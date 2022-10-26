package com.baidu.android.imsdk;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatuser.Utility;
import com.baidu.android.imsdk.db.DBManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class GetChatObjectInfoForRecordManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int RETRYTIMES = 2;
    public static String TAG = null;
    public static final int TYPE_BOX_PA = 1;
    public static final int TYPE_DEFAULT = 0;
    public static final int TYPE_DUMI_PA = 100;
    public static final int TYPE_GROUP_DISCUSS = 3;
    public static final int TYPE_GROUP_STAR = 4;
    public static final int TYPE_IP = 10;
    public static final int TYPE_USER = 0;
    public static Map classFinder;
    public static String[] classNameArray;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-134197260, "Lcom/baidu/android/imsdk/GetChatObjectInfoForRecordManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-134197260, "Lcom/baidu/android/imsdk/GetChatObjectInfoForRecordManager;");
                return;
            }
        }
        classNameArray = new String[]{"com.baidu.android.imsdk.chatuser.GetUserInfoForRecordHandler", "com.baidu.android.imsdk.group.GetGroupfoForRecordHandler", "com.baidu.android.imsdk.pubaccount.GetPaInfoForSessionHandler", "com.baidu.android.imsdk.group.GetFansGroupInfoForRecordHandler"};
        TAG = GetChatObjectInfoForRecordManager.class.getSimpleName();
        HashMap hashMap = new HashMap();
        classFinder = hashMap;
        hashMap.put(new Pair(0, 0), classNameArray[0]);
        classFinder.put(new Pair(1, 0), classNameArray[1]);
        classFinder.put(new Pair(0, 1), classNameArray[2]);
        classFinder.put(new Pair(1, 57), classNameArray[3]);
    }

    public GetChatObjectInfoForRecordManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void getChatObjectForSession(Context context, ChatObject chatObject) {
        GetChatObjectInfoForRecordHandler getChatObjectInfoForRecordHandler;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65539, null, context, chatObject) != null) || (getChatObjectInfoForRecordHandler = (GetChatObjectInfoForRecordHandler) newInstance(context, chatObject.getCategory(), chatObject.getContacter(), chatObject.getType())) == null) {
            return;
        }
        String chatObject2 = chatObject.toString();
        DBManager.getInstance(context).saveCmdMsg(chatObject2, Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, chatObject.toString(), null, 15, 2);
        getChatObjectInfoForRecordHandler.setUuid(chatObject2);
        DBManager.getInstance(context).updateCmdMsgSendStatus(chatObject2, 2);
        getChatObjectInfoForRecordHandler.getChatObjectInfo(chatObject.getContacter(), new CallBack(getChatObjectInfoForRecordHandler, chatObject, context, chatObject2) { // from class: com.baidu.android.imsdk.GetChatObjectInfoForRecordManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int retryTimes;
            public final /* synthetic */ Context val$context;
            public final /* synthetic */ ChatObject val$fChatObject;
            public final /* synthetic */ GetChatObjectInfoForRecordHandler val$handler;
            public final /* synthetic */ String val$uuid;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {getChatObjectInfoForRecordHandler, chatObject, context, chatObject2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$handler = getChatObjectInfoForRecordHandler;
                this.val$fChatObject = chatObject;
                this.val$context = context;
                this.val$uuid = chatObject2;
                this.retryTimes = 0;
            }

            @Override // com.baidu.android.imsdk.CallBack
            public void onError(int i, int i2, long j) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                    String str = GetChatObjectInfoForRecordManager.TAG;
                    LogUtils.i(str, "testsession callback type ," + i + " ,category :" + i2 + ", contacterId" + j);
                    if (i2 == 0 && i == 10) {
                        this.val$handler.updateChatRecord(this.val$fChatObject, Utility.createAnonyMousUserName(null), 0, "", 0, "", "", 0, 0, 0L, 0, 0L, "", "", "");
                        return;
                    }
                    int i3 = this.retryTimes + 1;
                    this.retryTimes = i3;
                    if (i3 >= 2) {
                        DBManager.getInstance(this.val$context).updateCmdMsgSendStatus(this.val$uuid, 1);
                    } else {
                        this.val$handler.getChatObjectInfo(this.val$fChatObject.getContacter(), this);
                    }
                }
            }

            @Override // com.baidu.android.imsdk.CallBack
            public void onSuccess(int i, int i2, Object obj) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj) == null) && obj != null) {
                    if (i2 == 0 || i2 == 1) {
                        String str = GetChatObjectInfoForRecordManager.TAG;
                        LogUtils.i(str, "testsession callback" + obj.toString());
                        this.val$handler.updateChatRecord(this.val$fChatObject, i, i2, obj);
                        DBManager.getInstance(this.val$context).deleteCmdMsg(this.val$uuid);
                    }
                }
            }
        });
    }

    public static Object newInstance(Context context, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i, i2)) == null) {
            String str = (String) classFinder.get(new Pair(Integer.valueOf(i), Integer.valueOf(i2)));
            String str2 = TAG;
            LogUtils.i(str2, "className : " + str);
            if (str == null) {
                return null;
            }
            try {
                return Class.forName(str).getConstructor(Context.class).newInstance(context);
            } catch (Exception e) {
                LogUtils.e(LogUtils.TAG, "Class.forName error", e);
                new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e)).build();
                return null;
            }
        }
        return invokeLII.objValue;
    }

    public static Object newInstance(Context context, int i, long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2)})) == null) {
            if (i == 0) {
                if ((j & Constants.PAFLAG) == 0) {
                    return newInstance(context, i, 0);
                }
                return newInstance(context, i, 1);
            } else if (i == 1 && i2 == 57) {
                return newInstance(context, i, i2);
            } else {
                return newInstance(context, i, 0);
            }
        }
        return invokeCommon.objValue;
    }
}
