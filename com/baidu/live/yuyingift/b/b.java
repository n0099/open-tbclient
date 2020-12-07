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
import com.baidu.live.gift.aj;
import com.baidu.live.gift.am;
import com.baidu.live.gift.g;
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
import com.baidu.live.utils.l;
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
public class b extends aj {
    private static volatile b bUv;
    private w aLD;
    private com.baidu.live.yuyingift.giftlist.a bUw;
    private com.baidu.live.yuyingift.giftlist.b bUx;
    private c bUy;
    private com.baidu.live.yuyingift.c.b bUz;
    private ArrayList<g> baV;
    private ArrayList<com.baidu.live.gift.c> beL;
    private ArrayList<com.baidu.live.yuyingift.a.c> beZ;
    private Map<String, com.baidu.live.yuyingift.a.b> bfc;
    private com.baidu.live.o.c bff;
    private String bfj;
    private boolean bfi = false;
    private c.a bUA = new c.a() { // from class: com.baidu.live.yuyingift.b.b.1
        @Override // com.baidu.live.yuyingift.b.c.a
        public void b(int i, String str, int i2, Object obj, long j) {
            b.this.a(i, str, i2, obj, j);
        }
    };
    private a.InterfaceC0245a bUB = new a.InterfaceC0245a() { // from class: com.baidu.live.yuyingift.b.b.2
        @Override // com.baidu.live.yuyingift.giftlist.a.InterfaceC0245a
        public void n(ArrayList<com.baidu.live.gift.c> arrayList) {
            b.this.beL.clear();
            if (!ListUtils.isEmpty(arrayList)) {
                b.this.beL.addAll(arrayList);
                if (b.this.bfi) {
                    b.this.Iu();
                }
            }
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.yuyingift.b.b.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Map.Entry entry;
            if (message.what == 100) {
                Set entrySet = b.this.bfc.entrySet();
                if (!entrySet.isEmpty()) {
                    if (b.this.bUy != null && !b.this.bUy.mIsSending && (entry = (Map.Entry) entrySet.iterator().next()) != null) {
                        b.this.bUy.a((com.baidu.live.yuyingift.a.b) entry.getValue());
                        b.this.bfc.remove(entry.getKey());
                    }
                    b.this.mHandler.sendEmptyMessage(100);
                } else {
                    return true;
                }
            }
            return false;
        }
    });
    private CustomMessageListener bfo = new CustomMessageListener(2913078) { // from class: com.baidu.live.yuyingift.b.b.4
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
                    com.baidu.live.yuyingift.a.c cVar2 = (com.baidu.live.yuyingift.a.c) it.next();
                    if (!TextUtils.isEmpty(cVar2.giftId) && cVar2.giftId.equals(id) && (hr = aj.hr(cVar2.giftId)) != null) {
                        arrayList.add(cVar2);
                        b.this.a(cVar2.giftId, cVar2.bcU, hr.GY(), hr.getThumbnail_url(), cVar2.userId, cVar2.portrait, cVar2.userName, "", "", false, "", "", "", cVar2.chatMCastId, cVar2.ensureMCastId, cVar2.msgId, cVar2.bnb, false);
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

    public static b Zu() {
        if (bUv == null) {
            synchronized (b.class) {
                if (bUv == null) {
                    bUv = new b();
                }
            }
        }
        return bUv;
    }

    private b() {
        a((aj) this);
        this.beL = new ArrayList<>();
        this.baV = new ArrayList<>();
        this.bfc = new HashMap();
    }

    @Override // com.baidu.live.gift.aj
    protected w Iq() {
        return this.aLD;
    }

    @Override // com.baidu.live.gift.aj
    protected void setLiveShowData(w wVar) {
        this.aLD = wVar;
    }

    @Override // com.baidu.live.gift.aj
    protected String Ir() {
        return this.bfj;
    }

    @Override // com.baidu.live.gift.aj
    protected void hi(String str) {
        this.bfj = str;
    }

    @Override // com.baidu.live.gift.aj
    public void a(BdPageContext bdPageContext, boolean z) {
        MessageManager.getInstance().registerListener(this.bfo);
        if (this.bUx == null) {
            this.bUx = new com.baidu.live.yuyingift.giftlist.b(bdPageContext);
        }
        if (this.bUw == null) {
            this.bUw = new com.baidu.live.yuyingift.giftlist.a(bdPageContext);
            this.bUw.a(this.bUB);
        }
        g(z, null);
        if (this.bUy == null) {
            this.bUy = new c(bdPageContext);
            this.bUy.setUniqueId(BdUniqueId.gen());
        }
        this.bUy.initListener();
        this.bUy.a(this.bUA);
        if (this.bff == null) {
            this.bff = new com.baidu.live.o.c();
        }
        this.bff.initListener();
        this.bff.refreshCurUserScores();
    }

    @Override // com.baidu.live.gift.aj
    public void Is() {
        if (AlaLiveSwitchData.isHotLive == 0) {
            this.bUx.a(s.WB(), true, "enter", "gift_init");
        }
    }

    private void g(boolean z, String str) {
        this.bUw.setHost(z);
        this.bUw.hO(str);
    }

    @Override // com.baidu.live.gift.aj
    public String It() {
        return s.WB();
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

    @Override // com.baidu.live.gift.aj
    public boolean hm(String str) {
        if (StringUtils.isNull(str) || ListUtils.isEmpty(this.beL)) {
            return false;
        }
        for (int i = 0; i < this.beL.size(); i++) {
            if (str.equals(this.beL.get(i).getDynamicGiftId())) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.live.gift.c hP(String str) {
        if (!StringUtils.isNull(str) && !ListUtils.isEmpty(this.beL)) {
            boolean z = UtilHelper.getRealScreenOrientation(TbadkCoreApplication.getInst().getContext()) == 2;
            for (int i = 0; i < this.beL.size(); i++) {
                com.baidu.live.gift.c cVar = this.beL.get(i);
                if (str.equals(cVar.getDynamicGiftId()) && z == cVar.isLandScapeZip()) {
                    return cVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.live.gift.aj
    protected String hj(String str) {
        com.baidu.live.gift.c hP = Zu().hP(str);
        if (hP == null || hP.aVv == null || hP.aVv.aVt == null) {
            return null;
        }
        return (com.baidu.live.alphavideo.a.Dl().Dm() && hP.aVv.GD()) ? hP.aVv.aVt.videoUrl : hP.aVv.aVt.zipDownloadUrl;
    }

    @Override // com.baidu.live.gift.aj
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

    @Override // com.baidu.live.gift.aj
    protected boolean hl(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return am.IF().aw(str, hj(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, Object obj, long j) {
        if (i2 == 1 || i2 == 2) {
            if (i >= 0) {
                if (this.bfc != null && this.bfc.size() == 0) {
                    if (i == 0) {
                        if (i2 == 1) {
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

    public void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, long j3, String str8) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), TbadkCoreApplication.getInst().getContext().getResources().getString(a.h.sdk_no_network_guide));
        } else if (gVar != null) {
            if (gVar.Hj()) {
                TiebaInitialize.log(new StatisticItem("c12792").param("obj_id", gVar.GX()).param("obj_param1", gVar.Ha()).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, hk(gVar.GX()) ? 1 : 0));
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
        com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(gVar.GX(), j, gVar, currentAccountInfo.getID(), currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), currentAccountInfo.getLiveLevel(), currentAccountInfo.getSex(), "", -1, str3, "", false, str, str4, j2, str5);
        cVar.aWT = j3;
        cVar.aQ(System.currentTimeMillis());
        cVar.bcM = true;
        com.baidu.live.yuyingift.b.f(cVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, long j2, String str7) {
        if (this.bUy != null) {
            com.baidu.live.yuyingift.a.b bVar = new com.baidu.live.yuyingift.a.b(gVar, j, str, str2, str3, str4, str5, str6, gVar.getThumbnail_url(), j2, str7);
            if (j == 1) {
                bVar.aXW = 0;
            } else {
                bVar.aXW = 1;
            }
            bVar.bcL.put(Long.valueOf(j2), Long.valueOf(j));
            if (this.bUy.mIsSending || !this.bfc.isEmpty()) {
                String D = r.D(gVar.GX(), str, str7);
                com.baidu.live.yuyingift.a.b bVar2 = this.bfc.get(D);
                if (bVar2 == null) {
                    this.bfc.put(D, bVar);
                } else {
                    bVar2.bcL.put(Long.valueOf(j2), Long.valueOf(j));
                    bVar2.bcJ += j;
                }
                this.mHandler.sendEmptyMessage(100);
                return;
            }
            this.bUy.a(bVar);
        }
    }

    @Override // com.baidu.live.gift.aj
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

    @Override // com.baidu.live.gift.aj
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
            g hh = hh(str);
            if (hh == null) {
                String sharedPrefKeyWithAccount = d.getSharedPrefKeyWithAccount("last_send_get_gift_list_time_yuyin");
                if (System.currentTimeMillis() - d.BM().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                    d.BM().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                }
                hh = new g();
                hh.gW(str);
                hh.setGiftName(str2);
                hh.gX("" + j);
                hh.setThumbnailUrl(str3);
                BdResourceLoader.getInstance().loadResource(hh.getThumbnail_url(), 10, null, BdUniqueId.gen());
            }
            com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(str, j, hh, str4, str5, str6, str7, str8, z, str9, str10, j2, str14);
            cVar.aQ(System.currentTimeMillis());
            cVar.bcM = false;
            cVar.bY(z3);
            cVar.chatMCastId = str12;
            cVar.ensureMCastId = str13;
            if (com.baidu.live.ae.a.RB().brA.aMS && !TextUtils.isEmpty(str11)) {
                k kVar = new k();
                if (kVar.gY(str11)) {
                    cVar.bcN.aWg = kVar;
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.live.gift.aj
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
                            g hh = hh(optString);
                            if (hh == null) {
                                String sharedPrefKeyWithAccount = d.getSharedPrefKeyWithAccount("last_send_get_gift_list_time_yuyin");
                                if (System.currentTimeMillis() - d.BM().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                                    d.BM().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                                }
                                hh = new g();
                                hh.gW(optString);
                                hh.setGiftName(optString2);
                                hh.setThumbnailUrl(optString3);
                                BdResourceLoader.getInstance().loadResource(hh.getThumbnail_url(), 10, null, BdUniqueId.gen());
                            }
                            arrayList.add(hh);
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
                com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(gVar.GX(), j3, gVar, str2, str3, str4, str5, str6, z, str7, str8, j, str12);
                cVar.aQ(System.currentTimeMillis());
                cVar.bcM = false;
                cVar.bY(true);
                cVar.chatMCastId = str10;
                cVar.ensureMCastId = str11;
                if (com.baidu.live.ae.a.RB().brA.aMS && !TextUtils.isEmpty(str9)) {
                    k kVar = new k();
                    if (kVar.gY(str9)) {
                        cVar.bcN.aWg = kVar;
                    }
                }
                if (arrayList.size() >= 2) {
                    com.baidu.live.yuyingift.b.a(j, gVar.GX(), str2, str4, j3, j2, str12);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
            }
        }
    }

    @Override // com.baidu.live.gift.aj
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12) {
        g gVar = new g();
        gVar.gW(str);
        gVar.setGiftName(str2);
        gVar.gX("" + j);
        gVar.setThumbnailUrl(str3);
        com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2, str12);
        cVar.aQ(System.currentTimeMillis());
        cVar.bcM = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bY(z3);
        cVar.bda = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
    }

    @Override // com.baidu.live.gift.aj
    protected void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12) {
        g gVar = new g();
        gVar.gW(str);
        gVar.setGiftName(str2);
        gVar.gX("" + j);
        gVar.setThumbnailUrl(str3);
        a(str, j, str4, str6, str5, j2, str12, z, false);
        com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2, str12);
        cVar.aQ(System.currentTimeMillis());
        cVar.bcM = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bY(z3);
        cVar.bda = false;
        cVar.bdb = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
    }

    @Override // com.baidu.live.gift.aj
    protected void ho(String str) {
        if (this.bUz == null) {
            this.bUz = new com.baidu.live.yuyingift.c.c();
        }
        this.bUz.hQ(str);
    }

    @Override // com.baidu.live.gift.aj
    protected void a(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6) {
        if (this.bUz == null) {
            this.bUz = new com.baidu.live.yuyingift.c.c();
        }
        this.bUz.a(str, str2, str3, str4, 1, 0, "", str6, System.currentTimeMillis());
    }

    private void a(String str, long j, String str2, String str3, String str4, long j2, String str5, boolean z, boolean z2) {
        if (hm(str)) {
            if (!ht(str)) {
                if (BdNetTypeUtil.isWifiNet() || !l.Ww()) {
                    if (this.beZ == null) {
                        this.beZ = new ArrayList<>();
                    }
                    this.beZ.add(new com.baidu.live.yuyingift.a.c(str, j, null, str2, str4, str3, "", "", false, "", "", j2, str5));
                    com.baidu.live.gift.c hP = Zu().hP(str);
                    if (hP != null) {
                        am.IF().a(hP.aVv, false, false);
                    }
                }
            }
        } else if (z2) {
            g(z, str);
        }
    }

    @Override // com.baidu.live.gift.aj
    public void Iu() {
        if (ListUtils.isEmpty(this.beL)) {
            this.bfi = true;
            return;
        }
        Iterator<com.baidu.live.gift.c> it = this.beL.iterator();
        while (it.hasNext()) {
            com.baidu.live.gift.c next = it.next();
            if (next != null && next.aVv != null && !Zu().hk(next.getDynamicGiftId())) {
                com.baidu.live.gift.b bVar = next.aVv;
                if (bVar.aVt != null) {
                    am.IF().a(bVar, false, false);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.aj
    public void onDestroy() {
        this.bfi = false;
        MessageManager.getInstance().unRegisterListener(this.bfo);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bUy != null) {
            this.bUy.onDestroy();
            this.bUy = null;
        }
        if (this.bUw != null) {
            this.bUw.onDestroy();
            this.bUw = null;
        }
        if (this.bUx != null) {
            this.bUx.onDestroy();
            this.bUx = null;
        }
        if (this.bff != null) {
            this.bff.onDestroy();
            this.bff = null;
        }
        if (this.bUz != null) {
            this.bUz.release();
            this.bUz = null;
        }
        if (this.beZ != null) {
            this.beZ.clear();
        }
        am.IF().Id();
        this.baV.clear();
        this.beL.clear();
        this.aLD = null;
        this.bfj = null;
    }
}
