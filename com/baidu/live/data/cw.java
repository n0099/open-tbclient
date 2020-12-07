package com.baidu.live.data;

import com.baidu.live.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class cw implements Cloneable {
    private String aUa;
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

    public BdUniqueId Ge() {
        return this.mPageId;
    }

    public boolean isAttention() {
        return this.mIsAttention;
    }

    public cw() {
    }

    public cw(String str, String str2, boolean z, BdUniqueId bdUniqueId) {
        this.aUa = str;
        this.liveId = str2;
        this.mIsAttention = z;
        this.mPageId = bdUniqueId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Gf */
    public cw clone() {
        try {
            return (cw) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String Gg() {
        return this.aUa;
    }
}
