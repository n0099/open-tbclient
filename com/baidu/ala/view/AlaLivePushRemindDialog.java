package com.baidu.ala.view;

import android.content.Intent;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import c.a.e.c.g.c;
import c.a.q0.s.s.a;
import c.a.q0.t.d.d;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class AlaLivePushRemindDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext mPageContext;
    public c msgRemindListener;

    public AlaLivePushRemindDialog(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c cVar = new c(this, 104102) { // from class: com.baidu.ala.view.AlaLivePushRemindDialog.1
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
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
                    d.d().E(300);
                    d.d().C(true);
                    d.d().G(true);
                    d.d().H(true);
                    d.d().B(true);
                    d.d().K(true);
                    d.d().D(true);
                    this.this$0.jumpSystemPermissionSetting();
                }
            }
        };
        this.msgRemindListener = cVar;
        this.mPageContext = tbPageContext;
        tbPageContext.registerListener(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpSystemPermissionSetting() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            try {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + TbadkCoreApplication.getInst().getPackageName()));
                intent.setFlags(268435456);
                this.mPageContext.getPageActivity().startActivity(intent);
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openMsgRemind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
            requestUpdateMaskInfoMessage.setMaskType(14);
            requestUpdateMaskInfoMessage.setSettingMask(true);
            this.mPageContext.sendMessage(requestUpdateMaskInfoMessage);
        }
    }

    public void showDialog(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            a aVar = new a(this.mPageContext.getPageActivity());
            aVar.setAutoNight(false);
            aVar.setTitle(R.string.ala_live_push_remind);
            aVar.setPositiveButton(R.string.ala_live_push_remind_open, new a.e(this, z) { // from class: com.baidu.ala.view.AlaLivePushRemindDialog.2
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$showAttentionSuccessPanel = z;
                }

                @Override // c.a.q0.s.s.a.e
                public void onClick(a aVar2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) {
                        TiebaStatic.log("c12670");
                        this.this$0.openMsgRemind();
                        aVar2.dismiss();
                        if (this.val$showAttentionSuccessPanel) {
                            AlaAttentionManager.getInstance().showAttentionSucceedTip(this.this$0.mPageContext);
                        }
                    }
                }
            });
            aVar.setNegativeButton(R.string.ala_live_push_remind_close, new a.e(this, z) { // from class: com.baidu.ala.view.AlaLivePushRemindDialog.3
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$showAttentionSuccessPanel = z;
                }

                @Override // c.a.q0.s.s.a.e
                public void onClick(a aVar2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) {
                        TiebaStatic.log("c12671");
                        aVar2.dismiss();
                        if (this.val$showAttentionSuccessPanel) {
                            AlaAttentionManager.getInstance().showAttentionSucceedTip(this.this$0.mPageContext);
                        }
                    }
                }
            });
            aVar.create(this.mPageContext).show();
            TiebaStatic.log("c12669");
        }
    }
}
