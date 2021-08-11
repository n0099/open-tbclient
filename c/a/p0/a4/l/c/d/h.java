package c.a.p0.a4.l.c.d;

import android.graphics.Bitmap;
import c.a.v0.t.u;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f15530a;

    /* renamed from: b  reason: collision with root package name */
    public String f15531b;

    /* renamed from: c  reason: collision with root package name */
    public float f15532c;

    /* renamed from: d  reason: collision with root package name */
    public long f15533d;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f15534e;

    /* renamed from: f  reason: collision with root package name */
    public int f15535f;

    /* renamed from: g  reason: collision with root package name */
    public int f15536g;

    /* renamed from: h  reason: collision with root package name */
    public int f15537h;

    /* renamed from: i  reason: collision with root package name */
    public int f15538i;

    /* renamed from: j  reason: collision with root package name */
    public f f15539j;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f15540e;

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
            this.f15540e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap bitmap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h hVar = this.f15540e;
                if (hVar.f15539j == null || (bitmap = hVar.f15534e) == null || bitmap.isRecycled()) {
                    return;
                }
                h hVar2 = this.f15540e;
                hVar2.f15539j.onFrameResult(hVar2.f15535f, hVar2.f15534e);
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
