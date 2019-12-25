package com.baidu.tbadk.core.data;

import java.io.Serializable;
import org.json.JSONObject;
import tbclient.Baijiahao;
/* loaded from: classes.dex */
public class BaijiahaoData implements Serializable {
    public static final int UGC_TYPE_ARTICLE = 1;
    public static final int UGC_TYPE_FEED_PIC = 3;
    public static final int UGC_TYPE_FEED_VIDEO = 4;
    public static final int UGC_TYPE_VIDEO = 2;
    public String forwardUrl;
    public String oriUgcNid;
    public String oriUgcTid;
    public int oriUgcType;
    public String oriUgcVid;

    public void parseProto(Baijiahao baijiahao) {
        if (baijiahao != null) {
            this.oriUgcNid = baijiahao.ori_ugc_nid;
            this.oriUgcTid = baijiahao.ori_ugc_tid;
            this.oriUgcType = baijiahao.ori_ugc_type.intValue();
            this.oriUgcVid = baijiahao.ori_ugc_vid;
            this.forwardUrl = baijiahao.forward_url;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.oriUgcNid = jSONObject.optString("ori_ugc_nid");
            this.oriUgcTid = jSONObject.optString("ori_ugc_tid");
            this.oriUgcType = jSONObject.optInt("ori_ugc_type");
            this.oriUgcVid = jSONObject.optString("ori_ugc_vid");
            this.forwardUrl = jSONObject.optString("forward_url");
        }
    }
}
