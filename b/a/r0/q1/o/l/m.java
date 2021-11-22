package b.a.r0.q1.o.l;

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
/* loaded from: classes5.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.e.a.f f24213a;

    /* renamed from: b  reason: collision with root package name */
    public int f24214b;

    /* renamed from: c  reason: collision with root package name */
    public int f24215c;

    /* renamed from: d  reason: collision with root package name */
    public ListView f24216d;

    /* renamed from: e  reason: collision with root package name */
    public String f24217e;

    /* renamed from: f  reason: collision with root package name */
    public int f24218f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, Integer> f24219g;

    /* renamed from: h  reason: collision with root package name */
    public View f24220h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f24221i;
    public b.a.r0.q2.e j;
    public b.a.r0.q2.l k;
    public boolean l;
    public b.a.r0.q2.a m;
    public final CustomMessageListener n;
    public b o;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f24222a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(m mVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24222a = mVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                this.f24222a.s();
                if (this.f24222a.l && this.f24222a.l) {
                    m mVar = this.f24222a;
                    mVar.k(mVar.k.a(), this.f24222a.k.b(), this.f24222a.k.d(), this.f24222a.k.c());
                }
            }
        }
    }

    public m(b.a.e.a.f fVar, ListView listView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, listView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24214b = 0;
        this.f24215c = 0;
        this.f24217e = null;
        this.f24218f = 0;
        this.f24219g = new HashMap();
        this.f24221i = false;
        this.l = true;
        this.m = new b.a.r0.q2.a();
        this.n = new a(this, 2000994);
        this.o = new b(this);
        this.f24213a = fVar;
        this.f24214b = b.a.e.f.p.l.i(fVar.getPageActivity());
        this.f24216d = listView;
        BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.k = new b.a.r0.q2.l();
        fVar.registerListener(this.n);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b.a.e.f.m.e.a().removeCallbacks(this.m);
            b.a.e.f.m.e.a().removeCallbacks(this.o);
            d();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i2 = 0; i2 < this.f24216d.getChildCount(); i2++) {
                View childAt = this.f24216d.getChildAt(i2);
                if (childAt.getTag() instanceof b.a.r0.q2.e) {
                    ((b.a.r0.q2.e) childAt.getTag()).stopPlay();
                }
            }
        }
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f24217e : (String) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f24218f : invokeV.intValue;
    }

    public int g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (this.f24219g.containsKey(str)) {
                return this.f24219g.get(str).intValue();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public void h(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view) == null) || view == null || i(view) || !(view.getTag() instanceof b.a.r0.q2.e)) {
            return;
        }
        b.a.r0.q2.e eVar = (b.a.r0.q2.e) view.getTag();
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
            return view != null && (measuredHeight = iArr[1] + (view.getMeasuredHeight() / 2)) > this.f24215c && measuredHeight < this.f24214b;
        }
        return invokeL.booleanValue;
    }

    public void j(int i2, int i3, boolean z, int i4) {
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(i4)}) == null) {
            this.k.e(i2, i3, z);
            ListView listView = this.f24216d;
            if (listView == null || listView.getChildCount() == 0) {
                return;
            }
            ListView listView2 = this.f24216d;
            ListAdapter wrappedAdapter = listView2 instanceof BdListView ? ((BdListView) listView2).getWrappedAdapter() : listView2.getAdapter();
            if (wrappedAdapter == null || wrappedAdapter.getCount() == 0) {
                return;
            }
            b.a.r0.q2.e eVar = this.j;
            if (eVar != null && !i(eVar.getVideoContainer())) {
                this.j.stopPlay();
            }
            int count = wrappedAdapter.getCount() + this.f24216d.getHeaderViewsCount() + this.f24216d.getFooterViewsCount();
            int i5 = 0;
            if (i2 == 0) {
                z2 = true;
            } else {
                int i6 = count - 1;
                z2 = false;
            }
            if (i2 == 0 || i3 == count - 1) {
                z3 = false;
                for (int i7 = 0; i7 < this.f24216d.getChildCount(); i7++) {
                    View childAt = this.f24216d.getChildAt(z2 ? i7 : (this.f24216d.getChildCount() - 1) - i7);
                    if (childAt.getTag() instanceof b.a.r0.q2.e) {
                        b.a.r0.q2.e eVar2 = (b.a.r0.q2.e) childAt.getTag();
                        if (!z3 && i(eVar2.getVideoContainer())) {
                            r(i4, childAt);
                            z3 = true;
                        } else {
                            if (!TextUtils.isEmpty(eVar2.getPlayUrl()) && eVar2.getCurrentPosition() > 0) {
                                q(eVar2.getPlayUrl(), eVar2.getCurrentPosition());
                            }
                            u(i4, childAt);
                        }
                    }
                }
            } else {
                z3 = false;
            }
            if (z3) {
                return;
            }
            int i8 = -1;
            int i9 = 0;
            while (true) {
                if (i9 >= this.f24216d.getChildCount()) {
                    break;
                }
                View childAt2 = this.f24216d.getChildAt(i9);
                if (childAt2.getTag() instanceof b.a.r0.q2.e) {
                    b.a.r0.q2.e eVar3 = (b.a.r0.q2.e) childAt2.getTag();
                    if (eVar3.isPlayStarted() && i(eVar3.getVideoContainer())) {
                        i8 = i9;
                        break;
                    }
                }
                i9++;
            }
            if (i8 >= 0) {
                while (i5 < this.f24216d.getChildCount()) {
                    View childAt3 = this.f24216d.getChildAt(i5);
                    if (i5 == i8) {
                        r(i4, childAt3);
                    } else {
                        if (childAt3.getTag() instanceof b.a.r0.q2.e) {
                            b.a.r0.q2.e eVar4 = (b.a.r0.q2.e) childAt3.getTag();
                            if (!TextUtils.isEmpty(eVar4.getPlayUrl()) && eVar4.getCurrentPosition() > 0) {
                                q(eVar4.getPlayUrl(), eVar4.getCurrentPosition());
                            }
                        }
                        u(i4, childAt3);
                    }
                    i5++;
                }
                return;
            }
            boolean z4 = false;
            while (i5 < this.f24216d.getChildCount()) {
                View childAt4 = this.f24216d.getChildAt(z ? (this.f24216d.getChildCount() - 1) - i5 : i5);
                if (childAt4.getTag() instanceof b.a.r0.q2.e) {
                    b.a.r0.q2.e eVar5 = (b.a.r0.q2.e) childAt4.getTag();
                    if (!z4 && i(eVar5.getVideoContainer())) {
                        r(i4, childAt4);
                        z4 = true;
                    } else {
                        if (!TextUtils.isEmpty(eVar5.getPlayUrl()) && eVar5.getCurrentPosition() > 0) {
                            q(eVar5.getPlayUrl(), eVar5.getCurrentPosition());
                        }
                        u(i4, childAt4);
                    }
                }
                i5++;
            }
        }
    }

    public void k(int i2, int i3, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            b.a.e.f.m.e.a().removeCallbacks(this.o);
            this.o.a(i2);
            this.o.c(i3);
            this.o.b(z);
            this.o.d(z2);
            this.k.f(z2);
            b.a.e.f.m.e.a().post(this.o);
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, str) == null) && this.f24219g.containsKey(str)) {
            this.f24219g.put(str, 0);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.l) {
            View view = this.f24220h;
            if (view != null && (view.getTag() instanceof b.a.r0.q2.e)) {
                b.a.r0.q2.e eVar = (b.a.r0.q2.e) this.f24220h.getTag();
                if (this.f24221i) {
                    eVar.startPlay();
                }
                if (this.f24220h.getTag() instanceof b.a.r0.q2.d) {
                    ((b.a.r0.q2.d) this.f24220h.getTag()).displayAllWithoutAnim();
                }
            }
            this.f24220h = null;
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
            this.f24217e = str;
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f24218f = i2;
        }
    }

    public void q(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, str, i2) == null) {
            if (this.f24219g.containsKey(str)) {
                if (this.f24219g.get(str).intValue() == 0) {
                    return;
                }
                this.f24219g.put(str, Integer.valueOf(i2));
                return;
            }
            this.f24219g.put(str, Integer.valueOf(i2));
        }
    }

    public final void r(int i2, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048591, this, i2, view) == null) || view == null) {
            return;
        }
        this.f24220h = view;
        if (i2 == 1 && (view.getTag() instanceof b.a.r0.q2.e)) {
            b.a.r0.q2.e eVar = (b.a.r0.q2.e) view.getTag();
            if (!this.l || eVar.isPlayStarted()) {
                return;
            }
            eVar.startPlay();
        } else if (i2 == 2 && (view.getTag() instanceof b.a.r0.q2.d)) {
            ((b.a.r0.q2.d) view.getTag()).displayAll();
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            b.a.e.f.m.e.a().removeCallbacks(this.m);
            b.a.e.f.m.e.a().removeCallbacks(this.o);
            for (int i2 = 0; i2 < this.f24216d.getChildCount(); i2++) {
                View childAt = this.f24216d.getChildAt(i2);
                if (childAt.getTag() instanceof b.a.r0.q2.e) {
                    b.a.r0.q2.e eVar = (b.a.r0.q2.e) childAt.getTag();
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
            for (int i2 = 0; i2 < this.f24216d.getChildCount(); i2++) {
                View childAt = this.f24216d.getChildAt(i2);
                if (childAt.getTag() instanceof b.a.r0.q2.e) {
                    b.a.r0.q2.e eVar = (b.a.r0.q2.e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        p(eVar.getCurrentPosition());
                        o(eVar.getPlayUrl());
                        this.f24220h = childAt;
                        this.f24221i = eVar.isPlaying();
                        eVar.stopPlay();
                        return;
                    }
                }
            }
        }
    }

    public final void u(int i2, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048594, this, i2, view) == null) {
            if (i2 == 1 && (view.getTag() instanceof b.a.r0.q2.e)) {
                ((b.a.r0.q2.e) view.getTag()).stopPlay();
            } else if (i2 == 2 && (view.getTag() instanceof b.a.r0.q2.d)) {
                ((b.a.r0.q2.d) view.getTag()).hideAll();
            }
        }
    }
}
