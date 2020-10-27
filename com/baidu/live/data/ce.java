package com.baidu.live.data;

import android.graphics.Color;
import com.baidu.live.adp.lib.util.StringUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ce {
    private String aQe;
    private String aQf;
    private String aQg;
    private String aQh;
    private String aQi;
    private String aQj;
    private String aQk;
    private String aQl;
    public boolean aQm;
    private String aQn;
    public int aQo;
    public int aQp;
    private int[] aQq;
    private int[] aQr;
    private int[] aQs;
    private int[] aQt;
    private int[] aQu;
    public String id;
    public String name;
    public int price;
    public int type;

    public ce() {
        this.aQm = false;
    }

    public ce(int i, JSONObject jSONObject) {
        int i2;
        this.aQm = false;
        this.type = i;
        this.id = jSONObject.optString("id");
        this.price = jSONObject.optInt("price");
        this.name = jSONObject.optString("name");
        this.aQe = jSONObject.optString("barrage_start_color");
        this.aQf = jSONObject.optString("barrage_end_color");
        this.aQg = jSONObject.optString("portrait_start_color");
        this.aQh = jSONObject.optString("portrait_end_color");
        this.aQi = jSONObject.optString("portrait_frame_start_color");
        this.aQj = jSONObject.optString("portrait_frame_end_color");
        this.aQk = jSONObject.optString("btn_start_color");
        this.aQl = jSONObject.optString("btn_end_color");
        this.aQn = jSONObject.optString("btn_border_color");
        this.aQo = jSONObject.optInt("btn_border_transprancy");
        if (!StringUtils.isNull(this.aQn)) {
            this.aQm = true;
        }
        try {
            i2 = (int) (((this.aQo * 1.0f) / 100.0f) * 255.0f);
        } catch (Exception e) {
            i2 = 255;
        }
        this.aQo = i2;
        this.aQp = jSONObject.optInt("noble_level");
    }

    public ce Ev() {
        this.type = 1;
        this.price = 100;
        this.aQe = "#FF613EFB";
        this.aQf = "#FF44E3FF";
        this.aQg = "#FF623DFE";
        this.aQh = "#FF03E2F5";
        this.aQi = "#FF61A0FF";
        this.aQj = "#FF73FFEF";
        return this;
    }

    public int[] Ew() {
        if (this.aQq == null || this.aQq.length != 2) {
            this.aQq = j(this.aQk, this.aQl, "#FF623DFE", "#FF03E2F5");
        }
        return this.aQq;
    }

    public int[] Ex() {
        if (this.aQu == null || this.aQu.length != 2) {
            this.aQu = j(this.aQn, this.aQn, "#FFFFC926", "#FFFFC926");
        }
        return this.aQu;
    }

    public int[] Ey() {
        if (this.aQr == null || this.aQr.length != 2) {
            this.aQr = j(this.aQg, this.aQh, "#FF623DFE", "#FF03E2F5");
        }
        return this.aQr;
    }

    public int[] Ez() {
        if (this.aQs == null || this.aQs.length != 2) {
            this.aQs = j(this.aQe, this.aQf, "#FF613EFB", "#FF44E3FF");
        }
        return this.aQs;
    }

    public int[] EA() {
        if (this.aQt == null || this.aQt.length != 2) {
            this.aQt = j(this.aQi, this.aQj, "#FF61A0FF", "#FF73FFEF");
        }
        return this.aQt;
    }

    private int[] j(String str, String str2, String str3, String str4) {
        int parseColor;
        int parseColor2;
        try {
            parseColor = Color.parseColor(str);
            parseColor2 = Color.parseColor(str2);
        } catch (Exception e) {
            parseColor = Color.parseColor(str3);
            parseColor2 = Color.parseColor(str4);
        }
        return new int[]{parseColor, parseColor2};
    }
}
