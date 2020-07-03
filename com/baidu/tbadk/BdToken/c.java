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
    private com.baidu.tbadk.h.b dzA;
    private final ScheduledExecutorService dzk;
    private final SparseArray<List<com.baidu.tbadk.BdToken.b>> dzl;
    private final LinkedList<com.baidu.tbadk.BdToken.b> dzm;
    private a dzn;
    private AtomicBoolean dzo;
    private boolean dzp;
    private boolean dzq;
    private com.baidu.tbadk.BdToken.completeTask.d dzr;
    private com.baidu.tbadk.BdToken.activeConfig.b dzs;
    private int dzt;
    private long dzu;
    private long dzv;
    private int dzw;
    private long dzx;
    private CustomMessageListener dzy;
    private com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a> dzz;
    private boolean isSchemaUp;
    private CustomMessageListener mBackgroundListener;
    private BdUniqueId mBdUniqueId;
    private CustomMessageListener mSyncFinishListener;

    public static final c aMo() {
        return g.dzE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g {
        private static final c dzE = new c();
    }

    private c() {
        this.dzk = Executors.newSingleThreadScheduledExecutor();
        this.dzl = new SparseArray<>();
        this.dzm = new LinkedList<>();
        this.dzn = new a();
        this.dzo = new AtomicBoolean(false);
        this.dzp = false;
        this.dzq = false;
        this.isSchemaUp = false;
        this.dzy = new CustomMessageListener(2921391) { // from class: com.baidu.tbadk.BdToken.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.dzp = true;
                if (!c.this.dzm.isEmpty()) {
                    Iterator it = c.this.dzm.iterator();
                    while (it.hasNext()) {
                        c.this.l((com.baidu.tbadk.BdToken.b) it.next());
                    }
                    c.this.dzm.clear();
                }
            }
        };
        this.mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.BdToken.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                    ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                    c.this.aMp();
                }
            }
        };
        this.mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tbadk.BdToken.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                    c.this.dzq = true;
                    c.this.aMp();
                }
            }
        };
        this.dzz = new com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a>() { // from class: com.baidu.tbadk.BdToken.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: a */
            public void onSuccess(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null) {
                    c.this.aw(aVar.aNx());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: b */
            public void ak(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null && aVar.dBC != null && aVar.dBC.mission != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b();
                    bVar.a(aVar.dBC.mission);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(bVar);
                    c.this.aw(arrayList);
                }
            }

            @Override // com.baidu.tbadk.h.a
            public void onError(int i, String str) {
            }
        };
        this.dzA = new com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b>() { // from class: com.baidu.tbadk.BdToken.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.b
            /* renamed from: m */
            public void onProgressUpdate(com.baidu.tbadk.BdToken.b bVar) {
                if (bVar != null) {
                    com.baidu.tbadk.BdToken.b e2 = c.this.e(bVar);
                    if (e2 != null && e2.dzi) {
                        e2.reset();
                        c.this.j(e2);
                        return;
                    }
                    n.aMP().o(e2);
                    if (e2 != null && e2.getTaskType() == 7) {
                        e2.aLU();
                        int aMm = e2.aMm();
                        int tag = e2.getTag();
                        if (aMm <= 1 || aMm <= tag) {
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
        this.dzr = new com.baidu.tbadk.BdToken.completeTask.d(this.mBdUniqueId);
        this.dzr.a(this.dzA);
        this.dzs = new com.baidu.tbadk.BdToken.activeConfig.b(this.mBdUniqueId);
        this.dzs.a(this.dzz);
        this.mSyncFinishListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        this.mBackgroundListener.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.mBackgroundListener);
        this.dzy.setPriority(Integer.MIN_VALUE);
        this.dzy.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.dzy);
        com.baidu.tbadk.core.f.a.aVM().init();
        p.aMS().i(this.mBdUniqueId);
        startTimer();
        if (isMainProcess()) {
            new f().execute(new Void[0]);
        }
    }

    private boolean isMainProcess() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public void aMp() {
        if (this.dzs != null && isMainProcess() && this.dzq && !aMt()) {
            this.dzs.c(aMr(), aMs(), 0);
        }
    }

    public boolean aMq() {
        if (this.dzs != null && isMainProcess()) {
            this.dzs.c(aMr(), aMs(), 1);
            return true;
        }
        return false;
    }

    public boolean aMr() {
        return !aMu();
    }

    public boolean aMs() {
        return this.isSchemaUp;
    }

    public void setSchemaUp(boolean z) {
        this.isSchemaUp = z;
    }

    public boolean aMt() {
        return UtilHelper.isSameDay(aMw(), System.currentTimeMillis());
    }

    public boolean aMu() {
        return UtilHelper.isSameDay(com.baidu.tbadk.core.sharedPref.b.aVP().getLong("pref_key_last_active_config", 0L), System.currentTimeMillis());
    }

    public boolean aMv() {
        return UtilHelper.isSameDay(com.baidu.tbadk.core.sharedPref.b.aVP().getLong("pref_key_last_popup_time", 0L), System.currentTimeMillis());
    }

    private long aMw() {
        this.dzx = com.baidu.tbadk.core.sharedPref.b.aVP().getLong("pref_key_active_config_info", 0L);
        return this.dzx;
    }

    public int aMx() {
        return this.dzw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.BdToken.b e(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.dzl.size()) {
                return null;
            }
            List<com.baidu.tbadk.BdToken.b> valueAt = this.dzl.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar2 : valueAt) {
                    if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.aLY() == bVar.aLY()) {
                        return bVar2;
                    }
                }
                continue;
            }
            i = i2 + 1;
        }
    }

    public void aMy() {
        this.dzo.compareAndSet(true, false);
        this.dzn.kf(0);
        this.dzn.setTid(0L);
        this.dzn.setFid(0L);
        if (this.dzr != null) {
            this.dzr.aNB();
        }
    }

    public void n(int i, long j) {
        if (isMainProcess()) {
            this.dzw = i;
            this.dzv = j;
            if (this.dzu > 0 && this.dzt > 0 && (j == 0 || j != this.dzu)) {
                o(this.dzt, this.dzu);
                this.dzu = 0L;
                this.dzt = 0;
            }
            aMz();
        }
    }

    public void o(int i, long j) {
        k kVar;
        com.baidu.tbadk.BdToken.b aMM;
        List<com.baidu.tbadk.BdToken.b> list = this.dzl.get(i);
        if (list != null && !list.isEmpty()) {
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 7) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aLN().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof k) && (aMM = (kVar = (k) next).aMM()) != null && kVar.getTid() == j && aMM.getActivityId() == bVar.getActivityId() && aMM.aLY() == bVar.aLY()) {
                                next.gE(true);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void p(int i, long j) {
        if (isMainProcess() && i != 0 && j != 0 && this.dzp) {
            this.dzt = i;
            List<com.baidu.tbadk.BdToken.b> list = this.dzl.get(i);
            if (list != null && !list.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 1) {
                        a(bVar, j);
                    } else if (bVar.getTaskType() != 7) {
                        continue;
                    } else if (bVar.bS(j)) {
                        break;
                    } else {
                        b(bVar, j);
                    }
                }
                this.dzn.kf(i);
                this.dzn.setTid(j);
                this.dzu = j;
                this.dzo.compareAndSet(false, true);
                synchronized (this.dzo) {
                    this.dzo.notify();
                }
            }
        }
    }

    private void a(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        m mVar;
        com.baidu.tbadk.BdToken.b aMM;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aLN().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof m) && (aMM = (mVar = (m) next).aMM()) != null && mVar.getTid() == j && aMM.getActivityId() == bVar.getActivityId() && aMM.aLY() == bVar.aLY()) {
                z = true;
                break;
            }
        }
        if (!z) {
            m mVar2 = new m(bVar, j);
            mVar2.bX(0L);
            mVar2.gE(false);
            mVar2.kd(bVar.getTag());
            bVar.a(mVar2);
        }
    }

    private void b(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        k kVar;
        com.baidu.tbadk.BdToken.b aMM;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aLN().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof k) && (aMM = (kVar = (k) next).aMM()) != null && kVar.getTid() == j && aMM.getActivityId() == bVar.getActivityId() && aMM.aLY() == bVar.aLY()) {
                z = true;
                break;
            }
        }
        if (!z) {
            k kVar2 = new k(bVar, j);
            kVar2.bX(0L);
            kVar2.gE(false);
            kVar2.kd(bVar.getTag());
            bVar.a(kVar2);
        }
    }

    public void q(int i, long j) {
        boolean z;
        if (isMainProcess() && i != 0 && j != 0 && this.dzp) {
            this.dzt = i;
            List<com.baidu.tbadk.BdToken.b> list = this.dzl.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 2) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aLN().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof j) && next.aMM().getActivityId() == bVar.getActivityId() && next.aMM().aLY() == bVar.aLY() && ((j) next).getFid() == j) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            j jVar = new j(bVar, j);
                            jVar.bX(0L);
                            jVar.gE(false);
                            jVar.kd(bVar.getTag());
                            bVar.a(jVar);
                        }
                        z2 = z;
                    }
                }
                this.dzn.kf(i);
                this.dzn.setFid(j);
                this.dzo.compareAndSet(false, true);
                synchronized (this.dzo) {
                    this.dzo.notify();
                }
            }
        }
    }

    public void ke(int i) {
        boolean z;
        if (isMainProcess() && i != 0 && this.dzp) {
            this.dzt = i;
            List<com.baidu.tbadk.BdToken.b> list = this.dzl.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 4) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aLN().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof i) && next.aMM().getActivityId() == bVar.getActivityId() && next.aMM().aLY() == bVar.aLY()) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            i iVar = new i(bVar);
                            iVar.bX(0L);
                            iVar.gE(false);
                            bVar.a(iVar);
                        }
                        z2 = z;
                    }
                }
                this.dzn.kf(i);
                this.dzo.compareAndSet(false, true);
                synchronized (this.dzo) {
                    this.dzo.notify();
                }
            }
        }
    }

    public void aMz() {
        int i;
        List<com.baidu.tbadk.BdToken.b> list;
        boolean z;
        if (isMainProcess() && this.dzp && (list = this.dzl.get((i = com.baidu.tbadk.BdToken.b.dyA))) != null && !list.isEmpty()) {
            boolean z2 = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 8) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aLN().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = z2;
                            break;
                        }
                        com.baidu.tbadk.BdToken.h next = it.next();
                        com.baidu.tbadk.BdToken.b aMM = next.aMM();
                        if (aMM != null && (next instanceof l) && aMM.getActivityId() == bVar.getActivityId() && aMM.aLY() == bVar.aLY()) {
                            ((l) next).aMO();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        l lVar = new l(bVar);
                        lVar.bX(0L);
                        lVar.gE(false);
                        bVar.a(lVar);
                    }
                    z2 = z;
                }
            }
            this.dzn.kf(i);
            this.dzo.compareAndSet(false, true);
            synchronized (this.dzo) {
                this.dzo.notify();
            }
        }
    }

    private void startTimer() {
        this.dzk.scheduleWithFixedDelay(this.dzn, 0L, 1L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tbadk.BdToken.b bVar) {
        int[] aMd;
        for (int i : bVar.aMd()) {
            List<com.baidu.tbadk.BdToken.b> list = this.dzl.get(i);
            if (list == null) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(bVar);
                this.dzl.put(i, linkedList);
            } else {
                list.add(bVar);
            }
        }
    }

    private boolean g(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return false;
        }
        int[] aMd = bVar.aMd();
        if (aMd == null) {
            return true;
        }
        for (int i : aMd) {
            List<com.baidu.tbadk.BdToken.b> list = this.dzl.get(i);
            if (list == null) {
                return false;
            }
            for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.aLY() == bVar.aLY()) {
                    if (bVar2.aLV()) {
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
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aLN().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.aMM() != null) {
                    com.baidu.tbadk.BdToken.b aMM = next.aMM();
                    if (aMM.getActivityId() == bVar.getActivityId() && aMM.aLY() == bVar.aLY()) {
                        if (taskType == 7 && (next instanceof k)) {
                            ((k) next).gE(true);
                        } else if (taskType == 1 && (next instanceof m)) {
                            ((m) next).gE(true);
                        }
                    }
                }
            }
            bVar.gD(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar != null) {
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aLN().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.aMM() != null) {
                    com.baidu.tbadk.BdToken.b aMM = next.aMM();
                    if (aMM.getActivityId() == bVar.getActivityId() && aMM.aLY() == bVar.aLY()) {
                        it.remove();
                    }
                }
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.dzl.size()) {
                    List<com.baidu.tbadk.BdToken.b> valueAt = this.dzl.valueAt(i2);
                    if (valueAt != null && !valueAt.isEmpty()) {
                        Iterator<com.baidu.tbadk.BdToken.b> it2 = valueAt.iterator();
                        while (it2.hasNext()) {
                            com.baidu.tbadk.BdToken.b next2 = it2.next();
                            if (next2 != null && next2.getActivityId() == bVar.getActivityId() && next2.aLY() == bVar.aLY()) {
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
                p.aMS().q(bVar);
            } else if (!this.dzp) {
                this.dzm.add(bVar);
            } else if (!g(bVar)) {
                f(bVar);
                new b().execute(bVar);
            }
        }
    }

    public void aw(List<com.baidu.tbadk.BdToken.b> list) {
        if (!com.baidu.tbadk.core.util.w.isEmpty(list)) {
            if (!this.dzp) {
                this.dzm.addAll(list);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar != null) {
                    if (bVar.getTaskType() == 9) {
                        p.aMS().q(bVar);
                    } else if (!g(bVar)) {
                        f(bVar);
                        arrayList.add(bVar);
                    }
                }
            }
            new C0474c().execute(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.BdToken.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0474c extends BdAsyncTask<List<com.baidu.tbadk.BdToken.b>, Integer, Void> {
        private C0474c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(List<com.baidu.tbadk.BdToken.b>... listArr) {
            if (listArr != null && listArr.length > 0 && listArr[0] != null) {
                com.baidu.tbadk.BdToken.a.aLK().aw(listArr[0]);
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
            linkedList.addAll(com.baidu.tbadk.BdToken.a.aLK().aLL());
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next != null && next.aLV()) {
                    com.baidu.tbadk.BdToken.a.aLK().c(next);
                    it.remove();
                } else if (next.getTaskType() == 7) {
                    next.aLP();
                    com.baidu.tbadk.BdToken.a.aLK().b(next);
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
                        if (next.aMd() != null) {
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
                com.baidu.tbadk.BdToken.a.aLK().a(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.aLK().c(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.aLK().c(bVar2);
            }
            if (bVar != null) {
                com.baidu.tbadk.BdToken.a.aLK().a(bVar);
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
            com.baidu.tbadk.BdToken.a.aLK().b(bVar);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(com.baidu.tbadk.BdToken.b bVar) {
            if (bVar != null && bVar.dzi) {
                bVar.dzi = false;
                c.this.p(c.this.dzt, c.this.dzu);
            }
        }
    }

    public void aMA() {
        List<com.baidu.tbadk.BdToken.b> list = this.dzl.get(com.baidu.tbadk.BdToken.b.dyA);
        if (!com.baidu.tbadk.core.util.w.isEmpty(list)) {
            boolean z = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bVar.aLN().iterator();
                boolean z2 = z;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof l) {
                        l lVar = (l) next;
                        if (!next.gJ()) {
                            lVar.aMO();
                            z2 = true;
                        }
                    }
                }
                z = z2;
            }
            if (z && !this.dzo.get()) {
                this.dzn.kf(com.baidu.tbadk.BdToken.b.dyA);
                this.dzo.compareAndSet(false, true);
                synchronized (this.dzo) {
                    this.dzo.notify();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private volatile long dyU;
        private volatile int dzC;
        private volatile boolean dzD;
        private volatile long mFid;

        private a() {
            this.dzD = false;
        }

        public synchronized void kf(int i) {
            this.dzC = i;
        }

        public synchronized void setTid(long j) {
            this.dyU = j;
        }

        public synchronized void setFid(long j) {
            this.mFid = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.dzC == 0 || !c.this.dzo.get()) {
                synchronized (c.this.dzo) {
                    try {
                        c.this.dzo.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            aMB();
        }

        private void aMB() {
            this.dzD = true;
            List<com.baidu.tbadk.BdToken.b> list = (List) c.this.dzl.get(com.baidu.tbadk.BdToken.b.dyA);
            List<com.baidu.tbadk.BdToken.b> list2 = (List) c.this.dzl.get(this.dzC);
            if (com.baidu.tbadk.core.util.w.isEmpty(list) && com.baidu.tbadk.core.util.w.isEmpty(list2)) {
                c.this.dzo.compareAndSet(true, false);
                return;
            }
            d.b bVar = new d.b();
            bVar.dBY = new LinkedList();
            bVar.dBZ = new LinkedList();
            bVar.dCa = new LinkedList();
            a(list, bVar);
            b(list2, bVar);
            if (this.dzD) {
                c.this.dzo.compareAndSet(true, false);
            }
            if (!com.baidu.tbadk.core.util.w.isEmpty(bVar.dCa)) {
                com.baidu.tbadk.BdToken.a.aLK().ax(bVar.dCa);
            }
            if (!com.baidu.tbadk.core.util.w.isEmpty(bVar.dBY) || !com.baidu.tbadk.core.util.w.isEmpty(bVar.dBZ)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921379, bVar));
            }
        }

        private void a(List<com.baidu.tbadk.BdToken.b> list, d.b bVar) {
            if (!com.baidu.tbadk.core.util.w.isEmpty(list)) {
                for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                    a(bVar2, bVar);
                }
            }
        }

        private void b(List<com.baidu.tbadk.BdToken.b> list, d.b bVar) {
            if (!com.baidu.tbadk.core.util.w.isEmpty(list)) {
                for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                    b(bVar2, bVar);
                }
            }
        }

        private void a(com.baidu.tbadk.BdToken.b bVar, d.b bVar2) {
            ArrayList<com.baidu.tbadk.BdToken.h> aLN;
            if (bVar != null && bVar2 != null && (aLN = bVar.aLN()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = aLN.iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if ((next instanceof l) && !((l) next).isTimeout() && !next.gJ()) {
                        this.dzD = false;
                        next.kg(1);
                        if (next.aMN() >= next.aMM().aMe()) {
                            next.gE(true);
                            bVar2.s(bVar);
                        }
                        bVar2.t(bVar);
                    }
                }
            }
        }

        private void b(com.baidu.tbadk.BdToken.b bVar, d.b bVar2) {
            ArrayList<com.baidu.tbadk.BdToken.h> aLN;
            if (bVar != null && bVar2 != null && (aLN = bVar.aLN()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = aLN.iterator();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof m) {
                        m mVar = (m) next;
                        if (this.dyU != 0 && mVar.getTid() == this.dyU && !next.gJ()) {
                            this.dzD = false;
                            next.kg(1);
                            if (next.aMN() >= next.aMM().aMe()) {
                                next.gE(true);
                                if (next.aMM().aLT() >= next.aMM().getThreadNum()) {
                                    bVar2.c(next);
                                }
                            }
                            bVar2.t(bVar);
                        }
                    } else if (next instanceof k) {
                        k kVar = (k) next;
                        if (!bVar.aMn() && kVar.getTag() == bVar.getTag()) {
                            if (this.dyU != 0 && kVar.getTid() == this.dyU && !next.gJ()) {
                                this.dzD = false;
                                next.kg(1);
                            }
                            i = (int) (i + next.aMN());
                            if (this.dyU != 0 && kVar.getTid() == this.dyU && !next.gJ()) {
                                if (next.aMN() >= bVar.aMe()) {
                                    next.gE(true);
                                    bVar.aLT();
                                }
                                bVar2.t(bVar);
                            }
                            int aLO = bVar.aLO();
                            int threadNum = bVar.getThreadNum();
                            if (i >= bVar.aMe() * bVar.getThreadNum() && aLO >= threadNum) {
                                bVar2.s(bVar);
                                bVar.gD(true);
                            }
                        }
                    } else if (next instanceof j) {
                        if (this.mFid != 0 && ((j) next).getFid() == this.mFid && !next.gJ()) {
                            this.dzD = false;
                            next.kg(1);
                            if (next.aMN() >= next.aMM().aMe()) {
                                next.gE(true);
                                if (next.aMM().aLS() >= next.aMM().aMf()) {
                                    bVar2.c(next);
                                }
                            }
                        }
                    } else if ((next instanceof i) && !next.gJ()) {
                        this.dzD = false;
                        next.kg(1);
                        if (next.aMN() >= next.aMM().aMe()) {
                            next.gE(true);
                            bVar2.c(next);
                        }
                    }
                }
            }
        }
    }
}
