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
import com.baidu.live.data.ab;
import com.baidu.live.data.as;
import com.baidu.live.data.cr;
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
    private final ALaImMsgView boL;
    private final ALALiveTextView boM;
    private com.baidu.live.im.view.a boN;
    private List<String> boO;
    private List<String> boP;
    private k.a boR;
    private TbPageContext mPageContext;
    private boolean aVn = false;
    public boolean boQ = false;
    private Handler mHandler = new Handler();
    private CustomMessageListener blG = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.c.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                List list = (List) customResponsedMessage.getData();
                a.this.X(list);
                a.this.d(list, true);
            }
        }
    };
    private CustomMessageListener blH = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.c.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b)) {
                com.baidu.live.im.data.b bVar = (com.baidu.live.im.data.b) customResponsedMessage.getData();
                if (!a.this.aVn && bVar != null && (bVar.KZ() instanceof com.baidu.live.data.a)) {
                    bVar.KZ().aFY = -1;
                }
                a.this.t(bVar);
            }
        }
    };
    private CustomMessageListener boS = new CustomMessageListener(2913044) { // from class: com.baidu.live.im.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener boT = new CustomMessageListener(2913095) { // from class: com.baidu.live.im.c.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.boM != null) {
                    a.this.boM.hi(str);
                }
                if (a.this.boN != null) {
                    a.this.boN.hi(str);
                }
            }
        }
    };
    public CustomMessageListener boU = new CustomMessageListener(2913272) { // from class: com.baidu.live.im.c.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                a.this.co(booleanValue);
                a.this.boL.cy(booleanValue);
                a.this.boL.setListAlignBottom(!booleanValue);
                a.this.boL.cz(booleanValue);
            }
        }
    };
    private final a.InterfaceC0232a boV = new a.InterfaceC0232a() { // from class: com.baidu.live.im.c.a.7
        @Override // com.baidu.live.view.input.a.InterfaceC0232a
        public boolean Kh() {
            return a.this.boR != null && a.this.boR.Kh();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0232a
        public void t(String str, boolean z) {
            Log.i("i", "@@@ localText nmpanctr sdhdl 1");
            if (a.this.boR != null) {
                a.this.boN.setClicked(true);
                if (a.this.boR.Kh()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (a.this.boM != null && a.this.boM.LW()) {
                        cr barrageInfo = a.this.boM.getBarrageInfo();
                        if (barrageInfo != null) {
                            if (barrageInfo.type == 16 && !a.this.boR.Km()) {
                                BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.h.sdk_throne_disabled_alert);
                                return;
                            } else if (barrageInfo.type == 17 && barrageInfo.aRV > a.this.boR.Kn()) {
                                if (barrageInfo.aRV == 7) {
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
                    if (hf(str) && !z) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (com.baidu.live.ae.a.Qj().buX.aME != null && com.baidu.live.ae.a.Qj().buX.aME.originTexts != null && com.baidu.live.ae.a.Qj().buX.aME.originTexts.size() > 0) {
                                jSONObject.putOpt("msg", com.baidu.live.ae.a.Qj().buX.aME.originTexts.get(0));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "chatsendclk").setContentExt(null, null, jSONObject));
                    }
                    if (!z && a.this.boM != null) {
                        a.this.boM.Ma();
                    }
                } else if (!z) {
                    Log.i("i", "@@@ localText nmpanctr sdhdl nolg");
                    a.this.boR.Ki();
                }
                if (z) {
                    a.this.boR.hb(str);
                }
            }
        }

        private boolean hf(String str) {
            int i;
            if (str == null || com.baidu.live.ae.a.Qj().buX.aME == null || com.baidu.live.ae.a.Qj().buX.aME.originTexts == null || com.baidu.live.ae.a.Qj().buX.aME.originTexts.size() <= 0) {
                return false;
            }
            char[] charArray = str.toCharArray();
            int length = com.baidu.live.ae.a.Qj().buX.aME.originTexts.get(0).length();
            for (i = 0; i < charArray.length; i = i + 1) {
                i = (charArray[i] == ' ' && (charArray.length - i == length || com.baidu.live.ae.a.Qj().buX.aME.originTexts.get(0).equals(str.substring(i + 1)))) ? 0 : i + 1;
                return true;
            }
            return false;
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0232a
        public void Kj() {
            if (a.this.boR != null) {
                a.this.boR.Kj();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0232a
        public void Kk() {
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0232a
        public void Kl() {
            if (a.this.boR != null) {
                a.this.boR.Kl();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0232a
        public boolean Km() {
            return a.this.boR != null && a.this.boR.Km();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0232a
        public int Kn() {
            if (a.this.boR != null) {
                return a.this.boR.Kn();
            }
            return 0;
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0232a
        public boolean Ko() {
            if (a.this.boR != null) {
                return a.this.boR.Ko();
            }
            return false;
        }
    };
    private final b.a boW = new b.a() { // from class: com.baidu.live.im.c.a.8
        @Override // com.baidu.live.view.input.b.a
        public void t(String str, boolean z) {
            Log.i("i", "@@@ localText nmpanctr sdhdl 1");
            if (a.this.boR != null) {
                if (a.this.boR.Kh()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    imSendMsgData.isQuick = z;
                    imSendMsgData.isOut = true;
                    Log.i("i", "@@@ localText nmpanctr sdhdl cmd");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
                    a.this.boN.setClicked(true);
                    if (!z && a.this.boM != null) {
                        a.this.boM.Ma();
                    }
                } else if (!z) {
                    Log.i("i", "@@@ localText nmpanctr sdhdl nolg");
                    a.this.boR.Ki();
                }
                if (z) {
                    a.this.boR.hb(str);
                }
            }
        }
    };
    private Runnable boX = new Runnable() { // from class: com.baidu.live.im.c.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.boL.cA(a.this.boQ);
        }
    };

    public void co(boolean z) {
        this.boQ = z;
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.boL = new ALaImMsgView(tbPageContext.getPageActivity());
        this.boL.setPageContext(this.mPageContext);
        this.boL.setNeedTopAlphaShade(true);
        this.boL.setMode(false);
        this.boN = new com.baidu.live.im.view.a(tbPageContext);
        this.boN.a(this.boW);
        this.boN.getView().setId(a.f.quick_input_header);
        this.boL.setView(this.boN);
        this.boM = new ALALiveTextView(tbPageContext.getPageActivity(), tbPageContext);
        this.boM.setMsHandler(this.boV);
        this.boM.setBdPageContext(tbPageContext);
        this.boO = new ArrayList();
        this.boP = new ArrayList();
        this.boO.add("allin");
    }

    @Override // com.baidu.live.im.k
    public void a(ViewGroup viewGroup, ab abVar, List<String> list, RelativeLayout.LayoutParams layoutParams) {
        if (viewGroup != null && this.mPageContext != null && abVar != null && this.boN.getView() != null && viewGroup.indexOfChild(this.boN.getView()) < 0) {
            viewGroup.addView(this.boN.getView(), layoutParams);
            this.boN.Z(list);
            this.boN.Mk();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913272, true));
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_QUICK_SHOW).setContentExt(null, null, null));
        }
    }

    @Override // com.baidu.live.im.k
    public void setFromMaster(boolean z) {
        this.aVn = z;
        if (this.boL != null) {
            this.boL.setFromMaster(z);
        }
        if (this.boM != null) {
            this.boM.setFromMaster(z);
        }
        if (this.boN != null) {
            this.boN.setFromMaster(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<com.baidu.live.im.data.b> list, boolean z) {
        if (this.boL != null) {
            boolean aa = this.boL.aa(list);
            this.boL.setMsgData(list);
            if (aa) {
                this.boL.Mn();
                if (z) {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.c.a.9
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.boL.Kc();
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
            if ("enter_live".equals(str) && com.baidu.live.entereffect.a.CV().h(bVar)) {
                this.boL.H(bVar);
            }
        }
    }

    @Override // com.baidu.live.im.k
    public j Kd() {
        return this.boL;
    }

    @Override // com.baidu.live.im.k
    public com.baidu.live.view.input.a Ke() {
        return this.boM;
    }

    @Override // com.baidu.live.im.k
    public com.baidu.live.view.input.b Kf() {
        return this.boN;
    }

    @Override // com.baidu.live.im.k
    public void setLogData(String str, String str2) {
        if (this.boM != null) {
            this.boM.setLogData(str, str2);
        }
        if (this.boL != null) {
            this.boL.setLogData(str, str2);
        }
        if (this.boN != null) {
            this.boN.setLogData(str, str2);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(String str, String str2, String str3, String str4, String str5, boolean z, String str6) {
        MessageManager.getInstance().registerListener(this.blG);
        MessageManager.getInstance().registerListener(this.blH);
        MessageManager.getInstance().registerListener(this.boS);
        MessageManager.getInstance().registerListener(this.boT);
        MessageManager.getInstance().registerListener(this.boU);
        this.boL.Jg();
        this.boL.a(str, str4, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str3), str3, str6);
        this.boL.cA(this.boQ);
        h(str4, str3, z);
        MessageManager.getInstance().registerListener(this.boM.boE);
        MessageManager.getInstance().registerListener(this.boM.bgy);
        MessageManager.getInstance().registerListener(this.boN.boE);
        MessageManager.getInstance().registerListener(this.boN.bgy);
        MessageManager.getInstance().registerListener(this.boN.bqY);
    }

    @Override // com.baidu.live.im.k
    public void zR() {
        MessageManager.getInstance().unRegisterListener(this.blG);
        MessageManager.getInstance().unRegisterListener(this.blH);
        MessageManager.getInstance().unRegisterListener(this.boS);
        MessageManager.getInstance().unRegisterListener(this.boT);
        if (this.boL != null) {
            this.boL.KJ();
        }
        if (this.boM != null) {
            this.boM.Ma();
            MessageManager.getInstance().unRegisterListener(this.boM.boE);
            MessageManager.getInstance().unRegisterListener(this.boM.bgy);
        }
        if (this.boN != null) {
            MessageManager.getInstance().unRegisterListener(this.boN.boE);
            MessageManager.getInstance().unRegisterListener(this.boN.bgy);
            MessageManager.getInstance().unRegisterListener(this.boN.bqY);
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        LiveTimerManager.getInstance().removeLiveTimerTask("live_show_tag_view", true);
        SafeHandler.getInst().removeCallbacks(this.boX);
        MessageManager.getInstance().unRegisterListener(this.boU);
    }

    @Override // com.baidu.live.im.k
    public void g(Map<String, Integer> map) {
        if (this.boM != null) {
            this.boM.g(map);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(k.a aVar) {
        this.boR = aVar;
    }

    @Override // com.baidu.live.im.k
    public void a(boolean z, int i, int i2, String str) {
        if (this.boM != null) {
            this.boM.b(z, i, i2, str);
        }
        if (this.boN != null) {
            this.boN.b(z, i, i2, str);
        }
    }

    @Override // com.baidu.live.im.k
    public void onDestroy() {
        a((k.a) null);
        if (Ke() != null) {
            Ke().destroy();
        }
    }

    @Override // com.baidu.live.im.k
    public View getTextView() {
        if (Ke() == null) {
            return null;
        }
        return Ke().getTextView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(List<com.baidu.live.im.data.b> list) {
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            if (this.aVn) {
                if (ListUtils.isEmpty(this.boO)) {
                    return;
                }
            } else if (ListUtils.isEmpty(this.boP)) {
                return;
            }
            for (com.baidu.live.im.data.b bVar : list) {
                if (bVar != null && (bVar.getMsgType() == 13 || bVar.getMsgType() == 26 || bVar.getMsgType() == 27 || bVar.getMsgType() == 12)) {
                    if (this.aVn) {
                        if (this.boO.contains(F(bVar))) {
                            arrayList.add(bVar);
                        }
                    } else if (this.boP.contains(F(bVar))) {
                        arrayList.add(bVar);
                    }
                }
            }
            list.removeAll(arrayList);
        }
    }

    private String F(com.baidu.live.im.data.b bVar) {
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
        if (as.Cm() && z && UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) != 2) {
            LiveTimerManager.getInstance().addLiveTimerTask("live_show_tag_view", Long.valueOf(str).longValue(), new OnLiveTimerListener() { // from class: com.baidu.live.im.c.a.10
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z2) {
                    if (UtilHelper.getRealScreenOrientation(a.this.mPageContext.getPageActivity()) != 2) {
                        a.this.boL.az(str, str2);
                        SafeHandler.getInst().postDelayed(a.this.boX, 10000L);
                    }
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, as.Cn() * 1000, true);
        }
    }

    @Override // com.baidu.live.im.k
    public int getImMsgListViewTop() {
        return this.boL.getImMsgListViewTop();
    }

    @Override // com.baidu.live.im.k
    public int getImMsgListViewHeight() {
        return this.boL.getImMsgListViewHeight();
    }

    @Override // com.baidu.live.im.k
    public int Kg() {
        return this.boL.getWidth();
    }
}
