package com.baidu.adp.framework.message;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class SocketMessage extends Message<byte[]> {
    public static String GLOBAL_ENCODE_NAME = "toByteArray";
    public Object mData;
    public String mEncodeName;
    public Object mExtraData;
    public int mRetryCount;

    public SocketMessage(int i) {
        super(i);
        this.mData = null;
        this.mExtraData = null;
        this.mEncodeName = null;
        this.mRetryCount = 0;
        this.mEncodeName = GLOBAL_ENCODE_NAME;
    }

    public static void setGlobalEncodeName(String str) {
        GLOBAL_ENCODE_NAME = str;
    }

    @Override // com.baidu.adp.framework.message.Message
    public boolean checkCmd(int i) {
        return FrameHelper.c(i);
    }

    public byte[] encodeExtraDataInBackGround() {
        Object obj = this.mExtraData;
        if (obj == null || !(obj instanceof byte[])) {
            return null;
        }
        return (byte[]) obj;
    }

    public Object getData() {
        return this.mData;
    }

    public String getEncodeName() {
        return this.mEncodeName;
    }

    public int getmRetryCount() {
        return this.mRetryCount;
    }

    public void setData(Object obj) {
        this.mData = obj;
    }

    public void setEncodeName(String str) {
        this.mEncodeName = str;
    }

    public void setExtraData(Object obj) {
        this.mExtraData = obj;
    }

    public void setmRetryCount(int i) {
        this.mRetryCount = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.Message
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
            if (invoke == null || !(invoke instanceof byte[])) {
                return null;
            }
            return (byte[]) invoke;
        } catch (Throwable th) {
            BdLog.detailException("SocketMessage encode error. cmd:" + getCmd(), th);
            return null;
        }
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
}
