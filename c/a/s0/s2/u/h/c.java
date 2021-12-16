package c.a.s0.s2.u.h;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.m.e.n;
import c.a.d.m.e.w;
import c.a.r0.s.r.d2;
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
    public c.a.s0.s2.u.h.f.b a;

    /* renamed from: b  reason: collision with root package name */
    public SubPbReplyAdapter f23309b;

    /* renamed from: c  reason: collision with root package name */
    public NewSubPbActivity f23310c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeListView f23311d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.d.m.e.a> f23312e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f23313f;

    /* renamed from: g  reason: collision with root package name */
    public w f23314g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f23315h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f23316i;

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
        this.f23312e = new ArrayList();
        this.f23313f = null;
        this.f23315h = false;
        this.f23316i = true;
        this.f23310c = newSubPbActivity;
        this.f23311d = bdTypeListView;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f23315h : invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.s0.s2.u.h.f.b bVar = new c.a.s0.s2.u.h.f.b(this.f23310c, PostData.z0);
            this.a = bVar;
            bVar.e(this.f23313f);
            this.a.c0(this.f23314g);
            this.a.setFromCDN(this.f23316i);
            this.f23312e.add(this.a);
            SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.f23310c, c.a.s0.s2.u.h.g.b.f23333f);
            this.f23309b = subPbReplyAdapter;
            this.f23312e.add(subPbReplyAdapter);
            this.f23312e.add(new c.a.s0.s2.u.h.f.c(this.f23310c, c.a.s0.s2.u.h.g.a.f23332e));
            this.f23311d.addAdapters(this.f23312e);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f23311d.getAdapter2() == null) {
            return;
        }
        this.f23311d.getAdapter2().notifyDataSetChanged();
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f23313f = onClickListener;
        }
    }

    public void e(d2 d2Var, List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, d2Var, list) == null) {
            this.a.t0(d2Var);
            if (!l.isEmpty(this.f23310c.getSubPbModel().p0())) {
                this.a.s0(this.f23310c.getSubPbModel().p0());
            }
            NewSubPbActivity newSubPbActivity = this.f23310c;
            if (newSubPbActivity != null && newSubPbActivity.getSubPbModel() != null) {
                this.a.r0(this.f23310c.getSubPbModel().K0());
            }
            this.f23311d.setData(list);
            this.f23311d.getAdapter2().notifyDataSetChanged();
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f23316i = z;
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f23315h = z;
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
