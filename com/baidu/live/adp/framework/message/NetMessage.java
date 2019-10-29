package com.baidu.live.adp.framework.message;

import com.baidu.live.adp.BdUniqueId;
/* loaded from: classes6.dex */
public abstract class NetMessage {
    private static final String HTTP_DATA_KEY = "data";
    private static final String HTTP_HEADER_KEY = "x_bd_data_type";
    private static SwitchToHttpStrategy mGlobalSwitchToHttpStrategy;
    private long clientLogID;
    private int httpCmd;
    private SwitchToHttpStrategy mSwitchToHttpStrategy;
    private int socketCmd;
    private BdUniqueId tag;
    private HttpMessage mHttpMessage = null;
    private SocketMessage mSocketMessage = null;
    private NetType mNetType = NetType.AUTO;
    private int socketErrNo = 0;
    private long socketCostTime = 0;

    /* loaded from: classes6.dex */
    public enum NetType {
        SOCKET,
        HTTP,
        AUTO
    }

    /* loaded from: classes6.dex */
    public interface SwitchToHttpStrategy {
        boolean checkToSwitchHttp(SocketResponsedMessage socketResponsedMessage);
    }

    protected abstract Object encode(boolean z);

    public byte[] encodeExtraDataInBackGround() {
        return null;
    }

    public NetMessage(int i, int i2) {
        init(i, i2, null);
    }

    public NetMessage(int i, int i2, BdUniqueId bdUniqueId) {
        init(i, i2, bdUniqueId);
    }

    private void init(int i, int i2, BdUniqueId bdUniqueId) {
        this.httpCmd = i;
        this.socketCmd = i2;
        this.tag = bdUniqueId;
        this.clientLogID = 0L;
    }

    public void resetData() {
        this.mHttpMessage = null;
        this.mSocketMessage = null;
    }

    public final HttpMessage getHttpMessage() {
        if (this.mHttpMessage == null) {
            this.mHttpMessage = new HttpMessage(this.httpCmd, this.tag);
            this.mHttpMessage.setExtra(this);
            this.mHttpMessage.setClientLogID(this.clientLogID);
            this.mHttpMessage.addParam("data", encode(true));
            this.mHttpMessage.addHeader(HTTP_HEADER_KEY, "protobuf");
        }
        return this.mHttpMessage;
    }

    public final SocketMessage getSocketMessage() {
        if (this.mSocketMessage == null) {
            this.mSocketMessage = new SocketMessage(this.socketCmd, this.tag);
            this.mSocketMessage.setData(encode(false));
            this.mSocketMessage.setExtra(this);
            this.mSocketMessage.setExtraData(encodeExtraDataInBackGround());
            this.mSocketMessage.setClientLogID(this.clientLogID);
        }
        return this.mSocketMessage;
    }

    public BdUniqueId getTag() {
        return this.tag;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.tag = bdUniqueId;
    }

    public NetType getNetType() {
        return this.mNetType;
    }

    public void setNetType(NetType netType) {
        this.mNetType = netType;
    }

    public long getLogID() {
        return this.clientLogID;
    }

    public void setLogID(long j) {
        this.clientLogID = j;
    }

    public void setSocketErrNo(int i) {
        this.socketErrNo = i;
    }

    public int getSocketErrNo() {
        return this.socketErrNo;
    }

    public static void setGlobalSwitchToHttpStrategy(SwitchToHttpStrategy switchToHttpStrategy) {
        if (switchToHttpStrategy != null) {
            mGlobalSwitchToHttpStrategy = switchToHttpStrategy;
        }
    }

    public void setSwitchToHttpStrategy(SwitchToHttpStrategy switchToHttpStrategy) {
        if (switchToHttpStrategy != null) {
            this.mSwitchToHttpStrategy = switchToHttpStrategy;
        }
    }

    public SwitchToHttpStrategy getSwitchToHttpStrategy() {
        return this.mSwitchToHttpStrategy == null ? mGlobalSwitchToHttpStrategy : this.mSwitchToHttpStrategy;
    }

    public long getSocketCostTime() {
        return this.socketCostTime;
    }

    public void setSocketCostTime(long j) {
        this.socketCostTime = j;
    }
}
