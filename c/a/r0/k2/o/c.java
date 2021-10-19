package c.a.r0.k2.o;

import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.l.e.n;
import c.a.r0.k2.k.e.l;
import c.a.r0.k3.i0.p;
import c.a.r0.z2.t;
import c.a.r0.z2.y;
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
public class c extends c.a.r0.k2.o.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ReplyFragment f20747a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f20748b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.k2.h.e f20749c;

    /* renamed from: d  reason: collision with root package name */
    public final List<c.a.e.l.e.a> f20750d;

    /* renamed from: e  reason: collision with root package name */
    public l f20751e;

    /* renamed from: f  reason: collision with root package name */
    public PbReplyLoadMoreAdapter f20752f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.e.l.e.a f20753g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.e.l.e.a f20754h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20755i;

    /* renamed from: j  reason: collision with root package name */
    public ArrayList<PostData> f20756j;
    public ArrayList<n> k;
    public String l;
    public boolean m;
    public boolean n;
    public View.OnClickListener o;
    public View.OnClickListener p;
    public TbRichTextView.z q;
    public c.a.r0.k2.i.c r;
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
        this.f20750d = new ArrayList();
        this.f20755i = true;
        this.l = null;
        this.m = true;
        this.n = false;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.f20747a = replyFragment;
        this.f20748b = bdTypeRecyclerView;
        d();
    }

    @Override // c.a.r0.k2.o.h.a
    public ArrayList<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (ArrayList) invokeV.objValue;
    }

    public final void b(p pVar) {
        ForumData m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar) == null) || pVar == null || this.f20749c == null || pVar.getAdvertAppInfo() == null) {
            return;
        }
        pVar.getAdvertAppInfo().g4 = new c.a.q0.s.q.e();
        if (this.f20749c.y() != null) {
            pVar.getAdvertAppInfo().g4.f14167b = this.f20749c.y().a();
        }
        pVar.getAdvertAppInfo().g4.f14166a = pVar.G0();
        if (this.f20749c.m() != null && (m = this.f20749c.m()) != null) {
            pVar.getAdvertAppInfo().g4.f14169d = m.getId();
            pVar.getAdvertAppInfo().g4.f14170e = m.getFirst_class();
            pVar.getAdvertAppInfo().g4.f14171f = m.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            pVar.getAdvertAppInfo().g4.f14172g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        pVar.getAdvertAppInfo().g4.f14173h = pVar.getAdvertAppInfo().e4;
        pVar.getAdvertAppInfo().g4.f14174i = false;
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
            l lVar = new l(this.f20747a.getVideoPbFragment(), PostData.v0);
            this.f20751e = lVar;
            lVar.X0(this.f20747a.getVideoPbFragment());
            this.f20752f = new PbReplyLoadMoreAdapter(this.f20747a.getVideoPbFragment(), PostData.B0);
            this.f20753g = y.o().a(this.f20747a.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.s4);
            this.f20754h = y.o().a(this.f20747a.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.u4);
            this.f20750d.add(this.f20753g);
            this.f20750d.add(this.f20754h);
            this.f20750d.add(this.f20751e);
            this.f20750d.add(this.f20752f);
            this.f20748b.addAdapters(this.f20750d);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (this.f20748b.getAdapter() instanceof BdRecyclerAdapter)) {
            this.f20748b.getAdapter().notifyDataSetChanged();
        }
    }

    public void f(c.a.r0.k2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) || eVar == null) {
            return;
        }
        this.f20749c = eVar;
        if (eVar != null && eVar.O() != null && eVar.O().J() != null) {
            this.l = eVar.O().J().getUserId();
        }
        if (this.f20756j == null) {
            this.f20756j = new ArrayList<>();
        }
        this.f20756j.clear();
        c.a.r0.k2.h.e eVar2 = this.f20749c;
        if (eVar2 != null && eVar2.F() != null && this.f20749c.F().size() > 0) {
            this.f20756j.addAll(this.f20749c.F());
        }
        this.f20751e.t(eVar);
        this.f20751e.setFromCDN(this.n);
        this.f20751e.q(this.l);
        this.f20751e.c(this.m);
        this.f20751e.e(this.p);
        this.f20751e.m(this.o);
        this.f20751e.p(this.q);
        this.f20751e.d(this.s);
        this.f20751e.W0(this.r);
        this.f20752f.l0(this.p);
        n();
        c.a.e.l.e.a aVar = this.f20754h;
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
        BdTypeRecyclerView bdTypeRecyclerView = this.f20748b;
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
            this.f20755i = z;
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

    public void m(c.a.r0.k2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.r = cVar;
        }
    }

    public final void n() {
        c.a.r0.k2.h.e eVar;
        p pVar;
        p pVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (eVar = this.f20749c) == null || eVar.a0 || eVar.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = eVar.F();
        ArrayList<p> e2 = this.f20749c.e();
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
                    c.a.r0.z2.l0.d.j(next3, S4);
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
                c.a.r0.z2.l0.d.j(pVar2, 30);
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
            if (this.f20749c.m() != null) {
                pVar4.F0 = this.f20749c.m().getId();
            }
            if (this.f20749c.O() != null) {
                pVar4.I0 = c.a.e.e.m.b.g(this.f20749c.O().f0(), 0L);
            }
            c.a.r0.k2.h.e eVar2 = this.f20749c;
            if (eVar2 != null && eVar2.y() != null) {
                pVar4.J0 = this.f20749c.y().a();
            }
            b(pVar4);
            int position = pVar4.getPosition() + this.f20749c.Z;
            if (position >= F.size()) {
                pVar4.L0 = position;
                c.a.r0.z2.l0.d.k(pVar4, 2, position + i4, c.a.r0.q1.o.k.a.k(arrayList));
                return;
            }
            if (!this.f20755i) {
                position--;
                pVar4.L0 = position;
            }
            if (position < 0) {
                c.a.r0.z2.l0.d.j(pVar4, 23);
            } else if (c(F, position)) {
                c.a.r0.z2.l0.d.j(pVar4, 1);
            } else {
                F.add(position, pVar4);
                TiebaStatic.eventStat(this.f20747a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", pVar4.getAdvertAppInfo().p4);
            }
        }
    }
}
