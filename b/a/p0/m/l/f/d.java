package b.a.p0.m.l.f;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import b.a.p0.a.h2.c.i;
import b.a.p0.a.h2.c.j.b;
import b.a.p0.a.v1.g;
import b.a.p0.a.z2.q0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements b.a.p0.a.z2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f11606e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11606e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (b.a.p0.a.h2.c.d.h(iVar)) {
                    d.c(this.f11606e);
                } else {
                    this.f11606e.onFail();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f11607a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11607a = cVar;
        }

        @Override // b.a.p0.a.v1.g.a
        public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, strArr, iArr) == null) {
                if (i2 != 0) {
                    this.f11607a.onFail();
                    return;
                }
                for (int i3 : iArr) {
                    if (i3 == -1) {
                        this.f11607a.onFail();
                        return;
                    }
                }
                this.f11607a.onSuccess();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void onFail();

        void onSuccess();
    }

    public static void b(Context context, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, cVar) == null) {
            if (!(context instanceof Activity)) {
                cVar.onFail();
                return;
            }
            b.a.p0.a.d2.e L = b.a.p0.a.d2.e.L();
            if (L != null) {
                L.d0().g((Activity) context, "mapp_location", new a(cVar));
            }
        }
    }

    public static void c(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, cVar) == null) {
            b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
            if (q0.M() && a0 != null) {
                cVar.onSuccess();
            } else {
                a0.x().requestPermissionsExt(0, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, new b(cVar));
            }
        }
    }
}
