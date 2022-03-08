package com.baidu.searchbox.player.ubc;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.ubc.BDVideoPlayerUbcContent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PlayerUbcFlowStatisticsManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float currentSpeed;
    public final HashMap<String, IUbcFlow> mFlowFetchers;
    public boolean mIsShowFirstFrame;
    public long mStartLoadingTime;
    public BDVideoPlayerUbcContent mUbcContent;

    public PlayerUbcFlowStatisticsManager() {
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
        this.mFlowFetchers = new HashMap<>();
        this.mUbcContent = new BDVideoPlayerUbcContent.Builder().buildEmpty();
        this.currentSpeed = 1.0f;
    }

    private void upSpeedDurationFlow() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || this.currentSpeed == 1.0f) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("value", this.currentSpeed);
            getFlow(IUbcFlow.TYPE_SPEED_DURATION_FLOW).uploadFlow(this.mUbcContent, null, jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void addFlow(IUbcFlow iUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iUbcFlow) == null) {
            this.mFlowFetchers.put(iUbcFlow.getFlowType(), iUbcFlow);
        }
    }

    @NonNull
    public IUbcFlow getFlow(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            IUbcFlow iUbcFlow = this.mFlowFetchers.get(str);
            return iUbcFlow == null ? new PlayerEmptyFlow() : iUbcFlow;
        }
        return (IUbcFlow) invokeL.objValue;
    }

    public void goBackOrForeground(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (z) {
                if (this.currentSpeed != 1.0f) {
                    getFlow(IUbcFlow.TYPE_SPEED_DURATION_FLOW).createFlow();
                    return;
                }
                return;
            }
            upSpeedDurationFlow();
        }
    }

    public void onInfo(int i2, int i3, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, obj) == null) {
            if (i2 == 904 || i2 == 956) {
                this.mIsShowFirstFrame = true;
                if (this.currentSpeed != 1.0f) {
                    getFlow(IUbcFlow.TYPE_SPEED_DURATION_FLOW).createFlow();
                }
            }
        }
    }

    public void onPlayerEnd(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.mIsShowFirstFrame = false;
            upSpeedDurationFlow();
        }
    }

    public void onPlayerPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public void onPlayerResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public void onPlayerStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.mIsShowFirstFrame = false;
        }
    }

    public void onPlayerStop(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.mIsShowFirstFrame = false;
            upSpeedDurationFlow();
        }
    }

    public void removeFlow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.mFlowFetchers.clear();
        }
    }

    public void setVideoPlayerUbcContent(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bDVideoPlayerUbcContent) == null) {
            this.mUbcContent = bDVideoPlayerUbcContent;
        }
    }

    public void switchPlayerSpeed(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048587, this, f2) == null) {
            upSpeedDurationFlow();
            if (f2 != 1.0f) {
                getFlow(IUbcFlow.TYPE_SPEED_DURATION_FLOW).createFlow();
            }
            this.currentSpeed = f2;
        }
    }
}
