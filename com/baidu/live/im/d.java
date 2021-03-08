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
import com.baidu.live.data.ab;
import com.baidu.live.gift.GiftPackageConsumeHttpResponsedMessage;
import com.baidu.live.gift.ac;
import com.baidu.live.im.b;
import com.baidu.live.im.data.ImForbiddenStateData;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.message.ALAGroupCommitHttpResponsedMessage;
import com.baidu.live.im.message.ALAGroupHttpResponseMessage;
import com.baidu.live.im.message.AlaForbiddenWordsStateResponseMessage;
import com.baidu.live.im.message.AlaLocalIMCustomResponseMessage;
import com.baidu.live.im.message.AlaLuckBagSendHttpResponseMessage;
import com.baidu.live.message.AlaGetLiveStatusHttpResponseMessage;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
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
/* loaded from: classes10.dex */
public class d extends BdBaseModel {
    private ab aED;
    private CustomMessageListener aEM;
    private List<AlaLiveMarkData> aKk;
    private CustomMessageListener bgO;
    private HttpMessageListener bgW;
    public int blU;
    public int blV;
    public int blW;
    BdPageContext<?> blX;
    private boolean blY;
    private a blZ;
    private HttpMessageListener bmA;
    private CustomMessageListener bmB;
    private HttpMessageListener bmC;
    private HttpMessageListener bmD;
    private HttpMessageListener bmE;
    private NetMessageListener bmF;
    CustomMessageListener bmG;
    CustomMessageListener bmH;
    CustomMessageListener bmI;
    CustomMessageListener bmJ;
    CustomMessageListener bmK;
    private HttpMessageListener bmL;
    private String bma;
    private String bmb;
    private List<com.baidu.live.im.data.b> bmc;
    private int bmd;
    private int bme;
    private int bmf;
    private float bmg;
    private String bmh;
    private String bmi;
    private String bmj;
    private CustomMessageListener bmk;
    private boolean bml;
    private boolean bmm;
    private int bmn;
    private int bmo;
    private boolean bmq;
    private LinkedHashMap<String, HashMap<Long, h>> bmr;
    private HashMap<String, HashMap<Long, h>> bms;
    private b.a bmt;
    private Runnable bmu;
    private Runnable bmv;
    private CustomMessageListener bmw;
    private CustomMessageListener bmx;
    private Runnable bmy;
    private HttpMessageListener bmz;
    private long count;
    private String mAppId;
    private String mGroupId;
    private Handler mHandler;
    private String mLiveId;
    private LinkedList<com.baidu.live.im.data.b> mMsgList;
    private HttpMessageListener syncListener;

    /* loaded from: classes10.dex */
    public interface a {
        void JH();

        void d(List<com.baidu.live.im.data.b> list, boolean z);

        void t(com.baidu.live.im.data.b bVar);
    }

    static /* synthetic */ int h(d dVar) {
        int i = dVar.bmf;
        dVar.bmf = i + 1;
        return i;
    }

