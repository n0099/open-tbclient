package com.baidu.live.im;

import android.content.Context;
import android.os.Handler;
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
import com.baidu.live.data.w;
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
    private w aLD;
    private boolean blC;
    private int blD;
    private int blE;
    private List<String> blL;
    private List<AlaLiveMarkData> blM;
    private long blN;
    private String chatMCastId;
    private String ensureMCastId;
    private Context mContext;
    private static volatile f blz = null;
    private static int blA = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private static int blB = 2147483646;
    private long blF = 0;
    private LinkedList<Long> blG = new LinkedList<>();
    private long blH = 0;
    private long blI = 0;
    private Handler handler = new Handler();
    private int blJ = 0;
    private int blK = 0;
    private CustomMessageListener blO = new CustomMessageListener(2913081) { // from class: com.baidu.live.im.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            w wVar;
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0) {
                f.this.blF = 0L;
                if (com.baidu.i.b.a.bn(f.this.mContext).aaf() == null || !(customResponsedMessage.getData() instanceof w) || (wVar = (w) customResponsedMessage.getData()) == null) {
                    return;
                }
                if ((wVar.mLiveSdkInfo != null && wVar.mLiveSdkInfo.mCastIds != null) || (wVar.mLiveInfo != null && wVar.mLiveInfo.mCastIds != null)) {
                    if (wVar.mLiveInfo == null || wVar.mLiveInfo.live_status != 2) {
                        if (f.this.aLD != null && f.this.aLD.mLiveInfo != null && wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.live_id != f.this.aLD.mLiveInfo.live_id) {
                            f.this.blG.clear();
                            f.this.blH = 0L;
                            f.this.blI = 0L;
                        }
                        f.this.aLD = wVar;
                        f.this.S(f.this.aLD.aKB);
                        f.this.MQ();
                        f.this.MP();
                    }
                }
            }
        }
    };
    private CustomMessageListener blP = new CustomMessageListener(2913082) { // from class: com.baidu.live.im.f.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof w)) {
                w wVar = (w) customResponsedMessage.getData();
                if (f.this.aLD != null && f.this.aLD.mLiveInfo != null && wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.live_id != f.this.aLD.mLiveInfo.live_id) {
                    f.this.blG.clear();
                    f.this.blH = 0L;
                    f.this.blI = 0L;
                }
                f.this.aLD = wVar;
                f.this.S(f.this.aLD.aKB);
            }
        }
    };
    private CustomMessageListener blQ = new CustomMessageListener(2501033) { // from class: com.baidu.live.im.f.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof w)) {
                w wVar = (w) customResponsedMessage.getData();
                if (f.this.aLD != null && f.this.aLD.mLiveInfo != null && wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.live_id != f.this.aLD.mLiveInfo.live_id) {
                    f.this.blG.clear();
                    f.this.blH = 0L;
                    f.this.blI = 0L;
                }
                f.this.aLD = wVar;
                f.this.S(f.this.aLD.aKB);
            }
        }
    };
    private CustomMessageListener blR = new CustomMessageListener(2913118) { // from class: com.baidu.live.im.f.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof w)) {
                f.this.S(((w) customResponsedMessage.getData()).aKB);
            }
        }
    };
    private HttpRule blS = new HttpRule(1021013) { // from class: com.baidu.live.im.f.15
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
    private HttpRule blT = new HttpRule(1021012) { // from class: com.baidu.live.im.f.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            return null;
        }
    };
    CustomMessageListener blU = new CustomMessageListener(2913084) { // from class: com.baidu.live.im.f.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.De();
        }
    };
    CustomMessageListener aWM = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.im.f.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.MU();
            f.this.handler.post(new Runnable() { // from class: com.baidu.live.im.f.18.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.MV();
                }
            });
        }
    };
    private HttpRule blV = new HttpRule(1021006) { // from class: com.baidu.live.im.f.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            f.this.MU();
            if (f.this.aLD != null && f.this.aLD.mLiveSdkInfo != null && f.this.aLD.mLiveSdkInfo.mCastIds != null) {
                String str = f.this.aLD.mLiveSdkInfo.mCastIds.chatMCastId;
                String str2 = f.this.aLD.mLiveSdkInfo.mCastIds.ensureMCastId;
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str, -1, "", "", "");
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str2, -1, "", "", "");
            }
            f.this.handler.post(new Runnable() { // from class: com.baidu.live.im.f.19.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.MV();
                }
            });
            return httpMessage;
        }
    };
    private IFetchMsgByIdListener blW = new IFetchMsgByIdListener() { // from class: com.baidu.live.im.f.4
        @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
        public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList) {
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
    private IFetchMsgByIdListener blX = new IFetchMsgByIdListener() { // from class: com.baidu.live.im.f.5
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
    private com.baidu.i.a.b.a.d blY = new com.baidu.i.a.b.a.d() { // from class: com.baidu.live.im.f.6
        @Override // com.baidu.i.a.b.a.d
        public void e(int i, List<com.baidu.i.a.b.a.c> list) {
            String str;
            String str2;
            JSONObject jSONObject;
            String optString;
            if (f.this.aLD == null || f.this.chatMCastId == null || f.this.ensureMCastId == null || f.this.aLD.mLiveInfo == null) {
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收: 直播间已销毁");
                }
            } else if (i != 0 && i != f.blA && i != f.blB) {
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收: 非有效消息");
                }
            } else {
                ALAGroupHttpResponseMessage aLAGroupHttpResponseMessage = new ALAGroupHttpResponseMessage();
                ArrayList arrayList = new ArrayList();
                if (f.this.blL != null) {
                    f.this.blL.clear();
                }
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收:");
                }
                for (com.baidu.i.a.b.a.c cVar : list) {
                    if (cVar == null) {
                        if (TbConfig.IM_LOG) {
                            Log.i("imlog", "@.@ IM消息 接收: messageBean 为空");
                        }
                    } else {
                        if (TbConfig.IM_LOG && cVar.bYG != null) {
                            try {
                                String str3 = cVar.bYG.bYU;
                                if (str3 != null) {
                                    Log.i("imlog", "@.@ IM消息 接收: contentType=" + new JSONObject(optString).optString("content_type") + ";;;content=" + new JSONObject(str3).optString("content"));
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        String str4 = "";
                        if (!TextUtils.isEmpty(cVar.aUg)) {
                            str = cVar.aUg;
                            str2 = "";
                        } else {
                            if (cVar.bYG != null && cVar.bYG.bYU != null) {
                                try {
                                    JSONObject jSONObject2 = new JSONObject(cVar.bYG.bYU);
                                    if (!TextUtils.isEmpty(jSONObject2.optString("room_id"))) {
                                        str4 = jSONObject2.optString("room_id");
                                    }
                                    String optString2 = jSONObject2.optString("msg_type");
                                    if (TextUtils.isEmpty(optString2)) {
                                        optString2 = jSONObject2.optString("msgType");
                                    }
                                    str = str4;
                                    str2 = optString2;
                                } catch (JSONException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            str = "";
                            str2 = "";
                        }
                        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, f.this.chatMCastId) && !TextUtils.equals(str, f.this.ensureMCastId)) {
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ IM消息 接收  非当前直播间的消息，过滤 castId：" + str + "   chatMCastId：" + f.this.chatMCastId + "   ensureMCastId: " + f.this.ensureMCastId);
                            }
                            f.this.ic(str);
                        } else if (TextUtils.equals(cVar.type, "0") && TextUtils.isEmpty(str)) {
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ IM消息 接收: 如果是普通消息同时castId为空，过滤");
                            }
                            f.this.ic(str);
                        } else if (!TextUtils.isEmpty(str) || !TextUtils.equals(str2, SoUtils.SO_EVENT_ID_DEFAULT)) {
                            if (i != f.blA && i != f.blB && TextUtils.equals(str, f.this.chatMCastId)) {
                                f.this.blF = System.currentTimeMillis();
                                if (TbConfig.IM_LOG) {
                                    Log.d("im-debug", "receiveChatMsgTime= " + f.this.blF);
                                }
                                f.this.blC = false;
                                f.this.MP();
                            }
                            if (!f.this.blG.contains(Long.valueOf(cVar.msgId))) {
                                if (i == f.blA) {
                                    String str5 = "";
                                    String str6 = "";
                                    if (!TextUtils.isEmpty(cVar.bYH)) {
                                        try {
                                            JSONObject jSONObject3 = new JSONObject(cVar.bYH);
                                            str5 = jSONObject3.optString("msgType");
                                            if (TextUtils.isEmpty(str5)) {
                                                str5 = jSONObject3.optString("msg_type");
                                            }
                                        } catch (JSONException e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                    if (cVar.bYG != null) {
                                        try {
                                            str6 = new JSONObject(new JSONObject(cVar.bYG.bYU).optString("content")).optString("content_type");
                                        } catch (Exception e4) {
                                            e4.printStackTrace();
                                        }
                                    }
                                    if (!TextUtils.equals(cVar.type, "0") || (!TextUtils.isEmpty(str5) && !TextUtils.equals(str5, "1"))) {
                                        if (!TextUtils.equals(str6, "audio_emoticon")) {
                                            if (TbConfig.IM_LOG) {
                                                Log.d("im-debug", "filters msg contentType=" + str6 + " type=" + cVar.type);
                                            }
                                        } else if (TbConfig.IM_LOG) {
                                            Log.d("im-debug", "no filters msg contentType=" + str6 + " type=" + cVar.type);
                                        }
                                    }
                                    if (TbConfig.IM_LOG) {
                                        Log.d("im-debug", "s == IM_HISTORY_RESPONSE_CODE：no filters msg contentType=" + str6 + " type=" + cVar.type);
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
                                            if (aVar.NU() != null && (!TextUtils.isEmpty(aVar.NU().name_show) || !TextUtils.isEmpty(aVar.NU().userName))) {
                                                arrayList.add(aVar);
                                            }
                                            i2 = i3 + 1;
                                        }
                                    } else {
                                        arrayList.addAll(a2);
                                    }
                                    if (i == 0 && cVar.bYG != null && !TextUtils.isEmpty(cVar.bYG.bYU)) {
                                        if (f.this.blL == null) {
                                            f.this.blL = new ArrayList();
                                        }
                                        f.this.blL.add(cVar.bYG.bYU);
                                    }
                                    if (!TextUtils.equals(cVar.type, TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY)) {
                                        if (TextUtils.equals(str2, SoUtils.SO_EVENT_ID_DEFAULT)) {
                                            f.this.blE += a2.size();
                                            if (f.this.aLD != null && f.this.aLD.isHost) {
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
                                                                if (aVar2.NU() != null) {
                                                                    jSONObject4.put("sender_uk", EncryptionHelper.getEncryptionUserId(aVar2.NU().userId));
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
                                            f.this.blD += a2.size();
                                        }
                                    }
                                    if (f.this.blG.size() > 200) {
                                        f.this.blG.removeFirst();
                                    }
                                    f.this.blG.add(Long.valueOf(cVar.msgId));
                                    if (!TextUtils.equals(str, f.this.chatMCastId) || cVar.msgId <= f.this.blH) {
                                        if (TextUtils.equals(str, f.this.chatMCastId) && cVar.msgId > f.this.blI) {
                                            f.this.blI = cVar.msgId;
                                        }
                                    } else {
                                        f.this.blH = cVar.msgId;
                                    }
                                }
                            } else if (TbConfig.IM_LOG) {
                                Log.d("im-debug", "remove repeat msg msgid=" + cVar.msgId + " type=" + cVar.type);
                            }
                        } else {
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ IM消息 接收: 如果是普通消息同时castId为空，过滤礼物消息");
                            }
                            f.this.ic(str);
                        }
                    }
                }
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收: 消息分发 Size: " + arrayList.size() + "  History: " + (i == f.blA));
                }
                if (f.this.blL != null && !f.this.blL.isEmpty()) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.addAll(f.this.blL);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913251, arrayList2));
                }
                if (arrayList.size() > 0) {
                    aLAGroupHttpResponseMessage.cl(i == f.blA);
                    aLAGroupHttpResponseMessage.X(arrayList);
                    aLAGroupHttpResponseMessage.setGroupId(f.this.aLD.mLiveInfo.getGroupID());
                    MessageManager.getInstance().dispatchResponsedMessage(aLAGroupHttpResponseMessage);
                    if (f.this.blL != null && !f.this.blL.isEmpty()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913107, f.this.blL));
                    }
                }
            }
        }
    };
    private CustomMessageListener blZ = new CustomMessageListener(2913108) { // from class: com.baidu.live.im.f.7
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
                f.this.MW();
            }
        }
    };
    private CustomMessageListener bma = new CustomMessageListener(2913190) { // from class: com.baidu.live.im.f.8
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
                    f.this.MW();
                } else {
                    f.this.handler.removeCallbacks(f.this.bmb);
                    f.this.handler.postDelayed(f.this.bmb, 1000L);
                }
            }
            if (TbadkCoreApplication.getInst().isTieba()) {
                if (LoginManager.getInstance(TbadkCoreApplication.getInst().getContext()).isIMLogined()) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ IM消息 贴吧直播间切前台监听 -- IM 没断，直接 join");
                    }
                    f.this.MW();
                    return;
                }
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 贴吧直播间切前台监听 -- IM 断");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913191, null));
            }
        }
    };
    private Runnable bmb = new Runnable() { // from class: com.baidu.live.im.f.9
        @Override // java.lang.Runnable
        public void run() {
            f.this.MW();
        }
    };
    private Runnable bmc = new Runnable() { // from class: com.baidu.live.im.f.10
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (TbConfig.IM_LOG) {
                Log.d("im-debug", "imExceptionCheckRunnable: " + (currentTimeMillis - f.this.blF));
            }
            if (currentTimeMillis - f.this.blF >= 18000) {
                if (!f.this.blC) {
                    f.this.blC = true;
                    f.this.MS();
                }
                if (f.this.aLD != null && f.this.aLD.isHost) {
                    f.this.MQ();
                    f.this.MR();
                }
            } else if (f.this.blC) {
                f.this.blC = false;
                f.this.MS();
            }
            f.this.MP();
        }
    };
    private CustomMessageTask.CustomRunnable bmd = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.im.f.11
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            String str;
            if (f.this.aLD != null && f.this.aLD.mLiveSdkInfo != null && f.this.aLD.mLiveSdkInfo.mCastIds != null) {
                str = f.this.aLD.mLiveSdkInfo.mCastIds.ensureMCastId;
            } else {
                str = "0";
            }
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID, str);
        }
    };

    public static f MO() {
        if (blz == null) {
            synchronized (f.class) {
                if (blz == null) {
                    blz = new f();
                }
            }
        }
        return blz;
    }

    private f() {
    }

    public void aY(Context context) {
        this.mContext = context;
        MessageManager.getInstance().unRegisterListener(this.blO);
        MessageManager.getInstance().registerListener(this.blO);
        MessageManager.getInstance().removeMessageRule(this.blT);
        MessageManager.getInstance().addMessageRule(this.blT);
        MessageManager.getInstance().unRegisterListener(this.blU);
        MessageManager.getInstance().registerListener(this.blU);
        MessageManager.getInstance().unRegisterListener(this.blZ);
        MessageManager.getInstance().registerListener(this.blZ);
        MessageManager.getInstance().unRegisterListener(this.bma);
        MessageManager.getInstance().registerListener(this.bma);
        new CustomMessageTask(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID, this.bmd).setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID);
    }

    public void De() {
        this.handler.removeCallbacksAndMessages(null);
        com.baidu.i.b.a.bn(this.mContext).aaf().MU();
        this.blN = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MP() {
        this.handler.removeCallbacks(this.bmc);
        if (this.aLD != null && this.aLD.mLiveInfo != null) {
            this.handler.postDelayed(this.bmc, 18000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MQ() {
        int i;
        String str;
        String str2;
        if (this.aLD != null) {
            if (this.aLD.mLiveSdkInfo != null && this.aLD.mLiveSdkInfo.mCastIds != null) {
                this.chatMCastId = this.aLD.mLiveSdkInfo.mCastIds.chatMCastId;
                String str3 = this.aLD.mLiveSdkInfo.mCastIds.chat_msg_hls_url;
                this.ensureMCastId = this.aLD.mLiveSdkInfo.mCastIds.ensureMCastId;
                String str4 = this.aLD.mLiveSdkInfo.mCastIds.reliable_msg_hls_url;
                i = JavaTypesHelper.toInt(this.aLD.mLiveSdkInfo.mCastIds.msg_hls_pull_internal_in_second, 5) * 1000;
                str = str4;
                str2 = str3;
            } else if (this.aLD.mLiveInfo == null || this.aLD.mLiveInfo.mCastIds == null) {
                i = 5000;
                str = "";
                str2 = "";
            } else {
                this.chatMCastId = this.aLD.mLiveInfo.mCastIds.chatMCastId;
                String str5 = this.aLD.mLiveInfo.mCastIds.chat_msg_hls_url;
                this.ensureMCastId = this.aLD.mLiveInfo.mCastIds.ensureMCastId;
                String str6 = this.aLD.mLiveInfo.mCastIds.reliable_msg_hls_url;
                i = JavaTypesHelper.toInt(this.aLD.mLiveInfo.mCastIds.msg_hls_pull_internal_in_second, 5) * 1000;
                str = str6;
                str2 = str5;
            }
            a(this.chatMCastId, str2, i, false);
            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", this.chatMCastId, this.chatMCastId, 0, "", "", "");
            a(this.ensureMCastId, str, i, this.aLD.isHost);
            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", this.chatMCastId, this.ensureMCastId, 0, "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MR() {
        if (TbConfig.IM_LOG) {
            Log.d("im-debug", "start fetch im chat castid=" + this.chatMCastId + "lastmsgid=" + this.blH);
        }
        int i = 25;
        if (this.blH == 0) {
            i = -25;
        }
        BIMManager.fetchMsgRequest(this.mContext, AccountManager.getAppid(this.mContext), AccountManager.getUK(this.mContext), 4, JavaTypesHelper.toLong(this.chatMCastId, -1L), this.blH, Long.MAX_VALUE, i, 1, this.blX);
        int i2 = 25;
        if (this.blI == 0) {
            i2 = -25;
        }
        if (TbConfig.IM_LOG) {
            Log.d("im-debug", "start fetch im ensure castid=" + this.ensureMCastId + " lastmsgid=" + this.blI);
        }
        BIMManager.fetchMsgRequest(this.mContext, AccountManager.getAppid(this.mContext), AccountManager.getUK(this.mContext), 4, JavaTypesHelper.toLong(this.ensureMCastId, -1L), this.blI, Long.MAX_VALUE, i2, 1, this.blX, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MS() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME), Long.class);
        if (runTask == null) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("im_state", this.blC ? 0 : 1);
            jSONObject.put("im_chat_mcast_id", this.chatMCastId);
            jSONObject.put("im_ensure_mcast_id", this.ensureMCastId);
            jSONObject.put("im_live_info_time", j);
            jSONObject.put("im_last_msg_time", this.blF);
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
            com.baidu.i.b.a.bn(this.mContext).aaf().a(str, str2, i, new com.baidu.i.a.b.b() { // from class: com.baidu.live.im.f.2
                @Override // com.baidu.i.a.b.b
                public void onResult(int i2, long j, long j2) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ enterRoom onResult i:" + i2 + ", l:" + j + ", l1:" + j2);
                    }
                    if (f.this.aLD == null || f.this.chatMCastId == null || f.this.ensureMCastId == null) {
                        com.baidu.i.b.a.bn(f.this.mContext).aaf().jD(String.valueOf(j));
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.chatMCastId, String.valueOf(j), -1, "", "", "");
                        return;
                    }
                    long j3 = JavaTypesHelper.toLong(f.this.chatMCastId, -1L);
                    long j4 = JavaTypesHelper.toLong(f.this.ensureMCastId, -1L);
                    if (j3 != j && j4 != j) {
                        com.baidu.i.b.a.bn(f.this.mContext).aaf().jD(String.valueOf(j));
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.chatMCastId, String.valueOf(j), -1, "", "", "");
                        if (TbConfig.IM_LOG) {
                            Log.e("imlog", "BDIM enterRoom wrong then exit end:" + j);
                            return;
                        }
                        return;
                    }
                    if (j3 == j) {
                        f.this.blD = 0;
                    } else {
                        f.this.blE = 0;
                    }
                    if (i2 != 0) {
                        f.this.b(j, i2, j3 == j ? f.this.blJ : f.this.blK);
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
                            if (f.this.blJ < 6) {
                                f.this.handler.postDelayed(new Runnable() { // from class: com.baidu.live.im.f.2.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        f.this.a(str, str2, i, z);
                                    }
                                }, IMConnection.RETRY_DELAY_TIMES);
                                f.this.blJ++;
                                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_MSG_FAIL_TO_REJOIN, f.this.chatMCastId, str, -1, "", "", "");
                                return;
                            }
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.chatMCastId, str, -1, "", "", "");
                        } else if (f.this.blK < 6) {
                            f.this.handler.postDelayed(new Runnable() { // from class: com.baidu.live.im.f.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    f.this.a(str, str2, i, z);
                                }
                            }, IMConnection.RETRY_DELAY_TIMES);
                            f.this.blK++;
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_GIFT_FAIL_TO_REJOIN, f.this.chatMCastId, str, -1, "", "", "");
                        } else {
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.chatMCastId, str, -1, "", "", "");
                        }
                    } else if (j3 == j) {
                        f.this.blJ = 0;
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", f.this.chatMCastId, str, 0, "", "", "");
                        if (TbConfig.IM_LOG) {
                            Log.i("imlog", "@.@ enterRoom onResult JOIN Msg成功:" + j3);
                        }
                        if ((!f.this.aLD.isHost || (f.this.aLD.isHost && f.this.aLD.aKE)) && f.this.blN != j3) {
                            f.this.blN = j3;
                            long j5 = JavaTypesHelper.toLong(str, -1L);
                            BIMManager.fetchMsgRequest(f.this.mContext, AccountManager.getAppid(f.this.mContext), AccountManager.getUK(f.this.mContext), 4, j5, 0L, Long.MAX_VALUE, -25, 1, f.this.blW);
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ enterRoom fetchMsgidByMsgid:   " + j5);
                            }
                        }
                    } else {
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", f.this.chatMCastId, str, 0, "", "", "");
                        if (TbConfig.IM_LOG) {
                            Log.i("imlog", "@.@ enterRoom onResult JOIN Gift成功:" + j4);
                        }
                        f.this.blK = 0;
                    }
                }
            }, z);
            MT();
            ib(str);
            if (TbConfig.IM_LOG) {
                Log.i("imlog", "@.@ enterRoom registerMsgReceiveListener:" + z + ", mCastId: " + str);
            }
        }
    }

    private void MT() {
        MessageManager.getInstance().unRegisterListener(this.aWM);
        MessageManager.getInstance().registerListener(this.aWM);
        MessageManager.getInstance().unRegisterListener(this.blP);
        MessageManager.getInstance().registerListener(this.blP);
        MessageManager.getInstance().unRegisterListener(this.blQ);
        MessageManager.getInstance().registerListener(this.blQ);
        MessageManager.getInstance().unRegisterListener(this.blR);
        MessageManager.getInstance().registerListener(this.blR);
        MessageManager.getInstance().removeMessageRule(this.blS);
        MessageManager.getInstance().addMessageRule(this.blS);
        MessageManager.getInstance().removeMessageRule(this.blV);
        MessageManager.getInstance().addMessageRule(this.blV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MU() {
        this.handler.removeCallbacksAndMessages(null);
        if (this.aLD != null && this.aLD.mLiveSdkInfo != null && this.aLD.mLiveSdkInfo.mCastIds != null) {
            String str = this.aLD.mLiveSdkInfo.mCastIds.chatMCastId;
            String str2 = this.aLD.mLiveSdkInfo.mCastIds.ensureMCastId;
            com.baidu.i.b.a.bn(this.mContext).aaf().jD(str);
            com.baidu.i.b.a.bn(this.mContext).aaf().jD(str2);
            MX();
        }
        this.blD = 0;
        this.blE = 0;
        this.blN = 0L;
        this.aLD = null;
        this.chatMCastId = null;
        this.ensureMCastId = null;
        this.blJ = 0;
        this.blK = 0;
        if (this.blL != null) {
            this.blL.clear();
            this.blL = null;
        }
        if (this.blM != null) {
            this.blM.clear();
            this.blM = null;
        }
        this.blG.clear();
        this.blH = 0L;
        this.blH = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MV() {
        MessageManager.getInstance().unRegisterListener(this.blP);
        MessageManager.getInstance().unRegisterListener(this.blQ);
        MessageManager.getInstance().unRegisterListener(this.blR);
        MessageManager.getInstance().unRegisterListener(this.aWM);
        MessageManager.getInstance().removeMessageRule(this.blS);
        MessageManager.getInstance().removeMessageRule(this.blV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(List<AlaLiveMarkData> list) {
        if (list != null && !list.isEmpty()) {
            if (this.blM == null) {
                this.blM = new ArrayList();
            }
            this.blM.clear();
            this.blM.addAll(list);
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
        final String str2 = (this.aLD == null || this.aLD.mLiveSdkInfo == null || this.aLD.mLiveSdkInfo.mCastIds == null) ? null : this.aLD.mLiveSdkInfo.mCastIds.chatMCastId;
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.i.a.b.a.e eVar = new com.baidu.i.a.b.a.e();
            eVar.msg = content;
            eVar.aUg = str2;
            if (this.aLD != null && this.aLD.aKr != null) {
                eVar.name = this.aLD.aKr.userName;
                eVar.portrait = this.aLD.aKr.portrait;
            }
            a aVar2 = new a();
            if (this.aLD != null) {
                if (this.aLD.isHost) {
                    alaLiveUserInfoData = this.aLD.aJV;
                } else {
                    alaLiveUserInfoData = this.aLD.aKr;
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
                    aVar3.aIy = alaLiveUserInfoData.followCount;
                    aVar3.aIx = alaLiveUserInfoData.fansCount;
                    aVar3.aIB = alaLiveUserInfoData.isAdmin == 1;
                    aVar3.aIA = alaLiveUserInfoData.isOfficial == 1;
                    aVar3.level_id = alaLiveUserInfoData.levelId;
                    aVar3.aID = this.blM;
                    aVar3.sex = alaLiveUserInfoData.sex;
                    aVar3.extraUserInfo = alaLiveUserInfoData.extraUserInfo;
                    aVar2.e(aVar3);
                    aVar2.setContent(content);
                    aVar2.setMsgType(aVar.Oi());
                    aVar2.fe(aVar.NY());
                    aVar2.ii(aVar.NZ());
                    aVar2.a(aVar.Oa());
                    aVar2.l(aVar.Ob());
                    aVar2.setUserId(alaLiveUserInfoData.userId);
                    aVar2.hY(String.valueOf(this.aLD.mLiveInfo.user_id));
                    aVar2.setBornTime(System.currentTimeMillis());
                    str = aVar2.Ms();
                }
            }
            eVar.bYH = str;
            com.baidu.i.a.b.a.f fVar = new com.baidu.i.a.b.a.f() { // from class: com.baidu.live.im.f.3
                @Override // com.baidu.i.a.b.a.f
                public void a(String str3, int i, List<com.baidu.i.a.b.a.c> list) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ IM消息 onSendSuccess s:" + str3 + ", i:" + i);
                    }
                    if (f.this.aLD != null && f.this.chatMCastId != null && f.this.ensureMCastId != null) {
                        if (TextUtils.equals(str3, f.this.chatMCastId) || TextUtils.equals(str3, f.this.ensureMCastId)) {
                            ALAGroupCommitHttpResponsedMessage aLAGroupCommitHttpResponsedMessage = new ALAGroupCommitHttpResponsedMessage();
                            aLAGroupCommitHttpResponsedMessage.setStatusCode(200, null);
                            if (f.this.aLD.mLiveInfo != null) {
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
            aB(content, str2);
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
            com.baidu.i.b.a.bn(this.mContext).aaf().a(str2, eVar, fVar);
            if (TbConfig.IM_LOG) {
                Log.i("imlog", "@.@ IM消息 发送 roomId:" + str2 + ", sendMessage:" + eVar.toString());
            }
        }
    }

    private void aB(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("im_send_content", str);
            a(jSONObject, (JSONObject) null, "1529", UbcStatConstant.ContentType.UBC_TYPE_IM_SEND, str2);
        } catch (JSONException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.im.message.a aVar, int i, String str, List<com.baidu.i.a.b.a.c> list) {
        if (TbadkCoreApplication.getInst().isHaokan()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SUC_SEND_NEWS);
            alaStaticItem.addParams("live_id", this.aLD.mLiveInfo.live_id + "");
            alaStaticItem.addParams("room_id", this.aLD.mLiveInfo.room_id + "");
            alaStaticItem.addParams("feed_id", this.aLD.mLiveInfo.feed_id + "");
            alaStaticItem.addParams("other_params", aVar.Oj());
            if (aVar.Oi() == 126) {
                alaStaticItem.addParams("gifts_value", String.valueOf(aVar.Ok()));
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SUC_SEND_NEWS);
            alaStaticItem2.addParams("live_id", this.aLD.mLiveInfo.live_id + "");
            alaStaticItem2.addParams("room_id", this.aLD.mLiveInfo.room_id + "");
            alaStaticItem2.addParams("feed_id", this.aLD.mLiveInfo.feed_id + "");
            alaStaticItem2.addParams("other_params", aVar.Oj());
            if (aVar.Oi() == 126) {
                alaStaticItem2.addParams("gifts_value", String.valueOf(aVar.Ok()));
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem2);
        }
        if (!aVar.Om()) {
            if (aVar.Oi() == 126) {
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "msg_send").setContentExt("barrage", null, null));
            } else if (aVar.Ol()) {
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "msg_send").setContentExt("fastkey", null, null));
            } else {
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "msg_send").setContentExt("manual", null, null));
            }
        } else {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, aVar.getCustomRoomId());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (aVar.Oi() == 126) {
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "msg_send").setContentExt("barrage", null, jSONObject));
            } else if (aVar.Ol()) {
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "msg_send").setContentExt("fastkey", null, jSONObject));
            } else {
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "msg_send").setContentExt("manual", null, jSONObject));
            }
        }
        if (list != null && !list.isEmpty()) {
            try {
                for (com.baidu.i.a.b.a.c cVar : list) {
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
    public void v(List<com.baidu.i.a.b.a.c> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.i.a.b.a.c cVar : list) {
                if (cVar != null) {
                    String str = "";
                    if (!TextUtils.isEmpty(cVar.aUg)) {
                        str = cVar.aUg;
                    } else if (cVar.bYG != null && cVar.bYG.bYU != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(cVar.bYG.bYU);
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
            if (!arrayList.isEmpty() && this.aLD != null) {
                if (((com.baidu.live.im.data.b) arrayList.get(0)).getMsgType() == 126) {
                    com.baidu.live.p.a.b(this.aLD.mLiveInfo.live_id, 6);
                } else {
                    com.baidu.live.p.a.b(this.aLD.mLiveInfo.live_id, 2);
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
                com.baidu.i.a.b.a.c a2 = com.baidu.i.b.a.a.a.a.a(it.next());
                if (a2 != null) {
                    arrayList2.add(a2);
                }
            }
            if (!arrayList2.isEmpty()) {
                Collections.reverse(arrayList2);
                if (TbConfig.IM_LOG) {
                    Log.d("im-debug", "handleFetchMsgResult msgList size=" + arrayList2.size());
                }
                this.blY.e(z ? blA : blB, arrayList2);
            }
        }
    }

    private void ib(String str) {
        com.baidu.i.b.a.bn(this.mContext).aaf().a(str, this.blY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ic(String str) {
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
    public void MW() {
        if (this.aLD != null && this.aLD.mLiveSdkInfo != null && this.aLD.mLiveSdkInfo.mCastIds != null) {
            this.blJ = 0;
            this.blK = 0;
            this.chatMCastId = this.aLD.mLiveSdkInfo.mCastIds.chatMCastId;
            String str = this.aLD.mLiveSdkInfo.mCastIds.chat_msg_hls_url;
            this.ensureMCastId = this.aLD.mLiveSdkInfo.mCastIds.ensureMCastId;
            String str2 = this.aLD.mLiveSdkInfo.mCastIds.reliable_msg_hls_url;
            int i = JavaTypesHelper.toInt(this.aLD.mLiveSdkInfo.mCastIds.msg_hls_pull_internal_in_second, 5) * 1000;
            a(this.chatMCastId, str, i, false);
            a(this.ensureMCastId, str2, i, this.aLD.isHost);
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

    private void MX() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("im_chat_mcast_id", this.chatMCastId);
            jSONObject.put("im_ensure_mcast_id", this.ensureMCastId);
            jSONObject.put("im_chat_mcast_count", this.blD);
            jSONObject.put("im_ensure_mcast_count", this.blE);
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
        if (this.aLD != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            if (TbConfig.IM_LOG) {
                Log.i("imUbclog", "Json: " + jSONObject.toString() + "  type: " + str2 + " isHost: " + this.aLD.isHost);
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
            UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(str, str2, this.aLD.isHost ? "author_liveroom" : "liveroom", str3);
            ubcStatisticItem.setContentExt(jSONObject3);
            UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
        }
    }
}
