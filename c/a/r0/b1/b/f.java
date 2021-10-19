package c.a.r0.b1.b;

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
    public c.a.e.a.f<GiftTabActivity> f15895a;

    /* renamed from: b  reason: collision with root package name */
    public DefaultGiftListModel f15896b;

    /* renamed from: c  reason: collision with root package name */
    public CategoryGiftListModel f15897c;

    /* renamed from: d  reason: collision with root package name */
    public FreeGiftChanceModel f15898d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<c.a.r0.b1.b.c> f15899e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<c.a.r0.b1.b.a> f15900f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c.a.r0.b1.b.e> f15901g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<Integer, ArrayList<j0>> f15902h;

    /* renamed from: i  reason: collision with root package name */
    public int f15903i;

    /* renamed from: j  reason: collision with root package name */
    public String f15904j;
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
        public final /* synthetic */ f f15905a;

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
            this.f15905a = fVar;
        }

        @Override // com.baidu.tieba.gift.giftTab.DefaultGiftListModel.b
        public void a(int i2, String str, int i3, String str2, int i4, k0 k0Var, ArrayList<c.a.r0.b1.b.a> arrayList, ArrayList<j0> arrayList2, ArrayList<c.a.r0.b1.b.e> arrayList3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, Integer.valueOf(i4), k0Var, arrayList, arrayList2, arrayList3}) == null) {
                if (i2 == 0) {
                    int i5 = 0;
                    if (arrayList != null && arrayList.size() >= 1 && arrayList.get(0) != null) {
                        i5 = arrayList.get(0).a();
                    }
                    this.f15905a.f15900f = arrayList;
                    this.f15905a.f15902h.put(Integer.valueOf(i5), arrayList2);
                    this.f15905a.f15901g = arrayList3;
                    this.f15905a.f15904j = str2;
                    this.f15905a.f15903i = i3;
                    f fVar = this.f15905a;
                    fVar.k = i4;
                    fVar.l = k0Var;
                    fVar.q();
                }
                if (this.f15905a.m != null) {
                    e eVar = this.f15905a.m;
                    String str3 = this.f15905a.f15904j;
                    f fVar2 = this.f15905a;
                    eVar.a(i2, str, true, str3, fVar2.k, fVar2.l, fVar2.f15899e, this.f15905a.f15900f, this.f15905a.f15901g);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements CategoryGiftListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f15906a;

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
            this.f15906a = fVar;
        }

        @Override // com.baidu.tieba.gift.giftTab.CategoryGiftListModel.b
        public void a(int i2, String str, int i3, ArrayList<j0> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), arrayList}) == null) {
                if (i2 == 0) {
                    this.f15906a.f15902h.put(Integer.valueOf(i3), arrayList);
                    this.f15906a.q();
                }
                if (this.f15906a.m != null) {
                    e eVar = this.f15906a.m;
                    String str2 = this.f15906a.f15904j;
                    f fVar = this.f15906a;
                    eVar.a(i2, str, false, str2, fVar.k, fVar.l, fVar.f15899e, this.f15906a.f15900f, this.f15906a.f15901g);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements FreeGiftChanceModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f15907a;

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
            this.f15907a = fVar;
        }

        @Override // com.baidu.tieba.gift.giftTab.FreeGiftChanceModel.b
        public void a(int i2, String str, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) && i2 == 0) {
                this.f15907a.f15903i = i3;
                if (this.f15907a.n != null) {
                    this.f15907a.n.a(this.f15907a.f15903i);
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
        void a(int i2, String str, boolean z, String str2, int i3, k0 k0Var, ArrayList<c.a.r0.b1.b.c> arrayList, ArrayList<c.a.r0.b1.b.a> arrayList2, ArrayList<c.a.r0.b1.b.e> arrayList3);
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
        this.f15902h = new HashMap<>();
        this.o = new a(this);
        this.p = new b(this);
        this.q = new c(this);
        this.f15895a = fVar;
        DefaultGiftListModel defaultGiftListModel = new DefaultGiftListModel(fVar);
        this.f15896b = defaultGiftListModel;
        defaultGiftListModel.I(this.o);
        CategoryGiftListModel categoryGiftListModel = new CategoryGiftListModel(this.f15895a);
        this.f15897c = categoryGiftListModel;
        categoryGiftListModel.A(this.p);
        FreeGiftChanceModel freeGiftChanceModel = new FreeGiftChanceModel(this.f15895a);
        this.f15898d = freeGiftChanceModel;
        freeGiftChanceModel.A(this.q);
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (this.f15898d == null) {
                FreeGiftChanceModel freeGiftChanceModel = new FreeGiftChanceModel(this.f15895a);
                this.f15898d = freeGiftChanceModel;
                freeGiftChanceModel.A(this.q);
            }
            this.f15898d.z(str);
        }
    }

    public void o(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j2) == null) {
            if (this.f15896b == null) {
                DefaultGiftListModel defaultGiftListModel = new DefaultGiftListModel(this.f15895a);
                this.f15896b = defaultGiftListModel;
                defaultGiftListModel.I(this.o);
            }
            this.f15896b.H(str, j2);
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (this.f15897c == null) {
                CategoryGiftListModel categoryGiftListModel = new CategoryGiftListModel(this.f15895a);
                this.f15897c = categoryGiftListModel;
                categoryGiftListModel.A(this.p);
            }
            this.f15897c.z(i2);
        }
    }

    public final void q() {
        HashMap<Integer, ArrayList<j0>> hashMap;
        ArrayList<c.a.r0.b1.b.a> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (hashMap = this.f15902h) == null || hashMap.size() <= 0 || (arrayList = this.f15900f) == null || arrayList.size() <= 0) {
            return;
        }
        if (this.f15899e == null) {
            this.f15899e = new ArrayList<>();
        }
        this.f15899e.clear();
        Iterator<c.a.r0.b1.b.a> it = this.f15900f.iterator();
        while (it.hasNext()) {
            c.a.r0.b1.b.a next = it.next();
            if (next != null && !StringUtils.isNull(next.b())) {
                c.a.r0.b1.b.c cVar = new c.a.r0.b1.b.c();
                cVar.c(next.a());
                cVar.d(next.b());
                ArrayList<j0> arrayList2 = this.f15902h.get(Integer.valueOf(next.a()));
                if (arrayList2 != null) {
                    cVar.e(arrayList2);
                }
                this.f15899e.add(cVar);
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
