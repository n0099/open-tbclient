package com.baidu.live.gift.b;

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
import com.baidu.live.gift.b.c;
import com.baidu.live.gift.g;
import com.baidu.live.gift.giftList.b;
import com.baidu.live.gift.i;
import com.baidu.live.gift.l;
import com.baidu.live.gift.r;
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
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.live.utils.k;
import com.baidu.live.utils.p;
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
public class b extends v {
    private static volatile b aPi;
    private ArrayList<g> aLY;
    private ArrayList<com.baidu.live.gift.c> aOS;
    private ArrayList<com.baidu.live.gift.a.c> aPj;
    private Map<String, com.baidu.live.gift.a.b> aPk;
    private com.baidu.live.gift.giftList.b aPl;
    private com.baidu.live.gift.giftList.c aPm;
    private com.baidu.live.l.c aPn;
    private c aPo;
    private com.baidu.live.gift.c.c aPp;
    private boolean aPq = false;
    private c.a aPr = new c.a() { // from class: com.baidu.live.gift.b.b.1
        @Override // com.baidu.live.gift.b.c.a
        public void b(int i, String str, int i2, Object obj, long j) {
            b.this.a(i, str, i2, obj, j);
        }
    };
    private b.a aPs = new b.a() { // from class: com.baidu.live.gift.b.b.2
        @Override // com.baidu.live.gift.giftList.b.a
        public void i(ArrayList<com.baidu.live.gift.c> arrayList) {
            b.this.aOS.clear();
            if (!ListUtils.isEmpty(arrayList)) {
                b.this.aOS.addAll(arrayList);
                if (b.this.aPq) {
                    b.this.zu();
                }
            }
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.b.b.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Map.Entry entry;
            if (message.what == 100) {
                Set entrySet = b.this.aPk.entrySet();
                if (entrySet.isEmpty()) {
                    if (b.this.aPn != null) {
                        b.this.aPn.refreshCurUserScores();
                    }
                    return true;
                }
                if (b.this.aPo != null && !b.this.aPo.mIsSending && (entry = (Map.Entry) entrySet.iterator().next()) != null) {
                    b.this.aPo.a((com.baidu.live.gift.a.b) entry.getValue());
                    b.this.aPk.remove(entry.getKey());
                }
                b.this.mHandler.sendEmptyMessage(100);
            }
            return false;
        }
    });
    private CustomMessageListener aPt = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.f.c cVar;
            g eT;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.f.c) && !ListUtils.isEmpty(b.this.aPj) && (cVar = (com.baidu.live.f.c) customResponsedMessage.getData()) != null && cVar.aGG != null && cVar.aGF == 5) {
                String id = cVar.aGG.getId();
                ArrayList arrayList = new ArrayList();
                Iterator it = b.this.aPj.iterator();
                while (it.hasNext()) {
                    com.baidu.live.gift.a.c cVar2 = (com.baidu.live.gift.a.c) it.next();
                    if (!TextUtils.isEmpty(cVar2.giftId) && cVar2.giftId.equals(id) && (eT = v.eT(cVar2.giftId)) != null) {
                        arrayList.add(cVar2);
                        b.this.a(cVar2.giftId, cVar2.aNH, eT.yp(), eT.getThumbnail_url(), cVar2.userId, cVar2.portrait, cVar2.userName, "", "", false, "", "", "", cVar2.ayO, cVar2.ayP, cVar2.msgId);
                    }
                }
                b.this.aPj.removeAll(arrayList);
            }
        }
    };

    public static b Bj() {
        if (aPi == null) {
            synchronized (b.class) {
                if (aPi == null) {
                    aPi = new b();
                }
            }
        }
        return aPi;
    }

    private b() {
        a((v) this);
        this.aOS = new ArrayList<>();
        this.aLY = new ArrayList<>();
        this.aPk = new HashMap();
    }

    @Override // com.baidu.live.gift.v
    public void a(BdPageContext bdPageContext, boolean z) {
        MessageManager.getInstance().registerListener(this.aPt);
        if (this.aPm == null) {
            this.aPm = new com.baidu.live.gift.giftList.c(bdPageContext);
        }
        if (this.aPl == null) {
            this.aPl = new com.baidu.live.gift.giftList.b(bdPageContext);
            this.aPl.a(this.aPs);
        }
        Bk();
        bC(z);
        if (this.aPo == null) {
            this.aPo = new c(bdPageContext);
            this.aPo.setUniqueId(BdUniqueId.gen());
        }
        this.aPo.initListener();
        this.aPo.a(this.aPr);
        if (this.aPn == null) {
            this.aPn = new com.baidu.live.l.c();
        }
        this.aPn.initListener();
        this.aPn.refreshCurUserScores();
    }

    private void Bk() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = com.baidu.live.c.vf().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0;
        if (AlaLiveSwitchData.isHotLive == 0) {
            this.aPm.a(p.Jx(), z, "enter", "gift_init");
        }
    }

    private void bC(boolean z) {
        this.aPl.setHost(z);
        this.aPl.loadData();
    }

    @Override // com.baidu.live.gift.v
    public String zt() {
        return p.Jx();
    }

    public void e(String str, ArrayList<i> arrayList) {
        if (!ListUtils.isEmpty(arrayList)) {
            if (this.aLY == null) {
                this.aLY = new ArrayList<>();
            }
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                i next = it.next();
                if (!ListUtils.isEmpty(next.yO())) {
                    c(str, next.yO());
                }
            }
        }
    }

    private void c(String str, List<g> list) {
        boolean z;
        if (!ListUtils.isEmpty(list)) {
            for (g gVar : list) {
                Iterator<g> it = this.aLY.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    g next = it.next();
                    if (next != null && !TextUtils.isEmpty(next.yo()) && next.yo().equals(gVar.yo())) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    gVar.setSceneFrom(str);
                    this.aLY.add(gVar);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.v
    public boolean eQ(String str) {
        if (StringUtils.isNull(str) || ListUtils.isEmpty(this.aOS)) {
            return false;
        }
        for (int i = 0; i < this.aOS.size(); i++) {
            if (str.equals(this.aOS.get(i).getDynamicGiftId())) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.live.gift.c fn(String str) {
        if (!StringUtils.isNull(str) && !ListUtils.isEmpty(this.aOS)) {
            boolean z = UtilHelper.getRealScreenOrientation(TbadkCoreApplication.getInst().getContext()) == 2;
            for (int i = 0; i < this.aOS.size(); i++) {
                com.baidu.live.gift.c cVar = this.aOS.get(i);
                if (str.equals(cVar.getDynamicGiftId()) && z == cVar.isLandScapeZip()) {
                    return cVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.live.gift.v
    protected String eN(String str) {
        com.baidu.live.gift.c fn = Bj().fn(str);
        if (fn == null || fn.aHB == null || fn.aHB.aHz == null) {
            return null;
        }
        return (com.baidu.live.alphavideo.a.vj().vk() && fn.aHB.xU()) ? fn.aHB.aHz.videoUrl : fn.aHB.aHz.zipDownloadUrl;
    }

    @Override // com.baidu.live.gift.v
    public boolean eO(String str) {
        com.baidu.live.gift.c fn;
        if (StringUtils.isNull(str) || (fn = fn(str)) == null || fn.aHB == null) {
            return false;
        }
        if (com.baidu.live.alphavideo.a.vj().vk() && fn.aHB.xU() && !TextUtils.isEmpty(fn.xX())) {
            return true;
        }
        return ListUtils.isEmpty(fn.getDynamicGiftPicPathList()) ? false : true;
    }

    @Override // com.baidu.live.gift.v
    protected boolean eP(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return a.an(str, eN(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, Object obj, long j) {
        if (i2 == 1 || i2 == 2) {
            if (i >= 0) {
                if (this.aPk != null && this.aPk.size() == 0) {
                    if (i == 0) {
                        if (i2 == 1) {
                            TbadkCoreApplication.getInst().currentAccountTdouNum = ((Long) obj).longValue();
                        } else {
                            TbadkCoreApplication.getInst().currentAccountFlowerNum = ((Long) obj).longValue();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                    } else if (this.aPn != null) {
                        this.aPn.refreshCurUserScores();
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
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), TbadkCoreApplication.getInst().getContext().getResources().getString(a.i.sdk_no_network_guide));
        } else if (gVar != null) {
            if (gVar.yz()) {
                TiebaInitialize.log(new StatisticItem("c12792").param("obj_id", gVar.yo()).param("obj_param1", gVar.yr()).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, eO(gVar.yo()) ? 1 : 0));
            }
            a(gVar, j, str, str2, str3, str5, j2, j3);
        }
    }

    @Override // com.baidu.live.gift.v
    public void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        a(gVar, j, str, str2, str3, str4, str5, str6, str7, j2, currentTimeMillis);
        a(gVar, j, str, str2, str3, str4, str6, str7, currentTimeMillis);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4, long j2, long j3) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(gVar.yo(), j, gVar, currentAccountInfo.getID(), currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), currentAccountInfo.getLiveLevel(), currentAccountInfo.getSex(), "", -1, str3, "", false, str, str4, j2);
        cVar.aIQ = j3;
        cVar.ad(System.currentTimeMillis());
        cVar.aNC = true;
        r.f(cVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    private String l(String str, String str2, String str3, String str4) {
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str4;
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, long j2) {
        if (this.aPo != null) {
            com.baidu.live.gift.a.b bVar = new com.baidu.live.gift.a.b(gVar, j, str, str2, str3, str4, str5, str6, gVar.getThumbnail_url(), j2);
            if (j == 1) {
                bVar.aJy = 0;
            } else {
                bVar.aJy = 1;
            }
            bVar.aNB.put(Long.valueOf(j2), Long.valueOf(j));
            if (this.aPo.mIsSending || !this.aPk.isEmpty()) {
                String l = l(str3, str, gVar.yo(), String.valueOf(j));
                com.baidu.live.gift.a.b bVar2 = this.aPk.get(l);
                if (bVar2 == null) {
                    this.aPk.put(l, bVar);
                } else {
                    bVar2.aNB.put(Long.valueOf(j2), Long.valueOf(j));
                    bVar2.aNz += j;
                }
                this.mHandler.sendEmptyMessage(100);
                return;
            }
            this.aPo.a(bVar);
        }
    }

    @Override // com.baidu.live.gift.v
    public g eM(String str) {
        if (TextUtils.isEmpty(str) || this.aLY == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.aLY.size()) {
                return null;
            }
            g gVar = this.aLY.get(i2);
            if (!str.equals(gVar.yo())) {
                i = i2 + 1;
            } else {
                return gVar;
            }
        }
    }

    @Override // com.baidu.live.gift.v
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2) {
        a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, true, true, str12, str13, j2);
    }

    public void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, String str12, String str13, long j2) {
        if (StringUtils.isNull(str4)) {
            if (z) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, str12, str13, str, "userId 为空");
            }
        } else if (!z2 || !str4.equals(TbadkCoreApplication.getCurrentAccount())) {
            a(str, j, str4, str6, str5, j2);
            g eM = eM(str);
            if (eM == null) {
                String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount("last_send_get_gift_list_time");
                if (System.currentTimeMillis() - com.baidu.live.c.vf().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                    com.baidu.live.c.vf().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                }
                eM = new g();
                eM.eI(str);
                eM.setGiftName(str2);
                eM.eJ("" + j);
                eM.setThumbnailUrl(str3);
                BdResourceLoader.getInstance().loadResource(eM.getThumbnail_url(), 10, null, BdUniqueId.gen());
            }
            com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, eM, str4, str5, str6, str7, str8, z, str9, str10, j2);
            cVar.ad(System.currentTimeMillis());
            cVar.aNC = false;
            cVar.bA(z3);
            cVar.ayO = str12;
            cVar.ayP = str13;
            if (com.baidu.live.v.a.Hs().aZn.aAB && !TextUtils.isEmpty(str11)) {
                l lVar = new l();
                if (lVar.eK(str11)) {
                    cVar.aND.aIh = lVar;
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.live.gift.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j) {
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
                            g eM = eM(optString);
                            if (eM == null) {
                                String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount("last_send_get_gift_list_time");
                                if (System.currentTimeMillis() - com.baidu.live.c.vf().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                                    com.baidu.live.c.vf().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                                }
                                eM = new g();
                                eM.eI(optString);
                                eM.setGiftName(optString2);
                                eM.setThumbnailUrl(optString3);
                                BdResourceLoader.getInstance().loadResource(eM.getThumbnail_url(), 10, null, BdUniqueId.gen());
                            }
                            arrayList.add(eM);
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
                com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(gVar.yo(), j3, gVar, str2, str3, str4, str5, str6, z, str7, str8, j);
                cVar.ad(System.currentTimeMillis());
                cVar.aNC = false;
                cVar.bA(true);
                cVar.ayO = str10;
                cVar.ayP = str11;
                if (com.baidu.live.v.a.Hs().aZn.aAB && !TextUtils.isEmpty(str9)) {
                    l lVar = new l();
                    if (lVar.eK(str9)) {
                        cVar.aND.aIh = lVar;
                    }
                }
                if (arrayList.size() >= 2) {
                    r.a(j, gVar.yo(), str2, str4, j3, j2);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
            }
        }
    }

    @Override // com.baidu.live.gift.v
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        g gVar = new g();
        gVar.eI(str);
        gVar.setGiftName(str2);
        gVar.eJ("" + j);
        gVar.setThumbnailUrl(str3);
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2);
        cVar.ad(System.currentTimeMillis());
        cVar.aNC = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bA(z3);
        cVar.aNM = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    @Override // com.baidu.live.gift.v
    protected void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        g gVar = new g();
        gVar.eI(str);
        gVar.setGiftName(str2);
        gVar.eJ("" + j);
        gVar.setThumbnailUrl(str3);
        a(str, j, str4, str6, str5, j2);
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2);
        cVar.ad(System.currentTimeMillis());
        cVar.aNC = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bA(z3);
        cVar.aNM = false;
        cVar.aNN = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    @Override // com.baidu.live.gift.v
    protected void eR(String str) {
        if (this.aPp == null) {
            this.aPp = new com.baidu.live.gift.c.a();
        }
        this.aPp.fo(str);
    }

    @Override // com.baidu.live.gift.v
    protected void b(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        if (this.aPp == null) {
            this.aPp = new com.baidu.live.gift.c.a();
        }
        this.aPp.a(str, "", str2, str3, str4, 1, 0, "", System.currentTimeMillis());
    }

    private void a(String str, long j, String str2, String str3, String str4, long j2) {
        if (eQ(str) && !eU(str)) {
            if (BdNetTypeUtil.isWifiNet() || !k.Jr()) {
                if (this.aPj == null) {
                    this.aPj = new ArrayList<>();
                }
                this.aPj.add(new com.baidu.live.gift.a.c(str, j, null, str2, str4, str3, "", "", false, "", "", j2));
                com.baidu.live.gift.c fn = Bj().fn(str);
                if (fn != null && fn.xW()) {
                    a.a(fn.aHB, false);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.v
    public void zu() {
        if (ListUtils.isEmpty(this.aOS)) {
            this.aPq = true;
            return;
        }
        Iterator<com.baidu.live.gift.c> it = this.aOS.iterator();
        while (it.hasNext()) {
            com.baidu.live.gift.c next = it.next();
            if (next != null && next.aHB != null && next.xW() && !Bj().eO(next.getDynamicGiftId())) {
                com.baidu.live.gift.b bVar = next.aHB;
                if (bVar.aHz != null) {
                    a.a(bVar, false);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.v
    public void onDestroy() {
        this.aPq = false;
        MessageManager.getInstance().unRegisterListener(this.aPt);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aPo != null) {
            this.aPo.onDestroy();
            this.aPo = null;
        }
        if (this.aPl != null) {
            this.aPl.onDestroy();
            this.aPl = null;
        }
        if (this.aPm != null) {
            this.aPm.onDestroy();
            this.aPm = null;
        }
        if (this.aPn != null) {
            this.aPn.onDestroy();
            this.aPn = null;
        }
        if (this.aPp != null) {
            this.aPp.release();
            this.aPp = null;
        }
        if (this.aPj != null) {
            this.aPj.clear();
        }
        a.Bi();
        this.aLY.clear();
        this.aOS.clear();
    }
}
