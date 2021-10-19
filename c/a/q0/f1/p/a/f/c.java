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
    public View f13346a;

    /* renamed from: b  reason: collision with root package name */
    public WheelView f13347b;

    /* renamed from: c  reason: collision with root package name */
    public WheelView f13348c;

    /* renamed from: d  reason: collision with root package name */
    public WheelView f13349d;

    /* renamed from: e  reason: collision with root package name */
    public List<T> f13350e;

    /* renamed from: f  reason: collision with root package name */
    public List<List<T>> f13351f;

    /* renamed from: g  reason: collision with root package name */
    public List<List<List<T>>> f13352g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13353h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13354i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.q0.f1.p.b.c.b f13355j;
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
        public final /* synthetic */ c f13356a;

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
            this.f13356a = cVar;
        }

        @Override // c.a.q0.f1.p.b.c.b
        public void a(int i2) {
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f13356a.f13351f == null) {
                    if (this.f13356a.l != null) {
                        this.f13356a.l.a(this.f13356a.f13347b.getCurrentItem(), 0, 0);
                        return;
                    }
                    return;
                }
                if (this.f13356a.f13354i) {
                    i3 = 0;
                } else {
                    i3 = this.f13356a.f13348c.getCurrentItem();
                    if (i3 >= ((List) this.f13356a.f13351f.get(i2)).size() - 1) {
                        i3 = ((List) this.f13356a.f13351f.get(i2)).size() - 1;
                    }
                }
                this.f13356a.f13348c.setAdapter(new c.a.q0.f1.p.a.a.a((List) this.f13356a.f13351f.get(i2)));
                this.f13356a.f13348c.setCurrentItem(i3);
                if (this.f13356a.f13352g != null) {
                    this.f13356a.k.a(i3);
                } else if (this.f13356a.l != null) {
                    this.f13356a.l.a(i2, i3, 0);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.a.q0.f1.p.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f13357a;

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
            this.f13357a = cVar;
        }

        @Override // c.a.q0.f1.p.b.c.b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                int i3 = 0;
                if (this.f13357a.f13352g != null) {
                    int currentItem = this.f13357a.f13347b.getCurrentItem();
                    if (currentItem >= this.f13357a.f13352g.size() - 1) {
                        currentItem = this.f13357a.f13352g.size() - 1;
                    }
                    if (i2 >= ((List) this.f13357a.f13351f.get(currentItem)).size() - 1) {
                        i2 = ((List) this.f13357a.f13351f.get(currentItem)).size() - 1;
                    }
                    if (!this.f13357a.f13354i) {
                        i3 = this.f13357a.f13349d.getCurrentItem() >= ((List) ((List) this.f13357a.f13352g.get(currentItem)).get(i2)).size() + (-1) ? ((List) ((List) this.f13357a.f13352g.get(currentItem)).get(i2)).size() - 1 : this.f13357a.f13349d.getCurrentItem();
                    }
                    this.f13357a.f13349d.setAdapter(new c.a.q0.f1.p.a.a.a((List) ((List) this.f13357a.f13352g.get(this.f13357a.f13347b.getCurrentItem())).get(i2)));
                    this.f13357a.f13349d.setCurrentItem(i3);
                    if (this.f13357a.l != null) {
                        this.f13357a.l.a(this.f13357a.f13347b.getCurrentItem(), i2, i3);
                    }
                } else if (this.f13357a.l != null) {
                    this.f13357a.l.a(this.f13357a.f13347b.getCurrentItem(), i2, 0);
                }
            }
        }
    }

    /* renamed from: c.a.q0.f1.p.a.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0663c implements c.a.q0.f1.p.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f13358a;

        public C0663c(c cVar) {
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
            this.f13358a = cVar;
        }

        @Override // c.a.q0.f1.p.b.c.b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f13358a.l.a(this.f13358a.f13347b.getCurrentItem(), this.f13358a.f13348c.getCurrentItem(), i2);
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
        this.f13353h = true;
        this.f13354i = z;
        this.f13346a = view;
        this.f13347b = (WheelView) view.findViewById(R.id.options1);
        this.f13348c = (WheelView) view.findViewById(R.id.options2);
        this.f13349d = (WheelView) view.findViewById(R.id.options3);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f13347b.setTextColorOut(this.m);
            this.f13348c.setTextColorOut(this.m);
            this.f13349d.setTextColorOut(this.m);
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
            this.f13347b.setTextSize(f2);
            this.f13348c.setTextSize(f2);
            this.f13349d.setTextSize(f2);
        }
    }

    public int[] i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int[] iArr = new int[3];
            iArr[0] = this.f13347b.getCurrentItem();
            List<List<T>> list = this.f13351f;
            if (list != null && list.size() > 0) {
                iArr[1] = this.f13348c.getCurrentItem() > this.f13351f.get(iArr[0]).size() - 1 ? 0 : this.f13348c.getCurrentItem();
            } else {
                iArr[1] = this.f13348c.getCurrentItem();
            }
            List<List<List<T>>> list2 = this.f13352g;
            if (list2 != null && list2.size() > 0) {
                iArr[2] = this.f13349d.getCurrentItem() <= this.f13352g.get(iArr[0]).get(iArr[1]).size() - 1 ? this.f13349d.getCurrentItem() : 0;
            } else {
                iArr[2] = this.f13349d.getCurrentItem();
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f13347b.invalidate();
            this.f13348c.invalidate();
            this.f13349d.invalidate();
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f13347b.isCenterLabel(z);
            this.f13348c.isCenterLabel(z);
            this.f13349d.isCenterLabel(z);
        }
    }

    public final void l(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048582, this, i2, i3, i4) == null) {
            if (this.f13350e != null) {
                this.f13347b.setCurrentItem(i2);
            }
            List<List<T>> list = this.f13351f;
            if (list != null) {
                this.f13348c.setAdapter(new c.a.q0.f1.p.a.a.a(list.get(i2)));
                this.f13348c.setCurrentItem(i3);
            }
            List<List<List<T>>> list2 = this.f13352g;
            if (list2 != null) {
                this.f13349d.setAdapter(new c.a.q0.f1.p.a.a.a(list2.get(i2).get(i3)));
                this.f13349d.setCurrentItem(i4);
            }
        }
    }

    public void m(Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, typeface) == null) {
            this.f13347b.setCenterTypeface(typeface);
            this.f13348c.setCenterTypeface(typeface);
            this.f13349d.setCenterTypeface(typeface);
        }
    }

    public void n(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4) == null) {
            if (this.f13353h) {
                l(i2, i3, i4);
                return;
            }
            this.f13347b.setCurrentItem(i2);
            this.f13348c.setCurrentItem(i3);
            this.f13349d.setCurrentItem(i4);
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f13347b.setCyclic(z);
            this.f13348c.setCyclic(z);
            this.f13349d.setCyclic(z);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f13347b.setDividerColor(this.o);
            this.f13348c.setDividerColor(this.o);
            this.f13349d.setDividerColor(this.o);
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
            this.f13347b.setDividerType(this.p);
            this.f13348c.setDividerType(this.p);
            this.f13349d.setDividerType(this.p);
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
            this.f13347b.setItemsVisible(i2);
            this.f13348c.setItemsVisible(i2);
            this.f13349d.setItemsVisible(i2);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f13347b.setLineSpacingMultiplier(this.q);
            this.f13348c.setLineSpacingMultiplier(this.q);
            this.f13349d.setLineSpacingMultiplier(this.q);
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
            this.f13350e = list;
            this.f13351f = list2;
            this.f13352g = list3;
            this.f13347b.setAdapter(new c.a.q0.f1.p.a.a.a(list));
            this.f13347b.setCurrentItem(0);
            List<List<T>> list4 = this.f13351f;
            if (list4 != null) {
                this.f13348c.setAdapter(new c.a.q0.f1.p.a.a.a(list4.get(0)));
            }
            WheelView wheelView = this.f13348c;
            wheelView.setCurrentItem(wheelView.getCurrentItem());
            List<List<List<T>>> list5 = this.f13352g;
            if (list5 != null) {
                this.f13349d.setAdapter(new c.a.q0.f1.p.a.a.a(list5.get(0).get(0)));
            }
            WheelView wheelView2 = this.f13349d;
            wheelView2.setCurrentItem(wheelView2.getCurrentItem());
            this.f13347b.setIsOptions(true);
            this.f13348c.setIsOptions(true);
            this.f13349d.setIsOptions(true);
            if (this.f13351f == null) {
                this.f13348c.setVisibility(8);
            } else {
                this.f13348c.setVisibility(0);
            }
            if (this.f13352g == null) {
                this.f13349d.setVisibility(8);
            } else {
                this.f13349d.setVisibility(0);
            }
            this.f13355j = new a(this);
            this.k = new b(this);
            if (list != null && this.f13353h) {
                this.f13347b.setOnItemSelectedListener(this.f13355j);
            }
            if (list2 != null && this.f13353h) {
                this.f13348c.setOnItemSelectedListener(this.k);
            }
            if (list3 == null || !this.f13353h || this.l == null) {
                return;
            }
            this.f13349d.setOnItemSelectedListener(new C0663c(this));
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f13347b.setTextColorCenter(this.n);
            this.f13348c.setTextColorCenter(this.n);
            this.f13349d.setTextColorCenter(this.n);
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
