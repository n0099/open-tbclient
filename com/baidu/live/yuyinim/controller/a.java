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
/* loaded from: classes10.dex */
public class a implements k {
    private List<String> bqo;
    private List<String> bqp;
    private k.a bqr;
    private final ALaImMsgView ceA;
    private final ALALiveTextView ceB;
    private String mGroupId;
    private TbPageContext mPageContext;
    private boolean aWN = false;
    private Set<Long> ceC = new HashSet();
    private CustomMessageListener bnh = new CustomMessageListener(2913038) { // from class: com.baidu.live.yuyinim.controller.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                List list = (List) customResponsedMessage.getData();
                a.this.X(list);
                List av = a.this.av(list);
                a.this.d(list, true);
                a.this.h(list, av);
            }
        }
    };
    private CustomMessageListener bni = new CustomMessageListener(2913037) { // from class: com.baidu.live.yuyinim.controller.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof b)) {
                b bVar = (b) customResponsedMessage.getData();
                if (!a.this.aWN && bVar != null && (bVar.Lc() instanceof com.baidu.live.data.a)) {
                    bVar.Lc().aHy = -1;
                }
                a.this.t(bVar);
            }
        }
    };
    private CustomMessageListener bqs = new CustomMessageListener(2913044) { // from class: com.baidu.live.yuyinim.controller.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener bqt = new CustomMessageListener(2913095) { // from class: com.baidu.live.yuyinim.controller.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.ceB != null) {
                    a.this.ceB.ho(str);
                }
            }
        }
    };
    private final a.InterfaceC0238a bqv = new a.InterfaceC0238a() { // from class: com.baidu.live.yuyinim.controller.a.6
        @Override // com.baidu.live.view.input.a.InterfaceC0238a
        public boolean Kk() {
            return a.this.bqr != null && a.this.bqr.Kk();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0238a
        public void t(String str, boolean z) {
            Log.i("i", "@@@ localText nmpanctr sdhdl 1");
            if (a.this.bqr != null) {
                if (a.this.bqr.Kk()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (a.this.ceB != null && a.this.ceB.LZ()) {
                        cr barrageInfo = a.this.ceB.getBarrageInfo();
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
                    }
                    Log.i("i", "@@@ localText nmpanctr sdhdl cmd");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
                    if (!z && a.this.ceB != null) {
                        a.this.ceB.Md();
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

        @Override // com.baidu.live.view.input.a.InterfaceC0238a
        public void Km() {
            if (a.this.bqr != null) {
                a.this.bqr.Km();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0238a
        public void Kn() {
            if (a.this.bqr != null) {
                a.this.bqr.Kn();
            }
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
    private Runnable bqx = new Runnable() { // from class: com.baidu.live.yuyinim.controller.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.ceA.ZM();
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.ceA = new ALaImMsgView(tbPageContext.getPageActivity());
        this.ceA.setPageContext(this.mPageContext);
        this.ceA.setNeedTopAlphaShade(true);
        this.ceA.setMode(false);
        this.ceB = new ALALiveTextView(tbPageContext.getPageActivity(), tbPageContext);
        this.ceB.setMsHandler(this.bqv);
        this.ceB.setBdPageContext(tbPageContext);
        this.bqo = new ArrayList();
        this.bqp = new ArrayList();
        this.bqo.add("allin");
    }

    @Override // com.baidu.live.im.k
    public void setFromMaster(boolean z) {
        this.aWN = z;
        if (this.ceA != null) {
            this.ceA.setFromMaster(z);
        }
        if (this.ceB != null) {
            this.ceB.setFromMaster(z);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(ViewGroup viewGroup, ab abVar, List<String> list, RelativeLayout.LayoutParams layoutParams) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<b> list, boolean z) {
        if (this.ceA != null) {
            boolean aw = this.ceA.aw(list);
            this.ceA.setMsgData(list);
            if (aw) {
                this.ceA.Mq();
                if (z) {
                    this.ceA.postDelayed(new Runnable() { // from class: com.baidu.live.yuyinim.controller.a.7
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.ceA.Kf();
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
            if (this.ceA != null) {
                this.ceA.setMsgData(list);
                this.ceA.Mq();
                this.ceA.postDelayed(new Runnable() { // from class: com.baidu.live.yuyinim.controller.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.ceA.Kf();
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
            if ("enter_live".equals(str) && com.baidu.live.entereffect.a.CY().h(bVar)) {
                this.ceA.H(bVar);
            }
        }
    }

    @Override // com.baidu.live.im.k
    public j Kg() {
        return this.ceA;
    }

    @Override // com.baidu.live.im.k
    public com.baidu.live.view.input.a Kh() {
        return this.ceB;
    }

    @Override // com.baidu.live.im.k
    public com.baidu.live.view.input.b Ki() {
        return null;
    }

    @Override // com.baidu.live.im.k
    public void setLogData(String str, String str2) {
        if (this.ceB != null) {
            this.ceB.setLogData(str, str2);
        }
        if (this.ceA != null) {
            this.ceA.setLogData(str, str2);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(String str, String str2, String str3, String str4, String str5, boolean z, String str6) {
        this.mGroupId = str;
        MessageManager.getInstance().registerListener(this.bnh);
        MessageManager.getInstance().registerListener(this.bni);
        MessageManager.getInstance().registerListener(this.bqs);
        MessageManager.getInstance().registerListener(this.bqt);
        this.ceC.clear();
        this.ceA.Jj();
        this.ceA.a(str, str4, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str3), str3, str6);
        MessageManager.getInstance().registerListener(this.ceB.bqe);
        MessageManager.getInstance().registerListener(this.ceB.bhY);
    }

    @Override // com.baidu.live.im.k
    public void zU() {
        MessageManager.getInstance().unRegisterListener(this.bnh);
        MessageManager.getInstance().unRegisterListener(this.bni);
        MessageManager.getInstance().unRegisterListener(this.bqs);
        MessageManager.getInstance().unRegisterListener(this.bqt);
        this.ceC.clear();
        if (this.ceA != null) {
            this.ceA.KM();
        }
        if (this.ceB != null) {
            this.ceB.Md();
            MessageManager.getInstance().unRegisterListener(this.ceB.bqe);
            MessageManager.getInstance().unRegisterListener(this.ceB.bhY);
        }
        LiveTimerManager.getInstance().removeLiveTimerTask("live_show_tag_view", true);
        SafeHandler.getInst().removeCallbacks(this.bqx);
    }

    @Override // com.baidu.live.im.k
    public void g(Map<String, Integer> map) {
        if (this.ceB != null) {
            this.ceB.g(map);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(k.a aVar) {
        this.bqr = aVar;
    }

    @Override // com.baidu.live.im.k
    public void a(boolean z, int i, int i2, String str) {
        if (this.ceB != null) {
            this.ceB.b(z, i, i2, str);
        }
    }

    @Override // com.baidu.live.im.k
    public int getImMsgListViewTop() {
        return 0;
    }

    @Override // com.baidu.live.im.k
    public int getImMsgListViewHeight() {
        return this.ceA.getHeight();
    }

    @Override // com.baidu.live.im.k
    public int Kj() {
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
            if (this.aWN) {
                if (ListUtils.isEmpty(this.bqo)) {
                    return;
                }
            } else if (ListUtils.isEmpty(this.bqp)) {
                return;
            }
            for (b bVar : list) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public List<b> av(List<b> list) {
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (b bVar : list) {
            if (bVar != null && "audio_emoticon".equals(F(bVar)) && !this.ceC.contains(Long.valueOf(bVar.getMsgId())) && (com.baidu.live.ao.a.Ym().iN(ExtraParamsManager.getEncryptionUserId(bVar.getUserId() + "")) || !StringUtils.isNull(M(bVar), true))) {
                arrayList.add(bVar);
                this.ceC.add(Long.valueOf(bVar.getMsgId()));
            }
        }
        list.removeAll(arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(final List<b> list, List<b> list2) {
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
                                    if (!bVar.Lf()) {
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
