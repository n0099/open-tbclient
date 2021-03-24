package com.baidu.ala.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class AlaAttentionData implements Cloneable {
    public static final String FROM_IN_LIVE = "1";
    public static final String FROM_NORMAL = "0";
    public String forumId;
    public String from;
    public boolean isGod;
    public String mInLive;
    public boolean mIsAttention;
    public BdUniqueId mPageId;
    public String mPortrait;
    public String mUserId;

    public AlaAttentionData() {
        this.mInLive = "0";
        this.from = "0";
        this.forumId = null;
        this.isGod = false;
    }

    public String getForumId() {
        return this.forumId;
    }

    public String getFrom() {
        return this.from;
    }

    public String getInLive() {
        return this.mInLive;
    }

    public BdUniqueId getPageId() {
        return this.mPageId;
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public boolean isAttention() {
        return this.mIsAttention;
    }

    public boolean isGod() {
        return this.isGod;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void setGod(boolean z) {
        this.isGod = z;
    }

    public void setInLive(String str) {
        this.mInLive = str;
    }

    public void setIsAttention(boolean z) {
        this.mIsAttention = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public AlaAttentionData m10clone() {
        try {
            return (AlaAttentionData) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public AlaAttentionData(String str, String str2, boolean z, BdUniqueId bdUniqueId) {
        this(str, str2, "0", z, bdUniqueId);
    }

    public AlaAttentionData(String str, String str2, String str3, boolean z, BdUniqueId bdUniqueId) {
        this.mInLive = "0";
        this.from = "0";
        this.forumId = null;
        this.isGod = false;
        this.mPortrait = str;
        this.mUserId = str2;
        this.mIsAttention = z;
        this.mInLive = str3;
        this.mPageId = bdUniqueId;
    }
}
