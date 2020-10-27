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
import com.baidu.live.data.w;
import com.baidu.live.gift.ai;
import com.baidu.live.gift.al;
import com.baidu.live.gift.g;
import com.baidu.live.gift.i;
import com.baidu.live.gift.l;
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
import com.baidu.live.utils.r;
import com.baidu.live.utils.s;
import com.baidu.live.yuyingift.b.c;
import com.baidu.live.yuyingift.giftlist.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends ai {
    private static volatile b bLn;
    private w aJv;
    private ArrayList<g> aXW;
    private com.baidu.live.yuyingift.giftlist.a bLo;
    private com.baidu.live.yuyingift.giftlist.b bLp;
    private c bLq;
    private com.baidu.live.yuyingift.c.b bLr;
    private ArrayList<com.baidu.live.gift.c> bbg;
    private ArrayList<com.baidu.live.yuyingift.a.c> bbu;
    private Map<String, com.baidu.live.yuyingift.a.b> bbv;
    private com.baidu.live.m.c bby;
    private boolean bbB = false;
    private c.a bLs = new c.a() { // from class: com.baidu.live.yuyingift.b.b.1
        @Override // com.baidu.live.yuyingift.b.c.a
        public void b(int i, String str, int i2, Object obj, long j) {
            b.this.a(i, str, i2, obj, j);
        }
    };
    private a.InterfaceC0226a bLt = new a.InterfaceC0226a() { // from class: com.baidu.live.yuyingift.b.b.2
        @Override // com.baidu.live.yuyingift.giftlist.a.InterfaceC0226a
        public void n(ArrayList<com.baidu.live.gift.c> arrayList) {
            b.this.bbg.clear();
            if (!ListUtils.isEmpty(arrayList)) {
                b.this.bbg.addAll(arrayList);
                if (b.this.bbB) {
                    b.this.GL();
                }
            }
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.yuyingift.b.b.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Map.Entry entry;
            if (message.what == 100) {
                Set entrySet = b.this.bbv.entrySet();
                if (entrySet.isEmpty()) {
                    if (b.this.bby != null) {
                        b.this.bby.refreshCurUserScores();
                    }
                    return true;
                }
                if (b.this.bLq != null && !b.this.bLq.mIsSending && (entry = (Map.Entry) entrySet.iterator().next()) != null) {
                    b.this.bLq.a((com.baidu.live.yuyingift.a.b) entry.getValue());
                    b.this.bbv.remove(entry.getKey());
                }
                b.this.mHandler.sendEmptyMessage(100);
            }
            return false;
        }
    });
    private CustomMessageListener bbH = new CustomMessageListener(2913078) { // from class: com.baidu.live.yuyingift.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.f.c cVar;
            g gW;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.f.c) && !ListUtils.isEmpty(b.this.bbu) && (cVar = (com.baidu.live.f.c) customResponsedMessage.getData()) != null && cVar.aRJ != null && cVar.aRI == 5) {
                String id = cVar.aRJ.getId();
                ArrayList arrayList = new ArrayList();
                Iterator it = b.this.bbu.iterator();
                while (it.hasNext()) {
                    com.baidu.live.yuyingift.a.c cVar2 = (com.baidu.live.yuyingift.a.c) it.next();
                    if (!TextUtils.isEmpty(cVar2.giftId) && cVar2.giftId.equals(id) && (gW = ai.gW(cVar2.giftId)) != null) {
                        arrayList.add(cVar2);
                        b.this.a(cVar2.giftId, cVar2.aZP, gW.Ft(), gW.getThumbnail_url(), cVar2.userId, cVar2.portrait, cVar2.userName, "", "", false, "", "", "", cVar2.chatMCastId, cVar2.ensureMCastId, cVar2.msgId, cVar2.bja, false);
                    }
                }
                b.this.bbu.removeAll(arrayList);
                com.baidu.live.gift.c hq = b.this.hq(id);
                if (hq != null && hq.aSL != null && hq.aSL.aSJ != null) {
                    v.gv(hq.aSL.aSJ.zipName);
                }
            }
        }
    };

    public static b Vf() {
        if (bLn == null) {
            synchronized (b.class) {
                if (bLn == null) {
                    bLn = new b();
                }
            }
        }
        return bLn;
    }

    private b() {
        a((ai) this);
        this.bbg = new ArrayList<>();
        this.aXW = new ArrayList<>();
        this.bbv = new HashMap();
    }

    @Override // com.baidu.live.gift.ai
    protected w GH() {
        return this.aJv;
    }

    @Override // com.baidu.live.gift.ai
    protected void d(w wVar) {
        this.aJv = wVar;
    }

    @Override // com.baidu.live.gift.ai
    public void a(BdPageContext bdPageContext, boolean z) {
        MessageManager.getInstance().registerListener(this.bbH);
        if (this.bLp == null) {
            this.bLp = new com.baidu.live.yuyingift.giftlist.b(bdPageContext);
        }
        if (this.bLo == null) {
            this.bLo = new com.baidu.live.yuyingift.giftlist.a(bdPageContext);
            this.bLo.a(this.bLt);
        }
        g(z, null);
        if (this.bLq == null) {
            this.bLq = new c(bdPageContext);
            this.bLq.setUniqueId(BdUniqueId.gen());
        }
        this.bLq.initListener();
        this.bLq.a(this.bLs);
        if (this.bby == null) {
            this.bby = new com.baidu.live.m.c();
        }
        this.bby.initListener();
        this.bby.refreshCurUserScores();
    }

    @Override // com.baidu.live.gift.ai
    public void GJ() {
        if (AlaLiveSwitchData.isHotLive == 0) {
            this.bLp.a(s.Sc(), true, "enter", "gift_init");
        }
    }

    private void g(boolean z, String str) {
        this.bLo.setHost(z);
        this.bLo.hp(str);
    }

    @Override // com.baidu.live.gift.ai
    public String GK() {
        return s.Sc();
    }

    public void e(String str, ArrayList<i> arrayList) {
        if (!ListUtils.isEmpty(arrayList)) {
            if (this.aXW == null) {
                this.aXW = new ArrayList<>();
            }
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                i next = it.next();
                if (!ListUtils.isEmpty(next.FT())) {
                    c(str, next.FT());
                }
            }
        }
    }

    private void c(String str, List<g> list) {
        boolean z;
        if (!ListUtils.isEmpty(list)) {
            for (g gVar : list) {
                Iterator<g> it = this.aXW.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    g next = it.next();
                    if (next != null && !TextUtils.isEmpty(next.Fs()) && next.Fs().equals(gVar.Fs())) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    gVar.setSceneFrom(str);
                    this.aXW.add(gVar);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.ai
    public boolean gS(String str) {
        if (StringUtils.isNull(str) || ListUtils.isEmpty(this.bbg)) {
            return false;
        }
        for (int i = 0; i < this.bbg.size(); i++) {
            if (str.equals(this.bbg.get(i).getDynamicGiftId())) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.live.gift.c hq(String str) {
        if (!StringUtils.isNull(str) && !ListUtils.isEmpty(this.bbg)) {
            boolean z = UtilHelper.getRealScreenOrientation(TbadkCoreApplication.getInst().getContext()) == 2;
            for (int i = 0; i < this.bbg.size(); i++) {
                com.baidu.live.gift.c cVar = this.bbg.get(i);
                if (str.equals(cVar.getDynamicGiftId()) && z == cVar.isLandScapeZip()) {
                    return cVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.live.gift.ai
    protected String gP(String str) {
        com.baidu.live.gift.c hq = Vf().hq(str);
        if (hq == null || hq.aSL == null || hq.aSL.aSJ == null) {
            return null;
        }
        return (com.baidu.live.alphavideo.a.BT().BU() && hq.aSL.Fa()) ? hq.aSL.aSJ.videoUrl : hq.aSL.aSJ.zipDownloadUrl;
    }

    @Override // com.baidu.live.gift.ai
    public boolean gQ(String str) {
        com.baidu.live.gift.c hq;
        if (StringUtils.isNull(str) || (hq = hq(str)) == null || hq.aSL == null) {
            return false;
        }
        if (com.baidu.live.alphavideo.a.BT().BU() && hq.aSL.Fa() && !TextUtils.isEmpty(hq.Fb())) {
            return true;
        }
        return ListUtils.isEmpty(hq.getDynamicGiftPicPathList()) ? false : true;
    }

    @Override // com.baidu.live.gift.ai
    protected boolean gR(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return al.GW().ar(str, gP(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, Object obj, long j) {
        if (i2 == 1 || i2 == 2) {
            if (i >= 0) {
                if (this.bbv != null && this.bbv.size() == 0) {
                    if (i == 0) {
                        if (i2 == 1) {
                            TbadkCoreApplication.getInst().currentAccountTdouNum = ((Long) obj).longValue();
                        } else {
                            TbadkCoreApplication.getInst().currentAccountFlowerNum = ((Long) obj).longValue();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                    } else if (this.bby != null) {
                        this.bby.refreshCurUserScores();
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

    public void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, long j3, String str8) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), TbadkCoreApplication.getInst().getContext().getResources().getString(a.i.sdk_no_network_guide));
        } else if (gVar != null) {
            if (gVar.FD()) {
                TiebaInitialize.log(new StatisticItem("c12792").param("obj_id", gVar.Fs()).param("obj_param1", gVar.Fv()).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, gQ(gVar.Fs()) ? 1 : 0));
            }
            a(gVar, j, str, str2, str3, str5, j2, j3, str8);
        }
    }

    public void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, String str8) {
        long currentTimeMillis = System.currentTimeMillis();
        a(gVar, j, str, str2, str3, str4, str5, str6, str7, j2, currentTimeMillis, str8);
        a(gVar, j, str, str2, str3, str4, str6, str7, currentTimeMillis, str8);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4, long j2, long j3, String str5) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(gVar.Fs(), j, gVar, currentAccountInfo.getID(), currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), currentAccountInfo.getLiveLevel(), currentAccountInfo.getSex(), "", -1, str3, "", false, str, str4, j2, str5);
        cVar.aUi = j3;
        cVar.ag(System.currentTimeMillis());
        cVar.aZI = true;
        com.baidu.live.yuyingift.b.f(cVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, long j2, String str7) {
        if (this.bLq != null) {
            com.baidu.live.yuyingift.a.b bVar = new com.baidu.live.yuyingift.a.b(gVar, j, str, str2, str3, str4, str5, str6, gVar.getThumbnail_url(), j2, str7);
            if (j == 1) {
                bVar.aVi = 0;
            } else {
                bVar.aVi = 1;
            }
            bVar.aZH.put(Long.valueOf(j2), Long.valueOf(j));
            if (this.bLq.mIsSending || !this.bbv.isEmpty()) {
                String A = r.A(gVar.Fs(), str, str7);
                com.baidu.live.yuyingift.a.b bVar2 = this.bbv.get(A);
                if (bVar2 == null) {
                    this.bbv.put(A, bVar);
                } else {
                    bVar2.aZH.put(Long.valueOf(j2), Long.valueOf(j));
                    bVar2.aZF += j;
                }
                this.mHandler.sendEmptyMessage(100);
                return;
            }
            this.bLq.a(bVar);
        }
    }

    @Override // com.baidu.live.gift.ai
    public g gN(String str) {
        if (TextUtils.isEmpty(str) || this.aXW == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.aXW.size()) {
                return null;
            }
            g gVar = this.aXW.get(i2);
            if (!str.equals(gVar.Fs())) {
                i = i2 + 1;
            } else {
                return gVar;
            }
        }
    }

    @Override // com.baidu.live.gift.ai
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2, String str14, boolean z2) {
        a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, true, true, str12, str13, j2, str14, z2);
    }

    public void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, String str12, String str13, long j2, String str14, boolean z4) {
        if (StringUtils.isNull(str4)) {
            if (z) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, str12, str13, str, "userId 为空");
            }
        } else if (!z2 || !str4.equals(TbadkCoreApplication.getCurrentAccount())) {
            a(str, j, str4, str6, str5, j2, str14, z, z4);
            g gN = gN(str);
            if (gN == null) {
                String sharedPrefKeyWithAccount = d.getSharedPrefKeyWithAccount("last_send_get_gift_list_time_yuyin");
                if (System.currentTimeMillis() - d.AZ().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                    d.AZ().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                }
                gN = new g();
                gN.gC(str);
                gN.setGiftName(str2);
                gN.gD("" + j);
                gN.setThumbnailUrl(str3);
                BdResourceLoader.getInstance().loadResource(gN.getThumbnail_url(), 10, null, BdUniqueId.gen());
            }
            com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(str, j, gN, str4, str5, str6, str7, str8, z, str9, str10, j2, str14);
            cVar.ag(System.currentTimeMillis());
            cVar.aZI = false;
            cVar.bM(z3);
            cVar.chatMCastId = str12;
            cVar.ensureMCastId = str13;
            if (com.baidu.live.z.a.Pq().bmJ.aKI && !TextUtils.isEmpty(str11)) {
                l lVar = new l();
                if (lVar.gE(str11)) {
                    cVar.aZJ.aTv = lVar;
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.live.gift.ai
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
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
                    while (i < jSONArray.length()) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        String optString = jSONObject.optString(LogConfig.LOG_GIFT_ID);
                        String optString2 = jSONObject.optString("gift_name");
                        long optLong = jSONObject.optLong("gift_count");
                        String optString3 = jSONObject.optString("gift_url");
                        long optLong2 = jSONObject.optLong("charm_value");
                        long j5 = j3 + optLong;
                        long j6 = j4 + optLong2;
                        try {
                            g gN = gN(optString);
                            if (gN == null) {
                                String sharedPrefKeyWithAccount = d.getSharedPrefKeyWithAccount("last_send_get_gift_list_time_yuyin");
                                if (System.currentTimeMillis() - d.AZ().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                                    d.AZ().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                                }
                                gN = new g();
                                gN.gC(optString);
                                gN.setGiftName(optString2);
                                gN.setThumbnailUrl(optString3);
                                BdResourceLoader.getInstance().loadResource(gN.getThumbnail_url(), 10, null, BdUniqueId.gen());
                            }
                            arrayList.add(gN);
                            i++;
                            j4 = j6;
                            j3 = j5;
                        } catch (JSONException e) {
                            j4 = j6;
                            j3 = j5;
                            e = e;
                            e.printStackTrace();
                            j2 = j4;
                            if (ListUtils.isEmpty(arrayList)) {
                            }
                        }
                    }
                }
                j2 = j4;
            } catch (JSONException e2) {
                e = e2;
            }
            if (ListUtils.isEmpty(arrayList)) {
                g gVar = (g) arrayList.get(0);
                com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(gVar.Fs(), j3, gVar, str2, str3, str4, str5, str6, z, str7, str8, j, str12);
                cVar.ag(System.currentTimeMillis());
                cVar.aZI = false;
                cVar.bM(true);
                cVar.chatMCastId = str10;
                cVar.ensureMCastId = str11;
                if (com.baidu.live.z.a.Pq().bmJ.aKI && !TextUtils.isEmpty(str9)) {
                    l lVar = new l();
                    if (lVar.gE(str9)) {
                        cVar.aZJ.aTv = lVar;
                    }
                }
                if (arrayList.size() >= 2) {
                    com.baidu.live.yuyingift.b.a(j, gVar.Fs(), str2, str4, j3, j2, str12);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
            }
        }
    }

    @Override // com.baidu.live.gift.ai
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12) {
        g gVar = new g();
        gVar.gC(str);
        gVar.setGiftName(str2);
        gVar.gD("" + j);
        gVar.setThumbnailUrl(str3);
        com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2, str12);
        cVar.ag(System.currentTimeMillis());
        cVar.aZI = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bM(z3);
        cVar.aZU = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
    }

    @Override // com.baidu.live.gift.ai
    protected void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12) {
        g gVar = new g();
        gVar.gC(str);
        gVar.setGiftName(str2);
        gVar.gD("" + j);
        gVar.setThumbnailUrl(str3);
        a(str, j, str4, str6, str5, j2, str12, z, false);
        com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2, str12);
        cVar.ag(System.currentTimeMillis());
        cVar.aZI = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bM(z3);
        cVar.aZU = false;
        cVar.aZV = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
    }

    @Override // com.baidu.live.gift.ai
    protected void gT(String str) {
        if (this.bLr == null) {
            this.bLr = new com.baidu.live.yuyingift.c.c();
        }
        this.bLr.hr(str);
    }

    @Override // com.baidu.live.gift.ai
    protected void a(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6) {
        if (this.bLr == null) {
            this.bLr = new com.baidu.live.yuyingift.c.c();
        }
        this.bLr.a(str, str2, str3, str4, 1, 0, "", str6, System.currentTimeMillis());
    }

    private void a(String str, long j, String str2, String str3, String str4, long j2, String str5, boolean z, boolean z2) {
        if (gS(str)) {
            if (!gY(str)) {
                if (BdNetTypeUtil.isWifiNet() || !com.baidu.live.utils.l.RX()) {
                    if (this.bbu == null) {
                        this.bbu = new ArrayList<>();
                    }
                    this.bbu.add(new com.baidu.live.yuyingift.a.c(str, j, null, str2, str4, str3, "", "", false, "", "", j2, str5));
                    com.baidu.live.gift.c hq = Vf().hq(str);
                    if (hq != null) {
                        al.GW().a(hq.aSL, false);
                    }
                }
            }
        } else if (z2) {
            g(z, str);
        }
    }

    @Override // com.baidu.live.gift.ai
    public void GL() {
        if (ListUtils.isEmpty(this.bbg)) {
            this.bbB = true;
            return;
        }
        Iterator<com.baidu.live.gift.c> it = this.bbg.iterator();
        while (it.hasNext()) {
            com.baidu.live.gift.c next = it.next();
            if (next != null && next.aSL != null && !Vf().gQ(next.getDynamicGiftId())) {
                com.baidu.live.gift.b bVar = next.aSL;
                if (bVar.aSJ != null) {
                    al.GW().a(bVar, false);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.ai
    public void onDestroy() {
        this.bbB = false;
        MessageManager.getInstance().unRegisterListener(this.bbH);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bLq != null) {
            this.bLq.onDestroy();
            this.bLq = null;
        }
        if (this.bLo != null) {
            this.bLo.onDestroy();
            this.bLo = null;
        }
        if (this.bLp != null) {
            this.bLp.onDestroy();
            this.bLp = null;
        }
        if (this.bby != null) {
            this.bby.onDestroy();
            this.bby = null;
        }
        if (this.bLr != null) {
            this.bLr.release();
            this.bLr = null;
        }
        if (this.bbu != null) {
            this.bbu.clear();
        }
        al.GW().Gw();
        this.aXW.clear();
        this.bbg.clear();
    }
}
