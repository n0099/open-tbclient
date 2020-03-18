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
import com.baidu.swan.games.utils.so.SoUtils;
import com.google.android.exoplayer2.Format;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {
    private static volatile f arX = null;
    private static int arY = Integer.MAX_VALUE;
    private com.baidu.live.data.m YG;
    private String Yh;
    private String Yi;
    private List<String> asb;
    private BdUniqueId asc;
    private List<AlaLiveMarkData> asd;
    private long ase;
    private Context mContext;
    private int arZ = 0;
    private int asa = 0;
    private CustomMessageListener asf = new CustomMessageListener(2913081) { // from class: com.baidu.live.im.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.data.m mVar;
            int i;
            String str;
            String str2;
            if (customResponsedMessage.hasError() || customResponsedMessage.getError() != 0 || com.baidu.g.b.a.aO(f.this.mContext).BW() == null || !(customResponsedMessage.getData() instanceof com.baidu.live.data.m) || (mVar = (com.baidu.live.data.m) customResponsedMessage.getData()) == null) {
                return;
            }
            if ((mVar.mLiveSdkInfo != null && mVar.mLiveSdkInfo.mCastIds != null) || (mVar.mLiveInfo != null && mVar.mLiveInfo.mCastIds != null)) {
                if (mVar.mLiveInfo == null || mVar.mLiveInfo.live_status != 2) {
                    f.this.YG = mVar;
                    f.this.A(f.this.YG.Ys);
                    if (mVar.mLiveSdkInfo != null && mVar.mLiveSdkInfo.mCastIds != null) {
                        f.this.Yh = f.this.YG.mLiveSdkInfo.mCastIds.Yh;
                        String str3 = f.this.YG.mLiveSdkInfo.mCastIds.Yj;
                        f.this.Yi = f.this.YG.mLiveSdkInfo.mCastIds.Yi;
                        String str4 = f.this.YG.mLiveSdkInfo.mCastIds.Yl;
                        i = JavaTypesHelper.toInt(f.this.YG.mLiveSdkInfo.mCastIds.Ym, 5) * 1000;
                        str = str4;
                        str2 = str3;
                    } else if (mVar.mLiveInfo != null && mVar.mLiveInfo.mCastIds != null) {
                        f.this.Yh = f.this.YG.mLiveInfo.mCastIds.Yh;
                        String str5 = f.this.YG.mLiveInfo.mCastIds.Yj;
                        f.this.Yi = f.this.YG.mLiveInfo.mCastIds.Yi;
                        String str6 = f.this.YG.mLiveInfo.mCastIds.Yl;
                        i = JavaTypesHelper.toInt(f.this.YG.mLiveInfo.mCastIds.Ym, 5) * 1000;
                        str = str6;
                        str2 = str5;
                    } else {
                        i = 5000;
                        str = "";
                        str2 = "";
                    }
                    f.this.a(f.this.Yh, str2, i, false);
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", f.this.Yh, f.this.Yh, 0, "", "", "");
                    f.this.a(f.this.Yi, str, i, mVar.isHost);
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", f.this.Yh, f.this.Yi, 0, "", "", "");
                }
            }
        }
    };
    private CustomMessageListener asg = new CustomMessageListener(2913082) { // from class: com.baidu.live.im.f.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof com.baidu.live.data.m)) {
                f.this.YG = (com.baidu.live.data.m) customResponsedMessage.getData();
                f.this.A(f.this.YG.Ys);
            }
        }
    };
    private CustomMessageListener ash = new CustomMessageListener(2913118) { // from class: com.baidu.live.im.f.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof com.baidu.live.data.m)) {
                f.this.A(((com.baidu.live.data.m) customResponsedMessage.getData()).Ys);
            }
        }
    };
    private HttpRule asi = new HttpRule(1021013) { // from class: com.baidu.live.im.f.8
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
    private HttpRule asj = new HttpRule(1021012) { // from class: com.baidu.live.im.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            return null;
        }
    };
    CustomMessageListener ask = new CustomMessageListener(2913084) { // from class: com.baidu.live.im.f.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.wo();
        }
    };
    CustomMessageListener ahe = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.im.f.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.wq();
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.im.f.11.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.wr();
                }
            });
        }
    };
    private HttpRule asl = new HttpRule(1021006) { // from class: com.baidu.live.im.f.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            f.this.wq();
            if (f.this.YG != null && f.this.YG.mLiveSdkInfo != null && f.this.YG.mLiveSdkInfo.mCastIds != null) {
                String str = f.this.YG.mLiveSdkInfo.mCastIds.Yh;
                String str2 = f.this.YG.mLiveSdkInfo.mCastIds.Yi;
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str, -1, "", "", "");
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str2, -1, "", "", "");
            }
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.im.f.12.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.wr();
                }
            });
            return httpMessage;
        }
    };
    private IFetchMsgByIdListener asn = new IFetchMsgByIdListener() { // from class: com.baidu.live.im.f.3
        @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
        public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList) {
            f.this.b(i, arrayList);
        }
    };
    private com.baidu.g.a.b.a.d aso = new com.baidu.g.a.b.a.d() { // from class: com.baidu.live.im.f.4
        @Override // com.baidu.g.a.b.a.d
        public void d(int i, List<com.baidu.g.a.b.a.c> list) {
            if (f.this.YG != null && f.this.Yh != null && f.this.Yi != null && f.this.YG.mLiveInfo != null) {
                if (i == 0 || i == f.arY) {
                    ALAGroupHttpResponseMessage aLAGroupHttpResponseMessage = new ALAGroupHttpResponseMessage();
                    ArrayList arrayList = new ArrayList();
                    if (f.this.asb != null) {
                        f.this.asb.clear();
                    }
                    for (com.baidu.g.a.b.a.c cVar : list) {
                        if (cVar != null) {
                            String str = "";
                            String str2 = "";
                            if (!TextUtils.isEmpty(cVar.aHV)) {
                                str = cVar.aHV;
                            } else if (cVar.aIk != null && cVar.aIk.aIy != null) {
                                try {
                                    JSONObject jSONObject = new JSONObject(cVar.aIk.aIy);
                                    if (!TextUtils.isEmpty(jSONObject.optString("room_id"))) {
                                        str = jSONObject.optString("room_id");
                                    }
                                    str2 = jSONObject.optString("msg_type");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            if (TextUtils.isEmpty(str) || TextUtils.equals(str, f.this.Yh) || TextUtils.equals(str, f.this.Yi)) {
                                if (!TextUtils.equals(cVar.type, "0") || !TextUtils.isEmpty(str)) {
                                    if (!TextUtils.isEmpty(str) || !TextUtils.equals(str2, SoUtils.SO_EVENT_ID_DEFAULT)) {
                                        List<a> a = p.a(cVar);
                                        if (a != null) {
                                            if (TextUtils.equals(cVar.type, "0")) {
                                                for (int i2 = 0; i2 < a.size(); i2++) {
                                                    a aVar = a.get(i2);
                                                    if (aVar.xt() != null && (!TextUtils.isEmpty(aVar.xt().name_show) || !TextUtils.isEmpty(aVar.xt().userName))) {
                                                        arrayList.add(aVar);
                                                    }
                                                }
                                            } else {
                                                arrayList.addAll(a);
                                            }
                                            if (i == 0 && cVar.aIk != null && !TextUtils.isEmpty(cVar.aIk.aIy)) {
                                                if (f.this.asb == null) {
                                                    f.this.asb = new ArrayList();
                                                }
                                                f.this.asb.add(cVar.aIk.aIy);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        aLAGroupHttpResponseMessage.aW(i == f.arY);
                        aLAGroupHttpResponseMessage.F(arrayList);
                        aLAGroupHttpResponseMessage.setGroupId(f.this.YG.mLiveInfo.getGroupID());
                        MessageManager.getInstance().dispatchResponsedMessage(aLAGroupHttpResponseMessage);
                        if (f.this.asb != null && !f.this.asb.isEmpty()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913107, f.this.asb));
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener asp = new CustomMessageListener(2913108) { // from class: com.baidu.live.im.f.5
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
                if (i != 0 && i == f.this.asc.getId() && f.this.YG != null) {
                    f.this.arZ = 0;
                    f.this.asa = 0;
                    f.this.Yh = f.this.YG.mLiveSdkInfo.mCastIds.Yh;
                    String str = f.this.YG.mLiveSdkInfo.mCastIds.Yj;
                    f.this.Yi = f.this.YG.mLiveSdkInfo.mCastIds.Yi;
                    String str2 = f.this.YG.mLiveSdkInfo.mCastIds.Yl;
                    int i2 = JavaTypesHelper.toInt(f.this.YG.mLiveSdkInfo.mCastIds.Ym, 5) * 1000;
                    f.this.a(f.this.Yh, str, i2, false);
                    f.this.a(f.this.Yi, str2, i2, f.this.YG.isHost);
                }
            }
        }
    };

    public static f wn() {
        if (arX == null) {
            synchronized (f.class) {
                if (arX == null) {
                    arX = new f();
                }
            }
        }
        return arX;
    }

    private f() {
    }

    public void aD(Context context) {
        this.mContext = context;
        MessageManager.getInstance().unRegisterListener(this.asf);
        MessageManager.getInstance().registerListener(this.asf);
        MessageManager.getInstance().removeMessageRule(this.asj);
        MessageManager.getInstance().addMessageRule(this.asj);
        MessageManager.getInstance().unRegisterListener(this.ask);
        MessageManager.getInstance().registerListener(this.ask);
        MessageManager.getInstance().unRegisterListener(this.asp);
        MessageManager.getInstance().registerListener(this.asp);
    }

    public void wo() {
        com.baidu.g.b.a.aO(this.mContext).BW().wq();
        this.ase = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final String str2, final int i, final boolean z) {
        if (TbConfig.IM_LOG) {
            Log.i("imlog", "@.@ enterRoom roomid:" + str + ", url:" + str2);
        }
        com.baidu.g.b.a.aO(this.mContext).BW().a(str, str2, i, new com.baidu.g.a.b.b() { // from class: com.baidu.live.im.f.13
            @Override // com.baidu.g.a.b.b
            public void onResult(int i2, long j, long j2) {
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ enterRoom onResult i:" + i2 + ", l:" + j + ", l1:" + j2);
                }
                if (f.this.YG == null || f.this.Yh == null || f.this.Yi == null) {
                    com.baidu.g.b.a.aO(f.this.mContext).BW().et(String.valueOf(j));
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.Yh, String.valueOf(j), -1, "", "", "");
                    return;
                }
                long j3 = JavaTypesHelper.toLong(f.this.Yh, -1L);
                long j4 = JavaTypesHelper.toLong(f.this.Yi, -1L);
                if (j3 != j && j4 != j) {
                    com.baidu.g.b.a.aO(f.this.mContext).BW().et(String.valueOf(j));
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.Yh, String.valueOf(j), -1, "", "", "");
                    if (TbConfig.IM_LOG) {
                        Log.e("imlog", "BDIM enterRoom wrong then exit end:" + j);
                    }
                } else if (i2 == 1000) {
                    IExtraParams buildParamsExtra = ExtraParamsManager.getInstance().buildParamsExtra();
                    if (buildParamsExtra != null) {
                        try {
                            HashMap hashMap = new HashMap();
                            hashMap.put(ExtraParamsManager.KEY_PROCESS_PLUGIN_ASYNC_CALLBACK, "");
                            f.this.asc = BdUniqueId.gen();
                            hashMap.put("id", Integer.valueOf(f.this.asc.getId()));
                            hashMap.put("cmd", 2913108);
                            buildParamsExtra.process(hashMap);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_FAIL_IM_NOT_LOGIN, f.this.Yh, str, -1, "", "", "");
                } else if (i2 == 1314 || i2 == 1306) {
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_MSG_ENTER_IM_FAIL, f.this.Yh, str, -1, String.valueOf(i2), "", "");
                } else if (i2 != 0) {
                    if (j3 == j) {
                        if (f.this.arZ < 3) {
                            f.this.a(str, str2, i, z);
                            f.this.arZ++;
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_MSG_FAIL_TO_REJOIN, f.this.Yh, str, -1, "", "", "");
                            return;
                        }
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.Yh, str, -1, "", "", "");
                    } else if (f.this.asa < 3) {
                        f.this.a(str, str2, i, z);
                        f.this.asa++;
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_GIFT_FAIL_TO_REJOIN, f.this.Yh, str, -1, "", "", "");
                    } else {
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.Yh, str, -1, "", "", "");
                    }
                } else if (j3 == j) {
                    f.this.arZ = 0;
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", f.this.Yh, str, 0, "", "", "");
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ enterRoom onResult JOIN Msg成功:" + j3);
                    }
                    if ((!f.this.YG.isHost || (f.this.YG.isHost && f.this.YG.Yv)) && f.this.ase != j3) {
                        f.this.ase = j3;
                        ChatMsgManagerImpl.getInstance(f.this.mContext).fetchMsgidByMsgid(f.this.mContext, 4, JavaTypesHelper.toLong(str, -1L), 0L, Format.OFFSET_SAMPLE_RELATIVE, -20, 1, 0, f.this.asn);
                    }
                } else {
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", f.this.Yh, str, 0, "", "", "");
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ enterRoom onResult JOIN Gift成功:" + j4);
                    }
                    f.this.asa = 0;
                }
            }
        }, z);
        wp();
        dK(str);
    }

    private void wp() {
        MessageManager.getInstance().unRegisterListener(this.ahe);
        MessageManager.getInstance().registerListener(this.ahe);
        MessageManager.getInstance().unRegisterListener(this.asg);
        MessageManager.getInstance().registerListener(this.asg);
        MessageManager.getInstance().unRegisterListener(this.ash);
        MessageManager.getInstance().registerListener(this.ash);
        MessageManager.getInstance().removeMessageRule(this.asi);
        MessageManager.getInstance().addMessageRule(this.asi);
        MessageManager.getInstance().removeMessageRule(this.asl);
        MessageManager.getInstance().addMessageRule(this.asl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wq() {
        if (this.YG != null && this.YG.mLiveSdkInfo != null && this.YG.mLiveSdkInfo.mCastIds != null) {
            String str = this.YG.mLiveSdkInfo.mCastIds.Yh;
            String str2 = this.YG.mLiveSdkInfo.mCastIds.Yi;
            com.baidu.g.b.a.aO(this.mContext).BW().et(str);
            com.baidu.g.b.a.aO(this.mContext).BW().et(str2);
        }
        this.ase = 0L;
        this.YG = null;
        this.Yh = null;
        this.Yi = null;
        this.arZ = 0;
        this.asa = 0;
        if (this.asb != null) {
            this.asb.clear();
            this.asb = null;
        }
        if (this.asd != null) {
            this.asd.clear();
            this.asd = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wr() {
        MessageManager.getInstance().unRegisterListener(this.asg);
        MessageManager.getInstance().unRegisterListener(this.ash);
        MessageManager.getInstance().unRegisterListener(this.ahe);
        MessageManager.getInstance().removeMessageRule(this.asi);
        MessageManager.getInstance().removeMessageRule(this.asl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(List<AlaLiveMarkData> list) {
        if (list != null && !list.isEmpty()) {
            if (this.asd == null) {
                this.asd = new ArrayList();
            }
            this.asd.clear();
            this.asd.addAll(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.live.im.message.a aVar) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        String str = null;
        String content = aVar.getContent();
        String str2 = (this.YG == null || this.YG.mLiveSdkInfo == null || this.YG.mLiveSdkInfo.mCastIds == null) ? null : this.YG.mLiveSdkInfo.mCastIds.Yh;
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.g.a.b.a.e eVar = new com.baidu.g.a.b.a.e();
            eVar.msg = content;
            eVar.aHV = str2;
            if (this.YG != null && this.YG.Yo != null) {
                eVar.name = this.YG.Yo.userName;
                eVar.portrait = this.YG.Yo.portrait;
            }
            a aVar2 = new a();
            if (this.YG != null) {
                if (this.YG.isHost) {
                    alaLiveUserInfoData = this.YG.Ya;
                } else {
                    alaLiveUserInfoData = this.YG.Yo;
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
                    aVar3.Xq = alaLiveUserInfoData.followCount;
                    aVar3.Xp = alaLiveUserInfoData.fansCount;
                    aVar3.Xt = alaLiveUserInfoData.isAdmin == 1;
                    aVar3.Xs = alaLiveUserInfoData.isOfficial == 1;
                    aVar3.level_id = alaLiveUserInfoData.levelId;
                    aVar3.Xv = this.asd;
                    aVar3.sex = alaLiveUserInfoData.sex;
                    aVar3.extraUserInfo = alaLiveUserInfoData.extraUserInfo;
                    aVar2.d(aVar3);
                    aVar2.setContent(content);
                    aVar2.setMsgType(aVar.xB());
                    aVar2.bX(aVar.xx());
                    aVar2.dM(aVar.xy());
                    aVar2.a(aVar.xz());
                    aVar2.l(aVar.xA());
                    aVar2.setUserId(alaLiveUserInfoData.userId);
                    aVar2.dH(String.valueOf(this.YG.mLiveInfo.user_id));
                    aVar2.setBornTime(System.currentTimeMillis());
                    str = aVar2.vV();
                }
            }
            eVar.aIl = str;
            com.baidu.g.b.a.aO(this.mContext).BW().a(str2, eVar, new com.baidu.g.a.b.a.f() { // from class: com.baidu.live.im.f.2
                @Override // com.baidu.g.a.b.a.f
                public void a(String str3, int i, List<com.baidu.g.a.b.a.c> list) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ IM消息 onSendSuccess s:" + str3 + ", i:" + i);
                    }
                    if (f.this.YG != null && f.this.Yh != null && f.this.Yi != null) {
                        if (TextUtils.equals(str3, f.this.Yh) || TextUtils.equals(str3, f.this.Yi)) {
                            ALAGroupCommitHttpResponsedMessage aLAGroupCommitHttpResponsedMessage = new ALAGroupCommitHttpResponsedMessage();
                            aLAGroupCommitHttpResponsedMessage.setStatusCode(200, null);
                            if (f.this.YG.mLiveInfo != null) {
                                if (TbadkCoreApplication.getInst().isHaokan()) {
                                    AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SUC_SEND_NEWS);
                                    alaStaticItem.addParams("live_id", f.this.YG.mLiveInfo.live_id + "");
                                    alaStaticItem.addParams("room_id", f.this.YG.mLiveInfo.room_id + "");
                                    alaStaticItem.addParams("feed_id", f.this.YG.mLiveInfo.feed_id + "");
                                    alaStaticItem.addParams("other_params", aVar.xC());
                                    if (aVar.xB() == 126) {
                                        alaStaticItem.addParams("gifts_value", String.valueOf(aVar.xD()));
                                    }
                                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                                }
                                if (TbadkCoreApplication.getInst().isQuanmin()) {
                                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SUC_SEND_NEWS);
                                    alaStaticItem2.addParams("live_id", f.this.YG.mLiveInfo.live_id + "");
                                    alaStaticItem2.addParams("room_id", f.this.YG.mLiveInfo.room_id + "");
                                    alaStaticItem2.addParams("feed_id", f.this.YG.mLiveInfo.feed_id + "");
                                    alaStaticItem2.addParams("other_params", aVar.xC());
                                    if (aVar.xB() == 126) {
                                        alaStaticItem2.addParams("gifts_value", String.valueOf(aVar.xD()));
                                    }
                                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                                }
                            }
                            if (i == 0) {
                                f.this.B(list);
                            } else if (i == 22) {
                                aLAGroupCommitHttpResponsedMessage.setError(22);
                                aLAGroupCommitHttpResponsedMessage.setErrorString("");
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(aLAGroupCommitHttpResponsedMessage);
                            if (com.baidu.live.liveroom.a.yr().ys()) {
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
    public void B(List<com.baidu.g.a.b.a.c> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.g.a.b.a.c cVar : list) {
                if (cVar != null) {
                    String str = "";
                    if (!TextUtils.isEmpty(cVar.aHV)) {
                        str = cVar.aHV;
                    } else if (cVar.aIk != null && cVar.aIk.aIy != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(cVar.aIk.aIy);
                            if (!TextUtils.isEmpty(jSONObject.optString("room_id"))) {
                                str = jSONObject.optString("room_id");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    if (TextUtils.isEmpty(str) || TextUtils.equals(str, this.Yh) || TextUtils.equals(str, this.Yi)) {
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
                com.baidu.g.a.b.a.c a = com.baidu.g.b.a.a.a.a.a(it.next());
                if (a != null) {
                    arrayList2.add(a);
                }
            }
            if (!arrayList2.isEmpty()) {
                Collections.reverse(arrayList2);
                this.aso.d(arY, arrayList2);
            }
        }
    }

    private void dK(String str) {
        com.baidu.g.b.a.aO(this.mContext).BW().a(str, this.aso);
    }
}
