package com.baidu.tbadk.core.util;

import android.app.Activity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.ve5;
import com.baidu.tieba.x35;
import com.baidu.tieba.y45;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ReplyPrivacyCheckController {
    public static /* synthetic */ Interceptable $ic = null;
    public static int PRIVACY_MYSELF = 4;
    public static int PRIVACY_MY_ATTENTION = 3;
    public static int PRIVACY_MY_FANS = 2;
    public static int PRIVACY_READ_ONLY = 5;
    public static int TYPE_FLOOR = 1;
    public static int TYPE_THREAD;
    public transient /* synthetic */ FieldHolder $fh;
    public IAfterAttentionCallBack mAttentionCallback;
    public CustomMessageListener mAttentionListener;
    public ve5 mAttentionModel;
    public TbPageContext mContext;
    public y45 mDialog;
    public BdUniqueId mId;
    public AttentionHostData mLikeData;
    public int replyType;

    /* loaded from: classes4.dex */
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
        this.mAttentionListener = new CustomMessageListener(this, 2001115) { // from class: com.baidu.tbadk.core.util.ReplyPrivacyCheckController.6
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
                if ((interceptable2 != null && interceptable2.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof UpdateAttentionMessage)) {
                    return;
                }
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.UpdateAttentionData data = updateAttentionMessage.getData();
                if (this.this$0.mLikeData != null && !StringUtils.isNull(this.this$0.mLikeData.uid) && data != null && this.this$0.mLikeData.uid.equals(data.toUid)) {
                    boolean z = false;
                    if (updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag().equals(this.this$0.mId)) {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast.makeText(this.this$0.mContext.getPageActivity(), updateAttentionMessage.getErrorString()).setIcon(BdToast.ToastIcon.FAILURE).setDuration(3000).show();
                        } else {
                            AntiHelper.s(this.this$0.mContext.getPageActivity(), data.blockData);
                        }
                    }
                    if (data.isSucc) {
                        this.this$0.mLikeData.likeStatus = data.status;
                        this.this$0.mLikeData.isAttention = data.isAttention;
                    }
                    if (z && this.this$0.mAttentionCallback != null) {
                        this.this$0.mAttentionCallback.sendAfterAttention(data.isSucc, this.this$0.replyType);
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        BdUniqueId gen = BdUniqueId.gen();
        this.mId = gen;
        this.mAttentionListener.setTag(gen);
        MessageManager.getInstance().registerListener(this.mAttentionListener);
        Activity pageActivity = tbPageContext.getPageActivity();
        if (pageActivity instanceof LifecycleOwner) {
            ((LifecycleOwner) pageActivity).getLifecycle().addObserver(new LifecycleObserver(this) { // from class: com.baidu.tbadk.core.util.ReplyPrivacyCheckController.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ReplyPrivacyCheckController this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i3 = newInitContext2.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                private void onDestroy() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(65537, this) == null) {
                        MessageManager.getInstance().unRegisterListener(this.this$0.mAttentionListener);
                    }
                }
            });
        }
    }

    public void showAttentionDialog(x35 x35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, x35Var) == null) {
            if (x35Var != null && !StringUtils.isNull(x35Var.a) && !StringUtils.isNull(x35Var.b) && !StringUtils.isNull(x35Var.c)) {
                y45 y45Var = new y45(this.mContext.getPageActivity());
                y45Var.setMessage(x35Var.a);
                y45Var.setPositiveButton(x35Var.c, new y45.e(this) { // from class: com.baidu.tbadk.core.util.ReplyPrivacyCheckController.4
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

                    @Override // com.baidu.tieba.y45.e
                    public void onClick(y45 y45Var2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeL(1048576, this, y45Var2) != null) {
                            return;
                        }
                        this.this$0.followHost();
                        y45Var2.dismiss();
                    }
                });
                y45Var.setNegativeButton(x35Var.b, new y45.e(this) { // from class: com.baidu.tbadk.core.util.ReplyPrivacyCheckController.5
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

                    @Override // com.baidu.tieba.y45.e
                    public void onClick(y45 y45Var2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, y45Var2) == null) {
                            y45Var2.dismiss();
                        }
                    }
                });
                y45Var.setAutoNight(true);
                y45Var.create(this.mContext);
                y45Var.show();
                return;
            }
            showAttentionDialog();
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
                BdUtilHelper.showToast(this.mContext.getPageActivity(), (int) R.string.message_privacy_fans_can_reply);
                return false;
            } else if (i == PRIVACY_MY_ATTENTION) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
                return false;
            } else if (i == PRIVACY_MYSELF) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
                return false;
            } else if (i != PRIVACY_READ_ONLY) {
                return true;
            } else {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), (int) R.string.privacy_read_only);
                return false;
            }
        }
        return invokeI.booleanValue;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void followHost() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                this.mContext.showToast(R.string.network_ungeilivable);
            } else if (this.mLikeData == null || !ViewHelper.checkUpIsLogin(this.mContext.getPageActivity())) {
            } else {
                if (this.mAttentionModel == null) {
                    this.mAttentionModel = new ve5(this.mContext);
                }
                ve5 ve5Var = this.mAttentionModel;
                AttentionHostData attentionHostData = this.mLikeData;
                ve5Var.i(true, attentionHostData.portrait, attentionHostData.uid, attentionHostData.isGod, "0", this.mId, null, "0");
            }
        }
    }

    private void showAttentionDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            if (this.mDialog == null) {
                y45 y45Var = new y45(this.mContext.getPageActivity());
                this.mDialog = y45Var;
                y45Var.setMessageId(R.string.message_privacy_fans_can_reply);
                this.mDialog.setPositiveButton(R.string.attention_and_reply, new y45.e(this) { // from class: com.baidu.tbadk.core.util.ReplyPrivacyCheckController.2
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

                    @Override // com.baidu.tieba.y45.e
                    public void onClick(y45 y45Var2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeL(1048576, this, y45Var2) != null) {
                            return;
                        }
                        this.this$0.followHost();
                        this.this$0.mDialog.dismiss();
                    }
                });
                this.mDialog.setNegativeButton(R.string.obfuscated_res_0x7f0f03d0, new y45.e(this) { // from class: com.baidu.tbadk.core.util.ReplyPrivacyCheckController.3
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

                    @Override // com.baidu.tieba.y45.e
                    public void onClick(y45 y45Var2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, y45Var2) == null) {
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
                BdUtilHelper.showToast(this.mContext.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
                return false;
            } else if (i == PRIVACY_MYSELF) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
                return false;
            } else if (i == PRIVACY_READ_ONLY) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), (int) R.string.privacy_read_only);
                return false;
            } else {
                return true;
            }
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
                BdUtilHelper.showToast(this.mContext.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
                return false;
            } else if (i == PRIVACY_MYSELF) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), (int) R.string.reason_cannot_reply_thread);
                return false;
            } else if (i != PRIVACY_READ_ONLY) {
                return true;
            } else {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), (int) R.string.privacy_read_only);
                return false;
            }
        }
        return invokeII.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.mId);
            y45 y45Var = this.mDialog;
            if (y45Var != null) {
                y45Var.dismiss();
            }
            ve5 ve5Var = this.mAttentionModel;
            if (ve5Var != null) {
                ve5Var.e();
            }
        }
    }
}
