package com.baidu.tbadk.core.util;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.BdToastData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.R;
import com.baidu.tieba.b49;
import com.baidu.tieba.ej;
import com.baidu.tieba.gh;
import com.baidu.tieba.zu4;
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
    public static final int ICON_TYPE_FESTIVAL_FIREWORKS = 8;
    public static final int ICON_TYPE_PRAISE = 3;
    public static final int ICON_TYPE_USER_GROW = 4;
    public static final int ICON_TYPE_VIP_DOUBLE = 5;
    public static final int ICON_TYPE_WORLD_CUP_BALL = 7;
    public static final int ICON_TYPE_WORLD_CUP_FLAG = 6;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return mBdToastData;
        }
        return (BdToastData) invokeV.objValue;
    }

    public static void showToastByUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            TbWebViewActivityConfig g = zu4.g(TbadkCoreApplication.getInst(), null, str, true);
            g.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
            g.start();
        }
    }

    public static SpannableString getToastSpannableString(BdToastData bdToastData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bdToastData)) == null) {
            if (bdToastData != null && bdToastData.getContent() != null) {
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
            return null;
        }
        return (SpannableString) invokeL.objValue;
    }

    public static void setToastIcon(BdToast bdToast, BdToastData bdToastData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bdToast, bdToastData) == null) && bdToast != null && bdToastData != null) {
            if (bdToastData.getIconType() == 1) {
                bdToast.g(BdToast.ToastIcon.SUCCESS);
            } else if (bdToastData.getIconType() == 2) {
                bdToast.g(BdToast.ToastIcon.FAILURE);
            } else if (bdToastData.getIconType() == 3) {
                bdToast.f(R.drawable.icon_mask_frs_firstlike40);
            } else if (bdToastData.getIconType() == 4) {
                bdToast.h(R.drawable.icon_mask_toast_grow, UtilHelper.getDimenPixelSize(R.dimen.tbds286), UtilHelper.getDimenPixelSize(R.dimen.tbds203));
            } else if (bdToastData.getIconType() == 5) {
                bdToast.h(R.drawable.icon_mask_usergrowthjiasu, UtilHelper.getDimenPixelSize(R.dimen.tbds286), UtilHelper.getDimenPixelSize(R.dimen.tbds203));
            } else if (bdToastData.getIconType() == 6) {
                bdToast.h(R.drawable.icon_mask_world_cup_flag, UtilHelper.getDimenPixelSize(R.dimen.tbds580), UtilHelper.getDimenPixelSize(R.dimen.tbds231));
            } else if (bdToastData.getIconType() == 7) {
                bdToast.h(R.drawable.icon_mask_world_cup_ball, UtilHelper.getDimenPixelSize(R.dimen.tbds580), UtilHelper.getDimenPixelSize(R.dimen.tbds231));
            } else if (bdToastData.getIconType() == 8) {
                bdToast.i(R.drawable.icon_mask_festival_firworks, UtilHelper.getDimenPixelSize(R.dimen.tbds580), UtilHelper.getDimenPixelSize(R.dimen.tbds231), UtilHelper.getDimenPixelSize(R.dimen.tbds12));
            }
        }
    }

    public static void toast(BdToastData bdToastData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, bdToastData) == null) {
            mBdToastData = bdToastData;
            if (bdToastData == null) {
                return;
            }
            if (!TextUtils.isEmpty(bdToastData.getUrl()) && TbadkCoreApplication.getInst().getCurrentActivity() != null) {
                if (ej.E()) {
                    showToastByUrl(bdToastData.getUrl());
                    return;
                } else {
                    gh.a().post(new Runnable(bdToastData) { // from class: com.baidu.tbadk.core.util.BdToastHelper.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ BdToastData val$data;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {bdToastData};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.val$data = bdToastData;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                BdToastHelper.showToastByUrl(this.val$data.getUrl());
                            }
                        }
                    });
                    return;
                }
            }
            SpannableString toastSpannableString = getToastSpannableString(bdToastData);
            if (toastSpannableString != null) {
                BdToast b = BdToast.b(TbadkCoreApplication.getInst().getContext(), toastSpannableString);
                setToastIcon(b, bdToastData);
                int f = b49.f(bdToastData.getBackground());
                if (f != 0 && f != Integer.MAX_VALUE) {
                    b.c(f);
                }
                if (ej.E()) {
                    b.k();
                } else {
                    gh.a().post(new Runnable(b) { // from class: com.baidu.tbadk.core.util.BdToastHelper.2
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
                                this.val$bdToast.k();
                            }
                        }
                    });
                }
            }
        }
    }
}
