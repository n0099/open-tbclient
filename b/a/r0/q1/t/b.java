package b.a.r0.q1.t;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import b.a.e.a.i;
import b.a.e.a.j;
import b.a.e.e.p.l;
import b.a.e.l.e.n;
import b.a.q0.s.g0.u.c;
import b.a.r0.q1.o.l.k;
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
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ListViewPager f22782a;

    /* renamed from: b  reason: collision with root package name */
    public IndicatorView f22783b;

    /* renamed from: c  reason: collision with root package name */
    public k f22784c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f22785d;

    /* renamed from: e  reason: collision with root package name */
    public BdBaseViewPagerAdapter f22786e;

    /* renamed from: f  reason: collision with root package name */
    public c f22787f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f22788g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22789h;

    /* renamed from: i  reason: collision with root package name */
    public int f22790i;
    public Context j;
    public List<n> k;
    public ViewPager.OnPageChangeListener l;
    public long m;
    public final Handler.Callback n;
    public final Handler o;
    public ViewPager.OnPageChangeListener p;

    /* loaded from: classes5.dex */
    public class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22791e;

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
            this.f22791e = bVar;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 1 && this.f22791e.k()) {
                    this.f22791e.i();
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* renamed from: b.a.r0.q1.t.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1114b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22792e;

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
            this.f22792e = bVar;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            int count;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f22792e.l != null) {
                    this.f22792e.l.onPageScrollStateChanged(i2);
                }
                if (i2 == 1) {
                    this.f22792e.s();
                } else if (i2 != 0 || (count = this.f22792e.f22786e.getCount()) < 2) {
                } else {
                    int currentItem = this.f22792e.f22782a.getCurrentItem();
                    int i3 = count - 2;
                    if (currentItem < 1) {
                        this.f22792e.f22782a.setCurrentItem(i3, false);
                    } else if (currentItem > i3) {
                        this.f22792e.f22782a.setCurrentItem(1, false);
                    }
                    this.f22792e.r();
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || this.f22792e.l == null) {
                return;
            }
            this.f22792e.l.onPageScrolled(i2, f2, i3);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && this.f22792e.f22787f != null && this.f22792e.f22787f.a(i2) == i2) {
                if (this.f22792e.f22783b != null) {
                    this.f22792e.f22783b.setPosition(this.f22792e.f22787f.c(i2));
                    if (this.f22792e.f22784c != null) {
                        this.f22792e.f22783b.setVisibility(8);
                        this.f22792e.f22784c.b(this.f22792e.f22787f.c(i2));
                    }
                }
                if (this.f22792e.l != null) {
                    this.f22792e.l.onPageSelected(this.f22792e.f22787f.c(i2));
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
        this.f22788g = false;
        this.f22789h = true;
        this.f22790i = 2;
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
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22782a == null || this.f22786e == null) {
            return;
        }
        i c2 = j.c(this.j);
        if ((c2 == null || !c2.isScroll()) && (count = this.f22786e.getCount()) >= 2) {
            int currentItem = this.f22782a.getCurrentItem();
            int i2 = count - 2;
            if (currentItem < 1) {
                this.f22782a.setCurrentItem(i2, false);
            } else if (currentItem > i2) {
                this.f22782a.setCurrentItem(1, false);
            } else {
                this.f22782a.setCurrentItem(currentItem + 1);
            }
        }
    }

    public final void j(Context context, ListViewPager listViewPager, IndicatorView indicatorView, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, listViewPager, indicatorView, textView) == null) {
            this.f22782a = listViewPager;
            this.f22783b = indicatorView;
            this.f22785d = textView;
            this.j = context;
            BdBaseViewPagerAdapter bdBaseViewPagerAdapter = new BdBaseViewPagerAdapter(context);
            this.f22786e = bdBaseViewPagerAdapter;
            ListViewPager listViewPager2 = this.f22782a;
            if (listViewPager2 != null) {
                listViewPager2.setAdapter(bdBaseViewPagerAdapter);
                this.f22782a.setOnPageChangeListener(this.p);
            }
        }
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ListViewPager listViewPager = this.f22782a;
            if (listViewPager == null) {
                return false;
            }
            int[] iArr = new int[2];
            listViewPager.getLocationOnScreen(iArr);
            int measuredHeight = iArr[1] + (this.f22782a.getMeasuredHeight() / 2);
            return measuredHeight > 0 && measuredHeight < l.i(this.j);
        }
        return invokeV.booleanValue;
    }

    public void l(Context context, b.a.q0.s.g0.u.b<?, ?> bVar) {
        BdBaseViewPagerAdapter bdBaseViewPagerAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, context, bVar) == null) || (bdBaseViewPagerAdapter = this.f22786e) == null) {
            return;
        }
        bdBaseViewPagerAdapter.registerAdapter(context, bVar);
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
        c cVar = new c(list, this.f22788g, this.f22790i);
        this.f22787f = cVar;
        cVar.i(2);
        boolean z = true;
        this.f22787f.g(1);
        this.f22786e.setDatas(this.f22787f.e());
        this.f22786e.notifyDataSetChanged();
        this.f22782a.setCurrentItem(this.f22787f.d(), false);
        if (this.f22787f.b() <= 0) {
            return;
        }
        if (this.f22787f.b() > this.f22790i) {
            TextView textView = this.f22785d;
            if (textView != null) {
                textView.setVisibility(0);
                this.f22785d.setOnClickListener(null);
                IndicatorView indicatorView = this.f22783b;
                if (indicatorView != null) {
                    indicatorView.setVisibility(8);
                }
            }
            if (this.f22783b != null && this.f22785d == null && this.f22788g) {
                z = false;
            }
            if (!z) {
                this.f22783b.setVisibility(8);
                int count = this.f22783b.getCount();
                int i2 = this.f22790i;
                if (count != i2) {
                    this.f22783b.setCount(i2);
                }
            }
            r();
        }
        if (this.f22787f.b() >= 2 && this.f22787f.b() <= this.f22790i) {
            TextView textView2 = this.f22785d;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            IndicatorView indicatorView2 = this.f22783b;
            if (indicatorView2 != null) {
                indicatorView2.setVisibility(0);
                if (this.f22783b.getCount() != this.f22787f.b()) {
                    this.f22783b.setCount(this.f22787f.b());
                    k kVar = this.f22784c;
                    if (kVar != null) {
                        kVar.a(this.f22787f.b());
                        this.f22783b.setVisibility(8);
                    }
                } else {
                    k kVar2 = this.f22784c;
                    if (kVar2 != null) {
                        kVar2.a(this.f22787f.b());
                        this.f22783b.setVisibility(8);
                    }
                }
            }
            r();
        }
        if (this.f22787f.b() < 2) {
            TextView textView3 = this.f22785d;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            IndicatorView indicatorView3 = this.f22783b;
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
                this.f22783b.setVisibility(8);
            } else {
                this.f22783b.setVisibility(0);
            }
            this.f22784c = kVar;
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f22790i = i2;
            c cVar = this.f22787f;
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
            if (this.f22789h) {
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
