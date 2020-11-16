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
    private final ALaImMsgView bjF;
    private final ALALiveTextView bjG;
    private List<String> bjH;
    private List<String> bjI;
    private k.a bjJ;
    private TbPageContext mPageContext;
    private boolean aSp = false;
    private CustomMessageListener bhg = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.c.a.1
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
    private CustomMessageListener bhh = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.c.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (!a.this.aSp && aVar != null && (aVar.LF() instanceof com.baidu.live.data.a)) {
                    aVar.LF().aFU = -1;
                }
                a.this.t(aVar);
            }
        }
    };
    private CustomMessageListener bjK = new CustomMessageListener(2913044) { // from class: com.baidu.live.im.c.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener bjL = new CustomMessageListener(2913095) { // from class: com.baidu.live.im.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.bjG != null) {
                    a.this.bjG.hG(str);
                }
            }
        }
    };
    private final a.InterfaceC0230a bjM = new a.InterfaceC0230a() { // from class: com.baidu.live.im.c.a.5
        @Override // com.baidu.live.view.input.a.InterfaceC0230a
        public boolean Ld() {
            return a.this.bjJ != null && a.this.bjJ.Ld();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0230a
        public void s(String str, boolean z) {
            Log.i("i", "@@@ localText nmpanctr sdhdl 1");
            if (a.this.bjJ != null) {
                if (a.this.bjJ.Ld()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (a.this.bjG != null && a.this.bjG.Mt()) {
                        cg barrageInfo = a.this.bjG.getBarrageInfo();
                        if (barrageInfo != null) {
                            if (barrageInfo.type == 16 && !a.this.bjJ.Lh()) {
                                BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.h.sdk_throne_disabled_alert);
                                return;
                            } else if (barrageInfo.type == 17 && barrageInfo.aPG > a.this.bjJ.Li()) {
                                if (barrageInfo.aPG == 7) {
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
                    if (!z && a.this.bjG != null) {
                        a.this.bjG.Mx();
                    }
                } else if (!z) {
                    Log.i("i", "@@@ localText nmpanctr sdhdl nolg");
                    a.this.bjJ.Le();
                }
                if (z) {
                    a.this.bjJ.hD(str);
                }
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0230a
        public void Lf() {
            if (a.this.bjJ != null) {
                a.this.bjJ.Lf();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0230a
        public void Lg() {
            if (a.this.bjJ != null) {
                a.this.bjJ.Lg();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0230a
        public boolean Lh() {
            return a.this.bjJ != null && a.this.bjJ.Lh();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0230a
        public int Li() {
            if (a.this.bjJ != null) {
                return a.this.bjJ.Li();
            }
            return 0;
        }
    };
    private Runnable bjN = new Runnable() { // from class: com.baidu.live.im.c.a.8
        @Override // java.lang.Runnable
        public void run() {
            a.this.bjF.ME();
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bjF = new ALaImMsgView(tbPageContext.getPageActivity());
        this.bjF.setPageContext(this.mPageContext);
        this.bjF.setNeedTopAlphaShade(true);
        this.bjF.setMode(false);
        this.bjG = new ALALiveTextView(tbPageContext.getPageActivity(), tbPageContext);
        this.bjG.setMsHandler(this.bjM);
        this.bjG.setBdPageContext(tbPageContext);
        this.bjH = new ArrayList();
        this.bjI = new ArrayList();
        this.bjH.add("allin");
    }

    @Override // com.baidu.live.im.k
    public void setFromMaster(boolean z) {
        this.aSp = z;
        if (this.bjF != null) {
            this.bjF.setFromMaster(z);
        }
        if (this.bjG != null) {
            this.bjG.setFromMaster(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.bjF != null) {
            boolean X = this.bjF.X(list);
            this.bjF.setMsgData(list);
            if (X) {
                this.bjF.MD();
                if (z) {
                    this.bjF.postDelayed(new Runnable() { // from class: com.baidu.live.im.c.a.6
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.bjF.KZ();
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
            if ("enter_live".equals(str) && com.baidu.live.entereffect.a.Ex().h(aVar)) {
                this.bjF.y(aVar);
            }
        }
    }

    @Override // com.baidu.live.im.k
    public j La() {
        return this.bjF;
    }

    @Override // com.baidu.live.im.k
    public com.baidu.live.view.input.a Lb() {
        return this.bjG;
    }

    @Override // com.baidu.live.im.k
    public void setLogData(String str, String str2) {
        if (this.bjG != null) {
            this.bjG.setLogData(str, str2);
        }
        if (this.bjF != null) {
            this.bjF.setLogData(str, str2);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(String str, String str2, String str3, String str4, String str5, boolean z) {
        MessageManager.getInstance().registerListener(this.bhg);
        MessageManager.getInstance().registerListener(this.bhh);
        MessageManager.getInstance().registerListener(this.bjK);
        MessageManager.getInstance().registerListener(this.bjL);
        this.bjF.Kj();
        this.bjF.b(str, str4, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str3), str3);
        this.bjF.ME();
        f(str4, str3, z);
        MessageManager.getInstance().registerListener(this.bjG.blf);
        MessageManager.getInstance().registerListener(this.bjG.bcy);
    }

    @Override // com.baidu.live.im.k
    public void Cd() {
        MessageManager.getInstance().unRegisterListener(this.bhg);
        MessageManager.getInstance().unRegisterListener(this.bhh);
        MessageManager.getInstance().unRegisterListener(this.bjK);
        MessageManager.getInstance().unRegisterListener(this.bjL);
        if (this.bjF != null) {
            this.bjF.Mn();
        }
        if (this.bjG != null) {
            this.bjG.Mx();
            MessageManager.getInstance().unRegisterListener(this.bjG.blf);
            MessageManager.getInstance().unRegisterListener(this.bjG.bcy);
        }
        LiveTimerManager.getInstance().removeLiveTimerTask("live_show_tag_view", true);
        SafeHandler.getInst().removeCallbacks(this.bjN);
    }

    @Override // com.baidu.live.im.k
    public void g(Map<String, Integer> map) {
        if (this.bjG != null) {
            this.bjG.g(map);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(k.a aVar) {
        this.bjJ = aVar;
    }

    @Override // com.baidu.live.im.k
    public void a(boolean z, int i, int i2, String str) {
        if (this.bjG != null) {
            this.bjG.b(z, i, i2, str);
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
            if (this.aSp) {
                if (ListUtils.isEmpty(this.bjH)) {
                    return;
                }
            } else if (ListUtils.isEmpty(this.bjI)) {
                return;
            }
            for (com.baidu.live.im.data.a aVar : list) {
                if (aVar != null && (aVar.getMsgType() == 13 || aVar.getMsgType() == 26 || aVar.getMsgType() == 27 || aVar.getMsgType() == 12)) {
                    if (this.aSp) {
                        if (this.bjH.contains(w(aVar))) {
                            arrayList.add(aVar);
                        }
                    } else if (this.bjI.contains(w(aVar))) {
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
        if (al.DT() && z && UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) != 2) {
            LiveTimerManager.getInstance().addLiveTimerTask("live_show_tag_view", Long.valueOf(str).longValue(), new OnLiveTimerListener() { // from class: com.baidu.live.im.c.a.7
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z2) {
                    if (UtilHelper.getRealScreenOrientation(a.this.mPageContext.getPageActivity()) != 2) {
                        a.this.bjF.ay(str, str2);
                        SafeHandler.getInst().postDelayed(a.this.bjN, 10000L);
                    }
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, al.DU() * 1000, true);
        }
    }

    @Override // com.baidu.live.im.k
    public int getImMsgListViewTop() {
        return this.bjF.getImMsgListViewTop();
    }

    @Override // com.baidu.live.im.k
    public int getImMsgListViewHeight() {
        return this.bjF.getImMsgListViewHeight();
    }

    @Override // com.baidu.live.im.k
    public int Lc() {
        return this.bjF.getWidth();
    }
}
