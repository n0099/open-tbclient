package com.baidu.nadcore.video.plugin.videoplayer.model;

import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class BdVideoAd implements Serializable {
    public static final String AD_VIDEO_DAPAGE = "da_page";
    public String channelId;
    public String channelTitle;
    public JSONObject commonParams;
    public JSONObject extRequest;
    public Object fullItemAdData;
    public Object mAdVideoTailFrameData;
    public String page;
    public String pd;
    public int pos;
    public String source;
    public boolean suffixAdEnable;
    public String tpl;
    public String type;
    public Object userInfoData;

    /* loaded from: classes3.dex */
    public static final class b {
        public boolean a;
        public String b;
        public String c;
        public JSONObject d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public int j;
        public Object k;
        public Object l;

        public b() {
            this.a = false;
            this.b = "";
            this.c = "";
            this.d = null;
            this.e = "";
            this.f = "";
            this.g = "";
            this.h = "";
            this.i = "detail";
            this.j = -1;
            this.k = null;
        }

        public BdVideoAd a() {
            return new BdVideoAd(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l);
        }

        public b(BdVideoAd bdVideoAd) {
            this.a = bdVideoAd.suffixAdEnable;
            this.b = bdVideoAd.tpl;
            this.c = bdVideoAd.pd;
            this.d = bdVideoAd.extRequest;
            this.e = bdVideoAd.page;
            this.f = bdVideoAd.type;
            this.g = bdVideoAd.channelId;
            this.h = bdVideoAd.channelTitle;
            this.i = bdVideoAd.source;
            this.j = bdVideoAd.pos;
            this.k = bdVideoAd.mAdVideoTailFrameData;
            this.l = bdVideoAd.userInfoData;
        }

        public b b(Object obj) {
            this.k = obj;
            return this;
        }

        public b c(boolean z) {
            this.a = z;
            return this;
        }
    }

    public BdVideoAd(boolean z, String str, String str2, JSONObject jSONObject, String str3, String str4, String str5, String str6, String str7, int i, Object obj, Object obj2) {
        this.suffixAdEnable = z;
        this.tpl = str;
        this.pd = str2;
        this.extRequest = jSONObject;
        this.page = str3;
        this.type = str4;
        this.channelId = str5;
        this.channelTitle = str6;
        this.source = str7;
        this.pos = i;
        this.mAdVideoTailFrameData = obj;
        this.userInfoData = obj2;
    }

    public b builder() {
        return new b(this);
    }
}
