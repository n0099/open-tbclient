package com.baidu.live.gift;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.Base64;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class m implements Cloneable {
    private String aTL;
    private int aTM;
    private int aTN;
    public Bitmap aTO;
    public g aTP;
    private int mGiftId;

    public String FU() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_GIFT_ID, this.mGiftId);
            if (!TextUtils.isEmpty(this.aTL)) {
                jSONObject.put("gift_img_url", Base64.encodeBytes(this.aTL.getBytes()));
            }
            jSONObject.put("gift_index", this.aTM);
            jSONObject.put("gift_count", this.aTN);
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean gA(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mGiftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
            String optString = jSONObject.optString("gift_img_url");
            if (!TextUtils.isEmpty(optString)) {
                this.aTL = new String(Base64.decode(optString.getBytes()));
            }
            this.aTM = jSONObject.optInt("gift_index");
            this.aTN = jSONObject.optInt("gift_count");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: FX */
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

    public String FY() {
        return this.aTL;
    }

    public void gB(String str) {
        this.aTL = str;
    }

    public int FZ() {
        return this.aTN;
    }

    public void dW(int i) {
        this.aTN = i;
    }
}
