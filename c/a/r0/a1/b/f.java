package c.a.r0.a1.b;

import c.a.q0.s.q.j0;
import c.a.q0.s.q.k0;
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
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.e.a.f<GiftTabActivity> f15729a;

    /* renamed from: b  reason: collision with root package name */
    public DefaultGiftListModel f15730b;

    /* renamed from: c  reason: collision with root package name */
    public CategoryGiftListModel f15731c;

    /* renamed from: d  reason: collision with root package name */
    public FreeGiftChanceModel f15732d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<c.a.r0.a1.b.c> f15733e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<c.a.r0.a1.b.a> f15734f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c.a.r0.a1.b.e> f15735g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<Integer, ArrayList<j0>> f15736h;

    /* renamed from: i  reason: collision with root package name */
    public int f15737i;

    /* renamed from: j  reason: collision with root package name */
    public String f15738j;
    public int k;
    public k0 l;
    public e m;
    public d n;
    public DefaultGiftListModel.b o;
    public CategoryGiftListModel.b p;
    public FreeGiftChanceModel.b q;

    /* loaded from: classes3.dex */
    public class a implements DefaultGiftListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f15739a;

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
            this.f15739a = fVar;
        }

        @Override // com.baidu.tieba.gift.giftTab.DefaultGiftListModel.b
        public void a(int i2, String str, int i3, String str2, int i4, k0 k0Var, ArrayList<c.a.r0.a1.b.a> arrayList, ArrayList<j0> arrayList2, ArrayList<c.a.r0.a1.b.e> arrayList3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, Integer.valueOf(i4), k0Var, arrayList, arrayList2, arrayList3}) == null) {
                if (i2 == 0) {
                    int i5 = 0;
                    if (arrayList != null && arrayList.size() >= 1 && arrayList.get(0) != null) {
                        i5 = arrayList.get(0).a();
                    }
                    this.f15739a.f15734f = arrayList;
                    this.f15739a.f15736h.put(Integer.valueOf(i5), arrayList2);
                    this.f15739a.f15735g = arrayList3;
                    this.f15739a.f15738j = str2;
                    this.f15739a.f15737i = i3;
                    f fVar = this.f15739a;
                    fVar.k = i4;
                    fVar.l = k0Var;
                    fVar.q();
                }
                if (this.f15739a.m != null) {
                    e eVar = this.f15739a.m;
                    String str3 = this.f15739a.f15738j;
                    f fVar2 = this.f15739a;
                    eVar.a(i2, str, true, str3, fVar2.k, fVar2.l, fVar2.f15733e, this.f15739a.f15734f, this.f15739a.f15735g);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements CategoryGiftListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f15740a;

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
            this.f15740a = fVar;
        }

        @Override // com.baidu.tieba.gift.giftTab.CategoryGiftListModel.b
        public void a(int i2, String str, int i3, ArrayList<j0> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), arrayList}) == null) {
                if (i2 == 0) {
                    this.f15740a.f15736h.put(Integer.valueOf(i3), arrayList);
                    this.f15740a.q();
                }
                if (this.f15740a.m != null) {
                    e eVar = this.f15740a.m;
                    String str2 = this.f15740a.f15738j;
                    f fVar = this.f15740a;
                    eVar.a(i2, str, false, str2, fVar.k, fVar.l, fVar.f15733e, this.f15740a.f15734f, this.f15740a.f15735g);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements FreeGiftChanceModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f15741a;

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
            this.f15741a = fVar;
        }

        @Override // com.baidu.tieba.gift.giftTab.FreeGiftChanceModel.b
        public void a(int i2, String str, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) && i2 == 0) {
                this.f15741a.f15737i = i3;
                if (this.f15741a.n != null) {
                    this.f15741a.n.a(this.f15741a.f15737i);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(int i2);
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(int i2, String str, boolean z, String str2, int i3, k0 k0Var, ArrayList<c.a.r0.a1.b.c> arrayList, ArrayList<c.a.r0.a1.b.a> arrayList2, ArrayList<c.a.r0.a1.b.e> arrayList3);
    }

    public f(c.a.e.a.f<GiftTabActivity> fVar) {
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
        this.f15736h = new HashMap<>();
        this.o = new a(this);
        this.p = new b(this);
        this.q = new c(this);
        this.f15729a = fVar;
        DefaultGiftListModel defaultGiftListModel = new DefaultGiftListModel(fVar);
        this.f15730b = defaultGiftListModel;
        defaultGiftListModel.I(this.o);
        CategoryGiftListModel categoryGiftListModel = new CategoryGiftListModel(this.f15729a);
        this.f15731c = categoryGiftListModel;
        categoryGiftListModel.A(this.p);
        FreeGiftChanceModel freeGiftChanceModel = new FreeGiftChanceModel(this.f15729a);
        this.f15732d = freeGiftChanceModel;
        freeGiftChanceModel.A(this.q);
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (this.f15732d == null) {
                FreeGiftChanceModel freeGiftChanceModel = new FreeGiftChanceModel(this.f15729a);
                this.f15732d = freeGiftChanceModel;
                freeGiftChanceModel.A(this.q);
            }
            this.f15732d.z(str);
        }
    }

    public void o(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j2) == null) {
            if (this.f15730b == null) {
                DefaultGiftListModel defaultGiftListModel = new DefaultGiftListModel(this.f15729a);
                this.f15730b = defaultGiftListModel;
                defaultGiftListModel.I(this.o);
            }
            this.f15730b.H(str, j2);
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (this.f15731c == null) {
                CategoryGiftListModel categoryGiftListModel = new CategoryGiftListModel(this.f15729a);
                this.f15731c = categoryGiftListModel;
                categoryGiftListModel.A(this.p);
            }
            this.f15731c.z(i2);
        }
    }

    public final void q() {
        HashMap<Integer, ArrayList<j0>> hashMap;
        ArrayList<c.a.r0.a1.b.a> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (hashMap = this.f15736h) == null || hashMap.size() <= 0 || (arrayList = this.f15734f) == null || arrayList.size() <= 0) {
            return;
        }
        if (this.f15733e == null) {
            this.f15733e = new ArrayList<>();
        }
        this.f15733e.clear();
        Iterator<c.a.r0.a1.b.a> it = this.f15734f.iterator();
        while (it.hasNext()) {
            c.a.r0.a1.b.a next = it.next();
            if (next != null && !StringUtils.isNull(next.b())) {
                c.a.r0.a1.b.c cVar = new c.a.r0.a1.b.c();
                cVar.c(next.a());
                cVar.d(next.b());
                ArrayList<j0> arrayList2 = this.f15736h.get(Integer.valueOf(next.a()));
                if (arrayList2 != null) {
                    cVar.e(arrayList2);
                }
                this.f15733e.add(cVar);
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
