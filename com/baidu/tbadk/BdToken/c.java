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
    private final ScheduledExecutorService epf;
    private final SparseArray<List<com.baidu.tbadk.BdToken.b>> epg;
    private final LinkedList<com.baidu.tbadk.BdToken.b> eph;
    private a epi;
    private AtomicBoolean epj;
    private boolean epk;
    private boolean epl;
    private com.baidu.tbadk.BdToken.completeTask.d epm;
    private com.baidu.tbadk.BdToken.activeConfig.b epn;
    private com.baidu.tbadk.BdToken.backUser.b epo;
    private int epp;
    private long epq;
    private long epr;
    private int eps;
    private long ept;
    private CustomMessageListener epu;
    private com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a> epv;
    private com.baidu.tbadk.h.b epw;
    private boolean isSchemaUp;
    private CustomMessageListener mBackgroundListener;
    private BdUniqueId mBdUniqueId;
    private CustomMessageListener mSyncFinishListener;

    public static final c bfy() {
        return g.epA;
    }

    /* loaded from: classes.dex */
    private static class g {
        private static final c epA = new c();
    }

    private c() {
        this.epf = Executors.newSingleThreadScheduledExecutor();
        this.epg = new SparseArray<>();
        this.eph = new LinkedList<>();
        this.epi = new a();
        this.epj = new AtomicBoolean(false);
        this.epk = false;
        this.epl = false;
        this.isSchemaUp = false;
        this.epu = new CustomMessageListener(2921391) { // from class: com.baidu.tbadk.BdToken.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.epk = true;
                if (!c.this.eph.isEmpty()) {
                    Iterator it = c.this.eph.iterator();
                    while (it.hasNext()) {
                        c.this.l((com.baidu.tbadk.BdToken.b) it.next());
                    }
                    c.this.eph.clear();
                }
            }
        };
        this.mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.BdToken.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                    ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                    c.this.bfA();
                }
            }
        };
        this.mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tbadk.BdToken.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                    c.this.epl = true;
                    c.this.bfA();
                }
            }
        };
        this.epv = new com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a>() { // from class: com.baidu.tbadk.BdToken.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: a */
            public void onSuccess(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null) {
                    c.this.ba(aVar.bgI());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: b */
            public void aq(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null && aVar.erD != null && aVar.erD.mission != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b();
                    bVar.a(aVar.erD.mission);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(bVar);
                    c.this.ba(arrayList);
                }
            }

            @Override // com.baidu.tbadk.h.a
            public void onError(int i, String str) {
            }
        };
        this.epw = new com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b>() { // from class: com.baidu.tbadk.BdToken.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.b
            /* renamed from: m */
            public void onProgressUpdate(com.baidu.tbadk.BdToken.b bVar) {
                if (bVar != null) {
                    com.baidu.tbadk.BdToken.b e2 = c.this.e(bVar);
                    if (e2 != null && e2.epd) {
                        e2.reset();
                        c.this.j(e2);
                        return;
                    }
                    n.bga().o(e2);
                    if (e2 != null && e2.getTaskType() == 7) {
                        e2.bfe();
                        int bfw = e2.bfw();
                        int tag = e2.getTag();
                        if (bfw <= 1 || bfw <= tag) {
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
        this.epm = new com.baidu.tbadk.BdToken.completeTask.d(this.mBdUniqueId);
        this.epm.a(this.epw);
        this.epn = new com.baidu.tbadk.BdToken.activeConfig.b(this.mBdUniqueId);
        this.epn.a(this.epv);
        this.epo = new com.baidu.tbadk.BdToken.backUser.b(this.mBdUniqueId);
        this.mSyncFinishListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        this.mBackgroundListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mBackgroundListener);
        this.epu.setPriority(Integer.MIN_VALUE);
        this.epu.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.epu);
        com.baidu.tbadk.core.f.a.bpq().init();
        p.bgd().i(this.mBdUniqueId);
        startTimer();
        if (isMainProcess()) {
            new f().execute(new Void[0]);
        }
    }

    private boolean isMainProcess() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public void bfz() {
        if (this.epo != null && isMainProcess()) {
            this.epo.bgM();
        }
    }

    public void bfA() {
        if (this.epn != null && isMainProcess() && this.epl && !bfE()) {
            this.epn.c(bfC(), bfD(), 0);
        }
    }

    public boolean bfB() {
        if (this.epn != null && isMainProcess()) {
            this.epn.c(bfC(), bfD(), 1);
            return true;
        }
        return false;
    }

    public boolean bfC() {
        return !bfF();
    }

    public boolean bfD() {
        return this.isSchemaUp;
    }

    public void setSchemaUp(boolean z) {
        this.isSchemaUp = z;
    }

    public boolean bfE() {
        return UtilHelper.isSameDay(bfH(), System.currentTimeMillis());
    }

    public boolean bfF() {
        return UtilHelper.isSameDay(com.baidu.tbadk.core.sharedPref.b.bpu().getLong("pref_key_last_active_config", 0L), System.currentTimeMillis());
    }

    public boolean bfG() {
        return UtilHelper.isSameDay(com.baidu.tbadk.core.sharedPref.b.bpu().getLong("pref_key_last_popup_time", 0L), System.currentTimeMillis());
    }

    private long bfH() {
        this.ept = com.baidu.tbadk.core.sharedPref.b.bpu().getLong("pref_key_active_config_info", 0L);
        return this.ept;
    }

    public int bfI() {
        return this.eps;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.BdToken.b e(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.epg.size()) {
                return null;
            }
            List<com.baidu.tbadk.BdToken.b> valueAt = this.epg.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar2 : valueAt) {
                    if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.bfi() == bVar.bfi()) {
                        return bVar2;
                    }
                }
                continue;
            }
            i = i2 + 1;
        }
    }

    public void bfJ() {
        this.epj.compareAndSet(true, false);
        this.epi.nD(0);
        this.epi.setTid(0L);
        this.epi.setFid(0L);
        if (this.epm != null) {
            this.epm.bgP();
        }
    }

    public void n(int i, long j) {
        if (isMainProcess()) {
            this.eps = i;
            this.epr = j;
            if (this.epq > 0 && this.epp > 0 && (j == 0 || j != this.epq)) {
                o(this.epp, this.epq);
                this.epq = 0L;
                this.epp = 0;
            }
            bfK();
        }
    }

    public void o(int i, long j) {
        k kVar;
        com.baidu.tbadk.BdToken.b bfX;
        List<com.baidu.tbadk.BdToken.b> list = this.epg.get(i);
        if (list != null && !list.isEmpty()) {
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 7) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.beX().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof k) && (bfX = (kVar = (k) next).bfX()) != null && kVar.getTid() == j && bfX.getActivityId() == bVar.getActivityId() && bfX.bfi() == bVar.bfi()) {
                                next.io(true);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void p(int i, long j) {
        if (isMainProcess() && i != 0 && j != 0 && this.epk) {
            this.epp = i;
            List<com.baidu.tbadk.BdToken.b> list = this.epg.get(i);
            if (list != null && !list.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 1) {
                        a(bVar, j);
                    } else if (bVar.getTaskType() != 7) {
                        continue;
                    } else if (bVar.cY(j)) {
                        break;
                    } else {
                        b(bVar, j);
                    }
                }
                this.epi.nD(i);
                this.epi.setTid(j);
                this.epq = j;
                this.epj.compareAndSet(false, true);
                synchronized (this.epj) {
                    this.epj.notify();
                }
            }
        }
    }

    private void a(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        m mVar;
        com.baidu.tbadk.BdToken.b bfX;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.beX().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof m) && (bfX = (mVar = (m) next).bfX()) != null && mVar.getTid() == j && bfX.getActivityId() == bVar.getActivityId() && bfX.bfi() == bVar.bfi()) {
                z = true;
                break;
            }
        }
        if (!z) {
            m mVar2 = new m(bVar, j);
            mVar2.dd(0L);
            mVar2.io(false);
            mVar2.nB(bVar.getTag());
            bVar.a(mVar2);
        }
    }

    private void b(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        k kVar;
        com.baidu.tbadk.BdToken.b bfX;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.beX().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof k) && (bfX = (kVar = (k) next).bfX()) != null && kVar.getTid() == j && bfX.getActivityId() == bVar.getActivityId() && bfX.bfi() == bVar.bfi()) {
                z = true;
                break;
            }
        }
        if (!z) {
            k kVar2 = new k(bVar, j);
            kVar2.dd(0L);
            kVar2.io(false);
            kVar2.nB(bVar.getTag());
            bVar.a(kVar2);
        }
    }

    public void q(int i, long j) {
        boolean z;
        if (isMainProcess() && i != 0 && j != 0 && this.epk) {
            this.epp = i;
            List<com.baidu.tbadk.BdToken.b> list = this.epg.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 2) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.beX().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof j) && next.bfX().getActivityId() == bVar.getActivityId() && next.bfX().bfi() == bVar.bfi() && ((j) next).getFid() == j) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            j jVar = new j(bVar, j);
                            jVar.dd(0L);
                            jVar.io(false);
                            jVar.nB(bVar.getTag());
                            bVar.a(jVar);
                        }
                        z2 = z;
                    }
                }
                this.epi.nD(i);
                this.epi.setFid(j);
                this.epj.compareAndSet(false, true);
                synchronized (this.epj) {
                    this.epj.notify();
                }
            }
        }
    }

    public void nC(int i) {
        boolean z;
        if (isMainProcess() && i != 0 && this.epk) {
            this.epp = i;
            List<com.baidu.tbadk.BdToken.b> list = this.epg.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 4) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.beX().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof i) && next.bfX().getActivityId() == bVar.getActivityId() && next.bfX().bfi() == bVar.bfi()) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            i iVar = new i(bVar);
                            iVar.dd(0L);
                            iVar.io(false);
                            bVar.a(iVar);
                        }
                        z2 = z;
                    }
                }
                this.epi.nD(i);
                this.epj.compareAndSet(false, true);
                synchronized (this.epj) {
                    this.epj.notify();
                }
            }
        }
    }

    public void bfK() {
        int i;
        List<com.baidu.tbadk.BdToken.b> list;
        boolean z;
        if (isMainProcess() && this.epk && (list = this.epg.get((i = com.baidu.tbadk.BdToken.b.eov))) != null && !list.isEmpty()) {
            boolean z2 = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 8) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.beX().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = z2;
                            break;
                        }
                        com.baidu.tbadk.BdToken.h next = it.next();
                        com.baidu.tbadk.BdToken.b bfX = next.bfX();
                        if (bfX != null && (next instanceof l) && bfX.getActivityId() == bVar.getActivityId() && bfX.bfi() == bVar.bfi()) {
                            ((l) next).bfZ();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        l lVar = new l(bVar);
                        lVar.dd(0L);
                        lVar.io(false);
                        bVar.a(lVar);
                    }
                    z2 = z;
                }
            }
            this.epi.nD(i);
            this.epj.compareAndSet(false, true);
            synchronized (this.epj) {
                this.epj.notify();
            }
        }
    }

    private void startTimer() {
        this.epf.scheduleWithFixedDelay(this.epi, 0L, 1L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tbadk.BdToken.b bVar) {
        int[] bfn;
        for (int i : bVar.bfn()) {
            List<com.baidu.tbadk.BdToken.b> list = this.epg.get(i);
            if (list == null) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(bVar);
                this.epg.put(i, linkedList);
            } else {
                list.add(bVar);
            }
        }
    }

    private boolean g(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return false;
        }
        int[] bfn = bVar.bfn();
        if (bfn == null) {
            return true;
        }
        for (int i : bfn) {
            List<com.baidu.tbadk.BdToken.b> list = this.epg.get(i);
            if (list == null) {
                return false;
            }
            for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.bfi() == bVar.bfi()) {
                    if (bVar2.bff()) {
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
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.beX().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.bfX() != null) {
                    com.baidu.tbadk.BdToken.b bfX = next.bfX();
                    if (bfX.getActivityId() == bVar.getActivityId() && bfX.bfi() == bVar.bfi()) {
                        if (taskType == 7 && (next instanceof k)) {
                            ((k) next).io(true);
                        } else if (taskType == 1 && (next instanceof m)) {
                            ((m) next).io(true);
                        }
                    }
                }
            }
            bVar.in(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar != null) {
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.beX().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.bfX() != null) {
                    com.baidu.tbadk.BdToken.b bfX = next.bfX();
                    if (bfX.getActivityId() == bVar.getActivityId() && bfX.bfi() == bVar.bfi()) {
                        it.remove();
                    }
                }
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.epg.size()) {
                    List<com.baidu.tbadk.BdToken.b> valueAt = this.epg.valueAt(i2);
                    if (valueAt != null && !valueAt.isEmpty()) {
                        Iterator<com.baidu.tbadk.BdToken.b> it2 = valueAt.iterator();
                        while (it2.hasNext()) {
                            com.baidu.tbadk.BdToken.b next2 = it2.next();
                            if (next2 != null && next2.getActivityId() == bVar.getActivityId() && next2.bfi() == bVar.bfi()) {
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
                p.bgd().q(bVar);
            } else if (!this.epk) {
                this.eph.add(bVar);
            } else if (!g(bVar)) {
                f(bVar);
                new b().execute(bVar);
            }
        }
    }

    public void ba(List<com.baidu.tbadk.BdToken.b> list) {
        if (!y.isEmpty(list)) {
            if (!this.epk) {
                this.eph.addAll(list);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar != null) {
                    if (bVar.getTaskType() == 9) {
                        p.bgd().q(bVar);
                    } else if (!g(bVar)) {
                        f(bVar);
                        arrayList.add(bVar);
                    }
                }
            }
            new C0568c().execute(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.BdToken.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0568c extends BdAsyncTask<List<com.baidu.tbadk.BdToken.b>, Integer, Void> {
        private C0568c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(List<com.baidu.tbadk.BdToken.b>... listArr) {
            if (listArr != null && listArr.length > 0 && listArr[0] != null) {
                com.baidu.tbadk.BdToken.a.beU().ba(listArr[0]);
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
        /* renamed from: e */
        public LinkedList<com.baidu.tbadk.BdToken.b> doInBackground(Void... voidArr) {
            LinkedList<com.baidu.tbadk.BdToken.b> linkedList = new LinkedList<>();
            linkedList.addAll(com.baidu.tbadk.BdToken.a.beU().beV());
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next != null && next.bff()) {
                    com.baidu.tbadk.BdToken.a.beU().c(next);
                    it.remove();
                } else if (next.getTaskType() == 7) {
                    next.beZ();
                    com.baidu.tbadk.BdToken.a.beU().b(next);
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
                        if (next.bfn() != null) {
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
                com.baidu.tbadk.BdToken.a.beU().a(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.beU().c(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.beU().c(bVar2);
            }
            if (bVar != null) {
                com.baidu.tbadk.BdToken.a.beU().a(bVar);
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
            com.baidu.tbadk.BdToken.a.beU().b(bVar);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(com.baidu.tbadk.BdToken.b bVar) {
            if (bVar != null && bVar.epd) {
                bVar.epd = false;
                c.this.p(c.this.epp, c.this.epq);
            }
        }
    }

    public void bfL() {
        List<com.baidu.tbadk.BdToken.b> list = this.epg.get(com.baidu.tbadk.BdToken.b.eov);
        if (!y.isEmpty(list)) {
            boolean z = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bVar.beX().iterator();
                boolean z2 = z;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof l) {
                        l lVar = (l) next;
                        if (!next.ik()) {
                            lVar.bfZ();
                            z2 = true;
                        }
                    }
                }
                z = z2;
            }
            if (z && !this.epj.get()) {
                this.epi.nD(com.baidu.tbadk.BdToken.b.eov);
                this.epj.compareAndSet(false, true);
                synchronized (this.epj) {
                    this.epj.notify();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private volatile long eoP;
        private volatile int epy;
        private volatile boolean epz;
        private volatile long mFid;

        private a() {
            this.epz = false;
        }

        public synchronized void nD(int i) {
            this.epy = i;
        }

        public synchronized void setTid(long j) {
            this.eoP = j;
        }

        public synchronized void setFid(long j) {
            this.mFid = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.epy == 0 || !c.this.epj.get()) {
                synchronized (c.this.epj) {
                    try {
                        c.this.epj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            bfM();
        }

        private void bfM() {
            this.epz = true;
            List<com.baidu.tbadk.BdToken.b> list = (List) c.this.epg.get(com.baidu.tbadk.BdToken.b.eov);
            List<com.baidu.tbadk.BdToken.b> list2 = (List) c.this.epg.get(this.epy);
            if (y.isEmpty(list) && y.isEmpty(list2)) {
                c.this.epj.compareAndSet(true, false);
                return;
            }
            d.b bVar = new d.b();
            bVar.esc = new LinkedList();
            bVar.esd = new LinkedList();
            bVar.ese = new LinkedList();
            a(list, bVar);
            b(list2, bVar);
            if (this.epz) {
                c.this.epj.compareAndSet(true, false);
            }
            if (!y.isEmpty(bVar.ese)) {
                com.baidu.tbadk.BdToken.a.beU().bb(bVar.ese);
            }
            if (!y.isEmpty(bVar.esc) || !y.isEmpty(bVar.esd)) {
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
            ArrayList<com.baidu.tbadk.BdToken.h> beX;
            if (bVar != null && bVar2 != null && (beX = bVar.beX()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = beX.iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if ((next instanceof l) && !((l) next).isTimeout() && !next.ik()) {
                        this.epz = false;
                        next.nE(1);
                        if (next.bfY() >= next.bfX().bfo()) {
                            next.io(true);
                            bVar2.s(bVar);
                        }
                        bVar2.t(bVar);
                    }
                }
            }
        }

        private void b(com.baidu.tbadk.BdToken.b bVar, d.b bVar2) {
            ArrayList<com.baidu.tbadk.BdToken.h> beX;
            if (bVar != null && bVar2 != null && (beX = bVar.beX()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = beX.iterator();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof m) {
                        m mVar = (m) next;
                        if (this.eoP != 0 && mVar.getTid() == this.eoP && !next.ik()) {
                            this.epz = false;
                            next.nE(1);
                            if (next.bfY() >= next.bfX().bfo()) {
                                next.io(true);
                                if (next.bfX().bfd() >= next.bfX().getThreadNum()) {
                                    bVar2.c(next);
                                }
                            }
                            bVar2.t(bVar);
                        }
                    } else if (next instanceof k) {
                        k kVar = (k) next;
                        if (!bVar.bfx() && kVar.getTag() == bVar.getTag()) {
                            if (this.eoP != 0 && kVar.getTid() == this.eoP && !next.ik()) {
                                this.epz = false;
                                next.nE(1);
                            }
                            i = (int) (i + next.bfY());
                            if (this.eoP != 0 && kVar.getTid() == this.eoP && !next.ik()) {
                                if (next.bfY() >= bVar.bfo()) {
                                    next.io(true);
                                    bVar.bfd();
                                }
                                bVar2.t(bVar);
                            }
                            int beY = bVar.beY();
                            int threadNum = bVar.getThreadNum();
                            if (i >= bVar.bfo() * bVar.getThreadNum() && beY >= threadNum) {
                                bVar2.s(bVar);
                                bVar.in(true);
                            }
                        }
                    } else if (next instanceof j) {
                        if (this.mFid != 0 && ((j) next).getFid() == this.mFid && !next.ik()) {
                            this.epz = false;
                            next.nE(1);
                            if (next.bfY() >= next.bfX().bfo()) {
                                next.io(true);
                                if (next.bfX().bfc() >= next.bfX().bfp()) {
                                    bVar2.c(next);
                                }
                            }
                        }
                    } else if ((next instanceof i) && !next.ik()) {
                        this.epz = false;
                        next.nE(1);
                        if (next.bfY() >= next.bfX().bfo()) {
                            next.io(true);
                            bVar2.c(next);
                        }
                    }
                }
            }
        }
    }
}
