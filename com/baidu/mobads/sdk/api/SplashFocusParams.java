package com.baidu.mobads.sdk.api;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.br;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SplashFocusParams {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Builder mBuilder;

    /* loaded from: classes3.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int animOffsetPx;
        public boolean autoAnimOffset;
        public double darkAlpha;
        public int iconBottomMarginDp;
        public int iconRightMarginDp;
        public int iconSizeDp;

        public Builder() {
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
            this.iconRightMarginDp = 15;
            this.iconBottomMarginDp = 95;
            this.iconSizeDp = 44;
            this.autoAnimOffset = true;
            this.animOffsetPx = 0;
            this.darkAlpha = 0.0d;
        }

        @Deprecated
        public Builder setAnimOffsetPx(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                this.autoAnimOffset = false;
                this.animOffsetPx = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setDarkAlpha(double d) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d)})) == null) {
                this.darkAlpha = d;
                return this;
            }
            return (Builder) invokeCommon.objValue;
        }

        public Builder setIconBottomMarginDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                this.iconBottomMarginDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setIconRightMarginDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                this.iconRightMarginDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setIconSizeDp(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                this.iconSizeDp = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public SplashFocusParams build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new SplashFocusParams(this);
            }
            return (SplashFocusParams) invokeV.objValue;
        }
    }

    public SplashFocusParams(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBuilder = builder;
    }

    public JSONObject getFocusParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("right_margin", this.mBuilder.iconRightMarginDp);
                jSONObject.put("bottom_margin", this.mBuilder.iconBottomMarginDp);
                jSONObject.put("icon_size", this.mBuilder.iconSizeDp);
                if (!this.mBuilder.autoAnimOffset) {
                    jSONObject.put("anim_offset_y", this.mBuilder.animOffsetPx);
                }
                jSONObject.put("icon_dark_alpha", this.mBuilder.darkAlpha);
            } catch (JSONException e) {
                br.a().a(e);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
