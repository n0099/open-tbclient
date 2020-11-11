package com.baidu.live.gift;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.Base64;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class l implements Cloneable {
    private String aVZ;
    private int aWa;
    private int aWb;
    public Bitmap aWc;
    public g aWd;
    private int mGiftId;

    public String GK() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_GIFT_ID, this.mGiftId);
            if (!TextUtils.isEmpty(this.aVZ)) {
                jSONObject.put("gift_img_url", Base64.encodeBytes(this.aVZ.getBytes()));
            }
            jSONObject.put("gift_index", this.aWa);
            jSONObject.put("gift_count", this.aWb);
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean gJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mGiftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
            String optString = jSONObject.optString("gift_img_url");
            if (!TextUtils.isEmpty(optString)) {
                this.aVZ = new String(Base64.decode(optString.getBytes()));
            }
            this.aWa = jSONObject.optInt("gift_index");
            this.aWb = jSONObject.optInt("gift_count");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: GN */
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

    public String GO() {
        return this.aVZ;
    }

    public void gK(String str) {
        this.aVZ = str;
    }

    public int GP() {
        return this.aWb;
    }

    public void dW(int i) {
        this.aWb = i;
    }
}
