package c.a.t0.n4.m.c.d;

import android.graphics.Bitmap;
import c.a.a1.t.u;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f20544b;

    /* renamed from: c  reason: collision with root package name */
    public float f20545c;

    /* renamed from: d  reason: collision with root package name */
    public long f20546d;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f20547e;

    /* renamed from: f  reason: collision with root package name */
    public int f20548f;

    /* renamed from: g  reason: collision with root package name */
    public int f20549g;

    /* renamed from: h  reason: collision with root package name */
    public int f20550h;

    /* renamed from: i  reason: collision with root package name */
    public int f20551i;

    /* renamed from: j  reason: collision with root package name */
    public f f20552j;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f20553e;

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
            this.f20553e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap bitmap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h hVar = this.f20553e;
                if (hVar.f20552j == null || (bitmap = hVar.f20547e) == null || bitmap.isRecycled()) {
                    return;
                }
                h hVar2 = this.f20553e;
                hVar2.f20552j.onFrameResult(hVar2.f20548f, hVar2.f20547e);
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
