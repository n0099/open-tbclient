package com.baidu.swan.apps.commonsync;

import com.baidu.searchbox.NoProGuard;
import com.coremedia.iso.boxes.MetaBox;
import com.google.gson.a.c;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes3.dex */
public class CommonSyncServerData implements NoProGuard, Serializable {
    @c("items")
    public List<MetaItemInfo> metaItems;

    /* loaded from: classes3.dex */
    public class MetaItemInfo implements NoProGuard {
        @c(MetaBox.TYPE)
        public MetaData metaData;

        public MetaItemInfo() {
        }
    }

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

    /* loaded from: classes3.dex */
    public class OtherData implements NoProGuard {
        @c("app_key")
        public String appKey;
        @c("frame_type")
        public int frameType = -1;

        public OtherData() {
        }
    }
}
