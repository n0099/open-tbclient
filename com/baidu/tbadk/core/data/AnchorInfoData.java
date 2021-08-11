package com.baidu.tbadk.core.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AnchorInfo;
/* loaded from: classes6.dex */
public class AnchorInfoData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public long authorId;
    public String authorName;
    public long group_id;
    public String intro;
    public int isVip;
    public String labelName;
    public int likers;
    public int listeners;
    public String name;
    public String portrait;
    public String publisherPortrait;
    public int startTime;
    public int status;

    public AnchorInfoData() {
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
        this.portrait = "";
        this.name = "";
        this.startTime = 0;
        this.status = 0;
        this.authorId = 0L;
        this.authorName = "";
        this.listeners = 0;
        this.likers = 0;
        this.group_id = 0L;
        this.intro = "";
        this.publisherPortrait = "";
        this.labelName = "";
    }

    public long getAuthorId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.authorId : invokeV.longValue;
    }

    public String getAuthorName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.authorName : (String) invokeV.objValue;
    }

    public long getGroup_id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.group_id : invokeV.longValue;
    }

    public String getIntro() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.intro : (String) invokeV.objValue;
    }

    public int getIsVip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.isVip : invokeV.intValue;
    }

    public String getLabelName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.labelName : (String) invokeV.objValue;
    }

    public int getLikers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.likers : invokeV.intValue;
    }

    public int getListeners() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.listeners : invokeV.intValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.name : (String) invokeV.objValue;
    }

    public String getPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.portrait : (String) invokeV.objValue;
    }

    public String getPublisherPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.publisherPortrait : (String) invokeV.objValue;
    }

    public int getStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.startTime : invokeV.intValue;
    }

    public int getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.status : invokeV.intValue;
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.portrait = jSONObject.getString("portrait");
            this.name = jSONObject.getString("name");
            this.startTime = jSONObject.getInt(SmartLaunchStats.UBC_BUSINESS_START_TIME_KEY);
            this.status = jSONObject.getInt("status");
            this.authorId = jSONObject.getLong("author_id");
            this.authorName = jSONObject.getString("author_name");
            this.listeners = jSONObject.getInt("listeners");
            this.likers = jSONObject.getInt("likers");
            this.group_id = jSONObject.optLong("group_id", 0L);
            this.intro = jSONObject.getString("intro");
            this.publisherPortrait = jSONObject.getString("publisherPortrait");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void parserProtobuf(AnchorInfo anchorInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, anchorInfo) == null) || anchorInfo == null) {
            return;
        }
        this.authorId = anchorInfo.author_id.longValue();
        this.authorName = anchorInfo.author_name;
        this.group_id = anchorInfo.group_id.longValue();
        this.intro = anchorInfo.intro;
        this.likers = anchorInfo.likers.intValue();
        this.listeners = anchorInfo.listeners.intValue();
        this.name = anchorInfo.name;
        this.portrait = anchorInfo.portrait;
        this.publisherPortrait = anchorInfo.publisherPortrait;
        this.startTime = anchorInfo.start_time.intValue();
        this.status = anchorInfo.status.intValue();
        this.labelName = anchorInfo.label_name;
        this.isVip = anchorInfo.is_vip.intValue();
    }

    public void setAuthorId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j2) == null) {
            this.authorId = j2;
        }
    }

    public void setAuthorName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.authorName = str;
        }
    }

    public void setGroup_id(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048593, this, j2) == null) {
            this.group_id = j2;
        }
    }

    public void setIntro(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.intro = str;
        }
    }

    public void setIsVip(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.isVip = i2;
        }
    }

    public void setLabelName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.labelName = str;
        }
    }

    public void setLikers(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.likers = i2;
        }
    }

    public void setListeners(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.listeners = i2;
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.name = str;
        }
    }

    public void setPortrait(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.portrait = str;
        }
    }

    public void setPublisherPortrait(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.publisherPortrait = str;
        }
    }

    public void setStartTime(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.startTime = i2;
        }
    }

    public void setStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.status = i2;
        }
    }
}
