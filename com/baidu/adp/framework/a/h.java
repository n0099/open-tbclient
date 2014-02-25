package com.baidu.adp.framework.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.network.a.k;
import com.baidu.adp.lib.network.a.l;
/* loaded from: classes.dex */
class h extends BdAsyncTask<byte[], String, com.baidu.adp.framework.message.h> {
    final /* synthetic */ g a;
    private byte[] b;

    public h(g gVar, byte[] bArr) {
        this.a = gVar;
        this.b = null;
        this.b = bArr;
        setImmediatelyExecut(true);
        setTag(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.adp.framework.message.h a(byte[]... bArr) {
        k b = com.baidu.adp.framework.e.c.a().b();
        if (b == null) {
            com.baidu.adp.lib.util.f.b("WebSocketUnPacker not defined");
        }
        l a = b.a(this.b);
        if (a == null) {
            com.baidu.adp.lib.util.f.b("WebSocketUnPacker UnPack Fail");
            return null;
        }
        int a2 = a.a();
        try {
            com.baidu.adp.framework.message.h newInstance = ((com.baidu.adp.framework.task.c) this.a.a.e(a2)).d().newInstance();
            try {
                newInstance.a(a2, this.b);
                newInstance.b(a2, this.b);
                com.baidu.adp.framework.message.g a3 = this.a.a(a);
                if (a3 != null) {
                    newInstance.a(a3);
                    return newInstance;
                }
                return newInstance;
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("Can't parser WebSocketResponseMessage!cmd:" + a2);
                return null;
            }
        } catch (Exception e2) {
            com.baidu.adp.lib.util.f.b("Can't instantiate WebSocketResponseMessage!cmd:" + a2);
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.adp.framework.message.h hVar) {
        if (hVar != null) {
            this.a.a.a(hVar);
        }
    }
}
