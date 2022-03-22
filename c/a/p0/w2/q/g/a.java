package c.a.p0.w2.q.g;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.o.e.n;
import c.a.o0.r.r.a2;
import c.a.p0.a4.k0.o;
import c.a.p0.w2.i.m;
import c.a.p0.w2.i.q;
import c.a.p0.w2.i.r;
import c.a.p0.w2.i.s;
import c.a.p0.w2.i.y;
import c.a.p0.w2.m.f.p;
import c.a.p0.w2.m.f.t0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerAdapter;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes3.dex */
public abstract class a extends c.a.p0.w2.q.i.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;

    /* renamed from: b  reason: collision with root package name */
    public DetailInfoAndReplyFragment f20467b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f20468c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.w2.i.f f20469d;

    /* renamed from: e  reason: collision with root package name */
    public final List<c.a.d.o.e.a> f20470e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f20471f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f20472g;

    /* renamed from: h  reason: collision with root package name */
    public String f20473h;
    public boolean i;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = BdUniqueId.gen();
        this.f20470e = new ArrayList();
        this.f20471f = true;
        this.f20473h = null;
        this.i = true;
        this.j = false;
        this.k = -1;
        this.l = -1;
        this.f20467b = detailInfoAndReplyFragment;
        this.f20468c = bdTypeRecyclerView;
    }

    public abstract void A(View.OnClickListener onClickListener);

    public abstract void B(c.a.p0.w2.i.f fVar);

    public void C(c.a.p0.w2.j.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
        }
    }

    public abstract void D(c.a.p0.w2.i.f fVar);

    public abstract void E(String str);

    public final void F() {
        c.a.p0.w2.i.f fVar;
        o oVar;
        o oVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (fVar = this.f20469d) == null || fVar.a0 || fVar.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = fVar.F();
        ArrayList<o> e2 = this.f20469d.e();
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
                next2.M0 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<o> it3 = e2.iterator();
        while (it3.hasNext()) {
            o next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int q = next3.getAdvertAppInfo().q();
                if (q != 0) {
                    c.a.p0.l3.m0.d.k(next3, q);
                    if (q != 28 && q != 31) {
                        next3.getAdvertAppInfo().f29816c = -1001;
                        Log.e("cq", "updateAppData，Data InValidate: " + q);
                    }
                }
                sparseArray.put(next3.getPosition(), next3);
            }
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < sparseArray.size(); i++) {
            o oVar3 = (o) sparseArray.get(sparseArray.keyAt(i));
            if (oVar3 != null && (oVar2 = (o) hashMap.put(oVar3.J0(), oVar3)) != null) {
                c.a.p0.l3.m0.d.k(oVar2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (oVar = (o) entry.getValue()) != null) {
                sparseArray.put(oVar.getPosition(), oVar);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
        }
        Collections.sort(arrayList);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            o oVar4 = (o) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
            if (this.f20469d.l() != null) {
                oVar4.G0 = this.f20469d.l().getId();
            }
            if (this.f20469d.O() != null) {
                oVar4.J0 = c.a.d.f.m.b.g(this.f20469d.O().getId(), 0L);
            }
            c.a.p0.w2.i.f fVar2 = this.f20469d;
            if (fVar2 != null && fVar2.y() != null) {
                oVar4.K0 = this.f20469d.y().a();
            }
            b(oVar4);
            int position = oVar4.getPosition() + this.f20469d.Z;
            if (position >= F.size()) {
                oVar4.M0 = position;
                c.a.p0.l3.m0.d.l(oVar4, 2, position + i3, F.size());
                return;
            }
            if (!this.f20471f) {
                position--;
                oVar4.M0 = position;
            }
            if (position < 0) {
                c.a.p0.l3.m0.d.k(oVar4, 23);
            } else if (h(F, position)) {
                c.a.p0.l3.m0.d.k(oVar4, 1);
            } else {
                F.add(position, oVar4);
                TiebaStatic.eventStat(this.f20467b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", oVar4.getAdvertAppInfo().s);
            }
        }
    }

    @Override // c.a.p0.w2.q.i.a
    public ArrayList<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f20472g : (ArrayList) invokeV.objValue;
    }

    public final void b(o oVar) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, oVar) == null) || oVar == null || this.f20469d == null || oVar.getAdvertAppInfo() == null) {
            return;
        }
        oVar.getAdvertAppInfo().j = new c.a.o0.r.r.e();
        if (this.f20469d.y() != null) {
            oVar.getAdvertAppInfo().j.f10837b = this.f20469d.y().a();
        }
        oVar.getAdvertAppInfo().j.a = oVar.L0();
        if (this.f20469d.l() != null && (l = this.f20469d.l()) != null) {
            oVar.getAdvertAppInfo().j.f10839d = l.getId();
            oVar.getAdvertAppInfo().j.f10840e = l.getFirst_class();
            oVar.getAdvertAppInfo().j.f10841f = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            oVar.getAdvertAppInfo().j.f10842g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        oVar.getAdvertAppInfo().j.f10843h = oVar.getAdvertAppInfo().f29821h;
        oVar.getAdvertAppInfo().j.i = false;
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

    public abstract t0 e();

    public abstract p f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public final boolean h(ArrayList<PostData> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.f20467b.w() != null) {
                return this.f20467b.w().w0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (this.f20468c.getAdapter() instanceof BdRecyclerAdapter)) {
            this.f20468c.getAdapter().notifyDataSetChanged();
        }
    }

    public abstract void l();

    public abstract void m();

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            boolean z = false;
            boolean z2 = false;
            for (int i = 0; i < this.f20472g.size(); i++) {
                n nVar = this.f20472g.get(i);
                if (nVar instanceof r) {
                    this.k = i;
                    z = true;
                } else if ((nVar instanceof c.a.p0.w2.i.e) && ((c.a.p0.w2.i.e) nVar).a() == this.a) {
                    this.l = i;
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

    public abstract void p(c.a.p0.w2.i.f fVar, boolean z, String str, boolean z2);

    public void q(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, fVar) == null) {
            r(fVar, false);
        }
    }

    public void r(c.a.p0.w2.i.f fVar, boolean z) {
        o oVar;
        PostData postData;
        boolean z2;
        c.a.p0.w2.i.f fVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048599, this, fVar, z) == null) || fVar == null) {
            return;
        }
        this.f20469d = fVar;
        if (fVar != null && fVar.O() != null && fVar.O().getAuthor() != null) {
            this.f20473h = fVar.O().getAuthor().getUserId();
        }
        if (this.f20472g == null) {
            this.f20472g = new ArrayList<>();
        }
        this.f20472g.clear();
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
            this.f20472g.add(postData);
        }
        D(fVar);
        E(this.f20473h);
        int i = 0;
        if (!ListUtils.isEmpty(fVar.F()) && fVar.F().get(0) != null && fVar.O() != null) {
            fVar.O().setItem(fVar.F().get(0).H());
            fVar.O().setItemStar(fVar.F().get(0).I());
        }
        if (fVar.O() != null && fVar.O().getRawThreadInfo() != null) {
            a2 a2Var = new a2();
            a2Var.s = fVar.O();
            a2Var.n = true;
            this.f20472g.add(a2Var);
        }
        s sVar = new s(fVar.O(), fVar.d());
        sVar.j(false);
        sVar.f19855b = false;
        this.f20472g.add(sVar);
        if (postData == null || postData.o0 == null || (fVar.l() != null && TextUtils.equals(fVar.l().getName(), this.f20467b.w().s0()) && this.f20467b.w().y0())) {
            z2 = false;
        } else {
            c.a.p0.w2.i.i iVar = new c.a.p0.w2.i.i(postData.o0);
            iVar.f19830b = this.f20467b.w().k1();
            this.f20472g.add(iVar);
            z2 = true;
        }
        if (!z2 && fVar.l() != null && !StringUtils.isNull(fVar.l().getName()) && (!TextUtils.equals(fVar.l().getName(), this.f20467b.w().s0()) || !this.f20467b.w().y0())) {
            c.a.p0.w2.i.h hVar = new c.a.p0.w2.i.h(fVar.l());
            hVar.f19827g = this.f20467b.w().k1();
            hVar.f19825e = false;
            this.f20472g.add(hVar);
            sVar.j(false);
            sVar.f19855b = false;
        }
        if (fVar.O() != null && !StringUtils.isNull(fVar.O().getForum_name())) {
            y yVar = new y();
            yVar.a = fVar.O();
            this.f20472g.add(yVar);
        } else if (fVar.O() != null && !StringUtils.isNull(fVar.n())) {
            fVar.O().setForum_name(fVar.n());
            y yVar2 = new y();
            yVar2.a = fVar.O();
            this.f20472g.add(yVar2);
        }
        r rVar = new r(r.f19847h);
        ThreadData O = fVar.O();
        if (O != null) {
            O.getReply_num();
        }
        this.f20467b.w().i1();
        rVar.f19850d = j();
        rVar.f19849c = fVar.f19820g;
        fVar.c();
        rVar.f19851e = fVar.g0();
        rVar.f19853g = fVar.f19819f;
        B(fVar);
        this.f20472g.add(rVar);
        if (fVar.L() == 4) {
            this.f20472g.add(new q());
        }
        F();
        o(i());
        Iterator<PostData> it2 = fVar.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            PostData next2 = it2.next();
            if ((next2 instanceof PostData) && next2.A() != 1) {
                this.f20472g.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !l.z()) && ((fVar2 = this.f20469d) == null || !fVar2.t()))) {
            c.a.p0.w2.i.o oVar2 = new c.a.p0.w2.i.o();
            oVar2.F0 = TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0ab6);
            oVar2.E0 = R.drawable.new_pic_emotion_03;
            oVar2.G0 = -2;
            oVar2.H0 = c.a.d.f.p.n.f(this.f20467b.getContext(), R.dimen.tbds74);
            this.f20472g.add(oVar2);
        }
        p(fVar, this.j, this.f20473h, this.i);
        if (fVar.y().b() == 0) {
            c.a.p0.w2.i.f fVar3 = this.f20469d;
            if (fVar3 != null && fVar3.t()) {
                A(this.f20467b.t().Z2());
                this.f20472g.add(new m());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.f20469d.m());
                statisticItem.param("fname", this.f20469d.n());
                statisticItem.param("tid", this.f20469d.Q());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                z(this.f20467b.t().Z2());
                c.a.p0.w2.i.l lVar = new c.a.p0.w2.i.l();
                lVar.a = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09e6);
                this.f20472g.add(lVar);
            }
            List<o> Y = fVar.Y();
            int i2 = -1;
            if (Y != null && !Y.isEmpty()) {
                oVar = Y.get(0);
                i2 = oVar.getPosition();
            }
            if (!ListUtils.isEmpty(fVar.f())) {
                c.a.p0.w2.i.e eVar = new c.a.p0.w2.i.e();
                eVar.f(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f69));
                eVar.e(this.a);
                this.f20472g.add(eVar);
                int i3 = 1;
                for (c.a.o0.r.r.q qVar : fVar.f()) {
                    if (Y != null && i3 == i2) {
                        if (oVar != null) {
                            b(oVar);
                            this.f20472g.add(oVar);
                            i++;
                            if (oVar.getType() != AdvertAppInfo.x) {
                                i3++;
                            }
                        }
                        if (i < Y.size()) {
                            o oVar3 = Y.get(i);
                            oVar = oVar3;
                            i2 = oVar3.getPosition();
                        }
                    }
                    this.f20472g.add(qVar);
                    i3++;
                    if (i3 == 4 && fVar.C() != null) {
                        this.f20472g.add(fVar.C());
                        i3++;
                    }
                }
            }
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.f20468c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setData(this.f20472g);
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
            this.f20471f = z;
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
