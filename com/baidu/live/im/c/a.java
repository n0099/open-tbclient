package com.baidu.live.im.c;

import android.util.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.aa;
import com.baidu.live.data.bp;
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
    private final ALaImMsgView aWN;
    private final ALALiveTextView aWO;
    private List<String> aWP;
    private List<String> aWQ;
    private k.a aWR;
    private TbPageContext mPageContext;
    private boolean aHx = false;
    private CustomMessageListener aUJ = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                List list = (List) customResponsedMessage.getData();
                a.this.O(list);
                a.this.d(list, true);
            }
        }
    };
    private CustomMessageListener aUK = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.c.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (!a.this.aHx && aVar != null && (aVar.Eh() instanceof com.baidu.live.data.a)) {
                    aVar.Eh().axP = -1;
                }
                a.this.r(aVar);
            }
        }
    };
    private CustomMessageListener aWS = new CustomMessageListener(2913044) { // from class: com.baidu.live.im.c.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener aWT = new CustomMessageListener(2913095) { // from class: com.baidu.live.im.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.aWO != null) {
                    a.this.aWO.fy(str);
                }
            }
        }
    };
    private final a.InterfaceC0192a aWU = new a.InterfaceC0192a() { // from class: com.baidu.live.im.c.a.5
        @Override // com.baidu.live.view.input.a.InterfaceC0192a
        public boolean DF() {
            return a.this.aWR != null && a.this.aWR.DF();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0192a
        public void r(String str, boolean z) {
            Log.i("i", "@@@ localText nmpanctr sdhdl 1");
            if (a.this.aWR != null) {
                if (a.this.aWR.DF()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (a.this.aWO != null && a.this.aWO.ER()) {
                        bp barrageInfo = a.this.aWO.getBarrageInfo();
                        if (barrageInfo != null) {
                            if (barrageInfo.type == 16 && !a.this.aWR.DJ()) {
                                BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.i.sdk_throne_disabled_alert);
                                return;
                            } else if (barrageInfo.type == 17 && barrageInfo.aFH > a.this.aWR.DK()) {
                                if (barrageInfo.aFH == 7) {
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
                    if (!z && a.this.aWO != null) {
                        a.this.aWO.EV();
                    }
                } else if (!z) {
                    Log.i("i", "@@@ localText nmpanctr sdhdl nolg");
                    a.this.aWR.DG();
                }
                if (z) {
                    a.this.aWR.fv(str);
                }
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0192a
        public void DH() {
            if (a.this.aWR != null) {
                a.this.aWR.DH();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0192a
        public void DI() {
            if (a.this.aWR != null) {
                a.this.aWR.DI();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0192a
        public boolean DJ() {
            return a.this.aWR != null && a.this.aWR.DJ();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0192a
        public int DK() {
            if (a.this.aWR != null) {
                return a.this.aWR.DK();
            }
            return 0;
        }
    };
    private Runnable aWV = new Runnable() { // from class: com.baidu.live.im.c.a.8
        @Override // java.lang.Runnable
        public void run() {
            a.this.aWN.Fc();
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.aWN = new ALaImMsgView(tbPageContext.getPageActivity());
        this.aWN.setPageContext(this.mPageContext);
        this.aWN.setNeedTopAlphaShade(true);
        this.aWN.setMode(false);
        this.aWO = new ALALiveTextView(tbPageContext.getPageActivity(), tbPageContext);
        this.aWO.setMsHandler(this.aWU);
        this.aWO.setBdPageContext(tbPageContext);
        this.aWP = new ArrayList();
        this.aWQ = new ArrayList();
        this.aWP.add("allin");
    }

    @Override // com.baidu.live.im.k
    public void setFromMaster(boolean z) {
        this.aHx = z;
        if (this.aWN != null) {
            this.aWN.setFromMaster(z);
        }
        if (this.aWO != null) {
            this.aWO.setFromMaster(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.aWN != null) {
            boolean Q = this.aWN.Q(list);
            this.aWN.setMsgData(list);
            if (Q) {
                this.aWN.Fb();
                if (z) {
                    this.aWN.postDelayed(new Runnable() { // from class: com.baidu.live.im.c.a.6
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.aWN.DB();
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
            if ("enter_live".equals(str) && com.baidu.live.entereffect.a.xD().h(aVar)) {
                this.aWN.w(aVar);
            }
        }
    }

    @Override // com.baidu.live.im.k
    public j DC() {
        return this.aWN;
    }

    @Override // com.baidu.live.im.k
    public com.baidu.live.view.input.a DD() {
        return this.aWO;
    }

    @Override // com.baidu.live.im.k
    public void setLogData(String str, String str2) {
        if (this.aWO != null) {
            this.aWO.setLogData(str, str2);
        }
        if (this.aWN != null) {
            this.aWN.setLogData(str, str2);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(String str, String str2, String str3, String str4, String str5, boolean z) {
        MessageManager.getInstance().registerListener(this.aUJ);
        MessageManager.getInstance().registerListener(this.aUK);
        MessageManager.getInstance().registerListener(this.aWS);
        MessageManager.getInstance().registerListener(this.aWT);
        this.aWN.DR();
        this.aWN.a(str, str4, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str3), str3);
        e(str4, str3, z);
        MessageManager.getInstance().registerListener(this.aWO.aYd);
        MessageManager.getInstance().registerListener(this.aWO.aQz);
    }

    @Override // com.baidu.live.im.k
    public void vD() {
        MessageManager.getInstance().unRegisterListener(this.aUJ);
        MessageManager.getInstance().unRegisterListener(this.aUK);
        MessageManager.getInstance().unRegisterListener(this.aWS);
        MessageManager.getInstance().unRegisterListener(this.aWT);
        if (this.aWN != null) {
            this.aWN.EL();
        }
        if (this.aWO != null) {
            this.aWO.EV();
            MessageManager.getInstance().unRegisterListener(this.aWO.aYd);
            MessageManager.getInstance().unRegisterListener(this.aWO.aQz);
        }
        LiveTimerManager.getInstance().removeLiveTimerTask("live_show_tag_view", true);
        SafeHandler.getInst().removeCallbacks(this.aWV);
    }

    @Override // com.baidu.live.im.k
    public void g(Map<String, Integer> map) {
        if (this.aWO != null) {
            this.aWO.g(map);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(k.a aVar) {
        this.aWR = aVar;
    }

    @Override // com.baidu.live.im.k
    public void a(boolean z, int i, int i2, String str) {
        if (this.aWO != null) {
            this.aWO.b(z, i, i2, str);
        }
    }

    @Override // com.baidu.live.im.k
    public void onDestroy() {
        a((k.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(List<com.baidu.live.im.data.a> list) {
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            if (this.aHx) {
                if (ListUtils.isEmpty(this.aWP)) {
                    return;
                }
            } else if (ListUtils.isEmpty(this.aWQ)) {
                return;
            }
            for (com.baidu.live.im.data.a aVar : list) {
                if (aVar != null && (aVar.getMsgType() == 13 || aVar.getMsgType() == 26 || aVar.getMsgType() == 27 || aVar.getMsgType() == 12)) {
                    if (this.aHx) {
                        if (this.aWP.contains(u(aVar))) {
                            arrayList.add(aVar);
                        }
                    } else if (this.aWQ.contains(u(aVar))) {
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
        if (aa.xh() && z && UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) != 2) {
            LiveTimerManager.getInstance().addLiveTimerTask("live_show_tag_view", Long.valueOf(str).longValue(), new OnLiveTimerListener() { // from class: com.baidu.live.im.c.a.7
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z2) {
                    if (UtilHelper.getRealScreenOrientation(a.this.mPageContext.getPageActivity()) != 2) {
                        a.this.aWN.ar(str, str2);
                        SafeHandler.getInst().postDelayed(a.this.aWV, 10000L);
                    }
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, aa.xi() * 1000, true);
        }
    }

    @Override // com.baidu.live.im.k
    public int getImMsgListViewTop() {
        return this.aWN.getImMsgListViewTop();
    }

    @Override // com.baidu.live.im.k
    public int getImMsgListViewHeight() {
        return this.aWN.getImMsgListViewHeight();
    }

    @Override // com.baidu.live.im.k
    public int DE() {
        return this.aWN.getWidth();
    }
}
