package com.baidu.live.gift.b;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.resourceloader.BdResourceLoader;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.b.d;
import com.baidu.live.gift.g;
import com.baidu.live.gift.giftList.a;
import com.baidu.live.gift.i;
import com.baidu.live.gift.l;
import com.baidu.live.gift.s;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.utils.k;
import com.baidu.live.utils.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends s {
    private static b akE;
    private ArrayList<g> aht;
    private ArrayList<com.baidu.live.gift.a.c> akF;
    private Map<String, com.baidu.live.gift.a.b> akG;
    private com.baidu.live.gift.giftList.a akH;
    private com.baidu.live.gift.giftList.b akI;
    private com.baidu.live.j.c akJ;
    private d akK;
    private ArrayList<com.baidu.live.gift.c> aku;
    private boolean akL = false;
    private d.a akM = new d.a() { // from class: com.baidu.live.gift.b.b.1
        @Override // com.baidu.live.gift.b.d.a
        public void b(int i, String str, int i2, Object obj, long j) {
            b.this.a(i, str, i2, obj, j);
        }
    };
    private a.InterfaceC0080a akN = new a.InterfaceC0080a() { // from class: com.baidu.live.gift.b.b.2
        @Override // com.baidu.live.gift.giftList.a.InterfaceC0080a
        public void h(ArrayList<com.baidu.live.gift.c> arrayList) {
            b.this.aku.clear();
            if (!ListUtils.isEmpty(arrayList)) {
                b.this.aku.addAll(arrayList);
                if (b.this.akL && TbadkCoreApplication.isShownNetChangeDialog.booleanValue()) {
                    b.this.te();
                }
            }
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.b.b.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Map.Entry entry;
            if (message.what == 100) {
                Set entrySet = b.this.akG.entrySet();
                if (entrySet.isEmpty()) {
                    if (b.this.akJ != null) {
                        b.this.akJ.refreshCurUserScores();
                    }
                    return true;
                }
                if (b.this.akK != null && !b.this.akK.mIsSending && (entry = (Map.Entry) entrySet.iterator().next()) != null) {
                    b.this.akK.a((com.baidu.live.gift.a.b) entry.getValue());
                    b.this.akG.remove(entry.getKey());
                }
                b.this.mHandler.sendEmptyMessage(100);
            }
            return false;
        }
    });
    private CustomMessageListener akO = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.f.c cVar;
            g df;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.f.c) && !ListUtils.isEmpty(b.this.akF) && (cVar = (com.baidu.live.f.c) customResponsedMessage.getData()) != null && cVar.acU != null && cVar.acT == 5) {
                String id = cVar.acU.getId();
                ArrayList arrayList = new ArrayList();
                Iterator it = b.this.akF.iterator();
                while (it.hasNext()) {
                    com.baidu.live.gift.a.c cVar2 = (com.baidu.live.gift.a.c) it.next();
                    if (!TextUtils.isEmpty(cVar2.giftId) && cVar2.giftId.equals(id) && (df = s.df(cVar2.giftId)) != null) {
                        arrayList.add(cVar2);
                        b.this.a(cVar2.giftId, cVar2.ajs, df.qF(), df.qH(), cVar2.userId, cVar2.portrait, cVar2.userName, "", "", false, "", "", "");
                    }
                }
                b.this.akF.removeAll(arrayList);
            }
        }
    };

    public static b ta() {
        if (akE == null) {
            synchronized (b.class) {
                if (akE == null) {
                    akE = new b();
                }
            }
        }
        return akE;
    }

    private b() {
        a((s) this);
        this.aku = new ArrayList<>();
        this.aht = new ArrayList<>();
        this.akG = new HashMap();
    }

    @Override // com.baidu.live.gift.s
    public void a(BdPageContext bdPageContext) {
        MessageManager.getInstance().registerListener(this.akO);
        if (this.akI == null) {
            this.akI = new com.baidu.live.gift.giftList.b(bdPageContext);
        }
        if (this.akH == null) {
            this.akH = new com.baidu.live.gift.giftList.a(bdPageContext);
            this.akH.a(this.akN);
        }
        tb();
        tc();
        if (this.akK == null) {
            this.akK = new d(bdPageContext);
            this.akK.setUniqueId(BdUniqueId.gen());
        }
        this.akK.initListener();
        this.akK.a(this.akM);
        if (this.akJ == null) {
            this.akJ = new com.baidu.live.j.c();
        }
        this.akJ.initListener();
        this.akJ.refreshCurUserScores();
    }

    private void tb() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = com.baidu.live.c.oJ().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0;
        if (AlaLiveSwitchData.isHotLive == 0) {
            this.akI.i(q.yO(), z);
        }
    }

    private void tc() {
        this.akH.loadData();
    }

    public String td() {
        return q.yO();
    }

    public void f(String str, ArrayList<i> arrayList) {
        if (!ListUtils.isEmpty(arrayList)) {
            if (this.aht == null) {
                this.aht = new ArrayList<>();
            }
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                i next = it.next();
                if (!ListUtils.isEmpty(next.qX())) {
                    c(str, next.qX());
                }
            }
        }
    }

    private void c(String str, List<g> list) {
        boolean z;
        if (!ListUtils.isEmpty(list)) {
            for (g gVar : list) {
                Iterator<g> it = this.aht.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    g next = it.next();
                    if (next != null && !TextUtils.isEmpty(next.qE()) && next.qE().equals(gVar.qE())) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    gVar.setSceneFrom(str);
                    this.aht.add(gVar);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.s
    public boolean de(String str) {
        if (StringUtils.isNull(str) || ListUtils.isEmpty(this.aku)) {
            return false;
        }
        for (int i = 0; i < this.aku.size(); i++) {
            if (str.equals(this.aku.get(i).getDynamicGiftId())) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.live.gift.c dw(String str) {
        if (!StringUtils.isNull(str) && !ListUtils.isEmpty(this.aku)) {
            boolean z = UtilHelper.getRealScreenOrientation(TbadkCoreApplication.getInst().getContext()) == 2;
            for (int i = 0; i < this.aku.size(); i++) {
                com.baidu.live.gift.c cVar = this.aku.get(i);
                if (str.equals(cVar.getDynamicGiftId()) && z == cVar.isLandScapeZip()) {
                    return cVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.live.gift.s
    public boolean dc(String str) {
        com.baidu.live.gift.c dw;
        return (StringUtils.isNull(str) || (dw = dw(str)) == null || ListUtils.isEmpty(dw.getDynamicGiftPicPathList())) ? false : true;
    }

    @Override // com.baidu.live.gift.s
    protected boolean dd(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return a.dv(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, Object obj, long j) {
        if (i2 == 1 || i2 == 2) {
            if (i >= 0) {
                if (this.akG != null && this.akG.size() == 0) {
                    if (i == 0) {
                        if (i2 == 1) {
                            TbadkCoreApplication.getInst().currentAccountTdouNum = ((Long) obj).longValue();
                        } else {
                            TbadkCoreApplication.getInst().currentAccountFlowerNum = ((Long) obj).longValue();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                    } else if (this.akJ != null) {
                        this.akJ.refreshCurUserScores();
                    }
                }
                if (i == 0) {
                    if (i2 == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913126, Long.valueOf(j)));
                        return;
                    }
                    return;
                } else if (i != 2270014) {
                    if (i == 2270005) {
                        BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), str);
                        return;
                    } else {
                        BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), str);
                        return;
                    }
                } else {
                    return;
                }
            }
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), str);
        }
    }

    public void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), TbadkCoreApplication.getInst().getContext().getResources().getString(a.i.sdk_no_network_guide));
        } else if (gVar != null) {
            if (gVar.qQ()) {
                TiebaInitialize.log(new StatisticItem("c12792").param("obj_id", gVar.qE()).param("obj_param1", gVar.qI()).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, dc(gVar.qE()) ? 1 : 0));
            }
            a(gVar, j, str, str2, str3, str5);
        }
    }

    public void b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        a(gVar, j, str, str2, str3, str4, str5, str6, str7);
        a(gVar, j, str, str2, str3, str4, str6, str7);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(gVar.qE(), j, gVar, currentAccountInfo.getID(), currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), currentAccountInfo.getLiveLevel(), currentAccountInfo.getSex(), "", -1, str3, "", false, str, str4);
        cVar.A(System.currentTimeMillis());
        cVar.ajn = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    private String j(String str, String str2, String str3, String str4) {
        return str + str2 + str3 + str4;
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6) {
        if (this.akK != null) {
            com.baidu.live.gift.a.b bVar = new com.baidu.live.gift.a.b(gVar, j, str, str2, str3, str4, str5, str6);
            if (j == 1) {
                bVar.afv = 0;
            } else {
                bVar.afv = 1;
            }
            if (this.akK.mIsSending || !this.akG.isEmpty()) {
                String j2 = j(str3, str, gVar.qE(), String.valueOf(j));
                com.baidu.live.gift.a.b bVar2 = this.akG.get(j2);
                if (bVar2 == null) {
                    this.akG.put(j2, bVar);
                } else {
                    bVar2.ajl += j;
                }
                this.mHandler.sendEmptyMessage(100);
                return;
            }
            this.akK.a(bVar);
        }
    }

    @Override // com.baidu.live.gift.s
    public g db(String str) {
        if (TextUtils.isEmpty(str) || this.aht == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.aht.size()) {
                return null;
            }
            g gVar = this.aht.get(i2);
            if (!str.equals(gVar.qE())) {
                i = i2 + 1;
            } else {
                return gVar;
            }
        }
    }

    @Override // com.baidu.live.gift.s
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11) {
        a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, true, true);
    }

    public void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3) {
        if (!StringUtils.isNull(str4)) {
            if (!z2 || !str4.equals(TbadkCoreApplication.getCurrentAccount())) {
                a(str, j, str4, str6, str5);
                g db = db(str);
                if (db == null) {
                    String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount("last_send_get_gift_list_time");
                    if (System.currentTimeMillis() - com.baidu.live.c.oJ().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                        com.baidu.live.c.oJ().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                    }
                    db = new g();
                    db.cX(str);
                    db.setGiftName(str2);
                    db.cY("" + j);
                    db.setThumbnailUrl(str3);
                    BdResourceLoader.getInstance().loadResource(db.qH(), 10, null, BdUniqueId.gen());
                }
                com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, db, str4, str5, str6, str7, str8, z, str9, str10);
                cVar.A(System.currentTimeMillis());
                cVar.ajn = false;
                cVar.aK(z3);
                if (com.baidu.live.s.a.wR().asq.XI && !TextUtils.isEmpty(str11)) {
                    l lVar = new l();
                    if (lVar.cZ(str11)) {
                        cVar.ajo.ael = lVar;
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
            }
        }
    }

    @Override // com.baidu.live.gift.s
    protected void a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9) {
        if (!StringUtils.isNull(str2) && !str2.equals(TbadkCoreApplication.getCurrentAccount())) {
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
                        int optInt = jSONObject.optInt("gift_count");
                        String optString3 = jSONObject.optString("gift_url");
                        g db = db(optString);
                        if (db == null) {
                            String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount("last_send_get_gift_list_time");
                            if (System.currentTimeMillis() - com.baidu.live.c.oJ().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                                com.baidu.live.c.oJ().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                            }
                            db = new g();
                            db.cX(optString);
                            db.setGiftName(optString2);
                            db.setThumbnailUrl(optString3);
                            BdResourceLoader.getInstance().loadResource(db.qH(), 10, null, BdUniqueId.gen());
                        }
                        db.cY("" + optInt);
                        arrayList.add(db);
                        i = i2 + 1;
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (!ListUtils.isEmpty(arrayList)) {
                long j = 0;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= arrayList.size()) {
                        break;
                    }
                    j += JavaTypesHelper.toLong(((g) arrayList.get(i4)).qI(), 0L);
                    i3 = i4 + 1;
                }
                g gVar = (g) arrayList.get(0);
                com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(gVar.qE(), j, gVar, str2, str3, str4, str5, str6, z, str7, str8);
                cVar.A(System.currentTimeMillis());
                cVar.ajn = false;
                cVar.aK(true);
                if (com.baidu.live.s.a.wR().asq.XI && !TextUtils.isEmpty(str9)) {
                    l lVar = new l();
                    if (lVar.cZ(str9)) {
                        cVar.ajo.ael = lVar;
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
            }
        }
    }

    @Override // com.baidu.live.gift.s
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4) {
        g gVar = new g();
        gVar.cX(str);
        gVar.setGiftName(str2);
        gVar.cY("" + j);
        gVar.setThumbnailUrl(str3);
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10);
        cVar.A(System.currentTimeMillis());
        cVar.ajn = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.aK(z3);
        cVar.ajx = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    private void a(String str, long j, String str2, String str3, String str4) {
        if (de(str) && !dg(str)) {
            if (BdNetTypeUtil.isWifiNet() || !k.yH()) {
                if (this.akF == null) {
                    this.akF = new ArrayList<>();
                }
                this.akF.add(new com.baidu.live.gift.a.c(str, j, null, str2, str4, str3, "", "", false, "", ""));
                com.baidu.live.gift.c dw = ta().dw(str);
                if (dw != null && dw.qu()) {
                    a.b(dw.getDynamicGiftId(), dw.adJ.adH.zipDownloadUrl, dw.adJ.adH.zipName, dw.adJ.adH.zipMD5, false);
                }
            }
        }
    }

    public void te() {
        if (ListUtils.isEmpty(this.aku)) {
            this.akL = true;
            return;
        }
        Iterator<com.baidu.live.gift.c> it = this.aku.iterator();
        while (it.hasNext()) {
            com.baidu.live.gift.c next = it.next();
            if (next != null && next.adJ != null && next.qu() && !ta().dc(next.getDynamicGiftId())) {
                com.baidu.live.gift.b bVar = next.adJ;
                if (bVar.adH != null) {
                    a.b(bVar.giftId, bVar.adH.zipDownloadUrl, bVar.adH.zipName, bVar.adH.zipMD5, false);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.s
    public void onDestroy() {
        this.akL = false;
        MessageManager.getInstance().unRegisterListener(this.akO);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.akK != null) {
            this.akK.onDestroy();
            this.akK = null;
        }
        if (this.akH != null) {
            this.akH.onDestroy();
            this.akH = null;
        }
        if (this.akI != null) {
            this.akI.onDestroy();
            this.akI = null;
        }
        if (this.akJ != null) {
            this.akJ.onDestroy();
            this.akJ = null;
        }
        if (this.akF != null) {
            this.akF.clear();
        }
        a.sZ();
        this.aht.clear();
        this.aku.clear();
    }
}
