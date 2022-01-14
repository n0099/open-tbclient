package c.a.t0.s2.u.h;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.n.e.n;
import c.a.d.n.e.w;
import c.a.s0.s.q.e2;
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
    public SubPbReplyAdapter f23162b;

    /* renamed from: c  reason: collision with root package name */
    public NewSubPbActivity f23163c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeListView f23164d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.d.n.e.a> f23165e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f23166f;

    /* renamed from: g  reason: collision with root package name */
    public w f23167g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f23168h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f23169i;

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
        this.f23165e = new ArrayList();
        this.f23166f = null;
        this.f23168h = false;
        this.f23169i = true;
        this.f23163c = newSubPbActivity;
        this.f23164d = bdTypeListView;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f23168h : invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.t0.s2.u.h.f.b bVar = new c.a.t0.s2.u.h.f.b(this.f23163c, PostData.A0);
            this.a = bVar;
            bVar.e(this.f23166f);
            this.a.V(this.f23167g);
            this.a.setFromCDN(this.f23169i);
            this.f23165e.add(this.a);
            SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.f23163c, c.a.t0.s2.u.h.g.b.f23186f);
            this.f23162b = subPbReplyAdapter;
            this.f23165e.add(subPbReplyAdapter);
            this.f23165e.add(new c.a.t0.s2.u.h.f.c(this.f23163c, c.a.t0.s2.u.h.g.a.f23185e));
            this.f23164d.addAdapters(this.f23165e);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f23164d.getAdapter2() == null) {
            return;
        }
        this.f23164d.getAdapter2().notifyDataSetChanged();
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f23166f = onClickListener;
        }
    }

    public void e(e2 e2Var, List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, e2Var, list) == null) {
            this.a.m0(e2Var);
            if (!m.isEmpty(this.f23163c.getSubPbModel().p0())) {
                this.a.l0(this.f23163c.getSubPbModel().p0());
            }
            NewSubPbActivity newSubPbActivity = this.f23163c;
            if (newSubPbActivity != null && newSubPbActivity.getSubPbModel() != null) {
                this.a.k0(this.f23163c.getSubPbModel().K0());
            }
            this.f23164d.setData(list);
            this.f23164d.getAdapter2().notifyDataSetChanged();
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f23169i = z;
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f23168h = z;
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
