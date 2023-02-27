package com.baidu.tbadk;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.RegisterIntentConfigHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.tieba.nd9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class KuangFloatingViewController {
    public static /* synthetic */ Interceptable $ic = null;
    public static String STORY_PACKAGE = "com.baidu.tieba.story";
    public static String WRITE_PACKAGE = "com.baidu.tieba.write";
    public static KuangFloatingViewController instance;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener mBackGroundSwitchListener;
    public View mFloatingView;
    public String mInfo;
    public WindowManager wm;
    public CustomMessageListener writeListener;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-360242393, "Lcom/baidu/tbadk/KuangFloatingViewController;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-360242393, "Lcom/baidu/tbadk/KuangFloatingViewController;");
        }
    }

    public KuangFloatingViewController() {
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
        this.mBackGroundSwitchListener = new CustomMessageListener(this, 2001011) { // from class: com.baidu.tbadk.KuangFloatingViewController.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KuangFloatingViewController this$0;

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
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null && data.booleanValue()) {
                    this.this$0.hideFloatingView();
                }
            }
        };
        this.writeListener = new CustomMessageListener(this, 2002001) { // from class: com.baidu.tbadk.KuangFloatingViewController.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KuangFloatingViewController this$0;

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
                Class<?> intentClass;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 != null && interceptable2.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof IntentConfig) || (intentClass = RegisterIntentConfigHelper.getInst().getIntentClass(((IntentConfig) customResponsedMessage.getData()).getClass())) == null) {
                    return;
                }
                if (intentClass.getName().contains(KuangFloatingViewController.WRITE_PACKAGE) || intentClass.getName().contains(KuangFloatingViewController.STORY_PACKAGE)) {
                    this.this$0.hideFloatingView();
                }
            }
        };
    }

    public static KuangFloatingViewController getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (instance == null) {
                instance = new KuangFloatingViewController();
            }
            return instance;
        }
        return (KuangFloatingViewController) invokeV.objValue;
    }

    public void hideFloatingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.wm == null) {
                this.wm = (WindowManager) TbadkCoreApplication.getInst().getSystemService("window");
            }
            View view2 = this.mFloatingView;
            if (view2 != null && view2.getParent() != null) {
                try {
                    if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(TbadkCoreApplication.getInst().getContext())) {
                        this.wm = null;
                        this.mFloatingView = null;
                        return;
                    }
                    this.wm.removeView(this.mFloatingView);
                } catch (SecurityException unused) {
                    this.wm = null;
                    this.mFloatingView = null;
                }
            }
        }
    }

    public boolean init() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            View view2 = this.mFloatingView;
            if (view2 == null) {
                View inflate = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.floating_view_from_kuang, (ViewGroup) null);
                this.mFloatingView = inflate;
                inflate.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.tbadk.KuangFloatingViewController.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ KuangFloatingViewController this$0;

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
                            this.this$0.hideFloatingView();
                            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                            if (currentActivity != null) {
                                currentActivity.moveTaskToBack(true);
                            }
                            TiebaStatic.log(new StatisticItem("c12264").param("obj_source", 1));
                            Intent launchIntentForPackage = TbadkCoreApplication.getInst().getPackageManager().getLaunchIntentForPackage("com.baidu.searchbox");
                            if (launchIntentForPackage != null) {
                                launchIntentForPackage.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                                TbadkCoreApplication.getInst().startActivity(launchIntentForPackage);
                                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FLOATING_VIEW_CLICK_KEY).param("obj_type", 1));
                            }
                        }
                    }
                });
                this.mFloatingView.findViewById(R.id.floating_view_close).setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.tbadk.KuangFloatingViewController.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ KuangFloatingViewController this$0;

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
                            this.this$0.hideFloatingView();
                        }
                    }
                });
            } else if (view2.getParent() != null) {
                return false;
            }
            ((TextView) this.mFloatingView.findViewById(R.id.obfuscated_res_0x7f091056)).setText(this.mInfo);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void setInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.mInfo = str;
        }
    }

    public void showFloatingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.type = nd9.a(2002);
            layoutParams.flags = 65800;
            layoutParams.format = -3;
            layoutParams.x = 0;
            layoutParams.y = ej.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07028b) + UtilHelper.getStatusBarHeight();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.gravity = 51;
            if (this.wm == null) {
                this.wm = (WindowManager) TbadkCoreApplication.getInst().getSystemService("window");
            }
            try {
                if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(TbadkCoreApplication.getInst().getContext())) {
                    this.wm = null;
                    this.mFloatingView = null;
                } else if (init()) {
                    if (this.mFloatingView != null && this.mFloatingView.getParent() == null) {
                        this.wm.addView(this.mFloatingView, layoutParams);
                    }
                    MessageManager.getInstance().registerListener(this.mBackGroundSwitchListener);
                    MessageManager.getInstance().registerListener(this.writeListener);
                }
            } catch (SecurityException unused) {
                this.wm = null;
                this.mFloatingView = null;
            }
        }
    }
}
