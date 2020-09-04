package com.baidu.live.gift;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.Base64;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class m implements Cloneable {
    private String aOB;
    private int aOC;
    private int aOD;
    public Bitmap aOE;
    public g aOF;
    private int mGiftId;

    public String EH() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_GIFT_ID, this.mGiftId);
            if (!TextUtils.isEmpty(this.aOB)) {
                jSONObject.put("gift_img_url", Base64.encodeBytes(this.aOB.getBytes()));
            }
            jSONObject.put("gift_index", this.aOC);
            jSONObject.put("gift_count", this.aOD);
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean gf(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mGiftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
            String optString = jSONObject.optString("gift_img_url");
            if (!TextUtils.isEmpty(optString)) {
                this.aOB = new String(Base64.decode(optString.getBytes()));
            }
            this.aOC = jSONObject.optInt("gift_index");
            this.aOD = jSONObject.optInt("gift_count");
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
        return this.aOB;
    }

    public void gg(String str) {
        this.aOB = str;
    }

    public int EM() {
        return this.aOD;
    }

    public void dN(int i) {
        this.aOD = i;
    }
}
