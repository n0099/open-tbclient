package c.a.r0.w0.b;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.r0.w0.a.c f26462a;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (bdTypeListView == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new c.a.r0.w0.a.a(tbPageContext, c.a.r0.w0.c.a.f26492h, tbPageContext.getUniqueId()));
        c.a.r0.w0.a.c cVar = new c.a.r0.w0.a.c(tbPageContext, c.a.r0.w0.c.b.l, tbPageContext.getUniqueId());
        this.f26462a = cVar;
        arrayList.add(cVar);
        arrayList.add(new c.a.r0.w0.a.b(tbPageContext, c.a.r0.w0.c.a.f26491g, tbPageContext.getUniqueId()));
        arrayList.add(new c.a.r0.w0.a.d(tbPageContext, c.a.r0.w0.c.a.f26493i, tbPageContext.getUniqueId()));
        bdTypeListView.addAdapters(arrayList);
    }

    public void a(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.f26462a.j0(onClickListener);
        }
    }
}
