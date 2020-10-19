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
import com.baidu.live.data.u;
import com.baidu.live.gift.GiftPackageConsumeHttpResponsedMessage;
import com.baidu.live.gift.q;
import com.baidu.live.gift.w;
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
    private u aDU;
    private List<AlaLiveMarkData> aIm;
    private boolean aTT;
    private CustomMessageListener bal;
    public int beZ;
    private CustomMessageListener bfA;
    private Runnable bfB;
    private HttpMessageListener bfC;
    private HttpMessageListener bfD;
    private HttpMessageListener bfE;
    private HttpMessageListener bfF;
    private HttpMessageListener bfG;
    private NetMessageListener bfH;
    CustomMessageListener bfI;
    CustomMessageListener bfJ;
    CustomMessageListener bfK;
    CustomMessageListener bfL;
    CustomMessageListener bfM;
    private HttpMessageListener bfN;
    public int bfa;
    public int bfc;
    private boolean bfd;
    private a bfe;
    private String bff;
    private String bfg;
    private List<com.baidu.live.im.data.a> bfh;
    private int bfi;
    private int bfj;
    private int bfk;
    private float bfl;
    private String bfm;
    private String bfn;
    private boolean bfo;
    private boolean bfp;
    private int bfq;
    private int bfr;
    private boolean bft;
    private LinkedHashMap<String, HashMap<Long, h>> bfu;
    private HashMap<String, HashMap<Long, h>> bfv;
    private b.a bfw;
    private Runnable bfx;
    private Runnable bfy;
    private CustomMessageListener bfz;
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
        void Kr();

        void d(List<com.baidu.live.im.data.a> list, boolean z);

        void r(com.baidu.live.im.data.a aVar);
    }

    static /* synthetic */ int h(d dVar) {
        int i = dVar.bfk;
        dVar.bfk = i + 1;
        return i;
    }

    public d(BdPageContext<?> bdPageContext, boolean z, a aVar) {
        super(bdPageContext);
        this.mLiveId = null;
        this.bfl = 1.0f;
        this.mHandler = new Handler();
        this.bfm = null;
        this.aTT = false;
        this.bfn = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION;
        this.bfo = false;
        this.bfp = false;
        this.bfr = 0;
        this.bft = false;
        this.bfw = new b.a() { // from class: com.baidu.live.im.d.1
        };
        this.bfx = new Runnable() { // from class: com.baidu.live.im.d.12
            @Override // java.lang.Runnable
            public void run() {
                int i = d.this.bfk * d.this.bfi;
                if (i >= d.this.bfh.size()) {
                    d.this.Kn();
                } else if (d.this.bfk >= d.this.bfj - 1) {
                    if (d.this.bfk != d.this.bfj - 1) {
                        d.this.Kn();
                        return;
                    }
                    ArrayList arrayList = new ArrayList(d.this.bfh);
                    d.this.M(d.this.b(arrayList.subList(i, arrayList.size()), true));
                    d.h(d.this);
                    d.this.Kn();
                } else {
                    ArrayList arrayList2 = new ArrayList(d.this.bfh);
                    if (d.this.bfi + i <= arrayList2.size()) {
                        d.this.M(d.this.b(arrayList2.subList(i, d.this.bfi + i), true));
                        d.h(d.this);
                        d.this.mHandler.postDelayed(d.this.bfx, 250L);
                        return;
                    }
                    d.this.M(d.this.b(arrayList2.subList(i, arrayList2.size()), true));
                    d.h(d.this);
                    d.this.Kn();
                }
            }
        };
        this.bfy = new Runnable() { // from class: com.baidu.live.im.d.15
            @Override // java.lang.Runnable
            public void run() {
                d.this.Kq();
            }
        };
        this.bal = new CustomMessageListener(2913238) { // from class: com.baidu.live.im.d.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null) {
                    d.this.aTT = ((Boolean) customResponsedMessage.getData()).booleanValue();
                }
            }
        };
        this.bfz = new CustomMessageListener(MessageConfig.SOCKET_RECEIVE_MSG) { // from class: com.baidu.live.im.d.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.Kj();
            }
        };
        this.bfA = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.live.im.d.18
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
                        if (d.this.bfe != null) {
                            d.this.bfe.r(aVar2);
                            d.this.bfe.d(d.this.mMsgList, true);
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
                        if (d.this.bfe != null) {
                            d.this.bfe.r(aVar3);
                            d.this.bfe.d(d.this.mMsgList, true);
                        }
                    }
                }
            }
        };
        this.bfB = new Runnable() { // from class: com.baidu.live.im.d.19
            @Override // java.lang.Runnable
            public void run() {
                if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().getLastReceDataTime() > 35000) {
                    d.this.Ki();
                }
                d.this.Kh();
            }
        };
        this.bfC = new HttpMessageListener(1021013) { // from class: com.baidu.live.im.d.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    boolean z2 = false;
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        int error = httpResponsedMessage.getError();
                        if (com.baidu.live.x.a.OS().blo.aLK == 1) {
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
                    if (!z2 && d.this.bfe != null) {
                        d.this.bfe.Kr();
                    }
                }
            }
        };
        this.bfD = new HttpMessageListener(1021015) { // from class: com.baidu.live.im.d.21
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
                            if (!d.this.bft) {
                                d.this.e(jVar.aTi, jVar.giftName);
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                        }
                        if (d.this.bft) {
                            d.this.a(jVar.giftId, jVar.aTi, jVar.aTm, z2, jVar.aTo);
                        }
                    }
                }
            }
        };
        this.bfE = new HttpMessageListener(1021014) { // from class: com.baidu.live.im.d.2
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
                            if (!d.this.bft) {
                                d.this.e(pVar.aTi, pVar.giftName);
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                        }
                        if (d.this.bft) {
                            d.this.a(pVar.giftId, pVar.aTi, pVar.aTm, z2, pVar.aTo);
                        }
                    }
                }
            }
        };
        this.bfF = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_SHARE_IN_BAR) { // from class: com.baidu.live.im.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                boolean z2;
                boolean z3;
                if (httpResponsedMessage != null) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof q) {
                        q qVar = (q) orginalMessage;
                        if ((httpResponsedMessage instanceof GiftPackageConsumeHttpResponsedMessage) && TextUtils.isEmpty(((GiftPackageConsumeHttpResponsedMessage) httpResponsedMessage).aTW)) {
                            if (!d.this.bft) {
                                d.this.e(qVar.aTS, qVar.giftName);
                            }
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            if (!d.this.bft) {
                                d.this.e(qVar.aTS, qVar.giftName);
                            }
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (d.this.bft) {
                            d.this.a(qVar.giftId, qVar.aTS, qVar.aTm, z3, qVar.aTo);
                        }
                    }
                }
            }
        };
        this.bfG = new HttpMessageListener(1021012) { // from class: com.baidu.live.im.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                d.this.a((ResponsedMessage<?>) httpResponsedMessage, false);
            }
        };
        this.bfH = new NetMessageListener(1021050, 601008) { // from class: com.baidu.live.im.d.5
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                JSONObject jSONObject;
                AlaGetLiveStatusHttpResponseMessage alaGetLiveStatusHttpResponseMessage = responsedMessage instanceof AlaGetLiveStatusHttpResponseMessage ? (AlaGetLiveStatusHttpResponseMessage) responsedMessage : null;
                if (alaGetLiveStatusHttpResponseMessage != null) {
                    try {
                        jSONObject = new JSONObject(alaGetLiveStatusHttpResponseMessage.ble);
                    } catch (JSONException e) {
                        jSONObject = null;
                    }
                    if (jSONObject != null) {
                        if (!"backstage_live".equals(jSONObject.optString("content_type"))) {
                            d.this.a(alaGetLiveStatusHttpResponseMessage.ble, jSONObject, 12, false);
                            return;
                        }
                        String optString = jSONObject.optString("backstage_type");
                        String optString2 = jSONObject.optString("text");
                        if (!TextUtils.isEmpty(optString) && !optString.equals(d.this.bfm) && !TextUtils.isEmpty(optString2)) {
                            d.this.a(alaGetLiveStatusHttpResponseMessage.ble, jSONObject, 13, true);
                            d.this.bfm = optString;
                        }
                    }
                }
            }
        };
        this.count = 1L;
        this.bfI = new CustomMessageListener(2913192) { // from class: com.baidu.live.im.d.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText banlstn sd=" + d.this.aDU);
                if (d.this.aDU != null) {
                    if (d.this.aDU.mLiveInfo.getUserID() == Long.valueOf(TbadkCoreApplication.getCurrentAccount()).longValue()) {
                        Log.i("i", "@@@ localText banlstn own");
                        if (d.this.aDU.aHD != null && d.this.aDU.mLiveInfo != null) {
                            Log.i("i", "@@@ localText banlstn own sdreq");
                            d.this.g(d.this.aDU.aHD.userId, d.this.aDU.mLiveInfo.live_id);
                            return;
                        }
                        return;
                    }
                    Log.i("i", "@@@ localText banlstn oth");
                    if (d.this.aDU.aIf != null && d.this.aDU.mLiveInfo != null) {
                        Log.i("i", "@@@ localText banlstn oth sdreq");
                        d.this.g(d.this.aDU.aIf.userId, d.this.aDU.mLiveInfo.live_id);
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
                    if (alaSyncHttpResponseMessage.getError() == 0 && alaSyncHttpResponseMessage.Nn() != null) {
                        d.this.beZ = alaSyncHttpResponseMessage.Nn().aLL;
                        d.this.bfa = alaSyncHttpResponseMessage.Nn().aLM;
                        d.this.bfc = alaSyncHttpResponseMessage.Nn().aLN;
                    }
                }
            }
        };
        this.bfJ = new CustomMessageListener(2913185) { // from class: com.baidu.live.im.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.bft && customResponsedMessage != null && (customResponsedMessage.getData() instanceof h)) {
                    h hVar = (h) customResponsedMessage.getData();
                    com.baidu.live.im.data.a b = d.this.b(hVar.giftId, hVar.count + "", hVar.giftName, 0L, hVar.bhl);
                    if (b != null) {
                        double l = d.this.l(b);
                        b.setMsgId(0L);
                        b.setRecordId(0L);
                        com.baidu.live.data.a Lt = b.Lt();
                        if (Lt != null && !StringUtils.isNull(Lt.userId) && !StringUtils.isNull(hVar.giftId)) {
                            String str = Lt.userId;
                            String nameShow = Lt.getNameShow();
                            String str2 = str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + hVar.giftId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + nameShow;
                            if (d.this.bfv == null) {
                                d.this.bfv = new HashMap();
                            }
                            hVar.bhh = b;
                            hVar.userId = str;
                            hVar.userName = nameShow;
                            hVar.bhk = l;
                            if (d.this.aTT) {
                                d.this.a(hVar);
                            }
                            if (!d.this.bfv.containsKey(str2)) {
                                HashMap hashMap = new HashMap();
                                hashMap.put(Long.valueOf(hVar.aTm), hVar);
                                d.this.bfv.put(str2, hashMap);
                                return;
                            }
                            ((HashMap) d.this.bfv.get(str2)).put(Long.valueOf(hVar.aTm), hVar);
                        }
                    }
                }
            }
        };
        this.bfK = new CustomMessageListener(2913184) { // from class: com.baidu.live.im.d.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                    i iVar = (i) customResponsedMessage.getData();
                    if (iVar.bhq > 0) {
                        HashMap hashMap = (HashMap) d.this.bfu.get(iVar.aYp);
                        if (hashMap != null && !hashMap.isEmpty()) {
                            h hVar = (h) hashMap.remove(Long.valueOf(iVar.bhq));
                            if (hVar != null) {
                                hVar.bhn = true;
                                hVar.bhh.aj(hVar.count);
                                hVar.bhh.o(hVar.bhk);
                                if (hVar.bhh.isHost()) {
                                    hVar.bhh.ak(-1L);
                                } else {
                                    hVar.bhh.ak(hVar.bhj);
                                }
                                d.this.a(-1, hVar.bhh);
                                if (d.this.bfe != null) {
                                    d.this.bfe.d(d.this.mMsgList, true);
                                }
                            }
                            if (hashMap.isEmpty()) {
                                d.this.bfu.remove(iVar.aYp);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    HashMap hashMap2 = (HashMap) d.this.bfv.get(iVar.aYp);
                    if (hashMap2 != null && !hashMap2.isEmpty()) {
                        h hVar2 = (h) hashMap2.get(Long.valueOf(iVar.bhs));
                        if (hVar2 != null) {
                            if (hVar2.bhm != 0) {
                                hVar2.bhn = true;
                                return;
                            }
                            hashMap2.remove(Long.valueOf(iVar.bhs));
                            hVar2.bhh.aj(hVar2.count);
                            hVar2.bhh.o(hVar2.bhk);
                            if (hVar2.bhh.isHost()) {
                                hVar2.bhh.ak(-1L);
                            } else {
                                hVar2.bhh.ak(hVar2.bhj);
                            }
                            d.this.a(-1, hVar2.bhh);
                            if (d.this.bfe != null) {
                                d.this.bfe.d(d.this.mMsgList, true);
                            }
                            long j = hVar2.bhi;
                            if (j > 0) {
                                d.this.e(j, hVar2.giftName);
                            }
                        }
                        if (hashMap2.isEmpty()) {
                            d.this.bfv.remove(iVar.aYp);
                        }
                    }
                }
            }
        };
        this.bfL = new CustomMessageListener(2913183) { // from class: com.baidu.live.im.d.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                    i iVar = (i) customResponsedMessage.getData();
                    if (iVar.bhq == 0) {
                        HashMap hashMap = (HashMap) d.this.bfv.get(iVar.aYp);
                        if (hashMap != null && !hashMap.isEmpty()) {
                            h hVar = (h) hashMap.get(Long.valueOf(iVar.bhs));
                            h hVar2 = (h) hashMap.get(Long.valueOf(iVar.bhv));
                            if (hVar != null && hVar2 != null) {
                                hashMap.remove(Long.valueOf(iVar.bhv));
                                hVar.count += hVar2.count;
                                hVar.bhj += hVar2.bhj;
                                hVar.bhi += hVar2.bhi;
                                hVar.bhm += hVar2.bhm;
                                if (hVar.bhk != hVar2.bhk) {
                                    hVar.bhk = 0.0d;
                                }
                                hVar.bho.add(Long.valueOf(hVar2.aTm));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    HashMap hashMap2 = (HashMap) d.this.bfu.get(iVar.aYp);
                    if (hashMap2 != null && !hashMap2.isEmpty()) {
                        h hVar3 = (h) hashMap2.get(Long.valueOf(iVar.bhq));
                        h hVar4 = (h) hashMap2.remove(Long.valueOf(iVar.bht));
                        if (hVar3 != null && hVar4 != null) {
                            hVar3.count += hVar4.count;
                            hVar3.bhj += hVar4.bhj;
                            if (hVar3.bhk != hVar4.bhk) {
                                hVar3.bhk = 0.0d;
                            }
                        }
                    }
                }
            }
        };
        this.bfM = new CustomMessageListener(2913195) { // from class: com.baidu.live.im.d.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                HashMap hashMap;
                h hVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                    i iVar = (i) customResponsedMessage.getData();
                    if (iVar.bhq != 0 && (hashMap = (HashMap) d.this.bfu.get(iVar.aYp)) != null && !hashMap.isEmpty() && (hVar = (h) hashMap.get(Long.valueOf(iVar.bhq))) != null) {
                        hVar.count = iVar.bhw;
                        hVar.bhj = iVar.bhx;
                    }
                }
            }
        };
        this.bfN = new HttpMessageListener(1021194) { // from class: com.baidu.live.im.d.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                d.this.bfo = false;
                d.this.mHandler.removeCallbacks(d.this.bfy);
                if (httpResponsedMessage != null) {
                    if (httpResponsedMessage.getOrginalMessage() == null || !(httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.im.message.c) || !((com.baidu.live.im.message.c) httpResponsedMessage.getOrginalMessage()).an(System.currentTimeMillis())) {
                        if (d.this.bfp) {
                            d.this.bfp = false;
                            return;
                        } else if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            ImForbiddenStateData imForbiddenStateData = new ImForbiddenStateData();
                            imForbiddenStateData.errno = httpResponsedMessage.getError();
                            imForbiddenStateData.errMsg = httpResponsedMessage.getErrorString();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, imForbiddenStateData));
                            return;
                        } else if (httpResponsedMessage instanceof AlaForbiddenWordsStateResponseMessage) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, ((AlaForbiddenWordsStateResponseMessage) httpResponsedMessage).bjb));
                            return;
                        } else {
                            return;
                        }
                    }
                    d.this.bfp = false;
                }
            }
        };
        this.beZ = com.baidu.live.x.a.OS().blo.aLL;
        this.bfa = com.baidu.live.x.a.OS().blo.aLM;
        this.bfc = com.baidu.live.x.a.OS().blo.aLN;
        this.mPageContext = bdPageContext;
        this.bfd = z;
        this.bfe = aVar;
        this.mMsgList = new LinkedList<>();
        this.bfu = new LinkedHashMap<>();
        this.bfv = new HashMap<>();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913182, Object.class);
        if (runTask != null && runTask.getData() != null) {
            this.bft = true;
        }
        MessageManager.getInstance().registerTask(Kg());
        com.baidu.live.tieba.f.a.a.a(1021050, "alaim/gmsg/getLiveStatus", AlaGetLiveStatusHttpResponseMessage.class, false, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021012, "alaim/gmsg/getGroupMsg", ALAGroupHttpResponseMessage.class, false, true, true, true);
        Kp();
        registerListener(this.bfN);
        MessageManager.getInstance().registerListener(this.syncListener);
    }

    public void g(u uVar) {
        this.aDU = uVar;
        if (this.aDU != null && this.aDU.mLiveInfo != null) {
            this.bfq = this.aDU.mLiveInfo.audience_count - this.aDU.mLiveInfo.ai_robot_num;
        }
    }

    private HttpMessageTask Kg() {
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
    public void Kh() {
        this.mHandler.postDelayed(this.bfB, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ki() {
        sendMessage(new com.baidu.live.im.message.b(JavaTypesHelper.toInt(this.mGroupId, 0), getLastMid()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kj() {
        this.mHandler.removeCallbacks(this.bfB);
    }

    public void e(long j, String str) {
        if (j == 0) {
            j = 1;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.mPageContext.getString(a.i.sdk_gift);
        }
        com.baidu.live.im.data.a a2 = a((short) 27, String.format(this.mPageContext.getString(a.i.sdk_send_gift_fail), Long.valueOf(j), str), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), this.aIm);
        if (a2 != null) {
            a(-1, a2);
            if (this.bfe != null) {
                this.bfe.r(a2);
                this.bfe.d(this.mMsgList, true);
            }
        }
    }

    public com.baidu.live.im.data.a b(String str, String str2, String str3, long j, boolean z) {
        return a((short) 24, c(str, TextUtils.isEmpty(str2) ? "1" : str2, TextUtils.isEmpty(str3) ? this.mPageContext.getString(a.i.sdk_gift) : str3, j, z).toString(), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), this.aIm);
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
        if (this.bfe != null) {
            this.bfe.r(aVar);
            if (z) {
                this.bfe.d(this.mMsgList, true);
            }
        }
    }

    protected void a(ResponsedMessage<?> responsedMessage, boolean z) {
        boolean z2;
        long j;
        List<com.baidu.live.im.data.a> list;
        if (responsedMessage instanceof ALAGroupHttpResponseMessage) {
            List<com.baidu.live.im.data.a> LO = ((ALAGroupHttpResponseMessage) responsedMessage).LO();
            j = ((ALAGroupHttpResponseMessage) responsedMessage).getGroupId();
            list = LO;
            z2 = ((ALAGroupHttpResponseMessage) responsedMessage).LN();
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
            if (this.bfj != 0) {
                int i2 = this.bfk * this.bfi;
                ArrayList arrayList = new ArrayList(this.bfh);
                d(0, arrayList.subList(i2, arrayList.size()));
                Kn();
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
        if (this.bfu != null) {
            this.bfu.clear();
        }
        if (this.bfv != null) {
            this.bfv.clear();
        }
        this.mMsgList = new LinkedList<>();
        this.mGroupId = str;
        this.bff = str2;
        this.bfg = str3;
        this.mLiveId = str4;
        this.bfm = "0";
        this.mAppId = str5;
        MessageManager.getInstance().registerListener(this.bfG);
        MessageManager.getInstance().registerListener(this.bfH);
        MessageManager.getInstance().registerListener(this.bfz);
        MessageManager.getInstance().registerListener(this.bfC);
        MessageManager.getInstance().registerListener(this.bfA);
        MessageManager.getInstance().registerListener(this.bfD);
        MessageManager.getInstance().registerListener(this.bfE);
        MessageManager.getInstance().registerListener(this.bfF);
        MessageManager.getInstance().registerListener(this.bfJ);
        MessageManager.getInstance().registerListener(this.bfK);
        MessageManager.getInstance().registerListener(this.bfL);
        MessageManager.getInstance().registerListener(this.bfM);
        MessageManager.getInstance().registerListener(this.bfI);
        MessageManager.getInstance().registerListener(this.bal);
        if (BdSocketLinkService.isClose()) {
            Ki();
            BdSocketLinkService.startService(true, "live start");
        }
        String str6 = com.baidu.live.x.a.OS().blo.aJn;
        if (!TextUtils.isEmpty(str6)) {
            com.baidu.live.im.data.a Ko = Ko();
            Ko.setMsgType(27);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("text", str6);
                jSONObject.put("content_type", "custom_live_notice");
                Ko.setContent(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            a(-1, Ko);
            if (this.bfe != null) {
                this.bfe.r(Ko);
            }
        }
        String str7 = com.baidu.live.x.a.OS().blo.aJo;
        if (!TextUtils.isEmpty(str7)) {
            com.baidu.live.im.data.a Ko2 = Ko();
            Ko2.setMsgType(27);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("text", str7);
                jSONObject2.put("content_type", "custom_live_notice");
                Ko2.setContent(jSONObject2.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            a(-1, Ko2);
        }
        List<String> list = com.baidu.live.x.a.OS().blo.aJm;
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
                    com.baidu.live.im.data.a Ko3 = Ko();
                    Ko3.setMsgType(27);
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("text", str8);
                        jSONObject3.put("content_type", "custom_im_notice");
                        Ko3.setContent(jSONObject3.toString());
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                    Ko3.setLink(str9);
                    a(-1, Ko3);
                    if (this.bfe != null) {
                        this.bfe.r(Ko3);
                    }
                }
                i = i2 + 2;
            }
        }
        if (this.aDU != null && this.aDU.aIt != null && !StringUtils.isNull(this.aDU.aIt.Dz())) {
            com.baidu.live.im.data.a Ko4 = Ko();
            Ko4.setMsgType(27);
            try {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("text", this.aDU.aIt.Dz());
                jSONObject4.put("content_type", "custom_live_notice");
                Ko4.setContent(jSONObject4.toString());
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            this.mMsgList.add(Ko4);
            if (this.bfe != null) {
                this.bfe.r(Ko4);
            }
        }
        Kl();
        Kk();
        if (this.mMsgList.size() > 0 && this.bfe != null) {
            this.bfe.d(this.mMsgList, true);
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGmsgGetLiveStatusUnabled()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.d.6
                @Override // java.lang.Runnable
                public void run() {
                    d.this.hq("enter");
                }
            }, 1000L);
        }
        Kh();
        if (TbadkCoreApplication.getInst().isOther()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913146, this.mMsgList));
        }
    }

    private void Kk() {
        String str = com.baidu.live.x.a.OS().blo.aJp;
        if (str != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    com.baidu.live.im.data.a Ko = Ko();
                    Ko.setMsgType(27);
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    JSONObject jSONObject2 = new JSONObject();
                    if (jSONObject.optInt("open") != 0) {
                        jSONObject2.put("text", jSONObject.toString());
                        jSONObject2.put("content_type", "activity_notice");
                        Ko.setContent(jSONObject2.toString());
                        this.mMsgList.add(Ko);
                        if (this.bfe != null) {
                            this.bfe.r(Ko);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void Kl() {
        if (Km()) {
            com.baidu.live.im.data.a Ko = Ko();
            Ko.setMsgType(27);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("text", com.baidu.live.x.a.OS().blo.aLH.aHP);
                jSONObject.put("content_type", "custom_im_notice_live_assistant");
                Ko.setContent(jSONObject.toString());
                Ko.setLink(com.baidu.live.x.a.OS().blo.aLH.aHO);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mMsgList.add(Ko);
            if (this.bfe != null) {
                this.bfe.r(Ko);
            }
        }
    }

    private boolean Km() {
        return (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) || !TbadkCoreApplication.getCurrentAccount().equals(this.bfg) || com.baidu.live.x.a.OS().blo == null || com.baidu.live.x.a.OS().blo.aLH == null || TextUtils.isEmpty(com.baidu.live.x.a.OS().blo.aLH.aHP)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(List<com.baidu.live.im.data.a> list) {
        if (list != null && this.bfe != null) {
            this.bfe.d(this.mMsgList, true);
            for (com.baidu.live.im.data.a aVar : list) {
                this.bfe.r(aVar);
            }
        }
    }

    protected void N(List<com.baidu.live.im.data.a> list) {
        this.bfh = list;
        this.bfj = (int) ((this.bfl * 2.0f) / 0.25f);
        this.bfk = 0;
        this.bfi = list.size() / this.bfj;
        if (this.bfi <= 0) {
            this.bfi = 1;
        }
        this.mHandler.removeCallbacks(this.bfx);
        this.mHandler.postDelayed(this.bfx, 250L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kn() {
        this.mHandler.removeCallbacks(this.bfx);
        this.bfk = 0;
        this.bfj = 0;
        this.bfi = 0;
        this.bfh = null;
    }

    protected List<com.baidu.live.im.data.a> b(List<com.baidu.live.im.data.a> list, boolean z) {
        return a(list, z, false);
    }

    protected List<com.baidu.live.im.data.a> a(List<com.baidu.live.im.data.a> list, boolean z, boolean z2) {
        for (com.baidu.live.im.data.a aVar : list) {
            if (aVar instanceof com.baidu.live.im.a) {
                ((com.baidu.live.im.a) aVar).hp(this.bfg);
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
                O(list);
            }
            if (z2 && this.mMsgList.size() > 2) {
                b(list, 2);
            } else {
                b(list, -1);
            }
        }
        if (this.mMsgList.size() > com.baidu.live.x.a.OS().blo.aLv) {
            int i = (int) (com.baidu.live.x.a.OS().blo.aLv * 0.7d);
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
        com.baidu.live.data.a Lt = aVar.Lt();
        if (Lt != null && (list = Lt.aGI) != null && !list.isEmpty()) {
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
            d = com.baidu.live.x.d.OZ().g(z, jSONObject.optString(LogConfig.LOG_GIFT_ID));
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
                        if (!TextUtils.isEmpty(optString) && (optString.equals("challenge_direct_start") || optString.equals("challenge_direct_matched") || optString.equals("challenge_random_start") || optString.equals("challenge_random_matched") || optString.equals("live_net_status") || optString.equals("send_redpacket") || optString.equals("start_grab_redpacket") || optString.equals("guard_seat") || optString.equals("multi_session") || optString.equals("fullscreen") || optString.equals("challenge_mvp") || optString.equals("challenge_mvp_punish") || optString.equals("challenge_winner_by_autofail") || optString.equals("official_notice") || optString.equals("activity_common_im") || optString.equals("activity_notice") || optString.equals("activity_gift") || optString.equals("pk_first_blood") || optString.equals("pk_send_props") || optString.equals("pk_mvp_props") || optString.equals("privilege_award_royal_success"))) {
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
                aVar.bW(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.live.im.data.a aVar) {
        if (this.bfq < this.beZ) {
            if (i >= 0) {
                this.mMsgList.add(i, aVar);
            } else {
                this.mMsgList.addLast(aVar);
            }
        } else if (this.bfq >= this.beZ && this.bfq < this.bfa) {
            if (p(aVar)) {
                aVar.LF();
            }
            if (i >= 0) {
                this.mMsgList.add(i, aVar);
            } else if (!this.mMsgList.isEmpty() && p(this.mMsgList.getLast())) {
                this.mMsgList.set(this.mMsgList.size() - 1, aVar);
            } else {
                this.mMsgList.addLast(aVar);
            }
        } else if (this.bfq >= this.bfa && this.bfq < this.bfc) {
            if (n(aVar)) {
                aVar.LF();
            }
            if (i >= 0) {
                this.mMsgList.add(i, aVar);
            } else if (!this.mMsgList.isEmpty() && n(this.mMsgList.getLast())) {
                this.mMsgList.set(this.mMsgList.size() - 1, aVar);
            } else {
                this.mMsgList.addLast(aVar);
            }
        } else if (this.bfq >= this.bfc) {
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
        this.bfr = 0;
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
                if (com.baidu.live.entereffect.a.Et().h(aVar)) {
                    this.bfr = 2;
                } else {
                    this.bfr = 1;
                }
            } else {
                this.bfr = 0;
            }
        }
        return this.bfr;
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
                    if (aVar != null && aVar.Lt() != null && !TextUtils.isEmpty(aVar.Lt().userId) && aVar.Lt().userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        int i2 = size - 1;
                        while (true) {
                            if (i2 >= 0 && i2 >= 0) {
                                com.baidu.live.im.data.a aVar2 = list.get(i2);
                                if (aVar2 != null && aVar2.Lt() != null && !TextUtils.isEmpty(aVar2.Lt().userId) && aVar2.Lt().userId.equals(TbadkCoreApplication.getCurrentAccount()) && aVar.getRecordId() == aVar2.getRecordId()) {
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

    /* JADX WARN: Removed duplicated region for block: B:24:0x0073 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0166 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:346:0x010d A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:354:0x015e A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:357:0x013d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:489:0x0196 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:575:0x0009 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0111 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x015c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(List<com.baidu.live.im.data.a> list, boolean z) {
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
        LinkedList linkedList = new LinkedList();
        for (com.baidu.live.im.data.a aVar : list) {
            long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
            if (!ListUtils.isEmpty(aVar.Lv()) && !aVar.Lv().contains(Long.valueOf(currentAccountId))) {
                linkedList.add(aVar);
            } else {
                boolean z2 = aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
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
                        } catch (JSONException e3) {
                            jSONObject4 = jSONObject6;
                            jSONException = e3;
                            jSONException.printStackTrace();
                            jSONObject5 = jSONObject4;
                            str2 = null;
                            if ("pk_send_props".equals(str2)) {
                                if (z2) {
                                }
                            }
                            if (z2) {
                                this.aIm = aVar.Lt().aGI;
                            }
                            if (z2) {
                            }
                            if (this.bft) {
                            }
                            if (aVar.getMsgType() == 125) {
                            }
                        } catch (Exception e4) {
                            jSONObject3 = jSONObject6;
                            exc = e4;
                            exc.printStackTrace();
                            jSONObject5 = jSONObject3;
                            str2 = null;
                            if ("pk_send_props".equals(str2)) {
                            }
                            if (z2) {
                            }
                            if (z2) {
                            }
                            if (this.bft) {
                            }
                            if (aVar.getMsgType() == 125) {
                            }
                        }
                    } catch (JSONException e5) {
                        jSONObject4 = null;
                        jSONException = e5;
                    } catch (Exception e6) {
                        jSONObject3 = null;
                        exc = e6;
                    }
                    if ("pk_send_props".equals(str2) && jSONObject5 != null && str2 != null && jSONObject5.optString("is_mine").equals("1")) {
                        if (z2) {
                            aVar.setMsgType(24);
                        } else {
                            aVar.setMsgType(13);
                        }
                    }
                }
                if (z2 && aVar.getMsgType() == 1 && !ListUtils.isEmpty(aVar.Lt().aGI) && this.aIm == null) {
                    this.aIm = aVar.Lt().aGI;
                }
                if (z2 && aVar.getMsgType() != 125 && aVar.getMsgType() != 24 && aVar.getMsgType() != 13 && aVar.getMsgType() != 28) {
                    if (aVar.getMsgType() != 1 || !z) {
                        linkedList.add(aVar);
                    }
                } else if (this.bft && z2 && aVar.getMsgType() == 24) {
                    try {
                        if (aVar.getObjContent() instanceof JSONObject) {
                            jSONObject2 = (JSONObject) aVar.getObjContent();
                        } else {
                            jSONObject2 = new JSONObject(aVar.getContent());
                        }
                        try {
                            jSONObject2.optString("content_type");
                        } catch (JSONException e7) {
                            e2 = e7;
                            e2.printStackTrace();
                            if (!(jSONObject2.optInt("from_gongyanfang_page") == 1)) {
                            }
                        } catch (Exception e8) {
                            e = e8;
                            e.printStackTrace();
                            if (!(jSONObject2.optInt("from_gongyanfang_page") == 1)) {
                            }
                        }
                    } catch (JSONException e9) {
                        jSONObject2 = null;
                        e2 = e9;
                    } catch (Exception e10) {
                        jSONObject2 = null;
                        e = e10;
                    }
                    if (!(jSONObject2.optInt("from_gongyanfang_page") == 1)) {
                        linkedList.add(aVar);
                    }
                } else if (aVar.getMsgType() == 125) {
                    try {
                        if (!"1".equals(new JSONObject(aVar.getContent()).optString("is_first"))) {
                            linkedList.add(aVar);
                            if (this.bfe != null) {
                                this.bfe.r(aVar);
                            }
                        }
                    } catch (JSONException e11) {
                        BdLog.e(e11);
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
                    } catch (JSONException e12) {
                        linkedList.add(aVar);
                        str = null;
                    }
                    if ("enter_live".equals(str) && this.bfq < this.bfc) {
                        if (com.baidu.live.entereffect.a.Et().h(aVar)) {
                        }
                    } else if ("close_live".equals(str)) {
                        linkedList.add(aVar);
                        if (this.bfe != null) {
                            this.bfe.r(aVar);
                        }
                    } else if ("task".equals(str)) {
                        linkedList.add(aVar);
                        if (this.bfe != null) {
                            this.bfe.r(aVar);
                        }
                    } else if ("live_achievement".equals(str)) {
                        linkedList.add(aVar);
                        if (this.bfe != null) {
                            this.bfe.r(aVar);
                        }
                    } else if ("ss_hot_live".equals(str)) {
                        linkedList.add(aVar);
                        if (this.bfe != null) {
                            this.bfe.r(aVar);
                        }
                    } else if ("challenge_direct_new".equals(str)) {
                        linkedList.add(aVar);
                        if (this.bfe != null) {
                            this.bfe.r(aVar);
                        }
                    } else if ("challenge_random_cancel".equals(str)) {
                        linkedList.add(aVar);
                        if (this.bfe != null) {
                            this.bfe.r(aVar);
                        }
                    } else if ("update_liveinfo".equals(str)) {
                        linkedList.add(aVar);
                        if (this.bfe != null) {
                            this.bfe.r(aVar);
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
                        if (z2 && !ListUtils.isEmpty(aVar.Lt().aGI)) {
                            this.aIm = aVar.Lt().aGI;
                            if (this.aDU != null) {
                                this.aDU.aIm = this.aIm;
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
                        } else if (TextUtils.equals(str, "guard_seat")) {
                            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                                linkedList.add(aVar);
                            }
                        } else if (TextUtils.equals(str, "multi_session")) {
                            linkedList.add(aVar);
                            if (this.bfe != null) {
                                this.bfe.r(aVar);
                            }
                        } else if (TextUtils.equals(str, "fullscreen")) {
                            linkedList.add(aVar);
                            if (this.bfe != null) {
                                this.bfe.r(aVar);
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
                                if (this.bfe != null) {
                                    this.bfe.r(aVar);
                                }
                            } else if ("first_recharge_success".equals(str)) {
                                linkedList.add(aVar);
                                if (this.bfe != null) {
                                    this.bfe.r(aVar);
                                }
                            } else if ("privilege_award_success".equals(str)) {
                                linkedList.add(aVar);
                                if (this.bfe != null) {
                                    this.bfe.r(aVar);
                                }
                            } else if ("need_update_live_mark_info".equals(str)) {
                                linkedList.add(aVar);
                                if (this.bfe != null) {
                                    this.bfe.r(aVar);
                                }
                            } else if ("pk_honor_change".equals(str) || "pk_invite".equals(str) || "pk_start".equals(str) || "pk_start_settle".equals(str) || "pk_end_settle".equals(str)) {
                                linkedList.add(aVar);
                                if (this.bfe != null) {
                                    this.bfe.r(aVar);
                                }
                            } else if ("official_notice".equals(str)) {
                                linkedList.add(aVar);
                                if (this.bfe != null && !z) {
                                    this.bfe.r(aVar);
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
                    if (this.bfe != null) {
                        this.bfe.r(aVar);
                    }
                    hq("push");
                }
            }
        }
        if (linkedList.size() > 0) {
            list.removeAll(linkedList);
        }
    }

    protected com.baidu.live.im.data.a a(short s, String str, boolean z, boolean z2, int i, List<AlaLiveMarkData> list) {
        long j = 0;
        com.baidu.live.im.data.a Ko = Ko();
        if (Ko == null) {
            return null;
        }
        Ko.setMsgType(s);
        Ko.setContent(str);
        long ai = o.ai(getLastMid());
        Ko.setMsgId(ai);
        Ko.setRecordId(ai);
        Ko.setTime(System.currentTimeMillis() / 1000);
        com.baidu.live.data.a aVar = new com.baidu.live.data.a();
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            aVar.userName = TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow();
        }
        aVar.userId = TbadkCoreApplication.getCurrentAccount();
        if (this.aDU != null && this.aDU.aIf != null && !TextUtils.isEmpty(this.aDU.aIf.portrait)) {
            aVar.portrait = this.aDU.aIf.portrait;
        } else {
            aVar.portrait = TbadkCoreApplication.getCurrentPortrait();
        }
        aVar.level_id = i;
        aVar.aGF = z;
        aVar.aGG = z2;
        if (list != null) {
            aVar.aGI = new ArrayList(list);
        }
        Ko.e(aVar);
        try {
            j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        } catch (Exception e) {
        }
        Ko.setUserId(j);
        return Ko;
    }

    private long getLastMid() {
        if (this.mMsgList == null || this.mMsgList.size() <= 0) {
            return JavaTypesHelper.toLong(this.bff, 1L);
        }
        return this.mMsgList.get(this.mMsgList.size() - 1).getMsgId();
    }

    protected com.baidu.live.im.data.a Ko() {
        com.baidu.live.im.a aVar = new com.baidu.live.im.a();
        aVar.setBornTime(System.currentTimeMillis());
        if (TextUtils.isEmpty(this.mGroupId)) {
            return null;
        }
        aVar.hp(this.bfg);
        return aVar;
    }

    public void Q(List<AlaLiveMarkData> list) {
        this.aIm = list;
    }

    public void hq(String str) {
        com.baidu.live.message.c cVar = new com.baidu.live.message.c(JavaTypesHelper.toLong(this.mLiveId, 0L), str);
        cVar.setParams();
        sendMessage(cVar);
    }

    public void hr(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.bfm)) {
            hq("getliveinfo");
        }
    }

    private List<com.baidu.live.im.data.a> q(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        int optInt;
        boolean Fk;
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
            com.baidu.live.gift.g gM = w.gM(jSONObject.optString(LogConfig.LOG_GIFT_ID));
            Fk = gM != null ? gM.Fk() : false;
        } catch (JSONException e) {
            arrayList.add(aVar2);
        }
        if (optInt == 1 || Fk) {
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
            aVar3.hp(aVar2.Ke());
            aVar3.setBornTime(aVar2.getBornTime());
            aVar3.setTime(aVar2.getTime());
            aVar3.setUserId(aVar2.getUserId());
            aVar3.setToUserId(aVar2.getToUserId());
            aVar3.f(aVar2.Lu());
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
            aVar3.e(aVar2.Lt());
            aVar3.setSt_type(aVar2.getSt_type());
            arrayList.add(aVar3);
        }
        return arrayList;
    }

    public void a(int i, String str, com.baidu.live.data.a aVar) {
        com.baidu.live.im.data.a Ko = Ko();
        if (Ko != null) {
            Ko.setMsgType(i);
            Ko.setContent(str);
            Ko.e(aVar);
            a(-1, Ko);
            if (this.bfe != null) {
                this.bfe.d(this.mMsgList, true);
                this.bfe.r(Ko);
            }
        }
    }

    private void b(List<com.baidu.live.im.data.a> list, int i) {
        JSONObject jSONObject;
        int i2;
        if (this.bft) {
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
                            com.baidu.live.data.a Lt = aVar.Lt();
                            if (Lt == null || StringUtils.isNull(Lt.userId) || StringUtils.isNull(optString)) {
                                if (i >= 0) {
                                    a(i + i4, aVar);
                                } else {
                                    a(-1, aVar);
                                }
                            } else {
                                String str = Lt.userId + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + optString + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + Lt.getNameShow();
                                if (this.bfu == null) {
                                    this.bfu = new LinkedHashMap<>();
                                }
                                long j = JavaTypesHelper.toLong(jSONObject.optString("gift_count"), 0L);
                                double optDouble = jSONObject.optDouble("gift_rate", 0.0d);
                                long j2 = JavaTypesHelper.toLong(jSONObject.optString("charm_value"), 0L);
                                h hVar = new h();
                                hVar.bhh = aVar;
                                hVar.count = j;
                                hVar.bhk = optDouble;
                                hVar.bhj = j2;
                                if (com.baidu.live.x.a.OS().blo == null) {
                                    i2 = 100;
                                } else {
                                    i2 = com.baidu.live.x.a.OS().blo.aLB * 2;
                                }
                                Iterator<String> it = this.bfu.keySet().iterator();
                                int i5 = 0;
                                while (it.hasNext()) {
                                    String next = it.next();
                                    if (this.bfu.get(next) == null || this.bfu.get(next).isEmpty()) {
                                        it.remove();
                                    } else {
                                        HashMap<Long, h> hashMap = this.bfu.get(next);
                                        Iterator<Long> it2 = hashMap.keySet().iterator();
                                        while (it2.hasNext()) {
                                            long longValue = it2.next().longValue();
                                            if (hashMap.get(Long.valueOf(longValue)) == null || hashMap.get(Long.valueOf(longValue)).bhn) {
                                                it2.remove();
                                            }
                                        }
                                        if (this.bfu.get(next) == null || this.bfu.get(next).isEmpty()) {
                                            it.remove();
                                        } else {
                                            i5 = hashMap.size() + i5;
                                        }
                                    }
                                }
                                if (i5 > i2) {
                                    int i6 = i5 - ((int) (i2 * 0.7d));
                                    Iterator<String> it3 = this.bfu.keySet().iterator();
                                    while (true) {
                                        int i7 = i6;
                                        if (!it3.hasNext()) {
                                            break;
                                        }
                                        i6 = i7 - this.bfu.get(it3.next()).size();
                                        it3.remove();
                                        if (i6 <= 0) {
                                            break;
                                        }
                                    }
                                }
                                if (!this.bfu.containsKey(str)) {
                                    HashMap<Long, h> hashMap2 = new HashMap<>();
                                    hashMap2.put(Long.valueOf(aVar.getMsgId()), hVar);
                                    this.bfu.put(str, hashMap2);
                                } else {
                                    this.bfu.get(str).put(Long.valueOf(aVar.getMsgId()), hVar);
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
            HashMap<Long, h> hashMap = this.bfv.get(str3);
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
                            if (next.bho.contains(l)) {
                                hVar = next;
                                break;
                            }
                        }
                    }
                    if (hVar != null) {
                        long longValue = map.get(l).longValue();
                        if (z) {
                            hVar.bhi += longValue;
                        }
                        hVar.bhm -= longValue;
                        if (hVar.bhn && hVar.bhm == 0) {
                            hashMap.remove(Long.valueOf(hVar.aTm));
                            hVar.bhh.aj(hVar.count);
                            hVar.bhh.o(hVar.bhk);
                            hVar.bhh.ak(hVar.bhj);
                            a(-1, hVar.bhh);
                            if (this.bfe != null) {
                                this.bfe.d(this.mMsgList, true);
                            }
                            long j3 = hVar.bhi;
                            if (j3 > 0) {
                                e(j3, hVar.giftName);
                            }
                        }
                    }
                }
                if (hashMap.isEmpty()) {
                    this.bfv.remove(str3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h hVar) {
        JSONObject jSONObject;
        com.baidu.live.im.data.a aVar = hVar.bhh;
        if (aVar != null) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pk_honer_buff_multiple", Double.parseDouble(hVar.bhp == null ? this.bfn : hVar.bhp));
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

    public void bR(boolean z) {
        this.mGroupId = null;
        this.bff = null;
        this.mLiveId = null;
        this.bfm = "0";
        this.mAppId = null;
        this.bfo = false;
        this.bfp = false;
        MessageManager.getInstance().unRegisterListener(this.bfH);
        MessageManager.getInstance().unRegisterListener(this.bfG);
        MessageManager.getInstance().unRegisterListener(this.bfz);
        MessageManager.getInstance().unRegisterListener(this.bfC);
        MessageManager.getInstance().unRegisterListener(this.bfD);
        MessageManager.getInstance().unRegisterListener(this.bfE);
        MessageManager.getInstance().unRegisterListener(this.bfF);
        MessageManager.getInstance().unRegisterListener(this.bfA);
        MessageManager.getInstance().unRegisterListener(this.bfJ);
        MessageManager.getInstance().unRegisterListener(this.bfK);
        MessageManager.getInstance().unRegisterListener(this.bfL);
        MessageManager.getInstance().unRegisterListener(this.bfM);
        MessageManager.getInstance().unRegisterListener(this.bfI);
        MessageManager.getInstance().unRegisterListener(this.bal);
        if (z) {
            MessageManager.getInstance().unRegisterListener(this.syncListener);
        }
        this.mHandler.removeCallbacks(this.bfy);
        this.mHandler.removeCallbacks(this.bfx);
        this.mHandler.removeCallbacks(this.bfB);
        if (this.mMsgList != null) {
            this.mMsgList.clear();
        }
        this.mMsgList = null;
        if (this.bfu != null) {
            this.bfu.clear();
        }
        if (this.bfv != null) {
            this.bfv.clear();
        }
    }

    private void Kp() {
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
            com.baidu.live.im.data.a a2 = a(s, str2, z, z2, i, this.aIm);
            if (s == 126) {
                a2.eJ(imSendMsgData.barrageType);
                a2.hw(imSendMsgData.barrageId);
                a2.a(imSendMsgData.barrageCardInfo);
            }
            if (a2 != null) {
                a2.k(strArr);
                a(-1, a2);
                if (this.bfe != null) {
                    this.bfe.r(a2);
                    this.bfe.d(this.mMsgList, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913043));
                com.baidu.live.im.message.a aVar = new com.baidu.live.im.message.a(str2, s, JavaTypesHelper.toInt(this.mGroupId, 0), this.mAppId);
                if (this.aDU != null && this.aDU.mLiveInfo != null) {
                    aVar.gx(this.aDU.mLiveInfo.live_id + "");
                    aVar.hx(this.aDU.mLiveInfo.room_id + "");
                } else {
                    aVar.gx("");
                    aVar.hx("");
                }
                aVar.setOtherParams(str);
                aVar.al(imSendMsgData.price);
                aVar.eJ(imSendMsgData.barrageType);
                aVar.hw(imSendMsgData.barrageId);
                aVar.a(imSendMsgData.barrageCardInfo);
                aVar.k(strArr);
                aVar.bX(imSendMsgData.isQuick);
                sendMessage(aVar);
            }
        }
    }

    public void g(long j, long j2) {
        if (!this.bfo) {
            this.bfo = true;
            com.baidu.live.im.message.c cVar = new com.baidu.live.im.message.c(1021194);
            cVar.addParam("user_id", j);
            cVar.addParam("live_id", j2);
            cVar.am(System.currentTimeMillis());
            sendMessage(cVar);
            this.mHandler.postDelayed(this.bfy, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kq() {
        this.bfo = false;
        this.bfp = true;
        ImForbiddenStateData imForbiddenStateData = new ImForbiddenStateData();
        imForbiddenStateData.errno = -1;
        imForbiddenStateData.errMsg = this.mPageContext.getString(a.i.sdk_neterror);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, imForbiddenStateData));
    }
}
