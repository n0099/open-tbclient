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
import com.baidu.live.data.r;
import com.baidu.live.gift.GiftPackageConsumeHttpResponsedMessage;
import com.baidu.live.gift.q;
import com.baidu.live.gift.v;
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
/* loaded from: classes7.dex */
public class d extends BdBaseModel {
    private r aAj;
    private List<AlaLiveMarkData> aEk;
    public int aYS;
    public int aYT;
    public int aYU;
    private boolean aYV;
    private a aYW;
    private String aYX;
    private String aYY;
    private List<com.baidu.live.im.data.a> aYZ;
    CustomMessageListener aZA;
    CustomMessageListener aZB;
    CustomMessageListener aZC;
    private HttpMessageListener aZD;
    private int aZa;
    private int aZb;
    private int aZc;
    private float aZd;
    private String aZe;
    private boolean aZf;
    private boolean aZg;
    private int aZh;
    private int aZi;
    private boolean aZj;
    private LinkedHashMap<String, HashMap<Long, h>> aZk;
    private HashMap<String, HashMap<Long, h>> aZl;
    private b.a aZm;
    private Runnable aZn;
    private Runnable aZo;
    private CustomMessageListener aZp;
    private CustomMessageListener aZq;
    private Runnable aZr;
    private HttpMessageListener aZs;
    private HttpMessageListener aZt;
    private HttpMessageListener aZu;
    private HttpMessageListener aZv;
    private HttpMessageListener aZw;
    private NetMessageListener aZx;
    CustomMessageListener aZy;
    CustomMessageListener aZz;
    private long count;
    private String mAppId;
    private String mGroupId;
    private Handler mHandler;
    private String mLiveId;
    private LinkedList<com.baidu.live.im.data.a> mMsgList;
    BdPageContext<?> mPageContext;
    private HttpMessageListener syncListener;

    /* loaded from: classes7.dex */
    public interface a {
        void IG();

        void d(List<com.baidu.live.im.data.a> list, boolean z);

        void r(com.baidu.live.im.data.a aVar);
    }

    static /* synthetic */ int h(d dVar) {
        int i = dVar.aZc;
        dVar.aZc = i + 1;
        return i;
    }

