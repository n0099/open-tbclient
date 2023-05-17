package com.baidu.tbadk.core.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.ThemeCardInUser;
/* loaded from: classes4.dex */
public class ThemeCardInUserData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public long cardId;
    public String cardImageUrlAndroid;
    public String cardImageUrlIos;
    public String coordinate;
    public String dynamicUrl;
    public String exclusiveNo;
    public int freeLevel;
    public String jumpUrl;

    public ThemeCardInUserData() {
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

    public long getCardId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.cardId;
        }
        return invokeV.longValue;
    }

    public String getCardImageUrlAndroid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.cardImageUrlAndroid;
        }
        return (String) invokeV.objValue;
    }

    public String getCardImageUrlIos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.cardImageUrlIos;
        }
        return (String) invokeV.objValue;
    }

    public String getCoordinate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.coordinate;
        }
        return (String) invokeV.objValue;
    }

    public String getDynamicUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.dynamicUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getExclusiveNo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.exclusiveNo;
        }
        return (String) invokeV.objValue;
    }

    public int getFreeLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.freeLevel;
        }
        return invokeV.intValue;
    }

    public String getJumpUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.jumpUrl;
        }
        return (String) invokeV.objValue;
    }

    public void parser(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.cardId = jSONObject.optLong("props_id");
        this.cardImageUrlAndroid = jSONObject.optString("img_android");
        this.cardImageUrlIos = jSONObject.optString("img_ios");
        this.freeLevel = jSONObject.optInt("level", 0);
        this.coordinate = jSONObject.optString("coordinate");
        this.dynamicUrl = jSONObject.optString("dynamic_url");
        this.exclusiveNo = jSONObject.optString("exclusive_no");
        this.jumpUrl = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
    }

    public void parser(ThemeCardInUser themeCardInUser) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, themeCardInUser) != null) || themeCardInUser == null) {
            return;
        }
        this.cardId = themeCardInUser.props_id.longValue();
        this.cardImageUrlAndroid = themeCardInUser.img_android;
        this.cardImageUrlIos = themeCardInUser.img_ios;
        this.freeLevel = themeCardInUser.level.intValue();
        this.coordinate = themeCardInUser.coordinate;
        this.dynamicUrl = themeCardInUser.dynamic_url;
        this.exclusiveNo = themeCardInUser.exclusive_no;
        this.jumpUrl = themeCardInUser.jump_url;
    }

    public void setCardId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            this.cardId = j;
        }
    }

    public void setCardImageUrlAndroid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.cardImageUrlAndroid = str;
        }
    }

    public void setCardImageUrlIos(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.cardImageUrlIos = str;
        }
    }

    public void setCoordinate(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.coordinate = str;
        }
    }

    public void setDynamicUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.dynamicUrl = str;
        }
    }

    public void setExclusiveNo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.exclusiveNo = str;
        }
    }

    public void setFreeLevel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.freeLevel = i;
        }
    }

    public void setJumpUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.jumpUrl = str;
        }
    }
}
