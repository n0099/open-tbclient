package c.a.p0.e1.b;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.e1.a.c a;

    public a(TbPageContext tbPageContext, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (bdTypeListView == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new c.a.p0.e1.a.a(tbPageContext, c.a.p0.e1.c.a.f13782d, tbPageContext.getUniqueId()));
        c.a.p0.e1.a.c cVar = new c.a.p0.e1.a.c(tbPageContext, c.a.p0.e1.c.b.f13785h, tbPageContext.getUniqueId());
        this.a = cVar;
        arrayList.add(cVar);
        arrayList.add(new c.a.p0.e1.a.b(tbPageContext, c.a.p0.e1.c.a.f13781c, tbPageContext.getUniqueId()));
        arrayList.add(new c.a.p0.e1.a.d(tbPageContext, c.a.p0.e1.c.a.f13783e, tbPageContext.getUniqueId()));
        bdTypeListView.a(arrayList);
    }

    public void a(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.a.b0(onClickListener);
        }
    }
}
