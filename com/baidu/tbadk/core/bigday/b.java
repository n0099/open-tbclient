package com.baidu.tbadk.core.bigday;

import android.util.SparseArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.e.d;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.d.c;
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
    private static b eMN = null;
    private com.baidu.tbadk.core.bigday.a eMH;
    private com.baidu.tbadk.core.bigday.a eMI;
    private SparseArray<Long> eMJ;
    private ArrayList<com.baidu.tbadk.core.bigday.a> eMK;
    private BdUniqueId mTag;
    private boolean eML = false;
    private boolean eMM = true;
    private com.baidu.adp.framework.listener.a eFZ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_BIGDAY_INFO, 309609) { // from class: com.baidu.tbadk.core.bigday.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && !responsedMessage.hasError()) {
                b.this.eML = true;
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
        MessageManager.getInstance().registerListener(this.eFZ);
        this.eMJ = new SparseArray<>();
    }

    public static b boC() {
        if (eMN == null) {
            eMN = new b();
        }
        return eMN;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void boD() {
        this.eML = false;
        GetBigdayInfoReqMessage getBigdayInfoReqMessage = new GetBigdayInfoReqMessage();
        getBigdayInfoReqMessage.setTag(this.mTag);
        MessageManager.getInstance().sendMessage(getBigdayInfoReqMessage);
    }

    public void boE() {
        new BdAsyncTask<Void, Void, ArrayList<com.baidu.tbadk.core.bigday.a>>() { // from class: com.baidu.tbadk.core.bigday.b.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: f */
            public ArrayList<com.baidu.tbadk.core.bigday.a> doInBackground(Void... voidArr) {
                byte[] bArr;
                ArrayList<com.baidu.tbadk.core.bigday.a> arrayList = new ArrayList<>();
                l<byte[]> Bm = com.baidu.tbadk.core.c.a.btS().Bm("tb.bigday_datas");
                if (Bm != null && (bArr = Bm.get("tb.bigday_datas")) != null) {
                    try {
                        GetBigdayResIdl getBigdayResIdl = (GetBigdayResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBigdayResIdl.class);
                        if (getBigdayResIdl.data != null) {
                            for (BigdayInfo bigdayInfo : getBigdayResIdl.data.bigday_list) {
                                if (bigdayInfo != null) {
                                    com.baidu.tbadk.core.bigday.a aVar = new com.baidu.tbadk.core.bigday.a();
                                    aVar.a(bigdayInfo);
                                    if (aVar.boB()) {
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
        if (!x.isEmpty(arrayList) && !this.eML) {
            this.eMH = c(arrayList, 1);
            this.eMI = c(arrayList, 3);
            this.eMK = arrayList;
            boF();
            if (this.eMH != null && c.Cp(this.eMH.imgUrl) && SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bvq().getLong("key_bigday_next_showtime_home", 0L)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, this.eMH));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
        com.baidu.tbadk.core.bigday.a c = c(arrayList, 1);
        com.baidu.tbadk.core.bigday.a c2 = c(arrayList, 3);
        A(arrayList);
        this.eMK = arrayList;
        if (c != null && c.boB()) {
            this.eMH = c;
        }
        if (c2 != null && c2.boB()) {
            this.eMI = c2;
        }
        boF();
        if (this.eMH != null && c.Cp(this.eMH.imgUrl) && SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) == 1 && System.currentTimeMillis() > com.baidu.tbadk.core.sharedPref.b.bvq().getLong("key_bigday_next_showtime_home", 0L)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, this.eMH));
        }
    }

    private void boF() {
        if (!x.isEmpty(this.eMK)) {
            Iterator<com.baidu.tbadk.core.bigday.a> it = this.eMK.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.bigday.a next = it.next();
                if (!c.Cp(next.imgUrl)) {
                    d.mx().a(next.imgUrl, 41, null, this.mTag);
                }
            }
        }
    }

    private void A(ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        x.addAll(arrayList2, 0, arrayList);
        x.add(arrayList2, this.eMH);
        x.add(arrayList2, this.eMI);
        a aVar = new a(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, null, DiskFileOperate.Action.DELETE_FILES, arrayList2);
        aVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        aVar.setSdCard(false);
        aVar.setSavedCache(true);
        com.baidu.adp.lib.Disk.d.lh().c(aVar);
    }

    private com.baidu.tbadk.core.bigday.a c(List<com.baidu.tbadk.core.bigday.a> list, int i) {
        if (!x.isEmpty(list)) {
            Iterator<com.baidu.tbadk.core.bigday.a> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.tbadk.core.bigday.a next = it.next();
                if (next.boB() && next.eMG == i) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (next.startTime > currentTimeMillis) {
                        this.eMJ.put(i, Long.valueOf(next.startTime));
                        break;
                    } else if (next.endTime >= currentTimeMillis) {
                        return next;
                    }
                }
            }
        }
        return null;
    }

    public com.baidu.tbadk.core.bigday.a ou(int i) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (i == 1) {
            if (this.eMH == null && this.eMJ.get(i, 0L).longValue() != 0 && this.eMJ.get(i, 0L).longValue() < currentTimeMillis) {
                this.eMH = c(this.eMK, 1);
            }
            if (this.eMH != null && (currentTimeMillis < this.eMH.startTime || currentTimeMillis > this.eMH.endTime)) {
                this.eMH = c(this.eMK, 1);
            }
            if (this.eMH != null && c.Cp(this.eMH.imgUrl)) {
                return this.eMH;
            }
        } else if (i == 3) {
            if (this.eMI == null && this.eMJ.get(i, 0L).longValue() != 0 && this.eMJ.get(i, 0L).longValue() < currentTimeMillis) {
                this.eMH = c(this.eMK, 3);
            }
            if (this.eMI != null && (currentTimeMillis < this.eMI.startTime || currentTimeMillis > this.eMI.endTime)) {
                this.eMI = c(this.eMK, 3);
            }
            if (this.eMI != null && c.Cp(this.eMI.imgUrl)) {
                return this.eMI;
            }
        }
        return null;
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.eFZ);
    }

    public void jr(boolean z) {
        this.eMM = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends DiskFileOperate implements com.baidu.adp.lib.Disk.a {
        private ArrayList<String> eMP;

        public a(String str, String str2, DiskFileOperate.Action action, ArrayList<com.baidu.tbadk.core.bigday.a> arrayList) {
            super(str, str2, action);
            this.eMP = new ArrayList<>();
            Iterator<com.baidu.tbadk.core.bigday.a> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.bigday.a next = it.next();
                if (next != null) {
                    String genCacheKey = d.mx().genCacheKey(next.imgUrl, 41);
                    if (!StringUtils.isNULL(genCacheKey)) {
                        String nameMd5FromUrl = av.getNameMd5FromUrl(genCacheKey);
                        if (!StringUtils.isNULL(nameMd5FromUrl)) {
                            this.eMP.add(nameMd5FromUrl);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.adp.lib.Disk.a
        public boolean compare(File file) {
            return (file == null || StringUtils.isNULL(file.getName()) || this.eMP.contains(file.getName())) ? false : true;
        }
    }
}