    public d(BdPageContext<?> bdPageContext, boolean z, a aVar) {
        super(bdPageContext);
        this.mLiveId = null;
        this.bmg = 1.0f;
        this.mHandler = new Handler();
        this.bmh = null;
        this.bmi = "1";
        this.bmj = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION;
        this.bml = false;
        this.bmm = false;
        this.bmo = 0;
        this.bmq = false;
        this.bmt = new b.a() { // from class: com.baidu.live.im.d.1
        };
        this.bmu = new Runnable() { // from class: com.baidu.live.im.d.12
            @Override // java.lang.Runnable
            public void run() {
                int i = d.this.bmf * d.this.bmd;
                if (i >= d.this.bmc.size()) {
                    d.this.JD();
                } else if (d.this.bmf >= d.this.bme - 1) {
                    if (d.this.bmf != d.this.bme - 1) {
                        d.this.JD();
                        return;
                    }
                    ArrayList arrayList = new ArrayList(d.this.bmc);
                    d.this.O(d.this.b(arrayList.subList(i, arrayList.size()), true));
                    d.h(d.this);
                    d.this.JD();
                } else {
                    ArrayList arrayList2 = new ArrayList(d.this.bmc);
                    if (d.this.bmd + i <= arrayList2.size()) {
                        d.this.O(d.this.b(arrayList2.subList(i, d.this.bmd + i), true));
                        d.h(d.this);
                        d.this.mHandler.postDelayed(d.this.bmu, 250L);
                        return;
                    }
                    d.this.O(d.this.b(arrayList2.subList(i, arrayList2.size()), true));
                    d.h(d.this);
                    d.this.JD();
                }
            }
        };
        this.bmv = new Runnable() { // from class: com.baidu.live.im.d.19
            @Override // java.lang.Runnable
            public void run() {
                d.this.JG();
            }
        };
        this.bgO = new CustomMessageListener(2913238) { // from class: com.baidu.live.im.d.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null) {
                    d.this.bmi = (String) customResponsedMessage.getData();
                }
            }
        };
        this.bmw = new CustomMessageListener(MessageConfig.SOCKET_RECEIVE_MSG) { // from class: com.baidu.live.im.d.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.Jx();
            }
        };
        this.bmx = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.live.im.d.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        com.baidu.live.im.a aVar2 = new com.baidu.live.im.a();
                        aVar2.setMsgType(27);
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("text", d.this.blX.getString(a.h.sdk_im_offline));
                            jSONObject.put("content_type", "custom_network_change");
                            aVar2.setContent(jSONObject.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        d.this.a(-1, aVar2);
                        if (d.this.blZ != null) {
                            d.this.blZ.t(aVar2);
                            d.this.blZ.d(d.this.mMsgList, true);
                        }
                    } else if (((NetWorkChangedMessage) customResponsedMessage).mLastNetState == 0 && BdNetTypeUtil.isNetWorkAvailable()) {
                        com.baidu.live.im.a aVar3 = new com.baidu.live.im.a();
                        aVar3.setMsgType(27);
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("text", d.this.blX.getString(a.h.sdk_im_online));
                            jSONObject2.put("content_type", "custom_network_change");
                            aVar3.setContent(jSONObject2.toString());
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        d.this.a(-1, aVar3);
                        if (d.this.blZ != null) {
                            d.this.blZ.t(aVar3);
                            d.this.blZ.d(d.this.mMsgList, true);
                        }
                    }
                }
            }
        };
        this.bmy = new Runnable() { // from class: com.baidu.live.im.d.23
            @Override // java.lang.Runnable
            public void run() {
                if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().getLastReceDataTime() > 35000) {
                    d.this.Jw();
                }
                d.this.Jv();
            }
        };
        this.bmz = new HttpMessageListener(1021013) { // from class: com.baidu.live.im.d.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    boolean z2 = false;
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        int error = httpResponsedMessage.getError();
                        if (com.baidu.live.ae.a.Qm().bwx.aOF == 1) {
                            if (error == 149010) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913070, d.this.blX.getPageActivity().getString(a.h.im_improper_content_tip)));
                                z2 = true;
                            } else if (error == 1202 || error == 1203) {
                                BdUtilHelper.showToast(d.this.blX.getPageActivity(), d.this.blX.getPageActivity().getString(a.h.im_improper_content_tip_net));
                                z2 = true;
                            } else if (error == 1204) {
                                BdUtilHelper.showToast(d.this.blX.getPageActivity(), d.this.blX.getPageActivity().getString(a.h.im_improper_content_tip));
                                z2 = true;
                            }
                        }
                    }
                    if (!z2 && d.this.blZ != null) {
                        d.this.blZ.JH();
                    }
                }
            }
        };
        this.bmA = new HttpMessageListener(1021015) { // from class: com.baidu.live.im.d.25
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
                            if (!d.this.bmq) {
                                d.this.g(iVar.aYn, iVar.giftName);
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                        }
                        if (d.this.bmq) {
                            d.this.a(iVar.giftId, iVar.aYn, iVar.aYr, z2, iVar.aYt);
                        }
                    }
                }
            }
        };
        this.bmB = new CustomMessageListener(2913277) { // from class: com.baidu.live.im.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                List<AlaLiveMarkData> list;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913277 && (customResponsedMessage instanceof AlaLocalIMCustomResponseMessage)) {
                    AlaLocalIMCustomResponseMessage alaLocalIMCustomResponseMessage = (AlaLocalIMCustomResponseMessage) customResponsedMessage;
                    d dVar = d.this;
                    short Lq = alaLocalIMCustomResponseMessage.Lq();
                    String content = alaLocalIMCustomResponseMessage.getContent();
                    boolean isOfficial = alaLocalIMCustomResponseMessage.isOfficial();
                    boolean LB = alaLocalIMCustomResponseMessage.LB();
                    int i = d.this.aED.isHost ? d.this.aED.aJD.levelId : d.this.aED.aJZ.levelId;
                    if (alaLocalIMCustomResponseMessage.LA()) {
                        list = d.this.aKk;
                    } else {
                        list = null;
                    }
                    com.baidu.live.im.data.b a2 = dVar.a(Lq, content, isOfficial, LB, i, list);
                    if (a2 != null) {
                        d.this.a(-1, a2);
                        if (d.this.blZ != null) {
                            d.this.blZ.t(a2);
                            d.this.blZ.d(d.this.mMsgList, true);
                        }
                    }
                }
            }
        };
        this.bgW = new HttpMessageListener(1021229) { // from class: com.baidu.live.im.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021229 && (httpResponsedMessage instanceof AlaLuckBagSendHttpResponseMessage)) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof com.baidu.live.gift.m) {
                        com.baidu.live.gift.m mVar = (com.baidu.live.gift.m) orginalMessage;
                        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            if (d.this.bmq) {
                                d.this.a(mVar.giftId, mVar.aYn, mVar.aYr, true, mVar.aYt);
                            }
                            if (!d.this.bmq) {
                                d.this.g(mVar.aYn, mVar.giftName);
                                return;
                            }
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                        if (d.this.bmq) {
                            d.this.a(mVar.giftId, mVar.aYn, mVar.aYr, false, mVar.aYt);
                        }
                        com.baidu.live.im.data.b a2 = d.this.a((AlaLuckBagSendHttpResponseMessage) httpResponsedMessage);
                        if (a2 != null) {
                            d.this.a(-1, a2);
                            if (d.this.blZ != null) {
                                d.this.blZ.t(a2);
                                d.this.blZ.d(d.this.mMsgList, true);
                            }
                        }
                    }
                }
            }
        };
        this.bmC = new HttpMessageListener(1021014) { // from class: com.baidu.live.im.d.4
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
                            if (!d.this.bmq) {
                                d.this.g(pVar.aYn, pVar.giftName);
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                        }
                        if (d.this.bmq) {
                            d.this.a(pVar.giftId, pVar.aYn, pVar.aYr, z2, pVar.aYt);
                        }
                    }
                }
            }
        };
        this.bmD = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.live.im.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                boolean z2;
                boolean z3;
                if (httpResponsedMessage != null) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof com.baidu.live.gift.q) {
                        com.baidu.live.gift.q qVar = (com.baidu.live.gift.q) orginalMessage;
                        if ((httpResponsedMessage instanceof GiftPackageConsumeHttpResponsedMessage) && TextUtils.isEmpty(((GiftPackageConsumeHttpResponsedMessage) httpResponsedMessage).aZu)) {
                            if (!d.this.bmq) {
                                d.this.g(qVar.aYZ, qVar.giftName);
                            }
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            if (!d.this.bmq) {
                                d.this.g(qVar.aYZ, qVar.giftName);
                            }
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (d.this.bmq) {
                            d.this.a(qVar.giftId, qVar.aYZ, qVar.aYr, z3, qVar.aYt);
                        }
                    }
                }
            }
        };
        this.bmE = new HttpMessageListener(1021012) { // from class: com.baidu.live.im.d.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                d.this.a((ResponsedMessage<?>) httpResponsedMessage, false);
            }
        };
        this.bmF = new NetMessageListener(1021050, 601008) { // from class: com.baidu.live.im.d.8
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                JSONObject jSONObject;
                AlaGetLiveStatusHttpResponseMessage alaGetLiveStatusHttpResponseMessage = responsedMessage instanceof AlaGetLiveStatusHttpResponseMessage ? (AlaGetLiveStatusHttpResponseMessage) responsedMessage : null;
                if (alaGetLiveStatusHttpResponseMessage != null && alaGetLiveStatusHttpResponseMessage.bwl != null) {
                    try {
                        jSONObject = new JSONObject(alaGetLiveStatusHttpResponseMessage.bwl);
                    } catch (JSONException e) {
                        jSONObject = null;
                    }
                    if (jSONObject != null) {
                        if (!"backstage_live".equals(jSONObject.optString("content_type"))) {
                            d.this.a(alaGetLiveStatusHttpResponseMessage.bwl, jSONObject, 12, false);
                            return;
                        }
                        String optString = jSONObject.optString("backstage_type");
                        String optString2 = jSONObject.optString("text");
                        if (!TextUtils.isEmpty(optString) && !optString.equals(d.this.bmh) && !TextUtils.isEmpty(optString2)) {
                            d.this.a(alaGetLiveStatusHttpResponseMessage.bwl, jSONObject, 13, true);
                            d.this.bmh = optString;
                        }
                    }
                }
            }
        };
        this.count = 1L;
        this.bmG = new CustomMessageListener(2913192) { // from class: com.baidu.live.im.d.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText banlstn sd=" + d.this.aED);
                if (d.this.aED != null) {
                    if (d.this.aED.mLiveInfo.getUserID() == Long.valueOf(TbadkCoreApplication.getCurrentAccount()).longValue()) {
                        Log.i("i", "@@@ localText banlstn own");
                        if (d.this.aED.aJD != null && d.this.aED.mLiveInfo != null) {
                            Log.i("i", "@@@ localText banlstn own sdreq");
                            d.this.j(d.this.aED.aJD.userId, d.this.aED.mLiveInfo.live_id);
                            return;
                        }
                        return;
                    }
                    Log.i("i", "@@@ localText banlstn oth");
                    if (d.this.aED.aJZ != null && d.this.aED.mLiveInfo != null) {
                        Log.i("i", "@@@ localText banlstn oth sdreq");
                        d.this.j(d.this.aED.aJZ.userId, d.this.aED.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.live.im.d.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                    AlaSyncHttpResponseMessage alaSyncHttpResponseMessage = (AlaSyncHttpResponseMessage) httpResponsedMessage;
                    if (alaSyncHttpResponseMessage.getError() == 0 && alaSyncHttpResponseMessage.Ow() != null) {
                        d.this.blU = alaSyncHttpResponseMessage.Ow().aOG;
                        d.this.blV = alaSyncHttpResponseMessage.Ow().aOH;
                        d.this.blW = alaSyncHttpResponseMessage.Ow().aOI;
                    }
                }
            }
        };
        this.bmH = new CustomMessageListener(2913185) { // from class: com.baidu.live.im.d.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                h hVar;
                com.baidu.live.im.data.b a2;
                if (d.this.bmq && customResponsedMessage != null && (customResponsedMessage.getData() instanceof h) && (a2 = d.this.a((hVar = (h) customResponsedMessage.getData()))) != null) {
                    double m = d.this.m(a2);
                    a2.setMsgId(0L);
                    a2.setRecordId(0L);
                    com.baidu.live.data.a Lc = a2.Lc();
                    if (Lc != null && !StringUtils.isNull(Lc.userId) && !StringUtils.isNull(hVar.giftId)) {
                        String str = Lc.userId;
                        String nameShow = Lc.getNameShow();
                        String str2 = str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + hVar.giftId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + nameShow;
                        if (d.this.bms == null) {
                            d.this.bms = new HashMap();
                        }
                        hVar.boe = a2;
                        hVar.userId = str;
                        hVar.userName = nameShow;
                        hVar.bog = m;
                        if (!d.this.bmi.equals("1")) {
                            d.this.b(hVar);
                        }
                        if (!d.this.bms.containsKey(str2)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put(Long.valueOf(hVar.aYr), hVar);
                            d.this.bms.put(str2, hashMap);
                            return;
                        }
                        ((HashMap) d.this.bms.get(str2)).put(Long.valueOf(hVar.aYr), hVar);
                    }
                }
            }
        };
        this.bmI = new CustomMessageListener(2913184) { // from class: com.baidu.live.im.d.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                    i iVar = (i) customResponsedMessage.getData();
                    if (iVar.bon > 0) {
                        HashMap hashMap = (HashMap) d.this.bmr.get(iVar.beq);
                        if (hashMap != null && !hashMap.isEmpty()) {
                            h hVar = (h) hashMap.remove(Long.valueOf(iVar.bon));
                            if (hVar != null) {
                                hVar.boj = true;
                                hVar.boe.aX(hVar.count);
                                hVar.boe.h(hVar.bog);
                                if (hVar.boe.isHost()) {
                                    hVar.boe.aY(-1L);
                                } else {
                                    hVar.boe.aY(hVar.aXc);
                                }
                                if (!d.this.s(hVar.boe)) {
                                    d.this.a(-1, hVar.boe);
                                    if (d.this.blZ != null) {
                                        d.this.blZ.d(d.this.mMsgList, true);
                                    }
                                }
                            }
                            if (hashMap.isEmpty()) {
                                d.this.bmr.remove(iVar.beq);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    HashMap hashMap2 = (HashMap) d.this.bms.get(iVar.beq);
                    if (hashMap2 != null && !hashMap2.isEmpty()) {
                        h hVar2 = (h) hashMap2.get(Long.valueOf(iVar.bop));
                        if (hVar2 != null) {
                            if (hVar2.boi != 0) {
                                hVar2.boj = true;
                                return;
                            }
                            hashMap2.remove(Long.valueOf(iVar.bop));
                            hVar2.boe.aX(hVar2.count);
                            hVar2.boe.h(hVar2.bog);
                            if (hVar2.boe.isHost()) {
                                hVar2.boe.aY(-1L);
                            } else {
                                hVar2.boe.aY(hVar2.aXc);
                            }
                            if (!d.this.s(hVar2.boe)) {
                                d.this.a(-1, hVar2.boe);
                                if (d.this.blZ != null) {
                                    d.this.blZ.d(d.this.mMsgList, true);
                                }
                            }
                            long j = hVar2.bof;
                            if (j > 0) {
                                d.this.g(j, hVar2.giftName);
                            }
                        }
                        if (hashMap2.isEmpty()) {
                            d.this.bms.remove(iVar.beq);
                        }
                    }
                }
            }
        };
        this.bmJ = new CustomMessageListener(2913183) { // from class: com.baidu.live.im.d.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                    i iVar = (i) customResponsedMessage.getData();
                    if (iVar.bon == 0) {
                        HashMap hashMap = (HashMap) d.this.bms.get(iVar.beq);
                        if (hashMap != null && !hashMap.isEmpty()) {
                            h hVar = (h) hashMap.get(Long.valueOf(iVar.bop));
                            h hVar2 = (h) hashMap.get(Long.valueOf(iVar.bos));
                            if (hVar != null && hVar2 != null) {
                                hashMap.remove(Long.valueOf(iVar.bos));
                                hVar.count += hVar2.count;
                                hVar.aXc += hVar2.aXc;
                                hVar.bof += hVar2.bof;
                                hVar.boi += hVar2.boi;
                                if (hVar.bog != hVar2.bog) {
                                    hVar.bog = 0.0d;
                                }
                                hVar.bok.add(Long.valueOf(hVar2.aYr));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    HashMap hashMap2 = (HashMap) d.this.bmr.get(iVar.beq);
                    if (hashMap2 != null && !hashMap2.isEmpty() && iVar.bon != iVar.boq) {
                        h hVar3 = (h) hashMap2.get(Long.valueOf(iVar.bon));
                        h hVar4 = (h) hashMap2.remove(Long.valueOf(iVar.boq));
                        if (hVar3 != null && hVar4 != null) {
                            hVar3.count += hVar4.count;
                            hVar3.aXc += hVar4.aXc;
                            if (hVar3.bog != hVar4.bog) {
                                hVar3.bog = 0.0d;
                            }
                        }
                    }
                }
            }
        };
        this.bmK = new CustomMessageListener(2913195) { // from class: com.baidu.live.im.d.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                HashMap hashMap;
                h hVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                    i iVar = (i) customResponsedMessage.getData();
                    if (iVar.bon != 0 && (hashMap = (HashMap) d.this.bmr.get(iVar.beq)) != null && !hashMap.isEmpty() && (hVar = (h) hashMap.get(Long.valueOf(iVar.bon))) != null) {
                        hVar.count = iVar.bot;
                        hVar.aXc = iVar.bou;
                    }
                }
            }
        };
        this.bmL = new HttpMessageListener(1021194) { // from class: com.baidu.live.im.d.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                d.this.bml = false;
                d.this.mHandler.removeCallbacks(d.this.bmv);
                if (httpResponsedMessage != null) {
                    if (httpResponsedMessage.getOrginalMessage() == null || !(httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.im.message.c) || !((com.baidu.live.im.message.c) httpResponsedMessage.getOrginalMessage()).bb(System.currentTimeMillis())) {
                        if (d.this.bmm) {
                            d.this.bmm = false;
                            return;
                        } else if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            ImForbiddenStateData imForbiddenStateData = new ImForbiddenStateData();
                            imForbiddenStateData.errno = httpResponsedMessage.getError();
                            imForbiddenStateData.errMsg = httpResponsedMessage.getErrorString();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, imForbiddenStateData));
                            return;
                        } else if (httpResponsedMessage instanceof AlaForbiddenWordsStateResponseMessage) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, ((AlaForbiddenWordsStateResponseMessage) httpResponsedMessage).bre));
                            return;
                        } else {
                            return;
                        }
                    }
                    d.this.bmm = false;
                }
            }
        };
        this.aEM = new CustomMessageListener(2913300) { // from class: com.baidu.live.im.d.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("memoryMonitor", "@@ memoryMonitor alaLivingImModel @memoryMonitorCleanListener");
                int size = d.this.mMsgList.size();
                int min = Math.min(size, 5);
                if (min <= 0) {
                    min = 1;
                }
                Log.i("memoryMonitor", "@@ memoryMonitor alaLivingImModel @memoryMonitorCleanListener count=" + size + ", max=" + min);
                while (d.this.mMsgList.size() > min) {
                    d.this.mMsgList.removeFirst();
                }
                Log.i("memoryMonitor", "@@ memoryMonitor alaLivingImModel @memoryMonitorCleanListener size=" + d.this.mMsgList.size());
            }
        };
        this.blU = com.baidu.live.ae.a.Qm().bwx.aOG;
        this.blV = com.baidu.live.ae.a.Qm().bwx.aOH;
        this.blW = com.baidu.live.ae.a.Qm().bwx.aOI;
        this.blX = bdPageContext;
        this.blY = z;
        this.blZ = aVar;
        this.mMsgList = new LinkedList<>();
        this.bmr = new LinkedHashMap<>();
        this.bms = new HashMap<>();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913182, Object.class);
        if (runTask != null && runTask.getData() != null) {
            this.bmq = true;
        }
        MessageManager.getInstance().registerTask(Ju());
        com.baidu.live.tieba.f.a.a.a(1021050, "alaim/gmsg/getLiveStatus", AlaGetLiveStatusHttpResponseMessage.class, false, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021012, "alaim/gmsg/getGroupMsg", ALAGroupHttpResponseMessage.class, false, true, true, true);
        JF();
        registerListener(this.bmL);
        MessageManager.getInstance().registerListener(this.syncListener);
        MessageManager.getInstance().registerListener(this.aEM);
    }

    public void setAlaLiveShowData(ab abVar) {
        this.aED = abVar;
        if (this.aED != null && this.aED.mLiveInfo != null) {
            this.bmn = this.aED.mLiveInfo.audience_count - this.aED.mLiveInfo.ai_robot_num;
        }
    }

    private HttpMessageTask Ju() {
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
    public void Jv() {
        this.mHandler.postDelayed(this.bmy, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jw() {
        sendMessage(new com.baidu.live.im.message.b(JavaTypesHelper.toInt(this.mGroupId, 0), getLastMid()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jx() {
        this.mHandler.removeCallbacks(this.bmy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.live.im.data.b a(AlaLuckBagSendHttpResponseMessage alaLuckBagSendHttpResponseMessage) {
        JSONObject jSONObject = new JSONObject();
        try {
            com.baidu.live.gift.m mVar = (com.baidu.live.gift.m) alaLuckBagSendHttpResponseMessage.getmOrginalMessage();
            jSONObject.put("content_type", "luckybag_win_prize");
            jSONObject.put("user_name", "您");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("prize_total_value", alaLuckBagSendHttpResponseMessage.LE());
            jSONObject2.put("lucky_bag_id", alaLuckBagSendHttpResponseMessage.LH());
            jSONObject2.put("lucky_bag_img", alaLuckBagSendHttpResponseMessage.LF());
            jSONObject2.put("lucky_bag_name", alaLuckBagSendHttpResponseMessage.LG());
            List<com.baidu.live.im.data.a> LC = alaLuckBagSendHttpResponseMessage.LC();
            if (LC != null && !LC.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (com.baidu.live.im.data.a aVar : LC) {
                    jSONArray.put(aVar.toJson());
                }
                jSONObject2.put("prize_member", jSONArray);
            }
            List<com.baidu.live.im.data.a> LD = alaLuckBagSendHttpResponseMessage.LD();
            if (LD != null && !LD.isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                for (com.baidu.live.im.data.a aVar2 : LD) {
                    jSONArray2.put(aVar2.toJson());
                }
                jSONObject2.put("surprise_prize_member", jSONArray2);
            }
            jSONObject.put("ext_data", jSONObject2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913276, jSONObject));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a((short) 13, jSONObject.toString(), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), this.aKk);
    }

    public void g(long j, String str) {
        if (j == 0) {
            j = 1;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.blX.getString(a.h.sdk_gift);
        }
        com.baidu.live.im.data.b a2 = a((short) 27, String.format(this.blX.getString(a.h.sdk_send_gift_fail), Long.valueOf(j), str), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), this.aKk);
        if (a2 != null) {
            a(-1, a2);
            if (this.blZ != null) {
                this.blZ.t(a2);
                this.blZ.d(this.mMsgList, true);
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
            str2 = this.blX.getString(a.h.sdk_gift);
        }
        if (hVar.bom) {
            b = s(hVar.giftId, str, str2);
        } else {
            b = b(hVar.giftId, str, str2, 0L, hVar.boh);
        }
        return a((short) 24, b.toString(), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), this.aKk);
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

    private JSONObject s(String str, String str2, String str3) {
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

    private void Jy() {
        if (this.bmk == null) {
            this.bmk = new CustomMessageListener(2913251) { // from class: com.baidu.live.im.d.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    JSONObject jSONObject;
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                        for (String str : (List) customResponsedMessage.getData()) {
                            if (str != null) {
                                try {
                                    if (str.contains("livetips_im_info") || str.contains("pubshow_live_add_team")) {
                                        JSONObject jSONObject2 = new JSONObject(str);
                                        if (jSONObject2 != null && (jSONObject = new JSONObject(jSONObject2.optString("content"))) != null) {
                                            if (str.contains("pubshow_live_add_team")) {
                                                String optString = jSONObject.optString("leader_uid");
                                                if (optString != null && !com.baidu.live.utils.f.isNumeric(optString)) {
                                                    optString = ExtraParamsManager.getDecryptUserId(optString);
                                                }
                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                String optString2 = jSONObject.optString("nickname", "");
                                                String optString3 = jSONObject.optString("head_img", "");
                                                com.baidu.live.im.a aVar = new com.baidu.live.im.a();
                                                aVar.setMsgType(27);
                                                try {
                                                    JSONObject jSONObject3 = new JSONObject();
                                                    jSONObject3.put("content_type", "group_guess");
                                                    jSONObject3.put("name_color", jSONObject.optString("nickname_color", "#FFFFEAAA"));
                                                    jSONObject3.put("content_color", jSONObject.optString("tips_color", "#FFFFFFFF"));
                                                    jSONObject3.put("content", jSONObject.optString("tips_content", ""));
                                                    jSONObject3.put("to_user_id", optString);
                                                    jSONObject3.put("from_user_id", currentAccount);
                                                    aVar.setContent(jSONObject3.toString());
                                                } catch (JSONException e) {
                                                    e.printStackTrace();
                                                }
                                                com.baidu.live.data.a aVar2 = new com.baidu.live.data.a();
                                                aVar2.userName = optString2;
                                                aVar2.portrait = optString3;
                                                aVar.e(aVar2);
                                                d.this.a(-1, aVar);
                                                if (d.this.blZ != null) {
                                                    d.this.blZ.d(d.this.mMsgList, true);
                                                    d.this.blZ.t(aVar);
                                                    return;
                                                }
                                                return;
                                            }
                                            com.baidu.live.im.data.e eVar = new com.baidu.live.im.data.e();
                                            eVar.X(jSONObject2);
                                            eVar.W(jSONObject);
                                            JSONObject jSONObject4 = new JSONObject();
                                            jSONObject4.put("foot_color", eVar.bra);
                                            jSONObject4.put("content_type", "host_send_award");
                                            jSONObject4.put("back_color", eVar.bg_color);
                                            jSONObject4.put("text", eVar.bqW);
                                            d.this.t(eVar.bqX, eVar.bqY, jSONObject4.toString());
                                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913297, jSONObject));
                                        } else {
                                            return;
                                        }
                                    }
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.bmk);
        }
    }

    private void Jz() {
        if (this.bmk != null) {
            MessageManager.getInstance().unRegisterListener(this.bmk);
            this.bmk = null;
        }
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
        if (this.blZ != null) {
            this.blZ.t(aVar);
            if (z) {
                this.blZ.d(this.mMsgList, true);
            }
        }
    }

    protected void a(ResponsedMessage<?> responsedMessage, boolean z) {
        boolean z2;
        long j;
        List<com.baidu.live.im.data.b> list;
        if (responsedMessage instanceof ALAGroupHttpResponseMessage) {
            list = ((ALAGroupHttpResponseMessage) responsedMessage).Lz();
            j = ((ALAGroupHttpResponseMessage) responsedMessage).getGroupId();
            z2 = ((ALAGroupHttpResponseMessage) responsedMessage).Ly();
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
                R(list);
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
            if (this.bme != 0) {
                int i2 = this.bmf * this.bmd;
                ArrayList arrayList = new ArrayList(this.bmc);
                d(0, arrayList.subList(i2, arrayList.size()));
                JD();
            }
            if (list.size() > 0) {
                if (list.size() > 5 && z) {
                    P(list);
                } else {
                    O(a(list, z, z2));
                }
            }
        }
    }

    public void e(String str, String str2, String str3, String str4, String str5) {
        if (this.mMsgList != null) {
            this.mMsgList.clear();
        }
        if (this.bmr != null) {
            this.bmr.clear();
        }
        if (this.bms != null) {
            this.bms.clear();
        }
        this.mMsgList = new LinkedList<>();
        this.mGroupId = str;
        this.bma = str2;
        this.bmb = str3;
        this.mLiveId = str4;
        this.bmh = "0";
        this.mAppId = str5;
        MessageManager.getInstance().registerListener(this.bmE);
        MessageManager.getInstance().registerListener(this.bmF);
        MessageManager.getInstance().registerListener(this.bmw);
        MessageManager.getInstance().registerListener(this.bmz);
        MessageManager.getInstance().registerListener(this.bmx);
        MessageManager.getInstance().registerListener(this.bmA);
        MessageManager.getInstance().registerListener(this.bmB);
        MessageManager.getInstance().registerListener(this.bgW);
        MessageManager.getInstance().registerListener(this.bmC);
        MessageManager.getInstance().registerListener(this.bmD);
        MessageManager.getInstance().registerListener(this.bmH);
        MessageManager.getInstance().registerListener(this.bmI);
        MessageManager.getInstance().registerListener(this.bmJ);
        MessageManager.getInstance().registerListener(this.bmK);
        MessageManager.getInstance().registerListener(this.bmG);
        MessageManager.getInstance().registerListener(this.bgO);
        Jy();
        if (BdSocketLinkService.isClose()) {
            Jw();
            BdSocketLinkService.startService(true, "live start");
        }
        String str6 = com.baidu.live.ae.a.Qm().bwx.aLS;
        if (!TextUtils.isEmpty(str6)) {
            com.baidu.live.im.data.b JE = JE();
            JE.setMsgType(27);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("text", str6);
                jSONObject.put("content_type", "custom_live_notice");
                JE.setContent(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            a(-1, JE);
            if (this.blZ != null) {
                this.blZ.t(JE);
            }
        }
        String str7 = com.baidu.live.ae.a.Qm().bwx.aLT;
        if (!TextUtils.isEmpty(str7)) {
            com.baidu.live.im.data.b JE2 = JE();
            JE2.setMsgType(27);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("text", str7);
                jSONObject2.put("content_type", "custom_live_notice");
                JE2.setContent(jSONObject2.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            a(-1, JE2);
        }
        List<String> list = com.baidu.live.ae.a.Qm().bwx.aLR;
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
                    com.baidu.live.im.data.b JE3 = JE();
                    JE3.setMsgType(27);
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("text", str8);
                        jSONObject3.put("content_type", "custom_im_notice");
                        JE3.setContent(jSONObject3.toString());
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                    JE3.setLink(str9);
                    a(-1, JE3);
                    if (this.blZ != null) {
                        this.blZ.t(JE3);
                    }
                }
                i = i2 + 2;
            }
        }
        if (this.aED != null && this.aED.aKr != null && !StringUtils.isNull(this.aED.aKr.Bh())) {
            com.baidu.live.im.data.b JE4 = JE();
            JE4.setMsgType(27);
            try {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("text", this.aED.aKr.Bh());
                jSONObject4.put("content_type", "live_notice_quick_chat");
                jSONObject4.put("anchorName", this.aED.aJD.userName);
                JE4.setContent(jSONObject4.toString());
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            this.mMsgList.add(JE4);
            if (this.blZ != null) {
                this.blZ.t(JE4);
            }
        }
        JB();
        JA();
        if (this.mMsgList.size() > 0 && this.blZ != null) {
            this.blZ.d(this.mMsgList, true);
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGmsgGetLiveStatusUnabled()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.d.9
                @Override // java.lang.Runnable
                public void run() {
                    d.this.hd("enter");
                }
            }, 1000L);
        }
        Jv();
        if (TbadkCoreApplication.getInst().isOther()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913146, this.mMsgList));
        }
    }

    private void JA() {
        String str = com.baidu.live.ae.a.Qm().bwx.aLU;
        if (str != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    com.baidu.live.im.data.b JE = JE();
                    JE.setMsgType(27);
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    JSONObject jSONObject2 = new JSONObject();
                    if (jSONObject.optInt("open") != 0) {
                        jSONObject2.put("text", jSONObject.toString());
                        jSONObject2.put("content_type", "activity_notice");
                        JE.setContent(jSONObject2.toString());
                        this.mMsgList.add(JE);
                        if (this.blZ != null) {
                            this.blZ.t(JE);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void JB() {
        if (JC()) {
            com.baidu.live.im.data.b JE = JE();
            JE.setMsgType(27);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("text", com.baidu.live.ae.a.Qm().bwx.aOC.aJP);
                jSONObject.put("content_type", "custom_im_notice_live_assistant");
                JE.setContent(jSONObject.toString());
                JE.setLink(com.baidu.live.ae.a.Qm().bwx.aOC.aJO);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mMsgList.add(JE);
            if (this.blZ != null) {
                this.blZ.t(JE);
            }
        }
    }

    private boolean JC() {
        return (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) || !TbadkCoreApplication.getCurrentAccount().equals(this.bmb) || com.baidu.live.ae.a.Qm().bwx == null || com.baidu.live.ae.a.Qm().bwx.aOC == null || TextUtils.isEmpty(com.baidu.live.ae.a.Qm().bwx.aOC.aJP)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(List<com.baidu.live.im.data.b> list) {
        if (list != null && this.blZ != null) {
            this.blZ.d(this.mMsgList, true);
            for (com.baidu.live.im.data.b bVar : list) {
                this.blZ.t(bVar);
            }
        }
    }

    protected void P(List<com.baidu.live.im.data.b> list) {
        this.bmc = list;
        this.bme = (int) ((this.bmg * 2.0f) / 0.25f);
        this.bmf = 0;
        this.bmd = list.size() / this.bme;
        if (this.bmd <= 0) {
            this.bmd = 1;
        }
        this.mHandler.removeCallbacks(this.bmu);
        this.mHandler.postDelayed(this.bmu, 250L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JD() {
        this.mHandler.removeCallbacks(this.bmu);
        this.bmf = 0;
        this.bme = 0;
        this.bmd = 0;
        this.bmc = null;
    }

    protected List<com.baidu.live.im.data.b> b(List<com.baidu.live.im.data.b> list, boolean z) {
        return a(list, z, false);
    }

    protected List<com.baidu.live.im.data.b> a(List<com.baidu.live.im.data.b> list, boolean z, boolean z2) {
        for (com.baidu.live.im.data.b bVar : list) {
            if (bVar instanceof com.baidu.live.im.a) {
                ((com.baidu.live.im.a) bVar).hc(this.bmb);
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
            d(z2, list);
            if (!z2) {
                Q(list);
            }
            if (z2 && this.mMsgList.size() > 2) {
                b(list, 2);
            } else {
                b(list, -1);
            }
        }
        if (this.mMsgList.size() > com.baidu.live.ae.a.Qm().bwx.aOq) {
            int i = (int) (com.baidu.live.ae.a.Qm().bwx.aOq * 0.7d);
            if (i <= 0) {
                i = 1;
            }
            while (this.mMsgList.size() > i) {
                this.mMsgList.removeFirst();
            }
        }
        return list;
    }

    private void Q(List<com.baidu.live.im.data.b> list) {
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
        JSONObject jSONObject;
        List<AlaLiveMarkData> list;
        boolean z = false;
        com.baidu.live.data.a Lc = bVar.Lc();
        if (Lc != null && (list = Lc.aHz) != null && !list.isEmpty()) {
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
            d = com.baidu.live.ae.f.QE().m(z, jSONObject.optString(LogConfig.LOG_GIFT_ID));
            if (d < 0.0d) {
                d = 0.0d;
            }
        } catch (JSONException e) {
            e = e;
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
        return d;
    }

    private void d(boolean z, List<com.baidu.live.im.data.b> list) {
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
                        if (!TextUtils.isEmpty(optString) && (optString.equals("challenge_direct_start") || optString.equals("challenge_direct_matched") || optString.equals("challenge_random_start") || optString.equals("challenge_random_matched") || optString.equals("live_net_status") || optString.equals("send_redpacket") || optString.equals("start_grab_redpacket") || optString.equals("guard_seat") || optString.equals("multi_session") || optString.equals("guard_pk_win_tip") || optString.equals("fullscreen") || optString.equals("challenge_mvp") || optString.equals("challenge_mvp_punish") || optString.equals("challenge_winner_by_autofail") || optString.equals("official_notice") || optString.equals("activity_common_im") || optString.equals("activity_notice") || optString.equals("activity_gift") || optString.equals("pk_first_blood") || optString.equals("pk_send_props") || optString.equals("pk_mvp_props") || optString.equals(UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT) || optString.equals("luckybag_win_prize") || optString.equals("luckybag_send") || optString.equals("privilege_award_royal_success"))) {
                            it.remove();
                        }
                    } catch (JSONException e) {
                    }
                }
            }
        }
    }

    private void R(List<com.baidu.live.im.data.b> list) {
        if (list != null && !list.isEmpty()) {
            for (com.baidu.live.im.data.b bVar : list) {
                bVar.cp(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.live.im.data.b bVar) {
        boolean z = false;
        if ((bVar instanceof com.baidu.live.im.a) && bVar.Lc() != null && TextUtils.equals(bVar.Lc().userId, TbadkCoreApplication.getCurrentAccount())) {
            z = true;
        }
        if (this.bmn < this.blU) {
            if (i >= 0) {
                this.mMsgList.add(i, bVar);
            } else {
                this.mMsgList.addLast(bVar);
            }
        } else if (this.bmn >= this.blU && this.bmn < this.blV) {
            if (q(bVar) && !z) {
                bVar.Lo();
            }
            if (i >= 0) {
                this.mMsgList.add(i, bVar);
            } else if (!this.mMsgList.isEmpty() && q(this.mMsgList.getLast())) {
                if (!this.mMsgList.getLast().Lc().userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.mMsgList.set(this.mMsgList.size() - 1, bVar);
                } else {
                    this.mMsgList.addLast(bVar);
                }
            } else {
                this.mMsgList.addLast(bVar);
            }
        } else if (this.bmn >= this.blV && this.bmn < this.blW) {
            if (o(bVar) && !z) {
                bVar.Lo();
            }
            if (i >= 0) {
                this.mMsgList.add(i, bVar);
            } else if (!this.mMsgList.isEmpty() && o(this.mMsgList.getLast())) {
                if (!this.mMsgList.getLast().Lc().userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.mMsgList.set(this.mMsgList.size() - 1, bVar);
                } else {
                    this.mMsgList.addLast(bVar);
                }
            } else {
                this.mMsgList.addLast(bVar);
            }
        } else if (this.bmn >= this.blW) {
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
        this.bmo = 0;
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
                if (com.baidu.live.entereffect.a.CY().h(bVar)) {
                    this.bmo = 2;
                } else {
                    this.bmo = 1;
                }
            } else {
                this.bmo = 0;
            }
        }
        return this.bmo;
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
                    if (bVar != null && bVar.Lc() != null && !TextUtils.isEmpty(bVar.Lc().userId) && bVar.Lc().userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        int i2 = size - 1;
                        while (true) {
                            if (i2 >= 0 && i2 >= 0) {
                                com.baidu.live.im.data.b bVar2 = list.get(i2);
                                if (bVar2 != null && bVar2.Lc() != null && !TextUtils.isEmpty(bVar2.Lc().userId) && bVar2.Lc().userId.equals(TbadkCoreApplication.getCurrentAccount()) && bVar.getRecordId() == bVar2.getRecordId()) {
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

    /* JADX WARN: Removed duplicated region for block: B:136:0x048d  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x058b  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x05c4 A[Catch: JSONException -> 0x0f8f, Exception -> 0x0f95, TryCatch #17 {JSONException -> 0x0f8f, Exception -> 0x0f95, blocks: (B:177:0x05bc, B:179:0x05c4, B:180:0x05cb, B:183:0x0603, B:186:0x0613, B:188:0x061c, B:191:0x062e, B:194:0x0643, B:623:0x0f82, B:622:0x0f7a, B:195:0x0646, B:197:0x0666, B:198:0x0671, B:619:0x0f68), top: B:659:0x05bc }] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0602  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0612  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x061c A[Catch: JSONException -> 0x0f8f, Exception -> 0x0f95, TryCatch #17 {JSONException -> 0x0f8f, Exception -> 0x0f95, blocks: (B:177:0x05bc, B:179:0x05c4, B:180:0x05cb, B:183:0x0603, B:186:0x0613, B:188:0x061c, B:191:0x062e, B:194:0x0643, B:623:0x0f82, B:622:0x0f7a, B:195:0x0646, B:197:0x0666, B:198:0x0671, B:619:0x0f68), top: B:659:0x05bc }] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0666 A[Catch: JSONException -> 0x0f8f, Exception -> 0x0f95, TryCatch #17 {JSONException -> 0x0f8f, Exception -> 0x0f95, blocks: (B:177:0x05bc, B:179:0x05c4, B:180:0x05cb, B:183:0x0603, B:186:0x0613, B:188:0x061c, B:191:0x062e, B:194:0x0643, B:623:0x0f82, B:622:0x0f7a, B:195:0x0646, B:197:0x0666, B:198:0x0671, B:619:0x0f68), top: B:659:0x05bc }] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0693  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0785 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:266:0x07ae  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x07b9  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x07bc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:282:0x07db  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x07dd  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x081b  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x087b  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x088d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:619:0x0f68 A[Catch: JSONException -> 0x0f8f, Exception -> 0x0f95, TRY_ENTER, TryCatch #17 {JSONException -> 0x0f8f, Exception -> 0x0f95, blocks: (B:177:0x05bc, B:179:0x05c4, B:180:0x05cb, B:183:0x0603, B:186:0x0613, B:188:0x061c, B:191:0x062e, B:194:0x0643, B:623:0x0f82, B:622:0x0f7a, B:195:0x0646, B:197:0x0666, B:198:0x0671, B:619:0x0f68), top: B:659:0x05bc }] */
    /* JADX WARN: Removed duplicated region for block: B:620:0x0f74  */
    /* JADX WARN: Removed duplicated region for block: B:621:0x0f77  */
    /* JADX WARN: Removed duplicated region for block: B:624:0x0f8a  */
    /* JADX WARN: Removed duplicated region for block: B:630:0x0f9b  */
    /* JADX WARN: Removed duplicated region for block: B:645:0x07e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(List<com.baidu.live.im.data.b> list, boolean z) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        String str;
        int i;
        JSONObject jSONObject5;
        LinkedList linkedList = new LinkedList();
        for (com.baidu.live.im.data.b bVar : list) {
            long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
            if (!ListUtils.isEmpty(bVar.Le()) && !bVar.Le().contains(Long.valueOf(currentAccountId))) {
                linkedList.add(bVar);
            } else {
                boolean z2 = false;
                int i2 = 0;
                int i3 = 0;
                boolean z3 = this.aED.aKP;
                boolean z4 = bVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                if (z4 && bVar.getMsgType() == 24) {
                    try {
                        if (bVar.getObjContent() instanceof JSONObject) {
                            jSONObject5 = (JSONObject) bVar.getObjContent();
                        } else {
                            jSONObject5 = new JSONObject(bVar.getContent());
                        }
                        i2 = jSONObject5.optInt("show_own");
                        if (i2 == 1) {
                            z2 = true;
                        }
                        JSONArray optJSONArray = jSONObject5.optJSONArray("im_icon_conf");
                        if (optJSONArray != null && optJSONArray.length() != 0 && !z2) {
                            jSONObject5.put("content_type", "custom_gift");
                            bVar.setContent(jSONObject5.toString());
                            bVar.setMsgType(13);
                        }
                        i = jSONObject5.optInt("local_show");
                        if (i == 1 && i2 != 1) {
                            try {
                                JSONObject optJSONObject = jSONObject5.optJSONObject("headline_info");
                                if (optJSONObject != null) {
                                    jSONObject5.put("content_type", "activity_gift");
                                    JSONObject jSONObject6 = new JSONObject();
                                    jSONObject6.put("giftName", jSONObject5.optString("gift_name"));
                                    jSONObject6.put("giftPic", jSONObject5.optString("gift_url"));
                                    jSONObject6.put("giftNumber", Integer.valueOf(jSONObject5.optString("gift_count")));
                                    jSONObject6.put("firstText", "送出的");
                                    jSONObject6.put("secondText", optJSONObject.optString("second_text"));
                                    jSONObject6.put("multipleTime", optJSONObject.optDouble("headline_buff_multiple"));
                                    jSONObject6.put("multipleName", optJSONObject.optString("headline_buff_text"));
                                    jSONObject6.put("span_color_start", optJSONObject.optString("headline_buff_text_color_start"));
                                    jSONObject6.put("span_color_end", optJSONObject.optString("headline_buff_text_color_end"));
                                    jSONObject6.put("span_text_color", optJSONObject.optString("headline_buff_text_font_color"));
                                    jSONObject5.put("content_data", jSONObject6);
                                    bVar.setContent(jSONObject5.toString());
                                    bVar.setMsgType(13);
                                }
                            } catch (JSONException e) {
                                e = e;
                                e.printStackTrace();
                                i3 = i;
                                if (bVar.getMsgType() == 13) {
                                }
                                if (bVar.getMsgType() == 24) {
                                }
                                if (!z4) {
                                }
                                if (!this.bmq) {
                                }
                                if (bVar.getMsgType() == 125) {
                                }
                                JSONObject jSONObject7 = new JSONObject();
                                if (!(bVar.getObjContent() instanceof JSONObject)) {
                                }
                                JSONObject jSONObject8 = new JSONObject();
                                jSONObject8.put("content_type", jSONObject3.optString("content_type"));
                                jSONObject8.put("show_own", i2);
                                jSONObject8.put("local_show", i3);
                                jSONObject8.put("is_mine", jSONObject3.optInt("is_mine"));
                                jSONObject8.put("headline_info", jSONObject3.optJSONArray("headline_info") != null ? 0 : 1);
                                jSONObject8.put("im_icon_conf", jSONObject3.optJSONObject("im_icon_conf") != null ? 0 : 1);
                                if (bVar.Lc() != null) {
                                }
                                jSONObject8.put("msg_id", bVar.getMsgId());
                                jSONObject8.put("msg_type", bVar.getMsgType());
                                jSONObject8.put(LogConfig.LOG_GIFT_ID, !jSONObject3.has(LogConfig.LOG_GIFT_ID) ? Integer.valueOf(jSONObject3.optInt(LogConfig.LOG_GIFT_ID)) : "");
                                jSONObject8.put("from_gongyanfang_page", 0);
                                jSONObject7.putOpt("im", jSONObject8);
                                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_LUCKY_BAG, UbcStatConstant.ContentType.UBC_FILTER_IM, !bVar.isHost() ? "author_liveroom" : "liveroom", UbcStatConstant.Value.VALUE_FILTER_IM).setContentExt(null, null, jSONObject7));
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                i3 = i;
                                if (bVar.getMsgType() == 13) {
                                }
                                if (bVar.getMsgType() == 24) {
                                }
                                if (!z4) {
                                }
                                if (!this.bmq) {
                                }
                                if (bVar.getMsgType() == 125) {
                                }
                                JSONObject jSONObject72 = new JSONObject();
                                if (!(bVar.getObjContent() instanceof JSONObject)) {
                                }
                                JSONObject jSONObject82 = new JSONObject();
                                jSONObject82.put("content_type", jSONObject3.optString("content_type"));
                                jSONObject82.put("show_own", i2);
                                jSONObject82.put("local_show", i3);
                                jSONObject82.put("is_mine", jSONObject3.optInt("is_mine"));
                                jSONObject82.put("headline_info", jSONObject3.optJSONArray("headline_info") != null ? 0 : 1);
                                jSONObject82.put("im_icon_conf", jSONObject3.optJSONObject("im_icon_conf") != null ? 0 : 1);
                                if (bVar.Lc() != null) {
                                }
                                jSONObject82.put("msg_id", bVar.getMsgId());
                                jSONObject82.put("msg_type", bVar.getMsgType());
                                jSONObject82.put(LogConfig.LOG_GIFT_ID, !jSONObject3.has(LogConfig.LOG_GIFT_ID) ? Integer.valueOf(jSONObject3.optInt(LogConfig.LOG_GIFT_ID)) : "");
                                jSONObject82.put("from_gongyanfang_page", 0);
                                jSONObject72.putOpt("im", jSONObject82);
                                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_LUCKY_BAG, UbcStatConstant.ContentType.UBC_FILTER_IM, !bVar.isHost() ? "author_liveroom" : "liveroom", UbcStatConstant.Value.VALUE_FILTER_IM).setContentExt(null, null, jSONObject72));
                            }
                        }
                        i3 = i;
                    } catch (JSONException e3) {
                        e = e3;
                        i = 0;
                    } catch (Exception e4) {
                        e = e4;
                        i = 0;
                    }
                }
                if (bVar.getMsgType() == 13) {
                    JSONObject jSONObject9 = null;
                    try {
                        if (bVar.getObjContent() instanceof JSONObject) {
                            jSONObject9 = (JSONObject) bVar.getObjContent();
                        } else {
                            jSONObject9 = new JSONObject(bVar.getContent());
                        }
                        str = jSONObject9.optString("content_type");
                    } catch (JSONException e5) {
                        e5.printStackTrace();
                        str = null;
                    } catch (Exception e6) {
                        e6.printStackTrace();
                        str = null;
                    }
                    if ("pk_send_props".equals(str) && jSONObject9 != null && str != null && jSONObject9.optString("is_mine").equals("1")) {
                        if (!z4) {
                            bVar.setMsgType(24);
                        } else {
                            bVar.setMsgType(13);
                        }
                    }
                    if (UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT.equals(str) && jSONObject9 != null && jSONObject9.optInt("tying_status") == 1) {
                        z2 = true;
                        bVar.setMsgType(24);
                    }
                    if ("luckybag_send".equals(str) && jSONObject9 != null) {
                        JSONObject jSONObject10 = new JSONObject();
                        try {
                            JSONObject jSONObject11 = new JSONObject();
                            jSONObject11.put("content_type", jSONObject9.optString("content_type"));
                            jSONObject11.put("show_own", i2);
                            jSONObject11.put("local_show", i3);
                            jSONObject11.put("is_mine", jSONObject9.optInt("is_mine"));
                            jSONObject11.put("headline_info", jSONObject9.optJSONArray("headline_info") == null ? 0 : 1);
                            jSONObject11.put("im_icon_conf", jSONObject9.optJSONObject("im_icon_conf") == null ? 0 : 1);
                            if (bVar.Lc() != null) {
                                jSONObject11.put("send_uid", TextUtils.isEmpty(bVar.Lc().userId) ? "" : bVar.Lc().userId);
                                jSONObject11.put("cur_uid", TextUtils.isEmpty(bVar.Lc().userId) ? "" : bVar.Lc().userId);
                            }
                            jSONObject11.put("msg_id", bVar.getMsgId());
                            jSONObject11.put("msg_type", bVar.getMsgType());
                            jSONObject11.put(LogConfig.LOG_GIFT_ID, jSONObject9.has(LogConfig.LOG_GIFT_ID) ? Integer.valueOf(jSONObject9.optInt(LogConfig.LOG_GIFT_ID)) : "");
                            jSONObject11.put("from_gongyanfang_page", 0);
                            jSONObject10.putOpt("im", jSONObject11);
                        } catch (JSONException e7) {
                            e7.printStackTrace();
                        } catch (Exception e8) {
                            e8.printStackTrace();
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_LUCKY_BAG, UbcStatConstant.ContentType.UBC_TYPE_LUCKY_BAG, bVar.isHost() ? "author_liveroom" : "liveroom", UbcStatConstant.Value.VALUE_LUCKYBAG_RECEIVE).setContentExt(null, null, jSONObject10));
                        if (z3 || z4) {
                            linkedList.add(bVar);
                        } else {
                            bVar.setMsgType(24);
                        }
                    }
                    if ("luckybag_win_prize".equals(str) && jSONObject9 != null) {
                        JSONObject jSONObject12 = new JSONObject();
                        try {
                            JSONObject jSONObject13 = new JSONObject();
                            jSONObject13.put("content_type", jSONObject9.optString("content_type"));
                            jSONObject13.put("show_own", i2);
                            jSONObject13.put("local_show", i3);
                            jSONObject13.put("is_mine", jSONObject9.optInt("is_mine"));
                            jSONObject13.put("headline_info", jSONObject9.optJSONArray("headline_info") == null ? 0 : 1);
                            jSONObject13.put("im_icon_conf", jSONObject9.optJSONObject("im_icon_conf") == null ? 0 : 1);
                            if (bVar.Lc() != null) {
                                jSONObject13.put("send_uid", TextUtils.isEmpty(bVar.Lc().userId) ? "" : bVar.Lc().userId);
                                jSONObject13.put("cur_uid", TextUtils.isEmpty(bVar.Lc().userId) ? "" : bVar.Lc().userId);
                            }
                            jSONObject13.put("msg_id", bVar.getMsgId());
                            jSONObject13.put("msg_type", bVar.getMsgType());
                            jSONObject13.put(LogConfig.LOG_GIFT_ID, jSONObject9.has(LogConfig.LOG_GIFT_ID) ? Integer.valueOf(jSONObject9.optInt(LogConfig.LOG_GIFT_ID)) : "");
                            jSONObject13.put("from_gongyanfang_page", 0);
                            jSONObject12.putOpt("im", jSONObject13);
                        } catch (JSONException e9) {
                            e9.printStackTrace();
                        } catch (Exception e10) {
                            e10.printStackTrace();
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_LUCKY_BAG, UbcStatConstant.ContentType.UBC_TYPE_LUCKY_BAG, bVar.isHost() ? "author_liveroom" : "liveroom", UbcStatConstant.Value.VALUE_LUCKYBAG_RECEIVE_TOTAL).setContentExt(null, null, jSONObject12));
                        if (z3) {
                            linkedList.add(bVar);
                        }
                    }
                    if (z4 && bVar.getMsgType() == 1 && !ListUtils.isEmpty(bVar.Lc().aHz) && this.aKk == null) {
                        this.aKk = bVar.Lc().aHz;
                    }
                    if (z4 && bVar.getMsgType() == 13 && jSONObject9 != null && jSONObject9.optInt("show_own", 1) == 0 && !str.equals("custom_gift")) {
                        linkedList.add(bVar);
                    }
                }
                if (bVar.getMsgType() == 24) {
                    bVar.aKP = this.aED.aKP;
                    JSONObject jSONObject14 = new JSONObject();
                    try {
                        if (bVar.getObjContent() instanceof JSONObject) {
                            jSONObject4 = (JSONObject) bVar.getObjContent();
                        } else {
                            jSONObject4 = new JSONObject(bVar.getContent());
                        }
                        JSONObject jSONObject15 = new JSONObject();
                        jSONObject15.put("content_type", jSONObject4.optString("content_type"));
                        jSONObject15.put("show_own", i2);
                        jSONObject15.put("local_show", i3);
                        jSONObject15.put("is_mine", jSONObject4.optInt("is_mine"));
                        jSONObject15.put("headline_info", jSONObject4.optJSONArray("headline_info") == null ? 0 : 1);
                        jSONObject15.put("im_icon_conf", jSONObject4.optJSONObject("im_icon_conf") == null ? 0 : 1);
                        if (bVar.Lc() != null) {
                            jSONObject15.put("send_uid", TextUtils.isEmpty(bVar.Lc().userId) ? "" : bVar.Lc().userId);
                            jSONObject15.put("cur_uid", TextUtils.isEmpty(bVar.Lc().userId) ? "" : bVar.Lc().userId);
                        }
                        jSONObject15.put("msg_id", bVar.getMsgId());
                        jSONObject15.put("msg_type", bVar.getMsgType());
                        jSONObject15.put(LogConfig.LOG_GIFT_ID, jSONObject4.has(LogConfig.LOG_GIFT_ID) ? Integer.valueOf(jSONObject4.optInt(LogConfig.LOG_GIFT_ID)) : "");
                        jSONObject15.put("from_gongyanfang_page", 0);
                        jSONObject14.putOpt("im", jSONObject15);
                    } catch (JSONException e11) {
                        e11.printStackTrace();
                    } catch (Exception e12) {
                        e12.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_LUCKY_BAG, UbcStatConstant.ContentType.UBC_TYPE_LUCKY_BAG, bVar.isHost() ? "author_liveroom" : "liveroom", UbcStatConstant.Value.VALUE_LUCKYBAG_OPEN).setContentExt(null, null, jSONObject14));
                }
                if (!z4 && bVar.getMsgType() != 125 && bVar.getMsgType() != 24 && bVar.getMsgType() != 13 && bVar.getMsgType() != 28) {
                    if (bVar.getMsgType() != 1 || !z) {
                        linkedList.add(bVar);
                    }
                } else if (!this.bmq && z4 && bVar.getMsgType() == 24) {
                    try {
                        if (bVar.getObjContent() instanceof JSONObject) {
                            jSONObject2 = (JSONObject) bVar.getObjContent();
                        } else {
                            jSONObject2 = new JSONObject(bVar.getContent());
                        }
                        try {
                            jSONObject2.optString("content_type");
                        } catch (JSONException e13) {
                            e = e13;
                            e.printStackTrace();
                            if (jSONObject2.optInt("from_gongyanfang_page") == 1) {
                            }
                            if (jSONObject2.optInt("from_gongyanfang_2") == 1) {
                            }
                            if (!z2) {
                                linkedList.add(bVar);
                            }
                            JSONObject jSONObject722 = new JSONObject();
                            if (!(bVar.getObjContent() instanceof JSONObject)) {
                            }
                            JSONObject jSONObject822 = new JSONObject();
                            jSONObject822.put("content_type", jSONObject3.optString("content_type"));
                            jSONObject822.put("show_own", i2);
                            jSONObject822.put("local_show", i3);
                            jSONObject822.put("is_mine", jSONObject3.optInt("is_mine"));
                            jSONObject822.put("headline_info", jSONObject3.optJSONArray("headline_info") != null ? 0 : 1);
                            jSONObject822.put("im_icon_conf", jSONObject3.optJSONObject("im_icon_conf") != null ? 0 : 1);
                            if (bVar.Lc() != null) {
                            }
                            jSONObject822.put("msg_id", bVar.getMsgId());
                            jSONObject822.put("msg_type", bVar.getMsgType());
                            jSONObject822.put(LogConfig.LOG_GIFT_ID, !jSONObject3.has(LogConfig.LOG_GIFT_ID) ? Integer.valueOf(jSONObject3.optInt(LogConfig.LOG_GIFT_ID)) : "");
                            jSONObject822.put("from_gongyanfang_page", 0);
                            jSONObject722.putOpt("im", jSONObject822);
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_LUCKY_BAG, UbcStatConstant.ContentType.UBC_FILTER_IM, !bVar.isHost() ? "author_liveroom" : "liveroom", UbcStatConstant.Value.VALUE_FILTER_IM).setContentExt(null, null, jSONObject722));
                        } catch (Exception e14) {
                            e = e14;
                            e.printStackTrace();
                            if (jSONObject2.optInt("from_gongyanfang_page") == 1) {
                            }
                            if (jSONObject2.optInt("from_gongyanfang_2") == 1) {
                            }
                            if (!z2) {
                            }
                            JSONObject jSONObject7222 = new JSONObject();
                            if (!(bVar.getObjContent() instanceof JSONObject)) {
                            }
                            JSONObject jSONObject8222 = new JSONObject();
                            jSONObject8222.put("content_type", jSONObject3.optString("content_type"));
                            jSONObject8222.put("show_own", i2);
                            jSONObject8222.put("local_show", i3);
                            jSONObject8222.put("is_mine", jSONObject3.optInt("is_mine"));
                            jSONObject8222.put("headline_info", jSONObject3.optJSONArray("headline_info") != null ? 0 : 1);
                            jSONObject8222.put("im_icon_conf", jSONObject3.optJSONObject("im_icon_conf") != null ? 0 : 1);
                            if (bVar.Lc() != null) {
                            }
                            jSONObject8222.put("msg_id", bVar.getMsgId());
                            jSONObject8222.put("msg_type", bVar.getMsgType());
                            jSONObject8222.put(LogConfig.LOG_GIFT_ID, !jSONObject3.has(LogConfig.LOG_GIFT_ID) ? Integer.valueOf(jSONObject3.optInt(LogConfig.LOG_GIFT_ID)) : "");
                            jSONObject8222.put("from_gongyanfang_page", 0);
                            jSONObject7222.putOpt("im", jSONObject8222);
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_LUCKY_BAG, UbcStatConstant.ContentType.UBC_FILTER_IM, !bVar.isHost() ? "author_liveroom" : "liveroom", UbcStatConstant.Value.VALUE_FILTER_IM).setContentExt(null, null, jSONObject7222));
                        }
                    } catch (JSONException e15) {
                        e = e15;
                        jSONObject2 = null;
                    } catch (Exception e16) {
                        e = e16;
                        jSONObject2 = null;
                    }
                    boolean z5 = jSONObject2.optInt("from_gongyanfang_page") == 1;
                    boolean z6 = jSONObject2.optInt("from_gongyanfang_2") == 1;
                    if (!z2 && !z5 && !z6) {
                        linkedList.add(bVar);
                    }
                } else if (bVar.getMsgType() == 125) {
                    try {
                        if (!"1".equals(new JSONObject(bVar.getContent()).optString("is_first"))) {
                            linkedList.add(bVar);
                            if (this.blZ != null) {
                                this.blZ.t(bVar);
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
                            JSONObject jSONObject72222 = new JSONObject();
                            if (!(bVar.getObjContent() instanceof JSONObject)) {
                            }
                            JSONObject jSONObject82222 = new JSONObject();
                            jSONObject82222.put("content_type", jSONObject3.optString("content_type"));
                            jSONObject82222.put("show_own", i2);
                            jSONObject82222.put("local_show", i3);
                            jSONObject82222.put("is_mine", jSONObject3.optInt("is_mine"));
                            jSONObject82222.put("headline_info", jSONObject3.optJSONArray("headline_info") != null ? 0 : 1);
                            jSONObject82222.put("im_icon_conf", jSONObject3.optJSONObject("im_icon_conf") != null ? 0 : 1);
                            if (bVar.Lc() != null) {
                            }
                            jSONObject82222.put("msg_id", bVar.getMsgId());
                            jSONObject82222.put("msg_type", bVar.getMsgType());
                            jSONObject82222.put(LogConfig.LOG_GIFT_ID, !jSONObject3.has(LogConfig.LOG_GIFT_ID) ? Integer.valueOf(jSONObject3.optInt(LogConfig.LOG_GIFT_ID)) : "");
                            jSONObject82222.put("from_gongyanfang_page", 0);
                            jSONObject72222.putOpt("im", jSONObject82222);
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_LUCKY_BAG, UbcStatConstant.ContentType.UBC_FILTER_IM, !bVar.isHost() ? "author_liveroom" : "liveroom", UbcStatConstant.Value.VALUE_FILTER_IM).setContentExt(null, null, jSONObject72222));
                        }
                    } catch (JSONException e19) {
                        jSONObject = null;
                    }
                    if (!"enter_live".equals(str2) && this.bmn < this.blW) {
                        if (com.baidu.live.entereffect.a.CY().h(bVar)) {
                            Log.d("EnterEffectManager", "hasEffect");
                        }
                    } else if (!"close_live".equals(str2)) {
                        linkedList.add(bVar);
                        if (this.blZ != null) {
                            this.blZ.t(bVar);
                        }
                    } else if ("task".equals(str2)) {
                        linkedList.add(bVar);
                        if (this.blZ != null) {
                            this.blZ.t(bVar);
                        }
                    } else if ("daily_task_status".equals(str2)) {
                        linkedList.add(bVar);
                        if (this.blZ != null) {
                            this.blZ.t(bVar);
                        }
                    } else if ("live_achievement".equals(str2)) {
                        linkedList.add(bVar);
                        if (this.blZ != null) {
                            this.blZ.t(bVar);
                        }
                    } else if ("ss_hot_live".equals(str2)) {
                        linkedList.add(bVar);
                        if (this.blZ != null) {
                            this.blZ.t(bVar);
                        }
                    } else if ("challenge_direct_new".equals(str2)) {
                        linkedList.add(bVar);
                        if (this.blZ != null) {
                            this.blZ.t(bVar);
                        }
                    } else if ("challenge_random_cancel".equals(str2)) {
                        linkedList.add(bVar);
                        if (this.blZ != null) {
                            this.blZ.t(bVar);
                        }
                    } else if ("update_liveinfo".equals(str2)) {
                        linkedList.add(bVar);
                        if (this.blZ != null) {
                            this.blZ.t(bVar);
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
                        if (z4 && !ListUtils.isEmpty(bVar.Lc().aHz)) {
                            this.aKk = bVar.Lc().aHz;
                            if (this.aED != null) {
                                this.aED.aKk = this.aKk;
                            }
                        }
                    } else if ("live_talk_ban".equals(str2)) {
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                    } else if ("live_talk_remove_ban".equals(str2)) {
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                    } else if ("live_talk_admin_ban".equals(str2)) {
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                    } else if ("live_talk_admin_remove_ban".equals(str2)) {
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                    } else if ("live_on_private".equals(str2)) {
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                    } else if ("challenge_direct_matched".equals(str2)) {
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
                    } else if (TextUtils.equals(str2, UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT)) {
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
                        if (this.blZ != null) {
                            this.blZ.t(bVar);
                        }
                    } else if (TextUtils.equals(str2, "guard_pk_win_tip")) {
                        linkedList.add(bVar);
                        if (this.blZ != null) {
                            this.blZ.t(bVar);
                        }
                    } else if (TextUtils.equals(str2, "fullscreen")) {
                        linkedList.add(bVar);
                        if (this.blZ != null) {
                            this.blZ.t(bVar);
                        }
                    } else if (TextUtils.equals(str2, "challenge_mvp")) {
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, "CONTENT_TYPE_CHALLENGE_MVP");
                    } else if (TextUtils.equals(str2, "challenge_mvp_punish")) {
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, "CONTENT_TYPE_CHALLENGE_MVP_PUNISH");
                    } else if (TextUtils.equals(str2, "challenge_winner_by_autofail")) {
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, "challenge_winner_by_autofail");
                    } else if (TextUtils.equals(str2, "wish_list_finish") || TextUtils.equals(str2, "wish_list_success")) {
                        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                            linkedList.add(bVar);
                        }
                    } else if ("introduce_goods".equals(str2)) {
                        linkedList.add(bVar);
                        if (this.blZ != null) {
                            this.blZ.t(bVar);
                        }
                    } else if ("first_recharge_success".equals(str2)) {
                        linkedList.add(bVar);
                        if (this.blZ != null) {
                            this.blZ.t(bVar);
                        }
                    } else if ("privilege_award_success".equals(str2)) {
                        linkedList.add(bVar);
                        if (this.blZ != null) {
                            this.blZ.t(bVar);
                        }
                    } else if ("need_update_live_mark_info".equals(str2)) {
                        linkedList.add(bVar);
                        if (this.blZ != null) {
                            this.blZ.t(bVar);
                        }
                    } else if ("pk_honor_change".equals(str2) || "pk_invite".equals(str2) || "pk_start".equals(str2) || "pk_start_settle".equals(str2) || "pk_solo_task".equals(str2) || "pk_kill_mode".equals(str2) || "pk_end_settle".equals(str2)) {
                        linkedList.add(bVar);
                        if (this.blZ != null) {
                            this.blZ.t(bVar);
                        }
                    } else if ("official_notice".equals(str2)) {
                        linkedList.add(bVar);
                        if (this.blZ != null && !z) {
                            this.blZ.t(bVar);
                        }
                    } else if (TextUtils.equals(str2, "privilege_award_royal_success")) {
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                    } else if (TextUtils.equals(str2, "remove_video")) {
                        boolean z7 = jSONObject.optInt("is_show_other", 1) == 1;
                        String optString = jSONObject.optString("poke_user_id", "");
                        String optString2 = jSONObject.optString("charm_user_id", "");
                        if (TbadkCoreApplication.getCurrentAccount() == null) {
                            linkedList.add(bVar);
                        }
                        if (TbadkCoreApplication.getCurrentAccount() != null && !TbadkCoreApplication.getCurrentAccount().equals(optString) && !TbadkCoreApplication.getCurrentAccount().equals(optString2) && !z7) {
                            linkedList.add(bVar);
                        }
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, "remove_video");
                    } else if (TextUtils.equals(str2, "live_poke_back")) {
                        boolean z8 = jSONObject.optInt("is_show_other", 1) == 1;
                        String optString3 = jSONObject.optString("poke_user_id", "");
                        String optString4 = jSONObject.optString("charm_user_id", "");
                        if (TbadkCoreApplication.getCurrentAccount() == null) {
                            linkedList.add(bVar);
                        }
                        if (TbadkCoreApplication.getCurrentAccount() != null && !TbadkCoreApplication.getCurrentAccount().equals(optString3) && !TbadkCoreApplication.getCurrentAccount().equals(optString4) && !z8) {
                            linkedList.add(bVar);
                        }
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, "live_poke_back");
                    } else if (TextUtils.equals(str2, "add_tags_to_anchor")) {
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, "add_tags_to_anchor");
                    } else if (TextUtils.equals(str2, "headline_data_im")) {
                        linkedList.add(bVar);
                        if (this.blZ != null) {
                            this.blZ.t(bVar);
                        }
                    } else if (TextUtils.equals(str2, "connect_apply_show_pub")) {
                        linkedList.add(bVar);
                        if (this.blZ != null) {
                            this.blZ.t(bVar);
                        }
                    } else if (TextUtils.equals(str2, "mysterious_man_activate")) {
                        linkedList.add(bVar);
                        if (this.blZ != null) {
                            this.blZ.t(bVar);
                        }
                    } else if (TextUtils.equals(str2, "mysterious_man_expired_remind")) {
                        if (this.blZ != null) {
                            this.blZ.t(bVar);
                        }
                    } else if (TextUtils.equals(str2, "mysterious_man_open_live")) {
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, "mysterious_man_open_live");
                    } else if (TextUtils.equals(str2, "mysterious_man_tip")) {
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, "mysterious_man_tip");
                    } else if ("pub_show".equals(str2)) {
                        linkedList.add(bVar);
                        if (this.blZ != null) {
                            this.blZ.t(bVar);
                        }
                    } else if (TextUtils.equals(str2, "content_text_only")) {
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                    } else {
                        linkedList.add(bVar);
                    }
                } else if (bVar.getMsgType() == 12) {
                    linkedList.add(bVar);
                    if (this.blZ != null) {
                        this.blZ.t(bVar);
                    }
                    hd("push");
                }
                JSONObject jSONObject722222 = new JSONObject();
                try {
                    if (!(bVar.getObjContent() instanceof JSONObject)) {
                        jSONObject3 = (JSONObject) bVar.getObjContent();
                    } else {
                        jSONObject3 = new JSONObject(bVar.getContent());
                    }
                    JSONObject jSONObject822222 = new JSONObject();
                    jSONObject822222.put("content_type", jSONObject3.optString("content_type"));
                    jSONObject822222.put("show_own", i2);
                    jSONObject822222.put("local_show", i3);
                    jSONObject822222.put("is_mine", jSONObject3.optInt("is_mine"));
                    jSONObject822222.put("headline_info", jSONObject3.optJSONArray("headline_info") != null ? 0 : 1);
                    jSONObject822222.put("im_icon_conf", jSONObject3.optJSONObject("im_icon_conf") != null ? 0 : 1);
                    if (bVar.Lc() != null) {
                        jSONObject822222.put("send_uid", TextUtils.isEmpty(bVar.Lc().userId) ? "" : bVar.Lc().userId);
                        jSONObject822222.put("cur_uid", TextUtils.isEmpty(bVar.Lc().userId) ? "" : bVar.Lc().userId);
                    }
                    jSONObject822222.put("msg_id", bVar.getMsgId());
                    jSONObject822222.put("msg_type", bVar.getMsgType());
                    jSONObject822222.put(LogConfig.LOG_GIFT_ID, !jSONObject3.has(LogConfig.LOG_GIFT_ID) ? Integer.valueOf(jSONObject3.optInt(LogConfig.LOG_GIFT_ID)) : "");
                    jSONObject822222.put("from_gongyanfang_page", 0);
                    jSONObject722222.putOpt("im", jSONObject822222);
                } catch (JSONException e20) {
                    e20.printStackTrace();
                } catch (Exception e21) {
                    e21.printStackTrace();
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_LUCKY_BAG, UbcStatConstant.ContentType.UBC_FILTER_IM, !bVar.isHost() ? "author_liveroom" : "liveroom", UbcStatConstant.Value.VALUE_FILTER_IM).setContentExt(null, null, jSONObject722222));
            }
        }
        if (linkedList.size() > 0) {
            list.removeAll(linkedList);
        }
    }

    protected com.baidu.live.im.data.b a(short s, String str, boolean z, boolean z2, int i, List<AlaLiveMarkData> list) {
        long j = 0;
        com.baidu.live.im.data.b JE = JE();
        if (JE == null) {
            return null;
        }
        JE.setMsgType(s);
        JE.setContent(str);
        long aW = o.aW(getLastMid());
        JE.setMsgId(aW);
        JE.setRecordId(aW);
        JE.setTime(System.currentTimeMillis() / 1000);
        com.baidu.live.data.a aVar = new com.baidu.live.data.a();
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            aVar.userName = TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow();
        }
        aVar.userId = TbadkCoreApplication.getCurrentAccount();
        if (this.aED != null && this.aED.aJZ != null && !TextUtils.isEmpty(this.aED.aJZ.portrait)) {
            aVar.portrait = this.aED.aJZ.portrait;
        } else {
            aVar.portrait = TbadkCoreApplication.getCurrentPortrait();
        }
        aVar.level_id = i;
        aVar.aHw = z;
        aVar.aHx = z2;
        if (list != null) {
            aVar.aHz = new ArrayList(list);
        }
        JE.e(aVar);
        try {
            j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        } catch (Exception e) {
        }
        JE.setUserId(j);
        return JE;
    }

    private long getLastMid() {
        if (this.mMsgList == null || this.mMsgList.size() <= 0) {
            return JavaTypesHelper.toLong(this.bma, 1L);
        }
        return this.mMsgList.get(this.mMsgList.size() - 1).getMsgId();
    }

    protected com.baidu.live.im.data.b JE() {
        com.baidu.live.im.a aVar = new com.baidu.live.im.a();
        aVar.setBornTime(System.currentTimeMillis());
        if (TextUtils.isEmpty(this.mGroupId)) {
            return null;
        }
        aVar.hc(this.bmb);
        return aVar;
    }

    public void S(List<AlaLiveMarkData> list) {
        this.aKk = list;
    }

    public void hd(String str) {
        com.baidu.live.message.d dVar = new com.baidu.live.message.d(JavaTypesHelper.toLong(this.mLiveId, 0L), str);
        dVar.setParams();
        sendMessage(dVar);
    }

    public void he(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.bmh)) {
            hd("getliveinfo");
        }
    }

    private List<com.baidu.live.im.data.b> r(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        int optInt;
        String optString;
        boolean Ee;
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
            optString = jSONObject.optString(LogConfig.LOG_GIFT_ID);
            com.baidu.live.gift.g gt = ac.gt(optString);
            Ee = gt != null ? gt.Ee() : false;
        } catch (JSONException e) {
            arrayList.add(aVar);
            com.baidu.live.utils.l.a("", 0L, aVar.getUserId(), aVar.getMsgId());
        }
        if (optInt == 1 || Ee) {
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
            aVar2.hc(aVar.Js());
            aVar2.setBornTime(aVar.getBornTime());
            aVar2.setTime(aVar.getTime());
            aVar2.setUserId(aVar.getUserId());
            aVar2.setToUserId(aVar.getToUserId());
            aVar2.f(aVar.Ld());
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
            aVar2.e(aVar.Lc());
            aVar2.setSt_type(aVar.getSt_type());
            arrayList.add(aVar2);
        }
        com.baidu.live.utils.l.a(optString, optLong, aVar.getUserId(), aVar.getMsgId());
        return arrayList;
    }

    public void t(String str, String str2, String str3) {
        com.baidu.live.im.a aVar = new com.baidu.live.im.a();
        aVar.setMsgType(13);
        aVar.setContent(str3);
        aVar.setBornTime(System.currentTimeMillis());
        aVar.hc(this.bmb);
        com.baidu.live.data.a aVar2 = new com.baidu.live.data.a();
        aVar2.name_show = str;
        aVar2.portrait = str2;
        aVar.e(aVar2);
        a(-1, aVar);
        if (this.blZ != null) {
            this.blZ.d(this.mMsgList, true);
            this.blZ.t(aVar);
        }
    }

    public void a(int i, String str, com.baidu.live.data.a aVar) {
        com.baidu.live.im.data.b JE = JE();
        if (JE != null) {
            JE.setMsgType(i);
            JE.setContent(str);
            JE.e(aVar);
            a(-1, JE);
            if (this.blZ != null) {
                this.blZ.d(this.mMsgList, true);
                this.blZ.t(JE);
            }
        }
    }

    private void b(List<com.baidu.live.im.data.b> list, int i) {
        JSONObject jSONObject;
        int i2;
        if (this.bmq) {
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
                            com.baidu.live.data.a Lc = bVar.Lc();
                            if (Lc == null || StringUtils.isNull(Lc.userId) || StringUtils.isNull(optString)) {
                                if (i >= 0) {
                                    a(i + i4, bVar);
                                } else {
                                    a(-1, bVar);
                                }
                            } else {
                                String str = Lc.userId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + optString + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + Lc.getNameShow();
                                if (this.bmr == null) {
                                    this.bmr = new LinkedHashMap<>();
                                }
                                long j = JavaTypesHelper.toLong(jSONObject.optString("gift_count"), 0L);
                                double optDouble = jSONObject.optDouble("gift_rate", 0.0d);
                                long j2 = JavaTypesHelper.toLong(jSONObject.optString("charm_value"), 0L);
                                h hVar = new h();
                                hVar.boe = bVar;
                                hVar.count = j;
                                hVar.bog = optDouble;
                                hVar.aXc = j2;
                                if (com.baidu.live.ae.a.Qm().bwx == null) {
                                    i2 = 100;
                                } else {
                                    i2 = com.baidu.live.ae.a.Qm().bwx.aOw * 2;
                                }
                                Iterator<String> it = this.bmr.keySet().iterator();
                                int i5 = 0;
                                while (it.hasNext()) {
                                    String next = it.next();
                                    if (this.bmr.get(next) == null || this.bmr.get(next).isEmpty()) {
                                        it.remove();
                                    } else {
                                        HashMap<Long, h> hashMap = this.bmr.get(next);
                                        Iterator<Long> it2 = hashMap.keySet().iterator();
                                        while (it2.hasNext()) {
                                            long longValue = it2.next().longValue();
                                            if (hashMap.get(Long.valueOf(longValue)) == null || hashMap.get(Long.valueOf(longValue)).boj) {
                                                it2.remove();
                                            }
                                        }
                                        if (this.bmr.get(next) == null || this.bmr.get(next).isEmpty()) {
                                            it.remove();
                                        } else {
                                            i5 = hashMap.size() + i5;
                                        }
                                    }
                                }
                                if (i5 > i2) {
                                    int i6 = i5 - ((int) (i2 * 0.7d));
                                    Iterator<String> it3 = this.bmr.keySet().iterator();
                                    while (true) {
                                        int i7 = i6;
                                        if (!it3.hasNext()) {
                                            break;
                                        }
                                        i6 = i7 - this.bmr.get(it3.next()).size();
                                        it3.remove();
                                        if (i6 <= 0) {
                                            break;
                                        }
                                    }
                                }
                                if (!this.bmr.containsKey(str)) {
                                    HashMap<Long, h> hashMap2 = new HashMap<>();
                                    hashMap2.put(Long.valueOf(bVar.getMsgId()), hVar);
                                    this.bmr.put(str, hashMap2);
                                } else {
                                    this.bmr.get(str).put(Long.valueOf(bVar.getMsgId()), hVar);
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
            HashMap<Long, h> hashMap = this.bms.get(str3);
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
                            if (next.bok.contains(l)) {
                                hVar = next;
                                break;
                            }
                        }
                    }
                    if (hVar != null) {
                        long longValue = map.get(l).longValue();
                        if (z) {
                            hVar.bof += longValue;
                        }
                        hVar.boi -= longValue;
                        if (hVar.boj && hVar.boi == 0) {
                            hashMap.remove(Long.valueOf(hVar.aYr));
                            hVar.boe.aX(hVar.count);
                            hVar.boe.h(hVar.bog);
                            hVar.boe.aY(hVar.aXc);
                            a(-1, hVar.boe);
                            if (this.blZ != null) {
                                this.blZ.d(this.mMsgList, true);
                            }
                            long j3 = hVar.bof;
                            if (j3 > 0) {
                                g(j3, hVar.giftName);
                            }
                        }
                    }
                }
                if (hashMap.isEmpty()) {
                    this.bms.remove(str3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(h hVar) {
        JSONObject jSONObject;
        com.baidu.live.im.data.b bVar = hVar.boe;
        if (bVar != null) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pk_honer_buff_multiple", Double.parseDouble(hVar.bol == null ? this.bmi : hVar.bol));
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

    public void cj(boolean z) {
        this.mGroupId = null;
        this.bma = null;
        this.mLiveId = null;
        this.bmh = "0";
        this.mAppId = null;
        this.bml = false;
        this.bmm = false;
        MessageManager.getInstance().unRegisterListener(this.bmF);
        MessageManager.getInstance().unRegisterListener(this.bmE);
        MessageManager.getInstance().unRegisterListener(this.bmw);
        MessageManager.getInstance().unRegisterListener(this.bmz);
        MessageManager.getInstance().unRegisterListener(this.bmA);
        MessageManager.getInstance().unRegisterListener(this.bmB);
        MessageManager.getInstance().unRegisterListener(this.bgW);
        MessageManager.getInstance().unRegisterListener(this.bmC);
        MessageManager.getInstance().unRegisterListener(this.bmD);
        MessageManager.getInstance().unRegisterListener(this.bmx);
        MessageManager.getInstance().unRegisterListener(this.bmH);
        MessageManager.getInstance().unRegisterListener(this.bmI);
        MessageManager.getInstance().unRegisterListener(this.bmJ);
        MessageManager.getInstance().unRegisterListener(this.bmK);
        MessageManager.getInstance().unRegisterListener(this.bmG);
        MessageManager.getInstance().unRegisterListener(this.bgO);
        Jz();
        if (z) {
            MessageManager.getInstance().unRegisterListener(this.syncListener);
            MessageManager.getInstance().unRegisterListener(this.aEM);
        }
        this.mHandler.removeCallbacks(this.bmv);
        this.mHandler.removeCallbacks(this.bmu);
        this.mHandler.removeCallbacks(this.bmy);
        if (this.mMsgList != null) {
            this.mMsgList.clear();
        }
        this.mMsgList = null;
        if (this.bmr != null) {
            this.bmr.clear();
        }
        if (this.bms != null) {
            this.bms.clear();
        }
    }

    private void JF() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021194, TbConfig.SERVER_ADDRESS + "ala/live/checkImBan");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaForbiddenWordsStateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(ImSendMsgData imSendMsgData, boolean z, boolean z2, int i, String str, String[] strArr) {
        if (!TbadkCoreApplication.isLogin()) {
            BdUtilHelper.showToast(this.blX.getPageActivity(), a.h.sdk_not_login);
        } else if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow())) {
            BdUtilHelper.showToast(this.blX.getPageActivity(), a.h.sdk_username_empty);
        } else {
            String str2 = imSendMsgData.text;
            short s = imSendMsgData.msgType;
            com.baidu.live.im.data.b a2 = a(s, str2, z, z2, i, this.aKk);
            if (s == 126) {
                a2.dD(imSendMsgData.barrageType);
                a2.hn(imSendMsgData.barrageId);
                a2.a(imSendMsgData.barrageCardInfo);
            }
            if (a2 != null) {
                a2.l(strArr);
                a(-1, a2);
                if (this.blZ != null) {
                    this.blZ.t(a2);
                    this.blZ.d(this.mMsgList, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913043));
                com.baidu.live.im.message.a aVar = new com.baidu.live.im.message.a(str2, s, JavaTypesHelper.toInt(this.mGroupId, 0), this.mAppId);
                if (this.aED != null && this.aED.mLiveInfo != null) {
                    aVar.setLiveId(this.aED.mLiveInfo.live_id + "");
                    aVar.setRoomId(this.aED.mLiveInfo.room_id + "");
                } else {
                    aVar.setLiveId("");
                    aVar.setRoomId("");
                }
                aVar.setOtherParams(str);
                aVar.aZ(imSendMsgData.price);
                aVar.dD(imSendMsgData.barrageType);
                aVar.hn(imSendMsgData.barrageId);
                aVar.a(imSendMsgData.barrageCardInfo);
                aVar.l(strArr);
                aVar.cq(imSendMsgData.isQuick);
                aVar.ct(imSendMsgData.isQuickBarrage);
                aVar.setText(str2);
                aVar.cr(imSendMsgData.isOut);
                aVar.cs(imSendMsgData.isUseCard);
                sendMessage(aVar);
            }
        }
    }

    public void j(long j, long j2) {
        if (!this.bml) {
            this.bml = true;
            com.baidu.live.im.message.c cVar = new com.baidu.live.im.message.c(1021194);
            cVar.addParam("user_id", j);
            cVar.addParam("live_id", j2);
            cVar.ba(System.currentTimeMillis());
            sendMessage(cVar);
            this.mHandler.postDelayed(this.bmv, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JG() {
        this.bml = false;
        this.bmm = true;
        ImForbiddenStateData imForbiddenStateData = new ImForbiddenStateData();
        imForbiddenStateData.errno = -1;
        imForbiddenStateData.errMsg = this.blX.getString(a.h.sdk_neterror);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, imForbiddenStateData));
    }
}
