package com.baidu.live.im;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.listener.NetMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.framework.message.ResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.NetWorkChangedMessage;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.gift.t;
import com.baidu.live.im.b;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.message.ALAGroupCommitHttpResponsedMessage;
import com.baidu.live.im.message.ALAGroupHttpResponseMessage;
import com.baidu.live.message.AlaGetLiveStatusHttpResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.u.a;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends BdBaseModel {
    private List<AlaLiveMarkData> Yi;
    private com.baidu.live.data.m ald;
    private boolean aqS;
    private a aqT;
    private String aqU;
    private String aqV;
    private List<com.baidu.live.im.data.a> aqW;
    private int aqX;
    private int aqY;
    private int aqZ;
    private float ara;
    private String arb;
    private b.a arc;
    private Runnable ard;
    private CustomMessageListener are;
    private CustomMessageListener arf;
    private Runnable arg;
    private HttpMessageListener arh;
    private HttpMessageListener ari;
    private HttpMessageListener arj;
    private HttpMessageListener ark;
    private NetMessageListener arl;
    private String mAppId;
    private String mGroupId;
    private Handler mHandler;
    private String mLiveId;
    private LinkedList<com.baidu.live.im.data.a> mMsgList;
    BdPageContext<?> mPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        void d(List<com.baidu.live.im.data.a> list, boolean z);

        void g(com.baidu.live.im.data.a aVar);

        void vY();
    }

    static /* synthetic */ int h(d dVar) {
        int i = dVar.aqZ;
        dVar.aqZ = i + 1;
        return i;
    }

    public d(BdPageContext<?> bdPageContext, boolean z, a aVar) {
        super(bdPageContext);
        this.mLiveId = null;
        this.ara = 1.0f;
        this.mHandler = new Handler();
        this.arb = null;
        this.arc = new b.a() { // from class: com.baidu.live.im.d.1
        };
        this.ard = new Runnable() { // from class: com.baidu.live.im.d.4
            @Override // java.lang.Runnable
            public void run() {
                int i = d.this.aqZ * d.this.aqX;
                if (i >= d.this.aqW.size()) {
                    d.this.vV();
                } else if (d.this.aqZ >= d.this.aqY - 1) {
                    if (d.this.aqZ != d.this.aqY - 1) {
                        d.this.vV();
                        return;
                    }
                    ArrayList arrayList = new ArrayList(d.this.aqW);
                    d.this.v(d.this.c(arrayList.subList(i, arrayList.size()), true));
                    d.h(d.this);
                    d.this.vV();
                } else {
                    ArrayList arrayList2 = new ArrayList(d.this.aqW);
                    if (d.this.aqX + i <= arrayList2.size()) {
                        d.this.v(d.this.c(arrayList2.subList(i, d.this.aqX + i), true));
                        d.h(d.this);
                        d.this.mHandler.postDelayed(d.this.ard, 250L);
                        return;
                    }
                    d.this.v(d.this.c(arrayList2.subList(i, arrayList2.size()), true));
                    d.h(d.this);
                    d.this.vV();
                }
            }
        };
        this.are = new CustomMessageListener(MessageConfig.SOCKET_RECEIVE_MSG) { // from class: com.baidu.live.im.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.vU();
            }
        };
        this.arf = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.live.im.d.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        com.baidu.live.im.a aVar2 = new com.baidu.live.im.a();
                        aVar2.setMsgType(27);
                        aVar2.setContent(d.this.mPageContext.getString(a.i.sdk_im_offline));
                        d.this.mMsgList.add(aVar2);
                        if (d.this.aqT != null) {
                            d.this.aqT.g(aVar2);
                            d.this.aqT.d(d.this.mMsgList, true);
                        }
                    } else if (((NetWorkChangedMessage) customResponsedMessage).mLastNetState == 0 && BdNetTypeUtil.isNetWorkAvailable()) {
                        com.baidu.live.im.a aVar3 = new com.baidu.live.im.a();
                        aVar3.setMsgType(27);
                        aVar3.setContent(d.this.mPageContext.getString(a.i.sdk_im_online));
                        d.this.mMsgList.add(aVar3);
                        if (d.this.aqT != null) {
                            d.this.aqT.g(aVar3);
                            d.this.aqT.d(d.this.mMsgList, true);
                        }
                    }
                }
            }
        };
        this.arg = new Runnable() { // from class: com.baidu.live.im.d.8
            @Override // java.lang.Runnable
            public void run() {
                if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().getLastReceDataTime() > 35000) {
                    d.this.vT();
                }
                d.this.vS();
            }
        };
        this.arh = new HttpMessageListener(1021013) { // from class: com.baidu.live.im.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    if (!httpResponsedMessage.hasError()) {
                        if (d.this.aqT != null) {
                            d.this.aqT.vY();
                        }
                    } else if (httpResponsedMessage.getError() == 149010) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913070, httpResponsedMessage.getErrorString()));
                    } else {
                        BdUtilHelper.showToast(d.this.mPageContext.getPageActivity(), httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        this.ari = new HttpMessageListener(1021015) { // from class: com.baidu.live.im.d.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                        if (orginalMessage instanceof com.baidu.live.gift.j) {
                            com.baidu.live.gift.j jVar = (com.baidu.live.gift.j) orginalMessage;
                            d.this.aa(jVar.agX, jVar.giftName);
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                }
            }
        };
        this.arj = new HttpMessageListener(1021014) { // from class: com.baidu.live.im.d.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    if (httpResponsedMessage.hasError()) {
                        Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                        if (orginalMessage instanceof com.baidu.live.gift.p) {
                            com.baidu.live.gift.p pVar = (com.baidu.live.gift.p) orginalMessage;
                            d.this.aa(pVar.agX, pVar.giftName);
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913168, "isAttentionOrGift"));
                }
            }
        };
        this.ark = new HttpMessageListener(1021012) { // from class: com.baidu.live.im.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                d.this.a((ResponsedMessage<?>) httpResponsedMessage, false);
            }
        };
        this.arl = new NetMessageListener(1021050, 601008) { // from class: com.baidu.live.im.d.3
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                JSONObject jSONObject;
                AlaGetLiveStatusHttpResponseMessage alaGetLiveStatusHttpResponseMessage = responsedMessage instanceof AlaGetLiveStatusHttpResponseMessage ? (AlaGetLiveStatusHttpResponseMessage) responsedMessage : null;
                if (alaGetLiveStatusHttpResponseMessage != null) {
                    try {
                        jSONObject = new JSONObject(alaGetLiveStatusHttpResponseMessage.awt);
                    } catch (JSONException e) {
                        jSONObject = null;
                    }
                    if (jSONObject != null) {
                        if (!"backstage_live".equals(jSONObject.optString("content_type"))) {
                            d.this.a(alaGetLiveStatusHttpResponseMessage.awt, jSONObject, 12, false);
                            return;
                        }
                        String optString = jSONObject.optString("backstage_type");
                        if (!TextUtils.isEmpty(optString) && !optString.equals(d.this.arb)) {
                            d.this.a(alaGetLiveStatusHttpResponseMessage.awt, jSONObject, 13, true);
                            d.this.arb = optString;
                        }
                    }
                }
            }
        };
        this.mPageContext = bdPageContext;
        this.aqS = z;
        this.aqT = aVar;
        this.mMsgList = new LinkedList<>();
        MessageManager.getInstance().registerTask(vR());
        com.baidu.live.tieba.f.a.a.a(1021050, "alaim/gmsg/getLiveStatus", AlaGetLiveStatusHttpResponseMessage.class, false, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021012, "alaim/gmsg/getGroupMsg", ALAGroupHttpResponseMessage.class, false, true, true, true);
    }

    public void e(com.baidu.live.data.m mVar) {
        this.ald = mVar;
    }

    private HttpMessageTask vR() {
        HttpMessageTask httpMessageTask = new HttpMessageTask(1021013, TbConfig.SERVER_ADDRESS + "alaim/gmsg/commitGroupMsg");
        httpMessageTask.setResponsedClass(ALAGroupCommitHttpResponsedMessage.class);
        return httpMessageTask;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    @Deprecated
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void e(String str, String str2, String str3, String str4, String str5) {
        if (this.mMsgList != null) {
            this.mMsgList.clear();
        }
        this.mMsgList = new LinkedList<>();
        this.mGroupId = str;
        this.aqU = str2;
        this.aqV = str3;
        this.mLiveId = str4;
        this.arb = "0";
        this.mAppId = str5;
        MessageManager.getInstance().registerListener(this.ark);
        MessageManager.getInstance().registerListener(this.arl);
        MessageManager.getInstance().registerListener(this.are);
        MessageManager.getInstance().registerListener(this.arh);
        MessageManager.getInstance().registerListener(this.arf);
        MessageManager.getInstance().registerListener(this.ari);
        MessageManager.getInstance().registerListener(this.arj);
        if (BdSocketLinkService.isClose()) {
            vT();
            BdSocketLinkService.startService(true, "live start");
        }
        String str6 = com.baidu.live.v.a.zj().awA.YL;
        if (!TextUtils.isEmpty(str6)) {
            com.baidu.live.im.data.a vX = vX();
            vX.setMsgType(27);
            vX.setContent(str6);
            this.mMsgList.add(vX);
            if (this.aqT != null) {
                this.aqT.g(vX);
            }
        }
        String str7 = com.baidu.live.v.a.zj().awA.YM;
        if (!TextUtils.isEmpty(str7)) {
            com.baidu.live.im.data.a vX2 = vX();
            vX2.setMsgType(27);
            vX2.setContent(str7);
            this.mMsgList.add(vX2);
        }
        List<String> list = com.baidu.live.v.a.zj().awA.YK;
        if (list != null && list.size() > 0 && list.size() % 2 == 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                String str8 = list.get(i2);
                String str9 = list.get(i2 + 1);
                if (!TextUtils.isEmpty(str8) && !TextUtils.isEmpty(str9)) {
                    com.baidu.live.im.data.a vX3 = vX();
                    vX3.setMsgType(27);
                    vX3.setContent(str8);
                    vX3.setLink(str9);
                    this.mMsgList.add(vX3);
                    if (this.aqT != null) {
                        this.aqT.g(vX3);
                    }
                }
                i = i2 + 2;
            }
        }
        if (this.mMsgList.size() > 0 && this.aqT != null) {
            this.aqT.d(this.mMsgList, true);
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGmsgGetLiveStatusUnabled()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.d.7
                @Override // java.lang.Runnable
                public void run() {
                    d.this.dJ("enter");
                }
            }, 1000L);
        }
        vS();
        if (TbadkCoreApplication.getInst().isOther()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913146, this.mMsgList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vS() {
        this.mHandler.postDelayed(this.arg, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vT() {
        sendMessage(new com.baidu.live.im.message.b(JavaTypesHelper.toInt(this.mGroupId, 0), getLastMid()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vU() {
        this.mHandler.removeCallbacks(this.arg);
    }

    public void aa(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "1";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = this.mPageContext.getString(a.i.sdk_gift);
        }
        com.baidu.live.im.data.a a2 = a((short) 27, String.format(this.mPageContext.getString(a.i.sdk_send_gift_fail), str, str2), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), this.Yi);
        if (a2 != null) {
            this.mMsgList.add(a2);
            if (this.aqT != null) {
                this.aqT.g(a2);
                this.aqT.d(this.mMsgList, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, JSONObject jSONObject, int i, boolean z) {
        com.baidu.live.im.a aVar = new com.baidu.live.im.a();
        aVar.setMsgType(i);
        aVar.setContent(str);
        aVar.setObjContent(jSONObject);
        if (z) {
            this.mMsgList.add(aVar);
        }
        if (this.aqT != null) {
            this.aqT.g(aVar);
            if (z) {
                this.aqT.d(this.mMsgList, true);
            }
        }
    }

    protected void a(ResponsedMessage<?> responsedMessage, boolean z) {
        long j;
        List<com.baidu.live.im.data.a> list;
        boolean z2;
        if (!(responsedMessage instanceof ALAGroupHttpResponseMessage)) {
            j = 0;
            list = null;
            z2 = false;
        } else {
            list = ((ALAGroupHttpResponseMessage) responsedMessage).xA();
            j = ((ALAGroupHttpResponseMessage) responsedMessage).getGroupId();
            z2 = ((ALAGroupHttpResponseMessage) responsedMessage).xz();
        }
        if (j == JavaTypesHelper.toLong(this.mGroupId, 0L) && list != null && !list.isEmpty()) {
            if (TbadkCoreApplication.getInst().isOther()) {
                if (z2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913167, list));
                    return;
                } else {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913146, list));
                    return;
                }
            }
            if (z2) {
                y(list);
            }
            b(list, z2);
            if (this.aqY != 0) {
                int i = this.aqZ * this.aqX;
                ArrayList arrayList = new ArrayList(this.aqW);
                list.addAll(0, arrayList.subList(i, arrayList.size()));
                vV();
            }
            if (list.size() > 0) {
                if (list.size() > 5 && z) {
                    w(list);
                } else {
                    v(a(list, z, z2));
                }
            }
        }
    }

    private void b(List<com.baidu.live.im.data.a> list, boolean z) {
        String str;
        JSONObject jSONObject;
        LinkedList linkedList = new LinkedList();
        for (com.baidu.live.im.data.a aVar : list) {
            long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
            if (!ListUtils.isEmpty(aVar.xq()) && !aVar.xq().contains(Long.valueOf(currentAccountId))) {
                linkedList.add(aVar);
            } else {
                boolean z2 = aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                if (z2 && aVar.getMsgType() == 1 && !ListUtils.isEmpty(aVar.xo().Xl) && this.Yi == null) {
                    this.Yi = aVar.xo().Xl;
                }
                if (z2 && aVar.getMsgType() != 125 && aVar.getMsgType() != 24 && aVar.getMsgType() != 13 && aVar.getMsgType() != 28) {
                    linkedList.add(aVar);
                } else if (aVar.getMsgType() == 125) {
                    try {
                        if (!"1".equals(new JSONObject(aVar.getContent()).optString("is_first"))) {
                            linkedList.add(aVar);
                            if (this.aqT != null) {
                                this.aqT.g(aVar);
                            }
                        }
                    } catch (JSONException e) {
                        BdLog.e(e);
                        linkedList.add(aVar);
                    }
                } else if (aVar.getMsgType() == 13) {
                    try {
                        if (aVar.getObjContent() instanceof JSONObject) {
                            jSONObject = (JSONObject) aVar.getObjContent();
                        } else {
                            jSONObject = new JSONObject(aVar.getContent());
                        }
                        str = jSONObject.optString("content_type");
                    } catch (JSONException e2) {
                        linkedList.add(aVar);
                        str = null;
                    }
                    if ("enter_live".equals(str)) {
                        if (com.baidu.live.entereffect.a.qR().a(aVar)) {
                            linkedList.add(aVar);
                            if (this.aqT != null) {
                                this.aqT.g(aVar);
                            }
                        }
                    } else if ("close_live".equals(str)) {
                        linkedList.add(aVar);
                        if (this.aqT != null) {
                            this.aqT.g(aVar);
                        }
                    } else if ("task".equals(str)) {
                        linkedList.add(aVar);
                        if (this.aqT != null) {
                            this.aqT.g(aVar);
                        }
                    } else if ("live_achievement".equals(str)) {
                        linkedList.add(aVar);
                        if (this.aqT != null) {
                            this.aqT.g(aVar);
                        }
                    } else if ("ss_hot_live".equals(str)) {
                        linkedList.add(aVar);
                        if (this.aqT != null) {
                            this.aqT.g(aVar);
                        }
                    } else if ("challenge_direct_new".equals(str)) {
                        linkedList.add(aVar);
                        if (this.aqT != null) {
                            this.aqT.g(aVar);
                        }
                    } else if ("update_liveinfo".equals(str)) {
                        linkedList.add(aVar);
                        if (this.aqT != null) {
                            this.aqT.g(aVar);
                        }
                    } else if ("backstage_live".equals(str)) {
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                    } else if ("offline_type".equals(str)) {
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                    } else if ("follow_anchor".equals(str)) {
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                    } else if (com.baidu.tbadk.TbConfig.TMP_SHARE_DIR_NAME.equals(str)) {
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                    } else if ("share_tieba".equals(str)) {
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                    } else if ("remove_video".equals(str)) {
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                    } else if ("ueg_warn".equals(str)) {
                        Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                    } else if ("live_admin".equals(str)) {
                        if (z2 && !ListUtils.isEmpty(aVar.xo().Xl)) {
                            this.Yi = aVar.xo().Xl;
                            if (this.ald != null) {
                                this.ald.Yi = this.Yi;
                            }
                        }
                    } else if (!"live_talk_ban".equals(str) && !"live_on_private".equals(str)) {
                        if ("challenge_direct_matched".equals(str)) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if ("challenge_direct_start".equals(str)) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if ("challenge_random_matched".equals(str)) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if ("challenge_random_start".equals(str)) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str, "share_rmb")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str, "zan_rmb")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str, "start_grab_wheel")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str, "guard_club_join")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str, "send_redpacket")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str, "start_grab_redpacket")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str, "guard_seat")) {
                            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                                linkedList.add(aVar);
                            }
                        } else if (TextUtils.equals(str, "challenge_mvp")) {
                            Log.d(CameraActivityConfig.KEY_CONTENT_TYPE, CameraActivityConfig.KEY_CONTENT_TYPE);
                        } else if (TextUtils.equals(str, "wish_list_finish") || TextUtils.equals(str, "wish_list_success")) {
                            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                                linkedList.add(aVar);
                            }
                        } else if ("ui_event".equals(str)) {
                            linkedList.add(aVar);
                            if (this.aqT != null) {
                                this.aqT.g(aVar);
                            }
                        } else if ("first_recharge_success".equals(str)) {
                            linkedList.add(aVar);
                            if (this.aqT != null) {
                                this.aqT.g(aVar);
                            }
                        } else if ("privilege_award_success".equals(str)) {
                            linkedList.add(aVar);
                            if (this.aqT != null) {
                                this.aqT.g(aVar);
                            }
                        } else if ("need_update_live_mark_info".equals(str)) {
                            linkedList.add(aVar);
                            if (this.aqT != null) {
                                this.aqT.g(aVar);
                            }
                        } else if ("official_notice".equals(str)) {
                            linkedList.add(aVar);
                            if (this.aqT != null && !z) {
                                this.aqT.g(aVar);
                            }
                        } else {
                            linkedList.add(aVar);
                        }
                    }
                } else if (aVar.getMsgType() == 12) {
                    linkedList.add(aVar);
                    if (this.aqT != null) {
                        this.aqT.g(aVar);
                    }
                    dJ("push");
                }
            }
        }
        if (linkedList.size() > 0) {
            list.removeAll(linkedList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(List<com.baidu.live.im.data.a> list) {
        if (list != null && this.aqT != null) {
            this.aqT.d(this.mMsgList, true);
            for (com.baidu.live.im.data.a aVar : list) {
                this.aqT.g(aVar);
            }
        }
    }

    protected void w(List<com.baidu.live.im.data.a> list) {
        this.aqW = list;
        this.aqY = (int) ((this.ara * 2.0f) / 0.25f);
        this.aqZ = 0;
        this.aqX = list.size() / this.aqY;
        if (this.aqX <= 0) {
            this.aqX = 1;
        }
        this.mHandler.removeCallbacks(this.ard);
        this.mHandler.postDelayed(this.ard, 250L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vV() {
        this.mHandler.removeCallbacks(this.ard);
        this.aqZ = 0;
        this.aqY = 0;
        this.aqX = 0;
        this.aqW = null;
    }

    protected List<com.baidu.live.im.data.a> c(List<com.baidu.live.im.data.a> list, boolean z) {
        return a(list, z, false);
    }

    protected List<com.baidu.live.im.data.a> a(List<com.baidu.live.im.data.a> list, boolean z, boolean z2) {
        for (com.baidu.live.im.data.a aVar : list) {
            if (aVar instanceof com.baidu.live.im.a) {
                ((com.baidu.live.im.a) aVar).dI(this.aqV);
            }
        }
        if (z) {
            LinkedList linkedList = new LinkedList();
            for (com.baidu.live.im.data.a aVar2 : list) {
                if (aVar2.getMsgId() > getLastMid()) {
                    if (aVar2.getMsgType() == 24) {
                        List<com.baidu.live.im.data.a> f = f(aVar2);
                        this.mMsgList.addAll(f);
                        linkedList.addAll(f);
                    } else {
                        this.mMsgList.add(aVar2);
                        linkedList.add(aVar2);
                    }
                }
            }
            list = linkedList;
        } else {
            delRepeatMsg(this.mMsgList, list);
            c(z2, list);
            if (!z2) {
                x(list);
            }
            if (z2 && this.mMsgList.size() > 2) {
                this.mMsgList.addAll(2, list);
            } else {
                this.mMsgList.addAll(list);
            }
        }
        if (this.mMsgList.size() > com.baidu.live.v.a.zj().awA.aaK) {
            int i = (int) (com.baidu.live.v.a.zj().awA.aaK * 0.7d);
            if (i <= 0) {
                i = 1;
            }
            while (this.mMsgList.size() > i) {
                this.mMsgList.removeFirst();
            }
        }
        if (this.mMsgList.size() > 1) {
            boolean e = e(this.mMsgList.get(this.mMsgList.size() - 1));
            while (e && e(this.mMsgList.get(this.mMsgList.size() - 2))) {
                this.mMsgList.remove(this.mMsgList.size() - 2);
                if (this.mMsgList.size() <= 1) {
                    break;
                }
            }
        }
        return list;
    }

    private void x(List<com.baidu.live.im.data.a> list) {
        List<AlaLiveMarkData> list2;
        if (list != null && !list.isEmpty()) {
            for (com.baidu.live.im.data.a aVar : list) {
                if (aVar.getMsgType() == 24) {
                    boolean z = false;
                    com.baidu.live.data.a xo = aVar.xo();
                    if (xo != null && (list2 = xo.Xl) != null && !list2.isEmpty()) {
                        for (AlaLiveMarkData alaLiveMarkData : list2) {
                            if (alaLiveMarkData.type == 102) {
                                z = true;
                                break;
                            }
                        }
                    }
                    try {
                        if (aVar.getObjContent() instanceof JSONObject) {
                            JSONObject jSONObject = (JSONObject) aVar.getObjContent();
                            double e = com.baidu.live.v.d.zq().e(z, jSONObject.optString(LogConfig.LOG_GIFT_ID));
                            if (e > 0.0d) {
                                jSONObject.put("gift_rate", e);
                                aVar.setObjContent(jSONObject);
                            } else {
                                return;
                            }
                        } else {
                            JSONObject jSONObject2 = new JSONObject(aVar.getContent());
                            double e2 = com.baidu.live.v.d.zq().e(z, jSONObject2.optString(LogConfig.LOG_GIFT_ID));
                            if (e2 > 0.0d) {
                                jSONObject2.put("gift_rate", e2);
                                aVar.setContent(jSONObject2.toString());
                            } else {
                                return;
                            }
                        }
                    } catch (JSONException e3) {
                    }
                }
            }
        }
    }

    private void c(boolean z, List<com.baidu.live.im.data.a> list) {
        JSONObject jSONObject;
        if (z && list != null && !list.isEmpty()) {
            Iterator<com.baidu.live.im.data.a> it = list.iterator();
            while (it.hasNext()) {
                com.baidu.live.im.data.a next = it.next();
                if (next != null) {
                    try {
                        if (next.getObjContent() instanceof JSONObject) {
                            jSONObject = (JSONObject) next.getObjContent();
                        } else {
                            jSONObject = new JSONObject(next.getContent());
                        }
                        String optString = jSONObject.optString("content_type");
                        if (!TextUtils.isEmpty(optString) && (optString.equals("challenge_direct_start") || optString.equals("challenge_direct_matched") || optString.equals("challenge_random_start") || optString.equals("challenge_random_matched") || optString.equals("live_net_status") || optString.equals("send_redpacket") || optString.equals("start_grab_redpacket") || optString.equals("guard_seat") || optString.equals("challenge_mvp") || optString.equals("official_notice"))) {
                            it.remove();
                        }
                    } catch (JSONException e) {
                    }
                }
            }
        }
    }

    private void y(List<com.baidu.live.im.data.a> list) {
        if (list != null && !list.isEmpty()) {
            for (com.baidu.live.im.data.a aVar : list) {
                aVar.aW(true);
            }
        }
    }

    private boolean e(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        String str = null;
        if (aVar.getMsgType() == 13 || aVar.getMsgType() == 12) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                try {
                    str = jSONObject.optString("content_type");
                    jSONObject.optString("text");
                } catch (JSONException e) {
                }
            } catch (JSONException e2) {
                jSONObject = null;
            }
            if ("enter_live".equals(str) && jSONObject != null && TextUtils.isEmpty(jSONObject.optString("enter_msg"))) {
                return true;
            }
        }
        return false;
    }

    private void delRepeatMsg(List<com.baidu.live.im.data.a> list, List<com.baidu.live.im.data.a> list2) {
        if (list != null && list2 != null) {
            int size = list.size();
            int size2 = list2.size();
            if (size2 != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = size - 1; i >= 0 && i >= 0; i--) {
                    com.baidu.live.im.data.a aVar = list.get(i);
                    if (aVar != null && aVar.xo() != null && !TextUtils.isEmpty(aVar.xo().userId) && aVar.xo().userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        int i2 = size2 - 1;
                        while (true) {
                            if (i2 >= 0 && i2 >= 0) {
                                com.baidu.live.im.data.a aVar2 = list2.get(i2);
                                if (aVar2 != null && aVar2.xo() != null && !TextUtils.isEmpty(aVar2.xo().userId) && aVar2.xo().userId.equals(TbadkCoreApplication.getCurrentAccount()) && aVar2.getRecordId() == aVar.getRecordId()) {
                                    arrayList.add(aVar2);
                                    break;
                                }
                                i2--;
                            }
                        }
                    }
                }
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    list2.remove(arrayList.get(i3));
                }
                arrayList.clear();
            }
        }
    }

    public void vW() {
        this.mGroupId = null;
        this.aqU = null;
        this.mLiveId = null;
        this.arb = "0";
        this.mAppId = null;
        MessageManager.getInstance().unRegisterListener(this.arl);
        MessageManager.getInstance().unRegisterListener(this.ark);
        MessageManager.getInstance().unRegisterListener(this.are);
        MessageManager.getInstance().unRegisterListener(this.arh);
        MessageManager.getInstance().unRegisterListener(this.ari);
        MessageManager.getInstance().unRegisterListener(this.arj);
        MessageManager.getInstance().unRegisterListener(this.arf);
        this.mHandler.removeCallbacks(this.ard);
        this.mHandler.removeCallbacks(this.arg);
        if (this.mMsgList != null) {
            this.mMsgList.clear();
        }
        this.mMsgList = null;
    }

    public void a(ImSendMsgData imSendMsgData, boolean z, boolean z2, int i, String str, String[] strArr) {
        if (!TbadkCoreApplication.isLogin()) {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.sdk_not_login);
        } else if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow())) {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.sdk_username_empty);
        } else {
            String str2 = imSendMsgData.text;
            short s = imSendMsgData.msgType;
            com.baidu.live.im.data.a a2 = a(s, str2, z, z2, i, this.Yi);
            if (s == 126) {
                a2.bX(imSendMsgData.barrageType);
                a2.dN(imSendMsgData.barrageId);
                a2.a(imSendMsgData.barrageCardInfo);
            }
            if (a2 != null) {
                a2.l(strArr);
                this.mMsgList.add(a2);
                if (this.aqT != null) {
                    this.aqT.g(a2);
                    this.aqT.d(this.mMsgList, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913043));
                com.baidu.live.im.message.a aVar = new com.baidu.live.im.message.a(str2, s, JavaTypesHelper.toInt(this.mGroupId, 0), this.mAppId);
                if (this.ald != null && this.ald.mLiveInfo != null) {
                    aVar.dO(this.ald.mLiveInfo.live_id + "");
                    aVar.dP(this.ald.mLiveInfo.room_id + "");
                } else {
                    aVar.dO("");
                    aVar.dP("");
                }
                aVar.setOtherParams(str);
                aVar.G(imSendMsgData.price);
                aVar.bX(imSendMsgData.barrageType);
                aVar.dN(imSendMsgData.barrageId);
                aVar.a(imSendMsgData.barrageCardInfo);
                aVar.l(strArr);
                sendMessage(aVar);
            }
        }
    }

    protected com.baidu.live.im.data.a a(short s, String str, boolean z, boolean z2, int i, List<AlaLiveMarkData> list) {
        long j = 0;
        com.baidu.live.im.data.a vX = vX();
        if (vX == null) {
            return null;
        }
        vX.setMsgType(s);
        vX.setContent(str);
        long F = o.F(getLastMid());
        vX.setMsgId(F);
        vX.setRecordId(F);
        vX.setTime(System.currentTimeMillis() / 1000);
        com.baidu.live.data.a aVar = new com.baidu.live.data.a();
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            aVar.userName = TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow();
        }
        aVar.userId = TbadkCoreApplication.getCurrentAccount();
        aVar.portrait = TbadkCoreApplication.getCurrentPortrait();
        aVar.level_id = i;
        aVar.Xi = z;
        aVar.Xj = z2;
        if (list != null) {
            aVar.Xl = new ArrayList(list);
        }
        vX.d(aVar);
        try {
            j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        } catch (Exception e) {
        }
        vX.setUserId(j);
        return vX;
    }

    private long getLastMid() {
        if (this.mMsgList == null || this.mMsgList.size() <= 0) {
            return JavaTypesHelper.toLong(this.aqU, 1L);
        }
        return this.mMsgList.get(this.mMsgList.size() - 1).getMsgId();
    }

    protected com.baidu.live.im.data.a vX() {
        com.baidu.live.im.a aVar = new com.baidu.live.im.a();
        aVar.setBornTime(System.currentTimeMillis());
        if (TextUtils.isEmpty(this.mGroupId)) {
            return null;
        }
        aVar.dI(this.aqV);
        return aVar;
    }

    public void z(List<AlaLiveMarkData> list) {
        this.Yi = list;
    }

    public void dJ(String str) {
        com.baidu.live.message.c cVar = new com.baidu.live.message.c(JavaTypesHelper.toLong(this.mLiveId, 0L), str);
        cVar.setParams();
        sendMessage(cVar);
    }

    public void dK(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.arb)) {
            dJ("getliveinfo");
        }
    }

    private List<com.baidu.live.im.data.a> f(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        int optInt;
        boolean rF;
        ArrayList arrayList = new ArrayList();
        if (!(aVar instanceof com.baidu.live.im.a)) {
            arrayList.add(aVar);
            return arrayList;
        }
        com.baidu.live.im.a aVar2 = (com.baidu.live.im.a) aVar;
        try {
            aVar.getObjContent();
            jSONObject = new JSONObject(aVar2.getContent());
            optInt = jSONObject.optInt("is_combo");
            com.baidu.live.gift.g dp = t.dp(jSONObject.optString(LogConfig.LOG_GIFT_ID));
            rF = dp != null ? dp.rF() : false;
        } catch (JSONException e) {
            arrayList.add(aVar2);
        }
        if (optInt == 1 || rF) {
            arrayList.add(aVar2);
            return arrayList;
        }
        long optLong = jSONObject.optLong("gift_count");
        if (optLong <= 1) {
            arrayList.add(aVar2);
            return arrayList;
        }
        jSONObject.put("gift_count", 1);
        String jSONObject2 = jSONObject.toString();
        for (int i = 0; i < optLong; i++) {
            com.baidu.live.im.a aVar3 = new com.baidu.live.im.a();
            aVar3.dI(aVar2.vP());
            aVar3.setBornTime(aVar2.getBornTime());
            aVar3.setTime(aVar2.getTime());
            aVar3.setUserId(aVar2.getUserId());
            aVar3.setToUserId(aVar2.getToUserId());
            aVar3.e(aVar2.xp());
            aVar3.setContent(jSONObject2);
            aVar3.setObjContent(jSONObject);
            aVar3.setGifLoadSuccess(aVar2.isGifLoadSuccess());
            aVar3.setHasRead(aVar2.isHasRead());
            aVar3.setIsPushForOperateAccount(aVar2.isPushForOperateAccount());
            aVar3.setLink(aVar2.getLink());
            aVar3.setIsUploading(aVar2.getIsUploading());
            aVar3.setMsgId(aVar2.getMsgId());
            aVar3.setMsgType(aVar2.getMsgType());
            aVar3.setProgressValue(aVar2.getProgressValue());
            aVar3.setTaskId(aVar2.getTaskId());
            aVar3.setRecordId(aVar2.getRecordId());
            aVar3.setStat(aVar2.getStat());
            aVar3.setLogTime(aVar2.getLogTime());
            aVar3.d(aVar2.xo());
            aVar3.setSt_type(aVar2.getSt_type());
            arrayList.add(aVar3);
        }
        return arrayList;
    }

    public void a(int i, String str, com.baidu.live.data.a aVar) {
        com.baidu.live.im.data.a vX = vX();
        if (vX != null) {
            vX.setMsgType(i);
            vX.setContent(str);
            vX.d(aVar);
            this.mMsgList.add(vX);
            if (this.aqT != null) {
                this.aqT.d(this.mMsgList, true);
                this.aqT.g(vX);
            }
        }
    }
}
