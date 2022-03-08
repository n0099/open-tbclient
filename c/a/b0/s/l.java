package c.a.b0.s;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.ParseError;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.facebook.common.util.UriUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1309061175, "Lc/a/b0/s/l$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1309061175, "Lc/a/b0/s/l$a;");
                    return;
                }
            }
            int[] iArr = new int[AdBaseModel.STYLE.values().length];
            a = iArr;
            try {
                iArr[AdBaseModel.STYLE.SMALL_IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AdBaseModel.STYLE.BIG_IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AdBaseModel.STYLE.PORTRAIT_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[AdBaseModel.STYLE.VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[AdBaseModel.STYLE.THREE_IMAGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[AdBaseModel.STYLE.FLOAT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[AdBaseModel.STYLE.MAX.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[AdBaseModel.STYLE.REWARD_VIDEO_LP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[AdBaseModel.STYLE.REWARD_VIDEO_LP_IMPL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    @NonNull
    public static List<AdBaseModel> a(JSONObject jSONObject, @NonNull String[] strArr) throws ParseError {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, jSONObject, strArr)) == null) {
            if (jSONObject != null) {
                String optString = jSONObject.optString("locCode");
                if (!TextUtils.isEmpty(optString)) {
                    int length = strArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            str = "";
                            break;
                        }
                        str = strArr[i2];
                        if (!TextUtils.isEmpty(str) && optString.startsWith(str)) {
                            break;
                        }
                        i2++;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
                        if (optJSONArray != null && optJSONArray.length() != 0) {
                            ArrayList arrayList = new ArrayList();
                            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                try {
                                    AdBaseModel b2 = b(str, optJSONArray.optJSONObject(i3));
                                    if (b2.f35658c == null) {
                                        c.a.b0.x.a.b(arrayList, b2);
                                    }
                                } catch (ParseError e2) {
                                    f(e2, 0, null);
                                }
                            }
                            return arrayList;
                        }
                        throw ParseError.parseError(34, "", str);
                    }
                    throw ParseError.parseError(46, "", optString + "#" + TextUtils.join("#", strArr));
                }
                throw ParseError.parseError(33, "");
            }
            throw ParseError.parseError(32, "");
        }
        return (List) invokeLL.objValue;
    }

    @NonNull
    public static AdBaseModel b(String str, JSONObject jSONObject) throws ParseError {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, jSONObject)) == null) {
            if (jSONObject != null) {
                boolean z = jSONObject.optInt("advisible", 1) == 0;
                String str2 = null;
                if (z && jSONObject.has("ext_info")) {
                    str2 = jSONObject.optString("ext_info", null);
                }
                if (str2 == null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("extra");
                    if (optJSONArray != null && optJSONArray.length() != 0) {
                        int length = optJSONArray.length();
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                break;
                            }
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                            if (optJSONObject != null) {
                                String optString = optJSONObject.optString("k");
                                String optString2 = optJSONObject.optString("v");
                                if (!TextUtils.isEmpty(optString2) && TextUtils.equals("extraParam", optString)) {
                                    str2 = optString2;
                                    break;
                                }
                            }
                            i2++;
                        }
                    } else {
                        throw ParseError.parseError(36, "", str);
                    }
                }
                if (str2 != null) {
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("material");
                    if (optJSONArray2 != null && optJSONArray2.length() != 0) {
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(0);
                        if (optJSONObject2 != null) {
                            try {
                                JSONArray jSONArray = new JSONArray(optJSONObject2.optString("info"));
                                if (jSONArray.length() != 0) {
                                    JSONObject optJSONObject3 = jSONArray.optJSONObject(0);
                                    if (optJSONObject3 != null) {
                                        int optInt = jSONObject.optInt("floor");
                                        AdBaseModel d2 = d(str, optInt, optJSONObject3, str2);
                                        if (d2 == null) {
                                            if (z) {
                                                return new AdBaseModel(i.a(str, optInt, new JSONObject(), new JSONObject(), str2), new JSONObject());
                                            }
                                            throw ParseError.contentError(24, "", str2);
                                        }
                                        d2.o = optJSONObject2.optInt("imTimeSign", -1);
                                        ParseError parseError = d2.f35658c;
                                        if (parseError != null) {
                                            f(parseError, jSONObject.optInt("floor"), d2.f35661f.f1923d);
                                            return d2;
                                        }
                                        return d2;
                                    }
                                    throw ParseError.parseError(41, str2, str);
                                }
                                throw ParseError.parseError(40, str2, str);
                            } catch (JSONException unused) {
                                throw ParseError.parseError(40, str2, str);
                            }
                        }
                        throw ParseError.parseError(39, str2, str);
                    }
                    throw ParseError.parseError(38, str2, str);
                }
                throw ParseError.parseError(37, "", str);
            }
            throw ParseError.parseError(35, "", str);
        }
        return (AdBaseModel) invokeLL.objValue;
    }

    @NonNull
    public static AdBaseModel[] c(String str, String[] strArr) throws ParseError {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, strArr)) == null) {
            if (!TextUtils.isEmpty(str)) {
                JSONObject optJSONObject = c.a.b0.x.b.b(str).optJSONObject(UriUtil.LOCAL_RESOURCE_SCHEME);
                if (optJSONObject != null) {
                    if (optJSONObject.optInt("status", 0) == 0) {
                        JSONArray optJSONArray = optJSONObject.optJSONArray("ad");
                        if (optJSONArray != null) {
                            int length = optJSONArray.length();
                            ArrayList arrayList = new ArrayList();
                            for (int i2 = 0; i2 < length; i2++) {
                                try {
                                    c.a.b0.x.a.c(arrayList, a(optJSONArray.optJSONObject(i2), strArr));
                                } catch (ParseError e2) {
                                    f(e2, 0, null);
                                }
                            }
                            return (AdBaseModel[]) arrayList.toArray(new AdBaseModel[0]);
                        }
                        throw ParseError.parseError(44, "");
                    }
                    throw ParseError.parseError(42, "");
                }
                throw ParseError.parseError(31, "");
            }
            throw ParseError.parseError(29, "");
        }
        return (AdBaseModel[]) invokeLL.objValue;
    }

    @Nullable
    public static AdBaseModel d(@NonNull String str, int i2, @NonNull JSONObject jSONObject, @NonNull String str2) throws ParseError {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65539, null, str, i2, jSONObject, str2)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("ad_common");
            if (optJSONObject == null) {
                return null;
            }
            i a2 = i.a(str, i2, jSONObject, optJSONObject, str2);
            switch (a.a[a2.a.ordinal()]) {
                case 1:
                case 2:
                    return new c.a.b0.s.a(a2, jSONObject);
                case 3:
                    return new j(a2, jSONObject);
                case 4:
                    return new q(a2, jSONObject);
                case 5:
                    return new n(a2, jSONObject);
                case 6:
                case 7:
                case 8:
                    return new AdBaseModel(a2, jSONObject);
                case 9:
                    return new m(a2, jSONObject);
                default:
                    throw ParseError.contentError(23, a2.a.value);
            }
        }
        return (AdBaseModel) invokeLILL.objValue;
    }

    public static void e(int i2, int i3, String str, String str2, int i4, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, str2, Integer.valueOf(i4), str3}) == null) {
        }
    }

    public static void f(ParseError parseError, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65541, null, parseError, i2, str) == null) {
            if (TextUtils.isEmpty(str)) {
                str = parseError.mExtraParam;
            }
            String str2 = parseError.mPid;
            e(parseError.mType, parseError.mReason, parseError.mTplName, str2, i2, str);
        }
    }
}
