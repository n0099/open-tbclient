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
    private static volatile f aTu = null;
    private static int aTv = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private static int aTw = 2147483646;
    private List<String> aTG;
    private List<AlaLiveMarkData> aTH;
    private long aTI;
    private boolean aTx;
    private int aTy;
    private int aTz;
    private String axB;
    private String axC;
    private com.baidu.live.data.q aye;
    private Context mContext;
    private long aTA = 0;
    private LinkedList<Long> aTB = new LinkedList<>();
    private long aTC = 0;
    private long aTD = 0;
    private int aTE = 0;
    private int aTF = 0;
    private CustomMessageListener aTJ = new CustomMessageListener(2913081) { // from class: com.baidu.live.im.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.data.q qVar;
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0) {
                f.this.aTA = 0L;
                if (com.baidu.c.b.a.aA(f.this.mContext).Lb() == null || !(customResponsedMessage.getData() instanceof com.baidu.live.data.q) || (qVar = (com.baidu.live.data.q) customResponsedMessage.getData()) == null) {
                    return;
                }
                if ((qVar.mLiveSdkInfo != null && qVar.mLiveSdkInfo.mCastIds != null) || (qVar.mLiveInfo != null && qVar.mLiveInfo.mCastIds != null)) {
                    if (qVar.mLiveInfo == null || qVar.mLiveInfo.live_status != 2) {
                        if (f.this.aye != null && f.this.aye.mLiveInfo != null && qVar != null && qVar.mLiveInfo != null && qVar.mLiveInfo.live_id != f.this.aye.mLiveInfo.live_id) {
                            f.this.aTB.clear();
                            f.this.aTC = 0L;
                            f.this.aTD = 0L;
                        }
                        f.this.aye = qVar;
                        f.this.J(f.this.aye.axN);
                        f.this.CO();
                        f.this.CN();
                    }
                }
            }
        }
    };
    private CustomMessageListener aTK = new CustomMessageListener(2913082) { // from class: com.baidu.live.im.f.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof com.baidu.live.data.q)) {
                com.baidu.live.data.q qVar = (com.baidu.live.data.q) customResponsedMessage.getData();
                if (f.this.aye != null && f.this.aye.mLiveInfo != null && qVar != null && qVar.mLiveInfo != null && qVar.mLiveInfo.live_id != f.this.aye.mLiveInfo.live_id) {
                    f.this.aTB.clear();
                    f.this.aTC = 0L;
                    f.this.aTD = 0L;
                }
                f.this.aye = qVar;
                f.this.J(f.this.aye.axN);
            }
        }
    };
    private CustomMessageListener aTL = new CustomMessageListener(2913118) { // from class: com.baidu.live.im.f.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof com.baidu.live.data.q)) {
                f.this.J(((com.baidu.live.data.q) customResponsedMessage.getData()).axN);
            }
        }
    };
    private HttpRule aTM = new HttpRule(1021013) { // from class: com.baidu.live.im.f.13
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
    private HttpRule aTN = new HttpRule(1021012) { // from class: com.baidu.live.im.f.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            return null;
        }
    };
    CustomMessageListener aTO = new CustomMessageListener(2913084) { // from class: com.baidu.live.im.f.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.CM();
        }
    };
    CustomMessageListener aHo = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.im.f.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.CS();
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.im.f.16.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.CT();
                }
            });
        }
    };
    private HttpRule aTP = new HttpRule(1021006) { // from class: com.baidu.live.im.f.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            f.this.CS();
            if (f.this.aye != null && f.this.aye.mLiveSdkInfo != null && f.this.aye.mLiveSdkInfo.mCastIds != null) {
                String str = f.this.aye.mLiveSdkInfo.mCastIds.axB;
                String str2 = f.this.aye.mLiveSdkInfo.mCastIds.axC;
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str, -1, "", "", "");
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str2, -1, "", "", "");
            }
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.im.f.17.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.CT();
                }
            });
            return httpMessage;
        }
    };
    private IFetchMsgByIdListener aTQ = new IFetchMsgByIdListener() { // from class: com.baidu.live.im.f.3
        @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
        public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList) {
            if (String.valueOf(j).equals(f.this.axB) || String.valueOf(j).equals(f.this.axC)) {
                if (TbConfig.IM_LOG) {
                    Log.d("im-debug", "fetch history msg received size=" + arrayList.size());
                }
                f.this.a(i, arrayList, true);
            } else if (TbConfig.IM_LOG) {
                Log.d("im-debug", "onFetchMsgByIdResult 非当前直播间 ：l: " + j);
            }
        }
    };
    private IFetchMsgByIdListener aTR = new IFetchMsgByIdListener() { // from class: com.baidu.live.im.f.4
        @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
        public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList) {
            if (String.valueOf(j).equals(f.this.axB) || String.valueOf(j).equals(f.this.axC)) {
                if (TbConfig.IM_LOG) {
                    Log.d("im-debug", "fetch msg received size=" + arrayList.size());
                }
                f.this.a(i, arrayList, false);
            } else if (TbConfig.IM_LOG) {
                Log.d("im-debug", "onFetchMsgByIdResult 非当前直播间 ：l: " + j);
            }
        }
    };
    private com.baidu.c.a.b.a.d aTS = new com.baidu.c.a.b.a.d() { // from class: com.baidu.live.im.f.5
        @Override // com.baidu.c.a.b.a.d
        public void e(int i, List<com.baidu.c.a.b.a.c> list) {
            String str;
            String str2;
            JSONObject jSONObject;
            if (f.this.aye == null || f.this.axB == null || f.this.axC == null || f.this.aye.mLiveInfo == null) {
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收: 直播间已销毁");
                }
            } else if (i != 0 && i != f.aTv && i != f.aTw) {
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收: 非有效消息");
                }
            } else {
                ALAGroupHttpResponseMessage aLAGroupHttpResponseMessage = new ALAGroupHttpResponseMessage();
                ArrayList arrayList = new ArrayList();
                if (f.this.aTG != null) {
                    f.this.aTG.clear();
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
                        if (!TextUtils.isEmpty(cVar.bqs)) {
                            str = cVar.bqs;
                            str2 = "";
                        } else {
                            if (cVar.bqH != null && cVar.bqH.bqV != null) {
                                try {
                                    JSONObject jSONObject2 = new JSONObject(cVar.bqH.bqV);
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
                        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, f.this.axB) && !TextUtils.equals(str, f.this.axC)) {
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ IM消息 接收  非当前直播间的消息，过滤 castId：" + str + "   chatMCastId：" + f.this.axB + "   ensureMCastId: " + f.this.axC);
                            }
                            f.this.fv(str);
                        } else if (TextUtils.equals(cVar.type, "0") && TextUtils.isEmpty(str)) {
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ IM消息 接收: 如果是普通消息同时castId为空，过滤");
                            }
                            f.this.fv(str);
                        } else if (!TextUtils.isEmpty(str) || !TextUtils.equals(str2, SoUtils.SO_EVENT_ID_DEFAULT)) {
                            if (i != f.aTv && i != f.aTw && TextUtils.equals(str, f.this.axB)) {
                                f.this.aTA = System.currentTimeMillis();
                                if (TbConfig.IM_LOG) {
                                    Log.d("im-debug", "receiveChatMsgTime= " + f.this.aTA);
                                }
                                f.this.aTx = false;
                                f.this.CN();
                            }
                            if (!f.this.aTB.contains(Long.valueOf(cVar.msgId))) {
                                if (i == f.aTv) {
                                    String str4 = "";
                                    if (!TextUtils.isEmpty(cVar.bqI)) {
                                        try {
                                            JSONObject jSONObject3 = new JSONObject(cVar.bqI);
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
                                            if (aVar.Ed() != null && (!TextUtils.isEmpty(aVar.Ed().name_show) || !TextUtils.isEmpty(aVar.Ed().userName))) {
                                                arrayList.add(aVar);
                                            }
                                            i2 = i3 + 1;
                                        }
                                    } else {
                                        arrayList.addAll(a);
                                    }
                                    if (i == 0 && cVar.bqH != null && !TextUtils.isEmpty(cVar.bqH.bqV)) {
                                        if (f.this.aTG == null) {
                                            f.this.aTG = new ArrayList();
                                        }
                                        f.this.aTG.add(cVar.bqH.bqV);
                                    }
                                    if (!TextUtils.equals(cVar.type, TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY)) {
                                        if (TextUtils.equals(str2, SoUtils.SO_EVENT_ID_DEFAULT)) {
                                            f.this.aTz += a.size();
                                            if (f.this.aye != null && f.this.aye.isHost) {
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
                                                                if (aVar2.Ed() != null) {
                                                                    jSONObject4.put("sender_uk", EncryptionHelper.getEncryptionUserId(aVar2.Ed().userId));
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
                                            f.this.aTy += a.size();
                                        }
                                    }
                                    if (f.this.aTB.size() > 200) {
                                        f.this.aTB.removeFirst();
                                    }
                                    f.this.aTB.add(Long.valueOf(cVar.msgId));
                                    if (!TextUtils.equals(str, f.this.axB) || cVar.msgId <= f.this.aTC) {
                                        if (TextUtils.equals(str, f.this.axB) && cVar.msgId > f.this.aTD) {
                                            f.this.aTD = cVar.msgId;
                                        }
                                    } else {
                                        f.this.aTC = cVar.msgId;
                                    }
                                }
                            } else if (TbConfig.IM_LOG) {
                                Log.d("im-debug", "remove repeat msg msgid=" + cVar.msgId + " type=" + cVar.type);
                            }
                        } else {
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ IM消息 接收: 如果是普通消息同时castId为空，过滤礼物消息");
                            }
                            f.this.fv(str);
                        }
                    }
                }
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收: 消息分发 Size: " + arrayList.size() + "  History: " + (i == f.aTv));
                }
                if (arrayList.size() > 0) {
                    aLAGroupHttpResponseMessage.bI(i == f.aTv);
                    aLAGroupHttpResponseMessage.P(arrayList);
                    aLAGroupHttpResponseMessage.setGroupId(f.this.aye.mLiveInfo.getGroupID());
                    MessageManager.getInstance().dispatchResponsedMessage(aLAGroupHttpResponseMessage);
                    if (f.this.aTG != null && !f.this.aTG.isEmpty()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913107, f.this.aTG));
                    }
                }
            }
        }
    };
    private CustomMessageListener aTT = new CustomMessageListener(2913108) { // from class: com.baidu.live.im.f.6
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
                f.this.CU();
            }
        }
    };
    private CustomMessageListener aTU = new CustomMessageListener(2913190) { // from class: com.baidu.live.im.f.7
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
                    f.this.CU();
                } else {
                    SafeHandler.getInst().removeCallbacks(f.this.aTV);
                    SafeHandler.getInst().postDelayed(f.this.aTV, 1000L);
                }
            }
            if (TbadkCoreApplication.getInst().isTieba()) {
                if (LoginManager.getInstance(TbadkCoreApplication.getInst().getContext()).isIMLogined()) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ IM消息 贴吧直播间切前台监听 -- IM 没断，直接 join");
                    }
                    f.this.CU();
                    return;
                }
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 贴吧直播间切前台监听 -- IM 断");
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913191, null));
            }
        }
    };
    private Runnable aTV = new Runnable() { // from class: com.baidu.live.im.f.8
        @Override // java.lang.Runnable
        public void run() {
            f.this.CU();
        }
    };
    private Runnable aTW = new Runnable() { // from class: com.baidu.live.im.f.9
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (TbConfig.IM_LOG) {
                Log.d("im-debug", "imExceptionCheckRunnable: " + (currentTimeMillis - f.this.aTA));
            }
            if (currentTimeMillis - f.this.aTA >= 18000) {
                if (!f.this.aTx) {
                    f.this.aTx = true;
                    f.this.CQ();
                }
                if (f.this.aye != null && f.this.aye.isHost) {
                    f.this.CO();
                    f.this.CP();
                }
            } else if (f.this.aTx) {
                f.this.aTx = false;
                f.this.CQ();
            }
            f.this.CN();
        }
    };
    private CustomMessageTask.CustomRunnable aTX = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.im.f.10
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            String str;
            if (f.this.aye != null && f.this.aye.mLiveSdkInfo != null && f.this.aye.mLiveSdkInfo.mCastIds != null) {
                str = f.this.aye.mLiveSdkInfo.mCastIds.axC;
            } else {
                str = "0";
            }
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID, str);
        }
    };

    public static f CL() {
        if (aTu == null) {
            synchronized (f.class) {
                if (aTu == null) {
                    aTu = new f();
                }
            }
        }
        return aTu;
    }

    private f() {
    }

    public void ap(Context context) {
        this.mContext = context;
        MessageManager.getInstance().unRegisterListener(this.aTJ);
        MessageManager.getInstance().registerListener(this.aTJ);
        MessageManager.getInstance().removeMessageRule(this.aTN);
        MessageManager.getInstance().addMessageRule(this.aTN);
        MessageManager.getInstance().unRegisterListener(this.aTO);
        MessageManager.getInstance().registerListener(this.aTO);
        MessageManager.getInstance().unRegisterListener(this.aTT);
        MessageManager.getInstance().registerListener(this.aTT);
        MessageManager.getInstance().unRegisterListener(this.aTU);
        MessageManager.getInstance().registerListener(this.aTU);
        new CustomMessageTask(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID, this.aTX).setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID);
    }

    public void CM() {
        SafeHandler.getInst().removeCallbacks(this.aTV);
        SafeHandler.getInst().removeCallbacks(this.aTW);
        com.baidu.c.b.a.aA(this.mContext).Lb().CS();
        this.aTI = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CN() {
        SafeHandler.getInst().removeCallbacks(this.aTW);
        if (this.aye != null && this.aye.mLiveInfo != null) {
            SafeHandler.getInst().postDelayed(this.aTW, 18000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CO() {
        int i;
        String str;
        String str2;
        if (this.aye != null) {
            if (this.aye.mLiveSdkInfo != null && this.aye.mLiveSdkInfo.mCastIds != null) {
                this.axB = this.aye.mLiveSdkInfo.mCastIds.axB;
                String str3 = this.aye.mLiveSdkInfo.mCastIds.axD;
                this.axC = this.aye.mLiveSdkInfo.mCastIds.axC;
                String str4 = this.aye.mLiveSdkInfo.mCastIds.axF;
                i = JavaTypesHelper.toInt(this.aye.mLiveSdkInfo.mCastIds.axG, 5) * 1000;
                str = str4;
                str2 = str3;
            } else if (this.aye.mLiveInfo == null || this.aye.mLiveInfo.mCastIds == null) {
                i = 5000;
                str = "";
                str2 = "";
            } else {
                this.axB = this.aye.mLiveInfo.mCastIds.axB;
                String str5 = this.aye.mLiveInfo.mCastIds.axD;
                this.axC = this.aye.mLiveInfo.mCastIds.axC;
                String str6 = this.aye.mLiveInfo.mCastIds.axF;
                i = JavaTypesHelper.toInt(this.aye.mLiveInfo.mCastIds.axG, 5) * 1000;
                str = str6;
                str2 = str5;
            }
            a(this.axB, str2, i, false);
            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", this.axB, this.axB, 0, "", "", "");
            a(this.axC, str, i, this.aye.isHost);
            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", this.axB, this.axC, 0, "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CP() {
        if (TbConfig.IM_LOG) {
            Log.d("im-debug", "start fetch im chat castid=" + this.axB + "lastmsgid=" + this.aTC);
        }
        int i = 25;
        if (this.aTC == 0) {
            i = -25;
        }
        BIMManager.fetchMsgRequest(this.mContext, AccountManager.getAppid(this.mContext), AccountManager.getUK(this.mContext), 4, JavaTypesHelper.toLong(this.axB, -1L), this.aTC, Long.MAX_VALUE, i, 1, this.aTR);
        int i2 = 25;
        if (this.aTD == 0) {
            i2 = -25;
        }
        if (TbConfig.IM_LOG) {
            Log.d("im-debug", "start fetch im ensure castid=" + this.axC + " lastmsgid=" + this.aTD);
        }
        BIMManager.fetchMsgRequest(this.mContext, AccountManager.getAppid(this.mContext), AccountManager.getUK(this.mContext), 4, JavaTypesHelper.toLong(this.axC, -1L), this.aTD, Long.MAX_VALUE, i2, 1, this.aTR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CQ() {
        long j;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME), Long.class);
        if (runTask == null) {
            j = 0;
        } else {
            j = ((Long) runTask.getData()).longValue();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("im_state", this.aTx ? 0 : 1);
            jSONObject.put("im_chat_mcast_id", this.axB);
            jSONObject.put("im_ensure_mcast_id", this.axC);
            jSONObject.put("im_live_info_time", j);
            jSONObject.put("im_last_msg_time", this.aTA);
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
            com.baidu.c.b.a.aA(this.mContext).Lb().a(str, str2, i, new com.baidu.c.a.b.b() { // from class: com.baidu.live.im.f.18
                @Override // com.baidu.c.a.b.b
                public void onResult(int i2, long j, long j2) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ enterRoom onResult i:" + i2 + ", l:" + j + ", l1:" + j2);
                    }
                    if (f.this.aye == null || f.this.axB == null || f.this.axC == null) {
                        com.baidu.c.b.a.aA(f.this.mContext).Lb().gh(String.valueOf(j));
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.axB, String.valueOf(j), -1, "", "", "");
                        return;
                    }
                    long j3 = JavaTypesHelper.toLong(f.this.axB, -1L);
                    long j4 = JavaTypesHelper.toLong(f.this.axC, -1L);
                    if (j3 != j && j4 != j) {
                        com.baidu.c.b.a.aA(f.this.mContext).Lb().gh(String.valueOf(j));
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.axB, String.valueOf(j), -1, "", "", "");
                        if (TbConfig.IM_LOG) {
                            Log.e("imlog", "BDIM enterRoom wrong then exit end:" + j);
                            return;
                        }
                        return;
                    }
                    if (j3 == j) {
                        f.this.aTy = 0;
                    } else {
                        f.this.aTz = 0;
                    }
                    if (i2 != 0) {
                        f.this.a(j, i2, j3 == j ? f.this.aTE : f.this.aTF);
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
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_FAIL_IM_NOT_LOGIN, f.this.axB, str, -1, "", "", "");
                    } else if (i2 == 1314 || i2 == 1306) {
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_MSG_ENTER_IM_FAIL, f.this.axB, str, -1, String.valueOf(i2), "", "");
                    } else if (i2 != 0) {
                        if (j3 == j) {
                            if (f.this.aTE < 6) {
                                f.this.a(str, str2, i, z);
                                f.this.aTE++;
                                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_MSG_FAIL_TO_REJOIN, f.this.axB, str, -1, "", "", "");
                                return;
                            }
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.axB, str, -1, "", "", "");
                        } else if (f.this.aTF < 6) {
                            f.this.a(str, str2, i, z);
                            f.this.aTF++;
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_GIFT_FAIL_TO_REJOIN, f.this.axB, str, -1, "", "", "");
                        } else {
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.axB, str, -1, "", "", "");
                        }
                    } else if (j3 == j) {
                        f.this.aTE = 0;
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", f.this.axB, str, 0, "", "", "");
                        if (TbConfig.IM_LOG) {
                            Log.i("imlog", "@.@ enterRoom onResult JOIN Msg成功:" + j3);
                        }
                        if ((!f.this.aye.isHost || (f.this.aye.isHost && f.this.aye.axQ)) && f.this.aTI != j3) {
                            f.this.aTI = j3;
                            long j5 = JavaTypesHelper.toLong(str, -1L);
                            BIMManager.fetchMsgRequest(f.this.mContext, AccountManager.getAppid(f.this.mContext), AccountManager.getUK(f.this.mContext), 4, j5, 0L, Long.MAX_VALUE, -25, 1, f.this.aTQ);
                            if (TbConfig.IM_LOG) {
                                Log.i("imlog", "@.@ enterRoom fetchMsgidByMsgid:   " + j5);
                            }
                        }
                    } else {
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", f.this.axB, str, 0, "", "", "");
                        if (TbConfig.IM_LOG) {
                            Log.i("imlog", "@.@ enterRoom onResult JOIN Gift成功:" + j4);
                        }
                        f.this.aTF = 0;
                    }
                }
            }, z);
            CR();
            fu(str);
            if (TbConfig.IM_LOG) {
                Log.i("imlog", "@.@ enterRoom registerMsgReceiveListener:" + z + ", mCastId: " + str);
            }
        }
    }

    private void CR() {
        MessageManager.getInstance().unRegisterListener(this.aHo);
        MessageManager.getInstance().registerListener(this.aHo);
        MessageManager.getInstance().unRegisterListener(this.aTK);
        MessageManager.getInstance().registerListener(this.aTK);
        MessageManager.getInstance().unRegisterListener(this.aTL);
        MessageManager.getInstance().registerListener(this.aTL);
        MessageManager.getInstance().removeMessageRule(this.aTM);
        MessageManager.getInstance().addMessageRule(this.aTM);
        MessageManager.getInstance().removeMessageRule(this.aTP);
        MessageManager.getInstance().addMessageRule(this.aTP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CS() {
        SafeHandler.getInst().removeCallbacks(this.aTV);
        SafeHandler.getInst().removeCallbacks(this.aTW);
        if (this.aye != null && this.aye.mLiveSdkInfo != null && this.aye.mLiveSdkInfo.mCastIds != null) {
            String str = this.aye.mLiveSdkInfo.mCastIds.axB;
            String str2 = this.aye.mLiveSdkInfo.mCastIds.axC;
            com.baidu.c.b.a.aA(this.mContext).Lb().gh(str);
            com.baidu.c.b.a.aA(this.mContext).Lb().gh(str2);
            CV();
        }
        this.aTy = 0;
        this.aTz = 0;
        this.aTI = 0L;
        this.aye = null;
        this.axB = null;
        this.axC = null;
        this.aTE = 0;
        this.aTF = 0;
        if (this.aTG != null) {
            this.aTG.clear();
            this.aTG = null;
        }
        if (this.aTH != null) {
            this.aTH.clear();
            this.aTH = null;
        }
        this.aTB.clear();
        this.aTC = 0L;
        this.aTC = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CT() {
        MessageManager.getInstance().unRegisterListener(this.aTK);
        MessageManager.getInstance().unRegisterListener(this.aTL);
        MessageManager.getInstance().unRegisterListener(this.aHo);
        MessageManager.getInstance().removeMessageRule(this.aTM);
        MessageManager.getInstance().removeMessageRule(this.aTP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(List<AlaLiveMarkData> list) {
        if (list != null && !list.isEmpty()) {
            if (this.aTH == null) {
                this.aTH = new ArrayList();
            }
            this.aTH.clear();
            this.aTH.addAll(list);
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
        final String str2 = (this.aye == null || this.aye.mLiveSdkInfo == null || this.aye.mLiveSdkInfo.mCastIds == null) ? null : this.aye.mLiveSdkInfo.mCastIds.axB;
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.c.a.b.a.e eVar = new com.baidu.c.a.b.a.e();
            eVar.msg = content;
            eVar.bqs = str2;
            if (this.aye != null && this.aye.axI != null) {
                eVar.name = this.aye.axI.userName;
                eVar.portrait = this.aye.axI.portrait;
            }
            a aVar2 = new a();
            if (this.aye != null) {
                if (this.aye.isHost) {
                    alaLiveUserInfoData = this.aye.axp;
                } else {
                    alaLiveUserInfoData = this.aye.axI;
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
                    aVar3.awy = alaLiveUserInfoData.followCount;
                    aVar3.awx = alaLiveUserInfoData.fansCount;
                    aVar3.awB = alaLiveUserInfoData.isAdmin == 1;
                    aVar3.awA = alaLiveUserInfoData.isOfficial == 1;
                    aVar3.level_id = alaLiveUserInfoData.levelId;
                    aVar3.awD = this.aTH;
                    aVar3.sex = alaLiveUserInfoData.sex;
                    aVar3.extraUserInfo = alaLiveUserInfoData.extraUserInfo;
                    aVar2.e(aVar3);
                    aVar2.setContent(content);
                    aVar2.setMsgType(aVar.Eo());
                    aVar2.cB(aVar.Eh());
                    aVar2.fx(aVar.Ei());
                    aVar2.a(aVar.Ej());
                    aVar2.k(aVar.Ek());
                    aVar2.setUserId(alaLiveUserInfoData.userId);
                    aVar2.fr(String.valueOf(this.aye.mLiveInfo.user_id));
                    aVar2.setBornTime(System.currentTimeMillis());
                    str = aVar2.Cq();
                }
            }
            eVar.bqI = str;
            com.baidu.c.a.b.a.f fVar = new com.baidu.c.a.b.a.f() { // from class: com.baidu.live.im.f.2
                @Override // com.baidu.c.a.b.a.f
                public void a(String str3, int i, List<com.baidu.c.a.b.a.c> list) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ IM消息 onSendSuccess s:" + str3 + ", i:" + i);
                    }
                    if (f.this.aye != null && f.this.axB != null && f.this.axC != null) {
                        if (TextUtils.equals(str3, f.this.axB) || TextUtils.equals(str3, f.this.axC)) {
                            ALAGroupCommitHttpResponsedMessage aLAGroupCommitHttpResponsedMessage = new ALAGroupCommitHttpResponsedMessage();
                            aLAGroupCommitHttpResponsedMessage.setStatusCode(200, null);
                            if (f.this.aye.mLiveInfo != null) {
                                f.this.a(aVar, i, str2, list);
                            }
                            aLAGroupCommitHttpResponsedMessage.setError(i);
                            if (i == 0) {
                                f.this.K(list);
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
                            if (com.baidu.live.liveroom.a.Fp().Fq()) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913093));
                            }
                        }
                    }
                }
            };
            ar(content, str2);
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
            com.baidu.c.b.a.aA(this.mContext).Lb().a(str2, eVar, fVar);
            if (TbConfig.IM_LOG) {
                Log.i("imlog", "@.@ IM消息 发送 roomId:" + str2 + ", sendMessage:" + eVar.toString());
            }
        }
    }

    private void ar(String str, String str2) {
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
            alaStaticItem.addParams("live_id", this.aye.mLiveInfo.live_id + "");
            alaStaticItem.addParams("room_id", this.aye.mLiveInfo.room_id + "");
            alaStaticItem.addParams("feed_id", this.aye.mLiveInfo.feed_id + "");
            alaStaticItem.addParams("other_params", aVar.Ep());
            if (aVar.Eo() == 126) {
                alaStaticItem.addParams("gifts_value", String.valueOf(aVar.Eq()));
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SUC_SEND_NEWS);
            alaStaticItem2.addParams("live_id", this.aye.mLiveInfo.live_id + "");
            alaStaticItem2.addParams("room_id", this.aye.mLiveInfo.room_id + "");
            alaStaticItem2.addParams("feed_id", this.aye.mLiveInfo.feed_id + "");
            alaStaticItem2.addParams("other_params", aVar.Ep());
            if (aVar.Eo() == 126) {
                alaStaticItem2.addParams("gifts_value", String.valueOf(aVar.Eq()));
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem2);
        }
        if (aVar.Eo() == 126) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", "liveroom", "msg_send").setContentExt("barrage", null, null));
        } else if (aVar.Er()) {
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
    public void K(List<com.baidu.c.a.b.a.c> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.c.a.b.a.c cVar : list) {
                if (cVar != null) {
                    String str = "";
                    if (!TextUtils.isEmpty(cVar.bqs)) {
                        str = cVar.bqs;
                    } else if (cVar.bqH != null && cVar.bqH.bqV != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(cVar.bqH.bqV);
                            if (!TextUtils.isEmpty(jSONObject.optString("room_id"))) {
                                str = jSONObject.optString("room_id");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    if (TextUtils.isEmpty(str) || TextUtils.equals(str, this.axB) || TextUtils.equals(str, this.axC)) {
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
                this.aTS.e(z ? aTv : aTw, arrayList2);
            }
        }
    }

    private void fu(String str) {
        com.baidu.c.b.a.aA(this.mContext).Lb().a(str, this.aTS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fv(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("im_worng_mcastid", str);
            jSONObject.put("im_wrong_msgs", 1);
            jSONObject.put("im_chat_mcast_id", this.axB);
            jSONObject.put("im_ensure_mcast_id", this.axC);
            a(jSONObject, (JSONObject) null, "1537", UbcStatConstant.ContentType.UBC_TYPE_IM_WRONG_ID, (String) null);
        } catch (JSONException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CU() {
        if (this.aye != null && this.aye.mLiveSdkInfo != null && this.aye.mLiveSdkInfo.mCastIds != null) {
            this.aTE = 0;
            this.aTF = 0;
            this.axB = this.aye.mLiveSdkInfo.mCastIds.axB;
            String str = this.aye.mLiveSdkInfo.mCastIds.axD;
            this.axC = this.aye.mLiveSdkInfo.mCastIds.axC;
            String str2 = this.aye.mLiveSdkInfo.mCastIds.axF;
            int i = JavaTypesHelper.toInt(this.aye.mLiveSdkInfo.mCastIds.axG, 5) * 1000;
            a(this.axB, str, i, false);
            a(this.axC, str2, i, this.aye.isHost);
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

    private void CV() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("im_chat_mcast_id", this.axB);
            jSONObject.put("im_ensure_mcast_id", this.axC);
            jSONObject.put("im_chat_mcast_count", this.aTy);
            jSONObject.put("im_ensure_mcast_count", this.aTz);
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
        if (this.aye != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            if (TbConfig.IM_LOG) {
                Log.i("imUbclog", "Json: " + jSONObject.toString() + "  type: " + str2 + " isHost: " + this.aye.isHost);
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
            UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(str, str2, this.aye.isHost ? UbcStatConstant.Page.AUTHOR_LIVE_ROOM : "liveroom", str3);
            ubcStatisticItem.setContentExt(jSONObject3);
            UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
        }
    }
}
