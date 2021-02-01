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
/* loaded from: classes11.dex */
public class b extends ac {
    private static volatile b beW;
    private ab aJZ;
    private ArrayList<g> baV;
    private ArrayList<com.baidu.live.gift.a.c> beX;
    private List<com.baidu.live.gift.c> beY;
    private Map<String, com.baidu.live.gift.a.b> beZ;
    public Map<String, com.baidu.live.gift.a.d> bfa;
    private boolean bfc;
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
        public void i(ArrayList<com.baidu.live.gift.c> arrayList) {
            b.this.beY.clear();
            if (!ListUtils.isEmpty(arrayList)) {
                b.this.beY.addAll(arrayList);
                if (b.this.bfi) {
                    b.this.Fq();
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
                    Set entrySet = b.this.beZ.entrySet();
                    if (!entrySet.isEmpty()) {
                        if (b.this.bfg != null && !b.this.bfg.mIsSending && (entry = (Map.Entry) entrySet.iterator().next()) != null) {
                            b.this.bfg.a((com.baidu.live.gift.a.b) b.this.beZ.remove(entry.getKey()));
                        }
                        b.this.mHandler.sendEmptyMessage(100);
                        break;
                    } else {
                        return true;
                    }
                    break;
                case 200:
                    if (b.this.bfa != null && !b.this.bfa.isEmpty()) {
                        if (!b.this.bfc && (next = b.this.bfa.entrySet().iterator().next()) != null) {
                            b.this.a(b.this.bfa.remove(next.getKey()));
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
    private CustomMessageListener bfm = new CustomMessageListener(2913238) { // from class: com.baidu.live.gift.c.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null) {
                w.aXR = (String) customResponsedMessage.getData();
                w.aXQ = !w.aXR.equals("1");
            }
        }
    };
    private CustomMessageListener bfn = new CustomMessageListener(2913234) { // from class: com.baidu.live.gift.c.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long) && ((Long) customResponsedMessage.getData()).longValue() == -1) {
                w.aXQ = false;
            }
        }
    };
    private CustomMessageListener bfo = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.c.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.h.c cVar;
            g gm;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.h.c) && !ListUtils.isEmpty(b.this.beX) && (cVar = (com.baidu.live.h.c) customResponsedMessage.getData()) != null && cVar.aUc != null && cVar.aUb == 5) {
                String id = cVar.aUc.getId();
                ArrayList arrayList = new ArrayList();
                Iterator it = b.this.beX.iterator();
                while (it.hasNext()) {
                    com.baidu.live.gift.a.c cVar2 = (com.baidu.live.gift.a.c) it.next();
                    if (!TextUtils.isEmpty(cVar2.giftId) && cVar2.giftId.equals(id) && (gm = ac.gm(cVar2.giftId)) != null) {
                        arrayList.add(cVar2);
                        com.baidu.live.im.data.c cVar3 = new com.baidu.live.im.data.c();
                        cVar3.giftId = cVar2.giftId;
                        cVar3.aWN = cVar2.bcT;
                        cVar3.giftName = gm.DS();
                        cVar3.aWQ = gm.getThumbnail_url();
                        cVar3.bdh = "";
                        cVar3.isDynamic = false;
                        cVar3.bcR = cVar2.bcR;
                        cVar3.bcS = cVar2.bcS;
                        com.baidu.live.data.a aVar = new com.baidu.live.data.a();
                        aVar.userId = cVar2.userId;
                        aVar.portrait = cVar2.portrait;
                        aVar.userName = cVar2.userName;
                        ac.b(cVar3, aVar, "", "", false, "", "", false, true, "", "", -1L);
                    }
                }
                b.this.beX.removeAll(arrayList);
                com.baidu.live.gift.c gM = b.this.gM(id);
                if (gM != null && gM.aVs != null && gM.aVs.aVp != null) {
                    v.D(gM.aVs.aVp.zipName, gM.aVs.aVr);
                }
            }
        }
    };

    public static b Hr() {
        if (beW == null) {
            synchronized (b.class) {
                if (beW == null) {
                    beW = new b();
                }
            }
        }
        return beW;
    }

    private b() {
        a((ac) this);
        this.beY = Collections.synchronizedList(new ArrayList());
        this.baV = new ArrayList<>();
        this.beZ = new HashMap();
    }

    @Override // com.baidu.live.gift.ac
    protected ab Fm() {
        return this.aJZ;
    }

    @Override // com.baidu.live.gift.ac
    protected void setLiveShowData(ab abVar) {
        this.aJZ = abVar;
    }

    @Override // com.baidu.live.gift.ac
    protected String Fn() {
        return this.bfj;
    }

    @Override // com.baidu.live.gift.ac
    protected void gc(String str) {
        this.bfj = str;
    }

    @Override // com.baidu.live.gift.ac
    public void a(BdPageContext bdPageContext, boolean z, boolean z2) {
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
        this.bfd.bZ(z2);
        k(z, null);
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
    protected void Fo() {
        if (AlaLiveSwitchData.isHotLive == 0) {
            this.bfe.a(q.Vu(), true, "enter", "gift_init");
        }
    }

    private void k(boolean z, String str) {
        this.bfd.setHost(z);
        this.bfd.gL(str);
    }

    @Override // com.baidu.live.gift.ac
    public String Fp() {
        return q.Vu();
    }

    @Override // com.baidu.live.gift.ac
    protected void EZ() {
        a.Hq().EZ();
    }

    @Override // com.baidu.live.gift.ac
    protected void gh(String str) {
        if (!TextUtils.isEmpty(str) && this.beY != null && !this.beY.isEmpty()) {
            for (com.baidu.live.gift.c cVar : this.beY) {
                if (cVar != null && cVar.aVs != null && cVar.aVs.aVp != null && str.equals(cVar.aVs.aVp.zipName)) {
                    cVar.videoPath = null;
                    cVar.unZipFilesPathList = null;
                    return;
                }
            }
        }
    }

    @Override // com.baidu.live.gift.ac
    protected com.baidu.live.gift.b gi(String str) {
        if (TextUtils.isEmpty(str) || this.beY == null || this.beY.isEmpty()) {
            return null;
        }
        for (com.baidu.live.gift.c cVar : this.beY) {
            if (cVar != null && cVar.aVs != null && cVar.aVs.aVp != null && str.equals(cVar.aVs.aVp.zipName)) {
                return cVar.aVs;
            }
        }
        return null;
    }

    public void e(String str, ArrayList<h> arrayList) {
        if (!ListUtils.isEmpty(arrayList)) {
            if (this.baV == null) {
                this.baV = new ArrayList<>();
            }
            Iterator<h> it = arrayList.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (!ListUtils.isEmpty(next.Ew())) {
                    c(str, next.Ew());
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
                    if (next != null && !TextUtils.isEmpty(next.DR()) && next.DR().equals(gVar.DR())) {
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
    public boolean gg(String str) {
        if (StringUtils.isNull(str) || ListUtils.isEmpty(this.beY)) {
            return false;
        }
        for (int i = 0; i < this.beY.size(); i++) {
            if (str.equals(this.beY.get(i).getDynamicGiftId())) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.live.gift.c gM(String str) {
        if (!StringUtils.isNull(str) && !ListUtils.isEmpty(this.beY)) {
            boolean z = UtilHelper.getRealScreenOrientation(TbadkCoreApplication.getInst().getContext()) == 2;
            for (int i = 0; i < this.beY.size(); i++) {
                com.baidu.live.gift.c cVar = this.beY.get(i);
                if (str.equals(cVar.getDynamicGiftId()) && z == cVar.isLandScapeZip()) {
                    return cVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.live.gift.ac
    protected String gd(String str) {
        com.baidu.live.gift.c gM = Hr().gM(str);
        if (gM == null || gM.aVs == null || gM.aVs.aVp == null) {
            return null;
        }
        return (com.baidu.live.alphavideo.a.zo().zp() && gM.aVs.Dv()) ? gM.aVs.aVp.videoUrl : gM.aVs.aVp.zipDownloadUrl;
    }

    @Override // com.baidu.live.gift.ac
    public boolean ge(String str) {
        com.baidu.live.gift.c gM;
        if (StringUtils.isNull(str) || (gM = gM(str)) == null || gM.aVs == null) {
            return false;
        }
        if (com.baidu.live.alphavideo.a.zo().zp() && gM.aVs.Dv() && !TextUtils.isEmpty(gM.Dy())) {
            return true;
        }
        return ListUtils.isEmpty(gM.getDynamicGiftPicPathList()) ? false : true;
    }

    @Override // com.baidu.live.gift.ac
    protected boolean gf(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return a.Hq().at(str, gd(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, Object obj, long j) {
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            if (i >= 0) {
                if (this.beZ != null && this.beZ.size() == 0) {
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
            if (gVar.Ef()) {
                TiebaInitialize.log(new StatisticItem("c12792").param("obj_id", gVar.DR()).param("obj_param1", gVar.DW()).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, ge(gVar.DR()) ? 1 : 0));
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
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(gVar.DR(), j, gVar, currentAccountInfo.getID(), currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), str3, "", false, str, str4, j2);
        cVar.bcQ = currentAccountInfo.getLiveLevel();
        cVar.sex = currentAccountInfo.getSex();
        cVar.description = "";
        cVar.userStatus = -1;
        cVar.aWR = j3;
        cVar.aS(System.currentTimeMillis());
        cVar.bcN = true;
        cVar.bcR = gVar.En();
        a(gVar.DR(), j, currentAccountInfo.getID(), currentAccountInfo.getAccountNameShow(), currentAccountInfo.getPortrait(), j2, false, false, gVar.En(), new JSONObject(), "");
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
        if (this.bfg != null) {
            com.baidu.live.gift.a.b bVar = new com.baidu.live.gift.a.b(gVar, j, str, str2, str3, str4, str5, str6, gVar.getThumbnail_url(), j2);
            bVar.aWU = bdUniqueId;
            if (j == 1) {
                bVar.aXW = 0;
            } else {
                bVar.aXW = 1;
            }
            bVar.bcM.put(Long.valueOf(j2), Long.valueOf(j));
            if (this.bfg.mIsSending || !this.beZ.isEmpty()) {
                String l = l(str3, str, gVar.DR(), String.valueOf(j));
                com.baidu.live.gift.a.b bVar2 = this.beZ.get(l);
                if (bVar2 == null) {
                    this.beZ.put(l, bVar);
                } else {
                    bVar2.bcM.put(Long.valueOf(j2), Long.valueOf(j));
                    bVar2.bcK += j;
                }
                this.mHandler.sendEmptyMessage(100);
                return;
            }
            this.bfg.a(bVar);
        }
    }

    @Override // com.baidu.live.gift.ac
    public g gb(String str) {
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
            if (!str.equals(gVar.DR())) {
                i = i2 + 1;
            } else {
                return gVar;
            }
        }
    }

    @Override // com.baidu.live.gift.ac
    public void a(com.baidu.live.im.data.c cVar, com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3, String str4, boolean z2, boolean z3, String str5, String str6, long j) {
        String str7 = cVar.giftId;
        long j2 = cVar.aWN;
        String str8 = cVar.giftName;
        String str9 = cVar.aWQ;
        String str10 = cVar.bdh;
        if (!TextUtils.isEmpty(cVar.bpm) && !TextUtils.isEmpty(cVar.bpo)) {
            str10 = cVar.bpm;
        }
        boolean z4 = cVar.isDynamic;
        boolean z5 = cVar.bcR;
        String str11 = aVar.userId;
        String str12 = aVar.portrait;
        String nameShow = aVar.getNameShow();
        JSONObject jSONObject = cVar.bcS;
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
            a(str7, j2, str11, nameShow, str12, j, z, z4, z5, jSONObject, cVar.bde);
            g gb = gb(str7);
            if (gb == null) {
                String sharedPrefKeyWithAccount = com.baidu.live.d.getSharedPrefKeyWithAccount("last_send_get_gift_list_time");
                if (System.currentTimeMillis() - com.baidu.live.d.xc().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                    com.baidu.live.d.xc().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                }
                gb = new g();
                gb.fQ(str7);
                gb.setGiftName(str8);
                gb.fR("" + j2);
                gb.setThumbnailUrl(str9);
                BdResourceLoader.getInstance().loadResource(gb.getThumbnail_url(), 10, null, BdUniqueId.gen());
            }
            gb.aN(cVar.aVC);
            com.baidu.live.gift.a.c cVar2 = new com.baidu.live.gift.a.c(str7, j2, gb, str11, str12, nameShow, str, str2, z, str3, str4, j, z5, jSONObject);
            cVar2.aS(System.currentTimeMillis());
            cVar2.bcN = false;
            cVar2.bX(z3);
            cVar2.chatMCastId = str5;
            cVar2.ensureMCastId = str6;
            cVar2.bde = cVar.bde;
            if (com.baidu.live.ae.a.Qj().buX.aLt && !TextUtils.isEmpty(str10)) {
                k kVar = new k();
                if (kVar.fS(str10)) {
                    cVar2.bcO.aWe = kVar;
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
        String str7 = cVar.bpo;
        String str8 = (TextUtils.isEmpty(cVar.bpm) || TextUtils.isEmpty(cVar.bpo)) ? cVar.bdh : cVar.bpm;
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
                            g gb = gb(optString);
                            if (gb == null) {
                                String sharedPrefKeyWithAccount = com.baidu.live.d.getSharedPrefKeyWithAccount("last_send_get_gift_list_time");
                                if (System.currentTimeMillis() - com.baidu.live.d.xc().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                                    com.baidu.live.d.xc().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                                }
                                gb = new g();
                                gb.fQ(optString);
                                gb.setGiftName(optString2);
                                gb.setThumbnailUrl(optString3);
                                BdResourceLoader.getInstance().loadResource(gb.getThumbnail_url(), 10, null, BdUniqueId.gen());
                            }
                            arrayList.add(gb);
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
                com.baidu.live.gift.a.c cVar2 = new com.baidu.live.gift.a.c(gVar.DR(), j3, gVar, str9, str10, nameShow, str, str2, z, str3, str4, j);
                cVar2.aS(System.currentTimeMillis());
                cVar2.bcN = false;
                cVar2.bX(true);
                cVar2.chatMCastId = str5;
                cVar2.ensureMCastId = str6;
                cVar2.bde = cVar.bde;
                if (com.baidu.live.ae.a.Qj().buX.aLt && !TextUtils.isEmpty(str8)) {
                    k kVar = new k();
                    if (kVar.fS(str8)) {
                        cVar2.bcO.aWe = kVar;
                    }
                }
                if (arrayList.size() >= 2) {
                    w.a(j, gVar.DR(), str9, nameShow, j3, j2);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar2));
            }
        }
    }

    @Override // com.baidu.live.gift.ac
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        g gVar = new g();
        gVar.fQ(str);
        gVar.setGiftName(str2);
        gVar.fR("" + j);
        gVar.setThumbnailUrl(str3);
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2);
        cVar.aS(System.currentTimeMillis());
        cVar.bcN = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bX(z3);
        cVar.bcZ = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    @Override // com.baidu.live.gift.ac
    protected void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        g gVar = new g();
        gVar.fQ(str);
        gVar.setGiftName(str2);
        gVar.fR("" + j);
        gVar.setThumbnailUrl(str3);
        a(str, j, str4, str6, str5, j2, z, false, false, (JSONObject) null, "");
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2);
        cVar.aS(System.currentTimeMillis());
        cVar.bcN = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bX(z3);
        cVar.bcZ = false;
        cVar.bda = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    @Override // com.baidu.live.gift.ac
    protected void gj(String str) {
        if (this.bfh == null) {
            this.bfh = new com.baidu.live.gift.d.a();
        }
        this.bfh.gN(str);
    }

    @Override // com.baidu.live.gift.ac
    protected void a(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        com.baidu.live.gift.a.d dVar = new com.baidu.live.gift.a.d(str, str2, str3, str4, i, i2, str5, System.currentTimeMillis());
        if (this.bfc || (this.bfa != null && !this.bfa.isEmpty())) {
            if (this.bfa == null) {
                this.bfa = new HashMap();
            }
            String b2 = b(str4, str3, str, i);
            com.baidu.live.gift.a.d dVar2 = this.bfa.get(b2);
            if (dVar2 == null) {
                this.bfa.put(b2, dVar);
            } else {
                dVar2.bdg += i;
            }
            this.mHandler.sendEmptyMessage(200);
            return;
        }
        a(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.gift.a.d dVar) {
        if (dVar != null) {
            this.bfc = true;
            if (this.bfh == null) {
                this.bfh = new com.baidu.live.gift.d.a();
                this.bfh.a(new com.baidu.live.gift.d.b() { // from class: com.baidu.live.gift.c.b.4
                    @Override // com.baidu.live.gift.d.b, com.baidu.live.gift.d.c.a
                    public void a(boolean z, int i, String str, String str2, int i2) {
                        super.a(z, i, str, str2, i2);
                        b.this.bfc = false;
                    }
                });
            }
            this.bfh.b(dVar);
        }
    }

    private void a(String str, long j, String str2, String str3, String str4, long j2, boolean z, boolean z2, boolean z3, JSONObject jSONObject, String str5) {
        if (gg(str)) {
            if (!go(str)) {
                if (this.beX == null) {
                    this.beX = new ArrayList<>();
                }
                com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, null, str2, str4, str3, "", "", false, "", "", j2, z3, jSONObject);
                cVar.bde = str5;
                this.beX.add(cVar);
                com.baidu.live.gift.c gM = Hr().gM(str);
                if (gM != null) {
                    a.Hq().a(gM.aVs, true);
                }
            }
        } else if (z2) {
            k(z, str);
        }
    }

    @Override // com.baidu.live.gift.ac
    public void Fq() {
        if (ListUtils.isEmpty(this.beY)) {
            this.bfi = true;
            return;
        }
        for (com.baidu.live.gift.c cVar : this.beY) {
            if (cVar != null && cVar.aVs != null && !Hr().ge(cVar.getDynamicGiftId())) {
                com.baidu.live.gift.b bVar = cVar.aVs;
                if (bVar.aVp != null) {
                    a.Hq().a(bVar, false);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.ac
    protected com.baidu.live.gift.c gk(String str) {
        if (!TextUtils.isEmpty(str) && !ListUtils.isEmpty(this.beY)) {
            for (com.baidu.live.gift.c cVar : this.beY) {
                if (cVar.aVs != null && cVar.aVs.aVp != null && str.equals(cVar.aVs.aVp.zipName)) {
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
        if (this.beX != null) {
            this.beX.clear();
        }
        EZ();
        this.baV.clear();
        this.beY.clear();
        this.aJZ = null;
        this.bfj = null;
        this.bfc = false;
        if (this.bfa != null) {
            this.bfa.clear();
        }
    }
}
