package c.a.r0.j2.o.f;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.l.e.n;
import c.a.q0.s.q.c2;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.q;
import c.a.r0.j2.h.o;
import c.a.r0.j2.h.v;
import c.a.r0.j2.k.e.l;
import c.a.r0.j2.k.e.l0;
import c.a.r0.j3.i0.p;
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
/* loaded from: classes3.dex */
public abstract class a extends c.a.r0.j2.o.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final BdUniqueId f20589a;

    /* renamed from: b  reason: collision with root package name */
    public DetailInfoAndReplyFragment f20590b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f20591c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.j2.h.e f20592d;

    /* renamed from: e  reason: collision with root package name */
    public final List<c.a.e.l.e.a> f20593e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f20594f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f20595g;

    /* renamed from: h  reason: collision with root package name */
    public String f20596h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20597i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f20598j;
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
        this.f20589a = BdUniqueId.gen();
        this.f20593e = new ArrayList();
        this.f20594f = true;
        this.f20596h = null;
        this.f20597i = true;
        this.f20598j = false;
        this.k = -1;
        this.l = -1;
        this.f20590b = detailInfoAndReplyFragment;
        this.f20591c = bdTypeRecyclerView;
    }

    public abstract void A(c.a.r0.j2.h.e eVar);

    public void B(c.a.r0.j2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
        }
    }

    public abstract void C(c.a.r0.j2.h.e eVar);

    public abstract void D(String str);

    public final void E() {
        c.a.r0.j2.h.e eVar;
        p pVar;
        p pVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (eVar = this.f20592d) == null || eVar.a0 || eVar.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = eVar.F();
        ArrayList<p> e2 = this.f20592d.e();
        if (e2 == null || e2.isEmpty() || F == null || F.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<p> it = e2.iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (next != null && next.D0() != null) {
                sb.append(next.D0());
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
                next2.L0 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<p> it3 = e2.iterator();
        while (it3.hasNext()) {
            p next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int T4 = next3.getAdvertAppInfo().T4();
                if (T4 != 0) {
                    c.a.r0.y2.l0.d.j(next3, T4);
                    if (T4 != 28 && T4 != 31) {
                        next3.getAdvertAppInfo().Y3 = -1001;
                        String str = "updateAppData，Data InValidate: " + T4;
                    }
                }
                sparseArray.put(next3.getPosition(), next3);
            }
        }
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            p pVar3 = (p) sparseArray.get(sparseArray.keyAt(i2));
            if (pVar3 != null && (pVar2 = (p) hashMap.put(pVar3.C0(), pVar3)) != null) {
                c.a.r0.y2.l0.d.j(pVar2, 30);
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
            if (this.f20592d.m() != null) {
                pVar4.F0 = this.f20592d.m().getId();
            }
            if (this.f20592d.O() != null) {
                pVar4.I0 = c.a.e.e.m.b.g(this.f20592d.O().f0(), 0L);
            }
            c.a.r0.j2.h.e eVar2 = this.f20592d;
            if (eVar2 != null && eVar2.y() != null) {
                pVar4.J0 = this.f20592d.y().a();
            }
            b(pVar4);
            int position = pVar4.getPosition() + this.f20592d.Z;
            if (position >= F.size()) {
                pVar4.L0 = position;
                c.a.r0.y2.l0.d.k(pVar4, 2, position + i4, F.size());
                return;
            }
            if (!this.f20594f) {
                position--;
                pVar4.L0 = position;
            }
            if (position < 0) {
                c.a.r0.y2.l0.d.j(pVar4, 23);
            } else if (h(F, position)) {
                c.a.r0.y2.l0.d.j(pVar4, 1);
            } else {
                F.add(position, pVar4);
                TiebaStatic.eventStat(this.f20590b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", pVar4.getAdvertAppInfo().o4);
            }
        }
    }

    @Override // c.a.r0.j2.o.h.a
    public ArrayList<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f20595g : (ArrayList) invokeV.objValue;
    }

    public final void b(p pVar) {
        ForumData m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, pVar) == null) || pVar == null || this.f20592d == null || pVar.getAdvertAppInfo() == null) {
            return;
        }
        pVar.getAdvertAppInfo().f4 = new c.a.q0.s.q.e();
        if (this.f20592d.y() != null) {
            pVar.getAdvertAppInfo().f4.f14144b = this.f20592d.y().a();
        }
        pVar.getAdvertAppInfo().f4.f14143a = pVar.E0();
        if (this.f20592d.m() != null && (m = this.f20592d.m()) != null) {
            pVar.getAdvertAppInfo().f4.f14146d = m.getId();
            pVar.getAdvertAppInfo().f4.f14147e = m.getFirst_class();
            pVar.getAdvertAppInfo().f4.f14148f = m.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            pVar.getAdvertAppInfo().f4.f14149g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        pVar.getAdvertAppInfo().f4.f14150h = pVar.getAdvertAppInfo().d4;
        pVar.getAdvertAppInfo().f4.f14151i = false;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f20598j : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f20590b.getPbModel() != null) {
                return this.f20590b.getPbModel().s0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (this.f20591c.getAdapter() instanceof BdRecyclerAdapter)) {
            this.f20591c.getAdapter().notifyDataSetChanged();
        }
    }

    public abstract void l();

    public abstract void m();

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            boolean z = false;
            boolean z2 = false;
            for (int i2 = 0; i2 < this.f20595g.size(); i2++) {
                n nVar = this.f20595g.get(i2);
                if (nVar instanceof o) {
                    this.k = i2;
                    z = true;
                } else if ((nVar instanceof c.a.r0.j2.h.d) && ((c.a.r0.j2.h.d) nVar).b() == this.f20589a) {
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

    public abstract void p(c.a.r0.j2.h.e eVar, boolean z, String str, boolean z2);

    public void q(c.a.r0.j2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, eVar) == null) {
            r(eVar, false);
        }
    }

    public void r(c.a.r0.j2.h.e eVar, boolean z) {
        p pVar;
        PostData postData;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048598, this, eVar, z) == null) || eVar == null) {
            return;
        }
        this.f20592d = eVar;
        if (eVar != null && eVar.O() != null && eVar.O().J() != null) {
            this.f20596h = eVar.O().J().getUserId();
        }
        if (this.f20595g == null) {
            this.f20595g = new ArrayList<>();
        }
        this.f20595g.clear();
        Iterator<PostData> it = eVar.F().iterator();
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
        if (postData == null && eVar.j() != null) {
            postData = eVar.j();
        }
        if (postData != null) {
            this.f20595g.add(postData);
        }
        C(eVar);
        D(this.f20596h);
        if (c.a.q0.g1.b.e.d()) {
            if (this.f20591c != null) {
                ArrayList<n> arrayList = this.f20595g;
                ListUtils.removeSubList(arrayList, 1, arrayList.size());
            }
            this.f20591c.setData(this.f20595g);
            return;
        }
        int i2 = 0;
        if (!ListUtils.isEmpty(eVar.F()) && eVar.F().get(0) != null && eVar.O() != null) {
            eVar.O().Z3(eVar.F().get(0).F());
            eVar.O().b4(eVar.F().get(0).G());
        }
        if (eVar.O() != null && eVar.O().P0() != null) {
            c2 c2Var = new c2();
            c2Var.w = eVar.O();
            c2Var.r = true;
            this.f20595g.add(c2Var);
        }
        c.a.r0.j2.h.p pVar2 = new c.a.r0.j2.h.p(eVar.O(), eVar.d());
        pVar2.k(false);
        pVar2.f19658f = false;
        this.f20595g.add(pVar2);
        if (postData == null || postData.p0 == null || (eVar.m() != null && TextUtils.equals(eVar.m().getName(), this.f20590b.getPbModel().p0()) && this.f20590b.getPbModel().u0())) {
            z2 = false;
        } else {
            c.a.r0.j2.h.h hVar = new c.a.r0.j2.h.h(postData.p0);
            hVar.f19629f = this.f20590b.getPbModel().e1();
            this.f20595g.add(hVar);
            z2 = true;
        }
        if (!z2 && eVar.m() != null && !StringUtils.isNull(eVar.m().getName()) && (!TextUtils.equals(eVar.m().getName(), this.f20590b.getPbModel().p0()) || !this.f20590b.getPbModel().u0())) {
            c.a.r0.j2.h.g gVar = new c.a.r0.j2.h.g(eVar.m());
            gVar.k = this.f20590b.getPbModel().e1();
            gVar.f19625i = false;
            this.f20595g.add(gVar);
            pVar2.k(false);
            pVar2.f19658f = false;
        }
        if (eVar.O() != null && !StringUtils.isNull(eVar.O().Z())) {
            v vVar = new v();
            vVar.f19684e = eVar.O();
            this.f20595g.add(vVar);
        } else if (eVar.O() != null && !StringUtils.isNull(eVar.o())) {
            eVar.O().I3(eVar.o());
            v vVar2 = new v();
            vVar2.f19684e = eVar.O();
            this.f20595g.add(vVar2);
        }
        o oVar = new o(o.l);
        d2 O = eVar.O();
        if (O != null) {
            O.U0();
        }
        this.f20590b.getPbModel().c1();
        oVar.f19653h = j();
        oVar.f19652g = eVar.f19617g;
        eVar.c();
        oVar.f19654i = eVar.f0();
        oVar.k = eVar.f19616f;
        A(eVar);
        this.f20595g.add(oVar);
        if (eVar.L() == 4) {
            this.f20595g.add(new c.a.r0.j2.h.n());
        }
        E();
        o(i());
        Iterator<PostData> it2 = eVar.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            PostData next2 = it2.next();
            if ((next2 instanceof PostData) && next2.A() != 1) {
                this.f20595g.add(next2);
                z3 = true;
            }
        }
        if (!z3 && (!z || !c.a.e.e.p.j.z())) {
            c.a.r0.j2.h.l lVar = new c.a.r0.j2.h.l();
            lVar.E0 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            lVar.D0 = R.drawable.new_pic_emotion_03;
            lVar.F0 = -2;
            lVar.G0 = c.a.e.e.p.l.g(this.f20590b.getContext(), R.dimen.tbds74);
            this.f20595g.add(lVar);
        }
        p(eVar, this.f20598j, this.f20596h, this.f20597i);
        if (eVar.y().b() == 0) {
            if (z3) {
                z(this.f20590b.getVideoPbFragment().getListener());
                c.a.r0.j2.h.j jVar = new c.a.r0.j2.h.j();
                jVar.f19633e = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.f20595g.add(jVar);
            }
            List<p> Y = eVar.Y();
            int i3 = -1;
            if (Y != null && !Y.isEmpty()) {
                pVar = Y.get(0);
                i3 = pVar.getPosition();
            }
            if (!ListUtils.isEmpty(eVar.f())) {
                c.a.r0.j2.h.d dVar = new c.a.r0.j2.h.d();
                dVar.g(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                dVar.d(this.f20589a);
                this.f20595g.add(dVar);
                int i4 = 1;
                for (q qVar : eVar.f()) {
                    if (Y != null && i4 == i3) {
                        if (pVar != null) {
                            b(pVar);
                            this.f20595g.add(pVar);
                            i2++;
                            if (pVar.getType() != AdvertAppInfo.r4) {
                                i4++;
                            }
                        }
                        if (i2 < Y.size()) {
                            p pVar3 = Y.get(i2);
                            pVar = pVar3;
                            i3 = pVar3.getPosition();
                        }
                    }
                    this.f20595g.add(qVar);
                    i4++;
                    if (i4 == 4 && eVar.C() != null) {
                        this.f20595g.add(eVar.C());
                        i4++;
                    }
                }
            }
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.f20591c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setData(this.f20595g);
        }
        n();
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.f20598j = z;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.f20594f = z;
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
