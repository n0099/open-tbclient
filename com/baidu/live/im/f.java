package com.baidu.live.im;

import android.content.Context;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.controller.HttpRule;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.u;
import com.baidu.live.im.message.ALAGroupCommitHttpResponsedMessage;
import com.baidu.live.im.message.ALAGroupHttpResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.extraparams.interfaces.IExtraParams;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticKeys;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.ubc.UbcDebugItem;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.swan.games.utils.so.SoUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {
    private static volatile f bcB = null;
    private static int bcC = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private static int bcD = 2147483646;
    private String aEU;
    private String aEV;
    private u aFP;
    private boolean bcE;
    private int bcF;
    private int bcG;
    private List<String> bcN;
    private List<AlaLiveMarkData> bcO;
    private long bcP;
    private Context mContext;
    private long bcH = 0;
    private LinkedList<Long> bcI = new LinkedList<>();
    private long bcJ = 0;
    private long bcK = 0;
    private int bcL = 0;
    private int bcM = 0;
    private CustomMessageListener bcQ = new CustomMessageListener(2913081) { // from class: com.baidu.live.im.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            u uVar;
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0) {
                f.this.bcH = 0L;
                if (com.baidu.h.b.a.aF(f.this.mContext).RZ() == null || !(customResponsedMessage.getData() instanceof u) || (uVar = (u) customResponsedMessage.getData()) == null) {
                    return;
                }
                if ((uVar.mLiveSdkInfo != null && uVar.mLiveSdkInfo.mCastIds != null) || (uVar.mLiveInfo != null && uVar.mLiveInfo.mCastIds != null)) {
                    if (uVar.mLiveInfo == null || uVar.mLiveInfo.live_status != 2) {
                        if (f.this.aFP != null && f.this.aFP.mLiveInfo != null && uVar != null && uVar.mLiveInfo != null && uVar.mLiveInfo.live_id != f.this.aFP.mLiveInfo.live_id) {
                            f.this.bcI.clear();
                            f.this.bcJ = 0L;
                            f.this.bcK = 0L;
                        }
                        f.this.aFP = uVar;
                        f.this.P(f.this.aFP.aFi);
                        f.this.Jw();
                        f.this.Jv();
                    }
                }
            }
        }
    };
    private CustomMessageListener bcR = new CustomMessageListener(2913082) { // from class: com.baidu.live.im.f.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof u)) {
                u uVar = (u) customResponsedMessage.getData();
                if (f.this.aFP != null && f.this.aFP.mLiveInfo != null && uVar != null && uVar.mLiveInfo != null && uVar.mLiveInfo.live_id != f.this.aFP.mLiveInfo.live_id) {
                    f.this.bcI.clear();
                    f.this.bcJ = 0L;
                    f.this.bcK = 0L;
                }
                f.this.aFP = uVar;
                f.this.P(f.this.aFP.aFi);
            }
        }
    };
    private CustomMessageListener bcS = new CustomMessageListener(2501033) { // from class: com.baidu.live.im.f.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof u)) {
                u uVar = (u) customResponsedMessage.getData();
                if (f.this.aFP != null && f.this.aFP.mLiveInfo != null && uVar != null && uVar.mLiveInfo != null && uVar.mLiveInfo.live_id != f.this.aFP.mLiveInfo.live_id) {
                    f.this.bcI.clear();
                    f.this.bcJ = 0L;
                    f.this.bcK = 0L;
                }
                f.this.aFP = uVar;
                f.this.P(f.this.aFP.aFi);
            }
        }
    };
    private CustomMessageListener bcT = new CustomMessageListener(2913118) { // from class: com.baidu.live.im.f.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof u)) {
                f.this.P(((u) customResponsedMessage.getData()).aFi);
            }
        }
    };
    private HttpRule bcU = new HttpRule(1021013) { // from class: com.baidu.live.im.f.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            if (httpMessage instanceof com.baidu.live.im.message.a) {
                f.this.a((com.baidu.live.im.message.a) httpMessage);
                return null;
            }
            return null;
        }
    };
    private HttpRule bcV = new HttpRule(1021012) { // from class: com.baidu.live.im.f.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            return null;
        }
    };
    CustomMessageListener bcW = new CustomMessageListener(2913084) { // from class: com.baidu.live.im.f.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.Ju();
        }
    };
    CustomMessageListener aPU = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.im.f.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.JA();
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.im.f.18.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.JB();
                }
            });
        }
    };
    private HttpRule bcX = new HttpRule(1021006) { // from class: com.baidu.live.im.f.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            f.this.JA();
            if (f.this.aFP != null && f.this.aFP.mLiveSdkInfo != null && f.this.aFP.mLiveSdkInfo.mCastIds != null) {
                String str = f.this.aFP.mLiveSdkInfo.mCastIds.aEU;
                String str2 = f.this.aFP.mLiveSdkInfo.mCastIds.aEV;
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str, -1, "", "", "");
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str2, -1, "", "", "");
            }
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.im.f.19.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.JB();
                }
            });
            return httpMessage;
        }
    };
    private IFetchMsgByIdListener bcY = new IFetchMsgByIdListener() { // from class: com.baidu.live.im.f.4
        @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
        public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList) {
            if (String.valueOf(j).equals(f.this.aEU) || String.valueOf(j).equals(f.this.aEV)) {
                if (TbConfig.IM_LOG) {
                    Log.d("im-debug", "fetch history msg received size=" + arrayList.size());
                }
                f.this.a(i, arrayList, true);
            } else if (TbConfig.IM_LOG) {
                Log.d("im-debug", "onFetchMsgByIdResult 非当前直播间 ：l: " + j);
            }
        }
    };
    private IFetchMsgByIdListener bcZ = new IFetchMsgByIdListener() { // from class: com.baidu.live.im.f.5
        @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
        public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList) {
            if (String.valueOf(j).equals(f.this.aEU) || String.valueOf(j).equals(f.this.aEV)) {
                if (TbConfig.IM_LOG) {
                    Log.d("im-debug", "fetch msg received size=" + arrayList.size());
                }
                f.this.a(i, arrayList, false);
            } else if (TbConfig.IM_LOG) {
                Log.d("im-debug", "onFetchMsgByIdResult 非当前直播间 ：l: " + j);
            }
        }
    };
    private com.baidu.h.a.b.a.d bda = new com.baidu.h.a.b.a.d() { // from class: com.baidu.live.im.f.6
        @Override // com.baidu.h.a.b.a.d
        public void e(int i, List<com.baidu.h.a.b.a.c> list) {
            String str;
            String str2;
            JSONObject jSONObject;
            if (f.this.aFP == null || f.this.aEU == null || f.this.aEV == null || f.this.aFP.mLiveInfo == null) {
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收: 直播间已销毁");
                }
            } else if (i != 0 && i != f.bcC && i != f.bcD) {
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收: 非有效消息");
                }
            } else {
                ALAGroupHttpResponseMessage aLAGroupHttpResponseMessage = new ALAGroupHttpResponseMessage();
                ArrayList arrayList = new ArrayList();
                if (f.this.bcN != null) {
                    f.this.bcN.clear();
                }
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收:");
                }
                for (com.baidu.h.a.b.a.c cVar : list) {
                    if (cVar == null) {
                        if (TbConfig.IM_LOG) {
                            Log.i("imlog", "@.@ IM消息 接收: messageBean 为空");
                        }
                    } else {
                        String str3 = "";
                        if (!TextUtils.isEmpty(cVar.aNx)) {
                            str = cVar.aNx;
                            str2 = "";
                        } else {
                            if (cVar.bAs != null && cVar.bAs.bAG != null) {
                                try {
                                    JSONObject jSONObject2 = new JSONObject(cVar.bAs.bAG);
                                    if (!TextUtils.isEmpty(jSONObject2.optString("room_id"))) {
                                        str3 = jSONObject2.optString("room_id");
                                    }
                                    String optString = jSONObject2.optString("msg_type");
                                    if (TextUtils.isEmpty(optString)) {
                                        optString = jSONObject2.optString("msgType");
                                    }
                                    str = str3;
                                    str2 = optString;
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            str = "";
                            str2 = "";
                        }
                        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, f.this.aEU) && !TextUtils.equals(str, f.this.aEV)) {
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ IM消息 接收  非当前直播间的消息，过滤 castId：" + str + "   chatMCastId：" + f.this.aEU + "   ensureMCastId: " + f.this.aEV);
                            }
                            f.this.hc(str);
                        } else if (TextUtils.equals(cVar.type, "0") && TextUtils.isEmpty(str)) {
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ IM消息 接收: 如果是普通消息同时castId为空，过滤");
                            }
                            f.this.hc(str);
                        } else if (!TextUtils.isEmpty(str) || !TextUtils.equals(str2, SoUtils.SO_EVENT_ID_DEFAULT)) {
                            if (i != f.bcC && i != f.bcD && TextUtils.equals(str, f.this.aEU)) {
                                f.this.bcH = System.currentTimeMillis();
                                if (TbConfig.IM_LOG) {
                                    Log.d("im-debug", "receiveChatMsgTime= " + f.this.bcH);
                                }
                                f.this.bcE = false;
                                f.this.Jv();
                            }
                            if (!f.this.bcI.contains(Long.valueOf(cVar.msgId))) {
                                if (i == f.bcC) {
                                    String str4 = "";
                                    String str5 = "";
                                    if (!TextUtils.isEmpty(cVar.bAt)) {
                                        try {
                                            JSONObject jSONObject3 = new JSONObject(cVar.bAt);
                                            str4 = jSONObject3.optString("msgType");
                                            if (TextUtils.isEmpty(str4)) {
                                                str4 = jSONObject3.optString("msg_type");
                                            }
                                        } catch (JSONException e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                    if (!TextUtils.isEmpty(cVar.bAd)) {
                                        try {
                                            JSONObject optJSONObject = new JSONObject(new JSONObject(cVar.bAd).optString("text")).optJSONObject("data");
                                            if (optJSONObject != null) {
                                                str5 = new JSONObject(optJSONObject.optJSONObject("service_info").optString("content")).optString("content_type");
                                            }
                                        } catch (JSONException e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                    if ((!TextUtils.equals(cVar.type, "0") || (!TextUtils.isEmpty(str4) && !TextUtils.equals(str4, "1"))) && !TextUtils.equals(str5, "audio_emoticon")) {
                                    }
                                }
                                List<a> a = p.a(cVar);
                                if (a == null) {
                                    if (TbConfig.IM_LOG) {
                                        Log.i("imlog", "@.@ IM消息 接收: 解析后无有效消息");
                                    }
                                } else {
                                    if (TextUtils.equals(cVar.type, "0")) {
                                        int i2 = 0;
                                        while (true) {
                                            int i3 = i2;
                                            if (i3 >= a.size()) {
                                                break;
                                            }
                                            a aVar = a.get(i3);
                                            if (aVar.Ko() != null && (!TextUtils.isEmpty(aVar.Ko().name_show) || !TextUtils.isEmpty(aVar.Ko().userName))) {
                                                arrayList.add(aVar);
                                            }
                                            i2 = i3 + 1;
                                        }
                                    } else {
                                        arrayList.addAll(a);
                                    }
                                    if (i == 0 && cVar.bAs != null && !TextUtils.isEmpty(cVar.bAs.bAG)) {
                                        if (f.this.bcN == null) {
                                            f.this.bcN = new ArrayList();
                                        }
                                        f.this.bcN.add(cVar.bAs.bAG);
                                    }
                                    if (!TextUtils.equals(cVar.type, TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY)) {
                                        if (TextUtils.equals(str2, SoUtils.SO_EVENT_ID_DEFAULT)) {
                                            f.this.bcG += a.size();
                                            if (f.this.aFP != null && f.this.aFP.isHost) {
                                                for (a aVar2 : a) {
                                                    if (aVar2.getMsgType() == 24) {
                                                        JSONObject jSONObject4 = new JSONObject();
                                                        if (aVar2.getObjContent() instanceof JSONObject) {
                                                            jSONObject = (JSONObject) aVar2.getObjContent();
                                                        } else {
                                                            try {
                                                                jSONObject = new JSONObject(aVar2.getContent());
                                                            } catch (JSONException e4) {
                                                                BdLog.e(e4);
                                                                jSONObject = null;
                                                            }
                                                            aVar2.setObjContent(jSONObject);
                                                        }
                                                        if (jSONObject != null) {
                                                            try {
                                                                jSONObject4.put(LogConfig.LOG_GIFT_ID, jSONObject.optString(LogConfig.LOG_GIFT_ID));
                                                                jSONObject4.put("gift_count", jSONObject.optLong("gift_count"));
                                                                if (aVar2.Ko() != null) {
                                                                    jSONObject4.put("sender_uk", EncryptionHelper.getEncryptionUserId(aVar2.Ko().userId));
                                                                }
                                                                jSONObject4.put("rec_time", System.currentTimeMillis());
                                                            } catch (JSONException e5) {
                                                                BdLog.e(e5);
                                                            }
                                                            UbcStatisticManager.getInstance().debugException(new UbcDebugItem(UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.DebugContentValue.GIFT, jSONObject4), "gift_rec");
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            f.this.bcF += a.size();
                                        }
                                    }
                                    if (f.this.bcI.size() > 200) {
                                        f.this.bcI.removeFirst();
                                    }
                                    f.this.bcI.add(Long.valueOf(cVar.msgId));
                                    if (!TextUtils.equals(str, f.this.aEU) || cVar.msgId <= f.this.bcJ) {
                                        if (TextUtils.equals(str, f.this.aEU) && cVar.msgId > f.this.bcK) {
                                            f.this.bcK = cVar.msgId;
                                        }
                                    } else {
                                        f.this.bcJ = cVar.msgId;
                                    }
                                }
                            } else if (TbConfig.IM_LOG) {
                                Log.d("im-debug", "remove repeat msg msgid=" + cVar.msgId + " type=" + cVar.type);
                            }
                        } else {
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ IM消息 接收: 如果是普通消息同时castId为空，过滤礼物消息");
                            }
                            f.this.hc(str);
                        }
                    }
                }
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收: 消息分发 Size: " + arrayList.size() + "  History: " + (i == f.bcC));
                }
                if (arrayList.size() > 0) {
                    aLAGroupHttpResponseMessage.bT(i == f.bcC);
                    aLAGroupHttpResponseMessage.T(arrayList);
                    aLAGroupHttpResponseMessage.setGroupId(f.this.aFP.mLiveInfo.getGroupID());
                    MessageManager.getInstance().dispatchResponsedMessage(aLAGroupHttpResponseMessage);
                    if (f.this.bcN != null && !f.this.bcN.isEmpty()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913107, f.this.bcN));
                    }
                }
            }
        }
    };
    private CustomMessageListener bdb = new CustomMessageListener(2913108) { // from class: com.baidu.live.im.f.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (TbConfig.IM_LOG) {
                Log.i("imlog", "@.@ IM消息 收到端上切前台消息");
            }
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 收到端上切前台 -- 非空消息");
                }
                f.this.JC();
            }
        }
    };
    private CustomMessageListener bdc = new CustomMessageListener(2913190) { // from class: com.baidu.live.im.f.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 直播间切前台监听 -- 网络不可用");
                    return;
                }
                return;
            }
            if ((TbadkCoreApplication.getInst().isMobileBaidu() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isHaokan()) && LoginManager.getInstance(TbadkCoreApplication.getInst().getContext()).isIMLogined()) {
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 直播间切前台监听 -- IM 没断，直接 join");
                }
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    f.this.JC();
                } else {
                    SafeHandler.getInst().removeCallbacks(f.this.bdd);
                    SafeHandler.getInst().postDelayed(f.this.bdd, 1000L);
                }
            }
            if (TbadkCoreApplication.getInst().isTieba()) {
                if (LoginManager.getInstance(TbadkCoreApplication.getInst().getContext()).isIMLogined()) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ IM消息 贴吧直播间切前台监听 -- IM 没断，直接 join");
                    }
                    f.this.JC();
                    return;
                }
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 贴吧直播间切前台监听 -- IM 断");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913191, null));
            }
        }
    };
    private Runnable bdd = new Runnable() { // from class: com.baidu.live.im.f.9
        @Override // java.lang.Runnable
        public void run() {
            f.this.JC();
        }
    };
    private Runnable bde = new Runnable() { // from class: com.baidu.live.im.f.10
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (TbConfig.IM_LOG) {
                Log.d("im-debug", "imExceptionCheckRunnable: " + (currentTimeMillis - f.this.bcH));
            }
            if (currentTimeMillis - f.this.bcH >= 18000) {
                if (!f.this.bcE) {
                    f.this.bcE = true;
                    f.this.Jy();
                }
                if (f.this.aFP != null && f.this.aFP.isHost) {
                    f.this.Jw();
                    f.this.Jx();
                }
            } else if (f.this.bcE) {
                f.this.bcE = false;
                f.this.Jy();
            }
            f.this.Jv();
        }
    };
    private CustomMessageTask.CustomRunnable bdf = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.im.f.11
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            String str;
            if (f.this.aFP != null && f.this.aFP.mLiveSdkInfo != null && f.this.aFP.mLiveSdkInfo.mCastIds != null) {
                str = f.this.aFP.mLiveSdkInfo.mCastIds.aEV;
            } else {
                str = "0";
            }
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID, str);
        }
    };

    public static f Jt() {
        if (bcB == null) {
            synchronized (f.class) {
                if (bcB == null) {
                    bcB = new f();
                }
            }
        }
        return bcB;
    }

    private f() {
    }

    public void as(Context context) {
        this.mContext = context;
        MessageManager.getInstance().unRegisterListener(this.bcQ);
        MessageManager.getInstance().registerListener(this.bcQ);
        MessageManager.getInstance().removeMessageRule(this.bcV);
        MessageManager.getInstance().addMessageRule(this.bcV);
        MessageManager.getInstance().unRegisterListener(this.bcW);
        MessageManager.getInstance().registerListener(this.bcW);
        MessageManager.getInstance().unRegisterListener(this.bdb);
        MessageManager.getInstance().registerListener(this.bdb);
        MessageManager.getInstance().unRegisterListener(this.bdc);
        MessageManager.getInstance().registerListener(this.bdc);
        new CustomMessageTask(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID, this.bdf).setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID);
    }

    public void Ju() {
        SafeHandler.getInst().removeCallbacks(this.bdd);
        SafeHandler.getInst().removeCallbacks(this.bde);
        com.baidu.h.b.a.aF(this.mContext).RZ().JA();
        this.bcP = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jv() {
        SafeHandler.getInst().removeCallbacks(this.bde);
        if (this.aFP != null && this.aFP.mLiveInfo != null) {
            SafeHandler.getInst().postDelayed(this.bde, 18000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jw() {
        int i;
        String str;
        String str2;
        if (this.aFP != null) {
            if (this.aFP.mLiveSdkInfo != null && this.aFP.mLiveSdkInfo.mCastIds != null) {
                this.aEU = this.aFP.mLiveSdkInfo.mCastIds.aEU;
                String str3 = this.aFP.mLiveSdkInfo.mCastIds.aEW;
                this.aEV = this.aFP.mLiveSdkInfo.mCastIds.aEV;
                String str4 = this.aFP.mLiveSdkInfo.mCastIds.aEY;
                i = JavaTypesHelper.toInt(this.aFP.mLiveSdkInfo.mCastIds.aEZ, 5) * 1000;
                str = str4;
                str2 = str3;
            } else if (this.aFP.mLiveInfo == null || this.aFP.mLiveInfo.mCastIds == null) {
                i = 5000;
                str = "";
                str2 = "";
            } else {
                this.aEU = this.aFP.mLiveInfo.mCastIds.aEU;
                String str5 = this.aFP.mLiveInfo.mCastIds.aEW;
                this.aEV = this.aFP.mLiveInfo.mCastIds.aEV;
                String str6 = this.aFP.mLiveInfo.mCastIds.aEY;
                i = JavaTypesHelper.toInt(this.aFP.mLiveInfo.mCastIds.aEZ, 5) * 1000;
                str = str6;
                str2 = str5;
            }
            a(this.aEU, str2, i, false);
            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", this.aEU, this.aEU, 0, "", "", "");
            a(this.aEV, str, i, this.aFP.isHost);
            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", this.aEU, this.aEV, 0, "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jx() {
        if (TbConfig.IM_LOG) {
            Log.d("im-debug", "start fetch im chat castid=" + this.aEU + "lastmsgid=" + this.bcJ);
        }
        int i = 25;
        if (this.bcJ == 0) {
            i = -25;
        }
        BIMManager.fetchMsgRequest(this.mContext, AccountManager.getAppid(this.mContext), AccountManager.getUK(this.mContext), 4, JavaTypesHelper.toLong(this.aEU, -1L), this.bcJ, Long.MAX_VALUE, i, 1, this.bcZ);
        int i2 = 25;
        if (this.bcK == 0) {
            i2 = -25;
        }
        if (TbConfig.IM_LOG) {
            Log.d("im-debug", "start fetch im ensure castid=" + this.aEV + " lastmsgid=" + this.bcK);
        }
        BIMManager.fetchMsgRequest(this.mContext, AccountManager.getAppid(this.mContext), AccountManager.getUK(this.mContext), 4, JavaTypesHelper.toLong(this.aEV, -1L), this.bcK, Long.MAX_VALUE, i2, 1, this.bcZ, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jy() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME), Long.class);
        if (runTask == null) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("im_state", this.bcE ? 0 : 1);
            jSONObject.put("im_chat_mcast_id", this.aEU);
            jSONObject.put("im_ensure_mcast_id", this.aEV);
            jSONObject.put("im_live_info_time", j);
            jSONObject.put("im_last_msg_time", this.bcH);
            a(jSONObject, (JSONObject) null, "1537", UbcStatConstant.ContentType.UBC_TYPE_IM_EXCEPTION, "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final String str2, final int i, final boolean z) {
        if (TbConfig.IM_LOG) {
            Log.i("imlog", "@.@ enterRoom roomid:" + str + ", url:" + str2);
        }
        if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
            a((JSONObject) null, (JSONObject) null, "1529", UbcStatConstant.ContentType.UBC_TYPE_IM_JOIN, str);
            com.baidu.h.b.a.aF(this.mContext).RZ().a(str, str2, i, new com.baidu.h.a.b.b() { // from class: com.baidu.live.im.f.2
                @Override // com.baidu.h.a.b.b
                public void onResult(int i2, long j, long j2) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ enterRoom onResult i:" + i2 + ", l:" + j + ", l1:" + j2);
                    }
                    if (f.this.aFP == null || f.this.aEU == null || f.this.aEV == null) {
                        com.baidu.h.b.a.aF(f.this.mContext).RZ().hY(String.valueOf(j));
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.aEU, String.valueOf(j), -1, "", "", "");
                        return;
                    }
                    long j3 = JavaTypesHelper.toLong(f.this.aEU, -1L);
                    long j4 = JavaTypesHelper.toLong(f.this.aEV, -1L);
                    if (j3 != j && j4 != j) {
                        com.baidu.h.b.a.aF(f.this.mContext).RZ().hY(String.valueOf(j));
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.aEU, String.valueOf(j), -1, "", "", "");
                        if (TbConfig.IM_LOG) {
                            Log.e("imlog", "BDIM enterRoom wrong then exit end:" + j);
                            return;
                        }
                        return;
                    }
                    if (j3 == j) {
                        f.this.bcF = 0;
                    } else {
                        f.this.bcG = 0;
                    }
                    if (i2 != 0) {
                        f.this.b(j, i2, j3 == j ? f.this.bcL : f.this.bcM);
                    }
                    if (i2 == 1000) {
                        IExtraParams buildParamsExtra = ExtraParamsManager.getInstance().buildParamsExtra();
                        if (buildParamsExtra != null) {
                            try {
                                HashMap hashMap = new HashMap();
                                hashMap.put(ExtraParamsManager.KEY_PROCESS_PLUGIN_ASYNC_CALLBACK, "");
                                hashMap.put("cmd", 2913108);
                                buildParamsExtra.process(hashMap);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_FAIL_IM_NOT_LOGIN, f.this.aEU, str, -1, "", "", "");
                    } else if (i2 == 1314 || i2 == 1306) {
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_MSG_ENTER_IM_FAIL, f.this.aEU, str, -1, String.valueOf(i2), "", "");
                    } else if (i2 != 0) {
                        if (j3 == j) {
                            if (f.this.bcL < 6) {
                                f.this.a(str, str2, i, z);
                                f.this.bcL++;
                                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_MSG_FAIL_TO_REJOIN, f.this.aEU, str, -1, "", "", "");
                                return;
                            }
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.aEU, str, -1, "", "", "");
                        } else if (f.this.bcM < 6) {
                            f.this.a(str, str2, i, z);
                            f.this.bcM++;
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_GIFT_FAIL_TO_REJOIN, f.this.aEU, str, -1, "", "", "");
                        } else {
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.aEU, str, -1, "", "", "");
                        }
                    } else if (j3 == j) {
                        f.this.bcL = 0;
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", f.this.aEU, str, 0, "", "", "");
                        if (TbConfig.IM_LOG) {
                            Log.i("imlog", "@.@ enterRoom onResult JOIN Msg成功:" + j3);
                        }
                        if ((!f.this.aFP.isHost || (f.this.aFP.isHost && f.this.aFP.aFl)) && f.this.bcP != j3) {
                            f.this.bcP = j3;
                            long j5 = JavaTypesHelper.toLong(str, -1L);
                            BIMManager.fetchMsgRequest(f.this.mContext, AccountManager.getAppid(f.this.mContext), AccountManager.getUK(f.this.mContext), 4, j5, 0L, Long.MAX_VALUE, -25, 1, f.this.bcY);
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ enterRoom fetchMsgidByMsgid:   " + j5);
                            }
                        }
                    } else {
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", f.this.aEU, str, 0, "", "", "");
                        if (TbConfig.IM_LOG) {
                            Log.i("imlog", "@.@ enterRoom onResult JOIN Gift成功:" + j4);
                        }
                        f.this.bcM = 0;
                    }
                }
            }, z);
            Jz();
            hb(str);
            if (TbConfig.IM_LOG) {
                Log.i("imlog", "@.@ enterRoom registerMsgReceiveListener:" + z + ", mCastId: " + str);
            }
        }
    }

    private void Jz() {
        MessageManager.getInstance().unRegisterListener(this.aPU);
        MessageManager.getInstance().registerListener(this.aPU);
        MessageManager.getInstance().unRegisterListener(this.bcR);
        MessageManager.getInstance().registerListener(this.bcR);
        MessageManager.getInstance().unRegisterListener(this.bcS);
        MessageManager.getInstance().registerListener(this.bcS);
        MessageManager.getInstance().unRegisterListener(this.bcT);
        MessageManager.getInstance().registerListener(this.bcT);
        MessageManager.getInstance().removeMessageRule(this.bcU);
        MessageManager.getInstance().addMessageRule(this.bcU);
        MessageManager.getInstance().removeMessageRule(this.bcX);
        MessageManager.getInstance().addMessageRule(this.bcX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JA() {
        SafeHandler.getInst().removeCallbacks(this.bdd);
        SafeHandler.getInst().removeCallbacks(this.bde);
        if (this.aFP != null && this.aFP.mLiveSdkInfo != null && this.aFP.mLiveSdkInfo.mCastIds != null) {
            String str = this.aFP.mLiveSdkInfo.mCastIds.aEU;
            String str2 = this.aFP.mLiveSdkInfo.mCastIds.aEV;
            com.baidu.h.b.a.aF(this.mContext).RZ().hY(str);
            com.baidu.h.b.a.aF(this.mContext).RZ().hY(str2);
            JD();
        }
        this.bcF = 0;
        this.bcG = 0;
        this.bcP = 0L;
        this.aFP = null;
        this.aEU = null;
        this.aEV = null;
        this.bcL = 0;
        this.bcM = 0;
        if (this.bcN != null) {
            this.bcN.clear();
            this.bcN = null;
        }
        if (this.bcO != null) {
            this.bcO.clear();
            this.bcO = null;
        }
        this.bcI.clear();
        this.bcJ = 0L;
        this.bcJ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JB() {
        MessageManager.getInstance().unRegisterListener(this.bcR);
        MessageManager.getInstance().unRegisterListener(this.bcS);
        MessageManager.getInstance().unRegisterListener(this.bcT);
        MessageManager.getInstance().unRegisterListener(this.aPU);
        MessageManager.getInstance().removeMessageRule(this.bcU);
        MessageManager.getInstance().removeMessageRule(this.bcX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(List<AlaLiveMarkData> list) {
        if (list != null && !list.isEmpty()) {
            if (this.bcO == null) {
                this.bcO = new ArrayList();
            }
            this.bcO.clear();
            this.bcO.addAll(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.live.im.message.a aVar) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        String str = null;
        String content = aVar.getContent();
        if (TbConfig.IM_LOG) {
            Log.i("imlog", "@.@ IM消息 发送内容: " + content);
        }
        final String str2 = (this.aFP == null || this.aFP.mLiveSdkInfo == null || this.aFP.mLiveSdkInfo.mCastIds == null) ? null : this.aFP.mLiveSdkInfo.mCastIds.aEU;
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.h.a.b.a.e eVar = new com.baidu.h.a.b.a.e();
            eVar.msg = content;
            eVar.aNx = str2;
            if (this.aFP != null && this.aFP.aFb != null) {
                eVar.name = this.aFP.aFb.userName;
                eVar.portrait = this.aFP.aFb.portrait;
            }
            a aVar2 = new a();
            if (this.aFP != null) {
                if (this.aFP.isHost) {
                    alaLiveUserInfoData = this.aFP.aEz;
                } else {
                    alaLiveUserInfoData = this.aFP.aFb;
                }
                if (alaLiveUserInfoData != null) {
                    aVar2.setTime(System.currentTimeMillis());
                    aVar2.setMsgId(-1L);
                    com.baidu.live.data.a aVar3 = new com.baidu.live.data.a();
                    aVar3.userName = alaLiveUserInfoData.userName;
                    aVar3.userId = String.valueOf(alaLiveUserInfoData.userId);
                    aVar3.portrait = alaLiveUserInfoData.portrait;
                    aVar3.name_show = TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow();
                    aVar3.appId = alaLiveUserInfoData.appId;
                    aVar3.aDz = alaLiveUserInfoData.followCount;
                    aVar3.aDy = alaLiveUserInfoData.fansCount;
                    aVar3.aDC = alaLiveUserInfoData.isAdmin == 1;
                    aVar3.aDB = alaLiveUserInfoData.isOfficial == 1;
                    aVar3.level_id = alaLiveUserInfoData.levelId;
                    aVar3.aDE = this.bcO;
                    aVar3.sex = alaLiveUserInfoData.sex;
                    aVar3.extraUserInfo = alaLiveUserInfoData.extraUserInfo;
                    aVar2.e(aVar3);
                    aVar2.setContent(content);
                    aVar2.setMsgType(aVar.KC());
                    aVar2.eA(aVar.Ks());
                    aVar2.hf(aVar.Kt());
                    aVar2.a(aVar.Ku());
                    aVar2.k(aVar.Kv());
                    aVar2.setUserId(alaLiveUserInfoData.userId);
                    aVar2.gY(String.valueOf(this.aFP.mLiveInfo.user_id));
                    aVar2.setBornTime(System.currentTimeMillis());
                    str = aVar2.IY();
                }
            }
            eVar.bAt = str;
            com.baidu.h.a.b.a.f fVar = new com.baidu.h.a.b.a.f() { // from class: com.baidu.live.im.f.3
                @Override // com.baidu.h.a.b.a.f
                public void a(String str3, int i, List<com.baidu.h.a.b.a.c> list) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ IM消息 onSendSuccess s:" + str3 + ", i:" + i);
                    }
                    if (f.this.aFP != null && f.this.aEU != null && f.this.aEV != null) {
                        if (TextUtils.equals(str3, f.this.aEU) || TextUtils.equals(str3, f.this.aEV)) {
                            ALAGroupCommitHttpResponsedMessage aLAGroupCommitHttpResponsedMessage = new ALAGroupCommitHttpResponsedMessage();
                            aLAGroupCommitHttpResponsedMessage.setStatusCode(200, null);
                            if (f.this.aFP.mLiveInfo != null) {
                                f.this.a(aVar, i, str2, list);
                            }
                            aLAGroupCommitHttpResponsedMessage.setError(i);
                            if (i == 0) {
                                f.this.s(list);
                            } else if (i == 149010) {
                                Log.d("BdIMImpl", "@@ sendMessageListener 禁言用户发消息 i = " + i);
                            } else if (i == 1202 || i == 1203) {
                                Log.d("BdIMImpl", "@@ sendMessageListener 网络错误，发送失败 i = " + i);
                            } else if (i == 1204) {
                                Log.d("BdIMImpl", "@@ sendMessageListener 含有不当内容，请修改后重发 i = " + i);
                            } else if (i == 1207) {
                                Log.d("BdIMImpl", "@@ sendMessageListener 命中ueg i = " + i);
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(aLAGroupCommitHttpResponsedMessage);
                        }
                    }
                }
            };
            au(content, str2);
            if (!LoginManager.getInstance(TbadkCoreApplication.getInst().getContext()).isIMLogined() || BIMManager.getLoginType(TbadkCoreApplication.getInst().getContext()) != 1) {
                if (TbConfig.IM_LOG) {
                    if (!LoginManager.getInstance(TbadkCoreApplication.getInst().getContext()).isIMLogined()) {
                        Log.i("imlog", "@.@ IM 发送消息失败：IM 未登录");
                        return;
                    } else {
                        Log.i("imlog", "@.@ IM 发送消息失败：非 uid 登录");
                        return;
                    }
                }
                return;
            }
            com.baidu.h.b.a.aF(this.mContext).RZ().a(str2, eVar, fVar);
            if (TbConfig.IM_LOG) {
                Log.i("imlog", "@.@ IM消息 发送 roomId:" + str2 + ", sendMessage:" + eVar.toString());
            }
        }
    }

    private void au(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("im_send_content", str);
            a(jSONObject, (JSONObject) null, "1529", UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, str2);
        } catch (JSONException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.im.message.a aVar, int i, String str, List<com.baidu.h.a.b.a.c> list) {
        if (TbadkCoreApplication.getInst().isHaokan()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SUC_SEND_NEWS);
            alaStaticItem.addParams("live_id", this.aFP.mLiveInfo.live_id + "");
            alaStaticItem.addParams("room_id", this.aFP.mLiveInfo.room_id + "");
            alaStaticItem.addParams("feed_id", this.aFP.mLiveInfo.feed_id + "");
            alaStaticItem.addParams("other_params", aVar.KD());
            if (aVar.KC() == 126) {
                alaStaticItem.addParams("gifts_value", String.valueOf(aVar.KE()));
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SUC_SEND_NEWS);
            alaStaticItem2.addParams("live_id", this.aFP.mLiveInfo.live_id + "");
            alaStaticItem2.addParams("room_id", this.aFP.mLiveInfo.room_id + "");
            alaStaticItem2.addParams("feed_id", this.aFP.mLiveInfo.feed_id + "");
            alaStaticItem2.addParams("other_params", aVar.KD());
            if (aVar.KC() == 126) {
                alaStaticItem2.addParams("gifts_value", String.valueOf(aVar.KE()));
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem2);
        }
        if (!aVar.KG()) {
            if (aVar.KC() == 126) {
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "msg_send").setContentExt("barrage", null, null));
            } else if (aVar.KF()) {
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "msg_send").setContentExt("fastkey", null, null));
            } else {
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "msg_send").setContentExt("manual", null, null));
            }
        } else {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, aVar.KH());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (aVar.KC() == 126) {
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "msg_send").setContentExt("barrage", null, jSONObject));
            } else if (aVar.KF()) {
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "msg_send").setContentExt("fastkey", null, jSONObject));
            } else {
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "msg_send").setContentExt("manual", null, jSONObject));
            }
        }
        if (list != null && !list.isEmpty()) {
            try {
                for (com.baidu.h.a.b.a.c cVar : list) {
                    if (cVar != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("msg_id", cVar.msgId + "");
                        jSONObject2.put("code", i);
                        a(jSONObject3, jSONObject2, "1537", UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, str);
                    }
                }
            } catch (JSONException e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(List<com.baidu.h.a.b.a.c> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.h.a.b.a.c cVar : list) {
                if (cVar != null) {
                    String str = "";
                    if (!TextUtils.isEmpty(cVar.aNx)) {
                        str = cVar.aNx;
                    } else if (cVar.bAs != null && cVar.bAs.bAG != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(cVar.bAs.bAG);
                            if (!TextUtils.isEmpty(jSONObject.optString("room_id"))) {
                                str = jSONObject.optString("room_id");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    if (TextUtils.isEmpty(str) || TextUtils.equals(str, this.aEU) || TextUtils.equals(str, this.aEV)) {
                        List<a> a = p.a(cVar, true);
                        if (a != null && !a.isEmpty()) {
                            for (a aVar : a) {
                                aVar.setMsgId(cVar.msgId);
                            }
                            arrayList.addAll(a);
                        }
                    }
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913102, arrayList));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913124));
            if (!arrayList.isEmpty() && this.aFP != null) {
                if (((com.baidu.live.im.data.a) arrayList.get(0)).getMsgType() == 126) {
                    com.baidu.live.m.a.b(this.aFP.mLiveInfo.live_id, 6);
                } else {
                    com.baidu.live.m.a.b(this.aFP.mLiveInfo.live_id, 2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ArrayList<ChatMsg> arrayList, boolean z) {
        if ((i == 0 || i == 200) && arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<ChatMsg> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.h.a.b.a.c a = com.baidu.h.b.a.a.a.a.a(it.next());
                if (a != null) {
                    arrayList2.add(a);
                }
            }
            if (!arrayList2.isEmpty()) {
                Collections.reverse(arrayList2);
                this.bda.e(z ? bcC : bcD, arrayList2);
            }
        }
    }

    private void hb(String str) {
        com.baidu.h.b.a.aF(this.mContext).RZ().a(str, this.bda);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hc(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("im_worng_mcastid", str);
            jSONObject.put("im_wrong_msgs", 1);
            jSONObject.put("im_chat_mcast_id", this.aEU);
            jSONObject.put("im_ensure_mcast_id", this.aEV);
            a(jSONObject, (JSONObject) null, "1537", UbcStatConstant.ContentType.UBC_TYPE_IM_WRONG_ID, (String) null);
        } catch (JSONException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JC() {
        if (this.aFP != null && this.aFP.mLiveSdkInfo != null && this.aFP.mLiveSdkInfo.mCastIds != null) {
            this.bcL = 0;
            this.bcM = 0;
            this.aEU = this.aFP.mLiveSdkInfo.mCastIds.aEU;
            String str = this.aFP.mLiveSdkInfo.mCastIds.aEW;
            this.aEV = this.aFP.mLiveSdkInfo.mCastIds.aEV;
            String str2 = this.aFP.mLiveSdkInfo.mCastIds.aEY;
            int i = JavaTypesHelper.toInt(this.aFP.mLiveSdkInfo.mCastIds.aEZ, 5) * 1000;
            a(this.aEU, str, i, false);
            a(this.aEV, str2, i, this.aFP.isHost);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("im_join_retry_count", i2);
        } catch (JSONException e) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("code", i);
        } catch (JSONException e2) {
        }
        a(jSONObject, jSONObject2, "1537", UbcStatConstant.ContentType.UBC_TYPE_IM_JOIN, j + "");
    }

    private void JD() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("im_chat_mcast_id", this.aEU);
            jSONObject.put("im_ensure_mcast_id", this.aEV);
            jSONObject.put("im_chat_mcast_count", this.bcF);
            jSONObject.put("im_ensure_mcast_count", this.bcG);
            a(jSONObject, (JSONObject) null, "1529", UbcStatConstant.ContentType.UBC_TYPE_IM_LEAVE, (String) null);
        } catch (JSONException e) {
        }
    }

    private JSONObject K(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String version = BIMManager.getVersion();
        boolean isIMLogined = LoginManager.getInstance(TbadkCoreApplication.getInst()).isIMLogined();
        int loginType = BIMManager.getLoginType(TbadkCoreApplication.getInst());
        String base64 = ExtraParamsManager.getBase64(BIMManager.getCuid(TbadkCoreApplication.getInst()));
        String base642 = ExtraParamsManager.getBase64(BIMManager.getLoginUser());
        try {
            jSONObject.put(SapiContext.KEY_SDK_VERSION, version);
            jSONObject.put("connected", isIMLogined ? 1 : 0);
            jSONObject.put(Constants.KEY_LOGIN_TYPE, loginType == 1 ? 1 : 0);
            if (loginType == 1) {
                jSONObject.put("im_uid", base642);
            } else {
                jSONObject.put("im_cuid", base64);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    private void a(JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        if (this.aFP != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            if (TbConfig.IM_LOG) {
                Log.i("imUbclog", "Json: " + jSONObject.toString() + "  type: " + str2 + " isHost: " + this.aFP.isHost);
            }
            JSONObject jSONObject3 = new JSONObject();
            K(jSONObject);
            try {
                jSONObject3.put("im", jSONObject);
                if (jSONObject2 != null) {
                    jSONObject3.put(BdStatsConstant.StatsType.ERROR, jSONObject2);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(str, str2, this.aFP.isHost ? UbcStatConstant.Page.AUTHOR_LIVE_ROOM : "liveroom", str3);
            ubcStatisticItem.setContentExt(jSONObject3);
            UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
        }
    }
}
