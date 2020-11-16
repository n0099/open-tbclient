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
    private static volatile b bPl;
    private w aIK;
    private ArrayList<g> aXD;
    private com.baidu.live.yuyingift.giftlist.a bPm;
    private com.baidu.live.yuyingift.giftlist.b bPn;
    private c bPo;
    private com.baidu.live.yuyingift.c.b bPp;
    private ArrayList<com.baidu.live.gift.c> baN;
    private ArrayList<com.baidu.live.yuyingift.a.c> bbb;
    private Map<String, com.baidu.live.yuyingift.a.b> bbd;
    private com.baidu.live.m.c bbg;
    private String bbk;
    private boolean bbj = false;
    private c.a bPq = new c.a() { // from class: com.baidu.live.yuyingift.b.b.1
        @Override // com.baidu.live.yuyingift.b.c.a
        public void b(int i, String str, int i2, Object obj, long j) {
            b.this.a(i, str, i2, obj, j);
        }
    };
    private a.InterfaceC0236a bPr = new a.InterfaceC0236a() { // from class: com.baidu.live.yuyingift.b.b.2
        @Override // com.baidu.live.yuyingift.giftlist.a.InterfaceC0236a
        public void n(ArrayList<com.baidu.live.gift.c> arrayList) {
            b.this.baN.clear();
            if (!ListUtils.isEmpty(arrayList)) {
                b.this.baN.addAll(arrayList);
                if (b.this.bbj) {
                    b.this.GD();
                }
            }
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.yuyingift.b.b.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Map.Entry entry;
            if (message.what == 100) {
                Set entrySet = b.this.bbd.entrySet();
                if (!entrySet.isEmpty()) {
                    if (b.this.bPo != null && !b.this.bPo.mIsSending && (entry = (Map.Entry) entrySet.iterator().next()) != null) {
                        b.this.bPo.a((com.baidu.live.yuyingift.a.b) entry.getValue());
                        b.this.bbd.remove(entry.getKey());
                    }
                    b.this.mHandler.sendEmptyMessage(100);
                } else {
                    return true;
                }
            }
            return false;
        }
    });
    private CustomMessageListener bbp = new CustomMessageListener(2913078) { // from class: com.baidu.live.yuyingift.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.f.c cVar;
            g gW;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.f.c) && !ListUtils.isEmpty(b.this.bbb) && (cVar = (com.baidu.live.f.c) customResponsedMessage.getData()) != null && cVar.aRq != null && cVar.aRp == 5) {
                String id = cVar.aRq.getId();
                ArrayList arrayList = new ArrayList();
                Iterator it = b.this.bbb.iterator();
                while (it.hasNext()) {
                    com.baidu.live.yuyingift.a.c cVar2 = (com.baidu.live.yuyingift.a.c) it.next();
                    if (!TextUtils.isEmpty(cVar2.giftId) && cVar2.giftId.equals(id) && (gW = ah.gW(cVar2.giftId)) != null) {
                        arrayList.add(cVar2);
                        b.this.a(cVar2.giftId, cVar2.aZw, gW.Fl(), gW.getThumbnail_url(), cVar2.userId, cVar2.portrait, cVar2.userName, "", "", false, "", "", "", cVar2.chatMCastId, cVar2.ensureMCastId, cVar2.msgId, cVar2.biJ, false);
                    }
                }
                b.this.bbb.removeAll(arrayList);
                com.baidu.live.gift.c hr = b.this.hr(id);
                if (hr != null && hr.aSt != null && hr.aSt.aSr != null) {
                    u.gu(hr.aSt.aSr.zipName);
                }
            }
        }
    };

    public static b WV() {
        if (bPl == null) {
            synchronized (b.class) {
                if (bPl == null) {
                    bPl = new b();
                }
            }
        }
        return bPl;
    }

    private b() {
        a((ah) this);
        this.baN = new ArrayList<>();
        this.aXD = new ArrayList<>();
        this.bbd = new HashMap();
    }

    @Override // com.baidu.live.gift.ah
    protected w Gz() {
        return this.aIK;
    }

    @Override // com.baidu.live.gift.ah
    protected void setLiveShowData(w wVar) {
        this.aIK = wVar;
    }

    @Override // com.baidu.live.gift.ah
    protected String GA() {
        return this.bbk;
    }

    @Override // com.baidu.live.gift.ah
    protected void gN(String str) {
        this.bbk = str;
    }

    @Override // com.baidu.live.gift.ah
    public void a(BdPageContext bdPageContext, boolean z) {
        MessageManager.getInstance().registerListener(this.bbp);
        if (this.bPn == null) {
            this.bPn = new com.baidu.live.yuyingift.giftlist.b(bdPageContext);
        }
        if (this.bPm == null) {
            this.bPm = new com.baidu.live.yuyingift.giftlist.a(bdPageContext);
            this.bPm.a(this.bPr);
        }
        g(z, null);
        if (this.bPo == null) {
            this.bPo = new c(bdPageContext);
            this.bPo.setUniqueId(BdUniqueId.gen());
        }
        this.bPo.initListener();
        this.bPo.a(this.bPq);
        if (this.bbg == null) {
            this.bbg = new com.baidu.live.m.c();
        }
        this.bbg.initListener();
        this.bbg.refreshCurUserScores();
    }

    @Override // com.baidu.live.gift.ah
    public void GB() {
        if (AlaLiveSwitchData.isHotLive == 0) {
            this.bPn.a(s.Ub(), true, "enter", "gift_init");
        }
    }

    private void g(boolean z, String str) {
        this.bPm.setHost(z);
        this.bPm.hq(str);
    }

    @Override // com.baidu.live.gift.ah
    public String GC() {
        return s.Ub();
    }

    public void e(String str, ArrayList<h> arrayList) {
        if (!ListUtils.isEmpty(arrayList)) {
            if (this.aXD == null) {
                this.aXD = new ArrayList<>();
            }
            Iterator<h> it = arrayList.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (!ListUtils.isEmpty(next.FL())) {
                    c(str, next.FL());
                }
            }
        }
    }

    private void c(String str, List<g> list) {
        boolean z;
        if (!ListUtils.isEmpty(list)) {
            for (g gVar : list) {
                Iterator<g> it = this.aXD.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    g next = it.next();
                    if (next != null && !TextUtils.isEmpty(next.Fk()) && next.Fk().equals(gVar.Fk())) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    gVar.setSceneFrom(str);
                    this.aXD.add(gVar);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.ah
    public boolean gR(String str) {
        if (StringUtils.isNull(str) || ListUtils.isEmpty(this.baN)) {
            return false;
        }
        for (int i = 0; i < this.baN.size(); i++) {
            if (str.equals(this.baN.get(i).getDynamicGiftId())) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.live.gift.c hr(String str) {
        if (!StringUtils.isNull(str) && !ListUtils.isEmpty(this.baN)) {
            boolean z = UtilHelper.getRealScreenOrientation(TbadkCoreApplication.getInst().getContext()) == 2;
            for (int i = 0; i < this.baN.size(); i++) {
                com.baidu.live.gift.c cVar = this.baN.get(i);
                if (str.equals(cVar.getDynamicGiftId()) && z == cVar.isLandScapeZip()) {
                    return cVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.live.gift.ah
    protected String gO(String str) {
        com.baidu.live.gift.c hr = WV().hr(str);
        if (hr == null || hr.aSt == null || hr.aSt.aSr == null) {
            return null;
        }
        return (com.baidu.live.alphavideo.a.BC().BD() && hr.aSt.ES()) ? hr.aSt.aSr.videoUrl : hr.aSt.aSr.zipDownloadUrl;
    }

    @Override // com.baidu.live.gift.ah
    public boolean gP(String str) {
        com.baidu.live.gift.c hr;
        if (StringUtils.isNull(str) || (hr = hr(str)) == null || hr.aSt == null) {
            return false;
        }
        if (com.baidu.live.alphavideo.a.BC().BD() && hr.aSt.ES() && !TextUtils.isEmpty(hr.ET())) {
            return true;
        }
        return ListUtils.isEmpty(hr.getDynamicGiftPicPathList()) ? false : true;
    }

    @Override // com.baidu.live.gift.ah
    protected boolean gQ(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return ak.GO().ar(str, gO(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, Object obj, long j) {
        if (i2 == 1 || i2 == 2) {
            if (i >= 0) {
                if (this.bbd != null && this.bbd.size() == 0) {
                    if (i == 0) {
                        if (i2 == 1) {
                            TbadkCoreApplication.getInst().currentAccountTdouNum = ((Long) obj).longValue();
                        } else {
                            TbadkCoreApplication.getInst().currentAccountFlowerNum = ((Long) obj).longValue();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                    } else if (this.bbg != null) {
                        this.bbg.refreshCurUserScores();
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
            if (gVar.Fv()) {
                TiebaInitialize.log(new StatisticItem("c12792").param("obj_id", gVar.Fk()).param("obj_param1", gVar.Fn()).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, gP(gVar.Fk()) ? 1 : 0));
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
        com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(gVar.Fk(), j, gVar, currentAccountInfo.getID(), currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), currentAccountInfo.getLiveLevel(), currentAccountInfo.getSex(), "", -1, str3, "", false, str, str4, j2, str5);
        cVar.aTP = j3;
        cVar.as(System.currentTimeMillis());
        cVar.aZp = true;
        com.baidu.live.yuyingift.b.f(cVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, long j2, String str7) {
        if (this.bPo != null) {
            com.baidu.live.yuyingift.a.b bVar = new com.baidu.live.yuyingift.a.b(gVar, j, str, str2, str3, str4, str5, str6, gVar.getThumbnail_url(), j2, str7);
            if (j == 1) {
                bVar.aUP = 0;
            } else {
                bVar.aUP = 1;
            }
            bVar.aZo.put(Long.valueOf(j2), Long.valueOf(j));
            if (this.bPo.mIsSending || !this.bbd.isEmpty()) {
                String A = r.A(gVar.Fk(), str, str7);
                com.baidu.live.yuyingift.a.b bVar2 = this.bbd.get(A);
                if (bVar2 == null) {
                    this.bbd.put(A, bVar);
                } else {
                    bVar2.aZo.put(Long.valueOf(j2), Long.valueOf(j));
                    bVar2.aZm += j;
                }
                this.mHandler.sendEmptyMessage(100);
                return;
            }
            this.bPo.a(bVar);
        }
    }

    @Override // com.baidu.live.gift.ah
    public g gM(String str) {
        if (TextUtils.isEmpty(str) || this.aXD == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.aXD.size()) {
                return null;
            }
            g gVar = this.aXD.get(i2);
            if (!str.equals(gVar.Fk())) {
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
            g gM = gM(str);
            if (gM == null) {
                String sharedPrefKeyWithAccount = d.getSharedPrefKeyWithAccount("last_send_get_gift_list_time_yuyin");
                if (System.currentTimeMillis() - d.Aq().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                    d.Aq().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                }
                gM = new g();
                gM.gB(str);
                gM.setGiftName(str2);
                gM.gC("" + j);
                gM.setThumbnailUrl(str3);
                BdResourceLoader.getInstance().loadResource(gM.getThumbnail_url(), 10, null, BdUniqueId.gen());
            }
            com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(str, j, gM, str4, str5, str6, str7, str8, z, str9, str10, j2, str14);
            cVar.as(System.currentTimeMillis());
            cVar.aZp = false;
            cVar.bP(z3);
            cVar.chatMCastId = str12;
            cVar.ensureMCastId = str13;
            if (com.baidu.live.aa.a.Ph().bms.aJX && !TextUtils.isEmpty(str11)) {
                k kVar = new k();
                if (kVar.gD(str11)) {
                    cVar.aZq.aTc = kVar;
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
                            g gM = gM(optString);
                            if (gM == null) {
                                String sharedPrefKeyWithAccount = d.getSharedPrefKeyWithAccount("last_send_get_gift_list_time_yuyin");
                                if (System.currentTimeMillis() - d.Aq().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                                    d.Aq().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                                }
                                gM = new g();
                                gM.gB(optString);
                                gM.setGiftName(optString2);
                                gM.setThumbnailUrl(optString3);
                                BdResourceLoader.getInstance().loadResource(gM.getThumbnail_url(), 10, null, BdUniqueId.gen());
                            }
                            arrayList.add(gM);
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
                com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(gVar.Fk(), j3, gVar, str2, str3, str4, str5, str6, z, str7, str8, j, str12);
                cVar.as(System.currentTimeMillis());
                cVar.aZp = false;
                cVar.bP(true);
                cVar.chatMCastId = str10;
                cVar.ensureMCastId = str11;
                if (com.baidu.live.aa.a.Ph().bms.aJX && !TextUtils.isEmpty(str9)) {
                    k kVar = new k();
                    if (kVar.gD(str9)) {
                        cVar.aZq.aTc = kVar;
                    }
                }
                if (arrayList.size() >= 2) {
                    com.baidu.live.yuyingift.b.a(j, gVar.Fk(), str2, str4, j3, j2, str12);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
            }
        }
    }

    @Override // com.baidu.live.gift.ah
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12) {
        g gVar = new g();
        gVar.gB(str);
        gVar.setGiftName(str2);
        gVar.gC("" + j);
        gVar.setThumbnailUrl(str3);
        com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2, str12);
        cVar.as(System.currentTimeMillis());
        cVar.aZp = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bP(z3);
        cVar.aZB = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
    }

    @Override // com.baidu.live.gift.ah
    protected void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12) {
        g gVar = new g();
        gVar.gB(str);
        gVar.setGiftName(str2);
        gVar.gC("" + j);
        gVar.setThumbnailUrl(str3);
        a(str, j, str4, str6, str5, j2, str12, z, false);
        com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2, str12);
        cVar.as(System.currentTimeMillis());
        cVar.aZp = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bP(z3);
        cVar.aZB = false;
        cVar.aZC = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
    }

    @Override // com.baidu.live.gift.ah
    protected void gT(String str) {
        if (this.bPp == null) {
            this.bPp = new com.baidu.live.yuyingift.c.c();
        }
        this.bPp.hs(str);
    }

    @Override // com.baidu.live.gift.ah
    protected void a(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6) {
        if (this.bPp == null) {
            this.bPp = new com.baidu.live.yuyingift.c.c();
        }
        this.bPp.a(str, str2, str3, str4, 1, 0, "", str6, System.currentTimeMillis());
    }

    private void a(String str, long j, String str2, String str3, String str4, long j2, String str5, boolean z, boolean z2) {
        if (gR(str)) {
            if (!gY(str)) {
                if (BdNetTypeUtil.isWifiNet() || !l.TW()) {
                    if (this.bbb == null) {
                        this.bbb = new ArrayList<>();
                    }
                    this.bbb.add(new com.baidu.live.yuyingift.a.c(str, j, null, str2, str4, str3, "", "", false, "", "", j2, str5));
                    com.baidu.live.gift.c hr = WV().hr(str);
                    if (hr != null) {
                        ak.GO().a(hr.aSt, false, false);
                    }
                }
            }
        } else if (z2) {
            g(z, str);
        }
    }

    @Override // com.baidu.live.gift.ah
    public void GD() {
        if (ListUtils.isEmpty(this.baN)) {
            this.bbj = true;
            return;
        }
        Iterator<com.baidu.live.gift.c> it = this.baN.iterator();
        while (it.hasNext()) {
            com.baidu.live.gift.c next = it.next();
            if (next != null && next.aSt != null && !WV().gP(next.getDynamicGiftId())) {
                com.baidu.live.gift.b bVar = next.aSt;
                if (bVar.aSr != null) {
                    ak.GO().a(bVar, false, false);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.ah
    public void onDestroy() {
        this.bbj = false;
        MessageManager.getInstance().unRegisterListener(this.bbp);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bPo != null) {
            this.bPo.onDestroy();
            this.bPo = null;
        }
        if (this.bPm != null) {
            this.bPm.onDestroy();
            this.bPm = null;
        }
        if (this.bPn != null) {
            this.bPn.onDestroy();
            this.bPn = null;
        }
        if (this.bbg != null) {
            this.bbg.onDestroy();
            this.bbg = null;
        }
        if (this.bPp != null) {
            this.bPp.release();
            this.bPp = null;
        }
        if (this.bbb != null) {
            this.bbb.clear();
        }
        ak.GO().Go();
        this.aXD.clear();
        this.baN.clear();
        this.aIK = null;
        this.bbk = null;
    }
}
