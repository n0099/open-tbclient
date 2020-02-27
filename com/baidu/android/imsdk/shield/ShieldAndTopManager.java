package com.baidu.android.imsdk.shield;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatuser.IStatusListener;
import com.baidu.android.imsdk.chatuser.db.ChatUserDBManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.shield.model.GetShieldAndTopResult;
import com.baidu.android.imsdk.shield.model.GetSubscriptionResult;
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
/* loaded from: classes3.dex */
public class ShieldAndTopManager {
    private static final String TAG = "ShieldAndTopManager";
    private static volatile ShieldAndTopManager mInstance;
    private Context mContext;
    private static int MSG_UPDATE_MAX_COUNT = 2;
    private static volatile int mMsgUpdateCount = 0;

    static /* synthetic */ int access$208() {
        int i = mMsgUpdateCount;
        mMsgUpdateCount = i + 1;
        return i;
    }

    private ShieldAndTopManager(Context context) {
        this.mContext = context.getApplicationContext();
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

    public void setShield(long j, int i, int i2, IStatusListener iStatusListener) {
        IMSetShieldAndTopRequest iMSetShieldAndTopRequest = new IMSetShieldAndTopRequest(this.mContext, ListenerManager.getInstance().addListener(iStatusListener), j, 1, i, i2);
        HttpHelper.executor(this.mContext, iMSetShieldAndTopRequest, iMSetShieldAndTopRequest);
    }

    public void onPaShieldResult(int i, String str, @NonNull final ChatSession chatSession, String str2) {
        if (i == 0) {
            TaskManager.getInstance(this.mContext).submitForLocalOperation(new Runnable() { // from class: com.baidu.android.imsdk.shield.ShieldAndTopManager.1
                @Override // java.lang.Runnable
                public void run() {
                    PaInfoDBManager.getInstance(ShieldAndTopManager.this.mContext).updateShield(chatSession, false);
                }
            });
        }
        IStatusListener iStatusListener = (IStatusListener) ListenerManager.getInstance().removeListener(str2);
        if (iStatusListener != null) {
            iStatusListener.onResult(i, str, chatSession.getShield(), chatSession.getContacter());
        }
    }

    public void onUserShieldResult(int i, String str, @NonNull final ChatSession chatSession, String str2) {
        if (i == 0) {
            TaskManager.getInstance(this.mContext).submitForLocalOperation(new Runnable() { // from class: com.baidu.android.imsdk.shield.ShieldAndTopManager.2
                @Override // java.lang.Runnable
                public void run() {
                    ChatUserDBManager.getInstance(ShieldAndTopManager.this.mContext).updateShield(chatSession, false);
                }
            });
        }
        IStatusListener iStatusListener = (IStatusListener) ListenerManager.getInstance().removeListener(str2);
        if (iStatusListener != null) {
            iStatusListener.onResult(i, str, chatSession.getShield(), chatSession.getContacter());
        }
    }

    public void getUserShieldListToShow(int i, IGetUserShieldListener iGetUserShieldListener) {
        String addListener = iGetUserShieldListener != null ? ListenerManager.getInstance().addListener(iGetUserShieldListener) : "";
        if (!Utility.isNeedSync(this.mContext, Constants.KEY_SYNC_MSG_TAB_TIME)) {
            onCallBack(0, "ok", getShieldListFromDB(i), addListener);
        } else {
            requestUserShieldList(i, addListener);
        }
    }

    private List<ChatSession> getShieldListFromDB(int i) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (i == 2) {
            arrayList2.add(1);
            arrayList2.add(5);
            arrayList2.add(17);
            arrayList2.add(19);
            arrayList2.add(26);
            arrayList.addAll(PaInfoDBManager.getInstance(this.mContext).getShieldUsers(arrayList2));
        } else {
            arrayList2.add(7);
            arrayList.addAll(PaInfoDBManager.getInstance(this.mContext).getShieldUsers(arrayList2));
            arrayList.addAll(ChatUserDBManager.getInstance(this.mContext).getShieldUsers());
        }
        return arrayList;
    }

    public void requestUserShieldList(int i, String str) {
        IMGetShieldAndTopListRequest iMGetShieldAndTopListRequest = new IMGetShieldAndTopListRequest(this.mContext, str, 1, i);
        HttpHelper.executor(this.mContext, iMGetShieldAndTopListRequest, iMGetShieldAndTopListRequest);
    }

