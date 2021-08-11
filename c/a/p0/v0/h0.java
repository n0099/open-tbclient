package c.a.p0.v0;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
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
/* loaded from: classes4.dex */
public class h0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragment f25803a;

    /* renamed from: b  reason: collision with root package name */
    public FrsTopItemInfoView f25804b;

    public h0(BaseFragment baseFragment) {
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
        this.f25803a = baseFragment;
        this.f25804b = new FrsTopItemInfoView(baseFragment.getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        this.f25804b.setLayoutParams(layoutParams);
        b();
        BaseFragment baseFragment2 = this.f25803a;
        if (!(baseFragment2 instanceof FrsCommonTabFragment) || (frsViewData = ((FrsCommonTabFragment) baseFragment2).viewData) == null || frsViewData.getForum() == null) {
            return;
        }
        ForumData forum = frsViewData.getForum();
        this.f25804b.setForumWriteData(new ForumWriteData(forum.getId(), forum.getName(), forum.getPrefixData(), frsViewData.getAnti()));
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25804b : (View) invokeV.objValue;
    }

    public void b() {
        FrsTopItemInfoView frsTopItemInfoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (frsTopItemInfoView = this.f25804b) == null) {
            return;
        }
        frsTopItemInfoView.onChangeSkinType();
    }

    public void c(ItemInfo itemInfo) {
        FrsTopItemInfoView frsTopItemInfoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, itemInfo) == null) || (frsTopItemInfoView = this.f25804b) == null) {
            return;
        }
        frsTopItemInfoView.setData(itemInfo);
    }
}
