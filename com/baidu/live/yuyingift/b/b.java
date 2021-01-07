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
import com.baidu.live.yuyingift.a.c;
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
/* loaded from: classes11.dex */
public class b extends aj {
    private static volatile b cao;
    private x aMh;
    private ArrayList<g> bcC;
    private ArrayList<c> bgH;
    private com.baidu.live.p.c bgO;
    private String bgS;
    private ArrayList<com.baidu.live.gift.c> bgx;
    private LinkedHashMap<String, com.baidu.live.yuyingift.a.b> cap;
    private com.baidu.live.yuyingift.giftlist.a caq;
    private com.baidu.live.yuyingift.giftlist.b car;
    private com.baidu.live.yuyingift.c.c cas;
    private com.baidu.live.yuyingift.c.b cat;
    private boolean bgR = false;
    private c.a cau = new c.a() { // from class: com.baidu.live.yuyingift.b.b.1
        @Override // com.baidu.live.yuyingift.c.c.a
        public void b(int i, String str, int i2, Object obj, long j) {
            b.this.a(i, str, i2, obj, j);
        }
    };
    private a.InterfaceC0245a cav = new a.InterfaceC0245a() { // from class: com.baidu.live.yuyingift.b.b.2
        @Override // com.baidu.live.yuyingift.giftlist.a.InterfaceC0245a
        public void n(ArrayList<com.baidu.live.gift.c> arrayList) {
            b.this.bgx.clear();
            if (!ListUtils.isEmpty(arrayList)) {
                b.this.bgx.addAll(arrayList);
                if (b.this.bgR) {
                    b.this.HV();
                }
            }
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.yuyingift.b.b.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Map.Entry entry;
            if (message.what == 100) {
                Set entrySet = b.this.cap.entrySet();
                if (entrySet.isEmpty()) {
                    return true;
                }
                if (b.this.cas != null && !b.this.cas.mIsSending && (entry = (Map.Entry) entrySet.iterator().next()) != null) {
                    com.baidu.live.yuyingift.a.b bVar = (com.baidu.live.yuyingift.a.b) entry.getValue();
                    if (bVar == null) {
                        return true;
                    }
                    if (((com.baidu.live.yuyingift.a.b) entry.getValue()).bes > 0) {
                        b.this.cas.a(bVar);
                    } else {
                        b.this.cas.a(bVar.aPa, bVar.bZL, bVar.bZM, bVar.liveId, bVar.boI);
                    }
                    b.this.cap.remove(entry.getKey());
                }
                b.this.mHandler.sendEmptyMessage(100);
            }
            return false;
        }
    });
    private CustomMessageListener bgX = new CustomMessageListener(2913078) { // from class: com.baidu.live.yuyingift.b.b.4
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
                    com.baidu.live.yuyingift.a.c cVar2 = (com.baidu.live.yuyingift.a.c) it.next();
                    if (!TextUtils.isEmpty(cVar2.giftId) && cVar2.giftId.equals(id) && (hc = aj.hc(cVar2.giftId)) != null) {
                        arrayList.add(cVar2);
                        b.this.a(cVar2.giftId, cVar2.beC, hc.Gy(), hc.getThumbnail_url(), cVar2.userId, cVar2.portrait, cVar2.userName, "", "", false, "", "", "", cVar2.chatMCastId, cVar2.ensureMCastId, cVar2.msgId, cVar2.boI, false, cVar2.bZN, cVar2.aZQ, cVar2.bZO, cVar2.bZP);
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

    public static b aba() {
        if (cao == null) {
            synchronized (b.class) {
                if (cao == null) {
                    cao = new b();
                }
            }
        }
        return cao;
    }

    private b() {
        a((aj) this);
        this.bgx = new ArrayList<>();
        this.bcC = new ArrayList<>();
        this.cap = new LinkedHashMap<>();
    }

    @Override // com.baidu.live.gift.aj
    protected x HR() {
        return this.aMh;
    }

    @Override // com.baidu.live.gift.aj
    protected void setLiveShowData(x xVar) {
        this.aMh = xVar;
    }

    @Override // com.baidu.live.gift.aj
    protected String HS() {
        return this.bgS;
    }

    @Override // com.baidu.live.gift.aj
    protected void gT(String str) {
        this.bgS = str;
    }

    @Override // com.baidu.live.gift.aj
    public void a(BdPageContext bdPageContext, boolean z, boolean z2) {
        MessageManager.getInstance().registerListener(this.bgX);
        if (this.car == null) {
            this.car = new com.baidu.live.yuyingift.giftlist.b(bdPageContext);
        }
        if (this.caq == null) {
            this.caq = new com.baidu.live.yuyingift.giftlist.a(bdPageContext);
            this.caq.a(this.cav);
        }
        this.caq.bY(z2);
        g(z, null);
        if (this.cas == null) {
            this.cas = new com.baidu.live.yuyingift.c.c(bdPageContext);
            this.cas.setUniqueId(BdUniqueId.gen());
        }
        this.cas.initListener();
        this.cas.a(this.cau);
        if (this.bgO == null) {
            this.bgO = new com.baidu.live.p.c();
        }
        this.bgO.initListener();
        this.bgO.refreshCurUserScores();
    }

    @Override // com.baidu.live.gift.aj
    public void HT() {
        if (AlaLiveSwitchData.isHotLive == 0) {
            this.car.a(t.XG(), true, "enter", "gift_init");
        }
    }

    private void g(boolean z, String str) {
        this.caq.setHost(z);
        this.caq.hz(str);
    }

    @Override // com.baidu.live.gift.aj
    public String HU() {
        return t.XG();
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

    @Override // com.baidu.live.gift.aj
    public boolean gX(String str) {
        if (StringUtils.isNull(str) || ListUtils.isEmpty(this.bgx)) {
            return false;
        }
        for (int i = 0; i < this.bgx.size(); i++) {
            if (str.equals(this.bgx.get(i).getDynamicGiftId())) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.live.gift.c hA(String str) {
        if (!StringUtils.isNull(str) && !ListUtils.isEmpty(this.bgx)) {
            boolean z = UtilHelper.getRealScreenOrientation(TbadkCoreApplication.getInst().getContext()) == 2;
            for (int i = 0; i < this.bgx.size(); i++) {
                com.baidu.live.gift.c cVar = this.bgx.get(i);
                if (str.equals(cVar.getDynamicGiftId()) && z == cVar.isLandScapeZip()) {
                    return cVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.live.gift.aj
    protected String gU(String str) {
        com.baidu.live.gift.c hA = aba().hA(str);
        if (hA == null || hA.aXb == null || hA.aXb.aWY == null) {
            return null;
        }
        return (com.baidu.live.alphavideo.a.CC().CD() && hA.aXb.Gb()) ? hA.aXb.aWY.videoUrl : hA.aXb.aWY.zipDownloadUrl;
    }

    @Override // com.baidu.live.gift.aj
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

    @Override // com.baidu.live.gift.aj
    protected boolean gW(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return am.Ih().au(str, gU(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, Object obj, long j) {
        if (i2 == 1 || i2 == 2) {
            if (i >= 0) {
                if (this.cap != null && this.cap.size() == 0) {
                    if (i == 0) {
                        if (i2 == 1) {
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

    public void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, long j3, String str8, long j4, int i) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), TbadkCoreApplication.getInst().getContext().getResources().getString(a.h.sdk_no_network_guide));
        } else if (gVar != null) {
            if (gVar.GK()) {
                TiebaInitialize.log(new StatisticItem("c12792").param("obj_id", gVar.Gx()).param("obj_param1", gVar.GB()).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, gV(gVar.Gx()) ? 1 : 0));
            }
            a(gVar, j, str, str2, str3, str5, j2, j3, str8, j4, i);
        }
    }

    public void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, String str8, long j3, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        a(gVar, j, str, str2, str3, str4, str5, str6, str7, j2, currentTimeMillis, str8, j3, i);
        a(gVar, j, str, str2, str3, str4, str6, str7, currentTimeMillis, str8, gVar.GA() ? 1 : 0, j3, i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4, long j2, long j3, String str5, long j4, int i) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(gVar.Gx(), j, gVar, currentAccountInfo.getID(), currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), currentAccountInfo.getLiveLevel(), currentAccountInfo.getSex(), "", -1, str3, "", false, str, str4, j2, str5, j4);
        cVar.bZN = gVar.GA();
        cVar.bZO = i;
        cVar.aYz = j3;
        cVar.aP(System.currentTimeMillis());
        cVar.bew = true;
        com.baidu.live.yuyingift.b.f(cVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, long j2, String str7, int i, long j3, int i2) {
        if (this.cas != null) {
            com.baidu.live.yuyingift.a.b bVar = new com.baidu.live.yuyingift.a.b(gVar, j, str, str2, str3, str4, str5, str6, gVar.getThumbnail_url(), j2, str7, i, j3, i2);
            if (j == 1) {
                bVar.aZB = 0;
            } else {
                bVar.aZB = 1;
            }
            bVar.bev.put(Long.valueOf(j2), Long.valueOf(j));
            if (this.cas.mIsSending || !this.cap.isEmpty()) {
                String a2 = s.a(j3, gVar.Gx(), str, str7);
                com.baidu.live.yuyingift.a.b bVar2 = this.cap.get(a2);
                if (bVar2 == null) {
                    this.cap.put(a2, bVar);
                } else {
                    bVar2.bev.put(Long.valueOf(j2), Long.valueOf(j));
                    bVar2.bes += j;
                }
                this.mHandler.sendEmptyMessage(100);
                return;
            }
            this.cas.a(bVar);
        }
    }

    public void a(long j, int i, String str, String str2, String str3) {
        if (this.cas.mIsSending) {
            if (j > 0) {
                String valueOf = String.valueOf(j);
                com.baidu.live.yuyingift.a.b bVar = new com.baidu.live.yuyingift.a.b();
                bVar.bes = -1L;
                bVar.aPa = str;
                bVar.liveId = str2;
                bVar.bZL = j;
                bVar.boI = str3;
                this.cap.put(valueOf, bVar);
                this.mHandler.sendEmptyMessage(100);
            }
        } else if (this.cas != null) {
            this.cas.a(str, j, i, str2, str3);
        }
    }

    @Override // com.baidu.live.gift.aj
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
            g gS = gS(str);
            if (gS == null) {
                String sharedPrefKeyWithAccount = d.getSharedPrefKeyWithAccount("last_send_get_gift_list_time_yuyin");
                if (System.currentTimeMillis() - d.Ba().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                    d.Ba().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                }
                gS = new g();
                gS.gH(str);
                gS.setGiftName(str2);
                gS.gI("" + j);
                gS.setThumbnailUrl(str3);
                BdResourceLoader.getInstance().loadResource(gS.getThumbnail_url(), 10, null, BdUniqueId.gen());
            }
            com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(str, j, gS, str4, str5, str6, str7, str8, z, str9, str10, j2, str14, j3);
            cVar.aP(System.currentTimeMillis());
            cVar.bew = false;
            cVar.bW(z3);
            cVar.chatMCastId = str12;
            cVar.ensureMCastId = str13;
            cVar.bZN = z5;
            cVar.bZO = i;
            cVar.bZP = z6;
            if (com.baidu.live.af.a.SE().bwi.aNw && !TextUtils.isEmpty(str11)) {
                k kVar = new k();
                if (kVar.gJ(str11)) {
                    cVar.bex.aXM = kVar;
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
                        g gS = gS(optString);
                        if (gS == null) {
                            String sharedPrefKeyWithAccount = d.getSharedPrefKeyWithAccount("last_send_get_gift_list_time_yuyin");
                            if (System.currentTimeMillis() - d.Ba().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                                d.Ba().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                            }
                            gS = new g();
                            gS.gH(optString);
                            gS.setGiftName(optString2);
                            gS.setThumbnailUrl(optString3);
                            BdResourceLoader.getInstance().loadResource(gS.getThumbnail_url(), 10, null, BdUniqueId.gen());
                        }
                        arrayList.add(gS);
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
                com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(gVar.Gx(), j3, gVar, str2, str3, str4, str5, str6, z, str7, str8, j, str12, 0L);
                cVar.aP(System.currentTimeMillis());
                cVar.bew = false;
                cVar.bW(true);
                cVar.chatMCastId = str10;
                cVar.ensureMCastId = str11;
                if (com.baidu.live.af.a.SE().bwi.aNw && !TextUtils.isEmpty(str9)) {
                    k kVar = new k();
                    if (kVar.gJ(str9)) {
                        cVar.bex.aXM = kVar;
                    }
                }
                if (arrayList.size() >= 2) {
                    com.baidu.live.yuyingift.b.a(j, gVar.Gx(), str2, str4, j3, j2, str12);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
            }
        }
    }

    @Override // com.baidu.live.gift.aj
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12) {
        g gVar = new g();
        gVar.gH(str);
        gVar.setGiftName(str2);
        gVar.gI("" + j);
        gVar.setThumbnailUrl(str3);
        com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2, str12, 0L);
        cVar.aP(System.currentTimeMillis());
        cVar.bew = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bW(z3);
        cVar.beI = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
    }

    @Override // com.baidu.live.gift.aj
    protected void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12) {
        g gVar = new g();
        gVar.gH(str);
        gVar.setGiftName(str2);
        gVar.gI("" + j);
        gVar.setThumbnailUrl(str3);
        a(str, j, str4, str6, str5, j2, str12, z, false);
        com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2, str12, 0L);
        cVar.aP(System.currentTimeMillis());
        cVar.bew = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bW(z3);
        cVar.beI = false;
        cVar.beJ = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
    }

    @Override // com.baidu.live.gift.aj
    protected void gZ(String str) {
        if (this.cat == null) {
            this.cat = new com.baidu.live.yuyingift.c.d();
        }
        this.cat.hB(str);
    }

    @Override // com.baidu.live.gift.aj
    protected void a(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6, int i3, long j) {
        if (this.cat == null) {
            this.cat = new com.baidu.live.yuyingift.c.d();
        }
        this.cat.a(str, str2, str3, str4, 1, 0, "", str6, System.currentTimeMillis(), i3, j);
    }

    private void a(String str, long j, String str2, String str3, String str4, long j2, String str5, boolean z, boolean z2) {
        if (gX(str)) {
            if (!he(str)) {
                if (BdNetTypeUtil.isWifiNet() || !m.XB()) {
                    if (this.bgH == null) {
                        this.bgH = new ArrayList<>();
                    }
                    this.bgH.add(new com.baidu.live.yuyingift.a.c(str, j, null, str2, str4, str3, "", "", false, "", "", j2, str5, 0L));
                    com.baidu.live.gift.c hA = aba().hA(str);
                    if (hA != null) {
                        am.Ih().a(hA.aXb, false);
                    }
                }
            }
        } else if (z2) {
            g(z, str);
        }
    }

    @Override // com.baidu.live.gift.aj
    public void HV() {
        if (ListUtils.isEmpty(this.bgx)) {
            this.bgR = true;
            return;
        }
        Iterator<com.baidu.live.gift.c> it = this.bgx.iterator();
        while (it.hasNext()) {
            com.baidu.live.gift.c next = it.next();
            if (next != null && next.aXb != null && !aba().gV(next.getDynamicGiftId())) {
                com.baidu.live.gift.b bVar = next.aXb;
                if (bVar.aWY != null) {
                    am.Ih().a(bVar, false);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.aj
    public void onDestroy() {
        this.bgR = false;
        MessageManager.getInstance().unRegisterListener(this.bgX);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.cas != null) {
            this.cas.onDestroy();
            this.cas = null;
        }
        if (this.caq != null) {
            this.caq.onDestroy();
            this.caq = null;
        }
        if (this.car != null) {
            this.car.onDestroy();
            this.car = null;
        }
        if (this.bgO != null) {
            this.bgO.onDestroy();
            this.bgO = null;
        }
        if (this.cat != null) {
            this.cat.release();
            this.cat = null;
        }
        if (this.bgH != null) {
            this.bgH.clear();
        }
        am.Ih().HE();
        this.bcC.clear();
        this.bgx.clear();
        this.aMh = null;
        this.bgS = null;
    }
}
