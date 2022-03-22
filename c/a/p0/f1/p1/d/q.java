package c.a.p0.f1.p1.d;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.r.a2;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.adapter.FrsUserRecommendAdapter;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class q implements e0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.d.o.e.s f14346b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.d.o.e.a> f14347c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<Integer, ThreadData> f14348d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<c.a.d.o.e.n> f14349e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f14350f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14351g;

    /* renamed from: h  reason: collision with root package name */
    public final c.a.p0.f1.i f14352h;
    public d0 i;
    public c.a.d.o.e.a j;
    public y k;
    public k l;
    public v m;
    public s n;
    public j o;
    public m p;
    public w q;
    public a0 r;
    public u s;
    public r t;
    public z u;
    public l v;
    public t w;

    public q(FrsFragment frsFragment, c.a.d.o.e.s sVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, sVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14347c = new LinkedList();
        this.f14351g = false;
        this.f14346b = sVar;
        this.f14352h = new c.a.p0.f1.i();
        p(frsFragment, sVar);
        this.f14348d = new HashMap<>();
        n(z);
    }

    @Override // c.a.p0.f1.p1.d.e0
    public void a(String str) {
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (list = this.f14347c) == null) {
            return;
        }
        for (c.a.d.o.e.a aVar : list) {
            if (aVar instanceof c.a.p0.h0.z) {
                ((c.a.p0.h0.z) aVar).a(str);
            }
        }
    }

    @Override // c.a.p0.f1.p1.d.e0
    public void b() {
        c.a.d.o.e.s sVar;
        List<c.a.d.o.e.n> data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f14346b) == null || sVar.getData() == null || this.f14346b.getData().size() == 0 || (data = this.f14346b.getData()) == null || data.size() == 0) {
            return;
        }
        for (c.a.d.o.e.n nVar : data) {
            if (nVar instanceof ThreadData) {
                ThreadData threadData = (ThreadData) nVar;
                if (threadData.getIs_top() != 0) {
                    threadData.parser_title();
                }
            } else if (nVar instanceof a2) {
                a2 a2Var = (a2) nVar;
                if (a2Var.s.getIs_top() != 0) {
                    a2Var.s.parser_title();
                }
            }
        }
    }

    @Override // c.a.p0.f1.p1.d.e0
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090aee;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.p0.f1.p1.d.e0
    public void d(c.a.d.o.e.w wVar) {
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, wVar) == null) || (list = this.f14347c) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f14347c) {
            if (aVar instanceof c.a.p0.f1.k) {
                ((c.a.p0.f1.k) aVar).V(wVar);
            } else if ((aVar instanceof t) || (aVar instanceof z)) {
                aVar.V(wVar);
            }
        }
    }

    @Override // c.a.p0.f1.p1.d.e0
    public void e() {
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (list = this.f14347c) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f14347c) {
            if (aVar instanceof c.a.p0.f1.k) {
                ((c.a.p0.f1.k) aVar).o(this.a.getPageContext(), this.a.getUniqueId());
            }
        }
        z(this.f14347c);
    }

    @Override // c.a.p0.f1.p1.d.e0
    public List<c.a.d.o.e.n> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.d.o.e.s sVar = this.f14346b;
            if (sVar != null) {
                return sVar.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // c.a.p0.f1.p1.d.e0
    public void g(ArrayList<c.a.d.o.e.n> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            c.a.p0.a4.x.f(arrayList, 1);
            o(arrayList);
            x(arrayList);
            s(arrayList);
            Iterator<c.a.d.o.e.n> it = arrayList.iterator();
            while (it.hasNext()) {
                c.a.d.o.e.n next = it.next();
                if ((next instanceof a2) && ((a2) next).s.isTop()) {
                    it.remove();
                }
            }
            this.f14346b.setData(arrayList);
            this.f14350f = frsViewData;
            w();
            y();
            this.f14349e = arrayList;
        }
    }

    @Override // c.a.p0.f1.p1.d.e0
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f14348d : (HashMap) invokeV.objValue;
    }

    @Override // c.a.p0.f1.p1.d.e0
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090ac9;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.p0.f1.p1.d.e0
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090b96;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.p0.f1.p1.d.e0
    public boolean k(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (c.a.d.o.e.a aVar : this.f14347c) {
                if (aVar != null && aVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.p0.f1.p1.d.e0
    public void l(c.a.p0.f1.f fVar) {
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) || (list = this.f14347c) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f14347c) {
            if (aVar instanceof c.a.p0.f1.k) {
                ((c.a.p0.f1.k) aVar).e0(fVar);
            }
        }
    }

    @Override // c.a.p0.f1.p1.d.e0
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            for (c.a.d.o.e.a aVar : this.f14347c) {
                if (aVar instanceof c.a.p0.f1.k) {
                    ((c.a.p0.f1.k) aVar).c0();
                } else if (aVar instanceof c.a.p0.l3.p) {
                    ((c.a.p0.l3.p) aVar).onDestroy();
                }
            }
        }
    }

    @Override // c.a.p0.f1.p1.d.e0
    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || this.f14351g == z) {
            return;
        }
        this.f14351g = z;
    }

    @Override // c.a.p0.f1.p1.d.e0
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.f14346b.getListAdapter() == null) {
            return;
        }
        this.f14346b.getListAdapter().notifyDataSetChanged();
    }

    public final ArrayList<Integer> o(ArrayList<c.a.d.o.e.n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, arrayList)) == null) {
            if (arrayList == null || arrayList.size() == 0) {
                return null;
            }
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            for (int i = 0; i < arrayList.size(); i++) {
                c.a.d.o.e.n nVar = arrayList.get(i);
                if (nVar instanceof AdvertAppInfo) {
                    arrayList2.add(Integer.valueOf(i));
                    HashMap<Integer, ThreadData> hashMap = this.f14348d;
                    if (hashMap != null && !hashMap.containsValue(nVar)) {
                        this.f14348d.put(Integer.valueOf(i), (ThreadData) nVar);
                    }
                }
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void p(FrsFragment frsFragment, c.a.d.o.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, frsFragment, sVar) == null) {
            this.a = frsFragment;
            this.j = c.a.p0.f1.e.e().c(frsFragment.getPageContext(), c.a.p0.a4.a0.f12164d, this.a.getUniqueId(), false);
            y yVar = new y(frsFragment.j(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = yVar;
            yVar.h0(sVar);
            k kVar = new k(frsFragment.j(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = kVar;
            kVar.h0(sVar);
            v vVar = new v(frsFragment.j(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = vVar;
            vVar.h0(sVar);
            s sVar2 = new s(frsFragment.j(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = sVar2;
            sVar2.h0(sVar);
            j jVar = new j(frsFragment.j(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = jVar;
            jVar.h0(sVar);
            m mVar = new m(frsFragment.j(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = mVar;
            mVar.h0(sVar);
            a0 a0Var = new a0(frsFragment.j(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = a0Var;
            a0Var.h0(sVar);
            w wVar = new w(frsFragment.j(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = wVar;
            wVar.h0(sVar);
            u uVar = new u(frsFragment.j(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = uVar;
            uVar.h0(sVar);
            r rVar = new r(frsFragment.j(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = rVar;
            rVar.h0(sVar);
            z zVar = new z(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = zVar;
            zVar.h0(sVar);
            l lVar = new l(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = lVar;
            lVar.h0(sVar);
            p pVar = new p(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            pVar.h0(sVar);
            x xVar = new x(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            xVar.h0(sVar);
            a aVar = new a(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            aVar.h0(sVar);
            aVar.r(1);
            c cVar = new c(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            cVar.h0(sVar);
            b bVar = new b(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            bVar.h0(sVar);
            bVar.K0(true);
            g gVar = new g(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            gVar.h0(sVar);
            gVar.K0(true);
            h hVar = new h(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            hVar.h0(sVar);
            hVar.L0(true);
            z zVar2 = new z(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            zVar2.h0(sVar);
            o oVar = new o(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            oVar.h0(sVar);
            n nVar = new n(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            nVar.h0(sVar);
            this.i = new d0(frsFragment.getPageContext(), c.a.p0.a4.s.f12379c, this.a.getUniqueId());
            t tVar = new t(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = tVar;
            tVar.h0(sVar);
            c.a.d.o.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> a = c.a.p0.f1.e.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            c.a.d.o.e.a<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d2 = c.a.p0.f1.e.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            c.a.p0.f1.r rVar2 = new c.a.p0.f1.r(frsFragment.getPageContext(), c.a.p0.f1.s.f14508b);
            i iVar = new i(frsFragment.getPageContext(), c.a.p0.f1.u.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), c.a.p0.f1.w.f14796e, this.a.getUniqueId());
            e eVar = new e(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            eVar.c0((BdTypeRecyclerView) sVar);
            this.f14347c.add(this.j);
            this.f14347c.add(this.k);
            this.f14347c.add(this.l);
            this.f14347c.add(this.m);
            this.f14347c.add(this.n);
            this.f14347c.add(this.o);
            this.f14347c.add(this.p);
            this.f14347c.add(this.q);
            this.f14347c.add(this.r);
            this.f14347c.add(this.s);
            this.f14347c.add(this.t);
            this.f14347c.add(this.i);
            this.f14347c.add(pVar);
            this.f14347c.add(xVar);
            this.f14347c.add(aVar);
            this.f14347c.add(cVar);
            this.f14347c.add(bVar);
            this.f14347c.add(gVar);
            this.f14347c.add(hVar);
            this.f14347c.add(this.w);
            this.f14347c.add(this.u);
            this.f14347c.add(this.v);
            this.f14347c.add(a);
            this.f14347c.add(d2);
            this.f14347c.add(rVar2);
            this.f14347c.add(iVar);
            this.f14347c.add(oVar);
            this.f14347c.add(nVar);
            this.f14347c.add(frsUserRecommendAdapter);
            this.f14347c.add(zVar2);
            this.f14347c.add(eVar);
            this.f14347c.add(c.a.p0.g1.c.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.H));
            c.a.p0.h.f.b bVar2 = new c.a.p0.h.f.b(this.a, 1);
            bVar2.t(this.f14347c);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            z(this.f14347c);
            sVar.a(this.f14347c);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            t("page_frs");
            if (absDelegateAdapterList.isEmpty()) {
                return;
            }
            Iterator<c.a.d.o.e.a<?, ?>> it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                c.a.d.o.e.a<?, ?> next = it.next();
                if (next instanceof c.a.p0.f1.k) {
                    ((c.a.p0.f1.k) next).o(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            List<c.a.d.o.e.a> list = this.f14347c;
            if (list != null) {
                list.addAll(arrayList);
            }
            c.a.d.o.e.s sVar3 = this.f14346b;
            if (sVar3 != null) {
                sVar3.a(arrayList);
            }
        }
    }

    public final boolean q(c.a.d.o.e.n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, nVar)) == null) {
            if (nVar == null) {
                return false;
            }
            BdUniqueId type = nVar.getType();
            return type == ThreadData.TYPE_NORMAL || type == ThreadData.TYPE_GOD_NORMAL || type == ThreadData.TYPE_VIDEO || type == ThreadData.TYPE_VIDEO_GOD || type == ThreadData.TYPE_INSERT_VIDEO;
        }
        return invokeL.booleanValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ArrayList<c.a.d.o.e.n> arrayList = this.f14349e;
            if (arrayList != null) {
                this.f14346b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    public final void s(ArrayList<c.a.d.o.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i = 0; i < count; i++) {
                c.a.d.o.e.n nVar = (c.a.d.o.e.n) ListUtils.getItem(arrayList, i - 1);
                c.a.d.o.e.n nVar2 = (c.a.d.o.e.n) ListUtils.getItem(arrayList, i);
                if (nVar2 instanceof a2) {
                    ThreadData threadData = ((a2) nVar2).s;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (nVar instanceof c.a.p0.f1.u) {
                        threadData.needTopMargin = false;
                    } else if (nVar != null && !q(nVar)) {
                        threadData.needTopMargin = false;
                    } else if ((nVar instanceof a2) && q(nVar) && !TextUtils.isEmpty(((a2) nVar).s.getRecomReason())) {
                        threadData.needTopMargin = true;
                    } else if (q(nVar2) && !TextUtils.isEmpty(recomReason)) {
                        threadData.needTopMargin = true;
                    } else {
                        threadData.needTopMargin = false;
                    }
                }
            }
        }
    }

    @Override // c.a.p0.f1.p1.d.e0
    public void setFromCDN(boolean z) {
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (list = this.f14347c) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f14347c) {
            if (aVar instanceof c.a.p0.f1.k) {
                ((c.a.p0.f1.k) aVar).setFromCDN(z);
            }
        }
        y yVar = this.k;
        if (yVar != null) {
            yVar.setFromCDN(z);
        }
        k kVar = this.l;
        if (kVar != null) {
            kVar.setFromCDN(z);
        }
        v vVar = this.m;
        if (vVar != null) {
            vVar.setFromCDN(z);
        }
        s sVar = this.n;
        if (sVar != null) {
            sVar.setFromCDN(z);
        }
        j jVar = this.o;
        if (jVar != null) {
            jVar.setFromCDN(z);
        }
        m mVar = this.p;
        if (mVar != null) {
            mVar.setFromCDN(z);
        }
        z zVar = this.u;
        if (zVar != null) {
            zVar.setFromCDN(z);
        }
        t tVar = this.w;
        if (tVar != null) {
            tVar.setFromCDN(z);
        }
    }

    public final void t(String str) {
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, str) == null) || (list = this.f14347c) == null) {
            return;
        }
        for (c.a.d.o.e.a aVar : list) {
            if (aVar instanceof c.a.p0.v.f) {
                ((c.a.p0.v.f) aVar).g(str);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || ListUtils.isEmpty(this.f14347c) || this.a == null) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f14347c) {
            if (aVar instanceof c.a.p0.f1.k) {
                ((c.a.p0.f1.k) aVar).j0(this.a.getTbPageTag());
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, frsViewData) == null) || (list = this.f14347c) == null || list.size() == 0) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f14347c) {
            if (aVar instanceof c.a.p0.f1.k) {
                ((c.a.p0.f1.k) aVar).f0(frsViewData);
            }
        }
    }

    public final void w() {
        c.a.p0.f1.o2.b j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.f14350f == null) {
            return;
        }
        for (c.a.d.o.e.a aVar : this.f14347c) {
            if ((aVar instanceof c.a.p0.f1.o2.d) && (j = ((c.a.p0.f1.o2.d) aVar).j()) != null) {
                if (this.f14350f.needLog == 1) {
                    j.a = true;
                } else {
                    j.a = false;
                }
                if (this.f14350f.getForum() != null) {
                    j.f14300c = this.f14350f.getForum().getId();
                    j.f14301d = this.f14350f.getForum().getName();
                }
                FrsFragment frsFragment = this.a;
                if (frsFragment != null && frsFragment.b0() != null) {
                    int T = this.a.b0().T();
                    if (T == -1) {
                        T = this.a.b0().S();
                    }
                    j.f14299b = T;
                }
            }
        }
    }

    public final void x(ArrayList<c.a.d.o.e.n> arrayList) {
        List<c.a.d.o.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, arrayList) == null) || (list = this.f14347c) == null || list.size() == 0) {
            return;
        }
        int i = 0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<c.a.d.o.e.n> it = arrayList.iterator();
            while (it.hasNext() && it.next().getType().getId() == ThreadData.TYPE_TOP.getId()) {
                i++;
            }
        }
        for (c.a.d.o.e.a aVar : this.f14347c) {
            if (aVar instanceof c.a.p0.f1.k) {
                ((c.a.p0.f1.k) aVar).k0(i);
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        d0 d0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (frsViewData = this.f14350f) == null || frsViewData.getForum() == null || StringUtils.isNull(this.f14350f.getForum().getId()) || (d0Var = this.i) == null) {
            return;
        }
        d0Var.q0(this.f14350f.getForum().getId());
    }

    public final void z(List<c.a.d.o.e.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, list) == null) || list == null) {
            return;
        }
        for (c.a.d.o.e.a aVar : list) {
            if (aVar instanceof c.a.p0.f1.k) {
                ((c.a.p0.f1.k) aVar).d0(this.f14352h);
            }
        }
    }
}
