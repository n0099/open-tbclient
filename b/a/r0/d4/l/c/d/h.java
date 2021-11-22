package b.a.r0.d4.l.c.d;

import android.graphics.Bitmap;
import b.a.x0.t.u;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f17164a;

    /* renamed from: b  reason: collision with root package name */
    public String f17165b;

    /* renamed from: c  reason: collision with root package name */
    public float f17166c;

    /* renamed from: d  reason: collision with root package name */
    public long f17167d;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f17168e;

    /* renamed from: f  reason: collision with root package name */
    public int f17169f;

    /* renamed from: g  reason: collision with root package name */
    public int f17170g;

    /* renamed from: h  reason: collision with root package name */
    public int f17171h;

    /* renamed from: i  reason: collision with root package name */
    public int f17172i;
    public f j;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f17173e;

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
            this.f17173e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap bitmap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h hVar = this.f17173e;
                if (hVar.j == null || (bitmap = hVar.f17168e) == null || bitmap.isRecycled()) {
                    return;
                }
                h hVar2 = this.f17173e;
                hVar2.j.onFrameResult(hVar2.f17169f, hVar2.f17168e);
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
