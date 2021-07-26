package com.baidu.cyberplayer.sdk.statistics;

import com.baidu.cyberplayer.sdk.Keep;
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
    @Keep
    public static final int PLAY_SESSION_STAGE_TYPE_UBC_LIVE = -1002;
    @Keep
    public static final int PLAY_SESSION_STAGE_TYPE_UBC_VOD = -1001;

    /* renamed from: a  reason: collision with root package name */
    public static UbcSessionUploader f5069a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Object f5070b;

    /* renamed from: c  reason: collision with root package name */
    public Method f5071c;

    public UbcSessionUploader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f5070b = null;
        this.f5071c = null;
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
                    this.f5070b = cls2.getDeclaredMethod("getService", Class.forName("com.baidu.pyramid.runtime.service.ServiceReference")).invoke(null, declaredField.get(null));
                    this.f5071c = cls.getDeclaredMethod("onEvent", String.class, String.class);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Keep
    public static synchronized UbcSessionUploader getInstance() {
        InterceptResult invokeV;
        UbcSessionUploader ubcSessionUploader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (UbcSessionUploader.class) {
                if (f5069a == null) {
                    f5069a = new UbcSessionUploader();
                }
                ubcSessionUploader = f5069a;
            }
            return ubcSessionUploader;
        }
        return (UbcSessionUploader) invokeV.objValue;
    }

    @Keep
    public void upload(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048576, this, str, str2, i2) == null) || !com.baidu.cyberplayer.sdk.c.a().d() || this.f5071c == null || this.f5070b == null) {
            return;
        }
        try {
            this.f5071c.invoke(this.f5070b, i2 == -1001 ? "2360" : "2368", str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
