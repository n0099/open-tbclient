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
    private static volatile f aKU = null;
    private static int aKV = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private List<String> aKY;
    private List<AlaLiveMarkData> aKZ;
    private long aLa;
    private com.baidu.live.data.n aqQ;
    private String aqq;
    private String aqr;
    private Context mContext;
    private int aKW = 0;
    private int aKX = 0;
    private CustomMessageListener aLb = new CustomMessageListener(2913081) { // from class: com.baidu.live.im.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.data.n nVar;
            int i;
            String str;
            String str2;
            if (customResponsedMessage.hasError() || customResponsedMessage.getError() != 0 || com.baidu.c.b.a.aB(f.this.mContext).Ia() == null || !(customResponsedMessage.getData() instanceof com.baidu.live.data.n) || (nVar = (com.baidu.live.data.n) customResponsedMessage.getData()) == null) {
                return;
            }
            if ((nVar.mLiveSdkInfo != null && nVar.mLiveSdkInfo.mCastIds != null) || (nVar.mLiveInfo != null && nVar.mLiveInfo.mCastIds != null)) {
                if (nVar.mLiveInfo == null || nVar.mLiveInfo.live_status != 2) {
                    f.this.aqQ = nVar;
                    f.this.F(f.this.aqQ.aqC);
                    if (nVar.mLiveSdkInfo != null && nVar.mLiveSdkInfo.mCastIds != null) {
                        f.this.aqq = f.this.aqQ.mLiveSdkInfo.mCastIds.aqq;
                        String str3 = f.this.aqQ.mLiveSdkInfo.mCastIds.aqs;
                        f.this.aqr = f.this.aqQ.mLiveSdkInfo.mCastIds.aqr;
                        String str4 = f.this.aqQ.mLiveSdkInfo.mCastIds.aqu;
                        i = JavaTypesHelper.toInt(f.this.aqQ.mLiveSdkInfo.mCastIds.aqv, 5) * 1000;
                        str = str4;
                        str2 = str3;
                    } else if (nVar.mLiveInfo != null && nVar.mLiveInfo.mCastIds != null) {
                        f.this.aqq = f.this.aqQ.mLiveInfo.mCastIds.aqq;
                        String str5 = f.this.aqQ.mLiveInfo.mCastIds.aqs;
                        f.this.aqr = f.this.aqQ.mLiveInfo.mCastIds.aqr;
                        String str6 = f.this.aqQ.mLiveInfo.mCastIds.aqu;
                        i = JavaTypesHelper.toInt(f.this.aqQ.mLiveInfo.mCastIds.aqv, 5) * 1000;
                        str = str6;
                        str2 = str5;
                    } else {
                        i = 5000;
                        str = "";
                        str2 = "";
                    }
                    f.this.a(f.this.aqq, str2, i, false);
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", f.this.aqq, f.this.aqq, 0, "", "", "");
                    f.this.a(f.this.aqr, str, i, nVar.isHost);
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", f.this.aqq, f.this.aqr, 0, "", "", "");
                }
            }
        }
    };
    private CustomMessageListener aLc = new CustomMessageListener(2913082) { // from class: com.baidu.live.im.f.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof com.baidu.live.data.n)) {
                f.this.aqQ = (com.baidu.live.data.n) customResponsedMessage.getData();
                f.this.F(f.this.aqQ.aqC);
            }
        }
    };
    private CustomMessageListener aLd = new CustomMessageListener(2913118) { // from class: com.baidu.live.im.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof com.baidu.live.data.n)) {
                f.this.F(((com.baidu.live.data.n) customResponsedMessage.getData()).aqC);
            }
        }
    };
    private HttpRule aLe = new HttpRule(1021013) { // from class: com.baidu.live.im.f.10
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
    private HttpRule aLf = new HttpRule(1021012) { // from class: com.baidu.live.im.f.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            return null;
        }
    };
    CustomMessageListener aLg = new CustomMessageListener(2913084) { // from class: com.baidu.live.im.f.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.AX();
        }
    };
    CustomMessageListener azu = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.im.f.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.AZ();
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.im.f.13.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.Ba();
                }
            });
        }
    };
    private HttpRule aLh = new HttpRule(1021006) { // from class: com.baidu.live.im.f.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            f.this.AZ();
            if (f.this.aqQ != null && f.this.aqQ.mLiveSdkInfo != null && f.this.aqQ.mLiveSdkInfo.mCastIds != null) {
                String str = f.this.aqQ.mLiveSdkInfo.mCastIds.aqq;
                String str2 = f.this.aqQ.mLiveSdkInfo.mCastIds.aqr;
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str, -1, "", "", "");
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str2, -1, "", "", "");
            }
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.im.f.14.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.Ba();
                }
            });
            return httpMessage;
        }
    };
    private IFetchMsgByIdListener aLi = new IFetchMsgByIdListener() { // from class: com.baidu.live.im.f.3
        @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
        public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList) {
            f.this.b(i, arrayList);
        }
    };
    private com.baidu.c.a.b.a.d aLj = new com.baidu.c.a.b.a.d() { // from class: com.baidu.live.im.f.4
        @Override // com.baidu.c.a.b.a.d
        public void e(int i, List<com.baidu.c.a.b.a.c> list) {
            if (f.this.aqQ != null && f.this.aqq != null && f.this.aqr != null && f.this.aqQ.mLiveInfo != null) {
                if (i == 0 || i == f.aKV) {
                    ALAGroupHttpResponseMessage aLAGroupHttpResponseMessage = new ALAGroupHttpResponseMessage();
                    ArrayList arrayList = new ArrayList();
                    if (f.this.aKY != null) {
                        f.this.aKY.clear();
                    }
                    for (com.baidu.c.a.b.a.c cVar : list) {
                        if (cVar != null) {
                            String str = "";
                            String str2 = "";
                            if (!TextUtils.isEmpty(cVar.bdK)) {
                                str = cVar.bdK;
                            } else if (cVar.bdZ != null && cVar.bdZ.beo != null) {
                                try {
                                    JSONObject jSONObject = new JSONObject(cVar.bdZ.beo);
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
                            if (TextUtils.isEmpty(str) || TextUtils.equals(str, f.this.aqq) || TextUtils.equals(str, f.this.aqr)) {
                                if (!TextUtils.equals(cVar.type, "0") || !TextUtils.isEmpty(str)) {
                                    if (!TextUtils.isEmpty(str) || !TextUtils.equals(str2, SoUtils.SO_EVENT_ID_DEFAULT)) {
                                        if (i == f.aKV) {
                                            String str3 = "";
                                            if (!TextUtils.isEmpty(cVar.bea)) {
                                                try {
                                                    JSONObject jSONObject2 = new JSONObject(cVar.bea);
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
                                                    if (aVar.Cf() != null && (!TextUtils.isEmpty(aVar.Cf().name_show) || !TextUtils.isEmpty(aVar.Cf().userName))) {
                                                        arrayList.add(aVar);
                                                    }
                                                }
                                            } else {
                                                arrayList.addAll(a);
                                            }
                                            if (i == 0 && cVar.bdZ != null && !TextUtils.isEmpty(cVar.bdZ.beo)) {
                                                if (f.this.aKY == null) {
                                                    f.this.aKY = new ArrayList();
                                                }
                                                f.this.aKY.add(cVar.bdZ.beo);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        aLAGroupHttpResponseMessage.bz(i == f.aKV);
                        aLAGroupHttpResponseMessage.K(arrayList);
                        aLAGroupHttpResponseMessage.setGroupId(f.this.aqQ.mLiveInfo.getGroupID());
                        MessageManager.getInstance().dispatchResponsedMessage(aLAGroupHttpResponseMessage);
                        if (f.this.aKY != null && !f.this.aKY.isEmpty()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913107, f.this.aKY));
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener aLk = new CustomMessageListener(2913108) { // from class: com.baidu.live.im.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                f.this.Bb();
            }
        }
    };
    private CustomMessageListener aLl = new CustomMessageListener(2913190) { // from class: com.baidu.live.im.f.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                if (TbadkCoreApplication.getInst().isMobileBaidu() && LoginManager.getInstance(TbadkCoreApplication.getInst().getContext()).isIMLogined()) {
                    f.this.Bb();
                }
                if (TbadkCoreApplication.getInst().isTieba()) {
                    if (LoginManager.getInstance(TbadkCoreApplication.getInst().getContext()).isIMLogined()) {
                        f.this.Bb();
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913191, null));
                    }
                }
            }
        }
    };
    private CustomMessageTask.CustomRunnable aLm = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.im.f.7
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            String str;
            if (f.this.aqQ != null && f.this.aqQ.mLiveSdkInfo != null && f.this.aqQ.mLiveSdkInfo.mCastIds != null) {
                str = f.this.aqQ.mLiveSdkInfo.mCastIds.aqr;
            } else {
                str = "0";
            }
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID, str);
        }
    };

    public static f AW() {
        if (aKU == null) {
            synchronized (f.class) {
                if (aKU == null) {
                    aKU = new f();
                }
            }
        }
        return aKU;
    }

    private f() {
    }

    public void aq(Context context) {
        this.mContext = context;
        MessageManager.getInstance().unRegisterListener(this.aLb);
        MessageManager.getInstance().registerListener(this.aLb);
        MessageManager.getInstance().removeMessageRule(this.aLf);
        MessageManager.getInstance().addMessageRule(this.aLf);
        MessageManager.getInstance().unRegisterListener(this.aLg);
        MessageManager.getInstance().registerListener(this.aLg);
        MessageManager.getInstance().unRegisterListener(this.aLk);
        MessageManager.getInstance().registerListener(this.aLk);
        MessageManager.getInstance().unRegisterListener(this.aLl);
        MessageManager.getInstance().registerListener(this.aLl);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID, this.aLm);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_ENSURE_CAST_ID);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void AX() {
        com.baidu.c.b.a.aB(this.mContext).Ia().AZ();
        this.aLa = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final String str2, final int i, final boolean z) {
        if (TbConfig.IM_LOG) {
            Log.i("imlog", "@.@ enterRoom roomid:" + str + ", url:" + str2);
        }
        com.baidu.c.b.a.aB(this.mContext).Ia().a(str, str2, i, new com.baidu.c.a.b.b() { // from class: com.baidu.live.im.f.15
            @Override // com.baidu.c.a.b.b
            public void onResult(int i2, long j, long j2) {
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ enterRoom onResult i:" + i2 + ", l:" + j + ", l1:" + j2);
                }
                if (f.this.aqQ == null || f.this.aqq == null || f.this.aqr == null) {
                    com.baidu.c.b.a.aB(f.this.mContext).Ia().fn(String.valueOf(j));
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.aqq, String.valueOf(j), -1, "", "", "");
                    return;
                }
                long j3 = JavaTypesHelper.toLong(f.this.aqq, -1L);
                long j4 = JavaTypesHelper.toLong(f.this.aqr, -1L);
                if (j3 != j && j4 != j) {
                    com.baidu.c.b.a.aB(f.this.mContext).Ia().fn(String.valueOf(j));
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.aqq, String.valueOf(j), -1, "", "", "");
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
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_FAIL_IM_NOT_LOGIN, f.this.aqq, str, -1, "", "", "");
                } else if (i2 == 1314 || i2 == 1306) {
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_MSG_ENTER_IM_FAIL, f.this.aqq, str, -1, String.valueOf(i2), "", "");
                } else if (i2 != 0) {
                    if (j3 == j) {
                        if (f.this.aKW < 3) {
                            f.this.a(str, str2, i, z);
                            f.this.aKW++;
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_MSG_FAIL_TO_REJOIN, f.this.aqq, str, -1, "", "", "");
                            return;
                        }
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.aqq, str, -1, "", "", "");
                    } else if (f.this.aKX < 3) {
                        f.this.a(str, str2, i, z);
                        f.this.aKX++;
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_GIFT_FAIL_TO_REJOIN, f.this.aqq, str, -1, "", "", "");
                    } else {
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.aqq, str, -1, "", "", "");
                    }
                } else if (j3 == j) {
                    f.this.aKW = 0;
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", f.this.aqq, str, 0, "", "", "");
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ enterRoom onResult JOIN Msg成功:" + j3);
                    }
                    if ((!f.this.aqQ.isHost || (f.this.aqQ.isHost && f.this.aqQ.aqF)) && f.this.aLa != j3) {
                        f.this.aLa = j3;
                        ChatMsgManagerImpl.getInstance(f.this.mContext).fetchMsgidByMsgid(f.this.mContext, 4, JavaTypesHelper.toLong(str, -1L), 0L, Long.MAX_VALUE, -25, 1, 0, f.this.aLi);
                    }
                } else {
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", f.this.aqq, str, 0, "", "", "");
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ enterRoom onResult JOIN Gift成功:" + j4);
                    }
                    f.this.aKX = 0;
                }
            }
        }, z);
        AY();
        eD(str);
    }

    private void AY() {
        MessageManager.getInstance().unRegisterListener(this.azu);
        MessageManager.getInstance().registerListener(this.azu);
        MessageManager.getInstance().unRegisterListener(this.aLc);
        MessageManager.getInstance().registerListener(this.aLc);
        MessageManager.getInstance().unRegisterListener(this.aLd);
        MessageManager.getInstance().registerListener(this.aLd);
        MessageManager.getInstance().removeMessageRule(this.aLe);
        MessageManager.getInstance().addMessageRule(this.aLe);
        MessageManager.getInstance().removeMessageRule(this.aLh);
        MessageManager.getInstance().addMessageRule(this.aLh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AZ() {
        if (this.aqQ != null && this.aqQ.mLiveSdkInfo != null && this.aqQ.mLiveSdkInfo.mCastIds != null) {
            String str = this.aqQ.mLiveSdkInfo.mCastIds.aqq;
            String str2 = this.aqQ.mLiveSdkInfo.mCastIds.aqr;
            com.baidu.c.b.a.aB(this.mContext).Ia().fn(str);
            com.baidu.c.b.a.aB(this.mContext).Ia().fn(str2);
        }
        this.aLa = 0L;
        this.aqQ = null;
        this.aqq = null;
        this.aqr = null;
        this.aKW = 0;
        this.aKX = 0;
        if (this.aKY != null) {
            this.aKY.clear();
            this.aKY = null;
        }
        if (this.aKZ != null) {
            this.aKZ.clear();
            this.aKZ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ba() {
        MessageManager.getInstance().unRegisterListener(this.aLc);
        MessageManager.getInstance().unRegisterListener(this.aLd);
        MessageManager.getInstance().unRegisterListener(this.azu);
        MessageManager.getInstance().removeMessageRule(this.aLe);
        MessageManager.getInstance().removeMessageRule(this.aLh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(List<AlaLiveMarkData> list) {
        if (list != null && !list.isEmpty()) {
            if (this.aKZ == null) {
                this.aKZ = new ArrayList();
            }
            this.aKZ.clear();
            this.aKZ.addAll(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.live.im.message.a aVar) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        String str = null;
        String content = aVar.getContent();
        String str2 = (this.aqQ == null || this.aqQ.mLiveSdkInfo == null || this.aqQ.mLiveSdkInfo.mCastIds == null) ? null : this.aqQ.mLiveSdkInfo.mCastIds.aqq;
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.c.a.b.a.e eVar = new com.baidu.c.a.b.a.e();
            eVar.msg = content;
            eVar.bdK = str2;
            if (this.aqQ != null && this.aqQ.aqx != null) {
                eVar.name = this.aqQ.aqx.userName;
                eVar.portrait = this.aqQ.aqx.portrait;
            }
            a aVar2 = new a();
            if (this.aqQ != null) {
                if (this.aqQ.isHost) {
                    alaLiveUserInfoData = this.aqQ.aqe;
                } else {
                    alaLiveUserInfoData = this.aqQ.aqx;
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
                    aVar3.apt = alaLiveUserInfoData.followCount;
                    aVar3.aps = alaLiveUserInfoData.fansCount;
                    aVar3.apw = alaLiveUserInfoData.isAdmin == 1;
                    aVar3.apv = alaLiveUserInfoData.isOfficial == 1;
                    aVar3.level_id = alaLiveUserInfoData.levelId;
                    aVar3.apy = this.aKZ;
                    aVar3.sex = alaLiveUserInfoData.sex;
                    aVar3.extraUserInfo = alaLiveUserInfoData.extraUserInfo;
                    aVar2.d(aVar3);
                    aVar2.setContent(content);
                    aVar2.setMsgType(aVar.Cq());
                    aVar2.cm(aVar.Cj());
                    aVar2.eF(aVar.Ck());
                    aVar2.a(aVar.Cl());
                    aVar2.l(aVar.Cm());
                    aVar2.setUserId(alaLiveUserInfoData.userId);
                    aVar2.eA(String.valueOf(this.aqQ.mLiveInfo.user_id));
                    aVar2.setBornTime(System.currentTimeMillis());
                    str = aVar2.AB();
                }
            }
            eVar.bea = str;
            com.baidu.c.a.b.a.f fVar = new com.baidu.c.a.b.a.f() { // from class: com.baidu.live.im.f.2
                @Override // com.baidu.c.a.b.a.f
                public void a(String str3, int i, List<com.baidu.c.a.b.a.c> list) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ IM消息 onSendSuccess s:" + str3 + ", i:" + i);
                    }
                    if (f.this.aqQ != null && f.this.aqq != null && f.this.aqr != null) {
                        if (TextUtils.equals(str3, f.this.aqq) || TextUtils.equals(str3, f.this.aqr)) {
                            ALAGroupCommitHttpResponsedMessage aLAGroupCommitHttpResponsedMessage = new ALAGroupCommitHttpResponsedMessage();
                            aLAGroupCommitHttpResponsedMessage.setStatusCode(200, null);
                            if (f.this.aqQ.mLiveInfo != null) {
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
                            if (com.baidu.live.liveroom.a.Dl().Dm()) {
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
            com.baidu.c.b.a.aB(this.mContext).Ia().a(str2, eVar, fVar);
            if (TbConfig.IM_LOG) {
                Log.i("imlog", "@.@ IM消息 发送 roomId:" + str2 + ", sendMessage:" + eVar.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.live.im.message.a aVar) {
        if (TbadkCoreApplication.getInst().isHaokan()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SUC_SEND_NEWS);
            alaStaticItem.addParams("live_id", this.aqQ.mLiveInfo.live_id + "");
            alaStaticItem.addParams("room_id", this.aqQ.mLiveInfo.room_id + "");
            alaStaticItem.addParams("feed_id", this.aqQ.mLiveInfo.feed_id + "");
            alaStaticItem.addParams("other_params", aVar.Cr());
            if (aVar.Cq() == 126) {
                alaStaticItem.addParams("gifts_value", String.valueOf(aVar.Cs()));
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SUC_SEND_NEWS);
            alaStaticItem2.addParams("live_id", this.aqQ.mLiveInfo.live_id + "");
            alaStaticItem2.addParams("room_id", this.aqQ.mLiveInfo.room_id + "");
            alaStaticItem2.addParams("feed_id", this.aqQ.mLiveInfo.feed_id + "");
            alaStaticItem2.addParams("other_params", aVar.Cr());
            if (aVar.Cq() == 126) {
                alaStaticItem2.addParams("gifts_value", String.valueOf(aVar.Cs()));
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem2);
        }
        if (aVar.Cq() == 126) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1395", "click", "liveroom", "msg_send").setContentExt("barrage", null, null));
        } else if (aVar.Ct()) {
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
                    if (!TextUtils.isEmpty(cVar.bdK)) {
                        str = cVar.bdK;
                    } else if (cVar.bdZ != null && cVar.bdZ.beo != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(cVar.bdZ.beo);
                            if (!TextUtils.isEmpty(jSONObject.optString("room_id"))) {
                                str = jSONObject.optString("room_id");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    if (TextUtils.isEmpty(str) || TextUtils.equals(str, this.aqq) || TextUtils.equals(str, this.aqr)) {
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
                this.aLj.e(aKV, arrayList2);
            }
        }
    }

    private void eD(String str) {
        com.baidu.c.b.a.aB(this.mContext).Ia().a(str, this.aLj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bb() {
        if (this.aqQ != null && this.aqQ.mLiveSdkInfo != null && this.aqQ.mLiveSdkInfo.mCastIds != null) {
            this.aKW = 0;
            this.aKX = 0;
            this.aqq = this.aqQ.mLiveSdkInfo.mCastIds.aqq;
            String str = this.aqQ.mLiveSdkInfo.mCastIds.aqs;
            this.aqr = this.aqQ.mLiveSdkInfo.mCastIds.aqr;
            String str2 = this.aqQ.mLiveSdkInfo.mCastIds.aqu;
            int i = JavaTypesHelper.toInt(this.aqQ.mLiveSdkInfo.mCastIds.aqv, 5) * 1000;
            a(this.aqq, str, i, false);
            a(this.aqr, str2, i, this.aqQ.isHost);
        }
    }
}
