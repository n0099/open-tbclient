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
import com.baidu.tbadk.core.util.d.d;
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
    private static b cHX = null;
    private com.baidu.tbadk.core.bigday.a cHR;
    private com.baidu.tbadk.core.bigday.a cHS;
    private SparseArray<Long> cHT;
    private ArrayList<com.baidu.tbadk.core.bigday.a> cHU;
    private BdUniqueId mTag;
    private boolean cHV = false;
    private boolean cHW = true;
    private com.baidu.adp.framework.listener.a cDZ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_BIGDAY_INFO, 309609) { // from class: com.baidu.tbadk.core.bigday.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && !responsedMessage.hasError()) {
                b.this.cHV = true;
                ArrayList<com.baidu.tbadk.core.bigday.a> arrayList = null;
                if (responsedMessage instanceof GetBigdayInfoSocketResMessage) {
                    arrayList = ((GetBigdayInfoSocketResMessage) responsedMessage).bigdayInfos;
                } else if (responsedMessage instanceof GetBigdayInfoHttpResMessage) {
                    arrayList = ((GetBigdayInfoHttpResMessage) responsedMessage).bigdayInfos;
                }
                b.this.r(arrayList);
            }
        }
    };

    private b() {
        com.baidu.tieba.tbadkCore.a.a.a(309609, GetBigdayInfoSocketResMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309609, CmdConfigHttp.CMD_GET_BIGDAY_INFO, "c/s/getBigday", GetBigdayInfoHttpResMessage.class, false, false, true, false);
        MessageManager.getInstance().registerListener(this.cDZ);
        this.cHT = new SparseArray<>();
    }

    public static b axG() {
        if (cHX == null) {
            cHX = new b();
        }
        return cHX;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void axH() {
        this.cHV = false;
        GetBigdayInfoReqMessage getBigdayInfoReqMessage = new GetBigdayInfoReqMessage();
        getBigdayInfoReqMessage.setTag(this.mTag);
        MessageManager.getInstance().sendMessage(getBigdayInfoReqMessage);
    }

    public void axI() {
        new BdAsyncTask<Void, Void, ArrayList<com.baidu.tbadk.core.bigday.a>>() { // from class: com.baidu.tbadk.core.bigday.b.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: e */
            public ArrayList<com.baidu.tbadk.core.bigday.a> doInBackground(Void... voidArr) {
                byte[] bArr;
                ArrayList<com.baidu.tbadk.core.bigday.a> arrayList = new ArrayList<>();
                l<byte[]> sz = com.baidu.tbadk.core.c.a.aCo().sz("tb.bigday_datas");
                if (sz != null && (bArr = sz.get("tb.bigday_datas")) != null) {
                    try {
                        GetBigdayResIdl getBigdayResIdl = (GetBigdayResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBigdayResIdl.class);
                        if (getBigdayResIdl.data != null) {
                            for (BigdayInfo bigdayInfo : getBigdayResIdl.data.bigday_list) {
                                if (bigdayInfo != null) {
                                    com.baidu.tbadk.core.bigday.a aVar = new com.baidu.tbadk.core.bigday.a();
                                    aVar.a(bigdayInfo);
                                    if (aVar.axF()) {
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
                    b.this.q(arrayList);
                }
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
        if (!v.isEmpty(arrayList) && !this.cHV) {
            this.cHR = c(arrayList, 1);
            this.cHS = c(arrayList, 3);
            this.cHU = arrayList;
            axJ();
            if (this.cHR != null && d.tu(this.cHR.imgUrl) && SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aDr().getLong("key_bigday_next_showtime_home", 0L)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.cHR));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
        com.baidu.tbadk.core.bigday.a c = c(arrayList, 1);
        com.baidu.tbadk.core.bigday.a c2 = c(arrayList, 3);
        s(arrayList);
        this.cHU = arrayList;
        if (c != null && c.axF()) {
            this.cHR = c;
        }
        if (c2 != null && c2.axF()) {
            this.cHS = c2;
        }
        axJ();
        if (this.cHR != null && d.tu(this.cHR.imgUrl) && SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.aDr().getLong("key_bigday_next_showtime_home", 0L)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.cHR));
        }
    }

    private void axJ() {
        if (!v.isEmpty(this.cHU)) {
            Iterator<com.baidu.tbadk.core.bigday.a> it = this.cHU.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.bigday.a next = it.next();
                if (!d.tu(next.imgUrl)) {
                    c.gr().a(next.imgUrl, 41, null, this.mTag);
                }
            }
        }
    }

    private void s(ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        v.addAll(arrayList2, 0, arrayList);
        v.add(arrayList2, this.cHR);
        v.add(arrayList2, this.cHS);
        a aVar = new a(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, null, DiskFileOperate.Action.DELETE_FILES, arrayList2);
        aVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        aVar.setSdCard(false);
        aVar.setSavedCache(true);
        com.baidu.adp.lib.Disk.d.fj().c(aVar);
    }

    private com.baidu.tbadk.core.bigday.a c(List<com.baidu.tbadk.core.bigday.a> list, int i) {
        if (!v.isEmpty(list)) {
            Iterator<com.baidu.tbadk.core.bigday.a> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.core.bigday.a next = it.next();
                if (next.axF() && next.cHQ == i) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (next.startTime > currentTimeMillis) {
                        this.cHT.put(i, Long.valueOf(next.startTime));
                        break;
                    } else if (next.endTime >= currentTimeMillis) {
                        return next;
                    }
                }
            }
        }
        return null;
    }

    public com.baidu.tbadk.core.bigday.a jb(int i) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (i == 1) {
            if (this.cHR == null && this.cHT.get(i, 0L).longValue() != 0 && this.cHT.get(i, 0L).longValue() < currentTimeMillis) {
                this.cHR = c(this.cHU, 1);
            }
            if (this.cHR != null && (currentTimeMillis < this.cHR.startTime || currentTimeMillis > this.cHR.endTime)) {
                this.cHR = c(this.cHU, 1);
            }
            if (this.cHR != null && d.tu(this.cHR.imgUrl)) {
                return this.cHR;
            }
        } else if (i == 3) {
            if (this.cHS == null && this.cHT.get(i, 0L).longValue() != 0 && this.cHT.get(i, 0L).longValue() < currentTimeMillis) {
                this.cHR = c(this.cHU, 3);
            }
            if (this.cHS != null && (currentTimeMillis < this.cHS.startTime || currentTimeMillis > this.cHS.endTime)) {
                this.cHS = c(this.cHU, 3);
            }
            if (this.cHS != null && d.tu(this.cHS.imgUrl)) {
                return this.cHS;
            }
        }
        return null;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.cDZ);
    }

    public void fm(boolean z) {
        this.cHW = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends DiskFileOperate implements com.baidu.adp.lib.Disk.a {
        private ArrayList<String> cHZ;

        public a(String str, String str2, DiskFileOperate.Action action, ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
            super(str, str2, action);
            this.cHZ = new ArrayList<>();
            Iterator<com.baidu.tbadk.core.bigday.a> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.bigday.a next = it.next();
                if (next != null) {
                    String genCacheKey = c.gr().genCacheKey(next.imgUrl, 41);
                    if (!StringUtils.isNULL(genCacheKey)) {
                        String nameMd5FromUrl = as.getNameMd5FromUrl(genCacheKey);
                        if (!StringUtils.isNULL(nameMd5FromUrl)) {
                            this.cHZ.add(nameMd5FromUrl);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.adp.lib.Disk.a
        public boolean compare(File file) {
            return (file == null || StringUtils.isNULL(file.getName()) || this.cHZ.contains(file.getName())) ? false : true;
        }
    }
}
