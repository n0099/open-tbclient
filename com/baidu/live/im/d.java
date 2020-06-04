package com.baidu.live.im;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
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
import com.baidu.live.gift.v;
import com.baidu.live.im.b;
import com.baidu.live.im.data.ImForbiddenStateData;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.message.ALAGroupCommitHttpResponsedMessage;
import com.baidu.live.im.message.ALAGroupHttpResponseMessage;
import com.baidu.live.im.message.AlaForbiddenWordsStateResponseMessage;
import com.baidu.live.message.AlaGetLiveStatusHttpResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.u.a;
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
/* loaded from: classes3.dex */
public class d extends BdBaseModel {
    private com.baidu.live.data.q aJj;
    public int aPD;
    public int aPE;
    public int aPF;
    private boolean aPG;
    private a aPH;
    private String aPI;
    private String aPJ;
    private List<com.baidu.live.im.data.a> aPK;
    private int aPL;
    private int aPM;
    private int aPN;
    private float aPO;
    private String aPP;
    private boolean aPQ;
    private boolean aPR;
    private int aPS;
    private int aPT;
    private boolean aPU;
    private LinkedHashMap<String, HashMap<Long, h>> aPV;
    private HashMap<String, HashMap<Long, h>> aPW;
    private b.a aPX;
    private Runnable aPY;
    private Runnable aPZ;
    private CustomMessageListener aQa;
    private CustomMessageListener aQb;
    private Runnable aQc;
    private HttpMessageListener aQd;
    private HttpMessageListener aQe;
    private HttpMessageListener aQf;
    private HttpMessageListener aQg;
    private NetMessageListener aQh;
    CustomMessageListener aQi;
    CustomMessageListener aQj;
    CustomMessageListener aQk;
    CustomMessageListener aQl;
    CustomMessageListener aQm;
    private HttpMessageListener aQn;
    private List<AlaLiveMarkData> avH;
    private long count;
    private String mAppId;
    private String mGroupId;
    private Handler mHandler;
    private String mLiveId;
    private LinkedList<com.baidu.live.im.data.a> mMsgList;
    BdPageContext<?> mPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        void Cc();

        void d(List<com.baidu.live.im.data.a> list, boolean z);

