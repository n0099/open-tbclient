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
    private boolean cDA;
    private boolean cDB;
    private com.baidu.tbadk.BdToken.completeTask.d cDC;
    private com.baidu.tbadk.BdToken.activeConfig.b cDD;
    private int cDE;
    private long cDF;
    private long cDG;
    private int cDH;
    private long cDI;
    private CustomMessageListener cDJ;
    private CustomMessageListener cDK;
    private CustomMessageListener cDL;
    private com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a> cDM;
    private com.baidu.tbadk.h.b cDN;
    private final ScheduledExecutorService cDv;
    private final SparseArray<List<com.baidu.tbadk.BdToken.b>> cDw;
    private final LinkedList<com.baidu.tbadk.BdToken.b> cDx;
    private a cDy;
    private AtomicBoolean cDz;
    private BdUniqueId mBdUniqueId;

    public static final c avj() {
        return g.cDR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g {
        private static final c cDR = new c();
    }

    private c() {
        this.cDv = Executors.newSingleThreadScheduledExecutor();
        this.cDw = new SparseArray<>();
        this.cDx = new LinkedList<>();
        this.cDy = new a();
        this.cDz = new AtomicBoolean(false);
        this.cDA = false;
        this.cDB = false;
        this.cDJ = new CustomMessageListener(2921391) { // from class: com.baidu.tbadk.BdToken.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.cDA = true;
                if (!c.this.cDx.isEmpty()) {
                    Iterator it = c.this.cDx.iterator();
                    while (it.hasNext()) {
                        c.this.l((com.baidu.tbadk.BdToken.b) it.next());
                    }
                    c.this.cDx.clear();
                }
            }
        };
        this.cDK = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.BdToken.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                    ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                    c.this.avk();
                }
            }
        };
        this.cDL = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tbadk.BdToken.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                    c.this.cDB = true;
                    c.this.avk();
                }
            }
        };
        this.cDM = new com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a>() { // from class: com.baidu.tbadk.BdToken.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: a */
            public void onSuccess(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    com.baidu.tbadk.core.sharedPref.b.aDr().putLong("pref_key_active_config_info", currentTimeMillis);
                    c.this.cDI = currentTimeMillis;
                    c.this.ao(aVar.avX());
                }
            }

            @Override // com.baidu.tbadk.h.a
            public void onError(int i, String str) {
            }
        };
        this.cDN = new com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b>() { // from class: com.baidu.tbadk.BdToken.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.b
            /* renamed from: m */
            public void onProgressUpdate(com.baidu.tbadk.BdToken.b bVar) {
                if (bVar != null) {
                    com.baidu.tbadk.BdToken.b e2 = c.this.e(bVar);
                    if (e2 != null && e2.cDt) {
                        e2.reset();
                        c.this.j(e2);
                        return;
                    }
                    n.avI().o(e2);
                    if (e2 != null && e2.getTaskType() == 7) {
                        e2.auP();
                        int avh = e2.avh();
                        int tag = e2.getTag();
                        if (avh <= 1 || avh <= tag) {
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
        this.cDC = new com.baidu.tbadk.BdToken.completeTask.d(this.mBdUniqueId);
        this.cDC.a(this.cDN);
        this.cDD = new com.baidu.tbadk.BdToken.activeConfig.b(this.mBdUniqueId);
        this.cDD.a(this.cDM);
        this.cDL.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.cDL);
        this.cDK.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.cDK);
        this.cDJ.setPriority(Integer.MIN_VALUE);
        this.cDJ.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.cDJ);
        com.baidu.tbadk.core.f.a.aDo().init();
        p.avL().h(this.mBdUniqueId);
        startTimer();
        if (isMainProcess()) {
            new f().execute(new Void[0]);
        }
    }

    private boolean isMainProcess() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public void avk() {
        if (this.cDD != null && isMainProcess() && this.cDB && !avl()) {
            this.cDD.avZ();
        }
    }

    public boolean avl() {
        return UtilHelper.isSameDay(avm(), System.currentTimeMillis());
    }

    private long avm() {
        if (this.cDI == 0) {
            this.cDI = com.baidu.tbadk.core.sharedPref.b.aDr().getLong("pref_key_active_config_info", 0L);
        }
        return this.cDI;
    }

    public int avn() {
        return this.cDH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.BdToken.b e(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cDw.size()) {
                return null;
            }
            List<com.baidu.tbadk.BdToken.b> valueAt = this.cDw.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar2 : valueAt) {
                    if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.auT() == bVar.auT()) {
                        return bVar2;
                    }
                }
                continue;
            }
            i = i2 + 1;
        }
    }

    public void avo() {
        this.cDz.compareAndSet(true, false);
        this.cDy.iU(0);
        this.cDy.setTid(0L);
        this.cDy.setFid(0L);
        if (this.cDC != null) {
            this.cDC.awc();
        }
    }

    public void m(int i, long j) {
        if (isMainProcess()) {
            this.cDH = i;
            this.cDG = j;
            if (this.cDF > 0 && this.cDE > 0 && (j == 0 || j != this.cDF)) {
                n(this.cDE, this.cDF);
                this.cDF = 0L;
                this.cDE = 0;
            }
            avp();
        }
    }

    public void n(int i, long j) {
        k kVar;
        com.baidu.tbadk.BdToken.b avF;
        List<com.baidu.tbadk.BdToken.b> list = this.cDw.get(i);
        if (list != null && !list.isEmpty()) {
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 7) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.auI().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof k) && (avF = (kVar = (k) next).avF()) != null && kVar.getTid() == j && avF.getActivityId() == bVar.getActivityId() && avF.auT() == bVar.auT()) {
                                next.fc(true);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void o(int i, long j) {
        if (isMainProcess() && i != 0 && j != 0 && this.cDA) {
            this.cDE = i;
            List<com.baidu.tbadk.BdToken.b> list = this.cDw.get(i);
            if (list != null && !list.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 1) {
                        a(bVar, j);
                    } else if (bVar.getTaskType() != 7) {
                        continue;
                    } else if (bVar.bj(j)) {
                        break;
                    } else {
                        b(bVar, j);
                    }
                }
                this.cDy.iU(i);
                this.cDy.setTid(j);
                this.cDF = j;
                this.cDz.compareAndSet(false, true);
                synchronized (this.cDz) {
                    this.cDz.notify();
                }
            }
        }
    }

    private void a(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        m mVar;
        com.baidu.tbadk.BdToken.b avF;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.auI().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof m) && (avF = (mVar = (m) next).avF()) != null && mVar.getTid() == j && avF.getActivityId() == bVar.getActivityId() && avF.auT() == bVar.auT()) {
                z = true;
                break;
            }
        }
        if (!z) {
            m mVar2 = new m(bVar, j);
            mVar2.bo(0L);
            mVar2.fc(false);
            mVar2.iS(bVar.getTag());
            bVar.a(mVar2);
        }
    }

    private void b(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        k kVar;
        com.baidu.tbadk.BdToken.b avF;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.auI().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof k) && (avF = (kVar = (k) next).avF()) != null && kVar.getTid() == j && avF.getActivityId() == bVar.getActivityId() && avF.auT() == bVar.auT()) {
                z = true;
                break;
            }
        }
        if (!z) {
            k kVar2 = new k(bVar, j);
            kVar2.bo(0L);
            kVar2.fc(false);
            kVar2.iS(bVar.getTag());
            bVar.a(kVar2);
        }
    }

    public void p(int i, long j) {
        boolean z;
        if (isMainProcess() && i != 0 && j != 0 && this.cDA) {
            this.cDE = i;
            List<com.baidu.tbadk.BdToken.b> list = this.cDw.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 2) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.auI().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof j) && next.avF().getActivityId() == bVar.getActivityId() && next.avF().auT() == bVar.auT() && ((j) next).getFid() == j) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            j jVar = new j(bVar, j);
                            jVar.bo(0L);
                            jVar.fc(false);
                            jVar.iS(bVar.getTag());
                            bVar.a(jVar);
                        }
                        z2 = z;
                    }
                }
                this.cDy.iU(i);
                this.cDy.setFid(j);
                this.cDz.compareAndSet(false, true);
                synchronized (this.cDz) {
                    this.cDz.notify();
                }
            }
        }
    }

    public void iT(int i) {
        boolean z;
        if (isMainProcess() && i != 0 && this.cDA) {
            this.cDE = i;
            List<com.baidu.tbadk.BdToken.b> list = this.cDw.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 4) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.auI().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof i) && next.avF().getActivityId() == bVar.getActivityId() && next.avF().auT() == bVar.auT()) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            i iVar = new i(bVar);
                            iVar.bo(0L);
                            iVar.fc(false);
                            bVar.a(iVar);
                        }
                        z2 = z;
                    }
                }
                this.cDy.iU(i);
                this.cDz.compareAndSet(false, true);
                synchronized (this.cDz) {
                    this.cDz.notify();
                }
            }
        }
    }

    public void avp() {
        int i;
        List<com.baidu.tbadk.BdToken.b> list;
        boolean z;
        if (isMainProcess() && this.cDA && (list = this.cDw.get((i = com.baidu.tbadk.BdToken.b.cCL))) != null && !list.isEmpty()) {
            boolean z2 = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 8) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.auI().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = z2;
                            break;
                        }
                        com.baidu.tbadk.BdToken.h next = it.next();
                        com.baidu.tbadk.BdToken.b avF = next.avF();
                        if (avF != null && (next instanceof l) && avF.getActivityId() == bVar.getActivityId() && avF.auT() == bVar.auT()) {
                            ((l) next).avH();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        l lVar = new l(bVar);
                        lVar.bo(0L);
                        lVar.fc(false);
                        bVar.a(lVar);
                    }
                    z2 = z;
                }
            }
            this.cDy.iU(i);
            this.cDz.compareAndSet(false, true);
            synchronized (this.cDz) {
                this.cDz.notify();
            }
        }
    }

    private void startTimer() {
        this.cDv.scheduleWithFixedDelay(this.cDy, 0L, 1L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tbadk.BdToken.b bVar) {
        int[] auY;
        for (int i : bVar.auY()) {
            List<com.baidu.tbadk.BdToken.b> list = this.cDw.get(i);
            if (list == null) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(bVar);
                this.cDw.put(i, linkedList);
            } else {
                list.add(bVar);
            }
        }
    }

    private boolean g(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return false;
        }
        int[] auY = bVar.auY();
        if (auY == null) {
            return true;
        }
        for (int i : auY) {
            List<com.baidu.tbadk.BdToken.b> list = this.cDw.get(i);
            if (list == null) {
                return false;
            }
            for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.auT() == bVar.auT()) {
                    if (bVar2.auQ()) {
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
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.auI().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.avF() != null) {
                    com.baidu.tbadk.BdToken.b avF = next.avF();
                    if (avF.getActivityId() == bVar.getActivityId() && avF.auT() == bVar.auT()) {
                        if (taskType == 7 && (next instanceof k)) {
                            ((k) next).fc(true);
                        } else if (taskType == 1 && (next instanceof m)) {
                            ((m) next).fc(true);
                        }
                    }
                }
            }
            bVar.fb(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar != null) {
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.auI().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.avF() != null) {
                    com.baidu.tbadk.BdToken.b avF = next.avF();
                    if (avF.getActivityId() == bVar.getActivityId() && avF.auT() == bVar.auT()) {
                        it.remove();
                    }
                }
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.cDw.size()) {
                    List<com.baidu.tbadk.BdToken.b> valueAt = this.cDw.valueAt(i2);
                    if (valueAt != null && !valueAt.isEmpty()) {
                        Iterator<com.baidu.tbadk.BdToken.b> it2 = valueAt.iterator();
                        while (it2.hasNext()) {
                            com.baidu.tbadk.BdToken.b next2 = it2.next();
                            if (next2 != null && next2.getActivityId() == bVar.getActivityId() && next2.auT() == bVar.auT()) {
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
                p.avL().q(bVar);
            } else if (!this.cDA) {
                this.cDx.add(bVar);
            } else if (!g(bVar)) {
                f(bVar);
                new b().execute(bVar);
            }
        }
    }

    public void ao(List<com.baidu.tbadk.BdToken.b> list) {
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            if (!this.cDA) {
                this.cDx.addAll(list);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar != null) {
                    if (bVar.getTaskType() == 9) {
                        p.avL().q(bVar);
                    } else if (!g(bVar)) {
                        f(bVar);
                        arrayList.add(bVar);
                    }
                }
            }
            new C0361c().execute(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.BdToken.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0361c extends BdAsyncTask<List<com.baidu.tbadk.BdToken.b>, Integer, Void> {
        private C0361c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(List<com.baidu.tbadk.BdToken.b>... listArr) {
            if (listArr != null && listArr.length > 0 && listArr[0] != null) {
                com.baidu.tbadk.BdToken.a.auF().ao(listArr[0]);
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
            linkedList.addAll(com.baidu.tbadk.BdToken.a.auF().auG());
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next != null && next.auQ()) {
                    com.baidu.tbadk.BdToken.a.auF().c(next);
                    it.remove();
                } else if (next.getTaskType() == 7) {
                    next.auK();
                    com.baidu.tbadk.BdToken.a.auF().b(next);
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
                        if (next.auY() != null) {
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
                com.baidu.tbadk.BdToken.a.auF().a(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.auF().c(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.auF().c(bVar2);
            }
            if (bVar != null) {
                com.baidu.tbadk.BdToken.a.auF().a(bVar);
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
            com.baidu.tbadk.BdToken.a.auF().b(bVar);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(com.baidu.tbadk.BdToken.b bVar) {
            if (bVar != null && bVar.cDt) {
                bVar.cDt = false;
                c.this.o(c.this.cDE, c.this.cDF);
            }
        }
    }

    public void avq() {
        List<com.baidu.tbadk.BdToken.b> list = this.cDw.get(com.baidu.tbadk.BdToken.b.cCL);
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            boolean z = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bVar.auI().iterator();
                boolean z2 = z;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof l) {
                        l lVar = (l) next;
                        if (!next.aW()) {
                            lVar.avH();
                            z2 = true;
                        }
                    }
                }
                z = z2;
            }
            if (z && !this.cDz.get()) {
                this.cDy.iU(com.baidu.tbadk.BdToken.b.cCL);
                this.cDz.compareAndSet(false, true);
                synchronized (this.cDz) {
                    this.cDz.notify();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private volatile int cDP;
        private volatile boolean cDQ;
        private volatile long cDf;
        private volatile long mFid;

        private a() {
            this.cDQ = false;
        }

        public synchronized void iU(int i) {
            this.cDP = i;
        }

        public synchronized void setTid(long j) {
            this.cDf = j;
        }

        public synchronized void setFid(long j) {
            this.mFid = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.cDP == 0 || !c.this.cDz.get()) {
                synchronized (c.this.cDz) {
                    try {
                        c.this.cDz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            avr();
        }

        private void avr() {
            this.cDQ = true;
            List<com.baidu.tbadk.BdToken.b> list = (List) c.this.cDw.get(com.baidu.tbadk.BdToken.b.cCL);
            List<com.baidu.tbadk.BdToken.b> list2 = (List) c.this.cDw.get(this.cDP);
            if (com.baidu.tbadk.core.util.v.isEmpty(list) && com.baidu.tbadk.core.util.v.isEmpty(list2)) {
                c.this.cDz.compareAndSet(true, false);
                return;
            }
            d.b bVar = new d.b();
            bVar.cFz = new LinkedList();
            bVar.cFA = new LinkedList();
            bVar.cFB = new LinkedList();
            a(list, bVar);
            b(list2, bVar);
            if (this.cDQ) {
                c.this.cDz.compareAndSet(true, false);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(bVar.cFB)) {
                com.baidu.tbadk.BdToken.a.auF().ap(bVar.cFB);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(bVar.cFz) || !com.baidu.tbadk.core.util.v.isEmpty(bVar.cFA)) {
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
            ArrayList<com.baidu.tbadk.BdToken.h> auI;
            if (bVar != null && bVar2 != null && (auI = bVar.auI()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = auI.iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if ((next instanceof l) && !((l) next).isTimeout() && !next.aW()) {
                        this.cDQ = false;
                        next.iV(1);
                        if (next.avG() >= next.avF().auZ()) {
                            next.fc(true);
                            bVar2.s(bVar);
                        }
                        bVar2.t(bVar);
                    }
                }
            }
        }

        private void b(com.baidu.tbadk.BdToken.b bVar, d.b bVar2) {
            ArrayList<com.baidu.tbadk.BdToken.h> auI;
            if (bVar != null && bVar2 != null && (auI = bVar.auI()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = auI.iterator();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof m) {
                        m mVar = (m) next;
                        if (this.cDf != 0 && mVar.getTid() == this.cDf && !next.aW()) {
                            this.cDQ = false;
                            next.iV(1);
                            if (next.avG() >= next.avF().auZ()) {
                                next.fc(true);
                                if (next.avF().auO() >= next.avF().getThreadNum()) {
                                    bVar2.c(next);
                                }
                            }
                            bVar2.t(bVar);
                        }
                    } else if (next instanceof k) {
                        k kVar = (k) next;
                        if (!bVar.avi() && kVar.getTag() == bVar.getTag()) {
                            if (this.cDf != 0 && kVar.getTid() == this.cDf && !next.aW()) {
                                this.cDQ = false;
                                next.iV(1);
                            }
                            i = (int) (i + next.avG());
                            if (this.cDf != 0 && kVar.getTid() == this.cDf && !next.aW()) {
                                if (next.avG() >= bVar.auZ()) {
                                    next.fc(true);
                                    bVar.auO();
                                }
                                bVar2.t(bVar);
                            }
                            int auJ = bVar.auJ();
                            int threadNum = bVar.getThreadNum();
                            if (i >= bVar.auZ() * bVar.getThreadNum() && auJ >= threadNum) {
                                bVar2.s(bVar);
                                bVar.fb(true);
                            }
                        }
                    } else if (next instanceof j) {
                        if (this.mFid != 0 && ((j) next).getFid() == this.mFid && !next.aW()) {
                            this.cDQ = false;
                            next.iV(1);
                            if (next.avG() >= next.avF().auZ()) {
                                next.fc(true);
                                if (next.avF().auN() >= next.avF().ava()) {
                                    bVar2.c(next);
                                }
                            }
                        }
                    } else if ((next instanceof i) && !next.aW()) {
                        this.cDQ = false;
                        next.iV(1);
                        if (next.avG() >= next.avF().auZ()) {
                            next.fc(true);
                            bVar2.c(next);
                        }
                    }
                }
            }
        }
    }
}
