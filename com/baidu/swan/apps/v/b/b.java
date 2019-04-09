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
    public SwanCoreVersion atv;
    public ExtensionCore atw;
    public long auj;
    public String aul;
    public String axH;
    public String axI;
    public long axJ;
    public String axK;
    public String axL;
    public String axM;
    public String axN;
    public String axO;
    public String axP;
    public String axQ;
    public String axR;
    public String axS;
    public SwanAppBearInfo axT;
    public Bundle axU;
    public String axV;
    public boolean axW;
    public String axX;
    public String axY;
    public String axZ;
    public String aya;
    public int ayb = 0;
    public boolean ayc;
    public int ayd;
    public long aye;
    public long ayf;
    public String ayg;
    public JSONObject ayh;
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
        bVar.axH = m.a(intent, "aiapps_app_title");
        bVar.axJ = m.a(intent, "aiapps_navigatebar_color", (long) IjkMediaMeta.AV_CH_WIDE_LEFT);
        bVar.axI = m.a(intent, "aiapps_icon_url");
        if (d.I(intent)) {
            bVar.axK = "1250000000000000";
        } else {
            bVar.axK = m.a(intent, "aiapps_launch_from");
        }
        bVar.axL = m.a(intent, "aiapps_launch_scheme");
        if (bVar.axL != null) {
            String queryParameter = Uri.parse(bVar.axL).getQueryParameter("_baiduboxapp");
            if (!TextUtils.isEmpty(queryParameter)) {
                try {
                    bVar.ayh = new JSONObject(queryParameter).optJSONObject("ext");
                } catch (JSONException e) {
                    if (com.baidu.swan.apps.b.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
        bVar.axM = m.a(intent, "aiapps_page");
        bVar.axW = m.a(intent, "aiapps_is_debug", true);
        bVar.mDescription = m.a(intent, "aiapps_description");
        bVar.mErrorCode = m.a(intent, "aiapps_error_code", 0);
        bVar.axN = m.a(intent, "aiapps_error_detail");
        bVar.mErrorMsg = m.a(intent, "aiapps_error_msg");
        bVar.axO = m.a(intent, "aiapps_resume_date");
        bVar.axP = m.a(intent, "aiapps_max_swan_version");
        bVar.axQ = m.a(intent, "aiapps_min_swan_version");
        bVar.axR = m.a(intent, "aiapps_service_category");
        bVar.axS = m.a(intent, "aiapps_subject_info");
        bVar.axT = (SwanAppBearInfo) m.c(intent, "aiapps_bear_info");
        bVar.mVersion = m.a(intent, "aiapps_version");
        bVar.axU = m.b(intent, "aiapps_extra_data");
        bVar.axV = m.a(intent, "aiapps_add_click_id");
        bVar.mType = m.a(intent, "aiapps_type", 0);
        bVar.axX = m.a(intent, "aiapps_not_in_history");
        bVar.axY = m.a(intent, "aiapps_app_open_url");
        bVar.axZ = m.a(intent, "aiapps_app_download_url");
        bVar.aya = m.a(intent, "aiapps_app_cur_swan_version");
        bVar.atv = (SwanCoreVersion) m.c(intent, "aiapps_swan_core_version");
        bVar.atw = (ExtensionCore) m.c(intent, "aiapps_extension_core");
        bVar.auj = m.a(intent, "aiapps_app_zip_size", 0L);
        bVar.ayb = m.a(intent, "aiapps_app_frame_type", 0);
        bVar.ayc = m.a(intent, "aiapps_app_console_switch", false);
        bVar.aul = m.a(intent, "aiapps_version_code");
        bVar.ayd = m.a(intent, "aiapps_app_launch_flags", 0);
        bVar.orientation = m.a(intent, "ai_launch_app_orientation", 0);
        bVar.ayg = m.a(intent, "remoteDebugUrl");
        return bVar;
    }

    public static Intent b(Context context, b bVar) {
        if (context == null || bVar == null || !bVar.Dz()) {
            return null;
        }
        Intent intent = new Intent();
        intent.setAction("com.baidu.searchbox.action.aiapps.LAUNCH");
        intent.setComponent(new ComponentName(context, SwanAppLauncherActivity.class));
        intent.putExtra("aiapps_app_id", bVar.mAppId);
        intent.putExtra("aiapps_app_key", bVar.mAppKey);
        intent.putExtra("aiapps_app_title", bVar.axH);
        intent.putExtra("aiapps_is_debug", bVar.axW);
        intent.putExtra("aiapps_error_code", bVar.mErrorCode);
        intent.putExtra("aiapps_description", bVar.mDescription);
        intent.putExtra("aiapps_error_detail", bVar.axN);
        intent.putExtra("aiapps_error_msg", bVar.mErrorMsg);
        intent.putExtra("aiapps_resume_date", bVar.axO);
        intent.putExtra("aiapps_max_swan_version", bVar.axP);
        intent.putExtra("aiapps_min_swan_version", bVar.axQ);
        intent.putExtra("aiapps_service_category", bVar.axR);
        intent.putExtra("aiapps_subject_info", bVar.axS);
        if (bVar.axT != null) {
            intent.putExtra("aiapps_bear_info", bVar.axT);
        }
        intent.putExtra("aiapps_extra_data", bVar.axU);
        intent.putExtra("aiapps_add_click_id", bVar.axV);
        intent.putExtra("aiapps_type", bVar.mType);
        intent.putExtra("aiapps_app_frame_type", bVar.ayb);
        intent.putExtra("ai_launch_app_orientation", bVar.orientation);
        if (bVar.axJ != IjkMediaMeta.AV_CH_WIDE_LEFT) {
            intent.putExtra("aiapps_navigatebar_color", bVar.axJ);
        }
        if (!TextUtils.isEmpty(bVar.axI)) {
            intent.putExtra("aiapps_icon_url", bVar.axI);
        }
        if (!TextUtils.isEmpty(bVar.axK)) {
            intent.putExtra("aiapps_launch_from", bVar.axK);
        }
        if (!TextUtils.isEmpty(bVar.axL)) {
            intent.putExtra("aiapps_launch_scheme", bVar.axL);
        }
        if (!TextUtils.isEmpty(bVar.axM)) {
            intent.putExtra("aiapps_page", bVar.axM);
        }
        if (!TextUtils.isEmpty(bVar.mVersion)) {
            intent.putExtra("aiapps_version", bVar.mVersion);
        }
        if (!TextUtils.isEmpty(bVar.axX)) {
            intent.putExtra("aiapps_not_in_history", bVar.axX);
        }
        if (!TextUtils.isEmpty(bVar.axY)) {
            intent.putExtra("aiapps_app_open_url", bVar.axY);
        }
        if (!TextUtils.isEmpty(bVar.axZ)) {
            intent.putExtra("aiapps_app_download_url", bVar.axZ);
        }
        if (bVar.atv != null) {
            intent.putExtra("aiapps_swan_core_version", bVar.atv);
        }
        if (bVar.atw != null) {
            intent.putExtra("aiapps_extension_core", bVar.atw);
        }
        if (bVar.aya != null) {
            intent.putExtra("aiapps_app_cur_swan_version", bVar.aya);
        }
        intent.putExtra("aiapps_app_zip_size", bVar.auj);
        intent.putExtra("aiapps_app_console_switch", com.baidu.swan.apps.console.b.dy(bVar.mAppKey));
        if (bVar.aul != null) {
            intent.putExtra("aiapps_version_code", bVar.aul);
        }
        intent.putExtra("remoteDebugUrl", bVar.ayg);
        intent.putExtra("aiapps_app_launch_flags", bVar.ayd);
        return intent;
    }

    public static Intent c(Context context, b bVar) {
        if (context == null || bVar == null) {
            return null;
        }
        Intent intent = new Intent();
        intent.putExtra("aiapps_app_id", bVar.mAppId);
        intent.putExtra("aiapps_app_title", bVar.axH);
        intent.putExtra("aiapps_error_code", bVar.mErrorCode);
        intent.putExtra("aiapps_description", bVar.mDescription);
        intent.putExtra("aiapps_error_detail", bVar.axN);
        intent.putExtra("aiapps_error_msg", bVar.mErrorMsg);
        intent.putExtra("aiapps_resume_date", bVar.axO);
        return intent;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.mAppId);
    }

    public boolean Dz() {
        return (TextUtils.isEmpty(this.mAppId) || TextUtils.isEmpty(this.axH)) ? false : true;
    }

    @NonNull
    public Bundle DA() {
        if (this.axU == null) {
            this.axU = new Bundle();
        }
        return this.axU;
    }

    public void al(String str, String str2) {
        if (str != null && str2 != null) {
            DA().putString(str, str2);
        }
    }

    public String toShortString() {
        return "SwanAppLaunchInfo{mAppId='" + this.mAppId + "', mAppKey='" + this.mAppKey + "', mAppTitle='" + this.axH + "', mLaunchFrom='" + this.axK + "', mLaunchScheme='" + this.axL + "', mPage='" + this.axM + "', mErrorCode=" + this.mErrorCode + ", mErrorDetail='" + this.axN + "', mErrorMsg='" + this.mErrorMsg + "', mResumeDate='" + this.axO + "', mMaxSwanVersion='" + this.axP + "', mMinSwanVersion='" + this.axQ + "', mVersion='" + this.mVersion + "', mType=" + this.mType + ", mExtraData=" + this.axU + ", mIsDebug=" + this.axW + ", mTargetSwanVersion='" + this.aya + "', mSwanCoreVersion=" + this.atv + ", mAppFrameType=" + this.ayb + ", mConsoleSwitch=" + this.ayc + ", orientation=" + this.orientation + ", versionCode='" + this.aul + "', launchFlags=" + this.ayd + ", swanAppStartTime=" + this.aye + ", extStartTimestamp=" + this.ayf + ", mRemoteDebug='" + this.ayg + "', mExtJSonObject=" + this.ayh + '}';
    }

    public static String a(b bVar, com.baidu.swan.apps.ae.a.c cVar) {
        String str = bVar.axM;
        if (!TextUtils.isEmpty(str) && str.startsWith(File.separator)) {
            str = str.substring(1);
        }
        bVar.axM = null;
        return a(str, cVar);
    }

    private static String a(String str, com.baidu.swan.apps.ae.a.c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return null;
        }
        if (cVar.gn(y.hG(str))) {
            return str;
        }
        return null;
    }

    public static b DB() {
        b bVar = new b();
        bVar.axH = "小程序测试";
        bVar.mAppId = "wSfMyKIbrbNg7ogTFTcBuk1P8mgGTlB1";
        bVar.axJ = Color.parseColor("#FF308EF0");
        bVar.axK = "1230000000000000";
        bVar.mDescription = "小程序简介";
        bVar.axR = "测试服务类目";
        bVar.axS = "测试主体信息";
        bVar.mAppKey = "CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N";
        bVar.mVersion = "1.0";
        bVar.axI = "https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg";
        return bVar;
    }
}
