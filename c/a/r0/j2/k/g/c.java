package c.a.r0.j2.k.g;

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
    public c.a.r0.j2.k.g.f.b f20458a;

    /* renamed from: b  reason: collision with root package name */
    public SubPbReplyAdapter f20459b;

    /* renamed from: c  reason: collision with root package name */
    public NewSubPbActivity f20460c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeListView f20461d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.e.l.e.a> f20462e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f20463f;

    /* renamed from: g  reason: collision with root package name */
    public w f20464g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f20465h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20466i;

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
        this.f20462e = new ArrayList();
        this.f20463f = null;
        this.f20465h = false;
        this.f20466i = true;
        this.f20460c = newSubPbActivity;
        this.f20461d = bdTypeListView;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20465h : invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.r0.j2.k.g.f.b bVar = new c.a.r0.j2.k.g.f.b(this.f20460c, PostData.v0);
            this.f20458a = bVar;
            bVar.e(this.f20463f);
            this.f20458a.d0(this.f20464g);
            this.f20458a.setFromCDN(this.f20466i);
            this.f20462e.add(this.f20458a);
            SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.f20460c, c.a.r0.j2.k.g.g.b.f20486f);
            this.f20459b = subPbReplyAdapter;
            this.f20462e.add(subPbReplyAdapter);
            this.f20462e.add(new c.a.r0.j2.k.g.f.c(this.f20460c, c.a.r0.j2.k.g.g.a.f20485e));
            this.f20461d.addAdapters(this.f20462e);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f20461d.getAdapter2() == null) {
            return;
        }
        this.f20461d.getAdapter2().notifyDataSetChanged();
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f20463f = onClickListener;
        }
    }

    public void e(d2 d2Var, List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, d2Var, list) == null) {
            this.f20458a.u0(d2Var);
            if (!k.isEmpty(this.f20460c.getSubPbModel().p0())) {
                this.f20458a.t0(this.f20460c.getSubPbModel().p0());
            }
            NewSubPbActivity newSubPbActivity = this.f20460c;
            if (newSubPbActivity != null && newSubPbActivity.getSubPbModel() != null) {
                this.f20458a.s0(this.f20460c.getSubPbModel().J0());
            }
            this.f20461d.setData(list);
            this.f20461d.getAdapter2().notifyDataSetChanged();
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f20466i = z;
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f20465h = z;
        }
    }

    public void h(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onLongClickListener) == null) {
            this.f20458a.d(onLongClickListener);
        }
    }

    public void i(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zVar) == null) {
            this.f20458a.p(zVar);
        }
    }
}
