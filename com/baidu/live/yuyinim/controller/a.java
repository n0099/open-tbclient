package com.baidu.live.yuyinim.controller;

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
import com.baidu.live.data.cr;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.data.b;
import com.baidu.live.im.j;
import com.baidu.live.im.k;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.timer.LiveTimerManager;
import com.baidu.live.tieba.view.AlaEmoticonView;
import com.baidu.live.view.input.a;
import com.baidu.live.yuyinim.view.ALALiveTextView;
import com.baidu.live.yuyinim.view.ALaImMsgView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements k {
    private List<String> boO;
    private List<String> boP;
    private k.a boR;
    private final ALaImMsgView ccY;
    private final ALALiveTextView ccZ;
    private String mGroupId;
    private TbPageContext mPageContext;
    private boolean aVn = false;
    private Set<Long> cda = new HashSet();
    private CustomMessageListener blG = new CustomMessageListener(2913038) { // from class: com.baidu.live.yuyinim.controller.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                List list = (List) customResponsedMessage.getData();
                a.this.X(list);
                List av = a.this.av(list);
                a.this.d(list, true);
                a.this.i(list, av);
            }
        }
    };
    private CustomMessageListener blH = new CustomMessageListener(2913037) { // from class: com.baidu.live.yuyinim.controller.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof b)) {
                b bVar = (b) customResponsedMessage.getData();
                if (!a.this.aVn && bVar != null && (bVar.KZ() instanceof com.baidu.live.data.a)) {
                    bVar.KZ().aFY = -1;
                }
                a.this.t(bVar);
            }
        }
    };
    private CustomMessageListener boS = new CustomMessageListener(2913044) { // from class: com.baidu.live.yuyinim.controller.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener boT = new CustomMessageListener(2913095) { // from class: com.baidu.live.yuyinim.controller.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.ccZ != null) {
                    a.this.ccZ.hi(str);
                }
            }
        }
    };
    private final a.InterfaceC0232a boV = new a.InterfaceC0232a() { // from class: com.baidu.live.yuyinim.controller.a.6
        @Override // com.baidu.live.view.input.a.InterfaceC0232a
        public boolean Kh() {
            return a.this.boR != null && a.this.boR.Kh();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0232a
        public void t(String str, boolean z) {
            Log.i("i", "@@@ localText nmpanctr sdhdl 1");
            if (a.this.boR != null) {
                if (a.this.boR.Kh()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (a.this.ccZ != null && a.this.ccZ.LW()) {
                        cr barrageInfo = a.this.ccZ.getBarrageInfo();
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
                    }
                    Log.i("i", "@@@ localText nmpanctr sdhdl cmd");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
                    if (!z && a.this.ccZ != null) {
                        a.this.ccZ.Ma();
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

        @Override // com.baidu.live.view.input.a.InterfaceC0232a
        public void Kj() {
            if (a.this.boR != null) {
                a.this.boR.Kj();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0232a
        public void Kk() {
            if (a.this.boR != null) {
                a.this.boR.Kk();
            }
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
    private Runnable boX = new Runnable() { // from class: com.baidu.live.yuyinim.controller.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.ccY.ZJ();
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.ccY = new ALaImMsgView(tbPageContext.getPageActivity());
        this.ccY.setPageContext(this.mPageContext);
        this.ccY.setNeedTopAlphaShade(true);
        this.ccY.setMode(false);
        this.ccZ = new ALALiveTextView(tbPageContext.getPageActivity(), tbPageContext);
        this.ccZ.setMsHandler(this.boV);
        this.ccZ.setBdPageContext(tbPageContext);
        this.boO = new ArrayList();
        this.boP = new ArrayList();
        this.boO.add("allin");
    }

    @Override // com.baidu.live.im.k
    public void setFromMaster(boolean z) {
        this.aVn = z;
        if (this.ccY != null) {
            this.ccY.setFromMaster(z);
        }
        if (this.ccZ != null) {
            this.ccZ.setFromMaster(z);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(ViewGroup viewGroup, ab abVar, List<String> list, RelativeLayout.LayoutParams layoutParams) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<b> list, boolean z) {
        if (this.ccY != null) {
            boolean aw = this.ccY.aw(list);
            this.ccY.setMsgData(list);
            if (aw) {
                this.ccY.Mn();
                if (z) {
                    this.ccY.postDelayed(new Runnable() { // from class: com.baidu.live.yuyinim.controller.a.7
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.ccY.Kc();
                        }
                    }, 350L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<b> list, b bVar) {
        if (bVar != null && list != null) {
            list.add(bVar);
            if (this.ccY != null) {
                this.ccY.setMsgData(list);
                this.ccY.Mn();
                this.ccY.postDelayed(new Runnable() { // from class: com.baidu.live.yuyinim.controller.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.ccY.Kc();
                    }
                }, 350L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(b bVar) {
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
                this.ccY.H(bVar);
            }
        }
    }

    @Override // com.baidu.live.im.k
    public j Kd() {
        return this.ccY;
    }

    @Override // com.baidu.live.im.k
    public com.baidu.live.view.input.a Ke() {
        return this.ccZ;
    }

    @Override // com.baidu.live.im.k
    public com.baidu.live.view.input.b Kf() {
        return null;
    }

    @Override // com.baidu.live.im.k
    public void setLogData(String str, String str2) {
        if (this.ccZ != null) {
            this.ccZ.setLogData(str, str2);
        }
        if (this.ccY != null) {
            this.ccY.setLogData(str, str2);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(String str, String str2, String str3, String str4, String str5, boolean z, String str6) {
        this.mGroupId = str;
        MessageManager.getInstance().registerListener(this.blG);
        MessageManager.getInstance().registerListener(this.blH);
        MessageManager.getInstance().registerListener(this.boS);
        MessageManager.getInstance().registerListener(this.boT);
        this.cda.clear();
        this.ccY.Jg();
        this.ccY.a(str, str4, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str3), str3, str6);
        MessageManager.getInstance().registerListener(this.ccZ.boE);
        MessageManager.getInstance().registerListener(this.ccZ.bgy);
    }

    @Override // com.baidu.live.im.k
    public void zR() {
        MessageManager.getInstance().unRegisterListener(this.blG);
        MessageManager.getInstance().unRegisterListener(this.blH);
        MessageManager.getInstance().unRegisterListener(this.boS);
        MessageManager.getInstance().unRegisterListener(this.boT);
        this.cda.clear();
        if (this.ccY != null) {
            this.ccY.KJ();
        }
        if (this.ccZ != null) {
            this.ccZ.Ma();
            MessageManager.getInstance().unRegisterListener(this.ccZ.boE);
            MessageManager.getInstance().unRegisterListener(this.ccZ.bgy);
        }
        LiveTimerManager.getInstance().removeLiveTimerTask("live_show_tag_view", true);
        SafeHandler.getInst().removeCallbacks(this.boX);
    }

    @Override // com.baidu.live.im.k
    public void g(Map<String, Integer> map) {
        if (this.ccZ != null) {
            this.ccZ.g(map);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(k.a aVar) {
        this.boR = aVar;
    }

    @Override // com.baidu.live.im.k
    public void a(boolean z, int i, int i2, String str) {
        if (this.ccZ != null) {
            this.ccZ.b(z, i, i2, str);
        }
    }

    @Override // com.baidu.live.im.k
    public int getImMsgListViewTop() {
        return 0;
    }

    @Override // com.baidu.live.im.k
    public int getImMsgListViewHeight() {
        return this.ccY.getHeight();
    }

    @Override // com.baidu.live.im.k
    public int Kg() {
        return 0;
    }

    @Override // com.baidu.live.im.k
    public void onDestroy() {
        a((k.a) null);
    }

    @Override // com.baidu.live.im.k
    public View getTextView() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(List<b> list) {
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            if (this.aVn) {
                if (ListUtils.isEmpty(this.boO)) {
                    return;
                }
            } else if (ListUtils.isEmpty(this.boP)) {
                return;
            }
            for (b bVar : list) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public List<b> av(List<b> list) {
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (b bVar : list) {
            if (bVar != null && "audio_emoticon".equals(F(bVar)) && !this.cda.contains(Long.valueOf(bVar.getMsgId())) && (com.baidu.live.ao.a.Yj().iH(ExtraParamsManager.getEncryptionUserId(bVar.getUserId() + "")) || !StringUtils.isNull(M(bVar), true))) {
                arrayList.add(bVar);
                this.cda.add(Long.valueOf(bVar.getMsgId()));
            }
        }
        list.removeAll(arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final List<b> list, List<b> list2) {
        if (list != null && !ListUtils.isEmpty(list2)) {
            final String str = this.mGroupId;
            for (final b bVar : list2) {
                if (bVar != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(bVar.getContent());
                        JSONObject optJSONObject = jSONObject.optJSONObject("emoticon_info");
                        optJSONObject.optString("compression_img");
                        final String optString = optJSONObject.optString("prototype_img");
                        final String optString2 = optJSONObject.optString("result_img");
                        if (StringUtils.isNull(optString2, true)) {
                            optString2 = null;
                        }
                        final String optString3 = jSONObject.optString("user_uk");
                        AlaEmoticonView.a(optString, optString2, new AlaEmoticonView.b() { // from class: com.baidu.live.yuyinim.controller.a.9
                            @Override // com.baidu.live.tieba.view.AlaEmoticonView.b
                            public void onLoaded() {
                                if (str == a.this.mGroupId) {
                                    a.this.a(list, bVar);
                                    if (!bVar.Lc()) {
                                        a.this.I(optString, optString2, optString3);
                                    }
                                }
                            }

                            @Override // com.baidu.live.tieba.view.AlaEmoticonView.b
                            public void onFail() {
                            }
                        }, this);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(String str, String str2, String str3) {
        if (!StringUtils.isNull(str, true) && !StringUtils.isNull(str3, true)) {
            HashMap hashMap = new HashMap();
            hashMap.put("user_uk", str3);
            hashMap.put("webp_url", str);
            hashMap.put("result_url", str2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501022, hashMap));
        }
    }

    private String F(b bVar) {
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

    private String M(b bVar) {
        JSONObject jSONObject;
        try {
            if (bVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) bVar.getObjContent();
            } else {
                jSONObject = new JSONObject(bVar.getContent());
            }
            return jSONObject.optJSONObject("emoticon_info").optString("result_img");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
