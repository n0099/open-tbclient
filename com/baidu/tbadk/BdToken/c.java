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
    private final ScheduledExecutorService eAI;
    private final SparseArray<List<com.baidu.tbadk.BdToken.b>> eAJ;
    private final LinkedList<com.baidu.tbadk.BdToken.b> eAK;
    private a eAL;
    private AtomicBoolean eAM;
    private boolean eAN;
    private boolean eAO;
    private com.baidu.tbadk.BdToken.completeTask.d eAP;
    private com.baidu.tbadk.BdToken.activeConfig.b eAQ;
    private com.baidu.tbadk.BdToken.backUser.b eAR;
    private int eAS;
    private long eAT;
    private long eAU;
    private int eAV;
    private long eAW;
    private CustomMessageListener eAX;
    private com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a> eAY;
    private com.baidu.tbadk.h.b eAZ;
    private boolean isSchemaUp;
    private CustomMessageListener mBackgroundListener;
    private BdUniqueId mBdUniqueId;
    private CustomMessageListener mSyncFinishListener;

    public static final c bha() {
        return g.eBd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g {
        private static final c eBd = new c();
    }

    private c() {
        this.eAI = Executors.newSingleThreadScheduledExecutor();
        this.eAJ = new SparseArray<>();
        this.eAK = new LinkedList<>();
        this.eAL = new a();
        this.eAM = new AtomicBoolean(false);
        this.eAN = false;
        this.eAO = false;
        this.isSchemaUp = false;
        this.eAX = new CustomMessageListener(2921391) { // from class: com.baidu.tbadk.BdToken.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.eAN = true;
                if (!c.this.eAK.isEmpty()) {
                    Iterator it = c.this.eAK.iterator();
                    while (it.hasNext()) {
                        c.this.l((com.baidu.tbadk.BdToken.b) it.next());
                    }
                    c.this.eAK.clear();
                }
            }
        };
        this.mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.BdToken.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                    ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                    c.this.bhc();
                }
            }
        };
        this.mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tbadk.BdToken.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                    c.this.eAO = true;
                    c.this.bhc();
                }
            }
        };
        this.eAY = new com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a>() { // from class: com.baidu.tbadk.BdToken.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: a */
            public void onSuccess(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null) {
                    c.this.bk(aVar.bij());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: b */
            public void as(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null && aVar.eDj != null && aVar.eDj.mission != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b();
                    bVar.a(aVar.eDj.mission);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(bVar);
                    c.this.bk(arrayList);
                }
            }

            @Override // com.baidu.tbadk.h.a
            public void onError(int i, String str) {
            }
        };
        this.eAZ = new com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b>() { // from class: com.baidu.tbadk.BdToken.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.b
            /* renamed from: m */
            public void onProgressUpdate(com.baidu.tbadk.BdToken.b bVar) {
                if (bVar != null) {
                    com.baidu.tbadk.BdToken.b e2 = c.this.e(bVar);
                    if (e2 != null && e2.eAG) {
                        e2.reset();
                        c.this.j(e2);
                        return;
                    }
                    n.bhC().o(e2);
                    if (e2 != null && e2.getTaskType() == 7) {
                        e2.bgG();
                        int bgY = e2.bgY();
                        int tag = e2.getTag();
                        if (bgY <= 1 || bgY <= tag) {
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
        this.eAP = new com.baidu.tbadk.BdToken.completeTask.d(this.mBdUniqueId);
        this.eAP.a(this.eAZ);
        this.eAQ = new com.baidu.tbadk.BdToken.activeConfig.b(this.mBdUniqueId);
        this.eAQ.a(this.eAY);
        this.eAR = new com.baidu.tbadk.BdToken.backUser.b(this.mBdUniqueId);
        this.mSyncFinishListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        this.mBackgroundListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mBackgroundListener);
        this.eAX.setPriority(Integer.MIN_VALUE);
        this.eAX.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.eAX);
        com.baidu.tbadk.core.f.a.brt().init();
        p.bhF().i(this.mBdUniqueId);
        startTimer();
        if (isMainProcess()) {
            new f().execute(new Void[0]);
        }
    }

    private boolean isMainProcess() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public void bhb() {
        if (this.eAR != null && isMainProcess()) {
            this.eAR.bin();
        }
    }

    public void bhc() {
        if (this.eAQ != null && isMainProcess() && this.eAO && !bhg()) {
            this.eAQ.d(bhe(), bhf(), 0);
        }
    }

    public boolean bhd() {
        if (this.eAQ != null && isMainProcess()) {
            this.eAQ.d(bhe(), bhf(), 1);
            return true;
        }
        return false;
    }

    public boolean bhe() {
        return !bhh();
    }

    public boolean bhf() {
        return this.isSchemaUp;
    }

    public void setSchemaUp(boolean z) {
        this.isSchemaUp = z;
    }

    public boolean bhg() {
        return UtilHelper.isSameDay(bhj(), System.currentTimeMillis());
    }

    public boolean bhh() {
        return UtilHelper.isSameDay(com.baidu.tbadk.core.sharedPref.b.brx().getLong("pref_key_last_active_config", 0L), System.currentTimeMillis());
    }

    public boolean bhi() {
        return UtilHelper.isSameDay(com.baidu.tbadk.core.sharedPref.b.brx().getLong("pref_key_last_popup_time", 0L), System.currentTimeMillis());
    }

    private long bhj() {
        this.eAW = com.baidu.tbadk.core.sharedPref.b.brx().getLong("pref_key_active_config_info", 0L);
        return this.eAW;
    }

    public int bhk() {
        return this.eAV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.BdToken.b e(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.eAJ.size()) {
                return null;
            }
            List<com.baidu.tbadk.BdToken.b> valueAt = this.eAJ.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar2 : valueAt) {
                    if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.bgK() == bVar.bgK()) {
                        return bVar2;
                    }
                }
                continue;
            }
            i = i2 + 1;
        }
    }

    public void bhl() {
        this.eAM.compareAndSet(true, false);
        this.eAL.mE(0);
        this.eAL.setTid(0L);
        this.eAL.setFid(0L);
        if (this.eAP != null) {
            this.eAP.biq();
        }
    }

    public void n(int i, long j) {
        if (isMainProcess()) {
            this.eAV = i;
            this.eAU = j;
            if (this.eAT > 0 && this.eAS > 0 && (j == 0 || j != this.eAT)) {
                o(this.eAS, this.eAT);
                this.eAT = 0L;
                this.eAS = 0;
            }
            bhm();
        }
    }

    public void o(int i, long j) {
        k kVar;
        com.baidu.tbadk.BdToken.b bhz;
        List<com.baidu.tbadk.BdToken.b> list = this.eAJ.get(i);
        if (list != null && !list.isEmpty()) {
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 7) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bgz().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof k) && (bhz = (kVar = (k) next).bhz()) != null && kVar.getTid() == j && bhz.getActivityId() == bVar.getActivityId() && bhz.bgK() == bVar.bgK()) {
                                next.iU(true);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void p(int i, long j) {
        if (isMainProcess() && i != 0 && j != 0 && this.eAN) {
            this.eAS = i;
            List<com.baidu.tbadk.BdToken.b> list = this.eAJ.get(i);
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
                this.eAL.mE(i);
                this.eAL.setTid(j);
                this.eAT = j;
                this.eAM.compareAndSet(false, true);
                synchronized (this.eAM) {
                    this.eAM.notify();
                }
            }
        }
    }

    private void a(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        m mVar;
        com.baidu.tbadk.BdToken.b bhz;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bgz().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof m) && (bhz = (mVar = (m) next).bhz()) != null && mVar.getTid() == j && bhz.getActivityId() == bVar.getActivityId() && bhz.bgK() == bVar.bgK()) {
                z = true;
                break;
            }
        }
        if (!z) {
            m mVar2 = new m(bVar, j);
            mVar2.dC(0L);
            mVar2.iU(false);
            mVar2.mC(bVar.getTag());
            bVar.a(mVar2);
        }
    }

    private void b(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        k kVar;
        com.baidu.tbadk.BdToken.b bhz;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bgz().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof k) && (bhz = (kVar = (k) next).bhz()) != null && kVar.getTid() == j && bhz.getActivityId() == bVar.getActivityId() && bhz.bgK() == bVar.bgK()) {
                z = true;
                break;
            }
        }
        if (!z) {
            k kVar2 = new k(bVar, j);
            kVar2.dC(0L);
            kVar2.iU(false);
            kVar2.mC(bVar.getTag());
            bVar.a(kVar2);
        }
    }

    public void q(int i, long j) {
        boolean z;
        if (isMainProcess() && i != 0 && j != 0 && this.eAN) {
            this.eAS = i;
            List<com.baidu.tbadk.BdToken.b> list = this.eAJ.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 2) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bgz().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof j) && next.bhz().getActivityId() == bVar.getActivityId() && next.bhz().bgK() == bVar.bgK() && ((j) next).getFid() == j) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            j jVar = new j(bVar, j);
                            jVar.dC(0L);
                            jVar.iU(false);
                            jVar.mC(bVar.getTag());
                            bVar.a(jVar);
                        }
                        z2 = z;
                    }
                }
                this.eAL.mE(i);
                this.eAL.setFid(j);
                this.eAM.compareAndSet(false, true);
                synchronized (this.eAM) {
                    this.eAM.notify();
                }
            }
        }
    }

    public void mD(int i) {
        boolean z;
        if (isMainProcess() && i != 0 && this.eAN) {
            this.eAS = i;
            List<com.baidu.tbadk.BdToken.b> list = this.eAJ.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 4) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bgz().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof i) && next.bhz().getActivityId() == bVar.getActivityId() && next.bhz().bgK() == bVar.bgK()) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            i iVar = new i(bVar);
                            iVar.dC(0L);
                            iVar.iU(false);
                            bVar.a(iVar);
                        }
                        z2 = z;
                    }
                }
                this.eAL.mE(i);
                this.eAM.compareAndSet(false, true);
                synchronized (this.eAM) {
                    this.eAM.notify();
                }
            }
        }
    }

    public void bhm() {
        int i;
        List<com.baidu.tbadk.BdToken.b> list;
        boolean z;
        if (isMainProcess() && this.eAN && (list = this.eAJ.get((i = com.baidu.tbadk.BdToken.b.ezY))) != null && !list.isEmpty()) {
            boolean z2 = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 8) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bgz().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = z2;
                            break;
                        }
                        com.baidu.tbadk.BdToken.h next = it.next();
                        com.baidu.tbadk.BdToken.b bhz = next.bhz();
                        if (bhz != null && (next instanceof l) && bhz.getActivityId() == bVar.getActivityId() && bhz.bgK() == bVar.bgK()) {
                            ((l) next).bhB();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        l lVar = new l(bVar);
                        lVar.dC(0L);
                        lVar.iU(false);
                        bVar.a(lVar);
                    }
                    z2 = z;
                }
            }
            this.eAL.mE(i);
            this.eAM.compareAndSet(false, true);
            synchronized (this.eAM) {
                this.eAM.notify();
            }
        }
    }

    private void startTimer() {
        this.eAI.scheduleWithFixedDelay(this.eAL, 0L, 1L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tbadk.BdToken.b bVar) {
        int[] bgP;
        for (int i : bVar.bgP()) {
            List<com.baidu.tbadk.BdToken.b> list = this.eAJ.get(i);
            if (list == null) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(bVar);
                this.eAJ.put(i, linkedList);
            } else {
                list.add(bVar);
            }
        }
    }

    private boolean g(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return false;
        }
        int[] bgP = bVar.bgP();
        if (bgP == null) {
            return true;
        }
        for (int i : bgP) {
            List<com.baidu.tbadk.BdToken.b> list = this.eAJ.get(i);
            if (list == null) {
                return false;
            }
            for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.bgK() == bVar.bgK()) {
                    if (bVar2.bgH()) {
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
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bgz().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.bhz() != null) {
                    com.baidu.tbadk.BdToken.b bhz = next.bhz();
                    if (bhz.getActivityId() == bVar.getActivityId() && bhz.bgK() == bVar.bgK()) {
                        if (taskType == 7 && (next instanceof k)) {
                            ((k) next).iU(true);
                        } else if (taskType == 1 && (next instanceof m)) {
                            ((m) next).iU(true);
                        }
                    }
                }
            }
            bVar.iT(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar != null) {
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bgz().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.bhz() != null) {
                    com.baidu.tbadk.BdToken.b bhz = next.bhz();
                    if (bhz.getActivityId() == bVar.getActivityId() && bhz.bgK() == bVar.bgK()) {
                        it.remove();
                    }
                }
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eAJ.size()) {
                    List<com.baidu.tbadk.BdToken.b> valueAt = this.eAJ.valueAt(i2);
                    if (valueAt != null && !valueAt.isEmpty()) {
                        Iterator<com.baidu.tbadk.BdToken.b> it2 = valueAt.iterator();
                        while (it2.hasNext()) {
                            com.baidu.tbadk.BdToken.b next2 = it2.next();
                            if (next2 != null && next2.getActivityId() == bVar.getActivityId() && next2.bgK() == bVar.bgK()) {
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
                p.bhF().q(bVar);
            } else if (!this.eAN) {
                this.eAK.add(bVar);
            } else if (!g(bVar)) {
                f(bVar);
                new b().execute(bVar);
            }
        }
    }

    public void bk(List<com.baidu.tbadk.BdToken.b> list) {
        if (!com.baidu.tbadk.core.util.x.isEmpty(list)) {
            if (!this.eAN) {
                this.eAK.addAll(list);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar != null) {
                    if (bVar.getTaskType() == 9) {
                        p.bhF().q(bVar);
                    } else if (!g(bVar)) {
                        f(bVar);
                        arrayList.add(bVar);
                    }
                }
            }
            new C0554c().execute(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.BdToken.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0554c extends BdAsyncTask<List<com.baidu.tbadk.BdToken.b>, Integer, Void> {
        private C0554c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(List<com.baidu.tbadk.BdToken.b>... listArr) {
            if (listArr != null && listArr.length > 0 && listArr[0] != null) {
                com.baidu.tbadk.BdToken.a.bgw().bk(listArr[0]);
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
            linkedList.addAll(com.baidu.tbadk.BdToken.a.bgw().bgx());
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next != null && next.bgH()) {
                    com.baidu.tbadk.BdToken.a.bgw().c(next);
                    it.remove();
                } else if (next.getTaskType() == 7) {
                    next.bgB();
                    com.baidu.tbadk.BdToken.a.bgw().b(next);
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
                        if (next.bgP() != null) {
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
                com.baidu.tbadk.BdToken.a.bgw().a(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.bgw().c(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.bgw().c(bVar2);
            }
            if (bVar != null) {
                com.baidu.tbadk.BdToken.a.bgw().a(bVar);
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
            com.baidu.tbadk.BdToken.a.bgw().b(bVar);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(com.baidu.tbadk.BdToken.b bVar) {
            if (bVar != null && bVar.eAG) {
                bVar.eAG = false;
                c.this.p(c.this.eAS, c.this.eAT);
            }
        }
    }

    public void bhn() {
        List<com.baidu.tbadk.BdToken.b> list = this.eAJ.get(com.baidu.tbadk.BdToken.b.ezY);
        if (!com.baidu.tbadk.core.util.x.isEmpty(list)) {
            boolean z = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bgz().iterator();
                boolean z2 = z;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof l) {
                        l lVar = (l) next;
                        if (!next.isCompleted()) {
                            lVar.bhB();
                            z2 = true;
                        }
                    }
                }
                z = z2;
            }
            if (z && !this.eAM.get()) {
                this.eAL.mE(com.baidu.tbadk.BdToken.b.ezY);
                this.eAM.compareAndSet(false, true);
                synchronized (this.eAM) {
                    this.eAM.notify();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private volatile long eAs;
        private volatile int eBb;
        private volatile boolean eBc;
        private volatile long mFid;

        private a() {
            this.eBc = false;
        }

        public synchronized void mE(int i) {
            this.eBb = i;
        }

        public synchronized void setTid(long j) {
            this.eAs = j;
        }

        public synchronized void setFid(long j) {
            this.mFid = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.eBb == 0 || !c.this.eAM.get()) {
                synchronized (c.this.eAM) {
                    try {
                        c.this.eAM.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            bho();
        }

        private void bho() {
            this.eBc = true;
            List<com.baidu.tbadk.BdToken.b> list = (List) c.this.eAJ.get(com.baidu.tbadk.BdToken.b.ezY);
            List<com.baidu.tbadk.BdToken.b> list2 = (List) c.this.eAJ.get(this.eBb);
            if (com.baidu.tbadk.core.util.x.isEmpty(list) && com.baidu.tbadk.core.util.x.isEmpty(list2)) {
                c.this.eAM.compareAndSet(true, false);
                return;
            }
            d.b bVar = new d.b();
            bVar.eDS = new LinkedList();
            bVar.eDT = new LinkedList();
            bVar.eDU = new LinkedList();
            a(list, bVar);
            b(list2, bVar);
            if (this.eBc) {
                c.this.eAM.compareAndSet(true, false);
            }
            if (!com.baidu.tbadk.core.util.x.isEmpty(bVar.eDU)) {
                com.baidu.tbadk.BdToken.a.bgw().bl(bVar.eDU);
            }
            if (!com.baidu.tbadk.core.util.x.isEmpty(bVar.eDS) || !com.baidu.tbadk.core.util.x.isEmpty(bVar.eDT)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921379, bVar));
            }
        }

        private void a(List<com.baidu.tbadk.BdToken.b> list, d.b bVar) {
            if (!com.baidu.tbadk.core.util.x.isEmpty(list)) {
                for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                    a(bVar2, bVar);
                }
            }
        }

        private void b(List<com.baidu.tbadk.BdToken.b> list, d.b bVar) {
            if (!com.baidu.tbadk.core.util.x.isEmpty(list)) {
                for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                    b(bVar2, bVar);
                }
            }
        }

        private void a(com.baidu.tbadk.BdToken.b bVar, d.b bVar2) {
            ArrayList<com.baidu.tbadk.BdToken.h> bgz;
            if (bVar != null && bVar2 != null && (bgz = bVar.bgz()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bgz.iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if ((next instanceof l) && !((l) next).isTimeout() && !next.isCompleted()) {
                        this.eBc = false;
                        next.mF(1);
                        if (next.bhA() >= next.bhz().bgQ()) {
                            next.iU(true);
                            bVar2.s(bVar);
                        }
                        bVar2.t(bVar);
                    }
                }
            }
        }

        private void b(com.baidu.tbadk.BdToken.b bVar, d.b bVar2) {
            ArrayList<com.baidu.tbadk.BdToken.h> bgz;
            if (bVar != null && bVar2 != null && (bgz = bVar.bgz()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bgz.iterator();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof m) {
                        m mVar = (m) next;
                        if (this.eAs != 0 && mVar.getTid() == this.eAs && !next.isCompleted()) {
                            this.eBc = false;
                            next.mF(1);
                            if (next.bhA() >= next.bhz().bgQ()) {
                                next.iU(true);
                                if (next.bhz().bgF() >= next.bhz().getThreadNum()) {
                                    bVar2.c(next);
                                }
                            }
                            bVar2.t(bVar);
                        }
                    } else if (next instanceof k) {
                        k kVar = (k) next;
                        if (!bVar.bgZ() && kVar.getTag() == bVar.getTag()) {
                            if (this.eAs != 0 && kVar.getTid() == this.eAs && !next.isCompleted()) {
                                this.eBc = false;
                                next.mF(1);
                            }
                            i = (int) (i + next.bhA());
                            if (this.eAs != 0 && kVar.getTid() == this.eAs && !next.isCompleted()) {
                                if (next.bhA() >= bVar.bgQ()) {
                                    next.iU(true);
                                    bVar.bgF();
                                }
                                bVar2.t(bVar);
                            }
                            int bgA = bVar.bgA();
                            int threadNum = bVar.getThreadNum();
                            if (i >= bVar.bgQ() * bVar.getThreadNum() && bgA >= threadNum) {
                                bVar2.s(bVar);
                                bVar.iT(true);
                            }
                        }
                    } else if (next instanceof j) {
                        if (this.mFid != 0 && ((j) next).getFid() == this.mFid && !next.isCompleted()) {
                            this.eBc = false;
                            next.mF(1);
                            if (next.bhA() >= next.bhz().bgQ()) {
                                next.iU(true);
                                if (next.bhz().bgE() >= next.bhz().bgR()) {
                                    bVar2.c(next);
                                }
                            }
                        }
                    } else if ((next instanceof i) && !next.isCompleted()) {
                        this.eBc = false;
                        next.mF(1);
                        if (next.bhA() >= next.bhz().bgQ()) {
                            next.iU(true);
                            bVar2.c(next);
                        }
                    }
                }
            }
        }
    }
}
