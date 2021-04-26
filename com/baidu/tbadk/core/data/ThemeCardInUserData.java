package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.ThemeCardInUser;
/* loaded from: classes3.dex */
public class ThemeCardInUserData extends OrmObject implements Serializable {
    public static final long serialVersionUID = 1;
    public long cardId;
    public String cardImageUrlAndroid;
    public String cardImageUrlIos;
    public String coordinate;
    public int freeLevel;

    public long getCardId() {
        return this.cardId;
    }

    public String getCardImageUrlAndroid() {
        return this.cardImageUrlAndroid;
    }

    public String getCardImageUrlIos() {
        return this.cardImageUrlIos;
    }

    public String getCoordinate() {
        return this.coordinate;
    }

    public int getFreeLevel() {
        return this.freeLevel;
    }

    public void parser(ThemeCardInUser themeCardInUser) {
        if (themeCardInUser == null) {
            return;
        }
        this.cardId = themeCardInUser.props_id.longValue();
        this.cardImageUrlAndroid = themeCardInUser.img_android;
        this.cardImageUrlIos = themeCardInUser.img_ios;
        this.freeLevel = themeCardInUser.level.intValue();
        this.coordinate = themeCardInUser.coordinate;
    }

    public void setCardId(long j) {
        this.cardId = j;
    }

    public void setCardImageUrlAndroid(String str) {
        this.cardImageUrlAndroid = str;
    }

    public void setCardImageUrlIos(String str) {
        this.cardImageUrlIos = str;
    }

    public void setCoordinate(String str) {
        this.coordinate = str;
    }

    public void setFreeLevel(int i2) {
        this.freeLevel = i2;
    }

    public void parser(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.cardId = jSONObject.optLong("props_id");
        this.cardImageUrlAndroid = jSONObject.optString("img_android");
        this.cardImageUrlIos = jSONObject.optString("img_ios");
        this.freeLevel = jSONObject.optInt("level", 0);
        this.coordinate = jSONObject.optString("coordinate");
    }
}
