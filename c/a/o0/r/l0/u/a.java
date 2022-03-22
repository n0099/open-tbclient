package c.a.o0.r.l0.u;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import c.a.d.a.i;
import c.a.d.a.j;
import c.a.d.o.e.n;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewPager a;

    /* renamed from: b  reason: collision with root package name */
    public IndicatorView f10704b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f10705c;

    /* renamed from: d  reason: collision with root package name */
    public BdBaseViewPagerAdapter f10706d;

    /* renamed from: e  reason: collision with root package name */
    public c f10707e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10708f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10709g;

    /* renamed from: h  reason: collision with root package name */
    public int f10710h;
    public Context i;
    public List<n> j;
    public ViewPager.OnPageChangeListener k;
    public long l;
    public final Handler.Callback m;
    public final Handler n;
    public ViewPager.OnPageChangeListener o;

    /* renamed from: c.a.o0.r.l0.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0833a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0833a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what != 1) {
                    return false;
                }
                this.a.g();
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            int count;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (this.a.k != null) {
                    this.a.k.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    this.a.p();
                } else if (i != 0 || (count = this.a.f10706d.getCount()) < 2) {
                } else {
                    int currentItem = this.a.a.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        this.a.a.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        this.a.a.setCurrentItem(1, false);
                    }
                    this.a.o();
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(i2)}) == null) || this.a.k == null) {
                return;
            }
            this.a.k.onPageScrolled(i, f2, i2);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && this.a.f10707e != null && this.a.f10707e.a(i) == i) {
                if (this.a.f10704b != null) {
                    this.a.f10704b.setPosition(this.a.f10707e.c(i));
                }
                if (this.a.k != null) {
                    this.a.k.onPageSelected(this.a.f10707e.c(i));
                }
            }
        }
    }

    public a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewPager, indicatorView, textView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10708f = false;
        this.f10709g = true;
        this.f10710h = 2;
        this.j = new ArrayList();
        this.l = 5000L;
        this.m = new C0833a(this);
        this.n = new Handler(this.m);
        this.o = new b(this);
        h(context, viewPager, indicatorView, textView);
    }

    public final void g() {
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a == null || this.f10706d == null) {
            return;
        }
        i c2 = j.c(this.i);
        if ((c2 == null || !c2.isScroll()) && (count = this.f10706d.getCount()) >= 2) {
            int currentItem = this.a.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.a.setCurrentItem(i, false);
            } else if (currentItem > i) {
                this.a.setCurrentItem(1, false);
            } else {
                this.a.setCurrentItem(currentItem + 1);
            }
        }
    }

    public final void h(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, viewPager, indicatorView, textView) == null) {
            this.a = viewPager;
            this.f10704b = indicatorView;
            this.f10705c = textView;
            this.i = context;
            BdBaseViewPagerAdapter bdBaseViewPagerAdapter = new BdBaseViewPagerAdapter(context);
            this.f10706d = bdBaseViewPagerAdapter;
            ViewPager viewPager2 = this.a;
            if (viewPager2 != null) {
                viewPager2.setAdapter(bdBaseViewPagerAdapter);
                this.a.setOnPageChangeListener(this.o);
            }
        }
    }

    public void i(Context context, c.a.o0.r.l0.u.b<?, ?> bVar) {
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, bVar) == null) || (bdBaseViewPagerAdapter = this.f10706d) == null) {
            return;
        }
        bdBaseViewPagerAdapter.g(context, bVar);
    }

    public void j(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            if (j < 0) {
                j = 0;
            }
            this.l = j;
        }
    }

    public void k(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || ListUtils.getCount(list) == 0) {
            return;
        }
        this.j = list;
        c cVar = new c(list, this.f10708f, this.f10710h);
        this.f10707e = cVar;
        cVar.i(2);
        this.f10707e.g(1);
        this.f10706d.h(this.f10707e.e());
        this.f10706d.notifyDataSetChanged();
        this.a.setCurrentItem(this.f10707e.d(), false);
        if (this.f10707e.b() <= 0) {
            return;
        }
        if (this.f10707e.b() > this.f10710h) {
            TextView textView = this.f10705c;
            if (textView != null) {
                textView.setVisibility(0);
                this.f10705c.setOnClickListener(null);
                IndicatorView indicatorView = this.f10704b;
                if (indicatorView != null) {
                    indicatorView.setVisibility(8);
                }
            } else {
                IndicatorView indicatorView2 = this.f10704b;
                if (indicatorView2 != null && !this.f10708f) {
                    indicatorView2.setVisibility(8);
                }
            }
            IndicatorView indicatorView3 = this.f10704b;
            if (indicatorView3 != null && indicatorView3.getVisibility() == 0) {
                int count = this.f10704b.getCount();
                int i = this.f10710h;
                if (count != i) {
                    this.f10704b.setCount(i);
                }
            }
            o();
        }
        if (this.f10707e.b() >= 2 && this.f10707e.b() <= this.f10710h) {
            TextView textView2 = this.f10705c;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            IndicatorView indicatorView4 = this.f10704b;
            if (indicatorView4 != null) {
                indicatorView4.setVisibility(0);
                if (this.f10704b.getCount() != this.f10707e.b()) {
                    this.f10704b.setCount(this.f10707e.b());
                }
            }
            o();
        }
        if (this.f10707e.b() < 2) {
            TextView textView3 = this.f10705c;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            IndicatorView indicatorView5 = this.f10704b;
            if (indicatorView5 != null) {
                indicatorView5.setVisibility(8);
            }
            p();
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f10709g = z;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f10708f = z;
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.f10710h = i;
            c cVar = this.f10707e;
            if (cVar != null) {
                cVar.h(i);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.f10709g) {
                this.n.removeMessages(1);
                this.n.sendEmptyMessageDelayed(1, this.l);
                return;
            }
            this.n.removeMessages(1);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.n.removeMessages(1);
        }
    }

    public a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewPager, indicatorView, textView, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f10708f = false;
        this.f10709g = true;
        this.f10710h = 2;
        this.j = new ArrayList();
        this.l = 5000L;
        this.m = new C0833a(this);
        this.n = new Handler(this.m);
        this.o = new b(this);
        this.f10708f = z;
        this.f10709g = z2;
        n(i);
        h(context, viewPager, indicatorView, textView);
    }
}
