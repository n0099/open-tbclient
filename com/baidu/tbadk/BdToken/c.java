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
import com.baidu.tbadk.core.util.v;
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
    private final ScheduledExecutorService bxG;
    private final SparseArray<List<com.baidu.tbadk.BdToken.b>> bxH;
    private final LinkedList<com.baidu.tbadk.BdToken.b> bxI;
    private a bxJ;
    private AtomicBoolean bxK;
    private boolean bxL;
    private boolean bxM;
    private com.baidu.tbadk.BdToken.completeTask.d bxN;
    private com.baidu.tbadk.BdToken.activeConfig.b bxO;
    private int bxP;
    private long bxQ;
    private long bxR;
    private int bxS;
    private long bxT;
    private CustomMessageListener bxU;
    private CustomMessageListener bxV;
    private CustomMessageListener bxW;
    private com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a> bxX;
    private com.baidu.tbadk.h.b bxY;
    private BdUniqueId mBdUniqueId;

    public static final c Yk() {
        return g.byc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g {
        private static final c byc = new c();
    }

    private c() {
        this.bxG = Executors.newSingleThreadScheduledExecutor();
        this.bxH = new SparseArray<>();
        this.bxI = new LinkedList<>();
        this.bxJ = new a();
        this.bxK = new AtomicBoolean(false);
        this.bxL = false;
        this.bxM = false;
        this.bxU = new CustomMessageListener(2921391) { // from class: com.baidu.tbadk.BdToken.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.bxL = true;
                if (!c.this.bxI.isEmpty()) {
                    Iterator it = c.this.bxI.iterator();
                    while (it.hasNext()) {
                        c.this.l((com.baidu.tbadk.BdToken.b) it.next());
                    }
                    c.this.bxI.clear();
                }
            }
        };
        this.bxV = new CustomMessageListener(2001011) { // from class: com.baidu.tbadk.BdToken.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                    ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                    c.this.Yl();
                }
            }
        };
        this.bxW = new CustomMessageListener(2001371) { // from class: com.baidu.tbadk.BdToken.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                    c.this.bxM = true;
                    c.this.Yl();
                }
            }
        };
        this.bxX = new com.baidu.tbadk.h.a<com.baidu.tbadk.BdToken.activeConfig.a>() { // from class: com.baidu.tbadk.BdToken.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.a
            /* renamed from: a */
            public void onSuccess(com.baidu.tbadk.BdToken.activeConfig.a aVar) {
                if (aVar != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    com.baidu.tbadk.core.sharedPref.b.agM().putLong("pref_key_active_config_info", currentTimeMillis);
                    c.this.bxT = currentTimeMillis;
                    c.this.K(aVar.YV());
                }
            }

            @Override // com.baidu.tbadk.h.a
            public void onError(int i, String str) {
            }
        };
        this.bxY = new com.baidu.tbadk.h.b<com.baidu.tbadk.BdToken.b>() { // from class: com.baidu.tbadk.BdToken.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.b
            /* renamed from: m */
            public void onProgressUpdate(com.baidu.tbadk.BdToken.b bVar) {
                if (bVar != null) {
                    com.baidu.tbadk.BdToken.b e2 = c.this.e(bVar);
                    if (e2 != null && e2.bxE) {
                        e2.reset();
                        c.this.j(e2);
                        return;
                    }
                    n.YJ().o(e2);
                    if (e2 != null && e2.getTaskType() == 7) {
                        e2.XQ();
                        int Yi = e2.Yi();
                        int tag = e2.getTag();
                        if (Yi <= 1 || Yi <= tag) {
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
        this.bxN = new com.baidu.tbadk.BdToken.completeTask.d(this.mBdUniqueId);
        this.bxN.a(this.bxY);
        this.bxO = new com.baidu.tbadk.BdToken.activeConfig.b(this.mBdUniqueId);
        this.bxO.a(this.bxX);
        this.bxW.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.bxW);
        this.bxV.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.bxV);
        this.bxU.setPriority(Integer.MIN_VALUE);
        this.bxU.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.bxU);
        com.baidu.tbadk.core.f.a.agJ().init();
        iF();
        if (isMainProcess()) {
            new f().execute(new Void[0]);
        }
    }

    private boolean isMainProcess() {
        return TbadkCoreApplication.getInst().isMainProcess(true);
    }

    public void Yl() {
        if (this.bxO != null && isMainProcess() && this.bxM && !Ym()) {
            this.bxO.YX();
        }
    }

    public boolean Ym() {
        return UtilHelper.isSameDay(Yn(), System.currentTimeMillis());
    }

    private long Yn() {
        if (this.bxT == 0) {
            this.bxT = com.baidu.tbadk.core.sharedPref.b.agM().getLong("pref_key_active_config_info", 0L);
        }
        return this.bxT;
    }

    public int Yo() {
        return this.bxS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.BdToken.b e(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.bxH.size()) {
                return null;
            }
            List<com.baidu.tbadk.BdToken.b> valueAt = this.bxH.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar2 : valueAt) {
                    if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.XU() == bVar.XU()) {
                        return bVar2;
                    }
                }
                continue;
            }
            i = i2 + 1;
        }
    }

    public void Yp() {
        this.bxK.compareAndSet(true, false);
        this.bxJ.gk(0);
        this.bxJ.setTid(0L);
        this.bxJ.setFid(0L);
        if (this.bxN != null) {
            this.bxN.Za();
        }
    }

    public void i(int i, long j) {
        if (isMainProcess()) {
            this.bxS = i;
            this.bxR = j;
            if (this.bxQ > 0 && this.bxP > 0 && (j == 0 || j != this.bxQ)) {
                j(this.bxP, this.bxQ);
                this.bxQ = 0L;
                this.bxP = 0;
            }
            Yq();
        }
    }

    public void j(int i, long j) {
        k kVar;
        com.baidu.tbadk.BdToken.b YG;
        List<com.baidu.tbadk.BdToken.b> list = this.bxH.get(i);
        if (list != null && !list.isEmpty()) {
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 7) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.XJ().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof k) && (YG = (kVar = (k) next).YG()) != null && kVar.getTid() == j && YG.getActivityId() == bVar.getActivityId() && YG.XU() == bVar.XU()) {
                                next.dp(true);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void k(int i, long j) {
        if (isMainProcess() && i != 0 && j != 0 && this.bxL) {
            this.bxP = i;
            List<com.baidu.tbadk.BdToken.b> list = this.bxH.get(i);
            if (list != null && !list.isEmpty()) {
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 1) {
                        a(bVar, j);
                    } else if (bVar.getTaskType() != 7) {
                        continue;
                    } else if (bVar.ai(j)) {
                        break;
                    } else {
                        b(bVar, j);
                    }
                }
                this.bxJ.gk(i);
                this.bxJ.setTid(j);
                this.bxQ = j;
                this.bxK.compareAndSet(false, true);
                synchronized (this.bxK) {
                    this.bxK.notify();
                }
            }
        }
    }

    private void a(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        m mVar;
        com.baidu.tbadk.BdToken.b YG;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.XJ().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof m) && (YG = (mVar = (m) next).YG()) != null && mVar.getTid() == j && YG.getActivityId() == bVar.getActivityId() && YG.XU() == bVar.XU()) {
                z = true;
                break;
            }
        }
        if (!z) {
            m mVar2 = new m(bVar, j);
            mVar2.an(0L);
            mVar2.dp(false);
            mVar2.gi(bVar.getTag());
            bVar.a(mVar2);
        }
    }

    private void b(com.baidu.tbadk.BdToken.b bVar, long j) {
        boolean z;
        k kVar;
        com.baidu.tbadk.BdToken.b YG;
        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.XJ().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            com.baidu.tbadk.BdToken.h next = it.next();
            if ((next instanceof k) && (YG = (kVar = (k) next).YG()) != null && kVar.getTid() == j && YG.getActivityId() == bVar.getActivityId() && YG.XU() == bVar.XU()) {
                z = true;
                break;
            }
        }
        if (!z) {
            k kVar2 = new k(bVar, j);
            kVar2.an(0L);
            kVar2.dp(false);
            kVar2.gi(bVar.getTag());
            bVar.a(kVar2);
        }
    }

    public void l(int i, long j) {
        boolean z;
        if (isMainProcess() && i != 0 && j != 0 && this.bxL) {
            this.bxP = i;
            List<com.baidu.tbadk.BdToken.b> list = this.bxH.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 2) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.XJ().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof j) && next.YG().getActivityId() == bVar.getActivityId() && next.YG().XU() == bVar.XU() && ((j) next).getFid() == j) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            j jVar = new j(bVar, j);
                            jVar.an(0L);
                            jVar.dp(false);
                            jVar.gi(bVar.getTag());
                            bVar.a(jVar);
                        }
                        z2 = z;
                    }
                }
                this.bxJ.gk(i);
                this.bxJ.setFid(j);
                this.bxK.compareAndSet(false, true);
                synchronized (this.bxK) {
                    this.bxK.notify();
                }
            }
        }
    }

    public void gj(int i) {
        boolean z;
        if (isMainProcess() && i != 0 && this.bxL) {
            this.bxP = i;
            List<com.baidu.tbadk.BdToken.b> list = this.bxH.get(i);
            if (list != null && !list.isEmpty()) {
                boolean z2 = false;
                for (com.baidu.tbadk.BdToken.b bVar : list) {
                    if (bVar.getTaskType() == 4) {
                        Iterator<com.baidu.tbadk.BdToken.h> it = bVar.XJ().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            }
                            com.baidu.tbadk.BdToken.h next = it.next();
                            if ((next instanceof i) && next.YG().getActivityId() == bVar.getActivityId() && next.YG().XU() == bVar.XU()) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            i iVar = new i(bVar);
                            iVar.an(0L);
                            iVar.dp(false);
                            bVar.a(iVar);
                        }
                        z2 = z;
                    }
                }
                this.bxJ.gk(i);
                this.bxK.compareAndSet(false, true);
                synchronized (this.bxK) {
                    this.bxK.notify();
                }
            }
        }
    }

    public void Yq() {
        int i;
        List<com.baidu.tbadk.BdToken.b> list;
        boolean z;
        if (isMainProcess() && this.bxL && (list = this.bxH.get((i = com.baidu.tbadk.BdToken.b.bwV))) != null && !list.isEmpty()) {
            boolean z2 = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (bVar.getTaskType() == 8) {
                    Iterator<com.baidu.tbadk.BdToken.h> it = bVar.XJ().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = z2;
                            break;
                        }
                        com.baidu.tbadk.BdToken.h next = it.next();
                        com.baidu.tbadk.BdToken.b YG = next.YG();
                        if (YG != null && (next instanceof l) && YG.getActivityId() == bVar.getActivityId() && YG.XU() == bVar.XU()) {
                            ((l) next).YI();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        l lVar = new l(bVar);
                        lVar.an(0L);
                        lVar.dp(false);
                        bVar.a(lVar);
                    }
                    z2 = z;
                }
            }
            this.bxJ.gk(i);
            this.bxK.compareAndSet(false, true);
            synchronized (this.bxK) {
                this.bxK.notify();
            }
        }
    }

    private void iF() {
        this.bxG.scheduleWithFixedDelay(this.bxJ, 0L, 1L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tbadk.BdToken.b bVar) {
        int[] XZ;
        for (int i : bVar.XZ()) {
            List<com.baidu.tbadk.BdToken.b> list = this.bxH.get(i);
            if (list == null) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(bVar);
                this.bxH.put(i, linkedList);
            } else {
                list.add(bVar);
            }
        }
    }

    private boolean g(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar == null) {
            return false;
        }
        int[] XZ = bVar.XZ();
        if (XZ == null) {
            return true;
        }
        for (int i : XZ) {
            List<com.baidu.tbadk.BdToken.b> list = this.bxH.get(i);
            if (list == null) {
                return false;
            }
            for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                if (bVar2 != null && bVar2.getActivityId() == bVar.getActivityId() && bVar2.XU() == bVar.XU()) {
                    if (bVar2.XR()) {
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
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.XJ().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.YG() != null) {
                    com.baidu.tbadk.BdToken.b YG = next.YG();
                    if (YG.getActivityId() == bVar.getActivityId() && YG.XU() == bVar.XU()) {
                        if (taskType == 7 && (next instanceof k)) {
                            ((k) next).dp(true);
                        } else if (taskType == 1 && (next instanceof m)) {
                            ((m) next).dp(true);
                        }
                    }
                }
            }
            bVar.m17do(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tbadk.BdToken.b bVar) {
        if (bVar != null) {
            Iterator<com.baidu.tbadk.BdToken.h> it = bVar.XJ().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.h next = it.next();
                if (next != null && next.YG() != null) {
                    com.baidu.tbadk.BdToken.b YG = next.YG();
                    if (YG.getActivityId() == bVar.getActivityId() && YG.XU() == bVar.XU()) {
                        it.remove();
                    }
                }
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bxH.size()) {
                    List<com.baidu.tbadk.BdToken.b> valueAt = this.bxH.valueAt(i2);
                    if (valueAt != null && !valueAt.isEmpty()) {
                        Iterator<com.baidu.tbadk.BdToken.b> it2 = valueAt.iterator();
                        while (it2.hasNext()) {
                            com.baidu.tbadk.BdToken.b next2 = it2.next();
                            if (next2 != null && next2.getActivityId() == bVar.getActivityId() && next2.XU() == bVar.XU()) {
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
        if (!this.bxL) {
            this.bxI.add(bVar);
        } else if (!g(bVar)) {
            f(bVar);
            new b().execute(bVar);
        }
    }

    public void K(List<com.baidu.tbadk.BdToken.b> list) {
        if (!v.aa(list)) {
            if (!this.bxL) {
                this.bxI.addAll(list);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                if (!g(bVar)) {
                    f(bVar);
                    arrayList.add(bVar);
                }
            }
            new C0233c().execute(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.BdToken.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0233c extends BdAsyncTask<List<com.baidu.tbadk.BdToken.b>, Integer, Void> {
        private C0233c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(List<com.baidu.tbadk.BdToken.b>... listArr) {
            if (listArr != null && listArr.length > 0 && listArr[0] != null) {
                com.baidu.tbadk.BdToken.a.XG().K(listArr[0]);
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
            linkedList.addAll(com.baidu.tbadk.BdToken.a.XG().XH());
            Iterator<com.baidu.tbadk.BdToken.b> it = linkedList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.BdToken.b next = it.next();
                if (next != null && next.XR()) {
                    com.baidu.tbadk.BdToken.a.XG().c(next);
                    it.remove();
                } else if (next.getTaskType() == 7) {
                    next.XL();
                    com.baidu.tbadk.BdToken.a.XG().b(next);
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
                        if (next.XZ() != null) {
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
                com.baidu.tbadk.BdToken.a.XG().a(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.XG().c(bVarArr[0]);
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
                com.baidu.tbadk.BdToken.a.XG().c(bVar2);
            }
            if (bVar != null) {
                com.baidu.tbadk.BdToken.a.XG().a(bVar);
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
            com.baidu.tbadk.BdToken.a.XG().b(bVar);
            return bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public void onPostExecute(com.baidu.tbadk.BdToken.b bVar) {
            if (bVar != null && bVar.bxE) {
                bVar.bxE = false;
                c.this.k(c.this.bxP, c.this.bxQ);
            }
        }
    }

    public void Yr() {
        List<com.baidu.tbadk.BdToken.b> list = this.bxH.get(com.baidu.tbadk.BdToken.b.bwV);
        if (!v.aa(list)) {
            boolean z = false;
            for (com.baidu.tbadk.BdToken.b bVar : list) {
                Iterator<com.baidu.tbadk.BdToken.h> it = bVar.XJ().iterator();
                boolean z2 = z;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof l) {
                        l lVar = (l) next;
                        if (!next.isCompleted()) {
                            lVar.YI();
                            z2 = true;
                        }
                    }
                }
                z = z2;
            }
            if (z && !this.bxK.get()) {
                this.bxJ.gk(com.baidu.tbadk.BdToken.b.bwV);
                this.bxK.compareAndSet(false, true);
                synchronized (this.bxK) {
                    this.bxK.notify();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private volatile long bxp;
        private volatile int bya;
        private volatile boolean byb;
        private volatile long mFid;

        private a() {
            this.byb = false;
        }

        public synchronized void gk(int i) {
            this.bya = i;
        }

        public synchronized void setTid(long j) {
            this.bxp = j;
        }

        public synchronized void setFid(long j) {
            this.mFid = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.bya == 0 || !c.this.bxK.get()) {
                synchronized (c.this.bxK) {
                    try {
                        c.this.bxK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            Ys();
        }

        private void Ys() {
            this.byb = true;
            List<com.baidu.tbadk.BdToken.b> list = (List) c.this.bxH.get(com.baidu.tbadk.BdToken.b.bwV);
            List<com.baidu.tbadk.BdToken.b> list2 = (List) c.this.bxH.get(this.bya);
            if (v.aa(list) && v.aa(list2)) {
                c.this.bxK.compareAndSet(true, false);
                return;
            }
            d.b bVar = new d.b();
            bVar.bzD = new LinkedList();
            bVar.bzE = new LinkedList();
            bVar.bzF = new LinkedList();
            a(list, bVar);
            b(list2, bVar);
            if (this.byb) {
                c.this.bxK.compareAndSet(true, false);
            }
            if (!v.aa(bVar.bzF)) {
                com.baidu.tbadk.BdToken.a.XG().L(bVar.bzF);
            }
            if (!v.aa(bVar.bzD) || !v.aa(bVar.bzE)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921379, bVar));
            }
        }

        private void a(List<com.baidu.tbadk.BdToken.b> list, d.b bVar) {
            if (!v.aa(list)) {
                for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                    a(bVar2, bVar);
                }
            }
        }

        private void b(List<com.baidu.tbadk.BdToken.b> list, d.b bVar) {
            if (!v.aa(list)) {
                for (com.baidu.tbadk.BdToken.b bVar2 : list) {
                    b(bVar2, bVar);
                }
            }
        }

        private void a(com.baidu.tbadk.BdToken.b bVar, d.b bVar2) {
            ArrayList<com.baidu.tbadk.BdToken.h> XJ;
            if (bVar != null && bVar2 != null && (XJ = bVar.XJ()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = XJ.iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if ((next instanceof l) && !((l) next).isTimeout() && !next.isCompleted()) {
                        this.byb = false;
                        next.gl(1);
                        if (next.YH() >= next.YG().Ya()) {
                            next.dp(true);
                            bVar2.r(bVar);
                        }
                        bVar2.s(bVar);
                    }
                }
            }
        }

        private void b(com.baidu.tbadk.BdToken.b bVar, d.b bVar2) {
            ArrayList<com.baidu.tbadk.BdToken.h> XJ;
            if (bVar != null && bVar2 != null && (XJ = bVar.XJ()) != null) {
                Iterator<com.baidu.tbadk.BdToken.h> it = XJ.iterator();
                int i = 0;
                while (it.hasNext()) {
                    com.baidu.tbadk.BdToken.h next = it.next();
                    if (next instanceof m) {
                        m mVar = (m) next;
                        if (this.bxp != 0 && mVar.getTid() == this.bxp && !next.isCompleted()) {
                            this.byb = false;
                            next.gl(1);
                            if (next.YH() >= next.YG().Ya()) {
                                next.dp(true);
                                if (next.YG().XP() >= next.YG().getThreadNum()) {
                                    bVar2.c(next);
                                }
                            }
                            bVar2.s(bVar);
                        }
                    } else if (next instanceof k) {
                        k kVar = (k) next;
                        if (!bVar.Yj() && kVar.getTag() == bVar.getTag()) {
                            if (this.bxp != 0 && kVar.getTid() == this.bxp && !next.isCompleted()) {
                                this.byb = false;
                                next.gl(1);
                            }
                            i = (int) (i + next.YH());
                            if (this.bxp != 0 && kVar.getTid() == this.bxp && !next.isCompleted()) {
                                if (next.YH() >= bVar.Ya()) {
                                    next.dp(true);
                                    bVar.XP();
                                }
                                bVar2.s(bVar);
                            }
                            int XK = bVar.XK();
                            int threadNum = bVar.getThreadNum();
                            if (i >= bVar.Ya() * bVar.getThreadNum() && XK >= threadNum) {
                                bVar2.r(bVar);
                                bVar.m17do(true);
                            }
                        }
                    } else if (next instanceof j) {
                        if (this.mFid != 0 && ((j) next).getFid() == this.mFid && !next.isCompleted()) {
                            this.byb = false;
                            next.gl(1);
                            if (next.YH() >= next.YG().Ya()) {
                                next.dp(true);
                                if (next.YG().XO() >= next.YG().Yb()) {
                                    bVar2.c(next);
                                }
                            }
                        }
                    } else if ((next instanceof i) && !next.isCompleted()) {
                        this.byb = false;
                        next.gl(1);
                        if (next.YH() >= next.YG().Ya()) {
                            next.dp(true);
                            bVar2.c(next);
                        }
                    }
                }
            }
        }
    }
}
