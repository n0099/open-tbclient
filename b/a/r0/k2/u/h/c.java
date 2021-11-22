package b.a.r0.k2.u.h;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.k;
import b.a.e.m.e.n;
import b.a.e.m.e.w;
import b.a.q0.s.q.d2;
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
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.r0.k2.u.h.f.b f21156a;

    /* renamed from: b  reason: collision with root package name */
    public SubPbReplyAdapter f21157b;

    /* renamed from: c  reason: collision with root package name */
    public NewSubPbActivity f21158c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeListView f21159d;

    /* renamed from: e  reason: collision with root package name */
    public List<b.a.e.m.e.a> f21160e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f21161f;

    /* renamed from: g  reason: collision with root package name */
    public w f21162g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21163h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f21164i;

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
        this.f21160e = new ArrayList();
        this.f21161f = null;
        this.f21163h = false;
        this.f21164i = true;
        this.f21158c = newSubPbActivity;
        this.f21159d = bdTypeListView;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21163h : invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.a.r0.k2.u.h.f.b bVar = new b.a.r0.k2.u.h.f.b(this.f21158c, PostData.y0);
            this.f21156a = bVar;
            bVar.e(this.f21161f);
            this.f21156a.c0(this.f21162g);
            this.f21156a.setFromCDN(this.f21164i);
            this.f21160e.add(this.f21156a);
            SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.f21158c, b.a.r0.k2.u.h.g.b.f21184f);
            this.f21157b = subPbReplyAdapter;
            this.f21160e.add(subPbReplyAdapter);
            this.f21160e.add(new b.a.r0.k2.u.h.f.c(this.f21158c, b.a.r0.k2.u.h.g.a.f21183e));
            this.f21159d.addAdapters(this.f21160e);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f21159d.getAdapter2() == null) {
            return;
        }
        this.f21159d.getAdapter2().notifyDataSetChanged();
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f21161f = onClickListener;
        }
    }

    public void e(d2 d2Var, List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, d2Var, list) == null) {
            this.f21156a.t0(d2Var);
            if (!k.isEmpty(this.f21158c.getSubPbModel().p0())) {
                this.f21156a.s0(this.f21158c.getSubPbModel().p0());
            }
            NewSubPbActivity newSubPbActivity = this.f21158c;
            if (newSubPbActivity != null && newSubPbActivity.getSubPbModel() != null) {
                this.f21156a.r0(this.f21158c.getSubPbModel().K0());
            }
            this.f21159d.setData(list);
            this.f21159d.getAdapter2().notifyDataSetChanged();
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f21164i = z;
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f21163h = z;
        }
    }

    public void h(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onLongClickListener) == null) {
            this.f21156a.d(onLongClickListener);
        }
    }

    public void i(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zVar) == null) {
            this.f21156a.p(zVar);
        }
    }
}
