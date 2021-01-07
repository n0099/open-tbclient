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
/* loaded from: classes11.dex */
public class b extends ac {
    private static volatile b bgG;
    private x aMh;
    private ArrayList<g> bcC;
    private ArrayList<com.baidu.live.gift.a.c> bgH;
    private List<com.baidu.live.gift.c> bgI;
    private Map<String, com.baidu.live.gift.a.b> bgJ;
    public Map<String, com.baidu.live.gift.a.d> bgK;
    private boolean bgL;
    private com.baidu.live.gift.giftList.b bgM;
    private com.baidu.live.gift.giftList.c bgN;
    private com.baidu.live.p.c bgO;
    private c bgP;
    private com.baidu.live.gift.d.c bgQ;
    private String bgS;
    private boolean bgR = false;
    private c.a bgT = new c.a() { // from class: com.baidu.live.gift.c.b.1
        @Override // com.baidu.live.gift.c.c.a
        public void b(int i, String str, int i2, Object obj, long j) {
            b.this.a(i, str, i2, obj, j);
        }
    };
    private b.a bgU = new b.a() { // from class: com.baidu.live.gift.c.b.2
        @Override // com.baidu.live.gift.giftList.b.a
        public void n(ArrayList<com.baidu.live.gift.c> arrayList) {
            b.this.bgI.clear();
            if (!ListUtils.isEmpty(arrayList)) {
                b.this.bgI.addAll(arrayList);
                if (b.this.bgR) {
                    b.this.HV();
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
                    Set entrySet = b.this.bgJ.entrySet();
                    if (!entrySet.isEmpty()) {
                        if (b.this.bgP != null && !b.this.bgP.mIsSending && (entry = (Map.Entry) entrySet.iterator().next()) != null) {
                            b.this.bgP.a((com.baidu.live.gift.a.b) b.this.bgJ.remove(entry.getKey()));
                        }
                        b.this.mHandler.sendEmptyMessage(100);
                        break;
                    } else {
                        return true;
                    }
                    break;
                case 200:
                    if (b.this.bgK != null && !b.this.bgK.isEmpty()) {
                        if (!b.this.bgL && (next = b.this.bgK.entrySet().iterator().next()) != null) {
                            b.this.a(b.this.bgK.remove(next.getKey()));
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
    private CustomMessageListener bgV = new CustomMessageListener(2913238) { // from class: com.baidu.live.gift.c.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null) {
                w.aZw = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private CustomMessageListener bgW = new CustomMessageListener(2913234) { // from class: com.baidu.live.gift.c.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long) && ((Long) customResponsedMessage.getData()).longValue() == -1) {
                w.aZw = false;
            }
        }
    };
    private CustomMessageListener bgX = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.c.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.i.c cVar;
            g hc;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.i.c) && !ListUtils.isEmpty(b.this.bgH) && (cVar = (com.baidu.live.i.c) customResponsedMessage.getData()) != null && cVar.aVK != null && cVar.aVJ == 5) {
                String id = cVar.aVK.getId();
                ArrayList arrayList = new ArrayList();
                Iterator it = b.this.bgH.iterator();
                while (it.hasNext()) {
                    com.baidu.live.gift.a.c cVar2 = (com.baidu.live.gift.a.c) it.next();
                    if (!TextUtils.isEmpty(cVar2.giftId) && cVar2.giftId.equals(id) && (hc = ac.hc(cVar2.giftId)) != null) {
                        arrayList.add(cVar2);
                        com.baidu.live.im.data.c cVar3 = new com.baidu.live.im.data.c();
                        cVar3.giftId = cVar2.giftId;
                        cVar3.aYv = cVar2.beC;
                        cVar3.giftName = hc.Gy();
                        cVar3.aYy = hc.getThumbnail_url();
                        cVar3.beQ = "";
                        cVar3.isDynamic = false;
                        cVar3.beA = cVar2.beA;
                        cVar3.beB = cVar2.beB;
                        com.baidu.live.data.a aVar = new com.baidu.live.data.a();
                        aVar.userId = cVar2.userId;
                        aVar.portrait = cVar2.portrait;
                        aVar.userName = cVar2.userName;
                        ac.b(cVar3, aVar, "", "", false, "", "", false, true, "", "", -1L);
                    }
                }
                b.this.bgH.removeAll(arrayList);
                com.baidu.live.gift.c hA = b.this.hA(id);
                if (hA != null && hA.aXb != null && hA.aXb.aWY != null) {
                    v.gz(hA.aXb.aWY.zipName);
                }
            }
        }
    };

    public static b JW() {
        if (bgG == null) {
            synchronized (b.class) {
                if (bgG == null) {
                    bgG = new b();
                }
            }
        }
        return bgG;
    }

    private b() {
        a((ac) this);
        this.bgI = Collections.synchronizedList(new ArrayList());
        this.bcC = new ArrayList<>();
        this.bgJ = new HashMap();
    }

    @Override // com.baidu.live.gift.ac
    protected x HR() {
        return this.aMh;
    }

    @Override // com.baidu.live.gift.ac
    protected void setLiveShowData(x xVar) {
        this.aMh = xVar;
    }

    @Override // com.baidu.live.gift.ac
    protected String HS() {
        return this.bgS;
    }

    @Override // com.baidu.live.gift.ac
    protected void gT(String str) {
        this.bgS = str;
    }

    @Override // com.baidu.live.gift.ac
    public void a(BdPageContext bdPageContext, boolean z, boolean z2) {
        MessageManager.getInstance().registerListener(this.bgX);
        MessageManager.getInstance().registerListener(this.bgV);
        MessageManager.getInstance().registerListener(this.bgW);
        if (this.bgN == null) {
            this.bgN = new com.baidu.live.gift.giftList.c(bdPageContext);
        }
        if (this.bgM == null) {
            this.bgM = new com.baidu.live.gift.giftList.b(bdPageContext);
            this.bgM.a(this.bgU);
        }
        this.bgM.bY(z2);
        g(z, null);
        if (this.bgP == null) {
            this.bgP = new c(bdPageContext);
            this.bgP.setUniqueId(BdUniqueId.gen());
        }
        this.bgP.initListener();
        this.bgP.a(this.bgT);
        if (this.bgO == null) {
            this.bgO = new com.baidu.live.p.c();
        }
        this.bgO.initListener();
        this.bgO.refreshCurUserScores();
    }

    @Override // com.baidu.live.gift.ac
    protected void HT() {
        if (AlaLiveSwitchData.isHotLive == 0) {
            this.bgN.a(q.XG(), true, "enter", "gift_init");
        }
    }

    private void g(boolean z, String str) {
        this.bgM.setHost(z);
        this.bgM.hz(str);
    }

    @Override // com.baidu.live.gift.ac
    public String HU() {
        return q.XG();
    }

    @Override // com.baidu.live.gift.ac
    protected void HE() {
        a.JV().HE();
    }

    @Override // com.baidu.live.gift.ac
    protected void gY(String str) {
        if (!TextUtils.isEmpty(str) && this.bgI != null && !this.bgI.isEmpty()) {
            for (com.baidu.live.gift.c cVar : this.bgI) {
                if (cVar != null && cVar.aXb != null && cVar.aXb.aWY != null && str.equals(cVar.aXb.aWY.zipName)) {
                    cVar.videoPath = null;
                    cVar.unZipFilesPathList = null;
                    return;
                }
            }
        }
    }

    public void e(String str, ArrayList<h> arrayList) {
        if (!ListUtils.isEmpty(arrayList)) {
            if (this.bcC == null) {
                this.bcC = new ArrayList<>();
            }
            Iterator<h> it = arrayList.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (!ListUtils.isEmpty(next.Hb())) {
                    c(str, next.Hb());
                }
            }
        }
    }

