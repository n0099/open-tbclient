package c.a.t0.n4.m.c.d;

import android.graphics.Bitmap;
import c.a.a1.t.u;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f20096b;

    /* renamed from: c  reason: collision with root package name */
    public float f20097c;

    /* renamed from: d  reason: collision with root package name */
    public long f20098d;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f20099e;

    /* renamed from: f  reason: collision with root package name */
    public int f20100f;

    /* renamed from: g  reason: collision with root package name */
    public int f20101g;

    /* renamed from: h  reason: collision with root package name */
    public int f20102h;

    /* renamed from: i  reason: collision with root package name */
    public int f20103i;

    /* renamed from: j  reason: collision with root package name */
    public f f20104j;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f20105e;

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
            this.f20105e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap bitmap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h hVar = this.f20105e;
                if (hVar.f20104j == null || (bitmap = hVar.f20099e) == null || bitmap.isRecycled()) {
                    return;
                }
                h hVar2 = this.f20105e;
                hVar2.f20104j.onFrameResult(hVar2.f20100f, hVar2.f20099e);
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
