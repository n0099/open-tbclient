package com.baidu.live.gift;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.Base64;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class l implements Cloneable {
    private String aYY;
    private int aYZ;
    private int aZa;
    public Bitmap aZb;
    public g aZc;
    private int mGiftId;

    public String Hr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_GIFT_ID, this.mGiftId);
            if (!TextUtils.isEmpty(this.aYY)) {
                jSONObject.put("gift_img_url", Base64.encodeBytes(this.aYY.getBytes()));
            }
            jSONObject.put("gift_index", this.aYZ);
            jSONObject.put("gift_count", this.aZa);
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
                this.aYY = new String(Base64.decode(optString.getBytes()));
            }
            this.aYZ = jSONObject.optInt("gift_index");
            this.aZa = jSONObject.optInt("gift_count");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Hu */
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

    public String Hv() {
        return this.aYY;
    }

    public void gK(String str) {
        this.aYY = str;
    }

    public int Hw() {
        return this.aZa;
    }

    public void ek(int i) {
        this.aZa = i;
    }
}
