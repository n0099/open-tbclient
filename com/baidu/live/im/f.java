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
    private static f anH = null;
    private static int anI = Integer.MAX_VALUE;
    private String VW;
    private String VX;
    private com.baidu.live.data.k Wr;
    private List<String> anL;
    private BdUniqueId anM;
    private List<AlaLiveMarkData> anN;
    private long anO;
    private Context mContext;
    private int anJ = 0;
    private int anK = 0;
    private CustomMessageListener anP = new CustomMessageListener(2913081) { // from class: com.baidu.live.im.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.data.k kVar;
            int i;
            String str;
            String str2;
            if (customResponsedMessage.hasError() || customResponsedMessage.getError() != 0 || com.baidu.g.b.a.aL(f.this.mContext).zb() == null || !(customResponsedMessage.getData() instanceof com.baidu.live.data.k) || (kVar = (com.baidu.live.data.k) customResponsedMessage.getData()) == null) {
                return;
            }
            if ((kVar.mLiveSdkInfo != null && kVar.mLiveSdkInfo.mCastIds != null) || (kVar.mLiveInfo != null && kVar.mLiveInfo.mCastIds != null)) {
                if (kVar.mLiveInfo == null || kVar.mLiveInfo.live_status != 2) {
                    f.this.Wr = kVar;
                    f.this.B(f.this.Wr.Wg);
                    if (kVar.mLiveSdkInfo != null && kVar.mLiveSdkInfo.mCastIds != null) {
                        f.this.VW = f.this.Wr.mLiveSdkInfo.mCastIds.VW;
                        String str3 = f.this.Wr.mLiveSdkInfo.mCastIds.VY;
                        f.this.VX = f.this.Wr.mLiveSdkInfo.mCastIds.VX;
                        String str4 = f.this.Wr.mLiveSdkInfo.mCastIds.Wa;
                        i = JavaTypesHelper.toInt(f.this.Wr.mLiveSdkInfo.mCastIds.Wb, 5) * 1000;
                        str = str4;
                        str2 = str3;
                    } else if (kVar.mLiveInfo != null && kVar.mLiveInfo.mCastIds != null) {
                        f.this.VW = f.this.Wr.mLiveInfo.mCastIds.VW;
                        String str5 = f.this.Wr.mLiveInfo.mCastIds.VY;
                        f.this.VX = f.this.Wr.mLiveInfo.mCastIds.VX;
                        String str6 = f.this.Wr.mLiveInfo.mCastIds.Wa;
                        i = JavaTypesHelper.toInt(f.this.Wr.mLiveInfo.mCastIds.Wb, 5) * 1000;
                        str = str6;
                        str2 = str5;
                    } else {
                        i = 5000;
                        str = "";
                        str2 = "";
                    }
                    f.this.a(f.this.VW, str2, i, false);
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", f.this.VW, f.this.VW, 0, "", "", "");
                    f.this.a(f.this.VX, str, i, kVar.isHost);
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", f.this.VW, f.this.VX, 0, "", "", "");
                }
            }
        }
    };
    private CustomMessageListener anQ = new CustomMessageListener(2913082) { // from class: com.baidu.live.im.f.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof com.baidu.live.data.k)) {
                f.this.Wr = (com.baidu.live.data.k) customResponsedMessage.getData();
                f.this.B(f.this.Wr.Wg);
            }
        }
    };
    private CustomMessageListener anR = new CustomMessageListener(2913118) { // from class: com.baidu.live.im.f.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0 && (customResponsedMessage.getData() instanceof com.baidu.live.data.k)) {
                f.this.B(((com.baidu.live.data.k) customResponsedMessage.getData()).Wg);
            }
        }
    };
    private HttpRule anS = new HttpRule(1021013) { // from class: com.baidu.live.im.f.8
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
    private HttpRule anT = new HttpRule(1021012) { // from class: com.baidu.live.im.f.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            return null;
        }
    };
    CustomMessageListener anU = new CustomMessageListener(2913084) { // from class: com.baidu.live.im.f.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.uo();
        }
    };
    CustomMessageListener anV = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.live.im.f.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f.this.uq();
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.im.f.11.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.ur();
                }
            });
        }
    };
    private HttpRule anW = new HttpRule(1021006) { // from class: com.baidu.live.im.f.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.controller.MessageRule
        public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            f.this.uq();
            if (f.this.Wr != null && f.this.Wr.mLiveSdkInfo != null && f.this.Wr.mLiveSdkInfo.mCastIds != null) {
                String str = f.this.Wr.mLiveSdkInfo.mCastIds.VW;
                String str2 = f.this.Wr.mLiveSdkInfo.mCastIds.VX;
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str, -1, "", "", "");
                LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, str, str2, -1, "", "", "");
            }
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.im.f.12.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.ur();
                }
            });
            return httpMessage;
        }
    };
    private IFetchMsgByIdListener anX = new IFetchMsgByIdListener() { // from class: com.baidu.live.im.f.3
        @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
        public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList) {
            f.this.b(i, arrayList);
        }
    };
    private com.baidu.g.a.b.a.d anY = new com.baidu.g.a.b.a.d() { // from class: com.baidu.live.im.f.4
        @Override // com.baidu.g.a.b.a.d
        public void d(int i, List<com.baidu.g.a.b.a.c> list) {
            if (f.this.Wr != null && f.this.VW != null && f.this.VX != null && f.this.Wr.mLiveInfo != null) {
                if (i == 0 || i == f.anI) {
                    ALAGroupHttpResponseMessage aLAGroupHttpResponseMessage = new ALAGroupHttpResponseMessage();
                    ArrayList arrayList = new ArrayList();
                    if (f.this.anL != null) {
                        f.this.anL.clear();
                    }
                    for (com.baidu.g.a.b.a.c cVar : list) {
                        if (cVar != null) {
                            String str = "";
                            String str2 = "";
                            if (!TextUtils.isEmpty(cVar.aCG)) {
                                str = cVar.aCG;
                            } else if (cVar.aCV != null && cVar.aCV.aDj != null) {
                                try {
                                    JSONObject jSONObject = new JSONObject(cVar.aCV.aDj);
                                    if (!TextUtils.isEmpty(jSONObject.optString("room_id"))) {
                                        str = jSONObject.optString("room_id");
                                    }
                                    str2 = jSONObject.optString("msg_type");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            if (TextUtils.isEmpty(str) || TextUtils.equals(str, f.this.VW) || TextUtils.equals(str, f.this.VX)) {
                                if (!TextUtils.equals(cVar.type, "0") || !TextUtils.isEmpty(str)) {
                                    if (!TextUtils.isEmpty(str) || !TextUtils.equals(str2, SoUtils.SO_EVENT_ID_DEFAULT)) {
                                        List<a> a = p.a(cVar);
                                        if (a != null) {
                                            if (TextUtils.equals(cVar.type, "0")) {
                                                for (int i2 = 0; i2 < a.size(); i2++) {
                                                    a aVar = a.get(i2);
                                                    if (aVar.uZ() != null && (!TextUtils.isEmpty(aVar.uZ().name_show) || !TextUtils.isEmpty(aVar.uZ().userName))) {
                                                        arrayList.add(aVar);
                                                    }
                                                }
                                            } else {
                                                arrayList.addAll(a);
                                            }
                                            if (i == 0 && cVar.aCV != null && !TextUtils.isEmpty(cVar.aCV.aDj)) {
                                                if (f.this.anL == null) {
                                                    f.this.anL = new ArrayList();
                                                }
                                                f.this.anL.add(cVar.aCV.aDj);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        aLAGroupHttpResponseMessage.aR(i == f.anI);
                        aLAGroupHttpResponseMessage.G(arrayList);
                        aLAGroupHttpResponseMessage.setGroupId(f.this.Wr.mLiveInfo.getGroupID());
                        MessageManager.getInstance().dispatchResponsedMessage(aLAGroupHttpResponseMessage);
                        if (f.this.anL != null && !f.this.anL.isEmpty()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913107, f.this.anL));
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener anZ = new CustomMessageListener(2913108) { // from class: com.baidu.live.im.f.5
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
                if (i != 0 && i == f.this.anM.getId() && f.this.Wr != null) {
                    f.this.anJ = 0;
                    f.this.anK = 0;
                    f.this.VW = f.this.Wr.mLiveSdkInfo.mCastIds.VW;
                    String str = f.this.Wr.mLiveSdkInfo.mCastIds.VY;
                    f.this.VX = f.this.Wr.mLiveSdkInfo.mCastIds.VX;
                    String str2 = f.this.Wr.mLiveSdkInfo.mCastIds.Wa;
                    int i2 = JavaTypesHelper.toInt(f.this.Wr.mLiveSdkInfo.mCastIds.Wb, 5) * 1000;
                    f.this.a(f.this.VW, str, i2, false);
                    f.this.a(f.this.VX, str2, i2, f.this.Wr.isHost);
                }
            }
        }
    };

    public static f un() {
        if (anH == null) {
            synchronized (f.class) {
                if (anH == null) {
                    anH = new f();
                }
            }
        }
        return anH;
    }

    private f() {
    }

    public void aB(Context context) {
        this.mContext = context;
        MessageManager.getInstance().unRegisterListener(this.anP);
        MessageManager.getInstance().registerListener(this.anP);
        MessageManager.getInstance().removeMessageRule(this.anT);
        MessageManager.getInstance().addMessageRule(this.anT);
        MessageManager.getInstance().unRegisterListener(this.anU);
        MessageManager.getInstance().registerListener(this.anU);
        MessageManager.getInstance().unRegisterListener(this.anZ);
        MessageManager.getInstance().registerListener(this.anZ);
    }

    public void uo() {
        com.baidu.g.b.a.aL(this.mContext).zb().uq();
        this.anO = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final String str2, final int i, final boolean z) {
        if (TbConfig.IM_LOG) {
            Log.i("imlog", "@.@ enterRoom roomid:" + str + ", url:" + str2);
        }
        com.baidu.g.b.a.aL(this.mContext).zb().a(str, str2, i, new com.baidu.g.a.b.b() { // from class: com.baidu.live.im.f.13
            @Override // com.baidu.g.a.b.b
            public void onResult(int i2, long j, long j2) {
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ enterRoom onResult i:" + i2 + ", l:" + j + ", l1:" + j2);
                }
                if (f.this.Wr == null || f.this.VW == null || f.this.VX == null) {
                    com.baidu.g.b.a.aL(f.this.mContext).zb().ec(String.valueOf(j));
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.VW, String.valueOf(j), -1, "", "", "");
                    return;
                }
                long j3 = JavaTypesHelper.toLong(f.this.VW, -1L);
                long j4 = JavaTypesHelper.toLong(f.this.VX, -1L);
                if (j3 != j && j4 != j) {
                    com.baidu.g.b.a.aL(f.this.mContext).zb().ec(String.valueOf(j));
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.EXIT_LIVE_IM, f.this.VW, String.valueOf(j), -1, "", "", "");
                    if (TbConfig.IM_LOG) {
                        Log.e("imlog", "BDIM enterRoom wrong then exit end:" + j);
                    }
                } else if (i2 == 1000) {
                    IExtraParams buildParamsExtra = ExtraParamsManager.getInstance().buildParamsExtra();
                    if (buildParamsExtra != null) {
                        try {
                            HashMap hashMap = new HashMap();
                            hashMap.put(ExtraParamsManager.KEY_PROCESS_PLUGIN_ASYNC_CALLBACK, "");
                            f.this.anM = BdUniqueId.gen();
                            hashMap.put("id", Integer.valueOf(f.this.anM.getId()));
                            hashMap.put("cmd", 2913108);
                            buildParamsExtra.process(hashMap);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_FAIL_IM_NOT_LOGIN, f.this.VW, str, -1, "", "", "");
                } else if (i2 != 0) {
                    if (j3 == j) {
                        if (f.this.anJ < 3) {
                            f.this.a(str, str2, i, z);
                            f.this.anJ++;
                            LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_MSG_FAIL_TO_REJOIN, f.this.VW, str, -1, "", "", "");
                            return;
                        }
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.VW, str, -1, "", "", "");
                    } else if (f.this.anK < 3) {
                        f.this.a(str, str2, i, z);
                        f.this.anK++;
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", LogConfig.JOIN_LIVE_GIFT_FAIL_TO_REJOIN, f.this.VW, str, -1, "", "", "");
                    } else {
                        LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsgFailOutLimit", f.this.VW, str, -1, "", "", "");
                    }
                } else if (j3 == j) {
                    f.this.anJ = 0;
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveMsg", f.this.VW, str, 0, "", "", "");
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ enterRoom onResult JOIN Msg成功:" + j3);
                    }
                    if (!f.this.Wr.isHost && f.this.anO != j3) {
                        f.this.anO = j3;
                        ChatMsgManagerImpl.getInstance(f.this.mContext).fetchMsgidByMsgid(f.this.mContext, 4, JavaTypesHelper.toLong(str, -1L), 0L, Format.OFFSET_SAMPLE_RELATIVE, -20, 1, 0, f.this.anX);
                    }
                } else {
                    LogManager.getLiveIMLogger().doIMLongLinkLog("", "", "", "", "", "joinLiveGift", f.this.VW, str, 0, "", "", "");
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ enterRoom onResult JOIN Gift成功:" + j4);
                    }
                    f.this.anK = 0;
                }
            }
        }, z);
        up();
        dy(str);
    }

    private void up() {
        MessageManager.getInstance().unRegisterListener(this.anV);
        MessageManager.getInstance().registerListener(this.anV);
        MessageManager.getInstance().unRegisterListener(this.anQ);
        MessageManager.getInstance().registerListener(this.anQ);
        MessageManager.getInstance().unRegisterListener(this.anR);
        MessageManager.getInstance().registerListener(this.anR);
        MessageManager.getInstance().removeMessageRule(this.anS);
        MessageManager.getInstance().addMessageRule(this.anS);
        MessageManager.getInstance().removeMessageRule(this.anW);
        MessageManager.getInstance().addMessageRule(this.anW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uq() {
        if (this.Wr != null && this.Wr.mLiveSdkInfo != null && this.Wr.mLiveSdkInfo.mCastIds != null) {
            String str = this.Wr.mLiveSdkInfo.mCastIds.VW;
            String str2 = this.Wr.mLiveSdkInfo.mCastIds.VX;
            com.baidu.g.b.a.aL(this.mContext).zb().ec(str);
            com.baidu.g.b.a.aL(this.mContext).zb().ec(str2);
        }
        this.anO = 0L;
        this.Wr = null;
        this.VW = null;
        this.VX = null;
        this.anJ = 0;
        this.anK = 0;
        if (this.anL != null) {
            this.anL.clear();
            this.anL = null;
        }
        if (this.anN != null) {
            this.anN.clear();
            this.anN = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ur() {
        MessageManager.getInstance().unRegisterListener(this.anQ);
        MessageManager.getInstance().unRegisterListener(this.anR);
        MessageManager.getInstance().unRegisterListener(this.anV);
        MessageManager.getInstance().removeMessageRule(this.anS);
        MessageManager.getInstance().removeMessageRule(this.anW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(List<AlaLiveMarkData> list) {
        if (list != null && !list.isEmpty()) {
            if (this.anN == null) {
                this.anN = new ArrayList();
            }
            this.anN.clear();
            this.anN.addAll(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.live.im.message.a aVar) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        String str = null;
        String content = aVar.getContent();
        String str2 = (this.Wr == null || this.Wr.mLiveSdkInfo == null || this.Wr.mLiveSdkInfo.mCastIds == null) ? null : this.Wr.mLiveSdkInfo.mCastIds.VW;
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.g.a.b.a.e eVar = new com.baidu.g.a.b.a.e();
            eVar.msg = content;
            eVar.aCG = str2;
            eVar.name = this.Wr.Wc.userName;
            eVar.portrait = this.Wr.Wc.portrait;
            a aVar2 = new a();
            if (this.Wr != null) {
                if (this.Wr.isHost) {
                    alaLiveUserInfoData = this.Wr.VP;
                } else {
                    alaLiveUserInfoData = this.Wr.Wc;
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
                    aVar3.Vk = alaLiveUserInfoData.followCount;
                    aVar3.Vj = alaLiveUserInfoData.fansCount;
                    aVar3.Vn = alaLiveUserInfoData.isAdmin == 1;
                    aVar3.Vm = alaLiveUserInfoData.isOfficial == 1;
                    aVar3.level_id = alaLiveUserInfoData.levelId;
                    aVar3.Vp = this.anN;
                    aVar3.sex = alaLiveUserInfoData.sex;
                    aVar2.b(aVar3);
                    aVar2.setContent(content);
                    aVar2.setMsgType(aVar.vh());
                    aVar2.bK(aVar.vd());
                    aVar2.dA(aVar.ve());
                    aVar2.a(aVar.vf());
                    aVar2.k(aVar.vg());
                    aVar2.setUserId(alaLiveUserInfoData.userId);
                    aVar2.dv(String.valueOf(this.Wr.mLiveInfo.user_id));
                    aVar2.setBornTime(System.currentTimeMillis());
                    str = aVar2.tV();
                }
            }
            eVar.aCW = str;
            com.baidu.g.b.a.aL(this.mContext).zb().a(str2, eVar, new com.baidu.g.a.b.a.f() { // from class: com.baidu.live.im.f.2
                @Override // com.baidu.g.a.b.a.f
                public void a(String str3, int i, List<com.baidu.g.a.b.a.c> list) {
                    if (TbConfig.IM_LOG) {
                        Log.i("imlog", "@.@ IM消息 onSendSuccess s:" + str3 + ", i:" + i);
                    }
                    if (f.this.Wr != null && f.this.VW != null && f.this.VX != null) {
                        if (TextUtils.equals(str3, f.this.VW) || TextUtils.equals(str3, f.this.VX)) {
                            ALAGroupCommitHttpResponsedMessage aLAGroupCommitHttpResponsedMessage = new ALAGroupCommitHttpResponsedMessage();
                            aLAGroupCommitHttpResponsedMessage.setStatusCode(200, null);
                            if (f.this.Wr.mLiveInfo != null) {
                                if (TbadkCoreApplication.getInst().isHaokan()) {
                                    AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SUC_SEND_NEWS);
                                    alaStaticItem.addParams("live_id", f.this.Wr.mLiveInfo.live_id + "");
                                    alaStaticItem.addParams("room_id", f.this.Wr.mLiveInfo.room_id + "");
                                    alaStaticItem.addParams("feed_id", f.this.Wr.mLiveInfo.feed_id + "");
                                    alaStaticItem.addParams("other_params", aVar.vi());
                                    if (aVar.vh() == 126) {
                                        alaStaticItem.addParams("gifts_value", String.valueOf(aVar.vj()));
                                    }
                                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                                }
                                if (TbadkCoreApplication.getInst().isQuanmin()) {
                                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SUC_SEND_NEWS);
                                    alaStaticItem2.addParams("live_id", f.this.Wr.mLiveInfo.live_id + "");
                                    alaStaticItem2.addParams("room_id", f.this.Wr.mLiveInfo.room_id + "");
                                    alaStaticItem2.addParams("feed_id", f.this.Wr.mLiveInfo.feed_id + "");
                                    alaStaticItem2.addParams("other_params", aVar.vi());
                                    if (aVar.vh() == 126) {
                                        alaStaticItem2.addParams("gifts_value", String.valueOf(aVar.vj()));
                                    }
                                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                                }
                            }
                            if (i == 0) {
                                f.this.C(list);
                            } else if (i == 22) {
                                aLAGroupCommitHttpResponsedMessage.setError(22);
                                aLAGroupCommitHttpResponsedMessage.setErrorString("");
                            } else if (i == 1000) {
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(aLAGroupCommitHttpResponsedMessage);
                            if (com.baidu.live.liveroom.a.vU().vV()) {
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
    public void C(List<com.baidu.g.a.b.a.c> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.g.a.b.a.c cVar : list) {
                if (cVar != null) {
                    String str = "";
                    if (!TextUtils.isEmpty(cVar.aCG)) {
                        str = cVar.aCG;
                    } else if (cVar.aCV != null && cVar.aCV.aDj != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(cVar.aCV.aDj);
                            if (!TextUtils.isEmpty(jSONObject.optString("room_id"))) {
                                str = jSONObject.optString("room_id");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    if (TextUtils.isEmpty(str) || TextUtils.equals(str, this.VW) || TextUtils.equals(str, this.VX)) {
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
                this.anY.d(anI, arrayList2);
            }
        }
    }

    private void dy(String str) {
        com.baidu.g.b.a.aL(this.mContext).zb().a(str, this.anY);
    }
}
