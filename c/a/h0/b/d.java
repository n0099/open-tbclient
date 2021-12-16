package c.a.h0.b;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.h0.b.f.g;
import c.a.h0.b.f.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d implements c.a.l0.a.h.a, c.a.l0.a.h.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final c.a.l0.a.h.b a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f3357b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final g f3358c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final BaseVM f3359d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public c f3360e;

    /* renamed from: f  reason: collision with root package name */
    public long f3361f;

    /* renamed from: g  reason: collision with root package name */
    public long f3362g;

    /* renamed from: h  reason: collision with root package name */
    public final long f3363h;

    /* renamed from: i  reason: collision with root package name */
    public long f3364i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3365j;

    /* renamed from: k  reason: collision with root package name */
    public c.a.h0.b.f.c f3366k;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f3367e;

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
            this.f3367e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f3367e.f3360e.d();
            }
        }
    }

    public d(@NonNull c.a.l0.a.h.b bVar, @NonNull ViewGroup viewGroup, @NonNull g gVar) {
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
        this.f3365j = true;
        this.f3363h = System.currentTimeMillis();
        this.a = bVar;
        this.f3357b = viewGroup;
        this.f3358c = gVar;
        this.f3359d = new BaseVM(gVar);
        c.a.h0.b.f.b.b(gVar);
    }

    @Override // c.a.l0.a.h.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // c.a.l0.a.h.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.h0.c.d.a(c.a.c0.e.a.b(), this.f3358c.o);
            j(BaseVM.CloseType.CLICK_AD_AREA.value);
            this.f3359d.a("");
            c cVar = this.f3360e;
            if (cVar != null) {
                cVar.b();
            }
        }
    }

    @Override // c.a.l0.a.h.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // c.a.l0.a.h.c
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f3362g = System.currentTimeMillis();
        }
    }

    @Override // c.a.l0.a.h.a
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c cVar = this.f3360e;
            if (cVar != null) {
                cVar.a();
            }
            j(BaseVM.CloseType.CLICK_SKIP_BUTTON.value);
        }
    }

    @Override // c.a.l0.a.h.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // c.a.l0.a.h.c
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f3361f = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("adShowScene", this.f3358c.C);
                jSONObject.put("adSplashType", this.f3358c.f3389e);
                if (this.f3358c.C == 1) {
                    long j2 = this.f3362g - this.f3363h;
                    if (j2 > 0) {
                        jSONObject.put("adLoadCostTime", j2);
                    }
                }
                jSONObject.put("adRenderCostTime", this.f3361f - this.f3363h);
            } catch (JSONException unused) {
            }
            this.f3359d.b(jSONObject);
            c.a.h0.b.f.e.z(this.f3358c);
            i.c(this.f3358c);
            c cVar = this.f3360e;
            if (cVar != null) {
                cVar.onAdShow();
            }
        }
    }

    @Override // c.a.l0.a.h.c
    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f3364i = System.currentTimeMillis() - this.f3361f;
            if ("time_end".equals(str)) {
                j(BaseVM.CloseType.COUNTDOWN_TIME_FINISH.value);
            } else if ("click_skip_button".equals(str)) {
                j(BaseVM.CloseType.CLICK_SKIP_BUTTON.value);
            } else if ("click_ad_area".equals(str)) {
                j(BaseVM.CloseType.CLICK_AD_AREA.value);
            } else {
                j(BaseVM.CloseType.OTHER.value);
            }
            if (this.f3360e != null) {
                c.a.l0.a.l.a.a(new a(this));
            }
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            c.a.b.f().e();
            if (this.f3365j) {
                this.f3365j = false;
                this.f3359d.d(str, this.f3364i);
            }
        }
    }

    public void k(c.a.h0.b.f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.f3366k = cVar;
            c.a.l0.a.h.b bVar = this.a;
            if (bVar != null) {
                cVar.j(bVar);
            }
        }
    }

    public void l(@NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.f3360e = cVar;
        }
    }

    @Override // c.a.l0.a.h.c
    public void onAdError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f3364i = System.currentTimeMillis() - this.f3361f;
            c cVar = this.f3360e;
            if (cVar != null) {
                cVar.c(str);
            }
        }
    }
}
