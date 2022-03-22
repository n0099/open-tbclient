package c.a.p0.f1.l2.d;

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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.p0.f1.l2.d.d
    public void a(@NonNull View view, @NonNull View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view, onClickListener) == null) {
            ViewCommonUtil.setViewWidthHeight(view.findViewById(R.id.obfuscated_res_0x7f090be4), -3, UtilHelper.getDimenPixelSize(R.dimen.tbds117));
            TbTabLayout tbTabLayout = (TbTabLayout) view.findViewById(R.id.obfuscated_res_0x7f090be1);
            tbTabLayout.setHorizontalFadingEdgeEnabled(true);
            tbTabLayout.setFadingEdgeLength(UtilHelper.getDimenPixelSize(R.dimen.tbds78));
            ViewCommonUtil.setViewMargin(tbTabLayout, -1, UtilHelper.getDimenPixelSize(R.dimen.M_H_X001), -1, -1);
            ImageView imageView = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090bc5);
            imageView.setVisibility(0);
            WebPManager.setPureDrawable(imageView, R.drawable.obfuscated_res_0x7f080602, R.color.CAM_X1107, null);
            imageView.setOnClickListener(onClickListener);
            imageView.setTag(R.id.obfuscated_res_0x7f090659, LogicField.SEARCH_BTN);
        }
    }
}
