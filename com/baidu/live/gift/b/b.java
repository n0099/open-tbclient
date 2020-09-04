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
/* loaded from: classes7.dex */
public class b extends v {
    private static volatile b aUy;
    private ArrayList<g> aRn;
    private Map<String, com.baidu.live.gift.a.b> aUA;
    private com.baidu.live.gift.giftList.b aUB;
    private com.baidu.live.gift.giftList.c aUC;
    private com.baidu.live.l.c aUD;
    private c aUE;
    private com.baidu.live.gift.c.c aUF;
    private ArrayList<com.baidu.live.gift.c> aUi;
    private ArrayList<com.baidu.live.gift.a.c> aUz;
    private boolean aUG = false;
    private c.a aUH = new c.a() { // from class: com.baidu.live.gift.b.b.1
        @Override // com.baidu.live.gift.b.c.a
        public void b(int i, String str, int i2, Object obj, long j) {
            b.this.a(i, str, i2, obj, j);
        }
    };
    private b.a aUI = new b.a() { // from class: com.baidu.live.gift.b.b.2
        @Override // com.baidu.live.gift.giftList.b.a
        public void n(ArrayList<com.baidu.live.gift.c> arrayList) {
            b.this.aUi.clear();
            if (!ListUtils.isEmpty(arrayList)) {
                b.this.aUi.addAll(arrayList);
                if (b.this.aUG) {
                    b.this.EX();
                }
            }
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.b.b.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Map.Entry entry;
            if (message.what == 100) {
                Set entrySet = b.this.aUA.entrySet();
                if (entrySet.isEmpty()) {
                    if (b.this.aUD != null) {
                        b.this.aUD.refreshCurUserScores();
                    }
                    return true;
                }
                if (b.this.aUE != null && !b.this.aUE.mIsSending && (entry = (Map.Entry) entrySet.iterator().next()) != null) {
                    b.this.aUE.a((com.baidu.live.gift.a.b) entry.getValue());
                    b.this.aUA.remove(entry.getKey());
                }
                b.this.mHandler.sendEmptyMessage(100);
            }
            return false;
        }
    });
    private CustomMessageListener aUJ = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.f.c cVar;
            g go;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.f.c) && !ListUtils.isEmpty(b.this.aUz) && (cVar = (com.baidu.live.f.c) customResponsedMessage.getData()) != null && cVar.aLS != null && cVar.aLR == 5) {
                String id = cVar.aLS.getId();
                ArrayList arrayList = new ArrayList();
                Iterator it = b.this.aUz.iterator();
                while (it.hasNext()) {
                    com.baidu.live.gift.a.c cVar2 = (com.baidu.live.gift.a.c) it.next();
                    if (!TextUtils.isEmpty(cVar2.giftId) && cVar2.giftId.equals(id) && (go = v.go(cVar2.giftId)) != null) {
                        arrayList.add(cVar2);
                        b.this.a(cVar2.giftId, cVar2.aSW, go.DS(), go.getThumbnail_url(), cVar2.userId, cVar2.portrait, cVar2.userName, "", "", false, "", "", "", cVar2.aDY, cVar2.aDZ, cVar2.msgId);
                    }
                }
                b.this.aUz.removeAll(arrayList);
            }
        }
    };

    public static b GM() {
        if (aUy == null) {
            synchronized (b.class) {
                if (aUy == null) {
                    aUy = new b();
                }
            }
        }
        return aUy;
    }

    private b() {
        a((v) this);
        this.aUi = new ArrayList<>();
        this.aRn = new ArrayList<>();
        this.aUA = new HashMap();
    }

    @Override // com.baidu.live.gift.v
    public void a(BdPageContext bdPageContext, boolean z) {
        MessageManager.getInstance().registerListener(this.aUJ);
        if (this.aUC == null) {
            this.aUC = new com.baidu.live.gift.giftList.c(bdPageContext);
        }
        if (this.aUB == null) {
            this.aUB = new com.baidu.live.gift.giftList.b(bdPageContext);
            this.aUB.a(this.aUI);
        }
        GN();
        bH(z);
        if (this.aUE == null) {
            this.aUE = new c(bdPageContext);
            this.aUE.setUniqueId(BdUniqueId.gen());
        }
        this.aUE.initListener();
        this.aUE.a(this.aUH);
        if (this.aUD == null) {
            this.aUD = new com.baidu.live.l.c();
        }
        this.aUD.initListener();
        this.aUD.refreshCurUserScores();
    }

    private void GN() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = com.baidu.live.c.AD().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0;
        if (AlaLiveSwitchData.isHotLive == 0) {
            this.aUC.a(p.Pp(), z, "enter", "gift_init");
        }
    }

    private void bH(boolean z) {
        this.aUB.setHost(z);
        this.aUB.loadData();
    }

    @Override // com.baidu.live.gift.v
    public String EW() {
        return p.Pp();
    }

    public void e(String str, ArrayList<i> arrayList) {
        if (!ListUtils.isEmpty(arrayList)) {
            if (this.aRn == null) {
                this.aRn = new ArrayList<>();
            }
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                i next = it.next();
                if (!ListUtils.isEmpty(next.Er())) {
                    c(str, next.Er());
                }
            }
        }
    }

    private void c(String str, List<g> list) {
        boolean z;
        if (!ListUtils.isEmpty(list)) {
            for (g gVar : list) {
                Iterator<g> it = this.aRn.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    g next = it.next();
                    if (next != null && !TextUtils.isEmpty(next.DR()) && next.DR().equals(gVar.DR())) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    gVar.setSceneFrom(str);
                    this.aRn.add(gVar);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.v
    public boolean gl(String str) {
        if (StringUtils.isNull(str) || ListUtils.isEmpty(this.aUi)) {
            return false;
        }
        for (int i = 0; i < this.aUi.size(); i++) {
            if (str.equals(this.aUi.get(i).getDynamicGiftId())) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.live.gift.c gJ(String str) {
        if (!StringUtils.isNull(str) && !ListUtils.isEmpty(this.aUi)) {
            boolean z = UtilHelper.getRealScreenOrientation(TbadkCoreApplication.getInst().getContext()) == 2;
            for (int i = 0; i < this.aUi.size(); i++) {
                com.baidu.live.gift.c cVar = this.aUi.get(i);
                if (str.equals(cVar.getDynamicGiftId()) && z == cVar.isLandScapeZip()) {
                    return cVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.live.gift.v
    protected String gi(String str) {
        com.baidu.live.gift.c gJ = GM().gJ(str);
        if (gJ == null || gJ.aMN == null || gJ.aMN.aML == null) {
            return null;
        }
        return (com.baidu.live.alphavideo.a.AH().AI() && gJ.aMN.Dx()) ? gJ.aMN.aML.videoUrl : gJ.aMN.aML.zipDownloadUrl;
    }

    @Override // com.baidu.live.gift.v
    public boolean gj(String str) {
        com.baidu.live.gift.c gJ;
        if (StringUtils.isNull(str) || (gJ = gJ(str)) == null || gJ.aMN == null) {
            return false;
        }
        if (com.baidu.live.alphavideo.a.AH().AI() && gJ.aMN.Dx() && !TextUtils.isEmpty(gJ.DA())) {
            return true;
        }
        return ListUtils.isEmpty(gJ.getDynamicGiftPicPathList()) ? false : true;
    }

    @Override // com.baidu.live.gift.v
    protected boolean gk(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return a.ar(str, gi(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, Object obj, long j) {
        if (i2 == 1 || i2 == 2) {
            if (i >= 0) {
                if (this.aUA != null && this.aUA.size() == 0) {
                    if (i == 0) {
                        if (i2 == 1) {
                            TbadkCoreApplication.getInst().currentAccountTdouNum = ((Long) obj).longValue();
                        } else {
                            TbadkCoreApplication.getInst().currentAccountFlowerNum = ((Long) obj).longValue();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                    } else if (this.aUD != null) {
                        this.aUD.refreshCurUserScores();
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
            if (gVar.Ec()) {
                TiebaInitialize.log(new StatisticItem("c12792").param("obj_id", gVar.DR()).param("obj_param1", gVar.DU()).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, gj(gVar.DR()) ? 1 : 0));
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
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(gVar.DR(), j, gVar, currentAccountInfo.getID(), currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), currentAccountInfo.getLiveLevel(), currentAccountInfo.getSex(), "", -1, str3, "", false, str, str4, j2);
        cVar.aOd = j3;
        cVar.ae(System.currentTimeMillis());
        cVar.aSR = true;
        r.f(cVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    private String l(String str, String str2, String str3, String str4) {
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str4;
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, long j2) {
        if (this.aUE != null) {
            com.baidu.live.gift.a.b bVar = new com.baidu.live.gift.a.b(gVar, j, str, str2, str3, str4, str5, str6, gVar.getThumbnail_url(), j2);
            if (j == 1) {
                bVar.aOL = 0;
            } else {
                bVar.aOL = 1;
            }
            bVar.aSQ.put(Long.valueOf(j2), Long.valueOf(j));
            if (this.aUE.mIsSending || !this.aUA.isEmpty()) {
                String l = l(str3, str, gVar.DR(), String.valueOf(j));
                com.baidu.live.gift.a.b bVar2 = this.aUA.get(l);
                if (bVar2 == null) {
                    this.aUA.put(l, bVar);
                } else {
                    bVar2.aSQ.put(Long.valueOf(j2), Long.valueOf(j));
                    bVar2.aSO += j;
                }
                this.mHandler.sendEmptyMessage(100);
                return;
            }
            this.aUE.a(bVar);
        }
    }

    @Override // com.baidu.live.gift.v
    public g gh(String str) {
        if (TextUtils.isEmpty(str) || this.aRn == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.aRn.size()) {
                return null;
            }
            g gVar = this.aRn.get(i2);
            if (!str.equals(gVar.DR())) {
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
            g gh = gh(str);
            if (gh == null) {
                String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount("last_send_get_gift_list_time");
                if (System.currentTimeMillis() - com.baidu.live.c.AD().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                    com.baidu.live.c.AD().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                }
                gh = new g();
                gh.gd(str);
                gh.setGiftName(str2);
                gh.ge("" + j);
                gh.setThumbnailUrl(str3);
                BdResourceLoader.getInstance().loadResource(gh.getThumbnail_url(), 10, null, BdUniqueId.gen());
            }
            com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, gh, str4, str5, str6, str7, str8, z, str9, str10, j2);
            cVar.ae(System.currentTimeMillis());
            cVar.aSR = false;
            cVar.bF(z3);
            cVar.aDY = str12;
            cVar.aDZ = str13;
            if (com.baidu.live.w.a.Nk().beJ.aFN && !TextUtils.isEmpty(str11)) {
                l lVar = new l();
                if (lVar.gf(str11)) {
                    cVar.aSS.aNu = lVar;
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
                            g gh = gh(optString);
                            if (gh == null) {
                                String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount("last_send_get_gift_list_time");
                                if (System.currentTimeMillis() - com.baidu.live.c.AD().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                                    com.baidu.live.c.AD().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                                }
                                gh = new g();
                                gh.gd(optString);
                                gh.setGiftName(optString2);
                                gh.setThumbnailUrl(optString3);
                                BdResourceLoader.getInstance().loadResource(gh.getThumbnail_url(), 10, null, BdUniqueId.gen());
                            }
                            arrayList.add(gh);
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
                com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(gVar.DR(), j3, gVar, str2, str3, str4, str5, str6, z, str7, str8, j);
                cVar.ae(System.currentTimeMillis());
                cVar.aSR = false;
                cVar.bF(true);
                cVar.aDY = str10;
                cVar.aDZ = str11;
                if (com.baidu.live.w.a.Nk().beJ.aFN && !TextUtils.isEmpty(str9)) {
                    l lVar = new l();
                    if (lVar.gf(str9)) {
                        cVar.aSS.aNu = lVar;
                    }
                }
                if (arrayList.size() >= 2) {
                    r.a(j, gVar.DR(), str2, str4, j3, j2);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
            }
        }
    }

    @Override // com.baidu.live.gift.v
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        g gVar = new g();
        gVar.gd(str);
        gVar.setGiftName(str2);
        gVar.ge("" + j);
        gVar.setThumbnailUrl(str3);
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2);
        cVar.ae(System.currentTimeMillis());
        cVar.aSR = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bF(z3);
        cVar.aTb = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    @Override // com.baidu.live.gift.v
    protected void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        g gVar = new g();
        gVar.gd(str);
        gVar.setGiftName(str2);
        gVar.ge("" + j);
        gVar.setThumbnailUrl(str3);
        a(str, j, str4, str6, str5, j2);
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2);
        cVar.ae(System.currentTimeMillis());
        cVar.aSR = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bF(z3);
        cVar.aTb = false;
        cVar.aTc = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    @Override // com.baidu.live.gift.v
    protected void gm(String str) {
        if (this.aUF == null) {
            this.aUF = new com.baidu.live.gift.c.a();
        }
        this.aUF.gK(str);
    }

    @Override // com.baidu.live.gift.v
    protected void b(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        if (this.aUF == null) {
            this.aUF = new com.baidu.live.gift.c.a();
        }
        this.aUF.a(str, "", str2, str3, str4, 1, 0, "", System.currentTimeMillis());
    }

    private void a(String str, long j, String str2, String str3, String str4, long j2) {
        if (gl(str) && !gp(str)) {
            if (BdNetTypeUtil.isWifiNet() || !k.Pj()) {
                if (this.aUz == null) {
                    this.aUz = new ArrayList<>();
                }
                this.aUz.add(new com.baidu.live.gift.a.c(str, j, null, str2, str4, str3, "", "", false, "", "", j2));
                com.baidu.live.gift.c gJ = GM().gJ(str);
                if (gJ != null && gJ.Dz()) {
                    a.a(gJ.aMN, false);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.v
    public void EX() {
        if (ListUtils.isEmpty(this.aUi)) {
            this.aUG = true;
            return;
        }
        Iterator<com.baidu.live.gift.c> it = this.aUi.iterator();
        while (it.hasNext()) {
            com.baidu.live.gift.c next = it.next();
            if (next != null && next.aMN != null && next.Dz() && !GM().gj(next.getDynamicGiftId())) {
                com.baidu.live.gift.b bVar = next.aMN;
                if (bVar.aML != null) {
                    a.a(bVar, false);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.v
    public void onDestroy() {
        this.aUG = false;
        MessageManager.getInstance().unRegisterListener(this.aUJ);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aUE != null) {
            this.aUE.onDestroy();
            this.aUE = null;
        }
        if (this.aUB != null) {
            this.aUB.onDestroy();
            this.aUB = null;
        }
        if (this.aUC != null) {
            this.aUC.onDestroy();
            this.aUC = null;
        }
        if (this.aUD != null) {
            this.aUD.onDestroy();
            this.aUD = null;
        }
        if (this.aUF != null) {
            this.aUF.release();
            this.aUF = null;
        }
        if (this.aUz != null) {
            this.aUz.clear();
        }
        a.GL();
        this.aRn.clear();
        this.aUi.clear();
    }
}
