package com.baidu.tbadk.core.util;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BdToastData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.tieba.gh;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class BdToastHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HAS_COLOR = 1;
    public static final int ICON_TYPE_DEFAULT_FAILURE = 2;
    public static final int ICON_TYPE_DEFAULT_SUCCESS = 1;
    public static final int ICON_TYPE_PRAISE = 3;
    public static final int ICON_TYPE_USER_GROW = 4;
    public static final int ICON_TYPE_VIP_DOUBLE = 5;
    public static BdToastData mBdToastData;
    public transient /* synthetic */ FieldHolder $fh;

    public BdToastHelper() {
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

    public static BdToastData getBdToastData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? mBdToastData : (BdToastData) invokeV.objValue;
    }

    public static SpannableString getToastSpannableString(BdToastData bdToastData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bdToastData)) == null) {
            if (bdToastData == null || bdToastData.getContent() == null) {
                return null;
            }
            List<BdToastData.ContentBean> content = bdToastData.getContent();
            StringBuilder sb = new StringBuilder();
            for (BdToastData.ContentBean contentBean : content) {
                if (contentBean != null && !StringUtils.isNull(contentBean.getText())) {
                    sb.append(contentBean.getText());
                }
            }
            SpannableString spannableString = new SpannableString(sb);
            StringBuilder sb2 = new StringBuilder();
            for (BdToastData.ContentBean contentBean2 : content) {
                if (contentBean2 != null) {
                    if (contentBean2.getHasColor() == 1) {
                        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)), sb2.length(), sb2.length() + contentBean2.getText().length(), 33);
                    }
                    if (!StringUtils.isNull(contentBean2.getText())) {
                        sb2.append(contentBean2.getText());
                    }
                }
            }
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public static void setToastIcon(BdToast bdToast, BdToastData bdToastData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, bdToast, bdToastData) == null) || bdToast == null || bdToastData == null) {
            return;
        }
        if (bdToastData.getIconType() == 1) {
            bdToast.f(BdToast.ToastIcon.SUCCESS);
        } else if (bdToastData.getIconType() == 2) {
            bdToast.f(BdToast.ToastIcon.FAILURE);
        } else if (bdToastData.getIconType() == 3) {
            bdToast.e(R.drawable.obfuscated_res_0x7f0807eb);
        } else if (bdToastData.getIconType() == 4) {
            bdToast.g(R.drawable.obfuscated_res_0x7f08083b, UtilHelper.getDimenPixelSize(R.dimen.tbds286), UtilHelper.getDimenPixelSize(R.dimen.tbds203));
        } else if (bdToastData.getIconType() == 5) {
            bdToast.g(R.drawable.obfuscated_res_0x7f080843, UtilHelper.getDimenPixelSize(R.dimen.tbds286), UtilHelper.getDimenPixelSize(R.dimen.tbds203));
        }
    }

    public static void toast(BdToastData bdToastData) {
        SpannableString toastSpannableString;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bdToastData) == null) {
            mBdToastData = bdToastData;
            if (bdToastData == null || (toastSpannableString = getToastSpannableString(bdToastData)) == null) {
                return;
            }
            BdToast b = BdToast.b(TbadkCoreApplication.getInst().getContext(), toastSpannableString);
            setToastIcon(b, bdToastData);
            if (ej.C()) {
                b.i();
            } else {
                gh.a().post(new Runnable(b) { // from class: com.baidu.tbadk.core.util.BdToastHelper.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BdToast val$bdToast;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {b};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$bdToast = b;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.val$bdToast.i();
                        }
                    }
                });
            }
        }
    }
}
