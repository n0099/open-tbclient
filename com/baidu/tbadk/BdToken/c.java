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
    private final ScheduledExecutorService dgM;
    private final SparseArray<List<com.baidu.tbadk.BdToken.b>> dgN;
    private final LinkedList<com.baidu.tbadk.BdToken.b> dgO;
    private a dgP;
    private AtomicBoolean dgQ;
    private boolean dgR;
    private boolean dgS;
    private com.baidu.tbadk.BdToken.completeTask.d dgT;
    private com.baidu.tbadk.BdToken.activeConfig.b dgU;
    private int dgV;
    private long dgW;
    private long dgX;
    private int dgY;
    private long dgZ;
    private CustomMessageListener dha;
    private com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a> dhb;
    private com.baidu.tbadk.h.b dhc;
    private CustomMessageListener mBackgroundListener;
    private BdUniqueId mBdUniqueId;
    private CustomMessageListener mSyncFinishListener;

    public static final c aFN() {
        return g.dhg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g {
        private static final c dhg = new c();
    }

    private c() {
        this.dgM = Executors.newSingleThreadScheduledExecutor();
        this.dgN = new SparseArray<>();
        this.dgO = new LinkedList<>();
        this.dgP = new a();
        this.dgQ = new AtomicBoolean(false);
        this.dgR = false;
        this.dgS = false;
        this.dha = new CustomMessageListener(2921391) { // from class: com.baidu.tbadk.BdToken.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.dgR = true;
                if (!c.this.dgO.isEmpty()) {
                    Iterator it = c.this.dgO.iterator();
                    while (it.hasNext()) {
                        c.this.l((com.baidu.tbadk.BdToken.b) it.next());
                    }
                    c.this.dgO.clear();
                }
            }
        };
        this.mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.BdToken.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                    ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                    c.this.aFO();
                }
            }
        };
        this.mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tbadk.BdToken.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                    c.this.dgS = true;
                    c.this.aFO();
                }
            }
        };
        this.dhb = new com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a>() { // from class: com.baidu.tbadk.BdToken.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: a */
            public void onSuccess(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    com.baidu.tbadk.core.sharedPref.b.aNT().putLong("pref_key_active_config_info", currentTimeMillis);
                    c.this.dgZ = currentTimeMillis;
                    c.this.ax(aVar.aGy());
                }
            }

            @Override // com.baidu.tbadk.h.a
            public void onError(int i, String str) {
            }
        };
        this.dhc = new com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b>() { // from class: com.baidu.tbadk.BdToken.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.b
            /* renamed from: m */
            public void onProgressUpdate(com.baidu.tbadk.BdToken.b bVar) {
                if (bVar != null) {
                    com.baidu.tbadk.BdToken.b e2 = c.this.e(bVar);
                    if (e2 != null && e2.dgK) {
                        e2.reset();
                        c.this.j(e2);
                        return;
                    }
                    n.aGj().o(e2);
                    if (e2 != null && e2.getTaskType() == 7) {
                        e2.aFt();
                        int aFL = e2.aFL();
                        int tag = e2.getTag();
                        if (aFL <= 1 || aFL <= tag) {
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
        this.dgT = new com.baidu.tbadk.BdToken.completeTask.d(this.mBdUniqueId);
        this.dgT.a(this.dhc);
        this.dgU = new com.baidu.tbadk.BdToken.activeConfig.b(this.mBdUniqueId);
        this.dgU.a(this.dhb);
        this.mSyncFinishListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        this.mBackgroundListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mBackgroundListener);
        this.dha.setPriority(Integer.MIN_VALUE);
        this.dha.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.dha);
        com.baidu.tbadk.core.f.a.aNQ().init();
        p.aGm().h(this.mBdUniqueId);
        startTimer();
        if (isMainProcess()) {
            new f().execute(new Void[0]);
        }
    }

    private boolean isMainProcess() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public void aFO() {
        if (this.dgU != null && isMainProcess() && this.dgS && !aFP()) {
            this.dgU.aGA();
        }
    }

    public boolean aFP() {
        return UtilHelper.isSameDay(aFQ(), System.currentTimeMillis());
    }

    private long aFQ() {
        if (this.dgZ == 0) {
            this.dgZ = com.baidu.tbadk.core.sharedPref.b.aNT().getLong("pref_key_active_config_info", 0L);
        }
        return this.dgZ;
    }

    public int aFR() {
        return this.dgY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.BdToken.b e(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.dgN.size()) {
                return null;
            }
            List<com.baidu.tbadk.BdToken.b> valueAt = this.dgN.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar2 : valueAt) {
                    if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.aFx() == bVar.aFx()) {
                        return bVar2;
                    }
                }
                continue;
            }
            i = i2 + 1;
        }
    }

    public void aFS() {
        this.dgQ.compareAndSet(true, false);
        this.dgP.js(0);
        this.dgP.setTid(0L);
        this.dgP.setFid(0L);
        if (this.dgT != null) {
            this.dgT.aGD();
        }
    }

    public void m(int i, long j) {
        if (isMainProcess()) {
            this.dgY = i;
            this.dgX = j;
            if (this.dgW > 0 && this.dgV > 0 && (j == 0 || j != this.dgW)) {
                n(this.dgV, this.dgW);
                this.dgW = 0L;
                this.dgV = 0;
            }
            aFT();
        }
    }

    public void n(int i, long j) {
        k kVar;
        com.baidu.tbadk.BdToken.b aGg;
        List<com.baidu.tbadk.BdToken.b> list = this.dgN.get(i);
        if (list != null && !list.isEmpty()) {
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 7) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aFm().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof k) && (aGg = (kVar = (k) next).aGg()) != null && kVar.getTid() == j && aGg.getActivityId() == bVar.getActivityId() && aGg.aFx() == bVar.aFx()) {
                                next.gh(true);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void o(int i, long j) {
        if (isMainProcess() && i != 0 && j != 0 && this.dgR) {
            this.dgV = i;
            List<com.baidu.tbadk.BdToken.b> list = this.dgN.get(i);
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
                this.dgP.js(i);
                this.dgP.setTid(j);
                this.dgW = j;
                this.dgQ.compareAndSet(false, true);
                synchronized (this.dgQ) {
                    this.dgQ.notify();
                }
            }
        }
    }

    private void a(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        m mVar;
        com.baidu.tbadk.BdToken.b aGg;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aFm().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof m) && (aGg = (mVar = (m) next).aGg()) != null && mVar.getTid() == j && aGg.getActivityId() == bVar.getActivityId() && aGg.aFx() == bVar.aFx()) {
                z = true;
                break;
            }
        }
        if (!z) {
            m mVar2 = new m(bVar, j);
            mVar2.bX(0L);
            mVar2.gh(false);
            mVar2.jq(bVar.getTag());
            bVar.a(mVar2);
        }
    }

    private void b(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        k kVar;
        com.baidu.tbadk.BdToken.b aGg;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aFm().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof k) && (aGg = (kVar = (k) next).aGg()) != null && kVar.getTid() == j && aGg.getActivityId() == bVar.getActivityId() && aGg.aFx() == bVar.aFx()) {
                z = true;
                break;
            }
        }
        if (!z) {
            k kVar2 = new k(bVar, j);
            kVar2.bX(0L);
            kVar2.gh(false);
            kVar2.jq(bVar.getTag());
            bVar.a(kVar2);
        }
    }

    public void p(int i, long j) {
        boolean z;
        if (isMainProcess() && i != 0 && j != 0 && this.dgR) {
            this.dgV = i;
            List<com.baidu.tbadk.BdToken.b> list = this.dgN.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 2) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aFm().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof j) && next.aGg().getActivityId() == bVar.getActivityId() && next.aGg().aFx() == bVar.aFx() && ((j) next).getFid() == j) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            j jVar = new j(bVar, j);
                            jVar.bX(0L);
                            jVar.gh(false);
                            jVar.jq(bVar.getTag());
                            bVar.a(jVar);
                        }
                        z2 = z;
                    }
                }
                this.dgP.js(i);
                this.dgP.setFid(j);
                this.dgQ.compareAndSet(false, true);
                synchronized (this.dgQ) {
                    this.dgQ.notify();
                }
            }
        }
    }

    public void jr(int i) {
        boolean z;
        if (isMainProcess() && i != 0 && this.dgR) {
            this.dgV = i;
            List<com.baidu.tbadk.BdToken.b> list = this.dgN.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 4) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aFm().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof i) && next.aGg().getActivityId() == bVar.getActivityId() && next.aGg().aFx() == bVar.aFx()) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            i iVar = new i(bVar);
                            iVar.bX(0L);
                            iVar.gh(false);
                            bVar.a(iVar);
                        }
                        z2 = z;
                    }
                }
                this.dgP.js(i);
                this.dgQ.compareAndSet(false, true);
                synchronized (this.dgQ) {
                    this.dgQ.notify();
                }
            }
        }
    }

    public void aFT() {
        int i;
        List<com.baidu.tbadk.BdToken.b> list;
        boolean z;
        if (isMainProcess() && this.dgR && (list = this.dgN.get((i = com.baidu.tbadk.BdToken.b.dgc))) != null && !list.isEmpty()) {
            boolean z2 = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 8) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aFm().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = z2;
                            break;
                        }
                        com.baidu.tbadk.BdToken.h next = it.next();
                        com.baidu.tbadk.BdToken.b aGg = next.aGg();
                        if (aGg != null && (next instanceof l) && aGg.getActivityId() == bVar.getActivityId() && aGg.aFx() == bVar.aFx()) {
                            ((l) next).aGi();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        l lVar = new l(bVar);
                        lVar.bX(0L);
                        lVar.gh(false);
                        bVar.a(lVar);
                    }
                    z2 = z;
                }
            }
            this.dgP.js(i);
            this.dgQ.compareAndSet(false, true);
            synchronized (this.dgQ) {
                this.dgQ.notify();
            }
        }
    }

    private void startTimer() {
        this.dgM.scheduleWithFixedDelay(this.dgP, 0L, 1L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tbadk.BdToken.b bVar) {
        int[] aFC;
        for (int i : bVar.aFC()) {
            List<com.baidu.tbadk.BdToken.b> list = this.dgN.get(i);
            if (list == null) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(bVar);
                this.dgN.put(i, linkedList);
            } else {
                list.add(bVar);
            }
        }
    }

    private boolean g(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return false;
        }
        int[] aFC = bVar.aFC();
        if (aFC == null) {
            return true;
        }
        for (int i : aFC) {
            List<com.baidu.tbadk.BdToken.b> list = this.dgN.get(i);
            if (list == null) {
                return false;
            }
            for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.aFx() == bVar.aFx()) {
                    if (bVar2.aFu()) {
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
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aFm().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.aGg() != null) {
                    com.baidu.tbadk.BdToken.b aGg = next.aGg();
                    if (aGg.getActivityId() == bVar.getActivityId() && aGg.aFx() == bVar.aFx()) {
                        if (taskType == 7 && (next instanceof k)) {
                            ((k) next).gh(true);
                        } else if (taskType == 1 && (next instanceof m)) {
                            ((m) next).gh(true);
                        }
                    }
                }
            }
            bVar.gg(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar != null) {
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aFm().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.aGg() != null) {
                    com.baidu.tbadk.BdToken.b aGg = next.aGg();
                    if (aGg.getActivityId() == bVar.getActivityId() && aGg.aFx() == bVar.aFx()) {
                        it.remove();
                    }
                }
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.dgN.size()) {
                    List<com.baidu.tbadk.BdToken.b> valueAt = this.dgN.valueAt(i2);
                    if (valueAt != null && !valueAt.isEmpty()) {
                        Iterator<com.baidu.tbadk.BdToken.b> it2 = valueAt.iterator();
                        while (it2.hasNext()) {
                            com.baidu.tbadk.BdToken.b next2 = it2.next();
                            if (next2 != null && next2.getActivityId() == bVar.getActivityId() && next2.aFx() == bVar.aFx()) {
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
                p.aGm().q(bVar);
            } else if (!this.dgR) {
                this.dgO.add(bVar);
            } else if (!g(bVar)) {
                f(bVar);
                new b().execute(bVar);
            }
        }
    }

    public void ax(List<com.baidu.tbadk.BdToken.b> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            if (!this.dgR) {
                this.dgO.addAll(list);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar != null) {
                    if (bVar.getTaskType() == 9) {
                        p.aGm().q(bVar);
                    } else if (!g(bVar)) {
                        f(bVar);
                        arrayList.add(bVar);
                    }
                }
            }
            new C0422c().execute(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.BdToken.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0422c extends BdAsyncTask<List<com.baidu.tbadk.BdToken.b>, Integer, Void> {
        private C0422c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Void doInBackground(List<com.baidu.tbadk.BdToken.b>... listArr) {
            if (listArr != null && listArr.length > 0 && listArr[0] != null) {
                com.baidu.tbadk.BdToken.a.aFj().ax(listArr[0]);
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
            linkedList.addAll(com.baidu.tbadk.BdToken.a.aFj().aFk());
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next != null && next.aFu()) {
                    com.baidu.tbadk.BdToken.a.aFj().c(next);
                    it.remove();
                } else if (next.getTaskType() == 7) {
                    next.aFo();
                    com.baidu.tbadk.BdToken.a.aFj().b(next);
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
                        if (next.aFC() != null) {
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
                com.baidu.tbadk.BdToken.a.aFj().a(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.aFj().c(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.aFj().c(bVar2);
            }
            if (bVar != null) {
                com.baidu.tbadk.BdToken.a.aFj().a(bVar);
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
            com.baidu.tbadk.BdToken.a.aFj().b(bVar);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(com.baidu.tbadk.BdToken.b bVar) {
            if (bVar != null && bVar.dgK) {
                bVar.dgK = false;
                c.this.o(c.this.dgV, c.this.dgW);
            }
        }
    }

    public void aFU() {
        List<com.baidu.tbadk.BdToken.b> list = this.dgN.get(com.baidu.tbadk.BdToken.b.dgc);
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            boolean z = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aFm().iterator();
                boolean z2 = z;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof l) {
                        l lVar = (l) next;
                        if (!next.gt()) {
                            lVar.aGi();
                            z2 = true;
                        }
                    }
                }
                z = z2;
            }
            if (z && !this.dgQ.get()) {
                this.dgP.js(com.baidu.tbadk.BdToken.b.dgc);
                this.dgQ.compareAndSet(false, true);
                synchronized (this.dgQ) {
                    this.dgQ.notify();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private volatile long dgw;
        private volatile int dhe;
        private volatile boolean dhf;
        private volatile long mFid;

        private a() {
            this.dhf = false;
        }

        public synchronized void js(int i) {
            this.dhe = i;
        }

        public synchronized void setTid(long j) {
            this.dgw = j;
        }

        public synchronized void setFid(long j) {
            this.mFid = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.dhe == 0 || !c.this.dgQ.get()) {
                synchronized (c.this.dgQ) {
                    try {
                        c.this.dgQ.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            aFV();
        }

        private void aFV() {
            this.dhf = true;
            List<com.baidu.tbadk.BdToken.b> list = (List) c.this.dgN.get(com.baidu.tbadk.BdToken.b.dgc);
            List<com.baidu.tbadk.BdToken.b> list2 = (List) c.this.dgN.get(this.dhe);
            if (com.baidu.tbadk.core.util.v.isEmpty(list) && com.baidu.tbadk.core.util.v.isEmpty(list2)) {
                c.this.dgQ.compareAndSet(true, false);
                return;
            }
            d.b bVar = new d.b();
            bVar.diZ = new LinkedList();
            bVar.dja = new LinkedList();
            bVar.djb = new LinkedList();
            a(list, bVar);
            b(list2, bVar);
            if (this.dhf) {
                c.this.dgQ.compareAndSet(true, false);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(bVar.djb)) {
                com.baidu.tbadk.BdToken.a.aFj().ay(bVar.djb);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(bVar.diZ) || !com.baidu.tbadk.core.util.v.isEmpty(bVar.dja)) {
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
            ArrayList<com.baidu.tbadk.BdToken.h> aFm;
            if (bVar != null && bVar2 != null && (aFm = bVar.aFm()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = aFm.iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if ((next instanceof l) && !((l) next).isTimeout() && !next.gt()) {
                        this.dhf = false;
                        next.jt(1);
                        if (next.aGh() >= next.aGg().aFD()) {
                            next.gh(true);
                            bVar2.s(bVar);
                        }
                        bVar2.t(bVar);
                    }
                }
            }
        }

        private void b(com.baidu.tbadk.BdToken.b bVar, d.b bVar2) {
            ArrayList<com.baidu.tbadk.BdToken.h> aFm;
            if (bVar != null && bVar2 != null && (aFm = bVar.aFm()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = aFm.iterator();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof m) {
                        m mVar = (m) next;
                        if (this.dgw != 0 && mVar.getTid() == this.dgw && !next.gt()) {
                            this.dhf = false;
                            next.jt(1);
                            if (next.aGh() >= next.aGg().aFD()) {
                                next.gh(true);
                                if (next.aGg().aFs() >= next.aGg().getThreadNum()) {
                                    bVar2.c(next);
                                }
                            }
                            bVar2.t(bVar);
                        }
                    } else if (next instanceof k) {
                        k kVar = (k) next;
                        if (!bVar.aFM() && kVar.getTag() == bVar.getTag()) {
                            if (this.dgw != 0 && kVar.getTid() == this.dgw && !next.gt()) {
                                this.dhf = false;
                                next.jt(1);
                            }
                            i = (int) (i + next.aGh());
                            if (this.dgw != 0 && kVar.getTid() == this.dgw && !next.gt()) {
                                if (next.aGh() >= bVar.aFD()) {
                                    next.gh(true);
                                    bVar.aFs();
                                }
                                bVar2.t(bVar);
                            }
                            int aFn = bVar.aFn();
                            int threadNum = bVar.getThreadNum();
                            if (i >= bVar.aFD() * bVar.getThreadNum() && aFn >= threadNum) {
                                bVar2.s(bVar);
                                bVar.gg(true);
                            }
                        }
                    } else if (next instanceof j) {
                        if (this.mFid != 0 && ((j) next).getFid() == this.mFid && !next.gt()) {
                            this.dhf = false;
                            next.jt(1);
                            if (next.aGh() >= next.aGg().aFD()) {
                                next.gh(true);
                                if (next.aGg().aFr() >= next.aGg().aFE()) {
                                    bVar2.c(next);
                                }
                            }
                        }
                    } else if ((next instanceof i) && !next.gt()) {
                        this.dhf = false;
                        next.jt(1);
                        if (next.aGh() >= next.aGg().aFD()) {
                            next.gh(true);
                            bVar2.c(next);
                        }
                    }
                }
            }
        }
    }
}
