package com.baidu.live.im.b;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.bb;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.h;
import com.baidu.live.im.i;
import com.baidu.live.im.view.ALALiveTextView;
import com.baidu.live.im.view.ALaImMsgView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.u.a;
import com.baidu.live.view.input.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements i {
    private final ALaImMsgView atn;
    private final ALALiveTextView ato;
    private List<String> atp;
    private List<String> atq;
    private i.a atr;
    private TbPageContext mPageContext;
    private boolean afH = false;
    private CustomMessageListener arI = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                List list = (List) customResponsedMessage.getData();
                a.this.E(list);
                a.this.d(list, true);
            }
        }
    };
    private CustomMessageListener arJ = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (!a.this.afH && aVar != null && (aVar.xo() instanceof com.baidu.live.data.a)) {
                    aVar.xo().Xk = -1;
                }
                a.this.g(aVar);
            }
        }
    };
    private CustomMessageListener ats = new CustomMessageListener(2913044) { // from class: com.baidu.live.im.b.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener att = new CustomMessageListener(2913095) { // from class: com.baidu.live.im.b.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.ato != null) {
                    a.this.ato.dQ(str);
                }
            }
        }
    };
    private final a.InterfaceC0104a atu = new a.InterfaceC0104a() { // from class: com.baidu.live.im.b.a.5
        @Override // com.baidu.live.view.input.a.InterfaceC0104a
        public boolean ws() {
            return a.this.atr != null && a.this.atr.ws();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0104a
        public void j(String str, boolean z) {
            bb barrageInfo;
            if (a.this.atr != null) {
                if (a.this.atr.ws()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (a.this.ato != null && a.this.ato.xP() && (barrageInfo = a.this.ato.getBarrageInfo()) != null) {
                        if (barrageInfo.type == 16 && !a.this.atr.ww()) {
                            BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.i.sdk_throne_disabled_alert);
                            return;
                        }
                        imSendMsgData.msgType = (short) 126;
                        imSendMsgData.barrageType = barrageInfo.type;
                        imSendMsgData.barrageId = barrageInfo.id;
                        imSendMsgData.price = barrageInfo.price;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
                    if (!z && a.this.ato != null) {
                        a.this.ato.xS();
                    }
                } else if (!z) {
                    a.this.atr.wt();
                }
                if (z) {
                    a.this.atr.dM(str);
                }
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0104a
        public void wu() {
            if (a.this.atr != null) {
                a.this.atr.wu();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0104a
        public void wv() {
            if (a.this.atr != null) {
                a.this.atr.wv();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0104a
        public boolean ww() {
            return a.this.atr != null && a.this.atr.ww();
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.atn = new ALaImMsgView(tbPageContext.getPageActivity());
        this.atn.setPageContext(this.mPageContext);
        this.atn.setNeedTopAlphaShade(true);
        this.atn.setMode(false);
        this.ato = new ALALiveTextView(tbPageContext.getPageActivity());
        this.ato.setMsHandler(this.atu);
        this.atp = new ArrayList();
        this.atq = new ArrayList();
        this.atp.add("allin");
    }

    @Override // com.baidu.live.im.i
    public void setFromMaster(boolean z) {
        this.afH = z;
        if (this.atn != null) {
            this.atn.setFromMaster(z);
        }
        if (this.ato != null) {
            this.ato.setFromMaster(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.atn != null) {
            boolean G = this.atn.G(list);
            this.atn.setMsgData(list);
            if (G) {
                this.atn.xX();
                if (z) {
                    this.atn.wp();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.baidu.live.im.data.a aVar) {
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
            if ("enter_live".equals(str) && com.baidu.live.entereffect.a.qR().a(aVar)) {
                this.atn.s(aVar);
            }
        }
    }

    @Override // com.baidu.live.im.i
    public h wq() {
        return this.atn;
    }

    @Override // com.baidu.live.im.i
    public com.baidu.live.view.input.a wr() {
        return this.ato;
    }

    @Override // com.baidu.live.im.i
    public void setLogData(String str, String str2) {
        if (this.ato != null) {
            this.ato.setLogData(str, str2);
        }
    }

    @Override // com.baidu.live.im.i
    public void e(String str, String str2, String str3, String str4, String str5) {
        MessageManager.getInstance().registerListener(this.arI);
        MessageManager.getInstance().registerListener(this.arJ);
        MessageManager.getInstance().registerListener(this.ats);
        MessageManager.getInstance().registerListener(this.att);
        this.atn.wL();
        this.atn.a(str, str4, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str3), str3);
    }

    @Override // com.baidu.live.im.i
    public void vW() {
        MessageManager.getInstance().unRegisterListener(this.arI);
        MessageManager.getInstance().unRegisterListener(this.arJ);
        MessageManager.getInstance().unRegisterListener(this.ats);
        MessageManager.getInstance().unRegisterListener(this.att);
        if (this.atn != null) {
            this.atn.xL();
        }
        if (this.ato != null) {
            this.ato.xS();
        }
    }

    @Override // com.baidu.live.im.i
    public void h(Map<String, Integer> map) {
        if (this.ato != null) {
            this.ato.h(map);
        }
    }

    @Override // com.baidu.live.im.i
    public void a(i.a aVar) {
        this.atr = aVar;
    }

    @Override // com.baidu.live.im.i
    public void onDestroy() {
        a((i.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(List<com.baidu.live.im.data.a> list) {
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            if (this.afH) {
                if (ListUtils.isEmpty(this.atp)) {
                    return;
                }
            } else if (ListUtils.isEmpty(this.atq)) {
                return;
            }
            for (com.baidu.live.im.data.a aVar : list) {
                if (aVar != null && (aVar.getMsgType() == 13 || aVar.getMsgType() == 26 || aVar.getMsgType() == 27 || aVar.getMsgType() == 12)) {
                    if (this.afH) {
                        if (this.atp.contains(j(aVar))) {
                            arrayList.add(aVar);
                        }
                    } else if (this.atq.contains(j(aVar))) {
                        arrayList.add(aVar);
                    }
                }
            }
            list.removeAll(arrayList);
        }
    }

    private String j(com.baidu.live.im.data.a aVar) {
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
}
