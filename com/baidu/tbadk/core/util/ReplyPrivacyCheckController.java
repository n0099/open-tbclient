package com.baidu.tbadk.core.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ki;
import com.repackage.mi;
import com.repackage.nr4;
import com.repackage.py4;
import com.repackage.uq4;
/* loaded from: classes3.dex */
public class ReplyPrivacyCheckController {
    public static /* synthetic */ Interceptable $ic = null;
    public static int PRIVACY_MYSELF = 4;
    public static int PRIVACY_MY_ATTENTION = 3;
    public static int PRIVACY_MY_FANS = 2;
    public static int TYPE_EMOTION_IMAGE = 2;
    public static int TYPE_FLOOR = 1;
    public static int TYPE_THREAD;
    public transient /* synthetic */ FieldHolder $fh;
    public IAfterAttentionCallBack mAttentionCallback;
    public CustomMessageListener mAttentionListener;
    public py4 mAttentionModel;
    public TbPageContext mContext;
    public nr4 mDialog;
    public BdUniqueId mId;
    public AttentionHostData mLikeData;
    public int replyType;

    /* loaded from: classes3.dex */
    public interface IAfterAttentionCallBack {
        void sendAfterAttention(boolean z, int i);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1021372875, "Lcom/baidu/tbadk/core/util/ReplyPrivacyCheckController;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1021372875, "Lcom/baidu/tbadk/core/util/ReplyPrivacyCheckController;");
        }
    }

    public ReplyPrivacyCheckController(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mAttentionListener = new CustomMessageListener(this, 2001115) { // from class: com.baidu.tbadk.core.util.ReplyPrivacyCheckController.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ReplyPrivacyCheckController this$0;

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
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                    if (this.this$0.mLikeData == null || StringUtils.isNull(this.this$0.mLikeData.uid) || data == null || !this.this$0.mLikeData.uid.equals(data.c)) {
                        return;
                    }
                    boolean z = false;
                    if (updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag().equals(this.this$0.mId)) {
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.h(this.this$0.mContext.getPageActivity(), updateAttentionMessage.getErrorString(), R.drawable.obfuscated_res_0x7f0809be, 3000, false).q();
                        } else {
                            AntiHelper.s(this.this$0.mContext.getPageActivity(), data.l);
                        }
                        z = true;
                    }
                    if (data.a) {
                        this.this$0.mLikeData.likeStatus = data.m;
                        this.this$0.mLikeData.isAttention = data.d;
                    }
                    if (!z || this.this$0.mAttentionCallback == null) {
                        return;
                    }
                    this.this$0.mAttentionCallback.sendAfterAttention(data.a, this.this$0.replyType);
                }
            }
        };
        this.mContext = tbPageContext;
        BdUniqueId gen = BdUniqueId.gen();
        this.mId = gen;
        this.mAttentionListener.setTag(gen);
        MessageManager.getInstance().registerListener(this.mAttentionListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void followHost() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            if (!ki.A()) {
                this.mContext.showToast(R.string.obfuscated_res_0x7f0f0c2f);
            } else if (this.mLikeData != null && ViewHelper.checkUpIsLogin(this.mContext.getPageActivity())) {
                if (this.mAttentionModel == null) {
                    this.mAttentionModel = new py4(this.mContext);
                }
                py4 py4Var = this.mAttentionModel;
                AttentionHostData attentionHostData = this.mLikeData;
                py4Var.l(true, attentionHostData.portrait, attentionHostData.uid, attentionHostData.isGod, "0", this.mId, null, "0");
            }
        }
    }

    private void showAttentionDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            if (this.mDialog == null) {
                nr4 nr4Var = new nr4(this.mContext.getPageActivity());
                this.mDialog = nr4Var;
                nr4Var.setMessageId(R.string.obfuscated_res_0x7f0f0ac1);
                this.mDialog.setPositiveButton(R.string.obfuscated_res_0x7f0f02a5, new nr4.e(this) { // from class: com.baidu.tbadk.core.util.ReplyPrivacyCheckController.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ReplyPrivacyCheckController this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
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
                    }

                    @Override // com.repackage.nr4.e
                    public void onClick(nr4 nr4Var2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, nr4Var2) == null) {
                            this.this$0.followHost();
                            this.this$0.mDialog.dismiss();
                        }
                    }
                });
                this.mDialog.setNegativeButton(R.string.obfuscated_res_0x7f0f0374, new nr4.e(this) { // from class: com.baidu.tbadk.core.util.ReplyPrivacyCheckController.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ReplyPrivacyCheckController this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
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
                    }

                    @Override // com.repackage.nr4.e
                    public void onClick(nr4 nr4Var2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, nr4Var2) == null) {
                            this.this$0.mDialog.dismiss();
                        }
                    }
                });
                this.mDialog.setAutoNight(true);
                this.mDialog.create(this.mContext);
            }
            this.mDialog.show();
        }
    }

    public boolean checkPrivacyBeforeInvokeEditor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i == PRIVACY_MY_ATTENTION) {
                mi.M(this.mContext.getPageActivity(), R.string.obfuscated_res_0x7f0f0f4e);
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public boolean checkPrivacyBeforeSend(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2)) == null) {
            this.replyType = i2;
            if (i == PRIVACY_MY_FANS) {
                AttentionHostData attentionHostData = this.mLikeData;
                if (attentionHostData == null || attentionHostData.isAttention) {
                    return true;
                }
                showAttentionDialog();
                return false;
            } else if (i == PRIVACY_MY_ATTENTION) {
                mi.M(this.mContext.getPageActivity(), R.string.obfuscated_res_0x7f0f0f4e);
                return false;
            } else {
                return true;
            }
        }
        return invokeII.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.mId);
            nr4 nr4Var = this.mDialog;
            if (nr4Var != null) {
                nr4Var.dismiss();
            }
            py4 py4Var = this.mAttentionModel;
            if (py4Var != null) {
                py4Var.g();
            }
        }
    }

    public void setAttentionCallback(IAfterAttentionCallBack iAfterAttentionCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iAfterAttentionCallBack) == null) {
            this.mAttentionCallback = iAfterAttentionCallBack;
        }
    }

    public void setLikeUserData(AttentionHostData attentionHostData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, attentionHostData) == null) {
            this.mLikeData = attentionHostData;
        }
    }

    public boolean showToastForPrivacy(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (i == PRIVACY_MY_FANS) {
                AttentionHostData attentionHostData = this.mLikeData;
                if (attentionHostData == null || attentionHostData.isAttention) {
                    return true;
                }
                mi.M(this.mContext.getPageActivity(), R.string.obfuscated_res_0x7f0f0ac1);
                return false;
            } else if (i == PRIVACY_MY_ATTENTION) {
                mi.M(this.mContext.getPageActivity(), R.string.obfuscated_res_0x7f0f0f4e);
                return false;
            } else {
                return true;
            }
        }
        return invokeI.booleanValue;
    }

    public void showAttentionDialog(uq4 uq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, uq4Var) == null) {
            if (uq4Var != null && !StringUtils.isNull(uq4Var.a) && !StringUtils.isNull(uq4Var.b) && !StringUtils.isNull(uq4Var.c)) {
                nr4 nr4Var = new nr4(this.mContext.getPageActivity());
                nr4Var.setMessage(uq4Var.a);
                nr4Var.setPositiveButton(uq4Var.c, new nr4.e(this) { // from class: com.baidu.tbadk.core.util.ReplyPrivacyCheckController.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ReplyPrivacyCheckController this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
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
                    }

                    @Override // com.repackage.nr4.e
                    public void onClick(nr4 nr4Var2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, nr4Var2) == null) {
                            this.this$0.followHost();
                            nr4Var2.dismiss();
                        }
                    }
                });
                nr4Var.setNegativeButton(uq4Var.b, new nr4.e(this) { // from class: com.baidu.tbadk.core.util.ReplyPrivacyCheckController.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ReplyPrivacyCheckController this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
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
                    }

                    @Override // com.repackage.nr4.e
                    public void onClick(nr4 nr4Var2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, nr4Var2) == null) {
                            nr4Var2.dismiss();
                        }
                    }
                });
                nr4Var.setAutoNight(true);
                nr4Var.create(this.mContext);
                nr4Var.show();
                return;
            }
            showAttentionDialog();
        }
    }
}
