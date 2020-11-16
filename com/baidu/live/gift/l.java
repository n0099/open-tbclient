package com.baidu.live.gift;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.Base64;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class l implements Cloneable {
    private String aUo;
    private int aUp;
    private int aUq;
    public Bitmap aUr;
    public g aUs;
    private int mGiftId;

    public String Gb() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_GIFT_ID, this.mGiftId);
            if (!TextUtils.isEmpty(this.aUo)) {
                jSONObject.put("gift_img_url", Base64.encodeBytes(this.aUo.getBytes()));
            }
            jSONObject.put("gift_index", this.aUp);
            jSONObject.put("gift_count", this.aUq);
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean gD(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mGiftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
            String optString = jSONObject.optString("gift_img_url");
            if (!TextUtils.isEmpty(optString)) {
                this.aUo = new String(Base64.decode(optString.getBytes()));
            }
            this.aUp = jSONObject.optInt("gift_index");
            this.aUq = jSONObject.optInt("gift_count");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Ge */
    public l clone() {
        try {
            return (l) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getGiftId() {
        return this.mGiftId;
    }

    public void setGiftId(int i) {
        this.mGiftId = i;
    }

    public String Gf() {
        return this.aUo;
    }

    public void gE(String str) {
        this.aUo = str;
    }

    public int Gg() {
        return this.aUq;
    }

    public void dS(int i) {
        this.aUq = i;
    }
}
