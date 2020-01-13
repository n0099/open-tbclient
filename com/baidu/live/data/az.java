package com.baidu.live.data;

import android.graphics.Color;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class az {
    private String abW;
    private String abX;
    private String abY;
    private String abZ;
    private String aca;
    private String acb;
    private String acc;
    private String acd;
    private int[] ace;
    private int[] acf;
    private int[] acg;
    private int[] ach;
    public String id;
    public String name;
    public int price;
    public int type;

    public az() {
    }

    public az(int i, JSONObject jSONObject) {
        this.type = i;
        this.id = jSONObject.optString("id");
        this.price = jSONObject.optInt("price");
        this.name = jSONObject.optString("name");
        this.abW = jSONObject.optString("barrage_start_color");
        this.abX = jSONObject.optString("barrage_end_color");
        this.abY = jSONObject.optString("portrait_start_color");
        this.abZ = jSONObject.optString("portrait_end_color");
        this.aca = jSONObject.optString("portrait_frame_start_color");
        this.acb = jSONObject.optString("portrait_frame_end_color");
        this.acc = jSONObject.optString("btn_start_color");
        this.acd = jSONObject.optString("btn_end_color");
    }

    public az qa() {
        this.type = 1;
        this.price = 100;
        this.abW = "#FF613EFB";
        this.abX = "#FF44E3FF";
        this.abY = "#FF623DFE";
        this.abZ = "#FF03E2F5";
        this.aca = "#FF61A0FF";
        this.acb = "#FF73FFEF";
        return this;
    }

    public int[] qb() {
        if (this.ace == null || this.ace.length != 2) {
            this.ace = i(this.acc, this.acd, "#FF623DFE", "#FF03E2F5");
        }
        return this.ace;
    }

    public int[] qc() {
        if (this.acf == null || this.acf.length != 2) {
            this.acf = i(this.abY, this.abZ, "#FF623DFE", "#FF03E2F5");
        }
        return this.acf;
    }

    public int[] qd() {
        if (this.acg == null || this.acg.length != 2) {
            this.acg = i(this.abW, this.abX, "#FF613EFB", "#FF44E3FF");
        }
        return this.acg;
    }

    public int[] qe() {
        if (this.ach == null || this.ach.length != 2) {
            this.ach = i(this.aca, this.acb, "#FF61A0FF", "#FF73FFEF");
        }
        return this.ach;
    }

    private int[] i(String str, String str2, String str3, String str4) {
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
