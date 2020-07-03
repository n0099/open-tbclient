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
/* loaded from: classes3.dex */
public class b extends v {
    private static volatile b aNN;
    private ArrayList<g> aKC;
    private ArrayList<com.baidu.live.gift.a.c> aNO;
    private Map<String, com.baidu.live.gift.a.b> aNP;
    private com.baidu.live.gift.giftList.b aNQ;
    private com.baidu.live.gift.giftList.c aNR;
    private com.baidu.live.l.c aNS;
    private c aNT;
    private com.baidu.live.gift.c.c aNU;
    private ArrayList<com.baidu.live.gift.c> aNx;
    private boolean aNV = false;
    private c.a aNW = new c.a() { // from class: com.baidu.live.gift.b.b.1
        @Override // com.baidu.live.gift.b.c.a
        public void b(int i, String str, int i2, Object obj, long j) {
            b.this.a(i, str, i2, obj, j);
        }
    };
    private b.a aNX = new b.a() { // from class: com.baidu.live.gift.b.b.2
        @Override // com.baidu.live.gift.giftList.b.a
        public void i(ArrayList<com.baidu.live.gift.c> arrayList) {
            b.this.aNx.clear();
            if (!ListUtils.isEmpty(arrayList)) {
                b.this.aNx.addAll(arrayList);
                if (b.this.aNV) {
                    b.this.yS();
                }
            }
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.b.b.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Map.Entry entry;
            if (message.what == 100) {
                Set entrySet = b.this.aNP.entrySet();
                if (entrySet.isEmpty()) {
                    if (b.this.aNS != null) {
                        b.this.aNS.refreshCurUserScores();
                    }
                    return true;
                }
                if (b.this.aNT != null && !b.this.aNT.mIsSending && (entry = (Map.Entry) entrySet.iterator().next()) != null) {
                    b.this.aNT.a((com.baidu.live.gift.a.b) entry.getValue());
                    b.this.aNP.remove(entry.getKey());
                }
                b.this.mHandler.sendEmptyMessage(100);
            }
            return false;
        }
    });
    private CustomMessageListener aNY = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.f.c cVar;
            g eU;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.f.c) && !ListUtils.isEmpty(b.this.aNO) && (cVar = (com.baidu.live.f.c) customResponsedMessage.getData()) != null && cVar.aFl != null && cVar.aFk == 5) {
                String id = cVar.aFl.getId();
                ArrayList arrayList = new ArrayList();
                Iterator it = b.this.aNO.iterator();
                while (it.hasNext()) {
                    com.baidu.live.gift.a.c cVar2 = (com.baidu.live.gift.a.c) it.next();
                    if (!TextUtils.isEmpty(cVar2.giftId) && cVar2.giftId.equals(id) && (eU = v.eU(cVar2.giftId)) != null) {
                        arrayList.add(cVar2);
                        b.this.a(cVar2.giftId, cVar2.aMm, eU.xN(), eU.getThumbnail_url(), cVar2.userId, cVar2.portrait, cVar2.userName, "", "", false, "", "", "", cVar2.axB, cVar2.axC, cVar2.msgId);
                    }
                }
                b.this.aNO.removeAll(arrayList);
            }
        }
    };

    public static b AH() {
        if (aNN == null) {
            synchronized (b.class) {
                if (aNN == null) {
                    aNN = new b();
                }
            }
        }
        return aNN;
    }

    private b() {
        a((v) this);
        this.aNx = new ArrayList<>();
        this.aKC = new ArrayList<>();
        this.aNP = new HashMap();
    }

    @Override // com.baidu.live.gift.v
    public void a(BdPageContext bdPageContext, boolean z) {
        MessageManager.getInstance().registerListener(this.aNY);
        if (this.aNR == null) {
            this.aNR = new com.baidu.live.gift.giftList.c(bdPageContext);
        }
        if (this.aNQ == null) {
            this.aNQ = new com.baidu.live.gift.giftList.b(bdPageContext);
            this.aNQ.a(this.aNX);
        }
        AI();
        bz(z);
        if (this.aNT == null) {
            this.aNT = new c(bdPageContext);
            this.aNT.setUniqueId(BdUniqueId.gen());
        }
        this.aNT.initListener();
        this.aNT.a(this.aNW);
        if (this.aNS == null) {
            this.aNS = new com.baidu.live.l.c();
        }
        this.aNS.initListener();
        this.aNS.refreshCurUserScores();
    }

    private void AI() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = com.baidu.live.c.vf().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0;
        if (AlaLiveSwitchData.isHotLive == 0) {
            this.aNR.a(p.Jq(), z, "enter", "gift_init");
        }
    }

    private void bz(boolean z) {
        this.aNQ.setHost(z);
        this.aNQ.loadData();
    }

    @Override // com.baidu.live.gift.v
    public String yR() {
        return p.Jq();
    }

    public void e(String str, ArrayList<i> arrayList) {
        if (!ListUtils.isEmpty(arrayList)) {
            if (this.aKC == null) {
                this.aKC = new ArrayList<>();
            }
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                i next = it.next();
                if (!ListUtils.isEmpty(next.ym())) {
                    c(str, next.ym());
                }
            }
        }
    }

    private void c(String str, List<g> list) {
        boolean z;
        if (!ListUtils.isEmpty(list)) {
            for (g gVar : list) {
                Iterator<g> it = this.aKC.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    g next = it.next();
                    if (next != null && !TextUtils.isEmpty(next.xM()) && next.xM().equals(gVar.xM())) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    gVar.setSceneFrom(str);
                    this.aKC.add(gVar);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.v
    public boolean eR(String str) {
        if (StringUtils.isNull(str) || ListUtils.isEmpty(this.aNx)) {
            return false;
        }
        for (int i = 0; i < this.aNx.size(); i++) {
            if (str.equals(this.aNx.get(i).getDynamicGiftId())) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.live.gift.c fo(String str) {
        if (!StringUtils.isNull(str) && !ListUtils.isEmpty(this.aNx)) {
            boolean z = UtilHelper.getRealScreenOrientation(TbadkCoreApplication.getInst().getContext()) == 2;
            for (int i = 0; i < this.aNx.size(); i++) {
                com.baidu.live.gift.c cVar = this.aNx.get(i);
                if (str.equals(cVar.getDynamicGiftId()) && z == cVar.isLandScapeZip()) {
                    return cVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.live.gift.v
    protected String eO(String str) {
        com.baidu.live.gift.c fo = AH().fo(str);
        if (fo == null || fo.aGg == null || fo.aGg.aGe == null) {
            return null;
        }
        return (com.baidu.live.alphavideo.a.vj().vk() && fo.aGg.xs()) ? fo.aGg.aGe.videoUrl : fo.aGg.aGe.zipDownloadUrl;
    }

    @Override // com.baidu.live.gift.v
    public boolean eP(String str) {
        com.baidu.live.gift.c fo;
        if (StringUtils.isNull(str) || (fo = fo(str)) == null || fo.aGg == null) {
            return false;
        }
        if (com.baidu.live.alphavideo.a.vj().vk() && fo.aGg.xs() && !TextUtils.isEmpty(fo.xv())) {
            return true;
        }
        return ListUtils.isEmpty(fo.getDynamicGiftPicPathList()) ? false : true;
    }

    @Override // com.baidu.live.gift.v
    protected boolean eQ(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return a.ao(str, eO(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, Object obj, long j) {
        if (i2 == 1 || i2 == 2) {
            if (i >= 0) {
                if (this.aNP != null && this.aNP.size() == 0) {
                    if (i == 0) {
                        if (i2 == 1) {
                            TbadkCoreApplication.getInst().currentAccountTdouNum = ((Long) obj).longValue();
                        } else {
                            TbadkCoreApplication.getInst().currentAccountFlowerNum = ((Long) obj).longValue();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                    } else if (this.aNS != null) {
                        this.aNS.refreshCurUserScores();
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
            if (gVar.xX()) {
                TiebaInitialize.log(new StatisticItem("c12792").param("obj_id", gVar.xM()).param("obj_param1", gVar.xP()).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, eP(gVar.xM()) ? 1 : 0));
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
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(gVar.xM(), j, gVar, currentAccountInfo.getID(), currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), currentAccountInfo.getLiveLevel(), currentAccountInfo.getSex(), "", -1, str3, "", false, str, str4, j2);
        cVar.aHv = j3;
        cVar.ad(System.currentTimeMillis());
        cVar.aMh = true;
        r.f(cVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    private String l(String str, String str2, String str3, String str4) {
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str4;
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, long j2) {
        if (this.aNT != null) {
            com.baidu.live.gift.a.b bVar = new com.baidu.live.gift.a.b(gVar, j, str, str2, str3, str4, str5, str6, gVar.getThumbnail_url(), j2);
            if (j == 1) {
                bVar.aIb = 0;
            } else {
                bVar.aIb = 1;
            }
            bVar.aMg.put(Long.valueOf(j2), Long.valueOf(j));
            if (this.aNT.mIsSending || !this.aNP.isEmpty()) {
                String l = l(str3, str, gVar.xM(), String.valueOf(j));
                com.baidu.live.gift.a.b bVar2 = this.aNP.get(l);
                if (bVar2 == null) {
                    this.aNP.put(l, bVar);
                } else {
                    bVar2.aMg.put(Long.valueOf(j2), Long.valueOf(j));
                    bVar2.aMe += j;
                }
                this.mHandler.sendEmptyMessage(100);
                return;
            }
            this.aNT.a(bVar);
        }
    }

    @Override // com.baidu.live.gift.v
    public g eN(String str) {
        if (TextUtils.isEmpty(str) || this.aKC == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.aKC.size()) {
                return null;
            }
            g gVar = this.aKC.get(i2);
            if (!str.equals(gVar.xM())) {
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
            g eN = eN(str);
            if (eN == null) {
                String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount("last_send_get_gift_list_time");
                if (System.currentTimeMillis() - com.baidu.live.c.vf().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                    com.baidu.live.c.vf().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                }
                eN = new g();
                eN.eJ(str);
                eN.setGiftName(str2);
                eN.eK("" + j);
                eN.setThumbnailUrl(str3);
                BdResourceLoader.getInstance().loadResource(eN.getThumbnail_url(), 10, null, BdUniqueId.gen());
            }
            com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, eN, str4, str5, str6, str7, str8, z, str9, str10, j2);
            cVar.ad(System.currentTimeMillis());
            cVar.aMh = false;
            cVar.bx(z3);
            cVar.axB = str12;
            cVar.axC = str13;
            if (com.baidu.live.v.a.Hm().aZp.azo && !TextUtils.isEmpty(str11)) {
                l lVar = new l();
                if (lVar.eL(str11)) {
                    cVar.aMi.aGM = lVar;
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
                            g eN = eN(optString);
                            if (eN == null) {
                                String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount("last_send_get_gift_list_time");
                                if (System.currentTimeMillis() - com.baidu.live.c.vf().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                                    com.baidu.live.c.vf().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                                }
                                eN = new g();
                                eN.eJ(optString);
                                eN.setGiftName(optString2);
                                eN.setThumbnailUrl(optString3);
                                BdResourceLoader.getInstance().loadResource(eN.getThumbnail_url(), 10, null, BdUniqueId.gen());
                            }
                            arrayList.add(eN);
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
                com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(gVar.xM(), j3, gVar, str2, str3, str4, str5, str6, z, str7, str8, j);
                cVar.ad(System.currentTimeMillis());
                cVar.aMh = false;
                cVar.bx(true);
                cVar.axB = str10;
                cVar.axC = str11;
                if (com.baidu.live.v.a.Hm().aZp.azo && !TextUtils.isEmpty(str9)) {
                    l lVar = new l();
                    if (lVar.eL(str9)) {
                        cVar.aMi.aGM = lVar;
                    }
                }
                if (arrayList.size() >= 2) {
                    r.a(j, gVar.xM(), str2, str4, j3, j2);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
            }
        }
    }

    @Override // com.baidu.live.gift.v
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        g gVar = new g();
        gVar.eJ(str);
        gVar.setGiftName(str2);
        gVar.eK("" + j);
        gVar.setThumbnailUrl(str3);
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2);
        cVar.ad(System.currentTimeMillis());
        cVar.aMh = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bx(z3);
        cVar.aMr = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    @Override // com.baidu.live.gift.v
    protected void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        g gVar = new g();
        gVar.eJ(str);
        gVar.setGiftName(str2);
        gVar.eK("" + j);
        gVar.setThumbnailUrl(str3);
        a(str, j, str4, str6, str5, j2);
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2);
        cVar.ad(System.currentTimeMillis());
        cVar.aMh = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bx(z3);
        cVar.aMr = false;
        cVar.aMs = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    @Override // com.baidu.live.gift.v
    protected void eS(String str) {
        if (this.aNU == null) {
            this.aNU = new com.baidu.live.gift.c.a();
        }
        this.aNU.fp(str);
    }

    @Override // com.baidu.live.gift.v
    protected void b(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        if (this.aNU == null) {
            this.aNU = new com.baidu.live.gift.c.a();
        }
        this.aNU.d(str, str2, str3, str4, 1, 0, "");
    }

    private void a(String str, long j, String str2, String str3, String str4, long j2) {
        if (eR(str) && !eV(str)) {
            if (BdNetTypeUtil.isWifiNet() || !k.Jk()) {
                if (this.aNO == null) {
                    this.aNO = new ArrayList<>();
                }
                this.aNO.add(new com.baidu.live.gift.a.c(str, j, null, str2, str4, str3, "", "", false, "", "", j2));
                com.baidu.live.gift.c fo = AH().fo(str);
                if (fo != null && fo.xu()) {
                    a.a(fo.aGg, false);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.v
    public void yS() {
        if (ListUtils.isEmpty(this.aNx)) {
            this.aNV = true;
            return;
        }
        Iterator<com.baidu.live.gift.c> it = this.aNx.iterator();
        while (it.hasNext()) {
            com.baidu.live.gift.c next = it.next();
            if (next != null && next.aGg != null && next.xu() && !AH().eP(next.getDynamicGiftId())) {
                com.baidu.live.gift.b bVar = next.aGg;
                if (bVar.aGe != null) {
                    a.a(bVar, false);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.v
    public void onDestroy() {
        this.aNV = false;
        MessageManager.getInstance().unRegisterListener(this.aNY);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aNT != null) {
            this.aNT.onDestroy();
            this.aNT = null;
        }
        if (this.aNQ != null) {
            this.aNQ.onDestroy();
            this.aNQ = null;
        }
        if (this.aNR != null) {
            this.aNR.onDestroy();
            this.aNR = null;
        }
        if (this.aNS != null) {
            this.aNS.onDestroy();
            this.aNS = null;
        }
        if (this.aNU != null) {
            this.aNU.release();
            this.aNU = null;
        }
        if (this.aNO != null) {
            this.aNO.clear();
        }
        a.AG();
        this.aKC.clear();
        this.aNx.clear();
    }
}
