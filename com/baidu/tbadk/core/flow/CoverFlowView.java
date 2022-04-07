package com.baidu.tbadk.core.flow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.as4;
import com.repackage.bs4;
import com.repackage.cs4;
import com.repackage.ds4;
import com.repackage.es4;
import com.repackage.fs4;
import java.util.List;
/* loaded from: classes3.dex */
public class CoverFlowView<T extends bs4> extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ListViewPager a;
    public IndicatorView b;
    public ds4 c;
    public View d;
    public CoverFlowAdapter<T> e;
    public as4 f;
    public CoverFlowView<T>.b g;
    public boolean h;
    public boolean i;
    public boolean j;
    public es4<T> k;
    public CoverFlowView<T>.d l;
    public CoverFlowView<T>.c m;
    public long n;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes3.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CoverFlowView a;

        public b(CoverFlowView coverFlowView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverFlowView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = coverFlowView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what != 1) {
                    return;
                }
                this.a.u();
            }
        }

        public /* synthetic */ b(CoverFlowView coverFlowView, a aVar) {
            this(coverFlowView);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CoverFlowView a;

        public c(CoverFlowView coverFlowView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverFlowView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = coverFlowView;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.a == null || this.a.e == null) {
                return;
            }
            if (i != 0) {
                if (i == 1 && !this.a.i) {
                    this.a.w();
                    this.a.m();
                }
            } else if (this.a.j) {
                this.a.o();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v25, resolved type: com.repackage.es4 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) || this.a.b == null || this.a.e == null) {
                return;
            }
            if (this.a.e.getCount() == 1 && i == 0 && this.a.k != null) {
                this.a.k.a(1, this.a.e.b(i));
            }
            if (this.a.b.getVisibility() != 0 || this.a.h) {
                return;
            }
            int count = this.a.e.getCount();
            if (i == 0) {
                this.a.b.setPosition((count - 3) + f);
            } else if (i == count - 1) {
                this.a.b.setPosition(f);
            } else {
                this.a.b.setPosition((i - 1) + f);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.repackage.es4 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.a.e == null) {
                return;
            }
            int count = this.a.e.getCount();
            if (i < 0 || i >= count) {
                return;
            }
            if (this.a.h) {
                this.a.setIndicatorSelected(i);
            }
            if (this.a.k == null) {
                return;
            }
            this.a.k.a(i, this.a.e.b(i));
        }

        public /* synthetic */ c(CoverFlowView coverFlowView, a aVar) {
            this(coverFlowView);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CoverFlowView a;

        public d(CoverFlowView coverFlowView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverFlowView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = coverFlowView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int intValue;
            bs4 b;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.k == null || !(view2.getTag() instanceof Integer) || (b = this.a.e.b((intValue = ((Integer) view2.getTag()).intValue()))) == null) {
                return;
            }
            this.a.k.b(intValue, b.b());
        }

        public /* synthetic */ d(CoverFlowView coverFlowView, a aVar) {
            this(coverFlowView);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoverFlowView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = null;
        this.g = new b(this, null);
        this.h = false;
        this.i = true;
        this.j = true;
        this.l = new d(this, null);
        this.m = new c(this, null);
        this.n = 5000L;
        p(context);
    }

    private boolean getAutoPlayPlayDragging() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? this.i : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIndicatorSelected(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65551, this, i) == null) {
            int count = this.e.getCount();
            if (i == 0) {
                this.b.setPosition(0.0f);
            } else if (i == count - 1) {
                this.b.setPosition(i);
            } else {
                this.b.setPosition(i - 1);
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.g.hasMessages(1)) {
            return;
        }
        v();
    }

    public final boolean m() {
        InterceptResult invokeV;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            CoverFlowAdapter<T> coverFlowAdapter = this.e;
            if (coverFlowAdapter != null && (count = coverFlowAdapter.getCount()) > 1) {
                int currentItem = this.a.getCurrentItem();
                int i = count - 2;
                if (currentItem < 1) {
                    this.a.setCurrentItem(i, false);
                    this.a.invalidate();
                } else if (currentItem > i) {
                    this.a.setCurrentItem(1, false);
                    this.a.invalidate();
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public T n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            CoverFlowAdapter<T> coverFlowAdapter = this.e;
            if (coverFlowAdapter == null) {
                return null;
            }
            return coverFlowAdapter.b(i);
        }
        return (T) invokeI.objValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && m()) {
            t();
        }
    }

    public final void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            r(context);
            q(context);
            setCoverFlowFactory(new cs4());
            addView(this.a);
            addView(this.b);
            CoverFlowAdapter<T> coverFlowAdapter = new CoverFlowAdapter<>(context);
            this.e = coverFlowAdapter;
            coverFlowAdapter.f(this.l);
            this.a.setAdapter(this.e);
            this.a.setOnPageChangeListener(this.m);
        }
    }

    public final void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            IndicatorView indicatorView = new IndicatorView(context);
            this.b = indicatorView;
            indicatorView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        }
    }

    public final void r(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            this.a = new ListViewPager(context);
        }
    }

    public void s() {
        ds4 ds4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.e.c();
            IndicatorView indicatorView = this.b;
            if (indicatorView == null || (ds4Var = this.c) == null) {
                return;
            }
            indicatorView.setDrawable(SkinManager.getDrawable(ds4Var.a()));
            this.b.setSelector(SkinManager.getDrawable(this.c.b()));
        }
    }

    public void setAutoPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.j = z;
        }
    }

    public void setCallback(es4<T> es4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, es4Var) == null) {
            this.k = es4Var;
        }
    }

    public void setCoverFlowFactory(as4 as4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, as4Var) == null) || as4Var == null) {
            return;
        }
        this.f = as4Var;
        ds4 a2 = as4Var.a();
        this.c = a2;
        a2.i(this.b);
        as4Var.c().b(this.a);
        View b2 = as4Var.b();
        this.d = b2;
        if (b2 != null) {
            removeAllViews();
            addView(this.a);
            addView(this.d);
            addView(this.b);
        }
    }

    public void setData(List<T> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        this.e.e(list, this.f);
        int size = list.size();
        if (size > 1) {
            this.b.setVisibility(0);
            this.b.setCount(size);
            this.a.setCurrentItem(1, false);
            this.b.setPosition(0.0f);
            if (this.j) {
                v();
                return;
            }
            return;
        }
        this.b.setVisibility(8);
        this.b.setCount(size);
        this.a.setCurrentItem(1, false);
        this.b.setPosition(0.0f);
        w();
    }

    public void setDisableParentEvent(boolean z) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (listViewPager = this.a) == null) {
            return;
        }
        listViewPager.setDisableParentEvent(z);
    }

    public void setIndicatorNoOffet(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.h = z;
        }
    }

    public void setIndicatorVisible(int i) {
        IndicatorView indicatorView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i) == null) || (indicatorView = this.b) == null) {
            return;
        }
        indicatorView.setVisibility(i);
    }

    public void setIsAutoPlayDragging(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.i = z;
        }
    }

    public void setMarqueenTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            this.n = j;
            t();
        }
    }

    public void setPageMargin(int i) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i) == null) || (listViewPager = this.a) == null) {
            return;
        }
        listViewPager.setPageMargin(i);
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, cVar) == null) || (listViewPager = this.a) == null) {
            return;
        }
        listViewPager.setSwipeControlInterface(cVar);
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.g.removeMessages(1);
            this.g.sendEmptyMessageDelayed(1, this.n);
        }
    }

    public final void u() {
        CoverFlowAdapter<T> coverFlowAdapter;
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || this.a == null || (coverFlowAdapter = this.e) == null || (count = coverFlowAdapter.getCount()) <= 1) {
            return;
        }
        int currentItem = this.a.getCurrentItem();
        int i = count - 2;
        if (currentItem < 1) {
            this.a.setCurrentItem(i, false);
        } else if (currentItem > i) {
            this.a.setCurrentItem(1, false);
        } else {
            this.a.setCurrentItem(currentItem + 1);
        }
        this.a.invalidate();
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            t();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.g.removeMessages(1);
        }
    }

    public void x(fs4 fs4Var) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, fs4Var) == null) || fs4Var == null || (listViewPager = this.a) == null) {
            return;
        }
        fs4Var.b(listViewPager);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.d = null;
        this.g = new b(this, null);
        this.h = false;
        this.i = true;
        this.j = true;
        this.l = new d(this, null);
        this.m = new c(this, null);
        this.n = 5000L;
        p(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = null;
        this.g = new b(this, null);
        this.h = false;
        this.i = true;
        this.j = true;
        this.l = new d(this, null);
        this.m = new c(this, null);
        this.n = 5000L;
        p(context);
    }
}
