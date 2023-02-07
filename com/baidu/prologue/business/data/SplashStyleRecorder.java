package com.baidu.prologue.business.data;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.k21;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.FreeSpaceBox;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SplashStyleRecorder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class SplashElements {
        public static final /* synthetic */ SplashElements[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SplashElements LABEL;
        public static final SplashElements LOGO;
        public static final SplashElements SKIP;
        public static final SplashElements VOICE;
        public static final SplashElements WIFI_TIP;
        public transient /* synthetic */ FieldHolder $fh;
        public String name;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1220098641, "Lcom/baidu/prologue/business/data/SplashStyleRecorder$SplashElements;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1220098641, "Lcom/baidu/prologue/business/data/SplashStyleRecorder$SplashElements;");
                    return;
                }
            }
            LOGO = new SplashElements("LOGO", 0, "logo");
            SKIP = new SplashElements("SKIP", 1, FreeSpaceBox.TYPE);
            LABEL = new SplashElements("LABEL", 2, "label");
            VOICE = new SplashElements("VOICE", 3, "voice");
            SplashElements splashElements = new SplashElements("WIFI_TIP", 4, "wifi_tip");
            WIFI_TIP = splashElements;
            $VALUES = new SplashElements[]{LOGO, SKIP, LABEL, VOICE, splashElements};
        }

        public SplashElements(String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            setName(str2);
        }

        public static SplashElements valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                return (SplashElements) Enum.valueOf(SplashElements.class, str);
            }
            return (SplashElements) invokeL.objValue;
        }

        public void setName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.name = str;
            }
        }

        public static SplashElements[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                return (SplashElements[]) $VALUES.clone();
            }
            return (SplashElements[]) invokeV.objValue;
        }

        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.name;
            }
            return (String) invokeV.objValue;
        }
    }

    @Nullable
    public static JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            String string = k21.a().b("splash_sp_name").getString("splash_style", "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            try {
                return new JSONObject(string);
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public static void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, jSONObject) == null) && jSONObject != null) {
            String string = k21.a().b("splash_sp_name").getString("splash_style", "");
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.equals(string, jSONObject2)) {
                k21.a().b("splash_sp_name").j("splash_style", jSONObject2, false);
            }
        }
    }
}
