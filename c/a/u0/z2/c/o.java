package c.a.u0.z2.c;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f a;

    /* renamed from: b  reason: collision with root package name */
    public l f25882b;

    /* renamed from: c  reason: collision with root package name */
    public g f25883c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.u0.w2.g.a f25884d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.d.o.e.a> f25885e;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, hTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25885e = new ArrayList();
        this.a = new f(tbPageContext, c.a.u0.z2.e.o.f26021g);
        this.f25882b = new l(tbPageContext);
        this.f25883c = new g(tbPageContext, c.a.u0.z2.e.h.f25999g);
        this.f25884d = new c.a.u0.w2.g.a(tbPageContext.getPageActivity(), c.a.u0.w2.d.f24966h);
        this.f25885e.add(this.a);
        this.f25885e.add(this.f25882b);
        this.f25885e.add(this.f25883c);
        this.f25885e.add(this.f25884d);
        hTypeListView.addAdapters(this.f25885e);
    }

    public void a(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.a.b0(onClickListener);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.f25883c.b0(onClickListener);
        }
    }
}
