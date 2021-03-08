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
/* loaded from: classes10.dex */
public class a implements k {
    private final ALaImMsgView bql;
    private final ALALiveTextView bqm;
    private com.baidu.live.im.view.a bqn;
    private List<String> bqo;
    private List<String> bqp;
    private k.a bqr;
    private TbPageContext mPageContext;
    private boolean aWN = false;
    public boolean bqq = false;
    private Handler mHandler = new Handler();
    private CustomMessageListener bnh = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.c.a.1
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
    private CustomMessageListener bni = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.c.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b)) {
                com.baidu.live.im.data.b bVar = (com.baidu.live.im.data.b) customResponsedMessage.getData();
                if (!a.this.aWN && bVar != null && (bVar.Lc() instanceof com.baidu.live.data.a)) {
                    bVar.Lc().aHy = -1;
                }
                a.this.t(bVar);
            }
        }
    };
    private CustomMessageListener bqs = new CustomMessageListener(2913044) { // from class: com.baidu.live.im.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener bqt = new CustomMessageListener(2913095) { // from class: com.baidu.live.im.c.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.bqm != null) {
                    a.this.bqm.ho(str);
                }
                if (a.this.bqn != null) {
                    a.this.bqn.ho(str);
                }
            }
        }
    };
    public CustomMessageListener bqu = new CustomMessageListener(2913272) { // from class: com.baidu.live.im.c.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                a.this.co(booleanValue);
                a.this.bql.cy(booleanValue);
                a.this.bql.setListAlignBottom(!booleanValue);
                a.this.bql.cz(booleanValue);
            }
        }
    };
    private final a.InterfaceC0238a bqv = new a.InterfaceC0238a() { // from class: com.baidu.live.im.c.a.7
        @Override // com.baidu.live.view.input.a.InterfaceC0238a
        public boolean Kk() {
            return a.this.bqr != null && a.this.bqr.Kk();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0238a
        public void t(String str, boolean z) {
            Log.i("i", "@@@ localText nmpanctr sdhdl 1");
            if (a.this.bqr != null) {
                a.this.bqn.setClicked(true);
                if (a.this.bqr.Kk()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (a.this.bqm != null && a.this.bqm.LZ()) {
                        cr barrageInfo = a.this.bqm.getBarrageInfo();
                        if (barrageInfo != null) {
                            if (barrageInfo.type == 16 && !a.this.bqr.Kp()) {
                                BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.h.sdk_throne_disabled_alert);
                                return;
                            } else if (barrageInfo.type == 17 && barrageInfo.aTv > a.this.bqr.Kq()) {
                                if (barrageInfo.aTv == 7) {
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
                    if (hl(str) && !z) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (com.baidu.live.ae.a.Qm().bwx.aOe != null && com.baidu.live.ae.a.Qm().bwx.aOe.originTexts != null && com.baidu.live.ae.a.Qm().bwx.aOe.originTexts.size() > 0) {
                                jSONObject.putOpt("msg", com.baidu.live.ae.a.Qm().bwx.aOe.originTexts.get(0));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "chatsendclk").setContentExt(null, null, jSONObject));
                    }
                    if (!z && a.this.bqm != null) {
                        a.this.bqm.Md();
                    }
                } else if (!z) {
                    Log.i("i", "@@@ localText nmpanctr sdhdl nolg");
                    a.this.bqr.Kl();
                }
                if (z) {
                    a.this.bqr.hh(str);
                }
            }
        }

        private boolean hl(String str) {
            int i;
            if (str == null || com.baidu.live.ae.a.Qm().bwx.aOe == null || com.baidu.live.ae.a.Qm().bwx.aOe.originTexts == null || com.baidu.live.ae.a.Qm().bwx.aOe.originTexts.size() <= 0) {
                return false;
            }
            char[] charArray = str.toCharArray();
            int length = com.baidu.live.ae.a.Qm().bwx.aOe.originTexts.get(0).length();
            for (i = 0; i < charArray.length; i = i + 1) {
                i = (charArray[i] == ' ' && (charArray.length - i == length || com.baidu.live.ae.a.Qm().bwx.aOe.originTexts.get(0).equals(str.substring(i + 1)))) ? 0 : i + 1;
                return true;
            }
            return false;
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0238a
        public void Km() {
            if (a.this.bqr != null) {
                a.this.bqr.Km();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0238a
        public void Kn() {
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0238a
        public void Ko() {
            if (a.this.bqr != null) {
                a.this.bqr.Ko();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0238a
        public boolean Kp() {
            return a.this.bqr != null && a.this.bqr.Kp();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0238a
        public int Kq() {
            if (a.this.bqr != null) {
                return a.this.bqr.Kq();
            }
            return 0;
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0238a
        public boolean Kr() {
            if (a.this.bqr != null) {
                return a.this.bqr.Kr();
            }
            return false;
        }
    };
    private final b.a bqw = new b.a() { // from class: com.baidu.live.im.c.a.8
        @Override // com.baidu.live.view.input.b.a
        public void t(String str, boolean z) {
            Log.i("i", "@@@ localText nmpanctr sdhdl 1");
            if (a.this.bqr != null) {
                if (a.this.bqr.Kk()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    imSendMsgData.isQuick = z;
                    imSendMsgData.isOut = true;
                    Log.i("i", "@@@ localText nmpanctr sdhdl cmd");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
                    a.this.bqn.setClicked(true);
                    if (!z && a.this.bqm != null) {
                        a.this.bqm.Md();
                    }
                } else if (!z) {
                    Log.i("i", "@@@ localText nmpanctr sdhdl nolg");
                    a.this.bqr.Kl();
                }
                if (z) {
                    a.this.bqr.hh(str);
                }
            }
        }
    };
    private Runnable bqx = new Runnable() { // from class: com.baidu.live.im.c.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bql.cA(a.this.bqq);
        }
    };

    public void co(boolean z) {
        this.bqq = z;
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bql = new ALaImMsgView(tbPageContext.getPageActivity());
        this.bql.setPageContext(this.mPageContext);
        this.bql.setNeedTopAlphaShade(true);
        this.bql.setMode(false);
        this.bqn = new com.baidu.live.im.view.a(tbPageContext);
        this.bqn.a(this.bqw);
        this.bqn.getView().setId(a.f.quick_input_header);
        this.bql.setView(this.bqn);
        this.bqm = new ALALiveTextView(tbPageContext.getPageActivity(), tbPageContext);
        this.bqm.setMsHandler(this.bqv);
        this.bqm.setBdPageContext(tbPageContext);
        this.bqo = new ArrayList();
        this.bqp = new ArrayList();
        this.bqo.add("allin");
    }

    @Override // com.baidu.live.im.k
    public void a(ViewGroup viewGroup, ab abVar, List<String> list, RelativeLayout.LayoutParams layoutParams) {
        if (viewGroup != null && this.mPageContext != null && abVar != null && this.bqn.getView() != null && viewGroup.indexOfChild(this.bqn.getView()) < 0) {
            viewGroup.addView(this.bqn.getView(), layoutParams);
            this.bqn.Z(list);
            this.bqn.Mn();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913272, true));
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_QUICK_SHOW).setContentExt(null, null, null));
        }
    }

    @Override // com.baidu.live.im.k
    public void setFromMaster(boolean z) {
        this.aWN = z;
        if (this.bql != null) {
            this.bql.setFromMaster(z);
        }
        if (this.bqm != null) {
            this.bqm.setFromMaster(z);
        }
        if (this.bqn != null) {
            this.bqn.setFromMaster(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<com.baidu.live.im.data.b> list, boolean z) {
        if (this.bql != null) {
            boolean aa = this.bql.aa(list);
            this.bql.setMsgData(list);
            if (aa) {
                this.bql.Mq();
                if (z) {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.c.a.9
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.bql.Kf();
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
            if ("enter_live".equals(str) && com.baidu.live.entereffect.a.CY().h(bVar)) {
                this.bql.H(bVar);
            }
        }
    }

    @Override // com.baidu.live.im.k
    public j Kg() {
        return this.bql;
    }

    @Override // com.baidu.live.im.k
    public com.baidu.live.view.input.a Kh() {
        return this.bqm;
    }

    @Override // com.baidu.live.im.k
    public com.baidu.live.view.input.b Ki() {
        return this.bqn;
    }

    @Override // com.baidu.live.im.k
    public void setLogData(String str, String str2) {
        if (this.bqm != null) {
            this.bqm.setLogData(str, str2);
        }
        if (this.bql != null) {
            this.bql.setLogData(str, str2);
        }
        if (this.bqn != null) {
            this.bqn.setLogData(str, str2);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(String str, String str2, String str3, String str4, String str5, boolean z, String str6) {
        MessageManager.getInstance().registerListener(this.bnh);
        MessageManager.getInstance().registerListener(this.bni);
        MessageManager.getInstance().registerListener(this.bqs);
        MessageManager.getInstance().registerListener(this.bqt);
        MessageManager.getInstance().registerListener(this.bqu);
        this.bql.Jj();
        this.bql.a(str, str4, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str3), str3, str6);
        this.bql.cA(this.bqq);
        h(str4, str3, z);
        MessageManager.getInstance().registerListener(this.bqm.bqe);
        MessageManager.getInstance().registerListener(this.bqm.bhY);
        MessageManager.getInstance().registerListener(this.bqn.bqe);
        MessageManager.getInstance().registerListener(this.bqn.bhY);
        MessageManager.getInstance().registerListener(this.bqn.bsy);
    }

    @Override // com.baidu.live.im.k
    public void zU() {
        MessageManager.getInstance().unRegisterListener(this.bnh);
        MessageManager.getInstance().unRegisterListener(this.bni);
        MessageManager.getInstance().unRegisterListener(this.bqs);
        MessageManager.getInstance().unRegisterListener(this.bqt);
        if (this.bql != null) {
            this.bql.KM();
        }
        if (this.bqm != null) {
            this.bqm.Md();
            MessageManager.getInstance().unRegisterListener(this.bqm.bqe);
            MessageManager.getInstance().unRegisterListener(this.bqm.bhY);
        }
        if (this.bqn != null) {
            MessageManager.getInstance().unRegisterListener(this.bqn.bqe);
            MessageManager.getInstance().unRegisterListener(this.bqn.bhY);
            MessageManager.getInstance().unRegisterListener(this.bqn.bsy);
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        LiveTimerManager.getInstance().removeLiveTimerTask("live_show_tag_view", true);
        SafeHandler.getInst().removeCallbacks(this.bqx);
        MessageManager.getInstance().unRegisterListener(this.bqu);
    }

    @Override // com.baidu.live.im.k
    public void g(Map<String, Integer> map) {
        if (this.bqm != null) {
            this.bqm.g(map);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(k.a aVar) {
        this.bqr = aVar;
    }

    @Override // com.baidu.live.im.k
    public void a(boolean z, int i, int i2, String str) {
        if (this.bqm != null) {
            this.bqm.b(z, i, i2, str);
        }
        if (this.bqn != null) {
            this.bqn.b(z, i, i2, str);
        }
    }

    @Override // com.baidu.live.im.k
    public void onDestroy() {
        a((k.a) null);
        if (Kh() != null) {
            Kh().destroy();
        }
    }

    @Override // com.baidu.live.im.k
    public View getTextView() {
        if (Kh() == null) {
            return null;
        }
        return Kh().getTextView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(List<com.baidu.live.im.data.b> list) {
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            if (this.aWN) {
                if (ListUtils.isEmpty(this.bqo)) {
                    return;
                }
            } else if (ListUtils.isEmpty(this.bqp)) {
                return;
            }
            for (com.baidu.live.im.data.b bVar : list) {
                if (bVar != null && (bVar.getMsgType() == 13 || bVar.getMsgType() == 26 || bVar.getMsgType() == 27 || bVar.getMsgType() == 12)) {
                    if (this.aWN) {
                        if (this.bqo.contains(F(bVar))) {
                            arrayList.add(bVar);
                        }
                    } else if (this.bqp.contains(F(bVar))) {
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
        if (as.Cp() && z && UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) != 2) {
            LiveTimerManager.getInstance().addLiveTimerTask("live_show_tag_view", Long.valueOf(str).longValue(), new OnLiveTimerListener() { // from class: com.baidu.live.im.c.a.10
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z2) {
                    if (UtilHelper.getRealScreenOrientation(a.this.mPageContext.getPageActivity()) != 2) {
                        a.this.bql.az(str, str2);
                        SafeHandler.getInst().postDelayed(a.this.bqx, 10000L);
                    }
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, as.Cq() * 1000, true);
        }
    }

    @Override // com.baidu.live.im.k
    public int getImMsgListViewTop() {
        return this.bql.getImMsgListViewTop();
    }

    @Override // com.baidu.live.im.k
    public int getImMsgListViewHeight() {
        return this.bql.getImMsgListViewHeight();
    }

    @Override // com.baidu.live.im.k
    public int Kj() {
        return this.bql.getWidth();
    }
}