    private void c(String str, List<g> list) {
        boolean z;
        if (!ListUtils.isEmpty(list)) {
            for (g gVar : list) {
                Iterator<g> it = this.bcC.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    g next = it.next();
                    if (next != null && !TextUtils.isEmpty(next.Gx()) && next.Gx().equals(gVar.Gx())) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    gVar.setSceneFrom(str);
                    this.bcC.add(gVar);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.ac
    public boolean gX(String str) {
        if (StringUtils.isNull(str) || ListUtils.isEmpty(this.bgI)) {
            return false;
        }
        for (int i = 0; i < this.bgI.size(); i++) {
            if (str.equals(this.bgI.get(i).getDynamicGiftId())) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.live.gift.c hA(String str) {
        if (!StringUtils.isNull(str) && !ListUtils.isEmpty(this.bgI)) {
            boolean z = UtilHelper.getRealScreenOrientation(TbadkCoreApplication.getInst().getContext()) == 2;
            for (int i = 0; i < this.bgI.size(); i++) {
                com.baidu.live.gift.c cVar = this.bgI.get(i);
                if (str.equals(cVar.getDynamicGiftId()) && z == cVar.isLandScapeZip()) {
                    return cVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.live.gift.ac
    protected String gU(String str) {
        com.baidu.live.gift.c hA = JW().hA(str);
        if (hA == null || hA.aXb == null || hA.aXb.aWY == null) {
            return null;
        }
        return (com.baidu.live.alphavideo.a.CC().CD() && hA.aXb.Gb()) ? hA.aXb.aWY.videoUrl : hA.aXb.aWY.zipDownloadUrl;
    }

    @Override // com.baidu.live.gift.ac
    public boolean gV(String str) {
        com.baidu.live.gift.c hA;
        if (StringUtils.isNull(str) || (hA = hA(str)) == null || hA.aXb == null) {
            return false;
        }
        if (com.baidu.live.alphavideo.a.CC().CD() && hA.aXb.Gb() && !TextUtils.isEmpty(hA.Ge())) {
            return true;
        }
        return ListUtils.isEmpty(hA.getDynamicGiftPicPathList()) ? false : true;
    }

    @Override // com.baidu.live.gift.ac
    protected boolean gW(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return a.JV().au(str, gU(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, Object obj, long j) {
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            if (i >= 0) {
                if (this.bgJ != null && this.bgJ.size() == 0) {
                    if (i == 0) {
                        if (i2 == 1 || i2 == 3) {
                            TbadkCoreApplication.getInst().currentAccountTdouNum = ((Long) obj).longValue();
                        } else {
                            TbadkCoreApplication.getInst().currentAccountFlowerNum = ((Long) obj).longValue();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                    } else if (this.bgO != null) {
                        this.bgO.refreshCurUserScores();
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
            if (gVar.GK()) {
                TiebaInitialize.log(new StatisticItem("c12792").param("obj_id", gVar.Gx()).param("obj_param1", gVar.GB()).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, gV(gVar.Gx()) ? 1 : 0));
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
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(gVar.Gx(), j, gVar, currentAccountInfo.getID(), currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), str3, "", false, str, str4, j2);
        cVar.bez = currentAccountInfo.getLiveLevel();
        cVar.sex = currentAccountInfo.getSex();
        cVar.description = "";
        cVar.userStatus = -1;
        cVar.aYz = j3;
        cVar.aP(System.currentTimeMillis());
        cVar.bew = true;
        cVar.beA = gVar.GS();
        a(gVar.Gx(), j, currentAccountInfo.getID(), currentAccountInfo.getAccountNameShow(), currentAccountInfo.getPortrait(), j2, false, false, gVar.GS(), new JSONObject(), "");
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
        if (this.bgP != null) {
            com.baidu.live.gift.a.b bVar = new com.baidu.live.gift.a.b(gVar, j, str, str2, str3, str4, str5, str6, gVar.getThumbnail_url(), j2);
            bVar.aYC = bdUniqueId;
            if (j == 1) {
                bVar.aZB = 0;
            } else {
                bVar.aZB = 1;
            }
            bVar.bev.put(Long.valueOf(j2), Long.valueOf(j));
            if (this.bgP.mIsSending || !this.bgJ.isEmpty()) {
                String l = l(str3, str, gVar.Gx(), String.valueOf(j));
                com.baidu.live.gift.a.b bVar2 = this.bgJ.get(l);
                if (bVar2 == null) {
                    this.bgJ.put(l, bVar);
                } else {
                    bVar2.bev.put(Long.valueOf(j2), Long.valueOf(j));
                    bVar2.bes += j;
                }
                this.mHandler.sendEmptyMessage(100);
                return;
            }
            this.bgP.a(bVar);
        }
    }

    @Override // com.baidu.live.gift.ac
    public g gS(String str) {
        if (TextUtils.isEmpty(str) || this.bcC == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.bcC.size()) {
                return null;
            }
            g gVar = this.bcC.get(i2);
            if (!str.equals(gVar.Gx())) {
                i = i2 + 1;
            } else {
                return gVar;
            }
        }
    }

    @Override // com.baidu.live.gift.ac
    public void a(com.baidu.live.im.data.c cVar, com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3, String str4, boolean z2, boolean z3, String str5, String str6, long j) {
        String str7 = cVar.giftId;
        long j2 = cVar.aYv;
        String str8 = cVar.giftName;
        String str9 = cVar.aYy;
        String str10 = cVar.beQ;
        if (!TextUtils.isEmpty(cVar.bqE) && !TextUtils.isEmpty(cVar.bqG)) {
            str10 = cVar.bqE;
        }
        boolean z4 = cVar.isDynamic;
        boolean z5 = cVar.beA;
        String str11 = aVar.userId;
        String str12 = aVar.portrait;
        String nameShow = aVar.getNameShow();
        JSONObject jSONObject = cVar.beB;
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
            a(str7, j2, str11, nameShow, str12, j, z, z4, z5, jSONObject, cVar.beN);
            g gS = gS(str7);
            if (gS == null) {
                String sharedPrefKeyWithAccount = com.baidu.live.d.getSharedPrefKeyWithAccount("last_send_get_gift_list_time");
                if (System.currentTimeMillis() - com.baidu.live.d.Ba().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                    com.baidu.live.d.Ba().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                }
                gS = new g();
                gS.gH(str7);
                gS.setGiftName(str8);
                gS.gI("" + j2);
                gS.setThumbnailUrl(str9);
                BdResourceLoader.getInstance().loadResource(gS.getThumbnail_url(), 10, null, BdUniqueId.gen());
            }
            com.baidu.live.gift.a.c cVar2 = new com.baidu.live.gift.a.c(str7, j2, gS, str11, str12, nameShow, str, str2, z, str3, str4, j, z5, jSONObject);
            cVar2.aP(System.currentTimeMillis());
            cVar2.bew = false;
            cVar2.bW(z3);
            cVar2.chatMCastId = str5;
            cVar2.ensureMCastId = str6;
            cVar2.beN = cVar.beN;
            if (com.baidu.live.af.a.SE().bwi.aNw && !TextUtils.isEmpty(str10)) {
                k kVar = new k();
                if (kVar.gJ(str10)) {
                    cVar2.bex.aXM = kVar;
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
        String str7 = cVar.bqG;
        String str8 = (TextUtils.isEmpty(cVar.bqE) || TextUtils.isEmpty(cVar.bqG)) ? cVar.beQ : cVar.bqE;
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
                            g gS = gS(optString);
                            if (gS == null) {
                                String sharedPrefKeyWithAccount = com.baidu.live.d.getSharedPrefKeyWithAccount("last_send_get_gift_list_time");
                                if (System.currentTimeMillis() - com.baidu.live.d.Ba().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                                    com.baidu.live.d.Ba().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                                }
                                gS = new g();
                                gS.gH(optString);
                                gS.setGiftName(optString2);
                                gS.setThumbnailUrl(optString3);
                                BdResourceLoader.getInstance().loadResource(gS.getThumbnail_url(), 10, null, BdUniqueId.gen());
                            }
                            arrayList.add(gS);
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
                com.baidu.live.gift.a.c cVar2 = new com.baidu.live.gift.a.c(gVar.Gx(), j3, gVar, str9, str10, nameShow, str, str2, z, str3, str4, j);
                cVar2.aP(System.currentTimeMillis());
                cVar2.bew = false;
                cVar2.bW(true);
                cVar2.chatMCastId = str5;
                cVar2.ensureMCastId = str6;
                cVar2.beN = cVar.beN;
                if (com.baidu.live.af.a.SE().bwi.aNw && !TextUtils.isEmpty(str8)) {
                    k kVar = new k();
                    if (kVar.gJ(str8)) {
                        cVar2.bex.aXM = kVar;
                    }
                }
                if (arrayList.size() >= 2) {
                    w.a(j, gVar.Gx(), str9, nameShow, j3, j2);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar2));
            }
        }
    }

    @Override // com.baidu.live.gift.ac
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        g gVar = new g();
        gVar.gH(str);
        gVar.setGiftName(str2);
        gVar.gI("" + j);
        gVar.setThumbnailUrl(str3);
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2);
        cVar.aP(System.currentTimeMillis());
        cVar.bew = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bW(z3);
        cVar.beI = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    @Override // com.baidu.live.gift.ac
    protected void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        g gVar = new g();
        gVar.gH(str);
        gVar.setGiftName(str2);
        gVar.gI("" + j);
        gVar.setThumbnailUrl(str3);
        a(str, j, str4, str6, str5, j2, z, false, false, (JSONObject) null, "");
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2);
        cVar.aP(System.currentTimeMillis());
        cVar.bew = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bW(z3);
        cVar.beI = false;
        cVar.beJ = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    @Override // com.baidu.live.gift.ac
    protected void gZ(String str) {
        if (this.bgQ == null) {
            this.bgQ = new com.baidu.live.gift.d.a();
        }
        this.bgQ.hB(str);
    }

    @Override // com.baidu.live.gift.ac
    protected void a(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        com.baidu.live.gift.a.d dVar = new com.baidu.live.gift.a.d(str, str2, str3, str4, i, i2, str5, System.currentTimeMillis());
        if (this.bgL || (this.bgK != null && !this.bgK.isEmpty())) {
            if (this.bgK == null) {
                this.bgK = new HashMap();
            }
            String b2 = b(str4, str3, str, i);
            com.baidu.live.gift.a.d dVar2 = this.bgK.get(b2);
            if (dVar2 == null) {
                this.bgK.put(b2, dVar);
            } else {
                dVar2.beP += i;
            }
            this.mHandler.sendEmptyMessage(200);
            return;
        }
        a(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.gift.a.d dVar) {
        if (dVar != null) {
            this.bgL = true;
            if (this.bgQ == null) {
                this.bgQ = new com.baidu.live.gift.d.a();
                this.bgQ.a(new com.baidu.live.gift.d.b() { // from class: com.baidu.live.gift.c.b.4
                    @Override // com.baidu.live.gift.d.b, com.baidu.live.gift.d.c.a
                    public void a(boolean z, int i, String str, String str2, int i2) {
                        super.a(z, i, str, str2, i2);
                        b.this.bgL = false;
                    }
                });
            }
            this.bgQ.b(dVar);
        }
    }

    private void a(String str, long j, String str2, String str3, String str4, long j2, boolean z, boolean z2, boolean z3, JSONObject jSONObject, String str5) {
        if (gX(str)) {
            if (!he(str)) {
                if (this.bgH == null) {
                    this.bgH = new ArrayList<>();
                }
                com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, null, str2, str4, str3, "", "", false, "", "", j2, z3, jSONObject);
                cVar.beN = str5;
                this.bgH.add(cVar);
                com.baidu.live.gift.c hA = JW().hA(str);
                if (hA != null) {
                    a.JV().a(hA.aXb, true);
                }
            }
        } else if (z2) {
            g(z, str);
        }
    }

    @Override // com.baidu.live.gift.ac
    public void HV() {
        if (ListUtils.isEmpty(this.bgI)) {
            this.bgR = true;
            return;
        }
        for (com.baidu.live.gift.c cVar : this.bgI) {
            if (cVar != null && cVar.aXb != null && !JW().gV(cVar.getDynamicGiftId())) {
                com.baidu.live.gift.b bVar = cVar.aXb;
                if (bVar.aWY != null) {
                    a.JV().a(bVar, false);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.ac
    protected com.baidu.live.gift.c ha(String str) {
        if (!TextUtils.isEmpty(str) && !ListUtils.isEmpty(this.bgI)) {
            for (com.baidu.live.gift.c cVar : this.bgI) {
                if (cVar.aXb != null && cVar.aXb.aWY != null && str.equals(cVar.aXb.aWY.zipName)) {
                    return cVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.live.gift.ac
    public void onDestroy() {
        this.bgR = false;
        MessageManager.getInstance().unRegisterListener(this.bgX);
        MessageManager.getInstance().unRegisterListener(this.bgV);
        MessageManager.getInstance().unRegisterListener(this.bgW);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bgP != null) {
            this.bgP.onDestroy();
            this.bgP = null;
        }
        if (this.bgM != null) {
            this.bgM.onDestroy();
            this.bgM = null;
        }
        if (this.bgN != null) {
            this.bgN.onDestroy();
            this.bgN = null;
        }
        if (this.bgO != null) {
            this.bgO.onDestroy();
            this.bgO = null;
        }
        if (this.bgQ != null) {
            this.bgQ.release();
            this.bgQ = null;
        }
        if (this.bgH != null) {
            this.bgH.clear();
        }
        HE();
        this.bcC.clear();
        this.bgI.clear();
        this.aMh = null;
        this.bgS = null;
        this.bgL = false;
        if (this.bgK != null) {
            this.bgK.clear();
        }
    }
}
