package com.baidu.live.im.c;

import android.util.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.al;
import com.baidu.live.data.cg;
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
    private final ALaImMsgView blq;
    private final ALALiveTextView blr;
    private List<String> bls;
    private List<String> blt;
    private k.a blu;
    private TbPageContext mPageContext;
    private boolean aUa = false;
    private CustomMessageListener biU = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                List list = (List) customResponsedMessage.getData();
                a.this.V(list);
                a.this.d(list, true);
            }
        }
    };
    private CustomMessageListener biV = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.c.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (!a.this.aUa && aVar != null && (aVar.Mo() instanceof com.baidu.live.data.a)) {
                    aVar.Mo().aHF = -1;
                }
                a.this.t(aVar);
            }
        }
    };
    private CustomMessageListener blv = new CustomMessageListener(2913044) { // from class: com.baidu.live.im.c.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener blw = new CustomMessageListener(2913095) { // from class: com.baidu.live.im.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.blr != null) {
                    a.this.blr.hM(str);
                }
            }
        }
    };
    private final a.InterfaceC0232a blx = new a.InterfaceC0232a() { // from class: com.baidu.live.im.c.a.5
        @Override // com.baidu.live.view.input.a.InterfaceC0232a
        public boolean LM() {
            return a.this.blu != null && a.this.blu.LM();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0232a
        public void s(String str, boolean z) {
            Log.i("i", "@@@ localText nmpanctr sdhdl 1");
            if (a.this.blu != null) {
                if (a.this.blu.LM()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (a.this.blr != null && a.this.blr.Nc()) {
                        cg barrageInfo = a.this.blr.getBarrageInfo();
                        if (barrageInfo != null) {
                            if (barrageInfo.type == 16 && !a.this.blu.LQ()) {
                                BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.h.sdk_throne_disabled_alert);
                                return;
                            } else if (barrageInfo.type == 17 && barrageInfo.aRr > a.this.blu.LR()) {
                                if (barrageInfo.aRr == 7) {
                                    BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.h.sdk_noble_king_disabled_alert);
                                    return;
                                } else {
                                    BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.h.sdk_noble_disabled_alert);
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
                    if (!z && a.this.blr != null) {
                        a.this.blr.Ng();
                    }
                } else if (!z) {
                    Log.i("i", "@@@ localText nmpanctr sdhdl nolg");
                    a.this.blu.LN();
                }
                if (z) {
                    a.this.blu.hJ(str);
                }
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0232a
        public void LO() {
            if (a.this.blu != null) {
                a.this.blu.LO();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0232a
        public void LP() {
            if (a.this.blu != null) {
                a.this.blu.LP();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0232a
        public boolean LQ() {
            return a.this.blu != null && a.this.blu.LQ();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0232a
        public int LR() {
            if (a.this.blu != null) {
                return a.this.blu.LR();
            }
            return 0;
        }
    };
    private Runnable bly = new Runnable() { // from class: com.baidu.live.im.c.a.8
        @Override // java.lang.Runnable
        public void run() {
            a.this.blq.Nn();
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.blq = new ALaImMsgView(tbPageContext.getPageActivity());
        this.blq.setPageContext(this.mPageContext);
        this.blq.setNeedTopAlphaShade(true);
        this.blq.setMode(false);
        this.blr = new ALALiveTextView(tbPageContext.getPageActivity(), tbPageContext);
        this.blr.setMsHandler(this.blx);
        this.blr.setBdPageContext(tbPageContext);
        this.bls = new ArrayList();
        this.blt = new ArrayList();
        this.bls.add("allin");
    }

    @Override // com.baidu.live.im.k
    public void setFromMaster(boolean z) {
        this.aUa = z;
        if (this.blq != null) {
            this.blq.setFromMaster(z);
        }
        if (this.blr != null) {
            this.blr.setFromMaster(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.blq != null) {
            boolean X = this.blq.X(list);
            this.blq.setMsgData(list);
            if (X) {
                this.blq.Nm();
                if (z) {
                    this.blq.postDelayed(new Runnable() { // from class: com.baidu.live.im.c.a.6
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.blq.LI();
                        }
                    }, 200L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(com.baidu.live.im.data.a aVar) {
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
            if ("enter_live".equals(str) && com.baidu.live.entereffect.a.Fg().h(aVar)) {
                this.blq.y(aVar);
            }
        }
    }

    @Override // com.baidu.live.im.k
    public j LJ() {
        return this.blq;
    }

    @Override // com.baidu.live.im.k
    public com.baidu.live.view.input.a LK() {
        return this.blr;
    }

    @Override // com.baidu.live.im.k
    public void setLogData(String str, String str2) {
        if (this.blr != null) {
            this.blr.setLogData(str, str2);
        }
        if (this.blq != null) {
            this.blq.setLogData(str, str2);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(String str, String str2, String str3, String str4, String str5, boolean z) {
        MessageManager.getInstance().registerListener(this.biU);
        MessageManager.getInstance().registerListener(this.biV);
        MessageManager.getInstance().registerListener(this.blv);
        MessageManager.getInstance().registerListener(this.blw);
        this.blq.KS();
        this.blq.b(str, str4, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str3), str3);
        this.blq.Nn();
        f(str4, str3, z);
        MessageManager.getInstance().registerListener(this.blr.bmQ);
        MessageManager.getInstance().registerListener(this.blr.bek);
    }

    @Override // com.baidu.live.im.k
    public void CM() {
        MessageManager.getInstance().unRegisterListener(this.biU);
        MessageManager.getInstance().unRegisterListener(this.biV);
        MessageManager.getInstance().unRegisterListener(this.blv);
        MessageManager.getInstance().unRegisterListener(this.blw);
        if (this.blq != null) {
            this.blq.MW();
        }
        if (this.blr != null) {
            this.blr.Ng();
            MessageManager.getInstance().unRegisterListener(this.blr.bmQ);
            MessageManager.getInstance().unRegisterListener(this.blr.bek);
        }
        LiveTimerManager.getInstance().removeLiveTimerTask("live_show_tag_view", true);
        SafeHandler.getInst().removeCallbacks(this.bly);
    }

    @Override // com.baidu.live.im.k
    public void g(Map<String, Integer> map) {
        if (this.blr != null) {
            this.blr.g(map);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(k.a aVar) {
        this.blu = aVar;
    }

    @Override // com.baidu.live.im.k
    public void a(boolean z, int i, int i2, String str) {
        if (this.blr != null) {
            this.blr.b(z, i, i2, str);
        }
    }

    @Override // com.baidu.live.im.k
    public void onDestroy() {
        a((k.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(List<com.baidu.live.im.data.a> list) {
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            if (this.aUa) {
                if (ListUtils.isEmpty(this.bls)) {
                    return;
                }
            } else if (ListUtils.isEmpty(this.blt)) {
                return;
            }
            for (com.baidu.live.im.data.a aVar : list) {
                if (aVar != null && (aVar.getMsgType() == 13 || aVar.getMsgType() == 26 || aVar.getMsgType() == 27 || aVar.getMsgType() == 12)) {
                    if (this.aUa) {
                        if (this.bls.contains(w(aVar))) {
                            arrayList.add(aVar);
                        }
                    } else if (this.blt.contains(w(aVar))) {
                        arrayList.add(aVar);
                    }
                }
            }
            list.removeAll(arrayList);
        }
    }

    private String w(com.baidu.live.im.data.a aVar) {
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

    private void f(final String str, final String str2, boolean z) {
        if (al.EC() && z && UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) != 2) {
            LiveTimerManager.getInstance().addLiveTimerTask("live_show_tag_view", Long.valueOf(str).longValue(), new OnLiveTimerListener() { // from class: com.baidu.live.im.c.a.7
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z2) {
                    if (UtilHelper.getRealScreenOrientation(a.this.mPageContext.getPageActivity()) != 2) {
                        a.this.blq.az(str, str2);
                        SafeHandler.getInst().postDelayed(a.this.bly, 10000L);
                    }
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, al.ED() * 1000, true);
        }
    }

    @Override // com.baidu.live.im.k
    public int getImMsgListViewTop() {
        return this.blq.getImMsgListViewTop();
    }

    @Override // com.baidu.live.im.k
    public int getImMsgListViewHeight() {
        return this.blq.getImMsgListViewHeight();
    }

    @Override // com.baidu.live.im.k
    public int LL() {
        return this.blq.getWidth();
    }
}
