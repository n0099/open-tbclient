package com.baidu.adp.lib.stats;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BdStatSwitchData implements Serializable {
    private static final long serialVersionUID = -4426491450548432115L;
    private BdStatFirstSwitchData error;
    private String mAppVersion;
    private int uploadInterval;
    private long specifiedExpired = 0;
    private int error_code = -1;
    private String error_msg = null;
    private BdStatFirstSwitchData debug = new BdStatFirstSwitchData();
    private BdStatFirstSwitchData stat = new BdStatFirstSwitchData();

    public BdStatSwitchData() {
        this.uploadInterval = 0;
        this.uploadInterval = 3600;
        this.stat.getCommon().setIs_only_wifi(false);
        this.stat.getCommon().setIs_open(true);
        this.stat.getCommon().setIs_exact(true);
        this.error = new BdStatFirstSwitchData();
        this.error.getCommon().setIs_only_wifi(false);
        this.error.getCommon().setIs_open(true);
        this.error.getCommon().setIs_exact(false);
    }

    public int getError_code() {
        return this.error_code;
    }

    public void setError_code(int i) {
        this.error_code = i;
    }

    public String getError_msg() {
        return this.error_msg;
    }

    public void setError_msg(String str) {
        this.error_msg = str;
    }

    public BdStatFirstSwitchData getDebug() {
        return this.debug;
    }

    public void setDebug(BdStatFirstSwitchData bdStatFirstSwitchData) {
        this.debug = bdStatFirstSwitchData;
    }

    public BdStatFirstSwitchData getStat() {
        return this.stat;
    }

    public void setStat(BdStatFirstSwitchData bdStatFirstSwitchData) {
        this.stat = bdStatFirstSwitchData;
    }

    public BdStatFirstSwitchData getError() {
        return this.error;
    }

    public void setError(BdStatFirstSwitchData bdStatFirstSwitchData) {
        this.error = bdStatFirstSwitchData;
    }

    public int getUploadInterval() {
        return this.uploadInterval;
    }

    public int getUploadMilliInterval() {
        return this.uploadInterval * 1000;
    }

    public void setUploadInterval(int i) {
        this.uploadInterval = i;
    }

    public long getSpecifiedExpired() {
        return this.specifiedExpired;
    }

    public void setSpecifiedExpired(long j) {
        this.specifiedExpired = j;
    }

    public boolean inSpecStrategy() {
        return this.specifiedExpired > System.currentTimeMillis();
    }

    public String getAppVersion() {
        return this.mAppVersion;
    }

    public void setAppVersion(String str) {
        this.mAppVersion = str;
    }

    public void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                a(new JSONObject(str));
            } catch (Exception e) {
                BdLog.e(getClass(), "parserJson", e);
            }
        }
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                setError_code(jSONObject.optInt("error_code", 0));
                setError_msg(jSONObject.optString("error_code"));
                int optInt = jSONObject.optInt("upload_interval", 0);
                if (optInt > 0) {
                    setUploadInterval(optInt);
                }
                long optInt2 = jSONObject.optInt("expire", 0);
                if (optInt2 > 0) {
                    setSpecifiedExpired((optInt2 * 1000) + System.currentTimeMillis());
                } else {
                    setSpecifiedExpired(0L);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null) {
                    this.debug.setAppVersion(this.mAppVersion);
                    this.stat.setAppVersion(this.mAppVersion);
                    this.error.setAppVersion(this.mAppVersion);
                    this.debug.parserJson(optJSONObject.optJSONArray("debug"));
                    this.stat.parserJson(optJSONObject.optJSONArray("stat"));
                    this.error.parserJson(optJSONObject.optJSONArray("error"));
                }
            } catch (Exception e) {
                BdLog.e(getClass(), "parserJson", e);
            }
        }
    }
}
