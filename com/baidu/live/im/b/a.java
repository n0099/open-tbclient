package com.baidu.live.im.b;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.ao;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.h;
import com.baidu.live.im.i;
import com.baidu.live.im.view.ALALiveTextView;
import com.baidu.live.im.view.ALaImMsgView;
import com.baidu.live.l.d;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.view.input.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a implements i {
    private List<String> ahA;
    private i.a ahB;
    private final ALaImMsgView ahx;
    private final ALALiveTextView ahy;
    private List<String> ahz;
    private TbPageContext mPageContext;
    private boolean Wi = false;
    private CustomMessageListener afT = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                List list = (List) customResponsedMessage.getData();
                a.this.H(list);
                a.this.d(list, true);
            }
        }
    };
    private CustomMessageListener afU = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (!a.this.Wi && aVar != null && (aVar.te() instanceof com.baidu.live.data.a)) {
                    aVar.te().OQ = -1;
                }
                a.this.f(aVar);
            }
        }
    };
    private CustomMessageListener ahC = new CustomMessageListener(2913044) { // from class: com.baidu.live.im.b.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener ahD = new CustomMessageListener(2913095) { // from class: com.baidu.live.im.b.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.ahy != null) {
                    a.this.ahy.cM(str);
                }
            }
        }
    };
    private final a.InterfaceC0080a ahE = new a.InterfaceC0080a() { // from class: com.baidu.live.im.b.a.5
        @Override // com.baidu.live.view.input.a.InterfaceC0080a
        public boolean sF() {
            return a.this.ahB != null && a.this.ahB.sF();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0080a
        public void g(String str, boolean z) {
            ao barrageInfo;
            if (a.this.ahB != null) {
                if (a.this.ahB.sF()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (a.this.ahy != null && a.this.ahy.tE() && (barrageInfo = a.this.ahy.getBarrageInfo()) != null) {
                        imSendMsgData.msgType = (short) 126;
                        imSendMsgData.barrageId = barrageInfo.id;
                        imSendMsgData.price = barrageInfo.price;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
                    if (!z && a.this.ahy != null) {
                        a.this.ahy.tH();
                    }
                } else if (!z) {
                    a.this.ahB.sG();
                }
                if (z) {
                    a.this.ahB.cH(str);
                }
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0080a
        public void sH() {
            if (a.this.ahB != null) {
                a.this.ahB.sH();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0080a
        public void sI() {
            if (a.this.ahB != null) {
                a.this.ahB.sI();
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.ahx = new ALaImMsgView(tbPageContext.getPageActivity());
        this.ahx.setPageContext(this.mPageContext);
        this.ahx.setNeedTopAlphaShade(true);
        this.ahx.setMode(false);
        this.ahy = new ALALiveTextView(tbPageContext.getPageActivity());
        this.ahy.setMsHandler(this.ahE);
        this.ahz = new ArrayList();
        this.ahA = new ArrayList();
        this.ahz.add("allin");
    }

    @Override // com.baidu.live.im.i
    public void setFromMaster(boolean z) {
        this.Wi = z;
        if (this.ahx != null) {
            this.ahx.setFromMaster(z);
        }
        if (this.ahy != null) {
            this.ahy.setFromMaster(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        G(list);
        if (this.ahx != null) {
            boolean J = this.ahx.J(list);
            this.ahx.setMsgData(list);
            if (J) {
                this.ahx.tL();
                if (z) {
                    this.ahx.sC();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.live.im.data.a aVar) {
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
            if ("enter_live".equals(str) && com.baidu.live.entereffect.a.oF().a(aVar)) {
                this.ahx.k(aVar);
            }
        }
    }

    private void G(List<com.baidu.live.im.data.a> list) {
        List<AlaLiveMarkData> list2;
        if (list != null && !list.isEmpty()) {
            for (com.baidu.live.im.data.a aVar : list) {
                if (aVar.getMsgType() == 24) {
                    boolean z = false;
                    com.baidu.live.data.a te = aVar.te();
                    if (te != null && (list2 = te.OR) != null && !list2.isEmpty()) {
                        for (AlaLiveMarkData alaLiveMarkData : list2) {
                            if (alaLiveMarkData.type == 102) {
                                z = true;
                                break;
                            }
                        }
                    }
                    try {
                        if (aVar.getObjContent() instanceof JSONObject) {
                            JSONObject jSONObject = (JSONObject) aVar.getObjContent();
                            jSONObject.put("gift_rate", d.uI().aF(z));
                            aVar.setObjContent(jSONObject);
                        } else {
                            JSONObject jSONObject2 = new JSONObject(aVar.getContent());
                            jSONObject2.put("gift_rate", d.uI().aF(z));
                            aVar.setContent(jSONObject2.toString());
                        }
                    } catch (JSONException e) {
                    }
                }
            }
        }
    }

    @Override // com.baidu.live.im.i
    public h sD() {
        return this.ahx;
    }

    @Override // com.baidu.live.im.i
    public com.baidu.live.view.input.a sE() {
        return this.ahy;
    }

    @Override // com.baidu.live.im.i
    public void setLogData(String str, String str2) {
        if (this.ahy != null) {
            this.ahy.setLogData(str, str2);
        }
    }

    @Override // com.baidu.live.im.i
    public void e(String str, String str2, String str3, String str4, String str5) {
        MessageManager.getInstance().registerListener(this.afT);
        MessageManager.getInstance().registerListener(this.afU);
        MessageManager.getInstance().registerListener(this.ahC);
        MessageManager.getInstance().registerListener(this.ahD);
        this.ahx.sW();
        this.ahx.a(str, str4, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str3), str3);
    }

    @Override // com.baidu.live.im.i
    public void sj() {
        MessageManager.getInstance().unRegisterListener(this.afT);
        MessageManager.getInstance().unRegisterListener(this.afU);
        MessageManager.getInstance().unRegisterListener(this.ahC);
        MessageManager.getInstance().unRegisterListener(this.ahD);
        if (this.ahx != null) {
            this.ahx.tA();
        }
    }

    @Override // com.baidu.live.im.i
    public void h(Map<String, Integer> map) {
        if (this.ahy != null) {
            this.ahy.h(map);
        }
    }

    @Override // com.baidu.live.im.i
    public void a(i.a aVar) {
        this.ahB = aVar;
    }

    @Override // com.baidu.live.im.i
    public void onDestroy() {
        a((i.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(List<com.baidu.live.im.data.a> list) {
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            if (this.Wi) {
                if (ListUtils.isEmpty(this.ahz)) {
                    return;
                }
            } else if (ListUtils.isEmpty(this.ahA)) {
                return;
            }
            for (com.baidu.live.im.data.a aVar : list) {
                if (aVar != null && (aVar.getMsgType() == 13 || aVar.getMsgType() == 26 || aVar.getMsgType() == 27 || aVar.getMsgType() == 12)) {
                    if (this.Wi) {
                        if (this.ahz.contains(i(aVar))) {
                            arrayList.add(aVar);
                        }
                    } else if (this.ahA.contains(i(aVar))) {
                        arrayList.add(aVar);
                    }
                }
            }
            list.removeAll(arrayList);
        }
    }

    private String i(com.baidu.live.im.data.a aVar) {
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
