package com.baidu.live.adp.lib.stats;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.net.http.Headers;
import android.text.TextUtils;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.lib.lbs.BdLocationMananger;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tieba.compatible.EditorHelper;
@Deprecated
/* loaded from: classes10.dex */
public class BdStatisticsManager {
    private static volatile BdStatisticsManager statisticsManager = null;
    private Context mContext;

    public static BdStatisticsManager getInstance() {
        if (statisticsManager == null) {
            synchronized (BdStatisticsManager.class) {
                if (statisticsManager == null) {
                    statisticsManager = new BdStatisticsManager();
                }
            }
        }
        return statisticsManager;
    }

    public void performance(String str, Object... objArr) {
        addLog(BdStatsConstant.StatsType.PERFORMANCE, str, -1L, null, null, objArr);
    }

    public void performance(String str, BdStatsItem bdStatsItem) {
        if (bdStatsItem != null) {
            Address address = BdLocationMananger.getInstance().getAddress(false, false);
            if (address != null) {
                bdStatsItem.append(Headers.LOCATION, address.getLocality());
            }
            addLog(BdStatsConstant.StatsType.PERFORMANCE, str, -1L, null, bdStatsItem, new Object[0]);
        }
    }

    public void debug(String str, Object... objArr) {
        addLog("dbg", str, -1L, null, null, objArr);
    }

    public void debug(String str, BdStatsItem bdStatsItem) {
        if (bdStatsItem != null) {
            debug(str, -1L, null, bdStatsItem);
        }
    }

    public void debug(String str, long j, String str2, BdStatsItem bdStatsItem) {
        addLog("dbg", str, j, str2, bdStatsItem, new Object[0]);
    }

    public void newDebug(String str, long j, String str2, Object... objArr) {
        addLog("dbg", str, j, str2, null, objArr);
    }

    public void error(String str, long j, String str2, BdStatsItem bdStatsItem) {
        addLog(BdStatsConstant.StatsType.ERROR, str, j, str2, bdStatsItem, new Object[0]);
    }

    public void error(String str, long j, String str2, Object... objArr) {
        addLog(BdStatsConstant.StatsType.ERROR, str, j, str2, null, objArr);
    }

    public void alert(String str, String str2) {
    }

    private void alert(String str, String str2, Object[] objArr) {
    }

    private void setUploadTime(String str) {
        if (!TextUtils.isEmpty(str)) {
            EditorHelper.putLong(getConfig(), str, System.currentTimeMillis());
        }
    }

    private SharedPreferences getConfig() {
        return BdBaseApplication.getInst().getSharedPreferences("alert", 0);
    }

    public void eventStat(Context context, String str, String str2, int i, Object... objArr) {
        BdStatsItem bdStatsItem = new BdStatsItem("stat");
        bdStatsItem.append(BdStatsConstant.StatsKey.TYPE, "stat");
        if (!TextUtils.isEmpty(str)) {
            bdStatsItem.append(BdStatsConstant.StatsKey.OP_NAME, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            bdStatsItem.append("pt", str2);
        }
        bdStatsItem.append(BdStatsConstant.StatsKey.COUNT, String.valueOf(i));
        bdStatsItem.append("t", String.valueOf(System.currentTimeMillis()));
        if (objArr != null && objArr.length > 0) {
            bdStatsItem.append(objArr);
            bdStatsItem.addValue(BdStatsConstant.StatsKey.MERGE_ITEM, 0);
        }
        addLog("stat", null, -1L, null, bdStatsItem, new Object[0]);
    }

    private void addLog(String str, String str2, long j, String str3, BdStatsItem bdStatsItem, Object... objArr) {
    }

    public void log(String str, Object... objArr) {
    }

    public void imgNet(String str, String str2, long j, long j2, long j3, long j4, long j5, int i, int i2, String str3, Object... objArr) {
        net("img", str, str2, j, j2, j3, j4, j5, i, i2, str3, objArr);
    }

    public void error(String str, String str2, String str3, int i, String str4, Object... objArr) {
        op(true, str, str2, str3, 0L, i, str4, objArr);
    }

    public void voiceNet(String str, String str2, long j, long j2, long j3, long j4, long j5, int i, int i2, String str3, Object... objArr) {
        net("voice", str, str2, j, j2, j3, j4, j5, i, i2, str3, objArr);
    }

    public void net(String str, String str2, long j, long j2, long j3, long j4, long j5, int i, int i2, String str3, Object... objArr) {
        net("d", str, str2, j, j2, j3, j4, j5, i, i2, str3, objArr);
    }

    public void net(String str, String str2, String str3, long j, long j2, long j3, long j4, long j5, int i, int i2, String str4, Object... objArr) {
    }

    public void op(String str, String str2, long j, int i, String str3, Object... objArr) {
        op(true, "d", str, str2, j, i, str3, objArr);
    }

    public void op(boolean z, String str, String str2, String str3, long j, int i, String str4, Object... objArr) {
    }

    public void file(String str, String str2, int i, String str3, Object... objArr) {
        op(true, "file", str, str2, 0L, i, str3, objArr);
    }

    public void db(String str, String str2, int i, String str3, Object... objArr) {
        op(true, BdStatsConstant.OpSubType.DB, str, str2, 0L, i, str3, objArr);
    }

    public void imgErr(String str, String str2, int i, String str3, Object... objArr) {
        op(true, "img", str, str2, 0L, i, str3, objArr);
    }

    public void voiceErr(String str, String str2, int i, String str3, Object... objArr) {
        op(true, "voice", str, str2, 0L, i, str3, objArr);
    }

    public void liveErr(String str, String str2, int i, String str3, Object... objArr) {
        op(true, "live", str, str2, 0L, i, str3, objArr);
    }

    public void aladinPortErr(String str, String str2, int i, String str3, Object... objArr) {
        op(true, BdStatsConstant.OpSubType.ALADIN_PORT_ERROR, str, str2, 0L, i, str3, objArr);
    }

    public void crash(String str, String str2, String str3, Object... objArr) {
        BdStatsItem bdStatsItem = new BdStatsItem("crash");
        bdStatsItem.append(BdStatsConstant.StatsKey.TYPE, "crash");
        if (!TextUtils.isEmpty(str)) {
            bdStatsItem.append(BdStatsConstant.StatsKey.CRASH_TYPE, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            bdStatsItem.append(BdStatsConstant.StatsKey.CRASH_INFO, str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            bdStatsItem.append("f", str3);
        }
        bdStatsItem.append("t", String.valueOf(System.currentTimeMillis()));
        if (objArr != null && objArr.length > 0) {
            bdStatsItem.append(objArr);
        }
        addLog("crash", "crash", -1L, null, bdStatsItem, new Object[0]);
    }

    public BdStatsItem getStatsItem(String str) {
        return new BdStatsItem(str);
    }

    public static void clearInstance() {
        statisticsManager = null;
    }
}
