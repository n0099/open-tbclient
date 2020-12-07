package com.baidu.live.im.c;

import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.am;
import com.baidu.live.data.ci;
import com.baidu.live.data.w;
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
/* loaded from: classes4.dex */
public class a implements k {
    private k.a boA;
    private final ALaImMsgView bou;
    private final ALALiveTextView bov;
    private com.baidu.live.im.view.a bow;
    private List<String> box;
    private List<String> boy;
    private TbPageContext mPageContext;
    private boolean aVr = false;
    public boolean boz = false;
    private CustomMessageListener blv = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.c.a.1
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
    private CustomMessageListener blw = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.c.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b)) {
                com.baidu.live.im.data.b bVar = (com.baidu.live.im.data.b) customResponsedMessage.getData();
                if (!a.this.aVr && bVar != null && (bVar.NU() instanceof com.baidu.live.data.a)) {
                    bVar.NU().aIC = -1;
                }
                a.this.t(bVar);
            }
        }
    };
    private CustomMessageListener boB = new CustomMessageListener(2913044) { // from class: com.baidu.live.im.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener boC = new CustomMessageListener(2913095) { // from class: com.baidu.live.im.c.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.bov != null) {
                    a.this.bov.ij(str);
                }
                if (a.this.bow != null) {
                    a.this.bow.ij(str);
                }
            }
        }
    };
    public CustomMessageListener boD = new CustomMessageListener(2913272) { // from class: com.baidu.live.im.c.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                a.this.ck(booleanValue);
                a.this.bou.cq(booleanValue);
                a.this.bou.setListAlignBottom(!booleanValue);
                a.this.bou.cr(booleanValue);
            }
        }
    };
    private final a.InterfaceC0239a boE = new a.InterfaceC0239a() { // from class: com.baidu.live.im.c.a.7
        @Override // com.baidu.live.view.input.a.InterfaceC0239a
        public boolean Nh() {
            return a.this.boA != null && a.this.boA.Nh();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0239a
        public void t(String str, boolean z) {
            Log.i("i", "@@@ localText nmpanctr sdhdl 1");
            if (a.this.boA != null) {
                if (a.this.boA.Nh()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (a.this.bov != null && a.this.bov.OO()) {
                        ci barrageInfo = a.this.bov.getBarrageInfo();
                        if (barrageInfo != null) {
                            if (barrageInfo.type == 16 && !a.this.boA.Nl()) {
                                BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.h.sdk_throne_disabled_alert);
                                return;
                            } else if (barrageInfo.type == 17 && barrageInfo.aSI > a.this.boA.Nm()) {
                                if (barrageInfo.aSI == 7) {
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
                    if (ig(str) && !z) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (com.baidu.live.ae.a.RB().brA.aOc != null && com.baidu.live.ae.a.RB().brA.aOc.originTexts != null && com.baidu.live.ae.a.RB().brA.aOc.originTexts.size() > 0) {
                                jSONObject.putOpt("msg", com.baidu.live.ae.a.RB().brA.aOc.originTexts.get(0));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "chatsendclk").setContentExt(null, null, jSONObject));
                    }
                    if (!z && a.this.bov != null) {
                        a.this.bov.OS();
                    }
                } else if (!z) {
                    Log.i("i", "@@@ localText nmpanctr sdhdl nolg");
                    a.this.boA.Ni();
                }
                if (z) {
                    a.this.boA.id(str);
                }
            }
        }

        private boolean ig(String str) {
            int i;
            if (str == null || com.baidu.live.ae.a.RB().brA.aOc == null || com.baidu.live.ae.a.RB().brA.aOc.originTexts == null || com.baidu.live.ae.a.RB().brA.aOc.originTexts.size() <= 0) {
                return false;
            }
            char[] charArray = str.toCharArray();
            int length = com.baidu.live.ae.a.RB().brA.aOc.originTexts.get(0).length();
            for (i = 0; i < charArray.length; i = i + 1) {
                i = (charArray[i] == ' ' && (charArray.length - i == length || com.baidu.live.ae.a.RB().brA.aOc.originTexts.get(0).equals(str.substring(i + 1)))) ? 0 : i + 1;
                return true;
            }
            return false;
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0239a
        public void Nj() {
            if (a.this.boA != null) {
                a.this.boA.Nj();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0239a
        public void Nk() {
            if (a.this.boA != null) {
                a.this.boA.Nk();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0239a
        public boolean Nl() {
            return a.this.boA != null && a.this.boA.Nl();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0239a
        public int Nm() {
            if (a.this.boA != null) {
                return a.this.boA.Nm();
            }
            return 0;
        }
    };
    private final b.a boF = new b.a() { // from class: com.baidu.live.im.c.a.8
        @Override // com.baidu.live.view.input.b.a
        public void t(String str, boolean z) {
            Log.i("i", "@@@ localText nmpanctr sdhdl 1");
            if (a.this.boA != null) {
                if (a.this.boA.Nh()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    imSendMsgData.isQuick = z;
                    Log.i("i", "@@@ localText nmpanctr sdhdl cmd");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
                    if (!z && a.this.bov != null) {
                        a.this.bov.OS();
                    }
                } else if (!z) {
                    Log.i("i", "@@@ localText nmpanctr sdhdl nolg");
                    a.this.boA.Ni();
                }
                if (z) {
                    a.this.boA.id(str);
                }
            }
        }
    };
    private Runnable boG = new Runnable() { // from class: com.baidu.live.im.c.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bou.cs(a.this.boz);
        }
    };

    public void ck(boolean z) {
        this.boz = z;
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bou = new ALaImMsgView(tbPageContext.getPageActivity());
        this.bou.setPageContext(this.mPageContext);
        this.bou.setNeedTopAlphaShade(true);
        this.bou.setMode(false);
        this.bow = new com.baidu.live.im.view.a(tbPageContext);
        this.bow.a(this.boF);
        this.bow.getView().setId(a.f.quick_input_header);
        this.bou.setView(this.bow);
        this.bov = new ALALiveTextView(tbPageContext.getPageActivity(), tbPageContext);
        this.bov.setMsHandler(this.boE);
        this.bov.setBdPageContext(tbPageContext);
        this.box = new ArrayList();
        this.boy = new ArrayList();
        this.box.add("allin");
    }

    @Override // com.baidu.live.im.k
    public void a(ViewGroup viewGroup, w wVar, List<String> list, RelativeLayout.LayoutParams layoutParams) {
        if (viewGroup != null && this.mPageContext != null && wVar != null) {
            viewGroup.addView(this.bow.getView(), layoutParams);
            this.bow.Y(list);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913272, true));
        }
    }

    @Override // com.baidu.live.im.k
    public void setFromMaster(boolean z) {
        this.aVr = z;
        if (this.bou != null) {
            this.bou.setFromMaster(z);
        }
        if (this.bov != null) {
            this.bov.setFromMaster(z);
        }
        if (this.bow != null) {
            this.bow.setFromMaster(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<com.baidu.live.im.data.b> list, boolean z) {
        if (this.bou != null) {
            boolean Z = this.bou.Z(list);
            this.bou.setMsgData(list);
            if (Z) {
                this.bou.OZ();
                if (z) {
                    this.bou.postDelayed(new Runnable() { // from class: com.baidu.live.im.c.a.9
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.bou.Nc();
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
            if ("enter_live".equals(str) && com.baidu.live.entereffect.a.Gi().h(bVar)) {
                this.bou.z(bVar);
            }
        }
    }

    @Override // com.baidu.live.im.k
    public j Nd() {
        return this.bou;
    }

    @Override // com.baidu.live.im.k
    public com.baidu.live.view.input.a Ne() {
        return this.bov;
    }

    @Override // com.baidu.live.im.k
    public com.baidu.live.view.input.b Nf() {
        return this.bow;
    }

    @Override // com.baidu.live.im.k
    public void setLogData(String str, String str2) {
        if (this.bov != null) {
            this.bov.setLogData(str, str2);
        }
        if (this.bou != null) {
            this.bou.setLogData(str, str2);
        }
        if (this.bow != null) {
            this.bow.setLogData(str, str2);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(String str, String str2, String str3, String str4, String str5, boolean z, String str6) {
        MessageManager.getInstance().registerListener(this.blv);
        MessageManager.getInstance().registerListener(this.blw);
        MessageManager.getInstance().registerListener(this.boB);
        MessageManager.getInstance().registerListener(this.boC);
        MessageManager.getInstance().registerListener(this.boD);
        this.bou.Ml();
        this.bou.a(str, str4, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str3), str3, str6);
        this.bou.cs(this.boz);
        g(str4, str3, z);
        MessageManager.getInstance().registerListener(this.bov.bon);
        MessageManager.getInstance().registerListener(this.bov.bgy);
        MessageManager.getInstance().registerListener(this.bow.bon);
        MessageManager.getInstance().registerListener(this.bow.bgy);
    }

    @Override // com.baidu.live.im.k
    public void DN() {
        MessageManager.getInstance().unRegisterListener(this.blv);
        MessageManager.getInstance().unRegisterListener(this.blw);
        MessageManager.getInstance().unRegisterListener(this.boB);
        MessageManager.getInstance().unRegisterListener(this.boC);
        if (this.bou != null) {
            this.bou.OI();
        }
        if (this.bov != null) {
            this.bov.OS();
            MessageManager.getInstance().unRegisterListener(this.bov.bon);
            MessageManager.getInstance().unRegisterListener(this.bov.bgy);
        }
        if (this.bow != null) {
            MessageManager.getInstance().unRegisterListener(this.bow.bon);
            MessageManager.getInstance().unRegisterListener(this.bow.bgy);
        }
        LiveTimerManager.getInstance().removeLiveTimerTask("live_show_tag_view", true);
        SafeHandler.getInst().removeCallbacks(this.boG);
        MessageManager.getInstance().unRegisterListener(this.boD);
    }

    @Override // com.baidu.live.im.k
    public void g(Map<String, Integer> map) {
        if (this.bov != null) {
            this.bov.g(map);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(k.a aVar) {
        this.boA = aVar;
    }

    @Override // com.baidu.live.im.k
    public void a(boolean z, int i, int i2, String str) {
        if (this.bov != null) {
            this.bov.b(z, i, i2, str);
        }
        if (this.bow != null) {
            this.bow.b(z, i, i2, str);
        }
    }

    @Override // com.baidu.live.im.k
    public void onDestroy() {
        a((k.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(List<com.baidu.live.im.data.b> list) {
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            if (this.aVr) {
                if (ListUtils.isEmpty(this.box)) {
                    return;
                }
            } else if (ListUtils.isEmpty(this.boy)) {
                return;
            }
            for (com.baidu.live.im.data.b bVar : list) {
                if (bVar != null && (bVar.getMsgType() == 13 || bVar.getMsgType() == 26 || bVar.getMsgType() == 27 || bVar.getMsgType() == 12)) {
                    if (this.aVr) {
                        if (this.box.contains(x(bVar))) {
                            arrayList.add(bVar);
                        }
                    } else if (this.boy.contains(x(bVar))) {
                        arrayList.add(bVar);
                    }
                }
            }
            list.removeAll(arrayList);
        }
    }

    private String x(com.baidu.live.im.data.b bVar) {
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

    private void g(final String str, final String str2, boolean z) {
        if (am.FE() && z && UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) != 2) {
            LiveTimerManager.getInstance().addLiveTimerTask("live_show_tag_view", Long.valueOf(str).longValue(), new OnLiveTimerListener() { // from class: com.baidu.live.im.c.a.10
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z2) {
                    if (UtilHelper.getRealScreenOrientation(a.this.mPageContext.getPageActivity()) != 2) {
                        a.this.bou.aC(str, str2);
                        SafeHandler.getInst().postDelayed(a.this.boG, 10000L);
                    }
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, am.FF() * 1000, true);
        }
    }

    @Override // com.baidu.live.im.k
    public int getImMsgListViewTop() {
        return this.bou.getImMsgListViewTop();
    }

    @Override // com.baidu.live.im.k
    public int getImMsgListViewHeight() {
        return this.bou.getImMsgListViewHeight();
    }

    @Override // com.baidu.live.im.k
    public int Ng() {
        return this.bou.getWidth();
    }
}
