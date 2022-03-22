package c.a.p0.b2.t;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import c.a.d.a.i;
import c.a.d.a.j;
import c.a.d.o.e.n;
import c.a.o0.r.l0.u.c;
import c.a.p0.b2.o.l.k;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ListViewPager a;

    /* renamed from: b  reason: collision with root package name */
    public IndicatorView f12602b;

    /* renamed from: c  reason: collision with root package name */
    public k f12603c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f12604d;

    /* renamed from: e  reason: collision with root package name */
    public BdBaseViewPagerAdapter f12605e;

    /* renamed from: f  reason: collision with root package name */
    public c f12606f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12607g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12608h;
    public int i;
    public Context j;
    public List<n> k;
    public ViewPager.OnPageChangeListener l;
    public long m;
    public final Handler.Callback n;
    public final Handler o;
    public ViewPager.OnPageChangeListener p;

    /* loaded from: classes2.dex */
    public class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 1 && this.a.k()) {
                    this.a.i();
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* renamed from: c.a.p0.b2.t.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0950b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C0950b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            int count;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (this.a.l != null) {
                    this.a.l.onPageScrollStateChanged(i);
                }
                if (i == 1) {
                    this.a.s();
                } else if (i != 0 || (count = this.a.f12605e.getCount()) < 2) {
                } else {
                    int currentItem = this.a.a.getCurrentItem();
                    int i2 = count - 2;
                    if (currentItem < 1) {
                        this.a.a.setCurrentItem(i2, false);
                    } else if (currentItem > i2) {
                        this.a.a.setCurrentItem(1, false);
                    }
                    this.a.r();
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(i2)}) == null) || this.a.l == null) {
                return;
            }
            this.a.l.onPageScrolled(i, f2, i2);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && this.a.f12606f != null && this.a.f12606f.a(i) == i) {
                if (this.a.f12602b != null) {
                    this.a.f12602b.setPosition(this.a.f12606f.c(i));
                    if (this.a.f12603c != null) {
                        this.a.f12602b.setVisibility(8);
                        this.a.f12603c.b(this.a.f12606f.c(i));
                    }
                }
                if (this.a.l != null) {
                    this.a.l.onPageSelected(this.a.f12606f.c(i));
                }
            }
        }
    }

    public b(Context context, ListViewPager listViewPager, IndicatorView indicatorView, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, listViewPager, indicatorView, textView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12607g = false;
        this.f12608h = true;
        this.i = 2;
        this.k = new ArrayList();
        this.m = 5000L;
        this.n = new a(this);
        this.o = new Handler(this.n);
        this.p = new C0950b(this);
        j(context, listViewPager, indicatorView, textView);
    }

    public final void i() {
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a == null || this.f12605e == null) {
            return;
        }
        i c2 = j.c(this.j);
        if ((c2 == null || !c2.isScroll()) && (count = this.f12605e.getCount()) >= 2) {
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

    public final void j(Context context, ListViewPager listViewPager, IndicatorView indicatorView, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, listViewPager, indicatorView, textView) == null) {
            this.a = listViewPager;
            this.f12602b = indicatorView;
            this.f12604d = textView;
            this.j = context;
            BdBaseViewPagerAdapter bdBaseViewPagerAdapter = new BdBaseViewPagerAdapter(context);
            this.f12605e = bdBaseViewPagerAdapter;
            ListViewPager listViewPager2 = this.a;
            if (listViewPager2 != null) {
                listViewPager2.setAdapter(bdBaseViewPagerAdapter);
                this.a.setOnPageChangeListener(this.p);
            }
        }
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ListViewPager listViewPager = this.a;
            if (listViewPager == null) {
                return false;
            }
            int[] iArr = new int[2];
            listViewPager.getLocationOnScreen(iArr);
            int measuredHeight = iArr[1] + (this.a.getMeasuredHeight() / 2);
            return measuredHeight > 0 && measuredHeight < c.a.d.f.p.n.i(this.j);
        }
        return invokeV.booleanValue;
    }

    public void l(Context context, c.a.o0.r.l0.u.b<?, ?> bVar) {
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, context, bVar) == null) || (bdBaseViewPagerAdapter = this.f12605e) == null) {
            return;
        }
        bdBaseViewPagerAdapter.g(context, bVar);
    }

    public void m(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            if (j < 0) {
                j = 0;
            }
            this.m = j;
        }
    }

    public void n(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || ListUtils.getCount(list) == 0) {
            return;
        }
        this.k = list;
        c cVar = new c(list, this.f12607g, this.i);
        this.f12606f = cVar;
        cVar.i(2);
        boolean z = true;
        this.f12606f.g(1);
        this.f12605e.h(this.f12606f.e());
        this.f12605e.notifyDataSetChanged();
        this.a.setCurrentItem(this.f12606f.d(), false);
        if (this.f12606f.b() <= 0) {
            return;
        }
        if (this.f12606f.b() > this.i) {
            TextView textView = this.f12604d;
            if (textView != null) {
                textView.setVisibility(0);
                this.f12604d.setOnClickListener(null);
                IndicatorView indicatorView = this.f12602b;
                if (indicatorView != null) {
                    indicatorView.setVisibility(8);
                }
            }
            if (this.f12602b != null && this.f12604d == null && this.f12607g) {
                z = false;
            }
            if (!z) {
                this.f12602b.setVisibility(8);
                int count = this.f12602b.getCount();
                int i = this.i;
                if (count != i) {
                    this.f12602b.setCount(i);
                }
            }
            r();
        }
        if (this.f12606f.b() >= 2 && this.f12606f.b() <= this.i) {
            TextView textView2 = this.f12604d;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            IndicatorView indicatorView2 = this.f12602b;
            if (indicatorView2 != null) {
                indicatorView2.setVisibility(0);
                if (this.f12602b.getCount() != this.f12606f.b()) {
                    this.f12602b.setCount(this.f12606f.b());
                    k kVar = this.f12603c;
                    if (kVar != null) {
                        kVar.a(this.f12606f.b());
                        this.f12602b.setVisibility(8);
                    }
                } else {
                    k kVar2 = this.f12603c;
                    if (kVar2 != null) {
                        kVar2.a(this.f12606f.b());
                        this.f12602b.setVisibility(8);
                    }
                }
            }
            r();
        }
        if (this.f12606f.b() < 2) {
            TextView textView3 = this.f12604d;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            IndicatorView indicatorView3 = this.f12602b;
            if (indicatorView3 != null) {
                indicatorView3.setVisibility(8);
            }
            s();
        }
    }

    public void o(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, kVar) == null) {
            if (kVar != null) {
                this.f12602b.setVisibility(8);
            } else {
                this.f12602b.setVisibility(0);
            }
            this.f12603c = kVar;
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.i = i;
            c cVar = this.f12606f;
            if (cVar != null) {
                cVar.h(i);
            }
        }
    }

    public void q(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onPageChangeListener) == null) {
            this.l = onPageChangeListener;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.f12608h) {
                this.o.removeMessages(1);
                this.o.sendEmptyMessageDelayed(1, this.m);
                return;
            }
            this.o.removeMessages(1);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.o.removeMessages(1);
        }
    }
}
