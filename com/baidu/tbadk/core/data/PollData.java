package com.baidu.tbadk.core.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.db.ResultTB;
import d.a.p0.s.q.p;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.PollInfo;
import tbclient.PollOption;
/* loaded from: classes3.dex */
public class PollData extends p implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int endTime;
    public int isMulti;
    public int isPolled;
    public int lastTime;
    public List<PollOptionData> options;
    public int optionsCount;
    public String polledValue;
    public String title;
    public long totalNum;
    public long totalPoll;

    public PollData() {
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
        this.options = new ArrayList();
    }

    public int getEndTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.endTime : invokeV.intValue;
    }

    public int getIsMulti() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.isMulti : invokeV.intValue;
    }

    public int getIsPolled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.isPolled : invokeV.intValue;
    }

    public int getLastTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.lastTime : invokeV.intValue;
    }

    public List<PollOptionData> getOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.options : (List) invokeV.objValue;
    }

    public int getOptionsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.optionsCount : invokeV.intValue;
    }

    public String getPolledValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.polledValue : (String) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.title : (String) invokeV.objValue;
    }

    public long getTotalNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.totalNum : invokeV.longValue;
    }

    public long getTotalPoll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.totalPoll : invokeV.longValue;
    }

    @Override // d.a.p0.s.q.p
    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.isMulti = jSONObject.optInt("is_multi", 0);
            this.totalPoll = jSONObject.optLong("total_num", 0L);
            this.optionsCount = jSONObject.optInt("options_count", 0);
            this.isPolled = jSONObject.optInt("is_polled", 0);
            this.polledValue = jSONObject.optString("polled_value", "");
            this.endTime = jSONObject.optInt(ResultTB.ENDTIME, 0);
            this.totalPoll = jSONObject.optLong("total_poll", 0L);
            this.title = jSONObject.optString("title", "");
            this.lastTime = jSONObject.optInt("last_time", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("options");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    PollOptionData pollOptionData = new PollOptionData();
                    pollOptionData.parserJson(optJSONArray.optJSONObject(i2));
                    this.options.add(pollOptionData);
                }
            }
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void parserProtobuf(PollInfo pollInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, pollInfo) == null) || pollInfo == null) {
            return;
        }
        this.isMulti = pollInfo.is_multi.intValue();
        this.totalNum = pollInfo.total_num.longValue();
        this.optionsCount = pollInfo.options_count.intValue();
        this.isPolled = pollInfo.is_polled.intValue();
        this.polledValue = pollInfo.polled_value;
        this.endTime = pollInfo.end_time.intValue();
        this.totalPoll = pollInfo.total_poll.longValue();
        this.title = pollInfo.title;
        this.lastTime = pollInfo.last_time.intValue();
        List<PollOption> list = pollInfo.options;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                PollOptionData pollOptionData = new PollOptionData();
                pollOptionData.parserProtobuf(pollInfo.options.get(i2));
                this.options.add(pollOptionData);
            }
        }
    }

    public void setEndTime(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.endTime = i2;
        }
    }

    public void setIsMulti(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.isMulti = i2;
        }
    }

    public void setIsPolled(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.isPolled = i2;
        }
    }

    public void setLastTime(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.lastTime = i2;
        }
    }

    public void setOptions(List<PollOptionData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, list) == null) {
            this.options = list;
        }
    }

    public void setOptionsCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.optionsCount = i2;
        }
    }

    public void setPolledValue(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.polledValue = str;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.title = str;
        }
    }

    public void setTotalNum(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j) == null) {
            this.totalNum = j;
        }
    }

    public void setTotalPoll(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048597, this, j) == null) {
            this.totalPoll = j;
        }
    }
}
