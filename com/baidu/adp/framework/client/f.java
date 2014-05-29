package com.baidu.adp.framework.client;

import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.network.websocket.CoderException;
import com.baidu.adp.lib.network.websocket.g;
import com.baidu.adp.lib.network.websocket.l;
import com.baidu.adp.lib.network.websocket.m;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class f extends BdAsyncTask<byte[], String, SocketResponsedMessage> {
    final /* synthetic */ e a;
    private byte[] b;
    private g c = null;

    public f(e eVar, byte[] bArr) {
        BdAsyncTaskParallel bdAsyncTaskParallel;
        this.a = eVar;
        this.b = null;
        this.b = bArr;
        setPriority(4);
        bdAsyncTaskParallel = e.h;
        setParallel(bdAsyncTaskParallel);
        setTag(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public SocketResponsedMessage doInBackground(byte[]... bArr) {
        long currentTimeMillis = System.currentTimeMillis();
        l b = com.baidu.adp.framework.c.c.a().b();
        if (b == null) {
            BdLog.e("WebSocketUnPacker not defined");
        }
        m b2 = b.b(this.b);
        try {
            this.b = b.a(this.b);
            if (b2 == null) {
                BdLog.e("WebSocketUnPacker UnPack Fail");
                return null;
            }
            int a = b2.a();
            try {
                SocketResponsedMessage newInstance = ((SocketMessageTask) this.a.a.findTask(a)).c().newInstance();
                newInstance.setmDownSize(this.b.length);
                this.c = this.a.a(b2);
                SocketMessage g = this.c != null ? this.c.g() : null;
                if (g != null) {
                    newInstance.setmCostTime(currentTimeMillis - g.getmStartSendTime());
                    newInstance.setmRetry(g.getmRetryCount());
                    newInstance.setOrginalMessage(g);
                }
                try {
                    newInstance.decodeInBackGround(a, this.b);
                    newInstance.processInBackGround(a, this.b);
                    return newInstance;
                } catch (Exception e) {
                    BdLog.detailException("Can't parser WebSocketResponseMessage!cmd:" + a, e);
                    return null;
                }
            } catch (Exception e2) {
                BdLog.detailException("Can't instantiate WebSocketResponseMessage!cmd:" + a, e2);
                return null;
            }
        } catch (CoderException e3) {
            BdLog.detailException("WebSocketUnPacker UnPack Fail", e3);
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null) {
            if (socketResponsedMessage.getError() != 0 && com.baidu.adp.framework.c.c.a().i() != null) {
                com.baidu.adp.framework.c.c.a().i().a("dispatchMessage", socketResponsedMessage.getErrorString(), socketResponsedMessage.getError(), socketResponsedMessage);
            }
            if (this.c != null) {
                this.a.d(this.c);
            }
            this.a.a.dispatchResponsedMessage(socketResponsedMessage);
        }
    }
}
