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
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.utils.k;
import com.baidu.live.utils.p;
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
    private static b ajT;
    private ArrayList<g> agK;
    private ArrayList<com.baidu.live.gift.c> ajK;
    private ArrayList<com.baidu.live.gift.a.b> ajU;
    private Map<String, com.baidu.live.gift.a.a> ajV;
    private com.baidu.live.gift.giftList.a ajW;
    private com.baidu.live.gift.giftList.b ajX;
    private com.baidu.live.i.c ajY;
    private d ajZ;
    private boolean aka = false;
    private d.a akb = new d.a() { // from class: com.baidu.live.gift.b.b.1
        @Override // com.baidu.live.gift.b.d.a
        public void b(int i, String str, int i2, Object obj, long j) {
            b.this.a(i, str, i2, obj, j);
        }
    };
    private a.InterfaceC0080a akc = new a.InterfaceC0080a() { // from class: com.baidu.live.gift.b.b.2
        @Override // com.baidu.live.gift.giftList.a.InterfaceC0080a
        public void h(ArrayList<com.baidu.live.gift.c> arrayList) {
            b.this.ajK.clear();
            if (!ListUtils.isEmpty(arrayList)) {
                b.this.ajK.addAll(arrayList);
                if (b.this.aka && TbadkCoreApplication.isShownNetChangeDialog.booleanValue()) {
                    b.this.sO();
                }
            }
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.b.b.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Map.Entry entry;
            if (message.what == 100) {
                Set entrySet = b.this.ajV.entrySet();
                if (entrySet.isEmpty()) {
                    if (b.this.ajY != null) {
                        b.this.ajY.refreshCurUserScores();
                    }
                    return true;
                }
                if (b.this.ajZ != null && !b.this.ajZ.mIsSending && (entry = (Map.Entry) entrySet.iterator().next()) != null) {
                    b.this.ajZ.a((com.baidu.live.gift.a.a) entry.getValue());
                    b.this.ajV.remove(entry.getKey());
                }
                b.this.mHandler.sendEmptyMessage(100);
            }
            return false;
        }
    });
    private CustomMessageListener akd = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.f.c cVar;
            g dd;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.f.c) && !ListUtils.isEmpty(b.this.ajU) && (cVar = (com.baidu.live.f.c) customResponsedMessage.getData()) != null && cVar.acI != null && cVar.acH == 5) {
                String id = cVar.acI.getId();
                ArrayList arrayList = new ArrayList();
                Iterator it = b.this.ajU.iterator();
                while (it.hasNext()) {
                    com.baidu.live.gift.a.b bVar = (com.baidu.live.gift.a.b) it.next();
                    if (!TextUtils.isEmpty(bVar.giftId) && bVar.giftId.equals(id) && (dd = s.dd(bVar.giftId)) != null) {
                        arrayList.add(bVar);
                        b.this.a(bVar.giftId, bVar.aiH, dd.qy(), dd.qA(), bVar.userId, bVar.portrait, bVar.userName, "", "", false, "", "", "");
                    }
                }
                b.this.ajU.removeAll(arrayList);
            }
        }
    };

    public static b sK() {
        if (ajT == null) {
            synchronized (b.class) {
                if (ajT == null) {
                    ajT = new b();
                }
            }
        }
        return ajT;
    }

    private b() {
        a((s) this);
        this.ajK = new ArrayList<>();
        this.agK = new ArrayList<>();
        this.ajV = new HashMap();
    }

    @Override // com.baidu.live.gift.s
    public void a(BdPageContext bdPageContext) {
        MessageManager.getInstance().registerListener(this.akd);
        if (this.ajX == null) {
            this.ajX = new com.baidu.live.gift.giftList.b(bdPageContext);
        }
        if (this.ajW == null) {
            this.ajW = new com.baidu.live.gift.giftList.a(bdPageContext);
            this.ajW.a(this.akc);
        }
        sL();
        sM();
        if (this.ajZ == null) {
            this.ajZ = new d();
            this.ajZ.setUniqueId(BdUniqueId.gen());
        }
        this.ajZ.initListener();
        this.ajZ.a(this.akb);
        if (this.ajY == null) {
            this.ajY = new com.baidu.live.i.c();
        }
        this.ajY.initListener();
        this.ajY.refreshCurUserScores();
    }

    private void sL() {
        long currentTimeMillis = System.currentTimeMillis();
        if (com.baidu.live.c.oI().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0) {
        }
    }

    private void sM() {
        this.ajW.loadData();
    }

    public String sN() {
        return p.yv();
    }

    public void f(String str, ArrayList<i> arrayList) {
        if (!ListUtils.isEmpty(arrayList)) {
            if (this.agK == null) {
                this.agK = new ArrayList<>();
            }
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                i next = it.next();
                if (!ListUtils.isEmpty(next.qQ())) {
                    c(str, next.qQ());
                }
            }
        }
    }

    private void c(String str, List<g> list) {
        boolean z;
        if (!ListUtils.isEmpty(list)) {
            for (g gVar : list) {
                Iterator<g> it = this.agK.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    g next = it.next();
                    if (next != null && !TextUtils.isEmpty(next.qx()) && next.qx().equals(gVar.qx())) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    gVar.setSceneFrom(str);
                    this.agK.add(gVar);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.s
    public boolean dc(String str) {
        if (StringUtils.isNull(str) || ListUtils.isEmpty(this.ajK)) {
            return false;
        }
        for (int i = 0; i < this.ajK.size(); i++) {
            if (str.equals(this.ajK.get(i).getDynamicGiftId())) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.live.gift.c du(String str) {
        if (!StringUtils.isNull(str) && !ListUtils.isEmpty(this.ajK)) {
            boolean z = UtilHelper.getRealScreenOrientation(TbadkCoreApplication.getInst().getContext()) == 2;
            for (int i = 0; i < this.ajK.size(); i++) {
                com.baidu.live.gift.c cVar = this.ajK.get(i);
                if (str.equals(cVar.getDynamicGiftId()) && z == cVar.isLandScapeZip()) {
                    return cVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.live.gift.s
    public boolean da(String str) {
        com.baidu.live.gift.c du;
        return (StringUtils.isNull(str) || (du = du(str)) == null || ListUtils.isEmpty(du.getDynamicGiftPicPathList())) ? false : true;
    }

    @Override // com.baidu.live.gift.s
    protected boolean db(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return a.dt(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, Object obj, long j) {
        if (i2 == 1 || i2 == 2) {
            if (i >= 0) {
                if (this.ajV != null && this.ajV.size() == 0) {
                    if (i == 0) {
                        if (i2 == 1) {
                            TbadkCoreApplication.getInst().currentAccountTdouNum = ((Long) obj).longValue();
                        } else {
                            TbadkCoreApplication.getInst().currentAccountFlowerNum = ((Long) obj).longValue();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                    } else if (this.ajY != null) {
                        this.ajY.refreshCurUserScores();
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
            if (gVar.qJ()) {
                TiebaInitialize.log(new StatisticItem("c12792").param("obj_id", gVar.qx()).param("obj_param1", gVar.qB()).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, da(gVar.qx()) ? 1 : 0));
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
        com.baidu.live.gift.a.b bVar = new com.baidu.live.gift.a.b(gVar.qx(), j, gVar, currentAccountInfo.getID(), currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), currentAccountInfo.getLiveLevel(), currentAccountInfo.getSex(), "", -1, str3, "", false, str, str4);
        bVar.A(System.currentTimeMillis());
        bVar.aiB = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, bVar));
    }

    private String j(String str, String str2, String str3, String str4) {
        return str + str2 + str3 + str4;
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6) {
        if (this.ajZ != null) {
            com.baidu.live.gift.a.a aVar = new com.baidu.live.gift.a.a(gVar, j, str, str2, str3, str4, str5, str6);
            if (j == 1) {
                aVar.aeM = 0;
            } else {
                aVar.aeM = 1;
            }
            if (this.ajZ.mIsSending || !this.ajV.isEmpty()) {
                String j2 = j(str3, str, gVar.qx(), String.valueOf(j));
                com.baidu.live.gift.a.a aVar2 = this.ajV.get(j2);
                if (aVar2 == null) {
                    this.ajV.put(j2, aVar);
                } else {
                    aVar2.aiz += j;
                }
                this.mHandler.sendEmptyMessage(100);
                return;
            }
            this.ajZ.a(aVar);
        }
    }

    @Override // com.baidu.live.gift.s
    public g cZ(String str) {
        if (TextUtils.isEmpty(str) || this.agK == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.agK.size()) {
                return null;
            }
            g gVar = this.agK.get(i2);
            if (!str.equals(gVar.qx())) {
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
                g cZ = cZ(str);
                if (cZ == null) {
                    String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount("last_send_get_gift_list_time");
                    if (System.currentTimeMillis() - com.baidu.live.c.oI().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                        com.baidu.live.c.oI().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                    }
                    cZ = new g();
                    cZ.cV(str);
                    cZ.setGiftName(str2);
                    cZ.cW("" + j);
                    cZ.setThumbnailUrl(str3);
                    BdResourceLoader.getInstance().loadResource(cZ.qA(), 10, null, BdUniqueId.gen());
                }
                com.baidu.live.gift.a.b bVar = new com.baidu.live.gift.a.b(str, j, cZ, str4, str5, str6, str7, str8, z, str9, str10);
                bVar.A(System.currentTimeMillis());
                bVar.aiB = false;
                bVar.aI(z3);
                if (com.baidu.live.r.a.wA().arE.Xp && !TextUtils.isEmpty(str11)) {
                    l lVar = new l();
                    if (lVar.cX(str11)) {
                        bVar.aiC.adW = lVar;
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, bVar));
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
                        g cZ = cZ(optString);
                        if (cZ == null) {
                            String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount("last_send_get_gift_list_time");
                            if (System.currentTimeMillis() - com.baidu.live.c.oI().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                                com.baidu.live.c.oI().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                            }
                            cZ = new g();
                            cZ.cV(optString);
                            cZ.setGiftName(optString2);
                            cZ.setThumbnailUrl(optString3);
                            BdResourceLoader.getInstance().loadResource(cZ.qA(), 10, null, BdUniqueId.gen());
                        }
                        cZ.cW("" + optInt);
                        arrayList.add(cZ);
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
                    j += JavaTypesHelper.toLong(((g) arrayList.get(i4)).qB(), 0L);
                    i3 = i4 + 1;
                }
                g gVar = (g) arrayList.get(0);
                com.baidu.live.gift.a.b bVar = new com.baidu.live.gift.a.b(gVar.qx(), j, gVar, str2, str3, str4, str5, str6, z, str7, str8);
                bVar.A(System.currentTimeMillis());
                bVar.aiB = false;
                bVar.aI(true);
                if (com.baidu.live.r.a.wA().arE.Xp && !TextUtils.isEmpty(str9)) {
                    l lVar = new l();
                    if (lVar.cX(str9)) {
                        bVar.aiC.adW = lVar;
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, bVar));
            }
        }
    }

    @Override // com.baidu.live.gift.s
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4) {
        g gVar = new g();
        gVar.cV(str);
        gVar.setGiftName(str2);
        gVar.cW("" + j);
        gVar.setThumbnailUrl(str3);
        com.baidu.live.gift.a.b bVar = new com.baidu.live.gift.a.b(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10);
        bVar.A(System.currentTimeMillis());
        bVar.aiB = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        bVar.aI(z3);
        bVar.aiM = true;
        if (z4) {
            bVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, bVar));
    }

    private void a(String str, long j, String str2, String str3, String str4) {
        if (dc(str) && !de(str)) {
            if (BdNetTypeUtil.isWifiNet() || !k.yr()) {
                if (this.ajU == null) {
                    this.ajU = new ArrayList<>();
                }
                this.ajU.add(new com.baidu.live.gift.a.b(str, j, null, str2, str4, str3, "", "", false, "", ""));
                com.baidu.live.gift.c du = sK().du(str);
                if (du != null && du.qn()) {
                    a.b(du.getDynamicGiftId(), du.adu.ads.zipDownloadUrl, du.adu.ads.zipName, du.adu.ads.zipMD5, false);
                }
            }
        }
    }

    public void sO() {
        if (ListUtils.isEmpty(this.ajK)) {
            this.aka = true;
            return;
        }
        Iterator<com.baidu.live.gift.c> it = this.ajK.iterator();
        while (it.hasNext()) {
            com.baidu.live.gift.c next = it.next();
            if (next != null && next.adu != null && next.qn() && !sK().da(next.getDynamicGiftId())) {
                com.baidu.live.gift.b bVar = next.adu;
                if (bVar.ads != null) {
                    a.b(bVar.giftId, bVar.ads.zipDownloadUrl, bVar.ads.zipName, bVar.ads.zipMD5, false);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.s
    public void onDestroy() {
        this.aka = false;
        MessageManager.getInstance().unRegisterListener(this.akd);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.ajZ != null) {
            this.ajZ.onDestroy();
            this.ajZ = null;
        }
        if (this.ajW != null) {
            this.ajW.onDestroy();
            this.ajW = null;
        }
        if (this.ajX != null) {
            this.ajX.onDestroy();
            this.ajX = null;
        }
        if (this.ajY != null) {
            this.ajY.onDestroy();
            this.ajY = null;
        }
        if (this.ajU != null) {
            this.ajU.clear();
        }
        a.sJ();
        this.agK.clear();
        this.ajK.clear();
    }
}
