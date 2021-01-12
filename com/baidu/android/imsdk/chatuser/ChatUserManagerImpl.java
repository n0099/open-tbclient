package com.baidu.android.imsdk.chatuser;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.LongSparseArray;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.Filter;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.account.IGetUidByUkListener;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatuser.db.ChatUserDBManager;
import com.baidu.android.imsdk.chatuser.db.IMUserManager;
import com.baidu.android.imsdk.chatuser.request.IMGetUserIdentityRequest;
import com.baidu.android.imsdk.chatuser.request.IMGetUserIpLocation;
import com.baidu.android.imsdk.chatuser.request.IMGetUsersStatusRequest;
import com.baidu.android.imsdk.chatuser.request.IMUserQueryRequest;
import com.baidu.android.imsdk.chatuser.request.IMUserSetRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.internal.MessageFactory;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.RequsetNetworkUtils;
import com.baidu.g.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class ChatUserManagerImpl {
    private static final String TAG = ChatUserManagerImpl.class.getSimpleName();
    private static Context mContext;
    private static volatile ChatUserManagerImpl mInstance;
    private LongSparseArray<ChatUser> mWaitSyncDisturbUKs = new LongSparseArray<>();
    Filter filter = new Filter() { // from class: com.baidu.android.imsdk.chatuser.ChatUserManagerImpl.1
        @Override // com.baidu.android.imsdk.Filter
        public void fileter(List<ChatMsg> list) {
            Iterator<ChatMsg> it = list.iterator();
            while (it.hasNext()) {
                ChatMsg next = it.next();
                long fromUser = next.getFromUser();
                if (fromUser == AccountManager.getUK(ChatUserManagerImpl.mContext)) {
                    fromUser = next.getContacter();
                }
                if (next.getCategory() == 0 && (Constants.PAFLAG & fromUser) == 0 && !ChatUserManagerImpl.this.isUserExist(fromUser)) {
                    it.remove();
                }
            }
        }
    };

    private ChatUserManagerImpl() {
        Class<?>[] clsArr = {IMGetUserIpLocation.class, IMGetUsersStatusRequest.class};
        int[] iArr = {91, 21};
        for (int i = 0; i < clsArr.length; i++) {
            MessageFactory.getInstance().addType(iArr[i], clsArr[i]);
        }
    }

    public static ChatUserManagerImpl getInstance(Context context) {
        if (mInstance == null) {
            synchronized (ChatUserManagerImpl.class) {
                if (mInstance == null) {
                    mContext = context.getApplicationContext();
                    mInstance = new ChatUserManagerImpl();
                }
            }
        }
        return mInstance;
    }

    public void getUKbyBuid(final long j, final IGetUkByBuidListener iGetUkByBuidListener) {
        long uKbyBuid = IMUserManager.getInstance(mContext).getUKbyBuid(j);
        if (uKbyBuid < 0) {
            getUserByBuid(j, 0, new IGetUserListener() { // from class: com.baidu.android.imsdk.chatuser.ChatUserManagerImpl.2
                @Override // com.baidu.android.imsdk.chatuser.IGetUserListener
                public void onGetUserResult(int i, long j2, ChatUser chatUser) {
                    if (iGetUkByBuidListener != null) {
                        if (chatUser != null) {
                            iGetUkByBuidListener.onFetchUk(i, j, chatUser.getUk());
                        } else {
                            iGetUkByBuidListener.onFetchUk(i, j, -1L);
                        }
                    }
                }
            });
        } else if (iGetUkByBuidListener != null) {
            iGetUkByBuidListener.onFetchUk(0, j, uKbyBuid);
        }
    }

    public void getUser(long j, int i, IGetUserListener iGetUserListener) {
        long uk = j <= 0 ? com.baidu.android.imsdk.utils.Utility.getUK(mContext) : j;
        String addListener = ListenerManager.getInstance().addListener(iGetUserListener);
        LogUtils.d(TAG, "getUser uid:" + uk);
        if (!com.baidu.android.imsdk.utils.Utility.isContacterCorrect(uk)) {
            onGetUserResult(mContext, i, addListener, 1005, uk);
        } else if (AccountManager.isLogin(mContext)) {
            if (IMUserManager.getInstance(mContext).isUserExist(uk)) {
                LogUtils.d(TAG, "isUserExist:" + uk);
                onGetUserResult(mContext, i, addListener, 0, uk);
                return;
            }
            LogUtils.d(TAG, "updateUserProfileByUks:" + uk);
            updateUserProfileByUks(new long[]{uk}, true, addListener);
        } else {
            LogUtils.d(TAG, "ACCOUNT_NOT_LOGIN:" + uk);
            onGetUserResult(mContext, i, addListener, 1000, uk);
        }
    }

    public void getUserByBuid(long j, int i, IGetUserListener iGetUserListener) {
        long buid = j <= 0 ? com.baidu.android.imsdk.utils.Utility.getBuid(mContext) : j;
        String addListener = ListenerManager.getInstance().addListener(iGetUserListener);
        if (!com.baidu.android.imsdk.utils.Utility.isContacterCorrect(buid)) {
            onGetUserResultByBuid(mContext, i, addListener, 1005, buid);
        } else if (AccountManager.isLogin(mContext)) {
            long uKbyBuid = IMUserManager.getInstance(mContext).getUKbyBuid(buid);
            if (uKbyBuid > -1 && IMUserManager.getInstance(mContext).isUserExist(uKbyBuid)) {
                onGetUserResultByBuid(mContext, i, addListener, 0, buid);
            } else {
                updateUserProfileByUks(new long[]{buid}, true, addListener);
            }
        } else {
            onGetUserResultByBuid(mContext, i, addListener, 1000, buid);
        }
    }

    public void onGetUserResultByBuid(Context context, int i, String str, int i2, long j) {
        IMListener removeListener = ListenerManager.getInstance().removeListener(str);
        if (removeListener != null && (removeListener instanceof IGetUserListener)) {
            IGetUserListener iGetUserListener = (IGetUserListener) removeListener;
            long uKbyBuid = IMUserManager.getInstance(mContext).getUKbyBuid(j);
            if (uKbyBuid > 0) {
                ChatUser chatUser = IMUserManager.getInstance(mContext).getChatUser(uKbyBuid);
                if (chatUser != null) {
                    LogUtils.d(TAG, "onGetUserResultByBuid: " + chatUser.getUserName());
                }
                iGetUserListener.onGetUserResult(i2, j, chatUser);
                return;
            }
            iGetUserListener.onGetUserResult(i2, j, null);
            return;
        }
        LogUtils.d(TAG, "onGetUserResultByBuid IGetUserListener is null!");
    }

    public void onGetUserResult(Context context, int i, String str, int i2, long j) {
        IMListener removeListener = ListenerManager.getInstance().removeListener(str);
        if (removeListener != null && (removeListener instanceof IGetUserListener)) {
            IGetUserListener iGetUserListener = (IGetUserListener) removeListener;
            ChatUser chatUser = IMUserManager.getInstance(mContext).getChatUser(j);
            LogUtils.d(TAG, "onGetUserResult :" + chatUser);
            if (chatUser != null) {
                LogUtils.d(TAG, "onGetUserResult: " + chatUser.getUserName());
            }
            iGetUserListener.onGetUserResult(i2, j, chatUser);
            return;
        }
        LogUtils.d(TAG, "onGetUserResult IGetUserListener is null!");
    }

    public void onGetUserResult(String str, ChatUser chatUser, int i, long j) {
        IMListener removeListener = ListenerManager.getInstance().removeListener(str);
        if (removeListener instanceof IGetUserListener) {
            IGetUserListener iGetUserListener = (IGetUserListener) removeListener;
            if (chatUser != null) {
                LogUtils.d(TAG, "onGetUserResult: " + chatUser.toString());
            }
            iGetUserListener.onGetUserResult(i, j, chatUser);
            return;
        }
        LogUtils.d(TAG, "onGetUserResult IGetUserListener is null!");
    }

    public ArrayList<ChatUser> getChatUser() {
        return ChatUserDBManager.getInstance(mContext).getChatUser();
    }

    public void updateUserProfileByUks(long[] jArr, boolean z, final String str) {
        AccountManagerImpl.getInstance(mContext).getUidByUk(jArr, new IGetUidByUkListener() { // from class: com.baidu.android.imsdk.chatuser.ChatUserManagerImpl.3
            @Override // com.baidu.android.imsdk.account.IGetUidByUkListener
            public void onGetUidByUkResult(int i, String str2, long[] jArr2, Map<Long, Long> map) {
                if (i != 0) {
                    if (!TextUtils.isEmpty(str)) {
                        ChatUserManagerImpl.this.onGetUserResult(ChatUserManagerImpl.mContext, 0, str, 1011, -1L);
                        return;
                    }
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<Long, Long> entry : map.entrySet()) {
                    if (entry.getValue().longValue() > 0) {
                        arrayList.add(entry.getValue());
                    }
                }
                LogUtils.d(ChatUserManagerImpl.TAG, "updateUserProfileByUks bduidList :" + arrayList.toString());
                ChatUserManagerImpl.this.updateUserIdentity(arrayList, new IGetUserIdentityListener() { // from class: com.baidu.android.imsdk.chatuser.ChatUserManagerImpl.3.1
                    @Override // com.baidu.android.imsdk.chatuser.IGetUserIdentityListener
                    public void onGetUserIdentityResult(int i2, List<ChatUser> list) {
                        if (i2 != 0 || list == null) {
                            LogUtils.i(ChatUserManagerImpl.TAG, "updateUserProfileByUks fail");
                            if (!TextUtils.isEmpty(str)) {
                                ChatUserManagerImpl.this.onGetUserResult(ChatUserManagerImpl.mContext, 0, str, 0, -1L);
                                return;
                            }
                            return;
                        }
                        if (!TextUtils.isEmpty(str)) {
                            ChatUserManagerImpl.this.onGetUserResult(str, list.get(0), 0, list.get(0).getUk());
                        }
                        for (ChatUser chatUser : list) {
                            ChatUserDBManager.getInstance(ChatUserManagerImpl.mContext).updateUser(chatUser);
                            ChatMessageDBManager.getInstance(ChatUserManagerImpl.mContext).updateSessionClass(chatUser);
                        }
                    }
                });
            }
        });
    }

    public void getUsersProfileBatchByBuid(final ArrayList<Long> arrayList, boolean z, IGetUsersProfileBatchListener iGetUsersProfileBatchListener) {
        final String addListener = ListenerManager.getInstance().addListener(iGetUsersProfileBatchListener);
        if (arrayList == null || arrayList.size() <= 0) {
            onGetUsersProfileBatchResult(addListener, 1005, Constants.ERROR_MSG_PARAMETER_ERROR, arrayList, null);
            return;
        }
        ArrayList<ChatUser> arrayList2 = new ArrayList<>();
        Iterator<Long> it = arrayList.iterator();
        while (it.hasNext()) {
            ChatUser chatUserByBuid = ChatUserDBManager.getInstance(mContext).getChatUserByBuid(it.next().longValue());
            if (chatUserByBuid != null) {
                arrayList2.add(chatUserByBuid);
            }
        }
        if (arrayList2.size() > 0 && arrayList2.size() >= arrayList.size()) {
            onGetUsersProfileBatchResult(addListener, 0, Constants.ERROR_MSG_SUCCESS, arrayList, arrayList2);
            return;
        }
        LogUtils.d(TAG, "getUsersProfileBatchByBuid buids :" + arrayList.toString());
        updateUserIdentity(arrayList, new IGetUserIdentityListener() { // from class: com.baidu.android.imsdk.chatuser.ChatUserManagerImpl.4
            @Override // com.baidu.android.imsdk.chatuser.IGetUserIdentityListener
            public void onGetUserIdentityResult(int i, List<ChatUser> list) {
                ChatUserManagerImpl.this.updateUserInfoToDB(i, list, addListener, arrayList);
            }
        });
    }

    public void getUsersProfileBatch(final ArrayList<Long> arrayList, IGetUsersProfileBatchListener iGetUsersProfileBatchListener) {
        final String addListener = ListenerManager.getInstance().addListener(iGetUsersProfileBatchListener);
        if (arrayList == null || arrayList.size() <= 0) {
            onGetUsersProfileBatchResult(addListener, 1005, Constants.ERROR_MSG_PARAMETER_ERROR, arrayList, null);
            return;
        }
        ArrayList<ChatUser> arrayList2 = new ArrayList<>();
        Iterator<Long> it = arrayList.iterator();
        while (it.hasNext()) {
            ChatUser chatUserByBuid = ChatUserDBManager.getInstance(mContext).getChatUserByBuid(it.next().longValue());
            if (chatUserByBuid != null) {
                arrayList2.add(chatUserByBuid);
            }
        }
        if (arrayList2.size() > 0) {
            onGetUsersProfileBatchResult(addListener, 0, Constants.ERROR_MSG_SUCCESS, arrayList, arrayList2);
            return;
        }
        LogUtils.d(TAG, "getUsersProfileBatch uks :" + arrayList.toString());
        updateUserIdentity(arrayList, new IGetUserIdentityListener() { // from class: com.baidu.android.imsdk.chatuser.ChatUserManagerImpl.5
            @Override // com.baidu.android.imsdk.chatuser.IGetUserIdentityListener
            public void onGetUserIdentityResult(int i, List<ChatUser> list) {
                ChatUserManagerImpl.this.updateUserInfoToDB(i, list, addListener, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUserInfoToDB(int i, List<ChatUser> list, String str, ArrayList<Long> arrayList) {
        if (i == 0) {
            onGetUsersProfileBatchResult(str, 0, Constants.ERROR_MSG_SUCCESS, arrayList, (ArrayList) list);
            for (ChatUser chatUser : list) {
                IMUserManager.getInstance(mContext).updateUser(chatUser);
                ChatMessageDBManager.getInstance(mContext).updateSessionClass(chatUser);
            }
            return;
        }
        onGetUsersProfileBatchResult(str, 1005, Constants.ERROR_MSG_PARAMETER_ERROR, arrayList, null);
    }

    public void getUsersStatus(ArrayList<Long> arrayList, IGetUserStatusListener iGetUserStatusListener) {
        String addListener = ListenerManager.getInstance().addListener(iGetUserStatusListener);
        if (arrayList == null || arrayList.size() < 1) {
            onGetUsersStatusResult(addListener, 1005, Constants.ERROR_MSG_PARAMETER_ERROR, null);
        } else if (!RequsetNetworkUtils.isConnected(mContext)) {
            onGetUsersStatusResult(addListener, 1001, Constants.ERROR_MSG_NETWORK_ERROR, null);
        } else if (AccountManager.isLogin(mContext) && !AccountManager.isCuidLogin(mContext)) {
            Intent creatMethodIntent = com.baidu.android.imsdk.utils.Utility.creatMethodIntent(mContext, 21);
            creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
            Bundle bundle = new Bundle();
            bundle.putSerializable(Constants.EXTRA_UIDS, arrayList);
            creatMethodIntent.putExtras(bundle);
            try {
                a.ao(mContext).e(mContext, creatMethodIntent);
            } catch (Exception e) {
                ListenerManager.getInstance().removeListener(addListener);
                onGetUsersStatusResult(addListener, 1003, Constants.ERROR_MSG_SERVICE_ERROR, null);
                LogUtils.e(TAG, "Exception ", e);
            }
        } else {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            onGetUsersStatusResult(addListener, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, null);
        }
    }

    public void onGetUsersProfileBatchResult(String str, int i, String str2, ArrayList<Long> arrayList, ArrayList<ChatUser> arrayList2) {
        LogUtils.d(TAG, "onGetUsersProfileBatchResult----errorCode: " + i);
        if (arrayList2 != null) {
            Iterator<ChatUser> it = arrayList2.iterator();
            while (it.hasNext()) {
                ChatUser next = it.next();
                LogUtils.d(TAG, "onGetUsersProfileBatchResult ChatUser: " + next.toString());
                String iconUrl = next.getIconUrl();
                if (!TextUtils.isEmpty(iconUrl)) {
                    next.setIconUrl(iconUrl.replace("http://himg", "https://himg"));
                }
                String tinyUrl = next.getTinyUrl();
                if (!TextUtils.isEmpty(tinyUrl)) {
                    next.setTinyUrl(tinyUrl.replace("http://himg", "https://himg"));
                }
            }
        }
        IMListener removeListener = ListenerManager.getInstance().removeListener(str);
        if (removeListener != null && (removeListener instanceof IGetUsersProfileBatchListener)) {
            ((IGetUsersProfileBatchListener) removeListener).onGetUsersProfileBatchResult(i, str2, arrayList, arrayList2);
        } else {
            LogUtils.d(TAG, "onGetUsersProfileBatchResult is null");
        }
    }

    public void onGetUsersStatusResult(String str, int i, String str2, ArrayList<UserStatus> arrayList) {
        LogUtils.d(TAG, "onGetUsersStatusResult----errorCode: " + i);
        IMListener removeListener = ListenerManager.getInstance().removeListener(str);
        if (removeListener != null && (removeListener instanceof IGetUserStatusListener)) {
            ((IGetUserStatusListener) removeListener).onGetUsersStatusResult(i, str2, arrayList);
        } else {
            LogUtils.d(TAG, "onGetUsersStatusResult is null");
        }
    }

    public boolean isUserExist(long j) {
        return IMUserManager.getInstance(mContext).isUserExist(j);
    }

    public void updateUserIdentity(List<Long> list, @NonNull IGetUserIdentityListener iGetUserIdentityListener) {
        if (list == null || list.size() <= 0) {
            iGetUserIdentityListener.onGetUserIdentityResult(1005, null);
            return;
        }
        LogUtils.d(TAG, "updateUserIdentity bduids :" + list.toString());
        int size = list.size() / 20;
        for (int i = 0; i < size; i++) {
            requestUserIdentity(list.subList(i * 20, (i + 1) * 20), iGetUserIdentityListener);
        }
        if (list.size() % 20 > 0) {
            requestUserIdentity(list.subList(size * 20, list.size()), iGetUserIdentityListener);
        }
    }

    private void requestUserIdentity(List<Long> list, IGetUserIdentityListener iGetUserIdentityListener) {
        IMGetUserIdentityRequest iMGetUserIdentityRequest = new IMGetUserIdentityRequest(mContext, list, iGetUserIdentityListener);
        HttpHelper.executor(mContext, iMGetUserIdentityRequest, iMGetUserIdentityRequest);
    }

    public void getUserIp(int i, ArrayList<Long> arrayList, IGetUserIpListener iGetUserIpListener) {
        LogUtils.d(TAG, "getUserIp----Start: " + arrayList);
        String addListener = ListenerManager.getInstance().addListener(iGetUserIpListener);
        if (arrayList == null || arrayList.size() == 0) {
            onGetUserIpResult(mContext, i, addListener, 1005, Constants.ERROR_MSG_PARAMETER_ERROR, arrayList, null);
        } else if (AccountManager.isLogin(mContext)) {
            Intent creatMethodIntent = com.baidu.android.imsdk.utils.Utility.creatMethodIntent(mContext, 91);
            creatMethodIntent.putExtra(Constants.EXTRA_LISTENER_ID, addListener);
            Bundle bundle = new Bundle();
            bundle.putSerializable(Constants.EXTRA_UIDS, arrayList);
            creatMethodIntent.putExtras(bundle);
            creatMethodIntent.putExtra(Constants.EXTRA_SAVE_TO_DB, i);
            try {
                a.ao(mContext).e(mContext, creatMethodIntent);
            } catch (Exception e) {
                ListenerManager.getInstance().removeListener(addListener);
                onGetUserIpResult(mContext, i, addListener, 1003, Constants.ERROR_MSG_SERVICE_ERROR, arrayList, null);
                LogUtils.e(TAG, "Exception ", e);
            }
        } else {
            LogUtils.d(TAG, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN);
            onGetUserIpResult(mContext, i, addListener, 1000, Constants.ERROR_MSG_ACCOUNT_NOT_LOGIN, arrayList, null);
        }
    }

    public void onGetUserIpResult(Context context, int i, String str, int i2, String str2, ArrayList<Long> arrayList, ArrayList<IpInfo> arrayList2) {
        IMListener removeListener = ListenerManager.getInstance().removeListener(str);
        if (removeListener != null && (removeListener instanceof IGetUserIpListener)) {
            ((IGetUserIpListener) removeListener).onGetUserIpResult(i2, str2, arrayList, arrayList2);
        } else {
            LogUtils.d(TAG, "onGetUserIpResult --errorCode:" + i2 + "---strMsg:" + str2 + "--listener:" + removeListener);
        }
    }

    public ChatUser getChatUserSync(long j) {
        ChatUser chatUser = ChatUserDBManager.getInstance(mContext).getChatUser(j);
        if (chatUser != null) {
            if (chatUser.getBuid() <= 0) {
                getUser(j, 1, null);
            }
            return syncUserDisturbExtra(chatUser);
        }
        return chatUser;
    }

    public void setUserPrivacy(long j, int i, int i2, IUserPrivacyListener iUserPrivacyListener) {
        IMUserSetRequest iMUserSetRequest = new IMUserSetRequest(mContext, ListenerManager.getInstance().addListener(iUserPrivacyListener), j != -2 ? IMUserManager.getInstance(mContext).getUKbyBuid(j) : -2L, AccountManager.getAppid(mContext), i, i2);
        HttpHelper.executor(mContext, iMUserSetRequest, iMUserSetRequest);
    }

    public void onSetPrivacyResult(String str, int i, String str2, long j, int i2, int i3) {
        IUserPrivacyListener iUserPrivacyListener = (IUserPrivacyListener) ListenerManager.getInstance().removeListener(str);
        if (iUserPrivacyListener != null) {
            if (i == 0) {
                if (j == -2) {
                    com.baidu.android.imsdk.utils.Utility.writeIntData(mContext, Constants.KEY_USER_SETTING_NOT_CONCERNED + AccountManager.getUK(mContext), i2);
                } else {
                    ChatUser chatUser = ChatUserDBManager.getInstance(mContext).getChatUser(j);
                    if (chatUser != null) {
                        if (i2 != -1) {
                            chatUser.setDisturb(i2);
                        }
                        if (i3 != -1) {
                            chatUser.setBlack(i3);
                        }
                        ChatUserDBManager.getInstance(mContext).updateUser(chatUser);
                    }
                }
            }
            iUserPrivacyListener.onResult(i, str2);
            return;
        }
        LogUtils.d(TAG, "IRetrieveServicesListener is null");
    }

    public void syncUsersAttr() {
        IMUserQueryRequest iMUserQueryRequest = new IMUserQueryRequest(mContext, AccountManager.getAppid(mContext));
        HttpHelper.executor(mContext, iMUserQueryRequest, iMUserQueryRequest);
    }

    public void getUnconcernedUserDisturb(IGetUnconcernedMsgListener iGetUnconcernedMsgListener) {
        IMUserQueryRequest iMUserQueryRequest = new IMUserQueryRequest(mContext, AccountManager.getAppid(mContext), ListenerManager.getInstance().addListener(iGetUnconcernedMsgListener));
        HttpHelper.executor(mContext, iMUserQueryRequest, iMUserQueryRequest);
    }

    private ChatUser syncUserDisturbExtra(ChatUser chatUser) {
        if (chatUser != null && this.mWaitSyncDisturbUKs.size() > 0 && this.mWaitSyncDisturbUKs.get(chatUser.getUk()) != null) {
            ChatUser chatUser2 = this.mWaitSyncDisturbUKs.get(chatUser.getUk());
            chatUser.setDisturb(chatUser2.getDisturb());
            chatUser.setBlack(chatUser2.getBlack());
            ChatUserDBManager.getInstance(mContext).updateUser(chatUser);
            this.mWaitSyncDisturbUKs.delete(chatUser.getUk());
            LogUtils.d(TAG, "onGetUsersProfileBatchResult add disturb and black value");
        }
        return chatUser;
    }

    public void onQueryResult(int i, String str, List<ChatUser> list, String str2) {
        IMListener removeListener;
        if (list != null) {
            for (ChatUser chatUser : list) {
                if (chatUser.getUk() == -2) {
                    com.baidu.android.imsdk.utils.Utility.writeIntData(mContext, Constants.KEY_USER_SETTING_NOT_CONCERNED + AccountManager.getUK(mContext), chatUser.getDisturb());
                } else {
                    ChatUser chatUser2 = ChatUserDBManager.getInstance(mContext).getChatUser(chatUser.getUk());
                    if (chatUser2 != null) {
                        chatUser2.setDisturb(chatUser.getDisturb());
                        chatUser2.setBlack(chatUser.getBlack());
                        ChatUserDBManager.getInstance(mContext).updateUser(chatUser2);
                        LogUtils.d(TAG, "user onQueryResult --->" + chatUser.toString());
                    } else {
                        this.mWaitSyncDisturbUKs.put(chatUser.getUk(), chatUser);
                        LogUtils.d(TAG, "wattting user onQueryResult --->" + chatUser.getUk());
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(str2) && (removeListener = ListenerManager.getInstance().removeListener(str2)) != null && (removeListener instanceof IGetUnconcernedMsgListener)) {
            LogUtils.d(TAG, "call back for IGetUnconcernedMsgListener error = " + i);
            ((IGetUnconcernedMsgListener) removeListener).onResult(i, com.baidu.android.imsdk.utils.Utility.readIntData(mContext, Constants.KEY_USER_SETTING_NOT_CONCERNED + AccountManager.getUK(mContext), 0));
        }
    }
}
