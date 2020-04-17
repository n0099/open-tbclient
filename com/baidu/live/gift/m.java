package com.baidu.live.gift;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.Base64;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m implements Cloneable {
    private int aAa;
    private int aAb;
    public Bitmap aAc;
    public g aAd;
    private String azZ;
    private int mGiftId;

    public String wM() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_GIFT_ID, this.mGiftId);
            if (!TextUtils.isEmpty(this.azZ)) {
                jSONObject.put("gift_img_url", Base64.encodeBytes(this.azZ.getBytes()));
            }
            jSONObject.put("gift_index", this.aAa);
            jSONObject.put("gift_count", this.aAb);
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean dY(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mGiftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
            String optString = jSONObject.optString("gift_img_url");
            if (!TextUtils.isEmpty(optString)) {
                this.azZ = new String(Base64.decode(optString.getBytes()));
            }
            this.aAa = jSONObject.optInt("gift_index");
            this.aAb = jSONObject.optInt("gift_count");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: wP */
    public m clone() {
        try {
            return (m) super.clone();
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

    public String wQ() {
        return this.azZ;
    }

    public void dZ(String str) {
        this.azZ = str;
    }

    public int wR() {
        return this.aAb;
    }

    public void bF(int i) {
        this.aAb = i;
    }
}
