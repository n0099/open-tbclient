package com.baidu.live.data;

import android.graphics.Color;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class be {
    private String awH;
    private String awI;
    private String awJ;
    private String awK;
    private String awL;
    private String awM;
    private String awN;
    private String awO;
    private int[] awP;
    private int[] awQ;
    private int[] awR;
    private int[] awS;
    public String id;
    public String name;
    public int price;
    public int type;

    public be() {
    }

    public be(int i, JSONObject jSONObject) {
        this.type = i;
        this.id = jSONObject.optString("id");
        this.price = jSONObject.optInt("price");
        this.name = jSONObject.optString("name");
        this.awH = jSONObject.optString("barrage_start_color");
        this.awI = jSONObject.optString("barrage_end_color");
        this.awJ = jSONObject.optString("portrait_start_color");
        this.awK = jSONObject.optString("portrait_end_color");
        this.awL = jSONObject.optString("portrait_frame_start_color");
        this.awM = jSONObject.optString("portrait_frame_end_color");
        this.awN = jSONObject.optString("btn_start_color");
        this.awO = jSONObject.optString("btn_end_color");
    }

    public be vg() {
        this.type = 1;
        this.price = 100;
        this.awH = "#FF613EFB";
        this.awI = "#FF44E3FF";
        this.awJ = "#FF623DFE";
        this.awK = "#FF03E2F5";
        this.awL = "#FF61A0FF";
        this.awM = "#FF73FFEF";
        return this;
    }

    public int[] vh() {
        if (this.awP == null || this.awP.length != 2) {
            this.awP = j(this.awN, this.awO, "#FF623DFE", "#FF03E2F5");
        }
        return this.awP;
    }

    public int[] vi() {
        if (this.awQ == null || this.awQ.length != 2) {
            this.awQ = j(this.awJ, this.awK, "#FF623DFE", "#FF03E2F5");
        }
        return this.awQ;
    }

    public int[] vj() {
        if (this.awR == null || this.awR.length != 2) {
            this.awR = j(this.awH, this.awI, "#FF613EFB", "#FF44E3FF");
        }
        return this.awR;
    }

    public int[] vk() {
        if (this.awS == null || this.awS.length != 2) {
            this.awS = j(this.awL, this.awM, "#FF61A0FF", "#FF73FFEF");
        }
        return this.awS;
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
