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
    private final ALaImMsgView beO;
    private final ALALiveTextView beP;
    private List<String> beQ;
    private List<String> beR;
    private k.a beS;
    private TbPageContext mPageContext;
    private boolean aOB = false;
    private CustomMessageListener bcx = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                List list = (List) customResponsedMessage.getData();
                a.this.S(list);
                a.this.d(list, true);
            }
        }
    };
    private CustomMessageListener bcy = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.c.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (!a.this.aOB && aVar != null && (aVar.Ko() instanceof com.baidu.live.data.a)) {
                    aVar.Ko().aDD = -1;
                }
                a.this.r(aVar);
            }
        }
    };
    private CustomMessageListener beT = new CustomMessageListener(2913044) { // from class: com.baidu.live.im.c.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener beU = new CustomMessageListener(2913095) { // from class: com.baidu.live.im.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.beP != null) {
                    a.this.beP.hh(str);
                }
            }
        }
    };
    private final a.InterfaceC0199a beV = new a.InterfaceC0199a() { // from class: com.baidu.live.im.c.a.5
        @Override // com.baidu.live.view.input.a.InterfaceC0199a
        public boolean JM() {
            return a.this.beS != null && a.this.beS.JM();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0199a
        public void r(String str, boolean z) {
            Log.i("i", "@@@ localText nmpanctr sdhdl 1");
            if (a.this.beS != null) {
                if (a.this.beS.JM()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (a.this.beP != null && a.this.beP.Ld()) {
                        bz barrageInfo = a.this.beP.getBarrageInfo();
                        if (barrageInfo != null) {
                            if (barrageInfo.type == 16 && !a.this.beS.JQ()) {
                                BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.i.sdk_throne_disabled_alert);
                                return;
                            } else if (barrageInfo.type == 17 && barrageInfo.aMA > a.this.beS.JR()) {
                                if (barrageInfo.aMA == 7) {
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
                    if (!z && a.this.beP != null) {
                        a.this.beP.Lh();
                    }
                } else if (!z) {
                    Log.i("i", "@@@ localText nmpanctr sdhdl nolg");
                    a.this.beS.JN();
                }
                if (z) {
                    a.this.beS.hd(str);
                }
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0199a
        public void JO() {
            if (a.this.beS != null) {
                a.this.beS.JO();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0199a
        public void JP() {
            if (a.this.beS != null) {
                a.this.beS.JP();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0199a
        public boolean JQ() {
            return a.this.beS != null && a.this.beS.JQ();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0199a
        public int JR() {
            if (a.this.beS != null) {
                return a.this.beS.JR();
            }
            return 0;
        }
    };
    private Runnable beW = new Runnable() { // from class: com.baidu.live.im.c.a.8
        @Override // java.lang.Runnable
        public void run() {
            a.this.beO.Lo();
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.beO = new ALaImMsgView(tbPageContext.getPageActivity());
        this.beO.setPageContext(this.mPageContext);
        this.beO.setNeedTopAlphaShade(true);
        this.beO.setMode(false);
        this.beP = new ALALiveTextView(tbPageContext.getPageActivity(), tbPageContext);
        this.beP.setMsHandler(this.beV);
        this.beP.setBdPageContext(tbPageContext);
        this.beQ = new ArrayList();
        this.beR = new ArrayList();
        this.beQ.add("allin");
    }

    @Override // com.baidu.live.im.k
    public void setFromMaster(boolean z) {
        this.aOB = z;
        if (this.beO != null) {
            this.beO.setFromMaster(z);
        }
        if (this.beP != null) {
            this.beP.setFromMaster(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.beO != null) {
            boolean U = this.beO.U(list);
            this.beO.setMsgData(list);
            if (U) {
                this.beO.Ln();
                if (z) {
                    this.beO.postDelayed(new Runnable() { // from class: com.baidu.live.im.c.a.6
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.beO.JI();
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
            if ("enter_live".equals(str) && com.baidu.live.entereffect.a.Dw().h(aVar)) {
                this.beO.w(aVar);
            }
        }
    }

    @Override // com.baidu.live.im.k
    public j JJ() {
        return this.beO;
    }

    @Override // com.baidu.live.im.k
    public com.baidu.live.view.input.a JK() {
        return this.beP;
    }

    @Override // com.baidu.live.im.k
    public void setLogData(String str, String str2) {
        if (this.beP != null) {
            this.beP.setLogData(str, str2);
        }
        if (this.beO != null) {
            this.beO.setLogData(str, str2);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(String str, String str2, String str3, String str4, String str5, boolean z) {
        MessageManager.getInstance().registerListener(this.bcx);
        MessageManager.getInstance().registerListener(this.bcy);
        MessageManager.getInstance().registerListener(this.beT);
        MessageManager.getInstance().registerListener(this.beU);
        this.beO.JY();
        this.beO.b(str, str4, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str3), str3);
        this.beO.Lo();
        e(str4, str3, z);
        MessageManager.getInstance().registerListener(this.beP.bgl);
        MessageManager.getInstance().registerListener(this.beP.aYi);
    }

    @Override // com.baidu.live.im.k
    public void Bq() {
        MessageManager.getInstance().unRegisterListener(this.bcx);
        MessageManager.getInstance().unRegisterListener(this.bcy);
        MessageManager.getInstance().unRegisterListener(this.beT);
        MessageManager.getInstance().unRegisterListener(this.beU);
        if (this.beO != null) {
            this.beO.KX();
        }
        if (this.beP != null) {
            this.beP.Lh();
            MessageManager.getInstance().unRegisterListener(this.beP.bgl);
            MessageManager.getInstance().unRegisterListener(this.beP.aYi);
        }
        LiveTimerManager.getInstance().removeLiveTimerTask("live_show_tag_view", true);
        SafeHandler.getInst().removeCallbacks(this.beW);
    }

    @Override // com.baidu.live.im.k
    public void g(Map<String, Integer> map) {
        if (this.beP != null) {
            this.beP.g(map);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(k.a aVar) {
        this.beS = aVar;
    }

    @Override // com.baidu.live.im.k
    public void a(boolean z, int i, int i2, String str) {
        if (this.beP != null) {
            this.beP.b(z, i, i2, str);
        }
    }

    @Override // com.baidu.live.im.k
    public void onDestroy() {
        a((k.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(List<com.baidu.live.im.data.a> list) {
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            if (this.aOB) {
                if (ListUtils.isEmpty(this.beQ)) {
                    return;
                }
            } else if (ListUtils.isEmpty(this.beR)) {
                return;
            }
            for (com.baidu.live.im.data.a aVar : list) {
                if (aVar != null && (aVar.getMsgType() == 13 || aVar.getMsgType() == 26 || aVar.getMsgType() == 27 || aVar.getMsgType() == 12)) {
                    if (this.aOB) {
                        if (this.beQ.contains(u(aVar))) {
                            arrayList.add(aVar);
                        }
                    } else if (this.beR.contains(u(aVar))) {
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
        if (ah.Da() && z && UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) != 2) {
            LiveTimerManager.getInstance().addLiveTimerTask("live_show_tag_view", Long.valueOf(str).longValue(), new OnLiveTimerListener() { // from class: com.baidu.live.im.c.a.7
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z2) {
                    if (UtilHelper.getRealScreenOrientation(a.this.mPageContext.getPageActivity()) != 2) {
                        a.this.beO.av(str, str2);
                        SafeHandler.getInst().postDelayed(a.this.beW, 10000L);
                    }
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, ah.Db() * 1000, true);
        }
    }

    @Override // com.baidu.live.im.k
    public int getImMsgListViewTop() {
        return this.beO.getImMsgListViewTop();
    }

    @Override // com.baidu.live.im.k
    public int getImMsgListViewHeight() {
        return this.beO.getImMsgListViewHeight();
    }

    @Override // com.baidu.live.im.k
    public int JL() {
        return this.beO.getWidth();
    }
}
