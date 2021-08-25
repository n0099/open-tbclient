package c.a.q0.x2;

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
/* loaded from: classes4.dex */
public class i implements c.a.q0.f.b.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<Object> f28859a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.q0.f.e.c f28860b;

    /* renamed from: c  reason: collision with root package name */
    public u f28861c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.e.l.e.a f28862d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.e.l.e.a f28863e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.e.l.e.a f28864f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.e.l.e.a f28865g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.e.l.e.a f28866h;

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.q0.f.b.d
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
        }
    }

    @Override // c.a.q0.f.e.a
    public void b(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) {
        }
    }

    @Override // c.a.q0.f.b.d
    public List<Integer> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(AdvertAppInfo.q4.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.n4.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.r4.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.s4.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.t4.getId()));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // c.a.q0.f.b.d
    public void e(List<c.a.q0.f.b.c> list, String str, String str2, String str3, String str4, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{list, str, str2, str3, str4, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || c.a.q0.o1.o.k.a.e(list)) {
            return;
        }
        Set<c.a.e.l.e.n> a2 = c.a.q0.x2.l0.a.a("FRS");
        if (a2 == null) {
            a2 = new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (c.a.q0.f.b.c cVar : list) {
            if (cVar != null) {
                Object a3 = cVar.a();
                for (c.a.e.l.e.n nVar : a2) {
                    if (a3 != null && cVar.c() == 3 && (a3 instanceof AdvertAppInfo) && nVar != null && (nVar instanceof AdvertAppInfo) && a3.hashCode() == nVar.hashCode()) {
                        ((AdvertAppInfo) a3).c4 = ((AdvertAppInfo) nVar).c4;
                    }
                }
                if (a3 != null && cVar.c() == 3 && (a3 instanceof AdvertAppInfo)) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) a3;
                    if (advertAppInfo.c4 == null) {
                        c.a.p0.s.q.e eVar = new c.a.p0.s.q.e();
                        advertAppInfo.c4 = eVar;
                        eVar.f14192a = "FRS";
                        eVar.f14194c = String.valueOf(z);
                        c.a.p0.s.q.e eVar2 = advertAppInfo.c4;
                        eVar2.f14193b = i2;
                        eVar2.f14195d = str;
                        eVar2.f14196e = str2;
                        eVar2.f14197f = str3;
                        eVar2.f14198g = str4;
                        eVar2.f14199h = advertAppInfo.a4;
                        eVar2.f14200i = false;
                        hashSet.add(advertAppInfo);
                    }
                }
            }
        }
        a2.addAll(hashSet);
        c.a.q0.x2.l0.a.b("FRS", a2);
    }

    @Override // c.a.q0.f.b.d
    public TypeAdapter.ViewHolder f(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        c.a.e.l.e.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, viewGroup, obj)) == null) {
            if (obj instanceof AdvertAppInfo) {
                BdUniqueId type = ((AdvertAppInfo) obj).getType();
                if (type == AdvertAppInfo.q4) {
                    aVar = this.f28863e;
                } else if (type == AdvertAppInfo.n4) {
                    aVar = this.f28862d;
                } else if (type == AdvertAppInfo.r4) {
                    aVar = this.f28864f;
                } else if (type == AdvertAppInfo.s4) {
                    aVar = this.f28865g;
                } else {
                    aVar = type == AdvertAppInfo.t4 ? this.f28866h : null;
                }
                if (aVar != null) {
                    return aVar.V(viewGroup, obj);
                }
                return null;
            }
            return null;
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    @Override // c.a.q0.f.b.d
    public void h(List<c.a.q0.f.b.c> list, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, list, i2) == null) || c.a.q0.o1.o.k.a.e(this.f28859a)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.f28859a) {
            if (obj instanceof AdvertAppInfo) {
                c.a.q0.o1.o.k.a.a(arrayList, (AdvertAppInfo) obj);
            }
        }
        Iterator<c.a.q0.f.b.c> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int k = c.a.q0.o1.o.k.a.k(list);
        int i3 = 0;
        int i4 = 0;
        for (c.a.q0.f.b.c cVar : list) {
            if (cVar.c() == 1) {
                i4++;
            }
        }
        int k2 = c.a.q0.o1.o.k.a.k(arrayList);
        if (k2 < 1) {
            return;
        }
        int i5 = k - i4;
        HashSet hashSet = new HashSet();
        int i6 = 0;
        while (i6 < k2) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) c.a.q0.o1.o.k.a.d(arrayList, i6);
            advertAppInfo.d4 = "FRS";
            int I4 = advertAppInfo.I4();
            if (I4 != 0) {
                c.a.q0.x2.l0.d.h(advertAppInfo, i2, I4);
                if (I4 != 28 && I4 != 31) {
                    advertAppInfo.V3 = -1001;
                }
                i6++;
                i3 = 0;
            }
            if (advertAppInfo.getType() == null) {
                c.a.q0.x2.l0.d.h(advertAppInfo, i2, 100);
            } else {
                int d2 = (c.a.e.e.m.b.d(advertAppInfo.Z3, i3) + i4) - 1;
                if (hashSet.contains(Integer.valueOf(d2))) {
                    c.a.q0.x2.l0.d.h(advertAppInfo, i2, 29);
                } else if (d2 < 0) {
                    c.a.q0.x2.l0.d.h(advertAppInfo, i2, 33);
                } else if (d2 >= k && i5 > 3) {
                    c.a.q0.x2.l0.d.i(advertAppInfo, i2, 2, d2, k);
                } else {
                    c.a.q0.f.b.c cVar2 = new c.a.q0.f.b.c();
                    cVar2.d(advertAppInfo);
                    cVar2.e(advertAppInfo.getType().getId());
                    cVar2.f(3);
                    if (advertAppInfo.F4()) {
                        if (z.q(advertAppInfo.l4) && c.a.q0.a.h().D()) {
                            c.a.q0.x2.l0.d.h(advertAppInfo, i2, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.l4) && !TextUtils.isEmpty(advertAppInfo.g4)) {
                            hashSet.add(Integer.valueOf(d2));
                            if (d2 < k) {
                                c.a.q0.o1.o.k.a.b(list, cVar2, d2);
                            } else if (d2 == k) {
                                c.a.q0.o1.o.k.a.a(list, cVar2);
                            }
                        }
                    } else if (advertAppInfo.H4()) {
                        hashSet.add(Integer.valueOf(d2));
                        if (d2 < k) {
                            c.a.q0.o1.o.k.a.b(list, cVar2, d2);
                        } else if (d2 == k) {
                            c.a.q0.o1.o.k.a.a(list, cVar2);
                        }
                    } else {
                        c.a.q0.x2.l0.d.h(advertAppInfo, i2, 21);
                    }
                }
            }
            i6++;
            i3 = 0;
        }
    }

    @Override // c.a.q0.f.b.d
    public void j(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.f28859a = list;
        }
    }

    @Override // c.a.q0.f.b.d
    public View l(int i2, View view, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        c.a.e.l.e.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), view, viewGroup, obj})) == null) {
            if (obj instanceof AdvertAppInfo) {
                AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
                BdUniqueId type = advertAppInfo.getType();
                if (type == AdvertAppInfo.q4) {
                    aVar = this.f28863e;
                } else if (type == AdvertAppInfo.n4) {
                    aVar = this.f28862d;
                } else if (type == AdvertAppInfo.r4) {
                    aVar = this.f28864f;
                } else if (type == AdvertAppInfo.s4) {
                    aVar = this.f28865g;
                } else {
                    aVar = type == AdvertAppInfo.t4 ? this.f28866h : null;
                }
                if (aVar != null) {
                    return aVar.L(i2, view, viewGroup, advertAppInfo);
                }
                return null;
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // c.a.q0.f.b.d
    public void m(int i2, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), viewGroup, viewHolder, obj}) == null) && (obj instanceof AdvertAppInfo)) {
            c.a.e.l.e.a aVar = null;
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.q4) {
                aVar = this.f28863e;
            } else if (type == AdvertAppInfo.n4) {
                aVar = this.f28862d;
            } else if (type == AdvertAppInfo.r4) {
                aVar = this.f28864f;
            } else if (type == AdvertAppInfo.s4) {
                aVar = this.f28865g;
            } else if (type == AdvertAppInfo.t4) {
                aVar = this.f28866h;
            }
            if (aVar != null) {
                aVar.b0(i2, viewGroup, viewHolder, obj);
            }
        }
    }

    @Override // c.a.q0.f.b.d
    public void n(List<c.a.q0.f.b.c> list, List<c.a.q0.f.b.c> list2, boolean z, int i2) {
        ArrayList arrayList;
        int i3;
        int i4;
        int d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{list, list2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || c.a.q0.o1.o.k.a.e(this.f28859a)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : this.f28859a) {
            if (obj instanceof AdvertAppInfo) {
                c.a.q0.o1.o.k.a.a(arrayList2, (AdvertAppInfo) obj);
            }
        }
        Iterator<c.a.q0.f.b.c> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int k = c.a.q0.o1.o.k.a.k(list);
        int i5 = 0;
        int i6 = 0;
        for (c.a.q0.f.b.c cVar : list) {
            if (cVar.c() == 1) {
                i6++;
            }
        }
        int k2 = c.a.q0.o1.o.k.a.k(arrayList2);
        if (k2 < 1) {
            return;
        }
        int i7 = 9;
        if (c.a.q0.o1.o.k.a.k(arrayList2) > 1 && (d2 = (c.a.e.e.m.b.d(((AdvertAppInfo) c.a.q0.o1.o.k.a.d(arrayList2, 1)).Z3, 0) - c.a.e.e.m.b.d(((AdvertAppInfo) c.a.q0.o1.o.k.a.d(arrayList2, 0)).Z3, 0)) - 1) > 0) {
            i7 = d2;
        }
        int d3 = c.a.e.e.m.b.d(((AdvertAppInfo) c.a.q0.o1.o.k.a.d(arrayList2, 0)).Z3, 0) - 1;
        int i8 = k - i6;
        HashSet hashSet = new HashSet();
        int i9 = 0;
        while (i9 < k2) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) c.a.q0.o1.o.k.a.d(arrayList2, i9);
            advertAppInfo.d4 = "SMART_FRS";
            int I4 = advertAppInfo.I4();
            if (I4 != 0) {
                c.a.q0.x2.l0.d.h(advertAppInfo, i2, I4);
                if (I4 != 28 && I4 != 31) {
                    advertAppInfo.V3 = -1001;
                }
                arrayList = arrayList2;
                i9++;
                arrayList2 = arrayList;
                i5 = 0;
            }
            if (advertAppInfo.getType() == null) {
                c.a.q0.x2.l0.d.h(advertAppInfo, i2, 100);
                arrayList = arrayList2;
                i9++;
                arrayList2 = arrayList;
                i5 = 0;
            } else {
                int d4 = c.a.e.e.m.b.d(advertAppInfo.Z3, i5);
                int i10 = (d4 + i6) - 1;
                if (i10 < 0 || hashSet.contains(Integer.valueOf(i10)) || i10 > k) {
                    arrayList = arrayList2;
                    if (i10 > k) {
                        c.a.q0.x2.l0.d.i(advertAppInfo, i2, 2, i10, k);
                        i9++;
                        arrayList2 = arrayList;
                        i5 = 0;
                    } else {
                        i3 = i10 < 0 ? 33 : 29;
                    }
                } else {
                    if (d4 <= (i8 - i7) + d3 || !z) {
                        arrayList = arrayList2;
                    } else if (!c.a.q0.o1.o.k.a.e(list2)) {
                        int k3 = c.a.q0.o1.o.k.a.k(list2);
                        int i11 = (i7 - ((i8 - d4) + 1)) - 1;
                        int i12 = 0;
                        while (i12 < k3 && i12 < i11) {
                            arrayList = arrayList2;
                            if (((c.a.q0.f.b.c) c.a.q0.o1.o.k.a.d(list2, i12)).a() instanceof AdvertAppInfo) {
                                i4 = 0;
                                break;
                            } else {
                                i12++;
                                arrayList2 = arrayList;
                            }
                        }
                        arrayList = arrayList2;
                        i4 = 1;
                        i3 = i4 ^ 1;
                    } else {
                        arrayList = arrayList2;
                        if (c.a.q0.a.h().C()) {
                            i3 = 36;
                        }
                    }
                    i3 = 0;
                }
                if (i3 != 0) {
                    c.a.q0.x2.l0.d.h(advertAppInfo, i2, i3);
                    i9++;
                    arrayList2 = arrayList;
                    i5 = 0;
                } else {
                    c.a.q0.f.b.c cVar2 = new c.a.q0.f.b.c();
                    cVar2.d(advertAppInfo);
                    cVar2.e(advertAppInfo.getType().getId());
                    cVar2.f(3);
                    if (advertAppInfo.F4()) {
                        if (z.q(advertAppInfo.l4) && c.a.q0.a.h().D()) {
                            c.a.q0.x2.l0.d.h(advertAppInfo, i2, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.l4) && !TextUtils.isEmpty(advertAppInfo.g4)) {
                            hashSet.add(Integer.valueOf(i10));
                            if (i10 < k) {
                                c.a.q0.o1.o.k.a.b(list, cVar2, i10);
                            } else if (i10 == k) {
                                c.a.q0.o1.o.k.a.a(list, cVar2);
                            }
                        }
                    } else if (advertAppInfo.H4()) {
                        hashSet.add(Integer.valueOf(i10));
                        if (i10 < k) {
                            c.a.q0.o1.o.k.a.b(list, cVar2, i10);
                        } else if (i10 == k) {
                            c.a.q0.o1.o.k.a.a(list, cVar2);
                        }
                    }
                    i9++;
                    arrayList2 = arrayList;
                    i5 = 0;
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.f.e.a
    /* renamed from: p */
    public void o(c.a.q0.f.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.f28860b = cVar;
            if (cVar == null || !(cVar.a() instanceof u)) {
                return;
            }
            this.f28861c = (u) this.f28860b.a();
            this.f28862d = new c.a.q0.x2.c0.c(this.f28861c, AdvertAppInfo.n4);
            this.f28863e = new c.a.q0.x2.c0.d(this.f28861c, AdvertAppInfo.q4);
            this.f28864f = new c.a.q0.x2.c0.d(this.f28861c, AdvertAppInfo.r4);
            this.f28865g = new c.a.q0.x2.c0.d(this.f28861c, AdvertAppInfo.s4);
            this.f28866h = new c.a.q0.x2.c0.d(this.f28861c, AdvertAppInfo.t4);
        }
    }
}
