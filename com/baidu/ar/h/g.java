package com.baidu.ar.h;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
/* loaded from: classes3.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public static UUID uuid;
    public transient /* synthetic */ FieldHolder $fh;

    public g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (uuid == null) {
            synchronized (g.class) {
                if (uuid == null) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("bd_plugin_ar_device_id.xml", 0);
                    String string = sharedPreferences.getString("device_id", null);
                    if (string != null) {
                        uuid = UUID.fromString(string);
                    } else {
                        String string2 = Settings.Secure.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
                        try {
                            if (!"9774d56d682e549c".equals(string2) && !TextUtils.isEmpty(string2)) {
                                uuid = UUID.nameUUIDFromBytes(string2.getBytes("utf8"));
                            }
                            if (uuid != null) {
                                sharedPreferences.edit().putString("device_id", uuid.toString()).apply();
                            }
                        } catch (UnsupportedEncodingException e2) {
                            throw new RuntimeException(e2);
                        }
                    }
                }
            }
        }
    }

    public UUID gz() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? uuid : (UUID) invokeV.objValue;
    }
}
