package com.baidu.spswitch.utils;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.spswitch.IPanelHeightTarget;
import com.baidu.spswitch.emotion.EmotionType;
import com.baidu.spswitch.emotion.resource.EmotionAPSManager;
import com.baidu.spswitch.utils.BDEmotionPanelManager;
import com.baidu.spswitch.utils.SPSwitchConflictUtil;
import com.baidu.spswitch.utils.SoftInputUtil;
import com.baidu.spswitch.view.SPSwitchPanelLinearLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes2.dex */
public class Emotion {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Emotion() {
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

    public static void init(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65537, null, z) == null) {
            SPConfig.init(z);
            loadEmotionResIfNeed();
        }
    }

    public static void initEmotionPanel(Activity activity, View view2, View view3, ViewGroup viewGroup, boolean z, boolean z2, SoftInputUtil.OnSoftInputShowingListener onSoftInputShowingListener, SPSwitchConflictUtil.SwitchClickListener switchClickListener, BDEmotionPanelManager.OnEmotionClickListener onEmotionClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{activity, view2, view3, viewGroup, Boolean.valueOf(z), Boolean.valueOf(z2), onSoftInputShowingListener, switchClickListener, onEmotionClickListener}) == null) {
            SPConfig.init(z);
            if (onSoftInputShowingListener == null) {
                onSoftInputShowingListener = new SoftInputUtil.OnSoftInputShowingListener() { // from class: com.baidu.spswitch.utils.Emotion.2
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

                    @Override // com.baidu.spswitch.utils.SoftInputUtil.OnSoftInputShowingListener
                    public void onSoftInputShowing(boolean z3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z3) == null) {
                        }
                    }
                };
            }
            if (switchClickListener == null) {
                switchClickListener = new SPSwitchConflictUtil.SwitchClickListener() { // from class: com.baidu.spswitch.utils.Emotion.3
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

                    @Override // com.baidu.spswitch.utils.SPSwitchConflictUtil.SwitchClickListener
                    public void onClickSwitch(View view4, boolean z3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, view4, z3) == null) {
                        }
                    }
                };
            }
            if (onEmotionClickListener == null) {
                onEmotionClickListener = new BDEmotionPanelManager.OnEmotionClickListener() { // from class: com.baidu.spswitch.utils.Emotion.4
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

                    @Override // com.baidu.spswitch.utils.BDEmotionPanelManager.OnEmotionClickListener
                    public void onEmotionClick(EmotionType emotionType, int i, String str, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLILL(1048576, this, emotionType, i, str, str2) == null) {
                        }
                    }
                };
            }
            SoftInputUtil.attach(activity, (ViewGroup) activity.findViewById(16908290), (IPanelHeightTarget) viewGroup, onSoftInputShowingListener);
            SPSwitchConflictUtil.attach(activity.getWindow(), viewGroup, view2, view3, switchClickListener);
            BDEmotionPanelManager.getInstance().loadInnerEmotionPanel(activity, viewGroup, view3, z2);
            BDEmotionPanelManager.getInstance().setOnEmotionClickListener(onEmotionClickListener);
        }
    }

    public static void loadEmotionResIfNeed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            ExecutorUtilsExt.postOnSerial(new Runnable() { // from class: com.baidu.spswitch.utils.Emotion.1
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

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        File[] restoreFileList = EmotionAPSManager.getRestoreFileList();
                        if (restoreFileList == null || restoreFileList.length <= 0) {
                            EmotionAPSManager.getInstance().presetDoAPSProcess();
                        } else if (EmotionAPSManager.getInstance().isLoaded()) {
                        } else {
                            EmotionAPSManager.getInstance().loadResourcesIfNeeded();
                        }
                    }
                }
            }, "loadEmotionResIfNeed");
        }
    }

    public static SPSwitchPanelLinearLayout setEmotionPanelAndInit(ViewGroup viewGroup, Activity activity, View view2, View view3, boolean z, boolean z2, SoftInputUtil.OnSoftInputShowingListener onSoftInputShowingListener, SPSwitchConflictUtil.SwitchClickListener switchClickListener, BDEmotionPanelManager.OnEmotionClickListener onEmotionClickListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{viewGroup, activity, view2, view3, Boolean.valueOf(z), Boolean.valueOf(z2), onSoftInputShowingListener, switchClickListener, onEmotionClickListener})) == null) {
            SPSwitchPanelLinearLayout sPSwitchPanelLinearLayout = (SPSwitchPanelLinearLayout) ((ViewGroup) LayoutInflater.from(AppRuntime.getAppContext()).inflate(R.layout.obfuscated_res_0x7f0d0258, viewGroup, true)).findViewById(R.id.obfuscated_res_0x7f0916b8);
            initEmotionPanel(activity, view2, view3, sPSwitchPanelLinearLayout, z, z2, onSoftInputShowingListener, switchClickListener, onEmotionClickListener);
            return sPSwitchPanelLinearLayout;
        }
        return (SPSwitchPanelLinearLayout) invokeCommon.objValue;
    }
}
