package com.baidu.adp.lib.stats.switchs;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
/* loaded from: classes.dex */
class BdStatisticsWriteConfig implements Serializable {
    private static final long serialVersionUID = 7184457133962107119L;
    public final HashMap<String, BdStatisticsWriteConfigItem> item = new HashMap<>();

    /* loaded from: classes.dex */
    public static class BdStatisticsWriteConfigItem implements Serializable {
        private static final long serialVersionUID = 4440010439026244319L;
        public String type;
        public boolean isWrite = false;
        public int particleNum = -1;
        public boolean isExac = false;
        public final HashMap<String, BdStatisticsWriteChildItem> childItem = new HashMap<>();
    }

    public boolean isWrite(String str, String str2) {
        BdStatisticsWriteConfigItem bdStatisticsWriteConfigItem;
        if (!TextUtils.isEmpty(str) && (bdStatisticsWriteConfigItem = this.item.get(str)) != null) {
            if (TextUtils.isEmpty(str2)) {
                return bdStatisticsWriteConfigItem.isWrite;
            }
            BdStatisticsWriteChildItem bdStatisticsWriteChildItem = bdStatisticsWriteConfigItem.childItem.get(str2);
            if (bdStatisticsWriteChildItem == null) {
                return bdStatisticsWriteConfigItem.isWrite;
            }
            return bdStatisticsWriteChildItem.ij() && bdStatisticsWriteConfigItem.isWrite;
        }
        return false;
    }

    public boolean isExactWriteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        BdStatisticsWriteConfigItem bdStatisticsWriteConfigItem = this.item.get(str);
        return bdStatisticsWriteConfigItem != null && bdStatisticsWriteConfigItem.isExac;
    }

    /* loaded from: classes.dex */
    public static class BdStatisticsWriteChildItem implements Serializable {
        private static final long serialVersionUID = 2371610422804472309L;
        public boolean isWrite;
        public String subType;

        /* JADX INFO: Access modifiers changed from: private */
        public boolean ij() {
            return this.isWrite;
        }
    }
}
