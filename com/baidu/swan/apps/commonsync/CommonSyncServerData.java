package com.baidu.swan.apps.commonsync;

import com.alipay.sdk.cons.b;
import com.baidu.searchbox.NoProGuard;
import d.g.c.a.c;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes3.dex */
public class CommonSyncServerData implements Serializable, NoProGuard {
    @c("items")
    public List<MetaItemInfo> metaItems;

    /* loaded from: classes3.dex */
    public class MetaData implements NoProGuard {
        @c("logo_url")
        public String logoUrl;
        @c("data")
        public OtherData otherData;
        @c("mut_plat_conf")
        public PlatConf platConf;
        @c("sub_id")
        public String subId;
        @c("title")
        public String title;

        public MetaData() {
        }
    }

    /* loaded from: classes3.dex */
    public class MetaItemInfo implements NoProGuard {
        @c("meta")
        public MetaData metaData;

        public MetaItemInfo() {
        }
    }

    /* loaded from: classes3.dex */
    public class OtherData implements NoProGuard {
        @c(b.f1858h)
        public String appKey;
        @c("frame_type")
        public int frameType = -1;

        public OtherData() {
        }
    }

    /* loaded from: classes3.dex */
    public class PlatConf implements NoProGuard {
        @c("h5")
        public PlatH5 platH5;

        public PlatConf() {
        }
    }

    /* loaded from: classes3.dex */
    public class PlatH5 implements NoProGuard {
        @c("url")
        public String url;

        public PlatH5() {
        }
    }
}
