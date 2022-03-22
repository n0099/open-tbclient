package c.a.p0.b2.o.l;

import android.text.TextUtils;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.d.a.f a;

    /* renamed from: b  reason: collision with root package name */
    public int f12542b;

    /* renamed from: c  reason: collision with root package name */
    public int f12543c;

    /* renamed from: d  reason: collision with root package name */
    public ListView f12544d;

    /* renamed from: e  reason: collision with root package name */
    public String f12545e;

    /* renamed from: f  reason: collision with root package name */
    public int f12546f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, Integer> f12547g;

    /* renamed from: h  reason: collision with root package name */
    public View f12548h;
    public boolean i;
    public c.a.p0.c3.e j;
    public c.a.p0.c3.n k;
    public boolean l;
    public c.a.p0.c3.a m;
    public final CustomMessageListener n;
    public b o;

    /* loaded from: classes2.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(m mVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                this.a.s();
                if (this.a.l && this.a.l) {
                    m mVar = this.a;
                    mVar.k(mVar.k.a(), this.a.k.b(), this.a.k.d(), this.a.k.c());
                }
            }
        }
    }

    public m(c.a.d.a.f fVar, ListView listView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, listView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12542b = 0;
        this.f12543c = 0;
        this.f12545e = null;
        this.f12546f = 0;
        this.f12547g = new HashMap();
        this.i = false;
        this.l = true;
        this.m = new c.a.p0.c3.a();
        this.n = new a(this, 2000994);
        this.o = new b(this);
        this.a = fVar;
        this.f12542b = c.a.d.f.p.n.i(fVar.getPageActivity());
        this.f12544d = listView;
        BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.k = new c.a.p0.c3.n();
        fVar.registerListener(this.n);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.m);
            c.a.d.f.m.e.a().removeCallbacks(this.o);
            d();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i = 0; i < this.f12544d.getChildCount(); i++) {
                View childAt = this.f12544d.getChildAt(i);
                if (childAt.getTag() instanceof c.a.p0.c3.e) {
                    ((c.a.p0.c3.e) childAt.getTag()).stopPlay();
                }
            }
        }
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f12545e : (String) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f12546f : invokeV.intValue;
    }

    public int g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (this.f12547g.containsKey(str)) {
                return this.f12547g.get(str).intValue();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public void h(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view) == null) || view == null || i(view) || !(view.getTag() instanceof c.a.p0.c3.e)) {
            return;
        }
        c.a.p0.c3.e eVar = (c.a.p0.c3.e) view.getTag();
        if (!TextUtils.isEmpty(eVar.getPlayUrl()) && eVar.getCurrentPosition() > 0) {
            q(eVar.getPlayUrl(), eVar.getCurrentPosition());
        }
        eVar.stopPlay();
    }

    public boolean i(View view) {
        InterceptResult invokeL;
        int measuredHeight;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view)) == null) {
            if (view == null) {
                return false;
            }
            int[] iArr = new int[2];
            if (view == null) {
                return false;
            }
            view.getLocationOnScreen(iArr);
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.f12543c && measuredHeight < this.f12542b;
        }
        return invokeL.booleanValue;
    }

    public void j(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) {
            this.k.e(i, i2, z);
            ListView listView = this.f12544d;
            if (listView == null || listView.getChildCount() == 0) {
                return;
            }
            ListView listView2 = this.f12544d;
            ListAdapter wrappedAdapter = listView2 instanceof BdListView ? ((BdListView) listView2).getWrappedAdapter() : listView2.getAdapter();
            if (wrappedAdapter == null || wrappedAdapter.getCount() == 0) {
                return;
            }
            c.a.p0.c3.e eVar = this.j;
            if (eVar != null && !i(eVar.getVideoContainer())) {
                this.j.stopPlay();
            }
            int count = wrappedAdapter.getCount() + this.f12544d.getHeaderViewsCount() + this.f12544d.getFooterViewsCount();
            int i4 = 0;
            if (i == 0) {
                z2 = true;
            } else {
                int i5 = count - 1;
                z2 = false;
            }
            if (i == 0 || i2 == count - 1) {
                z3 = false;
                for (int i6 = 0; i6 < this.f12544d.getChildCount(); i6++) {
                    View childAt = this.f12544d.getChildAt(z2 ? i6 : (this.f12544d.getChildCount() - 1) - i6);
                    if (childAt.getTag() instanceof c.a.p0.c3.e) {
                        c.a.p0.c3.e eVar2 = (c.a.p0.c3.e) childAt.getTag();
                        if (!z3 && i(eVar2.getVideoContainer())) {
                            r(i3, childAt);
                            z3 = true;
                        } else {
                            if (!TextUtils.isEmpty(eVar2.getPlayUrl()) && eVar2.getCurrentPosition() > 0) {
                                q(eVar2.getPlayUrl(), eVar2.getCurrentPosition());
                            }
                            u(i3, childAt);
                        }
                    }
                }
            } else {
                z3 = false;
            }
            if (z3) {
                return;
            }
            int i7 = -1;
            int i8 = 0;
            while (true) {
                if (i8 >= this.f12544d.getChildCount()) {
                    break;
                }
                View childAt2 = this.f12544d.getChildAt(i8);
                if (childAt2.getTag() instanceof c.a.p0.c3.e) {
                    c.a.p0.c3.e eVar3 = (c.a.p0.c3.e) childAt2.getTag();
                    if (eVar3.isPlayStarted() && i(eVar3.getVideoContainer())) {
                        i7 = i8;
                        break;
                    }
                }
                i8++;
            }
            if (i7 >= 0) {
                while (i4 < this.f12544d.getChildCount()) {
                    View childAt3 = this.f12544d.getChildAt(i4);
                    if (i4 == i7) {
                        r(i3, childAt3);
                    } else {
                        if (childAt3.getTag() instanceof c.a.p0.c3.e) {
                            c.a.p0.c3.e eVar4 = (c.a.p0.c3.e) childAt3.getTag();
                            if (!TextUtils.isEmpty(eVar4.getPlayUrl()) && eVar4.getCurrentPosition() > 0) {
                                q(eVar4.getPlayUrl(), eVar4.getCurrentPosition());
                            }
                        }
                        u(i3, childAt3);
                    }
                    i4++;
                }
                return;
            }
            boolean z4 = false;
            while (i4 < this.f12544d.getChildCount()) {
                View childAt4 = this.f12544d.getChildAt(z ? (this.f12544d.getChildCount() - 1) - i4 : i4);
                if (childAt4.getTag() instanceof c.a.p0.c3.e) {
                    c.a.p0.c3.e eVar5 = (c.a.p0.c3.e) childAt4.getTag();
                    if (!z4 && i(eVar5.getVideoContainer())) {
                        r(i3, childAt4);
                        z4 = true;
                    } else {
                        if (!TextUtils.isEmpty(eVar5.getPlayUrl()) && eVar5.getCurrentPosition() > 0) {
                            q(eVar5.getPlayUrl(), eVar5.getCurrentPosition());
                        }
                        u(i3, childAt4);
                    }
                }
                i4++;
            }
        }
    }

    public void k(int i, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.o);
            this.o.a(i);
            this.o.c(i2);
            this.o.b(z);
            this.o.d(z2);
            this.k.f(z2);
            c.a.d.f.m.e.a().post(this.o);
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, str) == null) && this.f12547g.containsKey(str)) {
            this.f12547g.put(str, 0);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.l) {
            View view = this.f12548h;
            if (view != null && (view.getTag() instanceof c.a.p0.c3.e)) {
                c.a.p0.c3.e eVar = (c.a.p0.c3.e) this.f12548h.getTag();
                if (this.i) {
                    eVar.startPlay();
                }
                if (this.f12548h.getTag() instanceof c.a.p0.c3.d) {
                    ((c.a.p0.c3.d) this.f12548h.getTag()).c();
                }
            }
            this.f12548h = null;
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.l = z;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f12545e = str;
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.f12546f = i;
        }
    }

    public void q(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, str, i) == null) {
            if (this.f12547g.containsKey(str)) {
                if (this.f12547g.get(str).intValue() == 0) {
                    return;
                }
                this.f12547g.put(str, Integer.valueOf(i));
                return;
            }
            this.f12547g.put(str, Integer.valueOf(i));
        }
    }

    public final void r(int i, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048591, this, i, view) == null) || view == null) {
            return;
        }
        this.f12548h = view;
        if (i == 1 && (view.getTag() instanceof c.a.p0.c3.e)) {
            c.a.p0.c3.e eVar = (c.a.p0.c3.e) view.getTag();
            if (!this.l || eVar.isPlayStarted()) {
                return;
            }
            eVar.startPlay();
        } else if (i == 2 && (view.getTag() instanceof c.a.p0.c3.d)) {
            ((c.a.p0.c3.d) view.getTag()).a();
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.m);
            c.a.d.f.m.e.a().removeCallbacks(this.o);
            for (int i = 0; i < this.f12544d.getChildCount(); i++) {
                View childAt = this.f12544d.getChildAt(i);
                if (childAt.getTag() instanceof c.a.p0.c3.e) {
                    c.a.p0.c3.e eVar = (c.a.p0.c3.e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        eVar.stopPlay();
                        return;
                    }
                }
            }
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            for (int i = 0; i < this.f12544d.getChildCount(); i++) {
                View childAt = this.f12544d.getChildAt(i);
                if (childAt.getTag() instanceof c.a.p0.c3.e) {
                    c.a.p0.c3.e eVar = (c.a.p0.c3.e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        p(eVar.getCurrentPosition());
                        o(eVar.getPlayUrl());
                        this.f12548h = childAt;
                        this.i = eVar.isPlaying();
                        eVar.stopPlay();
                        return;
                    }
                }
            }
        }
    }

    public final void u(int i, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048594, this, i, view) == null) {
            if (i == 1 && (view.getTag() instanceof c.a.p0.c3.e)) {
                ((c.a.p0.c3.e) view.getTag()).stopPlay();
            } else if (i == 2 && (view.getTag() instanceof c.a.p0.c3.d)) {
                ((c.a.p0.c3.d) view.getTag()).d();
            }
        }
    }
}
