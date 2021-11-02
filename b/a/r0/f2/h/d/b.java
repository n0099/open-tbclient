package b.a.r0.f2.h.d;

import android.widget.ListAdapter;
import b.a.r0.f2.h.f.e;
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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SingleThreadEmotionHorizontalAdater f16541a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f16542b;

    /* renamed from: c  reason: collision with root package name */
    public e f16543c;

    /* renamed from: d  reason: collision with root package name */
    public List<EmotionPackageData> f16544d;

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
        this.f16542b = bdListView;
        e eVar = new e(tbPageContext);
        this.f16543c = eVar;
        eVar.c(TbadkCoreApplication.getInst().getSkinType());
        this.f16542b.addHeaderView(this.f16543c.b());
        this.f16544d = new ArrayList();
        SingleThreadEmotionHorizontalAdater singleThreadEmotionHorizontalAdater = new SingleThreadEmotionHorizontalAdater(this.f16544d, tbPageContext);
        this.f16541a = singleThreadEmotionHorizontalAdater;
        this.f16542b.setAdapter((ListAdapter) singleThreadEmotionHorizontalAdater);
    }

    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public void update(List<EmotionPackageData> list) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || list == null || (eVar = this.f16543c) == null || this.f16541a == null) {
            return;
        }
        eVar.update(Integer.valueOf(list.size()));
        this.f16544d.clear();
        if (list != null) {
            this.f16544d.addAll(list);
        }
        this.f16541a.notifyDataSetChanged();
    }
}
