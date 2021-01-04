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
import com.baidu.live.data.x;
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
/* loaded from: classes11.dex */
public class d extends BdBaseModel {
    private x aGe;
    private List<AlaLiveMarkData> aLb;
    private boolean aZw;
    private CustomMessageListener bgV;
    private HttpMessageListener bhd;
    public int blR;
    public int blS;
    public int blT;
    BdPageContext<?> blU;
    private boolean blV;
    private a blW;
    private String blX;
    private String blY;
    private List<com.baidu.live.im.data.b> blZ;
    CustomMessageListener bmA;
    CustomMessageListener bmB;
    CustomMessageListener bmC;
    CustomMessageListener bmD;
    CustomMessageListener bmE;
    private HttpMessageListener bmF;
    private int bma;
    private int bmb;
    private int bmc;
    private float bmd;
    private String bme;
    private String bmf;
    private boolean bmg;
    private boolean bmh;
    private int bmi;
    private int bmj;
    private boolean bmk;
    private LinkedHashMap<String, HashMap<Long, h>> bml;
    private HashMap<String, HashMap<Long, h>> bmm;
    private b.a bmn;
    private Runnable bmo;
    private Runnable bmp;
    private CustomMessageListener bmq;
    private CustomMessageListener bmr;
    private Runnable bms;
    private HttpMessageListener bmt;
    private HttpMessageListener bmu;
    private CustomMessageListener bmv;
    private HttpMessageListener bmw;
    private HttpMessageListener bmx;
    private HttpMessageListener bmy;
    private NetMessageListener bmz;
    private long count;
    private String mAppId;
    private String mGroupId;
    private Handler mHandler;
    private String mLiveId;
    private LinkedList<com.baidu.live.im.data.b> mMsgList;
    private HttpMessageListener syncListener;

    /* loaded from: classes11.dex */
    public interface a {
        void Mb();

        void d(List<com.baidu.live.im.data.b> list, boolean z);

        void t(com.baidu.live.im.data.b bVar);
    }

    static /* synthetic */ int h(d dVar) {
        int i = dVar.bmc;
        dVar.bmc = i + 1;
        return i;
    }

