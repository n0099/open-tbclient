package com.baidu.live.gift;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.Base64;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class m implements Cloneable {
    private String aUH;
    private int aUI;
    private int aUJ;
    public Bitmap aUK;
    public g aUL;
    private int mGiftId;

    public String Gj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_GIFT_ID, this.mGiftId);
            if (!TextUtils.isEmpty(this.aUH)) {
                jSONObject.put("gift_img_url", Base64.encodeBytes(this.aUH.getBytes()));
            }
            jSONObject.put("gift_index", this.aUI);
            jSONObject.put("gift_count", this.aUJ);
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean gE(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mGiftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
            String optString = jSONObject.optString("gift_img_url");
            if (!TextUtils.isEmpty(optString)) {
                this.aUH = new String(Base64.decode(optString.getBytes()));
            }
            this.aUI = jSONObject.optInt("gift_index");
            this.aUJ = jSONObject.optInt("gift_count");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Gm */
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

    public String Gn() {
        return this.aUH;
    }

    public void gF(String str) {
        this.aUH = str;
    }

    public int Go() {
        return this.aUJ;
    }

    public void dW(int i) {
        this.aUJ = i;
    }
}
