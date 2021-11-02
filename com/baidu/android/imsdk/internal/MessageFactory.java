package com.baidu.android.imsdk.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class MessageFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MessageFactory";
    public static MessageFactory mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<Integer, Class<?>> classMap;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2046905939, "Lcom/baidu/android/imsdk/internal/MessageFactory;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2046905939, "Lcom/baidu/android/imsdk/internal/MessageFactory;");
        }
    }

    @SuppressLint({"UseSparseArrays"})
    public MessageFactory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.classMap = null;
        this.classMap = new HashMap();
    }

    public static MessageFactory getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (mInstance == null) {
                mInstance = new MessageFactory();
            }
            return mInstance;
        }
        return (MessageFactory) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v3, resolved type: java.lang.reflect.Method */
    /* JADX WARN: Multi-variable type inference failed */
    private Message invokeMethod(Context context, String str, int i2, Class<?>[] clsArr, Object[] objArr, Intent intent) {
        InterceptResult invokeCommon;
        Message message;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{context, str, Integer.valueOf(i2), clsArr, objArr, intent})) == null) {
            synchronized (mInstance) {
                Message message2 = null;
                if (this.classMap.isEmpty()) {
                    return null;
                }
                Class<?> cls = this.classMap.get(Integer.valueOf(i2));
                if (cls == null) {
                    LogUtils.d(TAG, ": don't hava class ,type=" + i2);
                    return null;
                }
                try {
                    Method method = cls.getMethod(str, clsArr);
                    if (method != 0) {
                        try {
                            message2 = (Message) method.invoke(cls, objArr);
                        } catch (Exception e2) {
                            e = e2;
                            Message message3 = message2;
                            message2 = method;
                            message = message3;
                            new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e)).build();
                            LogUtils.e(LogUtils.TAG, "IllegalArgumentException " + cls.getSimpleName() + ":" + message2, e);
                            message2 = message;
                            return message2;
                        }
                    }
                    if (intent != null && message2 != null && intent.hasExtra(Constants.EXTRA_LISTENER_ID)) {
                        message2.setListenerKey(intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
                    }
                } catch (Exception e3) {
                    e = e3;
                    message = null;
                }
                return message2;
            }
        }
        return (Message) invokeCommon.objValue;
    }

    public void addType(int i2, Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, cls) == null) {
            synchronized (mInstance) {
                try {
                    this.classMap.put(Integer.valueOf(i2), cls);
                } catch (SecurityException e2) {
                    LogUtils.e(LogUtils.TAG, "", e2);
                }
            }
        }
    }

    public Message createNewMessage(Context context, int i2, Intent intent) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2, intent)) == null) ? invokeMethod(context, "newInstance", i2, new Class[]{Context.class, Intent.class}, new Object[]{context, intent}, intent) : (Message) invokeLIL.objValue;
    }

    public Message parseMessage(Context context, int i2, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Integer.valueOf(i2), str, str2, str3})) == null) ? invokeMethod(context, "parseBody", i2, new Class[]{Context.class, String.class, String.class, String.class}, new Object[]{context, str, str2, str3}, null) : (Message) invokeCommon.objValue;
    }
}