    public d(BdPageContext<?> bdPageContext, boolean z, a aVar) {
        super(bdPageContext);
        this.mLiveId = null;
        this.bmd = 1.0f;
        this.mHandler = new Handler();
        this.bme = null;
        this.aZw = false;
        this.bmf = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION;
        this.bmg = false;
        this.bmh = false;
        this.bmj = 0;
        this.bmk = false;
        this.bmn = new b.a() { // from class: com.baidu.live.im.d.1
        };
        this.bmo = new Runnable() { // from class: com.baidu.live.im.d.12
            @Override // java.lang.Runnable
            public void run() {
                int i = d.this.bmc * d.this.bma;
                if (i >= d.this.blZ.size()) {
                    d.this.LX();
                } else if (d.this.bmc >= d.this.bmb - 1) {
                    if (d.this.bmc != d.this.bmb - 1) {
                        d.this.LX();
                        return;
                    }
                    ArrayList arrayList = new ArrayList(d.this.blZ);
                    d.this.N(d.this.b(arrayList.subList(i, arrayList.size()), true));
                    d.h(d.this);
                    d.this.LX();
                } else {
                    ArrayList arrayList2 = new ArrayList(d.this.blZ);
                    if (d.this.bma + i <= arrayList2.size()) {
                        d.this.N(d.this.b(arrayList2.subList(i, d.this.bma + i), true));
                        d.h(d.this);
                        d.this.mHandler.postDelayed(d.this.bmo, 250L);
                        return;
                    }
                    d.this.N(d.this.b(arrayList2.subList(i, arrayList2.size()), true));
                    d.h(d.this);
                    d.this.LX();
                }
            }
        };
        this.bmp = new Runnable() { // from class: com.baidu.live.im.d.17
            @Override // java.lang.Runnable
            public void run() {
                d.this.Ma();
            }
        };
        this.bgV = new CustomMessageListener(2913238) { // from class: com.baidu.live.im.d.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null) {
                    d.this.aZw = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
            }
        };
        this.bmq = new CustomMessageListener(MessageConfig.SOCKET_RECEIVE_MSG) { // from class: com.baidu.live.im.d.19
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.LT();
            }
        };
        this.bmr = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.live.im.d.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        com.baidu.live.im.a aVar2 = new com.baidu.live.im.a();
                        aVar2.setMsgType(27);
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("text", d.this.blU.getString(a.h.sdk_im_offline));
                            jSONObject.put("content_type", "custom_network_change");
                            aVar2.setContent(jSONObject.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        d.this.a(-1, aVar2);
                        if (d.this.blW != null) {
                            d.this.blW.t(aVar2);
                            d.this.blW.d(d.this.mMsgList, true);
                        }
                    } else if (((NetWorkChangedMessage) customResponsedMessage).mLastNetState == 0 && BdNetTypeUtil.isNetWorkAvailable()) {
                        com.baidu.live.im.a aVar3 = new com.baidu.live.im.a();
                        aVar3.setMsgType(27);
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("text", d.this.blU.getString(a.h.sdk_im_online));
                            jSONObject2.put("content_type", "custom_network_change");
                            aVar3.setContent(jSONObject2.toString());
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        d.this.a(-1, aVar3);
                        if (d.this.blW != null) {
                            d.this.blW.t(aVar3);
                            d.this.blW.d(d.this.mMsgList, true);
                        }
                    }
                }
            }
        };
        this.bms = new Runnable() { // from class: com.baidu.live.im.d.21
            @Override // java.lang.Runnable
            public void run() {
                if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().getLastReceDataTime() > 35000) {
                    d.this.LS();
                }
                d.this.LR();
            }
        };
        this.bmt = new HttpMessageListener(1021013) { // from class: com.baidu.live.im.d.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    boolean z2 = false;
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        int error = httpResponsedMessage.getError();
                        if (com.baidu.live.af.a.SE().bwi.aPf == 1) {
                            if (error == 149010) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913070, d.this.blU.getPageActivity().getString(a.h.im_improper_content_tip)));
                                z2 = true;
                            } else if (error == 1202 || error == 1203) {
                                BdUtilHelper.showToast(d.this.blU.getPageActivity(), d.this.blU.getPageActivity().getString(a.h.im_improper_content_tip_net));
                                z2 = true;
                            } else if (error == 1204) {
                                BdUtilHelper.showToast(d.this.blU.getPageActivity(), d.this.blU.getPageActivity().getString(a.h.im_improper_content_tip));
                                z2 = true;
                            }
                        }
                    }
                    if (!z2 && d.this.blW != null) {
                        d.this.blW.Mb();
                    }
                }
            }
        };
        this.bmu = new HttpMessageListener(1021015) { // from class: com.baidu.live.im.d.23
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
                            if (!d.this.bmk) {
                                d.this.g(iVar.aYv, iVar.giftName);
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                        }
                        if (d.this.bmk) {
                            d.this.a(iVar.giftId, iVar.aYv, iVar.aYz, z2, iVar.aYB);
                        }
                    }
                }
            }
        };
        this.bmv = new CustomMessageListener(2913277) { // from class: com.baidu.live.im.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                List<AlaLiveMarkData> list;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913277 && (customResponsedMessage instanceof AlaLocalIMCustomResponseMessage)) {
                    AlaLocalIMCustomResponseMessage alaLocalIMCustomResponseMessage = (AlaLocalIMCustomResponseMessage) customResponsedMessage;
                    d dVar = d.this;
                    short NK = alaLocalIMCustomResponseMessage.NK();
                    String content = alaLocalIMCustomResponseMessage.getContent();
                    boolean isOfficial = alaLocalIMCustomResponseMessage.isOfficial();
                    boolean NU = alaLocalIMCustomResponseMessage.NU();
                    int i = d.this.aGe.isHost ? d.this.aGe.aKu.levelId : d.this.aGe.aKQ.levelId;
                    if (alaLocalIMCustomResponseMessage.NT()) {
                        list = d.this.aLb;
                    } else {
                        list = null;
                    }
                    com.baidu.live.im.data.b a2 = dVar.a(NK, content, isOfficial, NU, i, list);
                    if (a2 != null) {
                        d.this.a(-1, a2);
                        if (d.this.blW != null) {
                            d.this.blW.t(a2);
                            d.this.blW.d(d.this.mMsgList, true);
                        }
                    }
                }
            }
        };
        this.bhd = new HttpMessageListener(1021229) { // from class: com.baidu.live.im.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021229 && (httpResponsedMessage instanceof AlaLuckBagSendHttpResponseMessage)) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof com.baidu.live.gift.m) {
                        com.baidu.live.gift.m mVar = (com.baidu.live.gift.m) orginalMessage;
                        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            if (d.this.bmk) {
                                d.this.a(mVar.giftId, mVar.aYv, mVar.aYz, true, mVar.aYB);
                            }
                            if (!d.this.bmk) {
                                d.this.g(mVar.aYv, mVar.giftName);
                                return;
                            }
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                        if (d.this.bmk) {
                            d.this.a(mVar.giftId, mVar.aYv, mVar.aYz, false, mVar.aYB);
                        }
                        com.baidu.live.im.data.b a2 = d.this.a((AlaLuckBagSendHttpResponseMessage) httpResponsedMessage);
                        if (a2 != null) {
                            d.this.a(-1, a2);
                            if (d.this.blW != null) {
                                d.this.blW.t(a2);
                                d.this.blW.d(d.this.mMsgList, true);
                            }
                        }
                    }
                }
            }
        };
        this.bmw = new HttpMessageListener(1021014) { // from class: com.baidu.live.im.d.4
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
                            if (!d.this.bmk) {
                                d.this.g(pVar.aYv, pVar.giftName);
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                        }
                        if (d.this.bmk) {
                            d.this.a(pVar.giftId, pVar.aYv, pVar.aYz, z2, pVar.aYB);
                        }
                    }
                }
            }
        };
        this.bmx = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.live.im.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                boolean z2;
                boolean z3;
                if (httpResponsedMessage != null) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof com.baidu.live.gift.q) {
                        com.baidu.live.gift.q qVar = (com.baidu.live.gift.q) orginalMessage;
                        if ((httpResponsedMessage instanceof GiftPackageConsumeHttpResponsedMessage) && TextUtils.isEmpty(((GiftPackageConsumeHttpResponsedMessage) httpResponsedMessage).aZz)) {
                            if (!d.this.bmk) {
                                d.this.g(qVar.aZh, qVar.giftName);
                            }
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            if (!d.this.bmk) {
                                d.this.g(qVar.aZh, qVar.giftName);
                            }
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (d.this.bmk) {
                            d.this.a(qVar.giftId, qVar.aZh, qVar.aYz, z3, qVar.aYB);
                        }
                    }
                }
            }
        };
        this.bmy = new HttpMessageListener(1021012) { // from class: com.baidu.live.im.d.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                d.this.a((ResponsedMessage<?>) httpResponsedMessage, false);
            }
        };
        this.bmz = new NetMessageListener(1021050, 601008) { // from class: com.baidu.live.im.d.7
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                JSONObject jSONObject;
                AlaGetLiveStatusHttpResponseMessage alaGetLiveStatusHttpResponseMessage = responsedMessage instanceof AlaGetLiveStatusHttpResponseMessage ? (AlaGetLiveStatusHttpResponseMessage) responsedMessage : null;
                if (alaGetLiveStatusHttpResponseMessage != null && alaGetLiveStatusHttpResponseMessage.bvW != null) {
                    try {
                        jSONObject = new JSONObject(alaGetLiveStatusHttpResponseMessage.bvW);
                    } catch (JSONException e) {
                        jSONObject = null;
                    }
                    if (jSONObject != null) {
                        if (!"backstage_live".equals(jSONObject.optString("content_type"))) {
                            d.this.a(alaGetLiveStatusHttpResponseMessage.bvW, jSONObject, 12, false);
                            return;
                        }
                        String optString = jSONObject.optString("backstage_type");
                        String optString2 = jSONObject.optString("text");
                        if (!TextUtils.isEmpty(optString) && !optString.equals(d.this.bme) && !TextUtils.isEmpty(optString2)) {
                            d.this.a(alaGetLiveStatusHttpResponseMessage.bvW, jSONObject, 13, true);
                            d.this.bme = optString;
                        }
                    }
                }
            }
        };
        this.count = 1L;
        this.bmA = new CustomMessageListener(2913192) { // from class: com.baidu.live.im.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText banlstn sd=" + d.this.aGe);
                if (d.this.aGe != null) {
                    if (d.this.aGe.mLiveInfo.getUserID() == Long.valueOf(TbadkCoreApplication.getCurrentAccount()).longValue()) {
                        Log.i("i", "@@@ localText banlstn own");
                        if (d.this.aGe.aKu != null && d.this.aGe.mLiveInfo != null) {
                            Log.i("i", "@@@ localText banlstn own sdreq");
                            d.this.j(d.this.aGe.aKu.userId, d.this.aGe.mLiveInfo.live_id);
                            return;
                        }
                        return;
                    }
                    Log.i("i", "@@@ localText banlstn oth");
                    if (d.this.aGe.aKQ != null && d.this.aGe.mLiveInfo != null) {
                        Log.i("i", "@@@ localText banlstn oth sdreq");
                        d.this.j(d.this.aGe.aKQ.userId, d.this.aGe.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.live.im.d.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                    AlaSyncHttpResponseMessage alaSyncHttpResponseMessage = (AlaSyncHttpResponseMessage) httpResponsedMessage;
                    if (alaSyncHttpResponseMessage.getError() == 0 && alaSyncHttpResponseMessage.QQ() != null) {
                        d.this.blR = alaSyncHttpResponseMessage.QQ().aPg;
                        d.this.blS = alaSyncHttpResponseMessage.QQ().aPh;
                        d.this.blT = alaSyncHttpResponseMessage.QQ().aPi;
                    }
                }
            }
        };
        this.bmB = new CustomMessageListener(2913185) { // from class: com.baidu.live.im.d.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                h hVar;
                com.baidu.live.im.data.b a2;
                if (d.this.bmk && customResponsedMessage != null && (customResponsedMessage.getData() instanceof h) && (a2 = d.this.a((hVar = (h) customResponsedMessage.getData()))) != null) {
                    double m = d.this.m(a2);
                    a2.setMsgId(0L);
                    a2.setRecordId(0L);
                    com.baidu.live.data.a Nw = a2.Nw();
                    if (Nw != null && !StringUtils.isNull(Nw.userId) && !StringUtils.isNull(hVar.giftId)) {
                        String str = Nw.userId;
                        String nameShow = Nw.getNameShow();
                        String str2 = str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + hVar.giftId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + nameShow;
                        if (d.this.bmm == null) {
                            d.this.bmm = new HashMap();
                        }
                        hVar.bnY = a2;
                        hVar.userId = str;
                        hVar.userName = nameShow;
                        hVar.bob = m;
                        if (d.this.aZw) {
                            d.this.b(hVar);
                        }
                        if (!d.this.bmm.containsKey(str2)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put(Long.valueOf(hVar.aYz), hVar);
                            d.this.bmm.put(str2, hashMap);
                            return;
                        }
                        ((HashMap) d.this.bmm.get(str2)).put(Long.valueOf(hVar.aYz), hVar);
                    }
                }
            }
        };
        this.bmC = new CustomMessageListener(2913184) { // from class: com.baidu.live.im.d.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                    i iVar = (i) customResponsedMessage.getData();
                    if (iVar.boi > 0) {
                        HashMap hashMap = (HashMap) d.this.bml.get(iVar.bey);
                        if (hashMap != null && !hashMap.isEmpty()) {
                            h hVar = (h) hashMap.remove(Long.valueOf(iVar.boi));
                            if (hVar != null) {
                                hVar.boe = true;
                                hVar.bnY.aT(hVar.count);
                                hVar.bnY.n(hVar.bob);
                                if (hVar.bnY.isHost()) {
                                    hVar.bnY.aU(-1L);
                                } else {
                                    hVar.bnY.aU(hVar.boa);
                                }
                                if (!d.this.s(hVar.bnY)) {
                                    d.this.a(-1, hVar.bnY);
                                    if (d.this.blW != null) {
                                        d.this.blW.d(d.this.mMsgList, true);
                                    }
                                }
                            }
                            if (hashMap.isEmpty()) {
                                d.this.bml.remove(iVar.bey);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    HashMap hashMap2 = (HashMap) d.this.bmm.get(iVar.bey);
                    if (hashMap2 != null && !hashMap2.isEmpty()) {
                        h hVar2 = (h) hashMap2.get(Long.valueOf(iVar.bok));
                        if (hVar2 != null) {
                            if (hVar2.bod != 0) {
                                hVar2.boe = true;
                                return;
                            }
                            hashMap2.remove(Long.valueOf(iVar.bok));
                            hVar2.bnY.aT(hVar2.count);
                            hVar2.bnY.n(hVar2.bob);
                            if (hVar2.bnY.isHost()) {
                                hVar2.bnY.aU(-1L);
                            } else {
                                hVar2.bnY.aU(hVar2.boa);
                            }
                            if (!d.this.s(hVar2.bnY)) {
                                d.this.a(-1, hVar2.bnY);
                                if (d.this.blW != null) {
                                    d.this.blW.d(d.this.mMsgList, true);
                                }
                            }
                            long j = hVar2.bnZ;
                            if (j > 0) {
                                d.this.g(j, hVar2.giftName);
                            }
                        }
                        if (hashMap2.isEmpty()) {
                            d.this.bmm.remove(iVar.bey);
                        }
                    }
                }
            }
        };
        this.bmD = new CustomMessageListener(2913183) { // from class: com.baidu.live.im.d.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                    i iVar = (i) customResponsedMessage.getData();
                    if (iVar.boi == 0) {
                        HashMap hashMap = (HashMap) d.this.bmm.get(iVar.bey);
                        if (hashMap != null && !hashMap.isEmpty()) {
                            h hVar = (h) hashMap.get(Long.valueOf(iVar.bok));
                            h hVar2 = (h) hashMap.get(Long.valueOf(iVar.bon));
                            if (hVar != null && hVar2 != null) {
                                hashMap.remove(Long.valueOf(iVar.bon));
                                hVar.count += hVar2.count;
                                hVar.boa += hVar2.boa;
                                hVar.bnZ += hVar2.bnZ;
                                hVar.bod += hVar2.bod;
                                if (hVar.bob != hVar2.bob) {
                                    hVar.bob = 0.0d;
                                }
                                hVar.bof.add(Long.valueOf(hVar2.aYz));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    HashMap hashMap2 = (HashMap) d.this.bml.get(iVar.bey);
                    if (hashMap2 != null && !hashMap2.isEmpty() && iVar.boi != iVar.bol) {
                        h hVar3 = (h) hashMap2.get(Long.valueOf(iVar.boi));
                        h hVar4 = (h) hashMap2.remove(Long.valueOf(iVar.bol));
                        if (hVar3 != null && hVar4 != null) {
                            hVar3.count += hVar4.count;
                            hVar3.boa += hVar4.boa;
                            if (hVar3.bob != hVar4.bob) {
                                hVar3.bob = 0.0d;
                            }
                        }
                    }
                }
            }
        };
        this.bmE = new CustomMessageListener(2913195) { // from class: com.baidu.live.im.d.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                HashMap hashMap;
                h hVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                    i iVar = (i) customResponsedMessage.getData();
                    if (iVar.boi != 0 && (hashMap = (HashMap) d.this.bml.get(iVar.bey)) != null && !hashMap.isEmpty() && (hVar = (h) hashMap.get(Long.valueOf(iVar.boi))) != null) {
                        hVar.count = iVar.boo;
                        hVar.boa = iVar.bop;
                    }
                }
            }
        };
        this.bmF = new HttpMessageListener(1021194) { // from class: com.baidu.live.im.d.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                d.this.bmg = false;
                d.this.mHandler.removeCallbacks(d.this.bmp);
                if (httpResponsedMessage != null) {
                    if (httpResponsedMessage.getOrginalMessage() == null || !(httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.im.message.c) || !((com.baidu.live.im.message.c) httpResponsedMessage.getOrginalMessage()).aX(System.currentTimeMillis())) {
                        if (d.this.bmh) {
                            d.this.bmh = false;
                            return;
                        } else if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            ImForbiddenStateData imForbiddenStateData = new ImForbiddenStateData();
                            imForbiddenStateData.errno = httpResponsedMessage.getError();
                            imForbiddenStateData.errMsg = httpResponsedMessage.getErrorString();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, imForbiddenStateData));
                            return;
                        } else if (httpResponsedMessage instanceof AlaForbiddenWordsStateResponseMessage) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, ((AlaForbiddenWordsStateResponseMessage) httpResponsedMessage).bqQ));
                            return;
                        } else {
                            return;
                        }
                    }
                    d.this.bmh = false;
                }
            }
        };
        this.blR = com.baidu.live.af.a.SE().bwi.aPg;
        this.blS = com.baidu.live.af.a.SE().bwi.aPh;
        this.blT = com.baidu.live.af.a.SE().bwi.aPi;
        this.blU = bdPageContext;
        this.blV = z;
        this.blW = aVar;
        this.mMsgList = new LinkedList<>();
        this.bml = new LinkedHashMap<>();
        this.bmm = new HashMap<>();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913182, Object.class);
        if (runTask != null && runTask.getData() != null) {
            this.bmk = true;
        }
        MessageManager.getInstance().registerTask(LQ());
        com.baidu.live.tieba.f.a.a.a(1021050, "alaim/gmsg/getLiveStatus", AlaGetLiveStatusHttpResponseMessage.class, false, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021012, "alaim/gmsg/getGroupMsg", ALAGroupHttpResponseMessage.class, false, true, true, true);
        LZ();
        registerListener(this.bmF);
        MessageManager.getInstance().registerListener(this.syncListener);
    }

    public void setAlaLiveShowData(x xVar) {
        this.aGe = xVar;
        if (this.aGe != null && this.aGe.mLiveInfo != null) {
            this.bmi = this.aGe.mLiveInfo.audience_count - this.aGe.mLiveInfo.ai_robot_num;
        }
    }

    private HttpMessageTask LQ() {
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
    public void LR() {
        this.mHandler.postDelayed(this.bms, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LS() {
        sendMessage(new com.baidu.live.im.message.b(JavaTypesHelper.toInt(this.mGroupId, 0), getLastMid()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LT() {
        this.mHandler.removeCallbacks(this.bms);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.live.im.data.b a(AlaLuckBagSendHttpResponseMessage alaLuckBagSendHttpResponseMessage) {
        JSONObject jSONObject = new JSONObject();
        try {
            com.baidu.live.gift.m mVar = (com.baidu.live.gift.m) alaLuckBagSendHttpResponseMessage.getmOrginalMessage();
            jSONObject.put("content_type", "luckybag_win_prize");
            jSONObject.put("user_name", "您");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("prize_total_value", alaLuckBagSendHttpResponseMessage.NX());
            jSONObject2.put("lucky_bag_id", alaLuckBagSendHttpResponseMessage.Oa());
            jSONObject2.put("lucky_bag_img", alaLuckBagSendHttpResponseMessage.NY());
            jSONObject2.put("lucky_bag_name", alaLuckBagSendHttpResponseMessage.NZ());
            List<com.baidu.live.im.data.a> NV = alaLuckBagSendHttpResponseMessage.NV();
            if (NV != null && !NV.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (com.baidu.live.im.data.a aVar : NV) {
                    jSONArray.put(aVar.toJson());
                }
                jSONObject2.put("prize_member", jSONArray);
            }
            List<com.baidu.live.im.data.a> NW = alaLuckBagSendHttpResponseMessage.NW();
            if (NW != null && !NW.isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                for (com.baidu.live.im.data.a aVar2 : NW) {
                    jSONArray2.put(aVar2.toJson());
                }
                jSONObject2.put("surprise_prize_member", jSONArray2);
            }
            jSONObject.put("ext_data", jSONObject2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913276, jSONObject));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a((short) 13, jSONObject.toString(), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), this.aLb);
    }

    public void g(long j, String str) {
        if (j == 0) {
            j = 1;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.blU.getString(a.h.sdk_gift);
        }
        com.baidu.live.im.data.b a2 = a((short) 27, String.format(this.blU.getString(a.h.sdk_send_gift_fail), Long.valueOf(j), str), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), this.aLb);
        if (a2 != null) {
            a(-1, a2);
            if (this.blW != null) {
                this.blW.t(a2);
                this.blW.d(this.mMsgList, true);
            }
        }
    }

    public com.baidu.live.im.data.b a(h hVar) {
        JSONObject b2;
        if (hVar == null) {
            return null;
        }
        String str = hVar.count + "";
        String str2 = hVar.giftName;
        if (TextUtils.isEmpty(str)) {
            str = "1";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = this.blU.getString(a.h.sdk_gift);
        }
        if (hVar.boh) {
            b2 = t(hVar.giftId, str, str2);
        } else {
            b2 = b(hVar.giftId, str, str2, 0L, hVar.boc);
        }
        return a((short) 24, b2.toString(), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), this.aLb);
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

    private JSONObject t(String str, String str2, String str3) {
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
        if (this.blW != null) {
            this.blW.t(aVar);
            if (z) {
                this.blW.d(this.mMsgList, true);
            }
        }
    }

    protected void a(ResponsedMessage<?> responsedMessage, boolean z) {
        boolean z2;
        long j;
        List<com.baidu.live.im.data.b> list;
        if (responsedMessage instanceof ALAGroupHttpResponseMessage) {
            list = ((ALAGroupHttpResponseMessage) responsedMessage).NS();
            j = ((ALAGroupHttpResponseMessage) responsedMessage).getGroupId();
            z2 = ((ALAGroupHttpResponseMessage) responsedMessage).NR();
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
            if (this.bmb != 0) {
                int i2 = this.bmc * this.bma;
                ArrayList arrayList = new ArrayList(this.blZ);
                d(0, arrayList.subList(i2, arrayList.size()));
                LX();
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
        if (this.bml != null) {
            this.bml.clear();
        }
        if (this.bmm != null) {
            this.bmm.clear();
        }
        this.mMsgList = new LinkedList<>();
        this.mGroupId = str;
        this.blX = str2;
        this.blY = str3;
        this.mLiveId = str4;
        this.bme = "0";
        this.mAppId = str5;
        MessageManager.getInstance().registerListener(this.bmy);
        MessageManager.getInstance().registerListener(this.bmz);
        MessageManager.getInstance().registerListener(this.bmq);
        MessageManager.getInstance().registerListener(this.bmt);
        MessageManager.getInstance().registerListener(this.bmr);
        MessageManager.getInstance().registerListener(this.bmu);
        MessageManager.getInstance().registerListener(this.bmv);
        MessageManager.getInstance().registerListener(this.bhd);
        MessageManager.getInstance().registerListener(this.bmw);
        MessageManager.getInstance().registerListener(this.bmx);
        MessageManager.getInstance().registerListener(this.bmB);
        MessageManager.getInstance().registerListener(this.bmC);
        MessageManager.getInstance().registerListener(this.bmD);
        MessageManager.getInstance().registerListener(this.bmE);
        MessageManager.getInstance().registerListener(this.bmA);
        MessageManager.getInstance().registerListener(this.bgV);
        if (BdSocketLinkService.isClose()) {
            LS();
            BdSocketLinkService.startService(true, "live start");
        }
        String str6 = com.baidu.live.af.a.SE().bwi.aMB;
        if (!TextUtils.isEmpty(str6)) {
            com.baidu.live.im.data.b LY = LY();
            LY.setMsgType(27);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("text", str6);
                jSONObject.put("content_type", "custom_live_notice");
                LY.setContent(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            a(-1, LY);
            if (this.blW != null) {
                this.blW.t(LY);
            }
        }
        String str7 = com.baidu.live.af.a.SE().bwi.aMC;
        if (!TextUtils.isEmpty(str7)) {
            com.baidu.live.im.data.b LY2 = LY();
            LY2.setMsgType(27);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("text", str7);
                jSONObject2.put("content_type", "custom_live_notice");
                LY2.setContent(jSONObject2.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            a(-1, LY2);
        }
        List<String> list = com.baidu.live.af.a.SE().bwi.aMA;
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
                    com.baidu.live.im.data.b LY3 = LY();
                    LY3.setMsgType(27);
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("text", str8);
                        jSONObject3.put("content_type", "custom_im_notice");
                        LY3.setContent(jSONObject3.toString());
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                    LY3.setLink(str9);
                    a(-1, LY3);
                    if (this.blW != null) {
                        this.blW.t(LY3);
                    }
                }
                i = i2 + 2;
            }
        }
        if (this.aGe != null && this.aGe.aLi != null && !StringUtils.isNull(this.aGe.aLi.Ep())) {
            com.baidu.live.im.data.b LY4 = LY();
            LY4.setMsgType(27);
            try {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("text", this.aGe.aLi.Ep());
                jSONObject4.put("content_type", "live_notice_quick_chat");
                jSONObject4.put("anchorName", this.aGe.aKu.userName);
                LY4.setContent(jSONObject4.toString());
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            this.mMsgList.add(LY4);
            if (this.blW != null) {
                this.blW.t(LY4);
            }
        }
        LV();
        LU();
        if (this.mMsgList.size() > 0 && this.blW != null) {
            this.blW.d(this.mMsgList, true);
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGmsgGetLiveStatusUnabled()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.d.8
                @Override // java.lang.Runnable
                public void run() {
                    d.this.hK("enter");
                }
            }, 1000L);
        }
        LR();
        if (TbadkCoreApplication.getInst().isOther()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913146, this.mMsgList));
        }
    }

    private void LU() {
        String str = com.baidu.live.af.a.SE().bwi.aMD;
        if (str != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    com.baidu.live.im.data.b LY = LY();
                    LY.setMsgType(27);
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    JSONObject jSONObject2 = new JSONObject();
                    if (jSONObject.optInt("open") != 0) {
                        jSONObject2.put("text", jSONObject.toString());
                        jSONObject2.put("content_type", "activity_notice");
                        LY.setContent(jSONObject2.toString());
                        this.mMsgList.add(LY);
                        if (this.blW != null) {
                            this.blW.t(LY);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void LV() {
        if (LW()) {
            com.baidu.live.im.data.b LY = LY();
            LY.setMsgType(27);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("text", com.baidu.live.af.a.SE().bwi.aPc.aKG);
                jSONObject.put("content_type", "custom_im_notice_live_assistant");
                LY.setContent(jSONObject.toString());
                LY.setLink(com.baidu.live.af.a.SE().bwi.aPc.aKF);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mMsgList.add(LY);
            if (this.blW != null) {
                this.blW.t(LY);
            }
        }
    }

    private boolean LW() {
        return (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) || !TbadkCoreApplication.getCurrentAccount().equals(this.blY) || com.baidu.live.af.a.SE().bwi == null || com.baidu.live.af.a.SE().bwi.aPc == null || TextUtils.isEmpty(com.baidu.live.af.a.SE().bwi.aPc.aKG)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(List<com.baidu.live.im.data.b> list) {
        if (list != null && this.blW != null) {
            this.blW.d(this.mMsgList, true);
            for (com.baidu.live.im.data.b bVar : list) {
                this.blW.t(bVar);
            }
        }
    }

    protected void O(List<com.baidu.live.im.data.b> list) {
        this.blZ = list;
        this.bmb = (int) ((this.bmd * 2.0f) / 0.25f);
        this.bmc = 0;
        this.bma = list.size() / this.bmb;
        if (this.bma <= 0) {
            this.bma = 1;
        }
        this.mHandler.removeCallbacks(this.bmo);
        this.mHandler.postDelayed(this.bmo, 250L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LX() {
        this.mHandler.removeCallbacks(this.bmo);
        this.bmc = 0;
        this.bmb = 0;
        this.bma = 0;
        this.blZ = null;
    }

    protected List<com.baidu.live.im.data.b> b(List<com.baidu.live.im.data.b> list, boolean z) {
        return a(list, z, false);
    }

    protected List<com.baidu.live.im.data.b> a(List<com.baidu.live.im.data.b> list, boolean z, boolean z2) {
        for (com.baidu.live.im.data.b bVar : list) {
            if (bVar instanceof com.baidu.live.im.a) {
                ((com.baidu.live.im.a) bVar).hJ(this.blY);
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
            c(z2, list);
            if (!z2) {
                P(list);
            }
            if (z2 && this.mMsgList.size() > 2) {
                b(list, 2);
            } else {
                b(list, -1);
            }
        }
        if (this.mMsgList.size() > com.baidu.live.af.a.SE().bwi.aOQ) {
            int i = (int) (com.baidu.live.af.a.SE().bwi.aOQ * 0.7d);
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
        JSONObject jSONObject;
        List<AlaLiveMarkData> list;
        boolean z = false;
        com.baidu.live.data.a Nw = bVar.Nw();
        if (Nw != null && (list = Nw.aIZ) != null && !list.isEmpty()) {
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
            d = com.baidu.live.af.f.SV().i(z, jSONObject.optString(LogConfig.LOG_GIFT_ID));
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

    private void c(boolean z, List<com.baidu.live.im.data.b> list) {
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
        if ((bVar instanceof com.baidu.live.im.a) && bVar.Nw() != null && TextUtils.equals(bVar.Nw().userId, TbadkCoreApplication.getCurrentAccount())) {
            z = true;
        }
        if (this.bmi < this.blR) {
            if (i >= 0) {
                this.mMsgList.add(i, bVar);
            } else {
                this.mMsgList.addLast(bVar);
            }
        } else if (this.bmi >= this.blR && this.bmi < this.blS) {
            if (q(bVar) && !z) {
                bVar.NI();
            }
            if (i >= 0) {
                this.mMsgList.add(i, bVar);
            } else if (!this.mMsgList.isEmpty() && q(this.mMsgList.getLast())) {
                if (!this.mMsgList.getLast().Nw().userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.mMsgList.set(this.mMsgList.size() - 1, bVar);
                } else {
                    this.mMsgList.addLast(bVar);
                }
            } else {
                this.mMsgList.addLast(bVar);
            }
        } else if (this.bmi >= this.blS && this.bmi < this.blT) {
            if (o(bVar) && !z) {
                bVar.NI();
            }
            if (i >= 0) {
                this.mMsgList.add(i, bVar);
            } else if (!this.mMsgList.isEmpty() && o(this.mMsgList.getLast())) {
                if (!this.mMsgList.getLast().Nw().userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.mMsgList.set(this.mMsgList.size() - 1, bVar);
                } else {
                    this.mMsgList.addLast(bVar);
                }
            } else {
                this.mMsgList.addLast(bVar);
            }
        } else if (this.bmi >= this.blT) {
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
        this.bmj = 0;
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
                if (com.baidu.live.entereffect.a.FB().h(bVar)) {
                    this.bmj = 2;
                } else {
                    this.bmj = 1;
                }
            } else {
                this.bmj = 0;
            }
        }
        return this.bmj;
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
                    if (bVar != null && bVar.Nw() != null && !TextUtils.isEmpty(bVar.Nw().userId) && bVar.Nw().userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        int i2 = size - 1;
                        while (true) {
                            if (i2 >= 0 && i2 >= 0) {
                                com.baidu.live.im.data.b bVar2 = list.get(i2);
                                if (bVar2 != null && bVar2.Nw() != null && !TextUtils.isEmpty(bVar2.Nw().userId) && bVar2.Nw().userId.equals(TbadkCoreApplication.getCurrentAccount()) && bVar.getRecordId() == bVar2.getRecordId()) {
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

    /* JADX WARN: Removed duplicated region for block: B:118:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0553  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x058c A[Catch: JSONException -> 0x0e68, Exception -> 0x0e6e, TryCatch #20 {JSONException -> 0x0e68, Exception -> 0x0e6e, blocks: (B:150:0x0584, B:152:0x058c, B:153:0x0593, B:156:0x05cb, B:159:0x05db, B:161:0x0616, B:162:0x0621, B:558:0x0e51), top: B:590:0x0584 }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x05ca  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x05da  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0616 A[Catch: JSONException -> 0x0e68, Exception -> 0x0e6e, TryCatch #20 {JSONException -> 0x0e68, Exception -> 0x0e6e, blocks: (B:150:0x0584, B:152:0x058c, B:153:0x0593, B:156:0x05cb, B:159:0x05db, B:161:0x0616, B:162:0x0621, B:558:0x0e51), top: B:590:0x0584 }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0643  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0705 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x072e  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0739  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x073c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x075b  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x075d  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x079b  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x07f2  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0804  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:558:0x0e51 A[Catch: JSONException -> 0x0e68, Exception -> 0x0e6e, TRY_ENTER, TryCatch #20 {JSONException -> 0x0e68, Exception -> 0x0e6e, blocks: (B:150:0x0584, B:152:0x058c, B:153:0x0593, B:156:0x05cb, B:159:0x05db, B:161:0x0616, B:162:0x0621, B:558:0x0e51), top: B:590:0x0584 }] */
    /* JADX WARN: Removed duplicated region for block: B:559:0x0e5d  */
    /* JADX WARN: Removed duplicated region for block: B:560:0x0e60  */
    /* JADX WARN: Removed duplicated region for block: B:561:0x0e63  */
    /* JADX WARN: Removed duplicated region for block: B:567:0x0e74  */
    /* JADX WARN: Removed duplicated region for block: B:586:0x0767 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
            if (!ListUtils.isEmpty(bVar.Ny()) && !bVar.Ny().contains(Long.valueOf(currentAccountId))) {
                linkedList.add(bVar);
            } else {
                boolean z2 = false;
                int i2 = 0;
                int i3 = 0;
                boolean z3 = this.aGe.aLE;
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
                                if (!this.bmk) {
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
                                jSONObject8.put("send_uid", bVar.Nw().userId);
                                jSONObject8.put("cur_uid", bVar.Nw().userId);
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
                                if (!this.bmk) {
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
                                jSONObject82.put("send_uid", bVar.Nw().userId);
                                jSONObject82.put("cur_uid", bVar.Nw().userId);
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
                            jSONObject11.put("send_uid", bVar.Nw().userId);
                            jSONObject11.put("cur_uid", bVar.Nw().userId);
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
                            jSONObject13.put("send_uid", bVar.Nw().userId);
                            jSONObject13.put("cur_uid", bVar.Nw().userId);
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
                    if (z4 && bVar.getMsgType() == 1 && !ListUtils.isEmpty(bVar.Nw().aIZ) && this.aLb == null) {
                        this.aLb = bVar.Nw().aIZ;
                    }
                    if (z4 && bVar.getMsgType() == 13 && jSONObject9 != null && jSONObject9.optInt("show_own", 1) == 0 && !str.equals("custom_gift")) {
                        linkedList.add(bVar);
                    }
                }
                if (bVar.getMsgType() == 24) {
                    bVar.aLE = this.aGe.aLE;
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
                        jSONObject15.put("send_uid", bVar.Nw().userId);
                        jSONObject15.put("cur_uid", bVar.Nw().userId);
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
                } else if (!this.bmk && z4 && bVar.getMsgType() == 24) {
                    try {
                        if (bVar.getObjContent() instanceof JSONObject) {
                            jSONObject2 = (JSONObject) bVar.getObjContent();
                        } else {
                            jSONObject2 = new JSONObject(bVar.getContent());
                        }
                    } catch (JSONException e13) {
                        e = e13;
                        jSONObject2 = null;
                    } catch (Exception e14) {
                        e = e14;
                        jSONObject2 = null;
                    }
                    try {
                        jSONObject2.optString("content_type");
                    } catch (JSONException e15) {
                        e = e15;
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
                        jSONObject822.put("send_uid", bVar.Nw().userId);
                        jSONObject822.put("cur_uid", bVar.Nw().userId);
                        jSONObject822.put("msg_id", bVar.getMsgId());
                        jSONObject822.put("msg_type", bVar.getMsgType());
                        jSONObject822.put(LogConfig.LOG_GIFT_ID, !jSONObject3.has(LogConfig.LOG_GIFT_ID) ? Integer.valueOf(jSONObject3.optInt(LogConfig.LOG_GIFT_ID)) : "");
                        jSONObject822.put("from_gongyanfang_page", 0);
                        jSONObject722.putOpt("im", jSONObject822);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_LUCKY_BAG, UbcStatConstant.ContentType.UBC_FILTER_IM, !bVar.isHost() ? "author_liveroom" : "liveroom", UbcStatConstant.Value.VALUE_FILTER_IM).setContentExt(null, null, jSONObject722));
                    } catch (Exception e16) {
                        e = e16;
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
                        jSONObject8222.put("send_uid", bVar.Nw().userId);
                        jSONObject8222.put("cur_uid", bVar.Nw().userId);
                        jSONObject8222.put("msg_id", bVar.getMsgId());
                        jSONObject8222.put("msg_type", bVar.getMsgType());
                        jSONObject8222.put(LogConfig.LOG_GIFT_ID, !jSONObject3.has(LogConfig.LOG_GIFT_ID) ? Integer.valueOf(jSONObject3.optInt(LogConfig.LOG_GIFT_ID)) : "");
                        jSONObject8222.put("from_gongyanfang_page", 0);
                        jSONObject7222.putOpt("im", jSONObject8222);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_LUCKY_BAG, UbcStatConstant.ContentType.UBC_FILTER_IM, !bVar.isHost() ? "author_liveroom" : "liveroom", UbcStatConstant.Value.VALUE_FILTER_IM).setContentExt(null, null, jSONObject7222));
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
                            if (this.blW != null) {
                                this.blW.t(bVar);
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
                    } catch (JSONException e18) {
                        jSONObject = null;
                    }
                    try {
                        str2 = jSONObject.optString("content_type");
                    } catch (JSONException e19) {
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
                        jSONObject82222.put("send_uid", bVar.Nw().userId);
                        jSONObject82222.put("cur_uid", bVar.Nw().userId);
                        jSONObject82222.put("msg_id", bVar.getMsgId());
                        jSONObject82222.put("msg_type", bVar.getMsgType());
                        jSONObject82222.put(LogConfig.LOG_GIFT_ID, !jSONObject3.has(LogConfig.LOG_GIFT_ID) ? Integer.valueOf(jSONObject3.optInt(LogConfig.LOG_GIFT_ID)) : "");
                        jSONObject82222.put("from_gongyanfang_page", 0);
                        jSONObject72222.putOpt("im", jSONObject82222);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_LUCKY_BAG, UbcStatConstant.ContentType.UBC_FILTER_IM, !bVar.isHost() ? "author_liveroom" : "liveroom", UbcStatConstant.Value.VALUE_FILTER_IM).setContentExt(null, null, jSONObject72222));
                    }
                    if (!"enter_live".equals(str2) && this.bmi < this.blT) {
                        if (com.baidu.live.entereffect.a.FB().h(bVar)) {
                        }
                    } else if (!"close_live".equals(str2)) {
                        linkedList.add(bVar);
                        if (this.blW != null) {
                            this.blW.t(bVar);
                        }
                    } else if ("task".equals(str2)) {
                        linkedList.add(bVar);
                        if (this.blW != null) {
                            this.blW.t(bVar);
                        }
                    } else if ("daily_task_status".equals(str2)) {
                        linkedList.add(bVar);
                        if (this.blW != null) {
                            this.blW.t(bVar);
                        }
                    } else if ("live_achievement".equals(str2)) {
                        linkedList.add(bVar);
                        if (this.blW != null) {
                            this.blW.t(bVar);
                        }
                    } else if ("ss_hot_live".equals(str2)) {
                        linkedList.add(bVar);
                        if (this.blW != null) {
                            this.blW.t(bVar);
                        }
                    } else if ("challenge_direct_new".equals(str2)) {
                        linkedList.add(bVar);
                        if (this.blW != null) {
                            this.blW.t(bVar);
                        }
                    } else if ("challenge_random_cancel".equals(str2)) {
                        linkedList.add(bVar);
                        if (this.blW != null) {
                            this.blW.t(bVar);
                        }
                    } else if ("update_liveinfo".equals(str2)) {
                        linkedList.add(bVar);
                        if (this.blW != null) {
                            this.blW.t(bVar);
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
                        if (z4 && !ListUtils.isEmpty(bVar.Nw().aIZ)) {
                            this.aLb = bVar.Nw().aIZ;
                            if (this.aGe != null) {
                                this.aGe.aLb = this.aLb;
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
                            if (this.blW != null) {
                                this.blW.t(bVar);
                            }
                        } else if (TextUtils.equals(str2, "guard_pk_win_tip")) {
                            linkedList.add(bVar);
                            if (this.blW != null) {
                                this.blW.t(bVar);
                            }
                        } else if (TextUtils.equals(str2, "fullscreen")) {
                            linkedList.add(bVar);
                            if (this.blW != null) {
                                this.blW.t(bVar);
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
                                if (this.blW != null) {
                                    this.blW.t(bVar);
                                }
                            } else if ("first_recharge_success".equals(str2)) {
                                linkedList.add(bVar);
                                if (this.blW != null) {
                                    this.blW.t(bVar);
                                }
                            } else if ("privilege_award_success".equals(str2)) {
                                linkedList.add(bVar);
                                if (this.blW != null) {
                                    this.blW.t(bVar);
                                }
                            } else if ("need_update_live_mark_info".equals(str2)) {
                                linkedList.add(bVar);
                                if (this.blW != null) {
                                    this.blW.t(bVar);
                                }
                            } else if ("pk_honor_change".equals(str2) || "pk_invite".equals(str2) || "pk_start".equals(str2) || "pk_start_settle".equals(str2) || "pk_end_settle".equals(str2)) {
                                linkedList.add(bVar);
                                if (this.blW != null) {
                                    this.blW.t(bVar);
                                }
                            } else if ("official_notice".equals(str2)) {
                                linkedList.add(bVar);
                                if (this.blW != null && !z) {
                                    this.blW.t(bVar);
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
                            } else if (!TextUtils.equals(str2, "add_tags_to_anchor")) {
                                if (TextUtils.equals(str2, "headline_data_im")) {
                                    linkedList.add(bVar);
                                    if (this.blW != null) {
                                        this.blW.t(bVar);
                                    }
                                } else if (TextUtils.equals(str2, "connect_apply_show_pub")) {
                                    linkedList.add(bVar);
                                    if (this.blW != null) {
                                        this.blW.t(bVar);
                                    }
                                } else if (TextUtils.equals(str2, "mysterious_man_activate")) {
                                    linkedList.add(bVar);
                                    if (this.blW != null) {
                                        this.blW.t(bVar);
                                    }
                                } else if (TextUtils.equals(str2, "mysterious_man_expired_remind")) {
                                    if (this.blW != null) {
                                        this.blW.t(bVar);
                                    }
                                } else if (TextUtils.equals(str2, "mysterious_man_open_live")) {
                                    Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, "mysterious_man_open_live");
                                } else if (TextUtils.equals(str2, "mysterious_man_tip")) {
                                    Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, "mysterious_man_tip");
                                } else {
                                    linkedList.add(bVar);
                                }
                            }
                        }
                    }
                } else if (bVar.getMsgType() == 12) {
                    linkedList.add(bVar);
                    if (this.blW != null) {
                        this.blW.t(bVar);
                    }
                    hK("push");
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
                    jSONObject822222.put("send_uid", bVar.Nw().userId);
                    jSONObject822222.put("cur_uid", bVar.Nw().userId);
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
        com.baidu.live.im.data.b LY = LY();
        if (LY == null) {
            return null;
        }
        LY.setMsgType(s);
        LY.setContent(str);
        long aS = o.aS(getLastMid());
        LY.setMsgId(aS);
        LY.setRecordId(aS);
        LY.setTime(System.currentTimeMillis() / 1000);
        com.baidu.live.data.a aVar = new com.baidu.live.data.a();
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            aVar.userName = TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow();
        }
        aVar.userId = TbadkCoreApplication.getCurrentAccount();
        if (this.aGe != null && this.aGe.aKQ != null && !TextUtils.isEmpty(this.aGe.aKQ.portrait)) {
            aVar.portrait = this.aGe.aKQ.portrait;
        } else {
            aVar.portrait = TbadkCoreApplication.getCurrentPortrait();
        }
        aVar.level_id = i;
        aVar.aIW = z;
        aVar.aIX = z2;
        if (list != null) {
            aVar.aIZ = new ArrayList(list);
        }
        LY.e(aVar);
        try {
            j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        } catch (Exception e) {
        }
        LY.setUserId(j);
        return LY;
    }

    private long getLastMid() {
        if (this.mMsgList == null || this.mMsgList.size() <= 0) {
            return JavaTypesHelper.toLong(this.blX, 1L);
        }
        return this.mMsgList.get(this.mMsgList.size() - 1).getMsgId();
    }

    protected com.baidu.live.im.data.b LY() {
        com.baidu.live.im.a aVar = new com.baidu.live.im.a();
        aVar.setBornTime(System.currentTimeMillis());
        if (TextUtils.isEmpty(this.mGroupId)) {
            return null;
        }
        aVar.hJ(this.blY);
        return aVar;
    }

    public void R(List<AlaLiveMarkData> list) {
        this.aLb = list;
    }

    public void hK(String str) {
        com.baidu.live.message.d dVar = new com.baidu.live.message.d(JavaTypesHelper.toLong(this.mLiveId, 0L), str);
        dVar.setParams();
        sendMessage(dVar);
    }

    public void hL(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.bme)) {
            hK("getliveinfo");
        }
    }

    private List<com.baidu.live.im.data.b> r(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        int optInt;
        String optString;
        boolean GG;
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
            com.baidu.live.gift.g hc = ac.hc(optString);
            GG = hc != null ? hc.GG() : false;
        } catch (JSONException e) {
            arrayList.add(aVar);
            com.baidu.live.utils.l.a("", 0L, aVar.getUserId(), aVar.getMsgId());
        }
        if (optInt == 1 || GG) {
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
            aVar2.hJ(aVar.LO());
            aVar2.setBornTime(aVar.getBornTime());
            aVar2.setTime(aVar.getTime());
            aVar2.setUserId(aVar.getUserId());
            aVar2.setToUserId(aVar.getToUserId());
            aVar2.f(aVar.Nx());
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
            aVar2.e(aVar.Nw());
            aVar2.setSt_type(aVar.getSt_type());
            arrayList.add(aVar2);
        }
        com.baidu.live.utils.l.a(optString, optLong, aVar.getUserId(), aVar.getMsgId());
        return arrayList;
    }

    public void a(int i, String str, com.baidu.live.data.a aVar) {
        com.baidu.live.im.data.b LY = LY();
        if (LY != null) {
            LY.setMsgType(i);
            LY.setContent(str);
            LY.e(aVar);
            a(-1, LY);
            if (this.blW != null) {
                this.blW.d(this.mMsgList, true);
                this.blW.t(LY);
            }
        }
    }

    private void b(List<com.baidu.live.im.data.b> list, int i) {
        JSONObject jSONObject;
        int i2;
        if (this.bmk) {
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
                            com.baidu.live.data.a Nw = bVar.Nw();
                            if (Nw == null || StringUtils.isNull(Nw.userId) || StringUtils.isNull(optString)) {
                                if (i >= 0) {
                                    a(i + i4, bVar);
                                } else {
                                    a(-1, bVar);
                                }
                            } else {
                                String str = Nw.userId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + optString + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + Nw.getNameShow();
                                if (this.bml == null) {
                                    this.bml = new LinkedHashMap<>();
                                }
                                long j = JavaTypesHelper.toLong(jSONObject.optString("gift_count"), 0L);
                                double optDouble = jSONObject.optDouble("gift_rate", 0.0d);
                                long j2 = JavaTypesHelper.toLong(jSONObject.optString("charm_value"), 0L);
                                h hVar = new h();
                                hVar.bnY = bVar;
                                hVar.count = j;
                                hVar.bob = optDouble;
                                hVar.boa = j2;
                                if (com.baidu.live.af.a.SE().bwi == null) {
                                    i2 = 100;
                                } else {
                                    i2 = com.baidu.live.af.a.SE().bwi.aOW * 2;
                                }
                                Iterator<String> it = this.bml.keySet().iterator();
                                int i5 = 0;
                                while (it.hasNext()) {
                                    String next = it.next();
                                    if (this.bml.get(next) == null || this.bml.get(next).isEmpty()) {
                                        it.remove();
                                    } else {
                                        HashMap<Long, h> hashMap = this.bml.get(next);
                                        Iterator<Long> it2 = hashMap.keySet().iterator();
                                        while (it2.hasNext()) {
                                            long longValue = it2.next().longValue();
                                            if (hashMap.get(Long.valueOf(longValue)) == null || hashMap.get(Long.valueOf(longValue)).boe) {
                                                it2.remove();
                                            }
                                        }
                                        if (this.bml.get(next) == null || this.bml.get(next).isEmpty()) {
                                            it.remove();
                                        } else {
                                            i5 = hashMap.size() + i5;
                                        }
                                    }
                                }
                                if (i5 > i2) {
                                    int i6 = i5 - ((int) (i2 * 0.7d));
                                    Iterator<String> it3 = this.bml.keySet().iterator();
                                    while (true) {
                                        int i7 = i6;
                                        if (!it3.hasNext()) {
                                            break;
                                        }
                                        i6 = i7 - this.bml.get(it3.next()).size();
                                        it3.remove();
                                        if (i6 <= 0) {
                                            break;
                                        }
                                    }
                                }
                                if (!this.bml.containsKey(str)) {
                                    HashMap<Long, h> hashMap2 = new HashMap<>();
                                    hashMap2.put(Long.valueOf(bVar.getMsgId()), hVar);
                                    this.bml.put(str, hashMap2);
                                } else {
                                    this.bml.get(str).put(Long.valueOf(bVar.getMsgId()), hVar);
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
            HashMap<Long, h> hashMap = this.bmm.get(str3);
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
                            if (next.bof.contains(l)) {
                                hVar = next;
                                break;
                            }
                        }
                    }
                    if (hVar != null) {
                        long longValue = map.get(l).longValue();
                        if (z) {
                            hVar.bnZ += longValue;
                        }
                        hVar.bod -= longValue;
                        if (hVar.boe && hVar.bod == 0) {
                            hashMap.remove(Long.valueOf(hVar.aYz));
                            hVar.bnY.aT(hVar.count);
                            hVar.bnY.n(hVar.bob);
                            hVar.bnY.aU(hVar.boa);
                            a(-1, hVar.bnY);
                            if (this.blW != null) {
                                this.blW.d(this.mMsgList, true);
                            }
                            long j3 = hVar.bnZ;
                            if (j3 > 0) {
                                g(j3, hVar.giftName);
                            }
                        }
                    }
                }
                if (hashMap.isEmpty()) {
                    this.bmm.remove(str3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(h hVar) {
        JSONObject jSONObject;
        com.baidu.live.im.data.b bVar = hVar.bnY;
        if (bVar != null) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pk_honer_buff_multiple", Double.parseDouble(hVar.bog == null ? this.bmf : hVar.bog));
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
        this.blX = null;
        this.mLiveId = null;
        this.bme = "0";
        this.mAppId = null;
        this.bmg = false;
        this.bmh = false;
        MessageManager.getInstance().unRegisterListener(this.bmz);
        MessageManager.getInstance().unRegisterListener(this.bmy);
        MessageManager.getInstance().unRegisterListener(this.bmq);
        MessageManager.getInstance().unRegisterListener(this.bmt);
        MessageManager.getInstance().unRegisterListener(this.bmu);
        MessageManager.getInstance().unRegisterListener(this.bmv);
        MessageManager.getInstance().unRegisterListener(this.bhd);
        MessageManager.getInstance().unRegisterListener(this.bmw);
        MessageManager.getInstance().unRegisterListener(this.bmx);
        MessageManager.getInstance().unRegisterListener(this.bmr);
        MessageManager.getInstance().unRegisterListener(this.bmB);
        MessageManager.getInstance().unRegisterListener(this.bmC);
        MessageManager.getInstance().unRegisterListener(this.bmD);
        MessageManager.getInstance().unRegisterListener(this.bmE);
        MessageManager.getInstance().unRegisterListener(this.bmA);
        MessageManager.getInstance().unRegisterListener(this.bgV);
        if (z) {
            MessageManager.getInstance().unRegisterListener(this.syncListener);
        }
        this.mHandler.removeCallbacks(this.bmp);
        this.mHandler.removeCallbacks(this.bmo);
        this.mHandler.removeCallbacks(this.bms);
        if (this.mMsgList != null) {
            this.mMsgList.clear();
        }
        this.mMsgList = null;
        if (this.bml != null) {
            this.bml.clear();
        }
        if (this.bmm != null) {
            this.bmm.clear();
        }
    }

    private void LZ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021194, TbConfig.SERVER_ADDRESS + "ala/live/checkImBan");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaForbiddenWordsStateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(ImSendMsgData imSendMsgData, boolean z, boolean z2, int i, String str, String[] strArr) {
        if (!TbadkCoreApplication.isLogin()) {
            BdUtilHelper.showToast(this.blU.getPageActivity(), a.h.sdk_not_login);
        } else if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow())) {
            BdUtilHelper.showToast(this.blU.getPageActivity(), a.h.sdk_username_empty);
        } else {
            String str2 = imSendMsgData.text;
            short s = imSendMsgData.msgType;
            com.baidu.live.im.data.b a2 = a(s, str2, z, z2, i, this.aLb);
            if (s == 126) {
                a2.fc(imSendMsgData.barrageType);
                a2.hT(imSendMsgData.barrageId);
                a2.a(imSendMsgData.barrageCardInfo);
            }
            if (a2 != null) {
                a2.l(strArr);
                a(-1, a2);
                if (this.blW != null) {
                    this.blW.t(a2);
                    this.blW.d(this.mMsgList, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913043));
                com.baidu.live.im.message.a aVar = new com.baidu.live.im.message.a(str2, s, JavaTypesHelper.toInt(this.mGroupId, 0), this.mAppId);
                if (this.aGe != null && this.aGe.mLiveInfo != null) {
                    aVar.setLiveId(this.aGe.mLiveInfo.live_id + "");
                    aVar.setRoomId(this.aGe.mLiveInfo.room_id + "");
                } else {
                    aVar.setLiveId("");
                    aVar.setRoomId("");
                }
                aVar.setOtherParams(str);
                aVar.aV(imSendMsgData.price);
                aVar.fc(imSendMsgData.barrageType);
                aVar.hT(imSendMsgData.barrageId);
                aVar.a(imSendMsgData.barrageCardInfo);
                aVar.l(strArr);
                aVar.cm(imSendMsgData.isQuick);
                aVar.co(imSendMsgData.isQuickBarrage);
                aVar.setText(str2);
                aVar.cn(imSendMsgData.isOut);
                sendMessage(aVar);
            }
        }
    }

    public void j(long j, long j2) {
        if (!this.bmg) {
            this.bmg = true;
            com.baidu.live.im.message.c cVar = new com.baidu.live.im.message.c(1021194);
            cVar.addParam("user_id", j);
            cVar.addParam("live_id", j2);
            cVar.aW(System.currentTimeMillis());
            sendMessage(cVar);
            this.mHandler.postDelayed(this.bmp, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ma() {
        this.bmg = false;
        this.bmh = true;
        ImForbiddenStateData imForbiddenStateData = new ImForbiddenStateData();
        imForbiddenStateData.errno = -1;
        imForbiddenStateData.errMsg = this.blU.getString(a.h.sdk_neterror);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, imForbiddenStateData));
    }
}
