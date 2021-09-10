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
    public c.a.r0.j2.k.g.f.b f20443a;

    /* renamed from: b  reason: collision with root package name */
    public SubPbReplyAdapter f20444b;

    /* renamed from: c  reason: collision with root package name */
    public NewSubPbActivity f20445c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeListView f20446d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.e.l.e.a> f20447e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f20448f;

    /* renamed from: g  reason: collision with root package name */
    public w f20449g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f20450h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20451i;

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
        this.f20447e = new ArrayList();
        this.f20448f = null;
        this.f20450h = false;
        this.f20451i = true;
        this.f20445c = newSubPbActivity;
        this.f20446d = bdTypeListView;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20450h : invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.r0.j2.k.g.f.b bVar = new c.a.r0.j2.k.g.f.b(this.f20445c, PostData.v0);
            this.f20443a = bVar;
            bVar.e(this.f20448f);
            this.f20443a.d0(this.f20449g);
            this.f20443a.setFromCDN(this.f20451i);
            this.f20447e.add(this.f20443a);
            SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.f20445c, c.a.r0.j2.k.g.g.b.f20471f);
            this.f20444b = subPbReplyAdapter;
            this.f20447e.add(subPbReplyAdapter);
            this.f20447e.add(new c.a.r0.j2.k.g.f.c(this.f20445c, c.a.r0.j2.k.g.g.a.f20470e));
            this.f20446d.addAdapters(this.f20447e);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f20446d.getAdapter2() == null) {
            return;
        }
        this.f20446d.getAdapter2().notifyDataSetChanged();
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f20448f = onClickListener;
        }
    }

    public void e(d2 d2Var, List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, d2Var, list) == null) {
            this.f20443a.u0(d2Var);
            if (!k.isEmpty(this.f20445c.getSubPbModel().o0())) {
                this.f20443a.t0(this.f20445c.getSubPbModel().o0());
            }
            NewSubPbActivity newSubPbActivity = this.f20445c;
            if (newSubPbActivity != null && newSubPbActivity.getSubPbModel() != null) {
                this.f20443a.s0(this.f20445c.getSubPbModel().I0());
            }
            this.f20446d.setData(list);
            this.f20446d.getAdapter2().notifyDataSetChanged();
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f20451i = z;
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f20450h = z;
        }
    }

    public void h(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onLongClickListener) == null) {
            this.f20443a.d(onLongClickListener);
        }
    }

    public void i(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zVar) == null) {
            this.f20443a.p(zVar);
        }
    }
}
