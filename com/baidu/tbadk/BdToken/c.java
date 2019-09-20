package com.baidu.tbadk.BdToken;

import android.util.Pair;
import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
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
    private final ScheduledExecutorService byV;
    private final SparseArray<List<com.baidu.tbadk.BdToken.b>> byW;
    private final LinkedList<com.baidu.tbadk.BdToken.b> byX;
    private a byY;
    private AtomicBoolean byZ;
    private boolean bza;
    private boolean bzb;
    private com.baidu.tbadk.BdToken.completeTask.d bzc;
    private com.baidu.tbadk.BdToken.activeConfig.b bzd;
    private int bze;
    private long bzf;
    private long bzg;
    private int bzh;
    private long bzi;
    private CustomMessageListener bzj;
    private CustomMessageListener bzk;
    private CustomMessageListener bzl;
    private com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a> bzm;
    private com.baidu.tbadk.h.b bzn;
    private BdUniqueId mBdUniqueId;

    public static final c Zk() {
        return g.bzr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g {
        private static final c bzr = new c();
    }

    private c() {
        this.byV = Executors.newSingleThreadScheduledExecutor();
        this.byW = new SparseArray<>();
        this.byX = new LinkedList<>();
        this.byY = new a();
        this.byZ = new AtomicBoolean(false);
        this.bza = false;
        this.bzb = false;
        this.bzj = new CustomMessageListener(2921391) { // from class: com.baidu.tbadk.BdToken.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.bza = true;
                if (!c.this.byX.isEmpty()) {
                    Iterator it = c.this.byX.iterator();
                    while (it.hasNext()) {
                        c.this.l((com.baidu.tbadk.BdToken.b) it.next());
                    }
                    c.this.byX.clear();
                }
            }
        };
        this.bzk = new CustomMessageListener(2001011) { // from class: com.baidu.tbadk.BdToken.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                    ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                    c.this.Zl();
                }
            }
        };
        this.bzl = new CustomMessageListener(2001371) { // from class: com.baidu.tbadk.BdToken.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                    c.this.bzb = true;
                    c.this.Zl();
                }
            }
        };
        this.bzm = new com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a>() { // from class: com.baidu.tbadk.BdToken.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: a */
            public void onSuccess(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    com.baidu.tbadk.core.sharedPref.b.ahU().putLong("pref_key_active_config_info", currentTimeMillis);
                    c.this.bzi = currentTimeMillis;
                    c.this.K(aVar.ZY());
                }
            }

            @Override // com.baidu.tbadk.h.a
            public void onError(int i, String str) {
            }
        };
        this.bzn = new com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b>() { // from class: com.baidu.tbadk.BdToken.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.b
            /* renamed from: m */
            public void onProgressUpdate(com.baidu.tbadk.BdToken.b bVar) {
                if (bVar != null) {
                    com.baidu.tbadk.BdToken.b e2 = c.this.e(bVar);
                    if (e2 != null && e2.byT) {
                        e2.reset();
                        c.this.j(e2);
                        return;
                    }
                    n.ZJ().o(e2);
                    if (e2 != null && e2.getTaskType() == 7) {
                        e2.YQ();
                        int Zi = e2.Zi();
                        int tag = e2.getTag();
                        if (Zi <= 1 || Zi <= tag) {
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
        this.bzc = new com.baidu.tbadk.BdToken.completeTask.d(this.mBdUniqueId);
        this.bzc.a(this.bzn);
        this.bzd = new com.baidu.tbadk.BdToken.activeConfig.b(this.mBdUniqueId);
        this.bzd.a(this.bzm);
        this.bzl.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.bzl);
        this.bzk.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.bzk);
        this.bzj.setPriority(Integer.MIN_VALUE);
        this.bzj.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.bzj);
        com.baidu.tbadk.core.g.a.ahR().init();
        p.ZM().h(this.mBdUniqueId);
        iO();
        if (isMainProcess()) {
            new f().execute(new Void[0]);
        }
    }

    private boolean isMainProcess() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public void Zl() {
        if (this.bzd != null && isMainProcess() && this.bzb && !Zm()) {
            this.bzd.aaa();
        }
    }

    public boolean Zm() {
        return UtilHelper.isSameDay(Zn(), System.currentTimeMillis());
    }

    private long Zn() {
        if (this.bzi == 0) {
            this.bzi = com.baidu.tbadk.core.sharedPref.b.ahU().getLong("pref_key_active_config_info", 0L);
        }
        return this.bzi;
    }

    public int Zo() {
        return this.bzh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.BdToken.b e(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.byW.size()) {
                return null;
            }
            List<com.baidu.tbadk.BdToken.b> valueAt = this.byW.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar2 : valueAt) {
                    if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.YU() == bVar.YU()) {
                        return bVar2;
                    }
                }
                continue;
            }
            i = i2 + 1;
        }
    }

    public void Zp() {
        this.byZ.compareAndSet(true, false);
        this.byY.gp(0);
        this.byY.setTid(0L);
        this.byY.setFid(0L);
        if (this.bzc != null) {
            this.bzc.aad();
        }
    }

    public void i(int i, long j) {
        if (isMainProcess()) {
            this.bzh = i;
            this.bzg = j;
            if (this.bzf > 0 && this.bze > 0 && (j == 0 || j != this.bzf)) {
                j(this.bze, this.bzf);
                this.bzf = 0L;
                this.bze = 0;
            }
            Zq();
        }
    }

    public void j(int i, long j) {
        k kVar;
        com.baidu.tbadk.BdToken.b ZG;
        List<com.baidu.tbadk.BdToken.b> list = this.byW.get(i);
        if (list != null && !list.isEmpty()) {
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 7) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.YJ().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof k) && (ZG = (kVar = (k) next).ZG()) != null && kVar.getTid() == j && ZG.getActivityId() == bVar.getActivityId() && ZG.YU() == bVar.YU()) {
                                next.du(true);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void k(int i, long j) {
        if (isMainProcess() && i != 0 && j != 0 && this.bza) {
            this.bze = i;
            List<com.baidu.tbadk.BdToken.b> list = this.byW.get(i);
            if (list != null && !list.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 1) {
                        a(bVar, j);
                    } else if (bVar.getTaskType() != 7) {
                        continue;
                    } else if (bVar.aj(j)) {
                        break;
                    } else {
                        b(bVar, j);
                    }
                }
                this.byY.gp(i);
                this.byY.setTid(j);
                this.bzf = j;
                this.byZ.compareAndSet(false, true);
                synchronized (this.byZ) {
                    this.byZ.notify();
                }
            }
        }
    }

    private void a(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        m mVar;
        com.baidu.tbadk.BdToken.b ZG;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.YJ().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof m) && (ZG = (mVar = (m) next).ZG()) != null && mVar.getTid() == j && ZG.getActivityId() == bVar.getActivityId() && ZG.YU() == bVar.YU()) {
                z = true;
                break;
            }
        }
        if (!z) {
            m mVar2 = new m(bVar, j);
            mVar2.ao(0L);
            mVar2.du(false);
            mVar2.gn(bVar.getTag());
            bVar.a(mVar2);
        }
    }

    private void b(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        k kVar;
        com.baidu.tbadk.BdToken.b ZG;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.YJ().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof k) && (ZG = (kVar = (k) next).ZG()) != null && kVar.getTid() == j && ZG.getActivityId() == bVar.getActivityId() && ZG.YU() == bVar.YU()) {
                z = true;
                break;
            }
        }
        if (!z) {
            k kVar2 = new k(bVar, j);
            kVar2.ao(0L);
            kVar2.du(false);
            kVar2.gn(bVar.getTag());
            bVar.a(kVar2);
        }
    }

    public void l(int i, long j) {
        boolean z;
        if (isMainProcess() && i != 0 && j != 0 && this.bza) {
            this.bze = i;
            List<com.baidu.tbadk.BdToken.b> list = this.byW.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 2) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.YJ().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof j) && next.ZG().getActivityId() == bVar.getActivityId() && next.ZG().YU() == bVar.YU() && ((j) next).getFid() == j) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            j jVar = new j(bVar, j);
                            jVar.ao(0L);
                            jVar.du(false);
                            jVar.gn(bVar.getTag());
                            bVar.a(jVar);
                        }
                        z2 = z;
                    }
                }
                this.byY.gp(i);
                this.byY.setFid(j);
                this.byZ.compareAndSet(false, true);
                synchronized (this.byZ) {
                    this.byZ.notify();
                }
            }
        }
    }

    public void go(int i) {
        boolean z;
        if (isMainProcess() && i != 0 && this.bza) {
            this.bze = i;
            List<com.baidu.tbadk.BdToken.b> list = this.byW.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 4) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.YJ().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof i) && next.ZG().getActivityId() == bVar.getActivityId() && next.ZG().YU() == bVar.YU()) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            i iVar = new i(bVar);
                            iVar.ao(0L);
                            iVar.du(false);
                            bVar.a(iVar);
                        }
                        z2 = z;
                    }
                }
                this.byY.gp(i);
                this.byZ.compareAndSet(false, true);
                synchronized (this.byZ) {
                    this.byZ.notify();
                }
            }
        }
    }

    public void Zq() {
        int i;
        List<com.baidu.tbadk.BdToken.b> list;
        boolean z;
        if (isMainProcess() && this.bza && (list = this.byW.get((i = com.baidu.tbadk.BdToken.b.byk))) != null && !list.isEmpty()) {
            boolean z2 = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 8) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.YJ().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = z2;
                            break;
                        }
                        com.baidu.tbadk.BdToken.h next = it.next();
                        com.baidu.tbadk.BdToken.b ZG = next.ZG();
                        if (ZG != null && (next instanceof l) && ZG.getActivityId() == bVar.getActivityId() && ZG.YU() == bVar.YU()) {
                            ((l) next).ZI();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        l lVar = new l(bVar);
                        lVar.ao(0L);
                        lVar.du(false);
                        bVar.a(lVar);
                    }
                    z2 = z;
                }
            }
            this.byY.gp(i);
            this.byZ.compareAndSet(false, true);
            synchronized (this.byZ) {
                this.byZ.notify();
            }
        }
    }

    private void iO() {
        this.byV.scheduleWithFixedDelay(this.byY, 0L, 1L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tbadk.BdToken.b bVar) {
        int[] YZ;
        for (int i : bVar.YZ()) {
            List<com.baidu.tbadk.BdToken.b> list = this.byW.get(i);
            if (list == null) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(bVar);
                this.byW.put(i, linkedList);
            } else {
                list.add(bVar);
            }
        }
    }

    private boolean g(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return false;
        }
        int[] YZ = bVar.YZ();
        if (YZ == null) {
            return true;
        }
        for (int i : YZ) {
            List<com.baidu.tbadk.BdToken.b> list = this.byW.get(i);
            if (list == null) {
                return false;
            }
            for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.YU() == bVar.YU()) {
                    if (bVar2.YR()) {
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
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.YJ().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.ZG() != null) {
                    com.baidu.tbadk.BdToken.b ZG = next.ZG();
                    if (ZG.getActivityId() == bVar.getActivityId() && ZG.YU() == bVar.YU()) {
                        if (taskType == 7 && (next instanceof k)) {
                            ((k) next).du(true);
                        } else if (taskType == 1 && (next instanceof m)) {
                            ((m) next).du(true);
                        }
                    }
                }
            }
            bVar.dt(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar != null) {
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.YJ().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.ZG() != null) {
                    com.baidu.tbadk.BdToken.b ZG = next.ZG();
                    if (ZG.getActivityId() == bVar.getActivityId() && ZG.YU() == bVar.YU()) {
                        it.remove();
                    }
                }
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.byW.size()) {
                    List<com.baidu.tbadk.BdToken.b> valueAt = this.byW.valueAt(i2);
                    if (valueAt != null && !valueAt.isEmpty()) {
                        Iterator<com.baidu.tbadk.BdToken.b> it2 = valueAt.iterator();
                        while (it2.hasNext()) {
                            com.baidu.tbadk.BdToken.b next2 = it2.next();
                            if (next2 != null && next2.getActivityId() == bVar.getActivityId() && next2.YU() == bVar.YU()) {
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
                p.ZM().q(bVar);
            } else if (!this.bza) {
                this.byX.add(bVar);
            } else if (!g(bVar)) {
                f(bVar);
                new b().execute(bVar);
            }
        }
    }

    public void K(List<com.baidu.tbadk.BdToken.b> list) {
        if (!com.baidu.tbadk.core.util.v.aa(list)) {
            if (!this.bza) {
                this.byX.addAll(list);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar != null) {
                    if (bVar.getTaskType() == 9) {
                        p.ZM().q(bVar);
                    } else if (!g(bVar)) {
                        f(bVar);
                        arrayList.add(bVar);
                    }
                }
            }
            new C0244c().execute(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.BdToken.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0244c extends BdAsyncTask<List<com.baidu.tbadk.BdToken.b>, Integer, Void> {
        private C0244c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(List<com.baidu.tbadk.BdToken.b>... listArr) {
            if (listArr != null && listArr.length > 0 && listArr[0] != null) {
                com.baidu.tbadk.BdToken.a.YG().K(listArr[0]);
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
        /* renamed from: b */
        public LinkedList<com.baidu.tbadk.BdToken.b> doInBackground(Void... voidArr) {
            LinkedList<com.baidu.tbadk.BdToken.b> linkedList = new LinkedList<>();
            linkedList.addAll(com.baidu.tbadk.BdToken.a.YG().YH());
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next != null && next.YR()) {
                    com.baidu.tbadk.BdToken.a.YG().c(next);
                    it.remove();
                } else if (next.getTaskType() == 7) {
                    next.YL();
                    com.baidu.tbadk.BdToken.a.YG().b(next);
                }
            }
            return linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public void onPostExecute(LinkedList<com.baidu.tbadk.BdToken.b> linkedList) {
            super.onPostExecute(linkedList);
            if (linkedList != null) {
                if (!linkedList.isEmpty()) {
                    Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
                    while (it.hasNext()) {
                        com.baidu.tbadk.BdToken.b next = it.next();
                        if (next.YZ() != null) {
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
                com.baidu.tbadk.BdToken.a.YG().a(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.YG().c(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.YG().c(bVar2);
            }
            if (bVar != null) {
                com.baidu.tbadk.BdToken.a.YG().a(bVar);
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
            com.baidu.tbadk.BdToken.a.YG().b(bVar);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(com.baidu.tbadk.BdToken.b bVar) {
            if (bVar != null && bVar.byT) {
                bVar.byT = false;
                c.this.k(c.this.bze, c.this.bzf);
            }
        }
    }

    public void Zr() {
        List<com.baidu.tbadk.BdToken.b> list = this.byW.get(com.baidu.tbadk.BdToken.b.byk);
        if (!com.baidu.tbadk.core.util.v.aa(list)) {
            boolean z = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bVar.YJ().iterator();
                boolean z2 = z;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof l) {
                        l lVar = (l) next;
                        if (!next.bh()) {
                            lVar.ZI();
                            z2 = true;
                        }
                    }
                }
                z = z2;
            }
            if (z && !this.byZ.get()) {
                this.byY.gp(com.baidu.tbadk.BdToken.b.byk);
                this.byZ.compareAndSet(false, true);
                synchronized (this.byZ) {
                    this.byZ.notify();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private volatile long byE;
        private volatile int bzp;
        private volatile boolean bzq;
        private volatile long mFid;

        private a() {
            this.bzq = false;
        }

        public synchronized void gp(int i) {
            this.bzp = i;
        }

        public synchronized void setTid(long j) {
            this.byE = j;
        }

        public synchronized void setFid(long j) {
            this.mFid = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.bzp == 0 || !c.this.byZ.get()) {
                synchronized (c.this.byZ) {
                    try {
                        c.this.byZ.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            Zs();
        }

        private void Zs() {
            this.bzq = true;
            List<com.baidu.tbadk.BdToken.b> list = (List) c.this.byW.get(com.baidu.tbadk.BdToken.b.byk);
            List<com.baidu.tbadk.BdToken.b> list2 = (List) c.this.byW.get(this.bzp);
            if (com.baidu.tbadk.core.util.v.aa(list) && com.baidu.tbadk.core.util.v.aa(list2)) {
                c.this.byZ.compareAndSet(true, false);
                return;
            }
            d.b bVar = new d.b();
            bVar.bAY = new LinkedList();
            bVar.bAZ = new LinkedList();
            bVar.bBa = new LinkedList();
            a(list, bVar);
            b(list2, bVar);
            if (this.bzq) {
                c.this.byZ.compareAndSet(true, false);
            }
            if (!com.baidu.tbadk.core.util.v.aa(bVar.bBa)) {
                com.baidu.tbadk.BdToken.a.YG().L(bVar.bBa);
            }
            if (!com.baidu.tbadk.core.util.v.aa(bVar.bAY) || !com.baidu.tbadk.core.util.v.aa(bVar.bAZ)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921379, bVar));
            }
        }

        private void a(List<com.baidu.tbadk.BdToken.b> list, d.b bVar) {
            if (!com.baidu.tbadk.core.util.v.aa(list)) {
                for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                    a(bVar2, bVar);
                }
            }
        }

        private void b(List<com.baidu.tbadk.BdToken.b> list, d.b bVar) {
            if (!com.baidu.tbadk.core.util.v.aa(list)) {
                for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                    b(bVar2, bVar);
                }
            }
        }

        private void a(com.baidu.tbadk.BdToken.b bVar, d.b bVar2) {
            ArrayList<com.baidu.tbadk.BdToken.h> YJ;
            if (bVar != null && bVar2 != null && (YJ = bVar.YJ()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = YJ.iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if ((next instanceof l) && !((l) next).isTimeout() && !next.bh()) {
                        this.bzq = false;
                        next.gq(1);
                        if (next.ZH() >= next.ZG().Za()) {
                            next.du(true);
                            bVar2.s(bVar);
                        }
                        bVar2.t(bVar);
                    }
                }
            }
        }

        private void b(com.baidu.tbadk.BdToken.b bVar, d.b bVar2) {
            ArrayList<com.baidu.tbadk.BdToken.h> YJ;
            if (bVar != null && bVar2 != null && (YJ = bVar.YJ()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = YJ.iterator();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof m) {
                        m mVar = (m) next;
                        if (this.byE != 0 && mVar.getTid() == this.byE && !next.bh()) {
                            this.bzq = false;
                            next.gq(1);
                            if (next.ZH() >= next.ZG().Za()) {
                                next.du(true);
                                if (next.ZG().YP() >= next.ZG().getThreadNum()) {
                                    bVar2.c(next);
                                }
                            }
                            bVar2.t(bVar);
                        }
                    } else if (next instanceof k) {
                        k kVar = (k) next;
                        if (!bVar.Zj() && kVar.getTag() == bVar.getTag()) {
                            if (this.byE != 0 && kVar.getTid() == this.byE && !next.bh()) {
                                this.bzq = false;
                                next.gq(1);
                            }
                            i = (int) (i + next.ZH());
                            if (this.byE != 0 && kVar.getTid() == this.byE && !next.bh()) {
                                if (next.ZH() >= bVar.Za()) {
                                    next.du(true);
                                    bVar.YP();
                                }
                                bVar2.t(bVar);
                            }
                            int YK = bVar.YK();
                            int threadNum = bVar.getThreadNum();
                            if (i >= bVar.Za() * bVar.getThreadNum() && YK >= threadNum) {
                                bVar2.s(bVar);
                                bVar.dt(true);
                            }
                        }
                    } else if (next instanceof j) {
                        if (this.mFid != 0 && ((j) next).getFid() == this.mFid && !next.bh()) {
                            this.bzq = false;
                            next.gq(1);
                            if (next.ZH() >= next.ZG().Za()) {
                                next.du(true);
                                if (next.ZG().YO() >= next.ZG().Zb()) {
                                    bVar2.c(next);
                                }
                            }
                        }
                    } else if ((next instanceof i) && !next.bh()) {
                        this.bzq = false;
                        next.gq(1);
                        if (next.ZH() >= next.ZG().Za()) {
                            next.du(true);
                            bVar2.c(next);
                        }
                    }
                }
            }
        }
    }
}
