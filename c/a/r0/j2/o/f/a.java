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
    public final BdUniqueId f20604a;

    /* renamed from: b  reason: collision with root package name */
    public DetailInfoAndReplyFragment f20605b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f20606c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.j2.h.e f20607d;

    /* renamed from: e  reason: collision with root package name */
    public final List<c.a.e.l.e.a> f20608e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f20609f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f20610g;

    /* renamed from: h  reason: collision with root package name */
    public String f20611h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20612i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f20613j;
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
        this.f20604a = BdUniqueId.gen();
        this.f20608e = new ArrayList();
        this.f20609f = true;
        this.f20611h = null;
        this.f20612i = true;
        this.f20613j = false;
        this.k = -1;
        this.l = -1;
        this.f20605b = detailInfoAndReplyFragment;
        this.f20606c = bdTypeRecyclerView;
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (eVar = this.f20607d) == null || eVar.a0 || eVar.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = eVar.F();
        ArrayList<p> e2 = this.f20607d.e();
        if (e2 == null || e2.isEmpty() || F == null || F.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<p> it = e2.iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (next != null && next.F0() != null) {
                sb.append(next.F0());
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
                int S4 = next3.getAdvertAppInfo().S4();
                if (S4 != 0) {
                    c.a.r0.y2.l0.d.j(next3, S4);
                    if (S4 != 28 && S4 != 31) {
                        next3.getAdvertAppInfo().Z3 = -1001;
                        String str = "updateAppData，Data InValidate: " + S4;
                    }
                }
                sparseArray.put(next3.getPosition(), next3);
            }
        }
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            p pVar3 = (p) sparseArray.get(sparseArray.keyAt(i2));
            if (pVar3 != null && (pVar2 = (p) hashMap.put(pVar3.E0(), pVar3)) != null) {
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
            if (this.f20607d.m() != null) {
                pVar4.F0 = this.f20607d.m().getId();
            }
            if (this.f20607d.O() != null) {
                pVar4.I0 = c.a.e.e.m.b.g(this.f20607d.O().f0(), 0L);
            }
            c.a.r0.j2.h.e eVar2 = this.f20607d;
            if (eVar2 != null && eVar2.y() != null) {
                pVar4.J0 = this.f20607d.y().a();
            }
            b(pVar4);
            int position = pVar4.getPosition() + this.f20607d.Z;
            if (position >= F.size()) {
                pVar4.L0 = position;
                c.a.r0.y2.l0.d.k(pVar4, 2, position + i4, F.size());
                return;
            }
            if (!this.f20609f) {
                position--;
                pVar4.L0 = position;
            }
            if (position < 0) {
                c.a.r0.y2.l0.d.j(pVar4, 23);
            } else if (h(F, position)) {
                c.a.r0.y2.l0.d.j(pVar4, 1);
            } else {
                F.add(position, pVar4);
                TiebaStatic.eventStat(this.f20605b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", pVar4.getAdvertAppInfo().p4);
            }
        }
    }

    @Override // c.a.r0.j2.o.h.a
    public ArrayList<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f20610g : (ArrayList) invokeV.objValue;
    }

    public final void b(p pVar) {
        ForumData m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, pVar) == null) || pVar == null || this.f20607d == null || pVar.getAdvertAppInfo() == null) {
            return;
        }
        pVar.getAdvertAppInfo().g4 = new c.a.q0.s.q.e();
        if (this.f20607d.y() != null) {
            pVar.getAdvertAppInfo().g4.f14144b = this.f20607d.y().a();
        }
        pVar.getAdvertAppInfo().g4.f14143a = pVar.G0();
        if (this.f20607d.m() != null && (m = this.f20607d.m()) != null) {
            pVar.getAdvertAppInfo().g4.f14146d = m.getId();
            pVar.getAdvertAppInfo().g4.f14147e = m.getFirst_class();
            pVar.getAdvertAppInfo().g4.f14148f = m.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            pVar.getAdvertAppInfo().g4.f14149g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        pVar.getAdvertAppInfo().g4.f14150h = pVar.getAdvertAppInfo().e4;
        pVar.getAdvertAppInfo().g4.f14151i = false;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f20613j : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f20605b.getPbModel() != null) {
                return this.f20605b.getPbModel().t0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (this.f20606c.getAdapter() instanceof BdRecyclerAdapter)) {
            this.f20606c.getAdapter().notifyDataSetChanged();
        }
    }

    public abstract void l();

    public abstract void m();

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            boolean z = false;
            boolean z2 = false;
            for (int i2 = 0; i2 < this.f20610g.size(); i2++) {
                n nVar = this.f20610g.get(i2);
                if (nVar instanceof o) {
                    this.k = i2;
                    z = true;
                } else if ((nVar instanceof c.a.r0.j2.h.d) && ((c.a.r0.j2.h.d) nVar).b() == this.f20604a) {
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
        this.f20607d = eVar;
        if (eVar != null && eVar.O() != null && eVar.O().J() != null) {
            this.f20611h = eVar.O().J().getUserId();
        }
        if (this.f20610g == null) {
            this.f20610g = new ArrayList<>();
        }
        this.f20610g.clear();
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
            this.f20610g.add(postData);
        }
        C(eVar);
        D(this.f20611h);
        if (c.a.q0.g1.b.c.d()) {
            if (this.f20606c != null) {
                ArrayList<n> arrayList = this.f20610g;
                ListUtils.removeSubList(arrayList, 1, arrayList.size());
            }
            this.f20606c.setData(this.f20610g);
            return;
        }
        int i2 = 0;
        if (!ListUtils.isEmpty(eVar.F()) && eVar.F().get(0) != null && eVar.O() != null) {
            eVar.O().Y3(eVar.F().get(0).F());
            eVar.O().a4(eVar.F().get(0).G());
        }
        if (eVar.O() != null && eVar.O().P0() != null) {
            c2 c2Var = new c2();
            c2Var.w = eVar.O();
            c2Var.r = true;
            this.f20610g.add(c2Var);
        }
        c.a.r0.j2.h.p pVar2 = new c.a.r0.j2.h.p(eVar.O(), eVar.d());
        pVar2.k(false);
        pVar2.f19673f = false;
        this.f20610g.add(pVar2);
        if (postData == null || postData.p0 == null || (eVar.m() != null && TextUtils.equals(eVar.m().getName(), this.f20605b.getPbModel().q0()) && this.f20605b.getPbModel().v0())) {
            z2 = false;
        } else {
            c.a.r0.j2.h.h hVar = new c.a.r0.j2.h.h(postData.p0);
            hVar.f19644f = this.f20605b.getPbModel().f1();
            this.f20610g.add(hVar);
            z2 = true;
        }
        if (!z2 && eVar.m() != null && !StringUtils.isNull(eVar.m().getName()) && (!TextUtils.equals(eVar.m().getName(), this.f20605b.getPbModel().q0()) || !this.f20605b.getPbModel().v0())) {
            c.a.r0.j2.h.g gVar = new c.a.r0.j2.h.g(eVar.m());
            gVar.k = this.f20605b.getPbModel().f1();
            gVar.f19640i = false;
            this.f20610g.add(gVar);
            pVar2.k(false);
            pVar2.f19673f = false;
        }
        if (eVar.O() != null && !StringUtils.isNull(eVar.O().Z())) {
            v vVar = new v();
            vVar.f19699e = eVar.O();
            this.f20610g.add(vVar);
        } else if (eVar.O() != null && !StringUtils.isNull(eVar.o())) {
            eVar.O().H3(eVar.o());
            v vVar2 = new v();
            vVar2.f19699e = eVar.O();
            this.f20610g.add(vVar2);
        }
        o oVar = new o(o.l);
        d2 O = eVar.O();
        if (O != null) {
            O.U0();
        }
        this.f20605b.getPbModel().d1();
        oVar.f19668h = j();
        oVar.f19667g = eVar.f19632g;
        eVar.c();
        oVar.f19669i = eVar.f0();
        oVar.k = eVar.f19631f;
        A(eVar);
        this.f20610g.add(oVar);
        if (eVar.L() == 4) {
            this.f20610g.add(new c.a.r0.j2.h.n());
        }
        E();
        o(i());
        Iterator<PostData> it2 = eVar.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            PostData next2 = it2.next();
            if ((next2 instanceof PostData) && next2.A() != 1) {
                this.f20610g.add(next2);
                z3 = true;
            }
        }
        if (!z3 && (!z || !c.a.e.e.p.j.z())) {
            c.a.r0.j2.h.l lVar = new c.a.r0.j2.h.l();
            lVar.E0 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            lVar.D0 = R.drawable.new_pic_emotion_03;
            lVar.F0 = -2;
            lVar.G0 = c.a.e.e.p.l.g(this.f20605b.getContext(), R.dimen.tbds74);
            this.f20610g.add(lVar);
        }
        p(eVar, this.f20613j, this.f20611h, this.f20612i);
        if (eVar.y().b() == 0) {
            if (z3) {
                z(this.f20605b.getVideoPbFragment().getListener());
                c.a.r0.j2.h.j jVar = new c.a.r0.j2.h.j();
                jVar.f19648e = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.f20610g.add(jVar);
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
                dVar.d(this.f20604a);
                this.f20610g.add(dVar);
                int i4 = 1;
                for (q qVar : eVar.f()) {
                    if (Y != null && i4 == i3) {
                        if (pVar != null) {
                            b(pVar);
                            this.f20610g.add(pVar);
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
                    this.f20610g.add(qVar);
                    i4++;
                    if (i4 == 4 && eVar.C() != null) {
                        this.f20610g.add(eVar.C());
                        i4++;
                    }
                }
            }
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.f20606c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setData(this.f20610g);
        }
        n();
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.f20613j = z;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.f20609f = z;
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
