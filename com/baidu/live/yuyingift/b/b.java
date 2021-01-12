package com.baidu.live.yuyingift.b;

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
import com.baidu.live.d;
import com.baidu.live.data.x;
import com.baidu.live.gift.aj;
import com.baidu.live.gift.am;
import com.baidu.live.gift.g;
import com.baidu.live.gift.h;
import com.baidu.live.gift.k;
import com.baidu.live.gift.v;
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
import com.baidu.live.utils.m;
import com.baidu.live.utils.s;
import com.baidu.live.utils.t;
import com.baidu.live.yuyingift.c.c;
import com.baidu.live.yuyingift.giftlist.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends aj {
    private static volatile b bVC;
    private x aHu;
    private ArrayList<g> aXO;
    private LinkedHashMap<String, com.baidu.live.yuyingift.a.b> bVD;
    private com.baidu.live.yuyingift.giftlist.a bVE;
    private com.baidu.live.yuyingift.giftlist.b bVF;
    private c bVG;
    private com.baidu.live.yuyingift.c.b bVH;
    private ArrayList<com.baidu.live.gift.c> bbG;
    private ArrayList<com.baidu.live.yuyingift.a.c> bbQ;
    private com.baidu.live.p.c bbX;
    private String bcb;
    private boolean bca = false;
    private c.a bVI = new c.a() { // from class: com.baidu.live.yuyingift.b.b.1
        @Override // com.baidu.live.yuyingift.c.c.a
        public void b(int i, String str, int i2, Object obj, long j) {
            b.this.a(i, str, i2, obj, j);
        }
    };
    private a.InterfaceC0236a bVJ = new a.InterfaceC0236a() { // from class: com.baidu.live.yuyingift.b.b.2
        @Override // com.baidu.live.yuyingift.giftlist.a.InterfaceC0236a
        public void i(ArrayList<com.baidu.live.gift.c> arrayList) {
            b.this.bbG.clear();
            if (!ListUtils.isEmpty(arrayList)) {
                b.this.bbG.addAll(arrayList);
                if (b.this.bca) {
                    b.this.Ea();
                }
            }
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.yuyingift.b.b.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Map.Entry entry;
            if (message.what == 100) {
                Set entrySet = b.this.bVD.entrySet();
                if (entrySet.isEmpty()) {
                    return true;
                }
                if (b.this.bVG != null && !b.this.bVG.mIsSending && (entry = (Map.Entry) entrySet.iterator().next()) != null) {
                    com.baidu.live.yuyingift.a.b bVar = (com.baidu.live.yuyingift.a.b) entry.getValue();
                    if (bVar == null) {
                        return true;
                    }
                    if (((com.baidu.live.yuyingift.a.b) entry.getValue()).aZD > 0) {
                        b.this.bVG.a(bVar);
                    } else {
                        b.this.bVG.a(bVar.aKn, bVar.bUZ, bVar.bVa, bVar.liveId, bVar.bjV);
                    }
                    b.this.bVD.remove(entry.getKey());
                }
                b.this.mHandler.sendEmptyMessage(100);
            }
            return false;
        }
    });
    private CustomMessageListener bcg = new CustomMessageListener(2913078) { // from class: com.baidu.live.yuyingift.b.b.4
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
                    com.baidu.live.yuyingift.a.c cVar2 = (com.baidu.live.yuyingift.a.c) it.next();
                    if (!TextUtils.isEmpty(cVar2.giftId) && cVar2.giftId.equals(id) && (fQ = aj.fQ(cVar2.giftId)) != null) {
                        arrayList.add(cVar2);
                        b.this.a(cVar2.giftId, cVar2.aZM, fQ.CD(), fQ.getThumbnail_url(), cVar2.userId, cVar2.portrait, cVar2.userName, "", "", false, "", "", "", cVar2.chatMCastId, cVar2.ensureMCastId, cVar2.msgId, cVar2.bjV, false, cVar2.bVb, cVar2.aVd, cVar2.bVc, cVar2.bVd);
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

    public static b Xh() {
        if (bVC == null) {
            synchronized (b.class) {
                if (bVC == null) {
                    bVC = new b();
                }
            }
        }
        return bVC;
    }

    private b() {
        a((aj) this);
        this.bbG = new ArrayList<>();
        this.aXO = new ArrayList<>();
        this.bVD = new LinkedHashMap<>();
    }

    @Override // com.baidu.live.gift.aj
    protected x DW() {
        return this.aHu;
    }

    @Override // com.baidu.live.gift.aj
    protected void setLiveShowData(x xVar) {
        this.aHu = xVar;
    }

    @Override // com.baidu.live.gift.aj
    protected String DX() {
        return this.bcb;
    }

    @Override // com.baidu.live.gift.aj
    protected void fH(String str) {
        this.bcb = str;
    }

    @Override // com.baidu.live.gift.aj
    public void a(BdPageContext bdPageContext, boolean z, boolean z2) {
        MessageManager.getInstance().registerListener(this.bcg);
        if (this.bVF == null) {
            this.bVF = new com.baidu.live.yuyingift.giftlist.b(bdPageContext);
        }
        if (this.bVE == null) {
            this.bVE = new com.baidu.live.yuyingift.giftlist.a(bdPageContext);
            this.bVE.a(this.bVJ);
        }
        this.bVE.bU(z2);
        g(z, null);
        if (this.bVG == null) {
            this.bVG = new c(bdPageContext);
            this.bVG.setUniqueId(BdUniqueId.gen());
        }
        this.bVG.initListener();
        this.bVG.a(this.bVI);
        if (this.bbX == null) {
            this.bbX = new com.baidu.live.p.c();
        }
        this.bbX.initListener();
        this.bbX.refreshCurUserScores();
    }

    @Override // com.baidu.live.gift.aj
    public void DY() {
        if (AlaLiveSwitchData.isHotLive == 0) {
            this.bVF.a(t.TN(), true, "enter", "gift_init");
        }
    }

    private void g(boolean z, String str) {
        this.bVE.setHost(z);
        this.bVE.gn(str);
    }

    @Override // com.baidu.live.gift.aj
    public String DZ() {
        return t.TN();
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

    @Override // com.baidu.live.gift.aj
    public boolean fL(String str) {
        if (StringUtils.isNull(str) || ListUtils.isEmpty(this.bbG)) {
            return false;
        }
        for (int i = 0; i < this.bbG.size(); i++) {
            if (str.equals(this.bbG.get(i).getDynamicGiftId())) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.live.gift.c go(String str) {
        if (!StringUtils.isNull(str) && !ListUtils.isEmpty(this.bbG)) {
            boolean z = UtilHelper.getRealScreenOrientation(TbadkCoreApplication.getInst().getContext()) == 2;
            for (int i = 0; i < this.bbG.size(); i++) {
                com.baidu.live.gift.c cVar = this.bbG.get(i);
                if (str.equals(cVar.getDynamicGiftId()) && z == cVar.isLandScapeZip()) {
                    return cVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.live.gift.aj
    protected String fI(String str) {
        com.baidu.live.gift.c go = Xh().go(str);
        if (go == null || go.aSo == null || go.aSo.aSl == null) {
            return null;
        }
        return (com.baidu.live.alphavideo.a.yH().yI() && go.aSo.Cg()) ? go.aSo.aSl.videoUrl : go.aSo.aSl.zipDownloadUrl;
    }

    @Override // com.baidu.live.gift.aj
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

    @Override // com.baidu.live.gift.aj
    protected boolean fK(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return am.Em().at(str, fI(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, Object obj, long j) {
        if (i2 == 1 || i2 == 2) {
            if (i >= 0) {
                if (this.bVD != null && this.bVD.size() == 0) {
                    if (i == 0) {
                        if (i2 == 1) {
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

    public void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, long j3, String str8, long j4, int i) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), TbadkCoreApplication.getInst().getContext().getResources().getString(a.h.sdk_no_network_guide));
        } else if (gVar != null) {
            if (gVar.CP()) {
                TiebaInitialize.log(new StatisticItem("c12792").param("obj_id", gVar.CC()).param("obj_param1", gVar.CG()).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, fJ(gVar.CC()) ? 1 : 0));
            }
            a(gVar, j, str, str2, str3, str5, j2, j3, str8, j4, i);
        }
    }

    public void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, String str8, long j3, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        a(gVar, j, str, str2, str3, str4, str5, str6, str7, j2, currentTimeMillis, str8, j3, i);
        a(gVar, j, str, str2, str3, str4, str6, str7, currentTimeMillis, str8, gVar.CF() ? 1 : 0, j3, i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4, long j2, long j3, String str5, long j4, int i) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(gVar.CC(), j, gVar, currentAccountInfo.getID(), currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), currentAccountInfo.getLiveLevel(), currentAccountInfo.getSex(), "", -1, str3, "", false, str, str4, j2, str5, j4);
        cVar.bVb = gVar.CF();
        cVar.bVc = i;
        cVar.aTM = j3;
        cVar.aP(System.currentTimeMillis());
        cVar.aZG = true;
        com.baidu.live.yuyingift.b.f(cVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, long j2, String str7, int i, long j3, int i2) {
        if (this.bVG != null) {
            com.baidu.live.yuyingift.a.b bVar = new com.baidu.live.yuyingift.a.b(gVar, j, str, str2, str3, str4, str5, str6, gVar.getThumbnail_url(), j2, str7, i, j3, i2);
            if (j == 1) {
                bVar.aUO = 0;
            } else {
                bVar.aUO = 1;
            }
            bVar.aZF.put(Long.valueOf(j2), Long.valueOf(j));
            if (this.bVG.mIsSending || !this.bVD.isEmpty()) {
                String a2 = s.a(j3, gVar.CC(), str, str7);
                com.baidu.live.yuyingift.a.b bVar2 = this.bVD.get(a2);
                if (bVar2 == null) {
                    this.bVD.put(a2, bVar);
                } else {
                    bVar2.aZF.put(Long.valueOf(j2), Long.valueOf(j));
                    bVar2.aZD += j;
                }
                this.mHandler.sendEmptyMessage(100);
                return;
            }
            this.bVG.a(bVar);
        }
    }

    public void a(long j, int i, String str, String str2, String str3) {
        if (this.bVG.mIsSending) {
            if (j > 0) {
                String valueOf = String.valueOf(j);
                com.baidu.live.yuyingift.a.b bVar = new com.baidu.live.yuyingift.a.b();
                bVar.aZD = -1L;
                bVar.aKn = str;
                bVar.liveId = str2;
                bVar.bUZ = j;
                bVar.bjV = str3;
                this.bVD.put(valueOf, bVar);
                this.mHandler.sendEmptyMessage(100);
            }
        } else if (this.bVG != null) {
            this.bVG.a(str, j, i, str2, str3);
        }
    }

    @Override // com.baidu.live.gift.aj
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

    @Override // com.baidu.live.gift.aj
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2, String str14, boolean z2, boolean z3, long j3, int i, boolean z4) {
        a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, true, true, str12, str13, j2, str14, z2, z3, j3, i, z4);
    }

    public void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, String str12, String str13, long j2, String str14, boolean z4, boolean z5, long j3, int i, boolean z6) {
        if (StringUtils.isNull(str4)) {
            if (z) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, str12, str13, str, "userId 为空");
            }
        } else if (!z2 || !str4.equals(TbadkCoreApplication.getCurrentAccount())) {
            a(str, j, str4, str6, str5, j2, str14, z, z4);
            g fG = fG(str);
            if (fG == null) {
                String sharedPrefKeyWithAccount = d.getSharedPrefKeyWithAccount("last_send_get_gift_list_time_yuyin");
                if (System.currentTimeMillis() - d.xf().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                    d.xf().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                }
                fG = new g();
                fG.fv(str);
                fG.setGiftName(str2);
                fG.fw("" + j);
                fG.setThumbnailUrl(str3);
                BdResourceLoader.getInstance().loadResource(fG.getThumbnail_url(), 10, null, BdUniqueId.gen());
            }
            com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(str, j, fG, str4, str5, str6, str7, str8, z, str9, str10, j2, str14, j3);
            cVar.aP(System.currentTimeMillis());
            cVar.aZG = false;
            cVar.bS(z3);
            cVar.chatMCastId = str12;
            cVar.ensureMCastId = str13;
            cVar.bVb = z5;
            cVar.bVc = i;
            cVar.bVd = z6;
            if (com.baidu.live.af.a.OJ().bru.aIJ && !TextUtils.isEmpty(str11)) {
                k kVar = new k();
                if (kVar.fx(str11)) {
                    cVar.aZH.aSZ = kVar;
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
        }
    }

    @Override // com.baidu.live.gift.aj
    protected void a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j, String str12) {
        long j2;
        if (!StringUtils.isNull(str2) && !str2.equals(TbadkCoreApplication.getCurrentAccount())) {
            long j3 = 0;
            long j4 = 0;
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray != null && jSONArray.length() > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= jSONArray.length()) {
                            break;
                        }
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        String optString = jSONObject.optString(LogConfig.LOG_GIFT_ID);
                        String optString2 = jSONObject.optString("gift_name");
                        long optLong = jSONObject.optLong("gift_count");
                        String optString3 = jSONObject.optString("gift_url");
                        j3 += optLong;
                        j4 += jSONObject.optLong("charm_value");
                        g fG = fG(optString);
                        if (fG == null) {
                            String sharedPrefKeyWithAccount = d.getSharedPrefKeyWithAccount("last_send_get_gift_list_time_yuyin");
                            if (System.currentTimeMillis() - d.xf().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                                d.xf().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                            }
                            fG = new g();
                            fG.fv(optString);
                            fG.setGiftName(optString2);
                            fG.setThumbnailUrl(optString3);
                            BdResourceLoader.getInstance().loadResource(fG.getThumbnail_url(), 10, null, BdUniqueId.gen());
                        }
                        arrayList.add(fG);
                        i = i2 + 1;
                    }
                }
                j2 = j4;
            } catch (JSONException e) {
                e.printStackTrace();
                j2 = j4;
            }
            if (!ListUtils.isEmpty(arrayList)) {
                g gVar = (g) arrayList.get(0);
                com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(gVar.CC(), j3, gVar, str2, str3, str4, str5, str6, z, str7, str8, j, str12, 0L);
                cVar.aP(System.currentTimeMillis());
                cVar.aZG = false;
                cVar.bS(true);
                cVar.chatMCastId = str10;
                cVar.ensureMCastId = str11;
                if (com.baidu.live.af.a.OJ().bru.aIJ && !TextUtils.isEmpty(str9)) {
                    k kVar = new k();
                    if (kVar.fx(str9)) {
                        cVar.aZH.aSZ = kVar;
                    }
                }
                if (arrayList.size() >= 2) {
                    com.baidu.live.yuyingift.b.a(j, gVar.CC(), str2, str4, j3, j2, str12);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
            }
        }
    }

    @Override // com.baidu.live.gift.aj
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12) {
        g gVar = new g();
        gVar.fv(str);
        gVar.setGiftName(str2);
        gVar.fw("" + j);
        gVar.setThumbnailUrl(str3);
        com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2, str12, 0L);
        cVar.aP(System.currentTimeMillis());
        cVar.aZG = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bS(z3);
        cVar.aZS = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
    }

    @Override // com.baidu.live.gift.aj
    protected void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12) {
        g gVar = new g();
        gVar.fv(str);
        gVar.setGiftName(str2);
        gVar.fw("" + j);
        gVar.setThumbnailUrl(str3);
        a(str, j, str4, str6, str5, j2, str12, z, false);
        com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2, str12, 0L);
        cVar.aP(System.currentTimeMillis());
        cVar.aZG = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bS(z3);
        cVar.aZS = false;
        cVar.aZT = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
    }

    @Override // com.baidu.live.gift.aj
    protected void fN(String str) {
        if (this.bVH == null) {
            this.bVH = new com.baidu.live.yuyingift.c.d();
        }
        this.bVH.gp(str);
    }

    @Override // com.baidu.live.gift.aj
    protected void a(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6, int i3, long j) {
        if (this.bVH == null) {
            this.bVH = new com.baidu.live.yuyingift.c.d();
        }
        this.bVH.a(str, str2, str3, str4, 1, 0, "", str6, System.currentTimeMillis(), i3, j);
    }

    private void a(String str, long j, String str2, String str3, String str4, long j2, String str5, boolean z, boolean z2) {
        if (fL(str)) {
            if (!fS(str)) {
                if (BdNetTypeUtil.isWifiNet() || !m.TI()) {
                    if (this.bbQ == null) {
                        this.bbQ = new ArrayList<>();
                    }
                    this.bbQ.add(new com.baidu.live.yuyingift.a.c(str, j, null, str2, str4, str3, "", "", false, "", "", j2, str5, 0L));
                    com.baidu.live.gift.c go = Xh().go(str);
                    if (go != null) {
                        am.Em().a(go.aSo, false);
                    }
                }
            }
        } else if (z2) {
            g(z, str);
        }
    }

    @Override // com.baidu.live.gift.aj
    public void Ea() {
        if (ListUtils.isEmpty(this.bbG)) {
            this.bca = true;
            return;
        }
        Iterator<com.baidu.live.gift.c> it = this.bbG.iterator();
        while (it.hasNext()) {
            com.baidu.live.gift.c next = it.next();
            if (next != null && next.aSo != null && !Xh().fJ(next.getDynamicGiftId())) {
                com.baidu.live.gift.b bVar = next.aSo;
                if (bVar.aSl != null) {
                    am.Em().a(bVar, false);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.aj
    public void onDestroy() {
        this.bca = false;
        MessageManager.getInstance().unRegisterListener(this.bcg);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bVG != null) {
            this.bVG.onDestroy();
            this.bVG = null;
        }
        if (this.bVE != null) {
            this.bVE.onDestroy();
            this.bVE = null;
        }
        if (this.bVF != null) {
            this.bVF.onDestroy();
            this.bVF = null;
        }
        if (this.bbX != null) {
            this.bbX.onDestroy();
            this.bbX = null;
        }
        if (this.bVH != null) {
            this.bVH.release();
            this.bVH = null;
        }
        if (this.bbQ != null) {
            this.bbQ.clear();
        }
        am.Em().DJ();
        this.aXO.clear();
        this.bbG.clear();
        this.aHu = null;
        this.bcb = null;
    }
}
