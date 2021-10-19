package c.a.r0.k2.k.g;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.e.l.e.n;
import c.a.e.l.e.w;
import c.a.q0.s.q.d2;
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
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.r0.k2.k.g.f.b f20635a;

    /* renamed from: b  reason: collision with root package name */
    public SubPbReplyAdapter f20636b;

    /* renamed from: c  reason: collision with root package name */
    public NewSubPbActivity f20637c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeListView f20638d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.e.l.e.a> f20639e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f20640f;

    /* renamed from: g  reason: collision with root package name */
    public w f20641g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f20642h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20643i;

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
        this.f20639e = new ArrayList();
        this.f20640f = null;
        this.f20642h = false;
        this.f20643i = true;
        this.f20637c = newSubPbActivity;
        this.f20638d = bdTypeListView;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20642h : invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.r0.k2.k.g.f.b bVar = new c.a.r0.k2.k.g.f.b(this.f20637c, PostData.v0);
            this.f20635a = bVar;
            bVar.e(this.f20640f);
            this.f20635a.d0(this.f20641g);
            this.f20635a.setFromCDN(this.f20643i);
            this.f20639e.add(this.f20635a);
            SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.f20637c, c.a.r0.k2.k.g.g.b.f20663f);
            this.f20636b = subPbReplyAdapter;
            this.f20639e.add(subPbReplyAdapter);
            this.f20639e.add(new c.a.r0.k2.k.g.f.c(this.f20637c, c.a.r0.k2.k.g.g.a.f20662e));
            this.f20638d.addAdapters(this.f20639e);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f20638d.getAdapter2() == null) {
            return;
        }
        this.f20638d.getAdapter2().notifyDataSetChanged();
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f20640f = onClickListener;
        }
    }

    public void e(d2 d2Var, List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, d2Var, list) == null) {
            this.f20635a.u0(d2Var);
            if (!k.isEmpty(this.f20637c.getSubPbModel().p0())) {
                this.f20635a.t0(this.f20637c.getSubPbModel().p0());
            }
            NewSubPbActivity newSubPbActivity = this.f20637c;
            if (newSubPbActivity != null && newSubPbActivity.getSubPbModel() != null) {
                this.f20635a.s0(this.f20637c.getSubPbModel().J0());
            }
            this.f20638d.setData(list);
            this.f20638d.getAdapter2().notifyDataSetChanged();
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f20643i = z;
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f20642h = z;
        }
    }

    public void h(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onLongClickListener) == null) {
            this.f20635a.d(onLongClickListener);
        }
    }

    public void i(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zVar) == null) {
            this.f20635a.p(zVar);
        }
    }
}
