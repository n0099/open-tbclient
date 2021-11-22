package b.a.r0.k2.y.f;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.e.m.e.n;
import b.a.q0.s.q.c2;
import b.a.q0.s.q.d2;
import b.a.r0.k2.r.k;
import b.a.r0.k2.r.q;
import b.a.r0.k2.r.r;
import b.a.r0.k2.r.x;
import b.a.r0.k2.u.f.l;
import b.a.r0.k2.u.f.m0;
import b.a.r0.m3.j0.p;
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
/* loaded from: classes5.dex */
public abstract class a extends b.a.r0.k2.y.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final BdUniqueId f21296a;

    /* renamed from: b  reason: collision with root package name */
    public DetailInfoAndReplyFragment f21297b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f21298c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.k2.r.f f21299d;

    /* renamed from: e  reason: collision with root package name */
    public final List<b.a.e.m.e.a> f21300e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f21301f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f21302g;

    /* renamed from: h  reason: collision with root package name */
    public String f21303h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f21304i;
    public boolean j;
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
        this.f21296a = BdUniqueId.gen();
        this.f21300e = new ArrayList();
        this.f21301f = true;
        this.f21303h = null;
        this.f21304i = true;
        this.j = false;
        this.k = -1;
        this.l = -1;
        this.f21297b = detailInfoAndReplyFragment;
        this.f21298c = bdTypeRecyclerView;
    }

    public abstract void A(View.OnClickListener onClickListener);

    public abstract void B(b.a.r0.k2.r.f fVar);

    public void C(b.a.r0.k2.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
        }
    }

    public abstract void D(b.a.r0.k2.r.f fVar);

    public abstract void E(String str);

    public final void F() {
        b.a.r0.k2.r.f fVar;
        p pVar;
        p pVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (fVar = this.f21299d) == null || fVar.a0 || fVar.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = fVar.F();
        ArrayList<p> e2 = this.f21299d.e();
        if (e2 == null || e2.isEmpty() || F == null || F.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<p> it = e2.iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (next != null && next.J0() != null) {
                sb.append(next.J0());
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
                next2.O0 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<p> it3 = e2.iterator();
        while (it3.hasNext()) {
            p next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int W4 = next3.getAdvertAppInfo().W4();
                if (W4 != 0) {
                    b.a.r0.a3.l0.d.k(next3, W4);
                    if (W4 != 28 && W4 != 31) {
                        next3.getAdvertAppInfo().a4 = -1001;
                        String str = "updateAppData，Data InValidate: " + W4;
                    }
                }
                sparseArray.put(next3.getPosition(), next3);
            }
        }
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            p pVar3 = (p) sparseArray.get(sparseArray.keyAt(i2));
            if (pVar3 != null && (pVar2 = (p) hashMap.put(pVar3.I0(), pVar3)) != null) {
                b.a.r0.a3.l0.d.k(pVar2, 30);
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
            if (this.f21299d.l() != null) {
                pVar4.I0 = this.f21299d.l().getId();
            }
            if (this.f21299d.O() != null) {
                pVar4.L0 = b.a.e.f.m.b.g(this.f21299d.O().f0(), 0L);
            }
            b.a.r0.k2.r.f fVar2 = this.f21299d;
            if (fVar2 != null && fVar2.y() != null) {
                pVar4.M0 = this.f21299d.y().a();
            }
            b(pVar4);
            int position = pVar4.getPosition() + this.f21299d.Z;
            if (position >= F.size()) {
                pVar4.O0 = position;
                b.a.r0.a3.l0.d.l(pVar4, 2, position + i4, F.size());
                return;
            }
            if (!this.f21301f) {
                position--;
                pVar4.O0 = position;
            }
            if (position < 0) {
                b.a.r0.a3.l0.d.k(pVar4, 23);
            } else if (h(F, position)) {
                b.a.r0.a3.l0.d.k(pVar4, 1);
            } else {
                F.add(position, pVar4);
                TiebaStatic.eventStat(this.f21297b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", pVar4.getAdvertAppInfo().q4);
            }
        }
    }

    @Override // b.a.r0.k2.y.h.a
    public ArrayList<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f21302g : (ArrayList) invokeV.objValue;
    }

    public final void b(p pVar) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, pVar) == null) || pVar == null || this.f21299d == null || pVar.getAdvertAppInfo() == null) {
            return;
        }
        pVar.getAdvertAppInfo().h4 = new b.a.q0.s.q.e();
        if (this.f21299d.y() != null) {
            pVar.getAdvertAppInfo().h4.f14057b = this.f21299d.y().a();
        }
        pVar.getAdvertAppInfo().h4.f14056a = pVar.K0();
        if (this.f21299d.l() != null && (l = this.f21299d.l()) != null) {
            pVar.getAdvertAppInfo().h4.f14059d = l.getId();
            pVar.getAdvertAppInfo().h4.f14060e = l.getFirst_class();
            pVar.getAdvertAppInfo().h4.f14061f = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            pVar.getAdvertAppInfo().h4.f14062g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        pVar.getAdvertAppInfo().h4.f14063h = pVar.getAdvertAppInfo().f4;
        pVar.getAdvertAppInfo().h4.f14064i = false;
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

    public abstract m0 e();

    public abstract l f();

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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.f21297b.getPbModel() != null) {
                return this.f21297b.getPbModel().t0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (this.f21298c.getAdapter() instanceof BdRecyclerAdapter)) {
            this.f21298c.getAdapter().notifyDataSetChanged();
        }
    }

    public abstract void l();

    public abstract void m();

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            boolean z = false;
            boolean z2 = false;
            for (int i2 = 0; i2 < this.f21302g.size(); i2++) {
                n nVar = this.f21302g.get(i2);
                if (nVar instanceof q) {
                    this.k = i2;
                    z = true;
                } else if ((nVar instanceof b.a.r0.k2.r.e) && ((b.a.r0.k2.r.e) nVar).a() == this.f21296a) {
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

    public abstract void p(b.a.r0.k2.r.f fVar, boolean z, String str, boolean z2);

    public void q(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, fVar) == null) {
            r(fVar, false);
        }
    }

    public void r(b.a.r0.k2.r.f fVar, boolean z) {
        p pVar;
        PostData postData;
        boolean z2;
        b.a.r0.k2.r.f fVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048599, this, fVar, z) == null) || fVar == null) {
            return;
        }
        this.f21299d = fVar;
        if (fVar != null && fVar.O() != null && fVar.O().J() != null) {
            this.f21303h = fVar.O().J().getUserId();
        }
        if (this.f21302g == null) {
            this.f21302g = new ArrayList<>();
        }
        this.f21302g.clear();
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
            this.f21302g.add(postData);
        }
        D(fVar);
        E(this.f21303h);
        if (b.a.q0.f1.b.c.d()) {
            if (this.f21298c != null) {
                ArrayList<n> arrayList = this.f21302g;
                ListUtils.removeSubList(arrayList, 1, arrayList.size());
            }
            this.f21298c.setData(this.f21302g);
            return;
        }
        int i2 = 0;
        if (!ListUtils.isEmpty(fVar.F()) && fVar.F().get(0) != null && fVar.O() != null) {
            fVar.O().b4(fVar.F().get(0).H());
            fVar.O().d4(fVar.F().get(0).I());
        }
        if (fVar.O() != null && fVar.O().P0() != null) {
            c2 c2Var = new c2();
            c2Var.w = fVar.O();
            c2Var.r = true;
            this.f21302g.add(c2Var);
        }
        r rVar = new r(fVar.O(), fVar.d());
        rVar.k(false);
        rVar.f20337f = false;
        this.f21302g.add(rVar);
        if (postData == null || postData.r0 == null || (fVar.l() != null && TextUtils.equals(fVar.l().getName(), this.f21297b.getPbModel().q0()) && this.f21297b.getPbModel().v0())) {
            z2 = false;
        } else {
            b.a.r0.k2.r.i iVar = new b.a.r0.k2.r.i(postData.r0);
            iVar.f20309f = this.f21297b.getPbModel().f1();
            this.f21302g.add(iVar);
            z2 = true;
        }
        if (!z2 && fVar.l() != null && !StringUtils.isNull(fVar.l().getName()) && (!TextUtils.equals(fVar.l().getName(), this.f21297b.getPbModel().q0()) || !this.f21297b.getPbModel().v0())) {
            b.a.r0.k2.r.h hVar = new b.a.r0.k2.r.h(fVar.l());
            hVar.k = this.f21297b.getPbModel().f1();
            hVar.f20306i = false;
            this.f21302g.add(hVar);
            rVar.k(false);
            rVar.f20337f = false;
        }
        if (fVar.O() != null && !StringUtils.isNull(fVar.O().Z())) {
            x xVar = new x();
            xVar.f20362e = fVar.O();
            this.f21302g.add(xVar);
        } else if (fVar.O() != null && !StringUtils.isNull(fVar.n())) {
            fVar.O().K3(fVar.n());
            x xVar2 = new x();
            xVar2.f20362e = fVar.O();
            this.f21302g.add(xVar2);
        }
        q qVar = new q(q.l);
        d2 O = fVar.O();
        if (O != null) {
            O.U0();
        }
        this.f21297b.getPbModel().d1();
        qVar.f20334h = j();
        qVar.f20333g = fVar.f20299g;
        fVar.c();
        qVar.f20335i = fVar.g0();
        qVar.k = fVar.f20298f;
        B(fVar);
        this.f21302g.add(qVar);
        if (fVar.L() == 4) {
            this.f21302g.add(new b.a.r0.k2.r.p());
        }
        F();
        o(i());
        Iterator<PostData> it2 = fVar.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            PostData next2 = it2.next();
            if ((next2 instanceof PostData) && next2.A() != 1) {
                this.f21302g.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !b.a.e.f.p.j.z()) && ((fVar2 = this.f21299d) == null || !fVar2.t()))) {
            b.a.r0.k2.r.n nVar = new b.a.r0.k2.r.n();
            nVar.H0 = TbadkCoreApplication.getInst().getContext().getString(b.a.r0.k2.l.mention_replyme_nodata);
            nVar.G0 = b.a.r0.k2.h.new_pic_emotion_03;
            nVar.I0 = -2;
            nVar.J0 = b.a.e.f.p.l.g(this.f21297b.getContext(), b.a.r0.k2.g.tbds74);
            this.f21302g.add(nVar);
        }
        p(fVar, this.j, this.f21303h, this.f21304i);
        if (fVar.y().b() == 0) {
            b.a.r0.k2.r.f fVar3 = this.f21299d;
            if (fVar3 != null && fVar3.t()) {
                A(this.f21297b.getVideoPbFragment().getListener());
                this.f21302g.add(new b.a.r0.k2.r.l());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.f21299d.m());
                statisticItem.param("fname", this.f21299d.n());
                statisticItem.param("tid", this.f21299d.Q());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                z(this.f21297b.getVideoPbFragment().getListener());
                k kVar = new k();
                kVar.f20313e = TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.list_has_no_more);
                this.f21302g.add(kVar);
            }
            List<p> Y = fVar.Y();
            int i3 = -1;
            if (Y != null && !Y.isEmpty()) {
                pVar = Y.get(0);
                i3 = pVar.getPosition();
            }
            if (!ListUtils.isEmpty(fVar.f())) {
                b.a.r0.k2.r.e eVar = new b.a.r0.k2.r.e();
                eVar.g(TbadkCoreApplication.getInst().getString(b.a.r0.k2.l.related_recommendation));
                eVar.e(this.f21296a);
                this.f21302g.add(eVar);
                int i4 = 1;
                for (b.a.q0.s.q.q qVar2 : fVar.f()) {
                    if (Y != null && i4 == i3) {
                        if (pVar != null) {
                            b(pVar);
                            this.f21302g.add(pVar);
                            i2++;
                            if (pVar.getType() != AdvertAppInfo.t4) {
                                i4++;
                            }
                        }
                        if (i2 < Y.size()) {
                            p pVar2 = Y.get(i2);
                            pVar = pVar2;
                            i3 = pVar2.getPosition();
                        }
                    }
                    this.f21302g.add(qVar2);
                    i4++;
                    if (i4 == 4 && fVar.C() != null) {
                        this.f21302g.add(fVar.C());
                        i4++;
                    }
                }
            }
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.f21298c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setData(this.f21302g);
        }
        n();
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.j = z;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.f21301f = z;
        }
    }

    public void u(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, onClickListener) == null) {
        }
    }

    public void v(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, zVar) == null) {
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
