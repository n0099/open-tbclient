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
    private static f afX = null;
    private static int afY = Integer.MAX_VALUE;
    private String PG;
    private String PH;
    private com.baidu.live.data.i Qb;
    private List<String> agb;
    private BdUniqueId agc;
    private List<AlaLiveMarkData> agd;
    private long agf;
    private Context mContext;
    private int afZ = 0;
    private int aga = 0;
    private CustomMessageListener agg = new CustomMessageListener(2913081) { // from class: com.baidu.live.im.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.data.i iVar;
            int i;
            String str;
            String str2;
            if (customResponsedMessage.hasError() || customResponsedMessage.getError() != 0 || com.baidu.c.b.a.aB(f.this.mContext).xc() == null || !(customResponsedMessage.getData() instanceof com.baidu.live.data.i) || (iVar = (com.baidu.live.data.i) customResponsedMessage.getData()) == null) {
                return;
            }
            if ((iVar.mLiveSdkInfo != null && iVar.mLiveSdkInfo.mCastIds != null) || (iVar.mLiveInfo != null && iVar.mLiveInfo.mCastIds != null)) {
                if (iVar.mLiveInfo == null || iVar.mLiveInfo.live_status != 2) {
                    f.this.Qb = iVar;
                    f.this.C(f.this.Qb.PP);
                    if (iVar.mLiveSdkInfo != null && iVar.mLiveSdkInfo.mCastIds != null) {
                        f.this.PG = f.this.Qb.mLiveSdkInfo.mCastIds.PG;
                        String str3 = f.this.Qb.mLiveSdkInfo.mCastIds.PI;
                        f.this.PH = f.this.Qb.mLiveSdkInfo.mCastIds.PH;
                        String str4 = f.this.Qb.mLiveSdkInfo.mCastIds.PK;
                        i = JavaTypesHelper.toInt(f.this.Qb.mLiveSdkInfo.mCastIds.PM, 5) * 1000;
                        str = str4;
                        str2 = str3;
                    } else if (iVar.mLiveInfo != null && iVar.mLiveInfo.mCastIds != null) {
                        f.this.PG = f.this.Qb.mLiveInfo.mCastIds.PG;
                        String str5 = f.this.Qb.mLiveInfo.mCastIds.PI;
                        f.this.PH = f.this.Qb.mLiveInfo.mCastIds.PH;
                        String str6 = f.this.Qb.mLiveInfo.mCastIds.PK;
                        i = JavaTypesHelper.toInt(f.this.Qb.mLiveInfo.mCastIds.PM, 5) * 1000;
                        str = str6;
                        str2 = str5;
                    } else {
                        i = 5000;
                        str = "";
                        str2 = "";
                    }
                    f.this.a(f.this.PG, str2, i, false);
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", f.this.PG, f.this.PG, 0, "", "", "");
                    f.this.a(f.this.PH, str, i, iVar.isHost);
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", f.this.PG, f.this.PH, 0, "", "", "");
                }
            }
        }
    };
    private CustomMessageListener agh = new CustomMessageListener(2913082) { // from class: com.baidu.live.im.f.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof com.baidu.live.data.i)) {
                f.this.Qb = (com.baidu.live.data.i) customResponsedMessage.getData();
                f.this.C(f.this.Qb.PP);
            }
        }
    };
    private CustomMessageListener agi = new CustomMessageListener(2913118) { // from class: com.baidu.live.im.f.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof com.baidu.live.data.i)) {
                f.this.C(((com.baidu.live.data.i) customResponsedMessage.getData()).PP);
            }
        }
    };
    private HttpRule agj = new HttpRule(1021013) { // from class: com.baidu.live.im.f.8
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
    private HttpRule agk = new HttpRule(1021012) { // from class: com.baidu.live.im.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            return null;
        }
    };
    CustomMessageListener agl = new CustomMessageListener(2913084) { // from class: com.baidu.live.im.f.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.sw();
        }
    };
    CustomMessageListener agm = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.im.f.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.sy();
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.im.f.11.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.sz();
                }
            });
        }
    };
    private HttpRule agn = new HttpRule(1021006) { // from class: com.baidu.live.im.f.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            f.this.sy();
            if (f.this.Qb != null && f.this.Qb.mLiveSdkInfo != null && f.this.Qb.mLiveSdkInfo.mCastIds != null) {
                String str = f.this.Qb.mLiveSdkInfo.mCastIds.PG;
                String str2 = f.this.Qb.mLiveSdkInfo.mCastIds.PH;
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str, -1, "", "", "");
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str2, -1, "", "", "");
            }
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.im.f.12.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.sz();
                }
            });
            return httpMessage;
        }
    };
    private IFetchMsgByIdListener ago = new IFetchMsgByIdListener() { // from class: com.baidu.live.im.f.3
        @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
        public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList) {
            f.this.b(i, arrayList);
        }
    };
    private com.baidu.c.a.b.a.d agp = new com.baidu.c.a.b.a.d() { // from class: com.baidu.live.im.f.4
        @Override // com.baidu.c.a.b.a.d
        public void d(int i, List<com.baidu.c.a.b.a.c> list) {
            if (f.this.Qb != null && f.this.PG != null && f.this.PH != null && f.this.Qb.mLiveInfo != null) {
                if (i == 0 || i == f.afY) {
                    ALAGroupHttpResponseMessage aLAGroupHttpResponseMessage = new ALAGroupHttpResponseMessage();
                    ArrayList arrayList = new ArrayList();
                    if (f.this.agb != null) {
                        f.this.agb.clear();
                    }
                    for (com.baidu.c.a.b.a.c cVar : list) {
                        if (cVar != null) {
                            String str = "";
                            String str2 = "";
                            if (!TextUtils.isEmpty(cVar.avg)) {
                                str = cVar.avg;
                            } else if (cVar.avv != null && cVar.avv.avJ != null) {
                                try {
                                    JSONObject jSONObject = new JSONObject(cVar.avv.avJ);
                                    if (!TextUtils.isEmpty(jSONObject.optString("room_id"))) {
                                        str = jSONObject.optString("room_id");
                                    }
                                    str2 = jSONObject.optString("msg_type");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            if (TextUtils.isEmpty(str) || TextUtils.equals(str, f.this.PG) || TextUtils.equals(str, f.this.PH)) {
                                if (!TextUtils.equals(cVar.type, "0") || !TextUtils.isEmpty(str)) {
                                    if (!TextUtils.isEmpty(str) || !TextUtils.equals(str2, "24")) {
                                        List<a> a = p.a(cVar);
                                        if (a != null) {
                                            if (TextUtils.equals(cVar.type, "0")) {
                                                for (int i2 = 0; i2 < a.size(); i2++) {
                                                    a aVar = a.get(i2);
                                                    if (aVar.te() != null && (!TextUtils.isEmpty(aVar.te().name_show) || !TextUtils.isEmpty(aVar.te().userName))) {
                                                        arrayList.add(aVar);
                                                    }
                                                }
                                            } else {
                                                arrayList.addAll(a);
                                            }
                                            if (i == 0 && cVar.avv != null && !TextUtils.isEmpty(cVar.avv.avJ)) {
                                                if (f.this.agb == null) {
                                                    f.this.agb = new ArrayList();
                                                }
                                                f.this.agb.add(cVar.avv.avJ);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        aLAGroupHttpResponseMessage.aA(i == f.afY);
                        aLAGroupHttpResponseMessage.I(arrayList);
                        aLAGroupHttpResponseMessage.setGroupId(f.this.Qb.mLiveInfo.getGroupID());
                        MessageManager.getInstance().dispatchResponsedMessage(aLAGroupHttpResponseMessage);
                        if (f.this.agb != null && !f.this.agb.isEmpty()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913107, f.this.agb));
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener agq = new CustomMessageListener(2913108) { // from class: com.baidu.live.im.f.5
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
                if (i != 0 && i == f.this.agc.getId() && f.this.Qb != null) {
                    f.this.afZ = 0;
                    f.this.aga = 0;
                    f.this.PG = f.this.Qb.mLiveSdkInfo.mCastIds.PG;
                    String str = f.this.Qb.mLiveSdkInfo.mCastIds.PI;
                    f.this.PH = f.this.Qb.mLiveSdkInfo.mCastIds.PH;
                    String str2 = f.this.Qb.mLiveSdkInfo.mCastIds.PK;
                    int i2 = JavaTypesHelper.toInt(f.this.Qb.mLiveSdkInfo.mCastIds.PM, 5) * 1000;
                    f.this.a(f.this.PG, str, i2, false);
                    f.this.a(f.this.PH, str2, i2, f.this.Qb.isHost);
                }
            }
        }
    };

    public static f sv() {
        if (afX == null) {
            synchronized (f.class) {
                if (afX == null) {
                    afX = new f();
                }
            }
        }
        return afX;
    }

    private f() {
    }

    public void aq(Context context) {
        this.mContext = context;
        MessageManager.getInstance().unRegisterListener(this.agg);
        MessageManager.getInstance().registerListener(this.agg);
        MessageManager.getInstance().removeMessageRule(this.agk);
        MessageManager.getInstance().addMessageRule(this.agk);
        MessageManager.getInstance().unRegisterListener(this.agl);
        MessageManager.getInstance().registerListener(this.agl);
        MessageManager.getInstance().unRegisterListener(this.agq);
        MessageManager.getInstance().registerListener(this.agq);
    }

    public void sw() {
        com.baidu.c.b.a.aB(this.mContext).xc().sy();
        this.agf = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final String str2, final int i, final boolean z) {
        if (TbConfig.IM_LOG) {
            Log.i("imlog", "@.@ enterRoom roomid:" + str + ", url:" + str2);
        }
        com.baidu.c.b.a.aB(this.mContext).xc().a(str, str2, i, new com.baidu.c.a.b.b() { // from class: com.baidu.live.im.f.13
            @Override // com.baidu.c.a.b.b
            public void onResult(int i2, long j, long j2) {
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ enterRoom onResult i:" + i2 + ", l:" + j + ", l1:" + j2);
                }
                if (f.this.Qb == null || f.this.PG == null || f.this.PH == null) {
                    com.baidu.c.b.a.aB(f.this.mContext).xc().dm(String.valueOf(j));
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.PG, String.valueOf(j), -1, "", "", "");
                    return;
                }
                long j3 = JavaTypesHelper.toLong(f.this.PG, -1L);
                long j4 = JavaTypesHelper.toLong(f.this.PH, -1L);
                if (j3 != j && j4 != j) {
                    com.baidu.c.b.a.aB(f.this.mContext).xc().dm(String.valueOf(j));
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.PG, String.valueOf(j), -1, "", "", "");
                    if (TbConfig.IM_LOG) {
                        Log.e("imlog", "BDIM enterRoom wrong then exit end:" + j);
                    }
                } else if (i2 == 1000) {
                    IExtraParams buildParamsExtra = ExtraParamsManager.getInstance().buildParamsExtra();
                    if (buildParamsExtra != null) {
                        try {
                            HashMap hashMap = new HashMap();
                            hashMap.put(ExtraParamsManager.KEY_PROCESS_PLUGIN_ASYNC_CALLBACK, "");
                            f.this.agc = BdUniqueId.gen();
                            hashMap.put("id", Integer.valueOf(f.this.agc.getId()));
                            hashMap.put("cmd", 2913108);
                            buildParamsExtra.process(hashMap);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_FAIL_IM_NOT_LOGIN, f.this.PG, str, -1, "", "", "");
                } else if (i2 != 0) {
                    if (j3 == j) {
                        if (f.this.afZ < 3) {
                            f.this.a(str, str2, i, z);
                            f.this.afZ++;
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_MSG_FAIL_TO_REJOIN, f.this.PG, str, -1, "", "", "");
                            return;
                        }
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.PG, str, -1, "", "", "");
                    } else if (f.this.aga < 3) {
                        f.this.a(str, str2, i, z);
                        f.this.aga++;
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_GIFT_FAIL_TO_REJOIN, f.this.PG, str, -1, "", "", "");
                    } else {
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.PG, str, -1, "", "", "");
                    }
                } else if (j3 == j) {
                    f.this.afZ = 0;
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", f.this.PG, str, 0, "", "", "");
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ enterRoom onResult JOIN Msg成功:" + j3);
                    }
                    if (!f.this.Qb.isHost && f.this.agf != j3) {
                        f.this.agf = j3;
                        ChatMsgManagerImpl.getInstance(f.this.mContext).fetchMsgidByMsgid(f.this.mContext, 4, JavaTypesHelper.toLong(str, -1L), 0L, Long.MAX_VALUE, -20, 1, 0, f.this.ago);
                    }
                } else {
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", f.this.PG, str, 0, "", "", "");
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ enterRoom onResult JOIN Gift成功:" + j4);
                    }
                    f.this.aga = 0;
                }
            }
        }, z);
        sx();
        cG(str);
    }

    private void sx() {
        MessageManager.getInstance().unRegisterListener(this.agm);
        MessageManager.getInstance().registerListener(this.agm);
        MessageManager.getInstance().unRegisterListener(this.agh);
        MessageManager.getInstance().registerListener(this.agh);
        MessageManager.getInstance().unRegisterListener(this.agi);
        MessageManager.getInstance().registerListener(this.agi);
        MessageManager.getInstance().removeMessageRule(this.agj);
        MessageManager.getInstance().addMessageRule(this.agj);
        MessageManager.getInstance().removeMessageRule(this.agn);
        MessageManager.getInstance().addMessageRule(this.agn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sy() {
        if (this.Qb != null && this.Qb.mLiveSdkInfo != null && this.Qb.mLiveSdkInfo.mCastIds != null) {
            String str = this.Qb.mLiveSdkInfo.mCastIds.PG;
            String str2 = this.Qb.mLiveSdkInfo.mCastIds.PH;
            com.baidu.c.b.a.aB(this.mContext).xc().dm(str);
            com.baidu.c.b.a.aB(this.mContext).xc().dm(str2);
        }
        this.agf = 0L;
        this.Qb = null;
        this.PG = null;
        this.PH = null;
        this.afZ = 0;
        this.aga = 0;
        if (this.agb != null) {
            this.agb.clear();
            this.agb = null;
        }
        if (this.agd != null) {
            this.agd.clear();
            this.agd = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sz() {
        MessageManager.getInstance().unRegisterListener(this.agh);
        MessageManager.getInstance().unRegisterListener(this.agi);
        MessageManager.getInstance().unRegisterListener(this.agm);
        MessageManager.getInstance().removeMessageRule(this.agj);
        MessageManager.getInstance().removeMessageRule(this.agn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(List<AlaLiveMarkData> list) {
        if (list != null && !list.isEmpty()) {
            if (this.agd == null) {
                this.agd = new ArrayList();
            }
            this.agd.clear();
            this.agd.addAll(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.live.im.message.a aVar) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        String str = null;
        String content = aVar.getContent();
        String str2 = (this.Qb == null || this.Qb.mLiveSdkInfo == null || this.Qb.mLiveSdkInfo.mCastIds == null) ? null : this.Qb.mLiveSdkInfo.mCastIds.PG;
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.c.a.b.a.e eVar = new com.baidu.c.a.b.a.e();
            eVar.msg = content;
            eVar.avg = str2;
            eVar.name = this.Qb.PN.userName;
            eVar.portrait = this.Qb.PN.portrait;
            a aVar2 = new a();
            if (this.Qb != null) {
                if (this.Qb.isHost) {
                    alaLiveUserInfoData = this.Qb.Ps;
                } else {
                    alaLiveUserInfoData = this.Qb.PN;
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
                    aVar3.OL = alaLiveUserInfoData.followCount;
                    aVar3.OJ = alaLiveUserInfoData.fansCount;
                    aVar3.OP = alaLiveUserInfoData.isAdmin == 1;
                    aVar3.OO = alaLiveUserInfoData.isOfficial == 1;
                    aVar3.level_id = alaLiveUserInfoData.levelId;
                    aVar3.OR = this.agd;
                    aVar3.sex = alaLiveUserInfoData.sex;
                    aVar2.b(aVar3);
                    aVar2.setContent(content);
                    aVar2.setMsgType(aVar.tl());
                    aVar2.cJ(aVar.ti());
                    aVar2.a(aVar.tj());
                    aVar2.k(aVar.tk());
                    aVar2.setUserId(alaLiveUserInfoData.userId);
                    aVar2.cD(String.valueOf(this.Qb.mLiveInfo.user_id));
                    aVar2.setBornTime(System.currentTimeMillis());
                    str = aVar2.sd();
                }
            }
            eVar.avw = str;
            com.baidu.c.b.a.aB(this.mContext).xc().a(str2, eVar, new com.baidu.c.a.b.a.f() { // from class: com.baidu.live.im.f.2
                @Override // com.baidu.c.a.b.a.f
                public void a(String str3, int i, List<com.baidu.c.a.b.a.c> list) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ IM消息 onSendSuccess s:" + str3 + ", i:" + i);
                    }
                    if (f.this.Qb != null && f.this.PG != null && f.this.PH != null) {
                        if (TextUtils.equals(str3, f.this.PG) || TextUtils.equals(str3, f.this.PH)) {
                            ALAGroupCommitHttpResponsedMessage aLAGroupCommitHttpResponsedMessage = new ALAGroupCommitHttpResponsedMessage();
                            aLAGroupCommitHttpResponsedMessage.setStatusCode(200, null);
                            if (f.this.Qb.mLiveInfo != null) {
                                if (TbadkCoreApplication.getInst().isHaokan()) {
                                    AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SUC_SEND_NEWS);
                                    alaStaticItem.addParams("live_id", f.this.Qb.mLiveInfo.live_id + "");
                                    alaStaticItem.addParams("room_id", f.this.Qb.mLiveInfo.room_id + "");
                                    alaStaticItem.addParams("feed_id", f.this.Qb.mLiveInfo.feed_id + "");
                                    alaStaticItem.addParams("other_params", aVar.tm());
                                    if (aVar.tl() == 126) {
                                        alaStaticItem.addParams("gifts_value", String.valueOf(aVar.tn()));
                                    }
                                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                                }
                                if (TbadkCoreApplication.getInst().isQuanmin()) {
                                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SUC_SEND_NEWS);
                                    alaStaticItem2.addParams("live_id", f.this.Qb.mLiveInfo.live_id + "");
                                    alaStaticItem2.addParams("room_id", f.this.Qb.mLiveInfo.room_id + "");
                                    alaStaticItem2.addParams("feed_id", f.this.Qb.mLiveInfo.feed_id + "");
                                    alaStaticItem2.addParams("other_params", aVar.tm());
                                    if (aVar.tl() == 126) {
                                        alaStaticItem2.addParams("gifts_value", String.valueOf(aVar.tn()));
                                    }
                                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                                }
                            }
                            if (i == 0) {
                                f.this.D(list);
                            } else if (i == 22) {
                                aLAGroupCommitHttpResponsedMessage.setError(22);
                                aLAGroupCommitHttpResponsedMessage.setErrorString("");
                            } else if (i == 1000) {
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(aLAGroupCommitHttpResponsedMessage);
                            if (com.baidu.live.liveroom.a.tY().tZ()) {
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
    public void D(List<com.baidu.c.a.b.a.c> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.c.a.b.a.c cVar : list) {
                if (cVar != null) {
                    String str = "";
                    if (!TextUtils.isEmpty(cVar.avg)) {
                        str = cVar.avg;
                    } else if (cVar.avv != null && cVar.avv.avJ != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(cVar.avv.avJ);
                            if (!TextUtils.isEmpty(jSONObject.optString("room_id"))) {
                                str = jSONObject.optString("room_id");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    if (TextUtils.isEmpty(str) || TextUtils.equals(str, this.PG) || TextUtils.equals(str, this.PH)) {
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
                this.agp.d(afY, arrayList2);
            }
        }
    }

    private void cG(String str) {
        com.baidu.c.b.a.aB(this.mContext).xc().a(str, this.agp);
    }
}
