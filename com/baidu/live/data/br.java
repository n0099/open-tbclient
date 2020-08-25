package com.baidu.live.data;

import android.graphics.Color;
import com.baidu.live.adp.lib.util.StringUtils;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class br {
    private String aKG;
    private String aKH;
    private String aKI;
    private String aKJ;
    private String aKK;
    private String aKL;
    private String aKM;
    private String aKN;
    public boolean aKO;
    private String aKP;
    public int aKQ;
    public int aKR;
    private int[] aKS;
    private int[] aKT;
    private int[] aKU;
    private int[] aKV;
    private int[] aKW;
    public String id;
    public String name;
    public int price;
    public int type;

    public br() {
        this.aKO = false;
    }

    public br(int i, JSONObject jSONObject) {
        int i2;
        this.aKO = false;
        this.type = i;
        this.id = jSONObject.optString("id");
        this.price = jSONObject.optInt("price");
        this.name = jSONObject.optString("name");
        this.aKG = jSONObject.optString("barrage_start_color");
        this.aKH = jSONObject.optString("barrage_end_color");
        this.aKI = jSONObject.optString("portrait_start_color");
        this.aKJ = jSONObject.optString("portrait_end_color");
        this.aKK = jSONObject.optString("portrait_frame_start_color");
        this.aKL = jSONObject.optString("portrait_frame_end_color");
        this.aKM = jSONObject.optString("btn_start_color");
        this.aKN = jSONObject.optString("btn_end_color");
        this.aKP = jSONObject.optString("btn_border_color");
        this.aKQ = jSONObject.optInt("btn_border_transprancy");
        if (!StringUtils.isNull(this.aKP)) {
            this.aKO = true;
        }
        try {
            i2 = (int) (((this.aKQ * 1.0f) / 100.0f) * 255.0f);
        } catch (Exception e) {
            i2 = 255;
        }
        this.aKQ = i2;
        this.aKR = jSONObject.optInt("noble_level");
    }

    public br CZ() {
        this.type = 1;
        this.price = 100;
        this.aKG = "#FF613EFB";
        this.aKH = "#FF44E3FF";
        this.aKI = "#FF623DFE";
        this.aKJ = "#FF03E2F5";
        this.aKK = "#FF61A0FF";
        this.aKL = "#FF73FFEF";
        return this;
    }

    public int[] Da() {
        if (this.aKS == null || this.aKS.length != 2) {
            this.aKS = j(this.aKM, this.aKN, "#FF623DFE", "#FF03E2F5");
        }
        return this.aKS;
    }

    public int[] Db() {
        if (this.aKW == null || this.aKW.length != 2) {
            this.aKW = j(this.aKP, this.aKP, "#FFFFC926", "#FFFFC926");
        }
        return this.aKW;
    }

    public int[] Dc() {
        if (this.aKT == null || this.aKT.length != 2) {
            this.aKT = j(this.aKI, this.aKJ, "#FF623DFE", "#FF03E2F5");
        }
        return this.aKT;
    }

    public int[] Dd() {
        if (this.aKU == null || this.aKU.length != 2) {
            this.aKU = j(this.aKG, this.aKH, "#FF613EFB", "#FF44E3FF");
        }
        return this.aKU;
    }

    public int[] De() {
        if (this.aKV == null || this.aKV.length != 2) {
            this.aKV = j(this.aKK, this.aKL, "#FF61A0FF", "#FF73FFEF");
        }
        return this.aKV;
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
