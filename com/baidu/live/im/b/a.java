package com.baidu.live.im.b;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.ao;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.h;
import com.baidu.live.im.i;
import com.baidu.live.im.view.ALALiveTextView;
import com.baidu.live.im.view.ALaImMsgView;
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
    private final ALaImMsgView ahf;
    private final ALALiveTextView ahg;
    private List<String> ahh;
    private List<String> ahi;
    private i.a ahj;
    private TbPageContext mPageContext;
    private boolean VP = false;
    private CustomMessageListener afB = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.b.a.1
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
    private CustomMessageListener afC = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (!a.this.VP && aVar != null && (aVar.tf() instanceof com.baidu.live.data.a)) {
                    aVar.tf().Oo = -1;
                }
                a.this.g(aVar);
            }
        }
    };
    private CustomMessageListener ahk = new CustomMessageListener(2913044) { // from class: com.baidu.live.im.b.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener ahl = new CustomMessageListener(2913095) { // from class: com.baidu.live.im.b.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.ahg != null) {
                    a.this.ahg.cM(str);
                }
            }
        }
    };
    private final a.InterfaceC0080a ahm = new a.InterfaceC0080a() { // from class: com.baidu.live.im.b.a.5
        @Override // com.baidu.live.view.input.a.InterfaceC0080a
        public boolean sG() {
            return a.this.ahj != null && a.this.ahj.sG();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0080a
        public void g(String str, boolean z) {
            ao barrageInfo;
            if (a.this.ahj != null) {
                if (a.this.ahj.sG()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (a.this.ahg != null && a.this.ahg.tF() && (barrageInfo = a.this.ahg.getBarrageInfo()) != null) {
                        imSendMsgData.msgType = (short) 126;
                        imSendMsgData.barrageId = barrageInfo.id;
                        imSendMsgData.price = barrageInfo.price;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
                    if (!z && a.this.ahg != null) {
                        a.this.ahg.tI();
                    }
                } else if (!z) {
                    a.this.ahj.sH();
                }
                if (z) {
                    a.this.ahj.cH(str);
                }
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0080a
        public void sI() {
            if (a.this.ahj != null) {
                a.this.ahj.sI();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0080a
        public void sJ() {
            if (a.this.ahj != null) {
                a.this.ahj.sJ();
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.ahf = new ALaImMsgView(tbPageContext.getPageActivity());
        this.ahf.setPageContext(this.mPageContext);
        this.ahf.setNeedTopAlphaShade(true);
        this.ahf.setMode(false);
        this.ahg = new ALALiveTextView(tbPageContext.getPageActivity());
        this.ahg.setMsHandler(this.ahm);
        this.ahh = new ArrayList();
        this.ahi = new ArrayList();
        this.ahh.add("allin");
    }

    @Override // com.baidu.live.im.i
    public void setFromMaster(boolean z) {
        this.VP = z;
        if (this.ahf != null) {
            this.ahf.setFromMaster(z);
        }
        if (this.ahg != null) {
            this.ahg.setFromMaster(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.ahf != null) {
            boolean J = this.ahf.J(list);
            this.ahf.setMsgData(list);
            if (J) {
                this.ahf.tM();
                if (z) {
                    this.ahf.sD();
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
            if ("enter_live".equals(str) && com.baidu.live.entereffect.a.oF().a(aVar)) {
                this.ahf.l(aVar);
            }
        }
    }

    @Override // com.baidu.live.im.i
    public h sE() {
        return this.ahf;
    }

    @Override // com.baidu.live.im.i
    public com.baidu.live.view.input.a sF() {
        return this.ahg;
    }

    @Override // com.baidu.live.im.i
    public void setLogData(String str, String str2) {
        if (this.ahg != null) {
            this.ahg.setLogData(str, str2);
        }
    }

    @Override // com.baidu.live.im.i
    public void e(String str, String str2, String str3, String str4, String str5) {
        MessageManager.getInstance().registerListener(this.afB);
        MessageManager.getInstance().registerListener(this.afC);
        MessageManager.getInstance().registerListener(this.ahk);
        MessageManager.getInstance().registerListener(this.ahl);
        this.ahf.sX();
        this.ahf.a(str, str4, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str3), str3);
    }

    @Override // com.baidu.live.im.i
    public void sk() {
        MessageManager.getInstance().unRegisterListener(this.afB);
        MessageManager.getInstance().unRegisterListener(this.afC);
        MessageManager.getInstance().unRegisterListener(this.ahk);
        MessageManager.getInstance().unRegisterListener(this.ahl);
        if (this.ahf != null) {
            this.ahf.tB();
        }
    }

    @Override // com.baidu.live.im.i
    public void h(Map<String, Integer> map) {
        if (this.ahg != null) {
            this.ahg.h(map);
        }
    }

    @Override // com.baidu.live.im.i
    public void a(i.a aVar) {
        this.ahj = aVar;
    }

    @Override // com.baidu.live.im.i
    public void onDestroy() {
        a((i.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(List<com.baidu.live.im.data.a> list) {
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            if (this.VP) {
                if (ListUtils.isEmpty(this.ahh)) {
                    return;
                }
            } else if (ListUtils.isEmpty(this.ahi)) {
                return;
            }
            for (com.baidu.live.im.data.a aVar : list) {
                if (aVar != null && (aVar.getMsgType() == 13 || aVar.getMsgType() == 26 || aVar.getMsgType() == 27 || aVar.getMsgType() == 12)) {
                    if (this.VP) {
                        if (this.ahh.contains(j(aVar))) {
                            arrayList.add(aVar);
                        }
                    } else if (this.ahi.contains(j(aVar))) {
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
