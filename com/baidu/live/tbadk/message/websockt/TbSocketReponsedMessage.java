package com.baidu.live.tbadk.message.websockt;

import com.baidu.live.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.adp.lib.cache.BdKVCache;
/* loaded from: classes7.dex */
public abstract class TbSocketReponsedMessage extends SocketResponsedMessage {
    public TbSocketReponsedMessage(int i) {
        super(i);
    }

    public static void saveProtocolBufferDataToCache(BdKVCache<byte[]> bdKVCache, String str, byte[] bArr) {
        if (str != null && bdKVCache != null && bArr != null && bArr.length > 0) {
            bdKVCache.setForever(str, bArr);
        }
    }
}
