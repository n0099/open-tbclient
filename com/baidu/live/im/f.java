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
    private static volatile f arM = null;
    private static int arN = Integer.MAX_VALUE;
    private String XX;
    private String XY;
    private com.baidu.live.data.m Yw;
    private List<String> arQ;
    private BdUniqueId arR;
    private List<AlaLiveMarkData> arS;
    private long arT;
    private Context mContext;
    private int arO = 0;
    private int arP = 0;
    private CustomMessageListener arU = new CustomMessageListener(2913081) { // from class: com.baidu.live.im.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.data.m mVar;
            int i;
            String str;
            String str2;
            if (customResponsedMessage.hasError() || customResponsedMessage.getError() != 0 || com.baidu.g.b.a.aP(f.this.mContext).BP() == null || !(customResponsedMessage.getData() instanceof com.baidu.live.data.m) || (mVar = (com.baidu.live.data.m) customResponsedMessage.getData()) == null) {
                return;
            }
            if ((mVar.mLiveSdkInfo != null && mVar.mLiveSdkInfo.mCastIds != null) || (mVar.mLiveInfo != null && mVar.mLiveInfo.mCastIds != null)) {
                if (mVar.mLiveInfo == null || mVar.mLiveInfo.live_status != 2) {
                    f.this.Yw = mVar;
                    f.this.A(f.this.Yw.Yi);
                    if (mVar.mLiveSdkInfo != null && mVar.mLiveSdkInfo.mCastIds != null) {
                        f.this.XX = f.this.Yw.mLiveSdkInfo.mCastIds.XX;
                        String str3 = f.this.Yw.mLiveSdkInfo.mCastIds.XZ;
                        f.this.XY = f.this.Yw.mLiveSdkInfo.mCastIds.XY;
                        String str4 = f.this.Yw.mLiveSdkInfo.mCastIds.Yb;
                        i = JavaTypesHelper.toInt(f.this.Yw.mLiveSdkInfo.mCastIds.Yc, 5) * 1000;
                        str = str4;
                        str2 = str3;
                    } else if (mVar.mLiveInfo != null && mVar.mLiveInfo.mCastIds != null) {
                        f.this.XX = f.this.Yw.mLiveInfo.mCastIds.XX;
                        String str5 = f.this.Yw.mLiveInfo.mCastIds.XZ;
                        f.this.XY = f.this.Yw.mLiveInfo.mCastIds.XY;
                        String str6 = f.this.Yw.mLiveInfo.mCastIds.Yb;
                        i = JavaTypesHelper.toInt(f.this.Yw.mLiveInfo.mCastIds.Yc, 5) * 1000;
                        str = str6;
                        str2 = str5;
                    } else {
                        i = 5000;
                        str = "";
                        str2 = "";
                    }
                    f.this.a(f.this.XX, str2, i, false);
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", f.this.XX, f.this.XX, 0, "", "", "");
                    f.this.a(f.this.XY, str, i, mVar.isHost);
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", f.this.XX, f.this.XY, 0, "", "", "");
                }
            }
        }
    };
    private CustomMessageListener arV = new CustomMessageListener(2913082) { // from class: com.baidu.live.im.f.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof com.baidu.live.data.m)) {
                f.this.Yw = (com.baidu.live.data.m) customResponsedMessage.getData();
                f.this.A(f.this.Yw.Yi);
            }
        }
    };
    private CustomMessageListener arW = new CustomMessageListener(2913118) { // from class: com.baidu.live.im.f.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof com.baidu.live.data.m)) {
                f.this.A(((com.baidu.live.data.m) customResponsedMessage.getData()).Yi);
            }
        }
    };
    private HttpRule arX = new HttpRule(1021013) { // from class: com.baidu.live.im.f.8
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
    private HttpRule arY = new HttpRule(1021012) { // from class: com.baidu.live.im.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            return null;
        }
    };
    CustomMessageListener arZ = new CustomMessageListener(2913084) { // from class: com.baidu.live.im.f.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.wj();
        }
    };
    CustomMessageListener agU = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.im.f.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.wl();
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.im.f.11.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.wm();
                }
            });
        }
    };
    private HttpRule asa = new HttpRule(1021006) { // from class: com.baidu.live.im.f.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            f.this.wl();
            if (f.this.Yw != null && f.this.Yw.mLiveSdkInfo != null && f.this.Yw.mLiveSdkInfo.mCastIds != null) {
                String str = f.this.Yw.mLiveSdkInfo.mCastIds.XX;
                String str2 = f.this.Yw.mLiveSdkInfo.mCastIds.XY;
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str, -1, "", "", "");
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str2, -1, "", "", "");
            }
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.im.f.12.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.wm();
                }
            });
            return httpMessage;
        }
    };
    private IFetchMsgByIdListener asb = new IFetchMsgByIdListener() { // from class: com.baidu.live.im.f.3
        @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
        public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList) {
            f.this.b(i, arrayList);
        }
    };
    private com.baidu.g.a.b.a.d asc = new com.baidu.g.a.b.a.d() { // from class: com.baidu.live.im.f.4
        @Override // com.baidu.g.a.b.a.d
        public void d(int i, List<com.baidu.g.a.b.a.c> list) {
            if (f.this.Yw != null && f.this.XX != null && f.this.XY != null && f.this.Yw.mLiveInfo != null) {
                if (i == 0 || i == f.arN) {
                    ALAGroupHttpResponseMessage aLAGroupHttpResponseMessage = new ALAGroupHttpResponseMessage();
                    ArrayList arrayList = new ArrayList();
                    if (f.this.arQ != null) {
                        f.this.arQ.clear();
                    }
                    for (com.baidu.g.a.b.a.c cVar : list) {
                        if (cVar != null) {
                            String str = "";
                            String str2 = "";
                            if (!TextUtils.isEmpty(cVar.aHG)) {
                                str = cVar.aHG;
                            } else if (cVar.aHV != null && cVar.aHV.aIj != null) {
                                try {
                                    JSONObject jSONObject = new JSONObject(cVar.aHV.aIj);
                                    if (!TextUtils.isEmpty(jSONObject.optString("room_id"))) {
                                        str = jSONObject.optString("room_id");
                                    }
                                    str2 = jSONObject.optString("msg_type");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            if (TextUtils.isEmpty(str) || TextUtils.equals(str, f.this.XX) || TextUtils.equals(str, f.this.XY)) {
                                if (!TextUtils.equals(cVar.type, "0") || !TextUtils.isEmpty(str)) {
                                    if (!TextUtils.isEmpty(str) || !TextUtils.equals(str2, SoUtils.SO_EVENT_ID_DEFAULT)) {
                                        List<a> a = p.a(cVar);
                                        if (a != null) {
                                            if (TextUtils.equals(cVar.type, "0")) {
                                                for (int i2 = 0; i2 < a.size(); i2++) {
                                                    a aVar = a.get(i2);
                                                    if (aVar.xo() != null && (!TextUtils.isEmpty(aVar.xo().name_show) || !TextUtils.isEmpty(aVar.xo().userName))) {
                                                        arrayList.add(aVar);
                                                    }
                                                }
                                            } else {
                                                arrayList.addAll(a);
                                            }
                                            if (i == 0 && cVar.aHV != null && !TextUtils.isEmpty(cVar.aHV.aIj)) {
                                                if (f.this.arQ == null) {
                                                    f.this.arQ = new ArrayList();
                                                }
                                                f.this.arQ.add(cVar.aHV.aIj);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        aLAGroupHttpResponseMessage.aW(i == f.arN);
                        aLAGroupHttpResponseMessage.F(arrayList);
                        aLAGroupHttpResponseMessage.setGroupId(f.this.Yw.mLiveInfo.getGroupID());
                        MessageManager.getInstance().dispatchResponsedMessage(aLAGroupHttpResponseMessage);
                        if (f.this.arQ != null && !f.this.arQ.isEmpty()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913107, f.this.arQ));
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener asd = new CustomMessageListener(2913108) { // from class: com.baidu.live.im.f.5
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
                if (i != 0 && i == f.this.arR.getId() && f.this.Yw != null) {
                    f.this.arO = 0;
                    f.this.arP = 0;
                    f.this.XX = f.this.Yw.mLiveSdkInfo.mCastIds.XX;
                    String str = f.this.Yw.mLiveSdkInfo.mCastIds.XZ;
                    f.this.XY = f.this.Yw.mLiveSdkInfo.mCastIds.XY;
                    String str2 = f.this.Yw.mLiveSdkInfo.mCastIds.Yb;
                    int i2 = JavaTypesHelper.toInt(f.this.Yw.mLiveSdkInfo.mCastIds.Yc, 5) * 1000;
                    f.this.a(f.this.XX, str, i2, false);
                    f.this.a(f.this.XY, str2, i2, f.this.Yw.isHost);
                }
            }
        }
    };

    public static f wi() {
        if (arM == null) {
            synchronized (f.class) {
                if (arM == null) {
                    arM = new f();
                }
            }
        }
        return arM;
    }

    private f() {
    }

    public void aE(Context context) {
        this.mContext = context;
        MessageManager.getInstance().unRegisterListener(this.arU);
        MessageManager.getInstance().registerListener(this.arU);
        MessageManager.getInstance().removeMessageRule(this.arY);
        MessageManager.getInstance().addMessageRule(this.arY);
        MessageManager.getInstance().unRegisterListener(this.arZ);
        MessageManager.getInstance().registerListener(this.arZ);
        MessageManager.getInstance().unRegisterListener(this.asd);
        MessageManager.getInstance().registerListener(this.asd);
    }

    public void wj() {
        com.baidu.g.b.a.aP(this.mContext).BP().wl();
        this.arT = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final String str2, final int i, final boolean z) {
        if (TbConfig.IM_LOG) {
            Log.i("imlog", "@.@ enterRoom roomid:" + str + ", url:" + str2);
        }
        com.baidu.g.b.a.aP(this.mContext).BP().a(str, str2, i, new com.baidu.g.a.b.b() { // from class: com.baidu.live.im.f.13
            @Override // com.baidu.g.a.b.b
            public void onResult(int i2, long j, long j2) {
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ enterRoom onResult i:" + i2 + ", l:" + j + ", l1:" + j2);
                }
                if (f.this.Yw == null || f.this.XX == null || f.this.XY == null) {
                    com.baidu.g.b.a.aP(f.this.mContext).BP().eu(String.valueOf(j));
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.XX, String.valueOf(j), -1, "", "", "");
                    return;
                }
                long j3 = JavaTypesHelper.toLong(f.this.XX, -1L);
                long j4 = JavaTypesHelper.toLong(f.this.XY, -1L);
                if (j3 != j && j4 != j) {
                    com.baidu.g.b.a.aP(f.this.mContext).BP().eu(String.valueOf(j));
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.XX, String.valueOf(j), -1, "", "", "");
                    if (TbConfig.IM_LOG) {
                        Log.e("imlog", "BDIM enterRoom wrong then exit end:" + j);
                    }
                } else if (i2 == 1000) {
                    IExtraParams buildParamsExtra = ExtraParamsManager.getInstance().buildParamsExtra();
                    if (buildParamsExtra != null) {
                        try {
                            HashMap hashMap = new HashMap();
                            hashMap.put(ExtraParamsManager.KEY_PROCESS_PLUGIN_ASYNC_CALLBACK, "");
                            f.this.arR = BdUniqueId.gen();
                            hashMap.put("id", Integer.valueOf(f.this.arR.getId()));
                            hashMap.put("cmd", 2913108);
                            buildParamsExtra.process(hashMap);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_FAIL_IM_NOT_LOGIN, f.this.XX, str, -1, "", "", "");
                } else if (i2 == 1314 || i2 == 1306) {
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_MSG_ENTER_IM_FAIL, f.this.XX, str, -1, String.valueOf(i2), "", "");
                } else if (i2 != 0) {
                    if (j3 == j) {
                        if (f.this.arO < 3) {
                            f.this.a(str, str2, i, z);
                            f.this.arO++;
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_MSG_FAIL_TO_REJOIN, f.this.XX, str, -1, "", "", "");
                            return;
                        }
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.XX, str, -1, "", "", "");
                    } else if (f.this.arP < 3) {
                        f.this.a(str, str2, i, z);
                        f.this.arP++;
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_GIFT_FAIL_TO_REJOIN, f.this.XX, str, -1, "", "", "");
                    } else {
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.XX, str, -1, "", "", "");
                    }
                } else if (j3 == j) {
                    f.this.arO = 0;
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", f.this.XX, str, 0, "", "", "");
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ enterRoom onResult JOIN Msg成功:" + j3);
                    }
                    if ((!f.this.Yw.isHost || (f.this.Yw.isHost && f.this.Yw.Yl)) && f.this.arT != j3) {
                        f.this.arT = j3;
                        ChatMsgManagerImpl.getInstance(f.this.mContext).fetchMsgidByMsgid(f.this.mContext, 4, JavaTypesHelper.toLong(str, -1L), 0L, Format.OFFSET_SAMPLE_RELATIVE, -20, 1, 0, f.this.asb);
                    }
                } else {
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", f.this.XX, str, 0, "", "", "");
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ enterRoom onResult JOIN Gift成功:" + j4);
                    }
                    f.this.arP = 0;
                }
            }
        }, z);
        wk();
        dL(str);
    }

    private void wk() {
        MessageManager.getInstance().unRegisterListener(this.agU);
        MessageManager.getInstance().registerListener(this.agU);
        MessageManager.getInstance().unRegisterListener(this.arV);
        MessageManager.getInstance().registerListener(this.arV);
        MessageManager.getInstance().unRegisterListener(this.arW);
        MessageManager.getInstance().registerListener(this.arW);
        MessageManager.getInstance().removeMessageRule(this.arX);
        MessageManager.getInstance().addMessageRule(this.arX);
        MessageManager.getInstance().removeMessageRule(this.asa);
        MessageManager.getInstance().addMessageRule(this.asa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wl() {
        if (this.Yw != null && this.Yw.mLiveSdkInfo != null && this.Yw.mLiveSdkInfo.mCastIds != null) {
            String str = this.Yw.mLiveSdkInfo.mCastIds.XX;
            String str2 = this.Yw.mLiveSdkInfo.mCastIds.XY;
            com.baidu.g.b.a.aP(this.mContext).BP().eu(str);
            com.baidu.g.b.a.aP(this.mContext).BP().eu(str2);
        }
        this.arT = 0L;
        this.Yw = null;
        this.XX = null;
        this.XY = null;
        this.arO = 0;
        this.arP = 0;
        if (this.arQ != null) {
            this.arQ.clear();
            this.arQ = null;
        }
        if (this.arS != null) {
            this.arS.clear();
            this.arS = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wm() {
        MessageManager.getInstance().unRegisterListener(this.arV);
        MessageManager.getInstance().unRegisterListener(this.arW);
        MessageManager.getInstance().unRegisterListener(this.agU);
        MessageManager.getInstance().removeMessageRule(this.arX);
        MessageManager.getInstance().removeMessageRule(this.asa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(List<AlaLiveMarkData> list) {
        if (list != null && !list.isEmpty()) {
            if (this.arS == null) {
                this.arS = new ArrayList();
            }
            this.arS.clear();
            this.arS.addAll(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.live.im.message.a aVar) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        String str = null;
        String content = aVar.getContent();
        String str2 = (this.Yw == null || this.Yw.mLiveSdkInfo == null || this.Yw.mLiveSdkInfo.mCastIds == null) ? null : this.Yw.mLiveSdkInfo.mCastIds.XX;
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.g.a.b.a.e eVar = new com.baidu.g.a.b.a.e();
            eVar.msg = content;
            eVar.aHG = str2;
            if (this.Yw != null && this.Yw.Ye != null) {
                eVar.name = this.Yw.Ye.userName;
                eVar.portrait = this.Yw.Ye.portrait;
            }
            a aVar2 = new a();
            if (this.Yw != null) {
                if (this.Yw.isHost) {
                    alaLiveUserInfoData = this.Yw.XQ;
                } else {
                    alaLiveUserInfoData = this.Yw.Ye;
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
                    aVar3.Xg = alaLiveUserInfoData.followCount;
                    aVar3.Xf = alaLiveUserInfoData.fansCount;
                    aVar3.Xj = alaLiveUserInfoData.isAdmin == 1;
                    aVar3.Xi = alaLiveUserInfoData.isOfficial == 1;
                    aVar3.level_id = alaLiveUserInfoData.levelId;
                    aVar3.Xl = this.arS;
                    aVar3.sex = alaLiveUserInfoData.sex;
                    aVar3.extraUserInfo = alaLiveUserInfoData.extraUserInfo;
                    aVar2.d(aVar3);
                    aVar2.setContent(content);
                    aVar2.setMsgType(aVar.xw());
                    aVar2.bX(aVar.xs());
                    aVar2.dN(aVar.xt());
                    aVar2.a(aVar.xu());
                    aVar2.l(aVar.xv());
                    aVar2.setUserId(alaLiveUserInfoData.userId);
                    aVar2.dI(String.valueOf(this.Yw.mLiveInfo.user_id));
                    aVar2.setBornTime(System.currentTimeMillis());
                    str = aVar2.vQ();
                }
            }
            eVar.aHW = str;
            com.baidu.g.b.a.aP(this.mContext).BP().a(str2, eVar, new com.baidu.g.a.b.a.f() { // from class: com.baidu.live.im.f.2
                @Override // com.baidu.g.a.b.a.f
                public void a(String str3, int i, List<com.baidu.g.a.b.a.c> list) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ IM消息 onSendSuccess s:" + str3 + ", i:" + i);
                    }
                    if (f.this.Yw != null && f.this.XX != null && f.this.XY != null) {
                        if (TextUtils.equals(str3, f.this.XX) || TextUtils.equals(str3, f.this.XY)) {
                            ALAGroupCommitHttpResponsedMessage aLAGroupCommitHttpResponsedMessage = new ALAGroupCommitHttpResponsedMessage();
                            aLAGroupCommitHttpResponsedMessage.setStatusCode(200, null);
                            if (f.this.Yw.mLiveInfo != null) {
                                if (TbadkCoreApplication.getInst().isHaokan()) {
                                    AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SUC_SEND_NEWS);
                                    alaStaticItem.addParams("live_id", f.this.Yw.mLiveInfo.live_id + "");
                                    alaStaticItem.addParams("room_id", f.this.Yw.mLiveInfo.room_id + "");
                                    alaStaticItem.addParams("feed_id", f.this.Yw.mLiveInfo.feed_id + "");
                                    alaStaticItem.addParams("other_params", aVar.xx());
                                    if (aVar.xw() == 126) {
                                        alaStaticItem.addParams("gifts_value", String.valueOf(aVar.xy()));
                                    }
                                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                                }
                                if (TbadkCoreApplication.getInst().isQuanmin()) {
                                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SUC_SEND_NEWS);
                                    alaStaticItem2.addParams("live_id", f.this.Yw.mLiveInfo.live_id + "");
                                    alaStaticItem2.addParams("room_id", f.this.Yw.mLiveInfo.room_id + "");
                                    alaStaticItem2.addParams("feed_id", f.this.Yw.mLiveInfo.feed_id + "");
                                    alaStaticItem2.addParams("other_params", aVar.xx());
                                    if (aVar.xw() == 126) {
                                        alaStaticItem2.addParams("gifts_value", String.valueOf(aVar.xy()));
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
                            if (com.baidu.live.liveroom.a.ym().yn()) {
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
                    if (!TextUtils.isEmpty(cVar.aHG)) {
                        str = cVar.aHG;
                    } else if (cVar.aHV != null && cVar.aHV.aIj != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(cVar.aHV.aIj);
                            if (!TextUtils.isEmpty(jSONObject.optString("room_id"))) {
                                str = jSONObject.optString("room_id");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    if (TextUtils.isEmpty(str) || TextUtils.equals(str, this.XX) || TextUtils.equals(str, this.XY)) {
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
                this.asc.d(arN, arrayList2);
            }
        }
    }

    private void dL(String str) {
        com.baidu.g.b.a.aP(this.mContext).BP().a(str, this.asc);
    }
}
