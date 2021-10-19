package c.a.r0.q1.t;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import c.a.e.a.i;
import c.a.e.a.j;
import c.a.e.e.p.l;
import c.a.e.l.e.n;
import c.a.q0.s.f0.u.c;
import c.a.r0.q1.o.l.k;
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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ListViewPager f23897a;

    /* renamed from: b  reason: collision with root package name */
    public IndicatorView f23898b;

    /* renamed from: c  reason: collision with root package name */
    public k f23899c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f23900d;

    /* renamed from: e  reason: collision with root package name */
    public BdBaseViewPagerAdapter f23901e;

    /* renamed from: f  reason: collision with root package name */
    public c f23902f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f23903g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f23904h;

    /* renamed from: i  reason: collision with root package name */
    public int f23905i;

    /* renamed from: j  reason: collision with root package name */
    public Context f23906j;
    public List<n> k;
    public ViewPager.OnPageChangeListener l;
    public long m;
    public final Handler.Callback n;
    public final Handler o;
    public ViewPager.OnPageChangeListener p;

    /* loaded from: classes3.dex */
    public class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f23907e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23907e = bVar;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 1 && this.f23907e.k()) {
                    this.f23907e.i();
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* renamed from: c.a.r0.q1.t.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1114b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f23908e;

        public C1114b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23908e = bVar;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            int count;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f23908e.l != null) {
                    this.f23908e.l.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    this.f23908e.s();
                } else if (i2 != 0 || (count = this.f23908e.f23901e.getCount()) < 2) {
                } else {
                    int currentItem = this.f23908e.f23897a.getCurrentItem();
                    int i3 = count - 2;
                    if (currentItem < 1) {
                        this.f23908e.f23897a.setCurrentItem(i3, false);
                    } else if (currentItem > i3) {
                        this.f23908e.f23897a.setCurrentItem(1, false);
                    }
                    this.f23908e.r();
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || this.f23908e.l == null) {
                return;
            }
            this.f23908e.l.onPageScrolled(i2, f2, i3);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && this.f23908e.f23902f != null && this.f23908e.f23902f.a(i2) == i2) {
                if (this.f23908e.f23898b != null) {
                    this.f23908e.f23898b.setPosition(this.f23908e.f23902f.c(i2));
                    if (this.f23908e.f23899c != null) {
                        this.f23908e.f23898b.setVisibility(8);
                        this.f23908e.f23899c.b(this.f23908e.f23902f.c(i2));
                    }
                }
                if (this.f23908e.l != null) {
                    this.f23908e.l.onPageSelected(this.f23908e.f23902f.c(i2));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23903g = false;
        this.f23904h = true;
        this.f23905i = 2;
        this.k = new ArrayList();
        this.m = 5000L;
        this.n = new a(this);
        this.o = new Handler(this.n);
        this.p = new C1114b(this);
        j(context, listViewPager, indicatorView, textView);
    }

    public final void i() {
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f23897a == null || this.f23901e == null) {
            return;
        }
        i c2 = j.c(this.f23906j);
        if ((c2 == null || !c2.isScroll()) && (count = this.f23901e.getCount()) >= 2) {
            int currentItem = this.f23897a.getCurrentItem();
            int i2 = count - 2;
            if (currentItem < 1) {
                this.f23897a.setCurrentItem(i2, false);
            } else if (currentItem > i2) {
                this.f23897a.setCurrentItem(1, false);
            } else {
                this.f23897a.setCurrentItem(currentItem + 1);
            }
        }
    }

    public final void j(Context context, ListViewPager listViewPager, IndicatorView indicatorView, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, listViewPager, indicatorView, textView) == null) {
            this.f23897a = listViewPager;
            this.f23898b = indicatorView;
            this.f23900d = textView;
            this.f23906j = context;
            BdBaseViewPagerAdapter bdBaseViewPagerAdapter = new BdBaseViewPagerAdapter(context);
            this.f23901e = bdBaseViewPagerAdapter;
            ListViewPager listViewPager2 = this.f23897a;
            if (listViewPager2 != null) {
                listViewPager2.setAdapter(bdBaseViewPagerAdapter);
                this.f23897a.setOnPageChangeListener(this.p);
            }
        }
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ListViewPager listViewPager = this.f23897a;
            if (listViewPager == null) {
                return false;
            }
            int[] iArr = new int[2];
            listViewPager.getLocationOnScreen(iArr);
            int measuredHeight = iArr[1] + (this.f23897a.getMeasuredHeight() / 2);
            return measuredHeight > 0 && measuredHeight < l.i(this.f23906j);
        }
        return invokeV.booleanValue;
    }

    public void l(Context context, c.a.q0.s.f0.u.b<?, ?> bVar) {
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, context, bVar) == null) || (bdBaseViewPagerAdapter = this.f23901e) == null) {
            return;
        }
        bdBaseViewPagerAdapter.registerAdapter(context, bVar);
    }

    public void m(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) {
            if (j2 < 0) {
                j2 = 0;
            }
            this.m = j2;
        }
    }

    public void n(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || ListUtils.getCount(list) == 0) {
            return;
        }
        this.k = list;
        c cVar = new c(list, this.f23903g, this.f23905i);
        this.f23902f = cVar;
        cVar.i(2);
        boolean z = true;
        this.f23902f.g(1);
        this.f23901e.setDatas(this.f23902f.e());
        this.f23901e.notifyDataSetChanged();
        this.f23897a.setCurrentItem(this.f23902f.d(), false);
        if (this.f23902f.b() <= 0) {
            return;
        }
        if (this.f23902f.b() > this.f23905i) {
            TextView textView = this.f23900d;
            if (textView != null) {
                textView.setVisibility(0);
                this.f23900d.setOnClickListener(null);
                IndicatorView indicatorView = this.f23898b;
                if (indicatorView != null) {
                    indicatorView.setVisibility(8);
                }
            }
            if (this.f23898b != null && this.f23900d == null && this.f23903g) {
                z = false;
            }
            if (!z) {
                this.f23898b.setVisibility(8);
                int count = this.f23898b.getCount();
                int i2 = this.f23905i;
                if (count != i2) {
                    this.f23898b.setCount(i2);
                }
            }
            r();
        }
        if (this.f23902f.b() >= 2 && this.f23902f.b() <= this.f23905i) {
            TextView textView2 = this.f23900d;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            IndicatorView indicatorView2 = this.f23898b;
            if (indicatorView2 != null) {
                indicatorView2.setVisibility(0);
                if (this.f23898b.getCount() != this.f23902f.b()) {
                    this.f23898b.setCount(this.f23902f.b());
                    k kVar = this.f23899c;
                    if (kVar != null) {
                        kVar.a(this.f23902f.b());
                        this.f23898b.setVisibility(8);
                    }
                } else {
                    k kVar2 = this.f23899c;
                    if (kVar2 != null) {
                        kVar2.a(this.f23902f.b());
                        this.f23898b.setVisibility(8);
                    }
                }
            }
            r();
        }
        if (this.f23902f.b() < 2) {
            TextView textView3 = this.f23900d;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            IndicatorView indicatorView3 = this.f23898b;
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
                this.f23898b.setVisibility(8);
            } else {
                this.f23898b.setVisibility(0);
            }
            this.f23899c = kVar;
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f23905i = i2;
            c cVar = this.f23902f;
            if (cVar != null) {
                cVar.h(i2);
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
            if (this.f23904h) {
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
