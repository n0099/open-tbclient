package c.a.p0.i2.k.g;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.e.k.e.n;
import c.a.e.k.e.w;
import c.a.o0.s.q.c2;
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
    public c.a.p0.i2.k.g.e.b f19555a;

    /* renamed from: b  reason: collision with root package name */
    public SubPbReplyAdapter f19556b;

    /* renamed from: c  reason: collision with root package name */
    public NewSubPbActivity f19557c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeListView f19558d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.e.k.e.a> f19559e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f19560f;

    /* renamed from: g  reason: collision with root package name */
    public w f19561g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f19562h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f19563i;

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
        this.f19559e = new ArrayList();
        this.f19560f = null;
        this.f19562h = false;
        this.f19563i = true;
        this.f19557c = newSubPbActivity;
        this.f19558d = bdTypeListView;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19562h : invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.p0.i2.k.g.e.b bVar = new c.a.p0.i2.k.g.e.b(this.f19557c, PostData.v0);
            this.f19555a = bVar;
            bVar.e(this.f19560f);
            this.f19555a.d0(this.f19561g);
            this.f19555a.setFromCDN(this.f19563i);
            this.f19559e.add(this.f19555a);
            SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.f19557c, c.a.p0.i2.k.g.f.b.f19583f);
            this.f19556b = subPbReplyAdapter;
            this.f19559e.add(subPbReplyAdapter);
            this.f19559e.add(new c.a.p0.i2.k.g.e.c(this.f19557c, c.a.p0.i2.k.g.f.a.f19582e));
            this.f19558d.addAdapters(this.f19559e);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f19558d.getAdapter2() == null) {
            return;
        }
        this.f19558d.getAdapter2().notifyDataSetChanged();
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f19560f = onClickListener;
        }
    }

    public void e(c2 c2Var, List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, c2Var, list) == null) {
            this.f19555a.u0(c2Var);
            if (!k.isEmpty(this.f19557c.getSubPbModel().o0())) {
                this.f19555a.t0(this.f19557c.getSubPbModel().o0());
            }
            NewSubPbActivity newSubPbActivity = this.f19557c;
            if (newSubPbActivity != null && newSubPbActivity.getSubPbModel() != null) {
                this.f19555a.s0(this.f19557c.getSubPbModel().H0());
            }
            this.f19558d.setData(list);
            this.f19558d.getAdapter2().notifyDataSetChanged();
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f19563i = z;
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f19562h = z;
        }
    }

    public void h(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onLongClickListener) == null) {
            this.f19555a.d(onLongClickListener);
        }
    }

    public void i(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zVar) == null) {
            this.f19555a.p(zVar);
        }
    }
}
