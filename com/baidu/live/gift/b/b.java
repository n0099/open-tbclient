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
public class b extends v {
    private static volatile b aLh;
    private ArrayList<g> aHY;
    private ArrayList<com.baidu.live.gift.c> aKR;
    private ArrayList<com.baidu.live.gift.a.c> aLi;
    private Map<String, com.baidu.live.gift.a.b> aLj;
    private com.baidu.live.gift.giftList.b aLk;
    private com.baidu.live.gift.giftList.c aLl;
    private com.baidu.live.k.c aLm;
    private c aLn;
    private com.baidu.live.gift.c.c aLo;
    private boolean aLp = false;
    private c.a aLq = new c.a() { // from class: com.baidu.live.gift.b.b.1
        @Override // com.baidu.live.gift.b.c.a
        public void b(int i, String str, int i2, Object obj, long j) {
            b.this.a(i, str, i2, obj, j);
        }
    };
    private b.a aLr = new b.a() { // from class: com.baidu.live.gift.b.b.2
        @Override // com.baidu.live.gift.giftList.b.a
        public void i(ArrayList<com.baidu.live.gift.c> arrayList) {
            b.this.aKR.clear();
            if (!ListUtils.isEmpty(arrayList)) {
                b.this.aKR.addAll(arrayList);
                if (b.this.aLp) {
                    b.this.ys();
                }
            }
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.b.b.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Map.Entry entry;
            if (message.what == 100) {
                Set entrySet = b.this.aLj.entrySet();
                if (entrySet.isEmpty()) {
                    if (b.this.aLm != null) {
                        b.this.aLm.refreshCurUserScores();
                    }
                    return true;
                }
                if (b.this.aLn != null && !b.this.aLn.mIsSending && (entry = (Map.Entry) entrySet.iterator().next()) != null) {
                    b.this.aLn.a((com.baidu.live.gift.a.b) entry.getValue());
                    b.this.aLj.remove(entry.getKey());
                }
                b.this.mHandler.sendEmptyMessage(100);
            }
            return false;
        }
    });
    private CustomMessageListener aLs = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.f.c cVar;
            g eO;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.f.c) && !ListUtils.isEmpty(b.this.aLi) && (cVar = (com.baidu.live.f.c) customResponsedMessage.getData()) != null && cVar.aCT != null && cVar.aCS == 5) {
                String id = cVar.aCT.getId();
                ArrayList arrayList = new ArrayList();
                Iterator it = b.this.aLi.iterator();
                while (it.hasNext()) {
                    com.baidu.live.gift.a.c cVar2 = (com.baidu.live.gift.a.c) it.next();
                    if (!TextUtils.isEmpty(cVar2.giftId) && cVar2.giftId.equals(id) && (eO = v.eO(cVar2.giftId)) != null) {
                        arrayList.add(cVar2);
                        b.this.a(cVar2.giftId, cVar2.aJG, eO.xm(), eO.xo(), cVar2.userId, cVar2.portrait, cVar2.userName, "", "", false, "", "", "", cVar2.avv, cVar2.avw, cVar2.msgId);
                    }
                }
                b.this.aLi.removeAll(arrayList);
            }
        }
    };

    public static b Ah() {
        if (aLh == null) {
            synchronized (b.class) {
                if (aLh == null) {
                    aLh = new b();
                }
            }
        }
        return aLh;
    }

    private b() {
        a((v) this);
        this.aKR = new ArrayList<>();
        this.aHY = new ArrayList<>();
        this.aLj = new HashMap();
    }

    @Override // com.baidu.live.gift.v
    public void a(BdPageContext bdPageContext, boolean z) {
        MessageManager.getInstance().registerListener(this.aLs);
        if (this.aLl == null) {
            this.aLl = new com.baidu.live.gift.giftList.c(bdPageContext);
        }
        if (this.aLk == null) {
            this.aLk = new com.baidu.live.gift.giftList.b(bdPageContext);
            this.aLk.a(this.aLr);
        }
        Ai();
        bz(z);
        if (this.aLn == null) {
            this.aLn = new c(bdPageContext);
            this.aLn.setUniqueId(BdUniqueId.gen());
        }
        this.aLn.initListener();
        this.aLn.a(this.aLq);
        if (this.aLm == null) {
            this.aLm = new com.baidu.live.k.c();
        }
        this.aLm.initListener();
        this.aLm.refreshCurUserScores();
    }

    private void Ai() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = com.baidu.live.c.uN().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0;
        if (AlaLiveSwitchData.isHotLive == 0) {
            this.aLl.a(q.Id(), z, "enter", "gift_init");
        }
    }

    private void bz(boolean z) {
        this.aLk.setHost(z);
        this.aLk.loadData();
    }

    @Override // com.baidu.live.gift.v
    public String yr() {
        return q.Id();
    }

    public void e(String str, ArrayList<i> arrayList) {
        if (!ListUtils.isEmpty(arrayList)) {
            if (this.aHY == null) {
                this.aHY = new ArrayList<>();
            }
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                i next = it.next();
                if (!ListUtils.isEmpty(next.xM())) {
                    c(str, next.xM());
                }
            }
        }
    }

    private void c(String str, List<g> list) {
        boolean z;
        if (!ListUtils.isEmpty(list)) {
            for (g gVar : list) {
                Iterator<g> it = this.aHY.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    g next = it.next();
                    if (next != null && !TextUtils.isEmpty(next.xl()) && next.xl().equals(gVar.xl())) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    gVar.setSceneFrom(str);
                    this.aHY.add(gVar);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.v
    public boolean eL(String str) {
        if (StringUtils.isNull(str) || ListUtils.isEmpty(this.aKR)) {
            return false;
        }
        for (int i = 0; i < this.aKR.size(); i++) {
            if (str.equals(this.aKR.get(i).getDynamicGiftId())) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.live.gift.c fi(String str) {
        if (!StringUtils.isNull(str) && !ListUtils.isEmpty(this.aKR)) {
            boolean z = UtilHelper.getRealScreenOrientation(TbadkCoreApplication.getInst().getContext()) == 2;
            for (int i = 0; i < this.aKR.size(); i++) {
                com.baidu.live.gift.c cVar = this.aKR.get(i);
                if (str.equals(cVar.getDynamicGiftId()) && z == cVar.isLandScapeZip()) {
                    return cVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.live.gift.v
    protected String eI(String str) {
        com.baidu.live.gift.c fi = Ah().fi(str);
        if (fi == null || fi.aDK == null || fi.aDK.aDI == null) {
            return null;
        }
        return (com.baidu.live.alphavideo.a.uR().uS() && fi.aDK.wR()) ? fi.aDK.aDI.videoUrl : fi.aDK.aDI.zipDownloadUrl;
    }

    @Override // com.baidu.live.gift.v
    public boolean eJ(String str) {
        com.baidu.live.gift.c fi;
        if (StringUtils.isNull(str) || (fi = fi(str)) == null || fi.aDK == null) {
            return false;
        }
        if (com.baidu.live.alphavideo.a.uR().uS() && fi.aDK.wR() && !TextUtils.isEmpty(fi.wU())) {
            return true;
        }
        return ListUtils.isEmpty(fi.getDynamicGiftPicPathList()) ? false : true;
    }

    @Override // com.baidu.live.gift.v
    protected boolean eK(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return a.an(str, eI(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, Object obj, long j) {
        if (i2 == 1 || i2 == 2) {
            if (i >= 0) {
                if (this.aLj != null && this.aLj.size() == 0) {
                    if (i == 0) {
                        if (i2 == 1) {
                            TbadkCoreApplication.getInst().currentAccountTdouNum = ((Long) obj).longValue();
                        } else {
                            TbadkCoreApplication.getInst().currentAccountFlowerNum = ((Long) obj).longValue();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                    } else if (this.aLm != null) {
                        this.aLm.refreshCurUserScores();
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
            if (gVar.xx()) {
                TiebaInitialize.log(new StatisticItem("c12792").param("obj_id", gVar.xl()).param("obj_param1", gVar.xp()).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, eJ(gVar.xl()) ? 1 : 0));
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
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(gVar.xl(), j, gVar, currentAccountInfo.getID(), currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), currentAccountInfo.getLiveLevel(), currentAccountInfo.getSex(), "", -1, str3, "", false, str, str4, j2);
        cVar.aEZ = j3;
        cVar.ad(System.currentTimeMillis());
        cVar.aJB = true;
        r.f(cVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    private String l(String str, String str2, String str3, String str4) {
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str4;
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, long j2) {
        if (this.aLn != null) {
            com.baidu.live.gift.a.b bVar = new com.baidu.live.gift.a.b(gVar, j, str, str2, str3, str4, str5, str6, gVar.xo(), j2);
            if (j == 1) {
                bVar.aFF = 0;
            } else {
                bVar.aFF = 1;
            }
            bVar.aJA.put(Long.valueOf(j2), Long.valueOf(j));
            if (this.aLn.mIsSending || !this.aLj.isEmpty()) {
                String l = l(str3, str, gVar.xl(), String.valueOf(j));
                com.baidu.live.gift.a.b bVar2 = this.aLj.get(l);
                if (bVar2 == null) {
                    this.aLj.put(l, bVar);
                } else {
                    bVar2.aJA.put(Long.valueOf(j2), Long.valueOf(j));
                    bVar2.aJy += j;
                }
                this.mHandler.sendEmptyMessage(100);
                return;
            }
            this.aLn.a(bVar);
        }
    }

    @Override // com.baidu.live.gift.v
    public g eH(String str) {
        if (TextUtils.isEmpty(str) || this.aHY == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.aHY.size()) {
                return null;
            }
            g gVar = this.aHY.get(i2);
            if (!str.equals(gVar.xl())) {
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
            g eH = eH(str);
            if (eH == null) {
                String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount("last_send_get_gift_list_time");
                if (System.currentTimeMillis() - com.baidu.live.c.uN().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                    com.baidu.live.c.uN().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                }
                eH = new g();
                eH.eD(str);
                eH.setGiftName(str2);
                eH.eE("" + j);
                eH.setThumbnailUrl(str3);
                BdResourceLoader.getInstance().loadResource(eH.xo(), 10, null, BdUniqueId.gen());
            }
            com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, eH, str4, str5, str6, str7, str8, z, str9, str10, j2);
            cVar.ad(System.currentTimeMillis());
            cVar.aJB = false;
            cVar.bx(z3);
            cVar.avv = str12;
            cVar.avw = str13;
            if (com.baidu.live.v.a.Ge().aWF.axf && !TextUtils.isEmpty(str11)) {
                l lVar = new l();
                if (lVar.eF(str11)) {
                    cVar.aJC.aEq = lVar;
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
                            g eH = eH(optString);
                            if (eH == null) {
                                String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount("last_send_get_gift_list_time");
                                if (System.currentTimeMillis() - com.baidu.live.c.uN().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                                    com.baidu.live.c.uN().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                                }
                                eH = new g();
                                eH.eD(optString);
                                eH.setGiftName(optString2);
                                eH.setThumbnailUrl(optString3);
                                BdResourceLoader.getInstance().loadResource(eH.xo(), 10, null, BdUniqueId.gen());
                            }
                            arrayList.add(eH);
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
                com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(gVar.xl(), j3, gVar, str2, str3, str4, str5, str6, z, str7, str8, j);
                cVar.ad(System.currentTimeMillis());
                cVar.aJB = false;
                cVar.bx(true);
                cVar.avv = str10;
                cVar.avw = str11;
                if (com.baidu.live.v.a.Ge().aWF.axf && !TextUtils.isEmpty(str9)) {
                    l lVar = new l();
                    if (lVar.eF(str9)) {
                        cVar.aJC.aEq = lVar;
                    }
                }
                if (arrayList.size() >= 2) {
                    r.a(j, gVar.xl(), str2, str4, j3, j2);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
            }
        }
    }

    @Override // com.baidu.live.gift.v
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        g gVar = new g();
        gVar.eD(str);
        gVar.setGiftName(str2);
        gVar.eE("" + j);
        gVar.setThumbnailUrl(str3);
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2);
        cVar.ad(System.currentTimeMillis());
        cVar.aJB = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bx(z3);
        cVar.aJL = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    @Override // com.baidu.live.gift.v
    protected void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        g gVar = new g();
        gVar.eD(str);
        gVar.setGiftName(str2);
        gVar.eE("" + j);
        gVar.setThumbnailUrl(str3);
        a(str, j, str4, str6, str5, j2);
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2);
        cVar.ad(System.currentTimeMillis());
        cVar.aJB = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bx(z3);
        cVar.aJL = false;
        cVar.aJM = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    @Override // com.baidu.live.gift.v
    protected void eM(String str) {
        if (this.aLo == null) {
            this.aLo = new com.baidu.live.gift.c.a();
        }
        this.aLo.fj(str);
    }

    @Override // com.baidu.live.gift.v
    protected void b(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        if (this.aLo == null) {
            this.aLo = new com.baidu.live.gift.c.a();
        }
        this.aLo.d(str, str2, str3, str4, 1, 0, "");
    }

    private void a(String str, long j, String str2, String str3, String str4, long j2) {
        if (eL(str) && !eP(str)) {
            if (BdNetTypeUtil.isWifiNet() || !k.HX()) {
                if (this.aLi == null) {
                    this.aLi = new ArrayList<>();
                }
                this.aLi.add(new com.baidu.live.gift.a.c(str, j, null, str2, str4, str3, "", "", false, "", "", j2));
                com.baidu.live.gift.c fi = Ah().fi(str);
                if (fi != null && fi.wT()) {
                    a.a(fi.aDK, false);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.v
    public void ys() {
        if (ListUtils.isEmpty(this.aKR)) {
            this.aLp = true;
            return;
        }
        Iterator<com.baidu.live.gift.c> it = this.aKR.iterator();
        while (it.hasNext()) {
            com.baidu.live.gift.c next = it.next();
            if (next != null && next.aDK != null && next.wT() && !Ah().eJ(next.getDynamicGiftId())) {
                com.baidu.live.gift.b bVar = next.aDK;
                if (bVar.aDI != null) {
                    a.a(bVar, false);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.v
    public void onDestroy() {
        this.aLp = false;
        MessageManager.getInstance().unRegisterListener(this.aLs);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.aLn != null) {
            this.aLn.onDestroy();
            this.aLn = null;
        }
        if (this.aLk != null) {
            this.aLk.onDestroy();
            this.aLk = null;
        }
        if (this.aLl != null) {
            this.aLl.onDestroy();
            this.aLl = null;
        }
        if (this.aLm != null) {
            this.aLm.onDestroy();
            this.aLm = null;
        }
        if (this.aLo != null) {
            this.aLo.release();
            this.aLo = null;
        }
        if (this.aLi != null) {
            this.aLi.clear();
        }
        a.Ag();
        this.aHY.clear();
        this.aKR.clear();
    }
}
