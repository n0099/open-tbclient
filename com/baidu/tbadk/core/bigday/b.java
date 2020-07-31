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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.c.d;
import com.baidu.tbadk.core.util.x;
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
    private static b dMb = null;
    private com.baidu.tbadk.core.bigday.a dLV;
    private com.baidu.tbadk.core.bigday.a dLW;
    private SparseArray<Long> dLX;
    private ArrayList<com.baidu.tbadk.core.bigday.a> dLY;
    private BdUniqueId mTag;
    private boolean dLZ = false;
    private boolean dMa = true;
    private com.baidu.adp.framework.listener.a dFJ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_BIGDAY_INFO, 309609) { // from class: com.baidu.tbadk.core.bigday.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && !responsedMessage.hasError()) {
                b.this.dLZ = true;
                ArrayList<com.baidu.tbadk.core.bigday.a> arrayList = null;
                if (responsedMessage instanceof GetBigdayInfoSocketResMessage) {
                    arrayList = ((GetBigdayInfoSocketResMessage) responsedMessage).bigdayInfos;
                } else if (responsedMessage instanceof GetBigdayInfoHttpResMessage) {
                    arrayList = ((GetBigdayInfoHttpResMessage) responsedMessage).bigdayInfos;
                }
                b.this.u(arrayList);
            }
        }
    };

    private b() {
        com.baidu.tieba.tbadkCore.a.a.a(309609, GetBigdayInfoSocketResMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309609, CmdConfigHttp.CMD_GET_BIGDAY_INFO, "c/s/getBigday", GetBigdayInfoHttpResMessage.class, false, false, true, false);
        MessageManager.getInstance().registerListener(this.dFJ);
        this.dLX = new SparseArray<>();
    }

    public static b aTD() {
        if (dMb == null) {
            dMb = new b();
        }
        return dMb;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void aTE() {
        this.dLZ = false;
        GetBigdayInfoReqMessage getBigdayInfoReqMessage = new GetBigdayInfoReqMessage();
        getBigdayInfoReqMessage.setTag(this.mTag);
        MessageManager.getInstance().sendMessage(getBigdayInfoReqMessage);
    }

    public void aTF() {
        new BdAsyncTask<Void, Void, ArrayList<com.baidu.tbadk.core.bigday.a>>() { // from class: com.baidu.tbadk.core.bigday.b.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: e */
            public ArrayList<com.baidu.tbadk.core.bigday.a> doInBackground(Void... voidArr) {
                byte[] bArr;
                ArrayList<com.baidu.tbadk.core.bigday.a> arrayList = new ArrayList<>();
                l<byte[]> xi = com.baidu.tbadk.core.c.a.aYG().xi("tb.bigday_datas");
                if (xi != null && (bArr = xi.get("tb.bigday_datas")) != null) {
                    try {
                        GetBigdayResIdl getBigdayResIdl = (GetBigdayResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBigdayResIdl.class);
                        if (getBigdayResIdl.data != null) {
                            for (BigdayInfo bigdayInfo : getBigdayResIdl.data.bigday_list) {
                                if (bigdayInfo != null) {
                                    com.baidu.tbadk.core.bigday.a aVar = new com.baidu.tbadk.core.bigday.a();
                                    aVar.a(bigdayInfo);
                                    if (aVar.aTC()) {
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
                    b.this.t(arrayList);
                }
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
        if (!x.isEmpty(arrayList) && !this.dLZ) {
            this.dLV = c(arrayList, 1);
            this.dLW = c(arrayList, 3);
            this.dLY = arrayList;
            aTG();
            if (this.dLV != null && d.yg(this.dLV.imgUrl) && SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aZP().getLong("key_bigday_next_showtime_home", 0L)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.dLV));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
        com.baidu.tbadk.core.bigday.a c = c(arrayList, 1);
        com.baidu.tbadk.core.bigday.a c2 = c(arrayList, 3);
        v(arrayList);
        this.dLY = arrayList;
        if (c != null && c.aTC()) {
            this.dLV = c;
        }
        if (c2 != null && c2.aTC()) {
            this.dLW = c2;
        }
        aTG();
        if (this.dLV != null && d.yg(this.dLV.imgUrl) && SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aZP().getLong("key_bigday_next_showtime_home", 0L)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.dLV));
        }
    }

    private void aTG() {
        if (!x.isEmpty(this.dLY)) {
            Iterator<com.baidu.tbadk.core.bigday.a> it = this.dLY.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.bigday.a next = it.next();
                if (!d.yg(next.imgUrl)) {
                    c.ln().a(next.imgUrl, 41, null, this.mTag);
                }
            }
        }
    }

    private void v(ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        x.addAll(arrayList2, 0, arrayList);
        x.add(arrayList2, this.dLV);
        x.add(arrayList2, this.dLW);
        a aVar = new a(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, null, DiskFileOperate.Action.DELETE_FILES, arrayList2);
        aVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        aVar.setSdCard(false);
        aVar.setSavedCache(true);
        com.baidu.adp.lib.Disk.d.kh().c(aVar);
    }

    private com.baidu.tbadk.core.bigday.a c(List<com.baidu.tbadk.core.bigday.a> list, int i) {
        if (!x.isEmpty(list)) {
            Iterator<com.baidu.tbadk.core.bigday.a> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.core.bigday.a next = it.next();
                if (next.aTC() && next.dLU == i) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (next.startTime > currentTimeMillis) {
                        this.dLX.put(i, Long.valueOf(next.startTime));
                        break;
                    } else if (next.endTime >= currentTimeMillis) {
                        return next;
                    }
                }
            }
        }
        return null;
    }

    public com.baidu.tbadk.core.bigday.a kH(int i) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (i == 1) {
            if (this.dLV == null && this.dLX.get(i, 0L).longValue() != 0 && this.dLX.get(i, 0L).longValue() < currentTimeMillis) {
                this.dLV = c(this.dLY, 1);
            }
            if (this.dLV != null && (currentTimeMillis < this.dLV.startTime || currentTimeMillis > this.dLV.endTime)) {
                this.dLV = c(this.dLY, 1);
            }
            if (this.dLV != null && d.yg(this.dLV.imgUrl)) {
                return this.dLV;
            }
        } else if (i == 3) {
            if (this.dLW == null && this.dLX.get(i, 0L).longValue() != 0 && this.dLX.get(i, 0L).longValue() < currentTimeMillis) {
                this.dLV = c(this.dLY, 3);
            }
            if (this.dLW != null && (currentTimeMillis < this.dLW.startTime || currentTimeMillis > this.dLW.endTime)) {
                this.dLW = c(this.dLY, 3);
            }
            if (this.dLW != null && d.yg(this.dLW.imgUrl)) {
                return this.dLW;
            }
        }
        return null;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.dFJ);
    }

    public void hu(boolean z) {
        this.dMa = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends DiskFileOperate implements com.baidu.adp.lib.Disk.a {
        private ArrayList<String> dMd;

        public a(String str, String str2, DiskFileOperate.Action action, ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
            super(str, str2, action);
            this.dMd = new ArrayList<>();
            Iterator<com.baidu.tbadk.core.bigday.a> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.bigday.a next = it.next();
                if (next != null) {
                    String genCacheKey = c.ln().genCacheKey(next.imgUrl, 41);
                    if (!StringUtils.isNULL(genCacheKey)) {
                        String nameMd5FromUrl = au.getNameMd5FromUrl(genCacheKey);
                        if (!StringUtils.isNULL(nameMd5FromUrl)) {
                            this.dMd.add(nameMd5FromUrl);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.adp.lib.Disk.a
        public boolean compare(File file) {
            return (file == null || StringUtils.isNULL(file.getName()) || this.dMd.contains(file.getName())) ? false : true;
        }
    }
}
