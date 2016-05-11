package com.baidu.tbadk.core.data;

import com.baidu.tbadk.core.atomData.LiveGroupLikeListActivityConfig;
import com.baidu.tbadk.core.atomData.ThActivityDetailActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AnchorInfo;
/* loaded from: classes.dex */
public class AnchorInfoData extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
    private static final long serialVersionUID = 1;
    private int isVip;
    private String portrait = "";
    private String name = "";
    private int startTime = 0;
    private int status = 0;
    private long authorId = 0;
    private String authorName = "";
    private int listeners = 0;
    private int likers = 0;
    private int group_id = 0;
    private String intro = "";
    private String publisherPortrait = "";
    private String labelName = "";

    public String getPublisherPortrait() {
        return this.publisherPortrait;
    }

    public void setPublisherPortrait(String str) {
        this.publisherPortrait = str;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public void setStartTime(int i) {
        this.startTime = i;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public long getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(long j) {
        this.authorId = j;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public void setAuthorName(String str) {
        this.authorName = str;
    }

    public int getListeners() {
        return this.listeners;
    }

    public void setListeners(int i) {
        this.listeners = i;
    }

    public int getLikers() {
        return this.likers;
    }

    public void setLikers(int i) {
        this.likers = i;
    }

    public int getGroup_id() {
        return this.group_id;
    }

    public void setGroup_id(int i) {
        this.group_id = i;
    }

    public String getIntro() {
        return this.intro;
    }

    public void setIntro(String str) {
        this.intro = str;
    }

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public int getIsVip() {
        return this.isVip;
    }

    public void setIsVip(int i) {
        this.isVip = i;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.portrait = jSONObject.getString(IntentConfig.PORTRAIT);
                this.name = jSONObject.getString("name");
                this.startTime = jSONObject.getInt(ThActivityDetailActivityConfig.START_TIME);
                this.status = jSONObject.getInt("status");
                this.authorId = jSONObject.getLong("author_id");
                this.authorName = jSONObject.getString("author_name");
                this.listeners = jSONObject.getInt("listeners");
                this.likers = jSONObject.getInt(LiveGroupLikeListActivityConfig.LIKERS);
                this.group_id = jSONObject.getInt("group_id");
                this.intro = jSONObject.getString("intro");
                this.publisherPortrait = jSONObject.getString("publisherPortrait");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void parserProtobuf(AnchorInfo anchorInfo) {
        if (anchorInfo != null) {
            this.authorId = anchorInfo.author_id.longValue();
            this.authorName = anchorInfo.author_name;
            this.group_id = anchorInfo.group_id.intValue();
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
}
