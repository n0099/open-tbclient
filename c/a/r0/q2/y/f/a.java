package c.a.r0.q2.y.f;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.m.e.n;
import c.a.q0.s.q.c2;
import c.a.q0.s.q.d2;
import c.a.r0.q2.r.k;
import c.a.r0.q2.r.q;
import c.a.r0.q2.r.r;
import c.a.r0.q2.r.x;
import c.a.r0.q2.u.f.l;
import c.a.r0.q2.u.f.m0;
import c.a.r0.t3.j0.p;
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
/* loaded from: classes6.dex */
public abstract class a extends c.a.r0.q2.y.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;

    /* renamed from: b  reason: collision with root package name */
    public DetailInfoAndReplyFragment f22428b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f22429c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.q2.r.f f22430d;

    /* renamed from: e  reason: collision with root package name */
    public final List<c.a.d.m.e.a> f22431e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f22432f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f22433g;

    /* renamed from: h  reason: collision with root package name */
    public String f22434h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f22435i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f22436j;

    /* renamed from: k  reason: collision with root package name */
    public int f22437k;
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
        this.f22431e = new ArrayList();
        this.f22432f = true;
        this.f22434h = null;
        this.f22435i = true;
        this.f22436j = false;
        this.f22437k = -1;
        this.l = -1;
        this.f22428b = detailInfoAndReplyFragment;
        this.f22429c = bdTypeRecyclerView;
    }

    public abstract void A(View.OnClickListener onClickListener);

    public abstract void B(c.a.r0.q2.r.f fVar);

    public void C(c.a.r0.q2.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
        }
    }

    public abstract void D(c.a.r0.q2.r.f fVar);

    public abstract void E(String str);

    public final void F() {
        c.a.r0.q2.r.f fVar;
        p pVar;
        p pVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (fVar = this.f22430d) == null || fVar.a0 || fVar.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = fVar.F();
        ArrayList<p> e2 = this.f22430d.e();
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
                next2.P0 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<p> it3 = e2.iterator();
        while (it3.hasNext()) {
            p next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int Y4 = next3.getAdvertAppInfo().Y4();
                if (Y4 != 0) {
                    c.a.r0.h3.l0.d.k(next3, Y4);
                    if (Y4 != 28 && Y4 != 31) {
                        next3.getAdvertAppInfo().e4 = -1001;
                        String str = "updateAppData，Data InValidate: " + Y4;
                    }
                }
                sparseArray.put(next3.getPosition(), next3);
            }
        }
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            p pVar3 = (p) sparseArray.get(sparseArray.keyAt(i2));
            if (pVar3 != null && (pVar2 = (p) hashMap.put(pVar3.I0(), pVar3)) != null) {
                c.a.r0.h3.l0.d.k(pVar2, 30);
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
            if (this.f22430d.l() != null) {
                pVar4.J0 = this.f22430d.l().getId();
            }
            if (this.f22430d.O() != null) {
                pVar4.M0 = c.a.d.f.m.b.g(this.f22430d.O().g0(), 0L);
            }
            c.a.r0.q2.r.f fVar2 = this.f22430d;
            if (fVar2 != null && fVar2.y() != null) {
                pVar4.N0 = this.f22430d.y().a();
            }
            b(pVar4);
            int position = pVar4.getPosition() + this.f22430d.Z;
            if (position >= F.size()) {
                pVar4.P0 = position;
                c.a.r0.h3.l0.d.l(pVar4, 2, position + i4, F.size());
                return;
            }
            if (!this.f22432f) {
                position--;
                pVar4.P0 = position;
            }
            if (position < 0) {
                c.a.r0.h3.l0.d.k(pVar4, 23);
            } else if (h(F, position)) {
                c.a.r0.h3.l0.d.k(pVar4, 1);
            } else {
                F.add(position, pVar4);
                TiebaStatic.eventStat(this.f22428b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", pVar4.getAdvertAppInfo().u4);
            }
        }
    }

    @Override // c.a.r0.q2.y.h.a
    public ArrayList<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f22433g : (ArrayList) invokeV.objValue;
    }

    public final void b(p pVar) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, pVar) == null) || pVar == null || this.f22430d == null || pVar.getAdvertAppInfo() == null) {
            return;
        }
        pVar.getAdvertAppInfo().l4 = new c.a.q0.s.q.e();
        if (this.f22430d.y() != null) {
            pVar.getAdvertAppInfo().l4.f12909b = this.f22430d.y().a();
        }
        pVar.getAdvertAppInfo().l4.a = pVar.K0();
        if (this.f22430d.l() != null && (l = this.f22430d.l()) != null) {
            pVar.getAdvertAppInfo().l4.f12911d = l.getId();
            pVar.getAdvertAppInfo().l4.f12912e = l.getFirst_class();
            pVar.getAdvertAppInfo().l4.f12913f = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            pVar.getAdvertAppInfo().l4.f12914g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        pVar.getAdvertAppInfo().l4.f12915h = pVar.getAdvertAppInfo().j4;
        pVar.getAdvertAppInfo().l4.f12916i = false;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.l : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f22437k : invokeV.intValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f22436j : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.f22428b.getPbModel() != null) {
                return this.f22428b.getPbModel().v0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (this.f22429c.getAdapter() instanceof BdRecyclerAdapter)) {
            this.f22429c.getAdapter().notifyDataSetChanged();
        }
    }

    public abstract void l();

    public abstract void m();

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            boolean z = false;
            boolean z2 = false;
            for (int i2 = 0; i2 < this.f22433g.size(); i2++) {
                n nVar = this.f22433g.get(i2);
                if (nVar instanceof q) {
                    this.f22437k = i2;
                    z = true;
                } else if ((nVar instanceof c.a.r0.q2.r.e) && ((c.a.r0.q2.r.e) nVar).a() == this.a) {
                    this.l = i2;
                    z2 = true;
                }
            }
            if (!z) {
                this.f22437k = -1;
            }
            if (z2) {
                return;
            }
            this.l = -1;
        }
    }

    public abstract void o(boolean z);

    public abstract void p(c.a.r0.q2.r.f fVar, boolean z, String str, boolean z2);

    public void q(c.a.r0.q2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, fVar) == null) {
            r(fVar, false);
        }
    }

    public void r(c.a.r0.q2.r.f fVar, boolean z) {
        p pVar;
        PostData postData;
        boolean z2;
        c.a.r0.q2.r.f fVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048599, this, fVar, z) == null) || fVar == null) {
            return;
        }
        this.f22430d = fVar;
        if (fVar != null && fVar.O() != null && fVar.O().J() != null) {
            this.f22434h = fVar.O().J().getUserId();
        }
        if (this.f22433g == null) {
            this.f22433g = new ArrayList<>();
        }
        this.f22433g.clear();
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
            this.f22433g.add(postData);
        }
        D(fVar);
        E(this.f22434h);
        if (c.a.q0.g1.b.c.d()) {
            if (this.f22429c != null) {
                ArrayList<n> arrayList = this.f22433g;
                ListUtils.removeSubList(arrayList, 1, arrayList.size());
            }
            this.f22429c.setData(this.f22433g);
            return;
        }
        int i2 = 0;
        if (!ListUtils.isEmpty(fVar.F()) && fVar.F().get(0) != null && fVar.O() != null) {
            fVar.O().d4(fVar.F().get(0).H());
            fVar.O().f4(fVar.F().get(0).I());
        }
        if (fVar.O() != null && fVar.O().Q0() != null) {
            c2 c2Var = new c2();
            c2Var.w = fVar.O();
            c2Var.r = true;
            this.f22433g.add(c2Var);
        }
        r rVar = new r(fVar.O(), fVar.d());
        rVar.k(false);
        rVar.f21563f = false;
        this.f22433g.add(rVar);
        if (postData == null || postData.s0 == null || (fVar.l() != null && TextUtils.equals(fVar.l().getName(), this.f22428b.getPbModel().r0()) && this.f22428b.getPbModel().x0())) {
            z2 = false;
        } else {
            c.a.r0.q2.r.i iVar = new c.a.r0.q2.r.i(postData.s0);
            iVar.f21535f = this.f22428b.getPbModel().h1();
            this.f22433g.add(iVar);
            z2 = true;
        }
        if (!z2 && fVar.l() != null && !StringUtils.isNull(fVar.l().getName()) && (!TextUtils.equals(fVar.l().getName(), this.f22428b.getPbModel().r0()) || !this.f22428b.getPbModel().x0())) {
            c.a.r0.q2.r.h hVar = new c.a.r0.q2.r.h(fVar.l());
            hVar.f21532k = this.f22428b.getPbModel().h1();
            hVar.f21530i = false;
            this.f22433g.add(hVar);
            rVar.k(false);
            rVar.f21563f = false;
        }
        if (fVar.O() != null && !StringUtils.isNull(fVar.O().a0())) {
            x xVar = new x();
            xVar.f21586e = fVar.O();
            this.f22433g.add(xVar);
        } else if (fVar.O() != null && !StringUtils.isNull(fVar.n())) {
            fVar.O().M3(fVar.n());
            x xVar2 = new x();
            xVar2.f21586e = fVar.O();
            this.f22433g.add(xVar2);
        }
        q qVar = new q(q.l);
        d2 O = fVar.O();
        if (O != null) {
            O.V0();
        }
        this.f22428b.getPbModel().f1();
        qVar.f21557h = j();
        qVar.f21556g = fVar.f21521g;
        fVar.c();
        qVar.f21558i = fVar.g0();
        qVar.f21560k = fVar.f21520f;
        B(fVar);
        this.f22433g.add(qVar);
        if (fVar.L() == 4) {
            this.f22433g.add(new c.a.r0.q2.r.p());
        }
        F();
        o(i());
        Iterator<PostData> it2 = fVar.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            PostData next2 = it2.next();
            if ((next2 instanceof PostData) && next2.A() != 1) {
                this.f22433g.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !c.a.d.f.p.j.z()) && ((fVar2 = this.f22430d) == null || !fVar2.t()))) {
            c.a.r0.q2.r.n nVar = new c.a.r0.q2.r.n();
            nVar.I0 = TbadkCoreApplication.getInst().getContext().getString(c.a.r0.q2.l.mention_replyme_nodata);
            nVar.H0 = c.a.r0.q2.h.new_pic_emotion_03;
            nVar.J0 = -2;
            nVar.K0 = c.a.d.f.p.l.f(this.f22428b.getContext(), c.a.r0.q2.g.tbds74);
            this.f22433g.add(nVar);
        }
        p(fVar, this.f22436j, this.f22434h, this.f22435i);
        if (fVar.y().b() == 0) {
            c.a.r0.q2.r.f fVar3 = this.f22430d;
            if (fVar3 != null && fVar3.t()) {
                A(this.f22428b.getVideoPbFragment().getListener());
                this.f22433g.add(new c.a.r0.q2.r.l());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.f22430d.m());
                statisticItem.param("fname", this.f22430d.n());
                statisticItem.param("tid", this.f22430d.Q());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                z(this.f22428b.getVideoPbFragment().getListener());
                k kVar = new k();
                kVar.f21538e = TbadkCoreApplication.getInst().getResources().getString(c.a.r0.q2.l.list_has_no_more);
                this.f22433g.add(kVar);
            }
            List<p> Y = fVar.Y();
            int i3 = -1;
            if (Y != null && !Y.isEmpty()) {
                pVar = Y.get(0);
                i3 = pVar.getPosition();
            }
            if (!ListUtils.isEmpty(fVar.f())) {
                c.a.r0.q2.r.e eVar = new c.a.r0.q2.r.e();
                eVar.g(TbadkCoreApplication.getInst().getString(c.a.r0.q2.l.related_recommendation));
                eVar.e(this.a);
                this.f22433g.add(eVar);
                int i4 = 1;
                for (c.a.q0.s.q.q qVar2 : fVar.f()) {
                    if (Y != null && i4 == i3) {
                        if (pVar != null) {
                            b(pVar);
                            this.f22433g.add(pVar);
                            i2++;
                            if (pVar.getType() != AdvertAppInfo.y4) {
                                i4++;
                            }
                        }
                        if (i2 < Y.size()) {
                            p pVar2 = Y.get(i2);
                            pVar = pVar2;
                            i3 = pVar2.getPosition();
                        }
                    }
                    this.f22433g.add(qVar2);
                    i4++;
                    if (i4 == 4 && fVar.C() != null) {
                        this.f22433g.add(fVar.C());
                        i4++;
                    }
                }
            }
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.f22429c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setData(this.f22433g);
        }
        n();
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.f22436j = z;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.f22432f = z;
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
