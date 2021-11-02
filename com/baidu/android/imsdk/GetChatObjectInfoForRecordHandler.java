package com.baidu.android.imsdk;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.db.DBManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.MethodInvokeUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public abstract class GetChatObjectInfoForRecordHandler {
    public static /* synthetic */ Interceptable $ic;
    public static Method method;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public String mUuid;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-255394825, "Lcom/baidu/android/imsdk/GetChatObjectInfoForRecordHandler;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-255394825, "Lcom/baidu/android/imsdk/GetChatObjectInfoForRecordHandler;");
        }
    }

    public GetChatObjectInfoForRecordHandler(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context;
    }

    public void deleteUUid() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            DBManager.getInstance(this.mContext).deleteCmdMsg(this.mUuid);
        }
    }

    public abstract void getChatObjectInfo(long j, CallBack callBack);

    public boolean getChatObjectInfoSync(Context context, long j, CallBack callBack) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Long.valueOf(j), callBack})) == null) {
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public String getUuid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mUuid : (String) invokeV.objValue;
    }

    public void setUuid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.mUuid = str;
        }
    }

    public abstract void updateChatRecord(ChatObject chatObject, int i2, int i3, Object obj);

    public void updateChatRecord(ChatObject chatObject, String str, int i2, String str2, int i3, String str3, String str4, int i4, int i5, long j, int i6, long j2, String str5, String str6, String str7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{chatObject, str, Integer.valueOf(i2), str2, Integer.valueOf(i3), str3, str4, Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(j), Integer.valueOf(i6), Long.valueOf(j2), str5, str6, str7}) == null) {
            Object[] objArr = {this.mContext, chatObject, str, Integer.valueOf(i2), str2, Integer.valueOf(i3), str3, str4, Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(j), Integer.valueOf(i6), Long.valueOf(j2), str5, str6, str7};
            Class<?> cls = Integer.TYPE;
            updateChatRecord("com.baidu.android.imsdk.chatmessage.ChatMsgManager", "createChatSession", new Class[]{Context.class, ChatObject.class, String.class, cls, String.class, cls, String.class, String.class, cls, cls, Long.TYPE, Integer.TYPE, Long.TYPE, String.class, String.class, String.class}, objArr);
        }
    }

    private void updateChatRecord(String str, String str2, Class<?>[] clsArr, Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, this, str, str2, clsArr, objArr) == null) {
            Class<?> cls = null;
            try {
                if (method == null) {
                    cls = Class.forName(str);
                    if (cls == null) {
                        return;
                    }
                    method = cls.getDeclaredMethod(str2, clsArr);
                }
                if (method != null) {
                    MethodInvokeUtil.invoke(method, cls, objArr);
                }
            } catch (Exception e2) {
                LogUtils.e(LogUtils.TAG, "Exception ", e2);
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            }
        }
    }
}
