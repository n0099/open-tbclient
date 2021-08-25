package c.a.q0.i2.o;

import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.l.e.n;
import c.a.q0.i2.k.e.k;
import c.a.q0.i3.i0.p;
import c.a.q0.x2.t;
import c.a.q0.x2.y;
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
/* loaded from: classes3.dex */
public class c extends c.a.q0.i2.o.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ReplyFragment f19991a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f19992b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.q0.i2.h.e f19993c;

    /* renamed from: d  reason: collision with root package name */
    public final List<c.a.e.l.e.a> f19994d;

    /* renamed from: e  reason: collision with root package name */
    public k f19995e;

    /* renamed from: f  reason: collision with root package name */
    public PbReplyLoadMoreAdapter f19996f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.e.l.e.a f19997g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.e.l.e.a f19998h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f19999i;

    /* renamed from: j  reason: collision with root package name */
    public ArrayList<PostData> f20000j;
    public ArrayList<n> k;
    public String l;
    public boolean m;
    public boolean n;
    public View.OnClickListener o;
    public View.OnClickListener p;
    public TbRichTextView.z q;
    public c.a.q0.i2.i.c r;
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
        this.f19994d = new ArrayList();
        this.f19999i = true;
        this.l = null;
        this.m = true;
        this.n = false;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.f19991a = replyFragment;
        this.f19992b = bdTypeRecyclerView;
        d();
    }

    @Override // c.a.q0.i2.o.h.a
    public ArrayList<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (ArrayList) invokeV.objValue;
    }

    public final void b(p pVar) {
        ForumData m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar) == null) || pVar == null || this.f19993c == null || pVar.getAdvertAppInfo() == null) {
            return;
        }
        pVar.getAdvertAppInfo().c4 = new c.a.p0.s.q.e();
        if (this.f19993c.y() != null) {
            pVar.getAdvertAppInfo().c4.f14193b = this.f19993c.y().a();
        }
        pVar.getAdvertAppInfo().c4.f14192a = pVar.E0();
        if (this.f19993c.m() != null && (m = this.f19993c.m()) != null) {
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
            k kVar = new k(this.f19991a.getVideoPbFragment(), PostData.v0);
            this.f19995e = kVar;
            kVar.X0(this.f19991a.getVideoPbFragment());
            this.f19996f = new PbReplyLoadMoreAdapter(this.f19991a.getVideoPbFragment(), PostData.B0);
            this.f19997g = y.o().a(this.f19991a.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.o4);
            this.f19998h = y.o().a(this.f19991a.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.q4);
            this.f19994d.add(this.f19997g);
            this.f19994d.add(this.f19998h);
            this.f19994d.add(this.f19995e);
            this.f19994d.add(this.f19996f);
            this.f19992b.addAdapters(this.f19994d);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (this.f19992b.getAdapter() instanceof BdRecyclerAdapter)) {
            this.f19992b.getAdapter().notifyDataSetChanged();
        }
    }

    public void f(c.a.q0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) || eVar == null) {
            return;
        }
        this.f19993c = eVar;
        if (eVar != null && eVar.O() != null && eVar.O().J() != null) {
            this.l = eVar.O().J().getUserId();
        }
        if (this.f20000j == null) {
            this.f20000j = new ArrayList<>();
        }
        this.f20000j.clear();
        c.a.q0.i2.h.e eVar2 = this.f19993c;
        if (eVar2 != null && eVar2.F() != null && this.f19993c.F().size() > 0) {
            this.f20000j.addAll(this.f19993c.F());
        }
        this.f19995e.t(eVar);
        this.f19995e.setFromCDN(this.n);
        this.f19995e.q(this.l);
        this.f19995e.c(this.m);
        this.f19995e.e(this.p);
        this.f19995e.m(this.o);
        this.f19995e.p(this.q);
        this.f19995e.d(this.s);
        this.f19995e.W0(this.r);
        this.f19996f.l0(this.p);
        n();
        c.a.e.l.e.a aVar = this.f19998h;
        if (aVar != null && (aVar instanceof t)) {
            ((t) aVar).k(this.n);
        }
        ArrayList<n> arrayList = new ArrayList<>(eVar.F());
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
        BdTypeRecyclerView bdTypeRecyclerView = this.f19992b;
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
            this.f19999i = z;
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

    public void m(c.a.q0.i2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.r = cVar;
        }
    }

    public final void n() {
        c.a.q0.i2.h.e eVar;
        p pVar;
        p pVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (eVar = this.f19993c) == null || eVar.a0 || eVar.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = eVar.F();
        ArrayList<p> e2 = this.f19993c.e();
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
            if (this.f19993c.m() != null) {
                pVar4.F0 = this.f19993c.m().getId();
            }
            if (this.f19993c.O() != null) {
                pVar4.I0 = c.a.e.e.m.b.f(this.f19993c.O().f0(), 0L);
            }
            c.a.q0.i2.h.e eVar2 = this.f19993c;
            if (eVar2 != null && eVar2.y() != null) {
                pVar4.J0 = this.f19993c.y().a();
            }
            b(pVar4);
            int position = pVar4.getPosition() + this.f19993c.Z;
            if (position >= F.size()) {
                pVar4.L0 = position;
                c.a.q0.x2.l0.d.k(pVar4, 2, position + i4, c.a.q0.o1.o.k.a.k(arrayList));
                return;
            }
            if (!this.f19999i) {
                position--;
                pVar4.L0 = position;
            }
            if (position < 0) {
                c.a.q0.x2.l0.d.j(pVar4, 23);
            } else if (c(F, position)) {
                c.a.q0.x2.l0.d.j(pVar4, 1);
            } else {
                F.add(position, pVar4);
                TiebaStatic.eventStat(this.f19991a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", pVar4.getAdvertAppInfo().l4);
            }
        }
    }
}
