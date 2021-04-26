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
        public RpcMetaPb$CompressType findValueByNumber(int i2) {
            return RpcMetaPb$CompressType.valueOf(i2);
        }
    };
    public final int value;

    RpcMetaPb$CompressType(int i2, int i3) {
        this.value = i3;
    }

    public static Internal.EnumLiteMap<RpcMetaPb$CompressType> internalGetValueMap() {
        return internalValueMap;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    public static RpcMetaPb$CompressType valueOf(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                return null;
            }
            return COMPRESS_GZIP;
        }
        return COMPRESS_NONE;
    }
}
