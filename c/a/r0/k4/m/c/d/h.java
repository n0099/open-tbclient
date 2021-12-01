package c.a.r0.k4.m.c.d;

import android.graphics.Bitmap;
import c.a.x0.t.u;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f19023b;

    /* renamed from: c  reason: collision with root package name */
    public float f19024c;

    /* renamed from: d  reason: collision with root package name */
    public long f19025d;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f19026e;

    /* renamed from: f  reason: collision with root package name */
    public int f19027f;

    /* renamed from: g  reason: collision with root package name */
    public int f19028g;

    /* renamed from: h  reason: collision with root package name */
    public int f19029h;

    /* renamed from: i  reason: collision with root package name */
    public int f19030i;

    /* renamed from: j  reason: collision with root package name */
    public f f19031j;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f19032e;

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
            this.f19032e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap bitmap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h hVar = this.f19032e;
                if (hVar.f19031j == null || (bitmap = hVar.f19026e) == null || bitmap.isRecycled()) {
                    return;
                }
                h hVar2 = this.f19032e;
                hVar2.f19031j.onFrameResult(hVar2.f19027f, hVar2.f19026e);
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
