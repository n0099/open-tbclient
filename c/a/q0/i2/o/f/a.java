package c.a.q0.i2.o.f;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.l.e.n;
import c.a.p0.s.q.b2;
import c.a.p0.s.q.c2;
import c.a.p0.s.q.q;
import c.a.q0.i2.h.l;
import c.a.q0.i2.h.o;
import c.a.q0.i2.h.v;
import c.a.q0.i2.k.e.k;
import c.a.q0.i2.k.e.k0;
import c.a.q0.i3.i0.p;
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
public abstract class a extends c.a.q0.i2.o.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final BdUniqueId f20025a;

    /* renamed from: b  reason: collision with root package name */
    public DetailInfoAndReplyFragment f20026b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f20027c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.q0.i2.h.e f20028d;

    /* renamed from: e  reason: collision with root package name */
    public final List<c.a.e.l.e.a> f20029e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f20030f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f20031g;

    /* renamed from: h  reason: collision with root package name */
    public String f20032h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20033i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f20034j;
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
        this.f20025a = BdUniqueId.gen();
        this.f20029e = new ArrayList();
        this.f20030f = true;
        this.f20032h = null;
        this.f20033i = true;
        this.f20034j = false;
        this.k = -1;
        this.l = -1;
        this.f20026b = detailInfoAndReplyFragment;
        this.f20027c = bdTypeRecyclerView;
    }

    public abstract void A(c.a.q0.i2.h.e eVar);

    public void B(c.a.q0.i2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
        }
    }

    public abstract void C(c.a.q0.i2.h.e eVar);

    public abstract void D(String str);

    public final void E() {
        c.a.q0.i2.h.e eVar;
        p pVar;
        p pVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (eVar = this.f20028d) == null || eVar.a0 || eVar.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = eVar.F();
        ArrayList<p> e2 = this.f20028d.e();
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
                int I4 = next3.getAdvertAppInfo().I4();
                if (I4 != 0) {
                    c.a.q0.x2.l0.d.j(next3, I4);
                    if (I4 != 28 && I4 != 31) {
                        next3.getAdvertAppInfo().V3 = -1001;
                        String str = "updateAppData，Data InValidate: " + I4;
                    }
                }
                sparseArray.put(next3.getPosition(), next3);
            }
        }
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            p pVar3 = (p) sparseArray.get(sparseArray.keyAt(i2));
            if (pVar3 != null && (pVar2 = (p) hashMap.put(pVar3.C0(), pVar3)) != null) {
                c.a.q0.x2.l0.d.j(pVar2, 30);
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
            if (this.f20028d.m() != null) {
                pVar4.F0 = this.f20028d.m().getId();
            }
            if (this.f20028d.O() != null) {
                pVar4.I0 = c.a.e.e.m.b.f(this.f20028d.O().f0(), 0L);
            }
            c.a.q0.i2.h.e eVar2 = this.f20028d;
            if (eVar2 != null && eVar2.y() != null) {
                pVar4.J0 = this.f20028d.y().a();
            }
            b(pVar4);
            int position = pVar4.getPosition() + this.f20028d.Z;
            if (position >= F.size()) {
                pVar4.L0 = position;
                c.a.q0.x2.l0.d.k(pVar4, 2, position + i4, F.size());
                return;
            }
            if (!this.f20030f) {
                position--;
                pVar4.L0 = position;
            }
            if (position < 0) {
                c.a.q0.x2.l0.d.j(pVar4, 23);
            } else if (h(F, position)) {
                c.a.q0.x2.l0.d.j(pVar4, 1);
            } else {
                F.add(position, pVar4);
                TiebaStatic.eventStat(this.f20026b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", pVar4.getAdvertAppInfo().l4);
            }
        }
    }

    @Override // c.a.q0.i2.o.h.a
    public ArrayList<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f20031g : (ArrayList) invokeV.objValue;
    }

    public final void b(p pVar) {
        ForumData m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, pVar) == null) || pVar == null || this.f20028d == null || pVar.getAdvertAppInfo() == null) {
            return;
        }
        pVar.getAdvertAppInfo().c4 = new c.a.p0.s.q.e();
        if (this.f20028d.y() != null) {
            pVar.getAdvertAppInfo().c4.f14193b = this.f20028d.y().a();
        }
        pVar.getAdvertAppInfo().c4.f14192a = pVar.E0();
        if (this.f20028d.m() != null && (m = this.f20028d.m()) != null) {
            pVar.getAdvertAppInfo().c4.f14195d = m.getId();
            pVar.getAdvertAppInfo().c4.f14196e = m.getFirst_class();
            pVar.getAdvertAppInfo().c4.f14197f = m.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            pVar.getAdvertAppInfo().c4.f14198g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        pVar.getAdvertAppInfo().c4.f14199h = pVar.getAdvertAppInfo().a4;
        pVar.getAdvertAppInfo().c4.f14200i = false;
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

    public abstract k0 e();

    public abstract k f();

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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f20034j : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f20026b.getPbModel() != null) {
                return this.f20026b.getPbModel().s0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (this.f20027c.getAdapter() instanceof BdRecyclerAdapter)) {
            this.f20027c.getAdapter().notifyDataSetChanged();
        }
    }

    public abstract void l();

    public abstract void m();

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            boolean z = false;
            boolean z2 = false;
            for (int i2 = 0; i2 < this.f20031g.size(); i2++) {
                n nVar = this.f20031g.get(i2);
                if (nVar instanceof o) {
                    this.k = i2;
                    z = true;
                } else if ((nVar instanceof c.a.q0.i2.h.d) && ((c.a.q0.i2.h.d) nVar).b() == this.f20025a) {
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

    public abstract void p(c.a.q0.i2.h.e eVar, boolean z, String str, boolean z2);

    public void q(c.a.q0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, eVar) == null) {
            r(eVar, false);
        }
    }

    public void r(c.a.q0.i2.h.e eVar, boolean z) {
        p pVar;
        PostData postData;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048598, this, eVar, z) == null) || eVar == null) {
            return;
        }
        this.f20028d = eVar;
        if (eVar != null && eVar.O() != null && eVar.O().J() != null) {
            this.f20032h = eVar.O().J().getUserId();
        }
        if (this.f20031g == null) {
            this.f20031g = new ArrayList<>();
        }
        this.f20031g.clear();
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
            this.f20031g.add(postData);
        }
        C(eVar);
        D(this.f20032h);
        if (c.a.p0.e1.b.e.d()) {
            if (this.f20027c != null) {
                ArrayList<n> arrayList = this.f20031g;
                ListUtils.removeSubList(arrayList, 1, arrayList.size());
            }
            this.f20027c.setData(this.f20031g);
            return;
        }
        int i2 = 0;
        if (!ListUtils.isEmpty(eVar.F()) && eVar.F().get(0) != null && eVar.O() != null) {
            eVar.O().Q3(eVar.F().get(0).F());
            eVar.O().S3(eVar.F().get(0).G());
        }
        if (eVar.O() != null && eVar.O().N0() != null) {
            b2 b2Var = new b2();
            b2Var.w = eVar.O();
            b2Var.r = true;
            this.f20031g.add(b2Var);
        }
        c.a.q0.i2.h.p pVar2 = new c.a.q0.i2.h.p(eVar.O(), eVar.d());
        pVar2.k(false);
        pVar2.f19109f = false;
        this.f20031g.add(pVar2);
        if (postData == null || postData.p0 == null || (eVar.m() != null && TextUtils.equals(eVar.m().getName(), this.f20026b.getPbModel().p0()) && this.f20026b.getPbModel().u0())) {
            z2 = false;
        } else {
            c.a.q0.i2.h.h hVar = new c.a.q0.i2.h.h(postData.p0);
            hVar.f19080f = this.f20026b.getPbModel().e1();
            this.f20031g.add(hVar);
            z2 = true;
        }
        if (!z2 && eVar.m() != null && !StringUtils.isNull(eVar.m().getName()) && (!TextUtils.equals(eVar.m().getName(), this.f20026b.getPbModel().p0()) || !this.f20026b.getPbModel().u0())) {
            c.a.q0.i2.h.g gVar = new c.a.q0.i2.h.g(eVar.m());
            gVar.k = this.f20026b.getPbModel().e1();
            gVar.f19076i = false;
            this.f20031g.add(gVar);
            pVar2.k(false);
            pVar2.f19109f = false;
        }
        if (eVar.O() != null && !StringUtils.isNull(eVar.O().Z())) {
            v vVar = new v();
            vVar.f19135e = eVar.O();
            this.f20031g.add(vVar);
        } else if (eVar.O() != null && !StringUtils.isNull(eVar.o())) {
            eVar.O().B3(eVar.o());
            v vVar2 = new v();
            vVar2.f19135e = eVar.O();
            this.f20031g.add(vVar2);
        }
        o oVar = new o(o.l);
        c2 O = eVar.O();
        if (O != null) {
            O.S0();
        }
        this.f20026b.getPbModel().c1();
        oVar.f19104h = j();
        oVar.f19103g = eVar.f19068g;
        eVar.c();
        oVar.f19105i = eVar.f0();
        oVar.k = eVar.f19067f;
        A(eVar);
        this.f20031g.add(oVar);
        if (eVar.L() == 4) {
            this.f20031g.add(new c.a.q0.i2.h.n());
        }
        E();
        o(i());
        Iterator<PostData> it2 = eVar.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            PostData next2 = it2.next();
            if ((next2 instanceof PostData) && next2.A() != 1) {
                this.f20031g.add(next2);
                z3 = true;
            }
        }
        if (!z3 && (!z || !c.a.e.e.p.j.z())) {
            l lVar = new l();
            lVar.E0 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            lVar.D0 = R.drawable.new_pic_emotion_03;
            lVar.F0 = -2;
            lVar.G0 = c.a.e.e.p.l.g(this.f20026b.getContext(), R.dimen.tbds74);
            this.f20031g.add(lVar);
        }
        p(eVar, this.f20034j, this.f20032h, this.f20033i);
        if (eVar.y().b() == 0) {
            if (z3) {
                z(this.f20026b.getVideoPbFragment().getListener());
                c.a.q0.i2.h.j jVar = new c.a.q0.i2.h.j();
                jVar.f19084e = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.f20031g.add(jVar);
            }
            List<p> Y = eVar.Y();
            int i3 = -1;
            if (Y != null && !Y.isEmpty()) {
                pVar = Y.get(0);
                i3 = pVar.getPosition();
            }
            if (!ListUtils.isEmpty(eVar.f())) {
                c.a.q0.i2.h.d dVar = new c.a.q0.i2.h.d();
                dVar.g(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                dVar.d(this.f20025a);
                this.f20031g.add(dVar);
                int i4 = 1;
                for (q qVar : eVar.f()) {
                    if (Y != null && i4 == i3) {
                        if (pVar != null) {
                            b(pVar);
                            this.f20031g.add(pVar);
                            i2++;
                            if (pVar.getType() != AdvertAppInfo.o4) {
                                i4++;
                            }
                        }
                        if (i2 < Y.size()) {
                            p pVar3 = Y.get(i2);
                            pVar = pVar3;
                            i3 = pVar3.getPosition();
                        }
                    }
                    this.f20031g.add(qVar);
                    i4++;
                    if (i4 == 4 && eVar.C() != null) {
                        this.f20031g.add(eVar.C());
                        i4++;
                    }
                }
            }
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.f20027c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setData(this.f20031g);
        }
        n();
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.f20034j = z;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.f20030f = z;
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
