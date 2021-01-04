package com.baidu.live.data;

import android.graphics.Color;
import com.baidu.live.adp.lib.util.StringUtils;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class ck {
    private String aTA;
    private String aTB;
    private String aTC;
    public boolean aTD;
    private String aTE;
    public int aTF;
    public int aTG;
    private int[] aTH;
    private int[] aTI;
    private int[] aTJ;
    private int[] aTK;
    private int[] aTL;
    private String aTv;
    private String aTw;
    private String aTx;
    private String aTy;
    private String aTz;
    public String id;
    public String name;
    public int price;
    public int type;

    public ck() {
        this.aTD = false;
    }

    public ck(int i, JSONObject jSONObject) {
        int i2;
        this.aTD = false;
        this.type = i;
        this.id = jSONObject.optString("id");
        this.price = jSONObject.optInt("price");
        this.name = jSONObject.optString("name");
        this.aTv = jSONObject.optString("barrage_start_color");
        this.aTw = jSONObject.optString("barrage_end_color");
        this.aTx = jSONObject.optString("portrait_start_color");
        this.aTy = jSONObject.optString("portrait_end_color");
        this.aTz = jSONObject.optString("portrait_frame_start_color");
        this.aTA = jSONObject.optString("portrait_frame_end_color");
        this.aTB = jSONObject.optString("btn_start_color");
        this.aTC = jSONObject.optString("btn_end_color");
        this.aTE = jSONObject.optString("btn_border_color");
        this.aTF = jSONObject.optInt("btn_border_transprancy");
        if (!StringUtils.isNull(this.aTE)) {
            this.aTD = true;
        }
        try {
            i2 = (int) (((this.aTF * 1.0f) / 100.0f) * 255.0f);
        } catch (Exception e) {
            i2 = 255;
        }
        this.aTF = i2;
        this.aTG = jSONObject.optInt("noble_level");
    }

    public ck Fr() {
        this.type = 1;
        this.price = 100;
        this.aTv = "#FF613EFB";
        this.aTw = "#FF44E3FF";
        this.aTx = "#FF623DFE";
        this.aTy = "#FF03E2F5";
        this.aTz = "#FF61A0FF";
        this.aTA = "#FF73FFEF";
        return this;
    }

    public int[] Fs() {
        if (this.aTH == null || this.aTH.length != 2) {
            this.aTH = j(this.aTB, this.aTC, "#FF623DFE", "#FF03E2F5");
        }
        return this.aTH;
    }

    public int[] Ft() {
        if (this.aTL == null || this.aTL.length != 2) {
            this.aTL = j(this.aTE, this.aTE, "#FFFFC926", "#FFFFC926");
        }
        return this.aTL;
    }

    public int[] Fu() {
        if (this.aTI == null || this.aTI.length != 2) {
            this.aTI = j(this.aTx, this.aTy, "#FF623DFE", "#FF03E2F5");
        }
        return this.aTI;
    }

    public int[] Fv() {
        if (this.aTJ == null || this.aTJ.length != 2) {
            this.aTJ = j(this.aTv, this.aTw, "#FF613EFB", "#FF44E3FF");
        }
        return this.aTJ;
    }

    public int[] Fw() {
        if (this.aTK == null || this.aTK.length != 2) {
            this.aTK = j(this.aTz, this.aTA, "#FF61A0FF", "#FF73FFEF");
        }
        return this.aTK;
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
