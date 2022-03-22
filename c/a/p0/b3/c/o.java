package c.a.p0.b3.c;

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
/* loaded from: classes2.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f a;

    /* renamed from: b  reason: collision with root package name */
    public l f12624b;

    /* renamed from: c  reason: collision with root package name */
    public g f12625c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.y2.h.a f12626d;

    /* renamed from: e  reason: collision with root package name */
    public List<c.a.d.o.e.a> f12627e;

    public o(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, hTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12627e = new ArrayList();
        this.a = new f(tbPageContext, c.a.p0.b3.e.o.f12741c);
        this.f12624b = new l(tbPageContext);
        this.f12625c = new g(tbPageContext, c.a.p0.b3.e.h.f12725c);
        this.f12626d = new c.a.p0.y2.h.a(tbPageContext.getPageActivity(), c.a.p0.y2.d.f20780d);
        this.f12627e.add(this.a);
        this.f12627e.add(this.f12624b);
        this.f12627e.add(this.f12625c);
        this.f12627e.add(this.f12626d);
        hTypeListView.a(this.f12627e);
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
            this.f12625c.b0(onClickListener);
        }
    }
}
