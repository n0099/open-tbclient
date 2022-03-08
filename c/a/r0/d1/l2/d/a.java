package c.a.r0.d1.l2.d;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.r0.d1.l2.d.d
    public void a(@NonNull View view, @NonNull View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view, onClickListener) == null) {
            ViewCommonUtil.setViewWidthHeight(view.findViewById(R.id.frs_tab_view_container), -3, UtilHelper.getDimenPixelSize(R.dimen.tbds117));
            TbTabLayout tbTabLayout = (TbTabLayout) view.findViewById(R.id.frs_tab_layout);
            tbTabLayout.setHorizontalFadingEdgeEnabled(true);
            tbTabLayout.setFadingEdgeLength(UtilHelper.getDimenPixelSize(R.dimen.tbds78));
            ViewCommonUtil.setViewMargin(tbTabLayout, -1, UtilHelper.getDimenPixelSize(R.dimen.M_H_X001), -1, -1);
            ImageView imageView = (ImageView) view.findViewById(R.id.frs_search_icon);
            imageView.setVisibility(0);
            WebPManager.setPureDrawable(imageView, R.drawable.ic_icon_pure_frs_search, R.color.CAM_X1107, null);
            imageView.setOnClickListener(onClickListener);
            imageView.setTag(R.id.click_view_tag, LogicField.SEARCH_BTN);
        }
    }
}
