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
import c.a.q0.s.w.b.a;
import c.a.q0.s.w.b.e;
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
import java.util.List;
/* loaded from: classes9.dex */
public class CoverFlowView<T extends c.a.q0.s.w.b.a> extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ListViewPager f41019e;

    /* renamed from: f  reason: collision with root package name */
    public IndicatorView f41020f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.s.w.b.c f41021g;

    /* renamed from: h  reason: collision with root package name */
    public View f41022h;

    /* renamed from: i  reason: collision with root package name */
    public CoverFlowAdapter<T> f41023i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.q0.s.w.a f41024j;

    /* renamed from: k  reason: collision with root package name */
    public CoverFlowView<T>.b f41025k;
    public boolean l;
    public boolean m;
    public boolean n;
    public c.a.q0.s.w.b.d<T> o;
    public CoverFlowView<T>.d p;
    public CoverFlowView<T>.c q;
    public long r;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes9.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                this.a.q();
            }
        }

        public /* synthetic */ b(CoverFlowView coverFlowView, a aVar) {
            this(coverFlowView);
        }
    }

    /* loaded from: classes9.dex */
    public class c implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CoverFlowView f41026e;

        public c(CoverFlowView coverFlowView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverFlowView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41026e = coverFlowView;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f41026e.f41019e == null || this.f41026e.f41023i == null) {
                return;
            }
            if (i2 != 0) {
                if (i2 == 1 && !this.f41026e.m) {
                    this.f41026e.stopMarqueen();
                    this.f41026e.l();
                }
            } else if (this.f41026e.n) {
                this.f41026e.m();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v25, resolved type: c.a.q0.s.w.b.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || this.f41026e.f41020f == null || this.f41026e.f41023i == null) {
                return;
            }
            if (this.f41026e.f41023i.getCount() == 1 && i2 == 0 && this.f41026e.o != null) {
                this.f41026e.o.a(1, this.f41026e.f41023i.getItem(i2));
            }
            if (this.f41026e.f41020f.getVisibility() != 0 || this.f41026e.l) {
                return;
            }
            int count = this.f41026e.f41023i.getCount();
            if (i2 == 0) {
                this.f41026e.f41020f.setPosition((count - 3) + f2);
            } else if (i2 == count - 1) {
                this.f41026e.f41020f.setPosition(f2);
            } else {
                this.f41026e.f41020f.setPosition((i2 - 1) + f2);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: c.a.q0.s.w.b.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f41026e.f41023i == null) {
                return;
            }
            int count = this.f41026e.f41023i.getCount();
            if (i2 < 0 || i2 >= count) {
                return;
            }
            if (this.f41026e.l) {
                this.f41026e.setIndicatorSelected(i2);
            }
            if (this.f41026e.o == null) {
                return;
            }
            this.f41026e.o.a(i2, this.f41026e.f41023i.getItem(i2));
        }

        public /* synthetic */ c(CoverFlowView coverFlowView, a aVar) {
            this(coverFlowView);
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CoverFlowView f41027e;

        public d(CoverFlowView coverFlowView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverFlowView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41027e = coverFlowView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            c.a.q0.s.w.b.a item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f41027e.o == null || !(view.getTag() instanceof Integer) || (item = this.f41027e.f41023i.getItem((intValue = ((Integer) view.getTag()).intValue()))) == null) {
                return;
            }
            this.f41027e.o.b(intValue, item.b());
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41022h = null;
        this.f41025k = new b(this, null);
        this.l = false;
        this.m = true;
        this.n = true;
        this.p = new d(this, null);
        this.q = new c(this, null);
        this.r = 5000L;
        n(context);
    }

    private boolean getAutoPlayPlayDragging() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? this.m : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIndicatorSelected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65551, this, i2) == null) {
            int count = this.f41023i.getCount();
            if (i2 == 0) {
                this.f41020f.setPosition(0.0f);
            } else if (i2 == count - 1) {
                this.f41020f.setPosition(i2);
            } else {
                this.f41020f.setPosition(i2 - 1);
            }
        }
    }

    public void checkAndStartMarqueen() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f41025k.hasMessages(1)) {
            return;
        }
        startMarqueen();
    }

    public void clearData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f41023i.clear();
        }
    }

    public T getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            CoverFlowAdapter<T> coverFlowAdapter = this.f41023i;
            if (coverFlowAdapter == null) {
                return null;
            }
            return coverFlowAdapter.getItem(i2);
        }
        return (T) invokeI.objValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            CoverFlowAdapter<T> coverFlowAdapter = this.f41023i;
            if (coverFlowAdapter != null && (count = coverFlowAdapter.getCount()) > 1) {
                int currentItem = this.f41019e.getCurrentItem();
                int i2 = count - 2;
                if (currentItem < 1) {
                    this.f41019e.setCurrentItem(i2, false);
                    this.f41019e.invalidate();
                } else if (currentItem > i2) {
                    this.f41019e.setCurrentItem(1, false);
                    this.f41019e.invalidate();
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && l()) {
            resetMarqueen();
        }
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            p(context);
            o(context);
            setCoverFlowFactory(new c.a.q0.s.w.b.b());
            addView(this.f41019e);
            addView(this.f41020f);
            CoverFlowAdapter<T> coverFlowAdapter = new CoverFlowAdapter<>(context);
            this.f41023i = coverFlowAdapter;
            coverFlowAdapter.setOnClickListener(this.p);
            this.f41019e.setAdapter(this.f41023i);
            this.f41019e.setOnPageChangeListener(this.q);
        }
    }

    public final void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            IndicatorView indicatorView = new IndicatorView(context);
            this.f41020f = indicatorView;
            indicatorView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        }
    }

    public void onChangeSkinType() {
        c.a.q0.s.w.b.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f41023i.onChangeSkinType();
            IndicatorView indicatorView = this.f41020f;
            if (indicatorView == null || (cVar = this.f41021g) == null) {
                return;
            }
            indicatorView.setDrawable(SkinManager.getDrawable(cVar.a()));
            this.f41020f.setSelector(SkinManager.getDrawable(this.f41021g.b()));
        }
    }

    public final void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            this.f41019e = new ListViewPager(context);
        }
    }

    public final void q() {
        CoverFlowAdapter<T> coverFlowAdapter;
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f41019e == null || (coverFlowAdapter = this.f41023i) == null || (count = coverFlowAdapter.getCount()) <= 1) {
            return;
        }
        int currentItem = this.f41019e.getCurrentItem();
        int i2 = count - 2;
        if (currentItem < 1) {
            this.f41019e.setCurrentItem(i2, false);
        } else if (currentItem > i2) {
            this.f41019e.setCurrentItem(1, false);
        } else {
            this.f41019e.setCurrentItem(currentItem + 1);
        }
        this.f41019e.invalidate();
    }

    public void resetMarqueen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f41025k.removeMessages(1);
            this.f41025k.sendEmptyMessageDelayed(1, this.r);
        }
    }

    public void setAutoPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.n = z;
        }
    }

    public void setCallback(c.a.q0.s.w.b.d<T> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dVar) == null) {
            this.o = dVar;
        }
    }

    public void setCoverFlowFactory(c.a.q0.s.w.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) || aVar == null) {
            return;
        }
        this.f41024j = aVar;
        c.a.q0.s.w.b.c a2 = aVar.a();
        this.f41021g = a2;
        a2.i(this.f41020f);
        aVar.c().b(this.f41019e);
        View b2 = aVar.b();
        this.f41022h = b2;
        if (b2 != null) {
            removeAllViews();
            addView(this.f41019e);
            addView(this.f41022h);
            addView(this.f41020f);
        }
    }

    public void setData(List<T> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        this.f41023i.setData(list, this.f41024j);
        int size = list.size();
        if (size > 1) {
            this.f41020f.setVisibility(0);
            this.f41020f.setCount(size);
            this.f41019e.setCurrentItem(1, false);
            this.f41020f.setPosition(0.0f);
            if (this.n) {
                startMarqueen();
                return;
            }
            return;
        }
        this.f41020f.setVisibility(8);
        this.f41020f.setCount(size);
        this.f41019e.setCurrentItem(1, false);
        this.f41020f.setPosition(0.0f);
        stopMarqueen();
    }

    public void setDisableParentEvent(boolean z) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (listViewPager = this.f41019e) == null) {
            return;
        }
        listViewPager.setDisableParentEvent(z);
    }

    public void setIndicatorNoOffet(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.l = z;
        }
    }

    public void setIndicatorVisible(int i2) {
        IndicatorView indicatorView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || (indicatorView = this.f41020f) == null) {
            return;
        }
        indicatorView.setVisibility(i2);
    }

    public void setIsAutoPlayDragging(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.m = z;
        }
    }

    public void setMarqueenTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j2) == null) {
            this.r = j2;
            resetMarqueen();
        }
    }

    public void setPageMargin(int i2) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i2) == null) || (listViewPager = this.f41019e) == null) {
            return;
        }
        listViewPager.setPageMargin(i2);
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, cVar) == null) || (listViewPager = this.f41019e) == null) {
            return;
        }
        listViewPager.setSwipeControlInterface(cVar);
    }

    public void startMarqueen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            resetMarqueen();
        }
    }

    public void stopMarqueen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.f41025k.removeMessages(1);
        }
    }

    public void updateViewPager(e eVar) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, eVar) == null) || eVar == null || (listViewPager = this.f41019e) == null) {
            return;
        }
        eVar.b(listViewPager);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoverFlowView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f41022h = null;
        this.f41025k = new b(this, null);
        this.l = false;
        this.m = true;
        this.n = true;
        this.p = new d(this, null);
        this.q = new c(this, null);
        this.r = 5000L;
        n(context);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f41022h = null;
        this.f41025k = new b(this, null);
        this.l = false;
        this.m = true;
        this.n = true;
        this.p = new d(this, null);
        this.q = new c(this, null);
        this.r = 5000L;
        n(context);
    }
}
