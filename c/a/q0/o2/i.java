package c.a.q0.o2;

import android.graphics.Rect;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.l.e.p;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f23176a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.e.a.f f23177b;

    /* renamed from: c  reason: collision with root package name */
    public int f23178c;

    /* renamed from: d  reason: collision with root package name */
    public int f23179d;

    /* renamed from: e  reason: collision with root package name */
    public p f23180e;

    /* renamed from: f  reason: collision with root package name */
    public View f23181f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f23182g;

    /* renamed from: h  reason: collision with root package name */
    public e f23183h;

    /* renamed from: i  reason: collision with root package name */
    public l f23184i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f23185j;
    public c.a.q0.o2.a k;
    public final CustomMessageListener l;
    public final CustomMessageListener m;
    public c.a.q0.o2.b n;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f23186a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i iVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i2)};
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
            this.f23186a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                this.f23186a.w();
                if (this.f23186a.f23185j && this.f23186a.f23185j) {
                    i iVar = this.f23186a;
                    iVar.n(iVar.f23184i.a(), this.f23186a.f23184i.b(), this.f23186a.f23184i.d(), this.f23186a.f23184i.c());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f23187a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(i iVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i2)};
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
            this.f23187a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (c.a.e.e.p.k.isEmpty(str)) {
                    return;
                }
                c.a.e.e.m.e.a().removeCallbacks(this.f23187a.k);
                c.a.e.e.m.e.a().removeCallbacks(this.f23187a.n);
                if (this.f23187a.f23181f != null && (this.f23187a.f23181f.getTag() instanceof e)) {
                    if (str.equals(((e) this.f23187a.f23181f.getTag()).getPlayUrl())) {
                        return;
                    }
                    ((e) this.f23187a.f23181f.getTag()).stopPlay();
                }
                for (int i2 = 0; i2 < this.f23187a.f23180e.getListView().getChildCount(); i2++) {
                    View childAt = this.f23187a.f23180e.getListView().getChildAt(i2);
                    if ((childAt.getTag() instanceof e) && str.equals(((e) childAt.getTag()).getPlayUrl())) {
                        this.f23187a.f23181f = childAt;
                        return;
                    }
                }
            }
        }
    }

    public i(c.a.e.a.f fVar, p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, pVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23176a = 0;
        this.f23178c = 0;
        this.f23179d = 0;
        this.f23182g = false;
        this.f23185j = true;
        this.k = new c.a.q0.o2.a();
        this.l = new a(this, 2000994);
        this.m = new b(this, 2921387);
        this.n = new c.a.q0.o2.b(this);
        this.f23177b = fVar;
        this.f23178c = c.a.e.e.p.l.i(fVar.getPageActivity());
        this.f23180e = pVar;
        BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.f23184i = new l();
        fVar.registerListener(this.l);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.e.e.m.e.a().removeCallbacks(this.k);
            c.a.e.e.m.e.a().removeCallbacks(this.n);
            i();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i2 = 0; i2 < this.f23180e.getListView().getChildCount(); i2++) {
                View childAt = this.f23180e.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    ((e) childAt.getTag()).stopPlay();
                }
            }
        }
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23181f : (View) invokeV.objValue;
    }

    public void k(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || view == null || l(view) || !(view.getTag() instanceof e)) {
            return;
        }
        ((e) view.getTag()).stopPlay();
    }

    public boolean l(View view) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) {
            if (view == null) {
                return false;
            }
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            if (this.f23176a == 1) {
                int i3 = c.a.e.e.p.l.i(this.f23177b.getPageActivity()) / 2;
                int i4 = rect.top;
                return i4 >= 0 && i4 <= i3 && rect.bottom - i4 >= view.getMeasuredHeight();
            }
            int i5 = rect.top;
            return i5 >= 0 && (i2 = rect.bottom) <= this.f23178c - this.f23179d && i2 - i5 >= view.getMeasuredHeight();
        }
        return invokeL.booleanValue;
    }

    public void m(int i2, int i3, boolean z, int i4) {
        boolean z2;
        boolean z3;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(i4)}) == null) {
            this.f23184i.e(i2, i3, z);
            p pVar = this.f23180e;
            if (pVar == null || pVar.getListView().getChildCount() == 0 || this.f23180e.getContentViewsCount() == 0) {
                return;
            }
            e eVar = this.f23183h;
            if (eVar != null && !l(eVar.getVideoContainer())) {
                this.f23183h.stopPlay();
            }
            View view2 = this.f23181f;
            int i5 = 0;
            if (view2 != null && (view2.getTag() instanceof e) && this.f23182g) {
                if (l(((e) this.f23181f.getTag()).getVideoContainer())) {
                    v(i4, this.f23181f);
                    this.f23182g = false;
                    return;
                }
                this.f23181f = null;
            }
            int contentViewsCount = this.f23180e.getContentViewsCount() + this.f23180e.getHeaderViewsCount() + this.f23180e.getFooterViewsCount();
            if (i2 == 0) {
                z2 = true;
            } else {
                int i6 = contentViewsCount - 1;
                z2 = false;
            }
            int childCount = this.f23180e.getListView().getChildCount();
            if (i2 == 0 || i3 == contentViewsCount - 1) {
                z3 = false;
                for (int i7 = 0; i7 < childCount; i7++) {
                    View childAt = this.f23180e.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
                    if (childAt.getTag() instanceof e) {
                        e eVar2 = (e) childAt.getTag();
                        if (!z3 && l(eVar2.getVideoContainer())) {
                            v(i4, childAt);
                            z3 = true;
                        } else {
                            y(i4, childAt);
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
                if (i9 >= childCount) {
                    break;
                }
                View childAt2 = this.f23180e.getListView().getChildAt(i9);
                if (childAt2.getTag() instanceof e) {
                    e eVar3 = (e) childAt2.getTag();
                    if (eVar3.isPlayStarted() && l(eVar3.getVideoContainer())) {
                        i8 = i9;
                        break;
                    }
                }
                i9++;
            }
            if (i8 >= 0) {
                while (i5 < childCount) {
                    View childAt3 = this.f23180e.getListView().getChildAt(i5);
                    if (i5 != i8) {
                        y(i4, childAt3);
                    } else {
                        v(i4, childAt3);
                    }
                    i5++;
                }
                return;
            }
            boolean z4 = false;
            while (i5 < childCount) {
                View childAt4 = this.f23180e.getListView().getChildAt(z ? (childCount - 1) - i5 : i5);
                if (childAt4.getTag() instanceof e) {
                    e eVar4 = (e) childAt4.getTag();
                    if (!z4 && (eVar4.isFullScreen() || l(eVar4.getVideoContainer()))) {
                        v(i4, childAt4);
                        z4 = true;
                    } else {
                        y(i4, childAt4);
                    }
                }
                i5++;
            }
            if (z4 || (view = this.f23181f) == null || !(view.getTag() instanceof e)) {
                return;
            }
            ((e) this.f23181f.getTag()).stopPlay();
        }
    }

    public void n(int i2, int i3, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            c.a.e.e.m.e.a().removeCallbacks(this.n);
            this.n.a(i2);
            this.n.c(i3);
            this.n.b(z);
            this.n.d(z2);
            this.f23184i.f(z2);
            c.a.e.e.m.e.a().postDelayed(this.n, 500L);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f23185j) {
            View view = this.f23181f;
            if (view != null && (view.getTag() instanceof e)) {
                e eVar = (e) this.f23181f.getTag();
                if (this.f23182g) {
                    eVar.startPlay();
                    this.f23182g = false;
                }
                if (this.f23181f.getTag() instanceof d) {
                    ((d) this.f23181f.getTag()).displayAllWithoutAnim();
                }
            }
            this.f23181f = null;
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f23176a = i2;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f23185j = z;
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
        }
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
        }
    }

    public void t(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        CustomMessageListener customMessageListener = this.l;
        if (customMessageListener != null) {
            customMessageListener.setTag(bdUniqueId);
        }
        CustomMessageListener customMessageListener2 = this.m;
        if (customMessageListener2 != null) {
            customMessageListener2.setSelfListener(true);
            this.m.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.l);
        MessageManager.getInstance().registerListener(this.m);
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f23179d = i2;
        }
    }

    public final void v(int i2, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048590, this, i2, view) == null) || view == null) {
            return;
        }
        View view2 = this.f23181f;
        if (view2 != null && view2 != view && (view2.getTag() instanceof e)) {
            ((e) this.f23181f.getTag()).stopPlay();
        }
        this.f23181f = view;
        if (i2 == 1 && (view.getTag() instanceof e)) {
            e eVar = (e) view.getTag();
            if (!this.f23185j || eVar.isPlayStarted()) {
                return;
            }
            eVar.startPlay();
        } else if (i2 == 2 && (view.getTag() instanceof d)) {
            ((d) view.getTag()).displayAll();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            c.a.e.e.m.e.a().removeCallbacks(this.k);
            c.a.e.e.m.e.a().removeCallbacks(this.n);
            for (int i2 = 0; i2 < this.f23180e.getListView().getChildCount(); i2++) {
                View childAt = this.f23180e.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    e eVar = (e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        eVar.stopPlay();
                        return;
                    }
                }
            }
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            for (int i2 = 0; i2 < this.f23180e.getListView().getChildCount(); i2++) {
                View childAt = this.f23180e.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    e eVar = (e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        s(eVar.getCurrentPosition());
                        r(eVar.getPlayUrl());
                        this.f23181f = childAt;
                        this.f23182g = eVar.isPlaying();
                        eVar.stopPlay();
                        return;
                    }
                }
            }
        }
    }

    public final void y(int i2, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048593, this, i2, view) == null) {
            if (i2 == 1 && (view.getTag() instanceof e)) {
                e eVar = (e) view.getTag();
                if (eVar.isPlaying()) {
                    eVar.stopPlay();
                }
            } else if (i2 == 2 && (view.getTag() instanceof d)) {
                ((d) view.getTag()).hideAll();
            }
        }
    }
}
