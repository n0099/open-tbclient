package com.baidu.searchbox.fluency.view;

import android.os.Build;
import android.provider.Settings;
import android.widget.CompoundButton;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.debug.annotation.DebugInfoProvider;
import com.baidu.searchbox.debug.data.CheckItemInfo;
import com.baidu.searchbox.debug.data.DebugDataGroupProvider;
import com.baidu.searchbox.debug.data.DebugItemInfo;
import com.baidu.searchbox.fluency.utils.FpsSpUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
@DebugInfoProvider(enable = false, type = "Debug_Fetures")
/* loaded from: classes9.dex */
public class FpsOperationProvider extends DebugDataGroupProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CompoundButton.OnCheckedChangeListener mSwitchDebugListener;

    public FpsOperationProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSwitchDebugListener = new CompoundButton.OnCheckedChangeListener(this) { // from class: com.baidu.searchbox.fluency.view.FpsOperationProvider.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FpsOperationProvider this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, compoundButton, z) == null) {
                    if (!this.this$0.canDrawOverLays()) {
                        UniversalToast.makeText(AppRuntime.getAppContext(), "请开启浮窗权限！").setDuration(2).showToast();
                        return;
                    }
                    FpsSpUtil.putFpsFloatSwitch(z);
                    UniversalToast.makeText(AppRuntime.getAppContext(), "开关已切换，重启生效!").setDuration(2).showToast();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canDrawOverLays() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return Settings.canDrawOverlays(AppRuntime.getAppContext());
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    private List<DebugItemInfo> getGCommunityOperationInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new CheckItemInfo("显示FPS浮窗", this.mSwitchDebugListener, Boolean.FALSE));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.debug.data.DebugDataGroupProvider
    public List<DebugItemInfo> getChildItemList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? getGCommunityOperationInfo() : (List) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.debug.data.DebugDataGroupProvider
    public String getGroupName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "帧率(FPS)监控" : (String) invokeV.objValue;
    }
}
