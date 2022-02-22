package c.a.t0.f1.q.a.f;

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
    public WheelView f13089b;

    /* renamed from: c  reason: collision with root package name */
    public WheelView f13090c;

    /* renamed from: d  reason: collision with root package name */
    public WheelView f13091d;

    /* renamed from: e  reason: collision with root package name */
    public List<T> f13092e;

    /* renamed from: f  reason: collision with root package name */
    public List<List<T>> f13093f;

    /* renamed from: g  reason: collision with root package name */
    public List<List<List<T>>> f13094g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13095h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13096i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.t0.f1.q.b.c.b f13097j;
    public c.a.t0.f1.q.b.c.b k;
    public c.a.t0.f1.q.a.d.d l;
    public int m;
    public int n;
    public int o;
    public WheelView.DividerType p;
    public float q;

    /* loaded from: classes6.dex */
    public class a implements c.a.t0.f1.q.b.c.b {
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

        @Override // c.a.t0.f1.q.b.c.b
        public void onItemSelected(int i2) {
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.a.f13093f == null) {
                    if (this.a.l != null) {
                        this.a.l.a(this.a.f13089b.getCurrentItem(), 0, 0);
                        return;
                    }
                    return;
                }
                if (this.a.f13096i) {
                    i3 = 0;
                } else {
                    i3 = this.a.f13090c.getCurrentItem();
                    if (i3 >= ((List) this.a.f13093f.get(i2)).size() - 1) {
                        i3 = ((List) this.a.f13093f.get(i2)).size() - 1;
                    }
                }
                this.a.f13090c.setAdapter(new c.a.t0.f1.q.a.a.a((List) this.a.f13093f.get(i2)));
                this.a.f13090c.setCurrentItem(i3);
                if (this.a.f13094g != null) {
                    this.a.k.onItemSelected(i3);
                } else if (this.a.l != null) {
                    this.a.l.a(i2, i3, 0);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements c.a.t0.f1.q.b.c.b {
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

        @Override // c.a.t0.f1.q.b.c.b
        public void onItemSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                int i3 = 0;
                if (this.a.f13094g != null) {
                    int currentItem = this.a.f13089b.getCurrentItem();
                    if (currentItem >= this.a.f13094g.size() - 1) {
                        currentItem = this.a.f13094g.size() - 1;
                    }
                    if (i2 >= ((List) this.a.f13093f.get(currentItem)).size() - 1) {
                        i2 = ((List) this.a.f13093f.get(currentItem)).size() - 1;
                    }
                    if (!this.a.f13096i) {
                        i3 = this.a.f13091d.getCurrentItem() >= ((List) ((List) this.a.f13094g.get(currentItem)).get(i2)).size() + (-1) ? ((List) ((List) this.a.f13094g.get(currentItem)).get(i2)).size() - 1 : this.a.f13091d.getCurrentItem();
                    }
                    this.a.f13091d.setAdapter(new c.a.t0.f1.q.a.a.a((List) ((List) this.a.f13094g.get(this.a.f13089b.getCurrentItem())).get(i2)));
                    this.a.f13091d.setCurrentItem(i3);
                    if (this.a.l != null) {
                        this.a.l.a(this.a.f13089b.getCurrentItem(), i2, i3);
                    }
                } else if (this.a.l != null) {
                    this.a.l.a(this.a.f13089b.getCurrentItem(), i2, 0);
                }
            }
        }
    }

    /* renamed from: c.a.t0.f1.q.a.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0865c implements c.a.t0.f1.q.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public C0865c(c cVar) {
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

        @Override // c.a.t0.f1.q.b.c.b
        public void onItemSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.a.l.a(this.a.f13089b.getCurrentItem(), this.a.f13090c.getCurrentItem(), i2);
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
        this.f13095h = true;
        this.f13096i = z;
        this.a = view;
        this.f13089b = (WheelView) view.findViewById(R.id.options1);
        this.f13090c = (WheelView) view.findViewById(R.id.options2);
        this.f13091d = (WheelView) view.findViewById(R.id.options3);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f13089b.setTextColorOut(this.m);
            this.f13090c.setTextColorOut(this.m);
            this.f13091d.setTextColorOut(this.m);
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
            this.f13089b.setTextSize(f2);
            this.f13090c.setTextSize(f2);
            this.f13091d.setTextSize(f2);
        }
    }

    public int[] i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int[] iArr = new int[3];
            iArr[0] = this.f13089b.getCurrentItem();
            List<List<T>> list = this.f13093f;
            if (list != null && list.size() > 0) {
                iArr[1] = this.f13090c.getCurrentItem() > this.f13093f.get(iArr[0]).size() - 1 ? 0 : this.f13090c.getCurrentItem();
            } else {
                iArr[1] = this.f13090c.getCurrentItem();
            }
            List<List<List<T>>> list2 = this.f13094g;
            if (list2 != null && list2.size() > 0) {
                iArr[2] = this.f13091d.getCurrentItem() <= this.f13094g.get(iArr[0]).get(iArr[1]).size() - 1 ? this.f13091d.getCurrentItem() : 0;
            } else {
                iArr[2] = this.f13091d.getCurrentItem();
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f13089b.invalidate();
            this.f13090c.invalidate();
            this.f13091d.invalidate();
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f13089b.isCenterLabel(z);
            this.f13090c.isCenterLabel(z);
            this.f13091d.isCenterLabel(z);
        }
    }

    public final void l(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048582, this, i2, i3, i4) == null) {
            if (this.f13092e != null) {
                this.f13089b.setCurrentItem(i2);
            }
            List<List<T>> list = this.f13093f;
            if (list != null) {
                this.f13090c.setAdapter(new c.a.t0.f1.q.a.a.a(list.get(i2)));
                this.f13090c.setCurrentItem(i3);
            }
            List<List<List<T>>> list2 = this.f13094g;
            if (list2 != null) {
                this.f13091d.setAdapter(new c.a.t0.f1.q.a.a.a(list2.get(i2).get(i3)));
                this.f13091d.setCurrentItem(i4);
            }
        }
    }

    public void m(Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, typeface) == null) {
            this.f13089b.setCenterTypeface(typeface);
            this.f13090c.setCenterTypeface(typeface);
            this.f13091d.setCenterTypeface(typeface);
        }
    }

    public void n(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4) == null) {
            if (this.f13095h) {
                l(i2, i3, i4);
                return;
            }
            this.f13089b.setCurrentItem(i2);
            this.f13090c.setCurrentItem(i3);
            this.f13091d.setCurrentItem(i4);
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f13089b.setCyclic(z);
            this.f13090c.setCyclic(z);
            this.f13091d.setCyclic(z);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f13089b.setDividerColor(this.o);
            this.f13090c.setDividerColor(this.o);
            this.f13091d.setDividerColor(this.o);
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
            this.f13089b.setDividerType(this.p);
            this.f13090c.setDividerType(this.p);
            this.f13091d.setDividerType(this.p);
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
            this.f13089b.setItemsVisible(i2);
            this.f13090c.setItemsVisible(i2);
            this.f13091d.setItemsVisible(i2);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f13089b.setLineSpacingMultiplier(this.q);
            this.f13090c.setLineSpacingMultiplier(this.q);
            this.f13091d.setLineSpacingMultiplier(this.q);
        }
    }

    public void v(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f2) == null) {
            this.q = f2;
            u();
        }
    }

    public void w(c.a.t0.f1.q.a.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, dVar) == null) {
            this.l = dVar;
        }
    }

    public void x(List<T> list, List<List<T>> list2, List<List<List<T>>> list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, list, list2, list3) == null) {
            this.f13092e = list;
            this.f13093f = list2;
            this.f13094g = list3;
            this.f13089b.setAdapter(new c.a.t0.f1.q.a.a.a(list));
            this.f13089b.setCurrentItem(0);
            List<List<T>> list4 = this.f13093f;
            if (list4 != null) {
                this.f13090c.setAdapter(new c.a.t0.f1.q.a.a.a(list4.get(0)));
            }
            WheelView wheelView = this.f13090c;
            wheelView.setCurrentItem(wheelView.getCurrentItem());
            List<List<List<T>>> list5 = this.f13094g;
            if (list5 != null) {
                this.f13091d.setAdapter(new c.a.t0.f1.q.a.a.a(list5.get(0).get(0)));
            }
            WheelView wheelView2 = this.f13091d;
            wheelView2.setCurrentItem(wheelView2.getCurrentItem());
            this.f13089b.setIsOptions(true);
            this.f13090c.setIsOptions(true);
            this.f13091d.setIsOptions(true);
            if (this.f13093f == null) {
                this.f13090c.setVisibility(8);
            } else {
                this.f13090c.setVisibility(0);
            }
            if (this.f13094g == null) {
                this.f13091d.setVisibility(8);
            } else {
                this.f13091d.setVisibility(0);
            }
            this.f13097j = new a(this);
            this.k = new b(this);
            if (list != null && this.f13095h) {
                this.f13089b.setOnItemSelectedListener(this.f13097j);
            }
            if (list2 != null && this.f13095h) {
                this.f13090c.setOnItemSelectedListener(this.k);
            }
            if (list3 == null || !this.f13095h || this.l == null) {
                return;
            }
            this.f13091d.setOnItemSelectedListener(new C0865c(this));
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f13089b.setTextColorCenter(this.n);
            this.f13090c.setTextColorCenter(this.n);
            this.f13091d.setTextColorCenter(this.n);
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
