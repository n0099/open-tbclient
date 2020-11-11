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
    private final ScheduledExecutorService eqM;
    private final SparseArray<List<com.baidu.tbadk.BdToken.b>> eqN;
    private final LinkedList<com.baidu.tbadk.BdToken.b> eqO;
    private a eqP;
    private AtomicBoolean eqQ;
    private boolean eqR;
    private boolean eqS;
    private com.baidu.tbadk.BdToken.completeTask.d eqT;
    private com.baidu.tbadk.BdToken.activeConfig.b eqU;
    private com.baidu.tbadk.BdToken.backUser.b eqV;
    private int eqW;
    private long eqX;
    private long eqY;
    private int eqZ;
    private long era;
    private CustomMessageListener erb;
    private com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a> erc;
    private com.baidu.tbadk.h.b erd;
    private boolean isSchemaUp;
    private CustomMessageListener mBackgroundListener;
    private BdUniqueId mBdUniqueId;
    private CustomMessageListener mSyncFinishListener;

    public static final c bgf() {
        return g.erh;
    }

    /* loaded from: classes.dex */
    private static class g {
        private static final c erh = new c();
    }

    private c() {
        this.eqM = Executors.newSingleThreadScheduledExecutor();
        this.eqN = new SparseArray<>();
        this.eqO = new LinkedList<>();
        this.eqP = new a();
        this.eqQ = new AtomicBoolean(false);
        this.eqR = false;
        this.eqS = false;
        this.isSchemaUp = false;
        this.erb = new CustomMessageListener(2921391) { // from class: com.baidu.tbadk.BdToken.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.eqR = true;
                if (!c.this.eqO.isEmpty()) {
                    Iterator it = c.this.eqO.iterator();
                    while (it.hasNext()) {
                        c.this.l((com.baidu.tbadk.BdToken.b) it.next());
                    }
                    c.this.eqO.clear();
                }
            }
        };
        this.mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.BdToken.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                    ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                    c.this.bgh();
                }
            }
        };
        this.mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tbadk.BdToken.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                    c.this.eqS = true;
                    c.this.bgh();
                }
            }
        };
        this.erc = new com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a>() { // from class: com.baidu.tbadk.BdToken.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: a */
            public void onSuccess(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null) {
                    c.this.ba(aVar.bhp());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: b */
            public void aq(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null && aVar.etj != null && aVar.etj.mission != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b();
                    bVar.a(aVar.etj.mission);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(bVar);
                    c.this.ba(arrayList);
                }
            }

            @Override // com.baidu.tbadk.h.a
            public void onError(int i, String str) {
            }
        };
        this.erd = new com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b>() { // from class: com.baidu.tbadk.BdToken.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.b
            /* renamed from: m */
            public void onProgressUpdate(com.baidu.tbadk.BdToken.b bVar) {
                if (bVar != null) {
                    com.baidu.tbadk.BdToken.b e2 = c.this.e(bVar);
                    if (e2 != null && e2.eqK) {
                        e2.reset();
                        c.this.j(e2);
                        return;
                    }
                    n.bgH().o(e2);
                    if (e2 != null && e2.getTaskType() == 7) {
                        e2.bfL();
                        int bgd = e2.bgd();
                        int tag = e2.getTag();
                        if (bgd <= 1 || bgd <= tag) {
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
        this.eqT = new com.baidu.tbadk.BdToken.completeTask.d(this.mBdUniqueId);
        this.eqT.a(this.erd);
        this.eqU = new com.baidu.tbadk.BdToken.activeConfig.b(this.mBdUniqueId);
        this.eqU.a(this.erc);
        this.eqV = new com.baidu.tbadk.BdToken.backUser.b(this.mBdUniqueId);
        this.mSyncFinishListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        this.mBackgroundListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mBackgroundListener);
        this.erb.setPriority(Integer.MIN_VALUE);
        this.erb.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.erb);
        com.baidu.tbadk.core.f.a.bqd().init();
        p.bgK().i(this.mBdUniqueId);
        startTimer();
        if (isMainProcess()) {
            new f().execute(new Void[0]);
        }
    }

    private boolean isMainProcess() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public void bgg() {
        if (this.eqV != null && isMainProcess()) {
            this.eqV.bht();
        }
    }

    public void bgh() {
        if (this.eqU != null && isMainProcess() && this.eqS && !bgl()) {
            this.eqU.c(bgj(), bgk(), 0);
        }
    }

    public boolean bgi() {
        if (this.eqU != null && isMainProcess()) {
            this.eqU.c(bgj(), bgk(), 1);
            return true;
        }
        return false;
    }

    public boolean bgj() {
        return !bgm();
    }

    public boolean bgk() {
        return this.isSchemaUp;
    }

    public void setSchemaUp(boolean z) {
        this.isSchemaUp = z;
    }

    public boolean bgl() {
        return UtilHelper.isSameDay(bgo(), System.currentTimeMillis());
    }

    public boolean bgm() {
        return UtilHelper.isSameDay(com.baidu.tbadk.core.sharedPref.b.bqh().getLong("pref_key_last_active_config", 0L), System.currentTimeMillis());
    }

    public boolean bgn() {
        return UtilHelper.isSameDay(com.baidu.tbadk.core.sharedPref.b.bqh().getLong("pref_key_last_popup_time", 0L), System.currentTimeMillis());
    }

    private long bgo() {
        this.era = com.baidu.tbadk.core.sharedPref.b.bqh().getLong("pref_key_active_config_info", 0L);
        return this.era;
    }

    public int bgp() {
        return this.eqZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.BdToken.b e(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.eqN.size()) {
                return null;
            }
            List<com.baidu.tbadk.BdToken.b> valueAt = this.eqN.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar2 : valueAt) {
                    if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.bfP() == bVar.bfP()) {
                        return bVar2;
                    }
                }
                continue;
            }
            i = i2 + 1;
        }
    }

    public void bgq() {
        this.eqQ.compareAndSet(true, false);
        this.eqP.nH(0);
        this.eqP.setTid(0L);
        this.eqP.setFid(0L);
        if (this.eqT != null) {
            this.eqT.bhw();
        }
    }

    public void n(int i, long j) {
        if (isMainProcess()) {
            this.eqZ = i;
            this.eqY = j;
            if (this.eqX > 0 && this.eqW > 0 && (j == 0 || j != this.eqX)) {
                o(this.eqW, this.eqX);
                this.eqX = 0L;
                this.eqW = 0;
            }
            bgr();
        }
    }

    public void o(int i, long j) {
        k kVar;
        com.baidu.tbadk.BdToken.b bgE;
        List<com.baidu.tbadk.BdToken.b> list = this.eqN.get(i);
        if (list != null && !list.isEmpty()) {
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 7) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bfE().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof k) && (bgE = (kVar = (k) next).bgE()) != null && kVar.getTid() == j && bgE.getActivityId() == bVar.getActivityId() && bgE.bfP() == bVar.bfP()) {
                                next.il(true);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void p(int i, long j) {
        if (isMainProcess() && i != 0 && j != 0 && this.eqR) {
            this.eqW = i;
            List<com.baidu.tbadk.BdToken.b> list = this.eqN.get(i);
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
                this.eqP.nH(i);
                this.eqP.setTid(j);
                this.eqX = j;
                this.eqQ.compareAndSet(false, true);
                synchronized (this.eqQ) {
                    this.eqQ.notify();
                }
            }
        }
    }

    private void a(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        m mVar;
        com.baidu.tbadk.BdToken.b bgE;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bfE().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof m) && (bgE = (mVar = (m) next).bgE()) != null && mVar.getTid() == j && bgE.getActivityId() == bVar.getActivityId() && bgE.bfP() == bVar.bfP()) {
                z = true;
                break;
            }
        }
        if (!z) {
            m mVar2 = new m(bVar, j);
            mVar2.dd(0L);
            mVar2.il(false);
            mVar2.nF(bVar.getTag());
            bVar.a(mVar2);
        }
    }

    private void b(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        k kVar;
        com.baidu.tbadk.BdToken.b bgE;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bfE().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof k) && (bgE = (kVar = (k) next).bgE()) != null && kVar.getTid() == j && bgE.getActivityId() == bVar.getActivityId() && bgE.bfP() == bVar.bfP()) {
                z = true;
                break;
            }
        }
        if (!z) {
            k kVar2 = new k(bVar, j);
            kVar2.dd(0L);
            kVar2.il(false);
            kVar2.nF(bVar.getTag());
            bVar.a(kVar2);
        }
    }

    public void q(int i, long j) {
        boolean z;
        if (isMainProcess() && i != 0 && j != 0 && this.eqR) {
            this.eqW = i;
            List<com.baidu.tbadk.BdToken.b> list = this.eqN.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 2) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bfE().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof j) && next.bgE().getActivityId() == bVar.getActivityId() && next.bgE().bfP() == bVar.bfP() && ((j) next).getFid() == j) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            j jVar = new j(bVar, j);
                            jVar.dd(0L);
                            jVar.il(false);
                            jVar.nF(bVar.getTag());
                            bVar.a(jVar);
                        }
                        z2 = z;
                    }
                }
                this.eqP.nH(i);
                this.eqP.setFid(j);
                this.eqQ.compareAndSet(false, true);
                synchronized (this.eqQ) {
                    this.eqQ.notify();
                }
            }
        }
    }

    public void nG(int i) {
        boolean z;
        if (isMainProcess() && i != 0 && this.eqR) {
            this.eqW = i;
            List<com.baidu.tbadk.BdToken.b> list = this.eqN.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 4) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bfE().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof i) && next.bgE().getActivityId() == bVar.getActivityId() && next.bgE().bfP() == bVar.bfP()) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            i iVar = new i(bVar);
                            iVar.dd(0L);
                            iVar.il(false);
                            bVar.a(iVar);
                        }
                        z2 = z;
                    }
                }
                this.eqP.nH(i);
                this.eqQ.compareAndSet(false, true);
                synchronized (this.eqQ) {
                    this.eqQ.notify();
                }
            }
        }
    }

    public void bgr() {
        int i;
        List<com.baidu.tbadk.BdToken.b> list;
        boolean z;
        if (isMainProcess() && this.eqR && (list = this.eqN.get((i = com.baidu.tbadk.BdToken.b.eqc))) != null && !list.isEmpty()) {
            boolean z2 = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 8) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bfE().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = z2;
                            break;
                        }
                        com.baidu.tbadk.BdToken.h next = it.next();
                        com.baidu.tbadk.BdToken.b bgE = next.bgE();
                        if (bgE != null && (next instanceof l) && bgE.getActivityId() == bVar.getActivityId() && bgE.bfP() == bVar.bfP()) {
                            ((l) next).bgG();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        l lVar = new l(bVar);
                        lVar.dd(0L);
                        lVar.il(false);
                        bVar.a(lVar);
                    }
                    z2 = z;
                }
            }
            this.eqP.nH(i);
            this.eqQ.compareAndSet(false, true);
            synchronized (this.eqQ) {
                this.eqQ.notify();
            }
        }
    }

    private void startTimer() {
        this.eqM.scheduleWithFixedDelay(this.eqP, 0L, 1L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tbadk.BdToken.b bVar) {
        int[] bfU;
        for (int i : bVar.bfU()) {
            List<com.baidu.tbadk.BdToken.b> list = this.eqN.get(i);
            if (list == null) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(bVar);
                this.eqN.put(i, linkedList);
            } else {
                list.add(bVar);
            }
        }
    }

    private boolean g(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return false;
        }
        int[] bfU = bVar.bfU();
        if (bfU == null) {
            return true;
        }
        for (int i : bfU) {
            List<com.baidu.tbadk.BdToken.b> list = this.eqN.get(i);
            if (list == null) {
                return false;
            }
            for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.bfP() == bVar.bfP()) {
                    if (bVar2.bfM()) {
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
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bfE().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.bgE() != null) {
                    com.baidu.tbadk.BdToken.b bgE = next.bgE();
                    if (bgE.getActivityId() == bVar.getActivityId() && bgE.bfP() == bVar.bfP()) {
                        if (taskType == 7 && (next instanceof k)) {
                            ((k) next).il(true);
                        } else if (taskType == 1 && (next instanceof m)) {
                            ((m) next).il(true);
                        }
                    }
                }
            }
            bVar.ik(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar != null) {
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bfE().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.bgE() != null) {
                    com.baidu.tbadk.BdToken.b bgE = next.bgE();
                    if (bgE.getActivityId() == bVar.getActivityId() && bgE.bfP() == bVar.bfP()) {
                        it.remove();
                    }
                }
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eqN.size()) {
                    List<com.baidu.tbadk.BdToken.b> valueAt = this.eqN.valueAt(i2);
                    if (valueAt != null && !valueAt.isEmpty()) {
                        Iterator<com.baidu.tbadk.BdToken.b> it2 = valueAt.iterator();
                        while (it2.hasNext()) {
                            com.baidu.tbadk.BdToken.b next2 = it2.next();
                            if (next2 != null && next2.getActivityId() == bVar.getActivityId() && next2.bfP() == bVar.bfP()) {
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
                p.bgK().q(bVar);
            } else if (!this.eqR) {
                this.eqO.add(bVar);
            } else if (!g(bVar)) {
                f(bVar);
                new b().execute(bVar);
            }
        }
    }

    public void ba(List<com.baidu.tbadk.BdToken.b> list) {
        if (!y.isEmpty(list)) {
            if (!this.eqR) {
                this.eqO.addAll(list);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar != null) {
                    if (bVar.getTaskType() == 9) {
                        p.bgK().q(bVar);
                    } else if (!g(bVar)) {
                        f(bVar);
                        arrayList.add(bVar);
                    }
                }
            }
            new C0570c().execute(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.BdToken.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0570c extends BdAsyncTask<List<com.baidu.tbadk.BdToken.b>, Integer, Void> {
        private C0570c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(List<com.baidu.tbadk.BdToken.b>... listArr) {
            if (listArr != null && listArr.length > 0 && listArr[0] != null) {
                com.baidu.tbadk.BdToken.a.bfB().ba(listArr[0]);
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
            linkedList.addAll(com.baidu.tbadk.BdToken.a.bfB().bfC());
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next != null && next.bfM()) {
                    com.baidu.tbadk.BdToken.a.bfB().c(next);
                    it.remove();
                } else if (next.getTaskType() == 7) {
                    next.bfG();
                    com.baidu.tbadk.BdToken.a.bfB().b(next);
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
                        if (next.bfU() != null) {
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
                com.baidu.tbadk.BdToken.a.bfB().a(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.bfB().c(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.bfB().c(bVar2);
            }
            if (bVar != null) {
                com.baidu.tbadk.BdToken.a.bfB().a(bVar);
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
            com.baidu.tbadk.BdToken.a.bfB().b(bVar);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(com.baidu.tbadk.BdToken.b bVar) {
            if (bVar != null && bVar.eqK) {
                bVar.eqK = false;
                c.this.p(c.this.eqW, c.this.eqX);
            }
        }
    }

    public void bgs() {
        List<com.baidu.tbadk.BdToken.b> list = this.eqN.get(com.baidu.tbadk.BdToken.b.eqc);
        if (!y.isEmpty(list)) {
            boolean z = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bfE().iterator();
                boolean z2 = z;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof l) {
                        l lVar = (l) next;
                        if (!next.ik()) {
                            lVar.bgG();
                            z2 = true;
                        }
                    }
                }
                z = z2;
            }
            if (z && !this.eqQ.get()) {
                this.eqP.nH(com.baidu.tbadk.BdToken.b.eqc);
                this.eqQ.compareAndSet(false, true);
                synchronized (this.eqQ) {
                    this.eqQ.notify();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private volatile long eqw;
        private volatile int erf;
        private volatile boolean erg;
        private volatile long mFid;

        private a() {
            this.erg = false;
        }

        public synchronized void nH(int i) {
            this.erf = i;
        }

        public synchronized void setTid(long j) {
            this.eqw = j;
        }

        public synchronized void setFid(long j) {
            this.mFid = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.erf == 0 || !c.this.eqQ.get()) {
                synchronized (c.this.eqQ) {
                    try {
                        c.this.eqQ.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            bgt();
        }

        private void bgt() {
            this.erg = true;
            List<com.baidu.tbadk.BdToken.b> list = (List) c.this.eqN.get(com.baidu.tbadk.BdToken.b.eqc);
            List<com.baidu.tbadk.BdToken.b> list2 = (List) c.this.eqN.get(this.erf);
            if (y.isEmpty(list) && y.isEmpty(list2)) {
                c.this.eqQ.compareAndSet(true, false);
                return;
            }
            d.b bVar = new d.b();
            bVar.etI = new LinkedList();
            bVar.etJ = new LinkedList();
            bVar.etK = new LinkedList();
            a(list, bVar);
            b(list2, bVar);
            if (this.erg) {
                c.this.eqQ.compareAndSet(true, false);
            }
            if (!y.isEmpty(bVar.etK)) {
                com.baidu.tbadk.BdToken.a.bfB().bb(bVar.etK);
            }
            if (!y.isEmpty(bVar.etI) || !y.isEmpty(bVar.etJ)) {
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
            ArrayList<com.baidu.tbadk.BdToken.h> bfE;
            if (bVar != null && bVar2 != null && (bfE = bVar.bfE()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bfE.iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if ((next instanceof l) && !((l) next).isTimeout() && !next.ik()) {
                        this.erg = false;
                        next.nI(1);
                        if (next.bgF() >= next.bgE().bfV()) {
                            next.il(true);
                            bVar2.s(bVar);
                        }
                        bVar2.t(bVar);
                    }
                }
            }
        }

        private void b(com.baidu.tbadk.BdToken.b bVar, d.b bVar2) {
            ArrayList<com.baidu.tbadk.BdToken.h> bfE;
            if (bVar != null && bVar2 != null && (bfE = bVar.bfE()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bfE.iterator();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof m) {
                        m mVar = (m) next;
                        if (this.eqw != 0 && mVar.getTid() == this.eqw && !next.ik()) {
                            this.erg = false;
                            next.nI(1);
                            if (next.bgF() >= next.bgE().bfV()) {
                                next.il(true);
                                if (next.bgE().bfK() >= next.bgE().getThreadNum()) {
                                    bVar2.c(next);
                                }
                            }
                            bVar2.t(bVar);
                        }
                    } else if (next instanceof k) {
                        k kVar = (k) next;
                        if (!bVar.bge() && kVar.getTag() == bVar.getTag()) {
                            if (this.eqw != 0 && kVar.getTid() == this.eqw && !next.ik()) {
                                this.erg = false;
                                next.nI(1);
                            }
                            i = (int) (i + next.bgF());
                            if (this.eqw != 0 && kVar.getTid() == this.eqw && !next.ik()) {
                                if (next.bgF() >= bVar.bfV()) {
                                    next.il(true);
                                    bVar.bfK();
                                }
                                bVar2.t(bVar);
                            }
                            int bfF = bVar.bfF();
                            int threadNum = bVar.getThreadNum();
                            if (i >= bVar.bfV() * bVar.getThreadNum() && bfF >= threadNum) {
                                bVar2.s(bVar);
                                bVar.ik(true);
                            }
                        }
                    } else if (next instanceof j) {
                        if (this.mFid != 0 && ((j) next).getFid() == this.mFid && !next.ik()) {
                            this.erg = false;
                            next.nI(1);
                            if (next.bgF() >= next.bgE().bfV()) {
                                next.il(true);
                                if (next.bgE().bfJ() >= next.bgE().bfW()) {
                                    bVar2.c(next);
                                }
                            }
                        }
                    } else if ((next instanceof i) && !next.ik()) {
                        this.erg = false;
                        next.nI(1);
                        if (next.bgF() >= next.bgE().bfV()) {
                            next.il(true);
                            bVar2.c(next);
                        }
                    }
                }
            }
        }
    }
}
