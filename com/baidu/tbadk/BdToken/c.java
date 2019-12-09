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
    private final ScheduledExecutorService bQK;
    private final SparseArray<List<com.baidu.tbadk.BdToken.b>> bQL;
    private final LinkedList<com.baidu.tbadk.BdToken.b> bQM;
    private a bQN;
    private AtomicBoolean bQO;
    private boolean bQP;
    private boolean bQQ;
    private com.baidu.tbadk.BdToken.completeTask.d bQR;
    private com.baidu.tbadk.BdToken.activeConfig.b bQS;
    private int bQT;
    private long bQU;
    private long bQV;
    private int bQW;
    private long bQX;
    private CustomMessageListener bQY;
    private CustomMessageListener bQZ;
    private CustomMessageListener bRa;
    private com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a> bRb;
    private com.baidu.tbadk.h.b bRc;
    private BdUniqueId mBdUniqueId;

    public static final c adX() {
        return g.bRg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g {
        private static final c bRg = new c();
    }

    private c() {
        this.bQK = Executors.newSingleThreadScheduledExecutor();
        this.bQL = new SparseArray<>();
        this.bQM = new LinkedList<>();
        this.bQN = new a();
        this.bQO = new AtomicBoolean(false);
        this.bQP = false;
        this.bQQ = false;
        this.bQY = new CustomMessageListener(2921391) { // from class: com.baidu.tbadk.BdToken.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.bQP = true;
                if (!c.this.bQM.isEmpty()) {
                    Iterator it = c.this.bQM.iterator();
                    while (it.hasNext()) {
                        c.this.l((com.baidu.tbadk.BdToken.b) it.next());
                    }
                    c.this.bQM.clear();
                }
            }
        };
        this.bQZ = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.BdToken.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                    ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                    c.this.adY();
                }
            }
        };
        this.bRa = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tbadk.BdToken.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                    c.this.bQQ = true;
                    c.this.adY();
                }
            }
        };
        this.bRb = new com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a>() { // from class: com.baidu.tbadk.BdToken.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: a */
            public void onSuccess(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    com.baidu.tbadk.core.sharedPref.b.alP().putLong("pref_key_active_config_info", currentTimeMillis);
                    c.this.bQX = currentTimeMillis;
                    c.this.aj(aVar.aeL());
                }
            }

            @Override // com.baidu.tbadk.h.a
            public void onError(int i, String str) {
            }
        };
        this.bRc = new com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b>() { // from class: com.baidu.tbadk.BdToken.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.b
            /* renamed from: m */
            public void onProgressUpdate(com.baidu.tbadk.BdToken.b bVar) {
                if (bVar != null) {
                    com.baidu.tbadk.BdToken.b e2 = c.this.e(bVar);
                    if (e2 != null && e2.bQI) {
                        e2.reset();
                        c.this.j(e2);
                        return;
                    }
                    n.aew().o(e2);
                    if (e2 != null && e2.getTaskType() == 7) {
                        e2.adD();
                        int adV = e2.adV();
                        int tag = e2.getTag();
                        if (adV <= 1 || adV <= tag) {
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
        this.bQR = new com.baidu.tbadk.BdToken.completeTask.d(this.mBdUniqueId);
        this.bQR.a(this.bRc);
        this.bQS = new com.baidu.tbadk.BdToken.activeConfig.b(this.mBdUniqueId);
        this.bQS.a(this.bRb);
        this.bRa.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.bRa);
        this.bQZ.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.bQZ);
        this.bQY.setPriority(Integer.MIN_VALUE);
        this.bQY.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.bQY);
        com.baidu.tbadk.core.g.a.alM().init();
        p.aez().h(this.mBdUniqueId);
        startTimer();
        if (isMainProcess()) {
            new f().execute(new Void[0]);
        }
    }

    private boolean isMainProcess() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public void adY() {
        if (this.bQS != null && isMainProcess() && this.bQQ && !adZ()) {
            this.bQS.aeN();
        }
    }

    public boolean adZ() {
        return UtilHelper.isSameDay(aea(), System.currentTimeMillis());
    }

    private long aea() {
        if (this.bQX == 0) {
            this.bQX = com.baidu.tbadk.core.sharedPref.b.alP().getLong("pref_key_active_config_info", 0L);
        }
        return this.bQX;
    }

    public int aeb() {
        return this.bQW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.BdToken.b e(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.bQL.size()) {
                return null;
            }
            List<com.baidu.tbadk.BdToken.b> valueAt = this.bQL.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar2 : valueAt) {
                    if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.adH() == bVar.adH()) {
                        return bVar2;
                    }
                }
                continue;
            }
            i = i2 + 1;
        }
    }

    public void aec() {
        this.bQO.compareAndSet(true, false);
        this.bQN.hj(0);
        this.bQN.setTid(0L);
        this.bQN.setFid(0L);
        if (this.bQR != null) {
            this.bQR.aeQ();
        }
    }

    public void g(int i, long j) {
        if (isMainProcess()) {
            this.bQW = i;
            this.bQV = j;
            if (this.bQU > 0 && this.bQT > 0 && (j == 0 || j != this.bQU)) {
                h(this.bQT, this.bQU);
                this.bQU = 0L;
                this.bQT = 0;
            }
            aed();
        }
    }

    public void h(int i, long j) {
        k kVar;
        com.baidu.tbadk.BdToken.b aet;
        List<com.baidu.tbadk.BdToken.b> list = this.bQL.get(i);
        if (list != null && !list.isEmpty()) {
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 7) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.adw().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof k) && (aet = (kVar = (k) next).aet()) != null && kVar.getTid() == j && aet.getActivityId() == bVar.getActivityId() && aet.adH() == bVar.adH()) {
                                next.dL(true);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void i(int i, long j) {
        if (isMainProcess() && i != 0 && j != 0 && this.bQP) {
            this.bQT = i;
            List<com.baidu.tbadk.BdToken.b> list = this.bQL.get(i);
            if (list != null && !list.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 1) {
                        a(bVar, j);
                    } else if (bVar.getTaskType() != 7) {
                        continue;
                    } else if (bVar.aB(j)) {
                        break;
                    } else {
                        b(bVar, j);
                    }
                }
                this.bQN.hj(i);
                this.bQN.setTid(j);
                this.bQU = j;
                this.bQO.compareAndSet(false, true);
                synchronized (this.bQO) {
                    this.bQO.notify();
                }
            }
        }
    }

    private void a(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        m mVar;
        com.baidu.tbadk.BdToken.b aet;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.adw().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof m) && (aet = (mVar = (m) next).aet()) != null && mVar.getTid() == j && aet.getActivityId() == bVar.getActivityId() && aet.adH() == bVar.adH()) {
                z = true;
                break;
            }
        }
        if (!z) {
            m mVar2 = new m(bVar, j);
            mVar2.aG(0L);
            mVar2.dL(false);
            mVar2.hh(bVar.getTag());
            bVar.a(mVar2);
        }
    }

    private void b(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        k kVar;
        com.baidu.tbadk.BdToken.b aet;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.adw().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof k) && (aet = (kVar = (k) next).aet()) != null && kVar.getTid() == j && aet.getActivityId() == bVar.getActivityId() && aet.adH() == bVar.adH()) {
                z = true;
                break;
            }
        }
        if (!z) {
            k kVar2 = new k(bVar, j);
            kVar2.aG(0L);
            kVar2.dL(false);
            kVar2.hh(bVar.getTag());
            bVar.a(kVar2);
        }
    }

    public void j(int i, long j) {
        boolean z;
        if (isMainProcess() && i != 0 && j != 0 && this.bQP) {
            this.bQT = i;
            List<com.baidu.tbadk.BdToken.b> list = this.bQL.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 2) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.adw().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof j) && next.aet().getActivityId() == bVar.getActivityId() && next.aet().adH() == bVar.adH() && ((j) next).getFid() == j) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            j jVar = new j(bVar, j);
                            jVar.aG(0L);
                            jVar.dL(false);
                            jVar.hh(bVar.getTag());
                            bVar.a(jVar);
                        }
                        z2 = z;
                    }
                }
                this.bQN.hj(i);
                this.bQN.setFid(j);
                this.bQO.compareAndSet(false, true);
                synchronized (this.bQO) {
                    this.bQO.notify();
                }
            }
        }
    }

    public void hi(int i) {
        boolean z;
        if (isMainProcess() && i != 0 && this.bQP) {
            this.bQT = i;
            List<com.baidu.tbadk.BdToken.b> list = this.bQL.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 4) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.adw().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof i) && next.aet().getActivityId() == bVar.getActivityId() && next.aet().adH() == bVar.adH()) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            i iVar = new i(bVar);
                            iVar.aG(0L);
                            iVar.dL(false);
                            bVar.a(iVar);
                        }
                        z2 = z;
                    }
                }
                this.bQN.hj(i);
                this.bQO.compareAndSet(false, true);
                synchronized (this.bQO) {
                    this.bQO.notify();
                }
            }
        }
    }

    public void aed() {
        int i;
        List<com.baidu.tbadk.BdToken.b> list;
        boolean z;
        if (isMainProcess() && this.bQP && (list = this.bQL.get((i = com.baidu.tbadk.BdToken.b.bPZ))) != null && !list.isEmpty()) {
            boolean z2 = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 8) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.adw().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = z2;
                            break;
                        }
                        com.baidu.tbadk.BdToken.h next = it.next();
                        com.baidu.tbadk.BdToken.b aet = next.aet();
                        if (aet != null && (next instanceof l) && aet.getActivityId() == bVar.getActivityId() && aet.adH() == bVar.adH()) {
                            ((l) next).aev();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        l lVar = new l(bVar);
                        lVar.aG(0L);
                        lVar.dL(false);
                        bVar.a(lVar);
                    }
                    z2 = z;
                }
            }
            this.bQN.hj(i);
            this.bQO.compareAndSet(false, true);
            synchronized (this.bQO) {
                this.bQO.notify();
            }
        }
    }

    private void startTimer() {
        this.bQK.scheduleWithFixedDelay(this.bQN, 0L, 1L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tbadk.BdToken.b bVar) {
        int[] adM;
        for (int i : bVar.adM()) {
            List<com.baidu.tbadk.BdToken.b> list = this.bQL.get(i);
            if (list == null) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(bVar);
                this.bQL.put(i, linkedList);
            } else {
                list.add(bVar);
            }
        }
    }

    private boolean g(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return false;
        }
        int[] adM = bVar.adM();
        if (adM == null) {
            return true;
        }
        for (int i : adM) {
            List<com.baidu.tbadk.BdToken.b> list = this.bQL.get(i);
            if (list == null) {
                return false;
            }
            for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.adH() == bVar.adH()) {
                    if (bVar2.adE()) {
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
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.adw().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.aet() != null) {
                    com.baidu.tbadk.BdToken.b aet = next.aet();
                    if (aet.getActivityId() == bVar.getActivityId() && aet.adH() == bVar.adH()) {
                        if (taskType == 7 && (next instanceof k)) {
                            ((k) next).dL(true);
                        } else if (taskType == 1 && (next instanceof m)) {
                            ((m) next).dL(true);
                        }
                    }
                }
            }
            bVar.dK(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar != null) {
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.adw().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.aet() != null) {
                    com.baidu.tbadk.BdToken.b aet = next.aet();
                    if (aet.getActivityId() == bVar.getActivityId() && aet.adH() == bVar.adH()) {
                        it.remove();
                    }
                }
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bQL.size()) {
                    List<com.baidu.tbadk.BdToken.b> valueAt = this.bQL.valueAt(i2);
                    if (valueAt != null && !valueAt.isEmpty()) {
                        Iterator<com.baidu.tbadk.BdToken.b> it2 = valueAt.iterator();
                        while (it2.hasNext()) {
                            com.baidu.tbadk.BdToken.b next2 = it2.next();
                            if (next2 != null && next2.getActivityId() == bVar.getActivityId() && next2.adH() == bVar.adH()) {
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
                p.aez().q(bVar);
            } else if (!this.bQP) {
                this.bQM.add(bVar);
            } else if (!g(bVar)) {
                f(bVar);
                new b().execute(bVar);
            }
        }
    }

    public void aj(List<com.baidu.tbadk.BdToken.b> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            if (!this.bQP) {
                this.bQM.addAll(list);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar != null) {
                    if (bVar.getTaskType() == 9) {
                        p.aez().q(bVar);
                    } else if (!g(bVar)) {
                        f(bVar);
                        arrayList.add(bVar);
                    }
                }
            }
            new C0271c().execute(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.BdToken.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0271c extends BdAsyncTask<List<com.baidu.tbadk.BdToken.b>, Integer, Void> {
        private C0271c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(List<com.baidu.tbadk.BdToken.b>... listArr) {
            if (listArr != null && listArr.length > 0 && listArr[0] != null) {
                com.baidu.tbadk.BdToken.a.adt().aj(listArr[0]);
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
            linkedList.addAll(com.baidu.tbadk.BdToken.a.adt().adu());
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next != null && next.adE()) {
                    com.baidu.tbadk.BdToken.a.adt().c(next);
                    it.remove();
                } else if (next.getTaskType() == 7) {
                    next.ady();
                    com.baidu.tbadk.BdToken.a.adt().b(next);
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
                        if (next.adM() != null) {
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
                com.baidu.tbadk.BdToken.a.adt().a(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.adt().c(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.adt().c(bVar2);
            }
            if (bVar != null) {
                com.baidu.tbadk.BdToken.a.adt().a(bVar);
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
            com.baidu.tbadk.BdToken.a.adt().b(bVar);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(com.baidu.tbadk.BdToken.b bVar) {
            if (bVar != null && bVar.bQI) {
                bVar.bQI = false;
                c.this.i(c.this.bQT, c.this.bQU);
            }
        }
    }

    public void aee() {
        List<com.baidu.tbadk.BdToken.b> list = this.bQL.get(com.baidu.tbadk.BdToken.b.bPZ);
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            boolean z = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bVar.adw().iterator();
                boolean z2 = z;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof l) {
                        l lVar = (l) next;
                        if (!next.aK()) {
                            lVar.aev();
                            z2 = true;
                        }
                    }
                }
                z = z2;
            }
            if (z && !this.bQO.get()) {
                this.bQN.hj(com.baidu.tbadk.BdToken.b.bPZ);
                this.bQO.compareAndSet(false, true);
                synchronized (this.bQO) {
                    this.bQO.notify();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private volatile long bQt;
        private volatile int bRe;
        private volatile boolean bRf;
        private volatile long mFid;

        private a() {
            this.bRf = false;
        }

        public synchronized void hj(int i) {
            this.bRe = i;
        }

        public synchronized void setTid(long j) {
            this.bQt = j;
        }

        public synchronized void setFid(long j) {
            this.mFid = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.bRe == 0 || !c.this.bQO.get()) {
                synchronized (c.this.bQO) {
                    try {
                        c.this.bQO.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            aef();
        }

        private void aef() {
            this.bRf = true;
            List<com.baidu.tbadk.BdToken.b> list = (List) c.this.bQL.get(com.baidu.tbadk.BdToken.b.bPZ);
            List<com.baidu.tbadk.BdToken.b> list2 = (List) c.this.bQL.get(this.bRe);
            if (com.baidu.tbadk.core.util.v.isEmpty(list) && com.baidu.tbadk.core.util.v.isEmpty(list2)) {
                c.this.bQO.compareAndSet(true, false);
                return;
            }
            d.b bVar = new d.b();
            bVar.bSP = new LinkedList();
            bVar.bSQ = new LinkedList();
            bVar.bSR = new LinkedList();
            a(list, bVar);
            b(list2, bVar);
            if (this.bRf) {
                c.this.bQO.compareAndSet(true, false);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(bVar.bSR)) {
                com.baidu.tbadk.BdToken.a.adt().ak(bVar.bSR);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(bVar.bSP) || !com.baidu.tbadk.core.util.v.isEmpty(bVar.bSQ)) {
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
            ArrayList<com.baidu.tbadk.BdToken.h> adw;
            if (bVar != null && bVar2 != null && (adw = bVar.adw()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = adw.iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if ((next instanceof l) && !((l) next).isTimeout() && !next.aK()) {
                        this.bRf = false;
                        next.hk(1);
                        if (next.aeu() >= next.aet().adN()) {
                            next.dL(true);
                            bVar2.s(bVar);
                        }
                        bVar2.t(bVar);
                    }
                }
            }
        }

        private void b(com.baidu.tbadk.BdToken.b bVar, d.b bVar2) {
            ArrayList<com.baidu.tbadk.BdToken.h> adw;
            if (bVar != null && bVar2 != null && (adw = bVar.adw()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = adw.iterator();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof m) {
                        m mVar = (m) next;
                        if (this.bQt != 0 && mVar.getTid() == this.bQt && !next.aK()) {
                            this.bRf = false;
                            next.hk(1);
                            if (next.aeu() >= next.aet().adN()) {
                                next.dL(true);
                                if (next.aet().adC() >= next.aet().getThreadNum()) {
                                    bVar2.c(next);
                                }
                            }
                            bVar2.t(bVar);
                        }
                    } else if (next instanceof k) {
                        k kVar = (k) next;
                        if (!bVar.adW() && kVar.getTag() == bVar.getTag()) {
                            if (this.bQt != 0 && kVar.getTid() == this.bQt && !next.aK()) {
                                this.bRf = false;
                                next.hk(1);
                            }
                            i = (int) (i + next.aeu());
                            if (this.bQt != 0 && kVar.getTid() == this.bQt && !next.aK()) {
                                if (next.aeu() >= bVar.adN()) {
                                    next.dL(true);
                                    bVar.adC();
                                }
                                bVar2.t(bVar);
                            }
                            int adx = bVar.adx();
                            int threadNum = bVar.getThreadNum();
                            if (i >= bVar.adN() * bVar.getThreadNum() && adx >= threadNum) {
                                bVar2.s(bVar);
                                bVar.dK(true);
                            }
                        }
                    } else if (next instanceof j) {
                        if (this.mFid != 0 && ((j) next).getFid() == this.mFid && !next.aK()) {
                            this.bRf = false;
                            next.hk(1);
                            if (next.aeu() >= next.aet().adN()) {
                                next.dL(true);
                                if (next.aet().adB() >= next.aet().adO()) {
                                    bVar2.c(next);
                                }
                            }
                        }
                    } else if ((next instanceof i) && !next.aK()) {
                        this.bRf = false;
                        next.hk(1);
                        if (next.aeu() >= next.aet().adN()) {
                            next.dL(true);
                            bVar2.c(next);
                        }
                    }
                }
            }
        }
    }
}
