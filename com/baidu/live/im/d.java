package com.baidu.live.im;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.listener.NetMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.framework.message.ResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.NetWorkChangedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.w;
import com.baidu.live.gift.GiftPackageConsumeHttpResponsedMessage;
import com.baidu.live.gift.ac;
import com.baidu.live.im.b;
import com.baidu.live.im.data.ImForbiddenStateData;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.message.ALAGroupCommitHttpResponsedMessage;
import com.baidu.live.im.message.ALAGroupHttpResponseMessage;
import com.baidu.live.im.message.AlaForbiddenWordsStateResponseMessage;
import com.baidu.live.im.message.AlaLuckBagSendHttpResponseMessage;
import com.baidu.live.message.AlaGetLiveStatusHttpResponseMessage;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.media.duplayer.LibsInfoDef;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends BdBaseModel {
    private w aFN;
    private List<AlaLiveMarkData> aKB;
    private boolean aXR;
    private CustomMessageListener bfm;
    private HttpMessageListener bfu;
    private String bkA;
    private boolean bkB;
    private boolean bkC;
    private int bkD;
    private int bkE;
    private boolean bkF;
    private LinkedHashMap<String, HashMap<Long, h>> bkG;
    private HashMap<String, HashMap<Long, h>> bkH;
    private b.a bkI;
    private Runnable bkJ;
    private Runnable bkK;
    private CustomMessageListener bkL;
    private CustomMessageListener bkM;
    private Runnable bkN;
    private HttpMessageListener bkO;
    private HttpMessageListener bkP;
    private HttpMessageListener bkQ;
    private HttpMessageListener bkR;
    private HttpMessageListener bkS;
    private NetMessageListener bkT;
    CustomMessageListener bkU;
    CustomMessageListener bkV;
    CustomMessageListener bkW;
    CustomMessageListener bkX;
    CustomMessageListener bkY;
    private HttpMessageListener bkZ;
    public int bkn;
    public int bko;
    public int bkp;
    private boolean bkq;
    private a bkr;
    private String bks;
    private String bkt;
    private List<com.baidu.live.im.data.b> bku;
    private int bkv;
    private int bkw;
    private int bkx;
    private float bky;
    private String bkz;
    private long count;
    private String mAppId;
    private String mGroupId;
    private Handler mHandler;
    private String mLiveId;
    private LinkedList<com.baidu.live.im.data.b> mMsgList;
    BdPageContext<?> mPageContext;
    private HttpMessageListener syncListener;

    /* loaded from: classes4.dex */
    public interface a {
        void ME();

        void d(List<com.baidu.live.im.data.b> list, boolean z);

        void t(com.baidu.live.im.data.b bVar);
    }

    static /* synthetic */ int h(d dVar) {
        int i = dVar.bkx;
        dVar.bkx = i + 1;
        return i;
    }

    public d(BdPageContext<?> bdPageContext, boolean z, a aVar) {
        super(bdPageContext);
        this.mLiveId = null;
        this.bky = 1.0f;
        this.mHandler = new Handler();
        this.bkz = null;
        this.aXR = false;
        this.bkA = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION;
        this.bkB = false;
        this.bkC = false;
        this.bkE = 0;
        this.bkF = false;
        this.bkI = new b.a() { // from class: com.baidu.live.im.d.1
        };
        this.bkJ = new Runnable() { // from class: com.baidu.live.im.d.12
            @Override // java.lang.Runnable
            public void run() {
                int i = d.this.bkx * d.this.bkv;
                if (i >= d.this.bku.size()) {
                    d.this.MA();
                } else if (d.this.bkx >= d.this.bkw - 1) {
                    if (d.this.bkx != d.this.bkw - 1) {
                        d.this.MA();
                        return;
                    }
                    ArrayList arrayList = new ArrayList(d.this.bku);
                    d.this.N(d.this.b(arrayList.subList(i, arrayList.size()), true));
                    d.h(d.this);
                    d.this.MA();
                } else {
                    ArrayList arrayList2 = new ArrayList(d.this.bku);
                    if (d.this.bkv + i <= arrayList2.size()) {
                        d.this.N(d.this.b(arrayList2.subList(i, d.this.bkv + i), true));
                        d.h(d.this);
                        d.this.mHandler.postDelayed(d.this.bkJ, 250L);
                        return;
                    }
                    d.this.N(d.this.b(arrayList2.subList(i, arrayList2.size()), true));
                    d.h(d.this);
                    d.this.MA();
                }
            }
        };
        this.bkK = new Runnable() { // from class: com.baidu.live.im.d.16
            @Override // java.lang.Runnable
            public void run() {
                d.this.MD();
            }
        };
        this.bfm = new CustomMessageListener(2913238) { // from class: com.baidu.live.im.d.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null) {
                    d.this.aXR = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
            }
        };
        this.bkL = new CustomMessageListener(MessageConfig.SOCKET_RECEIVE_MSG) { // from class: com.baidu.live.im.d.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.Mw();
            }
        };
        this.bkM = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.live.im.d.19
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        com.baidu.live.im.a aVar2 = new com.baidu.live.im.a();
                        aVar2.setMsgType(27);
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("text", d.this.mPageContext.getString(a.h.sdk_im_offline));
                            jSONObject.put("content_type", "custom_network_change");
                            aVar2.setContent(jSONObject.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        d.this.a(-1, aVar2);
                        if (d.this.bkr != null) {
                            d.this.bkr.t(aVar2);
                            d.this.bkr.d(d.this.mMsgList, true);
                        }
                    } else if (((NetWorkChangedMessage) customResponsedMessage).mLastNetState == 0 && BdNetTypeUtil.isNetWorkAvailable()) {
                        com.baidu.live.im.a aVar3 = new com.baidu.live.im.a();
                        aVar3.setMsgType(27);
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("text", d.this.mPageContext.getString(a.h.sdk_im_online));
                            jSONObject2.put("content_type", "custom_network_change");
                            aVar3.setContent(jSONObject2.toString());
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        d.this.a(-1, aVar3);
                        if (d.this.bkr != null) {
                            d.this.bkr.t(aVar3);
                            d.this.bkr.d(d.this.mMsgList, true);
                        }
                    }
                }
            }
        };
        this.bkN = new Runnable() { // from class: com.baidu.live.im.d.20
            @Override // java.lang.Runnable
            public void run() {
                if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().getLastReceDataTime() > 35000) {
                    d.this.Mv();
                }
                d.this.Mu();
            }
        };
        this.bkO = new HttpMessageListener(1021013) { // from class: com.baidu.live.im.d.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    boolean z2 = false;
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        int error = httpResponsedMessage.getError();
                        if (com.baidu.live.ae.a.RB().brA.aOy == 1) {
                            if (error == 149010) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913070, d.this.mPageContext.getPageActivity().getString(a.h.im_improper_content_tip)));
                                z2 = true;
                            } else if (error == 1202 || error == 1203) {
                                BdUtilHelper.showToast(d.this.mPageContext.getPageActivity(), d.this.mPageContext.getPageActivity().getString(a.h.im_improper_content_tip_net));
                                z2 = true;
                            } else if (error == 1204) {
                                BdUtilHelper.showToast(d.this.mPageContext.getPageActivity(), d.this.mPageContext.getPageActivity().getString(a.h.im_improper_content_tip));
                                z2 = true;
                            }
                        }
                    }
                    if (!z2 && d.this.bkr != null) {
                        d.this.bkr.ME();
                    }
                }
            }
        };
        this.bkP = new HttpMessageListener(1021015) { // from class: com.baidu.live.im.d.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof com.baidu.live.gift.i) {
                        com.baidu.live.gift.i iVar = (com.baidu.live.gift.i) orginalMessage;
                        boolean z2 = false;
                        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            z2 = true;
                            if (!d.this.bkF) {
                                d.this.h(iVar.aWP, iVar.giftName);
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                        }
                        if (d.this.bkF) {
                            d.this.a(iVar.giftId, iVar.aWP, iVar.aWT, z2, iVar.aWV);
                        }
                    }
                }
            }
        };
        this.bfu = new HttpMessageListener(1021229) { // from class: com.baidu.live.im.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021229 && (httpResponsedMessage instanceof AlaLuckBagSendHttpResponseMessage)) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof com.baidu.live.gift.m) {
                        com.baidu.live.gift.m mVar = (com.baidu.live.gift.m) orginalMessage;
                        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            if (d.this.bkF) {
                                d.this.a(mVar.giftId, mVar.aWP, mVar.aWT, true, mVar.aWV);
                            }
                            if (!d.this.bkF) {
                                d.this.h(mVar.aWP, mVar.giftName);
                                return;
                            }
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                        if (d.this.bkF) {
                            d.this.a(mVar.giftId, mVar.aWP, mVar.aWT, false, mVar.aWV);
                        }
                        com.baidu.live.im.data.b a2 = d.this.a((AlaLuckBagSendHttpResponseMessage) httpResponsedMessage);
                        if (a2 != null) {
                            d.this.a(-1, a2);
                            if (d.this.bkr != null) {
                                d.this.bkr.t(a2);
                                d.this.bkr.d(d.this.mMsgList, true);
                            }
                        }
                    }
                }
            }
        };
        this.bkQ = new HttpMessageListener(1021014) { // from class: com.baidu.live.im.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof com.baidu.live.gift.p) {
                        com.baidu.live.gift.p pVar = (com.baidu.live.gift.p) orginalMessage;
                        boolean z2 = false;
                        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            z2 = true;
                            if (!d.this.bkF) {
                                d.this.h(pVar.aWP, pVar.giftName);
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                        }
                        if (d.this.bkF) {
                            d.this.a(pVar.giftId, pVar.aWP, pVar.aWT, z2, pVar.aWV);
                        }
                    }
                }
            }
        };
        this.bkR = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.live.im.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                boolean z2;
                boolean z3;
                if (httpResponsedMessage != null) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof com.baidu.live.gift.q) {
                        com.baidu.live.gift.q qVar = (com.baidu.live.gift.q) orginalMessage;
                        if ((httpResponsedMessage instanceof GiftPackageConsumeHttpResponsedMessage) && TextUtils.isEmpty(((GiftPackageConsumeHttpResponsedMessage) httpResponsedMessage).aXU)) {
                            if (!d.this.bkF) {
                                d.this.h(qVar.aXC, qVar.giftName);
                            }
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            if (!d.this.bkF) {
                                d.this.h(qVar.aXC, qVar.giftName);
                            }
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (d.this.bkF) {
                            d.this.a(qVar.giftId, qVar.aXC, qVar.aWT, z3, qVar.aWV);
                        }
                    }
                }
            }
        };
        this.bkS = new HttpMessageListener(1021012) { // from class: com.baidu.live.im.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                d.this.a((ResponsedMessage<?>) httpResponsedMessage, false);
            }
        };
        this.bkT = new NetMessageListener(1021050, 601008) { // from class: com.baidu.live.im.d.6
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                JSONObject jSONObject;
                AlaGetLiveStatusHttpResponseMessage alaGetLiveStatusHttpResponseMessage = responsedMessage instanceof AlaGetLiveStatusHttpResponseMessage ? (AlaGetLiveStatusHttpResponseMessage) responsedMessage : null;
                if (alaGetLiveStatusHttpResponseMessage != null && alaGetLiveStatusHttpResponseMessage.brp != null) {
                    try {
                        jSONObject = new JSONObject(alaGetLiveStatusHttpResponseMessage.brp);
                    } catch (JSONException e) {
                        jSONObject = null;
                    }
                    if (jSONObject != null) {
                        if (!"backstage_live".equals(jSONObject.optString("content_type"))) {
                            d.this.a(alaGetLiveStatusHttpResponseMessage.brp, jSONObject, 12, false);
                            return;
                        }
                        String optString = jSONObject.optString("backstage_type");
                        String optString2 = jSONObject.optString("text");
                        if (!TextUtils.isEmpty(optString) && !optString.equals(d.this.bkz) && !TextUtils.isEmpty(optString2)) {
                            d.this.a(alaGetLiveStatusHttpResponseMessage.brp, jSONObject, 13, true);
                            d.this.bkz = optString;
                        }
                    }
                }
            }
        };
        this.count = 1L;
        this.bkU = new CustomMessageListener(2913192) { // from class: com.baidu.live.im.d.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText banlstn sd=" + d.this.aFN);
                if (d.this.aFN != null) {
                    if (d.this.aFN.mLiveInfo.getUserID() == Long.valueOf(TbadkCoreApplication.getCurrentAccount()).longValue()) {
                        Log.i("i", "@@@ localText banlstn own");
                        if (d.this.aFN.aJV != null && d.this.aFN.mLiveInfo != null) {
                            Log.i("i", "@@@ localText banlstn own sdreq");
                            d.this.g(d.this.aFN.aJV.userId, d.this.aFN.mLiveInfo.live_id);
                            return;
                        }
                        return;
                    }
                    Log.i("i", "@@@ localText banlstn oth");
                    if (d.this.aFN.aKr != null && d.this.aFN.mLiveInfo != null) {
                        Log.i("i", "@@@ localText banlstn oth sdreq");
                        d.this.g(d.this.aFN.aKr.userId, d.this.aFN.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.live.im.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                    AlaSyncHttpResponseMessage alaSyncHttpResponseMessage = (AlaSyncHttpResponseMessage) httpResponsedMessage;
                    if (alaSyncHttpResponseMessage.getError() == 0 && alaSyncHttpResponseMessage.PR() != null) {
                        d.this.bkn = alaSyncHttpResponseMessage.PR().aOz;
                        d.this.bko = alaSyncHttpResponseMessage.PR().aOA;
                        d.this.bkp = alaSyncHttpResponseMessage.PR().aOB;
                    }
                }
            }
        };
        this.bkV = new CustomMessageListener(2913185) { // from class: com.baidu.live.im.d.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                h hVar;
                com.baidu.live.im.data.b a2;
                if (d.this.bkF && customResponsedMessage != null && (customResponsedMessage.getData() instanceof h) && (a2 = d.this.a((hVar = (h) customResponsedMessage.getData()))) != null) {
                    double m = d.this.m(a2);
                    a2.setMsgId(0L);
                    a2.setRecordId(0L);
                    com.baidu.live.data.a NU = a2.NU();
                    if (NU != null && !StringUtils.isNull(NU.userId) && !StringUtils.isNull(hVar.giftId)) {
                        String str = NU.userId;
                        String nameShow = NU.getNameShow();
                        String str2 = str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + hVar.giftId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + nameShow;
                        if (d.this.bkH == null) {
                            d.this.bkH = new HashMap();
                        }
                        hVar.bmt = a2;
                        hVar.userId = str;
                        hVar.userName = nameShow;
                        hVar.bmw = m;
                        if (d.this.aXR) {
                            d.this.b(hVar);
                        }
                        if (!d.this.bkH.containsKey(str2)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put(Long.valueOf(hVar.aWT), hVar);
                            d.this.bkH.put(str2, hashMap);
                            return;
                        }
                        ((HashMap) d.this.bkH.get(str2)).put(Long.valueOf(hVar.aWT), hVar);
                    }
                }
            }
        };
        this.bkW = new CustomMessageListener(2913184) { // from class: com.baidu.live.im.d.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                    i iVar = (i) customResponsedMessage.getData();
                    if (iVar.bmD > 0) {
                        HashMap hashMap = (HashMap) d.this.bkG.get(iVar.bcO);
                        if (hashMap != null && !hashMap.isEmpty()) {
                            h hVar = (h) hashMap.remove(Long.valueOf(iVar.bmD));
                            if (hVar != null) {
                                hVar.bmz = true;
                                hVar.bmt.aU(hVar.count);
                                hVar.bmt.n(hVar.bmw);
                                if (hVar.bmt.isHost()) {
                                    hVar.bmt.aV(-1L);
                                } else {
                                    hVar.bmt.aV(hVar.bmv);
                                }
                                if (!d.this.s(hVar.bmt)) {
                                    d.this.a(-1, hVar.bmt);
                                    if (d.this.bkr != null) {
                                        d.this.bkr.d(d.this.mMsgList, true);
                                    }
                                }
                            }
                            if (hashMap.isEmpty()) {
                                d.this.bkG.remove(iVar.bcO);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    HashMap hashMap2 = (HashMap) d.this.bkH.get(iVar.bcO);
                    if (hashMap2 != null && !hashMap2.isEmpty()) {
                        h hVar2 = (h) hashMap2.get(Long.valueOf(iVar.bmF));
                        if (hVar2 != null) {
                            if (hVar2.bmy != 0) {
                                hVar2.bmz = true;
                                return;
                            }
                            hashMap2.remove(Long.valueOf(iVar.bmF));
                            hVar2.bmt.aU(hVar2.count);
                            hVar2.bmt.n(hVar2.bmw);
                            if (hVar2.bmt.isHost()) {
                                hVar2.bmt.aV(-1L);
                            } else {
                                hVar2.bmt.aV(hVar2.bmv);
                            }
                            if (!d.this.s(hVar2.bmt)) {
                                d.this.a(-1, hVar2.bmt);
                                if (d.this.bkr != null) {
                                    d.this.bkr.d(d.this.mMsgList, true);
                                }
                            }
                            long j = hVar2.bmu;
                            if (j > 0) {
                                d.this.h(j, hVar2.giftName);
                            }
                        }
                        if (hashMap2.isEmpty()) {
                            d.this.bkH.remove(iVar.bcO);
                        }
                    }
                }
            }
        };
        this.bkX = new CustomMessageListener(2913183) { // from class: com.baidu.live.im.d.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                    i iVar = (i) customResponsedMessage.getData();
                    if (iVar.bmD == 0) {
                        HashMap hashMap = (HashMap) d.this.bkH.get(iVar.bcO);
                        if (hashMap != null && !hashMap.isEmpty()) {
                            h hVar = (h) hashMap.get(Long.valueOf(iVar.bmF));
                            h hVar2 = (h) hashMap.get(Long.valueOf(iVar.bmI));
                            if (hVar != null && hVar2 != null) {
                                hashMap.remove(Long.valueOf(iVar.bmI));
                                hVar.count += hVar2.count;
                                hVar.bmv += hVar2.bmv;
                                hVar.bmu += hVar2.bmu;
                                hVar.bmy += hVar2.bmy;
                                if (hVar.bmw != hVar2.bmw) {
                                    hVar.bmw = 0.0d;
                                }
                                hVar.bmA.add(Long.valueOf(hVar2.aWT));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    HashMap hashMap2 = (HashMap) d.this.bkG.get(iVar.bcO);
                    if (hashMap2 != null && !hashMap2.isEmpty() && iVar.bmD != iVar.bmG) {
                        h hVar3 = (h) hashMap2.get(Long.valueOf(iVar.bmD));
                        h hVar4 = (h) hashMap2.remove(Long.valueOf(iVar.bmG));
                        if (hVar3 != null && hVar4 != null) {
                            hVar3.count += hVar4.count;
                            hVar3.bmv += hVar4.bmv;
                            if (hVar3.bmw != hVar4.bmw) {
                                hVar3.bmw = 0.0d;
                            }
                        }
                    }
                }
            }
        };
        this.bkY = new CustomMessageListener(2913195) { // from class: com.baidu.live.im.d.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                HashMap hashMap;
                h hVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                    i iVar = (i) customResponsedMessage.getData();
                    if (iVar.bmD != 0 && (hashMap = (HashMap) d.this.bkG.get(iVar.bcO)) != null && !hashMap.isEmpty() && (hVar = (h) hashMap.get(Long.valueOf(iVar.bmD))) != null) {
                        hVar.count = iVar.bmJ;
                        hVar.bmv = iVar.bmK;
                    }
                }
            }
        };
        this.bkZ = new HttpMessageListener(1021194) { // from class: com.baidu.live.im.d.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                d.this.bkB = false;
                d.this.mHandler.removeCallbacks(d.this.bkK);
                if (httpResponsedMessage != null) {
                    if (httpResponsedMessage.getOrginalMessage() == null || !(httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.im.message.c) || !((com.baidu.live.im.message.c) httpResponsedMessage.getOrginalMessage()).aY(System.currentTimeMillis())) {
                        if (d.this.bkC) {
                            d.this.bkC = false;
                            return;
                        } else if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            ImForbiddenStateData imForbiddenStateData = new ImForbiddenStateData();
                            imForbiddenStateData.errno = httpResponsedMessage.getError();
                            imForbiddenStateData.errMsg = httpResponsedMessage.getErrorString();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, imForbiddenStateData));
                            return;
                        } else if (httpResponsedMessage instanceof AlaForbiddenWordsStateResponseMessage) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, ((AlaForbiddenWordsStateResponseMessage) httpResponsedMessage).bpj));
                            return;
                        } else {
                            return;
                        }
                    }
                    d.this.bkC = false;
                }
            }
        };
        this.bkn = com.baidu.live.ae.a.RB().brA.aOz;
        this.bko = com.baidu.live.ae.a.RB().brA.aOA;
        this.bkp = com.baidu.live.ae.a.RB().brA.aOB;
        this.mPageContext = bdPageContext;
        this.bkq = z;
        this.bkr = aVar;
        this.mMsgList = new LinkedList<>();
        this.bkG = new LinkedHashMap<>();
        this.bkH = new HashMap<>();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913182, Object.class);
        if (runTask != null && runTask.getData() != null) {
            this.bkF = true;
        }
        MessageManager.getInstance().registerTask(Mt());
        com.baidu.live.tieba.f.a.a.a(1021050, "alaim/gmsg/getLiveStatus", AlaGetLiveStatusHttpResponseMessage.class, false, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021012, "alaim/gmsg/getGroupMsg", ALAGroupHttpResponseMessage.class, false, true, true, true);
        MC();
        registerListener(this.bkZ);
        MessageManager.getInstance().registerListener(this.syncListener);
    }

    public void setAlaLiveShowData(w wVar) {
        this.aFN = wVar;
        if (this.aFN != null && this.aFN.mLiveInfo != null) {
            this.bkD = this.aFN.mLiveInfo.audience_count - this.aFN.mLiveInfo.ai_robot_num;
        }
    }

    private HttpMessageTask Mt() {
        HttpMessageTask httpMessageTask = new HttpMessageTask(1021013, TbConfig.SERVER_ADDRESS + "alaim/gmsg/commitGroupMsg");
        httpMessageTask.setResponsedClass(ALAGroupCommitHttpResponsedMessage.class);
        return httpMessageTask;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    @Deprecated
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mu() {
        this.mHandler.postDelayed(this.bkN, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mv() {
        sendMessage(new com.baidu.live.im.message.b(JavaTypesHelper.toInt(this.mGroupId, 0), getLastMid()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mw() {
        this.mHandler.removeCallbacks(this.bkN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.live.im.data.b a(AlaLuckBagSendHttpResponseMessage alaLuckBagSendHttpResponseMessage) {
        JSONObject jSONObject = new JSONObject();
        try {
            com.baidu.live.gift.m mVar = (com.baidu.live.gift.m) alaLuckBagSendHttpResponseMessage.getmOrginalMessage();
            jSONObject.put("content_type", "luckybag_win_prize");
            jSONObject.put("user_name", "您");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("prize_total_value", alaLuckBagSendHttpResponseMessage.Or());
            jSONObject2.put("lucky_bag_id", alaLuckBagSendHttpResponseMessage.Ou());
            jSONObject2.put("lucky_bag_img", alaLuckBagSendHttpResponseMessage.Os());
            jSONObject2.put("lucky_bag_name", alaLuckBagSendHttpResponseMessage.Ot());
            List<com.baidu.live.im.data.a> Op = alaLuckBagSendHttpResponseMessage.Op();
            if (Op != null && !Op.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (com.baidu.live.im.data.a aVar : Op) {
                    jSONArray.put(aVar.toJson());
                }
                jSONObject2.put("prize_member", jSONArray);
            }
            List<com.baidu.live.im.data.a> Oq = alaLuckBagSendHttpResponseMessage.Oq();
            if (Oq != null && !Oq.isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                for (com.baidu.live.im.data.a aVar2 : Oq) {
                    jSONArray2.put(aVar2.toJson());
                }
                jSONObject2.put("surprise_prize_member", jSONArray2);
            }
            jSONObject.put("ext_data", jSONObject2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913276, jSONObject));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a((short) 13, jSONObject.toString(), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), this.aKB);
    }

    public void h(long j, String str) {
        if (j == 0) {
            j = 1;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.mPageContext.getString(a.h.sdk_gift);
        }
        com.baidu.live.im.data.b a2 = a((short) 27, String.format(this.mPageContext.getString(a.h.sdk_send_gift_fail), Long.valueOf(j), str), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), this.aKB);
        if (a2 != null) {
            a(-1, a2);
            if (this.bkr != null) {
                this.bkr.t(a2);
                this.bkr.d(this.mMsgList, true);
            }
        }
    }

    public com.baidu.live.im.data.b a(h hVar) {
        JSONObject b;
        if (hVar == null) {
            return null;
        }
        String str = hVar.count + "";
        String str2 = hVar.giftName;
        if (TextUtils.isEmpty(str)) {
            str = "1";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = this.mPageContext.getString(a.h.sdk_gift);
        }
        if (hVar.bmC) {
            b = r(hVar.giftId, str, str2);
        } else {
            b = b(hVar.giftId, str, str2, 0L, hVar.bmx);
        }
        return a((short) 24, b.toString(), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), this.aKB);
    }

    private JSONObject b(String str, String str2, String str3, long j, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_GIFT_ID, str);
            jSONObject.put("gift_count", str2);
            jSONObject.put("gift_name", str3);
            jSONObject.put("charm_value", j / 10);
            jSONObject.put("is_free", z ? 1 : 0);
            jSONObject.put("gift_rate", 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject r(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content_type", "luckybag_send");
            jSONObject.put(LogConfig.LOG_GIFT_ID, str);
            jSONObject.put("gift_count", str2);
            jSONObject.put("gift_name", str3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, JSONObject jSONObject, int i, boolean z) {
        com.baidu.live.im.a aVar = new com.baidu.live.im.a();
        aVar.setMsgType(i);
        aVar.setContent(str);
        aVar.setObjContent(jSONObject);
        if (z) {
            a(-1, aVar);
        }
        if (this.bkr != null) {
            this.bkr.t(aVar);
            if (z) {
                this.bkr.d(this.mMsgList, true);
            }
        }
    }

    protected void a(ResponsedMessage<?> responsedMessage, boolean z) {
        boolean z2;
        long j;
        List<com.baidu.live.im.data.b> list;
        if (responsedMessage instanceof ALAGroupHttpResponseMessage) {
            List<com.baidu.live.im.data.b> Oo = ((ALAGroupHttpResponseMessage) responsedMessage).Oo();
            j = ((ALAGroupHttpResponseMessage) responsedMessage).getGroupId();
            list = Oo;
            z2 = ((ALAGroupHttpResponseMessage) responsedMessage).On();
        } else {
            z2 = false;
            j = 0;
            list = null;
        }
        if (j == JavaTypesHelper.toLong(this.mGroupId, 0L) && list != null && !list.isEmpty()) {
            if (TbadkCoreApplication.getInst().isOther()) {
                if (z2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913167, list));
                    return;
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913146, list));
                    return;
                }
            }
            if (z2) {
                Q(list);
            }
            if (TbConfig.isForceNoticeIm && list != null && !list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                    com.baidu.live.im.data.b bVar = list.get(i);
                    if (bVar.getMsgType() == 13 || bVar.getMsgType() == 24) {
                        if (TbConfig.forceImType != 0) {
                            bVar.setMsgType(TbConfig.forceImType);
                        }
                        bVar.setContent(TbConfig.forceImContent);
                        bVar.setObjContent(null);
                    }
                }
            }
            c(list, z2);
            if (this.bkw != 0) {
                int i2 = this.bkx * this.bkv;
                ArrayList arrayList = new ArrayList(this.bku);
                d(0, arrayList.subList(i2, arrayList.size()));
                MA();
            }
            if (list.size() > 0) {
                if (list.size() > 5 && z) {
                    O(list);
                } else {
                    N(a(list, z, z2));
                }
            }
        }
    }

    public void e(String str, String str2, String str3, String str4, String str5) {
        if (this.mMsgList != null) {
            this.mMsgList.clear();
        }
        if (this.bkG != null) {
            this.bkG.clear();
        }
        if (this.bkH != null) {
            this.bkH.clear();
        }
        this.mMsgList = new LinkedList<>();
        this.mGroupId = str;
        this.bks = str2;
        this.bkt = str3;
        this.mLiveId = str4;
        this.bkz = "0";
        this.mAppId = str5;
        MessageManager.getInstance().registerListener(this.bkS);
        MessageManager.getInstance().registerListener(this.bkT);
        MessageManager.getInstance().registerListener(this.bkL);
        MessageManager.getInstance().registerListener(this.bkO);
        MessageManager.getInstance().registerListener(this.bkM);
        MessageManager.getInstance().registerListener(this.bkP);
        MessageManager.getInstance().registerListener(this.bfu);
        MessageManager.getInstance().registerListener(this.bkQ);
        MessageManager.getInstance().registerListener(this.bkR);
        MessageManager.getInstance().registerListener(this.bkV);
        MessageManager.getInstance().registerListener(this.bkW);
        MessageManager.getInstance().registerListener(this.bkX);
        MessageManager.getInstance().registerListener(this.bkY);
        MessageManager.getInstance().registerListener(this.bkU);
        MessageManager.getInstance().registerListener(this.bfm);
        if (BdSocketLinkService.isClose()) {
            Mv();
            BdSocketLinkService.startService(true, "live start");
        }
        String str6 = com.baidu.live.ae.a.RB().brA.aLX;
        if (!TextUtils.isEmpty(str6)) {
            com.baidu.live.im.data.b MB = MB();
            MB.setMsgType(27);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("text", str6);
                jSONObject.put("content_type", "custom_live_notice");
                MB.setContent(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            a(-1, MB);
            if (this.bkr != null) {
                this.bkr.t(MB);
            }
        }
        String str7 = com.baidu.live.ae.a.RB().brA.aLY;
        if (!TextUtils.isEmpty(str7)) {
            com.baidu.live.im.data.b MB2 = MB();
            MB2.setMsgType(27);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("text", str7);
                jSONObject2.put("content_type", "custom_live_notice");
                MB2.setContent(jSONObject2.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            a(-1, MB2);
        }
        List<String> list = com.baidu.live.ae.a.RB().brA.aLW;
        if (list != null && list.size() > 0 && list.size() % 2 == 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                String str8 = list.get(i2);
                String str9 = list.get(i2 + 1);
                if (!TextUtils.isEmpty(str8) && !TextUtils.isEmpty(str9)) {
                    com.baidu.live.im.data.b MB3 = MB();
                    MB3.setMsgType(27);
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("text", str8);
                        jSONObject3.put("content_type", "custom_im_notice");
                        MB3.setContent(jSONObject3.toString());
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                    MB3.setLink(str9);
                    a(-1, MB3);
                    if (this.bkr != null) {
                        this.bkr.t(MB3);
                    }
                }
                i = i2 + 2;
            }
        }
        if (this.aFN != null && this.aFN.aKI != null && !StringUtils.isNull(this.aFN.aKI.Fa())) {
            com.baidu.live.im.data.b MB4 = MB();
            MB4.setMsgType(27);
            try {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("text", this.aFN.aKI.Fa());
                jSONObject4.put("content_type", "live_notice_quick_chat");
                jSONObject4.put("anchorName", this.aFN.aJV.userName);
                MB4.setContent(jSONObject4.toString());
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            this.mMsgList.add(MB4);
            if (this.bkr != null) {
                this.bkr.t(MB4);
            }
        }
        My();
        Mx();
        if (this.mMsgList.size() > 0 && this.bkr != null) {
            this.bkr.d(this.mMsgList, true);
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGmsgGetLiveStatusUnabled()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.d.7
                @Override // java.lang.Runnable
                public void run() {
                    d.this.hZ("enter");
                }
            }, 1000L);
        }
        Mu();
        if (TbadkCoreApplication.getInst().isOther()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913146, this.mMsgList));
        }
    }

    private void Mx() {
        String str = com.baidu.live.ae.a.RB().brA.aLZ;
        if (str != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    com.baidu.live.im.data.b MB = MB();
                    MB.setMsgType(27);
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    JSONObject jSONObject2 = new JSONObject();
                    if (jSONObject.optInt("open") != 0) {
                        jSONObject2.put("text", jSONObject.toString());
                        jSONObject2.put("content_type", "activity_notice");
                        MB.setContent(jSONObject2.toString());
                        this.mMsgList.add(MB);
                        if (this.bkr != null) {
                            this.bkr.t(MB);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void My() {
        if (Mz()) {
            com.baidu.live.im.data.b MB = MB();
            MB.setMsgType(27);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("text", com.baidu.live.ae.a.RB().brA.aOv.aKh);
                jSONObject.put("content_type", "custom_im_notice_live_assistant");
                MB.setContent(jSONObject.toString());
                MB.setLink(com.baidu.live.ae.a.RB().brA.aOv.aKg);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mMsgList.add(MB);
            if (this.bkr != null) {
                this.bkr.t(MB);
            }
        }
    }

    private boolean Mz() {
        return (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) || !TbadkCoreApplication.getCurrentAccount().equals(this.bkt) || com.baidu.live.ae.a.RB().brA == null || com.baidu.live.ae.a.RB().brA.aOv == null || TextUtils.isEmpty(com.baidu.live.ae.a.RB().brA.aOv.aKh)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(List<com.baidu.live.im.data.b> list) {
        if (list != null && this.bkr != null) {
            this.bkr.d(this.mMsgList, true);
            for (com.baidu.live.im.data.b bVar : list) {
                this.bkr.t(bVar);
            }
        }
    }

    protected void O(List<com.baidu.live.im.data.b> list) {
        this.bku = list;
        this.bkw = (int) ((this.bky * 2.0f) / 0.25f);
        this.bkx = 0;
        this.bkv = list.size() / this.bkw;
        if (this.bkv <= 0) {
            this.bkv = 1;
        }
        this.mHandler.removeCallbacks(this.bkJ);
        this.mHandler.postDelayed(this.bkJ, 250L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MA() {
        this.mHandler.removeCallbacks(this.bkJ);
        this.bkx = 0;
        this.bkw = 0;
        this.bkv = 0;
        this.bku = null;
    }

    protected List<com.baidu.live.im.data.b> b(List<com.baidu.live.im.data.b> list, boolean z) {
        return a(list, z, false);
    }

    protected List<com.baidu.live.im.data.b> a(List<com.baidu.live.im.data.b> list, boolean z, boolean z2) {
        for (com.baidu.live.im.data.b bVar : list) {
            if (bVar instanceof com.baidu.live.im.a) {
                ((com.baidu.live.im.a) bVar).hY(this.bkt);
            }
        }
        if (z) {
            LinkedList linkedList = new LinkedList();
            for (com.baidu.live.im.data.b bVar2 : list) {
                if (bVar2.getMsgId() > getLastMid()) {
                    if (bVar2.getMsgType() == 24) {
                        if (!z2) {
                            m(bVar2);
                        }
                        List<com.baidu.live.im.data.b> r = r(bVar2);
                        b(r, -1);
                        linkedList.addAll(r);
                    } else {
                        a(-1, bVar2);
                        linkedList.add(bVar2);
                    }
                }
            }
            list = linkedList;
        } else {
            delRepeatMsg(this.mMsgList, list);
            b(z2, list);
            if (!z2) {
                P(list);
            }
            if (z2 && this.mMsgList.size() > 2) {
                b(list, 2);
            } else {
                b(list, -1);
            }
        }
        if (this.mMsgList.size() > com.baidu.live.ae.a.RB().brA.aOj) {
            int i = (int) (com.baidu.live.ae.a.RB().brA.aOj * 0.7d);
            if (i <= 0) {
                i = 1;
            }
            while (this.mMsgList.size() > i) {
                this.mMsgList.removeFirst();
            }
        }
        return list;
    }

    private void P(List<com.baidu.live.im.data.b> list) {
        if (list != null && !list.isEmpty()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    com.baidu.live.im.data.b bVar = list.get(i2);
                    if (bVar.getMsgType() == 24) {
                        m(bVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double m(com.baidu.live.im.data.b bVar) {
        double d;
        JSONException e;
        JSONObject jSONObject;
        List<AlaLiveMarkData> list;
        boolean z = false;
        com.baidu.live.data.a NU = bVar.NU();
        if (NU != null && (list = NU.aID) != null && !list.isEmpty()) {
            for (AlaLiveMarkData alaLiveMarkData : list) {
                if (alaLiveMarkData.type == 102) {
                    z = true;
                    break;
                }
            }
        }
        try {
            if (bVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) bVar.getObjContent();
            } else {
                jSONObject = new JSONObject(bVar.getContent());
            }
            d = com.baidu.live.ae.f.RR().i(z, jSONObject.optString(LogConfig.LOG_GIFT_ID));
            if (d < 0.0d) {
                d = 0.0d;
            }
            try {
                jSONObject.put("gift_rate", d);
                bVar.setObjContent(jSONObject);
                bVar.setContent(jSONObject.toString());
            } catch (JSONException e2) {
                e = e2;
                e.printStackTrace();
                return d;
            }
        } catch (JSONException e3) {
            d = 0.0d;
            e = e3;
        }
        return d;
    }

    private void b(boolean z, List<com.baidu.live.im.data.b> list) {
        JSONObject jSONObject;
        if (z && list != null && !list.isEmpty()) {
            Iterator<com.baidu.live.im.data.b> it = list.iterator();
            while (it.hasNext()) {
                com.baidu.live.im.data.b next = it.next();
                if (next != null) {
                    try {
                        if (next.getObjContent() instanceof JSONObject) {
                            jSONObject = (JSONObject) next.getObjContent();
                        } else {
                            jSONObject = new JSONObject(next.getContent());
                        }
                        String optString = jSONObject.optString("content_type");
                        if (!TextUtils.isEmpty(optString) && (optString.equals("challenge_direct_start") || optString.equals("challenge_direct_matched") || optString.equals("challenge_random_start") || optString.equals("challenge_random_matched") || optString.equals("live_net_status") || optString.equals("send_redpacket") || optString.equals("start_grab_redpacket") || optString.equals("guard_seat") || optString.equals("multi_session") || optString.equals("guard_pk_win_tip") || optString.equals("fullscreen") || optString.equals("challenge_mvp") || optString.equals("challenge_mvp_punish") || optString.equals("challenge_winner_by_autofail") || optString.equals("official_notice") || optString.equals("activity_common_im") || optString.equals("activity_notice") || optString.equals("activity_gift") || optString.equals("pk_first_blood") || optString.equals("pk_send_props") || optString.equals("pk_mvp_props") || optString.equals("tying_gift") || optString.equals("luckybag_win_prize") || optString.equals("luckybag_send") || optString.equals("privilege_award_royal_success"))) {
                            it.remove();
                        }
                    } catch (JSONException e) {
                    }
                }
            }
        }
    }

    private void Q(List<com.baidu.live.im.data.b> list) {
        if (list != null && !list.isEmpty()) {
            for (com.baidu.live.im.data.b bVar : list) {
                bVar.cl(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.live.im.data.b bVar) {
        boolean z = false;
        if ((bVar instanceof com.baidu.live.im.a) && bVar.NU() != null && TextUtils.equals(bVar.NU().userId, TbadkCoreApplication.getCurrentAccount())) {
            z = true;
        }
        if (this.bkD < this.bkn) {
            if (i >= 0) {
                this.mMsgList.add(i, bVar);
            } else {
                this.mMsgList.addLast(bVar);
            }
        } else if (this.bkD >= this.bkn && this.bkD < this.bko) {
            if (q(bVar) && !z) {
                bVar.Og();
            }
            if (i >= 0) {
                this.mMsgList.add(i, bVar);
            } else if (!this.mMsgList.isEmpty() && q(this.mMsgList.getLast())) {
                if (!this.mMsgList.getLast().NU().userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.mMsgList.set(this.mMsgList.size() - 1, bVar);
                } else {
                    this.mMsgList.addLast(bVar);
                }
            } else {
                this.mMsgList.addLast(bVar);
            }
        } else if (this.bkD >= this.bko && this.bkD < this.bkp) {
            if (o(bVar) && !z) {
                bVar.Og();
            }
            if (i >= 0) {
                this.mMsgList.add(i, bVar);
            } else if (!this.mMsgList.isEmpty() && o(this.mMsgList.getLast())) {
                if (!this.mMsgList.getLast().NU().userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.mMsgList.set(this.mMsgList.size() - 1, bVar);
                } else {
                    this.mMsgList.addLast(bVar);
                }
            } else {
                this.mMsgList.addLast(bVar);
            }
        } else if (this.bkD >= this.bkp) {
            if ((o(bVar) && z) || !o(bVar)) {
                if (i >= 0) {
                    this.mMsgList.add(i, bVar);
                } else {
                    this.mMsgList.addLast(bVar);
                }
            }
        } else if (i >= 0) {
            this.mMsgList.add(i, bVar);
        } else {
            this.mMsgList.addLast(bVar);
        }
    }

    private void d(int i, List<com.baidu.live.im.data.b> list) {
        if (i >= 0) {
            for (com.baidu.live.im.data.b bVar : list) {
                a(i, bVar);
                i++;
            }
            return;
        }
        for (com.baidu.live.im.data.b bVar2 : list) {
            a(-1, bVar2);
        }
    }

    private int n(com.baidu.live.im.data.b bVar) {
        String str;
        JSONObject jSONObject;
        this.bkE = 0;
        if (bVar.getMsgType() == 13 || bVar.getMsgType() == 12) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                str = jSONObject.optString("content_type");
            } catch (JSONException e) {
                str = null;
            }
            if ("enter_live".equals(str)) {
                if (com.baidu.live.entereffect.a.Gi().h(bVar)) {
                    this.bkE = 2;
                } else {
                    this.bkE = 1;
                }
            } else {
                this.bkE = 0;
            }
        }
        return this.bkE;
    }

    private boolean o(com.baidu.live.im.data.b bVar) {
        return q(bVar) || p(bVar);
    }

    private boolean p(com.baidu.live.im.data.b bVar) {
        return n(bVar) == 2;
    }

    private boolean q(com.baidu.live.im.data.b bVar) {
        return n(bVar) == 1;
    }

    private void delRepeatMsg(List<com.baidu.live.im.data.b> list, List<com.baidu.live.im.data.b> list2) {
        if (list != null && list2 != null) {
            int size = list.size();
            int size2 = list2.size();
            if (size2 != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = size2 - 1; i >= 0 && i >= 0; i--) {
                    com.baidu.live.im.data.b bVar = list2.get(i);
                    if (bVar != null && bVar.NU() != null && !TextUtils.isEmpty(bVar.NU().userId) && bVar.NU().userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        int i2 = size - 1;
                        while (true) {
                            if (i2 >= 0 && i2 >= 0) {
                                com.baidu.live.im.data.b bVar2 = list.get(i2);
                                if (bVar2 != null && bVar2.NU() != null && !TextUtils.isEmpty(bVar2.NU().userId) && bVar2.NU().userId.equals(TbadkCoreApplication.getCurrentAccount()) && bVar.getRecordId() == bVar2.getRecordId()) {
                                    arrayList.add(bVar);
                                    break;
                                }
                                i2--;
                            }
                        }
                    }
                }
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    list2.remove(arrayList.get(i3));
                }
                arrayList.clear();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02b7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:465:0x031d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0184 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:486:0x02b3 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:495:0x0315 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:498:0x02ee A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:506:0x03ae A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:508:0x03a0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01a8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01c3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:650:0x034d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01d5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:747:0x0009 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x022f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(List<com.baidu.live.im.data.b> list, boolean z) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Exception e;
        JSONException e2;
        JSONObject jSONObject3;
        Exception exc;
        JSONObject jSONObject4;
        JSONException jSONException;
        JSONObject jSONObject5;
        String str;
        JSONObject jSONObject6;
        boolean z2;
        Exception e3;
        JSONException e4;
        JSONObject jSONObject7;
        JSONObject optJSONObject;
        LinkedList linkedList = new LinkedList();
        for (com.baidu.live.im.data.b bVar : list) {
            long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
            if (!ListUtils.isEmpty(bVar.NW()) && !bVar.NW().contains(Long.valueOf(currentAccountId))) {
                linkedList.add(bVar);
            } else {
                boolean z3 = false;
                boolean z4 = this.aFN.aLe;
                boolean z5 = bVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                if (z5 && bVar.getMsgType() == 24) {
                    try {
                        if (bVar.getObjContent() instanceof JSONObject) {
                            jSONObject7 = (JSONObject) bVar.getObjContent();
                        } else {
                            jSONObject7 = new JSONObject(bVar.getContent());
                        }
                        if (jSONObject7.optInt("show_own") != 1) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                    } catch (JSONException e5) {
                        z2 = false;
                        e4 = e5;
                    } catch (Exception e6) {
                        z2 = false;
                        e3 = e6;
                    }
                    try {
                        JSONArray optJSONArray = jSONObject7.optJSONArray("im_icon_conf");
                        if (optJSONArray != null && optJSONArray.length() != 0 && !z2) {
                            jSONObject7.put("content_type", "custom_gift");
                            bVar.setContent(jSONObject7.toString());
                            bVar.setMsgType(13);
                        }
                        jSONObject7.optString("content_type");
                        if (jSONObject7.optString("local_show").equals("1") && (optJSONObject = jSONObject7.optJSONObject("headline_info")) != null) {
                            jSONObject7.put("content_type", "activity_gift");
                            JSONObject jSONObject8 = new JSONObject();
                            jSONObject8.put("giftName", jSONObject7.optString("gift_name"));
                            jSONObject8.put("giftPic", jSONObject7.optString("gift_url"));
                            jSONObject8.put("giftNumber", Integer.valueOf(jSONObject7.optString("gift_count")));
                            jSONObject8.put("firstText", "送出的");
                            jSONObject8.put("secondText", optJSONObject.optString("second_text"));
                            jSONObject8.put("multipleTime", optJSONObject.optDouble("headline_buff_multiple"));
                            jSONObject8.put("multipleName", optJSONObject.optString("headline_buff_text"));
                            jSONObject8.put("span_color_start", optJSONObject.optString("headline_buff_text_color_start"));
                            jSONObject8.put("span_color_end", optJSONObject.optString("headline_buff_text_color_end"));
                            jSONObject8.put("span_text_color", optJSONObject.optString("headline_buff_text_font_color"));
                            jSONObject7.put("content_data", jSONObject8);
                            bVar.setContent(jSONObject7.toString());
                            bVar.setMsgType(13);
                        }
                        z3 = z2;
                    } catch (JSONException e7) {
                        e4 = e7;
                        e4.printStackTrace();
                        z3 = z2;
                        if (bVar.getMsgType() == 13) {
                        }
                        if (bVar.getMsgType() == 24) {
                        }
                        if (z5) {
                        }
                        if (this.bkF) {
                        }
                        if (bVar.getMsgType() == 125) {
                        }
                    } catch (Exception e8) {
                        e3 = e8;
                        e3.printStackTrace();
                        z3 = z2;
                        if (bVar.getMsgType() == 13) {
                        }
                        if (bVar.getMsgType() == 24) {
                        }
                        if (z5) {
                        }
                        if (this.bkF) {
                        }
                        if (bVar.getMsgType() == 125) {
                        }
                    }
                }
                if (bVar.getMsgType() == 13) {
                    try {
                        if (bVar.getObjContent() instanceof JSONObject) {
                            jSONObject6 = (JSONObject) bVar.getObjContent();
                        } else {
                            jSONObject6 = new JSONObject(bVar.getContent());
                        }
                    } catch (JSONException e9) {
                        jSONObject4 = null;
                        jSONException = e9;
                    } catch (Exception e10) {
                        jSONObject3 = null;
                        exc = e10;
                    }
                    try {
                        str = jSONObject6.optString("content_type");
                        jSONObject5 = jSONObject6;
                    } catch (JSONException e11) {
                        jSONObject4 = jSONObject6;
                        jSONException = e11;
                        jSONException.printStackTrace();
                        jSONObject5 = jSONObject4;
                        str = null;
                        if ("pk_send_props".equals(str)) {
                            if (z5) {
                            }
                        }
                        if ("tying_gift".equals(str)) {
                            z3 = true;
                            bVar.setMsgType(24);
                        }
                        if ("luckybag_send".equals(str)) {
                            if (!z4) {
                            }
                            linkedList.add(bVar);
                        }
                        if ("luckybag_win_prize".equals(str)) {
                            linkedList.add(bVar);
                        }
                        if (z5) {
                            this.aKB = bVar.NU().aID;
                        }
                        if (z5) {
                            linkedList.add(bVar);
                        }
                        if (bVar.getMsgType() == 24) {
                        }
                        if (z5) {
                        }
                        if (this.bkF) {
                        }
                        if (bVar.getMsgType() == 125) {
                        }
                    } catch (Exception e12) {
                        jSONObject3 = jSONObject6;
                        exc = e12;
                        exc.printStackTrace();
                        jSONObject5 = jSONObject3;
                        str = null;
                        if ("pk_send_props".equals(str)) {
                        }
                        if ("tying_gift".equals(str)) {
                        }
                        if ("luckybag_send".equals(str)) {
                        }
                        if ("luckybag_win_prize".equals(str)) {
                        }
                        if (z5) {
                        }
                        if (z5) {
                        }
                        if (bVar.getMsgType() == 24) {
                        }
                        if (z5) {
                        }
                        if (this.bkF) {
                        }
                        if (bVar.getMsgType() == 125) {
                        }
                    }
                    if ("pk_send_props".equals(str) && jSONObject5 != null && str != null && jSONObject5.optString("is_mine").equals("1")) {
                        if (z5) {
                            bVar.setMsgType(24);
                        } else {
                            bVar.setMsgType(13);
                        }
                    }
                    if ("tying_gift".equals(str) && jSONObject5 != null && jSONObject5.optInt("tying_status") == 1) {
                        z3 = true;
                        bVar.setMsgType(24);
                    }
                    if ("luckybag_send".equals(str) && jSONObject5 != null) {
                        if (!z4 || z5) {
                            linkedList.add(bVar);
                        } else {
                            bVar.setMsgType(24);
                        }
                    }
                    if ("luckybag_win_prize".equals(str) && jSONObject5 != null && z4) {
                        linkedList.add(bVar);
                    }
                    if (z5 && bVar.getMsgType() == 1 && !ListUtils.isEmpty(bVar.NU().aID) && this.aKB == null) {
                        this.aKB = bVar.NU().aID;
                    }
                    if (z5 && bVar.getMsgType() == 13 && jSONObject5 != null && jSONObject5.optInt("show_own", 1) == 0 && !str.equals("custom_gift")) {
                        linkedList.add(bVar);
                    }
                }
                if (bVar.getMsgType() == 24) {
                    bVar.aLe = this.aFN.aLe;
                }
                if (z5 && bVar.getMsgType() != 125 && bVar.getMsgType() != 24 && bVar.getMsgType() != 13 && bVar.getMsgType() != 28) {
                    if (bVar.getMsgType() != 1 || !z) {
                        linkedList.add(bVar);
                    }
                } else if (this.bkF && z5 && bVar.getMsgType() == 24) {
                    try {
                        if (bVar.getObjContent() instanceof JSONObject) {
                            jSONObject2 = (JSONObject) bVar.getObjContent();
                        } else {
                            jSONObject2 = new JSONObject(bVar.getContent());
                        }
                    } catch (JSONException e13) {
                        jSONObject2 = null;
                        e2 = e13;
                    } catch (Exception e14) {
                        jSONObject2 = null;
                        e = e14;
                    }
                    try {
                        jSONObject2.optString("content_type");
                    } catch (JSONException e15) {
                        e2 = e15;
                        e2.printStackTrace();
                        if (jSONObject2.optInt("from_gongyanfang_page") == 1) {
                        }
                        if (jSONObject2.optInt("from_gongyanfang_2") == 1) {
                        }
                        if (z3) {
                            linkedList.add(bVar);
                        }
                    } catch (Exception e16) {
                        e = e16;
                        e.printStackTrace();
                        if (jSONObject2.optInt("from_gongyanfang_page") == 1) {
                        }
                        if (jSONObject2.optInt("from_gongyanfang_2") == 1) {
                        }
                        if (z3) {
                        }
                    }
                    boolean z6 = jSONObject2.optInt("from_gongyanfang_page") == 1;
                    boolean z7 = jSONObject2.optInt("from_gongyanfang_2") == 1;
                    if (z3 && !z6 && !z7) {
                        linkedList.add(bVar);
                    }
                } else if (bVar.getMsgType() == 125) {
                    try {
                        if (!"1".equals(new JSONObject(bVar.getContent()).optString("is_first"))) {
                            linkedList.add(bVar);
                            if (this.bkr != null) {
                                this.bkr.t(bVar);
                            }
                        }
                    } catch (JSONException e17) {
                        BdLog.e(e17);
                        linkedList.add(bVar);
                    }
                } else if (bVar.getMsgType() == 13) {
                    String str2 = null;
                    try {
                        if (bVar.getObjContent() instanceof JSONObject) {
                            jSONObject = (JSONObject) bVar.getObjContent();
                        } else {
                            jSONObject = new JSONObject(bVar.getContent());
                        }
                        try {
                            str2 = jSONObject.optString("content_type");
                        } catch (JSONException e18) {
                            linkedList.add(bVar);
                            if (!"enter_live".equals(str2)) {
                            }
                            if (!"close_live".equals(str2)) {
                            }
                        }
                    } catch (JSONException e19) {
                        jSONObject = null;
                    }
                    if (!"enter_live".equals(str2) && this.bkD < this.bkp) {
                        if (com.baidu.live.entereffect.a.Gi().h(bVar)) {
                        }
                    } else if (!"close_live".equals(str2)) {
                        linkedList.add(bVar);
                        if (this.bkr != null) {
                            this.bkr.t(bVar);
                        }
                    } else if ("task".equals(str2)) {
                        linkedList.add(bVar);
                        if (this.bkr != null) {
                            this.bkr.t(bVar);
                        }
                    } else if ("live_achievement".equals(str2)) {
                        linkedList.add(bVar);
                        if (this.bkr != null) {
                            this.bkr.t(bVar);
                        }
                    } else if ("ss_hot_live".equals(str2)) {
                        linkedList.add(bVar);
                        if (this.bkr != null) {
                            this.bkr.t(bVar);
                        }
                    } else if ("challenge_direct_new".equals(str2)) {
                        linkedList.add(bVar);
                        if (this.bkr != null) {
                            this.bkr.t(bVar);
                        }
                    } else if ("challenge_random_cancel".equals(str2)) {
                        linkedList.add(bVar);
                        if (this.bkr != null) {
                            this.bkr.t(bVar);
                        }
                    } else if ("update_liveinfo".equals(str2)) {
                        linkedList.add(bVar);
                        if (this.bkr != null) {
                            this.bkr.t(bVar);
                        }
                    } else if ("backstage_live".equals(str2)) {
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                    } else if ("offline_type".equals(str2)) {
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                    } else if ("follow_anchor".equals(str2)) {
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                    } else if (com.baidu.tbadk.TbConfig.TMP_SHARE_DIR_NAME.equals(str2)) {
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                    } else if ("share_tieba".equals(str2)) {
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                    } else if ("ueg_warn".equals(str2)) {
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                    } else if ("live_admin".equals(str2)) {
                        if (z5 && !ListUtils.isEmpty(bVar.NU().aID)) {
                            this.aKB = bVar.NU().aID;
                            if (this.aFN != null) {
                                this.aFN.aKB = this.aKB;
                            }
                        }
                    } else if (!"live_talk_ban".equals(str2) && !"live_talk_remove_ban".equals(str2) && !"live_talk_admin_ban".equals(str2) && !"live_talk_admin_remove_ban".equals(str2) && !"live_on_private".equals(str2)) {
                        if ("challenge_direct_matched".equals(str2)) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if ("challenge_direct_start".equals(str2)) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if ("challenge_random_matched".equals(str2)) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if ("challenge_random_start".equals(str2)) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str2, "share_rmb")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str2, "zan_rmb")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str2, "start_grab_wheel")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str2, "guard_club_join")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str2, "haokan_buy_goods")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str2, "send_redpacket")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str2, "start_grab_redpacket")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str2, "activity_notice")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str2, "activity_common_im")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str2, "activity_gift")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str2, "pk_first_blood")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str2, "pk_send_props")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str2, "pk_mvp_props")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str2, "tying_gift")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str2, "luckybag_win_prize")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str2, "luckybag_send")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str2, "custom_gift")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str2, "guard_seat")) {
                            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                                linkedList.add(bVar);
                            }
                        } else if (TextUtils.equals(str2, "multi_session")) {
                            linkedList.add(bVar);
                            if (this.bkr != null) {
                                this.bkr.t(bVar);
                            }
                        } else if (TextUtils.equals(str2, "guard_pk_win_tip")) {
                            linkedList.add(bVar);
                            if (this.bkr != null) {
                                this.bkr.t(bVar);
                            }
                        } else if (TextUtils.equals(str2, "fullscreen")) {
                            linkedList.add(bVar);
                            if (this.bkr != null) {
                                this.bkr.t(bVar);
                            }
                        } else if (TextUtils.equals(str2, "challenge_mvp")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, "CONTENT_TYPE_CHALLENGE_MVP");
                        } else if (TextUtils.equals(str2, "challenge_mvp_punish")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, "CONTENT_TYPE_CHALLENGE_MVP_PUNISH");
                        } else if (!TextUtils.equals(str2, "challenge_winner_by_autofail")) {
                            if (TextUtils.equals(str2, "wish_list_finish") || TextUtils.equals(str2, "wish_list_success")) {
                                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                                    linkedList.add(bVar);
                                }
                            } else if ("introduce_goods".equals(str2)) {
                                linkedList.add(bVar);
                                if (this.bkr != null) {
                                    this.bkr.t(bVar);
                                }
                            } else if ("first_recharge_success".equals(str2)) {
                                linkedList.add(bVar);
                                if (this.bkr != null) {
                                    this.bkr.t(bVar);
                                }
                            } else if ("privilege_award_success".equals(str2)) {
                                linkedList.add(bVar);
                                if (this.bkr != null) {
                                    this.bkr.t(bVar);
                                }
                            } else if ("need_update_live_mark_info".equals(str2)) {
                                linkedList.add(bVar);
                                if (this.bkr != null) {
                                    this.bkr.t(bVar);
                                }
                            } else if ("pk_honor_change".equals(str2) || "pk_invite".equals(str2) || "pk_start".equals(str2) || "pk_start_settle".equals(str2) || "pk_end_settle".equals(str2)) {
                                linkedList.add(bVar);
                                if (this.bkr != null) {
                                    this.bkr.t(bVar);
                                }
                            } else if ("official_notice".equals(str2)) {
                                linkedList.add(bVar);
                                if (this.bkr != null && !z) {
                                    this.bkr.t(bVar);
                                }
                            } else if (TextUtils.equals(str2, "privilege_award_royal_success")) {
                                Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                            } else if (TextUtils.equals(str2, "remove_video")) {
                                boolean z8 = jSONObject.optInt("is_show_other", 1) == 1;
                                String optString = jSONObject.optString("poke_user_id", "");
                                String optString2 = jSONObject.optString("charm_user_id", "");
                                if (TbadkCoreApplication.getCurrentAccount() == null) {
                                    linkedList.add(bVar);
                                }
                                if (TbadkCoreApplication.getCurrentAccount() != null && !TbadkCoreApplication.getCurrentAccount().equals(optString) && !TbadkCoreApplication.getCurrentAccount().equals(optString2) && !z8) {
                                    linkedList.add(bVar);
                                }
                                Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, "remove_video");
                            } else if (TextUtils.equals(str2, "live_poke_back")) {
                                boolean z9 = jSONObject.optInt("is_show_other", 1) == 1;
                                String optString3 = jSONObject.optString("poke_user_id", "");
                                String optString4 = jSONObject.optString("charm_user_id", "");
                                if (TbadkCoreApplication.getCurrentAccount() == null) {
                                    linkedList.add(bVar);
                                }
                                if (TbadkCoreApplication.getCurrentAccount() != null && !TbadkCoreApplication.getCurrentAccount().equals(optString3) && !TbadkCoreApplication.getCurrentAccount().equals(optString4) && !z9) {
                                    linkedList.add(bVar);
                                }
                                Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, "live_poke_back");
                            } else if (!TextUtils.equals(str2, "add_tags_to_anchor")) {
                                if (TextUtils.equals(str2, "headline_data_im")) {
                                    linkedList.add(bVar);
                                    if (this.bkr != null) {
                                        this.bkr.t(bVar);
                                    }
                                } else if (TextUtils.equals(str2, "connect_apply_show_pub")) {
                                    linkedList.add(bVar);
                                    if (this.bkr != null) {
                                        this.bkr.t(bVar);
                                    }
                                } else {
                                    linkedList.add(bVar);
                                }
                            }
                        }
                    }
                } else if (bVar.getMsgType() == 12) {
                    linkedList.add(bVar);
                    if (this.bkr != null) {
                        this.bkr.t(bVar);
                    }
                    hZ("push");
                }
            }
        }
        if (linkedList.size() > 0) {
            list.removeAll(linkedList);
        }
    }

    protected com.baidu.live.im.data.b a(short s, String str, boolean z, boolean z2, int i, List<AlaLiveMarkData> list) {
        long j = 0;
        com.baidu.live.im.data.b MB = MB();
        if (MB == null) {
            return null;
        }
        MB.setMsgType(s);
        MB.setContent(str);
        long aT = o.aT(getLastMid());
        MB.setMsgId(aT);
        MB.setRecordId(aT);
        MB.setTime(System.currentTimeMillis() / 1000);
        com.baidu.live.data.a aVar = new com.baidu.live.data.a();
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            aVar.userName = TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow();
        }
        aVar.userId = TbadkCoreApplication.getCurrentAccount();
        if (this.aFN != null && this.aFN.aKr != null && !TextUtils.isEmpty(this.aFN.aKr.portrait)) {
            aVar.portrait = this.aFN.aKr.portrait;
        } else {
            aVar.portrait = TbadkCoreApplication.getCurrentPortrait();
        }
        aVar.level_id = i;
        aVar.aIA = z;
        aVar.aIB = z2;
        if (list != null) {
            aVar.aID = new ArrayList(list);
        }
        MB.e(aVar);
        try {
            j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        } catch (Exception e) {
        }
        MB.setUserId(j);
        return MB;
    }

    private long getLastMid() {
        if (this.mMsgList == null || this.mMsgList.size() <= 0) {
            return JavaTypesHelper.toLong(this.bks, 1L);
        }
        return this.mMsgList.get(this.mMsgList.size() - 1).getMsgId();
    }

    protected com.baidu.live.im.data.b MB() {
        com.baidu.live.im.a aVar = new com.baidu.live.im.a();
        aVar.setBornTime(System.currentTimeMillis());
        if (TextUtils.isEmpty(this.mGroupId)) {
            return null;
        }
        aVar.hY(this.bkt);
        return aVar;
    }

    public void R(List<AlaLiveMarkData> list) {
        this.aKB = list;
    }

    public void hZ(String str) {
        com.baidu.live.message.d dVar = new com.baidu.live.message.d(JavaTypesHelper.toLong(this.mLiveId, 0L), str);
        dVar.setParams();
        sendMessage(dVar);
    }

    public void ia(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.bkz)) {
            hZ("getliveinfo");
        }
    }

    private List<com.baidu.live.im.data.b> r(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        int optInt;
        boolean Hf;
        ArrayList arrayList = new ArrayList();
        if (!(bVar instanceof com.baidu.live.im.a)) {
            arrayList.add(bVar);
            return arrayList;
        }
        com.baidu.live.im.a aVar = (com.baidu.live.im.a) bVar;
        try {
            bVar.getObjContent();
            jSONObject = new JSONObject(aVar.getContent());
            optInt = jSONObject.optInt("is_combo");
            com.baidu.live.gift.g hr = ac.hr(jSONObject.optString(LogConfig.LOG_GIFT_ID));
            Hf = hr != null ? hr.Hf() : false;
        } catch (JSONException e) {
            arrayList.add(aVar);
        }
        if (optInt == 1 || Hf) {
            arrayList.add(aVar);
            return arrayList;
        }
        long optLong = jSONObject.optLong("gift_count");
        if (optLong <= 1) {
            arrayList.add(aVar);
            return arrayList;
        }
        jSONObject.put("gift_count", 1);
        String jSONObject2 = jSONObject.toString();
        for (int i = 0; i < optLong; i++) {
            com.baidu.live.im.a aVar2 = new com.baidu.live.im.a();
            aVar2.hY(aVar.Mr());
            aVar2.setBornTime(aVar.getBornTime());
            aVar2.setTime(aVar.getTime());
            aVar2.setUserId(aVar.getUserId());
            aVar2.setToUserId(aVar.getToUserId());
            aVar2.f(aVar.NV());
            aVar2.setContent(jSONObject2);
            aVar2.setObjContent(jSONObject);
            aVar2.setGifLoadSuccess(aVar.isGifLoadSuccess());
            aVar2.setHasRead(aVar.isHasRead());
            aVar2.setIsPushForOperateAccount(aVar.isPushForOperateAccount());
            aVar2.setLink(aVar.getLink());
            aVar2.setIsUploading(aVar.getIsUploading());
            aVar2.setMsgId(aVar.getMsgId());
            aVar2.setMsgType(aVar.getMsgType());
            aVar2.setProgressValue(aVar.getProgressValue());
            aVar2.setTaskId(aVar.getTaskId());
            aVar2.setRecordId(aVar.getRecordId());
            aVar2.setStat(aVar.getStat());
            aVar2.setLogTime(aVar.getLogTime());
            aVar2.e(aVar.NU());
            aVar2.setSt_type(aVar.getSt_type());
            arrayList.add(aVar2);
        }
        return arrayList;
    }

    public void a(int i, String str, com.baidu.live.data.a aVar) {
        com.baidu.live.im.data.b MB = MB();
        if (MB != null) {
            MB.setMsgType(i);
            MB.setContent(str);
            MB.e(aVar);
            a(-1, MB);
            if (this.bkr != null) {
                this.bkr.d(this.mMsgList, true);
                this.bkr.t(MB);
            }
        }
    }

    private void b(List<com.baidu.live.im.data.b> list, int i) {
        JSONObject jSONObject;
        int i2;
        if (this.bkF) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    com.baidu.live.im.data.b bVar = list.get(i4);
                    if (bVar.getMsgType() != 24) {
                        if (i >= 0) {
                            a(i + i4, bVar);
                        } else {
                            a(-1, bVar);
                        }
                    } else {
                        try {
                            if (bVar.getObjContent() instanceof JSONObject) {
                                jSONObject = (JSONObject) bVar.getObjContent();
                            } else {
                                jSONObject = new JSONObject(bVar.getContent());
                            }
                        } catch (JSONException e) {
                            jSONObject = null;
                        }
                        if (jSONObject == null) {
                            if (i >= 0) {
                                a(i + i4, bVar);
                            } else {
                                a(-1, bVar);
                            }
                        } else {
                            String optString = jSONObject.optString(LogConfig.LOG_GIFT_ID);
                            com.baidu.live.data.a NU = bVar.NU();
                            if (NU == null || StringUtils.isNull(NU.userId) || StringUtils.isNull(optString)) {
                                if (i >= 0) {
                                    a(i + i4, bVar);
                                } else {
                                    a(-1, bVar);
                                }
                            } else {
                                String str = NU.userId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + optString + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + NU.getNameShow();
                                if (this.bkG == null) {
                                    this.bkG = new LinkedHashMap<>();
                                }
                                long j = JavaTypesHelper.toLong(jSONObject.optString("gift_count"), 0L);
                                double optDouble = jSONObject.optDouble("gift_rate", 0.0d);
                                long j2 = JavaTypesHelper.toLong(jSONObject.optString("charm_value"), 0L);
                                h hVar = new h();
                                hVar.bmt = bVar;
                                hVar.count = j;
                                hVar.bmw = optDouble;
                                hVar.bmv = j2;
                                if (com.baidu.live.ae.a.RB().brA == null) {
                                    i2 = 100;
                                } else {
                                    i2 = com.baidu.live.ae.a.RB().brA.aOp * 2;
                                }
                                Iterator<String> it = this.bkG.keySet().iterator();
                                int i5 = 0;
                                while (it.hasNext()) {
                                    String next = it.next();
                                    if (this.bkG.get(next) == null || this.bkG.get(next).isEmpty()) {
                                        it.remove();
                                    } else {
                                        HashMap<Long, h> hashMap = this.bkG.get(next);
                                        Iterator<Long> it2 = hashMap.keySet().iterator();
                                        while (it2.hasNext()) {
                                            long longValue = it2.next().longValue();
                                            if (hashMap.get(Long.valueOf(longValue)) == null || hashMap.get(Long.valueOf(longValue)).bmz) {
                                                it2.remove();
                                            }
                                        }
                                        if (this.bkG.get(next) == null || this.bkG.get(next).isEmpty()) {
                                            it.remove();
                                        } else {
                                            i5 = hashMap.size() + i5;
                                        }
                                    }
                                }
                                if (i5 > i2) {
                                    int i6 = i5 - ((int) (i2 * 0.7d));
                                    Iterator<String> it3 = this.bkG.keySet().iterator();
                                    while (true) {
                                        int i7 = i6;
                                        if (!it3.hasNext()) {
                                            break;
                                        }
                                        i6 = i7 - this.bkG.get(it3.next()).size();
                                        it3.remove();
                                        if (i6 <= 0) {
                                            break;
                                        }
                                    }
                                }
                                if (!this.bkG.containsKey(str)) {
                                    HashMap<Long, h> hashMap2 = new HashMap<>();
                                    hashMap2.put(Long.valueOf(bVar.getMsgId()), hVar);
                                    this.bkG.put(str, hashMap2);
                                } else {
                                    this.bkG.get(str).put(Long.valueOf(bVar.getMsgId()), hVar);
                                }
                            }
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        } else if (i >= 0) {
            d(i, list);
        } else {
            d(-1, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, long j, long j2, boolean z, Map<Long, Long> map) {
        if (map != null && !map.isEmpty()) {
            String str2 = "";
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                str2 = TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow();
            }
            String str3 = TbadkCoreApplication.getCurrentAccount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2;
            HashMap<Long, h> hashMap = this.bkH.get(str3);
            if (hashMap != null && !hashMap.isEmpty()) {
                for (Long l : map.keySet()) {
                    h hVar = hashMap.get(l);
                    if (hVar == null) {
                        Iterator<h> it = hashMap.values().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            h next = it.next();
                            if (next.bmA.contains(l)) {
                                hVar = next;
                                break;
                            }
                        }
                    }
                    if (hVar != null) {
                        long longValue = map.get(l).longValue();
                        if (z) {
                            hVar.bmu += longValue;
                        }
                        hVar.bmy -= longValue;
                        if (hVar.bmz && hVar.bmy == 0) {
                            hashMap.remove(Long.valueOf(hVar.aWT));
                            hVar.bmt.aU(hVar.count);
                            hVar.bmt.n(hVar.bmw);
                            hVar.bmt.aV(hVar.bmv);
                            a(-1, hVar.bmt);
                            if (this.bkr != null) {
                                this.bkr.d(this.mMsgList, true);
                            }
                            long j3 = hVar.bmu;
                            if (j3 > 0) {
                                h(j3, hVar.giftName);
                            }
                        }
                    }
                }
                if (hashMap.isEmpty()) {
                    this.bkH.remove(str3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(h hVar) {
        JSONObject jSONObject;
        com.baidu.live.im.data.b bVar = hVar.bmt;
        if (bVar != null) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pk_honer_buff_multiple", Double.parseDouble(hVar.bmB == null ? this.bkA : hVar.bmB));
                jSONObject2.put("pk_honer_buff_text", hVar.text);
                jSONObject2.put("pk_honer_buff_text_color_start", hVar.startColor);
                jSONObject2.put("pk_honer_buff_text_color_end", hVar.endColor);
                jSONObject2.put("pk_honer_buff_text_font_color", hVar.fontColor);
                jSONObject.put("pk_info", jSONObject2);
                bVar.setObjContent(jSONObject);
                bVar.setContent(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        if (bVar == null || bVar.getObjContent() == null) {
            return false;
        }
        if (bVar.getObjContent() instanceof JSONObject) {
            jSONObject = (JSONObject) bVar.getObjContent();
        } else {
            try {
                jSONObject = new JSONObject(bVar.getContent());
            } catch (JSONException e) {
                e.printStackTrace();
                jSONObject = null;
            }
        }
        if (jSONObject == null) {
            return false;
        }
        return jSONObject.optInt("from_gongyanfang_2") == 1;
    }

    public void cf(boolean z) {
        this.mGroupId = null;
        this.bks = null;
        this.mLiveId = null;
        this.bkz = "0";
        this.mAppId = null;
        this.bkB = false;
        this.bkC = false;
        MessageManager.getInstance().unRegisterListener(this.bkT);
        MessageManager.getInstance().unRegisterListener(this.bkS);
        MessageManager.getInstance().unRegisterListener(this.bkL);
        MessageManager.getInstance().unRegisterListener(this.bkO);
        MessageManager.getInstance().unRegisterListener(this.bkP);
        MessageManager.getInstance().unRegisterListener(this.bfu);
        MessageManager.getInstance().unRegisterListener(this.bkQ);
        MessageManager.getInstance().unRegisterListener(this.bkR);
        MessageManager.getInstance().unRegisterListener(this.bkM);
        MessageManager.getInstance().unRegisterListener(this.bkV);
        MessageManager.getInstance().unRegisterListener(this.bkW);
        MessageManager.getInstance().unRegisterListener(this.bkX);
        MessageManager.getInstance().unRegisterListener(this.bkY);
        MessageManager.getInstance().unRegisterListener(this.bkU);
        MessageManager.getInstance().unRegisterListener(this.bfm);
        if (z) {
            MessageManager.getInstance().unRegisterListener(this.syncListener);
        }
        this.mHandler.removeCallbacks(this.bkK);
        this.mHandler.removeCallbacks(this.bkJ);
        this.mHandler.removeCallbacks(this.bkN);
        if (this.mMsgList != null) {
            this.mMsgList.clear();
        }
        this.mMsgList = null;
        if (this.bkG != null) {
            this.bkG.clear();
        }
        if (this.bkH != null) {
            this.bkH.clear();
        }
    }

    private void MC() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021194, TbConfig.SERVER_ADDRESS + "ala/live/checkImBan");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaForbiddenWordsStateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(ImSendMsgData imSendMsgData, boolean z, boolean z2, int i, String str, String[] strArr) {
        if (!TbadkCoreApplication.isLogin()) {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.h.sdk_not_login);
        } else if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow())) {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.h.sdk_username_empty);
        } else {
            String str2 = imSendMsgData.text;
            short s = imSendMsgData.msgType;
            com.baidu.live.im.data.b a2 = a(s, str2, z, z2, i, this.aKB);
            if (s == 126) {
                a2.fe(imSendMsgData.barrageType);
                a2.ii(imSendMsgData.barrageId);
                a2.a(imSendMsgData.barrageCardInfo);
            }
            if (a2 != null) {
                a2.l(strArr);
                a(-1, a2);
                if (this.bkr != null) {
                    this.bkr.t(a2);
                    this.bkr.d(this.mMsgList, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913043));
                com.baidu.live.im.message.a aVar = new com.baidu.live.im.message.a(str2, s, JavaTypesHelper.toInt(this.mGroupId, 0), this.mAppId);
                if (this.aFN != null && this.aFN.mLiveInfo != null) {
                    aVar.setLiveId(this.aFN.mLiveInfo.live_id + "");
                    aVar.setRoomId(this.aFN.mLiveInfo.room_id + "");
                } else {
                    aVar.setLiveId("");
                    aVar.setRoomId("");
                }
                aVar.setOtherParams(str);
                aVar.aW(imSendMsgData.price);
                aVar.fe(imSendMsgData.barrageType);
                aVar.ii(imSendMsgData.barrageId);
                aVar.a(imSendMsgData.barrageCardInfo);
                aVar.l(strArr);
                aVar.cm(imSendMsgData.isQuick);
                sendMessage(aVar);
            }
        }
    }

    public void g(long j, long j2) {
        if (!this.bkB) {
            this.bkB = true;
            com.baidu.live.im.message.c cVar = new com.baidu.live.im.message.c(1021194);
            cVar.addParam("user_id", j);
            cVar.addParam("live_id", j2);
            cVar.aX(System.currentTimeMillis());
            sendMessage(cVar);
            this.mHandler.postDelayed(this.bkK, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MD() {
        this.bkB = false;
        this.bkC = true;
        ImForbiddenStateData imForbiddenStateData = new ImForbiddenStateData();
        imForbiddenStateData.errno = -1;
        imForbiddenStateData.errMsg = this.mPageContext.getString(a.h.sdk_neterror);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, imForbiddenStateData));
    }
}
