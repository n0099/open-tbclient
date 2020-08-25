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
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class c {
    private int dOA;
    private long dOB;
    private CustomMessageListener dOC;
    private com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a> dOD;
    private com.baidu.tbadk.h.b dOE;
    private final ScheduledExecutorService dOo;
    private final SparseArray<List<com.baidu.tbadk.BdToken.b>> dOp;
    private final LinkedList<com.baidu.tbadk.BdToken.b> dOq;
    private a dOr;
    private AtomicBoolean dOs;
    private boolean dOt;
    private boolean dOu;
    private com.baidu.tbadk.BdToken.completeTask.d dOv;
    private com.baidu.tbadk.BdToken.activeConfig.b dOw;
    private int dOx;
    private long dOy;
    private long dOz;
    private boolean isSchemaUp;
    private CustomMessageListener mBackgroundListener;
    private BdUniqueId mBdUniqueId;
    private CustomMessageListener mSyncFinishListener;

    public static final c aYs() {
        return g.dOI;
    }

    /* loaded from: classes2.dex */
    private static class g {
        private static final c dOI = new c();
    }

    private c() {
        this.dOo = Executors.newSingleThreadScheduledExecutor();
        this.dOp = new SparseArray<>();
        this.dOq = new LinkedList<>();
        this.dOr = new a();
        this.dOs = new AtomicBoolean(false);
        this.dOt = false;
        this.dOu = false;
        this.isSchemaUp = false;
        this.dOC = new CustomMessageListener(2921391) { // from class: com.baidu.tbadk.BdToken.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.dOt = true;
                if (!c.this.dOq.isEmpty()) {
                    Iterator it = c.this.dOq.iterator();
                    while (it.hasNext()) {
                        c.this.l((com.baidu.tbadk.BdToken.b) it.next());
                    }
                    c.this.dOq.clear();
                }
            }
        };
        this.mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.BdToken.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                    ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                    c.this.aYt();
                }
            }
        };
        this.mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tbadk.BdToken.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                    c.this.dOu = true;
                    c.this.aYt();
                }
            }
        };
        this.dOD = new com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a>() { // from class: com.baidu.tbadk.BdToken.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: a */
            public void onSuccess(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null) {
                    c.this.aC(aVar.aZB());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: b */
            public void am(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null && aVar.dQF != null && aVar.dQF.mission != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b();
                    bVar.a(aVar.dQF.mission);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(bVar);
                    c.this.aC(arrayList);
                }
            }

            @Override // com.baidu.tbadk.h.a
            public void onError(int i, String str) {
            }
        };
        this.dOE = new com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b>() { // from class: com.baidu.tbadk.BdToken.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.b
            /* renamed from: m */
            public void onProgressUpdate(com.baidu.tbadk.BdToken.b bVar) {
                if (bVar != null) {
                    com.baidu.tbadk.BdToken.b e2 = c.this.e(bVar);
                    if (e2 != null && e2.dOm) {
                        e2.reset();
                        c.this.j(e2);
                        return;
                    }
                    n.aYT().o(e2);
                    if (e2 != null && e2.getTaskType() == 7) {
                        e2.aXY();
                        int aYq = e2.aYq();
                        int tag = e2.getTag();
                        if (aYq <= 1 || aYq <= tag) {
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
        this.dOv = new com.baidu.tbadk.BdToken.completeTask.d(this.mBdUniqueId);
        this.dOv.a(this.dOE);
        this.dOw = new com.baidu.tbadk.BdToken.activeConfig.b(this.mBdUniqueId);
        this.dOw.a(this.dOD);
        this.mSyncFinishListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        this.mBackgroundListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mBackgroundListener);
        this.dOC.setPriority(Integer.MIN_VALUE);
        this.dOC.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.dOC);
        com.baidu.tbadk.core.f.a.bih().init();
        p.aYW().i(this.mBdUniqueId);
        startTimer();
        if (isMainProcess()) {
            new f().execute(new Void[0]);
        }
    }

    private boolean isMainProcess() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public void aYt() {
        if (this.dOw != null && isMainProcess() && this.dOu && !aYx()) {
            this.dOw.c(aYv(), aYw(), 0);
        }
    }

    public boolean aYu() {
        if (this.dOw != null && isMainProcess()) {
            this.dOw.c(aYv(), aYw(), 1);
            return true;
        }
        return false;
    }

    public boolean aYv() {
        return !aYy();
    }

    public boolean aYw() {
        return this.isSchemaUp;
    }

    public void setSchemaUp(boolean z) {
        this.isSchemaUp = z;
    }

    public boolean aYx() {
        return UtilHelper.isSameDay(aYA(), System.currentTimeMillis());
    }

    public boolean aYy() {
        return UtilHelper.isSameDay(com.baidu.tbadk.core.sharedPref.b.bik().getLong("pref_key_last_active_config", 0L), System.currentTimeMillis());
    }

    public boolean aYz() {
        return UtilHelper.isSameDay(com.baidu.tbadk.core.sharedPref.b.bik().getLong("pref_key_last_popup_time", 0L), System.currentTimeMillis());
    }

    private long aYA() {
        this.dOB = com.baidu.tbadk.core.sharedPref.b.bik().getLong("pref_key_active_config_info", 0L);
        return this.dOB;
    }

    public int aYB() {
        return this.dOA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.BdToken.b e(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.dOp.size()) {
                return null;
            }
            List<com.baidu.tbadk.BdToken.b> valueAt = this.dOp.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar2 : valueAt) {
                    if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.aYc() == bVar.aYc()) {
                        return bVar2;
                    }
                }
                continue;
            }
            i = i2 + 1;
        }
    }

    public void aYC() {
        this.dOs.compareAndSet(true, false);
        this.dOr.mE(0);
        this.dOr.setTid(0L);
        this.dOr.setFid(0L);
        if (this.dOv != null) {
            this.dOv.aZG();
        }
    }

    public void n(int i, long j) {
        if (isMainProcess()) {
            this.dOA = i;
            this.dOz = j;
            if (this.dOy > 0 && this.dOx > 0 && (j == 0 || j != this.dOy)) {
                o(this.dOx, this.dOy);
                this.dOy = 0L;
                this.dOx = 0;
            }
            aYD();
        }
    }

    public void o(int i, long j) {
        k kVar;
        com.baidu.tbadk.BdToken.b aYQ;
        List<com.baidu.tbadk.BdToken.b> list = this.dOp.get(i);
        if (list != null && !list.isEmpty()) {
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 7) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aXR().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof k) && (aYQ = (kVar = (k) next).aYQ()) != null && kVar.getTid() == j && aYQ.getActivityId() == bVar.getActivityId() && aYQ.aYc() == bVar.aYc()) {
                                next.hv(true);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void p(int i, long j) {
        if (isMainProcess() && i != 0 && j != 0 && this.dOt) {
            this.dOx = i;
            List<com.baidu.tbadk.BdToken.b> list = this.dOp.get(i);
            if (list != null && !list.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 1) {
                        a(bVar, j);
                    } else if (bVar.getTaskType() != 7) {
                        continue;
                    } else if (bVar.cr(j)) {
                        break;
                    } else {
                        b(bVar, j);
                    }
                }
                this.dOr.mE(i);
                this.dOr.setTid(j);
                this.dOy = j;
                this.dOs.compareAndSet(false, true);
                synchronized (this.dOs) {
                    this.dOs.notify();
                }
            }
        }
    }

    private void a(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        m mVar;
        com.baidu.tbadk.BdToken.b aYQ;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aXR().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof m) && (aYQ = (mVar = (m) next).aYQ()) != null && mVar.getTid() == j && aYQ.getActivityId() == bVar.getActivityId() && aYQ.aYc() == bVar.aYc()) {
                z = true;
                break;
            }
        }
        if (!z) {
            m mVar2 = new m(bVar, j);
            mVar2.cw(0L);
            mVar2.hv(false);
            mVar2.mC(bVar.getTag());
            bVar.a(mVar2);
        }
    }

    private void b(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        k kVar;
        com.baidu.tbadk.BdToken.b aYQ;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aXR().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof k) && (aYQ = (kVar = (k) next).aYQ()) != null && kVar.getTid() == j && aYQ.getActivityId() == bVar.getActivityId() && aYQ.aYc() == bVar.aYc()) {
                z = true;
                break;
            }
        }
        if (!z) {
            k kVar2 = new k(bVar, j);
            kVar2.cw(0L);
            kVar2.hv(false);
            kVar2.mC(bVar.getTag());
            bVar.a(kVar2);
        }
    }

    public void q(int i, long j) {
        boolean z;
        if (isMainProcess() && i != 0 && j != 0 && this.dOt) {
            this.dOx = i;
            List<com.baidu.tbadk.BdToken.b> list = this.dOp.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 2) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aXR().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof j) && next.aYQ().getActivityId() == bVar.getActivityId() && next.aYQ().aYc() == bVar.aYc() && ((j) next).getFid() == j) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            j jVar = new j(bVar, j);
                            jVar.cw(0L);
                            jVar.hv(false);
                            jVar.mC(bVar.getTag());
                            bVar.a(jVar);
                        }
                        z2 = z;
                    }
                }
                this.dOr.mE(i);
                this.dOr.setFid(j);
                this.dOs.compareAndSet(false, true);
                synchronized (this.dOs) {
                    this.dOs.notify();
                }
            }
        }
    }

    public void mD(int i) {
        boolean z;
        if (isMainProcess() && i != 0 && this.dOt) {
            this.dOx = i;
            List<com.baidu.tbadk.BdToken.b> list = this.dOp.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 4) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aXR().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof i) && next.aYQ().getActivityId() == bVar.getActivityId() && next.aYQ().aYc() == bVar.aYc()) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            i iVar = new i(bVar);
                            iVar.cw(0L);
                            iVar.hv(false);
                            bVar.a(iVar);
                        }
                        z2 = z;
                    }
                }
                this.dOr.mE(i);
                this.dOs.compareAndSet(false, true);
                synchronized (this.dOs) {
                    this.dOs.notify();
                }
            }
        }
    }

    public void aYD() {
        int i;
        List<com.baidu.tbadk.BdToken.b> list;
        boolean z;
        if (isMainProcess() && this.dOt && (list = this.dOp.get((i = com.baidu.tbadk.BdToken.b.dNE))) != null && !list.isEmpty()) {
            boolean z2 = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 8) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aXR().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = z2;
                            break;
                        }
                        com.baidu.tbadk.BdToken.h next = it.next();
                        com.baidu.tbadk.BdToken.b aYQ = next.aYQ();
                        if (aYQ != null && (next instanceof l) && aYQ.getActivityId() == bVar.getActivityId() && aYQ.aYc() == bVar.aYc()) {
                            ((l) next).aYS();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        l lVar = new l(bVar);
                        lVar.cw(0L);
                        lVar.hv(false);
                        bVar.a(lVar);
                    }
                    z2 = z;
                }
            }
            this.dOr.mE(i);
            this.dOs.compareAndSet(false, true);
            synchronized (this.dOs) {
                this.dOs.notify();
            }
        }
    }

    private void startTimer() {
        this.dOo.scheduleWithFixedDelay(this.dOr, 0L, 1L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tbadk.BdToken.b bVar) {
        int[] aYh;
        for (int i : bVar.aYh()) {
            List<com.baidu.tbadk.BdToken.b> list = this.dOp.get(i);
            if (list == null) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(bVar);
                this.dOp.put(i, linkedList);
            } else {
                list.add(bVar);
            }
        }
    }

    private boolean g(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return false;
        }
        int[] aYh = bVar.aYh();
        if (aYh == null) {
            return true;
        }
        for (int i : aYh) {
            List<com.baidu.tbadk.BdToken.b> list = this.dOp.get(i);
            if (list == null) {
                return false;
            }
            for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.aYc() == bVar.aYc()) {
                    if (bVar2.aXZ()) {
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
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aXR().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.aYQ() != null) {
                    com.baidu.tbadk.BdToken.b aYQ = next.aYQ();
                    if (aYQ.getActivityId() == bVar.getActivityId() && aYQ.aYc() == bVar.aYc()) {
                        if (taskType == 7 && (next instanceof k)) {
                            ((k) next).hv(true);
                        } else if (taskType == 1 && (next instanceof m)) {
                            ((m) next).hv(true);
                        }
                    }
                }
            }
            bVar.hu(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar != null) {
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aXR().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.aYQ() != null) {
                    com.baidu.tbadk.BdToken.b aYQ = next.aYQ();
                    if (aYQ.getActivityId() == bVar.getActivityId() && aYQ.aYc() == bVar.aYc()) {
                        it.remove();
                    }
                }
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.dOp.size()) {
                    List<com.baidu.tbadk.BdToken.b> valueAt = this.dOp.valueAt(i2);
                    if (valueAt != null && !valueAt.isEmpty()) {
                        Iterator<com.baidu.tbadk.BdToken.b> it2 = valueAt.iterator();
                        while (it2.hasNext()) {
                            com.baidu.tbadk.BdToken.b next2 = it2.next();
                            if (next2 != null && next2.getActivityId() == bVar.getActivityId() && next2.aYc() == bVar.aYc()) {
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
                p.aYW().q(bVar);
            } else if (!this.dOt) {
                this.dOq.add(bVar);
            } else if (!g(bVar)) {
                f(bVar);
                new b().execute(bVar);
            }
        }
    }

    public void aC(List<com.baidu.tbadk.BdToken.b> list) {
        if (!y.isEmpty(list)) {
            if (!this.dOt) {
                this.dOq.addAll(list);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar != null) {
                    if (bVar.getTaskType() == 9) {
                        p.aYW().q(bVar);
                    } else if (!g(bVar)) {
                        f(bVar);
                        arrayList.add(bVar);
                    }
                }
            }
            new C0532c().execute(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.BdToken.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0532c extends BdAsyncTask<List<com.baidu.tbadk.BdToken.b>, Integer, Void> {
        private C0532c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(List<com.baidu.tbadk.BdToken.b>... listArr) {
            if (listArr != null && listArr.length > 0 && listArr[0] != null) {
                com.baidu.tbadk.BdToken.a.aXO().aC(listArr[0]);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    private class f extends BdAsyncTask<Void, Integer, LinkedList<com.baidu.tbadk.BdToken.b>> {
        private f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public LinkedList<com.baidu.tbadk.BdToken.b> doInBackground(Void... voidArr) {
            LinkedList<com.baidu.tbadk.BdToken.b> linkedList = new LinkedList<>();
            linkedList.addAll(com.baidu.tbadk.BdToken.a.aXO().aXP());
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next != null && next.aXZ()) {
                    com.baidu.tbadk.BdToken.a.aXO().c(next);
                    it.remove();
                } else if (next.getTaskType() == 7) {
                    next.aXT();
                    com.baidu.tbadk.BdToken.a.aXO().b(next);
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
                        if (next.aYh() != null) {
                            c.this.f(next);
                        }
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921391));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends BdAsyncTask<com.baidu.tbadk.BdToken.b, Integer, Void> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Void doInBackground(com.baidu.tbadk.BdToken.b... bVarArr) {
            if (bVarArr != null && bVarArr.length > 0 && bVarArr[0] != null) {
                com.baidu.tbadk.BdToken.a.aXO().a(bVarArr[0]);
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d extends BdAsyncTask<com.baidu.tbadk.BdToken.b, Integer, Void> {
        private d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Void doInBackground(com.baidu.tbadk.BdToken.b... bVarArr) {
            if (bVarArr != null && bVarArr.length > 0 && bVarArr[0] != null) {
                com.baidu.tbadk.BdToken.a.aXO().c(bVarArr[0]);
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
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
                com.baidu.tbadk.BdToken.a.aXO().c(bVar2);
            }
            if (bVar != null) {
                com.baidu.tbadk.BdToken.a.aXO().a(bVar);
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
    /* loaded from: classes2.dex */
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
            com.baidu.tbadk.BdToken.a.aXO().b(bVar);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(com.baidu.tbadk.BdToken.b bVar) {
            if (bVar != null && bVar.dOm) {
                bVar.dOm = false;
                c.this.p(c.this.dOx, c.this.dOy);
            }
        }
    }

    public void aYE() {
        List<com.baidu.tbadk.BdToken.b> list = this.dOp.get(com.baidu.tbadk.BdToken.b.dNE);
        if (!y.isEmpty(list)) {
            boolean z = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aXR().iterator();
                boolean z2 = z;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof l) {
                        l lVar = (l) next;
                        if (!next.ij()) {
                            lVar.aYS();
                            z2 = true;
                        }
                    }
                }
                z = z2;
            }
            if (z && !this.dOs.get()) {
                this.dOr.mE(com.baidu.tbadk.BdToken.b.dNE);
                this.dOs.compareAndSet(false, true);
                synchronized (this.dOs) {
                    this.dOs.notify();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private volatile long dNY;
        private volatile int dOG;
        private volatile boolean dOH;
        private volatile long mFid;

        private a() {
            this.dOH = false;
        }

        public synchronized void mE(int i) {
            this.dOG = i;
        }

        public synchronized void setTid(long j) {
            this.dNY = j;
        }

        public synchronized void setFid(long j) {
            this.mFid = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.dOG == 0 || !c.this.dOs.get()) {
                synchronized (c.this.dOs) {
                    try {
                        c.this.dOs.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            aYF();
        }

        private void aYF() {
            this.dOH = true;
            List<com.baidu.tbadk.BdToken.b> list = (List) c.this.dOp.get(com.baidu.tbadk.BdToken.b.dNE);
            List<com.baidu.tbadk.BdToken.b> list2 = (List) c.this.dOp.get(this.dOG);
            if (y.isEmpty(list) && y.isEmpty(list2)) {
                c.this.dOs.compareAndSet(true, false);
                return;
            }
            d.b bVar = new d.b();
            bVar.dRb = new LinkedList();
            bVar.dRc = new LinkedList();
            bVar.dRd = new LinkedList();
            a(list, bVar);
            b(list2, bVar);
            if (this.dOH) {
                c.this.dOs.compareAndSet(true, false);
            }
            if (!y.isEmpty(bVar.dRd)) {
                com.baidu.tbadk.BdToken.a.aXO().aD(bVar.dRd);
            }
            if (!y.isEmpty(bVar.dRb) || !y.isEmpty(bVar.dRc)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921379, bVar));
            }
        }

        private void a(List<com.baidu.tbadk.BdToken.b> list, d.b bVar) {
            if (!y.isEmpty(list)) {
                for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                    a(bVar2, bVar);
                }
            }
        }

        private void b(List<com.baidu.tbadk.BdToken.b> list, d.b bVar) {
            if (!y.isEmpty(list)) {
                for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                    b(bVar2, bVar);
                }
            }
        }

        private void a(com.baidu.tbadk.BdToken.b bVar, d.b bVar2) {
            ArrayList<com.baidu.tbadk.BdToken.h> aXR;
            if (bVar != null && bVar2 != null && (aXR = bVar.aXR()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = aXR.iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if ((next instanceof l) && !((l) next).isTimeout() && !next.ij()) {
                        this.dOH = false;
                        next.mF(1);
                        if (next.aYR() >= next.aYQ().aYi()) {
                            next.hv(true);
                            bVar2.s(bVar);
                        }
                        bVar2.t(bVar);
                    }
                }
            }
        }

        private void b(com.baidu.tbadk.BdToken.b bVar, d.b bVar2) {
            ArrayList<com.baidu.tbadk.BdToken.h> aXR;
            if (bVar != null && bVar2 != null && (aXR = bVar.aXR()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = aXR.iterator();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof m) {
                        m mVar = (m) next;
                        if (this.dNY != 0 && mVar.getTid() == this.dNY && !next.ij()) {
                            this.dOH = false;
                            next.mF(1);
                            if (next.aYR() >= next.aYQ().aYi()) {
                                next.hv(true);
                                if (next.aYQ().aXX() >= next.aYQ().getThreadNum()) {
                                    bVar2.c(next);
                                }
                            }
                            bVar2.t(bVar);
                        }
                    } else if (next instanceof k) {
                        k kVar = (k) next;
                        if (!bVar.aYr() && kVar.getTag() == bVar.getTag()) {
                            if (this.dNY != 0 && kVar.getTid() == this.dNY && !next.ij()) {
                                this.dOH = false;
                                next.mF(1);
                            }
                            i = (int) (i + next.aYR());
                            if (this.dNY != 0 && kVar.getTid() == this.dNY && !next.ij()) {
                                if (next.aYR() >= bVar.aYi()) {
                                    next.hv(true);
                                    bVar.aXX();
                                }
                                bVar2.t(bVar);
                            }
                            int aXS = bVar.aXS();
                            int threadNum = bVar.getThreadNum();
                            if (i >= bVar.aYi() * bVar.getThreadNum() && aXS >= threadNum) {
                                bVar2.s(bVar);
                                bVar.hu(true);
                            }
                        }
                    } else if (next instanceof j) {
                        if (this.mFid != 0 && ((j) next).getFid() == this.mFid && !next.ij()) {
                            this.dOH = false;
                            next.mF(1);
                            if (next.aYR() >= next.aYQ().aYi()) {
                                next.hv(true);
                                if (next.aYQ().aXW() >= next.aYQ().aYj()) {
                                    bVar2.c(next);
                                }
                            }
                        }
                    } else if ((next instanceof i) && !next.ij()) {
                        this.dOH = false;
                        next.mF(1);
                        if (next.aYR() >= next.aYQ().aYi()) {
                            next.hv(true);
                            bVar2.c(next);
                        }
                    }
                }
            }
        }
    }
}
