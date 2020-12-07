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
    private final ScheduledExecutorService ewe;
    private final SparseArray<List<com.baidu.tbadk.BdToken.b>> ewf;
    private final LinkedList<com.baidu.tbadk.BdToken.b> ewg;
    private a ewh;
    private AtomicBoolean ewi;
    private boolean ewj;
    private boolean ewk;
    private com.baidu.tbadk.BdToken.completeTask.d ewl;
    private com.baidu.tbadk.BdToken.activeConfig.b ewm;
    private com.baidu.tbadk.BdToken.backUser.b ewn;
    private int ewo;
    private long ewp;
    private long ewq;
    private int ewr;
    private long ews;
    private CustomMessageListener ewt;
    private com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a> ewu;
    private com.baidu.tbadk.h.b ewv;
    private boolean isSchemaUp;
    private CustomMessageListener mBackgroundListener;
    private BdUniqueId mBdUniqueId;
    private CustomMessageListener mSyncFinishListener;

    public static final c biD() {
        return g.ewz;
    }

    /* loaded from: classes.dex */
    private static class g {
        private static final c ewz = new c();
    }

    private c() {
        this.ewe = Executors.newSingleThreadScheduledExecutor();
        this.ewf = new SparseArray<>();
        this.ewg = new LinkedList<>();
        this.ewh = new a();
        this.ewi = new AtomicBoolean(false);
        this.ewj = false;
        this.ewk = false;
        this.isSchemaUp = false;
        this.ewt = new CustomMessageListener(2921391) { // from class: com.baidu.tbadk.BdToken.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.ewj = true;
                if (!c.this.ewg.isEmpty()) {
                    Iterator it = c.this.ewg.iterator();
                    while (it.hasNext()) {
                        c.this.l((com.baidu.tbadk.BdToken.b) it.next());
                    }
                    c.this.ewg.clear();
                }
            }
        };
        this.mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.BdToken.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                    ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                    c.this.biF();
                }
            }
        };
        this.mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tbadk.BdToken.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                    c.this.ewk = true;
                    c.this.biF();
                }
            }
        };
        this.ewu = new com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a>() { // from class: com.baidu.tbadk.BdToken.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: a */
            public void onSuccess(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null) {
                    c.this.bd(aVar.bjN());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: b */
            public void aq(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null && aVar.eyG != null && aVar.eyG.mission != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b();
                    bVar.a(aVar.eyG.mission);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(bVar);
                    c.this.bd(arrayList);
                }
            }

            @Override // com.baidu.tbadk.h.a
            public void onError(int i, String str) {
            }
        };
        this.ewv = new com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b>() { // from class: com.baidu.tbadk.BdToken.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.b
            /* renamed from: m */
            public void onProgressUpdate(com.baidu.tbadk.BdToken.b bVar) {
                if (bVar != null) {
                    com.baidu.tbadk.BdToken.b e2 = c.this.e(bVar);
                    if (e2 != null && e2.ewc) {
                        e2.reset();
                        c.this.j(e2);
                        return;
                    }
                    n.bjf().o(e2);
                    if (e2 != null && e2.getTaskType() == 7) {
                        e2.bij();
                        int biB = e2.biB();
                        int tag = e2.getTag();
                        if (biB <= 1 || biB <= tag) {
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
        this.ewl = new com.baidu.tbadk.BdToken.completeTask.d(this.mBdUniqueId);
        this.ewl.a(this.ewv);
        this.ewm = new com.baidu.tbadk.BdToken.activeConfig.b(this.mBdUniqueId);
        this.ewm.a(this.ewu);
        this.ewn = new com.baidu.tbadk.BdToken.backUser.b(this.mBdUniqueId);
        this.mSyncFinishListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        this.mBackgroundListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mBackgroundListener);
        this.ewt.setPriority(Integer.MIN_VALUE);
        this.ewt.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.ewt);
        com.baidu.tbadk.core.f.a.bsK().init();
        p.bji().i(this.mBdUniqueId);
        startTimer();
        if (isMainProcess()) {
            new f().execute(new Void[0]);
        }
    }

    private boolean isMainProcess() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public void biE() {
        if (this.ewn != null && isMainProcess()) {
            this.ewn.bjR();
        }
    }

    public void biF() {
        if (this.ewm != null && isMainProcess() && this.ewk && !biJ()) {
            this.ewm.c(biH(), biI(), 0);
        }
    }

    public boolean biG() {
        if (this.ewm != null && isMainProcess()) {
            this.ewm.c(biH(), biI(), 1);
            return true;
        }
        return false;
    }

    public boolean biH() {
        return !biK();
    }

    public boolean biI() {
        return this.isSchemaUp;
    }

    public void setSchemaUp(boolean z) {
        this.isSchemaUp = z;
    }

    public boolean biJ() {
        return UtilHelper.isSameDay(biM(), System.currentTimeMillis());
    }

    public boolean biK() {
        return UtilHelper.isSameDay(com.baidu.tbadk.core.sharedPref.b.bsO().getLong("pref_key_last_active_config", 0L), System.currentTimeMillis());
    }

    public boolean biL() {
        return UtilHelper.isSameDay(com.baidu.tbadk.core.sharedPref.b.bsO().getLong("pref_key_last_popup_time", 0L), System.currentTimeMillis());
    }

    private long biM() {
        this.ews = com.baidu.tbadk.core.sharedPref.b.bsO().getLong("pref_key_active_config_info", 0L);
        return this.ews;
    }

    public int biN() {
        return this.ewr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.BdToken.b e(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.ewf.size()) {
                return null;
            }
            List<com.baidu.tbadk.BdToken.b> valueAt = this.ewf.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar2 : valueAt) {
                    if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.bin() == bVar.bin()) {
                        return bVar2;
                    }
                }
                continue;
            }
            i = i2 + 1;
        }
    }

    public void biO() {
        this.ewi.compareAndSet(true, false);
        this.ewh.ob(0);
        this.ewh.setTid(0L);
        this.ewh.setFid(0L);
        if (this.ewl != null) {
            this.ewl.bjU();
        }
    }

    public void n(int i, long j) {
        if (isMainProcess()) {
            this.ewr = i;
            this.ewq = j;
            if (this.ewp > 0 && this.ewo > 0 && (j == 0 || j != this.ewp)) {
                o(this.ewo, this.ewp);
                this.ewp = 0L;
                this.ewo = 0;
            }
            biP();
        }
    }

    public void o(int i, long j) {
        k kVar;
        com.baidu.tbadk.BdToken.b bjc;
        List<com.baidu.tbadk.BdToken.b> list = this.ewf.get(i);
        if (list != null && !list.isEmpty()) {
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 7) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bic().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof k) && (bjc = (kVar = (k) next).bjc()) != null && kVar.getTid() == j && bjc.getActivityId() == bVar.getActivityId() && bjc.bin() == bVar.bin()) {
                                next.iD(true);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void p(int i, long j) {
        if (isMainProcess() && i != 0 && j != 0 && this.ewj) {
            this.ewo = i;
            List<com.baidu.tbadk.BdToken.b> list = this.ewf.get(i);
            if (list != null && !list.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 1) {
                        a(bVar, j);
                    } else if (bVar.getTaskType() != 7) {
                        continue;
                    } else if (bVar.dx(j)) {
                        break;
                    } else {
                        b(bVar, j);
                    }
                }
                this.ewh.ob(i);
                this.ewh.setTid(j);
                this.ewp = j;
                this.ewi.compareAndSet(false, true);
                synchronized (this.ewi) {
                    this.ewi.notify();
                }
            }
        }
    }

    private void a(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        m mVar;
        com.baidu.tbadk.BdToken.b bjc;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bic().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof m) && (bjc = (mVar = (m) next).bjc()) != null && mVar.getTid() == j && bjc.getActivityId() == bVar.getActivityId() && bjc.bin() == bVar.bin()) {
                z = true;
                break;
            }
        }
        if (!z) {
            m mVar2 = new m(bVar, j);
            mVar2.dC(0L);
            mVar2.iD(false);
            mVar2.nZ(bVar.getTag());
            bVar.a(mVar2);
        }
    }

    private void b(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        k kVar;
        com.baidu.tbadk.BdToken.b bjc;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bic().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof k) && (bjc = (kVar = (k) next).bjc()) != null && kVar.getTid() == j && bjc.getActivityId() == bVar.getActivityId() && bjc.bin() == bVar.bin()) {
                z = true;
                break;
            }
        }
        if (!z) {
            k kVar2 = new k(bVar, j);
            kVar2.dC(0L);
            kVar2.iD(false);
            kVar2.nZ(bVar.getTag());
            bVar.a(kVar2);
        }
    }

    public void q(int i, long j) {
        boolean z;
        if (isMainProcess() && i != 0 && j != 0 && this.ewj) {
            this.ewo = i;
            List<com.baidu.tbadk.BdToken.b> list = this.ewf.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 2) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bic().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof j) && next.bjc().getActivityId() == bVar.getActivityId() && next.bjc().bin() == bVar.bin() && ((j) next).getFid() == j) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            j jVar = new j(bVar, j);
                            jVar.dC(0L);
                            jVar.iD(false);
                            jVar.nZ(bVar.getTag());
                            bVar.a(jVar);
                        }
                        z2 = z;
                    }
                }
                this.ewh.ob(i);
                this.ewh.setFid(j);
                this.ewi.compareAndSet(false, true);
                synchronized (this.ewi) {
                    this.ewi.notify();
                }
            }
        }
    }

    public void oa(int i) {
        boolean z;
        if (isMainProcess() && i != 0 && this.ewj) {
            this.ewo = i;
            List<com.baidu.tbadk.BdToken.b> list = this.ewf.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 4) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bic().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof i) && next.bjc().getActivityId() == bVar.getActivityId() && next.bjc().bin() == bVar.bin()) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            i iVar = new i(bVar);
                            iVar.dC(0L);
                            iVar.iD(false);
                            bVar.a(iVar);
                        }
                        z2 = z;
                    }
                }
                this.ewh.ob(i);
                this.ewi.compareAndSet(false, true);
                synchronized (this.ewi) {
                    this.ewi.notify();
                }
            }
        }
    }

    public void biP() {
        int i;
        List<com.baidu.tbadk.BdToken.b> list;
        boolean z;
        if (isMainProcess() && this.ewj && (list = this.ewf.get((i = com.baidu.tbadk.BdToken.b.evu))) != null && !list.isEmpty()) {
            boolean z2 = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 8) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bic().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = z2;
                            break;
                        }
                        com.baidu.tbadk.BdToken.h next = it.next();
                        com.baidu.tbadk.BdToken.b bjc = next.bjc();
                        if (bjc != null && (next instanceof l) && bjc.getActivityId() == bVar.getActivityId() && bjc.bin() == bVar.bin()) {
                            ((l) next).bje();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        l lVar = new l(bVar);
                        lVar.dC(0L);
                        lVar.iD(false);
                        bVar.a(lVar);
                    }
                    z2 = z;
                }
            }
            this.ewh.ob(i);
            this.ewi.compareAndSet(false, true);
            synchronized (this.ewi) {
                this.ewi.notify();
            }
        }
    }

    private void startTimer() {
        this.ewe.scheduleWithFixedDelay(this.ewh, 0L, 1L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tbadk.BdToken.b bVar) {
        int[] bis;
        for (int i : bVar.bis()) {
            List<com.baidu.tbadk.BdToken.b> list = this.ewf.get(i);
            if (list == null) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(bVar);
                this.ewf.put(i, linkedList);
            } else {
                list.add(bVar);
            }
        }
    }

    private boolean g(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return false;
        }
        int[] bis = bVar.bis();
        if (bis == null) {
            return true;
        }
        for (int i : bis) {
            List<com.baidu.tbadk.BdToken.b> list = this.ewf.get(i);
            if (list == null) {
                return false;
            }
            for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.bin() == bVar.bin()) {
                    if (bVar2.bik()) {
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
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bic().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.bjc() != null) {
                    com.baidu.tbadk.BdToken.b bjc = next.bjc();
                    if (bjc.getActivityId() == bVar.getActivityId() && bjc.bin() == bVar.bin()) {
                        if (taskType == 7 && (next instanceof k)) {
                            ((k) next).iD(true);
                        } else if (taskType == 1 && (next instanceof m)) {
                            ((m) next).iD(true);
                        }
                    }
                }
            }
            bVar.iC(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar != null) {
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bic().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.bjc() != null) {
                    com.baidu.tbadk.BdToken.b bjc = next.bjc();
                    if (bjc.getActivityId() == bVar.getActivityId() && bjc.bin() == bVar.bin()) {
                        it.remove();
                    }
                }
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ewf.size()) {
                    List<com.baidu.tbadk.BdToken.b> valueAt = this.ewf.valueAt(i2);
                    if (valueAt != null && !valueAt.isEmpty()) {
                        Iterator<com.baidu.tbadk.BdToken.b> it2 = valueAt.iterator();
                        while (it2.hasNext()) {
                            com.baidu.tbadk.BdToken.b next2 = it2.next();
                            if (next2 != null && next2.getActivityId() == bVar.getActivityId() && next2.bin() == bVar.bin()) {
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
                p.bji().q(bVar);
            } else if (!this.ewj) {
                this.ewg.add(bVar);
            } else if (!g(bVar)) {
                f(bVar);
                new b().execute(bVar);
            }
        }
    }

    public void bd(List<com.baidu.tbadk.BdToken.b> list) {
        if (!y.isEmpty(list)) {
            if (!this.ewj) {
                this.ewg.addAll(list);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar != null) {
                    if (bVar.getTaskType() == 9) {
                        p.bji().q(bVar);
                    } else if (!g(bVar)) {
                        f(bVar);
                        arrayList.add(bVar);
                    }
                }
            }
            new C0580c().execute(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.BdToken.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0580c extends BdAsyncTask<List<com.baidu.tbadk.BdToken.b>, Integer, Void> {
        private C0580c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(List<com.baidu.tbadk.BdToken.b>... listArr) {
            if (listArr != null && listArr.length > 0 && listArr[0] != null) {
                com.baidu.tbadk.BdToken.a.bhZ().bd(listArr[0]);
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
            linkedList.addAll(com.baidu.tbadk.BdToken.a.bhZ().bia());
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next != null && next.bik()) {
                    com.baidu.tbadk.BdToken.a.bhZ().c(next);
                    it.remove();
                } else if (next.getTaskType() == 7) {
                    next.bie();
                    com.baidu.tbadk.BdToken.a.bhZ().b(next);
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
                        if (next.bis() != null) {
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
                com.baidu.tbadk.BdToken.a.bhZ().a(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.bhZ().c(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.bhZ().c(bVar2);
            }
            if (bVar != null) {
                com.baidu.tbadk.BdToken.a.bhZ().a(bVar);
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
            com.baidu.tbadk.BdToken.a.bhZ().b(bVar);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(com.baidu.tbadk.BdToken.b bVar) {
            if (bVar != null && bVar.ewc) {
                bVar.ewc = false;
                c.this.p(c.this.ewo, c.this.ewp);
            }
        }
    }

    public void biQ() {
        List<com.baidu.tbadk.BdToken.b> list = this.ewf.get(com.baidu.tbadk.BdToken.b.evu);
        if (!y.isEmpty(list)) {
            boolean z = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bic().iterator();
                boolean z2 = z;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof l) {
                        l lVar = (l) next;
                        if (!next.ik()) {
                            lVar.bje();
                            z2 = true;
                        }
                    }
                }
                z = z2;
            }
            if (z && !this.ewi.get()) {
                this.ewh.ob(com.baidu.tbadk.BdToken.b.evu);
                this.ewi.compareAndSet(false, true);
                synchronized (this.ewi) {
                    this.ewi.notify();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private volatile long evO;
        private volatile int ewx;
        private volatile boolean ewy;
        private volatile long mFid;

        private a() {
            this.ewy = false;
        }

        public synchronized void ob(int i) {
            this.ewx = i;
        }

        public synchronized void setTid(long j) {
            this.evO = j;
        }

        public synchronized void setFid(long j) {
            this.mFid = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.ewx == 0 || !c.this.ewi.get()) {
                synchronized (c.this.ewi) {
                    try {
                        c.this.ewi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            biR();
        }

        private void biR() {
            this.ewy = true;
            List<com.baidu.tbadk.BdToken.b> list = (List) c.this.ewf.get(com.baidu.tbadk.BdToken.b.evu);
            List<com.baidu.tbadk.BdToken.b> list2 = (List) c.this.ewf.get(this.ewx);
            if (y.isEmpty(list) && y.isEmpty(list2)) {
                c.this.ewi.compareAndSet(true, false);
                return;
            }
            d.b bVar = new d.b();
            bVar.ezf = new LinkedList();
            bVar.ezg = new LinkedList();
            bVar.ezh = new LinkedList();
            a(list, bVar);
            b(list2, bVar);
            if (this.ewy) {
                c.this.ewi.compareAndSet(true, false);
            }
            if (!y.isEmpty(bVar.ezh)) {
                com.baidu.tbadk.BdToken.a.bhZ().be(bVar.ezh);
            }
            if (!y.isEmpty(bVar.ezf) || !y.isEmpty(bVar.ezg)) {
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
            ArrayList<com.baidu.tbadk.BdToken.h> bic;
            if (bVar != null && bVar2 != null && (bic = bVar.bic()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bic.iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if ((next instanceof l) && !((l) next).isTimeout() && !next.ik()) {
                        this.ewy = false;
                        next.oc(1);
                        if (next.bjd() >= next.bjc().bit()) {
                            next.iD(true);
                            bVar2.s(bVar);
                        }
                        bVar2.t(bVar);
                    }
                }
            }
        }

        private void b(com.baidu.tbadk.BdToken.b bVar, d.b bVar2) {
            ArrayList<com.baidu.tbadk.BdToken.h> bic;
            if (bVar != null && bVar2 != null && (bic = bVar.bic()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bic.iterator();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof m) {
                        m mVar = (m) next;
                        if (this.evO != 0 && mVar.getTid() == this.evO && !next.ik()) {
                            this.ewy = false;
                            next.oc(1);
                            if (next.bjd() >= next.bjc().bit()) {
                                next.iD(true);
                                if (next.bjc().bii() >= next.bjc().getThreadNum()) {
                                    bVar2.c(next);
                                }
                            }
                            bVar2.t(bVar);
                        }
                    } else if (next instanceof k) {
                        k kVar = (k) next;
                        if (!bVar.biC() && kVar.getTag() == bVar.getTag()) {
                            if (this.evO != 0 && kVar.getTid() == this.evO && !next.ik()) {
                                this.ewy = false;
                                next.oc(1);
                            }
                            i = (int) (i + next.bjd());
                            if (this.evO != 0 && kVar.getTid() == this.evO && !next.ik()) {
                                if (next.bjd() >= bVar.bit()) {
                                    next.iD(true);
                                    bVar.bii();
                                }
                                bVar2.t(bVar);
                            }
                            int bid = bVar.bid();
                            int threadNum = bVar.getThreadNum();
                            if (i >= bVar.bit() * bVar.getThreadNum() && bid >= threadNum) {
                                bVar2.s(bVar);
                                bVar.iC(true);
                            }
                        }
                    } else if (next instanceof j) {
                        if (this.mFid != 0 && ((j) next).getFid() == this.mFid && !next.ik()) {
                            this.ewy = false;
                            next.oc(1);
                            if (next.bjd() >= next.bjc().bit()) {
                                next.iD(true);
                                if (next.bjc().bih() >= next.bjc().biu()) {
                                    bVar2.c(next);
                                }
                            }
                        }
                    } else if ((next instanceof i) && !next.ik()) {
                        this.ewy = false;
                        next.oc(1);
                        if (next.bjd() >= next.bjc().bit()) {
                            next.iD(true);
                            bVar2.c(next);
                        }
                    }
                }
            }
        }
    }
}
