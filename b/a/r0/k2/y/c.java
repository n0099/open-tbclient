package b.a.r0.k2.y;

import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.e.l.e.n;
import b.a.r0.k2.r.f;
import b.a.r0.k2.u.f.l;
import b.a.r0.l3.j0.p;
import b.a.r0.z2.t;
import b.a.r0.z2.y;
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
    public ReplyFragment f19728a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f19729b;

    /* renamed from: c  reason: collision with root package name */
    public f f19730c;

    /* renamed from: d  reason: collision with root package name */
    public final List<b.a.e.l.e.a> f19731d;

    /* renamed from: e  reason: collision with root package name */
    public l f19732e;

    /* renamed from: f  reason: collision with root package name */
    public PbReplyLoadMoreAdapter f19733f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.e.l.e.a f19734g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.e.l.e.a f19735h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f19736i;
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
        this.f19731d = new ArrayList();
        this.f19736i = true;
        this.l = null;
        this.m = true;
        this.n = false;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.f19728a = replyFragment;
        this.f19729b = bdTypeRecyclerView;
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
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar) == null) || pVar == null || this.f19730c == null || pVar.getAdvertAppInfo() == null) {
            return;
        }
        pVar.getAdvertAppInfo().g4 = new b.a.q0.s.q.e();
        if (this.f19730c.y() != null) {
            pVar.getAdvertAppInfo().g4.f13277b = this.f19730c.y().a();
        }
        pVar.getAdvertAppInfo().g4.f13276a = pVar.K0();
        if (this.f19730c.l() != null && (l = this.f19730c.l()) != null) {
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
            l lVar = new l(this.f19728a.getVideoPbFragment(), PostData.y0);
            this.f19732e = lVar;
            lVar.X0(this.f19728a.getVideoPbFragment());
            this.f19733f = new PbReplyLoadMoreAdapter(this.f19728a.getVideoPbFragment(), PostData.E0);
            this.f19734g = y.o().a(this.f19728a.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.s4);
            this.f19735h = y.o().a(this.f19728a.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.u4);
            this.f19731d.add(this.f19734g);
            this.f19731d.add(this.f19735h);
            this.f19731d.add(this.f19732e);
            this.f19731d.add(this.f19733f);
            this.f19729b.addAdapters(this.f19731d);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (this.f19729b.getAdapter() instanceof BdRecyclerAdapter)) {
            this.f19729b.getAdapter().notifyDataSetChanged();
        }
    }

    public void f(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f19730c = fVar;
        if (fVar != null && fVar.O() != null && fVar.O().J() != null) {
            this.l = fVar.O().J().getUserId();
        }
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.clear();
        f fVar2 = this.f19730c;
        if (fVar2 != null && fVar2.F() != null && this.f19730c.F().size() > 0) {
            this.j.addAll(this.f19730c.F());
        }
        this.f19732e.t(fVar);
        this.f19732e.setFromCDN(this.n);
        this.f19732e.q(this.l);
        this.f19732e.c(this.m);
        this.f19732e.e(this.p);
        this.f19732e.m(this.o);
        this.f19732e.p(this.q);
        this.f19732e.d(this.s);
        this.f19732e.W0(this.r);
        this.f19733f.k0(this.p);
        n();
        b.a.e.l.e.a aVar = this.f19735h;
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
        BdTypeRecyclerView bdTypeRecyclerView = this.f19729b;
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
            this.f19736i = z;
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
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (fVar = this.f19730c) == null || fVar.a0 || fVar.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = fVar.F();
        ArrayList<p> e2 = this.f19730c.e();
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
            if (this.f19730c.l() != null) {
                pVar4.I0 = this.f19730c.l().getId();
            }
            if (this.f19730c.O() != null) {
                pVar4.L0 = b.a.e.e.m.b.g(this.f19730c.O().f0(), 0L);
            }
            f fVar2 = this.f19730c;
            if (fVar2 != null && fVar2.y() != null) {
                pVar4.M0 = this.f19730c.y().a();
            }
            b(pVar4);
            int position = pVar4.getPosition() + this.f19730c.Z;
            if (position >= F.size()) {
                pVar4.O0 = position;
                b.a.r0.z2.l0.d.l(pVar4, 2, position + i4, b.a.r0.q1.o.k.a.k(arrayList));
                return;
            }
            if (!this.f19736i) {
                position--;
                pVar4.O0 = position;
            }
            if (position < 0) {
                b.a.r0.z2.l0.d.k(pVar4, 23);
            } else if (c(F, position)) {
                b.a.r0.z2.l0.d.k(pVar4, 1);
            } else {
                F.add(position, pVar4);
                TiebaStatic.eventStat(this.f19728a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", pVar4.getAdvertAppInfo().p4);
            }
        }
    }
}
