package com.baidu.live.gift;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.Base64;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m implements Cloneable {
    private String aAf;
    private int aAg;
    private int aAh;
    public Bitmap aAi;
    public g aAj;
    private int mGiftId;

    public String wL() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_GIFT_ID, this.mGiftId);
            if (!TextUtils.isEmpty(this.aAf)) {
                jSONObject.put("gift_img_url", Base64.encodeBytes(this.aAf.getBytes()));
            }
            jSONObject.put("gift_index", this.aAg);
            jSONObject.put("gift_count", this.aAh);
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
                this.aAf = new String(Base64.decode(optString.getBytes()));
            }
            this.aAg = jSONObject.optInt("gift_index");
            this.aAh = jSONObject.optInt("gift_count");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: wO */
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

    public String wP() {
        return this.aAf;
    }

    public void dZ(String str) {
        this.aAf = str;
    }

    public int wQ() {
        return this.aAh;
    }

    public void bF(int i) {
        this.aAh = i;
    }
}
