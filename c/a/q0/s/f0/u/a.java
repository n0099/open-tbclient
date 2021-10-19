package c.a.q0.s.f0.u;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import c.a.e.a.i;
import c.a.e.a.j;
import c.a.e.l.e.n;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewPager f13949a;

    /* renamed from: b  reason: collision with root package name */
    public IndicatorView f13950b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f13951c;

    /* renamed from: d  reason: collision with root package name */
    public BdBaseViewPagerAdapter f13952d;

    /* renamed from: e  reason: collision with root package name */
    public c f13953e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13954f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13955g;

    /* renamed from: h  reason: collision with root package name */
    public int f13956h;

    /* renamed from: i  reason: collision with root package name */
    public Context f13957i;

    /* renamed from: j  reason: collision with root package name */
    public List<n> f13958j;
    public ViewPager.OnPageChangeListener k;
    public long l;
    public final Handler.Callback m;
    public final Handler n;
    public ViewPager.OnPageChangeListener o;

    /* renamed from: c.a.q0.s.f0.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0686a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f13959e;

        public C0686a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13959e = aVar;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what != 1) {
                    return false;
                }
                this.f13959e.g();
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f13960e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13960e = aVar;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            int count;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f13960e.k != null) {
                    this.f13960e.k.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    this.f13960e.s();
                } else if (i2 != 0 || (count = this.f13960e.f13952d.getCount()) < 2) {
                } else {
                    int currentItem = this.f13960e.f13949a.getCurrentItem();
                    int i3 = count - 2;
                    if (currentItem < 1) {
                        this.f13960e.f13949a.setCurrentItem(i3, false);
                    } else if (currentItem > i3) {
                        this.f13960e.f13949a.setCurrentItem(1, false);
                    }
                    this.f13960e.r();
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || this.f13960e.k == null) {
                return;
            }
            this.f13960e.k.onPageScrolled(i2, f2, i3);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && this.f13960e.f13953e != null && this.f13960e.f13953e.a(i2) == i2) {
                if (this.f13960e.f13950b != null) {
                    this.f13960e.f13950b.setPosition(this.f13960e.f13953e.c(i2));
                }
                if (this.f13960e.k != null) {
                    this.f13960e.k.onPageSelected(this.f13960e.f13953e.c(i2));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13954f = false;
        this.f13955g = true;
        this.f13956h = 2;
        this.f13958j = new ArrayList();
        this.l = 5000L;
        this.m = new C0686a(this);
        this.n = new Handler(this.m);
        this.o = new b(this);
        h(context, viewPager, indicatorView, textView);
    }

    public final void g() {
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f13949a == null || this.f13952d == null) {
            return;
        }
        i c2 = j.c(this.f13957i);
        if ((c2 == null || !c2.isScroll()) && (count = this.f13952d.getCount()) >= 2) {
            int currentItem = this.f13949a.getCurrentItem();
            int i2 = count - 2;
            if (currentItem < 1) {
                this.f13949a.setCurrentItem(i2, false);
            } else if (currentItem > i2) {
                this.f13949a.setCurrentItem(1, false);
            } else {
                this.f13949a.setCurrentItem(currentItem + 1);
            }
        }
    }

    public final void h(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, viewPager, indicatorView, textView) == null) {
            this.f13949a = viewPager;
            this.f13950b = indicatorView;
            this.f13951c = textView;
            this.f13957i = context;
            BdBaseViewPagerAdapter bdBaseViewPagerAdapter = new BdBaseViewPagerAdapter(context);
            this.f13952d = bdBaseViewPagerAdapter;
            ViewPager viewPager2 = this.f13949a;
            if (viewPager2 != null) {
                viewPager2.setAdapter(bdBaseViewPagerAdapter);
                this.f13949a.setOnPageChangeListener(this.o);
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c cVar = this.f13953e;
            if (cVar != null) {
                cVar.j(this.f13958j);
                this.f13952d.setDatas(this.f13953e.e());
            }
            this.f13952d.notifyDataSetChanged();
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f13952d.onSkinTypeChanged(i2);
        }
    }

    public void k(Context context, c.a.q0.s.f0.u.b<?, ?> bVar) {
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, context, bVar) == null) || (bdBaseViewPagerAdapter = this.f13952d) == null) {
            return;
        }
        bdBaseViewPagerAdapter.registerAdapter(context, bVar);
    }

    public void l(Context context, List<c.a.q0.s.f0.u.b<?, ?>> list) {
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, context, list) == null) || (bdBaseViewPagerAdapter = this.f13952d) == null) {
            return;
        }
        bdBaseViewPagerAdapter.registerAdapters(context, list);
    }

    public void m(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            if (j2 < 0) {
                j2 = 0;
            }
            this.l = j2;
        }
    }

    public void n(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, list) == null) || ListUtils.getCount(list) == 0) {
            return;
        }
        this.f13958j = list;
        c cVar = new c(list, this.f13954f, this.f13956h);
        this.f13953e = cVar;
        cVar.i(2);
        this.f13953e.g(1);
        this.f13952d.setDatas(this.f13953e.e());
        this.f13952d.notifyDataSetChanged();
        this.f13949a.setCurrentItem(this.f13953e.d(), false);
        if (this.f13953e.b() <= 0) {
            return;
        }
        if (this.f13953e.b() > this.f13956h) {
            TextView textView = this.f13951c;
            if (textView != null) {
                textView.setVisibility(0);
                this.f13951c.setOnClickListener(null);
                IndicatorView indicatorView = this.f13950b;
                if (indicatorView != null) {
                    indicatorView.setVisibility(8);
                }
            } else {
                IndicatorView indicatorView2 = this.f13950b;
                if (indicatorView2 != null && !this.f13954f) {
                    indicatorView2.setVisibility(8);
                }
            }
            IndicatorView indicatorView3 = this.f13950b;
            if (indicatorView3 != null && indicatorView3.getVisibility() == 0) {
                int count = this.f13950b.getCount();
                int i2 = this.f13956h;
                if (count != i2) {
                    this.f13950b.setCount(i2);
                }
            }
            r();
        }
        if (this.f13953e.b() >= 2 && this.f13953e.b() <= this.f13956h) {
            TextView textView2 = this.f13951c;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            IndicatorView indicatorView4 = this.f13950b;
            if (indicatorView4 != null) {
                indicatorView4.setVisibility(0);
                if (this.f13950b.getCount() != this.f13953e.b()) {
                    this.f13950b.setCount(this.f13953e.b());
                }
            }
            r();
        }
        if (this.f13953e.b() < 2) {
            TextView textView3 = this.f13951c;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            IndicatorView indicatorView5 = this.f13950b;
            if (indicatorView5 != null) {
                indicatorView5.setVisibility(8);
            }
            s();
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f13955g = z;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f13954f = z;
        }
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f13956h = i2;
            c cVar = this.f13953e;
            if (cVar != null) {
                cVar.h(i2);
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.f13955g) {
                this.n.removeMessages(1);
                this.n.sendEmptyMessageDelayed(1, this.l);
                return;
            }
            this.n.removeMessages(1);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.n.removeMessages(1);
        }
    }

    public a(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewPager, indicatorView, textView, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f13954f = false;
        this.f13955g = true;
        this.f13956h = 2;
        this.f13958j = new ArrayList();
        this.l = 5000L;
        this.m = new C0686a(this);
        this.n = new Handler(this.m);
        this.o = new b(this);
        this.f13954f = z;
        this.f13955g = z2;
        q(i2);
        h(context, viewPager, indicatorView, textView);
    }
}
