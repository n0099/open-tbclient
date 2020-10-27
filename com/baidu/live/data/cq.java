package com.baidu.live.data;

import com.baidu.live.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class cq implements Cloneable {
    private String aRs;
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

    public BdUniqueId EB() {
        return this.mPageId;
    }

    public boolean isAttention() {
        return this.mIsAttention;
    }

    public cq() {
    }

    public cq(String str, String str2, boolean z, BdUniqueId bdUniqueId) {
        this.aRs = str;
        this.liveId = str2;
        this.mIsAttention = z;
        this.mPageId = bdUniqueId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: EC */
    public cq clone() {
        try {
            return (cq) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String ED() {
        return this.aRs;
    }
}
