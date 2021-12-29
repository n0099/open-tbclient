package c.a.r0.n;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.n.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class n implements e, c.a.r0.n.r.b, View.OnKeyListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f11693e;

    /* renamed from: f  reason: collision with root package name */
    public int f11694f;

    /* renamed from: g  reason: collision with root package name */
    public Context f11695g;

    /* renamed from: h  reason: collision with root package name */
    public int f11696h;

    /* renamed from: i  reason: collision with root package name */
    public p f11697i;

    /* renamed from: j  reason: collision with root package name */
    public List<o> f11698j;

    /* renamed from: k  reason: collision with root package name */
    public List<o> f11699k;
    public List<List<o>> l;
    public e m;
    public c.a.r0.n.r.b n;
    public View.OnKeyListener o;
    public c p;
    public c.a.r0.n.b q;
    public boolean r;
    public int s;
    public boolean t;

    /* loaded from: classes6.dex */
    public class a implements PopupWindow.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n a;

        public a(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nVar;
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            n nVar;
            c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = (nVar = this.a).p) == null) {
                return;
            }
            cVar.a(nVar, false);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n a;

        public b(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nVar;
        }

        @Override // c.a.r0.n.b.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.a.o(i2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(n nVar, boolean z);
    }

    public n(Context context, View view, int i2, c.a.r0.n.b bVar, @Nullable c.a.r0.n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view, Integer.valueOf(i2), bVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11693e = false;
        this.f11694f = 0;
        this.f11698j = new ArrayList();
        this.f11699k = new ArrayList();
        this.l = new ArrayList();
        this.s = -1;
        this.t = false;
        if (i2 < 0) {
            return;
        }
        this.f11695g = context;
        this.f11696h = i2;
        this.q = bVar;
        this.t = bVar.a();
        List<o> b2 = q.b(this.f11696h);
        this.f11698j = b2;
        this.q.d(this.f11696h, b2);
        this.q.e(this.f11696h, this.f11698j);
        if (this.q.a()) {
            this.q.c(this.f11696h, this.f11698j);
        }
        p pVar = new p(this.f11695g, view, aVar);
        this.f11697i = pVar;
        pVar.I(new a(this));
    }

    public final void A(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || this.f11698j == null) {
            return;
        }
        this.f11699k.clear();
        o(41);
        o z2 = z(k(38), i2);
        if (z2 != null && z2.j()) {
            this.f11699k.add(z2);
        }
        o(48);
        o(45);
        o(4);
        o(101);
        o k2 = k(35);
        if (k2 != null && k2.j()) {
            this.f11699k.add(k2);
        }
        o(39);
        o(42);
        o(9);
        if (!this.f11693e) {
            this.s = this.f11699k.size() - 1;
        }
        o(37);
        if (this.r) {
            o(43);
        }
        o D = D(k(5), z);
        if (D != null && D.j()) {
            this.f11699k.add(D);
        }
        o(46);
        o(47);
        o(51);
        o(49);
        o(50);
        c.a.r0.n.b bVar = this.q;
        if (bVar != null) {
            bVar.f(this.f11696h, this.f11698j, new b(this));
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.q == null) {
            return;
        }
        this.f11698j.clear();
        List<o> b2 = q.b(this.f11696h);
        this.f11698j = b2;
        this.q.d(this.f11696h, b2);
        this.q.e(this.f11696h, this.f11698j);
        if (this.q.a()) {
            this.q.c(this.f11696h, this.f11698j);
        }
        y();
        n();
    }

    public void C(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            int optInt = jSONObject.optInt("pa_type");
            Long valueOf = Long.valueOf(jSONObject.optLong("pa_unread_sums"));
            int i2 = optInt != 7 ? optInt != 666 ? optInt != 888 ? optInt != 999 ? -1 : 48 : 47 : 46 : 45;
            if (i2 < 0) {
                return;
            }
            for (o oVar : this.f11699k) {
                if (oVar.c() == i2) {
                    valueOf = Long.valueOf(valueOf.longValue() + oVar.e());
                    oVar.o(valueOf.longValue() > 0 ? 1 : 0);
                    oVar.n(valueOf.longValue());
                }
            }
        }
    }

    public final o D(o oVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, oVar, z)) == null) {
            if (oVar == null) {
                return null;
            }
            oVar.q(z ? k.aiapp_menu_text_day_mode : k.aiapp_menu_text_night_mode);
            oVar.m(z ? h.aiapp_menu_item_daymode : h.aiapp_menu_item_nightmode);
            return oVar;
        }
        return (o) invokeLZ.objValue;
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            D(k(5), z);
            y();
            this.f11697i.R();
            n();
        }
    }

    @Override // c.a.r0.n.r.b
    public boolean a(o oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, oVar)) == null) {
            if (u(oVar) && !this.f11693e) {
                j(true);
            }
            c.a.r0.n.r.b bVar = this.n;
            if (bVar != null) {
                return bVar.a(oVar);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r0.n.e
    public boolean b(View view, o oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, view, oVar)) == null) {
            if (oVar.i()) {
                if (u(oVar)) {
                    j(true);
                }
                e eVar = this.m;
                if (eVar != null) {
                    return eVar.b(view, oVar);
                }
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void e(int i2, int i3) {
        o a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            boolean z = false;
            for (o oVar : this.f11698j) {
                if (oVar.c() == i2) {
                    z = true;
                }
            }
            if (z || (a2 = q.a(i2)) == null) {
                return;
            }
            int size = this.f11698j.size();
            if (i3 <= 0) {
                i3 = 0;
            } else if (i3 >= size) {
                i3 = size;
            }
            this.f11698j.add(i3, a2);
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f11696h = i2;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            j(true);
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f11697i.S(z);
            c cVar = this.p;
            if (cVar != null) {
                cVar.a(this, false);
            }
        }
    }

    public o k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            for (int i3 = 0; i3 < this.f11698j.size(); i3++) {
                o oVar = this.f11698j.get(i3);
                if (oVar != null && oVar.c() == i2) {
                    oVar.n(0L);
                    oVar.p(this);
                    return oVar;
                }
            }
            return null;
        }
        return (o) invokeI.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            p pVar = this.f11697i;
            return pVar != null && pVar.x();
        }
        return invokeV.booleanValue;
    }

    public void n() {
        p pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (pVar = this.f11697i) == null) {
            return;
        }
        pVar.U();
    }

    public final void o(int i2) {
        o k2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048590, this, i2) == null) && (k2 = k(i2)) != null && k2.j()) {
            this.f11699k.add(k2);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048591, this, view, i2, keyEvent)) == null) {
            View.OnKeyListener onKeyListener = this.o;
            if (onKeyListener != null) {
                return onKeyListener.onKey(view, i2, keyEvent);
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i2) == null) || this.f11698j == null) {
            return;
        }
        int i3 = -1;
        for (int i4 = 0; i4 < this.f11698j.size(); i4++) {
            if (this.f11698j.get(i4).c() == i2) {
                i3 = i4;
            }
        }
        if (i3 > -1) {
            this.f11698j.remove(i3);
        }
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.f11697i.V(i2);
        }
    }

    public void r(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, eVar) == null) {
            this.m = eVar;
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.f11694f = i2;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.r = z;
        }
    }

    public final boolean u(o oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, oVar)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            w(z, 0);
        }
    }

    public void w(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            x(z, i2, null, false);
        }
    }

    public void x(boolean z, int i2, View view, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), view, Boolean.valueOf(z2)}) == null) {
            if (l()) {
                j(true);
                return;
            }
            A(z, i2);
            y();
            this.f11697i.W(this.l, view, z2, this.f11694f);
            c cVar = this.p;
            if (cVar != null) {
                cVar.a(this, true);
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.l.clear();
            if (this.q.a()) {
                this.l.add(this.f11699k);
                return;
            }
            int size = this.f11699k.size();
            if (size > 0 && size <= 5) {
                this.l.add(this.f11699k);
            } else if (size > 5 && size <= 10) {
                int i2 = this.f11693e ? 5 : this.s;
                this.l.add(this.f11699k.subList(0, i2));
                this.l.add(this.f11699k.subList(i2, size));
            } else if (size > 10) {
                int ceil = this.f11693e ? (int) Math.ceil(size / 2.0f) : this.s;
                this.l.add(this.f11699k.subList(0, ceil));
                this.l.add(this.f11699k.subList(ceil, size));
            }
        }
    }

    public final o z(o oVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048602, this, oVar, i2)) == null) {
            if (oVar == null) {
                return null;
            }
            if (i2 == 2) {
                oVar.q(k.aiapp_menu_text_cancel_favorite);
                oVar.m(h.aiapp_menu_item_cancel_fav_selector);
                return oVar;
            } else if (i2 == 1) {
                oVar.q(k.aiapp_menu_text_favorite);
                oVar.m(h.aiapp_menu_item_add_fav_selector);
                return oVar;
            } else if (i2 == 0) {
                return null;
            } else {
                return oVar;
            }
        }
        return (o) invokeLI.objValue;
    }
}
