package c.a.s0.g1.q.a.f;

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
/* loaded from: classes6.dex */
public class c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public WheelView f12719b;

    /* renamed from: c  reason: collision with root package name */
    public WheelView f12720c;

    /* renamed from: d  reason: collision with root package name */
    public WheelView f12721d;

    /* renamed from: e  reason: collision with root package name */
    public List<T> f12722e;

    /* renamed from: f  reason: collision with root package name */
    public List<List<T>> f12723f;

    /* renamed from: g  reason: collision with root package name */
    public List<List<List<T>>> f12724g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12725h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12726i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.s0.g1.q.b.c.b f12727j;
    public c.a.s0.g1.q.b.c.b k;
    public c.a.s0.g1.q.a.d.d l;
    public int m;
    public int n;
    public int o;
    public WheelView.DividerType p;
    public float q;

    /* loaded from: classes6.dex */
    public class a implements c.a.s0.g1.q.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

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
            this.a = cVar;
        }

        @Override // c.a.s0.g1.q.b.c.b
        public void onItemSelected(int i2) {
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.a.f12723f == null) {
                    if (this.a.l != null) {
                        this.a.l.a(this.a.f12719b.getCurrentItem(), 0, 0);
                        return;
                    }
                    return;
                }
                if (this.a.f12726i) {
                    i3 = 0;
                } else {
                    i3 = this.a.f12720c.getCurrentItem();
                    if (i3 >= ((List) this.a.f12723f.get(i2)).size() - 1) {
                        i3 = ((List) this.a.f12723f.get(i2)).size() - 1;
                    }
                }
                this.a.f12720c.setAdapter(new c.a.s0.g1.q.a.a.a((List) this.a.f12723f.get(i2)));
                this.a.f12720c.setCurrentItem(i3);
                if (this.a.f12724g != null) {
                    this.a.k.onItemSelected(i3);
                } else if (this.a.l != null) {
                    this.a.l.a(i2, i3, 0);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements c.a.s0.g1.q.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

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
            this.a = cVar;
        }

        @Override // c.a.s0.g1.q.b.c.b
        public void onItemSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                int i3 = 0;
                if (this.a.f12724g != null) {
                    int currentItem = this.a.f12719b.getCurrentItem();
                    if (currentItem >= this.a.f12724g.size() - 1) {
                        currentItem = this.a.f12724g.size() - 1;
                    }
                    if (i2 >= ((List) this.a.f12723f.get(currentItem)).size() - 1) {
                        i2 = ((List) this.a.f12723f.get(currentItem)).size() - 1;
                    }
                    if (!this.a.f12726i) {
                        i3 = this.a.f12721d.getCurrentItem() >= ((List) ((List) this.a.f12724g.get(currentItem)).get(i2)).size() + (-1) ? ((List) ((List) this.a.f12724g.get(currentItem)).get(i2)).size() - 1 : this.a.f12721d.getCurrentItem();
                    }
                    this.a.f12721d.setAdapter(new c.a.s0.g1.q.a.a.a((List) ((List) this.a.f12724g.get(this.a.f12719b.getCurrentItem())).get(i2)));
                    this.a.f12721d.setCurrentItem(i3);
                    if (this.a.l != null) {
                        this.a.l.a(this.a.f12719b.getCurrentItem(), i2, i3);
                    }
                } else if (this.a.l != null) {
                    this.a.l.a(this.a.f12719b.getCurrentItem(), i2, 0);
                }
            }
        }
    }

    /* renamed from: c.a.s0.g1.q.a.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0846c implements c.a.s0.g1.q.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public C0846c(c cVar) {
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
            this.a = cVar;
        }

        @Override // c.a.s0.g1.q.b.c.b
        public void onItemSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.a.l.a(this.a.f12719b.getCurrentItem(), this.a.f12720c.getCurrentItem(), i2);
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
        this.f12725h = true;
        this.f12726i = z;
        this.a = view;
        this.f12719b = (WheelView) view.findViewById(R.id.options1);
        this.f12720c = (WheelView) view.findViewById(R.id.options2);
        this.f12721d = (WheelView) view.findViewById(R.id.options3);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f12719b.setTextColorOut(this.m);
            this.f12720c.setTextColorOut(this.m);
            this.f12721d.setTextColorOut(this.m);
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
            this.f12719b.setTextSize(f2);
            this.f12720c.setTextSize(f2);
            this.f12721d.setTextSize(f2);
        }
    }

    public int[] i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int[] iArr = new int[3];
            iArr[0] = this.f12719b.getCurrentItem();
            List<List<T>> list = this.f12723f;
            if (list != null && list.size() > 0) {
                iArr[1] = this.f12720c.getCurrentItem() > this.f12723f.get(iArr[0]).size() - 1 ? 0 : this.f12720c.getCurrentItem();
            } else {
                iArr[1] = this.f12720c.getCurrentItem();
            }
            List<List<List<T>>> list2 = this.f12724g;
            if (list2 != null && list2.size() > 0) {
                iArr[2] = this.f12721d.getCurrentItem() <= this.f12724g.get(iArr[0]).get(iArr[1]).size() - 1 ? this.f12721d.getCurrentItem() : 0;
            } else {
                iArr[2] = this.f12721d.getCurrentItem();
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f12719b.invalidate();
            this.f12720c.invalidate();
            this.f12721d.invalidate();
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f12719b.isCenterLabel(z);
            this.f12720c.isCenterLabel(z);
            this.f12721d.isCenterLabel(z);
        }
    }

    public final void l(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048582, this, i2, i3, i4) == null) {
            if (this.f12722e != null) {
                this.f12719b.setCurrentItem(i2);
            }
            List<List<T>> list = this.f12723f;
            if (list != null) {
                this.f12720c.setAdapter(new c.a.s0.g1.q.a.a.a(list.get(i2)));
                this.f12720c.setCurrentItem(i3);
            }
            List<List<List<T>>> list2 = this.f12724g;
            if (list2 != null) {
                this.f12721d.setAdapter(new c.a.s0.g1.q.a.a.a(list2.get(i2).get(i3)));
                this.f12721d.setCurrentItem(i4);
            }
        }
    }

    public void m(Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, typeface) == null) {
            this.f12719b.setCenterTypeface(typeface);
            this.f12720c.setCenterTypeface(typeface);
            this.f12721d.setCenterTypeface(typeface);
        }
    }

    public void n(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4) == null) {
            if (this.f12725h) {
                l(i2, i3, i4);
                return;
            }
            this.f12719b.setCurrentItem(i2);
            this.f12720c.setCurrentItem(i3);
            this.f12721d.setCurrentItem(i4);
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f12719b.setCyclic(z);
            this.f12720c.setCyclic(z);
            this.f12721d.setCyclic(z);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f12719b.setDividerColor(this.o);
            this.f12720c.setDividerColor(this.o);
            this.f12721d.setDividerColor(this.o);
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
            this.f12719b.setDividerType(this.p);
            this.f12720c.setDividerType(this.p);
            this.f12721d.setDividerType(this.p);
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
            this.f12719b.setItemsVisible(i2);
            this.f12720c.setItemsVisible(i2);
            this.f12721d.setItemsVisible(i2);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f12719b.setLineSpacingMultiplier(this.q);
            this.f12720c.setLineSpacingMultiplier(this.q);
            this.f12721d.setLineSpacingMultiplier(this.q);
        }
    }

    public void v(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f2) == null) {
            this.q = f2;
            u();
        }
    }

    public void w(c.a.s0.g1.q.a.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, dVar) == null) {
            this.l = dVar;
        }
    }

    public void x(List<T> list, List<List<T>> list2, List<List<List<T>>> list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, list, list2, list3) == null) {
            this.f12722e = list;
            this.f12723f = list2;
            this.f12724g = list3;
            this.f12719b.setAdapter(new c.a.s0.g1.q.a.a.a(list));
            this.f12719b.setCurrentItem(0);
            List<List<T>> list4 = this.f12723f;
            if (list4 != null) {
                this.f12720c.setAdapter(new c.a.s0.g1.q.a.a.a(list4.get(0)));
            }
            WheelView wheelView = this.f12720c;
            wheelView.setCurrentItem(wheelView.getCurrentItem());
            List<List<List<T>>> list5 = this.f12724g;
            if (list5 != null) {
                this.f12721d.setAdapter(new c.a.s0.g1.q.a.a.a(list5.get(0).get(0)));
            }
            WheelView wheelView2 = this.f12721d;
            wheelView2.setCurrentItem(wheelView2.getCurrentItem());
            this.f12719b.setIsOptions(true);
            this.f12720c.setIsOptions(true);
            this.f12721d.setIsOptions(true);
            if (this.f12723f == null) {
                this.f12720c.setVisibility(8);
            } else {
                this.f12720c.setVisibility(0);
            }
            if (this.f12724g == null) {
                this.f12721d.setVisibility(8);
            } else {
                this.f12721d.setVisibility(0);
            }
            this.f12727j = new a(this);
            this.k = new b(this);
            if (list != null && this.f12725h) {
                this.f12719b.setOnItemSelectedListener(this.f12727j);
            }
            if (list2 != null && this.f12725h) {
                this.f12720c.setOnItemSelectedListener(this.k);
            }
            if (list3 == null || !this.f12725h || this.l == null) {
                return;
            }
            this.f12721d.setOnItemSelectedListener(new C0846c(this));
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f12719b.setTextColorCenter(this.n);
            this.f12720c.setTextColorCenter(this.n);
            this.f12721d.setTextColorCenter(this.n);
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
