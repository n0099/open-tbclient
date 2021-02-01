package com.baidu.live.im;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.controller.HttpRule;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.ab;
import com.baidu.live.im.message.ALAGroupCommitHttpResponsedMessage;
import com.baidu.live.im.message.ALAGroupHttpResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.extraparams.interfaces.IExtraParams;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticKeys;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.ubc.UbcAudioFlowStatisticManager;
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
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f {
    private static volatile f blJ = null;
    private static int blK = Integer.MAX_VALUE;
    private static int blL = 2147483646;
    private ab aJZ;
    private boolean blM;
    private int blN;
    private int blO;
    private List<String> blV;
    private List<AlaLiveMarkData> blW;
    private long blX;
    private String chatMCastId;
    private String ensureMCastId;
    private Context mContext;
    private long blP = 0;
    private LinkedList<Long> blQ = new LinkedList<>();
    private long blR = 0;
    private long blS = 0;
    private Handler handler = new Handler();
    private int blT = 0;
    private int blU = 0;
    private CustomMessageListener blY = new CustomMessageListener(2913081) { // from class: com.baidu.live.im.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ab abVar;
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0) {
                f.this.blP = 0L;
                if (com.baidu.h.b.a.bA(f.this.mContext).ZU() == null || !(customResponsedMessage.getData() instanceof ab) || (abVar = (ab) customResponsedMessage.getData()) == null) {
                    return;
                }
                if ((abVar.mLiveSdkInfo != null && abVar.mLiveSdkInfo.mCastIds != null) || (abVar.mLiveInfo != null && abVar.mLiveInfo.mCastIds != null)) {
                    if (abVar.mLiveInfo == null || abVar.mLiveInfo.live_status != 2) {
                        if (f.this.aJZ != null && f.this.aJZ.mLiveInfo != null && abVar != null && abVar.mLiveInfo != null && abVar.mLiveInfo.live_id != f.this.aJZ.mLiveInfo.live_id) {
                            f.this.blQ.clear();
                            f.this.blR = 0L;
                            f.this.blS = 0L;
                        }
                        f.this.aJZ = abVar;
                        f.this.T(f.this.aJZ.aIK);
                        f.this.JQ();
                        f.this.JP();
                    }
                }
            }
        }
    };
    private CustomMessageListener blZ = new CustomMessageListener(2913082) { // from class: com.baidu.live.im.f.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof ab)) {
                ab abVar = (ab) customResponsedMessage.getData();
                if (f.this.aJZ != null && f.this.aJZ.mLiveInfo != null && abVar != null && abVar.mLiveInfo != null && abVar.mLiveInfo.live_id != f.this.aJZ.mLiveInfo.live_id) {
                    f.this.blQ.clear();
                    f.this.blR = 0L;
                    f.this.blS = 0L;
                }
                f.this.aJZ = abVar;
                f.this.T(f.this.aJZ.aIK);
            }
        }
    };
    private CustomMessageListener bma = new CustomMessageListener(2501033) { // from class: com.baidu.live.im.f.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof ab)) {
                ab abVar = (ab) customResponsedMessage.getData();
                if (f.this.aJZ != null && f.this.aJZ.mLiveInfo != null && abVar != null && abVar.mLiveInfo != null && abVar.mLiveInfo.live_id != f.this.aJZ.mLiveInfo.live_id) {
                    f.this.blQ.clear();
                    f.this.blR = 0L;
                    f.this.blS = 0L;
                }
                f.this.aJZ = abVar;
                f.this.T(f.this.aJZ.aIK);
            }
        }
    };
    private CustomMessageListener bmb = new CustomMessageListener(2913118) { // from class: com.baidu.live.im.f.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof ab)) {
                f.this.T(((ab) customResponsedMessage.getData()).aIK);
            }
        }
    };
    private HttpRule bmc = new HttpRule(1021013) { // from class: com.baidu.live.im.f.15
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
    private HttpRule bmd = new HttpRule(1021012) { // from class: com.baidu.live.im.f.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            return null;
        }
    };
    CustomMessageListener bme = new CustomMessageListener(2913084) { // from class: com.baidu.live.im.f.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.yp();
        }
    };
    CustomMessageListener aWK = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.im.f.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.JU();
            f.this.handler.post(new Runnable() { // from class: com.baidu.live.im.f.18.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.JV();
                }
            });
        }
    };
    private HttpRule bmf = new HttpRule(1021006) { // from class: com.baidu.live.im.f.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            f.this.JU();
            if (f.this.aJZ != null && f.this.aJZ.mLiveSdkInfo != null && f.this.aJZ.mLiveSdkInfo.mCastIds != null) {
                String str = f.this.aJZ.mLiveSdkInfo.mCastIds.chatMCastId;
                String str2 = f.this.aJZ.mLiveSdkInfo.mCastIds.ensureMCastId;
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str, -1, "", "", "");
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str2, -1, "", "", "");
            }
            f.this.handler.post(new Runnable() { // from class: com.baidu.live.im.f.19.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.JV();
                }
            });
            return httpMessage;
        }
    };
    private IFetchMsgByIdListener bmg = new IFetchMsgByIdListener() { // from class: com.baidu.live.im.f.4
        @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
        public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList) {
            UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_IM_RECENT_MSG_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "recentMessage");
            if (String.valueOf(j).equals(f.this.chatMCastId) || String.valueOf(j).equals(f.this.ensureMCastId)) {
                if (TbConfig.IM_LOG) {
                    Log.d("im-debug", "fetch history msg received size=" + arrayList.size());
                }
                f.this.a(i, arrayList, true);
            } else if (TbConfig.IM_LOG) {
                Log.d("im-debug", "onFetchMsgByIdResult 非当前直播间 ：l: " + j);
            }
        }
    };
    private IFetchMsgByIdListener bmh = new IFetchMsgByIdListener() { // from class: com.baidu.live.im.f.5
        @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
        public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList) {
            if (String.valueOf(j).equals(f.this.chatMCastId) || String.valueOf(j).equals(f.this.ensureMCastId)) {
                if (TbConfig.IM_LOG) {
                    Log.d("im-debug", "fetch msg received size=" + arrayList.size());
                }
                f.this.a(i, arrayList, false);
            } else if (TbConfig.IM_LOG) {
                Log.d("im-debug", "onFetchMsgByIdResult 非当前直播间 ：l: " + j);
            }
        }
    };
    private com.baidu.h.a.b.a.d bmi = new com.baidu.h.a.b.a.d() { // from class: com.baidu.live.im.f.6
        @Override // com.baidu.h.a.b.a.d
        public void e(int i, List<com.baidu.h.a.b.a.c> list) {
            String str;
            JSONObject jSONObject;
            String optString;
            if (f.this.aJZ == null || f.this.chatMCastId == null || f.this.ensureMCastId == null || f.this.aJZ.mLiveInfo == null) {
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收: 直播间已销毁");
                }
            } else if (i != 0 && i != f.blK && i != f.blL) {
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收: 非有效消息");
                }
            } else {
                ALAGroupHttpResponseMessage aLAGroupHttpResponseMessage = new ALAGroupHttpResponseMessage();
                aLAGroupHttpResponseMessage.setStatusCode(200, "");
                ArrayList arrayList = new ArrayList();
                if (f.this.blV != null) {
                    f.this.blV.clear();
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
                        if (TbConfig.IM_LOG && cVar.ceM != null) {
                            try {
                                String str2 = cVar.ceM.cfa;
                                if (str2 != null) {
                                    Log.i("imlog", "@.@ IM消息 接收: contentType=" + new JSONObject(optString).optString("content_type") + ";;;content=" + new JSONObject(str2).optString("content"));
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        String str3 = "";
                        if (!TextUtils.isEmpty(cVar.aTK)) {
                            str3 = cVar.aTK;
                            str = "";
                        } else {
                            if (cVar.ceM != null && cVar.ceM.cfa != null) {
                                try {
                                    JSONObject jSONObject2 = new JSONObject(cVar.ceM.cfa);
                                    if (!TextUtils.isEmpty(jSONObject2.optString("room_id"))) {
                                        str3 = jSONObject2.optString("room_id");
                                    }
                                    String optString2 = jSONObject2.optString("msg_type");
                                    if (TextUtils.isEmpty(optString2)) {
                                        optString2 = jSONObject2.optString("msgType");
                                    }
                                    str = optString2;
                                } catch (JSONException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            str = "";
                        }
                        if (!TextUtils.isEmpty(str3) && !TextUtils.equals(str3, f.this.chatMCastId) && !TextUtils.equals(str3, f.this.ensureMCastId)) {
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ IM消息 接收  非当前直播间的消息，过滤 castId：" + str3 + "   chatMCastId：" + f.this.chatMCastId + "   ensureMCastId: " + f.this.ensureMCastId);
                            }
                            f.this.ha(str3);
                        } else if (TextUtils.equals(cVar.type, "0") && TextUtils.isEmpty(str3)) {
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ IM消息 接收: 如果是普通消息同时castId为空，过滤");
                            }
                            f.this.ha(str3);
                        } else if (!TextUtils.isEmpty(str3) || !TextUtils.equals(str, SoUtils.SO_EVENT_ID_DEFAULT)) {
                            if (i != f.blK && i != f.blL && TextUtils.equals(str3, f.this.chatMCastId)) {
                                f.this.blP = System.currentTimeMillis();
                                if (TbConfig.IM_LOG) {
                                    Log.d("im-debug", "receiveChatMsgTime= " + f.this.blP);
                                }
                                f.this.blM = false;
                                f.this.JP();
                            }
                            if (!f.this.blQ.contains(Long.valueOf(cVar.msgId))) {
                                if (i == f.blK) {
                                    String str4 = "";
                                    String str5 = "";
                                    if (!TextUtils.isEmpty(cVar.ceN)) {
                                        try {
                                            JSONObject jSONObject3 = new JSONObject(cVar.ceN);
                                            str4 = jSONObject3.optString("msgType");
                                            if (TextUtils.isEmpty(str4)) {
                                                str4 = jSONObject3.optString("msg_type");
                                            }
                                        } catch (JSONException e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                    if (cVar.ceM != null) {
                                        try {
                                            str5 = new JSONObject(new JSONObject(cVar.ceM.cfa).optString("content")).optString("content_type");
                                        } catch (Exception e4) {
                                            e4.printStackTrace();
                                        }
                                    }
                                    if (!TextUtils.equals(cVar.type, "0") || (!TextUtils.isEmpty(str4) && !TextUtils.equals(str4, "1"))) {
                                        if (!TextUtils.equals(str5, "audio_emoticon")) {
                                            if (TbConfig.IM_LOG) {
                                                Log.d("im-debug", "filters msg contentType=" + str5 + " type=" + cVar.type);
                                            }
                                        } else if (TbConfig.IM_LOG) {
                                            Log.d("im-debug", "no filters msg contentType=" + str5 + " type=" + cVar.type);
                                        }
                                    }
                                    if (TbConfig.IM_LOG) {
                                        Log.d("im-debug", "s == IM_HISTORY_RESPONSE_CODE：no filters msg contentType=" + str5 + " type=" + cVar.type);
                                    }
                                }
                                List<a> a2 = p.a(cVar);
                                if (a2 == null) {
                                    if (TbConfig.IM_LOG) {
                                        Log.i("imlog", "@.@ IM消息 接收: 解析后无有效消息");
                                    }
                                } else {
                                    if (TbConfig.IM_LOG) {
                                        Log.i("imlog", "@.@ IM消息解析后 chatMessages.size()=" + a2.size());
                                    }
                                    if (TextUtils.equals(cVar.type, "0")) {
                                        int i2 = 0;
                                        while (true) {
                                            int i3 = i2;
                                            if (i3 >= a2.size()) {
                                                break;
                                            }
                                            a aVar = a2.get(i3);
                                            if (aVar.KZ() != null && (!TextUtils.isEmpty(aVar.KZ().name_show) || !TextUtils.isEmpty(aVar.KZ().userName))) {
                                                arrayList.add(aVar);
                                            }
                                            i2 = i3 + 1;
                                        }
                                    } else {
                                        arrayList.addAll(a2);
                                    }
                                    if (i == 0 && cVar.ceM != null && !TextUtils.isEmpty(cVar.ceM.cfa)) {
                                        if (f.this.blV == null) {
                                            f.this.blV = new ArrayList();
                                        }
                                        f.this.blV.add(cVar.ceM.cfa);
                                    }
                                    if (!TextUtils.equals(cVar.type, "101")) {
                                        if (TextUtils.equals(str, SoUtils.SO_EVENT_ID_DEFAULT)) {
                                            f.this.blO += a2.size();
                                            if (f.this.aJZ != null) {
                                                for (a aVar2 : a2) {
                                                    if (aVar2.getMsgType() == 24) {
                                                        JSONObject jSONObject4 = new JSONObject();
                                                        if (aVar2.getObjContent() instanceof JSONObject) {
                                                            jSONObject = (JSONObject) aVar2.getObjContent();
                                                        } else {
                                                            try {
                                                                jSONObject = new JSONObject(aVar2.getContent());
                                                            } catch (JSONException e5) {
                                                                BdLog.e(e5);
                                                                jSONObject = null;
                                                            }
                                                            aVar2.setObjContent(jSONObject);
                                                        }
                                                        if (jSONObject != null) {
                                                            try {
                                                                jSONObject4.put("msgid", cVar.msgId);
                                                                jSONObject4.put(LogConfig.LOG_GIFT_ID, jSONObject.optString(LogConfig.LOG_GIFT_ID));
                                                                jSONObject4.put("gift_name", jSONObject.optString("gift_name"));
                                                                jSONObject4.put("gift_count", jSONObject.optLong("gift_count"));
                                                                if (aVar2.KZ() != null) {
                                                                    jSONObject4.put("sender_uk", EncryptionHelper.getEncryptionUserId(aVar2.KZ().userId));
                                                                }
                                                                jSONObject4.put("receive_uk", !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) ? EncryptionHelper.getEncryptionUserId(TbadkCoreApplication.getCurrentAccount()) : "");
                                                                jSONObject4.put("is_host", f.this.aJZ.isHost);
                                                                jSONObject4.put("rec_time", System.currentTimeMillis());
                                                            } catch (JSONException e6) {
                                                                BdLog.e(e6);
                                                            }
                                                            UbcStatisticManager.getInstance().debugException(new UbcDebugItem(f.this.aJZ.isHost ? "author_liveroom" : "liveroom", UbcStatConstant.DebugContentValue.GIFT, jSONObject4), "gift_rec");
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            f.this.blN += a2.size();
                                        }
                                    }
                                    if (f.this.blQ.size() > 200) {
                                        f.this.blQ.removeFirst();
                                    }
                                    f.this.blQ.add(Long.valueOf(cVar.msgId));
                                    if (!TextUtils.equals(str3, f.this.chatMCastId) || cVar.msgId <= f.this.blR) {
                                        if (TextUtils.equals(str3, f.this.chatMCastId) && cVar.msgId > f.this.blS) {
                                            f.this.blS = cVar.msgId;
                                        }
                                    } else {
                                        f.this.blR = cVar.msgId;
                                    }
                                }
                            } else if (TbConfig.IM_LOG) {
                                Log.d("im-debug", "remove repeat msg msgid=" + cVar.msgId + " type=" + cVar.type);
                            }
                        } else {
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ IM消息 接收: 如果是普通消息同时castId为空，过滤礼物消息");
                            }
                            f.this.ha(str3);
                        }
                    }
                }
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收: 消息分发 Size: " + arrayList.size() + "  History: " + (i == f.blK));
                }
                if (f.this.blV != null && !f.this.blV.isEmpty()) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.addAll(f.this.blV);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913251, arrayList2));
                }
                if (arrayList.size() <= 0) {
                    if (i == f.blK && TbadkCoreApplication.getInst().getIsYuyinRoom()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501085));
                        return;
                    }
                    return;
                }
                if (i == f.blK && TbadkCoreApplication.getInst().getIsYuyinRoom() && f.this.aJZ != null && f.this.aJZ.aIU != null && f.this.aJZ.aIU.aTS != null && !StringUtils.isNull(f.this.aJZ.aIU.aTS.content)) {
                    com.baidu.live.im.data.b JB = f.this.JB();
                    if (JB != null) {
                        JB.setMsgType(27);
                        try {
                            JSONObject jSONObject5 = new JSONObject();
                            String str6 = f.this.aJZ.aIU.aTS.content;
                            String str7 = f.this.aJZ.aIU.aTS.title;
                            jSONObject5.put("text", str6);
                            jSONObject5.put("room_id", f.this.aJZ.aIU.aTK);
                            jSONObject5.put(DpStatConstants.KEY_ROOM_NAME, f.this.aJZ.aIU.room_name);
                            jSONObject5.put("live_id", f.this.aJZ.aIU.live_id);
                            jSONObject5.put("cover", f.this.aJZ.aIU.cover);
                            jSONObject5.put("content_type", "play_rules");
                            JB.setContent(jSONObject5.toString());
                            arrayList.add(JB);
                        } catch (JSONException e7) {
                            e7.printStackTrace();
                        }
                    } else {
                        return;
                    }
                }
                aLAGroupHttpResponseMessage.cp(i == f.blK);
                aLAGroupHttpResponseMessage.Y(arrayList);
                aLAGroupHttpResponseMessage.setGroupId(f.this.aJZ.mLiveInfo.getGroupID());
                MessageManager.getInstance().dispatchResponsedMessage(aLAGroupHttpResponseMessage);
                if (f.this.blV != null && !f.this.blV.isEmpty()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913107, f.this.blV));
                }
            }
        }
    };
    private CustomMessageListener bmj = new CustomMessageListener(2913108) { // from class: com.baidu.live.im.f.7
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
                f.this.JW();
            }
        }
    };
    private CustomMessageListener bmk = new CustomMessageListener(2913190) { // from class: com.baidu.live.im.f.8
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
            if ((TbadkCoreApplication.getInst().isMobileBaidu() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isHaokan()) && LoginManager.getInstance(TbadkCoreApplication.getInst().getContext()).isIMLogined()) {
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 直播间切前台监听 -- IM 没断，直接 join");
                }
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    f.this.JW();
                } else {
                    f.this.handler.removeCallbacks(f.this.bml);
                    f.this.handler.postDelayed(f.this.bml, 1000L);
                }
            }
            if (TbadkCoreApplication.getInst().isTieba()) {
                if (LoginManager.getInstance(TbadkCoreApplication.getInst().getContext()).isIMLogined()) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ IM消息 贴吧直播间切前台监听 -- IM 没断，直接 join");
                    }
                    f.this.JW();
                    return;
                }
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 贴吧直播间切前台监听 -- IM 断");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913191, null));
            }
        }
    };
    private Runnable bml = new Runnable() { // from class: com.baidu.live.im.f.9
        @Override // java.lang.Runnable
        public void run() {
            f.this.JW();
        }
    };
    private Runnable bmm = new Runnable() { // from class: com.baidu.live.im.f.10
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (TbConfig.IM_LOG) {
                Log.d("im-debug", "imExceptionCheckRunnable: " + (currentTimeMillis - f.this.blP));
            }
            if (currentTimeMillis - f.this.blP >= 18000) {
                if (!f.this.blM) {
                    f.this.blM = true;
                    f.this.JS();
                }
                if (f.this.aJZ != null && f.this.aJZ.isHost) {
                    f.this.JQ();
                    f.this.JR();
                }
            } else if (f.this.blM) {
                f.this.blM = false;
                f.this.JS();
            }
            f.this.JP();
        }
    };
    private CustomMessageTask.CustomRunnable bmn = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.im.f.11
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            String str;
            if (f.this.aJZ != null && f.this.aJZ.mLiveSdkInfo != null && f.this.aJZ.mLiveSdkInfo.mCastIds != null) {
                str = f.this.aJZ.mLiveSdkInfo.mCastIds.ensureMCastId;
            } else {
                str = "0";
            }
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID, str);
        }
    };

    public static f JO() {
        if (blJ == null) {
            synchronized (f.class) {
                if (blJ == null) {
                    blJ = new f();
                }
            }
        }
        return blJ;
    }

    private f() {
    }

    public void aW(Context context) {
        this.mContext = context;
        MessageManager.getInstance().unRegisterListener(this.blY);
        MessageManager.getInstance().registerListener(this.blY);
        MessageManager.getInstance().removeMessageRule(this.bmd);
        MessageManager.getInstance().addMessageRule(this.bmd);
        MessageManager.getInstance().unRegisterListener(this.bme);
        MessageManager.getInstance().registerListener(this.bme);
        MessageManager.getInstance().unRegisterListener(this.bmj);
        MessageManager.getInstance().registerListener(this.bmj);
        MessageManager.getInstance().unRegisterListener(this.bmk);
        MessageManager.getInstance().registerListener(this.bmk);
        new CustomMessageTask(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID, this.bmn).setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID);
    }

    public void yp() {
        this.handler.removeCallbacksAndMessages(null);
        com.baidu.h.b.a.bA(this.mContext).ZU().JU();
        this.blX = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP() {
        this.handler.removeCallbacks(this.bmm);
        if (this.aJZ != null && this.aJZ.mLiveInfo != null) {
            this.handler.postDelayed(this.bmm, 18000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JQ() {
        int i;
        String str;
        if (this.aJZ != null) {
            String str2 = "";
            if (this.aJZ.mLiveSdkInfo != null && this.aJZ.mLiveSdkInfo.mCastIds != null) {
                this.chatMCastId = this.aJZ.mLiveSdkInfo.mCastIds.chatMCastId;
                str2 = this.aJZ.mLiveSdkInfo.mCastIds.chat_msg_hls_url;
                this.ensureMCastId = this.aJZ.mLiveSdkInfo.mCastIds.ensureMCastId;
                String str3 = this.aJZ.mLiveSdkInfo.mCastIds.reliable_msg_hls_url;
                i = JavaTypesHelper.toInt(this.aJZ.mLiveSdkInfo.mCastIds.msg_hls_pull_internal_in_second, 5) * 1000;
                str = str3;
            } else if (this.aJZ.mLiveInfo == null || this.aJZ.mLiveInfo.mCastIds == null) {
                i = 5000;
                str = "";
            } else {
                this.chatMCastId = this.aJZ.mLiveInfo.mCastIds.chatMCastId;
                str2 = this.aJZ.mLiveInfo.mCastIds.chat_msg_hls_url;
                this.ensureMCastId = this.aJZ.mLiveInfo.mCastIds.ensureMCastId;
                String str4 = this.aJZ.mLiveInfo.mCastIds.reliable_msg_hls_url;
                i = JavaTypesHelper.toInt(this.aJZ.mLiveInfo.mCastIds.msg_hls_pull_internal_in_second, 5) * 1000;
                str = str4;
            }
            a(this.chatMCastId, str2, i, false);
            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", this.chatMCastId, this.chatMCastId, 0, "", "", "");
            a(this.ensureMCastId, str, i, this.aJZ.isHost);
            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", this.chatMCastId, this.ensureMCastId, 0, "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JR() {
        if (TbConfig.IM_LOG) {
            Log.d("im-debug", "start fetch im chat castid=" + this.chatMCastId + "lastmsgid=" + this.blR);
        }
        int i = 25;
        if (this.blR == 0) {
            i = -25;
        }
        BIMManager.fetchMsgRequest(this.mContext, AccountManager.getAppid(this.mContext), AccountManager.getUK(this.mContext), 4, JavaTypesHelper.toLong(this.chatMCastId, -1L), this.blR, Long.MAX_VALUE, i, 1, this.bmh);
        int i2 = 25;
        if (this.blS == 0) {
            i2 = -25;
        }
        if (TbConfig.IM_LOG) {
            Log.d("im-debug", "start fetch im ensure castid=" + this.ensureMCastId + " lastmsgid=" + this.blS);
        }
        BIMManager.fetchMsgRequest(this.mContext, AccountManager.getAppid(this.mContext), AccountManager.getUK(this.mContext), 4, JavaTypesHelper.toLong(this.ensureMCastId, -1L), this.blS, Long.MAX_VALUE, i2, 1, this.bmh, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JS() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME), Long.class);
        if (runTask == null) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("im_state", this.blM ? 0 : 1);
            jSONObject.put("im_chat_mcast_id", this.chatMCastId);
            jSONObject.put("im_ensure_mcast_id", this.ensureMCastId);
            jSONObject.put("im_live_info_time", j);
            jSONObject.put("im_last_msg_time", this.blP);
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
            UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_IM_CONNECT_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "IMConnect", null);
            com.baidu.h.b.a.bA(this.mContext).ZU().a(str, str2, i, new com.baidu.h.a.b.b() { // from class: com.baidu.live.im.f.2
                @Override // com.baidu.h.a.b.b
                public void onResult(int i2, long j, long j2) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ enterRoom onResult i:" + i2 + ", l:" + j + ", l1:" + j2);
                    }
                    if (f.this.aJZ == null || f.this.chatMCastId == null || f.this.ensureMCastId == null) {
                        com.baidu.h.b.a.bA(f.this.mContext).ZU().iR(String.valueOf(j));
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.chatMCastId, String.valueOf(j), -1, "", "", "");
                        return;
                    }
                    UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_IM_CONNECT_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "IMConnect");
                    UbcAudioFlowStatisticManager.getInstance().endFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_IM_CONNECT_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""));
                    long j3 = JavaTypesHelper.toLong(f.this.chatMCastId, -1L);
                    long j4 = JavaTypesHelper.toLong(f.this.ensureMCastId, -1L);
                    if (j3 != j && j4 != j) {
                        com.baidu.h.b.a.bA(f.this.mContext).ZU().iR(String.valueOf(j));
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.chatMCastId, String.valueOf(j), -1, "", "", "");
                        if (TbConfig.IM_LOG) {
                            Log.e("imlog", "BDIM enterRoom wrong then exit end:" + j);
                            return;
                        }
                        return;
                    }
                    if (j3 == j) {
                        f.this.blN = 0;
                    } else {
                        f.this.blO = 0;
                    }
                    if (i2 != 0) {
                        f.this.b(j, i2, j3 == j ? f.this.blT : f.this.blU);
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
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_FAIL_IM_NOT_LOGIN, f.this.chatMCastId, str, -1, "", "", "");
                    } else if (i2 == 1314 || i2 == 1306) {
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_MSG_ENTER_IM_FAIL, f.this.chatMCastId, str, -1, String.valueOf(i2), "", "");
                    } else if (i2 != 0) {
                        if (j3 == j) {
                            if (f.this.blT < 6) {
                                f.this.handler.postDelayed(new Runnable() { // from class: com.baidu.live.im.f.2.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        f.this.a(str, str2, i, z);
                                    }
                                }, IMConnection.RETRY_DELAY_TIMES);
                                f.this.blT++;
                                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_MSG_FAIL_TO_REJOIN, f.this.chatMCastId, str, -1, "", "", "");
                                return;
                            }
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.chatMCastId, str, -1, "", "", "");
                        } else if (f.this.blU < 6) {
                            f.this.handler.postDelayed(new Runnable() { // from class: com.baidu.live.im.f.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    f.this.a(str, str2, i, z);
                                }
                            }, IMConnection.RETRY_DELAY_TIMES);
                            f.this.blU++;
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_GIFT_FAIL_TO_REJOIN, f.this.chatMCastId, str, -1, "", "", "");
                        } else {
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.chatMCastId, str, -1, "", "", "");
                        }
                    } else if (j3 == j) {
                        f.this.blT = 0;
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", f.this.chatMCastId, str, 0, "", "", "");
                        if (TbConfig.IM_LOG) {
                            Log.i("imlog", "@.@ enterRoom onResult JOIN Msg成功:" + j3);
                        }
                        if ((!f.this.aJZ.isHost || (f.this.aJZ.isHost && f.this.aJZ.aIN)) && f.this.blX != j3) {
                            f.this.blX = j3;
                            long j5 = JavaTypesHelper.toLong(str, -1L);
                            BIMManager.fetchMsgRequest(f.this.mContext, AccountManager.getAppid(f.this.mContext), AccountManager.getUK(f.this.mContext), 4, j5, 0L, Long.MAX_VALUE, -25, 1, f.this.bmg);
                            UbcAudioFlowStatisticManager.getInstance().doSlotStart(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_IM_RECENT_MSG_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "recentMessage", null);
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ enterRoom fetchMsgidByMsgid:   " + j5);
                            }
                        }
                    } else {
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", f.this.chatMCastId, str, 0, "", "", "");
                        if (TbConfig.IM_LOG) {
                            Log.i("imlog", "@.@ enterRoom onResult JOIN Gift成功:" + j4);
                        }
                        f.this.blU = 0;
                    }
                }
            }, z);
            JT();
            gZ(str);
            if (TbConfig.IM_LOG) {
                Log.i("imlog", "@.@ enterRoom registerMsgReceiveListener:" + z + ", mCastId: " + str);
            }
        }
    }

    private void JT() {
        MessageManager.getInstance().unRegisterListener(this.aWK);
        MessageManager.getInstance().registerListener(this.aWK);
        MessageManager.getInstance().unRegisterListener(this.blZ);
        MessageManager.getInstance().registerListener(this.blZ);
        MessageManager.getInstance().unRegisterListener(this.bma);
        MessageManager.getInstance().registerListener(this.bma);
        MessageManager.getInstance().unRegisterListener(this.bmb);
        MessageManager.getInstance().registerListener(this.bmb);
        MessageManager.getInstance().removeMessageRule(this.bmc);
        MessageManager.getInstance().addMessageRule(this.bmc);
        MessageManager.getInstance().removeMessageRule(this.bmf);
        MessageManager.getInstance().addMessageRule(this.bmf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JU() {
        this.handler.removeCallbacksAndMessages(null);
        if (this.aJZ != null && this.aJZ.mLiveSdkInfo != null && this.aJZ.mLiveSdkInfo.mCastIds != null) {
            String str = this.aJZ.mLiveSdkInfo.mCastIds.chatMCastId;
            String str2 = this.aJZ.mLiveSdkInfo.mCastIds.ensureMCastId;
            com.baidu.h.b.a.bA(this.mContext).ZU().iR(str);
            com.baidu.h.b.a.bA(this.mContext).ZU().iR(str2);
            JX();
        }
        this.blN = 0;
        this.blO = 0;
        this.blX = 0L;
        this.aJZ = null;
        this.chatMCastId = null;
        this.ensureMCastId = null;
        this.blT = 0;
        this.blU = 0;
        if (this.blV != null) {
            this.blV.clear();
            this.blV = null;
        }
        if (this.blW != null) {
            this.blW.clear();
            this.blW = null;
        }
        this.blQ.clear();
        this.blR = 0L;
        this.blR = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JV() {
        MessageManager.getInstance().unRegisterListener(this.blZ);
        MessageManager.getInstance().unRegisterListener(this.bma);
        MessageManager.getInstance().unRegisterListener(this.bmb);
        MessageManager.getInstance().unRegisterListener(this.aWK);
        MessageManager.getInstance().removeMessageRule(this.bmc);
        MessageManager.getInstance().removeMessageRule(this.bmf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(List<AlaLiveMarkData> list) {
        if (list != null && !list.isEmpty()) {
            if (this.blW == null) {
                this.blW = new ArrayList();
            }
            this.blW.clear();
            this.blW.addAll(list);
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
        final String str2 = (this.aJZ == null || this.aJZ.mLiveSdkInfo == null || this.aJZ.mLiveSdkInfo.mCastIds == null) ? null : this.aJZ.mLiveSdkInfo.mCastIds.chatMCastId;
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.h.a.b.a.e eVar = new com.baidu.h.a.b.a.e();
            eVar.msg = content;
            eVar.aTK = str2;
            if (this.aJZ != null && this.aJZ.aIz != null) {
                eVar.name = this.aJZ.aIz.userName;
                eVar.portrait = this.aJZ.aIz.portrait;
            }
            a aVar2 = new a();
            if (this.aJZ != null) {
                if (this.aJZ.isHost) {
                    alaLiveUserInfoData = this.aJZ.aId;
                } else {
                    alaLiveUserInfoData = this.aJZ.aIz;
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
                    aVar3.aFU = alaLiveUserInfoData.followCount;
                    aVar3.aFT = alaLiveUserInfoData.fansCount;
                    aVar3.aFX = alaLiveUserInfoData.isAdmin == 1;
                    aVar3.aFW = alaLiveUserInfoData.isOfficial == 1;
                    aVar3.level_id = alaLiveUserInfoData.levelId;
                    aVar3.aFZ = this.blW;
                    aVar3.sex = alaLiveUserInfoData.sex;
                    aVar3.extraUserInfo = alaLiveUserInfoData.extraUserInfo;
                    aVar3.extInfoJson = alaLiveUserInfoData.extInfoJson;
                    aVar2.e(aVar3);
                    aVar2.setContent(content);
                    aVar2.setMsgType(aVar.Ln());
                    aVar2.dC(aVar.Ld());
                    aVar2.hh(aVar.Le());
                    aVar2.a(aVar.Lf());
                    aVar2.l(aVar.Lg());
                    aVar2.setUserId(alaLiveUserInfoData.userId);
                    aVar2.gW(String.valueOf(this.aJZ.mLiveInfo.user_id));
                    aVar2.setBornTime(System.currentTimeMillis());
                    str = aVar2.Jq();
                }
            }
            eVar.ceN = str;
            com.baidu.h.a.b.a.f fVar = new com.baidu.h.a.b.a.f() { // from class: com.baidu.live.im.f.3
                @Override // com.baidu.h.a.b.a.f
                public void a(String str3, int i, List<com.baidu.h.a.b.a.c> list) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ IM消息 onSendSuccess s:" + str3 + ", i:" + i);
                    }
                    if (f.this.aJZ != null && f.this.chatMCastId != null && f.this.ensureMCastId != null) {
                        if (TextUtils.equals(str3, f.this.chatMCastId) || TextUtils.equals(str3, f.this.ensureMCastId)) {
                            ALAGroupCommitHttpResponsedMessage aLAGroupCommitHttpResponsedMessage = new ALAGroupCommitHttpResponsedMessage();
                            aLAGroupCommitHttpResponsedMessage.setStatusCode(200, null);
                            if (f.this.aJZ.mLiveInfo != null) {
                                f.this.a(aVar, i, str2, list);
                            }
                            aLAGroupCommitHttpResponsedMessage.setError(i);
                            if (i == 0) {
                                f.this.v(list);
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
            ay(content, str2);
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
            com.baidu.h.b.a.bA(this.mContext).ZU().a(str2, eVar, fVar);
            if (TbConfig.IM_LOG) {
                Log.i("imlog", "@.@ IM消息 发送 roomId:" + str2 + ", sendMessage:" + eVar.toString());
            }
        }
    }

    private void ay(String str, String str2) {
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
            alaStaticItem.addParams("live_id", this.aJZ.mLiveInfo.live_id + "");
            alaStaticItem.addParams("room_id", this.aJZ.mLiveInfo.room_id + "");
            alaStaticItem.addParams("feed_id", this.aJZ.mLiveInfo.feed_id + "");
            alaStaticItem.addParams("other_params", aVar.Lo());
            if (aVar.Ln() == 126) {
                alaStaticItem.addParams("gifts_value", String.valueOf(aVar.Lp()));
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SUC_SEND_NEWS);
            alaStaticItem2.addParams("live_id", this.aJZ.mLiveInfo.live_id + "");
            alaStaticItem2.addParams("room_id", this.aJZ.mLiveInfo.room_id + "");
            alaStaticItem2.addParams("feed_id", this.aJZ.mLiveInfo.feed_id + "");
            alaStaticItem2.addParams("other_params", aVar.Lo());
            if (aVar.Ln() == 126) {
                alaStaticItem2.addParams("gifts_value", String.valueOf(aVar.Lp()));
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem2);
        }
        if (!aVar.Lu()) {
            if (aVar.Ln() == 126) {
                if (aVar.Lt()) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("msg", aVar.getText());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "msg_send").setContentExt("barrage", null, jSONObject));
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.putOpt("is_bullechat", Integer.valueOf(aVar.Lr() ? 1 : 0));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "msg_send").setContentExt("barrage", null, jSONObject2));
                }
            } else if (aVar.Lq()) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.putOpt("msg", aVar.getText());
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "msg_send").setContentExt("fastkey", null, aVar.Ls() ? "out" : "in", jSONObject3));
            } else {
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "msg_send").setContentExt("manual", null, null));
            }
        } else {
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                jSONObject4.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, aVar.getCustomRoomId());
                if (Pattern.compile("\\[([一-龥\\w])+\\]").matcher(aVar.getContent()).find()) {
                    jSONObject4.put("is_meme", 1);
                } else {
                    jSONObject4.put("is_meme", 0);
                }
                if (com.baidu.live.ao.a.Yj().Yq() != null && com.baidu.live.ao.a.Yj().Yq().aIY != null) {
                    int roomMode = com.baidu.live.ao.a.Yj().Yq().aIY.getRoomMode();
                    if (roomMode == 0) {
                        jSONObject4.put(UbcStatConstant.KEY_CONTENT_EXT_MODE, "normal");
                    } else if (roomMode == 1) {
                        jSONObject4.put(UbcStatConstant.KEY_CONTENT_EXT_MODE, "dating");
                    } else if (roomMode == 2) {
                        jSONObject4.put(UbcStatConstant.KEY_CONTENT_EXT_MODE, "battle");
                    }
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            if (aVar.Ln() == 126) {
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "msg_send").setContentExt("barrage", null, jSONObject4));
            } else if (aVar.Lq()) {
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "msg_send").setContentExt("fastkey", null, jSONObject4));
            } else {
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "msg_send").setContentExt("manual", null, jSONObject4));
            }
        }
        if (list != null && !list.isEmpty()) {
            try {
                for (com.baidu.h.a.b.a.c cVar : list) {
                    if (cVar != null) {
                        JSONObject jSONObject5 = new JSONObject();
                        JSONObject jSONObject6 = new JSONObject();
                        jSONObject6.put("msg_id", cVar.msgId + "");
                        jSONObject5.put("code", i);
                        a(jSONObject6, jSONObject5, "1537", UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, str);
                    }
                }
            } catch (JSONException e5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(List<com.baidu.h.a.b.a.c> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.h.a.b.a.c cVar : list) {
                if (cVar != null) {
                    String str = "";
                    if (!TextUtils.isEmpty(cVar.aTK)) {
                        str = cVar.aTK;
                    } else if (cVar.ceM != null && cVar.ceM.cfa != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(cVar.ceM.cfa);
                            if (!TextUtils.isEmpty(jSONObject.optString("room_id"))) {
                                str = jSONObject.optString("room_id");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    if (TextUtils.isEmpty(str) || TextUtils.equals(str, this.chatMCastId) || TextUtils.equals(str, this.ensureMCastId)) {
                        List<a> a2 = p.a(cVar, true);
                        if (a2 != null && !a2.isEmpty()) {
                            for (a aVar : a2) {
                                aVar.setMsgId(cVar.msgId);
                            }
                            arrayList.addAll(a2);
                        }
                    }
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913102, arrayList));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913124));
            if (!arrayList.isEmpty() && this.aJZ != null) {
                if (((com.baidu.live.im.data.b) arrayList.get(0)).getMsgType() == 126) {
                    com.baidu.live.p.a.c(this.aJZ.mLiveInfo.live_id, 6);
                } else {
                    com.baidu.live.p.a.c(this.aJZ.mLiveInfo.live_id, 2);
                }
            }
        }
    }

    protected com.baidu.live.im.data.b JB() {
        a aVar = new a();
        aVar.setBornTime(System.currentTimeMillis());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ArrayList<ChatMsg> arrayList, boolean z) {
        if ((i == 0 || i == 200) && arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<ChatMsg> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.h.a.b.a.c a2 = com.baidu.h.b.a.a.a.a.a(it.next());
                if (a2 != null) {
                    arrayList2.add(a2);
                }
            }
            if (!arrayList2.isEmpty()) {
                Collections.reverse(arrayList2);
                if (TbConfig.IM_LOG) {
                    Log.d("im-debug", "handleFetchMsgResult msgList size=" + arrayList2.size());
                }
                this.bmi.e(z ? blK : blL, arrayList2);
            }
        }
    }

    private void gZ(String str) {
        com.baidu.h.b.a.bA(this.mContext).ZU().a(str, this.bmi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ha(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("im_worng_mcastid", str);
            jSONObject.put("im_wrong_msgs", 1);
            jSONObject.put("im_chat_mcast_id", this.chatMCastId);
            jSONObject.put("im_ensure_mcast_id", this.ensureMCastId);
            a(jSONObject, (JSONObject) null, "1537", UbcStatConstant.ContentType.UBC_TYPE_IM_WRONG_ID, (String) null);
        } catch (JSONException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JW() {
        if (this.aJZ != null && this.aJZ.mLiveSdkInfo != null && this.aJZ.mLiveSdkInfo.mCastIds != null) {
            this.blT = 0;
            this.blU = 0;
            this.chatMCastId = this.aJZ.mLiveSdkInfo.mCastIds.chatMCastId;
            String str = this.aJZ.mLiveSdkInfo.mCastIds.chat_msg_hls_url;
            this.ensureMCastId = this.aJZ.mLiveSdkInfo.mCastIds.ensureMCastId;
            String str2 = this.aJZ.mLiveSdkInfo.mCastIds.reliable_msg_hls_url;
            int i = JavaTypesHelper.toInt(this.aJZ.mLiveSdkInfo.mCastIds.msg_hls_pull_internal_in_second, 5) * 1000;
            a(this.chatMCastId, str, i, false);
            a(this.ensureMCastId, str2, i, this.aJZ.isHost);
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

    private void JX() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("im_chat_mcast_id", this.chatMCastId);
            jSONObject.put("im_ensure_mcast_id", this.ensureMCastId);
            jSONObject.put("im_chat_mcast_count", this.blN);
            jSONObject.put("im_ensure_mcast_count", this.blO);
            a(jSONObject, (JSONObject) null, "1529", UbcStatConstant.ContentType.UBC_TYPE_IM_LEAVE, (String) null);
        } catch (JSONException e) {
        }
    }

    private JSONObject R(JSONObject jSONObject) {
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
        if (this.aJZ != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            if (TbConfig.IM_LOG) {
                Log.i("imUbclog", "Json: " + jSONObject.toString() + "  type: " + str2 + " isHost: " + this.aJZ.isHost);
            }
            JSONObject jSONObject3 = new JSONObject();
            R(jSONObject);
            try {
                jSONObject3.put("im", jSONObject);
                if (jSONObject2 != null) {
                    jSONObject3.put(BdStatsConstant.StatsType.ERROR, jSONObject2);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(str, str2, this.aJZ.isHost ? "author_liveroom" : "liveroom", str3);
            ubcStatisticItem.setContentExt(jSONObject3);
            UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
        }
    }
}
