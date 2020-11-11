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
import com.baidu.live.gift.aa;
import com.baidu.live.gift.al;
import com.baidu.live.gift.am;
import com.baidu.live.gift.an;
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
    private w aES;
    private List<AlaLiveMarkData> aJA;
    public int bhJ;
    public int bhK;
    public int bhL;
    private boolean bhM;
    private String bhO;
    private String bhP;
    private List<com.baidu.live.im.data.a> bhQ;
    private int bhR;
    private int bhS;
    private int bhT;
    private float bhU;
    private String bhV;
    private boolean bhX;
    private boolean bhY;
    private int bhZ;
    private int bia;
    private boolean bib;
    private LinkedHashMap<String, HashMap<Long, r>> bic;
    private HashMap<String, HashMap<Long, r>> bie;
    private b.a bif;
    private Runnable bih;
    private Runnable bii;
    private CustomMessageListener bij;
    private CustomMessageListener bik;
    private Runnable bil;
    private HttpMessageListener bim;
    private HttpMessageListener bin;
    private HttpMessageListener bip;
    private HttpMessageListener biq;
    private HttpMessageListener bir;
    private NetMessageListener bis;
    CustomMessageListener bit;
    CustomMessageListener biu;
    CustomMessageListener biv;
    CustomMessageListener biw;
    CustomMessageListener bix;
    private HttpMessageListener biy;
    private a bkr;
    private CustomMessageListener bks;
    private long count;
    private String mAppId;
    private String mGroupId;
    private Handler mHandler;
    private String mLiveId;
    private LinkedList<com.baidu.live.im.data.a> mMsgList;
    BdPageContext<?> mPageContext;

    /* loaded from: classes4.dex */
    public interface a {
        void Ll();

        void d(List<com.baidu.live.im.data.a> list, boolean z);

        void t(com.baidu.live.im.data.a aVar);
    }

    static /* synthetic */ int h(q qVar) {
        int i = qVar.bhT;
        qVar.bhT = i + 1;
        return i;
    }

    public q(BdPageContext<?> bdPageContext, boolean z, a aVar) {
        super(bdPageContext);
        this.mLiveId = null;
        this.bhU = 1.0f;
        this.mHandler = new Handler();
        this.bhV = null;
        this.bhX = false;
        this.bhY = false;
        this.bia = 0;
        this.bib = false;
        this.bif = new b.a() { // from class: com.baidu.live.im.q.1
        };
        this.bih = new Runnable() { // from class: com.baidu.live.im.q.12
            @Override // java.lang.Runnable
            public void run() {
                int i = q.this.bhT * q.this.bhR;
                if (i >= q.this.bhQ.size()) {
                    q.this.Lh();
                } else if (q.this.bhT >= q.this.bhS - 1) {
                    if (q.this.bhT != q.this.bhS - 1) {
                        q.this.Lh();
                        return;
                    }
                    ArrayList arrayList = new ArrayList(q.this.bhQ);
                    q.this.M(q.this.b(arrayList.subList(i, arrayList.size()), true));
                    q.h(q.this);
                    q.this.Lh();
                } else {
                    ArrayList arrayList2 = new ArrayList(q.this.bhQ);
                    if (q.this.bhR + i <= arrayList2.size()) {
                        q.this.M(q.this.b(arrayList2.subList(i, q.this.bhR + i), true));
                        q.h(q.this);
                        q.this.mHandler.postDelayed(q.this.bih, 250L);
                        return;
                    }
                    q.this.M(q.this.b(arrayList2.subList(i, arrayList2.size()), true));
                    q.h(q.this);
                    q.this.Lh();
                }
            }
        };
        this.bii = new Runnable() { // from class: com.baidu.live.im.q.14
            @Override // java.lang.Runnable
            public void run() {
                q.this.Lk();
            }
        };
        this.bij = new CustomMessageListener(MessageConfig.SOCKET_RECEIVE_MSG) { // from class: com.baidu.live.im.q.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                q.this.Ld();
            }
        };
        this.bik = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.live.im.q.16
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
                        if (q.this.bkr != null) {
                            q.this.bkr.t(aVar2);
                            q.this.bkr.d(q.this.mMsgList, true);
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
                        if (q.this.bkr != null) {
                            q.this.bkr.t(aVar3);
                            q.this.bkr.d(q.this.mMsgList, true);
                        }
                    }
                }
            }
        };
        this.bil = new Runnable() { // from class: com.baidu.live.im.q.17
            @Override // java.lang.Runnable
            public void run() {
                if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().getLastReceDataTime() > 35000) {
                    q.this.Lc();
                }
                q.this.Lb();
            }
        };
        this.bks = new CustomMessageListener(2501072) { // from class: com.baidu.live.im.q.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                    com.baidu.live.im.data.a aVar2 = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                    q.this.a(-1, aVar2);
                    if (q.this.bkr != null) {
                        q.this.bkr.d(q.this.mMsgList, true);
                        q.this.bkr.t(aVar2);
                    }
                }
            }
        };
        this.bim = new HttpMessageListener(1021013) { // from class: com.baidu.live.im.q.19
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    boolean z2 = false;
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        int error = httpResponsedMessage.getError();
                        if (com.baidu.live.aa.a.PQ().bod.aNo == 1) {
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
                    if (!z2 && q.this.bkr != null) {
                        q.this.bkr.Ll();
                    }
                }
            }
        };
        this.bin = new HttpMessageListener(1031055) { // from class: com.baidu.live.im.q.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof al) {
                        al alVar = (al) orginalMessage;
                        boolean z2 = false;
                        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            z2 = true;
                            if (!q.this.bib) {
                                q.this.f(alVar.aVw, alVar.giftName);
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                        }
                        if (q.this.bib) {
                            q.this.a(alVar.giftId, alVar.aVw, alVar.aVA, alVar.aWL, z2, alVar.aVC);
                        }
                    }
                }
            }
        };
        this.bip = new HttpMessageListener(1031056) { // from class: com.baidu.live.im.q.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof am) {
                        am amVar = (am) orginalMessage;
                        boolean z2 = false;
                        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            z2 = true;
                            if (!q.this.bib) {
                                q.this.f(amVar.aVw, amVar.giftName);
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                        }
                        if (q.this.bib) {
                            q.this.a(amVar.giftId, amVar.aVw, amVar.aVA, amVar.aWL, z2, amVar.aVC);
                        }
                    }
                }
            }
        };
        this.biq = new HttpMessageListener(1031057) { // from class: com.baidu.live.im.q.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                boolean z2;
                boolean z3;
                if (httpResponsedMessage != null) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof an) {
                        an anVar = (an) orginalMessage;
                        if ((httpResponsedMessage instanceof YuyinGiftPackageConsumeHttpResponsedMessage) && TextUtils.isEmpty(((YuyinGiftPackageConsumeHttpResponsedMessage) httpResponsedMessage).aWy)) {
                            if (!q.this.bib) {
                                q.this.f(anVar.aWg, anVar.giftName);
                            }
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            if (!q.this.bib) {
                                q.this.f(anVar.aWg, anVar.giftName);
                            }
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (q.this.bib) {
                            q.this.a(anVar.giftId, anVar.aWg, anVar.aVA, anVar.aWM, z3, anVar.aVC);
                        }
                    }
                }
            }
        };
        this.bir = new HttpMessageListener(1021012) { // from class: com.baidu.live.im.q.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                q.this.a((ResponsedMessage<?>) httpResponsedMessage, false);
            }
        };
        this.bis = new NetMessageListener(1031043, 601008) { // from class: com.baidu.live.im.q.5
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
                        if (!TextUtils.isEmpty(((AlaGetAudioLiveStatusHttpResponseMessage) responsedMessage).bnT)) {
                            jSONObject = new JSONObject(alaGetAudioLiveStatusHttpResponseMessage.bnT);
                            jSONObject2 = jSONObject;
                            if (jSONObject2 == null) {
                                if (!"backstage_live".equals(jSONObject2.optString("content_type"))) {
                                    q.this.a(alaGetAudioLiveStatusHttpResponseMessage.bnT, jSONObject2, 12, false);
                                    return;
                                }
                                String optString = jSONObject2.optString("backstage_type");
                                if (!TextUtils.isEmpty(optString) && !optString.equals(q.this.bhV)) {
                                    q.this.a(alaGetAudioLiveStatusHttpResponseMessage.bnT, jSONObject2, 13, true);
                                    q.this.bhV = optString;
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
        this.bit = new CustomMessageListener(2913192) { // from class: com.baidu.live.im.q.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText banlstn sd=" + q.this.aES);
                if (q.this.aES != null) {
                    if (q.this.aES.mLiveInfo.getUserID() == Long.valueOf(TbadkCoreApplication.getCurrentAccount()).longValue()) {
                        Log.i("i", "@@@ localText banlstn own");
                        if (q.this.aES.aIV != null && q.this.aES.mLiveInfo != null) {
                            Log.i("i", "@@@ localText banlstn own sdreq");
                            q.this.f(q.this.aES.aIV.userUk, q.this.aES.mLiveInfo.live_id);
                            return;
                        }
                        return;
                    }
                    Log.i("i", "@@@ localText banlstn oth");
                    if (q.this.aES.aJr != null && q.this.aES.mLiveInfo != null) {
                        Log.i("i", "@@@ localText banlstn oth sdreq");
                        q.this.f(q.this.aES.aJr.userUk, q.this.aES.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.biu = new CustomMessageListener(2913185) { // from class: com.baidu.live.im.q.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                r rVar;
                if (q.this.bib) {
                    if (q.this.bie == null) {
                        q.this.bie = new HashMap();
                    }
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r) && (rVar = (r) customResponsedMessage.getData()) != null && rVar.bkv != null && rVar.bkv.size() > 0) {
                        String A = com.baidu.live.utils.r.A(rVar.giftId, rVar.userId, rVar.bku);
                        for (r.a aVar2 : rVar.bkv) {
                            com.baidu.live.im.data.a a2 = q.this.a(aVar2.giftId, aVar2.aVz, aVar2.count + "", aVar2.giftName, 0L, aVar2.bjV, aVar2.bkw);
                            if (a2 != null) {
                                double m = q.this.m(a2);
                                a2.setMsgId(0L);
                                a2.setRecordId(0L);
                                com.baidu.live.data.a Mo = a2.Mo();
                                if (Mo != null && !StringUtils.isNull(Mo.userId) && !StringUtils.isNull(aVar2.giftId)) {
                                    aVar2.bjR = a2;
                                    aVar2.bjU = m;
                                } else {
                                    return;
                                }
                            }
                        }
                        if (!q.this.bie.containsKey(A)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put(Long.valueOf(rVar.aVA), rVar);
                            q.this.bie.put(A, hashMap);
                            return;
                        }
                        ((HashMap) q.this.bie.get(A)).put(Long.valueOf(rVar.aVA), rVar);
                    }
                }
            }
        };
        this.biv = new CustomMessageListener(2913184) { // from class: com.baidu.live.im.q.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof s)) {
                    s sVar = (s) customResponsedMessage.getData();
                    if (sVar.bka > 0) {
                        HashMap hashMap = (HashMap) q.this.bic.get(sVar.bbd);
                        if (hashMap != null && !hashMap.isEmpty()) {
                            r rVar = (r) hashMap.remove(Long.valueOf(sVar.bka));
                            if (rVar != null && rVar.bkv != null && rVar.bkv.size() > 0) {
                                rVar.bjX = true;
                                while (true) {
                                    int i2 = i;
                                    if (i2 >= rVar.bkv.size()) {
                                        break;
                                    }
                                    r.a aVar2 = rVar.bkv.get(i2);
                                    aVar2.bjR.aw(aVar2.count);
                                    aVar2.bjR.o(aVar2.bjU);
                                    aVar2.bjR.blH = aVar2.bkw;
                                    aVar2.bjR.ax(aVar2.bjT);
                                    q.this.a(-1, aVar2.bjR);
                                    if (q.this.bkr != null) {
                                        q.this.bkr.d(q.this.mMsgList, true);
                                    }
                                    i = i2 + 1;
                                }
                            }
                            if (hashMap.isEmpty()) {
                                q.this.bic.remove(sVar.bbd);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    HashMap hashMap2 = (HashMap) q.this.bie.get(sVar.bbd);
                    if (hashMap2 != null && !hashMap2.isEmpty()) {
                        r rVar2 = (r) hashMap2.get(Long.valueOf(sVar.bkc));
                        if (rVar2 != null && rVar2.bkv != null && rVar2.bkv.size() > 0) {
                            hashMap2.remove(Long.valueOf(sVar.bkc));
                            while (true) {
                                int i3 = i;
                                if (i3 >= rVar2.bkv.size()) {
                                    break;
                                }
                                r.a aVar3 = rVar2.bkv.get(i3);
                                aVar3.bjR.aw(aVar3.count);
                                aVar3.bjR.o(aVar3.bjU);
                                aVar3.bjR.ax(aVar3.bjT);
                                aVar3.bjR.blH = aVar3.bkw;
                                q.this.a(-1, aVar3.bjR);
                                if (q.this.bkr != null) {
                                    q.this.bkr.d(q.this.mMsgList, true);
                                }
                                long j = rVar2.bjS;
                                if (j > 0) {
                                    q.this.f(j, aVar3.giftName);
                                }
                                i = i3 + 1;
                            }
                        }
                        if (hashMap2.isEmpty()) {
                            q.this.bie.remove(sVar.bbd);
                        }
                    }
                }
            }
        };
        this.biw = new CustomMessageListener(2913183) { // from class: com.baidu.live.im.q.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof s)) {
                    s sVar = (s) customResponsedMessage.getData();
                    if (sVar.bka == 0) {
                        HashMap hashMap = (HashMap) q.this.bie.get(sVar.bbd);
                        if (hashMap != null && !hashMap.isEmpty()) {
                            r rVar = (r) hashMap.get(Long.valueOf(sVar.bkc));
                            r rVar2 = (r) hashMap.get(Long.valueOf(sVar.bkf));
                            if (rVar != null && rVar2 != null) {
                                hashMap.remove(Long.valueOf(sVar.bkf));
                                if (rVar.bkv != null && rVar2.bkv != null && rVar.bkv.size() == rVar2.bkv.size()) {
                                    rVar.bjS += rVar2.bjS;
                                    while (i < rVar.bkv.size()) {
                                        rVar.bkv.get(i).count += rVar2.bkv.get(i).count;
                                        rVar.bkv.get(i).bjT += rVar2.bkv.get(i).bjT;
                                        if (rVar.bkv.get(i).bjU != rVar2.bkv.get(i).bjU) {
                                            rVar.bkv.get(i).bjU = 0.0d;
                                        }
                                        i++;
                                    }
                                    rVar.bjY.add(Long.valueOf(rVar2.aVA));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    HashMap hashMap2 = (HashMap) q.this.bic.get(sVar.bbd);
                    if (hashMap2 != null && !hashMap2.isEmpty()) {
                        r rVar3 = (r) hashMap2.get(Long.valueOf(sVar.bka));
                        r rVar4 = (r) hashMap2.remove(Long.valueOf(sVar.bkd));
                        if (rVar3 != null && rVar4 != null && rVar3.bkv != null && rVar4.bkv != null && rVar3.bkv.size() == rVar4.bkv.size()) {
                            while (i < rVar3.bkv.size()) {
                                rVar3.bkv.get(i).count += rVar4.bkv.get(i).count;
                                rVar3.bkv.get(i).bjT += rVar4.bkv.get(i).bjT;
                                if (rVar3.bkv.get(i).bjU != rVar4.bkv.get(i).bjU) {
                                    rVar3.bkv.get(i).bjU = 0.0d;
                                }
                                i++;
                            }
                        }
                    }
                }
            }
        };
        this.bix = new CustomMessageListener(2913195) { // from class: com.baidu.live.im.q.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                HashMap hashMap;
                r rVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof s)) {
                    s sVar = (s) customResponsedMessage.getData();
                    if (sVar.bka != 0 && (hashMap = (HashMap) q.this.bic.get(sVar.bbd)) != null && !hashMap.isEmpty() && (rVar = (r) hashMap.get(Long.valueOf(sVar.bka))) != null && rVar.bkv != null) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < rVar.bkv.size()) {
                                r.a aVar2 = rVar.bkv.get(i2);
                                if (sVar.bkx != null && sVar.bkx.size() > i2) {
                                    aVar2.count = sVar.bkx.get(i2).bkg;
                                    aVar2.bjT = sVar.bkx.get(i2).bkh;
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
        this.biy = new HttpMessageListener(1031054) { // from class: com.baidu.live.im.q.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                q.this.bhX = false;
                Log.i("i", "@@@ localText gtibslist 1");
                q.this.mHandler.removeCallbacks(q.this.bii);
                if (httpResponsedMessage != null) {
                    if (httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.im.message.c) && ((com.baidu.live.im.message.c) httpResponsedMessage.getOrginalMessage()).aA(System.currentTimeMillis())) {
                        Log.i("i", "@@@ localText gtibslist out");
                        q.this.bhY = false;
                        return;
                    }
                    Log.i("i", "@@@ localText gtibslist ta=" + q.this.bhY);
                    if (q.this.bhY) {
                        q.this.bhY = false;
                    } else if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        Log.i("i", "@@@ localText gtibslist err he=" + httpResponsedMessage.hasError() + ", err=" + httpResponsedMessage.getError());
                        YuyinImForbiddenStateData yuyinImForbiddenStateData = new YuyinImForbiddenStateData();
                        yuyinImForbiddenStateData.errno = httpResponsedMessage.getError();
                        yuyinImForbiddenStateData.errMsg = httpResponsedMessage.getErrorString();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, yuyinImForbiddenStateData));
                    } else {
                        Log.i("i", "@@@ localText gtibslist suc");
                        if (httpResponsedMessage instanceof YuyinAlaForbiddenWordsStateResponseMessage) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, ((YuyinAlaForbiddenWordsStateResponseMessage) httpResponsedMessage).blT));
                        }
                    }
                }
            }
        };
        this.bhJ = com.baidu.live.aa.a.PQ().bod.aNp;
        this.bhK = com.baidu.live.aa.a.PQ().bod.aNq;
        this.bhL = com.baidu.live.aa.a.PQ().bod.aNr;
        this.mPageContext = bdPageContext;
        this.bhM = z;
        this.bkr = aVar;
        this.mMsgList = new LinkedList<>();
        this.bic = new LinkedHashMap<>();
        this.bie = new HashMap<>();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501043, Object.class);
        if (runTask != null && runTask.getData() != null) {
            this.bib = true;
        }
        MessageManager.getInstance().registerTask(La());
        com.baidu.live.tieba.f.a.a.a(1031043, "ala/audio/live/getLiveStatus", AlaGetAudioLiveStatusHttpResponseMessage.class, false, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021012, "alaim/gmsg/getGroupMsg", ALAGroupHttpResponseMessage.class, false, true, true, true);
        Lj();
        registerListener(this.biy);
    }

    public void setAlaLiveShowData(w wVar) {
        this.aES = wVar;
        if (this.aES != null && this.aES.mLiveInfo != null) {
            this.bhZ = this.aES.mLiveInfo.audience_count - this.aES.mLiveInfo.ai_robot_num;
        }
    }

    private HttpMessageTask La() {
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
    public void Lb() {
        this.mHandler.postDelayed(this.bil, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lc() {
        sendMessage(new com.baidu.live.im.message.b(JavaTypesHelper.toInt(this.mGroupId, 0), getLastMid()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ld() {
        this.mHandler.removeCallbacks(this.bil);
    }

    public void f(long j, String str) {
        if (j == 0) {
            j = 1;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.mPageContext.getString(a.h.sdk_gift);
        }
        com.baidu.live.im.data.a a2 = a((short) 27, String.format(this.mPageContext.getString(a.h.sdk_send_gift_fail_yuyin), Long.valueOf(j), str), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), "", this.aJA);
        if (a2 != null) {
            a(-1, a2);
            if (this.bkr != null) {
                this.bkr.t(a2);
                this.bkr.d(this.mMsgList, true);
            }
        }
    }

    public com.baidu.live.im.data.a a(String str, String str2, String str3, String str4, long j, boolean z, String str5) {
        return a((short) 24, a(str, str2, TextUtils.isEmpty(str3) ? "1" : str3, TextUtils.isEmpty(str4) ? this.mPageContext.getString(a.h.sdk_gift) : str4, j, z).toString(), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), str5, this.aJA);
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
        if (this.bkr != null) {
            this.bkr.t(aVar);
            if (z) {
                this.bkr.d(this.mMsgList, true);
            }
        }
    }

    protected void a(ResponsedMessage<?> responsedMessage, boolean z) {
        boolean z2;
        long j;
        List<com.baidu.live.im.data.a> list;
        if (responsedMessage instanceof ALAGroupHttpResponseMessage) {
            List<com.baidu.live.im.data.a> MI = ((ALAGroupHttpResponseMessage) responsedMessage).MI();
            j = ((ALAGroupHttpResponseMessage) responsedMessage).getGroupId();
            list = MI;
            z2 = ((ALAGroupHttpResponseMessage) responsedMessage).MH();
        } else {
            z2 = false;
            j = 0;
            list = null;
        }
        if (j == JavaTypesHelper.toLong(this.mGroupId, 0L) && list != null && !list.isEmpty()) {
            S(list);
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
            if (this.bhS != 0) {
                int i2 = this.bhT * this.bhR;
                ArrayList arrayList = new ArrayList(this.bhQ);
                d(0, arrayList.subList(i2, arrayList.size()));
                Lh();
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
        if (this.bic != null) {
            this.bic.clear();
        }
        if (this.bie != null) {
            this.bie.clear();
        }
        this.mMsgList = new LinkedList<>();
        this.mGroupId = str;
        this.bhO = str2;
        this.bhP = str3;
        this.mLiveId = str4;
        this.bhV = "0";
        this.mAppId = str5;
        MessageManager.getInstance().registerListener(this.bir);
        MessageManager.getInstance().registerListener(this.bis);
        MessageManager.getInstance().registerListener(this.bij);
        MessageManager.getInstance().registerListener(this.bim);
        MessageManager.getInstance().registerListener(this.bik);
        MessageManager.getInstance().registerListener(this.bin);
        MessageManager.getInstance().registerListener(this.biq);
        MessageManager.getInstance().registerListener(this.bip);
        MessageManager.getInstance().registerListener(this.biu);
        MessageManager.getInstance().registerListener(this.biv);
        MessageManager.getInstance().registerListener(this.biw);
        MessageManager.getInstance().registerListener(this.bix);
        MessageManager.getInstance().registerListener(this.bit);
        MessageManager.getInstance().registerListener(this.bks);
        if (BdSocketLinkService.isClose()) {
            Lc();
            BdSocketLinkService.startService(true, "live start");
        }
        String str6 = com.baidu.live.aa.a.PQ().bod.aKP;
        if (!TextUtils.isEmpty(str6)) {
            com.baidu.live.im.data.a Li = Li();
            Li.setMsgType(27);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("text", str6);
                jSONObject.put("content_type", "custom_live_notice");
                Li.setContent(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            a(-1, Li);
            if (this.bkr != null) {
                this.bkr.t(Li);
            }
        }
        String str7 = com.baidu.live.aa.a.PQ().bod.aKQ;
        if (!TextUtils.isEmpty(str7)) {
            com.baidu.live.im.data.a Li2 = Li();
            Li2.setMsgType(27);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("text", str7);
                jSONObject2.put("content_type", "custom_live_notice");
                Li2.setContent(jSONObject2.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            a(-1, Li2);
        }
        List<String> list = com.baidu.live.aa.a.PQ().bod.aKO;
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
                    com.baidu.live.im.data.a Li3 = Li();
                    Li3.setMsgType(27);
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("text", str8);
                        jSONObject3.put("content_type", "custom_im_notice");
                        Li3.setContent(jSONObject3.toString());
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                    Li3.setLink(str9);
                    a(-1, Li3);
                    if (this.bkr != null) {
                        this.bkr.t(Li3);
                    }
                }
                i = i2 + 2;
            }
        }
        if (this.aES != null && this.aES.aJH != null && !StringUtils.isNull(this.aES.aJH.DZ())) {
            com.baidu.live.im.data.a Li4 = Li();
            Li4.setMsgType(27);
            try {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("text", this.aES.aJH.DZ());
                jSONObject4.put("content_type", "custom_live_notice");
                jSONObject4.put("category_msg_filter", "1");
                Li4.setContent(jSONObject4.toString());
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            this.mMsgList.add(Li4);
            if (this.bkr != null) {
                this.bkr.t(Li4);
            }
        }
        if (this.aES != null && this.aES.aJK != null && this.aES.aJK.aST != null && !StringUtils.isNull(this.aES.aJK.aST.content)) {
            com.baidu.live.im.data.a Li5 = Li();
            Li5.setMsgType(27);
            try {
                JSONObject jSONObject5 = new JSONObject();
                String str10 = this.aES.aJK.aST.content;
                String str11 = this.aES.aJK.aST.title;
                if (str10.length() > 100) {
                    str10 = str10.substring(0, 100) + "... 【详情可查看公告】";
                }
                jSONObject5.put("text", str11 + "：" + str10);
                jSONObject5.put("content_type", "play_rules");
                Li5.setContent(jSONObject5.toString());
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
            this.mMsgList.add(Li5);
            if (this.bkr != null) {
                this.bkr.t(Li5);
            }
        }
        Lf();
        if (this.mMsgList.size() > 0 && this.bkr != null) {
            this.bkr.d(this.mMsgList, true);
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGmsgGetLiveStatusUnabled()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.q.6
                @Override // java.lang.Runnable
                public void run() {
                    q.this.hF("enter");
                }
            }, 1000L);
        }
        Lb();
        if (TbadkCoreApplication.getInst().isOther()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913146, this.mMsgList));
        }
    }

    private void Lf() {
        if (Lg()) {
            com.baidu.live.im.data.a Li = Li();
            Li.setMsgType(27);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("text", com.baidu.live.aa.a.PQ().bod.aNl.aJh);
                jSONObject.put("content_type", "custom_im_notice_live_assistant");
                Li.setContent(jSONObject.toString());
                Li.setLink(com.baidu.live.aa.a.PQ().bod.aNl.aJg);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mMsgList.add(Li);
            if (this.bkr != null) {
                this.bkr.t(Li);
            }
        }
    }

    private boolean Lg() {
        return (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) || !TbadkCoreApplication.getCurrentAccount().equals(this.bhP) || com.baidu.live.aa.a.PQ().bod == null || com.baidu.live.aa.a.PQ().bod.aNl == null || TextUtils.isEmpty(com.baidu.live.aa.a.PQ().bod.aNl.aJh)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(List<com.baidu.live.im.data.a> list) {
        if (list != null && this.bkr != null) {
            this.bkr.d(this.mMsgList, true);
            for (com.baidu.live.im.data.a aVar : list) {
                this.bkr.t(aVar);
            }
        }
    }

    protected void N(List<com.baidu.live.im.data.a> list) {
        this.bhQ = list;
        this.bhS = (int) ((this.bhU * 2.0f) / 0.25f);
        this.bhT = 0;
        this.bhR = list.size() / this.bhS;
        if (this.bhR <= 0) {
            this.bhR = 1;
        }
        this.mHandler.removeCallbacks(this.bih);
        this.mHandler.postDelayed(this.bih, 250L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lh() {
        this.mHandler.removeCallbacks(this.bih);
        this.bhT = 0;
        this.bhS = 0;
        this.bhR = 0;
        this.bhQ = null;
    }

    protected List<com.baidu.live.im.data.a> b(List<com.baidu.live.im.data.a> list, boolean z) {
        return a(list, z, false);
    }

    protected List<com.baidu.live.im.data.a> a(List<com.baidu.live.im.data.a> list, boolean z, boolean z2) {
        for (com.baidu.live.im.data.a aVar : list) {
            if (aVar instanceof com.baidu.live.im.a) {
                ((com.baidu.live.im.a) aVar).hE(this.bhP);
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
        if (this.mMsgList.size() > com.baidu.live.aa.a.PQ().bod.aMZ) {
            int i = (int) (com.baidu.live.aa.a.PQ().bod.aMZ * 0.7d);
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
        com.baidu.live.data.a Mo = aVar.Mo();
        if (Mo != null && (list = Mo.aHG) != null && !list.isEmpty()) {
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
            d = com.baidu.live.aa.f.Qg().i(z, jSONObject.optString(LogConfig.LOG_GIFT_ID));
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
                        if (!TextUtils.isEmpty(optString) && (optString.equals("challenge_direct_start") || optString.equals("challenge_direct_matched") || optString.equals("challenge_random_start") || optString.equals("challenge_random_matched") || optString.equals("live_net_status") || optString.equals("send_redpacket") || optString.equals("start_grab_redpacket") || optString.equals("guard_seat") || optString.equals("challenge_mvp") || optString.equals("challenge_mvp_punish") || optString.equals("challenge_winner_by_autofail") || optString.equals("official_notice") || optString.equals("privilege_award_royal_success"))) {
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
                aVar.bZ(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.live.im.data.a aVar) {
        if (this.bhZ < this.bhJ) {
            if (i >= 0) {
                this.mMsgList.add(i, aVar);
            } else {
                this.mMsgList.addLast(aVar);
            }
        } else if (this.bhZ >= this.bhJ && this.bhZ < this.bhK) {
            if (q(aVar)) {
                if (!this.mMsgList.isEmpty() && q(this.mMsgList.getLast())) {
                    this.mMsgList.set(this.mMsgList.size() - 1, aVar);
                } else {
                    this.mMsgList.addLast(aVar);
                }
            } else if (i >= 0) {
                this.mMsgList.add(i, aVar);
            } else {
                this.mMsgList.addLast(aVar);
            }
        } else if (this.bhZ >= this.bhK && this.bhZ < this.bhL) {
            if (o(aVar)) {
                if (!this.mMsgList.isEmpty() && o(this.mMsgList.getLast())) {
                    this.mMsgList.set(this.mMsgList.size() - 1, aVar);
                } else {
                    this.mMsgList.addLast(aVar);
                }
            } else if (i >= 0) {
                this.mMsgList.add(i, aVar);
            } else {
                this.mMsgList.addLast(aVar);
            }
        } else if (this.bhZ >= this.bhL) {
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
        this.bia = 0;
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
                if (com.baidu.live.entereffect.a.Fg().h(aVar)) {
                    this.bia = 2;
                } else {
                    this.bia = 1;
                }
            } else {
                this.bia = 0;
            }
        }
        return this.bia;
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
                    if (aVar != null && aVar.Mo() != null && !TextUtils.isEmpty(aVar.Mo().userId) && aVar.Mo().userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        int i2 = size - 1;
                        while (true) {
                            if (i2 >= 0 && i2 >= 0) {
                                com.baidu.live.im.data.a aVar2 = list.get(i2);
                                if (aVar2 != null && aVar2.Mo() != null && !TextUtils.isEmpty(aVar2.Mo().userId) && aVar2.Mo().userId.equals(TbadkCoreApplication.getCurrentAccount()) && aVar.getRecordId() == aVar2.getRecordId()) {
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
            if (!ListUtils.isEmpty(aVar.Mq()) && !aVar.Mq().contains(Long.valueOf(currentAccountId))) {
                linkedList.add(aVar);
            } else {
                boolean z2 = aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                if (z2 && aVar.getMsgType() == 1 && !ListUtils.isEmpty(aVar.Mo().aHG) && this.aJA == null) {
                    this.aJA = aVar.Mo().aHG;
                }
                if (z2 && aVar.getMsgType() != 125 && aVar.getMsgType() != 24 && aVar.getMsgType() != 13 && aVar.getMsgType() != 28 && (aVar.getMsgType() != 1 || !z)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(aVar.getContent());
                        int optInt = jSONObject2.optInt("close_audio_room");
                        String optString = jSONObject2.optString("content_type");
                        if (optInt == 1 && "close_live".equals(optString)) {
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    linkedList.add(aVar);
                } else if (aVar.getMsgType() == 125) {
                    try {
                        if (!"1".equals(new JSONObject(aVar.getContent()).optString("is_first"))) {
                            linkedList.add(aVar);
                            if (this.bkr != null) {
                                this.bkr.t(aVar);
                            }
                        }
                    } catch (JSONException e2) {
                        BdLog.e(e2);
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
                    } catch (JSONException e3) {
                        linkedList.add(aVar);
                        str = null;
                    }
                    if ("enter_live".equals(str) && this.bhZ < this.bhL) {
                        if (com.baidu.live.entereffect.a.Fg().h(aVar)) {
                        }
                    } else if ("close_live".equals(str)) {
                        linkedList.add(aVar);
                        if (this.bkr != null) {
                            this.bkr.t(aVar);
                        }
                    } else if ("task".equals(str)) {
                        linkedList.add(aVar);
                        if (this.bkr != null) {
                            this.bkr.t(aVar);
                        }
                    } else if ("live_achievement".equals(str)) {
                        linkedList.add(aVar);
                        if (this.bkr != null) {
                            this.bkr.t(aVar);
                        }
                    } else if ("ss_hot_live".equals(str)) {
                        linkedList.add(aVar);
                        if (this.bkr != null) {
                            this.bkr.t(aVar);
                        }
                    } else if ("challenge_direct_new".equals(str)) {
                        linkedList.add(aVar);
                        if (this.bkr != null) {
                            this.bkr.t(aVar);
                        }
                    } else if ("challenge_random_cancel".equals(str)) {
                        linkedList.add(aVar);
                        if (this.bkr != null) {
                            this.bkr.t(aVar);
                        }
                    } else if ("update_liveinfo".equals(str)) {
                        linkedList.add(aVar);
                        if (this.bkr != null) {
                            this.bkr.t(aVar);
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
                        if (z2 && !ListUtils.isEmpty(aVar.Mo().aHG)) {
                            this.aJA = aVar.Mo().aHG;
                            if (this.aES != null) {
                                this.aES.aJA = this.aJA;
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
                                if (this.bkr != null) {
                                    this.bkr.t(aVar);
                                }
                            } else if ("introduce_goods".equals(str)) {
                                linkedList.add(aVar);
                                if (this.bkr != null) {
                                    this.bkr.t(aVar);
                                }
                            } else if ("first_recharge_success".equals(str)) {
                                linkedList.add(aVar);
                                if (this.bkr != null) {
                                    this.bkr.t(aVar);
                                }
                            } else if ("privilege_award_success".equals(str)) {
                                linkedList.add(aVar);
                                if (this.bkr != null) {
                                    this.bkr.t(aVar);
                                }
                            } else if ("need_update_live_mark_info".equals(str)) {
                                linkedList.add(aVar);
                                if (this.bkr != null) {
                                    this.bkr.t(aVar);
                                }
                            } else if ("official_notice".equals(str)) {
                                linkedList.add(aVar);
                            } else if (TextUtils.equals(str, "privilege_award_royal_success")) {
                                Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                            } else if (!TextUtils.equals(str, "add_tags_to_anchor")) {
                                if (TextUtils.equals(str, "audio_emoticon")) {
                                    if (z2 && !z) {
                                        linkedList.add(aVar);
                                    }
                                } else if (!TextUtils.equals(str, "follow_anchor_phone") && !TextUtils.equals(str, "follow_room")) {
                                    if (TextUtils.equals(str, "audio_link_toast")) {
                                        try {
                                            if (new JSONObject(aVar.getContent()).optJSONObject("data").optInt("force_xiangqin_update") == 1) {
                                                linkedList.add(aVar);
                                            }
                                        } catch (JSONException e4) {
                                            e4.printStackTrace();
                                        }
                                    } else if (!TextUtils.equals(str, "live_audio_audit_notice") && !TextUtils.equals(str, "sync_audio_speeker_status") && !TextUtils.equals(str, "audio_hat_level_toast") && !TextUtils.equals(str, "audio_hat_user_toast") && !TextUtils.equals(str, "audio_loot_gift") && !TextUtils.equals(str, "switch_activity_stage") && !TextUtils.equals(str, "audio_link_online")) {
                                        linkedList.add(aVar);
                                    }
                                }
                            }
                        }
                    }
                } else if (aVar.getMsgType() == 12) {
                    linkedList.add(aVar);
                    if (this.bkr != null) {
                        this.bkr.t(aVar);
                    }
                    hF("push");
                }
            }
        }
        if (linkedList.size() > 0) {
            list.removeAll(linkedList);
        }
    }

    protected com.baidu.live.im.data.a a(short s, String str, boolean z, boolean z2, int i, String str2, List<AlaLiveMarkData> list) {
        long j = 0;
        com.baidu.live.im.data.a Li = Li();
        if (Li == null) {
            return null;
        }
        Li.setMsgType(s);
        Li.setContent(str);
        long av = o.av(getLastMid());
        Li.blH = str2;
        Li.setMsgId(av);
        Li.setRecordId(av);
        Li.setTime(System.currentTimeMillis() / 1000);
        com.baidu.live.data.a aVar = new com.baidu.live.data.a();
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            aVar.userName = TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow();
        }
        aVar.userId = TbadkCoreApplication.getCurrentAccount();
        aVar.portrait = TbadkCoreApplication.getCurrentPortrait();
        aVar.level_id = i;
        aVar.aHD = z;
        aVar.aHE = z2;
        if (list != null) {
            aVar.aHG = new ArrayList(list);
        }
        Li.e(aVar);
        try {
            j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        } catch (Exception e) {
        }
        Li.setUserId(j);
        return Li;
    }

    private long getLastMid() {
        if (this.mMsgList == null || this.mMsgList.size() <= 0) {
            return JavaTypesHelper.toLong(this.bhO, 1L);
        }
        return this.mMsgList.get(this.mMsgList.size() - 1).getMsgId();
    }

    protected com.baidu.live.im.data.a Li() {
        com.baidu.live.im.a aVar = new com.baidu.live.im.a();
        aVar.setBornTime(System.currentTimeMillis());
        if (TextUtils.isEmpty(this.mGroupId)) {
            return null;
        }
        aVar.hE(this.bhP);
        return aVar;
    }

    public void Q(List<AlaLiveMarkData> list) {
        this.aJA = list;
    }

    public void hF(String str) {
        com.baidu.live.message.b bVar = new com.baidu.live.message.b(JavaTypesHelper.toLong(this.mLiveId, 0L), str);
        bVar.setParams();
        sendMessage(bVar);
    }

    public void hG(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.bhV)) {
            hF("getliveinfo");
        }
    }

    private List<com.baidu.live.im.data.a> r(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        int optInt;
        boolean Ga;
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
            com.baidu.live.gift.g hc = aa.hc(jSONObject.optString(LogConfig.LOG_GIFT_ID));
            Ga = hc != null ? hc.Ga() : false;
        } catch (JSONException e) {
            arrayList.add(aVar2);
        }
        if (optInt == 1 || Ga) {
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
            aVar3.hE(aVar2.KY());
            aVar3.setBornTime(aVar2.getBornTime());
            aVar3.setTime(aVar2.getTime());
            aVar3.setUserId(aVar2.getUserId());
            aVar3.setToUserId(aVar2.getToUserId());
            aVar3.f(aVar2.Mp());
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
            aVar3.e(aVar2.Mo());
            aVar3.setSt_type(aVar2.getSt_type());
            arrayList.add(aVar3);
        }
        return arrayList;
    }

    public void a(int i, String str, com.baidu.live.data.a aVar) {
        com.baidu.live.im.data.a Li = Li();
        if (Li != null) {
            Li.setMsgType(i);
            Li.setContent(str);
            Li.e(aVar);
            a(-1, Li);
            if (this.bkr != null) {
                this.bkr.d(this.mMsgList, true);
                this.bkr.t(Li);
            }
        }
    }

    private void b(List<com.baidu.live.im.data.a> list, int i) {
        JSONObject jSONObject;
        int i2;
        if (this.bib) {
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
                            com.baidu.live.data.a Mo = aVar.Mo();
                            if (Mo == null || StringUtils.isNull(Mo.userId) || StringUtils.isNull(optString)) {
                                if (i >= 0) {
                                    a(i + i4, aVar);
                                } else {
                                    a(-1, aVar);
                                }
                            } else {
                                String str = Mo.userId;
                                Mo.getNameShow();
                                String A = com.baidu.live.utils.r.A(optString, str, aVar.bku);
                                if (this.bic == null) {
                                    this.bic = new LinkedHashMap<>();
                                }
                                long j = JavaTypesHelper.toLong(jSONObject.optString("gift_count"), 0L);
                                double optDouble = jSONObject.optDouble("gift_rate", 0.0d);
                                long j2 = JavaTypesHelper.toLong(jSONObject.optString("charm_value"), 0L);
                                jSONObject.optString("gift_url");
                                jSONObject.optString("gift_name");
                                r rVar = new r();
                                rVar.bkv = new ArrayList();
                                rVar.giftId = optString;
                                rVar.bku = aVar.bku;
                                for (r.a aVar2 : com.baidu.live.utils.r.iH(aVar.bku)) {
                                    r.a aVar3 = new r.a();
                                    aVar3.bjR = aVar.clone();
                                    aVar3.bjU = optDouble;
                                    aVar3.count = j;
                                    aVar3.bkw = aVar2.name;
                                    aVar3.bjT = j2;
                                    rVar.bkv.add(aVar3);
                                }
                                if (com.baidu.live.aa.a.PQ().bod == null) {
                                    i2 = 100;
                                } else {
                                    i2 = com.baidu.live.aa.a.PQ().bod.aNf * 2;
                                }
                                Iterator<String> it = this.bic.keySet().iterator();
                                int i5 = 0;
                                while (it.hasNext()) {
                                    String next = it.next();
                                    if (this.bic.get(next) == null || this.bic.get(next).isEmpty()) {
                                        it.remove();
                                    } else {
                                        HashMap<Long, r> hashMap = this.bic.get(next);
                                        Iterator<Long> it2 = hashMap.keySet().iterator();
                                        while (it2.hasNext()) {
                                            long longValue = it2.next().longValue();
                                            if (hashMap.get(Long.valueOf(longValue)) == null || hashMap.get(Long.valueOf(longValue)).bjX) {
                                                it2.remove();
                                            }
                                        }
                                        if (this.bic.get(next) == null || this.bic.get(next).isEmpty()) {
                                            it.remove();
                                        } else {
                                            i5 = hashMap.size() + i5;
                                        }
                                    }
                                }
                                if (i5 > i2) {
                                    int i6 = i5 - ((int) (i2 * 0.7d));
                                    Iterator<String> it3 = this.bic.keySet().iterator();
                                    while (true) {
                                        int i7 = i6;
                                        if (!it3.hasNext()) {
                                            break;
                                        }
                                        i6 = i7 - this.bic.get(it3.next()).size();
                                        it3.remove();
                                        if (i6 <= 0) {
                                            break;
                                        }
                                    }
                                }
                                if (!this.bic.containsKey(A)) {
                                    HashMap<Long, r> hashMap2 = new HashMap<>();
                                    hashMap2.put(Long.valueOf(aVar.getMsgId()), rVar);
                                    this.bic.put(A, hashMap2);
                                } else {
                                    this.bic.get(A).put(Long.valueOf(aVar.getMsgId()), rVar);
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
            String A = com.baidu.live.utils.r.A(str, TbadkCoreApplication.getCurrentAccount(), str2);
            HashMap<Long, r> hashMap = this.bie.get(A);
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
                            if (next.bjY.contains(l)) {
                                rVar = next;
                                break;
                            }
                        }
                    }
                    if (rVar != null) {
                        long longValue = map.get(l).longValue();
                        if (z) {
                            rVar.bjS = longValue + rVar.bjS;
                        }
                        if (rVar.bjX) {
                            hashMap.remove(Long.valueOf(rVar.aVA));
                            for (r.a aVar : rVar.bkv) {
                                aVar.bjR.aw(aVar.count);
                                aVar.bjR.o(aVar.bjU);
                                aVar.bjR.ax(aVar.bjT);
                                a(-1, aVar.bjR);
                                if (this.bkr != null) {
                                    this.bkr.d(this.mMsgList, true);
                                }
                                long j3 = rVar.bjS;
                                if (j3 > 0) {
                                    f(j3, aVar.giftName);
                                }
                            }
                        }
                    }
                }
                if (hashMap.isEmpty()) {
                    this.bie.remove(A);
                }
            }
        }
    }

    public void CM() {
        this.mGroupId = null;
        this.bhO = null;
        this.mLiveId = null;
        this.bhV = "0";
        this.mAppId = null;
        this.bhX = false;
        this.bhY = false;
        MessageManager.getInstance().unRegisterListener(this.bis);
        MessageManager.getInstance().unRegisterListener(this.bir);
        MessageManager.getInstance().unRegisterListener(this.bij);
        MessageManager.getInstance().unRegisterListener(this.bim);
        MessageManager.getInstance().unRegisterListener(this.bin);
        MessageManager.getInstance().unRegisterListener(this.bip);
        MessageManager.getInstance().unRegisterListener(this.biq);
        MessageManager.getInstance().unRegisterListener(this.bik);
        MessageManager.getInstance().unRegisterListener(this.biu);
        MessageManager.getInstance().unRegisterListener(this.biv);
        MessageManager.getInstance().unRegisterListener(this.biw);
        MessageManager.getInstance().unRegisterListener(this.bix);
        MessageManager.getInstance().unRegisterListener(this.bit);
        MessageManager.getInstance().unRegisterListener(this.bks);
        this.mHandler.removeCallbacks(this.bii);
        this.mHandler.removeCallbacks(this.bih);
        this.mHandler.removeCallbacks(this.bil);
        if (this.mMsgList != null) {
            this.mMsgList.clear();
        }
        this.mMsgList = null;
        if (this.bic != null) {
            this.bic.clear();
        }
        if (this.bie != null) {
            this.bie.clear();
        }
    }

    private void Lj() {
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
            com.baidu.live.im.data.a a2 = a(s, str2, z, z2, i, "", this.aJA);
            if (s == 126) {
                a2.eL(imSendMsgData.barrageType);
                a2.hL(imSendMsgData.barrageId);
                a2.a(imSendMsgData.barrageCardInfo);
            }
            Log.i("i", "@@@ localText limmdl sm cm=" + a2);
            if (a2 != null) {
                a2.l(strArr);
                a(-1, a2);
                if (this.bkr != null) {
                    Log.i("i", "@@@ localText limmdl sm recv");
                    this.bkr.t(a2);
                    this.bkr.d(this.mMsgList, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913043));
                com.baidu.live.im.message.a aVar = new com.baidu.live.im.message.a(str2, s, JavaTypesHelper.toInt(this.mGroupId, 0), this.mAppId);
                if (this.aES != null && this.aES.mLiveInfo != null && this.aES.aJK != null) {
                    aVar.setLiveId(this.aES.mLiveInfo.live_id + "");
                    aVar.setRoomId(this.aES.mLiveInfo.room_id + "");
                    aVar.eM(1);
                    aVar.setCustomRoomId(this.aES.aJK.croom_id);
                } else {
                    aVar.setLiveId("");
                    aVar.setRoomId("");
                }
                aVar.setOtherParams(str);
                aVar.ay(imSendMsgData.price);
                aVar.eL(imSendMsgData.barrageType);
                aVar.hL(imSendMsgData.barrageId);
                aVar.a(imSendMsgData.barrageCardInfo);
                aVar.l(strArr);
                aVar.ca(imSendMsgData.isQuick);
                sendMessage(aVar);
            }
        }
    }

    public void f(String str, long j) {
        Log.i("i", "@@@ localText limm sdreq uk=" + str + ",lvd=" + j + ",iibr=" + this.bhX);
        if (!this.bhX) {
            this.bhX = true;
            Log.i("i", "@@@ localText limm sdreq go");
            com.baidu.live.im.message.c cVar = new com.baidu.live.im.message.c(1031054);
            cVar.addParam("uk", str);
            cVar.addParam("live_id", j);
            cVar.az(System.currentTimeMillis());
            sendMessage(cVar);
            this.mHandler.postDelayed(this.bii, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lk() {
        Log.i("i", "@@@ localText limm sdreq out");
        this.bhX = false;
        this.bhY = true;
        YuyinImForbiddenStateData yuyinImForbiddenStateData = new YuyinImForbiddenStateData();
        yuyinImForbiddenStateData.errno = -1;
        yuyinImForbiddenStateData.errMsg = this.mPageContext.getString(a.h.sdk_neterror);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, yuyinImForbiddenStateData));
    }

    private void S(List<com.baidu.live.im.data.a> list) {
        if (!ListUtils.isEmpty(list)) {
            for (com.baidu.live.im.data.a aVar : list) {
                if (aVar != null) {
                    if (aVar.getMsgType() == 13) {
                        try {
                            JSONObject jSONObject = new JSONObject(aVar.getContent());
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
                    } else if (aVar.getMsgType() == 24) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(aVar.getContent());
                            if (jSONObject2 != null) {
                                aVar.bku = jSONObject2.optString("benefit_info");
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
