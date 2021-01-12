package com.baidu.live.gift;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.Base64;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class l implements Cloneable {
    private String aUl;
    private int aUm;
    private int aUn;
    public Bitmap aUo;
    public g aUp;
    private int mGiftId;

    public String Dw() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_GIFT_ID, this.mGiftId);
            if (!TextUtils.isEmpty(this.aUl)) {
                jSONObject.put("gift_img_url", Base64.encodeBytes(this.aUl.getBytes()));
            }
            jSONObject.put("gift_index", this.aUm);
            jSONObject.put("gift_count", this.aUn);
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean fx(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mGiftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
            String optString = jSONObject.optString("gift_img_url");
            if (!TextUtils.isEmpty(optString)) {
                this.aUl = new String(Base64.decode(optString.getBytes()));
            }
            this.aUm = jSONObject.optInt("gift_index");
            this.aUn = jSONObject.optInt("gift_count");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Dz */
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

    public String DA() {
        return this.aUl;
    }

    public void fy(String str) {
        this.aUl = str;
    }

    public int DB() {
        return this.aUn;
    }

    public void cE(int i) {
        this.aUn = i;
    }
}
