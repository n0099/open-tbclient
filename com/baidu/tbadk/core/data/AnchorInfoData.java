package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AnchorInfo;
/* loaded from: classes3.dex */
public class AnchorInfoData extends OrmObject implements Serializable {
    public static final long serialVersionUID = 1;
    public int isVip;
    public String portrait = "";
    public String name = "";
    public int startTime = 0;
    public int status = 0;
    public long authorId = 0;
    public String authorName = "";
    public int listeners = 0;
    public int likers = 0;
    public long group_id = 0;
    public String intro = "";
    public String publisherPortrait = "";
    public String labelName = "";

    public long getAuthorId() {
        return this.authorId;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public long getGroup_id() {
        return this.group_id;
    }

    public String getIntro() {
        return this.intro;
    }

    public int getIsVip() {
        return this.isVip;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public int getLikers() {
        return this.likers;
    }

    public int getListeners() {
        return this.listeners;
    }

    public String getName() {
        return this.name;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public String getPublisherPortrait() {
        return this.publisherPortrait;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public int getStatus() {
        return this.status;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.portrait = jSONObject.getString("portrait");
                this.name = jSONObject.getString("name");
                this.startTime = jSONObject.getInt("start_time");
                this.status = jSONObject.getInt("status");
                this.authorId = jSONObject.getLong("author_id");
                this.authorName = jSONObject.getString("author_name");
                this.listeners = jSONObject.getInt("listeners");
                this.likers = jSONObject.getInt("likers");
                this.group_id = jSONObject.optLong("group_id", 0L);
                this.intro = jSONObject.getString("intro");
                this.publisherPortrait = jSONObject.getString("publisherPortrait");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void parserProtobuf(AnchorInfo anchorInfo) {
        if (anchorInfo != null) {
            this.authorId = anchorInfo.author_id.longValue();
            this.authorName = anchorInfo.author_name;
            this.group_id = anchorInfo.group_id.longValue();
            this.intro = anchorInfo.intro;
            this.likers = anchorInfo.likers.intValue();
            this.listeners = anchorInfo.listeners.intValue();
            this.name = anchorInfo.name;
            this.portrait = anchorInfo.portrait;
            this.publisherPortrait = anchorInfo.publisherPortrait;
            this.startTime = anchorInfo.start_time.intValue();
            this.status = anchorInfo.status.intValue();
            this.labelName = anchorInfo.label_name;
            this.isVip = anchorInfo.is_vip.intValue();
        }
    }

    public void setAuthorId(long j) {
        this.authorId = j;
    }

    public void setAuthorName(String str) {
        this.authorName = str;
    }

    public void setGroup_id(long j) {
        this.group_id = j;
    }

    public void setIntro(String str) {
        this.intro = str;
    }

    public void setIsVip(int i) {
        this.isVip = i;
    }

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public void setLikers(int i) {
        this.likers = i;
    }

    public void setListeners(int i) {
        this.listeners = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public void setPublisherPortrait(String str) {
        this.publisherPortrait = str;
    }

    public void setStartTime(int i) {
        this.startTime = i;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
