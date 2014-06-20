package com.baidu.adp.framework.client.socket;

import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
class d extends BdAsyncTask<String, Integer, SocketResponsedMessage> {
    private static BdAsyncTaskParallel a = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, com.baidu.adp.lib.asyncTask.l.a());
    private e b;
    private com.baidu.adp.framework.client.socket.coder.c c;
    private g d;
    private int e;

    public d(com.baidu.adp.framework.client.socket.coder.c cVar, g gVar, e eVar, int i) {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = 0;
        this.c = cVar;
        this.d = gVar;
        this.b = eVar;
        this.e = i;
        setPriority(4);
        setParallel(a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public SocketResponsedMessage doInBackground(String... strArr) {
        SocketResponsedMessage socketResponsedMessage = null;
        int i = 0;
        if (this.c == null) {
            return null;
        }
        try {
            i = this.c.a.c();
            com.baidu.adp.framework.client.socket.coder.c a2 = com.baidu.adp.framework.client.socket.coder.b.a().a(this.c);
            SocketResponsedMessage a3 = com.baidu.adp.framework.client.socket.coder.b.a().a(i, a2.b, a2.c, a2.d, this.d != null ? this.d.j() : null);
            if (a3 != null) {
                try {
                    if (this.d != null && this.c != null) {
                        a3.setCostTime(System.currentTimeMillis() - this.d.d());
                        a3.setDownSize(this.c.d);
                        a3.setRetry(this.d.o());
                        return a3;
                    }
                    return a3;
                } catch (CoderException e) {
                    socketResponsedMessage = a3;
                    m.a("unpacker", i, this.e, "unpacktask", l.m, "onBinaryMesssage decodebody error");
                    return socketResponsedMessage;
                }
            }
            return a3;
        } catch (CoderException e2) {
        }
    }

    private boolean a(SocketResponsedMessage socketResponsedMessage, g gVar) {
        if (this.e == 0 || gVar == null || socketResponsedMessage != null) {
            return true;
        }
        m.a("unpacker", 0, this.e, "checkresponsedMessage", l.n, "ack cont responsed");
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(SocketResponsedMessage socketResponsedMessage) {
        super.onPostExecute(socketResponsedMessage);
        b(socketResponsedMessage);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
        b(null);
    }

    private void b(SocketResponsedMessage socketResponsedMessage) {
        if (this.b != null) {
            boolean a2 = a(socketResponsedMessage, this.d);
            f fVar = new f();
            fVar.a = socketResponsedMessage;
            if (!a2) {
                fVar.b = this.d;
            }
            this.b.a(fVar);
        }
    }
}
