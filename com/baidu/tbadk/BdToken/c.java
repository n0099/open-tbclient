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
    private final ScheduledExecutorService akB;
    private final SparseArray<LinkedList<com.baidu.tbadk.BdToken.b>> akC;
    private final SparseArray<ConcurrentLinkedQueue<h>> akD;
    private final LinkedList<com.baidu.tbadk.BdToken.b> akE;
    private a akF;
    private Boolean akG;
    private AtomicBoolean akH;
    private o akI;
    private CustomMessageListener akJ;
    private com.baidu.adp.framework.listener.a akK;
    private CustomMessageListener akL;

    public static final c vy() {
        return e.akO;
    }

    /* loaded from: classes.dex */
    private static class e {
        private static final c akO = new c();
    }

    private c() {
        this.akB = Executors.newSingleThreadScheduledExecutor();
        this.akC = new SparseArray<>();
        this.akD = new SparseArray<>();
        this.akE = new LinkedList<>();
        this.akF = new a();
        this.akG = false;
        this.akH = new AtomicBoolean(false);
        this.akJ = new CustomMessageListener(2921383) { // from class: com.baidu.tbadk.BdToken.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.akG = true;
                if (!c.this.akE.isEmpty()) {
                    Iterator it = c.this.akE.iterator();
                    while (it.hasNext()) {
                        c.this.b((com.baidu.tbadk.BdToken.b) it.next());
                    }
                    c.this.akE.clear();
                }
            }
        };
        this.akK = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_COMPLETE_TASK, 309627) { // from class: com.baidu.tbadk.BdToken.c.2
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
                    if (c.this.akI == null) {
                        c.this.akI = new o();
                    }
                    c.this.akI.a(data);
                    c.this.akI.show();
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
                                    for (String str : jSONObject.getString(next).split(",")) {
                                        com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b();
                                        bVar.setActivityId(com.baidu.adp.lib.g.b.l(next, 0));
                                        bVar.bS(com.baidu.adp.lib.g.b.l(str, 0));
                                        if (bVar.getActivityId() != 0 && bVar.vl() != 0) {
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
        this.akL = new CustomMessageListener(2921379) { // from class: com.baidu.tbadk.BdToken.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    HashMap hashMap = new HashMap();
                    for (h hVar : (List) customResponsedMessage.getData()) {
                        if (hVar.vP().getActivityId() != 0 && hVar.vP().vl() != 0) {
                            HashSet hashSet = (HashSet) hashMap.get(Integer.valueOf(hVar.vP().vl()));
                            if (hashSet == null) {
                                hashSet = new HashSet();
                                hashMap.put(Integer.valueOf(hVar.vP().getActivityId()), hashSet);
                            }
                            hashSet.add(Integer.valueOf(hVar.vP().vl()));
                        }
                    }
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry entry : hashMap.entrySet()) {
                        StringBuilder sb = new StringBuilder();
                        Iterator it = ((HashSet) entry.getValue()).iterator();
                        while (it.hasNext()) {
                            sb.append(it.next() + ",");
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
        vA();
        vB();
        startTimer();
        new d().execute(new Void[0]);
    }

    public void b(com.baidu.tbadk.BdToken.b bVar) {
        if (!this.akG.booleanValue()) {
            this.akE.add(bVar);
        } else if (!e(bVar)) {
            d(bVar);
            new b().execute(bVar);
        }
    }

    public void vz() {
        this.akH.compareAndSet(true, false);
        this.akF.bY(0);
        this.akF.setTid(0L);
        this.akF.setFid(0L);
        if (this.akI != null) {
            this.akI.clearData();
        }
    }

    public void f(int i, long j) {
        LinkedList<com.baidu.tbadk.BdToken.b> linkedList;
        ConcurrentLinkedQueue<h> concurrentLinkedQueue;
        boolean z;
        if (i != 0 && j != 0 && this.akG.booleanValue() && (linkedList = this.akC.get(i)) != null && !linkedList.isEmpty()) {
            ConcurrentLinkedQueue<h> concurrentLinkedQueue2 = this.akD.get(i);
            if (concurrentLinkedQueue2 == null || concurrentLinkedQueue2.isEmpty()) {
                ConcurrentLinkedQueue<h> concurrentLinkedQueue3 = new ConcurrentLinkedQueue<>();
                this.akD.put(i, concurrentLinkedQueue3);
                concurrentLinkedQueue = concurrentLinkedQueue3;
            } else {
                concurrentLinkedQueue = concurrentLinkedQueue2;
            }
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next.getTaskType() == com.baidu.tbadk.BdToken.b.ajT) {
                    Iterator<h> it2 = concurrentLinkedQueue.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z = z2;
                            break;
                        }
                        h next2 = it2.next();
                        if ((next2 instanceof k) && next2.vP().getActivityId() == next.getActivityId() && next2.vP().vl() == next.vl() && ((k) next2).getTid() == j) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        k kVar = new k(next, j);
                        kVar.A(0L);
                        kVar.aO(false);
                        for (int i2 : next.vp()) {
                            ConcurrentLinkedQueue<h> concurrentLinkedQueue4 = this.akD.get(i2);
                            if (concurrentLinkedQueue4 == null) {
                                concurrentLinkedQueue4 = new ConcurrentLinkedQueue<>();
                            }
                            concurrentLinkedQueue4.add(kVar);
                        }
                    }
                    z2 = z;
                }
            }
            this.akF.bY(i);
            this.akF.setTid(j);
            this.akH.compareAndSet(false, true);
            synchronized (this.akH) {
                this.akH.notify();
            }
        }
    }

    public void g(int i, long j) {
        LinkedList<com.baidu.tbadk.BdToken.b> linkedList;
        ConcurrentLinkedQueue<h> concurrentLinkedQueue;
        boolean z;
        if (i != 0 && j != 0 && this.akG.booleanValue() && (linkedList = this.akC.get(i)) != null && !linkedList.isEmpty()) {
            ConcurrentLinkedQueue<h> concurrentLinkedQueue2 = this.akD.get(i);
            if (concurrentLinkedQueue2 == null || concurrentLinkedQueue2.isEmpty()) {
                ConcurrentLinkedQueue<h> concurrentLinkedQueue3 = new ConcurrentLinkedQueue<>();
                this.akD.put(i, concurrentLinkedQueue3);
                concurrentLinkedQueue = concurrentLinkedQueue3;
            } else {
                concurrentLinkedQueue = concurrentLinkedQueue2;
            }
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next.getTaskType() == com.baidu.tbadk.BdToken.b.ajU) {
                    Iterator<h> it2 = concurrentLinkedQueue.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z = z2;
                            break;
                        }
                        h next2 = it2.next();
                        if ((next2 instanceof j) && next2.vP().getActivityId() == next.getActivityId() && next2.vP().vl() == next.vl() && ((j) next2).getFid() == j) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        j jVar = new j(next, j);
                        jVar.A(0L);
                        jVar.aO(false);
                        for (int i2 : next.vp()) {
                            ConcurrentLinkedQueue<h> concurrentLinkedQueue4 = this.akD.get(i2);
                            if (concurrentLinkedQueue4 == null) {
                                concurrentLinkedQueue4 = new ConcurrentLinkedQueue<>();
                            }
                            concurrentLinkedQueue4.add(jVar);
                        }
                    }
                    z2 = z;
                }
            }
            this.akF.bY(i);
            this.akF.setFid(j);
            this.akH.compareAndSet(false, true);
            synchronized (this.akH) {
                this.akH.notify();
            }
        }
    }

    public void bX(int i) {
        LinkedList<com.baidu.tbadk.BdToken.b> linkedList;
        ConcurrentLinkedQueue<h> concurrentLinkedQueue;
        boolean z;
        if (i != 0 && this.akG.booleanValue() && (linkedList = this.akC.get(i)) != null && !linkedList.isEmpty()) {
            ConcurrentLinkedQueue<h> concurrentLinkedQueue2 = this.akD.get(i);
            if (concurrentLinkedQueue2 == null || concurrentLinkedQueue2.isEmpty()) {
                ConcurrentLinkedQueue<h> concurrentLinkedQueue3 = new ConcurrentLinkedQueue<>();
                this.akD.put(i, concurrentLinkedQueue3);
                concurrentLinkedQueue = concurrentLinkedQueue3;
            } else {
                concurrentLinkedQueue = concurrentLinkedQueue2;
            }
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next.getTaskType() == com.baidu.tbadk.BdToken.b.ajW) {
                    Iterator<h> it2 = concurrentLinkedQueue.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z = z2;
                            break;
                        }
                        h next2 = it2.next();
                        if ((next2 instanceof i) && next2.vP().getActivityId() == next.getActivityId() && next2.vP().vl() == next.vl()) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        i iVar = new i(next);
                        iVar.A(0L);
                        iVar.aO(false);
                        for (int i2 : next.vp()) {
                            ConcurrentLinkedQueue<h> concurrentLinkedQueue4 = this.akD.get(i2);
                            if (concurrentLinkedQueue4 == null) {
                                concurrentLinkedQueue4 = new ConcurrentLinkedQueue<>();
                            }
                            concurrentLinkedQueue4.add(iVar);
                        }
                    }
                    z2 = z;
                }
            }
            this.akF.bY(i);
            this.akH.compareAndSet(false, true);
            synchronized (this.akH) {
                this.akH.notify();
            }
        }
    }

    private void vA() {
        String aV = com.baidu.tieba.tbadkCore.a.a.aV(TbConfig.COMPLETE_TASK_URL, 309627);
        MessageManager.getInstance().registerTask(new HttpMessageTask(CmdConfigHttp.CMD_COMPLETE_TASK, aV));
        com.baidu.tieba.tbadkCore.a.a.a(309627, CompleteTaskSocketResMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_COMPLETE_TASK, aV);
        tbHttpMessageTask.setResponsedClass(CompleteTaskHTTPResMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void vB() {
        this.akJ.setPriority(Integer.MIN_VALUE);
        MessageManager.getInstance().registerListener(this.akJ);
        MessageManager.getInstance().registerListener(this.akK);
        MessageManager.getInstance().registerListener(this.akL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.BdToken.b bVar) {
        f(bVar);
        new C0152c().execute(bVar);
    }

    private void startTimer() {
        this.akB.scheduleWithFixedDelay(this.akF, 0L, 1L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.BdToken.b bVar) {
        int[] vp;
        for (int i : bVar.vp()) {
            LinkedList<com.baidu.tbadk.BdToken.b> linkedList = this.akC.get(i);
            if (linkedList == null) {
                LinkedList<com.baidu.tbadk.BdToken.b> linkedList2 = new LinkedList<>();
                linkedList2.add(bVar);
                this.akC.put(i, linkedList2);
            } else {
                linkedList.add(bVar);
            }
        }
    }

    private boolean e(com.baidu.tbadk.BdToken.b bVar) {
        int[] vp = bVar.vp();
        if (vp == null) {
            return true;
        }
        for (int i : vp) {
            LinkedList<com.baidu.tbadk.BdToken.b> linkedList = this.akC.get(i);
            if (linkedList == null) {
                return false;
            }
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next != null && next.getActivityId() == bVar.getActivityId() && next.vl() == bVar.vl()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void f(com.baidu.tbadk.BdToken.b bVar) {
        for (int i = 0; i < this.akD.size(); i++) {
            ConcurrentLinkedQueue<h> valueAt = this.akD.valueAt(i);
            if (valueAt != null && !valueAt.isEmpty()) {
                Iterator<h> it = valueAt.iterator();
                while (it.hasNext()) {
                    h next = it.next();
                    if (next.vP().getActivityId() == bVar.getActivityId() && next.vP().vl() == bVar.vl()) {
                        it.remove();
                    }
                }
            }
        }
        for (int i2 = 0; i2 < this.akC.size(); i2++) {
            LinkedList<com.baidu.tbadk.BdToken.b> valueAt2 = this.akC.valueAt(i2);
            if (valueAt2 != null && !valueAt2.isEmpty()) {
                Iterator<com.baidu.tbadk.BdToken.b> it2 = valueAt2.iterator();
                while (it2.hasNext()) {
                    com.baidu.tbadk.BdToken.b next2 = it2.next();
                    if (next2.getActivityId() == bVar.getActivityId() && next2.vl() == bVar.vl()) {
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
            linkedList.addAll(com.baidu.tbadk.BdToken.a.ve().vf());
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next != null && System.currentTimeMillis() / 1000 > next.vu()) {
                    com.baidu.tbadk.BdToken.a.ve().v(next.getActivityId(), next.vl());
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
                        if (next.vp() != null) {
                            c.this.d(next);
                        }
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921383));
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
            com.baidu.tbadk.BdToken.a.ve().a(bVarArr[0]);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.BdToken.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0152c extends BdAsyncTask<com.baidu.tbadk.BdToken.b, Integer, Void> {
        private C0152c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Void doInBackground(com.baidu.tbadk.BdToken.b... bVarArr) {
            if (bVarArr[0] != null) {
                com.baidu.tbadk.BdToken.a.ve().v(bVarArr[0].getActivityId(), bVarArr[0].vl());
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private volatile int akN;
        private volatile long akt;
        private volatile long mFid;

        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            if (this.akN == 0 || !c.this.akH.get()) {
                synchronized (c.this.akH) {
                    try {
                        c.this.akH.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) c.this.akD.get(this.akN);
            if (concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
                c.this.akH.compareAndSet(true, false);
                return;
            }
            LinkedList linkedList = new LinkedList();
            Iterator it = concurrentLinkedQueue.iterator();
            boolean z2 = true;
            while (it.hasNext()) {
                h hVar = (h) it.next();
                if (hVar instanceof k) {
                    if (this.akt != 0 && ((k) hVar).getTid() == this.akt && !hVar.isCompleted()) {
                        hVar.bZ(1);
                        if (hVar.vQ() >= hVar.vP().vq()) {
                            hVar.aO(true);
                            if (hVar.vP().vi() >= hVar.vP().getThreadNum()) {
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
                        hVar.bZ(1);
                        if (hVar.vQ() >= hVar.vP().vq()) {
                            hVar.aO(true);
                            if (hVar.vP().vh() >= hVar.vP().vr()) {
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
                    hVar.bZ(1);
                    if (hVar.vQ() >= hVar.vP().vq()) {
                        hVar.aO(true);
                        linkedList.add(hVar);
                    }
                    z = false;
                    z2 = z;
                }
            }
            if (z2) {
                c.this.akH.compareAndSet(true, false);
            }
            if (linkedList != null && !linkedList.isEmpty()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921379, linkedList));
            }
        }

        public synchronized void bY(int i) {
            this.akN = i;
        }

        public synchronized void setTid(long j) {
            this.akt = j;
        }

        public synchronized void setFid(long j) {
            this.mFid = j;
        }
    }
}
