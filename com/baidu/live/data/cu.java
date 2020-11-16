package com.baidu.live.data;

import com.baidu.live.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class cu implements Cloneable {
    private String aQY;
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

    public BdUniqueId Et() {
        return this.mPageId;
    }

    public boolean isAttention() {
        return this.mIsAttention;
    }

    public cu() {
    }

    public cu(String str, String str2, boolean z, BdUniqueId bdUniqueId) {
        this.aQY = str;
        this.liveId = str2;
        this.mIsAttention = z;
        this.mPageId = bdUniqueId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Eu */
    public cu clone() {
        try {
            return (cu) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String Ev() {
        return this.aQY;
    }
}
