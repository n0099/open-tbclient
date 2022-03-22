package c.a.n0.n;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.n.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f implements e, c.a.n0.n.j.b, View.OnKeyListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public int f9089b;

    /* renamed from: c  reason: collision with root package name */
    public Context f9090c;

    /* renamed from: d  reason: collision with root package name */
    public int f9091d;

    /* renamed from: e  reason: collision with root package name */
    public h f9092e;

    /* renamed from: f  reason: collision with root package name */
    public List<g> f9093f;

    /* renamed from: g  reason: collision with root package name */
    public List<g> f9094g;

    /* renamed from: h  reason: collision with root package name */
    public List<List<g>> f9095h;
    public e i;
    public c.a.n0.n.j.b j;
    public View.OnKeyListener k;
    public c l;
    public c.a.n0.n.b m;
    public boolean n;
    public int o;
    public boolean p;

    /* loaded from: classes2.dex */
    public class a implements PopupWindow.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            f fVar;
            c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = (fVar = this.a).l) == null) {
                return;
            }
            cVar.a(fVar, false);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // c.a.n0.n.b.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.l(i);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(f fVar, boolean z);
    }

    public f(Context context, View view, int i, c.a.n0.n.b bVar, @Nullable c.a.n0.n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view, Integer.valueOf(i), bVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f9089b = 0;
        this.f9093f = new ArrayList();
        this.f9094g = new ArrayList();
        this.f9095h = new ArrayList();
        this.o = -1;
        this.p = false;
        if (i < 0) {
            return;
        }
        this.f9090c = context;
        this.f9091d = i;
        this.m = bVar;
        this.p = bVar.a();
        List<g> b2 = i.b(this.f9091d);
        this.f9093f = b2;
        this.m.d(this.f9091d, b2);
        this.m.e(this.f9091d, this.f9093f);
        if (this.m.a()) {
            this.m.c(this.f9091d, this.f9093f);
        }
        h hVar = new h(this.f9090c, view, aVar);
        this.f9092e = hVar;
        hVar.I(new a(this));
    }

    public void A(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            int optInt = jSONObject.optInt("pa_type");
            Long valueOf = Long.valueOf(jSONObject.optLong("pa_unread_sums"));
            int i = optInt != 7 ? optInt != 666 ? optInt != 888 ? optInt != 999 ? -1 : 48 : 47 : 46 : 45;
            if (i < 0) {
                return;
            }
            for (g gVar : this.f9094g) {
                if (gVar.c() == i) {
                    valueOf = Long.valueOf(valueOf.longValue() + gVar.e());
                    gVar.o(valueOf.longValue() > 0 ? 1 : 0);
                    gVar.n(valueOf.longValue());
                }
            }
        }
    }

    public final g B(g gVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, z)) == null) {
            if (gVar == null) {
                return null;
            }
            gVar.q(z ? R.string.obfuscated_res_0x7f0f00ee : R.string.obfuscated_res_0x7f0f00f1);
            gVar.m(z ? R.drawable.obfuscated_res_0x7f0800e2 : R.drawable.obfuscated_res_0x7f0800f5);
            return gVar;
        }
        return (g) invokeLZ.objValue;
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            B(h(5), z);
            v();
            this.f9092e.R();
            k();
        }
    }

    @Override // c.a.n0.n.j.b
    public boolean a(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, gVar)) == null) {
            if (r(gVar) && !this.a) {
                g(true);
            }
            c.a.n0.n.j.b bVar = this.j;
            if (bVar != null) {
                return bVar.a(gVar);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.n0.n.e
    public boolean b(View view, g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, view, gVar)) == null) {
            if (gVar.i()) {
                if (r(gVar)) {
                    g(true);
                }
                e eVar = this.i;
                if (eVar != null) {
                    return eVar.b(view, gVar);
                }
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void d(int i, int i2) {
        g a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            boolean z = false;
            for (g gVar : this.f9093f) {
                if (gVar.c() == i) {
                    z = true;
                }
            }
            if (z || (a2 = i.a(i)) == null) {
                return;
            }
            int size = this.f9093f.size();
            if (i2 <= 0) {
                i2 = 0;
            } else if (i2 >= size) {
                i2 = size;
            }
            this.f9093f.add(i2, a2);
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.f9091d = i;
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            g(true);
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f9092e.S(z);
            c cVar = this.l;
            if (cVar != null) {
                cVar.a(this, false);
            }
        }
    }

    public g h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            for (int i2 = 0; i2 < this.f9093f.size(); i2++) {
                g gVar = this.f9093f.get(i2);
                if (gVar != null && gVar.c() == i) {
                    gVar.n(0L);
                    gVar.p(this);
                    return gVar;
                }
            }
            return null;
        }
        return (g) invokeI.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            h hVar = this.f9092e;
            return hVar != null && hVar.x();
        }
        return invokeV.booleanValue;
    }

    public void k() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (hVar = this.f9092e) == null) {
            return;
        }
        hVar.U();
    }

    public final void l(int i) {
        g h2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i) == null) && (h2 = h(i)) != null && h2.j()) {
            this.f9094g.add(h2);
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i) == null) || this.f9093f == null) {
            return;
        }
        int i2 = -1;
        for (int i3 = 0; i3 < this.f9093f.size(); i3++) {
            if (this.f9093f.get(i3).c() == i) {
                i2 = i3;
            }
        }
        if (i2 > -1) {
            this.f9093f.remove(i2);
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.f9092e.V(i);
        }
    }

    public void o(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, eVar) == null) {
            this.i = eVar;
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048592, this, view, i, keyEvent)) == null) {
            View.OnKeyListener onKeyListener = this.k;
            if (onKeyListener != null) {
                return onKeyListener.onKey(view, i, keyEvent);
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.f9089b = i;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.n = z;
        }
    }

    public final boolean r(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, gVar)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            t(z, 0);
        }
    }

    public void t(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            u(z, i, null, false);
        }
    }

    public void u(boolean z, int i, View view, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), view, Boolean.valueOf(z2)}) == null) {
            if (j()) {
                g(true);
                return;
            }
            x(z, i);
            v();
            this.f9092e.W(this.f9095h, view, z2, this.f9089b);
            c cVar = this.l;
            if (cVar != null) {
                cVar.a(this, true);
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.f9095h.clear();
            if (this.m.a()) {
                this.f9095h.add(this.f9094g);
                return;
            }
            int size = this.f9094g.size();
            if (size > 0 && size <= 5) {
                this.f9095h.add(this.f9094g);
            } else if (size > 5 && size <= 10) {
                int i = this.a ? 5 : this.o;
                this.f9095h.add(this.f9094g.subList(0, i));
                this.f9095h.add(this.f9094g.subList(i, size));
            } else if (size > 10) {
                int ceil = this.a ? (int) Math.ceil(size / 2.0f) : this.o;
                this.f9095h.add(this.f9094g.subList(0, ceil));
                this.f9095h.add(this.f9094g.subList(ceil, size));
            }
        }
    }

    public final g w(g gVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048600, this, gVar, i)) == null) {
            if (gVar == null) {
                return null;
            }
            if (i == 2) {
                gVar.q(R.string.obfuscated_res_0x7f0f00ed);
                gVar.m(R.drawable.obfuscated_res_0x7f0800dc);
                return gVar;
            } else if (i == 1) {
                gVar.q(R.string.obfuscated_res_0x7f0f00ef);
                gVar.m(R.drawable.obfuscated_res_0x7f0800d4);
                return gVar;
            } else if (i == 0) {
                return null;
            } else {
                return gVar;
            }
        }
        return (g) invokeLI.objValue;
    }

    public final void x(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) || this.f9093f == null) {
            return;
        }
        this.f9094g.clear();
        l(41);
        g w = w(h(38), i);
        if (w != null && w.j()) {
            this.f9094g.add(w);
        }
        l(48);
        l(45);
        l(4);
        l(101);
        g h2 = h(35);
        if (h2 != null && h2.j()) {
            this.f9094g.add(h2);
        }
        l(39);
        l(42);
        l(9);
        if (!this.a) {
            this.o = this.f9094g.size() - 1;
        }
        l(37);
        if (this.n) {
            l(43);
        }
        g B = B(h(5), z);
        if (B != null && B.j()) {
            this.f9094g.add(B);
        }
        l(46);
        l(47);
        l(51);
        l(49);
        l(50);
        c.a.n0.n.b bVar = this.m;
        if (bVar != null) {
            bVar.f(this.f9091d, this.f9093f, new b(this));
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || this.m == null) {
            return;
        }
        this.f9093f.clear();
        List<g> b2 = i.b(this.f9091d);
        this.f9093f = b2;
        this.m.d(this.f9091d, b2);
        this.m.e(this.f9091d, this.f9093f);
        if (this.m.a()) {
            this.m.c(this.f9091d, this.f9093f);
        }
        v();
        k();
    }
}
