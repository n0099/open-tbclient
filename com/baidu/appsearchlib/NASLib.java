package com.baidu.appsearchlib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLDecoder;
import org.apache.commons.lang3.text.FormattableUtils;
/* loaded from: classes3.dex */
public class NASLib extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public static NASCallBack callback;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public interface NASCallBack {
        void callback(String str, String str2);
    }

    public NASLib() {
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

    private void load_uri() {
        Uri data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (data = getIntent().getData()) == null) {
            return;
        }
        parseRequest(data.toString(), true, getApplicationContext());
    }

    public static void onAppStart(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            Logger.onClientBoot(context);
        }
    }

    public static void onAppStop(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            Logger.onClientExit(context);
        }
    }

    private String parseRequest(String str, boolean z, Context context) {
        InterceptResult invokeCommon;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{str, Boolean.valueOf(z), context})) != null) {
            return (String) invokeCommon.objValue;
        }
        String str3 = null;
        try {
            if (str.contains(Info.kUrlSecStart)) {
                String trim = Encryption.desEncrypt(URLDecoder.decode(str.substring(str.indexOf(Info.kUrlSecStart) + 7), "utf-8")).trim();
                if (trim.contains(Info.kUrlLogStart)) {
                    String[] split = trim.split(Info.kUrlLogStart);
                    trim = split[0];
                    str2 = split[1];
                } else {
                    str2 = null;
                }
                Logger.onCallUp();
                if (str2 != null) {
                    Logger.recordServerAction(context, FormattableUtils.SIMPLEST_FORMAT, str2);
                }
                if (trim != null) {
                    try {
                        if (callback != null) {
                            callback.callback(str, trim);
                        } else if (z) {
                            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(trim)));
                        }
                        return trim;
                    } catch (Exception e2) {
                        e = e2;
                        str3 = trim;
                        e.printStackTrace();
                        return str3;
                    }
                }
                return null;
            }
            return null;
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static void recordCustomAction(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, str) == null) {
            Logger.recordCustomAction(context, str);
        }
    }

    public static void setCallBack(NASCallBack nASCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, nASCallBack) == null) {
            callback = nASCallBack;
        }
    }

    public static void setLooperDisabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, null, z) == null) {
            Logger.looperDisabled = z;
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            requestWindowFeature(1);
            getWindow().setFlags(1024, 2048);
            load_uri();
            onAppStart(getApplicationContext());
            finish();
            LogUtil.logActivity(this, "onCreate");
        }
    }

    public String parseUri(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, uri)) == null) {
            if (uri != null) {
                return parseRequest(uri.toString(), false, context);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }
}
