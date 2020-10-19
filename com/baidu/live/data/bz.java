package com.baidu.live.data;

import android.graphics.Color;
import com.baidu.live.adp.lib.util.StringUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bz {
    private String aPA;
    private String aPB;
    public boolean aPC;
    private String aPD;
    public int aPE;
    public int aPF;
    private int[] aPG;
    private int[] aPH;
    private int[] aPI;
    private int[] aPJ;
    private int[] aPK;
    private String aPu;
    private String aPv;
    private String aPw;
    private String aPx;
    private String aPy;
    private String aPz;
    public String id;
    public String name;
    public int price;
    public int type;

    public bz() {
        this.aPC = false;
    }

    public bz(int i, JSONObject jSONObject) {
        int i2;
        this.aPC = false;
        this.type = i;
        this.id = jSONObject.optString("id");
        this.price = jSONObject.optInt("price");
        this.name = jSONObject.optString("name");
        this.aPu = jSONObject.optString("barrage_start_color");
        this.aPv = jSONObject.optString("barrage_end_color");
        this.aPw = jSONObject.optString("portrait_start_color");
        this.aPx = jSONObject.optString("portrait_end_color");
        this.aPy = jSONObject.optString("portrait_frame_start_color");
        this.aPz = jSONObject.optString("portrait_frame_end_color");
        this.aPA = jSONObject.optString("btn_start_color");
        this.aPB = jSONObject.optString("btn_end_color");
        this.aPD = jSONObject.optString("btn_border_color");
        this.aPE = jSONObject.optInt("btn_border_transprancy");
        if (!StringUtils.isNull(this.aPD)) {
            this.aPC = true;
        }
        try {
            i2 = (int) (((this.aPE * 1.0f) / 100.0f) * 255.0f);
        } catch (Exception e) {
            i2 = 255;
        }
        this.aPE = i2;
        this.aPF = jSONObject.optInt("noble_level");
    }

    public bz Em() {
        this.type = 1;
        this.price = 100;
        this.aPu = "#FF613EFB";
        this.aPv = "#FF44E3FF";
        this.aPw = "#FF623DFE";
        this.aPx = "#FF03E2F5";
        this.aPy = "#FF61A0FF";
        this.aPz = "#FF73FFEF";
        return this;
    }

    public int[] En() {
        if (this.aPG == null || this.aPG.length != 2) {
            this.aPG = j(this.aPA, this.aPB, "#FF623DFE", "#FF03E2F5");
        }
        return this.aPG;
    }

    public int[] Eo() {
        if (this.aPK == null || this.aPK.length != 2) {
            this.aPK = j(this.aPD, this.aPD, "#FFFFC926", "#FFFFC926");
        }
        return this.aPK;
    }

    public int[] Ep() {
        if (this.aPH == null || this.aPH.length != 2) {
            this.aPH = j(this.aPw, this.aPx, "#FF623DFE", "#FF03E2F5");
        }
        return this.aPH;
    }

    public int[] Eq() {
        if (this.aPI == null || this.aPI.length != 2) {
            this.aPI = j(this.aPu, this.aPv, "#FF613EFB", "#FF44E3FF");
        }
        return this.aPI;
    }

    public int[] Er() {
        if (this.aPJ == null || this.aPJ.length != 2) {
            this.aPJ = j(this.aPy, this.aPz, "#FF61A0FF", "#FF73FFEF");
        }
        return this.aPJ;
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
