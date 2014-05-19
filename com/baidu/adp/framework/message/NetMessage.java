package com.baidu.adp.framework.message;
/* loaded from: classes.dex */
public abstract class NetMessage {
    private static final String HTTP_DATA_KEY = "data";
    private static final String HTTP_HEADER_KEY = "x_bd_data_type";
    private int httpCmd;
    private int socketCmd;
    private int tag;
    private HttpMessage mHttpMessage = null;
    private SocketMessage mSocketMessage = null;
    private NetType mNetType = NetType.AUTO;

    /* loaded from: classes.dex */
    public enum NetType {
        SOCKET,
        HTTP,
        AUTO;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
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
        init(i, i2, 0);
    }

    public NetMessage(int i, int i2, int i3) {
        init(i, i2, i3);
    }

    private void init(int i, int i2, int i3) {
        this.httpCmd = i;
        this.socketCmd = i2;
        this.tag = i3;
    }

    public void resetData() {
        this.mHttpMessage = null;
        this.mSocketMessage = null;
    }

    public final HttpMessage getHttpMessage() {
        if (this.mHttpMessage == null) {
            this.mHttpMessage = new HttpMessage(this.httpCmd, this.tag);
            this.mHttpMessage.setExtra(this);
            this.mHttpMessage.addParam(HTTP_DATA_KEY, encode(true));
            this.mHttpMessage.addHeader(HTTP_HEADER_KEY, "protobuf");
        }
        return this.mHttpMessage;
    }

    public final SocketMessage getSocketMessage() {
        if (this.mSocketMessage == null) {
            this.mSocketMessage = new SocketMessage(this.socketCmd, this.tag);
            this.mSocketMessage.setData(encode(false));
            this.mSocketMessage.setExtra(this);
        }
        return this.mSocketMessage;
    }

    public int getTag() {
        return this.tag;
    }

    public void setTag(int i) {
        this.tag = i;
    }

    public NetType getNetType() {
        return this.mNetType;
    }

    public void setNetType(NetType netType) {
        this.mNetType = netType;
    }
}
