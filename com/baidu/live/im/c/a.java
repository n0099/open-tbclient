package com.baidu.live.im.c;

import android.util.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.ac;
import com.baidu.live.data.br;
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
/* loaded from: classes7.dex */
public class a implements k {
    private final ALaImMsgView bcc;
    private final ALALiveTextView bcd;
    private List<String> bce;
    private List<String> bcf;
    private k.a bcg;
    private TbPageContext mPageContext;
    private boolean aMH = false;
    private CustomMessageListener aZX = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                List list = (List) customResponsedMessage.getData();
                a.this.P(list);
                a.this.d(list, true);
            }
        }
    };
    private CustomMessageListener aZY = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.c.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (!a.this.aMH && aVar != null && (aVar.JK() instanceof com.baidu.live.data.a)) {
                    aVar.JK().aCR = -1;
                }
                a.this.r(aVar);
            }
        }
    };
    private CustomMessageListener bch = new CustomMessageListener(2913044) { // from class: com.baidu.live.im.c.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener bci = new CustomMessageListener(2913095) { // from class: com.baidu.live.im.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.bcd != null) {
                    a.this.bcd.gT(str);
                }
            }
        }
    };
    private final a.InterfaceC0199a bcj = new a.InterfaceC0199a() { // from class: com.baidu.live.im.c.a.5
        @Override // com.baidu.live.view.input.a.InterfaceC0199a
        public boolean Ji() {
            return a.this.bcg != null && a.this.bcg.Ji();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0199a
        public void r(String str, boolean z) {
            Log.i("i", "@@@ localText nmpanctr sdhdl 1");
            if (a.this.bcg != null) {
                if (a.this.bcg.Ji()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (a.this.bcd != null && a.this.bcd.Kw()) {
                        br barrageInfo = a.this.bcd.getBarrageInfo();
                        if (barrageInfo != null) {
                            if (barrageInfo.type == 16 && !a.this.bcg.Jm()) {
                                BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.i.sdk_throne_disabled_alert);
                                return;
                            } else if (barrageInfo.type == 17 && barrageInfo.aKR > a.this.bcg.Jn()) {
                                if (barrageInfo.aKR == 7) {
                                    BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.i.sdk_noble_king_disabled_alert);
                                    return;
                                } else {
                                    BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.i.sdk_noble_disabled_alert);
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
                    if (!z && a.this.bcd != null) {
                        a.this.bcd.KA();
                    }
                } else if (!z) {
                    Log.i("i", "@@@ localText nmpanctr sdhdl nolg");
                    a.this.bcg.Jj();
                }
                if (z) {
                    a.this.bcg.gQ(str);
                }
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0199a
        public void Jk() {
            if (a.this.bcg != null) {
                a.this.bcg.Jk();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0199a
        public void Jl() {
            if (a.this.bcg != null) {
                a.this.bcg.Jl();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0199a
        public boolean Jm() {
            return a.this.bcg != null && a.this.bcg.Jm();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0199a
        public int Jn() {
            if (a.this.bcg != null) {
                return a.this.bcg.Jn();
            }
            return 0;
        }
    };
    private Runnable bck = new Runnable() { // from class: com.baidu.live.im.c.a.8
        @Override // java.lang.Runnable
        public void run() {
            a.this.bcc.KH();
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bcc = new ALaImMsgView(tbPageContext.getPageActivity());
        this.bcc.setPageContext(this.mPageContext);
        this.bcc.setNeedTopAlphaShade(true);
        this.bcc.setMode(false);
        this.bcd = new ALALiveTextView(tbPageContext.getPageActivity(), tbPageContext);
        this.bcd.setMsHandler(this.bcj);
        this.bcd.setBdPageContext(tbPageContext);
        this.bce = new ArrayList();
        this.bcf = new ArrayList();
        this.bce.add("allin");
    }

    @Override // com.baidu.live.im.k
    public void setFromMaster(boolean z) {
        this.aMH = z;
        if (this.bcc != null) {
            this.bcc.setFromMaster(z);
        }
        if (this.bcd != null) {
            this.bcd.setFromMaster(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.bcc != null) {
            boolean R = this.bcc.R(list);
            this.bcc.setMsgData(list);
            if (R) {
                this.bcc.KG();
                if (z) {
                    this.bcc.postDelayed(new Runnable() { // from class: com.baidu.live.im.c.a.6
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.bcc.Je();
                        }
                    }, 200L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(com.baidu.live.im.data.a aVar) {
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
            if ("enter_live".equals(str) && com.baidu.live.entereffect.a.Dg().h(aVar)) {
                this.bcc.w(aVar);
            }
        }
    }

    @Override // com.baidu.live.im.k
    public j Jf() {
        return this.bcc;
    }

    @Override // com.baidu.live.im.k
    public com.baidu.live.view.input.a Jg() {
        return this.bcd;
    }

    @Override // com.baidu.live.im.k
    public void setLogData(String str, String str2) {
        if (this.bcd != null) {
            this.bcd.setLogData(str, str2);
        }
        if (this.bcc != null) {
            this.bcc.setLogData(str, str2);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(String str, String str2, String str3, String str4, String str5, boolean z) {
        MessageManager.getInstance().registerListener(this.aZX);
        MessageManager.getInstance().registerListener(this.aZY);
        MessageManager.getInstance().registerListener(this.bch);
        MessageManager.getInstance().registerListener(this.bci);
        this.bcc.Ju();
        this.bcc.b(str, str4, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str3), str3);
        e(str4, str3, z);
        MessageManager.getInstance().registerListener(this.bcd.bdu);
        MessageManager.getInstance().registerListener(this.bcd.aVN);
    }

    @Override // com.baidu.live.im.k
    public void Bb() {
        MessageManager.getInstance().unRegisterListener(this.aZX);
        MessageManager.getInstance().unRegisterListener(this.aZY);
        MessageManager.getInstance().unRegisterListener(this.bch);
        MessageManager.getInstance().unRegisterListener(this.bci);
        if (this.bcc != null) {
            this.bcc.Kq();
        }
        if (this.bcd != null) {
            this.bcd.KA();
            MessageManager.getInstance().unRegisterListener(this.bcd.bdu);
            MessageManager.getInstance().unRegisterListener(this.bcd.aVN);
        }
        LiveTimerManager.getInstance().removeLiveTimerTask("live_show_tag_view", true);
        SafeHandler.getInst().removeCallbacks(this.bck);
    }

    @Override // com.baidu.live.im.k
    public void g(Map<String, Integer> map) {
        if (this.bcd != null) {
            this.bcd.g(map);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(k.a aVar) {
        this.bcg = aVar;
    }

    @Override // com.baidu.live.im.k
    public void a(boolean z, int i, int i2, String str) {
        if (this.bcd != null) {
            this.bcd.b(z, i, i2, str);
        }
    }

    @Override // com.baidu.live.im.k
    public void onDestroy() {
        a((k.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(List<com.baidu.live.im.data.a> list) {
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            if (this.aMH) {
                if (ListUtils.isEmpty(this.bce)) {
                    return;
                }
            } else if (ListUtils.isEmpty(this.bcf)) {
                return;
            }
            for (com.baidu.live.im.data.a aVar : list) {
                if (aVar != null && (aVar.getMsgType() == 13 || aVar.getMsgType() == 26 || aVar.getMsgType() == 27 || aVar.getMsgType() == 12)) {
                    if (this.aMH) {
                        if (this.bce.contains(u(aVar))) {
                            arrayList.add(aVar);
                        }
                    } else if (this.bcf.contains(u(aVar))) {
                        arrayList.add(aVar);
                    }
                }
            }
            list.removeAll(arrayList);
        }
    }

    private String u(com.baidu.live.im.data.a aVar) {
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

    private void e(final String str, final String str2, boolean z) {
        if (ac.CK() && z && UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) != 2) {
            LiveTimerManager.getInstance().addLiveTimerTask("live_show_tag_view", Long.valueOf(str).longValue(), new OnLiveTimerListener() { // from class: com.baidu.live.im.c.a.7
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z2) {
                    if (UtilHelper.getRealScreenOrientation(a.this.mPageContext.getPageActivity()) != 2) {
                        a.this.bcc.av(str, str2);
                        SafeHandler.getInst().postDelayed(a.this.bck, 10000L);
                    }
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, ac.CL() * 1000, true);
        }
    }

    @Override // com.baidu.live.im.k
    public int getImMsgListViewTop() {
        return this.bcc.getImMsgListViewTop();
    }

    @Override // com.baidu.live.im.k
    public int getImMsgListViewHeight() {
        return this.bcc.getImMsgListViewHeight();
    }

    @Override // com.baidu.live.im.k
    public int Jh() {
        return this.bcc.getWidth();
    }
}
