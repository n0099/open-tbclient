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
    private final ScheduledExecutorService brh;
    private final SparseArray<LinkedList<com.baidu.tbadk.BdToken.b>> bri;
    private final SparseArray<ConcurrentLinkedQueue<h>> brj;
    private final LinkedList<com.baidu.tbadk.BdToken.b> brk;
    private a brl;
    private Boolean brm;
    private AtomicBoolean brn;
    private o bro;
    private CustomMessageListener brp;
    private com.baidu.adp.framework.listener.a brq;
    private CustomMessageListener brr;

    public static final c TZ() {
        return e.bru;
    }

    /* loaded from: classes.dex */
    private static class e {
        private static final c bru = new c();
    }

    private c() {
        this.brh = Executors.newSingleThreadScheduledExecutor();
        this.bri = new SparseArray<>();
        this.brj = new SparseArray<>();
        this.brk = new LinkedList<>();
        this.brl = new a();
        this.brm = false;
        this.brn = new AtomicBoolean(false);
        this.brp = new CustomMessageListener(2921391) { // from class: com.baidu.tbadk.BdToken.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.brm = true;
                if (!c.this.brk.isEmpty()) {
                    Iterator it = c.this.brk.iterator();
                    while (it.hasNext()) {
                        c.this.b((com.baidu.tbadk.BdToken.b) it.next());
                    }
                    c.this.brk.clear();
                }
            }
        };
        this.brq = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMPLETE_TASK, 309627) { // from class: com.baidu.tbadk.BdToken.c.2
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
                    if (c.this.bro == null) {
                        c.this.bro = new o();
                    }
                    c.this.bro.a(data);
                    c.this.bro.show();
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
                                        bVar.fu(com.baidu.adp.lib.g.b.l(str, 0));
                                        if (bVar.getActivityId() != 0 && bVar.TM() != 0) {
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
        this.brr = new CustomMessageListener(2921379) { // from class: com.baidu.tbadk.BdToken.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    HashMap hashMap = new HashMap();
                    for (h hVar : (List) customResponsedMessage.getData()) {
                        if (hVar.Uq().getActivityId() != 0 && hVar.Uq().TM() != 0) {
                            HashSet hashSet = (HashSet) hashMap.get(Integer.valueOf(hVar.Uq().TM()));
                            if (hashSet == null) {
                                hashSet = new HashSet();
                                hashMap.put(Integer.valueOf(hVar.Uq().getActivityId()), hashSet);
                            }
                            hashSet.add(Integer.valueOf(hVar.Uq().TM()));
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
        Ub();
        Uc();
        jL();
        new d().execute(new Void[0]);
    }

    public void b(com.baidu.tbadk.BdToken.b bVar) {
        if (!this.brm.booleanValue()) {
            this.brk.add(bVar);
        } else if (!e(bVar)) {
            d(bVar);
            new b().execute(bVar);
        }
    }

    public void Ua() {
        this.brn.compareAndSet(true, false);
        this.brl.fA(0);
        this.brl.setTid(0L);
        this.brl.setFid(0L);
        if (this.bro != null) {
            this.bro.clearData();
        }
    }

    public void f(int i, long j) {
        LinkedList<com.baidu.tbadk.BdToken.b> linkedList;
        ConcurrentLinkedQueue<h> concurrentLinkedQueue;
        boolean z;
        if (i != 0 && j != 0 && this.brm.booleanValue() && (linkedList = this.bri.get(i)) != null && !linkedList.isEmpty()) {
            ConcurrentLinkedQueue<h> concurrentLinkedQueue2 = this.brj.get(i);
            if (concurrentLinkedQueue2 == null || concurrentLinkedQueue2.isEmpty()) {
                ConcurrentLinkedQueue<h> concurrentLinkedQueue3 = new ConcurrentLinkedQueue<>();
                this.brj.put(i, concurrentLinkedQueue3);
                concurrentLinkedQueue = concurrentLinkedQueue3;
            } else {
                concurrentLinkedQueue = concurrentLinkedQueue2;
            }
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next.getTaskType() == com.baidu.tbadk.BdToken.b.bqz) {
                    Iterator<h> it2 = concurrentLinkedQueue.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z = z2;
                            break;
                        }
                        h next2 = it2.next();
                        if ((next2 instanceof k) && next2.Uq().getActivityId() == next.getActivityId() && next2.Uq().TM() == next.TM() && ((k) next2).getTid() == j) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        k kVar = new k(next, j);
                        kVar.ac(0L);
                        kVar.cX(false);
                        for (int i2 : next.TQ()) {
                            ConcurrentLinkedQueue<h> concurrentLinkedQueue4 = this.brj.get(i2);
                            if (concurrentLinkedQueue4 == null) {
                                concurrentLinkedQueue4 = new ConcurrentLinkedQueue<>();
                            }
                            concurrentLinkedQueue4.add(kVar);
                        }
                    }
                    z2 = z;
                }
            }
            this.brl.fA(i);
            this.brl.setTid(j);
            this.brn.compareAndSet(false, true);
            synchronized (this.brn) {
                this.brn.notify();
            }
        }
    }

    public void g(int i, long j) {
        LinkedList<com.baidu.tbadk.BdToken.b> linkedList;
        ConcurrentLinkedQueue<h> concurrentLinkedQueue;
        boolean z;
        if (i != 0 && j != 0 && this.brm.booleanValue() && (linkedList = this.bri.get(i)) != null && !linkedList.isEmpty()) {
            ConcurrentLinkedQueue<h> concurrentLinkedQueue2 = this.brj.get(i);
            if (concurrentLinkedQueue2 == null || concurrentLinkedQueue2.isEmpty()) {
                ConcurrentLinkedQueue<h> concurrentLinkedQueue3 = new ConcurrentLinkedQueue<>();
                this.brj.put(i, concurrentLinkedQueue3);
                concurrentLinkedQueue = concurrentLinkedQueue3;
            } else {
                concurrentLinkedQueue = concurrentLinkedQueue2;
            }
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next.getTaskType() == com.baidu.tbadk.BdToken.b.bqA) {
                    Iterator<h> it2 = concurrentLinkedQueue.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z = z2;
                            break;
                        }
                        h next2 = it2.next();
                        if ((next2 instanceof j) && next2.Uq().getActivityId() == next.getActivityId() && next2.Uq().TM() == next.TM() && ((j) next2).getFid() == j) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        j jVar = new j(next, j);
                        jVar.ac(0L);
                        jVar.cX(false);
                        for (int i2 : next.TQ()) {
                            ConcurrentLinkedQueue<h> concurrentLinkedQueue4 = this.brj.get(i2);
                            if (concurrentLinkedQueue4 == null) {
                                concurrentLinkedQueue4 = new ConcurrentLinkedQueue<>();
                            }
                            concurrentLinkedQueue4.add(jVar);
                        }
                    }
                    z2 = z;
                }
            }
            this.brl.fA(i);
            this.brl.setFid(j);
            this.brn.compareAndSet(false, true);
            synchronized (this.brn) {
                this.brn.notify();
            }
        }
    }

    public void fz(int i) {
        LinkedList<com.baidu.tbadk.BdToken.b> linkedList;
        ConcurrentLinkedQueue<h> concurrentLinkedQueue;
        boolean z;
        if (i != 0 && this.brm.booleanValue() && (linkedList = this.bri.get(i)) != null && !linkedList.isEmpty()) {
            ConcurrentLinkedQueue<h> concurrentLinkedQueue2 = this.brj.get(i);
            if (concurrentLinkedQueue2 == null || concurrentLinkedQueue2.isEmpty()) {
                ConcurrentLinkedQueue<h> concurrentLinkedQueue3 = new ConcurrentLinkedQueue<>();
                this.brj.put(i, concurrentLinkedQueue3);
                concurrentLinkedQueue = concurrentLinkedQueue3;
            } else {
                concurrentLinkedQueue = concurrentLinkedQueue2;
            }
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next.getTaskType() == com.baidu.tbadk.BdToken.b.bqC) {
                    Iterator<h> it2 = concurrentLinkedQueue.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z = z2;
                            break;
                        }
                        h next2 = it2.next();
                        if ((next2 instanceof i) && next2.Uq().getActivityId() == next.getActivityId() && next2.Uq().TM() == next.TM()) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        i iVar = new i(next);
                        iVar.ac(0L);
                        iVar.cX(false);
                        for (int i2 : next.TQ()) {
                            ConcurrentLinkedQueue<h> concurrentLinkedQueue4 = this.brj.get(i2);
                            if (concurrentLinkedQueue4 == null) {
                                concurrentLinkedQueue4 = new ConcurrentLinkedQueue<>();
                            }
                            concurrentLinkedQueue4.add(iVar);
                        }
                    }
                    z2 = z;
                }
            }
            this.brl.fA(i);
            this.brn.compareAndSet(false, true);
            synchronized (this.brn) {
                this.brn.notify();
            }
        }
    }

    private void Ub() {
        String br = com.baidu.tieba.tbadkCore.a.a.br(TbConfig.COMPLETE_TASK_URL, 309627);
        MessageManager.getInstance().registerTask(new HttpMessageTask(CmdConfigHttp.CMD_COMPLETE_TASK, br));
        com.baidu.tieba.tbadkCore.a.a.a(309627, CompleteTaskSocketResMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_COMPLETE_TASK, br);
        tbHttpMessageTask.setResponsedClass(CompleteTaskHTTPResMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void Uc() {
        this.brp.setPriority(Integer.MIN_VALUE);
        MessageManager.getInstance().registerListener(this.brp);
        MessageManager.getInstance().registerListener(this.brq);
        MessageManager.getInstance().registerListener(this.brr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.BdToken.b bVar) {
        f(bVar);
        new C0219c().execute(bVar);
    }

    private void jL() {
        this.brh.scheduleWithFixedDelay(this.brl, 0L, 1L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.BdToken.b bVar) {
        int[] TQ;
        for (int i : bVar.TQ()) {
            LinkedList<com.baidu.tbadk.BdToken.b> linkedList = this.bri.get(i);
            if (linkedList == null) {
                LinkedList<com.baidu.tbadk.BdToken.b> linkedList2 = new LinkedList<>();
                linkedList2.add(bVar);
                this.bri.put(i, linkedList2);
            } else {
                linkedList.add(bVar);
            }
        }
    }

    private boolean e(com.baidu.tbadk.BdToken.b bVar) {
        int[] TQ = bVar.TQ();
        if (TQ == null) {
            return true;
        }
        for (int i : TQ) {
            LinkedList<com.baidu.tbadk.BdToken.b> linkedList = this.bri.get(i);
            if (linkedList == null) {
                return false;
            }
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next != null && next.getActivityId() == bVar.getActivityId() && next.TM() == bVar.TM()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void f(com.baidu.tbadk.BdToken.b bVar) {
        for (int i = 0; i < this.brj.size(); i++) {
            ConcurrentLinkedQueue<h> valueAt = this.brj.valueAt(i);
            if (valueAt != null && !valueAt.isEmpty()) {
                Iterator<h> it = valueAt.iterator();
                while (it.hasNext()) {
                    h next = it.next();
                    if (next.Uq().getActivityId() == bVar.getActivityId() && next.Uq().TM() == bVar.TM()) {
                        it.remove();
                    }
                }
            }
        }
        for (int i2 = 0; i2 < this.bri.size(); i2++) {
            LinkedList<com.baidu.tbadk.BdToken.b> valueAt2 = this.bri.valueAt(i2);
            if (valueAt2 != null && !valueAt2.isEmpty()) {
                Iterator<com.baidu.tbadk.BdToken.b> it2 = valueAt2.iterator();
                while (it2.hasNext()) {
                    com.baidu.tbadk.BdToken.b next2 = it2.next();
                    if (next2.getActivityId() == bVar.getActivityId() && next2.TM() == bVar.TM()) {
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
            linkedList.addAll(com.baidu.tbadk.BdToken.a.TF().TG());
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next != null && System.currentTimeMillis() / 1000 > next.TV()) {
                    com.baidu.tbadk.BdToken.a.TF().Q(next.getActivityId(), next.TM());
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
                        if (next.TQ() != null) {
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
            com.baidu.tbadk.BdToken.a.TF().a(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.TF().Q(bVarArr[0].getActivityId(), bVarArr[0].TM());
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private volatile long bqZ;
        private volatile int brt;
        private volatile long mFid;

        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            if (this.brt == 0 || !c.this.brn.get()) {
                synchronized (c.this.brn) {
                    try {
                        c.this.brn.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) c.this.brj.get(this.brt);
            if (concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
                c.this.brn.compareAndSet(true, false);
                return;
            }
            LinkedList linkedList = new LinkedList();
            Iterator it = concurrentLinkedQueue.iterator();
            boolean z2 = true;
            while (it.hasNext()) {
                h hVar = (h) it.next();
                if (hVar instanceof k) {
                    if (this.bqZ != 0 && ((k) hVar).getTid() == this.bqZ && !hVar.isCompleted()) {
                        hVar.fB(1);
                        if (hVar.Ur() >= hVar.Uq().TR()) {
                            hVar.cX(true);
                            if (hVar.Uq().TJ() >= hVar.Uq().getThreadNum()) {
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
                        hVar.fB(1);
                        if (hVar.Ur() >= hVar.Uq().TR()) {
                            hVar.cX(true);
                            if (hVar.Uq().TI() >= hVar.Uq().TS()) {
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
                    hVar.fB(1);
                    if (hVar.Ur() >= hVar.Uq().TR()) {
                        hVar.cX(true);
                        linkedList.add(hVar);
                    }
                    z = false;
                    z2 = z;
                }
            }
            if (z2) {
                c.this.brn.compareAndSet(true, false);
            }
            if (linkedList != null && !linkedList.isEmpty()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921379, linkedList));
            }
        }

        public synchronized void fA(int i) {
            this.brt = i;
        }

        public synchronized void setTid(long j) {
            this.bqZ = j;
        }

        public synchronized void setFid(long j) {
            this.mFid = j;
        }
    }
}
