package c.a.r0.b4.l.c.d;

import android.graphics.Bitmap;
import c.a.x0.t.u;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f16359a;

    /* renamed from: b  reason: collision with root package name */
    public String f16360b;

    /* renamed from: c  reason: collision with root package name */
    public float f16361c;

    /* renamed from: d  reason: collision with root package name */
    public long f16362d;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f16363e;

    /* renamed from: f  reason: collision with root package name */
    public int f16364f;

    /* renamed from: g  reason: collision with root package name */
    public int f16365g;

    /* renamed from: h  reason: collision with root package name */
    public int f16366h;

    /* renamed from: i  reason: collision with root package name */
    public int f16367i;

    /* renamed from: j  reason: collision with root package name */
    public f f16368j;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f16369e;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16369e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap bitmap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h hVar = this.f16369e;
                if (hVar.f16368j == null || (bitmap = hVar.f16363e) == null || bitmap.isRecycled()) {
                    return;
                }
                h hVar2 = this.f16369e;
                hVar2.f16368j.onFrameResult(hVar2.f16364f, hVar2.f16363e);
            }
        }
    }

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            u.a().post(new a(this));
        }
    }
}
