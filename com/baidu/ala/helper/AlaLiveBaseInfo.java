package com.baidu.ala.helper;

import android.os.Build;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaLiveBaseInfo {
    public static final String STREAM_TYPE_RECV = "RECV";
    public static final String STREAM_TYPE_SEND = "SEND";
    public static final String mOSType = "AND";
    public String mAppVer;
    public String mClientIp;
    public String mCuid;
    public String mLiveId;
    public String mNetWork;
    public String mPkId;
    public String mSessionId;
    public int mSessionLine;
    public String mStreamLine;
    public String mStreamType;
    public String mSubAppType;
    public String mUid;
    public static final String mOSModel = Build.MODEL;
    public static final String mOSVer = Build.VERSION.RELEASE;

    public AlaLiveBaseInfo() {
        this.mAppVer = "9.0.0";
        this.mStreamLine = AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT;
    }

    public AlaLiveBaseInfo(String str) {
        this.mAppVer = "9.0.0";
        this.mStreamLine = AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT;
        this.mAppVer = str;
    }

    public String toJsonString() {
        this.mCuid = TbadkCoreApplication.getClientId();
        this.mUid = TbadkCoreApplication.getCurrentAccount();
        this.mNetWork = BdNetTypeUtil.netTypeNameInUpperCase();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("appVer", this.mAppVer == null ? "" : this.mAppVer);
            jSONObject.putOpt("clientIp", this.mClientIp == null ? "" : this.mClientIp);
            jSONObject.putOpt("deviceId", this.mCuid == null ? "" : this.mCuid);
            jSONObject.putOpt("network", this.mNetWork == null ? "" : this.mNetWork);
            jSONObject.putOpt(HttpConstants.HTTP_OS_TYPE_OLD, mOSType == 0 ? "" : mOSType);
            jSONObject.putOpt("osVer", mOSVer == null ? "" : mOSVer);
            jSONObject.putOpt("streamType", this.mStreamType == null ? "" : this.mStreamType);
            jSONObject.putOpt("uid", this.mUid == null ? "" : this.mUid);
            jSONObject.putOpt("liveID", this.mLiveId == null ? "" : this.mLiveId);
            jSONObject.putOpt("model", mOSModel == null ? "" : mOSModel);
            jSONObject.putOpt("streamLine", this.mStreamLine == null ? "" : this.mStreamLine);
            jSONObject.putOpt("sessionLine", Integer.valueOf(this.mSessionLine));
            if (this.mPkId != null && this.mPkId.length() > 0) {
                jSONObject.putOpt("pkID", this.mPkId);
            }
            if (this.mSubAppType != null && this.mSubAppType.length() > 0) {
                jSONObject.put("subApp", this.mSubAppType);
            }
        } catch (Throwable th) {
        }
        return jSONObject.toString();
    }
}
