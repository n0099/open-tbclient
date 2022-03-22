package c.a.p0.w2.m.h;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.o.e.n;
import c.a.d.o.e.w;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
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
    public c.a.p0.w2.m.h.f.b a;

    /* renamed from: b  reason: collision with root package name */
    public SubPbReplyAdapter f20389b;

    /* renamed from: c  reason: collision with root package name */
    public NewSubPbActivity f20390c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeListView f20391d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.d.o.e.a> f20392e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f20393f;

    /* renamed from: g  reason: collision with root package name */
    public w f20394g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f20395h;
    public boolean i;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newSubPbActivity, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20392e = new ArrayList();
        this.f20393f = null;
        this.f20395h = false;
        this.i = true;
        this.f20390c = newSubPbActivity;
        this.f20391d = bdTypeListView;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20395h : invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.p0.w2.m.h.f.b bVar = new c.a.p0.w2.m.h.f.b(this.f20390c, PostData.w0);
            this.a = bVar;
            bVar.e(this.f20393f);
            this.a.V(this.f20394g);
            this.a.setFromCDN(this.i);
            this.f20392e.add(this.a);
            SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.f20390c, c.a.p0.w2.m.h.g.b.f20404b);
            this.f20389b = subPbReplyAdapter;
            this.f20392e.add(subPbReplyAdapter);
            this.f20392e.add(new c.a.p0.w2.m.h.f.c(this.f20390c, c.a.p0.w2.m.h.g.a.a));
            this.f20391d.a(this.f20392e);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f20391d.getAdapter2() == null) {
            return;
        }
        this.f20391d.getAdapter2().notifyDataSetChanged();
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f20393f = onClickListener;
        }
    }

    public void e(ThreadData threadData, List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, threadData, list) == null) {
            this.a.m0(threadData);
            if (!m.isEmpty(this.f20390c.getSubPbModel().r0())) {
                this.a.l0(this.f20390c.getSubPbModel().r0());
            }
            NewSubPbActivity newSubPbActivity = this.f20390c;
            if (newSubPbActivity != null && newSubPbActivity.getSubPbModel() != null) {
                this.a.k0(this.f20390c.getSubPbModel().M0());
            }
            this.f20391d.setData(list);
            this.f20391d.getAdapter2().notifyDataSetChanged();
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.i = z;
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f20395h = z;
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
