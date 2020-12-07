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
import com.baidu.live.data.w;
import com.baidu.live.gift.YuyinGiftPackageConsumeHttpResponsedMessage;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.an;
import com.baidu.live.gift.ao;
import com.baidu.live.gift.ap;
import com.baidu.live.im.b;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.data.YuyinImForbiddenStateData;
import com.baidu.live.im.message.ALAGroupCommitHttpResponsedMessage;
import com.baidu.live.im.message.ALAGroupHttpResponseMessage;
import com.baidu.live.im.message.YuyinAlaForbiddenWordsStateResponseMessage;
import com.baidu.live.im.r;
import com.baidu.live.message.AlaGetAudioLiveStatusHttpResponseMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.utils.r;
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
public class q extends BdBaseModel {
    private w aFN;
    private List<AlaLiveMarkData> aKB;
    private boolean bkB;
    private boolean bkC;
    private int bkD;
    private int bkE;
    private boolean bkF;
    private LinkedHashMap<String, HashMap<Long, r>> bkG;
    private HashMap<String, HashMap<Long, r>> bkH;
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
    private String bks;
    private String bkt;
    private List<com.baidu.live.im.data.b> bku;
    private int bkv;
    private int bkw;
    private int bkx;
    private float bky;
    private String bkz;
    private a bmY;
    private CustomMessageListener bmZ;
    private long count;
    private String mAppId;
    private String mGroupId;
    private Handler mHandler;
    private String mLiveId;
    private LinkedList<com.baidu.live.im.data.b> mMsgList;
    BdPageContext<?> mPageContext;

    /* loaded from: classes4.dex */
    public interface a {
        void ME();

        void d(List<com.baidu.live.im.data.b> list, boolean z);

        void t(com.baidu.live.im.data.b bVar);
    }

    static /* synthetic */ int h(q qVar) {
        int i = qVar.bkx;
        qVar.bkx = i + 1;
        return i;
    }

