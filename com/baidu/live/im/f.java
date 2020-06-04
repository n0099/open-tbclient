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
/* loaded from: classes3.dex */
public class f {
    private static volatile f aQO = null;
    private static int aQP = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private static int aQQ = 2147483646;
    private boolean aQR;
    private int aQS;
    private int aQT;
    private List<String> aRa;
    private List<AlaLiveMarkData> aRb;
    private long aRc;
    private com.baidu.live.data.q avW;
    private String avv;
    private String avw;
    private Context mContext;
    private long aQU = 0;
    private LinkedList<Long> aQV = new LinkedList<>();
    private long aQW = 0;
    private long aQX = 0;
    private int aQY = 0;
    private int aQZ = 0;
    private CustomMessageListener aRd = new CustomMessageListener(2913081) { // from class: com.baidu.live.im.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.data.q qVar;
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0) {
                f.this.aQU = 0L;
                if (com.baidu.c.b.a.az(f.this.mContext).JS() == null || !(customResponsedMessage.getData() instanceof com.baidu.live.data.q) || (qVar = (com.baidu.live.data.q) customResponsedMessage.getData()) == null) {
                    return;
                }
                if ((qVar.mLiveSdkInfo != null && qVar.mLiveSdkInfo.mCastIds != null) || (qVar.mLiveInfo != null && qVar.mLiveInfo.mCastIds != null)) {
                    if (qVar.mLiveInfo == null || qVar.mLiveInfo.live_status != 2) {
                        if (f.this.avW != null && f.this.avW.mLiveInfo != null && qVar != null && qVar.mLiveInfo != null && qVar.mLiveInfo.live_id != f.this.avW.mLiveInfo.live_id) {
                            f.this.aQV.clear();
                            f.this.aQW = 0L;
                            f.this.aQX = 0L;
                        }
                        f.this.avW = qVar;
                        f.this.F(f.this.avW.avH);
                        f.this.Co();
                        f.this.Cn();
                    }
                }
            }
        }
    };
    private CustomMessageListener aRe = new CustomMessageListener(2913082) { // from class: com.baidu.live.im.f.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof com.baidu.live.data.q)) {
                com.baidu.live.data.q qVar = (com.baidu.live.data.q) customResponsedMessage.getData();
                if (f.this.avW != null && f.this.avW.mLiveInfo != null && qVar != null && qVar.mLiveInfo != null && qVar.mLiveInfo.live_id != f.this.avW.mLiveInfo.live_id) {
                    f.this.aQV.clear();
                    f.this.aQW = 0L;
                    f.this.aQX = 0L;
                }
                f.this.avW = qVar;
                f.this.F(f.this.avW.avH);
            }
        }
    };
    private CustomMessageListener aRf = new CustomMessageListener(2913118) { // from class: com.baidu.live.im.f.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof com.baidu.live.data.q)) {
                f.this.F(((com.baidu.live.data.q) customResponsedMessage.getData()).avH);
            }
        }
    };
    private HttpRule aRg = new HttpRule(1021013) { // from class: com.baidu.live.im.f.13
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
    private HttpRule aRh = new HttpRule(1021012) { // from class: com.baidu.live.im.f.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            return null;
        }
    };
    CustomMessageListener aRi = new CustomMessageListener(2913084) { // from class: com.baidu.live.im.f.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.Cm();
        }
    };
    CustomMessageListener aES = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.im.f.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.Cs();
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.im.f.16.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.Ct();
                }
            });
        }
    };
    private HttpRule aRj = new HttpRule(1021006) { // from class: com.baidu.live.im.f.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            f.this.Cs();
            if (f.this.avW != null && f.this.avW.mLiveSdkInfo != null && f.this.avW.mLiveSdkInfo.mCastIds != null) {
                String str = f.this.avW.mLiveSdkInfo.mCastIds.avv;
                String str2 = f.this.avW.mLiveSdkInfo.mCastIds.avw;
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str, -1, "", "", "");
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str2, -1, "", "", "");
            }
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.im.f.17.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.Ct();
                }
            });
            return httpMessage;
        }
    };
    private IFetchMsgByIdListener aRk = new IFetchMsgByIdListener() { // from class: com.baidu.live.im.f.3
        @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
        public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList) {
            if (TbConfig.IM_LOG) {
                Log.d("im-debug", "fetch history msg received size=" + arrayList.size());
            }
            f.this.a(i, arrayList, true);
        }
    };
    private IFetchMsgByIdListener aRl = new IFetchMsgByIdListener() { // from class: com.baidu.live.im.f.4
        @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
        public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList) {
            if (TbConfig.IM_LOG) {
                Log.d("im-debug", "fetch msg received size=" + arrayList.size());
            }
            f.this.a(i, arrayList, false);
        }
    };
    private com.baidu.c.a.b.a.d aRm = new com.baidu.c.a.b.a.d() { // from class: com.baidu.live.im.f.5
        @Override // com.baidu.c.a.b.a.d
        public void e(int i, List<com.baidu.c.a.b.a.c> list) {
            String str;
            String str2;
            JSONObject jSONObject;
            if (f.this.avW == null || f.this.avv == null || f.this.avw == null || f.this.avW.mLiveInfo == null) {
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收: 直播间已销毁");
                }
            } else if (i != 0 && i != f.aQP && i != f.aQQ) {
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收: 非有效消息");
                }
            } else {
                ALAGroupHttpResponseMessage aLAGroupHttpResponseMessage = new ALAGroupHttpResponseMessage();
                ArrayList arrayList = new ArrayList();
                if (f.this.aRa != null) {
                    f.this.aRa.clear();
                }
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收:");
                }
                for (com.baidu.c.a.b.a.c cVar : list) {
                    if (cVar == null) {
                        if (TbConfig.IM_LOG) {
                            Log.i("imlog", "@.@ IM消息 接收: messageBean 为空");
                        }
                    } else {
                        String str3 = "";
                        if (!TextUtils.isEmpty(cVar.blr)) {
                            str = cVar.blr;
                            str2 = "";
                        } else {
                            if (cVar.blG != null && cVar.blG.blU != null) {
                                try {
                                    JSONObject jSONObject2 = new JSONObject(cVar.blG.blU);
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
                        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, f.this.avv) && !TextUtils.equals(str, f.this.avw)) {
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ IM消息 接收  非当前直播间的消息，过滤 castId：" + str + "   chatMCastId：" + f.this.avv + "   ensureMCastId: " + f.this.avw);
                            }
                            f.this.fp(str);
                        } else if (TextUtils.equals(cVar.type, "0") && TextUtils.isEmpty(str)) {
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ IM消息 接收: 如果是普通消息同时castId为空，过滤");
                            }
                            f.this.fp(str);
                        } else if (!TextUtils.isEmpty(str) || !TextUtils.equals(str2, SoUtils.SO_EVENT_ID_DEFAULT)) {
                            if (i != f.aQP && i != f.aQQ && TextUtils.equals(str, f.this.avv)) {
                                f.this.aQU = System.currentTimeMillis();
                                f.this.Cn();
                            }
                            if (!f.this.aQV.contains(Long.valueOf(cVar.msgId))) {
                                if (i == f.aQP) {
                                    String str4 = "";
                                    if (!TextUtils.isEmpty(cVar.blH)) {
                                        try {
                                            JSONObject jSONObject3 = new JSONObject(cVar.blH);
                                            str4 = jSONObject3.optString("msgType");
                                            if (TextUtils.isEmpty(str4)) {
                                                str4 = jSONObject3.optString("msg_type");
                                            }
                                        } catch (JSONException e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                    if (TextUtils.equals(cVar.type, "0")) {
                                        if (!TextUtils.isEmpty(str4) && !TextUtils.equals(str4, "1")) {
                                        }
                                    }
                                }
                                List<a> a = r.a(cVar);
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
                                            if (aVar.DB() != null && (!TextUtils.isEmpty(aVar.DB().name_show) || !TextUtils.isEmpty(aVar.DB().userName))) {
                                                arrayList.add(aVar);
                                            }
                                            i2 = i3 + 1;
                                        }
                                    } else {
                                        arrayList.addAll(a);
                                    }
                                    if (i == 0 && cVar.blG != null && !TextUtils.isEmpty(cVar.blG.blU)) {
                                        if (f.this.aRa == null) {
                                            f.this.aRa = new ArrayList();
                                        }
                                        f.this.aRa.add(cVar.blG.blU);
                                    }
                                    if (!TextUtils.equals(cVar.type, TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY)) {
                                        if (TextUtils.equals(str2, SoUtils.SO_EVENT_ID_DEFAULT)) {
                                            f.this.aQT += a.size();
                                            if (f.this.avW != null && f.this.avW.isHost) {
                                                for (a aVar2 : a) {
                                                    if (aVar2.getMsgType() == 24) {
                                                        JSONObject jSONObject4 = new JSONObject();
                                                        if (aVar2.getObjContent() instanceof JSONObject) {
                                                            jSONObject = (JSONObject) aVar2.getObjContent();
                                                        } else {
                                                            try {
                                                                jSONObject = new JSONObject(aVar2.getContent());
                                                            } catch (JSONException e3) {
                                                                BdLog.e(e3);
                                                                jSONObject = null;
                                                            }
                                                            aVar2.setObjContent(jSONObject);
                                                        }
                                                        if (jSONObject != null) {
                                                            try {
                                                                jSONObject4.put(LogConfig.LOG_GIFT_ID, jSONObject.optString(LogConfig.LOG_GIFT_ID));
                                                                jSONObject4.put("gift_count", jSONObject.optLong("gift_count"));
                                                                if (aVar2.DB() != null) {
                                                                    jSONObject4.put("sender_uk", EncryptionHelper.getEncryptionUserId(aVar2.DB().userId));
                                                                }
                                                                jSONObject4.put("rec_time", System.currentTimeMillis());
                                                            } catch (JSONException e4) {
                                                                BdLog.e(e4);
                                                            }
                                                            UbcStatisticManager.getInstance().debugException(new UbcDebugItem(UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.DebugContentValue.GIFT, jSONObject4), "gift_rec");
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            f.this.aQS += a.size();
                                        }
                                    }
                                    if (f.this.aQV.size() > 200) {
                                        f.this.aQV.removeFirst();
                                    }
                                    f.this.aQV.add(Long.valueOf(cVar.msgId));
                                    if (!TextUtils.equals(str, f.this.avv) || cVar.msgId <= f.this.aQW) {
                                        if (TextUtils.equals(str, f.this.avv) && cVar.msgId > f.this.aQX) {
                                            f.this.aQX = cVar.msgId;
                                        }
                                    } else {
                                        f.this.aQW = cVar.msgId;
                                    }
                                }
                            } else if (TbConfig.IM_LOG) {
                                Log.d("im-debug", "remove repeat msg msgid=" + cVar.msgId + " type=" + cVar.type);
                            }
                        } else {
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ IM消息 接收: 如果是普通消息同时castId为空，过滤礼物消息");
                            }
                            f.this.fp(str);
                        }
                    }
                }
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收: 消息分发 Size: " + arrayList.size() + "  History: " + (i == f.aQP));
                }
                if (arrayList.size() > 0) {
                    aLAGroupHttpResponseMessage.bI(i == f.aQP);
                    aLAGroupHttpResponseMessage.L(arrayList);
                    aLAGroupHttpResponseMessage.setGroupId(f.this.avW.mLiveInfo.getGroupID());
                    MessageManager.getInstance().dispatchResponsedMessage(aLAGroupHttpResponseMessage);
                    if (f.this.aRa != null && !f.this.aRa.isEmpty()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913107, f.this.aRa));
                    }
                }
            }
        }
    };
    private CustomMessageListener aRn = new CustomMessageListener(2913108) { // from class: com.baidu.live.im.f.6
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
                f.this.Cu();
            }
        }
    };
    private CustomMessageListener aRo = new CustomMessageListener(2913190) { // from class: com.baidu.live.im.f.7
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
                    f.this.Cu();
                } else {
                    SafeHandler.getInst().removeCallbacks(f.this.aRp);
                    SafeHandler.getInst().postDelayed(f.this.aRp, 1000L);
                }
            }
            if (TbadkCoreApplication.getInst().isTieba()) {
                if (LoginManager.getInstance(TbadkCoreApplication.getInst().getContext()).isIMLogined()) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ IM消息 贴吧直播间切前台监听 -- IM 没断，直接 join");
                    }
                    f.this.Cu();
                    return;
                }
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 贴吧直播间切前台监听 -- IM 断");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913191, null));
            }
        }
    };
    private Runnable aRp = new Runnable() { // from class: com.baidu.live.im.f.8
        @Override // java.lang.Runnable
        public void run() {
            f.this.Cu();
        }
    };
    private Runnable aRq = new Runnable() { // from class: com.baidu.live.im.f.9
        @Override // java.lang.Runnable
        public void run() {
            if (System.currentTimeMillis() - f.this.aQU > 18000) {
                f.this.aQR = true;
                if (f.this.avW != null && f.this.avW.isHost) {
                    f.this.Co();
                    f.this.Cp();
                }
                f.this.Cq();
            } else if (f.this.aQR) {
                f.this.aQR = false;
                f.this.Cq();
            }
            f.this.Cn();
        }
    };
    private CustomMessageTask.CustomRunnable aRr = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.im.f.10
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            String str;
            if (f.this.avW != null && f.this.avW.mLiveSdkInfo != null && f.this.avW.mLiveSdkInfo.mCastIds != null) {
                str = f.this.avW.mLiveSdkInfo.mCastIds.avw;
            } else {
                str = "0";
            }
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID, str);
        }
    };

    public static f Cl() {
        if (aQO == null) {
            synchronized (f.class) {
                if (aQO == null) {
                    aQO = new f();
                }
            }
        }
        return aQO;
    }

    private f() {
    }

    public void ao(Context context) {
        this.mContext = context;
        MessageManager.getInstance().unRegisterListener(this.aRd);
        MessageManager.getInstance().registerListener(this.aRd);
        MessageManager.getInstance().removeMessageRule(this.aRh);
        MessageManager.getInstance().addMessageRule(this.aRh);
        MessageManager.getInstance().unRegisterListener(this.aRi);
        MessageManager.getInstance().registerListener(this.aRi);
        MessageManager.getInstance().unRegisterListener(this.aRn);
        MessageManager.getInstance().registerListener(this.aRn);
        MessageManager.getInstance().unRegisterListener(this.aRo);
        MessageManager.getInstance().registerListener(this.aRo);
        new CustomMessageTask(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID, this.aRr).setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID);
    }

    public void Cm() {
        SafeHandler.getInst().removeCallbacks(this.aRp);
        SafeHandler.getInst().removeCallbacks(this.aRq);
        com.baidu.c.b.a.az(this.mContext).JS().Cs();
        this.aRc = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cn() {
        SafeHandler.getInst().removeCallbacks(this.aRq);
        if (this.avW != null && this.avW.mLiveInfo != null) {
            SafeHandler.getInst().postDelayed(this.aRq, 18000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Co() {
        int i;
        String str;
        String str2;
        if (this.avW != null) {
            if (this.avW.mLiveSdkInfo != null && this.avW.mLiveSdkInfo.mCastIds != null) {
                this.avv = this.avW.mLiveSdkInfo.mCastIds.avv;
                String str3 = this.avW.mLiveSdkInfo.mCastIds.avx;
                this.avw = this.avW.mLiveSdkInfo.mCastIds.avw;
                String str4 = this.avW.mLiveSdkInfo.mCastIds.avz;
                i = JavaTypesHelper.toInt(this.avW.mLiveSdkInfo.mCastIds.avA, 5) * 1000;
                str = str4;
                str2 = str3;
            } else if (this.avW.mLiveInfo == null || this.avW.mLiveInfo.mCastIds == null) {
                i = 5000;
                str = "";
                str2 = "";
            } else {
                this.avv = this.avW.mLiveInfo.mCastIds.avv;
                String str5 = this.avW.mLiveInfo.mCastIds.avx;
                this.avw = this.avW.mLiveInfo.mCastIds.avw;
                String str6 = this.avW.mLiveInfo.mCastIds.avz;
                i = JavaTypesHelper.toInt(this.avW.mLiveInfo.mCastIds.avA, 5) * 1000;
                str = str6;
                str2 = str5;
            }
            a(this.avv, str2, i, false);
            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", this.avv, this.avv, 0, "", "", "");
            a(this.avw, str, i, this.avW.isHost);
            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", this.avv, this.avw, 0, "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cp() {
        if (TbConfig.IM_LOG) {
            Log.d("im-debug", "start fetch im chat castid=" + this.avv + "lastmsgid=" + this.aQW);
        }
        int i = 25;
        if (this.aQW == 0) {
            i = -25;
        }
        BIMManager.fetchMsgRequest(this.mContext, AccountManager.getAppid(this.mContext), AccountManager.getUK(this.mContext), 4, JavaTypesHelper.toLong(this.avv, -1L), this.aQW, Long.MAX_VALUE, i, 1, this.aRl);
        int i2 = 25;
        if (this.aQX == 0) {
            i2 = -25;
        }
        if (TbConfig.IM_LOG) {
            Log.d("im-debug", "start fetch im ensure castid=" + this.avw + " lastmsgid=" + this.aQX);
        }
        BIMManager.fetchMsgRequest(this.mContext, AccountManager.getAppid(this.mContext), AccountManager.getUK(this.mContext), 4, JavaTypesHelper.toLong(this.avw, -1L), this.aQX, Long.MAX_VALUE, i2, 1, this.aRl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cq() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME), Long.class);
        if (runTask == null) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("im_state", this.aQR ? 0 : 1);
            jSONObject.put("im_chat_mcast_id", this.avv);
            jSONObject.put("im_ensure_mcast_id", this.avw);
            jSONObject.put("im_live_info_time", j);
            jSONObject.put("im_last_msg_time", this.aQU);
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
        a((JSONObject) null, (JSONObject) null, "1529", UbcStatConstant.ContentType.UBC_TYPE_IM_JOIN, str);
        com.baidu.c.b.a.az(this.mContext).JS().a(str, str2, i, new com.baidu.c.a.b.b() { // from class: com.baidu.live.im.f.18
            @Override // com.baidu.c.a.b.b
            public void onResult(int i2, long j, long j2) {
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ enterRoom onResult i:" + i2 + ", l:" + j + ", l1:" + j2);
                }
                if (f.this.avW == null || f.this.avv == null || f.this.avw == null) {
                    com.baidu.c.b.a.az(f.this.mContext).JS().fZ(String.valueOf(j));
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.avv, String.valueOf(j), -1, "", "", "");
                    return;
                }
                long j3 = JavaTypesHelper.toLong(f.this.avv, -1L);
                long j4 = JavaTypesHelper.toLong(f.this.avw, -1L);
                if (j3 != j && j4 != j) {
                    com.baidu.c.b.a.az(f.this.mContext).JS().fZ(String.valueOf(j));
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.avv, String.valueOf(j), -1, "", "", "");
                    if (TbConfig.IM_LOG) {
                        Log.e("imlog", "BDIM enterRoom wrong then exit end:" + j);
                        return;
                    }
                    return;
                }
                if (j3 == j) {
                    f.this.aQS = 0;
                } else {
                    f.this.aQT = 0;
                }
                if (i2 != 0) {
                    f.this.a(j, i2, j3 == j ? f.this.aQY : f.this.aQZ);
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
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_FAIL_IM_NOT_LOGIN, f.this.avv, str, -1, "", "", "");
                } else if (i2 == 1314 || i2 == 1306) {
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_MSG_ENTER_IM_FAIL, f.this.avv, str, -1, String.valueOf(i2), "", "");
                } else if (i2 != 0) {
                    if (j3 == j) {
                        if (f.this.aQY < 6) {
                            f.this.a(str, str2, i, z);
                            f.this.aQY++;
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_MSG_FAIL_TO_REJOIN, f.this.avv, str, -1, "", "", "");
                            return;
                        }
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.avv, str, -1, "", "", "");
                    } else if (f.this.aQZ < 6) {
                        f.this.a(str, str2, i, z);
                        f.this.aQZ++;
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_GIFT_FAIL_TO_REJOIN, f.this.avv, str, -1, "", "", "");
                    } else {
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.avv, str, -1, "", "", "");
                    }
                } else if (j3 == j) {
                    f.this.aQY = 0;
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", f.this.avv, str, 0, "", "", "");
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ enterRoom onResult JOIN Msg成功:" + j3);
                    }
                    if ((!f.this.avW.isHost || (f.this.avW.isHost && f.this.avW.avK)) && f.this.aRc != j3) {
                        f.this.aRc = j3;
                        long j5 = JavaTypesHelper.toLong(str, -1L);
                        BIMManager.fetchMsgRequest(f.this.mContext, AccountManager.getAppid(f.this.mContext), AccountManager.getUK(f.this.mContext), 4, j5, 0L, Long.MAX_VALUE, -25, 1, f.this.aRk);
                        if (TbConfig.IM_LOG) {
                            Log.i("imlog", "@.@ enterRoom fetchMsgidByMsgid:   " + j5);
                        }
                    }
                } else {
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", f.this.avv, str, 0, "", "", "");
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ enterRoom onResult JOIN Gift成功:" + j4);
                    }
                    f.this.aQZ = 0;
                }
            }
        }, z);
        Cr();
        fo(str);
        if (TbConfig.IM_LOG) {
            Log.i("imlog", "@.@ enterRoom registerMsgReceiveListener:" + z + ", mCastId: " + str);
        }
    }

    private void Cr() {
        MessageManager.getInstance().unRegisterListener(this.aES);
        MessageManager.getInstance().registerListener(this.aES);
        MessageManager.getInstance().unRegisterListener(this.aRe);
        MessageManager.getInstance().registerListener(this.aRe);
        MessageManager.getInstance().unRegisterListener(this.aRf);
        MessageManager.getInstance().registerListener(this.aRf);
        MessageManager.getInstance().removeMessageRule(this.aRg);
        MessageManager.getInstance().addMessageRule(this.aRg);
        MessageManager.getInstance().removeMessageRule(this.aRj);
        MessageManager.getInstance().addMessageRule(this.aRj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cs() {
        SafeHandler.getInst().removeCallbacks(this.aRp);
        SafeHandler.getInst().removeCallbacks(this.aRq);
        if (this.avW != null && this.avW.mLiveSdkInfo != null && this.avW.mLiveSdkInfo.mCastIds != null) {
            String str = this.avW.mLiveSdkInfo.mCastIds.avv;
            String str2 = this.avW.mLiveSdkInfo.mCastIds.avw;
            com.baidu.c.b.a.az(this.mContext).JS().fZ(str);
            com.baidu.c.b.a.az(this.mContext).JS().fZ(str2);
            Cv();
        }
        this.aQS = 0;
        this.aQT = 0;
        this.aRc = 0L;
        this.avW = null;
        this.avv = null;
        this.avw = null;
        this.aQY = 0;
        this.aQZ = 0;
        if (this.aRa != null) {
            this.aRa.clear();
            this.aRa = null;
        }
        if (this.aRb != null) {
            this.aRb.clear();
            this.aRb = null;
        }
        this.aQV.clear();
        this.aQW = 0L;
        this.aQW = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ct() {
        MessageManager.getInstance().unRegisterListener(this.aRe);
        MessageManager.getInstance().unRegisterListener(this.aRf);
        MessageManager.getInstance().unRegisterListener(this.aES);
        MessageManager.getInstance().removeMessageRule(this.aRg);
        MessageManager.getInstance().removeMessageRule(this.aRj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(List<AlaLiveMarkData> list) {
        if (list != null && !list.isEmpty()) {
            if (this.aRb == null) {
                this.aRb = new ArrayList();
            }
            this.aRb.clear();
            this.aRb.addAll(list);
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
        final String str2 = (this.avW == null || this.avW.mLiveSdkInfo == null || this.avW.mLiveSdkInfo.mCastIds == null) ? null : this.avW.mLiveSdkInfo.mCastIds.avv;
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.c.a.b.a.e eVar = new com.baidu.c.a.b.a.e();
            eVar.msg = content;
            eVar.blr = str2;
            if (this.avW != null && this.avW.avC != null) {
                eVar.name = this.avW.avC.userName;
                eVar.portrait = this.avW.avC.portrait;
            }
            a aVar2 = new a();
            if (this.avW != null) {
                if (this.avW.isHost) {
                    alaLiveUserInfoData = this.avW.avj;
                } else {
                    alaLiveUserInfoData = this.avW.avC;
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
                    aVar3.aus = alaLiveUserInfoData.followCount;
                    aVar3.aur = alaLiveUserInfoData.fansCount;
                    aVar3.auv = alaLiveUserInfoData.isAdmin == 1;
                    aVar3.auu = alaLiveUserInfoData.isOfficial == 1;
                    aVar3.level_id = alaLiveUserInfoData.levelId;
                    aVar3.aux = this.aRb;
                    aVar3.sex = alaLiveUserInfoData.sex;
                    aVar3.extraUserInfo = alaLiveUserInfoData.extraUserInfo;
                    aVar2.e(aVar3);
                    aVar2.setContent(content);
                    aVar2.setMsgType(aVar.DM());
                    aVar2.cv(aVar.DF());
                    aVar2.fr(aVar.DG());
                    aVar2.a(aVar.DH());
                    aVar2.k(aVar.DI());
                    aVar2.setUserId(alaLiveUserInfoData.userId);
                    aVar2.fl(String.valueOf(this.avW.mLiveInfo.user_id));
                    aVar2.setBornTime(System.currentTimeMillis());
                    str = aVar2.BQ();
                }
            }
            eVar.blH = str;
            com.baidu.c.a.b.a.f fVar = new com.baidu.c.a.b.a.f() { // from class: com.baidu.live.im.f.2
                @Override // com.baidu.c.a.b.a.f
                public void a(String str3, int i, List<com.baidu.c.a.b.a.c> list) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ IM消息 onSendSuccess s:" + str3 + ", i:" + i);
                    }
                    if (f.this.avW != null && f.this.avv != null && f.this.avw != null) {
                        if (TextUtils.equals(str3, f.this.avv) || TextUtils.equals(str3, f.this.avw)) {
                            ALAGroupCommitHttpResponsedMessage aLAGroupCommitHttpResponsedMessage = new ALAGroupCommitHttpResponsedMessage();
                            aLAGroupCommitHttpResponsedMessage.setStatusCode(200, null);
                            if (f.this.avW.mLiveInfo != null) {
                                f.this.a(aVar, i, str2, list);
                            }
                            aLAGroupCommitHttpResponsedMessage.setError(i);
                            if (i == 0) {
                                f.this.G(list);
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
                            if (com.baidu.live.liveroom.a.EI().EJ()) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913093));
                            }
                        }
                    }
                }
            };
            aq(content, str2);
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
            com.baidu.c.b.a.az(this.mContext).JS().a(str2, eVar, fVar);
            if (TbConfig.IM_LOG) {
                Log.i("imlog", "@.@ IM消息 发送 roomId:" + str2 + ", sendMessage:" + eVar.toString());
            }
        }
    }

    private void aq(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("im_send_content", str);
            a(jSONObject, (JSONObject) null, "1529", UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, str2);
        } catch (JSONException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.im.message.a aVar, int i, String str, List<com.baidu.c.a.b.a.c> list) {
        if (TbadkCoreApplication.getInst().isHaokan()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SUC_SEND_NEWS);
            alaStaticItem.addParams("live_id", this.avW.mLiveInfo.live_id + "");
            alaStaticItem.addParams("room_id", this.avW.mLiveInfo.room_id + "");
            alaStaticItem.addParams("feed_id", this.avW.mLiveInfo.feed_id + "");
            alaStaticItem.addParams("other_params", aVar.DN());
            if (aVar.DM() == 126) {
                alaStaticItem.addParams("gifts_value", String.valueOf(aVar.DO()));
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SUC_SEND_NEWS);
            alaStaticItem2.addParams("live_id", this.avW.mLiveInfo.live_id + "");
            alaStaticItem2.addParams("room_id", this.avW.mLiveInfo.room_id + "");
            alaStaticItem2.addParams("feed_id", this.avW.mLiveInfo.feed_id + "");
            alaStaticItem2.addParams("other_params", aVar.DN());
            if (aVar.DM() == 126) {
                alaStaticItem2.addParams("gifts_value", String.valueOf(aVar.DO()));
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem2);
        }
        if (aVar.DM() == 126) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "msg_send").setContentExt("barrage", null, null));
        } else if (aVar.DP()) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "msg_send").setContentExt("fastkey", null, null));
        } else {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "msg_send").setContentExt("manual", null, null));
        }
        if (list != null && !list.isEmpty()) {
            try {
                for (com.baidu.c.a.b.a.c cVar : list) {
                    if (cVar != null) {
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("msg_id", cVar.msgId + "");
                        jSONObject.put("code", i);
                        a(jSONObject2, jSONObject, "1537", UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, str);
                    }
                }
            } catch (JSONException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(List<com.baidu.c.a.b.a.c> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.c.a.b.a.c cVar : list) {
                if (cVar != null) {
                    String str = "";
                    if (!TextUtils.isEmpty(cVar.blr)) {
                        str = cVar.blr;
                    } else if (cVar.blG != null && cVar.blG.blU != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(cVar.blG.blU);
                            if (!TextUtils.isEmpty(jSONObject.optString("room_id"))) {
                                str = jSONObject.optString("room_id");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    if (TextUtils.isEmpty(str) || TextUtils.equals(str, this.avv) || TextUtils.equals(str, this.avw)) {
                        List<a> a = r.a(cVar, true);
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
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ArrayList<ChatMsg> arrayList, boolean z) {
        if ((i == 0 || i == 200) && arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<ChatMsg> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.c.a.b.a.c a = com.baidu.c.b.a.a.a.a.a(it.next());
                if (a != null) {
                    arrayList2.add(a);
                }
            }
            if (!arrayList2.isEmpty()) {
                Collections.reverse(arrayList2);
                this.aRm.e(z ? aQP : aQQ, arrayList2);
            }
        }
    }

    private void fo(String str) {
        com.baidu.c.b.a.az(this.mContext).JS().a(str, this.aRm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fp(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("im_worng_mcastid", str);
            jSONObject.put("im_wrong_msgs", 1);
            jSONObject.put("im_chat_mcast_id", this.avv);
            jSONObject.put("im_ensure_mcast_id", this.avw);
            a(jSONObject, (JSONObject) null, "1537", UbcStatConstant.ContentType.UBC_TYPE_IM_WRONG_ID, (String) null);
        } catch (JSONException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cu() {
        if (this.avW != null && this.avW.mLiveSdkInfo != null && this.avW.mLiveSdkInfo.mCastIds != null) {
            this.aQY = 0;
            this.aQZ = 0;
            this.avv = this.avW.mLiveSdkInfo.mCastIds.avv;
            String str = this.avW.mLiveSdkInfo.mCastIds.avx;
            this.avw = this.avW.mLiveSdkInfo.mCastIds.avw;
            String str2 = this.avW.mLiveSdkInfo.mCastIds.avz;
            int i = JavaTypesHelper.toInt(this.avW.mLiveSdkInfo.mCastIds.avA, 5) * 1000;
            a(this.avv, str, i, false);
            a(this.avw, str2, i, this.avW.isHost);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, int i, int i2) {
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

    private void Cv() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("im_chat_mcast_id", this.avv);
            jSONObject.put("im_ensure_mcast_id", this.avw);
            jSONObject.put("im_chat_mcast_count", this.aQS);
            jSONObject.put("im_ensure_mcast_count", this.aQT);
            a(jSONObject, (JSONObject) null, "1529", UbcStatConstant.ContentType.UBC_TYPE_IM_LEAVE, (String) null);
        } catch (JSONException e) {
        }
    }

    private JSONObject F(JSONObject jSONObject) {
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
        if (this.avW != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            if (TbConfig.IM_LOG) {
                Log.i("imUbclog", "Json: " + jSONObject.toString() + "  type: " + str2 + " isHost: " + this.avW.isHost);
            }
            JSONObject jSONObject3 = new JSONObject();
            F(jSONObject);
            try {
                jSONObject3.put("im", jSONObject);
                if (jSONObject2 != null) {
                    jSONObject3.put(BdStatsConstant.StatsType.ERROR, jSONObject2);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(str, str2, this.avW.isHost ? UbcStatConstant.Page.AUTHOR_LIVE_ROOM : "liveroom", str3);
            ubcStatisticItem.setContentExt(jSONObject3);
            UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
        }
    }
}
