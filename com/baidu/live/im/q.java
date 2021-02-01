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
/* loaded from: classes11.dex */
public class q extends BdBaseModel {
    private ab aDd;
    private List<AlaLiveMarkData> aIK;
    private String bkA;
    private String bkB;
    private List<com.baidu.live.im.data.b> bkC;
    private int bkD;
    private int bkE;
    private int bkF;
    private float bkG;
    private String bkH;
    private boolean bkL;
    private boolean bkM;
    private int bkN;
    private int bkO;
    private boolean bkP;
    private LinkedHashMap<String, HashMap<Long, r>> bkQ;
    private HashMap<String, HashMap<Long, r>> bkR;
    private b.a bkS;
    private Runnable bkT;
    private Runnable bkU;
    private CustomMessageListener bkV;
    private CustomMessageListener bkW;
    private Runnable bkX;
    private HttpMessageListener bkY;
    private HttpMessageListener bkZ;
    BdPageContext<?> bkx;
    private boolean bky;
    private HttpMessageListener blb;
    private HttpMessageListener blc;
    private HttpMessageListener bld;
    private NetMessageListener ble;
    CustomMessageListener blf;
    CustomMessageListener blg;
    CustomMessageListener blh;
    CustomMessageListener bli;
    CustomMessageListener blj;
    private HttpMessageListener blk;
    public long bnh;
    public long bni;
    public long bnj;
    private a bnk;
    private CustomMessageListener bnl;
    private CustomMessageListener bnm;
    private long count;
    private String mAppId;
    private String mGroupId;
    private Handler mHandler;
    private String mLiveId;
    private LinkedList<com.baidu.live.im.data.b> mMsgList;

    /* loaded from: classes11.dex */
    public interface a {
        void JE();

        void d(List<com.baidu.live.im.data.b> list, boolean z);

        void t(com.baidu.live.im.data.b bVar);
    }

    static /* synthetic */ int h(q qVar) {
        int i = qVar.bkF;
        qVar.bkF = i + 1;
        return i;
    }

