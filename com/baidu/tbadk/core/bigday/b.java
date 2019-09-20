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
    private static b bEv = null;
    private com.baidu.tbadk.core.bigday.a bEp;
    private com.baidu.tbadk.core.bigday.a bEq;
    private SparseArray<Long> bEr;
    private ArrayList<com.baidu.tbadk.core.bigday.a> bEs;
    private boolean bEt = false;
    private boolean bEu = true;
    private com.baidu.adp.framework.listener.a bzz = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_BIGDAY_INFO, 309609) { // from class: com.baidu.tbadk.core.bigday.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && !responsedMessage.hasError()) {
                b.this.bEt = true;
                ArrayList<com.baidu.tbadk.core.bigday.a> arrayList = null;
                if (responsedMessage instanceof GetBigdayInfoSocketResMessage) {
                    arrayList = ((GetBigdayInfoSocketResMessage) responsedMessage).bigdayInfos;
                } else if (responsedMessage instanceof GetBigdayInfoHttpResMessage) {
                    arrayList = ((GetBigdayInfoHttpResMessage) responsedMessage).bigdayInfos;
                }
                b.this.m(arrayList);
            }
        }
    };
    private BdUniqueId mTag;

    private b() {
        com.baidu.tieba.tbadkCore.a.a.a(309609, GetBigdayInfoSocketResMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309609, CmdConfigHttp.CMD_GET_BIGDAY_INFO, "c/s/getBigday", GetBigdayInfoHttpResMessage.class, false, false, true, false);
        MessageManager.getInstance().registerListener(this.bzz);
        this.bEr = new SparseArray<>();
    }

    public static b acs() {
        if (bEv == null) {
            bEv = new b();
        }
        return bEv;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void act() {
        this.bEt = false;
        GetBigdayInfoReqMessage getBigdayInfoReqMessage = new GetBigdayInfoReqMessage();
        getBigdayInfoReqMessage.setTag(this.mTag);
        MessageManager.getInstance().sendMessage(getBigdayInfoReqMessage);
    }

    public void acu() {
        new BdAsyncTask<Void, Void, ArrayList<com.baidu.tbadk.core.bigday.a>>() { // from class: com.baidu.tbadk.core.bigday.b.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: d */
            public ArrayList<com.baidu.tbadk.core.bigday.a> doInBackground(Void... voidArr) {
                byte[] bArr;
                ArrayList<com.baidu.tbadk.core.bigday.a> arrayList = new ArrayList<>();
                l<byte[]> mM = com.baidu.tbadk.core.d.a.agL().mM("tb.bigday_datas");
                if (mM != null && (bArr = mM.get("tb.bigday_datas")) != null) {
                    try {
                        GetBigdayResIdl getBigdayResIdl = (GetBigdayResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBigdayResIdl.class);
                        if (getBigdayResIdl.data != null) {
                            for (BigdayInfo bigdayInfo : getBigdayResIdl.data.bigday_list) {
                                if (bigdayInfo != null) {
                                    com.baidu.tbadk.core.bigday.a aVar = new com.baidu.tbadk.core.bigday.a();
                                    aVar.a(bigdayInfo);
                                    if (aVar.acr()) {
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
                    b.this.l(arrayList);
                }
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
        if (!v.aa(arrayList) && !this.bEt) {
            this.bEp = b(arrayList, 1);
            this.bEq = b(arrayList, 3);
            this.bEs = arrayList;
            acv();
            if (this.bEp != null && d.oN(this.bEp.imgUrl) && com.baidu.adp.lib.b.d.hS().az("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.ahU().getLong("key_bigday_next_showtime_home", 0L)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.bEp));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
        com.baidu.tbadk.core.bigday.a b = b(arrayList, 1);
        com.baidu.tbadk.core.bigday.a b2 = b(arrayList, 3);
        n(arrayList);
        this.bEs = arrayList;
        if (b != null && b.acr()) {
            this.bEp = b;
        }
        if (b2 != null && b2.acr()) {
            this.bEq = b2;
        }
        acv();
        if (this.bEp != null && d.oN(this.bEp.imgUrl) && com.baidu.adp.lib.b.d.hS().az("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.ahU().getLong("key_bigday_next_showtime_home", 0L)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.bEp));
        }
    }

    private void acv() {
        if (!v.aa(this.bEs)) {
            Iterator<com.baidu.tbadk.core.bigday.a> it = this.bEs.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.bigday.a next = it.next();
                if (!d.oN(next.imgUrl)) {
                    c.iE().a(next.imgUrl, 41, null, this.mTag);
                }
            }
        }
    }

    private void n(ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        v.a((List) arrayList2, 0, (List) arrayList);
        v.b(arrayList2, this.bEp);
        v.b(arrayList2, this.bEq);
        a aVar = new a(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, null, DiskFileOperate.Action.DELETE_FILES, arrayList2);
        aVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        aVar.L(false);
        aVar.M(true);
        com.baidu.adp.lib.Disk.d.gC().c(aVar);
    }

    private com.baidu.tbadk.core.bigday.a b(List<com.baidu.tbadk.core.bigday.a> list, int i) {
        if (!v.aa(list)) {
            Iterator<com.baidu.tbadk.core.bigday.a> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.core.bigday.a next = it.next();
                if (next.acr() && next.bEo == i) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (next.startTime > currentTimeMillis) {
                        this.bEr.put(i, Long.valueOf(next.startTime));
                        break;
                    } else if (next.endTime >= currentTimeMillis) {
                        return next;
                    }
                }
            }
        }
        return null;
    }

    public com.baidu.tbadk.core.bigday.a gS(int i) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (i == 1) {
            if (this.bEp == null && this.bEr.get(i, 0L).longValue() != 0 && this.bEr.get(i, 0L).longValue() < currentTimeMillis) {
                this.bEp = b(this.bEs, 1);
            }
            if (this.bEp != null && (currentTimeMillis < this.bEp.startTime || currentTimeMillis > this.bEp.endTime)) {
                this.bEp = b(this.bEs, 1);
            }
            if (this.bEp != null && d.oN(this.bEp.imgUrl)) {
                return this.bEp;
            }
        } else if (i == 3) {
            if (this.bEq == null && this.bEr.get(i, 0L).longValue() != 0 && this.bEr.get(i, 0L).longValue() < currentTimeMillis) {
                this.bEp = b(this.bEs, 3);
            }
            if (this.bEq != null && (currentTimeMillis < this.bEq.startTime || currentTimeMillis > this.bEq.endTime)) {
                this.bEq = b(this.bEs, 3);
            }
            if (this.bEq != null && d.oN(this.bEq.imgUrl)) {
                return this.bEq;
            }
        }
        return null;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.bzz);
    }

    public void dG(boolean z) {
        this.bEu = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends DiskFileOperate implements com.baidu.adp.lib.Disk.a {
        private ArrayList<String> bEx;

        public a(String str, String str2, DiskFileOperate.Action action, ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
            super(str, str2, action);
            this.bEx = new ArrayList<>();
            Iterator<com.baidu.tbadk.core.bigday.a> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.bigday.a next = it.next();
                if (next != null) {
                    String e = c.iE().e(next.imgUrl, 41);
                    if (!StringUtils.isNULL(e)) {
                        String ol = as.ol(e);
                        if (!StringUtils.isNULL(ol)) {
                            this.bEx.add(ol);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.adp.lib.Disk.a
        public boolean e(File file) {
            return (file == null || StringUtils.isNULL(file.getName()) || this.bEx.contains(file.getName())) ? false : true;
        }
    }
}
