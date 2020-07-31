package com.baidu.live.gift;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.Base64;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class m implements Cloneable {
    private String aJo;
    private int aJp;
    private int aJq;
    public Bitmap aJr;
    public g aJs;
    private int mGiftId;

    public String ze() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_GIFT_ID, this.mGiftId);
            if (!TextUtils.isEmpty(this.aJo)) {
                jSONObject.put("gift_img_url", Base64.encodeBytes(this.aJo.getBytes()));
            }
            jSONObject.put("gift_index", this.aJp);
            jSONObject.put("gift_count", this.aJq);
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean eK(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mGiftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
            String optString = jSONObject.optString("gift_img_url");
            if (!TextUtils.isEmpty(optString)) {
                this.aJo = new String(Base64.decode(optString.getBytes()));
            }
            this.aJp = jSONObject.optInt("gift_index");
            this.aJq = jSONObject.optInt("gift_count");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: zh */
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

    public String zi() {
        return this.aJo;
    }

    public void eL(String str) {
        this.aJo = str;
    }

    public int zj() {
        return this.aJq;
    }

    public void ca(int i) {
        this.aJq = i;
    }
}
