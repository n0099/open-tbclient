package com.baidu.android.imsdk.shield;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatuser.IStatusListener;
import com.baidu.android.imsdk.chatuser.db.ChatUserDBManager;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.shield.model.GetShieldAndTopResult;
import com.baidu.android.imsdk.shield.model.GetSubscriptionResult;
import com.baidu.android.imsdk.shield.request.IMForbidRequest;
import com.baidu.android.imsdk.shield.request.IMGetOneShieldAndTopRequest;
import com.baidu.android.imsdk.shield.request.IMGetShieldAndTopListRequest;
import com.baidu.android.imsdk.shield.request.IMGetSubscriptionRequest;
import com.baidu.android.imsdk.shield.request.IMSetShieldAndTopRequest;
import com.baidu.android.imsdk.shield.request.IMSetSubscriptionRequest;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes.dex */
public class ShieldAndTopManager {
    public static int MSG_UPDATE_MAX_COUNT = 2;
    public static final String TAG = "ShieldAndTopManager";
    public static volatile ShieldAndTopManager mInstance;
    public static volatile int mMsgUpdateCount;
    public Context mContext;

    public ShieldAndTopManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static /* synthetic */ int access$208() {
        int i2 = mMsgUpdateCount;
        mMsgUpdateCount = i2 + 1;
        return i2;
    }

