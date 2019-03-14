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
    private static b bvS = null;
    private com.baidu.tbadk.core.bigday.a bvM;
    private com.baidu.tbadk.core.bigday.a bvN;
    private SparseArray<Long> bvO;
    private ArrayList<com.baidu.tbadk.core.bigday.a> bvP;
    private boolean bvQ = false;
    private boolean bvR = true;
    private com.baidu.adp.framework.listener.a mNetMessageListener = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_BIGDAY_INFO, 309609) { // from class: com.baidu.tbadk.core.bigday.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && !responsedMessage.hasError()) {
                b.this.bvQ = true;
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
        this.bvO = new SparseArray<>();
    }

    public static b WM() {
        if (bvS == null) {
            bvS = new b();
        }
        return bvS;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void WN() {
        this.bvQ = false;
        GetBigdayInfoReqMessage getBigdayInfoReqMessage = new GetBigdayInfoReqMessage();
        getBigdayInfoReqMessage.setTag(this.mTag);
        MessageManager.getInstance().sendMessage(getBigdayInfoReqMessage);
    }

    public void WO() {
        new BdAsyncTask<Void, Void, ArrayList<com.baidu.tbadk.core.bigday.a>>() { // from class: com.baidu.tbadk.core.bigday.b.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: d */
            public ArrayList<com.baidu.tbadk.core.bigday.a> doInBackground(Void... voidArr) {
                byte[] bArr;
                ArrayList<com.baidu.tbadk.core.bigday.a> arrayList = new ArrayList<>();
                l<byte[]> lu = com.baidu.tbadk.core.c.a.aaW().lu("tb.bigday_datas");
                if (lu != null && (bArr = lu.get("tb.bigday_datas")) != null) {
                    try {
                        GetBigdayResIdl getBigdayResIdl = (GetBigdayResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBigdayResIdl.class);
                        if (getBigdayResIdl.data != null) {
                            for (BigdayInfo bigdayInfo : getBigdayResIdl.data.bigday_list) {
                                if (bigdayInfo != null) {
                                    com.baidu.tbadk.core.bigday.a aVar = new com.baidu.tbadk.core.bigday.a();
                                    aVar.a(bigdayInfo);
                                    if (aVar.WL()) {
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
        if (!v.T(arrayList) && !this.bvQ) {
            this.bvM = b(arrayList, 1);
            this.bvN = b(arrayList, 3);
            this.bvP = arrayList;
            WP();
            if (this.bvM != null && d.ne(this.bvM.imgUrl) && com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.bvM));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
        com.baidu.tbadk.core.bigday.a b = b(arrayList, 1);
        com.baidu.tbadk.core.bigday.a b2 = b(arrayList, 3);
        k(arrayList);
        this.bvP = arrayList;
        if (b != null && b.WL()) {
            this.bvM = b;
        }
        if (b2 != null && b2.WL()) {
            this.bvN = b2;
        }
        WP();
        if (this.bvM != null && d.ne(this.bvM.imgUrl) && com.baidu.adp.lib.b.d.iQ().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.bvM));
        }
    }

    private void WP() {
        if (!v.T(this.bvP)) {
            Iterator<com.baidu.tbadk.core.bigday.a> it = this.bvP.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.bigday.a next = it.next();
                if (!d.ne(next.imgUrl)) {
                    c.jB().a(next.imgUrl, 41, null, this.mTag);
                }
            }
        }
    }

    private void k(ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        v.a((List) arrayList2, 0, (List) arrayList);
        v.b(arrayList2, this.bvM);
        v.b(arrayList2, this.bvN);
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
                if (next.WL() && next.bvL == i) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (next.startTime > currentTimeMillis) {
                        this.bvO.put(i, Long.valueOf(next.startTime));
                        break;
                    } else if (next.endTime >= currentTimeMillis) {
                        return next;
                    }
                }
            }
        }
        return null;
    }

    public com.baidu.tbadk.core.bigday.a gc(int i) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (i == 1) {
            if (this.bvM == null && this.bvO.get(i, 0L).longValue() != 0 && this.bvO.get(i, 0L).longValue() < currentTimeMillis) {
                this.bvM = b(this.bvP, 1);
            }
            if (this.bvM != null && (currentTimeMillis < this.bvM.startTime || currentTimeMillis > this.bvM.endTime)) {
                this.bvM = b(this.bvP, 1);
            }
            if (this.bvM != null && d.ne(this.bvM.imgUrl)) {
                return this.bvM;
            }
        } else if (i == 3) {
            if (this.bvN == null && this.bvO.get(i, 0L).longValue() != 0 && this.bvO.get(i, 0L).longValue() < currentTimeMillis) {
                this.bvM = b(this.bvP, 3);
            }
            if (this.bvN != null && (currentTimeMillis < this.bvN.startTime || currentTimeMillis > this.bvN.endTime)) {
                this.bvN = b(this.bvP, 3);
            }
            if (this.bvN != null && d.ne(this.bvN.imgUrl)) {
                return this.bvN;
            }
        }
        return null;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.mNetMessageListener);
    }

    public boolean WQ() {
        return this.bvR;
    }

    public void dh(boolean z) {
        this.bvR = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends DiskFileOperate implements com.baidu.adp.lib.Disk.a {
        private ArrayList<String> bvU;

        public a(String str, String str2, DiskFileOperate.Action action, ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
            super(str, str2, action);
            this.bvU = new ArrayList<>();
            Iterator<com.baidu.tbadk.core.bigday.a> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.bigday.a next = it.next();
                if (next != null) {
                    String k = c.jB().k(next.imgUrl, 41);
                    if (!StringUtils.isNULL(k)) {
                        String mK = as.mK(k);
                        if (!StringUtils.isNULL(mK)) {
                            this.bvU.add(mK);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.adp.lib.Disk.a
        public boolean k(File file) {
            return (file == null || StringUtils.isNULL(file.getName()) || this.bvU.contains(file.getName())) ? false : true;
        }
    }
}
