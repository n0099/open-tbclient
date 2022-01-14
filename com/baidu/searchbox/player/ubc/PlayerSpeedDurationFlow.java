package com.baidu.searchbox.player.ubc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class PlayerSpeedDurationFlow implements IUbcFlow {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Flow mFlow;
    public final UBCManager mUBCService;

    public PlayerSpeedDurationFlow() {
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
        this.mUBCService = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    public void cancelFlow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    public void createFlow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mFlow = this.mUBCService.beginFlow(VideoPlayerUbcConstants.UBC_VIDEO_PLAY_SPEED_DURATION);
        }
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    public void endSlot(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    @Nullable
    public Flow getFlow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mFlow : (Flow) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    public String getFlowType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? IUbcFlow.TYPE_SPEED_DURATION_FLOW : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    public void resetFlow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    public void startSlot(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, jSONObject) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.ubc.IUbcFlow
    public void uploadFlow(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, @Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, bDVideoPlayerUbcContent, jSONObject, jSONObject2) == null) {
            try {
                String ubcContent = BDVideoPlayerUbcHelper.getUbcContent(bDVideoPlayerUbcContent, jSONObject2);
                if (this.mFlow != null) {
                    this.mUBCService.flowSetValue(this.mFlow, ubcContent);
                    this.mUBCService.flowEnd(this.mFlow);
                    this.mFlow = null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
