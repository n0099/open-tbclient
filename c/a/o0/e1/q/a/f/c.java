package c.a.o0.e1.q.a.f;

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
/* loaded from: classes2.dex */
public class c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public WheelView f10227b;

    /* renamed from: c  reason: collision with root package name */
    public WheelView f10228c;

    /* renamed from: d  reason: collision with root package name */
    public WheelView f10229d;

    /* renamed from: e  reason: collision with root package name */
    public List<T> f10230e;

    /* renamed from: f  reason: collision with root package name */
    public List<List<T>> f10231f;

    /* renamed from: g  reason: collision with root package name */
    public List<List<List<T>>> f10232g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f10233h;
    public boolean i;
    public c.a.o0.e1.q.b.c.b j;
    public c.a.o0.e1.q.b.c.b k;
    public c.a.o0.e1.q.a.d.d l;
    public int m;
    public int n;
    public int o;
    public WheelView.DividerType p;
    public float q;

    /* loaded from: classes2.dex */
    public class a implements c.a.o0.e1.q.b.c.b {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.o0.e1.q.b.c.b
        public void onItemSelected(int i) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (this.a.f10231f == null) {
                    if (this.a.l != null) {
                        this.a.l.a(this.a.f10227b.getCurrentItem(), 0, 0);
                        return;
                    }
                    return;
                }
                if (this.a.i) {
                    i2 = 0;
                } else {
                    i2 = this.a.f10228c.getCurrentItem();
                    if (i2 >= ((List) this.a.f10231f.get(i)).size() - 1) {
                        i2 = ((List) this.a.f10231f.get(i)).size() - 1;
                    }
                }
                this.a.f10228c.setAdapter(new c.a.o0.e1.q.a.a.a((List) this.a.f10231f.get(i)));
                this.a.f10228c.setCurrentItem(i2);
                if (this.a.f10232g != null) {
                    this.a.k.onItemSelected(i2);
                } else if (this.a.l != null) {
                    this.a.l.a(i, i2, 0);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements c.a.o0.e1.q.b.c.b {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.o0.e1.q.b.c.b
        public void onItemSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                int i2 = 0;
                if (this.a.f10232g != null) {
                    int currentItem = this.a.f10227b.getCurrentItem();
                    if (currentItem >= this.a.f10232g.size() - 1) {
                        currentItem = this.a.f10232g.size() - 1;
                    }
                    if (i >= ((List) this.a.f10231f.get(currentItem)).size() - 1) {
                        i = ((List) this.a.f10231f.get(currentItem)).size() - 1;
                    }
                    if (!this.a.i) {
                        i2 = this.a.f10229d.getCurrentItem() >= ((List) ((List) this.a.f10232g.get(currentItem)).get(i)).size() + (-1) ? ((List) ((List) this.a.f10232g.get(currentItem)).get(i)).size() - 1 : this.a.f10229d.getCurrentItem();
                    }
                    this.a.f10229d.setAdapter(new c.a.o0.e1.q.a.a.a((List) ((List) this.a.f10232g.get(this.a.f10227b.getCurrentItem())).get(i)));
                    this.a.f10229d.setCurrentItem(i2);
                    if (this.a.l != null) {
                        this.a.l.a(this.a.f10227b.getCurrentItem(), i, i2);
                    }
                } else if (this.a.l != null) {
                    this.a.l.a(this.a.f10227b.getCurrentItem(), i, 0);
                }
            }
        }
    }

    /* renamed from: c.a.o0.e1.q.a.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0805c implements c.a.o0.e1.q.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public C0805c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.o0.e1.q.b.c.b
        public void onItemSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.l.a(this.a.f10227b.getCurrentItem(), this.a.f10228c.getCurrentItem(), i);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10233h = true;
        this.i = z;
        this.a = view;
        this.f10227b = (WheelView) view.findViewById(R.id.obfuscated_res_0x7f09160f);
        this.f10228c = (WheelView) view.findViewById(R.id.obfuscated_res_0x7f091610);
        this.f10229d = (WheelView) view.findViewById(R.id.obfuscated_res_0x7f091611);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f10227b.setTextColorOut(this.m);
            this.f10228c.setTextColorOut(this.m);
            this.f10229d.setTextColorOut(this.m);
        }
    }

    public void B(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.m = i;
            A();
        }
    }

    public void C(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            float f2 = i;
            this.f10227b.setTextSize(f2);
            this.f10228c.setTextSize(f2);
            this.f10229d.setTextSize(f2);
        }
    }

    public int[] i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int[] iArr = new int[3];
            iArr[0] = this.f10227b.getCurrentItem();
            List<List<T>> list = this.f10231f;
            if (list != null && list.size() > 0) {
                iArr[1] = this.f10228c.getCurrentItem() > this.f10231f.get(iArr[0]).size() - 1 ? 0 : this.f10228c.getCurrentItem();
            } else {
                iArr[1] = this.f10228c.getCurrentItem();
            }
            List<List<List<T>>> list2 = this.f10232g;
            if (list2 != null && list2.size() > 0) {
                iArr[2] = this.f10229d.getCurrentItem() <= this.f10232g.get(iArr[0]).get(iArr[1]).size() - 1 ? this.f10229d.getCurrentItem() : 0;
            } else {
                iArr[2] = this.f10229d.getCurrentItem();
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f10227b.invalidate();
            this.f10228c.invalidate();
            this.f10229d.invalidate();
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f10227b.h(z);
            this.f10228c.h(z);
            this.f10229d.h(z);
        }
    }

    public final void l(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048582, this, i, i2, i3) == null) {
            if (this.f10230e != null) {
                this.f10227b.setCurrentItem(i);
            }
            List<List<T>> list = this.f10231f;
            if (list != null) {
                this.f10228c.setAdapter(new c.a.o0.e1.q.a.a.a(list.get(i)));
                this.f10228c.setCurrentItem(i2);
            }
            List<List<List<T>>> list2 = this.f10232g;
            if (list2 != null) {
                this.f10229d.setAdapter(new c.a.o0.e1.q.a.a.a(list2.get(i).get(i2)));
                this.f10229d.setCurrentItem(i3);
            }
        }
    }

    public void m(Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, typeface) == null) {
            this.f10227b.setCenterTypeface(typeface);
            this.f10228c.setCenterTypeface(typeface);
            this.f10229d.setCenterTypeface(typeface);
        }
    }

    public void n(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3) == null) {
            if (this.f10233h) {
                l(i, i2, i3);
                return;
            }
            this.f10227b.setCurrentItem(i);
            this.f10228c.setCurrentItem(i2);
            this.f10229d.setCurrentItem(i3);
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f10227b.setCyclic(z);
            this.f10228c.setCyclic(z);
            this.f10229d.setCyclic(z);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f10227b.setDividerColor(this.o);
            this.f10228c.setDividerColor(this.o);
            this.f10229d.setDividerColor(this.o);
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.o = i;
            p();
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f10227b.setDividerType(this.p);
            this.f10228c.setDividerType(this.p);
            this.f10229d.setDividerType(this.p);
        }
    }

    public void s(WheelView.DividerType dividerType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dividerType) == null) {
            this.p = dividerType;
            r();
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.f10227b.setItemsVisible(i);
            this.f10228c.setItemsVisible(i);
            this.f10229d.setItemsVisible(i);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f10227b.setLineSpacingMultiplier(this.q);
            this.f10228c.setLineSpacingMultiplier(this.q);
            this.f10229d.setLineSpacingMultiplier(this.q);
        }
    }

    public void v(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f2) == null) {
            this.q = f2;
            u();
        }
    }

    public void w(c.a.o0.e1.q.a.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, dVar) == null) {
            this.l = dVar;
        }
    }

    public void x(List<T> list, List<List<T>> list2, List<List<List<T>>> list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, list, list2, list3) == null) {
            this.f10230e = list;
            this.f10231f = list2;
            this.f10232g = list3;
            this.f10227b.setAdapter(new c.a.o0.e1.q.a.a.a(list));
            this.f10227b.setCurrentItem(0);
            List<List<T>> list4 = this.f10231f;
            if (list4 != null) {
                this.f10228c.setAdapter(new c.a.o0.e1.q.a.a.a(list4.get(0)));
            }
            WheelView wheelView = this.f10228c;
            wheelView.setCurrentItem(wheelView.getCurrentItem());
            List<List<List<T>>> list5 = this.f10232g;
            if (list5 != null) {
                this.f10229d.setAdapter(new c.a.o0.e1.q.a.a.a(list5.get(0).get(0)));
            }
            WheelView wheelView2 = this.f10229d;
            wheelView2.setCurrentItem(wheelView2.getCurrentItem());
            this.f10227b.setIsOptions(true);
            this.f10228c.setIsOptions(true);
            this.f10229d.setIsOptions(true);
            if (this.f10231f == null) {
                this.f10228c.setVisibility(8);
            } else {
                this.f10228c.setVisibility(0);
            }
            if (this.f10232g == null) {
                this.f10229d.setVisibility(8);
            } else {
                this.f10229d.setVisibility(0);
            }
            this.j = new a(this);
            this.k = new b(this);
            if (list != null && this.f10233h) {
                this.f10227b.setOnItemSelectedListener(this.j);
            }
            if (list2 != null && this.f10233h) {
                this.f10228c.setOnItemSelectedListener(this.k);
            }
            if (list3 == null || !this.f10233h || this.l == null) {
                return;
            }
            this.f10229d.setOnItemSelectedListener(new C0805c(this));
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f10227b.setTextColorCenter(this.n);
            this.f10228c.setTextColorCenter(this.n);
            this.f10229d.setTextColorCenter(this.n);
        }
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.n = i;
            y();
        }
    }
}
