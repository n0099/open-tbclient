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
    private final ALaImMsgView aMF;
    private final ALALiveTextView aMG;
    private List<String> aMH;
    private List<String> aMI;
    private k.a aMJ;
    private TbPageContext mPageContext;
    private boolean ayi = false;
    private CustomMessageListener aKQ = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.b.a.1
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
    private CustomMessageListener aKR = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (!a.this.ayi && aVar != null && (aVar.Cf() instanceof com.baidu.live.data.a)) {
                    aVar.Cf().apx = -1;
                }
                a.this.k(aVar);
            }
        }
    };
    private CustomMessageListener aMK = new CustomMessageListener(2913044) { // from class: com.baidu.live.im.b.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener aML = new CustomMessageListener(2913095) { // from class: com.baidu.live.im.b.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.aMG != null) {
                    a.this.aMG.eI(str);
                }
            }
        }
    };
    private final a.InterfaceC0130a aMM = new a.InterfaceC0130a() { // from class: com.baidu.live.im.b.a.5
        @Override // com.baidu.live.view.input.a.InterfaceC0130a
        public boolean Bh() {
            return a.this.aMJ != null && a.this.aMJ.Bh();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0130a
        public void n(String str, boolean z) {
            Log.i("i", "@@@ localText nmpanctr sdhdl 1");
            if (a.this.aMJ != null) {
                if (a.this.aMJ.Bh()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (a.this.aMG != null && a.this.aMG.CM()) {
                        be barrageInfo = a.this.aMG.getBarrageInfo();
                        if (barrageInfo != null) {
                            if (barrageInfo.type == 16 && !a.this.aMJ.Bl()) {
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
                    if (!z && a.this.aMG != null) {
                        a.this.aMG.CP();
                    }
                } else if (!z) {
                    Log.i("i", "@@@ localText nmpanctr sdhdl nolg");
                    a.this.aMJ.Bi();
                }
                if (z) {
                    a.this.aMJ.eE(str);
                }
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0130a
        public void Bj() {
            if (a.this.aMJ != null) {
                a.this.aMJ.Bj();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0130a
        public void Bk() {
            if (a.this.aMJ != null) {
                a.this.aMJ.Bk();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0130a
        public boolean Bl() {
            return a.this.aMJ != null && a.this.aMJ.Bl();
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.aMF = new ALaImMsgView(tbPageContext.getPageActivity());
        this.aMF.setPageContext(this.mPageContext);
        this.aMF.setNeedTopAlphaShade(true);
        this.aMF.setMode(false);
        this.aMG = new ALALiveTextView(tbPageContext.getPageActivity());
        this.aMG.setMsHandler(this.aMM);
        this.aMG.setBdPageContext(tbPageContext);
        this.aMH = new ArrayList();
        this.aMI = new ArrayList();
        this.aMH.add("allin");
    }

    @Override // com.baidu.live.im.k
    public void setFromMaster(boolean z) {
        this.ayi = z;
        if (this.aMF != null) {
            this.aMF.setFromMaster(z);
        }
        if (this.aMG != null) {
            this.aMG.setFromMaster(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.aMF != null) {
            boolean L = this.aMF.L(list);
            this.aMF.setMsgData(list);
            if (L) {
                this.aMF.CU();
                if (z) {
                    this.aMF.Be();
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
            if ("enter_live".equals(str) && com.baidu.live.entereffect.a.vo().a(aVar)) {
                this.aMF.w(aVar);
            }
        }
    }

    @Override // com.baidu.live.im.k
    public j Bf() {
        return this.aMF;
    }

    @Override // com.baidu.live.im.k
    public com.baidu.live.view.input.a Bg() {
        return this.aMG;
    }

    @Override // com.baidu.live.im.k
    public void setLogData(String str, String str2) {
        if (this.aMG != null) {
            this.aMG.setLogData(str, str2);
        }
    }

    @Override // com.baidu.live.im.k
    public void e(String str, String str2, String str3, String str4, String str5) {
        MessageManager.getInstance().registerListener(this.aKQ);
        MessageManager.getInstance().registerListener(this.aKR);
        MessageManager.getInstance().registerListener(this.aMK);
        MessageManager.getInstance().registerListener(this.aML);
        this.aMF.BB();
        this.aMF.a(str, str4, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str3), str3);
        MessageManager.getInstance().registerListener(this.aMG.aNj);
        this.aMG.zr();
    }

    @Override // com.baidu.live.im.k
    public void AK() {
        MessageManager.getInstance().unRegisterListener(this.aKQ);
        MessageManager.getInstance().unRegisterListener(this.aKR);
        MessageManager.getInstance().unRegisterListener(this.aMK);
        MessageManager.getInstance().unRegisterListener(this.aML);
        if (this.aMF != null) {
            this.aMF.CG();
        }
        if (this.aMG != null) {
            this.aMG.CP();
            MessageManager.getInstance().unRegisterListener(this.aMG.aNj);
            MessageManager.getInstance().unRegisterListener(this.aMG.aGM);
        }
    }

    @Override // com.baidu.live.im.k
    public void e(Map<String, Integer> map) {
        if (this.aMG != null) {
            this.aMG.e(map);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(k.a aVar) {
        this.aMJ = aVar;
    }

    @Override // com.baidu.live.im.k
    public void a(boolean z, int i, int i2, String str) {
        if (this.aMG != null) {
            this.aMG.b(z, i, i2, str);
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
            if (this.ayi) {
                if (ListUtils.isEmpty(this.aMH)) {
                    return;
                }
            } else if (ListUtils.isEmpty(this.aMI)) {
                return;
            }
            for (com.baidu.live.im.data.a aVar : list) {
                if (aVar != null && (aVar.getMsgType() == 13 || aVar.getMsgType() == 26 || aVar.getMsgType() == 27 || aVar.getMsgType() == 12)) {
                    if (this.ayi) {
                        if (this.aMH.contains(n(aVar))) {
                            arrayList.add(aVar);
                        }
                    } else if (this.aMI.contains(n(aVar))) {
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
