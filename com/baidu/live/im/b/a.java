package com.baidu.live.im.b;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.av;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.h;
import com.baidu.live.im.i;
import com.baidu.live.im.view.ALALiveTextView;
import com.baidu.live.im.view.ALaImMsgView;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.view.input.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements i {
    private final ALaImMsgView api;
    private final ALALiveTextView apj;
    private List<String> apk;
    private List<String> apl;
    private i.a apm;
    private TbPageContext mPageContext;
    private boolean adq = false;
    private CustomMessageListener anD = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                List list = (List) customResponsedMessage.getData();
                a.this.F(list);
                a.this.c(list, true);
            }
        }
    };
    private CustomMessageListener anE = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (!a.this.adq && aVar != null && (aVar.uZ() instanceof com.baidu.live.data.a)) {
                    aVar.uZ().Vo = -1;
                }
                a.this.g(aVar);
            }
        }
    };
    private CustomMessageListener apn = new CustomMessageListener(2913044) { // from class: com.baidu.live.im.b.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener apo = new CustomMessageListener(2913095) { // from class: com.baidu.live.im.b.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.apj != null) {
                    a.this.apj.dD(str);
                }
            }
        }
    };
    private final a.InterfaceC0097a apq = new a.InterfaceC0097a() { // from class: com.baidu.live.im.b.a.5
        @Override // com.baidu.live.view.input.a.InterfaceC0097a
        public boolean ux() {
            return a.this.apm != null && a.this.apm.ux();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0097a
        public void j(String str, boolean z) {
            av barrageInfo;
            if (a.this.apm != null) {
                if (a.this.apm.ux()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (a.this.apj != null && a.this.apj.vz() && (barrageInfo = a.this.apj.getBarrageInfo()) != null) {
                        if (barrageInfo.type == 16 && !a.this.apm.uB()) {
                            BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.i.sdk_throne_disabled_alert);
                            return;
                        }
                        imSendMsgData.msgType = (short) 126;
                        imSendMsgData.barrageType = barrageInfo.type;
                        imSendMsgData.barrageId = barrageInfo.id;
                        imSendMsgData.price = barrageInfo.price;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
                    if (!z && a.this.apj != null) {
                        a.this.apj.vC();
                    }
                } else if (!z) {
                    a.this.apm.uy();
                }
                if (z) {
                    a.this.apm.dz(str);
                }
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0097a
        public void uz() {
            if (a.this.apm != null) {
                a.this.apm.uz();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0097a
        public void uA() {
            if (a.this.apm != null) {
                a.this.apm.uA();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0097a
        public boolean uB() {
            return a.this.apm != null && a.this.apm.uB();
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.api = new ALaImMsgView(tbPageContext.getPageActivity());
        this.api.setPageContext(this.mPageContext);
        this.api.setNeedTopAlphaShade(true);
        this.api.setMode(false);
        this.apj = new ALALiveTextView(tbPageContext.getPageActivity());
        this.apj.setMsHandler(this.apq);
        this.apk = new ArrayList();
        this.apl = new ArrayList();
        this.apk.add("allin");
    }

    @Override // com.baidu.live.im.i
    public void setFromMaster(boolean z) {
        this.adq = z;
        if (this.api != null) {
            this.api.setFromMaster(z);
        }
        if (this.apj != null) {
            this.apj.setFromMaster(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.api != null) {
            boolean H = this.api.H(list);
            this.api.setMsgData(list);
            if (H) {
                this.api.vI();
                if (z) {
                    this.api.uu();
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
            if ("enter_live".equals(str) && com.baidu.live.entereffect.a.pZ().a(aVar)) {
                this.api.l(aVar);
            }
        }
    }

    @Override // com.baidu.live.im.i
    public h uv() {
        return this.api;
    }

    @Override // com.baidu.live.im.i
    public com.baidu.live.view.input.a uw() {
        return this.apj;
    }

    @Override // com.baidu.live.im.i
    public void setLogData(String str, String str2) {
        if (this.apj != null) {
            this.apj.setLogData(str, str2);
        }
    }

    @Override // com.baidu.live.im.i
    public void e(String str, String str2, String str3, String str4, String str5) {
        MessageManager.getInstance().registerListener(this.anD);
        MessageManager.getInstance().registerListener(this.anE);
        MessageManager.getInstance().registerListener(this.apn);
        MessageManager.getInstance().registerListener(this.apo);
        this.api.uQ();
        this.api.a(str, str4, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str3), str3);
    }

    @Override // com.baidu.live.im.i
    public void ub() {
        MessageManager.getInstance().unRegisterListener(this.anD);
        MessageManager.getInstance().unRegisterListener(this.anE);
        MessageManager.getInstance().unRegisterListener(this.apn);
        MessageManager.getInstance().unRegisterListener(this.apo);
        if (this.api != null) {
            this.api.vv();
        }
    }

    @Override // com.baidu.live.im.i
    public void h(Map<String, Integer> map) {
        if (this.apj != null) {
            this.apj.h(map);
        }
    }

    @Override // com.baidu.live.im.i
    public void a(i.a aVar) {
        this.apm = aVar;
    }

    @Override // com.baidu.live.im.i
    public void onDestroy() {
        a((i.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(List<com.baidu.live.im.data.a> list) {
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            if (this.adq) {
                if (ListUtils.isEmpty(this.apk)) {
                    return;
                }
            } else if (ListUtils.isEmpty(this.apl)) {
                return;
            }
            for (com.baidu.live.im.data.a aVar : list) {
                if (aVar != null && (aVar.getMsgType() == 13 || aVar.getMsgType() == 26 || aVar.getMsgType() == 27 || aVar.getMsgType() == 12)) {
                    if (this.adq) {
                        if (this.apk.contains(j(aVar))) {
                            arrayList.add(aVar);
                        }
                    } else if (this.apl.contains(j(aVar))) {
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
