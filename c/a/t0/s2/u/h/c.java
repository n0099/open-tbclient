package c.a.t0.s2.u.h;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.n.e.n;
import c.a.d.n.e.w;
import c.a.s0.s.q.d2;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.adapter.SubPbReplyAdapter;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.t0.s2.u.h.f.b a;

    /* renamed from: b  reason: collision with root package name */
    public SubPbReplyAdapter f23822b;

    /* renamed from: c  reason: collision with root package name */
    public NewSubPbActivity f23823c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeListView f23824d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.d.n.e.a> f23825e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f23826f;

    /* renamed from: g  reason: collision with root package name */
    public w f23827g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f23828h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f23829i;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newSubPbActivity, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23825e = new ArrayList();
        this.f23826f = null;
        this.f23828h = false;
        this.f23829i = true;
        this.f23823c = newSubPbActivity;
        this.f23824d = bdTypeListView;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f23828h : invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.t0.s2.u.h.f.b bVar = new c.a.t0.s2.u.h.f.b(this.f23823c, PostData.A0);
            this.a = bVar;
            bVar.e(this.f23826f);
            this.a.V(this.f23827g);
            this.a.setFromCDN(this.f23829i);
            this.f23825e.add(this.a);
            SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.f23823c, c.a.t0.s2.u.h.g.b.f23846f);
            this.f23822b = subPbReplyAdapter;
            this.f23825e.add(subPbReplyAdapter);
            this.f23825e.add(new c.a.t0.s2.u.h.f.c(this.f23823c, c.a.t0.s2.u.h.g.a.f23845e));
            this.f23824d.addAdapters(this.f23825e);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f23824d.getAdapter2() == null) {
            return;
        }
        this.f23824d.getAdapter2().notifyDataSetChanged();
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f23826f = onClickListener;
        }
    }

    public void e(d2 d2Var, List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, d2Var, list) == null) {
            this.a.m0(d2Var);
            if (!m.isEmpty(this.f23823c.getSubPbModel().p0())) {
                this.a.l0(this.f23823c.getSubPbModel().p0());
            }
            NewSubPbActivity newSubPbActivity = this.f23823c;
            if (newSubPbActivity != null && newSubPbActivity.getSubPbModel() != null) {
                this.a.k0(this.f23823c.getSubPbModel().K0());
            }
            this.f23824d.setData(list);
            this.f23824d.getAdapter2().notifyDataSetChanged();
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f23829i = z;
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f23828h = z;
        }
    }

    public void h(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onLongClickListener) == null) {
            this.a.d(onLongClickListener);
        }
    }

    public void i(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yVar) == null) {
            this.a.p(yVar);
        }
    }
}
