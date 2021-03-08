package com.baidu.live.data;

import com.baidu.live.adp.BdUniqueId;
/* loaded from: classes10.dex */
public class de implements Cloneable {
    private String aUP;
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

    public BdUniqueId CU() {
        return this.mPageId;
    }

    public boolean isAttention() {
        return this.mIsAttention;
    }

    public de() {
    }

    public de(String str, String str2, boolean z, BdUniqueId bdUniqueId) {
        this.aUP = str;
        this.liveId = str2;
        this.mIsAttention = z;
        this.mPageId = bdUniqueId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: CV */
    public de clone() {
        try {
            return (de) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String CW() {
        return this.aUP;
    }
}
