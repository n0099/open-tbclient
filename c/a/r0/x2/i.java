package c.a.r0.x2;

import android.graphics.Rect;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.d.a.f f25393b;

    /* renamed from: c  reason: collision with root package name */
    public int f25394c;

    /* renamed from: d  reason: collision with root package name */
    public int f25395d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.d.m.e.p f25396e;

    /* renamed from: f  reason: collision with root package name */
    public View f25397f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f25398g;

    /* renamed from: h  reason: collision with root package name */
    public e f25399h;

    /* renamed from: i  reason: collision with root package name */
    public l f25400i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f25401j;

    /* renamed from: k  reason: collision with root package name */
    public CustomMessageListener f25402k;
    public CustomMessageListener l;
    public c.a.r0.x2.a m;
    public final CustomMessageListener n;
    public final CustomMessageListener o;
    public c.a.r0.x2.b p;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

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
            this.a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                return;
            }
            c.a.d.f.m.e.a().postDelayed(this.a.p, 500L);
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

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
            this.a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            c.a.d.f.m.e.a().postDelayed(this.a.p, 500L);
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(i iVar, int i2) {
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
            this.a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                this.a.w();
                if (this.a.f25401j && this.a.f25401j) {
                    i iVar = this.a;
                    iVar.n(iVar.f25400i.a(), this.a.f25400i.b(), this.a.f25400i.d(), this.a.f25400i.c());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(i iVar, int i2) {
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
            this.a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921387 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (c.a.d.f.p.k.isEmpty(str)) {
                    return;
                }
                c.a.d.f.m.e.a().removeCallbacks(this.a.m);
                c.a.d.f.m.e.a().removeCallbacks(this.a.p);
                if (this.a.f25397f != null && (this.a.f25397f.getTag() instanceof e)) {
                    if (str.equals(((e) this.a.f25397f.getTag()).getPlayUrl())) {
                        return;
                    }
                    ((e) this.a.f25397f.getTag()).stopPlay();
                }
                for (int i2 = 0; i2 < this.a.f25396e.getListView().getChildCount(); i2++) {
                    View childAt = this.a.f25396e.getListView().getChildAt(i2);
                    if ((childAt.getTag() instanceof e) && str.equals(((e) childAt.getTag()).getPlayUrl())) {
                        this.a.f25397f = childAt;
                        return;
                    }
                }
            }
        }
    }

    public i(c.a.d.a.f fVar, c.a.d.m.e.p pVar) {
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
        this.a = 0;
        this.f25394c = 0;
        this.f25395d = 0;
        this.f25398g = false;
        this.f25401j = true;
        this.f25402k = new a(this, 2921637);
        this.l = new b(this, 2921636);
        this.m = new c.a.r0.x2.a();
        this.n = new c(this, 2000994);
        this.o = new d(this, 2921387);
        this.p = new c.a.r0.x2.b(this);
        this.f25393b = fVar;
        this.f25394c = c.a.d.f.p.l.i(fVar.getPageActivity());
        this.f25396e = pVar;
        BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.f25400i = new l();
        fVar.registerListener(this.n);
        fVar.registerListener(this.l);
        fVar.registerListener(this.f25402k);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.m);
            c.a.d.f.m.e.a().removeCallbacks(this.p);
            i();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i2 = 0; i2 < this.f25396e.getListView().getChildCount(); i2++) {
                View childAt = this.f25396e.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    ((e) childAt.getTag()).stopPlay();
                }
            }
        }
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f25397f : (View) invokeV.objValue;
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
            if (this.a == 1) {
                int i3 = c.a.d.f.p.l.i(this.f25393b.getPageActivity()) / 2;
                int i4 = rect.top;
                return i4 >= 0 && i4 <= i3 && rect.bottom - i4 >= view.getMeasuredHeight();
            }
            int i5 = rect.top;
            return i5 >= 0 && (i2 = rect.bottom) <= this.f25394c - this.f25395d && i2 - i5 >= view.getMeasuredHeight();
        }
        return invokeL.booleanValue;
    }

    public void m(int i2, int i3, boolean z, int i4) {
        boolean z2;
        boolean z3;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(i4)}) == null) {
            this.f25400i.e(i2, i3, z);
            c.a.d.m.e.p pVar = this.f25396e;
            if (pVar == null || pVar.getListView().getChildCount() == 0 || this.f25396e.getContentViewsCount() == 0) {
                return;
            }
            e eVar = this.f25399h;
            if (eVar != null && !l(eVar.getVideoContainer())) {
                this.f25399h.stopPlay();
            }
            View view2 = this.f25397f;
            int i5 = 0;
            if (view2 != null && (view2.getTag() instanceof e) && this.f25398g) {
                if (l(((e) this.f25397f.getTag()).getVideoContainer())) {
                    v(i4, this.f25397f);
                    this.f25398g = false;
                    return;
                }
                this.f25397f = null;
            }
            int contentViewsCount = this.f25396e.getContentViewsCount() + this.f25396e.getHeaderViewsCount() + this.f25396e.getFooterViewsCount();
            if (i2 == 0) {
                z2 = true;
            } else {
                int i6 = contentViewsCount - 1;
                z2 = false;
            }
            int childCount = this.f25396e.getListView().getChildCount();
            if (i2 == 0 || i3 == contentViewsCount - 1) {
                z3 = false;
                for (int i7 = 0; i7 < childCount; i7++) {
                    View childAt = this.f25396e.getListView().getChildAt(z2 ? i7 : (childCount - 1) - i7);
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
                View childAt2 = this.f25396e.getListView().getChildAt(i9);
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
                    View childAt3 = this.f25396e.getListView().getChildAt(i5);
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
                View childAt4 = this.f25396e.getListView().getChildAt(z ? (childCount - 1) - i5 : i5);
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
            if (z4 || (view = this.f25397f) == null || !(view.getTag() instanceof e)) {
                return;
            }
            ((e) this.f25397f.getTag()).stopPlay();
        }
    }

    public void n(int i2, int i3, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.p);
            this.p.a(i2);
            this.p.c(i3);
            this.p.b(z);
            this.p.d(z2);
            this.f25400i.f(z2);
            c.a.d.f.m.e.a().postDelayed(this.p, 500L);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f25401j) {
            View view = this.f25397f;
            if (view != null && (view.getTag() instanceof e)) {
                e eVar = (e) this.f25397f.getTag();
                if (this.f25398g) {
                    eVar.startPlay();
                    this.f25398g = false;
                }
                if (this.f25397f.getTag() instanceof c.a.r0.x2.d) {
                    ((c.a.r0.x2.d) this.f25397f.getTag()).displayAllWithoutAnim();
                }
            }
            this.f25397f = null;
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.a = i2;
        }
    }

    public void q(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f25401j = z;
            if (z || (view = this.f25397f) == null || !(view.getTag() instanceof e) || ((e) this.f25397f.getTag()).getVideoContainer() == null) {
                return;
            }
            ((e) this.f25397f.getTag()).getVideoContainer().setTag(-1001, "1");
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
        CustomMessageListener customMessageListener = this.n;
        if (customMessageListener != null) {
            customMessageListener.setTag(bdUniqueId);
        }
        CustomMessageListener customMessageListener2 = this.o;
        if (customMessageListener2 != null) {
            customMessageListener2.setSelfListener(true);
            this.o.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.n);
        MessageManager.getInstance().registerListener(this.o);
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f25395d = i2;
        }
    }

    public final void v(int i2, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048590, this, i2, view) == null) || view == null) {
            return;
        }
        View view2 = this.f25397f;
        if (view2 != null && view2 != view && (view2.getTag() instanceof e)) {
            ((e) this.f25397f.getTag()).stopPlay();
        }
        this.f25397f = view;
        if (i2 == 1 && (view.getTag() instanceof e)) {
            e eVar = (e) view.getTag();
            if (!this.f25401j || eVar.isPlayStarted()) {
                return;
            }
            eVar.startPlay();
        } else if (i2 == 2 && (view.getTag() instanceof c.a.r0.x2.d)) {
            ((c.a.r0.x2.d) view.getTag()).displayAll();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.m);
            c.a.d.f.m.e.a().removeCallbacks(this.p);
            for (int i2 = 0; i2 < this.f25396e.getListView().getChildCount(); i2++) {
                View childAt = this.f25396e.getListView().getChildAt(i2);
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
            for (int i2 = 0; i2 < this.f25396e.getListView().getChildCount(); i2++) {
                View childAt = this.f25396e.getListView().getChildAt(i2);
                if (childAt.getTag() instanceof e) {
                    e eVar = (e) childAt.getTag();
                    if (eVar.isPlayStarted()) {
                        s(eVar.getCurrentPosition());
                        r(eVar.getPlayUrl());
                        this.f25397f = childAt;
                        this.f25398g = eVar.isPlaying();
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
            } else if (i2 == 2 && (view.getTag() instanceof c.a.r0.x2.d)) {
                ((c.a.r0.x2.d) view.getTag()).hideAll();
            }
        }
    }
}
