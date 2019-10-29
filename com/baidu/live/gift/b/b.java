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
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.b.d;
import com.baidu.live.gift.g;
import com.baidu.live.gift.giftList.a;
import com.baidu.live.gift.h;
import com.baidu.live.gift.k;
import com.baidu.live.gift.q;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.utils.o;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public class b extends q {
    private static b acp;
    private ArrayList<g> Ze;
    private ArrayList<com.baidu.live.gift.c> acd;
    private ArrayList<com.baidu.live.gift.a.d> acq;
    private Map<String, com.baidu.live.gift.a.c> acr;
    private com.baidu.live.gift.giftList.a acs;
    private com.baidu.live.gift.giftList.d act;
    private com.baidu.live.e.b acu;
    private d acv;
    private d.a acx = new d.a() { // from class: com.baidu.live.gift.b.b.1
        @Override // com.baidu.live.gift.b.d.a
        public void b(int i, String str, int i2, Object obj, long j) {
            b.this.a(i, str, i2, obj, j);
        }
    };
    private a.InterfaceC0066a acy = new a.InterfaceC0066a() { // from class: com.baidu.live.gift.b.b.2
        @Override // com.baidu.live.gift.giftList.a.InterfaceC0066a
        public void h(ArrayList<com.baidu.live.gift.c> arrayList) {
            b.this.acd.clear();
            if (!ListUtils.isEmpty(arrayList)) {
                b.this.acd.addAll(arrayList);
            }
        }
    };
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.live.gift.b.b.3
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Map.Entry entry;
            if (message.what == 100) {
                Set entrySet = b.this.acr.entrySet();
                if (entrySet.isEmpty()) {
                    if (b.this.acu != null) {
                        b.this.acu.refreshCurUserScores();
                    }
                    return true;
                }
                if (b.this.acv != null && !b.this.acv.mIsSending && (entry = (Map.Entry) entrySet.iterator().next()) != null) {
                    b.this.acv.a((com.baidu.live.gift.a.c) entry.getValue());
                    b.this.acr.remove(entry.getKey());
                }
                b.this.mHandler.sendEmptyMessage(100);
            }
            return false;
        }
    });
    private CustomMessageListener acz = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.d.c cVar;
            g cl;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.d.c) && !ListUtils.isEmpty(b.this.acq) && (cVar = (com.baidu.live.d.c) customResponsedMessage.getData()) != null && cVar.VA != null && cVar.Vz == 5) {
                String id = cVar.VA.getId();
                ArrayList arrayList = new ArrayList();
                Iterator it = b.this.acq.iterator();
                while (it.hasNext()) {
                    com.baidu.live.gift.a.d dVar = (com.baidu.live.gift.a.d) it.next();
                    if (dVar.giftId.equals(id) && (cl = q.cl(dVar.giftId)) != null) {
                        arrayList.add(dVar);
                        b.this.a(dVar.giftId, dVar.aaW, cl.pd(), cl.pf(), dVar.userId, dVar.portrait, dVar.userName, "", "", false, "", "", "");
                    }
                }
                b.this.acq.removeAll(arrayList);
            }
        }
    };

    public static b rc() {
        if (acp == null) {
            synchronized (b.class) {
                if (acp == null) {
                    acp = new b();
                }
            }
        }
        return acp;
    }

    private b() {
        a((q) this);
        this.acd = new ArrayList<>();
        this.Ze = new ArrayList<>();
        this.acr = new HashMap();
    }

    @Override // com.baidu.live.gift.q
    public void a(BdPageContext bdPageContext) {
        MessageManager.getInstance().registerListener(this.acz);
        if (this.act == null) {
            this.act = new com.baidu.live.gift.giftList.d(bdPageContext);
        }
        if (this.acs == null) {
            this.acs = new com.baidu.live.gift.giftList.a(bdPageContext);
            this.acs.a(this.acy);
        }
        rd();
        re();
        if (this.acv == null) {
            this.acv = new d();
            this.acv.setUniqueId(BdUniqueId.gen());
        }
        this.acv.initListener();
        this.acv.a(this.acx);
        if (this.acu == null) {
            this.acu = new com.baidu.live.e.b();
        }
        this.acu.initListener();
        this.acu.refreshCurUserScores();
    }

    private void rd() {
        long currentTimeMillis = System.currentTimeMillis();
        this.act.f(o.wu(), com.baidu.live.c.np().getLong("ala_sdk_get_gift_list_req_time", currentTimeMillis) - currentTimeMillis <= 0);
    }

    private void re() {
        this.acs.loadData();
    }

    public String rf() {
        return o.wu();
    }

    public void e(String str, ArrayList<h> arrayList) {
        if (!ListUtils.isEmpty(arrayList)) {
            if (this.Ze == null) {
                this.Ze = new ArrayList<>();
            }
            Iterator<h> it = arrayList.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (!ListUtils.isEmpty(next.pt())) {
                    d(str, next.pt());
                }
            }
        }
    }

    private void d(String str, List<g> list) {
        boolean z;
        if (!ListUtils.isEmpty(list)) {
            for (g gVar : list) {
                Iterator<g> it = this.Ze.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    g next = it.next();
                    if (next != null && next.pc().equals(gVar.pc())) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    gVar.setSceneFrom(str);
                    this.Ze.add(gVar);
                }
            }
        }
    }

    @Override // com.baidu.live.gift.q
    public boolean ck(String str) {
        if (StringUtils.isNull(str) || ListUtils.isEmpty(this.acd)) {
            return false;
        }
        for (int i = 0; i < this.acd.size(); i++) {
            if (str.equals(this.acd.get(i).getDynamicGiftId())) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.live.gift.c cC(String str) {
        if (!StringUtils.isNull(str) && !ListUtils.isEmpty(this.acd)) {
            boolean z = UtilHelper.getRealScreenOrientation(TbadkCoreApplication.getInst().getContext()) == 2;
            for (int i = 0; i < this.acd.size(); i++) {
                com.baidu.live.gift.c cVar = this.acd.get(i);
                if (str.equals(cVar.getDynamicGiftId()) && z == cVar.isLandScapeZip()) {
                    return cVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.live.gift.q
    public boolean ci(String str) {
        com.baidu.live.gift.c cC;
        return (StringUtils.isNull(str) || (cC = cC(str)) == null || ListUtils.isEmpty(cC.getDynamicGiftPicPathList())) ? false : true;
    }

    @Override // com.baidu.live.gift.q
    protected boolean cj(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return a.cB(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2, Object obj, long j) {
        if (i2 == 1 || i2 == 2) {
            if (i >= 0) {
                if (this.acr != null && this.acr.size() == 0) {
                    if (i == 0) {
                        if (i2 == 1) {
                            TbadkCoreApplication.getInst().currentAccountTdouNum = ((Long) obj).longValue();
                        } else {
                            TbadkCoreApplication.getInst().currentAccountFlowerNum = ((Long) obj).longValue();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
                    } else if (this.acu != null) {
                        this.acu.refreshCurUserScores();
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
            if (gVar.pn()) {
                TiebaInitialize.log(new StatisticItem("c12792").param("obj_id", gVar.pc()).param("obj_param1", gVar.pg()).param("obj_locate", BdNetTypeUtil.isWifiNet() ? 1 : 0).param(TiebaInitialize.Params.OBJ_PARAM2, ci(gVar.pc()) ? 1 : 0));
            }
            a(gVar, j, str, str2, str3, str5);
        }
    }

    public void b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        a(gVar, j, str, str2, str3, str4, str5, str6, str7);
        a(gVar, j, str, str2, str3, str4, str6, str7);
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4) {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        com.baidu.live.gift.a.d dVar = new com.baidu.live.gift.a.d(gVar.pc(), j, gVar, currentAccountInfo.getID(), currentAccountInfo.getPortrait(), currentAccountInfo.getAccountNameShow(), currentAccountInfo.getLiveLevel(), currentAccountInfo.getSex(), "", -1, str3, "", false, str, str4);
        dVar.z(System.currentTimeMillis());
        dVar.aaQ = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, dVar));
    }

    private String j(String str, String str2, String str3, String str4) {
        return str + str2 + str3 + str4;
    }

    private void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6) {
        if (this.acv != null) {
            com.baidu.live.gift.a.c cVar = new com.baidu.live.gift.a.c(gVar, j, str, str2, str3, str4, str5, str6);
            if (j == 1) {
                cVar.WB = 0;
            } else {
                cVar.WB = 1;
            }
            if (this.acv.mIsSending || !this.acr.isEmpty()) {
                String j2 = j(str3, str, gVar.pc(), String.valueOf(j));
                com.baidu.live.gift.a.c cVar2 = this.acr.get(j2);
                if (cVar2 == null) {
                    this.acr.put(j2, cVar);
                } else {
                    cVar2.aaO += j;
                }
                this.mHandler.sendEmptyMessage(100);
                return;
            }
            this.acv.a(cVar);
        }
    }

    @Override // com.baidu.live.gift.q
    public g ch(String str) {
        if (TextUtils.isEmpty(str) || this.Ze == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.Ze.size()) {
                return null;
            }
            g gVar = this.Ze.get(i2);
            if (!str.equals(gVar.pc())) {
                i = i2 + 1;
            } else {
                return gVar;
            }
        }
    }

    @Override // com.baidu.live.gift.q
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11) {
        a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, true, true);
    }

    public void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3) {
        if (!StringUtils.isNull(str4)) {
            if (!z2 || !str4.equals(TbadkCoreApplication.getCurrentAccount())) {
                a(str, j, str4, str6, str5);
                g ch = ch(str);
                if (ch == null) {
                    String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount("last_send_get_gift_list_time");
                    if (System.currentTimeMillis() - com.baidu.live.c.np().getLong(sharedPrefKeyWithAccount, 0L) > ReportUserInfoModel.TIME_INTERVAL) {
                        com.baidu.live.c.np().putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                    }
                    ch = new g();
                    ch.ce(str);
                    ch.setGiftName(str2);
                    ch.cf("" + j);
                    ch.setThumbnailUrl(str3);
                    BdResourceLoader.getInstance().loadResource(ch.pf(), 10, null, BdUniqueId.gen());
                }
                com.baidu.live.gift.a.d dVar = new com.baidu.live.gift.a.d(str, j, ch, str4, str5, str6, str7, str8, z, str9, str10);
                dVar.z(System.currentTimeMillis());
                dVar.aaQ = false;
                dVar.as(z3);
                if (com.baidu.live.l.a.uA().ajX.Rb && !TextUtils.isEmpty(str11)) {
                    k kVar = new k();
                    if (kVar.cg(str11)) {
                        dVar.aaR.WJ = kVar;
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, dVar));
            }
        }
    }

    @Override // com.baidu.live.gift.q
    protected void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4) {
        g gVar = new g();
        gVar.ce(str);
        gVar.setGiftName(str2);
        gVar.cf("" + j);
        gVar.setThumbnailUrl(str3);
        com.baidu.live.gift.a.d dVar = new com.baidu.live.gift.a.d(str, j, gVar, str4, str5, str6, str7, str8, z, str9, str10);
        dVar.z(System.currentTimeMillis());
        dVar.aaQ = TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(str4);
        dVar.as(z3);
        dVar.abb = true;
        if (z4) {
            dVar.priority = 11;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913031, dVar));
    }

    private void a(String str, long j, String str2, String str3, String str4) {
        if (ck(str) && !cm(str) && BdNetTypeUtil.isWifiNet()) {
            if (this.acq == null) {
                this.acq = new ArrayList<>();
            }
            this.acq.add(new com.baidu.live.gift.a.d(str, j, null, str2, str4, str3, "", "", false, "", ""));
            com.baidu.live.gift.c cC = rc().cC(str);
            if (cC != null) {
                a.b(cC.getDynamicGiftId(), cC.Wm.Wk.zipDownloadUrl, cC.Wm.Wk.zipName, cC.Wm.Wk.zipMD5, false);
            }
        }
    }

    @Override // com.baidu.live.gift.q
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.acz);
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.acv != null) {
            this.acv.onDestroy();
            this.acv = null;
        }
        if (this.acs != null) {
            this.acs.onDestroy();
            this.acs = null;
        }
        if (this.act != null) {
            this.act.onDestroy();
            this.act = null;
        }
        if (this.acu != null) {
            this.acu.onDestroy();
            this.acu = null;
        }
        if (this.acq != null) {
            this.acq.clear();
        }
        a.rb();
        this.Ze.clear();
        this.acd.clear();
    }
}
