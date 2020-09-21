package com.baidu.live.data;

import android.graphics.Bitmap;
import android.text.TextUtils;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaLiveStickerInfo implements Serializable {
    public static final int ALA_STICKER_TYPE_IMAGE = 1;
    public static final int ALA_STICKER_TYPE_TEXT = 2;
    public static final int IMAGE_TYPE_HEIGHT = 64;
    public static final int IMAGE_TYPE_WIDTH = 98;
    public static final String STICKER_CENTERX = "sticker_center_x";
    public static final String STICKER_CENTERY = "sticker_center_y";
    public static final String STICKER_ID = "sticker_id";
    public static final String STICKER_LINK = "sticker_link";
    public static final String STICKER_TEXT = "sticker_text";
    public static final String STICKER_TYPE = "sticker_type";
    public static final int TEXT_TYPE_HEIGHT = 64;
    public static final int TEXT_TYPE_WIDTH = 162;
    public Bitmap bitmap;
    public double centerX;
    public double centerY;
    public int id;
    public String link;
    public String text;
    public int type;

    public AlaLiveStickerInfo() {
        this.id = 0;
        this.type = 0;
        this.centerX = 0.0d;
        this.centerY = 0.0d;
    }

    public AlaLiveStickerInfo(AlaLiveStickerInfo alaLiveStickerInfo) {
        this.id = 0;
        this.type = 0;
        this.centerX = 0.0d;
        this.centerY = 0.0d;
        if (alaLiveStickerInfo != null) {
            this.id = alaLiveStickerInfo.id;
            this.type = alaLiveStickerInfo.type;
            this.link = alaLiveStickerInfo.link;
            this.text = alaLiveStickerInfo.text;
            this.centerX = alaLiveStickerInfo.centerX;
            this.centerY = alaLiveStickerInfo.centerY;
            this.bitmap = alaLiveStickerInfo.bitmap;
        }
    }

    public static AlaLiveStickerInfo parse(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        AlaLiveStickerInfo alaLiveStickerInfo = new AlaLiveStickerInfo();
        alaLiveStickerInfo.id = jSONObject.optInt(STICKER_ID);
        alaLiveStickerInfo.type = jSONObject.optInt(STICKER_TYPE);
        alaLiveStickerInfo.link = jSONObject.optString(STICKER_LINK);
        alaLiveStickerInfo.text = jSONObject.optString(STICKER_TEXT);
        alaLiveStickerInfo.centerX = jSONObject.optDouble(STICKER_CENTERX);
        alaLiveStickerInfo.centerY = jSONObject.optDouble(STICKER_CENTERY);
        return alaLiveStickerInfo;
    }

    public static JSONObject createJson(AlaLiveStickerInfo alaLiveStickerInfo) {
        if (alaLiveStickerInfo == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(STICKER_ID, alaLiveStickerInfo.id);
            jSONObject.put(STICKER_TYPE, alaLiveStickerInfo.type);
            jSONObject.put(STICKER_LINK, alaLiveStickerInfo.link);
            jSONObject.put(STICKER_TEXT, alaLiveStickerInfo.text);
            jSONObject.put(STICKER_CENTERX, alaLiveStickerInfo.centerX);
            jSONObject.put(STICKER_CENTERY, alaLiveStickerInfo.centerY);
        } catch (JSONException e) {
            jSONObject = null;
        }
        return jSONObject;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AlaLiveStickerInfo)) {
            AlaLiveStickerInfo alaLiveStickerInfo = (AlaLiveStickerInfo) obj;
            boolean z = TextUtils.isEmpty(this.link) && TextUtils.isEmpty(alaLiveStickerInfo.link);
            if (!TextUtils.isEmpty(this.link) && this.link.equals(alaLiveStickerInfo.link)) {
                z = true;
            }
            boolean z2 = TextUtils.isEmpty(this.text) && TextUtils.isEmpty(alaLiveStickerInfo.text);
            if (!TextUtils.isEmpty(this.text) && this.text.equals(alaLiveStickerInfo.text)) {
                z2 = true;
            }
            if (this.id == alaLiveStickerInfo.id && this.type == alaLiveStickerInfo.type && z && z2 && this.centerX == alaLiveStickerInfo.centerX && this.centerY == alaLiveStickerInfo.centerY) {
                return true;
            }
        }
        return false;
    }
}
