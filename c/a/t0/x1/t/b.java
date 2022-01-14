package c.a.t0.x1.t;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import c.a.d.a.i;
import c.a.d.a.j;
import c.a.d.n.e.n;
import c.a.s0.s.j0.u.c;
import c.a.t0.x1.o.l.k;
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
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ListViewPager a;

    /* renamed from: b  reason: collision with root package name */
    public IndicatorView f25287b;

    /* renamed from: c  reason: collision with root package name */
    public k f25288c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f25289d;

    /* renamed from: e  reason: collision with root package name */
    public BdBaseViewPagerAdapter f25290e;

    /* renamed from: f  reason: collision with root package name */
    public c f25291f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f25292g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f25293h;

    /* renamed from: i  reason: collision with root package name */
    public int f25294i;

    /* renamed from: j  reason: collision with root package name */
    public Context f25295j;
    public List<n> k;
    public ViewPager.OnPageChangeListener l;
    public long m;
    public final Handler.Callback n;
    public final Handler o;
    public ViewPager.OnPageChangeListener p;

    /* loaded from: classes8.dex */
    public class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f25296e;

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
            this.f25296e = bVar;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 1 && this.f25296e.k()) {
                    this.f25296e.i();
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* renamed from: c.a.t0.x1.t.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1523b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f25297e;

        public C1523b(b bVar) {
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
            this.f25297e = bVar;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            int count;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f25297e.l != null) {
                    this.f25297e.l.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    this.f25297e.s();
                } else if (i2 != 0 || (count = this.f25297e.f25290e.getCount()) < 2) {
                } else {
                    int currentItem = this.f25297e.a.getCurrentItem();
                    int i3 = count - 2;
                    if (currentItem < 1) {
                        this.f25297e.a.setCurrentItem(i3, false);
                    } else if (currentItem > i3) {
                        this.f25297e.a.setCurrentItem(1, false);
                    }
                    this.f25297e.r();
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || this.f25297e.l == null) {
                return;
            }
            this.f25297e.l.onPageScrolled(i2, f2, i3);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && this.f25297e.f25291f != null && this.f25297e.f25291f.a(i2) == i2) {
                if (this.f25297e.f25287b != null) {
                    this.f25297e.f25287b.setPosition(this.f25297e.f25291f.c(i2));
                    if (this.f25297e.f25288c != null) {
                        this.f25297e.f25287b.setVisibility(8);
                        this.f25297e.f25288c.b(this.f25297e.f25291f.c(i2));
                    }
                }
                if (this.f25297e.l != null) {
                    this.f25297e.l.onPageSelected(this.f25297e.f25291f.c(i2));
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
        this.f25292g = false;
        this.f25293h = true;
        this.f25294i = 2;
        this.k = new ArrayList();
        this.m = 5000L;
        this.n = new a(this);
        this.o = new Handler(this.n);
        this.p = new C1523b(this);
        j(context, listViewPager, indicatorView, textView);
    }

    public final void i() {
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a == null || this.f25290e == null) {
            return;
        }
        i c2 = j.c(this.f25295j);
        if ((c2 == null || !c2.isScroll()) && (count = this.f25290e.getCount()) >= 2) {
            int currentItem = this.a.getCurrentItem();
            int i2 = count - 2;
            if (currentItem < 1) {
                this.a.setCurrentItem(i2, false);
            } else if (currentItem > i2) {
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
            this.f25287b = indicatorView;
            this.f25289d = textView;
            this.f25295j = context;
            BdBaseViewPagerAdapter bdBaseViewPagerAdapter = new BdBaseViewPagerAdapter(context);
            this.f25290e = bdBaseViewPagerAdapter;
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
            return measuredHeight > 0 && measuredHeight < c.a.d.f.p.n.i(this.f25295j);
        }
        return invokeV.booleanValue;
    }

    public void l(Context context, c.a.s0.s.j0.u.b<?, ?> bVar) {
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, context, bVar) == null) || (bdBaseViewPagerAdapter = this.f25290e) == null) {
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
        c cVar = new c(list, this.f25292g, this.f25294i);
        this.f25291f = cVar;
        cVar.i(2);
        boolean z = true;
        this.f25291f.g(1);
        this.f25290e.setDatas(this.f25291f.e());
        this.f25290e.notifyDataSetChanged();
        this.a.setCurrentItem(this.f25291f.d(), false);
        if (this.f25291f.b() <= 0) {
            return;
        }
        if (this.f25291f.b() > this.f25294i) {
            TextView textView = this.f25289d;
            if (textView != null) {
                textView.setVisibility(0);
                this.f25289d.setOnClickListener(null);
                IndicatorView indicatorView = this.f25287b;
                if (indicatorView != null) {
                    indicatorView.setVisibility(8);
                }
            }
            if (this.f25287b != null && this.f25289d == null && this.f25292g) {
                z = false;
            }
            if (!z) {
                this.f25287b.setVisibility(8);
                int count = this.f25287b.getCount();
                int i2 = this.f25294i;
                if (count != i2) {
                    this.f25287b.setCount(i2);
                }
            }
            r();
        }
        if (this.f25291f.b() >= 2 && this.f25291f.b() <= this.f25294i) {
            TextView textView2 = this.f25289d;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            IndicatorView indicatorView2 = this.f25287b;
            if (indicatorView2 != null) {
                indicatorView2.setVisibility(0);
                if (this.f25287b.getCount() != this.f25291f.b()) {
                    this.f25287b.setCount(this.f25291f.b());
                    k kVar = this.f25288c;
                    if (kVar != null) {
                        kVar.a(this.f25291f.b());
                        this.f25287b.setVisibility(8);
                    }
                } else {
                    k kVar2 = this.f25288c;
                    if (kVar2 != null) {
                        kVar2.a(this.f25291f.b());
                        this.f25287b.setVisibility(8);
                    }
                }
            }
            r();
        }
        if (this.f25291f.b() < 2) {
            TextView textView3 = this.f25289d;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            IndicatorView indicatorView3 = this.f25287b;
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
                this.f25287b.setVisibility(8);
            } else {
                this.f25287b.setVisibility(0);
            }
            this.f25288c = kVar;
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f25294i = i2;
            c cVar = this.f25291f;
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
            if (this.f25293h) {
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
