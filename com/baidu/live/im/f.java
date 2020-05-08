package com.baidu.live.im;

import android.content.Context;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
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
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.im.message.ALAGroupCommitHttpResponsedMessage;
import com.baidu.live.im.message.ALAGroupHttpResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.extraparams.interfaces.IExtraParams;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticKeys;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.swan.games.utils.so.SoUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {
    private static volatile f aLa = null;
    private static int aLb = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private List<String> aLe;
    private List<AlaLiveMarkData> aLf;
    private long aLg;
    private com.baidu.live.data.n aqW;
    private String aqw;
    private String aqx;
    private Context mContext;
    private int aLc = 0;
    private int aLd = 0;
    private CustomMessageListener aLh = new CustomMessageListener(2913081) { // from class: com.baidu.live.im.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.data.n nVar;
            int i;
            String str;
            String str2;
            if (customResponsedMessage.hasError() || customResponsedMessage.getError() != 0 || com.baidu.c.b.a.ap(f.this.mContext).HZ() == null || !(customResponsedMessage.getData() instanceof com.baidu.live.data.n) || (nVar = (com.baidu.live.data.n) customResponsedMessage.getData()) == null) {
                return;
            }
            if ((nVar.mLiveSdkInfo != null && nVar.mLiveSdkInfo.mCastIds != null) || (nVar.mLiveInfo != null && nVar.mLiveInfo.mCastIds != null)) {
                if (nVar.mLiveInfo == null || nVar.mLiveInfo.live_status != 2) {
                    f.this.aqW = nVar;
                    f.this.F(f.this.aqW.aqI);
                    if (nVar.mLiveSdkInfo != null && nVar.mLiveSdkInfo.mCastIds != null) {
                        f.this.aqw = f.this.aqW.mLiveSdkInfo.mCastIds.aqw;
                        String str3 = f.this.aqW.mLiveSdkInfo.mCastIds.aqy;
                        f.this.aqx = f.this.aqW.mLiveSdkInfo.mCastIds.aqx;
                        String str4 = f.this.aqW.mLiveSdkInfo.mCastIds.aqA;
                        i = JavaTypesHelper.toInt(f.this.aqW.mLiveSdkInfo.mCastIds.aqB, 5) * 1000;
                        str = str4;
                        str2 = str3;
                    } else if (nVar.mLiveInfo != null && nVar.mLiveInfo.mCastIds != null) {
                        f.this.aqw = f.this.aqW.mLiveInfo.mCastIds.aqw;
                        String str5 = f.this.aqW.mLiveInfo.mCastIds.aqy;
                        f.this.aqx = f.this.aqW.mLiveInfo.mCastIds.aqx;
                        String str6 = f.this.aqW.mLiveInfo.mCastIds.aqA;
                        i = JavaTypesHelper.toInt(f.this.aqW.mLiveInfo.mCastIds.aqB, 5) * 1000;
                        str = str6;
                        str2 = str5;
                    } else {
                        i = 5000;
                        str = "";
                        str2 = "";
                    }
                    f.this.a(f.this.aqw, str2, i, false);
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", f.this.aqw, f.this.aqw, 0, "", "", "");
                    f.this.a(f.this.aqx, str, i, nVar.isHost);
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", f.this.aqw, f.this.aqx, 0, "", "", "");
                }
            }
        }
    };
    private CustomMessageListener aLi = new CustomMessageListener(2913082) { // from class: com.baidu.live.im.f.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof com.baidu.live.data.n)) {
                f.this.aqW = (com.baidu.live.data.n) customResponsedMessage.getData();
                f.this.F(f.this.aqW.aqI);
            }
        }
    };
    private CustomMessageListener aLj = new CustomMessageListener(2913118) { // from class: com.baidu.live.im.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof com.baidu.live.data.n)) {
                f.this.F(((com.baidu.live.data.n) customResponsedMessage.getData()).aqI);
            }
        }
    };
    private HttpRule aLk = new HttpRule(1021013) { // from class: com.baidu.live.im.f.10
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
    private HttpRule aLl = new HttpRule(1021012) { // from class: com.baidu.live.im.f.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            return null;
        }
    };
    CustomMessageListener aLm = new CustomMessageListener(2913084) { // from class: com.baidu.live.im.f.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.AW();
        }
    };
    CustomMessageListener azA = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.im.f.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.AY();
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.im.f.13.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.AZ();
                }
            });
        }
    };
    private HttpRule aLn = new HttpRule(1021006) { // from class: com.baidu.live.im.f.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            f.this.AY();
            if (f.this.aqW != null && f.this.aqW.mLiveSdkInfo != null && f.this.aqW.mLiveSdkInfo.mCastIds != null) {
                String str = f.this.aqW.mLiveSdkInfo.mCastIds.aqw;
                String str2 = f.this.aqW.mLiveSdkInfo.mCastIds.aqx;
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str, -1, "", "", "");
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str2, -1, "", "", "");
            }
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.im.f.14.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.AZ();
                }
            });
            return httpMessage;
        }
    };
    private IFetchMsgByIdListener aLo = new IFetchMsgByIdListener() { // from class: com.baidu.live.im.f.3
        @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
        public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList) {
            f.this.b(i, arrayList);
        }
    };
    private com.baidu.c.a.b.a.d aLp = new com.baidu.c.a.b.a.d() { // from class: com.baidu.live.im.f.4
        @Override // com.baidu.c.a.b.a.d
        public void e(int i, List<com.baidu.c.a.b.a.c> list) {
            if (f.this.aqW != null && f.this.aqw != null && f.this.aqx != null && f.this.aqW.mLiveInfo != null) {
                if (i == 0 || i == f.aLb) {
                    ALAGroupHttpResponseMessage aLAGroupHttpResponseMessage = new ALAGroupHttpResponseMessage();
                    ArrayList arrayList = new ArrayList();
                    if (f.this.aLe != null) {
                        f.this.aLe.clear();
                    }
                    for (com.baidu.c.a.b.a.c cVar : list) {
                        if (cVar != null) {
                            String str = "";
                            String str2 = "";
                            if (!TextUtils.isEmpty(cVar.bdP)) {
                                str = cVar.bdP;
                            } else if (cVar.bee != null && cVar.bee.beu != null) {
                                try {
                                    JSONObject jSONObject = new JSONObject(cVar.bee.beu);
                                    if (!TextUtils.isEmpty(jSONObject.optString("room_id"))) {
                                        str = jSONObject.optString("room_id");
                                    }
                                    str2 = jSONObject.optString("msg_type");
                                    if (TextUtils.isEmpty(str2)) {
                                        str2 = jSONObject.optString("msgType");
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            if (TextUtils.isEmpty(str) || TextUtils.equals(str, f.this.aqw) || TextUtils.equals(str, f.this.aqx)) {
                                if (!TextUtils.equals(cVar.type, "0") || !TextUtils.isEmpty(str)) {
                                    if (!TextUtils.isEmpty(str) || !TextUtils.equals(str2, SoUtils.SO_EVENT_ID_DEFAULT)) {
                                        if (i == f.aLb) {
                                            String str3 = "";
                                            if (!TextUtils.isEmpty(cVar.bef)) {
                                                try {
                                                    JSONObject jSONObject2 = new JSONObject(cVar.bef);
                                                    str3 = jSONObject2.optString("msgType");
                                                    if (TextUtils.isEmpty(str3)) {
                                                        str3 = jSONObject2.optString("msg_type");
                                                    }
                                                } catch (JSONException e2) {
                                                    e2.printStackTrace();
                                                }
                                            }
                                            if (TextUtils.equals(cVar.type, "0") && TextUtils.equals(str3, "1")) {
                                            }
                                        }
                                        List<a> a = r.a(cVar);
                                        if (a != null) {
                                            if (TextUtils.equals(cVar.type, "0")) {
                                                for (int i2 = 0; i2 < a.size(); i2++) {
                                                    a aVar = a.get(i2);
                                                    if (aVar.Ce() != null && (!TextUtils.isEmpty(aVar.Ce().name_show) || !TextUtils.isEmpty(aVar.Ce().userName))) {
                                                        arrayList.add(aVar);
                                                    }
                                                }
                                            } else {
                                                arrayList.addAll(a);
                                            }
                                            if (i == 0 && cVar.bee != null && !TextUtils.isEmpty(cVar.bee.beu)) {
                                                if (f.this.aLe == null) {
                                                    f.this.aLe = new ArrayList();
                                                }
                                                f.this.aLe.add(cVar.bee.beu);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        aLAGroupHttpResponseMessage.bz(i == f.aLb);
                        aLAGroupHttpResponseMessage.K(arrayList);
                        aLAGroupHttpResponseMessage.setGroupId(f.this.aqW.mLiveInfo.getGroupID());
                        MessageManager.getInstance().dispatchResponsedMessage(aLAGroupHttpResponseMessage);
                        if (f.this.aLe != null && !f.this.aLe.isEmpty()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913107, f.this.aLe));
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener aLq = new CustomMessageListener(2913108) { // from class: com.baidu.live.im.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                f.this.Ba();
            }
        }
    };
    private CustomMessageListener aLr = new CustomMessageListener(2913190) { // from class: com.baidu.live.im.f.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                if (TbadkCoreApplication.getInst().isMobileBaidu() && LoginManager.getInstance(TbadkCoreApplication.getInst().getContext()).isIMLogined()) {
                    f.this.Ba();
                }
                if (TbadkCoreApplication.getInst().isTieba()) {
                    if (LoginManager.getInstance(TbadkCoreApplication.getInst().getContext()).isIMLogined()) {
                        f.this.Ba();
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913191, null));
                    }
                }
            }
        }
    };
    private CustomMessageTask.CustomRunnable aLs = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.im.f.7
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            String str;
            if (f.this.aqW != null && f.this.aqW.mLiveSdkInfo != null && f.this.aqW.mLiveSdkInfo.mCastIds != null) {
                str = f.this.aqW.mLiveSdkInfo.mCastIds.aqx;
            } else {
                str = "0";
            }
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID, str);
        }
    };

    public static f AV() {
        if (aLa == null) {
            synchronized (f.class) {
                if (aLa == null) {
                    aLa = new f();
                }
            }
        }
        return aLa;
    }

    private f() {
    }

    public void ae(Context context) {
        this.mContext = context;
        MessageManager.getInstance().unRegisterListener(this.aLh);
        MessageManager.getInstance().registerListener(this.aLh);
        MessageManager.getInstance().removeMessageRule(this.aLl);
        MessageManager.getInstance().addMessageRule(this.aLl);
        MessageManager.getInstance().unRegisterListener(this.aLm);
        MessageManager.getInstance().registerListener(this.aLm);
        MessageManager.getInstance().unRegisterListener(this.aLq);
        MessageManager.getInstance().registerListener(this.aLq);
        MessageManager.getInstance().unRegisterListener(this.aLr);
        MessageManager.getInstance().registerListener(this.aLr);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID, this.aLs);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void AW() {
        com.baidu.c.b.a.ap(this.mContext).HZ().AY();
        this.aLg = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final String str2, final int i, final boolean z) {
        if (TbConfig.IM_LOG) {
            Log.i("imlog", "@.@ enterRoom roomid:" + str + ", url:" + str2);
        }
        com.baidu.c.b.a.ap(this.mContext).HZ().a(str, str2, i, new com.baidu.c.a.b.b() { // from class: com.baidu.live.im.f.15
            @Override // com.baidu.c.a.b.b
            public void onResult(int i2, long j, long j2) {
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ enterRoom onResult i:" + i2 + ", l:" + j + ", l1:" + j2);
                }
                if (f.this.aqW == null || f.this.aqw == null || f.this.aqx == null) {
                    com.baidu.c.b.a.ap(f.this.mContext).HZ().fn(String.valueOf(j));
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.aqw, String.valueOf(j), -1, "", "", "");
                    return;
                }
                long j3 = JavaTypesHelper.toLong(f.this.aqw, -1L);
                long j4 = JavaTypesHelper.toLong(f.this.aqx, -1L);
                if (j3 != j && j4 != j) {
                    com.baidu.c.b.a.ap(f.this.mContext).HZ().fn(String.valueOf(j));
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.aqw, String.valueOf(j), -1, "", "", "");
                    if (TbConfig.IM_LOG) {
                        Log.e("imlog", "BDIM enterRoom wrong then exit end:" + j);
                    }
                } else if (i2 == 1000) {
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
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_FAIL_IM_NOT_LOGIN, f.this.aqw, str, -1, "", "", "");
                } else if (i2 == 1314 || i2 == 1306) {
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_MSG_ENTER_IM_FAIL, f.this.aqw, str, -1, String.valueOf(i2), "", "");
                } else if (i2 != 0) {
                    if (j3 == j) {
                        if (f.this.aLc < 3) {
                            f.this.a(str, str2, i, z);
                            f.this.aLc++;
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_MSG_FAIL_TO_REJOIN, f.this.aqw, str, -1, "", "", "");
                            return;
                        }
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.aqw, str, -1, "", "", "");
                    } else if (f.this.aLd < 3) {
                        f.this.a(str, str2, i, z);
                        f.this.aLd++;
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_GIFT_FAIL_TO_REJOIN, f.this.aqw, str, -1, "", "", "");
                    } else {
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.aqw, str, -1, "", "", "");
                    }
                } else if (j3 == j) {
                    f.this.aLc = 0;
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", f.this.aqw, str, 0, "", "", "");
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ enterRoom onResult JOIN Msg成功:" + j3);
                    }
                    if ((!f.this.aqW.isHost || (f.this.aqW.isHost && f.this.aqW.aqL)) && f.this.aLg != j3) {
                        f.this.aLg = j3;
                        ChatMsgManagerImpl.getInstance(f.this.mContext).fetchMsgidByMsgid(f.this.mContext, 4, JavaTypesHelper.toLong(str, -1L), 0L, Long.MAX_VALUE, -25, 1, 0, f.this.aLo);
                    }
                } else {
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", f.this.aqw, str, 0, "", "", "");
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ enterRoom onResult JOIN Gift成功:" + j4);
                    }
                    f.this.aLd = 0;
                }
            }
        }, z);
        AX();
        eD(str);
    }

    private void AX() {
        MessageManager.getInstance().unRegisterListener(this.azA);
        MessageManager.getInstance().registerListener(this.azA);
        MessageManager.getInstance().unRegisterListener(this.aLi);
        MessageManager.getInstance().registerListener(this.aLi);
        MessageManager.getInstance().unRegisterListener(this.aLj);
        MessageManager.getInstance().registerListener(this.aLj);
        MessageManager.getInstance().removeMessageRule(this.aLk);
        MessageManager.getInstance().addMessageRule(this.aLk);
        MessageManager.getInstance().removeMessageRule(this.aLn);
        MessageManager.getInstance().addMessageRule(this.aLn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AY() {
        if (this.aqW != null && this.aqW.mLiveSdkInfo != null && this.aqW.mLiveSdkInfo.mCastIds != null) {
            String str = this.aqW.mLiveSdkInfo.mCastIds.aqw;
            String str2 = this.aqW.mLiveSdkInfo.mCastIds.aqx;
            com.baidu.c.b.a.ap(this.mContext).HZ().fn(str);
            com.baidu.c.b.a.ap(this.mContext).HZ().fn(str2);
        }
        this.aLg = 0L;
        this.aqW = null;
        this.aqw = null;
        this.aqx = null;
        this.aLc = 0;
        this.aLd = 0;
        if (this.aLe != null) {
            this.aLe.clear();
            this.aLe = null;
        }
        if (this.aLf != null) {
            this.aLf.clear();
            this.aLf = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AZ() {
        MessageManager.getInstance().unRegisterListener(this.aLi);
        MessageManager.getInstance().unRegisterListener(this.aLj);
        MessageManager.getInstance().unRegisterListener(this.azA);
        MessageManager.getInstance().removeMessageRule(this.aLk);
        MessageManager.getInstance().removeMessageRule(this.aLn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(List<AlaLiveMarkData> list) {
        if (list != null && !list.isEmpty()) {
            if (this.aLf == null) {
                this.aLf = new ArrayList();
            }
            this.aLf.clear();
            this.aLf.addAll(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.live.im.message.a aVar) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        String str = null;
        String content = aVar.getContent();
        String str2 = (this.aqW == null || this.aqW.mLiveSdkInfo == null || this.aqW.mLiveSdkInfo.mCastIds == null) ? null : this.aqW.mLiveSdkInfo.mCastIds.aqw;
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.c.a.b.a.e eVar = new com.baidu.c.a.b.a.e();
            eVar.msg = content;
            eVar.bdP = str2;
            if (this.aqW != null && this.aqW.aqD != null) {
                eVar.name = this.aqW.aqD.userName;
                eVar.portrait = this.aqW.aqD.portrait;
            }
            a aVar2 = new a();
            if (this.aqW != null) {
                if (this.aqW.isHost) {
                    alaLiveUserInfoData = this.aqW.aqk;
                } else {
                    alaLiveUserInfoData = this.aqW.aqD;
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
                    aVar3.apz = alaLiveUserInfoData.followCount;
                    aVar3.apy = alaLiveUserInfoData.fansCount;
                    aVar3.apC = alaLiveUserInfoData.isAdmin == 1;
                    aVar3.apB = alaLiveUserInfoData.isOfficial == 1;
                    aVar3.level_id = alaLiveUserInfoData.levelId;
                    aVar3.apE = this.aLf;
                    aVar3.sex = alaLiveUserInfoData.sex;
                    aVar3.extraUserInfo = alaLiveUserInfoData.extraUserInfo;
                    aVar2.d(aVar3);
                    aVar2.setContent(content);
                    aVar2.setMsgType(aVar.Cp());
                    aVar2.cm(aVar.Ci());
                    aVar2.eF(aVar.Cj());
                    aVar2.a(aVar.Ck());
                    aVar2.l(aVar.Cl());
                    aVar2.setUserId(alaLiveUserInfoData.userId);
                    aVar2.eA(String.valueOf(this.aqW.mLiveInfo.user_id));
                    aVar2.setBornTime(System.currentTimeMillis());
                    str = aVar2.AA();
                }
            }
            eVar.bef = str;
            com.baidu.c.a.b.a.f fVar = new com.baidu.c.a.b.a.f() { // from class: com.baidu.live.im.f.2
                @Override // com.baidu.c.a.b.a.f
                public void a(String str3, int i, List<com.baidu.c.a.b.a.c> list) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ IM消息 onSendSuccess s:" + str3 + ", i:" + i);
                    }
                    if (f.this.aqW != null && f.this.aqw != null && f.this.aqx != null) {
                        if (TextUtils.equals(str3, f.this.aqw) || TextUtils.equals(str3, f.this.aqx)) {
                            ALAGroupCommitHttpResponsedMessage aLAGroupCommitHttpResponsedMessage = new ALAGroupCommitHttpResponsedMessage();
                            aLAGroupCommitHttpResponsedMessage.setStatusCode(200, null);
                            if (f.this.aqW.mLiveInfo != null) {
                                f.this.b(aVar);
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
                            if (com.baidu.live.liveroom.a.Dk().Dl()) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913093));
                            }
                        }
                    }
                }
            };
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
            com.baidu.c.b.a.ap(this.mContext).HZ().a(str2, eVar, fVar);
            if (TbConfig.IM_LOG) {
                Log.i("imlog", "@.@ IM消息 发送 roomId:" + str2 + ", sendMessage:" + eVar.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.live.im.message.a aVar) {
        if (TbadkCoreApplication.getInst().isHaokan()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SUC_SEND_NEWS);
            alaStaticItem.addParams("live_id", this.aqW.mLiveInfo.live_id + "");
            alaStaticItem.addParams("room_id", this.aqW.mLiveInfo.room_id + "");
            alaStaticItem.addParams("feed_id", this.aqW.mLiveInfo.feed_id + "");
            alaStaticItem.addParams("other_params", aVar.Cq());
            if (aVar.Cp() == 126) {
                alaStaticItem.addParams("gifts_value", String.valueOf(aVar.Cr()));
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SUC_SEND_NEWS);
            alaStaticItem2.addParams("live_id", this.aqW.mLiveInfo.live_id + "");
            alaStaticItem2.addParams("room_id", this.aqW.mLiveInfo.room_id + "");
            alaStaticItem2.addParams("feed_id", this.aqW.mLiveInfo.feed_id + "");
            alaStaticItem2.addParams("other_params", aVar.Cq());
            if (aVar.Cp() == 126) {
                alaStaticItem2.addParams("gifts_value", String.valueOf(aVar.Cr()));
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem2);
        }
        if (aVar.Cp() == 126) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1395", "click", "liveroom", "msg_send").setContentExt("barrage", null, null));
        } else if (aVar.Cs()) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1395", "click", "liveroom", "msg_send").setContentExt("fastkey", null, null));
        } else {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1395", "click", "liveroom", "msg_send").setContentExt("manual", null, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(List<com.baidu.c.a.b.a.c> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.c.a.b.a.c cVar : list) {
                if (cVar != null) {
                    String str = "";
                    if (!TextUtils.isEmpty(cVar.bdP)) {
                        str = cVar.bdP;
                    } else if (cVar.bee != null && cVar.bee.beu != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(cVar.bee.beu);
                            if (!TextUtils.isEmpty(jSONObject.optString("room_id"))) {
                                str = jSONObject.optString("room_id");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    if (TextUtils.isEmpty(str) || TextUtils.equals(str, this.aqw) || TextUtils.equals(str, this.aqx)) {
                        List<a> a = r.a(cVar);
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
    public void b(int i, ArrayList<ChatMsg> arrayList) {
        if (i == 0 && arrayList != null && arrayList.size() > 0) {
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
                this.aLp.e(aLb, arrayList2);
            }
        }
    }

    private void eD(String str) {
        com.baidu.c.b.a.ap(this.mContext).HZ().a(str, this.aLp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ba() {
        if (this.aqW != null && this.aqW.mLiveSdkInfo != null && this.aqW.mLiveSdkInfo.mCastIds != null) {
            this.aLc = 0;
            this.aLd = 0;
            this.aqw = this.aqW.mLiveSdkInfo.mCastIds.aqw;
            String str = this.aqW.mLiveSdkInfo.mCastIds.aqy;
            this.aqx = this.aqW.mLiveSdkInfo.mCastIds.aqx;
            String str2 = this.aqW.mLiveSdkInfo.mCastIds.aqA;
            int i = JavaTypesHelper.toInt(this.aqW.mLiveSdkInfo.mCastIds.aqB, 5) * 1000;
            a(this.aqw, str, i, false);
            a(this.aqx, str2, i, this.aqW.isHost);
        }
    }
}
