package com.baidu.live.im.b;

import android.util.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.be;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.j;
import com.baidu.live.im.k;
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
public class a implements k {
    private final ALaImMsgView aML;
    private final ALALiveTextView aMM;
    private List<String> aMN;
    private List<String> aMO;
    private k.a aMP;
    private TbPageContext mPageContext;
    private boolean ayo = false;
    private CustomMessageListener aKW = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                List list = (List) customResponsedMessage.getData();
                a.this.J(list);
                a.this.d(list, true);
            }
        }
    };
    private CustomMessageListener aKX = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (!a.this.ayo && aVar != null && (aVar.Ce() instanceof com.baidu.live.data.a)) {
                    aVar.Ce().apD = -1;
                }
                a.this.k(aVar);
            }
        }
    };
    private CustomMessageListener aMQ = new CustomMessageListener(2913044) { // from class: com.baidu.live.im.b.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener aMR = new CustomMessageListener(2913095) { // from class: com.baidu.live.im.b.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.aMM != null) {
                    a.this.aMM.eI(str);
                }
            }
        }
    };
    private final a.InterfaceC0151a aMS = new a.InterfaceC0151a() { // from class: com.baidu.live.im.b.a.5
        @Override // com.baidu.live.view.input.a.InterfaceC0151a
        public boolean Bg() {
            return a.this.aMP != null && a.this.aMP.Bg();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0151a
        public void n(String str, boolean z) {
            Log.i("i", "@@@ localText nmpanctr sdhdl 1");
            if (a.this.aMP != null) {
                if (a.this.aMP.Bg()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (a.this.aMM != null && a.this.aMM.CL()) {
                        be barrageInfo = a.this.aMM.getBarrageInfo();
                        if (barrageInfo != null) {
                            if (barrageInfo.type == 16 && !a.this.aMP.Bk()) {
                                BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.i.sdk_throne_disabled_alert);
                                return;
                            }
                            imSendMsgData.msgType = (short) 126;
                            imSendMsgData.barrageType = barrageInfo.type;
                            imSendMsgData.barrageId = barrageInfo.id;
                            imSendMsgData.price = barrageInfo.price;
                        }
                    } else {
                        imSendMsgData.isQuick = z;
                    }
                    Log.i("i", "@@@ localText nmpanctr sdhdl cmd");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
                    if (!z && a.this.aMM != null) {
                        a.this.aMM.CO();
                    }
                } else if (!z) {
                    Log.i("i", "@@@ localText nmpanctr sdhdl nolg");
                    a.this.aMP.Bh();
                }
                if (z) {
                    a.this.aMP.eE(str);
                }
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0151a
        public void Bi() {
            if (a.this.aMP != null) {
                a.this.aMP.Bi();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0151a
        public void Bj() {
            if (a.this.aMP != null) {
                a.this.aMP.Bj();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0151a
        public boolean Bk() {
            return a.this.aMP != null && a.this.aMP.Bk();
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.aML = new ALaImMsgView(tbPageContext.getPageActivity());
        this.aML.setPageContext(this.mPageContext);
        this.aML.setNeedTopAlphaShade(true);
        this.aML.setMode(false);
        this.aMM = new ALALiveTextView(tbPageContext.getPageActivity());
        this.aMM.setMsHandler(this.aMS);
        this.aMM.setBdPageContext(tbPageContext);
        this.aMN = new ArrayList();
        this.aMO = new ArrayList();
        this.aMN.add("allin");
    }

    @Override // com.baidu.live.im.k
    public void setFromMaster(boolean z) {
        this.ayo = z;
        if (this.aML != null) {
            this.aML.setFromMaster(z);
        }
        if (this.aMM != null) {
            this.aMM.setFromMaster(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.aML != null) {
            boolean L = this.aML.L(list);
            this.aML.setMsgData(list);
            if (L) {
                this.aML.CT();
                if (z) {
                    this.aML.Bd();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(com.baidu.live.im.data.a aVar) {
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
            if ("enter_live".equals(str) && com.baidu.live.entereffect.a.vn().a(aVar)) {
                this.aML.w(aVar);
            }
        }
    }

    @Override // com.baidu.live.im.k
    public j Be() {
        return this.aML;
    }

    @Override // com.baidu.live.im.k
    public com.baidu.live.view.input.a Bf() {
        return this.aMM;
    }

    @Override // com.baidu.live.im.k
    public void setLogData(String str, String str2) {
        if (this.aMM != null) {
            this.aMM.setLogData(str, str2);
        }
    }

    @Override // com.baidu.live.im.k
    public void e(String str, String str2, String str3, String str4, String str5) {
        MessageManager.getInstance().registerListener(this.aKW);
        MessageManager.getInstance().registerListener(this.aKX);
        MessageManager.getInstance().registerListener(this.aMQ);
        MessageManager.getInstance().registerListener(this.aMR);
        this.aML.BA();
        this.aML.a(str, str4, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str3), str3);
        MessageManager.getInstance().registerListener(this.aMM.aNp);
        this.aMM.zq();
    }

    @Override // com.baidu.live.im.k
    public void AJ() {
        MessageManager.getInstance().unRegisterListener(this.aKW);
        MessageManager.getInstance().unRegisterListener(this.aKX);
        MessageManager.getInstance().unRegisterListener(this.aMQ);
        MessageManager.getInstance().unRegisterListener(this.aMR);
        if (this.aML != null) {
            this.aML.CF();
        }
        if (this.aMM != null) {
            this.aMM.CO();
            MessageManager.getInstance().unRegisterListener(this.aMM.aNp);
            MessageManager.getInstance().unRegisterListener(this.aMM.aGS);
        }
    }

    @Override // com.baidu.live.im.k
    public void e(Map<String, Integer> map) {
        if (this.aMM != null) {
            this.aMM.e(map);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(k.a aVar) {
        this.aMP = aVar;
    }

    @Override // com.baidu.live.im.k
    public void a(boolean z, int i, int i2, String str) {
        if (this.aMM != null) {
            this.aMM.b(z, i, i2, str);
        }
    }

    @Override // com.baidu.live.im.k
    public void onDestroy() {
        a((k.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(List<com.baidu.live.im.data.a> list) {
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            if (this.ayo) {
                if (ListUtils.isEmpty(this.aMN)) {
                    return;
                }
            } else if (ListUtils.isEmpty(this.aMO)) {
                return;
            }
            for (com.baidu.live.im.data.a aVar : list) {
                if (aVar != null && (aVar.getMsgType() == 13 || aVar.getMsgType() == 26 || aVar.getMsgType() == 27 || aVar.getMsgType() == 12)) {
                    if (this.ayo) {
                        if (this.aMN.contains(n(aVar))) {
                            arrayList.add(aVar);
                        }
                    } else if (this.aMO.contains(n(aVar))) {
                        arrayList.add(aVar);
                    }
                }
            }
            list.removeAll(arrayList);
        }
    }

    private String n(com.baidu.live.im.data.a aVar) {
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
