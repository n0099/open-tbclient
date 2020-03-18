package com.baidu.live.gift.b;

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
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.b.c;
import com.baidu.live.gift.g;
import com.baidu.live.gift.giftList.a;
import com.baidu.live.gift.i;
import com.baidu.live.gift.l;
import com.baidu.live.gift.t;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.u.a;
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
/* loaded from: classes3.dex */
public class b extends t {
    private static volatile b anb;
    private ArrayList<g> ajN;
    private ArrayList<com.baidu.live.gift.c> amQ;
    private ArrayList<com.baidu.live.gift.a.c> anc;
    private Map<String, com.baidu.live.gift.a.b> and;
    private com.baidu.live.gift.giftList.a ane;
    private com.baidu.live.gift.giftList.b anf;
    private com.baidu.live.k.c ang;
    private c anh;
    private com.baidu.live.gift.c.c ani;
    private boolean anj = false;
    private c.a ank = new c.a() { // from class: com.baidu.live.gift.b.b.1
        @Override // com.baidu.live.gift.b.c.a
        public void b(int i, String str, int i2, Object obj, long j) {
            b.this.a(i, str, i2, obj, j);
        }
    };
    private a.InterfaceC0087a anl = new a.InterfaceC0087a() { // from class: com.baidu.live.gift.b.b.2
        @Override // com.baidu.live.gift.giftList.a.InterfaceC0087a
        public void i(ArrayList<com.baidu.live.gift.c> arrayList) {
            b.this.amQ.clear();
            if (!ListUtils.isEmpty(arrayList)) {
                b.this.amQ.addAll(arrayList);
                if (b.this.anj && TbadkCoreApplication.isShownNetChangeDialog.booleanValue()) {
                    b.this.sK();
                }
            }
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.b.b.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Map.Entry entry;
            if (message.what == 100) {
                Set entrySet = b.this.and.entrySet();
                if (entrySet.isEmpty()) {
                    if (b.this.ang != null) {
                        b.this.ang.refreshCurUserScores();
                    }
                    return true;
                }
                if (b.this.anh != null && !b.this.anh.mIsSending && (entry = (Map.Entry) entrySet.iterator().next()) != null) {
                    b.this.anh.a((com.baidu.live.gift.a.b) entry.getValue());
                    b.this.and.remove(entry.getKey());
                }
                b.this.mHandler.sendEmptyMessage(100);
            }
            return false;
        }
    });
    private CustomMessageListener anm = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.f.c cVar;
            g m19do;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.f.c) && !ListUtils.isEmpty(b.this.anc) && (cVar = (com.baidu.live.f.c) customResponsedMessage.getData()) != null && cVar.afh != null && cVar.afg == 5) {
                String id = cVar.afh.getId();
                ArrayList arrayList = new ArrayList();
                Iterator it = b.this.anc.iterator();
                while (it.hasNext()) {
                    com.baidu.live.gift.a.c cVar2 = (com.baidu.live.gift.a.c) it.next();
                    if (!TextUtils.isEmpty(cVar2.giftId) && cVar2.giftId.equals(id) && (m19do = t.m19do(cVar2.giftId)) != null) {
                        arrayList.add(cVar2);
                        b.this.a(cVar2.giftId, cVar2.alL, m19do.rD(), m19do.rF(), cVar2.userId, cVar2.portrait, cVar2.userName, "", "", false, "", "", "", cVar2.Yh, cVar2.Yi);
                    }
                }
                b.this.anc.removeAll(arrayList);
            }
        }
    };

    public static b uz() {
        if (anb == null) {
            synchronized (b.class) {
                if (anb == null) {
                    anb = new b();
                }
            }
        }
        return anb;
    }

    private b() {
        a((t) this);
        this.amQ = new ArrayList<>();
        this.ajN = new ArrayList<>();
        this.and = new HashMap();
    }

    @Override // com.baidu.live.gift.t
    public void a(BdPageContext bdPageContext) {
        MessageManager.getInstance().registerListener(this.anm);
        if (this.anf == null) {
            this.anf = new com.baidu.live.gift.giftList.b(bdPageContext);
        }
        if (this.ane == null) {
            this.ane = new com.baidu.live.gift.giftList.a(bdPageContext);
            this.ane.a(this.anl);
        }
        uA();
        uB();
        if (this.anh == null) {
            this.anh = new c(bdPageContext);
            this.anh.setUniqueId(BdUniqueId.gen());
        }
        this.anh.initListener();
        this.anh.a(this.ank);
        if (this.ang == null) {
            this.ang = new com.baidu.live.k.c();
        }
        this.ang.initListener();
        this.ang.refreshCurUserScores();
    }

    private void uA() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = com.baidu.live.c.pw().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0;
        if (AlaLiveSwitchData.isHotLive == 0) {
            this.anf.i(q.Bn(), z);
        }
    }

    private void uB() {
        this.ane.loadData();
    }

    @Override // com.baidu.live.gift.t
    public String sI() {
        return q.Bn();
    }

    public void e(String str, ArrayList<i> arrayList) {
        if (!ListUtils.isEmpty(arrayList)) {
            if (this.ajN == null) {
                this.ajN = new ArrayList<>();
            }
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                i next = it.next();
                if (!ListUtils.isEmpty(next.sd())) {
                    d(str, next.sd());
                }
            }
        }
    }

    private void d(String str, List<g> list) {
        boolean z;
        if (!ListUtils.isEmpty(list)) {
            for (g gVar : list) {
                Iterator<g> it = this.ajN.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    g next = it.next();
                    if (next != null && !TextUtils.isEmpty(next.rC()) && next.rC().equals(gVar.rC())) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    gVar.setSceneFrom(str);
                    this.ajN.add(gVar);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.t
    public boolean dn(String str) {
        if (StringUtils.isNull(str) || ListUtils.isEmpty(this.amQ)) {
            return false;
        }
        for (int i = 0; i < this.amQ.size(); i++) {
            if (str.equals(this.amQ.get(i).getDynamicGiftId())) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.live.gift.c dG(String str) {
        if (!StringUtils.isNull(str) && !ListUtils.isEmpty(this.amQ)) {
            boolean z = UtilHelper.getRealScreenOrientation(TbadkCoreApplication.getInst().getContext()) == 2;
            for (int i = 0; i < this.amQ.size(); i++) {
                com.baidu.live.gift.c cVar = this.amQ.get(i);
                if (str.equals(cVar.getDynamicGiftId()) && z == cVar.isLandScapeZip()) {
                    return cVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.live.gift.t
    protected String dk(String str) {
        com.baidu.live.gift.c dG = uz().dG(str);
        if (dG == null || dG.afV == null || dG.afV.afT == null) {
            return null;
        }
        return (com.baidu.live.alphavideo.a.pA().pB() && dG.afV.rk()) ? dG.afV.afT.videoUrl : dG.afV.afT.zipDownloadUrl;
    }

    @Override // com.baidu.live.gift.t
    public boolean dl(String str) {
        com.baidu.live.gift.c dG;
        if (StringUtils.isNull(str) || (dG = dG(str)) == null || dG.afV == null) {
            return false;
        }
        if (com.baidu.live.alphavideo.a.pA().pB() && dG.afV.rk() && !TextUtils.isEmpty(dG.rn())) {
            return true;
        }
        return ListUtils.isEmpty(dG.getDynamicGiftPicPathList()) ? false : true;
    }

    @Override // com.baidu.live.gift.t
    protected boolean dm(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return a.X(str, dk(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, Object obj, long j) {
        if (i2 == 1 || i2 == 2) {
            if (i >= 0) {
                if (this.and != null && this.and.size() == 0) {
                    if (i == 0) {
                        if (i2 == 1) {
                            TbadkCoreApplication.getInst().currentAccountTdouNum = ((Long) obj).longValue();
                        } else {
                            TbadkCoreApplication.getInst().currentAccountFlowerNum = ((Long) obj).longValue();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                    } else if (this.ang != null) {
                        this.ang.refreshCurUserScores();
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

    public void c(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), TbadkCoreApplication.getInst().getContext().getResources().getString(a.i.sdk_no_network_guide));
        } else if (gVar != null) {
            if (gVar.rO()) {
                TiebaInitialize.log(new StatisticItem("c12792").param("obj_id", gVar.rC()).param("obj_param1", gVar.rG()).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, dl(gVar.rC()) ? 1 : 0));
            }
            a(gVar, j, str, str2, str3, str5);
        }
    }

    @Override // com.baidu.live.gift.t
    public void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        c(gVar, j, str, str2, str3, str4, str5, str6, str7);
        a(gVar, j, str, str2, str3, str4, str6, str7);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913135));
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(gVar.rC(), j, gVar, currentAccountInfo.getID(), currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), currentAccountInfo.getLiveLevel(), currentAccountInfo.getSex(), "", -1, str3, "", false, str, str4);
        cVar.B(System.currentTimeMillis());
        cVar.alG = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    private String k(String str, String str2, String str3, String str4) {
        return str + str2 + str3 + str4;
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6) {
        if (this.anh != null) {
            com.baidu.live.gift.a.b bVar = new com.baidu.live.gift.a.b(gVar, j, str, str2, str3, str4, str5, str6);
            if (j == 1) {
                bVar.ahM = 0;
            } else {
                bVar.ahM = 1;
            }
            if (this.anh.mIsSending || !this.and.isEmpty()) {
                String k = k(str3, str, gVar.rC(), String.valueOf(j));
                com.baidu.live.gift.a.b bVar2 = this.and.get(k);
                if (bVar2 == null) {
                    this.and.put(k, bVar);
                } else {
                    bVar2.alE += j;
                }
                this.mHandler.sendEmptyMessage(100);
                return;
            }
            this.anh.a(bVar);
        }
    }

    @Override // com.baidu.live.gift.t
    public g dj(String str) {
        if (TextUtils.isEmpty(str) || this.ajN == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.ajN.size()) {
                return null;
            }
            g gVar = this.ajN.get(i2);
            if (!str.equals(gVar.rC())) {
                i = i2 + 1;
            } else {
                return gVar;
            }
        }
    }

    @Override // com.baidu.live.gift.t
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13) {
        a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, true, true, str12, str13);
    }

    public void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, String str12, String str13) {
        if (StringUtils.isNull(str4)) {
            if (z) {
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, str12, str13, str, "userId 为空");
            }
        } else if (!z2 || !str4.equals(TbadkCoreApplication.getCurrentAccount())) {
            a(str, j, str4, str6, str5);
            g dj = dj(str);
            if (dj == null) {
                String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount("last_send_get_gift_list_time");
                if (System.currentTimeMillis() - com.baidu.live.c.pw().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                    com.baidu.live.c.pw().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                }
                dj = new g();
                dj.df(str);
                dj.setGiftName(str2);
                dj.dg("" + j);
                dj.setThumbnailUrl(str3);
                BdResourceLoader.getInstance().loadResource(dj.rF(), 10, null, BdUniqueId.gen());
            }
            com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, dj, str4, str5, str6, str7, str8, z, str9, str10);
            cVar.B(System.currentTimeMillis());
            cVar.alG = false;
            cVar.aN(z3);
            cVar.Yh = str12;
            cVar.Yi = str13;
            if (com.baidu.live.v.a.zs().awM.ZJ && !TextUtils.isEmpty(str11)) {
                l lVar = new l();
                if (lVar.dh(str11)) {
                    cVar.alH.agC = lVar;
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
        }
    }

    @Override // com.baidu.live.gift.t
    protected void a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11) {
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
                        g dj = dj(optString);
                        if (dj == null) {
                            String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount("last_send_get_gift_list_time");
                            if (System.currentTimeMillis() - com.baidu.live.c.pw().getLong(sharedPrefKeyWithAccount, 0L) > 300000) {
                                com.baidu.live.c.pw().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                            }
                            dj = new g();
                            dj.df(optString);
                            dj.setGiftName(optString2);
                            dj.setThumbnailUrl(optString3);
                            BdResourceLoader.getInstance().loadResource(dj.rF(), 10, null, BdUniqueId.gen());
                        }
                        dj.dg("" + optInt);
                        arrayList.add(dj);
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
                    j += JavaTypesHelper.toLong(((g) arrayList.get(i4)).rG(), 0L);
                    i3 = i4 + 1;
                }
                g gVar = (g) arrayList.get(0);
                com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(gVar.rC(), j, gVar, str2, str3, str4, str5, str6, z, str7, str8);
                cVar.B(System.currentTimeMillis());
                cVar.alG = false;
                cVar.aN(true);
                cVar.Yh = str10;
                cVar.Yi = str11;
                if (com.baidu.live.v.a.zs().awM.ZJ && !TextUtils.isEmpty(str9)) {
                    l lVar = new l();
                    if (lVar.dh(str9)) {
                        cVar.alH.agC = lVar;
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
            }
        }
    }

    @Override // com.baidu.live.gift.t
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4) {
        g gVar = new g();
        gVar.df(str);
        gVar.setGiftName(str2);
        gVar.dg("" + j);
        gVar.setThumbnailUrl(str3);
        com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10);
        cVar.B(System.currentTimeMillis());
        cVar.alG = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        cVar.aN(z3);
        cVar.alQ = true;
        if (z4) {
            cVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, cVar));
    }

    @Override // com.baidu.live.gift.t
    protected void sJ() {
        if (this.ani == null) {
            this.ani = new com.baidu.live.gift.c.a();
        }
        this.ani.uS();
    }

    @Override // com.baidu.live.gift.t
    protected void a(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        if (this.ani == null) {
            this.ani = new com.baidu.live.gift.c.a();
        }
        this.ani.c(str, str2, str3, str4, 1, 0, "");
    }

    private void a(String str, long j, String str2, String str3, String str4) {
        if (dn(str) && !dp(str)) {
            if (BdNetTypeUtil.isWifiNet() || !k.Bh()) {
                if (this.anc == null) {
                    this.anc = new ArrayList<>();
                }
                this.anc.add(new com.baidu.live.gift.a.c(str, j, null, str2, str4, str3, "", "", false, "", ""));
                com.baidu.live.gift.c dG = uz().dG(str);
                if (dG != null && dG.rm()) {
                    a.a(dG.afV, false);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.t
    public void sK() {
        if (ListUtils.isEmpty(this.amQ)) {
            this.anj = true;
            return;
        }
        Iterator<com.baidu.live.gift.c> it = this.amQ.iterator();
        while (it.hasNext()) {
            com.baidu.live.gift.c next = it.next();
            if (next != null && next.afV != null && next.rm() && !uz().dl(next.getDynamicGiftId())) {
                com.baidu.live.gift.b bVar = next.afV;
                if (bVar.afT != null) {
                    a.a(bVar, false);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.t
    public void onDestroy() {
        this.anj = false;
        MessageManager.getInstance().unRegisterListener(this.anm);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.anh != null) {
            this.anh.onDestroy();
            this.anh = null;
        }
        if (this.ane != null) {
            this.ane.onDestroy();
            this.ane = null;
        }
        if (this.anf != null) {
            this.anf.onDestroy();
            this.anf = null;
        }
        if (this.ang != null) {
            this.ang.onDestroy();
            this.ang = null;
        }
        if (this.ani != null) {
            this.ani.release();
            this.ani = null;
        }
        if (this.anc != null) {
            this.anc.clear();
        }
        a.uy();
        this.ajN.clear();
        this.amQ.clear();
    }
}
