package com.baidu.live.data;

import com.baidu.live.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class e implements Cloneable {
    private String from;
    private String mInLive;
    private boolean mIsAttention;
    private BdUniqueId mPageId;
    private String mPortrait;
    private String mUserId;
    private String metaKey;

    public e() {
        this.mInLive = "0";
        this.from = "";
    }

    public e(String str, String str2, boolean z, BdUniqueId bdUniqueId) {
        this(str, str2, "0", z, bdUniqueId);
    }

    public e(String str, String str2, String str3, boolean z, BdUniqueId bdUniqueId) {
        this.mInLive = "0";
        this.from = "";
        this.mPortrait = str;
        this.mUserId = str2;
        this.mIsAttention = z;
        this.mInLive = str3;
        this.mPageId = bdUniqueId;
    }

    public e(String str, String str2, String str3, String str4, boolean z, BdUniqueId bdUniqueId) {
        this.mInLive = "0";
        this.from = "";
        this.mPortrait = str;
        this.mUserId = str2;
        this.metaKey = str3;
        this.mIsAttention = z;
        this.mInLive = str4;
        this.mPageId = bdUniqueId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: DD */
    public e clone() {
        try {
            return (e) super.clone();
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

    public BdUniqueId DE() {
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

    public String DF() {
        return this.metaKey;
    }
}
