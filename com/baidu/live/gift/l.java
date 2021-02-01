package com.baidu.live.gift;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.Base64;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class l implements Cloneable {
    private String aXq;
    private int aXr;
    private int aXs;
    public Bitmap aXt;
    public g aXu;
    private int mGiftId;

    public String EM() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_GIFT_ID, this.mGiftId);
            if (!TextUtils.isEmpty(this.aXq)) {
                jSONObject.put("gift_img_url", Base64.encodeBytes(this.aXq.getBytes()));
            }
            jSONObject.put("gift_index", this.aXr);
            jSONObject.put("gift_count", this.aXs);
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean fS(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mGiftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
            String optString = jSONObject.optString("gift_img_url");
            if (!TextUtils.isEmpty(optString)) {
                this.aXq = new String(Base64.decode(optString.getBytes()));
            }
            this.aXr = jSONObject.optInt("gift_index");
            this.aXs = jSONObject.optInt("gift_count");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: EP */
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

    public String EQ() {
        return this.aXq;
    }

    public void fT(String str) {
        this.aXq = str;
    }

    public int ER() {
        return this.aXs;
    }

    public void cJ(int i) {
        this.aXs = i;
    }
}
