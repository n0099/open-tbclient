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
import com.baidu.live.gift.ah;
import com.baidu.live.gift.ak;
import com.baidu.live.gift.g;
import com.baidu.live.gift.h;
import com.baidu.live.gift.k;
import com.baidu.live.gift.u;
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
public class b extends ah {
    private static volatile b bQV;
    private w aKv;
    private ArrayList<g> aZo;
    private com.baidu.live.yuyingift.giftlist.a bQW;
    private com.baidu.live.yuyingift.giftlist.b bQX;
    private c bQY;
    private com.baidu.live.yuyingift.c.b bQZ;
    private ArrayList<com.baidu.live.yuyingift.a.c> bcM;
    private Map<String, com.baidu.live.yuyingift.a.b> bcO;
    private com.baidu.live.m.c bcR;
    private String bcV;
    private ArrayList<com.baidu.live.gift.c> bcy;
    private boolean bcU = false;
    private c.a bRa = new c.a() { // from class: com.baidu.live.yuyingift.b.b.1
        @Override // com.baidu.live.yuyingift.b.c.a
        public void b(int i, String str, int i2, Object obj, long j) {
            b.this.a(i, str, i2, obj, j);
        }
    };
    private a.InterfaceC0238a bRb = new a.InterfaceC0238a() { // from class: com.baidu.live.yuyingift.b.b.2
        @Override // com.baidu.live.yuyingift.giftlist.a.InterfaceC0238a
        public void n(ArrayList<com.baidu.live.gift.c> arrayList) {
            b.this.bcy.clear();
            if (!ListUtils.isEmpty(arrayList)) {
                b.this.bcy.addAll(arrayList);
                if (b.this.bcU) {
                    b.this.Hm();
                }
            }
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.yuyingift.b.b.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Map.Entry entry;
            if (message.what == 100) {
                Set entrySet = b.this.bcO.entrySet();
                if (!entrySet.isEmpty()) {
                    if (b.this.bQY != null && !b.this.bQY.mIsSending && (entry = (Map.Entry) entrySet.iterator().next()) != null) {
                        b.this.bQY.a((com.baidu.live.yuyingift.a.b) entry.getValue());
                        b.this.bcO.remove(entry.getKey());
                    }
                    b.this.mHandler.sendEmptyMessage(100);
                } else {
                    return true;
                }
            }
            return false;
        }
    });
    private CustomMessageListener bda = new CustomMessageListener(2913078) { // from class: com.baidu.live.yuyingift.b.b.4
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
                    com.baidu.live.yuyingift.a.c cVar2 = (com.baidu.live.yuyingift.a.c) it.next();
                    if (!TextUtils.isEmpty(cVar2.giftId) && cVar2.giftId.equals(id) && (hc = ah.hc(cVar2.giftId)) != null) {
                        arrayList.add(cVar2);
                        b.this.a(cVar2.giftId, cVar2.bbi, hc.FU(), hc.getThumbnail_url(), cVar2.userId, cVar2.portrait, cVar2.userName, "", "", false, "", "", "", cVar2.chatMCastId, cVar2.ensureMCastId, cVar2.msgId, cVar2.bku, false);
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

    public static b XE() {
        if (bQV == null) {
            synchronized (b.class) {
                if (bQV == null) {
                    bQV = new b();
                }
            }
        }
        return bQV;
    }

    private b() {
        a((ah) this);
        this.bcy = new ArrayList<>();
        this.aZo = new ArrayList<>();
        this.bcO = new HashMap();
    }

    @Override // com.baidu.live.gift.ah
    protected w Hi() {
        return this.aKv;
    }

    @Override // com.baidu.live.gift.ah
    protected void setLiveShowData(w wVar) {
        this.aKv = wVar;
    }

    @Override // com.baidu.live.gift.ah
    protected String Hj() {
        return this.bcV;
    }

    @Override // com.baidu.live.gift.ah
    protected void gT(String str) {
        this.bcV = str;
    }

    @Override // com.baidu.live.gift.ah
    public void a(BdPageContext bdPageContext, boolean z) {
        MessageManager.getInstance().registerListener(this.bda);
        if (this.bQX == null) {
            this.bQX = new com.baidu.live.yuyingift.giftlist.b(bdPageContext);
        }
        if (this.bQW == null) {
            this.bQW = new com.baidu.live.yuyingift.giftlist.a(bdPageContext);
            this.bQW.a(this.bRb);
        }
        g(z, null);
        if (this.bQY == null) {
            this.bQY = new c(bdPageContext);
            this.bQY.setUniqueId(BdUniqueId.gen());
        }
        this.bQY.initListener();
        this.bQY.a(this.bRa);
        if (this.bcR == null) {
            this.bcR = new com.baidu.live.m.c();
        }
        this.bcR.initListener();
        this.bcR.refreshCurUserScores();
    }

    @Override // com.baidu.live.gift.ah
    public void Hk() {
        if (AlaLiveSwitchData.isHotLive == 0) {
            this.bQX.a(s.UK(), true, "enter", "gift_init");
        }
    }

    private void g(boolean z, String str) {
        this.bQW.setHost(z);
        this.bQW.hw(str);
    }

    @Override // com.baidu.live.gift.ah
    public String Hl() {
        return s.UK();
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

    @Override // com.baidu.live.gift.ah
    public boolean gX(String str) {
        if (StringUtils.isNull(str) || ListUtils.isEmpty(this.bcy)) {
            return false;
        }
        for (int i = 0; i < this.bcy.size(); i++) {
            if (str.equals(this.bcy.get(i).getDynamicGiftId())) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.live.gift.c hx(String str) {
        if (!StringUtils.isNull(str) && !ListUtils.isEmpty(this.bcy)) {
            boolean z = UtilHelper.getRealScreenOrientation(TbadkCoreApplication.getInst().getContext()) == 2;
            for (int i = 0; i < this.bcy.size(); i++) {
                com.baidu.live.gift.c cVar = this.bcy.get(i);
                if (str.equals(cVar.getDynamicGiftId()) && z == cVar.isLandScapeZip()) {
                    return cVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.live.gift.ah
    protected String gU(String str) {
        com.baidu.live.gift.c hx = XE().hx(str);
        if (hx == null || hx.aUe == null || hx.aUe.aUc == null) {
            return null;
        }
        return (com.baidu.live.alphavideo.a.Cl().Cm() && hx.aUe.FB()) ? hx.aUe.aUc.videoUrl : hx.aUe.aUc.zipDownloadUrl;
    }

    @Override // com.baidu.live.gift.ah
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

    @Override // com.baidu.live.gift.ah
    protected boolean gW(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return ak.Hx().as(str, gU(str));
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

    public void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, long j3, String str8) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), TbadkCoreApplication.getInst().getContext().getResources().getString(a.h.sdk_no_network_guide));
        } else if (gVar != null) {
            if (gVar.Ge()) {
                TiebaInitialize.log(new StatisticItem("c12792").param("obj_id", gVar.FT()).param("obj_param1", gVar.FW()).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, gV(gVar.FT()) ? 1 : 0));
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
        com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(gVar.FT(), j, gVar, currentAccountInfo.getID(), currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), currentAccountInfo.getLiveLevel(), currentAccountInfo.getSex(), "", -1, str3, "", false, str, str4, j2, str5);
        cVar.aVA = j3;
        cVar.as(System.currentTimeMillis());
        cVar.bbb = true;
        com.baidu.live.yuyingift.b.f(cVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, long j2, String str7) {
        if (this.bQY != null) {
            com.baidu.live.yuyingift.a.b bVar = new com.baidu.live.yuyingift.a.b(gVar, j, str, str2, str3, str4, str5, str6, gVar.getThumbnail_url(), j2, str7);
            if (j == 1) {
                bVar.aWA = 0;
            } else {
                bVar.aWA = 1;
            }
            bVar.bba.put(Long.valueOf(j2), Long.valueOf(j));
            if (this.bQY.mIsSending || !this.bcO.isEmpty()) {
                String A = r.A(gVar.FT(), str, str7);
                com.baidu.live.yuyingift.a.b bVar2 = this.bcO.get(A);
                if (bVar2 == null) {
                    this.bcO.put(A, bVar);
                } else {
                    bVar2.bba.put(Long.valueOf(j2), Long.valueOf(j));
                    bVar2.baY += j;
                }
                this.mHandler.sendEmptyMessage(100);
                return;
            }
            this.bQY.a(bVar);
        }
    }

    @Override // com.baidu.live.gift.ah
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

    @Override // com.baidu.live.gift.ah
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
            g gS = gS(str);
            if (gS == null) {
                String sharedPrefKeyWithAccount = d.getSharedPrefKeyWithAccount("last_send_get_gift_list_time_yuyin");
                if (System.currentTimeMillis() - d.AZ().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                    d.AZ().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                }
                gS = new g();
                gS.gH(str);
                gS.setGiftName(str2);
                gS.gI("" + j);
                gS.setThumbnailUrl(str3);
                BdResourceLoader.getInstance().loadResource(gS.getThumbnail_url(), 10, null, BdUniqueId.gen());
            }
            com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(str, j, gS, str4, str5, str6, str7, str8, z, str9, str10, j2, str14);
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
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.live.gift.ah
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
                            g gS = gS(optString);
                            if (gS == null) {
                                String sharedPrefKeyWithAccount = d.getSharedPrefKeyWithAccount("last_send_get_gift_list_time_yuyin");
                                if (System.currentTimeMillis() - d.AZ().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                                    d.AZ().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
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
                com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(gVar.FT(), j3, gVar, str2, str3, str4, str5, str6, z, str7, str8, j, str12);
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
                    com.baidu.live.yuyingift.b.a(j, gVar.FT(), str2, str4, j3, j2, str12);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
            }
        }
    }

    @Override // com.baidu.live.gift.ah
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12) {
        g gVar = new g();
        gVar.gH(str);
        gVar.setGiftName(str2);
        gVar.gI("" + j);
        gVar.setThumbnailUrl(str3);
        com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2, str12);
        cVar.as(System.currentTimeMillis());
        cVar.bbb = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bN(z3);
        cVar.bbn = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
    }

    @Override // com.baidu.live.gift.ah
    protected void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12) {
        g gVar = new g();
        gVar.gH(str);
        gVar.setGiftName(str2);
        gVar.gI("" + j);
        gVar.setThumbnailUrl(str3);
        a(str, j, str4, str6, str5, j2, str12, z, false);
        com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2, str12);
        cVar.as(System.currentTimeMillis());
        cVar.bbb = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bN(z3);
        cVar.bbn = false;
        cVar.bbo = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
    }

    @Override // com.baidu.live.gift.ah
    protected void gZ(String str) {
        if (this.bQZ == null) {
            this.bQZ = new com.baidu.live.yuyingift.c.c();
        }
        this.bQZ.hy(str);
    }

    @Override // com.baidu.live.gift.ah
    protected void a(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6) {
        if (this.bQZ == null) {
            this.bQZ = new com.baidu.live.yuyingift.c.c();
        }
        this.bQZ.a(str, str2, str3, str4, 1, 0, "", str6, System.currentTimeMillis());
    }

    private void a(String str, long j, String str2, String str3, String str4, long j2, String str5, boolean z, boolean z2) {
        if (gX(str)) {
            if (!he(str)) {
                if (BdNetTypeUtil.isWifiNet() || !l.UF()) {
                    if (this.bcM == null) {
                        this.bcM = new ArrayList<>();
                    }
                    this.bcM.add(new com.baidu.live.yuyingift.a.c(str, j, null, str2, str4, str3, "", "", false, "", "", j2, str5));
                    com.baidu.live.gift.c hx = XE().hx(str);
                    if (hx != null) {
                        ak.Hx().a(hx.aUe, false, false);
                    }
                }
            }
        } else if (z2) {
            g(z, str);
        }
    }

    @Override // com.baidu.live.gift.ah
    public void Hm() {
        if (ListUtils.isEmpty(this.bcy)) {
            this.bcU = true;
            return;
        }
        Iterator<com.baidu.live.gift.c> it = this.bcy.iterator();
        while (it.hasNext()) {
            com.baidu.live.gift.c next = it.next();
            if (next != null && next.aUe != null && !XE().gV(next.getDynamicGiftId())) {
                com.baidu.live.gift.b bVar = next.aUe;
                if (bVar.aUc != null) {
                    ak.Hx().a(bVar, false, false);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.ah
    public void onDestroy() {
        this.bcU = false;
        MessageManager.getInstance().unRegisterListener(this.bda);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bQY != null) {
            this.bQY.onDestroy();
            this.bQY = null;
        }
        if (this.bQW != null) {
            this.bQW.onDestroy();
            this.bQW = null;
        }
        if (this.bQX != null) {
            this.bQX.onDestroy();
            this.bQX = null;
        }
        if (this.bcR != null) {
            this.bcR.onDestroy();
            this.bcR = null;
        }
        if (this.bQZ != null) {
            this.bQZ.release();
            this.bQZ = null;
        }
        if (this.bcM != null) {
            this.bcM.clear();
        }
        ak.Hx().GX();
        this.aZo.clear();
        this.bcy.clear();
        this.aKv = null;
        this.bcV = null;
    }
}
