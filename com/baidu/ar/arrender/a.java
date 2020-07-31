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
/* loaded from: classes11.dex */
public class a {
    private String ha;
    private String hb;
    private String hc;
    private String hd;

    public a(Context context) {
        this.hc = "0";
        this.hd = "0";
        this.ha = new com.baidu.ar.f.e(context).fl().toString();
        this.hb = com.baidu.ar.f.c.q(context);
        for (Sensor sensor : ((SensorManager) context.getSystemService("sensor")).getSensorList(-1)) {
            if (sensor.getType() == 4) {
                this.hc = "1";
            }
            if (sensor.getType() == 11) {
                this.hd = "1";
            }
        }
    }

    private void bm() {
        HashMap hashMap = new HashMap();
        hashMap.put("app_version", String.valueOf(com.baidu.ar.f.c.getVersionCode()));
        hashMap.put("ar_key", ARConfig.getARKey());
        hashMap.put("ar_type", Integer.valueOf(ARConfig.getARType()));
        hashMap.put("os_version", String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("device_id", this.ha);
        hashMap.put(ARConfigKey.EXTRA_INFO, ARConfig.getARExtraInfo());
        hashMap.put(HttpConstants.HTTP_OS_TYPE, "android");
        hashMap.put(HttpConstants.DEVICE_TYPE, Build.BRAND);
        hashMap.put("channel", this.hb);
        ARPScriptEnvironment.getInstance().setSharedEnvironmentKV(TableDefine.DB_TABLE_USERINFO, hashMap);
    }

    private void bn() {
        HashMap hashMap = new HashMap();
        hashMap.put("android.sensor.gyroscope", this.hc);
        hashMap.put("android.sensor.rotation_vector", this.hd);
        ARPScriptEnvironment.getInstance().setSharedEnvironmentKV("deviceinfo", hashMap);
    }

    public void bl() {
        bm();
        bn();
    }

    public void setDataPipKV(String str, Object obj) {
        ARPScriptEnvironment.getInstance().setDataPipKV(str, obj);
    }
}
