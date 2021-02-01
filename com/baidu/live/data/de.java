package com.baidu.live.data;

import com.baidu.live.adp.BdUniqueId;
/* loaded from: classes11.dex */
public class de implements Cloneable {
    private String aTp;
    private String liveId;
    private boolean mIsAttention;
    private BdUniqueId mPageId;
    private String roomId;

    public String getLiveId() {
        return this.liveId;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public BdUniqueId CR() {
        return this.mPageId;
    }

    public boolean isAttention() {
        return this.mIsAttention;
    }

    public de() {
    }

    public de(String str, String str2, boolean z, BdUniqueId bdUniqueId) {
        this.aTp = str;
        this.liveId = str2;
        this.mIsAttention = z;
        this.mPageId = bdUniqueId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: CS */
    public de clone() {
        try {
            return (de) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String CT() {
        return this.aTp;
    }
}
