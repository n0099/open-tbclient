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
    private final ScheduledExecutorService eCO;
    private final SparseArray<List<com.baidu.tbadk.BdToken.b>> eCP;
    private final LinkedList<com.baidu.tbadk.BdToken.b> eCQ;
    private a eCR;
    private AtomicBoolean eCS;
    private boolean eCT;
    private boolean eCU;
    private com.baidu.tbadk.BdToken.completeTask.d eCV;
    private com.baidu.tbadk.BdToken.activeConfig.b eCW;
    private com.baidu.tbadk.BdToken.backUser.b eCX;
    private int eCY;
    private long eCZ;
    private long eDa;
    private int eDb;
    private long eDc;
    private CustomMessageListener eDd;
    private com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a> eDe;
    private com.baidu.tbadk.h.b eDf;
    private boolean isSchemaUp;
    private CustomMessageListener mBackgroundListener;
    private BdUniqueId mBdUniqueId;
    private CustomMessageListener mSyncFinishListener;

    public static final c bhn() {
        return g.eDj;
    }

    /* loaded from: classes.dex */
    private static class g {
        private static final c eDj = new c();
    }

    private c() {
        this.eCO = Executors.newSingleThreadScheduledExecutor();
        this.eCP = new SparseArray<>();
        this.eCQ = new LinkedList<>();
        this.eCR = new a();
        this.eCS = new AtomicBoolean(false);
        this.eCT = false;
        this.eCU = false;
        this.isSchemaUp = false;
        this.eDd = new CustomMessageListener(2921391) { // from class: com.baidu.tbadk.BdToken.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.eCT = true;
                if (!c.this.eCQ.isEmpty()) {
                    Iterator it = c.this.eCQ.iterator();
                    while (it.hasNext()) {
                        c.this.l((com.baidu.tbadk.BdToken.b) it.next());
                    }
                    c.this.eCQ.clear();
                }
            }
        };
        this.mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.BdToken.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                    ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                    c.this.bhp();
                }
            }
        };
        this.mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tbadk.BdToken.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                    c.this.eCU = true;
                    c.this.bhp();
                }
            }
        };
        this.eDe = new com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a>() { // from class: com.baidu.tbadk.BdToken.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: a */
            public void onSuccess(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null) {
                    c.this.bf(aVar.biw());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: b */
            public void as(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null && aVar.eFq != null && aVar.eFq.mission != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b();
                    bVar.a(aVar.eFq.mission);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(bVar);
                    c.this.bf(arrayList);
                }
            }

            @Override // com.baidu.tbadk.h.a
            public void onError(int i, String str) {
            }
        };
        this.eDf = new com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b>() { // from class: com.baidu.tbadk.BdToken.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.b
            /* renamed from: m */
            public void onProgressUpdate(com.baidu.tbadk.BdToken.b bVar) {
                if (bVar != null) {
                    com.baidu.tbadk.BdToken.b e2 = c.this.e(bVar);
                    if (e2 != null && e2.eCM) {
                        e2.reset();
                        c.this.j(e2);
                        return;
                    }
                    n.bhP().o(e2);
                    if (e2 != null && e2.getTaskType() == 7) {
                        e2.bgT();
                        int bhl = e2.bhl();
                        int tag = e2.getTag();
                        if (bhl <= 1 || bhl <= tag) {
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
        this.eCV = new com.baidu.tbadk.BdToken.completeTask.d(this.mBdUniqueId);
        this.eCV.a(this.eDf);
        this.eCW = new com.baidu.tbadk.BdToken.activeConfig.b(this.mBdUniqueId);
        this.eCW.a(this.eDe);
        this.eCX = new com.baidu.tbadk.BdToken.backUser.b(this.mBdUniqueId);
        this.mSyncFinishListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        this.mBackgroundListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mBackgroundListener);
        this.eDd.setPriority(Integer.MIN_VALUE);
        this.eDd.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.eDd);
        com.baidu.tbadk.core.f.a.brM().init();
        p.bhS().i(this.mBdUniqueId);
        startTimer();
        if (isMainProcess()) {
            new f().execute(new Void[0]);
        }
    }

    private boolean isMainProcess() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public void bho() {
        if (this.eCX != null && isMainProcess()) {
            this.eCX.biz();
        }
    }

    public void bhp() {
        if (this.eCW != null && isMainProcess() && this.eCU && !bht()) {
            this.eCW.d(bhr(), bhs(), 0);
        }
    }

    public boolean bhq() {
        if (this.eCW != null && isMainProcess()) {
            this.eCW.d(bhr(), bhs(), 1);
            return true;
        }
        return false;
    }

    public boolean bhr() {
        return !bhu();
    }

    public boolean bhs() {
        return this.isSchemaUp;
    }

    public void setSchemaUp(boolean z) {
        this.isSchemaUp = z;
    }

    public boolean bht() {
        return UtilHelper.isSameDay(bhw(), System.currentTimeMillis());
    }

    public boolean bhu() {
        return UtilHelper.isSameDay(com.baidu.tbadk.core.sharedPref.b.brQ().getLong("pref_key_last_active_config", 0L), System.currentTimeMillis());
    }

    public boolean bhv() {
        return UtilHelper.isSameDay(com.baidu.tbadk.core.sharedPref.b.brQ().getLong("pref_key_last_popup_time", 0L), System.currentTimeMillis());
    }

    private long bhw() {
        this.eDc = com.baidu.tbadk.core.sharedPref.b.brQ().getLong("pref_key_active_config_info", 0L);
        return this.eDc;
    }

    public int bhx() {
        return this.eDb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.BdToken.b e(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.eCP.size()) {
                return null;
            }
            List<com.baidu.tbadk.BdToken.b> valueAt = this.eCP.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar2 : valueAt) {
                    if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.bgX() == bVar.bgX()) {
                        return bVar2;
                    }
                }
                continue;
            }
            i = i2 + 1;
        }
    }

    public void bhy() {
        this.eCS.compareAndSet(true, false);
        this.eCR.mH(0);
        this.eCR.setTid(0L);
        this.eCR.setFid(0L);
        if (this.eCV != null) {
            this.eCV.biC();
        }
    }

    public void o(int i, long j) {
        if (isMainProcess()) {
            this.eDb = i;
            this.eDa = j;
            if (this.eCZ > 0 && this.eCY > 0 && (j == 0 || j != this.eCZ)) {
                p(this.eCY, this.eCZ);
                this.eCZ = 0L;
                this.eCY = 0;
            }
            bhz();
        }
    }

    public void p(int i, long j) {
        k kVar;
        com.baidu.tbadk.BdToken.b bhM;
        List<com.baidu.tbadk.BdToken.b> list = this.eCP.get(i);
        if (list != null && !list.isEmpty()) {
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 7) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bgM().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof k) && (bhM = (kVar = (k) next).bhM()) != null && kVar.getTid() == j && bhM.getActivityId() == bVar.getActivityId() && bhM.bgX() == bVar.bgX()) {
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
        if (isMainProcess() && i != 0 && j != 0 && this.eCT) {
            this.eCY = i;
            List<com.baidu.tbadk.BdToken.b> list = this.eCP.get(i);
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
                this.eCR.mH(i);
                this.eCR.setTid(j);
                this.eCZ = j;
                this.eCS.compareAndSet(false, true);
                synchronized (this.eCS) {
                    this.eCS.notify();
                }
            }
        }
    }

    private void a(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        m mVar;
        com.baidu.tbadk.BdToken.b bhM;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bgM().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof m) && (bhM = (mVar = (m) next).bhM()) != null && mVar.getTid() == j && bhM.getActivityId() == bVar.getActivityId() && bhM.bgX() == bVar.bgX()) {
                z = true;
                break;
            }
        }
        if (!z) {
            m mVar2 = new m(bVar, j);
            mVar2.dI(0L);
            mVar2.iW(false);
            mVar2.mF(bVar.getTag());
            bVar.a(mVar2);
        }
    }

    private void b(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        k kVar;
        com.baidu.tbadk.BdToken.b bhM;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bgM().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof k) && (bhM = (kVar = (k) next).bhM()) != null && kVar.getTid() == j && bhM.getActivityId() == bVar.getActivityId() && bhM.bgX() == bVar.bgX()) {
                z = true;
                break;
            }
        }
        if (!z) {
            k kVar2 = new k(bVar, j);
            kVar2.dI(0L);
            kVar2.iW(false);
            kVar2.mF(bVar.getTag());
            bVar.a(kVar2);
        }
    }

    public void r(int i, long j) {
        boolean z;
        if (isMainProcess() && i != 0 && j != 0 && this.eCT) {
            this.eCY = i;
            List<com.baidu.tbadk.BdToken.b> list = this.eCP.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 2) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bgM().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof j) && next.bhM().getActivityId() == bVar.getActivityId() && next.bhM().bgX() == bVar.bgX() && ((j) next).getFid() == j) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            j jVar = new j(bVar, j);
                            jVar.dI(0L);
                            jVar.iW(false);
                            jVar.mF(bVar.getTag());
                            bVar.a(jVar);
                        }
                        z2 = z;
                    }
                }
                this.eCR.mH(i);
                this.eCR.setFid(j);
                this.eCS.compareAndSet(false, true);
                synchronized (this.eCS) {
                    this.eCS.notify();
                }
            }
        }
    }

    public void mG(int i) {
        boolean z;
        if (isMainProcess() && i != 0 && this.eCT) {
            this.eCY = i;
            List<com.baidu.tbadk.BdToken.b> list = this.eCP.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 4) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bgM().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof i) && next.bhM().getActivityId() == bVar.getActivityId() && next.bhM().bgX() == bVar.bgX()) {
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
                this.eCR.mH(i);
                this.eCS.compareAndSet(false, true);
                synchronized (this.eCS) {
                    this.eCS.notify();
                }
            }
        }
    }

    public void bhz() {
        int i;
        List<com.baidu.tbadk.BdToken.b> list;
        boolean z;
        if (isMainProcess() && this.eCT && (list = this.eCP.get((i = com.baidu.tbadk.BdToken.b.eCe))) != null && !list.isEmpty()) {
            boolean z2 = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 8) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bgM().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = z2;
                            break;
                        }
                        com.baidu.tbadk.BdToken.h next = it.next();
                        com.baidu.tbadk.BdToken.b bhM = next.bhM();
                        if (bhM != null && (next instanceof l) && bhM.getActivityId() == bVar.getActivityId() && bhM.bgX() == bVar.bgX()) {
                            ((l) next).bhO();
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
            this.eCR.mH(i);
            this.eCS.compareAndSet(false, true);
            synchronized (this.eCS) {
                this.eCS.notify();
            }
        }
    }

    private void startTimer() {
        this.eCO.scheduleWithFixedDelay(this.eCR, 0L, 1L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tbadk.BdToken.b bVar) {
        int[] bhc;
        for (int i : bVar.bhc()) {
            List<com.baidu.tbadk.BdToken.b> list = this.eCP.get(i);
            if (list == null) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(bVar);
                this.eCP.put(i, linkedList);
            } else {
                list.add(bVar);
            }
        }
    }

    private boolean g(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return false;
        }
        int[] bhc = bVar.bhc();
        if (bhc == null) {
            return true;
        }
        for (int i : bhc) {
            List<com.baidu.tbadk.BdToken.b> list = this.eCP.get(i);
            if (list == null) {
                return false;
            }
            for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.bgX() == bVar.bgX()) {
                    if (bVar2.bgU()) {
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
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bgM().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.bhM() != null) {
                    com.baidu.tbadk.BdToken.b bhM = next.bhM();
                    if (bhM.getActivityId() == bVar.getActivityId() && bhM.bgX() == bVar.bgX()) {
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
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bgM().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.bhM() != null) {
                    com.baidu.tbadk.BdToken.b bhM = next.bhM();
                    if (bhM.getActivityId() == bVar.getActivityId() && bhM.bgX() == bVar.bgX()) {
                        it.remove();
                    }
                }
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eCP.size()) {
                    List<com.baidu.tbadk.BdToken.b> valueAt = this.eCP.valueAt(i2);
                    if (valueAt != null && !valueAt.isEmpty()) {
                        Iterator<com.baidu.tbadk.BdToken.b> it2 = valueAt.iterator();
                        while (it2.hasNext()) {
                            com.baidu.tbadk.BdToken.b next2 = it2.next();
                            if (next2 != null && next2.getActivityId() == bVar.getActivityId() && next2.bgX() == bVar.bgX()) {
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
                p.bhS().q(bVar);
            } else if (!this.eCT) {
                this.eCQ.add(bVar);
            } else if (!g(bVar)) {
                f(bVar);
                new b().execute(bVar);
            }
        }
    }

    public void bf(List<com.baidu.tbadk.BdToken.b> list) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(list)) {
            if (!this.eCT) {
                this.eCQ.addAll(list);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar != null) {
                    if (bVar.getTaskType() == 9) {
                        p.bhS().q(bVar);
                    } else if (!g(bVar)) {
                        f(bVar);
                        arrayList.add(bVar);
                    }
                }
            }
            new C0551c().execute(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.BdToken.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0551c extends BdAsyncTask<List<com.baidu.tbadk.BdToken.b>, Integer, Void> {
        private C0551c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(List<com.baidu.tbadk.BdToken.b>... listArr) {
            if (listArr != null && listArr.length > 0 && listArr[0] != null) {
                com.baidu.tbadk.BdToken.a.bgJ().bf(listArr[0]);
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
            linkedList.addAll(com.baidu.tbadk.BdToken.a.bgJ().bgK());
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next != null && next.bgU()) {
                    com.baidu.tbadk.BdToken.a.bgJ().c(next);
                    it.remove();
                } else if (next.getTaskType() == 7) {
                    next.bgO();
                    com.baidu.tbadk.BdToken.a.bgJ().b(next);
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
                        if (next.bhc() != null) {
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
                com.baidu.tbadk.BdToken.a.bgJ().a(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.bgJ().c(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.bgJ().c(bVar2);
            }
            if (bVar != null) {
                com.baidu.tbadk.BdToken.a.bgJ().a(bVar);
            }
            return pair;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
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
            com.baidu.tbadk.BdToken.a.bgJ().b(bVar);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(com.baidu.tbadk.BdToken.b bVar) {
            if (bVar != null && bVar.eCM) {
                bVar.eCM = false;
                c.this.q(c.this.eCY, c.this.eCZ);
            }
        }
    }

    public void bhA() {
        List<com.baidu.tbadk.BdToken.b> list = this.eCP.get(com.baidu.tbadk.BdToken.b.eCe);
        if (!com.baidu.tbadk.core.util.y.isEmpty(list)) {
            boolean z = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bgM().iterator();
                boolean z2 = z;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof l) {
                        l lVar = (l) next;
                        if (!next.isCompleted()) {
                            lVar.bhO();
                            z2 = true;
                        }
                    }
                }
                z = z2;
            }
            if (z && !this.eCS.get()) {
                this.eCR.mH(com.baidu.tbadk.BdToken.b.eCe);
                this.eCS.compareAndSet(false, true);
                synchronized (this.eCS) {
                    this.eCS.notify();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private volatile long eCy;
        private volatile int eDh;
        private volatile boolean eDi;
        private volatile long mFid;

        private a() {
            this.eDi = false;
        }

        public synchronized void mH(int i) {
            this.eDh = i;
        }

        public synchronized void setTid(long j) {
            this.eCy = j;
        }

        public synchronized void setFid(long j) {
            this.mFid = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.eDh == 0 || !c.this.eCS.get()) {
                synchronized (c.this.eCS) {
                    try {
                        c.this.eCS.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            bhB();
        }

        private void bhB() {
            this.eDi = true;
            List<com.baidu.tbadk.BdToken.b> list = (List) c.this.eCP.get(com.baidu.tbadk.BdToken.b.eCe);
            List<com.baidu.tbadk.BdToken.b> list2 = (List) c.this.eCP.get(this.eDh);
            if (com.baidu.tbadk.core.util.y.isEmpty(list) && com.baidu.tbadk.core.util.y.isEmpty(list2)) {
                c.this.eCS.compareAndSet(true, false);
                return;
            }
            d.b bVar = new d.b();
            bVar.eFZ = new LinkedList();
            bVar.eGa = new LinkedList();
            bVar.eGb = new LinkedList();
            a(list, bVar);
            b(list2, bVar);
            if (this.eDi) {
                c.this.eCS.compareAndSet(true, false);
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(bVar.eGb)) {
                com.baidu.tbadk.BdToken.a.bgJ().bg(bVar.eGb);
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(bVar.eFZ) || !com.baidu.tbadk.core.util.y.isEmpty(bVar.eGa)) {
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
            ArrayList<com.baidu.tbadk.BdToken.h> bgM;
            if (bVar != null && bVar2 != null && (bgM = bVar.bgM()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bgM.iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if ((next instanceof l) && !((l) next).isTimeout() && !next.isCompleted()) {
                        this.eDi = false;
                        next.mI(1);
                        if (next.bhN() >= next.bhM().bhd()) {
                            next.iW(true);
                            bVar2.s(bVar);
                        }
                        bVar2.t(bVar);
                    }
                }
            }
        }

        private void b(com.baidu.tbadk.BdToken.b bVar, d.b bVar2) {
            ArrayList<com.baidu.tbadk.BdToken.h> bgM;
            if (bVar != null && bVar2 != null && (bgM = bVar.bgM()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bgM.iterator();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof m) {
                        m mVar = (m) next;
                        if (this.eCy != 0 && mVar.getTid() == this.eCy && !next.isCompleted()) {
                            this.eDi = false;
                            next.mI(1);
                            if (next.bhN() >= next.bhM().bhd()) {
                                next.iW(true);
                                if (next.bhM().bgS() >= next.bhM().getThreadNum()) {
                                    bVar2.c(next);
                                }
                            }
                            bVar2.t(bVar);
                        }
                    } else if (next instanceof k) {
                        k kVar = (k) next;
                        if (!bVar.bhm() && kVar.getTag() == bVar.getTag()) {
                            if (this.eCy != 0 && kVar.getTid() == this.eCy && !next.isCompleted()) {
                                this.eDi = false;
                                next.mI(1);
                            }
                            i = (int) (i + next.bhN());
                            if (this.eCy != 0 && kVar.getTid() == this.eCy && !next.isCompleted()) {
                                if (next.bhN() >= bVar.bhd()) {
                                    next.iW(true);
                                    bVar.bgS();
                                }
                                bVar2.t(bVar);
                            }
                            int bgN = bVar.bgN();
                            int threadNum = bVar.getThreadNum();
                            if (i >= bVar.bhd() * bVar.getThreadNum() && bgN >= threadNum) {
                                bVar2.s(bVar);
                                bVar.iV(true);
                            }
                        }
                    } else if (next instanceof j) {
                        if (this.mFid != 0 && ((j) next).getFid() == this.mFid && !next.isCompleted()) {
                            this.eDi = false;
                            next.mI(1);
                            if (next.bhN() >= next.bhM().bhd()) {
                                next.iW(true);
                                if (next.bhM().bgR() >= next.bhM().bhe()) {
                                    bVar2.c(next);
                                }
                            }
                        }
                    } else if ((next instanceof i) && !next.isCompleted()) {
                        this.eDi = false;
                        next.mI(1);
                        if (next.bhN() >= next.bhM().bhd()) {
                            next.iW(true);
                            bVar2.c(next);
                        }
                    }
                }
            }
        }
    }
}
