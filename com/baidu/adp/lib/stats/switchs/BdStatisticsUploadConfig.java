package com.baidu.adp.lib.stats.switchs;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
/* loaded from: classes.dex */
class BdStatisticsUploadConfig implements Serializable {
    private static final long serialVersionUID = 3356496353918792359L;
    public HashMap<String, BdStatisticsUploadConfigItem> item = new HashMap<>();

    /* loaded from: classes.dex */
    public static class BdStatisticsUploadConfigItem implements Serializable {
        private static final long serialVersionUID = -7225735564387772L;
        public String type;
        public boolean isUpload = false;
        public boolean isWifi = true;
        public HashMap<String, BdStatistisUploadChilidItem> childItem = new HashMap<>();
    }

    /* loaded from: classes.dex */
    public static class BdStatistisUploadChilidItem implements Serializable {
        private static final long serialVersionUID = 492107549674799283L;
        public boolean isUpload = false;
        public boolean isWifi = true;
        public int percent = -1;
        public String subType;
    }

    public boolean isUpload(String str, String str2) {
        BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem;
        if (!TextUtils.isEmpty(str) && (bdStatisticsUploadConfigItem = this.item.get(str)) != null) {
            if (TextUtils.isEmpty(str2)) {
                return bdStatisticsUploadConfigItem.isUpload;
            }
            BdStatistisUploadChilidItem bdStatistisUploadChilidItem = bdStatisticsUploadConfigItem.childItem.get(str2);
            if (bdStatistisUploadChilidItem == null) {
                return bdStatisticsUploadConfigItem.isUpload;
            }
            return bdStatistisUploadChilidItem.isUpload && bdStatisticsUploadConfigItem.isUpload;
        }
        return false;
    }

    public boolean smallFlowUpload(String str, String str2) {
        BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem;
        BdStatistisUploadChilidItem bdStatistisUploadChilidItem;
        return TextUtils.isEmpty(str) || (bdStatisticsUploadConfigItem = this.item.get(str)) == null || TextUtils.isEmpty(str2) || (bdStatistisUploadChilidItem = bdStatisticsUploadConfigItem.childItem.get(str2)) == null || 100 == bdStatistisUploadChilidItem.percent || ((int) (Math.random() * 100.0d)) < bdStatistisUploadChilidItem.percent;
    }

    public boolean onlyWifiUpload(String str, String str2) {
        BdStatisticsUploadConfigItem bdStatisticsUploadConfigItem;
        if (!TextUtils.isEmpty(str) && (bdStatisticsUploadConfigItem = this.item.get(str)) != null) {
            if (TextUtils.isEmpty(str2)) {
                return bdStatisticsUploadConfigItem.isWifi;
            }
            BdStatistisUploadChilidItem bdStatistisUploadChilidItem = bdStatisticsUploadConfigItem.childItem.get(str2);
            if (bdStatistisUploadChilidItem == null) {
                return bdStatisticsUploadConfigItem.isWifi;
            }
            if (bdStatistisUploadChilidItem.isWifi) {
                return true;
            }
            return bdStatisticsUploadConfigItem.isWifi;
        }
        return true;
    }
}
