package com.baidu.live.adp.framework.message;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.FrameHelper;
import com.baidu.live.adp.lib.util.BdLog;
/* loaded from: classes3.dex */
public class SocketMessage extends Message<byte[]> {
    private static String GLOBAL_ENCODE_NAME = "toByteArray";
    private Object mData;
    private String mEncodeName;
    private Object mExtraData;
    private int mRetryCount;

    public static void setGlobalEncodeName(String str) {
        GLOBAL_ENCODE_NAME = str;
    }

    public SocketMessage(int i) {
        super(i);
        this.mData = null;
        this.mExtraData = null;
        this.mEncodeName = null;
        this.mRetryCount = 0;
        this.mEncodeName = GLOBAL_ENCODE_NAME;
    }

    public void setData(Object obj) {
        this.mData = obj;
    }

    public void setExtraData(Object obj) {
        this.mExtraData = obj;
    }

    public SocketMessage(int i, Object obj) {
        super(i);
        this.mData = null;
        this.mExtraData = null;
        this.mEncodeName = null;
        this.mRetryCount = 0;
        this.mData = obj;
        this.mEncodeName = GLOBAL_ENCODE_NAME;
    }

    public SocketMessage(int i, BdUniqueId bdUniqueId) {
        super(i, bdUniqueId);
        this.mData = null;
        this.mExtraData = null;
        this.mEncodeName = null;
        this.mRetryCount = 0;
        this.mEncodeName = GLOBAL_ENCODE_NAME;
    }

    public Object getData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.adp.framework.message.IEncode
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

    public byte[] encodeExtraDataInBackGround() {
        if (this.mExtraData == null || !(this.mExtraData instanceof byte[])) {
            return null;
        }
        return (byte[]) this.mExtraData;
    }

    @Override // com.baidu.live.adp.framework.message.Message
    public boolean checkCmd(int i) {
        return FrameHelper.checkSocketCmd(i);
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
}
