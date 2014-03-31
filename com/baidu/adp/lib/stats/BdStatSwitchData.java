package com.baidu.adp.lib.stats;

import android.text.TextUtils;
import com.baidu.location.LocationClientOption;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BdStatSwitchData implements Serializable {
    private static final long serialVersionUID = -4426491450548432115L;
    private int uploadInterval;
    private int error_code = -1;
    private String error_msg = null;
    private BdStatFirstSwitchData debug = new BdStatFirstSwitchData();
    private BdStatFirstSwitchData stat = new BdStatFirstSwitchData();
    private BdStatFirstSwitchData error = new BdStatFirstSwitchData();

    public BdStatSwitchData() {
        this.uploadInterval = 0;
        this.uploadInterval = 3600;
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
        return this.uploadInterval * LocationClientOption.MIN_SCAN_SPAN;
    }

    public void setUploadInterval(int i) {
        this.uploadInterval = i;
    }

    public void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.a(getClass(), "parserJson", e);
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                setError_code(jSONObject.optInt("error_code", 0));
                setError_msg(jSONObject.optString("error_code"));
                int optInt = jSONObject.optInt("upload_interval", 0);
                if (optInt > 0) {
                    setUploadInterval(optInt);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null) {
                    this.debug.parserJson(optJSONObject.optJSONObject("debug"));
                    this.stat.parserJson(optJSONObject.optJSONObject("stat"));
                    this.error.parserJson(optJSONObject.optJSONObject("error"));
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.a(getClass(), "parserJson", e);
            }
        }
    }
}
