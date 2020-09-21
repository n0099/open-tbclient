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
/* loaded from: classes.dex */
public class c {
    private boolean dQA;
    private boolean dQB;
    private com.baidu.tbadk.BdToken.completeTask.d dQC;
    private com.baidu.tbadk.BdToken.activeConfig.b dQD;
    private com.baidu.tbadk.BdToken.backUser.b dQE;
    private int dQF;
    private long dQG;
    private long dQH;
    private int dQI;
    private long dQJ;
    private CustomMessageListener dQK;
    private com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a> dQL;
    private com.baidu.tbadk.h.b dQM;
    private final ScheduledExecutorService dQv;
    private final SparseArray<List<com.baidu.tbadk.BdToken.b>> dQw;
    private final LinkedList<com.baidu.tbadk.BdToken.b> dQx;
    private a dQy;
    private AtomicBoolean dQz;
    private boolean isSchemaUp;
    private CustomMessageListener mBackgroundListener;
    private BdUniqueId mBdUniqueId;
    private CustomMessageListener mSyncFinishListener;

    public static final c aZe() {
        return g.dQQ;
    }

    /* loaded from: classes.dex */
    private static class g {
        private static final c dQQ = new c();
    }

    private c() {
        this.dQv = Executors.newSingleThreadScheduledExecutor();
        this.dQw = new SparseArray<>();
        this.dQx = new LinkedList<>();
        this.dQy = new a();
        this.dQz = new AtomicBoolean(false);
        this.dQA = false;
        this.dQB = false;
        this.isSchemaUp = false;
        this.dQK = new CustomMessageListener(2921391) { // from class: com.baidu.tbadk.BdToken.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.dQA = true;
                if (!c.this.dQx.isEmpty()) {
                    Iterator it = c.this.dQx.iterator();
                    while (it.hasNext()) {
                        c.this.l((com.baidu.tbadk.BdToken.b) it.next());
                    }
                    c.this.dQx.clear();
                }
            }
        };
        this.mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.BdToken.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                    ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                    c.this.aZg();
                }
            }
        };
        this.mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tbadk.BdToken.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                    c.this.dQB = true;
                    c.this.aZg();
                }
            }
        };
        this.dQL = new com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a>() { // from class: com.baidu.tbadk.BdToken.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: a */
            public void onSuccess(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null) {
                    c.this.aG(aVar.bao());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: b */
            public void an(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null && aVar.dSQ != null && aVar.dSQ.mission != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b();
                    bVar.a(aVar.dSQ.mission);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(bVar);
                    c.this.aG(arrayList);
                }
            }

            @Override // com.baidu.tbadk.h.a
            public void onError(int i, String str) {
            }
        };
        this.dQM = new com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b>() { // from class: com.baidu.tbadk.BdToken.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.b
            /* renamed from: m */
            public void onProgressUpdate(com.baidu.tbadk.BdToken.b bVar) {
                if (bVar != null) {
                    com.baidu.tbadk.BdToken.b e2 = c.this.e(bVar);
                    if (e2 != null && e2.dQt) {
                        e2.reset();
                        c.this.j(e2);
                        return;
                    }
                    n.aZG().o(e2);
                    if (e2 != null && e2.getTaskType() == 7) {
                        e2.aYK();
                        int aZc = e2.aZc();
                        int tag = e2.getTag();
                        if (aZc <= 1 || aZc <= tag) {
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
        this.dQC = new com.baidu.tbadk.BdToken.completeTask.d(this.mBdUniqueId);
        this.dQC.a(this.dQM);
        this.dQD = new com.baidu.tbadk.BdToken.activeConfig.b(this.mBdUniqueId);
        this.dQD.a(this.dQL);
        this.dQE = new com.baidu.tbadk.BdToken.backUser.b(this.mBdUniqueId);
        this.mSyncFinishListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        this.mBackgroundListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mBackgroundListener);
        this.dQK.setPriority(Integer.MIN_VALUE);
        this.dQK.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.dQK);
        com.baidu.tbadk.core.f.a.bjb().init();
        p.aZJ().i(this.mBdUniqueId);
        startTimer();
        if (isMainProcess()) {
            new f().execute(new Void[0]);
        }
    }

    private boolean isMainProcess() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public void aZf() {
        if (this.dQE != null && isMainProcess()) {
            this.dQE.bas();
        }
    }

    public void aZg() {
        if (this.dQD != null && isMainProcess() && this.dQB && !aZk()) {
            this.dQD.c(aZi(), aZj(), 0);
        }
    }

    public boolean aZh() {
        if (this.dQD != null && isMainProcess()) {
            this.dQD.c(aZi(), aZj(), 1);
            return true;
        }
        return false;
    }

    public boolean aZi() {
        return !aZl();
    }

    public boolean aZj() {
        return this.isSchemaUp;
    }

    public void setSchemaUp(boolean z) {
        this.isSchemaUp = z;
    }

    public boolean aZk() {
        return UtilHelper.isSameDay(aZn(), System.currentTimeMillis());
    }

    public boolean aZl() {
        return UtilHelper.isSameDay(com.baidu.tbadk.core.sharedPref.b.bjf().getLong("pref_key_last_active_config", 0L), System.currentTimeMillis());
    }

    public boolean aZm() {
        return UtilHelper.isSameDay(com.baidu.tbadk.core.sharedPref.b.bjf().getLong("pref_key_last_popup_time", 0L), System.currentTimeMillis());
    }

    private long aZn() {
        this.dQJ = com.baidu.tbadk.core.sharedPref.b.bjf().getLong("pref_key_active_config_info", 0L);
        return this.dQJ;
    }

    public int aZo() {
        return this.dQI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.BdToken.b e(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.dQw.size()) {
                return null;
            }
            List<com.baidu.tbadk.BdToken.b> valueAt = this.dQw.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar2 : valueAt) {
                    if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.aYO() == bVar.aYO()) {
                        return bVar2;
                    }
                }
                continue;
            }
            i = i2 + 1;
        }
    }

    public void aZp() {
        this.dQz.compareAndSet(true, false);
        this.dQy.mP(0);
        this.dQy.setTid(0L);
        this.dQy.setFid(0L);
        if (this.dQC != null) {
            this.dQC.bav();
        }
    }

    public void n(int i, long j) {
        if (isMainProcess()) {
            this.dQI = i;
            this.dQH = j;
            if (this.dQG > 0 && this.dQF > 0 && (j == 0 || j != this.dQG)) {
                o(this.dQF, this.dQG);
                this.dQG = 0L;
                this.dQF = 0;
            }
            aZq();
        }
    }

    public void o(int i, long j) {
        k kVar;
        com.baidu.tbadk.BdToken.b aZD;
        List<com.baidu.tbadk.BdToken.b> list = this.dQw.get(i);
        if (list != null && !list.isEmpty()) {
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 7) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aYD().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof k) && (aZD = (kVar = (k) next).aZD()) != null && kVar.getTid() == j && aZD.getActivityId() == bVar.getActivityId() && aZD.aYO() == bVar.aYO()) {
                                next.ht(true);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void p(int i, long j) {
        if (isMainProcess() && i != 0 && j != 0 && this.dQA) {
            this.dQF = i;
            List<com.baidu.tbadk.BdToken.b> list = this.dQw.get(i);
            if (list != null && !list.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 1) {
                        a(bVar, j);
                    } else if (bVar.getTaskType() != 7) {
                        continue;
                    } else if (bVar.cs(j)) {
                        break;
                    } else {
                        b(bVar, j);
                    }
                }
                this.dQy.mP(i);
                this.dQy.setTid(j);
                this.dQG = j;
                this.dQz.compareAndSet(false, true);
                synchronized (this.dQz) {
                    this.dQz.notify();
                }
            }
        }
    }

    private void a(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        m mVar;
        com.baidu.tbadk.BdToken.b aZD;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aYD().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof m) && (aZD = (mVar = (m) next).aZD()) != null && mVar.getTid() == j && aZD.getActivityId() == bVar.getActivityId() && aZD.aYO() == bVar.aYO()) {
                z = true;
                break;
            }
        }
        if (!z) {
            m mVar2 = new m(bVar, j);
            mVar2.cx(0L);
            mVar2.ht(false);
            mVar2.mN(bVar.getTag());
            bVar.a(mVar2);
        }
    }

    private void b(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        k kVar;
        com.baidu.tbadk.BdToken.b aZD;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aYD().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof k) && (aZD = (kVar = (k) next).aZD()) != null && kVar.getTid() == j && aZD.getActivityId() == bVar.getActivityId() && aZD.aYO() == bVar.aYO()) {
                z = true;
                break;
            }
        }
        if (!z) {
            k kVar2 = new k(bVar, j);
            kVar2.cx(0L);
            kVar2.ht(false);
            kVar2.mN(bVar.getTag());
            bVar.a(kVar2);
        }
    }

    public void q(int i, long j) {
        boolean z;
        if (isMainProcess() && i != 0 && j != 0 && this.dQA) {
            this.dQF = i;
            List<com.baidu.tbadk.BdToken.b> list = this.dQw.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 2) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aYD().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof j) && next.aZD().getActivityId() == bVar.getActivityId() && next.aZD().aYO() == bVar.aYO() && ((j) next).getFid() == j) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            j jVar = new j(bVar, j);
                            jVar.cx(0L);
                            jVar.ht(false);
                            jVar.mN(bVar.getTag());
                            bVar.a(jVar);
                        }
                        z2 = z;
                    }
                }
                this.dQy.mP(i);
                this.dQy.setFid(j);
                this.dQz.compareAndSet(false, true);
                synchronized (this.dQz) {
                    this.dQz.notify();
                }
            }
        }
    }

    public void mO(int i) {
        boolean z;
        if (isMainProcess() && i != 0 && this.dQA) {
            this.dQF = i;
            List<com.baidu.tbadk.BdToken.b> list = this.dQw.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 4) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aYD().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof i) && next.aZD().getActivityId() == bVar.getActivityId() && next.aZD().aYO() == bVar.aYO()) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            i iVar = new i(bVar);
                            iVar.cx(0L);
                            iVar.ht(false);
                            bVar.a(iVar);
                        }
                        z2 = z;
                    }
                }
                this.dQy.mP(i);
                this.dQz.compareAndSet(false, true);
                synchronized (this.dQz) {
                    this.dQz.notify();
                }
            }
        }
    }

    public void aZq() {
        int i;
        List<com.baidu.tbadk.BdToken.b> list;
        boolean z;
        if (isMainProcess() && this.dQA && (list = this.dQw.get((i = com.baidu.tbadk.BdToken.b.dPL))) != null && !list.isEmpty()) {
            boolean z2 = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 8) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aYD().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = z2;
                            break;
                        }
                        com.baidu.tbadk.BdToken.h next = it.next();
                        com.baidu.tbadk.BdToken.b aZD = next.aZD();
                        if (aZD != null && (next instanceof l) && aZD.getActivityId() == bVar.getActivityId() && aZD.aYO() == bVar.aYO()) {
                            ((l) next).aZF();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        l lVar = new l(bVar);
                        lVar.cx(0L);
                        lVar.ht(false);
                        bVar.a(lVar);
                    }
                    z2 = z;
                }
            }
            this.dQy.mP(i);
            this.dQz.compareAndSet(false, true);
            synchronized (this.dQz) {
                this.dQz.notify();
            }
        }
    }

    private void startTimer() {
        this.dQv.scheduleWithFixedDelay(this.dQy, 0L, 1L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tbadk.BdToken.b bVar) {
        int[] aYT;
        for (int i : bVar.aYT()) {
            List<com.baidu.tbadk.BdToken.b> list = this.dQw.get(i);
            if (list == null) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(bVar);
                this.dQw.put(i, linkedList);
            } else {
                list.add(bVar);
            }
        }
    }

    private boolean g(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return false;
        }
        int[] aYT = bVar.aYT();
        if (aYT == null) {
            return true;
        }
        for (int i : aYT) {
            List<com.baidu.tbadk.BdToken.b> list = this.dQw.get(i);
            if (list == null) {
                return false;
            }
            for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.aYO() == bVar.aYO()) {
                    if (bVar2.aYL()) {
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
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aYD().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.aZD() != null) {
                    com.baidu.tbadk.BdToken.b aZD = next.aZD();
                    if (aZD.getActivityId() == bVar.getActivityId() && aZD.aYO() == bVar.aYO()) {
                        if (taskType == 7 && (next instanceof k)) {
                            ((k) next).ht(true);
                        } else if (taskType == 1 && (next instanceof m)) {
                            ((m) next).ht(true);
                        }
                    }
                }
            }
            bVar.hs(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar != null) {
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aYD().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.aZD() != null) {
                    com.baidu.tbadk.BdToken.b aZD = next.aZD();
                    if (aZD.getActivityId() == bVar.getActivityId() && aZD.aYO() == bVar.aYO()) {
                        it.remove();
                    }
                }
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.dQw.size()) {
                    List<com.baidu.tbadk.BdToken.b> valueAt = this.dQw.valueAt(i2);
                    if (valueAt != null && !valueAt.isEmpty()) {
                        Iterator<com.baidu.tbadk.BdToken.b> it2 = valueAt.iterator();
                        while (it2.hasNext()) {
                            com.baidu.tbadk.BdToken.b next2 = it2.next();
                            if (next2 != null && next2.getActivityId() == bVar.getActivityId() && next2.aYO() == bVar.aYO()) {
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
                p.aZJ().q(bVar);
            } else if (!this.dQA) {
                this.dQx.add(bVar);
            } else if (!g(bVar)) {
                f(bVar);
                new b().execute(bVar);
            }
        }
    }

    public void aG(List<com.baidu.tbadk.BdToken.b> list) {
        if (!y.isEmpty(list)) {
            if (!this.dQA) {
                this.dQx.addAll(list);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar != null) {
                    if (bVar.getTaskType() == 9) {
                        p.aZJ().q(bVar);
                    } else if (!g(bVar)) {
                        f(bVar);
                        arrayList.add(bVar);
                    }
                }
            }
            new C0527c().execute(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.BdToken.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0527c extends BdAsyncTask<List<com.baidu.tbadk.BdToken.b>, Integer, Void> {
        private C0527c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(List<com.baidu.tbadk.BdToken.b>... listArr) {
            if (listArr != null && listArr.length > 0 && listArr[0] != null) {
                com.baidu.tbadk.BdToken.a.aYA().aG(listArr[0]);
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
            linkedList.addAll(com.baidu.tbadk.BdToken.a.aYA().aYB());
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next != null && next.aYL()) {
                    com.baidu.tbadk.BdToken.a.aYA().c(next);
                    it.remove();
                } else if (next.getTaskType() == 7) {
                    next.aYF();
                    com.baidu.tbadk.BdToken.a.aYA().b(next);
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
                        if (next.aYT() != null) {
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
                com.baidu.tbadk.BdToken.a.aYA().a(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.aYA().c(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.aYA().c(bVar2);
            }
            if (bVar != null) {
                com.baidu.tbadk.BdToken.a.aYA().a(bVar);
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
            com.baidu.tbadk.BdToken.a.aYA().b(bVar);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(com.baidu.tbadk.BdToken.b bVar) {
            if (bVar != null && bVar.dQt) {
                bVar.dQt = false;
                c.this.p(c.this.dQF, c.this.dQG);
            }
        }
    }

    public void aZr() {
        List<com.baidu.tbadk.BdToken.b> list = this.dQw.get(com.baidu.tbadk.BdToken.b.dPL);
        if (!y.isEmpty(list)) {
            boolean z = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aYD().iterator();
                boolean z2 = z;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof l) {
                        l lVar = (l) next;
                        if (!next.ij()) {
                            lVar.aZF();
                            z2 = true;
                        }
                    }
                }
                z = z2;
            }
            if (z && !this.dQz.get()) {
                this.dQy.mP(com.baidu.tbadk.BdToken.b.dPL);
                this.dQz.compareAndSet(false, true);
                synchronized (this.dQz) {
                    this.dQz.notify();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private volatile int dQO;
        private volatile boolean dQP;
        private volatile long dQf;
        private volatile long mFid;

        private a() {
            this.dQP = false;
        }

        public synchronized void mP(int i) {
            this.dQO = i;
        }

        public synchronized void setTid(long j) {
            this.dQf = j;
        }

        public synchronized void setFid(long j) {
            this.mFid = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.dQO == 0 || !c.this.dQz.get()) {
                synchronized (c.this.dQz) {
                    try {
                        c.this.dQz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            aZs();
        }

        private void aZs() {
            this.dQP = true;
            List<com.baidu.tbadk.BdToken.b> list = (List) c.this.dQw.get(com.baidu.tbadk.BdToken.b.dPL);
            List<com.baidu.tbadk.BdToken.b> list2 = (List) c.this.dQw.get(this.dQO);
            if (y.isEmpty(list) && y.isEmpty(list2)) {
                c.this.dQz.compareAndSet(true, false);
                return;
            }
            d.b bVar = new d.b();
            bVar.dTp = new LinkedList();
            bVar.dTq = new LinkedList();
            bVar.dTr = new LinkedList();
            a(list, bVar);
            b(list2, bVar);
            if (this.dQP) {
                c.this.dQz.compareAndSet(true, false);
            }
            if (!y.isEmpty(bVar.dTr)) {
                com.baidu.tbadk.BdToken.a.aYA().aH(bVar.dTr);
            }
            if (!y.isEmpty(bVar.dTp) || !y.isEmpty(bVar.dTq)) {
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
            ArrayList<com.baidu.tbadk.BdToken.h> aYD;
            if (bVar != null && bVar2 != null && (aYD = bVar.aYD()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = aYD.iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if ((next instanceof l) && !((l) next).isTimeout() && !next.ij()) {
                        this.dQP = false;
                        next.mQ(1);
                        if (next.aZE() >= next.aZD().aYU()) {
                            next.ht(true);
                            bVar2.s(bVar);
                        }
                        bVar2.t(bVar);
                    }
                }
            }
        }

        private void b(com.baidu.tbadk.BdToken.b bVar, d.b bVar2) {
            ArrayList<com.baidu.tbadk.BdToken.h> aYD;
            if (bVar != null && bVar2 != null && (aYD = bVar.aYD()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = aYD.iterator();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof m) {
                        m mVar = (m) next;
                        if (this.dQf != 0 && mVar.getTid() == this.dQf && !next.ij()) {
                            this.dQP = false;
                            next.mQ(1);
                            if (next.aZE() >= next.aZD().aYU()) {
                                next.ht(true);
                                if (next.aZD().aYJ() >= next.aZD().getThreadNum()) {
                                    bVar2.c(next);
                                }
                            }
                            bVar2.t(bVar);
                        }
                    } else if (next instanceof k) {
                        k kVar = (k) next;
                        if (!bVar.aZd() && kVar.getTag() == bVar.getTag()) {
                            if (this.dQf != 0 && kVar.getTid() == this.dQf && !next.ij()) {
                                this.dQP = false;
                                next.mQ(1);
                            }
                            i = (int) (i + next.aZE());
                            if (this.dQf != 0 && kVar.getTid() == this.dQf && !next.ij()) {
                                if (next.aZE() >= bVar.aYU()) {
                                    next.ht(true);
                                    bVar.aYJ();
                                }
                                bVar2.t(bVar);
                            }
                            int aYE = bVar.aYE();
                            int threadNum = bVar.getThreadNum();
                            if (i >= bVar.aYU() * bVar.getThreadNum() && aYE >= threadNum) {
                                bVar2.s(bVar);
                                bVar.hs(true);
                            }
                        }
                    } else if (next instanceof j) {
                        if (this.mFid != 0 && ((j) next).getFid() == this.mFid && !next.ij()) {
                            this.dQP = false;
                            next.mQ(1);
                            if (next.aZE() >= next.aZD().aYU()) {
                                next.ht(true);
                                if (next.aZD().aYI() >= next.aZD().aYV()) {
                                    bVar2.c(next);
                                }
                            }
                        }
                    } else if ((next instanceof i) && !next.ij()) {
                        this.dQP = false;
                        next.mQ(1);
                        if (next.aZE() >= next.aZD().aYU()) {
                            next.ht(true);
                            bVar2.c(next);
                        }
                    }
                }
            }
        }
    }
}
