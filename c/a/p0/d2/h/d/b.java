package c.a.p0.d2.h.d;

import android.widget.ListAdapter;
import c.a.p0.d2.h.f.e;
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
    public SingleThreadEmotionHorizontalAdater f16554a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f16555b;

    /* renamed from: c  reason: collision with root package name */
    public e f16556c;

    /* renamed from: d  reason: collision with root package name */
    public List<EmotionPackageData> f16557d;

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
        this.f16555b = bdListView;
        e eVar = new e(tbPageContext);
        this.f16556c = eVar;
        eVar.c(TbadkCoreApplication.getInst().getSkinType());
        this.f16555b.addHeaderView(this.f16556c.b());
        this.f16557d = new ArrayList();
        SingleThreadEmotionHorizontalAdater singleThreadEmotionHorizontalAdater = new SingleThreadEmotionHorizontalAdater(this.f16557d, tbPageContext);
        this.f16554a = singleThreadEmotionHorizontalAdater;
        this.f16555b.setAdapter((ListAdapter) singleThreadEmotionHorizontalAdater);
    }

    public void a(List<EmotionPackageData> list) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null || (eVar = this.f16556c) == null || this.f16554a == null) {
            return;
        }
        eVar.d(Integer.valueOf(list.size()));
        this.f16557d.clear();
        if (list != null) {
            this.f16557d.addAll(list);
        }
        this.f16554a.notifyDataSetChanged();
    }
}