    public static ShieldAndTopManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (ShieldAndTopManager.class) {
                if (mInstance == null) {
                    mInstance = new ShieldAndTopManager(context);
                }
            }
        }
        return mInstance;
    }

    private List<ChatSession> getShieldListFromDB(int i2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (i2 == 2) {
            arrayList2.add(1);
            arrayList2.add(5);
            arrayList2.add(17);
            arrayList2.add(19);
            arrayList2.add(29);
            arrayList2.add(26);
            for (int i3 = 32; i3 <= 56; i3++) {
                arrayList2.add(Integer.valueOf(i3));
            }
            arrayList.addAll(PaInfoDBManager.getInstance(this.mContext).getShieldUsers(arrayList2));
        } else {
            arrayList2.add(7);
            arrayList.addAll(PaInfoDBManager.getInstance(this.mContext).getShieldUsers(arrayList2));
            arrayList.addAll(ChatUserDBManager.getInstance(this.mContext).getShieldUsers());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCallBack(int i2, String str, @NonNull List<ChatSession> list, String str2) {
        IGetUserShieldListener iGetUserShieldListener;
        if (TextUtils.isEmpty(str2) || (iGetUserShieldListener = (IGetUserShieldListener) ListenerManager.getInstance().removeListener(str2)) == null) {
            return;
        }
        LogUtils.d(TAG, "onMsgShieldListResult size :" + list.size() + ", errCode :" + i2 + ", errMsg :" + str);
        Collections.sort(list, new Comparator<ChatSession>() { // from class: com.baidu.android.imsdk.shield.ShieldAndTopManager.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(ChatSession chatSession, ChatSession chatSession2) {
                return Long.valueOf(chatSession.getShieldTime()).compareTo(Long.valueOf(chatSession2.getShieldTime()));
            }
        });
        iGetUserShieldListener.onResult(i2, str, list);
    }

    public void getGroupAndStrangerDisturbList(IGetDisturbListListener iGetDisturbListListener) {
        requestSubbusinessContacterList(1, 3, iGetDisturbListListener != null ? ListenerManager.getInstance().addListener(iGetDisturbListListener) : "");
    }

    public void getOneShieldAndTopRequest(long j, IGetShieldAndTopListener iGetShieldAndTopListener) {
        IMGetOneShieldAndTopRequest iMGetOneShieldAndTopRequest = new IMGetOneShieldAndTopRequest(this.mContext, j, iGetShieldAndTopListener != null ? ListenerManager.getInstance().addListener(iGetShieldAndTopListener) : "");
        HttpHelper.executor(this.mContext, iMGetOneShieldAndTopRequest, iMGetOneShieldAndTopRequest);
    }

    public void getServiceNotifyMenuStatus(long j, List<Long> list, List<String> list2, String str, int i2, IGetServiceNotifyMenuListener iGetServiceNotifyMenuListener) {
        IMServiceNotifyMenuMergeListener iMServiceNotifyMenuMergeListener = new IMServiceNotifyMenuMergeListener(i2, iGetServiceNotifyMenuListener);
        if (i2 == 0) {
            getOneShieldAndTopRequest(j, iMServiceNotifyMenuMergeListener);
        } else if (i2 != 1) {
            getOneShieldAndTopRequest(j, iMServiceNotifyMenuMergeListener);
            getSubscription(j, list, list2, str, iMServiceNotifyMenuMergeListener);
        } else {
            getSubscription(j, list, list2, str, iMServiceNotifyMenuMergeListener);
        }
    }

    public void getSingleContacterSetting(long j, int i2, IGetShieldAndTopListener iGetShieldAndTopListener) {
        IMGetOneShieldAndTopRequest iMGetOneShieldAndTopRequest = new IMGetOneShieldAndTopRequest(this.mContext, j, i2, iGetShieldAndTopListener != null ? ListenerManager.getInstance().addListener(iGetShieldAndTopListener) : "");
        HttpHelper.executor(this.mContext, iMGetOneShieldAndTopRequest, iMGetOneShieldAndTopRequest);
    }

    public void getSubscription(long j, List<Long> list, List<String> list2, String str, IGetSubscriptionListener iGetSubscriptionListener) {
        if ((list != null && list.size() > 0) || (list2 != null && list2.size() > 0)) {
            IMGetSubscriptionRequest iMGetSubscriptionRequest = new IMGetSubscriptionRequest(this.mContext, j, list, list2, str, iGetSubscriptionListener != null ? ListenerManager.getInstance().addListener(iGetSubscriptionListener) : "");
            HttpHelper.executor(this.mContext, iMGetSubscriptionRequest, iMGetSubscriptionRequest);
            return;
        }
        GetSubscriptionResult getSubscriptionResult = new GetSubscriptionResult();
        getSubscriptionResult.setErrorCode(1005);
        getSubscriptionResult.setErrorMsg(Constants.ERROR_MSG_PARAMETER_ERROR);
        iGetSubscriptionListener.onResult(getSubscriptionResult);
    }

    public void getUserShieldListToShow(int i2, IGetUserShieldListener iGetUserShieldListener) {
        String addListener = iGetUserShieldListener != null ? ListenerManager.getInstance().addListener(iGetUserShieldListener) : "";
        if (!Utility.isNeedSync(this.mContext, Constants.KEY_SYNC_MSG_TAB_TIME)) {
            onCallBack(0, "ok", getShieldListFromDB(i2), addListener);
        } else {
            requestSubbusinessContacterList(i2, 1, addListener);
        }
    }

    public void onForbidResult(int i2, String str, boolean z, String str2, String str3) {
        ISetForbidListener iSetForbidListener;
        if (TextUtils.isEmpty(str3) || (iSetForbidListener = (ISetForbidListener) ListenerManager.getInstance().removeListener(str3)) == null) {
            return;
        }
        iSetForbidListener.onResult(i2, str, z, str2);
    }

    public void onGroupMarkTopResult(int i2, String str, @NonNull ChatSession chatSession, String str2) {
        if (i2 == 0) {
            GroupInfoDAOImpl.updateGroupMarkTop(this.mContext, chatSession.getContacter(), chatSession.getMarkTop(), chatSession.getMarkTopTime());
        }
        IStatusListener iStatusListener = (IStatusListener) ListenerManager.getInstance().removeListener(str2);
        if (iStatusListener != null) {
            iStatusListener.onResult(i2, str, chatSession.getMarkTop(), chatSession.getContacter());
        }
    }

    public void onMsgMarkTopListResult(int i2, String str, List<ChatSession> list, List<ChatSession> list2, List<ChatSession> list3) {
        if (list != null) {
            if (!(list.size() == 0 && ((list2 == null || list2.size() == 0) && (list3 == null || list3.size() == 0))) && i2 == 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("marktop", (Integer) 0);
                ChatMessageDBManager.getInstance(this.mContext).updateChatSession("marktop=?", new String[]{String.valueOf(1)}, contentValues);
                ChatUserDBManager.getInstance(this.mContext).updateMarkTopList(list);
                PaInfoDBManager.getInstance(this.mContext).updateMarkTopList(list2);
                GroupInfoDAOImpl.updateGroupListMarkTop(this.mContext, list3);
            }
        }
    }

    public void onMsgShieldListResult(final int i2, final String str, @NonNull List<ChatSession> list, @NonNull List<ChatSession> list2, final String str2) {
        final ArrayList arrayList = new ArrayList();
        LogUtils.d(TAG, "onMsgShieldListResult errorCode :" + i2 + ", cUsers: " + list.size() + ", pa :" + list2.size());
        if (i2 != 0) {
            onCallBack(i2, str, getShieldListFromDB(1), str2);
        } else if (list.size() == 0 && list2.size() == 0) {
            onCallBack(i2, str, arrayList, str2);
        } else {
            if (list.size() > 0 && list2.size() > 0) {
                MSG_UPDATE_MAX_COUNT = 2;
            } else {
                MSG_UPDATE_MAX_COUNT = 1;
            }
            if (list.size() > 0) {
                ChatUserDBManager.getInstance(this.mContext).getShieldUserByUids(list, !TextUtils.isEmpty(str2), new IGetUserShieldListener() { // from class: com.baidu.android.imsdk.shield.ShieldAndTopManager.4
                    @Override // com.baidu.android.imsdk.shield.IGetUserShieldListener
                    public void onResult(int i3, String str3, List<ChatSession> list3) {
                        ShieldAndTopManager.access$208();
                        if (list3 != null && list3.size() > 0) {
                            List list4 = arrayList;
                            list4.addAll(list4.size(), list3);
                        }
                        if (ShieldAndTopManager.mMsgUpdateCount >= ShieldAndTopManager.MSG_UPDATE_MAX_COUNT) {
                            ShieldAndTopManager.this.onCallBack(i2, str, arrayList, str2);
                        }
                    }
                });
            }
            if (list2.size() > 0) {
                PaInfoDBManager.getInstance(this.mContext).getShieldUserByPaId(list2, true ^ TextUtils.isEmpty(str2), new IGetUserShieldListener() { // from class: com.baidu.android.imsdk.shield.ShieldAndTopManager.5
                    @Override // com.baidu.android.imsdk.shield.IGetUserShieldListener
                    public void onResult(int i3, String str3, List<ChatSession> list3) {
                        ShieldAndTopManager.access$208();
                        if (list3 != null && list3.size() > 0) {
                            List list4 = arrayList;
                            list4.addAll(list4.size(), list3);
                        }
                        if (ShieldAndTopManager.mMsgUpdateCount >= ShieldAndTopManager.MSG_UPDATE_MAX_COUNT) {
                            ShieldAndTopManager.this.onCallBack(i2, str, arrayList, str2);
                        }
                    }
                });
            }
        }
    }

    public void onNotifyShieldListResult(int i2, String str, List<ChatSession> list, final String str2) {
        if (i2 != 0) {
            onCallBack(i2, str, getShieldListFromDB(2), str2);
            return;
        }
        final ArrayList arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            onCallBack(i2, str, arrayList, str2);
        } else if (i2 == 0) {
            PaInfoDBManager.getInstance(this.mContext).getShieldUserByPaId(list, !TextUtils.isEmpty(str2), new IGetUserShieldListener() { // from class: com.baidu.android.imsdk.shield.ShieldAndTopManager.3
                @Override // com.baidu.android.imsdk.shield.IGetUserShieldListener
                public void onResult(int i3, String str3, List<ChatSession> list2) {
                    if (i3 == 0) {
                        if (list2 != null) {
                            arrayList.addAll(list2);
                        }
                        ShieldAndTopManager.this.onCallBack(i3, str3, arrayList, str2);
                    }
                }
            });
        }
    }

    public void onPaMarkTopResult(int i2, String str, @NonNull final ChatSession chatSession, String str2) {
        IStatusListener iStatusListener = (IStatusListener) ListenerManager.getInstance().removeListener(str2);
        if (iStatusListener != null) {
            iStatusListener.onResult(i2, str, chatSession.getMarkTop(), chatSession.getContacter());
        }
        if (i2 == 0) {
            TaskManager.getInstance(this.mContext).submitForLocalOperation(new Runnable() { // from class: com.baidu.android.imsdk.shield.ShieldAndTopManager.7
                @Override // java.lang.Runnable
                public void run() {
                    PaInfoDBManager.getInstance(ShieldAndTopManager.this.mContext).updateMarkTop(chatSession.getContacter(), chatSession.getMarkTop(), chatSession.getMarkTopTime());
                }
            });
        }
    }

    public void onPaShieldResult(int i2, String str, @NonNull final ChatSession chatSession, String str2) {
        if (i2 == 0) {
            TaskManager.getInstance(this.mContext).submitForLocalOperation(new Runnable() { // from class: com.baidu.android.imsdk.shield.ShieldAndTopManager.1
                @Override // java.lang.Runnable
                public void run() {
                    PaInfoDBManager.getInstance(ShieldAndTopManager.this.mContext).updateShield(chatSession, false);
                }
            });
        }
        IStatusListener iStatusListener = (IStatusListener) ListenerManager.getInstance().removeListener(str2);
        if (iStatusListener != null) {
            iStatusListener.onResult(i2, str, chatSession.getShield(), chatSession.getContacter());
        }
    }

    public void onUserMarkTopResult(int i2, String str, @NonNull final ChatSession chatSession, String str2) {
        IStatusListener iStatusListener = (IStatusListener) ListenerManager.getInstance().removeListener(str2);
        if (iStatusListener != null) {
            iStatusListener.onResult(i2, str, chatSession.getMarkTop(), chatSession.getContacter());
        }
        if (i2 == 0) {
            TaskManager.getInstance(this.mContext).submitForLocalOperation(new Runnable() { // from class: com.baidu.android.imsdk.shield.ShieldAndTopManager.8
                @Override // java.lang.Runnable
                public void run() {
                    ChatUserDBManager.getInstance(ShieldAndTopManager.this.mContext).updateMarkTop(chatSession.getContacter(), chatSession.getMarkTop(), chatSession.getMarkTopTime());
                }
            });
        }
    }

    public void onUserShieldAndTopResult(GetShieldAndTopResult getShieldAndTopResult, String str) {
        IGetShieldAndTopListener iGetShieldAndTopListener;
        if (getShieldAndTopResult != null && getShieldAndTopResult.getChatType() != 3 && getShieldAndTopResult.getErrorCode() == 0) {
            ChatSession chatSession = new ChatSession();
            chatSession.setContacter(getShieldAndTopResult.getContacter());
            chatSession.setShield(getShieldAndTopResult.getShield());
            chatSession.setShieldTime(getShieldAndTopResult.getShieldTime());
            chatSession.setMarkTop(getShieldAndTopResult.getMarkTop());
            chatSession.setMarkTopTime(getShieldAndTopResult.getMarkTopTime());
            if ((chatSession.getContacter() & Constants.PAFLAG) == 0) {
                ChatUserDBManager.getInstance(this.mContext).updateShield(chatSession, true);
            } else {
                PaInfoDBManager.getInstance(this.mContext).updateShield(chatSession, true);
            }
        }
        if (TextUtils.isEmpty(str) || (iGetShieldAndTopListener = (IGetShieldAndTopListener) ListenerManager.getInstance().removeListener(str)) == null) {
            return;
        }
        iGetShieldAndTopListener.onResult(getShieldAndTopResult);
    }

    public void onUserShieldResult(int i2, String str, @NonNull final ChatSession chatSession, String str2) {
        if (i2 == 0) {
            TaskManager.getInstance(this.mContext).submitForLocalOperation(new Runnable() { // from class: com.baidu.android.imsdk.shield.ShieldAndTopManager.2
                @Override // java.lang.Runnable
                public void run() {
                    ChatUserDBManager.getInstance(ShieldAndTopManager.this.mContext).updateShield(chatSession, false);
                }
            });
        }
        IStatusListener iStatusListener = (IStatusListener) ListenerManager.getInstance().removeListener(str2);
        if (iStatusListener != null) {
            iStatusListener.onResult(i2, str, chatSession.getShield(), chatSession.getContacter());
        }
    }

    public void requestDisturbAndRemind(long j, int i2, int i3, int i4, IStatusListener iStatusListener) {
        IMSetShieldAndTopRequest iMSetShieldAndTopRequest = new IMSetShieldAndTopRequest(this.mContext, ListenerManager.getInstance().addListener(iStatusListener), j, i2, i3, i4);
        HttpHelper.executor(this.mContext, iMSetShieldAndTopRequest, iMSetShieldAndTopRequest);
    }

    public void requestMsgMarkTopList() {
        IMGetShieldAndTopListRequest iMGetShieldAndTopListRequest = new IMGetShieldAndTopListRequest(this.mContext, null, 2, 1);
        HttpHelper.executor(this.mContext, iMGetShieldAndTopListRequest, iMGetShieldAndTopListRequest);
    }

    public void requestSubbusinessContacterList(int i2, int i3, String str) {
        IMGetShieldAndTopListRequest iMGetShieldAndTopListRequest = new IMGetShieldAndTopListRequest(this.mContext, str, i3, i2);
        HttpHelper.executor(this.mContext, iMGetShieldAndTopListRequest, iMGetShieldAndTopListRequest);
    }

    public void setForbid(final long j, final long j2, final int i2, final ISetForbidListener iSetForbidListener) {
        Context context = this.mContext;
        if (context == null) {
            iSetForbidListener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, true, "");
        } else {
            TaskManager.getInstance(context).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.shield.ShieldAndTopManager.9
                @Override // java.lang.Runnable
                public void run() {
                    String addListener = iSetForbidListener != null ? ListenerManager.getInstance().addListener(iSetForbidListener) : "";
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(0);
                    arrayList.add(1);
                    arrayList.add(2);
                    arrayList.add(8);
                    IMForbidRequest iMForbidRequest = new IMForbidRequest(ShieldAndTopManager.this.mContext, j, j2, i2, ChatMessageDBManager.getInstance(ShieldAndTopManager.this.mContext).fetchMsgsByMsgTypes(new ChatObject(ShieldAndTopManager.this.mContext, i2, j), 0L, 5L, arrayList), addListener);
                    HttpHelper.executor(ShieldAndTopManager.this.mContext, iMForbidRequest, iMForbidRequest);
                }
            });
        }
    }

    public void setMarkTop(long j, int i2, int i3, IStatusListener iStatusListener) {
        IMSetShieldAndTopRequest iMSetShieldAndTopRequest = new IMSetShieldAndTopRequest(this.mContext, ListenerManager.getInstance().addListener(iStatusListener), j, 2, i2, i3);
        HttpHelper.executor(this.mContext, iMSetShieldAndTopRequest, iMSetShieldAndTopRequest);
    }

    public void setShield(long j, int i2, int i3, IStatusListener iStatusListener) {
        IMSetShieldAndTopRequest iMSetShieldAndTopRequest = new IMSetShieldAndTopRequest(this.mContext, ListenerManager.getInstance().addListener(iStatusListener), j, 1, i2, i3);
        HttpHelper.executor(this.mContext, iMSetShieldAndTopRequest, iMSetShieldAndTopRequest);
    }

    public void setSubscription(long j, List<Long> list, List<String> list2, int i2, String str, ISetSubscriptionListener iSetSubscriptionListener) {
        if ((list != null && list.size() > 0) || (list2 != null && list2.size() > 0)) {
            IMSetSubscriptionRequest iMSetSubscriptionRequest = new IMSetSubscriptionRequest(this.mContext, i2, j, list, list2, str, iSetSubscriptionListener != null ? ListenerManager.getInstance().addListener(iSetSubscriptionListener) : "");
            HttpHelper.executor(this.mContext, iMSetSubscriptionRequest, iMSetSubscriptionRequest);
            return;
        }
        iSetSubscriptionListener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR);
    }
}
