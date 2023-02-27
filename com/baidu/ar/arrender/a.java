package com.baidu.ar.arrender;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.constants.ARConfigKey;
import com.baidu.ar.constants.HttpConstants;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    public String gC;
    public String gD;
    public String gE;
    public String gF;

    public a(Context context) {
        this.gE = "0";
        this.gF = "0";
        this.gC = new com.baidu.ar.h.g(context).gz().toString();
        this.gD = com.baidu.ar.h.c.s(context);
        for (Sensor sensor : ((SensorManager) context.getSystemService("sensor")).getSensorList(-1)) {
            if (sensor.getType() == 4) {
                this.gE = "1";
            }
            if (sensor.getType() == 11) {
                this.gF = "1";
            }
        }
    }

    private void br() {
        HashMap hashMap = new HashMap();
        hashMap.put("app_version", String.valueOf(com.baidu.ar.h.c.getVersionCode()));
        hashMap.put("ar_key", ARConfig.getARKey());
        hashMap.put("ar_type", Integer.valueOf(ARConfig.getARType()));
        hashMap.put(HttpConstants.OS_VERSION, String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("device_id", this.gC);
        hashMap.put(ARConfigKey.EXTRA_INFO, ARConfig.getARExtraInfo());
        hashMap.put("os_type", "android");
        hashMap.put(HttpConstants.DEVICE_TYPE, Build.BRAND);
        hashMap.put("channel", this.gD);
        ARPScriptEnvironment.getInstance().setSharedEnvironmentKV(TableDefine.DB_TABLE_USERINFO, hashMap);
    }

    private void bs() {
        HashMap hashMap = new HashMap();
        hashMap.put("android.sensor.gyroscope", this.gE);
        hashMap.put("android.sensor.rotation_vector", this.gF);
        ARPScriptEnvironment.getInstance().setSharedEnvironmentKV("deviceinfo", hashMap);
    }

    public void bq() {
        br();
        bs();
    }

    public void setDataPipKV(String str, Object obj) {
        ARPScriptEnvironment.getInstance().setDataPipKV(str, obj);
    }
}
