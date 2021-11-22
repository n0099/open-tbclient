package b.a.p0.n;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.n.b;
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
/* loaded from: classes4.dex */
public class n implements e, b.a.p0.n.r.b, View.OnKeyListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f11697e;

    /* renamed from: f  reason: collision with root package name */
    public int f11698f;

    /* renamed from: g  reason: collision with root package name */
    public Context f11699g;

    /* renamed from: h  reason: collision with root package name */
    public int f11700h;

    /* renamed from: i  reason: collision with root package name */
    public p f11701i;
    public List<o> j;
    public List<o> k;
    public List<List<o>> l;
    public e m;
    public b.a.p0.n.r.b n;
    public View.OnKeyListener o;
    public c p;
    public b.a.p0.n.b q;
    public boolean r;
    public int s;
    public boolean t;

    /* loaded from: classes4.dex */
    public class a implements PopupWindow.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f11702a;

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
            this.f11702a = nVar;
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            n nVar;
            c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = (nVar = this.f11702a).p) == null) {
                return;
            }
            cVar.a(nVar, false);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f11703a;

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
            this.f11703a = nVar;
        }

        @Override // b.a.p0.n.b.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f11703a.k(i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(n nVar, boolean z);
    }

    public n(Context context, View view, int i2, b.a.p0.n.b bVar, @Nullable b.a.p0.n.a aVar) {
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
        this.f11697e = false;
        this.f11698f = 0;
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.s = -1;
        this.t = false;
        if (i2 < 0) {
            return;
        }
        this.f11699g = context;
        this.f11700h = i2;
        this.q = bVar;
        this.t = bVar.a();
        List<o> b2 = q.b(this.f11700h);
        this.j = b2;
        this.q.d(this.f11700h, b2);
        this.q.e(this.f11700h, this.j);
        if (this.q.a()) {
            this.q.c(this.f11700h, this.j);
        }
        p pVar = new p(this.f11699g, view, aVar);
        this.f11701i = pVar;
        pVar.P(new a(this));
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            z(h(5), z);
            u();
            this.f11701i.Y();
            j();
        }
    }

    @Override // b.a.p0.n.r.b
    public boolean a(o oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oVar)) == null) {
            if (q(oVar) && !this.f11697e) {
                g(true);
            }
            b.a.p0.n.r.b bVar = this.n;
            if (bVar != null) {
                return bVar.a(oVar);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.p0.n.e
    public boolean b(View view, o oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, oVar)) == null) {
            if (oVar.i()) {
                if (q(oVar)) {
                    g(true);
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

    public void d(int i2, int i3) {
        o a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            boolean z = false;
            for (o oVar : this.j) {
                if (oVar.c() == i2) {
                    z = true;
                }
            }
            if (z || (a2 = q.a(i2)) == null) {
                return;
            }
            int size = this.j.size();
            if (i3 <= 0) {
                i3 = 0;
            } else if (i3 >= size) {
                i3 = size;
            }
            this.j.add(i3, a2);
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f11700h = i2;
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            g(true);
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f11701i.Z(z);
            c cVar = this.p;
            if (cVar != null) {
                cVar.a(this, false);
            }
        }
    }

    public o h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            for (int i3 = 0; i3 < this.j.size(); i3++) {
                o oVar = this.j.get(i3);
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

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            p pVar = this.f11701i;
            return pVar != null && pVar.x();
        }
        return invokeV.booleanValue;
    }

    public void j() {
        p pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (pVar = this.f11701i) == null) {
            return;
        }
        pVar.b0();
    }

    public final void k(int i2) {
        o h2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048586, this, i2) == null) && (h2 = h(i2)) != null && h2.j()) {
            this.k.add(h2);
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || this.j == null) {
            return;
        }
        int i3 = -1;
        for (int i4 = 0; i4 < this.j.size(); i4++) {
            if (this.j.get(i4).c() == i2) {
                i3 = i4;
            }
        }
        if (i3 > -1) {
            this.j.remove(i3);
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f11701i.c0(i2);
        }
    }

    public void n(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) {
            this.m = eVar;
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f11698f = i2;
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

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.r = z;
        }
    }

    public final boolean q(o oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, oVar)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            s(z, 0);
        }
    }

    public void s(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            t(z, i2, null, false);
        }
    }

    public void t(boolean z, int i2, View view, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), view, Boolean.valueOf(z2)}) == null) {
            if (i()) {
                g(true);
                return;
            }
            w(z, i2);
            u();
            this.f11701i.d0(this.l, view, z2, this.f11698f);
            c cVar = this.p;
            if (cVar != null) {
                cVar.a(this, true);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.l.clear();
            if (this.q.a()) {
                this.l.add(this.k);
                return;
            }
            int size = this.k.size();
            if (size > 0 && size <= 5) {
                this.l.add(this.k);
            } else if (size > 5 && size <= 10) {
                int i2 = this.f11697e ? 5 : this.s;
                this.l.add(this.k.subList(0, i2));
                this.l.add(this.k.subList(i2, size));
            } else if (size > 10) {
                int ceil = this.f11697e ? (int) Math.ceil(size / 2.0f) : this.s;
                this.l.add(this.k.subList(0, ceil));
                this.l.add(this.k.subList(ceil, size));
            }
        }
    }

    public final o v(o oVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048598, this, oVar, i2)) == null) {
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

    public final void w(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || this.j == null) {
            return;
        }
        this.k.clear();
        k(41);
        o v = v(h(38), i2);
        if (v != null && v.j()) {
            this.k.add(v);
        }
        k(48);
        k(45);
        k(4);
        k(101);
        o h2 = h(35);
        if (h2 != null && h2.j()) {
            this.k.add(h2);
        }
        k(39);
        k(42);
        k(9);
        if (!this.f11697e) {
            this.s = this.k.size() - 1;
        }
        k(37);
        if (this.r) {
            k(43);
        }
        o z2 = z(h(5), z);
        if (z2 != null && z2.j()) {
            this.k.add(z2);
        }
        k(46);
        k(47);
        k(51);
        k(49);
        k(50);
        b.a.p0.n.b bVar = this.q;
        if (bVar != null) {
            bVar.f(this.f11700h, this.j, new b(this));
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.q == null) {
            return;
        }
        this.j.clear();
        List<o> b2 = q.b(this.f11700h);
        this.j = b2;
        this.q.d(this.f11700h, b2);
        this.q.e(this.f11700h, this.j);
        if (this.q.a()) {
            this.q.c(this.f11700h, this.j);
        }
        u();
        j();
    }

    public void y(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, jSONObject) == null) {
            int optInt = jSONObject.optInt("pa_type");
            Long valueOf = Long.valueOf(jSONObject.optLong("pa_unread_sums"));
            int i2 = optInt != 7 ? optInt != 666 ? optInt != 888 ? optInt != 999 ? -1 : 48 : 47 : 46 : 45;
            if (i2 < 0) {
                return;
            }
            for (o oVar : this.k) {
                if (oVar.c() == i2) {
                    valueOf = Long.valueOf(valueOf.longValue() + oVar.e());
                    oVar.o(valueOf.longValue() > 0 ? 1 : 0);
                    oVar.n(valueOf.longValue());
                }
            }
        }
    }

    public final o z(o oVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048602, this, oVar, z)) == null) {
            if (oVar == null) {
                return null;
            }
            oVar.q(z ? k.aiapp_menu_text_day_mode : k.aiapp_menu_text_night_mode);
            oVar.m(z ? h.aiapp_menu_item_daymode : h.aiapp_menu_item_nightmode);
            return oVar;
        }
        return (o) invokeLZ.objValue;
    }
}
