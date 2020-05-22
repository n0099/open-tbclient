package com.baidu.live.im.b;

import android.util.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.bj;
import com.baidu.live.data.z;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.j;
import com.baidu.live.im.k;
import com.baidu.live.im.view.ALALiveTextView;
import com.baidu.live.im.view.ALaImMsgView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.timer.LiveTimerManager;
import com.baidu.live.tbadk.timer.OnLiveTimerListener;
import com.baidu.live.u.a;
import com.baidu.live.view.input.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements k {
    private final ALaImMsgView aSP;
    private final ALALiveTextView aSQ;
    private List<String> aSR;
    private List<String> aSS;
    private k.a aST;
    private TbPageContext mPageContext;
    private boolean aDG = false;
    private CustomMessageListener aQK = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                List list = (List) customResponsedMessage.getData();
                a.this.K(list);
                a.this.d(list, true);
            }
        }
    };
    private CustomMessageListener aQL = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (!a.this.aDG && aVar != null && (aVar.DB() instanceof com.baidu.live.data.a)) {
                    aVar.DB().auw = -1;
                }
                a.this.k(aVar);
            }
        }
    };
    private CustomMessageListener aSU = new CustomMessageListener(2913044) { // from class: com.baidu.live.im.b.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener aSV = new CustomMessageListener(2913095) { // from class: com.baidu.live.im.b.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.aSQ != null) {
                    a.this.aSQ.fu(str);
                }
            }
        }
    };
    private final a.InterfaceC0184a aSW = new a.InterfaceC0184a() { // from class: com.baidu.live.im.b.a.5
        @Override // com.baidu.live.view.input.a.InterfaceC0184a
        public boolean CC() {
            return a.this.aST != null && a.this.aST.CC();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0184a
        public void r(String str, boolean z) {
            Log.i("i", "@@@ localText nmpanctr sdhdl 1");
            if (a.this.aST != null) {
                if (a.this.aST.CC()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (a.this.aSQ != null && a.this.aSQ.Ei()) {
                        bj barrageInfo = a.this.aSQ.getBarrageInfo();
                        if (barrageInfo != null) {
                            if (barrageInfo.type == 16 && !a.this.aST.CG()) {
                                BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.i.sdk_throne_disabled_alert);
                                return;
                            } else if (barrageInfo.type == 17 && barrageInfo.aCc > a.this.aST.CH()) {
                                if (barrageInfo.aCc == 7) {
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
                    if (!z && a.this.aSQ != null) {
                        a.this.aSQ.El();
                    }
                } else if (!z) {
                    Log.i("i", "@@@ localText nmpanctr sdhdl nolg");
                    a.this.aST.CD();
                }
                if (z) {
                    a.this.aST.fq(str);
                }
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0184a
        public void CE() {
            if (a.this.aST != null) {
                a.this.aST.CE();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0184a
        public void CF() {
            if (a.this.aST != null) {
                a.this.aST.CF();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0184a
        public boolean CG() {
            return a.this.aST != null && a.this.aST.CG();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0184a
        public int CH() {
            if (a.this.aST != null) {
                return a.this.aST.CH();
            }
            return 0;
        }
    };
    private Runnable aSX = new Runnable() { // from class: com.baidu.live.im.b.a.8
        @Override // java.lang.Runnable
        public void run() {
            a.this.aSP.Er();
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.aSP = new ALaImMsgView(tbPageContext.getPageActivity());
        this.aSP.setPageContext(this.mPageContext);
        this.aSP.setNeedTopAlphaShade(true);
        this.aSP.setMode(false);
        this.aSQ = new ALALiveTextView(tbPageContext.getPageActivity());
        this.aSQ.setMsHandler(this.aSW);
        this.aSQ.setBdPageContext(tbPageContext);
        this.aSR = new ArrayList();
        this.aSS = new ArrayList();
        this.aSR.add("allin");
    }

    @Override // com.baidu.live.im.k
    public void setFromMaster(boolean z) {
        this.aDG = z;
        if (this.aSP != null) {
            this.aSP.setFromMaster(z);
        }
        if (this.aSQ != null) {
            this.aSQ.setFromMaster(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.aSP != null) {
            boolean M = this.aSP.M(list);
            this.aSP.setMsgData(list);
            if (M) {
                this.aSP.Eq();
                if (z) {
                    this.aSP.postDelayed(new Runnable() { // from class: com.baidu.live.im.b.a.6
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.aSP.Cz();
                        }
                    }, 200L);
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
            if ("enter_live".equals(str) && com.baidu.live.entereffect.a.wD().a(aVar)) {
                this.aSP.w(aVar);
            }
        }
    }

    @Override // com.baidu.live.im.k
    public j CA() {
        return this.aSP;
    }

    @Override // com.baidu.live.im.k
    public com.baidu.live.view.input.a CB() {
        return this.aSQ;
    }

    @Override // com.baidu.live.im.k
    public void setLogData(String str, String str2) {
        if (this.aSQ != null) {
            this.aSQ.setLogData(str, str2);
        }
        if (this.aSP != null) {
            this.aSP.setLogData(str, str2);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(String str, String str2, String str3, String str4, String str5, boolean z) {
        MessageManager.getInstance().registerListener(this.aQK);
        MessageManager.getInstance().registerListener(this.aQL);
        MessageManager.getInstance().registerListener(this.aSU);
        MessageManager.getInstance().registerListener(this.aSV);
        this.aSP.CX();
        this.aSP.a(str, str4, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str3), str3);
        e(str4, str3, z);
        MessageManager.getInstance().registerListener(this.aSQ.aTv);
        this.aSQ.AF();
    }

    @Override // com.baidu.live.im.k
    public void BZ() {
        MessageManager.getInstance().unRegisterListener(this.aQK);
        MessageManager.getInstance().unRegisterListener(this.aQL);
        MessageManager.getInstance().unRegisterListener(this.aSU);
        MessageManager.getInstance().unRegisterListener(this.aSV);
        if (this.aSP != null) {
            this.aSP.Ec();
        }
        if (this.aSQ != null) {
            this.aSQ.El();
            MessageManager.getInstance().unRegisterListener(this.aSQ.aTv);
            MessageManager.getInstance().unRegisterListener(this.aSQ.aMA);
        }
        LiveTimerManager.getInstance().removeLiveTimerTask("live_show_tag_view", true);
        SafeHandler.getInst().removeCallbacks(this.aSX);
    }

    @Override // com.baidu.live.im.k
    public void f(Map<String, Integer> map) {
        if (this.aSQ != null) {
            this.aSQ.f(map);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(k.a aVar) {
        this.aST = aVar;
    }

    @Override // com.baidu.live.im.k
    public void a(boolean z, int i, int i2, String str) {
        if (this.aSQ != null) {
            this.aSQ.b(z, i, i2, str);
        }
    }

    @Override // com.baidu.live.im.k
    public void onDestroy() {
        a((k.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(List<com.baidu.live.im.data.a> list) {
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            if (this.aDG) {
                if (ListUtils.isEmpty(this.aSR)) {
                    return;
                }
            } else if (ListUtils.isEmpty(this.aSS)) {
                return;
            }
            for (com.baidu.live.im.data.a aVar : list) {
                if (aVar != null && (aVar.getMsgType() == 13 || aVar.getMsgType() == 26 || aVar.getMsgType() == 27 || aVar.getMsgType() == 12)) {
                    if (this.aDG) {
                        if (this.aSR.contains(n(aVar))) {
                            arrayList.add(aVar);
                        }
                    } else if (this.aSS.contains(n(aVar))) {
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

    private void e(final String str, final String str2, boolean z) {
        if (z.wh() && z && UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) != 2) {
            LiveTimerManager.getInstance().addLiveTimerTask("live_show_tag_view", Long.valueOf(str).longValue(), new OnLiveTimerListener() { // from class: com.baidu.live.im.b.a.7
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z2) {
                    if (UtilHelper.getRealScreenOrientation(a.this.mPageContext.getPageActivity()) != 2) {
                        a.this.aSP.ar(str, str2);
                        SafeHandler.getInst().postDelayed(a.this.aSX, 10000L);
                    }
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, z.wi() * 1000, true);
        }
    }
}
