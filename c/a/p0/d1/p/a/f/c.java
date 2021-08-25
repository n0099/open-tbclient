package c.a.p0.d1.p.a.f;

import android.graphics.Typeface;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f13288a;

    /* renamed from: b  reason: collision with root package name */
    public WheelView f13289b;

    /* renamed from: c  reason: collision with root package name */
    public WheelView f13290c;

    /* renamed from: d  reason: collision with root package name */
    public WheelView f13291d;

    /* renamed from: e  reason: collision with root package name */
    public List<T> f13292e;

    /* renamed from: f  reason: collision with root package name */
    public List<List<T>> f13293f;

    /* renamed from: g  reason: collision with root package name */
    public List<List<List<T>>> f13294g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13295h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13296i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.p0.d1.p.b.c.b f13297j;
    public c.a.p0.d1.p.b.c.b k;
    public c.a.p0.d1.p.a.d.d l;
    public int m;
    public int n;
    public int o;
    public WheelView.DividerType p;
    public float q;

    /* loaded from: classes3.dex */
    public class a implements c.a.p0.d1.p.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f13298a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13298a = cVar;
        }

        @Override // c.a.p0.d1.p.b.c.b
        public void a(int i2) {
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f13298a.f13293f == null) {
                    if (this.f13298a.l != null) {
                        this.f13298a.l.a(this.f13298a.f13289b.getCurrentItem(), 0, 0);
                        return;
                    }
                    return;
                }
                if (this.f13298a.f13296i) {
                    i3 = 0;
                } else {
                    i3 = this.f13298a.f13290c.getCurrentItem();
                    if (i3 >= ((List) this.f13298a.f13293f.get(i2)).size() - 1) {
                        i3 = ((List) this.f13298a.f13293f.get(i2)).size() - 1;
                    }
                }
                this.f13298a.f13290c.setAdapter(new c.a.p0.d1.p.a.a.a((List) this.f13298a.f13293f.get(i2)));
                this.f13298a.f13290c.setCurrentItem(i3);
                if (this.f13298a.f13294g != null) {
                    this.f13298a.k.a(i3);
                } else if (this.f13298a.l != null) {
                    this.f13298a.l.a(i2, i3, 0);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.a.p0.d1.p.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f13299a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13299a = cVar;
        }

        @Override // c.a.p0.d1.p.b.c.b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                int i3 = 0;
                if (this.f13299a.f13294g != null) {
                    int currentItem = this.f13299a.f13289b.getCurrentItem();
                    if (currentItem >= this.f13299a.f13294g.size() - 1) {
                        currentItem = this.f13299a.f13294g.size() - 1;
                    }
                    if (i2 >= ((List) this.f13299a.f13293f.get(currentItem)).size() - 1) {
                        i2 = ((List) this.f13299a.f13293f.get(currentItem)).size() - 1;
                    }
                    if (!this.f13299a.f13296i) {
                        i3 = this.f13299a.f13291d.getCurrentItem() >= ((List) ((List) this.f13299a.f13294g.get(currentItem)).get(i2)).size() + (-1) ? ((List) ((List) this.f13299a.f13294g.get(currentItem)).get(i2)).size() - 1 : this.f13299a.f13291d.getCurrentItem();
                    }
                    this.f13299a.f13291d.setAdapter(new c.a.p0.d1.p.a.a.a((List) ((List) this.f13299a.f13294g.get(this.f13299a.f13289b.getCurrentItem())).get(i2)));
                    this.f13299a.f13291d.setCurrentItem(i3);
                    if (this.f13299a.l != null) {
                        this.f13299a.l.a(this.f13299a.f13289b.getCurrentItem(), i2, i3);
                    }
                } else if (this.f13299a.l != null) {
                    this.f13299a.l.a(this.f13299a.f13289b.getCurrentItem(), i2, 0);
                }
            }
        }
    }

    /* renamed from: c.a.p0.d1.p.a.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0661c implements c.a.p0.d1.p.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f13300a;

        public C0661c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13300a = cVar;
        }

        @Override // c.a.p0.d1.p.b.c.b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f13300a.l.a(this.f13300a.f13289b.getCurrentItem(), this.f13300a.f13290c.getCurrentItem(), i2);
            }
        }
    }

    public c(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13295h = true;
        this.f13296i = z;
        this.f13288a = view;
        this.f13289b = (WheelView) view.findViewById(R.id.options1);
        this.f13290c = (WheelView) view.findViewById(R.id.options2);
        this.f13291d = (WheelView) view.findViewById(R.id.options3);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f13289b.setTextColorOut(this.m);
            this.f13290c.setTextColorOut(this.m);
            this.f13291d.setTextColorOut(this.m);
        }
    }

    public void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.m = i2;
            A();
        }
    }

    public void C(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            float f2 = i2;
            this.f13289b.setTextSize(f2);
            this.f13290c.setTextSize(f2);
            this.f13291d.setTextSize(f2);
        }
    }

    public int[] i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int[] iArr = new int[3];
            iArr[0] = this.f13289b.getCurrentItem();
            List<List<T>> list = this.f13293f;
            if (list != null && list.size() > 0) {
                iArr[1] = this.f13290c.getCurrentItem() > this.f13293f.get(iArr[0]).size() - 1 ? 0 : this.f13290c.getCurrentItem();
            } else {
                iArr[1] = this.f13290c.getCurrentItem();
            }
            List<List<List<T>>> list2 = this.f13294g;
            if (list2 != null && list2.size() > 0) {
                iArr[2] = this.f13291d.getCurrentItem() <= this.f13294g.get(iArr[0]).get(iArr[1]).size() - 1 ? this.f13291d.getCurrentItem() : 0;
            } else {
                iArr[2] = this.f13291d.getCurrentItem();
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f13289b.invalidate();
            this.f13290c.invalidate();
            this.f13291d.invalidate();
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f13289b.isCenterLabel(z);
            this.f13290c.isCenterLabel(z);
            this.f13291d.isCenterLabel(z);
        }
    }

    public final void l(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048582, this, i2, i3, i4) == null) {
            if (this.f13292e != null) {
                this.f13289b.setCurrentItem(i2);
            }
            List<List<T>> list = this.f13293f;
            if (list != null) {
                this.f13290c.setAdapter(new c.a.p0.d1.p.a.a.a(list.get(i2)));
                this.f13290c.setCurrentItem(i3);
            }
            List<List<List<T>>> list2 = this.f13294g;
            if (list2 != null) {
                this.f13291d.setAdapter(new c.a.p0.d1.p.a.a.a(list2.get(i2).get(i3)));
                this.f13291d.setCurrentItem(i4);
            }
        }
    }

    public void m(Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, typeface) == null) {
            this.f13289b.setCenterTypeface(typeface);
            this.f13290c.setCenterTypeface(typeface);
            this.f13291d.setCenterTypeface(typeface);
        }
    }

    public void n(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4) == null) {
            if (this.f13295h) {
                l(i2, i3, i4);
                return;
            }
            this.f13289b.setCurrentItem(i2);
            this.f13290c.setCurrentItem(i3);
            this.f13291d.setCurrentItem(i4);
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f13289b.setCyclic(z);
            this.f13290c.setCyclic(z);
            this.f13291d.setCyclic(z);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f13289b.setDividerColor(this.o);
            this.f13290c.setDividerColor(this.o);
            this.f13291d.setDividerColor(this.o);
        }
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.o = i2;
            p();
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f13289b.setDividerType(this.p);
            this.f13290c.setDividerType(this.p);
            this.f13291d.setDividerType(this.p);
        }
    }

    public void s(WheelView.DividerType dividerType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dividerType) == null) {
            this.p = dividerType;
            r();
        }
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f13289b.setItemsVisible(i2);
            this.f13290c.setItemsVisible(i2);
            this.f13291d.setItemsVisible(i2);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f13289b.setLineSpacingMultiplier(this.q);
            this.f13290c.setLineSpacingMultiplier(this.q);
            this.f13291d.setLineSpacingMultiplier(this.q);
        }
    }

    public void v(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f2) == null) {
            this.q = f2;
            u();
        }
    }

    public void w(c.a.p0.d1.p.a.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, dVar) == null) {
            this.l = dVar;
        }
    }

    public void x(List<T> list, List<List<T>> list2, List<List<List<T>>> list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, list, list2, list3) == null) {
            this.f13292e = list;
            this.f13293f = list2;
            this.f13294g = list3;
            this.f13289b.setAdapter(new c.a.p0.d1.p.a.a.a(list));
            this.f13289b.setCurrentItem(0);
            List<List<T>> list4 = this.f13293f;
            if (list4 != null) {
                this.f13290c.setAdapter(new c.a.p0.d1.p.a.a.a(list4.get(0)));
            }
            WheelView wheelView = this.f13290c;
            wheelView.setCurrentItem(wheelView.getCurrentItem());
            List<List<List<T>>> list5 = this.f13294g;
            if (list5 != null) {
                this.f13291d.setAdapter(new c.a.p0.d1.p.a.a.a(list5.get(0).get(0)));
            }
            WheelView wheelView2 = this.f13291d;
            wheelView2.setCurrentItem(wheelView2.getCurrentItem());
            this.f13289b.setIsOptions(true);
            this.f13290c.setIsOptions(true);
            this.f13291d.setIsOptions(true);
            if (this.f13293f == null) {
                this.f13290c.setVisibility(8);
            } else {
                this.f13290c.setVisibility(0);
            }
            if (this.f13294g == null) {
                this.f13291d.setVisibility(8);
            } else {
                this.f13291d.setVisibility(0);
            }
            this.f13297j = new a(this);
            this.k = new b(this);
            if (list != null && this.f13295h) {
                this.f13289b.setOnItemSelectedListener(this.f13297j);
            }
            if (list2 != null && this.f13295h) {
                this.f13290c.setOnItemSelectedListener(this.k);
            }
            if (list3 == null || !this.f13295h || this.l == null) {
                return;
            }
            this.f13291d.setOnItemSelectedListener(new C0661c(this));
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f13289b.setTextColorCenter(this.n);
            this.f13290c.setTextColorCenter(this.n);
            this.f13291d.setTextColorCenter(this.n);
        }
    }

    public void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.n = i2;
            y();
        }
    }
}
