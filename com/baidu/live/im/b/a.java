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
    private final ALaImMsgView ato;
    private final ALALiveTextView atp;
    private List<String> atq;
    private List<String> atr;
    private i.a ats;
    private TbPageContext mPageContext;
    private boolean afH = false;
    private CustomMessageListener arJ = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.b.a.1
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
    private CustomMessageListener arK = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.b.a.2
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
    private CustomMessageListener att = new CustomMessageListener(2913044) { // from class: com.baidu.live.im.b.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener atu = new CustomMessageListener(2913095) { // from class: com.baidu.live.im.b.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.atp != null) {
                    a.this.atp.dQ(str);
                }
            }
        }
    };
    private final a.InterfaceC0104a atv = new a.InterfaceC0104a() { // from class: com.baidu.live.im.b.a.5
        @Override // com.baidu.live.view.input.a.InterfaceC0104a
        public boolean ws() {
            return a.this.ats != null && a.this.ats.ws();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0104a
        public void j(String str, boolean z) {
            bb barrageInfo;
            if (a.this.ats != null) {
                if (a.this.ats.ws()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (a.this.atp != null && a.this.atp.xP() && (barrageInfo = a.this.atp.getBarrageInfo()) != null) {
                        if (barrageInfo.type == 16 && !a.this.ats.ww()) {
                            BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.i.sdk_throne_disabled_alert);
                            return;
                        }
                        imSendMsgData.msgType = (short) 126;
                        imSendMsgData.barrageType = barrageInfo.type;
                        imSendMsgData.barrageId = barrageInfo.id;
                        imSendMsgData.price = barrageInfo.price;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
                    if (!z && a.this.atp != null) {
                        a.this.atp.xS();
                    }
                } else if (!z) {
                    a.this.ats.wt();
                }
                if (z) {
                    a.this.ats.dM(str);
                }
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0104a
        public void wu() {
            if (a.this.ats != null) {
                a.this.ats.wu();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0104a
        public void wv() {
            if (a.this.ats != null) {
                a.this.ats.wv();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0104a
        public boolean ww() {
            return a.this.ats != null && a.this.ats.ww();
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.ato = new ALaImMsgView(tbPageContext.getPageActivity());
        this.ato.setPageContext(this.mPageContext);
        this.ato.setNeedTopAlphaShade(true);
        this.ato.setMode(false);
        this.atp = new ALALiveTextView(tbPageContext.getPageActivity());
        this.atp.setMsHandler(this.atv);
        this.atq = new ArrayList();
        this.atr = new ArrayList();
        this.atq.add("allin");
    }

    @Override // com.baidu.live.im.i
    public void setFromMaster(boolean z) {
        this.afH = z;
        if (this.ato != null) {
            this.ato.setFromMaster(z);
        }
        if (this.atp != null) {
            this.atp.setFromMaster(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.ato != null) {
            boolean G = this.ato.G(list);
            this.ato.setMsgData(list);
            if (G) {
                this.ato.xX();
                if (z) {
                    this.ato.wp();
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
                this.ato.s(aVar);
            }
        }
    }

    @Override // com.baidu.live.im.i
    public h wq() {
        return this.ato;
    }

    @Override // com.baidu.live.im.i
    public com.baidu.live.view.input.a wr() {
        return this.atp;
    }

    @Override // com.baidu.live.im.i
    public void setLogData(String str, String str2) {
        if (this.atp != null) {
            this.atp.setLogData(str, str2);
        }
    }

    @Override // com.baidu.live.im.i
    public void e(String str, String str2, String str3, String str4, String str5) {
        MessageManager.getInstance().registerListener(this.arJ);
        MessageManager.getInstance().registerListener(this.arK);
        MessageManager.getInstance().registerListener(this.att);
        MessageManager.getInstance().registerListener(this.atu);
        this.ato.wL();
        this.ato.a(str, str4, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str3), str3);
    }

    @Override // com.baidu.live.im.i
    public void vW() {
        MessageManager.getInstance().unRegisterListener(this.arJ);
        MessageManager.getInstance().unRegisterListener(this.arK);
        MessageManager.getInstance().unRegisterListener(this.att);
        MessageManager.getInstance().unRegisterListener(this.atu);
        if (this.ato != null) {
            this.ato.xL();
        }
        if (this.atp != null) {
            this.atp.xS();
        }
    }

    @Override // com.baidu.live.im.i
    public void h(Map<String, Integer> map) {
        if (this.atp != null) {
            this.atp.h(map);
        }
    }

    @Override // com.baidu.live.im.i
    public void a(i.a aVar) {
        this.ats = aVar;
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
                if (ListUtils.isEmpty(this.atq)) {
                    return;
                }
            } else if (ListUtils.isEmpty(this.atr)) {
                return;
            }
            for (com.baidu.live.im.data.a aVar : list) {
                if (aVar != null && (aVar.getMsgType() == 13 || aVar.getMsgType() == 26 || aVar.getMsgType() == 27 || aVar.getMsgType() == 12)) {
                    if (this.afH) {
                        if (this.atq.contains(j(aVar))) {
                            arrayList.add(aVar);
                        }
                    } else if (this.atr.contains(j(aVar))) {
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
