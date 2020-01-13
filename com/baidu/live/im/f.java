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
/* loaded from: classes2.dex */
public class f {
    private static f aou = null;
    private static int aov = Integer.MAX_VALUE;
    private com.baidu.live.data.l WK;
    private String Wm;
    private String Wn;
    private List<AlaLiveMarkData> aoA;
    private long aoB;
    private List<String> aoy;
    private BdUniqueId aoz;
    private Context mContext;
    private int aow = 0;
    private int aox = 0;
    private CustomMessageListener aoC = new CustomMessageListener(2913081) { // from class: com.baidu.live.im.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.data.l lVar;
            int i;
            String str;
            String str2;
            if (customResponsedMessage.hasError() || customResponsedMessage.getError() != 0 || com.baidu.g.b.a.aL(f.this.mContext).zx() == null || !(customResponsedMessage.getData() instanceof com.baidu.live.data.l) || (lVar = (com.baidu.live.data.l) customResponsedMessage.getData()) == null) {
                return;
            }
            if ((lVar.mLiveSdkInfo != null && lVar.mLiveSdkInfo.mCastIds != null) || (lVar.mLiveInfo != null && lVar.mLiveInfo.mCastIds != null)) {
                if (lVar.mLiveInfo == null || lVar.mLiveInfo.live_status != 2) {
                    f.this.WK = lVar;
                    f.this.A(f.this.WK.Wx);
                    if (lVar.mLiveSdkInfo != null && lVar.mLiveSdkInfo.mCastIds != null) {
                        f.this.Wm = f.this.WK.mLiveSdkInfo.mCastIds.Wm;
                        String str3 = f.this.WK.mLiveSdkInfo.mCastIds.Wo;
                        f.this.Wn = f.this.WK.mLiveSdkInfo.mCastIds.Wn;
                        String str4 = f.this.WK.mLiveSdkInfo.mCastIds.Wq;
                        i = JavaTypesHelper.toInt(f.this.WK.mLiveSdkInfo.mCastIds.Wr, 5) * 1000;
                        str = str4;
                        str2 = str3;
                    } else if (lVar.mLiveInfo != null && lVar.mLiveInfo.mCastIds != null) {
                        f.this.Wm = f.this.WK.mLiveInfo.mCastIds.Wm;
                        String str5 = f.this.WK.mLiveInfo.mCastIds.Wo;
                        f.this.Wn = f.this.WK.mLiveInfo.mCastIds.Wn;
                        String str6 = f.this.WK.mLiveInfo.mCastIds.Wq;
                        i = JavaTypesHelper.toInt(f.this.WK.mLiveInfo.mCastIds.Wr, 5) * 1000;
                        str = str6;
                        str2 = str5;
                    } else {
                        i = 5000;
                        str = "";
                        str2 = "";
                    }
                    f.this.a(f.this.Wm, str2, i, false);
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", f.this.Wm, f.this.Wm, 0, "", "", "");
                    f.this.a(f.this.Wn, str, i, lVar.isHost);
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", f.this.Wm, f.this.Wn, 0, "", "", "");
                }
            }
        }
    };
    private CustomMessageListener aoD = new CustomMessageListener(2913082) { // from class: com.baidu.live.im.f.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof com.baidu.live.data.l)) {
                f.this.WK = (com.baidu.live.data.l) customResponsedMessage.getData();
                f.this.A(f.this.WK.Wx);
            }
        }
    };
    private CustomMessageListener aoE = new CustomMessageListener(2913118) { // from class: com.baidu.live.im.f.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof com.baidu.live.data.l)) {
                f.this.A(((com.baidu.live.data.l) customResponsedMessage.getData()).Wx);
            }
        }
    };
    private HttpRule aoF = new HttpRule(1021013) { // from class: com.baidu.live.im.f.8
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
    private HttpRule aoG = new HttpRule(1021012) { // from class: com.baidu.live.im.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            return null;
        }
    };
    CustomMessageListener aoH = new CustomMessageListener(2913084) { // from class: com.baidu.live.im.f.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.uF();
        }
    };
    CustomMessageListener aeN = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.im.f.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.uH();
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.im.f.11.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.uI();
                }
            });
        }
    };
    private HttpRule aoI = new HttpRule(1021006) { // from class: com.baidu.live.im.f.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            f.this.uH();
            if (f.this.WK != null && f.this.WK.mLiveSdkInfo != null && f.this.WK.mLiveSdkInfo.mCastIds != null) {
                String str = f.this.WK.mLiveSdkInfo.mCastIds.Wm;
                String str2 = f.this.WK.mLiveSdkInfo.mCastIds.Wn;
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str, -1, "", "", "");
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str2, -1, "", "", "");
            }
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.im.f.12.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.uI();
                }
            });
            return httpMessage;
        }
    };
    private IFetchMsgByIdListener aoJ = new IFetchMsgByIdListener() { // from class: com.baidu.live.im.f.3
        @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
        public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList) {
            f.this.b(i, arrayList);
        }
    };
    private com.baidu.g.a.b.a.d aoK = new com.baidu.g.a.b.a.d() { // from class: com.baidu.live.im.f.4
        @Override // com.baidu.g.a.b.a.d
        public void d(int i, List<com.baidu.g.a.b.a.c> list) {
            if (f.this.WK != null && f.this.Wm != null && f.this.Wn != null && f.this.WK.mLiveInfo != null) {
                if (i == 0 || i == f.aov) {
                    ALAGroupHttpResponseMessage aLAGroupHttpResponseMessage = new ALAGroupHttpResponseMessage();
                    ArrayList arrayList = new ArrayList();
                    if (f.this.aoy != null) {
                        f.this.aoy.clear();
                    }
                    for (com.baidu.g.a.b.a.c cVar : list) {
                        if (cVar != null) {
                            String str = "";
                            String str2 = "";
                            if (!TextUtils.isEmpty(cVar.aDy)) {
                                str = cVar.aDy;
                            } else if (cVar.aDN != null && cVar.aDN.aEb != null) {
                                try {
                                    JSONObject jSONObject = new JSONObject(cVar.aDN.aEb);
                                    if (!TextUtils.isEmpty(jSONObject.optString("room_id"))) {
                                        str = jSONObject.optString("room_id");
                                    }
                                    str2 = jSONObject.optString("msg_type");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            if (TextUtils.isEmpty(str) || TextUtils.equals(str, f.this.Wm) || TextUtils.equals(str, f.this.Wn)) {
                                if (!TextUtils.equals(cVar.type, "0") || !TextUtils.isEmpty(str)) {
                                    if (!TextUtils.isEmpty(str) || !TextUtils.equals(str2, SoUtils.SO_EVENT_ID_DEFAULT)) {
                                        List<a> a = p.a(cVar);
                                        if (a != null) {
                                            if (TextUtils.equals(cVar.type, "0")) {
                                                for (int i2 = 0; i2 < a.size(); i2++) {
                                                    a aVar = a.get(i2);
                                                    if (aVar.vq() != null && (!TextUtils.isEmpty(aVar.vq().name_show) || !TextUtils.isEmpty(aVar.vq().userName))) {
                                                        arrayList.add(aVar);
                                                    }
                                                }
                                            } else {
                                                arrayList.addAll(a);
                                            }
                                            if (i == 0 && cVar.aDN != null && !TextUtils.isEmpty(cVar.aDN.aEb)) {
                                                if (f.this.aoy == null) {
                                                    f.this.aoy = new ArrayList();
                                                }
                                                f.this.aoy.add(cVar.aDN.aEb);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        aLAGroupHttpResponseMessage.aT(i == f.aov);
                        aLAGroupHttpResponseMessage.F(arrayList);
                        aLAGroupHttpResponseMessage.setGroupId(f.this.WK.mLiveInfo.getGroupID());
                        MessageManager.getInstance().dispatchResponsedMessage(aLAGroupHttpResponseMessage);
                        if (f.this.aoy != null && !f.this.aoy.isEmpty()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913107, f.this.aoy));
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener aoL = new CustomMessageListener(2913108) { // from class: com.baidu.live.im.f.5
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
                if (i != 0 && i == f.this.aoz.getId() && f.this.WK != null) {
                    f.this.aow = 0;
                    f.this.aox = 0;
                    f.this.Wm = f.this.WK.mLiveSdkInfo.mCastIds.Wm;
                    String str = f.this.WK.mLiveSdkInfo.mCastIds.Wo;
                    f.this.Wn = f.this.WK.mLiveSdkInfo.mCastIds.Wn;
                    String str2 = f.this.WK.mLiveSdkInfo.mCastIds.Wq;
                    int i2 = JavaTypesHelper.toInt(f.this.WK.mLiveSdkInfo.mCastIds.Wr, 5) * 1000;
                    f.this.a(f.this.Wm, str, i2, false);
                    f.this.a(f.this.Wn, str2, i2, f.this.WK.isHost);
                }
            }
        }
    };

    public static f uE() {
        if (aou == null) {
            synchronized (f.class) {
                if (aou == null) {
                    aou = new f();
                }
            }
        }
        return aou;
    }

    private f() {
    }

    public void aB(Context context) {
        this.mContext = context;
        MessageManager.getInstance().unRegisterListener(this.aoC);
        MessageManager.getInstance().registerListener(this.aoC);
        MessageManager.getInstance().removeMessageRule(this.aoG);
        MessageManager.getInstance().addMessageRule(this.aoG);
        MessageManager.getInstance().unRegisterListener(this.aoH);
        MessageManager.getInstance().registerListener(this.aoH);
        MessageManager.getInstance().unRegisterListener(this.aoL);
        MessageManager.getInstance().registerListener(this.aoL);
    }

    public void uF() {
        com.baidu.g.b.a.aL(this.mContext).zx().uH();
        this.aoB = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final String str2, final int i, final boolean z) {
        if (TbConfig.IM_LOG) {
            Log.i("imlog", "@.@ enterRoom roomid:" + str + ", url:" + str2);
        }
        com.baidu.g.b.a.aL(this.mContext).zx().a(str, str2, i, new com.baidu.g.a.b.b() { // from class: com.baidu.live.im.f.13
            @Override // com.baidu.g.a.b.b
            public void onResult(int i2, long j, long j2) {
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ enterRoom onResult i:" + i2 + ", l:" + j + ", l1:" + j2);
                }
                if (f.this.WK == null || f.this.Wm == null || f.this.Wn == null) {
                    com.baidu.g.b.a.aL(f.this.mContext).zx().ef(String.valueOf(j));
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.Wm, String.valueOf(j), -1, "", "", "");
                    return;
                }
                long j3 = JavaTypesHelper.toLong(f.this.Wm, -1L);
                long j4 = JavaTypesHelper.toLong(f.this.Wn, -1L);
                if (j3 != j && j4 != j) {
                    com.baidu.g.b.a.aL(f.this.mContext).zx().ef(String.valueOf(j));
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.Wm, String.valueOf(j), -1, "", "", "");
                    if (TbConfig.IM_LOG) {
                        Log.e("imlog", "BDIM enterRoom wrong then exit end:" + j);
                    }
                } else if (i2 == 1000) {
                    IExtraParams buildParamsExtra = ExtraParamsManager.getInstance().buildParamsExtra();
                    if (buildParamsExtra != null) {
                        try {
                            HashMap hashMap = new HashMap();
                            hashMap.put(ExtraParamsManager.KEY_PROCESS_PLUGIN_ASYNC_CALLBACK, "");
                            f.this.aoz = BdUniqueId.gen();
                            hashMap.put("id", Integer.valueOf(f.this.aoz.getId()));
                            hashMap.put("cmd", 2913108);
                            buildParamsExtra.process(hashMap);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_FAIL_IM_NOT_LOGIN, f.this.Wm, str, -1, "", "", "");
                } else if (i2 != 0) {
                    if (j3 == j) {
                        if (f.this.aow < 3) {
                            f.this.a(str, str2, i, z);
                            f.this.aow++;
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_MSG_FAIL_TO_REJOIN, f.this.Wm, str, -1, "", "", "");
                            return;
                        }
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.Wm, str, -1, "", "", "");
                    } else if (f.this.aox < 3) {
                        f.this.a(str, str2, i, z);
                        f.this.aox++;
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_GIFT_FAIL_TO_REJOIN, f.this.Wm, str, -1, "", "", "");
                    } else {
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.Wm, str, -1, "", "", "");
                    }
                } else if (j3 == j) {
                    f.this.aow = 0;
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", f.this.Wm, str, 0, "", "", "");
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ enterRoom onResult JOIN Msg成功:" + j3);
                    }
                    if (!f.this.WK.isHost && f.this.aoB != j3) {
                        f.this.aoB = j3;
                        ChatMsgManagerImpl.getInstance(f.this.mContext).fetchMsgidByMsgid(f.this.mContext, 4, JavaTypesHelper.toLong(str, -1L), 0L, Format.OFFSET_SAMPLE_RELATIVE, -20, 1, 0, f.this.aoJ);
                    }
                } else {
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", f.this.Wm, str, 0, "", "", "");
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ enterRoom onResult JOIN Gift成功:" + j4);
                    }
                    f.this.aox = 0;
                }
            }
        }, z);
        uG();
        dA(str);
    }

    private void uG() {
        MessageManager.getInstance().unRegisterListener(this.aeN);
        MessageManager.getInstance().registerListener(this.aeN);
        MessageManager.getInstance().unRegisterListener(this.aoD);
        MessageManager.getInstance().registerListener(this.aoD);
        MessageManager.getInstance().unRegisterListener(this.aoE);
        MessageManager.getInstance().registerListener(this.aoE);
        MessageManager.getInstance().removeMessageRule(this.aoF);
        MessageManager.getInstance().addMessageRule(this.aoF);
        MessageManager.getInstance().removeMessageRule(this.aoI);
        MessageManager.getInstance().addMessageRule(this.aoI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uH() {
        if (this.WK != null && this.WK.mLiveSdkInfo != null && this.WK.mLiveSdkInfo.mCastIds != null) {
            String str = this.WK.mLiveSdkInfo.mCastIds.Wm;
            String str2 = this.WK.mLiveSdkInfo.mCastIds.Wn;
            com.baidu.g.b.a.aL(this.mContext).zx().ef(str);
            com.baidu.g.b.a.aL(this.mContext).zx().ef(str2);
        }
        this.aoB = 0L;
        this.WK = null;
        this.Wm = null;
        this.Wn = null;
        this.aow = 0;
        this.aox = 0;
        if (this.aoy != null) {
            this.aoy.clear();
            this.aoy = null;
        }
        if (this.aoA != null) {
            this.aoA.clear();
            this.aoA = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uI() {
        MessageManager.getInstance().unRegisterListener(this.aoD);
        MessageManager.getInstance().unRegisterListener(this.aoE);
        MessageManager.getInstance().unRegisterListener(this.aeN);
        MessageManager.getInstance().removeMessageRule(this.aoF);
        MessageManager.getInstance().removeMessageRule(this.aoI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(List<AlaLiveMarkData> list) {
        if (list != null && !list.isEmpty()) {
            if (this.aoA == null) {
                this.aoA = new ArrayList();
            }
            this.aoA.clear();
            this.aoA.addAll(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.live.im.message.a aVar) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        String str = null;
        String content = aVar.getContent();
        String str2 = (this.WK == null || this.WK.mLiveSdkInfo == null || this.WK.mLiveSdkInfo.mCastIds == null) ? null : this.WK.mLiveSdkInfo.mCastIds.Wm;
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.g.a.b.a.e eVar = new com.baidu.g.a.b.a.e();
            eVar.msg = content;
            eVar.aDy = str2;
            eVar.name = this.WK.Wt.userName;
            eVar.portrait = this.WK.Wt.portrait;
            a aVar2 = new a();
            if (this.WK != null) {
                if (this.WK.isHost) {
                    alaLiveUserInfoData = this.WK.Wf;
                } else {
                    alaLiveUserInfoData = this.WK.Wt;
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
                    aVar3.VA = alaLiveUserInfoData.followCount;
                    aVar3.Vz = alaLiveUserInfoData.fansCount;
                    aVar3.VD = alaLiveUserInfoData.isAdmin == 1;
                    aVar3.VC = alaLiveUserInfoData.isOfficial == 1;
                    aVar3.level_id = alaLiveUserInfoData.levelId;
                    aVar3.VF = this.aoA;
                    aVar3.sex = alaLiveUserInfoData.sex;
                    aVar2.b(aVar3);
                    aVar2.setContent(content);
                    aVar2.setMsgType(aVar.vy());
                    aVar2.bK(aVar.vu());
                    aVar2.dC(aVar.vv());
                    aVar2.a(aVar.vw());
                    aVar2.k(aVar.vx());
                    aVar2.setUserId(alaLiveUserInfoData.userId);
                    aVar2.dx(String.valueOf(this.WK.mLiveInfo.user_id));
                    aVar2.setBornTime(System.currentTimeMillis());
                    str = aVar2.um();
                }
            }
            eVar.aDO = str;
            com.baidu.g.b.a.aL(this.mContext).zx().a(str2, eVar, new com.baidu.g.a.b.a.f() { // from class: com.baidu.live.im.f.2
                @Override // com.baidu.g.a.b.a.f
                public void a(String str3, int i, List<com.baidu.g.a.b.a.c> list) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ IM消息 onSendSuccess s:" + str3 + ", i:" + i);
                    }
                    if (f.this.WK != null && f.this.Wm != null && f.this.Wn != null) {
                        if (TextUtils.equals(str3, f.this.Wm) || TextUtils.equals(str3, f.this.Wn)) {
                            ALAGroupCommitHttpResponsedMessage aLAGroupCommitHttpResponsedMessage = new ALAGroupCommitHttpResponsedMessage();
                            aLAGroupCommitHttpResponsedMessage.setStatusCode(200, null);
                            if (f.this.WK.mLiveInfo != null) {
                                if (TbadkCoreApplication.getInst().isHaokan()) {
                                    AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SUC_SEND_NEWS);
                                    alaStaticItem.addParams("live_id", f.this.WK.mLiveInfo.live_id + "");
                                    alaStaticItem.addParams("room_id", f.this.WK.mLiveInfo.room_id + "");
                                    alaStaticItem.addParams("feed_id", f.this.WK.mLiveInfo.feed_id + "");
                                    alaStaticItem.addParams("other_params", aVar.vz());
                                    if (aVar.vy() == 126) {
                                        alaStaticItem.addParams("gifts_value", String.valueOf(aVar.vA()));
                                    }
                                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                                }
                                if (TbadkCoreApplication.getInst().isQuanmin()) {
                                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SUC_SEND_NEWS);
                                    alaStaticItem2.addParams("live_id", f.this.WK.mLiveInfo.live_id + "");
                                    alaStaticItem2.addParams("room_id", f.this.WK.mLiveInfo.room_id + "");
                                    alaStaticItem2.addParams("feed_id", f.this.WK.mLiveInfo.feed_id + "");
                                    alaStaticItem2.addParams("other_params", aVar.vz());
                                    if (aVar.vy() == 126) {
                                        alaStaticItem2.addParams("gifts_value", String.valueOf(aVar.vA()));
                                    }
                                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                                }
                            }
                            if (i == 0) {
                                f.this.B(list);
                            } else if (i == 22) {
                                aLAGroupCommitHttpResponsedMessage.setError(22);
                                aLAGroupCommitHttpResponsedMessage.setErrorString("");
                            } else if (i == 1000) {
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(aLAGroupCommitHttpResponsedMessage);
                            if (com.baidu.live.liveroom.a.wl().wm()) {
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
                    if (!TextUtils.isEmpty(cVar.aDy)) {
                        str = cVar.aDy;
                    } else if (cVar.aDN != null && cVar.aDN.aEb != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(cVar.aDN.aEb);
                            if (!TextUtils.isEmpty(jSONObject.optString("room_id"))) {
                                str = jSONObject.optString("room_id");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    if (TextUtils.isEmpty(str) || TextUtils.equals(str, this.Wm) || TextUtils.equals(str, this.Wn)) {
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
                this.aoK.d(aov, arrayList2);
            }
        }
    }

    private void dA(String str) {
        com.baidu.g.b.a.aL(this.mContext).zx().a(str, this.aoK);
    }
}
