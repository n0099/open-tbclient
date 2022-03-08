package c.a.r0.u2.o;

import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.r0.j3.u;
import c.a.r0.j3.z;
import c.a.r0.u2.k.f.m;
import c.a.r0.y3.k0.o;
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
/* loaded from: classes2.dex */
public class d extends c.a.r0.u2.o.i.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ReplyFragment a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f23942b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.u2.h.f f23943c;

    /* renamed from: d  reason: collision with root package name */
    public final List<c.a.d.o.e.a> f23944d;

    /* renamed from: e  reason: collision with root package name */
    public m f23945e;

    /* renamed from: f  reason: collision with root package name */
    public PbReplyLoadMoreAdapter f23946f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.d.o.e.a f23947g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.d.o.e.a f23948h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f23949i;

    /* renamed from: j  reason: collision with root package name */
    public ArrayList<PostData> f23950j;
    public ArrayList<n> k;
    public String l;
    public boolean m;
    public boolean n;
    public View.OnClickListener o;
    public View.OnClickListener p;
    public TbRichTextView.y q;
    public c.a.r0.u2.i.c r;
    public View.OnLongClickListener s;

    public d(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.f23944d = new ArrayList();
        this.f23949i = true;
        this.l = null;
        this.m = true;
        this.n = false;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.a = replyFragment;
        this.f23942b = bdTypeRecyclerView;
        d();
    }

    @Override // c.a.r0.u2.o.i.a
    public ArrayList<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (ArrayList) invokeV.objValue;
    }

    public final void b(o oVar) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oVar) == null) || oVar == null || this.f23943c == null || oVar.getAdvertAppInfo() == null) {
            return;
        }
        oVar.getAdvertAppInfo().p4 = new c.a.q0.r.r.e();
        if (this.f23943c.y() != null) {
            oVar.getAdvertAppInfo().p4.f13236b = this.f23943c.y().a();
        }
        oVar.getAdvertAppInfo().p4.a = oVar.L0();
        if (this.f23943c.l() != null && (l = this.f23943c.l()) != null) {
            oVar.getAdvertAppInfo().p4.f13238d = l.getId();
            oVar.getAdvertAppInfo().p4.f13239e = l.getFirst_class();
            oVar.getAdvertAppInfo().p4.f13240f = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            oVar.getAdvertAppInfo().p4.f13241g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        oVar.getAdvertAppInfo().p4.f13242h = oVar.getAdvertAppInfo().n4;
        oVar.getAdvertAppInfo().p4.f13243i = false;
    }

    public final boolean c(ArrayList<PostData> arrayList, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, arrayList, i2)) == null) {
            for (int max = Math.max(i2 - 4, 0); max < arrayList.size() && max < i2 + 4; max++) {
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
            m mVar = new m(this.a.getVideoPbFragment(), PostData.A0);
            this.f23945e = mVar;
            mVar.Q0(this.a.getVideoPbFragment());
            this.f23946f = new PbReplyLoadMoreAdapter(this.a.getVideoPbFragment(), PostData.G0);
            this.f23947g = z.q().a(this.a.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.C4);
            this.f23948h = z.q().a(this.a.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.E4);
            this.f23944d.add(this.f23947g);
            this.f23944d.add(this.f23948h);
            this.f23944d.add(this.f23945e);
            this.f23944d.add(this.f23946f);
            this.f23942b.addAdapters(this.f23944d);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (this.f23942b.getAdapter() instanceof BdRecyclerAdapter)) {
            this.f23942b.getAdapter().notifyDataSetChanged();
        }
    }

    public void f(c.a.r0.u2.h.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f23943c = fVar;
        if (fVar != null && fVar.O() != null && fVar.O().J() != null) {
            this.l = fVar.O().J().getUserId();
        }
        if (this.f23950j == null) {
            this.f23950j = new ArrayList<>();
        }
        this.f23950j.clear();
        c.a.r0.u2.h.f fVar2 = this.f23943c;
        if (fVar2 != null && fVar2.F() != null && this.f23943c.F().size() > 0) {
            this.f23950j.addAll(this.f23943c.F());
        }
        this.f23945e.t(fVar);
        this.f23945e.setFromCDN(this.n);
        this.f23945e.q(this.l);
        this.f23945e.c(this.m);
        this.f23945e.e(this.p);
        this.f23945e.m(this.o);
        this.f23945e.p(this.q);
        this.f23945e.d(this.s);
        this.f23945e.P0(this.r);
        this.f23946f.d0(this.p);
        n();
        c.a.d.o.e.a aVar = this.f23948h;
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
        BdTypeRecyclerView bdTypeRecyclerView = this.f23942b;
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
            this.f23949i = z;
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

    public void m(c.a.r0.u2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.r = cVar;
        }
    }

    public final void n() {
        c.a.r0.u2.h.f fVar;
        o oVar;
        o oVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (fVar = this.f23943c) == null || fVar.a0 || fVar.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = fVar.F();
        ArrayList<o> e2 = this.f23943c.e();
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
                next2.Q0 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<o> it3 = e2.iterator();
        while (it3.hasNext()) {
            o next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int Z4 = next3.getAdvertAppInfo().Z4();
                if (Z4 != 0) {
                    c.a.r0.j3.m0.d.k(next3, Z4);
                    if (Z4 != 28 && Z4 != 31) {
                        next3.getAdvertAppInfo().i4 = -1001;
                        String str = "updateAppData，Data InValidate: " + Z4;
                    }
                }
                sparseArray.put(next3.getPosition(), next3);
            }
        }
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            o oVar3 = (o) sparseArray.get(sparseArray.keyAt(i2));
            if (oVar3 != null && (oVar2 = (o) hashMap.put(oVar3.J0(), oVar3)) != null) {
                c.a.r0.j3.m0.d.k(oVar2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (oVar = (o) entry.getValue()) != null) {
                sparseArray.put(oVar.getPosition(), oVar);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            arrayList.add(Integer.valueOf(sparseArray.keyAt(i3)));
        }
        Collections.sort(arrayList);
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            o oVar4 = (o) sparseArray.get(((Integer) arrayList.get(i4)).intValue());
            if (this.f23943c.l() != null) {
                oVar4.K0 = this.f23943c.l().getId();
            }
            if (this.f23943c.O() != null) {
                oVar4.N0 = c.a.d.f.m.b.g(this.f23943c.O().h0(), 0L);
            }
            c.a.r0.u2.h.f fVar2 = this.f23943c;
            if (fVar2 != null && fVar2.y() != null) {
                oVar4.O0 = this.f23943c.y().a();
            }
            b(oVar4);
            int position = oVar4.getPosition() + this.f23943c.Z;
            if (position >= F.size()) {
                oVar4.Q0 = position;
                c.a.r0.j3.m0.d.l(oVar4, 2, position + i4, c.a.r0.z1.o.k.a.k(arrayList));
                return;
            }
            if (!this.f23949i) {
                position--;
                oVar4.Q0 = position;
            }
            if (position < 0) {
                c.a.r0.j3.m0.d.k(oVar4, 23);
            } else if (c(F, position)) {
                c.a.r0.j3.m0.d.k(oVar4, 1);
            } else {
                F.add(position, oVar4);
                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", oVar4.getAdvertAppInfo().y4);
            }
        }
    }
}
