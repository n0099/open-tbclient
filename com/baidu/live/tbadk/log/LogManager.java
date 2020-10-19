package com.baidu.live.tbadk.log;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.log.bdimpl.MobileBaiduFeedDiversionLogger;
import com.baidu.live.tbadk.log.defimpl.DefalutYuyinLiveLogger;
import com.baidu.live.tbadk.log.defimpl.DefaultCommonLogger;
import com.baidu.live.tbadk.log.defimpl.DefaultFeedDiversionLogger;
import com.baidu.live.tbadk.log.defimpl.DefaultFirstChargeLogger;
import com.baidu.live.tbadk.log.defimpl.DefaultGiftLogger;
import com.baidu.live.tbadk.log.defimpl.DefaultGuardClubLogger;
import com.baidu.live.tbadk.log.defimpl.DefaultLiveCloseLogger;
import com.baidu.live.tbadk.log.defimpl.DefaultLiveGoodsLogger;
import com.baidu.live.tbadk.log.defimpl.DefaultLiveIMLogger;
import com.baidu.live.tbadk.log.defimpl.DefaultLiveRecordLogger;
import com.baidu.live.tbadk.log.defimpl.DefaultMigrateFromTiebaLogger;
import com.baidu.live.tbadk.log.defimpl.DefaultYuanPackageLogger;
import com.baidu.live.tbadk.log.hkimpl.HaokanCommonLogger;
import com.baidu.live.tbadk.log.hkimpl.HaokanFirstChargeLogger;
import com.baidu.live.tbadk.log.hkimpl.HaokanGiftLogger;
import com.baidu.live.tbadk.log.hkimpl.HaokanGuardClubLogger;
import com.baidu.live.tbadk.log.hkimpl.HaokanLiveCloseLogger;
import com.baidu.live.tbadk.log.hkimpl.HaokanLiveGoodsLogger;
import com.baidu.live.tbadk.log.hkimpl.HaokanLiveIMLogger;
import com.baidu.live.tbadk.log.hkimpl.HaokanLiveRecordLogger;
import com.baidu.live.tbadk.log.hkimpl.HaokanYuanPackageLogger;
import com.baidu.live.tbadk.log.qmimpl.QuanminCommonLogger;
import com.baidu.live.tbadk.log.qmimpl.QuanminFirstChargeLogger;
import com.baidu.live.tbadk.log.qmimpl.QuanminGiftLogger;
import com.baidu.live.tbadk.log.qmimpl.QuanminGuardClubLogger;
import com.baidu.live.tbadk.log.qmimpl.QuanminLiveCloseLogger;
import com.baidu.live.tbadk.log.qmimpl.QuanminLiveGoodsLogger;
import com.baidu.live.tbadk.log.qmimpl.QuanminLiveIMLogger;
import com.baidu.live.tbadk.log.qmimpl.QuanminLiveRecordLogger;
import com.baidu.live.tbadk.log.qmimpl.QuanminYuanPackageLogger;
import com.baidu.live.tbadk.log.qmimpl.QuanminYuyinLiveLogger;
import com.baidu.live.tbadk.log.tbimpl.TiebaMigrateFromTiebaLogger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LogManager {
    public static ICommonLogger getCommonLogger() {
        if (TbadkCoreApplication.getInst().isHaokan()) {
            return new HaokanCommonLogger();
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            return new QuanminCommonLogger();
        }
        return new DefaultCommonLogger();
    }

    public static ILiveCloseLogger getLiveCloseLogger() {
        if (TbadkCoreApplication.getInst().isHaokan()) {
            return new HaokanLiveCloseLogger();
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            return new QuanminLiveCloseLogger();
        }
        return new DefaultLiveCloseLogger();
    }

    public static IYuanPackageLogger getYuanPackageLogger() {
        if (TbadkCoreApplication.getInst().isHaokan()) {
            return new HaokanYuanPackageLogger();
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            return new QuanminYuanPackageLogger();
        }
        return new DefaultYuanPackageLogger();
    }

    public static IGuardClubLogger getGuardClubLogger() {
        if (TbadkCoreApplication.getInst().isHaokan()) {
            return new HaokanGuardClubLogger();
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            return new QuanminGuardClubLogger();
        }
        return new DefaultGuardClubLogger();
    }

    public static IGiftLogger getGiftLogger() {
        if (TbadkCoreApplication.getInst().isHaokan()) {
            return new HaokanGiftLogger();
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            return new QuanminGiftLogger();
        }
        return new DefaultGiftLogger();
    }

    public static IYuyinLiveLogger getYuyinLiveLogger() {
        return TbadkCoreApplication.getInst().isQuanmin() ? new QuanminYuyinLiveLogger() : new DefalutYuyinLiveLogger();
    }

    public static ILiveIMLogger getLiveIMLogger() {
        if (TbadkCoreApplication.getInst().isHaokan()) {
            return new HaokanLiveIMLogger();
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            return new QuanminLiveIMLogger();
        }
        return new DefaultLiveIMLogger();
    }

    public static ILiveGoodsLogger getLiveGoodsLogger() {
        if (TbadkCoreApplication.getInst().isHaokan()) {
            return new HaokanLiveGoodsLogger();
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            return new QuanminLiveGoodsLogger();
        }
        return new DefaultLiveGoodsLogger();
    }

    public static ILiveRecordLogger getLiveRecordLogger() {
        if (TbadkCoreApplication.getInst().isHaokan()) {
            return new HaokanLiveRecordLogger();
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            return new QuanminLiveRecordLogger();
        }
        return new DefaultLiveRecordLogger();
    }

    public static IMigrateFromTiebaLogger getMigrateFromTiebaLogger() {
        return TbadkCoreApplication.getInst().isTieba() ? new TiebaMigrateFromTiebaLogger() : new DefaultMigrateFromTiebaLogger();
    }

    public static IFirstChargeLogger getFirstChargeLogger() {
        if (TbadkCoreApplication.getInst().isHaokan()) {
            return new HaokanFirstChargeLogger();
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            return new QuanminFirstChargeLogger();
        }
        return new DefaultFirstChargeLogger();
    }

    public static IFeedDiversionLogger getFeedDiversionLogger() {
        return TbadkCoreApplication.getInst().isMobileBaidu() ? new MobileBaiduFeedDiversionLogger() : new DefaultFeedDiversionLogger();
    }

    public static LiveOtherParamsEntity parseLiveOtherParamsEntity(String str) {
        JSONObject jSONObject;
        LiveOtherParamsEntity liveOtherParamsEntity = new LiveOtherParamsEntity();
        try {
            String str2 = "";
            String str3 = "";
            String str4 = "";
            String str5 = "";
            if (!TextUtils.isEmpty(str) && (jSONObject = new JSONObject(str)) != null) {
                str2 = jSONObject.optString("source");
                str3 = jSONObject.optString("tab");
                str4 = jSONObject.optString("tag");
                str5 = jSONObject.optString("from");
            }
            liveOtherParamsEntity.source = str2;
            liveOtherParamsEntity.tab = str3;
            liveOtherParamsEntity.tag = str4;
            liveOtherParamsEntity.from = str5;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return liveOtherParamsEntity;
    }

    public static JSONObject addOtherParamsToJson(JSONObject jSONObject, String str, boolean z, boolean z2) {
        if (jSONObject == null) {
            return null;
        }
        try {
            LiveOtherParamsEntity parseLiveOtherParamsEntity = parseLiveOtherParamsEntity(str);
            if (z) {
                if (!TextUtils.isEmpty(parseLiveOtherParamsEntity.source)) {
                    jSONObject.put("source", parseLiveOtherParamsEntity.source);
                } else {
                    jSONObject.put("source", "");
                }
            }
            if (!TextUtils.isEmpty(parseLiveOtherParamsEntity.tab)) {
                jSONObject.put(LogConfig.LOG_PRETAB, parseLiveOtherParamsEntity.tab);
            } else {
                jSONObject.put(LogConfig.LOG_PRETAB, "");
            }
            if (!TextUtils.isEmpty(parseLiveOtherParamsEntity.tag)) {
                jSONObject.put(LogConfig.LOG_PRETAG, parseLiveOtherParamsEntity.tag);
            } else {
                jSONObject.put(LogConfig.LOG_PRETAG, "");
            }
            if (z2 && !TextUtils.isEmpty(parseLiveOtherParamsEntity.from)) {
                jSONObject.put("from", parseLiveOtherParamsEntity.from);
                return jSONObject;
            }
            return jSONObject;
        } catch (JSONException e) {
            return jSONObject;
        }
    }

    public static void attachHaoKanLiveOtherParams(JSONObject jSONObject, String str) {
        JSONObject jSONObject2;
        String str2 = "";
        String str3 = "";
        String str4 = "";
        try {
            if (!TextUtils.isEmpty(str) && (jSONObject2 = new JSONObject(str)) != null) {
                str2 = jSONObject2.optString("source");
                str3 = jSONObject2.optString("tab");
                str4 = jSONObject2.optString("tag");
            }
            jSONObject.put("entry", str3);
            jSONObject.put("tag", str4);
            jSONObject.put("source", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
