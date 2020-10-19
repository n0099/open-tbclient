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
    private AtomicBoolean ecA;
    private boolean ecB;
    private boolean ecC;
    private com.baidu.tbadk.BdToken.completeTask.d ecD;
    private com.baidu.tbadk.BdToken.activeConfig.b ecE;
    private com.baidu.tbadk.BdToken.backUser.b ecF;
    private int ecG;
    private long ecH;
    private long ecI;
    private int ecJ;
    private long ecK;
    private CustomMessageListener ecL;
    private com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a> ecM;
    private com.baidu.tbadk.h.b ecN;
    private final ScheduledExecutorService ecw;
    private final SparseArray<List<com.baidu.tbadk.BdToken.b>> ecx;
    private final LinkedList<com.baidu.tbadk.BdToken.b> ecy;
    private a ecz;
    private boolean isSchemaUp;
    private CustomMessageListener mBackgroundListener;
    private BdUniqueId mBdUniqueId;
    private CustomMessageListener mSyncFinishListener;

    public static final c bbM() {
        return g.ecR;
    }

    /* loaded from: classes.dex */
    private static class g {
        private static final c ecR = new c();
    }

    private c() {
        this.ecw = Executors.newSingleThreadScheduledExecutor();
        this.ecx = new SparseArray<>();
        this.ecy = new LinkedList<>();
        this.ecz = new a();
        this.ecA = new AtomicBoolean(false);
        this.ecB = false;
        this.ecC = false;
        this.isSchemaUp = false;
        this.ecL = new CustomMessageListener(2921391) { // from class: com.baidu.tbadk.BdToken.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.ecB = true;
                if (!c.this.ecy.isEmpty()) {
                    Iterator it = c.this.ecy.iterator();
                    while (it.hasNext()) {
                        c.this.l((com.baidu.tbadk.BdToken.b) it.next());
                    }
                    c.this.ecy.clear();
                }
            }
        };
        this.mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.BdToken.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                    ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                    c.this.bbO();
                }
            }
        };
        this.mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tbadk.BdToken.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                    c.this.ecC = true;
                    c.this.bbO();
                }
            }
        };
        this.ecM = new com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a>() { // from class: com.baidu.tbadk.BdToken.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: a */
            public void onSuccess(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null) {
                    c.this.aJ(aVar.bcW());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: b */
            public void aq(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null && aVar.eeR != null && aVar.eeR.mission != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b();
                    bVar.a(aVar.eeR.mission);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(bVar);
                    c.this.aJ(arrayList);
                }
            }

            @Override // com.baidu.tbadk.h.a
            public void onError(int i, String str) {
            }
        };
        this.ecN = new com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b>() { // from class: com.baidu.tbadk.BdToken.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.b
            /* renamed from: m */
            public void onProgressUpdate(com.baidu.tbadk.BdToken.b bVar) {
                if (bVar != null) {
                    com.baidu.tbadk.BdToken.b e2 = c.this.e(bVar);
                    if (e2 != null && e2.ecu) {
                        e2.reset();
                        c.this.j(e2);
                        return;
                    }
                    n.bco().o(e2);
                    if (e2 != null && e2.getTaskType() == 7) {
                        e2.bbs();
                        int bbK = e2.bbK();
                        int tag = e2.getTag();
                        if (bbK <= 1 || bbK <= tag) {
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
        this.ecD = new com.baidu.tbadk.BdToken.completeTask.d(this.mBdUniqueId);
        this.ecD.a(this.ecN);
        this.ecE = new com.baidu.tbadk.BdToken.activeConfig.b(this.mBdUniqueId);
        this.ecE.a(this.ecM);
        this.ecF = new com.baidu.tbadk.BdToken.backUser.b(this.mBdUniqueId);
        this.mSyncFinishListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        this.mBackgroundListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mBackgroundListener);
        this.ecL.setPriority(Integer.MIN_VALUE);
        this.ecL.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.ecL);
        com.baidu.tbadk.core.f.a.blK().init();
        p.bcr().i(this.mBdUniqueId);
        startTimer();
        if (isMainProcess()) {
            new f().execute(new Void[0]);
        }
    }

    private boolean isMainProcess() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public void bbN() {
        if (this.ecF != null && isMainProcess()) {
            this.ecF.bda();
        }
    }

    public void bbO() {
        if (this.ecE != null && isMainProcess() && this.ecC && !bbS()) {
            this.ecE.c(bbQ(), bbR(), 0);
        }
    }

    public boolean bbP() {
        if (this.ecE != null && isMainProcess()) {
            this.ecE.c(bbQ(), bbR(), 1);
            return true;
        }
        return false;
    }

    public boolean bbQ() {
        return !bbT();
    }

    public boolean bbR() {
        return this.isSchemaUp;
    }

    public void setSchemaUp(boolean z) {
        this.isSchemaUp = z;
    }

    public boolean bbS() {
        return UtilHelper.isSameDay(bbV(), System.currentTimeMillis());
    }

    public boolean bbT() {
        return UtilHelper.isSameDay(com.baidu.tbadk.core.sharedPref.b.blO().getLong("pref_key_last_active_config", 0L), System.currentTimeMillis());
    }

    public boolean bbU() {
        return UtilHelper.isSameDay(com.baidu.tbadk.core.sharedPref.b.blO().getLong("pref_key_last_popup_time", 0L), System.currentTimeMillis());
    }

    private long bbV() {
        this.ecK = com.baidu.tbadk.core.sharedPref.b.blO().getLong("pref_key_active_config_info", 0L);
        return this.ecK;
    }

    public int bbW() {
        return this.ecJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.BdToken.b e(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.ecx.size()) {
                return null;
            }
            List<com.baidu.tbadk.BdToken.b> valueAt = this.ecx.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar2 : valueAt) {
                    if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.bbw() == bVar.bbw()) {
                        return bVar2;
                    }
                }
                continue;
            }
            i = i2 + 1;
        }
    }

    public void bbX() {
        this.ecA.compareAndSet(true, false);
        this.ecz.nm(0);
        this.ecz.setTid(0L);
        this.ecz.setFid(0L);
        if (this.ecD != null) {
            this.ecD.bdd();
        }
    }

    public void o(int i, long j) {
        if (isMainProcess()) {
            this.ecJ = i;
            this.ecI = j;
            if (this.ecH > 0 && this.ecG > 0 && (j == 0 || j != this.ecH)) {
                p(this.ecG, this.ecH);
                this.ecH = 0L;
                this.ecG = 0;
            }
            bbY();
        }
    }

    public void p(int i, long j) {
        k kVar;
        com.baidu.tbadk.BdToken.b bcl;
        List<com.baidu.tbadk.BdToken.b> list = this.ecx.get(i);
        if (list != null && !list.isEmpty()) {
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 7) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bbl().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof k) && (bcl = (kVar = (k) next).bcl()) != null && kVar.getTid() == j && bcl.getActivityId() == bVar.getActivityId() && bcl.bbw() == bVar.bbw()) {
                                next.hP(true);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void q(int i, long j) {
        if (isMainProcess() && i != 0 && j != 0 && this.ecB) {
            this.ecG = i;
            List<com.baidu.tbadk.BdToken.b> list = this.ecx.get(i);
            if (list != null && !list.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 1) {
                        a(bVar, j);
                    } else if (bVar.getTaskType() != 7) {
                        continue;
                    } else if (bVar.cA(j)) {
                        break;
                    } else {
                        b(bVar, j);
                    }
                }
                this.ecz.nm(i);
                this.ecz.setTid(j);
                this.ecH = j;
                this.ecA.compareAndSet(false, true);
                synchronized (this.ecA) {
                    this.ecA.notify();
                }
            }
        }
    }

    private void a(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        m mVar;
        com.baidu.tbadk.BdToken.b bcl;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bbl().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof m) && (bcl = (mVar = (m) next).bcl()) != null && mVar.getTid() == j && bcl.getActivityId() == bVar.getActivityId() && bcl.bbw() == bVar.bbw()) {
                z = true;
                break;
            }
        }
        if (!z) {
            m mVar2 = new m(bVar, j);
            mVar2.cF(0L);
            mVar2.hP(false);
            mVar2.nk(bVar.getTag());
            bVar.a(mVar2);
        }
    }

    private void b(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        k kVar;
        com.baidu.tbadk.BdToken.b bcl;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bbl().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof k) && (bcl = (kVar = (k) next).bcl()) != null && kVar.getTid() == j && bcl.getActivityId() == bVar.getActivityId() && bcl.bbw() == bVar.bbw()) {
                z = true;
                break;
            }
        }
        if (!z) {
            k kVar2 = new k(bVar, j);
            kVar2.cF(0L);
            kVar2.hP(false);
            kVar2.nk(bVar.getTag());
            bVar.a(kVar2);
        }
    }

    public void r(int i, long j) {
        boolean z;
        if (isMainProcess() && i != 0 && j != 0 && this.ecB) {
            this.ecG = i;
            List<com.baidu.tbadk.BdToken.b> list = this.ecx.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 2) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bbl().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof j) && next.bcl().getActivityId() == bVar.getActivityId() && next.bcl().bbw() == bVar.bbw() && ((j) next).getFid() == j) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            j jVar = new j(bVar, j);
                            jVar.cF(0L);
                            jVar.hP(false);
                            jVar.nk(bVar.getTag());
                            bVar.a(jVar);
                        }
                        z2 = z;
                    }
                }
                this.ecz.nm(i);
                this.ecz.setFid(j);
                this.ecA.compareAndSet(false, true);
                synchronized (this.ecA) {
                    this.ecA.notify();
                }
            }
        }
    }

    public void nl(int i) {
        boolean z;
        if (isMainProcess() && i != 0 && this.ecB) {
            this.ecG = i;
            List<com.baidu.tbadk.BdToken.b> list = this.ecx.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 4) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bbl().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof i) && next.bcl().getActivityId() == bVar.getActivityId() && next.bcl().bbw() == bVar.bbw()) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            i iVar = new i(bVar);
                            iVar.cF(0L);
                            iVar.hP(false);
                            bVar.a(iVar);
                        }
                        z2 = z;
                    }
                }
                this.ecz.nm(i);
                this.ecA.compareAndSet(false, true);
                synchronized (this.ecA) {
                    this.ecA.notify();
                }
            }
        }
    }

    public void bbY() {
        int i;
        List<com.baidu.tbadk.BdToken.b> list;
        boolean z;
        if (isMainProcess() && this.ecB && (list = this.ecx.get((i = com.baidu.tbadk.BdToken.b.ebM))) != null && !list.isEmpty()) {
            boolean z2 = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 8) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bbl().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = z2;
                            break;
                        }
                        com.baidu.tbadk.BdToken.h next = it.next();
                        com.baidu.tbadk.BdToken.b bcl = next.bcl();
                        if (bcl != null && (next instanceof l) && bcl.getActivityId() == bVar.getActivityId() && bcl.bbw() == bVar.bbw()) {
                            ((l) next).bcn();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        l lVar = new l(bVar);
                        lVar.cF(0L);
                        lVar.hP(false);
                        bVar.a(lVar);
                    }
                    z2 = z;
                }
            }
            this.ecz.nm(i);
            this.ecA.compareAndSet(false, true);
            synchronized (this.ecA) {
                this.ecA.notify();
            }
        }
    }

    private void startTimer() {
        this.ecw.scheduleWithFixedDelay(this.ecz, 0L, 1L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tbadk.BdToken.b bVar) {
        int[] bbB;
        for (int i : bVar.bbB()) {
            List<com.baidu.tbadk.BdToken.b> list = this.ecx.get(i);
            if (list == null) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(bVar);
                this.ecx.put(i, linkedList);
            } else {
                list.add(bVar);
            }
        }
    }

    private boolean g(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return false;
        }
        int[] bbB = bVar.bbB();
        if (bbB == null) {
            return true;
        }
        for (int i : bbB) {
            List<com.baidu.tbadk.BdToken.b> list = this.ecx.get(i);
            if (list == null) {
                return false;
            }
            for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.bbw() == bVar.bbw()) {
                    if (bVar2.bbt()) {
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
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bbl().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.bcl() != null) {
                    com.baidu.tbadk.BdToken.b bcl = next.bcl();
                    if (bcl.getActivityId() == bVar.getActivityId() && bcl.bbw() == bVar.bbw()) {
                        if (taskType == 7 && (next instanceof k)) {
                            ((k) next).hP(true);
                        } else if (taskType == 1 && (next instanceof m)) {
                            ((m) next).hP(true);
                        }
                    }
                }
            }
            bVar.hO(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar != null) {
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bbl().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.bcl() != null) {
                    com.baidu.tbadk.BdToken.b bcl = next.bcl();
                    if (bcl.getActivityId() == bVar.getActivityId() && bcl.bbw() == bVar.bbw()) {
                        it.remove();
                    }
                }
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ecx.size()) {
                    List<com.baidu.tbadk.BdToken.b> valueAt = this.ecx.valueAt(i2);
                    if (valueAt != null && !valueAt.isEmpty()) {
                        Iterator<com.baidu.tbadk.BdToken.b> it2 = valueAt.iterator();
                        while (it2.hasNext()) {
                            com.baidu.tbadk.BdToken.b next2 = it2.next();
                            if (next2 != null && next2.getActivityId() == bVar.getActivityId() && next2.bbw() == bVar.bbw()) {
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
                p.bcr().q(bVar);
            } else if (!this.ecB) {
                this.ecy.add(bVar);
            } else if (!g(bVar)) {
                f(bVar);
                new b().execute(bVar);
            }
        }
    }

    public void aJ(List<com.baidu.tbadk.BdToken.b> list) {
        if (!y.isEmpty(list)) {
            if (!this.ecB) {
                this.ecy.addAll(list);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar != null) {
                    if (bVar.getTaskType() == 9) {
                        p.bcr().q(bVar);
                    } else if (!g(bVar)) {
                        f(bVar);
                        arrayList.add(bVar);
                    }
                }
            }
            new C0544c().execute(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.BdToken.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0544c extends BdAsyncTask<List<com.baidu.tbadk.BdToken.b>, Integer, Void> {
        private C0544c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(List<com.baidu.tbadk.BdToken.b>... listArr) {
            if (listArr != null && listArr.length > 0 && listArr[0] != null) {
                com.baidu.tbadk.BdToken.a.bbi().aJ(listArr[0]);
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
            linkedList.addAll(com.baidu.tbadk.BdToken.a.bbi().bbj());
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next != null && next.bbt()) {
                    com.baidu.tbadk.BdToken.a.bbi().c(next);
                    it.remove();
                } else if (next.getTaskType() == 7) {
                    next.bbn();
                    com.baidu.tbadk.BdToken.a.bbi().b(next);
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
                        if (next.bbB() != null) {
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
                com.baidu.tbadk.BdToken.a.bbi().a(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.bbi().c(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.bbi().c(bVar2);
            }
            if (bVar != null) {
                com.baidu.tbadk.BdToken.a.bbi().a(bVar);
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
            com.baidu.tbadk.BdToken.a.bbi().b(bVar);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(com.baidu.tbadk.BdToken.b bVar) {
            if (bVar != null && bVar.ecu) {
                bVar.ecu = false;
                c.this.q(c.this.ecG, c.this.ecH);
            }
        }
    }

    public void bbZ() {
        List<com.baidu.tbadk.BdToken.b> list = this.ecx.get(com.baidu.tbadk.BdToken.b.ebM);
        if (!y.isEmpty(list)) {
            boolean z = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bbl().iterator();
                boolean z2 = z;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof l) {
                        l lVar = (l) next;
                        if (!next.ik()) {
                            lVar.bcn();
                            z2 = true;
                        }
                    }
                }
                z = z2;
            }
            if (z && !this.ecA.get()) {
                this.ecz.nm(com.baidu.tbadk.BdToken.b.ebM);
                this.ecA.compareAndSet(false, true);
                synchronized (this.ecA) {
                    this.ecA.notify();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private volatile int ecP;
        private volatile boolean ecQ;
        private volatile long ecg;
        private volatile long mFid;

        private a() {
            this.ecQ = false;
        }

        public synchronized void nm(int i) {
            this.ecP = i;
        }

        public synchronized void setTid(long j) {
            this.ecg = j;
        }

        public synchronized void setFid(long j) {
            this.mFid = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.ecP == 0 || !c.this.ecA.get()) {
                synchronized (c.this.ecA) {
                    try {
                        c.this.ecA.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            bca();
        }

        private void bca() {
            this.ecQ = true;
            List<com.baidu.tbadk.BdToken.b> list = (List) c.this.ecx.get(com.baidu.tbadk.BdToken.b.ebM);
            List<com.baidu.tbadk.BdToken.b> list2 = (List) c.this.ecx.get(this.ecP);
            if (y.isEmpty(list) && y.isEmpty(list2)) {
                c.this.ecA.compareAndSet(true, false);
                return;
            }
            d.b bVar = new d.b();
            bVar.efq = new LinkedList();
            bVar.efr = new LinkedList();
            bVar.efs = new LinkedList();
            a(list, bVar);
            b(list2, bVar);
            if (this.ecQ) {
                c.this.ecA.compareAndSet(true, false);
            }
            if (!y.isEmpty(bVar.efs)) {
                com.baidu.tbadk.BdToken.a.bbi().aK(bVar.efs);
            }
            if (!y.isEmpty(bVar.efq) || !y.isEmpty(bVar.efr)) {
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
            ArrayList<com.baidu.tbadk.BdToken.h> bbl;
            if (bVar != null && bVar2 != null && (bbl = bVar.bbl()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bbl.iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if ((next instanceof l) && !((l) next).isTimeout() && !next.ik()) {
                        this.ecQ = false;
                        next.nn(1);
                        if (next.bcm() >= next.bcl().bbC()) {
                            next.hP(true);
                            bVar2.s(bVar);
                        }
                        bVar2.t(bVar);
                    }
                }
            }
        }

        private void b(com.baidu.tbadk.BdToken.b bVar, d.b bVar2) {
            ArrayList<com.baidu.tbadk.BdToken.h> bbl;
            if (bVar != null && bVar2 != null && (bbl = bVar.bbl()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bbl.iterator();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof m) {
                        m mVar = (m) next;
                        if (this.ecg != 0 && mVar.getTid() == this.ecg && !next.ik()) {
                            this.ecQ = false;
                            next.nn(1);
                            if (next.bcm() >= next.bcl().bbC()) {
                                next.hP(true);
                                if (next.bcl().bbr() >= next.bcl().getThreadNum()) {
                                    bVar2.c(next);
                                }
                            }
                            bVar2.t(bVar);
                        }
                    } else if (next instanceof k) {
                        k kVar = (k) next;
                        if (!bVar.bbL() && kVar.getTag() == bVar.getTag()) {
                            if (this.ecg != 0 && kVar.getTid() == this.ecg && !next.ik()) {
                                this.ecQ = false;
                                next.nn(1);
                            }
                            i = (int) (i + next.bcm());
                            if (this.ecg != 0 && kVar.getTid() == this.ecg && !next.ik()) {
                                if (next.bcm() >= bVar.bbC()) {
                                    next.hP(true);
                                    bVar.bbr();
                                }
                                bVar2.t(bVar);
                            }
                            int bbm = bVar.bbm();
                            int threadNum = bVar.getThreadNum();
                            if (i >= bVar.bbC() * bVar.getThreadNum() && bbm >= threadNum) {
                                bVar2.s(bVar);
                                bVar.hO(true);
                            }
                        }
                    } else if (next instanceof j) {
                        if (this.mFid != 0 && ((j) next).getFid() == this.mFid && !next.ik()) {
                            this.ecQ = false;
                            next.nn(1);
                            if (next.bcm() >= next.bcl().bbC()) {
                                next.hP(true);
                                if (next.bcl().bbq() >= next.bcl().bbD()) {
                                    bVar2.c(next);
                                }
                            }
                        }
                    } else if ((next instanceof i) && !next.ik()) {
                        this.ecQ = false;
                        next.nn(1);
                        if (next.bcm() >= next.bcl().bbC()) {
                            next.hP(true);
                            bVar2.c(next);
                        }
                    }
                }
            }
        }
    }
}
