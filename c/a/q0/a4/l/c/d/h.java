package c.a.q0.a4.l.c.d;

import android.graphics.Bitmap;
import c.a.w0.t.u;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f15816a;

    /* renamed from: b  reason: collision with root package name */
    public String f15817b;

    /* renamed from: c  reason: collision with root package name */
    public float f15818c;

    /* renamed from: d  reason: collision with root package name */
    public long f15819d;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f15820e;

    /* renamed from: f  reason: collision with root package name */
    public int f15821f;

    /* renamed from: g  reason: collision with root package name */
    public int f15822g;

    /* renamed from: h  reason: collision with root package name */
    public int f15823h;

    /* renamed from: i  reason: collision with root package name */
    public int f15824i;

    /* renamed from: j  reason: collision with root package name */
    public f f15825j;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f15826e;

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
            this.f15826e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap bitmap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h hVar = this.f15826e;
                if (hVar.f15825j == null || (bitmap = hVar.f15820e) == null || bitmap.isRecycled()) {
                    return;
                }
                h hVar2 = this.f15826e;
                hVar2.f15825j.onFrameResult(hVar2.f15821f, hVar2.f15820e);
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
