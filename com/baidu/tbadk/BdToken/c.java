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
    private final ScheduledExecutorService bRB;
    private final SparseArray<List<com.baidu.tbadk.BdToken.b>> bRC;
    private final LinkedList<com.baidu.tbadk.BdToken.b> bRD;
    private a bRE;
    private AtomicBoolean bRF;
    private boolean bRG;
    private boolean bRH;
    private com.baidu.tbadk.BdToken.completeTask.d bRI;
    private com.baidu.tbadk.BdToken.activeConfig.b bRJ;
    private int bRK;
    private long bRL;
    private long bRM;
    private int bRN;
    private long bRO;
    private CustomMessageListener bRP;
    private CustomMessageListener bRQ;
    private CustomMessageListener bRR;
    private com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a> bRS;
    private com.baidu.tbadk.h.b bRT;
    private BdUniqueId mBdUniqueId;

    public static final c adZ() {
        return g.bRX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g {
        private static final c bRX = new c();
    }

    private c() {
        this.bRB = Executors.newSingleThreadScheduledExecutor();
        this.bRC = new SparseArray<>();
        this.bRD = new LinkedList<>();
        this.bRE = new a();
        this.bRF = new AtomicBoolean(false);
        this.bRG = false;
        this.bRH = false;
        this.bRP = new CustomMessageListener(2921391) { // from class: com.baidu.tbadk.BdToken.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.bRG = true;
                if (!c.this.bRD.isEmpty()) {
                    Iterator it = c.this.bRD.iterator();
                    while (it.hasNext()) {
                        c.this.l((com.baidu.tbadk.BdToken.b) it.next());
                    }
                    c.this.bRD.clear();
                }
            }
        };
        this.bRQ = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.BdToken.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                    ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                    c.this.aea();
                }
            }
        };
        this.bRR = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tbadk.BdToken.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                    c.this.bRH = true;
                    c.this.aea();
                }
            }
        };
        this.bRS = new com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a>() { // from class: com.baidu.tbadk.BdToken.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: a */
            public void onSuccess(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    com.baidu.tbadk.core.sharedPref.b.alR().putLong("pref_key_active_config_info", currentTimeMillis);
                    c.this.bRO = currentTimeMillis;
                    c.this.aj(aVar.aeN());
                }
            }

            @Override // com.baidu.tbadk.h.a
            public void onError(int i, String str) {
            }
        };
        this.bRT = new com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b>() { // from class: com.baidu.tbadk.BdToken.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.b
            /* renamed from: m */
            public void onProgressUpdate(com.baidu.tbadk.BdToken.b bVar) {
                if (bVar != null) {
                    com.baidu.tbadk.BdToken.b e2 = c.this.e(bVar);
                    if (e2 != null && e2.bRz) {
                        e2.reset();
                        c.this.j(e2);
                        return;
                    }
                    n.aey().o(e2);
                    if (e2 != null && e2.getTaskType() == 7) {
                        e2.adF();
                        int adX = e2.adX();
                        int tag = e2.getTag();
                        if (adX <= 1 || adX <= tag) {
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
        this.bRI = new com.baidu.tbadk.BdToken.completeTask.d(this.mBdUniqueId);
        this.bRI.a(this.bRT);
        this.bRJ = new com.baidu.tbadk.BdToken.activeConfig.b(this.mBdUniqueId);
        this.bRJ.a(this.bRS);
        this.bRR.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.bRR);
        this.bRQ.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.bRQ);
        this.bRP.setPriority(Integer.MIN_VALUE);
        this.bRP.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.bRP);
        com.baidu.tbadk.core.g.a.alO().init();
        p.aeB().h(this.mBdUniqueId);
        startTimer();
        if (isMainProcess()) {
            new f().execute(new Void[0]);
        }
    }

    private boolean isMainProcess() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public void aea() {
        if (this.bRJ != null && isMainProcess() && this.bRH && !aeb()) {
            this.bRJ.aeP();
        }
    }

    public boolean aeb() {
        return UtilHelper.isSameDay(aec(), System.currentTimeMillis());
    }

    private long aec() {
        if (this.bRO == 0) {
            this.bRO = com.baidu.tbadk.core.sharedPref.b.alR().getLong("pref_key_active_config_info", 0L);
        }
        return this.bRO;
    }

    public int aed() {
        return this.bRN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.BdToken.b e(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.bRC.size()) {
                return null;
            }
            List<com.baidu.tbadk.BdToken.b> valueAt = this.bRC.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar2 : valueAt) {
                    if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.adJ() == bVar.adJ()) {
                        return bVar2;
                    }
                }
                continue;
            }
            i = i2 + 1;
        }
    }

    public void aee() {
        this.bRF.compareAndSet(true, false);
        this.bRE.hk(0);
        this.bRE.setTid(0L);
        this.bRE.setFid(0L);
        if (this.bRI != null) {
            this.bRI.aeS();
        }
    }

    public void i(int i, long j) {
        if (isMainProcess()) {
            this.bRN = i;
            this.bRM = j;
            if (this.bRL > 0 && this.bRK > 0 && (j == 0 || j != this.bRL)) {
                j(this.bRK, this.bRL);
                this.bRL = 0L;
                this.bRK = 0;
            }
            aef();
        }
    }

    public void j(int i, long j) {
        k kVar;
        com.baidu.tbadk.BdToken.b aev;
        List<com.baidu.tbadk.BdToken.b> list = this.bRC.get(i);
        if (list != null && !list.isEmpty()) {
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 7) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.ady().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof k) && (aev = (kVar = (k) next).aev()) != null && kVar.getTid() == j && aev.getActivityId() == bVar.getActivityId() && aev.adJ() == bVar.adJ()) {
                                next.dL(true);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void k(int i, long j) {
        if (isMainProcess() && i != 0 && j != 0 && this.bRG) {
            this.bRK = i;
            List<com.baidu.tbadk.BdToken.b> list = this.bRC.get(i);
            if (list != null && !list.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 1) {
                        a(bVar, j);
                    } else if (bVar.getTaskType() != 7) {
                        continue;
                    } else if (bVar.aC(j)) {
                        break;
                    } else {
                        b(bVar, j);
                    }
                }
                this.bRE.hk(i);
                this.bRE.setTid(j);
                this.bRL = j;
                this.bRF.compareAndSet(false, true);
                synchronized (this.bRF) {
                    this.bRF.notify();
                }
            }
        }
    }

    private void a(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        m mVar;
        com.baidu.tbadk.BdToken.b aev;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.ady().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof m) && (aev = (mVar = (m) next).aev()) != null && mVar.getTid() == j && aev.getActivityId() == bVar.getActivityId() && aev.adJ() == bVar.adJ()) {
                z = true;
                break;
            }
        }
        if (!z) {
            m mVar2 = new m(bVar, j);
            mVar2.aH(0L);
            mVar2.dL(false);
            mVar2.hi(bVar.getTag());
            bVar.a(mVar2);
        }
    }

    private void b(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        k kVar;
        com.baidu.tbadk.BdToken.b aev;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.ady().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof k) && (aev = (kVar = (k) next).aev()) != null && kVar.getTid() == j && aev.getActivityId() == bVar.getActivityId() && aev.adJ() == bVar.adJ()) {
                z = true;
                break;
            }
        }
        if (!z) {
            k kVar2 = new k(bVar, j);
            kVar2.aH(0L);
            kVar2.dL(false);
            kVar2.hi(bVar.getTag());
            bVar.a(kVar2);
        }
    }

    public void l(int i, long j) {
        boolean z;
        if (isMainProcess() && i != 0 && j != 0 && this.bRG) {
            this.bRK = i;
            List<com.baidu.tbadk.BdToken.b> list = this.bRC.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 2) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.ady().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof j) && next.aev().getActivityId() == bVar.getActivityId() && next.aev().adJ() == bVar.adJ() && ((j) next).getFid() == j) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            j jVar = new j(bVar, j);
                            jVar.aH(0L);
                            jVar.dL(false);
                            jVar.hi(bVar.getTag());
                            bVar.a(jVar);
                        }
                        z2 = z;
                    }
                }
                this.bRE.hk(i);
                this.bRE.setFid(j);
                this.bRF.compareAndSet(false, true);
                synchronized (this.bRF) {
                    this.bRF.notify();
                }
            }
        }
    }

    public void hj(int i) {
        boolean z;
        if (isMainProcess() && i != 0 && this.bRG) {
            this.bRK = i;
            List<com.baidu.tbadk.BdToken.b> list = this.bRC.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 4) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.ady().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof i) && next.aev().getActivityId() == bVar.getActivityId() && next.aev().adJ() == bVar.adJ()) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            i iVar = new i(bVar);
                            iVar.aH(0L);
                            iVar.dL(false);
                            bVar.a(iVar);
                        }
                        z2 = z;
                    }
                }
                this.bRE.hk(i);
                this.bRF.compareAndSet(false, true);
                synchronized (this.bRF) {
                    this.bRF.notify();
                }
            }
        }
    }

    public void aef() {
        int i;
        List<com.baidu.tbadk.BdToken.b> list;
        boolean z;
        if (isMainProcess() && this.bRG && (list = this.bRC.get((i = com.baidu.tbadk.BdToken.b.bQQ))) != null && !list.isEmpty()) {
            boolean z2 = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 8) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.ady().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = z2;
                            break;
                        }
                        com.baidu.tbadk.BdToken.h next = it.next();
                        com.baidu.tbadk.BdToken.b aev = next.aev();
                        if (aev != null && (next instanceof l) && aev.getActivityId() == bVar.getActivityId() && aev.adJ() == bVar.adJ()) {
                            ((l) next).aex();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        l lVar = new l(bVar);
                        lVar.aH(0L);
                        lVar.dL(false);
                        bVar.a(lVar);
                    }
                    z2 = z;
                }
            }
            this.bRE.hk(i);
            this.bRF.compareAndSet(false, true);
            synchronized (this.bRF) {
                this.bRF.notify();
            }
        }
    }

    private void startTimer() {
        this.bRB.scheduleWithFixedDelay(this.bRE, 0L, 1L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tbadk.BdToken.b bVar) {
        int[] adO;
        for (int i : bVar.adO()) {
            List<com.baidu.tbadk.BdToken.b> list = this.bRC.get(i);
            if (list == null) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(bVar);
                this.bRC.put(i, linkedList);
            } else {
                list.add(bVar);
            }
        }
    }

    private boolean g(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return false;
        }
        int[] adO = bVar.adO();
        if (adO == null) {
            return true;
        }
        for (int i : adO) {
            List<com.baidu.tbadk.BdToken.b> list = this.bRC.get(i);
            if (list == null) {
                return false;
            }
            for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.adJ() == bVar.adJ()) {
                    if (bVar2.adG()) {
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
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.ady().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.aev() != null) {
                    com.baidu.tbadk.BdToken.b aev = next.aev();
                    if (aev.getActivityId() == bVar.getActivityId() && aev.adJ() == bVar.adJ()) {
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
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.ady().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.aev() != null) {
                    com.baidu.tbadk.BdToken.b aev = next.aev();
                    if (aev.getActivityId() == bVar.getActivityId() && aev.adJ() == bVar.adJ()) {
                        it.remove();
                    }
                }
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bRC.size()) {
                    List<com.baidu.tbadk.BdToken.b> valueAt = this.bRC.valueAt(i2);
                    if (valueAt != null && !valueAt.isEmpty()) {
                        Iterator<com.baidu.tbadk.BdToken.b> it2 = valueAt.iterator();
                        while (it2.hasNext()) {
                            com.baidu.tbadk.BdToken.b next2 = it2.next();
                            if (next2 != null && next2.getActivityId() == bVar.getActivityId() && next2.adJ() == bVar.adJ()) {
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
                p.aeB().q(bVar);
            } else if (!this.bRG) {
                this.bRD.add(bVar);
            } else if (!g(bVar)) {
                f(bVar);
                new b().execute(bVar);
            }
        }
    }

    public void aj(List<com.baidu.tbadk.BdToken.b> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            if (!this.bRG) {
                this.bRD.addAll(list);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar != null) {
                    if (bVar.getTaskType() == 9) {
                        p.aeB().q(bVar);
                    } else if (!g(bVar)) {
                        f(bVar);
                        arrayList.add(bVar);
                    }
                }
            }
            new C0276c().execute(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.BdToken.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0276c extends BdAsyncTask<List<com.baidu.tbadk.BdToken.b>, Integer, Void> {
        private C0276c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(List<com.baidu.tbadk.BdToken.b>... listArr) {
            if (listArr != null && listArr.length > 0 && listArr[0] != null) {
                com.baidu.tbadk.BdToken.a.adv().aj(listArr[0]);
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
            linkedList.addAll(com.baidu.tbadk.BdToken.a.adv().adw());
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next != null && next.adG()) {
                    com.baidu.tbadk.BdToken.a.adv().c(next);
                    it.remove();
                } else if (next.getTaskType() == 7) {
                    next.adA();
                    com.baidu.tbadk.BdToken.a.adv().b(next);
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
                        if (next.adO() != null) {
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
                com.baidu.tbadk.BdToken.a.adv().a(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.adv().c(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.adv().c(bVar2);
            }
            if (bVar != null) {
                com.baidu.tbadk.BdToken.a.adv().a(bVar);
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
            com.baidu.tbadk.BdToken.a.adv().b(bVar);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(com.baidu.tbadk.BdToken.b bVar) {
            if (bVar != null && bVar.bRz) {
                bVar.bRz = false;
                c.this.k(c.this.bRK, c.this.bRL);
            }
        }
    }

    public void aeg() {
        List<com.baidu.tbadk.BdToken.b> list = this.bRC.get(com.baidu.tbadk.BdToken.b.bQQ);
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            boolean z = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bVar.ady().iterator();
                boolean z2 = z;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof l) {
                        l lVar = (l) next;
                        if (!next.aK()) {
                            lVar.aex();
                            z2 = true;
                        }
                    }
                }
                z = z2;
            }
            if (z && !this.bRF.get()) {
                this.bRE.hk(com.baidu.tbadk.BdToken.b.bQQ);
                this.bRF.compareAndSet(false, true);
                synchronized (this.bRF) {
                    this.bRF.notify();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private volatile int bRV;
        private volatile boolean bRW;
        private volatile long bRk;
        private volatile long mFid;

        private a() {
            this.bRW = false;
        }

        public synchronized void hk(int i) {
            this.bRV = i;
        }

        public synchronized void setTid(long j) {
            this.bRk = j;
        }

        public synchronized void setFid(long j) {
            this.mFid = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.bRV == 0 || !c.this.bRF.get()) {
                synchronized (c.this.bRF) {
                    try {
                        c.this.bRF.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            aeh();
        }

        private void aeh() {
            this.bRW = true;
            List<com.baidu.tbadk.BdToken.b> list = (List) c.this.bRC.get(com.baidu.tbadk.BdToken.b.bQQ);
            List<com.baidu.tbadk.BdToken.b> list2 = (List) c.this.bRC.get(this.bRV);
            if (com.baidu.tbadk.core.util.v.isEmpty(list) && com.baidu.tbadk.core.util.v.isEmpty(list2)) {
                c.this.bRF.compareAndSet(true, false);
                return;
            }
            d.b bVar = new d.b();
            bVar.bTG = new LinkedList();
            bVar.bTH = new LinkedList();
            bVar.bTI = new LinkedList();
            a(list, bVar);
            b(list2, bVar);
            if (this.bRW) {
                c.this.bRF.compareAndSet(true, false);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(bVar.bTI)) {
                com.baidu.tbadk.BdToken.a.adv().ak(bVar.bTI);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(bVar.bTG) || !com.baidu.tbadk.core.util.v.isEmpty(bVar.bTH)) {
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
            ArrayList<com.baidu.tbadk.BdToken.h> ady;
            if (bVar != null && bVar2 != null && (ady = bVar.ady()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = ady.iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if ((next instanceof l) && !((l) next).isTimeout() && !next.aK()) {
                        this.bRW = false;
                        next.hl(1);
                        if (next.aew() >= next.aev().adP()) {
                            next.dL(true);
                            bVar2.s(bVar);
                        }
                        bVar2.t(bVar);
                    }
                }
            }
        }

        private void b(com.baidu.tbadk.BdToken.b bVar, d.b bVar2) {
            ArrayList<com.baidu.tbadk.BdToken.h> ady;
            if (bVar != null && bVar2 != null && (ady = bVar.ady()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = ady.iterator();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof m) {
                        m mVar = (m) next;
                        if (this.bRk != 0 && mVar.getTid() == this.bRk && !next.aK()) {
                            this.bRW = false;
                            next.hl(1);
                            if (next.aew() >= next.aev().adP()) {
                                next.dL(true);
                                if (next.aev().adE() >= next.aev().getThreadNum()) {
                                    bVar2.c(next);
                                }
                            }
                            bVar2.t(bVar);
                        }
                    } else if (next instanceof k) {
                        k kVar = (k) next;
                        if (!bVar.adY() && kVar.getTag() == bVar.getTag()) {
                            if (this.bRk != 0 && kVar.getTid() == this.bRk && !next.aK()) {
                                this.bRW = false;
                                next.hl(1);
                            }
                            i = (int) (i + next.aew());
                            if (this.bRk != 0 && kVar.getTid() == this.bRk && !next.aK()) {
                                if (next.aew() >= bVar.adP()) {
                                    next.dL(true);
                                    bVar.adE();
                                }
                                bVar2.t(bVar);
                            }
                            int adz = bVar.adz();
                            int threadNum = bVar.getThreadNum();
                            if (i >= bVar.adP() * bVar.getThreadNum() && adz >= threadNum) {
                                bVar2.s(bVar);
                                bVar.dK(true);
                            }
                        }
                    } else if (next instanceof j) {
                        if (this.mFid != 0 && ((j) next).getFid() == this.mFid && !next.aK()) {
                            this.bRW = false;
                            next.hl(1);
                            if (next.aew() >= next.aev().adP()) {
                                next.dL(true);
                                if (next.aev().adD() >= next.aev().adQ()) {
                                    bVar2.c(next);
                                }
                            }
                        }
                    } else if ((next instanceof i) && !next.aK()) {
                        this.bRW = false;
                        next.hl(1);
                        if (next.aew() >= next.aev().adP()) {
                            next.dL(true);
                            bVar2.c(next);
                        }
                    }
                }
            }
        }
    }
}
