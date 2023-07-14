package com.baidu.tbadk.core.util;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.BdToastData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.R;
import com.baidu.tieba.dba;
import com.baidu.tieba.nx4;
import com.baidu.tieba.yi;
import com.baidu.tieba.zg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return mBdToastData;
        }
        return (BdToastData) invokeV.objValue;
    }

    public static boolean canShowToast(BdToastData bdToastData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bdToastData)) == null) {
            if (bdToastData != null && (StringUtils.isNotNull(bdToastData.getUrl()) || ListUtils.isNotEmpty(bdToastData.getContent()))) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00da A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x004a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SpannableString getToastSpannableString(BdToastData bdToastData) {
        InterceptResult invokeL;
        ForegroundColorSpan foregroundColorSpan;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bdToastData)) == null) {
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
                    if (TbadkApplication.getInst().getSkinType() == 4) {
                        if (StringUtils.isNotNull(contentBean2.getTextColorDark())) {
                            foregroundColorSpan = new ForegroundColorSpan(dba.f(contentBean2.getTextColorDark()));
                        } else {
                            if (contentBean2.getHasColor() == 1) {
                                foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305));
                            }
                            foregroundColorSpan = null;
                        }
                        if (foregroundColorSpan != null) {
                            spannableString.setSpan(foregroundColorSpan, sb2.length(), sb2.length() + contentBean2.getText().length(), 33);
                        }
                        if (StringUtils.isNull(contentBean2.getText())) {
                            sb2.append(contentBean2.getText());
                        }
                    } else {
                        if (StringUtils.isNotNull(contentBean2.getTextColor())) {
                            foregroundColorSpan = new ForegroundColorSpan(dba.f(contentBean2.getTextColor()));
                        } else {
                            if (contentBean2.getHasColor() == 1) {
                                foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305));
                            }
                            foregroundColorSpan = null;
                        }
                        if (foregroundColorSpan != null) {
                        }
                        if (StringUtils.isNull(contentBean2.getText())) {
                        }
                    }
                }
            }
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public static void setToastIcon(BdToast bdToast, BdToastData bdToastData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, null, bdToast, bdToastData) == null) && bdToast != null && bdToastData != null) {
            bdToast.j(bdToastData.getIconUrl());
            bdToast.k(bdToastData.getIconUrlDark());
            bdToast.h(bdToastData.getIconWidth(), bdToastData.getIconHeight());
            bdToast.n(bdToastData.getHudWidth());
            if (bdToastData.getIconType() == 1) {
                bdToast.g(BdToast.ToastIcon.SUCCESS);
            } else if (bdToastData.getIconType() == 2) {
                bdToast.g(BdToast.ToastIcon.FAILURE);
            } else if (bdToastData.getIconType() == 3) {
                bdToast.f(R.drawable.icon_mask_frs_firstlike40);
            } else if (bdToastData.getIconType() == 4) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds286);
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds203);
                bdToast.f(R.drawable.icon_mask_toast_grow);
                bdToast.h(dimenPixelSize, dimenPixelSize2);
            } else if (bdToastData.getIconType() == 5) {
                int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds286);
                int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.tbds203);
                bdToast.f(R.drawable.icon_mask_usergrowthjiasu);
                bdToast.h(dimenPixelSize3, dimenPixelSize4);
            } else if (bdToastData.getIconType() == 6) {
                int dimenPixelSize5 = UtilHelper.getDimenPixelSize(R.dimen.tbds580);
                int dimenPixelSize6 = UtilHelper.getDimenPixelSize(R.dimen.tbds231);
                bdToast.f(R.drawable.icon_mask_world_cup_flag);
                bdToast.h(dimenPixelSize5, dimenPixelSize6);
            } else if (bdToastData.getIconType() == 7) {
                int dimenPixelSize7 = UtilHelper.getDimenPixelSize(R.dimen.tbds580);
                int dimenPixelSize8 = UtilHelper.getDimenPixelSize(R.dimen.tbds231);
                bdToast.f(R.drawable.icon_mask_world_cup_ball);
                bdToast.h(dimenPixelSize7, dimenPixelSize8);
            } else if (bdToastData.getIconType() == 8) {
                int dimenPixelSize9 = UtilHelper.getDimenPixelSize(R.dimen.tbds580);
                int dimenPixelSize10 = UtilHelper.getDimenPixelSize(R.dimen.tbds231);
                bdToast.f(R.drawable.icon_mask_festival_firworks);
                bdToast.i(dimenPixelSize9, dimenPixelSize10, UtilHelper.getDimenPixelSize(R.dimen.tbds12));
            }
        }
    }

    public static void showToastByUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, str) == null) {
            TbWebViewActivityConfig g = nx4.g(TbadkCoreApplication.getInst(), null, str, true);
            g.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
            g.start();
            if (mBdToastData.getTaskIds() != null && mBdToastData.getTaskIds().length > 0) {
                showToastLog(mBdToastData.getTaskIds());
            }
        }
    }

    public static void showToastLog(int[] iArr) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, iArr) == null) {
            if (TbadkCoreApplication.getCurrentMemberType() > 0) {
                i = 2;
            } else {
                i = 1;
            }
            for (int i2 : iArr) {
                new StatisticItem(CommonStatisticKey.KEY_USER_GROWTH_TASK_FINISH_TOAST_SHOW).addParam("obj_locate", i2).addParam("obj_type", i).eventStat();
            }
        }
    }

    public static void toast(BdToastData bdToastData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, bdToastData) == null) {
            mBdToastData = bdToastData;
            if (bdToastData == null) {
                return;
            }
            if (!TextUtils.isEmpty(bdToastData.getUrl()) && TbadkCoreApplication.getInst().getCurrentActivity() != null) {
                if (yi.F()) {
                    showToastByUrl(bdToastData.getUrl());
                    return;
                } else {
                    zg.a().post(new Runnable(bdToastData) { // from class: com.baidu.tbadk.core.util.BdToastHelper.1
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
                int f = dba.f(bdToastData.getBackground());
                if (f != 0 && f != Integer.MAX_VALUE) {
                    b.c(f);
                }
                if (yi.F()) {
                    b.q();
                } else {
                    zg.a().post(new Runnable(b) { // from class: com.baidu.tbadk.core.util.BdToastHelper.2
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
                                this.val$bdToast.q();
                            }
                        }
                    });
                }
                if (bdToastData.getTaskIds() != null && bdToastData.getTaskIds().length > 0) {
                    showToastLog(bdToastData.getTaskIds());
                }
            }
        }
    }
}
