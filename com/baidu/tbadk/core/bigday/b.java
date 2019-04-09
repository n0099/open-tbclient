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
import com.baidu.tbadk.core.util.as;
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
    private static b bvW = null;
    private com.baidu.tbadk.core.bigday.a bvQ;
    private com.baidu.tbadk.core.bigday.a bvR;
    private SparseArray<Long> bvS;
    private ArrayList<com.baidu.tbadk.core.bigday.a> bvT;
    private boolean bvU = false;
    private boolean bvV = true;
    private com.baidu.adp.framework.listener.a mNetMessageListener = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_BIGDAY_INFO, 309609) { // from class: com.baidu.tbadk.core.bigday.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && !responsedMessage.hasError()) {
                b.this.bvU = true;
                ArrayList<com.baidu.tbadk.core.bigday.a> arrayList = null;
                if (responsedMessage instanceof GetBigdayInfoSocketResMessage) {
                    arrayList = ((GetBigdayInfoSocketResMessage) responsedMessage).bigdayInfos;
                } else if (responsedMessage instanceof GetBigdayInfoHttpResMessage) {
                    arrayList = ((GetBigdayInfoHttpResMessage) responsedMessage).bigdayInfos;
                }
                b.this.j(arrayList);
            }
        }
    };
    private BdUniqueId mTag;

    private b() {
        com.baidu.tieba.tbadkCore.a.a.a(309609, GetBigdayInfoSocketResMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309609, CmdConfigHttp.CMD_GET_BIGDAY_INFO, "c/s/getBigday", GetBigdayInfoHttpResMessage.class, false, false, true, false);
        MessageManager.getInstance().registerListener(this.mNetMessageListener);
        this.bvS = new SparseArray<>();
    }

    public static b WJ() {
        if (bvW == null) {
            bvW = new b();
        }
        return bvW;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void WK() {
        this.bvU = false;
        GetBigdayInfoReqMessage getBigdayInfoReqMessage = new GetBigdayInfoReqMessage();
        getBigdayInfoReqMessage.setTag(this.mTag);
        MessageManager.getInstance().sendMessage(getBigdayInfoReqMessage);
    }

    public void WL() {
        new BdAsyncTask<Void, Void, ArrayList<com.baidu.tbadk.core.bigday.a>>() { // from class: com.baidu.tbadk.core.bigday.b.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: d */
            public ArrayList<com.baidu.tbadk.core.bigday.a> doInBackground(Void... voidArr) {
                byte[] bArr;
                ArrayList<com.baidu.tbadk.core.bigday.a> arrayList = new ArrayList<>();
                l<byte[]> lv = com.baidu.tbadk.core.c.a.aaT().lv("tb.bigday_datas");
                if (lv != null && (bArr = lv.get("tb.bigday_datas")) != null) {
                    try {
                        GetBigdayResIdl getBigdayResIdl = (GetBigdayResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBigdayResIdl.class);
                        if (getBigdayResIdl.data != null) {
                            for (BigdayInfo bigdayInfo : getBigdayResIdl.data.bigday_list) {
                                if (bigdayInfo != null) {
                                    com.baidu.tbadk.core.bigday.a aVar = new com.baidu.tbadk.core.bigday.a();
                                    aVar.a(bigdayInfo);
                                    if (aVar.WI()) {
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
            public void onPostExecute(ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
                super.onPostExecute((AnonymousClass2) arrayList);
                if (arrayList != null) {
                    b.this.i(arrayList);
                }
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
        if (!v.T(arrayList) && !this.bvU) {
            this.bvQ = b(arrayList, 1);
            this.bvR = b(arrayList, 3);
            this.bvT = arrayList;
            WM();
            if (this.bvQ != null && d.nf(this.bvQ.imgUrl) && com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.bvQ));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
        com.baidu.tbadk.core.bigday.a b = b(arrayList, 1);
        com.baidu.tbadk.core.bigday.a b2 = b(arrayList, 3);
        k(arrayList);
        this.bvT = arrayList;
        if (b != null && b.WI()) {
            this.bvQ = b;
        }
        if (b2 != null && b2.WI()) {
            this.bvR = b2;
        }
        WM();
        if (this.bvQ != null && d.nf(this.bvQ.imgUrl) && com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.bvQ));
        }
    }

    private void WM() {
        if (!v.T(this.bvT)) {
            Iterator<com.baidu.tbadk.core.bigday.a> it = this.bvT.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.bigday.a next = it.next();
                if (!d.nf(next.imgUrl)) {
                    c.jB().a(next.imgUrl, 41, null, this.mTag);
                }
            }
        }
    }

    private void k(ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        v.a((List) arrayList2, 0, (List) arrayList);
        v.b(arrayList2, this.bvQ);
        v.b(arrayList2, this.bvR);
        a aVar = new a(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, null, DiskFileOperate.Action.DELETE_FILES, arrayList2);
        aVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        aVar.T(false);
        aVar.U(true);
        com.baidu.adp.lib.Disk.d.hz().c(aVar);
    }

    private com.baidu.tbadk.core.bigday.a b(List<com.baidu.tbadk.core.bigday.a> list, int i) {
        if (!v.T(list)) {
            Iterator<com.baidu.tbadk.core.bigday.a> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.core.bigday.a next = it.next();
                if (next.WI() && next.bvP == i) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (next.startTime > currentTimeMillis) {
                        this.bvS.put(i, Long.valueOf(next.startTime));
                        break;
                    } else if (next.endTime >= currentTimeMillis) {
                        return next;
                    }
                }
            }
        }
        return null;
    }

    public com.baidu.tbadk.core.bigday.a gb(int i) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (i == 1) {
            if (this.bvQ == null && this.bvS.get(i, 0L).longValue() != 0 && this.bvS.get(i, 0L).longValue() < currentTimeMillis) {
                this.bvQ = b(this.bvT, 1);
            }
            if (this.bvQ != null && (currentTimeMillis < this.bvQ.startTime || currentTimeMillis > this.bvQ.endTime)) {
                this.bvQ = b(this.bvT, 1);
            }
            if (this.bvQ != null && d.nf(this.bvQ.imgUrl)) {
                return this.bvQ;
            }
        } else if (i == 3) {
            if (this.bvR == null && this.bvS.get(i, 0L).longValue() != 0 && this.bvS.get(i, 0L).longValue() < currentTimeMillis) {
                this.bvQ = b(this.bvT, 3);
            }
            if (this.bvR != null && (currentTimeMillis < this.bvR.startTime || currentTimeMillis > this.bvR.endTime)) {
                this.bvR = b(this.bvT, 3);
            }
            if (this.bvR != null && d.nf(this.bvR.imgUrl)) {
                return this.bvR;
            }
        }
        return null;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.mNetMessageListener);
    }

    public boolean WN() {
        return this.bvV;
    }

    public void dh(boolean z) {
        this.bvV = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends DiskFileOperate implements com.baidu.adp.lib.Disk.a {
        private ArrayList<String> bvY;

        public a(String str, String str2, DiskFileOperate.Action action, ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
            super(str, str2, action);
            this.bvY = new ArrayList<>();
            Iterator<com.baidu.tbadk.core.bigday.a> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.bigday.a next = it.next();
                if (next != null) {
                    String k = c.jB().k(next.imgUrl, 41);
                    if (!StringUtils.isNULL(k)) {
                        String mL = as.mL(k);
                        if (!StringUtils.isNULL(mL)) {
                            this.bvY.add(mL);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.adp.lib.Disk.a
        public boolean k(File file) {
            return (file == null || StringUtils.isNULL(file.getName()) || this.bvY.contains(file.getName())) ? false : true;
        }
    }
}
