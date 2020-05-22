package com.baidu.tbadk.BdToken;

import android.util.Pair;
import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BdToken.completeTask.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class c {
    private final ScheduledExecutorService duB;
    private final SparseArray<List<com.baidu.tbadk.BdToken.b>> duC;
    private final LinkedList<com.baidu.tbadk.BdToken.b> duD;
    private a duE;
    private AtomicBoolean duF;
    private boolean duG;
    private boolean duH;
    private com.baidu.tbadk.BdToken.completeTask.d duI;
    private com.baidu.tbadk.BdToken.activeConfig.b duJ;
    private int duK;
    private long duL;
    private long duM;
    private int duN;
    private long duO;
    private CustomMessageListener duP;
    private com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a> duQ;
    private com.baidu.tbadk.h.b duR;
    private CustomMessageListener mBackgroundListener;
    private BdUniqueId mBdUniqueId;
    private CustomMessageListener mSyncFinishListener;

    public static final c aLi() {
        return g.duV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g {
        private static final c duV = new c();
    }

    private c() {
        this.duB = Executors.newSingleThreadScheduledExecutor();
        this.duC = new SparseArray<>();
        this.duD = new LinkedList<>();
        this.duE = new a();
        this.duF = new AtomicBoolean(false);
        this.duG = false;
        this.duH = false;
        this.duP = new CustomMessageListener(2921391) { // from class: com.baidu.tbadk.BdToken.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.duG = true;
                if (!c.this.duD.isEmpty()) {
                    Iterator it = c.this.duD.iterator();
                    while (it.hasNext()) {
                        c.this.l((com.baidu.tbadk.BdToken.b) it.next());
                    }
                    c.this.duD.clear();
                }
            }
        };
        this.mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.BdToken.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                    ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                    c.this.aLj();
                }
            }
        };
        this.mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tbadk.BdToken.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                    c.this.duH = true;
                    c.this.aLj();
                }
            }
        };
        this.duQ = new com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a>() { // from class: com.baidu.tbadk.BdToken.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: a */
            public void onSuccess(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    com.baidu.tbadk.core.sharedPref.b.aTX().putLong("pref_key_active_config_info", currentTimeMillis);
                    c.this.duO = currentTimeMillis;
                    c.this.as(aVar.aLT());
                }
            }

            @Override // com.baidu.tbadk.h.a
            public void onError(int i, String str) {
            }
        };
        this.duR = new com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b>() { // from class: com.baidu.tbadk.BdToken.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.b
            /* renamed from: m */
            public void onProgressUpdate(com.baidu.tbadk.BdToken.b bVar) {
                if (bVar != null) {
                    com.baidu.tbadk.BdToken.b e2 = c.this.e(bVar);
                    if (e2 != null && e2.duz) {
                        e2.reset();
                        c.this.j(e2);
                        return;
                    }
                    n.aLE().o(e2);
                    if (e2 != null && e2.getTaskType() == 7) {
                        e2.aKO();
                        int aLg = e2.aLg();
                        int tag = e2.getTag();
                        if (aLg <= 1 || aLg <= tag) {
                            c.this.k(e2);
                        } else {
                            c.this.j(e2);
                        }
                    } else if (e2 == null || e2.getTaskType() != 8) {
                        c.this.k(bVar);
                    } else {
                        c.this.k(e2);
                    }
                }
            }
        };
        this.mBdUniqueId = BdUniqueId.gen();
        this.duI = new com.baidu.tbadk.BdToken.completeTask.d(this.mBdUniqueId);
        this.duI.a(this.duR);
        this.duJ = new com.baidu.tbadk.BdToken.activeConfig.b(this.mBdUniqueId);
        this.duJ.a(this.duQ);
        this.mSyncFinishListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        this.mBackgroundListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mBackgroundListener);
        this.duP.setPriority(Integer.MIN_VALUE);
        this.duP.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.duP);
        com.baidu.tbadk.core.f.a.aTU().init();
        p.aLH().i(this.mBdUniqueId);
        startTimer();
        if (isMainProcess()) {
            new f().execute(new Void[0]);
        }
    }

    private boolean isMainProcess() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public void aLj() {
        if (this.duJ != null && isMainProcess() && this.duH && !aLk()) {
            this.duJ.aLV();
        }
    }

    public boolean aLk() {
        return UtilHelper.isSameDay(aLl(), System.currentTimeMillis());
    }

    private long aLl() {
        if (this.duO == 0) {
            this.duO = com.baidu.tbadk.core.sharedPref.b.aTX().getLong("pref_key_active_config_info", 0L);
        }
        return this.duO;
    }

    public int aLm() {
        return this.duN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.BdToken.b e(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.duC.size()) {
                return null;
            }
            List<com.baidu.tbadk.BdToken.b> valueAt = this.duC.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar2 : valueAt) {
                    if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.aKS() == bVar.aKS()) {
                        return bVar2;
                    }
                }
                continue;
            }
            i = i2 + 1;
        }
    }

    public void aLn() {
        this.duF.compareAndSet(true, false);
        this.duE.jS(0);
        this.duE.setTid(0L);
        this.duE.setFid(0L);
        if (this.duI != null) {
            this.duI.aLY();
        }
    }

    public void m(int i, long j) {
        if (isMainProcess()) {
            this.duN = i;
            this.duM = j;
            if (this.duL > 0 && this.duK > 0 && (j == 0 || j != this.duL)) {
                n(this.duK, this.duL);
                this.duL = 0L;
                this.duK = 0;
            }
            aLo();
        }
    }

    public void n(int i, long j) {
        k kVar;
        com.baidu.tbadk.BdToken.b aLB;
        List<com.baidu.tbadk.BdToken.b> list = this.duC.get(i);
        if (list != null && !list.isEmpty()) {
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 7) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aKH().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof k) && (aLB = (kVar = (k) next).aLB()) != null && kVar.getTid() == j && aLB.getActivityId() == bVar.getActivityId() && aLB.aKS() == bVar.aKS()) {
                                next.gz(true);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void o(int i, long j) {
        if (isMainProcess() && i != 0 && j != 0 && this.duG) {
            this.duK = i;
            List<com.baidu.tbadk.BdToken.b> list = this.duC.get(i);
            if (list != null && !list.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 1) {
                        a(bVar, j);
                    } else if (bVar.getTaskType() != 7) {
                        continue;
                    } else if (bVar.bS(j)) {
                        break;
                    } else {
                        b(bVar, j);
                    }
                }
                this.duE.jS(i);
                this.duE.setTid(j);
                this.duL = j;
                this.duF.compareAndSet(false, true);
                synchronized (this.duF) {
                    this.duF.notify();
                }
            }
        }
    }

    private void a(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        m mVar;
        com.baidu.tbadk.BdToken.b aLB;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aKH().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof m) && (aLB = (mVar = (m) next).aLB()) != null && mVar.getTid() == j && aLB.getActivityId() == bVar.getActivityId() && aLB.aKS() == bVar.aKS()) {
                z = true;
                break;
            }
        }
        if (!z) {
            m mVar2 = new m(bVar, j);
            mVar2.bX(0L);
            mVar2.gz(false);
            mVar2.jQ(bVar.getTag());
            bVar.a(mVar2);
        }
    }

    private void b(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        k kVar;
        com.baidu.tbadk.BdToken.b aLB;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aKH().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof k) && (aLB = (kVar = (k) next).aLB()) != null && kVar.getTid() == j && aLB.getActivityId() == bVar.getActivityId() && aLB.aKS() == bVar.aKS()) {
                z = true;
                break;
            }
        }
        if (!z) {
            k kVar2 = new k(bVar, j);
            kVar2.bX(0L);
            kVar2.gz(false);
            kVar2.jQ(bVar.getTag());
            bVar.a(kVar2);
        }
    }

    public void p(int i, long j) {
        boolean z;
        if (isMainProcess() && i != 0 && j != 0 && this.duG) {
            this.duK = i;
            List<com.baidu.tbadk.BdToken.b> list = this.duC.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 2) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aKH().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof j) && next.aLB().getActivityId() == bVar.getActivityId() && next.aLB().aKS() == bVar.aKS() && ((j) next).getFid() == j) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            j jVar = new j(bVar, j);
                            jVar.bX(0L);
                            jVar.gz(false);
                            jVar.jQ(bVar.getTag());
                            bVar.a(jVar);
                        }
                        z2 = z;
                    }
                }
                this.duE.jS(i);
                this.duE.setFid(j);
                this.duF.compareAndSet(false, true);
                synchronized (this.duF) {
                    this.duF.notify();
                }
            }
        }
    }

    public void jR(int i) {
        boolean z;
        if (isMainProcess() && i != 0 && this.duG) {
            this.duK = i;
            List<com.baidu.tbadk.BdToken.b> list = this.duC.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 4) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aKH().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof i) && next.aLB().getActivityId() == bVar.getActivityId() && next.aLB().aKS() == bVar.aKS()) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            i iVar = new i(bVar);
                            iVar.bX(0L);
                            iVar.gz(false);
                            bVar.a(iVar);
                        }
                        z2 = z;
                    }
                }
                this.duE.jS(i);
                this.duF.compareAndSet(false, true);
                synchronized (this.duF) {
                    this.duF.notify();
                }
            }
        }
    }

    public void aLo() {
        int i;
        List<com.baidu.tbadk.BdToken.b> list;
        boolean z;
        if (isMainProcess() && this.duG && (list = this.duC.get((i = com.baidu.tbadk.BdToken.b.dtR))) != null && !list.isEmpty()) {
            boolean z2 = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 8) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aKH().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = z2;
                            break;
                        }
                        com.baidu.tbadk.BdToken.h next = it.next();
                        com.baidu.tbadk.BdToken.b aLB = next.aLB();
                        if (aLB != null && (next instanceof l) && aLB.getActivityId() == bVar.getActivityId() && aLB.aKS() == bVar.aKS()) {
                            ((l) next).aLD();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        l lVar = new l(bVar);
                        lVar.bX(0L);
                        lVar.gz(false);
                        bVar.a(lVar);
                    }
                    z2 = z;
                }
            }
            this.duE.jS(i);
            this.duF.compareAndSet(false, true);
            synchronized (this.duF) {
                this.duF.notify();
            }
        }
    }

    private void startTimer() {
        this.duB.scheduleWithFixedDelay(this.duE, 0L, 1L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tbadk.BdToken.b bVar) {
        int[] aKX;
        for (int i : bVar.aKX()) {
            List<com.baidu.tbadk.BdToken.b> list = this.duC.get(i);
            if (list == null) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(bVar);
                this.duC.put(i, linkedList);
            } else {
                list.add(bVar);
            }
        }
    }

    private boolean g(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return false;
        }
        int[] aKX = bVar.aKX();
        if (aKX == null) {
            return true;
        }
        for (int i : aKX) {
            List<com.baidu.tbadk.BdToken.b> list = this.duC.get(i);
            if (list == null) {
                return false;
            }
            for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.aKS() == bVar.aKS()) {
                    if (bVar2.aKP()) {
                        a(bVar, bVar2);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void h(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar != null) {
            int taskType = bVar.getTaskType();
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aKH().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.aLB() != null) {
                    com.baidu.tbadk.BdToken.b aLB = next.aLB();
                    if (aLB.getActivityId() == bVar.getActivityId() && aLB.aKS() == bVar.aKS()) {
                        if (taskType == 7 && (next instanceof k)) {
                            ((k) next).gz(true);
                        } else if (taskType == 1 && (next instanceof m)) {
                            ((m) next).gz(true);
                        }
                    }
                }
            }
            bVar.gy(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar != null) {
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aKH().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.aLB() != null) {
                    com.baidu.tbadk.BdToken.b aLB = next.aLB();
                    if (aLB.getActivityId() == bVar.getActivityId() && aLB.aKS() == bVar.aKS()) {
                        it.remove();
                    }
                }
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.duC.size()) {
                    List<com.baidu.tbadk.BdToken.b> valueAt = this.duC.valueAt(i2);
                    if (valueAt != null && !valueAt.isEmpty()) {
                        Iterator<com.baidu.tbadk.BdToken.b> it2 = valueAt.iterator();
                        while (it2.hasNext()) {
                            com.baidu.tbadk.BdToken.b next2 = it2.next();
                            if (next2 != null && next2.getActivityId() == bVar.getActivityId() && next2.aKS() == bVar.aKS()) {
                                it2.remove();
                            }
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.baidu.tbadk.BdToken.b bVar) {
        h(bVar);
        new h().execute(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(com.baidu.tbadk.BdToken.b bVar) {
        i(bVar);
        new d().execute(bVar);
    }

    private void a(com.baidu.tbadk.BdToken.b bVar, com.baidu.tbadk.BdToken.b bVar2) {
        i(bVar2);
        new e().execute(new Pair(bVar, bVar2));
    }

    public void l(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar != null) {
            if (bVar.getTaskType() == 9) {
                p.aLH().q(bVar);
            } else if (!this.duG) {
                this.duD.add(bVar);
            } else if (!g(bVar)) {
                f(bVar);
                new b().execute(bVar);
            }
        }
    }

    public void as(List<com.baidu.tbadk.BdToken.b> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            if (!this.duG) {
                this.duD.addAll(list);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar != null) {
                    if (bVar.getTaskType() == 9) {
                        p.aLH().q(bVar);
                    } else if (!g(bVar)) {
                        f(bVar);
                        arrayList.add(bVar);
                    }
                }
            }
            new C0468c().execute(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.BdToken.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0468c extends BdAsyncTask<List<com.baidu.tbadk.BdToken.b>, Integer, Void> {
        private C0468c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(List<com.baidu.tbadk.BdToken.b>... listArr) {
            if (listArr != null && listArr.length > 0 && listArr[0] != null) {
                com.baidu.tbadk.BdToken.a.aKE().as(listArr[0]);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    private class f extends BdAsyncTask<Void, Integer, LinkedList<com.baidu.tbadk.BdToken.b>> {
        private f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public LinkedList<com.baidu.tbadk.BdToken.b> doInBackground(Void... voidArr) {
            LinkedList<com.baidu.tbadk.BdToken.b> linkedList = new LinkedList<>();
            linkedList.addAll(com.baidu.tbadk.BdToken.a.aKE().aKF());
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next != null && next.aKP()) {
                    com.baidu.tbadk.BdToken.a.aKE().c(next);
                    it.remove();
                } else if (next.getTaskType() == 7) {
                    next.aKJ();
                    com.baidu.tbadk.BdToken.a.aKE().b(next);
                }
            }
            return linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public void onPostExecute(LinkedList<com.baidu.tbadk.BdToken.b> linkedList) {
            super.onPostExecute(linkedList);
            if (linkedList != null) {
                if (!linkedList.isEmpty()) {
                    Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
                    while (it.hasNext()) {
                        com.baidu.tbadk.BdToken.b next = it.next();
                        if (next.aKX() != null) {
                            c.this.f(next);
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
            if (bVarArr != null && bVarArr.length > 0 && bVarArr[0] != null) {
                com.baidu.tbadk.BdToken.a.aKE().a(bVarArr[0]);
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends BdAsyncTask<com.baidu.tbadk.BdToken.b, Integer, Void> {
        private d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Void doInBackground(com.baidu.tbadk.BdToken.b... bVarArr) {
            if (bVarArr != null && bVarArr.length > 0 && bVarArr[0] != null) {
                com.baidu.tbadk.BdToken.a.aKE().c(bVarArr[0]);
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Pair<com.baidu.tbadk.BdToken.b, com.baidu.tbadk.BdToken.b>, Integer, Pair<com.baidu.tbadk.BdToken.b, com.baidu.tbadk.BdToken.b>> {
        private e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Pair<com.baidu.tbadk.BdToken.b, com.baidu.tbadk.BdToken.b> doInBackground(Pair<com.baidu.tbadk.BdToken.b, com.baidu.tbadk.BdToken.b>... pairArr) {
            if (pairArr == null || pairArr.length <= 0 || pairArr[0] == null) {
                return null;
            }
            Pair<com.baidu.tbadk.BdToken.b, com.baidu.tbadk.BdToken.b> pair = pairArr[0];
            com.baidu.tbadk.BdToken.b bVar = (com.baidu.tbadk.BdToken.b) pair.first;
            com.baidu.tbadk.BdToken.b bVar2 = (com.baidu.tbadk.BdToken.b) pair.second;
            if (bVar2 != null) {
                com.baidu.tbadk.BdToken.a.aKE().c(bVar2);
            }
            if (bVar != null) {
                com.baidu.tbadk.BdToken.a.aKE().a(bVar);
            }
            return pair;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Pair<com.baidu.tbadk.BdToken.b, com.baidu.tbadk.BdToken.b> pair) {
            if (pair != null) {
                com.baidu.tbadk.BdToken.b bVar = (com.baidu.tbadk.BdToken.b) pair.first;
                com.baidu.tbadk.BdToken.b bVar2 = (com.baidu.tbadk.BdToken.b) pair.second;
                if (bVar2 != null) {
                    c.this.i(bVar2);
                }
                if (bVar != null) {
                    c.this.f(bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class h extends BdAsyncTask<com.baidu.tbadk.BdToken.b, Integer, com.baidu.tbadk.BdToken.b> {
        private h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public com.baidu.tbadk.BdToken.b doInBackground(com.baidu.tbadk.BdToken.b... bVarArr) {
            if (bVarArr == null || bVarArr.length <= 0 || bVarArr[0] == null) {
                return null;
            }
            com.baidu.tbadk.BdToken.b bVar = bVarArr[0];
            com.baidu.tbadk.BdToken.a.aKE().b(bVar);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(com.baidu.tbadk.BdToken.b bVar) {
            if (bVar != null && bVar.duz) {
                bVar.duz = false;
                c.this.o(c.this.duK, c.this.duL);
            }
        }
    }

    public void aLp() {
        List<com.baidu.tbadk.BdToken.b> list = this.duC.get(com.baidu.tbadk.BdToken.b.dtR);
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            boolean z = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aKH().iterator();
                boolean z2 = z;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof l) {
                        l lVar = (l) next;
                        if (!next.gt()) {
                            lVar.aLD();
                            z2 = true;
                        }
                    }
                }
                z = z2;
            }
            if (z && !this.duF.get()) {
                this.duE.jS(com.baidu.tbadk.BdToken.b.dtR);
                this.duF.compareAndSet(false, true);
                synchronized (this.duF) {
                    this.duF.notify();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private volatile int duT;
        private volatile boolean duU;
        private volatile long dul;
        private volatile long mFid;

        private a() {
            this.duU = false;
        }

        public synchronized void jS(int i) {
            this.duT = i;
        }

        public synchronized void setTid(long j) {
            this.dul = j;
        }

        public synchronized void setFid(long j) {
            this.mFid = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.duT == 0 || !c.this.duF.get()) {
                synchronized (c.this.duF) {
                    try {
                        c.this.duF.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            aLq();
        }

        private void aLq() {
            this.duU = true;
            List<com.baidu.tbadk.BdToken.b> list = (List) c.this.duC.get(com.baidu.tbadk.BdToken.b.dtR);
            List<com.baidu.tbadk.BdToken.b> list2 = (List) c.this.duC.get(this.duT);
            if (com.baidu.tbadk.core.util.v.isEmpty(list) && com.baidu.tbadk.core.util.v.isEmpty(list2)) {
                c.this.duF.compareAndSet(true, false);
                return;
            }
            d.b bVar = new d.b();
            bVar.dwS = new LinkedList();
            bVar.dwT = new LinkedList();
            bVar.dwU = new LinkedList();
            a(list, bVar);
            b(list2, bVar);
            if (this.duU) {
                c.this.duF.compareAndSet(true, false);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(bVar.dwU)) {
                com.baidu.tbadk.BdToken.a.aKE().at(bVar.dwU);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(bVar.dwS) || !com.baidu.tbadk.core.util.v.isEmpty(bVar.dwT)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921379, bVar));
            }
        }

        private void a(List<com.baidu.tbadk.BdToken.b> list, d.b bVar) {
            if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
                for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                    a(bVar2, bVar);
                }
            }
        }

        private void b(List<com.baidu.tbadk.BdToken.b> list, d.b bVar) {
            if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
                for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                    b(bVar2, bVar);
                }
            }
        }

        private void a(com.baidu.tbadk.BdToken.b bVar, d.b bVar2) {
            ArrayList<com.baidu.tbadk.BdToken.h> aKH;
            if (bVar != null && bVar2 != null && (aKH = bVar.aKH()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = aKH.iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if ((next instanceof l) && !((l) next).isTimeout() && !next.gt()) {
                        this.duU = false;
                        next.jT(1);
                        if (next.aLC() >= next.aLB().aKY()) {
                            next.gz(true);
                            bVar2.s(bVar);
                        }
                        bVar2.t(bVar);
                    }
                }
            }
        }

        private void b(com.baidu.tbadk.BdToken.b bVar, d.b bVar2) {
            ArrayList<com.baidu.tbadk.BdToken.h> aKH;
            if (bVar != null && bVar2 != null && (aKH = bVar.aKH()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = aKH.iterator();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof m) {
                        m mVar = (m) next;
                        if (this.dul != 0 && mVar.getTid() == this.dul && !next.gt()) {
                            this.duU = false;
                            next.jT(1);
                            if (next.aLC() >= next.aLB().aKY()) {
                                next.gz(true);
                                if (next.aLB().aKN() >= next.aLB().getThreadNum()) {
                                    bVar2.c(next);
                                }
                            }
                            bVar2.t(bVar);
                        }
                    } else if (next instanceof k) {
                        k kVar = (k) next;
                        if (!bVar.aLh() && kVar.getTag() == bVar.getTag()) {
                            if (this.dul != 0 && kVar.getTid() == this.dul && !next.gt()) {
                                this.duU = false;
                                next.jT(1);
                            }
                            i = (int) (i + next.aLC());
                            if (this.dul != 0 && kVar.getTid() == this.dul && !next.gt()) {
                                if (next.aLC() >= bVar.aKY()) {
                                    next.gz(true);
                                    bVar.aKN();
                                }
                                bVar2.t(bVar);
                            }
                            int aKI = bVar.aKI();
                            int threadNum = bVar.getThreadNum();
                            if (i >= bVar.aKY() * bVar.getThreadNum() && aKI >= threadNum) {
                                bVar2.s(bVar);
                                bVar.gy(true);
                            }
                        }
                    } else if (next instanceof j) {
                        if (this.mFid != 0 && ((j) next).getFid() == this.mFid && !next.gt()) {
                            this.duU = false;
                            next.jT(1);
                            if (next.aLC() >= next.aLB().aKY()) {
                                next.gz(true);
                                if (next.aLB().aKM() >= next.aLB().aKZ()) {
                                    bVar2.c(next);
                                }
                            }
                        }
                    } else if ((next instanceof i) && !next.gt()) {
                        this.duU = false;
                        next.jT(1);
                        if (next.aLC() >= next.aLB().aKY()) {
                            next.gz(true);
                            bVar2.c(next);
                        }
                    }
                }
            }
        }
    }
}
