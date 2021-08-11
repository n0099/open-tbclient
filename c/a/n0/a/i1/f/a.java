package c.a.n0.a.i1.f;

import android.text.TextUtils;
import c.a.n0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlinx.coroutines.DebugKt;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f6504a;

    /* renamed from: b  reason: collision with root package name */
    public String f6505b;

    /* renamed from: c  reason: collision with root package name */
    public int f6506c;

    /* renamed from: d  reason: collision with root package name */
    public int f6507d;

    /* renamed from: e  reason: collision with root package name */
    public int f6508e;

    /* renamed from: f  reason: collision with root package name */
    public int f6509f;

    /* renamed from: g  reason: collision with root package name */
    public String f6510g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1744806261, "Lc/a/n0/a/i1/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1744806261, "Lc/a/n0/a/i1/f/a;");
                return;
            }
        }
        boolean z = k.f6803a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f6504a = 60000;
        this.f6505b = "aac";
        this.f6506c = 1;
        this.f6507d = 8000;
        this.f6508e = 16000;
        this.f6509f = 1;
    }

    public static a a(JSONObject jSONObject, a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, aVar)) == null) {
            if (jSONObject != null && jSONObject.length() > 0) {
                aVar = new a();
                aVar.f6504a = jSONObject.optInt("duration", 60000);
                String optString = jSONObject.optString("format");
                aVar.f6505b = optString;
                if (TextUtils.isEmpty(optString)) {
                    aVar.f6505b = "aac";
                }
                aVar.f6506c = jSONObject.optInt("numberOfChannels", 1);
                aVar.f6507d = jSONObject.optInt("sampleRate", 8000);
                int optInt = jSONObject.optInt("encodeBitRate");
                aVar.f6508e = optInt;
                if (optInt == 0) {
                    int i2 = aVar.f6507d;
                    if (i2 == 8000) {
                        aVar.f6508e = 16000;
                    } else if (i2 == 16000) {
                        aVar.f6508e = 24000;
                    } else if (i2 == 44100) {
                        aVar.f6508e = 64000;
                    }
                }
                aVar.f6509f = b(jSONObject.optString("audioSource", DebugKt.DEBUG_PROPERTY_VALUE_AUTO));
                aVar.f6510g = jSONObject.optString("cb");
            }
            return aVar;
        }
        return (a) invokeLL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int b(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            switch (str.hashCode()) {
                case -401509030:
                    if (str.equals(BdUploadHandler.MEDIA_SOURCE_VALUE_CAMCORDER)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 108103:
                    if (str.equals("mic")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3005871:
                    if (str.equals(DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1059882026:
                    if (str.equals("voice_recognition")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1611170697:
                    if (str.equals("voice_communication")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0 || c2 == 1) {
                return 1;
            }
            if (c2 != 2) {
                if (c2 != 3) {
                    return c2 != 4 ? -1 : 6;
                }
                return 7;
            }
            return 5;
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0086, code lost:
        r2 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.f6504a;
            if (i2 <= 600000 && i2 >= 0) {
                int i3 = this.f6506c;
                boolean z = true;
                if (i3 != 1 && i3 != 2) {
                    return UnitedSchemeUtility.wrapCallbackParams(202, "error channels");
                }
                if (!TextUtils.equals(this.f6505b, "aac") && !TextUtils.equals(this.f6505b, "pcm")) {
                    return UnitedSchemeUtility.wrapCallbackParams(202, "error format");
                }
                int i4 = this.f6507d;
                if (i4 != 8000 && i4 != 16000 && i4 != 44100) {
                    return UnitedSchemeUtility.wrapCallbackParams(202, "error sampleRate");
                }
                if (!TextUtils.equals(this.f6505b, "pcm")) {
                    if ((r3 = this.f6507d) != 8000) {
                        if (z) {
                            return UnitedSchemeUtility.wrapCallbackParams(202, "error bitRate");
                        }
                    } else if (z) {
                    }
                }
                if (this.f6509f < 0) {
                    return UnitedSchemeUtility.wrapCallbackParams(202, "error audioSource");
                }
                return null;
            }
            return UnitedSchemeUtility.wrapCallbackParams(202, "error duration");
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "recordTime : " + this.f6504a + "; channel : " + this.f6506c + "; audioFormat : " + this.f6505b + "; sampleRate : " + this.f6507d + "; bitRate : " + this.f6508e + "; callbacks : " + this.f6510g;
        }
        return (String) invokeV.objValue;
    }
}
