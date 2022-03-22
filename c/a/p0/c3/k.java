package c.a.p0.c3;

import android.graphics.Rect;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.d.a.f f13471b;

    /* renamed from: c  reason: collision with root package name */
    public int f13472c;

    /* renamed from: d  reason: collision with root package name */
    public int f13473d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.d.o.e.p f13474e;

    /* renamed from: f  reason: collision with root package name */
    public View f13475f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13476g;

    /* renamed from: h  reason: collision with root package name */
    public e f13477h;
    public n i;
    public boolean j;
    public float k;
    public boolean l;
    public CustomMessageListener m;
    public CustomMessageListener n;
    public c.a.p0.c3.a o;
    public final CustomMessageListener p;
    public final CustomMessageListener q;
    public c.a.p0.c3.b r;

    /* loaded from: classes2.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(k kVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, Integer.valueOf(i)};
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
            this.a = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                return;
            }
            c.a.d.f.m.e.a().postDelayed(this.a.r, 500L);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(k kVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, Integer.valueOf(i)};
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
            this.a = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            c.a.d.f.m.e.a().postDelayed(this.a.r, 500L);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(k kVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, Integer.valueOf(i)};
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
            this.a = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                this.a.x();
                if (this.a.l && this.a.l) {
                    k kVar = this.a;
                    kVar.n(kVar.i.a(), this.a.i.b(), this.a.i.d(), this.a.i.c());
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(k kVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, Integer.valueOf(i)};
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
            this.a = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (c.a.d.f.p.m.isEmpty(str)) {
                    return;
                }
                c.a.d.f.m.e.a().removeCallbacks(this.a.o);
                c.a.d.f.m.e.a().removeCallbacks(this.a.r);
                if (this.a.f13475f != null && (this.a.f13475f.getTag() instanceof e)) {
                    if (str.equals(((e) this.a.f13475f.getTag()).getPlayUrl())) {
                        return;
                    }
                    ((e) this.a.f13475f.getTag()).stopPlay();
                }
                for (int i = 0; i < this.a.f13474e.getListView().getChildCount(); i++) {
                    View childAt = this.a.f13474e.getListView().getChildAt(i);
                    if ((childAt.getTag() instanceof e) && str.equals(((e) childAt.getTag()).getPlayUrl())) {
                        this.a.f13475f = childAt;
                        return;
                    }
                }
            }
        }
    }

    public k(c.a.d.a.f fVar, c.a.d.o.e.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, pVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.f13472c = 0;
        this.f13473d = 0;
        this.f13476g = false;
        this.j = true;
        this.k = 0.0f;
        this.l = true;
        this.m = new a(this, 2921637);
        this.n = new b(this, 2921636);
        this.o = new c.a.p0.c3.a();
        this.p = new c(this, 2000994);
        this.q = new d(this, 2921387);
        this.r = new c.a.p0.c3.b(this);
        this.f13471b = fVar;
        this.f13472c = c.a.d.f.p.n.i(fVar.getPageActivity());
        this.f13474e = pVar;
        BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.i = new n();
        fVar.registerListener(this.p);
        fVar.registerListener(this.n);
        fVar.registerListener(this.m);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.o);
            c.a.d.f.m.e.a().removeCallbacks(this.r);
            i();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i = 0; i < this.f13474e.getListView().getChildCount(); i++) {
                View childAt = this.f13474e.getListView().getChildAt(i);
                if (childAt.getTag() instanceof e) {
                    ((e) childAt.getTag()).stopPlay();
                }
            }
        }
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f13475f : (View) invokeV.objValue;
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
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) {
            if (view == null) {
                return false;
            }
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            int i2 = this.a;
            if (i2 == 1) {
                int i3 = c.a.d.f.p.n.i(this.f13471b.getPageActivity()) / 2;
                int i4 = rect.top;
                return i4 >= 0 && i4 <= i3 && rect.bottom - i4 >= view.getMeasuredHeight();
            } else if (i2 == 2) {
                int j = c.a.d.f.p.n.j(this.f13471b.getPageActivity(), true);
                float measuredHeight = (view.getMeasuredHeight() * 2.0f) / 3.0f;
                float statusBarHeight = UtilHelper.getStatusBarHeight() + measuredHeight + c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds104);
                int mainTabBottomBarHeight = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
                if (this.j) {
                    this.k = measuredHeight + mainTabBottomBarHeight;
                } else {
                    this.k = measuredHeight;
                }
                return ((float) rect.top) <= ((float) j) - this.k && ((float) rect.bottom) >= statusBarHeight;
            } else {
                int i5 = rect.top;
                return i5 >= 0 && (i = rect.bottom) <= this.f13472c - this.f13473d && i - i5 >= view.getMeasuredHeight();
            }
        }
        return invokeL.booleanValue;
    }

    public void m(int i, int i2, boolean z, int i3) {
        boolean z2;
        boolean z3;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) {
            this.i.e(i, i2, z);
            c.a.d.o.e.p pVar = this.f13474e;
            if (pVar == null || pVar.getListView().getChildCount() == 0 || this.f13474e.getContentViewsCount() == 0) {
                return;
            }
            e eVar = this.f13477h;
            if (eVar != null && !l(eVar.getVideoContainer())) {
                this.f13477h.stopPlay();
            }
            View view2 = this.f13475f;
            int i4 = 0;
            if (view2 != null && (view2.getTag() instanceof e) && this.f13476g) {
                if (l(((e) this.f13475f.getTag()).getVideoContainer())) {
                    w(i3, this.f13475f);
                    this.f13476g = false;
                    return;
                }
                this.f13475f = null;
            }
            int contentViewsCount = this.f13474e.getContentViewsCount() + this.f13474e.getHeaderViewsCount() + this.f13474e.getFooterViewsCount();
            if (i == 0) {
                z2 = true;
            } else {
                int i5 = contentViewsCount - 1;
                z2 = false;
            }
            int childCount = this.f13474e.getListView().getChildCount();
            if (i == 0 || i2 == contentViewsCount - 1) {
                z3 = false;
                for (int i6 = 0; i6 < childCount; i6++) {
                    View childAt = this.f13474e.getListView().getChildAt(z2 ? i6 : (childCount - 1) - i6);
                    if (childAt.getTag() instanceof e) {
                        e eVar2 = (e) childAt.getTag();
                        if (!z3 && l(eVar2.getVideoContainer())) {
                            w(i3, childAt);
                            z3 = true;
                        } else {
                            z(i3, childAt);
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
                if (i8 >= childCount) {
                    break;
                }
                View childAt2 = this.f13474e.getListView().getChildAt(i8);
                if (childAt2.getTag() instanceof e) {
                    e eVar3 = (e) childAt2.getTag();
                    if (eVar3.isPlayStarted() && l(eVar3.getVideoContainer())) {
                        i7 = i8;
                        break;
                    }
                }
                i8++;
            }
            if (i7 >= 0) {
                while (i4 < childCount) {
                    View childAt3 = this.f13474e.getListView().getChildAt(i4);
                    if (i4 != i7) {
                        z(i3, childAt3);
                    } else {
                        w(i3, childAt3);
                    }
                    i4++;
                }
                return;
            }
            boolean z4 = false;
            while (i4 < childCount) {
                View childAt4 = this.f13474e.getListView().getChildAt(z ? (childCount - 1) - i4 : i4);
                if (childAt4.getTag() instanceof e) {
                    e eVar4 = (e) childAt4.getTag();
                    if (!z4 && (eVar4.isFullScreen() || l(eVar4.getVideoContainer()))) {
                        w(i3, childAt4);
                        z4 = true;
                    } else {
                        z(i3, childAt4);
                    }
                }
                i4++;
            }
            if (z4 || (view = this.f13475f) == null || !(view.getTag() instanceof e)) {
                return;
            }
            ((e) this.f13475f.getTag()).stopPlay();
        }
    }

    public void n(int i, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.r);
            this.r.a(i);
            this.r.c(i2);
            this.r.b(z);
            this.r.d(z2);
            this.i.f(z2);
            c.a.d.f.m.e.a().postDelayed(this.r, 500L);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.l) {
            View view = this.f13475f;
            if (view != null && (view.getTag() instanceof e)) {
                e eVar = (e) this.f13475f.getTag();
                if (this.f13476g) {
                    eVar.startPlay();
                    this.f13476g = false;
                }
                if (this.f13475f.getTag() instanceof c.a.p0.c3.d) {
                    ((c.a.p0.c3.d) this.f13475f.getTag()).c();
                }
            }
            this.f13475f = null;
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.a = i;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.j = z;
        }
    }

    public void r(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.l = z;
            if (z || (view = this.f13475f) == null || !(view.getTag() instanceof e) || ((e) this.f13475f.getTag()).getVideoContainer() == null) {
                return;
            }
            ((e) this.f13475f.getTag()).getVideoContainer().setTag(-1001, "1");
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
        }
    }

    public void u(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        CustomMessageListener customMessageListener = this.p;
        if (customMessageListener != null) {
            customMessageListener.setTag(bdUniqueId);
        }
        CustomMessageListener customMessageListener2 = this.q;
        if (customMessageListener2 != null) {
            customMessageListener2.setSelfListener(true);
            this.q.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.p);
        MessageManager.getInstance().registerListener(this.q);
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.f13473d = i;
        }
    }

    public final void w(int i, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048591, this, i, view) == null) || view == null) {
            return;
        }
        View view2 = this.f13475f;
        if (view2 != null && view2 != view && (view2.getTag() instanceof e)) {
            ((e) this.f13475f.getTag()).stopPlay();
        }
        this.f13475f = view;
        if (i == 1 && (view.getTag() instanceof e)) {
            e eVar = (e) view.getTag();
            if (!this.l || eVar.isPlayStarted()) {
                return;
            }
            eVar.startPlay();
        } else if (i == 2 && (view.getTag() instanceof c.a.p0.c3.d)) {
            ((c.a.p0.c3.d) view.getTag()).a();
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.o);
            c.a.d.f.m.e.a().removeCallbacks(this.r);
            for (int i = 0; i < this.f13474e.getListView().getChildCount(); i++) {
                View childAt = this.f13474e.getListView().getChildAt(i);
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

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            for (int i = 0; i < this.f13474e.getListView().getChildCount(); i++) {
                View childAt = this.f13474e.getListView().getChildAt(i);
                if (childAt.getTag() instanceof e) {
                    e eVar = (e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        t(eVar.getCurrentPosition());
                        s(eVar.getPlayUrl());
                        this.f13475f = childAt;
                        this.f13476g = eVar.isPlaying();
                        eVar.stopPlay();
                        return;
                    }
                }
            }
        }
    }

    public final void z(int i, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048594, this, i, view) == null) {
            if (i == 1 && (view.getTag() instanceof e)) {
                e eVar = (e) view.getTag();
                if (eVar.isPlaying()) {
                    eVar.stopPlay();
                }
            } else if (i == 2 && (view.getTag() instanceof c.a.p0.c3.d)) {
                ((c.a.p0.c3.d) view.getTag()).d();
            }
        }
    }
}
