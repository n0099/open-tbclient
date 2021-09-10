package c.a.r0.v0.b;

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
    public c.a.r0.v0.a.c f26264a;

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
        arrayList.add(new c.a.r0.v0.a.a(tbPageContext, c.a.r0.v0.c.a.f26294h, tbPageContext.getUniqueId()));
        c.a.r0.v0.a.c cVar = new c.a.r0.v0.a.c(tbPageContext, c.a.r0.v0.c.b.l, tbPageContext.getUniqueId());
        this.f26264a = cVar;
        arrayList.add(cVar);
        arrayList.add(new c.a.r0.v0.a.b(tbPageContext, c.a.r0.v0.c.a.f26293g, tbPageContext.getUniqueId()));
        arrayList.add(new c.a.r0.v0.a.d(tbPageContext, c.a.r0.v0.c.a.f26295i, tbPageContext.getUniqueId()));
        bdTypeListView.addAdapters(arrayList);
    }

    public void a(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.f26264a.j0(onClickListener);
        }
    }
}
