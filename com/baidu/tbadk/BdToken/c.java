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
    private final ScheduledExecutorService cHG;
    private final SparseArray<List<com.baidu.tbadk.BdToken.b>> cHH;
    private final LinkedList<com.baidu.tbadk.BdToken.b> cHI;
    private a cHJ;
    private AtomicBoolean cHK;
    private boolean cHL;
    private boolean cHM;
    private com.baidu.tbadk.BdToken.completeTask.d cHN;
    private com.baidu.tbadk.BdToken.activeConfig.b cHO;
    private int cHP;
    private long cHQ;
    private long cHR;
    private int cHS;
    private long cHT;
    private CustomMessageListener cHU;
    private com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a> cHV;
    private com.baidu.tbadk.h.b cHW;
    private CustomMessageListener mBackgroundListener;
    private BdUniqueId mBdUniqueId;
    private CustomMessageListener mSyncFinishListener;

    public static final c axC() {
        return g.cIa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g {
        private static final c cIa = new c();
    }

    private c() {
        this.cHG = Executors.newSingleThreadScheduledExecutor();
        this.cHH = new SparseArray<>();
        this.cHI = new LinkedList<>();
        this.cHJ = new a();
        this.cHK = new AtomicBoolean(false);
        this.cHL = false;
        this.cHM = false;
        this.cHU = new CustomMessageListener(2921391) { // from class: com.baidu.tbadk.BdToken.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.cHL = true;
                if (!c.this.cHI.isEmpty()) {
                    Iterator it = c.this.cHI.iterator();
                    while (it.hasNext()) {
                        c.this.l((com.baidu.tbadk.BdToken.b) it.next());
                    }
                    c.this.cHI.clear();
                }
            }
        };
        this.mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.BdToken.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                    ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                    c.this.axD();
                }
            }
        };
        this.mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tbadk.BdToken.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                    c.this.cHM = true;
                    c.this.axD();
                }
            }
        };
        this.cHV = new com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a>() { // from class: com.baidu.tbadk.BdToken.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: a */
            public void onSuccess(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    com.baidu.tbadk.core.sharedPref.b.aFH().putLong("pref_key_active_config_info", currentTimeMillis);
                    c.this.cHT = currentTimeMillis;
                    c.this.ao(aVar.ayp());
                }
            }

            @Override // com.baidu.tbadk.h.a
            public void onError(int i, String str) {
            }
        };
        this.cHW = new com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b>() { // from class: com.baidu.tbadk.BdToken.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.b
            /* renamed from: m */
            public void onProgressUpdate(com.baidu.tbadk.BdToken.b bVar) {
                if (bVar != null) {
                    com.baidu.tbadk.BdToken.b e2 = c.this.e(bVar);
                    if (e2 != null && e2.cHE) {
                        e2.reset();
                        c.this.j(e2);
                        return;
                    }
                    n.aya().o(e2);
                    if (e2 != null && e2.getTaskType() == 7) {
                        e2.axi();
                        int axA = e2.axA();
                        int tag = e2.getTag();
                        if (axA <= 1 || axA <= tag) {
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
        this.cHN = new com.baidu.tbadk.BdToken.completeTask.d(this.mBdUniqueId);
        this.cHN.a(this.cHW);
        this.cHO = new com.baidu.tbadk.BdToken.activeConfig.b(this.mBdUniqueId);
        this.cHO.a(this.cHV);
        this.mSyncFinishListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        this.mBackgroundListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mBackgroundListener);
        this.cHU.setPriority(Integer.MIN_VALUE);
        this.cHU.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.cHU);
        com.baidu.tbadk.core.f.a.aFE().init();
        p.ayd().h(this.mBdUniqueId);
        startTimer();
        if (isMainProcess()) {
            new f().execute(new Void[0]);
        }
    }

    private boolean isMainProcess() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public void axD() {
        if (this.cHO != null && isMainProcess() && this.cHM && !axE()) {
            this.cHO.ayr();
        }
    }

    public boolean axE() {
        return UtilHelper.isSameDay(axF(), System.currentTimeMillis());
    }

    private long axF() {
        if (this.cHT == 0) {
            this.cHT = com.baidu.tbadk.core.sharedPref.b.aFH().getLong("pref_key_active_config_info", 0L);
        }
        return this.cHT;
    }

    public int axG() {
        return this.cHS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.BdToken.b e(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cHH.size()) {
                return null;
            }
            List<com.baidu.tbadk.BdToken.b> valueAt = this.cHH.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar2 : valueAt) {
                    if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.axm() == bVar.axm()) {
                        return bVar2;
                    }
                }
                continue;
            }
            i = i2 + 1;
        }
    }

    public void axH() {
        this.cHK.compareAndSet(true, false);
        this.cHJ.jl(0);
        this.cHJ.setTid(0L);
        this.cHJ.setFid(0L);
        if (this.cHN != null) {
            this.cHN.ayu();
        }
    }

    public void m(int i, long j) {
        if (isMainProcess()) {
            this.cHS = i;
            this.cHR = j;
            if (this.cHQ > 0 && this.cHP > 0 && (j == 0 || j != this.cHQ)) {
                n(this.cHP, this.cHQ);
                this.cHQ = 0L;
                this.cHP = 0;
            }
            axI();
        }
    }

    public void n(int i, long j) {
        k kVar;
        com.baidu.tbadk.BdToken.b axX;
        List<com.baidu.tbadk.BdToken.b> list = this.cHH.get(i);
        if (list != null && !list.isEmpty()) {
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 7) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.axb().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof k) && (axX = (kVar = (k) next).axX()) != null && kVar.getTid() == j && axX.getActivityId() == bVar.getActivityId() && axX.axm() == bVar.axm()) {
                                next.fk(true);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void o(int i, long j) {
        if (isMainProcess() && i != 0 && j != 0 && this.cHL) {
            this.cHP = i;
            List<com.baidu.tbadk.BdToken.b> list = this.cHH.get(i);
            if (list != null && !list.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 1) {
                        a(bVar, j);
                    } else if (bVar.getTaskType() != 7) {
                        continue;
                    } else if (bVar.bn(j)) {
                        break;
                    } else {
                        b(bVar, j);
                    }
                }
                this.cHJ.jl(i);
                this.cHJ.setTid(j);
                this.cHQ = j;
                this.cHK.compareAndSet(false, true);
                synchronized (this.cHK) {
                    this.cHK.notify();
                }
            }
        }
    }

    private void a(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        m mVar;
        com.baidu.tbadk.BdToken.b axX;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.axb().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof m) && (axX = (mVar = (m) next).axX()) != null && mVar.getTid() == j && axX.getActivityId() == bVar.getActivityId() && axX.axm() == bVar.axm()) {
                z = true;
                break;
            }
        }
        if (!z) {
            m mVar2 = new m(bVar, j);
            mVar2.bs(0L);
            mVar2.fk(false);
            mVar2.jj(bVar.getTag());
            bVar.a(mVar2);
        }
    }

    private void b(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        k kVar;
        com.baidu.tbadk.BdToken.b axX;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.axb().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof k) && (axX = (kVar = (k) next).axX()) != null && kVar.getTid() == j && axX.getActivityId() == bVar.getActivityId() && axX.axm() == bVar.axm()) {
                z = true;
                break;
            }
        }
        if (!z) {
            k kVar2 = new k(bVar, j);
            kVar2.bs(0L);
            kVar2.fk(false);
            kVar2.jj(bVar.getTag());
            bVar.a(kVar2);
        }
    }

    public void p(int i, long j) {
        boolean z;
        if (isMainProcess() && i != 0 && j != 0 && this.cHL) {
            this.cHP = i;
            List<com.baidu.tbadk.BdToken.b> list = this.cHH.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 2) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.axb().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof j) && next.axX().getActivityId() == bVar.getActivityId() && next.axX().axm() == bVar.axm() && ((j) next).getFid() == j) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            j jVar = new j(bVar, j);
                            jVar.bs(0L);
                            jVar.fk(false);
                            jVar.jj(bVar.getTag());
                            bVar.a(jVar);
                        }
                        z2 = z;
                    }
                }
                this.cHJ.jl(i);
                this.cHJ.setFid(j);
                this.cHK.compareAndSet(false, true);
                synchronized (this.cHK) {
                    this.cHK.notify();
                }
            }
        }
    }

    public void jk(int i) {
        boolean z;
        if (isMainProcess() && i != 0 && this.cHL) {
            this.cHP = i;
            List<com.baidu.tbadk.BdToken.b> list = this.cHH.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 4) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.axb().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof i) && next.axX().getActivityId() == bVar.getActivityId() && next.axX().axm() == bVar.axm()) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            i iVar = new i(bVar);
                            iVar.bs(0L);
                            iVar.fk(false);
                            bVar.a(iVar);
                        }
                        z2 = z;
                    }
                }
                this.cHJ.jl(i);
                this.cHK.compareAndSet(false, true);
                synchronized (this.cHK) {
                    this.cHK.notify();
                }
            }
        }
    }

    public void axI() {
        int i;
        List<com.baidu.tbadk.BdToken.b> list;
        boolean z;
        if (isMainProcess() && this.cHL && (list = this.cHH.get((i = com.baidu.tbadk.BdToken.b.cGW))) != null && !list.isEmpty()) {
            boolean z2 = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 8) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.axb().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = z2;
                            break;
                        }
                        com.baidu.tbadk.BdToken.h next = it.next();
                        com.baidu.tbadk.BdToken.b axX = next.axX();
                        if (axX != null && (next instanceof l) && axX.getActivityId() == bVar.getActivityId() && axX.axm() == bVar.axm()) {
                            ((l) next).axZ();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        l lVar = new l(bVar);
                        lVar.bs(0L);
                        lVar.fk(false);
                        bVar.a(lVar);
                    }
                    z2 = z;
                }
            }
            this.cHJ.jl(i);
            this.cHK.compareAndSet(false, true);
            synchronized (this.cHK) {
                this.cHK.notify();
            }
        }
    }

    private void startTimer() {
        this.cHG.scheduleWithFixedDelay(this.cHJ, 0L, 1L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tbadk.BdToken.b bVar) {
        int[] axr;
        for (int i : bVar.axr()) {
            List<com.baidu.tbadk.BdToken.b> list = this.cHH.get(i);
            if (list == null) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(bVar);
                this.cHH.put(i, linkedList);
            } else {
                list.add(bVar);
            }
        }
    }

    private boolean g(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return false;
        }
        int[] axr = bVar.axr();
        if (axr == null) {
            return true;
        }
        for (int i : axr) {
            List<com.baidu.tbadk.BdToken.b> list = this.cHH.get(i);
            if (list == null) {
                return false;
            }
            for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.axm() == bVar.axm()) {
                    if (bVar2.axj()) {
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
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.axb().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.axX() != null) {
                    com.baidu.tbadk.BdToken.b axX = next.axX();
                    if (axX.getActivityId() == bVar.getActivityId() && axX.axm() == bVar.axm()) {
                        if (taskType == 7 && (next instanceof k)) {
                            ((k) next).fk(true);
                        } else if (taskType == 1 && (next instanceof m)) {
                            ((m) next).fk(true);
                        }
                    }
                }
            }
            bVar.fj(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar != null) {
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.axb().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.axX() != null) {
                    com.baidu.tbadk.BdToken.b axX = next.axX();
                    if (axX.getActivityId() == bVar.getActivityId() && axX.axm() == bVar.axm()) {
                        it.remove();
                    }
                }
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.cHH.size()) {
                    List<com.baidu.tbadk.BdToken.b> valueAt = this.cHH.valueAt(i2);
                    if (valueAt != null && !valueAt.isEmpty()) {
                        Iterator<com.baidu.tbadk.BdToken.b> it2 = valueAt.iterator();
                        while (it2.hasNext()) {
                            com.baidu.tbadk.BdToken.b next2 = it2.next();
                            if (next2 != null && next2.getActivityId() == bVar.getActivityId() && next2.axm() == bVar.axm()) {
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
                p.ayd().q(bVar);
            } else if (!this.cHL) {
                this.cHI.add(bVar);
            } else if (!g(bVar)) {
                f(bVar);
                new b().execute(bVar);
            }
        }
    }

    public void ao(List<com.baidu.tbadk.BdToken.b> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            if (!this.cHL) {
                this.cHI.addAll(list);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar != null) {
                    if (bVar.getTaskType() == 9) {
                        p.ayd().q(bVar);
                    } else if (!g(bVar)) {
                        f(bVar);
                        arrayList.add(bVar);
                    }
                }
            }
            new C0371c().execute(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.BdToken.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0371c extends BdAsyncTask<List<com.baidu.tbadk.BdToken.b>, Integer, Void> {
        private C0371c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(List<com.baidu.tbadk.BdToken.b>... listArr) {
            if (listArr != null && listArr.length > 0 && listArr[0] != null) {
                com.baidu.tbadk.BdToken.a.awY().ao(listArr[0]);
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
            linkedList.addAll(com.baidu.tbadk.BdToken.a.awY().awZ());
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next != null && next.axj()) {
                    com.baidu.tbadk.BdToken.a.awY().c(next);
                    it.remove();
                } else if (next.getTaskType() == 7) {
                    next.axd();
                    com.baidu.tbadk.BdToken.a.awY().b(next);
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
                        if (next.axr() != null) {
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
                com.baidu.tbadk.BdToken.a.awY().a(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.awY().c(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.awY().c(bVar2);
            }
            if (bVar != null) {
                com.baidu.tbadk.BdToken.a.awY().a(bVar);
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
            com.baidu.tbadk.BdToken.a.awY().b(bVar);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(com.baidu.tbadk.BdToken.b bVar) {
            if (bVar != null && bVar.cHE) {
                bVar.cHE = false;
                c.this.o(c.this.cHP, c.this.cHQ);
            }
        }
    }

    public void axJ() {
        List<com.baidu.tbadk.BdToken.b> list = this.cHH.get(com.baidu.tbadk.BdToken.b.cGW);
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            boolean z = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bVar.axb().iterator();
                boolean z2 = z;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof l) {
                        l lVar = (l) next;
                        if (!next.aW()) {
                            lVar.axZ();
                            z2 = true;
                        }
                    }
                }
                z = z2;
            }
            if (z && !this.cHK.get()) {
                this.cHJ.jl(com.baidu.tbadk.BdToken.b.cGW);
                this.cHK.compareAndSet(false, true);
                synchronized (this.cHK) {
                    this.cHK.notify();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private volatile int cHY;
        private volatile boolean cHZ;
        private volatile long cHq;
        private volatile long mFid;

        private a() {
            this.cHZ = false;
        }

        public synchronized void jl(int i) {
            this.cHY = i;
        }

        public synchronized void setTid(long j) {
            this.cHq = j;
        }

        public synchronized void setFid(long j) {
            this.mFid = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.cHY == 0 || !c.this.cHK.get()) {
                synchronized (c.this.cHK) {
                    try {
                        c.this.cHK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            axK();
        }

        private void axK() {
            this.cHZ = true;
            List<com.baidu.tbadk.BdToken.b> list = (List) c.this.cHH.get(com.baidu.tbadk.BdToken.b.cGW);
            List<com.baidu.tbadk.BdToken.b> list2 = (List) c.this.cHH.get(this.cHY);
            if (com.baidu.tbadk.core.util.v.isEmpty(list) && com.baidu.tbadk.core.util.v.isEmpty(list2)) {
                c.this.cHK.compareAndSet(true, false);
                return;
            }
            d.b bVar = new d.b();
            bVar.cJQ = new LinkedList();
            bVar.cJR = new LinkedList();
            bVar.cJS = new LinkedList();
            a(list, bVar);
            b(list2, bVar);
            if (this.cHZ) {
                c.this.cHK.compareAndSet(true, false);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(bVar.cJS)) {
                com.baidu.tbadk.BdToken.a.awY().ap(bVar.cJS);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(bVar.cJQ) || !com.baidu.tbadk.core.util.v.isEmpty(bVar.cJR)) {
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
            ArrayList<com.baidu.tbadk.BdToken.h> axb;
            if (bVar != null && bVar2 != null && (axb = bVar.axb()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = axb.iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if ((next instanceof l) && !((l) next).isTimeout() && !next.aW()) {
                        this.cHZ = false;
                        next.jm(1);
                        if (next.axY() >= next.axX().axs()) {
                            next.fk(true);
                            bVar2.s(bVar);
                        }
                        bVar2.t(bVar);
                    }
                }
            }
        }

        private void b(com.baidu.tbadk.BdToken.b bVar, d.b bVar2) {
            ArrayList<com.baidu.tbadk.BdToken.h> axb;
            if (bVar != null && bVar2 != null && (axb = bVar.axb()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = axb.iterator();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof m) {
                        m mVar = (m) next;
                        if (this.cHq != 0 && mVar.getTid() == this.cHq && !next.aW()) {
                            this.cHZ = false;
                            next.jm(1);
                            if (next.axY() >= next.axX().axs()) {
                                next.fk(true);
                                if (next.axX().axh() >= next.axX().getThreadNum()) {
                                    bVar2.c(next);
                                }
                            }
                            bVar2.t(bVar);
                        }
                    } else if (next instanceof k) {
                        k kVar = (k) next;
                        if (!bVar.axB() && kVar.getTag() == bVar.getTag()) {
                            if (this.cHq != 0 && kVar.getTid() == this.cHq && !next.aW()) {
                                this.cHZ = false;
                                next.jm(1);
                            }
                            i = (int) (i + next.axY());
                            if (this.cHq != 0 && kVar.getTid() == this.cHq && !next.aW()) {
                                if (next.axY() >= bVar.axs()) {
                                    next.fk(true);
                                    bVar.axh();
                                }
                                bVar2.t(bVar);
                            }
                            int axc = bVar.axc();
                            int threadNum = bVar.getThreadNum();
                            if (i >= bVar.axs() * bVar.getThreadNum() && axc >= threadNum) {
                                bVar2.s(bVar);
                                bVar.fj(true);
                            }
                        }
                    } else if (next instanceof j) {
                        if (this.mFid != 0 && ((j) next).getFid() == this.mFid && !next.aW()) {
                            this.cHZ = false;
                            next.jm(1);
                            if (next.axY() >= next.axX().axs()) {
                                next.fk(true);
                                if (next.axX().axg() >= next.axX().axt()) {
                                    bVar2.c(next);
                                }
                            }
                        }
                    } else if ((next instanceof i) && !next.aW()) {
                        this.cHZ = false;
                        next.jm(1);
                        if (next.axY() >= next.axX().axs()) {
                            next.fk(true);
                            bVar2.c(next);
                        }
                    }
                }
            }
        }
    }
}
