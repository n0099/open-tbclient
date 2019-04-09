package com.baidu.tbadk.BdToken;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskHTTPResMsg;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskSocketResMsg;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private final ScheduledExecutorService brl;
    private final SparseArray<LinkedList<com.baidu.tbadk.BdToken.b>> brm;
    private final SparseArray<ConcurrentLinkedQueue<h>> brn;
    private final LinkedList<com.baidu.tbadk.BdToken.b> bro;
    private a brp;
    private Boolean brq;
    private AtomicBoolean brr;
    private o brs;
    private CustomMessageListener brt;
    private com.baidu.adp.framework.listener.a bru;
    private CustomMessageListener brv;

    public static final c TX() {
        return e.bry;
    }

    /* loaded from: classes.dex */
    private static class e {
        private static final c bry = new c();
    }

    private c() {
        this.brl = Executors.newSingleThreadScheduledExecutor();
        this.brm = new SparseArray<>();
        this.brn = new SparseArray<>();
        this.bro = new LinkedList<>();
        this.brp = new a();
        this.brq = false;
        this.brr = new AtomicBoolean(false);
        this.brt = new CustomMessageListener(2921391) { // from class: com.baidu.tbadk.BdToken.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.brq = true;
                if (!c.this.bro.isEmpty()) {
                    Iterator it = c.this.bro.iterator();
                    while (it.hasNext()) {
                        c.this.b((com.baidu.tbadk.BdToken.b) it.next());
                    }
                    c.this.bro.clear();
                }
            }
        };
        this.bru = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMPLETE_TASK, 309627) { // from class: com.baidu.tbadk.BdToken.c.2
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                com.baidu.tbadk.BdToken.completeTask.a data;
                if (!responsedMessage.hasError()) {
                    if (responsedMessage instanceof CompleteTaskHTTPResMsg) {
                        data = ((CompleteTaskHTTPResMsg) responsedMessage).getData();
                    } else if (responsedMessage instanceof CompleteTaskSocketResMsg) {
                        data = ((CompleteTaskSocketResMsg) responsedMessage).getData();
                    } else {
                        return;
                    }
                    if (c.this.brs == null) {
                        c.this.brs = new o();
                    }
                    c.this.brs.a(data);
                    c.this.brs.show();
                    CompleteTaskReqMsg completeTaskReqMsg = (CompleteTaskReqMsg) responsedMessage.getOrginalMessage().getExtra();
                    if (completeTaskReqMsg.getTaskType() == 1) {
                        JSONObject jSONObject = null;
                        try {
                            jSONObject = new JSONObject(completeTaskReqMsg.completeId);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        if (jSONObject != null) {
                            LinkedList<com.baidu.tbadk.BdToken.b> linkedList = new LinkedList();
                            Iterator<String> keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                try {
                                    for (String str : jSONObject.getString(next).split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                                        com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b();
                                        bVar.setActivityId(com.baidu.adp.lib.g.b.l(next, 0));
                                        bVar.ft(com.baidu.adp.lib.g.b.l(str, 0));
                                        if (bVar.getActivityId() != 0 && bVar.TK() != 0) {
                                            linkedList.add(bVar);
                                        }
                                    }
                                } catch (JSONException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            for (com.baidu.tbadk.BdToken.b bVar2 : linkedList) {
                                c.this.c(bVar2);
                            }
                        }
                    }
                }
            }
        };
        this.brv = new CustomMessageListener(2921379) { // from class: com.baidu.tbadk.BdToken.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    HashMap hashMap = new HashMap();
                    for (h hVar : (List) customResponsedMessage.getData()) {
                        if (hVar.Uo().getActivityId() != 0 && hVar.Uo().TK() != 0) {
                            HashSet hashSet = (HashSet) hashMap.get(Integer.valueOf(hVar.Uo().TK()));
                            if (hashSet == null) {
                                hashSet = new HashSet();
                                hashMap.put(Integer.valueOf(hVar.Uo().getActivityId()), hashSet);
                            }
                            hashSet.add(Integer.valueOf(hVar.Uo().TK()));
                        }
                    }
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry entry : hashMap.entrySet()) {
                        StringBuilder sb = new StringBuilder();
                        Iterator it = ((HashSet) entry.getValue()).iterator();
                        while (it.hasNext()) {
                            sb.append(it.next() + Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        try {
                            jSONObject.put(String.valueOf(entry.getKey()), sb);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(1);
                    completeTaskReqMsg.completeId = jSONObject.toString();
                    MessageManager.getInstance().sendMessage(completeTaskReqMsg);
                }
            }
        };
        TZ();
        Ua();
        jL();
        new d().execute(new Void[0]);
    }

    public void b(com.baidu.tbadk.BdToken.b bVar) {
        if (!this.brq.booleanValue()) {
            this.bro.add(bVar);
        } else if (!e(bVar)) {
            d(bVar);
            new b().execute(bVar);
        }
    }

    public void TY() {
        this.brr.compareAndSet(true, false);
        this.brp.fz(0);
        this.brp.setTid(0L);
        this.brp.setFid(0L);
        if (this.brs != null) {
            this.brs.clearData();
        }
    }

    public void f(int i, long j) {
        LinkedList<com.baidu.tbadk.BdToken.b> linkedList;
        ConcurrentLinkedQueue<h> concurrentLinkedQueue;
        boolean z;
        if (i != 0 && j != 0 && this.brq.booleanValue() && (linkedList = this.brm.get(i)) != null && !linkedList.isEmpty()) {
            ConcurrentLinkedQueue<h> concurrentLinkedQueue2 = this.brn.get(i);
            if (concurrentLinkedQueue2 == null || concurrentLinkedQueue2.isEmpty()) {
                ConcurrentLinkedQueue<h> concurrentLinkedQueue3 = new ConcurrentLinkedQueue<>();
                this.brn.put(i, concurrentLinkedQueue3);
                concurrentLinkedQueue = concurrentLinkedQueue3;
            } else {
                concurrentLinkedQueue = concurrentLinkedQueue2;
            }
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next.getTaskType() == com.baidu.tbadk.BdToken.b.bqD) {
                    Iterator<h> it2 = concurrentLinkedQueue.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z = z2;
                            break;
                        }
                        h next2 = it2.next();
                        if ((next2 instanceof k) && next2.Uo().getActivityId() == next.getActivityId() && next2.Uo().TK() == next.TK() && ((k) next2).getTid() == j) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        k kVar = new k(next, j);
                        kVar.ac(0L);
                        kVar.cX(false);
                        for (int i2 : next.TO()) {
                            ConcurrentLinkedQueue<h> concurrentLinkedQueue4 = this.brn.get(i2);
                            if (concurrentLinkedQueue4 == null) {
                                concurrentLinkedQueue4 = new ConcurrentLinkedQueue<>();
                            }
                            concurrentLinkedQueue4.add(kVar);
                        }
                    }
                    z2 = z;
                }
            }
            this.brp.fz(i);
            this.brp.setTid(j);
            this.brr.compareAndSet(false, true);
            synchronized (this.brr) {
                this.brr.notify();
            }
        }
    }

    public void g(int i, long j) {
        LinkedList<com.baidu.tbadk.BdToken.b> linkedList;
        ConcurrentLinkedQueue<h> concurrentLinkedQueue;
        boolean z;
        if (i != 0 && j != 0 && this.brq.booleanValue() && (linkedList = this.brm.get(i)) != null && !linkedList.isEmpty()) {
            ConcurrentLinkedQueue<h> concurrentLinkedQueue2 = this.brn.get(i);
            if (concurrentLinkedQueue2 == null || concurrentLinkedQueue2.isEmpty()) {
                ConcurrentLinkedQueue<h> concurrentLinkedQueue3 = new ConcurrentLinkedQueue<>();
                this.brn.put(i, concurrentLinkedQueue3);
                concurrentLinkedQueue = concurrentLinkedQueue3;
            } else {
                concurrentLinkedQueue = concurrentLinkedQueue2;
            }
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next.getTaskType() == com.baidu.tbadk.BdToken.b.bqE) {
                    Iterator<h> it2 = concurrentLinkedQueue.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z = z2;
                            break;
                        }
                        h next2 = it2.next();
                        if ((next2 instanceof j) && next2.Uo().getActivityId() == next.getActivityId() && next2.Uo().TK() == next.TK() && ((j) next2).getFid() == j) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        j jVar = new j(next, j);
                        jVar.ac(0L);
                        jVar.cX(false);
                        for (int i2 : next.TO()) {
                            ConcurrentLinkedQueue<h> concurrentLinkedQueue4 = this.brn.get(i2);
                            if (concurrentLinkedQueue4 == null) {
                                concurrentLinkedQueue4 = new ConcurrentLinkedQueue<>();
                            }
                            concurrentLinkedQueue4.add(jVar);
                        }
                    }
                    z2 = z;
                }
            }
            this.brp.fz(i);
            this.brp.setFid(j);
            this.brr.compareAndSet(false, true);
            synchronized (this.brr) {
                this.brr.notify();
            }
        }
    }

    public void fy(int i) {
        LinkedList<com.baidu.tbadk.BdToken.b> linkedList;
        ConcurrentLinkedQueue<h> concurrentLinkedQueue;
        boolean z;
        if (i != 0 && this.brq.booleanValue() && (linkedList = this.brm.get(i)) != null && !linkedList.isEmpty()) {
            ConcurrentLinkedQueue<h> concurrentLinkedQueue2 = this.brn.get(i);
            if (concurrentLinkedQueue2 == null || concurrentLinkedQueue2.isEmpty()) {
                ConcurrentLinkedQueue<h> concurrentLinkedQueue3 = new ConcurrentLinkedQueue<>();
                this.brn.put(i, concurrentLinkedQueue3);
                concurrentLinkedQueue = concurrentLinkedQueue3;
            } else {
                concurrentLinkedQueue = concurrentLinkedQueue2;
            }
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next.getTaskType() == com.baidu.tbadk.BdToken.b.bqG) {
                    Iterator<h> it2 = concurrentLinkedQueue.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z = z2;
                            break;
                        }
                        h next2 = it2.next();
                        if ((next2 instanceof i) && next2.Uo().getActivityId() == next.getActivityId() && next2.Uo().TK() == next.TK()) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        i iVar = new i(next);
                        iVar.ac(0L);
                        iVar.cX(false);
                        for (int i2 : next.TO()) {
                            ConcurrentLinkedQueue<h> concurrentLinkedQueue4 = this.brn.get(i2);
                            if (concurrentLinkedQueue4 == null) {
                                concurrentLinkedQueue4 = new ConcurrentLinkedQueue<>();
                            }
                            concurrentLinkedQueue4.add(iVar);
                        }
                    }
                    z2 = z;
                }
            }
            this.brp.fz(i);
            this.brr.compareAndSet(false, true);
            synchronized (this.brr) {
                this.brr.notify();
            }
        }
    }

    private void TZ() {
        String br = com.baidu.tieba.tbadkCore.a.a.br(TbConfig.COMPLETE_TASK_URL, 309627);
        MessageManager.getInstance().registerTask(new HttpMessageTask(CmdConfigHttp.CMD_COMPLETE_TASK, br));
        com.baidu.tieba.tbadkCore.a.a.a(309627, CompleteTaskSocketResMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_COMPLETE_TASK, br);
        tbHttpMessageTask.setResponsedClass(CompleteTaskHTTPResMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void Ua() {
        this.brt.setPriority(Integer.MIN_VALUE);
        MessageManager.getInstance().registerListener(this.brt);
        MessageManager.getInstance().registerListener(this.bru);
        MessageManager.getInstance().registerListener(this.brv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.BdToken.b bVar) {
        f(bVar);
        new C0219c().execute(bVar);
    }

    private void jL() {
        this.brl.scheduleWithFixedDelay(this.brp, 0L, 1L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.BdToken.b bVar) {
        int[] TO;
        for (int i : bVar.TO()) {
            LinkedList<com.baidu.tbadk.BdToken.b> linkedList = this.brm.get(i);
            if (linkedList == null) {
                LinkedList<com.baidu.tbadk.BdToken.b> linkedList2 = new LinkedList<>();
                linkedList2.add(bVar);
                this.brm.put(i, linkedList2);
            } else {
                linkedList.add(bVar);
            }
        }
    }

    private boolean e(com.baidu.tbadk.BdToken.b bVar) {
        int[] TO = bVar.TO();
        if (TO == null) {
            return true;
        }
        for (int i : TO) {
            LinkedList<com.baidu.tbadk.BdToken.b> linkedList = this.brm.get(i);
            if (linkedList == null) {
                return false;
            }
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next != null && next.getActivityId() == bVar.getActivityId() && next.TK() == bVar.TK()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void f(com.baidu.tbadk.BdToken.b bVar) {
        for (int i = 0; i < this.brn.size(); i++) {
            ConcurrentLinkedQueue<h> valueAt = this.brn.valueAt(i);
            if (valueAt != null && !valueAt.isEmpty()) {
                Iterator<h> it = valueAt.iterator();
                while (it.hasNext()) {
                    h next = it.next();
                    if (next.Uo().getActivityId() == bVar.getActivityId() && next.Uo().TK() == bVar.TK()) {
                        it.remove();
                    }
                }
            }
        }
        for (int i2 = 0; i2 < this.brm.size(); i2++) {
            LinkedList<com.baidu.tbadk.BdToken.b> valueAt2 = this.brm.valueAt(i2);
            if (valueAt2 != null && !valueAt2.isEmpty()) {
                Iterator<com.baidu.tbadk.BdToken.b> it2 = valueAt2.iterator();
                while (it2.hasNext()) {
                    com.baidu.tbadk.BdToken.b next2 = it2.next();
                    if (next2.getActivityId() == bVar.getActivityId() && next2.TK() == bVar.TK()) {
                        it2.remove();
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    private class d extends BdAsyncTask<Void, Integer, LinkedList<com.baidu.tbadk.BdToken.b>> {
        private d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public LinkedList<com.baidu.tbadk.BdToken.b> doInBackground(Void... voidArr) {
            LinkedList<com.baidu.tbadk.BdToken.b> linkedList = new LinkedList<>();
            linkedList.addAll(com.baidu.tbadk.BdToken.a.TD().TE());
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next != null && System.currentTimeMillis() / 1000 > next.TT()) {
                    com.baidu.tbadk.BdToken.a.TD().Q(next.getActivityId(), next.TK());
                    it.remove();
                }
            }
            return linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public void onPostExecute(LinkedList<com.baidu.tbadk.BdToken.b> linkedList) {
            super.onPostExecute(linkedList);
            if (linkedList != null) {
                if (!linkedList.isEmpty()) {
                    Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
                    while (it.hasNext()) {
                        com.baidu.tbadk.BdToken.b next = it.next();
                        if (next.TO() != null) {
                            c.this.d(next);
                        }
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921391));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<com.baidu.tbadk.BdToken.b, Integer, Void> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Void doInBackground(com.baidu.tbadk.BdToken.b... bVarArr) {
            com.baidu.tbadk.BdToken.a.TD().a(bVarArr[0]);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.BdToken.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0219c extends BdAsyncTask<com.baidu.tbadk.BdToken.b, Integer, Void> {
        private C0219c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Void doInBackground(com.baidu.tbadk.BdToken.b... bVarArr) {
            if (bVarArr[0] != null) {
                com.baidu.tbadk.BdToken.a.TD().Q(bVarArr[0].getActivityId(), bVarArr[0].TK());
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private volatile long brd;
        private volatile int brx;
        private volatile long mFid;

        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            if (this.brx == 0 || !c.this.brr.get()) {
                synchronized (c.this.brr) {
                    try {
                        c.this.brr.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) c.this.brn.get(this.brx);
            if (concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
                c.this.brr.compareAndSet(true, false);
                return;
            }
            LinkedList linkedList = new LinkedList();
            Iterator it = concurrentLinkedQueue.iterator();
            boolean z2 = true;
            while (it.hasNext()) {
                h hVar = (h) it.next();
                if (hVar instanceof k) {
                    if (this.brd != 0 && ((k) hVar).getTid() == this.brd && !hVar.isCompleted()) {
                        hVar.fA(1);
                        if (hVar.Up() >= hVar.Uo().TP()) {
                            hVar.cX(true);
                            if (hVar.Uo().TH() >= hVar.Uo().getThreadNum()) {
                                linkedList.add(hVar);
                            }
                            z = false;
                            z2 = z;
                        }
                        z = false;
                        z2 = z;
                    }
                } else if (hVar instanceof j) {
                    if (this.mFid != 0 && ((j) hVar).getFid() == this.mFid && !hVar.isCompleted()) {
                        hVar.fA(1);
                        if (hVar.Up() >= hVar.Uo().TP()) {
                            hVar.cX(true);
                            if (hVar.Uo().TG() >= hVar.Uo().TQ()) {
                                linkedList.add(hVar);
                            }
                            z = false;
                            z2 = z;
                        }
                        z = false;
                        z2 = z;
                    }
                } else if (!(hVar instanceof i)) {
                    z = z2;
                    z2 = z;
                } else if (!hVar.isCompleted()) {
                    hVar.fA(1);
                    if (hVar.Up() >= hVar.Uo().TP()) {
                        hVar.cX(true);
                        linkedList.add(hVar);
                    }
                    z = false;
                    z2 = z;
                }
            }
            if (z2) {
                c.this.brr.compareAndSet(true, false);
            }
            if (linkedList != null && !linkedList.isEmpty()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921379, linkedList));
            }
        }

        public synchronized void fz(int i) {
            this.brx = i;
        }

        public synchronized void setTid(long j) {
            this.brd = j;
        }

        public synchronized void setFid(long j) {
            this.mFid = j;
        }
    }
}