    public d(BdPageContext<?> bdPageContext, boolean z, a aVar) {
        super(bdPageContext);
        this.mLiveId = null;
        this.aZd = 1.0f;
        this.mHandler = new Handler();
        this.aZe = null;
        this.aZf = false;
        this.aZg = false;
        this.aZi = 0;
        this.aZj = false;
        this.aZm = new b.a() { // from class: com.baidu.live.im.d.1
        };
        this.aZn = new Runnable() { // from class: com.baidu.live.im.d.12
            @Override // java.lang.Runnable
            public void run() {
                int i = d.this.aZc * d.this.aZa;
                if (i >= d.this.aYZ.size()) {
                    d.this.IC();
                } else if (d.this.aZc >= d.this.aZb - 1) {
                    if (d.this.aZc != d.this.aZb - 1) {
                        d.this.IC();
                        return;
                    }
                    ArrayList arrayList = new ArrayList(d.this.aYZ);
                    d.this.H(d.this.b(arrayList.subList(i, arrayList.size()), true));
                    d.h(d.this);
                    d.this.IC();
                } else {
                    ArrayList arrayList2 = new ArrayList(d.this.aYZ);
                    if (d.this.aZa + i <= arrayList2.size()) {
                        d.this.H(d.this.b(arrayList2.subList(i, d.this.aZa + i), true));
                        d.h(d.this);
                        d.this.mHandler.postDelayed(d.this.aZn, 250L);
                        return;
                    }
                    d.this.H(d.this.b(arrayList2.subList(i, arrayList2.size()), true));
                    d.h(d.this);
                    d.this.IC();
                }
            }
        };
        this.aZo = new Runnable() { // from class: com.baidu.live.im.d.14
            @Override // java.lang.Runnable
            public void run() {
                d.this.IF();
            }
        };
        this.aZp = new CustomMessageListener(MessageConfig.SOCKET_RECEIVE_MSG) { // from class: com.baidu.live.im.d.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.Iz();
            }
        };
        this.aZq = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.live.im.d.16
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
                        if (d.this.aYW != null) {
                            d.this.aYW.r(aVar2);
                            d.this.aYW.d(d.this.mMsgList, true);
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
                        if (d.this.aYW != null) {
                            d.this.aYW.r(aVar3);
                            d.this.aYW.d(d.this.mMsgList, true);
                        }
                    }
                }
            }
        };
        this.aZr = new Runnable() { // from class: com.baidu.live.im.d.17
            @Override // java.lang.Runnable
            public void run() {
                if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().getLastReceDataTime() > 35000) {
                    d.this.Iy();
                }
                d.this.Ix();
            }
        };
        this.aZs = new HttpMessageListener(1021013) { // from class: com.baidu.live.im.d.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    boolean z2 = false;
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        int error = httpResponsedMessage.getError();
                        if (com.baidu.live.w.a.Nk().beJ.aHp == 1) {
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
                    if (!z2 && d.this.aYW != null) {
                        d.this.aYW.IG();
                    }
                }
            }
        };
        this.aZt = new HttpMessageListener(1021015) { // from class: com.baidu.live.im.d.19
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
                            if (!d.this.aZj) {
                                d.this.d(jVar.aNZ, jVar.giftName);
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                        }
                        if (d.this.aZj) {
                            d.this.a(jVar.giftId, jVar.aNZ, jVar.aOd, z2, jVar.aOe);
                        }
                    }
                }
            }
        };
        this.aZu = new HttpMessageListener(1021014) { // from class: com.baidu.live.im.d.20
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
                            if (!d.this.aZj) {
                                d.this.d(pVar.aNZ, pVar.giftName);
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                        }
                        if (d.this.aZj) {
                            d.this.a(pVar.giftId, pVar.aNZ, pVar.aOd, z2, pVar.aOe);
                        }
                    }
                }
            }
        };
        this.aZv = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.live.im.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                boolean z2;
                boolean z3;
                if (httpResponsedMessage != null) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof q) {
                        q qVar = (q) orginalMessage;
                        if ((httpResponsedMessage instanceof GiftPackageConsumeHttpResponsedMessage) && TextUtils.isEmpty(((GiftPackageConsumeHttpResponsedMessage) httpResponsedMessage).aOJ)) {
                            if (!d.this.aZj) {
                                d.this.d(qVar.aOI, qVar.giftName);
                            }
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            if (!d.this.aZj) {
                                d.this.d(qVar.aOI, qVar.giftName);
                            }
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (d.this.aZj) {
                            d.this.a(qVar.giftId, qVar.aOI, qVar.aOd, z3, qVar.aOe);
                        }
                    }
                }
            }
        };
        this.aZw = new HttpMessageListener(1021012) { // from class: com.baidu.live.im.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                d.this.a((ResponsedMessage<?>) httpResponsedMessage, false);
            }
        };
        this.aZx = new NetMessageListener(1021050, 601008) { // from class: com.baidu.live.im.d.4
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                JSONObject jSONObject;
                AlaGetLiveStatusHttpResponseMessage alaGetLiveStatusHttpResponseMessage = responsedMessage instanceof AlaGetLiveStatusHttpResponseMessage ? (AlaGetLiveStatusHttpResponseMessage) responsedMessage : null;
                if (alaGetLiveStatusHttpResponseMessage != null) {
                    try {
                        jSONObject = new JSONObject(alaGetLiveStatusHttpResponseMessage.beA);
                    } catch (JSONException e) {
                        jSONObject = null;
                    }
                    if (jSONObject != null) {
                        if (!"backstage_live".equals(jSONObject.optString("content_type"))) {
                            d.this.a(alaGetLiveStatusHttpResponseMessage.beA, jSONObject, 12, false);
                            return;
                        }
                        String optString = jSONObject.optString("backstage_type");
                        if (!TextUtils.isEmpty(optString) && !optString.equals(d.this.aZe)) {
                            d.this.a(alaGetLiveStatusHttpResponseMessage.beA, jSONObject, 13, true);
                            d.this.aZe = optString;
                        }
                    }
                }
            }
        };
        this.count = 1L;
        this.aZy = new CustomMessageListener(2913192) { // from class: com.baidu.live.im.d.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText banlstn sd=" + d.this.aAj);
                if (d.this.aAj != null) {
                    if (d.this.aAj.mLiveInfo.getUserID() == Long.valueOf(TbadkCoreApplication.getCurrentAccount()).longValue()) {
                        Log.i("i", "@@@ localText banlstn own");
                        if (d.this.aAj.aDG != null && d.this.aAj.mLiveInfo != null) {
                            Log.i("i", "@@@ localText banlstn own sdreq");
                            d.this.g(d.this.aAj.aDG.userId, d.this.aAj.mLiveInfo.live_id);
                            return;
                        }
                        return;
                    }
                    Log.i("i", "@@@ localText banlstn oth");
                    if (d.this.aAj.aEf != null && d.this.aAj.mLiveInfo != null) {
                        Log.i("i", "@@@ localText banlstn oth sdreq");
                        d.this.g(d.this.aAj.aEf.userId, d.this.aAj.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.live.im.d.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                    AlaSyncHttpResponseMessage alaSyncHttpResponseMessage = (AlaSyncHttpResponseMessage) httpResponsedMessage;
                    if (alaSyncHttpResponseMessage.getError() == 0 && alaSyncHttpResponseMessage.LH() != null) {
                        d.this.aYS = alaSyncHttpResponseMessage.LH().aHq;
                        d.this.aYT = alaSyncHttpResponseMessage.LH().aHr;
                        d.this.aYU = alaSyncHttpResponseMessage.LH().aHs;
                    }
                }
            }
        };
        this.aZz = new CustomMessageListener(2913185) { // from class: com.baidu.live.im.d.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.aZj && customResponsedMessage != null && (customResponsedMessage.getData() instanceof h)) {
                    h hVar = (h) customResponsedMessage.getData();
                    com.baidu.live.im.data.a b = d.this.b(hVar.giftId, hVar.count + "", hVar.giftName, 0L, hVar.bbb);
                    if (b != null) {
                        double l = d.this.l(b);
                        b.setMsgId(0L);
                        b.setRecordId(0L);
                        com.baidu.live.data.a JK = b.JK();
                        if (JK != null && !StringUtils.isNull(JK.userId) && !StringUtils.isNull(hVar.giftId)) {
                            String str = JK.userId;
                            String nameShow = JK.getNameShow();
                            String str2 = str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + hVar.giftId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + nameShow;
                            if (d.this.aZl == null) {
                                d.this.aZl = new HashMap();
                            }
                            hVar.baX = b;
                            hVar.userId = str;
                            hVar.userName = nameShow;
                            hVar.bba = l;
                            if (!d.this.aZl.containsKey(str2)) {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Long.valueOf(hVar.aOd), hVar);
                                d.this.aZl.put(str2, hashMap);
                                return;
                            }
                            ((HashMap) d.this.aZl.get(str2)).put(Long.valueOf(hVar.aOd), hVar);
                        }
                    }
                }
            }
        };
        this.aZA = new CustomMessageListener(2913184) { // from class: com.baidu.live.im.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                    i iVar = (i) customResponsedMessage.getData();
                    if (iVar.bbf > 0) {
                        HashMap hashMap = (HashMap) d.this.aZk.get(iVar.aST);
                        if (hashMap != null && !hashMap.isEmpty()) {
                            h hVar = (h) hashMap.remove(Long.valueOf(iVar.bbf));
                            if (hVar != null) {
                                hVar.bbd = true;
                                hVar.baX.aj(hVar.count);
                                hVar.baX.o(hVar.bba);
                                hVar.baX.ak(hVar.baZ);
                                d.this.a(-1, hVar.baX);
                                if (d.this.aYW != null) {
                                    d.this.aYW.d(d.this.mMsgList, true);
                                }
                            }
                            if (hashMap.isEmpty()) {
                                d.this.aZk.remove(iVar.aST);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    HashMap hashMap2 = (HashMap) d.this.aZl.get(iVar.aST);
                    if (hashMap2 != null && !hashMap2.isEmpty()) {
                        h hVar2 = (h) hashMap2.get(Long.valueOf(iVar.bbh));
                        if (hVar2 != null) {
                            if (hVar2.bbc != 0) {
                                hVar2.bbd = true;
                                return;
                            }
                            hashMap2.remove(Long.valueOf(iVar.bbh));
                            hVar2.baX.aj(hVar2.count);
                            hVar2.baX.o(hVar2.bba);
                            hVar2.baX.ak(hVar2.baZ);
                            d.this.a(-1, hVar2.baX);
                            if (d.this.aYW != null) {
                                d.this.aYW.d(d.this.mMsgList, true);
                            }
                            long j = hVar2.baY;
                            if (j > 0) {
                                d.this.d(j, hVar2.giftName);
                            }
                        }
                        if (hashMap2.isEmpty()) {
                            d.this.aZl.remove(iVar.aST);
                        }
                    }
                }
            }
        };
        this.aZB = new CustomMessageListener(2913183) { // from class: com.baidu.live.im.d.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                    i iVar = (i) customResponsedMessage.getData();
                    if (iVar.bbf == 0) {
                        HashMap hashMap = (HashMap) d.this.aZl.get(iVar.aST);
                        if (hashMap != null && !hashMap.isEmpty()) {
                            h hVar = (h) hashMap.get(Long.valueOf(iVar.bbh));
                            h hVar2 = (h) hashMap.get(Long.valueOf(iVar.bbk));
                            if (hVar != null && hVar2 != null) {
                                hashMap.remove(Long.valueOf(iVar.bbk));
                                hVar.count += hVar2.count;
                                hVar.baZ += hVar2.baZ;
                                hVar.baY += hVar2.baY;
                                hVar.bbc += hVar2.bbc;
                                if (hVar.bba != hVar2.bba) {
                                    hVar.bba = 0.0d;
                                }
                                hVar.bbe.add(Long.valueOf(hVar2.aOd));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    HashMap hashMap2 = (HashMap) d.this.aZk.get(iVar.aST);
                    if (hashMap2 != null && !hashMap2.isEmpty()) {
                        h hVar3 = (h) hashMap2.get(Long.valueOf(iVar.bbf));
                        h hVar4 = (h) hashMap2.remove(Long.valueOf(iVar.bbi));
                        if (hVar3 != null && hVar4 != null) {
                            hVar3.count += hVar4.count;
                            hVar3.baZ += hVar4.baZ;
                            if (hVar3.bba != hVar4.bba) {
                                hVar3.bba = 0.0d;
                            }
                        }
                    }
                }
            }
        };
        this.aZC = new CustomMessageListener(2913195) { // from class: com.baidu.live.im.d.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                HashMap hashMap;
                h hVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                    i iVar = (i) customResponsedMessage.getData();
                    if (iVar.bbf != 0 && (hashMap = (HashMap) d.this.aZk.get(iVar.aST)) != null && !hashMap.isEmpty() && (hVar = (h) hashMap.get(Long.valueOf(iVar.bbf))) != null) {
                        hVar.count = iVar.bbl;
                        hVar.baZ = iVar.bbm;
                    }
                }
            }
        };
        this.aZD = new HttpMessageListener(1021194) { // from class: com.baidu.live.im.d.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                d.this.aZf = false;
                d.this.mHandler.removeCallbacks(d.this.aZo);
                if (httpResponsedMessage != null) {
                    if (httpResponsedMessage.getOrginalMessage() == null || !(httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.im.message.c) || !((com.baidu.live.im.message.c) httpResponsedMessage.getOrginalMessage()).an(System.currentTimeMillis())) {
                        if (d.this.aZg) {
                            d.this.aZg = false;
                            return;
                        } else if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            ImForbiddenStateData imForbiddenStateData = new ImForbiddenStateData();
                            imForbiddenStateData.errno = httpResponsedMessage.getError();
                            imForbiddenStateData.errMsg = httpResponsedMessage.getErrorString();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, imForbiddenStateData));
                            return;
                        } else if (httpResponsedMessage instanceof AlaForbiddenWordsStateResponseMessage) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, ((AlaForbiddenWordsStateResponseMessage) httpResponsedMessage).bcC));
                            return;
                        } else {
                            return;
                        }
                    }
                    d.this.aZg = false;
                }
            }
        };
        this.aYS = com.baidu.live.w.a.Nk().beJ.aHq;
        this.aYT = com.baidu.live.w.a.Nk().beJ.aHr;
        this.aYU = com.baidu.live.w.a.Nk().beJ.aHs;
        this.mPageContext = bdPageContext;
        this.aYV = z;
        this.aYW = aVar;
        this.mMsgList = new LinkedList<>();
        this.aZk = new LinkedHashMap<>();
        this.aZl = new HashMap<>();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913182, Object.class);
        if (runTask != null && runTask.getData() != null) {
            this.aZj = true;
        }
        MessageManager.getInstance().registerTask(Iw());
        com.baidu.live.tieba.f.a.a.a(1021050, "alaim/gmsg/getLiveStatus", AlaGetLiveStatusHttpResponseMessage.class, false, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021012, "alaim/gmsg/getGroupMsg", ALAGroupHttpResponseMessage.class, false, true, true, true);
        IE();
        registerListener(this.aZD);
        MessageManager.getInstance().registerListener(this.syncListener);
    }

    public void e(r rVar) {
        this.aAj = rVar;
        if (this.aAj != null && this.aAj.mLiveInfo != null) {
            this.aZh = this.aAj.mLiveInfo.audience_count - this.aAj.mLiveInfo.ai_robot_num;
        }
    }

    private HttpMessageTask Iw() {
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
    public void Ix() {
        this.mHandler.postDelayed(this.aZr, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iy() {
        sendMessage(new com.baidu.live.im.message.b(JavaTypesHelper.toInt(this.mGroupId, 0), getLastMid()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iz() {
        this.mHandler.removeCallbacks(this.aZr);
    }

    public void d(long j, String str) {
        if (j == 0) {
            j = 1;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.mPageContext.getString(a.i.sdk_gift);
        }
        com.baidu.live.im.data.a a2 = a((short) 27, String.format(this.mPageContext.getString(a.i.sdk_send_gift_fail), Long.valueOf(j), str), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), this.aEk);
        if (a2 != null) {
            a(-1, a2);
            if (this.aYW != null) {
                this.aYW.r(a2);
                this.aYW.d(this.mMsgList, true);
            }
        }
    }

    public com.baidu.live.im.data.a b(String str, String str2, String str3, long j, boolean z) {
        return a((short) 24, c(str, TextUtils.isEmpty(str2) ? "1" : str2, TextUtils.isEmpty(str3) ? this.mPageContext.getString(a.i.sdk_gift) : str3, j, z).toString(), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), this.aEk);
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
        if (this.aYW != null) {
            this.aYW.r(aVar);
            if (z) {
                this.aYW.d(this.mMsgList, true);
            }
        }
    }

    protected void a(ResponsedMessage<?> responsedMessage, boolean z) {
        boolean z2;
        long j;
        List<com.baidu.live.im.data.a> list;
        if (responsedMessage instanceof ALAGroupHttpResponseMessage) {
            List<com.baidu.live.im.data.a> Kc = ((ALAGroupHttpResponseMessage) responsedMessage).Kc();
            j = ((ALAGroupHttpResponseMessage) responsedMessage).getGroupId();
            list = Kc;
            z2 = ((ALAGroupHttpResponseMessage) responsedMessage).Kb();
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
                K(list);
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
            if (this.aZb != 0) {
                int i2 = this.aZc * this.aZa;
                ArrayList arrayList = new ArrayList(this.aYZ);
                d(0, arrayList.subList(i2, arrayList.size()));
                IC();
            }
            if (list.size() > 0) {
                if (list.size() > 5 && z) {
                    I(list);
                } else {
                    H(a(list, z, z2));
                }
            }
        }
    }

    public void e(String str, String str2, String str3, String str4, String str5) {
        if (this.mMsgList != null) {
            this.mMsgList.clear();
        }
        if (this.aZk != null) {
            this.aZk.clear();
        }
        if (this.aZl != null) {
            this.aZl.clear();
        }
        this.mMsgList = new LinkedList<>();
        this.mGroupId = str;
        this.aYX = str2;
        this.aYY = str3;
        this.mLiveId = str4;
        this.aZe = "0";
        this.mAppId = str5;
        MessageManager.getInstance().registerListener(this.aZw);
        MessageManager.getInstance().registerListener(this.aZx);
        MessageManager.getInstance().registerListener(this.aZp);
        MessageManager.getInstance().registerListener(this.aZs);
        MessageManager.getInstance().registerListener(this.aZq);
        MessageManager.getInstance().registerListener(this.aZt);
        MessageManager.getInstance().registerListener(this.aZu);
        MessageManager.getInstance().registerListener(this.aZv);
        MessageManager.getInstance().registerListener(this.aZz);
        MessageManager.getInstance().registerListener(this.aZA);
        MessageManager.getInstance().registerListener(this.aZB);
        MessageManager.getInstance().registerListener(this.aZC);
        MessageManager.getInstance().registerListener(this.aZy);
        if (BdSocketLinkService.isClose()) {
            Iy();
            BdSocketLinkService.startService(true, "live start");
        }
        String str6 = com.baidu.live.w.a.Nk().beJ.aEW;
        if (!TextUtils.isEmpty(str6)) {
            com.baidu.live.im.data.a ID = ID();
            ID.setMsgType(27);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("text", str6);
                jSONObject.put("content_type", "custom_live_notice");
                ID.setContent(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            a(-1, ID);
            if (this.aYW != null) {
                this.aYW.r(ID);
            }
        }
        String str7 = com.baidu.live.w.a.Nk().beJ.aEX;
        if (!TextUtils.isEmpty(str7)) {
            com.baidu.live.im.data.a ID2 = ID();
            ID2.setMsgType(27);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("text", str7);
                jSONObject2.put("content_type", "custom_live_notice");
                ID2.setContent(jSONObject2.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            a(-1, ID2);
        }
        List<String> list = com.baidu.live.w.a.Nk().beJ.aEV;
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
                    com.baidu.live.im.data.a ID3 = ID();
                    ID3.setMsgType(27);
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("text", str8);
                        jSONObject3.put("content_type", "custom_im_notice");
                        ID3.setContent(jSONObject3.toString());
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                    ID3.setLink(str9);
                    a(-1, ID3);
                    if (this.aYW != null) {
                        this.aYW.r(ID3);
                    }
                }
                i = i2 + 2;
            }
        }
        if (this.aAj != null && this.aAj.aEs != null && !StringUtils.isNull(this.aAj.aEs.Cn())) {
            com.baidu.live.im.data.a ID4 = ID();
            ID4.setMsgType(27);
            try {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("text", this.aAj.aEs.Cn());
                jSONObject4.put("content_type", "custom_live_notice");
                ID4.setContent(jSONObject4.toString());
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            this.mMsgList.add(ID4);
            if (this.aYW != null) {
                this.aYW.r(ID4);
            }
        }
        IA();
        if (this.mMsgList.size() > 0 && this.aYW != null) {
            this.aYW.d(this.mMsgList, true);
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGmsgGetLiveStatusUnabled()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.gN("enter");
                }
            }, 1000L);
        }
        Ix();
        if (TbadkCoreApplication.getInst().isOther()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913146, this.mMsgList));
        }
    }

    private void IA() {
        if (IB()) {
            com.baidu.live.im.data.a ID = ID();
            ID.setMsgType(27);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("text", com.baidu.live.w.a.Nk().beJ.aHm.aDP);
                jSONObject.put("content_type", "custom_im_notice_live_assistant");
                ID.setContent(jSONObject.toString());
                ID.setLink(com.baidu.live.w.a.Nk().beJ.aHm.aDO);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mMsgList.add(ID);
            if (this.aYW != null) {
                this.aYW.r(ID);
            }
        }
    }

    private boolean IB() {
        return (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) || !TbadkCoreApplication.getCurrentAccount().equals(this.aYY) || com.baidu.live.w.a.Nk().beJ == null || com.baidu.live.w.a.Nk().beJ.aHm == null || TextUtils.isEmpty(com.baidu.live.w.a.Nk().beJ.aHm.aDP)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(List<com.baidu.live.im.data.a> list) {
        if (list != null && this.aYW != null) {
            this.aYW.d(this.mMsgList, true);
            for (com.baidu.live.im.data.a aVar : list) {
                this.aYW.r(aVar);
            }
        }
    }

    protected void I(List<com.baidu.live.im.data.a> list) {
        this.aYZ = list;
        this.aZb = (int) ((this.aZd * 2.0f) / 0.25f);
        this.aZc = 0;
        this.aZa = list.size() / this.aZb;
        if (this.aZa <= 0) {
            this.aZa = 1;
        }
        this.mHandler.removeCallbacks(this.aZn);
        this.mHandler.postDelayed(this.aZn, 250L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IC() {
        this.mHandler.removeCallbacks(this.aZn);
        this.aZc = 0;
        this.aZb = 0;
        this.aZa = 0;
        this.aYZ = null;
    }

    protected List<com.baidu.live.im.data.a> b(List<com.baidu.live.im.data.a> list, boolean z) {
        return a(list, z, false);
    }

    protected List<com.baidu.live.im.data.a> a(List<com.baidu.live.im.data.a> list, boolean z, boolean z2) {
        for (com.baidu.live.im.data.a aVar : list) {
            if (aVar instanceof com.baidu.live.im.a) {
                ((com.baidu.live.im.a) aVar).gM(this.aYY);
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
                J(list);
            }
            if (z2 && this.mMsgList.size() > 2) {
                b(list, 2);
            } else {
                b(list, -1);
            }
        }
        if (this.mMsgList.size() > com.baidu.live.w.a.Nk().beJ.aHb) {
            int i = (int) (com.baidu.live.w.a.Nk().beJ.aHb * 0.7d);
            if (i <= 0) {
                i = 1;
            }
            while (this.mMsgList.size() > i) {
                this.mMsgList.removeFirst();
            }
        }
        return list;
    }

    private void J(List<com.baidu.live.im.data.a> list) {
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
        com.baidu.live.data.a JK = aVar.JK();
        if (JK != null && (list = JK.aCU) != null && !list.isEmpty()) {
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
            d = com.baidu.live.w.d.Nr().g(z, jSONObject.optString(LogConfig.LOG_GIFT_ID));
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
                        if (!TextUtils.isEmpty(optString) && (optString.equals("challenge_direct_start") || optString.equals("challenge_direct_matched") || optString.equals("challenge_random_start") || optString.equals("challenge_random_matched") || optString.equals("live_net_status") || optString.equals("send_redpacket") || optString.equals("start_grab_redpacket") || optString.equals("guard_seat") || optString.equals("multi_session") || optString.equals("fullscreen") || optString.equals("challenge_mvp") || optString.equals("challenge_mvp_punish") || optString.equals("challenge_winner_by_autofail") || optString.equals("official_notice") || optString.equals("privilege_award_royal_success"))) {
                            it.remove();
                        }
                    } catch (JSONException e) {
                    }
                }
            }
        }
    }

    private void K(List<com.baidu.live.im.data.a> list) {
        if (list != null && !list.isEmpty()) {
            for (com.baidu.live.im.data.a aVar : list) {
                aVar.bR(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.live.im.data.a aVar) {
        if (this.aZh < this.aYS) {
            if (i >= 0) {
                this.mMsgList.add(i, aVar);
            } else {
                this.mMsgList.addLast(aVar);
            }
        } else if (this.aZh >= this.aYS && this.aZh < this.aYT) {
            if (p(aVar)) {
                aVar.JW();
            }
            if (i >= 0) {
                this.mMsgList.add(i, aVar);
            } else if (!this.mMsgList.isEmpty() && p(this.mMsgList.getLast())) {
                this.mMsgList.set(this.mMsgList.size() - 1, aVar);
            } else {
                this.mMsgList.addLast(aVar);
            }
        } else if (this.aZh >= this.aYT && this.aZh < this.aYU) {
            if (n(aVar)) {
                aVar.JW();
            }
            if (i >= 0) {
                this.mMsgList.add(i, aVar);
            } else if (!this.mMsgList.isEmpty() && n(this.mMsgList.getLast())) {
                this.mMsgList.set(this.mMsgList.size() - 1, aVar);
            } else {
                this.mMsgList.addLast(aVar);
            }
        } else if (this.aZh >= this.aYU) {
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
        this.aZi = 0;
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
                if (com.baidu.live.entereffect.a.Dg().h(aVar)) {
                    this.aZi = 2;
                } else {
                    this.aZi = 1;
                }
            } else {
                this.aZi = 0;
            }
        }
        return this.aZi;
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
                    if (aVar != null && aVar.JK() != null && !TextUtils.isEmpty(aVar.JK().userId) && aVar.JK().userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        int i2 = size - 1;
                        while (true) {
                            if (i2 >= 0 && i2 >= 0) {
                                com.baidu.live.im.data.a aVar2 = list.get(i2);
                                if (aVar2 != null && aVar2.JK() != null && !TextUtils.isEmpty(aVar2.JK().userId) && aVar2.JK().userId.equals(TbadkCoreApplication.getCurrentAccount()) && aVar.getRecordId() == aVar2.getRecordId()) {
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
            if (!ListUtils.isEmpty(aVar.JM()) && !aVar.JM().contains(Long.valueOf(currentAccountId))) {
                linkedList.add(aVar);
            } else {
                boolean z2 = aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                if (z2 && aVar.getMsgType() == 1 && !ListUtils.isEmpty(aVar.JK().aCU) && this.aEk == null) {
                    this.aEk = aVar.JK().aCU;
                }
                if (z2 && aVar.getMsgType() != 125 && aVar.getMsgType() != 24 && aVar.getMsgType() != 13 && aVar.getMsgType() != 28) {
                    if (aVar.getMsgType() != 1 || !z) {
                        linkedList.add(aVar);
                    }
                } else if (this.aZj && z2 && aVar.getMsgType() == 24) {
                    linkedList.add(aVar);
                } else if (aVar.getMsgType() == 125) {
                    try {
                        if (!"1".equals(new JSONObject(aVar.getContent()).optString("is_first"))) {
                            linkedList.add(aVar);
                            if (this.aYW != null) {
                                this.aYW.r(aVar);
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
                    if ("enter_live".equals(str) && this.aZh < this.aYU) {
                        if (com.baidu.live.entereffect.a.Dg().h(aVar)) {
                        }
                    } else if ("close_live".equals(str)) {
                        linkedList.add(aVar);
                        if (this.aYW != null) {
                            this.aYW.r(aVar);
                        }
                    } else if ("task".equals(str)) {
                        linkedList.add(aVar);
                        if (this.aYW != null) {
                            this.aYW.r(aVar);
                        }
                    } else if ("live_achievement".equals(str)) {
                        linkedList.add(aVar);
                        if (this.aYW != null) {
                            this.aYW.r(aVar);
                        }
                    } else if ("ss_hot_live".equals(str)) {
                        linkedList.add(aVar);
                        if (this.aYW != null) {
                            this.aYW.r(aVar);
                        }
                    } else if ("challenge_direct_new".equals(str)) {
                        linkedList.add(aVar);
                        if (this.aYW != null) {
                            this.aYW.r(aVar);
                        }
                    } else if ("challenge_random_cancel".equals(str)) {
                        linkedList.add(aVar);
                        if (this.aYW != null) {
                            this.aYW.r(aVar);
                        }
                    } else if ("update_liveinfo".equals(str)) {
                        linkedList.add(aVar);
                        if (this.aYW != null) {
                            this.aYW.r(aVar);
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
                        if (z2 && !ListUtils.isEmpty(aVar.JK().aCU)) {
                            this.aEk = aVar.JK().aCU;
                            if (this.aAj != null) {
                                this.aAj.aEk = this.aEk;
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
                        } else if (TextUtils.equals(str, "multi_session")) {
                            linkedList.add(aVar);
                            if (this.aYW != null) {
                                this.aYW.r(aVar);
                            }
                        } else if (TextUtils.equals(str, "fullscreen")) {
                            linkedList.add(aVar);
                            if (this.aYW != null) {
                                this.aYW.r(aVar);
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
                                if (this.aYW != null) {
                                    this.aYW.r(aVar);
                                }
                            } else if ("introduce_goods".equals(str)) {
                                linkedList.add(aVar);
                                if (this.aYW != null) {
                                    this.aYW.r(aVar);
                                }
                            } else if ("first_recharge_success".equals(str)) {
                                linkedList.add(aVar);
                                if (this.aYW != null) {
                                    this.aYW.r(aVar);
                                }
                            } else if ("privilege_award_success".equals(str)) {
                                linkedList.add(aVar);
                                if (this.aYW != null) {
                                    this.aYW.r(aVar);
                                }
                            } else if ("need_update_live_mark_info".equals(str)) {
                                linkedList.add(aVar);
                                if (this.aYW != null) {
                                    this.aYW.r(aVar);
                                }
                            } else if ("official_notice".equals(str)) {
                                linkedList.add(aVar);
                                if (this.aYW != null && !z) {
                                    this.aYW.r(aVar);
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
                    if (this.aYW != null) {
                        this.aYW.r(aVar);
                    }
                    gN("push");
                }
            }
        }
        if (linkedList.size() > 0) {
            list.removeAll(linkedList);
        }
    }

    protected com.baidu.live.im.data.a a(short s, String str, boolean z, boolean z2, int i, List<AlaLiveMarkData> list) {
        long j = 0;
        com.baidu.live.im.data.a ID = ID();
        if (ID == null) {
            return null;
        }
        ID.setMsgType(s);
        ID.setContent(str);
        long ai = o.ai(getLastMid());
        ID.setMsgId(ai);
        ID.setRecordId(ai);
        ID.setTime(System.currentTimeMillis() / 1000);
        com.baidu.live.data.a aVar = new com.baidu.live.data.a();
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            aVar.userName = TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow();
        }
        aVar.userId = TbadkCoreApplication.getCurrentAccount();
        if (this.aAj != null && this.aAj.aEf != null && !TextUtils.isEmpty(this.aAj.aEf.portrait)) {
            aVar.portrait = this.aAj.aEf.portrait;
        } else {
            aVar.portrait = TbadkCoreApplication.getCurrentPortrait();
        }
        aVar.level_id = i;
        aVar.aCR = z;
        aVar.aCS = z2;
        if (list != null) {
            aVar.aCU = new ArrayList(list);
        }
        ID.e(aVar);
        try {
            j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        } catch (Exception e) {
        }
        ID.setUserId(j);
        return ID;
    }

    private long getLastMid() {
        if (this.mMsgList == null || this.mMsgList.size() <= 0) {
            return JavaTypesHelper.toLong(this.aYX, 1L);
        }
        return this.mMsgList.get(this.mMsgList.size() - 1).getMsgId();
    }

    protected com.baidu.live.im.data.a ID() {
        com.baidu.live.im.a aVar = new com.baidu.live.im.a();
        aVar.setBornTime(System.currentTimeMillis());
        if (TextUtils.isEmpty(this.mGroupId)) {
            return null;
        }
        aVar.gM(this.aYY);
        return aVar;
    }

    public void L(List<AlaLiveMarkData> list) {
        this.aEk = list;
    }

    public void gN(String str) {
        com.baidu.live.message.c cVar = new com.baidu.live.message.c(JavaTypesHelper.toLong(this.mLiveId, 0L), str);
        cVar.setParams();
        sendMessage(cVar);
    }

    public void gO(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.aZe)) {
            gN("getliveinfo");
        }
    }

    private List<com.baidu.live.im.data.a> q(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        int optInt;
        boolean DY;
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
            com.baidu.live.gift.g go = v.go(jSONObject.optString(LogConfig.LOG_GIFT_ID));
            DY = go != null ? go.DY() : false;
        } catch (JSONException e) {
            arrayList.add(aVar2);
        }
        if (optInt == 1 || DY) {
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
            aVar3.gM(aVar2.Iu());
            aVar3.setBornTime(aVar2.getBornTime());
            aVar3.setTime(aVar2.getTime());
            aVar3.setUserId(aVar2.getUserId());
            aVar3.setToUserId(aVar2.getToUserId());
            aVar3.f(aVar2.JL());
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
            aVar3.e(aVar2.JK());
            aVar3.setSt_type(aVar2.getSt_type());
            arrayList.add(aVar3);
        }
        return arrayList;
    }

    public void a(int i, String str, com.baidu.live.data.a aVar) {
        com.baidu.live.im.data.a ID = ID();
        if (ID != null) {
            ID.setMsgType(i);
            ID.setContent(str);
            ID.e(aVar);
            a(-1, ID);
            if (this.aYW != null) {
                this.aYW.d(this.mMsgList, true);
                this.aYW.r(ID);
            }
        }
    }

    private void b(List<com.baidu.live.im.data.a> list, int i) {
        JSONObject jSONObject;
        int i2;
        if (this.aZj) {
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
                            com.baidu.live.data.a JK = aVar.JK();
                            if (JK == null || StringUtils.isNull(JK.userId) || StringUtils.isNull(optString)) {
                                if (i >= 0) {
                                    a(i + i4, aVar);
                                } else {
                                    a(-1, aVar);
                                }
                            } else {
                                String str = JK.userId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + optString + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + JK.getNameShow();
                                if (this.aZk == null) {
                                    this.aZk = new LinkedHashMap<>();
                                }
                                long j = JavaTypesHelper.toLong(jSONObject.optString("gift_count"), 0L);
                                double optDouble = jSONObject.optDouble("gift_rate", 0.0d);
                                long j2 = JavaTypesHelper.toLong(jSONObject.optString("charm_value"), 0L);
                                h hVar = new h();
                                hVar.baX = aVar;
                                hVar.count = j;
                                hVar.bba = optDouble;
                                hVar.baZ = j2;
                                if (com.baidu.live.w.a.Nk().beJ == null) {
                                    i2 = 100;
                                } else {
                                    i2 = com.baidu.live.w.a.Nk().beJ.aHg * 2;
                                }
                                Iterator<String> it = this.aZk.keySet().iterator();
                                int i5 = 0;
                                while (it.hasNext()) {
                                    String next = it.next();
                                    if (this.aZk.get(next) == null || this.aZk.get(next).isEmpty()) {
                                        it.remove();
                                    } else {
                                        HashMap<Long, h> hashMap = this.aZk.get(next);
                                        Iterator<Long> it2 = hashMap.keySet().iterator();
                                        while (it2.hasNext()) {
                                            long longValue = it2.next().longValue();
                                            if (hashMap.get(Long.valueOf(longValue)) == null || hashMap.get(Long.valueOf(longValue)).bbd) {
                                                it2.remove();
                                            }
                                        }
                                        if (this.aZk.get(next) == null || this.aZk.get(next).isEmpty()) {
                                            it.remove();
                                        } else {
                                            i5 = hashMap.size() + i5;
                                        }
                                    }
                                }
                                if (i5 > i2) {
                                    int i6 = i5 - ((int) (i2 * 0.7d));
                                    Iterator<String> it3 = this.aZk.keySet().iterator();
                                    while (true) {
                                        int i7 = i6;
                                        if (!it3.hasNext()) {
                                            break;
                                        }
                                        i6 = i7 - this.aZk.get(it3.next()).size();
                                        it3.remove();
                                        if (i6 <= 0) {
                                            break;
                                        }
                                    }
                                }
                                if (!this.aZk.containsKey(str)) {
                                    HashMap<Long, h> hashMap2 = new HashMap<>();
                                    hashMap2.put(Long.valueOf(aVar.getMsgId()), hVar);
                                    this.aZk.put(str, hashMap2);
                                } else {
                                    this.aZk.get(str).put(Long.valueOf(aVar.getMsgId()), hVar);
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
            HashMap<Long, h> hashMap = this.aZl.get(str3);
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
                            if (next.bbe.contains(l)) {
                                hVar = next;
                                break;
                            }
                        }
                    }
                    if (hVar != null) {
                        long longValue = map.get(l).longValue();
                        if (z) {
                            hVar.baY += longValue;
                        }
                        hVar.bbc -= longValue;
                        if (hVar.bbd && hVar.bbc == 0) {
                            hashMap.remove(Long.valueOf(hVar.aOd));
                            hVar.baX.aj(hVar.count);
                            hVar.baX.o(hVar.bba);
                            hVar.baX.ak(hVar.baZ);
                            a(-1, hVar.baX);
                            if (this.aYW != null) {
                                this.aYW.d(this.mMsgList, true);
                            }
                            long j3 = hVar.baY;
                            if (j3 > 0) {
                                d(j3, hVar.giftName);
                            }
                        }
                    }
                }
                if (hashMap.isEmpty()) {
                    this.aZl.remove(str3);
                }
            }
        }
    }

    public void bM(boolean z) {
        this.mGroupId = null;
        this.aYX = null;
        this.mLiveId = null;
        this.aZe = "0";
        this.mAppId = null;
        this.aZf = false;
        this.aZg = false;
        MessageManager.getInstance().unRegisterListener(this.aZx);
        MessageManager.getInstance().unRegisterListener(this.aZw);
        MessageManager.getInstance().unRegisterListener(this.aZp);
        MessageManager.getInstance().unRegisterListener(this.aZs);
        MessageManager.getInstance().unRegisterListener(this.aZt);
        MessageManager.getInstance().unRegisterListener(this.aZu);
        MessageManager.getInstance().unRegisterListener(this.aZv);
        MessageManager.getInstance().unRegisterListener(this.aZq);
        MessageManager.getInstance().unRegisterListener(this.aZz);
        MessageManager.getInstance().unRegisterListener(this.aZA);
        MessageManager.getInstance().unRegisterListener(this.aZB);
        MessageManager.getInstance().unRegisterListener(this.aZC);
        MessageManager.getInstance().unRegisterListener(this.aZy);
        if (z) {
            MessageManager.getInstance().unRegisterListener(this.syncListener);
        }
        this.mHandler.removeCallbacks(this.aZo);
        this.mHandler.removeCallbacks(this.aZn);
        this.mHandler.removeCallbacks(this.aZr);
        if (this.mMsgList != null) {
            this.mMsgList.clear();
        }
        this.mMsgList = null;
        if (this.aZk != null) {
            this.aZk.clear();
        }
        if (this.aZl != null) {
            this.aZl.clear();
        }
    }

    private void IE() {
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
            com.baidu.live.im.data.a a2 = a(s, str2, z, z2, i, this.aEk);
            if (s == 126) {
                a2.ew(imSendMsgData.barrageType);
                a2.gS(imSendMsgData.barrageId);
                a2.a(imSendMsgData.barrageCardInfo);
            }
            if (a2 != null) {
                a2.k(strArr);
                a(-1, a2);
                if (this.aYW != null) {
                    this.aYW.r(a2);
                    this.aYW.d(this.mMsgList, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913043));
                com.baidu.live.im.message.a aVar = new com.baidu.live.im.message.a(str2, s, JavaTypesHelper.toInt(this.mGroupId, 0), this.mAppId);
                if (this.aAj != null && this.aAj.mLiveInfo != null) {
                    aVar.gc(this.aAj.mLiveInfo.live_id + "");
                    aVar.gT(this.aAj.mLiveInfo.room_id + "");
                } else {
                    aVar.gc("");
                    aVar.gT("");
                }
                aVar.setOtherParams(str);
                aVar.al(imSendMsgData.price);
                aVar.ew(imSendMsgData.barrageType);
                aVar.gS(imSendMsgData.barrageId);
                aVar.a(imSendMsgData.barrageCardInfo);
                aVar.k(strArr);
                aVar.bS(imSendMsgData.isQuick);
                sendMessage(aVar);
            }
        }
    }

    public void g(long j, long j2) {
        if (!this.aZf) {
            this.aZf = true;
            com.baidu.live.im.message.c cVar = new com.baidu.live.im.message.c(1021194);
            cVar.addParam("user_id", j);
            cVar.addParam("live_id", j2);
            cVar.am(System.currentTimeMillis());
            sendMessage(cVar);
            this.mHandler.postDelayed(this.aZo, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IF() {
        this.aZf = false;
        this.aZg = true;
        ImForbiddenStateData imForbiddenStateData = new ImForbiddenStateData();
        imForbiddenStateData.errno = -1;
        imForbiddenStateData.errMsg = this.mPageContext.getString(a.i.sdk_neterror);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, imForbiddenStateData));
    }
}
