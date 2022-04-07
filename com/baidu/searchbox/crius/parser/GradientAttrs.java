package com.baidu.searchbox.crius.parser;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.crius.util.ColorUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u000e\u0018\u0000 \u001b:\u0001\u001bB\u0007¢\u0006\u0004\b\u0019\u0010\u001aR(\u0010\u0003\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R(\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0002\u001a\u0004\u0018\u00010\u00078\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR(\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0002\u001a\u0004\u0018\u00010\u00078\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR(\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u000e8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R(\u0010\u0013\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R(\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\u0010\u0002\u001a\u0004\u0018\u00010\u00078\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u000bR(\u0010\u0017\u001a\u0004\u0018\u00010\u00072\b\u0010\u0002\u001a\u0004\u0018\u00010\u00078\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0018\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/crius/parser/GradientAttrs;", "", "<set-?>", "dayColors", "[I", "getDayColors", "()[I", "", "endX", "Ljava/lang/Float;", "getEndX", "()Ljava/lang/Float;", "endY", "getEndY", "", NativeConstants.LOCATIONS, "[F", "getLocations", "()[F", "nightColors", "getNightColors", "startX", "getStartX", "startY", "getStartY", "<init>", "()V", "Companion", "lib-crius_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class GradientAttrs {
    public static /* synthetic */ Interceptable $ic;
    public static final Companion Companion;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] dayColors;
    public Float endX;
    public Float endY;
    public float[] locations;
    public int[] nightColors;
    public Float startX;
    public Float startY;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/crius/parser/GradientAttrs$Companion;", "Lorg/json/JSONObject;", "json", "Lcom/baidu/searchbox/crius/parser/GradientAttrs;", "parseGradient", "(Lorg/json/JSONObject;)Lcom/baidu/searchbox/crius/parser/GradientAttrs;", "<init>", "()V", "lib-crius_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Companion() {
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

        public final GradientAttrs parseGradient(JSONObject json) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, json)) == null) {
                Intrinsics.checkNotNullParameter(json, "json");
                GradientAttrs gradientAttrs = new GradientAttrs();
                JSONObject optJSONObject = json.optJSONObject(NativeConstants.COLOR_SET);
                if (optJSONObject != null) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("default");
                    if (optJSONArray != null) {
                        gradientAttrs.dayColors = new int[optJSONArray.length()];
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            int[] dayColors = gradientAttrs.getDayColors();
                            Intrinsics.checkNotNull(dayColors);
                            dayColors[i] = ColorUtils.parseColor((String) optJSONArray.get(i));
                        }
                    }
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("dark");
                    if (optJSONArray2 != null) {
                        gradientAttrs.nightColors = new int[optJSONArray2.length()];
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            int[] nightColors = gradientAttrs.getNightColors();
                            Intrinsics.checkNotNull(nightColors);
                            nightColors[i2] = ColorUtils.parseColor(optJSONArray2.optString(i2));
                        }
                    }
                }
                JSONArray optJSONArray3 = json.optJSONArray(NativeConstants.LOCATIONS);
                if (optJSONArray3 != null) {
                    gradientAttrs.locations = new float[optJSONArray3.length()];
                    int length3 = optJSONArray3.length();
                    for (int i3 = 0; i3 < length3; i3++) {
                        float[] locations = gradientAttrs.getLocations();
                        Intrinsics.checkNotNull(locations);
                        locations[i3] = (float) optJSONArray3.optDouble(i3, 0.0d);
                    }
                }
                JSONObject optJSONObject2 = json.optJSONObject("start");
                gradientAttrs.startX = optJSONObject2 != null ? Float.valueOf((float) optJSONObject2.optDouble("x", 0.0d)) : null;
                JSONObject optJSONObject3 = json.optJSONObject("start");
                gradientAttrs.startY = optJSONObject3 != null ? Float.valueOf((float) optJSONObject3.optDouble("y", 0.0d)) : null;
                JSONObject optJSONObject4 = json.optJSONObject("end");
                gradientAttrs.endX = optJSONObject4 != null ? Float.valueOf((float) optJSONObject4.optDouble("x", 0.0d)) : null;
                JSONObject optJSONObject5 = json.optJSONObject("end");
                gradientAttrs.endY = optJSONObject5 != null ? Float.valueOf((float) optJSONObject5.optDouble("y", 0.0d)) : null;
                return gradientAttrs;
            }
            return (GradientAttrs) invokeL.objValue;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1787279144, "Lcom/baidu/searchbox/crius/parser/GradientAttrs;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1787279144, "Lcom/baidu/searchbox/crius/parser/GradientAttrs;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    public GradientAttrs() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final int[] getDayColors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.dayColors : (int[]) invokeV.objValue;
    }

    public final Float getEndX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.endX : (Float) invokeV.objValue;
    }

    public final Float getEndY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.endY : (Float) invokeV.objValue;
    }

    public final float[] getLocations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.locations : (float[]) invokeV.objValue;
    }

    public final int[] getNightColors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.nightColors : (int[]) invokeV.objValue;
    }

    public final Float getStartX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.startX : (Float) invokeV.objValue;
    }

    public final Float getStartY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.startY : (Float) invokeV.objValue;
    }
}
