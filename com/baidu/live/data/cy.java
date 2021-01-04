package com.baidu.live.data;

import com.baidu.live.adp.BdUniqueId;
/* loaded from: classes11.dex */
public class cy implements Cloneable {
    private String aUZ;
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

    public BdUniqueId Fx() {
        return this.mPageId;
    }

    public boolean isAttention() {
        return this.mIsAttention;
    }

    public cy() {
    }

    public cy(String str, String str2, boolean z, BdUniqueId bdUniqueId) {
        this.aUZ = str;
        this.liveId = str2;
        this.mIsAttention = z;
        this.mPageId = bdUniqueId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Fy */
    public cy clone() {
        try {
            return (cy) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String Fz() {
        return this.aUZ;
    }
}
