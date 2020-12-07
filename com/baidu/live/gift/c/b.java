package com.baidu.live.gift.c;

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
import com.baidu.live.gift.ac;
import com.baidu.live.gift.c.c;
import com.baidu.live.gift.g;
import com.baidu.live.gift.giftList.b;
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
public class b extends ac {
    private static volatile b beY;
    private w aLD;
    private ArrayList<g> baV;
    private ArrayList<com.baidu.live.gift.a.c> beZ;
    private List<com.baidu.live.gift.c> bfa;
    private Map<String, com.baidu.live.gift.a.b> bfc;
    private com.baidu.live.gift.giftList.b bfd;
    private com.baidu.live.gift.giftList.c bfe;
    private com.baidu.live.o.c bff;
    private c bfg;
    private com.baidu.live.gift.d.c bfh;
    private String bfj;
    private boolean bfi = false;
    private c.a bfk = new c.a() { // from class: com.baidu.live.gift.c.b.1
        @Override // com.baidu.live.gift.c.c.a
        public void b(int i, String str, int i2, Object obj, long j) {
            b.this.a(i, str, i2, obj, j);
        }
    };
    private b.a bfl = new b.a() { // from class: com.baidu.live.gift.c.b.2
        @Override // com.baidu.live.gift.giftList.b.a
        public void n(ArrayList<com.baidu.live.gift.c> arrayList) {
            b.this.bfa.clear();
            if (!ListUtils.isEmpty(arrayList)) {
                b.this.bfa.addAll(arrayList);
                if (b.this.bfi) {
                    b.this.Iu();
                }
            }
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.c.b.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Map.Entry entry;
            if (message.what == 100) {
                Set entrySet = b.this.bfc.entrySet();
                if (entrySet.isEmpty()) {
                    if (b.this.bff != null) {
                        b.this.bff.refreshCurUserScores();
                    }
                    return true;
                }
                if (b.this.bfg != null && !b.this.bfg.mIsSending && (entry = (Map.Entry) entrySet.iterator().next()) != null) {
                    b.this.bfg.a((com.baidu.live.gift.a.b) entry.getValue());
                    b.this.bfc.remove(entry.getKey());
                }
                b.this.mHandler.sendEmptyMessage(100);
            }
            return false;
        }
    });
    private CustomMessageListener bfm = new CustomMessageListener(2913238) { // from class: com.baidu.live.gift.c.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null) {
                com.baidu.live.gift.w.aXR = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    };
    private CustomMessageListener bfn = new CustomMessageListener(2913234) { // from class: com.baidu.live.gift.c.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long) && ((Long) customResponsedMessage.getData()).longValue() == -1) {
                com.baidu.live.gift.w.aXR = false;
            }
        }
    };
    private CustomMessageListener bfo = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.c.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.h.c cVar;
            g hr;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.h.c) && !ListUtils.isEmpty(b.this.beZ) && (cVar = (com.baidu.live.h.c) customResponsedMessage.getData()) != null && cVar.aUs != null && cVar.aUr == 5) {
                String id = cVar.aUs.getId();
                ArrayList arrayList = new ArrayList();
                Iterator it = b.this.beZ.iterator();
                while (it.hasNext()) {
                    com.baidu.live.gift.a.c cVar2 = (com.baidu.live.gift.a.c) it.next();
                    if (!TextUtils.isEmpty(cVar2.giftId) && cVar2.giftId.equals(id) && (hr = ac.hr(cVar2.giftId)) != null) {
                        arrayList.add(cVar2);
                        com.baidu.live.im.data.c cVar3 = new com.baidu.live.im.data.c();
                        cVar3.giftId = cVar2.giftId;
                        cVar3.aWP = cVar2.bcU;
                        cVar3.giftName = hr.GY();
                        cVar3.aWS = hr.getThumbnail_url();
                        cVar3.boV = "";
                        cVar3.isDynamic = false;
                        cVar3.bcS = cVar2.bcS;
                        com.baidu.live.data.a aVar = new com.baidu.live.data.a();
                        aVar.userId = cVar2.userId;
                        aVar.portrait = cVar2.portrait;
                        aVar.userName = cVar2.userName;
                        ac.b(cVar3, aVar, "", "", false, "", "", true, true, "", "", -1L);
                    }
                }
                b.this.beZ.removeAll(arrayList);
                com.baidu.live.gift.c hP = b.this.hP(id);
                if (hP != null && hP.aVv != null && hP.aVv.aVt != null) {
                    v.gP(hP.aVv.aVt.zipName);
                }
            }
        }
    };

    public static b Kv() {
        if (beY == null) {
            synchronized (b.class) {
                if (beY == null) {
                    beY = new b();
                }
            }
        }
        return beY;
    }

    private b() {
        a((ac) this);
        this.bfa = Collections.synchronizedList(new ArrayList());
        this.baV = new ArrayList<>();
        this.bfc = new HashMap();
    }

    @Override // com.baidu.live.gift.ac
    protected w Iq() {
        return this.aLD;
    }

    @Override // com.baidu.live.gift.ac
    protected void setLiveShowData(w wVar) {
        this.aLD = wVar;
    }

    @Override // com.baidu.live.gift.ac
    protected String Ir() {
        return this.bfj;
    }

    @Override // com.baidu.live.gift.ac
    protected void hi(String str) {
        this.bfj = str;
    }

    @Override // com.baidu.live.gift.ac
    public void a(BdPageContext bdPageContext, boolean z) {
        MessageManager.getInstance().registerListener(this.bfo);
        MessageManager.getInstance().registerListener(this.bfm);
        MessageManager.getInstance().registerListener(this.bfn);
        if (this.bfe == null) {
            this.bfe = new com.baidu.live.gift.giftList.c(bdPageContext);
        }
        if (this.bfd == null) {
            this.bfd = new com.baidu.live.gift.giftList.b(bdPageContext);
            this.bfd.a(this.bfl);
        }
        g(z, null);
        if (this.bfg == null) {
            this.bfg = new c(bdPageContext);
            this.bfg.setUniqueId(BdUniqueId.gen());
        }
        this.bfg.initListener();
        this.bfg.a(this.bfk);
        if (this.bff == null) {
            this.bff = new com.baidu.live.o.c();
        }
        this.bff.initListener();
        this.bff.refreshCurUserScores();
    }

    @Override // com.baidu.live.gift.ac
    protected void Is() {
        if (AlaLiveSwitchData.isHotLive == 0) {
            this.bfe.a(p.WB(), true, "enter", "gift_init");
        }
    }

    private void g(boolean z, String str) {
        this.bfd.setHost(z);
        this.bfd.hO(str);
    }

    @Override // com.baidu.live.gift.ac
    public String It() {
        return p.WB();
    }

    @Override // com.baidu.live.gift.ac
    protected void hn(String str) {
        if (!TextUtils.isEmpty(str) && this.bfa != null && !this.bfa.isEmpty()) {
            for (com.baidu.live.gift.c cVar : this.bfa) {
                if (cVar != null && cVar.aVv != null && cVar.aVv.aVt != null && str.equals(cVar.aVv.aVt.zipName)) {
                    cVar.videoPath = null;
                    cVar.unZipFilesPathList = null;
                    return;
                }
            }
        }
    }

    public void e(String str, ArrayList<h> arrayList) {
        if (!ListUtils.isEmpty(arrayList)) {
            if (this.baV == null) {
                this.baV = new ArrayList<>();
            }
            Iterator<h> it = arrayList.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (!ListUtils.isEmpty(next.HA())) {
                    c(str, next.HA());
                }
            }
        }
    }

    private void c(String str, List<g> list) {
        boolean z;
        if (!ListUtils.isEmpty(list)) {
            for (g gVar : list) {
                Iterator<g> it = this.baV.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    g next = it.next();
                    if (next != null && !TextUtils.isEmpty(next.GX()) && next.GX().equals(gVar.GX())) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    gVar.setSceneFrom(str);
                    this.baV.add(gVar);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.ac
    public boolean hm(String str) {
        if (StringUtils.isNull(str) || ListUtils.isEmpty(this.bfa)) {
            return false;
        }
        for (int i = 0; i < this.bfa.size(); i++) {
            if (str.equals(this.bfa.get(i).getDynamicGiftId())) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.live.gift.c hP(String str) {
        if (!StringUtils.isNull(str) && !ListUtils.isEmpty(this.bfa)) {
            boolean z = UtilHelper.getRealScreenOrientation(TbadkCoreApplication.getInst().getContext()) == 2;
            for (int i = 0; i < this.bfa.size(); i++) {
                com.baidu.live.gift.c cVar = this.bfa.get(i);
                if (str.equals(cVar.getDynamicGiftId()) && z == cVar.isLandScapeZip()) {
                    return cVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.live.gift.ac
    protected String hj(String str) {
        com.baidu.live.gift.c hP = Kv().hP(str);
        if (hP == null || hP.aVv == null || hP.aVv.aVt == null) {
            return null;
        }
        return (com.baidu.live.alphavideo.a.Dl().Dm() && hP.aVv.GD()) ? hP.aVv.aVt.videoUrl : hP.aVv.aVt.zipDownloadUrl;
    }

    @Override // com.baidu.live.gift.ac
    public boolean hk(String str) {
        com.baidu.live.gift.c hP;
        if (StringUtils.isNull(str) || (hP = hP(str)) == null || hP.aVv == null) {
            return false;
        }
        if (com.baidu.live.alphavideo.a.Dl().Dm() && hP.aVv.GD() && !TextUtils.isEmpty(hP.GE())) {
            return true;
        }
        return ListUtils.isEmpty(hP.getDynamicGiftPicPathList()) ? false : true;
    }

    @Override // com.baidu.live.gift.ac
    protected boolean hl(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return a.Ku().aw(str, hj(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, Object obj, long j) {
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            if (i >= 0) {
                if (this.bfc != null && this.bfc.size() == 0) {
                    if (i == 0) {
                        if (i2 == 1 || i2 == 3) {
                            TbadkCoreApplication.getInst().currentAccountTdouNum = ((Long) obj).longValue();
                        } else {
                            TbadkCoreApplication.getInst().currentAccountFlowerNum = ((Long) obj).longValue();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                    } else if (this.bff != null) {
                        this.bff.refreshCurUserScores();
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
            if (gVar.Hj()) {
                TiebaInitialize.log(new StatisticItem("c12792").param("obj_id", gVar.GX()).param("obj_param1", gVar.Ha()).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, hk(gVar.GX()) ? 1 : 0));
            }
            a(gVar, j, str, str2, str3, str5, j2, j3);
        }
    }

    public void b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
        a(gVar, j, str, str2, str3, str4, str5, str6, str7, j2, (BdUniqueId) null);
    }

    @Override // com.baidu.live.gift.ac
    public void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, BdUniqueId bdUniqueId) {
        long currentTimeMillis = System.currentTimeMillis();
        a(gVar, j, str, str2, str3, str4, str5, str6, str7, j2, currentTimeMillis);
        a(gVar, j, str, str2, str3, str4, str6, str7, currentTimeMillis, bdUniqueId);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4, long j2, long j3) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(gVar.GX(), j, gVar, currentAccountInfo.getID(), currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), str3, "", false, str, str4, j2);
        cVar.bcP = currentAccountInfo.getLiveLevel();
        cVar.sex = currentAccountInfo.getSex();
        cVar.description = "";
        cVar.userStatus = -1;
        cVar.aWT = j3;
        cVar.aQ(System.currentTimeMillis());
        cVar.bcM = true;
        cVar.bcS = gVar.Hr();
        com.baidu.live.gift.w.f(cVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    private String l(String str, String str2, String str3, String str4) {
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str4;
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, long j2, BdUniqueId bdUniqueId) {
        if (this.bfg != null) {
            com.baidu.live.gift.a.b bVar = new com.baidu.live.gift.a.b(gVar, j, str, str2, str3, str4, str5, str6, gVar.getThumbnail_url(), j2);
            bVar.aWW = bdUniqueId;
            if (j == 1) {
                bVar.aXW = 0;
            } else {
                bVar.aXW = 1;
            }
            bVar.bcL.put(Long.valueOf(j2), Long.valueOf(j));
            if (this.bfg.mIsSending || !this.bfc.isEmpty()) {
                String l = l(str3, str, gVar.GX(), String.valueOf(j));
                com.baidu.live.gift.a.b bVar2 = this.bfc.get(l);
                if (bVar2 == null) {
                    this.bfc.put(l, bVar);
                } else {
                    bVar2.bcL.put(Long.valueOf(j2), Long.valueOf(j));
                    bVar2.bcJ += j;
                }
                this.mHandler.sendEmptyMessage(100);
                return;
            }
            this.bfg.a(bVar);
        }
    }

    @Override // com.baidu.live.gift.ac
    public g hh(String str) {
        if (TextUtils.isEmpty(str) || this.baV == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.baV.size()) {
                return null;
            }
            g gVar = this.baV.get(i2);
            if (!str.equals(gVar.GX())) {
                i = i2 + 1;
            } else {
                return gVar;
            }
        }
    }

    @Override // com.baidu.live.gift.ac
    public void a(com.baidu.live.im.data.c cVar, com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3, String str4, boolean z2, boolean z3, String str5, String str6, long j) {
        String str7 = cVar.giftId;
        long j2 = cVar.aWP;
        String str8 = cVar.giftName;
        String str9 = cVar.aWS;
        String str10 = cVar.boV;
        if (!TextUtils.isEmpty(cVar.boW) && !TextUtils.isEmpty(cVar.boY)) {
            str10 = cVar.boW;
        }
        boolean z4 = cVar.isDynamic;
        boolean z5 = cVar.bcS;
        String str11 = aVar.userId;
        String str12 = aVar.portrait;
        String nameShow = aVar.getNameShow();
        JSONObject jSONObject = cVar.bcT;
        if (StringUtils.isNull(str11)) {
            if (z) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, str5, str6, str7, "userId 为空");
                return;
            }
            return;
        }
        boolean z6 = false;
        if ("tying_gift".equals(jSONObject.optString("content_type")) && jSONObject != null && jSONObject.optInt("tying_status") == 1) {
            z6 = true;
        }
        if (!z2 || !str11.equals(TbadkCoreApplication.getCurrentAccount()) || z6) {
            a(str7, j2, str11, nameShow, str12, j, z, z4, z5, jSONObject, cVar.bdf);
            g hh = hh(str7);
            if (hh == null) {
                String sharedPrefKeyWithAccount = com.baidu.live.d.getSharedPrefKeyWithAccount("last_send_get_gift_list_time");
                if (System.currentTimeMillis() - com.baidu.live.d.BM().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                    com.baidu.live.d.BM().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                }
                hh = new g();
                hh.gW(str7);
                hh.setGiftName(str8);
                hh.gX("" + j2);
                hh.setThumbnailUrl(str9);
                BdResourceLoader.getInstance().loadResource(hh.getThumbnail_url(), 10, null, BdUniqueId.gen());
            }
            com.baidu.live.gift.a.c cVar2 = new com.baidu.live.gift.a.c(str7, j2, hh, str11, str12, nameShow, str, str2, z, str3, str4, j, z5, jSONObject);
            cVar2.aQ(System.currentTimeMillis());
            cVar2.bcM = false;
            cVar2.bY(z3);
            cVar2.chatMCastId = str5;
            cVar2.ensureMCastId = str6;
            cVar2.bdf = cVar.bdf;
            if (com.baidu.live.ae.a.RB().brA.aMS && !TextUtils.isEmpty(str10)) {
                k kVar = new k();
                if (kVar.gY(str10)) {
                    cVar2.bcN.aWg = kVar;
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.live.gift.ac
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void a(com.baidu.live.im.data.c cVar, com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3, String str4, String str5, String str6, long j) {
        long j2;
        JSONException e;
        String str7 = cVar.boY;
        String str8 = (TextUtils.isEmpty(cVar.boW) || TextUtils.isEmpty(cVar.boY)) ? cVar.boV : cVar.boW;
        String str9 = aVar.userId;
        String str10 = aVar.portrait;
        String nameShow = aVar.getNameShow();
        if (!StringUtils.isNull(str9) && !str9.equals(TbadkCoreApplication.getCurrentAccount())) {
            long j3 = 0;
            long j4 = 0;
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(str7);
                if (jSONArray != null && jSONArray.length() > 0) {
                    int i = 0;
                    while (i < jSONArray.length()) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        String optString = jSONObject.optString(LogConfig.LOG_GIFT_ID);
                        String optString2 = jSONObject.optString("gift_name");
                        long optLong = jSONObject.optLong("gift_count");
                        String optString3 = jSONObject.optString("gift_url");
                        j3 += optLong;
                        j2 = jSONObject.optLong("charm_value") + j4;
                        try {
                            g hh = hh(optString);
                            if (hh == null) {
                                String sharedPrefKeyWithAccount = com.baidu.live.d.getSharedPrefKeyWithAccount("last_send_get_gift_list_time");
                                if (System.currentTimeMillis() - com.baidu.live.d.BM().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                                    com.baidu.live.d.BM().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                                }
                                hh = new g();
                                hh.gW(optString);
                                hh.setGiftName(optString2);
                                hh.setThumbnailUrl(optString3);
                                BdResourceLoader.getInstance().loadResource(hh.getThumbnail_url(), 10, null, BdUniqueId.gen());
                            }
                            arrayList.add(hh);
                            i++;
                            j4 = j2;
                        } catch (JSONException e2) {
                            e = e2;
                            e.printStackTrace();
                            if (ListUtils.isEmpty(arrayList)) {
                            }
                        }
                    }
                }
                j2 = j4;
            } catch (JSONException e3) {
                j2 = j4;
                e = e3;
            }
            if (ListUtils.isEmpty(arrayList)) {
                g gVar = (g) arrayList.get(0);
                com.baidu.live.gift.a.c cVar2 = new com.baidu.live.gift.a.c(gVar.GX(), j3, gVar, str9, str10, nameShow, str, str2, z, str3, str4, j);
                cVar2.aQ(System.currentTimeMillis());
                cVar2.bcM = false;
                cVar2.bY(true);
                cVar2.chatMCastId = str5;
                cVar2.ensureMCastId = str6;
                cVar2.bdf = cVar.bdf;
                if (com.baidu.live.ae.a.RB().brA.aMS && !TextUtils.isEmpty(str8)) {
                    k kVar = new k();
                    if (kVar.gY(str8)) {
                        cVar2.bcN.aWg = kVar;
                    }
                }
                if (arrayList.size() >= 2) {
                    com.baidu.live.gift.w.a(j, gVar.GX(), str9, nameShow, j3, j2);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar2));
            }
        }
    }

    @Override // com.baidu.live.gift.ac
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        g gVar = new g();
        gVar.gW(str);
        gVar.setGiftName(str2);
        gVar.gX("" + j);
        gVar.setThumbnailUrl(str3);
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2);
        cVar.aQ(System.currentTimeMillis());
        cVar.bcM = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bY(z3);
        cVar.bda = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    @Override // com.baidu.live.gift.ac
    protected void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        g gVar = new g();
        gVar.gW(str);
        gVar.setGiftName(str2);
        gVar.gX("" + j);
        gVar.setThumbnailUrl(str3);
        a(str, j, str4, str6, str5, j2, z, false, false, (JSONObject) null, "");
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2);
        cVar.aQ(System.currentTimeMillis());
        cVar.bcM = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bY(z3);
        cVar.bda = false;
        cVar.bdb = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    @Override // com.baidu.live.gift.ac
    protected void ho(String str) {
        if (this.bfh == null) {
            this.bfh = new com.baidu.live.gift.d.a();
        }
        this.bfh.hQ(str);
    }

    @Override // com.baidu.live.gift.ac
    protected void a(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        if (this.bfh == null) {
            this.bfh = new com.baidu.live.gift.d.a();
        }
        this.bfh.a(str, "", str2, str3, str4, 1, 0, "", System.currentTimeMillis());
    }

    private void a(String str, long j, String str2, String str3, String str4, long j2, boolean z, boolean z2, boolean z3, JSONObject jSONObject, String str5) {
        if (hm(str)) {
            if (!ht(str)) {
                if (BdNetTypeUtil.isWifiNet() || !l.Ww()) {
                    if (this.beZ == null) {
                        this.beZ = new ArrayList<>();
                    }
                    com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, null, str2, str4, str3, "", "", false, "", "", j2, z3, jSONObject);
                    cVar.bdf = str5;
                    this.beZ.add(cVar);
                    com.baidu.live.gift.c hP = Kv().hP(str);
                    if (hP != null) {
                        a.Ku().a(hP.aVv, false);
                    }
                }
            }
        } else if (z2) {
            g(z, str);
        }
    }

    @Override // com.baidu.live.gift.ac
    public void Iu() {
        if (ListUtils.isEmpty(this.bfa)) {
            this.bfi = true;
            return;
        }
        for (com.baidu.live.gift.c cVar : this.bfa) {
            if (cVar != null && cVar.aVv != null && !Kv().hk(cVar.getDynamicGiftId())) {
                com.baidu.live.gift.b bVar = cVar.aVv;
                if (bVar.aVt != null) {
                    a.Ku().a(bVar, false);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.ac
    protected com.baidu.live.gift.c hp(String str) {
        if (!TextUtils.isEmpty(str) && !ListUtils.isEmpty(this.bfa)) {
            for (com.baidu.live.gift.c cVar : this.bfa) {
                if (cVar.aVv != null && cVar.aVv.aVt != null && str.equals(cVar.aVv.aVt.zipName)) {
                    return cVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.live.gift.ac
    public void onDestroy() {
        this.bfi = false;
        MessageManager.getInstance().unRegisterListener(this.bfo);
        MessageManager.getInstance().unRegisterListener(this.bfm);
        MessageManager.getInstance().unRegisterListener(this.bfn);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bfg != null) {
            this.bfg.onDestroy();
            this.bfg = null;
        }
        if (this.bfd != null) {
            this.bfd.onDestroy();
            this.bfd = null;
        }
        if (this.bfe != null) {
            this.bfe.onDestroy();
            this.bfe = null;
        }
        if (this.bff != null) {
            this.bff.onDestroy();
            this.bff = null;
        }
        if (this.bfh != null) {
            this.bfh.release();
            this.bfh = null;
        }
        if (this.beZ != null) {
            this.beZ.clear();
        }
        a.Ku().Id();
        this.baV.clear();
        this.bfa.clear();
        this.aLD = null;
        this.bfj = null;
    }
}
