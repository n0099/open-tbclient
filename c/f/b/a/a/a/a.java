package c.f.b.a.a.a;

import android.hardware.Camera;
import android.os.Handler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class a implements Camera.AutoFocusCallback {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final String f32342f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f32343a;

    /* renamed from: b  reason: collision with root package name */
    public long f32344b;

    /* renamed from: c  reason: collision with root package name */
    public volatile Handler f32345c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f32346d;

    /* renamed from: e  reason: collision with root package name */
    public int f32347e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1370934126, "Lc/f/b/a/a/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1370934126, "Lc/f/b/a/a/a/a;");
                return;
            }
        }
        f32342f = a.class.getSimpleName();
    }

    public a() {
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
        this.f32343a = 500L;
        this.f32344b = 500L;
        this.f32346d = false;
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            this.f32343a = j2;
        }
    }

    public synchronized void b(Handler handler, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, handler, i2) == null) {
            synchronized (this) {
                this.f32345c = handler;
                this.f32347e = i2;
            }
        }
    }

    public void c(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            this.f32344b = j2;
        }
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public synchronized void onAutoFocus(boolean z, Camera camera) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048579, this, z, camera) == null) {
            synchronized (this) {
                if (this.f32345c != null) {
                    this.f32345c.sendMessageDelayed(this.f32345c.obtainMessage(this.f32347e, Boolean.valueOf(z)), this.f32346d ? this.f32343a : this.f32344b);
                    this.f32346d = true;
                    this.f32345c = null;
                }
            }
        }
    }
}
