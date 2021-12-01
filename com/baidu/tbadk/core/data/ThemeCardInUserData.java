package com.baidu.tbadk.core.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.ThemeCardInUser;
/* loaded from: classes9.dex */
public class ThemeCardInUserData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public long cardId;
    public String cardImageUrlAndroid;
    public String cardImageUrlIos;
    public String coordinate;
    public int freeLevel;

    public ThemeCardInUserData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public long getCardId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.cardId : invokeV.longValue;
    }

    public String getCardImageUrlAndroid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.cardImageUrlAndroid : (String) invokeV.objValue;
    }

    public String getCardImageUrlIos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.cardImageUrlIos : (String) invokeV.objValue;
    }

    public String getCoordinate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.coordinate : (String) invokeV.objValue;
    }

    public int getFreeLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.freeLevel : invokeV.intValue;
    }

    public void parser(ThemeCardInUser themeCardInUser) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, themeCardInUser) == null) || themeCardInUser == null) {
            return;
        }
        this.cardId = themeCardInUser.props_id.longValue();
        this.cardImageUrlAndroid = themeCardInUser.img_android;
        this.cardImageUrlIos = themeCardInUser.img_ios;
        this.freeLevel = themeCardInUser.level.intValue();
        this.coordinate = themeCardInUser.coordinate;
    }

    public void setCardId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            this.cardId = j2;
        }
    }

    public void setCardImageUrlAndroid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.cardImageUrlAndroid = str;
        }
    }

    public void setCardImageUrlIos(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.cardImageUrlIos = str;
        }
    }

    public void setCoordinate(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.coordinate = str;
        }
    }

    public void setFreeLevel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.freeLevel = i2;
        }
    }

    public void parser(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.cardId = jSONObject.optLong("props_id");
        this.cardImageUrlAndroid = jSONObject.optString("img_android");
        this.cardImageUrlIos = jSONObject.optString("img_ios");
        this.freeLevel = jSONObject.optInt("level", 0);
        this.coordinate = jSONObject.optString("coordinate");
    }
}
