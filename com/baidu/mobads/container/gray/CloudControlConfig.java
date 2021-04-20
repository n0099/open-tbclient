package com.baidu.mobads.container.gray;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.XAdSDKRemoteVersion;
import com.baidu.mobads.container.util.APKStateManager;
import com.baidu.mobads.container.util.Base64;
import com.baidu.mobads.container.util.SPUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CloudControlConfig {
    public static final String TAG = "com.baidu.mobads.container.gray.CloudControlConfig";
    public static volatile CloudControlConfig mSingleton;
    public JSONObject configJson;
    public double inAvailableVersion;
    public JSONArray inAvailableVersionArray;
    public Context mContext;
    public String mSPName = "baidu_cloudControlConfig";
    public AvailablePKType availablePKType = AvailablePKType.AVAILABLE_PK_TYPE_GRAY;

    /* loaded from: classes2.dex */
    public enum AvailablePKType {
        AVAILABLE_PK_TYPE_GRAY(1),
        AVAILABLE_PK_TYPE_ASSETS(2),
        AVAILABLE_PK_TYPE_SPECIAL(3);
        
        public int value;

        AvailablePKType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public CloudControlConfig(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static CloudControlConfig getInstance(Context context) {
        if (mSingleton == null) {
            synchronized (CloudControlConfig.class) {
                if (mSingleton == null) {
                    mSingleton = new CloudControlConfig(context);
                }
            }
        }
        return mSingleton;
    }

    public int getAvailablePKType() {
        AvailablePKType availablePKType = this.availablePKType;
        if (availablePKType == null) {
            try {
                return new SPUtils(this.mContext, this.mSPName).getInt("baidu_cloudConfig_pktype", 1);
            } catch (Throwable th) {
                th.printStackTrace();
                return 1;
            }
        }
        return availablePKType.getValue();
    }

    public String getValueForKey(String str) {
        try {
            if (this.configJson == null) {
                this.configJson = new JSONObject(new SPUtils(this.mContext, this.mSPName).getString("baidu_cloudConfig", ""));
            }
            if (this.configJson != null) {
                return this.configJson.getString(str);
            }
            return null;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public boolean isInAvailableVersion(double d2) {
        double parseDouble;
        try {
            try {
                if (this.inAvailableVersionArray == null) {
                    String string = new SPUtils(this.mContext, this.mSPName).getString("baidu_cloudConfig_v", "");
                    if (!TextUtils.isEmpty(string)) {
                        this.inAvailableVersionArray = new JSONArray(string);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (this.inAvailableVersionArray == null) {
            return false;
        }
        if (d2 == this.inAvailableVersion) {
            return true;
        }
        for (int i = 0; i < this.inAvailableVersionArray.length(); i++) {
            try {
                parseDouble = Double.parseDouble(this.inAvailableVersionArray.getString(i));
                this.inAvailableVersion = parseDouble;
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            if (d2 == parseDouble) {
                return true;
            }
        }
        return false;
    }

    public void setCloudConfigInfo(String str) {
        String str2;
        String str3;
        JSONArray optJSONArray;
        SPUtils sPUtils = new SPUtils(this.mContext, this.mSPName);
        String str4 = "";
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String decodeStr = Base64.decodeStr(jSONObject.optString("config"));
                if (decodeStr != null) {
                    this.configJson = new JSONObject(decodeStr);
                }
                if (this.configJson == null || (optJSONArray = this.configJson.optJSONArray("inavailable_v")) == null) {
                    str3 = "";
                } else {
                    this.inAvailableVersionArray = optJSONArray;
                    setVersionFallback(jSONObject.optDouble("version"));
                    this.configJson.remove(APKStateManager.KEY_JSON_CONFIG_PKG_LIST);
                    str3 = this.configJson.toString();
                    try {
                        if (this.inAvailableVersionArray != null) {
                            str4 = this.inAvailableVersionArray.toString();
                        }
                    } catch (JSONException e2) {
                        str2 = str3;
                        e = e2;
                        e.printStackTrace();
                        sPUtils.putString("baidu_cloudConfig_v", str4);
                        sPUtils.putString("baidu_cloudConfig", str2);
                        sPUtils.putInt("baidu_cloudConfig_pktype", this.availablePKType.getValue());
                    } catch (Throwable th) {
                        str2 = str3;
                        th = th;
                        th.printStackTrace();
                        sPUtils.putString("baidu_cloudConfig_v", str4);
                        sPUtils.putString("baidu_cloudConfig", str2);
                        sPUtils.putInt("baidu_cloudConfig_pktype", this.availablePKType.getValue());
                    }
                }
                str2 = str3;
            } catch (JSONException e3) {
                e = e3;
                str2 = "";
            } catch (Throwable th2) {
                th = th2;
                str2 = "";
            }
        } else {
            str2 = "";
        }
        sPUtils.putString("baidu_cloudConfig_v", str4);
        sPUtils.putString("baidu_cloudConfig", str2);
        sPUtils.putInt("baidu_cloudConfig_pktype", this.availablePKType.getValue());
    }

    public void setVersionFallback(double d2) {
        if (this.inAvailableVersionArray == null) {
            return;
        }
        try {
            double runningVersion = RemoteVersionUtil.getInstance(this.mContext).getRunningVersion();
            String str = "";
            String str2 = runningVersion == 0.0d ? "" : "" + runningVersion;
            double downloadedVersion = RemoteVersionUtil.getInstance(this.mContext).getDownloadedVersion();
            if (downloadedVersion != 0.0d) {
                str = "" + downloadedVersion;
            }
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            for (int i = 0; i < this.inAvailableVersionArray.length(); i++) {
                String string = this.inAvailableVersionArray.getString(i);
                if (XAdSDKRemoteVersion.getVersion() == Double.valueOf(string).doubleValue()) {
                    this.inAvailableVersion = Double.valueOf(string).doubleValue();
                }
                if (!TextUtils.isEmpty(str2) && string.equals(str2)) {
                    z = true;
                }
                if ((!TextUtils.isEmpty(str) && string.equals(str)) || TextUtils.isEmpty(str)) {
                    z2 = true;
                }
                if (d2 == Double.valueOf(string).doubleValue() || d2 <= runningVersion) {
                    z3 = true;
                }
            }
            if (z && z2 && z3) {
                this.availablePKType = AvailablePKType.AVAILABLE_PK_TYPE_ASSETS;
            } else {
                this.availablePKType = AvailablePKType.AVAILABLE_PK_TYPE_GRAY;
            }
        } catch (Throwable unused) {
        }
    }
}
