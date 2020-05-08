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
import com.baidu.live.gift.giftList.a;
import com.baidu.live.gift.i;
import com.baidu.live.gift.l;
import com.baidu.live.gift.u;
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
import com.baidu.live.u.a;
import com.baidu.live.utils.k;
import com.baidu.live.utils.q;
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
public class b extends u {
    private static volatile b aFz;
    private ArrayList<g> aCz;
    private ArrayList<com.baidu.live.gift.a.c> aFA;
    private Map<String, com.baidu.live.gift.a.b> aFB;
    private com.baidu.live.gift.giftList.a aFC;
    private com.baidu.live.gift.giftList.b aFD;
    private com.baidu.live.k.c aFE;
    private c aFF;
    private com.baidu.live.gift.c.c aFG;
    private ArrayList<com.baidu.live.gift.c> aFo;
    private boolean aFH = false;
    private c.a aFI = new c.a() { // from class: com.baidu.live.gift.b.b.1
        @Override // com.baidu.live.gift.b.c.a
        public void b(int i, String str, int i2, Object obj, long j) {
            b.this.a(i, str, i2, obj, j);
        }
    };
    private a.InterfaceC0134a aFJ = new a.InterfaceC0134a() { // from class: com.baidu.live.gift.b.b.2
        @Override // com.baidu.live.gift.giftList.a.InterfaceC0134a
        public void i(ArrayList<com.baidu.live.gift.c> arrayList) {
            b.this.aFo.clear();
            if (!ListUtils.isEmpty(arrayList)) {
                b.this.aFo.addAll(arrayList);
                if (b.this.aFH && TbadkCoreApplication.isShownNetChangeDialog.booleanValue()) {
                    b.this.xc();
                }
            }
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.b.b.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Map.Entry entry;
            if (message.what == 100) {
                Set entrySet = b.this.aFB.entrySet();
                if (entrySet.isEmpty()) {
                    if (b.this.aFE != null) {
                        b.this.aFE.refreshCurUserScores();
                    }
                    return true;
                }
                if (b.this.aFF != null && !b.this.aFF.mIsSending && (entry = (Map.Entry) entrySet.iterator().next()) != null) {
                    b.this.aFF.a((com.baidu.live.gift.a.b) entry.getValue());
                    b.this.aFB.remove(entry.getKey());
                }
                b.this.mHandler.sendEmptyMessage(100);
            }
            return false;
        }
    });
    private CustomMessageListener aFK = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.f.c cVar;
            g ef;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.f.c) && !ListUtils.isEmpty(b.this.aFA) && (cVar = (com.baidu.live.f.c) customResponsedMessage.getData()) != null && cVar.axD != null && cVar.axC == 5) {
                String id = cVar.axD.getId();
                ArrayList arrayList = new ArrayList();
                Iterator it = b.this.aFA.iterator();
                while (it.hasNext()) {
                    com.baidu.live.gift.a.c cVar2 = (com.baidu.live.gift.a.c) it.next();
                    if (!TextUtils.isEmpty(cVar2.giftId) && cVar2.giftId.equals(id) && (ef = u.ef(cVar2.giftId)) != null) {
                        arrayList.add(cVar2);
                        b.this.a(cVar2.giftId, cVar2.aEh, ef.vV(), ef.vX(), cVar2.userId, cVar2.portrait, cVar2.userName, "", "", false, "", "", "", cVar2.aqw, cVar2.aqx, cVar2.msgId);
                    }
                }
                b.this.aFA.removeAll(arrayList);
            }
        }
    };

    public static b yS() {
        if (aFz == null) {
            synchronized (b.class) {
                if (aFz == null) {
                    aFz = new b();
                }
            }
        }
        return aFz;
    }

    private b() {
        a((u) this);
        this.aFo = new ArrayList<>();
        this.aCz = new ArrayList<>();
        this.aFB = new HashMap();
    }

    @Override // com.baidu.live.gift.u
    public void a(BdPageContext bdPageContext) {
        MessageManager.getInstance().registerListener(this.aFK);
        if (this.aFD == null) {
            this.aFD = new com.baidu.live.gift.giftList.b(bdPageContext);
        }
        if (this.aFC == null) {
            this.aFC = new com.baidu.live.gift.giftList.a(bdPageContext);
            this.aFC.a(this.aFJ);
        }
        yT();
        yU();
        if (this.aFF == null) {
            this.aFF = new c(bdPageContext);
            this.aFF.setUniqueId(BdUniqueId.gen());
        }
        this.aFF.initListener();
        this.aFF.a(this.aFI);
        if (this.aFE == null) {
            this.aFE = new com.baidu.live.k.c();
        }
        this.aFE.initListener();
        this.aFE.refreshCurUserScores();
    }

    private void yT() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = com.baidu.live.c.tG().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0;
        if (AlaLiveSwitchData.isHotLive == 0) {
            this.aFD.m(q.Gk(), z);
        }
    }

    private void yU() {
        this.aFC.loadData();
    }

    @Override // com.baidu.live.gift.u
    public String xa() {
        return q.Gk();
    }

    public void e(String str, ArrayList<i> arrayList) {
        if (!ListUtils.isEmpty(arrayList)) {
            if (this.aCz == null) {
                this.aCz = new ArrayList<>();
            }
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                i next = it.next();
                if (!ListUtils.isEmpty(next.wv())) {
                    d(str, next.wv());
                }
            }
        }
    }

    private void d(String str, List<g> list) {
        boolean z;
        if (!ListUtils.isEmpty(list)) {
            for (g gVar : list) {
                Iterator<g> it = this.aCz.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    g next = it.next();
                    if (next != null && !TextUtils.isEmpty(next.vU()) && next.vU().equals(gVar.vU())) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    gVar.setSceneFrom(str);
                    this.aCz.add(gVar);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.u
    public boolean ee(String str) {
        if (StringUtils.isNull(str) || ListUtils.isEmpty(this.aFo)) {
            return false;
        }
        for (int i = 0; i < this.aFo.size(); i++) {
            if (str.equals(this.aFo.get(i).getDynamicGiftId())) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.live.gift.c ey(String str) {
        if (!StringUtils.isNull(str) && !ListUtils.isEmpty(this.aFo)) {
            boolean z = UtilHelper.getRealScreenOrientation(TbadkCoreApplication.getInst().getContext()) == 2;
            for (int i = 0; i < this.aFo.size(); i++) {
                com.baidu.live.gift.c cVar = this.aFo.get(i);
                if (str.equals(cVar.getDynamicGiftId()) && z == cVar.isLandScapeZip()) {
                    return cVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.live.gift.u
    protected String eb(String str) {
        com.baidu.live.gift.c ey = yS().ey(str);
        if (ey == null || ey.ays == null || ey.ays.ayq == null) {
            return null;
        }
        return (com.baidu.live.alphavideo.a.tK().tL() && ey.ays.vB()) ? ey.ays.ayq.videoUrl : ey.ays.ayq.zipDownloadUrl;
    }

    @Override // com.baidu.live.gift.u
    public boolean ec(String str) {
        com.baidu.live.gift.c ey;
        if (StringUtils.isNull(str) || (ey = ey(str)) == null || ey.ays == null) {
            return false;
        }
        if (com.baidu.live.alphavideo.a.tK().tL() && ey.ays.vB() && !TextUtils.isEmpty(ey.vE())) {
            return true;
        }
        return ListUtils.isEmpty(ey.getDynamicGiftPicPathList()) ? false : true;
    }

    @Override // com.baidu.live.gift.u
    protected boolean ed(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return a.ab(str, eb(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, Object obj, long j) {
        if (i2 == 1 || i2 == 2) {
            if (i >= 0) {
                if (this.aFB != null && this.aFB.size() == 0) {
                    if (i == 0) {
                        if (i2 == 1) {
                            TbadkCoreApplication.getInst().currentAccountTdouNum = ((Long) obj).longValue();
                        } else {
                            TbadkCoreApplication.getInst().currentAccountFlowerNum = ((Long) obj).longValue();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                    } else if (this.aFE != null) {
                        this.aFE.refreshCurUserScores();
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
            if (gVar.wg()) {
                TiebaInitialize.log(new StatisticItem("c12792").param("obj_id", gVar.vU()).param("obj_param1", gVar.vY()).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, ec(gVar.vU()) ? 1 : 0));
            }
            a(gVar, j, str, str2, str3, str5, j2, j3);
        }
    }

    @Override // com.baidu.live.gift.u
    public void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        a(gVar, j, str, str2, str3, str4, str5, str6, str7, j2, currentTimeMillis);
        a(gVar, j, str, str2, str3, str4, str6, str7, currentTimeMillis);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4, long j2, long j3) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(gVar.vU(), j, gVar, currentAccountInfo.getID(), currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), currentAccountInfo.getLiveLevel(), currentAccountInfo.getSex(), "", -1, str3, "", false, str, str4, j2);
        cVar.azH = j3;
        cVar.Z(System.currentTimeMillis());
        cVar.aEc = true;
        com.baidu.live.gift.q.f(cVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    private String k(String str, String str2, String str3, String str4) {
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str4;
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, long j2) {
        if (this.aFF != null) {
            com.baidu.live.gift.a.b bVar = new com.baidu.live.gift.a.b(gVar, j, str, str2, str3, str4, str5, str6, gVar.vX(), j2);
            if (j == 1) {
                bVar.aAm = 0;
            } else {
                bVar.aAm = 1;
            }
            bVar.aEb.put(Long.valueOf(j2), Long.valueOf(j));
            if (this.aFF.mIsSending || !this.aFB.isEmpty()) {
                String k = k(str3, str, gVar.vU(), String.valueOf(j));
                com.baidu.live.gift.a.b bVar2 = this.aFB.get(k);
                if (bVar2 == null) {
                    this.aFB.put(k, bVar);
                } else {
                    bVar2.aEb.put(Long.valueOf(j2), Long.valueOf(j));
                    bVar2.aDZ += j;
                }
                this.mHandler.sendEmptyMessage(100);
                return;
            }
            this.aFF.a(bVar);
        }
    }

    @Override // com.baidu.live.gift.u
    public g ea(String str) {
        if (TextUtils.isEmpty(str) || this.aCz == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.aCz.size()) {
                return null;
            }
            g gVar = this.aCz.get(i2);
            if (!str.equals(gVar.vU())) {
                i = i2 + 1;
            } else {
                return gVar;
            }
        }
    }

    @Override // com.baidu.live.gift.u
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
            g ea = ea(str);
            if (ea == null) {
                String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount("last_send_get_gift_list_time");
                if (System.currentTimeMillis() - com.baidu.live.c.tG().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                    com.baidu.live.c.tG().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                }
                ea = new g();
                ea.dW(str);
                ea.setGiftName(str2);
                ea.dX("" + j);
                ea.setThumbnailUrl(str3);
                BdResourceLoader.getInstance().loadResource(ea.vX(), 10, null, BdUniqueId.gen());
            }
            com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, ea, str4, str5, str6, str7, str8, z, str9, str10, j2);
            cVar.Z(System.currentTimeMillis());
            cVar.aEc = false;
            cVar.bp(z3);
            cVar.aqw = str12;
            cVar.aqx = str13;
            if (com.baidu.live.v.a.En().aQu.ase && !TextUtils.isEmpty(str11)) {
                l lVar = new l();
                if (lVar.dY(str11)) {
                    cVar.aEd.ayY = lVar;
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.live.gift.u
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
                            g ea = ea(optString);
                            if (ea == null) {
                                String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount("last_send_get_gift_list_time");
                                if (System.currentTimeMillis() - com.baidu.live.c.tG().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                                    com.baidu.live.c.tG().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                                }
                                ea = new g();
                                ea.dW(optString);
                                ea.setGiftName(optString2);
                                ea.setThumbnailUrl(optString3);
                                BdResourceLoader.getInstance().loadResource(ea.vX(), 10, null, BdUniqueId.gen());
                            }
                            arrayList.add(ea);
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
                com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(gVar.vU(), j3, gVar, str2, str3, str4, str5, str6, z, str7, str8, j);
                cVar.Z(System.currentTimeMillis());
                cVar.aEc = false;
                cVar.bp(true);
                cVar.aqw = str10;
                cVar.aqx = str11;
                if (com.baidu.live.v.a.En().aQu.ase && !TextUtils.isEmpty(str9)) {
                    l lVar = new l();
                    if (lVar.dY(str9)) {
                        cVar.aEd.ayY = lVar;
                    }
                }
                if (arrayList.size() >= 2) {
                    com.baidu.live.gift.q.a(j, gVar.vU(), str2, str4, j3, j2);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
            }
        }
    }

    @Override // com.baidu.live.gift.u
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        g gVar = new g();
        gVar.dW(str);
        gVar.setGiftName(str2);
        gVar.dX("" + j);
        gVar.setThumbnailUrl(str3);
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2);
        cVar.Z(System.currentTimeMillis());
        cVar.aEc = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bp(z3);
        cVar.aEm = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    @Override // com.baidu.live.gift.u
    protected void xb() {
        if (this.aFG == null) {
            this.aFG = new com.baidu.live.gift.c.a();
        }
        this.aFG.zm();
    }

    @Override // com.baidu.live.gift.u
    protected void a(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        if (this.aFG == null) {
            this.aFG = new com.baidu.live.gift.c.a();
        }
        this.aFG.c(str, str2, str3, str4, 1, 0, "");
    }

    private void a(String str, long j, String str2, String str3, String str4, long j2) {
        if (ee(str) && !eg(str)) {
            if (BdNetTypeUtil.isWifiNet() || !k.Ge()) {
                if (this.aFA == null) {
                    this.aFA = new ArrayList<>();
                }
                this.aFA.add(new com.baidu.live.gift.a.c(str, j, null, str2, str4, str3, "", "", false, "", "", j2));
                com.baidu.live.gift.c ey = yS().ey(str);
                if (ey != null && ey.vD()) {
                    a.a(ey.ays, false);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.u
    public void xc() {
        if (ListUtils.isEmpty(this.aFo)) {
            this.aFH = true;
            return;
        }
        Iterator<com.baidu.live.gift.c> it = this.aFo.iterator();
        while (it.hasNext()) {
            com.baidu.live.gift.c next = it.next();
            if (next != null && next.ays != null && next.vD() && !yS().ec(next.getDynamicGiftId())) {
                com.baidu.live.gift.b bVar = next.ays;
                if (bVar.ayq != null) {
                    a.a(bVar, false);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.u
    public void onDestroy() {
        this.aFH = false;
        MessageManager.getInstance().unRegisterListener(this.aFK);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aFF != null) {
            this.aFF.onDestroy();
            this.aFF = null;
        }
        if (this.aFC != null) {
            this.aFC.onDestroy();
            this.aFC = null;
        }
        if (this.aFD != null) {
            this.aFD.onDestroy();
            this.aFD = null;
        }
        if (this.aFE != null) {
            this.aFE.onDestroy();
            this.aFE = null;
        }
        if (this.aFG != null) {
            this.aFG.release();
            this.aFG = null;
        }
        if (this.aFA != null) {
            this.aFA.clear();
        }
        a.yR();
        this.aCz.clear();
        this.aFo.clear();
    }
}
