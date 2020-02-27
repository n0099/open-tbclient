package com.baidu.live.data;

import android.graphics.Color;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bb {
    private String aeb;
    private String aec;
    private String aed;
    private String aee;
    private String aef;
    private String aeg;
    private String aeh;
    private String aei;
    private int[] aej;
    private int[] aek;
    private int[] ael;
    private int[] aem;
    public String id;
    public String name;
    public int price;
    public int type;

    public bb() {
    }

    public bb(int i, JSONObject jSONObject) {
        this.type = i;
        this.id = jSONObject.optString("id");
        this.price = jSONObject.optInt("price");
        this.name = jSONObject.optString("name");
        this.aeb = jSONObject.optString("barrage_start_color");
        this.aec = jSONObject.optString("barrage_end_color");
        this.aed = jSONObject.optString("portrait_start_color");
        this.aee = jSONObject.optString("portrait_end_color");
        this.aef = jSONObject.optString("portrait_frame_start_color");
        this.aeg = jSONObject.optString("portrait_frame_end_color");
        this.aeh = jSONObject.optString("btn_start_color");
        this.aei = jSONObject.optString("btn_end_color");
    }

    public bb qL() {
        this.type = 1;
        this.price = 100;
        this.aeb = "#FF613EFB";
        this.aec = "#FF44E3FF";
        this.aed = "#FF623DFE";
        this.aee = "#FF03E2F5";
        this.aef = "#FF61A0FF";
        this.aeg = "#FF73FFEF";
        return this;
    }

    public int[] qM() {
        if (this.aej == null || this.aej.length != 2) {
            this.aej = j(this.aeh, this.aei, "#FF623DFE", "#FF03E2F5");
        }
        return this.aej;
    }

    public int[] qN() {
        if (this.aek == null || this.aek.length != 2) {
            this.aek = j(this.aed, this.aee, "#FF623DFE", "#FF03E2F5");
        }
        return this.aek;
    }

    public int[] qO() {
        if (this.ael == null || this.ael.length != 2) {
            this.ael = j(this.aeb, this.aec, "#FF613EFB", "#FF44E3FF");
        }
        return this.ael;
    }

    public int[] qP() {
        if (this.aem == null || this.aem.length != 2) {
            this.aem = j(this.aef, this.aeg, "#FF61A0FF", "#FF73FFEF");
        }
        return this.aem;
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
