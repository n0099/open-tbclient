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
    private final ALaImMsgView bce;
    private final ALALiveTextView bcf;
    private List<String> bcg;
    private List<String> bch;
    private k.a bci;
    private TbPageContext mPageContext;
    private boolean aMJ = false;
    private CustomMessageListener aZZ = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.c.a.1
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
    private CustomMessageListener baa = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.c.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (!a.this.aMJ && aVar != null && (aVar.JK() instanceof com.baidu.live.data.a)) {
                    aVar.JK().aCT = -1;
                }
                a.this.r(aVar);
            }
        }
    };
    private CustomMessageListener bcj = new CustomMessageListener(2913044) { // from class: com.baidu.live.im.c.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener bck = new CustomMessageListener(2913095) { // from class: com.baidu.live.im.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.bcf != null) {
                    a.this.bcf.gU(str);
                }
            }
        }
    };
    private final a.InterfaceC0199a bcl = new a.InterfaceC0199a() { // from class: com.baidu.live.im.c.a.5
        @Override // com.baidu.live.view.input.a.InterfaceC0199a
        public boolean Ji() {
            return a.this.bci != null && a.this.bci.Ji();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0199a
        public void r(String str, boolean z) {
            Log.i("i", "@@@ localText nmpanctr sdhdl 1");
            if (a.this.bci != null) {
                if (a.this.bci.Ji()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (a.this.bcf != null && a.this.bcf.Kw()) {
                        br barrageInfo = a.this.bcf.getBarrageInfo();
                        if (barrageInfo != null) {
                            if (barrageInfo.type == 16 && !a.this.bci.Jm()) {
                                BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.i.sdk_throne_disabled_alert);
                                return;
                            } else if (barrageInfo.type == 17 && barrageInfo.aKT > a.this.bci.Jn()) {
                                if (barrageInfo.aKT == 7) {
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
                    if (!z && a.this.bcf != null) {
                        a.this.bcf.KA();
                    }
                } else if (!z) {
                    Log.i("i", "@@@ localText nmpanctr sdhdl nolg");
                    a.this.bci.Jj();
                }
                if (z) {
                    a.this.bci.gR(str);
                }
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0199a
        public void Jk() {
            if (a.this.bci != null) {
                a.this.bci.Jk();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0199a
        public void Jl() {
            if (a.this.bci != null) {
                a.this.bci.Jl();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0199a
        public boolean Jm() {
            return a.this.bci != null && a.this.bci.Jm();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0199a
        public int Jn() {
            if (a.this.bci != null) {
                return a.this.bci.Jn();
            }
            return 0;
        }
    };
    private Runnable bcm = new Runnable() { // from class: com.baidu.live.im.c.a.8
        @Override // java.lang.Runnable
        public void run() {
            a.this.bce.KH();
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bce = new ALaImMsgView(tbPageContext.getPageActivity());
        this.bce.setPageContext(this.mPageContext);
        this.bce.setNeedTopAlphaShade(true);
        this.bce.setMode(false);
        this.bcf = new ALALiveTextView(tbPageContext.getPageActivity(), tbPageContext);
        this.bcf.setMsHandler(this.bcl);
        this.bcf.setBdPageContext(tbPageContext);
        this.bcg = new ArrayList();
        this.bch = new ArrayList();
        this.bcg.add("allin");
    }

    @Override // com.baidu.live.im.k
    public void setFromMaster(boolean z) {
        this.aMJ = z;
        if (this.bce != null) {
            this.bce.setFromMaster(z);
        }
        if (this.bcf != null) {
            this.bcf.setFromMaster(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.bce != null) {
            boolean R = this.bce.R(list);
            this.bce.setMsgData(list);
            if (R) {
                this.bce.KG();
                if (z) {
                    this.bce.postDelayed(new Runnable() { // from class: com.baidu.live.im.c.a.6
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.bce.Je();
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
                this.bce.w(aVar);
            }
        }
    }

    @Override // com.baidu.live.im.k
    public j Jf() {
        return this.bce;
    }

    @Override // com.baidu.live.im.k
    public com.baidu.live.view.input.a Jg() {
        return this.bcf;
    }

    @Override // com.baidu.live.im.k
    public void setLogData(String str, String str2) {
        if (this.bcf != null) {
            this.bcf.setLogData(str, str2);
        }
        if (this.bce != null) {
            this.bce.setLogData(str, str2);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(String str, String str2, String str3, String str4, String str5, boolean z) {
        MessageManager.getInstance().registerListener(this.aZZ);
        MessageManager.getInstance().registerListener(this.baa);
        MessageManager.getInstance().registerListener(this.bcj);
        MessageManager.getInstance().registerListener(this.bck);
        this.bce.Ju();
        this.bce.b(str, str4, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str3), str3);
        e(str4, str3, z);
        MessageManager.getInstance().registerListener(this.bcf.bdw);
        MessageManager.getInstance().registerListener(this.bcf.aVP);
    }

    @Override // com.baidu.live.im.k
    public void Bb() {
        MessageManager.getInstance().unRegisterListener(this.aZZ);
        MessageManager.getInstance().unRegisterListener(this.baa);
        MessageManager.getInstance().unRegisterListener(this.bcj);
        MessageManager.getInstance().unRegisterListener(this.bck);
        if (this.bce != null) {
            this.bce.Kq();
        }
        if (this.bcf != null) {
            this.bcf.KA();
            MessageManager.getInstance().unRegisterListener(this.bcf.bdw);
            MessageManager.getInstance().unRegisterListener(this.bcf.aVP);
        }
        LiveTimerManager.getInstance().removeLiveTimerTask("live_show_tag_view", true);
        SafeHandler.getInst().removeCallbacks(this.bcm);
    }

    @Override // com.baidu.live.im.k
    public void g(Map<String, Integer> map) {
        if (this.bcf != null) {
            this.bcf.g(map);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(k.a aVar) {
        this.bci = aVar;
    }

    @Override // com.baidu.live.im.k
    public void a(boolean z, int i, int i2, String str) {
        if (this.bcf != null) {
            this.bcf.b(z, i, i2, str);
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
            if (this.aMJ) {
                if (ListUtils.isEmpty(this.bcg)) {
                    return;
                }
            } else if (ListUtils.isEmpty(this.bch)) {
                return;
            }
            for (com.baidu.live.im.data.a aVar : list) {
                if (aVar != null && (aVar.getMsgType() == 13 || aVar.getMsgType() == 26 || aVar.getMsgType() == 27 || aVar.getMsgType() == 12)) {
                    if (this.aMJ) {
                        if (this.bcg.contains(u(aVar))) {
                            arrayList.add(aVar);
                        }
                    } else if (this.bch.contains(u(aVar))) {
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
                        a.this.bce.av(str, str2);
                        SafeHandler.getInst().postDelayed(a.this.bcm, 10000L);
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
        return this.bce.getImMsgListViewTop();
    }

    @Override // com.baidu.live.im.k
    public int getImMsgListViewHeight() {
        return this.bce.getImMsgListViewHeight();
    }

    @Override // com.baidu.live.im.k
    public int Jh() {
        return this.bce.getWidth();
    }
}
