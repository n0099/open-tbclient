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
    private static b akp = null;
    private com.baidu.tbadk.core.bigday.a akj;
    private com.baidu.tbadk.core.bigday.a akk;
    private SparseArray<Long> akl;
    private ArrayList<com.baidu.tbadk.core.bigday.a> akm;
    private boolean akn = false;
    private boolean ako = true;
    private com.baidu.adp.framework.listener.a mNetMessageListener = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_BIGDAY_INFO, 309609) { // from class: com.baidu.tbadk.core.bigday.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && !responsedMessage.hasError()) {
                b.this.akn = true;
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
    private BdUniqueId mTag;

    private b() {
        com.baidu.tieba.tbadkCore.a.a.a(309609, GetBigdayInfoSocketResMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309609, CmdConfigHttp.CMD_GET_BIGDAY_INFO, "c/s/getBigday", GetBigdayInfoHttpResMessage.class, false, false, true, false);
        MessageManager.getInstance().registerListener(this.mNetMessageListener);
        this.akl = new SparseArray<>();
    }

    public static b wG() {
        if (akp == null) {
            akp = new b();
        }
        return akp;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void wH() {
        this.akn = false;
        GetBigdayInfoReqMessage getBigdayInfoReqMessage = new GetBigdayInfoReqMessage();
        getBigdayInfoReqMessage.setTag(this.mTag);
        MessageManager.getInstance().sendMessage(getBigdayInfoReqMessage);
    }

    public void wI() {
        new BdAsyncTask<Void, Void, ArrayList<com.baidu.tbadk.core.bigday.a>>() { // from class: com.baidu.tbadk.core.bigday.b.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: c */
            public ArrayList<com.baidu.tbadk.core.bigday.a> doInBackground(Void... voidArr) {
                byte[] bArr;
                ArrayList<com.baidu.tbadk.core.bigday.a> arrayList = new ArrayList<>();
                l<byte[]> ef = com.baidu.tbadk.core.c.a.Aq().ef("tb.bigday_datas");
                if (ef != null && (bArr = ef.get("tb.bigday_datas")) != null) {
                    try {
                        GetBigdayResIdl getBigdayResIdl = (GetBigdayResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBigdayResIdl.class);
                        if (getBigdayResIdl.data != null) {
                            for (BigdayInfo bigdayInfo : getBigdayResIdl.data.bigday_list) {
                                if (bigdayInfo != null) {
                                    com.baidu.tbadk.core.bigday.a aVar = new com.baidu.tbadk.core.bigday.a();
                                    aVar.a(bigdayInfo);
                                    if (aVar.wF()) {
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
        if (!v.J(arrayList) && !this.akn) {
            this.akj = c(arrayList, 1);
            this.akk = c(arrayList, 3);
            this.akm = arrayList;
            wJ();
            if (this.akj != null && d.fM(this.akj.imgUrl) && com.baidu.adp.lib.b.d.iR().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.akj));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
        com.baidu.tbadk.core.bigday.a c = c(arrayList, 1);
        com.baidu.tbadk.core.bigday.a c2 = c(arrayList, 3);
        h(arrayList);
        this.akm = arrayList;
        if (c != null && c.wF()) {
            this.akj = c;
        }
        if (c2 != null && c2.wF()) {
            this.akk = c2;
        }
        wJ();
        if (this.akj != null && d.fM(this.akj.imgUrl) && com.baidu.adp.lib.b.d.iR().aO("android_bigday_switch") == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_bigday_next_showtime_home", 0L)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.akj));
        }
    }

    private void wJ() {
        if (!v.J(this.akm)) {
            Iterator<com.baidu.tbadk.core.bigday.a> it = this.akm.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.bigday.a next = it.next();
                if (!d.fM(next.imgUrl)) {
                    c.jC().a(next.imgUrl, 41, null, this.mTag);
                }
            }
        }
    }

    private void h(ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        v.a((List) arrayList2, 0, (List) arrayList);
        v.b(arrayList2, this.akj);
        v.b(arrayList2, this.akk);
        a aVar = new a(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, null, DiskFileOperate.Action.DELETE_FILES, arrayList2);
        aVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        aVar.F(false);
        aVar.G(true);
        com.baidu.adp.lib.Disk.d.hC().c(aVar);
    }

    private com.baidu.tbadk.core.bigday.a c(List<com.baidu.tbadk.core.bigday.a> list, int i) {
        if (!v.J(list)) {
            Iterator<com.baidu.tbadk.core.bigday.a> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.core.bigday.a next = it.next();
                if (next.wF() && next.aki == i) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (next.startTime > currentTimeMillis) {
                        this.akl.put(i, Long.valueOf(next.startTime));
                        break;
                    } else if (next.endTime >= currentTimeMillis) {
                        return next;
                    }
                }
            }
        }
        return null;
    }

    public com.baidu.tbadk.core.bigday.a bX(int i) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (i == 1) {
            if (this.akj == null && this.akl.get(i, 0L).longValue() != 0 && this.akl.get(i, 0L).longValue() < currentTimeMillis) {
                this.akj = c(this.akm, 1);
            }
            if (this.akj != null && (currentTimeMillis < this.akj.startTime || currentTimeMillis > this.akj.endTime)) {
                this.akj = c(this.akm, 1);
            }
            if (this.akj != null && d.fM(this.akj.imgUrl)) {
                return this.akj;
            }
        } else if (i == 3) {
            if (this.akk == null && this.akl.get(i, 0L).longValue() != 0 && this.akl.get(i, 0L).longValue() < currentTimeMillis) {
                this.akj = c(this.akm, 3);
            }
            if (this.akk != null && (currentTimeMillis < this.akk.startTime || currentTimeMillis > this.akk.endTime)) {
                this.akk = c(this.akm, 3);
            }
            if (this.akk != null && d.fM(this.akk.imgUrl)) {
                return this.akk;
            }
        }
        return null;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.mNetMessageListener);
    }

    public boolean wK() {
        return this.ako;
    }

    public void aG(boolean z) {
        this.ako = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends DiskFileOperate implements com.baidu.adp.lib.Disk.a {
        private ArrayList<String> akr;

        public a(String str, String str2, DiskFileOperate.Action action, ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
            super(str, str2, action);
            this.akr = new ArrayList<>();
            Iterator<com.baidu.tbadk.core.bigday.a> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.bigday.a next = it.next();
                if (next != null) {
                    String k = c.jC().k(next.imgUrl, 41);
                    if (!StringUtils.isNULL(k)) {
                        String fs = ar.fs(k);
                        if (!StringUtils.isNULL(fs)) {
                            this.akr.add(fs);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.adp.lib.Disk.a
        public boolean j(File file) {
            return (file == null || StringUtils.isNULL(file.getName()) || this.akr.contains(file.getName())) ? false : true;
        }
    }
}
