package com.baidu.adp.framework.message;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class SocketMessage extends Message<byte[]> {
    private static String GLOBAL_ENCODE_NAME = "toByteArray";
    private Object mData;
    private String mEncodeName;
    private int mRetryCount;
    private int squencedId;

    public static void setGlobalEncodeName(String str) {
        GLOBAL_ENCODE_NAME = str;
    }

    public SocketMessage(int i) {
        super(i);
        this.mData = null;
        this.mEncodeName = null;
        this.mRetryCount = 0;
        this.squencedId = 0;
        this.mEncodeName = GLOBAL_ENCODE_NAME;
    }

    public void setData(Object obj) {
        this.mData = obj;
    }

    public SocketMessage(int i, Object obj) {
        super(i);
        this.mData = null;
        this.mEncodeName = null;
        this.mRetryCount = 0;
        this.squencedId = 0;
        this.mData = obj;
        this.mEncodeName = GLOBAL_ENCODE_NAME;
    }

    public SocketMessage(int i, BdUniqueId bdUniqueId) {
        super(i, bdUniqueId);
        this.mData = null;
        this.mEncodeName = null;
        this.mRetryCount = 0;
        this.squencedId = 0;
        this.mEncodeName = GLOBAL_ENCODE_NAME;
    }

    public Object getData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public byte[] encodeInBackGround() {
        Object data = getData();
        if (data instanceof byte[]) {
            return (byte[]) data;
        }
        if (data == null) {
            return null;
        }
        try {
            Object invoke = data.getClass().getMethod(this.mEncodeName, new Class[0]).invoke(data, new Object[0]);
            if (invoke != null && (invoke instanceof byte[])) {
                return (byte[]) invoke;
            }
        } catch (Throwable th) {
            BdLog.detailException("SocketMessage encode error. cmd:" + getCmd(), th);
        }
        return null;
    }

    @Override // com.baidu.adp.framework.message.Message
    public boolean checkCmd(int i) {
        return FrameHelper.r(i);
    }

    public String getEncodeName() {
        return this.mEncodeName;
    }

    public void setEncodeName(String str) {
        this.mEncodeName = str;
    }

    public int getmRetryCount() {
        return this.mRetryCount;
    }

    public void setmRetryCount(int i) {
        this.mRetryCount = i;
    }

    public int getSquencedId() {
        return this.squencedId;
    }

    public void setSquencedId(int i) {
        this.squencedId = i;
    }
}
