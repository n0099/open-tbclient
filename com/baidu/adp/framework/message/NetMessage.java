package com.baidu.adp.framework.message;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public abstract class NetMessage {
    private static final String HTTP_DATA_KEY = "data";
    private static final String HTTP_HEADER_KEY = "x_bd_data_type";
    private long clientLogID;
    private int httpCmd;
    private int socketCmd;
    private BdUniqueId tag;
    private HttpMessage mHttpMessage = null;
    private SocketMessage mSocketMessage = null;
    private NetType mNetType = NetType.AUTO;
    private int socketErrNo = 0;

    /* loaded from: classes.dex */
    public enum NetType {
        SOCKET,
        HTTP,
        AUTO;

        /* JADX DEBUG: Replace access to removed values field (qw) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static NetType[] valuesCustom() {
            NetType[] valuesCustom = values();
            int length = valuesCustom.length;
            NetType[] netTypeArr = new NetType[length];
            System.arraycopy(valuesCustom, 0, netTypeArr, 0, length);
            return netTypeArr;
        }
    }

    protected abstract Object encode(boolean z);

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
        this.clientLogID = com.baidu.adp.lib.stats.a.hl().hn();
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
}
