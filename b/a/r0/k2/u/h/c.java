package b.a.r0.k2.u.h;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.k;
import b.a.e.l.e.n;
import b.a.e.l.e.w;
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
    public b.a.r0.k2.u.h.f.b f19619a;

    /* renamed from: b  reason: collision with root package name */
    public SubPbReplyAdapter f19620b;

    /* renamed from: c  reason: collision with root package name */
    public NewSubPbActivity f19621c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeListView f19622d;

    /* renamed from: e  reason: collision with root package name */
    public List<b.a.e.l.e.a> f19623e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f19624f;

    /* renamed from: g  reason: collision with root package name */
    public w f19625g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f19626h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f19627i;

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
        this.f19623e = new ArrayList();
        this.f19624f = null;
        this.f19626h = false;
        this.f19627i = true;
        this.f19621c = newSubPbActivity;
        this.f19622d = bdTypeListView;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19626h : invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.a.r0.k2.u.h.f.b bVar = new b.a.r0.k2.u.h.f.b(this.f19621c, PostData.y0);
            this.f19619a = bVar;
            bVar.e(this.f19624f);
            this.f19619a.c0(this.f19625g);
            this.f19619a.setFromCDN(this.f19627i);
            this.f19623e.add(this.f19619a);
            SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.f19621c, b.a.r0.k2.u.h.g.b.f19647f);
            this.f19620b = subPbReplyAdapter;
            this.f19623e.add(subPbReplyAdapter);
            this.f19623e.add(new b.a.r0.k2.u.h.f.c(this.f19621c, b.a.r0.k2.u.h.g.a.f19646e));
            this.f19622d.addAdapters(this.f19623e);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f19622d.getAdapter2() == null) {
            return;
        }
        this.f19622d.getAdapter2().notifyDataSetChanged();
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f19624f = onClickListener;
        }
    }

    public void e(d2 d2Var, List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, d2Var, list) == null) {
            this.f19619a.t0(d2Var);
            if (!k.isEmpty(this.f19621c.getSubPbModel().p0())) {
                this.f19619a.s0(this.f19621c.getSubPbModel().p0());
            }
            NewSubPbActivity newSubPbActivity = this.f19621c;
            if (newSubPbActivity != null && newSubPbActivity.getSubPbModel() != null) {
                this.f19619a.r0(this.f19621c.getSubPbModel().K0());
            }
            this.f19622d.setData(list);
            this.f19622d.getAdapter2().notifyDataSetChanged();
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f19627i = z;
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f19626h = z;
        }
    }

    public void h(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onLongClickListener) == null) {
            this.f19619a.d(onLongClickListener);
        }
    }

    public void i(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zVar) == null) {
            this.f19619a.p(zVar);
        }
    }
}
