package com.baidu.live.im.c;

import android.util.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.ah;
import com.baidu.live.data.bz;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.j;
import com.baidu.live.im.k;
import com.baidu.live.im.view.ALALiveTextView;
import com.baidu.live.im.view.ALaImMsgView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.timer.LiveTimerManager;
import com.baidu.live.tbadk.timer.OnLiveTimerListener;
import com.baidu.live.view.input.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements k {
    private final ALaImMsgView biB;
    private final ALALiveTextView biC;
    private List<String> biD;
    private List<String> biE;
    private k.a biF;
    private TbPageContext mPageContext;
    private boolean aRM = false;
    private CustomMessageListener bgj = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                List list = (List) customResponsedMessage.getData();
                a.this.U(list);
                a.this.d(list, true);
            }
        }
    };
    private CustomMessageListener bgk = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.c.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (!a.this.aRM && aVar != null && (aVar.Lt() instanceof com.baidu.live.data.a)) {
                    aVar.Lt().aGH = -1;
                }
                a.this.r(aVar);
            }
        }
    };
    private CustomMessageListener biG = new CustomMessageListener(2913044) { // from class: com.baidu.live.im.c.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener biH = new CustomMessageListener(2913095) { // from class: com.baidu.live.im.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.biC != null) {
                    a.this.biC.hy(str);
                }
            }
        }
    };
    private final a.InterfaceC0214a biI = new a.InterfaceC0214a() { // from class: com.baidu.live.im.c.a.5
        @Override // com.baidu.live.view.input.a.InterfaceC0214a
        public boolean KS() {
            return a.this.biF != null && a.this.biF.KS();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0214a
        public void r(String str, boolean z) {
            Log.i("i", "@@@ localText nmpanctr sdhdl 1");
            if (a.this.biF != null) {
                if (a.this.biF.KS()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (a.this.biC != null && a.this.biC.Mi()) {
                        bz barrageInfo = a.this.biC.getBarrageInfo();
                        if (barrageInfo != null) {
                            if (barrageInfo.type == 16 && !a.this.biF.KW()) {
                                BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.i.sdk_throne_disabled_alert);
                                return;
                            } else if (barrageInfo.type == 17 && barrageInfo.aPF > a.this.biF.KX()) {
                                if (barrageInfo.aPF == 7) {
                                    BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.i.sdk_noble_king_disabled_alert);
                                    return;
                                } else {
                                    BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.i.sdk_noble_disabled_alert);
                                    return;
                                }
                            } else {
                                imSendMsgData.msgType = (short) 126;
                                imSendMsgData.barrageType = barrageInfo.type;
                                imSendMsgData.barrageId = barrageInfo.id;
                                imSendMsgData.price = barrageInfo.price;
                            }
                        }
                    } else {
                        imSendMsgData.isQuick = z;
                    }
                    Log.i("i", "@@@ localText nmpanctr sdhdl cmd");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
                    if (!z && a.this.biC != null) {
                        a.this.biC.Mm();
                    }
                } else if (!z) {
                    Log.i("i", "@@@ localText nmpanctr sdhdl nolg");
                    a.this.biF.KT();
                }
                if (z) {
                    a.this.biF.hu(str);
                }
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0214a
        public void KU() {
            if (a.this.biF != null) {
                a.this.biF.KU();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0214a
        public void KV() {
            if (a.this.biF != null) {
                a.this.biF.KV();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0214a
        public boolean KW() {
            return a.this.biF != null && a.this.biF.KW();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0214a
        public int KX() {
            if (a.this.biF != null) {
                return a.this.biF.KX();
            }
            return 0;
        }
    };
    private Runnable biJ = new Runnable() { // from class: com.baidu.live.im.c.a.8
        @Override // java.lang.Runnable
        public void run() {
            a.this.biB.Mt();
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.biB = new ALaImMsgView(tbPageContext.getPageActivity());
        this.biB.setPageContext(this.mPageContext);
        this.biB.setNeedTopAlphaShade(true);
        this.biB.setMode(false);
        this.biC = new ALALiveTextView(tbPageContext.getPageActivity(), tbPageContext);
        this.biC.setMsHandler(this.biI);
        this.biC.setBdPageContext(tbPageContext);
        this.biD = new ArrayList();
        this.biE = new ArrayList();
        this.biD.add("allin");
    }

    @Override // com.baidu.live.im.k
    public void setFromMaster(boolean z) {
        this.aRM = z;
        if (this.biB != null) {
            this.biB.setFromMaster(z);
        }
        if (this.biC != null) {
            this.biC.setFromMaster(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.biB != null) {
            boolean W = this.biB.W(list);
            this.biB.setMsgData(list);
            if (W) {
                this.biB.Ms();
                if (z) {
                    this.biB.postDelayed(new Runnable() { // from class: com.baidu.live.im.c.a.6
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.biB.KO();
                        }
                    }, 200L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(com.baidu.live.im.data.a aVar) {
        String str;
        JSONObject jSONObject;
        if (aVar.getMsgType() == 13 || aVar.getMsgType() == 12) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                str = jSONObject.optString("content_type");
                try {
                    jSONObject.optString("text");
                } catch (JSONException e) {
                }
            } catch (JSONException e2) {
                str = null;
            }
            if ("enter_live".equals(str) && com.baidu.live.entereffect.a.Et().h(aVar)) {
                this.biB.w(aVar);
            }
        }
    }

    @Override // com.baidu.live.im.k
    public j KP() {
        return this.biB;
    }

    @Override // com.baidu.live.im.k
    public com.baidu.live.view.input.a KQ() {
        return this.biC;
    }

    @Override // com.baidu.live.im.k
    public void setLogData(String str, String str2) {
        if (this.biC != null) {
            this.biC.setLogData(str, str2);
        }
        if (this.biB != null) {
            this.biB.setLogData(str, str2);
        }
    }

    @Override // com.baidu.live.im.k
    public void b(String str, String str2, String str3, String str4, String str5, boolean z) {
        MessageManager.getInstance().registerListener(this.bgj);
        MessageManager.getInstance().registerListener(this.bgk);
        MessageManager.getInstance().registerListener(this.biG);
        MessageManager.getInstance().registerListener(this.biH);
        this.biB.JY();
        this.biB.b(str, str4, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str3), str3);
        this.biB.Mt();
        e(str4, str3, z);
        MessageManager.getInstance().registerListener(this.biC.bkb);
        MessageManager.getInstance().registerListener(this.biC.bbC);
    }

    @Override // com.baidu.live.im.k
    public void Cn() {
        MessageManager.getInstance().unRegisterListener(this.bgj);
        MessageManager.getInstance().unRegisterListener(this.bgk);
        MessageManager.getInstance().unRegisterListener(this.biG);
        MessageManager.getInstance().unRegisterListener(this.biH);
        if (this.biB != null) {
            this.biB.Mc();
        }
        if (this.biC != null) {
            this.biC.Mm();
            MessageManager.getInstance().unRegisterListener(this.biC.bkb);
            MessageManager.getInstance().unRegisterListener(this.biC.bbC);
        }
        LiveTimerManager.getInstance().removeLiveTimerTask("live_show_tag_view", true);
        SafeHandler.getInst().removeCallbacks(this.biJ);
    }

    @Override // com.baidu.live.im.k
    public void g(Map<String, Integer> map) {
        if (this.biC != null) {
            this.biC.g(map);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(k.a aVar) {
        this.biF = aVar;
    }

    @Override // com.baidu.live.im.k
    public void a(boolean z, int i, int i2, String str) {
        if (this.biC != null) {
            this.biC.b(z, i, i2, str);
        }
    }

    @Override // com.baidu.live.im.k
    public void onDestroy() {
        a((k.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(List<com.baidu.live.im.data.a> list) {
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            if (this.aRM) {
                if (ListUtils.isEmpty(this.biD)) {
                    return;
                }
            } else if (ListUtils.isEmpty(this.biE)) {
                return;
            }
            for (com.baidu.live.im.data.a aVar : list) {
                if (aVar != null && (aVar.getMsgType() == 13 || aVar.getMsgType() == 26 || aVar.getMsgType() == 27 || aVar.getMsgType() == 12)) {
                    if (this.aRM) {
                        if (this.biD.contains(u(aVar))) {
                            arrayList.add(aVar);
                        }
                    } else if (this.biE.contains(u(aVar))) {
                        arrayList.add(aVar);
                    }
                }
            }
            list.removeAll(arrayList);
        }
    }

    private String u(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        try {
            if (aVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) aVar.getObjContent();
            } else {
                jSONObject = new JSONObject(aVar.getContent());
            }
            return jSONObject.optString("content_type");
        } catch (JSONException e) {
            return null;
        }
    }

    private void e(final String str, final String str2, boolean z) {
        if (ah.DX() && z && UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) != 2) {
            LiveTimerManager.getInstance().addLiveTimerTask("live_show_tag_view", Long.valueOf(str).longValue(), new OnLiveTimerListener() { // from class: com.baidu.live.im.c.a.7
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z2) {
                    if (UtilHelper.getRealScreenOrientation(a.this.mPageContext.getPageActivity()) != 2) {
                        a.this.biB.ay(str, str2);
                        SafeHandler.getInst().postDelayed(a.this.biJ, 10000L);
                    }
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, ah.DY() * 1000, true);
        }
    }

    @Override // com.baidu.live.im.k
    public int getImMsgListViewTop() {
        return this.biB.getImMsgListViewTop();
    }

    @Override // com.baidu.live.im.k
    public int getImMsgListViewHeight() {
        return this.biB.getImMsgListViewHeight();
    }

    @Override // com.baidu.live.im.k
    public int KR() {
        return this.biB.getWidth();
    }
}
