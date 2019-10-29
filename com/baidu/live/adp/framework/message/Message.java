package com.baidu.live.adp.framework.message;

import com.baidu.live.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes6.dex */
public abstract class Message<T> implements IEncode<T> {
    private long clientLogID;
    private final int mCmd;
    private BdUniqueId mTag;
    private Object mExtra = null;
    private long mStartTime = 0;
    private long encodedBinarySize = 0;
    private int squencedId = 0;

    public abstract boolean checkCmd(int i);

    public long getStartTime() {
        return this.mStartTime;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public Message(int i) {
        this.mCmd = i;
        check();
        this.clientLogID = 0L;
    }

    public Message(int i, BdUniqueId bdUniqueId) {
        this.mCmd = i;
        this.mTag = bdUniqueId;
        check();
        this.clientLogID = 0L;
    }

    private void check() {
        if (!checkCmd(this.mCmd)) {
            throw new InvalidParameterException("cmd invalid");
        }
    }

    public int getCmd() {
        return this.mCmd;
    }

    public BdUniqueId getTag() {
        return this.mTag;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public Object getExtra() {
        return this.mExtra;
    }

    public void setExtra(Object obj) {
        this.mExtra = obj;
    }

    public long getEncodedBinarySize() {
        return this.encodedBinarySize;
    }

    public void setEncodedBinarySize(long j) {
        this.encodedBinarySize = j;
    }

    public long getClientLogID() {
        return this.clientLogID;
    }

    public void setClientLogID(long j) {
        this.clientLogID = j;
    }

    public int getSquencedId() {
        return this.squencedId;
    }

    public void setSquencedId(int i) {
        this.squencedId = i;
    }
}
