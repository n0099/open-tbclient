package com.baidu.swan.apps.v.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.SwanAppLauncherActivity;
import com.baidu.swan.apps.an.m;
import com.baidu.swan.apps.an.y;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public final class b {
    public SwanCoreVersion atp;
    public ExtensionCore atq;
    public long aud;
    public String auf;
    public String axC;
    public String axD;
    public long axE;
    public String axF;
    public String axG;
    public String axH;
    public String axI;
    public String axJ;
    public String axK;
    public String axL;
    public String axM;
    public String axN;
    public SwanAppBearInfo axO;
    public Bundle axP;
    public String axQ;
    public boolean axR;
    public String axS;
    public String axT;
    public String axU;
    public String axV;
    public int axW = 0;
    public boolean axX;
    public int axY;
    public long axZ;
    public long aya;
    public String ayb;
    public JSONObject ayc;
    public String mAppId;
    public String mAppKey;
    public String mDescription;
    public int mErrorCode;
    public String mErrorMsg;
    public int mType;
    public String mVersion;
    public int orientation;

    public static b G(Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("intent must not be null.");
        }
        b bVar = new b();
        bVar.mAppId = m.a(intent, "aiapps_app_id");
        bVar.mAppKey = m.a(intent, "aiapps_app_key");
        bVar.axC = m.a(intent, "aiapps_app_title");
        bVar.axE = m.a(intent, "aiapps_navigatebar_color", (long) IjkMediaMeta.AV_CH_WIDE_LEFT);
        bVar.axD = m.a(intent, "aiapps_icon_url");
        if (d.I(intent)) {
            bVar.axF = "1250000000000000";
        } else {
            bVar.axF = m.a(intent, "aiapps_launch_from");
        }
        bVar.axG = m.a(intent, "aiapps_launch_scheme");
        if (bVar.axG != null) {
            String queryParameter = Uri.parse(bVar.axG).getQueryParameter("_baiduboxapp");
            if (!TextUtils.isEmpty(queryParameter)) {
                try {
                    bVar.ayc = new JSONObject(queryParameter).optJSONObject("ext");
                } catch (JSONException e) {
                    if (com.baidu.swan.apps.c.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
        bVar.axH = m.a(intent, "aiapps_page");
        bVar.axR = m.a(intent, "aiapps_is_debug", true);
        bVar.mDescription = m.a(intent, "aiapps_description");
        bVar.mErrorCode = m.a(intent, "aiapps_error_code", 0);
        bVar.axI = m.a(intent, "aiapps_error_detail");
        bVar.mErrorMsg = m.a(intent, "aiapps_error_msg");
        bVar.axJ = m.a(intent, "aiapps_resume_date");
        bVar.axK = m.a(intent, "aiapps_max_swan_version");
        bVar.axL = m.a(intent, "aiapps_min_swan_version");
        bVar.axM = m.a(intent, "aiapps_service_category");
        bVar.axN = m.a(intent, "aiapps_subject_info");
        bVar.axO = (SwanAppBearInfo) m.c(intent, "aiapps_bear_info");
        bVar.mVersion = m.a(intent, "aiapps_version");
        bVar.axP = m.b(intent, "aiapps_extra_data");
        bVar.axQ = m.a(intent, "aiapps_add_click_id");
        bVar.mType = m.a(intent, "aiapps_type", 0);
        bVar.axS = m.a(intent, "aiapps_not_in_history");
        bVar.axT = m.a(intent, "aiapps_app_open_url");
        bVar.axU = m.a(intent, "aiapps_app_download_url");
        bVar.axV = m.a(intent, "aiapps_app_cur_swan_version");
        bVar.atp = (SwanCoreVersion) m.c(intent, "aiapps_swan_core_version");
        bVar.atq = (ExtensionCore) m.c(intent, "aiapps_extension_core");
        bVar.aud = m.a(intent, "aiapps_app_zip_size", 0L);
        bVar.axW = m.a(intent, "aiapps_app_frame_type", 0);
        bVar.axX = m.a(intent, "aiapps_app_console_switch", false);
        bVar.auf = m.a(intent, "aiapps_version_code");
        bVar.axY = m.a(intent, "aiapps_app_launch_flags", 0);
        bVar.orientation = m.a(intent, "ai_launch_app_orientation", 0);
        bVar.ayb = m.a(intent, "remoteDebugUrl");
        return bVar;
    }

    public static Intent b(Context context, b bVar) {
        if (context == null || bVar == null || !bVar.DB()) {
            return null;
        }
        Intent intent = new Intent();
        intent.setAction("com.baidu.searchbox.action.aiapps.LAUNCH");
        intent.setComponent(new ComponentName(context, SwanAppLauncherActivity.class));
        intent.putExtra("aiapps_app_id", bVar.mAppId);
        intent.putExtra("aiapps_app_key", bVar.mAppKey);
        intent.putExtra("aiapps_app_title", bVar.axC);
        intent.putExtra("aiapps_is_debug", bVar.axR);
        intent.putExtra("aiapps_error_code", bVar.mErrorCode);
        intent.putExtra("aiapps_description", bVar.mDescription);
        intent.putExtra("aiapps_error_detail", bVar.axI);
        intent.putExtra("aiapps_error_msg", bVar.mErrorMsg);
        intent.putExtra("aiapps_resume_date", bVar.axJ);
        intent.putExtra("aiapps_max_swan_version", bVar.axK);
        intent.putExtra("aiapps_min_swan_version", bVar.axL);
        intent.putExtra("aiapps_service_category", bVar.axM);
        intent.putExtra("aiapps_subject_info", bVar.axN);
        if (bVar.axO != null) {
            intent.putExtra("aiapps_bear_info", bVar.axO);
        }
        intent.putExtra("aiapps_extra_data", bVar.axP);
        intent.putExtra("aiapps_add_click_id", bVar.axQ);
        intent.putExtra("aiapps_type", bVar.mType);
        intent.putExtra("aiapps_app_frame_type", bVar.axW);
        intent.putExtra("ai_launch_app_orientation", bVar.orientation);
        if (bVar.axE != IjkMediaMeta.AV_CH_WIDE_LEFT) {
            intent.putExtra("aiapps_navigatebar_color", bVar.axE);
        }
        if (!TextUtils.isEmpty(bVar.axD)) {
            intent.putExtra("aiapps_icon_url", bVar.axD);
        }
        if (!TextUtils.isEmpty(bVar.axF)) {
            intent.putExtra("aiapps_launch_from", bVar.axF);
        }
        if (!TextUtils.isEmpty(bVar.axG)) {
            intent.putExtra("aiapps_launch_scheme", bVar.axG);
        }
        if (!TextUtils.isEmpty(bVar.axH)) {
            intent.putExtra("aiapps_page", bVar.axH);
        }
        if (!TextUtils.isEmpty(bVar.mVersion)) {
            intent.putExtra("aiapps_version", bVar.mVersion);
        }
        if (!TextUtils.isEmpty(bVar.axS)) {
            intent.putExtra("aiapps_not_in_history", bVar.axS);
        }
        if (!TextUtils.isEmpty(bVar.axT)) {
            intent.putExtra("aiapps_app_open_url", bVar.axT);
        }
        if (!TextUtils.isEmpty(bVar.axU)) {
            intent.putExtra("aiapps_app_download_url", bVar.axU);
        }
        if (bVar.atp != null) {
            intent.putExtra("aiapps_swan_core_version", bVar.atp);
        }
        if (bVar.atq != null) {
            intent.putExtra("aiapps_extension_core", bVar.atq);
        }
        if (bVar.axV != null) {
            intent.putExtra("aiapps_app_cur_swan_version", bVar.axV);
        }
        intent.putExtra("aiapps_app_zip_size", bVar.aud);
        intent.putExtra("aiapps_app_console_switch", com.baidu.swan.apps.console.b.dw(bVar.mAppKey));
        if (bVar.auf != null) {
            intent.putExtra("aiapps_version_code", bVar.auf);
        }
        intent.putExtra("remoteDebugUrl", bVar.ayb);
        intent.putExtra("aiapps_app_launch_flags", bVar.axY);
        return intent;
    }

    public static Intent c(Context context, b bVar) {
        if (context == null || bVar == null) {
            return null;
        }
        Intent intent = new Intent();
        intent.putExtra("aiapps_app_id", bVar.mAppId);
        intent.putExtra("aiapps_app_title", bVar.axC);
        intent.putExtra("aiapps_error_code", bVar.mErrorCode);
        intent.putExtra("aiapps_description", bVar.mDescription);
        intent.putExtra("aiapps_error_detail", bVar.axI);
        intent.putExtra("aiapps_error_msg", bVar.mErrorMsg);
        intent.putExtra("aiapps_resume_date", bVar.axJ);
        return intent;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.mAppId);
    }

    public boolean DB() {
        return (TextUtils.isEmpty(this.mAppId) || TextUtils.isEmpty(this.axC)) ? false : true;
    }

    @NonNull
    public Bundle DC() {
        if (this.axP == null) {
            this.axP = new Bundle();
        }
        return this.axP;
    }

    public void al(String str, String str2) {
        if (str != null && str2 != null) {
            DC().putString(str, str2);
        }
    }

    public String toShortString() {
        return "SwanAppLaunchInfo{mAppId='" + this.mAppId + "', mAppKey='" + this.mAppKey + "', mAppTitle='" + this.axC + "', mLaunchFrom='" + this.axF + "', mLaunchScheme='" + this.axG + "', mPage='" + this.axH + "', mErrorCode=" + this.mErrorCode + ", mErrorDetail='" + this.axI + "', mErrorMsg='" + this.mErrorMsg + "', mResumeDate='" + this.axJ + "', mMaxSwanVersion='" + this.axK + "', mMinSwanVersion='" + this.axL + "', mVersion='" + this.mVersion + "', mType=" + this.mType + ", mExtraData=" + this.axP + ", mIsDebug=" + this.axR + ", mTargetSwanVersion='" + this.axV + "', mSwanCoreVersion=" + this.atp + ", mAppFrameType=" + this.axW + ", mConsoleSwitch=" + this.axX + ", orientation=" + this.orientation + ", versionCode='" + this.auf + "', launchFlags=" + this.axY + ", swanAppStartTime=" + this.axZ + ", extStartTimestamp=" + this.aya + ", mRemoteDebug='" + this.ayb + "', mExtJSonObject=" + this.ayc + '}';
    }

    public static String a(b bVar, com.baidu.swan.apps.ae.a.c cVar) {
        String str = bVar.axH;
        if (!TextUtils.isEmpty(str) && str.startsWith(File.separator)) {
            str = str.substring(1);
        }
        bVar.axH = null;
        return a(str, cVar);
    }

    private static String a(String str, com.baidu.swan.apps.ae.a.c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return null;
        }
        if (cVar.gm(y.hF(str))) {
            return str;
        }
        return null;
    }

    public static b DD() {
        b bVar = new b();
        bVar.axC = "小程序测试";
        bVar.mAppId = "wSfMyKIbrbNg7ogTFTcBuk1P8mgGTlB1";
        bVar.axE = Color.parseColor("#FF308EF0");
        bVar.axF = "1230000000000000";
        bVar.mDescription = "小程序简介";
        bVar.axM = "测试服务类目";
        bVar.axN = "测试主体信息";
        bVar.mAppKey = "CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N";
        bVar.mVersion = "1.0";
        bVar.axD = "https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg";
        return bVar;
    }
}
