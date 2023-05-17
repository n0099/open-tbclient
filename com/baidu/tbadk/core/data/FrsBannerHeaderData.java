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
import tbclient.FrsPage.FrsBannerHeader;
import tbclient.IconUrlInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes4.dex */
public class FrsBannerHeaderData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -4453004151548171098L;
    public transient /* synthetic */ FieldHolder $fh;
    public ThemeColorInfo backgroundColor;
    public IconUrlInfo brandIcon;
    public String content1;
    public ThemeColorInfo content1Color;
    public String content2;
    public ThemeColorInfo content2Color;
    public String iconUrl;
    public String jumpLink;
    public String jumpTips;
    public ThemeColorInfo jumpTipsColor;
    public IconUrlInfo jumpTipsIcon;
    public String type;

    public FrsBannerHeaderData() {
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

    public ThemeColorInfo getBackgroundColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.backgroundColor;
        }
        return (ThemeColorInfo) invokeV.objValue;
    }

    public IconUrlInfo getBrandIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.brandIcon;
        }
        return (IconUrlInfo) invokeV.objValue;
    }

    public String getContent1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.content1;
        }
        return (String) invokeV.objValue;
    }

    public ThemeColorInfo getContent1Color() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.content1Color;
        }
        return (ThemeColorInfo) invokeV.objValue;
    }

    public String getContent2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.content2;
        }
        return (String) invokeV.objValue;
    }

    public ThemeColorInfo getContent2Color() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.content2Color;
        }
        return (ThemeColorInfo) invokeV.objValue;
    }

    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.iconUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getJumpLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.jumpLink;
        }
        return (String) invokeV.objValue;
    }

    public String getJumpTips() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.jumpTips;
        }
        return (String) invokeV.objValue;
    }

    public ThemeColorInfo getJumpTipsColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.jumpTipsColor;
        }
        return (ThemeColorInfo) invokeV.objValue;
    }

    public IconUrlInfo getJumpTipsIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.jumpTipsIcon;
        }
        return (IconUrlInfo) invokeV.objValue;
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.type;
        }
        return (String) invokeV.objValue;
    }

    public void parseData(FrsBannerHeader frsBannerHeader) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, frsBannerHeader) != null) || frsBannerHeader == null) {
            return;
        }
        setIconUrl(frsBannerHeader.icon_url);
        setContent1(frsBannerHeader.content1);
        setContent2(frsBannerHeader.content2);
        setContent1Color(frsBannerHeader.content1_color);
        setContent2Color(frsBannerHeader.content2_color);
        setJumpTipsColor(frsBannerHeader.jump_tips_color);
        setBackgroundColor(frsBannerHeader.background_color);
        setBrandIcon(frsBannerHeader.brand_icon);
        setJumpTipsIcon(frsBannerHeader.jump_tips_icon);
        setJumpTips(frsBannerHeader.jump_tips);
        setJumpLink(frsBannerHeader.jump_link);
        setType(frsBannerHeader.type);
    }

    public void setBackgroundColor(ThemeColorInfo themeColorInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, themeColorInfo) == null) {
            this.backgroundColor = themeColorInfo;
        }
    }

    public void setBrandIcon(IconUrlInfo iconUrlInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, iconUrlInfo) == null) {
            this.brandIcon = iconUrlInfo;
        }
    }

    public void setContent1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.content1 = str;
        }
    }

    public void setContent1Color(ThemeColorInfo themeColorInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, themeColorInfo) == null) {
            this.content1Color = themeColorInfo;
        }
    }

    public void setContent2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.content2 = str;
        }
    }

    public void setContent2Color(ThemeColorInfo themeColorInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, themeColorInfo) == null) {
            this.content2Color = themeColorInfo;
        }
    }

    public void setIconUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.iconUrl = str;
        }
    }

    public void setJumpLink(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.jumpLink = str;
        }
    }

    public void setJumpTips(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.jumpTips = str;
        }
    }

    public void setJumpTipsColor(ThemeColorInfo themeColorInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, themeColorInfo) == null) {
            this.jumpTipsColor = themeColorInfo;
        }
    }

    public void setJumpTipsIcon(IconUrlInfo iconUrlInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, iconUrlInfo) == null) {
            this.jumpTipsIcon = iconUrlInfo;
        }
    }

    public void setType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.type = str;
        }
    }
}
