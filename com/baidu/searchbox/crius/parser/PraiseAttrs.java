package com.baidu.searchbox.crius.parser;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u001e\u0018\u0000B\u0007¢\u0006\u0004\b.\u0010/R$\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u0010\u0010\u0005\"\u0004\b\u0011\u0010\u0007R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000eR$\u0010\u001c\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u001d\u0010\u0005\"\u0004\b\u001e\u0010\u0007R$\u0010\u001f\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0003\u001a\u0004\b \u0010\u0005\"\u0004\b!\u0010\u0007R$\u0010\"\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0003\u001a\u0004\b#\u0010\u0005\"\u0004\b$\u0010\u0007R$\u0010%\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0003\u001a\u0004\b&\u0010\u0005\"\u0004\b'\u0010\u0007R$\u0010(\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\n\u001a\u0004\b)\u0010\f\"\u0004\b*\u0010\u000eR$\u0010+\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\n\u001a\u0004\b,\u0010\f\"\u0004\b-\u0010\u000e¨\u00060"}, d2 = {"Lcom/baidu/searchbox/crius/parser/PraiseAttrs;", "", "countText", "Ljava/lang/String;", "getCountText", "()Ljava/lang/String;", "setCountText", "(Ljava/lang/String;)V", "", "iconType", "Ljava/lang/Integer;", "getIconType", "()Ljava/lang/Integer;", "setIconType", "(Ljava/lang/Integer;)V", "id", "getId", "setId", "", "longPressEnable", "Ljava/lang/Boolean;", "getLongPressEnable", "()Ljava/lang/Boolean;", "setLongPressEnable", "(Ljava/lang/Boolean;)V", "praiseStatus", "getPraiseStatus", "setPraiseStatus", "textColorNormal", "getTextColorNormal", "setTextColorNormal", "textColorNormalNight", "getTextColorNormalNight", "setTextColorNormalNight", "textColorPraised", "getTextColorPraised", "setTextColorPraised", "textColorPraisedNight", "getTextColorPraisedNight", "setTextColorPraisedNight", "textLeftMargin", "getTextLeftMargin", "setTextLeftMargin", "textSize", "getTextSize", "setTextSize", "<init>", "()V", "lib-crius_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class PraiseAttrs {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String countText;
    public Integer iconType;
    public String id;
    public Boolean longPressEnable;
    public Integer praiseStatus;
    public String textColorNormal;
    public String textColorNormalNight;
    public String textColorPraised;
    public String textColorPraisedNight;
    public Integer textLeftMargin;
    public Integer textSize;

    public PraiseAttrs() {
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
        this.id = "";
        this.iconType = 0;
        this.longPressEnable = Boolean.FALSE;
    }

    public final String getCountText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.countText;
        }
        return (String) invokeV.objValue;
    }

    public final Integer getIconType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.iconType;
        }
        return (Integer) invokeV.objValue;
    }

    public final String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.id;
        }
        return (String) invokeV.objValue;
    }

    public final Boolean getLongPressEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.longPressEnable;
        }
        return (Boolean) invokeV.objValue;
    }

    public final Integer getPraiseStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.praiseStatus;
        }
        return (Integer) invokeV.objValue;
    }

    public final String getTextColorNormal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.textColorNormal;
        }
        return (String) invokeV.objValue;
    }

    public final String getTextColorNormalNight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.textColorNormalNight;
        }
        return (String) invokeV.objValue;
    }

    public final String getTextColorPraised() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.textColorPraised;
        }
        return (String) invokeV.objValue;
    }

    public final String getTextColorPraisedNight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.textColorPraisedNight;
        }
        return (String) invokeV.objValue;
    }

    public final Integer getTextLeftMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.textLeftMargin;
        }
        return (Integer) invokeV.objValue;
    }

    public final Integer getTextSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.textSize;
        }
        return (Integer) invokeV.objValue;
    }

    public final void setCountText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.countText = str;
        }
    }

    public final void setIconType(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, num) == null) {
            this.iconType = num;
        }
    }

    public final void setId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.id = str;
        }
    }

    public final void setLongPressEnable(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bool) == null) {
            this.longPressEnable = bool;
        }
    }

    public final void setPraiseStatus(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, num) == null) {
            this.praiseStatus = num;
        }
    }

    public final void setTextColorNormal(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.textColorNormal = str;
        }
    }

    public final void setTextColorNormalNight(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.textColorNormalNight = str;
        }
    }

    public final void setTextColorPraised(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.textColorPraised = str;
        }
    }

    public final void setTextColorPraisedNight(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.textColorPraisedNight = str;
        }
    }

    public final void setTextLeftMargin(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, num) == null) {
            this.textLeftMargin = num;
        }
    }

    public final void setTextSize(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, num) == null) {
            this.textSize = num;
        }
    }
}
