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
/* loaded from: classes3.dex */
public class a {
    private String gO;
    private String gP;
    private String gQ;
    private String gR;

    public a(Context context) {
        this.gQ = "0";
        this.gR = "0";
        this.gO = new com.baidu.ar.f.e(context).eV().toString();
        this.gP = com.baidu.ar.f.c.o(context);
        for (Sensor sensor : ((SensorManager) context.getSystemService("sensor")).getSensorList(-1)) {
            if (sensor.getType() == 4) {
                this.gQ = "1";
            }
            if (sensor.getType() == 11) {
                this.gR = "1";
            }
        }
    }

    private void aY() {
        HashMap hashMap = new HashMap();
        hashMap.put("app_version", String.valueOf(com.baidu.ar.f.c.getVersionCode()));
        hashMap.put("ar_key", ARConfig.getARKey());
        hashMap.put("ar_type", Integer.valueOf(ARConfig.getARType()));
        hashMap.put("os_version", String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("device_id", this.gO);
        hashMap.put(ARConfigKey.EXTRA_INFO, ARConfig.getARExtraInfo());
        hashMap.put(HttpConstants.HTTP_OS_TYPE, "android");
        hashMap.put(HttpConstants.DEVICE_TYPE, Build.BRAND);
        hashMap.put("channel", this.gP);
        ARPScriptEnvironment.getInstance().setSharedEnvironmentKV(TableDefine.DB_TABLE_USERINFO, hashMap);
    }

    private void aZ() {
        HashMap hashMap = new HashMap();
        hashMap.put("android.sensor.gyroscope", this.gQ);
        hashMap.put("android.sensor.rotation_vector", this.gR);
        ARPScriptEnvironment.getInstance().setSharedEnvironmentKV("deviceinfo", hashMap);
    }

    public void aX() {
        aY();
        aZ();
    }

    public void setDataPipKV(String str, Object obj) {
        ARPScriptEnvironment.getInstance().setDataPipKV(str, obj);
    }
}
