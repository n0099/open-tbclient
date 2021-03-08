package com.baidu.live.gift;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.Base64;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class l implements Cloneable {
    private String aYQ;
    private int aYR;
    private int aYS;
    public Bitmap aYT;
    public g aYU;
    private int mGiftId;

    public String EP() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_GIFT_ID, this.mGiftId);
            if (!TextUtils.isEmpty(this.aYQ)) {
                jSONObject.put("gift_img_url", Base64.encodeBytes(this.aYQ.getBytes()));
            }
            jSONObject.put("gift_index", this.aYR);
            jSONObject.put("gift_count", this.aYS);
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean fY(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mGiftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
            String optString = jSONObject.optString("gift_img_url");
            if (!TextUtils.isEmpty(optString)) {
                this.aYQ = new String(Base64.decode(optString.getBytes()));
            }
            this.aYR = jSONObject.optInt("gift_index");
            this.aYS = jSONObject.optInt("gift_count");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ES */
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

    public String ET() {
        return this.aYQ;
    }

    public void fZ(String str) {
        this.aYQ = str;
    }

    public int EU() {
        return this.aYS;
    }

    public void cK(int i) {
        this.aYS = i;
    }
}
