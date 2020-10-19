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
    private static volatile f bgn = null;
    private static int bgo = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private static int bgp = 2147483646;
    private String aHY;
    private String aHZ;
    private u aIT;
    private List<String> bgA;
    private List<AlaLiveMarkData> bgB;
    private long bgC;
    private boolean bgq;
    private int bgr;
    private int bgt;
    private Context mContext;
    private long bgu = 0;
    private LinkedList<Long> bgv = new LinkedList<>();
    private long bgw = 0;
    private long bgx = 0;
    private int bgy = 0;
    private int bgz = 0;
    private CustomMessageListener bgD = new CustomMessageListener(2913081) { // from class: com.baidu.live.im.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            u uVar;
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0) {
                f.this.bgu = 0L;
                if (com.baidu.h.b.a.aJ(f.this.mContext).TS() == null || !(customResponsedMessage.getData() instanceof u) || (uVar = (u) customResponsedMessage.getData()) == null) {
                    return;
                }
                if ((uVar.mLiveSdkInfo != null && uVar.mLiveSdkInfo.mCastIds != null) || (uVar.mLiveInfo != null && uVar.mLiveInfo.mCastIds != null)) {
                    if (uVar.mLiveInfo == null || uVar.mLiveInfo.live_status != 2) {
                        if (f.this.aIT != null && f.this.aIT.mLiveInfo != null && uVar != null && uVar.mLiveInfo != null && uVar.mLiveInfo.live_id != f.this.aIT.mLiveInfo.live_id) {
                            f.this.bgv.clear();
                            f.this.bgw = 0L;
                            f.this.bgx = 0L;
                        }
                        f.this.aIT = uVar;
                        f.this.R(f.this.aIT.aIm);
                        f.this.KC();
                        f.this.KB();
                    }
                }
            }
        }
    };
    private CustomMessageListener bgE = new CustomMessageListener(2913082) { // from class: com.baidu.live.im.f.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof u)) {
                u uVar = (u) customResponsedMessage.getData();
                if (f.this.aIT != null && f.this.aIT.mLiveInfo != null && uVar != null && uVar.mLiveInfo != null && uVar.mLiveInfo.live_id != f.this.aIT.mLiveInfo.live_id) {
                    f.this.bgv.clear();
                    f.this.bgw = 0L;
                    f.this.bgx = 0L;
                }
                f.this.aIT = uVar;
                f.this.R(f.this.aIT.aIm);
            }
        }
    };
    private CustomMessageListener bgF = new CustomMessageListener(2501033) { // from class: com.baidu.live.im.f.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof u)) {
                u uVar = (u) customResponsedMessage.getData();
                if (f.this.aIT != null && f.this.aIT.mLiveInfo != null && uVar != null && uVar.mLiveInfo != null && uVar.mLiveInfo.live_id != f.this.aIT.mLiveInfo.live_id) {
                    f.this.bgv.clear();
                    f.this.bgw = 0L;
                    f.this.bgx = 0L;
                }
                f.this.aIT = uVar;
                f.this.R(f.this.aIT.aIm);
            }
        }
    };
    private CustomMessageListener bgG = new CustomMessageListener(2913118) { // from class: com.baidu.live.im.f.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof u)) {
                f.this.R(((u) customResponsedMessage.getData()).aIm);
            }
        }
    };
    private HttpRule bgH = new HttpRule(1021013) { // from class: com.baidu.live.im.f.15
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
    private HttpRule bgI = new HttpRule(1021012) { // from class: com.baidu.live.im.f.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            return null;
        }
    };
    CustomMessageListener bgJ = new CustomMessageListener(2913084) { // from class: com.baidu.live.im.f.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.BO();
        }
    };
    CustomMessageListener aTf = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.im.f.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.KG();
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.im.f.18.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.KH();
                }
            });
        }
    };
    private HttpRule bgK = new HttpRule(1021006) { // from class: com.baidu.live.im.f.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            f.this.KG();
            if (f.this.aIT != null && f.this.aIT.mLiveSdkInfo != null && f.this.aIT.mLiveSdkInfo.mCastIds != null) {
                String str = f.this.aIT.mLiveSdkInfo.mCastIds.aHY;
                String str2 = f.this.aIT.mLiveSdkInfo.mCastIds.aHZ;
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str, -1, "", "", "");
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str2, -1, "", "", "");
            }
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.im.f.19.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.KH();
                }
            });
            return httpMessage;
        }
    };
    private IFetchMsgByIdListener bgL = new IFetchMsgByIdListener() { // from class: com.baidu.live.im.f.4
        @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
        public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList) {
            if (String.valueOf(j).equals(f.this.aHY) || String.valueOf(j).equals(f.this.aHZ)) {
                if (TbConfig.IM_LOG) {
                    Log.d("im-debug", "fetch history msg received size=" + arrayList.size());
                }
                f.this.a(i, arrayList, true);
            } else if (TbConfig.IM_LOG) {
                Log.d("im-debug", "onFetchMsgByIdResult 非当前直播间 ：l: " + j);
            }
        }
    };
    private IFetchMsgByIdListener bgM = new IFetchMsgByIdListener() { // from class: com.baidu.live.im.f.5
        @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
        public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList) {
            if (String.valueOf(j).equals(f.this.aHY) || String.valueOf(j).equals(f.this.aHZ)) {
                if (TbConfig.IM_LOG) {
                    Log.d("im-debug", "fetch msg received size=" + arrayList.size());
                }
                f.this.a(i, arrayList, false);
            } else if (TbConfig.IM_LOG) {
                Log.d("im-debug", "onFetchMsgByIdResult 非当前直播间 ：l: " + j);
            }
        }
    };
    private com.baidu.h.a.b.a.d bgN = new com.baidu.h.a.b.a.d() { // from class: com.baidu.live.im.f.6
        @Override // com.baidu.h.a.b.a.d
        public void e(int i, List<com.baidu.h.a.b.a.c> list) {
            String str;
            String str2;
            JSONObject jSONObject;
            if (f.this.aIT == null || f.this.aHY == null || f.this.aHZ == null || f.this.aIT.mLiveInfo == null) {
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收: 直播间已销毁");
                }
            } else if (i != 0 && i != f.bgo && i != f.bgp) {
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收: 非有效消息");
                }
            } else {
                ALAGroupHttpResponseMessage aLAGroupHttpResponseMessage = new ALAGroupHttpResponseMessage();
                ArrayList arrayList = new ArrayList();
                if (f.this.bgA != null) {
                    f.this.bgA.clear();
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
                        if (!TextUtils.isEmpty(cVar.aQI)) {
                            str = cVar.aQI;
                            str2 = "";
                        } else {
                            if (cVar.bGV != null && cVar.bGV.bHj != null) {
                                try {
                                    JSONObject jSONObject2 = new JSONObject(cVar.bGV.bHj);
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
                        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, f.this.aHY) && !TextUtils.equals(str, f.this.aHZ)) {
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ IM消息 接收  非当前直播间的消息，过滤 castId：" + str + "   chatMCastId：" + f.this.aHY + "   ensureMCastId: " + f.this.aHZ);
                            }
                            f.this.ht(str);
                        } else if (TextUtils.equals(cVar.type, "0") && TextUtils.isEmpty(str)) {
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ IM消息 接收: 如果是普通消息同时castId为空，过滤");
                            }
                            f.this.ht(str);
                        } else if (!TextUtils.isEmpty(str) || !TextUtils.equals(str2, SoUtils.SO_EVENT_ID_DEFAULT)) {
                            if (i != f.bgo && i != f.bgp && TextUtils.equals(str, f.this.aHY)) {
                                f.this.bgu = System.currentTimeMillis();
                                if (TbConfig.IM_LOG) {
                                    Log.d("im-debug", "receiveChatMsgTime= " + f.this.bgu);
                                }
                                f.this.bgq = false;
                                f.this.KB();
                            }
                            if (!f.this.bgv.contains(Long.valueOf(cVar.msgId))) {
                                if (i == f.bgo) {
                                    String str4 = "";
                                    String str5 = "";
                                    if (!TextUtils.isEmpty(cVar.bGW)) {
                                        try {
                                            JSONObject jSONObject3 = new JSONObject(cVar.bGW);
                                            str4 = jSONObject3.optString("msgType");
                                            if (TextUtils.isEmpty(str4)) {
                                                str4 = jSONObject3.optString("msg_type");
                                            }
                                        } catch (JSONException e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                    if (!TextUtils.isEmpty(cVar.bGG)) {
                                        try {
                                            if (TbConfig.IM_LOG) {
                                                Log.d("im-debug", "messageBean.originMsgStr=" + cVar.bGG);
                                            }
                                            JSONObject optJSONObject = new JSONObject(new JSONObject(cVar.bGG).optString("text")).optJSONObject("data");
                                            if (optJSONObject != null) {
                                                str5 = new JSONObject(optJSONObject.optJSONObject("service_info").optString("content")).optString("content_type");
                                                if (TbConfig.IM_LOG && TextUtils.equals(str5, "audio_emoticon")) {
                                                    Log.d("im-debug", "analysis msg contentType=" + str5 + " type=" + cVar.type);
                                                }
                                            }
                                        } catch (JSONException e3) {
                                            e3.printStackTrace();
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
                                            if (aVar.Lt() != null && (!TextUtils.isEmpty(aVar.Lt().name_show) || !TextUtils.isEmpty(aVar.Lt().userName))) {
                                                arrayList.add(aVar);
                                            }
                                            i2 = i3 + 1;
                                        }
                                    } else {
                                        arrayList.addAll(a2);
                                    }
                                    if (i == 0 && cVar.bGV != null && !TextUtils.isEmpty(cVar.bGV.bHj)) {
                                        if (f.this.bgA == null) {
                                            f.this.bgA = new ArrayList();
                                        }
                                        f.this.bgA.add(cVar.bGV.bHj);
                                    }
                                    if (!TextUtils.equals(cVar.type, TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY)) {
                                        if (TextUtils.equals(str2, SoUtils.SO_EVENT_ID_DEFAULT)) {
                                            f.this.bgt += a2.size();
                                            if (f.this.aIT != null && f.this.aIT.isHost) {
                                                for (a aVar2 : a2) {
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
                                                                if (aVar2.Lt() != null) {
                                                                    jSONObject4.put("sender_uk", EncryptionHelper.getEncryptionUserId(aVar2.Lt().userId));
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
                                            f.this.bgr += a2.size();
                                        }
                                    }
                                    if (f.this.bgv.size() > 200) {
                                        f.this.bgv.removeFirst();
                                    }
                                    f.this.bgv.add(Long.valueOf(cVar.msgId));
                                    if (!TextUtils.equals(str, f.this.aHY) || cVar.msgId <= f.this.bgw) {
                                        if (TextUtils.equals(str, f.this.aHY) && cVar.msgId > f.this.bgx) {
                                            f.this.bgx = cVar.msgId;
                                        }
                                    } else {
                                        f.this.bgw = cVar.msgId;
                                    }
                                }
                            } else if (TbConfig.IM_LOG) {
                                Log.d("im-debug", "remove repeat msg msgid=" + cVar.msgId + " type=" + cVar.type);
                            }
                        } else {
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ IM消息 接收: 如果是普通消息同时castId为空，过滤礼物消息");
                            }
                            f.this.ht(str);
                        }
                    }
                }
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收: 消息分发 Size: " + arrayList.size() + "  History: " + (i == f.bgo));
                }
                if (f.this.bgA != null && !f.this.bgA.isEmpty()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913246, f.this.bgA));
                }
                if (arrayList.size() > 0) {
                    aLAGroupHttpResponseMessage.bW(i == f.bgo);
                    aLAGroupHttpResponseMessage.V(arrayList);
                    aLAGroupHttpResponseMessage.setGroupId(f.this.aIT.mLiveInfo.getGroupID());
                    MessageManager.getInstance().dispatchResponsedMessage(aLAGroupHttpResponseMessage);
                    if (f.this.bgA != null && !f.this.bgA.isEmpty()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913107, f.this.bgA));
                    }
                }
            }
        }
    };
    private CustomMessageListener bgO = new CustomMessageListener(2913108) { // from class: com.baidu.live.im.f.7
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
                f.this.KI();
            }
        }
    };
    private CustomMessageListener bgP = new CustomMessageListener(2913190) { // from class: com.baidu.live.im.f.8
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
                    f.this.KI();
                } else {
                    SafeHandler.getInst().removeCallbacks(f.this.bgQ);
                    SafeHandler.getInst().postDelayed(f.this.bgQ, 1000L);
                }
            }
            if (TbadkCoreApplication.getInst().isTieba()) {
                if (LoginManager.getInstance(TbadkCoreApplication.getInst().getContext()).isIMLogined()) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ IM消息 贴吧直播间切前台监听 -- IM 没断，直接 join");
                    }
                    f.this.KI();
                    return;
                }
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 贴吧直播间切前台监听 -- IM 断");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913191, null));
            }
        }
    };
    private Runnable bgQ = new Runnable() { // from class: com.baidu.live.im.f.9
        @Override // java.lang.Runnable
        public void run() {
            f.this.KI();
        }
    };
    private Runnable bgR = new Runnable() { // from class: com.baidu.live.im.f.10
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (TbConfig.IM_LOG) {
                Log.d("im-debug", "imExceptionCheckRunnable: " + (currentTimeMillis - f.this.bgu));
            }
            if (currentTimeMillis - f.this.bgu >= 18000) {
                if (!f.this.bgq) {
                    f.this.bgq = true;
                    f.this.KE();
                }
                if (f.this.aIT != null && f.this.aIT.isHost) {
                    f.this.KC();
                    f.this.KD();
                }
            } else if (f.this.bgq) {
                f.this.bgq = false;
                f.this.KE();
            }
            f.this.KB();
        }
    };
    private CustomMessageTask.CustomRunnable bgS = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.im.f.11
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            String str;
            if (f.this.aIT != null && f.this.aIT.mLiveSdkInfo != null && f.this.aIT.mLiveSdkInfo.mCastIds != null) {
                str = f.this.aIT.mLiveSdkInfo.mCastIds.aHZ;
            } else {
                str = "0";
            }
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID, str);
        }
    };

    public static f KA() {
        if (bgn == null) {
            synchronized (f.class) {
                if (bgn == null) {
                    bgn = new f();
                }
            }
        }
        return bgn;
    }

    private f() {
    }

    public void av(Context context) {
        this.mContext = context;
        MessageManager.getInstance().unRegisterListener(this.bgD);
        MessageManager.getInstance().registerListener(this.bgD);
        MessageManager.getInstance().removeMessageRule(this.bgI);
        MessageManager.getInstance().addMessageRule(this.bgI);
        MessageManager.getInstance().unRegisterListener(this.bgJ);
        MessageManager.getInstance().registerListener(this.bgJ);
        MessageManager.getInstance().unRegisterListener(this.bgO);
        MessageManager.getInstance().registerListener(this.bgO);
        MessageManager.getInstance().unRegisterListener(this.bgP);
        MessageManager.getInstance().registerListener(this.bgP);
        new CustomMessageTask(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID, this.bgS).setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID);
    }

    public void BO() {
        SafeHandler.getInst().removeCallbacks(this.bgQ);
        SafeHandler.getInst().removeCallbacks(this.bgR);
        com.baidu.h.b.a.aJ(this.mContext).TS().KG();
        this.bgC = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KB() {
        SafeHandler.getInst().removeCallbacks(this.bgR);
        if (this.aIT != null && this.aIT.mLiveInfo != null) {
            SafeHandler.getInst().postDelayed(this.bgR, 18000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KC() {
        int i;
        String str;
        String str2;
        if (this.aIT != null) {
            if (this.aIT.mLiveSdkInfo != null && this.aIT.mLiveSdkInfo.mCastIds != null) {
                this.aHY = this.aIT.mLiveSdkInfo.mCastIds.aHY;
                String str3 = this.aIT.mLiveSdkInfo.mCastIds.aIa;
                this.aHZ = this.aIT.mLiveSdkInfo.mCastIds.aHZ;
                String str4 = this.aIT.mLiveSdkInfo.mCastIds.aIc;
                i = JavaTypesHelper.toInt(this.aIT.mLiveSdkInfo.mCastIds.aId, 5) * 1000;
                str = str4;
                str2 = str3;
            } else if (this.aIT.mLiveInfo == null || this.aIT.mLiveInfo.mCastIds == null) {
                i = 5000;
                str = "";
                str2 = "";
            } else {
                this.aHY = this.aIT.mLiveInfo.mCastIds.aHY;
                String str5 = this.aIT.mLiveInfo.mCastIds.aIa;
                this.aHZ = this.aIT.mLiveInfo.mCastIds.aHZ;
                String str6 = this.aIT.mLiveInfo.mCastIds.aIc;
                i = JavaTypesHelper.toInt(this.aIT.mLiveInfo.mCastIds.aId, 5) * 1000;
                str = str6;
                str2 = str5;
            }
            a(this.aHY, str2, i, false);
            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", this.aHY, this.aHY, 0, "", "", "");
            a(this.aHZ, str, i, this.aIT.isHost);
            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", this.aHY, this.aHZ, 0, "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KD() {
        if (TbConfig.IM_LOG) {
            Log.d("im-debug", "start fetch im chat castid=" + this.aHY + "lastmsgid=" + this.bgw);
        }
        int i = 25;
        if (this.bgw == 0) {
            i = -25;
        }
        BIMManager.fetchMsgRequest(this.mContext, AccountManager.getAppid(this.mContext), AccountManager.getUK(this.mContext), 4, JavaTypesHelper.toLong(this.aHY, -1L), this.bgw, Long.MAX_VALUE, i, 1, this.bgM);
        int i2 = 25;
        if (this.bgx == 0) {
            i2 = -25;
        }
        if (TbConfig.IM_LOG) {
            Log.d("im-debug", "start fetch im ensure castid=" + this.aHZ + " lastmsgid=" + this.bgx);
        }
        BIMManager.fetchMsgRequest(this.mContext, AccountManager.getAppid(this.mContext), AccountManager.getUK(this.mContext), 4, JavaTypesHelper.toLong(this.aHZ, -1L), this.bgx, Long.MAX_VALUE, i2, 1, this.bgM, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KE() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME), Long.class);
        if (runTask == null) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("im_state", this.bgq ? 0 : 1);
            jSONObject.put("im_chat_mcast_id", this.aHY);
            jSONObject.put("im_ensure_mcast_id", this.aHZ);
            jSONObject.put("im_live_info_time", j);
            jSONObject.put("im_last_msg_time", this.bgu);
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
            com.baidu.h.b.a.aJ(this.mContext).TS().a(str, str2, i, new com.baidu.h.a.b.b() { // from class: com.baidu.live.im.f.2
                @Override // com.baidu.h.a.b.b
                public void onResult(int i2, long j, long j2) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ enterRoom onResult i:" + i2 + ", l:" + j + ", l1:" + j2);
                    }
                    if (f.this.aIT == null || f.this.aHY == null || f.this.aHZ == null) {
                        com.baidu.h.b.a.aJ(f.this.mContext).TS().iz(String.valueOf(j));
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.aHY, String.valueOf(j), -1, "", "", "");
                        return;
                    }
                    long j3 = JavaTypesHelper.toLong(f.this.aHY, -1L);
                    long j4 = JavaTypesHelper.toLong(f.this.aHZ, -1L);
                    if (j3 != j && j4 != j) {
                        com.baidu.h.b.a.aJ(f.this.mContext).TS().iz(String.valueOf(j));
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.aHY, String.valueOf(j), -1, "", "", "");
                        if (TbConfig.IM_LOG) {
                            Log.e("imlog", "BDIM enterRoom wrong then exit end:" + j);
                            return;
                        }
                        return;
                    }
                    if (j3 == j) {
                        f.this.bgr = 0;
                    } else {
                        f.this.bgt = 0;
                    }
                    if (i2 != 0) {
                        f.this.b(j, i2, j3 == j ? f.this.bgy : f.this.bgz);
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
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_FAIL_IM_NOT_LOGIN, f.this.aHY, str, -1, "", "", "");
                    } else if (i2 == 1314 || i2 == 1306) {
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_MSG_ENTER_IM_FAIL, f.this.aHY, str, -1, String.valueOf(i2), "", "");
                    } else if (i2 != 0) {
                        if (j3 == j) {
                            if (f.this.bgy < 6) {
                                f.this.a(str, str2, i, z);
                                f.this.bgy++;
                                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_MSG_FAIL_TO_REJOIN, f.this.aHY, str, -1, "", "", "");
                                return;
                            }
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.aHY, str, -1, "", "", "");
                        } else if (f.this.bgz < 6) {
                            f.this.a(str, str2, i, z);
                            f.this.bgz++;
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_GIFT_FAIL_TO_REJOIN, f.this.aHY, str, -1, "", "", "");
                        } else {
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.aHY, str, -1, "", "", "");
                        }
                    } else if (j3 == j) {
                        f.this.bgy = 0;
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", f.this.aHY, str, 0, "", "", "");
                        if (TbConfig.IM_LOG) {
                            Log.i("imlog", "@.@ enterRoom onResult JOIN Msg成功:" + j3);
                        }
                        if ((!f.this.aIT.isHost || (f.this.aIT.isHost && f.this.aIT.aIp)) && f.this.bgC != j3) {
                            f.this.bgC = j3;
                            long j5 = JavaTypesHelper.toLong(str, -1L);
                            BIMManager.fetchMsgRequest(f.this.mContext, AccountManager.getAppid(f.this.mContext), AccountManager.getUK(f.this.mContext), 4, j5, 0L, Long.MAX_VALUE, -25, 1, f.this.bgL);
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ enterRoom fetchMsgidByMsgid:   " + j5);
                            }
                        }
                    } else {
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", f.this.aHY, str, 0, "", "", "");
                        if (TbConfig.IM_LOG) {
                            Log.i("imlog", "@.@ enterRoom onResult JOIN Gift成功:" + j4);
                        }
                        f.this.bgz = 0;
                    }
                }
            }, z);
            KF();
            hs(str);
            if (TbConfig.IM_LOG) {
                Log.i("imlog", "@.@ enterRoom registerMsgReceiveListener:" + z + ", mCastId: " + str);
            }
        }
    }

    private void KF() {
        MessageManager.getInstance().unRegisterListener(this.aTf);
        MessageManager.getInstance().registerListener(this.aTf);
        MessageManager.getInstance().unRegisterListener(this.bgE);
        MessageManager.getInstance().registerListener(this.bgE);
        MessageManager.getInstance().unRegisterListener(this.bgF);
        MessageManager.getInstance().registerListener(this.bgF);
        MessageManager.getInstance().unRegisterListener(this.bgG);
        MessageManager.getInstance().registerListener(this.bgG);
        MessageManager.getInstance().removeMessageRule(this.bgH);
        MessageManager.getInstance().addMessageRule(this.bgH);
        MessageManager.getInstance().removeMessageRule(this.bgK);
        MessageManager.getInstance().addMessageRule(this.bgK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KG() {
        SafeHandler.getInst().removeCallbacks(this.bgQ);
        SafeHandler.getInst().removeCallbacks(this.bgR);
        if (this.aIT != null && this.aIT.mLiveSdkInfo != null && this.aIT.mLiveSdkInfo.mCastIds != null) {
            String str = this.aIT.mLiveSdkInfo.mCastIds.aHY;
            String str2 = this.aIT.mLiveSdkInfo.mCastIds.aHZ;
            com.baidu.h.b.a.aJ(this.mContext).TS().iz(str);
            com.baidu.h.b.a.aJ(this.mContext).TS().iz(str2);
            KJ();
        }
        this.bgr = 0;
        this.bgt = 0;
        this.bgC = 0L;
        this.aIT = null;
        this.aHY = null;
        this.aHZ = null;
        this.bgy = 0;
        this.bgz = 0;
        if (this.bgA != null) {
            this.bgA.clear();
            this.bgA = null;
        }
        if (this.bgB != null) {
            this.bgB.clear();
            this.bgB = null;
        }
        this.bgv.clear();
        this.bgw = 0L;
        this.bgw = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KH() {
        MessageManager.getInstance().unRegisterListener(this.bgE);
        MessageManager.getInstance().unRegisterListener(this.bgF);
        MessageManager.getInstance().unRegisterListener(this.bgG);
        MessageManager.getInstance().unRegisterListener(this.aTf);
        MessageManager.getInstance().removeMessageRule(this.bgH);
        MessageManager.getInstance().removeMessageRule(this.bgK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(List<AlaLiveMarkData> list) {
        if (list != null && !list.isEmpty()) {
            if (this.bgB == null) {
                this.bgB = new ArrayList();
            }
            this.bgB.clear();
            this.bgB.addAll(list);
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
        final String str2 = (this.aIT == null || this.aIT.mLiveSdkInfo == null || this.aIT.mLiveSdkInfo.mCastIds == null) ? null : this.aIT.mLiveSdkInfo.mCastIds.aHY;
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.h.a.b.a.e eVar = new com.baidu.h.a.b.a.e();
            eVar.msg = content;
            eVar.aQI = str2;
            if (this.aIT != null && this.aIT.aIf != null) {
                eVar.name = this.aIT.aIf.userName;
                eVar.portrait = this.aIT.aIf.portrait;
            }
            a aVar2 = new a();
            if (this.aIT != null) {
                if (this.aIT.isHost) {
                    alaLiveUserInfoData = this.aIT.aHD;
                } else {
                    alaLiveUserInfoData = this.aIT.aIf;
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
                    aVar3.aGD = alaLiveUserInfoData.followCount;
                    aVar3.aGC = alaLiveUserInfoData.fansCount;
                    aVar3.aGG = alaLiveUserInfoData.isAdmin == 1;
                    aVar3.aGF = alaLiveUserInfoData.isOfficial == 1;
                    aVar3.level_id = alaLiveUserInfoData.levelId;
                    aVar3.aGI = this.bgB;
                    aVar3.sex = alaLiveUserInfoData.sex;
                    aVar3.extraUserInfo = alaLiveUserInfoData.extraUserInfo;
                    aVar2.e(aVar3);
                    aVar2.setContent(content);
                    aVar2.setMsgType(aVar.LH());
                    aVar2.eJ(aVar.Lx());
                    aVar2.hw(aVar.Ly());
                    aVar2.a(aVar.Lz());
                    aVar2.k(aVar.LA());
                    aVar2.setUserId(alaLiveUserInfoData.userId);
                    aVar2.hp(String.valueOf(this.aIT.mLiveInfo.user_id));
                    aVar2.setBornTime(System.currentTimeMillis());
                    str = aVar2.Kf();
                }
            }
            eVar.bGW = str;
            com.baidu.h.a.b.a.f fVar = new com.baidu.h.a.b.a.f() { // from class: com.baidu.live.im.f.3
                @Override // com.baidu.h.a.b.a.f
                public void a(String str3, int i, List<com.baidu.h.a.b.a.c> list) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ IM消息 onSendSuccess s:" + str3 + ", i:" + i);
                    }
                    if (f.this.aIT != null && f.this.aHY != null && f.this.aHZ != null) {
                        if (TextUtils.equals(str3, f.this.aHY) || TextUtils.equals(str3, f.this.aHZ)) {
                            ALAGroupCommitHttpResponsedMessage aLAGroupCommitHttpResponsedMessage = new ALAGroupCommitHttpResponsedMessage();
                            aLAGroupCommitHttpResponsedMessage.setStatusCode(200, null);
                            if (f.this.aIT.mLiveInfo != null) {
                                f.this.a(aVar, i, str2, list);
                            }
                            aLAGroupCommitHttpResponsedMessage.setError(i);
                            if (i == 0) {
                                f.this.u(list);
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
            ax(content, str2);
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
            com.baidu.h.b.a.aJ(this.mContext).TS().a(str2, eVar, fVar);
            if (TbConfig.IM_LOG) {
                Log.i("imlog", "@.@ IM消息 发送 roomId:" + str2 + ", sendMessage:" + eVar.toString());
            }
        }
    }

    private void ax(String str, String str2) {
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
            alaStaticItem.addParams("live_id", this.aIT.mLiveInfo.live_id + "");
            alaStaticItem.addParams("room_id", this.aIT.mLiveInfo.room_id + "");
            alaStaticItem.addParams("feed_id", this.aIT.mLiveInfo.feed_id + "");
            alaStaticItem.addParams("other_params", aVar.LI());
            if (aVar.LH() == 126) {
                alaStaticItem.addParams("gifts_value", String.valueOf(aVar.LJ()));
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SUC_SEND_NEWS);
            alaStaticItem2.addParams("live_id", this.aIT.mLiveInfo.live_id + "");
            alaStaticItem2.addParams("room_id", this.aIT.mLiveInfo.room_id + "");
            alaStaticItem2.addParams("feed_id", this.aIT.mLiveInfo.feed_id + "");
            alaStaticItem2.addParams("other_params", aVar.LI());
            if (aVar.LH() == 126) {
                alaStaticItem2.addParams("gifts_value", String.valueOf(aVar.LJ()));
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem2);
        }
        if (!aVar.LL()) {
            if (aVar.LH() == 126) {
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "msg_send").setContentExt("barrage", null, null));
            } else if (aVar.LK()) {
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "msg_send").setContentExt("fastkey", null, null));
            } else {
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "msg_send").setContentExt("manual", null, null));
            }
        } else {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, aVar.LM());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (aVar.LH() == 126) {
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "msg_send").setContentExt("barrage", null, jSONObject));
            } else if (aVar.LK()) {
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
    public void u(List<com.baidu.h.a.b.a.c> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.h.a.b.a.c cVar : list) {
                if (cVar != null) {
                    String str = "";
                    if (!TextUtils.isEmpty(cVar.aQI)) {
                        str = cVar.aQI;
                    } else if (cVar.bGV != null && cVar.bGV.bHj != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(cVar.bGV.bHj);
                            if (!TextUtils.isEmpty(jSONObject.optString("room_id"))) {
                                str = jSONObject.optString("room_id");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    if (TextUtils.isEmpty(str) || TextUtils.equals(str, this.aHY) || TextUtils.equals(str, this.aHZ)) {
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
            if (!arrayList.isEmpty() && this.aIT != null) {
                if (((com.baidu.live.im.data.a) arrayList.get(0)).getMsgType() == 126) {
                    com.baidu.live.m.a.b(this.aIT.mLiveInfo.live_id, 6);
                } else {
                    com.baidu.live.m.a.b(this.aIT.mLiveInfo.live_id, 2);
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
                this.bgN.e(z ? bgo : bgp, arrayList2);
            }
        }
    }

    private void hs(String str) {
        com.baidu.h.b.a.aJ(this.mContext).TS().a(str, this.bgN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ht(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("im_worng_mcastid", str);
            jSONObject.put("im_wrong_msgs", 1);
            jSONObject.put("im_chat_mcast_id", this.aHY);
            jSONObject.put("im_ensure_mcast_id", this.aHZ);
            a(jSONObject, (JSONObject) null, "1537", UbcStatConstant.ContentType.UBC_TYPE_IM_WRONG_ID, (String) null);
        } catch (JSONException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KI() {
        if (this.aIT != null && this.aIT.mLiveSdkInfo != null && this.aIT.mLiveSdkInfo.mCastIds != null) {
            this.bgy = 0;
            this.bgz = 0;
            this.aHY = this.aIT.mLiveSdkInfo.mCastIds.aHY;
            String str = this.aIT.mLiveSdkInfo.mCastIds.aIa;
            this.aHZ = this.aIT.mLiveSdkInfo.mCastIds.aHZ;
            String str2 = this.aIT.mLiveSdkInfo.mCastIds.aIc;
            int i = JavaTypesHelper.toInt(this.aIT.mLiveSdkInfo.mCastIds.aId, 5) * 1000;
            a(this.aHY, str, i, false);
            a(this.aHZ, str2, i, this.aIT.isHost);
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

    private void KJ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("im_chat_mcast_id", this.aHY);
            jSONObject.put("im_ensure_mcast_id", this.aHZ);
            jSONObject.put("im_chat_mcast_count", this.bgr);
            jSONObject.put("im_ensure_mcast_count", this.bgt);
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
        if (this.aIT != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            if (TbConfig.IM_LOG) {
                Log.i("imUbclog", "Json: " + jSONObject.toString() + "  type: " + str2 + " isHost: " + this.aIT.isHost);
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
            UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(str, str2, this.aIT.isHost ? UbcStatConstant.Page.AUTHOR_LIVE_ROOM : "liveroom", str3);
            ubcStatisticItem.setContentExt(jSONObject3);
            UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
        }
    }
}
