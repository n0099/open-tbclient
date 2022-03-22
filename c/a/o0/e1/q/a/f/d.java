package c.a.o0.e1.q.a.f;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.auth.FeatureCodes;
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
    public WheelView f10234b;

    /* renamed from: c  reason: collision with root package name */
    public WheelView f10235c;

    /* renamed from: d  reason: collision with root package name */
    public WheelView f10236d;

    /* renamed from: e  reason: collision with root package name */
    public WheelView f10237e;

    /* renamed from: f  reason: collision with root package name */
    public WheelView f10238f;

    /* renamed from: g  reason: collision with root package name */
    public WheelView f10239g;

    /* renamed from: h  reason: collision with root package name */
    public int f10240h;
    public boolean[] i;
    public int j;
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
    public c.a.o0.e1.q.a.d.b x;

    /* loaded from: classes2.dex */
    public class a implements c.a.o0.e1.q.b.c.b {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.o0.e1.q.b.c.b
        public void onItemSelected(int i) {
            int h2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                int i2 = i + this.a.j;
                this.a.f10235c.setAdapter(new c.a.o0.e1.q.a.a.a(c.a.o0.e1.q.a.e.a.d(i2)));
                if (c.a.o0.e1.q.a.e.a.g(i2) == 0 || this.a.f10235c.getCurrentItem() <= c.a.o0.e1.q.a.e.a.g(i2) - 1) {
                    this.a.f10235c.setCurrentItem(this.a.f10235c.getCurrentItem());
                } else {
                    this.a.f10235c.setCurrentItem(this.a.f10235c.getCurrentItem() + 1);
                }
                if (c.a.o0.e1.q.a.e.a.g(i2) == 0 || this.a.f10235c.getCurrentItem() <= c.a.o0.e1.q.a.e.a.g(i2) - 1) {
                    this.a.f10236d.setAdapter(new c.a.o0.e1.q.a.a.a(c.a.o0.e1.q.a.e.a.b(c.a.o0.e1.q.a.e.a.h(i2, this.a.f10235c.getCurrentItem() + 1))));
                    h2 = c.a.o0.e1.q.a.e.a.h(i2, this.a.f10235c.getCurrentItem() + 1);
                } else if (this.a.f10235c.getCurrentItem() == c.a.o0.e1.q.a.e.a.g(i2) + 1) {
                    this.a.f10236d.setAdapter(new c.a.o0.e1.q.a.a.a(c.a.o0.e1.q.a.e.a.b(c.a.o0.e1.q.a.e.a.f(i2))));
                    h2 = c.a.o0.e1.q.a.e.a.f(i2);
                } else {
                    this.a.f10236d.setAdapter(new c.a.o0.e1.q.a.a.a(c.a.o0.e1.q.a.e.a.b(c.a.o0.e1.q.a.e.a.h(i2, this.a.f10235c.getCurrentItem()))));
                    h2 = c.a.o0.e1.q.a.e.a.h(i2, this.a.f10235c.getCurrentItem());
                }
                int i3 = h2 - 1;
                if (this.a.f10236d.getCurrentItem() > i3) {
                    this.a.f10236d.setCurrentItem(i3);
                }
                if (this.a.x != null) {
                    this.a.x.a();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements c.a.o0.e1.q.b.c.b {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.o0.e1.q.b.c.b
        public void onItemSelected(int i) {
            int h2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                int currentItem = this.a.f10234b.getCurrentItem() + this.a.j;
                if (c.a.o0.e1.q.a.e.a.g(currentItem) == 0 || i <= c.a.o0.e1.q.a.e.a.g(currentItem) - 1) {
                    int i2 = i + 1;
                    this.a.f10236d.setAdapter(new c.a.o0.e1.q.a.a.a(c.a.o0.e1.q.a.e.a.b(c.a.o0.e1.q.a.e.a.h(currentItem, i2))));
                    h2 = c.a.o0.e1.q.a.e.a.h(currentItem, i2);
                } else if (this.a.f10235c.getCurrentItem() == c.a.o0.e1.q.a.e.a.g(currentItem) + 1) {
                    this.a.f10236d.setAdapter(new c.a.o0.e1.q.a.a.a(c.a.o0.e1.q.a.e.a.b(c.a.o0.e1.q.a.e.a.f(currentItem))));
                    h2 = c.a.o0.e1.q.a.e.a.f(currentItem);
                } else {
                    this.a.f10236d.setAdapter(new c.a.o0.e1.q.a.a.a(c.a.o0.e1.q.a.e.a.b(c.a.o0.e1.q.a.e.a.h(currentItem, i))));
                    h2 = c.a.o0.e1.q.a.e.a.h(currentItem, i);
                }
                int i3 = h2 - 1;
                if (this.a.f10236d.getCurrentItem() > i3) {
                    this.a.f10236d.setCurrentItem(i3);
                }
                if (this.a.x != null) {
                    this.a.x.a();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements c.a.o0.e1.q.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f10241b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f10242c;

        public c(d dVar, List list, List list2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, list, list2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10242c = dVar;
            this.a = list;
            this.f10241b = list2;
        }

        @Override // c.a.o0.e1.q.b.c.b
        public void onItemSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                int i2 = i + this.f10242c.j;
                this.f10242c.p = i2;
                int currentItem = this.f10242c.f10235c.getCurrentItem();
                if (this.f10242c.j == this.f10242c.k) {
                    this.f10242c.f10235c.setAdapter(new c.a.o0.e1.q.a.a.b(this.f10242c.l, this.f10242c.m));
                    if (currentItem > this.f10242c.f10235c.getAdapter().a() - 1) {
                        currentItem = this.f10242c.f10235c.getAdapter().a() - 1;
                        this.f10242c.f10235c.setCurrentItem(currentItem);
                    }
                    int i3 = currentItem + this.f10242c.l;
                    if (this.f10242c.l != this.f10242c.m) {
                        if (i3 != this.f10242c.l) {
                            if (i3 != this.f10242c.m) {
                                this.f10242c.F(i2, i3, 1, 31, this.a, this.f10241b);
                            } else {
                                d dVar = this.f10242c;
                                dVar.F(i2, i3, 1, dVar.o, this.a, this.f10241b);
                            }
                        } else {
                            d dVar2 = this.f10242c;
                            dVar2.F(i2, i3, dVar2.n, 31, this.a, this.f10241b);
                        }
                    } else {
                        d dVar3 = this.f10242c;
                        dVar3.F(i2, i3, dVar3.n, this.f10242c.o, this.a, this.f10241b);
                    }
                } else if (i2 == this.f10242c.j) {
                    this.f10242c.f10235c.setAdapter(new c.a.o0.e1.q.a.a.b(this.f10242c.l, 12));
                    if (currentItem > this.f10242c.f10235c.getAdapter().a() - 1) {
                        currentItem = this.f10242c.f10235c.getAdapter().a() - 1;
                        this.f10242c.f10235c.setCurrentItem(currentItem);
                    }
                    int i4 = currentItem + this.f10242c.l;
                    if (i4 != this.f10242c.l) {
                        this.f10242c.F(i2, i4, 1, 31, this.a, this.f10241b);
                    } else {
                        d dVar4 = this.f10242c;
                        dVar4.F(i2, i4, dVar4.n, 31, this.a, this.f10241b);
                    }
                } else if (i2 == this.f10242c.k) {
                    this.f10242c.f10235c.setAdapter(new c.a.o0.e1.q.a.a.b(1, this.f10242c.m));
                    if (currentItem > this.f10242c.f10235c.getAdapter().a() - 1) {
                        currentItem = this.f10242c.f10235c.getAdapter().a() - 1;
                        this.f10242c.f10235c.setCurrentItem(currentItem);
                    }
                    int i5 = 1 + currentItem;
                    if (i5 != this.f10242c.m) {
                        this.f10242c.F(i2, i5, 1, 31, this.a, this.f10241b);
                    } else {
                        d dVar5 = this.f10242c;
                        dVar5.F(i2, i5, 1, dVar5.o, this.a, this.f10241b);
                    }
                } else {
                    this.f10242c.f10235c.setAdapter(new c.a.o0.e1.q.a.a.b(1, 12));
                    d dVar6 = this.f10242c;
                    dVar6.F(i2, 1 + dVar6.f10235c.getCurrentItem(), 1, 31, this.a, this.f10241b);
                }
                if (this.f10242c.x != null) {
                    this.f10242c.x.a();
                }
            }
        }
    }

    /* renamed from: c.a.o0.e1.q.a.f.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0806d implements c.a.o0.e1.q.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f10243b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f10244c;

        public C0806d(d dVar, List list, List list2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, list, list2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10244c = dVar;
            this.a = list;
            this.f10243b = list2;
        }

        @Override // c.a.o0.e1.q.b.c.b
        public void onItemSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                int i2 = i + 1;
                if (this.f10244c.j == this.f10244c.k) {
                    int i3 = (i2 + this.f10244c.l) - 1;
                    if (this.f10244c.l != this.f10244c.m) {
                        if (this.f10244c.l != i3) {
                            if (this.f10244c.m == i3) {
                                d dVar = this.f10244c;
                                dVar.F(dVar.p, i3, 1, this.f10244c.o, this.a, this.f10243b);
                            } else {
                                d dVar2 = this.f10244c;
                                dVar2.F(dVar2.p, i3, 1, 31, this.a, this.f10243b);
                            }
                        } else {
                            d dVar3 = this.f10244c;
                            dVar3.F(dVar3.p, i3, this.f10244c.n, 31, this.a, this.f10243b);
                        }
                    } else {
                        d dVar4 = this.f10244c;
                        dVar4.F(dVar4.p, i3, this.f10244c.n, this.f10244c.o, this.a, this.f10243b);
                    }
                } else if (this.f10244c.p == this.f10244c.j) {
                    int i4 = (i2 + this.f10244c.l) - 1;
                    if (i4 == this.f10244c.l) {
                        d dVar5 = this.f10244c;
                        dVar5.F(dVar5.p, i4, this.f10244c.n, 31, this.a, this.f10243b);
                    } else {
                        d dVar6 = this.f10244c;
                        dVar6.F(dVar6.p, i4, 1, 31, this.a, this.f10243b);
                    }
                } else if (this.f10244c.p == this.f10244c.k) {
                    if (i2 == this.f10244c.m) {
                        d dVar7 = this.f10244c;
                        dVar7.F(dVar7.p, this.f10244c.f10235c.getCurrentItem() + 1, 1, this.f10244c.o, this.a, this.f10243b);
                    } else {
                        d dVar8 = this.f10244c;
                        dVar8.F(dVar8.p, this.f10244c.f10235c.getCurrentItem() + 1, 1, 31, this.a, this.f10243b);
                    }
                } else {
                    d dVar9 = this.f10244c;
                    dVar9.F(dVar9.p, i2, 1, 31, this.a, this.f10243b);
                }
                if (this.f10244c.x != null) {
                    this.f10244c.x.a();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements c.a.o0.e1.q.b.c.b {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.o0.e1.q.b.c.b
        public void onItemSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.x.a();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-589002073, "Lc/a/o0/e1/q/a/f/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-589002073, "Lc/a/o0/e1/q/a/f/d;");
                return;
            }
        }
        y = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public d(View view, boolean[] zArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, zArr, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = FeatureCodes.SKY_SEG;
        this.k = 2100;
        this.l = 1;
        this.m = 12;
        this.n = 1;
        this.o = 31;
        this.w = false;
        this.a = view;
        this.i = zArr;
        this.f10240h = i;
        this.q = i2;
        O(view);
    }

    public void A(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
            this.u = f2;
            z();
        }
    }

    public final void B(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            WheelView wheelView = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f0924b5);
            this.f10234b = wheelView;
            wheelView.setAdapter(new c.a.o0.e1.q.a.a.a(c.a.o0.e1.q.a.e.a.e(this.j, this.k)));
            this.f10234b.setLabel("");
            this.f10234b.setCurrentItem(i - this.j);
            this.f10234b.setGravity(this.f10240h);
            WheelView wheelView2 = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f091430);
            this.f10235c = wheelView2;
            wheelView2.setAdapter(new c.a.o0.e1.q.a.a.a(c.a.o0.e1.q.a.e.a.d(i)));
            this.f10235c.setLabel("");
            int g2 = c.a.o0.e1.q.a.e.a.g(i);
            if (g2 != 0 && (i2 > g2 - 1 || z)) {
                this.f10235c.setCurrentItem(i2 + 1);
            } else {
                this.f10235c.setCurrentItem(i2);
            }
            this.f10235c.setGravity(this.f10240h);
            this.f10236d = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f090759);
            if (c.a.o0.e1.q.a.e.a.g(i) == 0) {
                this.f10236d.setAdapter(new c.a.o0.e1.q.a.a.a(c.a.o0.e1.q.a.e.a.b(c.a.o0.e1.q.a.e.a.h(i, i2))));
            } else {
                this.f10236d.setAdapter(new c.a.o0.e1.q.a.a.a(c.a.o0.e1.q.a.e.a.b(c.a.o0.e1.q.a.e.a.f(i))));
            }
            this.f10236d.setLabel("");
            this.f10236d.setCurrentItem(i3 - 1);
            this.f10236d.setGravity(this.f10240h);
            WheelView wheelView3 = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f090df1);
            this.f10237e = wheelView3;
            wheelView3.setAdapter(new c.a.o0.e1.q.a.a.b(0, 23));
            this.f10237e.setCurrentItem(i4);
            this.f10237e.setGravity(this.f10240h);
            WheelView wheelView4 = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f09141c);
            this.f10238f = wheelView4;
            wheelView4.setAdapter(new c.a.o0.e1.q.a.a.b(0, 59));
            this.f10238f.setCurrentItem(i5);
            this.f10238f.setGravity(this.f10240h);
            WheelView wheelView5 = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f091c53);
            this.f10239g = wheelView5;
            wheelView5.setAdapter(new c.a.o0.e1.q.a.a.b(0, 59));
            this.f10239g.setCurrentItem(i5);
            this.f10239g.setGravity(this.f10240h);
            this.f10234b.setOnItemSelectedListener(new a(this));
            this.f10235c.setOnItemSelectedListener(new b(this));
            q(this.f10236d);
            q(this.f10237e);
            q(this.f10238f);
            q(this.f10239g);
            boolean[] zArr = this.i;
            if (zArr.length == 6) {
                this.f10234b.setVisibility(zArr[0] ? 0 : 8);
                this.f10235c.setVisibility(this.i[1] ? 0 : 8);
                this.f10236d.setVisibility(this.i[2] ? 0 : 8);
                this.f10237e.setVisibility(this.i[3] ? 0 : 8);
                this.f10238f.setVisibility(this.i[4] ? 0 : 8);
                this.f10239g.setVisibility(this.i[5] ? 0 : 8);
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

    public void D(int i, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            if (this.w) {
                int[] d2 = c.a.o0.e1.q.a.e.b.d(i, i2 + 1, i3);
                B(d2[0], d2[1] - 1, d2[2], d2[3] == 1, i4, i5, i6);
                return;
            }
            H(i, i2, i3, i4, i5, i6);
        }
    }

    public void E(Calendar calendar, Calendar calendar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, calendar, calendar2) == null) {
            if (calendar == null && calendar2 != null) {
                int i = calendar2.get(1);
                int i2 = calendar2.get(2) + 1;
                int i3 = calendar2.get(5);
                int i4 = this.j;
                if (i > i4) {
                    this.k = i;
                    this.m = i2;
                    this.o = i3;
                } else if (i == i4) {
                    int i5 = this.l;
                    if (i2 > i5) {
                        this.k = i;
                        this.m = i2;
                        this.o = i3;
                    } else if (i2 != i5 || i3 <= this.n) {
                    } else {
                        this.k = i;
                        this.m = i2;
                        this.o = i3;
                    }
                }
            } else if (calendar == null || calendar2 != null) {
                if (calendar == null || calendar2 == null) {
                    return;
                }
                this.j = calendar.get(1);
                this.k = calendar2.get(1);
                this.l = calendar.get(2) + 1;
                this.m = calendar2.get(2) + 1;
                this.n = calendar.get(5);
                this.o = calendar2.get(5);
            } else {
                int i6 = calendar.get(1);
                int i7 = calendar.get(2) + 1;
                int i8 = calendar.get(5);
                int i9 = this.k;
                if (i6 < i9) {
                    this.l = i7;
                    this.n = i8;
                    this.j = i6;
                } else if (i6 == i9) {
                    int i10 = this.m;
                    if (i7 < i10) {
                        this.l = i7;
                        this.n = i8;
                        this.j = i6;
                    } else if (i7 != i10 || i8 >= this.o) {
                    } else {
                        this.l = i7;
                        this.n = i8;
                        this.j = i6;
                    }
                }
            }
        }
    }

    public final void F(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), list, list2}) == null) {
            int currentItem = this.f10236d.getCurrentItem();
            if (list.contains(String.valueOf(i2))) {
                if (i4 > 31) {
                    i4 = 31;
                }
                this.f10236d.setAdapter(new c.a.o0.e1.q.a.a.b(i3, i4));
            } else if (list2.contains(String.valueOf(i2))) {
                if (i4 > 30) {
                    i4 = 30;
                }
                this.f10236d.setAdapter(new c.a.o0.e1.q.a.a.b(i3, i4));
            } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (i4 > 29) {
                    i4 = 29;
                }
                this.f10236d.setAdapter(new c.a.o0.e1.q.a.a.b(i3, i4));
            } else {
                if (i4 > 28) {
                    i4 = 28;
                }
                this.f10236d.setAdapter(new c.a.o0.e1.q.a.a.b(i3, i4));
            }
            if (currentItem > this.f10236d.getAdapter().a() - 1) {
                this.f10236d.setCurrentItem(this.f10236d.getAdapter().a() - 1);
            }
        }
    }

    public void G(c.a.o0.e1.q.a.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.x = bVar;
        }
    }

    public final void H(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            List asList = Arrays.asList("1", "3", "5", "7", "8", "10", "12");
            List asList2 = Arrays.asList("4", "6", "9", "11");
            this.p = i;
            WheelView wheelView = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f0924b5);
            this.f10234b = wheelView;
            wheelView.setAdapter(new c.a.o0.e1.q.a.a.b(this.j, this.k));
            this.f10234b.setCurrentItem(i - this.j);
            this.f10234b.setGravity(this.f10240h);
            WheelView wheelView2 = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f091430);
            this.f10235c = wheelView2;
            int i9 = this.j;
            int i10 = this.k;
            if (i9 == i10) {
                wheelView2.setAdapter(new c.a.o0.e1.q.a.a.b(this.l, this.m));
                this.f10235c.setCurrentItem((i2 + 1) - this.l);
            } else if (i == i9) {
                wheelView2.setAdapter(new c.a.o0.e1.q.a.a.b(this.l, 12));
                this.f10235c.setCurrentItem((i2 + 1) - this.l);
            } else if (i == i10) {
                wheelView2.setAdapter(new c.a.o0.e1.q.a.a.b(1, this.m));
                this.f10235c.setCurrentItem(i2);
            } else {
                wheelView2.setAdapter(new c.a.o0.e1.q.a.a.b(1, 12));
                this.f10235c.setCurrentItem(i2);
            }
            this.f10235c.setGravity(this.f10240h);
            this.f10236d = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f090759);
            if (this.j == this.k && this.l == this.m) {
                int i11 = i2 + 1;
                if (asList.contains(String.valueOf(i11))) {
                    if (this.o > 31) {
                        this.o = 31;
                    }
                    this.f10236d.setAdapter(new c.a.o0.e1.q.a.a.b(this.n, this.o));
                } else if (asList2.contains(String.valueOf(i11))) {
                    if (this.o > 30) {
                        this.o = 30;
                    }
                    this.f10236d.setAdapter(new c.a.o0.e1.q.a.a.b(this.n, this.o));
                } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                    if (this.o > 29) {
                        this.o = 29;
                    }
                    this.f10236d.setAdapter(new c.a.o0.e1.q.a.a.b(this.n, this.o));
                } else {
                    if (this.o > 28) {
                        this.o = 28;
                    }
                    this.f10236d.setAdapter(new c.a.o0.e1.q.a.a.b(this.n, this.o));
                }
                this.f10236d.setCurrentItem(i3 - this.n);
            } else if (i == this.j && (i8 = i2 + 1) == this.l) {
                if (asList.contains(String.valueOf(i8))) {
                    this.f10236d.setAdapter(new c.a.o0.e1.q.a.a.b(this.n, 31));
                } else if (asList2.contains(String.valueOf(i8))) {
                    this.f10236d.setAdapter(new c.a.o0.e1.q.a.a.b(this.n, 30));
                } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                    this.f10236d.setAdapter(new c.a.o0.e1.q.a.a.b(this.n, 29));
                } else {
                    this.f10236d.setAdapter(new c.a.o0.e1.q.a.a.b(this.n, 28));
                }
                this.f10236d.setCurrentItem(i3 - this.n);
            } else if (i == this.k && (i7 = i2 + 1) == this.m) {
                if (asList.contains(String.valueOf(i7))) {
                    if (this.o > 31) {
                        this.o = 31;
                    }
                    this.f10236d.setAdapter(new c.a.o0.e1.q.a.a.b(1, this.o));
                } else if (asList2.contains(String.valueOf(i7))) {
                    if (this.o > 30) {
                        this.o = 30;
                    }
                    this.f10236d.setAdapter(new c.a.o0.e1.q.a.a.b(1, this.o));
                } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                    if (this.o > 29) {
                        this.o = 29;
                    }
                    this.f10236d.setAdapter(new c.a.o0.e1.q.a.a.b(1, this.o));
                } else {
                    if (this.o > 28) {
                        this.o = 28;
                    }
                    this.f10236d.setAdapter(new c.a.o0.e1.q.a.a.b(1, this.o));
                }
                this.f10236d.setCurrentItem(i3 - 1);
            } else {
                int i12 = i2 + 1;
                if (asList.contains(String.valueOf(i12))) {
                    this.f10236d.setAdapter(new c.a.o0.e1.q.a.a.b(1, 31));
                } else if (asList2.contains(String.valueOf(i12))) {
                    this.f10236d.setAdapter(new c.a.o0.e1.q.a.a.b(1, 30));
                } else if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                    this.f10236d.setAdapter(new c.a.o0.e1.q.a.a.b(1, 29));
                } else {
                    this.f10236d.setAdapter(new c.a.o0.e1.q.a.a.b(1, 28));
                }
                this.f10236d.setCurrentItem(i3 - 1);
            }
            this.f10236d.setGravity(this.f10240h);
            WheelView wheelView3 = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f090df1);
            this.f10237e = wheelView3;
            wheelView3.setAdapter(new c.a.o0.e1.q.a.a.b(0, 23));
            this.f10237e.setCurrentItem(i4);
            this.f10237e.setGravity(this.f10240h);
            WheelView wheelView4 = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f09141c);
            this.f10238f = wheelView4;
            wheelView4.setAdapter(new c.a.o0.e1.q.a.a.b(0, 59));
            this.f10238f.setCurrentItem(i5);
            this.f10238f.setGravity(this.f10240h);
            WheelView wheelView5 = (WheelView) this.a.findViewById(R.id.obfuscated_res_0x7f091c53);
            this.f10239g = wheelView5;
            wheelView5.setAdapter(new c.a.o0.e1.q.a.a.b(0, 59));
            this.f10239g.setCurrentItem(i6);
            this.f10239g.setGravity(this.f10240h);
            this.f10234b.setOnItemSelectedListener(new c(this, asList, asList2));
            this.f10235c.setOnItemSelectedListener(new C0806d(this, asList, asList2));
            q(this.f10236d);
            q(this.f10237e);
            q(this.f10238f);
            q(this.f10239g);
            boolean[] zArr = this.i;
            if (zArr.length == 6) {
                this.f10234b.setVisibility(zArr[0] ? 0 : 8);
                this.f10235c.setVisibility(this.i[1] ? 0 : 8);
                this.f10236d.setVisibility(this.i[2] ? 0 : 8);
                this.f10237e.setVisibility(this.i[3] ? 0 : 8);
                this.f10238f.setVisibility(this.i[4] ? 0 : 8);
                this.f10239g.setVisibility(this.i[5] ? 0 : 8);
                r();
                return;
            }
            throw new IllegalArgumentException("type[] length is not 6");
        }
    }

    public void I(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.j = i;
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f10236d.setTextColorCenter(this.s);
            this.f10235c.setTextColorCenter(this.s);
            this.f10234b.setTextColorCenter(this.s);
            this.f10237e.setTextColorCenter(this.s);
            this.f10238f.setTextColorCenter(this.s);
            this.f10239g.setTextColorCenter(this.s);
        }
    }

    public void K(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.s = i;
            J();
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f10236d.setTextColorOut(this.r);
            this.f10235c.setTextColorOut(this.r);
            this.f10234b.setTextColorOut(this.r);
            this.f10237e.setTextColorOut(this.r);
            this.f10238f.setTextColorOut(this.r);
            this.f10239g.setTextColorOut(this.r);
        }
    }

    public void M(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.r = i;
            L();
        }
    }

    public void N(int i, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            this.f10236d.setTextXOffset(i);
            this.f10235c.setTextXOffset(i2);
            this.f10234b.setTextXOffset(i3);
            this.f10237e.setTextXOffset(i4);
            this.f10238f.setTextXOffset(i5);
            this.f10239g.setTextXOffset(i6);
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
            int currentItem3 = this.f10234b.getCurrentItem() + this.j;
            if (c.a.o0.e1.q.a.e.a.g(currentItem3) == 0) {
                currentItem2 = this.f10235c.getCurrentItem();
            } else if ((this.f10235c.getCurrentItem() + 1) - c.a.o0.e1.q.a.e.a.g(currentItem3) <= 0) {
                currentItem2 = this.f10235c.getCurrentItem();
            } else if ((this.f10235c.getCurrentItem() + 1) - c.a.o0.e1.q.a.e.a.g(currentItem3) == 1) {
                currentItem = this.f10235c.getCurrentItem();
                z = true;
                int[] b2 = c.a.o0.e1.q.a.e.b.b(currentItem3, currentItem, this.f10236d.getCurrentItem() + 1, z);
                sb.append(b2[0]);
                sb.append("-");
                sb.append(b2[1]);
                sb.append("-");
                sb.append(b2[2]);
                sb.append(" ");
                sb.append(this.f10237e.getCurrentItem());
                sb.append(":");
                sb.append(this.f10238f.getCurrentItem());
                sb.append(":");
                sb.append(this.f10239g.getCurrentItem());
                return sb.toString();
            } else {
                currentItem = this.f10235c.getCurrentItem();
                z = false;
                int[] b22 = c.a.o0.e1.q.a.e.b.b(currentItem3, currentItem, this.f10236d.getCurrentItem() + 1, z);
                sb.append(b22[0]);
                sb.append("-");
                sb.append(b22[1]);
                sb.append("-");
                sb.append(b22[2]);
                sb.append(" ");
                sb.append(this.f10237e.getCurrentItem());
                sb.append(":");
                sb.append(this.f10238f.getCurrentItem());
                sb.append(":");
                sb.append(this.f10239g.getCurrentItem());
                return sb.toString();
            }
            currentItem = currentItem2 + 1;
            z = false;
            int[] b222 = c.a.o0.e1.q.a.e.b.b(currentItem3, currentItem, this.f10236d.getCurrentItem() + 1, z);
            sb.append(b222[0]);
            sb.append("-");
            sb.append(b222[1]);
            sb.append("-");
            sb.append(b222[2]);
            sb.append(" ");
            sb.append(this.f10237e.getCurrentItem());
            sb.append(":");
            sb.append(this.f10238f.getCurrentItem());
            sb.append(":");
            sb.append(this.f10239g.getCurrentItem());
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
            if (this.p == this.j) {
                int currentItem = this.f10235c.getCurrentItem();
                int i = this.l;
                if (currentItem + i == i) {
                    sb.append(this.f10234b.getCurrentItem() + this.j);
                    sb.append("-");
                    sb.append(this.f10235c.getCurrentItem() + this.l);
                    sb.append("-");
                    sb.append(this.f10236d.getCurrentItem() + this.n);
                    sb.append(" ");
                    sb.append(this.f10237e.getCurrentItem());
                    sb.append(":");
                    sb.append(this.f10238f.getCurrentItem());
                    sb.append(":");
                    sb.append(this.f10239g.getCurrentItem());
                } else {
                    sb.append(this.f10234b.getCurrentItem() + this.j);
                    sb.append("-");
                    sb.append(this.f10235c.getCurrentItem() + this.l);
                    sb.append("-");
                    sb.append(this.f10236d.getCurrentItem() + 1);
                    sb.append(" ");
                    sb.append(this.f10237e.getCurrentItem());
                    sb.append(":");
                    sb.append(this.f10238f.getCurrentItem());
                    sb.append(":");
                    sb.append(this.f10239g.getCurrentItem());
                }
            } else {
                sb.append(this.f10234b.getCurrentItem() + this.j);
                sb.append("-");
                sb.append(this.f10235c.getCurrentItem() + 1);
                sb.append("-");
                sb.append(this.f10236d.getCurrentItem() + 1);
                sb.append(" ");
                sb.append(this.f10237e.getCurrentItem());
                sb.append(":");
                sb.append(this.f10238f.getCurrentItem());
                sb.append(":");
                sb.append(this.f10239g.getCurrentItem());
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f10236d.h(z);
            this.f10235c.h(z);
            this.f10234b.h(z);
            this.f10237e.h(z);
            this.f10238f.h(z);
            this.f10239g.h(z);
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
            this.f10236d.setTextSize(this.q);
            this.f10235c.setTextSize(this.q);
            this.f10234b.setTextSize(this.q);
            this.f10237e.setTextSize(this.q);
            this.f10238f.setTextSize(this.q);
            this.f10239g.setTextSize(this.q);
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.f10234b.setCyclic(z);
            this.f10235c.setCyclic(z);
            this.f10236d.setCyclic(z);
            this.f10237e.setCyclic(z);
            this.f10238f.setCyclic(z);
            this.f10239g.setCyclic(z);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f10236d.setDividerColor(this.t);
            this.f10235c.setDividerColor(this.t);
            this.f10234b.setDividerColor(this.t);
            this.f10237e.setDividerColor(this.t);
            this.f10238f.setDividerColor(this.t);
            this.f10239g.setDividerColor(this.t);
        }
    }

    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.t = i;
            t();
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.f10236d.setDividerType(this.v);
            this.f10235c.setDividerType(this.v);
            this.f10234b.setDividerType(this.v);
            this.f10237e.setDividerType(this.v);
            this.f10238f.setDividerType(this.v);
            this.f10239g.setDividerType(this.v);
        }
    }

    public void w(WheelView.DividerType dividerType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, dividerType) == null) {
            this.v = dividerType;
            v();
        }
    }

    public void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.k = i;
        }
    }

    public void y(String str, String str2, String str3, String str4, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{str, str2, str3, str4, str5, str6}) == null) || this.w) {
            return;
        }
        if (str != null) {
            this.f10234b.setLabel(str);
        } else {
            this.f10234b.setLabel(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0e46));
        }
        if (str2 != null) {
            this.f10235c.setLabel(str2);
        } else {
            this.f10235c.setLabel(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0e43));
        }
        if (str3 != null) {
            this.f10236d.setLabel(str3);
        } else {
            this.f10236d.setLabel(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0e40));
        }
        if (str4 != null) {
            this.f10237e.setLabel(str4);
        } else {
            this.f10237e.setLabel(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0e41));
        }
        if (str5 != null) {
            this.f10238f.setLabel(str5);
        } else {
            this.f10238f.setLabel(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0e42));
        }
        if (str6 != null) {
            this.f10239g.setLabel(str6);
        } else {
            this.f10239g.setLabel(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0e44));
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.f10236d.setLineSpacingMultiplier(this.u);
            this.f10235c.setLineSpacingMultiplier(this.u);
            this.f10234b.setLineSpacingMultiplier(this.u);
            this.f10237e.setLineSpacingMultiplier(this.u);
            this.f10238f.setLineSpacingMultiplier(this.u);
            this.f10239g.setLineSpacingMultiplier(this.u);
        }
    }
}
