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
    private List<String> atA;
    private List<String> atB;
    private i.a atC;
    private final ALaImMsgView aty;
    private final ALALiveTextView atz;
    private TbPageContext mPageContext;
    private boolean afR = false;
    private CustomMessageListener arT = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.b.a.1
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
    private CustomMessageListener arU = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (!a.this.afR && aVar != null && (aVar.xt() instanceof com.baidu.live.data.a)) {
                    aVar.xt().Xu = -1;
                }
                a.this.g(aVar);
            }
        }
    };
    private CustomMessageListener atD = new CustomMessageListener(2913044) { // from class: com.baidu.live.im.b.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener atE = new CustomMessageListener(2913095) { // from class: com.baidu.live.im.b.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.atz != null) {
                    a.this.atz.dP(str);
                }
            }
        }
    };
    private final a.InterfaceC0104a atF = new a.InterfaceC0104a() { // from class: com.baidu.live.im.b.a.5
        @Override // com.baidu.live.view.input.a.InterfaceC0104a
        public boolean wx() {
            return a.this.atC != null && a.this.atC.wx();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0104a
        public void j(String str, boolean z) {
            bb barrageInfo;
            if (a.this.atC != null) {
                if (a.this.atC.wx()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (a.this.atz != null && a.this.atz.xU() && (barrageInfo = a.this.atz.getBarrageInfo()) != null) {
                        if (barrageInfo.type == 16 && !a.this.atC.wB()) {
                            BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.i.sdk_throne_disabled_alert);
                            return;
                        }
                        imSendMsgData.msgType = (short) 126;
                        imSendMsgData.barrageType = barrageInfo.type;
                        imSendMsgData.barrageId = barrageInfo.id;
                        imSendMsgData.price = barrageInfo.price;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
                    if (!z && a.this.atz != null) {
                        a.this.atz.xX();
                    }
                } else if (!z) {
                    a.this.atC.wy();
                }
                if (z) {
                    a.this.atC.dL(str);
                }
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0104a
        public void wz() {
            if (a.this.atC != null) {
                a.this.atC.wz();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0104a
        public void wA() {
            if (a.this.atC != null) {
                a.this.atC.wA();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0104a
        public boolean wB() {
            return a.this.atC != null && a.this.atC.wB();
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.aty = new ALaImMsgView(tbPageContext.getPageActivity());
        this.aty.setPageContext(this.mPageContext);
        this.aty.setNeedTopAlphaShade(true);
        this.aty.setMode(false);
        this.atz = new ALALiveTextView(tbPageContext.getPageActivity());
        this.atz.setMsHandler(this.atF);
        this.atA = new ArrayList();
        this.atB = new ArrayList();
        this.atA.add("allin");
    }

    @Override // com.baidu.live.im.i
    public void setFromMaster(boolean z) {
        this.afR = z;
        if (this.aty != null) {
            this.aty.setFromMaster(z);
        }
        if (this.atz != null) {
            this.atz.setFromMaster(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.aty != null) {
            boolean G = this.aty.G(list);
            this.aty.setMsgData(list);
            if (G) {
                this.aty.yc();
                if (z) {
                    this.aty.wu();
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
            if ("enter_live".equals(str) && com.baidu.live.entereffect.a.qW().a(aVar)) {
                this.aty.s(aVar);
            }
        }
    }

    @Override // com.baidu.live.im.i
    public h wv() {
        return this.aty;
    }

    @Override // com.baidu.live.im.i
    public com.baidu.live.view.input.a ww() {
        return this.atz;
    }

    @Override // com.baidu.live.im.i
    public void setLogData(String str, String str2) {
        if (this.atz != null) {
            this.atz.setLogData(str, str2);
        }
    }

    @Override // com.baidu.live.im.i
    public void e(String str, String str2, String str3, String str4, String str5) {
        MessageManager.getInstance().registerListener(this.arT);
        MessageManager.getInstance().registerListener(this.arU);
        MessageManager.getInstance().registerListener(this.atD);
        MessageManager.getInstance().registerListener(this.atE);
        this.aty.wQ();
        this.aty.a(str, str4, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str3), str3);
    }

    @Override // com.baidu.live.im.i
    public void wb() {
        MessageManager.getInstance().unRegisterListener(this.arT);
        MessageManager.getInstance().unRegisterListener(this.arU);
        MessageManager.getInstance().unRegisterListener(this.atD);
        MessageManager.getInstance().unRegisterListener(this.atE);
        if (this.aty != null) {
            this.aty.xQ();
        }
        if (this.atz != null) {
            this.atz.xX();
        }
    }

    @Override // com.baidu.live.im.i
    public void h(Map<String, Integer> map) {
        if (this.atz != null) {
            this.atz.h(map);
        }
    }

    @Override // com.baidu.live.im.i
    public void a(i.a aVar) {
        this.atC = aVar;
    }

    @Override // com.baidu.live.im.i
    public void onDestroy() {
        a((i.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(List<com.baidu.live.im.data.a> list) {
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            if (this.afR) {
                if (ListUtils.isEmpty(this.atA)) {
                    return;
                }
            } else if (ListUtils.isEmpty(this.atB)) {
                return;
            }
            for (com.baidu.live.im.data.a aVar : list) {
                if (aVar != null && (aVar.getMsgType() == 13 || aVar.getMsgType() == 26 || aVar.getMsgType() == 27 || aVar.getMsgType() == 12)) {
                    if (this.afR) {
                        if (this.atA.contains(j(aVar))) {
                            arrayList.add(aVar);
                        }
                    } else if (this.atB.contains(j(aVar))) {
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
