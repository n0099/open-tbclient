package com.baidu.cyberplayer.sdk;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static c f38994a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public boolean f38995b;

    /* renamed from: c  reason: collision with root package name */
    public String f38996c;

    /* renamed from: d  reason: collision with root package name */
    public String f38997d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f38998e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f38999f;

    /* renamed from: g  reason: collision with root package name */
    public String f39000g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f39001h;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38995b = true;
        this.f38996c = null;
        this.f38997d = null;
        this.f38998e = true;
        this.f38999f = true;
        this.f39000g = null;
        this.f39001h = false;
    }

    public static synchronized c a() {
        InterceptResult invokeV;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (c.class) {
                if (f38994a == null) {
                    f38994a = new c();
                }
                cVar = f38994a;
            }
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(this.f39000g)) {
                    String cfgValue = CyberCfgManager.getInstance().getCfgValue("update_core_server", "");
                    return !TextUtils.isEmpty(cfgValue) ? cfgValue : "https://b.bdstatic.com/searchbox/androidvideo";
                }
                return this.f39000g;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f39001h = z;
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!this.f38995b) {
                CyberLog.i("CyberGlobalSetting", "isStatisticsUploadEnable closed");
                return false;
            } else if (i()) {
                return false;
            } else {
                return CyberCfgManager.getInstance().getCfgBoolValue("enable_upload_session_log", true);
            }
        }
        return invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? CyberCfgManager.getInstance().getCfgBoolValue("enable_live_upload_double", true) : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? CyberCfgManager.getInstance().getCfgBoolValue("enable_upload_ubc_log", true) : invokeV.booleanValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (TextUtils.isEmpty(this.f38996c)) {
                String cfgValue = CyberCfgManager.getInstance().getCfgValue("upload_session_server", "");
                return TextUtils.isEmpty(cfgValue) ? WebSettingsGlobalBlink.SESSION_UPLOAD_URL : cfgValue;
            }
            return this.f38996c;
        }
        return (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? !TextUtils.isEmpty(this.f38997d) ? this.f38997d : CyberCfgManager.getInstance().a(CyberCfgManager.getInstance().getCfgValue("update_cloud_cfg_server", "https://browserkernel.baidu.com/video")) : (String) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (i()) {
                return false;
            }
            return this.f38998e;
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f38999f && !i() : invokeV.booleanValue;
    }

    public synchronized boolean i() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this) {
                CyberLog.d("CyberGlobalSetting", "isSFSwitchEnabled:" + this.f39001h);
                z = this.f39001h;
            }
            return z;
        }
        return invokeV.booleanValue;
    }
}
