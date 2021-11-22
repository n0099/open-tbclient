package b.a.r0.a3;

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
public class i implements b.a.r0.g.b.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<Object> f15720a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.r0.g.e.c f15721b;

    /* renamed from: c  reason: collision with root package name */
    public u f15722c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.e.m.e.a f15723d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.e.m.e.a f15724e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.e.m.e.a f15725f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.e.m.e.a f15726g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.e.m.e.a f15727h;

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

    @Override // b.a.r0.g.b.d
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
        }
    }

    @Override // b.a.r0.g.e.a
    public void b(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) {
        }
    }

    @Override // b.a.r0.g.b.d
    public List<Integer> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(AdvertAppInfo.v4.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.s4.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.w4.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.x4.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.y4.getId()));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // b.a.r0.g.b.d
    public void e(List<b.a.r0.g.b.c> list, String str, String str2, String str3, String str4, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{list, str, str2, str3, str4, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || b.a.r0.q1.o.k.a.e(list)) {
            return;
        }
        Set<b.a.e.m.e.n> a2 = b.a.r0.a3.l0.a.a("FRS");
        if (a2 == null) {
            a2 = new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (b.a.r0.g.b.c cVar : list) {
            if (cVar != null) {
                Object a3 = cVar.a();
                for (b.a.e.m.e.n nVar : a2) {
                    if (a3 != null && cVar.c() == 3 && (a3 instanceof AdvertAppInfo) && nVar != null && (nVar instanceof AdvertAppInfo) && a3.hashCode() == nVar.hashCode()) {
                        ((AdvertAppInfo) a3).h4 = ((AdvertAppInfo) nVar).h4;
                    }
                }
                if (a3 != null && cVar.c() == 3 && (a3 instanceof AdvertAppInfo)) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) a3;
                    if (advertAppInfo.h4 == null) {
                        b.a.q0.s.q.e eVar = new b.a.q0.s.q.e();
                        advertAppInfo.h4 = eVar;
                        eVar.f14056a = "FRS";
                        eVar.f14058c = String.valueOf(z);
                        b.a.q0.s.q.e eVar2 = advertAppInfo.h4;
                        eVar2.f14057b = i2;
                        eVar2.f14059d = str;
                        eVar2.f14060e = str2;
                        eVar2.f14061f = str3;
                        eVar2.f14062g = str4;
                        eVar2.f14063h = advertAppInfo.f4;
                        eVar2.f14064i = false;
                        hashSet.add(advertAppInfo);
                    }
                }
            }
        }
        a2.addAll(hashSet);
        b.a.r0.a3.l0.a.b("FRS", a2);
    }

    @Override // b.a.r0.g.b.d
    public TypeAdapter.ViewHolder f(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        b.a.e.m.e.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, viewGroup, obj)) == null) {
            if (obj instanceof AdvertAppInfo) {
                BdUniqueId type = ((AdvertAppInfo) obj).getType();
                if (type == AdvertAppInfo.v4) {
                    aVar = this.f15724e;
                } else if (type == AdvertAppInfo.s4) {
                    aVar = this.f15723d;
                } else if (type == AdvertAppInfo.w4) {
                    aVar = this.f15725f;
                } else if (type == AdvertAppInfo.x4) {
                    aVar = this.f15726g;
                } else {
                    aVar = type == AdvertAppInfo.y4 ? this.f15727h : null;
                }
                if (aVar != null) {
                    return aVar.U(viewGroup, obj);
                }
                return null;
            }
            return null;
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    @Override // b.a.r0.g.b.d
    public void h(List<b.a.r0.g.b.c> list, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, list, i2) == null) || b.a.r0.q1.o.k.a.e(this.f15720a)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.f15720a) {
            if (obj instanceof AdvertAppInfo) {
                b.a.r0.q1.o.k.a.a(arrayList, (AdvertAppInfo) obj);
            }
        }
        Iterator<b.a.r0.g.b.c> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int k = b.a.r0.q1.o.k.a.k(list);
        int i3 = 0;
        int i4 = 0;
        for (b.a.r0.g.b.c cVar : list) {
            if (cVar.c() == 1) {
                i4++;
            }
        }
        int k2 = b.a.r0.q1.o.k.a.k(arrayList);
        if (k2 < 1) {
            return;
        }
        int i5 = k - i4;
        HashSet hashSet = new HashSet();
        int i6 = 0;
        while (i6 < k2) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) b.a.r0.q1.o.k.a.d(arrayList, i6);
            advertAppInfo.i4 = "FRS";
            int W4 = advertAppInfo.W4();
            if (W4 != 0) {
                b.a.r0.a3.l0.d.i(advertAppInfo, i2, W4);
                if (W4 != 28 && W4 != 31) {
                    advertAppInfo.a4 = -1001;
                }
                i6++;
                i3 = 0;
            }
            if (advertAppInfo.getType() == null) {
                b.a.r0.a3.l0.d.i(advertAppInfo, i2, 100);
            } else {
                int e2 = (b.a.e.f.m.b.e(advertAppInfo.e4, i3) + i4) - 1;
                if (hashSet.contains(Integer.valueOf(e2))) {
                    b.a.r0.a3.l0.d.i(advertAppInfo, i2, 29);
                } else if (e2 < 0) {
                    b.a.r0.a3.l0.d.i(advertAppInfo, i2, 33);
                } else if (e2 >= k && i5 > 3) {
                    b.a.r0.a3.l0.d.j(advertAppInfo, i2, 2, e2, k);
                } else {
                    b.a.r0.g.b.c cVar2 = new b.a.r0.g.b.c();
                    cVar2.d(advertAppInfo);
                    cVar2.e(advertAppInfo.getType().getId());
                    cVar2.f(3);
                    if (advertAppInfo.T4()) {
                        if (z.q(advertAppInfo.q4) && b.a.r0.a.h().E()) {
                            b.a.r0.a3.l0.d.i(advertAppInfo, i2, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.q4) && !TextUtils.isEmpty(advertAppInfo.l4)) {
                            hashSet.add(Integer.valueOf(e2));
                            if (e2 < k) {
                                b.a.r0.q1.o.k.a.b(list, cVar2, e2);
                            } else if (e2 == k) {
                                b.a.r0.q1.o.k.a.a(list, cVar2);
                            }
                        }
                    } else if (advertAppInfo.V4()) {
                        hashSet.add(Integer.valueOf(e2));
                        if (e2 < k) {
                            b.a.r0.q1.o.k.a.b(list, cVar2, e2);
                        } else if (e2 == k) {
                            b.a.r0.q1.o.k.a.a(list, cVar2);
                        }
                    } else {
                        b.a.r0.a3.l0.d.i(advertAppInfo, i2, 21);
                    }
                }
            }
            i6++;
            i3 = 0;
        }
    }

    @Override // b.a.r0.g.b.d
    public void j(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.f15720a = list;
        }
    }

    @Override // b.a.r0.g.b.d
    public View l(int i2, View view, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        b.a.e.m.e.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), view, viewGroup, obj})) == null) {
            if (obj instanceof AdvertAppInfo) {
                AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
                BdUniqueId type = advertAppInfo.getType();
                if (type == AdvertAppInfo.v4) {
                    aVar = this.f15724e;
                } else if (type == AdvertAppInfo.s4) {
                    aVar = this.f15723d;
                } else if (type == AdvertAppInfo.w4) {
                    aVar = this.f15725f;
                } else if (type == AdvertAppInfo.x4) {
                    aVar = this.f15726g;
                } else {
                    aVar = type == AdvertAppInfo.y4 ? this.f15727h : null;
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

    @Override // b.a.r0.g.b.d
    public void m(int i2, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), viewGroup, viewHolder, obj}) == null) && (obj instanceof AdvertAppInfo)) {
            b.a.e.m.e.a aVar = null;
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.v4) {
                aVar = this.f15724e;
            } else if (type == AdvertAppInfo.s4) {
                aVar = this.f15723d;
            } else if (type == AdvertAppInfo.w4) {
                aVar = this.f15725f;
            } else if (type == AdvertAppInfo.x4) {
                aVar = this.f15726g;
            } else if (type == AdvertAppInfo.y4) {
                aVar = this.f15727h;
            }
            if (aVar != null) {
                aVar.a0(i2, viewGroup, viewHolder, obj);
            }
        }
    }

    @Override // b.a.r0.g.b.d
    public void n(List<b.a.r0.g.b.c> list, List<b.a.r0.g.b.c> list2, boolean z, int i2) {
        ArrayList arrayList;
        int i3;
        int i4;
        int e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{list, list2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || b.a.r0.q1.o.k.a.e(this.f15720a)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : this.f15720a) {
            if (obj instanceof AdvertAppInfo) {
                b.a.r0.q1.o.k.a.a(arrayList2, (AdvertAppInfo) obj);
            }
        }
        Iterator<b.a.r0.g.b.c> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int k = b.a.r0.q1.o.k.a.k(list);
        int i5 = 0;
        int i6 = 0;
        for (b.a.r0.g.b.c cVar : list) {
            if (cVar.c() == 1) {
                i6++;
            }
        }
        int k2 = b.a.r0.q1.o.k.a.k(arrayList2);
        if (k2 < 1) {
            return;
        }
        int i7 = 9;
        if (b.a.r0.q1.o.k.a.k(arrayList2) > 1 && (e2 = (b.a.e.f.m.b.e(((AdvertAppInfo) b.a.r0.q1.o.k.a.d(arrayList2, 1)).e4, 0) - b.a.e.f.m.b.e(((AdvertAppInfo) b.a.r0.q1.o.k.a.d(arrayList2, 0)).e4, 0)) - 1) > 0) {
            i7 = e2;
        }
        int e3 = b.a.e.f.m.b.e(((AdvertAppInfo) b.a.r0.q1.o.k.a.d(arrayList2, 0)).e4, 0) - 1;
        int i8 = k - i6;
        HashSet hashSet = new HashSet();
        int i9 = 0;
        while (i9 < k2) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) b.a.r0.q1.o.k.a.d(arrayList2, i9);
            advertAppInfo.i4 = "SMART_FRS";
            int W4 = advertAppInfo.W4();
            if (W4 != 0) {
                b.a.r0.a3.l0.d.i(advertAppInfo, i2, W4);
                if (W4 != 28 && W4 != 31) {
                    advertAppInfo.a4 = -1001;
                }
                arrayList = arrayList2;
                i9++;
                arrayList2 = arrayList;
                i5 = 0;
            }
            if (advertAppInfo.getType() == null) {
                b.a.r0.a3.l0.d.i(advertAppInfo, i2, 100);
                arrayList = arrayList2;
                i9++;
                arrayList2 = arrayList;
                i5 = 0;
            } else {
                int e4 = b.a.e.f.m.b.e(advertAppInfo.e4, i5);
                int i10 = (e4 + i6) - 1;
                if (i10 < 0 || hashSet.contains(Integer.valueOf(i10)) || i10 > k) {
                    arrayList = arrayList2;
                    if (i10 > k) {
                        b.a.r0.a3.l0.d.j(advertAppInfo, i2, 2, i10, k);
                        i9++;
                        arrayList2 = arrayList;
                        i5 = 0;
                    } else {
                        i3 = i10 < 0 ? 33 : 29;
                    }
                } else {
                    if (e4 <= (i8 - i7) + e3 || !z) {
                        arrayList = arrayList2;
                    } else if (!b.a.r0.q1.o.k.a.e(list2)) {
                        int k3 = b.a.r0.q1.o.k.a.k(list2);
                        int i11 = (i7 - ((i8 - e4) + 1)) - 1;
                        int i12 = 0;
                        while (i12 < k3 && i12 < i11) {
                            arrayList = arrayList2;
                            if (((b.a.r0.g.b.c) b.a.r0.q1.o.k.a.d(list2, i12)).a() instanceof AdvertAppInfo) {
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
                        if (b.a.r0.a.h().D()) {
                            i3 = 36;
                        }
                    }
                    i3 = 0;
                }
                if (i3 != 0) {
                    b.a.r0.a3.l0.d.i(advertAppInfo, i2, i3);
                    i9++;
                    arrayList2 = arrayList;
                    i5 = 0;
                } else {
                    b.a.r0.g.b.c cVar2 = new b.a.r0.g.b.c();
                    cVar2.d(advertAppInfo);
                    cVar2.e(advertAppInfo.getType().getId());
                    cVar2.f(3);
                    if (advertAppInfo.T4()) {
                        if (z.q(advertAppInfo.q4) && b.a.r0.a.h().E()) {
                            b.a.r0.a3.l0.d.i(advertAppInfo, i2, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.q4) && !TextUtils.isEmpty(advertAppInfo.l4)) {
                            hashSet.add(Integer.valueOf(i10));
                            if (i10 < k) {
                                b.a.r0.q1.o.k.a.b(list, cVar2, i10);
                            } else if (i10 == k) {
                                b.a.r0.q1.o.k.a.a(list, cVar2);
                            }
                        }
                    } else if (advertAppInfo.V4()) {
                        hashSet.add(Integer.valueOf(i10));
                        if (i10 < k) {
                            b.a.r0.q1.o.k.a.b(list, cVar2, i10);
                        } else if (i10 == k) {
                            b.a.r0.q1.o.k.a.a(list, cVar2);
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
    @Override // b.a.r0.g.e.a
    /* renamed from: p */
    public void o(b.a.r0.g.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.f15721b = cVar;
            if (cVar == null || !(cVar.a() instanceof u)) {
                return;
            }
            this.f15722c = (u) this.f15721b.a();
            this.f15723d = new b.a.r0.a3.c0.c(this.f15722c, AdvertAppInfo.s4);
            this.f15724e = new b.a.r0.a3.c0.d(this.f15722c, AdvertAppInfo.v4);
            this.f15725f = new b.a.r0.a3.c0.d(this.f15722c, AdvertAppInfo.w4);
            this.f15726g = new b.a.r0.a3.c0.d(this.f15722c, AdvertAppInfo.x4);
            this.f15727h = new b.a.r0.a3.c0.d(this.f15722c, AdvertAppInfo.y4);
        }
    }
}
