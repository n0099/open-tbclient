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
    private boolean cHA;
    private com.baidu.tbadk.BdToken.completeTask.d cHB;
    private com.baidu.tbadk.BdToken.activeConfig.b cHC;
    private int cHD;
    private long cHE;
    private long cHF;
    private int cHG;
    private long cHH;
    private CustomMessageListener cHI;
    private com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a> cHJ;
    private com.baidu.tbadk.h.b cHK;
    private final ScheduledExecutorService cHu;
    private final SparseArray<List<com.baidu.tbadk.BdToken.b>> cHv;
    private final LinkedList<com.baidu.tbadk.BdToken.b> cHw;
    private a cHx;
    private AtomicBoolean cHy;
    private boolean cHz;
    private CustomMessageListener mBackgroundListener;
    private BdUniqueId mBdUniqueId;
    private CustomMessageListener mSyncFinishListener;

    public static final c axz() {
        return g.cHO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g {
        private static final c cHO = new c();
    }

    private c() {
        this.cHu = Executors.newSingleThreadScheduledExecutor();
        this.cHv = new SparseArray<>();
        this.cHw = new LinkedList<>();
        this.cHx = new a();
        this.cHy = new AtomicBoolean(false);
        this.cHz = false;
        this.cHA = false;
        this.cHI = new CustomMessageListener(2921391) { // from class: com.baidu.tbadk.BdToken.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.cHz = true;
                if (!c.this.cHw.isEmpty()) {
                    Iterator it = c.this.cHw.iterator();
                    while (it.hasNext()) {
                        c.this.l((com.baidu.tbadk.BdToken.b) it.next());
                    }
                    c.this.cHw.clear();
                }
            }
        };
        this.mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.BdToken.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                    ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                    c.this.axA();
                }
            }
        };
        this.mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tbadk.BdToken.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                    c.this.cHA = true;
                    c.this.axA();
                }
            }
        };
        this.cHJ = new com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a>() { // from class: com.baidu.tbadk.BdToken.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: a */
            public void onSuccess(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    com.baidu.tbadk.core.sharedPref.b.aFD().putLong("pref_key_active_config_info", currentTimeMillis);
                    c.this.cHH = currentTimeMillis;
                    c.this.ao(aVar.aym());
                }
            }

            @Override // com.baidu.tbadk.h.a
            public void onError(int i, String str) {
            }
        };
        this.cHK = new com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b>() { // from class: com.baidu.tbadk.BdToken.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.b
            /* renamed from: m */
            public void onProgressUpdate(com.baidu.tbadk.BdToken.b bVar) {
                if (bVar != null) {
                    com.baidu.tbadk.BdToken.b e2 = c.this.e(bVar);
                    if (e2 != null && e2.cHs) {
                        e2.reset();
                        c.this.j(e2);
                        return;
                    }
                    n.axX().o(e2);
                    if (e2 != null && e2.getTaskType() == 7) {
                        e2.axf();
                        int axx = e2.axx();
                        int tag = e2.getTag();
                        if (axx <= 1 || axx <= tag) {
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
        this.cHB = new com.baidu.tbadk.BdToken.completeTask.d(this.mBdUniqueId);
        this.cHB.a(this.cHK);
        this.cHC = new com.baidu.tbadk.BdToken.activeConfig.b(this.mBdUniqueId);
        this.cHC.a(this.cHJ);
        this.mSyncFinishListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        this.mBackgroundListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mBackgroundListener);
        this.cHI.setPriority(Integer.MIN_VALUE);
        this.cHI.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.cHI);
        com.baidu.tbadk.core.f.a.aFA().init();
        p.aya().h(this.mBdUniqueId);
        startTimer();
        if (isMainProcess()) {
            new f().execute(new Void[0]);
        }
    }

    private boolean isMainProcess() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public void axA() {
        if (this.cHC != null && isMainProcess() && this.cHA && !axB()) {
            this.cHC.ayo();
        }
    }

    public boolean axB() {
        return UtilHelper.isSameDay(axC(), System.currentTimeMillis());
    }

    private long axC() {
        if (this.cHH == 0) {
            this.cHH = com.baidu.tbadk.core.sharedPref.b.aFD().getLong("pref_key_active_config_info", 0L);
        }
        return this.cHH;
    }

    public int axD() {
        return this.cHG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.BdToken.b e(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cHv.size()) {
                return null;
            }
            List<com.baidu.tbadk.BdToken.b> valueAt = this.cHv.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar2 : valueAt) {
                    if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.axj() == bVar.axj()) {
                        return bVar2;
                    }
                }
                continue;
            }
            i = i2 + 1;
        }
    }

    public void axE() {
        this.cHy.compareAndSet(true, false);
        this.cHx.jl(0);
        this.cHx.setTid(0L);
        this.cHx.setFid(0L);
        if (this.cHB != null) {
            this.cHB.ayr();
        }
    }

    public void m(int i, long j) {
        if (isMainProcess()) {
            this.cHG = i;
            this.cHF = j;
            if (this.cHE > 0 && this.cHD > 0 && (j == 0 || j != this.cHE)) {
                n(this.cHD, this.cHE);
                this.cHE = 0L;
                this.cHD = 0;
            }
            axF();
        }
    }

    public void n(int i, long j) {
        k kVar;
        com.baidu.tbadk.BdToken.b axU;
        List<com.baidu.tbadk.BdToken.b> list = this.cHv.get(i);
        if (list != null && !list.isEmpty()) {
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 7) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.awY().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof k) && (axU = (kVar = (k) next).axU()) != null && kVar.getTid() == j && axU.getActivityId() == bVar.getActivityId() && axU.axj() == bVar.axj()) {
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
        if (isMainProcess() && i != 0 && j != 0 && this.cHz) {
            this.cHD = i;
            List<com.baidu.tbadk.BdToken.b> list = this.cHv.get(i);
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
                this.cHx.jl(i);
                this.cHx.setTid(j);
                this.cHE = j;
                this.cHy.compareAndSet(false, true);
                synchronized (this.cHy) {
                    this.cHy.notify();
                }
            }
        }
    }

    private void a(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        m mVar;
        com.baidu.tbadk.BdToken.b axU;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.awY().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof m) && (axU = (mVar = (m) next).axU()) != null && mVar.getTid() == j && axU.getActivityId() == bVar.getActivityId() && axU.axj() == bVar.axj()) {
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
        com.baidu.tbadk.BdToken.b axU;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.awY().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof k) && (axU = (kVar = (k) next).axU()) != null && kVar.getTid() == j && axU.getActivityId() == bVar.getActivityId() && axU.axj() == bVar.axj()) {
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
        if (isMainProcess() && i != 0 && j != 0 && this.cHz) {
            this.cHD = i;
            List<com.baidu.tbadk.BdToken.b> list = this.cHv.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 2) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.awY().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof j) && next.axU().getActivityId() == bVar.getActivityId() && next.axU().axj() == bVar.axj() && ((j) next).getFid() == j) {
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
                this.cHx.jl(i);
                this.cHx.setFid(j);
                this.cHy.compareAndSet(false, true);
                synchronized (this.cHy) {
                    this.cHy.notify();
                }
            }
        }
    }

    public void jk(int i) {
        boolean z;
        if (isMainProcess() && i != 0 && this.cHz) {
            this.cHD = i;
            List<com.baidu.tbadk.BdToken.b> list = this.cHv.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 4) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.awY().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof i) && next.axU().getActivityId() == bVar.getActivityId() && next.axU().axj() == bVar.axj()) {
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
                this.cHx.jl(i);
                this.cHy.compareAndSet(false, true);
                synchronized (this.cHy) {
                    this.cHy.notify();
                }
            }
        }
    }

    public void axF() {
        int i;
        List<com.baidu.tbadk.BdToken.b> list;
        boolean z;
        if (isMainProcess() && this.cHz && (list = this.cHv.get((i = com.baidu.tbadk.BdToken.b.cGK))) != null && !list.isEmpty()) {
            boolean z2 = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 8) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.awY().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = z2;
                            break;
                        }
                        com.baidu.tbadk.BdToken.h next = it.next();
                        com.baidu.tbadk.BdToken.b axU = next.axU();
                        if (axU != null && (next instanceof l) && axU.getActivityId() == bVar.getActivityId() && axU.axj() == bVar.axj()) {
                            ((l) next).axW();
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
            this.cHx.jl(i);
            this.cHy.compareAndSet(false, true);
            synchronized (this.cHy) {
                this.cHy.notify();
            }
        }
    }

    private void startTimer() {
        this.cHu.scheduleWithFixedDelay(this.cHx, 0L, 1L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tbadk.BdToken.b bVar) {
        int[] axo;
        for (int i : bVar.axo()) {
            List<com.baidu.tbadk.BdToken.b> list = this.cHv.get(i);
            if (list == null) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(bVar);
                this.cHv.put(i, linkedList);
            } else {
                list.add(bVar);
            }
        }
    }

    private boolean g(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return false;
        }
        int[] axo = bVar.axo();
        if (axo == null) {
            return true;
        }
        for (int i : axo) {
            List<com.baidu.tbadk.BdToken.b> list = this.cHv.get(i);
            if (list == null) {
                return false;
            }
            for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.axj() == bVar.axj()) {
                    if (bVar2.axg()) {
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
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.awY().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.axU() != null) {
                    com.baidu.tbadk.BdToken.b axU = next.axU();
                    if (axU.getActivityId() == bVar.getActivityId() && axU.axj() == bVar.axj()) {
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
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.awY().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.axU() != null) {
                    com.baidu.tbadk.BdToken.b axU = next.axU();
                    if (axU.getActivityId() == bVar.getActivityId() && axU.axj() == bVar.axj()) {
                        it.remove();
                    }
                }
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.cHv.size()) {
                    List<com.baidu.tbadk.BdToken.b> valueAt = this.cHv.valueAt(i2);
                    if (valueAt != null && !valueAt.isEmpty()) {
                        Iterator<com.baidu.tbadk.BdToken.b> it2 = valueAt.iterator();
                        while (it2.hasNext()) {
                            com.baidu.tbadk.BdToken.b next2 = it2.next();
                            if (next2 != null && next2.getActivityId() == bVar.getActivityId() && next2.axj() == bVar.axj()) {
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
                p.aya().q(bVar);
            } else if (!this.cHz) {
                this.cHw.add(bVar);
            } else if (!g(bVar)) {
                f(bVar);
                new b().execute(bVar);
            }
        }
    }

    public void ao(List<com.baidu.tbadk.BdToken.b> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            if (!this.cHz) {
                this.cHw.addAll(list);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar != null) {
                    if (bVar.getTaskType() == 9) {
                        p.aya().q(bVar);
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
                com.baidu.tbadk.BdToken.a.awV().ao(listArr[0]);
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
            linkedList.addAll(com.baidu.tbadk.BdToken.a.awV().awW());
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next != null && next.axg()) {
                    com.baidu.tbadk.BdToken.a.awV().c(next);
                    it.remove();
                } else if (next.getTaskType() == 7) {
                    next.axa();
                    com.baidu.tbadk.BdToken.a.awV().b(next);
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
                        if (next.axo() != null) {
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
                com.baidu.tbadk.BdToken.a.awV().a(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.awV().c(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.awV().c(bVar2);
            }
            if (bVar != null) {
                com.baidu.tbadk.BdToken.a.awV().a(bVar);
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
            com.baidu.tbadk.BdToken.a.awV().b(bVar);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(com.baidu.tbadk.BdToken.b bVar) {
            if (bVar != null && bVar.cHs) {
                bVar.cHs = false;
                c.this.o(c.this.cHD, c.this.cHE);
            }
        }
    }

    public void axG() {
        List<com.baidu.tbadk.BdToken.b> list = this.cHv.get(com.baidu.tbadk.BdToken.b.cGK);
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            boolean z = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bVar.awY().iterator();
                boolean z2 = z;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof l) {
                        l lVar = (l) next;
                        if (!next.aW()) {
                            lVar.axW();
                            z2 = true;
                        }
                    }
                }
                z = z2;
            }
            if (z && !this.cHy.get()) {
                this.cHx.jl(com.baidu.tbadk.BdToken.b.cGK);
                this.cHy.compareAndSet(false, true);
                synchronized (this.cHy) {
                    this.cHy.notify();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private volatile int cHM;
        private volatile boolean cHN;
        private volatile long cHe;
        private volatile long mFid;

        private a() {
            this.cHN = false;
        }

        public synchronized void jl(int i) {
            this.cHM = i;
        }

        public synchronized void setTid(long j) {
            this.cHe = j;
        }

        public synchronized void setFid(long j) {
            this.mFid = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.cHM == 0 || !c.this.cHy.get()) {
                synchronized (c.this.cHy) {
                    try {
                        c.this.cHy.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            axH();
        }

        private void axH() {
            this.cHN = true;
            List<com.baidu.tbadk.BdToken.b> list = (List) c.this.cHv.get(com.baidu.tbadk.BdToken.b.cGK);
            List<com.baidu.tbadk.BdToken.b> list2 = (List) c.this.cHv.get(this.cHM);
            if (com.baidu.tbadk.core.util.v.isEmpty(list) && com.baidu.tbadk.core.util.v.isEmpty(list2)) {
                c.this.cHy.compareAndSet(true, false);
                return;
            }
            d.b bVar = new d.b();
            bVar.cJE = new LinkedList();
            bVar.cJF = new LinkedList();
            bVar.cJG = new LinkedList();
            a(list, bVar);
            b(list2, bVar);
            if (this.cHN) {
                c.this.cHy.compareAndSet(true, false);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(bVar.cJG)) {
                com.baidu.tbadk.BdToken.a.awV().ap(bVar.cJG);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(bVar.cJE) || !com.baidu.tbadk.core.util.v.isEmpty(bVar.cJF)) {
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
            ArrayList<com.baidu.tbadk.BdToken.h> awY;
            if (bVar != null && bVar2 != null && (awY = bVar.awY()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = awY.iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if ((next instanceof l) && !((l) next).isTimeout() && !next.aW()) {
                        this.cHN = false;
                        next.jm(1);
                        if (next.axV() >= next.axU().axp()) {
                            next.fj(true);
                            bVar2.s(bVar);
                        }
                        bVar2.t(bVar);
                    }
                }
            }
        }

        private void b(com.baidu.tbadk.BdToken.b bVar, d.b bVar2) {
            ArrayList<com.baidu.tbadk.BdToken.h> awY;
            if (bVar != null && bVar2 != null && (awY = bVar.awY()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = awY.iterator();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof m) {
                        m mVar = (m) next;
                        if (this.cHe != 0 && mVar.getTid() == this.cHe && !next.aW()) {
                            this.cHN = false;
                            next.jm(1);
                            if (next.axV() >= next.axU().axp()) {
                                next.fj(true);
                                if (next.axU().axe() >= next.axU().getThreadNum()) {
                                    bVar2.c(next);
                                }
                            }
                            bVar2.t(bVar);
                        }
                    } else if (next instanceof k) {
                        k kVar = (k) next;
                        if (!bVar.axy() && kVar.getTag() == bVar.getTag()) {
                            if (this.cHe != 0 && kVar.getTid() == this.cHe && !next.aW()) {
                                this.cHN = false;
                                next.jm(1);
                            }
                            i = (int) (i + next.axV());
                            if (this.cHe != 0 && kVar.getTid() == this.cHe && !next.aW()) {
                                if (next.axV() >= bVar.axp()) {
                                    next.fj(true);
                                    bVar.axe();
                                }
                                bVar2.t(bVar);
                            }
                            int awZ = bVar.awZ();
                            int threadNum = bVar.getThreadNum();
                            if (i >= bVar.axp() * bVar.getThreadNum() && awZ >= threadNum) {
                                bVar2.s(bVar);
                                bVar.fi(true);
                            }
                        }
                    } else if (next instanceof j) {
                        if (this.mFid != 0 && ((j) next).getFid() == this.mFid && !next.aW()) {
                            this.cHN = false;
                            next.jm(1);
                            if (next.axV() >= next.axU().axp()) {
                                next.fj(true);
                                if (next.axU().axd() >= next.axU().axq()) {
                                    bVar2.c(next);
                                }
                            }
                        }
                    } else if ((next instanceof i) && !next.aW()) {
                        this.cHN = false;
                        next.jm(1);
                        if (next.axV() >= next.axU().axp()) {
                            next.fj(true);
                            bVar2.c(next);
                        }
                    }
                }
            }
        }
    }
}
