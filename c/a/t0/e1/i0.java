package c.a.t0.e1;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.view.FrsTopItemInfoView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ItemInfo;
/* loaded from: classes7.dex */
public class i0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment a;

    /* renamed from: b  reason: collision with root package name */
    public FrsTopItemInfoView f16472b;

    public i0(BaseFragment baseFragment) {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (baseFragment == null) {
            return;
        }
        this.a = baseFragment;
        this.f16472b = new FrsTopItemInfoView(baseFragment.getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(d1.M_H_X003);
        this.f16472b.setLayoutParams(layoutParams);
        b();
        BaseFragment baseFragment2 = this.a;
        if (!(baseFragment2 instanceof FrsCommonTabFragment) || (frsViewData = ((FrsCommonTabFragment) baseFragment2).viewData) == null || frsViewData.getForum() == null) {
            return;
        }
        ForumData forum = frsViewData.getForum();
        this.f16472b.setForumWriteData(new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), frsViewData.getAnti()));
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16472b : (View) invokeV.objValue;
    }

    public void b() {
        FrsTopItemInfoView frsTopItemInfoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (frsTopItemInfoView = this.f16472b) == null) {
            return;
        }
        frsTopItemInfoView.onChangeSkinType();
    }

    public void c(ItemInfo itemInfo) {
        FrsTopItemInfoView frsTopItemInfoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, itemInfo) == null) || (frsTopItemInfoView = this.f16472b) == null) {
            return;
        }
        frsTopItemInfoView.setData(itemInfo);
    }
}
