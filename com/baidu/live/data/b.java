package com.baidu.live.data;

import com.baidu.live.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class b implements Cloneable {
    private String forumId;
    private String from;
    private boolean isGod;
    private String mInLive;
    private boolean mIsAttention;
    private BdUniqueId mPageId;
    private String mPortrait;
    private String mUserId;
    private String metaKey;

    public b() {
        this.mInLive = "0";
        this.from = "0";
        this.forumId = null;
        this.isGod = false;
    }

    public b(String str, String str2, String str3, boolean z, BdUniqueId bdUniqueId) {
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

    public b(String str, String str2, String str3, String str4, boolean z, BdUniqueId bdUniqueId) {
        this.mInLive = "0";
        this.from = "0";
        this.forumId = null;
        this.isGod = false;
        this.mPortrait = str;
        this.mUserId = str2;
        this.metaKey = str3;
        this.mIsAttention = z;
        this.mInLive = str4;
        this.mPageId = bdUniqueId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: od */
    public b clone() {
        try {
            return (b) super.clone();
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

    public BdUniqueId oe() {
        return this.mPageId;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    public String getFrom() {
        return this.from;
    }

    public String getForumId() {
        return this.forumId;
    }

    public boolean isGod() {
        return this.isGod;
    }

    public String og() {
        return this.metaKey;
    }
}
