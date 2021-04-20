package com.baidu.apollon.heartbeat;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.utils.FileCopyUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.LogUtil;
import java.io.File;
import java.io.Serializable;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class HeartBeatCfgEntity implements NoProguard, Serializable {
    public static final String HEART_BEAT_CFG_UNUSE = "0";
    public static final String HEART_BEAT_CFG_USED = "1";
    public static final String TAG = HeartBeatCfgEntity.class.getSimpleName();
    public static final long serialVersionUID = 1;
    public String KA_CFG_TIME;
    public String KA_INIT;
    public String KA_MAX;
    public String KA_SWITCH;
    public String KA_TIMEOUT;

    public static HeartBeatCfgEntity build(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HeartBeatCfgEntity heartBeatCfgEntity = new HeartBeatCfgEntity();
        try {
            JSONObject jSONObject = new JSONObject(str);
            heartBeatCfgEntity.KA_SWITCH = jSONObject.optString("KA_SWITCH");
            heartBeatCfgEntity.KA_INIT = jSONObject.optString("KA_INIT");
            heartBeatCfgEntity.KA_MAX = jSONObject.optString("KA_MAX");
            heartBeatCfgEntity.KA_TIMEOUT = jSONObject.optString("KA_TIMEOUT");
            heartBeatCfgEntity.KA_CFG_TIME = jSONObject.optString("KA_CFG_TIME");
            return heartBeatCfgEntity;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return heartBeatCfgEntity;
        }
    }

    public boolean checkResponseValidity() {
        return TextUtils.equals(this.KA_SWITCH, "0") || TextUtils.equals(this.KA_SWITCH, "1");
    }

    public boolean isUsed() {
        return TextUtils.equals(this.KA_SWITCH, "1");
    }

    public boolean isValidRequestTime(long j) {
        if (TextUtils.isEmpty(this.KA_CFG_TIME)) {
            return false;
        }
        long longValue = Long.valueOf(this.KA_CFG_TIME).longValue();
        if (longValue >= 0) {
            long timeInMillis = Calendar.getInstance().getTimeInMillis() / 1000;
            if (timeInMillis > j + longValue) {
                return true;
            }
            String str = TAG;
            LogUtil.w(str, TAG + " isValidRequestTime currentTime:" + timeInMillis + ", lastTime:" + j + ", cfgTime:" + longValue);
        }
        return false;
    }

    public void storeResponse(Context context) {
        String json = JsonUtils.toJson(this);
        if (!TextUtils.isEmpty(json)) {
            FileCopyUtils.copyToFile(json, new File(context.getCacheDir() + File.separator + a.f3673b));
        }
        c.a(context, c.f3699b, Calendar.getInstance().getTimeInMillis() / 1000);
    }

    public String toString() {
        return " KA_SWITCH:" + this.KA_SWITCH + ",KA_INIT:" + this.KA_INIT + ",KA_MAX:" + this.KA_MAX + ",KA_TIMEOUT:" + this.KA_TIMEOUT + ", KA_CFG_TIME:" + this.KA_CFG_TIME;
    }

    public boolean validate() {
        boolean z = false;
        if (!TextUtils.isEmpty(this.KA_TIMEOUT) && !TextUtils.isEmpty(this.KA_INIT) && !TextUtils.isEmpty(this.KA_MAX) && !TextUtils.isEmpty(this.KA_CFG_TIME)) {
            try {
                int intValue = Integer.valueOf(this.KA_TIMEOUT).intValue();
                int intValue2 = Integer.valueOf(this.KA_INIT).intValue();
                if (intValue > 0 && intValue2 < intValue) {
                    z = true;
                }
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
        }
        if (!z) {
            String str = TAG;
            LogUtil.errord(str, TAG + " validate exception,KA_INIT:" + this.KA_INIT + ", KA_TIMEOUT:" + this.KA_TIMEOUT + ", KA_MAX:" + this.KA_MAX + ", KA_CFG_TIME:" + this.KA_CFG_TIME);
        }
        return z;
    }
}
