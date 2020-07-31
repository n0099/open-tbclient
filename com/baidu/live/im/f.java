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
import com.baidu.live.data.q;
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
    private static volatile f aUN = null;
    private static int aUO = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private static int aUP = 2147483646;
    private boolean aUQ;
    private int aUR;
    private int aUS;
    private List<String> aUZ;
    private List<AlaLiveMarkData> aVa;
    private long aVb;
    private String ayO;
    private String ayP;
    private q azr;
    private Context mContext;
    private long aUT = 0;
    private LinkedList<Long> aUU = new LinkedList<>();
    private long aUV = 0;
    private long aUW = 0;
    private int aUX = 0;
    private int aUY = 0;
    private CustomMessageListener aVc = new CustomMessageListener(2913081) { // from class: com.baidu.live.im.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            q qVar;
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0) {
                f.this.aUT = 0L;
                if (com.baidu.d.b.a.aA(f.this.mContext).Li() == null || !(customResponsedMessage.getData() instanceof q) || (qVar = (q) customResponsedMessage.getData()) == null) {
                    return;
                }
                if ((qVar.mLiveSdkInfo != null && qVar.mLiveSdkInfo.mCastIds != null) || (qVar.mLiveInfo != null && qVar.mLiveInfo.mCastIds != null)) {
                    if (qVar.mLiveInfo == null || qVar.mLiveInfo.live_status != 2) {
                        if (f.this.azr != null && f.this.azr.mLiveInfo != null && qVar != null && qVar.mLiveInfo != null && qVar.mLiveInfo.live_id != f.this.azr.mLiveInfo.live_id) {
                            f.this.aUU.clear();
                            f.this.aUV = 0L;
                            f.this.aUW = 0L;
                        }
                        f.this.azr = qVar;
                        f.this.L(f.this.azr.aza);
                        f.this.Dp();
                        f.this.Do();
                    }
                }
            }
        }
    };
    private CustomMessageListener aVd = new CustomMessageListener(2913082) { // from class: com.baidu.live.im.f.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof q)) {
                q qVar = (q) customResponsedMessage.getData();
                if (f.this.azr != null && f.this.azr.mLiveInfo != null && qVar != null && qVar.mLiveInfo != null && qVar.mLiveInfo.live_id != f.this.azr.mLiveInfo.live_id) {
                    f.this.aUU.clear();
                    f.this.aUV = 0L;
                    f.this.aUW = 0L;
                }
                f.this.azr = qVar;
                f.this.L(f.this.azr.aza);
            }
        }
    };
    private CustomMessageListener aVe = new CustomMessageListener(2913118) { // from class: com.baidu.live.im.f.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof q)) {
                f.this.L(((q) customResponsedMessage.getData()).aza);
            }
        }
    };
    private HttpRule aVf = new HttpRule(1021013) { // from class: com.baidu.live.im.f.13
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
    private HttpRule aVg = new HttpRule(1021012) { // from class: com.baidu.live.im.f.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            return null;
        }
    };
    CustomMessageListener aVh = new CustomMessageListener(2913084) { // from class: com.baidu.live.im.f.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.Dn();
        }
    };
    CustomMessageListener aIJ = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.im.f.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.Dt();
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.im.f.16.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.Du();
                }
            });
        }
    };
    private HttpRule aVi = new HttpRule(1021006) { // from class: com.baidu.live.im.f.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            f.this.Dt();
            if (f.this.azr != null && f.this.azr.mLiveSdkInfo != null && f.this.azr.mLiveSdkInfo.mCastIds != null) {
                String str = f.this.azr.mLiveSdkInfo.mCastIds.ayO;
                String str2 = f.this.azr.mLiveSdkInfo.mCastIds.ayP;
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str, -1, "", "", "");
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str2, -1, "", "", "");
            }
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.im.f.17.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.Du();
                }
            });
            return httpMessage;
        }
    };
    private IFetchMsgByIdListener aVj = new IFetchMsgByIdListener() { // from class: com.baidu.live.im.f.3
        @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
        public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList) {
            if (String.valueOf(j).equals(f.this.ayO) || String.valueOf(j).equals(f.this.ayP)) {
                if (TbConfig.IM_LOG) {
                    Log.d("im-debug", "fetch history msg received size=" + arrayList.size());
                }
                f.this.a(i, arrayList, true);
            } else if (TbConfig.IM_LOG) {
                Log.d("im-debug", "onFetchMsgByIdResult 非当前直播间 ：l: " + j);
            }
        }
    };
    private IFetchMsgByIdListener aVk = new IFetchMsgByIdListener() { // from class: com.baidu.live.im.f.4
        @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
        public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList) {
            if (String.valueOf(j).equals(f.this.ayO) || String.valueOf(j).equals(f.this.ayP)) {
                if (TbConfig.IM_LOG) {
                    Log.d("im-debug", "fetch msg received size=" + arrayList.size());
                }
                f.this.a(i, arrayList, false);
            } else if (TbConfig.IM_LOG) {
                Log.d("im-debug", "onFetchMsgByIdResult 非当前直播间 ：l: " + j);
            }
        }
    };
    private com.baidu.d.a.b.a.d aVl = new com.baidu.d.a.b.a.d() { // from class: com.baidu.live.im.f.5
        @Override // com.baidu.d.a.b.a.d
        public void e(int i, List<com.baidu.d.a.b.a.c> list) {
            String str;
            String str2;
            JSONObject jSONObject;
            if (f.this.azr == null || f.this.ayO == null || f.this.ayP == null || f.this.azr.mLiveInfo == null) {
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收: 直播间已销毁");
                }
            } else if (i != 0 && i != f.aUO && i != f.aUP) {
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收: 非有效消息");
                }
            } else {
                ALAGroupHttpResponseMessage aLAGroupHttpResponseMessage = new ALAGroupHttpResponseMessage();
                ArrayList arrayList = new ArrayList();
                if (f.this.aUZ != null) {
                    f.this.aUZ.clear();
                }
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收:");
                }
                for (com.baidu.d.a.b.a.c cVar : list) {
                    if (cVar == null) {
                        if (TbConfig.IM_LOG) {
                            Log.i("imlog", "@.@ IM消息 接收: messageBean 为空");
                        }
                    } else {
                        String str3 = "";
                        if (!TextUtils.isEmpty(cVar.bqN)) {
                            str = cVar.bqN;
                            str2 = "";
                        } else {
                            if (cVar.brc != null && cVar.brc.brq != null) {
                                try {
                                    JSONObject jSONObject2 = new JSONObject(cVar.brc.brq);
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
                        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, f.this.ayO) && !TextUtils.equals(str, f.this.ayP)) {
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ IM消息 接收  非当前直播间的消息，过滤 castId：" + str + "   chatMCastId：" + f.this.ayO + "   ensureMCastId: " + f.this.ayP);
                            }
                            f.this.fu(str);
                        } else if (TextUtils.equals(cVar.type, "0") && TextUtils.isEmpty(str)) {
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ IM消息 接收: 如果是普通消息同时castId为空，过滤");
                            }
                            f.this.fu(str);
                        } else if (!TextUtils.isEmpty(str) || !TextUtils.equals(str2, SoUtils.SO_EVENT_ID_DEFAULT)) {
                            if (i != f.aUO && i != f.aUP && TextUtils.equals(str, f.this.ayO)) {
                                f.this.aUT = System.currentTimeMillis();
                                if (TbConfig.IM_LOG) {
                                    Log.d("im-debug", "receiveChatMsgTime= " + f.this.aUT);
                                }
                                f.this.aUQ = false;
                                f.this.Do();
                            }
                            if (!f.this.aUU.contains(Long.valueOf(cVar.msgId))) {
                                if (i == f.aUO) {
                                    String str4 = "";
                                    if (!TextUtils.isEmpty(cVar.brd)) {
                                        try {
                                            JSONObject jSONObject3 = new JSONObject(cVar.brd);
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
                                            if (aVar.Eh() != null && (!TextUtils.isEmpty(aVar.Eh().name_show) || !TextUtils.isEmpty(aVar.Eh().userName))) {
                                                arrayList.add(aVar);
                                            }
                                            i2 = i3 + 1;
                                        }
                                    } else {
                                        arrayList.addAll(a);
                                    }
                                    if (i == 0 && cVar.brc != null && !TextUtils.isEmpty(cVar.brc.brq)) {
                                        if (f.this.aUZ == null) {
                                            f.this.aUZ = new ArrayList();
                                        }
                                        f.this.aUZ.add(cVar.brc.brq);
                                    }
                                    if (!TextUtils.equals(cVar.type, TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY)) {
                                        if (TextUtils.equals(str2, SoUtils.SO_EVENT_ID_DEFAULT)) {
                                            f.this.aUS += a.size();
                                            if (f.this.azr != null && f.this.azr.isHost) {
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
                                                                if (aVar2.Eh() != null) {
                                                                    jSONObject4.put("sender_uk", EncryptionHelper.getEncryptionUserId(aVar2.Eh().userId));
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
                                            f.this.aUR += a.size();
                                        }
                                    }
                                    if (f.this.aUU.size() > 200) {
                                        f.this.aUU.removeFirst();
                                    }
                                    f.this.aUU.add(Long.valueOf(cVar.msgId));
                                    if (!TextUtils.equals(str, f.this.ayO) || cVar.msgId <= f.this.aUV) {
                                        if (TextUtils.equals(str, f.this.ayO) && cVar.msgId > f.this.aUW) {
                                            f.this.aUW = cVar.msgId;
                                        }
                                    } else {
                                        f.this.aUV = cVar.msgId;
                                    }
                                }
                            } else if (TbConfig.IM_LOG) {
                                Log.d("im-debug", "remove repeat msg msgid=" + cVar.msgId + " type=" + cVar.type);
                            }
                        } else {
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ IM消息 接收: 如果是普通消息同时castId为空，过滤礼物消息");
                            }
                            f.this.fu(str);
                        }
                    }
                }
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收: 消息分发 Size: " + arrayList.size() + "  History: " + (i == f.aUO));
                }
                if (arrayList.size() > 0) {
                    aLAGroupHttpResponseMessage.bL(i == f.aUO);
                    aLAGroupHttpResponseMessage.P(arrayList);
                    aLAGroupHttpResponseMessage.setGroupId(f.this.azr.mLiveInfo.getGroupID());
                    MessageManager.getInstance().dispatchResponsedMessage(aLAGroupHttpResponseMessage);
                    if (f.this.aUZ != null && !f.this.aUZ.isEmpty()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913107, f.this.aUZ));
                    }
                }
            }
        }
    };
    private CustomMessageListener aVm = new CustomMessageListener(2913108) { // from class: com.baidu.live.im.f.6
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
                f.this.Dv();
            }
        }
    };
    private CustomMessageListener aVn = new CustomMessageListener(2913190) { // from class: com.baidu.live.im.f.7
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
                    f.this.Dv();
                } else {
                    SafeHandler.getInst().removeCallbacks(f.this.aVo);
                    SafeHandler.getInst().postDelayed(f.this.aVo, 1000L);
                }
            }
            if (TbadkCoreApplication.getInst().isTieba()) {
                if (LoginManager.getInstance(TbadkCoreApplication.getInst().getContext()).isIMLogined()) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ IM消息 贴吧直播间切前台监听 -- IM 没断，直接 join");
                    }
                    f.this.Dv();
                    return;
                }
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 贴吧直播间切前台监听 -- IM 断");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913191, null));
            }
        }
    };
    private Runnable aVo = new Runnable() { // from class: com.baidu.live.im.f.8
        @Override // java.lang.Runnable
        public void run() {
            f.this.Dv();
        }
    };
    private Runnable aVp = new Runnable() { // from class: com.baidu.live.im.f.9
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (TbConfig.IM_LOG) {
                Log.d("im-debug", "imExceptionCheckRunnable: " + (currentTimeMillis - f.this.aUT));
            }
            if (currentTimeMillis - f.this.aUT >= 18000) {
                if (!f.this.aUQ) {
                    f.this.aUQ = true;
                    f.this.Dr();
                }
                if (f.this.azr != null && f.this.azr.isHost) {
                    f.this.Dp();
                    f.this.Dq();
                }
            } else if (f.this.aUQ) {
                f.this.aUQ = false;
                f.this.Dr();
            }
            f.this.Do();
        }
    };
    private CustomMessageTask.CustomRunnable aVq = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.im.f.10
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            String str;
            if (f.this.azr != null && f.this.azr.mLiveSdkInfo != null && f.this.azr.mLiveSdkInfo.mCastIds != null) {
                str = f.this.azr.mLiveSdkInfo.mCastIds.ayP;
            } else {
                str = "0";
            }
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID, str);
        }
    };

    public static f Dm() {
        if (aUN == null) {
            synchronized (f.class) {
                if (aUN == null) {
                    aUN = new f();
                }
            }
        }
        return aUN;
    }

    private f() {
    }

    public void ap(Context context) {
        this.mContext = context;
        MessageManager.getInstance().unRegisterListener(this.aVc);
        MessageManager.getInstance().registerListener(this.aVc);
        MessageManager.getInstance().removeMessageRule(this.aVg);
        MessageManager.getInstance().addMessageRule(this.aVg);
        MessageManager.getInstance().unRegisterListener(this.aVh);
        MessageManager.getInstance().registerListener(this.aVh);
        MessageManager.getInstance().unRegisterListener(this.aVm);
        MessageManager.getInstance().registerListener(this.aVm);
        MessageManager.getInstance().unRegisterListener(this.aVn);
        MessageManager.getInstance().registerListener(this.aVn);
        new CustomMessageTask(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID, this.aVq).setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID);
    }

    public void Dn() {
        SafeHandler.getInst().removeCallbacks(this.aVo);
        SafeHandler.getInst().removeCallbacks(this.aVp);
        com.baidu.d.b.a.aA(this.mContext).Li().Dt();
        this.aVb = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Do() {
        SafeHandler.getInst().removeCallbacks(this.aVp);
        if (this.azr != null && this.azr.mLiveInfo != null) {
            SafeHandler.getInst().postDelayed(this.aVp, 18000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dp() {
        int i;
        String str;
        String str2;
        if (this.azr != null) {
            if (this.azr.mLiveSdkInfo != null && this.azr.mLiveSdkInfo.mCastIds != null) {
                this.ayO = this.azr.mLiveSdkInfo.mCastIds.ayO;
                String str3 = this.azr.mLiveSdkInfo.mCastIds.ayQ;
                this.ayP = this.azr.mLiveSdkInfo.mCastIds.ayP;
                String str4 = this.azr.mLiveSdkInfo.mCastIds.ayS;
                i = JavaTypesHelper.toInt(this.azr.mLiveSdkInfo.mCastIds.ayT, 5) * 1000;
                str = str4;
                str2 = str3;
            } else if (this.azr.mLiveInfo == null || this.azr.mLiveInfo.mCastIds == null) {
                i = 5000;
                str = "";
                str2 = "";
            } else {
                this.ayO = this.azr.mLiveInfo.mCastIds.ayO;
                String str5 = this.azr.mLiveInfo.mCastIds.ayQ;
                this.ayP = this.azr.mLiveInfo.mCastIds.ayP;
                String str6 = this.azr.mLiveInfo.mCastIds.ayS;
                i = JavaTypesHelper.toInt(this.azr.mLiveInfo.mCastIds.ayT, 5) * 1000;
                str = str6;
                str2 = str5;
            }
            a(this.ayO, str2, i, false);
            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", this.ayO, this.ayO, 0, "", "", "");
            a(this.ayP, str, i, this.azr.isHost);
            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", this.ayO, this.ayP, 0, "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dq() {
        if (TbConfig.IM_LOG) {
            Log.d("im-debug", "start fetch im chat castid=" + this.ayO + "lastmsgid=" + this.aUV);
        }
        int i = 25;
        if (this.aUV == 0) {
            i = -25;
        }
        BIMManager.fetchMsgRequest(this.mContext, AccountManager.getAppid(this.mContext), AccountManager.getUK(this.mContext), 4, JavaTypesHelper.toLong(this.ayO, -1L), this.aUV, Long.MAX_VALUE, i, 1, this.aVk);
        int i2 = 25;
        if (this.aUW == 0) {
            i2 = -25;
        }
        if (TbConfig.IM_LOG) {
            Log.d("im-debug", "start fetch im ensure castid=" + this.ayP + " lastmsgid=" + this.aUW);
        }
        BIMManager.fetchMsgRequest(this.mContext, AccountManager.getAppid(this.mContext), AccountManager.getUK(this.mContext), 4, JavaTypesHelper.toLong(this.ayP, -1L), this.aUW, Long.MAX_VALUE, i2, 1, this.aVk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dr() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME), Long.class);
        if (runTask == null) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("im_state", this.aUQ ? 0 : 1);
            jSONObject.put("im_chat_mcast_id", this.ayO);
            jSONObject.put("im_ensure_mcast_id", this.ayP);
            jSONObject.put("im_live_info_time", j);
            jSONObject.put("im_last_msg_time", this.aUT);
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
            com.baidu.d.b.a.aA(this.mContext).Li().a(str, str2, i, new com.baidu.d.a.b.b() { // from class: com.baidu.live.im.f.18
                @Override // com.baidu.d.a.b.b
                public void onResult(int i2, long j, long j2) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ enterRoom onResult i:" + i2 + ", l:" + j + ", l1:" + j2);
                    }
                    if (f.this.azr == null || f.this.ayO == null || f.this.ayP == null) {
                        com.baidu.d.b.a.aA(f.this.mContext).Li().gg(String.valueOf(j));
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.ayO, String.valueOf(j), -1, "", "", "");
                        return;
                    }
                    long j3 = JavaTypesHelper.toLong(f.this.ayO, -1L);
                    long j4 = JavaTypesHelper.toLong(f.this.ayP, -1L);
                    if (j3 != j && j4 != j) {
                        com.baidu.d.b.a.aA(f.this.mContext).Li().gg(String.valueOf(j));
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.ayO, String.valueOf(j), -1, "", "", "");
                        if (TbConfig.IM_LOG) {
                            Log.e("imlog", "BDIM enterRoom wrong then exit end:" + j);
                            return;
                        }
                        return;
                    }
                    if (j3 == j) {
                        f.this.aUR = 0;
                    } else {
                        f.this.aUS = 0;
                    }
                    if (i2 != 0) {
                        f.this.a(j, i2, j3 == j ? f.this.aUX : f.this.aUY);
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
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_FAIL_IM_NOT_LOGIN, f.this.ayO, str, -1, "", "", "");
                    } else if (i2 == 1314 || i2 == 1306) {
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_MSG_ENTER_IM_FAIL, f.this.ayO, str, -1, String.valueOf(i2), "", "");
                    } else if (i2 != 0) {
                        if (j3 == j) {
                            if (f.this.aUX < 6) {
                                f.this.a(str, str2, i, z);
                                f.this.aUX++;
                                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_MSG_FAIL_TO_REJOIN, f.this.ayO, str, -1, "", "", "");
                                return;
                            }
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.ayO, str, -1, "", "", "");
                        } else if (f.this.aUY < 6) {
                            f.this.a(str, str2, i, z);
                            f.this.aUY++;
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_GIFT_FAIL_TO_REJOIN, f.this.ayO, str, -1, "", "", "");
                        } else {
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.ayO, str, -1, "", "", "");
                        }
                    } else if (j3 == j) {
                        f.this.aUX = 0;
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", f.this.ayO, str, 0, "", "", "");
                        if (TbConfig.IM_LOG) {
                            Log.i("imlog", "@.@ enterRoom onResult JOIN Msg成功:" + j3);
                        }
                        if ((!f.this.azr.isHost || (f.this.azr.isHost && f.this.azr.azd)) && f.this.aVb != j3) {
                            f.this.aVb = j3;
                            long j5 = JavaTypesHelper.toLong(str, -1L);
                            BIMManager.fetchMsgRequest(f.this.mContext, AccountManager.getAppid(f.this.mContext), AccountManager.getUK(f.this.mContext), 4, j5, 0L, Long.MAX_VALUE, -25, 1, f.this.aVj);
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ enterRoom fetchMsgidByMsgid:   " + j5);
                            }
                        }
                    } else {
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", f.this.ayO, str, 0, "", "", "");
                        if (TbConfig.IM_LOG) {
                            Log.i("imlog", "@.@ enterRoom onResult JOIN Gift成功:" + j4);
                        }
                        f.this.aUY = 0;
                    }
                }
            }, z);
            Ds();
            ft(str);
            if (TbConfig.IM_LOG) {
                Log.i("imlog", "@.@ enterRoom registerMsgReceiveListener:" + z + ", mCastId: " + str);
            }
        }
    }

    private void Ds() {
        MessageManager.getInstance().unRegisterListener(this.aIJ);
        MessageManager.getInstance().registerListener(this.aIJ);
        MessageManager.getInstance().unRegisterListener(this.aVd);
        MessageManager.getInstance().registerListener(this.aVd);
        MessageManager.getInstance().unRegisterListener(this.aVe);
        MessageManager.getInstance().registerListener(this.aVe);
        MessageManager.getInstance().removeMessageRule(this.aVf);
        MessageManager.getInstance().addMessageRule(this.aVf);
        MessageManager.getInstance().removeMessageRule(this.aVi);
        MessageManager.getInstance().addMessageRule(this.aVi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dt() {
        SafeHandler.getInst().removeCallbacks(this.aVo);
        SafeHandler.getInst().removeCallbacks(this.aVp);
        if (this.azr != null && this.azr.mLiveSdkInfo != null && this.azr.mLiveSdkInfo.mCastIds != null) {
            String str = this.azr.mLiveSdkInfo.mCastIds.ayO;
            String str2 = this.azr.mLiveSdkInfo.mCastIds.ayP;
            com.baidu.d.b.a.aA(this.mContext).Li().gg(str);
            com.baidu.d.b.a.aA(this.mContext).Li().gg(str2);
            Dw();
        }
        this.aUR = 0;
        this.aUS = 0;
        this.aVb = 0L;
        this.azr = null;
        this.ayO = null;
        this.ayP = null;
        this.aUX = 0;
        this.aUY = 0;
        if (this.aUZ != null) {
            this.aUZ.clear();
            this.aUZ = null;
        }
        if (this.aVa != null) {
            this.aVa.clear();
            this.aVa = null;
        }
        this.aUU.clear();
        this.aUV = 0L;
        this.aUV = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Du() {
        MessageManager.getInstance().unRegisterListener(this.aVd);
        MessageManager.getInstance().unRegisterListener(this.aVe);
        MessageManager.getInstance().unRegisterListener(this.aIJ);
        MessageManager.getInstance().removeMessageRule(this.aVf);
        MessageManager.getInstance().removeMessageRule(this.aVi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(List<AlaLiveMarkData> list) {
        if (list != null && !list.isEmpty()) {
            if (this.aVa == null) {
                this.aVa = new ArrayList();
            }
            this.aVa.clear();
            this.aVa.addAll(list);
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
        final String str2 = (this.azr == null || this.azr.mLiveSdkInfo == null || this.azr.mLiveSdkInfo.mCastIds == null) ? null : this.azr.mLiveSdkInfo.mCastIds.ayO;
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.d.a.b.a.e eVar = new com.baidu.d.a.b.a.e();
            eVar.msg = content;
            eVar.bqN = str2;
            if (this.azr != null && this.azr.ayV != null) {
                eVar.name = this.azr.ayV.userName;
                eVar.portrait = this.azr.ayV.portrait;
            }
            a aVar2 = new a();
            if (this.azr != null) {
                if (this.azr.isHost) {
                    alaLiveUserInfoData = this.azr.ayC;
                } else {
                    alaLiveUserInfoData = this.azr.ayV;
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
                    aVar3.axL = alaLiveUserInfoData.followCount;
                    aVar3.axK = alaLiveUserInfoData.fansCount;
                    aVar3.axO = alaLiveUserInfoData.isAdmin == 1;
                    aVar3.axN = alaLiveUserInfoData.isOfficial == 1;
                    aVar3.level_id = alaLiveUserInfoData.levelId;
                    aVar3.axQ = this.aVa;
                    aVar3.sex = alaLiveUserInfoData.sex;
                    aVar3.extraUserInfo = alaLiveUserInfoData.extraUserInfo;
                    aVar2.e(aVar3);
                    aVar2.setContent(content);
                    aVar2.setMsgType(aVar.Es());
                    aVar2.cG(aVar.El());
                    aVar2.fw(aVar.Em());
                    aVar2.a(aVar.En());
                    aVar2.k(aVar.Eo());
                    aVar2.setUserId(alaLiveUserInfoData.userId);
                    aVar2.fq(String.valueOf(this.azr.mLiveInfo.user_id));
                    aVar2.setBornTime(System.currentTimeMillis());
                    str = aVar2.CS();
                }
            }
            eVar.brd = str;
            com.baidu.d.a.b.a.f fVar = new com.baidu.d.a.b.a.f() { // from class: com.baidu.live.im.f.2
                @Override // com.baidu.d.a.b.a.f
                public void a(String str3, int i, List<com.baidu.d.a.b.a.c> list) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ IM消息 onSendSuccess s:" + str3 + ", i:" + i);
                    }
                    if (f.this.azr != null && f.this.ayO != null && f.this.ayP != null) {
                        if (TextUtils.equals(str3, f.this.ayO) || TextUtils.equals(str3, f.this.ayP)) {
                            ALAGroupCommitHttpResponsedMessage aLAGroupCommitHttpResponsedMessage = new ALAGroupCommitHttpResponsedMessage();
                            aLAGroupCommitHttpResponsedMessage.setStatusCode(200, null);
                            if (f.this.azr.mLiveInfo != null) {
                                f.this.a(aVar, i, str2, list);
                            }
                            aLAGroupCommitHttpResponsedMessage.setError(i);
                            if (i == 0) {
                                f.this.r(list);
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
                            if (com.baidu.live.liveroom.a.Fj().Fk()) {
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
            com.baidu.d.b.a.aA(this.mContext).Li().a(str2, eVar, fVar);
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
    public void a(com.baidu.live.im.message.a aVar, int i, String str, List<com.baidu.d.a.b.a.c> list) {
        if (TbadkCoreApplication.getInst().isHaokan()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SUC_SEND_NEWS);
            alaStaticItem.addParams("live_id", this.azr.mLiveInfo.live_id + "");
            alaStaticItem.addParams("room_id", this.azr.mLiveInfo.room_id + "");
            alaStaticItem.addParams("feed_id", this.azr.mLiveInfo.feed_id + "");
            alaStaticItem.addParams("other_params", aVar.Et());
            if (aVar.Es() == 126) {
                alaStaticItem.addParams("gifts_value", String.valueOf(aVar.Eu()));
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SUC_SEND_NEWS);
            alaStaticItem2.addParams("live_id", this.azr.mLiveInfo.live_id + "");
            alaStaticItem2.addParams("room_id", this.azr.mLiveInfo.room_id + "");
            alaStaticItem2.addParams("feed_id", this.azr.mLiveInfo.feed_id + "");
            alaStaticItem2.addParams("other_params", aVar.Et());
            if (aVar.Es() == 126) {
                alaStaticItem2.addParams("gifts_value", String.valueOf(aVar.Eu()));
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem2);
        }
        if (aVar.Es() == 126) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "msg_send").setContentExt("barrage", null, null));
        } else if (aVar.Ev()) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "msg_send").setContentExt("fastkey", null, null));
        } else {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "msg_send").setContentExt("manual", null, null));
        }
        if (list != null && !list.isEmpty()) {
            try {
                for (com.baidu.d.a.b.a.c cVar : list) {
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
    public void r(List<com.baidu.d.a.b.a.c> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.d.a.b.a.c cVar : list) {
                if (cVar != null) {
                    String str = "";
                    if (!TextUtils.isEmpty(cVar.bqN)) {
                        str = cVar.bqN;
                    } else if (cVar.brc != null && cVar.brc.brq != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(cVar.brc.brq);
                            if (!TextUtils.isEmpty(jSONObject.optString("room_id"))) {
                                str = jSONObject.optString("room_id");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    if (TextUtils.isEmpty(str) || TextUtils.equals(str, this.ayO) || TextUtils.equals(str, this.ayP)) {
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
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ArrayList<ChatMsg> arrayList, boolean z) {
        if ((i == 0 || i == 200) && arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<ChatMsg> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.d.a.b.a.c a = com.baidu.d.b.a.a.a.a.a(it.next());
                if (a != null) {
                    arrayList2.add(a);
                }
            }
            if (!arrayList2.isEmpty()) {
                Collections.reverse(arrayList2);
                this.aVl.e(z ? aUO : aUP, arrayList2);
            }
        }
    }

    private void ft(String str) {
        com.baidu.d.b.a.aA(this.mContext).Li().a(str, this.aVl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fu(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("im_worng_mcastid", str);
            jSONObject.put("im_wrong_msgs", 1);
            jSONObject.put("im_chat_mcast_id", this.ayO);
            jSONObject.put("im_ensure_mcast_id", this.ayP);
            a(jSONObject, (JSONObject) null, "1537", UbcStatConstant.ContentType.UBC_TYPE_IM_WRONG_ID, (String) null);
        } catch (JSONException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dv() {
        if (this.azr != null && this.azr.mLiveSdkInfo != null && this.azr.mLiveSdkInfo.mCastIds != null) {
            this.aUX = 0;
            this.aUY = 0;
            this.ayO = this.azr.mLiveSdkInfo.mCastIds.ayO;
            String str = this.azr.mLiveSdkInfo.mCastIds.ayQ;
            this.ayP = this.azr.mLiveSdkInfo.mCastIds.ayP;
            String str2 = this.azr.mLiveSdkInfo.mCastIds.ayS;
            int i = JavaTypesHelper.toInt(this.azr.mLiveSdkInfo.mCastIds.ayT, 5) * 1000;
            a(this.ayO, str, i, false);
            a(this.ayP, str2, i, this.azr.isHost);
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

    private void Dw() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("im_chat_mcast_id", this.ayO);
            jSONObject.put("im_ensure_mcast_id", this.ayP);
            jSONObject.put("im_chat_mcast_count", this.aUR);
            jSONObject.put("im_ensure_mcast_count", this.aUS);
            a(jSONObject, (JSONObject) null, "1529", UbcStatConstant.ContentType.UBC_TYPE_IM_LEAVE, (String) null);
        } catch (JSONException e) {
        }
    }

    private JSONObject H(JSONObject jSONObject) {
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
        if (this.azr != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            if (TbConfig.IM_LOG) {
                Log.i("imUbclog", "Json: " + jSONObject.toString() + "  type: " + str2 + " isHost: " + this.azr.isHost);
            }
            JSONObject jSONObject3 = new JSONObject();
            H(jSONObject);
            try {
                jSONObject3.put("im", jSONObject);
                if (jSONObject2 != null) {
                    jSONObject3.put(BdStatsConstant.StatsType.ERROR, jSONObject2);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(str, str2, this.azr.isHost ? UbcStatConstant.Page.AUTHOR_LIVE_ROOM : "liveroom", str3);
            ubcStatisticItem.setContentExt(jSONObject3);
            UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
        }
    }
}
