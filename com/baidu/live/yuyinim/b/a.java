package com.baidu.live.yuyinim.b;

import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.db.DBResource;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.ci;
import com.baidu.live.data.w;
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
/* loaded from: classes4.dex */
public class a implements k {
    private final ALaImMsgView bXj;
    private final ALALiveTextView bXk;
    private k.a boA;
    private List<String> box;
    private List<String> boy;
    private String mGroupId;
    private TbPageContext mPageContext;
    private boolean aVr = false;
    private Set<Long> bXl = new HashSet();
    private CustomMessageListener blv = new CustomMessageListener(2913038) { // from class: com.baidu.live.yuyinim.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                List list = (List) customResponsedMessage.getData();
                a.this.W(list);
                a.this.ar(list);
                a.this.ap(list);
                a.this.aq(list);
                List at = a.this.at(list);
                a.this.d((List<b>) list, true);
                a.this.h(list, at);
            }
        }
    };
    private CustomMessageListener blw = new CustomMessageListener(2913037) { // from class: com.baidu.live.yuyinim.b.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof b)) {
                b bVar = (b) customResponsedMessage.getData();
                if (!a.this.aVr && bVar != null && (bVar.NU() instanceof com.baidu.live.data.a)) {
                    bVar.NU().aIC = -1;
                }
                a.this.t(bVar);
            }
        }
    };
    private CustomMessageListener boB = new CustomMessageListener(2913044) { // from class: com.baidu.live.yuyinim.b.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener boC = new CustomMessageListener(2913095) { // from class: com.baidu.live.yuyinim.b.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.bXk != null) {
                    a.this.bXk.ij(str);
                }
            }
        }
    };
    private final a.InterfaceC0239a boE = new a.InterfaceC0239a() { // from class: com.baidu.live.yuyinim.b.a.6
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
                    if (a.this.bXk != null && a.this.bXk.OO()) {
                        ci barrageInfo = a.this.bXk.getBarrageInfo();
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
                    if (!z && a.this.bXk != null) {
                        a.this.bXk.OS();
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
    private Runnable boG = new Runnable() { // from class: com.baidu.live.yuyinim.b.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bXj.ZW();
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bXj = new ALaImMsgView(tbPageContext.getPageActivity());
        this.bXj.setPageContext(this.mPageContext);
        this.bXj.setNeedTopAlphaShade(true);
        this.bXj.setMode(false);
        this.bXk = new ALALiveTextView(tbPageContext.getPageActivity(), tbPageContext);
        this.bXk.setMsHandler(this.boE);
        this.bXk.setBdPageContext(tbPageContext);
        this.box = new ArrayList();
        this.boy = new ArrayList();
        this.box.add("allin");
    }

    @Override // com.baidu.live.im.k
    public void setFromMaster(boolean z) {
        this.aVr = z;
        if (this.bXj != null) {
            this.bXj.setFromMaster(z);
        }
        if (this.bXk != null) {
            this.bXk.setFromMaster(z);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(ViewGroup viewGroup, w wVar, List<String> list, RelativeLayout.LayoutParams layoutParams) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<b> list, boolean z) {
        if (this.bXj != null) {
            boolean au = this.bXj.au(list);
            this.bXj.setMsgData(list);
            if (au) {
                this.bXj.OZ();
                if (z) {
                    this.bXj.postDelayed(new Runnable() { // from class: com.baidu.live.yuyinim.b.a.7
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.bXj.Nc();
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
            if (this.bXj != null) {
                this.bXj.setMsgData(list);
                this.bXj.OZ();
                this.bXj.postDelayed(new Runnable() { // from class: com.baidu.live.yuyinim.b.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bXj.Nc();
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
            if ("enter_live".equals(str) && com.baidu.live.entereffect.a.Gi().h(bVar)) {
                this.bXj.z(bVar);
            }
        }
    }

    @Override // com.baidu.live.im.k
    public j Nd() {
        return this.bXj;
    }

    @Override // com.baidu.live.im.k
    public com.baidu.live.view.input.a Ne() {
        return this.bXk;
    }

    @Override // com.baidu.live.im.k
    public com.baidu.live.view.input.b Nf() {
        return null;
    }

    @Override // com.baidu.live.im.k
    public void setLogData(String str, String str2) {
        if (this.bXk != null) {
            this.bXk.setLogData(str, str2);
        }
        if (this.bXj != null) {
            this.bXj.setLogData(str, str2);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(String str, String str2, String str3, String str4, String str5, boolean z, String str6) {
        this.mGroupId = str;
        MessageManager.getInstance().registerListener(this.blv);
        MessageManager.getInstance().registerListener(this.blw);
        MessageManager.getInstance().registerListener(this.boB);
        MessageManager.getInstance().registerListener(this.boC);
        this.bXl.clear();
        this.bXj.Ml();
        this.bXj.a(str, str4, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str3), str3, str6);
        MessageManager.getInstance().registerListener(this.bXk.bon);
        MessageManager.getInstance().registerListener(this.bXk.bgy);
    }

    @Override // com.baidu.live.im.k
    public void DN() {
        MessageManager.getInstance().unRegisterListener(this.blv);
        MessageManager.getInstance().unRegisterListener(this.blw);
        MessageManager.getInstance().unRegisterListener(this.boB);
        MessageManager.getInstance().unRegisterListener(this.boC);
        this.bXl.clear();
        if (this.bXj != null) {
            this.bXj.OI();
        }
        if (this.bXk != null) {
            this.bXk.OS();
            MessageManager.getInstance().unRegisterListener(this.bXk.bon);
            MessageManager.getInstance().unRegisterListener(this.bXk.bgy);
        }
        LiveTimerManager.getInstance().removeLiveTimerTask("live_show_tag_view", true);
        SafeHandler.getInst().removeCallbacks(this.boG);
    }

    @Override // com.baidu.live.im.k
    public void g(Map<String, Integer> map) {
        if (this.bXk != null) {
            this.bXk.g(map);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(k.a aVar) {
        this.boA = aVar;
    }

    @Override // com.baidu.live.im.k
    public void a(boolean z, int i, int i2, String str) {
        if (this.bXk != null) {
            this.bXk.b(z, i, i2, str);
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
    public int Ng() {
        return 0;
    }

    @Override // com.baidu.live.im.k
    public void onDestroy() {
        a((k.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(List<b> list) {
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = null;
            for (b bVar : list) {
                if (bVar != null && TextUtils.equals("switch_activity_stage", x(bVar))) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(bVar);
                }
            }
            if (!ListUtils.isEmpty(arrayList)) {
                try {
                    b bVar2 = (b) arrayList.get(arrayList.size() - 1);
                    boolean z = false;
                    if (E(bVar2) == 2) {
                        BdUtilHelper.showToast(DBResource.getContext(), "无成功匹配，本轮约会结束");
                        z = true;
                    }
                    if (!z && D(bVar2) == 0) {
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
    public void aq(List<b> list) {
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = null;
            for (b bVar : list) {
                if (bVar != null && TextUtils.equals("audio_link_online", x(bVar))) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(bVar);
                }
            }
            if (!ListUtils.isEmpty(arrayList)) {
                list.removeAll(arrayList);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(List<b> list) {
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = null;
            for (b bVar : list) {
                if (bVar != null && TextUtils.equals("sync_audio_speeker_status", x(bVar))) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(bVar);
                }
            }
            if (!ListUtils.isEmpty(arrayList)) {
                list.removeAll(arrayList);
                as(arrayList);
            }
        }
    }

    private void as(List<b> list) {
        JSONObject jSONObject;
        if (!ListUtils.isEmpty(list)) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            for (b bVar : list) {
                if (bVar != null && (!StringUtils.isNull(bVar.getContent()) || bVar.getObjContent() != null)) {
                    try {
                        if (bVar.getObjContent() instanceof JSONObject) {
                            jSONObject = (JSONObject) bVar.getObjContent();
                        } else {
                            jSONObject = new JSONObject(bVar.getContent());
                        }
                        String optString = jSONObject.optString("uk");
                        long optLong = jSONObject.optLong("timestamp");
                        if (!hashMap.containsKey(optString) || (hashMap.containsKey(optString) && ((Long) hashMap.get(optString)).longValue() < optLong)) {
                            hashMap.put(optString, Long.valueOf(optLong));
                            hashMap2.put(optString, bVar.getContent());
                        }
                    } catch (JSONException e) {
                    }
                }
            }
            if (!ListUtils.isEmpty(hashMap2)) {
                for (Map.Entry entry : hashMap2.entrySet()) {
                    if (!StringUtils.isNull((String) entry.getValue(), true)) {
                        if (!com.baidu.live.ap.b.YX().jt(com.baidu.live.ap.b.YX().Zc())) {
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
    public void W(List<b> list) {
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = new ArrayList();
            if (this.aVr) {
                if (ListUtils.isEmpty(this.box)) {
                    return;
                }
            } else if (ListUtils.isEmpty(this.boy)) {
                return;
            }
            for (b bVar : list) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public List<b> at(List<b> list) {
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (b bVar : list) {
            if (bVar != null && "audio_emoticon".equals(x(bVar)) && !this.bXl.contains(Long.valueOf(bVar.getMsgId())) && (com.baidu.live.ap.b.YX().jt(ExtraParamsManager.getEncryptionUserId(bVar.getUserId() + "")) || !StringUtils.isNull(F(bVar), true))) {
                arrayList.add(bVar);
                this.bXl.add(Long.valueOf(bVar.getMsgId()));
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
                        AlaEmoticonView.a(optString, optString2, new AlaEmoticonView.b() { // from class: com.baidu.live.yuyinim.b.a.9
                            @Override // com.baidu.live.tieba.view.AlaEmoticonView.b
                            public void Vn() {
                                if (str == a.this.mGroupId) {
                                    a.this.a(list, bVar);
                                    if (!bVar.NX()) {
                                        a.this.F(optString, optString2, optString3);
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
    public void F(String str, String str2, String str3) {
        if (!StringUtils.isNull(str, true) && !StringUtils.isNull(str3, true)) {
            HashMap hashMap = new HashMap();
            hashMap.put("user_uk", str3);
            hashMap.put("webp_url", str);
            hashMap.put("result_url", str2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501022, hashMap));
        }
    }

    private String x(b bVar) {
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

    private int D(b bVar) {
        JSONObject jSONObject;
        try {
            if (bVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) bVar.getObjContent();
            } else {
                jSONObject = new JSONObject(bVar.getContent());
            }
            return jSONObject.optInt("activity_stage");
        } catch (JSONException e) {
            return -1;
        }
    }

    private int E(b bVar) {
        JSONObject jSONObject;
        try {
            if (bVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) bVar.getObjContent();
            } else {
                jSONObject = new JSONObject(bVar.getContent());
            }
            return jSONObject.optInt("confession");
        } catch (JSONException e) {
            return -1;
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
            return jSONObject.optJSONObject("emoticon_info").optString("result_img");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
