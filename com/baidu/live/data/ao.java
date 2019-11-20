package com.baidu.live.data;

import android.graphics.Color;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ao {
    private String UC;
    private String UD;
    private String UE;
    private String UF;
    private String UG;
    private String UH;
    private String UJ;
    private String UK;
    private int[] UL;
    private int[] UM;
    private int[] UN;
    private int[] UO;
    public String id;
    public int price;

    public ao() {
    }

    public ao(JSONObject jSONObject) {
        this.id = jSONObject.optString("id");
        this.price = jSONObject.optInt("price");
        this.UC = jSONObject.optString("barrage_start_color");
        this.UD = jSONObject.optString("barrage_end_color");
        this.UE = jSONObject.optString("portrait_start_color");
        this.UF = jSONObject.optString("portrait_end_color");
        this.UG = jSONObject.optString("portrait_frame_start_color");
        this.UH = jSONObject.optString("portrait_frame_end_color");
        this.UJ = jSONObject.optString("btn_start_color");
        this.UK = jSONObject.optString("btn_end_color");
    }

    public ao oA() {
        this.price = 100;
        this.UC = "#FF613EFB";
        this.UD = "#FF44E3FF";
        this.UE = "#FF623DFE";
        this.UF = "#FF03E2F5";
        this.UG = "#FF61A0FF";
        this.UH = "#FF73FFEF";
        return this;
    }

    public int[] oB() {
        if (this.UL == null || this.UL.length != 2) {
            this.UL = i(this.UJ, this.UK, "#FF623DFE", "#FF03E2F5");
        }
        return this.UL;
    }

    public int[] oC() {
        if (this.UM == null || this.UM.length != 2) {
            this.UM = i(this.UE, this.UF, "#FF623DFE", "#FF03E2F5");
        }
        return this.UM;
    }

    public int[] oD() {
        if (this.UN == null || this.UN.length != 2) {
            this.UN = i(this.UC, this.UD, "#FF613EFB", "#FF44E3FF");
        }
        return this.UN;
    }

    public int[] oE() {
        if (this.UO == null || this.UO.length != 2) {
            this.UO = i(this.UG, this.UH, "#FF61A0FF", "#FF73FFEF");
        }
        return this.UO;
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
