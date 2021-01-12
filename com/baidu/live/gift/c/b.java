package com.baidu.live.gift.c;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.resourceloader.BdResourceLoader;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.x;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.c.c;
import com.baidu.live.gift.g;
import com.baidu.live.gift.giftList.b;
import com.baidu.live.gift.h;
import com.baidu.live.gift.k;
import com.baidu.live.gift.v;
import com.baidu.live.gift.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.utils.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends ac {
    private static volatile b bbP;
    private x aHu;
    private ArrayList<g> aXO;
    private ArrayList<com.baidu.live.gift.a.c> bbQ;
    private List<com.baidu.live.gift.c> bbR;
    private Map<String, com.baidu.live.gift.a.b> bbS;
    public Map<String, com.baidu.live.gift.a.d> bbT;
    private boolean bbU;
    private com.baidu.live.gift.giftList.b bbV;
    private com.baidu.live.gift.giftList.c bbW;
    private com.baidu.live.p.c bbX;
    private c bbY;
    private com.baidu.live.gift.d.c bbZ;
    private String bcb;
    private boolean bca = false;
    private c.a bcc = new c.a() { // from class: com.baidu.live.gift.c.b.1
        @Override // com.baidu.live.gift.c.c.a
        public void b(int i, String str, int i2, Object obj, long j) {
            b.this.a(i, str, i2, obj, j);
        }
    };
    private b.a bcd = new b.a() { // from class: com.baidu.live.gift.c.b.2
        @Override // com.baidu.live.gift.giftList.b.a
        public void i(ArrayList<com.baidu.live.gift.c> arrayList) {
            b.this.bbR.clear();
            if (!ListUtils.isEmpty(arrayList)) {
                b.this.bbR.addAll(arrayList);
                if (b.this.bca) {
                    b.this.Ea();
                }
            }
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.c.b.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Map.Entry<String, com.baidu.live.gift.a.d> next;
            Map.Entry entry;
            switch (message.what) {
                case 100:
                    Set entrySet = b.this.bbS.entrySet();
                    if (!entrySet.isEmpty()) {
                        if (b.this.bbY != null && !b.this.bbY.mIsSending && (entry = (Map.Entry) entrySet.iterator().next()) != null) {
                            b.this.bbY.a((com.baidu.live.gift.a.b) b.this.bbS.remove(entry.getKey()));
                        }
                        b.this.mHandler.sendEmptyMessage(100);
                        break;
                    } else {
                        return true;
                    }
                    break;
                case 200:
                    if (b.this.bbT != null && !b.this.bbT.isEmpty()) {
                        if (!b.this.bbU && (next = b.this.bbT.entrySet().iterator().next()) != null) {
                            b.this.a(b.this.bbT.remove(next.getKey()));
                        }
                        b.this.mHandler.sendEmptyMessage(200);
                        break;
                    } else {
                        return true;
                    }
                    break;
            }
            return false;
        }
    });
    private CustomMessageListener bce = new CustomMessageListener(2913238) { // from class: com.baidu.live.gift.c.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null) {
                w.aUJ = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private CustomMessageListener bcf = new CustomMessageListener(2913234) { // from class: com.baidu.live.gift.c.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long) && ((Long) customResponsedMessage.getData()).longValue() == -1) {
                w.aUJ = false;
            }
        }
    };
    private CustomMessageListener bcg = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.c.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.i.c cVar;
            g fQ;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.i.c) && !ListUtils.isEmpty(b.this.bbQ) && (cVar = (com.baidu.live.i.c) customResponsedMessage.getData()) != null && cVar.aQX != null && cVar.aQW == 5) {
                String id = cVar.aQX.getId();
                ArrayList arrayList = new ArrayList();
                Iterator it = b.this.bbQ.iterator();
                while (it.hasNext()) {
                    com.baidu.live.gift.a.c cVar2 = (com.baidu.live.gift.a.c) it.next();
                    if (!TextUtils.isEmpty(cVar2.giftId) && cVar2.giftId.equals(id) && (fQ = ac.fQ(cVar2.giftId)) != null) {
                        arrayList.add(cVar2);
                        com.baidu.live.im.data.c cVar3 = new com.baidu.live.im.data.c();
                        cVar3.giftId = cVar2.giftId;
                        cVar3.aTI = cVar2.aZM;
                        cVar3.giftName = fQ.CD();
                        cVar3.aTL = fQ.getThumbnail_url();
                        cVar3.baa = "";
                        cVar3.isDynamic = false;
                        cVar3.aZK = cVar2.aZK;
                        cVar3.aZL = cVar2.aZL;
                        com.baidu.live.data.a aVar = new com.baidu.live.data.a();
                        aVar.userId = cVar2.userId;
                        aVar.portrait = cVar2.portrait;
                        aVar.userName = cVar2.userName;
                        ac.b(cVar3, aVar, "", "", false, "", "", false, true, "", "", -1L);
                    }
                }
                b.this.bbQ.removeAll(arrayList);
                com.baidu.live.gift.c go = b.this.go(id);
                if (go != null && go.aSo != null && go.aSo.aSl != null) {
                    v.fn(go.aSo.aSl.zipName);
                }
            }
        }
    };

    public static b Gb() {
        if (bbP == null) {
            synchronized (b.class) {
                if (bbP == null) {
                    bbP = new b();
                }
            }
        }
        return bbP;
    }

    private b() {
        a((ac) this);
        this.bbR = Collections.synchronizedList(new ArrayList());
        this.aXO = new ArrayList<>();
        this.bbS = new HashMap();
    }

    @Override // com.baidu.live.gift.ac
    protected x DW() {
        return this.aHu;
    }

    @Override // com.baidu.live.gift.ac
    protected void setLiveShowData(x xVar) {
        this.aHu = xVar;
    }

    @Override // com.baidu.live.gift.ac
    protected String DX() {
        return this.bcb;
    }

    @Override // com.baidu.live.gift.ac
    protected void fH(String str) {
        this.bcb = str;
    }

    @Override // com.baidu.live.gift.ac
    public void a(BdPageContext bdPageContext, boolean z, boolean z2) {
        MessageManager.getInstance().registerListener(this.bcg);
        MessageManager.getInstance().registerListener(this.bce);
        MessageManager.getInstance().registerListener(this.bcf);
        if (this.bbW == null) {
            this.bbW = new com.baidu.live.gift.giftList.c(bdPageContext);
        }
        if (this.bbV == null) {
            this.bbV = new com.baidu.live.gift.giftList.b(bdPageContext);
            this.bbV.a(this.bcd);
        }
        this.bbV.bU(z2);
        g(z, null);
        if (this.bbY == null) {
            this.bbY = new c(bdPageContext);
            this.bbY.setUniqueId(BdUniqueId.gen());
        }
        this.bbY.initListener();
        this.bbY.a(this.bcc);
        if (this.bbX == null) {
            this.bbX = new com.baidu.live.p.c();
        }
        this.bbX.initListener();
        this.bbX.refreshCurUserScores();
    }

    @Override // com.baidu.live.gift.ac
    protected void DY() {
        if (AlaLiveSwitchData.isHotLive == 0) {
            this.bbW.a(q.TN(), true, "enter", "gift_init");
        }
    }

    private void g(boolean z, String str) {
        this.bbV.setHost(z);
        this.bbV.gn(str);
    }

    @Override // com.baidu.live.gift.ac
    public String DZ() {
        return q.TN();
    }

    @Override // com.baidu.live.gift.ac
    protected void DJ() {
        a.Ga().DJ();
    }

    @Override // com.baidu.live.gift.ac
    protected void fM(String str) {
        if (!TextUtils.isEmpty(str) && this.bbR != null && !this.bbR.isEmpty()) {
            for (com.baidu.live.gift.c cVar : this.bbR) {
                if (cVar != null && cVar.aSo != null && cVar.aSo.aSl != null && str.equals(cVar.aSo.aSl.zipName)) {
                    cVar.videoPath = null;
                    cVar.unZipFilesPathList = null;
                    return;
                }
            }
        }
    }

    public void e(String str, ArrayList<h> arrayList) {
        if (!ListUtils.isEmpty(arrayList)) {
            if (this.aXO == null) {
                this.aXO = new ArrayList<>();
            }
            Iterator<h> it = arrayList.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (!ListUtils.isEmpty(next.Dg())) {
                    c(str, next.Dg());
                }
            }
        }
    }

    private void c(String str, List<g> list) {
        boolean z;
        if (!ListUtils.isEmpty(list)) {
            for (g gVar : list) {
                Iterator<g> it = this.aXO.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    g next = it.next();
                    if (next != null && !TextUtils.isEmpty(next.CC()) && next.CC().equals(gVar.CC())) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    gVar.setSceneFrom(str);
                    this.aXO.add(gVar);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.ac
    public boolean fL(String str) {
        if (StringUtils.isNull(str) || ListUtils.isEmpty(this.bbR)) {
            return false;
        }
        for (int i = 0; i < this.bbR.size(); i++) {
            if (str.equals(this.bbR.get(i).getDynamicGiftId())) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.live.gift.c go(String str) {
        if (!StringUtils.isNull(str) && !ListUtils.isEmpty(this.bbR)) {
            boolean z = UtilHelper.getRealScreenOrientation(TbadkCoreApplication.getInst().getContext()) == 2;
            for (int i = 0; i < this.bbR.size(); i++) {
                com.baidu.live.gift.c cVar = this.bbR.get(i);
                if (str.equals(cVar.getDynamicGiftId()) && z == cVar.isLandScapeZip()) {
                    return cVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.live.gift.ac
    protected String fI(String str) {
        com.baidu.live.gift.c go = Gb().go(str);
        if (go == null || go.aSo == null || go.aSo.aSl == null) {
            return null;
        }
        return (com.baidu.live.alphavideo.a.yH().yI() && go.aSo.Cg()) ? go.aSo.aSl.videoUrl : go.aSo.aSl.zipDownloadUrl;
    }

    @Override // com.baidu.live.gift.ac
    public boolean fJ(String str) {
        com.baidu.live.gift.c go;
        if (StringUtils.isNull(str) || (go = go(str)) == null || go.aSo == null) {
            return false;
        }
        if (com.baidu.live.alphavideo.a.yH().yI() && go.aSo.Cg() && !TextUtils.isEmpty(go.Cj())) {
            return true;
        }
        return ListUtils.isEmpty(go.getDynamicGiftPicPathList()) ? false : true;
    }

    @Override // com.baidu.live.gift.ac
    protected boolean fK(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return a.Ga().at(str, fI(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, Object obj, long j) {
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            if (i >= 0) {
                if (this.bbS != null && this.bbS.size() == 0) {
                    if (i == 0) {
                        if (i2 == 1 || i2 == 3) {
                            TbadkCoreApplication.getInst().currentAccountTdouNum = ((Long) obj).longValue();
                        } else {
                            TbadkCoreApplication.getInst().currentAccountFlowerNum = ((Long) obj).longValue();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                    } else if (this.bbX != null) {
                        this.bbX.refreshCurUserScores();
                    }
                }
                if (i == 0) {
                    if (i2 == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913126, Long.valueOf(j)));
                        return;
                    }
                    return;
                } else if (i == 2270014) {
                    Log.d("errCode", "GIFT_SEND_GIFT_ID_ERROR");
                    return;
                } else if (i == 2270005) {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), str);
                    return;
                } else {
                    BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), str);
                    return;
                }
            }
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), str);
        }
    }

    public void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, long j3) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), TbadkCoreApplication.getInst().getContext().getResources().getString(a.h.sdk_no_network_guide));
        } else if (gVar != null) {
            if (gVar.CP()) {
                TiebaInitialize.log(new StatisticItem("c12792").param("obj_id", gVar.CC()).param("obj_param1", gVar.CG()).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, fJ(gVar.CC()) ? 1 : 0));
            }
            a(gVar, j, str, str2, str3, str5, j2, j3);
        }
    }

    public void b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
        a(gVar, j, str, str2, str3, str4, str5, str6, str7, j2, (BdUniqueId) null);
    }

    @Override // com.baidu.live.gift.ac
    public void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, BdUniqueId bdUniqueId) {
        long currentTimeMillis = System.currentTimeMillis();
        a(gVar, j, str, str2, str3, str4, str5, str6, str7, j2, currentTimeMillis);
        a(gVar, j, str, str2, str3, str4, str6, str7, currentTimeMillis, bdUniqueId);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4, long j2, long j3) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(gVar.CC(), j, gVar, currentAccountInfo.getID(), currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), str3, "", false, str, str4, j2);
        cVar.aZJ = currentAccountInfo.getLiveLevel();
        cVar.sex = currentAccountInfo.getSex();
        cVar.description = "";
        cVar.userStatus = -1;
        cVar.aTM = j3;
        cVar.aP(System.currentTimeMillis());
        cVar.aZG = true;
        cVar.aZK = gVar.CX();
        a(gVar.CC(), j, currentAccountInfo.getID(), currentAccountInfo.getAccountNameShow(), currentAccountInfo.getPortrait(), j2, false, false, gVar.CX(), new JSONObject(), "");
        w.f(cVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    private String l(String str, String str2, String str3, String str4) {
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str4;
    }

    private String b(String str, String str2, String str3, int i) {
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i;
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, long j2, BdUniqueId bdUniqueId) {
        if (this.bbY != null) {
            com.baidu.live.gift.a.b bVar = new com.baidu.live.gift.a.b(gVar, j, str, str2, str3, str4, str5, str6, gVar.getThumbnail_url(), j2);
            bVar.aTP = bdUniqueId;
            if (j == 1) {
                bVar.aUO = 0;
            } else {
                bVar.aUO = 1;
            }
            bVar.aZF.put(Long.valueOf(j2), Long.valueOf(j));
            if (this.bbY.mIsSending || !this.bbS.isEmpty()) {
                String l = l(str3, str, gVar.CC(), String.valueOf(j));
                com.baidu.live.gift.a.b bVar2 = this.bbS.get(l);
                if (bVar2 == null) {
                    this.bbS.put(l, bVar);
                } else {
                    bVar2.aZF.put(Long.valueOf(j2), Long.valueOf(j));
                    bVar2.aZD += j;
                }
                this.mHandler.sendEmptyMessage(100);
                return;
            }
            this.bbY.a(bVar);
        }
    }

    @Override // com.baidu.live.gift.ac
    public g fG(String str) {
        if (TextUtils.isEmpty(str) || this.aXO == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.aXO.size()) {
                return null;
            }
            g gVar = this.aXO.get(i2);
            if (!str.equals(gVar.CC())) {
                i = i2 + 1;
            } else {
                return gVar;
            }
        }
    }

    @Override // com.baidu.live.gift.ac
    public void a(com.baidu.live.im.data.c cVar, com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3, String str4, boolean z2, boolean z3, String str5, String str6, long j) {
        String str7 = cVar.giftId;
        long j2 = cVar.aTI;
        String str8 = cVar.giftName;
        String str9 = cVar.aTL;
        String str10 = cVar.baa;
        if (!TextUtils.isEmpty(cVar.blR) && !TextUtils.isEmpty(cVar.blT)) {
            str10 = cVar.blR;
        }
        boolean z4 = cVar.isDynamic;
        boolean z5 = cVar.aZK;
        String str11 = aVar.userId;
        String str12 = aVar.portrait;
        String nameShow = aVar.getNameShow();
        JSONObject jSONObject = cVar.aZL;
        if (StringUtils.isNull(str11)) {
            if (z) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, str5, str6, str7, "userId 为空");
                return;
            }
            return;
        }
        boolean z6 = false;
        if (UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT.equals(jSONObject.optString("content_type")) && jSONObject != null && jSONObject.optInt("tying_status") == 1) {
            z6 = true;
        }
        if (!z2 || !str11.equals(TbadkCoreApplication.getCurrentAccount()) || z6) {
            a(str7, j2, str11, nameShow, str12, j, z, z4, z5, jSONObject, cVar.aZX);
            g fG = fG(str7);
            if (fG == null) {
                String sharedPrefKeyWithAccount = com.baidu.live.d.getSharedPrefKeyWithAccount("last_send_get_gift_list_time");
                if (System.currentTimeMillis() - com.baidu.live.d.xf().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                    com.baidu.live.d.xf().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                }
                fG = new g();
                fG.fv(str7);
                fG.setGiftName(str8);
                fG.fw("" + j2);
                fG.setThumbnailUrl(str9);
                BdResourceLoader.getInstance().loadResource(fG.getThumbnail_url(), 10, null, BdUniqueId.gen());
            }
            com.baidu.live.gift.a.c cVar2 = new com.baidu.live.gift.a.c(str7, j2, fG, str11, str12, nameShow, str, str2, z, str3, str4, j, z5, jSONObject);
            cVar2.aP(System.currentTimeMillis());
            cVar2.aZG = false;
            cVar2.bS(z3);
            cVar2.chatMCastId = str5;
            cVar2.ensureMCastId = str6;
            cVar2.aZX = cVar.aZX;
            if (com.baidu.live.af.a.OJ().bru.aIJ && !TextUtils.isEmpty(str10)) {
                k kVar = new k();
                if (kVar.fx(str10)) {
                    cVar2.aZH.aSZ = kVar;
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.live.gift.ac
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void a(com.baidu.live.im.data.c cVar, com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3, String str4, String str5, String str6, long j) {
        long j2;
        String str7 = cVar.blT;
        String str8 = (TextUtils.isEmpty(cVar.blR) || TextUtils.isEmpty(cVar.blT)) ? cVar.baa : cVar.blR;
        String str9 = aVar.userId;
        String str10 = aVar.portrait;
        String nameShow = aVar.getNameShow();
        if (!StringUtils.isNull(str9) && !str9.equals(TbadkCoreApplication.getCurrentAccount())) {
            long j3 = 0;
            long j4 = 0;
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(str7);
                if (jSONArray != null && jSONArray.length() > 0) {
                    int i = 0;
                    while (i < jSONArray.length()) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        String optString = jSONObject.optString(LogConfig.LOG_GIFT_ID);
                        String optString2 = jSONObject.optString("gift_name");
                        long optLong = jSONObject.optLong("gift_count");
                        String optString3 = jSONObject.optString("gift_url");
                        j3 += optLong;
                        j2 = jSONObject.optLong("charm_value") + j4;
                        try {
                            g fG = fG(optString);
                            if (fG == null) {
                                String sharedPrefKeyWithAccount = com.baidu.live.d.getSharedPrefKeyWithAccount("last_send_get_gift_list_time");
                                if (System.currentTimeMillis() - com.baidu.live.d.xf().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                                    com.baidu.live.d.xf().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                                }
                                fG = new g();
                                fG.fv(optString);
                                fG.setGiftName(optString2);
                                fG.setThumbnailUrl(optString3);
                                BdResourceLoader.getInstance().loadResource(fG.getThumbnail_url(), 10, null, BdUniqueId.gen());
                            }
                            arrayList.add(fG);
                            i++;
                            j4 = j2;
                        } catch (JSONException e) {
                            e = e;
                            e.printStackTrace();
                            if (ListUtils.isEmpty(arrayList)) {
                            }
                        }
                    }
                }
                j2 = j4;
            } catch (JSONException e2) {
                e = e2;
                j2 = j4;
            }
            if (ListUtils.isEmpty(arrayList)) {
                g gVar = (g) arrayList.get(0);
                com.baidu.live.gift.a.c cVar2 = new com.baidu.live.gift.a.c(gVar.CC(), j3, gVar, str9, str10, nameShow, str, str2, z, str3, str4, j);
                cVar2.aP(System.currentTimeMillis());
                cVar2.aZG = false;
                cVar2.bS(true);
                cVar2.chatMCastId = str5;
                cVar2.ensureMCastId = str6;
                cVar2.aZX = cVar.aZX;
                if (com.baidu.live.af.a.OJ().bru.aIJ && !TextUtils.isEmpty(str8)) {
                    k kVar = new k();
                    if (kVar.fx(str8)) {
                        cVar2.aZH.aSZ = kVar;
                    }
                }
                if (arrayList.size() >= 2) {
                    w.a(j, gVar.CC(), str9, nameShow, j3, j2);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar2));
            }
        }
    }

    @Override // com.baidu.live.gift.ac
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        g gVar = new g();
        gVar.fv(str);
        gVar.setGiftName(str2);
        gVar.fw("" + j);
        gVar.setThumbnailUrl(str3);
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2);
        cVar.aP(System.currentTimeMillis());
        cVar.aZG = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bS(z3);
        cVar.aZS = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    @Override // com.baidu.live.gift.ac
    protected void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        g gVar = new g();
        gVar.fv(str);
        gVar.setGiftName(str2);
        gVar.fw("" + j);
        gVar.setThumbnailUrl(str3);
        a(str, j, str4, str6, str5, j2, z, false, false, (JSONObject) null, "");
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2);
        cVar.aP(System.currentTimeMillis());
        cVar.aZG = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bS(z3);
        cVar.aZS = false;
        cVar.aZT = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    @Override // com.baidu.live.gift.ac
    protected void fN(String str) {
        if (this.bbZ == null) {
            this.bbZ = new com.baidu.live.gift.d.a();
        }
        this.bbZ.gp(str);
    }

    @Override // com.baidu.live.gift.ac
    protected void a(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        com.baidu.live.gift.a.d dVar = new com.baidu.live.gift.a.d(str, str2, str3, str4, i, i2, str5, System.currentTimeMillis());
        if (this.bbU || (this.bbT != null && !this.bbT.isEmpty())) {
            if (this.bbT == null) {
                this.bbT = new HashMap();
            }
            String b2 = b(str4, str3, str, i);
            com.baidu.live.gift.a.d dVar2 = this.bbT.get(b2);
            if (dVar2 == null) {
                this.bbT.put(b2, dVar);
            } else {
                dVar2.aZZ += i;
            }
            this.mHandler.sendEmptyMessage(200);
            return;
        }
        a(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.gift.a.d dVar) {
        if (dVar != null) {
            this.bbU = true;
            if (this.bbZ == null) {
                this.bbZ = new com.baidu.live.gift.d.a();
                this.bbZ.a(new com.baidu.live.gift.d.b() { // from class: com.baidu.live.gift.c.b.4
                    @Override // com.baidu.live.gift.d.b, com.baidu.live.gift.d.c.a
                    public void a(boolean z, int i, String str, String str2, int i2) {
                        super.a(z, i, str, str2, i2);
                        b.this.bbU = false;
                    }
                });
            }
            this.bbZ.b(dVar);
        }
    }

    private void a(String str, long j, String str2, String str3, String str4, long j2, boolean z, boolean z2, boolean z3, JSONObject jSONObject, String str5) {
        if (fL(str)) {
            if (!fS(str)) {
                if (this.bbQ == null) {
                    this.bbQ = new ArrayList<>();
                }
                com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, null, str2, str4, str3, "", "", false, "", "", j2, z3, jSONObject);
                cVar.aZX = str5;
                this.bbQ.add(cVar);
                com.baidu.live.gift.c go = Gb().go(str);
                if (go != null) {
                    a.Ga().a(go.aSo, true);
                }
            }
        } else if (z2) {
            g(z, str);
        }
    }

    @Override // com.baidu.live.gift.ac
    public void Ea() {
        if (ListUtils.isEmpty(this.bbR)) {
            this.bca = true;
            return;
        }
        for (com.baidu.live.gift.c cVar : this.bbR) {
            if (cVar != null && cVar.aSo != null && !Gb().fJ(cVar.getDynamicGiftId())) {
                com.baidu.live.gift.b bVar = cVar.aSo;
                if (bVar.aSl != null) {
                    a.Ga().a(bVar, false);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.ac
    protected com.baidu.live.gift.c fO(String str) {
        if (!TextUtils.isEmpty(str) && !ListUtils.isEmpty(this.bbR)) {
            for (com.baidu.live.gift.c cVar : this.bbR) {
                if (cVar.aSo != null && cVar.aSo.aSl != null && str.equals(cVar.aSo.aSl.zipName)) {
                    return cVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.live.gift.ac
    public void onDestroy() {
        this.bca = false;
        MessageManager.getInstance().unRegisterListener(this.bcg);
        MessageManager.getInstance().unRegisterListener(this.bce);
        MessageManager.getInstance().unRegisterListener(this.bcf);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bbY != null) {
            this.bbY.onDestroy();
            this.bbY = null;
        }
        if (this.bbV != null) {
            this.bbV.onDestroy();
            this.bbV = null;
        }
        if (this.bbW != null) {
            this.bbW.onDestroy();
            this.bbW = null;
        }
        if (this.bbX != null) {
            this.bbX.onDestroy();
            this.bbX = null;
        }
        if (this.bbZ != null) {
            this.bbZ.release();
            this.bbZ = null;
        }
        if (this.bbQ != null) {
            this.bbQ.clear();
        }
        DJ();
        this.aXO.clear();
        this.bbR.clear();
        this.aHu = null;
        this.bcb = null;
        this.bbU = false;
        if (this.bbT != null) {
            this.bbT.clear();
        }
    }
}
