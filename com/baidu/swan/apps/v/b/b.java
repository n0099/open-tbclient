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
    public SwanCoreVersion atu;
    public ExtensionCore atv;
    public long aui;
    public String auk;
    public String axG;
    public String axH;
    public long axI;
    public String axJ;
    public String axK;
    public String axL;
    public String axM;
    public String axN;
    public String axO;
    public String axP;
    public String axQ;
    public String axR;
    public SwanAppBearInfo axS;
    public Bundle axT;
    public String axU;
    public boolean axV;
    public String axW;
    public String axX;
    public String axY;
    public String axZ;
    public int aya = 0;
    public boolean ayb;
    public int ayc;
    public long ayd;
    public long aye;
    public String ayf;
    public JSONObject ayg;
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
        bVar.axG = m.a(intent, "aiapps_app_title");
        bVar.axI = m.a(intent, "aiapps_navigatebar_color", (long) IjkMediaMeta.AV_CH_WIDE_LEFT);
        bVar.axH = m.a(intent, "aiapps_icon_url");
        if (d.I(intent)) {
            bVar.axJ = "1250000000000000";
        } else {
            bVar.axJ = m.a(intent, "aiapps_launch_from");
        }
        bVar.axK = m.a(intent, "aiapps_launch_scheme");
        if (bVar.axK != null) {
            String queryParameter = Uri.parse(bVar.axK).getQueryParameter("_baiduboxapp");
            if (!TextUtils.isEmpty(queryParameter)) {
                try {
                    bVar.ayg = new JSONObject(queryParameter).optJSONObject("ext");
                } catch (JSONException e) {
                    if (com.baidu.swan.apps.b.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
        bVar.axL = m.a(intent, "aiapps_page");
        bVar.axV = m.a(intent, "aiapps_is_debug", true);
        bVar.mDescription = m.a(intent, "aiapps_description");
        bVar.mErrorCode = m.a(intent, "aiapps_error_code", 0);
        bVar.axM = m.a(intent, "aiapps_error_detail");
        bVar.mErrorMsg = m.a(intent, "aiapps_error_msg");
        bVar.axN = m.a(intent, "aiapps_resume_date");
        bVar.axO = m.a(intent, "aiapps_max_swan_version");
        bVar.axP = m.a(intent, "aiapps_min_swan_version");
        bVar.axQ = m.a(intent, "aiapps_service_category");
        bVar.axR = m.a(intent, "aiapps_subject_info");
        bVar.axS = (SwanAppBearInfo) m.c(intent, "aiapps_bear_info");
        bVar.mVersion = m.a(intent, "aiapps_version");
        bVar.axT = m.b(intent, "aiapps_extra_data");
        bVar.axU = m.a(intent, "aiapps_add_click_id");
        bVar.mType = m.a(intent, "aiapps_type", 0);
        bVar.axW = m.a(intent, "aiapps_not_in_history");
        bVar.axX = m.a(intent, "aiapps_app_open_url");
        bVar.axY = m.a(intent, "aiapps_app_download_url");
        bVar.axZ = m.a(intent, "aiapps_app_cur_swan_version");
        bVar.atu = (SwanCoreVersion) m.c(intent, "aiapps_swan_core_version");
        bVar.atv = (ExtensionCore) m.c(intent, "aiapps_extension_core");
        bVar.aui = m.a(intent, "aiapps_app_zip_size", 0L);
        bVar.aya = m.a(intent, "aiapps_app_frame_type", 0);
        bVar.ayb = m.a(intent, "aiapps_app_console_switch", false);
        bVar.auk = m.a(intent, "aiapps_version_code");
        bVar.ayc = m.a(intent, "aiapps_app_launch_flags", 0);
        bVar.orientation = m.a(intent, "ai_launch_app_orientation", 0);
        bVar.ayf = m.a(intent, "remoteDebugUrl");
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
        intent.putExtra("aiapps_app_title", bVar.axG);
        intent.putExtra("aiapps_is_debug", bVar.axV);
        intent.putExtra("aiapps_error_code", bVar.mErrorCode);
        intent.putExtra("aiapps_description", bVar.mDescription);
        intent.putExtra("aiapps_error_detail", bVar.axM);
        intent.putExtra("aiapps_error_msg", bVar.mErrorMsg);
        intent.putExtra("aiapps_resume_date", bVar.axN);
        intent.putExtra("aiapps_max_swan_version", bVar.axO);
        intent.putExtra("aiapps_min_swan_version", bVar.axP);
        intent.putExtra("aiapps_service_category", bVar.axQ);
        intent.putExtra("aiapps_subject_info", bVar.axR);
        if (bVar.axS != null) {
            intent.putExtra("aiapps_bear_info", bVar.axS);
        }
        intent.putExtra("aiapps_extra_data", bVar.axT);
        intent.putExtra("aiapps_add_click_id", bVar.axU);
        intent.putExtra("aiapps_type", bVar.mType);
        intent.putExtra("aiapps_app_frame_type", bVar.aya);
        intent.putExtra("ai_launch_app_orientation", bVar.orientation);
        if (bVar.axI != IjkMediaMeta.AV_CH_WIDE_LEFT) {
            intent.putExtra("aiapps_navigatebar_color", bVar.axI);
        }
        if (!TextUtils.isEmpty(bVar.axH)) {
            intent.putExtra("aiapps_icon_url", bVar.axH);
        }
        if (!TextUtils.isEmpty(bVar.axJ)) {
            intent.putExtra("aiapps_launch_from", bVar.axJ);
        }
        if (!TextUtils.isEmpty(bVar.axK)) {
            intent.putExtra("aiapps_launch_scheme", bVar.axK);
        }
        if (!TextUtils.isEmpty(bVar.axL)) {
            intent.putExtra("aiapps_page", bVar.axL);
        }
        if (!TextUtils.isEmpty(bVar.mVersion)) {
            intent.putExtra("aiapps_version", bVar.mVersion);
        }
        if (!TextUtils.isEmpty(bVar.axW)) {
            intent.putExtra("aiapps_not_in_history", bVar.axW);
        }
        if (!TextUtils.isEmpty(bVar.axX)) {
            intent.putExtra("aiapps_app_open_url", bVar.axX);
        }
        if (!TextUtils.isEmpty(bVar.axY)) {
            intent.putExtra("aiapps_app_download_url", bVar.axY);
        }
        if (bVar.atu != null) {
            intent.putExtra("aiapps_swan_core_version", bVar.atu);
        }
        if (bVar.atv != null) {
            intent.putExtra("aiapps_extension_core", bVar.atv);
        }
        if (bVar.axZ != null) {
            intent.putExtra("aiapps_app_cur_swan_version", bVar.axZ);
        }
        intent.putExtra("aiapps_app_zip_size", bVar.aui);
        intent.putExtra("aiapps_app_console_switch", com.baidu.swan.apps.console.b.dy(bVar.mAppKey));
        if (bVar.auk != null) {
            intent.putExtra("aiapps_version_code", bVar.auk);
        }
        intent.putExtra("remoteDebugUrl", bVar.ayf);
        intent.putExtra("aiapps_app_launch_flags", bVar.ayc);
        return intent;
    }

    public static Intent c(Context context, b bVar) {
        if (context == null || bVar == null) {
            return null;
        }
        Intent intent = new Intent();
        intent.putExtra("aiapps_app_id", bVar.mAppId);
        intent.putExtra("aiapps_app_title", bVar.axG);
        intent.putExtra("aiapps_error_code", bVar.mErrorCode);
        intent.putExtra("aiapps_description", bVar.mDescription);
        intent.putExtra("aiapps_error_detail", bVar.axM);
        intent.putExtra("aiapps_error_msg", bVar.mErrorMsg);
        intent.putExtra("aiapps_resume_date", bVar.axN);
        return intent;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.mAppId);
    }

    public boolean Dz() {
        return (TextUtils.isEmpty(this.mAppId) || TextUtils.isEmpty(this.axG)) ? false : true;
    }

    @NonNull
    public Bundle DA() {
        if (this.axT == null) {
            this.axT = new Bundle();
        }
        return this.axT;
    }

    public void al(String str, String str2) {
        if (str != null && str2 != null) {
            DA().putString(str, str2);
        }
    }

    public String toShortString() {
        return "SwanAppLaunchInfo{mAppId='" + this.mAppId + "', mAppKey='" + this.mAppKey + "', mAppTitle='" + this.axG + "', mLaunchFrom='" + this.axJ + "', mLaunchScheme='" + this.axK + "', mPage='" + this.axL + "', mErrorCode=" + this.mErrorCode + ", mErrorDetail='" + this.axM + "', mErrorMsg='" + this.mErrorMsg + "', mResumeDate='" + this.axN + "', mMaxSwanVersion='" + this.axO + "', mMinSwanVersion='" + this.axP + "', mVersion='" + this.mVersion + "', mType=" + this.mType + ", mExtraData=" + this.axT + ", mIsDebug=" + this.axV + ", mTargetSwanVersion='" + this.axZ + "', mSwanCoreVersion=" + this.atu + ", mAppFrameType=" + this.aya + ", mConsoleSwitch=" + this.ayb + ", orientation=" + this.orientation + ", versionCode='" + this.auk + "', launchFlags=" + this.ayc + ", swanAppStartTime=" + this.ayd + ", extStartTimestamp=" + this.aye + ", mRemoteDebug='" + this.ayf + "', mExtJSonObject=" + this.ayg + '}';
    }

    public static String a(b bVar, com.baidu.swan.apps.ae.a.c cVar) {
        String str = bVar.axL;
        if (!TextUtils.isEmpty(str) && str.startsWith(File.separator)) {
            str = str.substring(1);
        }
        bVar.axL = null;
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
        bVar.axG = "小程序测试";
        bVar.mAppId = "wSfMyKIbrbNg7ogTFTcBuk1P8mgGTlB1";
        bVar.axI = Color.parseColor("#FF308EF0");
        bVar.axJ = "1230000000000000";
        bVar.mDescription = "小程序简介";
        bVar.axQ = "测试服务类目";
        bVar.axR = "测试主体信息";
        bVar.mAppKey = "CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N";
        bVar.mVersion = "1.0";
        bVar.axH = "https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg";
        return bVar;
    }
}
