package com.baidu.live.gift;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.Base64;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m implements Cloneable {
    private String aHT;
    private int aHU;
    private int aHV;
    public Bitmap aHW;
    public g aHX;
    private int mGiftId;

    public String yC() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_GIFT_ID, this.mGiftId);
            if (!TextUtils.isEmpty(this.aHT)) {
                jSONObject.put("gift_img_url", Base64.encodeBytes(this.aHT.getBytes()));
            }
            jSONObject.put("gift_index", this.aHU);
            jSONObject.put("gift_count", this.aHV);
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean eL(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mGiftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
            String optString = jSONObject.optString("gift_img_url");
            if (!TextUtils.isEmpty(optString)) {
                this.aHT = new String(Base64.decode(optString.getBytes()));
            }
            this.aHU = jSONObject.optInt("gift_index");
            this.aHV = jSONObject.optInt("gift_count");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: yF */
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

    public String yG() {
        return this.aHT;
    }

    public void eM(String str) {
        this.aHT = str;
    }

    public int yH() {
        return this.aHV;
    }

    public void bU(int i) {
        this.aHV = i;
    }
}
