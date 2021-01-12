package com.baidu.live.im;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
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
import com.baidu.live.gift.YuyinGiftPackageConsumeHttpResponsedMessage;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.an;
import com.baidu.live.gift.ap;
import com.baidu.live.gift.aq;
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
import com.baidu.live.utils.s;
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
/* loaded from: classes10.dex */
public class q extends BdBaseModel {
    private x aBr;
    private List<AlaLiveMarkData> aGo;
    private Runnable bhA;
    private CustomMessageListener bhB;
    private CustomMessageListener bhC;
    private Runnable bhD;
    private HttpMessageListener bhE;
    private HttpMessageListener bhF;
    private HttpMessageListener bhH;
    private HttpMessageListener bhI;
    private HttpMessageListener bhJ;
    private NetMessageListener bhK;
    CustomMessageListener bhL;
    CustomMessageListener bhM;
    CustomMessageListener bhN;
    CustomMessageListener bhO;
    CustomMessageListener bhP;
    private HttpMessageListener bhQ;
    BdPageContext<?> bhf;
    private boolean bhg;
    private String bhi;
    private String bhj;
    private List<com.baidu.live.im.data.b> bhk;
    private int bhl;
    private int bhm;
    private int bhn;
    private float bho;
    private String bhp;
    private boolean bhr;
    private boolean bhs;
    private int bht;
    private int bhu;
    private boolean bhv;
    private LinkedHashMap<String, HashMap<Long, r>> bhw;
    private HashMap<String, HashMap<Long, r>> bhx;
    private b.a bhy;
    private Runnable bhz;
    public long bjP;
    public long bjQ;
    public long bjR;
    private a bjS;
    private CustomMessageListener bjT;
    private long count;
    private String mAppId;
    private String mGroupId;
    private Handler mHandler;
    private String mLiveId;
    private LinkedList<com.baidu.live.im.data.b> mMsgList;

    /* loaded from: classes10.dex */
    public interface a {
        void Ig();

        void d(List<com.baidu.live.im.data.b> list, boolean z);

        void t(com.baidu.live.im.data.b bVar);
    }

    static /* synthetic */ int h(q qVar) {
        int i = qVar.bhn;
        qVar.bhn = i + 1;
        return i;
    }

