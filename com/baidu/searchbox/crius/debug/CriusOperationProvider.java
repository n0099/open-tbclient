package com.baidu.searchbox.crius.debug;

import android.content.ComponentName;
import android.content.Intent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.crius.util.CriusAbTestManager;
import com.baidu.searchbox.debug.annotation.DebugInfoProvider;
import com.baidu.searchbox.debug.data.CheckItemInfo;
import com.baidu.searchbox.debug.data.DebugDataGroupProvider;
import com.baidu.searchbox.debug.data.DebugItemInfo;
import com.baidu.searchbox.debug.data.TextItemInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
@DebugInfoProvider(enable = false, type = "Debug_Fetures")
/* loaded from: classes2.dex */
public class CriusOperationProvider extends DebugDataGroupProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener benchmarkListener;
    public View.OnClickListener criusBaseListener;
    public View.OnClickListener criusFlattenListener;
    public CompoundButton.OnCheckedChangeListener mCriusVisitedListener;

    public CriusOperationProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.criusBaseListener = new View.OnClickListener(this) { // from class: com.baidu.searchbox.crius.debug.CriusOperationProvider.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CriusOperationProvider this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
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

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(AppRuntime.getAppContext(), DebugCriusActivity.class));
                    ActivityUtils.startActivitySafely(AppRuntime.getAppContext(), intent);
                }
            }
        };
        this.criusFlattenListener = new View.OnClickListener(this) { // from class: com.baidu.searchbox.crius.debug.CriusOperationProvider.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CriusOperationProvider this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
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

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(AppRuntime.getAppContext(), DebugCriusFlattenActivity.class));
                    ActivityUtils.startActivitySafely(AppRuntime.getAppContext(), intent);
                }
            }
        };
        this.benchmarkListener = new View.OnClickListener(this) { // from class: com.baidu.searchbox.crius.debug.CriusOperationProvider.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CriusOperationProvider this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
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

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(AppRuntime.getAppContext(), DebugCriusBenchmarkActivity.class));
                    ActivityUtils.startActivitySafely(AppRuntime.getAppContext(), intent);
                }
            }
        };
        this.mCriusVisitedListener = new CompoundButton.OnCheckedChangeListener(this) { // from class: com.baidu.searchbox.crius.debug.CriusOperationProvider.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CriusOperationProvider this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
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

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, compoundButton, z) == null) {
                    CriusAbTestManager.updateVisitedState(z);
                    if (z) {
                        Toast.makeText(AppRuntime.getAppContext(), "切到已读态", 0).show();
                    } else {
                        Toast.makeText(AppRuntime.getAppContext(), "是否已读，根据调用方决定", 0).show();
                    }
                }
            }
        };
    }

    private List<DebugItemInfo> getGCommunityOperationInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new TextItemInfo("", "sample-base", this.criusBaseListener));
            arrayList.add(new TextItemInfo("", "sample-扁平化", this.criusFlattenListener));
            arrayList.add(new TextItemInfo("", "benchmark", this.benchmarkListener));
            arrayList.add(new CheckItemInfo("灵动强制已读态", this.mCriusVisitedListener, Boolean.valueOf(CriusAbTestManager.isVisited())));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "灵动" : (String) invokeV.objValue;
    }
}
