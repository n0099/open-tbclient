package com.baidu.fsg.base.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes4.dex */
public final class BussinessUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BussinessUtils() {
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

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
        if (r2 != null) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getUA(Context context) {
        InterceptResult invokeL;
        String str;
        String str2;
        PackageManager packageManager;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            String str3 = "";
            try {
                packageManager = context.getPackageManager();
            } catch (Exception unused) {
                str = "";
            }
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0)) != null) {
                str = packageInfo.versionName;
                try {
                    str3 = packageInfo.versionCode + "";
                } catch (Exception unused2) {
                }
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                StringBuilder sb = new StringBuilder();
                sb.append(ChannelUtils.getSDKVersion());
                sb.append('_');
                sb.append(displayMetrics.widthPixels);
                sb.append('_');
                sb.append(displayMetrics.heightPixels);
                sb.append('_');
                sb.append((Build.MODEL + SignatureImpl.SEP + Build.DEVICE).replace(WebvttCueParser.CHAR_SPACE, SignatureImpl.SEP).replace('_', SignatureImpl.SEP));
                sb.append('_');
                sb.append(Build.VERSION.SDK);
                sb.append('_');
                str2 = Build.VERSION.RELEASE;
                if (!TextUtils.isEmpty(str2)) {
                    str2 = str2.replace(WebvttCueParser.CHAR_SPACE, SignatureImpl.SEP).replace('_', SignatureImpl.SEP);
                }
                sb.append(str2);
                sb.append('_');
                sb.append(str);
                sb.append('_');
                sb.append(str3);
                return sb.toString();
            }
            str = "";
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(ChannelUtils.getSDKVersion());
            sb2.append('_');
            sb2.append(displayMetrics2.widthPixels);
            sb2.append('_');
            sb2.append(displayMetrics2.heightPixels);
            sb2.append('_');
            sb2.append((Build.MODEL + SignatureImpl.SEP + Build.DEVICE).replace(WebvttCueParser.CHAR_SPACE, SignatureImpl.SEP).replace('_', SignatureImpl.SEP));
            sb2.append('_');
            sb2.append(Build.VERSION.SDK);
            sb2.append('_');
            str2 = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str2)) {
            }
            sb2.append(str2);
            sb2.append('_');
            sb2.append(str);
            sb2.append('_');
            sb2.append(str3);
            return sb2.toString();
        }
        return (String) invokeL.objValue;
    }
}
