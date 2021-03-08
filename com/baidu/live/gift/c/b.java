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
import com.baidu.live.data.ab;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.c.c;
import com.baidu.live.gift.g;
import com.baidu.live.gift.giftList.b;
import com.baidu.live.gift.h;
import com.baidu.live.gift.k;
import com.baidu.live.gift.v;
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
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.utils.q;
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
/* loaded from: classes10.dex */
public class b extends ac {
    private static volatile b bgz;
    private ab aLz;
    private ArrayList<g> bcv;
    private ArrayList<com.baidu.live.gift.a.c> bgA;
    private List<com.baidu.live.gift.c> bgB;
    private Map<String, com.baidu.live.gift.a.b> bgC;
    public Map<String, com.baidu.live.gift.a.d> bgD;
    private boolean bgE;
    private com.baidu.live.gift.giftList.b bgF;
    private com.baidu.live.gift.giftList.c bgG;
    private com.baidu.live.o.c bgH;
    private c bgI;
    private com.baidu.live.gift.d.c bgJ;
    private String bgL;
    private boolean bgK = false;
    private c.a bgM = new c.a() { // from class: com.baidu.live.gift.c.b.1
        @Override // com.baidu.live.gift.c.c.a
        public void b(int i, String str, int i2, Object obj, long j) {
            b.this.a(i, str, i2, obj, j);
        }
    };
    private b.a bgN = new b.a() { // from class: com.baidu.live.gift.c.b.2
        @Override // com.baidu.live.gift.giftList.b.a
        public void i(ArrayList<com.baidu.live.gift.c> arrayList) {
            b.this.bgB.clear();
            if (!ListUtils.isEmpty(arrayList)) {
                b.this.bgB.addAll(arrayList);
                if (b.this.bgK) {
                    b.this.Ft();
                }
            }
        }
    };
    private final Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.c.b.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Map.Entry<String, com.baidu.live.gift.a.d> next;
            Map.Entry entry;
            switch (message.what) {
                case 100:
                    Set entrySet = b.this.bgC.entrySet();
                    if (!entrySet.isEmpty()) {
                        if (b.this.bgI != null && !b.this.bgI.mIsSending && (entry = (Map.Entry) entrySet.iterator().next()) != null) {
                            b.this.bgI.a((com.baidu.live.gift.a.b) b.this.bgC.remove(entry.getKey()));
                        }
                        b.this.mHandler.sendEmptyMessage(100);
                        break;
                    } else {
                        return true;
                    }
                    break;
                case 200:
                    if (b.this.bgD != null && !b.this.bgD.isEmpty()) {
                        if (!b.this.bgE && (next = b.this.bgD.entrySet().iterator().next()) != null) {
                            b.this.a(b.this.bgD.remove(next.getKey()));
                        }
                        b.this.mHandler.sendEmptyMessage(200);
                        break;
                    } else {
                        return true;
                    }
                    break;
            }
            return false;
        }
    });
    private CustomMessageListener bgO = new CustomMessageListener(2913238) { // from class: com.baidu.live.gift.c.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null) {
                w.aZr = (String) customResponsedMessage.getData();
                w.aZq = !w.aZr.equals("1");
            }
        }
    };
    private CustomMessageListener bgP = new CustomMessageListener(2913234) { // from class: com.baidu.live.gift.c.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long) && ((Long) customResponsedMessage.getData()).longValue() == -1) {
                w.aZq = false;
            }
        }
    };
    private CustomMessageListener bgQ = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.c.b.7
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
                    com.baidu.live.gift.a.c cVar2 = (com.baidu.live.gift.a.c) it.next();
                    if (!TextUtils.isEmpty(cVar2.giftId) && cVar2.giftId.equals(id) && (gt = ac.gt(cVar2.giftId)) != null) {
                        arrayList.add(cVar2);
                        com.baidu.live.im.data.c cVar3 = new com.baidu.live.im.data.c();
                        cVar3.giftId = cVar2.giftId;
                        cVar3.aYn = cVar2.bev;
                        cVar3.giftName = gt.DV();
                        cVar3.aYq = gt.getThumbnail_url();
                        cVar3.beJ = "";
                        cVar3.isDynamic = false;
                        cVar3.bes = cVar2.bes;
                        cVar3.beu = cVar2.beu;
                        com.baidu.live.data.a aVar = new com.baidu.live.data.a();
                        aVar.userId = cVar2.userId;
                        aVar.portrait = cVar2.portrait;
                        aVar.userName = cVar2.userName;
                        ac.b(cVar3, aVar, "", "", false, "", "", false, true, "", "", -1L);
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

    public static b Hu() {
        if (bgz == null) {
            synchronized (b.class) {
                if (bgz == null) {
                    bgz = new b();
                }
            }
        }
        return bgz;
    }

    private b() {
        a((ac) this);
        this.bgB = Collections.synchronizedList(new ArrayList());
        this.bcv = new ArrayList<>();
        this.bgC = new HashMap();
    }

    @Override // com.baidu.live.gift.ac
    protected ab Fp() {
        return this.aLz;
    }

    @Override // com.baidu.live.gift.ac
    protected void setLiveShowData(ab abVar) {
        this.aLz = abVar;
    }

    @Override // com.baidu.live.gift.ac
    protected String Fq() {
        return this.bgL;
    }

    @Override // com.baidu.live.gift.ac
    protected void gi(String str) {
        this.bgL = str;
    }

    @Override // com.baidu.live.gift.ac
    public void a(BdPageContext bdPageContext, boolean z, boolean z2) {
        MessageManager.getInstance().registerListener(this.bgQ);
        MessageManager.getInstance().registerListener(this.bgO);
        MessageManager.getInstance().registerListener(this.bgP);
        if (this.bgG == null) {
            this.bgG = new com.baidu.live.gift.giftList.c(bdPageContext);
        }
        if (this.bgF == null) {
            this.bgF = new com.baidu.live.gift.giftList.b(bdPageContext);
            this.bgF.a(this.bgN);
        }
        this.bgF.bZ(z2);
        k(z, null);
        if (this.bgI == null) {
            this.bgI = new c(bdPageContext);
            this.bgI.setUniqueId(BdUniqueId.gen());
        }
        this.bgI.initListener();
        this.bgI.a(this.bgM);
        if (this.bgH == null) {
            this.bgH = new com.baidu.live.o.c();
        }
        this.bgH.initListener();
        this.bgH.refreshCurUserScores();
    }

    @Override // com.baidu.live.gift.ac
    protected void Fr() {
        if (AlaLiveSwitchData.isHotLive == 0) {
            this.bgG.a(q.Vx(), true, "enter", "gift_init");
        }
    }

    private void k(boolean z, String str) {
        this.bgF.setHost(z);
        this.bgF.gR(str);
    }

    @Override // com.baidu.live.gift.ac
    public String Fs() {
        return q.Vx();
    }

    @Override // com.baidu.live.gift.ac
    protected void Fc() {
        a.Ht().Fc();
    }

    @Override // com.baidu.live.gift.ac
    protected void gn(String str) {
        if (!TextUtils.isEmpty(str) && this.bgB != null && !this.bgB.isEmpty()) {
            for (com.baidu.live.gift.c cVar : this.bgB) {
                if (cVar != null && cVar.aWS != null && cVar.aWS.aWP != null && str.equals(cVar.aWS.aWP.zipName)) {
                    cVar.videoPath = null;
                    cVar.unZipFilesPathList = null;
                    return;
                }
            }
        }
    }

    @Override // com.baidu.live.gift.ac
    protected com.baidu.live.gift.b go(String str) {
        if (TextUtils.isEmpty(str) || this.bgB == null || this.bgB.isEmpty()) {
            return null;
        }
        for (com.baidu.live.gift.c cVar : this.bgB) {
            if (cVar != null && cVar.aWS != null && cVar.aWS.aWP != null && str.equals(cVar.aWS.aWP.zipName)) {
                return cVar.aWS;
            }
        }
        return null;
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

    @Override // com.baidu.live.gift.ac
    public boolean gm(String str) {
        if (StringUtils.isNull(str) || ListUtils.isEmpty(this.bgB)) {
            return false;
        }
        for (int i = 0; i < this.bgB.size(); i++) {
            if (str.equals(this.bgB.get(i).getDynamicGiftId())) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.live.gift.c gS(String str) {
        if (!StringUtils.isNull(str) && !ListUtils.isEmpty(this.bgB)) {
            boolean z = UtilHelper.getRealScreenOrientation(TbadkCoreApplication.getInst().getContext()) == 2;
            for (int i = 0; i < this.bgB.size(); i++) {
                com.baidu.live.gift.c cVar = this.bgB.get(i);
                if (str.equals(cVar.getDynamicGiftId()) && z == cVar.isLandScapeZip()) {
                    return cVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.live.gift.ac
    protected String gj(String str) {
        com.baidu.live.gift.c gS = Hu().gS(str);
        if (gS == null || gS.aWS == null || gS.aWS.aWP == null) {
            return null;
        }
        return (com.baidu.live.alphavideo.a.zr().zs() && gS.aWS.Dy()) ? gS.aWS.aWP.videoUrl : gS.aWS.aWP.zipDownloadUrl;
    }

    @Override // com.baidu.live.gift.ac
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

    @Override // com.baidu.live.gift.ac
    protected boolean gl(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return a.Ht().at(str, gj(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, Object obj, long j) {
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            if (i >= 0) {
                if (this.bgC != null && this.bgC.size() == 0) {
                    if (i == 0) {
                        if (i2 == 1 || i2 == 3) {
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

    public void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, long j3) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), TbadkCoreApplication.getInst().getContext().getResources().getString(a.h.sdk_no_network_guide));
        } else if (gVar != null) {
            if (gVar.Ei()) {
                TiebaInitialize.log(new StatisticItem("c12792").param("obj_id", gVar.DU()).param("obj_param1", gVar.DZ()).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, gk(gVar.DU()) ? 1 : 0));
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
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(gVar.DU(), j, gVar, currentAccountInfo.getID(), currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), str3, "", false, str, str4, j2);
        cVar.ber = currentAccountInfo.getLiveLevel();
        cVar.sex = currentAccountInfo.getSex();
        cVar.description = "";
        cVar.userStatus = -1;
        cVar.aYr = j3;
        cVar.aS(System.currentTimeMillis());
        cVar.beo = true;
        cVar.bes = gVar.Eq();
        a(gVar.DU(), j, currentAccountInfo.getID(), currentAccountInfo.getAccountNameShow(), currentAccountInfo.getPortrait(), j2, false, false, gVar.Eq(), new JSONObject(), "");
        w.f(cVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    private String l(String str, String str2, String str3, String str4) {
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str4;
    }

    private String b(String str, String str2, String str3, int i) {
        return str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str3 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i;
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, long j2, BdUniqueId bdUniqueId) {
        if (this.bgI != null) {
            com.baidu.live.gift.a.b bVar = new com.baidu.live.gift.a.b(gVar, j, str, str2, str3, str4, str5, str6, gVar.getThumbnail_url(), j2);
            bVar.aYu = bdUniqueId;
            if (j == 1) {
                bVar.aZw = 0;
            } else {
                bVar.aZw = 1;
            }
            bVar.ben.put(Long.valueOf(j2), Long.valueOf(j));
            if (this.bgI.mIsSending || !this.bgC.isEmpty()) {
                String l = l(str3, str, gVar.DU(), String.valueOf(j));
                com.baidu.live.gift.a.b bVar2 = this.bgC.get(l);
                if (bVar2 == null) {
                    this.bgC.put(l, bVar);
                } else {
                    bVar2.ben.put(Long.valueOf(j2), Long.valueOf(j));
                    bVar2.bel += j;
                }
                this.mHandler.sendEmptyMessage(100);
                return;
            }
            this.bgI.a(bVar);
        }
    }

    @Override // com.baidu.live.gift.ac
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

    @Override // com.baidu.live.gift.ac
    public void a(com.baidu.live.im.data.c cVar, com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3, String str4, boolean z2, boolean z3, String str5, String str6, long j) {
        String str7 = cVar.giftId;
        long j2 = cVar.aYn;
        String str8 = cVar.giftName;
        String str9 = cVar.aYq;
        String str10 = cVar.beJ;
        if (!TextUtils.isEmpty(cVar.bqM) && !TextUtils.isEmpty(cVar.bqO)) {
            str10 = cVar.bqM;
        }
        boolean z4 = cVar.isDynamic;
        boolean z5 = cVar.bes;
        String str11 = aVar.userId;
        String str12 = aVar.portrait;
        String nameShow = aVar.getNameShow();
        JSONObject jSONObject = cVar.beu;
        if (StringUtils.isNull(str11)) {
            if (z) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, str5, str6, str7, "userId 为空");
                return;
            }
            return;
        }
        boolean z6 = false;
        if (UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT.equals(jSONObject.optString("content_type")) && jSONObject != null && jSONObject.optInt("tying_status") == 1) {
            z6 = true;
        }
        if (!z2 || !str11.equals(TbadkCoreApplication.getCurrentAccount()) || z6) {
            a(str7, j2, str11, nameShow, str12, j, z, z4, z5, jSONObject, cVar.beG);
            g gh = gh(str7);
            if (gh == null) {
                String sharedPrefKeyWithAccount = com.baidu.live.d.getSharedPrefKeyWithAccount("last_send_get_gift_list_time");
                if (System.currentTimeMillis() - com.baidu.live.d.xf().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                    com.baidu.live.d.xf().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                }
                gh = new g();
                gh.fW(str7);
                gh.setGiftName(str8);
                gh.fX("" + j2);
                gh.setThumbnailUrl(str9);
                BdResourceLoader.getInstance().loadResource(gh.getThumbnail_url(), 10, null, BdUniqueId.gen());
            }
            gh.aN(cVar.aXc);
            com.baidu.live.gift.a.c cVar2 = new com.baidu.live.gift.a.c(str7, j2, gh, str11, str12, nameShow, str, str2, z, str3, str4, j, z5, jSONObject);
            cVar2.aS(System.currentTimeMillis());
            cVar2.beo = false;
            cVar2.bX(z3);
            cVar2.chatMCastId = str5;
            cVar2.ensureMCastId = str6;
            cVar2.beG = cVar.beG;
            if (com.baidu.live.ae.a.Qm().bwx.aMT && !TextUtils.isEmpty(str10)) {
                k kVar = new k();
                if (kVar.fY(str10)) {
                    cVar2.bep.aXE = kVar;
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.live.gift.ac
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void a(com.baidu.live.im.data.c cVar, com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3, String str4, String str5, String str6, long j) {
        long j2;
        String str7 = cVar.bqO;
        String str8 = (TextUtils.isEmpty(cVar.bqM) || TextUtils.isEmpty(cVar.bqO)) ? cVar.beJ : cVar.bqM;
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
                            g gh = gh(optString);
                            if (gh == null) {
                                String sharedPrefKeyWithAccount = com.baidu.live.d.getSharedPrefKeyWithAccount("last_send_get_gift_list_time");
                                if (System.currentTimeMillis() - com.baidu.live.d.xf().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                                    com.baidu.live.d.xf().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                                }
                                gh = new g();
                                gh.fW(optString);
                                gh.setGiftName(optString2);
                                gh.setThumbnailUrl(optString3);
                                BdResourceLoader.getInstance().loadResource(gh.getThumbnail_url(), 10, null, BdUniqueId.gen());
                            }
                            arrayList.add(gh);
                            i++;
                            j4 = j2;
                        } catch (JSONException e) {
                            e = e;
                            e.printStackTrace();
                            if (ListUtils.isEmpty(arrayList)) {
                            }
                        }
                    }
                }
                j2 = j4;
            } catch (JSONException e2) {
                e = e2;
                j2 = j4;
            }
            if (ListUtils.isEmpty(arrayList)) {
                g gVar = (g) arrayList.get(0);
                com.baidu.live.gift.a.c cVar2 = new com.baidu.live.gift.a.c(gVar.DU(), j3, gVar, str9, str10, nameShow, str, str2, z, str3, str4, j);
                cVar2.aS(System.currentTimeMillis());
                cVar2.beo = false;
                cVar2.bX(true);
                cVar2.chatMCastId = str5;
                cVar2.ensureMCastId = str6;
                cVar2.beG = cVar.beG;
                if (com.baidu.live.ae.a.Qm().bwx.aMT && !TextUtils.isEmpty(str8)) {
                    k kVar = new k();
                    if (kVar.fY(str8)) {
                        cVar2.bep.aXE = kVar;
                    }
                }
                if (arrayList.size() >= 2) {
                    w.a(j, gVar.DU(), str9, nameShow, j3, j2);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar2));
            }
        }
    }

    @Override // com.baidu.live.gift.ac
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        g gVar = new g();
        gVar.fW(str);
        gVar.setGiftName(str2);
        gVar.fX("" + j);
        gVar.setThumbnailUrl(str3);
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2);
        cVar.aS(System.currentTimeMillis());
        cVar.beo = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bX(z3);
        cVar.beB = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    @Override // com.baidu.live.gift.ac
    protected void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        g gVar = new g();
        gVar.fW(str);
        gVar.setGiftName(str2);
        gVar.fX("" + j);
        gVar.setThumbnailUrl(str3);
        a(str, j, str4, str6, str5, j2, z, false, false, (JSONObject) null, "");
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2);
        cVar.aS(System.currentTimeMillis());
        cVar.beo = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bX(z3);
        cVar.beB = false;
        cVar.beC = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    @Override // com.baidu.live.gift.ac
    protected void gp(String str) {
        if (this.bgJ == null) {
            this.bgJ = new com.baidu.live.gift.d.a();
        }
        this.bgJ.gT(str);
    }

    @Override // com.baidu.live.gift.ac
    protected void a(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        com.baidu.live.gift.a.d dVar = new com.baidu.live.gift.a.d(str, str2, str3, str4, i, i2, str5, System.currentTimeMillis());
        if (this.bgE || (this.bgD != null && !this.bgD.isEmpty())) {
            if (this.bgD == null) {
                this.bgD = new HashMap();
            }
            String b = b(str4, str3, str, i);
            com.baidu.live.gift.a.d dVar2 = this.bgD.get(b);
            if (dVar2 == null) {
                this.bgD.put(b, dVar);
            } else {
                dVar2.beI += i;
            }
            this.mHandler.sendEmptyMessage(200);
            return;
        }
        a(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.gift.a.d dVar) {
        if (dVar != null) {
            this.bgE = true;
            if (this.bgJ == null) {
                this.bgJ = new com.baidu.live.gift.d.a();
                this.bgJ.a(new com.baidu.live.gift.d.b() { // from class: com.baidu.live.gift.c.b.4
                    @Override // com.baidu.live.gift.d.b, com.baidu.live.gift.d.c.a
                    public void a(boolean z, int i, String str, String str2, int i2) {
                        super.a(z, i, str, str2, i2);
                        b.this.bgE = false;
                    }
                });
            }
            this.bgJ.b(dVar);
        }
    }

    private void a(String str, long j, String str2, String str3, String str4, long j2, boolean z, boolean z2, boolean z3, JSONObject jSONObject, String str5) {
        if (gm(str)) {
            if (!gv(str)) {
                if (this.bgA == null) {
                    this.bgA = new ArrayList<>();
                }
                com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, null, str2, str4, str3, "", "", false, "", "", j2, z3, jSONObject);
                cVar.beG = str5;
                this.bgA.add(cVar);
                com.baidu.live.gift.c gS = Hu().gS(str);
                if (gS != null) {
                    a.Ht().a(gS.aWS, true);
                }
            }
        } else if (z2) {
            k(z, str);
        }
    }

    @Override // com.baidu.live.gift.ac
    public void Ft() {
        if (ListUtils.isEmpty(this.bgB)) {
            this.bgK = true;
            return;
        }
        for (com.baidu.live.gift.c cVar : this.bgB) {
            if (cVar != null && cVar.aWS != null && !Hu().gk(cVar.getDynamicGiftId())) {
                com.baidu.live.gift.b bVar = cVar.aWS;
                if (bVar.aWP != null) {
                    a.Ht().a(bVar, false);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.ac
    protected com.baidu.live.gift.c gq(String str) {
        if (!TextUtils.isEmpty(str) && !ListUtils.isEmpty(this.bgB)) {
            for (com.baidu.live.gift.c cVar : this.bgB) {
                if (cVar.aWS != null && cVar.aWS.aWP != null && str.equals(cVar.aWS.aWP.zipName)) {
                    return cVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.live.gift.ac
    public void onDestroy() {
        this.bgK = false;
        MessageManager.getInstance().unRegisterListener(this.bgQ);
        MessageManager.getInstance().unRegisterListener(this.bgO);
        MessageManager.getInstance().unRegisterListener(this.bgP);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.bgI != null) {
            this.bgI.onDestroy();
            this.bgI = null;
        }
        if (this.bgF != null) {
            this.bgF.onDestroy();
            this.bgF = null;
        }
        if (this.bgG != null) {
            this.bgG.onDestroy();
            this.bgG = null;
        }
        if (this.bgH != null) {
            this.bgH.onDestroy();
            this.bgH = null;
        }
        if (this.bgJ != null) {
            this.bgJ.release();
            this.bgJ = null;
        }
        if (this.bgA != null) {
            this.bgA.clear();
        }
        Fc();
        this.bcv.clear();
        this.bgB.clear();
        this.aLz = null;
        this.bgL = null;
        this.bgE = false;
        if (this.bgD != null) {
            this.bgD.clear();
        }
    }
}
