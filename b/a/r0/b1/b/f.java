package b.a.r0.b1.b;

import b.a.q0.s.q.j0;
import b.a.q0.s.q.k0;
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
/* loaded from: classes4.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.e.a.f<GiftTabActivity> f14916a;

    /* renamed from: b  reason: collision with root package name */
    public DefaultGiftListModel f14917b;

    /* renamed from: c  reason: collision with root package name */
    public CategoryGiftListModel f14918c;

    /* renamed from: d  reason: collision with root package name */
    public FreeGiftChanceModel f14919d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<b.a.r0.b1.b.c> f14920e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<b.a.r0.b1.b.a> f14921f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<b.a.r0.b1.b.e> f14922g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<Integer, ArrayList<j0>> f14923h;

    /* renamed from: i  reason: collision with root package name */
    public int f14924i;
    public String j;
    public int k;
    public k0 l;
    public e m;
    public d n;
    public DefaultGiftListModel.b o;
    public CategoryGiftListModel.b p;
    public FreeGiftChanceModel.b q;

    /* loaded from: classes4.dex */
    public class a implements DefaultGiftListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f14925a;

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
            this.f14925a = fVar;
        }

        @Override // com.baidu.tieba.gift.giftTab.DefaultGiftListModel.b
        public void a(int i2, String str, int i3, String str2, int i4, k0 k0Var, ArrayList<b.a.r0.b1.b.a> arrayList, ArrayList<j0> arrayList2, ArrayList<b.a.r0.b1.b.e> arrayList3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, Integer.valueOf(i4), k0Var, arrayList, arrayList2, arrayList3}) == null) {
                if (i2 == 0) {
                    int i5 = 0;
                    if (arrayList != null && arrayList.size() >= 1 && arrayList.get(0) != null) {
                        i5 = arrayList.get(0).a();
                    }
                    this.f14925a.f14921f = arrayList;
                    this.f14925a.f14923h.put(Integer.valueOf(i5), arrayList2);
                    this.f14925a.f14922g = arrayList3;
                    this.f14925a.j = str2;
                    this.f14925a.f14924i = i3;
                    f fVar = this.f14925a;
                    fVar.k = i4;
                    fVar.l = k0Var;
                    fVar.q();
                }
                if (this.f14925a.m != null) {
                    e eVar = this.f14925a.m;
                    String str3 = this.f14925a.j;
                    f fVar2 = this.f14925a;
                    eVar.a(i2, str, true, str3, fVar2.k, fVar2.l, fVar2.f14920e, this.f14925a.f14921f, this.f14925a.f14922g);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements CategoryGiftListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f14926a;

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
            this.f14926a = fVar;
        }

        @Override // com.baidu.tieba.gift.giftTab.CategoryGiftListModel.b
        public void a(int i2, String str, int i3, ArrayList<j0> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), arrayList}) == null) {
                if (i2 == 0) {
                    this.f14926a.f14923h.put(Integer.valueOf(i3), arrayList);
                    this.f14926a.q();
                }
                if (this.f14926a.m != null) {
                    e eVar = this.f14926a.m;
                    String str2 = this.f14926a.j;
                    f fVar = this.f14926a;
                    eVar.a(i2, str, false, str2, fVar.k, fVar.l, fVar.f14920e, this.f14926a.f14921f, this.f14926a.f14922g);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements FreeGiftChanceModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f14927a;

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
            this.f14927a = fVar;
        }

        @Override // com.baidu.tieba.gift.giftTab.FreeGiftChanceModel.b
        public void a(int i2, String str, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) && i2 == 0) {
                this.f14927a.f14924i = i3;
                if (this.f14927a.n != null) {
                    this.f14927a.n.a(this.f14927a.f14924i);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(int i2);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(int i2, String str, boolean z, String str2, int i3, k0 k0Var, ArrayList<b.a.r0.b1.b.c> arrayList, ArrayList<b.a.r0.b1.b.a> arrayList2, ArrayList<b.a.r0.b1.b.e> arrayList3);
    }

    public f(b.a.e.a.f<GiftTabActivity> fVar) {
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
        this.f14923h = new HashMap<>();
        this.o = new a(this);
        this.p = new b(this);
        this.q = new c(this);
        this.f14916a = fVar;
        DefaultGiftListModel defaultGiftListModel = new DefaultGiftListModel(fVar);
        this.f14917b = defaultGiftListModel;
        defaultGiftListModel.I(this.o);
        CategoryGiftListModel categoryGiftListModel = new CategoryGiftListModel(this.f14916a);
        this.f14918c = categoryGiftListModel;
        categoryGiftListModel.A(this.p);
        FreeGiftChanceModel freeGiftChanceModel = new FreeGiftChanceModel(this.f14916a);
        this.f14919d = freeGiftChanceModel;
        freeGiftChanceModel.A(this.q);
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (this.f14919d == null) {
                FreeGiftChanceModel freeGiftChanceModel = new FreeGiftChanceModel(this.f14916a);
                this.f14919d = freeGiftChanceModel;
                freeGiftChanceModel.A(this.q);
            }
            this.f14919d.z(str);
        }
    }

    public void o(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
            if (this.f14917b == null) {
                DefaultGiftListModel defaultGiftListModel = new DefaultGiftListModel(this.f14916a);
                this.f14917b = defaultGiftListModel;
                defaultGiftListModel.I(this.o);
            }
            this.f14917b.H(str, j);
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (this.f14918c == null) {
                CategoryGiftListModel categoryGiftListModel = new CategoryGiftListModel(this.f14916a);
                this.f14918c = categoryGiftListModel;
                categoryGiftListModel.A(this.p);
            }
            this.f14918c.z(i2);
        }
    }

    public final void q() {
        HashMap<Integer, ArrayList<j0>> hashMap;
        ArrayList<b.a.r0.b1.b.a> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (hashMap = this.f14923h) == null || hashMap.size() <= 0 || (arrayList = this.f14921f) == null || arrayList.size() <= 0) {
            return;
        }
        if (this.f14920e == null) {
            this.f14920e = new ArrayList<>();
        }
        this.f14920e.clear();
        Iterator<b.a.r0.b1.b.a> it = this.f14921f.iterator();
        while (it.hasNext()) {
            b.a.r0.b1.b.a next = it.next();
            if (next != null && !StringUtils.isNull(next.b())) {
                b.a.r0.b1.b.c cVar = new b.a.r0.b1.b.c();
                cVar.c(next.a());
                cVar.d(next.b());
                ArrayList<j0> arrayList2 = this.f14923h.get(Integer.valueOf(next.a()));
                if (arrayList2 != null) {
                    cVar.e(arrayList2);
                }
                this.f14920e.add(cVar);
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
