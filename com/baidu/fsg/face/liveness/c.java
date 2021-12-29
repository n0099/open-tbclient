package com.baidu.fsg.face.liveness;

import android.content.Context;
import com.baidu.fsg.base.utils.ResUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f35423b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final String f35424c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f35425d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f35426e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public Context f35427f;

    /* loaded from: classes10.dex */
    public class a extends com.baidu.fsg.face.base.c.a {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f35428b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f35429c = 5;

        /* renamed from: d  reason: collision with root package name */
        public static final int f35430d = -306;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f35431e;

        /* renamed from: f  reason: collision with root package name */
        public String f35432f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f35433g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f35434h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f35435i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c f35436j;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35436j = cVar;
            this.f35434h = true;
            this.f35435i = false;
            this.msgMap.put(1, c.f35424c);
            this.msgMap.put(2, c.f35425d);
            this.msgMap.put(-306, c.f35426e);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2133310485, "Lcom/baidu/fsg/face/liveness/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2133310485, "Lcom/baidu/fsg/face/liveness/c;");
                return;
            }
        }
        f35424c = ResUtils.string("error_msg_get_userinfo_failure");
        f35425d = ResUtils.string("error_msg_upload_failure");
        f35426e = ResUtils.string("error_msg_image_file_empty");
    }

    public c(Context context) {
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
        this.f35427f = context;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }
}
