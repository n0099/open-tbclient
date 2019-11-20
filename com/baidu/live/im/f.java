package com.baidu.live.im;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.controller.HttpRule;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.im.message.ALAGroupCommitHttpResponsedMessage;
import com.baidu.live.im.message.ALAGroupHttpResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.extraparams.interfaces.IExtraParams;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticKeys;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {
    private static f afF = null;
    private static int afG = Integer.MAX_VALUE;
    private String Pd;
    private String Pe;
    private com.baidu.live.data.i Pv;
    private List<String> afJ;
    private BdUniqueId afK;
    private List<AlaLiveMarkData> afL;
    private long afM;
    private Context mContext;
    private int afH = 0;
    private int afI = 0;
    private CustomMessageListener afN = new CustomMessageListener(2913081) { // from class: com.baidu.live.im.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.data.i iVar;
            int i;
            String str;
            String str2;
            if (customResponsedMessage.hasError() || customResponsedMessage.getError() != 0 || com.baidu.c.b.a.aB(f.this.mContext).xd() == null || !(customResponsedMessage.getData() instanceof com.baidu.live.data.i) || (iVar = (com.baidu.live.data.i) customResponsedMessage.getData()) == null) {
                return;
            }
            if ((iVar.mLiveSdkInfo != null && iVar.mLiveSdkInfo.mCastIds != null) || (iVar.mLiveInfo != null && iVar.mLiveInfo.mCastIds != null)) {
                if (iVar.mLiveInfo == null || iVar.mLiveInfo.live_status != 2) {
                    f.this.Pv = iVar;
                    f.this.D(f.this.Pv.Pl);
                    if (iVar.mLiveSdkInfo != null && iVar.mLiveSdkInfo.mCastIds != null) {
                        f.this.Pd = f.this.Pv.mLiveSdkInfo.mCastIds.Pd;
                        String str3 = f.this.Pv.mLiveSdkInfo.mCastIds.Pf;
                        f.this.Pe = f.this.Pv.mLiveSdkInfo.mCastIds.Pe;
                        String str4 = f.this.Pv.mLiveSdkInfo.mCastIds.Ph;
                        i = JavaTypesHelper.toInt(f.this.Pv.mLiveSdkInfo.mCastIds.Pi, 5) * 1000;
                        str = str4;
                        str2 = str3;
                    } else if (iVar.mLiveInfo != null && iVar.mLiveInfo.mCastIds != null) {
                        f.this.Pd = f.this.Pv.mLiveInfo.mCastIds.Pd;
                        String str5 = f.this.Pv.mLiveInfo.mCastIds.Pf;
                        f.this.Pe = f.this.Pv.mLiveInfo.mCastIds.Pe;
                        String str6 = f.this.Pv.mLiveInfo.mCastIds.Ph;
                        i = JavaTypesHelper.toInt(f.this.Pv.mLiveInfo.mCastIds.Pi, 5) * 1000;
                        str = str6;
                        str2 = str5;
                    } else {
                        i = 5000;
                        str = "";
                        str2 = "";
                    }
                    f.this.a(f.this.Pd, str2, i, false);
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", f.this.Pd, f.this.Pd, 0, "", "", "");
                    f.this.a(f.this.Pe, str, i, iVar.isHost);
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", f.this.Pd, f.this.Pe, 0, "", "", "");
                }
            }
        }
    };
    private CustomMessageListener afO = new CustomMessageListener(2913082) { // from class: com.baidu.live.im.f.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof com.baidu.live.data.i)) {
                f.this.Pv = (com.baidu.live.data.i) customResponsedMessage.getData();
                f.this.D(f.this.Pv.Pl);
            }
        }
    };
    private CustomMessageListener afP = new CustomMessageListener(2913118) { // from class: com.baidu.live.im.f.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof com.baidu.live.data.i)) {
                f.this.D(((com.baidu.live.data.i) customResponsedMessage.getData()).Pl);
            }
        }
    };
    private HttpRule afQ = new HttpRule(1021013) { // from class: com.baidu.live.im.f.8
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
    private HttpRule afR = new HttpRule(1021012) { // from class: com.baidu.live.im.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            return null;
        }
    };
    CustomMessageListener afS = new CustomMessageListener(2913084) { // from class: com.baidu.live.im.f.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.sx();
        }
    };
    CustomMessageListener afT = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.im.f.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.sz();
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.im.f.11.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.sA();
                }
            });
        }
    };
    private HttpRule afU = new HttpRule(1021006) { // from class: com.baidu.live.im.f.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            f.this.sz();
            if (f.this.Pv != null && f.this.Pv.mLiveSdkInfo != null && f.this.Pv.mLiveSdkInfo.mCastIds != null) {
                String str = f.this.Pv.mLiveSdkInfo.mCastIds.Pd;
                String str2 = f.this.Pv.mLiveSdkInfo.mCastIds.Pe;
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str, -1, "", "", "");
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str2, -1, "", "", "");
            }
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.im.f.12.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.sA();
                }
            });
            return httpMessage;
        }
    };
    private IFetchMsgByIdListener afV = new IFetchMsgByIdListener() { // from class: com.baidu.live.im.f.3
        @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
        public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList) {
            f.this.b(i, arrayList);
        }
    };
    private com.baidu.c.a.b.a.d afW = new com.baidu.c.a.b.a.d() { // from class: com.baidu.live.im.f.4
        @Override // com.baidu.c.a.b.a.d
        public void d(int i, List<com.baidu.c.a.b.a.c> list) {
            if (f.this.Pv != null && f.this.Pd != null && f.this.Pe != null && f.this.Pv.mLiveInfo != null) {
                if (i == 0 || i == f.afG) {
                    ALAGroupHttpResponseMessage aLAGroupHttpResponseMessage = new ALAGroupHttpResponseMessage();
                    ArrayList arrayList = new ArrayList();
                    if (f.this.afJ != null) {
                        f.this.afJ.clear();
                    }
                    for (com.baidu.c.a.b.a.c cVar : list) {
                        if (cVar != null) {
                            String str = "";
                            String str2 = "";
                            if (!TextUtils.isEmpty(cVar.auO)) {
                                str = cVar.auO;
                            } else if (cVar.avd != null && cVar.avd.avr != null) {
                                try {
                                    JSONObject jSONObject = new JSONObject(cVar.avd.avr);
                                    if (!TextUtils.isEmpty(jSONObject.optString("room_id"))) {
                                        str = jSONObject.optString("room_id");
                                    }
                                    str2 = jSONObject.optString("msg_type");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            if (TextUtils.isEmpty(str) || TextUtils.equals(str, f.this.Pd) || TextUtils.equals(str, f.this.Pe)) {
                                if (!TextUtils.equals(cVar.type, "0") || !TextUtils.isEmpty(str)) {
                                    if (!TextUtils.isEmpty(str) || !TextUtils.equals(str2, "24")) {
                                        List<a> a = p.a(cVar);
                                        if (a != null) {
                                            if (TextUtils.equals(cVar.type, "0")) {
                                                for (int i2 = 0; i2 < a.size(); i2++) {
                                                    a aVar = a.get(i2);
                                                    if (aVar.tf() != null && (!TextUtils.isEmpty(aVar.tf().name_show) || !TextUtils.isEmpty(aVar.tf().userName))) {
                                                        arrayList.add(aVar);
                                                    }
                                                }
                                            } else {
                                                arrayList.addAll(a);
                                            }
                                            if (i == 0 && cVar.avd != null && !TextUtils.isEmpty(cVar.avd.avr)) {
                                                if (f.this.afJ == null) {
                                                    f.this.afJ = new ArrayList();
                                                }
                                                f.this.afJ.add(cVar.avd.avr);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        aLAGroupHttpResponseMessage.aA(i == f.afG);
                        aLAGroupHttpResponseMessage.I(arrayList);
                        aLAGroupHttpResponseMessage.setGroupId(f.this.Pv.mLiveInfo.getGroupID());
                        MessageManager.getInstance().dispatchResponsedMessage(aLAGroupHttpResponseMessage);
                        if (f.this.afJ != null && !f.this.afJ.isEmpty()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913107, f.this.afJ));
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener afX = new CustomMessageListener(2913108) { // from class: com.baidu.live.im.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                try {
                    i = new JSONObject((String) customResponsedMessage.getData()).optInt("id", 0);
                } catch (JSONException e) {
                    e.printStackTrace();
                    i = 0;
                }
                if (i != 0 && i == f.this.afK.getId() && f.this.Pv != null) {
                    f.this.afH = 0;
                    f.this.afI = 0;
                    f.this.Pd = f.this.Pv.mLiveSdkInfo.mCastIds.Pd;
                    String str = f.this.Pv.mLiveSdkInfo.mCastIds.Pf;
                    f.this.Pe = f.this.Pv.mLiveSdkInfo.mCastIds.Pe;
                    String str2 = f.this.Pv.mLiveSdkInfo.mCastIds.Ph;
                    int i2 = JavaTypesHelper.toInt(f.this.Pv.mLiveSdkInfo.mCastIds.Pi, 5) * 1000;
                    f.this.a(f.this.Pd, str, i2, false);
                    f.this.a(f.this.Pe, str2, i2, f.this.Pv.isHost);
                }
            }
        }
    };

    public static f sw() {
        if (afF == null) {
            synchronized (f.class) {
                if (afF == null) {
                    afF = new f();
                }
            }
        }
        return afF;
    }

    private f() {
    }

    public void aq(Context context) {
        this.mContext = context;
        MessageManager.getInstance().unRegisterListener(this.afN);
        MessageManager.getInstance().registerListener(this.afN);
        MessageManager.getInstance().removeMessageRule(this.afR);
        MessageManager.getInstance().addMessageRule(this.afR);
        MessageManager.getInstance().unRegisterListener(this.afS);
        MessageManager.getInstance().registerListener(this.afS);
        MessageManager.getInstance().unRegisterListener(this.afX);
        MessageManager.getInstance().registerListener(this.afX);
    }

    public void sx() {
        com.baidu.c.b.a.aB(this.mContext).xd().sz();
        this.afM = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final String str2, final int i, final boolean z) {
        if (TbConfig.IM_LOG) {
            Log.i("imlog", "@.@ enterRoom roomid:" + str + ", url:" + str2);
        }
        com.baidu.c.b.a.aB(this.mContext).xd().a(str, str2, i, new com.baidu.c.a.b.b() { // from class: com.baidu.live.im.f.13
            @Override // com.baidu.c.a.b.b
            public void onResult(int i2, long j, long j2) {
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ enterRoom onResult i:" + i2 + ", l:" + j + ", l1:" + j2);
                }
                if (f.this.Pv == null || f.this.Pd == null || f.this.Pe == null) {
                    com.baidu.c.b.a.aB(f.this.mContext).xd().dm(String.valueOf(j));
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.Pd, String.valueOf(j), -1, "", "", "");
                    return;
                }
                long j3 = JavaTypesHelper.toLong(f.this.Pd, -1L);
                long j4 = JavaTypesHelper.toLong(f.this.Pe, -1L);
                if (j3 != j && j4 != j) {
                    com.baidu.c.b.a.aB(f.this.mContext).xd().dm(String.valueOf(j));
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.Pd, String.valueOf(j), -1, "", "", "");
                    if (TbConfig.IM_LOG) {
                        Log.e("imlog", "BDIM enterRoom wrong then exit end:" + j);
                    }
                } else if (i2 == 1000) {
                    IExtraParams buildParamsExtra = ExtraParamsManager.getInstance().buildParamsExtra();
                    if (buildParamsExtra != null) {
                        try {
                            HashMap hashMap = new HashMap();
                            hashMap.put(ExtraParamsManager.KEY_PROCESS_PLUGIN_ASYNC_CALLBACK, "");
                            f.this.afK = BdUniqueId.gen();
                            hashMap.put("id", Integer.valueOf(f.this.afK.getId()));
                            hashMap.put("cmd", 2913108);
                            buildParamsExtra.process(hashMap);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_FAIL_IM_NOT_LOGIN, f.this.Pd, str, -1, "", "", "");
                } else if (i2 != 0) {
                    if (j3 == j) {
                        if (f.this.afH < 3) {
                            f.this.a(str, str2, i, z);
                            f.this.afH++;
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_MSG_FAIL_TO_REJOIN, f.this.Pd, str, -1, "", "", "");
                            return;
                        }
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.Pd, str, -1, "", "", "");
                    } else if (f.this.afI < 3) {
                        f.this.a(str, str2, i, z);
                        f.this.afI++;
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_GIFT_FAIL_TO_REJOIN, f.this.Pd, str, -1, "", "", "");
                    } else {
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.Pd, str, -1, "", "", "");
                    }
                } else if (j3 == j) {
                    f.this.afH = 0;
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", f.this.Pd, str, 0, "", "", "");
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ enterRoom onResult JOIN Msg成功:" + j3);
                    }
                    if (!f.this.Pv.isHost && f.this.afM != j3) {
                        f.this.afM = j3;
                        ChatMsgManagerImpl.getInstance(f.this.mContext).fetchMsgidByMsgid(f.this.mContext, 4, JavaTypesHelper.toLong(str, -1L), 0L, Long.MAX_VALUE, -20, 1, 0, f.this.afV);
                    }
                } else {
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", f.this.Pd, str, 0, "", "", "");
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ enterRoom onResult JOIN Gift成功:" + j4);
                    }
                    f.this.afI = 0;
                }
            }
        }, z);
        sy();
        cG(str);
    }

    private void sy() {
        MessageManager.getInstance().unRegisterListener(this.afT);
        MessageManager.getInstance().registerListener(this.afT);
        MessageManager.getInstance().unRegisterListener(this.afO);
        MessageManager.getInstance().registerListener(this.afO);
        MessageManager.getInstance().unRegisterListener(this.afP);
        MessageManager.getInstance().registerListener(this.afP);
        MessageManager.getInstance().removeMessageRule(this.afQ);
        MessageManager.getInstance().addMessageRule(this.afQ);
        MessageManager.getInstance().removeMessageRule(this.afU);
        MessageManager.getInstance().addMessageRule(this.afU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sz() {
        if (this.Pv != null && this.Pv.mLiveSdkInfo != null && this.Pv.mLiveSdkInfo.mCastIds != null) {
            String str = this.Pv.mLiveSdkInfo.mCastIds.Pd;
            String str2 = this.Pv.mLiveSdkInfo.mCastIds.Pe;
            com.baidu.c.b.a.aB(this.mContext).xd().dm(str);
            com.baidu.c.b.a.aB(this.mContext).xd().dm(str2);
        }
        this.afM = 0L;
        this.Pv = null;
        this.Pd = null;
        this.Pe = null;
        this.afH = 0;
        this.afI = 0;
        if (this.afJ != null) {
            this.afJ.clear();
            this.afJ = null;
        }
        if (this.afL != null) {
            this.afL.clear();
            this.afL = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sA() {
        MessageManager.getInstance().unRegisterListener(this.afO);
        MessageManager.getInstance().unRegisterListener(this.afP);
        MessageManager.getInstance().unRegisterListener(this.afT);
        MessageManager.getInstance().removeMessageRule(this.afQ);
        MessageManager.getInstance().removeMessageRule(this.afU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(List<AlaLiveMarkData> list) {
        if (list != null && !list.isEmpty()) {
            if (this.afL == null) {
                this.afL = new ArrayList();
            }
            this.afL.clear();
            this.afL.addAll(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.live.im.message.a aVar) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        String str = null;
        String content = aVar.getContent();
        String str2 = (this.Pv == null || this.Pv.mLiveSdkInfo == null || this.Pv.mLiveSdkInfo.mCastIds == null) ? null : this.Pv.mLiveSdkInfo.mCastIds.Pd;
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.c.a.b.a.e eVar = new com.baidu.c.a.b.a.e();
            eVar.msg = content;
            eVar.auO = str2;
            eVar.name = this.Pv.Pj.userName;
            eVar.portrait = this.Pv.Pj.portrait;
            a aVar2 = new a();
            if (this.Pv != null) {
                if (this.Pv.isHost) {
                    alaLiveUserInfoData = this.Pv.OR;
                } else {
                    alaLiveUserInfoData = this.Pv.Pj;
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
                    aVar3.Ok = alaLiveUserInfoData.followCount;
                    aVar3.Oj = alaLiveUserInfoData.fansCount;
                    aVar3.On = alaLiveUserInfoData.isAdmin == 1;
                    aVar3.Om = alaLiveUserInfoData.isOfficial == 1;
                    aVar3.level_id = alaLiveUserInfoData.levelId;
                    aVar3.Op = this.afL;
                    aVar3.sex = alaLiveUserInfoData.sex;
                    aVar2.b(aVar3);
                    aVar2.setContent(content);
                    aVar2.setMsgType(aVar.tm());
                    aVar2.cJ(aVar.tj());
                    aVar2.a(aVar.tk());
                    aVar2.k(aVar.tl());
                    aVar2.setUserId(alaLiveUserInfoData.userId);
                    aVar2.cD(String.valueOf(this.Pv.mLiveInfo.user_id));
                    aVar2.setBornTime(System.currentTimeMillis());
                    str = aVar2.se();
                }
            }
            eVar.ave = str;
            com.baidu.c.b.a.aB(this.mContext).xd().a(str2, eVar, new com.baidu.c.a.b.a.f() { // from class: com.baidu.live.im.f.2
                @Override // com.baidu.c.a.b.a.f
                public void a(String str3, int i, List<com.baidu.c.a.b.a.c> list) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ IM消息 onSendSuccess s:" + str3 + ", i:" + i);
                    }
                    if (f.this.Pv != null && f.this.Pd != null && f.this.Pe != null) {
                        if (TextUtils.equals(str3, f.this.Pd) || TextUtils.equals(str3, f.this.Pe)) {
                            ALAGroupCommitHttpResponsedMessage aLAGroupCommitHttpResponsedMessage = new ALAGroupCommitHttpResponsedMessage();
                            aLAGroupCommitHttpResponsedMessage.setStatusCode(200, null);
                            if (f.this.Pv.mLiveInfo != null) {
                                if (TbadkCoreApplication.getInst().isHaokan()) {
                                    AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SUC_SEND_NEWS);
                                    alaStaticItem.addParams("live_id", f.this.Pv.mLiveInfo.live_id + "");
                                    alaStaticItem.addParams("room_id", f.this.Pv.mLiveInfo.room_id + "");
                                    alaStaticItem.addParams("feed_id", f.this.Pv.mLiveInfo.feed_id + "");
                                    alaStaticItem.addParams("other_params", aVar.tn());
                                    if (aVar.tm() == 126) {
                                        alaStaticItem.addParams("gifts_value", String.valueOf(aVar.tp()));
                                    }
                                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                                }
                                if (TbadkCoreApplication.getInst().isQuanmin()) {
                                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SUC_SEND_NEWS);
                                    alaStaticItem2.addParams("live_id", f.this.Pv.mLiveInfo.live_id + "");
                                    alaStaticItem2.addParams("room_id", f.this.Pv.mLiveInfo.room_id + "");
                                    alaStaticItem2.addParams("feed_id", f.this.Pv.mLiveInfo.feed_id + "");
                                    alaStaticItem2.addParams("other_params", aVar.tn());
                                    if (aVar.tm() == 126) {
                                        alaStaticItem2.addParams("gifts_value", String.valueOf(aVar.tp()));
                                    }
                                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                                }
                            }
                            if (i == 0) {
                                f.this.E(list);
                            } else if (i == 22) {
                                aLAGroupCommitHttpResponsedMessage.setError(22);
                                aLAGroupCommitHttpResponsedMessage.setErrorString("");
                            } else if (i == 1000) {
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(aLAGroupCommitHttpResponsedMessage);
                            if (com.baidu.live.liveroom.a.tZ().ua()) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913093));
                            }
                        }
                    }
                }
            });
            if (TbConfig.IM_LOG) {
                Log.i("imlog", "@.@ IM消息 发送 roomId:" + str2 + ", sendMessage:" + eVar.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(List<com.baidu.c.a.b.a.c> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.c.a.b.a.c cVar : list) {
                if (cVar != null) {
                    String str = "";
                    if (!TextUtils.isEmpty(cVar.auO)) {
                        str = cVar.auO;
                    } else if (cVar.avd != null && cVar.avd.avr != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(cVar.avd.avr);
                            if (!TextUtils.isEmpty(jSONObject.optString("room_id"))) {
                                str = jSONObject.optString("room_id");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    if (TextUtils.isEmpty(str) || TextUtils.equals(str, this.Pd) || TextUtils.equals(str, this.Pe)) {
                        List<a> a = p.a(cVar);
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
                this.afW.d(afG, arrayList2);
            }
        }
    }

    private void cG(String str) {
        com.baidu.c.b.a.aB(this.mContext).xd().a(str, this.afW);
    }
}
