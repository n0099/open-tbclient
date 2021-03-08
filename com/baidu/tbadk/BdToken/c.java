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
    private long eEA;
    private long eEB;
    private int eEC;
    private long eED;
    private CustomMessageListener eEE;
    private com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a> eEF;
    private com.baidu.tbadk.h.b eEG;
    private final ScheduledExecutorService eEp;
    private final SparseArray<List<com.baidu.tbadk.BdToken.b>> eEq;
    private final LinkedList<com.baidu.tbadk.BdToken.b> eEr;
    private a eEs;
    private AtomicBoolean eEt;
    private boolean eEu;
    private boolean eEv;
    private com.baidu.tbadk.BdToken.completeTask.d eEw;
    private com.baidu.tbadk.BdToken.activeConfig.b eEx;
    private com.baidu.tbadk.BdToken.backUser.b eEy;
    private int eEz;
    private boolean isSchemaUp;
    private CustomMessageListener mBackgroundListener;
    private BdUniqueId mBdUniqueId;
    private CustomMessageListener mSyncFinishListener;

    public static final c bhp() {
        return g.eEK;
    }

    /* loaded from: classes.dex */
    private static class g {
        private static final c eEK = new c();
    }

    private c() {
        this.eEp = Executors.newSingleThreadScheduledExecutor();
        this.eEq = new SparseArray<>();
        this.eEr = new LinkedList<>();
        this.eEs = new a();
        this.eEt = new AtomicBoolean(false);
        this.eEu = false;
        this.eEv = false;
        this.isSchemaUp = false;
        this.eEE = new CustomMessageListener(2921391) { // from class: com.baidu.tbadk.BdToken.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.eEu = true;
                if (!c.this.eEr.isEmpty()) {
                    Iterator it = c.this.eEr.iterator();
                    while (it.hasNext()) {
                        c.this.l((com.baidu.tbadk.BdToken.b) it.next());
                    }
                    c.this.eEr.clear();
                }
            }
        };
        this.mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.BdToken.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                    ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                    c.this.bhr();
                }
            }
        };
        this.mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tbadk.BdToken.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                    c.this.eEv = true;
                    c.this.bhr();
                }
            }
        };
        this.eEF = new com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a>() { // from class: com.baidu.tbadk.BdToken.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: a */
            public void onSuccess(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null) {
                    c.this.bf(aVar.biy());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: b */
            public void au(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null && aVar.eGR != null && aVar.eGR.mission != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b();
                    bVar.a(aVar.eGR.mission);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(bVar);
                    c.this.bf(arrayList);
                }
            }

            @Override // com.baidu.tbadk.h.a
            public void onError(int i, String str) {
            }
        };
        this.eEG = new com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b>() { // from class: com.baidu.tbadk.BdToken.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.b
            /* renamed from: m */
            public void onProgressUpdate(com.baidu.tbadk.BdToken.b bVar) {
                if (bVar != null) {
                    com.baidu.tbadk.BdToken.b e2 = c.this.e(bVar);
                    if (e2 != null && e2.eEn) {
                        e2.reset();
                        c.this.j(e2);
                        return;
                    }
                    n.bhR().o(e2);
                    if (e2 != null && e2.getTaskType() == 7) {
                        e2.bgV();
                        int bhn = e2.bhn();
                        int tag = e2.getTag();
                        if (bhn <= 1 || bhn <= tag) {
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
        this.eEw = new com.baidu.tbadk.BdToken.completeTask.d(this.mBdUniqueId);
        this.eEw.a(this.eEG);
        this.eEx = new com.baidu.tbadk.BdToken.activeConfig.b(this.mBdUniqueId);
        this.eEx.a(this.eEF);
        this.eEy = new com.baidu.tbadk.BdToken.backUser.b(this.mBdUniqueId);
        this.mSyncFinishListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        this.mBackgroundListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mBackgroundListener);
        this.eEE.setPriority(Integer.MIN_VALUE);
        this.eEE.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.eEE);
        com.baidu.tbadk.core.f.a.brN().init();
        p.bhU().i(this.mBdUniqueId);
        startTimer();
        if (isMainProcess()) {
            new f().execute(new Void[0]);
        }
    }

    private boolean isMainProcess() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public void bhq() {
        if (this.eEy != null && isMainProcess()) {
            this.eEy.biB();
        }
    }

    public void bhr() {
        if (this.eEx != null && isMainProcess() && this.eEv && !bhv()) {
            this.eEx.d(bht(), bhu(), 0);
        }
    }

    public boolean bhs() {
        if (this.eEx != null && isMainProcess()) {
            this.eEx.d(bht(), bhu(), 1);
            return true;
        }
        return false;
    }

    public boolean bht() {
        return !bhw();
    }

    public boolean bhu() {
        return this.isSchemaUp;
    }

    public void setSchemaUp(boolean z) {
        this.isSchemaUp = z;
    }

    public boolean bhv() {
        return UtilHelper.isSameDay(bhy(), System.currentTimeMillis());
    }

    public boolean bhw() {
        return UtilHelper.isSameDay(com.baidu.tbadk.core.sharedPref.b.brR().getLong("pref_key_last_active_config", 0L), System.currentTimeMillis());
    }

    public boolean bhx() {
        return UtilHelper.isSameDay(com.baidu.tbadk.core.sharedPref.b.brR().getLong("pref_key_last_popup_time", 0L), System.currentTimeMillis());
    }

    private long bhy() {
        this.eED = com.baidu.tbadk.core.sharedPref.b.brR().getLong("pref_key_active_config_info", 0L);
        return this.eED;
    }

    public int bhz() {
        return this.eEC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.BdToken.b e(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.eEq.size()) {
                return null;
            }
            List<com.baidu.tbadk.BdToken.b> valueAt = this.eEq.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar2 : valueAt) {
                    if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.bgZ() == bVar.bgZ()) {
                        return bVar2;
                    }
                }
                continue;
            }
            i = i2 + 1;
        }
    }

    public void bhA() {
        this.eEt.compareAndSet(true, false);
        this.eEs.mI(0);
        this.eEs.setTid(0L);
        this.eEs.setFid(0L);
        if (this.eEw != null) {
            this.eEw.biE();
        }
    }

    public void o(int i, long j) {
        if (isMainProcess()) {
            this.eEC = i;
            this.eEB = j;
            if (this.eEA > 0 && this.eEz > 0 && (j == 0 || j != this.eEA)) {
                p(this.eEz, this.eEA);
                this.eEA = 0L;
                this.eEz = 0;
            }
            bhB();
        }
    }

    public void p(int i, long j) {
        k kVar;
        com.baidu.tbadk.BdToken.b bhO;
        List<com.baidu.tbadk.BdToken.b> list = this.eEq.get(i);
        if (list != null && !list.isEmpty()) {
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 7) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bgO().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof k) && (bhO = (kVar = (k) next).bhO()) != null && kVar.getTid() == j && bhO.getActivityId() == bVar.getActivityId() && bhO.bgZ() == bVar.bgZ()) {
                                next.iW(true);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void q(int i, long j) {
        if (isMainProcess() && i != 0 && j != 0 && this.eEu) {
            this.eEz = i;
            List<com.baidu.tbadk.BdToken.b> list = this.eEq.get(i);
            if (list != null && !list.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 1) {
                        a(bVar, j);
                    } else if (bVar.getTaskType() != 7) {
                        continue;
                    } else if (bVar.dD(j)) {
                        break;
                    } else {
                        b(bVar, j);
                    }
                }
                this.eEs.mI(i);
                this.eEs.setTid(j);
                this.eEA = j;
                this.eEt.compareAndSet(false, true);
                synchronized (this.eEt) {
                    this.eEt.notify();
                }
            }
        }
    }

    private void a(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        m mVar;
        com.baidu.tbadk.BdToken.b bhO;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bgO().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof m) && (bhO = (mVar = (m) next).bhO()) != null && mVar.getTid() == j && bhO.getActivityId() == bVar.getActivityId() && bhO.bgZ() == bVar.bgZ()) {
                z = true;
                break;
            }
        }
        if (!z) {
            m mVar2 = new m(bVar, j);
            mVar2.dI(0L);
            mVar2.iW(false);
            mVar2.mG(bVar.getTag());
            bVar.a(mVar2);
        }
    }

    private void b(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        k kVar;
        com.baidu.tbadk.BdToken.b bhO;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bgO().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof k) && (bhO = (kVar = (k) next).bhO()) != null && kVar.getTid() == j && bhO.getActivityId() == bVar.getActivityId() && bhO.bgZ() == bVar.bgZ()) {
                z = true;
                break;
            }
        }
        if (!z) {
            k kVar2 = new k(bVar, j);
            kVar2.dI(0L);
            kVar2.iW(false);
            kVar2.mG(bVar.getTag());
            bVar.a(kVar2);
        }
    }

    public void r(int i, long j) {
        boolean z;
        if (isMainProcess() && i != 0 && j != 0 && this.eEu) {
            this.eEz = i;
            List<com.baidu.tbadk.BdToken.b> list = this.eEq.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 2) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bgO().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof j) && next.bhO().getActivityId() == bVar.getActivityId() && next.bhO().bgZ() == bVar.bgZ() && ((j) next).getFid() == j) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            j jVar = new j(bVar, j);
                            jVar.dI(0L);
                            jVar.iW(false);
                            jVar.mG(bVar.getTag());
                            bVar.a(jVar);
                        }
                        z2 = z;
                    }
                }
                this.eEs.mI(i);
                this.eEs.setFid(j);
                this.eEt.compareAndSet(false, true);
                synchronized (this.eEt) {
                    this.eEt.notify();
                }
            }
        }
    }

    public void mH(int i) {
        boolean z;
        if (isMainProcess() && i != 0 && this.eEu) {
            this.eEz = i;
            List<com.baidu.tbadk.BdToken.b> list = this.eEq.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 4) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bgO().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof i) && next.bhO().getActivityId() == bVar.getActivityId() && next.bhO().bgZ() == bVar.bgZ()) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            i iVar = new i(bVar);
                            iVar.dI(0L);
                            iVar.iW(false);
                            bVar.a(iVar);
                        }
                        z2 = z;
                    }
                }
                this.eEs.mI(i);
                this.eEt.compareAndSet(false, true);
                synchronized (this.eEt) {
                    this.eEt.notify();
                }
            }
        }
    }

    public void bhB() {
        int i;
        List<com.baidu.tbadk.BdToken.b> list;
        boolean z;
        if (isMainProcess() && this.eEu && (list = this.eEq.get((i = com.baidu.tbadk.BdToken.b.eDF))) != null && !list.isEmpty()) {
            boolean z2 = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 8) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bgO().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = z2;
                            break;
                        }
                        com.baidu.tbadk.BdToken.h next = it.next();
                        com.baidu.tbadk.BdToken.b bhO = next.bhO();
                        if (bhO != null && (next instanceof l) && bhO.getActivityId() == bVar.getActivityId() && bhO.bgZ() == bVar.bgZ()) {
                            ((l) next).bhQ();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        l lVar = new l(bVar);
                        lVar.dI(0L);
                        lVar.iW(false);
                        bVar.a(lVar);
                    }
                    z2 = z;
                }
            }
            this.eEs.mI(i);
            this.eEt.compareAndSet(false, true);
            synchronized (this.eEt) {
                this.eEt.notify();
            }
        }
    }

    private void startTimer() {
        this.eEp.scheduleWithFixedDelay(this.eEs, 0L, 1L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tbadk.BdToken.b bVar) {
        int[] bhe;
        for (int i : bVar.bhe()) {
            List<com.baidu.tbadk.BdToken.b> list = this.eEq.get(i);
            if (list == null) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(bVar);
                this.eEq.put(i, linkedList);
            } else {
                list.add(bVar);
            }
        }
    }

    private boolean g(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return false;
        }
        int[] bhe = bVar.bhe();
        if (bhe == null) {
            return true;
        }
        for (int i : bhe) {
            List<com.baidu.tbadk.BdToken.b> list = this.eEq.get(i);
            if (list == null) {
                return false;
            }
            for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.bgZ() == bVar.bgZ()) {
                    if (bVar2.bgW()) {
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
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bgO().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.bhO() != null) {
                    com.baidu.tbadk.BdToken.b bhO = next.bhO();
                    if (bhO.getActivityId() == bVar.getActivityId() && bhO.bgZ() == bVar.bgZ()) {
                        if (taskType == 7 && (next instanceof k)) {
                            ((k) next).iW(true);
                        } else if (taskType == 1 && (next instanceof m)) {
                            ((m) next).iW(true);
                        }
                    }
                }
            }
            bVar.iV(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar != null) {
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bgO().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.bhO() != null) {
                    com.baidu.tbadk.BdToken.b bhO = next.bhO();
                    if (bhO.getActivityId() == bVar.getActivityId() && bhO.bgZ() == bVar.bgZ()) {
                        it.remove();
                    }
                }
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eEq.size()) {
                    List<com.baidu.tbadk.BdToken.b> valueAt = this.eEq.valueAt(i2);
                    if (valueAt != null && !valueAt.isEmpty()) {
                        Iterator<com.baidu.tbadk.BdToken.b> it2 = valueAt.iterator();
                        while (it2.hasNext()) {
                            com.baidu.tbadk.BdToken.b next2 = it2.next();
                            if (next2 != null && next2.getActivityId() == bVar.getActivityId() && next2.bgZ() == bVar.bgZ()) {
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
                p.bhU().q(bVar);
            } else if (!this.eEu) {
                this.eEr.add(bVar);
            } else if (!g(bVar)) {
                f(bVar);
                new b().execute(bVar);
            }
        }
    }

    public void bf(List<com.baidu.tbadk.BdToken.b> list) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(list)) {
            if (!this.eEu) {
                this.eEr.addAll(list);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar != null) {
                    if (bVar.getTaskType() == 9) {
                        p.bhU().q(bVar);
                    } else if (!g(bVar)) {
                        f(bVar);
                        arrayList.add(bVar);
                    }
                }
            }
            new C0557c().execute(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.BdToken.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0557c extends BdAsyncTask<List<com.baidu.tbadk.BdToken.b>, Integer, Void> {
        private C0557c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(List<com.baidu.tbadk.BdToken.b>... listArr) {
            if (listArr != null && listArr.length > 0 && listArr[0] != null) {
                com.baidu.tbadk.BdToken.a.bgL().bf(listArr[0]);
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
            linkedList.addAll(com.baidu.tbadk.BdToken.a.bgL().bgM());
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next != null && next.bgW()) {
                    com.baidu.tbadk.BdToken.a.bgL().c(next);
                    it.remove();
                } else if (next.getTaskType() == 7) {
                    next.bgQ();
                    com.baidu.tbadk.BdToken.a.bgL().b(next);
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
                        if (next.bhe() != null) {
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
                com.baidu.tbadk.BdToken.a.bgL().a(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.bgL().c(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.bgL().c(bVar2);
            }
            if (bVar != null) {
                com.baidu.tbadk.BdToken.a.bgL().a(bVar);
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
            com.baidu.tbadk.BdToken.a.bgL().b(bVar);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(com.baidu.tbadk.BdToken.b bVar) {
            if (bVar != null && bVar.eEn) {
                bVar.eEn = false;
                c.this.q(c.this.eEz, c.this.eEA);
            }
        }
    }

    public void bhC() {
        List<com.baidu.tbadk.BdToken.b> list = this.eEq.get(com.baidu.tbadk.BdToken.b.eDF);
        if (!com.baidu.tbadk.core.util.y.isEmpty(list)) {
            boolean z = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bgO().iterator();
                boolean z2 = z;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof l) {
                        l lVar = (l) next;
                        if (!next.isCompleted()) {
                            lVar.bhQ();
                            z2 = true;
                        }
                    }
                }
                z = z2;
            }
            if (z && !this.eEt.get()) {
                this.eEs.mI(com.baidu.tbadk.BdToken.b.eDF);
                this.eEt.compareAndSet(false, true);
                synchronized (this.eEt) {
                    this.eEt.notify();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private volatile long eDZ;
        private volatile int eEI;
        private volatile boolean eEJ;
        private volatile long mFid;

        private a() {
            this.eEJ = false;
        }

        public synchronized void mI(int i) {
            this.eEI = i;
        }

        public synchronized void setTid(long j) {
            this.eDZ = j;
        }

        public synchronized void setFid(long j) {
            this.mFid = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.eEI == 0 || !c.this.eEt.get()) {
                synchronized (c.this.eEt) {
                    try {
                        c.this.eEt.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            bhD();
        }

        private void bhD() {
            this.eEJ = true;
            List<com.baidu.tbadk.BdToken.b> list = (List) c.this.eEq.get(com.baidu.tbadk.BdToken.b.eDF);
            List<com.baidu.tbadk.BdToken.b> list2 = (List) c.this.eEq.get(this.eEI);
            if (com.baidu.tbadk.core.util.y.isEmpty(list) && com.baidu.tbadk.core.util.y.isEmpty(list2)) {
                c.this.eEt.compareAndSet(true, false);
                return;
            }
            d.b bVar = new d.b();
            bVar.eHA = new LinkedList();
            bVar.eHB = new LinkedList();
            bVar.eHC = new LinkedList();
            a(list, bVar);
            b(list2, bVar);
            if (this.eEJ) {
                c.this.eEt.compareAndSet(true, false);
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(bVar.eHC)) {
                com.baidu.tbadk.BdToken.a.bgL().bg(bVar.eHC);
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(bVar.eHA) || !com.baidu.tbadk.core.util.y.isEmpty(bVar.eHB)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921379, bVar));
            }
        }

        private void a(List<com.baidu.tbadk.BdToken.b> list, d.b bVar) {
            if (!com.baidu.tbadk.core.util.y.isEmpty(list)) {
                for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                    a(bVar2, bVar);
                }
            }
        }

        private void b(List<com.baidu.tbadk.BdToken.b> list, d.b bVar) {
            if (!com.baidu.tbadk.core.util.y.isEmpty(list)) {
                for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                    b(bVar2, bVar);
                }
            }
        }

        private void a(com.baidu.tbadk.BdToken.b bVar, d.b bVar2) {
            ArrayList<com.baidu.tbadk.BdToken.h> bgO;
            if (bVar != null && bVar2 != null && (bgO = bVar.bgO()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bgO.iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if ((next instanceof l) && !((l) next).isTimeout() && !next.isCompleted()) {
                        this.eEJ = false;
                        next.mJ(1);
                        if (next.bhP() >= next.bhO().bhf()) {
                            next.iW(true);
                            bVar2.s(bVar);
                        }
                        bVar2.t(bVar);
                    }
                }
            }
        }

        private void b(com.baidu.tbadk.BdToken.b bVar, d.b bVar2) {
            ArrayList<com.baidu.tbadk.BdToken.h> bgO;
            if (bVar != null && bVar2 != null && (bgO = bVar.bgO()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bgO.iterator();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof m) {
                        m mVar = (m) next;
                        if (this.eDZ != 0 && mVar.getTid() == this.eDZ && !next.isCompleted()) {
                            this.eEJ = false;
                            next.mJ(1);
                            if (next.bhP() >= next.bhO().bhf()) {
                                next.iW(true);
                                if (next.bhO().bgU() >= next.bhO().getThreadNum()) {
                                    bVar2.c(next);
                                }
                            }
                            bVar2.t(bVar);
                        }
                    } else if (next instanceof k) {
                        k kVar = (k) next;
                        if (!bVar.bho() && kVar.getTag() == bVar.getTag()) {
                            if (this.eDZ != 0 && kVar.getTid() == this.eDZ && !next.isCompleted()) {
                                this.eEJ = false;
                                next.mJ(1);
                            }
                            i = (int) (i + next.bhP());
                            if (this.eDZ != 0 && kVar.getTid() == this.eDZ && !next.isCompleted()) {
                                if (next.bhP() >= bVar.bhf()) {
                                    next.iW(true);
                                    bVar.bgU();
                                }
                                bVar2.t(bVar);
                            }
                            int bgP = bVar.bgP();
                            int threadNum = bVar.getThreadNum();
                            if (i >= bVar.bhf() * bVar.getThreadNum() && bgP >= threadNum) {
                                bVar2.s(bVar);
                                bVar.iV(true);
                            }
                        }
                    } else if (next instanceof j) {
                        if (this.mFid != 0 && ((j) next).getFid() == this.mFid && !next.isCompleted()) {
                            this.eEJ = false;
                            next.mJ(1);
                            if (next.bhP() >= next.bhO().bhf()) {
                                next.iW(true);
                                if (next.bhO().bgT() >= next.bhO().bhg()) {
                                    bVar2.c(next);
                                }
                            }
                        }
                    } else if ((next instanceof i) && !next.isCompleted()) {
                        this.eEJ = false;
                        next.mJ(1);
                        if (next.bhP() >= next.bhO().bhf()) {
                            next.iW(true);
                            bVar2.c(next);
                        }
                    }
                }
            }
        }
    }
}
