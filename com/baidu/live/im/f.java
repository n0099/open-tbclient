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
    private static volatile f biY = null;
    private static int biZ = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private static int bja = 2147483646;
    private w aKv;
    private boolean bjb;
    private int bjc;
    private int bjd;
    private List<String> bjk;
    private List<AlaLiveMarkData> bjl;
    private long bjm;
    private String chatMCastId;
    private String ensureMCastId;
    private Context mContext;
    private long bje = 0;
    private LinkedList<Long> bjf = new LinkedList<>();
    private long bjg = 0;
    private long bjh = 0;
    private int bji = 0;
    private int bjj = 0;
    private CustomMessageListener bjn = new CustomMessageListener(2913081) { // from class: com.baidu.live.im.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            w wVar;
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0) {
                f.this.bje = 0L;
                if (com.baidu.h.b.a.aJ(f.this.mContext).Yl() == null || !(customResponsedMessage.getData() instanceof w) || (wVar = (w) customResponsedMessage.getData()) == null) {
                    return;
                }
                if ((wVar.mLiveSdkInfo != null && wVar.mLiveSdkInfo.mCastIds != null) || (wVar.mLiveInfo != null && wVar.mLiveInfo.mCastIds != null)) {
                    if (wVar.mLiveInfo == null || wVar.mLiveInfo.live_status != 2) {
                        if (f.this.aKv != null && f.this.aKv.mLiveInfo != null && wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.live_id != f.this.aKv.mLiveInfo.live_id) {
                            f.this.bjf.clear();
                            f.this.bjg = 0L;
                            f.this.bjh = 0L;
                        }
                        f.this.aKv = wVar;
                        f.this.R(f.this.aKv.aJA);
                        f.this.Lw();
                        f.this.Lv();
                    }
                }
            }
        }
    };
    private CustomMessageListener bjo = new CustomMessageListener(2913082) { // from class: com.baidu.live.im.f.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof w)) {
                w wVar = (w) customResponsedMessage.getData();
                if (f.this.aKv != null && f.this.aKv.mLiveInfo != null && wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.live_id != f.this.aKv.mLiveInfo.live_id) {
                    f.this.bjf.clear();
                    f.this.bjg = 0L;
                    f.this.bjh = 0L;
                }
                f.this.aKv = wVar;
                f.this.R(f.this.aKv.aJA);
            }
        }
    };
    private CustomMessageListener bjp = new CustomMessageListener(2501033) { // from class: com.baidu.live.im.f.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof w)) {
                w wVar = (w) customResponsedMessage.getData();
                if (f.this.aKv != null && f.this.aKv.mLiveInfo != null && wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.live_id != f.this.aKv.mLiveInfo.live_id) {
                    f.this.bjf.clear();
                    f.this.bjg = 0L;
                    f.this.bjh = 0L;
                }
                f.this.aKv = wVar;
                f.this.R(f.this.aKv.aJA);
            }
        }
    };
    private CustomMessageListener bjq = new CustomMessageListener(2913118) { // from class: com.baidu.live.im.f.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof w)) {
                f.this.R(((w) customResponsedMessage.getData()).aJA);
            }
        }
    };
    private HttpRule bjr = new HttpRule(1021013) { // from class: com.baidu.live.im.f.15
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
    private HttpRule bjs = new HttpRule(1021012) { // from class: com.baidu.live.im.f.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            return null;
        }
    };
    CustomMessageListener bjt = new CustomMessageListener(2913084) { // from class: com.baidu.live.im.f.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.Ce();
        }
    };
    CustomMessageListener aVt = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.im.f.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.LA();
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.im.f.18.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.LB();
                }
            });
        }
    };
    private HttpRule bju = new HttpRule(1021006) { // from class: com.baidu.live.im.f.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            f.this.LA();
            if (f.this.aKv != null && f.this.aKv.mLiveSdkInfo != null && f.this.aKv.mLiveSdkInfo.mCastIds != null) {
                String str = f.this.aKv.mLiveSdkInfo.mCastIds.chatMCastId;
                String str2 = f.this.aKv.mLiveSdkInfo.mCastIds.ensureMCastId;
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str, -1, "", "", "");
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str2, -1, "", "", "");
            }
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.im.f.19.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.LB();
                }
            });
            return httpMessage;
        }
    };
    private IFetchMsgByIdListener bjv = new IFetchMsgByIdListener() { // from class: com.baidu.live.im.f.4
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
    private IFetchMsgByIdListener bjw = new IFetchMsgByIdListener() { // from class: com.baidu.live.im.f.5
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
    private com.baidu.h.a.b.a.d bjx = new com.baidu.h.a.b.a.d() { // from class: com.baidu.live.im.f.6
        @Override // com.baidu.h.a.b.a.d
        public void e(int i, List<com.baidu.h.a.b.a.c> list) {
            String str;
            String str2;
            JSONObject jSONObject;
            String optString;
            if (f.this.aKv == null || f.this.chatMCastId == null || f.this.ensureMCastId == null || f.this.aKv.mLiveInfo == null) {
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收: 直播间已销毁");
                }
            } else if (i != 0 && i != f.biZ && i != f.bja) {
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收: 非有效消息");
                }
            } else {
                ALAGroupHttpResponseMessage aLAGroupHttpResponseMessage = new ALAGroupHttpResponseMessage();
                ArrayList arrayList = new ArrayList();
                if (f.this.bjk != null) {
                    f.this.bjk.clear();
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
                        if (TbConfig.IM_LOG && cVar.bVa != null) {
                            try {
                                Log.i("imlog", "@.@ IM消息 接收: contentType=" + new JSONObject(optString).optString("content_type") + ";;;content=" + new JSONObject(cVar.bVa.bVo).optString("content"));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        String str3 = "";
                        if (!TextUtils.isEmpty(cVar.aSP)) {
                            str = cVar.aSP;
                            str2 = "";
                        } else {
                            if (cVar.bVa != null && cVar.bVa.bVo != null) {
                                try {
                                    JSONObject jSONObject2 = new JSONObject(cVar.bVa.bVo);
                                    if (!TextUtils.isEmpty(jSONObject2.optString("room_id"))) {
                                        str3 = jSONObject2.optString("room_id");
                                    }
                                    String optString2 = jSONObject2.optString("msg_type");
                                    if (TextUtils.isEmpty(optString2)) {
                                        optString2 = jSONObject2.optString("msgType");
                                    }
                                    str = str3;
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
                            f.this.hI(str);
                        } else if (TextUtils.equals(cVar.type, "0") && TextUtils.isEmpty(str)) {
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ IM消息 接收: 如果是普通消息同时castId为空，过滤");
                            }
                            f.this.hI(str);
                        } else if (!TextUtils.isEmpty(str) || !TextUtils.equals(str2, SoUtils.SO_EVENT_ID_DEFAULT)) {
                            if (i != f.biZ && i != f.bja && TextUtils.equals(str, f.this.chatMCastId)) {
                                f.this.bje = System.currentTimeMillis();
                                if (TbConfig.IM_LOG) {
                                    Log.d("im-debug", "receiveChatMsgTime= " + f.this.bje);
                                }
                                f.this.bjb = false;
                                f.this.Lv();
                            }
                            if (!f.this.bjf.contains(Long.valueOf(cVar.msgId))) {
                                if (i == f.biZ) {
                                    String str4 = "";
                                    String str5 = "";
                                    if (!TextUtils.isEmpty(cVar.bVb)) {
                                        try {
                                            JSONObject jSONObject3 = new JSONObject(cVar.bVb);
                                            str4 = jSONObject3.optString("msgType");
                                            if (TextUtils.isEmpty(str4)) {
                                                str4 = jSONObject3.optString("msg_type");
                                            }
                                        } catch (JSONException e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                    if (cVar.bVa != null) {
                                        try {
                                            str5 = new JSONObject(new JSONObject(cVar.bVa.bVo).optString("content")).optString("content_type");
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
                                            if (aVar.Mo() != null && (!TextUtils.isEmpty(aVar.Mo().name_show) || !TextUtils.isEmpty(aVar.Mo().userName))) {
                                                arrayList.add(aVar);
                                            }
                                            i2 = i3 + 1;
                                        }
                                    } else {
                                        arrayList.addAll(a2);
                                    }
                                    if (i == 0 && cVar.bVa != null && !TextUtils.isEmpty(cVar.bVa.bVo)) {
                                        if (f.this.bjk == null) {
                                            f.this.bjk = new ArrayList();
                                        }
                                        f.this.bjk.add(cVar.bVa.bVo);
                                    }
                                    if (!TextUtils.equals(cVar.type, TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY)) {
                                        if (TextUtils.equals(str2, SoUtils.SO_EVENT_ID_DEFAULT)) {
                                            f.this.bjd += a2.size();
                                            if (f.this.aKv != null && f.this.aKv.isHost) {
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
                                                                if (aVar2.Mo() != null) {
                                                                    jSONObject4.put("sender_uk", EncryptionHelper.getEncryptionUserId(aVar2.Mo().userId));
                                                                }
                                                                jSONObject4.put("rec_time", System.currentTimeMillis());
                                                            } catch (JSONException e6) {
                                                                BdLog.e(e6);
                                                            }
                                                            UbcStatisticManager.getInstance().debugException(new UbcDebugItem(UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.DebugContentValue.GIFT, jSONObject4), "gift_rec");
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            f.this.bjc += a2.size();
                                        }
                                    }
                                    if (f.this.bjf.size() > 200) {
                                        f.this.bjf.removeFirst();
                                    }
                                    f.this.bjf.add(Long.valueOf(cVar.msgId));
                                    if (!TextUtils.equals(str, f.this.chatMCastId) || cVar.msgId <= f.this.bjg) {
                                        if (TextUtils.equals(str, f.this.chatMCastId) && cVar.msgId > f.this.bjh) {
                                            f.this.bjh = cVar.msgId;
                                        }
                                    } else {
                                        f.this.bjg = cVar.msgId;
                                    }
                                }
                            } else if (TbConfig.IM_LOG) {
                                Log.d("im-debug", "remove repeat msg msgid=" + cVar.msgId + " type=" + cVar.type);
                            }
                        } else {
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ IM消息 接收: 如果是普通消息同时castId为空，过滤礼物消息");
                            }
                            f.this.hI(str);
                        }
                    }
                }
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收: 消息分发 Size: " + arrayList.size() + "  History: " + (i == f.biZ));
                }
                if (f.this.bjk != null && !f.this.bjk.isEmpty()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913251, f.this.bjk));
                }
                if (arrayList.size() > 0) {
                    aLAGroupHttpResponseMessage.bZ(i == f.biZ);
                    aLAGroupHttpResponseMessage.W(arrayList);
                    aLAGroupHttpResponseMessage.setGroupId(f.this.aKv.mLiveInfo.getGroupID());
                    MessageManager.getInstance().dispatchResponsedMessage(aLAGroupHttpResponseMessage);
                    if (f.this.bjk != null && !f.this.bjk.isEmpty()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913107, f.this.bjk));
                    }
                }
            }
        }
    };
    private CustomMessageListener bjy = new CustomMessageListener(2913108) { // from class: com.baidu.live.im.f.7
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
                f.this.LC();
            }
        }
    };
    private CustomMessageListener bjz = new CustomMessageListener(2913190) { // from class: com.baidu.live.im.f.8
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
                    f.this.LC();
                } else {
                    SafeHandler.getInst().removeCallbacks(f.this.bjA);
                    SafeHandler.getInst().postDelayed(f.this.bjA, 1000L);
                }
            }
            if (TbadkCoreApplication.getInst().isTieba()) {
                if (LoginManager.getInstance(TbadkCoreApplication.getInst().getContext()).isIMLogined()) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ IM消息 贴吧直播间切前台监听 -- IM 没断，直接 join");
                    }
                    f.this.LC();
                    return;
                }
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 贴吧直播间切前台监听 -- IM 断");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913191, null));
            }
        }
    };
    private Runnable bjA = new Runnable() { // from class: com.baidu.live.im.f.9
        @Override // java.lang.Runnable
        public void run() {
            f.this.LC();
        }
    };
    private Runnable bjB = new Runnable() { // from class: com.baidu.live.im.f.10
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (TbConfig.IM_LOG) {
                Log.d("im-debug", "imExceptionCheckRunnable: " + (currentTimeMillis - f.this.bje));
            }
            if (currentTimeMillis - f.this.bje >= 18000) {
                if (!f.this.bjb) {
                    f.this.bjb = true;
                    f.this.Ly();
                }
                if (f.this.aKv != null && f.this.aKv.isHost) {
                    f.this.Lw();
                    f.this.Lx();
                }
            } else if (f.this.bjb) {
                f.this.bjb = false;
                f.this.Ly();
            }
            f.this.Lv();
        }
    };
    private CustomMessageTask.CustomRunnable bjC = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.im.f.11
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            String str;
            if (f.this.aKv != null && f.this.aKv.mLiveSdkInfo != null && f.this.aKv.mLiveSdkInfo.mCastIds != null) {
                str = f.this.aKv.mLiveSdkInfo.mCastIds.ensureMCastId;
            } else {
                str = "0";
            }
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID, str);
        }
    };

    public static f Lu() {
        if (biY == null) {
            synchronized (f.class) {
                if (biY == null) {
                    biY = new f();
                }
            }
        }
        return biY;
    }

    private f() {
    }

    public void av(Context context) {
        this.mContext = context;
        MessageManager.getInstance().unRegisterListener(this.bjn);
        MessageManager.getInstance().registerListener(this.bjn);
        MessageManager.getInstance().removeMessageRule(this.bjs);
        MessageManager.getInstance().addMessageRule(this.bjs);
        MessageManager.getInstance().unRegisterListener(this.bjt);
        MessageManager.getInstance().registerListener(this.bjt);
        MessageManager.getInstance().unRegisterListener(this.bjy);
        MessageManager.getInstance().registerListener(this.bjy);
        MessageManager.getInstance().unRegisterListener(this.bjz);
        MessageManager.getInstance().registerListener(this.bjz);
        new CustomMessageTask(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID, this.bjC).setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID);
    }

    public void Ce() {
        SafeHandler.getInst().removeCallbacks(this.bjA);
        SafeHandler.getInst().removeCallbacks(this.bjB);
        com.baidu.h.b.a.aJ(this.mContext).Yl().LA();
        this.bjm = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lv() {
        SafeHandler.getInst().removeCallbacks(this.bjB);
        if (this.aKv != null && this.aKv.mLiveInfo != null) {
            SafeHandler.getInst().postDelayed(this.bjB, 18000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lw() {
        int i;
        String str;
        String str2;
        if (this.aKv != null) {
            if (this.aKv.mLiveSdkInfo != null && this.aKv.mLiveSdkInfo.mCastIds != null) {
                this.chatMCastId = this.aKv.mLiveSdkInfo.mCastIds.chatMCastId;
                String str3 = this.aKv.mLiveSdkInfo.mCastIds.chat_msg_hls_url;
                this.ensureMCastId = this.aKv.mLiveSdkInfo.mCastIds.ensureMCastId;
                String str4 = this.aKv.mLiveSdkInfo.mCastIds.reliable_msg_hls_url;
                i = JavaTypesHelper.toInt(this.aKv.mLiveSdkInfo.mCastIds.msg_hls_pull_internal_in_second, 5) * 1000;
                str = str4;
                str2 = str3;
            } else if (this.aKv.mLiveInfo == null || this.aKv.mLiveInfo.mCastIds == null) {
                i = 5000;
                str = "";
                str2 = "";
            } else {
                this.chatMCastId = this.aKv.mLiveInfo.mCastIds.chatMCastId;
                String str5 = this.aKv.mLiveInfo.mCastIds.chat_msg_hls_url;
                this.ensureMCastId = this.aKv.mLiveInfo.mCastIds.ensureMCastId;
                String str6 = this.aKv.mLiveInfo.mCastIds.reliable_msg_hls_url;
                i = JavaTypesHelper.toInt(this.aKv.mLiveInfo.mCastIds.msg_hls_pull_internal_in_second, 5) * 1000;
                str = str6;
                str2 = str5;
            }
            a(this.chatMCastId, str2, i, false);
            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", this.chatMCastId, this.chatMCastId, 0, "", "", "");
            a(this.ensureMCastId, str, i, this.aKv.isHost);
            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", this.chatMCastId, this.ensureMCastId, 0, "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lx() {
        if (TbConfig.IM_LOG) {
            Log.d("im-debug", "start fetch im chat castid=" + this.chatMCastId + "lastmsgid=" + this.bjg);
        }
        int i = 25;
        if (this.bjg == 0) {
            i = -25;
        }
        BIMManager.fetchMsgRequest(this.mContext, AccountManager.getAppid(this.mContext), AccountManager.getUK(this.mContext), 4, JavaTypesHelper.toLong(this.chatMCastId, -1L), this.bjg, Long.MAX_VALUE, i, 1, this.bjw);
        int i2 = 25;
        if (this.bjh == 0) {
            i2 = -25;
        }
        if (TbConfig.IM_LOG) {
            Log.d("im-debug", "start fetch im ensure castid=" + this.ensureMCastId + " lastmsgid=" + this.bjh);
        }
        BIMManager.fetchMsgRequest(this.mContext, AccountManager.getAppid(this.mContext), AccountManager.getUK(this.mContext), 4, JavaTypesHelper.toLong(this.ensureMCastId, -1L), this.bjh, Long.MAX_VALUE, i2, 1, this.bjw, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ly() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME), Long.class);
        if (runTask == null) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("im_state", this.bjb ? 0 : 1);
            jSONObject.put("im_chat_mcast_id", this.chatMCastId);
            jSONObject.put("im_ensure_mcast_id", this.ensureMCastId);
            jSONObject.put("im_live_info_time", j);
            jSONObject.put("im_last_msg_time", this.bje);
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
            com.baidu.h.b.a.aJ(this.mContext).Yl().a(str, str2, i, new com.baidu.h.a.b.b() { // from class: com.baidu.live.im.f.2
                @Override // com.baidu.h.a.b.b
                public void onResult(int i2, long j, long j2) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ enterRoom onResult i:" + i2 + ", l:" + j + ", l1:" + j2);
                    }
                    if (f.this.aKv == null || f.this.chatMCastId == null || f.this.ensureMCastId == null) {
                        com.baidu.h.b.a.aJ(f.this.mContext).Yl().jf(String.valueOf(j));
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.chatMCastId, String.valueOf(j), -1, "", "", "");
                        return;
                    }
                    long j3 = JavaTypesHelper.toLong(f.this.chatMCastId, -1L);
                    long j4 = JavaTypesHelper.toLong(f.this.ensureMCastId, -1L);
                    if (j3 != j && j4 != j) {
                        com.baidu.h.b.a.aJ(f.this.mContext).Yl().jf(String.valueOf(j));
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.chatMCastId, String.valueOf(j), -1, "", "", "");
                        if (TbConfig.IM_LOG) {
                            Log.e("imlog", "BDIM enterRoom wrong then exit end:" + j);
                            return;
                        }
                        return;
                    }
                    if (j3 == j) {
                        f.this.bjc = 0;
                    } else {
                        f.this.bjd = 0;
                    }
                    if (i2 != 0) {
                        f.this.b(j, i2, j3 == j ? f.this.bji : f.this.bjj);
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
                            if (f.this.bji < 6) {
                                f.this.a(str, str2, i, z);
                                f.this.bji++;
                                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_MSG_FAIL_TO_REJOIN, f.this.chatMCastId, str, -1, "", "", "");
                                return;
                            }
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.chatMCastId, str, -1, "", "", "");
                        } else if (f.this.bjj < 6) {
                            f.this.a(str, str2, i, z);
                            f.this.bjj++;
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_GIFT_FAIL_TO_REJOIN, f.this.chatMCastId, str, -1, "", "", "");
                        } else {
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.chatMCastId, str, -1, "", "", "");
                        }
                    } else if (j3 == j) {
                        f.this.bji = 0;
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", f.this.chatMCastId, str, 0, "", "", "");
                        if (TbConfig.IM_LOG) {
                            Log.i("imlog", "@.@ enterRoom onResult JOIN Msg成功:" + j3);
                        }
                        if ((!f.this.aKv.isHost || (f.this.aKv.isHost && f.this.aKv.aJD)) && f.this.bjm != j3) {
                            f.this.bjm = j3;
                            long j5 = JavaTypesHelper.toLong(str, -1L);
                            BIMManager.fetchMsgRequest(f.this.mContext, AccountManager.getAppid(f.this.mContext), AccountManager.getUK(f.this.mContext), 4, j5, 0L, Long.MAX_VALUE, -25, 1, f.this.bjv);
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ enterRoom fetchMsgidByMsgid:   " + j5);
                            }
                        }
                    } else {
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", f.this.chatMCastId, str, 0, "", "", "");
                        if (TbConfig.IM_LOG) {
                            Log.i("imlog", "@.@ enterRoom onResult JOIN Gift成功:" + j4);
                        }
                        f.this.bjj = 0;
                    }
                }
            }, z);
            Lz();
            hH(str);
            if (TbConfig.IM_LOG) {
                Log.i("imlog", "@.@ enterRoom registerMsgReceiveListener:" + z + ", mCastId: " + str);
            }
        }
    }

    private void Lz() {
        MessageManager.getInstance().unRegisterListener(this.aVt);
        MessageManager.getInstance().registerListener(this.aVt);
        MessageManager.getInstance().unRegisterListener(this.bjo);
        MessageManager.getInstance().registerListener(this.bjo);
        MessageManager.getInstance().unRegisterListener(this.bjp);
        MessageManager.getInstance().registerListener(this.bjp);
        MessageManager.getInstance().unRegisterListener(this.bjq);
        MessageManager.getInstance().registerListener(this.bjq);
        MessageManager.getInstance().removeMessageRule(this.bjr);
        MessageManager.getInstance().addMessageRule(this.bjr);
        MessageManager.getInstance().removeMessageRule(this.bju);
        MessageManager.getInstance().addMessageRule(this.bju);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LA() {
        SafeHandler.getInst().removeCallbacks(this.bjA);
        SafeHandler.getInst().removeCallbacks(this.bjB);
        if (this.aKv != null && this.aKv.mLiveSdkInfo != null && this.aKv.mLiveSdkInfo.mCastIds != null) {
            String str = this.aKv.mLiveSdkInfo.mCastIds.chatMCastId;
            String str2 = this.aKv.mLiveSdkInfo.mCastIds.ensureMCastId;
            com.baidu.h.b.a.aJ(this.mContext).Yl().jf(str);
            com.baidu.h.b.a.aJ(this.mContext).Yl().jf(str2);
            LD();
        }
        this.bjc = 0;
        this.bjd = 0;
        this.bjm = 0L;
        this.aKv = null;
        this.chatMCastId = null;
        this.ensureMCastId = null;
        this.bji = 0;
        this.bjj = 0;
        if (this.bjk != null) {
            this.bjk.clear();
            this.bjk = null;
        }
        if (this.bjl != null) {
            this.bjl.clear();
            this.bjl = null;
        }
        this.bjf.clear();
        this.bjg = 0L;
        this.bjg = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LB() {
        MessageManager.getInstance().unRegisterListener(this.bjo);
        MessageManager.getInstance().unRegisterListener(this.bjp);
        MessageManager.getInstance().unRegisterListener(this.bjq);
        MessageManager.getInstance().unRegisterListener(this.aVt);
        MessageManager.getInstance().removeMessageRule(this.bjr);
        MessageManager.getInstance().removeMessageRule(this.bju);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(List<AlaLiveMarkData> list) {
        if (list != null && !list.isEmpty()) {
            if (this.bjl == null) {
                this.bjl = new ArrayList();
            }
            this.bjl.clear();
            this.bjl.addAll(list);
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
        final String str2 = (this.aKv == null || this.aKv.mLiveSdkInfo == null || this.aKv.mLiveSdkInfo.mCastIds == null) ? null : this.aKv.mLiveSdkInfo.mCastIds.chatMCastId;
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.h.a.b.a.e eVar = new com.baidu.h.a.b.a.e();
            eVar.msg = content;
            eVar.aSP = str2;
            if (this.aKv != null && this.aKv.aJr != null) {
                eVar.name = this.aKv.aJr.userName;
                eVar.portrait = this.aKv.aJr.portrait;
            }
            a aVar2 = new a();
            if (this.aKv != null) {
                if (this.aKv.isHost) {
                    alaLiveUserInfoData = this.aKv.aIV;
                } else {
                    alaLiveUserInfoData = this.aKv.aJr;
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
                    aVar3.aHB = alaLiveUserInfoData.followCount;
                    aVar3.aHA = alaLiveUserInfoData.fansCount;
                    aVar3.aHE = alaLiveUserInfoData.isAdmin == 1;
                    aVar3.aHD = alaLiveUserInfoData.isOfficial == 1;
                    aVar3.level_id = alaLiveUserInfoData.levelId;
                    aVar3.aHG = this.bjl;
                    aVar3.sex = alaLiveUserInfoData.sex;
                    aVar3.extraUserInfo = alaLiveUserInfoData.extraUserInfo;
                    aVar2.e(aVar3);
                    aVar2.setContent(content);
                    aVar2.setMsgType(aVar.MC());
                    aVar2.eL(aVar.Ms());
                    aVar2.hL(aVar.Mt());
                    aVar2.a(aVar.Mu());
                    aVar2.l(aVar.Mv());
                    aVar2.setUserId(alaLiveUserInfoData.userId);
                    aVar2.hE(String.valueOf(this.aKv.mLiveInfo.user_id));
                    aVar2.setBornTime(System.currentTimeMillis());
                    str = aVar2.KZ();
                }
            }
            eVar.bVb = str;
            com.baidu.h.a.b.a.f fVar = new com.baidu.h.a.b.a.f() { // from class: com.baidu.live.im.f.3
                @Override // com.baidu.h.a.b.a.f
                public void a(String str3, int i, List<com.baidu.h.a.b.a.c> list) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ IM消息 onSendSuccess s:" + str3 + ", i:" + i);
                    }
                    if (f.this.aKv != null && f.this.chatMCastId != null && f.this.ensureMCastId != null) {
                        if (TextUtils.equals(str3, f.this.chatMCastId) || TextUtils.equals(str3, f.this.ensureMCastId)) {
                            ALAGroupCommitHttpResponsedMessage aLAGroupCommitHttpResponsedMessage = new ALAGroupCommitHttpResponsedMessage();
                            aLAGroupCommitHttpResponsedMessage.setStatusCode(200, null);
                            if (f.this.aKv.mLiveInfo != null) {
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
            com.baidu.h.b.a.aJ(this.mContext).Yl().a(str2, eVar, fVar);
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
            alaStaticItem.addParams("live_id", this.aKv.mLiveInfo.live_id + "");
            alaStaticItem.addParams("room_id", this.aKv.mLiveInfo.room_id + "");
            alaStaticItem.addParams("feed_id", this.aKv.mLiveInfo.feed_id + "");
            alaStaticItem.addParams("other_params", aVar.MD());
            if (aVar.MC() == 126) {
                alaStaticItem.addParams("gifts_value", String.valueOf(aVar.ME()));
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SUC_SEND_NEWS);
            alaStaticItem2.addParams("live_id", this.aKv.mLiveInfo.live_id + "");
            alaStaticItem2.addParams("room_id", this.aKv.mLiveInfo.room_id + "");
            alaStaticItem2.addParams("feed_id", this.aKv.mLiveInfo.feed_id + "");
            alaStaticItem2.addParams("other_params", aVar.MD());
            if (aVar.MC() == 126) {
                alaStaticItem2.addParams("gifts_value", String.valueOf(aVar.ME()));
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem2);
        }
        if (!aVar.MG()) {
            if (aVar.MC() == 126) {
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "msg_send").setContentExt("barrage", null, null));
            } else if (aVar.MF()) {
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
            if (aVar.MC() == 126) {
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "msg_send").setContentExt("barrage", null, jSONObject));
            } else if (aVar.MF()) {
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
                    if (!TextUtils.isEmpty(cVar.aSP)) {
                        str = cVar.aSP;
                    } else if (cVar.bVa != null && cVar.bVa.bVo != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(cVar.bVa.bVo);
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
            if (!arrayList.isEmpty() && this.aKv != null) {
                if (((com.baidu.live.im.data.a) arrayList.get(0)).getMsgType() == 126) {
                    com.baidu.live.n.a.b(this.aKv.mLiveInfo.live_id, 6);
                } else {
                    com.baidu.live.n.a.b(this.aKv.mLiveInfo.live_id, 2);
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
                this.bjx.e(z ? biZ : bja, arrayList2);
            }
        }
    }

    private void hH(String str) {
        com.baidu.h.b.a.aJ(this.mContext).Yl().a(str, this.bjx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hI(String str) {
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
    public void LC() {
        if (this.aKv != null && this.aKv.mLiveSdkInfo != null && this.aKv.mLiveSdkInfo.mCastIds != null) {
            this.bji = 0;
            this.bjj = 0;
            this.chatMCastId = this.aKv.mLiveSdkInfo.mCastIds.chatMCastId;
            String str = this.aKv.mLiveSdkInfo.mCastIds.chat_msg_hls_url;
            this.ensureMCastId = this.aKv.mLiveSdkInfo.mCastIds.ensureMCastId;
            String str2 = this.aKv.mLiveSdkInfo.mCastIds.reliable_msg_hls_url;
            int i = JavaTypesHelper.toInt(this.aKv.mLiveSdkInfo.mCastIds.msg_hls_pull_internal_in_second, 5) * 1000;
            a(this.chatMCastId, str, i, false);
            a(this.ensureMCastId, str2, i, this.aKv.isHost);
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

    private void LD() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("im_chat_mcast_id", this.chatMCastId);
            jSONObject.put("im_ensure_mcast_id", this.ensureMCastId);
            jSONObject.put("im_chat_mcast_count", this.bjc);
            jSONObject.put("im_ensure_mcast_count", this.bjd);
            a(jSONObject, (JSONObject) null, "1529", UbcStatConstant.ContentType.UBC_TYPE_IM_LEAVE, (String) null);
        } catch (JSONException e) {
        }
    }

    private JSONObject P(JSONObject jSONObject) {
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
        if (this.aKv != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            if (TbConfig.IM_LOG) {
                Log.i("imUbclog", "Json: " + jSONObject.toString() + "  type: " + str2 + " isHost: " + this.aKv.isHost);
            }
            JSONObject jSONObject3 = new JSONObject();
            P(jSONObject);
            try {
                jSONObject3.put("im", jSONObject);
                if (jSONObject2 != null) {
                    jSONObject3.put(BdStatsConstant.StatsType.ERROR, jSONObject2);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(str, str2, this.aKv.isHost ? UbcStatConstant.Page.AUTHOR_LIVE_ROOM : "liveroom", str3);
            ubcStatisticItem.setContentExt(jSONObject3);
            UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
        }
    }
}
