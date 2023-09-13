package com.baidu.tbadk.core.view.headViewPendant;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.kg;
import com.baidu.tieba.sa5;
import com.baidu.tieba.ta5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class LightInteractiveManager {
    public static /* synthetic */ Interceptable $ic;
    public static boolean isShowing;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2131815855, "Lcom/baidu/tbadk/core/view/headViewPendant/LightInteractiveManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2131815855, "Lcom/baidu/tbadk/core/view/headViewPendant/LightInteractiveManager;");
        }
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WeakReference a;
        public final /* synthetic */ WeakReference b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, WeakReference weakReference, WeakReference weakReference2, int i2, int i3) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), weakReference, weakReference2, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = weakReference;
            this.b = weakReference2;
            this.c = i2;
            this.d = i3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && this.a.get() != null) {
                if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                    ((Window) this.a.get()).getDecorView().setSystemUiVisibility(1280);
                } else {
                    ((Window) this.a.get()).getDecorView().setSystemUiVisibility(9472);
                }
                if (this.b.get() != null) {
                    ((LightInteractiveLayout) this.b.get()).setListBackground(this.c, this.d);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CustomMessageListener a;
        public final /* synthetic */ WeakReference b;

        public b(CustomMessageListener customMessageListener, WeakReference weakReference) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {customMessageListener, weakReference};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = customMessageListener;
            this.b = weakReference;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_QINGHUDONG_EMOTION);
                MessageManager.getInstance().unRegisterListener(this.a);
                if (this.b.get() != null) {
                    ((LightInteractiveLayout) this.b.get()).E();
                }
                boolean unused = LightInteractiveManager.isShowing = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ta5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Dialog a;

        public c(Dialog dialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dialog;
        }

        @Override // com.baidu.tieba.ta5
        public void onClose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements DialogInterface.OnShowListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
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

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                boolean unused = LightInteractiveManager.isShowing = true;
            }
        }
    }

    public LightInteractiveManager() {
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

    public static void show(Context context, int i, int i2, MetaData metaData, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65539, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), metaData, Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) != null) || isShowing) {
            return;
        }
        if ((context instanceof Application) && (context = TbadkCoreApplication.getInst().getCurrentActivity()) == null) {
            return;
        }
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_QINGHUDONG_EMOTION, TbConfig.SERVER_ADDRESS + "c/c/agree/agreeVirtualImage"));
        Dialog dialog = new Dialog(context, R.style.obfuscated_res_0x7f1003d8);
        dialog.setCancelable(true);
        WeakReference weakReference = new WeakReference(dialog.getWindow());
        if (weakReference.get() != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                ((Window) weakReference.get()).getDecorView().setSystemUiVisibility(1280);
            } else {
                ((Window) weakReference.get()).getDecorView().setSystemUiVisibility(9472);
            }
            ((Window) weakReference.get()).addFlags(Integer.MIN_VALUE);
            ((Window) weakReference.get()).addFlags(512);
            ((Window) weakReference.get()).setType(1000);
            ((Window) weakReference.get()).setStatusBarColor(0);
            ((Window) weakReference.get()).setDimAmount(0.0f);
            WindowManager.LayoutParams attributes = ((Window) weakReference.get()).getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            ((Window) weakReference.get()).setNavigationBarColor(0);
            ((Window) weakReference.get()).setAttributes(attributes);
        }
        WeakReference weakReference2 = new WeakReference(new LightInteractiveLayout(context));
        if (weakReference2.get() != null) {
            ((LightInteractiveLayout) weakReference2.get()).setUserInfo(metaData);
            ((LightInteractiveLayout) weakReference2.get()).setType(i3);
            ((LightInteractiveLayout) weakReference2.get()).setFrom(i4);
            ((LightInteractiveLayout) weakReference2.get()).setNeedHomeIcon(z);
            ((LightInteractiveLayout) weakReference2.get()).setLocation(i, i2);
            dialog.setContentView((View) weakReference2.get());
        }
        GreyUtil.grey(dialog);
        a aVar = new a(2001304, weakReference, weakReference2, i, i2);
        dialog.setOnDismissListener(new b(aVar, weakReference2));
        if (weakReference2.get() != null) {
            ((LightInteractiveLayout) weakReference2.get()).setOnDismissListener(new c(dialog));
        }
        dialog.setOnShowListener(new d());
        if ((context instanceof Activity) && kg.e((Activity) context)) {
            dialog.show();
        }
        if (metaData != null) {
            sa5.b(i4, metaData.getUserId());
        }
        MessageManager.getInstance().registerListener(aVar);
    }
}
