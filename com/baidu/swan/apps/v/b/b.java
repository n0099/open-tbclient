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
    public SwanCoreVersion atq;
    public ExtensionCore atr;
    public long aue;
    public String aug;
    public String axD;
    public String axE;
    public long axF;
    public String axG;
    public String axH;
    public String axI;
    public String axJ;
    public String axK;
    public String axL;
    public String axM;
    public String axN;
    public String axO;
    public SwanAppBearInfo axP;
    public Bundle axQ;
    public String axR;
    public boolean axS;
    public String axT;
    public String axU;
    public String axV;
    public String axW;
    public int axX = 0;
    public boolean axY;
    public int axZ;
    public long aya;
    public long ayb;
    public String ayc;
    public JSONObject ayd;
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
        bVar.axD = m.a(intent, "aiapps_app_title");
        bVar.axF = m.a(intent, "aiapps_navigatebar_color", (long) IjkMediaMeta.AV_CH_WIDE_LEFT);
        bVar.axE = m.a(intent, "aiapps_icon_url");
        if (d.I(intent)) {
            bVar.axG = "1250000000000000";
        } else {
            bVar.axG = m.a(intent, "aiapps_launch_from");
        }
        bVar.axH = m.a(intent, "aiapps_launch_scheme");
        if (bVar.axH != null) {
            String queryParameter = Uri.parse(bVar.axH).getQueryParameter("_baiduboxapp");
            if (!TextUtils.isEmpty(queryParameter)) {
                try {
                    bVar.ayd = new JSONObject(queryParameter).optJSONObject("ext");
                } catch (JSONException e) {
                    if (com.baidu.swan.apps.b.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
        bVar.axI = m.a(intent, "aiapps_page");
        bVar.axS = m.a(intent, "aiapps_is_debug", true);
        bVar.mDescription = m.a(intent, "aiapps_description");
        bVar.mErrorCode = m.a(intent, "aiapps_error_code", 0);
        bVar.axJ = m.a(intent, "aiapps_error_detail");
        bVar.mErrorMsg = m.a(intent, "aiapps_error_msg");
        bVar.axK = m.a(intent, "aiapps_resume_date");
        bVar.axL = m.a(intent, "aiapps_max_swan_version");
        bVar.axM = m.a(intent, "aiapps_min_swan_version");
        bVar.axN = m.a(intent, "aiapps_service_category");
        bVar.axO = m.a(intent, "aiapps_subject_info");
        bVar.axP = (SwanAppBearInfo) m.c(intent, "aiapps_bear_info");
        bVar.mVersion = m.a(intent, "aiapps_version");
        bVar.axQ = m.b(intent, "aiapps_extra_data");
        bVar.axR = m.a(intent, "aiapps_add_click_id");
        bVar.mType = m.a(intent, "aiapps_type", 0);
        bVar.axT = m.a(intent, "aiapps_not_in_history");
        bVar.axU = m.a(intent, "aiapps_app_open_url");
        bVar.axV = m.a(intent, "aiapps_app_download_url");
        bVar.axW = m.a(intent, "aiapps_app_cur_swan_version");
        bVar.atq = (SwanCoreVersion) m.c(intent, "aiapps_swan_core_version");
        bVar.atr = (ExtensionCore) m.c(intent, "aiapps_extension_core");
        bVar.aue = m.a(intent, "aiapps_app_zip_size", 0L);
        bVar.axX = m.a(intent, "aiapps_app_frame_type", 0);
        bVar.axY = m.a(intent, "aiapps_app_console_switch", false);
        bVar.aug = m.a(intent, "aiapps_version_code");
        bVar.axZ = m.a(intent, "aiapps_app_launch_flags", 0);
        bVar.orientation = m.a(intent, "ai_launch_app_orientation", 0);
        bVar.ayc = m.a(intent, "remoteDebugUrl");
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
        intent.putExtra("aiapps_app_title", bVar.axD);
        intent.putExtra("aiapps_is_debug", bVar.axS);
        intent.putExtra("aiapps_error_code", bVar.mErrorCode);
        intent.putExtra("aiapps_description", bVar.mDescription);
        intent.putExtra("aiapps_error_detail", bVar.axJ);
        intent.putExtra("aiapps_error_msg", bVar.mErrorMsg);
        intent.putExtra("aiapps_resume_date", bVar.axK);
        intent.putExtra("aiapps_max_swan_version", bVar.axL);
        intent.putExtra("aiapps_min_swan_version", bVar.axM);
        intent.putExtra("aiapps_service_category", bVar.axN);
        intent.putExtra("aiapps_subject_info", bVar.axO);
        if (bVar.axP != null) {
            intent.putExtra("aiapps_bear_info", bVar.axP);
        }
        intent.putExtra("aiapps_extra_data", bVar.axQ);
        intent.putExtra("aiapps_add_click_id", bVar.axR);
        intent.putExtra("aiapps_type", bVar.mType);
        intent.putExtra("aiapps_app_frame_type", bVar.axX);
        intent.putExtra("ai_launch_app_orientation", bVar.orientation);
        if (bVar.axF != IjkMediaMeta.AV_CH_WIDE_LEFT) {
            intent.putExtra("aiapps_navigatebar_color", bVar.axF);
        }
        if (!TextUtils.isEmpty(bVar.axE)) {
            intent.putExtra("aiapps_icon_url", bVar.axE);
        }
        if (!TextUtils.isEmpty(bVar.axG)) {
            intent.putExtra("aiapps_launch_from", bVar.axG);
        }
        if (!TextUtils.isEmpty(bVar.axH)) {
            intent.putExtra("aiapps_launch_scheme", bVar.axH);
        }
        if (!TextUtils.isEmpty(bVar.axI)) {
            intent.putExtra("aiapps_page", bVar.axI);
        }
        if (!TextUtils.isEmpty(bVar.mVersion)) {
            intent.putExtra("aiapps_version", bVar.mVersion);
        }
        if (!TextUtils.isEmpty(bVar.axT)) {
            intent.putExtra("aiapps_not_in_history", bVar.axT);
        }
        if (!TextUtils.isEmpty(bVar.axU)) {
            intent.putExtra("aiapps_app_open_url", bVar.axU);
        }
        if (!TextUtils.isEmpty(bVar.axV)) {
            intent.putExtra("aiapps_app_download_url", bVar.axV);
        }
        if (bVar.atq != null) {
            intent.putExtra("aiapps_swan_core_version", bVar.atq);
        }
        if (bVar.atr != null) {
            intent.putExtra("aiapps_extension_core", bVar.atr);
        }
        if (bVar.axW != null) {
            intent.putExtra("aiapps_app_cur_swan_version", bVar.axW);
        }
        intent.putExtra("aiapps_app_zip_size", bVar.aue);
        intent.putExtra("aiapps_app_console_switch", com.baidu.swan.apps.console.b.dw(bVar.mAppKey));
        if (bVar.aug != null) {
            intent.putExtra("aiapps_version_code", bVar.aug);
        }
        intent.putExtra("remoteDebugUrl", bVar.ayc);
        intent.putExtra("aiapps_app_launch_flags", bVar.axZ);
        return intent;
    }

    public static Intent c(Context context, b bVar) {
        if (context == null || bVar == null) {
            return null;
        }
        Intent intent = new Intent();
        intent.putExtra("aiapps_app_id", bVar.mAppId);
        intent.putExtra("aiapps_app_title", bVar.axD);
        intent.putExtra("aiapps_error_code", bVar.mErrorCode);
        intent.putExtra("aiapps_description", bVar.mDescription);
        intent.putExtra("aiapps_error_detail", bVar.axJ);
        intent.putExtra("aiapps_error_msg", bVar.mErrorMsg);
        intent.putExtra("aiapps_resume_date", bVar.axK);
        return intent;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.mAppId);
    }

    public boolean DB() {
        return (TextUtils.isEmpty(this.mAppId) || TextUtils.isEmpty(this.axD)) ? false : true;
    }

    @NonNull
    public Bundle DC() {
        if (this.axQ == null) {
            this.axQ = new Bundle();
        }
        return this.axQ;
    }

    public void al(String str, String str2) {
        if (str != null && str2 != null) {
            DC().putString(str, str2);
        }
    }

    public String toShortString() {
        return "SwanAppLaunchInfo{mAppId='" + this.mAppId + "', mAppKey='" + this.mAppKey + "', mAppTitle='" + this.axD + "', mLaunchFrom='" + this.axG + "', mLaunchScheme='" + this.axH + "', mPage='" + this.axI + "', mErrorCode=" + this.mErrorCode + ", mErrorDetail='" + this.axJ + "', mErrorMsg='" + this.mErrorMsg + "', mResumeDate='" + this.axK + "', mMaxSwanVersion='" + this.axL + "', mMinSwanVersion='" + this.axM + "', mVersion='" + this.mVersion + "', mType=" + this.mType + ", mExtraData=" + this.axQ + ", mIsDebug=" + this.axS + ", mTargetSwanVersion='" + this.axW + "', mSwanCoreVersion=" + this.atq + ", mAppFrameType=" + this.axX + ", mConsoleSwitch=" + this.axY + ", orientation=" + this.orientation + ", versionCode='" + this.aug + "', launchFlags=" + this.axZ + ", swanAppStartTime=" + this.aya + ", extStartTimestamp=" + this.ayb + ", mRemoteDebug='" + this.ayc + "', mExtJSonObject=" + this.ayd + '}';
    }

    public static String a(b bVar, com.baidu.swan.apps.ae.a.c cVar) {
        String str = bVar.axI;
        if (!TextUtils.isEmpty(str) && str.startsWith(File.separator)) {
            str = str.substring(1);
        }
        bVar.axI = null;
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
        bVar.axD = "小程序测试";
        bVar.mAppId = "wSfMyKIbrbNg7ogTFTcBuk1P8mgGTlB1";
        bVar.axF = Color.parseColor("#FF308EF0");
        bVar.axG = "1230000000000000";
        bVar.mDescription = "小程序简介";
        bVar.axN = "测试服务类目";
        bVar.axO = "测试主体信息";
        bVar.mAppKey = "CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N";
        bVar.mVersion = "1.0";
        bVar.axE = "https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg";
        return bVar;
    }
}
