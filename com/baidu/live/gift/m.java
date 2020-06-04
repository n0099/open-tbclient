package com.baidu.live.gift;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.Base64;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m implements Cloneable {
    public Bitmap aFA;
    public g aFB;
    private String aFx;
    private int aFy;
    private int aFz;
    private int mGiftId;

    public String yc() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_GIFT_ID, this.mGiftId);
            if (!TextUtils.isEmpty(this.aFx)) {
                jSONObject.put("gift_img_url", Base64.encodeBytes(this.aFx.getBytes()));
            }
            jSONObject.put("gift_index", this.aFy);
            jSONObject.put("gift_count", this.aFz);
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean eF(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mGiftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
            String optString = jSONObject.optString("gift_img_url");
            if (!TextUtils.isEmpty(optString)) {
                this.aFx = new String(Base64.decode(optString.getBytes()));
            }
            this.aFy = jSONObject.optInt("gift_index");
            this.aFz = jSONObject.optInt("gift_count");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: yf */
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

    public String yg() {
        return this.aFx;
    }

    public void eG(String str) {
        this.aFx = str;
    }

    public int yh() {
        return this.aFz;
    }

    public void bO(int i) {
        this.aFz = i;
    }
}
