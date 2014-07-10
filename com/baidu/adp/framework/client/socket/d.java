package com.baidu.adp.framework.client.socket;

import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
class d extends BdAsyncTask<String, SocketResponsedMessage, SocketResponsedMessage> {
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
        if (gVar == null || gVar.s()) {
            setParallel(a);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public SocketResponsedMessage doInBackground(String... strArr) {
        int i;
        com.baidu.adp.framework.client.socket.coder.c cVar;
        SocketResponsedMessage socketResponsedMessage;
        com.baidu.adp.framework.client.socket.coder.c cVar2;
        SocketResponsedMessage socketResponsedMessage2;
        if (this.c != null) {
            try {
                i = this.c.a.c();
                try {
                    cVar2 = com.baidu.adp.framework.client.socket.coder.b.a().a(this.c);
                    try {
                        SocketMessage j = this.d != null ? this.d.j() : null;
                        if (cVar2.c != 0 || cVar2.d != cVar2.b.length) {
                            if (cVar2.d <= 0) {
                                cVar2.b = null;
                            } else {
                                cVar2.b = ByteBuffer.wrap(cVar2.b, cVar2.c, cVar2.d).array();
                            }
                        }
                        socketResponsedMessage2 = com.baidu.adp.framework.client.socket.coder.b.a().a(i, cVar2.b, j);
                        if (socketResponsedMessage2 != null) {
                            try {
                                if (this.d != null && this.c != null) {
                                    socketResponsedMessage2.setCostTime(System.currentTimeMillis() - this.d.d());
                                    socketResponsedMessage2.setDownSize(this.c.d);
                                    socketResponsedMessage2.setRetry(this.d.o());
                                }
                                try {
                                    socketResponsedMessage2.beforeDispatchInBackGround(i, cVar2.b);
                                } catch (Exception e) {
                                    BdLog.e(e.getMessage());
                                }
                            } catch (CoderException e2) {
                                cVar = cVar2;
                                socketResponsedMessage = socketResponsedMessage2;
                                m.a("unpacker", i, this.e, "unpacktask", l.m, "onBinaryMesssage decodebody error");
                                cVar2 = cVar;
                                socketResponsedMessage2 = socketResponsedMessage;
                                publishProgress(socketResponsedMessage2);
                                socketResponsedMessage2.afterDispatchInBackGround(i, cVar2.b);
                                return null;
                            }
                        }
                    } catch (CoderException e3) {
                        cVar = cVar2;
                        socketResponsedMessage = null;
                    }
                } catch (CoderException e4) {
                    cVar = null;
                    socketResponsedMessage = null;
                }
            } catch (CoderException e5) {
                i = 0;
                cVar = null;
                socketResponsedMessage = null;
            }
            publishProgress(socketResponsedMessage2);
            try {
                socketResponsedMessage2.afterDispatchInBackGround(i, cVar2.b);
            } catch (Exception e6) {
                BdLog.e(e6.getMessage());
            }
        }
        return null;
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
    public void onProgressUpdate(SocketResponsedMessage... socketResponsedMessageArr) {
        if (socketResponsedMessageArr != null && socketResponsedMessageArr.length > 0) {
            a(socketResponsedMessageArr[0]);
        } else {
            a((SocketResponsedMessage) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
        a((SocketResponsedMessage) null);
    }

    private void a(SocketResponsedMessage socketResponsedMessage) {
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
