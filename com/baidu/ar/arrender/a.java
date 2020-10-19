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
/* loaded from: classes14.dex */
public class a {
    private String gp;
    private String gq;
    private String gr;
    private String gs;

    public a(Context context) {
        this.gr = "0";
        this.gs = "0";
        this.gp = new com.baidu.ar.g.g(context).gz().toString();
        this.gq = com.baidu.ar.g.c.r(context);
        for (Sensor sensor : ((SensorManager) context.getSystemService("sensor")).getSensorList(-1)) {
            if (sensor.getType() == 4) {
                this.gr = "1";
            }
            if (sensor.getType() == 11) {
                this.gs = "1";
            }
        }
    }

    private void bu() {
        HashMap hashMap = new HashMap();
        hashMap.put("app_version", String.valueOf(com.baidu.ar.g.c.getVersionCode()));
        hashMap.put("ar_key", ARConfig.getARKey());
        hashMap.put("ar_type", Integer.valueOf(ARConfig.getARType()));
        hashMap.put("os_version", String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("device_id", this.gp);
        hashMap.put(ARConfigKey.EXTRA_INFO, ARConfig.getARExtraInfo());
        hashMap.put(HttpConstants.HTTP_OS_TYPE, "android");
        hashMap.put(HttpConstants.DEVICE_TYPE, Build.BRAND);
        hashMap.put("channel", this.gq);
        ARPScriptEnvironment.getInstance().setSharedEnvironmentKV(TableDefine.DB_TABLE_USERINFO, hashMap);
    }

    private void bv() {
        HashMap hashMap = new HashMap();
        hashMap.put("android.sensor.gyroscope", this.gr);
        hashMap.put("android.sensor.rotation_vector", this.gs);
        ARPScriptEnvironment.getInstance().setSharedEnvironmentKV("deviceinfo", hashMap);
    }

    public void bt() {
        bu();
        bv();
    }

    public void setDataPipKV(String str, Object obj) {
        ARPScriptEnvironment.getInstance().setDataPipKV(str, obj);
    }
}
