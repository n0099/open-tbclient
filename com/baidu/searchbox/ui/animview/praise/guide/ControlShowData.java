package com.baidu.searchbox.ui.animview.praise.guide;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ControlShowData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int cycleMaxcount;
    public int cycleTime;
    public int dayMaxCount;
    public boolean open;
    public int sessionMaxCount;

    public ControlShowData() {
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
        this.open = true;
        this.sessionMaxCount = 1;
        this.dayMaxCount = 2;
        this.cycleMaxcount = 6;
        this.cycleTime = 60;
    }

    public int getCycleMaxcount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.cycleMaxcount : invokeV.intValue;
    }

    public int getCycleTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.cycleTime : invokeV.intValue;
    }

    public int getDayMaxCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.dayMaxCount : invokeV.intValue;
    }

    public int getSessionMaxCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.sessionMaxCount : invokeV.intValue;
    }

    public boolean isOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.open : invokeV.booleanValue;
    }

    public void parseData(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            setOpen(jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH, 1) == 1);
            setSessionMaxCount(jSONObject.optInt("session_max_count", 1));
            setDayMaxCount(jSONObject.optInt("day_max_count", 2));
            setCycleMaxcount(jSONObject.optInt("cycle_max_count", 6));
            setCycleTime(jSONObject.optInt("cycle_time", 60));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void setCycleMaxcount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.cycleMaxcount = i2;
        }
    }

    public void setCycleTime(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.cycleTime = i2;
        }
    }

    public void setDayMaxCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.dayMaxCount = i2;
        }
    }

    public void setOpen(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.open = z;
        }
    }

    public void setSessionMaxCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.sessionMaxCount = i2;
        }
    }

    public String toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(SetImageWatermarkTypeReqMsg.SWITCH, this.open ? "1" : "0");
                jSONObject.put("session_max_count", this.sessionMaxCount);
                jSONObject.put("day_max_count", this.dayMaxCount);
                jSONObject.put("cycle_max_count", this.cycleMaxcount);
                jSONObject.put("cycle_time", this.cycleTime);
                return jSONObject.toString();
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }
}
