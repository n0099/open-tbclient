package com.baidu.live.yuyinim.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.aj.b;
import com.baidu.live.data.ce;
import com.baidu.live.im.data.ImSendMsgData;
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
/* loaded from: classes4.dex */
public class a implements k {
    private final ALaImMsgView bNU;
    private final ALALiveTextView bNV;
    private List<String> bjY;
    private List<String> bjZ;
    private k.a bka;
    private String mGroupId;
    private TbPageContext mPageContext;
    private boolean aSH = false;
    private Set<Long> bNW = new HashSet();
    private CustomMessageListener bhy = new CustomMessageListener(2913038) { // from class: com.baidu.live.yuyinim.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                List list = (List) customResponsedMessage.getData();
                a.this.V(list);
                a.this.ai(list);
                List ak = a.this.ak(list);
                a.this.d(list, true);
                a.this.g(list, ak);
            }
        }
    };
    private CustomMessageListener bhz = new CustomMessageListener(2913037) { // from class: com.baidu.live.yuyinim.b.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (!a.this.aSH && aVar != null && (aVar.LO() instanceof com.baidu.live.data.a)) {
                    aVar.LO().aGP = -1;
                }
                a.this.s(aVar);
            }
        }
    };
    private CustomMessageListener bkb = new CustomMessageListener(2913044) { // from class: com.baidu.live.yuyinim.b.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener bkc = new CustomMessageListener(2913095) { // from class: com.baidu.live.yuyinim.b.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.bNV != null) {
                    a.this.bNV.hF(str);
                }
            }
        }
    };
    private final a.InterfaceC0220a bkd = new a.InterfaceC0220a() { // from class: com.baidu.live.yuyinim.b.a.6
        @Override // com.baidu.live.view.input.a.InterfaceC0220a
        public boolean Lm() {
            return a.this.bka != null && a.this.bka.Lm();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0220a
        public void s(String str, boolean z) {
            Log.i("i", "@@@ localText nmpanctr sdhdl 1");
            if (a.this.bka != null) {
                if (a.this.bka.Lm()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (a.this.bNV != null && a.this.bNV.MC()) {
                        ce barrageInfo = a.this.bNV.getBarrageInfo();
                        if (barrageInfo != null) {
                            if (barrageInfo.type == 16 && !a.this.bka.Lq()) {
                                BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.i.sdk_throne_disabled_alert);
                                return;
                            } else if (barrageInfo.type == 17 && barrageInfo.aQp > a.this.bka.Lr()) {
                                if (barrageInfo.aQp == 7) {
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
                    if (!z && a.this.bNV != null) {
                        a.this.bNV.MG();
                    }
                } else if (!z) {
                    Log.i("i", "@@@ localText nmpanctr sdhdl nolg");
                    a.this.bka.Ln();
                }
                if (z) {
                    a.this.bka.hC(str);
                }
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0220a
        public void Lo() {
            if (a.this.bka != null) {
                a.this.bka.Lo();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0220a
        public void Lp() {
            if (a.this.bka != null) {
                a.this.bka.Lp();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0220a
        public boolean Lq() {
            return a.this.bka != null && a.this.bka.Lq();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0220a
        public int Lr() {
            if (a.this.bka != null) {
                return a.this.bka.Lr();
            }
            return 0;
        }
    };
    private Runnable bke = new Runnable() { // from class: com.baidu.live.yuyinim.b.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bNU.MN();
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bNU = new ALaImMsgView(tbPageContext.getPageActivity());
        this.bNU.setPageContext(this.mPageContext);
        this.bNU.setNeedTopAlphaShade(true);
        this.bNU.setMode(false);
        this.bNV = new ALALiveTextView(tbPageContext.getPageActivity(), tbPageContext);
        this.bNV.setMsHandler(this.bkd);
        this.bNV.setBdPageContext(tbPageContext);
        this.bjY = new ArrayList();
        this.bjZ = new ArrayList();
        this.bjY.add("allin");
    }

    @Override // com.baidu.live.im.k
    public void setFromMaster(boolean z) {
        this.aSH = z;
        if (this.bNU != null) {
            this.bNU.setFromMaster(z);
        }
        if (this.bNV != null) {
            this.bNV.setFromMaster(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.bNU != null) {
            boolean al = this.bNU.al(list);
            this.bNU.setMsgData(list);
            if (al) {
                this.bNU.MM();
                if (z) {
                    this.bNU.postDelayed(new Runnable() { // from class: com.baidu.live.yuyinim.b.a.7
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.bNU.Li();
                        }
                    }, 350L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<com.baidu.live.im.data.a> list, com.baidu.live.im.data.a aVar) {
        if (aVar != null && list != null) {
            list.add(aVar);
            if (this.bNU != null) {
                this.bNU.setMsgData(list);
                this.bNU.MM();
                this.bNU.postDelayed(new Runnable() { // from class: com.baidu.live.yuyinim.b.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bNU.Li();
                    }
                }, 350L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(com.baidu.live.im.data.a aVar) {
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
            if ("enter_live".equals(str) && com.baidu.live.entereffect.a.EF().h(aVar)) {
                this.bNU.x(aVar);
            }
        }
    }

    @Override // com.baidu.live.im.k
    public j Lj() {
        return this.bNU;
    }

    @Override // com.baidu.live.im.k
    public com.baidu.live.view.input.a Lk() {
        return this.bNV;
    }

    @Override // com.baidu.live.im.k
    public void setLogData(String str, String str2) {
        if (this.bNV != null) {
            this.bNV.setLogData(str, str2);
        }
        if (this.bNU != null) {
            this.bNU.setLogData(str, str2);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(String str, String str2, String str3, String str4, String str5, boolean z) {
        this.mGroupId = str;
        MessageManager.getInstance().registerListener(this.bhy);
        MessageManager.getInstance().registerListener(this.bhz);
        MessageManager.getInstance().registerListener(this.bkb);
        MessageManager.getInstance().registerListener(this.bkc);
        this.bNW.clear();
        this.bNU.Ks();
        this.bNU.b(str, str4, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str3), str3);
        MessageManager.getInstance().registerListener(this.bNV.blw);
        MessageManager.getInstance().registerListener(this.bNV.bcQ);
    }

    @Override // com.baidu.live.im.k
    public void Ct() {
        MessageManager.getInstance().unRegisterListener(this.bhy);
        MessageManager.getInstance().unRegisterListener(this.bhz);
        MessageManager.getInstance().unRegisterListener(this.bkb);
        MessageManager.getInstance().unRegisterListener(this.bkc);
        this.bNW.clear();
        if (this.bNU != null) {
            this.bNU.Mw();
        }
        if (this.bNV != null) {
            this.bNV.MG();
            MessageManager.getInstance().unRegisterListener(this.bNV.blw);
            MessageManager.getInstance().unRegisterListener(this.bNV.bcQ);
        }
        LiveTimerManager.getInstance().removeLiveTimerTask("live_show_tag_view", true);
        SafeHandler.getInst().removeCallbacks(this.bke);
    }

    @Override // com.baidu.live.im.k
    public void g(Map<String, Integer> map) {
        if (this.bNV != null) {
            this.bNV.g(map);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(k.a aVar) {
        this.bka = aVar;
    }

    @Override // com.baidu.live.im.k
    public void a(boolean z, int i, int i2, String str) {
        if (this.bNV != null) {
            this.bNV.b(z, i, i2, str);
        }
    }

    @Override // com.baidu.live.im.k
    public int getImMsgListViewTop() {
        return 0;
    }

    @Override // com.baidu.live.im.k
    public int getImMsgListViewHeight() {
        return 0;
    }

    @Override // com.baidu.live.im.k
    public int Ll() {
        return 0;
    }

    @Override // com.baidu.live.im.k
    public void onDestroy() {
        a((k.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(List<com.baidu.live.im.data.a> list) {
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = null;
            for (com.baidu.live.im.data.a aVar : list) {
                if (aVar != null && TextUtils.equals("sync_audio_speeker_status", v(aVar))) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(aVar);
                }
            }
            if (!ListUtils.isEmpty(arrayList)) {
                list.removeAll(arrayList);
                aj(arrayList);
            }
        }
    }

    private void aj(List<com.baidu.live.im.data.a> list) {
        JSONObject jSONObject;
        if (!ListUtils.isEmpty(list)) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            for (com.baidu.live.im.data.a aVar : list) {
                if (aVar != null && (!StringUtils.isNull(aVar.getContent()) || aVar.getObjContent() != null)) {
                    try {
                        if (aVar.getObjContent() instanceof JSONObject) {
                            jSONObject = (JSONObject) aVar.getObjContent();
                        } else {
                            jSONObject = new JSONObject(aVar.getContent());
                        }
                        String optString = jSONObject.optString("uk");
                        long optLong = jSONObject.optLong("timestamp");
                        if (!hashMap.containsKey(optString) || (hashMap.containsKey(optString) && ((Long) hashMap.get(optString)).longValue() < optLong)) {
                            hashMap.put(optString, Long.valueOf(optLong));
                            hashMap2.put(optString, aVar.getContent());
                        }
                    } catch (JSONException e) {
                    }
                }
            }
            if (!ListUtils.isEmpty(hashMap2)) {
                for (Map.Entry entry : hashMap2.entrySet()) {
                    if (!StringUtils.isNull((String) entry.getValue(), true)) {
                        if (!b.UH().iI(b.UH().UN())) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501026, entry.getValue()));
                        } else {
                            try {
                                if (new JSONObject((String) entry.getValue()).optInt("open_rtc_mode", 0) != 1) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501026, entry.getValue()));
                                }
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(List<com.baidu.live.im.data.a> list) {
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            if (this.aSH) {
                if (ListUtils.isEmpty(this.bjY)) {
                    return;
                }
            } else if (ListUtils.isEmpty(this.bjZ)) {
                return;
            }
            for (com.baidu.live.im.data.a aVar : list) {
                if (aVar != null && (aVar.getMsgType() == 13 || aVar.getMsgType() == 26 || aVar.getMsgType() == 27 || aVar.getMsgType() == 12)) {
                    if (this.aSH) {
                        if (this.bjY.contains(v(aVar))) {
                            arrayList.add(aVar);
                        }
                    } else if (this.bjZ.contains(v(aVar))) {
                        arrayList.add(aVar);
                    }
                }
            }
            list.removeAll(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.live.im.data.a> ak(List<com.baidu.live.im.data.a> list) {
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.baidu.live.im.data.a aVar : list) {
            if (aVar != null && "audio_emoticon".equals(v(aVar)) && !this.bNW.contains(Long.valueOf(aVar.getMsgId())) && (b.UH().iI(ExtraParamsManager.getEncryptionUserId(aVar.getUserId() + "")) || !StringUtils.isNull(B(aVar), true))) {
                arrayList.add(aVar);
                this.bNW.add(Long.valueOf(aVar.getMsgId()));
            }
        }
        list.removeAll(arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(final List<com.baidu.live.im.data.a> list, List<com.baidu.live.im.data.a> list2) {
        if (list != null && !ListUtils.isEmpty(list2)) {
            final String str = this.mGroupId;
            for (final com.baidu.live.im.data.a aVar : list2) {
                if (aVar != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(aVar.getContent());
                        JSONObject optJSONObject = jSONObject.optJSONObject("emoticon_info");
                        optJSONObject.optString("compression_img");
                        final String optString = optJSONObject.optString("prototype_img");
                        final String optString2 = optJSONObject.optString("result_img");
                        if (StringUtils.isNull(optString2, true)) {
                            optString2 = null;
                        }
                        final String optString3 = jSONObject.optString("user_uk");
                        AlaEmoticonView.a(optString, optString2, new AlaEmoticonView.b() { // from class: com.baidu.live.yuyinim.b.a.9
                            @Override // com.baidu.live.tieba.view.AlaEmoticonView.b
                            public void QO() {
                                if (str == a.this.mGroupId) {
                                    a.this.a(list, aVar);
                                    a.this.C(optString, optString2, optString3);
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
    public void C(String str, String str2, String str3) {
        if (!StringUtils.isNull(str, true) && !StringUtils.isNull(str3, true)) {
            HashMap hashMap = new HashMap();
            hashMap.put("user_uk", str3);
            hashMap.put("webp_url", str);
            hashMap.put("result_url", str2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501022, hashMap));
        }
    }

    private String v(com.baidu.live.im.data.a aVar) {
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

    private String B(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        try {
            if (aVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) aVar.getObjContent();
            } else {
                jSONObject = new JSONObject(aVar.getContent());
            }
            return jSONObject.optJSONObject("emoticon_info").optString("result_img");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
