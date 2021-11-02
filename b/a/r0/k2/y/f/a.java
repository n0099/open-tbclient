package b.a.r0.k2.y.f;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.e.l.e.n;
import b.a.q0.s.q.c2;
import b.a.q0.s.q.d2;
import b.a.r0.k2.r.k;
import b.a.r0.k2.r.m;
import b.a.r0.k2.r.o;
import b.a.r0.k2.r.q;
import b.a.r0.k2.r.w;
import b.a.r0.k2.u.f.l;
import b.a.r0.k2.u.f.l0;
import b.a.r0.l3.j0.p;
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
    public final BdUniqueId f19759a;

    /* renamed from: b  reason: collision with root package name */
    public DetailInfoAndReplyFragment f19760b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f19761c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.k2.r.f f19762d;

    /* renamed from: e  reason: collision with root package name */
    public final List<b.a.e.l.e.a> f19763e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f19764f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f19765g;

    /* renamed from: h  reason: collision with root package name */
    public String f19766h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f19767i;
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
        this.f19759a = BdUniqueId.gen();
        this.f19763e = new ArrayList();
        this.f19764f = true;
        this.f19766h = null;
        this.f19767i = true;
        this.j = false;
        this.k = -1;
        this.l = -1;
        this.f19760b = detailInfoAndReplyFragment;
        this.f19761c = bdTypeRecyclerView;
    }

    public abstract void A(b.a.r0.k2.r.f fVar);

    public void B(b.a.r0.k2.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
        }
    }

    public abstract void C(b.a.r0.k2.r.f fVar);

    public abstract void D(String str);

    public final void E() {
        b.a.r0.k2.r.f fVar;
        p pVar;
        p pVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (fVar = this.f19762d) == null || fVar.a0 || fVar.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = fVar.F();
        ArrayList<p> e2 = this.f19762d.e();
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
                int U4 = next3.getAdvertAppInfo().U4();
                if (U4 != 0) {
                    b.a.r0.z2.l0.d.k(next3, U4);
                    if (U4 != 28 && U4 != 31) {
                        next3.getAdvertAppInfo().Z3 = -1001;
                        String str = "updateAppData，Data InValidate: " + U4;
                    }
                }
                sparseArray.put(next3.getPosition(), next3);
            }
        }
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            p pVar3 = (p) sparseArray.get(sparseArray.keyAt(i2));
            if (pVar3 != null && (pVar2 = (p) hashMap.put(pVar3.I0(), pVar3)) != null) {
                b.a.r0.z2.l0.d.k(pVar2, 30);
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
            if (this.f19762d.l() != null) {
                pVar4.I0 = this.f19762d.l().getId();
            }
            if (this.f19762d.O() != null) {
                pVar4.L0 = b.a.e.e.m.b.g(this.f19762d.O().f0(), 0L);
            }
            b.a.r0.k2.r.f fVar2 = this.f19762d;
            if (fVar2 != null && fVar2.y() != null) {
                pVar4.M0 = this.f19762d.y().a();
            }
            b(pVar4);
            int position = pVar4.getPosition() + this.f19762d.Z;
            if (position >= F.size()) {
                pVar4.O0 = position;
                b.a.r0.z2.l0.d.l(pVar4, 2, position + i4, F.size());
                return;
            }
            if (!this.f19764f) {
                position--;
                pVar4.O0 = position;
            }
            if (position < 0) {
                b.a.r0.z2.l0.d.k(pVar4, 23);
            } else if (h(F, position)) {
                b.a.r0.z2.l0.d.k(pVar4, 1);
            } else {
                F.add(position, pVar4);
                TiebaStatic.eventStat(this.f19760b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", pVar4.getAdvertAppInfo().p4);
            }
        }
    }

    @Override // b.a.r0.k2.y.h.a
    public ArrayList<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f19765g : (ArrayList) invokeV.objValue;
    }

    public final void b(p pVar) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, pVar) == null) || pVar == null || this.f19762d == null || pVar.getAdvertAppInfo() == null) {
            return;
        }
        pVar.getAdvertAppInfo().g4 = new b.a.q0.s.q.e();
        if (this.f19762d.y() != null) {
            pVar.getAdvertAppInfo().g4.f13277b = this.f19762d.y().a();
        }
        pVar.getAdvertAppInfo().g4.f13276a = pVar.K0();
        if (this.f19762d.l() != null && (l = this.f19762d.l()) != null) {
            pVar.getAdvertAppInfo().g4.f13279d = l.getId();
            pVar.getAdvertAppInfo().g4.f13280e = l.getFirst_class();
            pVar.getAdvertAppInfo().g4.f13281f = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            pVar.getAdvertAppInfo().g4.f13282g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        pVar.getAdvertAppInfo().g4.f13283h = pVar.getAdvertAppInfo().e4;
        pVar.getAdvertAppInfo().g4.f13284i = false;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.l : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : invokeV.intValue;
    }

    public abstract l0 e();

    public abstract l f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public final boolean h(ArrayList<PostData> arrayList, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, arrayList, i2)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f19760b.getPbModel() != null) {
                return this.f19760b.getPbModel().t0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (this.f19761c.getAdapter() instanceof BdRecyclerAdapter)) {
            this.f19761c.getAdapter().notifyDataSetChanged();
        }
    }

    public abstract void l();

    public abstract void m();

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            boolean z = false;
            boolean z2 = false;
            for (int i2 = 0; i2 < this.f19765g.size(); i2++) {
                n nVar = this.f19765g.get(i2);
                if (nVar instanceof b.a.r0.k2.r.p) {
                    this.k = i2;
                    z = true;
                } else if ((nVar instanceof b.a.r0.k2.r.e) && ((b.a.r0.k2.r.e) nVar).a() == this.f19759a) {
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
        if (interceptable == null || interceptable.invokeL(1048597, this, fVar) == null) {
            r(fVar, false);
        }
    }

    public void r(b.a.r0.k2.r.f fVar, boolean z) {
        p pVar;
        PostData postData;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048598, this, fVar, z) == null) || fVar == null) {
            return;
        }
        this.f19762d = fVar;
        if (fVar != null && fVar.O() != null && fVar.O().J() != null) {
            this.f19766h = fVar.O().J().getUserId();
        }
        if (this.f19765g == null) {
            this.f19765g = new ArrayList<>();
        }
        this.f19765g.clear();
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
            this.f19765g.add(postData);
        }
        C(fVar);
        D(this.f19766h);
        if (b.a.q0.g1.b.c.d()) {
            if (this.f19761c != null) {
                ArrayList<n> arrayList = this.f19765g;
                ListUtils.removeSubList(arrayList, 1, arrayList.size());
            }
            this.f19761c.setData(this.f19765g);
            return;
        }
        int i2 = 0;
        if (!ListUtils.isEmpty(fVar.F()) && fVar.F().get(0) != null && fVar.O() != null) {
            fVar.O().Z3(fVar.F().get(0).H());
            fVar.O().b4(fVar.F().get(0).I());
        }
        if (fVar.O() != null && fVar.O().P0() != null) {
            c2 c2Var = new c2();
            c2Var.w = fVar.O();
            c2Var.r = true;
            this.f19765g.add(c2Var);
        }
        q qVar = new q(fVar.O(), fVar.d());
        qVar.k(false);
        qVar.f18800f = false;
        this.f19765g.add(qVar);
        if (postData == null || postData.r0 == null || (fVar.l() != null && TextUtils.equals(fVar.l().getName(), this.f19760b.getPbModel().q0()) && this.f19760b.getPbModel().v0())) {
            z2 = false;
        } else {
            b.a.r0.k2.r.i iVar = new b.a.r0.k2.r.i(postData.r0);
            iVar.f18773f = this.f19760b.getPbModel().f1();
            this.f19765g.add(iVar);
            z2 = true;
        }
        if (!z2 && fVar.l() != null && !StringUtils.isNull(fVar.l().getName()) && (!TextUtils.equals(fVar.l().getName(), this.f19760b.getPbModel().q0()) || !this.f19760b.getPbModel().v0())) {
            b.a.r0.k2.r.h hVar = new b.a.r0.k2.r.h(fVar.l());
            hVar.k = this.f19760b.getPbModel().f1();
            hVar.f18770i = false;
            this.f19765g.add(hVar);
            qVar.k(false);
            qVar.f18800f = false;
        }
        if (fVar.O() != null && !StringUtils.isNull(fVar.O().Z())) {
            w wVar = new w();
            wVar.f18825e = fVar.O();
            this.f19765g.add(wVar);
        } else if (fVar.O() != null && !StringUtils.isNull(fVar.n())) {
            fVar.O().I3(fVar.n());
            w wVar2 = new w();
            wVar2.f18825e = fVar.O();
            this.f19765g.add(wVar2);
        }
        b.a.r0.k2.r.p pVar2 = new b.a.r0.k2.r.p(b.a.r0.k2.r.p.l);
        d2 O = fVar.O();
        if (O != null) {
            O.U0();
        }
        this.f19760b.getPbModel().d1();
        pVar2.f18797h = j();
        pVar2.f18796g = fVar.f18763g;
        fVar.c();
        pVar2.f18798i = fVar.g0();
        pVar2.k = fVar.f18762f;
        A(fVar);
        this.f19765g.add(pVar2);
        if (fVar.L() == 4) {
            this.f19765g.add(new o());
        }
        E();
        o(i());
        Iterator<PostData> it2 = fVar.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            PostData next2 = it2.next();
            if ((next2 instanceof PostData) && next2.A() != 1) {
                this.f19765g.add(next2);
                z3 = true;
            }
        }
        if (!z3 && (!z || !b.a.e.e.p.j.z())) {
            m mVar = new m();
            mVar.H0 = TbadkCoreApplication.getInst().getContext().getString(b.a.r0.k2.l.mention_replyme_nodata);
            mVar.G0 = b.a.r0.k2.h.new_pic_emotion_03;
            mVar.I0 = -2;
            mVar.J0 = b.a.e.e.p.l.g(this.f19760b.getContext(), b.a.r0.k2.g.tbds74);
            this.f19765g.add(mVar);
        }
        p(fVar, this.j, this.f19766h, this.f19767i);
        if (fVar.y().b() == 0) {
            if (z3) {
                z(this.f19760b.getVideoPbFragment().getListener());
                k kVar = new k();
                kVar.f18777e = TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.list_has_no_more);
                this.f19765g.add(kVar);
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
                eVar.e(this.f19759a);
                this.f19765g.add(eVar);
                int i4 = 1;
                for (b.a.q0.s.q.q qVar2 : fVar.f()) {
                    if (Y != null && i4 == i3) {
                        if (pVar != null) {
                            b(pVar);
                            this.f19765g.add(pVar);
                            i2++;
                            if (pVar.getType() != AdvertAppInfo.s4) {
                                i4++;
                            }
                        }
                        if (i2 < Y.size()) {
                            p pVar3 = Y.get(i2);
                            pVar = pVar3;
                            i3 = pVar3.getPosition();
                        }
                    }
                    this.f19765g.add(qVar2);
                    i4++;
                    if (i4 == 4 && fVar.C() != null) {
                        this.f19765g.add(fVar.C());
                        i4++;
                    }
                }
            }
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.f19761c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setData(this.f19765g);
        }
        n();
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.j = z;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.f19764f = z;
        }
    }

    public void u(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onClickListener) == null) {
        }
    }

    public void v(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, zVar) == null) {
        }
    }

    public void w(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, onLongClickListener) == null) {
        }
    }

    public void x(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, fVar) == null) {
        }
    }

    public void y(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, onClickListener) == null) {
        }
    }

    public abstract void z(View.OnClickListener onClickListener);
}