        void k(com.baidu.live.im.data.a aVar);
    }

    static /* synthetic */ int h(d dVar) {
        int i = dVar.aPN;
        dVar.aPN = i + 1;
        return i;
    }

    public d(BdPageContext<?> bdPageContext, boolean z, a aVar) {
        super(bdPageContext);
        this.mLiveId = null;
        this.aPO = 1.0f;
        this.mHandler = new Handler();
        this.aPP = null;
        this.aPQ = false;
        this.aPR = false;
        this.aPT = 0;
        this.aPU = false;
        this.aPX = new b.a() { // from class: com.baidu.live.im.d.1
        };
        this.aPY = new Runnable() { // from class: com.baidu.live.im.d.11
            @Override // java.lang.Runnable
            public void run() {
                int i = d.this.aPN * d.this.aPL;
                if (i >= d.this.aPK.size()) {
                    d.this.BX();
                } else if (d.this.aPN >= d.this.aPM - 1) {
                    if (d.this.aPN != d.this.aPM - 1) {
                        d.this.BX();
                        return;
                    }
                    ArrayList arrayList = new ArrayList(d.this.aPK);
                    d.this.A(d.this.b(arrayList.subList(i, arrayList.size()), true));
                    d.h(d.this);
                    d.this.BX();
                } else {
                    ArrayList arrayList2 = new ArrayList(d.this.aPK);
                    if (d.this.aPL + i <= arrayList2.size()) {
                        d.this.A(d.this.b(arrayList2.subList(i, d.this.aPL + i), true));
                        d.h(d.this);
                        d.this.mHandler.postDelayed(d.this.aPY, 250L);
                        return;
                    }
                    d.this.A(d.this.b(arrayList2.subList(i, arrayList2.size()), true));
                    d.h(d.this);
                    d.this.BX();
                }
            }
        };
        this.aPZ = new Runnable() { // from class: com.baidu.live.im.d.12
            @Override // java.lang.Runnable
            public void run() {
                d.this.Cb();
            }
        };
        this.aQa = new CustomMessageListener(MessageConfig.SOCKET_RECEIVE_MSG) { // from class: com.baidu.live.im.d.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.BU();
            }
        };
        this.aQb = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.live.im.d.14
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
                        if (d.this.aPH != null) {
                            d.this.aPH.k(aVar2);
                            d.this.aPH.d(d.this.mMsgList, true);
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
                        if (d.this.aPH != null) {
                            d.this.aPH.k(aVar3);
                            d.this.aPH.d(d.this.mMsgList, true);
                        }
                    }
                }
            }
        };
        this.aQc = new Runnable() { // from class: com.baidu.live.im.d.15
            @Override // java.lang.Runnable
            public void run() {
                if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().getLastReceDataTime() > 35000) {
                    d.this.BT();
                }
                d.this.BS();
            }
        };
        this.aQd = new HttpMessageListener(1021013) { // from class: com.baidu.live.im.d.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    boolean z2 = false;
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        int error = httpResponsedMessage.getError();
                        if (com.baidu.live.v.a.Ge().aWF.ayB == 1) {
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
                    if (!z2 && d.this.aPH != null) {
                        d.this.aPH.Cc();
                    }
                }
            }
        };
        this.aQe = new HttpMessageListener(1021015) { // from class: com.baidu.live.im.d.17
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
                            if (!d.this.aPU) {
                                d.this.c(jVar.aEV, jVar.giftName);
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                        }
                        if (d.this.aPU) {
                            d.this.a(jVar.giftId, jVar.aEV, jVar.aEZ, z2, jVar.aFa);
                        }
                    }
                }
            }
        };
        this.aQf = new HttpMessageListener(1021014) { // from class: com.baidu.live.im.d.18
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
                            if (!d.this.aPU) {
                                d.this.c(pVar.aEV, pVar.giftName);
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                        }
                        if (d.this.aPU) {
                            d.this.a(pVar.giftId, pVar.aEV, pVar.aEZ, z2, pVar.aFa);
                        }
                    }
                }
            }
        };
        this.aQg = new HttpMessageListener(1021012) { // from class: com.baidu.live.im.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                d.this.a((ResponsedMessage<?>) httpResponsedMessage, false);
            }
        };
        this.aQh = new NetMessageListener(1021050, 601008) { // from class: com.baidu.live.im.d.3
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                JSONObject jSONObject;
                AlaGetLiveStatusHttpResponseMessage alaGetLiveStatusHttpResponseMessage = responsedMessage instanceof AlaGetLiveStatusHttpResponseMessage ? (AlaGetLiveStatusHttpResponseMessage) responsedMessage : null;
                if (alaGetLiveStatusHttpResponseMessage != null) {
                    try {
                        jSONObject = new JSONObject(alaGetLiveStatusHttpResponseMessage.aWx);
                    } catch (JSONException e) {
                        jSONObject = null;
                    }
                    if (jSONObject != null) {
                        if (!"backstage_live".equals(jSONObject.optString("content_type"))) {
                            d.this.a(alaGetLiveStatusHttpResponseMessage.aWx, jSONObject, 12, false);
                            return;
                        }
                        String optString = jSONObject.optString("backstage_type");
                        if (!TextUtils.isEmpty(optString) && !optString.equals(d.this.aPP)) {
                            d.this.a(alaGetLiveStatusHttpResponseMessage.aWx, jSONObject, 13, true);
                            d.this.aPP = optString;
                        }
                    }
                }
            }
        };
        this.count = 1L;
        this.aQi = new CustomMessageListener(2913192) { // from class: com.baidu.live.im.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText banlstn sd=" + d.this.aJj);
                if (d.this.aJj != null) {
                    if (d.this.aJj.mLiveInfo.getUserID() == Long.valueOf(TbadkCoreApplication.getCurrentAccount()).longValue()) {
                        Log.i("i", "@@@ localText banlstn own");
                        if (d.this.aJj.avj != null && d.this.aJj.mLiveInfo != null) {
                            Log.i("i", "@@@ localText banlstn own sdreq");
                            d.this.g(d.this.aJj.avj.userId, d.this.aJj.mLiveInfo.live_id);
                            return;
                        }
                        return;
                    }
                    Log.i("i", "@@@ localText banlstn oth");
                    if (d.this.aJj.avC != null && d.this.aJj.mLiveInfo != null) {
                        Log.i("i", "@@@ localText banlstn oth sdreq");
                        d.this.g(d.this.aJj.avC.userId, d.this.aJj.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.aQj = new CustomMessageListener(2913185) { // from class: com.baidu.live.im.d.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.aPU && customResponsedMessage != null && (customResponsedMessage.getData() instanceof h)) {
                    h hVar = (h) customResponsedMessage.getData();
                    com.baidu.live.im.data.a b = d.this.b(hVar.giftId, hVar.count + "", hVar.giftName, 0L, hVar.aRL);
                    if (b != null) {
                        double e = d.this.e(b);
                        b.setMsgId(0L);
                        b.setRecordId(0L);
                        com.baidu.live.data.a DB = b.DB();
                        if (DB != null && !StringUtils.isNull(DB.userId) && !StringUtils.isNull(hVar.giftId)) {
                            String str = DB.userId;
                            String nameShow = DB.getNameShow();
                            String str2 = str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + hVar.giftId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + nameShow;
                            if (d.this.aPW == null) {
                                d.this.aPW = new HashMap();
                            }
                            hVar.aRH = b;
                            hVar.userId = str;
                            hVar.userName = nameShow;
                            hVar.aRK = e;
                            if (!d.this.aPW.containsKey(str2)) {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Long.valueOf(hVar.aEZ), hVar);
                                d.this.aPW.put(str2, hashMap);
                                return;
                            }
                            ((HashMap) d.this.aPW.get(str2)).put(Long.valueOf(hVar.aEZ), hVar);
                        }
                    }
                }
            }
        };
        this.aQk = new CustomMessageListener(2913184) { // from class: com.baidu.live.im.d.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                    i iVar = (i) customResponsedMessage.getData();
                    if (iVar.aRP > 0) {
                        HashMap hashMap = (HashMap) d.this.aPV.get(iVar.aJD);
                        if (hashMap != null && !hashMap.isEmpty()) {
                            h hVar = (h) hashMap.remove(Long.valueOf(iVar.aRP));
                            if (hVar != null) {
                                hVar.aRN = true;
                                hVar.aRH.ai(hVar.count);
                                hVar.aRH.i(hVar.aRK);
                                hVar.aRH.aj(hVar.aRJ);
                                d.this.a(-1, hVar.aRH);
                                if (d.this.aPH != null) {
                                    d.this.aPH.d(d.this.mMsgList, true);
                                }
                            }
                            if (hashMap.isEmpty()) {
                                d.this.aPV.remove(iVar.aJD);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    HashMap hashMap2 = (HashMap) d.this.aPW.get(iVar.aJD);
                    if (hashMap2 != null && !hashMap2.isEmpty()) {
                        h hVar2 = (h) hashMap2.get(Long.valueOf(iVar.aRR));
                        if (hVar2 != null) {
                            if (hVar2.aRM != 0) {
                                hVar2.aRN = true;
                                return;
                            }
                            hashMap2.remove(Long.valueOf(iVar.aRR));
                            hVar2.aRH.ai(hVar2.count);
                            hVar2.aRH.i(hVar2.aRK);
                            hVar2.aRH.aj(hVar2.aRJ);
                            d.this.a(-1, hVar2.aRH);
                            if (d.this.aPH != null) {
                                d.this.aPH.d(d.this.mMsgList, true);
                            }
                            long j = hVar2.aRI;
                            if (j > 0) {
                                d.this.c(j, hVar2.giftName);
                            }
                        }
                        if (hashMap2.isEmpty()) {
                            d.this.aPW.remove(iVar.aJD);
                        }
                    }
                }
            }
        };
        this.aQl = new CustomMessageListener(2913183) { // from class: com.baidu.live.im.d.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                    i iVar = (i) customResponsedMessage.getData();
                    if (iVar.aRP == 0) {
                        HashMap hashMap = (HashMap) d.this.aPW.get(iVar.aJD);
                        if (hashMap != null && !hashMap.isEmpty()) {
                            h hVar = (h) hashMap.get(Long.valueOf(iVar.aRR));
                            h hVar2 = (h) hashMap.get(Long.valueOf(iVar.aRU));
                            if (hVar != null && hVar2 != null) {
                                hashMap.remove(Long.valueOf(iVar.aRU));
                                hVar.count += hVar2.count;
                                hVar.aRJ += hVar2.aRJ;
                                hVar.aRI += hVar2.aRI;
                                hVar.aRM += hVar2.aRM;
                                if (hVar.aRK != hVar2.aRK) {
                                    hVar.aRK = 0.0d;
                                }
                                hVar.aRO.add(Long.valueOf(hVar2.aEZ));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    HashMap hashMap2 = (HashMap) d.this.aPV.get(iVar.aJD);
                    if (hashMap2 != null && !hashMap2.isEmpty()) {
                        h hVar3 = (h) hashMap2.get(Long.valueOf(iVar.aRP));
                        h hVar4 = (h) hashMap2.remove(Long.valueOf(iVar.aRS));
                        if (hVar3 != null && hVar4 != null) {
                            hVar3.count += hVar4.count;
                            hVar3.aRJ += hVar4.aRJ;
                            if (hVar3.aRK != hVar4.aRK) {
                                hVar3.aRK = 0.0d;
                            }
                        }
                    }
                }
            }
        };
        this.aQm = new CustomMessageListener(2913195) { // from class: com.baidu.live.im.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                HashMap hashMap;
                h hVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                    i iVar = (i) customResponsedMessage.getData();
                    if (iVar.aRP != 0 && (hashMap = (HashMap) d.this.aPV.get(iVar.aJD)) != null && !hashMap.isEmpty() && (hVar = (h) hashMap.get(Long.valueOf(iVar.aRP))) != null) {
                        hVar.count = iVar.aRV;
                        hVar.aRJ = iVar.aRW;
                    }
                }
            }
        };
        this.aQn = new HttpMessageListener(1021194) { // from class: com.baidu.live.im.d.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                d.this.aPQ = false;
                Log.i("i", "@@@ localText gtibslist 1");
                d.this.mHandler.removeCallbacks(d.this.aPZ);
                if (httpResponsedMessage != null) {
                    if (httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.im.message.c) && ((com.baidu.live.im.message.c) httpResponsedMessage.getOrginalMessage()).am(System.currentTimeMillis())) {
                        Log.i("i", "@@@ localText gtibslist out");
                        d.this.aPR = false;
                        return;
                    }
                    Log.i("i", "@@@ localText gtibslist ta=" + d.this.aPR);
                    if (d.this.aPR) {
                        d.this.aPR = false;
                    } else if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        Log.i("i", "@@@ localText gtibslist err he=" + httpResponsedMessage.hasError() + ", err=" + httpResponsedMessage.getError());
                        ImForbiddenStateData imForbiddenStateData = new ImForbiddenStateData();
                        imForbiddenStateData.errno = httpResponsedMessage.getError();
                        imForbiddenStateData.errMsg = httpResponsedMessage.getErrorString();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, imForbiddenStateData));
                    } else {
                        Log.i("i", "@@@ localText gtibslist suc");
                        if (httpResponsedMessage instanceof AlaForbiddenWordsStateResponseMessage) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, ((AlaForbiddenWordsStateResponseMessage) httpResponsedMessage).aTJ));
                        }
                    }
                }
            }
        };
        this.aPD = com.baidu.live.v.a.Ge().aWF.ayC;
        this.aPE = com.baidu.live.v.a.Ge().aWF.ayD;
        this.aPF = com.baidu.live.v.a.Ge().aWF.ayE;
        this.mPageContext = bdPageContext;
        this.aPG = z;
        this.aPH = aVar;
        this.mMsgList = new LinkedList<>();
        this.aPV = new LinkedHashMap<>();
        this.aPW = new HashMap<>();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913182, Object.class);
        if (runTask != null && runTask.getData() != null) {
            this.aPU = true;
        }
        MessageManager.getInstance().registerTask(BR());
        com.baidu.live.tieba.f.a.a.a(1021050, "alaim/gmsg/getLiveStatus", AlaGetLiveStatusHttpResponseMessage.class, false, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021012, "alaim/gmsg/getGroupMsg", ALAGroupHttpResponseMessage.class, false, true, true, true);
        Ca();
        registerListener(this.aQn);
    }

    public void e(com.baidu.live.data.q qVar) {
        this.aJj = qVar;
        if (this.aJj != null && this.aJj.mLiveInfo != null) {
            this.aPS = this.aJj.mLiveInfo.audience_count - this.aJj.mLiveInfo.ai_robot_num;
        }
    }

    private HttpMessageTask BR() {
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
    public void BS() {
        this.mHandler.postDelayed(this.aQc, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BT() {
        sendMessage(new com.baidu.live.im.message.b(JavaTypesHelper.toInt(this.mGroupId, 0), getLastMid()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BU() {
        this.mHandler.removeCallbacks(this.aQc);
    }

    public void c(long j, String str) {
        if (j == 0) {
            j = 1;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.mPageContext.getString(a.i.sdk_gift);
        }
        com.baidu.live.im.data.a a2 = a((short) 27, String.format(this.mPageContext.getString(a.i.sdk_send_gift_fail), Long.valueOf(j), str), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), this.avH);
        if (a2 != null) {
            a(-1, a2);
            if (this.aPH != null) {
                this.aPH.k(a2);
                this.aPH.d(this.mMsgList, true);
            }
        }
    }

    public com.baidu.live.im.data.a b(String str, String str2, String str3, long j, boolean z) {
        return a((short) 24, c(str, TextUtils.isEmpty(str2) ? "1" : str2, TextUtils.isEmpty(str3) ? this.mPageContext.getString(a.i.sdk_gift) : str3, j, z).toString(), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), this.avH);
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
        if (this.aPH != null) {
            this.aPH.k(aVar);
            if (z) {
                this.aPH.d(this.mMsgList, true);
            }
        }
    }

    protected void a(ResponsedMessage<?> responsedMessage, boolean z) {
        boolean z2;
        long j;
        List<com.baidu.live.im.data.a> list;
        if (responsedMessage instanceof ALAGroupHttpResponseMessage) {
            List<com.baidu.live.im.data.a> DR = ((ALAGroupHttpResponseMessage) responsedMessage).DR();
            j = ((ALAGroupHttpResponseMessage) responsedMessage).getGroupId();
            list = DR;
            z2 = ((ALAGroupHttpResponseMessage) responsedMessage).DQ();
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
                D(list);
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
            if (this.aPM != 0) {
                int i2 = this.aPN * this.aPL;
                ArrayList arrayList = new ArrayList(this.aPK);
                d(0, arrayList.subList(i2, arrayList.size()));
                BX();
            }
            if (list.size() > 0) {
                if (list.size() > 5 && z) {
                    B(list);
                } else {
                    A(a(list, z, z2));
                }
            }
        }
    }

    public void e(String str, String str2, String str3, String str4, String str5) {
        if (this.mMsgList != null) {
            this.mMsgList.clear();
        }
        if (this.aPV != null) {
            this.aPV.clear();
        }
        if (this.aPW != null) {
            this.aPW.clear();
        }
        this.mMsgList = new LinkedList<>();
        this.mGroupId = str;
        this.aPI = str2;
        this.aPJ = str3;
        this.mLiveId = str4;
        this.aPP = "0";
        this.mAppId = str5;
        MessageManager.getInstance().registerListener(this.aQg);
        MessageManager.getInstance().registerListener(this.aQh);
        MessageManager.getInstance().registerListener(this.aQa);
        MessageManager.getInstance().registerListener(this.aQd);
        MessageManager.getInstance().registerListener(this.aQb);
        MessageManager.getInstance().registerListener(this.aQe);
        MessageManager.getInstance().registerListener(this.aQf);
        MessageManager.getInstance().registerListener(this.aQj);
        MessageManager.getInstance().registerListener(this.aQk);
        MessageManager.getInstance().registerListener(this.aQl);
        MessageManager.getInstance().registerListener(this.aQm);
        MessageManager.getInstance().registerListener(this.aQi);
        if (BdSocketLinkService.isClose()) {
            BT();
            BdSocketLinkService.startService(true, "live start");
        }
        String str6 = com.baidu.live.v.a.Ge().aWF.awp;
        if (!TextUtils.isEmpty(str6)) {
            com.baidu.live.im.data.a BY = BY();
            BY.setMsgType(27);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("text", str6);
                jSONObject.put("content_type", "custom_live_notice");
                BY.setContent(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            a(-1, BY);
            if (this.aPH != null) {
                this.aPH.k(BY);
            }
        }
        String str7 = com.baidu.live.v.a.Ge().aWF.awq;
        if (!TextUtils.isEmpty(str7)) {
            com.baidu.live.im.data.a BY2 = BY();
            BY2.setMsgType(27);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("text", str7);
                jSONObject2.put("content_type", "custom_live_notice");
                BY2.setContent(jSONObject2.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            a(-1, BY2);
        }
        List<String> list = com.baidu.live.v.a.Ge().aWF.awo;
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
                    com.baidu.live.im.data.a BY3 = BY();
                    BY3.setMsgType(27);
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("text", str8);
                        jSONObject3.put("content_type", "custom_im_notice");
                        BY3.setContent(jSONObject3.toString());
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                    BY3.setLink(str9);
                    a(-1, BY3);
                    if (this.aPH != null) {
                        this.aPH.k(BY3);
                    }
                }
                i = i2 + 2;
            }
        }
        if (this.aJj != null && this.aJj.avP != null && !StringUtils.isNull(this.aJj.avP.vP())) {
            com.baidu.live.im.data.a BY4 = BY();
            BY4.setMsgType(27);
            try {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("text", this.aJj.avP.vP());
                jSONObject4.put("content_type", "custom_live_notice");
                BY4.setContent(jSONObject4.toString());
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            this.mMsgList.add(BY4);
            if (this.aPH != null) {
                this.aPH.k(BY4);
            }
        }
        BV();
        if (this.mMsgList.size() > 0 && this.aPH != null) {
            this.aPH.d(this.mMsgList, true);
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGmsgGetLiveStatusUnabled()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.d.4
                @Override // java.lang.Runnable
                public void run() {
                    d.this.fm("enter");
                }
            }, 1000L);
        }
        BS();
        if (TbadkCoreApplication.getInst().isOther()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913146, this.mMsgList));
        }
    }

    private void BV() {
        if (BW()) {
            com.baidu.live.im.data.a BY = BY();
            BY.setMsgType(27);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("text", com.baidu.live.v.a.Ge().aWF.ayy.avs);
                jSONObject.put("content_type", "custom_im_notice_live_assistant");
                BY.setContent(jSONObject.toString());
                BY.setLink(com.baidu.live.v.a.Ge().aWF.ayy.avr);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mMsgList.add(BY);
            if (this.aPH != null) {
                this.aPH.k(BY);
            }
        }
    }

    private boolean BW() {
        return (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) || !TbadkCoreApplication.getCurrentAccount().equals(this.aPJ) || com.baidu.live.v.a.Ge().aWF == null || com.baidu.live.v.a.Ge().aWF.ayy == null || TextUtils.isEmpty(com.baidu.live.v.a.Ge().aWF.ayy.avs)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(List<com.baidu.live.im.data.a> list) {
        if (list != null && this.aPH != null) {
            this.aPH.d(this.mMsgList, true);
            for (com.baidu.live.im.data.a aVar : list) {
                this.aPH.k(aVar);
            }
        }
    }

    protected void B(List<com.baidu.live.im.data.a> list) {
        this.aPK = list;
        this.aPM = (int) ((this.aPO * 2.0f) / 0.25f);
        this.aPN = 0;
        this.aPL = list.size() / this.aPM;
        if (this.aPL <= 0) {
            this.aPL = 1;
        }
        this.mHandler.removeCallbacks(this.aPY);
        this.mHandler.postDelayed(this.aPY, 250L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BX() {
        this.mHandler.removeCallbacks(this.aPY);
        this.aPN = 0;
        this.aPM = 0;
        this.aPL = 0;
        this.aPK = null;
    }

    protected List<com.baidu.live.im.data.a> b(List<com.baidu.live.im.data.a> list, boolean z) {
        return a(list, z, false);
    }

    protected List<com.baidu.live.im.data.a> a(List<com.baidu.live.im.data.a> list, boolean z, boolean z2) {
        for (com.baidu.live.im.data.a aVar : list) {
            if (aVar instanceof com.baidu.live.im.a) {
                ((com.baidu.live.im.a) aVar).fl(this.aPJ);
            }
        }
        if (z) {
            LinkedList linkedList = new LinkedList();
            for (com.baidu.live.im.data.a aVar2 : list) {
                if (aVar2.getMsgId() > getLastMid()) {
                    if (aVar2.getMsgType() == 24) {
                        if (!z2) {
                            e(aVar2);
                        }
                        List<com.baidu.live.im.data.a> j = j(aVar2);
                        b(j, -1);
                        linkedList.addAll(j);
                    } else {
                        a(-1, aVar2);
                        linkedList.add(aVar2);
                    }
                }
            }
            list = linkedList;
        } else {
            delRepeatMsg(this.mMsgList, list);
            c(z2, list);
            if (!z2) {
                C(list);
            }
            if (z2 && this.mMsgList.size() > 2) {
                b(list, 2);
            } else {
                b(list, -1);
            }
        }
        if (this.mMsgList.size() > com.baidu.live.v.a.Ge().aWF.ayn) {
            int i = (int) (com.baidu.live.v.a.Ge().aWF.ayn * 0.7d);
            if (i <= 0) {
                i = 1;
            }
            while (this.mMsgList.size() > i) {
                this.mMsgList.removeFirst();
            }
        }
        return list;
    }

    private void C(List<com.baidu.live.im.data.a> list) {
        if (list != null && !list.isEmpty()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    com.baidu.live.im.data.a aVar = list.get(i2);
                    if (aVar.getMsgType() == 24) {
                        e(aVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double e(com.baidu.live.im.data.a aVar) {
        double d;
        JSONException e;
        JSONObject jSONObject;
        List<AlaLiveMarkData> list;
        boolean z = false;
        com.baidu.live.data.a DB = aVar.DB();
        if (DB != null && (list = DB.aux) != null && !list.isEmpty()) {
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
            d = com.baidu.live.v.d.Gl().f(z, jSONObject.optString(LogConfig.LOG_GIFT_ID));
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

    private void c(boolean z, List<com.baidu.live.im.data.a> list) {
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
                        if (!TextUtils.isEmpty(optString) && (optString.equals("challenge_direct_start") || optString.equals("challenge_direct_matched") || optString.equals("challenge_random_start") || optString.equals("challenge_random_matched") || optString.equals("live_net_status") || optString.equals("send_redpacket") || optString.equals("start_grab_redpacket") || optString.equals("guard_seat") || optString.equals("challenge_mvp") || optString.equals("official_notice") || optString.equals("privilege_award_royal_success"))) {
                            it.remove();
                        }
                    } catch (JSONException e) {
                    }
                }
            }
        }
    }

    private void D(List<com.baidu.live.im.data.a> list) {
        if (list != null && !list.isEmpty()) {
            for (com.baidu.live.im.data.a aVar : list) {
                aVar.bI(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.live.im.data.a aVar) {
        if (this.aPS < this.aPD) {
            if (i >= 0) {
                this.mMsgList.add(i, aVar);
            } else {
                this.mMsgList.addLast(aVar);
            }
        } else if (this.aPS >= this.aPD && this.aPS < this.aPE) {
            if (i(aVar)) {
                if (!this.mMsgList.isEmpty() && i(this.mMsgList.getLast())) {
                    this.mMsgList.set(this.mMsgList.size() - 1, aVar);
                } else {
                    this.mMsgList.addLast(aVar);
                }
            } else if (i >= 0) {
                this.mMsgList.add(i, aVar);
            } else {
                this.mMsgList.addLast(aVar);
            }
        } else if (this.aPS >= this.aPE && this.aPS < this.aPF) {
            if (g(aVar)) {
                if (!this.mMsgList.isEmpty() && g(this.mMsgList.getLast())) {
                    this.mMsgList.set(this.mMsgList.size() - 1, aVar);
                } else {
                    this.mMsgList.addLast(aVar);
                }
            } else if (i >= 0) {
                this.mMsgList.add(i, aVar);
            } else {
                this.mMsgList.addLast(aVar);
            }
        } else if (this.aPS >= this.aPF) {
            if (!g(aVar)) {
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

    private int f(com.baidu.live.im.data.a aVar) {
        String str;
        JSONObject jSONObject;
        this.aPT = 0;
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
                if (com.baidu.live.entereffect.a.wD().a(aVar)) {
                    this.aPT = 2;
                } else {
                    this.aPT = 1;
                }
            } else {
                this.aPT = 0;
            }
        }
        return this.aPT;
    }

    private boolean g(com.baidu.live.im.data.a aVar) {
        return i(aVar) || h(aVar);
    }

    private boolean h(com.baidu.live.im.data.a aVar) {
        return f(aVar) == 2;
    }

    private boolean i(com.baidu.live.im.data.a aVar) {
        return f(aVar) == 1;
    }

    private void delRepeatMsg(List<com.baidu.live.im.data.a> list, List<com.baidu.live.im.data.a> list2) {
        if (list != null && list2 != null) {
            int size = list.size();
            int size2 = list2.size();
            if (size2 != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = size2 - 1; i >= 0 && i >= 0; i--) {
                    com.baidu.live.im.data.a aVar = list2.get(i);
                    if (aVar != null && aVar.DB() != null && !TextUtils.isEmpty(aVar.DB().userId) && aVar.DB().userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        int i2 = size - 1;
                        while (true) {
                            if (i2 >= 0 && i2 >= 0) {
                                com.baidu.live.im.data.a aVar2 = list.get(i2);
                                if (aVar2 != null && aVar2.DB() != null && !TextUtils.isEmpty(aVar2.DB().userId) && aVar2.DB().userId.equals(TbadkCoreApplication.getCurrentAccount()) && aVar.getRecordId() == aVar2.getRecordId()) {
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
            if (!ListUtils.isEmpty(aVar.DD()) && !aVar.DD().contains(Long.valueOf(currentAccountId))) {
                linkedList.add(aVar);
            } else {
                boolean z2 = aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                if (z2 && aVar.getMsgType() == 1 && !ListUtils.isEmpty(aVar.DB().aux) && this.avH == null) {
                    this.avH = aVar.DB().aux;
                }
                if (z2 && aVar.getMsgType() != 125 && aVar.getMsgType() != 24 && aVar.getMsgType() != 13 && aVar.getMsgType() != 28) {
                    if (aVar.getMsgType() != 1 || !z) {
                        linkedList.add(aVar);
                    }
                } else if (this.aPU && z2 && aVar.getMsgType() == 24) {
                    linkedList.add(aVar);
                } else if (aVar.getMsgType() == 125) {
                    try {
                        if (!"1".equals(new JSONObject(aVar.getContent()).optString("is_first"))) {
                            linkedList.add(aVar);
                            if (this.aPH != null) {
                                this.aPH.k(aVar);
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
                    if ("enter_live".equals(str) && this.aPS < this.aPF) {
                        if (com.baidu.live.entereffect.a.wD().a(aVar)) {
                        }
                    } else if ("close_live".equals(str)) {
                        linkedList.add(aVar);
                        if (this.aPH != null) {
                            this.aPH.k(aVar);
                        }
                    } else if ("task".equals(str)) {
                        linkedList.add(aVar);
                        if (this.aPH != null) {
                            this.aPH.k(aVar);
                        }
                    } else if ("live_achievement".equals(str)) {
                        linkedList.add(aVar);
                        if (this.aPH != null) {
                            this.aPH.k(aVar);
                        }
                    } else if ("ss_hot_live".equals(str)) {
                        linkedList.add(aVar);
                        if (this.aPH != null) {
                            this.aPH.k(aVar);
                        }
                    } else if ("challenge_direct_new".equals(str)) {
                        linkedList.add(aVar);
                        if (this.aPH != null) {
                            this.aPH.k(aVar);
                        }
                    } else if ("update_liveinfo".equals(str)) {
                        linkedList.add(aVar);
                        if (this.aPH != null) {
                            this.aPH.k(aVar);
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
                        if (z2 && !ListUtils.isEmpty(aVar.DB().aux)) {
                            this.avH = aVar.DB().aux;
                            if (this.aJj != null) {
                                this.aJj.avH = this.avH;
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
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str, "wish_list_finish") || TextUtils.equals(str, "wish_list_success")) {
                            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                                linkedList.add(aVar);
                            }
                        } else if ("ui_event".equals(str)) {
                            linkedList.add(aVar);
                            if (this.aPH != null) {
                                this.aPH.k(aVar);
                            }
                        } else if ("first_recharge_success".equals(str)) {
                            linkedList.add(aVar);
                            if (this.aPH != null) {
                                this.aPH.k(aVar);
                            }
                        } else if ("privilege_award_success".equals(str)) {
                            linkedList.add(aVar);
                            if (this.aPH != null) {
                                this.aPH.k(aVar);
                            }
                        } else if ("need_update_live_mark_info".equals(str)) {
                            linkedList.add(aVar);
                            if (this.aPH != null) {
                                this.aPH.k(aVar);
                            }
                        } else if ("official_notice".equals(str)) {
                            linkedList.add(aVar);
                            if (this.aPH != null && !z) {
                                this.aPH.k(aVar);
                            }
                        } else if (TextUtils.equals(str, "privilege_award_royal_success")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (!TextUtils.equals(str, "add_tags_to_anchor")) {
                            linkedList.add(aVar);
                        }
                    }
                } else if (aVar.getMsgType() == 12) {
                    linkedList.add(aVar);
                    if (this.aPH != null) {
                        this.aPH.k(aVar);
                    }
                    fm("push");
                }
            }
        }
        if (linkedList.size() > 0) {
            list.removeAll(linkedList);
        }
    }

    protected com.baidu.live.im.data.a a(short s, String str, boolean z, boolean z2, int i, List<AlaLiveMarkData> list) {
        long j = 0;
        com.baidu.live.im.data.a BY = BY();
        if (BY == null) {
            return null;
        }
        BY.setMsgType(s);
        BY.setContent(str);
        long ah = q.ah(getLastMid());
        BY.setMsgId(ah);
        BY.setRecordId(ah);
        BY.setTime(System.currentTimeMillis() / 1000);
        com.baidu.live.data.a aVar = new com.baidu.live.data.a();
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            aVar.userName = TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow();
        }
        aVar.userId = TbadkCoreApplication.getCurrentAccount();
        aVar.portrait = TbadkCoreApplication.getCurrentPortrait();
        aVar.level_id = i;
        aVar.auu = z;
        aVar.auv = z2;
        if (list != null) {
            aVar.aux = new ArrayList(list);
        }
        BY.e(aVar);
        try {
            j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        } catch (Exception e) {
        }
        BY.setUserId(j);
        return BY;
    }

    private long getLastMid() {
        if (this.mMsgList == null || this.mMsgList.size() <= 0) {
            return JavaTypesHelper.toLong(this.aPI, 1L);
        }
        return this.mMsgList.get(this.mMsgList.size() - 1).getMsgId();
    }

    protected com.baidu.live.im.data.a BY() {
        com.baidu.live.im.a aVar = new com.baidu.live.im.a();
        aVar.setBornTime(System.currentTimeMillis());
        if (TextUtils.isEmpty(this.mGroupId)) {
            return null;
        }
        aVar.fl(this.aPJ);
        return aVar;
    }

    public void E(List<AlaLiveMarkData> list) {
        this.avH = list;
    }

    public void fm(String str) {
        com.baidu.live.message.c cVar = new com.baidu.live.message.c(JavaTypesHelper.toLong(this.mLiveId, 0L), str);
        cVar.setParams();
        sendMessage(cVar);
    }

    public void fn(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.aPP)) {
            fm("getliveinfo");
        }
    }

    private List<com.baidu.live.im.data.a> j(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        int optInt;
        boolean xt;
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
            com.baidu.live.gift.g eO = v.eO(jSONObject.optString(LogConfig.LOG_GIFT_ID));
            xt = eO != null ? eO.xt() : false;
        } catch (JSONException e) {
            arrayList.add(aVar2);
        }
        if (optInt == 1 || xt) {
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
            aVar3.fl(aVar2.BP());
            aVar3.setBornTime(aVar2.getBornTime());
            aVar3.setTime(aVar2.getTime());
            aVar3.setUserId(aVar2.getUserId());
            aVar3.setToUserId(aVar2.getToUserId());
            aVar3.f(aVar2.DC());
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
            aVar3.e(aVar2.DB());
            aVar3.setSt_type(aVar2.getSt_type());
            arrayList.add(aVar3);
        }
        return arrayList;
    }

    public void a(int i, String str, com.baidu.live.data.a aVar) {
        com.baidu.live.im.data.a BY = BY();
        if (BY != null) {
            BY.setMsgType(i);
            BY.setContent(str);
            BY.e(aVar);
            a(-1, BY);
            if (this.aPH != null) {
                this.aPH.d(this.mMsgList, true);
                this.aPH.k(BY);
            }
        }
    }

    private void b(List<com.baidu.live.im.data.a> list, int i) {
        JSONObject jSONObject;
        int i2;
        if (this.aPU) {
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
                            com.baidu.live.data.a DB = aVar.DB();
                            if (DB == null || StringUtils.isNull(DB.userId) || StringUtils.isNull(optString)) {
                                if (i >= 0) {
                                    a(i + i4, aVar);
                                } else {
                                    a(-1, aVar);
                                }
                            } else {
                                String str = DB.userId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + optString + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + DB.getNameShow();
                                if (this.aPV == null) {
                                    this.aPV = new LinkedHashMap<>();
                                }
                                long j = JavaTypesHelper.toLong(jSONObject.optString("gift_count"), 0L);
                                double optDouble = jSONObject.optDouble("gift_rate", 0.0d);
                                long j2 = JavaTypesHelper.toLong(jSONObject.optString("charm_value"), 0L);
                                h hVar = new h();
                                hVar.aRH = aVar;
                                hVar.count = j;
                                hVar.aRK = optDouble;
                                hVar.aRJ = j2;
                                if (com.baidu.live.v.a.Ge().aWF == null) {
                                    i2 = 100;
                                } else {
                                    i2 = com.baidu.live.v.a.Ge().aWF.ays * 2;
                                }
                                Iterator<String> it = this.aPV.keySet().iterator();
                                int i5 = 0;
                                while (it.hasNext()) {
                                    String next = it.next();
                                    if (this.aPV.get(next) == null || this.aPV.get(next).isEmpty()) {
                                        it.remove();
                                    } else {
                                        HashMap<Long, h> hashMap = this.aPV.get(next);
                                        Iterator<Long> it2 = hashMap.keySet().iterator();
                                        while (it2.hasNext()) {
                                            long longValue = it2.next().longValue();
                                            if (hashMap.get(Long.valueOf(longValue)) == null || hashMap.get(Long.valueOf(longValue)).aRN) {
                                                it2.remove();
                                            }
                                        }
                                        if (this.aPV.get(next) == null || this.aPV.get(next).isEmpty()) {
                                            it.remove();
                                        } else {
                                            i5 = hashMap.size() + i5;
                                        }
                                    }
                                }
                                if (i5 > i2) {
                                    int i6 = i5 - ((int) (i2 * 0.7d));
                                    Iterator<String> it3 = this.aPV.keySet().iterator();
                                    while (true) {
                                        int i7 = i6;
                                        if (!it3.hasNext()) {
                                            break;
                                        }
                                        i6 = i7 - this.aPV.get(it3.next()).size();
                                        it3.remove();
                                        if (i6 <= 0) {
                                            break;
                                        }
                                    }
                                }
                                if (!this.aPV.containsKey(str)) {
                                    HashMap<Long, h> hashMap2 = new HashMap<>();
                                    hashMap2.put(Long.valueOf(aVar.getMsgId()), hVar);
                                    this.aPV.put(str, hashMap2);
                                } else {
                                    this.aPV.get(str).put(Long.valueOf(aVar.getMsgId()), hVar);
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
            HashMap<Long, h> hashMap = this.aPW.get(str3);
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
                            if (next.aRO.contains(l)) {
                                hVar = next;
                                break;
                            }
                        }
                    }
                    if (hVar != null) {
                        long longValue = map.get(l).longValue();
                        if (z) {
                            hVar.aRI += longValue;
                        }
                        hVar.aRM -= longValue;
                        if (hVar.aRN && hVar.aRM == 0) {
                            hashMap.remove(Long.valueOf(hVar.aEZ));
                            hVar.aRH.ai(hVar.count);
                            hVar.aRH.i(hVar.aRK);
                            hVar.aRH.aj(hVar.aRJ);
                            a(-1, hVar.aRH);
                            if (this.aPH != null) {
                                this.aPH.d(this.mMsgList, true);
                            }
                            long j3 = hVar.aRI;
                            if (j3 > 0) {
                                c(j3, hVar.giftName);
                            }
                        }
                    }
                }
                if (hashMap.isEmpty()) {
                    this.aPW.remove(str3);
                }
            }
        }
    }

    public void BZ() {
        this.mGroupId = null;
        this.aPI = null;
        this.mLiveId = null;
        this.aPP = "0";
        this.mAppId = null;
        this.aPQ = false;
        this.aPR = false;
        MessageManager.getInstance().unRegisterListener(this.aQh);
        MessageManager.getInstance().unRegisterListener(this.aQg);
        MessageManager.getInstance().unRegisterListener(this.aQa);
        MessageManager.getInstance().unRegisterListener(this.aQd);
        MessageManager.getInstance().unRegisterListener(this.aQe);
        MessageManager.getInstance().unRegisterListener(this.aQf);
        MessageManager.getInstance().unRegisterListener(this.aQb);
        MessageManager.getInstance().unRegisterListener(this.aQj);
        MessageManager.getInstance().unRegisterListener(this.aQk);
        MessageManager.getInstance().unRegisterListener(this.aQl);
        MessageManager.getInstance().unRegisterListener(this.aQm);
        MessageManager.getInstance().unRegisterListener(this.aQi);
        this.mHandler.removeCallbacks(this.aPZ);
        this.mHandler.removeCallbacks(this.aPY);
        this.mHandler.removeCallbacks(this.aQc);
        if (this.mMsgList != null) {
            this.mMsgList.clear();
        }
        this.mMsgList = null;
        if (this.aPV != null) {
            this.aPV.clear();
        }
        if (this.aPW != null) {
            this.aPW.clear();
        }
    }

    private void Ca() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021194, TbConfig.SERVER_ADDRESS + "ala/live/checkImBan");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaForbiddenWordsStateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(ImSendMsgData imSendMsgData, boolean z, boolean z2, int i, String str, String[] strArr) {
        Log.i("i", "@@@ localText limmdl sm");
        if (!TbadkCoreApplication.isLogin()) {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.sdk_not_login);
        } else if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow())) {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.sdk_username_empty);
        } else {
            Log.i("i", "@@@ localText limmdl sm 1");
            String str2 = imSendMsgData.text;
            short s = imSendMsgData.msgType;
            com.baidu.live.im.data.a a2 = a(s, str2, z, z2, i, this.avH);
            if (s == 126) {
                a2.cv(imSendMsgData.barrageType);
                a2.fr(imSendMsgData.barrageId);
                a2.a(imSendMsgData.barrageCardInfo);
            }
            Log.i("i", "@@@ localText limmdl sm cm=" + a2);
            if (a2 != null) {
                a2.k(strArr);
                a(-1, a2);
                if (this.aPH != null) {
                    Log.i("i", "@@@ localText limmdl sm recv");
                    this.aPH.k(a2);
                    this.aPH.d(this.mMsgList, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913043));
                com.baidu.live.im.message.a aVar = new com.baidu.live.im.message.a(str2, s, JavaTypesHelper.toInt(this.mGroupId, 0), this.mAppId);
                if (this.aJj != null && this.aJj.mLiveInfo != null) {
                    aVar.fs(this.aJj.mLiveInfo.live_id + "");
                    aVar.ft(this.aJj.mLiveInfo.room_id + "");
                } else {
                    aVar.fs("");
                    aVar.ft("");
                }
                aVar.setOtherParams(str);
                aVar.ak(imSendMsgData.price);
                aVar.cv(imSendMsgData.barrageType);
                aVar.fr(imSendMsgData.barrageId);
                aVar.a(imSendMsgData.barrageCardInfo);
                aVar.k(strArr);
                aVar.bJ(imSendMsgData.isQuick);
                sendMessage(aVar);
            }
        }
    }

    public void g(long j, long j2) {
        Log.i("i", "@@@ localText limm sdreq ud=" + j + ",lvd=" + j2 + ",iibr=" + this.aPQ);
        if (!this.aPQ) {
            this.aPQ = true;
            Log.i("i", "@@@ localText limm sdreq go");
            com.baidu.live.im.message.c cVar = new com.baidu.live.im.message.c(1021194);
            cVar.addParam("user_id", j);
            cVar.addParam("live_id", j2);
            cVar.al(System.currentTimeMillis());
            sendMessage(cVar);
            this.mHandler.postDelayed(this.aPZ, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cb() {
        Log.i("i", "@@@ localText limm sdreq out");
        this.aPQ = false;
        this.aPR = true;
        ImForbiddenStateData imForbiddenStateData = new ImForbiddenStateData();
        imForbiddenStateData.errno = -1;
        imForbiddenStateData.errMsg = this.mPageContext.getString(a.i.sdk_neterror);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, imForbiddenStateData));
    }
}
