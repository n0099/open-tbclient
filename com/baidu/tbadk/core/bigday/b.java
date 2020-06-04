package com.baidu.tbadk.core.bigday;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.c.d;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.switchs.BigdaySwitch;
import com.squareup.wire.Wire;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.GetBigday.BigdayInfo;
import tbclient.GetBigday.GetBigdayResIdl;
/* loaded from: classes.dex */
public class b {
    private static b dzx = null;
    private com.baidu.tbadk.core.bigday.a dzr;
    private com.baidu.tbadk.core.bigday.a dzs;
    private SparseArray<Long> dzt;
    private ArrayList<com.baidu.tbadk.core.bigday.a> dzu;
    private BdUniqueId mTag;
    private boolean dzv = false;
    private boolean dzw = true;
    private com.baidu.adp.framework.listener.a dve = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_BIGDAY_INFO, 309609) { // from class: com.baidu.tbadk.core.bigday.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && !responsedMessage.hasError()) {
                b.this.dzv = true;
                ArrayList<com.baidu.tbadk.core.bigday.a> arrayList = null;
                if (responsedMessage instanceof GetBigdayInfoSocketResMessage) {
                    arrayList = ((GetBigdayInfoSocketResMessage) responsedMessage).bigdayInfos;
                } else if (responsedMessage instanceof GetBigdayInfoHttpResMessage) {
                    arrayList = ((GetBigdayInfoHttpResMessage) responsedMessage).bigdayInfos;
                }
                b.this.t(arrayList);
            }
        }
    };

    private b() {
        com.baidu.tieba.tbadkCore.a.a.a(309609, GetBigdayInfoSocketResMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309609, CmdConfigHttp.CMD_GET_BIGDAY_INFO, "c/s/getBigday", GetBigdayInfoHttpResMessage.class, false, false, true, false);
        MessageManager.getInstance().registerListener(this.dve);
        this.dzt = new SparseArray<>();
    }

    public static b aNY() {
        if (dzx == null) {
            dzx = new b();
        }
        return dzx;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void aNZ() {
        this.dzv = false;
        GetBigdayInfoReqMessage getBigdayInfoReqMessage = new GetBigdayInfoReqMessage();
        getBigdayInfoReqMessage.setTag(this.mTag);
        MessageManager.getInstance().sendMessage(getBigdayInfoReqMessage);
    }

    public void aOa() {
        new BdAsyncTask<Void, Void, ArrayList<com.baidu.tbadk.core.bigday.a>>() { // from class: com.baidu.tbadk.core.bigday.b.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: e */
            public ArrayList<com.baidu.tbadk.core.bigday.a> doInBackground(Void... voidArr) {
                byte[] bArr;
                ArrayList<com.baidu.tbadk.core.bigday.a> arrayList = new ArrayList<>();
                l<byte[]> vL = com.baidu.tbadk.core.c.a.aSS().vL("tb.bigday_datas");
                if (vL != null && (bArr = vL.get("tb.bigday_datas")) != null) {
                    try {
                        GetBigdayResIdl getBigdayResIdl = (GetBigdayResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBigdayResIdl.class);
                        if (getBigdayResIdl.data != null) {
                            for (BigdayInfo bigdayInfo : getBigdayResIdl.data.bigday_list) {
                                if (bigdayInfo != null) {
                                    com.baidu.tbadk.core.bigday.a aVar = new com.baidu.tbadk.core.bigday.a();
                                    aVar.a(bigdayInfo);
                                    if (aVar.aNX()) {
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
                    b.this.s(arrayList);
                }
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
        if (!v.isEmpty(arrayList) && !this.dzv) {
            this.dzr = c(arrayList, 1);
            this.dzs = c(arrayList, 3);
            this.dzu = arrayList;
            aOb();
            if (this.dzr != null && d.wH(this.dzr.imgUrl) && SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aTX().getLong("key_bigday_next_showtime_home", 0L)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.dzr));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
        com.baidu.tbadk.core.bigday.a c = c(arrayList, 1);
        com.baidu.tbadk.core.bigday.a c2 = c(arrayList, 3);
        u(arrayList);
        this.dzu = arrayList;
        if (c != null && c.aNX()) {
            this.dzr = c;
        }
        if (c2 != null && c2.aNX()) {
            this.dzs = c2;
        }
        aOb();
        if (this.dzr != null && d.wH(this.dzr.imgUrl) && SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aTX().getLong("key_bigday_next_showtime_home", 0L)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.dzr));
        }
    }

    private void aOb() {
        if (!v.isEmpty(this.dzu)) {
            Iterator<com.baidu.tbadk.core.bigday.a> it = this.dzu.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.bigday.a next = it.next();
                if (!d.wH(next.imgUrl)) {
                    c.kX().a(next.imgUrl, 41, null, this.mTag);
                }
            }
        }
    }

    private void u(ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        v.addAll(arrayList2, 0, arrayList);
        v.add(arrayList2, this.dzr);
        v.add(arrayList2, this.dzs);
        a aVar = new a(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, null, DiskFileOperate.Action.DELETE_FILES, arrayList2);
        aVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        aVar.setSdCard(false);
        aVar.setSavedCache(true);
        com.baidu.adp.lib.Disk.d.jR().c(aVar);
    }

    private com.baidu.tbadk.core.bigday.a c(List<com.baidu.tbadk.core.bigday.a> list, int i) {
        if (!v.isEmpty(list)) {
            Iterator<com.baidu.tbadk.core.bigday.a> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.core.bigday.a next = it.next();
                if (next.aNX() && next.dzq == i) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (next.startTime > currentTimeMillis) {
                        this.dzt.put(i, Long.valueOf(next.startTime));
                        break;
                    } else if (next.endTime >= currentTimeMillis) {
                        return next;
                    }
                }
            }
        }
        return null;
    }

    public com.baidu.tbadk.core.bigday.a kc(int i) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (i == 1) {
            if (this.dzr == null && this.dzt.get(i, 0L).longValue() != 0 && this.dzt.get(i, 0L).longValue() < currentTimeMillis) {
                this.dzr = c(this.dzu, 1);
            }
            if (this.dzr != null && (currentTimeMillis < this.dzr.startTime || currentTimeMillis > this.dzr.endTime)) {
                this.dzr = c(this.dzu, 1);
            }
            if (this.dzr != null && d.wH(this.dzr.imgUrl)) {
                return this.dzr;
            }
        } else if (i == 3) {
            if (this.dzs == null && this.dzt.get(i, 0L).longValue() != 0 && this.dzt.get(i, 0L).longValue() < currentTimeMillis) {
                this.dzr = c(this.dzu, 3);
            }
            if (this.dzs != null && (currentTimeMillis < this.dzs.startTime || currentTimeMillis > this.dzs.endTime)) {
                this.dzs = c(this.dzu, 3);
            }
            if (this.dzs != null && d.wH(this.dzs.imgUrl)) {
                return this.dzs;
            }
        }
        return null;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.dve);
    }

    public void gJ(boolean z) {
        this.dzw = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends DiskFileOperate implements com.baidu.adp.lib.Disk.a {
        private ArrayList<String> dzz;

        public a(String str, String str2, DiskFileOperate.Action action, ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
            super(str, str2, action);
            this.dzz = new ArrayList<>();
            Iterator<com.baidu.tbadk.core.bigday.a> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.bigday.a next = it.next();
                if (next != null) {
                    String genCacheKey = c.kX().genCacheKey(next.imgUrl, 41);
                    if (!StringUtils.isNULL(genCacheKey)) {
                        String nameMd5FromUrl = as.getNameMd5FromUrl(genCacheKey);
                        if (!StringUtils.isNULL(nameMd5FromUrl)) {
                            this.dzz.add(nameMd5FromUrl);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.adp.lib.Disk.a
        public boolean compare(File file) {
            return (file == null || StringUtils.isNULL(file.getName()) || this.dzz.contains(file.getName())) ? false : true;
        }
    }
}
