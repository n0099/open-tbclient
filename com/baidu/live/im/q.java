package com.baidu.live.im;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.db.DBResource;
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
import com.baidu.live.data.ab;
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
    private ab aED;
    private List<AlaLiveMarkData> aKk;
    BdPageContext<?> blX;
    private boolean blY;
    private HttpMessageListener bmA;
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
    private boolean bml;
    private boolean bmm;
    private int bmn;
    private int bmo;
    private boolean bmq;
    private LinkedHashMap<String, HashMap<Long, r>> bmr;
    private HashMap<String, HashMap<Long, r>> bms;
    private b.a bmt;
    private Runnable bmu;
    private Runnable bmv;
    private CustomMessageListener bmw;
    private CustomMessageListener bmx;
    private Runnable bmy;
    private HttpMessageListener bmz;
    public long boH;
    public long boI;
    public long boJ;
    private a boK;
    private CustomMessageListener boL;
    private CustomMessageListener boM;
    private long count;
    private String mAppId;
    private String mGroupId;
    private Handler mHandler;
    private String mLiveId;
    private LinkedList<com.baidu.live.im.data.b> mMsgList;

    /* loaded from: classes10.dex */
    public interface a {
        void JH();

        void d(List<com.baidu.live.im.data.b> list, boolean z);

        void t(com.baidu.live.im.data.b bVar);
    }

    static /* synthetic */ int h(q qVar) {
        int i = qVar.bmf;
        qVar.bmf = i + 1;
        return i;
    }

    public q(BdPageContext<?> bdPageContext, boolean z, a aVar) {
        super(bdPageContext);
        this.boH = 100L;
        this.boI = 200L;
        this.boJ = 5000L;
        this.mLiveId = null;
        this.bmg = 1.0f;
        this.mHandler = new Handler();
        this.bmh = null;
        this.bml = false;
        this.bmm = false;
        this.bmo = 0;
        this.bmq = false;
        this.bmt = new b.a() { // from class: com.baidu.live.im.q.1
        };
        this.bmu = new Runnable() { // from class: com.baidu.live.im.q.12
            @Override // java.lang.Runnable
            public void run() {
                int i = q.this.bmf * q.this.bmd;
                if (i >= q.this.bmc.size()) {
                    q.this.JD();
                } else if (q.this.bmf >= q.this.bme - 1) {
                    if (q.this.bmf != q.this.bme - 1) {
                        q.this.JD();
                        return;
                    }
                    ArrayList arrayList = new ArrayList(q.this.bmc);
                    q.this.O(q.this.b(arrayList.subList(i, arrayList.size()), true));
                    q.h(q.this);
                    q.this.JD();
                } else {
                    ArrayList arrayList2 = new ArrayList(q.this.bmc);
                    if (q.this.bmd + i <= arrayList2.size()) {
                        q.this.O(q.this.b(arrayList2.subList(i, q.this.bmd + i), true));
                        q.h(q.this);
                        q.this.mHandler.postDelayed(q.this.bmu, 250L);
                        return;
                    }
                    q.this.O(q.this.b(arrayList2.subList(i, arrayList2.size()), true));
                    q.h(q.this);
                    q.this.JD();
                }
            }
        };
        this.bmv = new Runnable() { // from class: com.baidu.live.im.q.15
            @Override // java.lang.Runnable
            public void run() {
                q.this.JG();
            }
        };
        this.bmw = new CustomMessageListener(MessageConfig.SOCKET_RECEIVE_MSG) { // from class: com.baidu.live.im.q.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                q.this.Jx();
            }
        };
        this.bmx = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.live.im.q.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        com.baidu.live.im.a aVar2 = new com.baidu.live.im.a();
                        aVar2.setMsgType(27);
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("text", q.this.blX.getString(a.h.sdk_im_offline));
                            jSONObject.put("content_type", "custom_network_change");
                            aVar2.setContent(jSONObject.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        q.this.a(-1, aVar2);
                        if (q.this.boK != null) {
                            q.this.boK.t(aVar2);
                            q.this.boK.d(q.this.mMsgList, true);
                        }
                    } else if (((NetWorkChangedMessage) customResponsedMessage).mLastNetState == 0 && BdNetTypeUtil.isNetWorkAvailable()) {
                        com.baidu.live.im.a aVar3 = new com.baidu.live.im.a();
                        aVar3.setMsgType(27);
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("text", q.this.blX.getString(a.h.sdk_im_online));
                            jSONObject2.put("content_type", "custom_network_change");
                            aVar3.setContent(jSONObject2.toString());
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        q.this.a(-1, aVar3);
                        if (q.this.boK != null) {
                            q.this.boK.t(aVar3);
                            q.this.boK.d(q.this.mMsgList, true);
                        }
                    }
                }
            }
        };
        this.bmy = new Runnable() { // from class: com.baidu.live.im.q.18
            @Override // java.lang.Runnable
            public void run() {
                if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().getLastReceDataTime() > 35000) {
                    q.this.Jw();
                }
                q.this.Jv();
            }
        };
        this.boL = new CustomMessageListener(2501072) { // from class: com.baidu.live.im.q.19
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b)) {
                    com.baidu.live.im.data.b bVar = (com.baidu.live.im.data.b) customResponsedMessage.getData();
                    q.this.a(-1, bVar);
                    if (q.this.boK != null) {
                        q.this.boK.d(q.this.mMsgList, true);
                        q.this.boK.t(bVar);
                    }
                }
            }
        };
        this.boM = new CustomMessageListener(2501085) { // from class: com.baidu.live.im.q.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                q.this.Ky();
            }
        };
        this.bmz = new HttpMessageListener(1021013) { // from class: com.baidu.live.im.q.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    boolean z2 = false;
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        int error = httpResponsedMessage.getError();
                        if (com.baidu.live.ae.a.Qm().bwx.aOF == 1) {
                            if (error == 149010) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913070, q.this.blX.getPageActivity().getString(a.h.im_improper_content_tip)));
                                z2 = true;
                            } else if (error == 1202 || error == 1203) {
                                BdUtilHelper.showToast(q.this.blX.getPageActivity(), q.this.blX.getPageActivity().getString(a.h.im_improper_content_tip_net));
                                z2 = true;
                            } else if (error == 1204) {
                                BdUtilHelper.showToast(q.this.blX.getPageActivity(), q.this.blX.getPageActivity().getString(a.h.im_improper_content_tip));
                                z2 = true;
                            }
                        }
                    }
                    if (!z2 && q.this.boK != null) {
                        q.this.boK.JH();
                    }
                }
            }
        };
        this.bmA = new HttpMessageListener(1031055) { // from class: com.baidu.live.im.q.2
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
                            if (!q.this.bmq) {
                                q.this.g(anVar.aYn, anVar.giftName);
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                        }
                        if (q.this.bmq) {
                            q.this.a(anVar.giftId, anVar.aZL, anVar.aYn, anVar.aYr, anVar.aZM, z2, anVar.aYt);
                        }
                    }
                }
            }
        };
        this.bmC = new HttpMessageListener(1031056) { // from class: com.baidu.live.im.q.3
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
                            if (!q.this.bmq) {
                                q.this.g(apVar.aYn, apVar.giftName);
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                        }
                        if (q.this.bmq) {
                            q.this.a(apVar.giftId, apVar.aYn, apVar.aZL, apVar.aYr, apVar.aZM, z2, apVar.aYt);
                        }
                    }
                }
            }
        };
        this.bmD = new HttpMessageListener(1031057) { // from class: com.baidu.live.im.q.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                boolean z2;
                boolean z3;
                if (httpResponsedMessage != null) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof aq) {
                        aq aqVar = (aq) orginalMessage;
                        if ((httpResponsedMessage instanceof YuyinGiftPackageConsumeHttpResponsedMessage) && TextUtils.isEmpty(((YuyinGiftPackageConsumeHttpResponsedMessage) httpResponsedMessage).aZu)) {
                            if (!q.this.bmq) {
                                q.this.g(aqVar.aYZ, aqVar.giftName);
                            }
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            if (!q.this.bmq) {
                                q.this.g(aqVar.aYZ, aqVar.giftName);
                            }
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (q.this.bmq) {
                            q.this.a(aqVar.giftId, aqVar.aZL, aqVar.aYZ, aqVar.aYr, aqVar.aZN, z3, aqVar.aYt);
                        }
                    }
                }
            }
        };
        this.bmE = new HttpMessageListener(1021012) { // from class: com.baidu.live.im.q.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                q.this.a((ResponsedMessage<?>) httpResponsedMessage, false);
            }
        };
        this.bmF = new NetMessageListener(1031043, 601008) { // from class: com.baidu.live.im.q.6
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
                        if (!TextUtils.isEmpty(((AlaGetAudioLiveStatusHttpResponseMessage) responsedMessage).bwl)) {
                            jSONObject = new JSONObject(alaGetAudioLiveStatusHttpResponseMessage.bwl);
                            jSONObject2 = jSONObject;
                            if (jSONObject2 == null) {
                                if (!"backstage_live".equals(jSONObject2.optString("content_type"))) {
                                    q.this.a(alaGetAudioLiveStatusHttpResponseMessage.bwl, jSONObject2, 12, false);
                                    return;
                                }
                                String optString = jSONObject2.optString("backstage_type");
                                if (!TextUtils.isEmpty(optString) && !optString.equals(q.this.bmh)) {
                                    q.this.a(alaGetAudioLiveStatusHttpResponseMessage.bwl, jSONObject2, 13, true);
                                    q.this.bmh = optString;
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
        this.bmG = new CustomMessageListener(2913192) { // from class: com.baidu.live.im.q.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText banlstn sd=" + q.this.aED);
                if (q.this.aED != null) {
                    if (q.this.aED.mLiveInfo.getUserID() == Long.valueOf(TbadkCoreApplication.getCurrentAccount()).longValue()) {
                        Log.i("i", "@@@ localText banlstn own");
                        if (q.this.aED.aJD != null && q.this.aED.mLiveInfo != null) {
                            Log.i("i", "@@@ localText banlstn own sdreq");
                            q.this.e(q.this.aED.aJD.userUk, q.this.aED.mLiveInfo.live_id);
                            return;
                        }
                        return;
                    }
                    Log.i("i", "@@@ localText banlstn oth");
                    if (q.this.aED.aJZ != null && q.this.aED.mLiveInfo != null) {
                        Log.i("i", "@@@ localText banlstn oth sdreq");
                        q.this.e(q.this.aED.aJZ.userUk, q.this.aED.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.bmH = new CustomMessageListener(2913185) { // from class: com.baidu.live.im.q.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                r rVar;
                if (q.this.bmq) {
                    if (q.this.bms == null) {
                        q.this.bms = new HashMap();
                    }
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r) && (rVar = (r) customResponsedMessage.getData()) != null && rVar.boP != null && rVar.boP.size() > 0) {
                        String a2 = com.baidu.live.utils.s.a(rVar.aZL, rVar.giftId, rVar.userId, rVar.boO);
                        for (r.a aVar2 : rVar.boP) {
                            com.baidu.live.im.data.b a3 = q.this.a(aVar2.giftId, aVar2.aYq, aVar2.count + "", aVar2.giftName, 0L, aVar2.boh, aVar2.boQ);
                            if (a3 != null) {
                                double m = q.this.m(a3);
                                a3.setMsgId(0L);
                                a3.setRecordId(0L);
                                com.baidu.live.data.a Lc = a3.Lc();
                                if (Lc != null && !StringUtils.isNull(Lc.userId) && !StringUtils.isNull(aVar2.giftId)) {
                                    aVar2.boe = a3;
                                    aVar2.bog = m;
                                } else {
                                    return;
                                }
                            }
                        }
                        if (!q.this.bms.containsKey(a2)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put(Long.valueOf(rVar.aYr), rVar);
                            q.this.bms.put(a2, hashMap);
                            return;
                        }
                        ((HashMap) q.this.bms.get(a2)).put(Long.valueOf(rVar.aYr), rVar);
                    }
                }
            }
        };
        this.bmI = new CustomMessageListener(2913184) { // from class: com.baidu.live.im.q.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof s)) {
                    s sVar = (s) customResponsedMessage.getData();
                    if (sVar.bon > 0) {
                        HashMap hashMap = (HashMap) q.this.bmr.get(sVar.beq);
                        if (hashMap != null && !hashMap.isEmpty()) {
                            r rVar = (r) hashMap.remove(Long.valueOf(sVar.bon));
                            if (rVar != null && rVar.boP != null && rVar.boP.size() > 0) {
                                rVar.boj = true;
                                while (true) {
                                    int i2 = i;
                                    if (i2 >= rVar.boP.size()) {
                                        break;
                                    }
                                    r.a aVar2 = rVar.boP.get(i2);
                                    aVar2.boe.setMsgType(24);
                                    aVar2.boe.aX(aVar2.count);
                                    aVar2.boe.h(aVar2.bog);
                                    aVar2.boe.bqK = aVar2.boQ;
                                    aVar2.boe.aY(aVar2.aXc);
                                    q.this.a(-1, aVar2.boe);
                                    if (q.this.boK != null) {
                                        q.this.boK.d(q.this.mMsgList, true);
                                    }
                                    i = i2 + 1;
                                }
                            }
                            if (hashMap.isEmpty()) {
                                q.this.bmr.remove(sVar.beq);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    HashMap hashMap2 = (HashMap) q.this.bms.get(sVar.beq);
                    if (hashMap2 != null && !hashMap2.isEmpty()) {
                        r rVar2 = (r) hashMap2.get(Long.valueOf(sVar.bop));
                        if (rVar2 != null && rVar2.boP != null && rVar2.boP.size() > 0) {
                            hashMap2.remove(Long.valueOf(sVar.bop));
                            while (true) {
                                int i3 = i;
                                if (i3 >= rVar2.boP.size()) {
                                    break;
                                }
                                r.a aVar3 = rVar2.boP.get(i3);
                                aVar3.boe.aX(aVar3.count);
                                aVar3.boe.h(aVar3.bog);
                                aVar3.boe.aY(aVar3.aXc);
                                aVar3.boe.bqK = aVar3.boQ;
                                q.this.a(-1, aVar3.boe);
                                if (q.this.boK != null) {
                                    q.this.boK.d(q.this.mMsgList, true);
                                }
                                long j = rVar2.bof;
                                if (j > 0) {
                                    q.this.g(j, aVar3.giftName);
                                }
                                i = i3 + 1;
                            }
                        }
                        if (hashMap2.isEmpty()) {
                            q.this.bms.remove(sVar.beq);
                        }
                    }
                }
            }
        };
        this.bmJ = new CustomMessageListener(2913183) { // from class: com.baidu.live.im.q.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof s)) {
                    s sVar = (s) customResponsedMessage.getData();
                    if (sVar.bon == 0) {
                        HashMap hashMap = (HashMap) q.this.bms.get(sVar.beq);
                        if (hashMap != null && !hashMap.isEmpty()) {
                            r rVar = (r) hashMap.get(Long.valueOf(sVar.bop));
                            r rVar2 = (r) hashMap.get(Long.valueOf(sVar.bos));
                            if (rVar != null && rVar2 != null) {
                                hashMap.remove(Long.valueOf(sVar.bos));
                                if (rVar.boP != null && rVar2.boP != null && rVar.boP.size() == rVar2.boP.size()) {
                                    rVar.bof += rVar2.bof;
                                    while (i < rVar.boP.size()) {
                                        rVar.boP.get(i).count += rVar2.boP.get(i).count;
                                        rVar.boP.get(i).aXc += rVar2.boP.get(i).aXc;
                                        if (rVar.boP.get(i).bog != rVar2.boP.get(i).bog) {
                                            rVar.boP.get(i).bog = 0.0d;
                                        }
                                        i++;
                                    }
                                    rVar.bok.add(Long.valueOf(rVar2.aYr));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    HashMap hashMap2 = (HashMap) q.this.bmr.get(sVar.beq);
                    if (hashMap2 != null && !hashMap2.isEmpty()) {
                        r rVar3 = (r) hashMap2.get(Long.valueOf(sVar.bon));
                        r rVar4 = (r) hashMap2.remove(Long.valueOf(sVar.boq));
                        if (rVar3 != null && rVar4 != null && rVar3.boP != null && rVar4.boP != null && rVar3.boP.size() == rVar4.boP.size()) {
                            while (i < rVar3.boP.size()) {
                                rVar3.boP.get(i).count += rVar4.boP.get(i).count;
                                rVar3.boP.get(i).aXc += rVar4.boP.get(i).aXc;
                                if (rVar3.boP.get(i).bog != rVar4.boP.get(i).bog) {
                                    rVar3.boP.get(i).bog = 0.0d;
                                }
                                i++;
                            }
                        }
                    }
                }
            }
        };
        this.bmK = new CustomMessageListener(2913195) { // from class: com.baidu.live.im.q.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                HashMap hashMap;
                r rVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof s)) {
                    s sVar = (s) customResponsedMessage.getData();
                    if (sVar.bon != 0 && (hashMap = (HashMap) q.this.bmr.get(sVar.beq)) != null && !hashMap.isEmpty() && (rVar = (r) hashMap.get(Long.valueOf(sVar.bon))) != null && rVar.boP != null) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < rVar.boP.size()) {
                                r.a aVar2 = rVar.boP.get(i2);
                                if (sVar.boR != null && sVar.boR.size() > i2) {
                                    aVar2.count = sVar.boR.get(i2).bot;
                                    aVar2.aXc = sVar.boR.get(i2).bou;
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
        this.bmL = new HttpMessageListener(1031054) { // from class: com.baidu.live.im.q.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                q.this.bml = false;
                Log.i("i", "@@@ localText gtibslist 1");
                q.this.mHandler.removeCallbacks(q.this.bmv);
                if (httpResponsedMessage != null) {
                    if (httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.im.message.c) && ((com.baidu.live.im.message.c) httpResponsedMessage.getOrginalMessage()).bb(System.currentTimeMillis())) {
                        Log.i("i", "@@@ localText gtibslist out");
                        q.this.bmm = false;
                        return;
                    }
                    Log.i("i", "@@@ localText gtibslist ta=" + q.this.bmm);
                    if (q.this.bmm) {
                        q.this.bmm = false;
                    } else if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        Log.i("i", "@@@ localText gtibslist err he=" + httpResponsedMessage.hasError() + ", err=" + httpResponsedMessage.getError());
                        YuyinImForbiddenStateData yuyinImForbiddenStateData = new YuyinImForbiddenStateData();
                        yuyinImForbiddenStateData.errno = httpResponsedMessage.getError();
                        yuyinImForbiddenStateData.errMsg = httpResponsedMessage.getErrorString();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, yuyinImForbiddenStateData));
                    } else {
                        Log.i("i", "@@@ localText gtibslist suc");
                        if (httpResponsedMessage instanceof YuyinAlaForbiddenWordsStateResponseMessage) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, ((YuyinAlaForbiddenWordsStateResponseMessage) httpResponsedMessage).brn));
                        }
                    }
                }
            }
        };
        if (com.baidu.live.ae.a.Qm().bwx.aOT != null) {
            this.boH = com.baidu.live.ae.a.Qm().bwx.aOT.aSK;
            this.boI = com.baidu.live.ae.a.Qm().bwx.aOT.aSL;
            this.boJ = com.baidu.live.ae.a.Qm().bwx.aOT.aSM;
        }
        this.blX = bdPageContext;
        this.blY = z;
        this.boK = aVar;
        this.mMsgList = new LinkedList<>();
        this.bmr = new LinkedHashMap<>();
        this.bms = new HashMap<>();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501043, Object.class);
        if (runTask != null && runTask.getData() != null) {
            this.bmq = true;
        }
        MessageManager.getInstance().registerTask(Ju());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031043, com.baidu.live.a.axj + "ala/audio/live/getLiveStatus");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGetAudioLiveStatusHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.live.tieba.f.a.a.a(1021012, "alaim/gmsg/getGroupMsg", ALAGroupHttpResponseMessage.class, false, true, true, true);
        JF();
        registerListener(this.bmL);
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

    public void g(long j, String str) {
        if (j == 0) {
            j = 1;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.blX.getString(a.h.sdk_gift);
        }
        com.baidu.live.im.data.b a2 = a((short) 27, String.format(this.blX.getString(a.h.sdk_send_gift_fail_yuyin), Long.valueOf(j), str), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), "", this.aKk);
        if (a2 != null) {
            a(-1, a2);
            if (this.boK != null) {
                this.boK.t(a2);
                this.boK.d(this.mMsgList, true);
            }
        }
    }

    public com.baidu.live.im.data.b a(String str, String str2, String str3, String str4, long j, boolean z, String str5) {
        return a((short) 24, a(str, str2, TextUtils.isEmpty(str3) ? "1" : str3, TextUtils.isEmpty(str4) ? this.blX.getString(a.h.sdk_gift) : str4, j, z).toString(), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), str5, this.aKk);
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
        if (this.boK != null) {
            this.boK.t(aVar);
            if (z) {
                this.boK.d(this.mMsgList, true);
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
            U(list);
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
        MessageManager.getInstance().registerListener(this.bmD);
        MessageManager.getInstance().registerListener(this.bmC);
        MessageManager.getInstance().registerListener(this.bmH);
        MessageManager.getInstance().registerListener(this.bmI);
        MessageManager.getInstance().registerListener(this.bmJ);
        MessageManager.getInstance().registerListener(this.bmK);
        MessageManager.getInstance().registerListener(this.bmG);
        MessageManager.getInstance().registerListener(this.boL);
        MessageManager.getInstance().registerListener(this.boM);
        if (BdSocketLinkService.isClose()) {
            Jw();
            BdSocketLinkService.startService(true, "live start");
        }
        if (com.baidu.live.ae.a.Qm().bwx != null && com.baidu.live.ae.a.Qm().bwx.aOT != null) {
            String str6 = com.baidu.live.ae.a.Qm().bwx.aOT.aSJ;
            if (!TextUtils.isEmpty(str6)) {
                com.baidu.live.im.data.b JE = JE();
                JE.setMsgType(27);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("text", str6);
                    jSONObject.put("content_type", "audio_custom_live_notice");
                    JE.setContent(jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                a(-1, JE);
                if (this.boK != null) {
                    this.boK.t(JE);
                }
            }
        }
        if (this.aED != null && this.aED.aKr != null && !StringUtils.isNull(this.aED.aKr.Bh())) {
            com.baidu.live.im.data.b JE2 = JE();
            JE2.setMsgType(27);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("text", this.aED.aKr.Bh());
                jSONObject2.put("content_type", "custom_live_notice");
                jSONObject2.put("category_msg_filter", "1");
                JE2.setContent(jSONObject2.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.mMsgList.add(JE2);
            if (this.boK != null) {
                this.boK.t(JE2);
            }
        }
        JB();
        if (this.mMsgList.size() > 0 && this.boK != null) {
            this.boK.d(this.mMsgList, true);
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGmsgGetLiveStatusUnabled()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.q.7
                @Override // java.lang.Runnable
                public void run() {
                    q.this.hd("enter");
                }
            }, 1000L);
        }
        Jv();
        if (TbadkCoreApplication.getInst().isOther()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913146, this.mMsgList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ky() {
        com.baidu.live.im.data.b JE;
        if (this.aED != null && this.aED.aKu != null && this.aED.aKu.aVs != null && !StringUtils.isNull(this.aED.aKu.aVs.content) && (JE = JE()) != null) {
            JE.setMsgType(27);
            try {
                JSONObject jSONObject = new JSONObject();
                String str = this.aED.aKu.aVs.content;
                String str2 = this.aED.aKu.aVs.title;
                jSONObject.put("text", str);
                jSONObject.put("room_id", this.aED.aKu.aVk);
                jSONObject.put(DpStatConstants.KEY_ROOM_NAME, this.aED.aKu.room_name);
                jSONObject.put("live_id", this.aED.aKu.live_id);
                jSONObject.put("cover", this.aED.aKu.cover);
                jSONObject.put("content_type", "play_rules");
                JE.setContent(jSONObject.toString());
                this.mMsgList.add(JE);
                if (this.mMsgList.size() > 0 && this.boK != null) {
                    this.boK.d(this.mMsgList, true);
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
            if (this.boK != null) {
                this.boK.t(JE);
            }
        }
    }

    private boolean JC() {
        return (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) || !TbadkCoreApplication.getCurrentAccount().equals(this.bmb) || com.baidu.live.ae.a.Qm().bwx == null || com.baidu.live.ae.a.Qm().bwx.aOC == null || TextUtils.isEmpty(com.baidu.live.ae.a.Qm().bwx.aOC.aJP)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(List<com.baidu.live.im.data.b> list) {
        if (list != null && this.boK != null) {
            this.boK.d(this.mMsgList, true);
            for (com.baidu.live.im.data.b bVar : list) {
                this.boK.t(bVar);
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
                        if (!TextUtils.isEmpty(optString) && (optString.equals("challenge_direct_start") || optString.equals("challenge_direct_matched") || optString.equals("challenge_random_start") || optString.equals("challenge_random_matched") || optString.equals("live_net_status") || optString.equals("send_redpacket") || optString.equals("start_grab_redpacket") || optString.equals("guard_seat") || optString.equals("challenge_mvp") || optString.equals("challenge_mvp_punish") || optString.equals("challenge_winner_by_autofail") || optString.equals("official_notice") || optString.equals("privilege_award_royal_success"))) {
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
        if (this.bmn < this.boH) {
            if (i >= 0) {
                this.mMsgList.add(i, bVar);
            } else {
                this.mMsgList.addLast(bVar);
            }
        } else if (this.bmn >= this.boH && this.bmn < this.boI) {
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
        } else if (this.bmn >= this.boI && this.bmn < this.boJ) {
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
        } else if (this.bmn >= this.boJ) {
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

    private void c(List<com.baidu.live.im.data.b> list, boolean z) {
        String str;
        JSONObject jSONObject;
        int optInt;
        String optString;
        LinkedList linkedList = new LinkedList();
        for (com.baidu.live.im.data.b bVar : list) {
            long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
            if (!ListUtils.isEmpty(bVar.Le()) && !bVar.Le().contains(Long.valueOf(currentAccountId))) {
                linkedList.add(bVar);
            } else {
                boolean z2 = bVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                if (z2 && bVar.getMsgType() == 1 && !ListUtils.isEmpty(bVar.Lc().aHz) && this.aKk == null) {
                    this.aKk = bVar.Lc().aHz;
                }
                if (z2 && bVar.getMsgType() != 125 && bVar.getMsgType() != 24 && bVar.getMsgType() != 13 && bVar.getMsgType() != 28 && (bVar.getMsgType() != 1 || !z)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(bVar.getContent());
                        optInt = jSONObject2.optInt("close_audio_room");
                        optString = jSONObject2.optString("content_type");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (optInt != 1 || !"close_live".equals(optString)) {
                        if (!"play_rules".equals(optString)) {
                            linkedList.add(bVar);
                        }
                    }
                } else if (bVar.getMsgType() == 125) {
                    try {
                        if (!"1".equals(new JSONObject(bVar.getContent()).optString("is_first"))) {
                            linkedList.add(bVar);
                            if (this.boK != null) {
                                this.boK.t(bVar);
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
                    if (!"enter_live".equals(str)) {
                        if ("close_live".equals(str)) {
                            linkedList.add(bVar);
                            if (this.boK != null) {
                                this.boK.t(bVar);
                            }
                        } else if ("task".equals(str)) {
                            linkedList.add(bVar);
                            if (this.boK != null) {
                                this.boK.t(bVar);
                            }
                        } else if ("live_achievement".equals(str)) {
                            linkedList.add(bVar);
                            if (this.boK != null) {
                                this.boK.t(bVar);
                            }
                        } else if ("ss_hot_live".equals(str)) {
                            linkedList.add(bVar);
                            if (this.boK != null) {
                                this.boK.t(bVar);
                            }
                        } else if ("challenge_direct_new".equals(str)) {
                            linkedList.add(bVar);
                            if (this.boK != null) {
                                this.boK.t(bVar);
                            }
                        } else if ("challenge_random_cancel".equals(str)) {
                            linkedList.add(bVar);
                            if (this.boK != null) {
                                this.boK.t(bVar);
                            }
                        } else if ("update_liveinfo".equals(str)) {
                            linkedList.add(bVar);
                            if (this.boK != null) {
                                this.boK.t(bVar);
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
                            if (z2 && !ListUtils.isEmpty(bVar.Lc().aHz)) {
                                this.aKk = bVar.Lc().aHz;
                                if (this.aED != null) {
                                    this.aED.aKk = this.aKk;
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
                            } else if (TextUtils.equals(str, "challenge_winner_by_autofail")) {
                                Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                            } else if (TextUtils.equals(str, "wish_list_finish") || TextUtils.equals(str, "wish_list_success")) {
                                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                                    linkedList.add(bVar);
                                }
                            } else if ("ui_event".equals(str)) {
                                linkedList.add(bVar);
                                if (this.boK != null) {
                                    this.boK.t(bVar);
                                }
                            } else if ("introduce_goods".equals(str)) {
                                linkedList.add(bVar);
                                if (this.boK != null) {
                                    this.boK.t(bVar);
                                }
                            } else if ("first_recharge_success".equals(str)) {
                                linkedList.add(bVar);
                                if (this.boK != null) {
                                    this.boK.t(bVar);
                                }
                            } else if ("privilege_award_success".equals(str)) {
                                linkedList.add(bVar);
                                if (this.boK != null) {
                                    this.boK.t(bVar);
                                }
                            } else if ("need_update_live_mark_info".equals(str)) {
                                linkedList.add(bVar);
                                if (this.boK != null) {
                                    this.boK.t(bVar);
                                }
                            } else if ("official_notice".equals(str)) {
                                linkedList.add(bVar);
                            } else if (TextUtils.equals(str, "privilege_award_royal_success")) {
                                Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                            } else if (TextUtils.equals(str, "add_tags_to_anchor")) {
                                Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                            } else if (TextUtils.equals(str, "audio_emoticon")) {
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
                                } else if (!TextUtils.equals(str, "audio_low_version_toast") && !TextUtils.equals(str, "live_audio_audit_notice")) {
                                    if (TextUtils.equals(str, "sync_audio_speeker_status")) {
                                        w(bVar);
                                        linkedList.add(bVar);
                                    } else if (!TextUtils.equals(str, "audio_hat_level_toast") && !TextUtils.equals(str, "audio_hat_user_toast") && !TextUtils.equals(str, "audio_loot_gift")) {
                                        if (TextUtils.equals(str, "switch_activity_stage")) {
                                            x(bVar);
                                            linkedList.add(bVar);
                                        } else if (TextUtils.equals(str, "audio_live_new_phone_frame")) {
                                            A(bVar);
                                            linkedList.add(bVar);
                                        } else if (TextUtils.equals(str, "audio_link_online")) {
                                            B(bVar);
                                            linkedList.add(bVar);
                                        } else if (!TextUtils.equals(str, "mode_change_stage") && !TextUtils.equals(str, "mode_add_time") && !TextUtils.equals(str, "play_rules")) {
                                            if (TextUtils.equals(str, "audio_common_toast_msg")) {
                                                u(bVar);
                                                linkedList.add(bVar);
                                            } else if (TextUtils.equals(str, "gift_combo_end")) {
                                                linkedList.add(bVar);
                                                v(bVar);
                                                if (this.boK != null) {
                                                    this.boK.t(bVar);
                                                }
                                            } else {
                                                linkedList.add(bVar);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (bVar.getMsgType() == 12) {
                    linkedList.add(bVar);
                    if (this.boK != null) {
                        this.boK.t(bVar);
                    }
                    hd("push");
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
                BdUtilHelper.showToast(this.blX.getPageActivity(), optString);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected com.baidu.live.im.data.b a(short s, String str, boolean z, boolean z2, int i, String str2, List<AlaLiveMarkData> list) {
        long j = 0;
        com.baidu.live.im.data.b JE = JE();
        if (JE == null) {
            return null;
        }
        JE.setMsgType(s);
        JE.setContent(str);
        long aW = o.aW(getLastMid());
        JE.bqK = str2;
        JE.setMsgId(aW);
        JE.setRecordId(aW);
        JE.setTime(System.currentTimeMillis() / 1000);
        com.baidu.live.data.a aVar = new com.baidu.live.data.a();
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            aVar.userName = TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow();
        }
        aVar.userId = TbadkCoreApplication.getCurrentAccount();
        aVar.portrait = TbadkCoreApplication.getCurrentPortrait();
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
        com.baidu.live.message.b bVar = new com.baidu.live.message.b(JavaTypesHelper.toLong(this.mLiveId, 0L), str);
        bVar.setParams();
        sendMessage(bVar);
    }

    public void he(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.bmh)) {
            hd("getliveinfo");
        }
    }

    private List<com.baidu.live.im.data.b> r(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        int optInt;
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
            com.baidu.live.gift.g gt = ac.gt(jSONObject.optString(LogConfig.LOG_GIFT_ID));
            Ee = gt != null ? gt.Ee() : false;
        } catch (JSONException e) {
            arrayList.add(aVar);
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
        return arrayList;
    }

    public void a(int i, String str, com.baidu.live.data.a aVar) {
        com.baidu.live.im.data.b JE = JE();
        if (JE != null) {
            JE.setMsgType(i);
            JE.setContent(str);
            JE.e(aVar);
            a(-1, JE);
            if (this.boK != null) {
                this.boK.d(this.mMsgList, true);
                this.boK.t(JE);
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
        com.baidu.live.data.a Lc = bVar.Lc();
        String str = Lc.userId;
        Lc.getNameShow();
        String a2 = com.baidu.live.utils.s.a(optLong, optString, str, bVar.boO);
        if (this.bmr == null) {
            this.bmr = new LinkedHashMap<>();
        }
        long j = JavaTypesHelper.toLong(jSONObject.optString("gift_count"), 0L);
        double optDouble = jSONObject.optDouble("gift_rate", 0.0d);
        long j2 = JavaTypesHelper.toLong(jSONObject.optString("charm_value"), 0L);
        jSONObject.optString("gift_url");
        jSONObject.optString("gift_name");
        r rVar = new r();
        rVar.boP = new ArrayList();
        rVar.giftId = optString;
        rVar.aZL = optLong;
        rVar.boO = bVar.boO;
        for (s.a aVar : com.baidu.live.utils.s.il(bVar.boO)) {
            r.a aVar2 = new r.a();
            aVar2.boe = bVar.clone();
            aVar2.boe.setMsgType(24);
            aVar2.bog = optDouble;
            aVar2.count = j;
            aVar2.boQ = aVar.name;
            aVar2.aXc = j2;
            rVar.boP.add(aVar2);
        }
        Iterator<String> it = this.bmr.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (this.bmr.get(next) == null || this.bmr.get(next).isEmpty()) {
                it.remove();
            } else {
                HashMap<Long, r> hashMap = this.bmr.get(next);
                Iterator<Long> it2 = hashMap.keySet().iterator();
                while (it2.hasNext()) {
                    long longValue = it2.next().longValue();
                    if (hashMap.get(Long.valueOf(longValue)) == null || hashMap.get(Long.valueOf(longValue)).boj) {
                        it2.remove();
                    }
                }
                if (this.bmr.get(next) == null || this.bmr.get(next).isEmpty()) {
                    it.remove();
                }
            }
        }
        if (!this.bmr.containsKey(a2)) {
            HashMap<Long, r> hashMap2 = new HashMap<>();
            hashMap2.put(Long.valueOf(bVar.getMsgId()), rVar);
            this.bmr.put(a2, hashMap2);
            return;
        }
        this.bmr.get(a2).put(Long.valueOf(bVar.getMsgId()), rVar);
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
                                String str = Lc.userId;
                                Lc.getNameShow();
                                String a2 = com.baidu.live.utils.s.a(0L, optString, str, bVar.boO);
                                if (this.bmr == null) {
                                    this.bmr = new LinkedHashMap<>();
                                }
                                long j = JavaTypesHelper.toLong(jSONObject.optString("gift_count"), 0L);
                                double optDouble = jSONObject.optDouble("gift_rate", 0.0d);
                                long j2 = JavaTypesHelper.toLong(jSONObject.optString("charm_value"), 0L);
                                jSONObject.optString("gift_url");
                                jSONObject.optString("gift_name");
                                long optLong = jSONObject.optLong("combo_groupid");
                                r rVar = new r();
                                rVar.boP = new ArrayList();
                                rVar.giftId = optString;
                                rVar.aZL = optLong;
                                rVar.boO = bVar.boO;
                                for (s.a aVar : com.baidu.live.utils.s.il(bVar.boO)) {
                                    r.a aVar2 = new r.a();
                                    aVar2.boe = bVar.clone();
                                    aVar2.bog = optDouble;
                                    aVar2.count = j;
                                    aVar2.boQ = aVar.name;
                                    aVar2.aXc = j2;
                                    rVar.boP.add(aVar2);
                                }
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
                                        HashMap<Long, r> hashMap = this.bmr.get(next);
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
                                if (!this.bmr.containsKey(a2)) {
                                    HashMap<Long, r> hashMap2 = new HashMap<>();
                                    hashMap2.put(Long.valueOf(bVar.getMsgId()), rVar);
                                    this.bmr.put(a2, hashMap2);
                                } else {
                                    this.bmr.get(a2).put(Long.valueOf(bVar.getMsgId()), rVar);
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
            HashMap<Long, r> hashMap = this.bms.get(a2);
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
                            if (next.bok.contains(l)) {
                                rVar = next;
                                break;
                            }
                        }
                    }
                    if (rVar != null) {
                        long longValue = map.get(l).longValue();
                        if (z) {
                            rVar.bof = longValue + rVar.bof;
                        }
                        if (rVar.boj) {
                            hashMap.remove(Long.valueOf(rVar.aYr));
                            for (r.a aVar : rVar.boP) {
                                aVar.boe.aX(aVar.count);
                                aVar.boe.h(aVar.bog);
                                aVar.boe.aY(aVar.aXc);
                                a(-1, aVar.boe);
                                if (this.boK != null) {
                                    this.boK.d(this.mMsgList, true);
                                }
                                long j4 = rVar.bof;
                                if (j4 > 0) {
                                    g(j4, aVar.giftName);
                                }
                            }
                        }
                    }
                }
                if (hashMap.isEmpty()) {
                    this.bms.remove(a2);
                }
            }
        }
    }

    public void zU() {
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
        MessageManager.getInstance().unRegisterListener(this.bmC);
        MessageManager.getInstance().unRegisterListener(this.bmD);
        MessageManager.getInstance().unRegisterListener(this.bmx);
        MessageManager.getInstance().unRegisterListener(this.bmH);
        MessageManager.getInstance().unRegisterListener(this.bmI);
        MessageManager.getInstance().unRegisterListener(this.bmJ);
        MessageManager.getInstance().unRegisterListener(this.bmK);
        MessageManager.getInstance().unRegisterListener(this.bmG);
        MessageManager.getInstance().unRegisterListener(this.boL);
        MessageManager.getInstance().unRegisterListener(this.boM);
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
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031054, com.baidu.live.a.axj + "ala/audio/user/judgeBan");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(YuyinAlaForbiddenWordsStateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(ImSendMsgData imSendMsgData, boolean z, boolean z2, int i, String str, String[] strArr) {
        Log.i("i", "@@@ localText limmdl sm");
        if (!TbadkCoreApplication.isLogin()) {
            BdUtilHelper.showToast(this.blX.getPageActivity(), a.h.sdk_not_login);
        } else if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow())) {
            BdUtilHelper.showToast(this.blX.getPageActivity(), a.h.sdk_username_empty);
        } else {
            Log.i("i", "@@@ localText limmdl sm 1");
            String str2 = imSendMsgData.text;
            short s = imSendMsgData.msgType;
            com.baidu.live.im.data.b a2 = a(s, str2, z, z2, i, "", this.aKk);
            if (s == 126) {
                a2.dD(imSendMsgData.barrageType);
                a2.hn(imSendMsgData.barrageId);
                a2.a(imSendMsgData.barrageCardInfo);
            }
            Log.i("i", "@@@ localText limmdl sm cm=" + a2);
            if (a2 != null) {
                a2.l(strArr);
                a(-1, a2);
                if (this.boK != null) {
                    Log.i("i", "@@@ localText limmdl sm recv");
                    this.boK.t(a2);
                    this.boK.d(this.mMsgList, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913043));
                com.baidu.live.im.message.a aVar = new com.baidu.live.im.message.a(str2, s, JavaTypesHelper.toInt(this.mGroupId, 0), this.mAppId);
                if (this.aED != null && this.aED.mLiveInfo != null && this.aED.aKu != null) {
                    aVar.setLiveId(this.aED.mLiveInfo.live_id + "");
                    aVar.setRoomId(this.aED.mLiveInfo.room_id + "");
                    aVar.dE(1);
                    aVar.setCustomRoomId(this.aED.aKu.croom_id);
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
                sendMessage(aVar);
            }
        }
    }

    public void e(String str, long j) {
        Log.i("i", "@@@ localText limm sdreq uk=" + str + ",lvd=" + j + ",iibr=" + this.bml);
        if (!this.bml) {
            this.bml = true;
            Log.i("i", "@@@ localText limm sdreq go");
            com.baidu.live.im.message.c cVar = new com.baidu.live.im.message.c(1031054);
            cVar.addParam("uk", str);
            cVar.addParam("live_id", j);
            cVar.ba(System.currentTimeMillis());
            sendMessage(cVar);
            this.mHandler.postDelayed(this.bmv, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JG() {
        Log.i("i", "@@@ localText limm sdreq out");
        this.bml = false;
        this.bmm = true;
        YuyinImForbiddenStateData yuyinImForbiddenStateData = new YuyinImForbiddenStateData();
        yuyinImForbiddenStateData.errno = -1;
        yuyinImForbiddenStateData.errMsg = this.blX.getString(a.h.sdk_neterror);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, yuyinImForbiddenStateData));
    }

    private void U(List<com.baidu.live.im.data.b> list) {
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
                                bVar.boO = jSONObject.optString("benefit_info");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (bVar.getMsgType() == 24) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(bVar.getContent());
                            if (jSONObject2 != null) {
                                bVar.boO = jSONObject2.optString("benefit_info");
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private void w(com.baidu.live.im.data.b bVar) {
        if (!StringUtils.isNull(bVar.getContent(), true)) {
            if (!com.baidu.live.ao.a.Ym().iN(com.baidu.live.ao.a.Ym().Ys()) && !com.baidu.live.ao.a.Ym().Yn()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501026, bVar.getContent()));
                return;
            }
            try {
                if (new JSONObject(bVar.getContent()).optInt("open_rtc_mode", 0) != 1) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501026, bVar.getContent()));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void x(com.baidu.live.im.data.b bVar) {
        boolean z = false;
        try {
            if (y(bVar) == 2) {
                BdUtilHelper.showToast(DBResource.getContext(), "无成功匹配，本轮约会结束");
                z = true;
            }
            if (!z && z(bVar) == 0) {
                BdUtilHelper.showToast(DBResource.getContext(), "本轮约会结束");
            }
        } catch (Exception e) {
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
    }

    private int y(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        try {
            if (bVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) bVar.getObjContent();
            } else {
                jSONObject = new JSONObject(bVar.getContent());
            }
            return jSONObject.optInt("confession");
        } catch (JSONException e) {
            return -1;
        }
    }

    private int z(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        try {
            if (bVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) bVar.getObjContent();
            } else {
                jSONObject = new JSONObject(bVar.getContent());
            }
            return jSONObject.optInt("activity_stage");
        } catch (JSONException e) {
            return -1;
        }
    }

    private void A(com.baidu.live.im.data.b bVar) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501084, bVar.clone()));
    }

    private void B(com.baidu.live.im.data.b bVar) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
    }
}
