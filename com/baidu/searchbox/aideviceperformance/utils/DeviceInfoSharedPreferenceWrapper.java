package com.baidu.searchbox.aideviceperformance.utils;

import com.baidu.android.util.UniKV;
/* loaded from: classes3.dex */
public class DeviceInfoSharedPreferenceWrapper extends UniKV {
    public static final String SP_FILE_DEFAULT = "com.baidu.searchbox.device_info_sp";

    /* loaded from: classes3.dex */
    public static class Holder {
        public static final DeviceInfoSharedPreferenceWrapper INSTANCE = new DeviceInfoSharedPreferenceWrapper();
    }

    public DeviceInfoSharedPreferenceWrapper() {
        super(SP_FILE_DEFAULT);
    }

    public static DeviceInfoSharedPreferenceWrapper getInstance() {
        return Holder.INSTANCE;
    }
}
