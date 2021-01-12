package com.baidu.live.yuyinim.controller;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
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
import com.baidu.live.data.ck;
import com.baidu.live.data.x;
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
    private final ALaImMsgView bYU;
    private final ALALiveTextView bYV;
    private List<String> blt;
    private List<String> blu;
    private k.a blw;
    private String mGroupId;
    private TbPageContext mPageContext;
    private boolean aSj = false;
    private Set<Long> bYW = new HashSet();
    private CustomMessageListener bio = new CustomMessageListener(2913038) { // from class: com.baidu.live.yuyinim.controller.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                List list = (List) customResponsedMessage.getData();
                a.this.W(list);
                a.this.aw(list);
                a.this.au(list);
                a.this.av(list);
                List ay = a.this.ay(list);
                a.this.d((List<b>) list, true);
                a.this.j(list, ay);
            }
        }
    };
    private CustomMessageListener bip = new CustomMessageListener(2913037) { // from class: com.baidu.live.yuyinim.controller.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof b)) {
                b bVar = (b) customResponsedMessage.getData();
                if (!a.this.aSj && bVar != null && (bVar.JB() instanceof com.baidu.live.data.a)) {
                    bVar.JB().aEl = -1;
                }
                a.this.t(bVar);
            }
        }
    };
    private CustomMessageListener blx = new CustomMessageListener(2913044) { // from class: com.baidu.live.yuyinim.controller.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        }
    };
    private CustomMessageListener bly = new CustomMessageListener(2913095) { // from class: com.baidu.live.yuyinim.controller.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                if (a.this.bYV != null) {
                    a.this.bYV.gJ(str);
                }
            }
        }
    };
    private final a.InterfaceC0230a blA = new a.InterfaceC0230a() { // from class: com.baidu.live.yuyinim.controller.a.6
        @Override // com.baidu.live.view.input.a.InterfaceC0230a
        public boolean IJ() {
            return a.this.blw != null && a.this.blw.IJ();
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0230a
        public void t(String str, boolean z) {
            Log.i("i", "@@@ localText nmpanctr sdhdl 1");
            if (a.this.blw != null) {
                if (a.this.blw.IJ()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (a.this.bYV != null && a.this.bYV.Ky()) {
                        ck barrageInfo = a.this.bYV.getBarrageInfo();
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
                    }
                    Log.i("i", "@@@ localText nmpanctr sdhdl cmd");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
                    if (!z && a.this.bYV != null) {
                        a.this.bYV.KC();
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

        @Override // com.baidu.live.view.input.a.InterfaceC0230a
        public void IL() {
            if (a.this.blw != null) {
                a.this.blw.IL();
            }
        }

        @Override // com.baidu.live.view.input.a.InterfaceC0230a
        public void IM() {
            if (a.this.blw != null) {
                a.this.blw.IM();
            }
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
    private Runnable blC = new Runnable() { // from class: com.baidu.live.yuyinim.controller.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bYU.XS();
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.bYU = new ALaImMsgView(tbPageContext.getPageActivity());
        this.bYU.setPageContext(this.mPageContext);
        this.bYU.setNeedTopAlphaShade(true);
        this.bYU.setMode(false);
        this.bYV = new ALALiveTextView(tbPageContext.getPageActivity(), tbPageContext);
        this.bYV.setMsHandler(this.blA);
        this.bYV.setBdPageContext(tbPageContext);
        this.blt = new ArrayList();
        this.blu = new ArrayList();
        this.blt.add("allin");
    }

    @Override // com.baidu.live.im.k
    public void setFromMaster(boolean z) {
        this.aSj = z;
        if (this.bYU != null) {
            this.bYU.setFromMaster(z);
        }
        if (this.bYV != null) {
            this.bYV.setFromMaster(z);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(ViewGroup viewGroup, x xVar, List<String> list, RelativeLayout.LayoutParams layoutParams) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<b> list, boolean z) {
        if (this.bYU != null) {
            boolean az = this.bYU.az(list);
            this.bYU.setMsgData(list);
            if (az) {
                this.bYU.KP();
                if (z) {
                    this.bYU.postDelayed(new Runnable() { // from class: com.baidu.live.yuyinim.controller.a.7
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.bYU.IE();
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
            if (this.bYU != null) {
                this.bYU.setMsgData(list);
                this.bYU.KP();
                this.bYU.postDelayed(new Runnable() { // from class: com.baidu.live.yuyinim.controller.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.bYU.IE();
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
            if ("enter_live".equals(str) && com.baidu.live.entereffect.a.BG().h(bVar)) {
                this.bYU.B(bVar);
            }
        }
    }

    @Override // com.baidu.live.im.k
    public j IF() {
        return this.bYU;
    }

    @Override // com.baidu.live.im.k
    public com.baidu.live.view.input.a IG() {
        return this.bYV;
    }

    @Override // com.baidu.live.im.k
    public com.baidu.live.view.input.b IH() {
        return null;
    }

    @Override // com.baidu.live.im.k
    public void setLogData(String str, String str2) {
        if (this.bYV != null) {
            this.bYV.setLogData(str, str2);
        }
        if (this.bYU != null) {
            this.bYU.setLogData(str, str2);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(String str, String str2, String str3, String str4, String str5, boolean z, String str6) {
        this.mGroupId = str;
        MessageManager.getInstance().registerListener(this.bio);
        MessageManager.getInstance().registerListener(this.bip);
        MessageManager.getInstance().registerListener(this.blx);
        MessageManager.getInstance().registerListener(this.bly);
        this.bYW.clear();
        this.bYU.HN();
        this.bYU.a(str, str4, !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str3), str3, str6);
        MessageManager.getInstance().registerListener(this.bYV.blj);
        MessageManager.getInstance().registerListener(this.bYV.bdo);
    }

    @Override // com.baidu.live.im.k
    public void zh() {
        MessageManager.getInstance().unRegisterListener(this.bio);
        MessageManager.getInstance().unRegisterListener(this.bip);
        MessageManager.getInstance().unRegisterListener(this.blx);
        MessageManager.getInstance().unRegisterListener(this.bly);
        this.bYW.clear();
        if (this.bYU != null) {
            this.bYU.Jl();
        }
        if (this.bYV != null) {
            this.bYV.KC();
            MessageManager.getInstance().unRegisterListener(this.bYV.blj);
            MessageManager.getInstance().unRegisterListener(this.bYV.bdo);
        }
        LiveTimerManager.getInstance().removeLiveTimerTask("live_show_tag_view", true);
        SafeHandler.getInst().removeCallbacks(this.blC);
    }

    @Override // com.baidu.live.im.k
    public void g(Map<String, Integer> map) {
        if (this.bYV != null) {
            this.bYV.g(map);
        }
    }

    @Override // com.baidu.live.im.k
    public void a(k.a aVar) {
        this.blw = aVar;
    }

    @Override // com.baidu.live.im.k
    public void a(boolean z, int i, int i2, String str) {
        if (this.bYV != null) {
            this.bYV.b(z, i, i2, str);
        }
    }

    @Override // com.baidu.live.im.k
    public int getImMsgListViewTop() {
        return 0;
    }

    @Override // com.baidu.live.im.k
    public int getImMsgListViewHeight() {
        return this.bYU.getHeight();
    }

    @Override // com.baidu.live.im.k
    public int II() {
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
    public void au(List<b> list) {
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = null;
            for (b bVar : list) {
                if (bVar != null && TextUtils.equals("switch_activity_stage", z(bVar))) {
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
                    if (G(bVar2) == 2) {
                        BdUtilHelper.showToast(DBResource.getContext(), "无成功匹配，本轮约会结束");
                        z = true;
                    }
                    if (!z && F(bVar2) == 0) {
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
    public void av(List<b> list) {
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = null;
            for (b bVar : list) {
                if (bVar != null && TextUtils.equals("audio_link_online", z(bVar))) {
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
    public void aw(List<b> list) {
        if (!ListUtils.isEmpty(list)) {
            ArrayList arrayList = null;
            for (b bVar : list) {
                if (bVar != null && TextUtils.equals("sync_audio_speeker_status", z(bVar))) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(bVar);
                }
            }
            if (!ListUtils.isEmpty(arrayList)) {
                list.removeAll(arrayList);
                ax(arrayList);
            }
        }
    }

    private void ax(List<b> list) {
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
                        if (!com.baidu.live.aq.a.Wu().ib(com.baidu.live.aq.a.Wu().Wz())) {
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
            if (this.aSj) {
                if (ListUtils.isEmpty(this.blt)) {
                    return;
                }
            } else if (ListUtils.isEmpty(this.blu)) {
                return;
            }
            for (b bVar : list) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public List<b> ay(List<b> list) {
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (b bVar : list) {
            if (bVar != null && "audio_emoticon".equals(z(bVar)) && !this.bYW.contains(Long.valueOf(bVar.getMsgId())) && (com.baidu.live.aq.a.Wu().ib(ExtraParamsManager.getEncryptionUserId(bVar.getUserId() + "")) || !StringUtils.isNull(H(bVar), true))) {
                arrayList.add(bVar);
                this.bYW.add(Long.valueOf(bVar.getMsgId()));
            }
        }
        list.removeAll(arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final List<b> list, List<b> list2) {
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
                                    if (!bVar.JE()) {
                                        a.this.H(optString, optString2, optString3);
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
    public void H(String str, String str2, String str3) {
        if (!StringUtils.isNull(str, true) && !StringUtils.isNull(str3, true)) {
            HashMap hashMap = new HashMap();
            hashMap.put("user_uk", str3);
            hashMap.put("webp_url", str);
            hashMap.put("result_url", str2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501022, hashMap));
        }
    }

    private String z(b bVar) {
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

    private int F(b bVar) {
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

    private int G(b bVar) {
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

    private String H(b bVar) {
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
