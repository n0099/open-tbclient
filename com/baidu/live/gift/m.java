package com.baidu.live.gift;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.Base64;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class m implements Cloneable {
    private String afo;
    private int afp;
    private int afq;
    public Bitmap afr;
    public g afs;
    private int mGiftId;

    public String rn() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_GIFT_ID, this.mGiftId);
            if (!TextUtils.isEmpty(this.afo)) {
                jSONObject.put("gift_img_url", Base64.encodeBytes(this.afo.getBytes()));
            }
            jSONObject.put("gift_index", this.afp);
            jSONObject.put("gift_count", this.afq);
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean cZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mGiftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
            String optString = jSONObject.optString("gift_img_url");
            if (!TextUtils.isEmpty(optString)) {
                this.afo = new String(Base64.decode(optString.getBytes()));
            }
            this.afp = jSONObject.optInt("gift_index");
            this.afq = jSONObject.optInt("gift_count");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: rq */
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

    public String rr() {
        return this.afo;
    }

    public void da(String str) {
        this.afo = str;
    }

    public int rs() {
        return this.afq;
    }

    public void bl(int i) {
        this.afq = i;
    }
}
