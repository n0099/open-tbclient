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
/* loaded from: classes11.dex */
public class b extends aj {
    private static volatile b bZE;
    private ab aJZ;
    private LinkedHashMap<String, com.baidu.live.yuyingift.a.b> bZF;
    private com.baidu.live.yuyingift.giftlist.a bZG;
    private com.baidu.live.yuyingift.giftlist.b bZH;
    private c bZI;
    private com.baidu.live.yuyingift.c.b bZJ;
    private ArrayList<g> baV;
    private ArrayList<com.baidu.live.gift.c> beN;
    private ArrayList<com.baidu.live.yuyingift.a.c> beX;
    private com.baidu.live.o.c bff;
    private String bfj;
    private boolean bfi = false;
    private c.a bZK = new c.a() { // from class: com.baidu.live.yuyingift.b.b.1
        @Override // com.baidu.live.yuyingift.c.c.a
        public void b(int i, String str, int i2, Object obj, long j) {
            b.this.a(i, str, i2, obj, j);
        }
    };
    private a.InterfaceC0237a bZL = new a.InterfaceC0237a() { // from class: com.baidu.live.yuyingift.b.b.2
        @Override // com.baidu.live.yuyingift.giftlist.a.InterfaceC0237a
        public void i(ArrayList<com.baidu.live.gift.c> arrayList) {
            b.this.beN.clear();
            if (!ListUtils.isEmpty(arrayList)) {
                b.this.beN.addAll(arrayList);
                if (b.this.bfi) {
                    b.this.Fq();
                }
            }
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.yuyingift.b.b.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Map.Entry entry;
            if (message.what == 100) {
                Set entrySet = b.this.bZF.entrySet();
                if (entrySet.isEmpty()) {
                    return true;
                }
                if (b.this.bZI != null && !b.this.bZI.mIsSending && (entry = (Map.Entry) entrySet.iterator().next()) != null) {
                    com.baidu.live.yuyingift.a.b bVar = (com.baidu.live.yuyingift.a.b) entry.getValue();
                    if (bVar == null) {
                        return true;
                    }
                    if (((com.baidu.live.yuyingift.a.b) entry.getValue()).bcK > 0) {
                        b.this.bZI.a(bVar);
                    } else {
                        b.this.bZI.a(bVar.aNa, bVar.bZb, bVar.bZc, bVar.liveId, bVar.bno);
                    }
                    b.this.bZF.remove(entry.getKey());
                }
                b.this.mHandler.sendEmptyMessage(100);
            }
            return false;
        }
    });
    private CustomMessageListener bfo = new CustomMessageListener(2913078) { // from class: com.baidu.live.yuyingift.b.b.4
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
                    com.baidu.live.yuyingift.a.c cVar2 = (com.baidu.live.yuyingift.a.c) it.next();
                    if (!TextUtils.isEmpty(cVar2.giftId) && cVar2.giftId.equals(id) && (gm = aj.gm(cVar2.giftId)) != null) {
                        arrayList.add(cVar2);
                        b.this.a(cVar2.giftId, cVar2.bcT, gm.DS(), gm.getThumbnail_url(), cVar2.userId, cVar2.portrait, cVar2.userName, "", "", false, "", "", "", cVar2.chatMCastId, cVar2.ensureMCastId, cVar2.msgId, cVar2.bno, false, cVar2.bZd, cVar2.aYl, cVar2.bZe, cVar2.bZf);
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

    public static b YX() {
        if (bZE == null) {
            synchronized (b.class) {
                if (bZE == null) {
                    bZE = new b();
                }
            }
        }
        return bZE;
    }

    private b() {
        a((aj) this);
        this.beN = new ArrayList<>();
        this.baV = new ArrayList<>();
        this.bZF = new LinkedHashMap<>();
    }

    @Override // com.baidu.live.gift.aj
    protected ab Fm() {
        return this.aJZ;
    }

    @Override // com.baidu.live.gift.aj
    protected void setLiveShowData(ab abVar) {
        this.aJZ = abVar;
    }

    @Override // com.baidu.live.gift.aj
    protected String Fn() {
        return this.bfj;
    }

    @Override // com.baidu.live.gift.aj
    protected void gc(String str) {
        this.bfj = str;
    }

    @Override // com.baidu.live.gift.aj
    public void a(BdPageContext bdPageContext, boolean z, boolean z2) {
        MessageManager.getInstance().registerListener(this.bfo);
        if (this.bZH == null) {
            this.bZH = new com.baidu.live.yuyingift.giftlist.b(bdPageContext);
        }
        if (this.bZG == null) {
            this.bZG = new com.baidu.live.yuyingift.giftlist.a(bdPageContext);
            this.bZG.a(this.bZL);
        }
        this.bZG.bZ(z2);
        k(z, null);
        if (this.bZI == null) {
            this.bZI = new c(bdPageContext);
            this.bZI.setUniqueId(BdUniqueId.gen());
        }
        this.bZI.initListener();
        this.bZI.a(this.bZK);
        if (this.bff == null) {
            this.bff = new com.baidu.live.o.c();
        }
        this.bff.initListener();
        this.bff.refreshCurUserScores();
    }

    @Override // com.baidu.live.gift.aj
    public void Fo() {
        if (AlaLiveSwitchData.isHotLive == 0) {
            this.bZH.a(t.Vu(), true, "enter", "gift_init");
        }
    }

    private void k(boolean z, String str) {
        this.bZG.setHost(z);
        this.bZG.gL(str);
    }

    @Override // com.baidu.live.gift.aj
    public String Fp() {
        return t.Vu();
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

    @Override // com.baidu.live.gift.aj
    public boolean gg(String str) {
        if (StringUtils.isNull(str) || ListUtils.isEmpty(this.beN)) {
            return false;
        }
        for (int i = 0; i < this.beN.size(); i++) {
            if (str.equals(this.beN.get(i).getDynamicGiftId())) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.live.gift.c gM(String str) {
        if (!StringUtils.isNull(str) && !ListUtils.isEmpty(this.beN)) {
            boolean z = UtilHelper.getRealScreenOrientation(TbadkCoreApplication.getInst().getContext()) == 2;
            for (int i = 0; i < this.beN.size(); i++) {
                com.baidu.live.gift.c cVar = this.beN.get(i);
                if (str.equals(cVar.getDynamicGiftId()) && z == cVar.isLandScapeZip()) {
                    return cVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.live.gift.aj
    protected String gd(String str) {
        com.baidu.live.gift.c gM = YX().gM(str);
        if (gM == null || gM.aVs == null || gM.aVs.aVp == null) {
            return null;
        }
        return (com.baidu.live.alphavideo.a.zo().zp() && gM.aVs.Dv()) ? gM.aVs.aVp.videoUrl : gM.aVs.aVp.zipDownloadUrl;
    }

    @Override // com.baidu.live.gift.aj
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

    @Override // com.baidu.live.gift.aj
    protected boolean gf(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return am.FC().at(str, gd(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, Object obj, long j) {
        if (i2 == 1 || i2 == 2) {
            if (i >= 0) {
                if (this.bZF != null && this.bZF.size() == 0) {
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

    public void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, long j3, String str8, long j4, int i) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), TbadkCoreApplication.getInst().getContext().getResources().getString(a.h.sdk_no_network_guide));
        } else if (gVar != null) {
            if (gVar.Ef()) {
                TiebaInitialize.log(new StatisticItem("c12792").param("obj_id", gVar.DR()).param("obj_param1", gVar.DW()).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, ge(gVar.DR()) ? 1 : 0));
            }
            a(gVar, j, str, str2, str3, str5, j2, j3, str8, j4, i);
        }
    }

    public void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, String str8, long j3, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        a(gVar, j, str, str2, str3, str4, str5, str6, str7, j2, currentTimeMillis, str8, j3, i);
        a(gVar, j, str, str2, str3, str4, str6, str7, currentTimeMillis, str8, gVar.DV() ? 1 : 0, j3, i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4, long j2, long j3, String str5, long j4, int i) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(gVar.DR(), j, gVar, currentAccountInfo.getID(), currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), currentAccountInfo.getLiveLevel(), currentAccountInfo.getSex(), "", -1, str3, "", false, str, str4, j2, str5, j4);
        cVar.bZd = gVar.DV();
        cVar.bZe = i;
        cVar.aWR = j3;
        cVar.aS(System.currentTimeMillis());
        cVar.bcN = true;
        com.baidu.live.yuyingift.b.f(cVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, long j2, String str7, int i, long j3, int i2) {
        if (this.bZI != null) {
            com.baidu.live.yuyingift.a.b bVar = new com.baidu.live.yuyingift.a.b(gVar, j, str, str2, str3, str4, str5, str6, gVar.getThumbnail_url(), j2, str7, i, j3, i2);
            if (j == 1) {
                bVar.aXW = 0;
            } else {
                bVar.aXW = 1;
            }
            bVar.bcM.put(Long.valueOf(j2), Long.valueOf(j));
            if (this.bZI.mIsSending || !this.bZF.isEmpty()) {
                String a2 = s.a(j3, gVar.DR(), str, str7);
                com.baidu.live.yuyingift.a.b bVar2 = this.bZF.get(a2);
                if (bVar2 == null) {
                    this.bZF.put(a2, bVar);
                } else {
                    bVar2.bcM.put(Long.valueOf(j2), Long.valueOf(j));
                    bVar2.bcK += j;
                }
                this.mHandler.sendEmptyMessage(100);
                return;
            }
            this.bZI.a(bVar);
        }
    }

    public void a(long j, int i, String str, String str2, String str3) {
        if (this.bZI.mIsSending) {
            if (j > 0) {
                String valueOf = String.valueOf(j);
                com.baidu.live.yuyingift.a.b bVar = new com.baidu.live.yuyingift.a.b();
                bVar.bcK = -1L;
                bVar.aNa = str;
                bVar.liveId = str2;
                bVar.bZb = j;
                bVar.bno = str3;
                this.bZF.put(valueOf, bVar);
                this.mHandler.sendEmptyMessage(100);
            }
        } else if (this.bZI != null) {
            this.bZI.a(str, j, i, str2, str3);
        }
    }

    @Override // com.baidu.live.gift.aj
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
            g gb = gb(str);
            if (gb == null) {
                String sharedPrefKeyWithAccount = d.getSharedPrefKeyWithAccount("last_send_get_gift_list_time_yuyin");
                if (System.currentTimeMillis() - d.xc().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                    d.xc().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                }
                gb = new g();
                gb.fQ(str);
                gb.setGiftName(str2);
                gb.fR("" + j);
                gb.setThumbnailUrl(str3);
                BdResourceLoader.getInstance().loadResource(gb.getThumbnail_url(), 10, null, BdUniqueId.gen());
            }
            com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(str, j, gb, str4, str5, str6, str7, str8, z, str9, str10, j2, str14, j3);
            cVar.aS(System.currentTimeMillis());
            cVar.bcN = false;
            cVar.bX(z3);
            cVar.chatMCastId = str12;
            cVar.ensureMCastId = str13;
            cVar.bZd = z5;
            cVar.bZe = i;
            cVar.bZf = z6;
            if (com.baidu.live.ae.a.Qj().buX.aLt && !TextUtils.isEmpty(str11)) {
                k kVar = new k();
                if (kVar.fS(str11)) {
                    cVar.bcO.aWe = kVar;
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
                        g gb = gb(optString);
                        if (gb == null) {
                            String sharedPrefKeyWithAccount = d.getSharedPrefKeyWithAccount("last_send_get_gift_list_time_yuyin");
                            if (System.currentTimeMillis() - d.xc().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                                d.xc().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                            }
                            gb = new g();
                            gb.fQ(optString);
                            gb.setGiftName(optString2);
                            gb.setThumbnailUrl(optString3);
                            BdResourceLoader.getInstance().loadResource(gb.getThumbnail_url(), 10, null, BdUniqueId.gen());
                        }
                        arrayList.add(gb);
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
                com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(gVar.DR(), j3, gVar, str2, str3, str4, str5, str6, z, str7, str8, j, str12, 0L);
                cVar.aS(System.currentTimeMillis());
                cVar.bcN = false;
                cVar.bX(true);
                cVar.chatMCastId = str10;
                cVar.ensureMCastId = str11;
                if (com.baidu.live.ae.a.Qj().buX.aLt && !TextUtils.isEmpty(str9)) {
                    k kVar = new k();
                    if (kVar.fS(str9)) {
                        cVar.bcO.aWe = kVar;
                    }
                }
                if (arrayList.size() >= 2) {
                    com.baidu.live.yuyingift.b.a(j, gVar.DR(), str2, str4, j3, j2, str12);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
            }
        }
    }

    @Override // com.baidu.live.gift.aj
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12) {
        g gVar = new g();
        gVar.fQ(str);
        gVar.setGiftName(str2);
        gVar.fR("" + j);
        gVar.setThumbnailUrl(str3);
        com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2, str12, 0L);
        cVar.aS(System.currentTimeMillis());
        cVar.bcN = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bX(z3);
        cVar.bcZ = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
    }

    @Override // com.baidu.live.gift.aj
    protected void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12) {
        g gVar = new g();
        gVar.fQ(str);
        gVar.setGiftName(str2);
        gVar.fR("" + j);
        gVar.setThumbnailUrl(str3);
        a(str, j, str4, str6, str5, j2, str12, z, false);
        com.baidu.live.yuyingift.a.c cVar = new com.baidu.live.yuyingift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10, j2, str12, 0L);
        cVar.aS(System.currentTimeMillis());
        cVar.bcN = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.bX(z3);
        cVar.bcZ = false;
        cVar.bda = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501063, cVar));
    }

    @Override // com.baidu.live.gift.aj
    protected void gj(String str) {
        if (this.bZJ == null) {
            this.bZJ = new com.baidu.live.yuyingift.c.d();
        }
        this.bZJ.gN(str);
    }

    @Override // com.baidu.live.gift.aj
    protected void a(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6, int i3, long j) {
        if (this.bZJ == null) {
            this.bZJ = new com.baidu.live.yuyingift.c.d();
        }
        this.bZJ.a(str, str2, str3, str4, 1, 0, "", str6, System.currentTimeMillis(), i3, j);
    }

    private void a(String str, long j, String str2, String str3, String str4, long j2, String str5, boolean z, boolean z2) {
        if (gg(str)) {
            if (!go(str)) {
                if (BdNetTypeUtil.isWifiNet() || !m.Vp()) {
                    if (this.beX == null) {
                        this.beX = new ArrayList<>();
                    }
                    this.beX.add(new com.baidu.live.yuyingift.a.c(str, j, null, str2, str4, str3, "", "", false, "", "", j2, str5, 0L));
                    com.baidu.live.gift.c gM = YX().gM(str);
                    if (gM != null) {
                        am.FC().a(gM.aVs, false);
                    }
                }
            }
        } else if (z2) {
            k(z, str);
        }
    }

    @Override // com.baidu.live.gift.aj
    public void Fq() {
        if (ListUtils.isEmpty(this.beN)) {
            this.bfi = true;
            return;
        }
        Iterator<com.baidu.live.gift.c> it = this.beN.iterator();
        while (it.hasNext()) {
            com.baidu.live.gift.c next = it.next();
            if (next != null && next.aVs != null && !YX().ge(next.getDynamicGiftId())) {
                com.baidu.live.gift.b bVar = next.aVs;
                if (bVar.aVp != null) {
                    am.FC().a(bVar, false);
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
        if (this.bZI != null) {
            this.bZI.onDestroy();
            this.bZI = null;
        }
        if (this.bZG != null) {
            this.bZG.onDestroy();
            this.bZG = null;
        }
        if (this.bZH != null) {
            this.bZH.onDestroy();
            this.bZH = null;
        }
        if (this.bff != null) {
            this.bff.onDestroy();
            this.bff = null;
        }
        if (this.bZJ != null) {
            this.bZJ.release();
            this.bZJ = null;
        }
        if (this.beX != null) {
            this.beX.clear();
        }
        am.FC().EZ();
        this.baV.clear();
        this.beN.clear();
        this.aJZ = null;
        this.bfj = null;
    }
}
