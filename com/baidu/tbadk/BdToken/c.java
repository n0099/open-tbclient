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
    private final ScheduledExecutorService dgH;
    private final SparseArray<List<com.baidu.tbadk.BdToken.b>> dgI;
    private final LinkedList<com.baidu.tbadk.BdToken.b> dgJ;
    private a dgK;
    private AtomicBoolean dgL;
    private boolean dgM;
    private boolean dgN;
    private com.baidu.tbadk.BdToken.completeTask.d dgO;
    private com.baidu.tbadk.BdToken.activeConfig.b dgP;
    private int dgQ;
    private long dgR;
    private long dgS;
    private int dgT;
    private long dgU;
    private CustomMessageListener dgV;
    private com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a> dgW;
    private com.baidu.tbadk.h.b dgX;
    private CustomMessageListener mBackgroundListener;
    private BdUniqueId mBdUniqueId;
    private CustomMessageListener mSyncFinishListener;

    public static final c aFN() {
        return g.dhb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g {
        private static final c dhb = new c();
    }

    private c() {
        this.dgH = Executors.newSingleThreadScheduledExecutor();
        this.dgI = new SparseArray<>();
        this.dgJ = new LinkedList<>();
        this.dgK = new a();
        this.dgL = new AtomicBoolean(false);
        this.dgM = false;
        this.dgN = false;
        this.dgV = new CustomMessageListener(2921391) { // from class: com.baidu.tbadk.BdToken.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.dgM = true;
                if (!c.this.dgJ.isEmpty()) {
                    Iterator it = c.this.dgJ.iterator();
                    while (it.hasNext()) {
                        c.this.l((com.baidu.tbadk.BdToken.b) it.next());
                    }
                    c.this.dgJ.clear();
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
                    c.this.dgN = true;
                    c.this.aFO();
                }
            }
        };
        this.dgW = new com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a>() { // from class: com.baidu.tbadk.BdToken.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: a */
            public void onSuccess(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    com.baidu.tbadk.core.sharedPref.b.aNV().putLong("pref_key_active_config_info", currentTimeMillis);
                    c.this.dgU = currentTimeMillis;
                    c.this.ax(aVar.aGA());
                }
            }

            @Override // com.baidu.tbadk.h.a
            public void onError(int i, String str) {
            }
        };
        this.dgX = new com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b>() { // from class: com.baidu.tbadk.BdToken.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.b
            /* renamed from: m */
            public void onProgressUpdate(com.baidu.tbadk.BdToken.b bVar) {
                if (bVar != null) {
                    com.baidu.tbadk.BdToken.b e2 = c.this.e(bVar);
                    if (e2 != null && e2.dgF) {
                        e2.reset();
                        c.this.j(e2);
                        return;
                    }
                    n.aGl().o(e2);
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
        this.dgO = new com.baidu.tbadk.BdToken.completeTask.d(this.mBdUniqueId);
        this.dgO.a(this.dgX);
        this.dgP = new com.baidu.tbadk.BdToken.activeConfig.b(this.mBdUniqueId);
        this.dgP.a(this.dgW);
        this.mSyncFinishListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        this.mBackgroundListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mBackgroundListener);
        this.dgV.setPriority(Integer.MIN_VALUE);
        this.dgV.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.dgV);
        com.baidu.tbadk.core.f.a.aNS().init();
        p.aGo().h(this.mBdUniqueId);
        startTimer();
        if (isMainProcess()) {
            new f().execute(new Void[0]);
        }
    }

    private boolean isMainProcess() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public void aFO() {
        if (this.dgP != null && isMainProcess() && this.dgN && !aFP()) {
            this.dgP.aGC();
        }
    }

    public boolean aFP() {
        return UtilHelper.isSameDay(aFQ(), System.currentTimeMillis());
    }

    private long aFQ() {
        if (this.dgU == 0) {
            this.dgU = com.baidu.tbadk.core.sharedPref.b.aNV().getLong("pref_key_active_config_info", 0L);
        }
        return this.dgU;
    }

    public int aFR() {
        return this.dgT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.BdToken.b e(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.dgI.size()) {
                return null;
            }
            List<com.baidu.tbadk.BdToken.b> valueAt = this.dgI.valueAt(i2);
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
        this.dgL.compareAndSet(true, false);
        this.dgK.js(0);
        this.dgK.setTid(0L);
        this.dgK.setFid(0L);
        if (this.dgO != null) {
            this.dgO.aGF();
        }
    }

    public void m(int i, long j) {
        if (isMainProcess()) {
            this.dgT = i;
            this.dgS = j;
            if (this.dgR > 0 && this.dgQ > 0 && (j == 0 || j != this.dgR)) {
                n(this.dgQ, this.dgR);
                this.dgR = 0L;
                this.dgQ = 0;
            }
            aFT();
        }
    }

    public void n(int i, long j) {
        k kVar;
        com.baidu.tbadk.BdToken.b aGi;
        List<com.baidu.tbadk.BdToken.b> list = this.dgI.get(i);
        if (list != null && !list.isEmpty()) {
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 7) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aFm().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof k) && (aGi = (kVar = (k) next).aGi()) != null && kVar.getTid() == j && aGi.getActivityId() == bVar.getActivityId() && aGi.aFx() == bVar.aFx()) {
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
        if (isMainProcess() && i != 0 && j != 0 && this.dgM) {
            this.dgQ = i;
            List<com.baidu.tbadk.BdToken.b> list = this.dgI.get(i);
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
                this.dgK.js(i);
                this.dgK.setTid(j);
                this.dgR = j;
                this.dgL.compareAndSet(false, true);
                synchronized (this.dgL) {
                    this.dgL.notify();
                }
            }
        }
    }

    private void a(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        m mVar;
        com.baidu.tbadk.BdToken.b aGi;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aFm().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof m) && (aGi = (mVar = (m) next).aGi()) != null && mVar.getTid() == j && aGi.getActivityId() == bVar.getActivityId() && aGi.aFx() == bVar.aFx()) {
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
        com.baidu.tbadk.BdToken.b aGi;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aFm().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof k) && (aGi = (kVar = (k) next).aGi()) != null && kVar.getTid() == j && aGi.getActivityId() == bVar.getActivityId() && aGi.aFx() == bVar.aFx()) {
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
        if (isMainProcess() && i != 0 && j != 0 && this.dgM) {
            this.dgQ = i;
            List<com.baidu.tbadk.BdToken.b> list = this.dgI.get(i);
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
                            if ((next instanceof j) && next.aGi().getActivityId() == bVar.getActivityId() && next.aGi().aFx() == bVar.aFx() && ((j) next).getFid() == j) {
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
                this.dgK.js(i);
                this.dgK.setFid(j);
                this.dgL.compareAndSet(false, true);
                synchronized (this.dgL) {
                    this.dgL.notify();
                }
            }
        }
    }

    public void jr(int i) {
        boolean z;
        if (isMainProcess() && i != 0 && this.dgM) {
            this.dgQ = i;
            List<com.baidu.tbadk.BdToken.b> list = this.dgI.get(i);
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
                            if ((next instanceof i) && next.aGi().getActivityId() == bVar.getActivityId() && next.aGi().aFx() == bVar.aFx()) {
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
                this.dgK.js(i);
                this.dgL.compareAndSet(false, true);
                synchronized (this.dgL) {
                    this.dgL.notify();
                }
            }
        }
    }

    public void aFT() {
        int i;
        List<com.baidu.tbadk.BdToken.b> list;
        boolean z;
        if (isMainProcess() && this.dgM && (list = this.dgI.get((i = com.baidu.tbadk.BdToken.b.dfX))) != null && !list.isEmpty()) {
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
                        com.baidu.tbadk.BdToken.b aGi = next.aGi();
                        if (aGi != null && (next instanceof l) && aGi.getActivityId() == bVar.getActivityId() && aGi.aFx() == bVar.aFx()) {
                            ((l) next).aGk();
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
            this.dgK.js(i);
            this.dgL.compareAndSet(false, true);
            synchronized (this.dgL) {
                this.dgL.notify();
            }
        }
    }

    private void startTimer() {
        this.dgH.scheduleWithFixedDelay(this.dgK, 0L, 1L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tbadk.BdToken.b bVar) {
        int[] aFC;
        for (int i : bVar.aFC()) {
            List<com.baidu.tbadk.BdToken.b> list = this.dgI.get(i);
            if (list == null) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(bVar);
                this.dgI.put(i, linkedList);
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
            List<com.baidu.tbadk.BdToken.b> list = this.dgI.get(i);
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
                if (next != null && next.aGi() != null) {
                    com.baidu.tbadk.BdToken.b aGi = next.aGi();
                    if (aGi.getActivityId() == bVar.getActivityId() && aGi.aFx() == bVar.aFx()) {
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
                if (next != null && next.aGi() != null) {
                    com.baidu.tbadk.BdToken.b aGi = next.aGi();
                    if (aGi.getActivityId() == bVar.getActivityId() && aGi.aFx() == bVar.aFx()) {
                        it.remove();
                    }
                }
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.dgI.size()) {
                    List<com.baidu.tbadk.BdToken.b> valueAt = this.dgI.valueAt(i2);
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
                p.aGo().q(bVar);
            } else if (!this.dgM) {
                this.dgJ.add(bVar);
            } else if (!g(bVar)) {
                f(bVar);
                new b().execute(bVar);
            }
        }
    }

    public void ax(List<com.baidu.tbadk.BdToken.b> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            if (!this.dgM) {
                this.dgJ.addAll(list);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar != null) {
                    if (bVar.getTaskType() == 9) {
                        p.aGo().q(bVar);
                    } else if (!g(bVar)) {
                        f(bVar);
                        arrayList.add(bVar);
                    }
                }
            }
            new C0401c().execute(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.BdToken.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0401c extends BdAsyncTask<List<com.baidu.tbadk.BdToken.b>, Integer, Void> {
        private C0401c() {
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
            if (bVar != null && bVar.dgF) {
                bVar.dgF = false;
                c.this.o(c.this.dgQ, c.this.dgR);
            }
        }
    }

    public void aFU() {
        List<com.baidu.tbadk.BdToken.b> list = this.dgI.get(com.baidu.tbadk.BdToken.b.dfX);
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
                            lVar.aGk();
                            z2 = true;
                        }
                    }
                }
                z = z2;
            }
            if (z && !this.dgL.get()) {
                this.dgK.js(com.baidu.tbadk.BdToken.b.dfX);
                this.dgL.compareAndSet(false, true);
                synchronized (this.dgL) {
                    this.dgL.notify();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private volatile int dgZ;
        private volatile long dgr;
        private volatile boolean dha;
        private volatile long mFid;

        private a() {
            this.dha = false;
        }

        public synchronized void js(int i) {
            this.dgZ = i;
        }

        public synchronized void setTid(long j) {
            this.dgr = j;
        }

        public synchronized void setFid(long j) {
            this.mFid = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.dgZ == 0 || !c.this.dgL.get()) {
                synchronized (c.this.dgL) {
                    try {
                        c.this.dgL.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            aFV();
        }

        private void aFV() {
            this.dha = true;
            List<com.baidu.tbadk.BdToken.b> list = (List) c.this.dgI.get(com.baidu.tbadk.BdToken.b.dfX);
            List<com.baidu.tbadk.BdToken.b> list2 = (List) c.this.dgI.get(this.dgZ);
            if (com.baidu.tbadk.core.util.v.isEmpty(list) && com.baidu.tbadk.core.util.v.isEmpty(list2)) {
                c.this.dgL.compareAndSet(true, false);
                return;
            }
            d.b bVar = new d.b();
            bVar.diV = new LinkedList();
            bVar.diW = new LinkedList();
            bVar.diX = new LinkedList();
            a(list, bVar);
            b(list2, bVar);
            if (this.dha) {
                c.this.dgL.compareAndSet(true, false);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(bVar.diX)) {
                com.baidu.tbadk.BdToken.a.aFj().ay(bVar.diX);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(bVar.diV) || !com.baidu.tbadk.core.util.v.isEmpty(bVar.diW)) {
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
                        this.dha = false;
                        next.jt(1);
                        if (next.aGj() >= next.aGi().aFD()) {
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
                        if (this.dgr != 0 && mVar.getTid() == this.dgr && !next.gt()) {
                            this.dha = false;
                            next.jt(1);
                            if (next.aGj() >= next.aGi().aFD()) {
                                next.gh(true);
                                if (next.aGi().aFs() >= next.aGi().getThreadNum()) {
                                    bVar2.c(next);
                                }
                            }
                            bVar2.t(bVar);
                        }
                    } else if (next instanceof k) {
                        k kVar = (k) next;
                        if (!bVar.aFM() && kVar.getTag() == bVar.getTag()) {
                            if (this.dgr != 0 && kVar.getTid() == this.dgr && !next.gt()) {
                                this.dha = false;
                                next.jt(1);
                            }
                            i = (int) (i + next.aGj());
                            if (this.dgr != 0 && kVar.getTid() == this.dgr && !next.gt()) {
                                if (next.aGj() >= bVar.aFD()) {
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
                            this.dha = false;
                            next.jt(1);
                            if (next.aGj() >= next.aGi().aFD()) {
                                next.gh(true);
                                if (next.aGi().aFr() >= next.aGi().aFE()) {
                                    bVar2.c(next);
                                }
                            }
                        }
                    } else if ((next instanceof i) && !next.gt()) {
                        this.dha = false;
                        next.jt(1);
                        if (next.aGj() >= next.aGi().aFD()) {
                            next.gh(true);
                            bVar2.c(next);
                        }
                    }
                }
            }
        }
    }
}
