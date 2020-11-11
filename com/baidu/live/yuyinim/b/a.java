package com.baidu.live.yuyinim.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.db.DBResource;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.al.b;
import com.baidu.live.data.cg;
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
    private final ALaImMsgView bTD;
    private final ALALiveTextView bTE;
    private List<String> bls;
    private List<String> blt;
    private k.a blu;
    private String mGroupId;
    private TbPageContext mPageContext;
    private boolean aUa = false;
    private Set<Long> bTF = new HashSet();
    private CustomMessageListener biU = new CustomMessageListener(2913038) { // from class: com.baidu.live.yuyinim.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                List list = (List) customResponsedMessage.getData();
                a.this.V(list);
                a.this.ap(list);
                a.this.an(list);
                a.this.ao(list);
                List ar = a.this.ar(list);
                a.this.d((List<com.baidu.live.im.data.a>) list, true);
                a.this.h(list, ar);
            }
        }
    };
    private CustomMessageListener biV = new CustomMessageListener(2913037) { // from class: com.baidu.live.yuyinim.b.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (!a.this.aUa && aVar != null && (aVar.Mo() instanceof com.baidu.live.data.a)) {
                    aVar.Mo().aHF = -1;
                }
                a.this.t(aVar);
            }
        }
    };
    private CustomMessageListener blv = new CustomMessageListener(2913044) { // from class: com.baidu.live.yuyinim.b.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener blw = new CustomMessageListener(2913095) { // from class: com.baidu.live.yuyinim.b.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.bTE != null) {
                    a.this.bTE.hM(str);
                }
            }
        }
    };
    private final a.InterfaceC0232a blx = new a.InterfaceC0232a() { // from class: com.baidu.live.yuyinim.b.a.6
        @Override // com.baidu.live.view.input.a.InterfaceC0232a
        public boolean LM() {
            return a.this.blu != null && a.this.blu.LM();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0232a
        public void s(String str, boolean z) {
            Log.i("i", "@@@ localText nmpanctr sdhdl 1");
            if (a.this.blu != null) {
                if (a.this.blu.LM()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (a.this.bTE != null && a.this.bTE.Nc()) {
                        cg barrageInfo = a.this.bTE.getBarrageInfo();
                        if (barrageInfo != null) {
                            if (barrageInfo.type == 16 && !a.this.blu.LQ()) {
                                BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.h.sdk_throne_disabled_alert);
                                return;
                            } else if (barrageInfo.type == 17 && barrageInfo.aRr > a.this.blu.LR()) {
                                if (barrageInfo.aRr == 7) {
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
                    if (!z && a.this.bTE != null) {
                        a.this.bTE.Ng();
                    }
                } else if (!z) {
                    Log.i("i", "@@@ localText nmpanctr sdhdl nolg");
                    a.this.blu.LN();
                }
                if (z) {
                    a.this.blu.hJ(str);
                }
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0232a
        public void LO() {
            if (a.this.blu != null) {
                a.this.blu.LO();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0232a
        public void LP() {
            if (a.this.blu != null) {
                a.this.blu.LP();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0232a
        public boolean LQ() {
            return a.this.blu != null && a.this.blu.LQ();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0232a
        public int LR() {
            if (a.this.blu != null) {
                return a.this.blu.LR();
            }
            return 0;
        }
    };
    private Runnable bly = new Runnable() { // from class: com.baidu.live.yuyinim.b.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bTD.Nn();
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bTD = new ALaImMsgView(tbPageContext.getPageActivity());
        this.bTD.setPageContext(this.mPageContext);
        this.bTD.setNeedTopAlphaShade(true);
        this.bTD.setMode(false);
        this.bTE = new ALALiveTextView(tbPageContext.getPageActivity(), tbPageContext);
        this.bTE.setMsHandler(this.blx);
        this.bTE.setBdPageContext(tbPageContext);
        this.bls = new ArrayList();
        this.blt = new ArrayList();
        this.bls.add("allin");
    }

    @Override // com.baidu.live.im.k
    public void setFromMaster(boolean z) {
        this.aUa = z;
        if (this.bTD != null) {
            this.bTD.setFromMaster(z);
        }
        if (this.bTE != null) {
            this.bTE.setFromMaster(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.bTD != null) {
            boolean as = this.bTD.as(list);
            this.bTD.setMsgData(list);
            if (as) {
                this.bTD.Nm();
                if (z) {
                    this.bTD.postDelayed(new Runnable() { // from class: com.baidu.live.yuyinim.b.a.7
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.bTD.LI();
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
            if (this.bTD != null) {
                this.bTD.setMsgData(list);
                this.bTD.Nm();
                this.bTD.postDelayed(new Runnable() { // from class: com.baidu.live.yuyinim.b.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bTD.LI();
                    }
                }, 350L);
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
            if ("enter_live".equals(str) && com.baidu.live.entereffect.a.Fg().h(aVar)) {
                this.bTD.y(aVar);
            }
        }
    }

    @Override // com.baidu.live.im.k
    public j LJ() {
        return this.bTD;
    }

    @Override // com.baidu.live.im.k
    public com.baidu.live.view.input.a LK() {
        return this.bTE;
    }

    @Override // com.baidu.live.im.k
    public void setLogData(String str, String str2) {
        if (this.bTE != null) {
            this.bTE.setLogData(str, str2);
        }
        if (this.bTD != null) {
            this.bTD.setLogData(str, str2);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(String str, String str2, String str3, String str4, String str5, boolean z) {
        this.mGroupId = str;
        MessageManager.getInstance().registerListener(this.biU);
        MessageManager.getInstance().registerListener(this.biV);
        MessageManager.getInstance().registerListener(this.blv);
        MessageManager.getInstance().registerListener(this.blw);
        this.bTF.clear();
        this.bTD.KS();
        this.bTD.b(str, str4, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str3), str3);
        MessageManager.getInstance().registerListener(this.bTE.bmQ);
        MessageManager.getInstance().registerListener(this.bTE.bek);
    }

    @Override // com.baidu.live.im.k
    public void CM() {
        MessageManager.getInstance().unRegisterListener(this.biU);
        MessageManager.getInstance().unRegisterListener(this.biV);
        MessageManager.getInstance().unRegisterListener(this.blv);
        MessageManager.getInstance().unRegisterListener(this.blw);
        this.bTF.clear();
        if (this.bTD != null) {
            this.bTD.MW();
        }
        if (this.bTE != null) {
            this.bTE.Ng();
            MessageManager.getInstance().unRegisterListener(this.bTE.bmQ);
            MessageManager.getInstance().unRegisterListener(this.bTE.bek);
        }
        LiveTimerManager.getInstance().removeLiveTimerTask("live_show_tag_view", true);
        SafeHandler.getInst().removeCallbacks(this.bly);
    }

    @Override // com.baidu.live.im.k
    public void g(Map<String, Integer> map) {
        if (this.bTE != null) {
            this.bTE.g(map);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(k.a aVar) {
        this.blu = aVar;
    }

    @Override // com.baidu.live.im.k
    public void a(boolean z, int i, int i2, String str) {
        if (this.bTE != null) {
            this.bTE.b(z, i, i2, str);
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
    public int LL() {
        return 0;
    }

    @Override // com.baidu.live.im.k
    public void onDestroy() {
        a((k.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(List<com.baidu.live.im.data.a> list) {
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = null;
            for (com.baidu.live.im.data.a aVar : list) {
                if (aVar != null && TextUtils.equals("switch_activity_stage", w(aVar))) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(aVar);
                }
            }
            if (!ListUtils.isEmpty(arrayList)) {
                try {
                    com.baidu.live.im.data.a aVar2 = (com.baidu.live.im.data.a) arrayList.get(arrayList.size() - 1);
                    boolean z = false;
                    if (D(aVar2) == 2) {
                        BdUtilHelper.showToast(DBResource.getContext(), "无成功匹配，本轮约会结束");
                        z = true;
                    }
                    if (!z && C(aVar2) == 0) {
                        BdUtilHelper.showToast(DBResource.getContext(), "本轮约会结束");
                    }
                } catch (Exception e) {
                }
                list.removeAll(arrayList);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(List<com.baidu.live.im.data.a> list) {
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = null;
            for (com.baidu.live.im.data.a aVar : list) {
                if (aVar != null && TextUtils.equals("audio_link_online", w(aVar))) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(aVar);
                }
            }
            if (!ListUtils.isEmpty(arrayList)) {
                list.removeAll(arrayList);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(List<com.baidu.live.im.data.a> list) {
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = null;
            for (com.baidu.live.im.data.a aVar : list) {
                if (aVar != null && TextUtils.equals("sync_audio_speeker_status", w(aVar))) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(aVar);
                }
            }
            if (!ListUtils.isEmpty(arrayList)) {
                list.removeAll(arrayList);
                aq(arrayList);
            }
        }
    }

    private void aq(List<com.baidu.live.im.data.a> list) {
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
                        if (!b.Xh().iV(b.Xh().Xm())) {
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
            if (this.aUa) {
                if (ListUtils.isEmpty(this.bls)) {
                    return;
                }
            } else if (ListUtils.isEmpty(this.blt)) {
                return;
            }
            for (com.baidu.live.im.data.a aVar : list) {
                if (aVar != null && (aVar.getMsgType() == 13 || aVar.getMsgType() == 26 || aVar.getMsgType() == 27 || aVar.getMsgType() == 12)) {
                    if (this.aUa) {
                        if (this.bls.contains(w(aVar))) {
                            arrayList.add(aVar);
                        }
                    } else if (this.blt.contains(w(aVar))) {
                        arrayList.add(aVar);
                    }
                }
            }
            list.removeAll(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.live.im.data.a> ar(List<com.baidu.live.im.data.a> list) {
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.baidu.live.im.data.a aVar : list) {
            if (aVar != null && "audio_emoticon".equals(w(aVar)) && !this.bTF.contains(Long.valueOf(aVar.getMsgId())) && (b.Xh().iV(ExtraParamsManager.getEncryptionUserId(aVar.getUserId() + "")) || !StringUtils.isNull(E(aVar), true))) {
                arrayList.add(aVar);
                this.bTF.add(Long.valueOf(aVar.getMsgId()));
            }
        }
        list.removeAll(arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(final List<com.baidu.live.im.data.a> list, List<com.baidu.live.im.data.a> list2) {
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
                            public void Tw() {
                                if (str == a.this.mGroupId) {
                                    a.this.a(list, aVar);
                                    if (!aVar.Mr()) {
                                        a.this.C(optString, optString2, optString3);
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
    public void C(String str, String str2, String str3) {
        if (!StringUtils.isNull(str, true) && !StringUtils.isNull(str3, true)) {
            HashMap hashMap = new HashMap();
            hashMap.put("user_uk", str3);
            hashMap.put("webp_url", str);
            hashMap.put("result_url", str2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501022, hashMap));
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

    private int C(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        try {
            if (aVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) aVar.getObjContent();
            } else {
                jSONObject = new JSONObject(aVar.getContent());
            }
            return jSONObject.optInt("activity_stage");
        } catch (JSONException e) {
            return -1;
        }
    }

    private int D(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        try {
            if (aVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) aVar.getObjContent();
            } else {
                jSONObject = new JSONObject(aVar.getContent());
            }
            return jSONObject.optInt("confession");
        } catch (JSONException e) {
            return -1;
        }
    }

    private String E(com.baidu.live.im.data.a aVar) {
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
