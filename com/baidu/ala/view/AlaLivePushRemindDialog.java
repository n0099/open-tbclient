package com.baidu.ala.view;

import android.content.Intent;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.au4;
import com.baidu.tieba.rb;
import com.baidu.tieba.x15;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class AlaLivePushRemindDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext mPageContext;
    public rb msgRemindListener;

    public AlaLivePushRemindDialog(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        rb rbVar = new rb(this, 104102) { // from class: com.baidu.ala.view.AlaLivePushRemindDialog.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AlaLivePushRemindDialog this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage) && ((ResponseUpdateMaskInfoMessage) socketResponsedMessage).getError() == 0) {
                    x15.d().K(300);
                    x15.d().I(true);
                    x15.d().M(true);
                    x15.d().N(true);
                    x15.d().H(true);
                    x15.d().Q(true);
                    x15.d().J(true);
                    this.this$0.jumpSystemPermissionSetting();
                }
            }
        };
        this.msgRemindListener = rbVar;
        this.mPageContext = tbPageContext;
        tbPageContext.registerListener(rbVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpSystemPermissionSetting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            try {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + TbadkCoreApplication.getInst().getPackageName()));
                intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                this.mPageContext.getPageActivity().startActivity(intent);
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openMsgRemind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
            requestUpdateMaskInfoMessage.setMaskType(14);
            requestUpdateMaskInfoMessage.setSettingMask(true);
            this.mPageContext.sendMessage(requestUpdateMaskInfoMessage);
        }
    }

    public void showDialog(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            au4 au4Var = new au4(this.mPageContext.getPageActivity());
            au4Var.setAutoNight(false);
            au4Var.setTitle(R.string.obfuscated_res_0x7f0f022e);
            au4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0230, new au4.e(this, z) { // from class: com.baidu.ala.view.AlaLivePushRemindDialog.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AlaLivePushRemindDialog this$0;
                public final /* synthetic */ boolean val$showAttentionSuccessPanel;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$showAttentionSuccessPanel = z;
                }

                @Override // com.baidu.tieba.au4.e
                public void onClick(au4 au4Var2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, au4Var2) == null) {
                        TiebaStatic.log("c12670");
                        this.this$0.openMsgRemind();
                        au4Var2.dismiss();
                        if (this.val$showAttentionSuccessPanel) {
                            AlaAttentionManager.getInstance().showAttentionSucceedTip(this.this$0.mPageContext);
                        }
                    }
                }
            });
            au4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f022f, new au4.e(this, z) { // from class: com.baidu.ala.view.AlaLivePushRemindDialog.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AlaLivePushRemindDialog this$0;
                public final /* synthetic */ boolean val$showAttentionSuccessPanel;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$showAttentionSuccessPanel = z;
                }

                @Override // com.baidu.tieba.au4.e
                public void onClick(au4 au4Var2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, au4Var2) == null) {
                        TiebaStatic.log("c12671");
                        au4Var2.dismiss();
                        if (this.val$showAttentionSuccessPanel) {
                            AlaAttentionManager.getInstance().showAttentionSucceedTip(this.this$0.mPageContext);
                        }
                    }
                }
            });
            au4Var.create(this.mPageContext).show();
            TiebaStatic.log("c12669");
        }
    }
}
