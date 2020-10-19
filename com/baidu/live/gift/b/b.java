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
import com.baidu.live.data.u;
import com.baidu.live.gift.b.c;
import com.baidu.live.gift.g;
import com.baidu.live.gift.giftList.b;
import com.baidu.live.gift.i;
import com.baidu.live.gift.l;
import com.baidu.live.gift.r;
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
public class b extends w {
    private static volatile b aZZ;
    private u aIT;
    private ArrayList<g> aWB;
    private ArrayList<com.baidu.live.gift.c> aZI;
    private ArrayList<com.baidu.live.gift.a.c> baa;
    private Map<String, com.baidu.live.gift.a.b> bab;
    private com.baidu.live.gift.giftList.b bac;
    private com.baidu.live.gift.giftList.c bad;
    private com.baidu.live.l.c bae;
    private c baf;
    private com.baidu.live.gift.c.c bag;
    private String bai;
    private boolean aYs = false;
    private boolean bah = false;
    private c.a baj = new c.a() { // from class: com.baidu.live.gift.b.b.1
        @Override // com.baidu.live.gift.b.c.a
        public void b(int i, String str, int i2, Object obj, long j) {
            b.this.a(i, str, i2, obj, j);
        }
    };
    private b.a bak = new b.a() { // from class: com.baidu.live.gift.b.b.2
        @Override // com.baidu.live.gift.giftList.b.a
        public void n(ArrayList<com.baidu.live.gift.c> arrayList) {
            b.this.aZI.clear();
            if (!ListUtils.isEmpty(arrayList)) {
                b.this.aZI.addAll(arrayList);
                if (b.this.bah) {
                    b.this.Gq();
                }
            }
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.b.b.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Map.Entry entry;
            if (message.what == 100) {
                Set entrySet = b.this.bab.entrySet();
                if (entrySet.isEmpty()) {
                    if (b.this.bae != null) {
                        b.this.bae.refreshCurUserScores();
                    }
                    return true;
                }
                if (b.this.baf != null && !b.this.baf.mIsSending && (entry = (Map.Entry) entrySet.iterator().next()) != null) {
                    b.this.baf.a((com.baidu.live.gift.a.b) entry.getValue());
                    b.this.bab.remove(entry.getKey());
                }
                b.this.mHandler.sendEmptyMessage(100);
            }
            return false;
        }
    });
    private CustomMessageListener bal = new CustomMessageListener(2913238) { // from class: com.baidu.live.gift.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null) {
                r.aTT = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private CustomMessageListener bam = new CustomMessageListener(2913234) { // from class: com.baidu.live.gift.b.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long) && ((Long) customResponsedMessage.getData()).longValue() == -1) {
                r.aTT = false;
            }
        }
    };
    private CustomMessageListener ban = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.b.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.f.c cVar;
            g gM;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.f.c) && !ListUtils.isEmpty(b.this.baa) && (cVar = (com.baidu.live.f.c) customResponsedMessage.getData()) != null && cVar.aQV != null && cVar.aQU == 5) {
                String id = cVar.aQV.getId();
                ArrayList arrayList = new ArrayList();
                Iterator it = b.this.baa.iterator();
                while (it.hasNext()) {
                    com.baidu.live.gift.a.c cVar2 = (com.baidu.live.gift.a.c) it.next();
                    if (!TextUtils.isEmpty(cVar2.giftId) && cVar2.giftId.equals(id) && (gM = w.gM(cVar2.giftId)) != null) {
                        arrayList.add(cVar2);
                        b.this.a(cVar2.giftId, cVar2.aYt, gM.Fe(), gM.getThumbnail_url(), cVar2.userId, cVar2.portrait, cVar2.userName, "", "", false, "", "", "", cVar2.aHY, cVar2.aHZ, cVar2.msgId, true, cVar2.aYs);
                    }
                }
                b.this.baa.removeAll(arrayList);
            }
        }
    };

    public static b Ik() {
        if (aZZ == null) {
            synchronized (b.class) {
                if (aZZ == null) {
                    aZZ = new b();
                }
            }
        }
        return aZZ;
    }

    private b() {
        a((w) this);
        this.aZI = new ArrayList<>();
        this.aWB = new ArrayList<>();
        this.bab = new HashMap();
    }

    @Override // com.baidu.live.gift.w
    protected u Gm() {
        return this.aIT;
    }

    @Override // com.baidu.live.gift.w
    protected void d(u uVar) {
        this.aIT = uVar;
    }

    @Override // com.baidu.live.gift.w
    protected String Gn() {
        return this.bai;
    }

    @Override // com.baidu.live.gift.w
    protected void gF(String str) {
        this.bai = str;
    }

    @Override // com.baidu.live.gift.w
    public void a(BdPageContext bdPageContext, boolean z) {
        MessageManager.getInstance().registerListener(this.ban);
        MessageManager.getInstance().registerListener(this.bal);
        MessageManager.getInstance().registerListener(this.bam);
        if (this.bad == null) {
            this.bad = new com.baidu.live.gift.giftList.c(bdPageContext);
        }
        if (this.bac == null) {
            this.bac = new com.baidu.live.gift.giftList.b(bdPageContext);
            this.bac.a(this.bak);
        }
        bM(z);
        if (this.baf == null) {
            this.baf = new c(bdPageContext);
            this.baf.setUniqueId(BdUniqueId.gen());
        }
        this.baf.initListener();
        this.baf.a(this.baj);
        if (this.bae == null) {
            this.bae = new com.baidu.live.l.c();
        }
        this.bae.initListener();
        this.bae.refreshCurUserScores();
    }

    @Override // com.baidu.live.gift.w
    protected void Go() {
        if (AlaLiveSwitchData.isHotLive == 0) {
            this.bad.a(p.QW(), true, "enter", "gift_init");
        }
    }

    private void bM(boolean z) {
        this.bac.setHost(z);
        this.bac.loadData();
    }

    @Override // com.baidu.live.gift.w
    public String Gp() {
        return p.QW();
    }

    public void e(String str, ArrayList<i> arrayList) {
        if (!ListUtils.isEmpty(arrayList)) {
            if (this.aWB == null) {
                this.aWB = new ArrayList<>();
            }
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                i next = it.next();
                if (!ListUtils.isEmpty(next.FE())) {
                    c(str, next.FE());
                }
            }
        }
    }

    private void c(String str, List<g> list) {
        boolean z;
        if (!ListUtils.isEmpty(list)) {
            for (g gVar : list) {
                Iterator<g> it = this.aWB.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    g next = it.next();
                    if (next != null && !TextUtils.isEmpty(next.Fd()) && next.Fd().equals(gVar.Fd())) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    gVar.setSceneFrom(str);
                    this.aWB.add(gVar);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.w
    public boolean gJ(String str) {
        if (StringUtils.isNull(str) || ListUtils.isEmpty(this.aZI)) {
            return false;
        }
        for (int i = 0; i < this.aZI.size(); i++) {
            if (str.equals(this.aZI.get(i).getDynamicGiftId())) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.live.gift.c hf(String str) {
        if (!StringUtils.isNull(str) && !ListUtils.isEmpty(this.aZI)) {
            boolean z = UtilHelper.getRealScreenOrientation(TbadkCoreApplication.getInst().getContext()) == 2;
            for (int i = 0; i < this.aZI.size(); i++) {
                com.baidu.live.gift.c cVar = this.aZI.get(i);
                if (str.equals(cVar.getDynamicGiftId()) && z == cVar.isLandScapeZip()) {
                    return cVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.live.gift.w
    protected String gG(String str) {
        com.baidu.live.gift.c hf = Ik().hf(str);
        if (hf == null || hf.aRQ == null || hf.aRQ.aRO == null) {
            return null;
        }
        return (com.baidu.live.alphavideo.a.BT().BU() && hf.aRQ.EL()) ? hf.aRQ.aRO.videoUrl : hf.aRQ.aRO.zipDownloadUrl;
    }

    @Override // com.baidu.live.gift.w
    public boolean gH(String str) {
        com.baidu.live.gift.c hf;
        if (StringUtils.isNull(str) || (hf = hf(str)) == null || hf.aRQ == null) {
            return false;
        }
        if (com.baidu.live.alphavideo.a.BT().BU() && hf.aRQ.EL() && !TextUtils.isEmpty(hf.EM())) {
            return true;
        }
        return ListUtils.isEmpty(hf.getDynamicGiftPicPathList()) ? false : true;
    }

    @Override // com.baidu.live.gift.w
    protected boolean gI(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return a.Ih().at(str, gG(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, Object obj, long j) {
        if (i2 == 1 || i2 == 2) {
            if (i >= 0) {
                if (this.bab != null && this.bab.size() == 0) {
                    if (i == 0) {
                        if (i2 == 1) {
                            TbadkCoreApplication.getInst().currentAccountTdouNum = ((Long) obj).longValue();
                        } else {
                            TbadkCoreApplication.getInst().currentAccountFlowerNum = ((Long) obj).longValue();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                    } else if (this.bae != null) {
                        this.bae.refreshCurUserScores();
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
            if (gVar.Fo()) {
                TiebaInitialize.log(new StatisticItem("c12792").param("obj_id", gVar.Fd()).param("obj_param1", gVar.Fg()).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, gH(gVar.Fd()) ? 1 : 0));
            }
            a(gVar, j, str, str2, str3, str5, j2, j3);
        }
    }

    @Override // com.baidu.live.gift.w
    public void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        a(gVar, j, str, str2, str3, str4, str5, str6, str7, j2, currentTimeMillis);
        a(gVar, j, str, str2, str3, str4, str6, str7, currentTimeMillis);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4, long j2, long j3) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(gVar.Fd(), j, gVar, currentAccountInfo.getID(), currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), currentAccountInfo.getLiveLevel(), currentAccountInfo.getSex(), "", -1, str3, "", false, str, str4, j2);
        cVar.aTm = j3;
        cVar.af(System.currentTimeMillis());
        cVar.aYn = true;
        cVar.aYs = gVar.Fw();
        r.f(cVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    private String l(String str, String str2, String str3, String str4) {
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str4;
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, long j2) {
        if (this.baf != null) {
            com.baidu.live.gift.a.b bVar = new com.baidu.live.gift.a.b(gVar, j, str, str2, str3, str4, str5, str6, gVar.getThumbnail_url(), j2);
            if (j == 1) {
                bVar.aTY = 0;
            } else {
                bVar.aTY = 1;
            }
            bVar.aYm.put(Long.valueOf(j2), Long.valueOf(j));
            if (this.baf.mIsSending || !this.bab.isEmpty()) {
                String l = l(str3, str, gVar.Fd(), String.valueOf(j));
                com.baidu.live.gift.a.b bVar2 = this.bab.get(l);
                if (bVar2 == null) {
                    this.bab.put(l, bVar);
                } else {
                    bVar2.aYm.put(Long.valueOf(j2), Long.valueOf(j));
                    bVar2.aYk += j;
                }
                this.mHandler.sendEmptyMessage(100);
                return;
            }
            this.baf.a(bVar);
        }
    }

    @Override // com.baidu.live.gift.w
    public g gE(String str) {
        if (TextUtils.isEmpty(str) || this.aWB == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.aWB.size()) {
                return null;
            }
            g gVar = this.aWB.get(i2);
            if (!str.equals(gVar.Fd())) {
                i = i2 + 1;
            } else {
                return gVar;
            }
        }
    }

    @Override // com.baidu.live.gift.w
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, boolean z2, long j2) {
        a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, true, str12, str13, j2);
    }

    @Override // com.baidu.live.gift.w
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2, boolean z2, boolean z3) {
        this.aYs = z3;
        a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, true, str12, str13, j2);
    }

    public void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, String str12, String str13, long j2) {
        if (StringUtils.isNull(str4)) {
            if (z) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, str12, str13, str, "userId 为空");
            }
        } else if (!z2 || !str4.equals(TbadkCoreApplication.getCurrentAccount())) {
            a(str, j, str4, str6, str5, j2);
            g gE = gE(str);
            if (gE == null) {
                String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount("last_send_get_gift_list_time");
                if (System.currentTimeMillis() - com.baidu.live.c.AZ().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                    com.baidu.live.c.AZ().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                }
                gE = new g();
                gE.gy(str);
                gE.setGiftName(str2);
                gE.gz("" + j);
                gE.setThumbnailUrl(str3);
                BdResourceLoader.getInstance().loadResource(gE.getThumbnail_url(), 10, null, BdUniqueId.gen());
            }
            com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, gE, str4, str5, str6, str7, str8, z, str9, str10, j2, this.aYs);
            cVar.af(System.currentTimeMillis());
            cVar.aYn = false;
            cVar.bK(z3);
            cVar.aHY = str12;
            cVar.aHZ = str13;
            if (com.baidu.live.x.a.OS().blo.aKg && !TextUtils.isEmpty(str11)) {
                l lVar = new l();
                if (lVar.gA(str11)) {
                    cVar.aYo.aSz = lVar;
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.live.gift.w
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
                            g gE = gE(optString);
                            if (gE == null) {
                                String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount("last_send_get_gift_list_time");
                                if (System.currentTimeMillis() - com.baidu.live.c.AZ().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                                    com.baidu.live.c.AZ().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                                }
                                gE = new g();
                                gE.gy(optString);
                                gE.setGiftName(optString2);
                                gE.setThumbnailUrl(optString3);
                                BdResourceLoader.getInstance().loadResource(gE.getThumbnail_url(), 10, null, BdUniqueId.gen());
                            }
                            arrayList.add(gE);
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
                com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(gVar.Fd(), j3, gVar, str2, str3, str4, str5, str6, z, str7, str8, j);
                cVar.af(System.currentTimeMillis());
                cVar.aYn = false;
                cVar.bK(true);
                cVar.aHY = str10;
                cVar.aHZ = str11;
                if (com.baidu.live.x.a.OS().blo.aKg && !TextUtils.isEmpty(str9)) {
                    l lVar = new l();
                    if (lVar.gA(str9)) {
                        cVar.aYo.aSz = lVar;
                    }
                }
                if (arrayList.size() >= 2) {
                    r.a(j, gVar.Fd(), str2, str4, j3, j2);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
            }
        }
    }

    @Override // com.baidu.live.gift.w
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        g gVar = new g();
        gVar.gy(str);
        gVar.setGiftName(str2);
        gVar.gz("" + j);
        gVar.setThumbnailUrl(str3);
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2);
        cVar.af(System.currentTimeMillis());
        cVar.aYn = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bK(z3);
        cVar.aYy = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    @Override // com.baidu.live.gift.w
    protected void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        g gVar = new g();
        gVar.gy(str);
        gVar.setGiftName(str2);
        gVar.gz("" + j);
        gVar.setThumbnailUrl(str3);
        a(str, j, str4, str6, str5, j2);
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2);
        cVar.af(System.currentTimeMillis());
        cVar.aYn = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bK(z3);
        cVar.aYy = false;
        cVar.aYz = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    @Override // com.baidu.live.gift.w
    protected void gK(String str) {
        if (this.bag == null) {
            this.bag = new com.baidu.live.gift.c.a();
        }
        this.bag.hj(str);
    }

    @Override // com.baidu.live.gift.w
    protected void a(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        if (this.bag == null) {
            this.bag = new com.baidu.live.gift.c.a();
        }
        this.bag.a(str, "", str2, str3, str4, 1, 0, "", System.currentTimeMillis());
    }

    private void a(String str, long j, String str2, String str3, String str4, long j2) {
        if (gJ(str) && !gO(str)) {
            if (BdNetTypeUtil.isWifiNet() || !com.baidu.live.utils.l.QR()) {
                if (this.baa == null) {
                    this.baa = new ArrayList<>();
                }
                this.baa.add(new com.baidu.live.gift.a.c(str, j, null, str2, str4, str3, "", "", false, "", "", j2, this.aYs));
                com.baidu.live.gift.c hf = Ik().hf(str);
                if (hf != null) {
                    a.Ih().a(hf.aRQ, false);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.w
    public void Gq() {
        if (ListUtils.isEmpty(this.aZI)) {
            this.bah = true;
            return;
        }
        Iterator<com.baidu.live.gift.c> it = this.aZI.iterator();
        while (it.hasNext()) {
            com.baidu.live.gift.c next = it.next();
            if (next != null && next.aRQ != null && !Ik().gH(next.getDynamicGiftId())) {
                com.baidu.live.gift.b bVar = next.aRQ;
                if (bVar.aRO != null) {
                    a.Ih().a(bVar, false);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.w
    public void onDestroy() {
        this.bah = false;
        MessageManager.getInstance().unRegisterListener(this.ban);
        MessageManager.getInstance().unRegisterListener(this.bal);
        MessageManager.getInstance().unRegisterListener(this.bam);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.baf != null) {
            this.baf.onDestroy();
            this.baf = null;
        }
        if (this.bac != null) {
            this.bac.onDestroy();
            this.bac = null;
        }
        if (this.bad != null) {
            this.bad.onDestroy();
            this.bad = null;
        }
        if (this.bae != null) {
            this.bae.onDestroy();
            this.bae = null;
        }
        if (this.bag != null) {
            this.bag.release();
            this.bag = null;
        }
        if (this.baa != null) {
            this.baa.clear();
        }
        a.Ih().Ij();
        this.aWB.clear();
        this.aZI.clear();
        this.aIT = null;
        this.bai = null;
    }
}
