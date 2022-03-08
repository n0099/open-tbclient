package c.a.p0.n;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.n.b;
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
public class f implements e, c.a.p0.n.j.b, View.OnKeyListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f10897e;

    /* renamed from: f  reason: collision with root package name */
    public int f10898f;

    /* renamed from: g  reason: collision with root package name */
    public Context f10899g;

    /* renamed from: h  reason: collision with root package name */
    public int f10900h;

    /* renamed from: i  reason: collision with root package name */
    public h f10901i;

    /* renamed from: j  reason: collision with root package name */
    public List<g> f10902j;
    public List<g> k;
    public List<List<g>> l;
    public e m;
    public c.a.p0.n.j.b n;
    public View.OnKeyListener o;
    public c p;
    public c.a.p0.n.b q;
    public boolean r;
    public int s;
    public boolean t;

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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = (fVar = this.a).p) == null) {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // c.a.p0.n.b.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.a.o(i2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(f fVar, boolean z);
    }

    public f(Context context, View view, int i2, c.a.p0.n.b bVar, @Nullable c.a.p0.n.a aVar) {
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
        this.f10897e = false;
        this.f10898f = 0;
        this.f10902j = new ArrayList();
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.s = -1;
        this.t = false;
        if (i2 < 0) {
            return;
        }
        this.f10899g = context;
        this.f10900h = i2;
        this.q = bVar;
        this.t = bVar.a();
        List<g> b2 = i.b(this.f10900h);
        this.f10902j = b2;
        this.q.d(this.f10900h, b2);
        this.q.e(this.f10900h, this.f10902j);
        if (this.q.a()) {
            this.q.c(this.f10900h, this.f10902j);
        }
        h hVar = new h(this.f10899g, view, aVar);
        this.f10901i = hVar;
        hVar.I(new a(this));
    }

    public final void A(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || this.f10902j == null) {
            return;
        }
        this.k.clear();
        o(41);
        g z2 = z(k(38), i2);
        if (z2 != null && z2.j()) {
            this.k.add(z2);
        }
        o(48);
        o(45);
        o(4);
        o(101);
        g k = k(35);
        if (k != null && k.j()) {
            this.k.add(k);
        }
        o(39);
        o(42);
        o(9);
        if (!this.f10897e) {
            this.s = this.k.size() - 1;
        }
        o(37);
        if (this.r) {
            o(43);
        }
        g D = D(k(5), z);
        if (D != null && D.j()) {
            this.k.add(D);
        }
        o(46);
        o(47);
        o(51);
        o(49);
        o(50);
        c.a.p0.n.b bVar = this.q;
        if (bVar != null) {
            bVar.f(this.f10900h, this.f10902j, new b(this));
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.q == null) {
            return;
        }
        this.f10902j.clear();
        List<g> b2 = i.b(this.f10900h);
        this.f10902j = b2;
        this.q.d(this.f10900h, b2);
        this.q.e(this.f10900h, this.f10902j);
        if (this.q.a()) {
            this.q.c(this.f10900h, this.f10902j);
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
            for (g gVar : this.k) {
                if (gVar.c() == i2) {
                    valueOf = Long.valueOf(valueOf.longValue() + gVar.e());
                    gVar.o(valueOf.longValue() > 0 ? 1 : 0);
                    gVar.n(valueOf.longValue());
                }
            }
        }
    }

    public final g D(g gVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, gVar, z)) == null) {
            if (gVar == null) {
                return null;
            }
            gVar.q(z ? R.string.aiapp_menu_text_day_mode : R.string.aiapp_menu_text_night_mode);
            gVar.m(z ? R.drawable.aiapp_menu_item_daymode : R.drawable.aiapp_menu_item_nightmode);
            return gVar;
        }
        return (g) invokeLZ.objValue;
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            D(k(5), z);
            y();
            this.f10901i.R();
            n();
        }
    }

    @Override // c.a.p0.n.j.b
    public boolean a(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, gVar)) == null) {
            if (u(gVar) && !this.f10897e) {
                j(true);
            }
            c.a.p0.n.j.b bVar = this.n;
            if (bVar != null) {
                return bVar.a(gVar);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.p0.n.e
    public boolean b(View view, g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, view, gVar)) == null) {
            if (gVar.i()) {
                if (u(gVar)) {
                    j(true);
                }
                e eVar = this.m;
                if (eVar != null) {
                    return eVar.b(view, gVar);
                }
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void e(int i2, int i3) {
        g a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            boolean z = false;
            for (g gVar : this.f10902j) {
                if (gVar.c() == i2) {
                    z = true;
                }
            }
            if (z || (a2 = i.a(i2)) == null) {
                return;
            }
            int size = this.f10902j.size();
            if (i3 <= 0) {
                i3 = 0;
            } else if (i3 >= size) {
                i3 = size;
            }
            this.f10902j.add(i3, a2);
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f10900h = i2;
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
            this.f10901i.S(z);
            c cVar = this.p;
            if (cVar != null) {
                cVar.a(this, false);
            }
        }
    }

    public g k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            for (int i3 = 0; i3 < this.f10902j.size(); i3++) {
                g gVar = this.f10902j.get(i3);
                if (gVar != null && gVar.c() == i2) {
                    gVar.n(0L);
                    gVar.p(this);
                    return gVar;
                }
            }
            return null;
        }
        return (g) invokeI.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            h hVar = this.f10901i;
            return hVar != null && hVar.x();
        }
        return invokeV.booleanValue;
    }

    public void n() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (hVar = this.f10901i) == null) {
            return;
        }
        hVar.U();
    }

    public final void o(int i2) {
        g k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048590, this, i2) == null) && (k = k(i2)) != null && k.j()) {
            this.k.add(k);
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
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i2) == null) || this.f10902j == null) {
            return;
        }
        int i3 = -1;
        for (int i4 = 0; i4 < this.f10902j.size(); i4++) {
            if (this.f10902j.get(i4).c() == i2) {
                i3 = i4;
            }
        }
        if (i3 > -1) {
            this.f10902j.remove(i3);
        }
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.f10901i.V(i2);
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
            this.f10898f = i2;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.r = z;
        }
    }

    public final boolean u(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, gVar)) == null) {
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
            this.f10901i.W(this.l, view, z2, this.f10898f);
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
                this.l.add(this.k);
                return;
            }
            int size = this.k.size();
            if (size > 0 && size <= 5) {
                this.l.add(this.k);
            } else if (size > 5 && size <= 10) {
                int i2 = this.f10897e ? 5 : this.s;
                this.l.add(this.k.subList(0, i2));
                this.l.add(this.k.subList(i2, size));
            } else if (size > 10) {
                int ceil = this.f10897e ? (int) Math.ceil(size / 2.0f) : this.s;
                this.l.add(this.k.subList(0, ceil));
                this.l.add(this.k.subList(ceil, size));
            }
        }
    }

    public final g z(g gVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048602, this, gVar, i2)) == null) {
            if (gVar == null) {
                return null;
            }
            if (i2 == 2) {
                gVar.q(R.string.aiapp_menu_text_cancel_favorite);
                gVar.m(R.drawable.aiapp_menu_item_cancel_fav_selector);
                return gVar;
            } else if (i2 == 1) {
                gVar.q(R.string.aiapp_menu_text_favorite);
                gVar.m(R.drawable.aiapp_menu_item_add_fav_selector);
                return gVar;
            } else if (i2 == 0) {
                return null;
            } else {
                return gVar;
            }
        }
        return (g) invokeLI.objValue;
    }
}
