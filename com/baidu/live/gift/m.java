package com.baidu.live.gift;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.Base64;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m implements Cloneable {
    private String ahF;
    private int ahG;
    private int ahH;
    public Bitmap ahI;
    public g ahJ;
    private int mGiftId;

    public String st() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_GIFT_ID, this.mGiftId);
            if (!TextUtils.isEmpty(this.ahF)) {
                jSONObject.put("gift_img_url", Base64.encodeBytes(this.ahF.getBytes()));
            }
            jSONObject.put("gift_index", this.ahG);
            jSONObject.put("gift_count", this.ahH);
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean dh(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mGiftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
            String optString = jSONObject.optString("gift_img_url");
            if (!TextUtils.isEmpty(optString)) {
                this.ahF = new String(Base64.decode(optString.getBytes()));
            }
            this.ahG = jSONObject.optInt("gift_index");
            this.ahH = jSONObject.optInt("gift_count");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: sw */
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

    public String sx() {
        return this.ahF;
    }

    public void di(String str) {
        this.ahF = str;
    }

    public int sy() {
        return this.ahH;
    }

    public void bs(int i) {
        this.ahH = i;
    }
}
