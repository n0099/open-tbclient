package com.baidu.tbadk.BdToken;

import android.util.Pair;
import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
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
    private a byA;
    private AtomicBoolean byB;
    private boolean byC;
    private boolean byD;
    private com.baidu.tbadk.BdToken.completeTask.d byE;
    private com.baidu.tbadk.BdToken.activeConfig.b byF;
    private int byG;
    private long byH;
    private long byI;
    private int byJ;
    private long byK;
    private CustomMessageListener byL;
    private CustomMessageListener byM;
    private CustomMessageListener byN;
    private com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a> byO;
    private com.baidu.tbadk.h.b byP;
    private final ScheduledExecutorService byx;
    private final SparseArray<List<com.baidu.tbadk.BdToken.b>> byy;
    private final LinkedList<com.baidu.tbadk.BdToken.b> byz;
    private BdUniqueId mBdUniqueId;

    public static final c Zg() {
        return g.byT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g {
        private static final c byT = new c();
    }

    private c() {
        this.byx = Executors.newSingleThreadScheduledExecutor();
        this.byy = new SparseArray<>();
        this.byz = new LinkedList<>();
        this.byA = new a();
        this.byB = new AtomicBoolean(false);
        this.byC = false;
        this.byD = false;
        this.byL = new CustomMessageListener(2921391) { // from class: com.baidu.tbadk.BdToken.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.byC = true;
                if (!c.this.byz.isEmpty()) {
                    Iterator it = c.this.byz.iterator();
                    while (it.hasNext()) {
                        c.this.l((com.baidu.tbadk.BdToken.b) it.next());
                    }
                    c.this.byz.clear();
                }
            }
        };
        this.byM = new CustomMessageListener(2001011) { // from class: com.baidu.tbadk.BdToken.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                    ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                    c.this.Zh();
                }
            }
        };
        this.byN = new CustomMessageListener(2001371) { // from class: com.baidu.tbadk.BdToken.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                    c.this.byD = true;
                    c.this.Zh();
                }
            }
        };
        this.byO = new com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a>() { // from class: com.baidu.tbadk.BdToken.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: a */
            public void onSuccess(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    com.baidu.tbadk.core.sharedPref.b.ahO().putLong("pref_key_active_config_info", currentTimeMillis);
                    c.this.byK = currentTimeMillis;
                    c.this.K(aVar.ZU());
                }
            }

            @Override // com.baidu.tbadk.h.a
            public void onError(int i, String str) {
            }
        };
        this.byP = new com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b>() { // from class: com.baidu.tbadk.BdToken.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.b
            /* renamed from: m */
            public void onProgressUpdate(com.baidu.tbadk.BdToken.b bVar) {
                if (bVar != null) {
                    com.baidu.tbadk.BdToken.b e2 = c.this.e(bVar);
                    if (e2 != null && e2.byv) {
                        e2.reset();
                        c.this.j(e2);
                        return;
                    }
                    n.ZF().o(e2);
                    if (e2 != null && e2.getTaskType() == 7) {
                        e2.YM();
                        int Ze = e2.Ze();
                        int tag = e2.getTag();
                        if (Ze <= 1 || Ze <= tag) {
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
        this.byE = new com.baidu.tbadk.BdToken.completeTask.d(this.mBdUniqueId);
        this.byE.a(this.byP);
        this.byF = new com.baidu.tbadk.BdToken.activeConfig.b(this.mBdUniqueId);
        this.byF.a(this.byO);
        this.byN.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.byN);
        this.byM.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.byM);
        this.byL.setPriority(Integer.MIN_VALUE);
        this.byL.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.byL);
        com.baidu.tbadk.core.g.a.ahL().init();
        p.ZI().h(this.mBdUniqueId);
        iO();
        if (isMainProcess()) {
            new f().execute(new Void[0]);
        }
    }

    private boolean isMainProcess() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public void Zh() {
        if (this.byF != null && isMainProcess() && this.byD && !Zi()) {
            this.byF.ZW();
        }
    }

    public boolean Zi() {
        return UtilHelper.isSameDay(Zj(), System.currentTimeMillis());
    }

    private long Zj() {
        if (this.byK == 0) {
            this.byK = com.baidu.tbadk.core.sharedPref.b.ahO().getLong("pref_key_active_config_info", 0L);
        }
        return this.byK;
    }

    public int Zk() {
        return this.byJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.BdToken.b e(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.byy.size()) {
                return null;
            }
            List<com.baidu.tbadk.BdToken.b> valueAt = this.byy.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar2 : valueAt) {
                    if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.YQ() == bVar.YQ()) {
                        return bVar2;
                    }
                }
                continue;
            }
            i = i2 + 1;
        }
    }

    public void Zl() {
        this.byB.compareAndSet(true, false);
        this.byA.go(0);
        this.byA.setTid(0L);
        this.byA.setFid(0L);
        if (this.byE != null) {
            this.byE.ZZ();
        }
    }

    public void i(int i, long j) {
        if (isMainProcess()) {
            this.byJ = i;
            this.byI = j;
            if (this.byH > 0 && this.byG > 0 && (j == 0 || j != this.byH)) {
                j(this.byG, this.byH);
                this.byH = 0L;
                this.byG = 0;
            }
            Zm();
        }
    }

    public void j(int i, long j) {
        k kVar;
        com.baidu.tbadk.BdToken.b ZC;
        List<com.baidu.tbadk.BdToken.b> list = this.byy.get(i);
        if (list != null && !list.isEmpty()) {
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 7) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.YF().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof k) && (ZC = (kVar = (k) next).ZC()) != null && kVar.getTid() == j && ZC.getActivityId() == bVar.getActivityId() && ZC.YQ() == bVar.YQ()) {
                                next.du(true);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void k(int i, long j) {
        if (isMainProcess() && i != 0 && j != 0 && this.byC) {
            this.byG = i;
            List<com.baidu.tbadk.BdToken.b> list = this.byy.get(i);
            if (list != null && !list.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 1) {
                        a(bVar, j);
                    } else if (bVar.getTaskType() != 7) {
                        continue;
                    } else if (bVar.aj(j)) {
                        break;
                    } else {
                        b(bVar, j);
                    }
                }
                this.byA.go(i);
                this.byA.setTid(j);
                this.byH = j;
                this.byB.compareAndSet(false, true);
                synchronized (this.byB) {
                    this.byB.notify();
                }
            }
        }
    }

    private void a(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        m mVar;
        com.baidu.tbadk.BdToken.b ZC;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.YF().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof m) && (ZC = (mVar = (m) next).ZC()) != null && mVar.getTid() == j && ZC.getActivityId() == bVar.getActivityId() && ZC.YQ() == bVar.YQ()) {
                z = true;
                break;
            }
        }
        if (!z) {
            m mVar2 = new m(bVar, j);
            mVar2.ao(0L);
            mVar2.du(false);
            mVar2.gm(bVar.getTag());
            bVar.a(mVar2);
        }
    }

    private void b(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        k kVar;
        com.baidu.tbadk.BdToken.b ZC;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.YF().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof k) && (ZC = (kVar = (k) next).ZC()) != null && kVar.getTid() == j && ZC.getActivityId() == bVar.getActivityId() && ZC.YQ() == bVar.YQ()) {
                z = true;
                break;
            }
        }
        if (!z) {
            k kVar2 = new k(bVar, j);
            kVar2.ao(0L);
            kVar2.du(false);
            kVar2.gm(bVar.getTag());
            bVar.a(kVar2);
        }
    }

    public void l(int i, long j) {
        boolean z;
        if (isMainProcess() && i != 0 && j != 0 && this.byC) {
            this.byG = i;
            List<com.baidu.tbadk.BdToken.b> list = this.byy.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 2) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.YF().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof j) && next.ZC().getActivityId() == bVar.getActivityId() && next.ZC().YQ() == bVar.YQ() && ((j) next).getFid() == j) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            j jVar = new j(bVar, j);
                            jVar.ao(0L);
                            jVar.du(false);
                            jVar.gm(bVar.getTag());
                            bVar.a(jVar);
                        }
                        z2 = z;
                    }
                }
                this.byA.go(i);
                this.byA.setFid(j);
                this.byB.compareAndSet(false, true);
                synchronized (this.byB) {
                    this.byB.notify();
                }
            }
        }
    }

    public void gn(int i) {
        boolean z;
        if (isMainProcess() && i != 0 && this.byC) {
            this.byG = i;
            List<com.baidu.tbadk.BdToken.b> list = this.byy.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 4) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.YF().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof i) && next.ZC().getActivityId() == bVar.getActivityId() && next.ZC().YQ() == bVar.YQ()) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            i iVar = new i(bVar);
                            iVar.ao(0L);
                            iVar.du(false);
                            bVar.a(iVar);
                        }
                        z2 = z;
                    }
                }
                this.byA.go(i);
                this.byB.compareAndSet(false, true);
                synchronized (this.byB) {
                    this.byB.notify();
                }
            }
        }
    }

    public void Zm() {
        int i;
        List<com.baidu.tbadk.BdToken.b> list;
        boolean z;
        if (isMainProcess() && this.byC && (list = this.byy.get((i = com.baidu.tbadk.BdToken.b.bxM))) != null && !list.isEmpty()) {
            boolean z2 = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 8) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.YF().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = z2;
                            break;
                        }
                        com.baidu.tbadk.BdToken.h next = it.next();
                        com.baidu.tbadk.BdToken.b ZC = next.ZC();
                        if (ZC != null && (next instanceof l) && ZC.getActivityId() == bVar.getActivityId() && ZC.YQ() == bVar.YQ()) {
                            ((l) next).ZE();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        l lVar = new l(bVar);
                        lVar.ao(0L);
                        lVar.du(false);
                        bVar.a(lVar);
                    }
                    z2 = z;
                }
            }
            this.byA.go(i);
            this.byB.compareAndSet(false, true);
            synchronized (this.byB) {
                this.byB.notify();
            }
        }
    }

    private void iO() {
        this.byx.scheduleWithFixedDelay(this.byA, 0L, 1L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tbadk.BdToken.b bVar) {
        int[] YV;
        for (int i : bVar.YV()) {
            List<com.baidu.tbadk.BdToken.b> list = this.byy.get(i);
            if (list == null) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(bVar);
                this.byy.put(i, linkedList);
            } else {
                list.add(bVar);
            }
        }
    }

    private boolean g(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return false;
        }
        int[] YV = bVar.YV();
        if (YV == null) {
            return true;
        }
        for (int i : YV) {
            List<com.baidu.tbadk.BdToken.b> list = this.byy.get(i);
            if (list == null) {
                return false;
            }
            for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.YQ() == bVar.YQ()) {
                    if (bVar2.YN()) {
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
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.YF().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.ZC() != null) {
                    com.baidu.tbadk.BdToken.b ZC = next.ZC();
                    if (ZC.getActivityId() == bVar.getActivityId() && ZC.YQ() == bVar.YQ()) {
                        if (taskType == 7 && (next instanceof k)) {
                            ((k) next).du(true);
                        } else if (taskType == 1 && (next instanceof m)) {
                            ((m) next).du(true);
                        }
                    }
                }
            }
            bVar.dt(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar != null) {
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.YF().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.ZC() != null) {
                    com.baidu.tbadk.BdToken.b ZC = next.ZC();
                    if (ZC.getActivityId() == bVar.getActivityId() && ZC.YQ() == bVar.YQ()) {
                        it.remove();
                    }
                }
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.byy.size()) {
                    List<com.baidu.tbadk.BdToken.b> valueAt = this.byy.valueAt(i2);
                    if (valueAt != null && !valueAt.isEmpty()) {
                        Iterator<com.baidu.tbadk.BdToken.b> it2 = valueAt.iterator();
                        while (it2.hasNext()) {
                            com.baidu.tbadk.BdToken.b next2 = it2.next();
                            if (next2 != null && next2.getActivityId() == bVar.getActivityId() && next2.YQ() == bVar.YQ()) {
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
                p.ZI().q(bVar);
            } else if (!this.byC) {
                this.byz.add(bVar);
            } else if (!g(bVar)) {
                f(bVar);
                new b().execute(bVar);
            }
        }
    }

    public void K(List<com.baidu.tbadk.BdToken.b> list) {
        if (!com.baidu.tbadk.core.util.v.aa(list)) {
            if (!this.byC) {
                this.byz.addAll(list);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar != null) {
                    if (bVar.getTaskType() == 9) {
                        p.ZI().q(bVar);
                    } else if (!g(bVar)) {
                        f(bVar);
                        arrayList.add(bVar);
                    }
                }
            }
            new C0230c().execute(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.BdToken.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0230c extends BdAsyncTask<List<com.baidu.tbadk.BdToken.b>, Integer, Void> {
        private C0230c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(List<com.baidu.tbadk.BdToken.b>... listArr) {
            if (listArr != null && listArr.length > 0 && listArr[0] != null) {
                com.baidu.tbadk.BdToken.a.YC().K(listArr[0]);
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
        /* renamed from: b */
        public LinkedList<com.baidu.tbadk.BdToken.b> doInBackground(Void... voidArr) {
            LinkedList<com.baidu.tbadk.BdToken.b> linkedList = new LinkedList<>();
            linkedList.addAll(com.baidu.tbadk.BdToken.a.YC().YD());
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next != null && next.YN()) {
                    com.baidu.tbadk.BdToken.a.YC().c(next);
                    it.remove();
                } else if (next.getTaskType() == 7) {
                    next.YH();
                    com.baidu.tbadk.BdToken.a.YC().b(next);
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
                        if (next.YV() != null) {
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
                com.baidu.tbadk.BdToken.a.YC().a(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.YC().c(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.YC().c(bVar2);
            }
            if (bVar != null) {
                com.baidu.tbadk.BdToken.a.YC().a(bVar);
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
            com.baidu.tbadk.BdToken.a.YC().b(bVar);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(com.baidu.tbadk.BdToken.b bVar) {
            if (bVar != null && bVar.byv) {
                bVar.byv = false;
                c.this.k(c.this.byG, c.this.byH);
            }
        }
    }

    public void Zn() {
        List<com.baidu.tbadk.BdToken.b> list = this.byy.get(com.baidu.tbadk.BdToken.b.bxM);
        if (!com.baidu.tbadk.core.util.v.aa(list)) {
            boolean z = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bVar.YF().iterator();
                boolean z2 = z;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof l) {
                        l lVar = (l) next;
                        if (!next.bh()) {
                            lVar.ZE();
                            z2 = true;
                        }
                    }
                }
                z = z2;
            }
            if (z && !this.byB.get()) {
                this.byA.go(com.baidu.tbadk.BdToken.b.bxM);
                this.byB.compareAndSet(false, true);
                synchronized (this.byB) {
                    this.byB.notify();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private volatile int byR;
        private volatile boolean byS;
        private volatile long byg;
        private volatile long mFid;

        private a() {
            this.byS = false;
        }

        public synchronized void go(int i) {
            this.byR = i;
        }

        public synchronized void setTid(long j) {
            this.byg = j;
        }

        public synchronized void setFid(long j) {
            this.mFid = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.byR == 0 || !c.this.byB.get()) {
                synchronized (c.this.byB) {
                    try {
                        c.this.byB.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            Zo();
        }

        private void Zo() {
            this.byS = true;
            List<com.baidu.tbadk.BdToken.b> list = (List) c.this.byy.get(com.baidu.tbadk.BdToken.b.bxM);
            List<com.baidu.tbadk.BdToken.b> list2 = (List) c.this.byy.get(this.byR);
            if (com.baidu.tbadk.core.util.v.aa(list) && com.baidu.tbadk.core.util.v.aa(list2)) {
                c.this.byB.compareAndSet(true, false);
                return;
            }
            d.b bVar = new d.b();
            bVar.bAA = new LinkedList();
            bVar.bAB = new LinkedList();
            bVar.bAC = new LinkedList();
            a(list, bVar);
            b(list2, bVar);
            if (this.byS) {
                c.this.byB.compareAndSet(true, false);
            }
            if (!com.baidu.tbadk.core.util.v.aa(bVar.bAC)) {
                com.baidu.tbadk.BdToken.a.YC().L(bVar.bAC);
            }
            if (!com.baidu.tbadk.core.util.v.aa(bVar.bAA) || !com.baidu.tbadk.core.util.v.aa(bVar.bAB)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921379, bVar));
            }
        }

        private void a(List<com.baidu.tbadk.BdToken.b> list, d.b bVar) {
            if (!com.baidu.tbadk.core.util.v.aa(list)) {
                for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                    a(bVar2, bVar);
                }
            }
        }

        private void b(List<com.baidu.tbadk.BdToken.b> list, d.b bVar) {
            if (!com.baidu.tbadk.core.util.v.aa(list)) {
                for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                    b(bVar2, bVar);
                }
            }
        }

        private void a(com.baidu.tbadk.BdToken.b bVar, d.b bVar2) {
            ArrayList<com.baidu.tbadk.BdToken.h> YF;
            if (bVar != null && bVar2 != null && (YF = bVar.YF()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = YF.iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if ((next instanceof l) && !((l) next).isTimeout() && !next.bh()) {
                        this.byS = false;
                        next.gp(1);
                        if (next.ZD() >= next.ZC().YW()) {
                            next.du(true);
                            bVar2.s(bVar);
                        }
                        bVar2.t(bVar);
                    }
                }
            }
        }

        private void b(com.baidu.tbadk.BdToken.b bVar, d.b bVar2) {
            ArrayList<com.baidu.tbadk.BdToken.h> YF;
            if (bVar != null && bVar2 != null && (YF = bVar.YF()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = YF.iterator();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof m) {
                        m mVar = (m) next;
                        if (this.byg != 0 && mVar.getTid() == this.byg && !next.bh()) {
                            this.byS = false;
                            next.gp(1);
                            if (next.ZD() >= next.ZC().YW()) {
                                next.du(true);
                                if (next.ZC().YL() >= next.ZC().getThreadNum()) {
                                    bVar2.c(next);
                                }
                            }
                            bVar2.t(bVar);
                        }
                    } else if (next instanceof k) {
                        k kVar = (k) next;
                        if (!bVar.Zf() && kVar.getTag() == bVar.getTag()) {
                            if (this.byg != 0 && kVar.getTid() == this.byg && !next.bh()) {
                                this.byS = false;
                                next.gp(1);
                            }
                            i = (int) (i + next.ZD());
                            if (this.byg != 0 && kVar.getTid() == this.byg && !next.bh()) {
                                if (next.ZD() >= bVar.YW()) {
                                    next.du(true);
                                    bVar.YL();
                                }
                                bVar2.t(bVar);
                            }
                            int YG = bVar.YG();
                            int threadNum = bVar.getThreadNum();
                            if (i >= bVar.YW() * bVar.getThreadNum() && YG >= threadNum) {
                                bVar2.s(bVar);
                                bVar.dt(true);
                            }
                        }
                    } else if (next instanceof j) {
                        if (this.mFid != 0 && ((j) next).getFid() == this.mFid && !next.bh()) {
                            this.byS = false;
                            next.gp(1);
                            if (next.ZD() >= next.ZC().YW()) {
                                next.du(true);
                                if (next.ZC().YK() >= next.ZC().YX()) {
                                    bVar2.c(next);
                                }
                            }
                        }
                    } else if ((next instanceof i) && !next.bh()) {
                        this.byS = false;
                        next.gp(1);
                        if (next.ZD() >= next.ZC().YW()) {
                            next.du(true);
                            bVar2.c(next);
                        }
                    }
                }
            }
        }
    }
}
