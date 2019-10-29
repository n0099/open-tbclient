package com.baidu.live.data;

import android.graphics.Color;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ao {
    private String UX;
    private String UY;
    private String UZ;
    private String Va;
    private String Vb;
    private String Vc;
    private String Vd;
    private String Ve;
    private int[] Vf;
    private int[] Vg;
    private int[] Vh;
    private int[] Vi;
    public String id;
    public int price;

    public ao() {
    }

    public ao(JSONObject jSONObject) {
        this.id = jSONObject.optString("id");
        this.price = jSONObject.optInt("price");
        this.UX = jSONObject.optString("barrage_start_color");
        this.UY = jSONObject.optString("barrage_end_color");
        this.UZ = jSONObject.optString("portrait_start_color");
        this.Va = jSONObject.optString("portrait_end_color");
        this.Vb = jSONObject.optString("portrait_frame_start_color");
        this.Vc = jSONObject.optString("portrait_frame_end_color");
        this.Vd = jSONObject.optString("btn_start_color");
        this.Ve = jSONObject.optString("btn_end_color");
    }

    public ao oA() {
        this.price = 100;
        this.UX = "#FF613EFB";
        this.UY = "#FF44E3FF";
        this.UZ = "#FF623DFE";
        this.Va = "#FF03E2F5";
        this.Vb = "#FF61A0FF";
        this.Vc = "#FF73FFEF";
        return this;
    }

    public int[] oB() {
        if (this.Vf == null || this.Vf.length != 2) {
            this.Vf = i(this.Vd, this.Ve, "#FF623DFE", "#FF03E2F5");
        }
        return this.Vf;
    }

    public int[] oC() {
        if (this.Vg == null || this.Vg.length != 2) {
            this.Vg = i(this.UZ, this.Va, "#FF623DFE", "#FF03E2F5");
        }
        return this.Vg;
    }

    public int[] oD() {
        if (this.Vh == null || this.Vh.length != 2) {
            this.Vh = i(this.UX, this.UY, "#FF613EFB", "#FF44E3FF");
        }
        return this.Vh;
    }

    public int[] oE() {
        if (this.Vi == null || this.Vi.length != 2) {
            this.Vi = i(this.Vb, this.Vc, "#FF61A0FF", "#FF73FFEF");
        }
        return this.Vi;
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
