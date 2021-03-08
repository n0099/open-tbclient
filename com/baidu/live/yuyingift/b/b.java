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
import com.baidu.live.data.ab;
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
import com.baidu.live.utils.m;
import com.baidu.live.utils.s;
import com.baidu.live.utils.t;
import com.baidu.live.yuyingift.a.c;
import com.baidu.live.yuyingift.c.c;
import com.baidu.live.yuyingift.giftlist.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends aj {
    private static volatile b cbe;
    private ab aLz;
    private ArrayList<g> bcv;
    private ArrayList<c> bgA;
    private com.baidu.live.o.c bgH;
    private String bgL;
    private ArrayList<com.baidu.live.gift.c> bgp;
    private LinkedHashMap<String, com.baidu.live.yuyingift.a.b> cbf;
    private com.baidu.live.yuyingift.giftlist.a cbg;
    private com.baidu.live.yuyingift.giftlist.b cbh;
    private com.baidu.live.yuyingift.c.c cbi;
    private com.baidu.live.yuyingift.c.b cbj;
    private boolean bgK = false;
    private c.a cbk = new c.a() { // from class: com.baidu.live.yuyingift.b.b.1
        @Override // com.baidu.live.yuyingift.c.c.a
        public void b(int i, String str, int i2, Object obj, long j) {
            b.this.a(i, str, i2, obj, j);
        }
    };
    private a.InterfaceC0243a cbl = new a.InterfaceC0243a() { // from class: com.baidu.live.yuyingift.b.b.2
        @Override // com.baidu.live.yuyingift.giftlist.a.InterfaceC0243a
        public void i(ArrayList<com.baidu.live.gift.c> arrayList) {
            b.this.bgp.clear();
            if (!ListUtils.isEmpty(arrayList)) {
                b.this.bgp.addAll(arrayList);
                if (b.this.bgK) {
                    b.this.Ft();
                }
            }
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.yuyingift.b.b.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Map.Entry entry;
            if (message.what == 100) {
                Set entrySet = b.this.cbf.entrySet();
                if (entrySet.isEmpty()) {
                    return true;
                }
                if (b.this.cbi != null && !b.this.cbi.mIsSending && (entry = (Map.Entry) entrySet.iterator().next()) != null) {
                    com.baidu.live.yuyingift.a.b bVar = (com.baidu.live.yuyingift.a.b) entry.getValue();
                    if (bVar == null) {
                        return true;
                    }
                    if (((com.baidu.live.yuyingift.a.b) entry.getValue()).bel > 0) {
                        b.this.cbi.a(bVar);
                    } else {
                        b.this.cbi.a(bVar.aOA, bVar.caB, bVar.caC, bVar.liveId, bVar.boO);
                    }
                    b.this.cbf.remove(entry.getKey());
                }
                b.this.mHandler.sendEmptyMessage(100);
            }
            return false;
        }
    });
    private CustomMessageListener bgQ = new CustomMessageListener(2913078) { // from class: com.baidu.live.yuyingift.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.h.c cVar;
            g gt;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.h.c) && !ListUtils.isEmpty(b.this.bgA) && (cVar = (com.baidu.live.h.c) customResponsedMessage.getData()) != null && cVar.aVC != null && cVar.aVB == 5) {
                String id = cVar.aVC.getId();
                ArrayList arrayList = new ArrayList();
                Iterator it = b.this.bgA.iterator();
                while (it.hasNext()) {
                    com.baidu.live.yuyingift.a.c cVar2 = (com.baidu.live.yuyingift.a.c) it.next();
                    if (!TextUtils.isEmpty(cVar2.giftId) && cVar2.giftId.equals(id) && (gt = aj.gt(cVar2.giftId)) != null) {
                        arrayList.add(cVar2);
                        b.this.a(cVar2.giftId, cVar2.bev, gt.DV(), gt.getThumbnail_url(), cVar2.userId, cVar2.portrait, cVar2.userName, "", "", false, "", "", "", cVar2.chatMCastId, cVar2.ensureMCastId, cVar2.msgId, cVar2.boO, false, cVar2.caD, cVar2.aZL, cVar2.caE, cVar2.caF);
                    }
                }
                b.this.bgA.removeAll(arrayList);
                com.baidu.live.gift.c gS = b.this.gS(id);
                if (gS != null && gS.aWS != null && gS.aWS.aWP != null) {
                    v.D(gS.aWS.aWP.zipName, gS.aWS.aWR);
                }
            }
        }
    };

    public static b Za() {
        if (cbe == null) {
            synchronized (b.class) {
                if (cbe == null) {
                    cbe = new b();
                }
            }
        }
        return cbe;
    }

    private b() {
        a((aj) this);
        this.bgp = new ArrayList<>();
        this.bcv = new ArrayList<>();
        this.cbf = new LinkedHashMap<>();
    }

    @Override // com.baidu.live.gift.aj
    protected ab Fp() {
        return this.aLz;
    }

    @Override // com.baidu.live.gift.aj
    protected void setLiveShowData(ab abVar) {
        this.aLz = abVar;
    }

    @Override // com.baidu.live.gift.aj
    protected String Fq() {
        return this.bgL;
    }

    @Override // com.baidu.live.gift.aj
    protected void gi(String str) {
        this.bgL = str;
    }

    @Override // com.baidu.live.gift.aj
    public void a(BdPageContext bdPageContext, boolean z, boolean z2) {
        MessageManager.getInstance().registerListener(this.bgQ);
        if (this.cbh == null) {
            this.cbh = new com.baidu.live.yuyingift.giftlist.b(bdPageContext);
        }
        if (this.cbg == null) {
            this.cbg = new com.baidu.live.yuyingift.giftlist.a(bdPageContext);
            this.cbg.a(this.cbl);
        }
        this.cbg.bZ(z2);
        k(z, null);
        if (this.cbi == null) {
            this.cbi = new com.baidu.live.yuyingift.c.c(bdPageContext);
            this.cbi.setUniqueId(BdUniqueId.gen());
        }
        this.cbi.initListener();
        this.cbi.a(this.cbk);
        if (this.bgH == null) {
            this.bgH = new com.baidu.live.o.c();
        }
        this.bgH.initListener();
        this.bgH.refreshCurUserScores();
    }

    @Override // com.baidu.live.gift.aj
    public void Fr() {
        if (AlaLiveSwitchData.isHotLive == 0) {
            this.cbh.a(t.Vx(), true, "enter", "gift_init");
        }
    }

    private void k(boolean z, String str) {
        this.cbg.setHost(z);
        this.cbg.gR(str);
    }

    @Override // com.baidu.live.gift.aj
    public String Fs() {
        return t.Vx();
    }

    public void e(String str, ArrayList<h> arrayList) {
        if (!ListUtils.isEmpty(arrayList)) {
            if (this.bcv == null) {
                this.bcv = new ArrayList<>();
            }
            Iterator<h> it = arrayList.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (!ListUtils.isEmpty(next.Ez())) {
                    c(str, next.Ez());
                }
            }
        }
    }

    private void c(String str, List<g> list) {
        boolean z;
        if (!ListUtils.isEmpty(list)) {
            for (g gVar : list) {
                Iterator<g> it = this.bcv.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    g next = it.next();
                    if (next != null && !TextUtils.isEmpty(next.DU()) && next.DU().equals(gVar.DU())) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    gVar.setSceneFrom(str);
                    this.bcv.add(gVar);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.aj
    public boolean gm(String str) {
        if (StringUtils.isNull(str) || ListUtils.isEmpty(this.bgp)) {
            return false;
        }
        for (int i = 0; i < this.bgp.size(); i++) {
            if (str.equals(this.bgp.get(i).getDynamicGiftId())) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.live.gift.c gS(String str) {
        if (!StringUtils.isNull(str) && !ListUtils.isEmpty(this.bgp)) {
            boolean z = UtilHelper.getRealScreenOrientation(TbadkCoreApplication.getInst().getContext()) == 2;
            for (int i = 0; i < this.bgp.size(); i++) {
                com.baidu.live.gift.c cVar = this.bgp.get(i);
                if (str.equals(cVar.getDynamicGiftId()) && z == cVar.isLandScapeZip()) {
                    return cVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.live.gift.aj
    protected String gj(String str) {
        com.baidu.live.gift.c gS = Za().gS(str);
        if (gS == null || gS.aWS == null || gS.aWS.aWP == null) {
            return null;
        }
        return (com.baidu.live.alphavideo.a.zr().zs() && gS.aWS.Dy()) ? gS.aWS.aWP.videoUrl : gS.aWS.aWP.zipDownloadUrl;
    }

    @Override // com.baidu.live.gift.aj
    public boolean gk(String str) {
        com.baidu.live.gift.c gS;
        if (StringUtils.isNull(str) || (gS = gS(str)) == null || gS.aWS == null) {
            return false;
        }
        if (com.baidu.live.alphavideo.a.zr().zs() && gS.aWS.Dy() && !TextUtils.isEmpty(gS.DB())) {
            return true;
        }
        return ListUtils.isEmpty(gS.getDynamicGiftPicPathList()) ? false : true;
    }

    @Override // com.baidu.live.gift.aj
    protected boolean gl(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return am.FF().at(str, gj(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, Object obj, long j) {
        if (i2 == 1 || i2 == 2) {
            if (i >= 0) {
                if (this.cbf != null && this.cbf.size() == 0) {
                    if (i == 0) {
                        if (i2 == 1) {
                            TbadkCoreApplication.getInst().currentAccountTdouNum = ((Long) obj).longValue();
                        } else {
                            TbadkCoreApplication.getInst().currentAccountFlowerNum = ((Long) obj).longValue();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                    } else if (this.bgH != null) {
                        this.bgH.refreshCurUserScores();
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

    public void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, long j3, String str8, long j4, int i) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), TbadkCoreApplication.getInst().getContext().getResources().getString(a.h.sdk_no_network_guide));
        } else if (gVar != null) {
            if (gVar.Ei()) {
                TiebaInitialize.log(new StatisticItem("c12792").param("obj_id", gVar.DU()).param("obj_param1", gVar.DZ()).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, gk(gVar.DU()) ? 1 : 0));
            }
            a(gVar, j, str, str2, str3, str5, j2, j3, str8, j4, i);
        }
    }

    public void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, String str8, long j3, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        a(gVar, j, str, str2, str3, str4, str5, str6, str7, j2, currentTimeMillis, str8, j3, i);
        a(gVar, j, str, str2, str3, str4, str6, str7, currentTimeMillis, str8, gVar.DY() ? 1 : 0, j3, i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4, long j2, long j3, String str5, long j4, int i) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(gVar.DU(), j, gVar, currentAccountInfo.getID(), currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), currentAccountInfo.getLiveLevel(), currentAccountInfo.getSex(), "", -1, str3, "", false, str, str4, j2, str5, j4);
        cVar.caD = gVar.DY();
        cVar.caE = i;
        cVar.aYr = j3;
        cVar.aS(System.currentTimeMillis());
        cVar.beo = true;
        com.baidu.live.yuyingift.b.f(cVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, long j2, String str7, int i, long j3, int i2) {
        if (this.cbi != null) {
            com.baidu.live.yuyingift.a.b bVar = new com.baidu.live.yuyingift.a.b(gVar, j, str, str2, str3, str4, str5, str6, gVar.getThumbnail_url(), j2, str7, i, j3, i2);
            if (j == 1) {
                bVar.aZw = 0;
            } else {
                bVar.aZw = 1;
            }
            bVar.ben.put(Long.valueOf(j2), Long.valueOf(j));
            if (this.cbi.mIsSending || !this.cbf.isEmpty()) {
                String a2 = s.a(j3, gVar.DU(), str, str7);
                com.baidu.live.yuyingift.a.b bVar2 = this.cbf.get(a2);
                if (bVar2 == null) {
                    this.cbf.put(a2, bVar);
                } else {
                    bVar2.ben.put(Long.valueOf(j2), Long.valueOf(j));
                    bVar2.bel += j;
                }
                this.mHandler.sendEmptyMessage(100);
                return;
            }
            this.cbi.a(bVar);
        }
    }

    public void a(long j, int i, String str, String str2, String str3) {
        if (this.cbi.mIsSending) {
            if (j > 0) {
                String valueOf = String.valueOf(j);
                com.baidu.live.yuyingift.a.b bVar = new com.baidu.live.yuyingift.a.b();
                bVar.bel = -1L;
                bVar.aOA = str;
                bVar.liveId = str2;
                bVar.caB = j;
                bVar.boO = str3;
                this.cbf.put(valueOf, bVar);
                this.mHandler.sendEmptyMessage(100);
            }
        } else if (this.cbi != null) {
            this.cbi.a(str, j, i, str2, str3);
        }
    }

    @Override // com.baidu.live.gift.aj
    public g gh(String str) {
        if (TextUtils.isEmpty(str) || this.bcv == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.bcv.size()) {
                return null;
            }
            g gVar = this.bcv.get(i2);
            if (!str.equals(gVar.DU())) {
                i = i2 + 1;
            } else {
                return gVar;
            }
        }
    }

    @Override // com.baidu.live.gift.aj
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2, String str14, boolean z2, boolean z3, long j3, int i, boolean z4) {
        a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, true, true, str12, str13, j2, str14, z2, z3, j3, i, z4);
    }

    public void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, String str12, String str13, long j2, String str14, boolean z4, boolean z5, long j3, int i, boolean z6) {
        if (StringUtils.isNull(str4)) {
            if (z) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, str12, str13, str, "userId 为空");
            }
        } else if (!z2 || !str4.equals(TbadkCoreApplication.getCurrentAccount())) {
            a(str, j, str4, str6, str5, j2, str14, z, z4);
            g gh = gh(str);
            if (gh == null) {
                String sharedPrefKeyWithAccount = d.getSharedPrefKeyWithAccount("last_send_get_gift_list_time_yuyin");
                if (System.currentTimeMillis() - d.xf().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                    d.xf().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                }
                gh = new g();
                gh.fW(str);
                gh.setGiftName(str2);
                gh.fX("" + j);
                gh.setThumbnailUrl(str3);
                BdResourceLoader.getInstance().loadResource(gh.getThumbnail_url(), 10, null, BdUniqueId.gen());
            }
            com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(str, j, gh, str4, str5, str6, str7, str8, z, str9, str10, j2, str14, j3);
            cVar.aS(System.currentTimeMillis());
            cVar.beo = false;
            cVar.bX(z3);
            cVar.chatMCastId = str12;
            cVar.ensureMCastId = str13;
            cVar.caD = z5;
            cVar.caE = i;
            cVar.caF = z6;
            if (com.baidu.live.ae.a.Qm().bwx.aMT && !TextUtils.isEmpty(str11)) {
                k kVar = new k();
                if (kVar.fY(str11)) {
                    cVar.bep.aXE = kVar;
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
        }
    }

    @Override // com.baidu.live.gift.aj
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
                    while (true) {
                        int i2 = i;
                        if (i2 >= jSONArray.length()) {
                            break;
                        }
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        String optString = jSONObject.optString(LogConfig.LOG_GIFT_ID);
                        String optString2 = jSONObject.optString("gift_name");
                        long optLong = jSONObject.optLong("gift_count");
                        String optString3 = jSONObject.optString("gift_url");
                        j3 += optLong;
                        j4 += jSONObject.optLong("charm_value");
                        g gh = gh(optString);
                        if (gh == null) {
                            String sharedPrefKeyWithAccount = d.getSharedPrefKeyWithAccount("last_send_get_gift_list_time_yuyin");
                            if (System.currentTimeMillis() - d.xf().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                                d.xf().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                            }
                            gh = new g();
                            gh.fW(optString);
                            gh.setGiftName(optString2);
                            gh.setThumbnailUrl(optString3);
                            BdResourceLoader.getInstance().loadResource(gh.getThumbnail_url(), 10, null, BdUniqueId.gen());
                        }
                        arrayList.add(gh);
                        i = i2 + 1;
                    }
                }
                j2 = j4;
            } catch (JSONException e) {
                e.printStackTrace();
                j2 = j4;
            }
            if (!ListUtils.isEmpty(arrayList)) {
                g gVar = (g) arrayList.get(0);
                com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(gVar.DU(), j3, gVar, str2, str3, str4, str5, str6, z, str7, str8, j, str12, 0L);
                cVar.aS(System.currentTimeMillis());
                cVar.beo = false;
                cVar.bX(true);
                cVar.chatMCastId = str10;
                cVar.ensureMCastId = str11;
                if (com.baidu.live.ae.a.Qm().bwx.aMT && !TextUtils.isEmpty(str9)) {
                    k kVar = new k();
                    if (kVar.fY(str9)) {
                        cVar.bep.aXE = kVar;
                    }
                }
                if (arrayList.size() >= 2) {
                    com.baidu.live.yuyingift.b.a(j, gVar.DU(), str2, str4, j3, j2, str12);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
            }
        }
    }

    @Override // com.baidu.live.gift.aj
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12) {
        g gVar = new g();
        gVar.fW(str);
        gVar.setGiftName(str2);
        gVar.fX("" + j);
        gVar.setThumbnailUrl(str3);
        com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2, str12, 0L);
        cVar.aS(System.currentTimeMillis());
        cVar.beo = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bX(z3);
        cVar.beB = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
    }

    @Override // com.baidu.live.gift.aj
    protected void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12) {
        g gVar = new g();
        gVar.fW(str);
        gVar.setGiftName(str2);
        gVar.fX("" + j);
        gVar.setThumbnailUrl(str3);
        a(str, j, str4, str6, str5, j2, str12, z, false);
        com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2, str12, 0L);
        cVar.aS(System.currentTimeMillis());
        cVar.beo = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bX(z3);
        cVar.beB = false;
        cVar.beC = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
    }

    @Override // com.baidu.live.gift.aj
    protected void gp(String str) {
        if (this.cbj == null) {
            this.cbj = new com.baidu.live.yuyingift.c.d();
        }
        this.cbj.gT(str);
    }

    @Override // com.baidu.live.gift.aj
    protected void a(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6, int i3, long j) {
        if (this.cbj == null) {
            this.cbj = new com.baidu.live.yuyingift.c.d();
        }
        this.cbj.a(str, str2, str3, str4, 1, 0, "", str6, System.currentTimeMillis(), i3, j);
    }

    private void a(String str, long j, String str2, String str3, String str4, long j2, String str5, boolean z, boolean z2) {
        if (gm(str)) {
            if (!gv(str)) {
                if (BdNetTypeUtil.isWifiNet() || !m.Vs()) {
                    if (this.bgA == null) {
                        this.bgA = new ArrayList<>();
                    }
                    this.bgA.add(new com.baidu.live.yuyingift.a.c(str, j, null, str2, str4, str3, "", "", false, "", "", j2, str5, 0L));
                    com.baidu.live.gift.c gS = Za().gS(str);
                    if (gS != null) {
                        am.FF().a(gS.aWS, false);
                    }
                }
            }
        } else if (z2) {
            k(z, str);
        }
    }

    @Override // com.baidu.live.gift.aj
    public void Ft() {
        if (ListUtils.isEmpty(this.bgp)) {
            this.bgK = true;
            return;
        }
        Iterator<com.baidu.live.gift.c> it = this.bgp.iterator();
        while (it.hasNext()) {
            com.baidu.live.gift.c next = it.next();
            if (next != null && next.aWS != null && !Za().gk(next.getDynamicGiftId())) {
                com.baidu.live.gift.b bVar = next.aWS;
                if (bVar.aWP != null) {
                    am.FF().a(bVar, false);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.aj
    public void onDestroy() {
        this.bgK = false;
        MessageManager.getInstance().unRegisterListener(this.bgQ);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.cbi != null) {
            this.cbi.onDestroy();
            this.cbi = null;
        }
        if (this.cbg != null) {
            this.cbg.onDestroy();
            this.cbg = null;
        }
        if (this.cbh != null) {
            this.cbh.onDestroy();
            this.cbh = null;
        }
        if (this.bgH != null) {
            this.bgH.onDestroy();
            this.bgH = null;
        }
        if (this.cbj != null) {
            this.cbj.release();
            this.cbj = null;
        }
        if (this.bgA != null) {
            this.bgA.clear();
        }
        am.FF().Fc();
        this.bcv.clear();
        this.bgp.clear();
        this.aLz = null;
        this.bgL = null;
    }
}
