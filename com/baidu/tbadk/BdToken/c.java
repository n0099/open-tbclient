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
    private final ScheduledExecutorService dFg;
    private final SparseArray<List<com.baidu.tbadk.BdToken.b>> dFh;
    private final LinkedList<com.baidu.tbadk.BdToken.b> dFi;
    private a dFj;
    private AtomicBoolean dFk;
    private boolean dFl;
    private boolean dFm;
    private com.baidu.tbadk.BdToken.completeTask.d dFn;
    private com.baidu.tbadk.BdToken.activeConfig.b dFo;
    private int dFp;
    private long dFq;
    private long dFr;
    private int dFs;
    private long dFt;
    private CustomMessageListener dFu;
    private com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a> dFv;
    private com.baidu.tbadk.h.b dFw;
    private boolean isSchemaUp;
    private CustomMessageListener mBackgroundListener;
    private BdUniqueId mBdUniqueId;
    private CustomMessageListener mSyncFinishListener;

    public static final c aQc() {
        return g.dFA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g {
        private static final c dFA = new c();
    }

    private c() {
        this.dFg = Executors.newSingleThreadScheduledExecutor();
        this.dFh = new SparseArray<>();
        this.dFi = new LinkedList<>();
        this.dFj = new a();
        this.dFk = new AtomicBoolean(false);
        this.dFl = false;
        this.dFm = false;
        this.isSchemaUp = false;
        this.dFu = new CustomMessageListener(2921391) { // from class: com.baidu.tbadk.BdToken.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.dFl = true;
                if (!c.this.dFi.isEmpty()) {
                    Iterator it = c.this.dFi.iterator();
                    while (it.hasNext()) {
                        c.this.l((com.baidu.tbadk.BdToken.b) it.next());
                    }
                    c.this.dFi.clear();
                }
            }
        };
        this.mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.BdToken.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                    ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                    c.this.aQd();
                }
            }
        };
        this.mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tbadk.BdToken.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                    c.this.dFm = true;
                    c.this.aQd();
                }
            }
        };
        this.dFv = new com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a>() { // from class: com.baidu.tbadk.BdToken.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: a */
            public void onSuccess(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null) {
                    c.this.aC(aVar.aRl());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: b */
            public void ak(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null && aVar.dHy != null && aVar.dHy.mission != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b();
                    bVar.a(aVar.dHy.mission);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(bVar);
                    c.this.aC(arrayList);
                }
            }

            @Override // com.baidu.tbadk.h.a
            public void onError(int i, String str) {
            }
        };
        this.dFw = new com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b>() { // from class: com.baidu.tbadk.BdToken.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.b
            /* renamed from: m */
            public void onProgressUpdate(com.baidu.tbadk.BdToken.b bVar) {
                if (bVar != null) {
                    com.baidu.tbadk.BdToken.b e2 = c.this.e(bVar);
                    if (e2 != null && e2.dFe) {
                        e2.reset();
                        c.this.j(e2);
                        return;
                    }
                    n.aQD().o(e2);
                    if (e2 != null && e2.getTaskType() == 7) {
                        e2.aPI();
                        int aQa = e2.aQa();
                        int tag = e2.getTag();
                        if (aQa <= 1 || aQa <= tag) {
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
        this.dFn = new com.baidu.tbadk.BdToken.completeTask.d(this.mBdUniqueId);
        this.dFn.a(this.dFw);
        this.dFo = new com.baidu.tbadk.BdToken.activeConfig.b(this.mBdUniqueId);
        this.dFo.a(this.dFv);
        this.mSyncFinishListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        this.mBackgroundListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mBackgroundListener);
        this.dFu.setPriority(Integer.MIN_VALUE);
        this.dFu.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.dFu);
        com.baidu.tbadk.core.f.a.aZM().init();
        p.aQG().i(this.mBdUniqueId);
        startTimer();
        if (isMainProcess()) {
            new f().execute(new Void[0]);
        }
    }

    private boolean isMainProcess() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public void aQd() {
        if (this.dFo != null && isMainProcess() && this.dFm && !aQh()) {
            this.dFo.c(aQf(), aQg(), 0);
        }
    }

    public boolean aQe() {
        if (this.dFo != null && isMainProcess()) {
            this.dFo.c(aQf(), aQg(), 1);
            return true;
        }
        return false;
    }

    public boolean aQf() {
        return !aQi();
    }

    public boolean aQg() {
        return this.isSchemaUp;
    }

    public void setSchemaUp(boolean z) {
        this.isSchemaUp = z;
    }

    public boolean aQh() {
        return UtilHelper.isSameDay(aQk(), System.currentTimeMillis());
    }

    public boolean aQi() {
        return UtilHelper.isSameDay(com.baidu.tbadk.core.sharedPref.b.aZP().getLong("pref_key_last_active_config", 0L), System.currentTimeMillis());
    }

    public boolean aQj() {
        return UtilHelper.isSameDay(com.baidu.tbadk.core.sharedPref.b.aZP().getLong("pref_key_last_popup_time", 0L), System.currentTimeMillis());
    }

    private long aQk() {
        this.dFt = com.baidu.tbadk.core.sharedPref.b.aZP().getLong("pref_key_active_config_info", 0L);
        return this.dFt;
    }

    public int aQl() {
        return this.dFs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.BdToken.b e(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.dFh.size()) {
                return null;
            }
            List<com.baidu.tbadk.BdToken.b> valueAt = this.dFh.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar2 : valueAt) {
                    if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.aPM() == bVar.aPM()) {
                        return bVar2;
                    }
                }
                continue;
            }
            i = i2 + 1;
        }
    }

    public void aQm() {
        this.dFk.compareAndSet(true, false);
        this.dFj.ky(0);
        this.dFj.setTid(0L);
        this.dFj.setFid(0L);
        if (this.dFn != null) {
            this.dFn.aRp();
        }
    }

    public void n(int i, long j) {
        if (isMainProcess()) {
            this.dFs = i;
            this.dFr = j;
            if (this.dFq > 0 && this.dFp > 0 && (j == 0 || j != this.dFq)) {
                o(this.dFp, this.dFq);
                this.dFq = 0L;
                this.dFp = 0;
            }
            aQn();
        }
    }

    public void o(int i, long j) {
        k kVar;
        com.baidu.tbadk.BdToken.b aQA;
        List<com.baidu.tbadk.BdToken.b> list = this.dFh.get(i);
        if (list != null && !list.isEmpty()) {
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 7) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aPB().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof k) && (aQA = (kVar = (k) next).aQA()) != null && kVar.getTid() == j && aQA.getActivityId() == bVar.getActivityId() && aQA.aPM() == bVar.aPM()) {
                                next.gZ(true);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void p(int i, long j) {
        if (isMainProcess() && i != 0 && j != 0 && this.dFl) {
            this.dFp = i;
            List<com.baidu.tbadk.BdToken.b> list = this.dFh.get(i);
            if (list != null && !list.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 1) {
                        a(bVar, j);
                    } else if (bVar.getTaskType() != 7) {
                        continue;
                    } else if (bVar.ch(j)) {
                        break;
                    } else {
                        b(bVar, j);
                    }
                }
                this.dFj.ky(i);
                this.dFj.setTid(j);
                this.dFq = j;
                this.dFk.compareAndSet(false, true);
                synchronized (this.dFk) {
                    this.dFk.notify();
                }
            }
        }
    }

    private void a(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        m mVar;
        com.baidu.tbadk.BdToken.b aQA;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aPB().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof m) && (aQA = (mVar = (m) next).aQA()) != null && mVar.getTid() == j && aQA.getActivityId() == bVar.getActivityId() && aQA.aPM() == bVar.aPM()) {
                z = true;
                break;
            }
        }
        if (!z) {
            m mVar2 = new m(bVar, j);
            mVar2.cm(0L);
            mVar2.gZ(false);
            mVar2.kw(bVar.getTag());
            bVar.a(mVar2);
        }
    }

    private void b(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        k kVar;
        com.baidu.tbadk.BdToken.b aQA;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aPB().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof k) && (aQA = (kVar = (k) next).aQA()) != null && kVar.getTid() == j && aQA.getActivityId() == bVar.getActivityId() && aQA.aPM() == bVar.aPM()) {
                z = true;
                break;
            }
        }
        if (!z) {
            k kVar2 = new k(bVar, j);
            kVar2.cm(0L);
            kVar2.gZ(false);
            kVar2.kw(bVar.getTag());
            bVar.a(kVar2);
        }
    }

    public void q(int i, long j) {
        boolean z;
        if (isMainProcess() && i != 0 && j != 0 && this.dFl) {
            this.dFp = i;
            List<com.baidu.tbadk.BdToken.b> list = this.dFh.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 2) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aPB().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof j) && next.aQA().getActivityId() == bVar.getActivityId() && next.aQA().aPM() == bVar.aPM() && ((j) next).getFid() == j) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            j jVar = new j(bVar, j);
                            jVar.cm(0L);
                            jVar.gZ(false);
                            jVar.kw(bVar.getTag());
                            bVar.a(jVar);
                        }
                        z2 = z;
                    }
                }
                this.dFj.ky(i);
                this.dFj.setFid(j);
                this.dFk.compareAndSet(false, true);
                synchronized (this.dFk) {
                    this.dFk.notify();
                }
            }
        }
    }

    public void kx(int i) {
        boolean z;
        if (isMainProcess() && i != 0 && this.dFl) {
            this.dFp = i;
            List<com.baidu.tbadk.BdToken.b> list = this.dFh.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 4) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aPB().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof i) && next.aQA().getActivityId() == bVar.getActivityId() && next.aQA().aPM() == bVar.aPM()) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            i iVar = new i(bVar);
                            iVar.cm(0L);
                            iVar.gZ(false);
                            bVar.a(iVar);
                        }
                        z2 = z;
                    }
                }
                this.dFj.ky(i);
                this.dFk.compareAndSet(false, true);
                synchronized (this.dFk) {
                    this.dFk.notify();
                }
            }
        }
    }

    public void aQn() {
        int i;
        List<com.baidu.tbadk.BdToken.b> list;
        boolean z;
        if (isMainProcess() && this.dFl && (list = this.dFh.get((i = com.baidu.tbadk.BdToken.b.dEw))) != null && !list.isEmpty()) {
            boolean z2 = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 8) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aPB().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = z2;
                            break;
                        }
                        com.baidu.tbadk.BdToken.h next = it.next();
                        com.baidu.tbadk.BdToken.b aQA = next.aQA();
                        if (aQA != null && (next instanceof l) && aQA.getActivityId() == bVar.getActivityId() && aQA.aPM() == bVar.aPM()) {
                            ((l) next).aQC();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        l lVar = new l(bVar);
                        lVar.cm(0L);
                        lVar.gZ(false);
                        bVar.a(lVar);
                    }
                    z2 = z;
                }
            }
            this.dFj.ky(i);
            this.dFk.compareAndSet(false, true);
            synchronized (this.dFk) {
                this.dFk.notify();
            }
        }
    }

    private void startTimer() {
        this.dFg.scheduleWithFixedDelay(this.dFj, 0L, 1L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tbadk.BdToken.b bVar) {
        int[] aPR;
        for (int i : bVar.aPR()) {
            List<com.baidu.tbadk.BdToken.b> list = this.dFh.get(i);
            if (list == null) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(bVar);
                this.dFh.put(i, linkedList);
            } else {
                list.add(bVar);
            }
        }
    }

    private boolean g(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return false;
        }
        int[] aPR = bVar.aPR();
        if (aPR == null) {
            return true;
        }
        for (int i : aPR) {
            List<com.baidu.tbadk.BdToken.b> list = this.dFh.get(i);
            if (list == null) {
                return false;
            }
            for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.aPM() == bVar.aPM()) {
                    if (bVar2.aPJ()) {
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
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aPB().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.aQA() != null) {
                    com.baidu.tbadk.BdToken.b aQA = next.aQA();
                    if (aQA.getActivityId() == bVar.getActivityId() && aQA.aPM() == bVar.aPM()) {
                        if (taskType == 7 && (next instanceof k)) {
                            ((k) next).gZ(true);
                        } else if (taskType == 1 && (next instanceof m)) {
                            ((m) next).gZ(true);
                        }
                    }
                }
            }
            bVar.gY(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar != null) {
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aPB().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.aQA() != null) {
                    com.baidu.tbadk.BdToken.b aQA = next.aQA();
                    if (aQA.getActivityId() == bVar.getActivityId() && aQA.aPM() == bVar.aPM()) {
                        it.remove();
                    }
                }
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.dFh.size()) {
                    List<com.baidu.tbadk.BdToken.b> valueAt = this.dFh.valueAt(i2);
                    if (valueAt != null && !valueAt.isEmpty()) {
                        Iterator<com.baidu.tbadk.BdToken.b> it2 = valueAt.iterator();
                        while (it2.hasNext()) {
                            com.baidu.tbadk.BdToken.b next2 = it2.next();
                            if (next2 != null && next2.getActivityId() == bVar.getActivityId() && next2.aPM() == bVar.aPM()) {
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
                p.aQG().q(bVar);
            } else if (!this.dFl) {
                this.dFi.add(bVar);
            } else if (!g(bVar)) {
                f(bVar);
                new b().execute(bVar);
            }
        }
    }

    public void aC(List<com.baidu.tbadk.BdToken.b> list) {
        if (!com.baidu.tbadk.core.util.x.isEmpty(list)) {
            if (!this.dFl) {
                this.dFi.addAll(list);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar != null) {
                    if (bVar.getTaskType() == 9) {
                        p.aQG().q(bVar);
                    } else if (!g(bVar)) {
                        f(bVar);
                        arrayList.add(bVar);
                    }
                }
            }
            new C0486c().execute(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.BdToken.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0486c extends BdAsyncTask<List<com.baidu.tbadk.BdToken.b>, Integer, Void> {
        private C0486c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(List<com.baidu.tbadk.BdToken.b>... listArr) {
            if (listArr != null && listArr.length > 0 && listArr[0] != null) {
                com.baidu.tbadk.BdToken.a.aPy().aC(listArr[0]);
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
            linkedList.addAll(com.baidu.tbadk.BdToken.a.aPy().aPz());
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next != null && next.aPJ()) {
                    com.baidu.tbadk.BdToken.a.aPy().c(next);
                    it.remove();
                } else if (next.getTaskType() == 7) {
                    next.aPD();
                    com.baidu.tbadk.BdToken.a.aPy().b(next);
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
                        if (next.aPR() != null) {
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
                com.baidu.tbadk.BdToken.a.aPy().a(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.aPy().c(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.aPy().c(bVar2);
            }
            if (bVar != null) {
                com.baidu.tbadk.BdToken.a.aPy().a(bVar);
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
            com.baidu.tbadk.BdToken.a.aPy().b(bVar);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(com.baidu.tbadk.BdToken.b bVar) {
            if (bVar != null && bVar.dFe) {
                bVar.dFe = false;
                c.this.p(c.this.dFp, c.this.dFq);
            }
        }
    }

    public void aQo() {
        List<com.baidu.tbadk.BdToken.b> list = this.dFh.get(com.baidu.tbadk.BdToken.b.dEw);
        if (!com.baidu.tbadk.core.util.x.isEmpty(list)) {
            boolean z = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aPB().iterator();
                boolean z2 = z;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof l) {
                        l lVar = (l) next;
                        if (!next.gJ()) {
                            lVar.aQC();
                            z2 = true;
                        }
                    }
                }
                z = z2;
            }
            if (z && !this.dFk.get()) {
                this.dFj.ky(com.baidu.tbadk.BdToken.b.dEw);
                this.dFk.compareAndSet(false, true);
                synchronized (this.dFk) {
                    this.dFk.notify();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private volatile long dEQ;
        private volatile int dFy;
        private volatile boolean dFz;
        private volatile long mFid;

        private a() {
            this.dFz = false;
        }

        public synchronized void ky(int i) {
            this.dFy = i;
        }

        public synchronized void setTid(long j) {
            this.dEQ = j;
        }

        public synchronized void setFid(long j) {
            this.mFid = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.dFy == 0 || !c.this.dFk.get()) {
                synchronized (c.this.dFk) {
                    try {
                        c.this.dFk.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            aQp();
        }

        private void aQp() {
            this.dFz = true;
            List<com.baidu.tbadk.BdToken.b> list = (List) c.this.dFh.get(com.baidu.tbadk.BdToken.b.dEw);
            List<com.baidu.tbadk.BdToken.b> list2 = (List) c.this.dFh.get(this.dFy);
            if (com.baidu.tbadk.core.util.x.isEmpty(list) && com.baidu.tbadk.core.util.x.isEmpty(list2)) {
                c.this.dFk.compareAndSet(true, false);
                return;
            }
            d.b bVar = new d.b();
            bVar.dHU = new LinkedList();
            bVar.dHV = new LinkedList();
            bVar.dHW = new LinkedList();
            a(list, bVar);
            b(list2, bVar);
            if (this.dFz) {
                c.this.dFk.compareAndSet(true, false);
            }
            if (!com.baidu.tbadk.core.util.x.isEmpty(bVar.dHW)) {
                com.baidu.tbadk.BdToken.a.aPy().aD(bVar.dHW);
            }
            if (!com.baidu.tbadk.core.util.x.isEmpty(bVar.dHU) || !com.baidu.tbadk.core.util.x.isEmpty(bVar.dHV)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921379, bVar));
            }
        }

        private void a(List<com.baidu.tbadk.BdToken.b> list, d.b bVar) {
            if (!com.baidu.tbadk.core.util.x.isEmpty(list)) {
                for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                    a(bVar2, bVar);
                }
            }
        }

        private void b(List<com.baidu.tbadk.BdToken.b> list, d.b bVar) {
            if (!com.baidu.tbadk.core.util.x.isEmpty(list)) {
                for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                    b(bVar2, bVar);
                }
            }
        }

        private void a(com.baidu.tbadk.BdToken.b bVar, d.b bVar2) {
            ArrayList<com.baidu.tbadk.BdToken.h> aPB;
            if (bVar != null && bVar2 != null && (aPB = bVar.aPB()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = aPB.iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if ((next instanceof l) && !((l) next).isTimeout() && !next.gJ()) {
                        this.dFz = false;
                        next.kz(1);
                        if (next.aQB() >= next.aQA().aPS()) {
                            next.gZ(true);
                            bVar2.s(bVar);
                        }
                        bVar2.t(bVar);
                    }
                }
            }
        }

        private void b(com.baidu.tbadk.BdToken.b bVar, d.b bVar2) {
            ArrayList<com.baidu.tbadk.BdToken.h> aPB;
            if (bVar != null && bVar2 != null && (aPB = bVar.aPB()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = aPB.iterator();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof m) {
                        m mVar = (m) next;
                        if (this.dEQ != 0 && mVar.getTid() == this.dEQ && !next.gJ()) {
                            this.dFz = false;
                            next.kz(1);
                            if (next.aQB() >= next.aQA().aPS()) {
                                next.gZ(true);
                                if (next.aQA().aPH() >= next.aQA().getThreadNum()) {
                                    bVar2.c(next);
                                }
                            }
                            bVar2.t(bVar);
                        }
                    } else if (next instanceof k) {
                        k kVar = (k) next;
                        if (!bVar.aQb() && kVar.getTag() == bVar.getTag()) {
                            if (this.dEQ != 0 && kVar.getTid() == this.dEQ && !next.gJ()) {
                                this.dFz = false;
                                next.kz(1);
                            }
                            i = (int) (i + next.aQB());
                            if (this.dEQ != 0 && kVar.getTid() == this.dEQ && !next.gJ()) {
                                if (next.aQB() >= bVar.aPS()) {
                                    next.gZ(true);
                                    bVar.aPH();
                                }
                                bVar2.t(bVar);
                            }
                            int aPC = bVar.aPC();
                            int threadNum = bVar.getThreadNum();
                            if (i >= bVar.aPS() * bVar.getThreadNum() && aPC >= threadNum) {
                                bVar2.s(bVar);
                                bVar.gY(true);
                            }
                        }
                    } else if (next instanceof j) {
                        if (this.mFid != 0 && ((j) next).getFid() == this.mFid && !next.gJ()) {
                            this.dFz = false;
                            next.kz(1);
                            if (next.aQB() >= next.aQA().aPS()) {
                                next.gZ(true);
                                if (next.aQA().aPG() >= next.aQA().aPT()) {
                                    bVar2.c(next);
                                }
                            }
                        }
                    } else if ((next instanceof i) && !next.gJ()) {
                        this.dFz = false;
                        next.kz(1);
                        if (next.aQB() >= next.aQA().aPS()) {
                            next.gZ(true);
                            bVar2.c(next);
                        }
                    }
                }
            }
        }
    }
}
