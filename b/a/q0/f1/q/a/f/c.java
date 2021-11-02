package b.a.q0.f1.q.a.f;

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
/* loaded from: classes4.dex */
public class c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f12494a;

    /* renamed from: b  reason: collision with root package name */
    public WheelView f12495b;

    /* renamed from: c  reason: collision with root package name */
    public WheelView f12496c;

    /* renamed from: d  reason: collision with root package name */
    public WheelView f12497d;

    /* renamed from: e  reason: collision with root package name */
    public List<T> f12498e;

    /* renamed from: f  reason: collision with root package name */
    public List<List<T>> f12499f;

    /* renamed from: g  reason: collision with root package name */
    public List<List<List<T>>> f12500g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12501h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12502i;
    public b.a.q0.f1.q.b.c.b j;
    public b.a.q0.f1.q.b.c.b k;
    public b.a.q0.f1.q.a.d.d l;
    public int m;
    public int n;
    public int o;
    public WheelView.DividerType p;
    public float q;

    /* loaded from: classes4.dex */
    public class a implements b.a.q0.f1.q.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f12503a;

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
            this.f12503a = cVar;
        }

        @Override // b.a.q0.f1.q.b.c.b
        public void onItemSelected(int i2) {
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f12503a.f12499f == null) {
                    if (this.f12503a.l != null) {
                        this.f12503a.l.a(this.f12503a.f12495b.getCurrentItem(), 0, 0);
                        return;
                    }
                    return;
                }
                if (this.f12503a.f12502i) {
                    i3 = 0;
                } else {
                    i3 = this.f12503a.f12496c.getCurrentItem();
                    if (i3 >= ((List) this.f12503a.f12499f.get(i2)).size() - 1) {
                        i3 = ((List) this.f12503a.f12499f.get(i2)).size() - 1;
                    }
                }
                this.f12503a.f12496c.setAdapter(new b.a.q0.f1.q.a.a.a((List) this.f12503a.f12499f.get(i2)));
                this.f12503a.f12496c.setCurrentItem(i3);
                if (this.f12503a.f12500g != null) {
                    this.f12503a.k.onItemSelected(i3);
                } else if (this.f12503a.l != null) {
                    this.f12503a.l.a(i2, i3, 0);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements b.a.q0.f1.q.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f12504a;

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
            this.f12504a = cVar;
        }

        @Override // b.a.q0.f1.q.b.c.b
        public void onItemSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                int i3 = 0;
                if (this.f12504a.f12500g != null) {
                    int currentItem = this.f12504a.f12495b.getCurrentItem();
                    if (currentItem >= this.f12504a.f12500g.size() - 1) {
                        currentItem = this.f12504a.f12500g.size() - 1;
                    }
                    if (i2 >= ((List) this.f12504a.f12499f.get(currentItem)).size() - 1) {
                        i2 = ((List) this.f12504a.f12499f.get(currentItem)).size() - 1;
                    }
                    if (!this.f12504a.f12502i) {
                        i3 = this.f12504a.f12497d.getCurrentItem() >= ((List) ((List) this.f12504a.f12500g.get(currentItem)).get(i2)).size() + (-1) ? ((List) ((List) this.f12504a.f12500g.get(currentItem)).get(i2)).size() - 1 : this.f12504a.f12497d.getCurrentItem();
                    }
                    this.f12504a.f12497d.setAdapter(new b.a.q0.f1.q.a.a.a((List) ((List) this.f12504a.f12500g.get(this.f12504a.f12495b.getCurrentItem())).get(i2)));
                    this.f12504a.f12497d.setCurrentItem(i3);
                    if (this.f12504a.l != null) {
                        this.f12504a.l.a(this.f12504a.f12495b.getCurrentItem(), i2, i3);
                    }
                } else if (this.f12504a.l != null) {
                    this.f12504a.l.a(this.f12504a.f12495b.getCurrentItem(), i2, 0);
                }
            }
        }
    }

    /* renamed from: b.a.q0.f1.q.a.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0658c implements b.a.q0.f1.q.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f12505a;

        public C0658c(c cVar) {
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
            this.f12505a = cVar;
        }

        @Override // b.a.q0.f1.q.b.c.b
        public void onItemSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f12505a.l.a(this.f12505a.f12495b.getCurrentItem(), this.f12505a.f12496c.getCurrentItem(), i2);
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
        this.f12501h = true;
        this.f12502i = z;
        this.f12494a = view;
        this.f12495b = (WheelView) view.findViewById(R.id.options1);
        this.f12496c = (WheelView) view.findViewById(R.id.options2);
        this.f12497d = (WheelView) view.findViewById(R.id.options3);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f12495b.setTextColorOut(this.m);
            this.f12496c.setTextColorOut(this.m);
            this.f12497d.setTextColorOut(this.m);
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
            this.f12495b.setTextSize(f2);
            this.f12496c.setTextSize(f2);
            this.f12497d.setTextSize(f2);
        }
    }

    public int[] i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int[] iArr = new int[3];
            iArr[0] = this.f12495b.getCurrentItem();
            List<List<T>> list = this.f12499f;
            if (list != null && list.size() > 0) {
                iArr[1] = this.f12496c.getCurrentItem() > this.f12499f.get(iArr[0]).size() - 1 ? 0 : this.f12496c.getCurrentItem();
            } else {
                iArr[1] = this.f12496c.getCurrentItem();
            }
            List<List<List<T>>> list2 = this.f12500g;
            if (list2 != null && list2.size() > 0) {
                iArr[2] = this.f12497d.getCurrentItem() <= this.f12500g.get(iArr[0]).get(iArr[1]).size() - 1 ? this.f12497d.getCurrentItem() : 0;
            } else {
                iArr[2] = this.f12497d.getCurrentItem();
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f12495b.invalidate();
            this.f12496c.invalidate();
            this.f12497d.invalidate();
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f12495b.isCenterLabel(z);
            this.f12496c.isCenterLabel(z);
            this.f12497d.isCenterLabel(z);
        }
    }

    public final void l(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048582, this, i2, i3, i4) == null) {
            if (this.f12498e != null) {
                this.f12495b.setCurrentItem(i2);
            }
            List<List<T>> list = this.f12499f;
            if (list != null) {
                this.f12496c.setAdapter(new b.a.q0.f1.q.a.a.a(list.get(i2)));
                this.f12496c.setCurrentItem(i3);
            }
            List<List<List<T>>> list2 = this.f12500g;
            if (list2 != null) {
                this.f12497d.setAdapter(new b.a.q0.f1.q.a.a.a(list2.get(i2).get(i3)));
                this.f12497d.setCurrentItem(i4);
            }
        }
    }

    public void m(Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, typeface) == null) {
            this.f12495b.setCenterTypeface(typeface);
            this.f12496c.setCenterTypeface(typeface);
            this.f12497d.setCenterTypeface(typeface);
        }
    }

    public void n(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4) == null) {
            if (this.f12501h) {
                l(i2, i3, i4);
                return;
            }
            this.f12495b.setCurrentItem(i2);
            this.f12496c.setCurrentItem(i3);
            this.f12497d.setCurrentItem(i4);
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f12495b.setCyclic(z);
            this.f12496c.setCyclic(z);
            this.f12497d.setCyclic(z);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f12495b.setDividerColor(this.o);
            this.f12496c.setDividerColor(this.o);
            this.f12497d.setDividerColor(this.o);
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
            this.f12495b.setDividerType(this.p);
            this.f12496c.setDividerType(this.p);
            this.f12497d.setDividerType(this.p);
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
            this.f12495b.setItemsVisible(i2);
            this.f12496c.setItemsVisible(i2);
            this.f12497d.setItemsVisible(i2);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f12495b.setLineSpacingMultiplier(this.q);
            this.f12496c.setLineSpacingMultiplier(this.q);
            this.f12497d.setLineSpacingMultiplier(this.q);
        }
    }

    public void v(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f2) == null) {
            this.q = f2;
            u();
        }
    }

    public void w(b.a.q0.f1.q.a.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, dVar) == null) {
            this.l = dVar;
        }
    }

    public void x(List<T> list, List<List<T>> list2, List<List<List<T>>> list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, list, list2, list3) == null) {
            this.f12498e = list;
            this.f12499f = list2;
            this.f12500g = list3;
            this.f12495b.setAdapter(new b.a.q0.f1.q.a.a.a(list));
            this.f12495b.setCurrentItem(0);
            List<List<T>> list4 = this.f12499f;
            if (list4 != null) {
                this.f12496c.setAdapter(new b.a.q0.f1.q.a.a.a(list4.get(0)));
            }
            WheelView wheelView = this.f12496c;
            wheelView.setCurrentItem(wheelView.getCurrentItem());
            List<List<List<T>>> list5 = this.f12500g;
            if (list5 != null) {
                this.f12497d.setAdapter(new b.a.q0.f1.q.a.a.a(list5.get(0).get(0)));
            }
            WheelView wheelView2 = this.f12497d;
            wheelView2.setCurrentItem(wheelView2.getCurrentItem());
            this.f12495b.setIsOptions(true);
            this.f12496c.setIsOptions(true);
            this.f12497d.setIsOptions(true);
            if (this.f12499f == null) {
                this.f12496c.setVisibility(8);
            } else {
                this.f12496c.setVisibility(0);
            }
            if (this.f12500g == null) {
                this.f12497d.setVisibility(8);
            } else {
                this.f12497d.setVisibility(0);
            }
            this.j = new a(this);
            this.k = new b(this);
            if (list != null && this.f12501h) {
                this.f12495b.setOnItemSelectedListener(this.j);
            }
            if (list2 != null && this.f12501h) {
                this.f12496c.setOnItemSelectedListener(this.k);
            }
            if (list3 == null || !this.f12501h || this.l == null) {
                return;
            }
            this.f12497d.setOnItemSelectedListener(new C0658c(this));
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f12495b.setTextColorCenter(this.n);
            this.f12496c.setTextColorCenter(this.n);
            this.f12497d.setTextColorCenter(this.n);
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
