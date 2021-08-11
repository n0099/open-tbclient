package c.a.l0.l;

import android.content.Context;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.cmic.sso.sdk.auth.AuthnHelper;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f3891a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f3892b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f3893c = "";
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            try {
                if (c.a.l0.b.a.h(context).e()) {
                    if (Build.VERSION.SDK_INT < 24) {
                        return -1001;
                    }
                    if (c.o(context)) {
                        return SubscriptionManager.getDefaultDataSubscriptionId();
                    }
                    return -1002;
                }
                return -1000;
            } catch (Throwable th) {
                c.d(th);
                return -1001;
            }
        }
        return invokeL.intValue;
    }

    public static String b(Context context, int i2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            try {
                if (!c.a.l0.b.a.h(context).e()) {
                    return c(String.valueOf(-1000), z2);
                }
                if (z) {
                    if (i2 == 3 && !TextUtils.isEmpty(f3891a)) {
                        return f3891a;
                    }
                    if (i2 == 1 && !TextUtils.isEmpty(f3893c)) {
                        return f3893c;
                    }
                    if (i2 == 2 && !TextUtils.isEmpty(f3892b)) {
                        return f3892b;
                    }
                }
                if (!h.a(context, "android.permission.READ_PHONE_STATE")) {
                    return c(String.valueOf(-1001), z2);
                }
                if (!c.o(context)) {
                    return c(String.valueOf(-1002), z2);
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                String str = null;
                if (i2 == 3) {
                    str = telephonyManager.getSubscriberId();
                } else if (i2 == 1) {
                    str = telephonyManager.getDeviceId();
                } else if (i2 == 2) {
                    str = telephonyManager.getSimSerialNumber();
                }
                if (TextUtils.isEmpty(str)) {
                    return c(String.valueOf(-1003), z2);
                }
                if (i2 == 3) {
                    f3891a = str;
                } else if (i2 == 1) {
                    f3893c = str;
                } else if (i2 == 2) {
                    f3892b = str;
                }
                return str;
            } catch (Throwable th) {
                c.d(th);
                return c(String.valueOf(-1001), z2);
            }
        }
        return (String) invokeCommon.objValue;
    }

    public static String c(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, str, z)) == null) ? z ? str : "" : (String) invokeLZ.objValue;
    }

    public static Pair<Integer, Integer> d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            Pair<Integer, Integer> pair = new Pair<>(-1, -1);
            try {
                JSONObject networkType = AuthnHelper.getInstance(context).getNetworkType(context);
                return (networkType != null && networkType.has("networktype")) ? Pair.create(Integer.valueOf(networkType.optString("networktype", "-1")), Integer.valueOf(networkType.optString("operatortype", "-1"))) : pair;
            } catch (Throwable th) {
                c.d(th);
                return pair;
            }
        }
        return (Pair) invokeL.objValue;
    }

    public static Pair<Integer, String[]> e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                if (!c.a.l0.b.a.h(context).e()) {
                    return new Pair<>(-1, new String[]{String.valueOf(-1000), String.valueOf(-1000), String.valueOf(-1000), String.valueOf(-1000)});
                }
                if (Build.VERSION.SDK_INT < 22) {
                    return new Pair<>(-2, new String[]{String.valueOf(-1001), String.valueOf(-1001), String.valueOf(-1001), String.valueOf(-1001)});
                }
                if (!h.a(context, "android.permission.READ_PHONE_STATE")) {
                    return new Pair<>(-1, new String[]{String.valueOf(-1001), String.valueOf(-1001), String.valueOf(-1001), String.valueOf(-1001)});
                }
                if (!c.o(context)) {
                    return new Pair<>(-1, new String[]{String.valueOf(-1002), String.valueOf(-1002), String.valueOf(-1002), String.valueOf(-1002)});
                }
                List<SubscriptionInfo> activeSubscriptionInfoList = ((SubscriptionManager) context.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoList();
                if (activeSubscriptionInfoList == null) {
                    return new Pair<>(0, new String[]{String.valueOf(-1003), String.valueOf(-1003), String.valueOf(-1003), String.valueOf(-1003)});
                }
                String[] strArr = new String[4];
                int i2 = 0;
                for (SubscriptionInfo subscriptionInfo : activeSubscriptionInfoList) {
                    int i3 = i2 * 2;
                    int simSlotIndex = subscriptionInfo.getSimSlotIndex();
                    int subscriptionId = subscriptionInfo.getSubscriptionId();
                    String iccId = subscriptionInfo.getIccId();
                    if (TextUtils.isEmpty(iccId)) {
                        iccId = String.valueOf(-1003);
                    }
                    strArr[i3] = simSlotIndex + "_" + subscriptionId + "_" + iccId;
                    CharSequence carrierName = subscriptionInfo.getCarrierName();
                    if (carrierName != null) {
                        strArr[i3 + 1] = carrierName.toString();
                    } else {
                        strArr[i3 + 1] = String.valueOf(-1003);
                    }
                    i2++;
                    if (i2 >= 2) {
                        break;
                    }
                }
                for (int i4 = 0; i4 < 4; i4++) {
                    if (TextUtils.isEmpty(strArr[i4])) {
                        strArr[i4] = String.valueOf(-1003);
                    }
                }
                return new Pair<>(Integer.valueOf(i2), strArr);
            } catch (Throwable th) {
                c.d(th);
                return new Pair<>(-1, new String[]{String.valueOf(-1001), String.valueOf(-1001), String.valueOf(-1001), String.valueOf(-1001)});
            }
        }
        return (Pair) invokeL.objValue;
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    return telephonyManager.getSimOperator();
                }
                return String.valueOf(-1003);
            } catch (Throwable unused) {
                return String.valueOf(-1003);
            }
        }
        return (String) invokeL.objValue;
    }
}
