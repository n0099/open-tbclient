package com.baidu.adp.lib.webSocket;

import com.baidu.adp.lib.webSocket.k;
import java.util.Map;
/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, c cVar);

        void a(c cVar);

        void b(c cVar);

        void b(k.a aVar);

        void c(c cVar);

        void d(int i, String str);

        void k(byte[] bArr);

        void mG();

        void onOpen(Map<String, String> map);

        void onTextMessage(String str);
    }
}
