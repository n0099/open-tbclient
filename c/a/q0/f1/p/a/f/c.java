package c.a.q0.f1.p.a.f;

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
    public View f13338a;

    /* renamed from: b  reason: collision with root package name */
    public WheelView f13339b;

    /* renamed from: c  reason: collision with root package name */
    public WheelView f13340c;

    /* renamed from: d  reason: collision with root package name */
    public WheelView f13341d;

    /* renamed from: e  reason: collision with root package name */
    public List<T> f13342e;

    /* renamed from: f  reason: collision with root package name */
    public List<List<T>> f13343f;

    /* renamed from: g  reason: collision with root package name */
    public List<List<List<T>>> f13344g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13345h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13346i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.q0.f1.p.b.c.b f13347j;
    public c.a.q0.f1.p.b.c.b k;
    public c.a.q0.f1.p.a.d.d l;
    public int m;
    public int n;
    public int o;
    public WheelView.DividerType p;
    public float q;

    /* loaded from: classes3.dex */
    public class a implements c.a.q0.f1.p.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f13348a;

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
            this.f13348a = cVar;
        }

        @Override // c.a.q0.f1.p.b.c.b
        public void a(int i2) {
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f13348a.f13343f == null) {
                    if (this.f13348a.l != null) {
                        this.f13348a.l.a(this.f13348a.f13339b.getCurrentItem(), 0, 0);
                        return;
                    }
                    return;
                }
                if (this.f13348a.f13346i) {
                    i3 = 0;
                } else {
                    i3 = this.f13348a.f13340c.getCurrentItem();
                    if (i3 >= ((List) this.f13348a.f13343f.get(i2)).size() - 1) {
                        i3 = ((List) this.f13348a.f13343f.get(i2)).size() - 1;
                    }
                }
                this.f13348a.f13340c.setAdapter(new c.a.q0.f1.p.a.a.a((List) this.f13348a.f13343f.get(i2)));
                this.f13348a.f13340c.setCurrentItem(i3);
                if (this.f13348a.f13344g != null) {
                    this.f13348a.k.a(i3);
                } else if (this.f13348a.l != null) {
                    this.f13348a.l.a(i2, i3, 0);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.a.q0.f1.p.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f13349a;

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
            this.f13349a = cVar;
        }

        @Override // c.a.q0.f1.p.b.c.b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                int i3 = 0;
                if (this.f13349a.f13344g != null) {
                    int currentItem = this.f13349a.f13339b.getCurrentItem();
                    if (currentItem >= this.f13349a.f13344g.size() - 1) {
                        currentItem = this.f13349a.f13344g.size() - 1;
                    }
                    if (i2 >= ((List) this.f13349a.f13343f.get(currentItem)).size() - 1) {
                        i2 = ((List) this.f13349a.f13343f.get(currentItem)).size() - 1;
                    }
                    if (!this.f13349a.f13346i) {
                        i3 = this.f13349a.f13341d.getCurrentItem() >= ((List) ((List) this.f13349a.f13344g.get(currentItem)).get(i2)).size() + (-1) ? ((List) ((List) this.f13349a.f13344g.get(currentItem)).get(i2)).size() - 1 : this.f13349a.f13341d.getCurrentItem();
                    }
                    this.f13349a.f13341d.setAdapter(new c.a.q0.f1.p.a.a.a((List) ((List) this.f13349a.f13344g.get(this.f13349a.f13339b.getCurrentItem())).get(i2)));
                    this.f13349a.f13341d.setCurrentItem(i3);
                    if (this.f13349a.l != null) {
                        this.f13349a.l.a(this.f13349a.f13339b.getCurrentItem(), i2, i3);
                    }
                } else if (this.f13349a.l != null) {
                    this.f13349a.l.a(this.f13349a.f13339b.getCurrentItem(), i2, 0);
                }
            }
        }
    }

    /* renamed from: c.a.q0.f1.p.a.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0662c implements c.a.q0.f1.p.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f13350a;

        public C0662c(c cVar) {
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
            this.f13350a = cVar;
        }

        @Override // c.a.q0.f1.p.b.c.b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f13350a.l.a(this.f13350a.f13339b.getCurrentItem(), this.f13350a.f13340c.getCurrentItem(), i2);
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
        this.f13345h = true;
        this.f13346i = z;
        this.f13338a = view;
        this.f13339b = (WheelView) view.findViewById(R.id.options1);
        this.f13340c = (WheelView) view.findViewById(R.id.options2);
        this.f13341d = (WheelView) view.findViewById(R.id.options3);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f13339b.setTextColorOut(this.m);
            this.f13340c.setTextColorOut(this.m);
            this.f13341d.setTextColorOut(this.m);
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
            this.f13339b.setTextSize(f2);
            this.f13340c.setTextSize(f2);
            this.f13341d.setTextSize(f2);
        }
    }

    public int[] i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int[] iArr = new int[3];
            iArr[0] = this.f13339b.getCurrentItem();
            List<List<T>> list = this.f13343f;
            if (list != null && list.size() > 0) {
                iArr[1] = this.f13340c.getCurrentItem() > this.f13343f.get(iArr[0]).size() - 1 ? 0 : this.f13340c.getCurrentItem();
            } else {
                iArr[1] = this.f13340c.getCurrentItem();
            }
            List<List<List<T>>> list2 = this.f13344g;
            if (list2 != null && list2.size() > 0) {
                iArr[2] = this.f13341d.getCurrentItem() <= this.f13344g.get(iArr[0]).get(iArr[1]).size() - 1 ? this.f13341d.getCurrentItem() : 0;
            } else {
                iArr[2] = this.f13341d.getCurrentItem();
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f13339b.invalidate();
            this.f13340c.invalidate();
            this.f13341d.invalidate();
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f13339b.isCenterLabel(z);
            this.f13340c.isCenterLabel(z);
            this.f13341d.isCenterLabel(z);
        }
    }

    public final void l(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048582, this, i2, i3, i4) == null) {
            if (this.f13342e != null) {
                this.f13339b.setCurrentItem(i2);
            }
            List<List<T>> list = this.f13343f;
            if (list != null) {
                this.f13340c.setAdapter(new c.a.q0.f1.p.a.a.a(list.get(i2)));
                this.f13340c.setCurrentItem(i3);
            }
            List<List<List<T>>> list2 = this.f13344g;
            if (list2 != null) {
                this.f13341d.setAdapter(new c.a.q0.f1.p.a.a.a(list2.get(i2).get(i3)));
                this.f13341d.setCurrentItem(i4);
            }
        }
    }

    public void m(Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, typeface) == null) {
            this.f13339b.setCenterTypeface(typeface);
            this.f13340c.setCenterTypeface(typeface);
            this.f13341d.setCenterTypeface(typeface);
        }
    }

    public void n(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4) == null) {
            if (this.f13345h) {
                l(i2, i3, i4);
                return;
            }
            this.f13339b.setCurrentItem(i2);
            this.f13340c.setCurrentItem(i3);
            this.f13341d.setCurrentItem(i4);
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f13339b.setCyclic(z);
            this.f13340c.setCyclic(z);
            this.f13341d.setCyclic(z);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f13339b.setDividerColor(this.o);
            this.f13340c.setDividerColor(this.o);
            this.f13341d.setDividerColor(this.o);
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
            this.f13339b.setDividerType(this.p);
            this.f13340c.setDividerType(this.p);
            this.f13341d.setDividerType(this.p);
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
            this.f13339b.setItemsVisible(i2);
            this.f13340c.setItemsVisible(i2);
            this.f13341d.setItemsVisible(i2);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f13339b.setLineSpacingMultiplier(this.q);
            this.f13340c.setLineSpacingMultiplier(this.q);
            this.f13341d.setLineSpacingMultiplier(this.q);
        }
    }

    public void v(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f2) == null) {
            this.q = f2;
            u();
        }
    }

    public void w(c.a.q0.f1.p.a.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, dVar) == null) {
            this.l = dVar;
        }
    }

    public void x(List<T> list, List<List<T>> list2, List<List<List<T>>> list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, list, list2, list3) == null) {
            this.f13342e = list;
            this.f13343f = list2;
            this.f13344g = list3;
            this.f13339b.setAdapter(new c.a.q0.f1.p.a.a.a(list));
            this.f13339b.setCurrentItem(0);
            List<List<T>> list4 = this.f13343f;
            if (list4 != null) {
                this.f13340c.setAdapter(new c.a.q0.f1.p.a.a.a(list4.get(0)));
            }
            WheelView wheelView = this.f13340c;
            wheelView.setCurrentItem(wheelView.getCurrentItem());
            List<List<List<T>>> list5 = this.f13344g;
            if (list5 != null) {
                this.f13341d.setAdapter(new c.a.q0.f1.p.a.a.a(list5.get(0).get(0)));
            }
            WheelView wheelView2 = this.f13341d;
            wheelView2.setCurrentItem(wheelView2.getCurrentItem());
            this.f13339b.setIsOptions(true);
            this.f13340c.setIsOptions(true);
            this.f13341d.setIsOptions(true);
            if (this.f13343f == null) {
                this.f13340c.setVisibility(8);
            } else {
                this.f13340c.setVisibility(0);
            }
            if (this.f13344g == null) {
                this.f13341d.setVisibility(8);
            } else {
                this.f13341d.setVisibility(0);
            }
            this.f13347j = new a(this);
            this.k = new b(this);
            if (list != null && this.f13345h) {
                this.f13339b.setOnItemSelectedListener(this.f13347j);
            }
            if (list2 != null && this.f13345h) {
                this.f13340c.setOnItemSelectedListener(this.k);
            }
            if (list3 == null || !this.f13345h || this.l == null) {
                return;
            }
            this.f13341d.setOnItemSelectedListener(new C0662c(this));
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f13339b.setTextColorCenter(this.n);
            this.f13340c.setTextColorCenter(this.n);
            this.f13341d.setTextColorCenter(this.n);
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
