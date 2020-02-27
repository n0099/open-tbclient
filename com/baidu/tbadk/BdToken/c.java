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
    private com.baidu.tbadk.BdToken.completeTask.d cHA;
    private com.baidu.tbadk.BdToken.activeConfig.b cHB;
    private int cHC;
    private long cHD;
    private long cHE;
    private int cHF;
    private long cHG;
    private CustomMessageListener cHH;
    private com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a> cHI;
    private com.baidu.tbadk.h.b cHJ;
    private final ScheduledExecutorService cHt;
    private final SparseArray<List<com.baidu.tbadk.BdToken.b>> cHu;
    private final LinkedList<com.baidu.tbadk.BdToken.b> cHv;
    private a cHw;
    private AtomicBoolean cHx;
    private boolean cHy;
    private boolean cHz;
    private CustomMessageListener mBackgroundListener;
    private BdUniqueId mBdUniqueId;
    private CustomMessageListener mSyncFinishListener;

    public static final c axx() {
        return g.cHN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g {
        private static final c cHN = new c();
    }

    private c() {
        this.cHt = Executors.newSingleThreadScheduledExecutor();
        this.cHu = new SparseArray<>();
        this.cHv = new LinkedList<>();
        this.cHw = new a();
        this.cHx = new AtomicBoolean(false);
        this.cHy = false;
        this.cHz = false;
        this.cHH = new CustomMessageListener(2921391) { // from class: com.baidu.tbadk.BdToken.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.cHy = true;
                if (!c.this.cHv.isEmpty()) {
                    Iterator it = c.this.cHv.iterator();
                    while (it.hasNext()) {
                        c.this.l((com.baidu.tbadk.BdToken.b) it.next());
                    }
                    c.this.cHv.clear();
                }
            }
        };
        this.mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.BdToken.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                    ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                    c.this.axy();
                }
            }
        };
        this.mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tbadk.BdToken.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                    c.this.cHz = true;
                    c.this.axy();
                }
            }
        };
        this.cHI = new com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a>() { // from class: com.baidu.tbadk.BdToken.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: a */
            public void onSuccess(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    com.baidu.tbadk.core.sharedPref.b.aFB().putLong("pref_key_active_config_info", currentTimeMillis);
                    c.this.cHG = currentTimeMillis;
                    c.this.ao(aVar.ayk());
                }
            }

            @Override // com.baidu.tbadk.h.a
            public void onError(int i, String str) {
            }
        };
        this.cHJ = new com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b>() { // from class: com.baidu.tbadk.BdToken.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.b
            /* renamed from: m */
            public void onProgressUpdate(com.baidu.tbadk.BdToken.b bVar) {
                if (bVar != null) {
                    com.baidu.tbadk.BdToken.b e2 = c.this.e(bVar);
                    if (e2 != null && e2.cHr) {
                        e2.reset();
                        c.this.j(e2);
                        return;
                    }
                    n.axV().o(e2);
                    if (e2 != null && e2.getTaskType() == 7) {
                        e2.axd();
                        int axv = e2.axv();
                        int tag = e2.getTag();
                        if (axv <= 1 || axv <= tag) {
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
        this.cHA = new com.baidu.tbadk.BdToken.completeTask.d(this.mBdUniqueId);
        this.cHA.a(this.cHJ);
        this.cHB = new com.baidu.tbadk.BdToken.activeConfig.b(this.mBdUniqueId);
        this.cHB.a(this.cHI);
        this.mSyncFinishListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        this.mBackgroundListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mBackgroundListener);
        this.cHH.setPriority(Integer.MIN_VALUE);
        this.cHH.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.cHH);
        com.baidu.tbadk.core.f.a.aFy().init();
        p.axY().h(this.mBdUniqueId);
        startTimer();
        if (isMainProcess()) {
            new f().execute(new Void[0]);
        }
    }

    private boolean isMainProcess() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public void axy() {
        if (this.cHB != null && isMainProcess() && this.cHz && !axz()) {
            this.cHB.aym();
        }
    }

    public boolean axz() {
        return UtilHelper.isSameDay(axA(), System.currentTimeMillis());
    }

    private long axA() {
        if (this.cHG == 0) {
            this.cHG = com.baidu.tbadk.core.sharedPref.b.aFB().getLong("pref_key_active_config_info", 0L);
        }
        return this.cHG;
    }

    public int axB() {
        return this.cHF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.BdToken.b e(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cHu.size()) {
                return null;
            }
            List<com.baidu.tbadk.BdToken.b> valueAt = this.cHu.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar2 : valueAt) {
                    if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.axh() == bVar.axh()) {
                        return bVar2;
                    }
                }
                continue;
            }
            i = i2 + 1;
        }
    }

    public void axC() {
        this.cHx.compareAndSet(true, false);
        this.cHw.jl(0);
        this.cHw.setTid(0L);
        this.cHw.setFid(0L);
        if (this.cHA != null) {
            this.cHA.ayp();
        }
    }

    public void m(int i, long j) {
        if (isMainProcess()) {
            this.cHF = i;
            this.cHE = j;
            if (this.cHD > 0 && this.cHC > 0 && (j == 0 || j != this.cHD)) {
                n(this.cHC, this.cHD);
                this.cHD = 0L;
                this.cHC = 0;
            }
            axD();
        }
    }

    public void n(int i, long j) {
        k kVar;
        com.baidu.tbadk.BdToken.b axS;
        List<com.baidu.tbadk.BdToken.b> list = this.cHu.get(i);
        if (list != null && !list.isEmpty()) {
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 7) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.awW().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof k) && (axS = (kVar = (k) next).axS()) != null && kVar.getTid() == j && axS.getActivityId() == bVar.getActivityId() && axS.axh() == bVar.axh()) {
                                next.fj(true);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void o(int i, long j) {
        if (isMainProcess() && i != 0 && j != 0 && this.cHy) {
            this.cHC = i;
            List<com.baidu.tbadk.BdToken.b> list = this.cHu.get(i);
            if (list != null && !list.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 1) {
                        a(bVar, j);
                    } else if (bVar.getTaskType() != 7) {
                        continue;
                    } else if (bVar.bn(j)) {
                        break;
                    } else {
                        b(bVar, j);
                    }
                }
                this.cHw.jl(i);
                this.cHw.setTid(j);
                this.cHD = j;
                this.cHx.compareAndSet(false, true);
                synchronized (this.cHx) {
                    this.cHx.notify();
                }
            }
        }
    }

    private void a(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        m mVar;
        com.baidu.tbadk.BdToken.b axS;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.awW().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof m) && (axS = (mVar = (m) next).axS()) != null && mVar.getTid() == j && axS.getActivityId() == bVar.getActivityId() && axS.axh() == bVar.axh()) {
                z = true;
                break;
            }
        }
        if (!z) {
            m mVar2 = new m(bVar, j);
            mVar2.bs(0L);
            mVar2.fj(false);
            mVar2.jj(bVar.getTag());
            bVar.a(mVar2);
        }
    }

    private void b(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        k kVar;
        com.baidu.tbadk.BdToken.b axS;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.awW().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof k) && (axS = (kVar = (k) next).axS()) != null && kVar.getTid() == j && axS.getActivityId() == bVar.getActivityId() && axS.axh() == bVar.axh()) {
                z = true;
                break;
            }
        }
        if (!z) {
            k kVar2 = new k(bVar, j);
            kVar2.bs(0L);
            kVar2.fj(false);
            kVar2.jj(bVar.getTag());
            bVar.a(kVar2);
        }
    }

    public void p(int i, long j) {
        boolean z;
        if (isMainProcess() && i != 0 && j != 0 && this.cHy) {
            this.cHC = i;
            List<com.baidu.tbadk.BdToken.b> list = this.cHu.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 2) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.awW().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof j) && next.axS().getActivityId() == bVar.getActivityId() && next.axS().axh() == bVar.axh() && ((j) next).getFid() == j) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            j jVar = new j(bVar, j);
                            jVar.bs(0L);
                            jVar.fj(false);
                            jVar.jj(bVar.getTag());
                            bVar.a(jVar);
                        }
                        z2 = z;
                    }
                }
                this.cHw.jl(i);
                this.cHw.setFid(j);
                this.cHx.compareAndSet(false, true);
                synchronized (this.cHx) {
                    this.cHx.notify();
                }
            }
        }
    }

    public void jk(int i) {
        boolean z;
        if (isMainProcess() && i != 0 && this.cHy) {
            this.cHC = i;
            List<com.baidu.tbadk.BdToken.b> list = this.cHu.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 4) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.awW().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof i) && next.axS().getActivityId() == bVar.getActivityId() && next.axS().axh() == bVar.axh()) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            i iVar = new i(bVar);
                            iVar.bs(0L);
                            iVar.fj(false);
                            bVar.a(iVar);
                        }
                        z2 = z;
                    }
                }
                this.cHw.jl(i);
                this.cHx.compareAndSet(false, true);
                synchronized (this.cHx) {
                    this.cHx.notify();
                }
            }
        }
    }

    public void axD() {
        int i;
        List<com.baidu.tbadk.BdToken.b> list;
        boolean z;
        if (isMainProcess() && this.cHy && (list = this.cHu.get((i = com.baidu.tbadk.BdToken.b.cGJ))) != null && !list.isEmpty()) {
            boolean z2 = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 8) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.awW().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = z2;
                            break;
                        }
                        com.baidu.tbadk.BdToken.h next = it.next();
                        com.baidu.tbadk.BdToken.b axS = next.axS();
                        if (axS != null && (next instanceof l) && axS.getActivityId() == bVar.getActivityId() && axS.axh() == bVar.axh()) {
                            ((l) next).axU();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        l lVar = new l(bVar);
                        lVar.bs(0L);
                        lVar.fj(false);
                        bVar.a(lVar);
                    }
                    z2 = z;
                }
            }
            this.cHw.jl(i);
            this.cHx.compareAndSet(false, true);
            synchronized (this.cHx) {
                this.cHx.notify();
            }
        }
    }

    private void startTimer() {
        this.cHt.scheduleWithFixedDelay(this.cHw, 0L, 1L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tbadk.BdToken.b bVar) {
        int[] axm;
        for (int i : bVar.axm()) {
            List<com.baidu.tbadk.BdToken.b> list = this.cHu.get(i);
            if (list == null) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(bVar);
                this.cHu.put(i, linkedList);
            } else {
                list.add(bVar);
            }
        }
    }

    private boolean g(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return false;
        }
        int[] axm = bVar.axm();
        if (axm == null) {
            return true;
        }
        for (int i : axm) {
            List<com.baidu.tbadk.BdToken.b> list = this.cHu.get(i);
            if (list == null) {
                return false;
            }
            for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.axh() == bVar.axh()) {
                    if (bVar2.axe()) {
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
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.awW().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.axS() != null) {
                    com.baidu.tbadk.BdToken.b axS = next.axS();
                    if (axS.getActivityId() == bVar.getActivityId() && axS.axh() == bVar.axh()) {
                        if (taskType == 7 && (next instanceof k)) {
                            ((k) next).fj(true);
                        } else if (taskType == 1 && (next instanceof m)) {
                            ((m) next).fj(true);
                        }
                    }
                }
            }
            bVar.fi(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar != null) {
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.awW().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.axS() != null) {
                    com.baidu.tbadk.BdToken.b axS = next.axS();
                    if (axS.getActivityId() == bVar.getActivityId() && axS.axh() == bVar.axh()) {
                        it.remove();
                    }
                }
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.cHu.size()) {
                    List<com.baidu.tbadk.BdToken.b> valueAt = this.cHu.valueAt(i2);
                    if (valueAt != null && !valueAt.isEmpty()) {
                        Iterator<com.baidu.tbadk.BdToken.b> it2 = valueAt.iterator();
                        while (it2.hasNext()) {
                            com.baidu.tbadk.BdToken.b next2 = it2.next();
                            if (next2 != null && next2.getActivityId() == bVar.getActivityId() && next2.axh() == bVar.axh()) {
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
                p.axY().q(bVar);
            } else if (!this.cHy) {
                this.cHv.add(bVar);
            } else if (!g(bVar)) {
                f(bVar);
                new b().execute(bVar);
            }
        }
    }

    public void ao(List<com.baidu.tbadk.BdToken.b> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            if (!this.cHy) {
                this.cHv.addAll(list);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar != null) {
                    if (bVar.getTaskType() == 9) {
                        p.axY().q(bVar);
                    } else if (!g(bVar)) {
                        f(bVar);
                        arrayList.add(bVar);
                    }
                }
            }
            new C0371c().execute(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.BdToken.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0371c extends BdAsyncTask<List<com.baidu.tbadk.BdToken.b>, Integer, Void> {
        private C0371c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(List<com.baidu.tbadk.BdToken.b>... listArr) {
            if (listArr != null && listArr.length > 0 && listArr[0] != null) {
                com.baidu.tbadk.BdToken.a.awT().ao(listArr[0]);
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
            linkedList.addAll(com.baidu.tbadk.BdToken.a.awT().awU());
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next != null && next.axe()) {
                    com.baidu.tbadk.BdToken.a.awT().c(next);
                    it.remove();
                } else if (next.getTaskType() == 7) {
                    next.awY();
                    com.baidu.tbadk.BdToken.a.awT().b(next);
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
                        if (next.axm() != null) {
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
                com.baidu.tbadk.BdToken.a.awT().a(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.awT().c(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.awT().c(bVar2);
            }
            if (bVar != null) {
                com.baidu.tbadk.BdToken.a.awT().a(bVar);
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
            com.baidu.tbadk.BdToken.a.awT().b(bVar);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(com.baidu.tbadk.BdToken.b bVar) {
            if (bVar != null && bVar.cHr) {
                bVar.cHr = false;
                c.this.o(c.this.cHC, c.this.cHD);
            }
        }
    }

    public void axE() {
        List<com.baidu.tbadk.BdToken.b> list = this.cHu.get(com.baidu.tbadk.BdToken.b.cGJ);
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            boolean z = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bVar.awW().iterator();
                boolean z2 = z;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof l) {
                        l lVar = (l) next;
                        if (!next.aW()) {
                            lVar.axU();
                            z2 = true;
                        }
                    }
                }
                z = z2;
            }
            if (z && !this.cHx.get()) {
                this.cHw.jl(com.baidu.tbadk.BdToken.b.cGJ);
                this.cHx.compareAndSet(false, true);
                synchronized (this.cHx) {
                    this.cHx.notify();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private volatile int cHL;
        private volatile boolean cHM;
        private volatile long cHd;
        private volatile long mFid;

        private a() {
            this.cHM = false;
        }

        public synchronized void jl(int i) {
            this.cHL = i;
        }

        public synchronized void setTid(long j) {
            this.cHd = j;
        }

        public synchronized void setFid(long j) {
            this.mFid = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.cHL == 0 || !c.this.cHx.get()) {
                synchronized (c.this.cHx) {
                    try {
                        c.this.cHx.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            axF();
        }

        private void axF() {
            this.cHM = true;
            List<com.baidu.tbadk.BdToken.b> list = (List) c.this.cHu.get(com.baidu.tbadk.BdToken.b.cGJ);
            List<com.baidu.tbadk.BdToken.b> list2 = (List) c.this.cHu.get(this.cHL);
            if (com.baidu.tbadk.core.util.v.isEmpty(list) && com.baidu.tbadk.core.util.v.isEmpty(list2)) {
                c.this.cHx.compareAndSet(true, false);
                return;
            }
            d.b bVar = new d.b();
            bVar.cJD = new LinkedList();
            bVar.cJE = new LinkedList();
            bVar.cJF = new LinkedList();
            a(list, bVar);
            b(list2, bVar);
            if (this.cHM) {
                c.this.cHx.compareAndSet(true, false);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(bVar.cJF)) {
                com.baidu.tbadk.BdToken.a.awT().ap(bVar.cJF);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(bVar.cJD) || !com.baidu.tbadk.core.util.v.isEmpty(bVar.cJE)) {
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
            ArrayList<com.baidu.tbadk.BdToken.h> awW;
            if (bVar != null && bVar2 != null && (awW = bVar.awW()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = awW.iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if ((next instanceof l) && !((l) next).isTimeout() && !next.aW()) {
                        this.cHM = false;
                        next.jm(1);
                        if (next.axT() >= next.axS().axn()) {
                            next.fj(true);
                            bVar2.s(bVar);
                        }
                        bVar2.t(bVar);
                    }
                }
            }
        }

        private void b(com.baidu.tbadk.BdToken.b bVar, d.b bVar2) {
            ArrayList<com.baidu.tbadk.BdToken.h> awW;
            if (bVar != null && bVar2 != null && (awW = bVar.awW()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = awW.iterator();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof m) {
                        m mVar = (m) next;
                        if (this.cHd != 0 && mVar.getTid() == this.cHd && !next.aW()) {
                            this.cHM = false;
                            next.jm(1);
                            if (next.axT() >= next.axS().axn()) {
                                next.fj(true);
                                if (next.axS().axc() >= next.axS().getThreadNum()) {
                                    bVar2.c(next);
                                }
                            }
                            bVar2.t(bVar);
                        }
                    } else if (next instanceof k) {
                        k kVar = (k) next;
                        if (!bVar.axw() && kVar.getTag() == bVar.getTag()) {
                            if (this.cHd != 0 && kVar.getTid() == this.cHd && !next.aW()) {
                                this.cHM = false;
                                next.jm(1);
                            }
                            i = (int) (i + next.axT());
                            if (this.cHd != 0 && kVar.getTid() == this.cHd && !next.aW()) {
                                if (next.axT() >= bVar.axn()) {
                                    next.fj(true);
                                    bVar.axc();
                                }
                                bVar2.t(bVar);
                            }
                            int awX = bVar.awX();
                            int threadNum = bVar.getThreadNum();
                            if (i >= bVar.axn() * bVar.getThreadNum() && awX >= threadNum) {
                                bVar2.s(bVar);
                                bVar.fi(true);
                            }
                        }
                    } else if (next instanceof j) {
                        if (this.mFid != 0 && ((j) next).getFid() == this.mFid && !next.aW()) {
                            this.cHM = false;
                            next.jm(1);
                            if (next.axT() >= next.axS().axn()) {
                                next.fj(true);
                                if (next.axS().axb() >= next.axS().axo()) {
                                    bVar2.c(next);
                                }
                            }
                        }
                    } else if ((next instanceof i) && !next.aW()) {
                        this.cHM = false;
                        next.jm(1);
                        if (next.axT() >= next.axS().axn()) {
                            next.fj(true);
                            bVar2.c(next);
                        }
                    }
                }
            }
        }
    }
}
