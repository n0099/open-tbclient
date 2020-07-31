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
import com.baidu.live.data.q;
import com.baidu.live.gift.GiftPackageConsumeHttpResponsedMessage;
import com.baidu.live.gift.v;
import com.baidu.live.im.b;
import com.baidu.live.im.data.ImForbiddenStateData;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.message.ALAGroupCommitHttpResponsedMessage;
import com.baidu.live.im.message.ALAGroupHttpResponseMessage;
import com.baidu.live.im.message.AlaForbiddenWordsStateResponseMessage;
import com.baidu.live.message.AlaGetLiveStatusHttpResponseMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends BdBaseModel {
    public int aTC;
    public int aTD;
    public int aTE;
    private boolean aTF;
    private a aTG;
    private String aTH;
    private String aTI;
    private List<com.baidu.live.im.data.a> aTJ;
    private int aTK;
    private int aTL;
    private int aTM;
    private float aTN;
    private String aTO;
    private boolean aTP;
    private boolean aTQ;
    private int aTR;
    private int aTS;
    private boolean aTT;
    private LinkedHashMap<String, HashMap<Long, h>> aTU;
    private HashMap<String, HashMap<Long, h>> aTV;
    private b.a aTW;
    private Runnable aTX;
    private Runnable aTY;
    private CustomMessageListener aTZ;
    private CustomMessageListener aUa;
    private Runnable aUb;
    private HttpMessageListener aUc;
    private HttpMessageListener aUd;
    private HttpMessageListener aUe;
    private HttpMessageListener aUf;
    private HttpMessageListener aUg;
    private NetMessageListener aUh;
    CustomMessageListener aUi;
    CustomMessageListener aUj;
    CustomMessageListener aUk;
    CustomMessageListener aUl;
    CustomMessageListener aUm;
    private HttpMessageListener aUn;
    private q avf;
    private List<AlaLiveMarkData> aza;
    private long count;
    private String mAppId;
    private String mGroupId;
    private Handler mHandler;
    private String mLiveId;
    private LinkedList<com.baidu.live.im.data.a> mMsgList;
    BdPageContext<?> mPageContext;

    /* loaded from: classes4.dex */
    public interface a {
        void Dd();

        void d(List<com.baidu.live.im.data.a> list, boolean z);

        void r(com.baidu.live.im.data.a aVar);
    }

    static /* synthetic */ int h(d dVar) {
        int i = dVar.aTM;
        dVar.aTM = i + 1;
        return i;
    }

    public d(BdPageContext<?> bdPageContext, boolean z, a aVar) {
        super(bdPageContext);
        this.mLiveId = null;
        this.aTN = 1.0f;
        this.mHandler = new Handler();
        this.aTO = null;
        this.aTP = false;
        this.aTQ = false;
        this.aTS = 0;
        this.aTT = false;
        this.aTW = new b.a() { // from class: com.baidu.live.im.d.1
        };
        this.aTX = new Runnable() { // from class: com.baidu.live.im.d.12
            @Override // java.lang.Runnable
            public void run() {
                int i = d.this.aTM * d.this.aTK;
                if (i >= d.this.aTJ.size()) {
                    d.this.CZ();
                } else if (d.this.aTM >= d.this.aTL - 1) {
                    if (d.this.aTM != d.this.aTL - 1) {
                        d.this.CZ();
                        return;
                    }
                    ArrayList arrayList = new ArrayList(d.this.aTJ);
                    d.this.G(d.this.b(arrayList.subList(i, arrayList.size()), true));
                    d.h(d.this);
                    d.this.CZ();
                } else {
                    ArrayList arrayList2 = new ArrayList(d.this.aTJ);
                    if (d.this.aTK + i <= arrayList2.size()) {
                        d.this.G(d.this.b(arrayList2.subList(i, d.this.aTK + i), true));
                        d.h(d.this);
                        d.this.mHandler.postDelayed(d.this.aTX, 250L);
                        return;
                    }
                    d.this.G(d.this.b(arrayList2.subList(i, arrayList2.size()), true));
                    d.h(d.this);
                    d.this.CZ();
                }
            }
        };
        this.aTY = new Runnable() { // from class: com.baidu.live.im.d.13
            @Override // java.lang.Runnable
            public void run() {
                d.this.Dc();
            }
        };
        this.aTZ = new CustomMessageListener(MessageConfig.SOCKET_RECEIVE_MSG) { // from class: com.baidu.live.im.d.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.CW();
            }
        };
        this.aUa = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.live.im.d.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        com.baidu.live.im.a aVar2 = new com.baidu.live.im.a();
                        aVar2.setMsgType(27);
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("text", d.this.mPageContext.getString(a.i.sdk_im_offline));
                            jSONObject.put("content_type", "custom_network_change");
                            aVar2.setContent(jSONObject.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        d.this.a(-1, aVar2);
                        if (d.this.aTG != null) {
                            d.this.aTG.r(aVar2);
                            d.this.aTG.d(d.this.mMsgList, true);
                        }
                    } else if (((NetWorkChangedMessage) customResponsedMessage).mLastNetState == 0 && BdNetTypeUtil.isNetWorkAvailable()) {
                        com.baidu.live.im.a aVar3 = new com.baidu.live.im.a();
                        aVar3.setMsgType(27);
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("text", d.this.mPageContext.getString(a.i.sdk_im_online));
                            jSONObject2.put("content_type", "custom_network_change");
                            aVar3.setContent(jSONObject2.toString());
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        d.this.a(-1, aVar3);
                        if (d.this.aTG != null) {
                            d.this.aTG.r(aVar3);
                            d.this.aTG.d(d.this.mMsgList, true);
                        }
                    }
                }
            }
        };
        this.aUb = new Runnable() { // from class: com.baidu.live.im.d.16
            @Override // java.lang.Runnable
            public void run() {
                if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().getLastReceDataTime() > 35000) {
                    d.this.CV();
                }
                d.this.CU();
            }
        };
        this.aUc = new HttpMessageListener(1021013) { // from class: com.baidu.live.im.d.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    boolean z2 = false;
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        int error = httpResponsedMessage.getError();
                        if (com.baidu.live.v.a.Hs().aZn.aCd == 1) {
                            if (error == 149010) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913070, d.this.mPageContext.getPageActivity().getString(a.i.im_improper_content_tip)));
                                z2 = true;
                            } else if (error == 1202 || error == 1203) {
                                BdUtilHelper.showToast(d.this.mPageContext.getPageActivity(), d.this.mPageContext.getPageActivity().getString(a.i.im_improper_content_tip_net));
                                z2 = true;
                            } else if (error == 1204) {
                                BdUtilHelper.showToast(d.this.mPageContext.getPageActivity(), d.this.mPageContext.getPageActivity().getString(a.i.im_improper_content_tip));
                                z2 = true;
                            }
                        }
                    }
                    if (!z2 && d.this.aTG != null) {
                        d.this.aTG.Dd();
                    }
                }
            }
        };
        this.aUd = new HttpMessageListener(1021015) { // from class: com.baidu.live.im.d.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof com.baidu.live.gift.j) {
                        com.baidu.live.gift.j jVar = (com.baidu.live.gift.j) orginalMessage;
                        boolean z2 = false;
                        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            z2 = true;
                            if (!d.this.aTT) {
                                d.this.d(jVar.aIM, jVar.giftName);
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                        }
                        if (d.this.aTT) {
                            d.this.a(jVar.giftId, jVar.aIM, jVar.aIQ, z2, jVar.aIR);
                        }
                    }
                }
            }
        };
        this.aUe = new HttpMessageListener(1021014) { // from class: com.baidu.live.im.d.19
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
                            if (!d.this.aTT) {
                                d.this.d(pVar.aIM, pVar.giftName);
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                        }
                        if (d.this.aTT) {
                            d.this.a(pVar.giftId, pVar.aIM, pVar.aIQ, z2, pVar.aIR);
                        }
                    }
                }
            }
        };
        this.aUf = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.live.im.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                boolean z2;
                boolean z3;
                if (httpResponsedMessage != null) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof com.baidu.live.gift.q) {
                        com.baidu.live.gift.q qVar = (com.baidu.live.gift.q) orginalMessage;
                        if ((httpResponsedMessage instanceof GiftPackageConsumeHttpResponsedMessage) && TextUtils.isEmpty(((GiftPackageConsumeHttpResponsedMessage) httpResponsedMessage).aJw)) {
                            if (!d.this.aTT) {
                                d.this.d(qVar.aJv, qVar.giftName);
                            }
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            if (!d.this.aTT) {
                                d.this.d(qVar.aJv, qVar.giftName);
                            }
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (d.this.aTT) {
                            d.this.a(qVar.giftId, qVar.aJv, qVar.aIQ, z3, qVar.aIR);
                        }
                    }
                }
            }
        };
        this.aUg = new HttpMessageListener(1021012) { // from class: com.baidu.live.im.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                d.this.a((ResponsedMessage<?>) httpResponsedMessage, false);
            }
        };
        this.aUh = new NetMessageListener(1021050, 601008) { // from class: com.baidu.live.im.d.4
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                JSONObject jSONObject;
                AlaGetLiveStatusHttpResponseMessage alaGetLiveStatusHttpResponseMessage = responsedMessage instanceof AlaGetLiveStatusHttpResponseMessage ? (AlaGetLiveStatusHttpResponseMessage) responsedMessage : null;
                if (alaGetLiveStatusHttpResponseMessage != null) {
                    try {
                        jSONObject = new JSONObject(alaGetLiveStatusHttpResponseMessage.aZe);
                    } catch (JSONException e) {
                        jSONObject = null;
                    }
                    if (jSONObject != null) {
                        if (!"backstage_live".equals(jSONObject.optString("content_type"))) {
                            d.this.a(alaGetLiveStatusHttpResponseMessage.aZe, jSONObject, 12, false);
                            return;
                        }
                        String optString = jSONObject.optString("backstage_type");
                        if (!TextUtils.isEmpty(optString) && !optString.equals(d.this.aTO)) {
                            d.this.a(alaGetLiveStatusHttpResponseMessage.aZe, jSONObject, 13, true);
                            d.this.aTO = optString;
                        }
                    }
                }
            }
        };
        this.count = 1L;
        this.aUi = new CustomMessageListener(2913192) { // from class: com.baidu.live.im.d.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText banlstn sd=" + d.this.avf);
                if (d.this.avf != null) {
                    if (d.this.avf.mLiveInfo.getUserID() == Long.valueOf(TbadkCoreApplication.getCurrentAccount()).longValue()) {
                        Log.i("i", "@@@ localText banlstn own");
                        if (d.this.avf.ayC != null && d.this.avf.mLiveInfo != null) {
                            Log.i("i", "@@@ localText banlstn own sdreq");
                            d.this.g(d.this.avf.ayC.userId, d.this.avf.mLiveInfo.live_id);
                            return;
                        }
                        return;
                    }
                    Log.i("i", "@@@ localText banlstn oth");
                    if (d.this.avf.ayV != null && d.this.avf.mLiveInfo != null) {
                        Log.i("i", "@@@ localText banlstn oth sdreq");
                        d.this.g(d.this.avf.ayV.userId, d.this.avf.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.aUj = new CustomMessageListener(2913185) { // from class: com.baidu.live.im.d.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.aTT && customResponsedMessage != null && (customResponsedMessage.getData() instanceof h)) {
                    h hVar = (h) customResponsedMessage.getData();
                    com.baidu.live.im.data.a b = d.this.b(hVar.giftId, hVar.count + "", hVar.giftName, 0L, hVar.aVK);
                    if (b != null) {
                        double l = d.this.l(b);
                        b.setMsgId(0L);
                        b.setRecordId(0L);
                        com.baidu.live.data.a Eh = b.Eh();
                        if (Eh != null && !StringUtils.isNull(Eh.userId) && !StringUtils.isNull(hVar.giftId)) {
                            String str = Eh.userId;
                            String nameShow = Eh.getNameShow();
                            String str2 = str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + hVar.giftId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + nameShow;
                            if (d.this.aTV == null) {
                                d.this.aTV = new HashMap();
                            }
                            hVar.aVG = b;
                            hVar.userId = str;
                            hVar.userName = nameShow;
                            hVar.aVJ = l;
                            if (!d.this.aTV.containsKey(str2)) {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Long.valueOf(hVar.aIQ), hVar);
                                d.this.aTV.put(str2, hashMap);
                                return;
                            }
                            ((HashMap) d.this.aTV.get(str2)).put(Long.valueOf(hVar.aIQ), hVar);
                        }
                    }
                }
            }
        };
        this.aUk = new CustomMessageListener(2913184) { // from class: com.baidu.live.im.d.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                    i iVar = (i) customResponsedMessage.getData();
                    if (iVar.aVO > 0) {
                        HashMap hashMap = (HashMap) d.this.aTU.get(iVar.aNE);
                        if (hashMap != null && !hashMap.isEmpty()) {
                            h hVar = (h) hashMap.remove(Long.valueOf(iVar.aVO));
                            if (hVar != null) {
                                hVar.aVM = true;
                                hVar.aVG.ai(hVar.count);
                                hVar.aVG.i(hVar.aVJ);
                                hVar.aVG.aj(hVar.aVI);
                                d.this.a(-1, hVar.aVG);
                                if (d.this.aTG != null) {
                                    d.this.aTG.d(d.this.mMsgList, true);
                                }
                            }
                            if (hashMap.isEmpty()) {
                                d.this.aTU.remove(iVar.aNE);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    HashMap hashMap2 = (HashMap) d.this.aTV.get(iVar.aNE);
                    if (hashMap2 != null && !hashMap2.isEmpty()) {
                        h hVar2 = (h) hashMap2.get(Long.valueOf(iVar.aVQ));
                        if (hVar2 != null) {
                            if (hVar2.aVL != 0) {
                                hVar2.aVM = true;
                                return;
                            }
                            hashMap2.remove(Long.valueOf(iVar.aVQ));
                            hVar2.aVG.ai(hVar2.count);
                            hVar2.aVG.i(hVar2.aVJ);
                            hVar2.aVG.aj(hVar2.aVI);
                            d.this.a(-1, hVar2.aVG);
                            if (d.this.aTG != null) {
                                d.this.aTG.d(d.this.mMsgList, true);
                            }
                            long j = hVar2.aVH;
                            if (j > 0) {
                                d.this.d(j, hVar2.giftName);
                            }
                        }
                        if (hashMap2.isEmpty()) {
                            d.this.aTV.remove(iVar.aNE);
                        }
                    }
                }
            }
        };
        this.aUl = new CustomMessageListener(2913183) { // from class: com.baidu.live.im.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                    i iVar = (i) customResponsedMessage.getData();
                    if (iVar.aVO == 0) {
                        HashMap hashMap = (HashMap) d.this.aTV.get(iVar.aNE);
                        if (hashMap != null && !hashMap.isEmpty()) {
                            h hVar = (h) hashMap.get(Long.valueOf(iVar.aVQ));
                            h hVar2 = (h) hashMap.get(Long.valueOf(iVar.aVT));
                            if (hVar != null && hVar2 != null) {
                                hashMap.remove(Long.valueOf(iVar.aVT));
                                hVar.count += hVar2.count;
                                hVar.aVI += hVar2.aVI;
                                hVar.aVH += hVar2.aVH;
                                hVar.aVL += hVar2.aVL;
                                if (hVar.aVJ != hVar2.aVJ) {
                                    hVar.aVJ = 0.0d;
                                }
                                hVar.aVN.add(Long.valueOf(hVar2.aIQ));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    HashMap hashMap2 = (HashMap) d.this.aTU.get(iVar.aNE);
                    if (hashMap2 != null && !hashMap2.isEmpty()) {
                        h hVar3 = (h) hashMap2.get(Long.valueOf(iVar.aVO));
                        h hVar4 = (h) hashMap2.remove(Long.valueOf(iVar.aVR));
                        if (hVar3 != null && hVar4 != null) {
                            hVar3.count += hVar4.count;
                            hVar3.aVI += hVar4.aVI;
                            if (hVar3.aVJ != hVar4.aVJ) {
                                hVar3.aVJ = 0.0d;
                            }
                        }
                    }
                }
            }
        };
        this.aUm = new CustomMessageListener(2913195) { // from class: com.baidu.live.im.d.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                HashMap hashMap;
                h hVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                    i iVar = (i) customResponsedMessage.getData();
                    if (iVar.aVO != 0 && (hashMap = (HashMap) d.this.aTU.get(iVar.aNE)) != null && !hashMap.isEmpty() && (hVar = (h) hashMap.get(Long.valueOf(iVar.aVO))) != null) {
                        hVar.count = iVar.aVU;
                        hVar.aVI = iVar.aVV;
                    }
                }
            }
        };
        this.aUn = new HttpMessageListener(1021194) { // from class: com.baidu.live.im.d.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                d.this.aTP = false;
                d.this.mHandler.removeCallbacks(d.this.aTY);
                if (httpResponsedMessage != null) {
                    if (httpResponsedMessage.getOrginalMessage() == null || !(httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.im.message.c) || !((com.baidu.live.im.message.c) httpResponsedMessage.getOrginalMessage()).am(System.currentTimeMillis())) {
                        if (d.this.aTQ) {
                            d.this.aTQ = false;
                            return;
                        } else if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            ImForbiddenStateData imForbiddenStateData = new ImForbiddenStateData();
                            imForbiddenStateData.errno = httpResponsedMessage.getError();
                            imForbiddenStateData.errMsg = httpResponsedMessage.getErrorString();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, imForbiddenStateData));
                            return;
                        } else if (httpResponsedMessage instanceof AlaForbiddenWordsStateResponseMessage) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, ((AlaForbiddenWordsStateResponseMessage) httpResponsedMessage).aXk));
                            return;
                        } else {
                            return;
                        }
                    }
                    d.this.aTQ = false;
                }
            }
        };
        this.aTC = com.baidu.live.v.a.Hs().aZn.aCe;
        this.aTD = com.baidu.live.v.a.Hs().aZn.aCf;
        this.aTE = com.baidu.live.v.a.Hs().aZn.aCg;
        this.mPageContext = bdPageContext;
        this.aTF = z;
        this.aTG = aVar;
        this.mMsgList = new LinkedList<>();
        this.aTU = new LinkedHashMap<>();
        this.aTV = new HashMap<>();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913182, Object.class);
        if (runTask != null && runTask.getData() != null) {
            this.aTT = true;
        }
        MessageManager.getInstance().registerTask(CT());
        com.baidu.live.tieba.f.a.a.a(1021050, "alaim/gmsg/getLiveStatus", AlaGetLiveStatusHttpResponseMessage.class, false, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021012, "alaim/gmsg/getGroupMsg", ALAGroupHttpResponseMessage.class, false, true, true, true);
        Db();
        registerListener(this.aUn);
    }

    public void e(q qVar) {
        this.avf = qVar;
        if (this.avf != null && this.avf.mLiveInfo != null) {
            this.aTR = this.avf.mLiveInfo.audience_count - this.avf.mLiveInfo.ai_robot_num;
        }
    }

    private HttpMessageTask CT() {
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
    public void CU() {
        this.mHandler.postDelayed(this.aUb, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CV() {
        sendMessage(new com.baidu.live.im.message.b(JavaTypesHelper.toInt(this.mGroupId, 0), getLastMid()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CW() {
        this.mHandler.removeCallbacks(this.aUb);
    }

    public void d(long j, String str) {
        if (j == 0) {
            j = 1;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.mPageContext.getString(a.i.sdk_gift);
        }
        com.baidu.live.im.data.a a2 = a((short) 27, String.format(this.mPageContext.getString(a.i.sdk_send_gift_fail), Long.valueOf(j), str), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), this.aza);
        if (a2 != null) {
            a(-1, a2);
            if (this.aTG != null) {
                this.aTG.r(a2);
                this.aTG.d(this.mMsgList, true);
            }
        }
    }

    public com.baidu.live.im.data.a b(String str, String str2, String str3, long j, boolean z) {
        return a((short) 24, c(str, TextUtils.isEmpty(str2) ? "1" : str2, TextUtils.isEmpty(str3) ? this.mPageContext.getString(a.i.sdk_gift) : str3, j, z).toString(), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), this.aza);
    }

    private JSONObject c(String str, String str2, String str3, long j, boolean z) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, JSONObject jSONObject, int i, boolean z) {
        com.baidu.live.im.a aVar = new com.baidu.live.im.a();
        aVar.setMsgType(i);
        aVar.setContent(str);
        aVar.setObjContent(jSONObject);
        if (z) {
            a(-1, aVar);
        }
        if (this.aTG != null) {
            this.aTG.r(aVar);
            if (z) {
                this.aTG.d(this.mMsgList, true);
            }
        }
    }

    protected void a(ResponsedMessage<?> responsedMessage, boolean z) {
        boolean z2;
        long j;
        List<com.baidu.live.im.data.a> list;
        if (responsedMessage instanceof ALAGroupHttpResponseMessage) {
            List<com.baidu.live.im.data.a> Ex = ((ALAGroupHttpResponseMessage) responsedMessage).Ex();
            j = ((ALAGroupHttpResponseMessage) responsedMessage).getGroupId();
            list = Ex;
            z2 = ((ALAGroupHttpResponseMessage) responsedMessage).Ew();
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
                J(list);
            }
            if (TbConfig.isForceNoticeIm && list != null && !list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                    com.baidu.live.im.data.a aVar = list.get(i);
                    if (aVar.getMsgType() == 13 || aVar.getMsgType() == 24) {
                        if (TbConfig.forceImType != 0) {
                            aVar.setMsgType(TbConfig.forceImType);
                        }
                        aVar.setContent(TbConfig.forceImContent);
                        aVar.setObjContent(null);
                    }
                }
            }
            c(list, z2);
            if (this.aTL != 0) {
                int i2 = this.aTM * this.aTK;
                ArrayList arrayList = new ArrayList(this.aTJ);
                d(0, arrayList.subList(i2, arrayList.size()));
                CZ();
            }
            if (list.size() > 0) {
                if (list.size() > 5 && z) {
                    H(list);
                } else {
                    G(a(list, z, z2));
                }
            }
        }
    }

    public void e(String str, String str2, String str3, String str4, String str5) {
        if (this.mMsgList != null) {
            this.mMsgList.clear();
        }
        if (this.aTU != null) {
            this.aTU.clear();
        }
        if (this.aTV != null) {
            this.aTV.clear();
        }
        this.mMsgList = new LinkedList<>();
        this.mGroupId = str;
        this.aTH = str2;
        this.aTI = str3;
        this.mLiveId = str4;
        this.aTO = "0";
        this.mAppId = str5;
        MessageManager.getInstance().registerListener(this.aUg);
        MessageManager.getInstance().registerListener(this.aUh);
        MessageManager.getInstance().registerListener(this.aTZ);
        MessageManager.getInstance().registerListener(this.aUc);
        MessageManager.getInstance().registerListener(this.aUa);
        MessageManager.getInstance().registerListener(this.aUd);
        MessageManager.getInstance().registerListener(this.aUe);
        MessageManager.getInstance().registerListener(this.aUf);
        MessageManager.getInstance().registerListener(this.aUj);
        MessageManager.getInstance().registerListener(this.aUk);
        MessageManager.getInstance().registerListener(this.aUl);
        MessageManager.getInstance().registerListener(this.aUm);
        MessageManager.getInstance().registerListener(this.aUi);
        if (BdSocketLinkService.isClose()) {
            CV();
            BdSocketLinkService.startService(true, "live start");
        }
        String str6 = com.baidu.live.v.a.Hs().aZn.azK;
        if (!TextUtils.isEmpty(str6)) {
            com.baidu.live.im.data.a Da = Da();
            Da.setMsgType(27);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("text", str6);
                jSONObject.put("content_type", "custom_live_notice");
                Da.setContent(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            a(-1, Da);
            if (this.aTG != null) {
                this.aTG.r(Da);
            }
        }
        String str7 = com.baidu.live.v.a.Hs().aZn.azL;
        if (!TextUtils.isEmpty(str7)) {
            com.baidu.live.im.data.a Da2 = Da();
            Da2.setMsgType(27);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("text", str7);
                jSONObject2.put("content_type", "custom_live_notice");
                Da2.setContent(jSONObject2.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            a(-1, Da2);
        }
        List<String> list = com.baidu.live.v.a.Hs().aZn.azJ;
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
                    com.baidu.live.im.data.a Da3 = Da();
                    Da3.setMsgType(27);
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("text", str8);
                        jSONObject3.put("content_type", "custom_im_notice");
                        Da3.setContent(jSONObject3.toString());
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                    Da3.setLink(str9);
                    a(-1, Da3);
                    if (this.aTG != null) {
                        this.aTG.r(Da3);
                    }
                }
                i = i2 + 2;
            }
        }
        if (this.avf != null && this.avf.azi != null && !StringUtils.isNull(this.avf.azi.wP())) {
            com.baidu.live.im.data.a Da4 = Da();
            Da4.setMsgType(27);
            try {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("text", this.avf.azi.wP());
                jSONObject4.put("content_type", "custom_live_notice");
                Da4.setContent(jSONObject4.toString());
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            this.mMsgList.add(Da4);
            if (this.aTG != null) {
                this.aTG.r(Da4);
            }
        }
        CX();
        if (this.mMsgList.size() > 0 && this.aTG != null) {
            this.aTG.d(this.mMsgList, true);
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGmsgGetLiveStatusUnabled()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.fr("enter");
                }
            }, 1000L);
        }
        CU();
        if (TbadkCoreApplication.getInst().isOther()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913146, this.mMsgList));
        }
    }

    private void CX() {
        if (CY()) {
            com.baidu.live.im.data.a Da = Da();
            Da.setMsgType(27);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("text", com.baidu.live.v.a.Hs().aZn.aCa.ayL);
                jSONObject.put("content_type", "custom_im_notice_live_assistant");
                Da.setContent(jSONObject.toString());
                Da.setLink(com.baidu.live.v.a.Hs().aZn.aCa.ayK);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mMsgList.add(Da);
            if (this.aTG != null) {
                this.aTG.r(Da);
            }
        }
    }

    private boolean CY() {
        return (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) || !TbadkCoreApplication.getCurrentAccount().equals(this.aTI) || com.baidu.live.v.a.Hs().aZn == null || com.baidu.live.v.a.Hs().aZn.aCa == null || TextUtils.isEmpty(com.baidu.live.v.a.Hs().aZn.aCa.ayL)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(List<com.baidu.live.im.data.a> list) {
        if (list != null && this.aTG != null) {
            this.aTG.d(this.mMsgList, true);
            for (com.baidu.live.im.data.a aVar : list) {
                this.aTG.r(aVar);
            }
        }
    }

    protected void H(List<com.baidu.live.im.data.a> list) {
        this.aTJ = list;
        this.aTL = (int) ((this.aTN * 2.0f) / 0.25f);
        this.aTM = 0;
        this.aTK = list.size() / this.aTL;
        if (this.aTK <= 0) {
            this.aTK = 1;
        }
        this.mHandler.removeCallbacks(this.aTX);
        this.mHandler.postDelayed(this.aTX, 250L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CZ() {
        this.mHandler.removeCallbacks(this.aTX);
        this.aTM = 0;
        this.aTL = 0;
        this.aTK = 0;
        this.aTJ = null;
    }

    protected List<com.baidu.live.im.data.a> b(List<com.baidu.live.im.data.a> list, boolean z) {
        return a(list, z, false);
    }

    protected List<com.baidu.live.im.data.a> a(List<com.baidu.live.im.data.a> list, boolean z, boolean z2) {
        for (com.baidu.live.im.data.a aVar : list) {
            if (aVar instanceof com.baidu.live.im.a) {
                ((com.baidu.live.im.a) aVar).fq(this.aTI);
            }
        }
        if (z) {
            LinkedList linkedList = new LinkedList();
            for (com.baidu.live.im.data.a aVar2 : list) {
                if (aVar2.getMsgId() > getLastMid()) {
                    if (aVar2.getMsgType() == 24) {
                        if (!z2) {
                            l(aVar2);
                        }
                        List<com.baidu.live.im.data.a> q = q(aVar2);
                        b(q, -1);
                        linkedList.addAll(q);
                    } else {
                        a(-1, aVar2);
                        linkedList.add(aVar2);
                    }
                }
            }
            list = linkedList;
        } else {
            delRepeatMsg(this.mMsgList, list);
            d(z2, list);
            if (!z2) {
                I(list);
            }
            if (z2 && this.mMsgList.size() > 2) {
                b(list, 2);
            } else {
                b(list, -1);
            }
        }
        if (this.mMsgList.size() > com.baidu.live.v.a.Hs().aZn.aBP) {
            int i = (int) (com.baidu.live.v.a.Hs().aZn.aBP * 0.7d);
            if (i <= 0) {
                i = 1;
            }
            while (this.mMsgList.size() > i) {
                this.mMsgList.removeFirst();
            }
        }
        return list;
    }

    private void I(List<com.baidu.live.im.data.a> list) {
        if (list != null && !list.isEmpty()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    com.baidu.live.im.data.a aVar = list.get(i2);
                    if (aVar.getMsgType() == 24) {
                        l(aVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double l(com.baidu.live.im.data.a aVar) {
        double d;
        JSONException e;
        JSONObject jSONObject;
        List<AlaLiveMarkData> list;
        boolean z = false;
        com.baidu.live.data.a Eh = aVar.Eh();
        if (Eh != null && (list = Eh.axQ) != null && !list.isEmpty()) {
            for (AlaLiveMarkData alaLiveMarkData : list) {
                if (alaLiveMarkData.type == 102) {
                    z = true;
                    break;
                }
            }
        }
        try {
            if (aVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) aVar.getObjContent();
            } else {
                jSONObject = new JSONObject(aVar.getContent());
            }
            d = com.baidu.live.v.d.Hz().g(z, jSONObject.optString(LogConfig.LOG_GIFT_ID));
            if (d < 0.0d) {
                d = 0.0d;
            }
            try {
                jSONObject.put("gift_rate", d);
                aVar.setObjContent(jSONObject);
                aVar.setContent(jSONObject.toString());
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

    private void d(boolean z, List<com.baidu.live.im.data.a> list) {
        JSONObject jSONObject;
        if (z && list != null && !list.isEmpty()) {
            Iterator<com.baidu.live.im.data.a> it = list.iterator();
            while (it.hasNext()) {
                com.baidu.live.im.data.a next = it.next();
                if (next != null) {
                    try {
                        if (next.getObjContent() instanceof JSONObject) {
                            jSONObject = (JSONObject) next.getObjContent();
                        } else {
                            jSONObject = new JSONObject(next.getContent());
                        }
                        String optString = jSONObject.optString("content_type");
                        if (!TextUtils.isEmpty(optString) && (optString.equals("challenge_direct_start") || optString.equals("challenge_direct_matched") || optString.equals("challenge_random_start") || optString.equals("challenge_random_matched") || optString.equals("live_net_status") || optString.equals("send_redpacket") || optString.equals("start_grab_redpacket") || optString.equals("guard_seat") || optString.equals("challenge_mvp") || optString.equals("challenge_mvp_punish") || optString.equals("challenge_winner_by_autofail") || optString.equals("official_notice") || optString.equals("privilege_award_royal_success"))) {
                            it.remove();
                        }
                    } catch (JSONException e) {
                    }
                }
            }
        }
    }

    private void J(List<com.baidu.live.im.data.a> list) {
        if (list != null && !list.isEmpty()) {
            for (com.baidu.live.im.data.a aVar : list) {
                aVar.bL(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.live.im.data.a aVar) {
        if (this.aTR < this.aTC) {
            if (i >= 0) {
                this.mMsgList.add(i, aVar);
            } else {
                this.mMsgList.addLast(aVar);
            }
        } else if (this.aTR >= this.aTC && this.aTR < this.aTD) {
            if (p(aVar)) {
                if (!this.mMsgList.isEmpty() && p(this.mMsgList.getLast())) {
                    this.mMsgList.set(this.mMsgList.size() - 1, aVar);
                } else {
                    this.mMsgList.addLast(aVar);
                }
            } else if (i >= 0) {
                this.mMsgList.add(i, aVar);
            } else {
                this.mMsgList.addLast(aVar);
            }
        } else if (this.aTR >= this.aTD && this.aTR < this.aTE) {
            if (n(aVar)) {
                if (!this.mMsgList.isEmpty() && n(this.mMsgList.getLast())) {
                    this.mMsgList.set(this.mMsgList.size() - 1, aVar);
                } else {
                    this.mMsgList.addLast(aVar);
                }
            } else if (i >= 0) {
                this.mMsgList.add(i, aVar);
            } else {
                this.mMsgList.addLast(aVar);
            }
        } else if (this.aTR >= this.aTE) {
            if (!n(aVar)) {
                if (i >= 0) {
                    this.mMsgList.add(i, aVar);
                } else {
                    this.mMsgList.addLast(aVar);
                }
            }
        } else if (i >= 0) {
            this.mMsgList.add(i, aVar);
        } else {
            this.mMsgList.addLast(aVar);
        }
    }

    private void d(int i, List<com.baidu.live.im.data.a> list) {
        if (i >= 0) {
            for (com.baidu.live.im.data.a aVar : list) {
                a(i, aVar);
                i++;
            }
            return;
        }
        for (com.baidu.live.im.data.a aVar2 : list) {
            a(-1, aVar2);
        }
    }

    private int m(com.baidu.live.im.data.a aVar) {
        String str;
        JSONObject jSONObject;
        this.aTS = 0;
        if (aVar.getMsgType() == 13 || aVar.getMsgType() == 12) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                str = jSONObject.optString("content_type");
            } catch (JSONException e) {
                str = null;
            }
            if ("enter_live".equals(str)) {
                if (com.baidu.live.entereffect.a.xD().h(aVar)) {
                    this.aTS = 2;
                } else {
                    this.aTS = 1;
                }
            } else {
                this.aTS = 0;
            }
        }
        return this.aTS;
    }

    private boolean n(com.baidu.live.im.data.a aVar) {
        return p(aVar) || o(aVar);
    }

    private boolean o(com.baidu.live.im.data.a aVar) {
        return m(aVar) == 2;
    }

    private boolean p(com.baidu.live.im.data.a aVar) {
        return m(aVar) == 1;
    }

    private void delRepeatMsg(List<com.baidu.live.im.data.a> list, List<com.baidu.live.im.data.a> list2) {
        if (list != null && list2 != null) {
            int size = list.size();
            int size2 = list2.size();
            if (size2 != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = size2 - 1; i >= 0 && i >= 0; i--) {
                    com.baidu.live.im.data.a aVar = list2.get(i);
                    if (aVar != null && aVar.Eh() != null && !TextUtils.isEmpty(aVar.Eh().userId) && aVar.Eh().userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        int i2 = size - 1;
                        while (true) {
                            if (i2 >= 0 && i2 >= 0) {
                                com.baidu.live.im.data.a aVar2 = list.get(i2);
                                if (aVar2 != null && aVar2.Eh() != null && !TextUtils.isEmpty(aVar2.Eh().userId) && aVar2.Eh().userId.equals(TbadkCoreApplication.getCurrentAccount()) && aVar.getRecordId() == aVar2.getRecordId()) {
                                    arrayList.add(aVar);
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

    private void c(List<com.baidu.live.im.data.a> list, boolean z) {
        String str;
        JSONObject jSONObject;
        LinkedList linkedList = new LinkedList();
        for (com.baidu.live.im.data.a aVar : list) {
            long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
            if (!ListUtils.isEmpty(aVar.Ej()) && !aVar.Ej().contains(Long.valueOf(currentAccountId))) {
                linkedList.add(aVar);
            } else {
                boolean z2 = aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                if (z2 && aVar.getMsgType() == 1 && !ListUtils.isEmpty(aVar.Eh().axQ) && this.aza == null) {
                    this.aza = aVar.Eh().axQ;
                }
                if (z2 && aVar.getMsgType() != 125 && aVar.getMsgType() != 24 && aVar.getMsgType() != 13 && aVar.getMsgType() != 28) {
                    if (aVar.getMsgType() != 1 || !z) {
                        linkedList.add(aVar);
                    }
                } else if (this.aTT && z2 && aVar.getMsgType() == 24) {
                    linkedList.add(aVar);
                } else if (aVar.getMsgType() == 125) {
                    try {
                        if (!"1".equals(new JSONObject(aVar.getContent()).optString("is_first"))) {
                            linkedList.add(aVar);
                            if (this.aTG != null) {
                                this.aTG.r(aVar);
                            }
                        }
                    } catch (JSONException e) {
                        BdLog.e(e);
                        linkedList.add(aVar);
                    }
                } else if (aVar.getMsgType() == 13) {
                    try {
                        if (aVar.getObjContent() instanceof JSONObject) {
                            jSONObject = (JSONObject) aVar.getObjContent();
                        } else {
                            jSONObject = new JSONObject(aVar.getContent());
                        }
                        str = jSONObject.optString("content_type");
                    } catch (JSONException e2) {
                        linkedList.add(aVar);
                        str = null;
                    }
                    if ("enter_live".equals(str) && this.aTR < this.aTE) {
                        if (com.baidu.live.entereffect.a.xD().h(aVar)) {
                        }
                    } else if ("close_live".equals(str)) {
                        linkedList.add(aVar);
                        if (this.aTG != null) {
                            this.aTG.r(aVar);
                        }
                    } else if ("task".equals(str)) {
                        linkedList.add(aVar);
                        if (this.aTG != null) {
                            this.aTG.r(aVar);
                        }
                    } else if ("live_achievement".equals(str)) {
                        linkedList.add(aVar);
                        if (this.aTG != null) {
                            this.aTG.r(aVar);
                        }
                    } else if ("ss_hot_live".equals(str)) {
                        linkedList.add(aVar);
                        if (this.aTG != null) {
                            this.aTG.r(aVar);
                        }
                    } else if ("challenge_direct_new".equals(str)) {
                        linkedList.add(aVar);
                        if (this.aTG != null) {
                            this.aTG.r(aVar);
                        }
                    } else if ("challenge_random_cancel".equals(str)) {
                        linkedList.add(aVar);
                        if (this.aTG != null) {
                            this.aTG.r(aVar);
                        }
                    } else if ("update_liveinfo".equals(str)) {
                        linkedList.add(aVar);
                        if (this.aTG != null) {
                            this.aTG.r(aVar);
                        }
                    } else if ("backstage_live".equals(str)) {
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                    } else if ("offline_type".equals(str)) {
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                    } else if ("follow_anchor".equals(str)) {
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                    } else if (com.baidu.tbadk.TbConfig.TMP_SHARE_DIR_NAME.equals(str)) {
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                    } else if ("share_tieba".equals(str)) {
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                    } else if ("remove_video".equals(str)) {
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                    } else if ("ueg_warn".equals(str)) {
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                    } else if ("live_admin".equals(str)) {
                        if (z2 && !ListUtils.isEmpty(aVar.Eh().axQ)) {
                            this.aza = aVar.Eh().axQ;
                            if (this.avf != null) {
                                this.avf.aza = this.aza;
                            }
                        }
                    } else if (!"live_talk_ban".equals(str) && !"live_talk_remove_ban".equals(str) && !"live_talk_admin_ban".equals(str) && !"live_talk_admin_remove_ban".equals(str) && !"live_on_private".equals(str)) {
                        if ("challenge_direct_matched".equals(str)) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if ("challenge_direct_start".equals(str)) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if ("challenge_random_matched".equals(str)) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if ("challenge_random_start".equals(str)) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str, "share_rmb")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str, "zan_rmb")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str, "start_grab_wheel")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str, "guard_club_join")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str, "haokan_buy_goods")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str, "send_redpacket")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str, "start_grab_redpacket")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str, "guard_seat")) {
                            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                                linkedList.add(aVar);
                            }
                        } else if (TextUtils.equals(str, "challenge_mvp")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, "CONTENT_TYPE_CHALLENGE_MVP");
                        } else if (TextUtils.equals(str, "challenge_mvp_punish")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, "CONTENT_TYPE_CHALLENGE_MVP_PUNISH");
                        } else if (!TextUtils.equals(str, "challenge_winner_by_autofail")) {
                            if (TextUtils.equals(str, "wish_list_finish") || TextUtils.equals(str, "wish_list_success")) {
                                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                                    linkedList.add(aVar);
                                }
                            } else if ("ui_event".equals(str)) {
                                linkedList.add(aVar);
                                if (this.aTG != null) {
                                    this.aTG.r(aVar);
                                }
                            } else if ("introduce_goods".equals(str)) {
                                linkedList.add(aVar);
                                if (this.aTG != null) {
                                    this.aTG.r(aVar);
                                }
                            } else if ("first_recharge_success".equals(str)) {
                                linkedList.add(aVar);
                                if (this.aTG != null) {
                                    this.aTG.r(aVar);
                                }
                            } else if ("privilege_award_success".equals(str)) {
                                linkedList.add(aVar);
                                if (this.aTG != null) {
                                    this.aTG.r(aVar);
                                }
                            } else if ("need_update_live_mark_info".equals(str)) {
                                linkedList.add(aVar);
                                if (this.aTG != null) {
                                    this.aTG.r(aVar);
                                }
                            } else if ("official_notice".equals(str)) {
                                linkedList.add(aVar);
                                if (this.aTG != null && !z) {
                                    this.aTG.r(aVar);
                                }
                            } else if (TextUtils.equals(str, "privilege_award_royal_success")) {
                                Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                            } else if (!TextUtils.equals(str, "add_tags_to_anchor")) {
                                linkedList.add(aVar);
                            }
                        }
                    }
                } else if (aVar.getMsgType() == 12) {
                    linkedList.add(aVar);
                    if (this.aTG != null) {
                        this.aTG.r(aVar);
                    }
                    fr("push");
                }
            }
        }
        if (linkedList.size() > 0) {
            list.removeAll(linkedList);
        }
    }

    protected com.baidu.live.im.data.a a(short s, String str, boolean z, boolean z2, int i, List<AlaLiveMarkData> list) {
        long j = 0;
        com.baidu.live.im.data.a Da = Da();
        if (Da == null) {
            return null;
        }
        Da.setMsgType(s);
        Da.setContent(str);
        long ah = o.ah(getLastMid());
        Da.setMsgId(ah);
        Da.setRecordId(ah);
        Da.setTime(System.currentTimeMillis() / 1000);
        com.baidu.live.data.a aVar = new com.baidu.live.data.a();
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            aVar.userName = TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow();
        }
        aVar.userId = TbadkCoreApplication.getCurrentAccount();
        aVar.portrait = TbadkCoreApplication.getCurrentPortrait();
        aVar.level_id = i;
        aVar.axN = z;
        aVar.axO = z2;
        if (list != null) {
            aVar.axQ = new ArrayList(list);
        }
        Da.e(aVar);
        try {
            j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        } catch (Exception e) {
        }
        Da.setUserId(j);
        return Da;
    }

    private long getLastMid() {
        if (this.mMsgList == null || this.mMsgList.size() <= 0) {
            return JavaTypesHelper.toLong(this.aTH, 1L);
        }
        return this.mMsgList.get(this.mMsgList.size() - 1).getMsgId();
    }

    protected com.baidu.live.im.data.a Da() {
        com.baidu.live.im.a aVar = new com.baidu.live.im.a();
        aVar.setBornTime(System.currentTimeMillis());
        if (TextUtils.isEmpty(this.mGroupId)) {
            return null;
        }
        aVar.fq(this.aTI);
        return aVar;
    }

    public void K(List<AlaLiveMarkData> list) {
        this.aza = list;
    }

    public void fr(String str) {
        com.baidu.live.message.c cVar = new com.baidu.live.message.c(JavaTypesHelper.toLong(this.mLiveId, 0L), str);
        cVar.setParams();
        sendMessage(cVar);
    }

    public void fs(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.aTO)) {
            fr("getliveinfo");
        }
    }

    private List<com.baidu.live.im.data.a> q(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        int optInt;
        boolean yv;
        ArrayList arrayList = new ArrayList();
        if (!(aVar instanceof com.baidu.live.im.a)) {
            arrayList.add(aVar);
            return arrayList;
        }
        com.baidu.live.im.a aVar2 = (com.baidu.live.im.a) aVar;
        try {
            aVar.getObjContent();
            jSONObject = new JSONObject(aVar2.getContent());
            optInt = jSONObject.optInt("is_combo");
            com.baidu.live.gift.g eT = v.eT(jSONObject.optString(LogConfig.LOG_GIFT_ID));
            yv = eT != null ? eT.yv() : false;
        } catch (JSONException e) {
            arrayList.add(aVar2);
        }
        if (optInt == 1 || yv) {
            arrayList.add(aVar2);
            return arrayList;
        }
        long optLong = jSONObject.optLong("gift_count");
        if (optLong <= 1) {
            arrayList.add(aVar2);
            return arrayList;
        }
        jSONObject.put("gift_count", 1);
        String jSONObject2 = jSONObject.toString();
        for (int i = 0; i < optLong; i++) {
            com.baidu.live.im.a aVar3 = new com.baidu.live.im.a();
            aVar3.fq(aVar2.CR());
            aVar3.setBornTime(aVar2.getBornTime());
            aVar3.setTime(aVar2.getTime());
            aVar3.setUserId(aVar2.getUserId());
            aVar3.setToUserId(aVar2.getToUserId());
            aVar3.f(aVar2.Ei());
            aVar3.setContent(jSONObject2);
            aVar3.setObjContent(jSONObject);
            aVar3.setGifLoadSuccess(aVar2.isGifLoadSuccess());
            aVar3.setHasRead(aVar2.isHasRead());
            aVar3.setIsPushForOperateAccount(aVar2.isPushForOperateAccount());
            aVar3.setLink(aVar2.getLink());
            aVar3.setIsUploading(aVar2.getIsUploading());
            aVar3.setMsgId(aVar2.getMsgId());
            aVar3.setMsgType(aVar2.getMsgType());
            aVar3.setProgressValue(aVar2.getProgressValue());
            aVar3.setTaskId(aVar2.getTaskId());
            aVar3.setRecordId(aVar2.getRecordId());
            aVar3.setStat(aVar2.getStat());
            aVar3.setLogTime(aVar2.getLogTime());
            aVar3.e(aVar2.Eh());
            aVar3.setSt_type(aVar2.getSt_type());
            arrayList.add(aVar3);
        }
        return arrayList;
    }

    public void a(int i, String str, com.baidu.live.data.a aVar) {
        com.baidu.live.im.data.a Da = Da();
        if (Da != null) {
            Da.setMsgType(i);
            Da.setContent(str);
            Da.e(aVar);
            a(-1, Da);
            if (this.aTG != null) {
                this.aTG.d(this.mMsgList, true);
                this.aTG.r(Da);
            }
        }
    }

    private void b(List<com.baidu.live.im.data.a> list, int i) {
        JSONObject jSONObject;
        int i2;
        if (this.aTT) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    com.baidu.live.im.data.a aVar = list.get(i4);
                    if (aVar.getMsgType() != 24) {
                        if (i >= 0) {
                            a(i + i4, aVar);
                        } else {
                            a(-1, aVar);
                        }
                    } else {
                        try {
                            if (aVar.getObjContent() instanceof JSONObject) {
                                jSONObject = (JSONObject) aVar.getObjContent();
                            } else {
                                jSONObject = new JSONObject(aVar.getContent());
                            }
                        } catch (JSONException e) {
                            jSONObject = null;
                        }
                        if (jSONObject == null) {
                            if (i >= 0) {
                                a(i + i4, aVar);
                            } else {
                                a(-1, aVar);
                            }
                        } else {
                            String optString = jSONObject.optString(LogConfig.LOG_GIFT_ID);
                            com.baidu.live.data.a Eh = aVar.Eh();
                            if (Eh == null || StringUtils.isNull(Eh.userId) || StringUtils.isNull(optString)) {
                                if (i >= 0) {
                                    a(i + i4, aVar);
                                } else {
                                    a(-1, aVar);
                                }
                            } else {
                                String str = Eh.userId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + optString + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + Eh.getNameShow();
                                if (this.aTU == null) {
                                    this.aTU = new LinkedHashMap<>();
                                }
                                long j = JavaTypesHelper.toLong(jSONObject.optString("gift_count"), 0L);
                                double optDouble = jSONObject.optDouble("gift_rate", 0.0d);
                                long j2 = JavaTypesHelper.toLong(jSONObject.optString("charm_value"), 0L);
                                h hVar = new h();
                                hVar.aVG = aVar;
                                hVar.count = j;
                                hVar.aVJ = optDouble;
                                hVar.aVI = j2;
                                if (com.baidu.live.v.a.Hs().aZn == null) {
                                    i2 = 100;
                                } else {
                                    i2 = com.baidu.live.v.a.Hs().aZn.aBU * 2;
                                }
                                Iterator<String> it = this.aTU.keySet().iterator();
                                int i5 = 0;
                                while (it.hasNext()) {
                                    String next = it.next();
                                    if (this.aTU.get(next) == null || this.aTU.get(next).isEmpty()) {
                                        it.remove();
                                    } else {
                                        HashMap<Long, h> hashMap = this.aTU.get(next);
                                        Iterator<Long> it2 = hashMap.keySet().iterator();
                                        while (it2.hasNext()) {
                                            long longValue = it2.next().longValue();
                                            if (hashMap.get(Long.valueOf(longValue)) == null || hashMap.get(Long.valueOf(longValue)).aVM) {
                                                it2.remove();
                                            }
                                        }
                                        if (this.aTU.get(next) == null || this.aTU.get(next).isEmpty()) {
                                            it.remove();
                                        } else {
                                            i5 = hashMap.size() + i5;
                                        }
                                    }
                                }
                                if (i5 > i2) {
                                    int i6 = i5 - ((int) (i2 * 0.7d));
                                    Iterator<String> it3 = this.aTU.keySet().iterator();
                                    while (true) {
                                        int i7 = i6;
                                        if (!it3.hasNext()) {
                                            break;
                                        }
                                        i6 = i7 - this.aTU.get(it3.next()).size();
                                        it3.remove();
                                        if (i6 <= 0) {
                                            break;
                                        }
                                    }
                                }
                                if (!this.aTU.containsKey(str)) {
                                    HashMap<Long, h> hashMap2 = new HashMap<>();
                                    hashMap2.put(Long.valueOf(aVar.getMsgId()), hVar);
                                    this.aTU.put(str, hashMap2);
                                } else {
                                    this.aTU.get(str).put(Long.valueOf(aVar.getMsgId()), hVar);
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
            HashMap<Long, h> hashMap = this.aTV.get(str3);
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
                            if (next.aVN.contains(l)) {
                                hVar = next;
                                break;
                            }
                        }
                    }
                    if (hVar != null) {
                        long longValue = map.get(l).longValue();
                        if (z) {
                            hVar.aVH += longValue;
                        }
                        hVar.aVL -= longValue;
                        if (hVar.aVM && hVar.aVL == 0) {
                            hashMap.remove(Long.valueOf(hVar.aIQ));
                            hVar.aVG.ai(hVar.count);
                            hVar.aVG.i(hVar.aVJ);
                            hVar.aVG.aj(hVar.aVI);
                            a(-1, hVar.aVG);
                            if (this.aTG != null) {
                                this.aTG.d(this.mMsgList, true);
                            }
                            long j3 = hVar.aVH;
                            if (j3 > 0) {
                                d(j3, hVar.giftName);
                            }
                        }
                    }
                }
                if (hashMap.isEmpty()) {
                    this.aTV.remove(str3);
                }
            }
        }
    }

    public void vD() {
        this.mGroupId = null;
        this.aTH = null;
        this.mLiveId = null;
        this.aTO = "0";
        this.mAppId = null;
        this.aTP = false;
        this.aTQ = false;
        MessageManager.getInstance().unRegisterListener(this.aUh);
        MessageManager.getInstance().unRegisterListener(this.aUg);
        MessageManager.getInstance().unRegisterListener(this.aTZ);
        MessageManager.getInstance().unRegisterListener(this.aUc);
        MessageManager.getInstance().unRegisterListener(this.aUd);
        MessageManager.getInstance().unRegisterListener(this.aUe);
        MessageManager.getInstance().unRegisterListener(this.aUf);
        MessageManager.getInstance().unRegisterListener(this.aUa);
        MessageManager.getInstance().unRegisterListener(this.aUj);
        MessageManager.getInstance().unRegisterListener(this.aUk);
        MessageManager.getInstance().unRegisterListener(this.aUl);
        MessageManager.getInstance().unRegisterListener(this.aUm);
        MessageManager.getInstance().unRegisterListener(this.aUi);
        this.mHandler.removeCallbacks(this.aTY);
        this.mHandler.removeCallbacks(this.aTX);
        this.mHandler.removeCallbacks(this.aUb);
        if (this.mMsgList != null) {
            this.mMsgList.clear();
        }
        this.mMsgList = null;
        if (this.aTU != null) {
            this.aTU.clear();
        }
        if (this.aTV != null) {
            this.aTV.clear();
        }
    }

    private void Db() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021194, TbConfig.SERVER_ADDRESS + "ala/live/checkImBan");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaForbiddenWordsStateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(ImSendMsgData imSendMsgData, boolean z, boolean z2, int i, String str, String[] strArr) {
        if (!TbadkCoreApplication.isLogin()) {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.sdk_not_login);
        } else if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow())) {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.sdk_username_empty);
        } else {
            String str2 = imSendMsgData.text;
            short s = imSendMsgData.msgType;
            com.baidu.live.im.data.a a2 = a(s, str2, z, z2, i, this.aza);
            if (s == 126) {
                a2.cG(imSendMsgData.barrageType);
                a2.fw(imSendMsgData.barrageId);
                a2.a(imSendMsgData.barrageCardInfo);
            }
            if (a2 != null) {
                a2.k(strArr);
                a(-1, a2);
                if (this.aTG != null) {
                    this.aTG.r(a2);
                    this.aTG.d(this.mMsgList, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913043));
                com.baidu.live.im.message.a aVar = new com.baidu.live.im.message.a(str2, s, JavaTypesHelper.toInt(this.mGroupId, 0), this.mAppId);
                if (this.avf != null && this.avf.mLiveInfo != null) {
                    aVar.eH(this.avf.mLiveInfo.live_id + "");
                    aVar.fx(this.avf.mLiveInfo.room_id + "");
                } else {
                    aVar.eH("");
                    aVar.fx("");
                }
                aVar.setOtherParams(str);
                aVar.ak(imSendMsgData.price);
                aVar.cG(imSendMsgData.barrageType);
                aVar.fw(imSendMsgData.barrageId);
                aVar.a(imSendMsgData.barrageCardInfo);
                aVar.k(strArr);
                aVar.bM(imSendMsgData.isQuick);
                sendMessage(aVar);
            }
        }
    }

    public void g(long j, long j2) {
        if (!this.aTP) {
            this.aTP = true;
            com.baidu.live.im.message.c cVar = new com.baidu.live.im.message.c(1021194);
            cVar.addParam("user_id", j);
            cVar.addParam("live_id", j2);
            cVar.al(System.currentTimeMillis());
            sendMessage(cVar);
            this.mHandler.postDelayed(this.aTY, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dc() {
        this.aTP = false;
        this.aTQ = true;
        ImForbiddenStateData imForbiddenStateData = new ImForbiddenStateData();
        imForbiddenStateData.errno = -1;
        imForbiddenStateData.errMsg = this.mPageContext.getString(a.i.sdk_neterror);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, imForbiddenStateData));
    }
}
