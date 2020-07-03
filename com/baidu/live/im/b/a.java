package com.baidu.live.im.b;

import android.util.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.aa;
import com.baidu.live.data.bo;
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
/* loaded from: classes3.dex */
public class a implements k {
    private boolean aGc = false;
    private CustomMessageListener aTq = new CustomMessageListener(2913038) { // from class: com.baidu.live.im.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                List list = (List) customResponsedMessage.getData();
                a.this.O(list);
                a.this.d(list, true);
            }
        }
    };
    private CustomMessageListener aTr = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.b.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (!a.this.aGc && aVar != null && (aVar.Ed() instanceof com.baidu.live.data.a)) {
                    aVar.Ed().awC = -1;
                }
                a.this.k(aVar);
            }
        }
    };
    private CustomMessageListener aVA = new CustomMessageListener(2913044) { // from class: com.baidu.live.im.b.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener aVB = new CustomMessageListener(2913095) { // from class: com.baidu.live.im.b.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.aVw != null) {
                    a.this.aVw.fz(str);
                }
            }
        }
    };
    private final a.InterfaceC0190a aVC = new a.InterfaceC0190a() { // from class: com.baidu.live.im.b.a.5
        @Override // com.baidu.live.view.input.a.InterfaceC0190a
        public boolean Dd() {
            return a.this.aVz != null && a.this.aVz.Dd();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0190a
        public void r(String str, boolean z) {
            Log.i("i", "@@@ localText nmpanctr sdhdl 1");
            if (a.this.aVz != null) {
                if (a.this.aVz.Dd()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (a.this.aVw != null && a.this.aVw.EK()) {
                        bo barrageInfo = a.this.aVw.getBarrageInfo();
                        if (barrageInfo != null) {
                            if (barrageInfo.type == 16 && !a.this.aVz.Dh()) {
                                BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.i.sdk_throne_disabled_alert);
                                return;
                            } else if (barrageInfo.type == 17 && barrageInfo.aEn > a.this.aVz.Di()) {
                                if (barrageInfo.aEn == 7) {
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
                    if (!z && a.this.aVw != null) {
                        a.this.aVw.EO();
                    }
                } else if (!z) {
                    Log.i("i", "@@@ localText nmpanctr sdhdl nolg");
                    a.this.aVz.De();
                }
                if (z) {
                    a.this.aVz.fw(str);
                }
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0190a
        public void Df() {
            if (a.this.aVz != null) {
                a.this.aVz.Df();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0190a
        public void Dg() {
            if (a.this.aVz != null) {
                a.this.aVz.Dg();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0190a
        public boolean Dh() {
            return a.this.aVz != null && a.this.aVz.Dh();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0190a
        public int Di() {
            if (a.this.aVz != null) {
                return a.this.aVz.Di();
            }
            return 0;
        }
    };
    private Runnable aVD = new Runnable() { // from class: com.baidu.live.im.b.a.8
        @Override // java.lang.Runnable
        public void run() {
            a.this.aVv.EV();
        }
    };
    private final ALaImMsgView aVv;
    private final ALALiveTextView aVw;
    private List<String> aVx;
    private List<String> aVy;
    private k.a aVz;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.aVv = new ALaImMsgView(tbPageContext.getPageActivity());
        this.aVv.setPageContext(this.mPageContext);
        this.aVv.setNeedTopAlphaShade(true);
        this.aVv.setMode(false);
        this.aVw = new ALALiveTextView(tbPageContext.getPageActivity());
        this.aVw.setMsHandler(this.aVC);
        this.aVw.setBdPageContext(tbPageContext);
        this.aVx = new ArrayList();
        this.aVy = new ArrayList();
        this.aVx.add("allin");
    }

    @Override // com.baidu.live.im.k
    public void setFromMaster(boolean z) {
        this.aGc = z;
        if (this.aVv != null) {
            this.aVv.setFromMaster(z);
        }
        if (this.aVw != null) {
            this.aVw.setFromMaster(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.aVv != null) {
            boolean Q = this.aVv.Q(list);
            this.aVv.setMsgData(list);
            if (Q) {
                this.aVv.EU();
                if (z) {
                    this.aVv.postDelayed(new Runnable() { // from class: com.baidu.live.im.b.a.6
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.aVv.CZ();
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
            if ("enter_live".equals(str) && com.baidu.live.entereffect.a.xa().a(aVar)) {
                this.aVv.w(aVar);
            }
        }
    }

    @Override // com.baidu.live.im.k
    public j Da() {
        return this.aVv;
    }

    @Override // com.baidu.live.im.k
    public com.baidu.live.view.input.a Db() {
        return this.aVw;
    }

    @Override // com.baidu.live.im.k
    public void setLogData(String str, String str2) {
        if (this.aVw != null) {
            this.aVw.setLogData(str, str2);
        }
        if (this.aVv != null) {
            this.aVv.setLogData(str, str2);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(String str, String str2, String str3, String str4, String str5, boolean z) {
        MessageManager.getInstance().registerListener(this.aTq);
        MessageManager.getInstance().registerListener(this.aTr);
        MessageManager.getInstance().registerListener(this.aVA);
        MessageManager.getInstance().registerListener(this.aVB);
        this.aVv.Dy();
        this.aVv.a(str, str4, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str3), str3);
        e(str4, str3, z);
        MessageManager.getInstance().registerListener(this.aVw.aWc);
        MessageManager.getInstance().registerListener(this.aVw.aPg);
    }

    @Override // com.baidu.live.im.k
    public void Cz() {
        MessageManager.getInstance().unRegisterListener(this.aTq);
        MessageManager.getInstance().unRegisterListener(this.aTr);
        MessageManager.getInstance().unRegisterListener(this.aVA);
        MessageManager.getInstance().unRegisterListener(this.aVB);
        if (this.aVv != null) {
            this.aVv.EE();
        }
        if (this.aVw != null) {
            this.aVw.EO();
            MessageManager.getInstance().unRegisterListener(this.aVw.aWc);
            MessageManager.getInstance().unRegisterListener(this.aVw.aPg);
        }
        LiveTimerManager.getInstance().removeLiveTimerTask("live_show_tag_view", true);
        SafeHandler.getInst().removeCallbacks(this.aVD);
    }

    @Override // com.baidu.live.im.k
    public void f(Map<String, Integer> map) {
        if (this.aVw != null) {
            this.aVw.f(map);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(k.a aVar) {
        this.aVz = aVar;
    }

    @Override // com.baidu.live.im.k
    public void a(boolean z, int i, int i2, String str) {
        if (this.aVw != null) {
            this.aVw.b(z, i, i2, str);
        }
    }

    @Override // com.baidu.live.im.k
    public void onDestroy() {
        a((k.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(List<com.baidu.live.im.data.a> list) {
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            if (this.aGc) {
                if (ListUtils.isEmpty(this.aVx)) {
                    return;
                }
            } else if (ListUtils.isEmpty(this.aVy)) {
                return;
            }
            for (com.baidu.live.im.data.a aVar : list) {
                if (aVar != null && (aVar.getMsgType() == 13 || aVar.getMsgType() == 26 || aVar.getMsgType() == 27 || aVar.getMsgType() == 12)) {
                    if (this.aGc) {
                        if (this.aVx.contains(n(aVar))) {
                            arrayList.add(aVar);
                        }
                    } else if (this.aVy.contains(n(aVar))) {
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
        if (aa.wF() && z && UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) != 2) {
            LiveTimerManager.getInstance().addLiveTimerTask("live_show_tag_view", Long.valueOf(str).longValue(), new OnLiveTimerListener() { // from class: com.baidu.live.im.b.a.7
                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onComplete(boolean z2) {
                    if (UtilHelper.getRealScreenOrientation(a.this.mPageContext.getPageActivity()) != 2) {
                        a.this.aVv.as(str, str2);
                        SafeHandler.getInst().postDelayed(a.this.aVD, 10000L);
                    }
                }

                @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                public void onInterrupt() {
                }
            }, aa.wG() * 1000, true);
        }
    }

    @Override // com.baidu.live.im.k
    public int getImMsgListViewTop() {
        return this.aVv.getImMsgListViewTop();
    }

    @Override // com.baidu.live.im.k
    public int getImMsgListViewHeight() {
        return this.aVv.getImMsgListViewHeight();
    }

    @Override // com.baidu.live.im.k
    public int Dc() {
        return this.aVv.getWidth();
    }
}
