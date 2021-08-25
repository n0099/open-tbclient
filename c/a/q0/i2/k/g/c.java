package c.a.q0.i2.k.g;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.e.l.e.n;
import c.a.e.l.e.w;
import c.a.p0.s.q.c2;
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
    public c.a.q0.i2.k.g.f.b f19879a;

    /* renamed from: b  reason: collision with root package name */
    public SubPbReplyAdapter f19880b;

    /* renamed from: c  reason: collision with root package name */
    public NewSubPbActivity f19881c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeListView f19882d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.e.l.e.a> f19883e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f19884f;

    /* renamed from: g  reason: collision with root package name */
    public w f19885g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f19886h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f19887i;

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
        this.f19883e = new ArrayList();
        this.f19884f = null;
        this.f19886h = false;
        this.f19887i = true;
        this.f19881c = newSubPbActivity;
        this.f19882d = bdTypeListView;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19886h : invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.q0.i2.k.g.f.b bVar = new c.a.q0.i2.k.g.f.b(this.f19881c, PostData.v0);
            this.f19879a = bVar;
            bVar.e(this.f19884f);
            this.f19879a.d0(this.f19885g);
            this.f19879a.setFromCDN(this.f19887i);
            this.f19883e.add(this.f19879a);
            SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.f19881c, c.a.q0.i2.k.g.g.b.f19907f);
            this.f19880b = subPbReplyAdapter;
            this.f19883e.add(subPbReplyAdapter);
            this.f19883e.add(new c.a.q0.i2.k.g.f.c(this.f19881c, c.a.q0.i2.k.g.g.a.f19906e));
            this.f19882d.addAdapters(this.f19883e);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f19882d.getAdapter2() == null) {
            return;
        }
        this.f19882d.getAdapter2().notifyDataSetChanged();
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f19884f = onClickListener;
        }
    }

    public void e(c2 c2Var, List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, c2Var, list) == null) {
            this.f19879a.u0(c2Var);
            if (!k.isEmpty(this.f19881c.getSubPbModel().o0())) {
                this.f19879a.t0(this.f19881c.getSubPbModel().o0());
            }
            NewSubPbActivity newSubPbActivity = this.f19881c;
            if (newSubPbActivity != null && newSubPbActivity.getSubPbModel() != null) {
                this.f19879a.s0(this.f19881c.getSubPbModel().I0());
            }
            this.f19882d.setData(list);
            this.f19882d.getAdapter2().notifyDataSetChanged();
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f19887i = z;
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f19886h = z;
        }
    }

    public void h(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onLongClickListener) == null) {
            this.f19879a.d(onLongClickListener);
        }
    }

    public void i(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zVar) == null) {
            this.f19879a.p(zVar);
        }
    }
}
