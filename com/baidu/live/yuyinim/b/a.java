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
    private final ALaImMsgView bRT;
    private final ALALiveTextView bRU;
    private List<String> bjH;
    private List<String> bjI;
    private k.a bjJ;
    private String mGroupId;
    private TbPageContext mPageContext;
    private boolean aSp = false;
    private Set<Long> bRV = new HashSet();
    private CustomMessageListener bhg = new CustomMessageListener(2913038) { // from class: com.baidu.live.yuyinim.b.a.1
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
    private CustomMessageListener bhh = new CustomMessageListener(2913037) { // from class: com.baidu.live.yuyinim.b.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (!a.this.aSp && aVar != null && (aVar.LF() instanceof com.baidu.live.data.a)) {
                    aVar.LF().aFU = -1;
                }
                a.this.t(aVar);
            }
        }
    };
    private CustomMessageListener bjK = new CustomMessageListener(2913044) { // from class: com.baidu.live.yuyinim.b.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener bjL = new CustomMessageListener(2913095) { // from class: com.baidu.live.yuyinim.b.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.bRU != null) {
                    a.this.bRU.hG(str);
                }
            }
        }
    };
    private final a.InterfaceC0230a bjM = new a.InterfaceC0230a() { // from class: com.baidu.live.yuyinim.b.a.6
        @Override // com.baidu.live.view.input.a.InterfaceC0230a
        public boolean Ld() {
            return a.this.bjJ != null && a.this.bjJ.Ld();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0230a
        public void s(String str, boolean z) {
            Log.i("i", "@@@ localText nmpanctr sdhdl 1");
            if (a.this.bjJ != null) {
                if (a.this.bjJ.Ld()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (a.this.bRU != null && a.this.bRU.Mt()) {
                        cg barrageInfo = a.this.bRU.getBarrageInfo();
                        if (barrageInfo != null) {
                            if (barrageInfo.type == 16 && !a.this.bjJ.Lh()) {
                                BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), a.h.sdk_throne_disabled_alert);
                                return;
                            } else if (barrageInfo.type == 17 && barrageInfo.aPG > a.this.bjJ.Li()) {
                                if (barrageInfo.aPG == 7) {
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
                    if (!z && a.this.bRU != null) {
                        a.this.bRU.Mx();
                    }
                } else if (!z) {
                    Log.i("i", "@@@ localText nmpanctr sdhdl nolg");
                    a.this.bjJ.Le();
                }
                if (z) {
                    a.this.bjJ.hD(str);
                }
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0230a
        public void Lf() {
            if (a.this.bjJ != null) {
                a.this.bjJ.Lf();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0230a
        public void Lg() {
            if (a.this.bjJ != null) {
                a.this.bjJ.Lg();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0230a
        public boolean Lh() {
            return a.this.bjJ != null && a.this.bjJ.Lh();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0230a
        public int Li() {
            if (a.this.bjJ != null) {
                return a.this.bjJ.Li();
            }
            return 0;
        }
    };
    private Runnable bjN = new Runnable() { // from class: com.baidu.live.yuyinim.b.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bRT.ME();
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bRT = new ALaImMsgView(tbPageContext.getPageActivity());
        this.bRT.setPageContext(this.mPageContext);
        this.bRT.setNeedTopAlphaShade(true);
        this.bRT.setMode(false);
        this.bRU = new ALALiveTextView(tbPageContext.getPageActivity(), tbPageContext);
        this.bRU.setMsHandler(this.bjM);
        this.bRU.setBdPageContext(tbPageContext);
        this.bjH = new ArrayList();
        this.bjI = new ArrayList();
        this.bjH.add("allin");
    }

    @Override // com.baidu.live.im.k
    public void setFromMaster(boolean z) {
        this.aSp = z;
        if (this.bRT != null) {
            this.bRT.setFromMaster(z);
        }
        if (this.bRU != null) {
            this.bRU.setFromMaster(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.bRT != null) {
            boolean as = this.bRT.as(list);
            this.bRT.setMsgData(list);
            if (as) {
                this.bRT.MD();
                if (z) {
                    this.bRT.postDelayed(new Runnable() { // from class: com.baidu.live.yuyinim.b.a.7
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.bRT.KZ();
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
            if (this.bRT != null) {
                this.bRT.setMsgData(list);
                this.bRT.MD();
                this.bRT.postDelayed(new Runnable() { // from class: com.baidu.live.yuyinim.b.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bRT.KZ();
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
            if ("enter_live".equals(str) && com.baidu.live.entereffect.a.Ex().h(aVar)) {
                this.bRT.y(aVar);
            }
        }
    }

    @Override // com.baidu.live.im.k
    public j La() {
        return this.bRT;
    }

    @Override // com.baidu.live.im.k
    public com.baidu.live.view.input.a Lb() {
        return this.bRU;
    }

    @Override // com.baidu.live.im.k
    public void setLogData(String str, String str2) {
        if (this.bRU != null) {
            this.bRU.setLogData(str, str2);
        }
        if (this.bRT != null) {
            this.bRT.setLogData(str, str2);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(String str, String str2, String str3, String str4, String str5, boolean z) {
        this.mGroupId = str;
        MessageManager.getInstance().registerListener(this.bhg);
        MessageManager.getInstance().registerListener(this.bhh);
        MessageManager.getInstance().registerListener(this.bjK);
        MessageManager.getInstance().registerListener(this.bjL);
        this.bRV.clear();
        this.bRT.Kj();
        this.bRT.b(str, str4, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str3), str3);
        MessageManager.getInstance().registerListener(this.bRU.blf);
        MessageManager.getInstance().registerListener(this.bRU.bcy);
    }

    @Override // com.baidu.live.im.k
    public void Cd() {
        MessageManager.getInstance().unRegisterListener(this.bhg);
        MessageManager.getInstance().unRegisterListener(this.bhh);
        MessageManager.getInstance().unRegisterListener(this.bjK);
        MessageManager.getInstance().unRegisterListener(this.bjL);
        this.bRV.clear();
        if (this.bRT != null) {
            this.bRT.Mn();
        }
        if (this.bRU != null) {
            this.bRU.Mx();
            MessageManager.getInstance().unRegisterListener(this.bRU.blf);
            MessageManager.getInstance().unRegisterListener(this.bRU.bcy);
        }
        LiveTimerManager.getInstance().removeLiveTimerTask("live_show_tag_view", true);
        SafeHandler.getInst().removeCallbacks(this.bjN);
    }

    @Override // com.baidu.live.im.k
    public void g(Map<String, Integer> map) {
        if (this.bRU != null) {
            this.bRU.g(map);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(k.a aVar) {
        this.bjJ = aVar;
    }

    @Override // com.baidu.live.im.k
    public void a(boolean z, int i, int i2, String str) {
        if (this.bRU != null) {
            this.bRU.b(z, i, i2, str);
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
    public int Lc() {
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
                        if (!b.Wy().iP(b.Wy().WD())) {
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
            if (this.aSp) {
                if (ListUtils.isEmpty(this.bjH)) {
                    return;
                }
            } else if (ListUtils.isEmpty(this.bjI)) {
                return;
            }
            for (com.baidu.live.im.data.a aVar : list) {
                if (aVar != null && (aVar.getMsgType() == 13 || aVar.getMsgType() == 26 || aVar.getMsgType() == 27 || aVar.getMsgType() == 12)) {
                    if (this.aSp) {
                        if (this.bjH.contains(w(aVar))) {
                            arrayList.add(aVar);
                        }
                    } else if (this.bjI.contains(w(aVar))) {
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
            if (aVar != null && "audio_emoticon".equals(w(aVar)) && !this.bRV.contains(Long.valueOf(aVar.getMsgId())) && (b.Wy().iP(ExtraParamsManager.getEncryptionUserId(aVar.getUserId() + "")) || !StringUtils.isNull(E(aVar), true))) {
                arrayList.add(aVar);
                this.bRV.add(Long.valueOf(aVar.getMsgId()));
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
                            public void SN() {
                                if (str == a.this.mGroupId) {
                                    a.this.a(list, aVar);
                                    if (!aVar.LI()) {
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
