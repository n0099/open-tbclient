package com.baidu.tbadk.core.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.message.UpgradePopWindowMessage;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.rq4;
import com.repackage.uw4;
import com.repackage.v85;
import com.repackage.wq4;
import com.repackage.ys4;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes3.dex */
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? SIMPLE_DATE_FORMAT.format(new Date()) : (String) invokeV.objValue;
    }

    public static int daysBetween(Date date, Date date2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, date, date2)) == null) ? Math.abs((int) ((date.getTime() - date2.getTime()) / 86400000)) : invokeLL.intValue;
    }

    public static boolean isDue(uw4 uw4Var) {
        InterceptResult invokeL;
        Date string2Date;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, uw4Var)) == null) {
            String q = ys4.k().q(SP_UPGRADE_POP_WINDOW_SHOW_DATE, "");
            return TextUtils.isEmpty(q) || (string2Date = string2Date(q)) == null || daysBetween(new Date(), string2Date) >= uw4Var.b();
        }
        return invokeL.booleanValue;
    }

    public static void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            v85 v85Var = new v85(2001016, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.tbadk.core.util.UpgradePopWindowHelper.1
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
                            uw4 upgradePopWindowConfig = TbSingleton.getInstance().getUpgradePopWindowConfig();
                            if (upgradePopWindowConfig.i() && upgradePopWindowConfig.h().contains(upgradePopWindowMessage.getFromPage()) && UpgradePopWindowHelper.isDue(upgradePopWindowConfig) && (customMessage.getData() instanceof TbPageContext)) {
                                UpgradePopWindowHelper.showPopWindow(customMessage.getData(), upgradePopWindowConfig);
                                ys4.k().y(UpgradePopWindowHelper.SP_UPGRADE_POP_WINDOW_SHOW_DATE, UpgradePopWindowHelper.date2String());
                            }
                        }
                        return null;
                    }
                    return (CustomResponsedMessage) invokeL.objValue;
                }
            });
            v85Var.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(v85Var);
        }
    }

    public static void showPopWindow(TbPageContext tbPageContext, uw4 uw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, tbPageContext, uw4Var) == null) {
            Activity pageActivity = tbPageContext.getPageActivity();
            RelativeLayout relativeLayout = new RelativeLayout(pageActivity);
            View view2 = new View(pageActivity);
            wq4 d = wq4.d(view2);
            d.m(1);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(R.dimen.tbds237));
            layoutParams.setMargins(0, UtilHelper.getDimenPixelSize(R.dimen.tbds120), 0, 0);
            relativeLayout.addView(view2, layoutParams);
            ImageView imageView = new ImageView(pageActivity);
            WebPManager.setMaskDrawable(imageView, R.drawable.obfuscated_res_0x7f0807fa, null);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(14);
            relativeLayout.addView(imageView, layoutParams2);
            rq4 rq4Var = new rq4(pageActivity);
            rq4Var.v(uw4Var.d());
            rq4Var.p(uw4Var.g());
            rq4Var.n(true);
            rq4Var.k(relativeLayout);
            if (TextUtils.isEmpty(uw4Var.c())) {
                rq4Var.r(new TBAlertConfig.a(uw4Var.e(), TBAlertConfig.OperateBtnStyle.MAIN, new View.OnClickListener(rq4Var) { // from class: com.baidu.tbadk.core.util.UpgradePopWindowHelper.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ rq4 val$builder;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {rq4Var};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$builder = rq4Var;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                            this.val$builder.c().dismiss();
                        }
                    }
                }));
            } else {
                rq4Var.r(new TBAlertConfig.a(uw4Var.f(), TBAlertConfig.OperateBtnStyle.SECONDARY, new View.OnClickListener(rq4Var) { // from class: com.baidu.tbadk.core.util.UpgradePopWindowHelper.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ rq4 val$builder;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {rq4Var};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$builder = rq4Var;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                            this.val$builder.c().dismiss();
                        }
                    }
                }), new TBAlertConfig.a(uw4Var.e(), TBAlertConfig.OperateBtnStyle.FORCE, new View.OnClickListener(tbPageContext, uw4Var, rq4Var) { // from class: com.baidu.tbadk.core.util.UpgradePopWindowHelper.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ rq4 val$builder;
                    public final /* synthetic */ uw4 val$config;
                    public final /* synthetic */ TbPageContext val$pageContext;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {tbPageContext, uw4Var, rq4Var};
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
                        this.val$config = uw4Var;
                        this.val$builder = rq4Var;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                            UrlManager.getInstance().dealOneLink(this.val$pageContext, new String[]{this.val$config.c()});
                            this.val$builder.c().dismiss();
                        }
                    }
                }));
            }
            rq4Var.c().setCanceledOnTouchOutside(false);
            rq4Var.x();
            isShowed = true;
            TbSingleton.getInstance().setExceptInsertAdDiaShow(true);
        }
    }

    public static Date string2Date(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
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
