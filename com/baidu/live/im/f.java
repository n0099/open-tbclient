package com.baidu.live.im;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConnection;
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
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.x;
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
/* loaded from: classes10.dex */
public class f {
    private static volatile f bir = null;
    private static int bis = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private static int bit = 2147483646;
    private x aHu;
    private List<String> biD;
    private List<AlaLiveMarkData> biE;
    private long biF;
    private boolean biu;
    private int biv;
    private int biw;
    private String chatMCastId;
    private String ensureMCastId;
    private Context mContext;
    private long bix = 0;
    private LinkedList<Long> biy = new LinkedList<>();
    private long biz = 0;
    private long biA = 0;
    private Handler handler = new Handler();
    private int biB = 0;
    private int biC = 0;
    private CustomMessageListener biG = new CustomMessageListener(2913081) { // from class: com.baidu.live.im.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            x xVar;
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0) {
                f.this.bix = 0L;
                if (com.baidu.h.b.a.bx(f.this.mContext).Ya() == null || !(customResponsedMessage.getData() instanceof x) || (xVar = (x) customResponsedMessage.getData()) == null) {
                    return;
                }
                if ((xVar.mLiveSdkInfo != null && xVar.mLiveSdkInfo.mCastIds != null) || (xVar.mLiveInfo != null && xVar.mLiveInfo.mCastIds != null)) {
                    if (xVar.mLiveInfo == null || xVar.mLiveInfo.live_status != 2) {
                        if (f.this.aHu != null && f.this.aHu.mLiveInfo != null && xVar != null && xVar.mLiveInfo != null && xVar.mLiveInfo.live_id != f.this.aHu.mLiveInfo.live_id) {
                            f.this.biy.clear();
                            f.this.biz = 0L;
                            f.this.biA = 0L;
                        }
                        f.this.aHu = xVar;
                        f.this.S(f.this.aHu.aGo);
                        f.this.Is();
                        f.this.Ir();
                    }
                }
            }
        }
    };
    private CustomMessageListener biH = new CustomMessageListener(2913082) { // from class: com.baidu.live.im.f.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof x)) {
                x xVar = (x) customResponsedMessage.getData();
                if (f.this.aHu != null && f.this.aHu.mLiveInfo != null && xVar != null && xVar.mLiveInfo != null && xVar.mLiveInfo.live_id != f.this.aHu.mLiveInfo.live_id) {
                    f.this.biy.clear();
                    f.this.biz = 0L;
                    f.this.biA = 0L;
                }
                f.this.aHu = xVar;
                f.this.S(f.this.aHu.aGo);
            }
        }
    };
    private CustomMessageListener biI = new CustomMessageListener(2501033) { // from class: com.baidu.live.im.f.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof x)) {
                x xVar = (x) customResponsedMessage.getData();
                if (f.this.aHu != null && f.this.aHu.mLiveInfo != null && xVar != null && xVar.mLiveInfo != null && xVar.mLiveInfo.live_id != f.this.aHu.mLiveInfo.live_id) {
                    f.this.biy.clear();
                    f.this.biz = 0L;
                    f.this.biA = 0L;
                }
                f.this.aHu = xVar;
                f.this.S(f.this.aHu.aGo);
            }
        }
    };
    private CustomMessageListener biJ = new CustomMessageListener(2913118) { // from class: com.baidu.live.im.f.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof x)) {
                f.this.S(((x) customResponsedMessage.getData()).aGo);
            }
        }
    };
    private HttpRule biK = new HttpRule(1021013) { // from class: com.baidu.live.im.f.15
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
    private HttpRule biL = new HttpRule(1021012) { // from class: com.baidu.live.im.f.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            return null;
        }
    };
    CustomMessageListener biM = new CustomMessageListener(2913084) { // from class: com.baidu.live.im.f.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.yA();
        }
    };
    CustomMessageListener aTF = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.im.f.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.Iw();
            f.this.handler.post(new Runnable() { // from class: com.baidu.live.im.f.18.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.Ix();
                }
            });
        }
    };
    private HttpRule biN = new HttpRule(1021006) { // from class: com.baidu.live.im.f.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            f.this.Iw();
            if (f.this.aHu != null && f.this.aHu.mLiveSdkInfo != null && f.this.aHu.mLiveSdkInfo.mCastIds != null) {
                String str = f.this.aHu.mLiveSdkInfo.mCastIds.chatMCastId;
                String str2 = f.this.aHu.mLiveSdkInfo.mCastIds.ensureMCastId;
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str, -1, "", "", "");
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str2, -1, "", "", "");
            }
            f.this.handler.post(new Runnable() { // from class: com.baidu.live.im.f.19.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.Ix();
                }
            });
            return httpMessage;
        }
    };
    private IFetchMsgByIdListener biO = new IFetchMsgByIdListener() { // from class: com.baidu.live.im.f.4
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
    private IFetchMsgByIdListener biP = new IFetchMsgByIdListener() { // from class: com.baidu.live.im.f.5
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
    private com.baidu.h.a.b.a.d biQ = new com.baidu.h.a.b.a.d() { // from class: com.baidu.live.im.f.6
        @Override // com.baidu.h.a.b.a.d
        public void e(int i, List<com.baidu.h.a.b.a.c> list) {
            String str;
            JSONObject jSONObject;
            String optString;
            if (f.this.aHu == null || f.this.chatMCastId == null || f.this.ensureMCastId == null || f.this.aHu.mLiveInfo == null) {
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收: 直播间已销毁");
                }
            } else if (i != 0 && i != f.bis && i != f.bit) {
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收: 非有效消息");
                }
            } else {
                ALAGroupHttpResponseMessage aLAGroupHttpResponseMessage = new ALAGroupHttpResponseMessage();
                aLAGroupHttpResponseMessage.setStatusCode(200, "");
                ArrayList arrayList = new ArrayList();
                if (f.this.biD != null) {
                    f.this.biD.clear();
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
                        if (TbConfig.IM_LOG && cVar.caA != null) {
                            try {
                                String str2 = cVar.caA.caO;
                                if (str2 != null) {
                                    Log.i("imlog", "@.@ IM消息 接收: contentType=" + new JSONObject(optString).optString("content_type") + ";;;content=" + new JSONObject(str2).optString("content"));
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        String str3 = "";
                        if (!TextUtils.isEmpty(cVar.aQH)) {
                            str3 = cVar.aQH;
                            str = "";
                        } else {
                            if (cVar.caA != null && cVar.caA.caO != null) {
                                try {
                                    JSONObject jSONObject2 = new JSONObject(cVar.caA.caO);
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
                            f.this.gC(str3);
                        } else if (TextUtils.equals(cVar.type, "0") && TextUtils.isEmpty(str3)) {
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ IM消息 接收: 如果是普通消息同时castId为空，过滤");
                            }
                            f.this.gC(str3);
                        } else if (!TextUtils.isEmpty(str3) || !TextUtils.equals(str, SoUtils.SO_EVENT_ID_DEFAULT)) {
                            if (i != f.bis && i != f.bit && TextUtils.equals(str3, f.this.chatMCastId)) {
                                f.this.bix = System.currentTimeMillis();
                                if (TbConfig.IM_LOG) {
                                    Log.d("im-debug", "receiveChatMsgTime= " + f.this.bix);
                                }
                                f.this.biu = false;
                                f.this.Ir();
                            }
                            if (!f.this.biy.contains(Long.valueOf(cVar.msgId))) {
                                if (i == f.bis) {
                                    String str4 = "";
                                    String str5 = "";
                                    if (!TextUtils.isEmpty(cVar.caB)) {
                                        try {
                                            JSONObject jSONObject3 = new JSONObject(cVar.caB);
                                            str4 = jSONObject3.optString("msgType");
                                            if (TextUtils.isEmpty(str4)) {
                                                str4 = jSONObject3.optString("msg_type");
                                            }
                                        } catch (JSONException e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                    if (cVar.caA != null) {
                                        try {
                                            str5 = new JSONObject(new JSONObject(cVar.caA.caO).optString("content")).optString("content_type");
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
                                            if (aVar.JB() != null && (!TextUtils.isEmpty(aVar.JB().name_show) || !TextUtils.isEmpty(aVar.JB().userName))) {
                                                arrayList.add(aVar);
                                            }
                                            i2 = i3 + 1;
                                        }
                                    } else {
                                        arrayList.addAll(a2);
                                    }
                                    if (i == 0 && cVar.caA != null && !TextUtils.isEmpty(cVar.caA.caO)) {
                                        if (f.this.biD == null) {
                                            f.this.biD = new ArrayList();
                                        }
                                        f.this.biD.add(cVar.caA.caO);
                                    }
                                    if (!TextUtils.equals(cVar.type, "101")) {
                                        if (TextUtils.equals(str, SoUtils.SO_EVENT_ID_DEFAULT)) {
                                            f.this.biw += a2.size();
                                            if (f.this.aHu != null && f.this.aHu.isHost) {
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
                                                                jSONObject4.put(LogConfig.LOG_GIFT_ID, jSONObject.optString(LogConfig.LOG_GIFT_ID));
                                                                jSONObject4.put("gift_count", jSONObject.optLong("gift_count"));
                                                                if (aVar2.JB() != null) {
                                                                    jSONObject4.put("sender_uk", EncryptionHelper.getEncryptionUserId(aVar2.JB().userId));
                                                                }
                                                                jSONObject4.put("rec_time", System.currentTimeMillis());
                                                            } catch (JSONException e6) {
                                                                BdLog.e(e6);
                                                            }
                                                            UbcStatisticManager.getInstance().debugException(new UbcDebugItem("author_liveroom", UbcStatConstant.DebugContentValue.GIFT, jSONObject4), "gift_rec");
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            f.this.biv += a2.size();
                                        }
                                    }
                                    if (f.this.biy.size() > 200) {
                                        f.this.biy.removeFirst();
                                    }
                                    f.this.biy.add(Long.valueOf(cVar.msgId));
                                    if (!TextUtils.equals(str3, f.this.chatMCastId) || cVar.msgId <= f.this.biz) {
                                        if (TextUtils.equals(str3, f.this.chatMCastId) && cVar.msgId > f.this.biA) {
                                            f.this.biA = cVar.msgId;
                                        }
                                    } else {
                                        f.this.biz = cVar.msgId;
                                    }
                                }
                            } else if (TbConfig.IM_LOG) {
                                Log.d("im-debug", "remove repeat msg msgid=" + cVar.msgId + " type=" + cVar.type);
                            }
                        } else {
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ IM消息 接收: 如果是普通消息同时castId为空，过滤礼物消息");
                            }
                            f.this.gC(str3);
                        }
                    }
                }
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收: 消息分发 Size: " + arrayList.size() + "  History: " + (i == f.bis));
                }
                if (f.this.biD != null && !f.this.biD.isEmpty()) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.addAll(f.this.biD);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913251, arrayList2));
                }
                if (arrayList.size() > 0) {
                    aLAGroupHttpResponseMessage.ch(i == f.bis);
                    aLAGroupHttpResponseMessage.X(arrayList);
                    aLAGroupHttpResponseMessage.setGroupId(f.this.aHu.mLiveInfo.getGroupID());
                    MessageManager.getInstance().dispatchResponsedMessage(aLAGroupHttpResponseMessage);
                    if (f.this.biD != null && !f.this.biD.isEmpty()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913107, f.this.biD));
                    }
                }
            }
        }
    };
    private CustomMessageListener biR = new CustomMessageListener(2913108) { // from class: com.baidu.live.im.f.7
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
                f.this.Iy();
            }
        }
    };
    private CustomMessageListener biS = new CustomMessageListener(2913190) { // from class: com.baidu.live.im.f.8
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
                    f.this.Iy();
                } else {
                    f.this.handler.removeCallbacks(f.this.biT);
                    f.this.handler.postDelayed(f.this.biT, 1000L);
                }
            }
            if (TbadkCoreApplication.getInst().isTieba()) {
                if (LoginManager.getInstance(TbadkCoreApplication.getInst().getContext()).isIMLogined()) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ IM消息 贴吧直播间切前台监听 -- IM 没断，直接 join");
                    }
                    f.this.Iy();
                    return;
                }
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 贴吧直播间切前台监听 -- IM 断");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913191, null));
            }
        }
    };
    private Runnable biT = new Runnable() { // from class: com.baidu.live.im.f.9
        @Override // java.lang.Runnable
        public void run() {
            f.this.Iy();
        }
    };
    private Runnable biU = new Runnable() { // from class: com.baidu.live.im.f.10
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (TbConfig.IM_LOG) {
                Log.d("im-debug", "imExceptionCheckRunnable: " + (currentTimeMillis - f.this.bix));
            }
            if (currentTimeMillis - f.this.bix >= 18000) {
                if (!f.this.biu) {
                    f.this.biu = true;
                    f.this.Iu();
                }
                if (f.this.aHu != null && f.this.aHu.isHost) {
                    f.this.Is();
                    f.this.It();
                }
            } else if (f.this.biu) {
                f.this.biu = false;
                f.this.Iu();
            }
            f.this.Ir();
        }
    };
    private CustomMessageTask.CustomRunnable biV = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.im.f.11
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            String str;
            if (f.this.aHu != null && f.this.aHu.mLiveSdkInfo != null && f.this.aHu.mLiveSdkInfo.mCastIds != null) {
                str = f.this.aHu.mLiveSdkInfo.mCastIds.ensureMCastId;
            } else {
                str = "0";
            }
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID, str);
        }
    };

    public static f Iq() {
        if (bir == null) {
            synchronized (f.class) {
                if (bir == null) {
                    bir = new f();
                }
            }
        }
        return bir;
    }

    private f() {
    }

    public void aW(Context context) {
        this.mContext = context;
        MessageManager.getInstance().unRegisterListener(this.biG);
        MessageManager.getInstance().registerListener(this.biG);
        MessageManager.getInstance().removeMessageRule(this.biL);
        MessageManager.getInstance().addMessageRule(this.biL);
        MessageManager.getInstance().unRegisterListener(this.biM);
        MessageManager.getInstance().registerListener(this.biM);
        MessageManager.getInstance().unRegisterListener(this.biR);
        MessageManager.getInstance().registerListener(this.biR);
        MessageManager.getInstance().unRegisterListener(this.biS);
        MessageManager.getInstance().registerListener(this.biS);
        new CustomMessageTask(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID, this.biV).setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID);
    }

    public void yA() {
        this.handler.removeCallbacksAndMessages(null);
        com.baidu.h.b.a.bx(this.mContext).Ya().Iw();
        this.biF = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ir() {
        this.handler.removeCallbacks(this.biU);
        if (this.aHu != null && this.aHu.mLiveInfo != null) {
            this.handler.postDelayed(this.biU, 18000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Is() {
        int i;
        String str;
        if (this.aHu != null) {
            String str2 = "";
            if (this.aHu.mLiveSdkInfo != null && this.aHu.mLiveSdkInfo.mCastIds != null) {
                this.chatMCastId = this.aHu.mLiveSdkInfo.mCastIds.chatMCastId;
                str2 = this.aHu.mLiveSdkInfo.mCastIds.chat_msg_hls_url;
                this.ensureMCastId = this.aHu.mLiveSdkInfo.mCastIds.ensureMCastId;
                String str3 = this.aHu.mLiveSdkInfo.mCastIds.reliable_msg_hls_url;
                i = JavaTypesHelper.toInt(this.aHu.mLiveSdkInfo.mCastIds.msg_hls_pull_internal_in_second, 5) * 1000;
                str = str3;
            } else if (this.aHu.mLiveInfo == null || this.aHu.mLiveInfo.mCastIds == null) {
                i = 5000;
                str = "";
            } else {
                this.chatMCastId = this.aHu.mLiveInfo.mCastIds.chatMCastId;
                str2 = this.aHu.mLiveInfo.mCastIds.chat_msg_hls_url;
                this.ensureMCastId = this.aHu.mLiveInfo.mCastIds.ensureMCastId;
                String str4 = this.aHu.mLiveInfo.mCastIds.reliable_msg_hls_url;
                i = JavaTypesHelper.toInt(this.aHu.mLiveInfo.mCastIds.msg_hls_pull_internal_in_second, 5) * 1000;
                str = str4;
            }
            a(this.chatMCastId, str2, i, false);
            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", this.chatMCastId, this.chatMCastId, 0, "", "", "");
            a(this.ensureMCastId, str, i, this.aHu.isHost);
            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", this.chatMCastId, this.ensureMCastId, 0, "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void It() {
        if (TbConfig.IM_LOG) {
            Log.d("im-debug", "start fetch im chat castid=" + this.chatMCastId + "lastmsgid=" + this.biz);
        }
        int i = 25;
        if (this.biz == 0) {
            i = -25;
        }
        BIMManager.fetchMsgRequest(this.mContext, AccountManager.getAppid(this.mContext), AccountManager.getUK(this.mContext), 4, JavaTypesHelper.toLong(this.chatMCastId, -1L), this.biz, Long.MAX_VALUE, i, 1, this.biP);
        int i2 = 25;
        if (this.biA == 0) {
            i2 = -25;
        }
        if (TbConfig.IM_LOG) {
            Log.d("im-debug", "start fetch im ensure castid=" + this.ensureMCastId + " lastmsgid=" + this.biA);
        }
        BIMManager.fetchMsgRequest(this.mContext, AccountManager.getAppid(this.mContext), AccountManager.getUK(this.mContext), 4, JavaTypesHelper.toLong(this.ensureMCastId, -1L), this.biA, Long.MAX_VALUE, i2, 1, this.biP, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iu() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME), Long.class);
        if (runTask == null) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("im_state", this.biu ? 0 : 1);
            jSONObject.put("im_chat_mcast_id", this.chatMCastId);
            jSONObject.put("im_ensure_mcast_id", this.ensureMCastId);
            jSONObject.put("im_live_info_time", j);
            jSONObject.put("im_last_msg_time", this.bix);
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
            com.baidu.h.b.a.bx(this.mContext).Ya().a(str, str2, i, new com.baidu.h.a.b.b() { // from class: com.baidu.live.im.f.2
                @Override // com.baidu.h.a.b.b
                public void onResult(int i2, long j, long j2) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ enterRoom onResult i:" + i2 + ", l:" + j + ", l1:" + j2);
                    }
                    if (f.this.aHu == null || f.this.chatMCastId == null || f.this.ensureMCastId == null) {
                        com.baidu.h.b.a.bx(f.this.mContext).Ya().il(String.valueOf(j));
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.chatMCastId, String.valueOf(j), -1, "", "", "");
                        return;
                    }
                    UbcAudioFlowStatisticManager.getInstance().doSlotEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_IM_CONNECT_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""), "IMConnect");
                    UbcAudioFlowStatisticManager.getInstance().endFlow(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_AUDIO_IM_CONNECT_FLOW, "auidolivechatflow", UbcStatConstant.Page.AUDIO_LIVE_ROOM, ""));
                    long j3 = JavaTypesHelper.toLong(f.this.chatMCastId, -1L);
                    long j4 = JavaTypesHelper.toLong(f.this.ensureMCastId, -1L);
                    if (j3 != j && j4 != j) {
                        com.baidu.h.b.a.bx(f.this.mContext).Ya().il(String.valueOf(j));
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.chatMCastId, String.valueOf(j), -1, "", "", "");
                        if (TbConfig.IM_LOG) {
                            Log.e("imlog", "BDIM enterRoom wrong then exit end:" + j);
                            return;
                        }
                        return;
                    }
                    if (j3 == j) {
                        f.this.biv = 0;
                    } else {
                        f.this.biw = 0;
                    }
                    if (i2 != 0) {
                        f.this.b(j, i2, j3 == j ? f.this.biB : f.this.biC);
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
                            if (f.this.biB < 6) {
                                f.this.handler.postDelayed(new Runnable() { // from class: com.baidu.live.im.f.2.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        f.this.a(str, str2, i, z);
                                    }
                                }, IMConnection.RETRY_DELAY_TIMES);
                                f.this.biB++;
                                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_MSG_FAIL_TO_REJOIN, f.this.chatMCastId, str, -1, "", "", "");
                                return;
                            }
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.chatMCastId, str, -1, "", "", "");
                        } else if (f.this.biC < 6) {
                            f.this.handler.postDelayed(new Runnable() { // from class: com.baidu.live.im.f.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    f.this.a(str, str2, i, z);
                                }
                            }, IMConnection.RETRY_DELAY_TIMES);
                            f.this.biC++;
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_GIFT_FAIL_TO_REJOIN, f.this.chatMCastId, str, -1, "", "", "");
                        } else {
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.chatMCastId, str, -1, "", "", "");
                        }
                    } else if (j3 == j) {
                        f.this.biB = 0;
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", f.this.chatMCastId, str, 0, "", "", "");
                        if (TbConfig.IM_LOG) {
                            Log.i("imlog", "@.@ enterRoom onResult JOIN Msg成功:" + j3);
                        }
                        if ((!f.this.aHu.isHost || (f.this.aHu.isHost && f.this.aHu.aGr)) && f.this.biF != j3) {
                            f.this.biF = j3;
                            long j5 = JavaTypesHelper.toLong(str, -1L);
                            BIMManager.fetchMsgRequest(f.this.mContext, AccountManager.getAppid(f.this.mContext), AccountManager.getUK(f.this.mContext), 4, j5, 0L, Long.MAX_VALUE, -25, 1, f.this.biO);
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
                        f.this.biC = 0;
                    }
                }
            }, z);
            Iv();
            gB(str);
            if (TbConfig.IM_LOG) {
                Log.i("imlog", "@.@ enterRoom registerMsgReceiveListener:" + z + ", mCastId: " + str);
            }
        }
    }

    private void Iv() {
        MessageManager.getInstance().unRegisterListener(this.aTF);
        MessageManager.getInstance().registerListener(this.aTF);
        MessageManager.getInstance().unRegisterListener(this.biH);
        MessageManager.getInstance().registerListener(this.biH);
        MessageManager.getInstance().unRegisterListener(this.biI);
        MessageManager.getInstance().registerListener(this.biI);
        MessageManager.getInstance().unRegisterListener(this.biJ);
        MessageManager.getInstance().registerListener(this.biJ);
        MessageManager.getInstance().removeMessageRule(this.biK);
        MessageManager.getInstance().addMessageRule(this.biK);
        MessageManager.getInstance().removeMessageRule(this.biN);
        MessageManager.getInstance().addMessageRule(this.biN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iw() {
        this.handler.removeCallbacksAndMessages(null);
        if (this.aHu != null && this.aHu.mLiveSdkInfo != null && this.aHu.mLiveSdkInfo.mCastIds != null) {
            String str = this.aHu.mLiveSdkInfo.mCastIds.chatMCastId;
            String str2 = this.aHu.mLiveSdkInfo.mCastIds.ensureMCastId;
            com.baidu.h.b.a.bx(this.mContext).Ya().il(str);
            com.baidu.h.b.a.bx(this.mContext).Ya().il(str2);
            Iz();
        }
        this.biv = 0;
        this.biw = 0;
        this.biF = 0L;
        this.aHu = null;
        this.chatMCastId = null;
        this.ensureMCastId = null;
        this.biB = 0;
        this.biC = 0;
        if (this.biD != null) {
            this.biD.clear();
            this.biD = null;
        }
        if (this.biE != null) {
            this.biE.clear();
            this.biE = null;
        }
        this.biy.clear();
        this.biz = 0L;
        this.biz = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ix() {
        MessageManager.getInstance().unRegisterListener(this.biH);
        MessageManager.getInstance().unRegisterListener(this.biI);
        MessageManager.getInstance().unRegisterListener(this.biJ);
        MessageManager.getInstance().unRegisterListener(this.aTF);
        MessageManager.getInstance().removeMessageRule(this.biK);
        MessageManager.getInstance().removeMessageRule(this.biN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(List<AlaLiveMarkData> list) {
        if (list != null && !list.isEmpty()) {
            if (this.biE == null) {
                this.biE = new ArrayList();
            }
            this.biE.clear();
            this.biE.addAll(list);
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
        final String str2 = (this.aHu == null || this.aHu.mLiveSdkInfo == null || this.aHu.mLiveSdkInfo.mCastIds == null) ? null : this.aHu.mLiveSdkInfo.mCastIds.chatMCastId;
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.h.a.b.a.e eVar = new com.baidu.h.a.b.a.e();
            eVar.msg = content;
            eVar.aQH = str2;
            if (this.aHu != null && this.aHu.aGd != null) {
                eVar.name = this.aHu.aGd.userName;
                eVar.portrait = this.aHu.aGd.portrait;
            }
            a aVar2 = new a();
            if (this.aHu != null) {
                if (this.aHu.isHost) {
                    alaLiveUserInfoData = this.aHu.aFH;
                } else {
                    alaLiveUserInfoData = this.aHu.aGd;
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
                    aVar3.aEh = alaLiveUserInfoData.followCount;
                    aVar3.aEg = alaLiveUserInfoData.fansCount;
                    aVar3.aEk = alaLiveUserInfoData.isAdmin == 1;
                    aVar3.aEj = alaLiveUserInfoData.isOfficial == 1;
                    aVar3.level_id = alaLiveUserInfoData.levelId;
                    aVar3.aEm = this.biE;
                    aVar3.sex = alaLiveUserInfoData.sex;
                    aVar3.extraUserInfo = alaLiveUserInfoData.extraUserInfo;
                    aVar3.extInfoJson = alaLiveUserInfoData.extInfoJson;
                    aVar2.e(aVar3);
                    aVar2.setContent(content);
                    aVar2.setMsgType(aVar.JP());
                    aVar2.dw(aVar.JF());
                    aVar2.gI(aVar.JG());
                    aVar2.a(aVar.JH());
                    aVar2.l(aVar.JI());
                    aVar2.setUserId(alaLiveUserInfoData.userId);
                    aVar2.gy(String.valueOf(this.aHu.mLiveInfo.user_id));
                    aVar2.setBornTime(System.currentTimeMillis());
                    str = aVar2.HU();
                }
            }
            eVar.caB = str;
            com.baidu.h.a.b.a.f fVar = new com.baidu.h.a.b.a.f() { // from class: com.baidu.live.im.f.3
                @Override // com.baidu.h.a.b.a.f
                public void a(String str3, int i, List<com.baidu.h.a.b.a.c> list) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ IM消息 onSendSuccess s:" + str3 + ", i:" + i);
                    }
                    if (f.this.aHu != null && f.this.chatMCastId != null && f.this.ensureMCastId != null) {
                        if (TextUtils.equals(str3, f.this.chatMCastId) || TextUtils.equals(str3, f.this.ensureMCastId)) {
                            ALAGroupCommitHttpResponsedMessage aLAGroupCommitHttpResponsedMessage = new ALAGroupCommitHttpResponsedMessage();
                            aLAGroupCommitHttpResponsedMessage.setStatusCode(200, null);
                            if (f.this.aHu.mLiveInfo != null) {
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
            com.baidu.h.b.a.bx(this.mContext).Ya().a(str2, eVar, fVar);
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
            alaStaticItem.addParams("live_id", this.aHu.mLiveInfo.live_id + "");
            alaStaticItem.addParams("room_id", this.aHu.mLiveInfo.room_id + "");
            alaStaticItem.addParams("feed_id", this.aHu.mLiveInfo.feed_id + "");
            alaStaticItem.addParams("other_params", aVar.JQ());
            if (aVar.JP() == 126) {
                alaStaticItem.addParams("gifts_value", String.valueOf(aVar.JR()));
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SUC_SEND_NEWS);
            alaStaticItem2.addParams("live_id", this.aHu.mLiveInfo.live_id + "");
            alaStaticItem2.addParams("room_id", this.aHu.mLiveInfo.room_id + "");
            alaStaticItem2.addParams("feed_id", this.aHu.mLiveInfo.feed_id + "");
            alaStaticItem2.addParams("other_params", aVar.JQ());
            if (aVar.JP() == 126) {
                alaStaticItem2.addParams("gifts_value", String.valueOf(aVar.JR()));
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem2);
        }
        if (!aVar.JV()) {
            if (aVar.JP() == 126) {
                if (aVar.JU()) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("msg", aVar.getText());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "msg_send").setContentExt("barrage", null, jSONObject));
                } else {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "msg_send").setContentExt("barrage", null, null));
                }
            } else if (aVar.JS()) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.putOpt("msg", aVar.getText());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "msg_send").setContentExt("fastkey", null, aVar.JT() ? "out" : "in", jSONObject2));
            } else {
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "msg_send").setContentExt("manual", null, null));
            }
        } else {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                jSONObject3.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, aVar.getCustomRoomId());
                if (Pattern.compile("\\[([一-龥\\w])+\\]").matcher(aVar.getContent()).find()) {
                    jSONObject3.put("is_meme", 1);
                } else {
                    jSONObject3.put("is_meme", 0);
                }
                if (com.baidu.live.aq.a.Wu().WA() != null && com.baidu.live.aq.a.Wu().WA().aGD != null) {
                    int roomMode = com.baidu.live.aq.a.Wu().WA().aGD.getRoomMode();
                    if (roomMode == 0) {
                        jSONObject3.put(UbcStatConstant.KEY_CONTENT_EXT_MODE, "normal");
                    } else if (roomMode == 1) {
                        jSONObject3.put(UbcStatConstant.KEY_CONTENT_EXT_MODE, "dating");
                    } else if (roomMode == 2) {
                        jSONObject3.put(UbcStatConstant.KEY_CONTENT_EXT_MODE, "battle");
                    }
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            if (aVar.JP() == 126) {
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "msg_send").setContentExt("barrage", null, jSONObject3));
            } else if (aVar.JS()) {
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "msg_send").setContentExt("fastkey", null, jSONObject3));
            } else {
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "msg_send").setContentExt("manual", null, jSONObject3));
            }
        }
        if (list != null && !list.isEmpty()) {
            try {
                for (com.baidu.h.a.b.a.c cVar : list) {
                    if (cVar != null) {
                        JSONObject jSONObject4 = new JSONObject();
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("msg_id", cVar.msgId + "");
                        jSONObject4.put("code", i);
                        a(jSONObject5, jSONObject4, "1537", UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, str);
                    }
                }
            } catch (JSONException e4) {
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
                    if (!TextUtils.isEmpty(cVar.aQH)) {
                        str = cVar.aQH;
                    } else if (cVar.caA != null && cVar.caA.caO != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(cVar.caA.caO);
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
            if (!arrayList.isEmpty() && this.aHu != null) {
                if (((com.baidu.live.im.data.b) arrayList.get(0)).getMsgType() == 126) {
                    com.baidu.live.q.a.c(this.aHu.mLiveInfo.live_id, 6);
                } else {
                    com.baidu.live.q.a.c(this.aHu.mLiveInfo.live_id, 2);
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
                this.biQ.e(z ? bis : bit, arrayList2);
            }
        }
    }

    private void gB(String str) {
        com.baidu.h.b.a.bx(this.mContext).Ya().a(str, this.biQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gC(String str) {
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
    public void Iy() {
        if (this.aHu != null && this.aHu.mLiveSdkInfo != null && this.aHu.mLiveSdkInfo.mCastIds != null) {
            this.biB = 0;
            this.biC = 0;
            this.chatMCastId = this.aHu.mLiveSdkInfo.mCastIds.chatMCastId;
            String str = this.aHu.mLiveSdkInfo.mCastIds.chat_msg_hls_url;
            this.ensureMCastId = this.aHu.mLiveSdkInfo.mCastIds.ensureMCastId;
            String str2 = this.aHu.mLiveSdkInfo.mCastIds.reliable_msg_hls_url;
            int i = JavaTypesHelper.toInt(this.aHu.mLiveSdkInfo.mCastIds.msg_hls_pull_internal_in_second, 5) * 1000;
            a(this.chatMCastId, str, i, false);
            a(this.ensureMCastId, str2, i, this.aHu.isHost);
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

    private void Iz() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("im_chat_mcast_id", this.chatMCastId);
            jSONObject.put("im_ensure_mcast_id", this.ensureMCastId);
            jSONObject.put("im_chat_mcast_count", this.biv);
            jSONObject.put("im_ensure_mcast_count", this.biw);
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
        if (this.aHu != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            if (TbConfig.IM_LOG) {
                Log.i("imUbclog", "Json: " + jSONObject.toString() + "  type: " + str2 + " isHost: " + this.aHu.isHost);
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
            UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(str, str2, this.aHu.isHost ? "author_liveroom" : "liveroom", str3);
            ubcStatisticItem.setContentExt(jSONObject3);
            UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
        }
    }
}
