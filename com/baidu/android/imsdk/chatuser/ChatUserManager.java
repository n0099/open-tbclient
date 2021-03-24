package com.baidu.android.imsdk.chatuser;

import android.content.Context;
import com.baidu.android.imsdk.internal.BaseManager;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ChatUserManager extends BaseManager {
    @Deprecated
    public static ArrayList<ChatUser> getChatUser(Context context) {
        if (BaseManager.isNullContext(context)) {
            return null;
        }
        return ChatUserManagerImpl.getInstance(context).getChatUser();
    }

    public static ChatUser getChatUserSync(Context context, long j) {
        if (BaseManager.isNullContext(context)) {
            return null;
        }
        return ChatUserManagerImpl.getInstance(context).getChatUserSync(j);
    }

    public static void getUKbyBuid(Context context, long j, IGetUkByBuidListener iGetUkByBuidListener) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        ChatUserManagerImpl.getInstance(context).getUKbyBuid(j, iGetUkByBuidListener);
    }

    public static void getUnconcernedUserDisturb(Context context, IGetUnconcernedMsgListener iGetUnconcernedMsgListener) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        ChatUserManagerImpl.getInstance(context).getUnconcernedUserDisturb(iGetUnconcernedMsgListener);
    }

    public static void getUser(Context context, long j, IGetUserListener iGetUserListener) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        ChatUserManagerImpl.getInstance(context).getUser(j, 0, iGetUserListener);
    }

    public static void getUserByBuid(Context context, long j, IGetUserListener iGetUserListener) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        ChatUserManagerImpl.getInstance(context).getUserByBuid(j, 0, iGetUserListener);
    }

    public static void getUsersProfileBatch(Context context, ArrayList<Long> arrayList, IGetUsersProfileBatchListener iGetUsersProfileBatchListener) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        ChatUserManagerImpl.getInstance(context).getUsersProfileBatch(arrayList, iGetUsersProfileBatchListener);
    }

    public static void getUsersProfiles(Context context, ArrayList<Long> arrayList, boolean z, IGetUsersProfileBatchListener iGetUsersProfileBatchListener) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        ChatUserManagerImpl.getInstance(context).getUsersProfileBatchByBuid(arrayList, z, iGetUsersProfileBatchListener);
    }

    public static void getUsersStatus(Context context, ArrayList<Long> arrayList, IGetUserStatusListener iGetUserStatusListener) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        ChatUserManagerImpl.getInstance(context).getUsersStatus(arrayList, iGetUserStatusListener);
    }

    public static void init(Context context) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        ChatUserManagerImpl.getInstance(context);
    }

    @Deprecated
    public static boolean isUserExist(Context context, long j) {
        if (!BaseManager.isNullContext(context) && 0 <= j) {
            return ChatUserManagerImpl.getInstance(context).isUserExist(j);
        }
        return false;
    }

    public static void setUserBlack(Context context, long j, int i, IUserPrivacyListener iUserPrivacyListener) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        ChatUserManagerImpl.getInstance(context).setUserPrivacy(j, -1, i, iUserPrivacyListener);
    }

    public static void setUserDisturb(Context context, long j, int i, IUserPrivacyListener iUserPrivacyListener) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        ChatUserManagerImpl.getInstance(context).setUserPrivacy(j, i, -1, iUserPrivacyListener);
    }

    public static void syncUsersProfileBatch(Context context) {
        if (BaseManager.isNullContext(context)) {
            return;
        }
        ChatUserManagerImpl.getInstance(context).syncUsersAttr();
    }
}
