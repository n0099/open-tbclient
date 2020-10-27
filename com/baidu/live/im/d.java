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
import com.baidu.live.gift.ab;
import com.baidu.live.im.b;
import com.baidu.live.im.data.ImForbiddenStateData;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.message.ALAGroupCommitHttpResponsedMessage;
import com.baidu.live.im.message.ALAGroupHttpResponseMessage;
import com.baidu.live.im.message.AlaForbiddenWordsStateResponseMessage;
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
    private w aEc;
    private List<AlaLiveMarkData> aIJ;
    private boolean aVd;
    private CustomMessageListener bbF;
    private int bgA;
    private float bgB;
    private String bgC;
    private String bgD;
    private boolean bgE;
    private boolean bgF;
    private int bgG;
    private int bgH;
    private boolean bgI;
    private LinkedHashMap<String, HashMap<Long, h>> bgJ;
    private HashMap<String, HashMap<Long, h>> bgK;
    private b.a bgL;
    private Runnable bgM;
    private Runnable bgN;
    private CustomMessageListener bgO;
    private CustomMessageListener bgP;
    private Runnable bgQ;
    private HttpMessageListener bgR;
    private HttpMessageListener bgS;
    private HttpMessageListener bgT;
    private HttpMessageListener bgU;
    private HttpMessageListener bgV;
    private NetMessageListener bgW;
    CustomMessageListener bgX;
    CustomMessageListener bgY;
    CustomMessageListener bgZ;
    public int bgp;
    public int bgq;
    public int bgr;
    private boolean bgt;
    private a bgu;
    private String bgv;
    private String bgw;
    private List<com.baidu.live.im.data.a> bgx;
    private int bgy;
    private int bgz;
    CustomMessageListener bha;
    CustomMessageListener bhb;
    private HttpMessageListener bhc;
    private long count;
    private String mAppId;
    private String mGroupId;
    private Handler mHandler;
    private String mLiveId;
    private LinkedList<com.baidu.live.im.data.a> mMsgList;
    BdPageContext<?> mPageContext;
    private HttpMessageListener syncListener;

    /* loaded from: classes4.dex */
    public interface a {
        void KL();

        void d(List<com.baidu.live.im.data.a> list, boolean z);

        void s(com.baidu.live.im.data.a aVar);
    }

    static /* synthetic */ int h(d dVar) {
        int i = dVar.bgA;
        dVar.bgA = i + 1;
        return i;
    }

    public d(BdPageContext<?> bdPageContext, boolean z, a aVar) {
        super(bdPageContext);
        this.mLiveId = null;
        this.bgB = 1.0f;
        this.mHandler = new Handler();
        this.bgC = null;
        this.aVd = false;
        this.bgD = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION;
        this.bgE = false;
        this.bgF = false;
        this.bgH = 0;
        this.bgI = false;
        this.bgL = new b.a() { // from class: com.baidu.live.im.d.1
        };
        this.bgM = new Runnable() { // from class: com.baidu.live.im.d.12
            @Override // java.lang.Runnable
            public void run() {
                int i = d.this.bgA * d.this.bgy;
                if (i >= d.this.bgx.size()) {
                    d.this.KH();
                } else if (d.this.bgA >= d.this.bgz - 1) {
                    if (d.this.bgA != d.this.bgz - 1) {
                        d.this.KH();
                        return;
                    }
                    ArrayList arrayList = new ArrayList(d.this.bgx);
                    d.this.M(d.this.b(arrayList.subList(i, arrayList.size()), true));
                    d.h(d.this);
                    d.this.KH();
                } else {
                    ArrayList arrayList2 = new ArrayList(d.this.bgx);
                    if (d.this.bgy + i <= arrayList2.size()) {
                        d.this.M(d.this.b(arrayList2.subList(i, d.this.bgy + i), true));
                        d.h(d.this);
                        d.this.mHandler.postDelayed(d.this.bgM, 250L);
                        return;
                    }
                    d.this.M(d.this.b(arrayList2.subList(i, arrayList2.size()), true));
                    d.h(d.this);
                    d.this.KH();
                }
            }
        };
        this.bgN = new Runnable() { // from class: com.baidu.live.im.d.15
            @Override // java.lang.Runnable
            public void run() {
                d.this.KK();
            }
        };
        this.bbF = new CustomMessageListener(2913238) { // from class: com.baidu.live.im.d.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null) {
                    d.this.aVd = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
            }
        };
        this.bgO = new CustomMessageListener(MessageConfig.SOCKET_RECEIVE_MSG) { // from class: com.baidu.live.im.d.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.KD();
            }
        };
        this.bgP = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.live.im.d.18
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
                        if (d.this.bgu != null) {
                            d.this.bgu.s(aVar2);
                            d.this.bgu.d(d.this.mMsgList, true);
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
                        if (d.this.bgu != null) {
                            d.this.bgu.s(aVar3);
                            d.this.bgu.d(d.this.mMsgList, true);
                        }
                    }
                }
            }
        };
        this.bgQ = new Runnable() { // from class: com.baidu.live.im.d.19
            @Override // java.lang.Runnable
            public void run() {
                if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().getLastReceDataTime() > 35000) {
                    d.this.KC();
                }
                d.this.KB();
            }
        };
        this.bgR = new HttpMessageListener(1021013) { // from class: com.baidu.live.im.d.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    boolean z2 = false;
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        int error = httpResponsedMessage.getError();
                        if (com.baidu.live.z.a.Pq().bmJ.aMo == 1) {
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
                    if (!z2 && d.this.bgu != null) {
                        d.this.bgu.KL();
                    }
                }
            }
        };
        this.bgS = new HttpMessageListener(1021015) { // from class: com.baidu.live.im.d.21
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
                            if (!d.this.bgI) {
                                d.this.e(jVar.aUe, jVar.giftName);
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                        }
                        if (d.this.bgI) {
                            d.this.a(jVar.giftId, jVar.aUe, jVar.aUi, z2, jVar.aUk);
                        }
                    }
                }
            }
        };
        this.bgT = new HttpMessageListener(1021014) { // from class: com.baidu.live.im.d.2
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
                            if (!d.this.bgI) {
                                d.this.e(pVar.aUe, pVar.giftName);
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                        }
                        if (d.this.bgI) {
                            d.this.a(pVar.giftId, pVar.aUe, pVar.aUi, z2, pVar.aUk);
                        }
                    }
                }
            }
        };
        this.bgU = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.live.im.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                boolean z2;
                boolean z3;
                if (httpResponsedMessage != null) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof com.baidu.live.gift.q) {
                        com.baidu.live.gift.q qVar = (com.baidu.live.gift.q) orginalMessage;
                        if ((httpResponsedMessage instanceof GiftPackageConsumeHttpResponsedMessage) && TextUtils.isEmpty(((GiftPackageConsumeHttpResponsedMessage) httpResponsedMessage).aVg)) {
                            if (!d.this.bgI) {
                                d.this.e(qVar.aUO, qVar.giftName);
                            }
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            if (!d.this.bgI) {
                                d.this.e(qVar.aUO, qVar.giftName);
                            }
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (d.this.bgI) {
                            d.this.a(qVar.giftId, qVar.aUO, qVar.aUi, z3, qVar.aUk);
                        }
                    }
                }
            }
        };
        this.bgV = new HttpMessageListener(1021012) { // from class: com.baidu.live.im.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                d.this.a((ResponsedMessage<?>) httpResponsedMessage, false);
            }
        };
        this.bgW = new NetMessageListener(1021050, 601008) { // from class: com.baidu.live.im.d.5
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                JSONObject jSONObject;
                AlaGetLiveStatusHttpResponseMessage alaGetLiveStatusHttpResponseMessage = responsedMessage instanceof AlaGetLiveStatusHttpResponseMessage ? (AlaGetLiveStatusHttpResponseMessage) responsedMessage : null;
                if (alaGetLiveStatusHttpResponseMessage != null) {
                    try {
                        jSONObject = new JSONObject(alaGetLiveStatusHttpResponseMessage.bmz);
                    } catch (JSONException e) {
                        jSONObject = null;
                    }
                    if (jSONObject != null) {
                        if (!"backstage_live".equals(jSONObject.optString("content_type"))) {
                            d.this.a(alaGetLiveStatusHttpResponseMessage.bmz, jSONObject, 12, false);
                            return;
                        }
                        String optString = jSONObject.optString("backstage_type");
                        String optString2 = jSONObject.optString("text");
                        if (!TextUtils.isEmpty(optString) && !optString.equals(d.this.bgC) && !TextUtils.isEmpty(optString2)) {
                            d.this.a(alaGetLiveStatusHttpResponseMessage.bmz, jSONObject, 13, true);
                            d.this.bgC = optString;
                        }
                    }
                }
            }
        };
        this.count = 1L;
        this.bgX = new CustomMessageListener(2913192) { // from class: com.baidu.live.im.d.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText banlstn sd=" + d.this.aEc);
                if (d.this.aEc != null) {
                    if (d.this.aEc.mLiveInfo.getUserID() == Long.valueOf(TbadkCoreApplication.getCurrentAccount()).longValue()) {
                        Log.i("i", "@@@ localText banlstn own");
                        if (d.this.aEc.aIe != null && d.this.aEc.mLiveInfo != null) {
                            Log.i("i", "@@@ localText banlstn own sdreq");
                            d.this.g(d.this.aEc.aIe.userId, d.this.aEc.mLiveInfo.live_id);
                            return;
                        }
                        return;
                    }
                    Log.i("i", "@@@ localText banlstn oth");
                    if (d.this.aEc.aIA != null && d.this.aEc.mLiveInfo != null) {
                        Log.i("i", "@@@ localText banlstn oth sdreq");
                        d.this.g(d.this.aEc.aIA.userId, d.this.aEc.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.live.im.d.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                    AlaSyncHttpResponseMessage alaSyncHttpResponseMessage = (AlaSyncHttpResponseMessage) httpResponsedMessage;
                    if (alaSyncHttpResponseMessage.getError() == 0 && alaSyncHttpResponseMessage.NH() != null) {
                        d.this.bgp = alaSyncHttpResponseMessage.NH().aMp;
                        d.this.bgq = alaSyncHttpResponseMessage.NH().aMq;
                        d.this.bgr = alaSyncHttpResponseMessage.NH().aMr;
                    }
                }
            }
        };
        this.bgY = new CustomMessageListener(2913185) { // from class: com.baidu.live.im.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.bgI && customResponsedMessage != null && (customResponsedMessage.getData() instanceof h)) {
                    h hVar = (h) customResponsedMessage.getData();
                    com.baidu.live.im.data.a b = d.this.b(hVar.giftId, hVar.count + "", hVar.giftName, 0L, hVar.biC);
                    if (b != null) {
                        double m = d.this.m(b);
                        b.setMsgId(0L);
                        b.setRecordId(0L);
                        com.baidu.live.data.a LO = b.LO();
                        if (LO != null && !StringUtils.isNull(LO.userId) && !StringUtils.isNull(hVar.giftId)) {
                            String str = LO.userId;
                            String nameShow = LO.getNameShow();
                            String str2 = str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + hVar.giftId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + nameShow;
                            if (d.this.bgK == null) {
                                d.this.bgK = new HashMap();
                            }
                            hVar.biy = b;
                            hVar.userId = str;
                            hVar.userName = nameShow;
                            hVar.biB = m;
                            if (d.this.aVd) {
                                d.this.a(hVar);
                            }
                            if (!d.this.bgK.containsKey(str2)) {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Long.valueOf(hVar.aUi), hVar);
                                d.this.bgK.put(str2, hashMap);
                                return;
                            }
                            ((HashMap) d.this.bgK.get(str2)).put(Long.valueOf(hVar.aUi), hVar);
                        }
                    }
                }
            }
        };
        this.bgZ = new CustomMessageListener(2913184) { // from class: com.baidu.live.im.d.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                    i iVar = (i) customResponsedMessage.getData();
                    if (iVar.biH > 0) {
                        HashMap hashMap = (HashMap) d.this.bgJ.get(iVar.aZK);
                        if (hashMap != null && !hashMap.isEmpty()) {
                            h hVar = (h) hashMap.remove(Long.valueOf(iVar.biH));
                            if (hVar != null) {
                                hVar.biE = true;
                                hVar.biy.ak(hVar.count);
                                hVar.biy.o(hVar.biB);
                                if (hVar.biy.isHost()) {
                                    hVar.biy.al(-1L);
                                } else {
                                    hVar.biy.al(hVar.biA);
                                }
                                d.this.a(-1, hVar.biy);
                                if (d.this.bgu != null) {
                                    d.this.bgu.d(d.this.mMsgList, true);
                                }
                            }
                            if (hashMap.isEmpty()) {
                                d.this.bgJ.remove(iVar.aZK);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    HashMap hashMap2 = (HashMap) d.this.bgK.get(iVar.aZK);
                    if (hashMap2 != null && !hashMap2.isEmpty()) {
                        h hVar2 = (h) hashMap2.get(Long.valueOf(iVar.biJ));
                        if (hVar2 != null) {
                            if (hVar2.biD != 0) {
                                hVar2.biE = true;
                                return;
                            }
                            hashMap2.remove(Long.valueOf(iVar.biJ));
                            hVar2.biy.ak(hVar2.count);
                            hVar2.biy.o(hVar2.biB);
                            if (hVar2.biy.isHost()) {
                                hVar2.biy.al(-1L);
                            } else {
                                hVar2.biy.al(hVar2.biA);
                            }
                            d.this.a(-1, hVar2.biy);
                            if (d.this.bgu != null) {
                                d.this.bgu.d(d.this.mMsgList, true);
                            }
                            long j = hVar2.biz;
                            if (j > 0) {
                                d.this.e(j, hVar2.giftName);
                            }
                        }
                        if (hashMap2.isEmpty()) {
                            d.this.bgK.remove(iVar.aZK);
                        }
                    }
                }
            }
        };
        this.bha = new CustomMessageListener(2913183) { // from class: com.baidu.live.im.d.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                    i iVar = (i) customResponsedMessage.getData();
                    if (iVar.biH == 0) {
                        HashMap hashMap = (HashMap) d.this.bgK.get(iVar.aZK);
                        if (hashMap != null && !hashMap.isEmpty()) {
                            h hVar = (h) hashMap.get(Long.valueOf(iVar.biJ));
                            h hVar2 = (h) hashMap.get(Long.valueOf(iVar.biM));
                            if (hVar != null && hVar2 != null) {
                                hashMap.remove(Long.valueOf(iVar.biM));
                                hVar.count += hVar2.count;
                                hVar.biA += hVar2.biA;
                                hVar.biz += hVar2.biz;
                                hVar.biD += hVar2.biD;
                                if (hVar.biB != hVar2.biB) {
                                    hVar.biB = 0.0d;
                                }
                                hVar.biF.add(Long.valueOf(hVar2.aUi));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    HashMap hashMap2 = (HashMap) d.this.bgJ.get(iVar.aZK);
                    if (hashMap2 != null && !hashMap2.isEmpty()) {
                        h hVar3 = (h) hashMap2.get(Long.valueOf(iVar.biH));
                        h hVar4 = (h) hashMap2.remove(Long.valueOf(iVar.biK));
                        if (hVar3 != null && hVar4 != null) {
                            hVar3.count += hVar4.count;
                            hVar3.biA += hVar4.biA;
                            if (hVar3.biB != hVar4.biB) {
                                hVar3.biB = 0.0d;
                            }
                        }
                    }
                }
            }
        };
        this.bhb = new CustomMessageListener(2913195) { // from class: com.baidu.live.im.d.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                HashMap hashMap;
                h hVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                    i iVar = (i) customResponsedMessage.getData();
                    if (iVar.biH != 0 && (hashMap = (HashMap) d.this.bgJ.get(iVar.aZK)) != null && !hashMap.isEmpty() && (hVar = (h) hashMap.get(Long.valueOf(iVar.biH))) != null) {
                        hVar.count = iVar.biN;
                        hVar.biA = iVar.biO;
                    }
                }
            }
        };
        this.bhc = new HttpMessageListener(1021194) { // from class: com.baidu.live.im.d.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                d.this.bgE = false;
                d.this.mHandler.removeCallbacks(d.this.bgN);
                if (httpResponsedMessage != null) {
                    if (httpResponsedMessage.getOrginalMessage() == null || !(httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.im.message.c) || !((com.baidu.live.im.message.c) httpResponsedMessage.getOrginalMessage()).ao(System.currentTimeMillis())) {
                        if (d.this.bgF) {
                            d.this.bgF = false;
                            return;
                        } else if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            ImForbiddenStateData imForbiddenStateData = new ImForbiddenStateData();
                            imForbiddenStateData.errno = httpResponsedMessage.getError();
                            imForbiddenStateData.errMsg = httpResponsedMessage.getErrorString();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, imForbiddenStateData));
                            return;
                        } else if (httpResponsedMessage instanceof AlaForbiddenWordsStateResponseMessage) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, ((AlaForbiddenWordsStateResponseMessage) httpResponsedMessage).bkw));
                            return;
                        } else {
                            return;
                        }
                    }
                    d.this.bgF = false;
                }
            }
        };
        this.bgp = com.baidu.live.z.a.Pq().bmJ.aMp;
        this.bgq = com.baidu.live.z.a.Pq().bmJ.aMq;
        this.bgr = com.baidu.live.z.a.Pq().bmJ.aMr;
        this.mPageContext = bdPageContext;
        this.bgt = z;
        this.bgu = aVar;
        this.mMsgList = new LinkedList<>();
        this.bgJ = new LinkedHashMap<>();
        this.bgK = new HashMap<>();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913182, Object.class);
        if (runTask != null && runTask.getData() != null) {
            this.bgI = true;
        }
        MessageManager.getInstance().registerTask(KA());
        com.baidu.live.tieba.f.a.a.a(1021050, "alaim/gmsg/getLiveStatus", AlaGetLiveStatusHttpResponseMessage.class, false, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021012, "alaim/gmsg/getGroupMsg", ALAGroupHttpResponseMessage.class, false, true, true, true);
        KJ();
        registerListener(this.bhc);
        MessageManager.getInstance().registerListener(this.syncListener);
    }

    public void setAlaLiveShowData(w wVar) {
        this.aEc = wVar;
        if (this.aEc != null && this.aEc.mLiveInfo != null) {
            this.bgG = this.aEc.mLiveInfo.audience_count - this.aEc.mLiveInfo.ai_robot_num;
        }
    }

    private HttpMessageTask KA() {
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
    public void KB() {
        this.mHandler.postDelayed(this.bgQ, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KC() {
        sendMessage(new com.baidu.live.im.message.b(JavaTypesHelper.toInt(this.mGroupId, 0), getLastMid()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KD() {
        this.mHandler.removeCallbacks(this.bgQ);
    }

    public void e(long j, String str) {
        if (j == 0) {
            j = 1;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.mPageContext.getString(a.i.sdk_gift);
        }
        com.baidu.live.im.data.a a2 = a((short) 27, String.format(this.mPageContext.getString(a.i.sdk_send_gift_fail), Long.valueOf(j), str), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), this.aIJ);
        if (a2 != null) {
            a(-1, a2);
            if (this.bgu != null) {
                this.bgu.s(a2);
                this.bgu.d(this.mMsgList, true);
            }
        }
    }

    public com.baidu.live.im.data.a b(String str, String str2, String str3, long j, boolean z) {
        return a((short) 24, c(str, TextUtils.isEmpty(str2) ? "1" : str2, TextUtils.isEmpty(str3) ? this.mPageContext.getString(a.i.sdk_gift) : str3, j, z).toString(), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), this.aIJ);
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
        if (this.bgu != null) {
            this.bgu.s(aVar);
            if (z) {
                this.bgu.d(this.mMsgList, true);
            }
        }
    }

    protected void a(ResponsedMessage<?> responsedMessage, boolean z) {
        boolean z2;
        long j;
        List<com.baidu.live.im.data.a> list;
        if (responsedMessage instanceof ALAGroupHttpResponseMessage) {
            List<com.baidu.live.im.data.a> Mi = ((ALAGroupHttpResponseMessage) responsedMessage).Mi();
            j = ((ALAGroupHttpResponseMessage) responsedMessage).getGroupId();
            list = Mi;
            z2 = ((ALAGroupHttpResponseMessage) responsedMessage).Mh();
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
                P(list);
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
            if (this.bgz != 0) {
                int i2 = this.bgA * this.bgy;
                ArrayList arrayList = new ArrayList(this.bgx);
                d(0, arrayList.subList(i2, arrayList.size()));
                KH();
            }
            if (list.size() > 0) {
                if (list.size() > 5 && z) {
                    N(list);
                } else {
                    M(a(list, z, z2));
                }
            }
        }
    }

    public void e(String str, String str2, String str3, String str4, String str5) {
        if (this.mMsgList != null) {
            this.mMsgList.clear();
        }
        if (this.bgJ != null) {
            this.bgJ.clear();
        }
        if (this.bgK != null) {
            this.bgK.clear();
        }
        this.mMsgList = new LinkedList<>();
        this.mGroupId = str;
        this.bgv = str2;
        this.bgw = str3;
        this.mLiveId = str4;
        this.bgC = "0";
        this.mAppId = str5;
        MessageManager.getInstance().registerListener(this.bgV);
        MessageManager.getInstance().registerListener(this.bgW);
        MessageManager.getInstance().registerListener(this.bgO);
        MessageManager.getInstance().registerListener(this.bgR);
        MessageManager.getInstance().registerListener(this.bgP);
        MessageManager.getInstance().registerListener(this.bgS);
        MessageManager.getInstance().registerListener(this.bgT);
        MessageManager.getInstance().registerListener(this.bgU);
        MessageManager.getInstance().registerListener(this.bgY);
        MessageManager.getInstance().registerListener(this.bgZ);
        MessageManager.getInstance().registerListener(this.bha);
        MessageManager.getInstance().registerListener(this.bhb);
        MessageManager.getInstance().registerListener(this.bgX);
        MessageManager.getInstance().registerListener(this.bbF);
        if (BdSocketLinkService.isClose()) {
            KC();
            BdSocketLinkService.startService(true, "live start");
        }
        String str6 = com.baidu.live.z.a.Pq().bmJ.aJP;
        if (!TextUtils.isEmpty(str6)) {
            com.baidu.live.im.data.a KI = KI();
            KI.setMsgType(27);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("text", str6);
                jSONObject.put("content_type", "custom_live_notice");
                KI.setContent(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            a(-1, KI);
            if (this.bgu != null) {
                this.bgu.s(KI);
            }
        }
        String str7 = com.baidu.live.z.a.Pq().bmJ.aJQ;
        if (!TextUtils.isEmpty(str7)) {
            com.baidu.live.im.data.a KI2 = KI();
            KI2.setMsgType(27);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("text", str7);
                jSONObject2.put("content_type", "custom_live_notice");
                KI2.setContent(jSONObject2.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            a(-1, KI2);
        }
        List<String> list = com.baidu.live.z.a.Pq().bmJ.aJO;
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
                    com.baidu.live.im.data.a KI3 = KI();
                    KI3.setMsgType(27);
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("text", str8);
                        jSONObject3.put("content_type", "custom_im_notice");
                        KI3.setContent(jSONObject3.toString());
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                    KI3.setLink(str9);
                    a(-1, KI3);
                    if (this.bgu != null) {
                        this.bgu.s(KI3);
                    }
                }
                i = i2 + 2;
            }
        }
        if (this.aEc != null && this.aEc.aIQ != null && !StringUtils.isNull(this.aEc.aIQ.DG())) {
            com.baidu.live.im.data.a KI4 = KI();
            KI4.setMsgType(27);
            try {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("text", this.aEc.aIQ.DG());
                jSONObject4.put("content_type", "custom_live_notice");
                KI4.setContent(jSONObject4.toString());
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            this.mMsgList.add(KI4);
            if (this.bgu != null) {
                this.bgu.s(KI4);
            }
        }
        KF();
        KE();
        if (this.mMsgList.size() > 0 && this.bgu != null) {
            this.bgu.d(this.mMsgList, true);
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGmsgGetLiveStatusUnabled()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.d.6
                @Override // java.lang.Runnable
                public void run() {
                    d.this.hy("enter");
                }
            }, 1000L);
        }
        KB();
        if (TbadkCoreApplication.getInst().isOther()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913146, this.mMsgList));
        }
    }

    private void KE() {
        String str = com.baidu.live.z.a.Pq().bmJ.aJR;
        if (str != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    com.baidu.live.im.data.a KI = KI();
                    KI.setMsgType(27);
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    JSONObject jSONObject2 = new JSONObject();
                    if (jSONObject.optInt("open") != 0) {
                        jSONObject2.put("text", jSONObject.toString());
                        jSONObject2.put("content_type", "activity_notice");
                        KI.setContent(jSONObject2.toString());
                        this.mMsgList.add(KI);
                        if (this.bgu != null) {
                            this.bgu.s(KI);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void KF() {
        if (KG()) {
            com.baidu.live.im.data.a KI = KI();
            KI.setMsgType(27);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("text", com.baidu.live.z.a.Pq().bmJ.aMl.aIq);
                jSONObject.put("content_type", "custom_im_notice_live_assistant");
                KI.setContent(jSONObject.toString());
                KI.setLink(com.baidu.live.z.a.Pq().bmJ.aMl.aIp);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mMsgList.add(KI);
            if (this.bgu != null) {
                this.bgu.s(KI);
            }
        }
    }

    private boolean KG() {
        return (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) || !TbadkCoreApplication.getCurrentAccount().equals(this.bgw) || com.baidu.live.z.a.Pq().bmJ == null || com.baidu.live.z.a.Pq().bmJ.aMl == null || TextUtils.isEmpty(com.baidu.live.z.a.Pq().bmJ.aMl.aIq)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(List<com.baidu.live.im.data.a> list) {
        if (list != null && this.bgu != null) {
            this.bgu.d(this.mMsgList, true);
            for (com.baidu.live.im.data.a aVar : list) {
                this.bgu.s(aVar);
            }
        }
    }

    protected void N(List<com.baidu.live.im.data.a> list) {
        this.bgx = list;
        this.bgz = (int) ((this.bgB * 2.0f) / 0.25f);
        this.bgA = 0;
        this.bgy = list.size() / this.bgz;
        if (this.bgy <= 0) {
            this.bgy = 1;
        }
        this.mHandler.removeCallbacks(this.bgM);
        this.mHandler.postDelayed(this.bgM, 250L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KH() {
        this.mHandler.removeCallbacks(this.bgM);
        this.bgA = 0;
        this.bgz = 0;
        this.bgy = 0;
        this.bgx = null;
    }

    protected List<com.baidu.live.im.data.a> b(List<com.baidu.live.im.data.a> list, boolean z) {
        return a(list, z, false);
    }

    protected List<com.baidu.live.im.data.a> a(List<com.baidu.live.im.data.a> list, boolean z, boolean z2) {
        for (com.baidu.live.im.data.a aVar : list) {
            if (aVar instanceof com.baidu.live.im.a) {
                ((com.baidu.live.im.a) aVar).hx(this.bgw);
            }
        }
        if (z) {
            LinkedList linkedList = new LinkedList();
            for (com.baidu.live.im.data.a aVar2 : list) {
                if (aVar2.getMsgId() > getLastMid()) {
                    if (aVar2.getMsgType() == 24) {
                        if (!z2) {
                            m(aVar2);
                        }
                        List<com.baidu.live.im.data.a> r = r(aVar2);
                        b(r, -1);
                        linkedList.addAll(r);
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
                O(list);
            }
            if (z2 && this.mMsgList.size() > 2) {
                b(list, 2);
            } else {
                b(list, -1);
            }
        }
        if (this.mMsgList.size() > com.baidu.live.z.a.Pq().bmJ.aLZ) {
            int i = (int) (com.baidu.live.z.a.Pq().bmJ.aLZ * 0.7d);
            if (i <= 0) {
                i = 1;
            }
            while (this.mMsgList.size() > i) {
                this.mMsgList.removeFirst();
            }
        }
        return list;
    }

    private void O(List<com.baidu.live.im.data.a> list) {
        if (list != null && !list.isEmpty()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    com.baidu.live.im.data.a aVar = list.get(i2);
                    if (aVar.getMsgType() == 24) {
                        m(aVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double m(com.baidu.live.im.data.a aVar) {
        double d;
        JSONException e;
        JSONObject jSONObject;
        List<AlaLiveMarkData> list;
        boolean z = false;
        com.baidu.live.data.a LO = aVar.LO();
        if (LO != null && (list = LO.aGQ) != null && !list.isEmpty()) {
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
            d = com.baidu.live.z.f.PF().i(z, jSONObject.optString(LogConfig.LOG_GIFT_ID));
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
                        if (!TextUtils.isEmpty(optString) && (optString.equals("challenge_direct_start") || optString.equals("challenge_direct_matched") || optString.equals("challenge_random_start") || optString.equals("challenge_random_matched") || optString.equals("live_net_status") || optString.equals("send_redpacket") || optString.equals("start_grab_redpacket") || optString.equals("guard_seat") || optString.equals("multi_session") || optString.equals("fullscreen") || optString.equals("challenge_mvp") || optString.equals("challenge_mvp_punish") || optString.equals("challenge_winner_by_autofail") || optString.equals("official_notice") || optString.equals("activity_common_im") || optString.equals("activity_notice") || optString.equals("activity_gift") || optString.equals("pk_first_blood") || optString.equals("pk_send_props") || optString.equals("pk_mvp_props") || optString.equals("tying_gift") || optString.equals("privilege_award_royal_success"))) {
                            it.remove();
                        }
                    } catch (JSONException e) {
                    }
                }
            }
        }
    }

    private void P(List<com.baidu.live.im.data.a> list) {
        if (list != null && !list.isEmpty()) {
            for (com.baidu.live.im.data.a aVar : list) {
                aVar.bY(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.live.im.data.a aVar) {
        if (this.bgG < this.bgp) {
            if (i >= 0) {
                this.mMsgList.add(i, aVar);
            } else {
                this.mMsgList.addLast(aVar);
            }
        } else if (this.bgG >= this.bgp && this.bgG < this.bgq) {
            if (q(aVar)) {
                aVar.Ma();
            }
            if (i >= 0) {
                this.mMsgList.add(i, aVar);
            } else if (!this.mMsgList.isEmpty() && q(this.mMsgList.getLast())) {
                this.mMsgList.set(this.mMsgList.size() - 1, aVar);
            } else {
                this.mMsgList.addLast(aVar);
            }
        } else if (this.bgG >= this.bgq && this.bgG < this.bgr) {
            if (o(aVar)) {
                aVar.Ma();
            }
            if (i >= 0) {
                this.mMsgList.add(i, aVar);
            } else if (!this.mMsgList.isEmpty() && o(this.mMsgList.getLast())) {
                this.mMsgList.set(this.mMsgList.size() - 1, aVar);
            } else {
                this.mMsgList.addLast(aVar);
            }
        } else if (this.bgG >= this.bgr) {
            if (!o(aVar)) {
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

    private int n(com.baidu.live.im.data.a aVar) {
        String str;
        JSONObject jSONObject;
        this.bgH = 0;
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
                if (com.baidu.live.entereffect.a.EF().h(aVar)) {
                    this.bgH = 2;
                } else {
                    this.bgH = 1;
                }
            } else {
                this.bgH = 0;
            }
        }
        return this.bgH;
    }

    private boolean o(com.baidu.live.im.data.a aVar) {
        return q(aVar) || p(aVar);
    }

    private boolean p(com.baidu.live.im.data.a aVar) {
        return n(aVar) == 2;
    }

    private boolean q(com.baidu.live.im.data.a aVar) {
        return n(aVar) == 1;
    }

    private void delRepeatMsg(List<com.baidu.live.im.data.a> list, List<com.baidu.live.im.data.a> list2) {
        if (list != null && list2 != null) {
            int size = list.size();
            int size2 = list2.size();
            if (size2 != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = size2 - 1; i >= 0 && i >= 0; i--) {
                    com.baidu.live.im.data.a aVar = list2.get(i);
                    if (aVar != null && aVar.LO() != null && !TextUtils.isEmpty(aVar.LO().userId) && aVar.LO().userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        int i2 = size - 1;
                        while (true) {
                            if (i2 >= 0 && i2 >= 0) {
                                com.baidu.live.im.data.a aVar2 = list.get(i2);
                                if (aVar2 != null && aVar2.LO() != null && !TextUtils.isEmpty(aVar2.LO().userId) && aVar2.LO().userId.equals(TbadkCoreApplication.getCurrentAccount()) && aVar.getRecordId() == aVar2.getRecordId()) {
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

    /* JADX WARN: Removed duplicated region for block: B:108:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x014d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0276 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:381:0x021b A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:389:0x026e A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:392:0x024b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0171 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:530:0x02a6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:619:0x0009 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x021f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0248  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(List<com.baidu.live.im.data.a> list, boolean z) {
        boolean z2;
        String str;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Exception e;
        JSONException e2;
        JSONObject jSONObject3;
        Exception exc;
        JSONObject jSONObject4;
        JSONException jSONException;
        JSONObject jSONObject5;
        String str2;
        JSONObject jSONObject6;
        JSONObject jSONObject7;
        JSONObject optJSONObject;
        LinkedList linkedList = new LinkedList();
        for (com.baidu.live.im.data.a aVar : list) {
            long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
            if (!ListUtils.isEmpty(aVar.LQ()) && !aVar.LQ().contains(Long.valueOf(currentAccountId))) {
                linkedList.add(aVar);
            } else {
                boolean z3 = aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                if (z3 && aVar.getMsgType() == 24) {
                    try {
                        if (aVar.getObjContent() instanceof JSONObject) {
                            jSONObject7 = (JSONObject) aVar.getObjContent();
                        } else {
                            jSONObject7 = new JSONObject(aVar.getContent());
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
                            aVar.setContent(jSONObject7.toString());
                            aVar.setMsgType(13);
                        }
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                if (aVar.getMsgType() == 13) {
                    try {
                        if (aVar.getObjContent() instanceof JSONObject) {
                            jSONObject6 = (JSONObject) aVar.getObjContent();
                        } else {
                            jSONObject6 = new JSONObject(aVar.getContent());
                        }
                        try {
                            str2 = jSONObject6.optString("content_type");
                            jSONObject5 = jSONObject6;
                        } catch (JSONException e5) {
                            jSONObject4 = jSONObject6;
                            jSONException = e5;
                            jSONException.printStackTrace();
                            jSONObject5 = jSONObject4;
                            str2 = null;
                            if ("pk_send_props".equals(str2)) {
                                if (z3) {
                                }
                            }
                            if ("tying_gift".equals(str2)) {
                                aVar.setMsgType(24);
                                z2 = true;
                                if (z3) {
                                }
                                if (z3) {
                                }
                                if (this.bgI) {
                                }
                                if (aVar.getMsgType() == 125) {
                                }
                            }
                            z2 = false;
                            if (z3) {
                            }
                            if (z3) {
                            }
                            if (this.bgI) {
                            }
                            if (aVar.getMsgType() == 125) {
                            }
                        } catch (Exception e6) {
                            jSONObject3 = jSONObject6;
                            exc = e6;
                            exc.printStackTrace();
                            jSONObject5 = jSONObject3;
                            str2 = null;
                            if ("pk_send_props".equals(str2)) {
                            }
                            if ("tying_gift".equals(str2)) {
                            }
                            z2 = false;
                            if (z3) {
                            }
                            if (z3) {
                            }
                            if (this.bgI) {
                            }
                            if (aVar.getMsgType() == 125) {
                            }
                        }
                    } catch (JSONException e7) {
                        jSONObject4 = null;
                        jSONException = e7;
                    } catch (Exception e8) {
                        jSONObject3 = null;
                        exc = e8;
                    }
                    if ("pk_send_props".equals(str2) && jSONObject5 != null && str2 != null && jSONObject5.optString("is_mine").equals("1")) {
                        if (z3) {
                            aVar.setMsgType(24);
                        } else {
                            aVar.setMsgType(13);
                        }
                    }
                    if ("tying_gift".equals(str2) && jSONObject5 != null && jSONObject5.optInt("tying_status") == 1) {
                        aVar.setMsgType(24);
                        z2 = true;
                        if (z3 && aVar.getMsgType() == 1 && !ListUtils.isEmpty(aVar.LO().aGQ) && this.aIJ == null) {
                            this.aIJ = aVar.LO().aGQ;
                        }
                        if (z3 && aVar.getMsgType() != 125 && aVar.getMsgType() != 24 && aVar.getMsgType() != 13 && aVar.getMsgType() != 28) {
                            if (aVar.getMsgType() != 1 || !z) {
                                linkedList.add(aVar);
                            }
                        } else if (this.bgI && z3 && aVar.getMsgType() == 24) {
                            try {
                                if (aVar.getObjContent() instanceof JSONObject) {
                                    jSONObject2 = (JSONObject) aVar.getObjContent();
                                } else {
                                    jSONObject2 = new JSONObject(aVar.getContent());
                                }
                                try {
                                    jSONObject2.optString("content_type");
                                } catch (JSONException e9) {
                                    e2 = e9;
                                    e2.printStackTrace();
                                    if (jSONObject2.optInt("from_gongyanfang_page") == 1) {
                                    }
                                    if (z2) {
                                        linkedList.add(aVar);
                                    }
                                } catch (Exception e10) {
                                    e = e10;
                                    e.printStackTrace();
                                    if (jSONObject2.optInt("from_gongyanfang_page") == 1) {
                                    }
                                    if (z2) {
                                    }
                                }
                            } catch (JSONException e11) {
                                jSONObject2 = null;
                                e2 = e11;
                            } catch (Exception e12) {
                                jSONObject2 = null;
                                e = e12;
                            }
                            boolean z4 = jSONObject2.optInt("from_gongyanfang_page") == 1;
                            if (z2 && !z4) {
                                linkedList.add(aVar);
                            }
                        } else if (aVar.getMsgType() == 125) {
                            try {
                                if (!"1".equals(new JSONObject(aVar.getContent()).optString("is_first"))) {
                                    linkedList.add(aVar);
                                    if (this.bgu != null) {
                                        this.bgu.s(aVar);
                                    }
                                }
                            } catch (JSONException e13) {
                                BdLog.e(e13);
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
                            } catch (JSONException e14) {
                                linkedList.add(aVar);
                                str = null;
                            }
                            if ("enter_live".equals(str) && this.bgG < this.bgr) {
                                if (com.baidu.live.entereffect.a.EF().h(aVar)) {
                                }
                            } else if ("close_live".equals(str)) {
                                linkedList.add(aVar);
                                if (this.bgu != null) {
                                    this.bgu.s(aVar);
                                }
                            } else if ("task".equals(str)) {
                                linkedList.add(aVar);
                                if (this.bgu != null) {
                                    this.bgu.s(aVar);
                                }
                            } else if ("live_achievement".equals(str)) {
                                linkedList.add(aVar);
                                if (this.bgu != null) {
                                    this.bgu.s(aVar);
                                }
                            } else if ("ss_hot_live".equals(str)) {
                                linkedList.add(aVar);
                                if (this.bgu != null) {
                                    this.bgu.s(aVar);
                                }
                            } else if ("challenge_direct_new".equals(str)) {
                                linkedList.add(aVar);
                                if (this.bgu != null) {
                                    this.bgu.s(aVar);
                                }
                            } else if ("challenge_random_cancel".equals(str)) {
                                linkedList.add(aVar);
                                if (this.bgu != null) {
                                    this.bgu.s(aVar);
                                }
                            } else if ("update_liveinfo".equals(str)) {
                                linkedList.add(aVar);
                                if (this.bgu != null) {
                                    this.bgu.s(aVar);
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
                                if (z3 && !ListUtils.isEmpty(aVar.LO().aGQ)) {
                                    this.aIJ = aVar.LO().aGQ;
                                    if (this.aEc != null) {
                                        this.aEc.aIJ = this.aIJ;
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
                                } else if (TextUtils.equals(str, "activity_notice")) {
                                    Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                                } else if (TextUtils.equals(str, "activity_common_im")) {
                                    Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                                } else if (TextUtils.equals(str, "activity_gift")) {
                                    Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                                } else if (TextUtils.equals(str, "pk_first_blood")) {
                                    Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                                } else if (TextUtils.equals(str, "pk_send_props")) {
                                    Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                                } else if (TextUtils.equals(str, "pk_mvp_props")) {
                                    Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                                } else if (TextUtils.equals(str, "tying_gift")) {
                                    Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                                } else if (TextUtils.equals(str, "guard_seat")) {
                                    if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                                        linkedList.add(aVar);
                                    }
                                } else if (TextUtils.equals(str, "multi_session")) {
                                    linkedList.add(aVar);
                                    if (this.bgu != null) {
                                        this.bgu.s(aVar);
                                    }
                                } else if (TextUtils.equals(str, "fullscreen")) {
                                    linkedList.add(aVar);
                                    if (this.bgu != null) {
                                        this.bgu.s(aVar);
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
                                    } else if ("introduce_goods".equals(str)) {
                                        linkedList.add(aVar);
                                        if (this.bgu != null) {
                                            this.bgu.s(aVar);
                                        }
                                    } else if ("first_recharge_success".equals(str)) {
                                        linkedList.add(aVar);
                                        if (this.bgu != null) {
                                            this.bgu.s(aVar);
                                        }
                                    } else if ("privilege_award_success".equals(str)) {
                                        linkedList.add(aVar);
                                        if (this.bgu != null) {
                                            this.bgu.s(aVar);
                                        }
                                    } else if ("need_update_live_mark_info".equals(str)) {
                                        linkedList.add(aVar);
                                        if (this.bgu != null) {
                                            this.bgu.s(aVar);
                                        }
                                    } else if ("pk_honor_change".equals(str) || "pk_invite".equals(str) || "pk_start".equals(str) || "pk_start_settle".equals(str) || "pk_end_settle".equals(str)) {
                                        linkedList.add(aVar);
                                        if (this.bgu != null) {
                                            this.bgu.s(aVar);
                                        }
                                    } else if ("official_notice".equals(str)) {
                                        linkedList.add(aVar);
                                        if (this.bgu != null && !z) {
                                            this.bgu.s(aVar);
                                        }
                                    } else if (TextUtils.equals(str, "privilege_award_royal_success")) {
                                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                                    } else if (!TextUtils.equals(str, "add_tags_to_anchor")) {
                                        if (TextUtils.equals(str, "headline_data_im")) {
                                            linkedList.add(aVar);
                                            if (this.bgu != null) {
                                                this.bgu.s(aVar);
                                            }
                                        } else {
                                            linkedList.add(aVar);
                                        }
                                    }
                                }
                            }
                        } else if (aVar.getMsgType() == 12) {
                            linkedList.add(aVar);
                            if (this.bgu != null) {
                                this.bgu.s(aVar);
                            }
                            hy("push");
                        }
                    }
                }
                z2 = false;
                if (z3) {
                    this.aIJ = aVar.LO().aGQ;
                }
                if (z3) {
                }
                if (this.bgI) {
                }
                if (aVar.getMsgType() == 125) {
                }
            }
        }
        if (linkedList.size() > 0) {
            list.removeAll(linkedList);
        }
    }

    protected com.baidu.live.im.data.a a(short s, String str, boolean z, boolean z2, int i, List<AlaLiveMarkData> list) {
        long j = 0;
        com.baidu.live.im.data.a KI = KI();
        if (KI == null) {
            return null;
        }
        KI.setMsgType(s);
        KI.setContent(str);
        long aj = o.aj(getLastMid());
        KI.setMsgId(aj);
        KI.setRecordId(aj);
        KI.setTime(System.currentTimeMillis() / 1000);
        com.baidu.live.data.a aVar = new com.baidu.live.data.a();
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            aVar.userName = TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow();
        }
        aVar.userId = TbadkCoreApplication.getCurrentAccount();
        if (this.aEc != null && this.aEc.aIA != null && !TextUtils.isEmpty(this.aEc.aIA.portrait)) {
            aVar.portrait = this.aEc.aIA.portrait;
        } else {
            aVar.portrait = TbadkCoreApplication.getCurrentPortrait();
        }
        aVar.level_id = i;
        aVar.aGN = z;
        aVar.aGO = z2;
        if (list != null) {
            aVar.aGQ = new ArrayList(list);
        }
        KI.e(aVar);
        try {
            j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        } catch (Exception e) {
        }
        KI.setUserId(j);
        return KI;
    }

    private long getLastMid() {
        if (this.mMsgList == null || this.mMsgList.size() <= 0) {
            return JavaTypesHelper.toLong(this.bgv, 1L);
        }
        return this.mMsgList.get(this.mMsgList.size() - 1).getMsgId();
    }

    protected com.baidu.live.im.data.a KI() {
        com.baidu.live.im.a aVar = new com.baidu.live.im.a();
        aVar.setBornTime(System.currentTimeMillis());
        if (TextUtils.isEmpty(this.mGroupId)) {
            return null;
        }
        aVar.hx(this.bgw);
        return aVar;
    }

    public void Q(List<AlaLiveMarkData> list) {
        this.aIJ = list;
    }

    public void hy(String str) {
        com.baidu.live.message.d dVar = new com.baidu.live.message.d(JavaTypesHelper.toLong(this.mLiveId, 0L), str);
        dVar.setParams();
        sendMessage(dVar);
    }

    public void hz(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.bgC)) {
            hy("getliveinfo");
        }
    }

    private List<com.baidu.live.im.data.a> r(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        int optInt;
        boolean Fz;
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
            com.baidu.live.gift.g gW = ab.gW(jSONObject.optString(LogConfig.LOG_GIFT_ID));
            Fz = gW != null ? gW.Fz() : false;
        } catch (JSONException e) {
            arrayList.add(aVar2);
        }
        if (optInt == 1 || Fz) {
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
            aVar3.hx(aVar2.Ky());
            aVar3.setBornTime(aVar2.getBornTime());
            aVar3.setTime(aVar2.getTime());
            aVar3.setUserId(aVar2.getUserId());
            aVar3.setToUserId(aVar2.getToUserId());
            aVar3.f(aVar2.LP());
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
            aVar3.e(aVar2.LO());
            aVar3.setSt_type(aVar2.getSt_type());
            arrayList.add(aVar3);
        }
        return arrayList;
    }

    public void a(int i, String str, com.baidu.live.data.a aVar) {
        com.baidu.live.im.data.a KI = KI();
        if (KI != null) {
            KI.setMsgType(i);
            KI.setContent(str);
            KI.e(aVar);
            a(-1, KI);
            if (this.bgu != null) {
                this.bgu.d(this.mMsgList, true);
                this.bgu.s(KI);
            }
        }
    }

    private void b(List<com.baidu.live.im.data.a> list, int i) {
        JSONObject jSONObject;
        int i2;
        if (this.bgI) {
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
                            com.baidu.live.data.a LO = aVar.LO();
                            if (LO == null || StringUtils.isNull(LO.userId) || StringUtils.isNull(optString)) {
                                if (i >= 0) {
                                    a(i + i4, aVar);
                                } else {
                                    a(-1, aVar);
                                }
                            } else {
                                String str = LO.userId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + optString + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + LO.getNameShow();
                                if (this.bgJ == null) {
                                    this.bgJ = new LinkedHashMap<>();
                                }
                                long j = JavaTypesHelper.toLong(jSONObject.optString("gift_count"), 0L);
                                double optDouble = jSONObject.optDouble("gift_rate", 0.0d);
                                long j2 = JavaTypesHelper.toLong(jSONObject.optString("charm_value"), 0L);
                                h hVar = new h();
                                hVar.biy = aVar;
                                hVar.count = j;
                                hVar.biB = optDouble;
                                hVar.biA = j2;
                                if (com.baidu.live.z.a.Pq().bmJ == null) {
                                    i2 = 100;
                                } else {
                                    i2 = com.baidu.live.z.a.Pq().bmJ.aMf * 2;
                                }
                                Iterator<String> it = this.bgJ.keySet().iterator();
                                int i5 = 0;
                                while (it.hasNext()) {
                                    String next = it.next();
                                    if (this.bgJ.get(next) == null || this.bgJ.get(next).isEmpty()) {
                                        it.remove();
                                    } else {
                                        HashMap<Long, h> hashMap = this.bgJ.get(next);
                                        Iterator<Long> it2 = hashMap.keySet().iterator();
                                        while (it2.hasNext()) {
                                            long longValue = it2.next().longValue();
                                            if (hashMap.get(Long.valueOf(longValue)) == null || hashMap.get(Long.valueOf(longValue)).biE) {
                                                it2.remove();
                                            }
                                        }
                                        if (this.bgJ.get(next) == null || this.bgJ.get(next).isEmpty()) {
                                            it.remove();
                                        } else {
                                            i5 = hashMap.size() + i5;
                                        }
                                    }
                                }
                                if (i5 > i2) {
                                    int i6 = i5 - ((int) (i2 * 0.7d));
                                    Iterator<String> it3 = this.bgJ.keySet().iterator();
                                    while (true) {
                                        int i7 = i6;
                                        if (!it3.hasNext()) {
                                            break;
                                        }
                                        i6 = i7 - this.bgJ.get(it3.next()).size();
                                        it3.remove();
                                        if (i6 <= 0) {
                                            break;
                                        }
                                    }
                                }
                                if (!this.bgJ.containsKey(str)) {
                                    HashMap<Long, h> hashMap2 = new HashMap<>();
                                    hashMap2.put(Long.valueOf(aVar.getMsgId()), hVar);
                                    this.bgJ.put(str, hashMap2);
                                } else {
                                    this.bgJ.get(str).put(Long.valueOf(aVar.getMsgId()), hVar);
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
            HashMap<Long, h> hashMap = this.bgK.get(str3);
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
                            if (next.biF.contains(l)) {
                                hVar = next;
                                break;
                            }
                        }
                    }
                    if (hVar != null) {
                        long longValue = map.get(l).longValue();
                        if (z) {
                            hVar.biz += longValue;
                        }
                        hVar.biD -= longValue;
                        if (hVar.biE && hVar.biD == 0) {
                            hashMap.remove(Long.valueOf(hVar.aUi));
                            hVar.biy.ak(hVar.count);
                            hVar.biy.o(hVar.biB);
                            hVar.biy.al(hVar.biA);
                            a(-1, hVar.biy);
                            if (this.bgu != null) {
                                this.bgu.d(this.mMsgList, true);
                            }
                            long j3 = hVar.biz;
                            if (j3 > 0) {
                                e(j3, hVar.giftName);
                            }
                        }
                    }
                }
                if (hashMap.isEmpty()) {
                    this.bgK.remove(str3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h hVar) {
        JSONObject jSONObject;
        com.baidu.live.im.data.a aVar = hVar.biy;
        if (aVar != null) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pk_honer_buff_multiple", Double.parseDouble(hVar.biG == null ? this.bgD : hVar.biG));
                jSONObject2.put("pk_honer_buff_text", hVar.text);
                jSONObject2.put("pk_honer_buff_text_color_start", hVar.startColor);
                jSONObject2.put("pk_honer_buff_text_color_end", hVar.endColor);
                jSONObject2.put("pk_honer_buff_text_font_color", hVar.fontColor);
                jSONObject.put("pk_info", jSONObject2);
                aVar.setObjContent(jSONObject);
                aVar.setContent(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void bT(boolean z) {
        this.mGroupId = null;
        this.bgv = null;
        this.mLiveId = null;
        this.bgC = "0";
        this.mAppId = null;
        this.bgE = false;
        this.bgF = false;
        MessageManager.getInstance().unRegisterListener(this.bgW);
        MessageManager.getInstance().unRegisterListener(this.bgV);
        MessageManager.getInstance().unRegisterListener(this.bgO);
        MessageManager.getInstance().unRegisterListener(this.bgR);
        MessageManager.getInstance().unRegisterListener(this.bgS);
        MessageManager.getInstance().unRegisterListener(this.bgT);
        MessageManager.getInstance().unRegisterListener(this.bgU);
        MessageManager.getInstance().unRegisterListener(this.bgP);
        MessageManager.getInstance().unRegisterListener(this.bgY);
        MessageManager.getInstance().unRegisterListener(this.bgZ);
        MessageManager.getInstance().unRegisterListener(this.bha);
        MessageManager.getInstance().unRegisterListener(this.bhb);
        MessageManager.getInstance().unRegisterListener(this.bgX);
        MessageManager.getInstance().unRegisterListener(this.bbF);
        if (z) {
            MessageManager.getInstance().unRegisterListener(this.syncListener);
        }
        this.mHandler.removeCallbacks(this.bgN);
        this.mHandler.removeCallbacks(this.bgM);
        this.mHandler.removeCallbacks(this.bgQ);
        if (this.mMsgList != null) {
            this.mMsgList.clear();
        }
        this.mMsgList = null;
        if (this.bgJ != null) {
            this.bgJ.clear();
        }
        if (this.bgK != null) {
            this.bgK.clear();
        }
    }

    private void KJ() {
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
            com.baidu.live.im.data.a a2 = a(s, str2, z, z2, i, this.aIJ);
            if (s == 126) {
                a2.eL(imSendMsgData.barrageType);
                a2.hE(imSendMsgData.barrageId);
                a2.a(imSendMsgData.barrageCardInfo);
            }
            if (a2 != null) {
                a2.l(strArr);
                a(-1, a2);
                if (this.bgu != null) {
                    this.bgu.s(a2);
                    this.bgu.d(this.mMsgList, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913043));
                com.baidu.live.im.message.a aVar = new com.baidu.live.im.message.a(str2, s, JavaTypesHelper.toInt(this.mGroupId, 0), this.mAppId);
                if (this.aEc != null && this.aEc.mLiveInfo != null) {
                    aVar.setLiveId(this.aEc.mLiveInfo.live_id + "");
                    aVar.setRoomId(this.aEc.mLiveInfo.room_id + "");
                } else {
                    aVar.setLiveId("");
                    aVar.setRoomId("");
                }
                aVar.setOtherParams(str);
                aVar.am(imSendMsgData.price);
                aVar.eL(imSendMsgData.barrageType);
                aVar.hE(imSendMsgData.barrageId);
                aVar.a(imSendMsgData.barrageCardInfo);
                aVar.l(strArr);
                aVar.bZ(imSendMsgData.isQuick);
                sendMessage(aVar);
            }
        }
    }

    public void g(long j, long j2) {
        if (!this.bgE) {
            this.bgE = true;
            com.baidu.live.im.message.c cVar = new com.baidu.live.im.message.c(1021194);
            cVar.addParam("user_id", j);
            cVar.addParam("live_id", j2);
            cVar.an(System.currentTimeMillis());
            sendMessage(cVar);
            this.mHandler.postDelayed(this.bgN, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KK() {
        this.bgE = false;
        this.bgF = true;
        ImForbiddenStateData imForbiddenStateData = new ImForbiddenStateData();
        imForbiddenStateData.errno = -1;
        imForbiddenStateData.errMsg = this.mPageContext.getString(a.i.sdk_neterror);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, imForbiddenStateData));
    }
}
