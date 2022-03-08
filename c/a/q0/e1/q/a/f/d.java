package c.a.q0.e1.q.a.f;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static DateFormat y;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public WheelView f12508b;

    /* renamed from: c  reason: collision with root package name */
    public WheelView f12509c;

    /* renamed from: d  reason: collision with root package name */
    public WheelView f12510d;

    /* renamed from: e  reason: collision with root package name */
    public WheelView f12511e;

    /* renamed from: f  reason: collision with root package name */
    public WheelView f12512f;

    /* renamed from: g  reason: collision with root package name */
    public WheelView f12513g;

    /* renamed from: h  reason: collision with root package name */
    public int f12514h;

    /* renamed from: i  reason: collision with root package name */
    public boolean[] f12515i;

    /* renamed from: j  reason: collision with root package name */
    public int f12516j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public float u;
    public WheelView.DividerType v;
    public boolean w;
    public c.a.q0.e1.q.a.d.b x;

    /* loaded from: classes2.dex */
    public class a implements c.a.q0.e1.q.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.q0.e1.q.b.c.b
        public void onItemSelected(int i2) {
            int h2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                int i3 = i2 + this.a.f12516j;
                this.a.f12509c.setAdapter(new c.a.q0.e1.q.a.a.a(c.a.q0.e1.q.a.e.a.d(i3)));
                if (c.a.q0.e1.q.a.e.a.g(i3) == 0 || this.a.f12509c.getCurrentItem() <= c.a.q0.e1.q.a.e.a.g(i3) - 1) {
                    this.a.f12509c.setCurrentItem(this.a.f12509c.getCurrentItem());
                } else {
                    this.a.f12509c.setCurrentItem(this.a.f12509c.getCurrentItem() + 1);
                }
                if (c.a.q0.e1.q.a.e.a.g(i3) == 0 || this.a.f12509c.getCurrentItem() <= c.a.q0.e1.q.a.e.a.g(i3) - 1) {
                    this.a.f12510d.setAdapter(new c.a.q0.e1.q.a.a.a(c.a.q0.e1.q.a.e.a.b(c.a.q0.e1.q.a.e.a.h(i3, this.a.f12509c.getCurrentItem() + 1))));
                    h2 = c.a.q0.e1.q.a.e.a.h(i3, this.a.f12509c.getCurrentItem() + 1);
                } else if (this.a.f12509c.getCurrentItem() == c.a.q0.e1.q.a.e.a.g(i3) + 1) {
                    this.a.f12510d.setAdapter(new c.a.q0.e1.q.a.a.a(c.a.q0.e1.q.a.e.a.b(c.a.q0.e1.q.a.e.a.f(i3))));
                    h2 = c.a.q0.e1.q.a.e.a.f(i3);
                } else {
                    this.a.f12510d.setAdapter(new c.a.q0.e1.q.a.a.a(c.a.q0.e1.q.a.e.a.b(c.a.q0.e1.q.a.e.a.h(i3, this.a.f12509c.getCurrentItem()))));
                    h2 = c.a.q0.e1.q.a.e.a.h(i3, this.a.f12509c.getCurrentItem());
                }
                int i4 = h2 - 1;
                if (this.a.f12510d.getCurrentItem() > i4) {
                    this.a.f12510d.setCurrentItem(i4);
                }
                if (this.a.x != null) {
                    this.a.x.a();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements c.a.q0.e1.q.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.q0.e1.q.b.c.b
        public void onItemSelected(int i2) {
            int h2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                int currentItem = this.a.f12508b.getCurrentItem() + this.a.f12516j;
                if (c.a.q0.e1.q.a.e.a.g(currentItem) == 0 || i2 <= c.a.q0.e1.q.a.e.a.g(currentItem) - 1) {
                    int i3 = i2 + 1;
                    this.a.f12510d.setAdapter(new c.a.q0.e1.q.a.a.a(c.a.q0.e1.q.a.e.a.b(c.a.q0.e1.q.a.e.a.h(currentItem, i3))));
                    h2 = c.a.q0.e1.q.a.e.a.h(currentItem, i3);
                } else if (this.a.f12509c.getCurrentItem() == c.a.q0.e1.q.a.e.a.g(currentItem) + 1) {
                    this.a.f12510d.setAdapter(new c.a.q0.e1.q.a.a.a(c.a.q0.e1.q.a.e.a.b(c.a.q0.e1.q.a.e.a.f(currentItem))));
                    h2 = c.a.q0.e1.q.a.e.a.f(currentItem);
                } else {
                    this.a.f12510d.setAdapter(new c.a.q0.e1.q.a.a.a(c.a.q0.e1.q.a.e.a.b(c.a.q0.e1.q.a.e.a.h(currentItem, i2))));
                    h2 = c.a.q0.e1.q.a.e.a.h(currentItem, i2);
                }
                int i4 = h2 - 1;
                if (this.a.f12510d.getCurrentItem() > i4) {
                    this.a.f12510d.setCurrentItem(i4);
                }
                if (this.a.x != null) {
                    this.a.x.a();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements c.a.q0.e1.q.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f12517b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f12518c;

        public c(d dVar, List list, List list2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, list, list2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12518c = dVar;
            this.a = list;
            this.f12517b = list2;
        }

        @Override // c.a.q0.e1.q.b.c.b
        public void onItemSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                int i3 = i2 + this.f12518c.f12516j;
                this.f12518c.p = i3;
                int currentItem = this.f12518c.f12509c.getCurrentItem();
                if (this.f12518c.f12516j == this.f12518c.k) {
                    this.f12518c.f12509c.setAdapter(new c.a.q0.e1.q.a.a.b(this.f12518c.l, this.f12518c.m));
                    if (currentItem > this.f12518c.f12509c.getAdapter().a() - 1) {
                        currentItem = this.f12518c.f12509c.getAdapter().a() - 1;
                        this.f12518c.f12509c.setCurrentItem(currentItem);
                    }
                    int i4 = currentItem + this.f12518c.l;
                    if (this.f12518c.l != this.f12518c.m) {
                        if (i4 != this.f12518c.l) {
                            if (i4 != this.f12518c.m) {
                                this.f12518c.F(i3, i4, 1, 31, this.a, this.f12517b);
                            } else {
                                d dVar = this.f12518c;
                                dVar.F(i3, i4, 1, dVar.o, this.a, this.f12517b);
                            }
                        } else {
                            d dVar2 = this.f12518c;
                            dVar2.F(i3, i4, dVar2.n, 31, this.a, this.f12517b);
                        }
                    } else {
                        d dVar3 = this.f12518c;
                        dVar3.F(i3, i4, dVar3.n, this.f12518c.o, this.a, this.f12517b);
                    }
                } else if (i3 == this.f12518c.f12516j) {
                    this.f12518c.f12509c.setAdapter(new c.a.q0.e1.q.a.a.b(this.f12518c.l, 12));
                    if (currentItem > this.f12518c.f12509c.getAdapter().a() - 1) {
                        currentItem = this.f12518c.f12509c.getAdapter().a() - 1;
                        this.f12518c.f12509c.setCurrentItem(currentItem);
                    }
                    int i5 = currentItem + this.f12518c.l;
                    if (i5 != this.f12518c.l) {
                        this.f12518c.F(i3, i5, 1, 31, this.a, this.f12517b);
                    } else {
                        d dVar4 = this.f12518c;
                        dVar4.F(i3, i5, dVar4.n, 31, this.a, this.f12517b);
                    }
                } else if (i3 == this.f12518c.k) {
                    this.f12518c.f12509c.setAdapter(new c.a.q0.e1.q.a.a.b(1, this.f12518c.m));
                    if (currentItem > this.f12518c.f12509c.getAdapter().a() - 1) {
                        currentItem = this.f12518c.f12509c.getAdapter().a() - 1;
                        this.f12518c.f12509c.setCurrentItem(currentItem);
                    }
                    int i6 = 1 + currentItem;
                    if (i6 != this.f12518c.m) {
                        this.f12518c.F(i3, i6, 1, 31, this.a, this.f12517b);
                    } else {
                        d dVar5 = this.f12518c;
                        dVar5.F(i3, i6, 1, dVar5.o, this.a, this.f12517b);
                    }
                } else {
                    this.f12518c.f12509c.setAdapter(new c.a.q0.e1.q.a.a.b(1, 12));
                    d dVar6 = this.f12518c;
                    dVar6.F(i3, 1 + dVar6.f12509c.getCurrentItem(), 1, 31, this.a, this.f12517b);
                }
                if (this.f12518c.x != null) {
                    this.f12518c.x.a();
                }
            }
        }
    }

    /* renamed from: c.a.q0.e1.q.a.f.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0838d implements c.a.q0.e1.q.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f12519b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f12520c;

        public C0838d(d dVar, List list, List list2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, list, list2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12520c = dVar;
            this.a = list;
            this.f12519b = list2;
        }

        @Override // c.a.q0.e1.q.b.c.b
        public void onItemSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                int i3 = i2 + 1;
                if (this.f12520c.f12516j == this.f12520c.k) {
                    int i4 = (i3 + this.f12520c.l) - 1;
                    if (this.f12520c.l != this.f12520c.m) {
                        if (this.f12520c.l != i4) {
                            if (this.f12520c.m == i4) {
                                d dVar = this.f12520c;
                                dVar.F(dVar.p, i4, 1, this.f12520c.o, this.a, this.f12519b);
                            } else {
                                d dVar2 = this.f12520c;
                                dVar2.F(dVar2.p, i4, 1, 31, this.a, this.f12519b);
                            }
                        } else {
                            d dVar3 = this.f12520c;
                            dVar3.F(dVar3.p, i4, this.f12520c.n, 31, this.a, this.f12519b);
                        }
                    } else {
                        d dVar4 = this.f12520c;
                        dVar4.F(dVar4.p, i4, this.f12520c.n, this.f12520c.o, this.a, this.f12519b);
                    }
                } else if (this.f12520c.p == this.f12520c.f12516j) {
                    int i5 = (i3 + this.f12520c.l) - 1;
                    if (i5 == this.f12520c.l) {
                        d dVar5 = this.f12520c;
                        dVar5.F(dVar5.p, i5, this.f12520c.n, 31, this.a, this.f12519b);
                    } else {
                        d dVar6 = this.f12520c;
                        dVar6.F(dVar6.p, i5, 1, 31, this.a, this.f12519b);
                    }
                } else if (this.f12520c.p == this.f12520c.k) {
                    if (i3 == this.f12520c.m) {
                        d dVar7 = this.f12520c;
                        dVar7.F(dVar7.p, this.f12520c.f12509c.getCurrentItem() + 1, 1, this.f12520c.o, this.a, this.f12519b);
                    } else {
                        d dVar8 = this.f12520c;
                        dVar8.F(dVar8.p, this.f12520c.f12509c.getCurrentItem() + 1, 1, 31, this.a, this.f12519b);
                    }
                } else {
                    d dVar9 = this.f12520c;
                    dVar9.F(dVar9.p, i3, 1, 31, this.a, this.f12519b);
                }
                if (this.f12520c.x != null) {
                    this.f12520c.x.a();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements c.a.q0.e1.q.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.q0.e1.q.b.c.b
        public void onItemSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.a.x.a();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1600119323, "Lc/a/q0/e1/q/a/f/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1600119323, "Lc/a/q0/e1/q/a/f/d;");
                return;
            }
        }
        y = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public d(View view, boolean[] zArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, zArr, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f12516j = 1900;
        this.k = 2100;
        this.l = 1;
        this.m = 12;
        this.n = 1;
        this.o = 31;
        this.w = false;
        this.a = view;
        this.f12515i = zArr;
        this.f12514h = i2;
        this.q = i3;
        O(view);
    }

    public void A(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
            this.u = f2;
            z();
        }
    }

    public final void B(int i2, int i3, int i4, boolean z, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            WheelView wheelView = (WheelView) this.a.findViewById(R.id.year);
            this.f12508b = wheelView;
            wheelView.setAdapter(new c.a.q0.e1.q.a.a.a(c.a.q0.e1.q.a.e.a.e(this.f12516j, this.k)));
            this.f12508b.setLabel("");
            this.f12508b.setCurrentItem(i2 - this.f12516j);
            this.f12508b.setGravity(this.f12514h);
            WheelView wheelView2 = (WheelView) this.a.findViewById(R.id.month);
            this.f12509c = wheelView2;
            wheelView2.setAdapter(new c.a.q0.e1.q.a.a.a(c.a.q0.e1.q.a.e.a.d(i2)));
            this.f12509c.setLabel("");
            int g2 = c.a.q0.e1.q.a.e.a.g(i2);
            if (g2 != 0 && (i3 > g2 - 1 || z)) {
                this.f12509c.setCurrentItem(i3 + 1);
            } else {
                this.f12509c.setCurrentItem(i3);
            }
            this.f12509c.setGravity(this.f12514h);
            this.f12510d = (WheelView) this.a.findViewById(R.id.day);
            if (c.a.q0.e1.q.a.e.a.g(i2) == 0) {
                this.f12510d.setAdapter(new c.a.q0.e1.q.a.a.a(c.a.q0.e1.q.a.e.a.b(c.a.q0.e1.q.a.e.a.h(i2, i3))));
            } else {
                this.f12510d.setAdapter(new c.a.q0.e1.q.a.a.a(c.a.q0.e1.q.a.e.a.b(c.a.q0.e1.q.a.e.a.f(i2))));
            }
            this.f12510d.setLabel("");
            this.f12510d.setCurrentItem(i4 - 1);
            this.f12510d.setGravity(this.f12514h);
            WheelView wheelView3 = (WheelView) this.a.findViewById(R.id.hour);
            this.f12511e = wheelView3;
            wheelView3.setAdapter(new c.a.q0.e1.q.a.a.b(0, 23));
            this.f12511e.setCurrentItem(i5);
            this.f12511e.setGravity(this.f12514h);
            WheelView wheelView4 = (WheelView) this.a.findViewById(R.id.min);
            this.f12512f = wheelView4;
            wheelView4.setAdapter(new c.a.q0.e1.q.a.a.b(0, 59));
            this.f12512f.setCurrentItem(i6);
            this.f12512f.setGravity(this.f12514h);
            WheelView wheelView5 = (WheelView) this.a.findViewById(R.id.second);
            this.f12513g = wheelView5;
            wheelView5.setAdapter(new c.a.q0.e1.q.a.a.b(0, 59));
            this.f12513g.setCurrentItem(i6);
            this.f12513g.setGravity(this.f12514h);
            this.f12508b.setOnItemSelectedListener(new a(this));
            this.f12509c.setOnItemSelectedListener(new b(this));
            q(this.f12510d);
            q(this.f12511e);
            q(this.f12512f);
            q(this.f12513g);
            boolean[] zArr = this.f12515i;
            if (zArr.length == 6) {
                this.f12508b.setVisibility(zArr[0] ? 0 : 8);
                this.f12509c.setVisibility(this.f12515i[1] ? 0 : 8);
                this.f12510d.setVisibility(this.f12515i[2] ? 0 : 8);
                this.f12511e.setVisibility(this.f12515i[3] ? 0 : 8);
                this.f12512f.setVisibility(this.f12515i[4] ? 0 : 8);
                this.f12513g.setVisibility(this.f12515i[5] ? 0 : 8);
                r();
                return;
            }
            throw new RuntimeException("type[] length is not 6");
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.w = z;
        }
    }

    public void D(int i2, int i3, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            if (this.w) {
                int[] d2 = c.a.q0.e1.q.a.e.b.d(i2, i3 + 1, i4);
                B(d2[0], d2[1] - 1, d2[2], d2[3] == 1, i5, i6, i7);
                return;
            }
            H(i2, i3, i4, i5, i6, i7);
        }
    }

    public void E(Calendar calendar, Calendar calendar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, calendar, calendar2) == null) {
            if (calendar == null && calendar2 != null) {
                int i2 = calendar2.get(1);
                int i3 = calendar2.get(2) + 1;
                int i4 = calendar2.get(5);
                int i5 = this.f12516j;
                if (i2 > i5) {
                    this.k = i2;
                    this.m = i3;
                    this.o = i4;
                } else if (i2 == i5) {
                    int i6 = this.l;
                    if (i3 > i6) {
                        this.k = i2;
                        this.m = i3;
                        this.o = i4;
                    } else if (i3 != i6 || i4 <= this.n) {
                    } else {
                        this.k = i2;
                        this.m = i3;
                        this.o = i4;
                    }
                }
            } else if (calendar == null || calendar2 != null) {
                if (calendar == null || calendar2 == null) {
                    return;
                }
                this.f12516j = calendar.get(1);
                this.k = calendar2.get(1);
                this.l = calendar.get(2) + 1;
                this.m = calendar2.get(2) + 1;
                this.n = calendar.get(5);
                this.o = calendar2.get(5);
            } else {
                int i7 = calendar.get(1);
                int i8 = calendar.get(2) + 1;
                int i9 = calendar.get(5);
                int i10 = this.k;
                if (i7 < i10) {
                    this.l = i8;
                    this.n = i9;
                    this.f12516j = i7;
                } else if (i7 == i10) {
                    int i11 = this.m;
                    if (i8 < i11) {
                        this.l = i8;
                        this.n = i9;
                        this.f12516j = i7;
                    } else if (i8 != i11 || i9 >= this.o) {
                    } else {
                        this.l = i8;
                        this.n = i9;
                        this.f12516j = i7;
                    }
                }
            }
        }
    }

    public final void F(int i2, int i3, int i4, int i5, List<String> list, List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), list, list2}) == null) {
            int currentItem = this.f12510d.getCurrentItem();
            if (list.contains(String.valueOf(i3))) {
                if (i5 > 31) {
                    i5 = 31;
                }
                this.f12510d.setAdapter(new c.a.q0.e1.q.a.a.b(i4, i5));
            } else if (list2.contains(String.valueOf(i3))) {
                if (i5 > 30) {
                    i5 = 30;
                }
                this.f12510d.setAdapter(new c.a.q0.e1.q.a.a.b(i4, i5));
            } else if ((i2 % 4 == 0 && i2 % 100 != 0) || i2 % 400 == 0) {
                if (i5 > 29) {
                    i5 = 29;
                }
                this.f12510d.setAdapter(new c.a.q0.e1.q.a.a.b(i4, i5));
            } else {
                if (i5 > 28) {
                    i5 = 28;
                }
                this.f12510d.setAdapter(new c.a.q0.e1.q.a.a.b(i4, i5));
            }
            if (currentItem > this.f12510d.getAdapter().a() - 1) {
                this.f12510d.setCurrentItem(this.f12510d.getAdapter().a() - 1);
            }
        }
    }

    public void G(c.a.q0.e1.q.a.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.x = bVar;
        }
    }

    public final void H(int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8;
        int i9;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            List asList = Arrays.asList("1", "3", "5", "7", "8", "10", "12");
            List asList2 = Arrays.asList("4", "6", "9", "11");
            this.p = i2;
            WheelView wheelView = (WheelView) this.a.findViewById(R.id.year);
            this.f12508b = wheelView;
            wheelView.setAdapter(new c.a.q0.e1.q.a.a.b(this.f12516j, this.k));
            this.f12508b.setCurrentItem(i2 - this.f12516j);
            this.f12508b.setGravity(this.f12514h);
            WheelView wheelView2 = (WheelView) this.a.findViewById(R.id.month);
            this.f12509c = wheelView2;
            int i10 = this.f12516j;
            int i11 = this.k;
            if (i10 == i11) {
                wheelView2.setAdapter(new c.a.q0.e1.q.a.a.b(this.l, this.m));
                this.f12509c.setCurrentItem((i3 + 1) - this.l);
            } else if (i2 == i10) {
                wheelView2.setAdapter(new c.a.q0.e1.q.a.a.b(this.l, 12));
                this.f12509c.setCurrentItem((i3 + 1) - this.l);
            } else if (i2 == i11) {
                wheelView2.setAdapter(new c.a.q0.e1.q.a.a.b(1, this.m));
                this.f12509c.setCurrentItem(i3);
            } else {
                wheelView2.setAdapter(new c.a.q0.e1.q.a.a.b(1, 12));
                this.f12509c.setCurrentItem(i3);
            }
            this.f12509c.setGravity(this.f12514h);
            this.f12510d = (WheelView) this.a.findViewById(R.id.day);
            if (this.f12516j == this.k && this.l == this.m) {
                int i12 = i3 + 1;
                if (asList.contains(String.valueOf(i12))) {
                    if (this.o > 31) {
                        this.o = 31;
                    }
                    this.f12510d.setAdapter(new c.a.q0.e1.q.a.a.b(this.n, this.o));
                } else if (asList2.contains(String.valueOf(i12))) {
                    if (this.o > 30) {
                        this.o = 30;
                    }
                    this.f12510d.setAdapter(new c.a.q0.e1.q.a.a.b(this.n, this.o));
                } else if ((i2 % 4 == 0 && i2 % 100 != 0) || i2 % 400 == 0) {
                    if (this.o > 29) {
                        this.o = 29;
                    }
                    this.f12510d.setAdapter(new c.a.q0.e1.q.a.a.b(this.n, this.o));
                } else {
                    if (this.o > 28) {
                        this.o = 28;
                    }
                    this.f12510d.setAdapter(new c.a.q0.e1.q.a.a.b(this.n, this.o));
                }
                this.f12510d.setCurrentItem(i4 - this.n);
            } else if (i2 == this.f12516j && (i9 = i3 + 1) == this.l) {
                if (asList.contains(String.valueOf(i9))) {
                    this.f12510d.setAdapter(new c.a.q0.e1.q.a.a.b(this.n, 31));
                } else if (asList2.contains(String.valueOf(i9))) {
                    this.f12510d.setAdapter(new c.a.q0.e1.q.a.a.b(this.n, 30));
                } else if ((i2 % 4 == 0 && i2 % 100 != 0) || i2 % 400 == 0) {
                    this.f12510d.setAdapter(new c.a.q0.e1.q.a.a.b(this.n, 29));
                } else {
                    this.f12510d.setAdapter(new c.a.q0.e1.q.a.a.b(this.n, 28));
                }
                this.f12510d.setCurrentItem(i4 - this.n);
            } else if (i2 == this.k && (i8 = i3 + 1) == this.m) {
                if (asList.contains(String.valueOf(i8))) {
                    if (this.o > 31) {
                        this.o = 31;
                    }
                    this.f12510d.setAdapter(new c.a.q0.e1.q.a.a.b(1, this.o));
                } else if (asList2.contains(String.valueOf(i8))) {
                    if (this.o > 30) {
                        this.o = 30;
                    }
                    this.f12510d.setAdapter(new c.a.q0.e1.q.a.a.b(1, this.o));
                } else if ((i2 % 4 == 0 && i2 % 100 != 0) || i2 % 400 == 0) {
                    if (this.o > 29) {
                        this.o = 29;
                    }
                    this.f12510d.setAdapter(new c.a.q0.e1.q.a.a.b(1, this.o));
                } else {
                    if (this.o > 28) {
                        this.o = 28;
                    }
                    this.f12510d.setAdapter(new c.a.q0.e1.q.a.a.b(1, this.o));
                }
                this.f12510d.setCurrentItem(i4 - 1);
            } else {
                int i13 = i3 + 1;
                if (asList.contains(String.valueOf(i13))) {
                    this.f12510d.setAdapter(new c.a.q0.e1.q.a.a.b(1, 31));
                } else if (asList2.contains(String.valueOf(i13))) {
                    this.f12510d.setAdapter(new c.a.q0.e1.q.a.a.b(1, 30));
                } else if ((i2 % 4 == 0 && i2 % 100 != 0) || i2 % 400 == 0) {
                    this.f12510d.setAdapter(new c.a.q0.e1.q.a.a.b(1, 29));
                } else {
                    this.f12510d.setAdapter(new c.a.q0.e1.q.a.a.b(1, 28));
                }
                this.f12510d.setCurrentItem(i4 - 1);
            }
            this.f12510d.setGravity(this.f12514h);
            WheelView wheelView3 = (WheelView) this.a.findViewById(R.id.hour);
            this.f12511e = wheelView3;
            wheelView3.setAdapter(new c.a.q0.e1.q.a.a.b(0, 23));
            this.f12511e.setCurrentItem(i5);
            this.f12511e.setGravity(this.f12514h);
            WheelView wheelView4 = (WheelView) this.a.findViewById(R.id.min);
            this.f12512f = wheelView4;
            wheelView4.setAdapter(new c.a.q0.e1.q.a.a.b(0, 59));
            this.f12512f.setCurrentItem(i6);
            this.f12512f.setGravity(this.f12514h);
            WheelView wheelView5 = (WheelView) this.a.findViewById(R.id.second);
            this.f12513g = wheelView5;
            wheelView5.setAdapter(new c.a.q0.e1.q.a.a.b(0, 59));
            this.f12513g.setCurrentItem(i7);
            this.f12513g.setGravity(this.f12514h);
            this.f12508b.setOnItemSelectedListener(new c(this, asList, asList2));
            this.f12509c.setOnItemSelectedListener(new C0838d(this, asList, asList2));
            q(this.f12510d);
            q(this.f12511e);
            q(this.f12512f);
            q(this.f12513g);
            boolean[] zArr = this.f12515i;
            if (zArr.length == 6) {
                this.f12508b.setVisibility(zArr[0] ? 0 : 8);
                this.f12509c.setVisibility(this.f12515i[1] ? 0 : 8);
                this.f12510d.setVisibility(this.f12515i[2] ? 0 : 8);
                this.f12511e.setVisibility(this.f12515i[3] ? 0 : 8);
                this.f12512f.setVisibility(this.f12515i[4] ? 0 : 8);
                this.f12513g.setVisibility(this.f12515i[5] ? 0 : 8);
                r();
                return;
            }
            throw new IllegalArgumentException("type[] length is not 6");
        }
    }

    public void I(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f12516j = i2;
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f12510d.setTextColorCenter(this.s);
            this.f12509c.setTextColorCenter(this.s);
            this.f12508b.setTextColorCenter(this.s);
            this.f12511e.setTextColorCenter(this.s);
            this.f12512f.setTextColorCenter(this.s);
            this.f12513g.setTextColorCenter(this.s);
        }
    }

    public void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.s = i2;
            J();
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f12510d.setTextColorOut(this.r);
            this.f12509c.setTextColorOut(this.r);
            this.f12508b.setTextColorOut(this.r);
            this.f12511e.setTextColorOut(this.r);
            this.f12512f.setTextColorOut(this.r);
            this.f12513g.setTextColorOut(this.r);
        }
    }

    public void M(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.r = i2;
            L();
        }
    }

    public void N(int i2, int i3, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            this.f12510d.setTextXOffset(i2);
            this.f12509c.setTextXOffset(i3);
            this.f12508b.setTextXOffset(i4);
            this.f12511e.setTextXOffset(i5);
            this.f12512f.setTextXOffset(i6);
            this.f12513g.setTextXOffset(i7);
        }
    }

    public void O(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view) == null) {
            this.a = view;
        }
    }

    public final String n() {
        InterceptResult invokeV;
        int currentItem;
        boolean z;
        int currentItem2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            StringBuilder sb = new StringBuilder();
            int currentItem3 = this.f12508b.getCurrentItem() + this.f12516j;
            if (c.a.q0.e1.q.a.e.a.g(currentItem3) == 0) {
                currentItem2 = this.f12509c.getCurrentItem();
            } else if ((this.f12509c.getCurrentItem() + 1) - c.a.q0.e1.q.a.e.a.g(currentItem3) <= 0) {
                currentItem2 = this.f12509c.getCurrentItem();
            } else if ((this.f12509c.getCurrentItem() + 1) - c.a.q0.e1.q.a.e.a.g(currentItem3) == 1) {
                currentItem = this.f12509c.getCurrentItem();
                z = true;
                int[] b2 = c.a.q0.e1.q.a.e.b.b(currentItem3, currentItem, this.f12510d.getCurrentItem() + 1, z);
                sb.append(b2[0]);
                sb.append("-");
                sb.append(b2[1]);
                sb.append("-");
                sb.append(b2[2]);
                sb.append(" ");
                sb.append(this.f12511e.getCurrentItem());
                sb.append(":");
                sb.append(this.f12512f.getCurrentItem());
                sb.append(":");
                sb.append(this.f12513g.getCurrentItem());
                return sb.toString();
            } else {
                currentItem = this.f12509c.getCurrentItem();
                z = false;
                int[] b22 = c.a.q0.e1.q.a.e.b.b(currentItem3, currentItem, this.f12510d.getCurrentItem() + 1, z);
                sb.append(b22[0]);
                sb.append("-");
                sb.append(b22[1]);
                sb.append("-");
                sb.append(b22[2]);
                sb.append(" ");
                sb.append(this.f12511e.getCurrentItem());
                sb.append(":");
                sb.append(this.f12512f.getCurrentItem());
                sb.append(":");
                sb.append(this.f12513g.getCurrentItem());
                return sb.toString();
            }
            currentItem = currentItem2 + 1;
            z = false;
            int[] b222 = c.a.q0.e1.q.a.e.b.b(currentItem3, currentItem, this.f12510d.getCurrentItem() + 1, z);
            sb.append(b222[0]);
            sb.append("-");
            sb.append(b222[1]);
            sb.append("-");
            sb.append(b222[2]);
            sb.append(" ");
            sb.append(this.f12511e.getCurrentItem());
            sb.append(":");
            sb.append(this.f12512f.getCurrentItem());
            sb.append(":");
            sb.append(this.f12513g.getCurrentItem());
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.w) {
                return n();
            }
            StringBuilder sb = new StringBuilder();
            if (this.p == this.f12516j) {
                int currentItem = this.f12509c.getCurrentItem();
                int i2 = this.l;
                if (currentItem + i2 == i2) {
                    sb.append(this.f12508b.getCurrentItem() + this.f12516j);
                    sb.append("-");
                    sb.append(this.f12509c.getCurrentItem() + this.l);
                    sb.append("-");
                    sb.append(this.f12510d.getCurrentItem() + this.n);
                    sb.append(" ");
                    sb.append(this.f12511e.getCurrentItem());
                    sb.append(":");
                    sb.append(this.f12512f.getCurrentItem());
                    sb.append(":");
                    sb.append(this.f12513g.getCurrentItem());
                } else {
                    sb.append(this.f12508b.getCurrentItem() + this.f12516j);
                    sb.append("-");
                    sb.append(this.f12509c.getCurrentItem() + this.l);
                    sb.append("-");
                    sb.append(this.f12510d.getCurrentItem() + 1);
                    sb.append(" ");
                    sb.append(this.f12511e.getCurrentItem());
                    sb.append(":");
                    sb.append(this.f12512f.getCurrentItem());
                    sb.append(":");
                    sb.append(this.f12513g.getCurrentItem());
                }
            } else {
                sb.append(this.f12508b.getCurrentItem() + this.f12516j);
                sb.append("-");
                sb.append(this.f12509c.getCurrentItem() + 1);
                sb.append("-");
                sb.append(this.f12510d.getCurrentItem() + 1);
                sb.append(" ");
                sb.append(this.f12511e.getCurrentItem());
                sb.append(":");
                sb.append(this.f12512f.getCurrentItem());
                sb.append(":");
                sb.append(this.f12513g.getCurrentItem());
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f12510d.isCenterLabel(z);
            this.f12509c.isCenterLabel(z);
            this.f12508b.isCenterLabel(z);
            this.f12511e.isCenterLabel(z);
            this.f12512f.isCenterLabel(z);
            this.f12513g.isCenterLabel(z);
        }
    }

    public final void q(WheelView wheelView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, wheelView) == null) || this.x == null) {
            return;
        }
        wheelView.setOnItemSelectedListener(new e(this));
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f12510d.setTextSize(this.q);
            this.f12509c.setTextSize(this.q);
            this.f12508b.setTextSize(this.q);
            this.f12511e.setTextSize(this.q);
            this.f12512f.setTextSize(this.q);
            this.f12513g.setTextSize(this.q);
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.f12508b.setCyclic(z);
            this.f12509c.setCyclic(z);
            this.f12510d.setCyclic(z);
            this.f12511e.setCyclic(z);
            this.f12512f.setCyclic(z);
            this.f12513g.setCyclic(z);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f12510d.setDividerColor(this.t);
            this.f12509c.setDividerColor(this.t);
            this.f12508b.setDividerColor(this.t);
            this.f12511e.setDividerColor(this.t);
            this.f12512f.setDividerColor(this.t);
            this.f12513g.setDividerColor(this.t);
        }
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.t = i2;
            t();
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.f12510d.setDividerType(this.v);
            this.f12509c.setDividerType(this.v);
            this.f12508b.setDividerType(this.v);
            this.f12511e.setDividerType(this.v);
            this.f12512f.setDividerType(this.v);
            this.f12513g.setDividerType(this.v);
        }
    }

    public void w(WheelView.DividerType dividerType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, dividerType) == null) {
            this.v = dividerType;
            v();
        }
    }

    public void x(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.k = i2;
        }
    }

    public void y(String str, String str2, String str3, String str4, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{str, str2, str3, str4, str5, str6}) == null) || this.w) {
            return;
        }
        if (str != null) {
            this.f12508b.setLabel(str);
        } else {
            this.f12508b.setLabel(this.a.getContext().getString(R.string.pickerview_year));
        }
        if (str2 != null) {
            this.f12509c.setLabel(str2);
        } else {
            this.f12509c.setLabel(this.a.getContext().getString(R.string.pickerview_month));
        }
        if (str3 != null) {
            this.f12510d.setLabel(str3);
        } else {
            this.f12510d.setLabel(this.a.getContext().getString(R.string.pickerview_day));
        }
        if (str4 != null) {
            this.f12511e.setLabel(str4);
        } else {
            this.f12511e.setLabel(this.a.getContext().getString(R.string.pickerview_hours));
        }
        if (str5 != null) {
            this.f12512f.setLabel(str5);
        } else {
            this.f12512f.setLabel(this.a.getContext().getString(R.string.pickerview_minutes));
        }
        if (str6 != null) {
            this.f12513g.setLabel(str6);
        } else {
            this.f12513g.setLabel(this.a.getContext().getString(R.string.pickerview_seconds));
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.f12510d.setLineSpacingMultiplier(this.u);
            this.f12509c.setLineSpacingMultiplier(this.u);
            this.f12508b.setLineSpacingMultiplier(this.u);
            this.f12511e.setLineSpacingMultiplier(this.u);
            this.f12512f.setLineSpacingMultiplier(this.u);
            this.f12513g.setLineSpacingMultiplier(this.u);
        }
    }
}
