package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
import org.json.JSONObject;
import tbclient.ThemeCardInUser;
/* loaded from: classes2.dex */
public class ThemeCardInUserData extends OrmObject implements Serializable {
    private static final long serialVersionUID = 1;
    private long cardId;
    private String cardImageUrlAndroid;
    private String cardImageUrlIos;
    private String coordinate;
    private int freeLevel;

    public void parser(ThemeCardInUser themeCardInUser) {
        if (themeCardInUser != null) {
            this.cardId = themeCardInUser.props_id.longValue();
            this.cardImageUrlAndroid = themeCardInUser.img_android;
            this.cardImageUrlIos = themeCardInUser.img_ios;
            this.freeLevel = themeCardInUser.level.intValue();
            this.coordinate = themeCardInUser.coordinate;
        }
    }

    public void parser(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cardId = jSONObject.optLong("props_id");
            this.cardImageUrlAndroid = jSONObject.optString("img_android");
            this.cardImageUrlIos = jSONObject.optString("img_ios");
            this.freeLevel = jSONObject.optInt("level", 0);
            this.coordinate = jSONObject.optString("coordinate");
        }
    }

    public long getCardId() {
        return this.cardId;
    }

    public void setCardId(long j) {
        this.cardId = j;
    }

    public String getCardImageUrlIos() {
        return this.cardImageUrlIos;
    }

    public void setCardImageUrlIos(String str) {
        this.cardImageUrlIos = str;
    }

    public String getCardImageUrlAndroid() {
        return this.cardImageUrlAndroid;
    }

    public void setCardImageUrlAndroid(String str) {
        this.cardImageUrlAndroid = str;
    }

    public int getFreeLevel() {
        return this.freeLevel;
    }

    public void setFreeLevel(int i) {
        this.freeLevel = i;
    }

    public String getCoordinate() {
        return this.coordinate;
    }

    public void setCoordinate(String str) {
        this.coordinate = str;
    }
}
