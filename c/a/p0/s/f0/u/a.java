package c.a.p0.s.f0.u;

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
    public ViewPager f13976a;

    /* renamed from: b  reason: collision with root package name */
    public IndicatorView f13977b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f13978c;

    /* renamed from: d  reason: collision with root package name */
    public BdBaseViewPagerAdapter f13979d;

    /* renamed from: e  reason: collision with root package name */
    public c f13980e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13981f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13982g;

    /* renamed from: h  reason: collision with root package name */
    public int f13983h;

    /* renamed from: i  reason: collision with root package name */
    public Context f13984i;

    /* renamed from: j  reason: collision with root package name */
    public List<n> f13985j;
    public ViewPager.OnPageChangeListener k;
    public long l;
    public final Handler.Callback m;
    public final Handler n;
    public ViewPager.OnPageChangeListener o;

    /* renamed from: c.a.p0.s.f0.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0686a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f13986e;

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
            this.f13986e = aVar;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what != 1) {
                    return false;
                }
                this.f13986e.g();
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
        public final /* synthetic */ a f13987e;

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
            this.f13987e = aVar;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            int count;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f13987e.k != null) {
                    this.f13987e.k.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    this.f13987e.s();
                } else if (i2 != 0 || (count = this.f13987e.f13979d.getCount()) < 2) {
                } else {
                    int currentItem = this.f13987e.f13976a.getCurrentItem();
                    int i3 = count - 2;
                    if (currentItem < 1) {
                        this.f13987e.f13976a.setCurrentItem(i3, false);
                    } else if (currentItem > i3) {
                        this.f13987e.f13976a.setCurrentItem(1, false);
                    }
                    this.f13987e.r();
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || this.f13987e.k == null) {
                return;
            }
            this.f13987e.k.onPageScrolled(i2, f2, i3);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && this.f13987e.f13980e != null && this.f13987e.f13980e.a(i2) == i2) {
                if (this.f13987e.f13977b != null) {
                    this.f13987e.f13977b.setPosition(this.f13987e.f13980e.c(i2));
                }
                if (this.f13987e.k != null) {
                    this.f13987e.k.onPageSelected(this.f13987e.f13980e.c(i2));
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
        this.f13981f = false;
        this.f13982g = true;
        this.f13983h = 2;
        this.f13985j = new ArrayList();
        this.l = 5000L;
        this.m = new C0686a(this);
        this.n = new Handler(this.m);
        this.o = new b(this);
        h(context, viewPager, indicatorView, textView);
    }

    public final void g() {
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f13976a == null || this.f13979d == null) {
            return;
        }
        i c2 = j.c(this.f13984i);
        if ((c2 == null || !c2.isScroll()) && (count = this.f13979d.getCount()) >= 2) {
            int currentItem = this.f13976a.getCurrentItem();
            int i2 = count - 2;
            if (currentItem < 1) {
                this.f13976a.setCurrentItem(i2, false);
            } else if (currentItem > i2) {
                this.f13976a.setCurrentItem(1, false);
            } else {
                this.f13976a.setCurrentItem(currentItem + 1);
            }
        }
    }

    public final void h(Context context, ViewPager viewPager, IndicatorView indicatorView, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, viewPager, indicatorView, textView) == null) {
            this.f13976a = viewPager;
            this.f13977b = indicatorView;
            this.f13978c = textView;
            this.f13984i = context;
            BdBaseViewPagerAdapter bdBaseViewPagerAdapter = new BdBaseViewPagerAdapter(context);
            this.f13979d = bdBaseViewPagerAdapter;
            ViewPager viewPager2 = this.f13976a;
            if (viewPager2 != null) {
                viewPager2.setAdapter(bdBaseViewPagerAdapter);
                this.f13976a.setOnPageChangeListener(this.o);
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c cVar = this.f13980e;
            if (cVar != null) {
                cVar.j(this.f13985j);
                this.f13979d.setDatas(this.f13980e.e());
            }
            this.f13979d.notifyDataSetChanged();
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f13979d.onSkinTypeChanged(i2);
        }
    }

    public void k(Context context, c.a.p0.s.f0.u.b<?, ?> bVar) {
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, context, bVar) == null) || (bdBaseViewPagerAdapter = this.f13979d) == null) {
            return;
        }
        bdBaseViewPagerAdapter.registerAdapter(context, bVar);
    }

    public void l(Context context, List<c.a.p0.s.f0.u.b<?, ?>> list) {
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, context, list) == null) || (bdBaseViewPagerAdapter = this.f13979d) == null) {
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
        this.f13985j = list;
        c cVar = new c(list, this.f13981f, this.f13983h);
        this.f13980e = cVar;
        cVar.i(2);
        this.f13980e.g(1);
        this.f13979d.setDatas(this.f13980e.e());
        this.f13979d.notifyDataSetChanged();
        this.f13976a.setCurrentItem(this.f13980e.d(), false);
        if (this.f13980e.b() <= 0) {
            return;
        }
        if (this.f13980e.b() > this.f13983h) {
            TextView textView = this.f13978c;
            if (textView != null) {
                textView.setVisibility(0);
                this.f13978c.setOnClickListener(null);
                IndicatorView indicatorView = this.f13977b;
                if (indicatorView != null) {
                    indicatorView.setVisibility(8);
                }
            } else {
                IndicatorView indicatorView2 = this.f13977b;
                if (indicatorView2 != null && !this.f13981f) {
                    indicatorView2.setVisibility(8);
                }
            }
            IndicatorView indicatorView3 = this.f13977b;
            if (indicatorView3 != null && indicatorView3.getVisibility() == 0) {
                int count = this.f13977b.getCount();
                int i2 = this.f13983h;
                if (count != i2) {
                    this.f13977b.setCount(i2);
                }
            }
            r();
        }
        if (this.f13980e.b() >= 2 && this.f13980e.b() <= this.f13983h) {
            TextView textView2 = this.f13978c;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            IndicatorView indicatorView4 = this.f13977b;
            if (indicatorView4 != null) {
                indicatorView4.setVisibility(0);
                if (this.f13977b.getCount() != this.f13980e.b()) {
                    this.f13977b.setCount(this.f13980e.b());
                }
            }
            r();
        }
        if (this.f13980e.b() < 2) {
            TextView textView3 = this.f13978c;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            IndicatorView indicatorView5 = this.f13977b;
            if (indicatorView5 != null) {
                indicatorView5.setVisibility(8);
            }
            s();
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f13982g = z;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f13981f = z;
        }
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f13983h = i2;
            c cVar = this.f13980e;
            if (cVar != null) {
                cVar.h(i2);
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.f13982g) {
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
        this.f13981f = false;
        this.f13982g = true;
        this.f13983h = 2;
        this.f13985j = new ArrayList();
        this.l = 5000L;
        this.m = new C0686a(this);
        this.n = new Handler(this.m);
        this.o = new b(this);
        this.f13981f = z;
        this.f13982g = z2;
        q(i2);
        h(context, viewPager, indicatorView, textView);
    }
}
