package com.baidu.lcp.sdk.pb;

import com.google.protobuf.Internal;
/* loaded from: classes2.dex */
public enum RpcMetaPb$CompressType implements Internal.EnumLite {
    COMPRESS_NONE(0, 0),
    COMPRESS_GZIP(1, 1);
    
    public static final int COMPRESS_GZIP_VALUE = 1;
    public static final int COMPRESS_NONE_VALUE = 0;
    public static Internal.EnumLiteMap<RpcMetaPb$CompressType> internalValueMap = new Internal.EnumLiteMap<RpcMetaPb$CompressType>() { // from class: com.baidu.lcp.sdk.pb.RpcMetaPb$CompressType.a
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a */
        public RpcMetaPb$CompressType findValueByNumber(int i) {
            return RpcMetaPb$CompressType.valueOf(i);
        }
    };
    public final int value;

    RpcMetaPb$CompressType(int i, int i2) {
        this.value = i2;
    }

    public static Internal.EnumLiteMap<RpcMetaPb$CompressType> internalGetValueMap() {
        return internalValueMap;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    public static RpcMetaPb$CompressType valueOf(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return COMPRESS_GZIP;
        }
        return COMPRESS_NONE;
    }
}
