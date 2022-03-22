package c.a.p0.r2.h.d;

import android.widget.ListAdapter;
import c.a.p0.r2.h.f.e;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SingleThreadEmotionHorizontalAdater a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f18072b;

    /* renamed from: c  reason: collision with root package name */
    public e f18073c;

    /* renamed from: d  reason: collision with root package name */
    public List<EmotionPackageData> f18074d;

    public b(TbPageContext<?> tbPageContext, BdListView bdListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18072b = bdListView;
        e eVar = new e(tbPageContext);
        this.f18073c = eVar;
        eVar.c(TbadkCoreApplication.getInst().getSkinType());
        this.f18072b.addHeaderView(this.f18073c.b());
        this.f18074d = new ArrayList();
        SingleThreadEmotionHorizontalAdater singleThreadEmotionHorizontalAdater = new SingleThreadEmotionHorizontalAdater(this.f18074d, tbPageContext);
        this.a = singleThreadEmotionHorizontalAdater;
        this.f18072b.setAdapter((ListAdapter) singleThreadEmotionHorizontalAdater);
    }

    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public void update(List<EmotionPackageData> list) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || list == null || (eVar = this.f18073c) == null || this.a == null) {
            return;
        }
        eVar.update(Integer.valueOf(list.size()));
        this.f18074d.clear();
        if (list != null) {
            this.f18074d.addAll(list);
        }
        this.a.notifyDataSetChanged();
    }
}
