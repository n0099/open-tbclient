package com.baidu.cyberplayer.sdk;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLDecoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
@Keep
/* loaded from: classes3.dex */
public class MPDParser {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Keep
    /* loaded from: classes3.dex */
    public static class MPDInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mpdAuto;
        public int mpdClarity;
        public String urlStr;

        public MPDInfo() {
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
    }

    public MPDParser() {
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

    @Keep
    public static Uri getDefaultUrlFromMPD(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, uri)) == null) ? !isMPD(uri) ? uri : getDefaultUrlFromMPDURL(uri) : (Uri) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006c, code lost:
        r1 = android.net.Uri.parse(r6.getString("url"));
        r3 = java.lang.Boolean.TRUE;
        com.baidu.cyberplayer.sdk.CyberLog.d("sdk_MPDParser", "mpd parsed uri is => " + r1);
        r9 = r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    @Keep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Uri getDefaultUrlFromMPDURL(Uri uri) {
        InterceptResult invokeL;
        Uri uri2;
        int parseInt;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, uri)) == null) {
            String queryParameter = uri.getQueryParameter("content");
            String queryParameter2 = uri.getQueryParameter("clarity");
            Boolean bool = Boolean.FALSE;
            try {
                String decode = URLDecoder.decode(queryParameter, "UTF-8");
                parseInt = Integer.parseInt(queryParameter2);
                jSONArray = new JSONObject(decode).getJSONObject("video").getJSONArray("adaptation_set");
            } catch (Exception e2) {
                e = e2;
                uri2 = uri;
            }
            if (jSONArray.length() >= 1) {
                int i = 0;
                if (jSONArray.get(0) instanceof JSONObject) {
                    JSONArray jSONArray2 = ((JSONObject) jSONArray.get(0)).getJSONArray("representation_list");
                    new ArrayList();
                    uri2 = uri;
                    while (true) {
                        try {
                            if (i >= jSONArray2.length()) {
                                break;
                            }
                            Object obj = jSONArray2.get(i);
                            if (obj instanceof JSONObject) {
                                JSONObject jSONObject = (JSONObject) obj;
                                if (jSONObject.getInt("rank") == parseInt) {
                                    break;
                                }
                                uri2 = Uri.parse(jSONObject.getString("url"));
                            }
                            i++;
                        } catch (Exception e3) {
                            e = e3;
                            CyberLog.d("sdk_MPDParser", "mpd urlWithMPDURL parse exception " + e.getMessage());
                            if (!bool.booleanValue()) {
                            }
                        }
                    }
                    return !bool.booleanValue() ? uri : uri2;
                }
            }
            return uri;
        }
        return (Uri) invokeL.objValue;
    }

    @Keep
    public static String getDefaultUrlStringFromMPD(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? !isMPD(str) ? str : getDefaultUrlStringFromMPDStr(str) : (String) invokeL.objValue;
    }

    @Keep
    public static String getDefaultUrlStringFromMPDStr(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            try {
                return getDefaultUrlFromMPDURL(Uri.parse(str)).toString();
            } catch (Exception e2) {
                CyberLog.d("sdk_MPDParser", "mpd parse exception " + e2.getMessage());
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    @Keep
    public static MPDInfo getMPDInfoFromMPDStr(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            MPDInfo mPDInfo = new MPDInfo();
            try {
                Uri parse = Uri.parse(str);
                String queryParameter = parse.getQueryParameter("content");
                String queryParameter2 = parse.getQueryParameter("clarity");
                String queryParameter3 = parse.getQueryParameter("auto");
                CyberLog.d("sdk_MPDParser", "mpd autoMode: " + queryParameter3 + " selectedClarity:" + queryParameter2);
                try {
                    mPDInfo.mpdClarity = Integer.parseInt(queryParameter2);
                } catch (Exception e2) {
                    CyberLog.d("sdk_MPDParser", "mpd parse exception " + e2.getMessage());
                }
                try {
                    mPDInfo.mpdAuto = Integer.parseInt(queryParameter3);
                } catch (Exception e3) {
                    CyberLog.d("sdk_MPDParser", "mpd parse exception " + e3.getMessage());
                }
                String decode = URLDecoder.decode(queryParameter, "UTF-8");
                CyberLog.d("sdk_MPDParser", "mpd uri decodedStr is => " + decode);
                mPDInfo.urlStr = decode;
            } catch (Exception e4) {
                CyberLog.d("sdk_MPDParser", "mpd parse exception " + e4.getMessage());
            }
            return mPDInfo;
        }
        return (MPDInfo) invokeL.objValue;
    }

    @Keep
    public static boolean isMPD(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, uri)) == null) {
            if (uri == null) {
                return false;
            }
            return "mpd".equalsIgnoreCase(uri.getScheme());
        }
        return invokeL.booleanValue;
    }

    @Keep
    public static boolean isMPD(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (str == null) {
                return false;
            }
            return str.startsWith("mpd://");
        }
        return invokeL.booleanValue;
    }
}