    public q(BdPageContext<?> bdPageContext, boolean z, a aVar) {
        super(bdPageContext);
        this.mLiveId = null;
        this.bky = 1.0f;
        this.mHandler = new Handler();
        this.bkz = null;
        this.bkB = false;
        this.bkC = false;
        this.bkE = 0;
        this.bkF = false;
        this.bkI = new b.a() { // from class: com.baidu.live.im.q.1
        };
        this.bkJ = new Runnable() { // from class: com.baidu.live.im.q.12
            @Override // java.lang.Runnable
            public void run() {
                int i = q.this.bkx * q.this.bkv;
                if (i >= q.this.bku.size()) {
                    q.this.MA();
                } else if (q.this.bkx >= q.this.bkw - 1) {
                    if (q.this.bkx != q.this.bkw - 1) {
                        q.this.MA();
                        return;
                    }
                    ArrayList arrayList = new ArrayList(q.this.bku);
                    q.this.N(q.this.b(arrayList.subList(i, arrayList.size()), true));
                    q.h(q.this);
                    q.this.MA();
                } else {
                    ArrayList arrayList2 = new ArrayList(q.this.bku);
                    if (q.this.bkv + i <= arrayList2.size()) {
                        q.this.N(q.this.b(arrayList2.subList(i, q.this.bkv + i), true));
                        q.h(q.this);
                        q.this.mHandler.postDelayed(q.this.bkJ, 250L);
                        return;
                    }
                    q.this.N(q.this.b(arrayList2.subList(i, arrayList2.size()), true));
                    q.h(q.this);
                    q.this.MA();
                }
            }
        };
        this.bkK = new Runnable() { // from class: com.baidu.live.im.q.14
            @Override // java.lang.Runnable
            public void run() {
                q.this.MD();
            }
        };
        this.bkL = new CustomMessageListener(MessageConfig.SOCKET_RECEIVE_MSG) { // from class: com.baidu.live.im.q.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                q.this.Mw();
            }
        };
        this.bkM = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.live.im.q.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        com.baidu.live.im.a aVar2 = new com.baidu.live.im.a();
                        aVar2.setMsgType(27);
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("text", q.this.mPageContext.getString(a.h.sdk_im_offline));
                            jSONObject.put("content_type", "custom_network_change");
                            aVar2.setContent(jSONObject.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        q.this.a(-1, aVar2);
                        if (q.this.bmY != null) {
                            q.this.bmY.t(aVar2);
                            q.this.bmY.d(q.this.mMsgList, true);
                        }
                    } else if (((NetWorkChangedMessage) customResponsedMessage).mLastNetState == 0 && BdNetTypeUtil.isNetWorkAvailable()) {
                        com.baidu.live.im.a aVar3 = new com.baidu.live.im.a();
                        aVar3.setMsgType(27);
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("text", q.this.mPageContext.getString(a.h.sdk_im_online));
                            jSONObject2.put("content_type", "custom_network_change");
                            aVar3.setContent(jSONObject2.toString());
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        q.this.a(-1, aVar3);
                        if (q.this.bmY != null) {
                            q.this.bmY.t(aVar3);
                            q.this.bmY.d(q.this.mMsgList, true);
                        }
                    }
                }
            }
        };
        this.bkN = new Runnable() { // from class: com.baidu.live.im.q.17
            @Override // java.lang.Runnable
            public void run() {
                if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().getLastReceDataTime() > 35000) {
                    q.this.Mv();
                }
                q.this.Mu();
            }
        };
        this.bmZ = new CustomMessageListener(2501072) { // from class: com.baidu.live.im.q.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b)) {
                    com.baidu.live.im.data.b bVar = (com.baidu.live.im.data.b) customResponsedMessage.getData();
                    q.this.a(-1, bVar);
                    if (q.this.bmY != null) {
                        q.this.bmY.d(q.this.mMsgList, true);
                        q.this.bmY.t(bVar);
                    }
                }
            }
        };
        this.bkO = new HttpMessageListener(1021013) { // from class: com.baidu.live.im.q.19
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    boolean z2 = false;
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        int error = httpResponsedMessage.getError();
                        if (com.baidu.live.ae.a.RB().brA.aOy == 1) {
                            if (error == 149010) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913070, q.this.mPageContext.getPageActivity().getString(a.h.im_improper_content_tip)));
                                z2 = true;
                            } else if (error == 1202 || error == 1203) {
                                BdUtilHelper.showToast(q.this.mPageContext.getPageActivity(), q.this.mPageContext.getPageActivity().getString(a.h.im_improper_content_tip_net));
                                z2 = true;
                            } else if (error == 1204) {
                                BdUtilHelper.showToast(q.this.mPageContext.getPageActivity(), q.this.mPageContext.getPageActivity().getString(a.h.im_improper_content_tip));
                                z2 = true;
                            }
                        }
                    }
                    if (!z2 && q.this.bmY != null) {
                        q.this.bmY.ME();
                    }
                }
            }
        };
        this.bkP = new HttpMessageListener(1031055) { // from class: com.baidu.live.im.q.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof an) {
                        an anVar = (an) orginalMessage;
                        boolean z2 = false;
                        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            z2 = true;
                            if (!q.this.bkF) {
                                q.this.h(anVar.aWP, anVar.giftName);
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                        }
                        if (q.this.bkF) {
                            q.this.a(anVar.giftId, anVar.aWP, anVar.aWT, anVar.aYl, z2, anVar.aWV);
                        }
                    }
                }
            }
        };
        this.bkQ = new HttpMessageListener(1031056) { // from class: com.baidu.live.im.q.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof ao) {
                        ao aoVar = (ao) orginalMessage;
                        boolean z2 = false;
                        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            z2 = true;
                            if (!q.this.bkF) {
                                q.this.h(aoVar.aWP, aoVar.giftName);
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                        }
                        if (q.this.bkF) {
                            q.this.a(aoVar.giftId, aoVar.aWP, aoVar.aWT, aoVar.aYl, z2, aoVar.aWV);
                        }
                    }
                }
            }
        };
        this.bkR = new HttpMessageListener(1031057) { // from class: com.baidu.live.im.q.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                boolean z2;
                boolean z3;
                if (httpResponsedMessage != null) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof ap) {
                        ap apVar = (ap) orginalMessage;
                        if ((httpResponsedMessage instanceof YuyinGiftPackageConsumeHttpResponsedMessage) && TextUtils.isEmpty(((YuyinGiftPackageConsumeHttpResponsedMessage) httpResponsedMessage).aXU)) {
                            if (!q.this.bkF) {
                                q.this.h(apVar.aXC, apVar.giftName);
                            }
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            if (!q.this.bkF) {
                                q.this.h(apVar.aXC, apVar.giftName);
                            }
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (q.this.bkF) {
                            q.this.a(apVar.giftId, apVar.aXC, apVar.aWT, apVar.aYm, z3, apVar.aWV);
                        }
                    }
                }
            }
        };
        this.bkS = new HttpMessageListener(1021012) { // from class: com.baidu.live.im.q.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                q.this.a((ResponsedMessage<?>) httpResponsedMessage, false);
            }
        };
        this.bkT = new NetMessageListener(1031043, 601008) { // from class: com.baidu.live.im.q.5
            /* JADX WARN: Removed duplicated region for block: B:13:0x0022  */
            /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                JSONObject jSONObject;
                JSONObject jSONObject2 = null;
                AlaGetAudioLiveStatusHttpResponseMessage alaGetAudioLiveStatusHttpResponseMessage = responsedMessage instanceof AlaGetAudioLiveStatusHttpResponseMessage ? (AlaGetAudioLiveStatusHttpResponseMessage) responsedMessage : null;
                if (alaGetAudioLiveStatusHttpResponseMessage != null) {
                    if (responsedMessage != null) {
                        if (!TextUtils.isEmpty(((AlaGetAudioLiveStatusHttpResponseMessage) responsedMessage).brp)) {
                            jSONObject = new JSONObject(alaGetAudioLiveStatusHttpResponseMessage.brp);
                            jSONObject2 = jSONObject;
                            if (jSONObject2 == null) {
                                if (!"backstage_live".equals(jSONObject2.optString("content_type"))) {
                                    q.this.a(alaGetAudioLiveStatusHttpResponseMessage.brp, jSONObject2, 12, false);
                                    return;
                                }
                                String optString = jSONObject2.optString("backstage_type");
                                if (!TextUtils.isEmpty(optString) && !optString.equals(q.this.bkz)) {
                                    q.this.a(alaGetAudioLiveStatusHttpResponseMessage.brp, jSONObject2, 13, true);
                                    q.this.bkz = optString;
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    jSONObject = null;
                    jSONObject2 = jSONObject;
                    if (jSONObject2 == null) {
                    }
                }
            }
        };
        this.count = 1L;
        this.bkU = new CustomMessageListener(2913192) { // from class: com.baidu.live.im.q.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText banlstn sd=" + q.this.aFN);
                if (q.this.aFN != null) {
                    if (q.this.aFN.mLiveInfo.getUserID() == Long.valueOf(TbadkCoreApplication.getCurrentAccount()).longValue()) {
                        Log.i("i", "@@@ localText banlstn own");
                        if (q.this.aFN.aJV != null && q.this.aFN.mLiveInfo != null) {
                            Log.i("i", "@@@ localText banlstn own sdreq");
                            q.this.f(q.this.aFN.aJV.userUk, q.this.aFN.mLiveInfo.live_id);
                            return;
                        }
                        return;
                    }
                    Log.i("i", "@@@ localText banlstn oth");
                    if (q.this.aFN.aKr != null && q.this.aFN.mLiveInfo != null) {
                        Log.i("i", "@@@ localText banlstn oth sdreq");
                        q.this.f(q.this.aFN.aKr.userUk, q.this.aFN.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.bkV = new CustomMessageListener(2913185) { // from class: com.baidu.live.im.q.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                r rVar;
                if (q.this.bkF) {
                    if (q.this.bkH == null) {
                        q.this.bkH = new HashMap();
                    }
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r) && (rVar = (r) customResponsedMessage.getData()) != null && rVar.bnc != null && rVar.bnc.size() > 0) {
                        String D = com.baidu.live.utils.r.D(rVar.giftId, rVar.userId, rVar.bnb);
                        for (r.a aVar2 : rVar.bnc) {
                            com.baidu.live.im.data.b a2 = q.this.a(aVar2.giftId, aVar2.aWS, aVar2.count + "", aVar2.giftName, 0L, aVar2.bmx, aVar2.bnd);
                            if (a2 != null) {
                                double m = q.this.m(a2);
                                a2.setMsgId(0L);
                                a2.setRecordId(0L);
                                com.baidu.live.data.a NU = a2.NU();
                                if (NU != null && !StringUtils.isNull(NU.userId) && !StringUtils.isNull(aVar2.giftId)) {
                                    aVar2.bmt = a2;
                                    aVar2.bmw = m;
                                } else {
                                    return;
                                }
                            }
                        }
                        if (!q.this.bkH.containsKey(D)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put(Long.valueOf(rVar.aWT), rVar);
                            q.this.bkH.put(D, hashMap);
                            return;
                        }
                        ((HashMap) q.this.bkH.get(D)).put(Long.valueOf(rVar.aWT), rVar);
                    }
                }
            }
        };
        this.bkW = new CustomMessageListener(2913184) { // from class: com.baidu.live.im.q.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof s)) {
                    s sVar = (s) customResponsedMessage.getData();
                    if (sVar.bmD > 0) {
                        HashMap hashMap = (HashMap) q.this.bkG.get(sVar.bcO);
                        if (hashMap != null && !hashMap.isEmpty()) {
                            r rVar = (r) hashMap.remove(Long.valueOf(sVar.bmD));
                            if (rVar != null && rVar.bnc != null && rVar.bnc.size() > 0) {
                                rVar.bmz = true;
                                while (true) {
                                    int i2 = i;
                                    if (i2 >= rVar.bnc.size()) {
                                        break;
                                    }
                                    r.a aVar2 = rVar.bnc.get(i2);
                                    aVar2.bmt.aU(aVar2.count);
                                    aVar2.bmt.n(aVar2.bmw);
                                    aVar2.bmt.boT = aVar2.bnd;
                                    aVar2.bmt.aV(aVar2.bmv);
                                    q.this.a(-1, aVar2.bmt);
                                    if (q.this.bmY != null) {
                                        q.this.bmY.d(q.this.mMsgList, true);
                                    }
                                    i = i2 + 1;
                                }
                            }
                            if (hashMap.isEmpty()) {
                                q.this.bkG.remove(sVar.bcO);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    HashMap hashMap2 = (HashMap) q.this.bkH.get(sVar.bcO);
                    if (hashMap2 != null && !hashMap2.isEmpty()) {
                        r rVar2 = (r) hashMap2.get(Long.valueOf(sVar.bmF));
                        if (rVar2 != null && rVar2.bnc != null && rVar2.bnc.size() > 0) {
                            hashMap2.remove(Long.valueOf(sVar.bmF));
                            while (true) {
                                int i3 = i;
                                if (i3 >= rVar2.bnc.size()) {
                                    break;
                                }
                                r.a aVar3 = rVar2.bnc.get(i3);
                                aVar3.bmt.aU(aVar3.count);
                                aVar3.bmt.n(aVar3.bmw);
                                aVar3.bmt.aV(aVar3.bmv);
                                aVar3.bmt.boT = aVar3.bnd;
                                q.this.a(-1, aVar3.bmt);
                                if (q.this.bmY != null) {
                                    q.this.bmY.d(q.this.mMsgList, true);
                                }
                                long j = rVar2.bmu;
                                if (j > 0) {
                                    q.this.h(j, aVar3.giftName);
                                }
                                i = i3 + 1;
                            }
                        }
                        if (hashMap2.isEmpty()) {
                            q.this.bkH.remove(sVar.bcO);
                        }
                    }
                }
            }
        };
        this.bkX = new CustomMessageListener(2913183) { // from class: com.baidu.live.im.q.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof s)) {
                    s sVar = (s) customResponsedMessage.getData();
                    if (sVar.bmD == 0) {
                        HashMap hashMap = (HashMap) q.this.bkH.get(sVar.bcO);
                        if (hashMap != null && !hashMap.isEmpty()) {
                            r rVar = (r) hashMap.get(Long.valueOf(sVar.bmF));
                            r rVar2 = (r) hashMap.get(Long.valueOf(sVar.bmI));
                            if (rVar != null && rVar2 != null) {
                                hashMap.remove(Long.valueOf(sVar.bmI));
                                if (rVar.bnc != null && rVar2.bnc != null && rVar.bnc.size() == rVar2.bnc.size()) {
                                    rVar.bmu += rVar2.bmu;
                                    while (i < rVar.bnc.size()) {
                                        rVar.bnc.get(i).count += rVar2.bnc.get(i).count;
                                        rVar.bnc.get(i).bmv += rVar2.bnc.get(i).bmv;
                                        if (rVar.bnc.get(i).bmw != rVar2.bnc.get(i).bmw) {
                                            rVar.bnc.get(i).bmw = 0.0d;
                                        }
                                        i++;
                                    }
                                    rVar.bmA.add(Long.valueOf(rVar2.aWT));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    HashMap hashMap2 = (HashMap) q.this.bkG.get(sVar.bcO);
                    if (hashMap2 != null && !hashMap2.isEmpty()) {
                        r rVar3 = (r) hashMap2.get(Long.valueOf(sVar.bmD));
                        r rVar4 = (r) hashMap2.remove(Long.valueOf(sVar.bmG));
                        if (rVar3 != null && rVar4 != null && rVar3.bnc != null && rVar4.bnc != null && rVar3.bnc.size() == rVar4.bnc.size()) {
                            while (i < rVar3.bnc.size()) {
                                rVar3.bnc.get(i).count += rVar4.bnc.get(i).count;
                                rVar3.bnc.get(i).bmv += rVar4.bnc.get(i).bmv;
                                if (rVar3.bnc.get(i).bmw != rVar4.bnc.get(i).bmw) {
                                    rVar3.bnc.get(i).bmw = 0.0d;
                                }
                                i++;
                            }
                        }
                    }
                }
            }
        };
        this.bkY = new CustomMessageListener(2913195) { // from class: com.baidu.live.im.q.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                HashMap hashMap;
                r rVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof s)) {
                    s sVar = (s) customResponsedMessage.getData();
                    if (sVar.bmD != 0 && (hashMap = (HashMap) q.this.bkG.get(sVar.bcO)) != null && !hashMap.isEmpty() && (rVar = (r) hashMap.get(Long.valueOf(sVar.bmD))) != null && rVar.bnc != null) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < rVar.bnc.size()) {
                                r.a aVar2 = rVar.bnc.get(i2);
                                if (sVar.bne != null && sVar.bne.size() > i2) {
                                    aVar2.count = sVar.bne.get(i2).bmJ;
                                    aVar2.bmv = sVar.bne.get(i2).bmK;
                                }
                                i = i2 + 1;
                            } else {
                                return;
                            }
                        }
                    }
                }
            }
        };
        this.bkZ = new HttpMessageListener(1031054) { // from class: com.baidu.live.im.q.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                q.this.bkB = false;
                Log.i("i", "@@@ localText gtibslist 1");
                q.this.mHandler.removeCallbacks(q.this.bkK);
                if (httpResponsedMessage != null) {
                    if (httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.im.message.c) && ((com.baidu.live.im.message.c) httpResponsedMessage.getOrginalMessage()).aY(System.currentTimeMillis())) {
                        Log.i("i", "@@@ localText gtibslist out");
                        q.this.bkC = false;
                        return;
                    }
                    Log.i("i", "@@@ localText gtibslist ta=" + q.this.bkC);
                    if (q.this.bkC) {
                        q.this.bkC = false;
                    } else if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        Log.i("i", "@@@ localText gtibslist err he=" + httpResponsedMessage.hasError() + ", err=" + httpResponsedMessage.getError());
                        YuyinImForbiddenStateData yuyinImForbiddenStateData = new YuyinImForbiddenStateData();
                        yuyinImForbiddenStateData.errno = httpResponsedMessage.getError();
                        yuyinImForbiddenStateData.errMsg = httpResponsedMessage.getErrorString();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, yuyinImForbiddenStateData));
                    } else {
                        Log.i("i", "@@@ localText gtibslist suc");
                        if (httpResponsedMessage instanceof YuyinAlaForbiddenWordsStateResponseMessage) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, ((YuyinAlaForbiddenWordsStateResponseMessage) httpResponsedMessage).bpr));
                        }
                    }
                }
            }
        };
        this.bkn = com.baidu.live.ae.a.RB().brA.aOz;
        this.bko = com.baidu.live.ae.a.RB().brA.aOA;
        this.bkp = com.baidu.live.ae.a.RB().brA.aOB;
        this.mPageContext = bdPageContext;
        this.bkq = z;
        this.bmY = aVar;
        this.mMsgList = new LinkedList<>();
        this.bkG = new LinkedHashMap<>();
        this.bkH = new HashMap<>();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501043, Object.class);
        if (runTask != null && runTask.getData() != null) {
            this.bkF = true;
        }
        MessageManager.getInstance().registerTask(Mt());
        com.baidu.live.tieba.f.a.a.a(1031043, "ala/audio/live/getLiveStatus", AlaGetAudioLiveStatusHttpResponseMessage.class, false, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021012, "alaim/gmsg/getGroupMsg", ALAGroupHttpResponseMessage.class, false, true, true, true);
        MC();
        registerListener(this.bkZ);
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

    public void h(long j, String str) {
        if (j == 0) {
            j = 1;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.mPageContext.getString(a.h.sdk_gift);
        }
        com.baidu.live.im.data.b a2 = a((short) 27, String.format(this.mPageContext.getString(a.h.sdk_send_gift_fail_yuyin), Long.valueOf(j), str), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), "", this.aKB);
        if (a2 != null) {
            a(-1, a2);
            if (this.bmY != null) {
                this.bmY.t(a2);
                this.bmY.d(this.mMsgList, true);
            }
        }
    }

    public com.baidu.live.im.data.b a(String str, String str2, String str3, String str4, long j, boolean z, String str5) {
        return a((short) 24, a(str, str2, TextUtils.isEmpty(str3) ? "1" : str3, TextUtils.isEmpty(str4) ? this.mPageContext.getString(a.h.sdk_gift) : str4, j, z).toString(), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), str5, this.aKB);
    }

    private JSONObject a(String str, String str2, String str3, String str4, long j, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_GIFT_ID, str);
            jSONObject.put("gift_count", str3);
            jSONObject.put("gift_name", str4);
            jSONObject.put("gift_url", str2);
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
        if (this.bmY != null) {
            this.bmY.t(aVar);
            if (z) {
                this.bmY.d(this.mMsgList, true);
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
            T(list);
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
        MessageManager.getInstance().registerListener(this.bkR);
        MessageManager.getInstance().registerListener(this.bkQ);
        MessageManager.getInstance().registerListener(this.bkV);
        MessageManager.getInstance().registerListener(this.bkW);
        MessageManager.getInstance().registerListener(this.bkX);
        MessageManager.getInstance().registerListener(this.bkY);
        MessageManager.getInstance().registerListener(this.bkU);
        MessageManager.getInstance().registerListener(this.bmZ);
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
            if (this.bmY != null) {
                this.bmY.t(MB);
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
                    if (this.bmY != null) {
                        this.bmY.t(MB3);
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
                jSONObject4.put("content_type", "custom_live_notice");
                jSONObject4.put("category_msg_filter", "1");
                MB4.setContent(jSONObject4.toString());
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            this.mMsgList.add(MB4);
            if (this.bmY != null) {
                this.bmY.t(MB4);
            }
        }
        if (this.aFN != null && this.aFN.aKL != null && this.aFN.aKL.aUk != null && !StringUtils.isNull(this.aFN.aKL.aUk.content)) {
            com.baidu.live.im.data.b MB5 = MB();
            MB5.setMsgType(27);
            try {
                JSONObject jSONObject5 = new JSONObject();
                String str10 = this.aFN.aKL.aUk.content;
                String str11 = this.aFN.aKL.aUk.title;
                if (str10.length() > 100) {
                    str10 = str10.substring(0, 100) + "... 【详情可查看公告】";
                }
                jSONObject5.put("text", str11 + "：" + str10);
                jSONObject5.put("content_type", "play_rules");
                MB5.setContent(jSONObject5.toString());
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
            this.mMsgList.add(MB5);
            if (this.bmY != null) {
                this.bmY.t(MB5);
            }
        }
        My();
        if (this.mMsgList.size() > 0 && this.bmY != null) {
            this.bmY.d(this.mMsgList, true);
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGmsgGetLiveStatusUnabled()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.q.6
                @Override // java.lang.Runnable
                public void run() {
                    q.this.hZ("enter");
                }
            }, 1000L);
        }
        Mu();
        if (TbadkCoreApplication.getInst().isOther()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913146, this.mMsgList));
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
            if (this.bmY != null) {
                this.bmY.t(MB);
            }
        }
    }

    private boolean Mz() {
        return (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) || !TbadkCoreApplication.getCurrentAccount().equals(this.bkt) || com.baidu.live.ae.a.RB().brA == null || com.baidu.live.ae.a.RB().brA.aOv == null || TextUtils.isEmpty(com.baidu.live.ae.a.RB().brA.aOv.aKh)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(List<com.baidu.live.im.data.b> list) {
        if (list != null && this.bmY != null) {
            this.bmY.d(this.mMsgList, true);
            for (com.baidu.live.im.data.b bVar : list) {
                this.bmY.t(bVar);
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
                        if (!TextUtils.isEmpty(optString) && (optString.equals("challenge_direct_start") || optString.equals("challenge_direct_matched") || optString.equals("challenge_random_start") || optString.equals("challenge_random_matched") || optString.equals("live_net_status") || optString.equals("send_redpacket") || optString.equals("start_grab_redpacket") || optString.equals("guard_seat") || optString.equals("challenge_mvp") || optString.equals("challenge_mvp_punish") || optString.equals("challenge_winner_by_autofail") || optString.equals("official_notice") || optString.equals("privilege_award_royal_success"))) {
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
        if (this.bkD < this.bkn) {
            if (i >= 0) {
                this.mMsgList.add(i, bVar);
            } else {
                this.mMsgList.addLast(bVar);
            }
        } else if (this.bkD >= this.bkn && this.bkD < this.bko) {
            if (q(bVar)) {
                if (!this.mMsgList.isEmpty() && q(this.mMsgList.getLast())) {
                    this.mMsgList.set(this.mMsgList.size() - 1, bVar);
                } else {
                    this.mMsgList.addLast(bVar);
                }
            } else if (i >= 0) {
                this.mMsgList.add(i, bVar);
            } else {
                this.mMsgList.addLast(bVar);
            }
        } else if (this.bkD >= this.bko && this.bkD < this.bkp) {
            if (o(bVar)) {
                if (!this.mMsgList.isEmpty() && o(this.mMsgList.getLast())) {
                    this.mMsgList.set(this.mMsgList.size() - 1, bVar);
                } else {
                    this.mMsgList.addLast(bVar);
                }
            } else if (i >= 0) {
                this.mMsgList.add(i, bVar);
            } else {
                this.mMsgList.addLast(bVar);
            }
        } else if (this.bkD >= this.bkp) {
            if (!o(bVar)) {
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

    private void c(List<com.baidu.live.im.data.b> list, boolean z) {
        String str;
        JSONObject jSONObject;
        LinkedList linkedList = new LinkedList();
        for (com.baidu.live.im.data.b bVar : list) {
            long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
            if (!ListUtils.isEmpty(bVar.NW()) && !bVar.NW().contains(Long.valueOf(currentAccountId))) {
                linkedList.add(bVar);
            } else {
                boolean z2 = bVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                if (z2 && bVar.getMsgType() == 1 && !ListUtils.isEmpty(bVar.NU().aID) && this.aKB == null) {
                    this.aKB = bVar.NU().aID;
                }
                if (z2 && bVar.getMsgType() != 125 && bVar.getMsgType() != 24 && bVar.getMsgType() != 13 && bVar.getMsgType() != 28 && (bVar.getMsgType() != 1 || !z)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(bVar.getContent());
                        int optInt = jSONObject2.optInt("close_audio_room");
                        String optString = jSONObject2.optString("content_type");
                        if (optInt == 1 && "close_live".equals(optString)) {
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    linkedList.add(bVar);
                } else if (bVar.getMsgType() == 125) {
                    try {
                        if (!"1".equals(new JSONObject(bVar.getContent()).optString("is_first"))) {
                            linkedList.add(bVar);
                            if (this.bmY != null) {
                                this.bmY.t(bVar);
                            }
                        }
                    } catch (JSONException e2) {
                        BdLog.e(e2);
                        linkedList.add(bVar);
                    }
                } else if (bVar.getMsgType() == 13) {
                    try {
                        if (bVar.getObjContent() instanceof JSONObject) {
                            jSONObject = (JSONObject) bVar.getObjContent();
                        } else {
                            jSONObject = new JSONObject(bVar.getContent());
                        }
                        str = jSONObject.optString("content_type");
                    } catch (JSONException e3) {
                        linkedList.add(bVar);
                        str = null;
                    }
                    if ("enter_live".equals(str) && this.bkD < this.bkp) {
                        if (com.baidu.live.entereffect.a.Gi().h(bVar)) {
                        }
                    } else if ("close_live".equals(str)) {
                        linkedList.add(bVar);
                        if (this.bmY != null) {
                            this.bmY.t(bVar);
                        }
                    } else if ("task".equals(str)) {
                        linkedList.add(bVar);
                        if (this.bmY != null) {
                            this.bmY.t(bVar);
                        }
                    } else if ("live_achievement".equals(str)) {
                        linkedList.add(bVar);
                        if (this.bmY != null) {
                            this.bmY.t(bVar);
                        }
                    } else if ("ss_hot_live".equals(str)) {
                        linkedList.add(bVar);
                        if (this.bmY != null) {
                            this.bmY.t(bVar);
                        }
                    } else if ("challenge_direct_new".equals(str)) {
                        linkedList.add(bVar);
                        if (this.bmY != null) {
                            this.bmY.t(bVar);
                        }
                    } else if ("challenge_random_cancel".equals(str)) {
                        linkedList.add(bVar);
                        if (this.bmY != null) {
                            this.bmY.t(bVar);
                        }
                    } else if ("update_liveinfo".equals(str)) {
                        linkedList.add(bVar);
                        if (this.bmY != null) {
                            this.bmY.t(bVar);
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
                        if (z2 && !ListUtils.isEmpty(bVar.NU().aID)) {
                            this.aKB = bVar.NU().aID;
                            if (this.aFN != null) {
                                this.aFN.aKB = this.aKB;
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
                                linkedList.add(bVar);
                            }
                        } else if (TextUtils.equals(str, "challenge_mvp")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, "CONTENT_TYPE_CHALLENGE_MVP");
                        } else if (TextUtils.equals(str, "challenge_mvp_punish")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, "CONTENT_TYPE_CHALLENGE_MVP_PUNISH");
                        } else if (!TextUtils.equals(str, "challenge_winner_by_autofail")) {
                            if (TextUtils.equals(str, "wish_list_finish") || TextUtils.equals(str, "wish_list_success")) {
                                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                                    linkedList.add(bVar);
                                }
                            } else if ("ui_event".equals(str)) {
                                linkedList.add(bVar);
                                if (this.bmY != null) {
                                    this.bmY.t(bVar);
                                }
                            } else if ("introduce_goods".equals(str)) {
                                linkedList.add(bVar);
                                if (this.bmY != null) {
                                    this.bmY.t(bVar);
                                }
                            } else if ("first_recharge_success".equals(str)) {
                                linkedList.add(bVar);
                                if (this.bmY != null) {
                                    this.bmY.t(bVar);
                                }
                            } else if ("privilege_award_success".equals(str)) {
                                linkedList.add(bVar);
                                if (this.bmY != null) {
                                    this.bmY.t(bVar);
                                }
                            } else if ("need_update_live_mark_info".equals(str)) {
                                linkedList.add(bVar);
                                if (this.bmY != null) {
                                    this.bmY.t(bVar);
                                }
                            } else if ("official_notice".equals(str)) {
                                linkedList.add(bVar);
                            } else if (TextUtils.equals(str, "privilege_award_royal_success")) {
                                Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                            } else if (!TextUtils.equals(str, "add_tags_to_anchor")) {
                                if (TextUtils.equals(str, "audio_emoticon")) {
                                    if (z2 && !z) {
                                        linkedList.add(bVar);
                                    }
                                } else if (!TextUtils.equals(str, "follow_anchor_phone") && !TextUtils.equals(str, "follow_room")) {
                                    if (TextUtils.equals(str, "audio_link_toast")) {
                                        try {
                                            if (new JSONObject(bVar.getContent()).optJSONObject("data").optInt("force_xiangqin_update") == 1) {
                                                linkedList.add(bVar);
                                            }
                                        } catch (JSONException e4) {
                                            e4.printStackTrace();
                                        }
                                    } else if (!TextUtils.equals(str, "live_audio_audit_notice") && !TextUtils.equals(str, "sync_audio_speeker_status") && !TextUtils.equals(str, "audio_hat_level_toast") && !TextUtils.equals(str, "audio_hat_user_toast") && !TextUtils.equals(str, "audio_loot_gift") && !TextUtils.equals(str, "switch_activity_stage") && !TextUtils.equals(str, "audio_link_online")) {
                                        linkedList.add(bVar);
                                    }
                                }
                            }
                        }
                    }
                } else if (bVar.getMsgType() == 12) {
                    linkedList.add(bVar);
                    if (this.bmY != null) {
                        this.bmY.t(bVar);
                    }
                    hZ("push");
                }
            }
        }
        if (linkedList.size() > 0) {
            list.removeAll(linkedList);
        }
    }

    protected com.baidu.live.im.data.b a(short s, String str, boolean z, boolean z2, int i, String str2, List<AlaLiveMarkData> list) {
        long j = 0;
        com.baidu.live.im.data.b MB = MB();
        if (MB == null) {
            return null;
        }
        MB.setMsgType(s);
        MB.setContent(str);
        long aT = o.aT(getLastMid());
        MB.boT = str2;
        MB.setMsgId(aT);
        MB.setRecordId(aT);
        MB.setTime(System.currentTimeMillis() / 1000);
        com.baidu.live.data.a aVar = new com.baidu.live.data.a();
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            aVar.userName = TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow();
        }
        aVar.userId = TbadkCoreApplication.getCurrentAccount();
        aVar.portrait = TbadkCoreApplication.getCurrentPortrait();
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
        com.baidu.live.message.b bVar = new com.baidu.live.message.b(JavaTypesHelper.toLong(this.mLiveId, 0L), str);
        bVar.setParams();
        sendMessage(bVar);
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
            if (this.bmY != null) {
                this.bmY.d(this.mMsgList, true);
                this.bmY.t(MB);
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
                                String str = NU.userId;
                                NU.getNameShow();
                                String D = com.baidu.live.utils.r.D(optString, str, bVar.bnb);
                                if (this.bkG == null) {
                                    this.bkG = new LinkedHashMap<>();
                                }
                                long j = JavaTypesHelper.toLong(jSONObject.optString("gift_count"), 0L);
                                double optDouble = jSONObject.optDouble("gift_rate", 0.0d);
                                long j2 = JavaTypesHelper.toLong(jSONObject.optString("charm_value"), 0L);
                                jSONObject.optString("gift_url");
                                jSONObject.optString("gift_name");
                                r rVar = new r();
                                rVar.bnc = new ArrayList();
                                rVar.giftId = optString;
                                rVar.bnb = bVar.bnb;
                                for (r.a aVar : com.baidu.live.utils.r.jf(bVar.bnb)) {
                                    r.a aVar2 = new r.a();
                                    aVar2.bmt = bVar.clone();
                                    aVar2.bmw = optDouble;
                                    aVar2.count = j;
                                    aVar2.bnd = aVar.name;
                                    aVar2.bmv = j2;
                                    rVar.bnc.add(aVar2);
                                }
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
                                        HashMap<Long, r> hashMap = this.bkG.get(next);
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
                                if (!this.bkG.containsKey(D)) {
                                    HashMap<Long, r> hashMap2 = new HashMap<>();
                                    hashMap2.put(Long.valueOf(bVar.getMsgId()), rVar);
                                    this.bkG.put(D, hashMap2);
                                } else {
                                    this.bkG.get(D).put(Long.valueOf(bVar.getMsgId()), rVar);
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
    public void a(String str, long j, long j2, String str2, boolean z, Map<Long, Long> map) {
        if (map != null && !map.isEmpty()) {
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow();
            }
            String D = com.baidu.live.utils.r.D(str, TbadkCoreApplication.getCurrentAccount(), str2);
            HashMap<Long, r> hashMap = this.bkH.get(D);
            if (hashMap != null && !hashMap.isEmpty()) {
                for (Long l : map.keySet()) {
                    r rVar = hashMap.get(l);
                    if (rVar == null) {
                        Iterator<r> it = hashMap.values().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            r next = it.next();
                            if (next.bmA.contains(l)) {
                                rVar = next;
                                break;
                            }
                        }
                    }
                    if (rVar != null) {
                        long longValue = map.get(l).longValue();
                        if (z) {
                            rVar.bmu = longValue + rVar.bmu;
                        }
                        if (rVar.bmz) {
                            hashMap.remove(Long.valueOf(rVar.aWT));
                            for (r.a aVar : rVar.bnc) {
                                aVar.bmt.aU(aVar.count);
                                aVar.bmt.n(aVar.bmw);
                                aVar.bmt.aV(aVar.bmv);
                                a(-1, aVar.bmt);
                                if (this.bmY != null) {
                                    this.bmY.d(this.mMsgList, true);
                                }
                                long j3 = rVar.bmu;
                                if (j3 > 0) {
                                    h(j3, aVar.giftName);
                                }
                            }
                        }
                    }
                }
                if (hashMap.isEmpty()) {
                    this.bkH.remove(D);
                }
            }
        }
    }

    public void DN() {
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
        MessageManager.getInstance().unRegisterListener(this.bkQ);
        MessageManager.getInstance().unRegisterListener(this.bkR);
        MessageManager.getInstance().unRegisterListener(this.bkM);
        MessageManager.getInstance().unRegisterListener(this.bkV);
        MessageManager.getInstance().unRegisterListener(this.bkW);
        MessageManager.getInstance().unRegisterListener(this.bkX);
        MessageManager.getInstance().unRegisterListener(this.bkY);
        MessageManager.getInstance().unRegisterListener(this.bkU);
        MessageManager.getInstance().unRegisterListener(this.bmZ);
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
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031054, TbConfig.SERVER_ADDRESS + "ala/audio/user/judgeBan");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(YuyinAlaForbiddenWordsStateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(ImSendMsgData imSendMsgData, boolean z, boolean z2, int i, String str, String[] strArr) {
        Log.i("i", "@@@ localText limmdl sm");
        if (!TbadkCoreApplication.isLogin()) {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.h.sdk_not_login);
        } else if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow())) {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.h.sdk_username_empty);
        } else {
            Log.i("i", "@@@ localText limmdl sm 1");
            String str2 = imSendMsgData.text;
            short s = imSendMsgData.msgType;
            com.baidu.live.im.data.b a2 = a(s, str2, z, z2, i, "", this.aKB);
            if (s == 126) {
                a2.fe(imSendMsgData.barrageType);
                a2.ii(imSendMsgData.barrageId);
                a2.a(imSendMsgData.barrageCardInfo);
            }
            Log.i("i", "@@@ localText limmdl sm cm=" + a2);
            if (a2 != null) {
                a2.l(strArr);
                a(-1, a2);
                if (this.bmY != null) {
                    Log.i("i", "@@@ localText limmdl sm recv");
                    this.bmY.t(a2);
                    this.bmY.d(this.mMsgList, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913043));
                com.baidu.live.im.message.a aVar = new com.baidu.live.im.message.a(str2, s, JavaTypesHelper.toInt(this.mGroupId, 0), this.mAppId);
                if (this.aFN != null && this.aFN.mLiveInfo != null && this.aFN.aKL != null) {
                    aVar.setLiveId(this.aFN.mLiveInfo.live_id + "");
                    aVar.setRoomId(this.aFN.mLiveInfo.room_id + "");
                    aVar.ff(1);
                    aVar.setCustomRoomId(this.aFN.aKL.croom_id);
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

    public void f(String str, long j) {
        Log.i("i", "@@@ localText limm sdreq uk=" + str + ",lvd=" + j + ",iibr=" + this.bkB);
        if (!this.bkB) {
            this.bkB = true;
            Log.i("i", "@@@ localText limm sdreq go");
            com.baidu.live.im.message.c cVar = new com.baidu.live.im.message.c(1031054);
            cVar.addParam("uk", str);
            cVar.addParam("live_id", j);
            cVar.aX(System.currentTimeMillis());
            sendMessage(cVar);
            this.mHandler.postDelayed(this.bkK, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MD() {
        Log.i("i", "@@@ localText limm sdreq out");
        this.bkB = false;
        this.bkC = true;
        YuyinImForbiddenStateData yuyinImForbiddenStateData = new YuyinImForbiddenStateData();
        yuyinImForbiddenStateData.errno = -1;
        yuyinImForbiddenStateData.errMsg = this.mPageContext.getString(a.h.sdk_neterror);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, yuyinImForbiddenStateData));
    }

    private void T(List<com.baidu.live.im.data.b> list) {
        if (!ListUtils.isEmpty(list)) {
            for (com.baidu.live.im.data.b bVar : list) {
                if (bVar != null) {
                    if (bVar.getMsgType() == 13) {
                        try {
                            JSONObject jSONObject = new JSONObject(bVar.getContent());
                            String optString = jSONObject.optString("content_type");
                            if (TextUtils.equals("audio_link_online", optString)) {
                                jSONObject.optString("room_id");
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                            } else if (TextUtils.equals("audio_link_toast", optString)) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501012));
                            } else if (TextUtils.equals("audio_link_cancel", optString)) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501012));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (bVar.getMsgType() == 24) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(bVar.getContent());
                            if (jSONObject2 != null) {
                                bVar.bnb = jSONObject2.optString("benefit_info");
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
