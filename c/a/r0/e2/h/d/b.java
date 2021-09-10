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
    public SingleThreadEmotionHorizontalAdater f17396a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f17397b;

    /* renamed from: c  reason: collision with root package name */
    public e f17398c;

    /* renamed from: d  reason: collision with root package name */
    public List<EmotionPackageData> f17399d;

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
        this.f17397b = bdListView;
        e eVar = new e(tbPageContext);
        this.f17398c = eVar;
        eVar.c(TbadkCoreApplication.getInst().getSkinType());
        this.f17397b.addHeaderView(this.f17398c.b());
        this.f17399d = new ArrayList();
        SingleThreadEmotionHorizontalAdater singleThreadEmotionHorizontalAdater = new SingleThreadEmotionHorizontalAdater(this.f17399d, tbPageContext);
        this.f17396a = singleThreadEmotionHorizontalAdater;
        this.f17397b.setAdapter((ListAdapter) singleThreadEmotionHorizontalAdater);
    }

    public void a(List<EmotionPackageData> list) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null || (eVar = this.f17398c) == null || this.f17396a == null) {
            return;
        }
        eVar.d(Integer.valueOf(list.size()));
        this.f17399d.clear();
        if (list != null) {
            this.f17399d.addAll(list);
        }
        this.f17396a.notifyDataSetChanged();
    }
}
