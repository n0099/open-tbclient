package com.baidu.adp.framework.message;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public abstract class NetMessage {
    public static final String HTTP_DATA_KEY = "data";
    public static final String HTTP_HEADER_KEY = "x_bd_data_type";
    public static a mGlobalSwitchToHttpStrategy;
    public long clientLogID;
    public int httpCmd;
    public a mSwitchToHttpStrategy;
    public int socketCmd;
    public BdUniqueId tag;
    public HttpMessage mHttpMessage = null;
    public SocketMessage mSocketMessage = null;
    public NetType mNetType = NetType.AUTO;
    public int socketErrNo = 0;
    public long socketCostTime = 0;

    /* loaded from: classes.dex */
    public enum NetType {
        SOCKET,
        HTTP,
        AUTO
    }

    /* loaded from: classes.dex */
    public interface a {
        boolean checkToSwitchHttp(SocketResponsedMessage socketResponsedMessage);
    }

    public NetMessage(int i2, int i3) {
        init(i2, i3, null);
    }

    private void init(int i2, int i3, BdUniqueId bdUniqueId) {
        this.httpCmd = i2;
        this.socketCmd = i3;
        this.tag = bdUniqueId;
        this.clientLogID = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void setGlobalSwitchToHttpStrategy(a aVar) {
        if (aVar == null) {
            return;
        }
        mGlobalSwitchToHttpStrategy = aVar;
    }

    public abstract Object encode(boolean z);

    public byte[] encodeExtraDataInBackGround() {
        return null;
    }

    public final HttpMessage getHttpMessage() {
        if (this.mHttpMessage == null) {
            HttpMessage httpMessage = new HttpMessage(this.httpCmd, this.tag);
            this.mHttpMessage = httpMessage;
            httpMessage.setExtra(this);
            this.mHttpMessage.setSelf(this);
            this.mHttpMessage.setClientLogID(this.clientLogID);
            this.mHttpMessage.addParam("data", encode(true));
            this.mHttpMessage.addHeader(HTTP_HEADER_KEY, "protobuf");
        }
        return this.mHttpMessage;
    }

    public long getLogID() {
        return this.clientLogID;
    }

    public NetType getNetType() {
        return this.mNetType;
    }

    public long getSocketCostTime() {
        return this.socketCostTime;
    }

    public int getSocketErrNo() {
        return this.socketErrNo;
    }

    public final SocketMessage getSocketMessage() {
        if (this.mSocketMessage == null) {
            SocketMessage socketMessage = new SocketMessage(this.socketCmd, this.tag);
            this.mSocketMessage = socketMessage;
            socketMessage.setData(encode(false));
            this.mSocketMessage.setExtra(this);
            this.mSocketMessage.setSelf(this);
            this.mSocketMessage.setExtraData(encodeExtraDataInBackGround());
            this.mSocketMessage.setClientLogID(this.clientLogID);
        }
        return this.mSocketMessage;
    }

    public a getSwitchToHttpStrategy() {
        a aVar = this.mSwitchToHttpStrategy;
        return aVar == null ? mGlobalSwitchToHttpStrategy : aVar;
    }

    public BdUniqueId getTag() {
        return this.tag;
    }

    public void resetData() {
        this.mHttpMessage = null;
        this.mSocketMessage = null;
    }

    public void setLogID(long j) {
        this.clientLogID = j;
    }

    public void setNetType(NetType netType) {
        this.mNetType = netType;
    }

    public void setSocketCostTime(long j) {
        this.socketCostTime = j;
    }

    public void setSocketErrNo(int i2) {
        this.socketErrNo = i2;
    }

    public void setSwitchToHttpStrategy(a aVar) {
        if (aVar == null) {
            return;
        }
        this.mSwitchToHttpStrategy = aVar;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.tag = bdUniqueId;
    }

    public NetMessage(int i2, int i3, BdUniqueId bdUniqueId) {
        init(i2, i3, bdUniqueId);
    }
}
