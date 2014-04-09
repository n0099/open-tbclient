package com.baidu.adp.framework.a;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.network.websocket.CoderException;
import com.baidu.adp.lib.network.websocket.l;
import com.baidu.adp.lib.network.websocket.m;
/* loaded from: classes.dex */
final class h extends BdAsyncTask<byte[], String, SocketResponsedMessage> {
    final /* synthetic */ g a;
    private byte[] b;
    private com.baidu.adp.lib.network.websocket.g c = null;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ SocketResponsedMessage a(byte[]... bArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        if (socketResponsedMessage2 != null) {
            if (socketResponsedMessage2.e() != 0 && com.baidu.adp.framework.e.c.a().i() != null) {
                com.baidu.adp.framework.e.c.a().i().a("dispatchMessage", socketResponsedMessage2.f(), socketResponsedMessage2.e(), socketResponsedMessage2);
            }
            if (this.c != null) {
                this.a.c(this.c);
            }
            this.a.a.a(socketResponsedMessage2);
        }
    }

    public h(g gVar, byte[] bArr) {
        this.a = gVar;
        this.b = null;
        this.b = bArr;
        setImmediatelyExecut(true);
        setTag(1);
    }

    private SocketResponsedMessage a() {
        long currentTimeMillis = System.currentTimeMillis();
        l b = com.baidu.adp.framework.e.c.a().b();
        if (b == null) {
            com.baidu.adp.lib.util.f.b("WebSocketUnPacker not defined");
        }
        m b2 = b.b(this.b);
        try {
            this.b = b.a(this.b);
        } catch (CoderException e) {
            com.baidu.adp.lib.util.f.b("WebSocketUnPacker UnPack Fail" + e.toString());
        }
        if (b2 == null) {
            com.baidu.adp.lib.util.f.b("WebSocketUnPacker UnPack Fail");
            return null;
        }
        int a = b2.a();
        try {
            SocketResponsedMessage newInstance = ((SocketMessageTask) this.a.a.d(a)).d().newInstance();
            newInstance.b(this.b.length);
            this.c = this.a.a(b2);
            com.baidu.adp.framework.message.g f = this.c != null ? this.c.f() : null;
            if (f != null) {
                newInstance.a(f);
                newInstance.a(currentTimeMillis - f.c());
                newInstance.c(f.d());
            }
            try {
                newInstance.a(a, this.b);
                newInstance.b(a, this.b);
                return newInstance;
            } catch (Exception e2) {
                com.baidu.adp.lib.util.f.b("Can't parser WebSocketResponseMessage!cmd:" + a);
                return null;
            }
        } catch (Exception e3) {
            com.baidu.adp.lib.util.f.b("Can't instantiate WebSocketResponseMessage!cmd:" + a);
            return null;
        }
    }
}
