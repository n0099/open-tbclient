package c.a.t0.j3;

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
/* loaded from: classes7.dex */
public class i implements c.a.t0.h.b.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Object> a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.t0.h.e.c f18383b;

    /* renamed from: c  reason: collision with root package name */
    public u f18384c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.d.n.e.a f18385d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.d.n.e.a f18386e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.d.n.e.a f18387f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.d.n.e.a f18388g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.d.n.e.a f18389h;

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

    @Override // c.a.t0.h.b.d
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
        }
    }

    @Override // c.a.t0.h.b.d
    public List<Integer> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(AdvertAppInfo.D4.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.A4.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.E4.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.F4.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.G4.getId()));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // c.a.t0.h.b.d
    public void d(List<c.a.t0.h.b.c> list, String str, String str2, String str3, String str4, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{list, str, str2, str3, str4, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || c.a.t0.x1.o.k.a.e(list)) {
            return;
        }
        Set<c.a.d.n.e.n> a = c.a.t0.j3.l0.a.a("FRS");
        if (a == null) {
            a = new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (c.a.t0.h.b.c cVar : list) {
            if (cVar != null) {
                Object a2 = cVar.a();
                for (c.a.d.n.e.n nVar : a) {
                    if (a2 != null && cVar.c() == 3 && (a2 instanceof AdvertAppInfo) && nVar != null && (nVar instanceof AdvertAppInfo) && a2.hashCode() == nVar.hashCode()) {
                        ((AdvertAppInfo) a2).o4 = ((AdvertAppInfo) nVar).o4;
                    }
                }
                if (a2 != null && cVar.c() == 3 && (a2 instanceof AdvertAppInfo)) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) a2;
                    if (advertAppInfo.o4 == null) {
                        c.a.s0.s.q.e eVar = new c.a.s0.s.q.e();
                        advertAppInfo.o4 = eVar;
                        eVar.a = "FRS";
                        eVar.f13351c = String.valueOf(z);
                        c.a.s0.s.q.e eVar2 = advertAppInfo.o4;
                        eVar2.f13350b = i2;
                        eVar2.f13352d = str;
                        eVar2.f13353e = str2;
                        eVar2.f13354f = str3;
                        eVar2.f13355g = str4;
                        eVar2.f13356h = advertAppInfo.m4;
                        eVar2.f13357i = false;
                        hashSet.add(advertAppInfo);
                    }
                }
            }
        }
        a.addAll(hashSet);
        c.a.t0.j3.l0.a.b("FRS", a);
    }

    @Override // c.a.t0.h.b.d
    public TypeAdapter.ViewHolder e(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        c.a.d.n.e.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, viewGroup, obj)) == null) {
            if (obj instanceof AdvertAppInfo) {
                BdUniqueId type = ((AdvertAppInfo) obj).getType();
                if (type == AdvertAppInfo.D4) {
                    aVar = this.f18386e;
                } else if (type == AdvertAppInfo.A4) {
                    aVar = this.f18385d;
                } else if (type == AdvertAppInfo.E4) {
                    aVar = this.f18387f;
                } else if (type == AdvertAppInfo.F4) {
                    aVar = this.f18388g;
                } else {
                    aVar = type == AdvertAppInfo.G4 ? this.f18389h : null;
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

    @Override // c.a.t0.h.b.d
    public void g(List<c.a.t0.h.b.c> list, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, list, i2) == null) || c.a.t0.x1.o.k.a.e(this.a)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.a) {
            if (obj instanceof AdvertAppInfo) {
                c.a.t0.x1.o.k.a.a(arrayList, (AdvertAppInfo) obj);
            }
        }
        Iterator<c.a.t0.h.b.c> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int k = c.a.t0.x1.o.k.a.k(list);
        int i3 = 0;
        int i4 = 0;
        for (c.a.t0.h.b.c cVar : list) {
            if (cVar.c() == 1) {
                i4++;
            }
        }
        int k2 = c.a.t0.x1.o.k.a.k(arrayList);
        if (k2 < 1) {
            return;
        }
        int i5 = k - i4;
        HashSet hashSet = new HashSet();
        int i6 = 0;
        while (i6 < k2) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) c.a.t0.x1.o.k.a.d(arrayList, i6);
            advertAppInfo.p4 = "FRS";
            int Y4 = advertAppInfo.Y4();
            if (Y4 != 0) {
                c.a.t0.j3.l0.d.i(advertAppInfo, i2, Y4);
                if (Y4 != 28 && Y4 != 31) {
                    advertAppInfo.h4 = -1001;
                }
                i6++;
                i3 = 0;
            }
            if (advertAppInfo.getType() == null) {
                c.a.t0.j3.l0.d.i(advertAppInfo, i2, 100);
            } else {
                int e2 = (c.a.d.f.m.b.e(advertAppInfo.l4, i3) + i4) - 1;
                if (hashSet.contains(Integer.valueOf(e2))) {
                    c.a.t0.j3.l0.d.i(advertAppInfo, i2, 29);
                } else if (e2 < 0) {
                    c.a.t0.j3.l0.d.i(advertAppInfo, i2, 33);
                } else if (e2 >= k && i5 > 3) {
                    c.a.t0.j3.l0.d.j(advertAppInfo, i2, 2, e2, k);
                } else {
                    c.a.t0.h.b.c cVar2 = new c.a.t0.h.b.c();
                    cVar2.d(advertAppInfo);
                    cVar2.e(advertAppInfo.getType().getId());
                    cVar2.f(3);
                    if (advertAppInfo.V4()) {
                        if (z.r(advertAppInfo.x4) && c.a.t0.a.h().F()) {
                            c.a.t0.j3.l0.d.i(advertAppInfo, i2, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.x4) && !TextUtils.isEmpty(advertAppInfo.s4)) {
                            hashSet.add(Integer.valueOf(e2));
                            if (e2 < k) {
                                c.a.t0.x1.o.k.a.b(list, cVar2, e2);
                            } else if (e2 == k) {
                                c.a.t0.x1.o.k.a.a(list, cVar2);
                            }
                        }
                    } else if (advertAppInfo.X4()) {
                        hashSet.add(Integer.valueOf(e2));
                        if (e2 < k) {
                            c.a.t0.x1.o.k.a.b(list, cVar2, e2);
                        } else if (e2 == k) {
                            c.a.t0.x1.o.k.a.a(list, cVar2);
                        }
                    } else {
                        c.a.t0.j3.l0.d.i(advertAppInfo, i2, 21);
                    }
                }
            }
            i6++;
            i3 = 0;
        }
    }

    @Override // c.a.t0.h.b.d
    public void i(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.a = list;
        }
    }

    @Override // c.a.t0.h.b.d
    public View k(int i2, View view, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        c.a.d.n.e.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), view, viewGroup, obj})) == null) {
            if (obj instanceof AdvertAppInfo) {
                AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
                BdUniqueId type = advertAppInfo.getType();
                if (type == AdvertAppInfo.D4) {
                    aVar = this.f18386e;
                } else if (type == AdvertAppInfo.A4) {
                    aVar = this.f18385d;
                } else if (type == AdvertAppInfo.E4) {
                    aVar = this.f18387f;
                } else if (type == AdvertAppInfo.F4) {
                    aVar = this.f18388g;
                } else {
                    aVar = type == AdvertAppInfo.G4 ? this.f18389h : null;
                }
                if (aVar != null) {
                    return aVar.E(i2, view, viewGroup, advertAppInfo);
                }
                return null;
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // c.a.t0.h.b.d
    public void l(int i2, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), viewGroup, viewHolder, obj}) == null) && (obj instanceof AdvertAppInfo)) {
            c.a.d.n.e.a aVar = null;
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.D4) {
                aVar = this.f18386e;
            } else if (type == AdvertAppInfo.A4) {
                aVar = this.f18385d;
            } else if (type == AdvertAppInfo.E4) {
                aVar = this.f18387f;
            } else if (type == AdvertAppInfo.F4) {
                aVar = this.f18388g;
            } else if (type == AdvertAppInfo.G4) {
                aVar = this.f18389h;
            }
            if (aVar != null) {
                aVar.T(i2, viewGroup, viewHolder, obj);
            }
        }
    }

    @Override // c.a.t0.h.b.d
    public void m(List<c.a.t0.h.b.c> list, List<c.a.t0.h.b.c> list2, boolean z, int i2) {
        ArrayList arrayList;
        int i3;
        int i4;
        int e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{list, list2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || c.a.t0.x1.o.k.a.e(this.a)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : this.a) {
            if (obj instanceof AdvertAppInfo) {
                c.a.t0.x1.o.k.a.a(arrayList2, (AdvertAppInfo) obj);
            }
        }
        Iterator<c.a.t0.h.b.c> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int k = c.a.t0.x1.o.k.a.k(list);
        int i5 = 0;
        int i6 = 0;
        for (c.a.t0.h.b.c cVar : list) {
            if (cVar.c() == 1) {
                i6++;
            }
        }
        int k2 = c.a.t0.x1.o.k.a.k(arrayList2);
        if (k2 < 1) {
            return;
        }
        int i7 = 9;
        if (c.a.t0.x1.o.k.a.k(arrayList2) > 1 && (e2 = (c.a.d.f.m.b.e(((AdvertAppInfo) c.a.t0.x1.o.k.a.d(arrayList2, 1)).l4, 0) - c.a.d.f.m.b.e(((AdvertAppInfo) c.a.t0.x1.o.k.a.d(arrayList2, 0)).l4, 0)) - 1) > 0) {
            i7 = e2;
        }
        int e3 = c.a.d.f.m.b.e(((AdvertAppInfo) c.a.t0.x1.o.k.a.d(arrayList2, 0)).l4, 0) - 1;
        int i8 = k - i6;
        HashSet hashSet = new HashSet();
        int i9 = 0;
        while (i9 < k2) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) c.a.t0.x1.o.k.a.d(arrayList2, i9);
            advertAppInfo.p4 = "SMART_FRS";
            int Y4 = advertAppInfo.Y4();
            if (Y4 != 0) {
                c.a.t0.j3.l0.d.i(advertAppInfo, i2, Y4);
                if (Y4 != 28 && Y4 != 31) {
                    advertAppInfo.h4 = -1001;
                }
                arrayList = arrayList2;
                i9++;
                arrayList2 = arrayList;
                i5 = 0;
            }
            if (advertAppInfo.getType() == null) {
                c.a.t0.j3.l0.d.i(advertAppInfo, i2, 100);
                arrayList = arrayList2;
                i9++;
                arrayList2 = arrayList;
                i5 = 0;
            } else {
                int e4 = c.a.d.f.m.b.e(advertAppInfo.l4, i5);
                int i10 = (e4 + i6) - 1;
                if (i10 < 0 || hashSet.contains(Integer.valueOf(i10)) || i10 > k) {
                    arrayList = arrayList2;
                    if (i10 > k) {
                        c.a.t0.j3.l0.d.j(advertAppInfo, i2, 2, i10, k);
                        i9++;
                        arrayList2 = arrayList;
                        i5 = 0;
                    } else {
                        i3 = i10 < 0 ? 33 : 29;
                    }
                } else {
                    if (e4 <= (i8 - i7) + e3 || !z) {
                        arrayList = arrayList2;
                    } else if (!c.a.t0.x1.o.k.a.e(list2)) {
                        int k3 = c.a.t0.x1.o.k.a.k(list2);
                        int i11 = (i7 - ((i8 - e4) + 1)) - 1;
                        int i12 = 0;
                        while (i12 < k3 && i12 < i11) {
                            arrayList = arrayList2;
                            if (((c.a.t0.h.b.c) c.a.t0.x1.o.k.a.d(list2, i12)).a() instanceof AdvertAppInfo) {
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
                        if (c.a.t0.a.h().E()) {
                            i3 = 36;
                        }
                    }
                    i3 = 0;
                }
                if (i3 != 0) {
                    c.a.t0.j3.l0.d.i(advertAppInfo, i2, i3);
                    i9++;
                    arrayList2 = arrayList;
                    i5 = 0;
                } else {
                    c.a.t0.h.b.c cVar2 = new c.a.t0.h.b.c();
                    cVar2.d(advertAppInfo);
                    cVar2.e(advertAppInfo.getType().getId());
                    cVar2.f(3);
                    if (advertAppInfo.V4()) {
                        if (z.r(advertAppInfo.x4) && c.a.t0.a.h().F()) {
                            c.a.t0.j3.l0.d.i(advertAppInfo, i2, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.x4) && !TextUtils.isEmpty(advertAppInfo.s4)) {
                            hashSet.add(Integer.valueOf(i10));
                            if (i10 < k) {
                                c.a.t0.x1.o.k.a.b(list, cVar2, i10);
                            } else if (i10 == k) {
                                c.a.t0.x1.o.k.a.a(list, cVar2);
                            }
                        }
                    } else if (advertAppInfo.X4()) {
                        hashSet.add(Integer.valueOf(i10));
                        if (i10 < k) {
                            c.a.t0.x1.o.k.a.b(list, cVar2, i10);
                        } else if (i10 == k) {
                            c.a.t0.x1.o.k.a.a(list, cVar2);
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
    @Override // c.a.t0.h.e.a
    /* renamed from: o */
    public void n(c.a.t0.h.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.f18383b = cVar;
            if (cVar == null || !(cVar.a() instanceof u)) {
                return;
            }
            this.f18384c = (u) this.f18383b.a();
            this.f18385d = new c.a.t0.j3.c0.c(this.f18384c, AdvertAppInfo.A4);
            this.f18386e = new c.a.t0.j3.c0.d(this.f18384c, AdvertAppInfo.D4);
            this.f18387f = new c.a.t0.j3.c0.d(this.f18384c, AdvertAppInfo.E4);
            this.f18388g = new c.a.t0.j3.c0.d(this.f18384c, AdvertAppInfo.F4);
            this.f18389h = new c.a.t0.j3.c0.d(this.f18384c, AdvertAppInfo.G4);
        }
    }

    @Override // c.a.t0.h.e.a
    public void setParams(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, map) == null) {
        }
    }
}
