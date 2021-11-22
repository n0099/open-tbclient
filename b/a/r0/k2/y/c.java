package b.a.r0.k2.y;

import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.e.m.e.n;
import b.a.r0.a3.t;
import b.a.r0.a3.y;
import b.a.r0.k2.r.f;
import b.a.r0.k2.u.f.l;
import b.a.r0.m3.j0.p;
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
/* loaded from: classes5.dex */
public class c extends b.a.r0.k2.y.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ReplyFragment f21265a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f21266b;

    /* renamed from: c  reason: collision with root package name */
    public f f21267c;

    /* renamed from: d  reason: collision with root package name */
    public final List<b.a.e.m.e.a> f21268d;

    /* renamed from: e  reason: collision with root package name */
    public l f21269e;

    /* renamed from: f  reason: collision with root package name */
    public PbReplyLoadMoreAdapter f21270f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.e.m.e.a f21271g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.e.m.e.a f21272h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f21273i;
    public ArrayList<PostData> j;
    public ArrayList<n> k;
    public String l;
    public boolean m;
    public boolean n;
    public View.OnClickListener o;
    public View.OnClickListener p;
    public TbRichTextView.z q;
    public b.a.r0.k2.s.c r;
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
        this.f21268d = new ArrayList();
        this.f21273i = true;
        this.l = null;
        this.m = true;
        this.n = false;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.f21265a = replyFragment;
        this.f21266b = bdTypeRecyclerView;
        d();
    }

    @Override // b.a.r0.k2.y.h.a
    public ArrayList<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (ArrayList) invokeV.objValue;
    }

    public final void b(p pVar) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar) == null) || pVar == null || this.f21267c == null || pVar.getAdvertAppInfo() == null) {
            return;
        }
        pVar.getAdvertAppInfo().h4 = new b.a.q0.s.q.e();
        if (this.f21267c.y() != null) {
            pVar.getAdvertAppInfo().h4.f14057b = this.f21267c.y().a();
        }
        pVar.getAdvertAppInfo().h4.f14056a = pVar.K0();
        if (this.f21267c.l() != null && (l = this.f21267c.l()) != null) {
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
            l lVar = new l(this.f21265a.getVideoPbFragment(), PostData.y0);
            this.f21269e = lVar;
            lVar.X0(this.f21265a.getVideoPbFragment());
            this.f21270f = new PbReplyLoadMoreAdapter(this.f21265a.getVideoPbFragment(), PostData.E0);
            this.f21271g = y.o().a(this.f21265a.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.t4);
            this.f21272h = y.o().a(this.f21265a.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.v4);
            this.f21268d.add(this.f21271g);
            this.f21268d.add(this.f21272h);
            this.f21268d.add(this.f21269e);
            this.f21268d.add(this.f21270f);
            this.f21266b.addAdapters(this.f21268d);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (this.f21266b.getAdapter() instanceof BdRecyclerAdapter)) {
            this.f21266b.getAdapter().notifyDataSetChanged();
        }
    }

    public void f(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f21267c = fVar;
        if (fVar != null && fVar.O() != null && fVar.O().J() != null) {
            this.l = fVar.O().J().getUserId();
        }
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.clear();
        f fVar2 = this.f21267c;
        if (fVar2 != null && fVar2.F() != null && this.f21267c.F().size() > 0) {
            this.j.addAll(this.f21267c.F());
        }
        this.f21269e.t(fVar);
        this.f21269e.setFromCDN(this.n);
        this.f21269e.q(this.l);
        this.f21269e.c(this.m);
        this.f21269e.e(this.p);
        this.f21269e.m(this.o);
        this.f21269e.p(this.q);
        this.f21269e.d(this.s);
        this.f21269e.W0(this.r);
        this.f21270f.k0(this.p);
        n();
        b.a.e.m.e.a aVar = this.f21272h;
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
        BdTypeRecyclerView bdTypeRecyclerView = this.f21266b;
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
            this.f21273i = z;
        }
    }

    public void i(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    public void j(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, zVar) == null) {
            this.q = zVar;
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

    public void m(b.a.r0.k2.s.c cVar) {
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
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (fVar = this.f21267c) == null || fVar.a0 || fVar.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = fVar.F();
        ArrayList<p> e2 = this.f21267c.e();
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
            if (this.f21267c.l() != null) {
                pVar4.I0 = this.f21267c.l().getId();
            }
            if (this.f21267c.O() != null) {
                pVar4.L0 = b.a.e.f.m.b.g(this.f21267c.O().f0(), 0L);
            }
            f fVar2 = this.f21267c;
            if (fVar2 != null && fVar2.y() != null) {
                pVar4.M0 = this.f21267c.y().a();
            }
            b(pVar4);
            int position = pVar4.getPosition() + this.f21267c.Z;
            if (position >= F.size()) {
                pVar4.O0 = position;
                b.a.r0.a3.l0.d.l(pVar4, 2, position + i4, b.a.r0.q1.o.k.a.k(arrayList));
                return;
            }
            if (!this.f21273i) {
                position--;
                pVar4.O0 = position;
            }
            if (position < 0) {
                b.a.r0.a3.l0.d.k(pVar4, 23);
            } else if (c(F, position)) {
                b.a.r0.a3.l0.d.k(pVar4, 1);
            } else {
                F.add(position, pVar4);
                TiebaStatic.eventStat(this.f21265a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", pVar4.getAdvertAppInfo().q4);
            }
        }
    }
}
