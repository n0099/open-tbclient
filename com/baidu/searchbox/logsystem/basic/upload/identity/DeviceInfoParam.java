package com.baidu.searchbox.logsystem.basic.upload.identity;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.util.Base64Encoder;
/* loaded from: classes3.dex */
public class DeviceInfoParam {
    public String mDeviceInfo;
    public String mEnDeviceInfo;
    public String mManufacturer;
    public String mModel;
    public String mOSVersion;

    public DeviceInfoParam() {
        init();
    }

    private String initDeviceInfo() {
        String str = this.mModel;
        String str2 = this.mOSVersion;
        int i = Build.VERSION.SDK_INT;
        String str3 = this.mManufacturer;
        return str + "_" + str2 + "_" + i + "_" + str3;
    }

    private void initEnDeviceInfo() {
        this.mEnDeviceInfo = new String(Base64Encoder.B64Encode(this.mDeviceInfo.getBytes()));
    }

    public String getDeviceInfo() {
        return this.mDeviceInfo;
    }

    public String getEnDeviceInfo() {
        if (TextUtils.isEmpty(this.mEnDeviceInfo)) {
            initEnDeviceInfo();
        }
        return this.mEnDeviceInfo;
    }

    public String getManufacturer() {
        return this.mManufacturer;
    }

    public String getModel() {
        return this.mModel;
    }

    public String getOSVersion() {
        return this.mOSVersion;
    }

    private void init() {
        String str = Build.MODEL;
        this.mModel = str;
        if (TextUtils.isEmpty(str)) {
            this.mModel = "NUL";
        } else {
            this.mModel = this.mModel.replace("_", "-");
        }
        String str2 = Build.MANUFACTURER;
        this.mManufacturer = str2;
        if (TextUtils.isEmpty(str2)) {
            this.mManufacturer = "NUL";
        } else {
            this.mManufacturer = this.mManufacturer.replace("_", "-");
        }
        String str3 = Build.VERSION.RELEASE;
        this.mOSVersion = str3;
        if (TextUtils.isEmpty(str3)) {
            this.mOSVersion = "0.0";
        } else {
            this.mOSVersion = this.mOSVersion.replace("_", "-");
        }
        this.mDeviceInfo = initDeviceInfo();
    }
}
