package com.baidu.tbadk.core.util;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BdAlertData;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tieba.rd;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class TBAlertBuilderHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_RETURN = "return";
    public static final String COM_ERROR_DIALOG = "alert";
    public transient /* synthetic */ FieldHolder $fh;

    public TBAlertBuilderHelper() {
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

    public static void sendReturnMessage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921814, str));
        }
    }

    public static void dialog(BdAlertData bdAlertData) {
        BdAlertData.AlertBtn alertBtn;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, bdAlertData) == null) && bdAlertData != null && !ListUtils.isEmpty(bdAlertData.getButtons()) && TbadkCoreApplication.getInst().getCurrentActivity() != null) {
            List<BdAlertData.AlertBtn> buttons = bdAlertData.getButtons();
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(TbadkCoreApplication.getInst().getCurrentActivity());
            tBAlertBuilder.setTitleStr(bdAlertData.getTitle());
            tBAlertBuilder.setDescStr(bdAlertData.getContent());
            TBAlertConfig.OperateBtnConfig[] operateBtnConfigArr = new TBAlertConfig.OperateBtnConfig[bdAlertData.getButtons().size()];
            for (int i = 0; i < buttons.size(); i++) {
                if (buttons.get(i) != null && (alertBtn = buttons.get(i)) != null) {
                    TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig(alertBtn.getText(), TBAlertConfig.OperateBtnStyle.MAIN);
                    operateBtnConfig.setListener(new View.OnClickListener(alertBtn, tBAlertBuilder) { // from class: com.baidu.tbadk.core.util.TBAlertBuilderHelper.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ BdAlertData.AlertBtn val$AlertBtn;
                        public final /* synthetic */ TBAlertBuilder val$builder;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {alertBtn, tBAlertBuilder};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.val$AlertBtn = alertBtn;
                            this.val$builder = tBAlertBuilder;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            BdAlertData.AlertBtn alertBtn2;
                            TBAlertBuilder tBAlertBuilder2;
                            Interceptable interceptable2 = $ic;
                            if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) && (alertBtn2 = this.val$AlertBtn) != null && alertBtn2.getConfig() != null && this.val$AlertBtn.getConfig().getAction() != null && rd.isEquals(this.val$AlertBtn.getConfig().getAction(), TBAlertBuilderHelper.ACTION_RETURN) && (tBAlertBuilder2 = this.val$builder) != null) {
                                tBAlertBuilder2.dismiss();
                                TBAlertBuilderHelper.sendReturnMessage(TBAlertBuilderHelper.ACTION_RETURN);
                            }
                        }
                    });
                    operateBtnConfigArr[i] = operateBtnConfig;
                }
            }
            tBAlertBuilder.setOperateBtn(operateBtnConfigArr);
            tBAlertBuilder.setCancelable(false);
            if (BdUtilHelper.isMainThread()) {
                tBAlertBuilder.show();
            } else {
                SafeHandler.getInst().post(new Runnable(tBAlertBuilder) { // from class: com.baidu.tbadk.core.util.TBAlertBuilderHelper.2
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$builder = tBAlertBuilder;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.val$builder.show();
                        }
                    }
                });
            }
        }
    }
}
