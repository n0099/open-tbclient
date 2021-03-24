package com.baidu.android.imsdk.chatmessage.sync;

import android.content.Context;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.chatmessage.sync.SyncStrategy;
import com.baidu.android.imsdk.chatuser.ChatUserManagerImpl;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes2.dex */
public class SyncGroupMessageService {
    public static final int MAX_MAP_SIZE = 1;
    public static final String TAG = "SyncGroupMessageService";
    public static SyncGroupMessageService mInstance;
    public static Object synobject = new Object();
    public boolean mComplete = true;
    public Map<ChatObject, SyncGroupMessage> mGroupSyncMap = new ConcurrentHashMap();
    public ConcurrentLinkedQueue<DialogRecord> mDialogRecords = new ConcurrentLinkedQueue<>();
    public ConcurrentLinkedQueue<DialogRecord> mNewRecords = new ConcurrentLinkedQueue<>();

    private DialogRecord get() {
        return this.mDialogRecords.peek();
    }

    public static SyncGroupMessageService getInstance() {
        synchronized (synobject) {
            if (mInstance == null) {
                mInstance = new SyncGroupMessageService();
            }
        }
        return mInstance;
    }

    private DialogRecord getNew() {
        LogUtils.d(TAG, "get new dialogRecord ");
        return this.mNewRecords.peek();
    }

    private void put(DialogRecord dialogRecord) {
        if (dialogRecord == null) {
            return;
        }
        String str = TAG;
        LogUtils.d(str, "put dialogRecord " + dialogRecord.getContacter());
        boolean z = false;
        Iterator<DialogRecord> it = this.mDialogRecords.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DialogRecord next = it.next();
            if (next.getCategory() == dialogRecord.getCategory() && next.getContacter() == dialogRecord.getContacter()) {
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        this.mDialogRecords.add(dialogRecord);
    }

    private void putNew(DialogRecord dialogRecord) {
        if (dialogRecord == null) {
            return;
        }
        String str = TAG;
        LogUtils.d(str, "put new dialogRecord " + dialogRecord.getContacter());
        boolean z = false;
        Iterator<DialogRecord> it = this.mNewRecords.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DialogRecord next = it.next();
            if (next.getCategory() == dialogRecord.getCategory() && next.getContacter() == dialogRecord.getContacter()) {
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        this.mNewRecords.add(dialogRecord);
    }

    private void remove(DialogRecord dialogRecord, int i) {
        String str = TAG;
        LogUtils.d(str, "BB remove dialogRecord " + dialogRecord + " " + i);
        if (i == 0) {
            this.mDialogRecords.remove(dialogRecord);
        } else {
            this.mNewRecords.remove(dialogRecord);
        }
    }

    public void clear() {
        LogUtils.d(TAG, "BB clear");
        this.mDialogRecords.clear();
        Map<ChatObject, SyncGroupMessage> map = this.mGroupSyncMap;
        if (map != null) {
            map.clear();
        }
    }

    public void execute(Context context, int i, long j, long j2, int i2) {
        String str = TAG;
        LogUtils.d(str, "SYNCGROUPNEW group sync execute 1 \"to\":" + j + " " + j2 + " " + i2);
        synchronized (synobject) {
            DialogRecord dialogRecord = DialogRecordDBManager.getInstance(context).getDialogRecord(i, j);
            if (dialogRecord == null) {
                dialogRecord = new DialogRecord().setCategory(i).setContacter(j).setJumpToRecent(0).setMaxMsgid(0L).setUpdateTime(System.currentTimeMillis());
                long add = DialogRecordDBManager.getInstance(context).add(dialogRecord);
                dialogRecord.setJumpToRecent(1);
                String str2 = TAG;
                LogUtils.d(str2, "SYNCGROUPNEW " + dialogRecord.toString());
                if (add < 0) {
                    String str3 = TAG;
                    LogUtils.e(str3, "SYNCGROUPNEW add dialogRecord err " + add);
                    return;
                }
            } else if (dialogRecord.getMaxMsgid() <= 0) {
                dialogRecord.setJumpToRecent(1);
            } else {
                dialogRecord.setJumpToRecent(0);
            }
            dialogRecord.setState(0);
            putNew(dialogRecord);
            execute(context, dialogRecord, i2);
        }
    }

    public ChatObject getChatObject(Context context, DialogRecord dialogRecord) {
        return new ChatObject(context, dialogRecord.getCategory(), dialogRecord.getContacter());
    }

    public int getState(Context context) {
        int i = DialogRecordDBManager.getInstance(context).getUnCompleteItemCount() > 0 ? 0 : 1;
        if (i == 0 && this.mComplete) {
            return 1;
        }
        return i;
    }

    public boolean isComplete() {
        return this.mComplete;
    }

    public int getState(Context context, long j) {
        String str = TAG;
        LogUtils.d(str, "getState --->" + j);
        return (DialogRecordDBManager.getInstance(context).getUnCompleteItemCount(j) == 0 || this.mComplete) ? 1 : 0;
    }

    public void execute(final Context context, DialogRecord dialogRecord, final int i) {
        int i2 = 0;
        if (i == 0) {
            this.mComplete = false;
        }
        synchronized (synobject) {
            if (dialogRecord != null && i == 0) {
                if (dialogRecord.getMaxMsgid() == 0) {
                    dialogRecord.setJumpToRecent(1);
                }
                put(dialogRecord);
            }
            DialogRecord dialogRecord2 = get();
            if (dialogRecord2 == null) {
                LogUtils.d(TAG, "SYNCGROUP loging trigger dialog is null --1");
                dialogRecord2 = getNew();
                if (dialogRecord2 != null) {
                    LogUtils.d(TAG, "SYNCGROUPNEW to work...");
                    i = 2;
                    i2 = 1;
                }
            } else {
                i = 0;
            }
            if (dialogRecord2 == null) {
                LogUtils.d(TAG, "SYNCGROUP loging trigger dialog is null --2");
                return;
            }
            final ChatObject chatObject = getChatObject(context, dialogRecord2);
            SyncGroupMessage syncGroupMessage = this.mGroupSyncMap.size() < 1 ? new SyncGroupMessage(context) : null;
            if (syncGroupMessage != null) {
                LogUtils.d(TAG, "find sync group message worker!");
                remove(dialogRecord2, i2);
                syncGroupMessage.setDialogRecord(dialogRecord2);
                syncGroupMessage.setCompleteListener(new SyncStrategy.CompleteListener() { // from class: com.baidu.android.imsdk.chatmessage.sync.SyncGroupMessageService.1
                    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy.CompleteListener
                    public void onComplete(DialogRecord dialogRecord3) {
                        String str = SyncGroupMessageService.TAG;
                        LogUtils.d(str, "SYNCGROUP  complete " + chatObject.getContacter() + " trigger " + i);
                        SyncGroupMessageService.this.mGroupSyncMap.remove(SyncGroupMessageService.this.getChatObject(context, dialogRecord3));
                        if (SyncGroupMessageService.this.mDialogRecords.isEmpty() && i == 0) {
                            LogUtils.d(SyncGroupMessageService.TAG, "all SYNCGROUP complete ");
                            ChatUserManagerImpl.getInstance(context).syncUsersAttr();
                            SyncGroupMessageService.this.mComplete = true;
                        }
                        SyncGroupMessageService.this.execute(context, null, -1);
                    }
                });
                syncGroupMessage.start(i);
                this.mGroupSyncMap.put(chatObject, syncGroupMessage);
            }
        }
    }
}
