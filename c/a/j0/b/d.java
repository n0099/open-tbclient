package c.a.j0.b;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d0.h.k;
import c.a.j0.b.f.g;
import c.a.j0.b.f.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d implements c.a.n0.a.h.a, c.a.n0.a.h.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final c.a.n0.a.h.b a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f4260b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final g f4261c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final BaseVM f4262d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public c f4263e;

    /* renamed from: f  reason: collision with root package name */
    public long f4264f;

    /* renamed from: g  reason: collision with root package name */
    public long f4265g;

    /* renamed from: h  reason: collision with root package name */
    public final long f4266h;

    /* renamed from: i  reason: collision with root package name */
    public long f4267i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f4268j;
    public c.a.j0.b.f.c k;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f4269e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4269e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4269e.f4263e.d();
            }
        }
    }

    public d(@NonNull c.a.n0.a.h.b bVar, @NonNull ViewGroup viewGroup, @NonNull g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, viewGroup, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f4268j = true;
        this.f4266h = System.currentTimeMillis();
        this.a = bVar;
        this.f4260b = viewGroup;
        this.f4261c = gVar;
        this.f4262d = new BaseVM(gVar);
        c.a.j0.b.f.b.b(gVar);
    }

    @Override // c.a.n0.a.h.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // c.a.n0.a.h.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.j0.c.d.a(c.a.d0.h.a.b(), this.f4261c.o);
            j(BaseVM.CloseType.CLICK_AD_AREA.value);
            this.f4262d.b("");
            c cVar = this.f4263e;
            if (cVar != null) {
                cVar.b();
            }
        }
    }

    @Override // c.a.n0.a.h.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // c.a.n0.a.h.c
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f4265g = System.currentTimeMillis();
        }
    }

    @Override // c.a.n0.a.h.a
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c cVar = this.f4263e;
            if (cVar != null) {
                cVar.a();
            }
            j(BaseVM.CloseType.CLICK_SKIP_BUTTON.value);
        }
    }

    @Override // c.a.n0.a.h.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // c.a.n0.a.h.c
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f4264f = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("adShowScene", this.f4261c.C);
                jSONObject.put("adSplashType", this.f4261c.f4294e);
                if (this.f4261c.C == 1) {
                    long j2 = this.f4265g - this.f4266h;
                    if (j2 > 0) {
                        jSONObject.put("adLoadCostTime", j2);
                    }
                }
                jSONObject.put("adRenderCostTime", this.f4264f - this.f4266h);
            } catch (JSONException unused) {
            }
            this.f4262d.c(jSONObject);
            c.a.j0.b.f.e.z(this.f4261c);
            i.e(this.f4261c);
            c cVar = this.f4263e;
            if (cVar != null) {
                cVar.onAdShow();
            }
        }
    }

    @Override // c.a.n0.a.h.c
    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f4267i = System.currentTimeMillis() - this.f4264f;
            if ("time_end".equals(str)) {
                j(BaseVM.CloseType.COUNTDOWN_TIME_FINISH.value);
            } else if ("click_skip_button".equals(str)) {
                j(BaseVM.CloseType.CLICK_SKIP_BUTTON.value);
            } else if ("click_ad_area".equals(str)) {
                j(BaseVM.CloseType.CLICK_AD_AREA.value);
            } else {
                j(BaseVM.CloseType.OTHER.value);
            }
            if (this.f4263e != null) {
                k.b(new a(this));
            }
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            c.a.b.f().e();
            if (this.f4268j) {
                this.f4268j = false;
                this.f4262d.e(str, this.f4267i);
            }
        }
    }

    public void k(c.a.j0.b.f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.k = cVar;
            c.a.n0.a.h.b bVar = this.a;
            if (bVar != null) {
                cVar.j(bVar);
            }
        }
    }

    public void l(@NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.f4263e = cVar;
        }
    }

    @Override // c.a.n0.a.h.c
    public void onAdError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f4267i = System.currentTimeMillis() - this.f4264f;
            c cVar = this.f4263e;
            if (cVar != null) {
                cVar.f();
            }
        }
    }
}
