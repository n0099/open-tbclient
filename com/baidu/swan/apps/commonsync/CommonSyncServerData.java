package com.baidu.swan.apps.commonsync;

import android.support.annotation.Keep;
import com.coremedia.iso.boxes.MetaBox;
import com.google.gson.a.c;
import java.io.Serializable;
import java.util.List;
@Keep
/* loaded from: classes9.dex */
public class CommonSyncServerData implements Serializable {
    @c("items")
    public List<MetaItemInfo> metaItems;

    @Keep
    /* loaded from: classes9.dex */
    public class MetaItemInfo {
        @c(MetaBox.TYPE)
        public MetaData metaData;

        public MetaItemInfo() {
        }
    }

    @Keep
    /* loaded from: classes9.dex */
    public class MetaData {
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

    @Keep
    /* loaded from: classes9.dex */
    public class PlatConf {
        @c("h5")
        public PlatH5 platH5;

        public PlatConf() {
        }
    }

    @Keep
    /* loaded from: classes9.dex */
    public class PlatH5 {
        @c("url")
        public String url;

        public PlatH5() {
        }
    }

    @Keep
    /* loaded from: classes9.dex */
    public class OtherData {
        @c("app_key")
        public String appKey;
        @c("frame_type")
        public int frameType = -1;

        public OtherData() {
        }
    }
}
