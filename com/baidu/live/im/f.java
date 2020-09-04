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
import com.baidu.live.data.r;
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
/* loaded from: classes7.dex */
public class f {
    private static volatile f bad = null;
    private static int bae = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private static int baf = 2147483646;
    private String aDY;
    private String aDZ;
    private r aEE;
    private boolean bag;
    private int bah;
    private int bai;
    private List<String> bap;
    private List<AlaLiveMarkData> baq;
    private long bas;
    private Context mContext;
    private long baj = 0;
    private LinkedList<Long> bak = new LinkedList<>();
    private long bal = 0;
    private long bam = 0;
    private int ban = 0;
    private int bao = 0;
    private CustomMessageListener bat = new CustomMessageListener(2913081) { // from class: com.baidu.live.im.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            r rVar;
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0) {
                f.this.baj = 0L;
                if (com.baidu.h.b.a.aF(f.this.mContext).Ri() == null || !(customResponsedMessage.getData() instanceof r) || (rVar = (r) customResponsedMessage.getData()) == null) {
                    return;
                }
                if ((rVar.mLiveSdkInfo != null && rVar.mLiveSdkInfo.mCastIds != null) || (rVar.mLiveInfo != null && rVar.mLiveInfo.mCastIds != null)) {
                    if (rVar.mLiveInfo == null || rVar.mLiveInfo.live_status != 2) {
                        if (f.this.aEE != null && f.this.aEE.mLiveInfo != null && rVar != null && rVar.mLiveInfo != null && rVar.mLiveInfo.live_id != f.this.aEE.mLiveInfo.live_id) {
                            f.this.bak.clear();
                            f.this.bal = 0L;
                            f.this.bam = 0L;
                        }
                        f.this.aEE = rVar;
                        f.this.M(f.this.aEE.aEk);
                        f.this.IS();
                        f.this.IR();
                    }
                }
            }
        }
    };
    private CustomMessageListener bau = new CustomMessageListener(2913082) { // from class: com.baidu.live.im.f.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof r)) {
                r rVar = (r) customResponsedMessage.getData();
                if (f.this.aEE != null && f.this.aEE.mLiveInfo != null && rVar != null && rVar.mLiveInfo != null && rVar.mLiveInfo.live_id != f.this.aEE.mLiveInfo.live_id) {
                    f.this.bak.clear();
                    f.this.bal = 0L;
                    f.this.bam = 0L;
                }
                f.this.aEE = rVar;
                f.this.M(f.this.aEE.aEk);
            }
        }
    };
    private CustomMessageListener bav = new CustomMessageListener(2913118) { // from class: com.baidu.live.im.f.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof r)) {
                f.this.M(((r) customResponsedMessage.getData()).aEk);
            }
        }
    };
    private HttpRule baw = new HttpRule(1021013) { // from class: com.baidu.live.im.f.13
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
    private HttpRule bax = new HttpRule(1021012) { // from class: com.baidu.live.im.f.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            return null;
        }
    };
    CustomMessageListener bay = new CustomMessageListener(2913084) { // from class: com.baidu.live.im.f.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.IQ();
        }
    };
    CustomMessageListener aNW = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.im.f.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.IW();
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.im.f.16.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.IX();
                }
            });
        }
    };
    private HttpRule baz = new HttpRule(1021006) { // from class: com.baidu.live.im.f.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            f.this.IW();
            if (f.this.aEE != null && f.this.aEE.mLiveSdkInfo != null && f.this.aEE.mLiveSdkInfo.mCastIds != null) {
                String str = f.this.aEE.mLiveSdkInfo.mCastIds.aDY;
                String str2 = f.this.aEE.mLiveSdkInfo.mCastIds.aDZ;
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str, -1, "", "", "");
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str2, -1, "", "", "");
            }
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.im.f.17.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.IX();
                }
            });
            return httpMessage;
        }
    };
    private IFetchMsgByIdListener baA = new IFetchMsgByIdListener() { // from class: com.baidu.live.im.f.3
        @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
        public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList) {
            if (String.valueOf(j).equals(f.this.aDY) || String.valueOf(j).equals(f.this.aDZ)) {
                if (TbConfig.IM_LOG) {
                    Log.d("im-debug", "fetch history msg received size=" + arrayList.size());
                }
                f.this.a(i, arrayList, true);
            } else if (TbConfig.IM_LOG) {
                Log.d("im-debug", "onFetchMsgByIdResult 非当前直播间 ：l: " + j);
            }
        }
    };
    private IFetchMsgByIdListener baB = new IFetchMsgByIdListener() { // from class: com.baidu.live.im.f.4
        @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
        public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList) {
            if (String.valueOf(j).equals(f.this.aDY) || String.valueOf(j).equals(f.this.aDZ)) {
                if (TbConfig.IM_LOG) {
                    Log.d("im-debug", "fetch msg received size=" + arrayList.size());
                }
                f.this.a(i, arrayList, false);
            } else if (TbConfig.IM_LOG) {
                Log.d("im-debug", "onFetchMsgByIdResult 非当前直播间 ：l: " + j);
            }
        }
    };
    private com.baidu.h.a.b.a.d baC = new com.baidu.h.a.b.a.d() { // from class: com.baidu.live.im.f.5
        @Override // com.baidu.h.a.b.a.d
        public void e(int i, List<com.baidu.h.a.b.a.c> list) {
            String str;
            String str2;
            JSONObject jSONObject;
            if (f.this.aEE == null || f.this.aDY == null || f.this.aDZ == null || f.this.aEE.mLiveInfo == null) {
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收: 直播间已销毁");
                }
            } else if (i != 0 && i != f.bae && i != f.baf) {
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收: 非有效消息");
                }
            } else {
                ALAGroupHttpResponseMessage aLAGroupHttpResponseMessage = new ALAGroupHttpResponseMessage();
                ArrayList arrayList = new ArrayList();
                if (f.this.bap != null) {
                    f.this.bap.clear();
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
                        if (!TextUtils.isEmpty(cVar.bwG)) {
                            str = cVar.bwG;
                            str2 = "";
                        } else {
                            if (cVar.bwV != null && cVar.bwV.bxj != null) {
                                try {
                                    JSONObject jSONObject2 = new JSONObject(cVar.bwV.bxj);
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
                        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, f.this.aDY) && !TextUtils.equals(str, f.this.aDZ)) {
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ IM消息 接收  非当前直播间的消息，过滤 castId：" + str + "   chatMCastId：" + f.this.aDY + "   ensureMCastId: " + f.this.aDZ);
                            }
                            f.this.gQ(str);
                        } else if (TextUtils.equals(cVar.type, "0") && TextUtils.isEmpty(str)) {
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ IM消息 接收: 如果是普通消息同时castId为空，过滤");
                            }
                            f.this.gQ(str);
                        } else if (!TextUtils.isEmpty(str) || !TextUtils.equals(str2, SoUtils.SO_EVENT_ID_DEFAULT)) {
                            if (i != f.bae && i != f.baf && TextUtils.equals(str, f.this.aDY)) {
                                f.this.baj = System.currentTimeMillis();
                                if (TbConfig.IM_LOG) {
                                    Log.d("im-debug", "receiveChatMsgTime= " + f.this.baj);
                                }
                                f.this.bag = false;
                                f.this.IR();
                            }
                            if (!f.this.bak.contains(Long.valueOf(cVar.msgId))) {
                                if (i == f.bae) {
                                    String str4 = "";
                                    if (!TextUtils.isEmpty(cVar.bwW)) {
                                        try {
                                            JSONObject jSONObject3 = new JSONObject(cVar.bwW);
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
                                            if (aVar.JK() != null && (!TextUtils.isEmpty(aVar.JK().name_show) || !TextUtils.isEmpty(aVar.JK().userName))) {
                                                arrayList.add(aVar);
                                            }
                                            i2 = i3 + 1;
                                        }
                                    } else {
                                        arrayList.addAll(a);
                                    }
                                    if (i == 0 && cVar.bwV != null && !TextUtils.isEmpty(cVar.bwV.bxj)) {
                                        if (f.this.bap == null) {
                                            f.this.bap = new ArrayList();
                                        }
                                        f.this.bap.add(cVar.bwV.bxj);
                                    }
                                    if (!TextUtils.equals(cVar.type, TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY)) {
                                        if (TextUtils.equals(str2, SoUtils.SO_EVENT_ID_DEFAULT)) {
                                            f.this.bai += a.size();
                                            if (f.this.aEE != null && f.this.aEE.isHost) {
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
                                                                if (aVar2.JK() != null) {
                                                                    jSONObject4.put("sender_uk", EncryptionHelper.getEncryptionUserId(aVar2.JK().userId));
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
                                            f.this.bah += a.size();
                                        }
                                    }
                                    if (f.this.bak.size() > 200) {
                                        f.this.bak.removeFirst();
                                    }
                                    f.this.bak.add(Long.valueOf(cVar.msgId));
                                    if (!TextUtils.equals(str, f.this.aDY) || cVar.msgId <= f.this.bal) {
                                        if (TextUtils.equals(str, f.this.aDY) && cVar.msgId > f.this.bam) {
                                            f.this.bam = cVar.msgId;
                                        }
                                    } else {
                                        f.this.bal = cVar.msgId;
                                    }
                                }
                            } else if (TbConfig.IM_LOG) {
                                Log.d("im-debug", "remove repeat msg msgid=" + cVar.msgId + " type=" + cVar.type);
                            }
                        } else {
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ IM消息 接收: 如果是普通消息同时castId为空，过滤礼物消息");
                            }
                            f.this.gQ(str);
                        }
                    }
                }
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收: 消息分发 Size: " + arrayList.size() + "  History: " + (i == f.bae));
                }
                if (arrayList.size() > 0) {
                    aLAGroupHttpResponseMessage.bR(i == f.bae);
                    aLAGroupHttpResponseMessage.Q(arrayList);
                    aLAGroupHttpResponseMessage.setGroupId(f.this.aEE.mLiveInfo.getGroupID());
                    MessageManager.getInstance().dispatchResponsedMessage(aLAGroupHttpResponseMessage);
                    if (f.this.bap != null && !f.this.bap.isEmpty()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913107, f.this.bap));
                    }
                }
            }
        }
    };
    private CustomMessageListener baD = new CustomMessageListener(2913108) { // from class: com.baidu.live.im.f.6
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
                f.this.IY();
            }
        }
    };
    private CustomMessageListener baE = new CustomMessageListener(2913190) { // from class: com.baidu.live.im.f.7
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
                    f.this.IY();
                } else {
                    SafeHandler.getInst().removeCallbacks(f.this.baF);
                    SafeHandler.getInst().postDelayed(f.this.baF, 1000L);
                }
            }
            if (TbadkCoreApplication.getInst().isTieba()) {
                if (LoginManager.getInstance(TbadkCoreApplication.getInst().getContext()).isIMLogined()) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ IM消息 贴吧直播间切前台监听 -- IM 没断，直接 join");
                    }
                    f.this.IY();
                    return;
                }
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 贴吧直播间切前台监听 -- IM 断");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913191, null));
            }
        }
    };
    private Runnable baF = new Runnable() { // from class: com.baidu.live.im.f.8
        @Override // java.lang.Runnable
        public void run() {
            f.this.IY();
        }
    };
    private Runnable baG = new Runnable() { // from class: com.baidu.live.im.f.9
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (TbConfig.IM_LOG) {
                Log.d("im-debug", "imExceptionCheckRunnable: " + (currentTimeMillis - f.this.baj));
            }
            if (currentTimeMillis - f.this.baj >= 18000) {
                if (!f.this.bag) {
                    f.this.bag = true;
                    f.this.IU();
                }
                if (f.this.aEE != null && f.this.aEE.isHost) {
                    f.this.IS();
                    f.this.IT();
                }
            } else if (f.this.bag) {
                f.this.bag = false;
                f.this.IU();
            }
            f.this.IR();
        }
    };
    private CustomMessageTask.CustomRunnable baH = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.im.f.10
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            String str;
            if (f.this.aEE != null && f.this.aEE.mLiveSdkInfo != null && f.this.aEE.mLiveSdkInfo.mCastIds != null) {
                str = f.this.aEE.mLiveSdkInfo.mCastIds.aDZ;
            } else {
                str = "0";
            }
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID, str);
        }
    };

    public static f IP() {
        if (bad == null) {
            synchronized (f.class) {
                if (bad == null) {
                    bad = new f();
                }
            }
        }
        return bad;
    }

    private f() {
    }

    public void as(Context context) {
        this.mContext = context;
        MessageManager.getInstance().unRegisterListener(this.bat);
        MessageManager.getInstance().registerListener(this.bat);
        MessageManager.getInstance().removeMessageRule(this.bax);
        MessageManager.getInstance().addMessageRule(this.bax);
        MessageManager.getInstance().unRegisterListener(this.bay);
        MessageManager.getInstance().registerListener(this.bay);
        MessageManager.getInstance().unRegisterListener(this.baD);
        MessageManager.getInstance().registerListener(this.baD);
        MessageManager.getInstance().unRegisterListener(this.baE);
        MessageManager.getInstance().registerListener(this.baE);
        new CustomMessageTask(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID, this.baH).setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID);
    }

    public void IQ() {
        SafeHandler.getInst().removeCallbacks(this.baF);
        SafeHandler.getInst().removeCallbacks(this.baG);
        com.baidu.h.b.a.aF(this.mContext).Ri().IW();
        this.bas = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IR() {
        SafeHandler.getInst().removeCallbacks(this.baG);
        if (this.aEE != null && this.aEE.mLiveInfo != null) {
            SafeHandler.getInst().postDelayed(this.baG, 18000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IS() {
        int i;
        String str;
        String str2;
        if (this.aEE != null) {
            if (this.aEE.mLiveSdkInfo != null && this.aEE.mLiveSdkInfo.mCastIds != null) {
                this.aDY = this.aEE.mLiveSdkInfo.mCastIds.aDY;
                String str3 = this.aEE.mLiveSdkInfo.mCastIds.aEa;
                this.aDZ = this.aEE.mLiveSdkInfo.mCastIds.aDZ;
                String str4 = this.aEE.mLiveSdkInfo.mCastIds.aEc;
                i = JavaTypesHelper.toInt(this.aEE.mLiveSdkInfo.mCastIds.aEd, 5) * 1000;
                str = str4;
                str2 = str3;
            } else if (this.aEE.mLiveInfo == null || this.aEE.mLiveInfo.mCastIds == null) {
                i = 5000;
                str = "";
                str2 = "";
            } else {
                this.aDY = this.aEE.mLiveInfo.mCastIds.aDY;
                String str5 = this.aEE.mLiveInfo.mCastIds.aEa;
                this.aDZ = this.aEE.mLiveInfo.mCastIds.aDZ;
                String str6 = this.aEE.mLiveInfo.mCastIds.aEc;
                i = JavaTypesHelper.toInt(this.aEE.mLiveInfo.mCastIds.aEd, 5) * 1000;
                str = str6;
                str2 = str5;
            }
            a(this.aDY, str2, i, false);
            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", this.aDY, this.aDY, 0, "", "", "");
            a(this.aDZ, str, i, this.aEE.isHost);
            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", this.aDY, this.aDZ, 0, "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IT() {
        if (TbConfig.IM_LOG) {
            Log.d("im-debug", "start fetch im chat castid=" + this.aDY + "lastmsgid=" + this.bal);
        }
        int i = 25;
        if (this.bal == 0) {
            i = -25;
        }
        BIMManager.fetchMsgRequest(this.mContext, AccountManager.getAppid(this.mContext), AccountManager.getUK(this.mContext), 4, JavaTypesHelper.toLong(this.aDY, -1L), this.bal, Long.MAX_VALUE, i, 1, this.baB);
        int i2 = 25;
        if (this.bam == 0) {
            i2 = -25;
        }
        if (TbConfig.IM_LOG) {
            Log.d("im-debug", "start fetch im ensure castid=" + this.aDZ + " lastmsgid=" + this.bam);
        }
        BIMManager.fetchMsgRequest(this.mContext, AccountManager.getAppid(this.mContext), AccountManager.getUK(this.mContext), 4, JavaTypesHelper.toLong(this.aDZ, -1L), this.bam, Long.MAX_VALUE, i2, 1, this.baB, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IU() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME), Long.class);
        if (runTask == null) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("im_state", this.bag ? 0 : 1);
            jSONObject.put("im_chat_mcast_id", this.aDY);
            jSONObject.put("im_ensure_mcast_id", this.aDZ);
            jSONObject.put("im_live_info_time", j);
            jSONObject.put("im_last_msg_time", this.baj);
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
            com.baidu.h.b.a.aF(this.mContext).Ri().a(str, str2, i, new com.baidu.h.a.b.b() { // from class: com.baidu.live.im.f.18
                @Override // com.baidu.h.a.b.b
                public void onResult(int i2, long j, long j2) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ enterRoom onResult i:" + i2 + ", l:" + j + ", l1:" + j2);
                    }
                    if (f.this.aEE == null || f.this.aDY == null || f.this.aDZ == null) {
                        com.baidu.h.b.a.aF(f.this.mContext).Ri().hC(String.valueOf(j));
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.aDY, String.valueOf(j), -1, "", "", "");
                        return;
                    }
                    long j3 = JavaTypesHelper.toLong(f.this.aDY, -1L);
                    long j4 = JavaTypesHelper.toLong(f.this.aDZ, -1L);
                    if (j3 != j && j4 != j) {
                        com.baidu.h.b.a.aF(f.this.mContext).Ri().hC(String.valueOf(j));
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.aDY, String.valueOf(j), -1, "", "", "");
                        if (TbConfig.IM_LOG) {
                            Log.e("imlog", "BDIM enterRoom wrong then exit end:" + j);
                            return;
                        }
                        return;
                    }
                    if (j3 == j) {
                        f.this.bah = 0;
                    } else {
                        f.this.bai = 0;
                    }
                    if (i2 != 0) {
                        f.this.b(j, i2, j3 == j ? f.this.ban : f.this.bao);
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
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_FAIL_IM_NOT_LOGIN, f.this.aDY, str, -1, "", "", "");
                    } else if (i2 == 1314 || i2 == 1306) {
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_MSG_ENTER_IM_FAIL, f.this.aDY, str, -1, String.valueOf(i2), "", "");
                    } else if (i2 != 0) {
                        if (j3 == j) {
                            if (f.this.ban < 6) {
                                f.this.a(str, str2, i, z);
                                f.this.ban++;
                                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_MSG_FAIL_TO_REJOIN, f.this.aDY, str, -1, "", "", "");
                                return;
                            }
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.aDY, str, -1, "", "", "");
                        } else if (f.this.bao < 6) {
                            f.this.a(str, str2, i, z);
                            f.this.bao++;
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_GIFT_FAIL_TO_REJOIN, f.this.aDY, str, -1, "", "", "");
                        } else {
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.aDY, str, -1, "", "", "");
                        }
                    } else if (j3 == j) {
                        f.this.ban = 0;
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", f.this.aDY, str, 0, "", "", "");
                        if (TbConfig.IM_LOG) {
                            Log.i("imlog", "@.@ enterRoom onResult JOIN Msg成功:" + j3);
                        }
                        if ((!f.this.aEE.isHost || (f.this.aEE.isHost && f.this.aEE.aEn)) && f.this.bas != j3) {
                            f.this.bas = j3;
                            long j5 = JavaTypesHelper.toLong(str, -1L);
                            BIMManager.fetchMsgRequest(f.this.mContext, AccountManager.getAppid(f.this.mContext), AccountManager.getUK(f.this.mContext), 4, j5, 0L, Long.MAX_VALUE, -25, 1, f.this.baA);
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ enterRoom fetchMsgidByMsgid:   " + j5);
                            }
                        }
                    } else {
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", f.this.aDY, str, 0, "", "", "");
                        if (TbConfig.IM_LOG) {
                            Log.i("imlog", "@.@ enterRoom onResult JOIN Gift成功:" + j4);
                        }
                        f.this.bao = 0;
                    }
                }
            }, z);
            IV();
            gP(str);
            if (TbConfig.IM_LOG) {
                Log.i("imlog", "@.@ enterRoom registerMsgReceiveListener:" + z + ", mCastId: " + str);
            }
        }
    }

    private void IV() {
        MessageManager.getInstance().unRegisterListener(this.aNW);
        MessageManager.getInstance().registerListener(this.aNW);
        MessageManager.getInstance().unRegisterListener(this.bau);
        MessageManager.getInstance().registerListener(this.bau);
        MessageManager.getInstance().unRegisterListener(this.bav);
        MessageManager.getInstance().registerListener(this.bav);
        MessageManager.getInstance().removeMessageRule(this.baw);
        MessageManager.getInstance().addMessageRule(this.baw);
        MessageManager.getInstance().removeMessageRule(this.baz);
        MessageManager.getInstance().addMessageRule(this.baz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IW() {
        SafeHandler.getInst().removeCallbacks(this.baF);
        SafeHandler.getInst().removeCallbacks(this.baG);
        if (this.aEE != null && this.aEE.mLiveSdkInfo != null && this.aEE.mLiveSdkInfo.mCastIds != null) {
            String str = this.aEE.mLiveSdkInfo.mCastIds.aDY;
            String str2 = this.aEE.mLiveSdkInfo.mCastIds.aDZ;
            com.baidu.h.b.a.aF(this.mContext).Ri().hC(str);
            com.baidu.h.b.a.aF(this.mContext).Ri().hC(str2);
            IZ();
        }
        this.bah = 0;
        this.bai = 0;
        this.bas = 0L;
        this.aEE = null;
        this.aDY = null;
        this.aDZ = null;
        this.ban = 0;
        this.bao = 0;
        if (this.bap != null) {
            this.bap.clear();
            this.bap = null;
        }
        if (this.baq != null) {
            this.baq.clear();
            this.baq = null;
        }
        this.bak.clear();
        this.bal = 0L;
        this.bal = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IX() {
        MessageManager.getInstance().unRegisterListener(this.bau);
        MessageManager.getInstance().unRegisterListener(this.bav);
        MessageManager.getInstance().unRegisterListener(this.aNW);
        MessageManager.getInstance().removeMessageRule(this.baw);
        MessageManager.getInstance().removeMessageRule(this.baz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(List<AlaLiveMarkData> list) {
        if (list != null && !list.isEmpty()) {
            if (this.baq == null) {
                this.baq = new ArrayList();
            }
            this.baq.clear();
            this.baq.addAll(list);
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
        final String str2 = (this.aEE == null || this.aEE.mLiveSdkInfo == null || this.aEE.mLiveSdkInfo.mCastIds == null) ? null : this.aEE.mLiveSdkInfo.mCastIds.aDY;
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.h.a.b.a.e eVar = new com.baidu.h.a.b.a.e();
            eVar.msg = content;
            eVar.bwG = str2;
            if (this.aEE != null && this.aEE.aEf != null) {
                eVar.name = this.aEE.aEf.userName;
                eVar.portrait = this.aEE.aEf.portrait;
            }
            a aVar2 = new a();
            if (this.aEE != null) {
                if (this.aEE.isHost) {
                    alaLiveUserInfoData = this.aEE.aDG;
                } else {
                    alaLiveUserInfoData = this.aEE.aEf;
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
                    aVar3.aCP = alaLiveUserInfoData.followCount;
                    aVar3.aCO = alaLiveUserInfoData.fansCount;
                    aVar3.aCS = alaLiveUserInfoData.isAdmin == 1;
                    aVar3.aCR = alaLiveUserInfoData.isOfficial == 1;
                    aVar3.level_id = alaLiveUserInfoData.levelId;
                    aVar3.aCU = this.baq;
                    aVar3.sex = alaLiveUserInfoData.sex;
                    aVar3.extraUserInfo = alaLiveUserInfoData.extraUserInfo;
                    aVar2.e(aVar3);
                    aVar2.setContent(content);
                    aVar2.setMsgType(aVar.JX());
                    aVar2.ew(aVar.JO());
                    aVar2.gS(aVar.JP());
                    aVar2.a(aVar.JQ());
                    aVar2.k(aVar.JR());
                    aVar2.setUserId(alaLiveUserInfoData.userId);
                    aVar2.gM(String.valueOf(this.aEE.mLiveInfo.user_id));
                    aVar2.setBornTime(System.currentTimeMillis());
                    str = aVar2.Iv();
                }
            }
            eVar.bwW = str;
            com.baidu.h.a.b.a.f fVar = new com.baidu.h.a.b.a.f() { // from class: com.baidu.live.im.f.2
                @Override // com.baidu.h.a.b.a.f
                public void a(String str3, int i, List<com.baidu.h.a.b.a.c> list) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ IM消息 onSendSuccess s:" + str3 + ", i:" + i);
                    }
                    if (f.this.aEE != null && f.this.aDY != null && f.this.aDZ != null) {
                        if (TextUtils.equals(str3, f.this.aDY) || TextUtils.equals(str3, f.this.aDZ)) {
                            ALAGroupCommitHttpResponsedMessage aLAGroupCommitHttpResponsedMessage = new ALAGroupCommitHttpResponsedMessage();
                            aLAGroupCommitHttpResponsedMessage.setStatusCode(200, null);
                            if (f.this.aEE.mLiveInfo != null) {
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
                            if (com.baidu.live.liveroom.a.KQ().KR()) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913093));
                            }
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
            com.baidu.h.b.a.aF(this.mContext).Ri().a(str2, eVar, fVar);
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
            alaStaticItem.addParams("live_id", this.aEE.mLiveInfo.live_id + "");
            alaStaticItem.addParams("room_id", this.aEE.mLiveInfo.room_id + "");
            alaStaticItem.addParams("feed_id", this.aEE.mLiveInfo.feed_id + "");
            alaStaticItem.addParams("other_params", aVar.JY());
            if (aVar.JX() == 126) {
                alaStaticItem.addParams("gifts_value", String.valueOf(aVar.JZ()));
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SUC_SEND_NEWS);
            alaStaticItem2.addParams("live_id", this.aEE.mLiveInfo.live_id + "");
            alaStaticItem2.addParams("room_id", this.aEE.mLiveInfo.room_id + "");
            alaStaticItem2.addParams("feed_id", this.aEE.mLiveInfo.feed_id + "");
            alaStaticItem2.addParams("other_params", aVar.JY());
            if (aVar.JX() == 126) {
                alaStaticItem2.addParams("gifts_value", String.valueOf(aVar.JZ()));
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem2);
        }
        if (aVar.JX() == 126) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "msg_send").setContentExt("barrage", null, null));
        } else if (aVar.Ka()) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "msg_send").setContentExt("fastkey", null, null));
        } else {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "msg_send").setContentExt("manual", null, null));
        }
        if (list != null && !list.isEmpty()) {
            try {
                for (com.baidu.h.a.b.a.c cVar : list) {
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
    public void s(List<com.baidu.h.a.b.a.c> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.h.a.b.a.c cVar : list) {
                if (cVar != null) {
                    String str = "";
                    if (!TextUtils.isEmpty(cVar.bwG)) {
                        str = cVar.bwG;
                    } else if (cVar.bwV != null && cVar.bwV.bxj != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(cVar.bwV.bxj);
                            if (!TextUtils.isEmpty(jSONObject.optString("room_id"))) {
                                str = jSONObject.optString("room_id");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    if (TextUtils.isEmpty(str) || TextUtils.equals(str, this.aDY) || TextUtils.equals(str, this.aDZ)) {
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
                com.baidu.h.a.b.a.c a = com.baidu.h.b.a.a.a.a.a(it.next());
                if (a != null) {
                    arrayList2.add(a);
                }
            }
            if (!arrayList2.isEmpty()) {
                Collections.reverse(arrayList2);
                this.baC.e(z ? bae : baf, arrayList2);
            }
        }
    }

    private void gP(String str) {
        com.baidu.h.b.a.aF(this.mContext).Ri().a(str, this.baC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gQ(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("im_worng_mcastid", str);
            jSONObject.put("im_wrong_msgs", 1);
            jSONObject.put("im_chat_mcast_id", this.aDY);
            jSONObject.put("im_ensure_mcast_id", this.aDZ);
            a(jSONObject, (JSONObject) null, "1537", UbcStatConstant.ContentType.UBC_TYPE_IM_WRONG_ID, (String) null);
        } catch (JSONException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IY() {
        if (this.aEE != null && this.aEE.mLiveSdkInfo != null && this.aEE.mLiveSdkInfo.mCastIds != null) {
            this.ban = 0;
            this.bao = 0;
            this.aDY = this.aEE.mLiveSdkInfo.mCastIds.aDY;
            String str = this.aEE.mLiveSdkInfo.mCastIds.aEa;
            this.aDZ = this.aEE.mLiveSdkInfo.mCastIds.aDZ;
            String str2 = this.aEE.mLiveSdkInfo.mCastIds.aEc;
            int i = JavaTypesHelper.toInt(this.aEE.mLiveSdkInfo.mCastIds.aEd, 5) * 1000;
            a(this.aDY, str, i, false);
            a(this.aDZ, str2, i, this.aEE.isHost);
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

    private void IZ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("im_chat_mcast_id", this.aDY);
            jSONObject.put("im_ensure_mcast_id", this.aDZ);
            jSONObject.put("im_chat_mcast_count", this.bah);
            jSONObject.put("im_ensure_mcast_count", this.bai);
            a(jSONObject, (JSONObject) null, "1529", UbcStatConstant.ContentType.UBC_TYPE_IM_LEAVE, (String) null);
        } catch (JSONException e) {
        }
    }

    private JSONObject J(JSONObject jSONObject) {
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
        if (this.aEE != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            if (TbConfig.IM_LOG) {
                Log.i("imUbclog", "Json: " + jSONObject.toString() + "  type: " + str2 + " isHost: " + this.aEE.isHost);
            }
            JSONObject jSONObject3 = new JSONObject();
            J(jSONObject);
            try {
                jSONObject3.put("im", jSONObject);
                if (jSONObject2 != null) {
                    jSONObject3.put(BdStatsConstant.StatsType.ERROR, jSONObject2);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(str, str2, this.aEE.isHost ? UbcStatConstant.Page.AUTHOR_LIVE_ROOM : "liveroom", str3);
            ubcStatisticItem.setContentExt(jSONObject3);
            UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
        }
    }
}
