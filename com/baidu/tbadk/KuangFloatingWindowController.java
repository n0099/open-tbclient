package com.baidu.tbadk;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.ConfigChangeMessage;
import com.baidu.tbadk.core.message.KeyBoardSwitchMessage;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.f6a;
import com.baidu.tieba.vi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class KuangFloatingWindowController {
    public static /* synthetic */ Interceptable $ic;
    public static boolean currentStatus;
    public static KuangFloatingWindowController instance;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener mConfigChange;
    public CustomMessageListener mDialogListener;
    public View mFloatingView;
    public CustomMessageListener mKeyBoardSwitchListener;
    public WindowManager manager;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2002301508, "Lcom/baidu/tbadk/KuangFloatingWindowController;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2002301508, "Lcom/baidu/tbadk/KuangFloatingWindowController;");
        }
    }

    public KuangFloatingWindowController() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mKeyBoardSwitchListener = new CustomMessageListener(this, 2001013) { // from class: com.baidu.tbadk.KuangFloatingWindowController.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KuangFloatingWindowController this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
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
                Boolean data;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 != null && interceptable2.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof KeyBoardSwitchMessage) || (data = ((KeyBoardSwitchMessage) customResponsedMessage).getData()) == null) {
                    return;
                }
                if (!data.booleanValue()) {
                    this.this$0.hideFloatingView();
                } else if (this.this$0.init()) {
                    this.this$0.showFloatingView();
                }
            }
        };
        this.mDialogListener = new CustomMessageListener(this, 2001014) { // from class: com.baidu.tbadk.KuangFloatingWindowController.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KuangFloatingWindowController this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
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
                Boolean data;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 != null && interceptable2.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof WindowSwitchMessage) || (data = ((WindowSwitchMessage) customResponsedMessage).getData()) == null) {
                    return;
                }
                if (data.booleanValue()) {
                    this.this$0.hideFloatingView();
                } else if (this.this$0.init()) {
                    this.this$0.showFloatingView();
                }
            }
        };
        this.mConfigChange = new CustomMessageListener(this, 2001015) { // from class: com.baidu.tbadk.KuangFloatingWindowController.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KuangFloatingWindowController this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
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
                Boolean data;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ConfigChangeMessage) && (data = ((ConfigChangeMessage) customResponsedMessage).getData()) != null && data.booleanValue()) {
                    this.this$0.hideFloatingView();
                    if (this.this$0.init()) {
                        this.this$0.showFloatingView();
                    }
                }
            }
        };
    }

    public boolean init() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            View view2 = this.mFloatingView;
            if (view2 == null) {
                View inflate = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.floating_window_from_kuang, (ViewGroup) null);
                this.mFloatingView = inflate;
                inflate.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.tbadk.KuangFloatingWindowController.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ KuangFloatingWindowController this$0;

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

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                            TbSingleton.getInstance().isShowBackLabel = false;
                            this.this$0.hideFloatingView();
                            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                            if (currentActivity != null) {
                                currentActivity.moveTaskToBack(true);
                            }
                            Intent launchIntentForPackage = TbadkCoreApplication.getInst().getPackageManager().getLaunchIntentForPackage("com.baidu.searchbox");
                            if (launchIntentForPackage != null) {
                                launchIntentForPackage.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                                TbadkCoreApplication.getInst().startActivity(launchIntentForPackage);
                            }
                        }
                    }
                });
                return true;
            } else if (view2.getParent() != null) {
                return false;
            } else {
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    private int getHeightPx() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity == null) {
                return vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds800);
            }
            WindowManager windowManager = (WindowManager) currentActivity.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int orientation = windowManager.getDefaultDisplay().getOrientation();
            if (orientation != 1 && orientation != 3) {
                return displayMetrics.heightPixels;
            }
            return displayMetrics.widthPixels;
        }
        return invokeV.intValue;
    }

    public void hideFloatingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.manager == null) {
                this.manager = (WindowManager) TbadkCoreApplication.getInst().getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
            }
            View view2 = this.mFloatingView;
            if (view2 != null && view2.getParent() != null) {
                try {
                    if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(TbadkCoreApplication.getInst().getContext())) {
                        this.manager = null;
                        this.mFloatingView = null;
                        return;
                    }
                    this.manager.removeView(this.mFloatingView);
                    currentStatus = false;
                } catch (SecurityException unused) {
                    this.manager = null;
                    this.mFloatingView = null;
                }
            }
        }
    }

    public static KuangFloatingWindowController getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (instance == null) {
                instance = new KuangFloatingWindowController();
            }
            return instance;
        }
        return (KuangFloatingWindowController) invokeV.objValue;
    }

    public void showFloatingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.type = f6a.a(2002);
            layoutParams.flags = 65800;
            layoutParams.format = -3;
            layoutParams.x = 0;
            layoutParams.y = (int) (getHeightPx() * 0.75d);
            layoutParams.width = -2;
            layoutParams.height = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds84);
            layoutParams.gravity = 51;
            if (this.manager == null) {
                this.manager = (WindowManager) TbadkCoreApplication.getInst().getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
            }
            try {
                if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(TbadkCoreApplication.getInst().getContext())) {
                    this.manager = null;
                    this.mFloatingView = null;
                } else if (init()) {
                    if (this.mFloatingView != null && this.mFloatingView.getParent() == null) {
                        this.manager.addView(this.mFloatingView, layoutParams);
                        currentStatus = true;
                    }
                    MessageManager.getInstance().registerListener(this.mKeyBoardSwitchListener);
                    MessageManager.getInstance().registerListener(this.mDialogListener);
                    MessageManager.getInstance().registerListener(this.mConfigChange);
                }
            } catch (SecurityException unused) {
                this.manager = null;
                this.mFloatingView = null;
            }
        }
    }
}
