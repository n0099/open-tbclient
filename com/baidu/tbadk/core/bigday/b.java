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
import com.baidu.tbadk.core.util.e.d;
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
    private static b bWm = null;
    private com.baidu.tbadk.core.bigday.a bWg;
    private com.baidu.tbadk.core.bigday.a bWh;
    private SparseArray<Long> bWi;
    private ArrayList<com.baidu.tbadk.core.bigday.a> bWj;
    private BdUniqueId mTag;
    private boolean bWk = false;
    private boolean bWl = true;
    private com.baidu.adp.framework.listener.a bSf = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_BIGDAY_INFO, 309609) { // from class: com.baidu.tbadk.core.bigday.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && !responsedMessage.hasError()) {
                b.this.bWk = true;
                ArrayList<com.baidu.tbadk.core.bigday.a> arrayList = null;
                if (responsedMessage instanceof GetBigdayInfoSocketResMessage) {
                    arrayList = ((GetBigdayInfoSocketResMessage) responsedMessage).bigdayInfos;
                } else if (responsedMessage instanceof GetBigdayInfoHttpResMessage) {
                    arrayList = ((GetBigdayInfoHttpResMessage) responsedMessage).bigdayInfos;
                }
                b.this.p(arrayList);
            }
        }
    };

    private b() {
        com.baidu.tieba.tbadkCore.a.a.a(309609, GetBigdayInfoSocketResMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309609, CmdConfigHttp.CMD_GET_BIGDAY_INFO, "c/s/getBigday", GetBigdayInfoHttpResMessage.class, false, false, true, false);
        MessageManager.getInstance().registerListener(this.bSf);
        this.bWi = new SparseArray<>();
    }

    public static b agy() {
        if (bWm == null) {
            bWm = new b();
        }
        return bWm;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void agz() {
        this.bWk = false;
        GetBigdayInfoReqMessage getBigdayInfoReqMessage = new GetBigdayInfoReqMessage();
        getBigdayInfoReqMessage.setTag(this.mTag);
        MessageManager.getInstance().sendMessage(getBigdayInfoReqMessage);
    }

    public void agA() {
        new BdAsyncTask<Void, Void, ArrayList<com.baidu.tbadk.core.bigday.a>>() { // from class: com.baidu.tbadk.core.bigday.b.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: e */
            public ArrayList<com.baidu.tbadk.core.bigday.a> doInBackground(Void... voidArr) {
                byte[] bArr;
                ArrayList<com.baidu.tbadk.core.bigday.a> arrayList = new ArrayList<>();
                l<byte[]> nk = com.baidu.tbadk.core.d.a.akN().nk("tb.bigday_datas");
                if (nk != null && (bArr = nk.get("tb.bigday_datas")) != null) {
                    try {
                        GetBigdayResIdl getBigdayResIdl = (GetBigdayResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBigdayResIdl.class);
                        if (getBigdayResIdl.data != null) {
                            for (BigdayInfo bigdayInfo : getBigdayResIdl.data.bigday_list) {
                                if (bigdayInfo != null) {
                                    com.baidu.tbadk.core.bigday.a aVar = new com.baidu.tbadk.core.bigday.a();
                                    aVar.a(bigdayInfo);
                                    if (aVar.agx()) {
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
                    b.this.o(arrayList);
                }
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
        if (!v.isEmpty(arrayList) && !this.bWk) {
            this.bWg = b(arrayList, 1);
            this.bWh = b(arrayList, 3);
            this.bWj = arrayList;
            agB();
            if (this.bWg != null && d.om(this.bWg.imgUrl) && com.baidu.adp.lib.b.d.ft().af("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.alR().getLong("key_bigday_next_showtime_home", 0L)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.bWg));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
        com.baidu.tbadk.core.bigday.a b = b(arrayList, 1);
        com.baidu.tbadk.core.bigday.a b2 = b(arrayList, 3);
        q(arrayList);
        this.bWj = arrayList;
        if (b != null && b.agx()) {
            this.bWg = b;
        }
        if (b2 != null && b2.agx()) {
            this.bWh = b2;
        }
        agB();
        if (this.bWg != null && d.om(this.bWg.imgUrl) && com.baidu.adp.lib.b.d.ft().af("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.alR().getLong("key_bigday_next_showtime_home", 0L)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.bWg));
        }
    }

    private void agB() {
        if (!v.isEmpty(this.bWj)) {
            Iterator<com.baidu.tbadk.core.bigday.a> it = this.bWj.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.bigday.a next = it.next();
                if (!d.om(next.imgUrl)) {
                    c.fT().a(next.imgUrl, 41, null, this.mTag);
                }
            }
        }
    }

    private void q(ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        v.addAll(arrayList2, 0, arrayList);
        v.add(arrayList2, this.bWg);
        v.add(arrayList2, this.bWh);
        a aVar = new a(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, null, DiskFileOperate.Action.DELETE_FILES, arrayList2);
        aVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        aVar.setSdCard(false);
        aVar.setSavedCache(true);
        com.baidu.adp.lib.Disk.d.eP().c(aVar);
    }

    private com.baidu.tbadk.core.bigday.a b(List<com.baidu.tbadk.core.bigday.a> list, int i) {
        if (!v.isEmpty(list)) {
            Iterator<com.baidu.tbadk.core.bigday.a> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.core.bigday.a next = it.next();
                if (next.agx() && next.bWf == i) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (next.startTime > currentTimeMillis) {
                        this.bWi.put(i, Long.valueOf(next.startTime));
                        break;
                    } else if (next.endTime >= currentTimeMillis) {
                        return next;
                    }
                }
            }
        }
        return null;
    }

    public com.baidu.tbadk.core.bigday.a hr(int i) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (i == 1) {
            if (this.bWg == null && this.bWi.get(i, 0L).longValue() != 0 && this.bWi.get(i, 0L).longValue() < currentTimeMillis) {
                this.bWg = b(this.bWj, 1);
            }
            if (this.bWg != null && (currentTimeMillis < this.bWg.startTime || currentTimeMillis > this.bWg.endTime)) {
                this.bWg = b(this.bWj, 1);
            }
            if (this.bWg != null && d.om(this.bWg.imgUrl)) {
                return this.bWg;
            }
        } else if (i == 3) {
            if (this.bWh == null && this.bWi.get(i, 0L).longValue() != 0 && this.bWi.get(i, 0L).longValue() < currentTimeMillis) {
                this.bWg = b(this.bWj, 3);
            }
            if (this.bWh != null && (currentTimeMillis < this.bWh.startTime || currentTimeMillis > this.bWh.endTime)) {
                this.bWh = b(this.bWj, 3);
            }
            if (this.bWh != null && d.om(this.bWh.imgUrl)) {
                return this.bWh;
            }
        }
        return null;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.bSf);
    }

    public void dW(boolean z) {
        this.bWl = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends DiskFileOperate implements com.baidu.adp.lib.Disk.a {
        private ArrayList<String> bWo;

        public a(String str, String str2, DiskFileOperate.Action action, ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
            super(str, str2, action);
            this.bWo = new ArrayList<>();
            Iterator<com.baidu.tbadk.core.bigday.a> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.bigday.a next = it.next();
                if (next != null) {
                    String genCacheKey = c.fT().genCacheKey(next.imgUrl, 41);
                    if (!StringUtils.isNULL(genCacheKey)) {
                        String nameMd5FromUrl = as.getNameMd5FromUrl(genCacheKey);
                        if (!StringUtils.isNULL(nameMd5FromUrl)) {
                            this.bWo.add(nameMd5FromUrl);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.adp.lib.Disk.a
        public boolean compare(File file) {
            return (file == null || StringUtils.isNULL(file.getName()) || this.bWo.contains(file.getName())) ? false : true;
        }
    }
}
