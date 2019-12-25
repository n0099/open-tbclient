package com.baidu.live.gift;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.Base64;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class m implements Cloneable {
    private String aeF;
    private int aeG;
    private int aeH;
    public Bitmap aeI;
    public g aeJ;
    private int mGiftId;

    public String rb() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_GIFT_ID, this.mGiftId);
            if (!TextUtils.isEmpty(this.aeF)) {
                jSONObject.put("gift_img_url", Base64.encodeBytes(this.aeF.getBytes()));
            }
            jSONObject.put("gift_index", this.aeG);
            jSONObject.put("gift_count", this.aeH);
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean cX(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mGiftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
            String optString = jSONObject.optString("gift_img_url");
            if (!TextUtils.isEmpty(optString)) {
                this.aeF = new String(Base64.decode(optString.getBytes()));
            }
            this.aeG = jSONObject.optInt("gift_index");
            this.aeH = jSONObject.optInt("gift_count");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: re */
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

    public String rf() {
        return this.aeF;
    }

    public void cY(String str) {
        this.aeF = str;
    }

    public int rg() {
        return this.aeH;
    }

    public void bl(int i) {
        this.aeH = i;
    }
}
