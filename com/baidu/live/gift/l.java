package com.baidu.live.gift;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.Base64;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class l implements Cloneable {
    private String aXt;
    private int aXu;
    private int aXv;
    public Bitmap aXw;
    public g aXx;
    private int mGiftId;

    public String HQ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_GIFT_ID, this.mGiftId);
            if (!TextUtils.isEmpty(this.aXt)) {
                jSONObject.put("gift_img_url", Base64.encodeBytes(this.aXt.getBytes()));
            }
            jSONObject.put("gift_index", this.aXu);
            jSONObject.put("gift_count", this.aXv);
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean gY(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mGiftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
            String optString = jSONObject.optString("gift_img_url");
            if (!TextUtils.isEmpty(optString)) {
                this.aXt = new String(Base64.decode(optString.getBytes()));
            }
            this.aXu = jSONObject.optInt("gift_index");
            this.aXv = jSONObject.optInt("gift_count");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: HT */
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

    public String HU() {
        return this.aXt;
    }

    public void gZ(String str) {
        this.aXt = str;
    }

    public int HV() {
        return this.aXv;
    }

    public void em(int i) {
        this.aXv = i;
    }
}
