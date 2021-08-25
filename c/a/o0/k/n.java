package c.a.o0.k;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes3.dex */
public class n implements e, c.a.o0.k.r.b, View.OnKeyListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f11786e;

    /* renamed from: f  reason: collision with root package name */
    public int f11787f;

    /* renamed from: g  reason: collision with root package name */
    public Context f11788g;

    /* renamed from: h  reason: collision with root package name */
    public int f11789h;

    /* renamed from: i  reason: collision with root package name */
    public p f11790i;

    /* renamed from: j  reason: collision with root package name */
    public List<o> f11791j;
    public List<o> k;
    public List<List<o>> l;
    public e m;
    public c.a.o0.k.r.b n;
    public View.OnKeyListener o;
    public b p;
    public c.a.o0.k.b q;
    public boolean r;
    public int s;

    /* loaded from: classes3.dex */
    public class a implements PopupWindow.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f11792a;

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
            this.f11792a = nVar;
        }

        @Override // com.baidu.swan.menu.PopupWindow.b
        public void onDismiss() {
            n nVar;
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = (nVar = this.f11792a).p) == null) {
                return;
            }
            bVar.a(nVar, false);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(n nVar, boolean z);
    }

    public n(Context context, View view, int i2, c.a.o0.k.b bVar, @Nullable c.a.o0.k.a aVar) {
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
        this.f11786e = false;
        this.f11787f = 0;
        this.f11791j = new ArrayList();
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.s = -1;
        if (i2 < 0) {
            return;
        }
        this.f11788g = context;
        this.f11789h = i2;
        this.q = bVar;
        List<o> b2 = q.b(i2);
        this.f11791j = b2;
        this.q.c(this.f11789h, b2);
        this.q.d(this.f11789h, this.f11791j);
        p pVar = new p(this.f11788g, view, aVar);
        this.f11790i = pVar;
        pVar.P(new a(this));
    }

    @Override // c.a.o0.k.r.b
    public boolean a(o oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, oVar)) == null) {
            if (o(oVar) && !this.f11786e) {
                e(true);
            }
            c.a.o0.k.r.b bVar = this.n;
            if (bVar != null) {
                return bVar.a(oVar);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.o0.k.e
    public boolean b(View view, o oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, oVar)) == null) {
            if (oVar.i()) {
                if (o(oVar)) {
                    e(true);
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

    public void c(int i2, int i3) {
        o a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            boolean z = false;
            for (o oVar : this.f11791j) {
                if (oVar.c() == i2) {
                    z = true;
                }
            }
            if (z || (a2 = q.a(i2)) == null) {
                return;
            }
            int size = this.f11791j.size();
            if (i3 <= 0) {
                i3 = 0;
            } else if (i3 >= size) {
                i3 = size;
            }
            this.f11791j.add(i3, a2);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            e(true);
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f11790i.b0(z);
            b bVar = this.p;
            if (bVar != null) {
                bVar.a(this, false);
            }
        }
    }

    public o f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            for (int i3 = 0; i3 < this.f11791j.size(); i3++) {
                o oVar = this.f11791j.get(i3);
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

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            p pVar = this.f11790i;
            return pVar != null && pVar.x();
        }
        return invokeV.booleanValue;
    }

    public void h() {
        p pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (pVar = this.f11790i) == null) {
            return;
        }
        pVar.d0();
    }

    public final void i(int i2) {
        o f2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) && (f2 = f(i2)) != null && f2.j()) {
            this.k.add(f2);
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || this.f11791j == null) {
            return;
        }
        int i3 = -1;
        for (int i4 = 0; i4 < this.f11791j.size(); i4++) {
            if (this.f11791j.get(i4).c() == i2) {
                i3 = i4;
            }
        }
        if (i3 > -1) {
            this.f11791j.remove(i3);
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f11790i.e0(i2);
        }
    }

    public void l(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            this.m = eVar;
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f11787f = i2;
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.r = z;
        }
    }

    public final boolean o(o oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, oVar)) == null) {
            return true;
        }
        return invokeL.booleanValue;
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
            q(z, 0);
        }
    }

    public void q(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            r(z, i2, null, false);
        }
    }

    public void r(boolean z, int i2, View view, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), view, Boolean.valueOf(z2)}) == null) {
            if (g()) {
                e(true);
                return;
            }
            c.a.o0.k.b bVar = this.q;
            if (bVar != null) {
                bVar.b(this.f11789h, this.f11791j);
            }
            u(z, i2);
            s();
            this.f11790i.f0(this.l, view, z2, this.f11787f);
            b bVar2 = this.p;
            if (bVar2 != null) {
                bVar2.a(this, true);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.l.clear();
            int size = this.k.size();
            if (size > 0 && size <= 5) {
                this.l.add(this.k);
            } else if (size > 5 && size <= 10) {
                int i2 = this.f11786e ? 5 : this.s;
                this.l.add(this.k.subList(0, i2));
                this.l.add(this.k.subList(i2, size));
            } else if (size > 10) {
                int ceil = this.f11786e ? (int) Math.ceil(size / 2.0f) : this.s;
                this.l.add(this.k.subList(0, ceil));
                this.l.add(this.k.subList(ceil, size));
            }
        }
    }

    public final o t(o oVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, oVar, i2)) == null) {
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

    public final void u(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || this.f11791j == null) {
            return;
        }
        this.k.clear();
        i(41);
        o t = t(f(38), i2);
        if (t != null && t.j()) {
            this.k.add(t);
        }
        i(48);
        i(45);
        i(4);
        i(101);
        o f2 = f(35);
        if (f2 != null && f2.j()) {
            this.k.add(f2);
        }
        i(39);
        i(42);
        i(9);
        if (!this.f11786e) {
            this.s = this.k.size() - 1;
        }
        i(37);
        if (this.r) {
            i(43);
        }
        o w = w(f(5), z);
        if (w != null && w.j()) {
            this.k.add(w);
        }
        i(46);
        i(47);
        i(51);
        i(49);
        i(50);
    }

    public void v(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, jSONObject) == null) {
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

    public final o w(o oVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048599, this, oVar, z)) == null) {
            if (oVar == null) {
                return null;
            }
            oVar.q(z ? k.aiapp_menu_text_day_mode : k.aiapp_menu_text_night_mode);
            oVar.m(z ? h.aiapp_menu_item_daymode : h.aiapp_menu_item_nightmode);
            return oVar;
        }
        return (o) invokeLZ.objValue;
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            w(f(5), z);
            s();
            this.f11790i.a0();
            h();
        }
    }
}
