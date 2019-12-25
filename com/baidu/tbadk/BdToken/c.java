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
    private CustomMessageListener cDA;
    private com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a> cDB;
    private com.baidu.tbadk.h.b cDC;
    private final ScheduledExecutorService cDk;
    private final SparseArray<List<com.baidu.tbadk.BdToken.b>> cDl;
    private final LinkedList<com.baidu.tbadk.BdToken.b> cDm;
    private a cDn;
    private AtomicBoolean cDo;
    private boolean cDp;
    private boolean cDq;
    private com.baidu.tbadk.BdToken.completeTask.d cDr;
    private com.baidu.tbadk.BdToken.activeConfig.b cDs;
    private int cDt;
    private long cDu;
    private long cDv;
    private int cDw;
    private long cDx;
    private CustomMessageListener cDy;
    private CustomMessageListener cDz;
    private BdUniqueId mBdUniqueId;

    public static final c auQ() {
        return g.cDG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g {
        private static final c cDG = new c();
    }

    private c() {
        this.cDk = Executors.newSingleThreadScheduledExecutor();
        this.cDl = new SparseArray<>();
        this.cDm = new LinkedList<>();
        this.cDn = new a();
        this.cDo = new AtomicBoolean(false);
        this.cDp = false;
        this.cDq = false;
        this.cDy = new CustomMessageListener(2921391) { // from class: com.baidu.tbadk.BdToken.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.cDp = true;
                if (!c.this.cDm.isEmpty()) {
                    Iterator it = c.this.cDm.iterator();
                    while (it.hasNext()) {
                        c.this.l((com.baidu.tbadk.BdToken.b) it.next());
                    }
                    c.this.cDm.clear();
                }
            }
        };
        this.cDz = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.BdToken.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                    ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                    c.this.auR();
                }
            }
        };
        this.cDA = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tbadk.BdToken.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                    c.this.cDq = true;
                    c.this.auR();
                }
            }
        };
        this.cDB = new com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a>() { // from class: com.baidu.tbadk.BdToken.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: a */
            public void onSuccess(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    com.baidu.tbadk.core.sharedPref.b.aCY().putLong("pref_key_active_config_info", currentTimeMillis);
                    c.this.cDx = currentTimeMillis;
                    c.this.ap(aVar.avE());
                }
            }

            @Override // com.baidu.tbadk.h.a
            public void onError(int i, String str) {
            }
        };
        this.cDC = new com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b>() { // from class: com.baidu.tbadk.BdToken.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.b
            /* renamed from: m */
            public void onProgressUpdate(com.baidu.tbadk.BdToken.b bVar) {
                if (bVar != null) {
                    com.baidu.tbadk.BdToken.b e2 = c.this.e(bVar);
                    if (e2 != null && e2.cDi) {
                        e2.reset();
                        c.this.j(e2);
                        return;
                    }
                    n.avp().o(e2);
                    if (e2 != null && e2.getTaskType() == 7) {
                        e2.auw();
                        int auO = e2.auO();
                        int tag = e2.getTag();
                        if (auO <= 1 || auO <= tag) {
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
        this.cDr = new com.baidu.tbadk.BdToken.completeTask.d(this.mBdUniqueId);
        this.cDr.a(this.cDC);
        this.cDs = new com.baidu.tbadk.BdToken.activeConfig.b(this.mBdUniqueId);
        this.cDs.a(this.cDB);
        this.cDA.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.cDA);
        this.cDz.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.cDz);
        this.cDy.setPriority(Integer.MIN_VALUE);
        this.cDy.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.cDy);
        com.baidu.tbadk.core.f.a.aCV().init();
        p.avs().h(this.mBdUniqueId);
        startTimer();
        if (isMainProcess()) {
            new f().execute(new Void[0]);
        }
    }

    private boolean isMainProcess() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public void auR() {
        if (this.cDs != null && isMainProcess() && this.cDq && !auS()) {
            this.cDs.avG();
        }
    }

    public boolean auS() {
        return UtilHelper.isSameDay(auT(), System.currentTimeMillis());
    }

    private long auT() {
        if (this.cDx == 0) {
            this.cDx = com.baidu.tbadk.core.sharedPref.b.aCY().getLong("pref_key_active_config_info", 0L);
        }
        return this.cDx;
    }

    public int auU() {
        return this.cDw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.BdToken.b e(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cDl.size()) {
                return null;
            }
            List<com.baidu.tbadk.BdToken.b> valueAt = this.cDl.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar2 : valueAt) {
                    if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.auA() == bVar.auA()) {
                        return bVar2;
                    }
                }
                continue;
            }
            i = i2 + 1;
        }
    }

    public void auV() {
        this.cDo.compareAndSet(true, false);
        this.cDn.iU(0);
        this.cDn.setTid(0L);
        this.cDn.setFid(0L);
        if (this.cDr != null) {
            this.cDr.avJ();
        }
    }

    public void m(int i, long j) {
        if (isMainProcess()) {
            this.cDw = i;
            this.cDv = j;
            if (this.cDu > 0 && this.cDt > 0 && (j == 0 || j != this.cDu)) {
                n(this.cDt, this.cDu);
                this.cDu = 0L;
                this.cDt = 0;
            }
            auW();
        }
    }

    public void n(int i, long j) {
        k kVar;
        com.baidu.tbadk.BdToken.b avm;
        List<com.baidu.tbadk.BdToken.b> list = this.cDl.get(i);
        if (list != null && !list.isEmpty()) {
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 7) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aup().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof k) && (avm = (kVar = (k) next).avm()) != null && kVar.getTid() == j && avm.getActivityId() == bVar.getActivityId() && avm.auA() == bVar.auA()) {
                                next.eX(true);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void o(int i, long j) {
        if (isMainProcess() && i != 0 && j != 0 && this.cDp) {
            this.cDt = i;
            List<com.baidu.tbadk.BdToken.b> list = this.cDl.get(i);
            if (list != null && !list.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 1) {
                        a(bVar, j);
                    } else if (bVar.getTaskType() != 7) {
                        continue;
                    } else if (bVar.bg(j)) {
                        break;
                    } else {
                        b(bVar, j);
                    }
                }
                this.cDn.iU(i);
                this.cDn.setTid(j);
                this.cDu = j;
                this.cDo.compareAndSet(false, true);
                synchronized (this.cDo) {
                    this.cDo.notify();
                }
            }
        }
    }

    private void a(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        m mVar;
        com.baidu.tbadk.BdToken.b avm;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aup().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof m) && (avm = (mVar = (m) next).avm()) != null && mVar.getTid() == j && avm.getActivityId() == bVar.getActivityId() && avm.auA() == bVar.auA()) {
                z = true;
                break;
            }
        }
        if (!z) {
            m mVar2 = new m(bVar, j);
            mVar2.bl(0L);
            mVar2.eX(false);
            mVar2.iS(bVar.getTag());
            bVar.a(mVar2);
        }
    }

    private void b(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        k kVar;
        com.baidu.tbadk.BdToken.b avm;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aup().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof k) && (avm = (kVar = (k) next).avm()) != null && kVar.getTid() == j && avm.getActivityId() == bVar.getActivityId() && avm.auA() == bVar.auA()) {
                z = true;
                break;
            }
        }
        if (!z) {
            k kVar2 = new k(bVar, j);
            kVar2.bl(0L);
            kVar2.eX(false);
            kVar2.iS(bVar.getTag());
            bVar.a(kVar2);
        }
    }

    public void p(int i, long j) {
        boolean z;
        if (isMainProcess() && i != 0 && j != 0 && this.cDp) {
            this.cDt = i;
            List<com.baidu.tbadk.BdToken.b> list = this.cDl.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 2) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aup().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof j) && next.avm().getActivityId() == bVar.getActivityId() && next.avm().auA() == bVar.auA() && ((j) next).getFid() == j) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            j jVar = new j(bVar, j);
                            jVar.bl(0L);
                            jVar.eX(false);
                            jVar.iS(bVar.getTag());
                            bVar.a(jVar);
                        }
                        z2 = z;
                    }
                }
                this.cDn.iU(i);
                this.cDn.setFid(j);
                this.cDo.compareAndSet(false, true);
                synchronized (this.cDo) {
                    this.cDo.notify();
                }
            }
        }
    }

    public void iT(int i) {
        boolean z;
        if (isMainProcess() && i != 0 && this.cDp) {
            this.cDt = i;
            List<com.baidu.tbadk.BdToken.b> list = this.cDl.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 4) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aup().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof i) && next.avm().getActivityId() == bVar.getActivityId() && next.avm().auA() == bVar.auA()) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            i iVar = new i(bVar);
                            iVar.bl(0L);
                            iVar.eX(false);
                            bVar.a(iVar);
                        }
                        z2 = z;
                    }
                }
                this.cDn.iU(i);
                this.cDo.compareAndSet(false, true);
                synchronized (this.cDo) {
                    this.cDo.notify();
                }
            }
        }
    }

    public void auW() {
        int i;
        List<com.baidu.tbadk.BdToken.b> list;
        boolean z;
        if (isMainProcess() && this.cDp && (list = this.cDl.get((i = com.baidu.tbadk.BdToken.b.cCA))) != null && !list.isEmpty()) {
            boolean z2 = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 8) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aup().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = z2;
                            break;
                        }
                        com.baidu.tbadk.BdToken.h next = it.next();
                        com.baidu.tbadk.BdToken.b avm = next.avm();
                        if (avm != null && (next instanceof l) && avm.getActivityId() == bVar.getActivityId() && avm.auA() == bVar.auA()) {
                            ((l) next).avo();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        l lVar = new l(bVar);
                        lVar.bl(0L);
                        lVar.eX(false);
                        bVar.a(lVar);
                    }
                    z2 = z;
                }
            }
            this.cDn.iU(i);
            this.cDo.compareAndSet(false, true);
            synchronized (this.cDo) {
                this.cDo.notify();
            }
        }
    }

    private void startTimer() {
        this.cDk.scheduleWithFixedDelay(this.cDn, 0L, 1L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tbadk.BdToken.b bVar) {
        int[] auF;
        for (int i : bVar.auF()) {
            List<com.baidu.tbadk.BdToken.b> list = this.cDl.get(i);
            if (list == null) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(bVar);
                this.cDl.put(i, linkedList);
            } else {
                list.add(bVar);
            }
        }
    }

    private boolean g(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return false;
        }
        int[] auF = bVar.auF();
        if (auF == null) {
            return true;
        }
        for (int i : auF) {
            List<com.baidu.tbadk.BdToken.b> list = this.cDl.get(i);
            if (list == null) {
                return false;
            }
            for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.auA() == bVar.auA()) {
                    if (bVar2.aux()) {
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
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aup().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.avm() != null) {
                    com.baidu.tbadk.BdToken.b avm = next.avm();
                    if (avm.getActivityId() == bVar.getActivityId() && avm.auA() == bVar.auA()) {
                        if (taskType == 7 && (next instanceof k)) {
                            ((k) next).eX(true);
                        } else if (taskType == 1 && (next instanceof m)) {
                            ((m) next).eX(true);
                        }
                    }
                }
            }
            bVar.eW(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar != null) {
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aup().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.avm() != null) {
                    com.baidu.tbadk.BdToken.b avm = next.avm();
                    if (avm.getActivityId() == bVar.getActivityId() && avm.auA() == bVar.auA()) {
                        it.remove();
                    }
                }
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.cDl.size()) {
                    List<com.baidu.tbadk.BdToken.b> valueAt = this.cDl.valueAt(i2);
                    if (valueAt != null && !valueAt.isEmpty()) {
                        Iterator<com.baidu.tbadk.BdToken.b> it2 = valueAt.iterator();
                        while (it2.hasNext()) {
                            com.baidu.tbadk.BdToken.b next2 = it2.next();
                            if (next2 != null && next2.getActivityId() == bVar.getActivityId() && next2.auA() == bVar.auA()) {
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
                p.avs().q(bVar);
            } else if (!this.cDp) {
                this.cDm.add(bVar);
            } else if (!g(bVar)) {
                f(bVar);
                new b().execute(bVar);
            }
        }
    }

    public void ap(List<com.baidu.tbadk.BdToken.b> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            if (!this.cDp) {
                this.cDm.addAll(list);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar != null) {
                    if (bVar.getTaskType() == 9) {
                        p.avs().q(bVar);
                    } else if (!g(bVar)) {
                        f(bVar);
                        arrayList.add(bVar);
                    }
                }
            }
            new C0359c().execute(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.BdToken.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0359c extends BdAsyncTask<List<com.baidu.tbadk.BdToken.b>, Integer, Void> {
        private C0359c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(List<com.baidu.tbadk.BdToken.b>... listArr) {
            if (listArr != null && listArr.length > 0 && listArr[0] != null) {
                com.baidu.tbadk.BdToken.a.aum().ap(listArr[0]);
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
            linkedList.addAll(com.baidu.tbadk.BdToken.a.aum().aun());
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next != null && next.aux()) {
                    com.baidu.tbadk.BdToken.a.aum().c(next);
                    it.remove();
                } else if (next.getTaskType() == 7) {
                    next.aur();
                    com.baidu.tbadk.BdToken.a.aum().b(next);
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
                        if (next.auF() != null) {
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
                com.baidu.tbadk.BdToken.a.aum().a(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.aum().c(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.aum().c(bVar2);
            }
            if (bVar != null) {
                com.baidu.tbadk.BdToken.a.aum().a(bVar);
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
            com.baidu.tbadk.BdToken.a.aum().b(bVar);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(com.baidu.tbadk.BdToken.b bVar) {
            if (bVar != null && bVar.cDi) {
                bVar.cDi = false;
                c.this.o(c.this.cDt, c.this.cDu);
            }
        }
    }

    public void auX() {
        List<com.baidu.tbadk.BdToken.b> list = this.cDl.get(com.baidu.tbadk.BdToken.b.cCA);
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            boolean z = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aup().iterator();
                boolean z2 = z;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof l) {
                        l lVar = (l) next;
                        if (!next.aW()) {
                            lVar.avo();
                            z2 = true;
                        }
                    }
                }
                z = z2;
            }
            if (z && !this.cDo.get()) {
                this.cDn.iU(com.baidu.tbadk.BdToken.b.cCA);
                this.cDo.compareAndSet(false, true);
                synchronized (this.cDo) {
                    this.cDo.notify();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private volatile long cCU;
        private volatile int cDE;
        private volatile boolean cDF;
        private volatile long mFid;

        private a() {
            this.cDF = false;
        }

        public synchronized void iU(int i) {
            this.cDE = i;
        }

        public synchronized void setTid(long j) {
            this.cCU = j;
        }

        public synchronized void setFid(long j) {
            this.mFid = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.cDE == 0 || !c.this.cDo.get()) {
                synchronized (c.this.cDo) {
                    try {
                        c.this.cDo.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            auY();
        }

        private void auY() {
            this.cDF = true;
            List<com.baidu.tbadk.BdToken.b> list = (List) c.this.cDl.get(com.baidu.tbadk.BdToken.b.cCA);
            List<com.baidu.tbadk.BdToken.b> list2 = (List) c.this.cDl.get(this.cDE);
            if (com.baidu.tbadk.core.util.v.isEmpty(list) && com.baidu.tbadk.core.util.v.isEmpty(list2)) {
                c.this.cDo.compareAndSet(true, false);
                return;
            }
            d.b bVar = new d.b();
            bVar.cFn = new LinkedList();
            bVar.cFo = new LinkedList();
            bVar.cFp = new LinkedList();
            a(list, bVar);
            b(list2, bVar);
            if (this.cDF) {
                c.this.cDo.compareAndSet(true, false);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(bVar.cFp)) {
                com.baidu.tbadk.BdToken.a.aum().aq(bVar.cFp);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(bVar.cFn) || !com.baidu.tbadk.core.util.v.isEmpty(bVar.cFo)) {
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
            ArrayList<com.baidu.tbadk.BdToken.h> aup;
            if (bVar != null && bVar2 != null && (aup = bVar.aup()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = aup.iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if ((next instanceof l) && !((l) next).isTimeout() && !next.aW()) {
                        this.cDF = false;
                        next.iV(1);
                        if (next.avn() >= next.avm().auG()) {
                            next.eX(true);
                            bVar2.s(bVar);
                        }
                        bVar2.t(bVar);
                    }
                }
            }
        }

        private void b(com.baidu.tbadk.BdToken.b bVar, d.b bVar2) {
            ArrayList<com.baidu.tbadk.BdToken.h> aup;
            if (bVar != null && bVar2 != null && (aup = bVar.aup()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = aup.iterator();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof m) {
                        m mVar = (m) next;
                        if (this.cCU != 0 && mVar.getTid() == this.cCU && !next.aW()) {
                            this.cDF = false;
                            next.iV(1);
                            if (next.avn() >= next.avm().auG()) {
                                next.eX(true);
                                if (next.avm().auv() >= next.avm().getThreadNum()) {
                                    bVar2.c(next);
                                }
                            }
                            bVar2.t(bVar);
                        }
                    } else if (next instanceof k) {
                        k kVar = (k) next;
                        if (!bVar.auP() && kVar.getTag() == bVar.getTag()) {
                            if (this.cCU != 0 && kVar.getTid() == this.cCU && !next.aW()) {
                                this.cDF = false;
                                next.iV(1);
                            }
                            i = (int) (i + next.avn());
                            if (this.cCU != 0 && kVar.getTid() == this.cCU && !next.aW()) {
                                if (next.avn() >= bVar.auG()) {
                                    next.eX(true);
                                    bVar.auv();
                                }
                                bVar2.t(bVar);
                            }
                            int auq = bVar.auq();
                            int threadNum = bVar.getThreadNum();
                            if (i >= bVar.auG() * bVar.getThreadNum() && auq >= threadNum) {
                                bVar2.s(bVar);
                                bVar.eW(true);
                            }
                        }
                    } else if (next instanceof j) {
                        if (this.mFid != 0 && ((j) next).getFid() == this.mFid && !next.aW()) {
                            this.cDF = false;
                            next.iV(1);
                            if (next.avn() >= next.avm().auG()) {
                                next.eX(true);
                                if (next.avm().auu() >= next.avm().auH()) {
                                    bVar2.c(next);
                                }
                            }
                        }
                    } else if ((next instanceof i) && !next.aW()) {
                        this.cDF = false;
                        next.iV(1);
                        if (next.avn() >= next.avm().auG()) {
                            next.eX(true);
                            bVar2.c(next);
                        }
                    }
                }
            }
        }
    }
}
