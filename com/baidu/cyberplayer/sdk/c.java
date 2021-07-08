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
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static c f4829a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4830b;

    /* renamed from: c  reason: collision with root package name */
    public String f4831c;

    /* renamed from: d  reason: collision with root package name */
    public String f4832d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4833e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4834f;

    /* renamed from: g  reason: collision with root package name */
    public String f4835g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4836h;

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
        this.f4830b = true;
        this.f4831c = null;
        this.f4832d = null;
        this.f4833e = true;
        this.f4834f = true;
        this.f4835g = null;
        this.f4836h = false;
    }

    public static synchronized c a() {
        InterceptResult invokeV;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (c.class) {
                if (f4829a == null) {
                    f4829a = new c();
                }
                cVar = f4829a;
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
                if (TextUtils.isEmpty(this.f4835g)) {
                    String cfgValue = CyberCfgManager.getInstance().getCfgValue("update_core_server", "");
                    return !TextUtils.isEmpty(cfgValue) ? cfgValue : "https://b.bdstatic.com/searchbox/androidvideo";
                }
                return this.f4835g;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f4836h = z;
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!this.f4830b) {
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
            if (TextUtils.isEmpty(this.f4831c)) {
                String cfgValue = CyberCfgManager.getInstance().getCfgValue("upload_session_server", "");
                return TextUtils.isEmpty(cfgValue) ? WebSettingsGlobalBlink.SESSION_UPLOAD_URL : cfgValue;
            }
            return this.f4831c;
        }
        return (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? !TextUtils.isEmpty(this.f4832d) ? this.f4832d : CyberCfgManager.getInstance().a(CyberCfgManager.getInstance().getCfgValue("update_cloud_cfg_server", "https://browserkernel.baidu.com/video")) : (String) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (i()) {
                return false;
            }
            return this.f4833e;
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f4834f && !i() : invokeV.booleanValue;
    }

    public synchronized boolean i() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this) {
                CyberLog.d("CyberGlobalSetting", "isSFSwitchEnabled:" + this.f4836h);
                z = this.f4836h;
            }
            return z;
        }
        return invokeV.booleanValue;
    }
}
