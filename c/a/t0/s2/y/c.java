package c.a.t0.s2.y;

import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.n.e.n;
import c.a.t0.j3.t;
import c.a.t0.j3.y;
import c.a.t0.s2.r.f;
import c.a.t0.s2.u.f.l;
import c.a.t0.w3.j0.p;
import com.baidu.adp.widget.ListView.BdRecyclerAdapter;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.adapter.PbReplyLoadMoreAdapter;
import com.baidu.tieba.pb.videopb.fragment.ReplyFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
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
public class c extends c.a.t0.s2.y.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ReplyFragment a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f23250b;

    /* renamed from: c  reason: collision with root package name */
    public f f23251c;

    /* renamed from: d  reason: collision with root package name */
    public final List<c.a.d.n.e.a> f23252d;

    /* renamed from: e  reason: collision with root package name */
    public l f23253e;

    /* renamed from: f  reason: collision with root package name */
    public PbReplyLoadMoreAdapter f23254f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.d.n.e.a f23255g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.d.n.e.a f23256h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f23257i;

    /* renamed from: j  reason: collision with root package name */
    public ArrayList<PostData> f23258j;
    public ArrayList<n> k;
    public String l;
    public boolean m;
    public boolean n;
    public View.OnClickListener o;
    public View.OnClickListener p;
    public TbRichTextView.y q;
    public c.a.t0.s2.s.c r;
    public View.OnLongClickListener s;

    public c(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {replyFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23252d = new ArrayList();
        this.f23257i = true;
        this.l = null;
        this.m = true;
        this.n = false;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.a = replyFragment;
        this.f23250b = bdTypeRecyclerView;
        d();
    }

    @Override // c.a.t0.s2.y.h.a
    public ArrayList<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (ArrayList) invokeV.objValue;
    }

    public final void b(p pVar) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar) == null) || pVar == null || this.f23251c == null || pVar.getAdvertAppInfo() == null) {
            return;
        }
        pVar.getAdvertAppInfo().o4 = new c.a.s0.s.q.e();
        if (this.f23251c.y() != null) {
            pVar.getAdvertAppInfo().o4.f13350b = this.f23251c.y().a();
        }
        pVar.getAdvertAppInfo().o4.a = pVar.L0();
        if (this.f23251c.l() != null && (l = this.f23251c.l()) != null) {
            pVar.getAdvertAppInfo().o4.f13352d = l.getId();
            pVar.getAdvertAppInfo().o4.f13353e = l.getFirst_class();
            pVar.getAdvertAppInfo().o4.f13354f = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            pVar.getAdvertAppInfo().o4.f13355g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        pVar.getAdvertAppInfo().o4.f13356h = pVar.getAdvertAppInfo().m4;
        pVar.getAdvertAppInfo().o4.f13357i = false;
    }

    public final boolean c(ArrayList<PostData> arrayList, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, arrayList, i2)) == null) {
            for (int max = Math.max(i2 - 4, 0); max < arrayList.size() && max < i2 + 4; max++) {
                if (arrayList.get(max) instanceof p) {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            l lVar = new l(this.a.getVideoPbFragment(), PostData.A0);
            this.f23253e = lVar;
            lVar.Q0(this.a.getVideoPbFragment());
            this.f23254f = new PbReplyLoadMoreAdapter(this.a.getVideoPbFragment(), PostData.G0);
            this.f23255g = y.q().a(this.a.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.B4);
            this.f23256h = y.q().a(this.a.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.D4);
            this.f23252d.add(this.f23255g);
            this.f23252d.add(this.f23256h);
            this.f23252d.add(this.f23253e);
            this.f23252d.add(this.f23254f);
            this.f23250b.addAdapters(this.f23252d);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (this.f23250b.getAdapter() instanceof BdRecyclerAdapter)) {
            this.f23250b.getAdapter().notifyDataSetChanged();
        }
    }

    public void f(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f23251c = fVar;
        if (fVar != null && fVar.O() != null && fVar.O().J() != null) {
            this.l = fVar.O().J().getUserId();
        }
        if (this.f23258j == null) {
            this.f23258j = new ArrayList<>();
        }
        this.f23258j.clear();
        f fVar2 = this.f23251c;
        if (fVar2 != null && fVar2.F() != null && this.f23251c.F().size() > 0) {
            this.f23258j.addAll(this.f23251c.F());
        }
        this.f23253e.t(fVar);
        this.f23253e.setFromCDN(this.n);
        this.f23253e.q(this.l);
        this.f23253e.c(this.m);
        this.f23253e.e(this.p);
        this.f23253e.m(this.o);
        this.f23253e.p(this.q);
        this.f23253e.d(this.s);
        this.f23253e.P0(this.r);
        this.f23254f.d0(this.p);
        n();
        c.a.d.n.e.a aVar = this.f23256h;
        if (aVar != null && (aVar instanceof t)) {
            ((t) aVar).k(this.n);
        }
        ArrayList<n> arrayList = new ArrayList<>(fVar.F());
        boolean z = false;
        PostData postData = null;
        Iterator<n> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            n next = it.next();
            if (next instanceof PostData) {
                PostData postData2 = (PostData) next;
                if (postData2.A() == 1) {
                    postData = postData2;
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            arrayList.remove(postData);
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.f23250b;
        if (bdTypeRecyclerView != null) {
            this.k = arrayList;
            bdTypeRecyclerView.setData(arrayList);
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.n = z;
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f23257i = z;
        }
    }

    public void i(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    public void j(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, yVar) == null) {
            this.q = yVar;
        }
    }

    public void k(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onLongClickListener) == null) {
            this.s = onLongClickListener;
        }
    }

    public void l(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.p = onClickListener;
        }
    }

    public void m(c.a.t0.s2.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.r = cVar;
        }
    }

    public final void n() {
        f fVar;
        p pVar;
        p pVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (fVar = this.f23251c) == null || fVar.a0 || fVar.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = fVar.F();
        ArrayList<p> e2 = this.f23251c.e();
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
                int Y4 = next3.getAdvertAppInfo().Y4();
                if (Y4 != 0) {
                    c.a.t0.j3.l0.d.k(next3, Y4);
                    if (Y4 != 28 && Y4 != 31) {
                        next3.getAdvertAppInfo().h4 = -1001;
                        String str = "updateAppData，Data InValidate: " + Y4;
                    }
                }
                sparseArray.put(next3.getPosition(), next3);
            }
        }
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            p pVar3 = (p) sparseArray.get(sparseArray.keyAt(i2));
            if (pVar3 != null && (pVar2 = (p) hashMap.put(pVar3.J0(), pVar3)) != null) {
                c.a.t0.j3.l0.d.k(pVar2, 30);
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
            if (this.f23251c.l() != null) {
                pVar4.K0 = this.f23251c.l().getId();
            }
            if (this.f23251c.O() != null) {
                pVar4.N0 = c.a.d.f.m.b.g(this.f23251c.O().g0(), 0L);
            }
            f fVar2 = this.f23251c;
            if (fVar2 != null && fVar2.y() != null) {
                pVar4.O0 = this.f23251c.y().a();
            }
            b(pVar4);
            int position = pVar4.getPosition() + this.f23251c.Z;
            if (position >= F.size()) {
                pVar4.Q0 = position;
                c.a.t0.j3.l0.d.l(pVar4, 2, position + i4, c.a.t0.x1.o.k.a.k(arrayList));
                return;
            }
            if (!this.f23257i) {
                position--;
                pVar4.Q0 = position;
            }
            if (position < 0) {
                c.a.t0.j3.l0.d.k(pVar4, 23);
            } else if (c(F, position)) {
                c.a.t0.j3.l0.d.k(pVar4, 1);
            } else {
                F.add(position, pVar4);
                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", pVar4.getAdvertAppInfo().x4);
            }
        }
    }
}
