package com.baidu.live.data;

import android.graphics.Color;
import com.baidu.live.adp.lib.util.StringUtils;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class br {
    private String aKI;
    private String aKJ;
    private String aKK;
    private String aKL;
    private String aKM;
    private String aKN;
    private String aKO;
    private String aKP;
    public boolean aKQ;
    private String aKR;
    public int aKS;
    public int aKT;
    private int[] aKU;
    private int[] aKV;
    private int[] aKW;
    private int[] aKX;
    private int[] aKY;
    public String id;
    public String name;
    public int price;
    public int type;

    public br() {
        this.aKQ = false;
    }

    public br(int i, JSONObject jSONObject) {
        int i2;
        this.aKQ = false;
        this.type = i;
        this.id = jSONObject.optString("id");
        this.price = jSONObject.optInt("price");
        this.name = jSONObject.optString("name");
        this.aKI = jSONObject.optString("barrage_start_color");
        this.aKJ = jSONObject.optString("barrage_end_color");
        this.aKK = jSONObject.optString("portrait_start_color");
        this.aKL = jSONObject.optString("portrait_end_color");
        this.aKM = jSONObject.optString("portrait_frame_start_color");
        this.aKN = jSONObject.optString("portrait_frame_end_color");
        this.aKO = jSONObject.optString("btn_start_color");
        this.aKP = jSONObject.optString("btn_end_color");
        this.aKR = jSONObject.optString("btn_border_color");
        this.aKS = jSONObject.optInt("btn_border_transprancy");
        if (!StringUtils.isNull(this.aKR)) {
            this.aKQ = true;
        }
        try {
            i2 = (int) (((this.aKS * 1.0f) / 100.0f) * 255.0f);
        } catch (Exception e) {
            i2 = 255;
        }
        this.aKS = i2;
        this.aKT = jSONObject.optInt("noble_level");
    }

    public br CZ() {
        this.type = 1;
        this.price = 100;
        this.aKI = "#FF613EFB";
        this.aKJ = "#FF44E3FF";
        this.aKK = "#FF623DFE";
        this.aKL = "#FF03E2F5";
        this.aKM = "#FF61A0FF";
        this.aKN = "#FF73FFEF";
        return this;
    }

    public int[] Da() {
        if (this.aKU == null || this.aKU.length != 2) {
            this.aKU = j(this.aKO, this.aKP, "#FF623DFE", "#FF03E2F5");
        }
        return this.aKU;
    }

    public int[] Db() {
        if (this.aKY == null || this.aKY.length != 2) {
            this.aKY = j(this.aKR, this.aKR, "#FFFFC926", "#FFFFC926");
        }
        return this.aKY;
    }

    public int[] Dc() {
        if (this.aKV == null || this.aKV.length != 2) {
            this.aKV = j(this.aKK, this.aKL, "#FF623DFE", "#FF03E2F5");
        }
        return this.aKV;
    }

    public int[] Dd() {
        if (this.aKW == null || this.aKW.length != 2) {
            this.aKW = j(this.aKI, this.aKJ, "#FF613EFB", "#FF44E3FF");
        }
        return this.aKW;
    }

    public int[] De() {
        if (this.aKX == null || this.aKX.length != 2) {
            this.aKX = j(this.aKM, this.aKN, "#FF61A0FF", "#FF73FFEF");
        }
        return this.aKX;
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
