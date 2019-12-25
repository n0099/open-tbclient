package com.baidu.ala.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class AlaAttentionData implements Cloneable {
    public static final String FROM_IN_LIVE = "1";
    public static final String FROM_NORMAL = "0";
    private String forumId;
    private String from;
    private boolean isGod;
    private String mInLive;
    private boolean mIsAttention;
    private BdUniqueId mPageId;
    private String mPortrait;
    private String mUserId;

    public AlaAttentionData() {
        this.mInLive = "0";
        this.from = "0";
        this.forumId = null;
        this.isGod = false;
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

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public AlaAttentionData m12clone() {
        try {
            return (AlaAttentionData) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getPortrait() {
        return this.mPortrait;
    }

    public void setPortrait(String str) {
        this.mPortrait = str;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public boolean isAttention() {
        return this.mIsAttention;
    }

    public void setIsAttention(boolean z) {
        this.mIsAttention = z;
    }

    public String getInLive() {
        return this.mInLive;
    }

    public void setInLive(String str) {
        this.mInLive = str;
    }

    public BdUniqueId getPageId() {
        return this.mPageId;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public String getFrom() {
        return this.from;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setGod(boolean z) {
        this.isGod = z;
    }

    public boolean isGod() {
        return this.isGod;
    }
}
