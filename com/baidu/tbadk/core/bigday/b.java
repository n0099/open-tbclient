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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.c.d;
import com.baidu.tbadk.core.util.y;
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
    private static b dXy = null;
    private com.baidu.tbadk.core.bigday.a dXs;
    private com.baidu.tbadk.core.bigday.a dXt;
    private SparseArray<Long> dXu;
    private ArrayList<com.baidu.tbadk.core.bigday.a> dXv;
    private BdUniqueId mTag;
    private boolean dXw = false;
    private boolean dXx = true;
    private com.baidu.adp.framework.listener.a dRa = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_BIGDAY_INFO, 309609) { // from class: com.baidu.tbadk.core.bigday.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && !responsedMessage.hasError()) {
                b.this.dXw = true;
                ArrayList<com.baidu.tbadk.core.bigday.a> arrayList = null;
                if (responsedMessage instanceof GetBigdayInfoSocketResMessage) {
                    arrayList = ((GetBigdayInfoSocketResMessage) responsedMessage).bigdayInfos;
                } else if (responsedMessage instanceof GetBigdayInfoHttpResMessage) {
                    arrayList = ((GetBigdayInfoHttpResMessage) responsedMessage).bigdayInfos;
                }
                b.this.z(arrayList);
            }
        }
    };

    private b() {
        com.baidu.tieba.tbadkCore.a.a.a(309609, GetBigdayInfoSocketResMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309609, CmdConfigHttp.CMD_GET_BIGDAY_INFO, "c/s/getBigday", GetBigdayInfoHttpResMessage.class, false, false, true, false);
        MessageManager.getInstance().registerListener(this.dRa);
        this.dXu = new SparseArray<>();
    }

    public static b bcO() {
        if (dXy == null) {
            dXy = new b();
        }
        return dXy;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void bcP() {
        this.dXw = false;
        GetBigdayInfoReqMessage getBigdayInfoReqMessage = new GetBigdayInfoReqMessage();
        getBigdayInfoReqMessage.setTag(this.mTag);
        MessageManager.getInstance().sendMessage(getBigdayInfoReqMessage);
    }

    public void bcQ() {
        new BdAsyncTask<Void, Void, ArrayList<com.baidu.tbadk.core.bigday.a>>() { // from class: com.baidu.tbadk.core.bigday.b.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: e */
            public ArrayList<com.baidu.tbadk.core.bigday.a> doInBackground(Void... voidArr) {
                byte[] bArr;
                ArrayList<com.baidu.tbadk.core.bigday.a> arrayList = new ArrayList<>();
                l<byte[]> zS = com.baidu.tbadk.core.c.a.bhV().zS("tb.bigday_datas");
                if (zS != null && (bArr = zS.get("tb.bigday_datas")) != null) {
                    try {
                        GetBigdayResIdl getBigdayResIdl = (GetBigdayResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBigdayResIdl.class);
                        if (getBigdayResIdl.data != null) {
                            for (BigdayInfo bigdayInfo : getBigdayResIdl.data.bigday_list) {
                                if (bigdayInfo != null) {
                                    com.baidu.tbadk.core.bigday.a aVar = new com.baidu.tbadk.core.bigday.a();
                                    aVar.a(bigdayInfo);
                                    if (aVar.bcN()) {
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
            /* renamed from: B */
            public void onPostExecute(ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
                super.onPostExecute(arrayList);
                if (arrayList != null) {
                    b.this.y(arrayList);
                }
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
        if (!y.isEmpty(arrayList) && !this.dXw) {
            this.dXs = c(arrayList, 1);
            this.dXt = c(arrayList, 3);
            this.dXv = arrayList;
            bcR();
            if (this.dXs != null && d.AR(this.dXs.imgUrl) && SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bjf().getLong("key_bigday_next_showtime_home", 0L)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.dXs));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
        com.baidu.tbadk.core.bigday.a c = c(arrayList, 1);
        com.baidu.tbadk.core.bigday.a c2 = c(arrayList, 3);
        A(arrayList);
        this.dXv = arrayList;
        if (c != null && c.bcN()) {
            this.dXs = c;
        }
        if (c2 != null && c2.bcN()) {
            this.dXt = c2;
        }
        bcR();
        if (this.dXs != null && d.AR(this.dXs.imgUrl) && SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bjf().getLong("key_bigday_next_showtime_home", 0L)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.dXs));
        }
    }

    private void bcR() {
        if (!y.isEmpty(this.dXv)) {
            Iterator<com.baidu.tbadk.core.bigday.a> it = this.dXv.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.bigday.a next = it.next();
                if (!d.AR(next.imgUrl)) {
                    c.mR().a(next.imgUrl, 41, null, this.mTag);
                }
            }
        }
    }

    private void A(ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        y.addAll(arrayList2, 0, arrayList);
        y.add(arrayList2, this.dXs);
        y.add(arrayList2, this.dXt);
        a aVar = new a(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, null, DiskFileOperate.Action.DELETE_FILES, arrayList2);
        aVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        aVar.setSdCard(false);
        aVar.setSavedCache(true);
        com.baidu.adp.lib.Disk.d.lK().c(aVar);
    }

    private com.baidu.tbadk.core.bigday.a c(List<com.baidu.tbadk.core.bigday.a> list, int i) {
        if (!y.isEmpty(list)) {
            Iterator<com.baidu.tbadk.core.bigday.a> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.core.bigday.a next = it.next();
                if (next.bcN() && next.dXr == i) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (next.startTime > currentTimeMillis) {
                        this.dXu.put(i, Long.valueOf(next.startTime));
                        break;
                    } else if (next.endTime >= currentTimeMillis) {
                        return next;
                    }
                }
            }
        }
        return null;
    }

    public com.baidu.tbadk.core.bigday.a mY(int i) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (i == 1) {
            if (this.dXs == null && this.dXu.get(i, 0L).longValue() != 0 && this.dXu.get(i, 0L).longValue() < currentTimeMillis) {
                this.dXs = c(this.dXv, 1);
            }
            if (this.dXs != null && (currentTimeMillis < this.dXs.startTime || currentTimeMillis > this.dXs.endTime)) {
                this.dXs = c(this.dXv, 1);
            }
            if (this.dXs != null && d.AR(this.dXs.imgUrl)) {
                return this.dXs;
            }
        } else if (i == 3) {
            if (this.dXt == null && this.dXu.get(i, 0L).longValue() != 0 && this.dXu.get(i, 0L).longValue() < currentTimeMillis) {
                this.dXs = c(this.dXv, 3);
            }
            if (this.dXt != null && (currentTimeMillis < this.dXt.startTime || currentTimeMillis > this.dXt.endTime)) {
                this.dXt = c(this.dXv, 3);
            }
            if (this.dXt != null && d.AR(this.dXt.imgUrl)) {
                return this.dXt;
            }
        }
        return null;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.dRa);
    }

    public void hO(boolean z) {
        this.dXx = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends DiskFileOperate implements com.baidu.adp.lib.Disk.a {
        private ArrayList<String> dXA;

        public a(String str, String str2, DiskFileOperate.Action action, ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
            super(str, str2, action);
            this.dXA = new ArrayList<>();
            Iterator<com.baidu.tbadk.core.bigday.a> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.bigday.a next = it.next();
                if (next != null) {
                    String genCacheKey = c.mR().genCacheKey(next.imgUrl, 41);
                    if (!StringUtils.isNULL(genCacheKey)) {
                        String nameMd5FromUrl = av.getNameMd5FromUrl(genCacheKey);
                        if (!StringUtils.isNULL(nameMd5FromUrl)) {
                            this.dXA.add(nameMd5FromUrl);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.adp.lib.Disk.a
        public boolean compare(File file) {
            return (file == null || StringUtils.isNULL(file.getName()) || this.dXA.contains(file.getName())) ? false : true;
        }
    }
}
