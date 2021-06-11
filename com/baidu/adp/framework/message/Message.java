package com.baidu.adp.framework.message;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class Message<T> extends OrmObject {
    public long clientLogID;
    public final int mCmd;
    public BdUniqueId mTag;
    public Object mExtra = null;
    public Object mSelf = null;
    public long mStartTime = 0;
    public long encodedBinarySize = 0;
    public int squencedId = 0;

    public Message(int i2) {
        this.mCmd = i2;
        check();
        this.clientLogID = BdStatisticsManager.getInstance().getClientLogId();
    }

    private void check() {
        if (!checkCmd(this.mCmd)) {
            throw new InvalidParameterException("cmd invalid");
        }
    }

    public abstract boolean checkCmd(int i2);

    public abstract /* synthetic */ T encodeInBackGround();

    public long getClientLogID() {
        return this.clientLogID;
    }

    public int getCmd() {
        return this.mCmd;
    }

    public long getEncodedBinarySize() {
        return this.encodedBinarySize;
    }

    public Object getExtra() {
        return this.mExtra;
    }

    public Object getSelf() {
        return this.mSelf;
    }

    public int getSquencedId() {
        return this.squencedId;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public BdUniqueId getTag() {
        return this.mTag;
    }

    public void setClientLogID(long j) {
        this.clientLogID = j;
    }

    public void setEncodedBinarySize(long j) {
        this.encodedBinarySize = j;
    }

    public void setExtra(Object obj) {
        this.mExtra = obj;
    }

    public void setSelf(Object obj) {
        this.mSelf = obj;
    }

    public void setSquencedId(int i2) {
        this.squencedId = i2;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public Message(int i2, BdUniqueId bdUniqueId) {
        this.mCmd = i2;
        this.mTag = bdUniqueId;
        check();
        this.clientLogID = BdStatisticsManager.getInstance().getClientLogId();
    }
}
