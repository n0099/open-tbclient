package com.baidu.live.im.c;

import android.util.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.ak;
import com.baidu.live.data.ce;
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
    private final ALaImMsgView bjW;
    private final ALALiveTextView bjX;
    private List<String> bjY;
    private List<String> bjZ;
    private k.a bka;
    private TbPageContext mPageContext;
    private boolean aSH = false;
    private CustomMessageListener bhy = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.c.a.1
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
    private CustomMessageListener bhz = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.c.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (!a.this.aSH && aVar != null && (aVar.LO() instanceof com.baidu.live.data.a)) {
                    aVar.LO().aGP = -1;
                }
                a.this.s(aVar);
            }
        }
    };
    private CustomMessageListener bkb = new CustomMessageListener(2913044) { // from class: com.baidu.live.im.c.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener bkc = new CustomMessageListener(2913095) { // from class: com.baidu.live.im.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.bjX != null) {
                    a.this.bjX.hF(str);
                }
            }
        }
    };
    private final a.InterfaceC0220a bkd = new a.InterfaceC0220a() { // from class: com.baidu.live.im.c.a.5
        @Override // com.baidu.live.view.input.a.InterfaceC0220a
        public boolean Lm() {
            return a.this.bka != null && a.this.bka.Lm();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0220a
        public void s(String str, boolean z) {
            Log.i("i", "@@@ localText nmpanctr sdhdl 1");
            if (a.this.bka != null) {
                if (a.this.bka.Lm()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (a.this.bjX != null && a.this.bjX.MC()) {
                        ce barrageInfo = a.this.bjX.getBarrageInfo();
                        if (barrageInfo != null) {
                            if (barrageInfo.type == 16 && !a.this.bka.Lq()) {
                                BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.i.sdk_throne_disabled_alert);
                                return;
                            } else if (barrageInfo.type == 17 && barrageInfo.aQp > a.this.bka.Lr()) {
                                if (barrageInfo.aQp == 7) {
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
                    if (!z && a.this.bjX != null) {
                        a.this.bjX.MG();
                    }
                } else if (!z) {
                    Log.i("i", "@@@ localText nmpanctr sdhdl nolg");
                    a.this.bka.Ln();
                }
                if (z) {
                    a.this.bka.hC(str);
                }
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0220a
        public void Lo() {
            if (a.this.bka != null) {
                a.this.bka.Lo();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0220a
        public void Lp() {
            if (a.this.bka != null) {
                a.this.bka.Lp();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0220a
        public boolean Lq() {
            return a.this.bka != null && a.this.bka.Lq();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0220a
        public int Lr() {
            if (a.this.bka != null) {
                return a.this.bka.Lr();
            }
            return 0;
        }
    };
    private Runnable bke = new Runnable() { // from class: com.baidu.live.im.c.a.8
        @Override // java.lang.Runnable
        public void run() {
            a.this.bjW.MN();
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bjW = new ALaImMsgView(tbPageContext.getPageActivity());
        this.bjW.setPageContext(this.mPageContext);
        this.bjW.setNeedTopAlphaShade(true);
        this.bjW.setMode(false);
        this.bjX = new ALALiveTextView(tbPageContext.getPageActivity(), tbPageContext);
        this.bjX.setMsHandler(this.bkd);
        this.bjX.setBdPageContext(tbPageContext);
        this.bjY = new ArrayList();
        this.bjZ = new ArrayList();
        this.bjY.add("allin");
    }

    @Override // com.baidu.live.im.k
    public void setFromMaster(boolean z) {
        this.aSH = z;
        if (this.bjW != null) {
            this.bjW.setFromMaster(z);
        }
        if (this.bjX != null) {
            this.bjX.setFromMaster(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.bjW != null) {
            boolean X = this.bjW.X(list);
            this.bjW.setMsgData(list);
            if (X) {
                this.bjW.MM();
                if (z) {
                    this.bjW.postDelayed(new Runnable() { // from class: com.baidu.live.im.c.a.6
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.bjW.Li();
                        }
                    }, 200L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(com.baidu.live.im.data.a aVar) {
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
            if ("enter_live".equals(str) && com.baidu.live.entereffect.a.EF().h(aVar)) {
                this.bjW.x(aVar);
            }
        }
    }

    @Override // com.baidu.live.im.k
    public j Lj() {
        return this.bjW;
    }

    @Override // com.baidu.live.im.k
    public com.baidu.live.view.input.a Lk() {
        return this.bjX;
    }

    @Override // com.baidu.live.im.k
    public void setLogData(String str, String str2) {
        if (this.bjX != null) {
            this.bjX.setLogData(str, str2);
        }
        if (this.bjW != null) {
            this.bjW.setLogData(str, str2);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(String str, String str2, String str3, String str4, String str5, boolean z) {
        MessageManager.getInstance().registerListener(this.bhy);
        MessageManager.getInstance().registerListener(this.bhz);
        MessageManager.getInstance().registerListener(this.bkb);
        MessageManager.getInstance().registerListener(this.bkc);
        this.bjW.Ks();
        this.bjW.b(str, str4, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str3), str3);
        this.bjW.MN();
        e(str4, str3, z);
        MessageManager.getInstance().registerListener(this.bjX.blw);
        MessageManager.getInstance().registerListener(this.bjX.bcQ);
    }

    @Override // com.baidu.live.im.k
    public void Ct() {
        MessageManager.getInstance().unRegisterListener(this.bhy);
        MessageManager.getInstance().unRegisterListener(this.bhz);
        MessageManager.getInstance().unRegisterListener(this.bkb);
        MessageManager.getInstance().unRegisterListener(this.bkc);
        if (this.bjW != null) {
            this.bjW.Mw();
        }
        if (this.bjX != null) {
            this.bjX.MG();
            MessageManager.getInstance().unRegisterListener(this.bjX.blw);
            MessageManager.getInstance().unRegisterListener(this.bjX.bcQ);
        }
        LiveTimerManager.getInstance().removeLiveTimerTask("live_show_tag_view", true);
        SafeHandler.getInst().removeCallbacks(this.bke);
    }

    @Override // com.baidu.live.im.k
    public void g(Map<String, Integer> map) {
        if (this.bjX != null) {
            this.bjX.g(map);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(k.a aVar) {
        this.bka = aVar;
    }

    @Override // com.baidu.live.im.k
    public void a(boolean z, int i, int i2, String str) {
        if (this.bjX != null) {
            this.bjX.b(z, i, i2, str);
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
            if (this.aSH) {
                if (ListUtils.isEmpty(this.bjY)) {
                    return;
                }
            } else if (ListUtils.isEmpty(this.bjZ)) {
                return;
            }
            for (com.baidu.live.im.data.a aVar : list) {
                if (aVar != null && (aVar.getMsgType() == 13 || aVar.getMsgType() == 26 || aVar.getMsgType() == 27 || aVar.getMsgType() == 12)) {
                    if (this.aSH) {
                        if (this.bjY.contains(v(aVar))) {
                            arrayList.add(aVar);
                        }
                    } else if (this.bjZ.contains(v(aVar))) {
                        arrayList.add(aVar);
                    }
                }
            }
            list.removeAll(arrayList);
        }
    }

    private String v(com.baidu.live.im.data.a aVar) {
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
        if (ak.Eg() && z && UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) != 2) {
            LiveTimerManager.getInstance().addLiveTimerTask("live_show_tag_view", Long.valueOf(str).longValue(), new OnLiveTimerListener() { // from class: com.baidu.live.im.c.a.7
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z2) {
                    if (UtilHelper.getRealScreenOrientation(a.this.mPageContext.getPageActivity()) != 2) {
                        a.this.bjW.ay(str, str2);
                        SafeHandler.getInst().postDelayed(a.this.bke, 10000L);
                    }
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, ak.Eh() * 1000, true);
        }
    }

    @Override // com.baidu.live.im.k
    public int getImMsgListViewTop() {
        return this.bjW.getImMsgListViewTop();
    }

    @Override // com.baidu.live.im.k
    public int getImMsgListViewHeight() {
        return this.bjW.getImMsgListViewHeight();
    }

    @Override // com.baidu.live.im.k
    public int Ll() {
        return this.bjW.getWidth();
    }
}