    public void onNotifyShieldListResult(int i, String str, List<ChatSession> list, final String str2) {
        if (i != 0) {
            onCallBack(i, str, getShieldListFromDB(2), str2);
            return;
        }
        final ArrayList arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            onCallBack(i, str, arrayList, str2);
        } else if (i == 0) {
            PaInfoDBManager.getInstance(this.mContext).getShieldUserByPaId(list, !TextUtils.isEmpty(str2), new IGetUserShieldListener() { // from class: com.baidu.android.imsdk.shield.ShieldAndTopManager.3
                @Override // com.baidu.android.imsdk.shield.IGetUserShieldListener
                public void onResult(int i2, String str3, List<ChatSession> list2) {
                    if (i2 == 0) {
                        if (list2 != null) {
                            arrayList.addAll(list2);
                        }
                        ShieldAndTopManager.this.onCallBack(i2, str3, arrayList, str2);
                    }
                }
            });
        }
    }

    public void onMsgShieldListResult(final int i, final String str, @NonNull List<ChatSession> list, @NonNull List<ChatSession> list2, final String str2) {
        final ArrayList arrayList = new ArrayList();
        LogUtils.d(TAG, "onMsgShieldListResult errorCode :" + i + ", cUsers: " + list.size() + ", pa :" + list2.size());
        if (i != 0) {
            onCallBack(i, str, getShieldListFromDB(1), str2);
        } else if (list.size() == 0 && list2.size() == 0) {
            onCallBack(i, str, arrayList, str2);
        } else {
            if (list.size() > 0 && list2.size() > 0) {
                MSG_UPDATE_MAX_COUNT = 2;
            } else {
                MSG_UPDATE_MAX_COUNT = 1;
            }
            if (list.size() > 0) {
                ChatUserDBManager.getInstance(this.mContext).getShieldUserByUids(list, !TextUtils.isEmpty(str2), new IGetUserShieldListener() { // from class: com.baidu.android.imsdk.shield.ShieldAndTopManager.4
                    @Override // com.baidu.android.imsdk.shield.IGetUserShieldListener
                    public void onResult(int i2, String str3, List<ChatSession> list3) {
                        ShieldAndTopManager.access$208();
                        if (list3 != null && list3.size() > 0) {
                            arrayList.addAll(arrayList.size(), list3);
                        }
                        if (ShieldAndTopManager.mMsgUpdateCount >= ShieldAndTopManager.MSG_UPDATE_MAX_COUNT) {
                            ShieldAndTopManager.this.onCallBack(i, str, arrayList, str2);
                        }
                    }
                });
            }
            if (list2.size() > 0) {
                PaInfoDBManager.getInstance(this.mContext).getShieldUserByPaId(list2, TextUtils.isEmpty(str2) ? false : true, new IGetUserShieldListener() { // from class: com.baidu.android.imsdk.shield.ShieldAndTopManager.5
                    @Override // com.baidu.android.imsdk.shield.IGetUserShieldListener
                    public void onResult(int i2, String str3, List<ChatSession> list3) {
                        ShieldAndTopManager.access$208();
                        if (list3 != null && list3.size() > 0) {
                            arrayList.addAll(arrayList.size(), list3);
                        }
                        if (ShieldAndTopManager.mMsgUpdateCount >= ShieldAndTopManager.MSG_UPDATE_MAX_COUNT) {
                            ShieldAndTopManager.this.onCallBack(i, str, arrayList, str2);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCallBack(int i, String str, @NonNull List<ChatSession> list, String str2) {
        IGetUserShieldListener iGetUserShieldListener;
        if (!TextUtils.isEmpty(str2) && (iGetUserShieldListener = (IGetUserShieldListener) ListenerManager.getInstance().removeListener(str2)) != null) {
            LogUtils.d(TAG, "onMsgShieldListResult size :" + list.size() + ", errCode :" + i + ", errMsg :" + str);
            Collections.sort(list, new Comparator<ChatSession>() { // from class: com.baidu.android.imsdk.shield.ShieldAndTopManager.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                public int compare(ChatSession chatSession, ChatSession chatSession2) {
                    return Long.valueOf(chatSession.getShieldTime()).compareTo(Long.valueOf(chatSession2.getShieldTime()));
                }
            });
            iGetUserShieldListener.onResult(i, str, list);
        }
    }

    public void getOneShieldAndTopRequest(long j, IGetShieldAndTopListener iGetShieldAndTopListener) {
        IMGetOneShieldAndTopRequest iMGetOneShieldAndTopRequest = new IMGetOneShieldAndTopRequest(this.mContext, j, iGetShieldAndTopListener != null ? ListenerManager.getInstance().addListener(iGetShieldAndTopListener) : "");
        HttpHelper.executor(this.mContext, iMGetOneShieldAndTopRequest, iMGetOneShieldAndTopRequest);
    }

    public void onUserShieldAndTopResult(GetShieldAndTopResult getShieldAndTopResult, String str) {
        IGetShieldAndTopListener iGetShieldAndTopListener;
        if (getShieldAndTopResult != null && getShieldAndTopResult.getErrorCode() == 0) {
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
        if (!TextUtils.isEmpty(str) && (iGetShieldAndTopListener = (IGetShieldAndTopListener) ListenerManager.getInstance().removeListener(str)) != null) {
            iGetShieldAndTopListener.onResult(getShieldAndTopResult);
        }
    }

    public void setMarkTop(long j, int i, int i2, IStatusListener iStatusListener) {
        IMSetShieldAndTopRequest iMSetShieldAndTopRequest = new IMSetShieldAndTopRequest(this.mContext, ListenerManager.getInstance().addListener(iStatusListener), j, 2, i, i2);
        HttpHelper.executor(this.mContext, iMSetShieldAndTopRequest, iMSetShieldAndTopRequest);
    }

    public void onPaMarkTopResult(int i, String str, @NonNull final ChatSession chatSession, String str2) {
        IStatusListener iStatusListener = (IStatusListener) ListenerManager.getInstance().removeListener(str2);
        if (iStatusListener != null) {
            iStatusListener.onResult(i, str, chatSession.getMarkTop(), chatSession.getContacter());
        }
        if (i == 0) {
            TaskManager.getInstance(this.mContext).submitForLocalOperation(new Runnable() { // from class: com.baidu.android.imsdk.shield.ShieldAndTopManager.7
                @Override // java.lang.Runnable
                public void run() {
                    PaInfoDBManager.getInstance(ShieldAndTopManager.this.mContext).updateMarkTop(chatSession.getContacter(), chatSession.getMarkTop(), chatSession.getMarkTopTime());
                }
            });
        }
    }

    public void onUserMarkTopResult(int i, String str, @NonNull final ChatSession chatSession, String str2) {
        IStatusListener iStatusListener = (IStatusListener) ListenerManager.getInstance().removeListener(str2);
        if (iStatusListener != null) {
            iStatusListener.onResult(i, str, chatSession.getMarkTop(), chatSession.getContacter());
        }
        if (i == 0) {
            TaskManager.getInstance(this.mContext).submitForLocalOperation(new Runnable() { // from class: com.baidu.android.imsdk.shield.ShieldAndTopManager.8
                @Override // java.lang.Runnable
                public void run() {
                    ChatUserDBManager.getInstance(ShieldAndTopManager.this.mContext).updateMarkTop(chatSession.getContacter(), chatSession.getMarkTop(), chatSession.getMarkTopTime());
                }
            });
        }
    }

    public void requestMsgMarkTopList() {
        IMGetShieldAndTopListRequest iMGetShieldAndTopListRequest = new IMGetShieldAndTopListRequest(this.mContext, null, 2, 1);
        HttpHelper.executor(this.mContext, iMGetShieldAndTopListRequest, iMGetShieldAndTopListRequest);
    }

    public void onMsgMarkTopListResult(int i, String str, List<ChatSession> list, List<ChatSession> list2) {
        if (list != null) {
            if ((list.size() != 0 || (list2 != null && list2.size() != 0)) && i == 0) {
                if (list.size() > 0) {
                    ChatUserDBManager.getInstance(this.mContext).updateMarkTopList(list);
                }
                if (list2.size() > 0) {
                    PaInfoDBManager.getInstance(this.mContext).updateMarkTopList(list2);
                }
            }
        }
    }

    public void setSubscription(long j, List<Long> list, int i, String str, ISetSubscriptionListener iSetSubscriptionListener) {
        if (list != null && list.size() > 0) {
            IMSetSubscriptionRequest iMSetSubscriptionRequest = new IMSetSubscriptionRequest(this.mContext, i, j, list, str, iSetSubscriptionListener != null ? ListenerManager.getInstance().addListener(iSetSubscriptionListener) : "");
            HttpHelper.executor(this.mContext, iMSetSubscriptionRequest, iMSetSubscriptionRequest);
            return;
        }
        iSetSubscriptionListener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR);
    }

    public void getSubscription(long j, List<Long> list, String str, IGetSubscriptionListener iGetSubscriptionListener) {
        if (list != null && list.size() > 0) {
            IMGetSubscriptionRequest iMGetSubscriptionRequest = new IMGetSubscriptionRequest(this.mContext, j, list, str, iGetSubscriptionListener != null ? ListenerManager.getInstance().addListener(iGetSubscriptionListener) : "");
            HttpHelper.executor(this.mContext, iMGetSubscriptionRequest, iMGetSubscriptionRequest);
            return;
        }
        GetSubscriptionResult getSubscriptionResult = new GetSubscriptionResult();
        getSubscriptionResult.setErrorCode(1005);
        getSubscriptionResult.setErrorMsg(Constants.ERROR_MSG_PARAMETER_ERROR);
        iGetSubscriptionListener.onResult(getSubscriptionResult);
    }

    public void getServiceNotifyMenuStatus(long j, List<Long> list, String str, int i, IGetServiceNotifyMenuListener iGetServiceNotifyMenuListener) {
        IMServiceNotifyMenuMergeListener iMServiceNotifyMenuMergeListener = new IMServiceNotifyMenuMergeListener(i, iGetServiceNotifyMenuListener);
        switch (i) {
            case 0:
                getOneShieldAndTopRequest(j, iMServiceNotifyMenuMergeListener);
                return;
            case 1:
                getSubscription(j, list, str, iMServiceNotifyMenuMergeListener);
                return;
            default:
                getOneShieldAndTopRequest(j, iMServiceNotifyMenuMergeListener);
                getSubscription(j, list, str, iMServiceNotifyMenuMergeListener);
                return;
        }
    }
}
