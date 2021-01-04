package com.baidu.live.im.c;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.ao;
import com.baidu.live.data.ck;
import com.baidu.live.data.x;
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
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.view.input.a;
import com.baidu.live.view.input.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements k {
    private final ALaImMsgView bqd;
    private final ALALiveTextView bqe;
    private com.baidu.live.im.view.a bqf;
    private List<String> bqg;
    private List<String> bqh;
    private k.a bqj;
    private TbPageContext mPageContext;
    private boolean aWW = false;
    public boolean bqi = false;
    private Handler mHandler = new Handler();
    private CustomMessageListener bnb = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                List list = (List) customResponsedMessage.getData();
                a.this.W(list);
                a.this.d(list, true);
            }
        }
    };
    private CustomMessageListener bnc = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.c.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b)) {
                com.baidu.live.im.data.b bVar = (com.baidu.live.im.data.b) customResponsedMessage.getData();
                if (!a.this.aWW && bVar != null && (bVar.Nw() instanceof com.baidu.live.data.a)) {
                    bVar.Nw().aIY = -1;
                }
                a.this.t(bVar);
            }
        }
    };
    private CustomMessageListener bqk = new CustomMessageListener(2913044) { // from class: com.baidu.live.im.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener bql = new CustomMessageListener(2913095) { // from class: com.baidu.live.im.c.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.bqe != null) {
                    a.this.bqe.hU(str);
                }
                if (a.this.bqf != null) {
                    a.this.bqf.hU(str);
                }
            }
        }
    };
    public CustomMessageListener bqm = new CustomMessageListener(2913272) { // from class: com.baidu.live.im.c.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                a.this.ck(booleanValue);
                a.this.bqd.ct(booleanValue);
                a.this.bqd.setListAlignBottom(!booleanValue);
                a.this.bqd.cu(booleanValue);
            }
        }
    };
    private final a.InterfaceC0239a bqn = new a.InterfaceC0239a() { // from class: com.baidu.live.im.c.a.7
        @Override // com.baidu.live.view.input.a.InterfaceC0239a
        public boolean ME() {
            return a.this.bqj != null && a.this.bqj.ME();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0239a
        public void t(String str, boolean z) {
            Log.i("i", "@@@ localText nmpanctr sdhdl 1");
            if (a.this.bqj != null) {
                a.this.bqf.setClicked(true);
                if (a.this.bqj.ME()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (a.this.bqe != null && a.this.bqe.Ot()) {
                        ck barrageInfo = a.this.bqe.getBarrageInfo();
                        if (barrageInfo != null) {
                            if (barrageInfo.type == 16 && !a.this.bqj.MJ()) {
                                BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.h.sdk_throne_disabled_alert);
                                return;
                            } else if (barrageInfo.type == 17 && barrageInfo.aTG > a.this.bqj.MK()) {
                                if (barrageInfo.aTG == 7) {
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
                        imSendMsgData.isOut = false;
                    }
                    Log.i("i", "@@@ localText nmpanctr sdhdl cmd");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
                    if (hR(str) && !z) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (com.baidu.live.af.a.SE().bwi.aOG != null && com.baidu.live.af.a.SE().bwi.aOG.originTexts != null && com.baidu.live.af.a.SE().bwi.aOG.originTexts.size() > 0) {
                                jSONObject.putOpt("msg", com.baidu.live.af.a.SE().bwi.aOG.originTexts.get(0));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "chatsendclk").setContentExt(null, null, jSONObject));
                    }
                    if (!z && a.this.bqe != null) {
                        a.this.bqe.Ox();
                    }
                } else if (!z) {
                    Log.i("i", "@@@ localText nmpanctr sdhdl nolg");
                    a.this.bqj.MF();
                }
                if (z) {
                    a.this.bqj.hO(str);
                }
            }
        }

        private boolean hR(String str) {
            int i;
            if (str == null || com.baidu.live.af.a.SE().bwi.aOG == null || com.baidu.live.af.a.SE().bwi.aOG.originTexts == null || com.baidu.live.af.a.SE().bwi.aOG.originTexts.size() <= 0) {
                return false;
            }
            char[] charArray = str.toCharArray();
            int length = com.baidu.live.af.a.SE().bwi.aOG.originTexts.get(0).length();
            for (i = 0; i < charArray.length; i = i + 1) {
                i = (charArray[i] == ' ' && (charArray.length - i == length || com.baidu.live.af.a.SE().bwi.aOG.originTexts.get(0).equals(str.substring(i + 1)))) ? 0 : i + 1;
                return true;
            }
            return false;
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0239a
        public void MG() {
            if (a.this.bqj != null) {
                a.this.bqj.MG();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0239a
        public void MH() {
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0239a
        public void MI() {
            if (a.this.bqj != null) {
                a.this.bqj.MI();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0239a
        public boolean MJ() {
            return a.this.bqj != null && a.this.bqj.MJ();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0239a
        public int MK() {
            if (a.this.bqj != null) {
                return a.this.bqj.MK();
            }
            return 0;
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0239a
        public boolean ML() {
            if (a.this.bqj != null) {
                return a.this.bqj.ML();
            }
            return false;
        }
    };
    private final b.a bqo = new b.a() { // from class: com.baidu.live.im.c.a.8
        @Override // com.baidu.live.view.input.b.a
        public void t(String str, boolean z) {
            Log.i("i", "@@@ localText nmpanctr sdhdl 1");
            if (a.this.bqj != null) {
                if (a.this.bqj.ME()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    imSendMsgData.isQuick = z;
                    imSendMsgData.isOut = true;
                    Log.i("i", "@@@ localText nmpanctr sdhdl cmd");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
                    a.this.bqf.setClicked(true);
                    if (!z && a.this.bqe != null) {
                        a.this.bqe.Ox();
                    }
                } else if (!z) {
                    Log.i("i", "@@@ localText nmpanctr sdhdl nolg");
                    a.this.bqj.MF();
                }
                if (z) {
                    a.this.bqj.hO(str);
                }
            }
        }
    };
    private Runnable bqp = new Runnable() { // from class: com.baidu.live.im.c.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bqd.cv(a.this.bqi);
        }
    };

    public void ck(boolean z) {
        this.bqi = z;
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bqd = new ALaImMsgView(tbPageContext.getPageActivity());
        this.bqd.setPageContext(this.mPageContext);
        this.bqd.setNeedTopAlphaShade(true);
        this.bqd.setMode(false);
        this.bqf = new com.baidu.live.im.view.a(tbPageContext);
        this.bqf.a(this.bqo);
        this.bqf.getView().setId(a.f.quick_input_header);
        this.bqd.setView(this.bqf);
        this.bqe = new ALALiveTextView(tbPageContext.getPageActivity(), tbPageContext);
        this.bqe.setMsHandler(this.bqn);
        this.bqe.setBdPageContext(tbPageContext);
        this.bqg = new ArrayList();
        this.bqh = new ArrayList();
        this.bqg.add("allin");
    }

    @Override // com.baidu.live.im.k
    public void a(ViewGroup viewGroup, x xVar, List<String> list, RelativeLayout.LayoutParams layoutParams) {
        if (viewGroup != null && this.mPageContext != null && xVar != null && this.bqf.getView() != null && viewGroup.indexOfChild(this.bqf.getView()) < 0) {
            viewGroup.addView(this.bqf.getView(), layoutParams);
            this.bqf.Y(list);
            this.bqf.OH();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913272, true));
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_QUICK_SHOW).setContentExt(null, null, null));
        }
    }

    @Override // com.baidu.live.im.k
    public void setFromMaster(boolean z) {
        this.aWW = z;
        if (this.bqd != null) {
            this.bqd.setFromMaster(z);
        }
        if (this.bqe != null) {
            this.bqe.setFromMaster(z);
        }
        if (this.bqf != null) {
            this.bqf.setFromMaster(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<com.baidu.live.im.data.b> list, boolean z) {
        if (this.bqd != null) {
            boolean Z = this.bqd.Z(list);
            this.bqd.setMsgData(list);
            if (Z) {
                this.bqd.OK();
                if (z) {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.c.a.9
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.bqd.Mz();
                        }
                    }, 200L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(com.baidu.live.im.data.b bVar) {
        String str;
        JSONObject jSONObject;
        if (bVar.getMsgType() == 13 || bVar.getMsgType() == 12) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                str = jSONObject.optString("content_type");
                try {
                    jSONObject.optString("text");
                } catch (JSONException e) {
                }
            } catch (JSONException e2) {
                str = null;
            }
            if ("enter_live".equals(str) && com.baidu.live.entereffect.a.FB().h(bVar)) {
                this.bqd.B(bVar);
            }
        }
    }

    @Override // com.baidu.live.im.k
    public j MA() {
        return this.bqd;
    }

    @Override // com.baidu.live.im.k
    public com.baidu.live.view.input.a MB() {
        return this.bqe;
    }

    @Override // com.baidu.live.im.k
    public com.baidu.live.view.input.b MC() {
        return this.bqf;
    }

    @Override // com.baidu.live.im.k
    public void setLogData(String str, String str2) {
        if (this.bqe != null) {
            this.bqe.setLogData(str, str2);
        }
        if (this.bqd != null) {
            this.bqd.setLogData(str, str2);
        }
        if (this.bqf != null) {
            this.bqf.setLogData(str, str2);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(String str, String str2, String str3, String str4, String str5, boolean z, String str6) {
        MessageManager.getInstance().registerListener(this.bnb);
        MessageManager.getInstance().registerListener(this.bnc);
        MessageManager.getInstance().registerListener(this.bqk);
        MessageManager.getInstance().registerListener(this.bql);
        MessageManager.getInstance().registerListener(this.bqm);
        this.bqd.LI();
        this.bqd.a(str, str4, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str3), str3, str6);
        this.bqd.cv(this.bqi);
        h(str4, str3, z);
        MessageManager.getInstance().registerListener(this.bqe.bpW);
        MessageManager.getInstance().registerListener(this.bqe.bih);
        MessageManager.getInstance().registerListener(this.bqf.bpW);
        MessageManager.getInstance().registerListener(this.bqf.bih);
        MessageManager.getInstance().registerListener(this.bqf.bsj);
    }

    @Override // com.baidu.live.im.k
    public void Dc() {
        MessageManager.getInstance().unRegisterListener(this.bnb);
        MessageManager.getInstance().unRegisterListener(this.bnc);
        MessageManager.getInstance().unRegisterListener(this.bqk);
        MessageManager.getInstance().unRegisterListener(this.bql);
        if (this.bqd != null) {
            this.bqd.Ng();
        }
        if (this.bqe != null) {
            this.bqe.Ox();
            MessageManager.getInstance().unRegisterListener(this.bqe.bpW);
            MessageManager.getInstance().unRegisterListener(this.bqe.bih);
        }
        if (this.bqf != null) {
            MessageManager.getInstance().unRegisterListener(this.bqf.bpW);
            MessageManager.getInstance().unRegisterListener(this.bqf.bih);
            MessageManager.getInstance().unRegisterListener(this.bqf.bsj);
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        LiveTimerManager.getInstance().removeLiveTimerTask("live_show_tag_view", true);
        SafeHandler.getInst().removeCallbacks(this.bqp);
        MessageManager.getInstance().unRegisterListener(this.bqm);
    }

    @Override // com.baidu.live.im.k
    public void g(Map<String, Integer> map) {
        if (this.bqe != null) {
            this.bqe.g(map);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(k.a aVar) {
        this.bqj = aVar;
    }

    @Override // com.baidu.live.im.k
    public void a(boolean z, int i, int i2, String str) {
        if (this.bqe != null) {
            this.bqe.b(z, i, i2, str);
        }
        if (this.bqf != null) {
            this.bqf.b(z, i, i2, str);
        }
    }

    @Override // com.baidu.live.im.k
    public void onDestroy() {
        a((k.a) null);
        if (MB() != null) {
            MB().destroy();
        }
    }

    @Override // com.baidu.live.im.k
    public View getTextView() {
        if (MB() == null) {
            return null;
        }
        return MB().getTextView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(List<com.baidu.live.im.data.b> list) {
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            if (this.aWW) {
                if (ListUtils.isEmpty(this.bqg)) {
                    return;
                }
            } else if (ListUtils.isEmpty(this.bqh)) {
                return;
            }
            for (com.baidu.live.im.data.b bVar : list) {
                if (bVar != null && (bVar.getMsgType() == 13 || bVar.getMsgType() == 26 || bVar.getMsgType() == 27 || bVar.getMsgType() == 12)) {
                    if (this.aWW) {
                        if (this.bqg.contains(z(bVar))) {
                            arrayList.add(bVar);
                        }
                    } else if (this.bqh.contains(z(bVar))) {
                        arrayList.add(bVar);
                    }
                }
            }
            list.removeAll(arrayList);
        }
    }

    private String z(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        try {
            if (bVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) bVar.getObjContent();
            } else {
                jSONObject = new JSONObject(bVar.getContent());
            }
            return jSONObject.optString("content_type");
        } catch (JSONException e) {
            return null;
        }
    }

    private void h(final String str, final String str2, boolean z) {
        if (ao.EU() && z && UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) != 2) {
            LiveTimerManager.getInstance().addLiveTimerTask("live_show_tag_view", Long.valueOf(str).longValue(), new OnLiveTimerListener() { // from class: com.baidu.live.im.c.a.10
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z2) {
                    if (UtilHelper.getRealScreenOrientation(a.this.mPageContext.getPageActivity()) != 2) {
                        a.this.bqd.aA(str, str2);
                        SafeHandler.getInst().postDelayed(a.this.bqp, 10000L);
                    }
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, ao.EV() * 1000, true);
        }
    }

    @Override // com.baidu.live.im.k
    public int getImMsgListViewTop() {
        return this.bqd.getImMsgListViewTop();
    }

    @Override // com.baidu.live.im.k
    public int getImMsgListViewHeight() {
        return this.bqd.getImMsgListViewHeight();
    }

    @Override // com.baidu.live.im.k
    public int MD() {
        return this.bqd.getWidth();
    }
}
