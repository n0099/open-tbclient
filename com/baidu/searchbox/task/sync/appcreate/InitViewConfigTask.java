package com.baidu.searchbox.task.sync.appcreate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.dimen.TbDimenManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.j95;
import com.repackage.ln4;
import com.repackage.mi;
import com.repackage.xr8;
import com.repackage.y35;
/* loaded from: classes2.dex */
public class InitViewConfigTask extends LaunchTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public InitViewConfigTask() {
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

    private void initCustomToastView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (TbadkCoreApplication.getInst().mToast == null && mi.u() == null) {
                TbadkCoreApplication.getInst().mToast = new mi.c(this) { // from class: com.baidu.searchbox.task.sync.appcreate.InitViewConfigTask.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ InitViewConfigTask this$0;

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

                    @Override // com.repackage.mi.c
                    public void createToastView() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            TbadkCoreApplication.getInst().mCustomToastView = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.obfuscated_res_0x7f0d020f, (ViewGroup) null);
                        }
                    }

                    @Override // com.repackage.mi.c
                    public View getToastContentView() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TbadkCoreApplication.getInst().mCustomToastView : (View) invokeV.objValue;
                    }

                    @Override // com.repackage.mi.c
                    public void setToastString(String str) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (getToastContentView() instanceof TextView)) {
                            ((TextView) getToastContentView()).setText(str);
                        }
                    }
                };
                mi.H(TbadkCoreApplication.getInst().mToast);
                j95.b().H(System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ViewHelper.initSkinDataOnStartup(AppRuntime.getAppContext());
            ln4.c().f();
            TbConfig.initBigImageWidth(TbadkCoreApplication.getInst());
            TbConfig.initBigImageMaxUsedMemory(TbadkCoreApplication.getInst().getContext());
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                y35.k().q(TbConfig.getMaxPhotoMemoryCache(), TbConfig.getBigImageMaxUsedMemory());
            } else {
                y35.k().q(TbConfig.getMaxPhotoMemoryCacheForRemoteProcess(), TbConfig.getBigImageMaxUsedMemoryForRemoteProcess());
            }
            TbConfig.initFriendPhotoConfig(TbadkCoreApplication.getInst());
            TbadkCoreApplication.getInst().setFontSize(TbadkSettings.getInst().loadInt("font_size", 2));
            TbDimenManager.getInstance().init(AppRuntime.getApplication());
            xr8.c();
            initCustomToastView();
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "AppCreate_InitViewConfig" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }
}
