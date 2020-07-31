package com.baidu.live.data;

import android.graphics.Color;
import com.baidu.live.adp.lib.util.StringUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bp {
    private String aFA;
    private String aFB;
    private String aFC;
    private String aFD;
    public boolean aFE;
    private String aFF;
    public int aFG;
    public int aFH;
    private int[] aFI;
    private int[] aFJ;
    private int[] aFK;
    private int[] aFL;
    private int[] aFM;
    private String aFw;
    private String aFx;
    private String aFy;
    private String aFz;
    public String id;
    public String name;
    public int price;
    public int type;

    public bp() {
        this.aFE = false;
    }

    public bp(int i, JSONObject jSONObject) {
        int i2;
        this.aFE = false;
        this.type = i;
        this.id = jSONObject.optString("id");
        this.price = jSONObject.optInt("price");
        this.name = jSONObject.optString("name");
        this.aFw = jSONObject.optString("barrage_start_color");
        this.aFx = jSONObject.optString("barrage_end_color");
        this.aFy = jSONObject.optString("portrait_start_color");
        this.aFz = jSONObject.optString("portrait_end_color");
        this.aFA = jSONObject.optString("portrait_frame_start_color");
        this.aFB = jSONObject.optString("portrait_frame_end_color");
        this.aFC = jSONObject.optString("btn_start_color");
        this.aFD = jSONObject.optString("btn_end_color");
        this.aFF = jSONObject.optString("btn_border_color");
        this.aFG = jSONObject.optInt("btn_border_transprancy");
        if (!StringUtils.isNull(this.aFF)) {
            this.aFE = true;
        }
        try {
            i2 = (int) (((this.aFG * 1.0f) / 100.0f) * 255.0f);
        } catch (Exception e) {
            i2 = 255;
        }
        this.aFG = i2;
        this.aFH = jSONObject.optInt("noble_level");
    }

    public bp xw() {
        this.type = 1;
        this.price = 100;
        this.aFw = "#FF613EFB";
        this.aFx = "#FF44E3FF";
        this.aFy = "#FF623DFE";
        this.aFz = "#FF03E2F5";
        this.aFA = "#FF61A0FF";
        this.aFB = "#FF73FFEF";
        return this;
    }

    public int[] xx() {
        if (this.aFI == null || this.aFI.length != 2) {
            this.aFI = j(this.aFC, this.aFD, "#FF623DFE", "#FF03E2F5");
        }
        return this.aFI;
    }

    public int[] xy() {
        if (this.aFM == null || this.aFM.length != 2) {
            this.aFM = j(this.aFF, this.aFF, "#FFFFC926", "#FFFFC926");
        }
        return this.aFM;
    }

    public int[] xz() {
        if (this.aFJ == null || this.aFJ.length != 2) {
            this.aFJ = j(this.aFy, this.aFz, "#FF623DFE", "#FF03E2F5");
        }
        return this.aFJ;
    }

    public int[] xA() {
        if (this.aFK == null || this.aFK.length != 2) {
            this.aFK = j(this.aFw, this.aFx, "#FF613EFB", "#FF44E3FF");
        }
        return this.aFK;
    }

    public int[] xB() {
        if (this.aFL == null || this.aFL.length != 2) {
            this.aFL = j(this.aFA, this.aFB, "#FF61A0FF", "#FF73FFEF");
        }
        return this.aFL;
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
