package com.baidu.live.gift;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.Base64;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class m implements Cloneable {
    private String aQA;
    private int aQB;
    private int aQC;
    public Bitmap aQD;
    public g aQE;
    private int mGiftId;

    public String EY() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_GIFT_ID, this.mGiftId);
            if (!TextUtils.isEmpty(this.aQA)) {
                jSONObject.put("gift_img_url", Base64.encodeBytes(this.aQA.getBytes()));
            }
            jSONObject.put("gift_index", this.aQB);
            jSONObject.put("gift_count", this.aQC);
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean gl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mGiftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
            String optString = jSONObject.optString("gift_img_url");
            if (!TextUtils.isEmpty(optString)) {
                this.aQA = new String(Base64.decode(optString.getBytes()));
            }
            this.aQB = jSONObject.optInt("gift_index");
            this.aQC = jSONObject.optInt("gift_count");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Fb */
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

    public String Fc() {
        return this.aQA;
    }

    public void gm(String str) {
        this.aQA = str;
    }

    public int Fd() {
        return this.aQC;
    }

    public void dR(int i) {
        this.aQC = i;
    }
}
