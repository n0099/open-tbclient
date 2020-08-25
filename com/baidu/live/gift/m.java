package com.baidu.live.gift;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.Base64;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class m implements Cloneable {
    private int aOA;
    private int aOB;
    public Bitmap aOC;
    public g aOD;
    private String aOz;
    private int mGiftId;

    public String EH() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_GIFT_ID, this.mGiftId);
            if (!TextUtils.isEmpty(this.aOz)) {
                jSONObject.put("gift_img_url", Base64.encodeBytes(this.aOz.getBytes()));
            }
            jSONObject.put("gift_index", this.aOA);
            jSONObject.put("gift_count", this.aOB);
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean ge(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mGiftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
            String optString = jSONObject.optString("gift_img_url");
            if (!TextUtils.isEmpty(optString)) {
                this.aOz = new String(Base64.decode(optString.getBytes()));
            }
            this.aOA = jSONObject.optInt("gift_index");
            this.aOB = jSONObject.optInt("gift_count");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: EK */
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

    public String EL() {
        return this.aOz;
    }

    public void gf(String str) {
        this.aOz = str;
    }

    public int EM() {
        return this.aOB;
    }

    public void dN(int i) {
        this.aOB = i;
    }
}
