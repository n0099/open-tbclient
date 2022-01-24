package c.a.t0.t2.y.g;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.n.e.n;
import c.a.s0.s.q.d2;
import c.a.s0.s.q.e2;
import c.a.t0.t2.r.k;
import c.a.t0.t2.r.q;
import c.a.t0.t2.r.r;
import c.a.t0.t2.r.x;
import c.a.t0.t2.u.f.m;
import c.a.t0.t2.u.f.n0;
import c.a.t0.x3.j0.p;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerAdapter;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public abstract class a extends c.a.t0.t2.y.i.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;

    /* renamed from: b  reason: collision with root package name */
    public DetailInfoAndReplyFragment f23560b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f23561c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.t0.t2.r.f f23562d;

    /* renamed from: e  reason: collision with root package name */
    public final List<c.a.d.n.e.a> f23563e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f23564f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f23565g;

    /* renamed from: h  reason: collision with root package name */
    public String f23566h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f23567i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f23568j;
    public int k;
    public int l;

    public a(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {detailInfoAndReplyFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = BdUniqueId.gen();
        this.f23563e = new ArrayList();
        this.f23564f = true;
        this.f23566h = null;
        this.f23567i = true;
        this.f23568j = false;
        this.k = -1;
        this.l = -1;
        this.f23560b = detailInfoAndReplyFragment;
        this.f23561c = bdTypeRecyclerView;
    }

    public abstract void A(View.OnClickListener onClickListener);

    public abstract void B(c.a.t0.t2.r.f fVar);

    public void C(c.a.t0.t2.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
        }
    }

    public abstract void D(c.a.t0.t2.r.f fVar);

    public abstract void E(String str);

    public final void F() {
        c.a.t0.t2.r.f fVar;
        p pVar;
        p pVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (fVar = this.f23562d) == null || fVar.a0 || fVar.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = fVar.F();
        ArrayList<p> e2 = this.f23562d.e();
        if (e2 == null || e2.isEmpty() || F == null || F.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<p> it = e2.iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (next != null && next.K0() != null) {
                sb.append(next.K0());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Iterator<p> it2 = e2.iterator();
        while (it2.hasNext()) {
            p next2 = it2.next();
            if (next2 != null) {
                next2.Q0 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<p> it3 = e2.iterator();
        while (it3.hasNext()) {
            p next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int Z4 = next3.getAdvertAppInfo().Z4();
                if (Z4 != 0) {
                    c.a.t0.k3.l0.d.k(next3, Z4);
                    if (Z4 != 28 && Z4 != 31) {
                        next3.getAdvertAppInfo().i4 = -1001;
                        String str = "updateAppData，Data InValidate: " + Z4;
                    }
                }
                sparseArray.put(next3.getPosition(), next3);
            }
        }
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            p pVar3 = (p) sparseArray.get(sparseArray.keyAt(i2));
            if (pVar3 != null && (pVar2 = (p) hashMap.put(pVar3.J0(), pVar3)) != null) {
                c.a.t0.k3.l0.d.k(pVar2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (pVar = (p) entry.getValue()) != null) {
                sparseArray.put(pVar.getPosition(), pVar);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            arrayList.add(Integer.valueOf(sparseArray.keyAt(i3)));
        }
        Collections.sort(arrayList);
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            p pVar4 = (p) sparseArray.get(((Integer) arrayList.get(i4)).intValue());
            if (this.f23562d.l() != null) {
                pVar4.K0 = this.f23562d.l().getId();
            }
            if (this.f23562d.O() != null) {
                pVar4.N0 = c.a.d.f.m.b.g(this.f23562d.O().h0(), 0L);
            }
            c.a.t0.t2.r.f fVar2 = this.f23562d;
            if (fVar2 != null && fVar2.y() != null) {
                pVar4.O0 = this.f23562d.y().a();
            }
            b(pVar4);
            int position = pVar4.getPosition() + this.f23562d.Z;
            if (position >= F.size()) {
                pVar4.Q0 = position;
                c.a.t0.k3.l0.d.l(pVar4, 2, position + i4, F.size());
                return;
            }
            if (!this.f23564f) {
                position--;
                pVar4.Q0 = position;
            }
            if (position < 0) {
                c.a.t0.k3.l0.d.k(pVar4, 23);
            } else if (h(F, position)) {
                c.a.t0.k3.l0.d.k(pVar4, 1);
            } else {
                F.add(position, pVar4);
                TiebaStatic.eventStat(this.f23560b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", pVar4.getAdvertAppInfo().y4);
            }
        }
    }

    @Override // c.a.t0.t2.y.i.a
    public ArrayList<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f23565g : (ArrayList) invokeV.objValue;
    }

    public final void b(p pVar) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, pVar) == null) || pVar == null || this.f23562d == null || pVar.getAdvertAppInfo() == null) {
            return;
        }
        pVar.getAdvertAppInfo().p4 = new c.a.s0.s.q.e();
        if (this.f23562d.y() != null) {
            pVar.getAdvertAppInfo().p4.f13536b = this.f23562d.y().a();
        }
        pVar.getAdvertAppInfo().p4.a = pVar.L0();
        if (this.f23562d.l() != null && (l = this.f23562d.l()) != null) {
            pVar.getAdvertAppInfo().p4.f13538d = l.getId();
            pVar.getAdvertAppInfo().p4.f13539e = l.getFirst_class();
            pVar.getAdvertAppInfo().p4.f13540f = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            pVar.getAdvertAppInfo().p4.f13541g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        pVar.getAdvertAppInfo().p4.f13542h = pVar.getAdvertAppInfo().n4;
        pVar.getAdvertAppInfo().p4.f13543i = false;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.l : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.k : invokeV.intValue;
    }

    public abstract n0 e();

    public abstract m f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public final boolean h(ArrayList<PostData> arrayList, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, arrayList, i2)) == null) {
            for (int max = Math.max(i2 - 4, 0); max < arrayList.size() && max < i2 + 4; max++) {
                if (arrayList.get(max) instanceof p) {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f23568j : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.f23560b.getPbModel() != null) {
                return this.f23560b.getPbModel().v0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (this.f23561c.getAdapter() instanceof BdRecyclerAdapter)) {
            this.f23561c.getAdapter().notifyDataSetChanged();
        }
    }

    public abstract void l();

    public abstract void m();

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            boolean z = false;
            boolean z2 = false;
            for (int i2 = 0; i2 < this.f23565g.size(); i2++) {
                n nVar = this.f23565g.get(i2);
                if (nVar instanceof q) {
                    this.k = i2;
                    z = true;
                } else if ((nVar instanceof c.a.t0.t2.r.e) && ((c.a.t0.t2.r.e) nVar).a() == this.a) {
                    this.l = i2;
                    z2 = true;
                }
            }
            if (!z) {
                this.k = -1;
            }
            if (z2) {
                return;
            }
            this.l = -1;
        }
    }

    public abstract void o(boolean z);

    public abstract void p(c.a.t0.t2.r.f fVar, boolean z, String str, boolean z2);

    public void q(c.a.t0.t2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, fVar) == null) {
            r(fVar, false);
        }
    }

    public void r(c.a.t0.t2.r.f fVar, boolean z) {
        p pVar;
        PostData postData;
        boolean z2;
        c.a.t0.t2.r.f fVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048599, this, fVar, z) == null) || fVar == null) {
            return;
        }
        this.f23562d = fVar;
        if (fVar != null && fVar.O() != null && fVar.O().J() != null) {
            this.f23566h = fVar.O().J().getUserId();
        }
        if (this.f23565g == null) {
            this.f23565g = new ArrayList<>();
        }
        this.f23565g.clear();
        Iterator<PostData> it = fVar.F().iterator();
        while (true) {
            pVar = null;
            if (!it.hasNext()) {
                postData = null;
                break;
            }
            PostData next = it.next();
            if (next instanceof PostData) {
                postData = next;
                if (postData.A() == 1) {
                    break;
                }
            }
        }
        if (postData == null && fVar.j() != null) {
            postData = fVar.j();
        }
        if (postData != null) {
            this.f23565g.add(postData);
        }
        D(fVar);
        E(this.f23566h);
        if (c.a.s0.g1.b.c.d()) {
            if (this.f23561c != null) {
                ArrayList<n> arrayList = this.f23565g;
                ListUtils.removeSubList(arrayList, 1, arrayList.size());
            }
            this.f23561c.setData(this.f23565g);
            return;
        }
        int i2 = 0;
        if (!ListUtils.isEmpty(fVar.F()) && fVar.F().get(0) != null && fVar.O() != null) {
            fVar.O().e4(fVar.F().get(0).H());
            fVar.O().g4(fVar.F().get(0).I());
        }
        if (fVar.O() != null && fVar.O().R0() != null) {
            d2 d2Var = new d2();
            d2Var.w = fVar.O();
            d2Var.r = true;
            this.f23565g.add(d2Var);
        }
        r rVar = new r(fVar.O(), fVar.d());
        rVar.k(false);
        rVar.f22724f = false;
        this.f23565g.add(rVar);
        if (postData == null || postData.s0 == null || (fVar.l() != null && TextUtils.equals(fVar.l().getName(), this.f23560b.getPbModel().r0()) && this.f23560b.getPbModel().x0())) {
            z2 = false;
        } else {
            c.a.t0.t2.r.i iVar = new c.a.t0.t2.r.i(postData.s0);
            iVar.f22697f = this.f23560b.getPbModel().h1();
            this.f23565g.add(iVar);
            z2 = true;
        }
        if (!z2 && fVar.l() != null && !StringUtils.isNull(fVar.l().getName()) && (!TextUtils.equals(fVar.l().getName(), this.f23560b.getPbModel().r0()) || !this.f23560b.getPbModel().x0())) {
            c.a.t0.t2.r.h hVar = new c.a.t0.t2.r.h(fVar.l());
            hVar.k = this.f23560b.getPbModel().h1();
            hVar.f22693i = false;
            this.f23565g.add(hVar);
            rVar.k(false);
            rVar.f22724f = false;
        }
        if (fVar.O() != null && !StringUtils.isNull(fVar.O().b0())) {
            x xVar = new x();
            xVar.f22746e = fVar.O();
            this.f23565g.add(xVar);
        } else if (fVar.O() != null && !StringUtils.isNull(fVar.n())) {
            fVar.O().N3(fVar.n());
            x xVar2 = new x();
            xVar2.f22746e = fVar.O();
            this.f23565g.add(xVar2);
        }
        q qVar = new q(q.l);
        e2 O = fVar.O();
        if (O != null) {
            O.W0();
        }
        this.f23560b.getPbModel().f1();
        qVar.f22719h = j();
        qVar.f22718g = fVar.f22685g;
        fVar.c();
        qVar.f22720i = fVar.g0();
        qVar.k = fVar.f22684f;
        B(fVar);
        this.f23565g.add(qVar);
        if (fVar.L() == 4) {
            this.f23565g.add(new c.a.t0.t2.r.p());
        }
        F();
        o(i());
        Iterator<PostData> it2 = fVar.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            PostData next2 = it2.next();
            if ((next2 instanceof PostData) && next2.A() != 1) {
                this.f23565g.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !l.z()) && ((fVar2 = this.f23562d) == null || !fVar2.t()))) {
            c.a.t0.t2.r.n nVar = new c.a.t0.t2.r.n();
            nVar.J0 = TbadkCoreApplication.getInst().getContext().getString(c.a.t0.t2.l.mention_replyme_nodata);
            nVar.I0 = c.a.t0.t2.h.new_pic_emotion_03;
            nVar.K0 = -2;
            nVar.L0 = c.a.d.f.p.n.f(this.f23560b.getContext(), c.a.t0.t2.g.tbds74);
            this.f23565g.add(nVar);
        }
        p(fVar, this.f23568j, this.f23566h, this.f23567i);
        if (fVar.y().b() == 0) {
            c.a.t0.t2.r.f fVar3 = this.f23562d;
            if (fVar3 != null && fVar3.t()) {
                A(this.f23560b.getVideoPbFragment().getListener());
                this.f23565g.add(new c.a.t0.t2.r.l());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.f23562d.m());
                statisticItem.param("fname", this.f23562d.n());
                statisticItem.param("tid", this.f23562d.Q());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                z(this.f23560b.getVideoPbFragment().getListener());
                k kVar = new k();
                kVar.f22700e = TbadkCoreApplication.getInst().getResources().getString(c.a.t0.t2.l.list_has_no_more);
                this.f23565g.add(kVar);
            }
            List<p> Y = fVar.Y();
            int i3 = -1;
            if (Y != null && !Y.isEmpty()) {
                pVar = Y.get(0);
                i3 = pVar.getPosition();
            }
            if (!ListUtils.isEmpty(fVar.f())) {
                c.a.t0.t2.r.e eVar = new c.a.t0.t2.r.e();
                eVar.g(TbadkCoreApplication.getInst().getString(c.a.t0.t2.l.related_recommendation));
                eVar.e(this.a);
                this.f23565g.add(eVar);
                int i4 = 1;
                for (c.a.s0.s.q.q qVar2 : fVar.f()) {
                    if (Y != null && i4 == i3) {
                        if (pVar != null) {
                            b(pVar);
                            this.f23565g.add(pVar);
                            i2++;
                            if (pVar.getType() != AdvertAppInfo.C4) {
                                i4++;
                            }
                        }
                        if (i2 < Y.size()) {
                            p pVar2 = Y.get(i2);
                            pVar = pVar2;
                            i3 = pVar2.getPosition();
                        }
                    }
                    this.f23565g.add(qVar2);
                    i4++;
                    if (i4 == 4 && fVar.C() != null) {
                        this.f23565g.add(fVar.C());
                        i4++;
                    }
                }
            }
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.f23561c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setData(this.f23565g);
        }
        n();
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.f23568j = z;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.f23564f = z;
        }
    }

    public void u(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, onClickListener) == null) {
        }
    }

    public void v(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, yVar) == null) {
        }
    }

    public void w(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, onLongClickListener) == null) {
        }
    }

    public void x(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, fVar) == null) {
        }
    }

    public void y(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, onClickListener) == null) {
        }
    }

    public abstract void z(View.OnClickListener onClickListener);
}
