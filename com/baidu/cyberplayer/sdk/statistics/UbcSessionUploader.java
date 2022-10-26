package com.baidu.cyberplayer.sdk.statistics;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public final class UbcSessionUploader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PLAY_SESSION_STAGE_TYPE_UBC_LIVE = -1002;
    public static final int PLAY_SESSION_STAGE_TYPE_UBC_VOD = -1001;
    public static UbcSessionUploader a;
    public transient /* synthetic */ FieldHolder $fh;
    public Object b;
    public Method c;

    public UbcSessionUploader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = null;
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            try {
                Class<?> cls = Class.forName("com.baidu.ubc.UBCManager");
                Class<?> cls2 = Class.forName("com.baidu.pyramid.runtime.service.ServiceManager");
                Field declaredField = cls.getDeclaredField("SERVICE_REFERENCE");
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                    this.b = cls2.getDeclaredMethod("getService", Class.forName("com.baidu.pyramid.runtime.service.ServiceReference")).invoke(null, declaredField.get(null));
                    this.c = cls.getDeclaredMethod("onEvent", String.class, String.class);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized UbcSessionUploader getInstance() {
        InterceptResult invokeV;
        UbcSessionUploader ubcSessionUploader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (UbcSessionUploader.class) {
                if (a == null) {
                    a = new UbcSessionUploader();
                }
                ubcSessionUploader = a;
            }
            return ubcSessionUploader;
        }
        return (UbcSessionUploader) invokeV.objValue;
    }

    public void upload(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048576, this, str, str2, i) == null) || !com.baidu.cyberplayer.sdk.c.a().d() || this.c == null || this.b == null) {
            return;
        }
        try {
            this.c.invoke(this.b, i == -1001 ? "2360" : "2368", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
