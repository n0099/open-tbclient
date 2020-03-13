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
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.b.c;
import com.baidu.live.gift.g;
import com.baidu.live.gift.giftList.a;
import com.baidu.live.gift.i;
import com.baidu.live.gift.l;
import com.baidu.live.gift.t;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
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
public class b extends t {
    private static volatile b amR;
    private ArrayList<g> ajD;
    private ArrayList<com.baidu.live.gift.c> amG;
    private ArrayList<com.baidu.live.gift.a.c> amS;
    private Map<String, com.baidu.live.gift.a.b> amT;
    private com.baidu.live.gift.giftList.a amU;
    private com.baidu.live.gift.giftList.b amV;
    private com.baidu.live.k.c amW;
    private c amX;
    private com.baidu.live.gift.c.c amY;
    private boolean amZ = false;
    private c.a ana = new c.a() { // from class: com.baidu.live.gift.b.b.1
        @Override // com.baidu.live.gift.b.c.a
        public void b(int i, String str, int i2, Object obj, long j) {
            b.this.a(i, str, i2, obj, j);
        }
    };
    private a.InterfaceC0087a anb = new a.InterfaceC0087a() { // from class: com.baidu.live.gift.b.b.2
        @Override // com.baidu.live.gift.giftList.a.InterfaceC0087a
        public void i(ArrayList<com.baidu.live.gift.c> arrayList) {
            b.this.amG.clear();
            if (!ListUtils.isEmpty(arrayList)) {
                b.this.amG.addAll(arrayList);
                if (b.this.amZ && TbadkCoreApplication.isShownNetChangeDialog.booleanValue()) {
                    b.this.sF();
                }
            }
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.b.b.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Map.Entry entry;
            if (message.what == 100) {
                Set entrySet = b.this.amT.entrySet();
                if (entrySet.isEmpty()) {
                    if (b.this.amW != null) {
                        b.this.amW.refreshCurUserScores();
                    }
                    return true;
                }
                if (b.this.amX != null && !b.this.amX.mIsSending && (entry = (Map.Entry) entrySet.iterator().next()) != null) {
                    b.this.amX.a((com.baidu.live.gift.a.b) entry.getValue());
                    b.this.amT.remove(entry.getKey());
                }
                b.this.mHandler.sendEmptyMessage(100);
            }
            return false;
        }
    });
    private CustomMessageListener anc = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.f.c cVar;
            g dp;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.f.c) && !ListUtils.isEmpty(b.this.amS) && (cVar = (com.baidu.live.f.c) customResponsedMessage.getData()) != null && cVar.aeX != null && cVar.aeW == 5) {
                String id = cVar.aeX.getId();
                ArrayList arrayList = new ArrayList();
                Iterator it = b.this.amS.iterator();
                while (it.hasNext()) {
                    com.baidu.live.gift.a.c cVar2 = (com.baidu.live.gift.a.c) it.next();
                    if (!TextUtils.isEmpty(cVar2.giftId) && cVar2.giftId.equals(id) && (dp = t.dp(cVar2.giftId)) != null) {
                        arrayList.add(cVar2);
                        b.this.a(cVar2.giftId, cVar2.alB, dp.ry(), dp.rA(), cVar2.userId, cVar2.portrait, cVar2.userName, "", "", false, "", "", "", cVar2.XX, cVar2.XY);
                    }
                }
                b.this.amS.removeAll(arrayList);
            }
        }
    };

    public static b uu() {
        if (amR == null) {
            synchronized (b.class) {
                if (amR == null) {
                    amR = new b();
                }
            }
        }
        return amR;
    }

    private b() {
        a((t) this);
        this.amG = new ArrayList<>();
        this.ajD = new ArrayList<>();
        this.amT = new HashMap();
    }

    @Override // com.baidu.live.gift.t
    public void a(BdPageContext bdPageContext) {
        MessageManager.getInstance().registerListener(this.anc);
        if (this.amV == null) {
            this.amV = new com.baidu.live.gift.giftList.b(bdPageContext);
        }
        if (this.amU == null) {
            this.amU = new com.baidu.live.gift.giftList.a(bdPageContext);
            this.amU.a(this.anb);
        }
        uv();
        uw();
        if (this.amX == null) {
            this.amX = new c(bdPageContext);
            this.amX.setUniqueId(BdUniqueId.gen());
        }
        this.amX.initListener();
        this.amX.a(this.ana);
        if (this.amW == null) {
            this.amW = new com.baidu.live.k.c();
        }
        this.amW.initListener();
        this.amW.refreshCurUserScores();
    }

    private void uv() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = com.baidu.live.c.pr().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0;
        if (AlaLiveSwitchData.isHotLive == 0) {
            this.amV.i(q.Bg(), z);
        }
    }

    private void uw() {
        this.amU.loadData();
    }

    @Override // com.baidu.live.gift.t
    public String sD() {
        return q.Bg();
    }

    public void e(String str, ArrayList<i> arrayList) {
        if (!ListUtils.isEmpty(arrayList)) {
            if (this.ajD == null) {
                this.ajD = new ArrayList<>();
            }
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                i next = it.next();
                if (!ListUtils.isEmpty(next.rY())) {
                    d(str, next.rY());
                }
            }
        }
    }

    private void d(String str, List<g> list) {
        boolean z;
        if (!ListUtils.isEmpty(list)) {
            for (g gVar : list) {
                Iterator<g> it = this.ajD.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    g next = it.next();
                    if (next != null && !TextUtils.isEmpty(next.rx()) && next.rx().equals(gVar.rx())) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    gVar.setSceneFrom(str);
                    this.ajD.add(gVar);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.t
    /* renamed from: do  reason: not valid java name */
    public boolean mo19do(String str) {
        if (StringUtils.isNull(str) || ListUtils.isEmpty(this.amG)) {
            return false;
        }
        for (int i = 0; i < this.amG.size(); i++) {
            if (str.equals(this.amG.get(i).getDynamicGiftId())) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.live.gift.c dH(String str) {
        if (!StringUtils.isNull(str) && !ListUtils.isEmpty(this.amG)) {
            boolean z = UtilHelper.getRealScreenOrientation(TbadkCoreApplication.getInst().getContext()) == 2;
            for (int i = 0; i < this.amG.size(); i++) {
                com.baidu.live.gift.c cVar = this.amG.get(i);
                if (str.equals(cVar.getDynamicGiftId()) && z == cVar.isLandScapeZip()) {
                    return cVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.live.gift.t
    protected String dl(String str) {
        com.baidu.live.gift.c dH = uu().dH(str);
        if (dH == null || dH.afL == null || dH.afL.afJ == null) {
            return null;
        }
        return (com.baidu.live.alphavideo.a.pv().pw() && dH.afL.rf()) ? dH.afL.afJ.videoUrl : dH.afL.afJ.zipDownloadUrl;
    }

    @Override // com.baidu.live.gift.t
    public boolean dm(String str) {
        com.baidu.live.gift.c dH;
        if (StringUtils.isNull(str) || (dH = dH(str)) == null || dH.afL == null) {
            return false;
        }
        if (com.baidu.live.alphavideo.a.pv().pw() && dH.afL.rf() && !TextUtils.isEmpty(dH.ri())) {
            return true;
        }
        return ListUtils.isEmpty(dH.getDynamicGiftPicPathList()) ? false : true;
    }

    @Override // com.baidu.live.gift.t
    protected boolean dn(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return a.Y(str, dl(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, Object obj, long j) {
        if (i2 == 1 || i2 == 2) {
            if (i >= 0) {
                if (this.amT != null && this.amT.size() == 0) {
                    if (i == 0) {
                        if (i2 == 1) {
                            TbadkCoreApplication.getInst().currentAccountTdouNum = ((Long) obj).longValue();
                        } else {
                            TbadkCoreApplication.getInst().currentAccountFlowerNum = ((Long) obj).longValue();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                    } else if (this.amW != null) {
                        this.amW.refreshCurUserScores();
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

    public void c(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), TbadkCoreApplication.getInst().getContext().getResources().getString(a.i.sdk_no_network_guide));
        } else if (gVar != null) {
            if (gVar.rJ()) {
                TiebaInitialize.log(new StatisticItem("c12792").param("obj_id", gVar.rx()).param("obj_param1", gVar.rB()).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, dm(gVar.rx()) ? 1 : 0));
            }
            a(gVar, j, str, str2, str3, str5);
        }
    }

    @Override // com.baidu.live.gift.t
    public void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        c(gVar, j, str, str2, str3, str4, str5, str6, str7);
        a(gVar, j, str, str2, str3, str4, str6, str7);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(gVar.rx(), j, gVar, currentAccountInfo.getID(), currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), currentAccountInfo.getLiveLevel(), currentAccountInfo.getSex(), "", -1, str3, "", false, str, str4);
        cVar.B(System.currentTimeMillis());
        cVar.alw = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    private String k(String str, String str2, String str3, String str4) {
        return str + str2 + str3 + str4;
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6) {
        if (this.amX != null) {
            com.baidu.live.gift.a.b bVar = new com.baidu.live.gift.a.b(gVar, j, str, str2, str3, str4, str5, str6);
            if (j == 1) {
                bVar.ahC = 0;
            } else {
                bVar.ahC = 1;
            }
            if (this.amX.mIsSending || !this.amT.isEmpty()) {
                String k = k(str3, str, gVar.rx(), String.valueOf(j));
                com.baidu.live.gift.a.b bVar2 = this.amT.get(k);
                if (bVar2 == null) {
                    this.amT.put(k, bVar);
                } else {
                    bVar2.alu += j;
                }
                this.mHandler.sendEmptyMessage(100);
                return;
            }
            this.amX.a(bVar);
        }
    }

    @Override // com.baidu.live.gift.t
    public g dk(String str) {
        if (TextUtils.isEmpty(str) || this.ajD == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.ajD.size()) {
                return null;
            }
            g gVar = this.ajD.get(i2);
            if (!str.equals(gVar.rx())) {
                i = i2 + 1;
            } else {
                return gVar;
            }
        }
    }

    @Override // com.baidu.live.gift.t
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13) {
        a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, true, true, str12, str13);
    }

    public void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, String str12, String str13) {
        if (StringUtils.isNull(str4)) {
            if (z) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, str12, str13, str, "userId 为空");
            }
        } else if (!z2 || !str4.equals(TbadkCoreApplication.getCurrentAccount())) {
            a(str, j, str4, str6, str5);
            g dk = dk(str);
            if (dk == null) {
                String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount("last_send_get_gift_list_time");
                if (System.currentTimeMillis() - com.baidu.live.c.pr().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                    com.baidu.live.c.pr().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                }
                dk = new g();
                dk.dg(str);
                dk.setGiftName(str2);
                dk.dh("" + j);
                dk.setThumbnailUrl(str3);
                BdResourceLoader.getInstance().loadResource(dk.rA(), 10, null, BdUniqueId.gen());
            }
            com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, dk, str4, str5, str6, str7, str8, z, str9, str10);
            cVar.B(System.currentTimeMillis());
            cVar.alw = false;
            cVar.aN(z3);
            cVar.XX = str12;
            cVar.XY = str13;
            if (com.baidu.live.v.a.zl().awC.Zz && !TextUtils.isEmpty(str11)) {
                l lVar = new l();
                if (lVar.di(str11)) {
                    cVar.alx.ags = lVar;
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
        }
    }

    @Override // com.baidu.live.gift.t
    protected void a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11) {
        if (!StringUtils.isNull(str2) && !str2.equals(TbadkCoreApplication.getCurrentAccount())) {
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
                        int optInt = jSONObject.optInt("gift_count");
                        String optString3 = jSONObject.optString("gift_url");
                        g dk = dk(optString);
                        if (dk == null) {
                            String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount("last_send_get_gift_list_time");
                            if (System.currentTimeMillis() - com.baidu.live.c.pr().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                                com.baidu.live.c.pr().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                            }
                            dk = new g();
                            dk.dg(optString);
                            dk.setGiftName(optString2);
                            dk.setThumbnailUrl(optString3);
                            BdResourceLoader.getInstance().loadResource(dk.rA(), 10, null, BdUniqueId.gen());
                        }
                        dk.dh("" + optInt);
                        arrayList.add(dk);
                        i = i2 + 1;
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (!ListUtils.isEmpty(arrayList)) {
                long j = 0;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= arrayList.size()) {
                        break;
                    }
                    j += JavaTypesHelper.toLong(((g) arrayList.get(i4)).rB(), 0L);
                    i3 = i4 + 1;
                }
                g gVar = (g) arrayList.get(0);
                com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(gVar.rx(), j, gVar, str2, str3, str4, str5, str6, z, str7, str8);
                cVar.B(System.currentTimeMillis());
                cVar.alw = false;
                cVar.aN(true);
                cVar.XX = str10;
                cVar.XY = str11;
                if (com.baidu.live.v.a.zl().awC.Zz && !TextUtils.isEmpty(str9)) {
                    l lVar = new l();
                    if (lVar.di(str9)) {
                        cVar.alx.ags = lVar;
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
            }
        }
    }

    @Override // com.baidu.live.gift.t
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4) {
        g gVar = new g();
        gVar.dg(str);
        gVar.setGiftName(str2);
        gVar.dh("" + j);
        gVar.setThumbnailUrl(str3);
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10);
        cVar.B(System.currentTimeMillis());
        cVar.alw = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.aN(z3);
        cVar.alG = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    @Override // com.baidu.live.gift.t
    protected void sE() {
        if (this.amY == null) {
            this.amY = new com.baidu.live.gift.c.a();
        }
        this.amY.uN();
    }

    @Override // com.baidu.live.gift.t
    protected void a(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        if (this.amY == null) {
            this.amY = new com.baidu.live.gift.c.a();
        }
        this.amY.c(str, str2, str3, str4, 1, 0, "");
    }

    private void a(String str, long j, String str2, String str3, String str4) {
        if (mo19do(str) && !dq(str)) {
            if (BdNetTypeUtil.isWifiNet() || !k.Ba()) {
                if (this.amS == null) {
                    this.amS = new ArrayList<>();
                }
                this.amS.add(new com.baidu.live.gift.a.c(str, j, null, str2, str4, str3, "", "", false, "", ""));
                com.baidu.live.gift.c dH = uu().dH(str);
                if (dH != null && dH.rh()) {
                    a.a(dH.afL, false);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.t
    public void sF() {
        if (ListUtils.isEmpty(this.amG)) {
            this.amZ = true;
            return;
        }
        Iterator<com.baidu.live.gift.c> it = this.amG.iterator();
        while (it.hasNext()) {
            com.baidu.live.gift.c next = it.next();
            if (next != null && next.afL != null && next.rh() && !uu().dm(next.getDynamicGiftId())) {
                com.baidu.live.gift.b bVar = next.afL;
                if (bVar.afJ != null) {
                    a.a(bVar, false);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.t
    public void onDestroy() {
        this.amZ = false;
        MessageManager.getInstance().unRegisterListener(this.anc);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.amX != null) {
            this.amX.onDestroy();
            this.amX = null;
        }
        if (this.amU != null) {
            this.amU.onDestroy();
            this.amU = null;
        }
        if (this.amV != null) {
            this.amV.onDestroy();
            this.amV = null;
        }
        if (this.amW != null) {
            this.amW.onDestroy();
            this.amW = null;
        }
        if (this.amY != null) {
            this.amY.release();
            this.amY = null;
        }
        if (this.amS != null) {
            this.amS.clear();
        }
        a.ut();
        this.ajD.clear();
        this.amG.clear();
    }
}
