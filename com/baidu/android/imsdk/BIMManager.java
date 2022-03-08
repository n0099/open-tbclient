package com.baidu.android.imsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import c.a.u.a.b.a;
import c.a.u.a.h.c;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.account.IConnectListener;
import com.baidu.android.imsdk.account.IGetTokenByCuidListener;
import com.baidu.android.imsdk.account.ILoginListener;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.box.IMBoxManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.IChatSessionChangeListener;
import com.baidu.android.imsdk.chatmessage.IFetchMessageListener;
import com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener;
import com.baidu.android.imsdk.chatmessage.IGenBosObjectUrlListener;
import com.baidu.android.imsdk.chatmessage.IGetNewMsgCountListener;
import com.baidu.android.imsdk.chatmessage.IGetSessionListener;
import com.baidu.android.imsdk.chatmessage.IMediaChatMsgChangedListener;
import com.baidu.android.imsdk.chatmessage.IMediaContactorSettingListener;
import com.baidu.android.imsdk.chatmessage.IMediaDeleteChatMsgListener;
import com.baidu.android.imsdk.chatmessage.IMediaDeleteChatSessionListener;
import com.baidu.android.imsdk.chatmessage.IMediaFetchChatMsgsListener;
import com.baidu.android.imsdk.chatmessage.IMediaGetChatSessionListener;
import com.baidu.android.imsdk.chatmessage.IMediaGetContactorPauidListener;
import com.baidu.android.imsdk.chatmessage.IMediaSendChatMsgListener;
import com.baidu.android.imsdk.chatmessage.IMediaSetSessionReadListener;
import com.baidu.android.imsdk.chatmessage.IMessageReceiveListener;
import com.baidu.android.imsdk.chatmessage.ISendMessageListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.ChatUserManager;
import com.baidu.android.imsdk.chatuser.IGetUsersProfileBatchListener;
import com.baidu.android.imsdk.chatuser.IStatusListener;
import com.baidu.android.imsdk.chatuser.IUserPrivacyListener;
import com.baidu.android.imsdk.conversation.ConversationManagerImpl;
import com.baidu.android.imsdk.conversation.ConversationStudioManImpl;
import com.baidu.android.imsdk.conversation.IConversationChangeListener;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.internal.BaseManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMManagerImpl;
import com.baidu.android.imsdk.internal.IMSettings;
import com.baidu.android.imsdk.mcast.ILiveMsgReceiveListener;
import com.baidu.android.imsdk.retrieve.RetrieveMsgReceiver;
import com.baidu.android.imsdk.shield.ISetForbidListener;
import com.baidu.android.imsdk.shield.ShieldAndTopManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.IUploadTransferListener;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.upload.action.IMTrackDatabase;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class BIMManager extends BaseManager implements NoProGuard {
    public static /* synthetic */ Interceptable $ic;
    public static volatile Runnable checkIMLoginState;
    public static IConnectListener mConnectListener;
    public static List<IConnectListener> mConnectListeners;
    public static Context sContext;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class CATEGORY {
        public static final /* synthetic */ CATEGORY[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CATEGORY ALL;
        public static final CATEGORY GROUP;
        public static final CATEGORY PA;
        public static final CATEGORY SINGLEPERSON;
        public static final CATEGORY STUDIO;
        public static final CATEGORY SYSTEM;
        public static final CATEGORY UNKOWN;
        public static final CATEGORY ZHIDA;
        public transient /* synthetic */ FieldHolder $fh;
        public final int value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(845770119, "Lcom/baidu/android/imsdk/BIMManager$CATEGORY;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(845770119, "Lcom/baidu/android/imsdk/BIMManager$CATEGORY;");
                    return;
                }
            }
            ALL = new CATEGORY("ALL", 0, -1);
            SINGLEPERSON = new CATEGORY("SINGLEPERSON", 1, 0);
            GROUP = new CATEGORY("GROUP", 2, 1);
            SYSTEM = new CATEGORY("SYSTEM", 3, 2);
            PA = new CATEGORY("PA", 4, 0);
            ZHIDA = new CATEGORY("ZHIDA", 5, 0);
            STUDIO = new CATEGORY("STUDIO", 6, 4);
            CATEGORY category = new CATEGORY("UNKOWN", 7, -1);
            UNKOWN = category;
            $VALUES = new CATEGORY[]{ALL, SINGLEPERSON, GROUP, SYSTEM, PA, ZHIDA, STUDIO, category};
        }

        public CATEGORY(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = i3;
        }

        public static CATEGORY valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CATEGORY) Enum.valueOf(CATEGORY.class, str) : (CATEGORY) invokeL.objValue;
        }

        public static CATEGORY[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CATEGORY[]) $VALUES.clone() : (CATEGORY[]) invokeV.objValue;
        }

        public int getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-671636915, "Lcom/baidu/android/imsdk/BIMManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-671636915, "Lcom/baidu/android/imsdk/BIMManager;");
                return;
            }
        }
        mConnectListeners = new ArrayList();
        checkIMLoginState = new Runnable() { // from class: com.baidu.android.imsdk.BIMManager.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (a.b() == 0 && LoginManager.getInstance(BIMManager.sContext).getCurrentState() != LoginManager.LoginState.LOGINED) {
                        LogUtils.e("BIMManager", "checkIMLoginState lcp connected, but im not login, triggle im relogin");
                        LoginManager.getInstance(BIMManager.sContext).triggleLogoutListener(4001, Constants.ERROR_LOGIN_STATE_ERROR);
                    }
                    BIMManager.postCheckRunnable();
                }
            }
        };
    }

    public BIMManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void asyncUploadImgToBos(Context context, String str, String str2, int i2, int i3, int i4, IUploadTransferListener iUploadTransferListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{context, str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iUploadTransferListener}) == null) {
            ChatMsgManager.asyncUploadImgToBos(context, str, str2, i2, i3, i4, iUploadTransferListener);
        }
    }

    public static void audioTrans(Context context, String str, String str2, String str3, int i2, BIMValueCallBack bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{context, str, str2, str3, Integer.valueOf(i2), bIMValueCallBack}) == null) {
            ChatMsgManager.audioTrans(context, str, str2, str3, i2, bIMValueCallBack);
        }
    }

    public static void autoClearCache(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, context) == null) {
            long imTrackDbSize = Utility.getImTrackDbSize(context);
            long readLongData = Utility.readLongData(context, IMConstants.KEY_TRACK_DB_DEFAULT_SIZE, 0L);
            String str = BaseManager.TAG;
            LogUtils.d(str, "autoClearCache trackSize = " + imTrackDbSize + " defSize = " + readLongData);
            if (imTrackDbSize - readLongData >= 307200) {
                LogUtils.d(BaseManager.TAG, "autoClearCache start clean db");
                IMTrackDatabase.getInstance(context).clearAllTables();
                Utility.writeLongData(context, IMConstants.KEY_TRACK_DB_DEFAULT_SIZE, Utility.getImTrackDbSize(context));
            }
            long sumCacheSize = Utility.sumCacheSize(context);
            String str2 = BaseManager.TAG;
            LogUtils.d(str2, "autoClearCache pluginCacheSize = " + sumCacheSize);
            if (sumCacheSize >= 31457280) {
                LogUtils.d(BaseManager.TAG, "autoClearCache start clean cache");
                Utility.clearFileCache(context);
            }
        }
    }

    public static void clearCache(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, context) == null) {
            LogUtils.d(BaseManager.TAG, "start clearCache");
            Utility.clearFileCache(context);
            IMTrackDatabase.getInstance(context).clearAllTables();
            Utility.writeLongData(context, IMConstants.KEY_TRACK_DB_DEFAULT_SIZE, Utility.getImTrackDbSize(context));
        }
    }

    public static void clearDb(Context context) {
        File[] listFiles;
        String name;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, context) == null) {
            File file = new File(context.getDatabasePath("bdimsdk_.db").getParent());
            if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2 != null && (name = file2.getName()) != null && name.startsWith(TableDefine.DB_NAME_PREFIX)) {
                        file2.delete();
                    }
                }
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREF_COMMON_DATA, 0);
            if (sharedPreferences != null) {
                sharedPreferences.edit().clear().commit();
            }
        }
    }

    public static void connectStatusNotify(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65550, null, i2) == null) {
            String str = BaseManager.TAG;
            LogUtils.i(str, "connectStatusNotify:" + i2);
            String str2 = BaseManager.TAG;
            LogUtils.i(str2, "IConnectListener size:" + mConnectListeners.size());
            synchronized (mConnectListeners) {
                for (IConnectListener iConnectListener : mConnectListeners) {
                    if (iConnectListener != null) {
                        String str3 = BaseManager.TAG;
                        LogUtils.i(str3, "im connect Status changed，成功回调业务监听, listener :" + iConnectListener.hashCode());
                        iConnectListener.onResult(i2);
                    }
                }
            }
        }
    }

    public static boolean deleteConversation(BIMConversation bIMConversation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, bIMConversation)) == null) {
            if (BaseManager.isNullContext(sContext) || bIMConversation == null) {
                return false;
            }
            return ConversationManagerImpl.getInstance(sContext).deleteConversation(bIMConversation);
        }
        return invokeL.booleanValue;
    }

    public static int deleteDraftMsg(Context context, int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2)})) == null) ? ChatMsgManager.deleteDraftMsg(context, i2, j2) : invokeCommon.intValue;
    }

    public static int deleteMsg(Context context, ChatMsg chatMsg) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, context, chatMsg)) == null) ? ChatMsgManager.deleteMsg(context, chatMsg) : invokeLL.intValue;
    }

    public static long deleteMsgs(Context context, int i2, long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            if (BaseManager.isNullContext(context)) {
                return -1L;
            }
            return ChatMsgManagerImpl.getInstance(context).deleteAllMsgs(i2, j2, z);
        }
        return invokeCommon.longValue;
    }

    public static boolean enableDebugMode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65557, null, z)) == null) {
            if (BaseManager.isNullContext(sContext)) {
                return false;
            }
            try {
                c.a = z;
            } catch (Throwable unused) {
                LogUtils.e(BaseManager.TAG, "LCPConstants.LOG_DEBUG not found");
            }
            return IMSettings.enableDebugMode(sContext.getApplicationContext(), z);
        }
        return invokeZ.booleanValue;
    }

    public static ArrayList<ChatMsg> fetchMessageSync(Context context, long j2, long j3, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65558, null, new Object[]{context, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2)})) == null) ? ChatMsgManager.fetchMessageSync(context, 0, j2, j3, i2) : (ArrayList) invokeCommon.objValue;
    }

    public static Pair<Integer, ArrayList<ChatMsg>> fetchMessageSyncWithState(Context context, int i2, long j2, int i3, ChatMsg chatMsg) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65559, null, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), chatMsg})) == null) ? ChatMsgManager.fetchMessageSyncWithState(context, i2, j2, i3, chatMsg) : (Pair) invokeCommon.objValue;
    }

    public static void fetchMsgByHostRequest(Context context, long j2, int i2, long j3, long j4, long j5, int i3, int i4, IFetchMsgByIdListener iFetchMsgByIdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65560, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Integer.valueOf(i3), Integer.valueOf(i4), iFetchMsgByIdListener}) == null) {
            fetchMsgByHostRequest(context, j2, i2, j3, j4, j5, i3, i4, iFetchMsgByIdListener, false);
        }
    }

    public static void fetchMsgByMsgid(Context context, int i2, long j2, long j3, long j4, int i3, int i4, IFetchMsgByIdListener iFetchMsgByIdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65562, null, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i3), Integer.valueOf(i4), iFetchMsgByIdListener}) == null) {
            fetchMsgByMsgid(context, i2, j2, j3, j4, i3, i4, iFetchMsgByIdListener, false);
        }
    }

    public static void fetchMsgRequest(Context context, long j2, long j3, int i2, long j4, long j5, long j6, int i3, int i4, IFetchMsgByIdListener iFetchMsgByIdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65564, null, new Object[]{context, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Integer.valueOf(i3), Integer.valueOf(i4), iFetchMsgByIdListener}) == null) {
            fetchMsgRequest(context, j2, j3, i2, j4, j5, j6, i3, i4, iFetchMsgByIdListener, false);
        }
    }

    public static void fetchPaChatMsgs(Context context, int i2, int i3, long j2, long j3, long j4, int i4, IFetchMessageListener iFetchMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65566, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i4), iFetchMessageListener}) == null) {
            String str = BaseManager.TAG;
            LogUtils.d(str, "fetchPaChatMsgs patype = " + i2 + " subPatype = " + i3 + " paid = " + j2 + " msgid = " + j3 + " time = " + j4 + " count = " + i4);
            ChatMsgManager.fetchPaChatMsgs(context, i2, i3, j2, j3, j4, i4, iFetchMessageListener);
        }
    }

    public static void genBosObjectUrl(Context context, String str, String str2, String str3, int i2, int i3, int i4, IGenBosObjectUrlListener iGenBosObjectUrlListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65567, null, new Object[]{context, str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iGenBosObjectUrlListener}) == null) {
            ChatMsgManager.genBosObjectUrl(context, str, str2, str3, i2, i3, i4, iGenBosObjectUrlListener);
        }
    }

    public static String getAllCastIdList(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) ? ConversationStudioManImpl.getInstance(context).getAllCastIdList() : (String) invokeL.objValue;
    }

    public static ArrayList<BIMConversation> getAllConversation(CATEGORY category) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, category)) == null) {
            if (BaseManager.isNullContext(sContext)) {
                return null;
            }
            return ConversationManagerImpl.getInstance(sContext).getAllConversation(category);
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String getAppVersion(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) ? AccountManagerImpl.getInstance(context).getAppVersion() : (String) invokeL.objValue;
    }

    public static long getCacheSize(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, context)) == null) {
            long sumCacheSize = Utility.sumCacheSize(context);
            long imTrackDbSize = Utility.getImTrackDbSize(context);
            long readLongData = Utility.readLongData(context, IMConstants.KEY_TRACK_DB_DEFAULT_SIZE, 0L);
            String str = BaseManager.TAG;
            LogUtils.d(str, "getCacheSize pluginCacheSize = " + sumCacheSize + " trackSize = " + imTrackDbSize + " defSize = " + readLongData);
            long j2 = imTrackDbSize - readLongData;
            return sumCacheSize + (j2 >= 0 ? j2 : 0L);
        }
        return invokeL.longValue;
    }

    @Deprecated
    public static List<ChatSession> getChatSession(Context context, List<Integer> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65572, null, context, list)) == null) ? ChatMsgManager.getChatRecords(context, list) : (List) invokeLL.objValue;
    }

    public static ChatUser getChatUserSync(Context context, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65574, null, context, j2)) == null) ? ChatUserManager.getChatUserSync(context, j2) : (ChatUser) invokeLJ.objValue;
    }

    public static BIMConversation getConversation(String str, CATEGORY category) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65577, null, str, category)) == null) {
            if (BaseManager.isNullContext(sContext)) {
                return null;
            }
            if (CATEGORY.ALL != category && CATEGORY.SYSTEM != category) {
                return ConversationManagerImpl.getInstance(sContext).getConversation(category, str);
            }
            LogUtils.e(LogUtils.TAG, "category should not be ALL or SYSTEM");
            return null;
        }
        return (BIMConversation) invokeLL.objValue;
    }

    public static String getCuid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65578, null, context)) == null) ? Utility.getDeviceId(context) : (String) invokeL.objValue;
    }

    public static void getCuidTokenAndLogin(String str, int i2, String str2, String str3, ILoginListener iLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65579, null, new Object[]{str, Integer.valueOf(i2), str2, str3, iLoginListener}) == null) {
            Context context = sContext;
            Utility.writeLoginFlag(context, "3N", "getCuidTokenAndLogin accessToken = " + str);
            AccountManagerImpl.getInstance(sContext).getTokenByCuid(AccountManager.getAppid(sContext), str, new IGetTokenByCuidListener(i2, str2, str3, iLoginListener, str) { // from class: com.baidu.android.imsdk.BIMManager.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String val$accessToken;
                public final /* synthetic */ String val$cfrom;
                public final /* synthetic */ String val$from;
                public final /* synthetic */ ILoginListener val$listener;
                public final /* synthetic */ int val$loginType;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Integer.valueOf(i2), str2, str3, iLoginListener, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$loginType = i2;
                    this.val$from = str2;
                    this.val$cfrom = str3;
                    this.val$listener = iLoginListener;
                    this.val$accessToken = str;
                }

                @Override // com.baidu.android.imsdk.account.IGetTokenByCuidListener
                public void onGetTokenByCuidResult(int i3, String str4, String str5) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i3, str4, str5) == null) {
                        if (i3 != 0) {
                            if (i3 != 70) {
                                AccountManagerImpl.getInstance(BIMManager.sContext);
                                AccountManagerImpl.mCuidTokenTryTimes++;
                                LogUtils.d(BaseManager.TAG, "HB> getTokenByCuid, responseCode = " + i3 + ", errMsg = " + str4);
                                AccountManagerImpl.getInstance(BIMManager.sContext);
                                if (AccountManagerImpl.mCuidTokenTryTimes > 3) {
                                    Utility.writeLoginFlag(BIMManager.sContext, "3N", "genToken retryTime >= 3, errCode = " + i3 + ", errMsg :" + str4);
                                    this.val$listener.onLoginResult(i3, str4);
                                    return;
                                }
                                try {
                                    Thread.sleep(200L);
                                } catch (Exception e2) {
                                    LogUtils.e(BaseManager.TAG, "Exception ", e2);
                                    Utility.writeLoginFlag(BIMManager.sContext, "3N", "gen token retry exception, errCode = " + i3);
                                    new IMTrack.CrashBuilder(BIMManager.sContext).exception(Log.getStackTraceString(e2)).build();
                                }
                                BIMManager.getCuidTokenAndLogin(this.val$accessToken, this.val$loginType, this.val$from, this.val$cfrom, this.val$listener);
                                return;
                            }
                            this.val$listener.onLoginResult(i3, str4);
                        } else if (!TextUtils.isEmpty(str5)) {
                            AccountManagerImpl.getInstance(BIMManager.sContext);
                            AccountManagerImpl.mCuidTokenTryTimes = 0;
                            LogUtils.d(BaseManager.TAG, "HB> getTokenByCuid, token =  " + str5);
                            Utility.writeLoginFlag(BIMManager.sContext, "3Y", "genToken success, token = " + str5);
                            BIMManager.loginExecutor(this.val$loginType, null, str5, this.val$from, this.val$cfrom, this.val$listener);
                        } else {
                            LogUtils.d(BaseManager.TAG, "HB> getTokenByCuid, token is null,  responseCode = " + i3 + ", errMsg = " + str4);
                            AccountManagerImpl.getInstance(BIMManager.sContext);
                            AccountManagerImpl.mCuidTokenTryTimes = AccountManagerImpl.mCuidTokenTryTimes + 1;
                            AccountManagerImpl.getInstance(BIMManager.sContext);
                            if (AccountManagerImpl.mCuidTokenTryTimes > 3) {
                                Utility.writeLoginFlag(BIMManager.sContext, "3N", "genToken is null, errCode = 1005");
                                this.val$listener.onLoginResult(1005, "gen token is NULL");
                                return;
                            }
                            try {
                                Thread.sleep(200L);
                            } catch (Exception e3) {
                                LogUtils.e(BaseManager.TAG, "Exception ", e3);
                                Utility.writeLoginFlag(BIMManager.sContext, "3N", "genToken retry exception, errCode = " + i3);
                                new IMTrack.CrashBuilder(BIMManager.sContext).exception(Log.getStackTraceString(e3)).build();
                            }
                            BIMManager.getCuidTokenAndLogin(this.val$accessToken, this.val$loginType, this.val$from, this.val$cfrom, this.val$listener);
                        }
                    }
                }
            });
        }
    }

    public static ChatMsg getDraftMsg(Context context, int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65580, null, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2)})) == null) ? ChatMsgManager.getDraftMsg(context, i2, j2) : (ChatMsg) invokeCommon.objValue;
    }

    public static long getJoinedCastId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65581, null, context)) == null) ? ConversationStudioManImpl.getInstance(context).getJoinedCastId() : invokeL.longValue;
    }

    public static int getLoginType(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65582, null, context)) == null) ? AccountManagerImpl.getInstance(context).getLoginType() : invokeL.intValue;
    }

    public static String getLoginUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) {
            if (!BaseManager.isNullContext(sContext) && AccountManagerImpl.getInstance(sContext).isLogin() && LoginManager.LoginState.LOGINED.equals(LoginManager.getInstance(sContext).getCurrentState())) {
                return AccountManagerImpl.getInstance(sContext).getUid();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static long getMaxReliableMsgId(Context context, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65584, null, context, j2)) == null) ? ConversationStudioManImpl.getInstance(context).getMaxReliableMsgId(j2) : invokeLJ.longValue;
    }

    public static int getNewMsgCount(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65585, null, context)) == null) ? ChatMsgManager.getNewMsgCount(context) : invokeL.intValue;
    }

    public static void getPaNewMsgCount(Context context, int i2, int i3, long j2, IGetNewMsgCountListener iGetNewMsgCountListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65587, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), iGetNewMsgCountListener}) == null) {
            String str = BaseManager.TAG;
            LogUtils.d(str, "getPaNewMsgCount patype = " + i2 + " subPatype = " + i3 + " paid = " + j2);
            ChatMsgManager.getPaNewMsgCount(context, i2, i3, j2, iGetNewMsgCountListener);
        }
    }

    public static long getReliableMsgCount(Context context, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65588, null, context, j2)) == null) ? ConversationStudioManImpl.getInstance(context).getReliableMsgCount(j2) : invokeLJ.longValue;
    }

    public static int getUnReadMsgCountByPaid(Context context, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65589, null, context, j2)) == null) ? ChatMsgManager.getUnReadMsgCountByPaid(context, j2) : invokeLJ.intValue;
    }

    public static void getUsersProfiles(Context context, ArrayList<Long> arrayList, boolean z, IGetUsersProfileBatchListener iGetUsersProfileBatchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65590, null, new Object[]{context, arrayList, Boolean.valueOf(z), iGetUsersProfileBatchListener}) == null) {
            ChatUserManager.getUsersProfiles(context, arrayList, z, iGetUsersProfileBatchListener);
        }
    }

    public static String getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65591, null)) == null) ? IMManagerImpl.getVersion() : (String) invokeV.objValue;
    }

    public static void imLogoutByLcp(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65592, null, context) == null) {
            try {
                c.a.t.a.e(context);
                LoginManager.getInstance(context).onLogoutResultInternal(0, "lcp unconnected");
            } catch (Exception e2) {
                LogUtils.e(BaseManager.TAG, "imLogoutByLcp exception ", e2);
            }
        }
    }

    public static void imLogoutByLcpAsync(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65593, null, context) == null) {
            TaskManager.getInstance(context).submitForNetWork(new Runnable(context) { // from class: com.baidu.android.imsdk.BIMManager.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$context = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        BIMManager.imLogoutByLcp(this.val$context);
                    }
                }
            });
        }
    }

    public static boolean init(Context context, long j2, int i2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65594, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), str})) == null) {
            if (BaseManager.isNullContext(context) || TextUtils.isEmpty(str)) {
                return false;
            }
            Context applicationContext = context.getApplicationContext();
            sContext = applicationContext;
            c.a.t.a.f25914e = a.d(applicationContext);
            if (c.a.t.a.f25914e) {
                try {
                    initLCP();
                    c.c(applicationContext, i2 != 0);
                    c.d(applicationContext, i2);
                } catch (Throwable unused) {
                    LogUtils.e(BaseManager.TAG, "LCPConstants.setLcpEnv not found");
                }
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.lcp.sdk.broadcast");
            LocalBroadcastManager.getInstance(applicationContext).registerReceiver(new BroadcastReceiver() { // from class: com.baidu.android.imsdk.BIMManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context2, Intent intent) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, context2, intent) == null) && intent != null && "com.baidu.lcp.sdk.broadcast".equals(intent.getAction())) {
                        boolean z = intent.getIntExtra("com.baidu.lcp.sdk.connect.state", -1) == 0;
                        LogUtils.e("BIMManager", "BLCPClient notifyConnectState :" + z);
                        if (!z) {
                            BIMManager.imLogoutByLcpAsync(context2);
                            BIMManager.connectStatusNotify(1);
                        }
                        try {
                            BIMManager.initIMServiceImpl(context2);
                            c.a.t.a.f25912c.removeCallbacks(BIMManager.checkIMLoginState);
                            if (z) {
                                BIMManager.postCheckRunnable();
                            }
                        } catch (Exception e2) {
                            String str2 = BaseManager.TAG;
                            LogUtils.e(str2, "registerLCPReceiver exception" + e2.getMessage());
                        }
                    }
                }
            }, intentFilter);
            String str2 = "set env as " + i2 + "， appId:" + j2 + ", cuid :" + str;
            AccountManagerImpl.getInstance(applicationContext).setAppid(j2);
            Utility.setDeviceId(applicationContext, str);
            Constants.setEnv(applicationContext, i2);
            IMManagerImpl.getInstance(applicationContext);
            IMSettings.setContext(applicationContext);
            ConversationManagerImpl.getInstance(applicationContext);
            Utility.clearExpiredMsg(applicationContext);
            registerInternalListener(RetrieveMsgReceiver.getInstance(applicationContext));
            c.a.s.a.a.d().e(applicationContext, str, i2, Constants.isDebugMode());
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static void initIMServiceImpl(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65595, null, context) == null) {
            TaskManager.getInstance(context).submitForNetWork(new Runnable(context) { // from class: com.baidu.android.imsdk.BIMManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$context = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        c.a.t.a.g(this.val$context);
                    }
                }
            });
        }
    }

    public static void initLCP() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65596, null) == null) {
            c.a.u.a.b.c.e().i(sContext);
        }
    }

    public static boolean isIMLogined(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65597, null, context)) == null) ? LoginManager.getInstance(context).isIMLogined() : invokeL.booleanValue;
    }

    public static boolean isSupportMsgType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65598, null, i2)) == null) ? i2 == 0 || i2 == 8 || i2 == 2 || i2 == 1 || i2 == 13 || i2 == 16 || i2 == 18 || i2 == 12 || i2 == 21 || i2 == 9 || i2 == 1002 || i2 == 1001 || i2 == 1003 || i2 == 1004 || i2 == 1005 || i2 == 1007 || i2 == 1008 || i2 == 1009 || i2 == 1010 || i2 == 1011 || i2 == 2010 || i2 == 1012 || i2 == 2001 || i2 == 80 || i2 == 31 || i2 == 32 || i2 == 33 || i2 == 20 || i2 == 22 || i2 == 25 || i2 == 26 || i2 == 24 || i2 == 2012 || i2 == 2014 || i2 == 28 || i2 == 27 || i2 == 29 || i2 == 30 || i2 == 35 || i2 == 36 || i2 == 38 || i2 == 1013 || i2 == 1014 || i2 == 39 || i2 == 40 || i2 == 41 : invokeI.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void login(String str, String str2, int i2, String str3, String str4, String str5, String str6, int i3, ILoginListener iLoginListener) {
        long j2;
        IMTrack.RequestBuilder requestId;
        String str7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65600, null, new Object[]{str, str2, Integer.valueOf(i2), str3, str4, str5, str6, Integer.valueOf(i3), iLoginListener}) == null) {
            String str8 = BaseManager.TAG;
            LogUtils.d(str8, "HB> im in login, uid = " + str + ", cuid = " + str2 + ", loginType = " + i2 + ", zid = " + str5 + ", vCode = " + str6 + ", openType = " + i3);
            if (BaseManager.isNullContext(sContext)) {
                if (iLoginListener != null) {
                    iLoginListener.onLoginResult(1005, "Context is NULL");
                    return;
                }
                return;
            }
            try {
                String[] loginFlag = Utility.getLoginFlag(sContext);
                if (loginFlag.length >= 2) {
                    j2 = Long.valueOf(loginFlag[0]).longValue();
                    try {
                        try {
                            str7 = loginFlag[1];
                        } catch (Exception unused) {
                            LogUtils.e(BaseManager.TAG, "IMTrack init request getLoginFlag Exception ");
                            requestId = new IMTrack.RequestBuilder(sContext).method(String.valueOf(Utility.getLoginOpenType(sContext))).requestId("1Y");
                            requestId.requestTime(Utility.getLoginCallTime(sContext)).responseTime(j2).ext(Utility.getLoginFlagExt(sContext)).aliasId(501100L).build();
                            Utility.writeLoginCallTime(sContext);
                            Context context = sContext;
                            Utility.writeLoginFlag(context, "1Y", "context is nonnull, accessToken is null -> " + TextUtils.isEmpty(str2));
                            Utility.writeLoginOpenType(sContext, i3);
                            AccountManagerImpl.getInstance(sContext).setAppOpenType(i3);
                            AccountManagerImpl.getInstance(sContext).pushReStartWork();
                            if (!TextUtils.isEmpty(str2)) {
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        new IMTrack.RequestBuilder(sContext).method(String.valueOf(Utility.getLoginOpenType(sContext))).requestId("1Y").requestTime(Utility.getLoginCallTime(sContext)).responseTime(j2).ext(Utility.getLoginFlagExt(sContext)).aliasId(501100L).build();
                        throw th;
                    }
                } else {
                    str7 = "1Y";
                    j2 = 0;
                }
                requestId = new IMTrack.RequestBuilder(sContext).method(String.valueOf(Utility.getLoginOpenType(sContext))).requestId(str7);
            } catch (Exception unused2) {
                j2 = 0;
            } catch (Throwable th2) {
                th = th2;
                j2 = 0;
                new IMTrack.RequestBuilder(sContext).method(String.valueOf(Utility.getLoginOpenType(sContext))).requestId("1Y").requestTime(Utility.getLoginCallTime(sContext)).responseTime(j2).ext(Utility.getLoginFlagExt(sContext)).aliasId(501100L).build();
                throw th;
            }
            requestId.requestTime(Utility.getLoginCallTime(sContext)).responseTime(j2).ext(Utility.getLoginFlagExt(sContext)).aliasId(501100L).build();
            Utility.writeLoginCallTime(sContext);
            Context context2 = sContext;
            Utility.writeLoginFlag(context2, "1Y", "context is nonnull, accessToken is null -> " + TextUtils.isEmpty(str2));
            Utility.writeLoginOpenType(sContext, i3);
            AccountManagerImpl.getInstance(sContext).setAppOpenType(i3);
            AccountManagerImpl.getInstance(sContext).pushReStartWork();
            if (!TextUtils.isEmpty(str2)) {
                Utility.writeLoginFlag(sContext, "2N", "accessToken is null");
                if (iLoginListener != null) {
                    iLoginListener.onLoginResult(1005, "accessToken is NULL");
                    return;
                }
                return;
            }
            Context context3 = sContext;
            Utility.writeLoginFlag(context3, "2Y", "accessToken is nonnull, loginType = " + i2);
            if (!TextUtils.isEmpty(str5)) {
                LogUtils.d(BaseManager.TAG, "HB> im in login, zid is not null !");
                AccountManagerImpl.getInstance(sContext).setZid(str5);
            }
            if (!TextUtils.isEmpty(str6)) {
                LogUtils.d(BaseManager.TAG, "HB> im in login, vCode is not null !");
                AccountManagerImpl.getInstance(sContext).setVersionCode(str6);
            }
            if (i2 == 6) {
                AccountManagerImpl.getInstance(sContext).setCuid(str2);
                String token = AccountManagerImpl.getInstance(sContext).getToken();
                if (!TextUtils.isEmpty(token)) {
                    loginExecutor(i2, str, token, str3, str4, iLoginListener);
                    return;
                }
                AccountManagerImpl.getInstance(sContext);
                AccountManagerImpl.mCuidTokenTryTimes = 0;
                getCuidTokenAndLogin(str2, i2, str3, str4, iLoginListener);
                return;
            }
            loginExecutor(i2, str, str2, str3, str4, iLoginListener);
        }
    }

    public static void loginExecutor(int i2, String str, String str2, String str3, String str4, ILoginListener iLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65601, null, new Object[]{Integer.valueOf(i2), str, str2, str3, str4, iLoginListener}) == null) {
            if (BaseManager.isNullContext(sContext)) {
                if (iLoginListener != null) {
                    iLoginListener.onLoginResult(1005, "Context is NULL");
                }
            } else if (TextUtils.isEmpty(str2)) {
                if (iLoginListener != null) {
                    iLoginListener.onLoginResult(1005, "accessToken is NULL");
                }
            } else {
                if (i2 != 6) {
                    if (TextUtils.isEmpty(str)) {
                        Utility.writeLoginFlag(sContext, "4N", "uid is null");
                        if (iLoginListener != null) {
                            iLoginListener.onLoginResult(1005, "uid is NULL");
                            return;
                        }
                        return;
                    }
                    Utility.writeLoginFlag(sContext, "4Y", "uid is nonnull");
                }
                AccountManagerImpl.getInstance(sContext).login(i2, str, str2, str3, str4, iLoginListener);
            }
        }
    }

    public static void logout(ILoginListener iLoginListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65602, null, iLoginListener) == null) {
            LogUtils.d(BaseManager.TAG, "logout");
            if (!BaseManager.isNullContext(sContext)) {
                AccountManagerImpl.getInstance(sContext).logout(1, new ILoginListener(iLoginListener) { // from class: com.baidu.android.imsdk.BIMManager.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ILoginListener val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {iLoginListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$listener = iLoginListener;
                    }

                    @Override // com.baidu.android.imsdk.account.ILoginListener
                    public void onLoginResult(int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        }
                    }

                    @Override // com.baidu.android.imsdk.account.ILoginListener
                    public void onLogoutResult(int i2, String str, int i3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
                            String str2 = BaseManager.TAG;
                            LogUtils.i(str2, "onLogoutResult errorCode : " + i2 + " , errMsg, " + str + " , loginType, " + i3);
                            if (i2 != 0) {
                                Utility.logout(BIMManager.sContext, null);
                            }
                            LoginManager.getInstance(BIMManager.sContext).onLogoutResultInternal(0, str);
                            ILoginListener iLoginListener2 = this.val$listener;
                            if (iLoginListener2 != null) {
                                iLoginListener2.onLogoutResult(0, i2 != 0 ? "Force logout" : "", i3);
                            }
                        }
                    }
                });
            } else if (iLoginListener != null) {
                iLoginListener.onLogoutResult(1005, "Context is null", -1);
            }
        }
    }

    public static int markMsgClicked(Context context, ChatMsg chatMsg) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65603, null, context, chatMsg)) == null) ? ChatMsgManager.markMsgClicked(context, chatMsg) : invokeLL.intValue;
    }

    public static void mediaContactorSetting(Context context, long j2, int i2, IMediaContactorSettingListener iMediaContactorSettingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65605, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), iMediaContactorSettingListener}) == null) {
            ChatMsgManager.mediaContactorSetting(context, j2, i2, iMediaContactorSettingListener);
        }
    }

    public static void mediaDeleteAllChatMsg(Context context, long j2, long j3, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65607, null, new Object[]{context, Long.valueOf(j2), Long.valueOf(j3), iMediaDeleteChatMsgListener}) == null) {
            ChatMsgManager.mediaDeleteChatMsg(context, j2, j3, null, iMediaDeleteChatMsgListener);
        }
    }

    public static void mediaDeleteChatMsg(Context context, long j2, List<Long> list, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65609, null, new Object[]{context, Long.valueOf(j2), list, iMediaDeleteChatMsgListener}) == null) {
            ChatMsgManager.mediaDeleteChatMsg(context, j2, -1L, list, iMediaDeleteChatMsgListener);
        }
    }

    public static void mediaDeleteChatSession(Context context, long j2, long j3, IMediaDeleteChatSessionListener iMediaDeleteChatSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65611, null, new Object[]{context, Long.valueOf(j2), Long.valueOf(j3), iMediaDeleteChatSessionListener}) == null) {
            ChatMsgManager.mediaDeleteChatSession(context, j2, j3, iMediaDeleteChatSessionListener);
        }
    }

    public static void mediaFetchChatMsgs(Context context, long j2, long j3, long j4, int i2, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65613, null, new Object[]{context, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i2), iMediaFetchChatMsgsListener}) == null) {
            ChatMsgManager.mediaFetchChatMsgs(context, j2, j3, j4, i2, iMediaFetchChatMsgsListener);
        }
    }

    public static void mediaGetChatSessions(Context context, long j2, long j3, int i2, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65615, null, new Object[]{context, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), iMediaGetChatSessionListener}) == null) {
            ChatMsgManager.mediaGetChatSessions(context, j2, j3, i2, iMediaGetChatSessionListener);
        }
    }

    public static void mediaGetContactorPauid(Context context, long j2, IMediaGetContactorPauidListener iMediaGetContactorPauidListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65617, null, new Object[]{context, Long.valueOf(j2), iMediaGetContactorPauidListener}) == null) {
            ChatMsgManager.mediaGetContactorPauid(context, j2, iMediaGetContactorPauidListener);
        }
    }

    public static void mediaGetContactorSetting(Context context, long j2, int i2, IMediaContactorSettingListener iMediaContactorSettingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65619, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), iMediaContactorSettingListener}) == null) {
            ChatMsgManager.mediaGetContactorSetting(context, j2, i2, iMediaContactorSettingListener);
        }
    }

    public static void mediaRegisterChatMsgChangedListener(Context context, IMediaChatMsgChangedListener iMediaChatMsgChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65620, null, context, iMediaChatMsgChangedListener) == null) {
            ChatMsgManager.mediaRegisterChatMsgChangedListener(context, iMediaChatMsgChangedListener);
        }
    }

    public static void mediaSendChatMsg(Context context, long j2, ChatMsg chatMsg, IMediaSendChatMsgListener iMediaSendChatMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65622, null, new Object[]{context, Long.valueOf(j2), chatMsg, iMediaSendChatMsgListener}) == null) {
            ChatMsgManager.mediaSendChatMsg(context, j2, chatMsg, iMediaSendChatMsgListener);
        }
    }

    public static void mediaSetAllSessionRead(Context context, IMediaSetSessionReadListener iMediaSetSessionReadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65623, null, context, iMediaSetSessionReadListener) == null) {
            ChatMsgManager.setMediaAllSessionRead(context, iMediaSetSessionReadListener);
        }
    }

    public static void mediaSetRole(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65624, null, context, z) == null) {
            AccountManager.setMediaRole(context, z);
        }
    }

    public static void mediaSetSessionRead(Context context, long j2, long j3, IMediaSetSessionReadListener iMediaSetSessionReadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65626, null, new Object[]{context, Long.valueOf(j2), Long.valueOf(j3), iMediaSetSessionReadListener}) == null) {
            ChatMsgManager.mediaSetSessionRead(context, j2, j3, iMediaSetSessionReadListener);
        }
    }

    public static void mediaUnRegisterChatMsgChangedListener(Context context, IMediaChatMsgChangedListener iMediaChatMsgChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65627, null, context, iMediaChatMsgChangedListener) == null) {
            ChatMsgManager.mediaUnRegisterChatMsgChangedListener(context, iMediaChatMsgChangedListener);
        }
    }

    public static void pingRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65628, null) == null) {
            a.e();
        }
    }

    public static void postCheckRunnable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65629, null) == null) {
            try {
                LogUtils.i("BIMManager", "postCheckRunnable after 30s");
                c.a.t.a.f25912c.postDelayed(checkIMLoginState, 30000L);
            } catch (Exception e2) {
                LogUtils.e(BaseManager.TAG, "postCheckRunnable exception ", e2);
            }
        }
    }

    public static void registerChatSessionChangeListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65630, null, context, iChatSessionChangeListener) == null) {
            IMBoxManager.registerChatSessionChangeListener(context, iChatSessionChangeListener);
        }
    }

    public static void registerChatSessionListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65631, null, context, iChatSessionChangeListener) == null) {
            ChatMsgManager.registerChatSessionListener(context, iChatSessionChangeListener);
        }
    }

    public static void registerConnectListener(IConnectListener iConnectListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65632, null, iConnectListener) == null) {
            mConnectListener = iConnectListener;
            registerConnectListenerToList(iConnectListener);
        }
    }

    public static void registerConnectListenerToList(IConnectListener iConnectListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65633, null, iConnectListener) == null) {
            synchronized (mConnectListeners) {
                if (!mConnectListeners.contains(iConnectListener)) {
                    mConnectListeners.add(iConnectListener);
                    String str = BaseManager.TAG;
                    LogUtils.i(str, "registerConnectListenerToList:" + iConnectListener.hashCode());
                }
            }
        }
    }

    public static void registerConversationListener(IConversationChangeListener iConversationChangeListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65634, null, iConversationChangeListener) == null) || BaseManager.isNullContext(sContext)) {
            return;
        }
        ConversationManagerImpl.getInstance(sContext).registerConversationListener(iConversationChangeListener);
    }

    public static void registerInternalListener(IMessageReceiveListener iMessageReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65635, null, iMessageReceiveListener) == null) {
            ChatMsgManagerImpl.getInstance(sContext).registerInternalMessageReceiveListener(iMessageReceiveListener);
        }
    }

    public static void registerMessageReceiveListener(Context context, IMessageReceiveListener iMessageReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65636, null, context, iMessageReceiveListener) == null) {
            ChatMsgManager.registerMessageReceiveListener(context, iMessageReceiveListener);
        }
    }

    public static boolean registerNotify(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65637, null, str, str2, str3)) == null) {
            String str4 = BaseManager.TAG;
            LogUtils.d(str4, "channelId=" + str + ";userId=" + str2 + ";appId=" + str3);
            if (BaseManager.isNullContext(sContext)) {
                LogUtils.d(BaseManager.TAG, "Context is NULL!");
                return false;
            } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                return ChatMsgManagerImpl.getInstance(sContext).registerNotify(str, str2, str3, null);
            } else {
                LogUtils.d(BaseManager.TAG, Constants.ERROR_MSG_PARAMETER_ERROR);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static void registerStudioUsePaReceiveMsg(Context context, ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65638, null, context, iLiveMsgReceiveListener) == null) {
            if (context == null && iLiveMsgReceiveListener != null) {
                iLiveMsgReceiveListener.onReceiveMessage(-1, null);
            }
            ChatMsgManager.registerStudioUsePaReceivePaMsg(context, iLiveMsgReceiveListener);
        }
    }

    public static void removeSessionByClasstype(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65639, null, context, i2) == null) {
            IMBoxManager.removeSessionByClasstype(context, i2);
        }
    }

    public static int saveAsDraftMsg(Context context, ChatMsg chatMsg) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65640, null, context, chatMsg)) == null) ? ChatMsgManager.saveAsDraftMsg(context, chatMsg) : invokeLL.intValue;
    }

    public static void saveMessage(Context context, ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65641, null, context, chatMsg) == null) {
            ChatMsgManager.saveMessage(context, chatMsg);
        }
    }

    public static void sendMessage(Context context, ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65642, null, context, chatMsg, iSendMessageListener) == null) || context == null) {
            return;
        }
        ChatMsgManager.sendMessage(context, chatMsg, iSendMessageListener);
    }

    public static void sendMsgRequest(Context context, boolean z, ChatMsg chatMsg, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65643, null, new Object[]{context, Boolean.valueOf(z), chatMsg, iSendMessageListener}) == null) || context == null) {
            return;
        }
        Utility.setStudioHostSendMsg(context, z);
        ChatMsgManager.sendMessage(context, chatMsg, iSendMessageListener);
    }

    public static void sendPaChatMsg(Context context, int i2, int i3, long j2, int i4, String str, ISendMessageListener iSendMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65644, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), Integer.valueOf(i4), str, iSendMessageListener}) == null) {
            String str2 = BaseManager.TAG;
            LogUtils.d(str2, "sendPaChatMsg patype = " + i2 + " subPatype = " + i3 + " paid = " + j2 + " msgtype = " + i4 + " content = " + str);
            ChatMsgManager.sendPaChatMsg(context, i2, i3, j2, i4, str, iSendMessageListener);
        }
    }

    public static boolean setAllMsgRead(Context context, int i2, long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65645, null, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2), Boolean.valueOf(z)})) == null) ? ChatMsgManager.setAllMsgRead(context, i2, j2, z) : invokeCommon.booleanValue;
    }

    public static void setForbid(Context context, long j2, long j3, int i2, ISetForbidListener iSetForbidListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65646, null, new Object[]{context, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), iSetForbidListener}) == null) {
            ShieldAndTopManager.getInstance(context).setForbid(j2, j3, i2, iSetForbidListener);
        }
    }

    public static void setGroupMarkTop(Context context, long j2, int i2, IStatusListener iStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65647, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), iStatusListener}) == null) {
            ShieldAndTopManager.getInstance(context).setMarkTop(j2, 3, i2, iStatusListener);
        }
    }

    public static void setMarkTop(Context context, long j2, int i2, IStatusListener iStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65648, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), iStatusListener}) == null) {
            ShieldAndTopManager.getInstance(context).setMarkTop(j2, 1, i2, iStatusListener);
        }
    }

    public static boolean setMsgRead(Context context, long j2, long j3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65650, null, new Object[]{context, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)})) == null) ? ChatMsgManager.setMsgRead(context, 0, j2, j3, z) : invokeCommon.booleanValue;
    }

    public static void setPaMsgsRead(Context context, int i2, int i3, long j2, long j3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65651, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
            String str = BaseManager.TAG;
            LogUtils.d(str, "setPaMsgsRead patype = " + i2 + " subPatype = " + i3 + " paid = " + j2 + " msgid = " + j3 + " time = " + j4);
            ChatMsgManager.setPaMsgsRead(context, i2, i3, j2, j3, j4);
        }
    }

    public static boolean setProductLine(Context context, int i2, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65652, null, context, i2, str)) == null) {
            if (BaseManager.isNullContext(context)) {
                return false;
            }
            if (!TextUtils.isEmpty(str)) {
                if (str.equals(AccountManagerImpl.getInstance(context).getAppVersion())) {
                    IMConstants.IS_UPDATE_VERSION = false;
                } else {
                    IMConstants.IS_UPDATE_VERSION = true;
                }
            }
            AccountManagerImpl.getInstance(context).setAppVersion(str);
            return IMManager.init(context, i2);
        }
        return invokeLIL.booleanValue;
    }

    public static void setUpdateSwitch(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65653, null, context, i2) == null) {
            AccountManager.setUpdateSwitch(context, i2);
        }
    }

    public static void setUserDisturb(Context context, long j2, int i2, IUserPrivacyListener iUserPrivacyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65654, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), iUserPrivacyListener}) == null) {
            IMBoxManager.setUserDisturb(context, j2, i2, iUserPrivacyListener);
        }
    }

    public static void setUserMarkTop(Context context, long j2, int i2, IStatusListener iStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65655, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), iStatusListener}) == null) {
            ShieldAndTopManager.getInstance(context).setMarkTop(j2, 0, i2, iStatusListener);
        }
    }

    public static void tryConnection(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65656, null, context) == null) || c.a.t.a.f25914e) {
            return;
        }
        AccountManagerImpl.getInstance(context);
        AccountManagerImpl.tryConnection(context);
    }

    public static void unregisterChatSessionChangeListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65657, null, context, iChatSessionChangeListener) == null) {
            IMBoxManager.unregisterChatSessionChangeListener(context, iChatSessionChangeListener);
        }
    }

    public static void unregisterChatSessionListener(Context context, IChatSessionChangeListener iChatSessionChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65658, null, context, iChatSessionChangeListener) == null) {
            ChatMsgManager.unregisterChatSessionListener(context, iChatSessionChangeListener);
        }
    }

    public static void unregisterConnectListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65659, null) == null) {
            mConnectListener = null;
        }
    }

    public static void unregisterConnectListenerFromList(IConnectListener iConnectListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65660, null, iConnectListener) == null) || iConnectListener == null) {
            return;
        }
        synchronized (mConnectListeners) {
            mConnectListeners.remove(iConnectListener);
            String str = BaseManager.TAG;
            LogUtils.i(str, "unregisterConnectListenerFromList:" + iConnectListener.hashCode());
        }
    }

    public static void unregisterConversationListener(IConversationChangeListener iConversationChangeListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65661, null, iConversationChangeListener) == null) || BaseManager.isNullContext(sContext)) {
            return;
        }
        ConversationManagerImpl.getInstance(sContext).unregisterConversationListener(iConversationChangeListener);
    }

    public static void unregisterMessageReceiveListener(Context context, IMessageReceiveListener iMessageReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65662, null, context, iMessageReceiveListener) == null) {
            ChatMsgManager.unregisterMessageReceiveListener(context, iMessageReceiveListener);
        }
    }

    public static void unregisterStudioUsePaReceiveMsg(Context context, ILiveMsgReceiveListener iLiveMsgReceiveListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65663, null, context, iLiveMsgReceiveListener) == null) {
            if (context == null && iLiveMsgReceiveListener != null) {
                iLiveMsgReceiveListener.onReceiveMessage(-1, null);
            }
            ChatMsgManager.unregisterStudioUsePaReceivePaMsg(context, iLiveMsgReceiveListener);
        }
    }

    public static void fetchMsgByHostRequest(Context context, long j2, int i2, long j3, long j4, long j5, int i3, int i4, IFetchMsgByIdListener iFetchMsgByIdListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65561, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Integer.valueOf(i3), Integer.valueOf(i4), iFetchMsgByIdListener, Boolean.valueOf(z)}) == null) {
            ChatMsgManager.fetchMsgByHostRequst(context, j2, i2, j3, j4, j5, i3, iFetchMsgByIdListener);
        }
    }

    public static void fetchMsgByMsgid(Context context, int i2, long j2, long j3, long j4, int i3, int i4, IFetchMsgByIdListener iFetchMsgByIdListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65563, null, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i3), Integer.valueOf(i4), iFetchMsgByIdListener, Boolean.valueOf(z)}) == null) {
            ChatMsgManager.fetchMsgRequst(context, Utility.getAppId(context), Utility.getUK(context), i2, j2, j3, j4, i3, iFetchMsgByIdListener, z);
        }
    }

    public static void fetchMsgRequest(Context context, long j2, long j3, int i2, long j4, long j5, long j6, int i3, int i4, IFetchMsgByIdListener iFetchMsgByIdListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65565, null, new Object[]{context, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Integer.valueOf(i3), Integer.valueOf(i4), iFetchMsgByIdListener, Boolean.valueOf(z)}) == null) {
            ChatMsgManager.fetchMsgRequst(context, j2, j3, i2, j4, j5, j6, i3, iFetchMsgByIdListener, z);
        }
    }

    public static void getChatSession(Context context, List<Integer> list, IGetSessionListener iGetSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65573, null, context, list, iGetSessionListener) == null) {
            IMBoxManager.getChatSession(context, list, iGetSessionListener);
        }
    }

    public static void getNewMsgCount(Context context, List<Integer> list, IGetNewMsgCountListener iGetNewMsgCountListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65586, null, context, list, iGetNewMsgCountListener) == null) {
            IMBoxManager.getNewMsgCount(context, list, iGetNewMsgCountListener);
        }
    }

    public static void mediaContactorSetting(Context context, long j2, int i2, long j3, String str, int i3, IMediaContactorSettingListener iMediaContactorSettingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65604, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), str, Integer.valueOf(i3), iMediaContactorSettingListener}) == null) {
            ChatMsgManager.mediaContactorSetting(context, j2, i2, j3, str, i3, iMediaContactorSettingListener);
        }
    }

    public static void mediaDeleteAllChatMsg(Context context, long j2, int i2, long j3, String str, long j4, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65606, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), str, Long.valueOf(j4), iMediaDeleteChatMsgListener}) == null) {
            ChatMsgManager.mediaDeleteChatMsg(context, j2, i2, j3, str, j4, null, iMediaDeleteChatMsgListener);
        }
    }

    public static void mediaDeleteChatMsg(Context context, long j2, int i2, long j3, String str, List<Long> list, IMediaDeleteChatMsgListener iMediaDeleteChatMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65608, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), str, list, iMediaDeleteChatMsgListener}) == null) {
            ChatMsgManager.mediaDeleteChatMsg(context, j2, i2, j3, str, -1L, list, iMediaDeleteChatMsgListener);
        }
    }

    public static void mediaDeleteChatSession(Context context, long j2, int i2, long j3, String str, long j4, IMediaDeleteChatSessionListener iMediaDeleteChatSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65610, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), str, Long.valueOf(j4), iMediaDeleteChatSessionListener}) == null) {
            ChatMsgManager.mediaDeleteChatSession(context, j2, i2, j3, str, j4, iMediaDeleteChatSessionListener);
        }
    }

    public static void mediaFetchChatMsgs(Context context, long j2, int i2, long j3, String str, long j4, long j5, int i3, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65612, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), str, Long.valueOf(j4), Long.valueOf(j5), Integer.valueOf(i3), iMediaFetchChatMsgsListener}) == null) {
            ChatMsgManager.mediaFetchChatMsgs(context, j2, i2, j3, str, j4, j5, i3, iMediaFetchChatMsgsListener);
        }
    }

    public static void mediaGetChatSessions(Context context, long j2, int i2, long j3, String str, long j4, int i3, int i4, IMediaGetChatSessionListener iMediaGetChatSessionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65614, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), str, Long.valueOf(j4), Integer.valueOf(i3), Integer.valueOf(i4), iMediaGetChatSessionListener}) == null) {
            ChatMsgManager.mediaGetChatSessions(context, j2, i2, j3, str, j4, i3, i4, iMediaGetChatSessionListener);
        }
    }

    public static void mediaGetContactorPauid(Context context, long j2, int i2, long j3, String str, IMediaGetContactorPauidListener iMediaGetContactorPauidListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65616, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), str, iMediaGetContactorPauidListener}) == null) {
            ChatMsgManager.mediaGetContactorPauid(context, j2, i2, j3, str, iMediaGetContactorPauidListener);
        }
    }

    public static void mediaGetContactorSetting(Context context, long j2, int i2, long j3, String str, int i3, IMediaContactorSettingListener iMediaContactorSettingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65618, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), str, Integer.valueOf(i3), iMediaContactorSettingListener}) == null) {
            ChatMsgManager.mediaGetContactorSetting(context, j2, i2, j3, str, i3, iMediaContactorSettingListener);
        }
    }

    public static void mediaSendChatMsg(Context context, long j2, int i2, long j3, String str, ChatMsg chatMsg, IMediaSendChatMsgListener iMediaSendChatMsgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65621, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), str, chatMsg, iMediaSendChatMsgListener}) == null) {
            ChatMsgManager.mediaSendChatMsg(context, j2, i2, j3, str, chatMsg, iMediaSendChatMsgListener);
        }
    }

    public static void mediaSetSessionRead(Context context, long j2, int i2, long j3, String str, long j4, IMediaSetSessionReadListener iMediaSetSessionReadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65625, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), str, Long.valueOf(j4), iMediaSetSessionReadListener}) == null) {
            ChatMsgManager.mediaSetSessionRead(context, j2, i2, j3, str, j4, iMediaSetSessionReadListener);
        }
    }

    @Deprecated
    public static boolean setMsgRead(Context context, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65649, null, new Object[]{context, Long.valueOf(j2), Long.valueOf(j3)})) == null) ? ChatMsgManager.setMsgRead(context, 0, j2, j3, false) : invokeCommon.booleanValue;
    }

    public static int deleteMsgs(Context context, long j2, long[] jArr, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{context, Long.valueOf(j2), jArr, Boolean.valueOf(z)})) == null) {
            if (BaseManager.isNullContext(context)) {
                return -1;
            }
            return ChatMsgManagerImpl.getInstance(context).deleteMsgs(0, j2, jArr, z);
        }
        return invokeCommon.intValue;
    }

    @Deprecated
    public static long deleteMsgs(Context context, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65556, null, context, j2)) == null) {
            if (BaseManager.isNullContext(context)) {
                return -1L;
            }
            return ChatMsgManagerImpl.getInstance(context).deleteAllMsgs(0, j2, false);
        }
        return invokeLJ.longValue;
    }

    public static BIMConversation getConversation(Context context, String str, CATEGORY category, String str2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65575, null, new Object[]{context, str, category, str2, Integer.valueOf(i2)})) == null) ? getConversation(context, str, false, category, str2, i2) : (BIMConversation) invokeCommon.objValue;
    }

    public static BIMConversation getConversation(Context context, String str, boolean z, CATEGORY category, String str2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65576, null, new Object[]{context, str, Boolean.valueOf(z), category, str2, Integer.valueOf(i2)})) == null) {
            if (BaseManager.isNullContext(context)) {
                LogUtils.e(BaseManager.TAG, "GETCONVERSATION context is null");
                return null;
            }
            sContext = context;
            if (CATEGORY.ALL != category && CATEGORY.SYSTEM != category) {
                return ConversationStudioManImpl.getInstance(sContext).getConversation(category, str, z, str2, i2);
            }
            LogUtils.e(LogUtils.TAG, "GETCONVERSATION category should not be ALL or SYSTEM");
            return null;
        }
        return (BIMConversation) invokeCommon.objValue;
    }

    public static void login(String str, String str2, int i2, String str3, String str4, ILoginListener iLoginListener) {
        IMTrack.RequestBuilder requestId;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65599, null, new Object[]{str, str2, Integer.valueOf(i2), str3, str4, iLoginListener}) == null) {
            String str6 = BaseManager.TAG;
            LogUtils.d(str6, "HB> im in login, uid = " + str + " ,cuid = " + str2 + ", loginType = " + i2);
            if (BaseManager.isNullContext(sContext)) {
                if (iLoginListener != null) {
                    iLoginListener.onLoginResult(1005, "Context is NULL");
                    return;
                }
                return;
            }
            long j2 = 0;
            try {
                try {
                    String[] loginFlag = Utility.getLoginFlag(sContext);
                    if (loginFlag.length >= 2) {
                        j2 = Long.valueOf(loginFlag[0]).longValue();
                        str5 = loginFlag[1];
                    } else {
                        str5 = "1Y";
                    }
                    requestId = new IMTrack.RequestBuilder(sContext).method(String.valueOf(AccountManagerImpl.getInstance(sContext).getAppOpenType())).requestId(str5);
                } catch (Exception unused) {
                    LogUtils.e(BaseManager.TAG, "IMTrack init request getLoginFlag Exception ");
                    requestId = new IMTrack.RequestBuilder(sContext).method(String.valueOf(AccountManagerImpl.getInstance(sContext).getAppOpenType())).requestId("1Y");
                }
                requestId.requestTime(Utility.getLoginCallTime(sContext)).responseTime(j2).ext(Utility.getLoginFlagExt(sContext)).aliasId(501100L).build();
                Utility.writeLoginCallTime(sContext);
                Context context = sContext;
                Utility.writeLoginFlag(context, "1Y", "context is nonnull, accessToken is null -> " + TextUtils.isEmpty(str2));
                if (TextUtils.isEmpty(str2)) {
                    Utility.writeLoginFlag(sContext, "2N", "accessToken is null");
                    if (iLoginListener != null) {
                        iLoginListener.onLoginResult(1005, "accessToken is NULL");
                        return;
                    }
                    return;
                }
                Context context2 = sContext;
                Utility.writeLoginFlag(context2, "2Y", "accessToken is nonnull, loginType = " + i2);
                if (i2 == 6) {
                    AccountManagerImpl.getInstance(sContext).setCuid(str2);
                    String token = AccountManagerImpl.getInstance(sContext).getToken();
                    if (!TextUtils.isEmpty(token)) {
                        loginExecutor(i2, str, token, str3, str4, iLoginListener);
                        return;
                    }
                    AccountManagerImpl.getInstance(sContext);
                    AccountManagerImpl.mCuidTokenTryTimes = 0;
                    getCuidTokenAndLogin(str2, i2, str3, str4, iLoginListener);
                    return;
                }
                loginExecutor(i2, str, str2, str3, str4, iLoginListener);
            } catch (Throwable th) {
                new IMTrack.RequestBuilder(sContext).method(String.valueOf(AccountManagerImpl.getInstance(sContext).getAppOpenType())).requestId("1Y").requestTime(Utility.getLoginCallTime(sContext)).responseTime(j2).ext(Utility.getLoginFlagExt(sContext)).aliasId(501100L).build();
                throw th;
            }
        }
    }
}
