package c.a.t0.i1.b;

import c.a.s0.s.q.j0;
import c.a.s0.s.q.k0;
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
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.d.a.f<GiftTabActivity> a;

    /* renamed from: b  reason: collision with root package name */
    public DefaultGiftListModel f18339b;

    /* renamed from: c  reason: collision with root package name */
    public CategoryGiftListModel f18340c;

    /* renamed from: d  reason: collision with root package name */
    public FreeGiftChanceModel f18341d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<c.a.t0.i1.b.c> f18342e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<c.a.t0.i1.b.a> f18343f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c.a.t0.i1.b.e> f18344g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<Integer, ArrayList<j0>> f18345h;

    /* renamed from: i  reason: collision with root package name */
    public int f18346i;

    /* renamed from: j  reason: collision with root package name */
    public String f18347j;
    public int k;
    public k0 l;
    public e m;
    public d n;
    public DefaultGiftListModel.b o;
    public CategoryGiftListModel.b p;
    public FreeGiftChanceModel.b q;

    /* loaded from: classes7.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // com.baidu.tieba.gift.giftTab.DefaultGiftListModel.b
        public void a(int i2, String str, int i3, String str2, int i4, k0 k0Var, ArrayList<c.a.t0.i1.b.a> arrayList, ArrayList<j0> arrayList2, ArrayList<c.a.t0.i1.b.e> arrayList3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, Integer.valueOf(i4), k0Var, arrayList, arrayList2, arrayList3}) == null) {
                if (i2 == 0) {
                    int i5 = 0;
                    if (arrayList != null && arrayList.size() >= 1 && arrayList.get(0) != null) {
                        i5 = arrayList.get(0).a();
                    }
                    this.a.f18343f = arrayList;
                    this.a.f18345h.put(Integer.valueOf(i5), arrayList2);
                    this.a.f18344g = arrayList3;
                    this.a.f18347j = str2;
                    this.a.f18346i = i3;
                    f fVar = this.a;
                    fVar.k = i4;
                    fVar.l = k0Var;
                    fVar.q();
                }
                if (this.a.m != null) {
                    e eVar = this.a.m;
                    String str3 = this.a.f18347j;
                    f fVar2 = this.a;
                    eVar.a(i2, str, true, str3, fVar2.k, fVar2.l, fVar2.f18342e, this.a.f18343f, this.a.f18344g);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // com.baidu.tieba.gift.giftTab.CategoryGiftListModel.b
        public void a(int i2, String str, int i3, ArrayList<j0> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), arrayList}) == null) {
                if (i2 == 0) {
                    this.a.f18345h.put(Integer.valueOf(i3), arrayList);
                    this.a.q();
                }
                if (this.a.m != null) {
                    e eVar = this.a.m;
                    String str2 = this.a.f18347j;
                    f fVar = this.a;
                    eVar.a(i2, str, false, str2, fVar.k, fVar.l, fVar.f18342e, this.a.f18343f, this.a.f18344g);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // com.baidu.tieba.gift.giftTab.FreeGiftChanceModel.b
        public void a(int i2, String str, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) && i2 == 0) {
                this.a.f18346i = i3;
                if (this.a.n != null) {
                    this.a.n.a(this.a.f18346i);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a(int i2);
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a(int i2, String str, boolean z, String str2, int i3, k0 k0Var, ArrayList<c.a.t0.i1.b.c> arrayList, ArrayList<c.a.t0.i1.b.a> arrayList2, ArrayList<c.a.t0.i1.b.e> arrayList3);
    }

    public f(c.a.d.a.f<GiftTabActivity> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18345h = new HashMap<>();
        this.o = new a(this);
        this.p = new b(this);
        this.q = new c(this);
        this.a = fVar;
        DefaultGiftListModel defaultGiftListModel = new DefaultGiftListModel(fVar);
        this.f18339b = defaultGiftListModel;
        defaultGiftListModel.I(this.o);
        CategoryGiftListModel categoryGiftListModel = new CategoryGiftListModel(this.a);
        this.f18340c = categoryGiftListModel;
        categoryGiftListModel.A(this.p);
        FreeGiftChanceModel freeGiftChanceModel = new FreeGiftChanceModel(this.a);
        this.f18341d = freeGiftChanceModel;
        freeGiftChanceModel.A(this.q);
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (this.f18341d == null) {
                FreeGiftChanceModel freeGiftChanceModel = new FreeGiftChanceModel(this.a);
                this.f18341d = freeGiftChanceModel;
                freeGiftChanceModel.A(this.q);
            }
            this.f18341d.z(str);
        }
    }

    public void o(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j2) == null) {
            if (this.f18339b == null) {
                DefaultGiftListModel defaultGiftListModel = new DefaultGiftListModel(this.a);
                this.f18339b = defaultGiftListModel;
                defaultGiftListModel.I(this.o);
            }
            this.f18339b.H(str, j2);
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (this.f18340c == null) {
                CategoryGiftListModel categoryGiftListModel = new CategoryGiftListModel(this.a);
                this.f18340c = categoryGiftListModel;
                categoryGiftListModel.A(this.p);
            }
            this.f18340c.z(i2);
        }
    }

    public final void q() {
        HashMap<Integer, ArrayList<j0>> hashMap;
        ArrayList<c.a.t0.i1.b.a> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (hashMap = this.f18345h) == null || hashMap.size() <= 0 || (arrayList = this.f18343f) == null || arrayList.size() <= 0) {
            return;
        }
        if (this.f18342e == null) {
            this.f18342e = new ArrayList<>();
        }
        this.f18342e.clear();
        Iterator<c.a.t0.i1.b.a> it = this.f18343f.iterator();
        while (it.hasNext()) {
            c.a.t0.i1.b.a next = it.next();
            if (next != null && !StringUtils.isNull(next.b())) {
                c.a.t0.i1.b.c cVar = new c.a.t0.i1.b.c();
                cVar.c(next.a());
                cVar.d(next.b());
                ArrayList<j0> arrayList2 = this.f18345h.get(Integer.valueOf(next.a()));
                if (arrayList2 != null) {
                    cVar.e(arrayList2);
                }
                this.f18342e.add(cVar);
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
