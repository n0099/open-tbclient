package com.baidu.tbadk.core.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.message.UpgradePopWindowMessage;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.cq5;
import com.baidu.tieba.f95;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes4.dex */
public class UpgradePopWindowHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String APP = "app";
    public static final String FRS = "frs";
    @SuppressLint({"SimpleDateFormat"})
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT;
    public static final String SP_UPGRADE_POP_WINDOW_SHOW_DATE = "sp_upgrade_pop_window_show_date";
    public static boolean isShowed;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1326576840, "Lcom/baidu/tbadk/core/util/UpgradePopWindowHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1326576840, "Lcom/baidu/tbadk/core/util/UpgradePopWindowHelper;");
                return;
            }
        }
        SIMPLE_DATE_FORMAT = new SimpleDateFormat("yy-MM-dd");
    }

    public UpgradePopWindowHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String date2String() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return SIMPLE_DATE_FORMAT.format(new Date());
        }
        return (String) invokeV.objValue;
    }

    public static void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            cq5 cq5Var = new cq5(2001016, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.tbadk.core.util.UpgradePopWindowHelper.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<?> run(CustomMessage<TbPageContext> customMessage) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, customMessage)) == null) {
                        if (!UpgradePopWindowHelper.isShowed && customMessage != null && customMessage.getData() != null && (customMessage instanceof UpgradePopWindowMessage)) {
                            UpgradePopWindowMessage upgradePopWindowMessage = (UpgradePopWindowMessage) customMessage;
                            f95 upgradePopWindowConfig = TbSingleton.getInstance().getUpgradePopWindowConfig();
                            if (upgradePopWindowConfig.i() && upgradePopWindowConfig.h().contains(upgradePopWindowMessage.getFromPage()) && UpgradePopWindowHelper.isDue(upgradePopWindowConfig) && (customMessage.getData() instanceof TbPageContext)) {
                                UpgradePopWindowHelper.showPopWindow(customMessage.getData(), upgradePopWindowConfig);
                                SharedPrefHelper.getInstance().putString(UpgradePopWindowHelper.SP_UPGRADE_POP_WINDOW_SHOW_DATE, UpgradePopWindowHelper.date2String());
                            }
                        }
                        return null;
                    }
                    return (CustomResponsedMessage) invokeL.objValue;
                }
            });
            cq5Var.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(cq5Var);
        }
    }

    public static int daysBetween(Date date, Date date2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, date, date2)) == null) {
            return Math.abs((int) ((date.getTime() - date2.getTime()) / 86400000));
        }
        return invokeLL.intValue;
    }

    public static boolean isDue(f95 f95Var) {
        InterceptResult invokeL;
        Date string2Date;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, f95Var)) == null) {
            String string = SharedPrefHelper.getInstance().getString(SP_UPGRADE_POP_WINDOW_SHOW_DATE, "");
            if (TextUtils.isEmpty(string) || (string2Date = string2Date(string)) == null || daysBetween(new Date(), string2Date) >= f95Var.b()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void showPopWindow(TbPageContext tbPageContext, f95 f95Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, tbPageContext, f95Var) == null) {
            Activity pageActivity = tbPageContext.getPageActivity();
            RelativeLayout relativeLayout = new RelativeLayout(pageActivity);
            View view2 = new View(pageActivity);
            EMManager.from(view2).setCardType(1).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(R.dimen.tbds237));
            layoutParams.setMargins(0, UtilHelper.getDimenPixelSize(R.dimen.tbds120), 0, 0);
            relativeLayout.addView(view2, layoutParams);
            ImageView imageView = new ImageView(pageActivity);
            WebPManager.setMaskDrawable(imageView, R.drawable.icon_mask_popshengji, null);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(14);
            relativeLayout.addView(imageView, layoutParams2);
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(pageActivity);
            tBAlertBuilder.setTitleStr(f95Var.d());
            tBAlertBuilder.setDescStr(f95Var.g());
            tBAlertBuilder.setDescLightStyle(true);
            tBAlertBuilder.setCustomHeaderView(relativeLayout);
            if (TextUtils.isEmpty(f95Var.c())) {
                tBAlertBuilder.setOperateBtn(new TBAlertConfig.OperateBtnConfig(f95Var.e(), TBAlertConfig.OperateBtnStyle.MAIN, new View.OnClickListener(tBAlertBuilder) { // from class: com.baidu.tbadk.core.util.UpgradePopWindowHelper.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TBAlertBuilder val$builder;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {tBAlertBuilder};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$builder = tBAlertBuilder;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                            this.val$builder.create().dismiss();
                        }
                    }
                }));
            } else {
                tBAlertBuilder.setOperateBtn(new TBAlertConfig.OperateBtnConfig(f95Var.f(), TBAlertConfig.OperateBtnStyle.SECONDARY, new View.OnClickListener(tBAlertBuilder) { // from class: com.baidu.tbadk.core.util.UpgradePopWindowHelper.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TBAlertBuilder val$builder;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {tBAlertBuilder};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$builder = tBAlertBuilder;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                            this.val$builder.create().dismiss();
                        }
                    }
                }), new TBAlertConfig.OperateBtnConfig(f95Var.e(), TBAlertConfig.OperateBtnStyle.FORCE, new View.OnClickListener(tbPageContext, f95Var, tBAlertBuilder) { // from class: com.baidu.tbadk.core.util.UpgradePopWindowHelper.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TBAlertBuilder val$builder;
                    public final /* synthetic */ f95 val$config;
                    public final /* synthetic */ TbPageContext val$pageContext;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {tbPageContext, f95Var, tBAlertBuilder};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$pageContext = tbPageContext;
                        this.val$config = f95Var;
                        this.val$builder = tBAlertBuilder;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                            UrlManager.getInstance().dealOneLink(this.val$pageContext, new String[]{this.val$config.c()});
                            this.val$builder.create().dismiss();
                        }
                    }
                }));
            }
            tBAlertBuilder.create().setCanceledOnTouchOutside(false);
            tBAlertBuilder.show();
            isShowed = true;
            TbSingleton.getInstance();
            TbSingleton.setExceptInsertAdDiaShow(true);
        }
    }

    public static Date string2Date(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            try {
                return SIMPLE_DATE_FORMAT.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (Date) invokeL.objValue;
    }
}
