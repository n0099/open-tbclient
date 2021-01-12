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
/* loaded from: classes10.dex */
public class a implements k {
    private final ALaImMsgView blq;
    private final ALALiveTextView blr;
    private com.baidu.live.im.view.a bls;
    private List<String> blt;
    private List<String> blu;
    private k.a blw;
    private TbPageContext mPageContext;
    private boolean aSj = false;
    public boolean blv = false;
    private Handler mHandler = new Handler();
    private CustomMessageListener bio = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.c.a.1
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
    private CustomMessageListener bip = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.c.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b)) {
                com.baidu.live.im.data.b bVar = (com.baidu.live.im.data.b) customResponsedMessage.getData();
                if (!a.this.aSj && bVar != null && (bVar.JB() instanceof com.baidu.live.data.a)) {
                    bVar.JB().aEl = -1;
                }
                a.this.t(bVar);
            }
        }
    };
    private CustomMessageListener blx = new CustomMessageListener(2913044) { // from class: com.baidu.live.im.c.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener bly = new CustomMessageListener(2913095) { // from class: com.baidu.live.im.c.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.blr != null) {
                    a.this.blr.gJ(str);
                }
                if (a.this.bls != null) {
                    a.this.bls.gJ(str);
                }
            }
        }
    };
    public CustomMessageListener blz = new CustomMessageListener(2913272) { // from class: com.baidu.live.im.c.a.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                a.this.cg(booleanValue);
                a.this.blq.cp(booleanValue);
                a.this.blq.setListAlignBottom(!booleanValue);
                a.this.blq.cq(booleanValue);
            }
        }
    };
    private final a.InterfaceC0230a blA = new a.InterfaceC0230a() { // from class: com.baidu.live.im.c.a.7
        @Override // com.baidu.live.view.input.a.InterfaceC0230a
        public boolean IJ() {
            return a.this.blw != null && a.this.blw.IJ();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0230a
        public void t(String str, boolean z) {
            Log.i("i", "@@@ localText nmpanctr sdhdl 1");
            if (a.this.blw != null) {
                a.this.bls.setClicked(true);
                if (a.this.blw.IJ()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (a.this.blr != null && a.this.blr.Ky()) {
                        ck barrageInfo = a.this.blr.getBarrageInfo();
                        if (barrageInfo != null) {
                            if (barrageInfo.type == 16 && !a.this.blw.IO()) {
                                BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.h.sdk_throne_disabled_alert);
                                return;
                            } else if (barrageInfo.type == 17 && barrageInfo.aOT > a.this.blw.IP()) {
                                if (barrageInfo.aOT == 7) {
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
                    if (gG(str) && !z) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (com.baidu.live.af.a.OJ().bru.aJT != null && com.baidu.live.af.a.OJ().bru.aJT.originTexts != null && com.baidu.live.af.a.OJ().bru.aJT.originTexts.size() > 0) {
                                jSONObject.putOpt("msg", com.baidu.live.af.a.OJ().bru.aJT.originTexts.get(0));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "chatsendclk").setContentExt(null, null, jSONObject));
                    }
                    if (!z && a.this.blr != null) {
                        a.this.blr.KC();
                    }
                } else if (!z) {
                    Log.i("i", "@@@ localText nmpanctr sdhdl nolg");
                    a.this.blw.IK();
                }
                if (z) {
                    a.this.blw.gD(str);
                }
            }
        }

        private boolean gG(String str) {
            int i;
            if (str == null || com.baidu.live.af.a.OJ().bru.aJT == null || com.baidu.live.af.a.OJ().bru.aJT.originTexts == null || com.baidu.live.af.a.OJ().bru.aJT.originTexts.size() <= 0) {
                return false;
            }
            char[] charArray = str.toCharArray();
            int length = com.baidu.live.af.a.OJ().bru.aJT.originTexts.get(0).length();
            for (i = 0; i < charArray.length; i = i + 1) {
                i = (charArray[i] == ' ' && (charArray.length - i == length || com.baidu.live.af.a.OJ().bru.aJT.originTexts.get(0).equals(str.substring(i + 1)))) ? 0 : i + 1;
                return true;
            }
            return false;
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0230a
        public void IL() {
            if (a.this.blw != null) {
                a.this.blw.IL();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0230a
        public void IM() {
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0230a
        public void IN() {
            if (a.this.blw != null) {
                a.this.blw.IN();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0230a
        public boolean IO() {
            return a.this.blw != null && a.this.blw.IO();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0230a
        public int IP() {
            if (a.this.blw != null) {
                return a.this.blw.IP();
            }
            return 0;
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0230a
        public boolean IQ() {
            if (a.this.blw != null) {
                return a.this.blw.IQ();
            }
            return false;
        }
    };
    private final b.a blB = new b.a() { // from class: com.baidu.live.im.c.a.8
        @Override // com.baidu.live.view.input.b.a
        public void t(String str, boolean z) {
            Log.i("i", "@@@ localText nmpanctr sdhdl 1");
            if (a.this.blw != null) {
                if (a.this.blw.IJ()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    imSendMsgData.isQuick = z;
                    imSendMsgData.isOut = true;
                    Log.i("i", "@@@ localText nmpanctr sdhdl cmd");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
                    a.this.bls.setClicked(true);
                    if (!z && a.this.blr != null) {
                        a.this.blr.KC();
                    }
                } else if (!z) {
                    Log.i("i", "@@@ localText nmpanctr sdhdl nolg");
                    a.this.blw.IK();
                }
                if (z) {
                    a.this.blw.gD(str);
                }
            }
        }
    };
    private Runnable blC = new Runnable() { // from class: com.baidu.live.im.c.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.blq.cr(a.this.blv);
        }
    };

    public void cg(boolean z) {
        this.blv = z;
    }

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.blq = new ALaImMsgView(tbPageContext.getPageActivity());
        this.blq.setPageContext(this.mPageContext);
        this.blq.setNeedTopAlphaShade(true);
        this.blq.setMode(false);
        this.bls = new com.baidu.live.im.view.a(tbPageContext);
        this.bls.a(this.blB);
        this.bls.getView().setId(a.f.quick_input_header);
        this.blq.setView(this.bls);
        this.blr = new ALALiveTextView(tbPageContext.getPageActivity(), tbPageContext);
        this.blr.setMsHandler(this.blA);
        this.blr.setBdPageContext(tbPageContext);
        this.blt = new ArrayList();
        this.blu = new ArrayList();
        this.blt.add("allin");
    }

    @Override // com.baidu.live.im.k
    public void a(ViewGroup viewGroup, x xVar, List<String> list, RelativeLayout.LayoutParams layoutParams) {
        if (viewGroup != null && this.mPageContext != null && xVar != null && this.bls.getView() != null && viewGroup.indexOfChild(this.bls.getView()) < 0) {
            viewGroup.addView(this.bls.getView(), layoutParams);
            this.bls.Y(list);
            this.bls.KM();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913272, true));
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_QUICK_SHOW).setContentExt(null, null, null));
        }
    }

    @Override // com.baidu.live.im.k
    public void setFromMaster(boolean z) {
        this.aSj = z;
        if (this.blq != null) {
            this.blq.setFromMaster(z);
        }
        if (this.blr != null) {
            this.blr.setFromMaster(z);
        }
        if (this.bls != null) {
            this.bls.setFromMaster(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<com.baidu.live.im.data.b> list, boolean z) {
        if (this.blq != null) {
            boolean Z = this.blq.Z(list);
            this.blq.setMsgData(list);
            if (Z) {
                this.blq.KP();
                if (z) {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.c.a.9
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.blq.IE();
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
            if ("enter_live".equals(str) && com.baidu.live.entereffect.a.BG().h(bVar)) {
                this.blq.B(bVar);
            }
        }
    }

    @Override // com.baidu.live.im.k
    public j IF() {
        return this.blq;
    }

    @Override // com.baidu.live.im.k
    public com.baidu.live.view.input.a IG() {
        return this.blr;
    }

    @Override // com.baidu.live.im.k
    public com.baidu.live.view.input.b IH() {
        return this.bls;
    }

    @Override // com.baidu.live.im.k
    public void setLogData(String str, String str2) {
        if (this.blr != null) {
            this.blr.setLogData(str, str2);
        }
        if (this.blq != null) {
            this.blq.setLogData(str, str2);
        }
        if (this.bls != null) {
            this.bls.setLogData(str, str2);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(String str, String str2, String str3, String str4, String str5, boolean z, String str6) {
        MessageManager.getInstance().registerListener(this.bio);
        MessageManager.getInstance().registerListener(this.bip);
        MessageManager.getInstance().registerListener(this.blx);
        MessageManager.getInstance().registerListener(this.bly);
        MessageManager.getInstance().registerListener(this.blz);
        this.blq.HN();
        this.blq.a(str, str4, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str3), str3, str6);
        this.blq.cr(this.blv);
        h(str4, str3, z);
        MessageManager.getInstance().registerListener(this.blr.blj);
        MessageManager.getInstance().registerListener(this.blr.bdo);
        MessageManager.getInstance().registerListener(this.bls.blj);
        MessageManager.getInstance().registerListener(this.bls.bdo);
        MessageManager.getInstance().registerListener(this.bls.bnx);
    }

    @Override // com.baidu.live.im.k
    public void zh() {
        MessageManager.getInstance().unRegisterListener(this.bio);
        MessageManager.getInstance().unRegisterListener(this.bip);
        MessageManager.getInstance().unRegisterListener(this.blx);
        MessageManager.getInstance().unRegisterListener(this.bly);
        if (this.blq != null) {
            this.blq.Jl();
        }
        if (this.blr != null) {
            this.blr.KC();
            MessageManager.getInstance().unRegisterListener(this.blr.blj);
            MessageManager.getInstance().unRegisterListener(this.blr.bdo);
        }
        if (this.bls != null) {
            MessageManager.getInstance().unRegisterListener(this.bls.blj);
            MessageManager.getInstance().unRegisterListener(this.bls.bdo);
            MessageManager.getInstance().unRegisterListener(this.bls.bnx);
        }
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        LiveTimerManager.getInstance().removeLiveTimerTask("live_show_tag_view", true);
        SafeHandler.getInst().removeCallbacks(this.blC);
        MessageManager.getInstance().unRegisterListener(this.blz);
    }

    @Override // com.baidu.live.im.k
    public void g(Map<String, Integer> map) {
        if (this.blr != null) {
            this.blr.g(map);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(k.a aVar) {
        this.blw = aVar;
    }

    @Override // com.baidu.live.im.k
    public void a(boolean z, int i, int i2, String str) {
        if (this.blr != null) {
            this.blr.b(z, i, i2, str);
        }
        if (this.bls != null) {
            this.bls.b(z, i, i2, str);
        }
    }

    @Override // com.baidu.live.im.k
    public void onDestroy() {
        a((k.a) null);
        if (IG() != null) {
            IG().destroy();
        }
    }

    @Override // com.baidu.live.im.k
    public View getTextView() {
        if (IG() == null) {
            return null;
        }
        return IG().getTextView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(List<com.baidu.live.im.data.b> list) {
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            if (this.aSj) {
                if (ListUtils.isEmpty(this.blt)) {
                    return;
                }
            } else if (ListUtils.isEmpty(this.blu)) {
                return;
            }
            for (com.baidu.live.im.data.b bVar : list) {
                if (bVar != null && (bVar.getMsgType() == 13 || bVar.getMsgType() == 26 || bVar.getMsgType() == 27 || bVar.getMsgType() == 12)) {
                    if (this.aSj) {
                        if (this.blt.contains(z(bVar))) {
                            arrayList.add(bVar);
                        }
                    } else if (this.blu.contains(z(bVar))) {
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
        if (ao.AZ() && z && UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) != 2) {
            LiveTimerManager.getInstance().addLiveTimerTask("live_show_tag_view", Long.valueOf(str).longValue(), new OnLiveTimerListener() { // from class: com.baidu.live.im.c.a.10
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z2) {
                    if (UtilHelper.getRealScreenOrientation(a.this.mPageContext.getPageActivity()) != 2) {
                        a.this.blq.az(str, str2);
                        SafeHandler.getInst().postDelayed(a.this.blC, 10000L);
                    }
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, ao.Ba() * 1000, true);
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
    public int II() {
        return this.blq.getWidth();
    }
}
