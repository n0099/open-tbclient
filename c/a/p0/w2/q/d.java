package c.a.p0.w2.q;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.p0.a4.k0.o;
import c.a.p0.l3.u;
import c.a.p0.l3.z;
import c.a.p0.w2.m.f.p;
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
public class d extends c.a.p0.w2.q.i.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ReplyFragment a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f20446b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.w2.i.f f20447c;

    /* renamed from: d  reason: collision with root package name */
    public final List<c.a.d.o.e.a> f20448d;

    /* renamed from: e  reason: collision with root package name */
    public p f20449e;

    /* renamed from: f  reason: collision with root package name */
    public PbReplyLoadMoreAdapter f20450f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.d.o.e.a f20451g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.d.o.e.a f20452h;
    public boolean i;
    public ArrayList<PostData> j;
    public ArrayList<n> k;
    public String l;
    public boolean m;
    public boolean n;
    public View.OnClickListener o;
    public View.OnClickListener p;
    public TbRichTextView.y q;
    public c.a.p0.w2.j.c r;
    public View.OnLongClickListener s;

    public d(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {replyFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20448d = new ArrayList();
        this.i = true;
        this.l = null;
        this.m = true;
        this.n = false;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.a = replyFragment;
        this.f20446b = bdTypeRecyclerView;
        d();
    }

    @Override // c.a.p0.w2.q.i.a
    public ArrayList<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (ArrayList) invokeV.objValue;
    }

    public final void b(o oVar) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oVar) == null) || oVar == null || this.f20447c == null || oVar.getAdvertAppInfo() == null) {
            return;
        }
        oVar.getAdvertAppInfo().j = new c.a.o0.r.r.e();
        if (this.f20447c.y() != null) {
            oVar.getAdvertAppInfo().j.f10837b = this.f20447c.y().a();
        }
        oVar.getAdvertAppInfo().j.a = oVar.L0();
        if (this.f20447c.l() != null && (l = this.f20447c.l()) != null) {
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

    public final boolean c(ArrayList<PostData> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof o) {
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
            p pVar = new p(this.a.t(), PostData.w0);
            this.f20449e = pVar;
            pVar.Q0(this.a.t());
            this.f20450f = new PbReplyLoadMoreAdapter(this.a.t(), PostData.C0);
            this.f20451g = z.q().a(this.a.t().getBaseFragmentActivity(), AdvertAppInfo.x);
            this.f20452h = z.q().a(this.a.t().getBaseFragmentActivity(), AdvertAppInfo.z);
            this.f20448d.add(this.f20451g);
            this.f20448d.add(this.f20452h);
            this.f20448d.add(this.f20449e);
            this.f20448d.add(this.f20450f);
            this.f20446b.a(this.f20448d);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (this.f20446b.getAdapter() instanceof BdRecyclerAdapter)) {
            this.f20446b.getAdapter().notifyDataSetChanged();
        }
    }

    public void f(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f20447c = fVar;
        if (fVar != null && fVar.O() != null && fVar.O().getAuthor() != null) {
            this.l = fVar.O().getAuthor().getUserId();
        }
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.clear();
        c.a.p0.w2.i.f fVar2 = this.f20447c;
        if (fVar2 != null && fVar2.F() != null && this.f20447c.F().size() > 0) {
            this.j.addAll(this.f20447c.F());
        }
        this.f20449e.t(fVar);
        this.f20449e.setFromCDN(this.n);
        this.f20449e.q(this.l);
        this.f20449e.c(this.m);
        this.f20449e.e(this.p);
        this.f20449e.m(this.o);
        this.f20449e.p(this.q);
        this.f20449e.d(this.s);
        this.f20449e.P0(this.r);
        this.f20450f.d0(this.p);
        n();
        c.a.d.o.e.a aVar = this.f20452h;
        if (aVar != null && (aVar instanceof u)) {
            ((u) aVar).k(this.n);
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
        BdTypeRecyclerView bdTypeRecyclerView = this.f20446b;
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
            this.i = z;
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

    public void m(c.a.p0.w2.j.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.r = cVar;
        }
    }

    public final void n() {
        c.a.p0.w2.i.f fVar;
        o oVar;
        o oVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (fVar = this.f20447c) == null || fVar.a0 || fVar.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = fVar.F();
        ArrayList<o> e2 = this.f20447c.e();
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
            if (this.f20447c.l() != null) {
                oVar4.G0 = this.f20447c.l().getId();
            }
            if (this.f20447c.O() != null) {
                oVar4.J0 = c.a.d.f.m.b.g(this.f20447c.O().getId(), 0L);
            }
            c.a.p0.w2.i.f fVar2 = this.f20447c;
            if (fVar2 != null && fVar2.y() != null) {
                oVar4.K0 = this.f20447c.y().a();
            }
            b(oVar4);
            int position = oVar4.getPosition() + this.f20447c.Z;
            if (position >= F.size()) {
                oVar4.M0 = position;
                c.a.p0.l3.m0.d.l(oVar4, 2, position + i3, c.a.p0.b2.o.k.a.k(arrayList));
                return;
            }
            if (!this.i) {
                position--;
                oVar4.M0 = position;
            }
            if (position < 0) {
                c.a.p0.l3.m0.d.k(oVar4, 23);
            } else if (c(F, position)) {
                c.a.p0.l3.m0.d.k(oVar4, 1);
            } else {
                F.add(position, oVar4);
                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", oVar4.getAdvertAppInfo().s);
            }
        }
    }
}