    public q(BdPageContext<?> bdPageContext, boolean z, a aVar) {
        super(bdPageContext);
        this.bjP = 10L;
        this.bjQ = 30L;
        this.bjR = 5000L;
        this.mLiveId = null;
        this.bho = 1.0f;
        this.mHandler = new Handler();
        this.bhp = null;
        this.bhr = false;
        this.bhs = false;
        this.bhu = 0;
        this.bhv = false;
        this.bhy = new b.a() { // from class: com.baidu.live.im.q.1
        };
        this.bhz = new Runnable() { // from class: com.baidu.live.im.q.12
            @Override // java.lang.Runnable
            public void run() {
                int i = q.this.bhn * q.this.bhl;
                if (i >= q.this.bhk.size()) {
                    q.this.Ic();
                } else if (q.this.bhn >= q.this.bhm - 1) {
                    if (q.this.bhn != q.this.bhm - 1) {
                        q.this.Ic();
                        return;
                    }
                    ArrayList arrayList = new ArrayList(q.this.bhk);
                    q.this.N(q.this.b(arrayList.subList(i, arrayList.size()), true));
                    q.h(q.this);
                    q.this.Ic();
                } else {
                    ArrayList arrayList2 = new ArrayList(q.this.bhk);
                    if (q.this.bhl + i <= arrayList2.size()) {
                        q.this.N(q.this.b(arrayList2.subList(i, q.this.bhl + i), true));
                        q.h(q.this);
                        q.this.mHandler.postDelayed(q.this.bhz, 250L);
                        return;
                    }
                    q.this.N(q.this.b(arrayList2.subList(i, arrayList2.size()), true));
                    q.h(q.this);
                    q.this.Ic();
                }
            }
        };
        this.bhA = new Runnable() { // from class: com.baidu.live.im.q.15
            @Override // java.lang.Runnable
            public void run() {
                q.this.If();
            }
        };
        this.bhB = new CustomMessageListener(MessageConfig.SOCKET_RECEIVE_MSG) { // from class: com.baidu.live.im.q.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                q.this.HY();
            }
        };
        this.bhC = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.live.im.q.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        com.baidu.live.im.a aVar2 = new com.baidu.live.im.a();
                        aVar2.setMsgType(27);
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("text", q.this.bhf.getString(a.h.sdk_im_offline));
                            jSONObject.put("content_type", "custom_network_change");
                            aVar2.setContent(jSONObject.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        q.this.a(-1, aVar2);
                        if (q.this.bjS != null) {
                            q.this.bjS.t(aVar2);
                            q.this.bjS.d(q.this.mMsgList, true);
                        }
                    } else if (((NetWorkChangedMessage) customResponsedMessage).mLastNetState == 0 && BdNetTypeUtil.isNetWorkAvailable()) {
                        com.baidu.live.im.a aVar3 = new com.baidu.live.im.a();
                        aVar3.setMsgType(27);
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("text", q.this.bhf.getString(a.h.sdk_im_online));
                            jSONObject2.put("content_type", "custom_network_change");
                            aVar3.setContent(jSONObject2.toString());
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        q.this.a(-1, aVar3);
                        if (q.this.bjS != null) {
                            q.this.bjS.t(aVar3);
                            q.this.bjS.d(q.this.mMsgList, true);
                        }
                    }
                }
            }
        };
        this.bhD = new Runnable() { // from class: com.baidu.live.im.q.18
            @Override // java.lang.Runnable
            public void run() {
                if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().getLastReceDataTime() > 35000) {
                    q.this.HX();
                }
                q.this.HW();
            }
        };
        this.bjT = new CustomMessageListener(2501072) { // from class: com.baidu.live.im.q.19
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b)) {
                    com.baidu.live.im.data.b bVar = (com.baidu.live.im.data.b) customResponsedMessage.getData();
                    q.this.a(-1, bVar);
                    if (q.this.bjS != null) {
                        q.this.bjS.d(q.this.mMsgList, true);
                        q.this.bjS.t(bVar);
                    }
                }
            }
        };
        this.bhE = new HttpMessageListener(1021013) { // from class: com.baidu.live.im.q.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    boolean z2 = false;
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        int error = httpResponsedMessage.getError();
                        if (com.baidu.live.af.a.OJ().bru.aKs == 1) {
                            if (error == 149010) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913070, q.this.bhf.getPageActivity().getString(a.h.im_improper_content_tip)));
                                z2 = true;
                            } else if (error == 1202 || error == 1203) {
                                BdUtilHelper.showToast(q.this.bhf.getPageActivity(), q.this.bhf.getPageActivity().getString(a.h.im_improper_content_tip_net));
                                z2 = true;
                            } else if (error == 1204) {
                                BdUtilHelper.showToast(q.this.bhf.getPageActivity(), q.this.bhf.getPageActivity().getString(a.h.im_improper_content_tip));
                                z2 = true;
                            }
                        }
                    }
                    if (!z2 && q.this.bjS != null) {
                        q.this.bjS.Ig();
                    }
                }
            }
        };
        this.bhF = new HttpMessageListener(1031055) { // from class: com.baidu.live.im.q.21
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
                            if (!q.this.bhv) {
                                q.this.g(anVar.aTI, anVar.giftName);
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                        }
                        if (q.this.bhv) {
                            q.this.a(anVar.giftId, anVar.aVd, anVar.aTI, anVar.aTM, anVar.aVe, z2, anVar.aTO);
                        }
                    }
                }
            }
        };
        this.bhH = new HttpMessageListener(1031056) { // from class: com.baidu.live.im.q.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof ap) {
                        ap apVar = (ap) orginalMessage;
                        boolean z2 = false;
                        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            z2 = true;
                            if (!q.this.bhv) {
                                q.this.g(apVar.aTI, apVar.giftName);
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                        }
                        if (q.this.bhv) {
                            q.this.a(apVar.giftId, apVar.aTI, apVar.aVd, apVar.aTM, apVar.aVe, z2, apVar.aTO);
                        }
                    }
                }
            }
        };
        this.bhI = new HttpMessageListener(1031057) { // from class: com.baidu.live.im.q.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                boolean z2;
                boolean z3;
                if (httpResponsedMessage != null) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof aq) {
                        aq aqVar = (aq) orginalMessage;
                        if ((httpResponsedMessage instanceof YuyinGiftPackageConsumeHttpResponsedMessage) && TextUtils.isEmpty(((YuyinGiftPackageConsumeHttpResponsedMessage) httpResponsedMessage).aUM)) {
                            if (!q.this.bhv) {
                                q.this.g(aqVar.aUu, aqVar.giftName);
                            }
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            if (!q.this.bhv) {
                                q.this.g(aqVar.aUu, aqVar.giftName);
                            }
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (q.this.bhv) {
                            q.this.a(aqVar.giftId, aqVar.aVd, aqVar.aUu, aqVar.aTM, aqVar.aVf, z3, aqVar.aTO);
                        }
                    }
                }
            }
        };
        this.bhJ = new HttpMessageListener(1021012) { // from class: com.baidu.live.im.q.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                q.this.a((ResponsedMessage<?>) httpResponsedMessage, false);
            }
        };
        this.bhK = new NetMessageListener(1031043, 601008) { // from class: com.baidu.live.im.q.5
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
                        if (!TextUtils.isEmpty(((AlaGetAudioLiveStatusHttpResponseMessage) responsedMessage).bri)) {
                            jSONObject = new JSONObject(alaGetAudioLiveStatusHttpResponseMessage.bri);
                            jSONObject2 = jSONObject;
                            if (jSONObject2 == null) {
                                if (!"backstage_live".equals(jSONObject2.optString("content_type"))) {
                                    q.this.a(alaGetAudioLiveStatusHttpResponseMessage.bri, jSONObject2, 12, false);
                                    return;
                                }
                                String optString = jSONObject2.optString("backstage_type");
                                if (!TextUtils.isEmpty(optString) && !optString.equals(q.this.bhp)) {
                                    q.this.a(alaGetAudioLiveStatusHttpResponseMessage.bri, jSONObject2, 13, true);
                                    q.this.bhp = optString;
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
        this.bhL = new CustomMessageListener(2913192) { // from class: com.baidu.live.im.q.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText banlstn sd=" + q.this.aBr);
                if (q.this.aBr != null) {
                    if (q.this.aBr.mLiveInfo.getUserID() == Long.valueOf(TbadkCoreApplication.getCurrentAccount()).longValue()) {
                        Log.i("i", "@@@ localText banlstn own");
                        if (q.this.aBr.aFH != null && q.this.aBr.mLiveInfo != null) {
                            Log.i("i", "@@@ localText banlstn own sdreq");
                            q.this.f(q.this.aBr.aFH.userUk, q.this.aBr.mLiveInfo.live_id);
                            return;
                        }
                        return;
                    }
                    Log.i("i", "@@@ localText banlstn oth");
                    if (q.this.aBr.aGd != null && q.this.aBr.mLiveInfo != null) {
                        Log.i("i", "@@@ localText banlstn oth sdreq");
                        q.this.f(q.this.aBr.aGd.userUk, q.this.aBr.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.bhM = new CustomMessageListener(2913185) { // from class: com.baidu.live.im.q.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                r rVar;
                if (q.this.bhv) {
                    if (q.this.bhx == null) {
                        q.this.bhx = new HashMap();
                    }
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r) && (rVar = (r) customResponsedMessage.getData()) != null && rVar.bjW != null && rVar.bjW.size() > 0) {
                        String a2 = com.baidu.live.utils.s.a(rVar.aVd, rVar.giftId, rVar.userId, rVar.bjV);
                        for (r.a aVar2 : rVar.bjW) {
                            com.baidu.live.im.data.b a3 = q.this.a(aVar2.giftId, aVar2.aTL, aVar2.count + "", aVar2.giftName, 0L, aVar2.bjp, aVar2.bjX);
                            if (a3 != null) {
                                double m = q.this.m(a3);
                                a3.setMsgId(0L);
                                a3.setRecordId(0L);
                                com.baidu.live.data.a JB = a3.JB();
                                if (JB != null && !StringUtils.isNull(JB.userId) && !StringUtils.isNull(aVar2.giftId)) {
                                    aVar2.bjl = a3;
                                    aVar2.bjo = m;
                                } else {
                                    return;
                                }
                            }
                        }
                        if (!q.this.bhx.containsKey(a2)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put(Long.valueOf(rVar.aTM), rVar);
                            q.this.bhx.put(a2, hashMap);
                            return;
                        }
                        ((HashMap) q.this.bhx.get(a2)).put(Long.valueOf(rVar.aTM), rVar);
                    }
                }
            }
        };
        this.bhN = new CustomMessageListener(2913184) { // from class: com.baidu.live.im.q.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof s)) {
                    s sVar = (s) customResponsedMessage.getData();
                    if (sVar.bjv > 0) {
                        HashMap hashMap = (HashMap) q.this.bhw.get(sVar.aZI);
                        if (hashMap != null && !hashMap.isEmpty()) {
                            r rVar = (r) hashMap.remove(Long.valueOf(sVar.bjv));
                            if (rVar != null && rVar.bjW != null && rVar.bjW.size() > 0) {
                                rVar.bjr = true;
                                while (true) {
                                    int i2 = i;
                                    if (i2 >= rVar.bjW.size()) {
                                        break;
                                    }
                                    r.a aVar2 = rVar.bjW.get(i2);
                                    aVar2.bjl.setMsgType(24);
                                    aVar2.bjl.aT(aVar2.count);
                                    aVar2.bjl.h(aVar2.bjo);
                                    aVar2.bjl.blP = aVar2.bjX;
                                    aVar2.bjl.aU(aVar2.bjn);
                                    q.this.a(-1, aVar2.bjl);
                                    if (q.this.bjS != null) {
                                        q.this.bjS.d(q.this.mMsgList, true);
                                    }
                                    i = i2 + 1;
                                }
                            }
                            if (hashMap.isEmpty()) {
                                q.this.bhw.remove(sVar.aZI);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    HashMap hashMap2 = (HashMap) q.this.bhx.get(sVar.aZI);
                    if (hashMap2 != null && !hashMap2.isEmpty()) {
                        r rVar2 = (r) hashMap2.get(Long.valueOf(sVar.bjx));
                        if (rVar2 != null && rVar2.bjW != null && rVar2.bjW.size() > 0) {
                            hashMap2.remove(Long.valueOf(sVar.bjx));
                            while (true) {
                                int i3 = i;
                                if (i3 >= rVar2.bjW.size()) {
                                    break;
                                }
                                r.a aVar3 = rVar2.bjW.get(i3);
                                aVar3.bjl.aT(aVar3.count);
                                aVar3.bjl.h(aVar3.bjo);
                                aVar3.bjl.aU(aVar3.bjn);
                                aVar3.bjl.blP = aVar3.bjX;
                                q.this.a(-1, aVar3.bjl);
                                if (q.this.bjS != null) {
                                    q.this.bjS.d(q.this.mMsgList, true);
                                }
                                long j = rVar2.bjm;
                                if (j > 0) {
                                    q.this.g(j, aVar3.giftName);
                                }
                                i = i3 + 1;
                            }
                        }
                        if (hashMap2.isEmpty()) {
                            q.this.bhx.remove(sVar.aZI);
                        }
                    }
                }
            }
        };
        this.bhO = new CustomMessageListener(2913183) { // from class: com.baidu.live.im.q.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof s)) {
                    s sVar = (s) customResponsedMessage.getData();
                    if (sVar.bjv == 0) {
                        HashMap hashMap = (HashMap) q.this.bhx.get(sVar.aZI);
                        if (hashMap != null && !hashMap.isEmpty()) {
                            r rVar = (r) hashMap.get(Long.valueOf(sVar.bjx));
                            r rVar2 = (r) hashMap.get(Long.valueOf(sVar.bjA));
                            if (rVar != null && rVar2 != null) {
                                hashMap.remove(Long.valueOf(sVar.bjA));
                                if (rVar.bjW != null && rVar2.bjW != null && rVar.bjW.size() == rVar2.bjW.size()) {
                                    rVar.bjm += rVar2.bjm;
                                    while (i < rVar.bjW.size()) {
                                        rVar.bjW.get(i).count += rVar2.bjW.get(i).count;
                                        rVar.bjW.get(i).bjn += rVar2.bjW.get(i).bjn;
                                        if (rVar.bjW.get(i).bjo != rVar2.bjW.get(i).bjo) {
                                            rVar.bjW.get(i).bjo = 0.0d;
                                        }
                                        i++;
                                    }
                                    rVar.bjs.add(Long.valueOf(rVar2.aTM));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    HashMap hashMap2 = (HashMap) q.this.bhw.get(sVar.aZI);
                    if (hashMap2 != null && !hashMap2.isEmpty()) {
                        r rVar3 = (r) hashMap2.get(Long.valueOf(sVar.bjv));
                        r rVar4 = (r) hashMap2.remove(Long.valueOf(sVar.bjy));
                        if (rVar3 != null && rVar4 != null && rVar3.bjW != null && rVar4.bjW != null && rVar3.bjW.size() == rVar4.bjW.size()) {
                            while (i < rVar3.bjW.size()) {
                                rVar3.bjW.get(i).count += rVar4.bjW.get(i).count;
                                rVar3.bjW.get(i).bjn += rVar4.bjW.get(i).bjn;
                                if (rVar3.bjW.get(i).bjo != rVar4.bjW.get(i).bjo) {
                                    rVar3.bjW.get(i).bjo = 0.0d;
                                }
                                i++;
                            }
                        }
                    }
                }
            }
        };
        this.bhP = new CustomMessageListener(2913195) { // from class: com.baidu.live.im.q.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                HashMap hashMap;
                r rVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof s)) {
                    s sVar = (s) customResponsedMessage.getData();
                    if (sVar.bjv != 0 && (hashMap = (HashMap) q.this.bhw.get(sVar.aZI)) != null && !hashMap.isEmpty() && (rVar = (r) hashMap.get(Long.valueOf(sVar.bjv))) != null && rVar.bjW != null) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < rVar.bjW.size()) {
                                r.a aVar2 = rVar.bjW.get(i2);
                                if (sVar.bjY != null && sVar.bjY.size() > i2) {
                                    aVar2.count = sVar.bjY.get(i2).bjB;
                                    aVar2.bjn = sVar.bjY.get(i2).bjC;
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
        this.bhQ = new HttpMessageListener(1031054) { // from class: com.baidu.live.im.q.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                q.this.bhr = false;
                Log.i("i", "@@@ localText gtibslist 1");
                q.this.mHandler.removeCallbacks(q.this.bhA);
                if (httpResponsedMessage != null) {
                    if (httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.im.message.c) && ((com.baidu.live.im.message.c) httpResponsedMessage.getOrginalMessage()).aX(System.currentTimeMillis())) {
                        Log.i("i", "@@@ localText gtibslist out");
                        q.this.bhs = false;
                        return;
                    }
                    Log.i("i", "@@@ localText gtibslist ta=" + q.this.bhs);
                    if (q.this.bhs) {
                        q.this.bhs = false;
                    } else if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        Log.i("i", "@@@ localText gtibslist err he=" + httpResponsedMessage.hasError() + ", err=" + httpResponsedMessage.getError());
                        YuyinImForbiddenStateData yuyinImForbiddenStateData = new YuyinImForbiddenStateData();
                        yuyinImForbiddenStateData.errno = httpResponsedMessage.getError();
                        yuyinImForbiddenStateData.errMsg = httpResponsedMessage.getErrorString();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, yuyinImForbiddenStateData));
                    } else {
                        Log.i("i", "@@@ localText gtibslist suc");
                        if (httpResponsedMessage instanceof YuyinAlaForbiddenWordsStateResponseMessage) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, ((YuyinAlaForbiddenWordsStateResponseMessage) httpResponsedMessage).bmm));
                        }
                    }
                }
            }
        };
        if (com.baidu.live.af.a.OJ().bru.aKD != null) {
            this.bjP = com.baidu.live.af.a.OJ().bru.aKD.aOh;
            this.bjQ = com.baidu.live.af.a.OJ().bru.aKD.aOi;
            this.bjR = com.baidu.live.af.a.OJ().bru.aKD.aOj;
        }
        this.bhf = bdPageContext;
        this.bhg = z;
        this.bjS = aVar;
        this.mMsgList = new LinkedList<>();
        this.bhw = new LinkedHashMap<>();
        this.bhx = new HashMap<>();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501043, Object.class);
        if (runTask != null && runTask.getData() != null) {
            this.bhv = true;
        }
        MessageManager.getInstance().registerTask(HV());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031043, com.baidu.live.a.avU + "ala/audio/live/getLiveStatus");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGetAudioLiveStatusHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.live.tieba.f.a.a.a(1021012, "alaim/gmsg/getGroupMsg", ALAGroupHttpResponseMessage.class, false, true, true, true);
        Ie();
        registerListener(this.bhQ);
    }

    public void setAlaLiveShowData(x xVar) {
        this.aBr = xVar;
        if (this.aBr != null && this.aBr.mLiveInfo != null) {
            this.bht = this.aBr.mLiveInfo.audience_count - this.aBr.mLiveInfo.ai_robot_num;
        }
    }

    private HttpMessageTask HV() {
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
    public void HW() {
        this.mHandler.postDelayed(this.bhD, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HX() {
        sendMessage(new com.baidu.live.im.message.b(JavaTypesHelper.toInt(this.mGroupId, 0), getLastMid()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HY() {
        this.mHandler.removeCallbacks(this.bhD);
    }

    public void g(long j, String str) {
        if (j == 0) {
            j = 1;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.bhf.getString(a.h.sdk_gift);
        }
        com.baidu.live.im.data.b a2 = a((short) 27, String.format(this.bhf.getString(a.h.sdk_send_gift_fail_yuyin), Long.valueOf(j), str), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), "", this.aGo);
        if (a2 != null) {
            a(-1, a2);
            if (this.bjS != null) {
                this.bjS.t(a2);
                this.bjS.d(this.mMsgList, true);
            }
        }
    }

    public com.baidu.live.im.data.b a(String str, String str2, String str3, String str4, long j, boolean z, String str5) {
        return a((short) 24, a(str, str2, TextUtils.isEmpty(str3) ? "1" : str3, TextUtils.isEmpty(str4) ? this.bhf.getString(a.h.sdk_gift) : str4, j, z).toString(), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), str5, this.aGo);
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
        if (this.bjS != null) {
            this.bjS.t(aVar);
            if (z) {
                this.bjS.d(this.mMsgList, true);
            }
        }
    }

    protected void a(ResponsedMessage<?> responsedMessage, boolean z) {
        boolean z2;
        long j;
        List<com.baidu.live.im.data.b> list;
        if (responsedMessage instanceof ALAGroupHttpResponseMessage) {
            list = ((ALAGroupHttpResponseMessage) responsedMessage).JX();
            j = ((ALAGroupHttpResponseMessage) responsedMessage).getGroupId();
            z2 = ((ALAGroupHttpResponseMessage) responsedMessage).JW();
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
            if (this.bhm != 0) {
                int i2 = this.bhn * this.bhl;
                ArrayList arrayList = new ArrayList(this.bhk);
                d(0, arrayList.subList(i2, arrayList.size()));
                Ic();
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
        if (this.bhw != null) {
            this.bhw.clear();
        }
        if (this.bhx != null) {
            this.bhx.clear();
        }
        this.mMsgList = new LinkedList<>();
        this.mGroupId = str;
        this.bhi = str2;
        this.bhj = str3;
        this.mLiveId = str4;
        this.bhp = "0";
        this.mAppId = str5;
        MessageManager.getInstance().registerListener(this.bhJ);
        MessageManager.getInstance().registerListener(this.bhK);
        MessageManager.getInstance().registerListener(this.bhB);
        MessageManager.getInstance().registerListener(this.bhE);
        MessageManager.getInstance().registerListener(this.bhC);
        MessageManager.getInstance().registerListener(this.bhF);
        MessageManager.getInstance().registerListener(this.bhI);
        MessageManager.getInstance().registerListener(this.bhH);
        MessageManager.getInstance().registerListener(this.bhM);
        MessageManager.getInstance().registerListener(this.bhN);
        MessageManager.getInstance().registerListener(this.bhO);
        MessageManager.getInstance().registerListener(this.bhP);
        MessageManager.getInstance().registerListener(this.bhL);
        MessageManager.getInstance().registerListener(this.bjT);
        if (BdSocketLinkService.isClose()) {
            HX();
            BdSocketLinkService.startService(true, "live start");
        }
        if (com.baidu.live.af.a.OJ().bru != null && com.baidu.live.af.a.OJ().bru.aKD != null) {
            String str6 = com.baidu.live.af.a.OJ().bru.aKD.aOg;
            if (!TextUtils.isEmpty(str6)) {
                com.baidu.live.im.data.b Id = Id();
                Id.setMsgType(27);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("text", str6);
                    jSONObject.put("content_type", "audio_custom_live_notice");
                    Id.setContent(jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                a(-1, Id);
                if (this.bjS != null) {
                    this.bjS.t(Id);
                }
            }
        }
        if (this.aBr != null && this.aBr.aGv != null && !StringUtils.isNull(this.aBr.aGv.Au())) {
            com.baidu.live.im.data.b Id2 = Id();
            Id2.setMsgType(27);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("text", this.aBr.aGv.Au());
                jSONObject2.put("content_type", "custom_live_notice");
                jSONObject2.put("category_msg_filter", "1");
                Id2.setContent(jSONObject2.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.mMsgList.add(Id2);
            if (this.bjS != null) {
                this.bjS.t(Id2);
            }
        }
        Ia();
        if (this.mMsgList.size() > 0 && this.bjS != null) {
            this.bjS.d(this.mMsgList, true);
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGmsgGetLiveStatusUnabled()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.q.6
                @Override // java.lang.Runnable
                public void run() {
                    q.this.gz("enter");
                }
            }, 1000L);
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.q.7
            @Override // java.lang.Runnable
            public void run() {
                q.this.IX();
            }
        }, 1500L);
        HW();
        if (TbadkCoreApplication.getInst().isOther()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913146, this.mMsgList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IX() {
        com.baidu.live.im.data.b Id;
        if (this.aBr != null && this.aBr.aGy != null && this.aBr.aGy.aQP != null && !StringUtils.isNull(this.aBr.aGy.aQP.content) && (Id = Id()) != null) {
            Id.setMsgType(27);
            try {
                JSONObject jSONObject = new JSONObject();
                String str = this.aBr.aGy.aQP.content;
                String str2 = this.aBr.aGy.aQP.title;
                jSONObject.put("text", str);
                jSONObject.put("room_id", this.aBr.aGy.aQH);
                jSONObject.put(DpStatConstants.KEY_ROOM_NAME, this.aBr.aGy.room_name);
                jSONObject.put("live_id", this.aBr.aGy.live_id);
                jSONObject.put("cover", this.aBr.aGy.cover);
                jSONObject.put("content_type", "play_rules");
                Id.setContent(jSONObject.toString());
                this.mMsgList.add(Id);
                if (this.mMsgList.size() > 0 && this.bjS != null) {
                    this.bjS.d(this.mMsgList, true);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void Ia() {
        if (Ib()) {
            com.baidu.live.im.data.b Id = Id();
            Id.setMsgType(27);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("text", com.baidu.live.af.a.OJ().bru.aKp.aFT);
                jSONObject.put("content_type", "custom_im_notice_live_assistant");
                Id.setContent(jSONObject.toString());
                Id.setLink(com.baidu.live.af.a.OJ().bru.aKp.aFS);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mMsgList.add(Id);
            if (this.bjS != null) {
                this.bjS.t(Id);
            }
        }
    }

    private boolean Ib() {
        return (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) || !TbadkCoreApplication.getCurrentAccount().equals(this.bhj) || com.baidu.live.af.a.OJ().bru == null || com.baidu.live.af.a.OJ().bru.aKp == null || TextUtils.isEmpty(com.baidu.live.af.a.OJ().bru.aKp.aFT)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(List<com.baidu.live.im.data.b> list) {
        if (list != null && this.bjS != null) {
            this.bjS.d(this.mMsgList, true);
            for (com.baidu.live.im.data.b bVar : list) {
                this.bjS.t(bVar);
            }
        }
    }

    protected void O(List<com.baidu.live.im.data.b> list) {
        this.bhk = list;
        this.bhm = (int) ((this.bho * 2.0f) / 0.25f);
        this.bhn = 0;
        this.bhl = list.size() / this.bhm;
        if (this.bhl <= 0) {
            this.bhl = 1;
        }
        this.mHandler.removeCallbacks(this.bhz);
        this.mHandler.postDelayed(this.bhz, 250L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ic() {
        this.mHandler.removeCallbacks(this.bhz);
        this.bhn = 0;
        this.bhm = 0;
        this.bhl = 0;
        this.bhk = null;
    }

    protected List<com.baidu.live.im.data.b> b(List<com.baidu.live.im.data.b> list, boolean z) {
        return a(list, z, false);
    }

    protected List<com.baidu.live.im.data.b> a(List<com.baidu.live.im.data.b> list, boolean z, boolean z2) {
        for (com.baidu.live.im.data.b bVar : list) {
            if (bVar instanceof com.baidu.live.im.a) {
                ((com.baidu.live.im.a) bVar).gy(this.bhj);
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
        if (this.mMsgList.size() > com.baidu.live.af.a.OJ().bru.aKd) {
            int i = (int) (com.baidu.live.af.a.OJ().bru.aKd * 0.7d);
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
        com.baidu.live.data.a JB = bVar.JB();
        if (JB != null && (list = JB.aEm) != null && !list.isEmpty()) {
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
            d = com.baidu.live.af.f.Pa().i(z, jSONObject.optString(LogConfig.LOG_GIFT_ID));
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
                bVar.ch(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.live.im.data.b bVar) {
        boolean z = false;
        if ((bVar instanceof com.baidu.live.im.a) && bVar.JB() != null && TextUtils.equals(bVar.JB().userId, TbadkCoreApplication.getCurrentAccount())) {
            z = true;
        }
        if (this.bht < this.bjP) {
            if (i >= 0) {
                this.mMsgList.add(i, bVar);
            } else {
                this.mMsgList.addLast(bVar);
            }
        } else if (this.bht >= this.bjP && this.bht < this.bjQ) {
            if (q(bVar) && !z) {
                bVar.JN();
            }
            if (i >= 0) {
                this.mMsgList.add(i, bVar);
            } else if (!this.mMsgList.isEmpty() && q(this.mMsgList.getLast())) {
                if (!this.mMsgList.getLast().JB().userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.mMsgList.set(this.mMsgList.size() - 1, bVar);
                } else {
                    this.mMsgList.addLast(bVar);
                }
            } else {
                this.mMsgList.addLast(bVar);
            }
        } else if (this.bht >= this.bjQ && this.bht < this.bjR) {
            if (o(bVar) && !z) {
                bVar.JN();
            }
            if (i >= 0) {
                this.mMsgList.add(i, bVar);
            } else if (!this.mMsgList.isEmpty() && o(this.mMsgList.getLast())) {
                if (!this.mMsgList.getLast().JB().userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.mMsgList.set(this.mMsgList.size() - 1, bVar);
                } else {
                    this.mMsgList.addLast(bVar);
                }
            } else {
                this.mMsgList.addLast(bVar);
            }
        } else if (this.bht >= this.bjR) {
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
        this.bhu = 0;
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
                if (com.baidu.live.entereffect.a.BG().h(bVar)) {
                    this.bhu = 2;
                } else {
                    this.bhu = 1;
                }
            } else {
                this.bhu = 0;
            }
        }
        return this.bhu;
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
                    if (bVar != null && bVar.JB() != null && !TextUtils.isEmpty(bVar.JB().userId) && bVar.JB().userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        int i2 = size - 1;
                        while (true) {
                            if (i2 >= 0 && i2 >= 0) {
                                com.baidu.live.im.data.b bVar2 = list.get(i2);
                                if (bVar2 != null && bVar2.JB() != null && !TextUtils.isEmpty(bVar2.JB().userId) && bVar2.JB().userId.equals(TbadkCoreApplication.getCurrentAccount()) && bVar.getRecordId() == bVar2.getRecordId()) {
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
            if (!ListUtils.isEmpty(bVar.JD()) && !bVar.JD().contains(Long.valueOf(currentAccountId))) {
                linkedList.add(bVar);
            } else {
                boolean z2 = bVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                if (z2 && bVar.getMsgType() == 1 && !ListUtils.isEmpty(bVar.JB().aEm) && this.aGo == null) {
                    this.aGo = bVar.JB().aEm;
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
                            if (this.bjS != null) {
                                this.bjS.t(bVar);
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
                    if ("enter_live".equals(str) && this.bht < this.bjR) {
                        if (com.baidu.live.entereffect.a.BG().h(bVar)) {
                        }
                    } else if ("close_live".equals(str)) {
                        linkedList.add(bVar);
                        if (this.bjS != null) {
                            this.bjS.t(bVar);
                        }
                    } else if ("task".equals(str)) {
                        linkedList.add(bVar);
                        if (this.bjS != null) {
                            this.bjS.t(bVar);
                        }
                    } else if ("live_achievement".equals(str)) {
                        linkedList.add(bVar);
                        if (this.bjS != null) {
                            this.bjS.t(bVar);
                        }
                    } else if ("ss_hot_live".equals(str)) {
                        linkedList.add(bVar);
                        if (this.bjS != null) {
                            this.bjS.t(bVar);
                        }
                    } else if ("challenge_direct_new".equals(str)) {
                        linkedList.add(bVar);
                        if (this.bjS != null) {
                            this.bjS.t(bVar);
                        }
                    } else if ("challenge_random_cancel".equals(str)) {
                        linkedList.add(bVar);
                        if (this.bjS != null) {
                            this.bjS.t(bVar);
                        }
                    } else if ("update_liveinfo".equals(str)) {
                        linkedList.add(bVar);
                        if (this.bjS != null) {
                            this.bjS.t(bVar);
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
                        if (z2 && !ListUtils.isEmpty(bVar.JB().aEm)) {
                            this.aGo = bVar.JB().aEm;
                            if (this.aBr != null) {
                                this.aBr.aGo = this.aGo;
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
                                if (this.bjS != null) {
                                    this.bjS.t(bVar);
                                }
                            } else if ("introduce_goods".equals(str)) {
                                linkedList.add(bVar);
                                if (this.bjS != null) {
                                    this.bjS.t(bVar);
                                }
                            } else if ("first_recharge_success".equals(str)) {
                                linkedList.add(bVar);
                                if (this.bjS != null) {
                                    this.bjS.t(bVar);
                                }
                            } else if ("privilege_award_success".equals(str)) {
                                linkedList.add(bVar);
                                if (this.bjS != null) {
                                    this.bjS.t(bVar);
                                }
                            } else if ("need_update_live_mark_info".equals(str)) {
                                linkedList.add(bVar);
                                if (this.bjS != null) {
                                    this.bjS.t(bVar);
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
                                            JSONObject optJSONObject = new JSONObject(bVar.getContent()).optJSONObject("data");
                                            int optInt2 = optJSONObject.optInt("force_xiangqin_update");
                                            int optInt3 = optJSONObject.optInt("force_update");
                                            if (optInt2 == 1 || optInt3 == 1) {
                                                linkedList.add(bVar);
                                            }
                                        } catch (JSONException e4) {
                                            e4.printStackTrace();
                                        }
                                    } else if (!TextUtils.equals(str, "audio_low_version_toast") && !TextUtils.equals(str, "live_audio_audit_notice") && !TextUtils.equals(str, "sync_audio_speeker_status") && !TextUtils.equals(str, "audio_hat_level_toast") && !TextUtils.equals(str, "audio_hat_user_toast") && !TextUtils.equals(str, "audio_loot_gift") && !TextUtils.equals(str, "switch_activity_stage") && !TextUtils.equals(str, "audio_link_online") && !TextUtils.equals(str, "mode_change_stage") && !TextUtils.equals(str, "mode_add_time")) {
                                        if (TextUtils.equals(str, "audio_common_toast_msg")) {
                                            u(bVar);
                                            linkedList.add(bVar);
                                        } else if (TextUtils.equals(str, "gift_combo_end")) {
                                            linkedList.add(bVar);
                                            v(bVar);
                                            if (this.bjS != null) {
                                                this.bjS.t(bVar);
                                            }
                                        } else {
                                            linkedList.add(bVar);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (bVar.getMsgType() == 12) {
                    linkedList.add(bVar);
                    if (this.bjS != null) {
                        this.bjS.t(bVar);
                    }
                    gz("push");
                }
            }
        }
        if (linkedList.size() > 0) {
            list.removeAll(linkedList);
        }
    }

    private void u(com.baidu.live.im.data.b bVar) {
        try {
            String optString = new JSONObject(bVar.getContent()).optString("text");
            if (!TextUtils.isEmpty(optString)) {
                BdUtilHelper.showToast(this.bhf.getPageActivity(), optString);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected com.baidu.live.im.data.b a(short s, String str, boolean z, boolean z2, int i, String str2, List<AlaLiveMarkData> list) {
        long j = 0;
        com.baidu.live.im.data.b Id = Id();
        if (Id == null) {
            return null;
        }
        Id.setMsgType(s);
        Id.setContent(str);
        long aS = o.aS(getLastMid());
        Id.blP = str2;
        Id.setMsgId(aS);
        Id.setRecordId(aS);
        Id.setTime(System.currentTimeMillis() / 1000);
        com.baidu.live.data.a aVar = new com.baidu.live.data.a();
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            aVar.userName = TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow();
        }
        aVar.userId = TbadkCoreApplication.getCurrentAccount();
        aVar.portrait = TbadkCoreApplication.getCurrentPortrait();
        aVar.level_id = i;
        aVar.aEj = z;
        aVar.aEk = z2;
        if (list != null) {
            aVar.aEm = new ArrayList(list);
        }
        Id.e(aVar);
        try {
            j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        } catch (Exception e) {
        }
        Id.setUserId(j);
        return Id;
    }

    private long getLastMid() {
        if (this.mMsgList == null || this.mMsgList.size() <= 0) {
            return JavaTypesHelper.toLong(this.bhi, 1L);
        }
        return this.mMsgList.get(this.mMsgList.size() - 1).getMsgId();
    }

    protected com.baidu.live.im.data.b Id() {
        com.baidu.live.im.a aVar = new com.baidu.live.im.a();
        aVar.setBornTime(System.currentTimeMillis());
        if (TextUtils.isEmpty(this.mGroupId)) {
            return null;
        }
        aVar.gy(this.bhj);
        return aVar;
    }

    public void R(List<AlaLiveMarkData> list) {
        this.aGo = list;
    }

    public void gz(String str) {
        com.baidu.live.message.b bVar = new com.baidu.live.message.b(JavaTypesHelper.toLong(this.mLiveId, 0L), str);
        bVar.setParams();
        sendMessage(bVar);
    }

    public void gA(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.bhp)) {
            gz("getliveinfo");
        }
    }

    private List<com.baidu.live.im.data.b> r(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        int optInt;
        boolean CL;
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
            com.baidu.live.gift.g fQ = ac.fQ(jSONObject.optString(LogConfig.LOG_GIFT_ID));
            CL = fQ != null ? fQ.CL() : false;
        } catch (JSONException e) {
            arrayList.add(aVar);
        }
        if (optInt == 1 || CL) {
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
            aVar2.gy(aVar.HT());
            aVar2.setBornTime(aVar.getBornTime());
            aVar2.setTime(aVar.getTime());
            aVar2.setUserId(aVar.getUserId());
            aVar2.setToUserId(aVar.getToUserId());
            aVar2.f(aVar.JC());
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
            aVar2.e(aVar.JB());
            aVar2.setSt_type(aVar.getSt_type());
            arrayList.add(aVar2);
        }
        return arrayList;
    }

    public void a(int i, String str, com.baidu.live.data.a aVar) {
        com.baidu.live.im.data.b Id = Id();
        if (Id != null) {
            Id.setMsgType(i);
            Id.setContent(str);
            Id.e(aVar);
            a(-1, Id);
            if (this.bjS != null) {
                this.bjS.d(this.mMsgList, true);
                this.bjS.t(Id);
            }
        }
    }

    private void v(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        try {
            if (bVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) bVar.getObjContent();
            } else {
                jSONObject = new JSONObject(bVar.getContent());
            }
        } catch (JSONException e) {
            jSONObject = null;
        }
        String optString = jSONObject.optString(LogConfig.LOG_GIFT_ID);
        long optLong = jSONObject.optLong("combo_groupid");
        com.baidu.live.data.a JB = bVar.JB();
        String str = JB.userId;
        JB.getNameShow();
        String a2 = com.baidu.live.utils.s.a(optLong, optString, str, bVar.bjV);
        if (this.bhw == null) {
            this.bhw = new LinkedHashMap<>();
        }
        long j = JavaTypesHelper.toLong(jSONObject.optString("gift_count"), 0L);
        double optDouble = jSONObject.optDouble("gift_rate", 0.0d);
        long j2 = JavaTypesHelper.toLong(jSONObject.optString("charm_value"), 0L);
        jSONObject.optString("gift_url");
        jSONObject.optString("gift_name");
        r rVar = new r();
        rVar.bjW = new ArrayList();
        rVar.giftId = optString;
        rVar.aVd = optLong;
        rVar.bjV = bVar.bjV;
        for (s.a aVar : com.baidu.live.utils.s.hK(bVar.bjV)) {
            r.a aVar2 = new r.a();
            aVar2.bjl = bVar.clone();
            aVar2.bjl.setMsgType(24);
            aVar2.bjo = optDouble;
            aVar2.count = j;
            aVar2.bjX = aVar.name;
            aVar2.bjn = j2;
            rVar.bjW.add(aVar2);
        }
        Iterator<String> it = this.bhw.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (this.bhw.get(next) == null || this.bhw.get(next).isEmpty()) {
                it.remove();
            } else {
                HashMap<Long, r> hashMap = this.bhw.get(next);
                Iterator<Long> it2 = hashMap.keySet().iterator();
                while (it2.hasNext()) {
                    long longValue = it2.next().longValue();
                    if (hashMap.get(Long.valueOf(longValue)) == null || hashMap.get(Long.valueOf(longValue)).bjr) {
                        it2.remove();
                    }
                }
                if (this.bhw.get(next) == null || this.bhw.get(next).isEmpty()) {
                    it.remove();
                }
            }
        }
        if (!this.bhw.containsKey(a2)) {
            HashMap<Long, r> hashMap2 = new HashMap<>();
            hashMap2.put(Long.valueOf(bVar.getMsgId()), rVar);
            this.bhw.put(a2, hashMap2);
            return;
        }
        this.bhw.get(a2).put(Long.valueOf(bVar.getMsgId()), rVar);
    }

    private void b(List<com.baidu.live.im.data.b> list, int i) {
        JSONObject jSONObject;
        int i2;
        if (this.bhv) {
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
                            com.baidu.live.data.a JB = bVar.JB();
                            if (JB == null || StringUtils.isNull(JB.userId) || StringUtils.isNull(optString)) {
                                if (i >= 0) {
                                    a(i + i4, bVar);
                                } else {
                                    a(-1, bVar);
                                }
                            } else {
                                String str = JB.userId;
                                JB.getNameShow();
                                String a2 = com.baidu.live.utils.s.a(0L, optString, str, bVar.bjV);
                                if (this.bhw == null) {
                                    this.bhw = new LinkedHashMap<>();
                                }
                                long j = JavaTypesHelper.toLong(jSONObject.optString("gift_count"), 0L);
                                double optDouble = jSONObject.optDouble("gift_rate", 0.0d);
                                long j2 = JavaTypesHelper.toLong(jSONObject.optString("charm_value"), 0L);
                                jSONObject.optString("gift_url");
                                jSONObject.optString("gift_name");
                                long optLong = jSONObject.optLong("combo_groupid");
                                r rVar = new r();
                                rVar.bjW = new ArrayList();
                                rVar.giftId = optString;
                                rVar.aVd = optLong;
                                rVar.bjV = bVar.bjV;
                                for (s.a aVar : com.baidu.live.utils.s.hK(bVar.bjV)) {
                                    r.a aVar2 = new r.a();
                                    aVar2.bjl = bVar.clone();
                                    aVar2.bjo = optDouble;
                                    aVar2.count = j;
                                    aVar2.bjX = aVar.name;
                                    aVar2.bjn = j2;
                                    rVar.bjW.add(aVar2);
                                }
                                if (com.baidu.live.af.a.OJ().bru == null) {
                                    i2 = 100;
                                } else {
                                    i2 = com.baidu.live.af.a.OJ().bru.aKj * 2;
                                }
                                Iterator<String> it = this.bhw.keySet().iterator();
                                int i5 = 0;
                                while (it.hasNext()) {
                                    String next = it.next();
                                    if (this.bhw.get(next) == null || this.bhw.get(next).isEmpty()) {
                                        it.remove();
                                    } else {
                                        HashMap<Long, r> hashMap = this.bhw.get(next);
                                        Iterator<Long> it2 = hashMap.keySet().iterator();
                                        while (it2.hasNext()) {
                                            long longValue = it2.next().longValue();
                                            if (hashMap.get(Long.valueOf(longValue)) == null || hashMap.get(Long.valueOf(longValue)).bjr) {
                                                it2.remove();
                                            }
                                        }
                                        if (this.bhw.get(next) == null || this.bhw.get(next).isEmpty()) {
                                            it.remove();
                                        } else {
                                            i5 = hashMap.size() + i5;
                                        }
                                    }
                                }
                                if (i5 > i2) {
                                    int i6 = i5 - ((int) (i2 * 0.7d));
                                    Iterator<String> it3 = this.bhw.keySet().iterator();
                                    while (true) {
                                        int i7 = i6;
                                        if (!it3.hasNext()) {
                                            break;
                                        }
                                        i6 = i7 - this.bhw.get(it3.next()).size();
                                        it3.remove();
                                        if (i6 <= 0) {
                                            break;
                                        }
                                    }
                                }
                                if (!this.bhw.containsKey(a2)) {
                                    HashMap<Long, r> hashMap2 = new HashMap<>();
                                    hashMap2.put(Long.valueOf(bVar.getMsgId()), rVar);
                                    this.bhw.put(a2, hashMap2);
                                } else {
                                    this.bhw.get(a2).put(Long.valueOf(bVar.getMsgId()), rVar);
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
    public void a(String str, long j, long j2, long j3, String str2, boolean z, Map<Long, Long> map) {
        if (map != null && !map.isEmpty()) {
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow();
            }
            String a2 = com.baidu.live.utils.s.a(j, str, TbadkCoreApplication.getCurrentAccount(), str2);
            HashMap<Long, r> hashMap = this.bhx.get(a2);
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
                            if (next.bjs.contains(l)) {
                                rVar = next;
                                break;
                            }
                        }
                    }
                    if (rVar != null) {
                        long longValue = map.get(l).longValue();
                        if (z) {
                            rVar.bjm = longValue + rVar.bjm;
                        }
                        if (rVar.bjr) {
                            hashMap.remove(Long.valueOf(rVar.aTM));
                            for (r.a aVar : rVar.bjW) {
                                aVar.bjl.aT(aVar.count);
                                aVar.bjl.h(aVar.bjo);
                                aVar.bjl.aU(aVar.bjn);
                                a(-1, aVar.bjl);
                                if (this.bjS != null) {
                                    this.bjS.d(this.mMsgList, true);
                                }
                                long j4 = rVar.bjm;
                                if (j4 > 0) {
                                    g(j4, aVar.giftName);
                                }
                            }
                        }
                    }
                }
                if (hashMap.isEmpty()) {
                    this.bhx.remove(a2);
                }
            }
        }
    }

    public void zh() {
        this.mGroupId = null;
        this.bhi = null;
        this.mLiveId = null;
        this.bhp = "0";
        this.mAppId = null;
        this.bhr = false;
        this.bhs = false;
        MessageManager.getInstance().unRegisterListener(this.bhK);
        MessageManager.getInstance().unRegisterListener(this.bhJ);
        MessageManager.getInstance().unRegisterListener(this.bhB);
        MessageManager.getInstance().unRegisterListener(this.bhE);
        MessageManager.getInstance().unRegisterListener(this.bhF);
        MessageManager.getInstance().unRegisterListener(this.bhH);
        MessageManager.getInstance().unRegisterListener(this.bhI);
        MessageManager.getInstance().unRegisterListener(this.bhC);
        MessageManager.getInstance().unRegisterListener(this.bhM);
        MessageManager.getInstance().unRegisterListener(this.bhN);
        MessageManager.getInstance().unRegisterListener(this.bhO);
        MessageManager.getInstance().unRegisterListener(this.bhP);
        MessageManager.getInstance().unRegisterListener(this.bhL);
        MessageManager.getInstance().unRegisterListener(this.bjT);
        this.mHandler.removeCallbacks(this.bhA);
        this.mHandler.removeCallbacks(this.bhz);
        this.mHandler.removeCallbacks(this.bhD);
        if (this.mMsgList != null) {
            this.mMsgList.clear();
        }
        this.mMsgList = null;
        if (this.bhw != null) {
            this.bhw.clear();
        }
        if (this.bhx != null) {
            this.bhx.clear();
        }
    }

    private void Ie() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031054, com.baidu.live.a.avU + "ala/audio/user/judgeBan");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(YuyinAlaForbiddenWordsStateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(ImSendMsgData imSendMsgData, boolean z, boolean z2, int i, String str, String[] strArr) {
        Log.i("i", "@@@ localText limmdl sm");
        if (!TbadkCoreApplication.isLogin()) {
            BdUtilHelper.showToast(this.bhf.getPageActivity(), a.h.sdk_not_login);
        } else if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow())) {
            BdUtilHelper.showToast(this.bhf.getPageActivity(), a.h.sdk_username_empty);
        } else {
            Log.i("i", "@@@ localText limmdl sm 1");
            String str2 = imSendMsgData.text;
            short s = imSendMsgData.msgType;
            com.baidu.live.im.data.b a2 = a(s, str2, z, z2, i, "", this.aGo);
            if (s == 126) {
                a2.dw(imSendMsgData.barrageType);
                a2.gI(imSendMsgData.barrageId);
                a2.a(imSendMsgData.barrageCardInfo);
            }
            Log.i("i", "@@@ localText limmdl sm cm=" + a2);
            if (a2 != null) {
                a2.l(strArr);
                a(-1, a2);
                if (this.bjS != null) {
                    Log.i("i", "@@@ localText limmdl sm recv");
                    this.bjS.t(a2);
                    this.bjS.d(this.mMsgList, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913043));
                com.baidu.live.im.message.a aVar = new com.baidu.live.im.message.a(str2, s, JavaTypesHelper.toInt(this.mGroupId, 0), this.mAppId);
                if (this.aBr != null && this.aBr.mLiveInfo != null && this.aBr.aGy != null) {
                    aVar.setLiveId(this.aBr.mLiveInfo.live_id + "");
                    aVar.setRoomId(this.aBr.mLiveInfo.room_id + "");
                    aVar.dx(1);
                    aVar.setCustomRoomId(this.aBr.aGy.croom_id);
                } else {
                    aVar.setLiveId("");
                    aVar.setRoomId("");
                }
                aVar.setOtherParams(str);
                aVar.aV(imSendMsgData.price);
                aVar.dw(imSendMsgData.barrageType);
                aVar.gI(imSendMsgData.barrageId);
                aVar.a(imSendMsgData.barrageCardInfo);
                aVar.l(strArr);
                aVar.ci(imSendMsgData.isQuick);
                sendMessage(aVar);
            }
        }
    }

    public void f(String str, long j) {
        Log.i("i", "@@@ localText limm sdreq uk=" + str + ",lvd=" + j + ",iibr=" + this.bhr);
        if (!this.bhr) {
            this.bhr = true;
            Log.i("i", "@@@ localText limm sdreq go");
            com.baidu.live.im.message.c cVar = new com.baidu.live.im.message.c(1031054);
            cVar.addParam("uk", str);
            cVar.addParam("live_id", j);
            cVar.aW(System.currentTimeMillis());
            sendMessage(cVar);
            this.mHandler.postDelayed(this.bhA, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void If() {
        Log.i("i", "@@@ localText limm sdreq out");
        this.bhr = false;
        this.bhs = true;
        YuyinImForbiddenStateData yuyinImForbiddenStateData = new YuyinImForbiddenStateData();
        yuyinImForbiddenStateData.errno = -1;
        yuyinImForbiddenStateData.errMsg = this.bhf.getString(a.h.sdk_neterror);
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
                            } else if (TextUtils.equals(optString, "gift_combo_end") && jSONObject != null) {
                                bVar.bjV = jSONObject.optString("benefit_info");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (bVar.getMsgType() == 24) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(bVar.getContent());
                            if (jSONObject2 != null) {
                                bVar.bjV = jSONObject2.optString("benefit_info");
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
