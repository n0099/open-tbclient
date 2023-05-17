package com.baidu.location.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDLocation;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPreferences a;
    public boolean b;
    public Deque<String> c;
    public Deque<String> d;
    public Deque<String> e;
    public int f;
    public int g;
    public int h;
    public int i;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static c a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(819702836, "Lcom/baidu/location/b/c$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(819702836, "Lcom/baidu/location/b/c$a;");
                    return;
                }
            }
            a = new c();
        }
    }

    public c() {
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
        this.a = null;
        this.b = false;
        this.c = new LinkedList();
        this.d = new LinkedList();
        this.e = new LinkedList();
        this.f = 5;
        this.g = 5;
        this.h = 1;
        this.i = 1;
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.a : (c) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(int i, int i2) {
        InterceptResult invokeII;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeII = interceptable.invokeII(65538, this, i, i2)) != null) {
            return (String) invokeII.objValue;
        }
        if (i == 1) {
            String c = c(this.e);
            if (!"".equals(c)) {
                str = "&ll_pre=" + c;
                if (i2 != 1) {
                    String b = b(this.c);
                    if (!"".equals(b)) {
                        str = str + "&cl_pre=" + b;
                    }
                    String b2 = b(this.d);
                    if ("".equals(b2)) {
                        return str;
                    }
                    return str + "&wf_pre=" + b2;
                }
                return str;
            }
        }
        str = "";
        if (i2 != 1) {
        }
    }

    private void a(String str, Deque<String> deque) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, this, str, deque) == null) || str == null || "".equals(str)) {
            return;
        }
        deque.addAll(Arrays.asList(new String(Base64.decode(str.getBytes(), 0)).split(WebChromeClient.PARAM_SEPARATOR)));
    }

    private void a(Deque<String> deque) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, deque) == null) || deque == null || deque.isEmpty()) {
            return;
        }
        while (deque.size() > this.g) {
            deque.pollLast();
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str : deque) {
            sb.append(str);
            if (i != deque.size() - 1) {
                sb.append("|");
            }
            i++;
        }
        try {
            String str2 = new String(Base64.encode(sb.toString().getBytes(), 0));
            SharedPreferences.Editor edit = this.a.edit();
            edit.putString("ll_pre", str2);
            edit.commit();
        } catch (Exception unused) {
        }
    }

    private void a(Deque<String> deque, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, this, deque, str) == null) || deque == null || deque.isEmpty()) {
            return;
        }
        while (deque.size() > this.f) {
            deque.pollLast();
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str2 : deque) {
            sb.append(str2);
            if (i != deque.size() - 1) {
                sb.append("|");
            }
            i++;
        }
        try {
            String str3 = new String(Base64.encode(sb.toString().getBytes(), 0));
            SharedPreferences.Editor edit = this.a.edit();
            edit.putString(str + "_pre", str3);
            edit.commit();
        } catch (Exception unused) {
        }
    }

    private String b(Deque<String> deque) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, deque)) == null) {
            if (deque == null || deque.isEmpty()) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            String peekFirst = deque.peekFirst();
            if (peekFirst != null) {
                String[] split = peekFirst.split(",");
                int i = 0;
                for (String str : deque) {
                    if (split.length != 3) {
                        break;
                    }
                    String[] split2 = str.split(",");
                    if (i == 0) {
                        sb.append(peekFirst);
                    } else if (split2.length != 3) {
                        i++;
                    } else {
                        try {
                            sb.append((int) ((Double.parseDouble(split[0]) - Double.parseDouble(split2[0])) * Math.pow(10.0d, 6.0d)));
                            sb.append(",");
                            sb.append((int) ((Double.parseDouble(split[1]) - Double.parseDouble(split2[1])) * Math.pow(10.0d, 6.0d)));
                            sb.append(",");
                            sb.append(Long.parseLong(split[2]) - Long.parseLong(split2[2]));
                        } catch (Exception unused) {
                        }
                    }
                    if (i != deque.size() - 1) {
                        sb.append("|");
                    }
                    i++;
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    private void b(String str, Deque<String> deque) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, this, str, deque) == null) || str == null || "".equals(str)) {
            return;
        }
        deque.addAll(Arrays.asList(new String(Base64.decode(str.getBytes(), 0)).split(WebChromeClient.PARAM_SEPARATOR)));
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String c(Deque<String> deque) {
        InterceptResult invokeL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, deque)) == null) {
            if (deque == null || deque.isEmpty()) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            String peekFirst = deque.peekFirst();
            if (peekFirst != null) {
                String[] split = peekFirst.split(",");
                char c = 0;
                int i3 = 0;
                for (String str : deque) {
                    if (split.length != 7) {
                        break;
                    }
                    String[] split2 = str.split(",");
                    if (i3 == 0) {
                        sb.append(peekFirst);
                    } else if (split2.length != 7) {
                        i3++;
                    } else {
                        try {
                            sb.append(Integer.parseInt(split[c]) - Integer.parseInt(split2[c]));
                            sb.append(",");
                            sb.append(Integer.parseInt(split[1]) - Integer.parseInt(split2[1]));
                            sb.append(",");
                            sb.append(new BigDecimal(split[2]).subtract(new BigDecimal(split2[2])));
                            sb.append(",");
                            sb.append(Long.parseLong(split[3]) - Long.parseLong(split2[3]));
                            sb.append(",");
                            sb.append(new BigDecimal(split[4]).subtract(new BigDecimal(split2[4])));
                            sb.append(",");
                            double doubleValue = new BigDecimal(split[5]).subtract(new BigDecimal(split2[5])).doubleValue();
                            double doubleValue2 = new BigDecimal(split[6]).subtract(new BigDecimal(split2[6])).doubleValue();
                            i = i3;
                            try {
                                sb.append((int) (doubleValue * Math.pow(10.0d, 6.0d)));
                                sb.append(",");
                                sb.append((int) (doubleValue2 * Math.pow(10.0d, 6.0d)));
                            } catch (Exception unused) {
                            }
                        } catch (Exception unused2) {
                        }
                        i2 = i;
                        if (i2 != deque.size() - 1) {
                            sb.append("|");
                        }
                        i3 = i2 + 1;
                        c = 0;
                    }
                    i = i3;
                    i2 = i;
                    if (i2 != deque.size() - 1) {
                    }
                    i3 = i2 + 1;
                    c = 0;
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            if (this.a == null) {
                this.a = r.a().a(context);
            }
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences == null || this.b) {
                return;
            }
            try {
                String string = sharedPreferences.getString("cl_pre", "");
                String string2 = this.a.getString("wf_pre", "");
                String string3 = this.a.getString("ll_pre", "");
                a(string, this.c);
                a(string2, this.d);
                b(string3, this.e);
            } catch (Exception unused) {
            }
            this.b = true;
        }
    }

    public synchronized void a(BDLocation bDLocation, String str, Location location) {
        Deque<String> deque;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bDLocation, str, location) == null) {
            synchronized (this) {
                if (bDLocation != null) {
                    if ("gcj02".equals(str)) {
                        String networkLocationType = bDLocation.getNetworkLocationType();
                        int locType = bDLocation.getLocType();
                        if (locType == 61 || locType == 161) {
                            if (networkLocationType == null) {
                                networkLocationType = StringUtil.NULL_STRING;
                            }
                            if (networkLocationType.contains("wf") && this.h == 1) {
                                this.d.offerFirst(bDLocation.getLongitude() + "," + bDLocation.getLatitude() + "," + com.baidu.location.e.k.d(bDLocation.getTime()));
                                deque = this.d;
                                str2 = "wf";
                            } else if (!networkLocationType.contains("cl") || this.h != 1) {
                                if (locType == 61 && this.i == 1 && location != null) {
                                    DecimalFormat decimalFormat = new DecimalFormat("0.00");
                                    DecimalFormat decimalFormat2 = new DecimalFormat("0.0");
                                    DecimalFormat decimalFormat3 = new DecimalFormat("0.000000");
                                    double longitude = location.getLongitude();
                                    double latitude = location.getLatitude();
                                    this.e.offerFirst(bDLocation.getSatelliteNumber() + "," + ((int) bDLocation.getRadius()) + "," + decimalFormat.format(bDLocation.getAltitude()) + "," + com.baidu.location.e.k.d(bDLocation.getTime()) + "," + decimalFormat2.format(bDLocation.getSpeed()) + "," + decimalFormat3.format(longitude) + "," + decimalFormat3.format(latitude));
                                    a(this.e);
                                }
                            } else {
                                this.c.offerFirst(bDLocation.getLongitude() + "," + bDLocation.getLatitude() + "," + com.baidu.location.e.k.d(bDLocation.getTime()));
                                deque = this.c;
                                str2 = "cl";
                            }
                            a(deque, str2);
                        }
                    }
                }
            }
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? a(this.i, this.h) : (String) invokeV.objValue;
    }

    public synchronized String c() {
        InterceptResult invokeV;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                a2 = a(this.i, this.h);
            }
            return a2;
        }
        return (String) invokeV.objValue;
    }
}
