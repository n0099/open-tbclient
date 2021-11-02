package com.baidu.mobads.container.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.config.AppCommonConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class APKStateManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long APK_INFO_TIMEOUT;
    public static final String APK_LIST_FILE_NAME = "mobads_aplist_status";
    public static final String KEY_JSON_CONFIG_PKG_LIST = "pkglist";
    public static final String KEY_MTJ_SWITCH = "mtj_switch";
    public static final String KEY_MTJ_WEB_SWITCH = "mtj_web_switch";
    public static final String KEY_ORIGIN_ENCODE_PKGLIST = "n_origin_pkg_encode_";
    public static final String KEY_ORIGIN_INDEX_ARRAY = "n_iad_index_array";
    public static final String KEY_ORIGIN_SNIFF_IAD = "n_iad_sniff_result";
    public static final String KEY_ORIGIN_TIME_STAMP = "n_iad_time_stamp";
    public static final String KEY_SWITCH_LP_RELOAD = "lp_reload";
    public static final String SWITCH_MTJ_OPEN = "switch_mtj_open";
    public static final String TAG = "APKStateManager";
    public static APKStateManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public String defaultList;
    public String defaultListSecond;
    public String mIadex;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(10341585, "Lcom/baidu/mobads/container/util/APKStateManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(10341585, "Lcom/baidu/mobads/container/util/APKStateManager;");
                return;
            }
        }
        APK_INFO_TIMEOUT = TimeUnit.HOURS.toMillis(24L);
    }

    public APKStateManager() {
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
        RemoteXAdLogger.getInstance().d(TAG, "create APKStateManager Instance ~");
    }

    private String[] doubleCheckPkgArrays(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            String[] strArr = new String[64];
            if (TextUtils.isEmpty(str)) {
                return strArr;
            }
            String decodeStr = Base64.decodeStr(str);
            if (decodeStr.contains(",")) {
                return decodeStr.split(",");
            }
            strArr[0] = decodeStr;
            return strArr;
        }
        return (String[]) invokeL.objValue;
    }

    private String[] getAllOriginPkgList(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, context)) == null) {
            try {
                int i2 = getInt(context, KEY_ORIGIN_INDEX_ARRAY, -1);
                if (i2 == -1) {
                    List<String> iadStringList = AppCommonConfig.getInstance().getIadStringList();
                    if (iadStringList != null && iadStringList.size() > 1) {
                        this.defaultList = iadStringList.get(0);
                        this.defaultListSecond = iadStringList.get(1);
                    }
                    return new String[]{this.defaultList, this.defaultListSecond};
                }
                int i3 = i2 + 1;
                String[] strArr = new String[i3];
                for (int i4 = 0; i4 < i3; i4++) {
                    strArr[i4] = getString(context, KEY_ORIGIN_ENCODE_PKGLIST + i4);
                }
                return strArr;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (String[]) invokeL.objValue;
    }

    private boolean getBoolean(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, this, context, str, z)) == null) ? context == null ? z : context.getSharedPreferences(APK_LIST_FILE_NAME, 0).getBoolean(str, z) : invokeLLZ.booleanValue;
    }

    private long[] getIADEXArray(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, context)) == null) {
            String iADEXValue = getIADEXValue(context);
            int max = Math.max(getInt(context, KEY_ORIGIN_INDEX_ARRAY, 0) + 1, getAllOriginPkgList(context).length);
            long[] jArr = new long[max];
            if (TextUtils.isEmpty(iADEXValue)) {
                RemoteXAdLogger.getInstance().d(TAG, "getIADArray values is null");
                return jArr;
            }
            try {
                if (iADEXValue.contains(",")) {
                    String[] split = iADEXValue.split(",");
                    for (int i2 = 0; i2 < max; i2++) {
                        jArr[i2] = Long.parseLong(split[i2]);
                    }
                } else {
                    jArr[0] = Long.parseLong(iADEXValue);
                }
            } catch (RuntimeException e2) {
                RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
                remoteXAdLogger.e(TAG, "getIADEXArray Exception :" + e2.getMessage());
            }
            return jArr;
        }
        return (long[]) invokeL.objValue;
    }

    public static APKStateManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (sInstance == null) {
                synchronized (APKStateManager.class) {
                    if (sInstance == null) {
                        sInstance = new APKStateManager();
                    }
                }
            }
            return sInstance;
        }
        return (APKStateManager) invokeV.objValue;
    }

    private int getInt(Context context, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65543, this, context, str, i2)) == null) ? context == null ? i2 : context.getSharedPreferences(APK_LIST_FILE_NAME, 0).getInt(str, i2) : invokeLLI.intValue;
    }

    private long getLong(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, context, str)) == null) {
            if (context == null) {
                return 0L;
            }
            return context.getSharedPreferences(APK_LIST_FILE_NAME, 0).getLong(str, 0L);
        }
        return invokeLL.longValue;
    }

    private String getString(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, context, str)) == null) ? context == null ? "" : context.getSharedPreferences(APK_LIST_FILE_NAME, 0).getString(str, "") : (String) invokeLL.objValue;
    }

    private long judgeAppsState(PackageManager packageManager, String str, int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, this, new Object[]{packageManager, str, Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            try {
                RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
                String str2 = TAG;
                remoteXAdLogger.d(str2, "judge pkg :" + str);
                packageManager.getApplicationInfo(str, 0);
                return setApkInstalled(j, i2);
            } catch (PackageManager.NameNotFoundException unused) {
                return setApkUnInstalled(j, i2);
            } catch (Exception unused2) {
                return setApkUnInstalled(j, i2);
            }
        }
        return invokeCommon.longValue;
    }

    private long setApkInstalled(long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)})) == null) {
            RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
            String str = TAG;
            remoteXAdLogger.d(str, "setApkInstalled, current state :" + j + ", position :" + i2);
            return j | (1 << i2);
        }
        return invokeCommon.longValue;
    }

    private long setApkUnInstalled(long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)})) == null) {
            RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
            String str = TAG;
            remoteXAdLogger.d(str, "setApkInstalled, current state :" + j + ", position :" + i2);
            return j & (~(1 << i2));
        }
        return invokeCommon.longValue;
    }

    private void setBoolean(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65549, this, context, str, z) == null) || context == null) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(APK_LIST_FILE_NAME, 0).edit();
        edit.putBoolean(str, z);
        if (Build.VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }

    private void setInt(Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65550, this, context, str, i2) == null) || context == null || i2 <= 0) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(APK_LIST_FILE_NAME, 0).edit();
        edit.putInt(str, i2);
        if (Build.VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }

    private void setLong(Context context, String str, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65551, this, new Object[]{context, str, Long.valueOf(j)}) == null) || context == null || j <= 0) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(APK_LIST_FILE_NAME, 0).edit();
        edit.putLong(str, j);
        if (Build.VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }

    private void setString(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65552, this, context, str, str2) == null) || context == null || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(APK_LIST_FILE_NAME, 0).edit();
        edit.putString(str, str2);
        if (Build.VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }

    public void actionToSniff(Context context, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, context, z) == null) {
            if (APK_INFO_TIMEOUT > System.currentTimeMillis() - getLong(context, KEY_ORIGIN_TIME_STAMP) && !z) {
                RemoteXAdLogger.getInstance().d(TAG, "Within the time protection period");
                return;
            }
            String[] allOriginPkgList = getAllOriginPkgList(context);
            if (allOriginPkgList != null && allOriginPkgList.length != 0) {
                StringBuilder sb = new StringBuilder();
                PackageManager packageManager = context.getPackageManager();
                for (int i3 = 0; i3 < allOriginPkgList.length; i3++) {
                    String str = allOriginPkgList[i3];
                    if (TextUtils.isEmpty(str)) {
                        if (i3 > 0) {
                            sb.append(",");
                        }
                        sb.append(1L);
                    } else {
                        String[] doubleCheckPkgArrays = doubleCheckPkgArrays(str);
                        if (doubleCheckPkgArrays != null && doubleCheckPkgArrays.length != 0) {
                            long j = 1;
                            int i4 = 0;
                            while (i4 < doubleCheckPkgArrays.length && i4 < 64) {
                                int i5 = i4 + 1;
                                j = judgeAppsState(packageManager, doubleCheckPkgArrays[i4], i5, j);
                                RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
                                String str2 = TAG;
                                remoteXAdLogger.d(str2, "actionToProbo : i=" + i3 + ", j=" + i4 + "pkg=" + doubleCheckPkgArrays[i2] + ", state=" + j);
                                i4 = i5;
                            }
                            if (i3 > 0) {
                                sb.append(",");
                            }
                            sb.append(j);
                        } else {
                            if (i3 > 0) {
                                sb.append(",");
                            }
                            sb.append(1L);
                        }
                    }
                }
                setString(context, KEY_ORIGIN_SNIFF_IAD, sb.toString());
                setLong(context, KEY_ORIGIN_TIME_STAMP, System.currentTimeMillis());
                return;
            }
            RemoteXAdLogger.getInstance().d(TAG, "actionToSniff array is null");
        }
    }

    public void actionToSniffByBroadCast(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                String[] allOriginPkgList = getAllOriginPkgList(context);
                if (allOriginPkgList != null && allOriginPkgList.length != 0) {
                    long[] iADEXArray = getIADEXArray(context);
                    StringBuilder sb = new StringBuilder();
                    PackageManager packageManager = context.getPackageManager();
                    boolean z = false;
                    for (int i2 = 0; i2 < allOriginPkgList.length && i2 < iADEXArray.length; i2++) {
                        String[] doubleCheckPkgArrays = doubleCheckPkgArrays(allOriginPkgList[i2]);
                        if (doubleCheckPkgArrays != null && doubleCheckPkgArrays.length != 0) {
                            long j = iADEXArray[i2];
                            int i3 = 0;
                            while (true) {
                                if (i3 >= doubleCheckPkgArrays.length || i3 >= 64) {
                                    break;
                                } else if (str.equals(doubleCheckPkgArrays[i3])) {
                                    iADEXArray[i2] = judgeAppsState(packageManager, str, i3 + 1, j);
                                    z = true;
                                    break;
                                } else {
                                    i3++;
                                }
                            }
                            if (i2 > 0) {
                                sb.append(",");
                            }
                            sb.append(iADEXArray[i2]);
                        }
                    }
                    if (z) {
                        setString(context, KEY_ORIGIN_SNIFF_IAD, sb.toString());
                        setLong(context, KEY_ORIGIN_TIME_STAMP, System.currentTimeMillis());
                        return;
                    }
                    return;
                }
                RemoteXAdLogger.getInstance().d(TAG, "SniffByBroadCast array is null");
                return;
            }
            RemoteXAdLogger.getInstance().d(TAG, "SniffByBroadCast pkg or context is null");
        }
    }

    public void dealWithPKGProfile(Context context, String str) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str) == null) {
            RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
            String str2 = TAG;
            remoteXAdLogger.d(str2, "dealWithPKGProfile :" + str);
            if (!TextUtils.isEmpty(str) && context != null) {
                String decodeStr = Base64.decodeStr(str);
                ArrayList<Integer> arrayList = new ArrayList();
                try {
                    JSONObject jSONObject2 = new JSONObject(decodeStr);
                    boolean z = false;
                    setBoolean(context, KEY_SWITCH_LP_RELOAD, jSONObject2.optBoolean(KEY_SWITCH_LP_RELOAD, false));
                    setBoolean(context, KEY_MTJ_SWITCH, jSONObject2.optBoolean(KEY_MTJ_SWITCH, false));
                    setBoolean(context, KEY_MTJ_WEB_SWITCH, jSONObject2.optBoolean(KEY_MTJ_WEB_SWITCH, false));
                    if (!jSONObject2.has(KEY_JSON_CONFIG_PKG_LIST) || (jSONObject = jSONObject2.getJSONObject(KEY_JSON_CONFIG_PKG_LIST)) == null) {
                        return;
                    }
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        int parseInt = Integer.parseInt(next);
                        if (parseInt >= 0) {
                            arrayList.add(Integer.valueOf(parseInt));
                            String optString = jSONObject.optString(next);
                            if (!TextUtils.equals(getString(context, KEY_ORIGIN_ENCODE_PKGLIST + next), optString)) {
                                setString(context, KEY_ORIGIN_ENCODE_PKGLIST + parseInt, jSONObject.optString(next));
                                z = true;
                            }
                        }
                    }
                    RemoteXAdLogger remoteXAdLogger2 = RemoteXAdLogger.getInstance();
                    String str3 = TAG;
                    remoteXAdLogger2.d(str3, "sort BEFORE KEY:" + arrayList.toString());
                    Collections.sort(arrayList);
                    RemoteXAdLogger remoteXAdLogger3 = RemoteXAdLogger.getInstance();
                    String str4 = TAG;
                    remoteXAdLogger3.d(str4, "sort KEY:" + arrayList.toString());
                    int intValue = ((Integer) arrayList.get(arrayList.size() - 1)).intValue();
                    String[] strArr = new String[intValue + 1];
                    setInt(context, KEY_ORIGIN_INDEX_ARRAY, intValue);
                    RemoteXAdLogger remoteXAdLogger4 = RemoteXAdLogger.getInstance();
                    String str5 = TAG;
                    remoteXAdLogger4.d(str5, "ready to create int[] size = " + intValue);
                    for (Integer num : arrayList) {
                        int intValue2 = num.intValue();
                        strArr[intValue2] = jSONObject.optString(String.valueOf(intValue2));
                    }
                    setLong(context, KEY_ORIGIN_TIME_STAMP, 0L);
                    actionToSniff(context, z);
                    return;
                } catch (IllegalArgumentException e2) {
                    RemoteXAdLogger.getInstance().d(TAG, "dealWithPKGProfile : IllegalArgumentException");
                    e2.printStackTrace();
                    return;
                } catch (RuntimeException e3) {
                    RemoteXAdLogger.getInstance().d(TAG, "dealWithPKGProfile : RunTimeException");
                    e3.printStackTrace();
                    return;
                } catch (JSONException e4) {
                    RemoteXAdLogger.getInstance().d(TAG, "dealWithPKGProfile :decode json String error");
                    e4.printStackTrace();
                    return;
                }
            }
            RemoteXAdLogger.getInstance().d(TAG, "dealWithPKGProfile : origin string is null");
        }
    }

    public String getIADEXValue(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (context == null) {
                return null;
            }
            if (!TextUtils.isEmpty(this.mIadex)) {
                return this.mIadex;
            }
            this.mIadex = getString(context, KEY_ORIGIN_SNIFF_IAD);
            actionToSniff(context, false);
            return this.mIadex;
        }
        return (String) invokeL.objValue;
    }

    public boolean getLPSwitch(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? getBoolean(context, KEY_SWITCH_LP_RELOAD, false) : invokeL.booleanValue;
    }

    public boolean getMTJSwitch(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? getBoolean(context, KEY_MTJ_SWITCH, AppCommonConfig.getInstance().getMtjSwitch()) : invokeL.booleanValue;
    }

    public boolean getMTJWebSwitch(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) ? getBoolean(context, KEY_MTJ_WEB_SWITCH, false) : invokeL.booleanValue;
    }
}
