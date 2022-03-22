package c.a.f0.b;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.a0.h.k;
import c.a.f0.b.f.g;
import c.a.f0.b.f.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d implements c.a.i0.a.h.a, c.a.i0.a.h.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final c.a.i0.a.h.b a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f2907b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final g f2908c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final BaseVM f2909d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public c f2910e;

    /* renamed from: f  reason: collision with root package name */
    public long f2911f;

    /* renamed from: g  reason: collision with root package name */
    public long f2912g;

    /* renamed from: h  reason: collision with root package name */
    public final long f2913h;
    public long i;
    public boolean j;
    public c.a.f0.b.f.c k;

    /* loaded from: classes.dex */
    public class a implements c.a.f0.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.f0.c.a
        public boolean d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (this.a.f2910e != null) {
                    return this.a.f2910e.d(str);
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f2910e.e();
            }
        }
    }

    public d(@NonNull c.a.i0.a.h.b bVar, @NonNull ViewGroup viewGroup, @NonNull g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, viewGroup, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = true;
        this.f2913h = System.currentTimeMillis();
        this.a = bVar;
        this.f2907b = viewGroup;
        this.f2908c = gVar;
        this.f2909d = new BaseVM(gVar);
        c.a.f0.b.f.b.b(gVar);
    }

    @Override // c.a.i0.a.h.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // c.a.i0.a.h.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.f0.c.d.a(c.a.a0.h.a.b(), this.f2908c.o, new a(this));
            j(BaseVM.CloseType.CLICK_AD_AREA.value);
            this.f2909d.b("");
            c cVar = this.f2910e;
            if (cVar != null) {
                cVar.b();
            }
        }
    }

    @Override // c.a.i0.a.h.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // c.a.i0.a.h.c
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f2912g = System.currentTimeMillis();
        }
    }

    @Override // c.a.i0.a.h.a
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c cVar = this.f2910e;
            if (cVar != null) {
                cVar.a();
            }
            j(BaseVM.CloseType.CLICK_SKIP_BUTTON.value);
        }
    }

    @Override // c.a.i0.a.h.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // c.a.i0.a.h.c
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f2911f = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("adShowScene", this.f2908c.C);
                jSONObject.put("adSplashType", this.f2908c.f2933e);
                if (this.f2908c.C == 1) {
                    long j = this.f2912g - this.f2913h;
                    if (j > 0) {
                        jSONObject.put("adLoadCostTime", j);
                    }
                }
                jSONObject.put("adRenderCostTime", this.f2911f - this.f2913h);
            } catch (JSONException unused) {
            }
            this.f2909d.c(jSONObject);
            c.a.f0.b.f.e.B(this.f2908c);
            i.e(this.f2908c);
            c cVar = this.f2910e;
            if (cVar != null) {
                cVar.onAdShow();
            }
        }
    }

    @Override // c.a.i0.a.h.c
    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.i = System.currentTimeMillis() - this.f2911f;
            if ("time_end".equals(str)) {
                j(BaseVM.CloseType.COUNTDOWN_TIME_FINISH.value);
            } else if ("click_skip_button".equals(str)) {
                j(BaseVM.CloseType.CLICK_SKIP_BUTTON.value);
            } else if ("click_ad_area".equals(str)) {
                j(BaseVM.CloseType.CLICK_AD_AREA.value);
            } else {
                j(BaseVM.CloseType.OTHER.value);
            }
            if (this.f2910e != null) {
                k.b(new b(this));
            }
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            c.a.b.f().e();
            if (this.j) {
                this.j = false;
                this.f2909d.e(str, this.i);
            }
        }
    }

    public void k(c.a.f0.b.f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.k = cVar;
            c.a.i0.a.h.b bVar = this.a;
            if (bVar != null) {
                cVar.j(bVar);
            }
        }
    }

    public void l(@NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.f2910e = cVar;
        }
    }

    @Override // c.a.i0.a.h.c
    public void onAdError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.i = System.currentTimeMillis() - this.f2911f;
            c cVar = this.f2910e;
            if (cVar != null) {
                cVar.g();
            }
        }
    }
}
