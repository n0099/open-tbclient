package com.baidu.swan.apps.commonsync;

import com.alipay.sdk.cons.b;
import com.baidu.searchbox.NoProGuard;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes2.dex */
public class CommonSyncServerData implements Serializable, NoProGuard {
    @SerializedName("items")
    public List<MetaItemInfo> metaItems;

    /* loaded from: classes2.dex */
    public class MetaData implements NoProGuard {
        @SerializedName("logo_url")
        public String logoUrl;
        @SerializedName("data")
        public OtherData otherData;
        @SerializedName("mut_plat_conf")
        public PlatConf platConf;
        @SerializedName("sub_id")
        public String subId;
        @SerializedName("title")
        public String title;

        public MetaData() {
        }
    }

    /* loaded from: classes2.dex */
    public class MetaItemInfo implements NoProGuard {
        @SerializedName("meta")
        public MetaData metaData;

        public MetaItemInfo() {
        }
    }

    /* loaded from: classes2.dex */
    public class OtherData implements NoProGuard {
        @SerializedName(b.f1831h)
        public String appKey;
        @SerializedName("frame_type")
        public int frameType = -1;

        public OtherData() {
        }
    }

    /* loaded from: classes2.dex */
    public class PlatConf implements NoProGuard {
        @SerializedName("h5")
        public PlatH5 platH5;

        public PlatConf() {
        }
    }

    /* loaded from: classes2.dex */
    public class PlatH5 implements NoProGuard {
        @SerializedName("url")
        public String url;

        public PlatH5() {
        }
    }
}
