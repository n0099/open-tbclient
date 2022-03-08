package c.a.r0.u2.o.g;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.o.e.n;
import c.a.q0.r.r.d2;
import c.a.q0.r.r.e2;
import c.a.r0.u2.h.k;
import c.a.r0.u2.h.p;
import c.a.r0.u2.h.q;
import c.a.r0.u2.h.r;
import c.a.r0.u2.h.x;
import c.a.r0.u2.k.f.m;
import c.a.r0.u2.k.f.n0;
import c.a.r0.y3.k0.o;
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
import com.baidu.tieba.R;
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
/* loaded from: classes2.dex */
public abstract class a extends c.a.r0.u2.o.i.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;

    /* renamed from: b  reason: collision with root package name */
    public DetailInfoAndReplyFragment f23973b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f23974c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.u2.h.f f23975d;

    /* renamed from: e  reason: collision with root package name */
    public final List<c.a.d.o.e.a> f23976e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f23977f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f23978g;

    /* renamed from: h  reason: collision with root package name */
    public String f23979h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f23980i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f23981j;
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
        this.f23976e = new ArrayList();
        this.f23977f = true;
        this.f23979h = null;
        this.f23980i = true;
        this.f23981j = false;
        this.k = -1;
        this.l = -1;
        this.f23973b = detailInfoAndReplyFragment;
        this.f23974c = bdTypeRecyclerView;
    }

    public abstract void A(View.OnClickListener onClickListener);

    public abstract void B(c.a.r0.u2.h.f fVar);

    public void C(c.a.r0.u2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
        }
    }

    public abstract void D(c.a.r0.u2.h.f fVar);

    public abstract void E(String str);

    public final void F() {
        c.a.r0.u2.h.f fVar;
        o oVar;
        o oVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (fVar = this.f23975d) == null || fVar.a0 || fVar.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = fVar.F();
        ArrayList<o> e2 = this.f23975d.e();
        if (e2 == null || e2.isEmpty() || F == null || F.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<o> it = e2.iterator();
        while (it.hasNext()) {
            o next = it.next();
            if (next != null && next.K0() != null) {
                sb.append(next.K0());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Iterator<o> it2 = e2.iterator();
        while (it2.hasNext()) {
            o next2 = it2.next();
            if (next2 != null) {
                next2.Q0 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<o> it3 = e2.iterator();
        while (it3.hasNext()) {
            o next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int Z4 = next3.getAdvertAppInfo().Z4();
                if (Z4 != 0) {
                    c.a.r0.j3.m0.d.k(next3, Z4);
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
            o oVar3 = (o) sparseArray.get(sparseArray.keyAt(i2));
            if (oVar3 != null && (oVar2 = (o) hashMap.put(oVar3.J0(), oVar3)) != null) {
                c.a.r0.j3.m0.d.k(oVar2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (oVar = (o) entry.getValue()) != null) {
                sparseArray.put(oVar.getPosition(), oVar);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            arrayList.add(Integer.valueOf(sparseArray.keyAt(i3)));
        }
        Collections.sort(arrayList);
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            o oVar4 = (o) sparseArray.get(((Integer) arrayList.get(i4)).intValue());
            if (this.f23975d.l() != null) {
                oVar4.K0 = this.f23975d.l().getId();
            }
            if (this.f23975d.O() != null) {
                oVar4.N0 = c.a.d.f.m.b.g(this.f23975d.O().h0(), 0L);
            }
            c.a.r0.u2.h.f fVar2 = this.f23975d;
            if (fVar2 != null && fVar2.y() != null) {
                oVar4.O0 = this.f23975d.y().a();
            }
            b(oVar4);
            int position = oVar4.getPosition() + this.f23975d.Z;
            if (position >= F.size()) {
                oVar4.Q0 = position;
                c.a.r0.j3.m0.d.l(oVar4, 2, position + i4, F.size());
                return;
            }
            if (!this.f23977f) {
                position--;
                oVar4.Q0 = position;
            }
            if (position < 0) {
                c.a.r0.j3.m0.d.k(oVar4, 23);
            } else if (h(F, position)) {
                c.a.r0.j3.m0.d.k(oVar4, 1);
            } else {
                F.add(position, oVar4);
                TiebaStatic.eventStat(this.f23973b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", oVar4.getAdvertAppInfo().y4);
            }
        }
    }

    @Override // c.a.r0.u2.o.i.a
    public ArrayList<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f23978g : (ArrayList) invokeV.objValue;
    }

    public final void b(o oVar) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, oVar) == null) || oVar == null || this.f23975d == null || oVar.getAdvertAppInfo() == null) {
            return;
        }
        oVar.getAdvertAppInfo().p4 = new c.a.q0.r.r.e();
        if (this.f23975d.y() != null) {
            oVar.getAdvertAppInfo().p4.f13236b = this.f23975d.y().a();
        }
        oVar.getAdvertAppInfo().p4.a = oVar.L0();
        if (this.f23975d.l() != null && (l = this.f23975d.l()) != null) {
            oVar.getAdvertAppInfo().p4.f13238d = l.getId();
            oVar.getAdvertAppInfo().p4.f13239e = l.getFirst_class();
            oVar.getAdvertAppInfo().p4.f13240f = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            oVar.getAdvertAppInfo().p4.f13241g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        oVar.getAdvertAppInfo().p4.f13242h = oVar.getAdvertAppInfo().n4;
        oVar.getAdvertAppInfo().p4.f13243i = false;
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
                if (arrayList.get(max) instanceof o) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f23981j : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.f23973b.getPbModel() != null) {
                return this.f23973b.getPbModel().v0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (this.f23974c.getAdapter() instanceof BdRecyclerAdapter)) {
            this.f23974c.getAdapter().notifyDataSetChanged();
        }
    }

    public abstract void l();

    public abstract void m();

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            boolean z = false;
            boolean z2 = false;
            for (int i2 = 0; i2 < this.f23978g.size(); i2++) {
                n nVar = this.f23978g.get(i2);
                if (nVar instanceof q) {
                    this.k = i2;
                    z = true;
                } else if ((nVar instanceof c.a.r0.u2.h.e) && ((c.a.r0.u2.h.e) nVar).a() == this.a) {
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

    public abstract void p(c.a.r0.u2.h.f fVar, boolean z, String str, boolean z2);

    public void q(c.a.r0.u2.h.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, fVar) == null) {
            r(fVar, false);
        }
    }

    public void r(c.a.r0.u2.h.f fVar, boolean z) {
        o oVar;
        PostData postData;
        boolean z2;
        c.a.r0.u2.h.f fVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048599, this, fVar, z) == null) || fVar == null) {
            return;
        }
        this.f23975d = fVar;
        if (fVar != null && fVar.O() != null && fVar.O().J() != null) {
            this.f23979h = fVar.O().J().getUserId();
        }
        if (this.f23978g == null) {
            this.f23978g = new ArrayList<>();
        }
        this.f23978g.clear();
        Iterator<PostData> it = fVar.F().iterator();
        while (true) {
            oVar = null;
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
            this.f23978g.add(postData);
        }
        D(fVar);
        E(this.f23979h);
        if (c.a.q0.f1.b.c.d()) {
            if (this.f23974c != null) {
                ArrayList<n> arrayList = this.f23978g;
                ListUtils.removeSubList(arrayList, 1, arrayList.size());
            }
            this.f23974c.setData(this.f23978g);
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
            this.f23978g.add(d2Var);
        }
        r rVar = new r(fVar.O(), fVar.d());
        rVar.k(false);
        rVar.f23136f = false;
        this.f23978g.add(rVar);
        if (postData == null || postData.s0 == null || (fVar.l() != null && TextUtils.equals(fVar.l().getName(), this.f23973b.getPbModel().r0()) && this.f23973b.getPbModel().x0())) {
            z2 = false;
        } else {
            c.a.r0.u2.h.i iVar = new c.a.r0.u2.h.i(postData.s0);
            iVar.f23109f = this.f23973b.getPbModel().h1();
            this.f23978g.add(iVar);
            z2 = true;
        }
        if (!z2 && fVar.l() != null && !StringUtils.isNull(fVar.l().getName()) && (!TextUtils.equals(fVar.l().getName(), this.f23973b.getPbModel().r0()) || !this.f23973b.getPbModel().x0())) {
            c.a.r0.u2.h.h hVar = new c.a.r0.u2.h.h(fVar.l());
            hVar.k = this.f23973b.getPbModel().h1();
            hVar.f23105i = false;
            this.f23978g.add(hVar);
            rVar.k(false);
            rVar.f23136f = false;
        }
        if (fVar.O() != null && !StringUtils.isNull(fVar.O().b0())) {
            x xVar = new x();
            xVar.f23158e = fVar.O();
            this.f23978g.add(xVar);
        } else if (fVar.O() != null && !StringUtils.isNull(fVar.n())) {
            fVar.O().N3(fVar.n());
            x xVar2 = new x();
            xVar2.f23158e = fVar.O();
            this.f23978g.add(xVar2);
        }
        q qVar = new q(q.l);
        e2 O = fVar.O();
        if (O != null) {
            O.W0();
        }
        this.f23973b.getPbModel().f1();
        qVar.f23131h = j();
        qVar.f23130g = fVar.f23097g;
        fVar.c();
        qVar.f23132i = fVar.g0();
        qVar.k = fVar.f23096f;
        B(fVar);
        this.f23978g.add(qVar);
        if (fVar.L() == 4) {
            this.f23978g.add(new p());
        }
        F();
        o(i());
        Iterator<PostData> it2 = fVar.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            PostData next2 = it2.next();
            if ((next2 instanceof PostData) && next2.A() != 1) {
                this.f23978g.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !l.z()) && ((fVar2 = this.f23975d) == null || !fVar2.t()))) {
            c.a.r0.u2.h.n nVar = new c.a.r0.u2.h.n();
            nVar.J0 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            nVar.I0 = R.drawable.new_pic_emotion_03;
            nVar.K0 = -2;
            nVar.L0 = c.a.d.f.p.n.f(this.f23973b.getContext(), R.dimen.tbds74);
            this.f23978g.add(nVar);
        }
        p(fVar, this.f23981j, this.f23979h, this.f23980i);
        if (fVar.y().b() == 0) {
            c.a.r0.u2.h.f fVar3 = this.f23975d;
            if (fVar3 != null && fVar3.t()) {
                A(this.f23973b.getVideoPbFragment().getListener());
                this.f23978g.add(new c.a.r0.u2.h.l());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.f23975d.m());
                statisticItem.param("fname", this.f23975d.n());
                statisticItem.param("tid", this.f23975d.Q());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                z(this.f23973b.getVideoPbFragment().getListener());
                k kVar = new k();
                kVar.f23112e = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.f23978g.add(kVar);
            }
            List<o> Y = fVar.Y();
            int i3 = -1;
            if (Y != null && !Y.isEmpty()) {
                oVar = Y.get(0);
                i3 = oVar.getPosition();
            }
            if (!ListUtils.isEmpty(fVar.f())) {
                c.a.r0.u2.h.e eVar = new c.a.r0.u2.h.e();
                eVar.g(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                eVar.e(this.a);
                this.f23978g.add(eVar);
                int i4 = 1;
                for (c.a.q0.r.r.q qVar2 : fVar.f()) {
                    if (Y != null && i4 == i3) {
                        if (oVar != null) {
                            b(oVar);
                            this.f23978g.add(oVar);
                            i2++;
                            if (oVar.getType() != AdvertAppInfo.C4) {
                                i4++;
                            }
                        }
                        if (i2 < Y.size()) {
                            o oVar2 = Y.get(i2);
                            oVar = oVar2;
                            i3 = oVar2.getPosition();
                        }
                    }
                    this.f23978g.add(qVar2);
                    i4++;
                    if (i4 == 4 && fVar.C() != null) {
                        this.f23978g.add(fVar.C());
                        i4++;
                    }
                }
            }
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.f23974c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setData(this.f23978g);
        }
        n();
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.f23981j = z;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.f23977f = z;
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
