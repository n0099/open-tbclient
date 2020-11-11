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
import com.baidu.live.data.w;
import com.baidu.live.gift.aa;
import com.baidu.live.gift.b.c;
import com.baidu.live.gift.g;
import com.baidu.live.gift.giftList.b;
import com.baidu.live.gift.h;
import com.baidu.live.gift.k;
import com.baidu.live.gift.u;
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
import com.baidu.live.utils.l;
import com.baidu.live.utils.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends aa {
    private static volatile b bcL;
    private w aKv;
    private ArrayList<g> aZo;
    private JSONObject bbh;
    private ArrayList<com.baidu.live.gift.a.c> bcM;
    private List<com.baidu.live.gift.c> bcN;
    private Map<String, com.baidu.live.gift.a.b> bcO;
    private com.baidu.live.gift.giftList.b bcP;
    private com.baidu.live.gift.giftList.c bcQ;
    private com.baidu.live.m.c bcR;
    private c bcS;
    private com.baidu.live.gift.c.c bcT;
    private String bcV;
    private boolean bbg = false;
    private boolean bbp = false;
    private boolean bcU = false;
    private c.a bcW = new c.a() { // from class: com.baidu.live.gift.b.b.1
        @Override // com.baidu.live.gift.b.c.a
        public void b(int i, String str, int i2, Object obj, long j) {
            b.this.a(i, str, i2, obj, j);
        }
    };
    private b.a bcX = new b.a() { // from class: com.baidu.live.gift.b.b.2
        @Override // com.baidu.live.gift.giftList.b.a
        public void n(ArrayList<com.baidu.live.gift.c> arrayList) {
            b.this.bcN.clear();
            if (!ListUtils.isEmpty(arrayList)) {
                b.this.bcN.addAll(arrayList);
                if (b.this.bcU) {
                    b.this.Hm();
                }
            }
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.b.b.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Map.Entry entry;
            if (message.what == 100) {
                Set entrySet = b.this.bcO.entrySet();
                if (entrySet.isEmpty()) {
                    if (b.this.bcR != null) {
                        b.this.bcR.refreshCurUserScores();
                    }
                    return true;
                }
                if (b.this.bcS != null && !b.this.bcS.mIsSending && (entry = (Map.Entry) entrySet.iterator().next()) != null) {
                    b.this.bcS.a((com.baidu.live.gift.a.b) entry.getValue());
                    b.this.bcO.remove(entry.getKey());
                }
                b.this.mHandler.sendEmptyMessage(100);
            }
            return false;
        }
    });
    private CustomMessageListener bcY = new CustomMessageListener(2913238) { // from class: com.baidu.live.gift.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null) {
                v.aWv = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private CustomMessageListener bcZ = new CustomMessageListener(2913234) { // from class: com.baidu.live.gift.b.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long) && ((Long) customResponsedMessage.getData()).longValue() == -1) {
                v.aWv = false;
            }
        }
    };
    private CustomMessageListener bda = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.b.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.f.c cVar;
            g hc;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.f.c) && !ListUtils.isEmpty(b.this.bcM) && (cVar = (com.baidu.live.f.c) customResponsedMessage.getData()) != null && cVar.aTb != null && cVar.aTa == 5) {
                String id = cVar.aTb.getId();
                ArrayList arrayList = new ArrayList();
                Iterator it = b.this.bcM.iterator();
                while (it.hasNext()) {
                    com.baidu.live.gift.a.c cVar2 = (com.baidu.live.gift.a.c) it.next();
                    if (!TextUtils.isEmpty(cVar2.giftId) && cVar2.giftId.equals(id) && (hc = aa.hc(cVar2.giftId)) != null) {
                        arrayList.add(cVar2);
                        b.this.a(cVar2.giftId, cVar2.bbi, hc.FU(), hc.getThumbnail_url(), cVar2.userId, cVar2.portrait, cVar2.userName, "", "", false, "", "", "", true, true, cVar2.chatMCastId, cVar2.ensureMCastId, cVar2.msgId, false, cVar2.bbg);
                    }
                }
                b.this.bcM.removeAll(arrayList);
                com.baidu.live.gift.c hx = b.this.hx(id);
                if (hx != null && hx.aUe != null && hx.aUe.aUc != null) {
                    u.gA(hx.aUe.aUc.zipName);
                }
            }
        }
    };

    public static b Je() {
        if (bcL == null) {
            synchronized (b.class) {
                if (bcL == null) {
                    bcL = new b();
                }
            }
        }
        return bcL;
    }

    private b() {
        a((aa) this);
        this.bcN = Collections.synchronizedList(new ArrayList());
        this.aZo = new ArrayList<>();
        this.bcO = new HashMap();
    }

    @Override // com.baidu.live.gift.aa
    protected w Hi() {
        return this.aKv;
    }

    @Override // com.baidu.live.gift.aa
    protected void setLiveShowData(w wVar) {
        this.aKv = wVar;
    }

    @Override // com.baidu.live.gift.aa
    protected String Hj() {
        return this.bcV;
    }

    @Override // com.baidu.live.gift.aa
    protected void gT(String str) {
        this.bcV = str;
    }

    @Override // com.baidu.live.gift.aa
    public void a(BdPageContext bdPageContext, boolean z) {
        MessageManager.getInstance().registerListener(this.bda);
        MessageManager.getInstance().registerListener(this.bcY);
        MessageManager.getInstance().registerListener(this.bcZ);
        if (this.bcQ == null) {
            this.bcQ = new com.baidu.live.gift.giftList.c(bdPageContext);
        }
        if (this.bcP == null) {
            this.bcP = new com.baidu.live.gift.giftList.b(bdPageContext);
            this.bcP.a(this.bcX);
        }
        g(z, null);
        if (this.bcS == null) {
            this.bcS = new c(bdPageContext);
            this.bcS.setUniqueId(BdUniqueId.gen());
        }
        this.bcS.initListener();
        this.bcS.a(this.bcW);
        if (this.bcR == null) {
            this.bcR = new com.baidu.live.m.c();
        }
        this.bcR.initListener();
        this.bcR.refreshCurUserScores();
    }

    @Override // com.baidu.live.gift.aa
    protected void Hk() {
        if (AlaLiveSwitchData.isHotLive == 0) {
            this.bcQ.a(p.UK(), true, "enter", "gift_init");
        }
    }

    private void g(boolean z, String str) {
        this.bcP.setHost(z);
        this.bcP.hw(str);
    }

    @Override // com.baidu.live.gift.aa
    public String Hl() {
        return p.UK();
    }

    @Override // com.baidu.live.gift.aa
    protected void gY(String str) {
        if (!TextUtils.isEmpty(str) && this.bcN != null && !this.bcN.isEmpty()) {
            for (com.baidu.live.gift.c cVar : this.bcN) {
                if (cVar != null && cVar.aUe != null && cVar.aUe.aUc != null && str.equals(cVar.aUe.aUc.zipName)) {
                    cVar.videoPath = null;
                    cVar.unZipFilesPathList = null;
                    return;
                }
            }
        }
    }

    public void e(String str, ArrayList<h> arrayList) {
        if (!ListUtils.isEmpty(arrayList)) {
            if (this.aZo == null) {
                this.aZo = new ArrayList<>();
            }
            Iterator<h> it = arrayList.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (!ListUtils.isEmpty(next.Gu())) {
                    c(str, next.Gu());
                }
            }
        }
    }

    private void c(String str, List<g> list) {
        boolean z;
        if (!ListUtils.isEmpty(list)) {
            for (g gVar : list) {
                Iterator<g> it = this.aZo.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    g next = it.next();
                    if (next != null && !TextUtils.isEmpty(next.FT()) && next.FT().equals(gVar.FT())) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    gVar.setSceneFrom(str);
                    this.aZo.add(gVar);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.aa
    public boolean gX(String str) {
        if (StringUtils.isNull(str) || ListUtils.isEmpty(this.bcN)) {
            return false;
        }
        for (int i = 0; i < this.bcN.size(); i++) {
            if (str.equals(this.bcN.get(i).getDynamicGiftId())) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.live.gift.c hx(String str) {
        if (!StringUtils.isNull(str) && !ListUtils.isEmpty(this.bcN)) {
            boolean z = UtilHelper.getRealScreenOrientation(TbadkCoreApplication.getInst().getContext()) == 2;
            for (int i = 0; i < this.bcN.size(); i++) {
                com.baidu.live.gift.c cVar = this.bcN.get(i);
                if (str.equals(cVar.getDynamicGiftId()) && z == cVar.isLandScapeZip()) {
                    return cVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.live.gift.aa
    protected String gU(String str) {
        com.baidu.live.gift.c hx = Je().hx(str);
        if (hx == null || hx.aUe == null || hx.aUe.aUc == null) {
            return null;
        }
        return (com.baidu.live.alphavideo.a.Cl().Cm() && hx.aUe.FB()) ? hx.aUe.aUc.videoUrl : hx.aUe.aUc.zipDownloadUrl;
    }

    @Override // com.baidu.live.gift.aa
    public boolean gV(String str) {
        com.baidu.live.gift.c hx;
        if (StringUtils.isNull(str) || (hx = hx(str)) == null || hx.aUe == null) {
            return false;
        }
        if (com.baidu.live.alphavideo.a.Cl().Cm() && hx.aUe.FB() && !TextUtils.isEmpty(hx.FC())) {
            return true;
        }
        return ListUtils.isEmpty(hx.getDynamicGiftPicPathList()) ? false : true;
    }

    @Override // com.baidu.live.gift.aa
    protected boolean gW(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return a.Jd().as(str, gU(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, Object obj, long j) {
        if (i2 == 1 || i2 == 2) {
            if (i >= 0) {
                if (this.bcO != null && this.bcO.size() == 0) {
                    if (i == 0) {
                        if (i2 == 1) {
                            TbadkCoreApplication.getInst().currentAccountTdouNum = ((Long) obj).longValue();
                        } else {
                            TbadkCoreApplication.getInst().currentAccountFlowerNum = ((Long) obj).longValue();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                    } else if (this.bcR != null) {
                        this.bcR.refreshCurUserScores();
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
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), TbadkCoreApplication.getInst().getContext().getResources().getString(a.h.sdk_no_network_guide));
        } else if (gVar != null) {
            if (gVar.Ge()) {
                TiebaInitialize.log(new StatisticItem("c12792").param("obj_id", gVar.FT()).param("obj_param1", gVar.FW()).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, gV(gVar.FT()) ? 1 : 0));
            }
            a(gVar, j, str, str2, str3, str5, j2, j3);
        }
    }

    @Override // com.baidu.live.gift.aa
    public void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        a(gVar, j, str, str2, str3, str4, str5, str6, str7, j2, currentTimeMillis);
        a(gVar, j, str, str2, str3, str4, str6, str7, currentTimeMillis);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4, long j2, long j3) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(gVar.FT(), j, gVar, currentAccountInfo.getID(), currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), currentAccountInfo.getLiveLevel(), currentAccountInfo.getSex(), "", -1, str3, "", false, str, str4, j2);
        cVar.aVA = j3;
        cVar.as(System.currentTimeMillis());
        cVar.bbb = true;
        cVar.bbg = gVar.Gm();
        v.f(cVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    private String l(String str, String str2, String str3, String str4) {
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str4;
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, long j2) {
        if (this.bcS != null) {
            com.baidu.live.gift.a.b bVar = new com.baidu.live.gift.a.b(gVar, j, str, str2, str3, str4, str5, str6, gVar.getThumbnail_url(), j2);
            if (j == 1) {
                bVar.aWA = 0;
            } else {
                bVar.aWA = 1;
            }
            bVar.bba.put(Long.valueOf(j2), Long.valueOf(j));
            if (this.bcS.mIsSending || !this.bcO.isEmpty()) {
                String l = l(str3, str, gVar.FT(), String.valueOf(j));
                com.baidu.live.gift.a.b bVar2 = this.bcO.get(l);
                if (bVar2 == null) {
                    this.bcO.put(l, bVar);
                } else {
                    bVar2.bba.put(Long.valueOf(j2), Long.valueOf(j));
                    bVar2.baY += j;
                }
                this.mHandler.sendEmptyMessage(100);
                return;
            }
            this.bcS.a(bVar);
        }
    }

    @Override // com.baidu.live.gift.aa
    public g gS(String str) {
        if (TextUtils.isEmpty(str) || this.aZo == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.aZo.size()) {
                return null;
            }
            g gVar = this.aZo.get(i2);
            if (!str.equals(gVar.FT())) {
                i = i2 + 1;
            } else {
                return gVar;
            }
        }
    }

    @Override // com.baidu.live.gift.aa
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, String str12, String str13, long j2, boolean z4, boolean z5) {
        this.bbg = z5;
        a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, true, str12, str13, j2, z4);
    }

    @Override // com.baidu.live.gift.aa
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, String str12, String str13, long j2, boolean z4, boolean z5, JSONObject jSONObject) {
        this.bbg = z5;
        this.bbh = jSONObject;
        a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, str12, str13, j2, z4);
    }

    public void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, String str12, String str13, long j2, boolean z4) {
        if (StringUtils.isNull(str4)) {
            if (z) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, str12, str13, str, "userId 为空");
                return;
            }
            return;
        }
        if ("tying_gift".equals(this.bbh.optString("content_type")) && this.bbh != null && this.bbh.optInt("tying_status") == 1) {
            this.bbp = true;
        }
        if (!z2 || !str4.equals(TbadkCoreApplication.getCurrentAccount()) || this.bbp) {
            a(str, j, str4, str6, str5, j2, z, z4);
            g gS = gS(str);
            if (gS == null) {
                String sharedPrefKeyWithAccount = com.baidu.live.d.getSharedPrefKeyWithAccount("last_send_get_gift_list_time");
                if (System.currentTimeMillis() - com.baidu.live.d.AZ().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                    com.baidu.live.d.AZ().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                }
                gS = new g();
                gS.gH(str);
                gS.setGiftName(str2);
                gS.gI("" + j);
                gS.setThumbnailUrl(str3);
                BdResourceLoader.getInstance().loadResource(gS.getThumbnail_url(), 10, null, BdUniqueId.gen());
            }
            com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, gS, str4, str5, str6, str7, str8, z, str9, str10, j2, this.bbg, this.bbh);
            cVar.as(System.currentTimeMillis());
            cVar.bbb = false;
            cVar.bN(z3);
            cVar.chatMCastId = str12;
            cVar.ensureMCastId = str13;
            if (com.baidu.live.aa.a.PQ().bod.aLI && !TextUtils.isEmpty(str11)) {
                k kVar = new k();
                if (kVar.gJ(str11)) {
                    cVar.bbc.aUN = kVar;
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.live.gift.aa
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
                            g gS = gS(optString);
                            if (gS == null) {
                                String sharedPrefKeyWithAccount = com.baidu.live.d.getSharedPrefKeyWithAccount("last_send_get_gift_list_time");
                                if (System.currentTimeMillis() - com.baidu.live.d.AZ().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                                    com.baidu.live.d.AZ().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                                }
                                gS = new g();
                                gS.gH(optString);
                                gS.setGiftName(optString2);
                                gS.setThumbnailUrl(optString3);
                                BdResourceLoader.getInstance().loadResource(gS.getThumbnail_url(), 10, null, BdUniqueId.gen());
                            }
                            arrayList.add(gS);
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
                com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(gVar.FT(), j3, gVar, str2, str3, str4, str5, str6, z, str7, str8, j);
                cVar.as(System.currentTimeMillis());
                cVar.bbb = false;
                cVar.bN(true);
                cVar.chatMCastId = str10;
                cVar.ensureMCastId = str11;
                if (com.baidu.live.aa.a.PQ().bod.aLI && !TextUtils.isEmpty(str9)) {
                    k kVar = new k();
                    if (kVar.gJ(str9)) {
                        cVar.bbc.aUN = kVar;
                    }
                }
                if (arrayList.size() >= 2) {
                    v.a(j, gVar.FT(), str2, str4, j3, j2);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
            }
        }
    }

    @Override // com.baidu.live.gift.aa
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        g gVar = new g();
        gVar.gH(str);
        gVar.setGiftName(str2);
        gVar.gI("" + j);
        gVar.setThumbnailUrl(str3);
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2);
        cVar.as(System.currentTimeMillis());
        cVar.bbb = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bN(z3);
        cVar.bbn = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    @Override // com.baidu.live.gift.aa
    protected void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        g gVar = new g();
        gVar.gH(str);
        gVar.setGiftName(str2);
        gVar.gI("" + j);
        gVar.setThumbnailUrl(str3);
        a(str, j, str4, str6, str5, j2, z, false);
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2);
        cVar.as(System.currentTimeMillis());
        cVar.bbb = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bN(z3);
        cVar.bbn = false;
        cVar.bbo = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    @Override // com.baidu.live.gift.aa
    protected void gZ(String str) {
        if (this.bcT == null) {
            this.bcT = new com.baidu.live.gift.c.a();
        }
        this.bcT.hy(str);
    }

    @Override // com.baidu.live.gift.aa
    protected void a(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        if (this.bcT == null) {
            this.bcT = new com.baidu.live.gift.c.a();
        }
        this.bcT.a(str, "", str2, str3, str4, 1, 0, "", System.currentTimeMillis());
    }

    private void a(String str, long j, String str2, String str3, String str4, long j2, boolean z, boolean z2) {
        if (gX(str)) {
            if (!he(str)) {
                if (BdNetTypeUtil.isWifiNet() || !l.UF()) {
                    if (this.bcM == null) {
                        this.bcM = new ArrayList<>();
                    }
                    this.bcM.add(new com.baidu.live.gift.a.c(str, j, null, str2, str4, str3, "", "", false, "", "", j2, this.bbg, this.bbh));
                    com.baidu.live.gift.c hx = Je().hx(str);
                    if (hx != null) {
                        a.Jd().a(hx.aUe, false);
                    }
                }
            }
        } else if (z2) {
            g(z, str);
        }
    }

    @Override // com.baidu.live.gift.aa
    public void Hm() {
        if (ListUtils.isEmpty(this.bcN)) {
            this.bcU = true;
            return;
        }
        for (com.baidu.live.gift.c cVar : this.bcN) {
            if (cVar != null && cVar.aUe != null && !Je().gV(cVar.getDynamicGiftId())) {
                com.baidu.live.gift.b bVar = cVar.aUe;
                if (bVar.aUc != null) {
                    a.Jd().a(bVar, false);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.aa
    protected com.baidu.live.gift.c ha(String str) {
        if (!TextUtils.isEmpty(str) && !ListUtils.isEmpty(this.bcN)) {
            for (com.baidu.live.gift.c cVar : this.bcN) {
                if (cVar.aUe != null && cVar.aUe.aUc != null && str.equals(cVar.aUe.aUc.zipName)) {
                    return cVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.live.gift.aa
    public void onDestroy() {
        this.bcU = false;
        MessageManager.getInstance().unRegisterListener(this.bda);
        MessageManager.getInstance().unRegisterListener(this.bcY);
        MessageManager.getInstance().unRegisterListener(this.bcZ);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bcS != null) {
            this.bcS.onDestroy();
            this.bcS = null;
        }
        if (this.bcP != null) {
            this.bcP.onDestroy();
            this.bcP = null;
        }
        if (this.bcQ != null) {
            this.bcQ.onDestroy();
            this.bcQ = null;
        }
        if (this.bcR != null) {
            this.bcR.onDestroy();
            this.bcR = null;
        }
        if (this.bcT != null) {
            this.bcT.release();
            this.bcT = null;
        }
        if (this.bcM != null) {
            this.bcM.clear();
        }
        a.Jd().GX();
        this.aZo.clear();
        this.bcN.clear();
        this.aKv = null;
        this.bcV = null;
    }
}
