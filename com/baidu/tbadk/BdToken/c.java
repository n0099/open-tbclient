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
    private final ScheduledExecutorService ekS;
    private final SparseArray<List<com.baidu.tbadk.BdToken.b>> ekT;
    private final LinkedList<com.baidu.tbadk.BdToken.b> ekU;
    private a ekV;
    private AtomicBoolean ekW;
    private boolean ekX;
    private boolean ekY;
    private com.baidu.tbadk.BdToken.completeTask.d ekZ;
    private com.baidu.tbadk.BdToken.activeConfig.b ela;
    private com.baidu.tbadk.BdToken.backUser.b elb;
    private int elc;
    private long eld;
    private long ele;
    private int elf;
    private long elg;
    private CustomMessageListener elh;
    private com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a> eli;
    private com.baidu.tbadk.h.b elj;
    private boolean isSchemaUp;
    private CustomMessageListener mBackgroundListener;
    private BdUniqueId mBdUniqueId;
    private CustomMessageListener mSyncFinishListener;

    public static final c bdF() {
        return g.eln;
    }

    /* loaded from: classes.dex */
    private static class g {
        private static final c eln = new c();
    }

    private c() {
        this.ekS = Executors.newSingleThreadScheduledExecutor();
        this.ekT = new SparseArray<>();
        this.ekU = new LinkedList<>();
        this.ekV = new a();
        this.ekW = new AtomicBoolean(false);
        this.ekX = false;
        this.ekY = false;
        this.isSchemaUp = false;
        this.elh = new CustomMessageListener(2921391) { // from class: com.baidu.tbadk.BdToken.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.ekX = true;
                if (!c.this.ekU.isEmpty()) {
                    Iterator it = c.this.ekU.iterator();
                    while (it.hasNext()) {
                        c.this.l((com.baidu.tbadk.BdToken.b) it.next());
                    }
                    c.this.ekU.clear();
                }
            }
        };
        this.mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.BdToken.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                    ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                    c.this.bdH();
                }
            }
        };
        this.mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tbadk.BdToken.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                    c.this.ekY = true;
                    c.this.bdH();
                }
            }
        };
        this.eli = new com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a>() { // from class: com.baidu.tbadk.BdToken.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: a */
            public void onSuccess(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null) {
                    c.this.aT(aVar.beP());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: b */
            public void aq(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null && aVar.eno != null && aVar.eno.mission != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b();
                    bVar.a(aVar.eno.mission);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(bVar);
                    c.this.aT(arrayList);
                }
            }

            @Override // com.baidu.tbadk.h.a
            public void onError(int i, String str) {
            }
        };
        this.elj = new com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b>() { // from class: com.baidu.tbadk.BdToken.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.b
            /* renamed from: m */
            public void onProgressUpdate(com.baidu.tbadk.BdToken.b bVar) {
                if (bVar != null) {
                    com.baidu.tbadk.BdToken.b e2 = c.this.e(bVar);
                    if (e2 != null && e2.ekQ) {
                        e2.reset();
                        c.this.j(e2);
                        return;
                    }
                    n.beh().o(e2);
                    if (e2 != null && e2.getTaskType() == 7) {
                        e2.bdl();
                        int bdD = e2.bdD();
                        int tag = e2.getTag();
                        if (bdD <= 1 || bdD <= tag) {
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
        this.ekZ = new com.baidu.tbadk.BdToken.completeTask.d(this.mBdUniqueId);
        this.ekZ.a(this.elj);
        this.ela = new com.baidu.tbadk.BdToken.activeConfig.b(this.mBdUniqueId);
        this.ela.a(this.eli);
        this.elb = new com.baidu.tbadk.BdToken.backUser.b(this.mBdUniqueId);
        this.mSyncFinishListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        this.mBackgroundListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mBackgroundListener);
        this.elh.setPriority(Integer.MIN_VALUE);
        this.elh.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.elh);
        com.baidu.tbadk.core.f.a.bnD().init();
        p.bek().i(this.mBdUniqueId);
        startTimer();
        if (isMainProcess()) {
            new f().execute(new Void[0]);
        }
    }

    private boolean isMainProcess() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public void bdG() {
        if (this.elb != null && isMainProcess()) {
            this.elb.beT();
        }
    }

    public void bdH() {
        if (this.ela != null && isMainProcess() && this.ekY && !bdL()) {
            this.ela.c(bdJ(), bdK(), 0);
        }
    }

    public boolean bdI() {
        if (this.ela != null && isMainProcess()) {
            this.ela.c(bdJ(), bdK(), 1);
            return true;
        }
        return false;
    }

    public boolean bdJ() {
        return !bdM();
    }

    public boolean bdK() {
        return this.isSchemaUp;
    }

    public void setSchemaUp(boolean z) {
        this.isSchemaUp = z;
    }

    public boolean bdL() {
        return UtilHelper.isSameDay(bdO(), System.currentTimeMillis());
    }

    public boolean bdM() {
        return UtilHelper.isSameDay(com.baidu.tbadk.core.sharedPref.b.bnH().getLong("pref_key_last_active_config", 0L), System.currentTimeMillis());
    }

    public boolean bdN() {
        return UtilHelper.isSameDay(com.baidu.tbadk.core.sharedPref.b.bnH().getLong("pref_key_last_popup_time", 0L), System.currentTimeMillis());
    }

    private long bdO() {
        this.elg = com.baidu.tbadk.core.sharedPref.b.bnH().getLong("pref_key_active_config_info", 0L);
        return this.elg;
    }

    public int bdP() {
        return this.elf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.BdToken.b e(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.ekT.size()) {
                return null;
            }
            List<com.baidu.tbadk.BdToken.b> valueAt = this.ekT.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar2 : valueAt) {
                    if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.bdp() == bVar.bdp()) {
                        return bVar2;
                    }
                }
                continue;
            }
            i = i2 + 1;
        }
    }

    public void bdQ() {
        this.ekW.compareAndSet(true, false);
        this.ekV.nx(0);
        this.ekV.setTid(0L);
        this.ekV.setFid(0L);
        if (this.ekZ != null) {
            this.ekZ.beW();
        }
    }

    public void o(int i, long j) {
        if (isMainProcess()) {
            this.elf = i;
            this.ele = j;
            if (this.eld > 0 && this.elc > 0 && (j == 0 || j != this.eld)) {
                p(this.elc, this.eld);
                this.eld = 0L;
                this.elc = 0;
            }
            bdR();
        }
    }

    public void p(int i, long j) {
        k kVar;
        com.baidu.tbadk.BdToken.b bee;
        List<com.baidu.tbadk.BdToken.b> list = this.ekT.get(i);
        if (list != null && !list.isEmpty()) {
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 7) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bde().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof k) && (bee = (kVar = (k) next).bee()) != null && kVar.getTid() == j && bee.getActivityId() == bVar.getActivityId() && bee.bdp() == bVar.bdp()) {
                                next.ic(true);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void q(int i, long j) {
        if (isMainProcess() && i != 0 && j != 0 && this.ekX) {
            this.elc = i;
            List<com.baidu.tbadk.BdToken.b> list = this.ekT.get(i);
            if (list != null && !list.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 1) {
                        a(bVar, j);
                    } else if (bVar.getTaskType() != 7) {
                        continue;
                    } else if (bVar.cC(j)) {
                        break;
                    } else {
                        b(bVar, j);
                    }
                }
                this.ekV.nx(i);
                this.ekV.setTid(j);
                this.eld = j;
                this.ekW.compareAndSet(false, true);
                synchronized (this.ekW) {
                    this.ekW.notify();
                }
            }
        }
    }

    private void a(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        m mVar;
        com.baidu.tbadk.BdToken.b bee;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bde().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof m) && (bee = (mVar = (m) next).bee()) != null && mVar.getTid() == j && bee.getActivityId() == bVar.getActivityId() && bee.bdp() == bVar.bdp()) {
                z = true;
                break;
            }
        }
        if (!z) {
            m mVar2 = new m(bVar, j);
            mVar2.cH(0L);
            mVar2.ic(false);
            mVar2.nv(bVar.getTag());
            bVar.a(mVar2);
        }
    }

    private void b(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        k kVar;
        com.baidu.tbadk.BdToken.b bee;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bde().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof k) && (bee = (kVar = (k) next).bee()) != null && kVar.getTid() == j && bee.getActivityId() == bVar.getActivityId() && bee.bdp() == bVar.bdp()) {
                z = true;
                break;
            }
        }
        if (!z) {
            k kVar2 = new k(bVar, j);
            kVar2.cH(0L);
            kVar2.ic(false);
            kVar2.nv(bVar.getTag());
            bVar.a(kVar2);
        }
    }

    public void r(int i, long j) {
        boolean z;
        if (isMainProcess() && i != 0 && j != 0 && this.ekX) {
            this.elc = i;
            List<com.baidu.tbadk.BdToken.b> list = this.ekT.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 2) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bde().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof j) && next.bee().getActivityId() == bVar.getActivityId() && next.bee().bdp() == bVar.bdp() && ((j) next).getFid() == j) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            j jVar = new j(bVar, j);
                            jVar.cH(0L);
                            jVar.ic(false);
                            jVar.nv(bVar.getTag());
                            bVar.a(jVar);
                        }
                        z2 = z;
                    }
                }
                this.ekV.nx(i);
                this.ekV.setFid(j);
                this.ekW.compareAndSet(false, true);
                synchronized (this.ekW) {
                    this.ekW.notify();
                }
            }
        }
    }

    public void nw(int i) {
        boolean z;
        if (isMainProcess() && i != 0 && this.ekX) {
            this.elc = i;
            List<com.baidu.tbadk.BdToken.b> list = this.ekT.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 4) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bde().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof i) && next.bee().getActivityId() == bVar.getActivityId() && next.bee().bdp() == bVar.bdp()) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            i iVar = new i(bVar);
                            iVar.cH(0L);
                            iVar.ic(false);
                            bVar.a(iVar);
                        }
                        z2 = z;
                    }
                }
                this.ekV.nx(i);
                this.ekW.compareAndSet(false, true);
                synchronized (this.ekW) {
                    this.ekW.notify();
                }
            }
        }
    }

    public void bdR() {
        int i;
        List<com.baidu.tbadk.BdToken.b> list;
        boolean z;
        if (isMainProcess() && this.ekX && (list = this.ekT.get((i = com.baidu.tbadk.BdToken.b.eki))) != null && !list.isEmpty()) {
            boolean z2 = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 8) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bde().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = z2;
                            break;
                        }
                        com.baidu.tbadk.BdToken.h next = it.next();
                        com.baidu.tbadk.BdToken.b bee = next.bee();
                        if (bee != null && (next instanceof l) && bee.getActivityId() == bVar.getActivityId() && bee.bdp() == bVar.bdp()) {
                            ((l) next).beg();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        l lVar = new l(bVar);
                        lVar.cH(0L);
                        lVar.ic(false);
                        bVar.a(lVar);
                    }
                    z2 = z;
                }
            }
            this.ekV.nx(i);
            this.ekW.compareAndSet(false, true);
            synchronized (this.ekW) {
                this.ekW.notify();
            }
        }
    }

    private void startTimer() {
        this.ekS.scheduleWithFixedDelay(this.ekV, 0L, 1L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tbadk.BdToken.b bVar) {
        int[] bdu;
        for (int i : bVar.bdu()) {
            List<com.baidu.tbadk.BdToken.b> list = this.ekT.get(i);
            if (list == null) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(bVar);
                this.ekT.put(i, linkedList);
            } else {
                list.add(bVar);
            }
        }
    }

    private boolean g(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return false;
        }
        int[] bdu = bVar.bdu();
        if (bdu == null) {
            return true;
        }
        for (int i : bdu) {
            List<com.baidu.tbadk.BdToken.b> list = this.ekT.get(i);
            if (list == null) {
                return false;
            }
            for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.bdp() == bVar.bdp()) {
                    if (bVar2.bdm()) {
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
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bde().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.bee() != null) {
                    com.baidu.tbadk.BdToken.b bee = next.bee();
                    if (bee.getActivityId() == bVar.getActivityId() && bee.bdp() == bVar.bdp()) {
                        if (taskType == 7 && (next instanceof k)) {
                            ((k) next).ic(true);
                        } else if (taskType == 1 && (next instanceof m)) {
                            ((m) next).ic(true);
                        }
                    }
                }
            }
            bVar.ib(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar != null) {
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bde().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.bee() != null) {
                    com.baidu.tbadk.BdToken.b bee = next.bee();
                    if (bee.getActivityId() == bVar.getActivityId() && bee.bdp() == bVar.bdp()) {
                        it.remove();
                    }
                }
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ekT.size()) {
                    List<com.baidu.tbadk.BdToken.b> valueAt = this.ekT.valueAt(i2);
                    if (valueAt != null && !valueAt.isEmpty()) {
                        Iterator<com.baidu.tbadk.BdToken.b> it2 = valueAt.iterator();
                        while (it2.hasNext()) {
                            com.baidu.tbadk.BdToken.b next2 = it2.next();
                            if (next2 != null && next2.getActivityId() == bVar.getActivityId() && next2.bdp() == bVar.bdp()) {
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
                p.bek().q(bVar);
            } else if (!this.ekX) {
                this.ekU.add(bVar);
            } else if (!g(bVar)) {
                f(bVar);
                new b().execute(bVar);
            }
        }
    }

    public void aT(List<com.baidu.tbadk.BdToken.b> list) {
        if (!y.isEmpty(list)) {
            if (!this.ekX) {
                this.ekU.addAll(list);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar != null) {
                    if (bVar.getTaskType() == 9) {
                        p.bek().q(bVar);
                    } else if (!g(bVar)) {
                        f(bVar);
                        arrayList.add(bVar);
                    }
                }
            }
            new C0558c().execute(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.BdToken.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0558c extends BdAsyncTask<List<com.baidu.tbadk.BdToken.b>, Integer, Void> {
        private C0558c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(List<com.baidu.tbadk.BdToken.b>... listArr) {
            if (listArr != null && listArr.length > 0 && listArr[0] != null) {
                com.baidu.tbadk.BdToken.a.bdb().aT(listArr[0]);
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
            linkedList.addAll(com.baidu.tbadk.BdToken.a.bdb().bdc());
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next != null && next.bdm()) {
                    com.baidu.tbadk.BdToken.a.bdb().c(next);
                    it.remove();
                } else if (next.getTaskType() == 7) {
                    next.bdg();
                    com.baidu.tbadk.BdToken.a.bdb().b(next);
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
                        if (next.bdu() != null) {
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
                com.baidu.tbadk.BdToken.a.bdb().a(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.bdb().c(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.bdb().c(bVar2);
            }
            if (bVar != null) {
                com.baidu.tbadk.BdToken.a.bdb().a(bVar);
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
            com.baidu.tbadk.BdToken.a.bdb().b(bVar);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(com.baidu.tbadk.BdToken.b bVar) {
            if (bVar != null && bVar.ekQ) {
                bVar.ekQ = false;
                c.this.q(c.this.elc, c.this.eld);
            }
        }
    }

    public void bdS() {
        List<com.baidu.tbadk.BdToken.b> list = this.ekT.get(com.baidu.tbadk.BdToken.b.eki);
        if (!y.isEmpty(list)) {
            boolean z = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bde().iterator();
                boolean z2 = z;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof l) {
                        l lVar = (l) next;
                        if (!next.ik()) {
                            lVar.beg();
                            z2 = true;
                        }
                    }
                }
                z = z2;
            }
            if (z && !this.ekW.get()) {
                this.ekV.nx(com.baidu.tbadk.BdToken.b.eki);
                this.ekW.compareAndSet(false, true);
                synchronized (this.ekW) {
                    this.ekW.notify();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private volatile long ekC;
        private volatile int ell;
        private volatile boolean elm;
        private volatile long mFid;

        private a() {
            this.elm = false;
        }

        public synchronized void nx(int i) {
            this.ell = i;
        }

        public synchronized void setTid(long j) {
            this.ekC = j;
        }

        public synchronized void setFid(long j) {
            this.mFid = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.ell == 0 || !c.this.ekW.get()) {
                synchronized (c.this.ekW) {
                    try {
                        c.this.ekW.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            bdT();
        }

        private void bdT() {
            this.elm = true;
            List<com.baidu.tbadk.BdToken.b> list = (List) c.this.ekT.get(com.baidu.tbadk.BdToken.b.eki);
            List<com.baidu.tbadk.BdToken.b> list2 = (List) c.this.ekT.get(this.ell);
            if (y.isEmpty(list) && y.isEmpty(list2)) {
                c.this.ekW.compareAndSet(true, false);
                return;
            }
            d.b bVar = new d.b();
            bVar.enO = new LinkedList();
            bVar.enP = new LinkedList();
            bVar.enQ = new LinkedList();
            a(list, bVar);
            b(list2, bVar);
            if (this.elm) {
                c.this.ekW.compareAndSet(true, false);
            }
            if (!y.isEmpty(bVar.enQ)) {
                com.baidu.tbadk.BdToken.a.bdb().aU(bVar.enQ);
            }
            if (!y.isEmpty(bVar.enO) || !y.isEmpty(bVar.enP)) {
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
            ArrayList<com.baidu.tbadk.BdToken.h> bde;
            if (bVar != null && bVar2 != null && (bde = bVar.bde()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bde.iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if ((next instanceof l) && !((l) next).isTimeout() && !next.ik()) {
                        this.elm = false;
                        next.ny(1);
                        if (next.bef() >= next.bee().bdv()) {
                            next.ic(true);
                            bVar2.s(bVar);
                        }
                        bVar2.t(bVar);
                    }
                }
            }
        }

        private void b(com.baidu.tbadk.BdToken.b bVar, d.b bVar2) {
            ArrayList<com.baidu.tbadk.BdToken.h> bde;
            if (bVar != null && bVar2 != null && (bde = bVar.bde()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bde.iterator();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof m) {
                        m mVar = (m) next;
                        if (this.ekC != 0 && mVar.getTid() == this.ekC && !next.ik()) {
                            this.elm = false;
                            next.ny(1);
                            if (next.bef() >= next.bee().bdv()) {
                                next.ic(true);
                                if (next.bee().bdk() >= next.bee().getThreadNum()) {
                                    bVar2.c(next);
                                }
                            }
                            bVar2.t(bVar);
                        }
                    } else if (next instanceof k) {
                        k kVar = (k) next;
                        if (!bVar.bdE() && kVar.getTag() == bVar.getTag()) {
                            if (this.ekC != 0 && kVar.getTid() == this.ekC && !next.ik()) {
                                this.elm = false;
                                next.ny(1);
                            }
                            i = (int) (i + next.bef());
                            if (this.ekC != 0 && kVar.getTid() == this.ekC && !next.ik()) {
                                if (next.bef() >= bVar.bdv()) {
                                    next.ic(true);
                                    bVar.bdk();
                                }
                                bVar2.t(bVar);
                            }
                            int bdf = bVar.bdf();
                            int threadNum = bVar.getThreadNum();
                            if (i >= bVar.bdv() * bVar.getThreadNum() && bdf >= threadNum) {
                                bVar2.s(bVar);
                                bVar.ib(true);
                            }
                        }
                    } else if (next instanceof j) {
                        if (this.mFid != 0 && ((j) next).getFid() == this.mFid && !next.ik()) {
                            this.elm = false;
                            next.ny(1);
                            if (next.bef() >= next.bee().bdv()) {
                                next.ic(true);
                                if (next.bee().bdj() >= next.bee().bdw()) {
                                    bVar2.c(next);
                                }
                            }
                        }
                    } else if ((next instanceof i) && !next.ik()) {
                        this.elm = false;
                        next.ny(1);
                        if (next.bef() >= next.bee().bdv()) {
                            next.ic(true);
                            bVar2.c(next);
                        }
                    }
                }
            }
        }
    }
}
