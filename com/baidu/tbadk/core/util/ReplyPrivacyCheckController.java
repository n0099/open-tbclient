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
import com.repackage.ar4;
import com.repackage.oi;
import com.repackage.pz4;
import com.repackage.qi;
import com.repackage.ur4;
/* loaded from: classes3.dex */
public class ReplyPrivacyCheckController {
    public static /* synthetic */ Interceptable $ic = null;
    public static int PRIVACY_MYSELF = 4;
    public static int PRIVACY_MY_ATTENTION = 3;
    public static int PRIVACY_MY_FANS = 2;
    public static int PRIVACY_READ_ONLY = 5;
    public static int TYPE_EMOTION_IMAGE = 2;
    public static int TYPE_FLOOR = 1;
    public static int TYPE_THREAD;
    public transient /* synthetic */ FieldHolder $fh;
    public IAfterAttentionCallBack mAttentionCallback;
    public CustomMessageListener mAttentionListener;
    public pz4 mAttentionModel;
    public TbPageContext mContext;
    public ur4 mDialog;
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
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                    if (this.this$0.mLikeData == null || StringUtils.isNull(this.this$0.mLikeData.uid) || data == null || !this.this$0.mLikeData.uid.equals(data.c)) {
                        return;
                    }
                    boolean z = false;
                    if (updateAttentionMessage.getOrginalMessage() != null && updateAttentionMessage.getOrginalMessage().getTag().equals(this.this$0.mId)) {
                        z = true;
                        if (updateAttentionMessage.getError() == 3250013) {
                            BdToast b = BdToast.b(this.this$0.mContext.getPageActivity(), updateAttentionMessage.getErrorString());
                            b.f(BdToast.ToastIcon.FAILURE);
                            b.c(3000);
                            b.i();
                        } else {
                            AntiHelper.s(this.this$0.mContext.getPageActivity(), data.l);
                        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void followHost() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            if (!oi.A()) {
                this.mContext.showToast(R.string.obfuscated_res_0x7f0f0c3f);
            } else if (this.mLikeData != null && ViewHelper.checkUpIsLogin(this.mContext.getPageActivity())) {
                if (this.mAttentionModel == null) {
                    this.mAttentionModel = new pz4(this.mContext);
                }
                pz4 pz4Var = this.mAttentionModel;
                AttentionHostData attentionHostData = this.mLikeData;
                pz4Var.l(true, attentionHostData.portrait, attentionHostData.uid, attentionHostData.isGod, "0", this.mId, null, "0");
            }
        }
    }

    private void showAttentionDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            if (this.mDialog == null) {
                ur4 ur4Var = new ur4(this.mContext.getPageActivity());
                this.mDialog = ur4Var;
                ur4Var.setMessageId(R.string.obfuscated_res_0x7f0f0acc);
                this.mDialog.setPositiveButton(R.string.obfuscated_res_0x7f0f02ae, new ur4.e(this) { // from class: com.baidu.tbadk.core.util.ReplyPrivacyCheckController.2
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

                    @Override // com.repackage.ur4.e
                    public void onClick(ur4 ur4Var2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, ur4Var2) == null) {
                            this.this$0.followHost();
                            this.this$0.mDialog.dismiss();
                        }
                    }
                });
                this.mDialog.setNegativeButton(R.string.obfuscated_res_0x7f0f0370, new ur4.e(this) { // from class: com.baidu.tbadk.core.util.ReplyPrivacyCheckController.3
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

                    @Override // com.repackage.ur4.e
                    public void onClick(ur4 ur4Var2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, ur4Var2) == null) {
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
                qi.M(this.mContext.getPageActivity(), R.string.obfuscated_res_0x7f0f0f81);
                return false;
            } else if (i == PRIVACY_MYSELF) {
                qi.M(this.mContext.getPageActivity(), R.string.obfuscated_res_0x7f0f0f81);
                return false;
            } else if (i == PRIVACY_READ_ONLY) {
                qi.M(this.mContext.getPageActivity(), R.string.obfuscated_res_0x7f0f0f02);
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
                qi.M(this.mContext.getPageActivity(), R.string.obfuscated_res_0x7f0f0f81);
                return false;
            } else if (i == PRIVACY_MYSELF) {
                qi.M(this.mContext.getPageActivity(), R.string.obfuscated_res_0x7f0f0f81);
                return false;
            } else if (i == PRIVACY_READ_ONLY) {
                qi.M(this.mContext.getPageActivity(), R.string.obfuscated_res_0x7f0f0f02);
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
            ur4 ur4Var = this.mDialog;
            if (ur4Var != null) {
                ur4Var.dismiss();
            }
            pz4 pz4Var = this.mAttentionModel;
            if (pz4Var != null) {
                pz4Var.g();
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
                qi.M(this.mContext.getPageActivity(), R.string.obfuscated_res_0x7f0f0acc);
                return false;
            } else if (i == PRIVACY_MY_ATTENTION) {
                qi.M(this.mContext.getPageActivity(), R.string.obfuscated_res_0x7f0f0f81);
                return false;
            } else if (i == PRIVACY_MYSELF) {
                qi.M(this.mContext.getPageActivity(), R.string.obfuscated_res_0x7f0f0f81);
                return false;
            } else if (i == PRIVACY_READ_ONLY) {
                qi.M(this.mContext.getPageActivity(), R.string.obfuscated_res_0x7f0f0f02);
                return false;
            } else {
                return true;
            }
        }
        return invokeI.booleanValue;
    }

    public void showAttentionDialog(ar4 ar4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ar4Var) == null) {
            if (ar4Var != null && !StringUtils.isNull(ar4Var.a) && !StringUtils.isNull(ar4Var.b) && !StringUtils.isNull(ar4Var.c)) {
                ur4 ur4Var = new ur4(this.mContext.getPageActivity());
                ur4Var.setMessage(ar4Var.a);
                ur4Var.setPositiveButton(ar4Var.c, new ur4.e(this) { // from class: com.baidu.tbadk.core.util.ReplyPrivacyCheckController.4
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

                    @Override // com.repackage.ur4.e
                    public void onClick(ur4 ur4Var2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, ur4Var2) == null) {
                            this.this$0.followHost();
                            ur4Var2.dismiss();
                        }
                    }
                });
                ur4Var.setNegativeButton(ar4Var.b, new ur4.e(this) { // from class: com.baidu.tbadk.core.util.ReplyPrivacyCheckController.5
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

                    @Override // com.repackage.ur4.e
                    public void onClick(ur4 ur4Var2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, ur4Var2) == null) {
                            ur4Var2.dismiss();
                        }
                    }
                });
                ur4Var.setAutoNight(true);
                ur4Var.create(this.mContext);
                ur4Var.show();
                return;
            }
            showAttentionDialog();
        }
    }
}
