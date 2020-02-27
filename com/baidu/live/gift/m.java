package com.baidu.live.gift;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.Base64;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m implements Cloneable {
    private String ahv;
    private int ahw;
    private int ahx;
    public Bitmap ahy;
    public g ahz;
    private int mGiftId;

    public String so() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_GIFT_ID, this.mGiftId);
            if (!TextUtils.isEmpty(this.ahv)) {
                jSONObject.put("gift_img_url", Base64.encodeBytes(this.ahv.getBytes()));
            }
            jSONObject.put("gift_index", this.ahw);
            jSONObject.put("gift_count", this.ahx);
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean di(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mGiftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
            String optString = jSONObject.optString("gift_img_url");
            if (!TextUtils.isEmpty(optString)) {
                this.ahv = new String(Base64.decode(optString.getBytes()));
            }
            this.ahw = jSONObject.optInt("gift_index");
            this.ahx = jSONObject.optInt("gift_count");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: sr */
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

    public String ss() {
        return this.ahv;
    }

    public void dj(String str) {
        this.ahv = str;
    }

    public int st() {
        return this.ahx;
    }

    public void bs(int i) {
        this.ahx = i;
    }
}
