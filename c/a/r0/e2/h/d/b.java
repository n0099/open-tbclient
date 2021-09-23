package c.a.r0.e2.h.d;

import android.widget.ListAdapter;
import c.a.r0.e2.h.f.e;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.newfaceshop.nativemotionmanager.managers.SingleThreadEmotionHorizontalAdater;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SingleThreadEmotionHorizontalAdater f17406a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f17407b;

    /* renamed from: c  reason: collision with root package name */
    public e f17408c;

    /* renamed from: d  reason: collision with root package name */
    public List<EmotionPackageData> f17409d;

    public b(TbPageContext<?> tbPageContext, BdListView bdListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17407b = bdListView;
        e eVar = new e(tbPageContext);
        this.f17408c = eVar;
        eVar.c(TbadkCoreApplication.getInst().getSkinType());
        this.f17407b.addHeaderView(this.f17408c.b());
        this.f17409d = new ArrayList();
        SingleThreadEmotionHorizontalAdater singleThreadEmotionHorizontalAdater = new SingleThreadEmotionHorizontalAdater(this.f17409d, tbPageContext);
        this.f17406a = singleThreadEmotionHorizontalAdater;
        this.f17407b.setAdapter((ListAdapter) singleThreadEmotionHorizontalAdater);
    }

    public void a(List<EmotionPackageData> list) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null || (eVar = this.f17408c) == null || this.f17406a == null) {
            return;
        }
        eVar.d(Integer.valueOf(list.size()));
        this.f17409d.clear();
        if (list != null) {
            this.f17409d.addAll(list);
        }
        this.f17406a.notifyDataSetChanged();
    }
}
