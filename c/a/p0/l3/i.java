package c.a.p0.l3;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class i implements c.a.p0.h.b.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Object> a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.h.e.c f16216b;

    /* renamed from: c  reason: collision with root package name */
    public v f16217c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.d.o.e.a f16218d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.d.o.e.a f16219e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.d.o.e.a f16220f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.d.o.e.a f16221g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.d.o.e.a f16222h;

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.p0.h.b.d
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    @Override // c.a.p0.h.b.d
    public List<Integer> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(AdvertAppInfo.z.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.w.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.A.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.B.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.C.getId()));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // c.a.p0.h.b.d
    public void d(List<c.a.p0.h.b.c> list, String str, String str2, String str3, String str4, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{list, str, str2, str3, str4, Boolean.valueOf(z), Integer.valueOf(i)}) == null) || c.a.p0.b2.o.k.a.e(list)) {
            return;
        }
        Set<c.a.d.o.e.n> a = c.a.p0.l3.m0.a.a("FRS");
        if (a == null) {
            a = new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (c.a.p0.h.b.c cVar : list) {
            if (cVar != null) {
                Object a2 = cVar.a();
                for (c.a.d.o.e.n nVar : a) {
                    if (a2 != null && cVar.c() == 3 && (a2 instanceof AdvertAppInfo) && nVar != null && (nVar instanceof AdvertAppInfo) && a2.hashCode() == nVar.hashCode()) {
                        ((AdvertAppInfo) a2).j = ((AdvertAppInfo) nVar).j;
                    }
                }
                if (a2 != null && cVar.c() == 3 && (a2 instanceof AdvertAppInfo)) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) a2;
                    if (advertAppInfo.j == null) {
                        c.a.o0.r.r.e eVar = new c.a.o0.r.r.e();
                        advertAppInfo.j = eVar;
                        eVar.a = "FRS";
                        eVar.f10838c = String.valueOf(z);
                        c.a.o0.r.r.e eVar2 = advertAppInfo.j;
                        eVar2.f10837b = i;
                        eVar2.f10839d = str;
                        eVar2.f10840e = str2;
                        eVar2.f10841f = str3;
                        eVar2.f10842g = str4;
                        eVar2.f10843h = advertAppInfo.f29821h;
                        eVar2.i = false;
                        hashSet.add(advertAppInfo);
                    }
                }
            }
        }
        a.addAll(hashSet);
        c.a.p0.l3.m0.a.b("FRS", a);
    }

    @Override // c.a.p0.h.b.d
    public TypeAdapter.ViewHolder e(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        c.a.d.o.e.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, viewGroup, obj)) == null) {
            if (obj instanceof AdvertAppInfo) {
                BdUniqueId type = ((AdvertAppInfo) obj).getType();
                if (type == AdvertAppInfo.z) {
                    aVar = this.f16219e;
                } else if (type == AdvertAppInfo.w) {
                    aVar = this.f16218d;
                } else if (type == AdvertAppInfo.A) {
                    aVar = this.f16220f;
                } else if (type == AdvertAppInfo.B) {
                    aVar = this.f16221g;
                } else {
                    aVar = type == AdvertAppInfo.C ? this.f16222h : null;
                }
                if (aVar != null) {
                    return aVar.N(viewGroup, obj);
                }
                return null;
            }
            return null;
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    @Override // c.a.p0.h.b.d
    public void g(List<c.a.p0.h.b.c> list, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, list, i) == null) || c.a.p0.b2.o.k.a.e(this.a)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.a) {
            if (obj instanceof AdvertAppInfo) {
                c.a.p0.b2.o.k.a.a(arrayList, (AdvertAppInfo) obj);
            }
        }
        Iterator<c.a.p0.h.b.c> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int k = c.a.p0.b2.o.k.a.k(list);
        int i2 = 0;
        int i3 = 0;
        for (c.a.p0.h.b.c cVar : list) {
            if (cVar.c() == 1) {
                i3++;
            }
        }
        int k2 = c.a.p0.b2.o.k.a.k(arrayList);
        if (k2 < 1) {
            return;
        }
        int i4 = k - i3;
        HashSet hashSet = new HashSet();
        int i5 = 0;
        while (i5 < k2) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) c.a.p0.b2.o.k.a.d(arrayList, i5);
            advertAppInfo.k = "FRS";
            int q = advertAppInfo.q();
            if (q != 0) {
                c.a.p0.l3.m0.d.i(advertAppInfo, i, q);
                if (q != 28 && q != 31) {
                    advertAppInfo.f29816c = -1001;
                }
                i5++;
                i2 = 0;
            }
            if (advertAppInfo.getType() == null) {
                c.a.p0.l3.m0.d.i(advertAppInfo, i, 100);
            } else {
                int e2 = (c.a.d.f.m.b.e(advertAppInfo.f29820g, i2) + i3) - 1;
                if (hashSet.contains(Integer.valueOf(e2))) {
                    c.a.p0.l3.m0.d.i(advertAppInfo, i, 29);
                } else if (e2 < 0) {
                    c.a.p0.l3.m0.d.i(advertAppInfo, i, 33);
                } else if (e2 >= k && i4 > 3) {
                    c.a.p0.l3.m0.d.j(advertAppInfo, i, 2, e2, k);
                } else {
                    c.a.p0.h.b.c cVar2 = new c.a.p0.h.b.c();
                    cVar2.d(advertAppInfo);
                    cVar2.e(advertAppInfo.getType().getId());
                    cVar2.f(3);
                    if (advertAppInfo.i()) {
                        if (a0.r(advertAppInfo.s) && c.a.p0.a.h().F()) {
                            c.a.p0.l3.m0.d.i(advertAppInfo, i, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.s) && !TextUtils.isEmpty(advertAppInfo.n)) {
                            hashSet.add(Integer.valueOf(e2));
                            if (e2 < k) {
                                c.a.p0.b2.o.k.a.b(list, cVar2, e2);
                            } else if (e2 == k) {
                                c.a.p0.b2.o.k.a.a(list, cVar2);
                            }
                        }
                    } else if (advertAppInfo.m()) {
                        hashSet.add(Integer.valueOf(e2));
                        if (e2 < k) {
                            c.a.p0.b2.o.k.a.b(list, cVar2, e2);
                        } else if (e2 == k) {
                            c.a.p0.b2.o.k.a.a(list, cVar2);
                        }
                    } else {
                        c.a.p0.l3.m0.d.i(advertAppInfo, i, 21);
                    }
                }
            }
            i5++;
            i2 = 0;
        }
    }

    @Override // c.a.p0.h.b.d
    public void i(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.a = list;
        }
    }

    @Override // c.a.p0.h.b.d
    public View k(int i, View view, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        c.a.d.o.e.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view, viewGroup, obj})) == null) {
            if (obj instanceof AdvertAppInfo) {
                AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
                BdUniqueId type = advertAppInfo.getType();
                if (type == AdvertAppInfo.z) {
                    aVar = this.f16219e;
                } else if (type == AdvertAppInfo.w) {
                    aVar = this.f16218d;
                } else if (type == AdvertAppInfo.A) {
                    aVar = this.f16220f;
                } else if (type == AdvertAppInfo.B) {
                    aVar = this.f16221g;
                } else {
                    aVar = type == AdvertAppInfo.C ? this.f16222h : null;
                }
                if (aVar != null) {
                    return aVar.E(i, view, viewGroup, advertAppInfo);
                }
                return null;
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // c.a.p0.h.b.d
    public void l(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) == null) && (obj instanceof AdvertAppInfo)) {
            c.a.d.o.e.a aVar = null;
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.z) {
                aVar = this.f16219e;
            } else if (type == AdvertAppInfo.w) {
                aVar = this.f16218d;
            } else if (type == AdvertAppInfo.A) {
                aVar = this.f16220f;
            } else if (type == AdvertAppInfo.B) {
                aVar = this.f16221g;
            } else if (type == AdvertAppInfo.C) {
                aVar = this.f16222h;
            }
            if (aVar != null) {
                aVar.T(i, viewGroup, viewHolder, obj);
            }
        }
    }

    @Override // c.a.p0.h.b.d
    public void m(List<c.a.p0.h.b.c> list, List<c.a.p0.h.b.c> list2, boolean z, int i) {
        ArrayList arrayList;
        int i2;
        int i3;
        int e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{list, list2, Boolean.valueOf(z), Integer.valueOf(i)}) == null) || c.a.p0.b2.o.k.a.e(this.a)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : this.a) {
            if (obj instanceof AdvertAppInfo) {
                c.a.p0.b2.o.k.a.a(arrayList2, (AdvertAppInfo) obj);
            }
        }
        Iterator<c.a.p0.h.b.c> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int k = c.a.p0.b2.o.k.a.k(list);
        int i4 = 0;
        int i5 = 0;
        for (c.a.p0.h.b.c cVar : list) {
            if (cVar.c() == 1) {
                i5++;
            }
        }
        int k2 = c.a.p0.b2.o.k.a.k(arrayList2);
        if (k2 < 1) {
            return;
        }
        int i6 = 9;
        if (c.a.p0.b2.o.k.a.k(arrayList2) > 1 && (e2 = (c.a.d.f.m.b.e(((AdvertAppInfo) c.a.p0.b2.o.k.a.d(arrayList2, 1)).f29820g, 0) - c.a.d.f.m.b.e(((AdvertAppInfo) c.a.p0.b2.o.k.a.d(arrayList2, 0)).f29820g, 0)) - 1) > 0) {
            i6 = e2;
        }
        int e3 = c.a.d.f.m.b.e(((AdvertAppInfo) c.a.p0.b2.o.k.a.d(arrayList2, 0)).f29820g, 0) - 1;
        int i7 = k - i5;
        HashSet hashSet = new HashSet();
        int i8 = 0;
        while (i8 < k2) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) c.a.p0.b2.o.k.a.d(arrayList2, i8);
            advertAppInfo.k = "SMART_FRS";
            int q = advertAppInfo.q();
            if (q != 0) {
                c.a.p0.l3.m0.d.i(advertAppInfo, i, q);
                if (q != 28 && q != 31) {
                    advertAppInfo.f29816c = -1001;
                }
                arrayList = arrayList2;
                i8++;
                arrayList2 = arrayList;
                i4 = 0;
            }
            if (advertAppInfo.getType() == null) {
                c.a.p0.l3.m0.d.i(advertAppInfo, i, 100);
                arrayList = arrayList2;
                i8++;
                arrayList2 = arrayList;
                i4 = 0;
            } else {
                int e4 = c.a.d.f.m.b.e(advertAppInfo.f29820g, i4);
                int i9 = (e4 + i5) - 1;
                if (i9 < 0 || hashSet.contains(Integer.valueOf(i9)) || i9 > k) {
                    arrayList = arrayList2;
                    if (i9 > k) {
                        c.a.p0.l3.m0.d.j(advertAppInfo, i, 2, i9, k);
                        i8++;
                        arrayList2 = arrayList;
                        i4 = 0;
                    } else {
                        i2 = i9 < 0 ? 33 : 29;
                    }
                } else {
                    if (e4 <= (i7 - i6) + e3 || !z) {
                        arrayList = arrayList2;
                    } else if (!c.a.p0.b2.o.k.a.e(list2)) {
                        int k3 = c.a.p0.b2.o.k.a.k(list2);
                        int i10 = (i6 - ((i7 - e4) + 1)) - 1;
                        int i11 = 0;
                        while (i11 < k3 && i11 < i10) {
                            arrayList = arrayList2;
                            if (((c.a.p0.h.b.c) c.a.p0.b2.o.k.a.d(list2, i11)).a() instanceof AdvertAppInfo) {
                                i3 = 0;
                                break;
                            } else {
                                i11++;
                                arrayList2 = arrayList;
                            }
                        }
                        arrayList = arrayList2;
                        i3 = 1;
                        i2 = i3 ^ 1;
                    } else {
                        arrayList = arrayList2;
                        if (c.a.p0.a.h().E()) {
                            i2 = 36;
                        }
                    }
                    i2 = 0;
                }
                if (i2 != 0) {
                    c.a.p0.l3.m0.d.i(advertAppInfo, i, i2);
                    i8++;
                    arrayList2 = arrayList;
                    i4 = 0;
                } else {
                    c.a.p0.h.b.c cVar2 = new c.a.p0.h.b.c();
                    cVar2.d(advertAppInfo);
                    cVar2.e(advertAppInfo.getType().getId());
                    cVar2.f(3);
                    if (advertAppInfo.i()) {
                        if (a0.r(advertAppInfo.s) && c.a.p0.a.h().F()) {
                            c.a.p0.l3.m0.d.i(advertAppInfo, i, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.s) && !TextUtils.isEmpty(advertAppInfo.n)) {
                            hashSet.add(Integer.valueOf(i9));
                            if (i9 < k) {
                                c.a.p0.b2.o.k.a.b(list, cVar2, i9);
                            } else if (i9 == k) {
                                c.a.p0.b2.o.k.a.a(list, cVar2);
                            }
                        }
                    } else if (advertAppInfo.m()) {
                        hashSet.add(Integer.valueOf(i9));
                        if (i9 < k) {
                            c.a.p0.b2.o.k.a.b(list, cVar2, i9);
                        } else if (i9 == k) {
                            c.a.p0.b2.o.k.a.a(list, cVar2);
                        }
                    }
                    i8++;
                    arrayList2 = arrayList;
                    i4 = 0;
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.h.e.a
    /* renamed from: o */
    public void n(c.a.p0.h.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.f16216b = cVar;
            if (cVar == null || !(cVar.a() instanceof v)) {
                return;
            }
            this.f16217c = (v) this.f16216b.a();
            this.f16218d = new c.a.p0.l3.d0.c(this.f16217c, AdvertAppInfo.w);
            this.f16219e = new c.a.p0.l3.d0.d(this.f16217c, AdvertAppInfo.z);
            this.f16220f = new c.a.p0.l3.d0.d(this.f16217c, AdvertAppInfo.A);
            this.f16221g = new c.a.p0.l3.d0.d(this.f16217c, AdvertAppInfo.B);
            this.f16222h = new c.a.p0.l3.d0.d(this.f16217c, AdvertAppInfo.C);
        }
    }

    @Override // c.a.p0.h.e.a
    public void setParams(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, map) == null) {
        }
    }
}
