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
    private boolean eFA;
    private com.baidu.tbadk.BdToken.completeTask.d eFB;
    private com.baidu.tbadk.BdToken.activeConfig.b eFC;
    private com.baidu.tbadk.BdToken.backUser.b eFD;
    private int eFE;
    private long eFF;
    private long eFG;
    private int eFH;
    private long eFI;
    private CustomMessageListener eFJ;
    private com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a> eFK;
    private com.baidu.tbadk.h.b eFL;
    private final ScheduledExecutorService eFu;
    private final SparseArray<List<com.baidu.tbadk.BdToken.b>> eFv;
    private final LinkedList<com.baidu.tbadk.BdToken.b> eFw;
    private a eFx;
    private AtomicBoolean eFy;
    private boolean eFz;
    private boolean isSchemaUp;
    private CustomMessageListener mBackgroundListener;
    private BdUniqueId mBdUniqueId;
    private CustomMessageListener mSyncFinishListener;

    public static final c bkU() {
        return g.eFP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g {
        private static final c eFP = new c();
    }

    private c() {
        this.eFu = Executors.newSingleThreadScheduledExecutor();
        this.eFv = new SparseArray<>();
        this.eFw = new LinkedList<>();
        this.eFx = new a();
        this.eFy = new AtomicBoolean(false);
        this.eFz = false;
        this.eFA = false;
        this.isSchemaUp = false;
        this.eFJ = new CustomMessageListener(2921391) { // from class: com.baidu.tbadk.BdToken.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.eFz = true;
                if (!c.this.eFw.isEmpty()) {
                    Iterator it = c.this.eFw.iterator();
                    while (it.hasNext()) {
                        c.this.l((com.baidu.tbadk.BdToken.b) it.next());
                    }
                    c.this.eFw.clear();
                }
            }
        };
        this.mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.BdToken.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                    ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                    c.this.bkW();
                }
            }
        };
        this.mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tbadk.BdToken.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                    c.this.eFA = true;
                    c.this.bkW();
                }
            }
        };
        this.eFK = new com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a>() { // from class: com.baidu.tbadk.BdToken.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: a */
            public void onSuccess(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null) {
                    c.this.bk(aVar.bmd());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: b */
            public void as(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null && aVar.eHU != null && aVar.eHU.mission != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b();
                    bVar.a(aVar.eHU.mission);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(bVar);
                    c.this.bk(arrayList);
                }
            }

            @Override // com.baidu.tbadk.h.a
            public void onError(int i, String str) {
            }
        };
        this.eFL = new com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b>() { // from class: com.baidu.tbadk.BdToken.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.b
            /* renamed from: m */
            public void onProgressUpdate(com.baidu.tbadk.BdToken.b bVar) {
                if (bVar != null) {
                    com.baidu.tbadk.BdToken.b e2 = c.this.e(bVar);
                    if (e2 != null && e2.eFs) {
                        e2.reset();
                        c.this.j(e2);
                        return;
                    }
                    n.blw().o(e2);
                    if (e2 != null && e2.getTaskType() == 7) {
                        e2.bkA();
                        int bkS = e2.bkS();
                        int tag = e2.getTag();
                        if (bkS <= 1 || bkS <= tag) {
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
        this.eFB = new com.baidu.tbadk.BdToken.completeTask.d(this.mBdUniqueId);
        this.eFB.a(this.eFL);
        this.eFC = new com.baidu.tbadk.BdToken.activeConfig.b(this.mBdUniqueId);
        this.eFC.a(this.eFK);
        this.eFD = new com.baidu.tbadk.BdToken.backUser.b(this.mBdUniqueId);
        this.mSyncFinishListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        this.mBackgroundListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mBackgroundListener);
        this.eFJ.setPriority(Integer.MIN_VALUE);
        this.eFJ.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.eFJ);
        com.baidu.tbadk.core.f.a.bvn().init();
        p.blz().i(this.mBdUniqueId);
        startTimer();
        if (isMainProcess()) {
            new f().execute(new Void[0]);
        }
    }

    private boolean isMainProcess() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public void bkV() {
        if (this.eFD != null && isMainProcess()) {
            this.eFD.bmh();
        }
    }

    public void bkW() {
        if (this.eFC != null && isMainProcess() && this.eFA && !bla()) {
            this.eFC.d(bkY(), bkZ(), 0);
        }
    }

    public boolean bkX() {
        if (this.eFC != null && isMainProcess()) {
            this.eFC.d(bkY(), bkZ(), 1);
            return true;
        }
        return false;
    }

    public boolean bkY() {
        return !blb();
    }

    public boolean bkZ() {
        return this.isSchemaUp;
    }

    public void setSchemaUp(boolean z) {
        this.isSchemaUp = z;
    }

    public boolean bla() {
        return UtilHelper.isSameDay(bld(), System.currentTimeMillis());
    }

    public boolean blb() {
        return UtilHelper.isSameDay(com.baidu.tbadk.core.sharedPref.b.bvr().getLong("pref_key_last_active_config", 0L), System.currentTimeMillis());
    }

    public boolean blc() {
        return UtilHelper.isSameDay(com.baidu.tbadk.core.sharedPref.b.bvr().getLong("pref_key_last_popup_time", 0L), System.currentTimeMillis());
    }

    private long bld() {
        this.eFI = com.baidu.tbadk.core.sharedPref.b.bvr().getLong("pref_key_active_config_info", 0L);
        return this.eFI;
    }

    public int ble() {
        return this.eFH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.BdToken.b e(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.eFv.size()) {
                return null;
            }
            List<com.baidu.tbadk.BdToken.b> valueAt = this.eFv.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar2 : valueAt) {
                    if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.bkE() == bVar.bkE()) {
                        return bVar2;
                    }
                }
                continue;
            }
            i = i2 + 1;
        }
    }

    public void blf() {
        this.eFy.compareAndSet(true, false);
        this.eFx.ok(0);
        this.eFx.setTid(0L);
        this.eFx.setFid(0L);
        if (this.eFB != null) {
            this.eFB.bmk();
        }
    }

    public void n(int i, long j) {
        if (isMainProcess()) {
            this.eFH = i;
            this.eFG = j;
            if (this.eFF > 0 && this.eFE > 0 && (j == 0 || j != this.eFF)) {
                o(this.eFE, this.eFF);
                this.eFF = 0L;
                this.eFE = 0;
            }
            blg();
        }
    }

    public void o(int i, long j) {
        k kVar;
        com.baidu.tbadk.BdToken.b blt;
        List<com.baidu.tbadk.BdToken.b> list = this.eFv.get(i);
        if (list != null && !list.isEmpty()) {
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 7) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bkt().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof k) && (blt = (kVar = (k) next).blt()) != null && kVar.getTid() == j && blt.getActivityId() == bVar.getActivityId() && blt.bkE() == bVar.bkE()) {
                                next.iY(true);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void p(int i, long j) {
        if (isMainProcess() && i != 0 && j != 0 && this.eFz) {
            this.eFE = i;
            List<com.baidu.tbadk.BdToken.b> list = this.eFv.get(i);
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
                this.eFx.ok(i);
                this.eFx.setTid(j);
                this.eFF = j;
                this.eFy.compareAndSet(false, true);
                synchronized (this.eFy) {
                    this.eFy.notify();
                }
            }
        }
    }

    private void a(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        m mVar;
        com.baidu.tbadk.BdToken.b blt;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bkt().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof m) && (blt = (mVar = (m) next).blt()) != null && mVar.getTid() == j && blt.getActivityId() == bVar.getActivityId() && blt.bkE() == bVar.bkE()) {
                z = true;
                break;
            }
        }
        if (!z) {
            m mVar2 = new m(bVar, j);
            mVar2.dC(0L);
            mVar2.iY(false);
            mVar2.oi(bVar.getTag());
            bVar.a(mVar2);
        }
    }

    private void b(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        k kVar;
        com.baidu.tbadk.BdToken.b blt;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bkt().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof k) && (blt = (kVar = (k) next).blt()) != null && kVar.getTid() == j && blt.getActivityId() == bVar.getActivityId() && blt.bkE() == bVar.bkE()) {
                z = true;
                break;
            }
        }
        if (!z) {
            k kVar2 = new k(bVar, j);
            kVar2.dC(0L);
            kVar2.iY(false);
            kVar2.oi(bVar.getTag());
            bVar.a(kVar2);
        }
    }

    public void q(int i, long j) {
        boolean z;
        if (isMainProcess() && i != 0 && j != 0 && this.eFz) {
            this.eFE = i;
            List<com.baidu.tbadk.BdToken.b> list = this.eFv.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 2) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bkt().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof j) && next.blt().getActivityId() == bVar.getActivityId() && next.blt().bkE() == bVar.bkE() && ((j) next).getFid() == j) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            j jVar = new j(bVar, j);
                            jVar.dC(0L);
                            jVar.iY(false);
                            jVar.oi(bVar.getTag());
                            bVar.a(jVar);
                        }
                        z2 = z;
                    }
                }
                this.eFx.ok(i);
                this.eFx.setFid(j);
                this.eFy.compareAndSet(false, true);
                synchronized (this.eFy) {
                    this.eFy.notify();
                }
            }
        }
    }

    public void oj(int i) {
        boolean z;
        if (isMainProcess() && i != 0 && this.eFz) {
            this.eFE = i;
            List<com.baidu.tbadk.BdToken.b> list = this.eFv.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 4) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bkt().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof i) && next.blt().getActivityId() == bVar.getActivityId() && next.blt().bkE() == bVar.bkE()) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            i iVar = new i(bVar);
                            iVar.dC(0L);
                            iVar.iY(false);
                            bVar.a(iVar);
                        }
                        z2 = z;
                    }
                }
                this.eFx.ok(i);
                this.eFy.compareAndSet(false, true);
                synchronized (this.eFy) {
                    this.eFy.notify();
                }
            }
        }
    }

    public void blg() {
        int i;
        List<com.baidu.tbadk.BdToken.b> list;
        boolean z;
        if (isMainProcess() && this.eFz && (list = this.eFv.get((i = com.baidu.tbadk.BdToken.b.eEK))) != null && !list.isEmpty()) {
            boolean z2 = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 8) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bkt().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = z2;
                            break;
                        }
                        com.baidu.tbadk.BdToken.h next = it.next();
                        com.baidu.tbadk.BdToken.b blt = next.blt();
                        if (blt != null && (next instanceof l) && blt.getActivityId() == bVar.getActivityId() && blt.bkE() == bVar.bkE()) {
                            ((l) next).blv();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        l lVar = new l(bVar);
                        lVar.dC(0L);
                        lVar.iY(false);
                        bVar.a(lVar);
                    }
                    z2 = z;
                }
            }
            this.eFx.ok(i);
            this.eFy.compareAndSet(false, true);
            synchronized (this.eFy) {
                this.eFy.notify();
            }
        }
    }

    private void startTimer() {
        this.eFu.scheduleWithFixedDelay(this.eFx, 0L, 1L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tbadk.BdToken.b bVar) {
        int[] bkJ;
        for (int i : bVar.bkJ()) {
            List<com.baidu.tbadk.BdToken.b> list = this.eFv.get(i);
            if (list == null) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(bVar);
                this.eFv.put(i, linkedList);
            } else {
                list.add(bVar);
            }
        }
    }

    private boolean g(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return false;
        }
        int[] bkJ = bVar.bkJ();
        if (bkJ == null) {
            return true;
        }
        for (int i : bkJ) {
            List<com.baidu.tbadk.BdToken.b> list = this.eFv.get(i);
            if (list == null) {
                return false;
            }
            for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.bkE() == bVar.bkE()) {
                    if (bVar2.bkB()) {
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
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bkt().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.blt() != null) {
                    com.baidu.tbadk.BdToken.b blt = next.blt();
                    if (blt.getActivityId() == bVar.getActivityId() && blt.bkE() == bVar.bkE()) {
                        if (taskType == 7 && (next instanceof k)) {
                            ((k) next).iY(true);
                        } else if (taskType == 1 && (next instanceof m)) {
                            ((m) next).iY(true);
                        }
                    }
                }
            }
            bVar.iX(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar != null) {
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bkt().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.blt() != null) {
                    com.baidu.tbadk.BdToken.b blt = next.blt();
                    if (blt.getActivityId() == bVar.getActivityId() && blt.bkE() == bVar.bkE()) {
                        it.remove();
                    }
                }
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.eFv.size()) {
                    List<com.baidu.tbadk.BdToken.b> valueAt = this.eFv.valueAt(i2);
                    if (valueAt != null && !valueAt.isEmpty()) {
                        Iterator<com.baidu.tbadk.BdToken.b> it2 = valueAt.iterator();
                        while (it2.hasNext()) {
                            com.baidu.tbadk.BdToken.b next2 = it2.next();
                            if (next2 != null && next2.getActivityId() == bVar.getActivityId() && next2.bkE() == bVar.bkE()) {
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
                p.blz().q(bVar);
            } else if (!this.eFz) {
                this.eFw.add(bVar);
            } else if (!g(bVar)) {
                f(bVar);
                new b().execute(bVar);
            }
        }
    }

    public void bk(List<com.baidu.tbadk.BdToken.b> list) {
        if (!com.baidu.tbadk.core.util.x.isEmpty(list)) {
            if (!this.eFz) {
                this.eFw.addAll(list);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar != null) {
                    if (bVar.getTaskType() == 9) {
                        p.blz().q(bVar);
                    } else if (!g(bVar)) {
                        f(bVar);
                        arrayList.add(bVar);
                    }
                }
            }
            new C0571c().execute(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.BdToken.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0571c extends BdAsyncTask<List<com.baidu.tbadk.BdToken.b>, Integer, Void> {
        private C0571c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(List<com.baidu.tbadk.BdToken.b>... listArr) {
            if (listArr != null && listArr.length > 0 && listArr[0] != null) {
                com.baidu.tbadk.BdToken.a.bkq().bk(listArr[0]);
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
            linkedList.addAll(com.baidu.tbadk.BdToken.a.bkq().bkr());
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next != null && next.bkB()) {
                    com.baidu.tbadk.BdToken.a.bkq().c(next);
                    it.remove();
                } else if (next.getTaskType() == 7) {
                    next.bkv();
                    com.baidu.tbadk.BdToken.a.bkq().b(next);
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
                        if (next.bkJ() != null) {
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
                com.baidu.tbadk.BdToken.a.bkq().a(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.bkq().c(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.bkq().c(bVar2);
            }
            if (bVar != null) {
                com.baidu.tbadk.BdToken.a.bkq().a(bVar);
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
            com.baidu.tbadk.BdToken.a.bkq().b(bVar);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(com.baidu.tbadk.BdToken.b bVar) {
            if (bVar != null && bVar.eFs) {
                bVar.eFs = false;
                c.this.p(c.this.eFE, c.this.eFF);
            }
        }
    }

    public void blh() {
        List<com.baidu.tbadk.BdToken.b> list = this.eFv.get(com.baidu.tbadk.BdToken.b.eEK);
        if (!com.baidu.tbadk.core.util.x.isEmpty(list)) {
            boolean z = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bVar.bkt().iterator();
                boolean z2 = z;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof l) {
                        l lVar = (l) next;
                        if (!next.isCompleted()) {
                            lVar.blv();
                            z2 = true;
                        }
                    }
                }
                z = z2;
            }
            if (z && !this.eFy.get()) {
                this.eFx.ok(com.baidu.tbadk.BdToken.b.eEK);
                this.eFy.compareAndSet(false, true);
                synchronized (this.eFy) {
                    this.eFy.notify();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private volatile int eFN;
        private volatile boolean eFO;
        private volatile long eFe;
        private volatile long mFid;

        private a() {
            this.eFO = false;
        }

        public synchronized void ok(int i) {
            this.eFN = i;
        }

        public synchronized void setTid(long j) {
            this.eFe = j;
        }

        public synchronized void setFid(long j) {
            this.mFid = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.eFN == 0 || !c.this.eFy.get()) {
                synchronized (c.this.eFy) {
                    try {
                        c.this.eFy.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            bli();
        }

        private void bli() {
            this.eFO = true;
            List<com.baidu.tbadk.BdToken.b> list = (List) c.this.eFv.get(com.baidu.tbadk.BdToken.b.eEK);
            List<com.baidu.tbadk.BdToken.b> list2 = (List) c.this.eFv.get(this.eFN);
            if (com.baidu.tbadk.core.util.x.isEmpty(list) && com.baidu.tbadk.core.util.x.isEmpty(list2)) {
                c.this.eFy.compareAndSet(true, false);
                return;
            }
            d.b bVar = new d.b();
            bVar.eID = new LinkedList();
            bVar.eIE = new LinkedList();
            bVar.eIF = new LinkedList();
            a(list, bVar);
            b(list2, bVar);
            if (this.eFO) {
                c.this.eFy.compareAndSet(true, false);
            }
            if (!com.baidu.tbadk.core.util.x.isEmpty(bVar.eIF)) {
                com.baidu.tbadk.BdToken.a.bkq().bl(bVar.eIF);
            }
            if (!com.baidu.tbadk.core.util.x.isEmpty(bVar.eID) || !com.baidu.tbadk.core.util.x.isEmpty(bVar.eIE)) {
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
            ArrayList<com.baidu.tbadk.BdToken.h> bkt;
            if (bVar != null && bVar2 != null && (bkt = bVar.bkt()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bkt.iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if ((next instanceof l) && !((l) next).isTimeout() && !next.isCompleted()) {
                        this.eFO = false;
                        next.ol(1);
                        if (next.blu() >= next.blt().bkK()) {
                            next.iY(true);
                            bVar2.s(bVar);
                        }
                        bVar2.t(bVar);
                    }
                }
            }
        }

        private void b(com.baidu.tbadk.BdToken.b bVar, d.b bVar2) {
            ArrayList<com.baidu.tbadk.BdToken.h> bkt;
            if (bVar != null && bVar2 != null && (bkt = bVar.bkt()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bkt.iterator();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof m) {
                        m mVar = (m) next;
                        if (this.eFe != 0 && mVar.getTid() == this.eFe && !next.isCompleted()) {
                            this.eFO = false;
                            next.ol(1);
                            if (next.blu() >= next.blt().bkK()) {
                                next.iY(true);
                                if (next.blt().bkz() >= next.blt().getThreadNum()) {
                                    bVar2.c(next);
                                }
                            }
                            bVar2.t(bVar);
                        }
                    } else if (next instanceof k) {
                        k kVar = (k) next;
                        if (!bVar.bkT() && kVar.getTag() == bVar.getTag()) {
                            if (this.eFe != 0 && kVar.getTid() == this.eFe && !next.isCompleted()) {
                                this.eFO = false;
                                next.ol(1);
                            }
                            i = (int) (i + next.blu());
                            if (this.eFe != 0 && kVar.getTid() == this.eFe && !next.isCompleted()) {
                                if (next.blu() >= bVar.bkK()) {
                                    next.iY(true);
                                    bVar.bkz();
                                }
                                bVar2.t(bVar);
                            }
                            int bku = bVar.bku();
                            int threadNum = bVar.getThreadNum();
                            if (i >= bVar.bkK() * bVar.getThreadNum() && bku >= threadNum) {
                                bVar2.s(bVar);
                                bVar.iX(true);
                            }
                        }
                    } else if (next instanceof j) {
                        if (this.mFid != 0 && ((j) next).getFid() == this.mFid && !next.isCompleted()) {
                            this.eFO = false;
                            next.ol(1);
                            if (next.blu() >= next.blt().bkK()) {
                                next.iY(true);
                                if (next.blt().bky() >= next.blt().bkL()) {
                                    bVar2.c(next);
                                }
                            }
                        }
                    } else if ((next instanceof i) && !next.isCompleted()) {
                        this.eFO = false;
                        next.ol(1);
                        if (next.blu() >= next.blt().bkK()) {
                            next.iY(true);
                            bVar2.c(next);
                        }
                    }
                }
            }
        }
    }
}
