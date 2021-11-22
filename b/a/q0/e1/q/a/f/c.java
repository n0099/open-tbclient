package b.a.q0.e1.q.a.f;

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
    public View f13202a;

    /* renamed from: b  reason: collision with root package name */
    public WheelView f13203b;

    /* renamed from: c  reason: collision with root package name */
    public WheelView f13204c;

    /* renamed from: d  reason: collision with root package name */
    public WheelView f13205d;

    /* renamed from: e  reason: collision with root package name */
    public List<T> f13206e;

    /* renamed from: f  reason: collision with root package name */
    public List<List<T>> f13207f;

    /* renamed from: g  reason: collision with root package name */
    public List<List<List<T>>> f13208g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13209h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13210i;
    public b.a.q0.e1.q.b.c.b j;
    public b.a.q0.e1.q.b.c.b k;
    public b.a.q0.e1.q.a.d.d l;
    public int m;
    public int n;
    public int o;
    public WheelView.DividerType p;
    public float q;

    /* loaded from: classes4.dex */
    public class a implements b.a.q0.e1.q.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f13211a;

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
            this.f13211a = cVar;
        }

        @Override // b.a.q0.e1.q.b.c.b
        public void a(int i2) {
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f13211a.f13207f == null) {
                    if (this.f13211a.l != null) {
                        this.f13211a.l.a(this.f13211a.f13203b.getCurrentItem(), 0, 0);
                        return;
                    }
                    return;
                }
                if (this.f13211a.f13210i) {
                    i3 = 0;
                } else {
                    i3 = this.f13211a.f13204c.getCurrentItem();
                    if (i3 >= ((List) this.f13211a.f13207f.get(i2)).size() - 1) {
                        i3 = ((List) this.f13211a.f13207f.get(i2)).size() - 1;
                    }
                }
                this.f13211a.f13204c.setAdapter(new b.a.q0.e1.q.a.a.a((List) this.f13211a.f13207f.get(i2)));
                this.f13211a.f13204c.setCurrentItem(i3);
                if (this.f13211a.f13208g != null) {
                    this.f13211a.k.a(i3);
                } else if (this.f13211a.l != null) {
                    this.f13211a.l.a(i2, i3, 0);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements b.a.q0.e1.q.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f13212a;

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
            this.f13212a = cVar;
        }

        @Override // b.a.q0.e1.q.b.c.b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                int i3 = 0;
                if (this.f13212a.f13208g != null) {
                    int currentItem = this.f13212a.f13203b.getCurrentItem();
                    if (currentItem >= this.f13212a.f13208g.size() - 1) {
                        currentItem = this.f13212a.f13208g.size() - 1;
                    }
                    if (i2 >= ((List) this.f13212a.f13207f.get(currentItem)).size() - 1) {
                        i2 = ((List) this.f13212a.f13207f.get(currentItem)).size() - 1;
                    }
                    if (!this.f13212a.f13210i) {
                        i3 = this.f13212a.f13205d.getCurrentItem() >= ((List) ((List) this.f13212a.f13208g.get(currentItem)).get(i2)).size() + (-1) ? ((List) ((List) this.f13212a.f13208g.get(currentItem)).get(i2)).size() - 1 : this.f13212a.f13205d.getCurrentItem();
                    }
                    this.f13212a.f13205d.setAdapter(new b.a.q0.e1.q.a.a.a((List) ((List) this.f13212a.f13208g.get(this.f13212a.f13203b.getCurrentItem())).get(i2)));
                    this.f13212a.f13205d.setCurrentItem(i3);
                    if (this.f13212a.l != null) {
                        this.f13212a.l.a(this.f13212a.f13203b.getCurrentItem(), i2, i3);
                    }
                } else if (this.f13212a.l != null) {
                    this.f13212a.l.a(this.f13212a.f13203b.getCurrentItem(), i2, 0);
                }
            }
        }
    }

    /* renamed from: b.a.q0.e1.q.a.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0691c implements b.a.q0.e1.q.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f13213a;

        public C0691c(c cVar) {
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
            this.f13213a = cVar;
        }

        @Override // b.a.q0.e1.q.b.c.b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f13213a.l.a(this.f13213a.f13203b.getCurrentItem(), this.f13213a.f13204c.getCurrentItem(), i2);
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
        this.f13209h = true;
        this.f13210i = z;
        this.f13202a = view;
        this.f13203b = (WheelView) view.findViewById(R.id.options1);
        this.f13204c = (WheelView) view.findViewById(R.id.options2);
        this.f13205d = (WheelView) view.findViewById(R.id.options3);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f13203b.setTextColorOut(this.m);
            this.f13204c.setTextColorOut(this.m);
            this.f13205d.setTextColorOut(this.m);
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
            this.f13203b.setTextSize(f2);
            this.f13204c.setTextSize(f2);
            this.f13205d.setTextSize(f2);
        }
    }

    public int[] i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int[] iArr = new int[3];
            iArr[0] = this.f13203b.getCurrentItem();
            List<List<T>> list = this.f13207f;
            if (list != null && list.size() > 0) {
                iArr[1] = this.f13204c.getCurrentItem() > this.f13207f.get(iArr[0]).size() - 1 ? 0 : this.f13204c.getCurrentItem();
            } else {
                iArr[1] = this.f13204c.getCurrentItem();
            }
            List<List<List<T>>> list2 = this.f13208g;
            if (list2 != null && list2.size() > 0) {
                iArr[2] = this.f13205d.getCurrentItem() <= this.f13208g.get(iArr[0]).get(iArr[1]).size() - 1 ? this.f13205d.getCurrentItem() : 0;
            } else {
                iArr[2] = this.f13205d.getCurrentItem();
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f13203b.invalidate();
            this.f13204c.invalidate();
            this.f13205d.invalidate();
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f13203b.isCenterLabel(z);
            this.f13204c.isCenterLabel(z);
            this.f13205d.isCenterLabel(z);
        }
    }

    public final void l(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048582, this, i2, i3, i4) == null) {
            if (this.f13206e != null) {
                this.f13203b.setCurrentItem(i2);
            }
            List<List<T>> list = this.f13207f;
            if (list != null) {
                this.f13204c.setAdapter(new b.a.q0.e1.q.a.a.a(list.get(i2)));
                this.f13204c.setCurrentItem(i3);
            }
            List<List<List<T>>> list2 = this.f13208g;
            if (list2 != null) {
                this.f13205d.setAdapter(new b.a.q0.e1.q.a.a.a(list2.get(i2).get(i3)));
                this.f13205d.setCurrentItem(i4);
            }
        }
    }

    public void m(Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, typeface) == null) {
            this.f13203b.setCenterTypeface(typeface);
            this.f13204c.setCenterTypeface(typeface);
            this.f13205d.setCenterTypeface(typeface);
        }
    }

    public void n(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4) == null) {
            if (this.f13209h) {
                l(i2, i3, i4);
                return;
            }
            this.f13203b.setCurrentItem(i2);
            this.f13204c.setCurrentItem(i3);
            this.f13205d.setCurrentItem(i4);
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f13203b.setCyclic(z);
            this.f13204c.setCyclic(z);
            this.f13205d.setCyclic(z);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f13203b.setDividerColor(this.o);
            this.f13204c.setDividerColor(this.o);
            this.f13205d.setDividerColor(this.o);
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
            this.f13203b.setDividerType(this.p);
            this.f13204c.setDividerType(this.p);
            this.f13205d.setDividerType(this.p);
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
            this.f13203b.setItemsVisible(i2);
            this.f13204c.setItemsVisible(i2);
            this.f13205d.setItemsVisible(i2);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f13203b.setLineSpacingMultiplier(this.q);
            this.f13204c.setLineSpacingMultiplier(this.q);
            this.f13205d.setLineSpacingMultiplier(this.q);
        }
    }

    public void v(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f2) == null) {
            this.q = f2;
            u();
        }
    }

    public void w(b.a.q0.e1.q.a.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, dVar) == null) {
            this.l = dVar;
        }
    }

    public void x(List<T> list, List<List<T>> list2, List<List<List<T>>> list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, list, list2, list3) == null) {
            this.f13206e = list;
            this.f13207f = list2;
            this.f13208g = list3;
            this.f13203b.setAdapter(new b.a.q0.e1.q.a.a.a(list));
            this.f13203b.setCurrentItem(0);
            List<List<T>> list4 = this.f13207f;
            if (list4 != null) {
                this.f13204c.setAdapter(new b.a.q0.e1.q.a.a.a(list4.get(0)));
            }
            WheelView wheelView = this.f13204c;
            wheelView.setCurrentItem(wheelView.getCurrentItem());
            List<List<List<T>>> list5 = this.f13208g;
            if (list5 != null) {
                this.f13205d.setAdapter(new b.a.q0.e1.q.a.a.a(list5.get(0).get(0)));
            }
            WheelView wheelView2 = this.f13205d;
            wheelView2.setCurrentItem(wheelView2.getCurrentItem());
            this.f13203b.setIsOptions(true);
            this.f13204c.setIsOptions(true);
            this.f13205d.setIsOptions(true);
            if (this.f13207f == null) {
                this.f13204c.setVisibility(8);
            } else {
                this.f13204c.setVisibility(0);
            }
            if (this.f13208g == null) {
                this.f13205d.setVisibility(8);
            } else {
                this.f13205d.setVisibility(0);
            }
            this.j = new a(this);
            this.k = new b(this);
            if (list != null && this.f13209h) {
                this.f13203b.setOnItemSelectedListener(this.j);
            }
            if (list2 != null && this.f13209h) {
                this.f13204c.setOnItemSelectedListener(this.k);
            }
            if (list3 == null || !this.f13209h || this.l == null) {
                return;
            }
            this.f13205d.setOnItemSelectedListener(new C0691c(this));
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f13203b.setTextColorCenter(this.n);
            this.f13204c.setTextColorCenter(this.n);
            this.f13205d.setTextColorCenter(this.n);
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
