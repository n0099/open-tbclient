package com.baidu.live.im.b;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.az;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.h;
import com.baidu.live.im.i;
import com.baidu.live.im.view.ALALiveTextView;
import com.baidu.live.im.view.ALaImMsgView;
import com.baidu.live.r.a;
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
    private final ALaImMsgView apV;
    private final ALALiveTextView apW;
    private List<String> apX;
    private List<String> apY;
    private i.a apZ;
    private TbPageContext mPageContext;
    private boolean adF = false;
    private CustomMessageListener aoq = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.b.a.1
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
    private CustomMessageListener aor = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (!a.this.adF && aVar != null && (aVar.vq() instanceof com.baidu.live.data.a)) {
                    aVar.vq().VE = -1;
                }
                a.this.g(aVar);
            }
        }
    };
    private CustomMessageListener aqa = new CustomMessageListener(2913044) { // from class: com.baidu.live.im.b.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener aqb = new CustomMessageListener(2913095) { // from class: com.baidu.live.im.b.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.apW != null) {
                    a.this.apW.dF(str);
                }
            }
        }
    };
    private final a.InterfaceC0098a aqc = new a.InterfaceC0098a() { // from class: com.baidu.live.im.b.a.5
        @Override // com.baidu.live.view.input.a.InterfaceC0098a
        public boolean uO() {
            return a.this.apZ != null && a.this.apZ.uO();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0098a
        public void j(String str, boolean z) {
            az barrageInfo;
            if (a.this.apZ != null) {
                if (a.this.apZ.uO()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (a.this.apW != null && a.this.apW.vQ() && (barrageInfo = a.this.apW.getBarrageInfo()) != null) {
                        if (barrageInfo.type == 16 && !a.this.apZ.uS()) {
                            BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.i.sdk_throne_disabled_alert);
                            return;
                        }
                        imSendMsgData.msgType = (short) 126;
                        imSendMsgData.barrageType = barrageInfo.type;
                        imSendMsgData.barrageId = barrageInfo.id;
                        imSendMsgData.price = barrageInfo.price;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
                    if (!z && a.this.apW != null) {
                        a.this.apW.vT();
                    }
                } else if (!z) {
                    a.this.apZ.uP();
                }
                if (z) {
                    a.this.apZ.dB(str);
                }
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0098a
        public void uQ() {
            if (a.this.apZ != null) {
                a.this.apZ.uQ();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0098a
        public void uR() {
            if (a.this.apZ != null) {
                a.this.apZ.uR();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0098a
        public boolean uS() {
            return a.this.apZ != null && a.this.apZ.uS();
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.apV = new ALaImMsgView(tbPageContext.getPageActivity());
        this.apV.setPageContext(this.mPageContext);
        this.apV.setNeedTopAlphaShade(true);
        this.apV.setMode(false);
        this.apW = new ALALiveTextView(tbPageContext.getPageActivity());
        this.apW.setMsHandler(this.aqc);
        this.apX = new ArrayList();
        this.apY = new ArrayList();
        this.apX.add("allin");
    }

    @Override // com.baidu.live.im.i
    public void setFromMaster(boolean z) {
        this.adF = z;
        if (this.apV != null) {
            this.apV.setFromMaster(z);
        }
        if (this.apW != null) {
            this.apW.setFromMaster(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.apV != null) {
            boolean G = this.apV.G(list);
            this.apV.setMsgData(list);
            if (G) {
                this.apV.vZ();
                if (z) {
                    this.apV.uL();
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
            if ("enter_live".equals(str) && com.baidu.live.entereffect.a.qg().a(aVar)) {
                this.apV.l(aVar);
            }
        }
    }

    @Override // com.baidu.live.im.i
    public h uM() {
        return this.apV;
    }

    @Override // com.baidu.live.im.i
    public com.baidu.live.view.input.a uN() {
        return this.apW;
    }

    @Override // com.baidu.live.im.i
    public void setLogData(String str, String str2) {
        if (this.apW != null) {
            this.apW.setLogData(str, str2);
        }
    }

    @Override // com.baidu.live.im.i
    public void e(String str, String str2, String str3, String str4, String str5) {
        MessageManager.getInstance().registerListener(this.aoq);
        MessageManager.getInstance().registerListener(this.aor);
        MessageManager.getInstance().registerListener(this.aqa);
        MessageManager.getInstance().registerListener(this.aqb);
        this.apV.vh();
        this.apV.a(str, str4, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str3), str3);
    }

    @Override // com.baidu.live.im.i
    public void us() {
        MessageManager.getInstance().unRegisterListener(this.aoq);
        MessageManager.getInstance().unRegisterListener(this.aor);
        MessageManager.getInstance().unRegisterListener(this.aqa);
        MessageManager.getInstance().unRegisterListener(this.aqb);
        if (this.apV != null) {
            this.apV.vM();
        }
    }

    @Override // com.baidu.live.im.i
    public void h(Map<String, Integer> map) {
        if (this.apW != null) {
            this.apW.h(map);
        }
    }

    @Override // com.baidu.live.im.i
    public void a(i.a aVar) {
        this.apZ = aVar;
    }

    @Override // com.baidu.live.im.i
    public void onDestroy() {
        a((i.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(List<com.baidu.live.im.data.a> list) {
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            if (this.adF) {
                if (ListUtils.isEmpty(this.apX)) {
                    return;
                }
            } else if (ListUtils.isEmpty(this.apY)) {
                return;
            }
            for (com.baidu.live.im.data.a aVar : list) {
                if (aVar != null && (aVar.getMsgType() == 13 || aVar.getMsgType() == 26 || aVar.getMsgType() == 27 || aVar.getMsgType() == 12)) {
                    if (this.adF) {
                        if (this.apX.contains(j(aVar))) {
                            arrayList.add(aVar);
                        }
                    } else if (this.apY.contains(j(aVar))) {
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
