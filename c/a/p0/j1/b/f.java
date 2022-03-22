package c.a.p0.j1.b;

import c.a.o0.r.r.j0;
import c.a.o0.r.r.k0;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.gift.giftTab.CategoryGiftListModel;
import com.baidu.tieba.gift.giftTab.DefaultGiftListModel;
import com.baidu.tieba.gift.giftTab.FreeGiftChanceModel;
import com.baidu.tieba.gift.giftTab.GiftTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.d.a.f<GiftTabActivity> a;

    /* renamed from: b  reason: collision with root package name */
    public DefaultGiftListModel f15586b;

    /* renamed from: c  reason: collision with root package name */
    public CategoryGiftListModel f15587c;

    /* renamed from: d  reason: collision with root package name */
    public FreeGiftChanceModel f15588d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<c.a.p0.j1.b.c> f15589e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<c.a.p0.j1.b.a> f15590f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c.a.p0.j1.b.e> f15591g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<Integer, ArrayList<j0>> f15592h;
    public int i;
    public String j;
    public int k;
    public k0 l;
    public e m;
    public d n;
    public DefaultGiftListModel.b o;
    public CategoryGiftListModel.b p;
    public FreeGiftChanceModel.b q;

    /* loaded from: classes2.dex */
    public class a implements DefaultGiftListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // com.baidu.tieba.gift.giftTab.DefaultGiftListModel.b
        public void a(int i, String str, int i2, String str2, int i3, k0 k0Var, ArrayList<c.a.p0.j1.b.a> arrayList, ArrayList<j0> arrayList2, ArrayList<c.a.p0.j1.b.e> arrayList3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), str2, Integer.valueOf(i3), k0Var, arrayList, arrayList2, arrayList3}) == null) {
                if (i == 0) {
                    int i4 = 0;
                    if (arrayList != null && arrayList.size() >= 1 && arrayList.get(0) != null) {
                        i4 = arrayList.get(0).a();
                    }
                    this.a.f15590f = arrayList;
                    this.a.f15592h.put(Integer.valueOf(i4), arrayList2);
                    this.a.f15591g = arrayList3;
                    this.a.j = str2;
                    this.a.i = i2;
                    f fVar = this.a;
                    fVar.k = i3;
                    fVar.l = k0Var;
                    fVar.q();
                }
                if (this.a.m != null) {
                    e eVar = this.a.m;
                    String str3 = this.a.j;
                    f fVar2 = this.a;
                    eVar.a(i, str, true, str3, fVar2.k, fVar2.l, fVar2.f15589e, this.a.f15590f, this.a.f15591g);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements CategoryGiftListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // com.baidu.tieba.gift.giftTab.CategoryGiftListModel.b
        public void a(int i, String str, int i2, ArrayList<j0> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), arrayList}) == null) {
                if (i == 0) {
                    this.a.f15592h.put(Integer.valueOf(i2), arrayList);
                    this.a.q();
                }
                if (this.a.m != null) {
                    e eVar = this.a.m;
                    String str2 = this.a.j;
                    f fVar = this.a;
                    eVar.a(i, str, false, str2, fVar.k, fVar.l, fVar.f15589e, this.a.f15590f, this.a.f15591g);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements FreeGiftChanceModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // com.baidu.tieba.gift.giftTab.FreeGiftChanceModel.b
        public void a(int i, String str, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) && i == 0) {
                this.a.i = i2;
                if (this.a.n != null) {
                    this.a.n.a(this.a.i);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(int i);
    }

    /* loaded from: classes2.dex */
    public interface e {
        void a(int i, String str, boolean z, String str2, int i2, k0 k0Var, ArrayList<c.a.p0.j1.b.c> arrayList, ArrayList<c.a.p0.j1.b.a> arrayList2, ArrayList<c.a.p0.j1.b.e> arrayList3);
    }

    public f(c.a.d.a.f<GiftTabActivity> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15592h = new HashMap<>();
        this.o = new a(this);
        this.p = new b(this);
        this.q = new c(this);
        this.a = fVar;
        DefaultGiftListModel defaultGiftListModel = new DefaultGiftListModel(fVar);
        this.f15586b = defaultGiftListModel;
        defaultGiftListModel.K(this.o);
        CategoryGiftListModel categoryGiftListModel = new CategoryGiftListModel(this.a);
        this.f15587c = categoryGiftListModel;
        categoryGiftListModel.C(this.p);
        FreeGiftChanceModel freeGiftChanceModel = new FreeGiftChanceModel(this.a);
        this.f15588d = freeGiftChanceModel;
        freeGiftChanceModel.C(this.q);
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (this.f15588d == null) {
                FreeGiftChanceModel freeGiftChanceModel = new FreeGiftChanceModel(this.a);
                this.f15588d = freeGiftChanceModel;
                freeGiftChanceModel.C(this.q);
            }
            this.f15588d.B(str);
        }
    }

    public void o(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
            if (this.f15586b == null) {
                DefaultGiftListModel defaultGiftListModel = new DefaultGiftListModel(this.a);
                this.f15586b = defaultGiftListModel;
                defaultGiftListModel.K(this.o);
            }
            this.f15586b.J(str, j);
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (this.f15587c == null) {
                CategoryGiftListModel categoryGiftListModel = new CategoryGiftListModel(this.a);
                this.f15587c = categoryGiftListModel;
                categoryGiftListModel.C(this.p);
            }
            this.f15587c.B(i);
        }
    }

    public final void q() {
        HashMap<Integer, ArrayList<j0>> hashMap;
        ArrayList<c.a.p0.j1.b.a> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (hashMap = this.f15592h) == null || hashMap.size() <= 0 || (arrayList = this.f15590f) == null || arrayList.size() <= 0) {
            return;
        }
        if (this.f15589e == null) {
            this.f15589e = new ArrayList<>();
        }
        this.f15589e.clear();
        Iterator<c.a.p0.j1.b.a> it = this.f15590f.iterator();
        while (it.hasNext()) {
            c.a.p0.j1.b.a next = it.next();
            if (next != null && !StringUtils.isNull(next.b())) {
                c.a.p0.j1.b.c cVar = new c.a.p0.j1.b.c();
                cVar.c(next.a());
                cVar.d(next.b());
                ArrayList<j0> arrayList2 = this.f15592h.get(Integer.valueOf(next.a()));
                if (arrayList2 != null) {
                    cVar.e(arrayList2);
                }
                this.f15589e.add(cVar);
            }
        }
    }

    public void r(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.n = dVar;
        }
    }

    public void s(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
            this.m = eVar;
        }
    }
}
