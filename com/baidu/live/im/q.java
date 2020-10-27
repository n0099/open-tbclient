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
import com.baidu.live.gift.ab;
import com.baidu.live.gift.am;
import com.baidu.live.gift.an;
import com.baidu.live.gift.ao;
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
    private w aEc;
    private List<AlaLiveMarkData> aIJ;
    private int bgA;
    private float bgB;
    private String bgC;
    private boolean bgE;
    private boolean bgF;
    private int bgG;
    private int bgH;
    private boolean bgI;
    private LinkedHashMap<String, HashMap<Long, r>> bgJ;
    private HashMap<String, HashMap<Long, r>> bgK;
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
    private String bgv;
    private String bgw;
    private List<com.baidu.live.im.data.a> bgx;
    private int bgy;
    private int bgz;
    CustomMessageListener bha;
    CustomMessageListener bhb;
    private HttpMessageListener bhc;
    private a biY;
    private long count;
    private String mAppId;
    private String mGroupId;
    private Handler mHandler;
    private String mLiveId;
    private LinkedList<com.baidu.live.im.data.a> mMsgList;
    BdPageContext<?> mPageContext;

    /* loaded from: classes4.dex */
    public interface a {
        void KL();

        void d(List<com.baidu.live.im.data.a> list, boolean z);

        void s(com.baidu.live.im.data.a aVar);
    }

    static /* synthetic */ int h(q qVar) {
        int i = qVar.bgA;
        qVar.bgA = i + 1;
        return i;
    }

    public q(BdPageContext<?> bdPageContext, boolean z, a aVar) {
        super(bdPageContext);
        this.mLiveId = null;
        this.bgB = 1.0f;
        this.mHandler = new Handler();
        this.bgC = null;
        this.bgE = false;
        this.bgF = false;
        this.bgH = 0;
        this.bgI = false;
        this.bgL = new b.a() { // from class: com.baidu.live.im.q.1
        };
        this.bgM = new Runnable() { // from class: com.baidu.live.im.q.12
            @Override // java.lang.Runnable
            public void run() {
                int i = q.this.bgA * q.this.bgy;
                if (i >= q.this.bgx.size()) {
                    q.this.KH();
                } else if (q.this.bgA >= q.this.bgz - 1) {
                    if (q.this.bgA != q.this.bgz - 1) {
                        q.this.KH();
                        return;
                    }
                    ArrayList arrayList = new ArrayList(q.this.bgx);
                    q.this.M(q.this.b(arrayList.subList(i, arrayList.size()), true));
                    q.h(q.this);
                    q.this.KH();
                } else {
                    ArrayList arrayList2 = new ArrayList(q.this.bgx);
                    if (q.this.bgy + i <= arrayList2.size()) {
                        q.this.M(q.this.b(arrayList2.subList(i, q.this.bgy + i), true));
                        q.h(q.this);
                        q.this.mHandler.postDelayed(q.this.bgM, 250L);
                        return;
                    }
                    q.this.M(q.this.b(arrayList2.subList(i, arrayList2.size()), true));
                    q.h(q.this);
                    q.this.KH();
                }
            }
        };
        this.bgN = new Runnable() { // from class: com.baidu.live.im.q.13
            @Override // java.lang.Runnable
            public void run() {
                q.this.KK();
            }
        };
        this.bgO = new CustomMessageListener(MessageConfig.SOCKET_RECEIVE_MSG) { // from class: com.baidu.live.im.q.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                q.this.KD();
            }
        };
        this.bgP = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.live.im.q.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        com.baidu.live.im.a aVar2 = new com.baidu.live.im.a();
                        aVar2.setMsgType(27);
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("text", q.this.mPageContext.getString(a.i.sdk_im_offline));
                            jSONObject.put("content_type", "custom_network_change");
                            aVar2.setContent(jSONObject.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        q.this.a(-1, aVar2);
                        if (q.this.biY != null) {
                            q.this.biY.s(aVar2);
                            q.this.biY.d(q.this.mMsgList, true);
                        }
                    } else if (((NetWorkChangedMessage) customResponsedMessage).mLastNetState == 0 && BdNetTypeUtil.isNetWorkAvailable()) {
                        com.baidu.live.im.a aVar3 = new com.baidu.live.im.a();
                        aVar3.setMsgType(27);
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("text", q.this.mPageContext.getString(a.i.sdk_im_online));
                            jSONObject2.put("content_type", "custom_network_change");
                            aVar3.setContent(jSONObject2.toString());
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        q.this.a(-1, aVar3);
                        if (q.this.biY != null) {
                            q.this.biY.s(aVar3);
                            q.this.biY.d(q.this.mMsgList, true);
                        }
                    }
                }
            }
        };
        this.bgQ = new Runnable() { // from class: com.baidu.live.im.q.16
            @Override // java.lang.Runnable
            public void run() {
                if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().getLastReceDataTime() > 35000) {
                    q.this.KC();
                }
                q.this.KB();
            }
        };
        this.bgR = new HttpMessageListener(1021013) { // from class: com.baidu.live.im.q.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    boolean z2 = false;
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        int error = httpResponsedMessage.getError();
                        if (com.baidu.live.z.a.Pq().bmJ.aMo == 1) {
                            if (error == 149010) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913070, q.this.mPageContext.getPageActivity().getString(a.i.im_improper_content_tip)));
                                z2 = true;
                            } else if (error == 1202 || error == 1203) {
                                BdUtilHelper.showToast(q.this.mPageContext.getPageActivity(), q.this.mPageContext.getPageActivity().getString(a.i.im_improper_content_tip_net));
                                z2 = true;
                            } else if (error == 1204) {
                                BdUtilHelper.showToast(q.this.mPageContext.getPageActivity(), q.this.mPageContext.getPageActivity().getString(a.i.im_improper_content_tip));
                                z2 = true;
                            }
                        }
                    }
                    if (!z2 && q.this.biY != null) {
                        q.this.biY.KL();
                    }
                }
            }
        };
        this.bgS = new HttpMessageListener(1031055) { // from class: com.baidu.live.im.q.18
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
                            if (!q.this.bgI) {
                                q.this.e(amVar.aUe, amVar.giftName);
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                        }
                        if (q.this.bgI) {
                            q.this.a(amVar.giftId, amVar.aUe, amVar.aUi, amVar.aVt, z2, amVar.aUk);
                        }
                    }
                }
            }
        };
        this.bgT = new HttpMessageListener(1031056) { // from class: com.baidu.live.im.q.19
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
                            if (!q.this.bgI) {
                                q.this.e(anVar.aUe, anVar.giftName);
                            }
                        } else {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                        }
                        if (q.this.bgI) {
                            q.this.a(anVar.giftId, anVar.aUe, anVar.aUi, anVar.aVt, z2, anVar.aUk);
                        }
                    }
                }
            }
        };
        this.bgU = new HttpMessageListener(1031057) { // from class: com.baidu.live.im.q.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                boolean z2;
                boolean z3;
                if (httpResponsedMessage != null) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof ao) {
                        ao aoVar = (ao) orginalMessage;
                        if ((httpResponsedMessage instanceof YuyinGiftPackageConsumeHttpResponsedMessage) && TextUtils.isEmpty(((YuyinGiftPackageConsumeHttpResponsedMessage) httpResponsedMessage).aVg)) {
                            if (!q.this.bgI) {
                                q.this.e(aoVar.aUO, aoVar.giftName);
                            }
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            if (!q.this.bgI) {
                                q.this.e(aoVar.aUO, aoVar.giftName);
                            }
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (q.this.bgI) {
                            q.this.a(aoVar.giftId, aoVar.aUO, aoVar.aUi, aoVar.aVu, z3, aoVar.aUk);
                        }
                    }
                }
            }
        };
        this.bgV = new HttpMessageListener(1021012) { // from class: com.baidu.live.im.q.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                q.this.a((ResponsedMessage<?>) httpResponsedMessage, false);
            }
        };
        this.bgW = new NetMessageListener(1031043, 601008) { // from class: com.baidu.live.im.q.4
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
                        if (!TextUtils.isEmpty(((AlaGetAudioLiveStatusHttpResponseMessage) responsedMessage).bmz)) {
                            jSONObject = new JSONObject(alaGetAudioLiveStatusHttpResponseMessage.bmz);
                            jSONObject2 = jSONObject;
                            if (jSONObject2 == null) {
                                if (!"backstage_live".equals(jSONObject2.optString("content_type"))) {
                                    q.this.a(alaGetAudioLiveStatusHttpResponseMessage.bmz, jSONObject2, 12, false);
                                    return;
                                }
                                String optString = jSONObject2.optString("backstage_type");
                                if (!TextUtils.isEmpty(optString) && !optString.equals(q.this.bgC)) {
                                    q.this.a(alaGetAudioLiveStatusHttpResponseMessage.bmz, jSONObject2, 13, true);
                                    q.this.bgC = optString;
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
        this.bgX = new CustomMessageListener(2913192) { // from class: com.baidu.live.im.q.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText banlstn sd=" + q.this.aEc);
                if (q.this.aEc != null) {
                    if (q.this.aEc.mLiveInfo.getUserID() == Long.valueOf(TbadkCoreApplication.getCurrentAccount()).longValue()) {
                        Log.i("i", "@@@ localText banlstn own");
                        if (q.this.aEc.aIe != null && q.this.aEc.mLiveInfo != null) {
                            Log.i("i", "@@@ localText banlstn own sdreq");
                            q.this.g(q.this.aEc.aIe.userUk, q.this.aEc.mLiveInfo.live_id);
                            return;
                        }
                        return;
                    }
                    Log.i("i", "@@@ localText banlstn oth");
                    if (q.this.aEc.aIA != null && q.this.aEc.mLiveInfo != null) {
                        Log.i("i", "@@@ localText banlstn oth sdreq");
                        q.this.g(q.this.aEc.aIA.userUk, q.this.aEc.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.bgY = new CustomMessageListener(2913185) { // from class: com.baidu.live.im.q.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                r rVar;
                if (q.this.bgI) {
                    if (q.this.bgK == null) {
                        q.this.bgK = new HashMap();
                    }
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r) && (rVar = (r) customResponsedMessage.getData()) != null && rVar.bjb != null && rVar.bjb.size() > 0) {
                        String A = com.baidu.live.utils.r.A(rVar.giftId, rVar.userId, rVar.bja);
                        for (r.a aVar2 : rVar.bjb) {
                            com.baidu.live.im.data.a a2 = q.this.a(aVar2.giftId, aVar2.aUh, aVar2.count + "", aVar2.giftName, 0L, aVar2.biC, aVar2.bjc);
                            if (a2 != null) {
                                double m = q.this.m(a2);
                                a2.setMsgId(0L);
                                a2.setRecordId(0L);
                                com.baidu.live.data.a LO = a2.LO();
                                if (LO != null && !StringUtils.isNull(LO.userId) && !StringUtils.isNull(aVar2.giftId)) {
                                    aVar2.biy = a2;
                                    aVar2.biB = m;
                                } else {
                                    return;
                                }
                            }
                        }
                        if (!q.this.bgK.containsKey(A)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put(Long.valueOf(rVar.aUi), rVar);
                            q.this.bgK.put(A, hashMap);
                            return;
                        }
                        ((HashMap) q.this.bgK.get(A)).put(Long.valueOf(rVar.aUi), rVar);
                    }
                }
            }
        };
        this.bgZ = new CustomMessageListener(2913184) { // from class: com.baidu.live.im.q.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof s)) {
                    s sVar = (s) customResponsedMessage.getData();
                    if (sVar.biH > 0) {
                        HashMap hashMap = (HashMap) q.this.bgJ.get(sVar.aZK);
                        if (hashMap != null && !hashMap.isEmpty()) {
                            r rVar = (r) hashMap.remove(Long.valueOf(sVar.biH));
                            if (rVar != null && rVar.bjb != null && rVar.bjb.size() > 0) {
                                rVar.biE = true;
                                while (true) {
                                    int i2 = i;
                                    if (i2 >= rVar.bjb.size()) {
                                        break;
                                    }
                                    r.a aVar2 = rVar.bjb.get(i2);
                                    aVar2.biy.ak(aVar2.count);
                                    aVar2.biy.o(aVar2.biB);
                                    aVar2.biy.bkn = aVar2.bjc;
                                    aVar2.biy.al(aVar2.biA);
                                    q.this.a(-1, aVar2.biy);
                                    if (q.this.biY != null) {
                                        q.this.biY.d(q.this.mMsgList, true);
                                    }
                                    i = i2 + 1;
                                }
                            }
                            if (hashMap.isEmpty()) {
                                q.this.bgJ.remove(sVar.aZK);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    HashMap hashMap2 = (HashMap) q.this.bgK.get(sVar.aZK);
                    if (hashMap2 != null && !hashMap2.isEmpty()) {
                        r rVar2 = (r) hashMap2.get(Long.valueOf(sVar.biJ));
                        if (rVar2 != null && rVar2.bjb != null && rVar2.bjb.size() > 0) {
                            hashMap2.remove(Long.valueOf(sVar.biJ));
                            while (true) {
                                int i3 = i;
                                if (i3 >= rVar2.bjb.size()) {
                                    break;
                                }
                                r.a aVar3 = rVar2.bjb.get(i3);
                                aVar3.biy.ak(aVar3.count);
                                aVar3.biy.o(aVar3.biB);
                                aVar3.biy.al(aVar3.biA);
                                aVar3.biy.bkn = aVar3.bjc;
                                q.this.a(-1, aVar3.biy);
                                if (q.this.biY != null) {
                                    q.this.biY.d(q.this.mMsgList, true);
                                }
                                long j = rVar2.biz;
                                if (j > 0) {
                                    q.this.e(j, aVar3.giftName);
                                }
                                i = i3 + 1;
                            }
                        }
                        if (hashMap2.isEmpty()) {
                            q.this.bgK.remove(sVar.aZK);
                        }
                    }
                }
            }
        };
        this.bha = new CustomMessageListener(2913183) { // from class: com.baidu.live.im.q.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i = 0;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof s)) {
                    s sVar = (s) customResponsedMessage.getData();
                    if (sVar.biH == 0) {
                        HashMap hashMap = (HashMap) q.this.bgK.get(sVar.aZK);
                        if (hashMap != null && !hashMap.isEmpty()) {
                            r rVar = (r) hashMap.get(Long.valueOf(sVar.biJ));
                            r rVar2 = (r) hashMap.get(Long.valueOf(sVar.biM));
                            if (rVar != null && rVar2 != null) {
                                hashMap.remove(Long.valueOf(sVar.biM));
                                if (rVar.bjb != null && rVar2.bjb != null && rVar.bjb.size() == rVar2.bjb.size()) {
                                    rVar.biz += rVar2.biz;
                                    while (i < rVar.bjb.size()) {
                                        rVar.bjb.get(i).count += rVar2.bjb.get(i).count;
                                        rVar.bjb.get(i).biA += rVar2.bjb.get(i).biA;
                                        if (rVar.bjb.get(i).biB != rVar2.bjb.get(i).biB) {
                                            rVar.bjb.get(i).biB = 0.0d;
                                        }
                                        i++;
                                    }
                                    rVar.biF.add(Long.valueOf(rVar2.aUi));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    HashMap hashMap2 = (HashMap) q.this.bgJ.get(sVar.aZK);
                    if (hashMap2 != null && !hashMap2.isEmpty()) {
                        r rVar3 = (r) hashMap2.get(Long.valueOf(sVar.biH));
                        r rVar4 = (r) hashMap2.remove(Long.valueOf(sVar.biK));
                        if (rVar3 != null && rVar4 != null && rVar3.bjb != null && rVar4.bjb != null && rVar3.bjb.size() == rVar4.bjb.size()) {
                            while (i < rVar3.bjb.size()) {
                                rVar3.bjb.get(i).count += rVar4.bjb.get(i).count;
                                rVar3.bjb.get(i).biA += rVar4.bjb.get(i).biA;
                                if (rVar3.bjb.get(i).biB != rVar4.bjb.get(i).biB) {
                                    rVar3.bjb.get(i).biB = 0.0d;
                                }
                                i++;
                            }
                        }
                    }
                }
            }
        };
        this.bhb = new CustomMessageListener(2913195) { // from class: com.baidu.live.im.q.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                HashMap hashMap;
                r rVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof s)) {
                    s sVar = (s) customResponsedMessage.getData();
                    if (sVar.biH != 0 && (hashMap = (HashMap) q.this.bgJ.get(sVar.aZK)) != null && !hashMap.isEmpty() && (rVar = (r) hashMap.get(Long.valueOf(sVar.biH))) != null && rVar.bjb != null) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < rVar.bjb.size()) {
                                r.a aVar2 = rVar.bjb.get(i2);
                                if (sVar.bjd != null && sVar.bjd.size() > i2) {
                                    aVar2.count = sVar.bjd.get(i2).biN;
                                    aVar2.biA = sVar.bjd.get(i2).biO;
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
        this.bhc = new HttpMessageListener(1031054) { // from class: com.baidu.live.im.q.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                q.this.bgE = false;
                Log.i("i", "@@@ localText gtibslist 1");
                q.this.mHandler.removeCallbacks(q.this.bgN);
                if (httpResponsedMessage != null) {
                    if (httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.im.message.c) && ((com.baidu.live.im.message.c) httpResponsedMessage.getOrginalMessage()).ao(System.currentTimeMillis())) {
                        Log.i("i", "@@@ localText gtibslist out");
                        q.this.bgF = false;
                        return;
                    }
                    Log.i("i", "@@@ localText gtibslist ta=" + q.this.bgF);
                    if (q.this.bgF) {
                        q.this.bgF = false;
                    } else if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        Log.i("i", "@@@ localText gtibslist err he=" + httpResponsedMessage.hasError() + ", err=" + httpResponsedMessage.getError());
                        YuyinImForbiddenStateData yuyinImForbiddenStateData = new YuyinImForbiddenStateData();
                        yuyinImForbiddenStateData.errno = httpResponsedMessage.getError();
                        yuyinImForbiddenStateData.errMsg = httpResponsedMessage.getErrorString();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, yuyinImForbiddenStateData));
                    } else {
                        Log.i("i", "@@@ localText gtibslist suc");
                        if (httpResponsedMessage instanceof YuyinAlaForbiddenWordsStateResponseMessage) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913193, ((YuyinAlaForbiddenWordsStateResponseMessage) httpResponsedMessage).bkz));
                        }
                    }
                }
            }
        };
        this.bgp = com.baidu.live.z.a.Pq().bmJ.aMp;
        this.bgq = com.baidu.live.z.a.Pq().bmJ.aMq;
        this.bgr = com.baidu.live.z.a.Pq().bmJ.aMr;
        this.mPageContext = bdPageContext;
        this.bgt = z;
        this.biY = aVar;
        this.mMsgList = new LinkedList<>();
        this.bgJ = new LinkedHashMap<>();
        this.bgK = new HashMap<>();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501043, Object.class);
        if (runTask != null && runTask.getData() != null) {
            this.bgI = true;
        }
        MessageManager.getInstance().registerTask(KA());
        com.baidu.live.tieba.f.a.a.a(1031043, "ala/audio/live/getLiveStatus", AlaGetAudioLiveStatusHttpResponseMessage.class, false, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021012, "alaim/gmsg/getGroupMsg", ALAGroupHttpResponseMessage.class, false, true, true, true);
        KJ();
        registerListener(this.bhc);
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
        com.baidu.live.im.data.a a2 = a((short) 27, String.format(this.mPageContext.getString(a.i.sdk_send_gift_fail_yuyin), Long.valueOf(j), str), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), "", this.aIJ);
        if (a2 != null) {
            a(-1, a2);
            if (this.biY != null) {
                this.biY.s(a2);
                this.biY.d(this.mMsgList, true);
            }
        }
    }

    public com.baidu.live.im.data.a a(String str, String str2, String str3, String str4, long j, boolean z, String str5) {
        return a((short) 24, a(str, str2, TextUtils.isEmpty(str3) ? "1" : str3, TextUtils.isEmpty(str4) ? this.mPageContext.getString(a.i.sdk_gift) : str4, j, z).toString(), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), str5, this.aIJ);
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
        if (this.biY != null) {
            this.biY.s(aVar);
            if (z) {
                this.biY.d(this.mMsgList, true);
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
        MessageManager.getInstance().registerListener(this.bgU);
        MessageManager.getInstance().registerListener(this.bgT);
        MessageManager.getInstance().registerListener(this.bgY);
        MessageManager.getInstance().registerListener(this.bgZ);
        MessageManager.getInstance().registerListener(this.bha);
        MessageManager.getInstance().registerListener(this.bhb);
        MessageManager.getInstance().registerListener(this.bgX);
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
            if (this.biY != null) {
                this.biY.s(KI);
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
                    if (this.biY != null) {
                        this.biY.s(KI3);
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
                jSONObject4.put("category_msg_filter", "1");
                KI4.setContent(jSONObject4.toString());
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            this.mMsgList.add(KI4);
            if (this.biY != null) {
                this.biY.s(KI4);
            }
        }
        if (this.aEc != null && this.aEc.aIS != null && this.aEc.aIS.aRC != null && !StringUtils.isNull(this.aEc.aIS.aRC.content)) {
            com.baidu.live.im.data.a KI5 = KI();
            KI5.setMsgType(27);
            try {
                JSONObject jSONObject5 = new JSONObject();
                String str10 = this.aEc.aIS.aRC.content;
                String str11 = this.aEc.aIS.aRC.title;
                if (str10.length() > 100) {
                    str10 = str10.substring(0, 100) + "... 【详情可查看公告】";
                }
                jSONObject5.put("text", str11 + "：" + str10);
                jSONObject5.put("content_type", "play_rules");
                KI5.setContent(jSONObject5.toString());
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
            this.mMsgList.add(KI5);
            if (this.biY != null) {
                this.biY.s(KI5);
            }
        }
        KF();
        if (this.mMsgList.size() > 0 && this.biY != null) {
            this.biY.d(this.mMsgList, true);
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGmsgGetLiveStatusUnabled()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.q.5
                @Override // java.lang.Runnable
                public void run() {
                    q.this.hy("enter");
                }
            }, 1000L);
        }
        KB();
        if (TbadkCoreApplication.getInst().isOther()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913146, this.mMsgList));
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
            if (this.biY != null) {
                this.biY.s(KI);
            }
        }
    }

    private boolean KG() {
        return (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) || !TbadkCoreApplication.getCurrentAccount().equals(this.bgw) || com.baidu.live.z.a.Pq().bmJ == null || com.baidu.live.z.a.Pq().bmJ.aMl == null || TextUtils.isEmpty(com.baidu.live.z.a.Pq().bmJ.aMl.aIq)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(List<com.baidu.live.im.data.a> list) {
        if (list != null && this.biY != null) {
            this.biY.d(this.mMsgList, true);
            for (com.baidu.live.im.data.a aVar : list) {
                this.biY.s(aVar);
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
        } else if (this.bgG >= this.bgq && this.bgG < this.bgr) {
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

    private void c(List<com.baidu.live.im.data.a> list, boolean z) {
        String str;
        JSONObject jSONObject;
        LinkedList linkedList = new LinkedList();
        for (com.baidu.live.im.data.a aVar : list) {
            long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
            if (!ListUtils.isEmpty(aVar.LQ()) && !aVar.LQ().contains(Long.valueOf(currentAccountId))) {
                linkedList.add(aVar);
            } else {
                boolean z2 = aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                if (z2 && aVar.getMsgType() == 1 && !ListUtils.isEmpty(aVar.LO().aGQ) && this.aIJ == null) {
                    this.aIJ = aVar.LO().aGQ;
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
                            if (this.biY != null) {
                                this.biY.s(aVar);
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
                    if ("enter_live".equals(str) && this.bgG < this.bgr) {
                        if (com.baidu.live.entereffect.a.EF().h(aVar)) {
                        }
                    } else if ("close_live".equals(str)) {
                        linkedList.add(aVar);
                        if (this.biY != null) {
                            this.biY.s(aVar);
                        }
                    } else if ("task".equals(str)) {
                        linkedList.add(aVar);
                        if (this.biY != null) {
                            this.biY.s(aVar);
                        }
                    } else if ("live_achievement".equals(str)) {
                        linkedList.add(aVar);
                        if (this.biY != null) {
                            this.biY.s(aVar);
                        }
                    } else if ("ss_hot_live".equals(str)) {
                        linkedList.add(aVar);
                        if (this.biY != null) {
                            this.biY.s(aVar);
                        }
                    } else if ("challenge_direct_new".equals(str)) {
                        linkedList.add(aVar);
                        if (this.biY != null) {
                            this.biY.s(aVar);
                        }
                    } else if ("challenge_random_cancel".equals(str)) {
                        linkedList.add(aVar);
                        if (this.biY != null) {
                            this.biY.s(aVar);
                        }
                    } else if ("update_liveinfo".equals(str)) {
                        linkedList.add(aVar);
                        if (this.biY != null) {
                            this.biY.s(aVar);
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
                        if (z2 && !ListUtils.isEmpty(aVar.LO().aGQ)) {
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
                                if (this.biY != null) {
                                    this.biY.s(aVar);
                                }
                            } else if ("introduce_goods".equals(str)) {
                                linkedList.add(aVar);
                                if (this.biY != null) {
                                    this.biY.s(aVar);
                                }
                            } else if ("first_recharge_success".equals(str)) {
                                linkedList.add(aVar);
                                if (this.biY != null) {
                                    this.biY.s(aVar);
                                }
                            } else if ("privilege_award_success".equals(str)) {
                                linkedList.add(aVar);
                                if (this.biY != null) {
                                    this.biY.s(aVar);
                                }
                            } else if ("need_update_live_mark_info".equals(str)) {
                                linkedList.add(aVar);
                                if (this.biY != null) {
                                    this.biY.s(aVar);
                                }
                            } else if ("official_notice".equals(str)) {
                                linkedList.add(aVar);
                            } else if (TextUtils.equals(str, "privilege_award_royal_success")) {
                                Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                            } else if (!TextUtils.equals(str, "add_tags_to_anchor") && !TextUtils.equals(str, "audio_emoticon") && !TextUtils.equals(str, "follow_anchor_phone") && !TextUtils.equals(str, "follow_room") && !TextUtils.equals(str, "audio_link_toast") && !TextUtils.equals(str, "live_audio_audit_notice") && !TextUtils.equals(str, "sync_audio_speeker_status")) {
                                linkedList.add(aVar);
                            }
                        }
                    }
                } else if (aVar.getMsgType() == 12) {
                    linkedList.add(aVar);
                    if (this.biY != null) {
                        this.biY.s(aVar);
                    }
                    hy("push");
                }
            }
        }
        if (linkedList.size() > 0) {
            list.removeAll(linkedList);
        }
    }

    protected com.baidu.live.im.data.a a(short s, String str, boolean z, boolean z2, int i, String str2, List<AlaLiveMarkData> list) {
        long j = 0;
        com.baidu.live.im.data.a KI = KI();
        if (KI == null) {
            return null;
        }
        KI.setMsgType(s);
        KI.setContent(str);
        long aj = o.aj(getLastMid());
        KI.bkn = str2;
        KI.setMsgId(aj);
        KI.setRecordId(aj);
        KI.setTime(System.currentTimeMillis() / 1000);
        com.baidu.live.data.a aVar = new com.baidu.live.data.a();
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            aVar.userName = TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow();
        }
        aVar.userId = TbadkCoreApplication.getCurrentAccount();
        aVar.portrait = TbadkCoreApplication.getCurrentPortrait();
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
        com.baidu.live.message.b bVar = new com.baidu.live.message.b(JavaTypesHelper.toLong(this.mLiveId, 0L), str);
        bVar.setParams();
        sendMessage(bVar);
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
            if (this.biY != null) {
                this.biY.d(this.mMsgList, true);
                this.biY.s(KI);
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
                                String str = LO.userId;
                                LO.getNameShow();
                                String A = com.baidu.live.utils.r.A(optString, str, aVar.bja);
                                if (this.bgJ == null) {
                                    this.bgJ = new LinkedHashMap<>();
                                }
                                long j = JavaTypesHelper.toLong(jSONObject.optString("gift_count"), 0L);
                                double optDouble = jSONObject.optDouble("gift_rate", 0.0d);
                                long j2 = JavaTypesHelper.toLong(jSONObject.optString("charm_value"), 0L);
                                jSONObject.optString("gift_url");
                                jSONObject.optString("gift_name");
                                r rVar = new r();
                                rVar.bjb = new ArrayList();
                                rVar.giftId = optString;
                                rVar.bja = aVar.bja;
                                for (r.a aVar2 : com.baidu.live.utils.r.io(aVar.bja)) {
                                    r.a aVar3 = new r.a();
                                    aVar3.biy = aVar.clone();
                                    aVar3.biB = optDouble;
                                    aVar3.count = j;
                                    aVar3.bjc = aVar2.name;
                                    aVar3.biA = j2;
                                    rVar.bjb.add(aVar3);
                                }
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
                                        HashMap<Long, r> hashMap = this.bgJ.get(next);
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
                                if (!this.bgJ.containsKey(A)) {
                                    HashMap<Long, r> hashMap2 = new HashMap<>();
                                    hashMap2.put(Long.valueOf(aVar.getMsgId()), rVar);
                                    this.bgJ.put(A, hashMap2);
                                } else {
                                    this.bgJ.get(A).put(Long.valueOf(aVar.getMsgId()), rVar);
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
            HashMap<Long, r> hashMap = this.bgK.get(A);
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
                            if (next.biF.contains(l)) {
                                rVar = next;
                                break;
                            }
                        }
                    }
                    if (rVar != null) {
                        long longValue = map.get(l).longValue();
                        if (z) {
                            rVar.biz = longValue + rVar.biz;
                        }
                        if (rVar.biE) {
                            hashMap.remove(Long.valueOf(rVar.aUi));
                            for (r.a aVar : rVar.bjb) {
                                aVar.biy.ak(aVar.count);
                                aVar.biy.o(aVar.biB);
                                aVar.biy.al(aVar.biA);
                                a(-1, aVar.biy);
                                if (this.biY != null) {
                                    this.biY.d(this.mMsgList, true);
                                }
                                long j3 = rVar.biz;
                                if (j3 > 0) {
                                    e(j3, aVar.giftName);
                                }
                            }
                        }
                    }
                }
                if (hashMap.isEmpty()) {
                    this.bgK.remove(A);
                }
            }
        }
    }

    public void Ct() {
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
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.sdk_not_login);
        } else if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow())) {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.sdk_username_empty);
        } else {
            Log.i("i", "@@@ localText limmdl sm 1");
            String str2 = imSendMsgData.text;
            short s = imSendMsgData.msgType;
            com.baidu.live.im.data.a a2 = a(s, str2, z, z2, i, "", this.aIJ);
            if (s == 126) {
                a2.eL(imSendMsgData.barrageType);
                a2.hE(imSendMsgData.barrageId);
                a2.a(imSendMsgData.barrageCardInfo);
            }
            Log.i("i", "@@@ localText limmdl sm cm=" + a2);
            if (a2 != null) {
                a2.l(strArr);
                a(-1, a2);
                if (this.biY != null) {
                    Log.i("i", "@@@ localText limmdl sm recv");
                    this.biY.s(a2);
                    this.biY.d(this.mMsgList, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913043));
                com.baidu.live.im.message.a aVar = new com.baidu.live.im.message.a(str2, s, JavaTypesHelper.toInt(this.mGroupId, 0), this.mAppId);
                if (this.aEc != null && this.aEc.mLiveInfo != null && this.aEc.aIS != null) {
                    aVar.setLiveId(this.aEc.mLiveInfo.live_id + "");
                    aVar.setRoomId(this.aEc.mLiveInfo.room_id + "");
                    aVar.eM(1);
                    aVar.setCustomRoomId(this.aEc.aIS.croom_id);
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

    public void g(String str, long j) {
        Log.i("i", "@@@ localText limm sdreq uk=" + str + ",lvd=" + j + ",iibr=" + this.bgE);
        if (!this.bgE) {
            this.bgE = true;
            Log.i("i", "@@@ localText limm sdreq go");
            com.baidu.live.im.message.c cVar = new com.baidu.live.im.message.c(1031054);
            cVar.addParam("uk", str);
            cVar.addParam("live_id", j);
            cVar.an(System.currentTimeMillis());
            sendMessage(cVar);
            this.mHandler.postDelayed(this.bgN, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KK() {
        Log.i("i", "@@@ localText limm sdreq out");
        this.bgE = false;
        this.bgF = true;
        YuyinImForbiddenStateData yuyinImForbiddenStateData = new YuyinImForbiddenStateData();
        yuyinImForbiddenStateData.errno = -1;
        yuyinImForbiddenStateData.errMsg = this.mPageContext.getString(a.i.sdk_neterror);
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
                                aVar.bja = jSONObject2.optString("benefit_info");
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
