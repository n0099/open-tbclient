package com.baidu.tbadk.core.bigday;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.d.d;
import com.baidu.tbadk.core.util.v;
import com.squareup.wire.Wire;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.GetBigday.BigdayInfo;
import tbclient.GetBigday.GetBigdayResIdl;
/* loaded from: classes.dex */
public class b {
    private static b aoE = null;
    private SparseArray<Long> aoA;
    private ArrayList<com.baidu.tbadk.core.bigday.a> aoB;
    private com.baidu.tbadk.core.bigday.a aoy;
    private com.baidu.tbadk.core.bigday.a aoz;
    private BdUniqueId mTag;
    private boolean aoC = false;
    private boolean aoD = true;
    private com.baidu.adp.framework.listener.a mNetMessageListener = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_BIGDAY_INFO, 309609) { // from class: com.baidu.tbadk.core.bigday.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && !responsedMessage.hasError()) {
                b.this.aoC = true;
                ArrayList<com.baidu.tbadk.core.bigday.a> arrayList = null;
                if (responsedMessage instanceof GetBigdayInfoSocketResMessage) {
                    arrayList = ((GetBigdayInfoSocketResMessage) responsedMessage).bigdayInfos;
                } else if (responsedMessage instanceof GetBigdayInfoHttpResMessage) {
                    arrayList = ((GetBigdayInfoHttpResMessage) responsedMessage).bigdayInfos;
                }
                b.this.g(arrayList);
            }
        }
    };

    private b() {
        com.baidu.tieba.tbadkCore.a.a.a(309609, GetBigdayInfoSocketResMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309609, CmdConfigHttp.CMD_GET_BIGDAY_INFO, "c/s/getBigday", GetBigdayInfoHttpResMessage.class, false, false, true, false);
        MessageManager.getInstance().registerListener(this.mNetMessageListener);
        this.aoA = new SparseArray<>();
    }

    public static b xS() {
        if (aoE == null) {
            aoE = new b();
        }
        return aoE;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void xT() {
        this.aoC = false;
        GetBigdayInfoReqMessage getBigdayInfoReqMessage = new GetBigdayInfoReqMessage();
        getBigdayInfoReqMessage.setTag(this.mTag);
        MessageManager.getInstance().sendMessage(getBigdayInfoReqMessage);
    }

    public void xU() {
        new BdAsyncTask<Void, Void, ArrayList<com.baidu.tbadk.core.bigday.a>>() { // from class: com.baidu.tbadk.core.bigday.b.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: d */
            public ArrayList<com.baidu.tbadk.core.bigday.a> doInBackground(Void... voidArr) {
                byte[] bArr;
                ArrayList<com.baidu.tbadk.core.bigday.a> arrayList = new ArrayList<>();
                l<byte[]> ex = com.baidu.tbadk.core.c.a.BB().ex("tb.bigday_datas");
                if (ex != null && (bArr = ex.get("tb.bigday_datas")) != null) {
                    try {
                        GetBigdayResIdl getBigdayResIdl = (GetBigdayResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBigdayResIdl.class);
                        if (getBigdayResIdl.data != null) {
                            for (BigdayInfo bigdayInfo : getBigdayResIdl.data.bigday_list) {
                                if (bigdayInfo != null) {
                                    com.baidu.tbadk.core.bigday.a aVar = new com.baidu.tbadk.core.bigday.a();
                                    aVar.a(bigdayInfo);
                                    if (aVar.xR()) {
                                        arrayList.add(aVar);
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        return null;
                    }
                }
                return arrayList;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: i */
            public void onPostExecute(ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
                super.onPostExecute(arrayList);
                if (arrayList != null) {
                    b.this.f(arrayList);
                }
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
        if (!v.I(arrayList) && !this.aoC) {
            this.aoy = c(arrayList, 1);
            this.aoz = c(arrayList, 3);
            this.aoB = arrayList;
            xV();
            if (this.aoy != null && d.ge(this.aoy.imgUrl) && com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.aoy));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
        com.baidu.tbadk.core.bigday.a c = c(arrayList, 1);
        com.baidu.tbadk.core.bigday.a c2 = c(arrayList, 3);
        h(arrayList);
        this.aoB = arrayList;
        if (c != null && c.xR()) {
            this.aoy = c;
        }
        if (c2 != null && c2.xR()) {
            this.aoz = c2;
        }
        xV();
        if (this.aoy != null && d.ge(this.aoy.imgUrl) && com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.aoy));
        }
    }

    private void xV() {
        if (!v.I(this.aoB)) {
            Iterator<com.baidu.tbadk.core.bigday.a> it = this.aoB.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.bigday.a next = it.next();
                if (!d.ge(next.imgUrl)) {
                    c.jA().a(next.imgUrl, 41, null, this.mTag);
                }
            }
        }
    }

    private void h(ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        v.a((List) arrayList2, 0, (List) arrayList);
        v.b(arrayList2, this.aoy);
        v.b(arrayList2, this.aoz);
        a aVar = new a(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, null, DiskFileOperate.Action.DELETE_FILES, arrayList2);
        aVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        aVar.T(false);
        aVar.U(true);
        com.baidu.adp.lib.Disk.d.hB().c(aVar);
    }

    private com.baidu.tbadk.core.bigday.a c(List<com.baidu.tbadk.core.bigday.a> list, int i) {
        if (!v.I(list)) {
            Iterator<com.baidu.tbadk.core.bigday.a> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.core.bigday.a next = it.next();
                if (next.xR() && next.aox == i) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (next.startTime > currentTimeMillis) {
                        this.aoA.put(i, Long.valueOf(next.startTime));
                        break;
                    } else if (next.endTime >= currentTimeMillis) {
                        return next;
                    }
                }
            }
        }
        return null;
    }

    public com.baidu.tbadk.core.bigday.a cA(int i) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (i == 1) {
            if (this.aoy == null && this.aoA.get(i, 0L).longValue() != 0 && this.aoA.get(i, 0L).longValue() < currentTimeMillis) {
                this.aoy = c(this.aoB, 1);
            }
            if (this.aoy != null && (currentTimeMillis < this.aoy.startTime || currentTimeMillis > this.aoy.endTime)) {
                this.aoy = c(this.aoB, 1);
            }
            if (this.aoy != null && d.ge(this.aoy.imgUrl)) {
                return this.aoy;
            }
        } else if (i == 3) {
            if (this.aoz == null && this.aoA.get(i, 0L).longValue() != 0 && this.aoA.get(i, 0L).longValue() < currentTimeMillis) {
                this.aoy = c(this.aoB, 3);
            }
            if (this.aoz != null && (currentTimeMillis < this.aoz.startTime || currentTimeMillis > this.aoz.endTime)) {
                this.aoz = c(this.aoB, 3);
            }
            if (this.aoz != null && d.ge(this.aoz.imgUrl)) {
                return this.aoz;
            }
        }
        return null;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.mNetMessageListener);
    }

    public boolean xW() {
        return this.aoD;
    }

    public void aX(boolean z) {
        this.aoD = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends DiskFileOperate implements com.baidu.adp.lib.Disk.a {
        private ArrayList<String> aoG;

        public a(String str, String str2, DiskFileOperate.Action action, ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
            super(str, str2, action);
            this.aoG = new ArrayList<>();
            Iterator<com.baidu.tbadk.core.bigday.a> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.bigday.a next = it.next();
                if (next != null) {
                    String k = c.jA().k(next.imgUrl, 41);
                    if (!StringUtils.isNULL(k)) {
                        String fK = ar.fK(k);
                        if (!StringUtils.isNULL(fK)) {
                            this.aoG.add(fK);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.adp.lib.Disk.a
        public boolean j(File file) {
            return (file == null || StringUtils.isNULL(file.getName()) || this.aoG.contains(file.getName())) ? false : true;
        }
    }
}
