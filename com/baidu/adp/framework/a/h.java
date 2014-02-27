package com.baidu.adp.framework.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.network.a.k;
import com.baidu.adp.lib.network.a.l;
/* loaded from: classes.dex */
final class h extends BdAsyncTask<byte[], String, com.baidu.adp.framework.message.h> {
    final /* synthetic */ g a;
    private byte[] b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ com.baidu.adp.framework.message.h a(byte[]... bArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ void a(com.baidu.adp.framework.message.h hVar) {
        com.baidu.adp.framework.message.h hVar2 = hVar;
        if (hVar2 != null) {
            this.a.a.a(hVar2);
        }
    }

    public h(g gVar, byte[] bArr) {
        this.a = gVar;
        this.b = null;
        this.b = bArr;
        setImmediatelyExecut(true);
        setTag(1);
    }

    private com.baidu.adp.framework.message.h d() {
        k b = com.baidu.adp.framework.e.c.a().b();
        if (b == null) {
            com.baidu.adp.lib.util.e.b("WebSocketUnPacker not defined");
        }
        byte[] bArr = this.b;
        l a = b.a();
        if (a == null) {
            com.baidu.adp.lib.util.e.b("WebSocketUnPacker UnPack Fail");
            return null;
        }
        int b2 = a.b();
        try {
            com.baidu.adp.framework.message.h newInstance = ((com.baidu.adp.framework.task.c) this.a.a.b(b2)).d().newInstance();
            try {
                newInstance.a(b2, this.b);
                byte[] bArr2 = this.b;
                com.baidu.adp.framework.message.g a2 = this.a.a(a);
                if (a2 != null) {
                    newInstance.a(a2);
                    return newInstance;
                }
                return newInstance;
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b("Can't parser WebSocketResponseMessage!cmd:" + b2);
                return null;
            }
        } catch (Exception e2) {
            com.baidu.adp.lib.util.e.b("Can't instantiate WebSocketResponseMessage!cmd:" + b2);
            return null;
        }
    }
}
