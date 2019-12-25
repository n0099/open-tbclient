package com.baidu.android.imsdk.chatmessage.sync;

import android.content.Context;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.chatmessage.sync.SyncStrategy;
import com.baidu.android.imsdk.chatuser.ChatUserManagerImpl;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes2.dex */
public class SyncGroupMessageService {
    private static final int MAX_MAP_SIZE = 1;
    public static final String TAG = SyncGroupMessageService.class.getSimpleName();
    private static SyncGroupMessageService mInstance = null;
    private static Object synobject = new Object();
    private boolean mComplete = true;
    private Map<ChatObject, SyncGroupMessage> mGroupSyncMap = new ConcurrentHashMap();
    private ConcurrentLinkedQueue<DialogRecord> mDialogRecords = new ConcurrentLinkedQueue<>();
    private ConcurrentLinkedQueue<DialogRecord> mNewRecords = new ConcurrentLinkedQueue<>();

    public static SyncGroupMessageService getInstance() {
        synchronized (synobject) {
            if (mInstance == null) {
                mInstance = new SyncGroupMessageService();
            }
        }
        return mInstance;
    }

    private void put(DialogRecord dialogRecord) {
        boolean z;
        if (dialogRecord != null) {
            LogUtils.d(TAG, "put dialogRecord " + dialogRecord.getContacter());
            Iterator<DialogRecord> it = this.mDialogRecords.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                DialogRecord next = it.next();
                if (next.getCategory() == dialogRecord.getCategory() && next.getContacter() == dialogRecord.getContacter()) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                this.mDialogRecords.add(dialogRecord);
            }
        }
    }

    private void putNew(DialogRecord dialogRecord) {
        boolean z;
        if (dialogRecord != null) {
            LogUtils.d(TAG, "put new dialogRecord " + dialogRecord.getContacter());
            Iterator<DialogRecord> it = this.mNewRecords.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                DialogRecord next = it.next();
                if (next.getCategory() == dialogRecord.getCategory() && next.getContacter() == dialogRecord.getContacter()) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                this.mNewRecords.add(dialogRecord);
            }
        }
    }

    private DialogRecord getNew() {
        LogUtils.d(TAG, "get new dialogRecord ");
        return this.mNewRecords.peek();
    }

    private DialogRecord get() {
        return this.mDialogRecords.peek();
    }

    private void remove(DialogRecord dialogRecord, int i) {
        LogUtils.d(TAG, "BB remove dialogRecord " + dialogRecord + HanziToPinyin.Token.SEPARATOR + i);
        if (i == 0) {
            this.mDialogRecords.remove(dialogRecord);
        } else {
            this.mNewRecords.remove(dialogRecord);
        }
    }

    public void clear() {
        LogUtils.d(TAG, "BB clear");
        this.mDialogRecords.clear();
        if (this.mGroupSyncMap != null) {
            this.mGroupSyncMap.clear();
        }
    }

    public void execute(Context context, int i, long j, long j2, int i2) {
        LogUtils.d(TAG, "SYNCGROUPNEW group sync execute 1 \"to\":" + j + HanziToPinyin.Token.SEPARATOR + j2 + HanziToPinyin.Token.SEPARATOR + i2);
        synchronized (synobject) {
            DialogRecord dialogRecord = DialogRecordDBManager.getInstance(context).getDialogRecord(i, j);
            if (dialogRecord == null) {
                dialogRecord = new DialogRecord().setCategory(i).setContacter(j).setJumpToRecent(0).setMaxMsgid(0L).setUpdateTime(System.currentTimeMillis());
                long add = DialogRecordDBManager.getInstance(context).add(dialogRecord);
                dialogRecord.setJumpToRecent(1);
                LogUtils.d(TAG, "SYNCGROUPNEW " + dialogRecord.toString());
                if (add < 0) {
                    LogUtils.e(TAG, "SYNCGROUPNEW add dialogRecord err " + add);
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

    public void execute(final Context context, DialogRecord dialogRecord, final int i) {
        int i2;
        DialogRecord dialogRecord2;
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
            DialogRecord dialogRecord3 = get();
            if (dialogRecord3 == null) {
                LogUtils.d(TAG, "SYNCGROUP loging trigger dialog is null --1");
                DialogRecord dialogRecord4 = getNew();
                if (dialogRecord4 != null) {
                    LogUtils.d(TAG, "SYNCGROUPNEW to work...");
                    i = 2;
                    dialogRecord2 = dialogRecord4;
                    i2 = 1;
                } else {
                    i2 = 0;
                    dialogRecord2 = dialogRecord4;
                }
            } else {
                i2 = 0;
                i = 0;
                dialogRecord2 = dialogRecord3;
            }
            if (dialogRecord2 == null) {
                LogUtils.d(TAG, "SYNCGROUP loging trigger dialog is null --2");
                return;
            }
            final ChatObject chatObject = getChatObject(context, dialogRecord2);
            SyncGroupMessage syncGroupMessage = null;
            if (this.mGroupSyncMap.size() < 1) {
                syncGroupMessage = new SyncGroupMessage(context);
            }
            if (syncGroupMessage != null) {
                LogUtils.d(TAG, "find sync group message worker!");
                remove(dialogRecord2, i2);
                syncGroupMessage.setDialogRecord(dialogRecord2);
                syncGroupMessage.setCompleteListener(new SyncStrategy.CompleteListener() { // from class: com.baidu.android.imsdk.chatmessage.sync.SyncGroupMessageService.1
                    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy.CompleteListener
                    public void onComplete(DialogRecord dialogRecord5) {
                        LogUtils.d(SyncGroupMessageService.TAG, "SYNCGROUP  complete " + chatObject.getContacter() + " trigger " + i);
                        SyncGroupMessageService.this.mGroupSyncMap.remove(SyncGroupMessageService.this.getChatObject(context, dialogRecord5));
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

    public boolean isComplete() {
        return this.mComplete;
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

    public int getState(Context context, long j) {
        LogUtils.d(TAG, "getState --->" + j);
        return (DialogRecordDBManager.getInstance(context).getUnCompleteItemCount(j) == 0 || this.mComplete) ? 1 : 0;
    }
}