    public q(BdPageContext<?> bdPageContext, boolean z, a aVar) {
        super(bdPageContext);
        this.bnh = 100L;
        this.bni = 200L;
        this.bnj = 5000L;
        this.mLiveId = null;
        this.bkG = 1.0f;
        this.mHandler = new Handler();
        this.bkH = null;
        this.bkL = false;
        this.bkM = false;
        this.bkO = 0;
        this.bkP = false;
        this.bkS = new b.a() { // from class: com.baidu.live.im.q.1
        };
        this.bkT = new Runnable() { // from class: com.baidu.live.im.q.12
            @Override // java.lang.Runnable
            public void run() {
                int i = q.this.bkF * q.this.bkD;
                if (i >= q.this.bkC.size()) {
                    q.this.JA();
                } else if (q.this.bkF >= q.this.bkE - 1) {
                    if (q.this.bkF != q.this.bkE - 1) {
                        q.this.JA();
                        return;
                    }
                    ArrayList arrayList = new ArrayList(q.this.bkC);
                    q.this.O(q.this.b(arrayList.subList(i, arrayList.size()), true));
                    q.h(q.this);
                    q.this.JA();
                } else {
                    ArrayList arrayList2 = new ArrayList(q.this.bkC);
                    if (q.this.bkD + i <= arrayList2.size()) {
                        q.this.O(q.this.b(arrayList2.subList(i, q.this.bkD + i), true));
                        q.h(q.this);
                        q.this.mHandler.postDelayed(q.this.bkT, 250L);
                        return;
                    }
                    q.this.O(q.this.b(arrayList2.subList(i, arrayList2.size()), true));
                    q.h(q.this);
                    q.this.JA();
                }
            }
        };
        this.bkU = new Runnable() { // from class: com.baidu.live.im.q.15
            @Override // java.lang.Runnable
            public void run() {
                q.this.JD();
            }
        };
        this.bkV = new CustomMessageListener(MessageConfig.SOCKET_RECEIVE_MSG) { // from class: com.baidu.live.im.q.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                q.this.Ju();
            }
        };
        this.bkW = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.live.im.q.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        com.baidu.live.im.a aVar2 = new com.baidu.live.im.a();
                        aVar2.setMsgType(27);
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("text", q.this.bkx.getString(a.h.sdk_im_offline));
                            jSONObject.put("content_type", "custom_network_change");
                            aVar2.setContent(jSONObject.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        q.this.a(-1, aVar2);
                        if (q.this.bnk != null) {
                            q.this.bnk.t(aVar2);
                            q.this.bnk.d(q.this.mMsgList, true);
                        }
                    } else if (((NetWorkChangedMessage) customResponsedMessage).mLastNetState == 0 && BdNetTypeUtil.isNetWorkAvailable()) {
                        com.baidu.live.im.a aVar3 = new com.baidu.live.im.a();
                        aVar3.setMsgType(27);
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("text", q.this.bkx.getString(a.h.sdk_im_online));
                            jSONObject2.put("content_type", "custom_network_change");
                            aVar3.setContent(jSONObject2.toString());
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        q.this.a(-1, aVar3);
                        if (q.this.bnk != null) {
                            q.this.bnk.t(aVar3);
                            q.this.bnk.d(q.this.mMsgList, true);
                        }
                    }
                }
            }
        };
        this.bkX = new Runnable() { // from class: com.baidu.live.im.q.18
            @Override // java.lang.Runnable
            public void run() {
                if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().getLastReceDataTime() > 35000) {
                    q.this.Jt();
                }
                q.this.Js();
            }
        };
        this.bnl = new CustomMessageListener(2501072) { // from class: com.baidu.live.im.q.19
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b)) {
                    com.baidu.live.im.data.b bVar = (com.baidu.live.im.data.b) customResponsedMessage.getData();
                    q.this.a(-1, bVar);
                    if (q.this.bnk != null) {
                        q.this.bnk.d(q.this.mMsgList, true);
                        q.this.bnk.t(bVar);
                    }
                }
            }
        };
        this.bnm = new CustomMessageListener(2501085) { // from class: com.baidu.live.im.q.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                q.this.Kv();
            }
        };
        this.bkY = new HttpMessageListener(1021013) { // from class: com.baidu.live.im.q.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    boolean z2 = false;
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        int error = httpResponsedMessage.getError();
                        if (com.baidu.live.ae.a.Qj().buX.aNf == 1) {
                            if (error == 149010) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913070, q.this.bkx.getPageActivity().getString(a.h.im_improper_content_tip)));
                                z2 = true;
                            } else if (error == 1202 || error == 1203) {
                                BdUtilHelper.showToast(q.this.bkx.getPageActivity(), q.this.bkx.getPageActivity().getString(a.h.im_improper_content_tip_net));
                                z2 = true;
                            } else if (error == 1204) {
                                BdUtilHelper.showToast(q.this.bkx.getPageActivity(), q.this.bkx.getPageActivity().getString(a.h.im_improper_content_tip));
                                z2 = true;
                            }
                        }
                    }
                    if (!z2 && q.this.bnk != null) {
                        q.this.bnk.JE();
                    }
                }
            }
        };
        this.bkZ = new HttpMessageListener(1031055) { // from class: com.baidu.live.im.q.2
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
                            if (!q.this.bkP) {
                                q.this.g(anVar.aWN, anVar.giftName);
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                        }
                        if (q.this.bkP) {
                            q.this.a(anVar.giftId, anVar.aYl, anVar.aWN, anVar.aWR, anVar.aYm, z2, anVar.aWT);
                        }
                    }
                }
            }
        };
        this.blb = new HttpMessageListener(1031056) { // from class: com.baidu.live.im.q.3
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
                            if (!q.this.bkP) {
                                q.this.g(apVar.aWN, apVar.giftName);
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                        }
                        if (q.this.bkP) {
                            q.this.a(apVar.giftId, apVar.aWN, apVar.aYl, apVar.aWR, apVar.aYm, z2, apVar.aWT);
                        }
                    }
                }
            }
        };
        this.blc = new HttpMessageListener(1031057) { // from class: com.baidu.live.im.q.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                boolean z2;
                boolean z3;
                if (httpResponsedMessage != null) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof aq) {
                        aq aqVar = (aq) orginalMessage;
                        if ((httpResponsedMessage instanceof YuyinGiftPackageConsumeHttpResponsedMessage) && TextUtils.isEmpty(((YuyinGiftPackageConsumeHttpResponsedMessage) httpResponsedMessage).aXU)) {
                            if (!q.this.bkP) {
                                q.this.g(aqVar.aXz, aqVar.giftName);
                            }
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            if (!q.this.bkP) {
                                q.this.g(aqVar.aXz, aqVar.giftName);
                            }
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (q.this.bkP) {
                            q.this.a(aqVar.giftId, aqVar.aYl, aqVar.aXz, aqVar.aWR, aqVar.aYn, z3, aqVar.aWT);
                        }
                    }
                }
            }
        };
        this.bld = new HttpMessageListener(1021012) { // from class: com.baidu.live.im.q.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                q.this.a((ResponsedMessage<?>) httpResponsedMessage, false);
            }
        };
        this.ble = new NetMessageListener(1031043, 601008) { // from class: com.baidu.live.im.q.6
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
                        if (!TextUtils.isEmpty(((AlaGetAudioLiveStatusHttpResponseMessage) responsedMessage).buL)) {
                            jSONObject = new JSONObject(alaGetAudioLiveStatusHttpResponseMessage.buL);
                            jSONObject2 = jSONObject;
                            if (jSONObject2 == null) {
                                if (!"backstage_live".equals(jSONObject2.optString("content_type"))) {
                                    q.this.a(alaGetAudioLiveStatusHttpResponseMessage.buL, jSONObject2, 12, false);
                                    return;
                                }
                                String optString = jSONObject2.optString("backstage_type");
                                if (!TextUtils.isEmpty(optString) && !optString.equals(q.this.bkH)) {
                                    q.this.a(alaGetAudioLiveStatusHttpResponseMessage.buL, jSONObject2, 13, true);
                                    q.this.bkH = optString;
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
        this.blf = new CustomMessageListener(2913192) { // from class: com.baidu.live.im.q.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText banlstn sd=" + q.this.aDd);
                if (q.this.aDd != null) {
                    if (q.this.aDd.mLiveInfo.getUserID() == Long.valueOf(TbadkCoreApplication.getCurrentAccount()).longValue()) {
                        Log.i("i", "@@@ localText banlstn own");
                        if (q.this.aDd.aId != null && q.this.aDd.mLiveInfo != null) {
                            Log.i("i", "@@@ localText banlstn own sdreq");
                            q.this.e(q.this.aDd.aId.userUk, q.this.aDd.mLiveInfo.live_id);
                            return;
                        }
                        return;
                    }
                    Log.i("i", "@@@ localText banlstn oth");
                    if (q.this.aDd.aIz != null && q.this.aDd.mLiveInfo != null) {
                        Log.i("i", "@@@ localText banlstn oth sdreq");
                        q.this.e(q.this.aDd.aIz.userUk, q.this.aDd.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.blg = new CustomMessageListener(2913185) { // from class: com.baidu.live.im.q.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                r rVar;
                if (q.this.bkP) {
                    if (q.this.bkR == null) {
                        q.this.bkR = new HashMap();
                    }
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r) && (rVar = (r) customResponsedMessage.getData()) != null && rVar.bnp != null && rVar.bnp.size() > 0) {
                        String a2 = com.baidu.live.utils.s.a(rVar.aYl, rVar.giftId, rVar.userId, rVar.bno);
                        for (r.a aVar2 : rVar.bnp) {
                            com.baidu.live.im.data.b a3 = q.this.a(aVar2.giftId, aVar2.aWQ, aVar2.count + "", aVar2.giftName, 0L, aVar2.bmH, aVar2.bnq);
                            if (a3 != null) {
                                double m = q.this.m(a3);
                                a3.setMsgId(0L);
                                a3.setRecordId(0L);
                                com.baidu.live.data.a KZ = a3.KZ();
                                if (KZ != null && !StringUtils.isNull(KZ.userId) && !StringUtils.isNull(aVar2.giftId)) {
                                    aVar2.bmE = a3;
                                    aVar2.bmG = m;
                                } else {
                                    return;
                                }
                            }
                        }
                        if (!q.this.bkR.containsKey(a2)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put(Long.valueOf(rVar.aWR), rVar);
                            q.this.bkR.put(a2, hashMap);
                            return;
                        }
                        ((HashMap) q.this.bkR.get(a2)).put(Long.valueOf(rVar.aWR), rVar);
                    }
                }
            }
        };
        this.blh = new CustomMessageListener(2913184) { // from class: com.baidu.live.im.q.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof s)) {
                    s sVar = (s) customResponsedMessage.getData();
                    if (sVar.bmN > 0) {
                        HashMap hashMap = (HashMap) q.this.bkQ.get(sVar.bcP);
                        if (hashMap != null && !hashMap.isEmpty()) {
                            r rVar = (r) hashMap.remove(Long.valueOf(sVar.bmN));
                            if (rVar != null && rVar.bnp != null && rVar.bnp.size() > 0) {
                                rVar.bmJ = true;
                                while (true) {
                                    int i2 = i;
                                    if (i2 >= rVar.bnp.size()) {
                                        break;
                                    }
                                    r.a aVar2 = rVar.bnp.get(i2);
                                    aVar2.bmE.setMsgType(24);
                                    aVar2.bmE.aX(aVar2.count);
                                    aVar2.bmE.h(aVar2.bmG);
                                    aVar2.bmE.bpk = aVar2.bnq;
                                    aVar2.bmE.aY(aVar2.aVC);
                                    q.this.a(-1, aVar2.bmE);
                                    if (q.this.bnk != null) {
                                        q.this.bnk.d(q.this.mMsgList, true);
                                    }
                                    i = i2 + 1;
                                }
                            }
                            if (hashMap.isEmpty()) {
                                q.this.bkQ.remove(sVar.bcP);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    HashMap hashMap2 = (HashMap) q.this.bkR.get(sVar.bcP);
                    if (hashMap2 != null && !hashMap2.isEmpty()) {
                        r rVar2 = (r) hashMap2.get(Long.valueOf(sVar.bmP));
                        if (rVar2 != null && rVar2.bnp != null && rVar2.bnp.size() > 0) {
                            hashMap2.remove(Long.valueOf(sVar.bmP));
                            while (true) {
                                int i3 = i;
                                if (i3 >= rVar2.bnp.size()) {
                                    break;
                                }
                                r.a aVar3 = rVar2.bnp.get(i3);
                                aVar3.bmE.aX(aVar3.count);
                                aVar3.bmE.h(aVar3.bmG);
                                aVar3.bmE.aY(aVar3.aVC);
                                aVar3.bmE.bpk = aVar3.bnq;
                                q.this.a(-1, aVar3.bmE);
                                if (q.this.bnk != null) {
                                    q.this.bnk.d(q.this.mMsgList, true);
                                }
                                long j = rVar2.bmF;
                                if (j > 0) {
                                    q.this.g(j, aVar3.giftName);
                                }
                                i = i3 + 1;
                            }
                        }
                        if (hashMap2.isEmpty()) {
                            q.this.bkR.remove(sVar.bcP);
                        }
                    }
                }
            }
        };
        this.bli = new CustomMessageListener(2913183) { // from class: com.baidu.live.im.q.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof s)) {
                    s sVar = (s) customResponsedMessage.getData();
                    if (sVar.bmN == 0) {
                        HashMap hashMap = (HashMap) q.this.bkR.get(sVar.bcP);
                        if (hashMap != null && !hashMap.isEmpty()) {
                            r rVar = (r) hashMap.get(Long.valueOf(sVar.bmP));
                            r rVar2 = (r) hashMap.get(Long.valueOf(sVar.bmS));
                            if (rVar != null && rVar2 != null) {
                                hashMap.remove(Long.valueOf(sVar.bmS));
                                if (rVar.bnp != null && rVar2.bnp != null && rVar.bnp.size() == rVar2.bnp.size()) {
                                    rVar.bmF += rVar2.bmF;
                                    while (i < rVar.bnp.size()) {
                                        rVar.bnp.get(i).count += rVar2.bnp.get(i).count;
                                        rVar.bnp.get(i).aVC += rVar2.bnp.get(i).aVC;
                                        if (rVar.bnp.get(i).bmG != rVar2.bnp.get(i).bmG) {
                                            rVar.bnp.get(i).bmG = 0.0d;
                                        }
                                        i++;
                                    }
                                    rVar.bmK.add(Long.valueOf(rVar2.aWR));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    HashMap hashMap2 = (HashMap) q.this.bkQ.get(sVar.bcP);
                    if (hashMap2 != null && !hashMap2.isEmpty()) {
                        r rVar3 = (r) hashMap2.get(Long.valueOf(sVar.bmN));
                        r rVar4 = (r) hashMap2.remove(Long.valueOf(sVar.bmQ));
                        if (rVar3 != null && rVar4 != null && rVar3.bnp != null && rVar4.bnp != null && rVar3.bnp.size() == rVar4.bnp.size()) {
                            while (i < rVar3.bnp.size()) {
                                rVar3.bnp.get(i).count += rVar4.bnp.get(i).count;
                                rVar3.bnp.get(i).aVC += rVar4.bnp.get(i).aVC;
                                if (rVar3.bnp.get(i).bmG != rVar4.bnp.get(i).bmG) {
                                    rVar3.bnp.get(i).bmG = 0.0d;
                                }
                                i++;
                            }
                        }
                    }
                }
            }
        };
        this.blj = new CustomMessageListener(2913195) { // from class: com.baidu.live.im.q.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                HashMap hashMap;
                r rVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof s)) {
                    s sVar = (s) customResponsedMessage.getData();
                    if (sVar.bmN != 0 && (hashMap = (HashMap) q.this.bkQ.get(sVar.bcP)) != null && !hashMap.isEmpty() && (rVar = (r) hashMap.get(Long.valueOf(sVar.bmN))) != null && rVar.bnp != null) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < rVar.bnp.size()) {
                                r.a aVar2 = rVar.bnp.get(i2);
                                if (sVar.bnr != null && sVar.bnr.size() > i2) {
                                    aVar2.count = sVar.bnr.get(i2).bmT;
                                    aVar2.aVC = sVar.bnr.get(i2).bmU;
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
        this.blk = new HttpMessageListener(1031054) { // from class: com.baidu.live.im.q.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                q.this.bkL = false;
                Log.i("i", "@@@ localText gtibslist 1");
                q.this.mHandler.removeCallbacks(q.this.bkU);
                if (httpResponsedMessage != null) {
                    if (httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.im.message.c) && ((com.baidu.live.im.message.c) httpResponsedMessage.getOrginalMessage()).bb(System.currentTimeMillis())) {
                        Log.i("i", "@@@ localText gtibslist out");
                        q.this.bkM = false;
                        return;
                    }
                    Log.i("i", "@@@ localText gtibslist ta=" + q.this.bkM);
                    if (q.this.bkM) {
                        q.this.bkM = false;
                    } else if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        Log.i("i", "@@@ localText gtibslist err he=" + httpResponsedMessage.hasError() + ", err=" + httpResponsedMessage.getError());
                        YuyinImForbiddenStateData yuyinImForbiddenStateData = new YuyinImForbiddenStateData();
                        yuyinImForbiddenStateData.errno = httpResponsedMessage.getError();
                        yuyinImForbiddenStateData.errMsg = httpResponsedMessage.getErrorString();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, yuyinImForbiddenStateData));
                    } else {
                        Log.i("i", "@@@ localText gtibslist suc");
                        if (httpResponsedMessage instanceof YuyinAlaForbiddenWordsStateResponseMessage) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, ((YuyinAlaForbiddenWordsStateResponseMessage) httpResponsedMessage).bpN));
                        }
                    }
                }
            }
        };
        if (com.baidu.live.ae.a.Qj().buX.aNt != null) {
            this.bnh = com.baidu.live.ae.a.Qj().buX.aNt.aRk;
            this.bni = com.baidu.live.ae.a.Qj().buX.aNt.aRl;
            this.bnj = com.baidu.live.ae.a.Qj().buX.aNt.aRm;
        }
        this.bkx = bdPageContext;
        this.bky = z;
        this.bnk = aVar;
        this.mMsgList = new LinkedList<>();
        this.bkQ = new LinkedHashMap<>();
        this.bkR = new HashMap<>();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501043, Object.class);
        if (runTask != null && runTask.getData() != null) {
            this.bkP = true;
        }
        MessageManager.getInstance().registerTask(Jr());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031043, com.baidu.live.a.avJ + "ala/audio/live/getLiveStatus");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGetAudioLiveStatusHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.live.tieba.f.a.a.a(1021012, "alaim/gmsg/getGroupMsg", ALAGroupHttpResponseMessage.class, false, true, true, true);
        JC();
        registerListener(this.blk);
    }

    public void setAlaLiveShowData(ab abVar) {
        this.aDd = abVar;
        if (this.aDd != null && this.aDd.mLiveInfo != null) {
            this.bkN = this.aDd.mLiveInfo.audience_count - this.aDd.mLiveInfo.ai_robot_num;
        }
    }

    private HttpMessageTask Jr() {
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
    public void Js() {
        this.mHandler.postDelayed(this.bkX, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jt() {
        sendMessage(new com.baidu.live.im.message.b(JavaTypesHelper.toInt(this.mGroupId, 0), getLastMid()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ju() {
        this.mHandler.removeCallbacks(this.bkX);
    }

    public void g(long j, String str) {
        if (j == 0) {
            j = 1;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.bkx.getString(a.h.sdk_gift);
        }
        com.baidu.live.im.data.b a2 = a((short) 27, String.format(this.bkx.getString(a.h.sdk_send_gift_fail_yuyin), Long.valueOf(j), str), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), "", this.aIK);
        if (a2 != null) {
            a(-1, a2);
            if (this.bnk != null) {
                this.bnk.t(a2);
                this.bnk.d(this.mMsgList, true);
            }
        }
    }

    public com.baidu.live.im.data.b a(String str, String str2, String str3, String str4, long j, boolean z, String str5) {
        return a((short) 24, a(str, str2, TextUtils.isEmpty(str3) ? "1" : str3, TextUtils.isEmpty(str4) ? this.bkx.getString(a.h.sdk_gift) : str4, j, z).toString(), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), str5, this.aIK);
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
        if (this.bnk != null) {
            this.bnk.t(aVar);
            if (z) {
                this.bnk.d(this.mMsgList, true);
            }
        }
    }

    protected void a(ResponsedMessage<?> responsedMessage, boolean z) {
        boolean z2;
        long j;
        List<com.baidu.live.im.data.b> list;
        if (responsedMessage instanceof ALAGroupHttpResponseMessage) {
            list = ((ALAGroupHttpResponseMessage) responsedMessage).Lw();
            j = ((ALAGroupHttpResponseMessage) responsedMessage).getGroupId();
            z2 = ((ALAGroupHttpResponseMessage) responsedMessage).Lv();
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
            if (this.bkE != 0) {
                int i2 = this.bkF * this.bkD;
                ArrayList arrayList = new ArrayList(this.bkC);
                d(0, arrayList.subList(i2, arrayList.size()));
                JA();
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
        if (this.bkQ != null) {
            this.bkQ.clear();
        }
        if (this.bkR != null) {
            this.bkR.clear();
        }
        this.mMsgList = new LinkedList<>();
        this.mGroupId = str;
        this.bkA = str2;
        this.bkB = str3;
        this.mLiveId = str4;
        this.bkH = "0";
        this.mAppId = str5;
        MessageManager.getInstance().registerListener(this.bld);
        MessageManager.getInstance().registerListener(this.ble);
        MessageManager.getInstance().registerListener(this.bkV);
        MessageManager.getInstance().registerListener(this.bkY);
        MessageManager.getInstance().registerListener(this.bkW);
        MessageManager.getInstance().registerListener(this.bkZ);
        MessageManager.getInstance().registerListener(this.blc);
        MessageManager.getInstance().registerListener(this.blb);
        MessageManager.getInstance().registerListener(this.blg);
        MessageManager.getInstance().registerListener(this.blh);
        MessageManager.getInstance().registerListener(this.bli);
        MessageManager.getInstance().registerListener(this.blj);
        MessageManager.getInstance().registerListener(this.blf);
        MessageManager.getInstance().registerListener(this.bnl);
        MessageManager.getInstance().registerListener(this.bnm);
        if (BdSocketLinkService.isClose()) {
            Jt();
            BdSocketLinkService.startService(true, "live start");
        }
        if (com.baidu.live.ae.a.Qj().buX != null && com.baidu.live.ae.a.Qj().buX.aNt != null) {
            String str6 = com.baidu.live.ae.a.Qj().buX.aNt.aRj;
            if (!TextUtils.isEmpty(str6)) {
                com.baidu.live.im.data.b JB = JB();
                JB.setMsgType(27);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("text", str6);
                    jSONObject.put("content_type", "audio_custom_live_notice");
                    JB.setContent(jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                a(-1, JB);
                if (this.bnk != null) {
                    this.bnk.t(JB);
                }
            }
        }
        if (this.aDd != null && this.aDd.aIR != null && !StringUtils.isNull(this.aDd.aIR.Be())) {
            com.baidu.live.im.data.b JB2 = JB();
            JB2.setMsgType(27);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("text", this.aDd.aIR.Be());
                jSONObject2.put("content_type", "custom_live_notice");
                jSONObject2.put("category_msg_filter", "1");
                JB2.setContent(jSONObject2.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.mMsgList.add(JB2);
            if (this.bnk != null) {
                this.bnk.t(JB2);
            }
        }
        Jy();
        if (this.mMsgList.size() > 0 && this.bnk != null) {
            this.bnk.d(this.mMsgList, true);
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGmsgGetLiveStatusUnabled()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.q.7
                @Override // java.lang.Runnable
                public void run() {
                    q.this.gX("enter");
                }
            }, 1000L);
        }
        Js();
        if (TbadkCoreApplication.getInst().isOther()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913146, this.mMsgList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kv() {
        com.baidu.live.im.data.b JB;
        if (this.aDd != null && this.aDd.aIU != null && this.aDd.aIU.aTS != null && !StringUtils.isNull(this.aDd.aIU.aTS.content) && (JB = JB()) != null) {
            JB.setMsgType(27);
            try {
                JSONObject jSONObject = new JSONObject();
                String str = this.aDd.aIU.aTS.content;
                String str2 = this.aDd.aIU.aTS.title;
                jSONObject.put("text", str);
                jSONObject.put("room_id", this.aDd.aIU.aTK);
                jSONObject.put(DpStatConstants.KEY_ROOM_NAME, this.aDd.aIU.room_name);
                jSONObject.put("live_id", this.aDd.aIU.live_id);
                jSONObject.put("cover", this.aDd.aIU.cover);
                jSONObject.put("content_type", "play_rules");
                JB.setContent(jSONObject.toString());
                this.mMsgList.add(JB);
                if (this.mMsgList.size() > 0 && this.bnk != null) {
                    this.bnk.d(this.mMsgList, true);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void Jy() {
        if (Jz()) {
            com.baidu.live.im.data.b JB = JB();
            JB.setMsgType(27);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("text", com.baidu.live.ae.a.Qj().buX.aNc.aIp);
                jSONObject.put("content_type", "custom_im_notice_live_assistant");
                JB.setContent(jSONObject.toString());
                JB.setLink(com.baidu.live.ae.a.Qj().buX.aNc.aIo);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mMsgList.add(JB);
            if (this.bnk != null) {
                this.bnk.t(JB);
            }
        }
    }

    private boolean Jz() {
        return (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) || !TbadkCoreApplication.getCurrentAccount().equals(this.bkB) || com.baidu.live.ae.a.Qj().buX == null || com.baidu.live.ae.a.Qj().buX.aNc == null || TextUtils.isEmpty(com.baidu.live.ae.a.Qj().buX.aNc.aIp)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(List<com.baidu.live.im.data.b> list) {
        if (list != null && this.bnk != null) {
            this.bnk.d(this.mMsgList, true);
            for (com.baidu.live.im.data.b bVar : list) {
                this.bnk.t(bVar);
            }
        }
    }

    protected void P(List<com.baidu.live.im.data.b> list) {
        this.bkC = list;
        this.bkE = (int) ((this.bkG * 2.0f) / 0.25f);
        this.bkF = 0;
        this.bkD = list.size() / this.bkE;
        if (this.bkD <= 0) {
            this.bkD = 1;
        }
        this.mHandler.removeCallbacks(this.bkT);
        this.mHandler.postDelayed(this.bkT, 250L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JA() {
        this.mHandler.removeCallbacks(this.bkT);
        this.bkF = 0;
        this.bkE = 0;
        this.bkD = 0;
        this.bkC = null;
    }

    protected List<com.baidu.live.im.data.b> b(List<com.baidu.live.im.data.b> list, boolean z) {
        return a(list, z, false);
    }

    protected List<com.baidu.live.im.data.b> a(List<com.baidu.live.im.data.b> list, boolean z, boolean z2) {
        for (com.baidu.live.im.data.b bVar : list) {
            if (bVar instanceof com.baidu.live.im.a) {
                ((com.baidu.live.im.a) bVar).gW(this.bkB);
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
                Q(list);
            }
            if (z2 && this.mMsgList.size() > 2) {
                b(list, 2);
            } else {
                b(list, -1);
            }
        }
        if (this.mMsgList.size() > com.baidu.live.ae.a.Qj().buX.aMQ) {
            int i = (int) (com.baidu.live.ae.a.Qj().buX.aMQ * 0.7d);
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
        com.baidu.live.data.a KZ = bVar.KZ();
        if (KZ != null && (list = KZ.aFZ) != null && !list.isEmpty()) {
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
            d = com.baidu.live.ae.f.QB().m(z, jSONObject.optString(LogConfig.LOG_GIFT_ID));
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
        if ((bVar instanceof com.baidu.live.im.a) && bVar.KZ() != null && TextUtils.equals(bVar.KZ().userId, TbadkCoreApplication.getCurrentAccount())) {
            z = true;
        }
        if (this.bkN < this.bnh) {
            if (i >= 0) {
                this.mMsgList.add(i, bVar);
            } else {
                this.mMsgList.addLast(bVar);
            }
        } else if (this.bkN >= this.bnh && this.bkN < this.bni) {
            if (q(bVar) && !z) {
                bVar.Ll();
            }
            if (i >= 0) {
                this.mMsgList.add(i, bVar);
            } else if (!this.mMsgList.isEmpty() && q(this.mMsgList.getLast())) {
                if (!this.mMsgList.getLast().KZ().userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.mMsgList.set(this.mMsgList.size() - 1, bVar);
                } else {
                    this.mMsgList.addLast(bVar);
                }
            } else {
                this.mMsgList.addLast(bVar);
            }
        } else if (this.bkN >= this.bni && this.bkN < this.bnj) {
            if (o(bVar) && !z) {
                bVar.Ll();
            }
            if (i >= 0) {
                this.mMsgList.add(i, bVar);
            } else if (!this.mMsgList.isEmpty() && o(this.mMsgList.getLast())) {
                if (!this.mMsgList.getLast().KZ().userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.mMsgList.set(this.mMsgList.size() - 1, bVar);
                } else {
                    this.mMsgList.addLast(bVar);
                }
            } else {
                this.mMsgList.addLast(bVar);
            }
        } else if (this.bkN >= this.bnj) {
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
        this.bkO = 0;
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
                if (com.baidu.live.entereffect.a.CV().h(bVar)) {
                    this.bkO = 2;
                } else {
                    this.bkO = 1;
                }
            } else {
                this.bkO = 0;
            }
        }
        return this.bkO;
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
                    if (bVar != null && bVar.KZ() != null && !TextUtils.isEmpty(bVar.KZ().userId) && bVar.KZ().userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        int i2 = size - 1;
                        while (true) {
                            if (i2 >= 0 && i2 >= 0) {
                                com.baidu.live.im.data.b bVar2 = list.get(i2);
                                if (bVar2 != null && bVar2.KZ() != null && !TextUtils.isEmpty(bVar2.KZ().userId) && bVar2.KZ().userId.equals(TbadkCoreApplication.getCurrentAccount()) && bVar.getRecordId() == bVar2.getRecordId()) {
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
            if (!ListUtils.isEmpty(bVar.Lb()) && !bVar.Lb().contains(Long.valueOf(currentAccountId))) {
                linkedList.add(bVar);
            } else {
                boolean z2 = bVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                if (z2 && bVar.getMsgType() == 1 && !ListUtils.isEmpty(bVar.KZ().aFZ) && this.aIK == null) {
                    this.aIK = bVar.KZ().aFZ;
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
                            if (this.bnk != null) {
                                this.bnk.t(bVar);
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
                            if (this.bnk != null) {
                                this.bnk.t(bVar);
                            }
                        } else if ("task".equals(str)) {
                            linkedList.add(bVar);
                            if (this.bnk != null) {
                                this.bnk.t(bVar);
                            }
                        } else if ("live_achievement".equals(str)) {
                            linkedList.add(bVar);
                            if (this.bnk != null) {
                                this.bnk.t(bVar);
                            }
                        } else if ("ss_hot_live".equals(str)) {
                            linkedList.add(bVar);
                            if (this.bnk != null) {
                                this.bnk.t(bVar);
                            }
                        } else if ("challenge_direct_new".equals(str)) {
                            linkedList.add(bVar);
                            if (this.bnk != null) {
                                this.bnk.t(bVar);
                            }
                        } else if ("challenge_random_cancel".equals(str)) {
                            linkedList.add(bVar);
                            if (this.bnk != null) {
                                this.bnk.t(bVar);
                            }
                        } else if ("update_liveinfo".equals(str)) {
                            linkedList.add(bVar);
                            if (this.bnk != null) {
                                this.bnk.t(bVar);
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
                            if (z2 && !ListUtils.isEmpty(bVar.KZ().aFZ)) {
                                this.aIK = bVar.KZ().aFZ;
                                if (this.aDd != null) {
                                    this.aDd.aIK = this.aIK;
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
                                if (this.bnk != null) {
                                    this.bnk.t(bVar);
                                }
                            } else if ("introduce_goods".equals(str)) {
                                linkedList.add(bVar);
                                if (this.bnk != null) {
                                    this.bnk.t(bVar);
                                }
                            } else if ("first_recharge_success".equals(str)) {
                                linkedList.add(bVar);
                                if (this.bnk != null) {
                                    this.bnk.t(bVar);
                                }
                            } else if ("privilege_award_success".equals(str)) {
                                linkedList.add(bVar);
                                if (this.bnk != null) {
                                    this.bnk.t(bVar);
                                }
                            } else if ("need_update_live_mark_info".equals(str)) {
                                linkedList.add(bVar);
                                if (this.bnk != null) {
                                    this.bnk.t(bVar);
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
                                                if (this.bnk != null) {
                                                    this.bnk.t(bVar);
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
                    if (this.bnk != null) {
                        this.bnk.t(bVar);
                    }
                    gX("push");
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
                BdUtilHelper.showToast(this.bkx.getPageActivity(), optString);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected com.baidu.live.im.data.b a(short s, String str, boolean z, boolean z2, int i, String str2, List<AlaLiveMarkData> list) {
        long j = 0;
        com.baidu.live.im.data.b JB = JB();
        if (JB == null) {
            return null;
        }
        JB.setMsgType(s);
        JB.setContent(str);
        long aW = o.aW(getLastMid());
        JB.bpk = str2;
        JB.setMsgId(aW);
        JB.setRecordId(aW);
        JB.setTime(System.currentTimeMillis() / 1000);
        com.baidu.live.data.a aVar = new com.baidu.live.data.a();
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            aVar.userName = TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow();
        }
        aVar.userId = TbadkCoreApplication.getCurrentAccount();
        aVar.portrait = TbadkCoreApplication.getCurrentPortrait();
        aVar.level_id = i;
        aVar.aFW = z;
        aVar.aFX = z2;
        if (list != null) {
            aVar.aFZ = new ArrayList(list);
        }
        JB.e(aVar);
        try {
            j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        } catch (Exception e) {
        }
        JB.setUserId(j);
        return JB;
    }

    private long getLastMid() {
        if (this.mMsgList == null || this.mMsgList.size() <= 0) {
            return JavaTypesHelper.toLong(this.bkA, 1L);
        }
        return this.mMsgList.get(this.mMsgList.size() - 1).getMsgId();
    }

    protected com.baidu.live.im.data.b JB() {
        com.baidu.live.im.a aVar = new com.baidu.live.im.a();
        aVar.setBornTime(System.currentTimeMillis());
        if (TextUtils.isEmpty(this.mGroupId)) {
            return null;
        }
        aVar.gW(this.bkB);
        return aVar;
    }

    public void S(List<AlaLiveMarkData> list) {
        this.aIK = list;
    }

    public void gX(String str) {
        com.baidu.live.message.b bVar = new com.baidu.live.message.b(JavaTypesHelper.toLong(this.mLiveId, 0L), str);
        bVar.setParams();
        sendMessage(bVar);
    }

    public void gY(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.bkH)) {
            gX("getliveinfo");
        }
    }

    private List<com.baidu.live.im.data.b> r(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        int optInt;
        boolean Eb;
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
            com.baidu.live.gift.g gm = ac.gm(jSONObject.optString(LogConfig.LOG_GIFT_ID));
            Eb = gm != null ? gm.Eb() : false;
        } catch (JSONException e) {
            arrayList.add(aVar);
        }
        if (optInt == 1 || Eb) {
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
            aVar2.gW(aVar.Jp());
            aVar2.setBornTime(aVar.getBornTime());
            aVar2.setTime(aVar.getTime());
            aVar2.setUserId(aVar.getUserId());
            aVar2.setToUserId(aVar.getToUserId());
            aVar2.f(aVar.La());
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
            aVar2.e(aVar.KZ());
            aVar2.setSt_type(aVar.getSt_type());
            arrayList.add(aVar2);
        }
        return arrayList;
    }

    public void a(int i, String str, com.baidu.live.data.a aVar) {
        com.baidu.live.im.data.b JB = JB();
        if (JB != null) {
            JB.setMsgType(i);
            JB.setContent(str);
            JB.e(aVar);
            a(-1, JB);
            if (this.bnk != null) {
                this.bnk.d(this.mMsgList, true);
                this.bnk.t(JB);
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
        com.baidu.live.data.a KZ = bVar.KZ();
        String str = KZ.userId;
        KZ.getNameShow();
        String a2 = com.baidu.live.utils.s.a(optLong, optString, str, bVar.bno);
        if (this.bkQ == null) {
            this.bkQ = new LinkedHashMap<>();
        }
        long j = JavaTypesHelper.toLong(jSONObject.optString("gift_count"), 0L);
        double optDouble = jSONObject.optDouble("gift_rate", 0.0d);
        long j2 = JavaTypesHelper.toLong(jSONObject.optString("charm_value"), 0L);
        jSONObject.optString("gift_url");
        jSONObject.optString("gift_name");
        r rVar = new r();
        rVar.bnp = new ArrayList();
        rVar.giftId = optString;
        rVar.aYl = optLong;
        rVar.bno = bVar.bno;
        for (s.a aVar : com.baidu.live.utils.s.m22if(bVar.bno)) {
            r.a aVar2 = new r.a();
            aVar2.bmE = bVar.clone();
            aVar2.bmE.setMsgType(24);
            aVar2.bmG = optDouble;
            aVar2.count = j;
            aVar2.bnq = aVar.name;
            aVar2.aVC = j2;
            rVar.bnp.add(aVar2);
        }
        Iterator<String> it = this.bkQ.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (this.bkQ.get(next) == null || this.bkQ.get(next).isEmpty()) {
                it.remove();
            } else {
                HashMap<Long, r> hashMap = this.bkQ.get(next);
                Iterator<Long> it2 = hashMap.keySet().iterator();
                while (it2.hasNext()) {
                    long longValue = it2.next().longValue();
                    if (hashMap.get(Long.valueOf(longValue)) == null || hashMap.get(Long.valueOf(longValue)).bmJ) {
                        it2.remove();
                    }
                }
                if (this.bkQ.get(next) == null || this.bkQ.get(next).isEmpty()) {
                    it.remove();
                }
            }
        }
        if (!this.bkQ.containsKey(a2)) {
            HashMap<Long, r> hashMap2 = new HashMap<>();
            hashMap2.put(Long.valueOf(bVar.getMsgId()), rVar);
            this.bkQ.put(a2, hashMap2);
            return;
        }
        this.bkQ.get(a2).put(Long.valueOf(bVar.getMsgId()), rVar);
    }

    private void b(List<com.baidu.live.im.data.b> list, int i) {
        JSONObject jSONObject;
        int i2;
        if (this.bkP) {
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
                            com.baidu.live.data.a KZ = bVar.KZ();
                            if (KZ == null || StringUtils.isNull(KZ.userId) || StringUtils.isNull(optString)) {
                                if (i >= 0) {
                                    a(i + i4, bVar);
                                } else {
                                    a(-1, bVar);
                                }
                            } else {
                                String str = KZ.userId;
                                KZ.getNameShow();
                                String a2 = com.baidu.live.utils.s.a(0L, optString, str, bVar.bno);
                                if (this.bkQ == null) {
                                    this.bkQ = new LinkedHashMap<>();
                                }
                                long j = JavaTypesHelper.toLong(jSONObject.optString("gift_count"), 0L);
                                double optDouble = jSONObject.optDouble("gift_rate", 0.0d);
                                long j2 = JavaTypesHelper.toLong(jSONObject.optString("charm_value"), 0L);
                                jSONObject.optString("gift_url");
                                jSONObject.optString("gift_name");
                                long optLong = jSONObject.optLong("combo_groupid");
                                r rVar = new r();
                                rVar.bnp = new ArrayList();
                                rVar.giftId = optString;
                                rVar.aYl = optLong;
                                rVar.bno = bVar.bno;
                                for (s.a aVar : com.baidu.live.utils.s.m22if(bVar.bno)) {
                                    r.a aVar2 = new r.a();
                                    aVar2.bmE = bVar.clone();
                                    aVar2.bmG = optDouble;
                                    aVar2.count = j;
                                    aVar2.bnq = aVar.name;
                                    aVar2.aVC = j2;
                                    rVar.bnp.add(aVar2);
                                }
                                if (com.baidu.live.ae.a.Qj().buX == null) {
                                    i2 = 100;
                                } else {
                                    i2 = com.baidu.live.ae.a.Qj().buX.aMW * 2;
                                }
                                Iterator<String> it = this.bkQ.keySet().iterator();
                                int i5 = 0;
                                while (it.hasNext()) {
                                    String next = it.next();
                                    if (this.bkQ.get(next) == null || this.bkQ.get(next).isEmpty()) {
                                        it.remove();
                                    } else {
                                        HashMap<Long, r> hashMap = this.bkQ.get(next);
                                        Iterator<Long> it2 = hashMap.keySet().iterator();
                                        while (it2.hasNext()) {
                                            long longValue = it2.next().longValue();
                                            if (hashMap.get(Long.valueOf(longValue)) == null || hashMap.get(Long.valueOf(longValue)).bmJ) {
                                                it2.remove();
                                            }
                                        }
                                        if (this.bkQ.get(next) == null || this.bkQ.get(next).isEmpty()) {
                                            it.remove();
                                        } else {
                                            i5 = hashMap.size() + i5;
                                        }
                                    }
                                }
                                if (i5 > i2) {
                                    int i6 = i5 - ((int) (i2 * 0.7d));
                                    Iterator<String> it3 = this.bkQ.keySet().iterator();
                                    while (true) {
                                        int i7 = i6;
                                        if (!it3.hasNext()) {
                                            break;
                                        }
                                        i6 = i7 - this.bkQ.get(it3.next()).size();
                                        it3.remove();
                                        if (i6 <= 0) {
                                            break;
                                        }
                                    }
                                }
                                if (!this.bkQ.containsKey(a2)) {
                                    HashMap<Long, r> hashMap2 = new HashMap<>();
                                    hashMap2.put(Long.valueOf(bVar.getMsgId()), rVar);
                                    this.bkQ.put(a2, hashMap2);
                                } else {
                                    this.bkQ.get(a2).put(Long.valueOf(bVar.getMsgId()), rVar);
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
            HashMap<Long, r> hashMap = this.bkR.get(a2);
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
                            if (next.bmK.contains(l)) {
                                rVar = next;
                                break;
                            }
                        }
                    }
                    if (rVar != null) {
                        long longValue = map.get(l).longValue();
                        if (z) {
                            rVar.bmF = longValue + rVar.bmF;
                        }
                        if (rVar.bmJ) {
                            hashMap.remove(Long.valueOf(rVar.aWR));
                            for (r.a aVar : rVar.bnp) {
                                aVar.bmE.aX(aVar.count);
                                aVar.bmE.h(aVar.bmG);
                                aVar.bmE.aY(aVar.aVC);
                                a(-1, aVar.bmE);
                                if (this.bnk != null) {
                                    this.bnk.d(this.mMsgList, true);
                                }
                                long j4 = rVar.bmF;
                                if (j4 > 0) {
                                    g(j4, aVar.giftName);
                                }
                            }
                        }
                    }
                }
                if (hashMap.isEmpty()) {
                    this.bkR.remove(a2);
                }
            }
        }
    }

    public void zR() {
        this.mGroupId = null;
        this.bkA = null;
        this.mLiveId = null;
        this.bkH = "0";
        this.mAppId = null;
        this.bkL = false;
        this.bkM = false;
        MessageManager.getInstance().unRegisterListener(this.ble);
        MessageManager.getInstance().unRegisterListener(this.bld);
        MessageManager.getInstance().unRegisterListener(this.bkV);
        MessageManager.getInstance().unRegisterListener(this.bkY);
        MessageManager.getInstance().unRegisterListener(this.bkZ);
        MessageManager.getInstance().unRegisterListener(this.blb);
        MessageManager.getInstance().unRegisterListener(this.blc);
        MessageManager.getInstance().unRegisterListener(this.bkW);
        MessageManager.getInstance().unRegisterListener(this.blg);
        MessageManager.getInstance().unRegisterListener(this.blh);
        MessageManager.getInstance().unRegisterListener(this.bli);
        MessageManager.getInstance().unRegisterListener(this.blj);
        MessageManager.getInstance().unRegisterListener(this.blf);
        MessageManager.getInstance().unRegisterListener(this.bnl);
        MessageManager.getInstance().unRegisterListener(this.bnm);
        this.mHandler.removeCallbacks(this.bkU);
        this.mHandler.removeCallbacks(this.bkT);
        this.mHandler.removeCallbacks(this.bkX);
        if (this.mMsgList != null) {
            this.mMsgList.clear();
        }
        this.mMsgList = null;
        if (this.bkQ != null) {
            this.bkQ.clear();
        }
        if (this.bkR != null) {
            this.bkR.clear();
        }
    }

    private void JC() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031054, com.baidu.live.a.avJ + "ala/audio/user/judgeBan");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(YuyinAlaForbiddenWordsStateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(ImSendMsgData imSendMsgData, boolean z, boolean z2, int i, String str, String[] strArr) {
        Log.i("i", "@@@ localText limmdl sm");
        if (!TbadkCoreApplication.isLogin()) {
            BdUtilHelper.showToast(this.bkx.getPageActivity(), a.h.sdk_not_login);
        } else if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow())) {
            BdUtilHelper.showToast(this.bkx.getPageActivity(), a.h.sdk_username_empty);
        } else {
            Log.i("i", "@@@ localText limmdl sm 1");
            String str2 = imSendMsgData.text;
            short s = imSendMsgData.msgType;
            com.baidu.live.im.data.b a2 = a(s, str2, z, z2, i, "", this.aIK);
            if (s == 126) {
                a2.dC(imSendMsgData.barrageType);
                a2.hh(imSendMsgData.barrageId);
                a2.a(imSendMsgData.barrageCardInfo);
            }
            Log.i("i", "@@@ localText limmdl sm cm=" + a2);
            if (a2 != null) {
                a2.l(strArr);
                a(-1, a2);
                if (this.bnk != null) {
                    Log.i("i", "@@@ localText limmdl sm recv");
                    this.bnk.t(a2);
                    this.bnk.d(this.mMsgList, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913043));
                com.baidu.live.im.message.a aVar = new com.baidu.live.im.message.a(str2, s, JavaTypesHelper.toInt(this.mGroupId, 0), this.mAppId);
                if (this.aDd != null && this.aDd.mLiveInfo != null && this.aDd.aIU != null) {
                    aVar.setLiveId(this.aDd.mLiveInfo.live_id + "");
                    aVar.setRoomId(this.aDd.mLiveInfo.room_id + "");
                    aVar.dD(1);
                    aVar.setCustomRoomId(this.aDd.aIU.croom_id);
                } else {
                    aVar.setLiveId("");
                    aVar.setRoomId("");
                }
                aVar.setOtherParams(str);
                aVar.aZ(imSendMsgData.price);
                aVar.dC(imSendMsgData.barrageType);
                aVar.hh(imSendMsgData.barrageId);
                aVar.a(imSendMsgData.barrageCardInfo);
                aVar.l(strArr);
                aVar.cq(imSendMsgData.isQuick);
                sendMessage(aVar);
            }
        }
    }

    public void e(String str, long j) {
        Log.i("i", "@@@ localText limm sdreq uk=" + str + ",lvd=" + j + ",iibr=" + this.bkL);
        if (!this.bkL) {
            this.bkL = true;
            Log.i("i", "@@@ localText limm sdreq go");
            com.baidu.live.im.message.c cVar = new com.baidu.live.im.message.c(1031054);
            cVar.addParam("uk", str);
            cVar.addParam("live_id", j);
            cVar.ba(System.currentTimeMillis());
            sendMessage(cVar);
            this.mHandler.postDelayed(this.bkU, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JD() {
        Log.i("i", "@@@ localText limm sdreq out");
        this.bkL = false;
        this.bkM = true;
        YuyinImForbiddenStateData yuyinImForbiddenStateData = new YuyinImForbiddenStateData();
        yuyinImForbiddenStateData.errno = -1;
        yuyinImForbiddenStateData.errMsg = this.bkx.getString(a.h.sdk_neterror);
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
                                bVar.bno = jSONObject.optString("benefit_info");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (bVar.getMsgType() == 24) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(bVar.getContent());
                            if (jSONObject2 != null) {
                                bVar.bno = jSONObject2.optString("benefit_info");
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
            if (!com.baidu.live.ao.a.Yj().iH(com.baidu.live.ao.a.Yj().Yp()) && !com.baidu.live.ao.a.Yj().Yk()) {
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
