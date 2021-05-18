package com.baidu.swan.apps.commonsync;

import com.baidu.searchbox.NoProGuard;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes2.dex */
public class CommonSyncServerData implements Serializable, NoProGuard {
    @SerializedName("count")
    public int count = 0;
    @SerializedName("rows")
    public List<MetaItemInfo> metaItems;

    /* loaded from: classes2.dex */
    public static class MetaItemInfo implements NoProGuard {
        @SerializedName("AppKey")
        public String appKey;
        @SerializedName("AppName")
        public String appName;
        @SerializedName("CreateTime")
        public long createTime;
        @SerializedName("Icon")
        public String icon;
        @SerializedName("PayProtected")
        public int payProtected;
        @SerializedName("Scheme")
        public String scheme;
        @SerializedName("SubCategory")
        public int subCategory;
    }
}
