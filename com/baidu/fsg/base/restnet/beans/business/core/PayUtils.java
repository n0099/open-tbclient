package com.baidu.fsg.base.restnet.beans.business.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.encrypt.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.armor.RimArmor;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.utils.ChannelUtils;
import com.baidu.fsg.base.utils.Crypto;
import com.baidu.fsg.base.utils.Md5Utils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes10.dex */
public final class PayUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String API_SECRET = "";
    public static final String KEY_CARD_NO = "card_no";
    public static final String KEY_CVV2 = "cvv2";
    public static final String KEY_IDENTITY_CODE = "identity_code";
    public static final String KEY_PHONE_NUMBER = "phone_number";
    public static final String KEY_VALID_DATE = "valid_date";
    public static final String PACKAGE_NAME = "rim-package-name";
    public static final String PACKAGE_NAME_INFO = "rim-package-info";
    public static String TAG = "PayUtils";
    public static ArrayList<String> keys;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static class ParamComparator implements Comparator<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ParamComparator() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) ? str.compareTo(str2) : invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1955142724, "Lcom/baidu/fsg/base/restnet/beans/business/core/PayUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1955142724, "Lcom/baidu/fsg/base/restnet/beans/business/core/PayUtils;");
                return;
            }
        }
        ArrayList<String> arrayList = new ArrayList<>();
        keys = arrayList;
        arrayList.add("card_no");
        keys.add("valid_date");
        keys.add("cvv2");
        keys.add("identity_code");
        keys.add("phone_number");
    }

    public PayUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String encrypt(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) ? keys.contains(str) ? !TextUtils.isEmpty(str2) ? RimArmor.getInstance().encryptProxy(str2) : "" : str2 : (String) invokeLL.objValue;
    }

    public static String genAPIsig(List<RestNameValuePair> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (RestNameValuePair restNameValuePair : list) {
                arrayList.add(restNameValuePair.getName() + "=" + restNameValuePair.getValue());
            }
            return getSign(arrayList);
        }
        return (String) invokeL.objValue;
    }

    public static String getAppSignatureSha1(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
                return (packageInfo == null || packageInfo.signatures == null) ? "" : Crypto.sha1(packageInfo.signatures[0].toByteArray());
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return "";
            } catch (Exception e3) {
                e3.printStackTrace();
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String getCookie(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String getNonce(Context context, List<RestNameValuePair> list) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, list)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list);
            Collections.sort(arrayList, new Comparator<RestNameValuePair>() { // from class: com.baidu.fsg.base.restnet.beans.business.core.PayUtils.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                public int compare(RestNameValuePair restNameValuePair, RestNameValuePair restNameValuePair2) {
                    InterceptResult invokeLL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL2 = interceptable2.invokeLL(1048576, this, restNameValuePair, restNameValuePair2)) == null) ? restNameValuePair.getName().compareTo(restNameValuePair2.getName()) : invokeLL2.intValue;
                }
            });
            RestNameValuePair restNameValuePair = new RestNameValuePair();
            restNameValuePair.setName("key");
            String fpk = RimArmor.getInstance().getFpk(context);
            if (TextUtils.isEmpty(fpk)) {
                fpk = context.getPackageName();
            }
            MessageDigest messageDigest = null;
            try {
                str = Crypto.sha1(fpk + ChannelUtils.getHostAppId());
            } catch (Exception e2) {
                e2.printStackTrace();
                str = null;
            }
            restNameValuePair.setValue(str);
            arrayList.add(restNameValuePair);
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e3) {
                e3.printStackTrace();
            }
            if (messageDigest != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    RestNameValuePair restNameValuePair2 = (RestNameValuePair) arrayList.get(i2);
                    String name = restNameValuePair2.getName();
                    String value = restNameValuePair2.getValue();
                    if (!TextUtils.isEmpty(name)) {
                        if (value == null) {
                            value = "";
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append(name);
                        sb.append(a.f31864h);
                        sb.append(value);
                        if (i2 != arrayList.size() - 1) {
                            sb.append(Typography.amp);
                        }
                        if (!TextUtils.isEmpty(sb)) {
                            messageDigest.update(sb.toString().getBytes(Charset.forName("UTF-8")));
                        }
                    }
                }
                byte[] digest = messageDigest.digest();
                StringBuilder sb2 = new StringBuilder();
                for (byte b2 : digest) {
                    sb2.append(Integer.toHexString((b2 & 255) | (-256)).substring(6));
                }
                return RimArmor.getInstance().encrypt(sb2.toString());
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static String getParamsSign(Map<String, String> map, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, map, str)) == null) ? (map == null || map.size() == 0) ? "" : getSign(mapToList(map), str) : (String) invokeLL.objValue;
    }

    public static String getSign(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, list)) == null) {
            Collections.sort(list, new ParamComparator());
            StringBuffer stringBuffer = new StringBuffer();
            for (String str : list) {
                stringBuffer.append(str);
                stringBuffer.append("&");
            }
            stringBuffer.append("key=");
            stringBuffer.append("");
            return URLEncoder.encode(Md5Utils.md5Hex(stringBuffer.toString()));
        }
        return (String) invokeL.objValue;
    }

    public static String getSign(List<String> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, list, str)) == null) {
            Collections.sort(list, new ParamComparator());
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : list) {
                stringBuffer.append(str2);
                stringBuffer.append("&");
            }
            stringBuffer.append("key=");
            stringBuffer.append(str);
            return URLEncoder.encode(Md5Utils.md5Hex(stringBuffer.toString()));
        }
        return (String) invokeLL.objValue;
    }

    public static String list2String(List<RestNameValuePair> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, list)) == null) {
            if (list == null || list.size() == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (RestNameValuePair restNameValuePair : list) {
                String name = restNameValuePair.getName();
                String value = restNameValuePair.getValue();
                if (!TextUtils.isEmpty(name)) {
                    if (value == null) {
                        value = "";
                    }
                    sb.append(name);
                    sb.append(a.f31864h);
                    sb.append(value);
                    sb.append(Typography.amp);
                }
            }
            if (sb.length() > 1) {
                sb.replace(sb.length() - 1, sb.length(), "");
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static List<String> mapToList(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, map)) == null) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                StringBuilder sb = new StringBuilder();
                sb.append(entry.getKey().toString());
                sb.append("=");
                sb.append(TextUtils.isEmpty(entry.getValue()) ? "" : entry.getValue().toString());
                arrayList.add(sb.toString());
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }
}
