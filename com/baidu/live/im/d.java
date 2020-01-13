package com.baidu.live.im;

import android.os.Handler;
import android.text.TextUtils;
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
import com.baidu.live.gift.s;
import com.baidu.live.im.b;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.message.ALAGroupCommitHttpResponsedMessage;
import com.baidu.live.im.message.ALAGroupHttpResponseMessage;
import com.baidu.live.message.AlaGetLiveStatusHttpResponseMessage;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.log.LogConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends BdBaseModel {
    private List<AlaLiveMarkData> Wx;
    private com.baidu.live.data.l aiW;
    private boolean anA;
    private a anB;
    private String anC;
    private String anD;
    private List<com.baidu.live.im.data.a> anE;
    private int anF;
    private int anG;
    private int anH;
    private float anI;
    private String anJ;
    private b.a anK;
    private Runnable anL;
    private CustomMessageListener anM;
    private CustomMessageListener anN;
    private Runnable anO;
    private HttpMessageListener anP;
    private HttpMessageListener anQ;
    private HttpMessageListener anR;
    private HttpMessageListener anS;
    private NetMessageListener anT;
    private String mAppId;
    private String mGroupId;
    private Handler mHandler;
    private String mLiveId;
    private LinkedList<com.baidu.live.im.data.a> mMsgList;
    BdPageContext<?> mPageContext;

    /* loaded from: classes2.dex */
    public interface a {
        void d(List<com.baidu.live.im.data.a> list, boolean z);

        void g(com.baidu.live.im.data.a aVar);

        void uu();
    }

    static /* synthetic */ int h(d dVar) {
        int i = dVar.anH;
        dVar.anH = i + 1;
        return i;
    }

    public d(BdPageContext<?> bdPageContext, boolean z, a aVar) {
        super(bdPageContext);
        this.mLiveId = null;
        this.anI = 1.0f;
        this.mHandler = new Handler();
        this.anJ = null;
        this.anK = new b.a() { // from class: com.baidu.live.im.d.1
        };
        this.anL = new Runnable() { // from class: com.baidu.live.im.d.4
            @Override // java.lang.Runnable
            public void run() {
                int i = d.this.anH * d.this.anF;
                if (i >= d.this.anE.size()) {
                    d.this.ur();
                } else if (d.this.anH >= d.this.anG - 1) {
                    if (d.this.anH != d.this.anG - 1) {
                        d.this.ur();
                        return;
                    }
                    ArrayList arrayList = new ArrayList(d.this.anE);
                    d.this.v(d.this.c(arrayList.subList(i, arrayList.size()), true));
                    d.h(d.this);
                    d.this.ur();
                } else {
                    ArrayList arrayList2 = new ArrayList(d.this.anE);
                    if (d.this.anF + i <= arrayList2.size()) {
                        d.this.v(d.this.c(arrayList2.subList(i, d.this.anF + i), true));
                        d.h(d.this);
                        d.this.mHandler.postDelayed(d.this.anL, 250L);
                        return;
                    }
                    d.this.v(d.this.c(arrayList2.subList(i, arrayList2.size()), true));
                    d.h(d.this);
                    d.this.ur();
                }
            }
        };
        this.anM = new CustomMessageListener(MessageConfig.SOCKET_RECEIVE_MSG) { // from class: com.baidu.live.im.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.uq();
            }
        };
        this.anN = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.live.im.d.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        com.baidu.live.im.a aVar2 = new com.baidu.live.im.a();
                        aVar2.setMsgType(27);
                        aVar2.setContent(d.this.mPageContext.getString(a.i.sdk_im_offline));
                        d.this.mMsgList.add(aVar2);
                        if (d.this.anB != null) {
                            d.this.anB.g(aVar2);
                            d.this.anB.d(d.this.mMsgList, true);
                        }
                    } else if (((NetWorkChangedMessage) customResponsedMessage).mLastNetState == 0 && BdNetTypeUtil.isNetWorkAvailable()) {
                        com.baidu.live.im.a aVar3 = new com.baidu.live.im.a();
                        aVar3.setMsgType(27);
                        aVar3.setContent(d.this.mPageContext.getString(a.i.sdk_im_online));
                        d.this.mMsgList.add(aVar3);
                        if (d.this.anB != null) {
                            d.this.anB.g(aVar3);
                            d.this.anB.d(d.this.mMsgList, true);
                        }
                    }
                }
            }
        };
        this.anO = new Runnable() { // from class: com.baidu.live.im.d.8
            @Override // java.lang.Runnable
            public void run() {
                if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().getLastReceDataTime() > 35000) {
                    d.this.up();
                }
                d.this.uo();
            }
        };
        this.anP = new HttpMessageListener(1021013) { // from class: com.baidu.live.im.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    if (!httpResponsedMessage.hasError()) {
                        if (d.this.anB != null) {
                            d.this.anB.uu();
                        }
                    } else if (httpResponsedMessage.getError() == 149010) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913070, httpResponsedMessage.getErrorString()));
                    } else {
                        BdUtilHelper.showToast(d.this.mPageContext.getPageActivity(), httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        this.anQ = new HttpMessageListener(1021015) { // from class: com.baidu.live.im.d.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                        if (orginalMessage instanceof com.baidu.live.gift.j) {
                            com.baidu.live.gift.j jVar = (com.baidu.live.gift.j) orginalMessage;
                            d.this.S(jVar.aeQ, jVar.giftName);
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913151, "isAttentionOrGift"));
                }
            }
        };
        this.anR = new HttpMessageListener(1021014) { // from class: com.baidu.live.im.d.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    if (httpResponsedMessage.hasError()) {
                        Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                        if (orginalMessage instanceof com.baidu.live.gift.o) {
                            com.baidu.live.gift.o oVar = (com.baidu.live.gift.o) orginalMessage;
                            d.this.S(oVar.aeQ, oVar.giftName);
                            return;
                        }
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913151, "isAttentionOrGift"));
                }
            }
        };
        this.anS = new HttpMessageListener(1021012) { // from class: com.baidu.live.im.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                d.this.a((ResponsedMessage<?>) httpResponsedMessage, false);
            }
        };
        this.anT = new NetMessageListener(1021050, 601008) { // from class: com.baidu.live.im.d.3
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                JSONObject jSONObject;
                AlaGetLiveStatusHttpResponseMessage alaGetLiveStatusHttpResponseMessage = responsedMessage instanceof AlaGetLiveStatusHttpResponseMessage ? (AlaGetLiveStatusHttpResponseMessage) responsedMessage : null;
                if (alaGetLiveStatusHttpResponseMessage != null) {
                    try {
                        jSONObject = new JSONObject(alaGetLiveStatusHttpResponseMessage.asj);
                    } catch (JSONException e) {
                        jSONObject = null;
                    }
                    if (jSONObject != null) {
                        if (!"backstage_live".equals(jSONObject.optString("content_type"))) {
                            d.this.a(alaGetLiveStatusHttpResponseMessage.asj, jSONObject, 12, false);
                            return;
                        }
                        String optString = jSONObject.optString("backstage_type");
                        if (!TextUtils.isEmpty(optString) && !optString.equals(d.this.anJ)) {
                            d.this.a(alaGetLiveStatusHttpResponseMessage.asj, jSONObject, 13, true);
                            d.this.anJ = optString;
                        }
                    }
                }
            }
        };
        this.mPageContext = bdPageContext;
        this.anA = z;
        this.anB = aVar;
        this.mMsgList = new LinkedList<>();
        MessageManager.getInstance().registerTask(un());
        com.baidu.live.tieba.f.a.a.a(1021050, "alaim/gmsg/getLiveStatus", AlaGetLiveStatusHttpResponseMessage.class, false, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021012, "alaim/gmsg/getGroupMsg", ALAGroupHttpResponseMessage.class, false, true, true, true);
    }

    public void d(com.baidu.live.data.l lVar) {
        this.aiW = lVar;
    }

    private HttpMessageTask un() {
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
        this.anC = str2;
        this.anD = str3;
        this.mLiveId = str4;
        this.anJ = "0";
        this.mAppId = str5;
        MessageManager.getInstance().registerListener(this.anS);
        MessageManager.getInstance().registerListener(this.anT);
        MessageManager.getInstance().registerListener(this.anM);
        MessageManager.getInstance().registerListener(this.anP);
        MessageManager.getInstance().registerListener(this.anN);
        MessageManager.getInstance().registerListener(this.anQ);
        MessageManager.getInstance().registerListener(this.anR);
        if (BdSocketLinkService.isClose()) {
            up();
            BdSocketLinkService.startService(true, "live start");
        }
        String str6 = com.baidu.live.s.a.wR().asq.WZ;
        if (!TextUtils.isEmpty(str6)) {
            com.baidu.live.im.data.a ut = ut();
            ut.setMsgType(13);
            ut.setContent(str6);
            this.mMsgList.add(ut);
            if (this.anB != null) {
                this.anB.g(ut);
            }
        }
        String str7 = com.baidu.live.s.a.wR().asq.Xa;
        if (!TextUtils.isEmpty(str7)) {
            com.baidu.live.im.data.a ut2 = ut();
            ut2.setMsgType(13);
            ut2.setContent(str7);
            this.mMsgList.add(ut2);
        }
        List<String> list = com.baidu.live.s.a.wR().asq.WY;
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
                    com.baidu.live.im.data.a ut3 = ut();
                    ut3.setMsgType(13);
                    ut3.setContent(str8);
                    ut3.setLink(str9);
                    this.mMsgList.add(ut3);
                    if (this.anB != null) {
                        this.anB.g(ut3);
                    }
                }
                i = i2 + 2;
            }
        }
        if (this.mMsgList.size() > 0) {
            this.anB.d(this.mMsgList, true);
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGmsgGetLiveStatusUnabled()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.d.7
                @Override // java.lang.Runnable
                public void run() {
                    d.this.dy("enter");
                }
            }, 1000L);
        }
        uo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uo() {
        this.mHandler.postDelayed(this.anO, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void up() {
        sendMessage(new com.baidu.live.im.message.b(JavaTypesHelper.toInt(this.mGroupId, 0), getLastMid()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uq() {
        this.mHandler.removeCallbacks(this.anO);
    }

    public void S(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "1";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = this.mPageContext.getString(a.i.sdk_gift);
        }
        com.baidu.live.im.data.a a2 = a((short) 27, String.format(this.mPageContext.getString(a.i.sdk_send_gift_fail), str, str2), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), this.Wx);
        if (a2 != null) {
            this.mMsgList.add(a2);
            if (this.anB != null) {
                this.anB.g(a2);
                this.anB.d(this.mMsgList, true);
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
        if (this.anB != null) {
            this.anB.g(aVar);
            if (z) {
                this.anB.d(this.mMsgList, true);
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
            list = ((ALAGroupHttpResponseMessage) responsedMessage).vC();
            j = ((ALAGroupHttpResponseMessage) responsedMessage).getGroupId();
            z2 = ((ALAGroupHttpResponseMessage) responsedMessage).vB();
        }
        if (j == JavaTypesHelper.toLong(this.mGroupId, 0L) && list != null && !list.isEmpty()) {
            if (z2) {
                y(list);
            }
            b(list, z2);
            if (this.anG != 0) {
                int i = this.anH * this.anF;
                ArrayList arrayList = new ArrayList(this.anE);
                list.addAll(0, arrayList.subList(i, arrayList.size()));
                ur();
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
            if (!ListUtils.isEmpty(aVar.vs()) && !aVar.vs().contains(Long.valueOf(currentAccountId))) {
                linkedList.add(aVar);
            } else {
                boolean z2 = aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                if (z2 && aVar.getMsgType() == 1 && !ListUtils.isEmpty(aVar.vq().VF) && this.Wx == null) {
                    this.Wx = aVar.vq().VF;
                }
                if (z2 && aVar.getMsgType() != 125 && aVar.getMsgType() != 24 && aVar.getMsgType() != 13 && aVar.getMsgType() != 28) {
                    linkedList.add(aVar);
                } else if (aVar.getMsgType() == 125) {
                    try {
                        if (!"1".equals(new JSONObject(aVar.getContent()).optString("is_first"))) {
                            linkedList.add(aVar);
                            if (this.anB != null) {
                                this.anB.g(aVar);
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
                        if (com.baidu.live.entereffect.a.qg().a(aVar)) {
                            linkedList.add(aVar);
                            if (this.anB != null) {
                                this.anB.g(aVar);
                            }
                        }
                    } else if ("close_live".equals(str)) {
                        linkedList.add(aVar);
                        if (this.anB != null) {
                            this.anB.g(aVar);
                        }
                    } else if ("task".equals(str)) {
                        linkedList.add(aVar);
                        if (this.anB != null) {
                            this.anB.g(aVar);
                        }
                    } else if ("live_achievement".equals(str)) {
                        linkedList.add(aVar);
                        if (this.anB != null) {
                            this.anB.g(aVar);
                        }
                    } else if ("ss_hot_live".equals(str)) {
                        linkedList.add(aVar);
                        if (this.anB != null) {
                            this.anB.g(aVar);
                        }
                    } else if ("challenge_direct_new".equals(str)) {
                        linkedList.add(aVar);
                        if (this.anB != null) {
                            this.anB.g(aVar);
                        }
                    } else if ("update_liveinfo".equals(str)) {
                        linkedList.add(aVar);
                        if (this.anB != null) {
                            this.anB.g(aVar);
                        }
                    } else if (!"backstage_live".equals(str) && !"offline_type".equals(str) && !"follow_anchor".equals(str) && !com.baidu.tbadk.TbConfig.TMP_SHARE_DIR_NAME.equals(str) && !"share_tieba".equals(str) && !"remove_video".equals(str) && !"ueg_warn".equals(str)) {
                        if ("live_admin".equals(str)) {
                            if (z2 && !ListUtils.isEmpty(aVar.vq().VF)) {
                                this.Wx = aVar.vq().VF;
                                if (this.aiW != null) {
                                    this.aiW.Wx = this.Wx;
                                }
                            }
                        } else if (!"live_talk_ban".equals(str) && !"live_on_private".equals(str) && !"challenge_direct_matched".equals(str) && !"challenge_direct_start".equals(str) && !"challenge_random_matched".equals(str) && !"challenge_random_start".equals(str) && !TextUtils.equals(str, "share_rmb") && !TextUtils.equals(str, "zan_rmb") && !TextUtils.equals(str, "start_grab_wheel") && !TextUtils.equals(str, "guard_club_join") && !TextUtils.equals(str, "send_redpacket") && !TextUtils.equals(str, "start_grab_redpacket")) {
                            if (TextUtils.equals(str, "guard_seat")) {
                                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                                    linkedList.add(aVar);
                                }
                            } else if (!TextUtils.equals(str, "challenge_mvp")) {
                                if (TextUtils.equals(str, "wish_list_finish") || TextUtils.equals(str, "wish_list_success")) {
                                    if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                                        linkedList.add(aVar);
                                    }
                                } else if ("ui_event".equals(str)) {
                                    linkedList.add(aVar);
                                    if (this.anB != null) {
                                        this.anB.g(aVar);
                                    }
                                } else if ("first_recharge_success".equals(str)) {
                                    linkedList.add(aVar);
                                    if (this.anB != null) {
                                        this.anB.g(aVar);
                                    }
                                } else if ("privilege_award_success".equals(str)) {
                                    linkedList.add(aVar);
                                    if (this.anB != null) {
                                        this.anB.g(aVar);
                                    }
                                } else if ("need_update_live_mark_info".equals(str)) {
                                    linkedList.add(aVar);
                                    if (this.anB != null) {
                                        this.anB.g(aVar);
                                    }
                                } else if ("official_notice".equals(str)) {
                                    linkedList.add(aVar);
                                    if (this.anB != null && !z) {
                                        this.anB.g(aVar);
                                    }
                                } else {
                                    linkedList.add(aVar);
                                }
                            }
                        }
                    }
                } else if (aVar.getMsgType() == 12) {
                    linkedList.add(aVar);
                    if (this.anB != null) {
                        this.anB.g(aVar);
                    }
                    dy("push");
                }
            }
        }
        if (linkedList.size() > 0) {
            list.removeAll(linkedList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(List<com.baidu.live.im.data.a> list) {
        if (list != null && this.anB != null) {
            this.anB.d(this.mMsgList, true);
            for (com.baidu.live.im.data.a aVar : list) {
                this.anB.g(aVar);
            }
        }
    }

    protected void w(List<com.baidu.live.im.data.a> list) {
        this.anE = list;
        this.anG = (int) ((this.anI * 2.0f) / 0.25f);
        this.anH = 0;
        this.anF = list.size() / this.anG;
        if (this.anF <= 0) {
            this.anF = 1;
        }
        this.mHandler.removeCallbacks(this.anL);
        this.mHandler.postDelayed(this.anL, 250L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ur() {
        this.mHandler.removeCallbacks(this.anL);
        this.anH = 0;
        this.anG = 0;
        this.anF = 0;
        this.anE = null;
    }

    protected List<com.baidu.live.im.data.a> c(List<com.baidu.live.im.data.a> list, boolean z) {
        return a(list, z, false);
    }

    protected List<com.baidu.live.im.data.a> a(List<com.baidu.live.im.data.a> list, boolean z, boolean z2) {
        for (com.baidu.live.im.data.a aVar : list) {
            if (aVar instanceof com.baidu.live.im.a) {
                ((com.baidu.live.im.a) aVar).dx(this.anD);
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
        if (this.mMsgList.size() > com.baidu.live.s.a.wR().asq.YS) {
            int i = (int) (com.baidu.live.s.a.wR().asq.YS * 0.7d);
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
        boolean z;
        List<AlaLiveMarkData> list2;
        double aY = com.baidu.live.s.d.wY().aY(false);
        double aY2 = com.baidu.live.s.d.wY().aY(true);
        if ((aY > 0.0d || aY2 > 0.0d) && list != null && !list.isEmpty()) {
            for (com.baidu.live.im.data.a aVar : list) {
                if (aVar.getMsgType() == 24) {
                    com.baidu.live.data.a vq = aVar.vq();
                    if (vq != null && (list2 = vq.VF) != null && !list2.isEmpty()) {
                        for (AlaLiveMarkData alaLiveMarkData : list2) {
                            if (alaLiveMarkData.type == 102) {
                                z = true;
                                break;
                            }
                        }
                    }
                    z = false;
                    try {
                        if (aVar.getObjContent() instanceof JSONObject) {
                            JSONObject jSONObject = (JSONObject) aVar.getObjContent();
                            jSONObject.put("gift_rate", z ? aY2 : aY);
                            aVar.setObjContent(jSONObject);
                        } else {
                            JSONObject jSONObject2 = new JSONObject(aVar.getContent());
                            jSONObject2.put("gift_rate", z ? aY2 : aY);
                            aVar.setContent(jSONObject2.toString());
                        }
                    } catch (JSONException e) {
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
                aVar.aT(true);
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
            if ("enter_live".equals(str) && TextUtils.isEmpty(jSONObject.optString("enter_msg"))) {
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
                    if (aVar != null && aVar.vq() != null && !TextUtils.isEmpty(aVar.vq().userId) && aVar.vq().userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        int i2 = size2 - 1;
                        while (true) {
                            if (i2 >= 0 && i2 >= 0) {
                                com.baidu.live.im.data.a aVar2 = list2.get(i2);
                                if (aVar2 != null && aVar2.vq() != null && !TextUtils.isEmpty(aVar2.vq().userId) && aVar2.vq().userId.equals(TbadkCoreApplication.getCurrentAccount()) && aVar2.getRecordId() == aVar.getRecordId()) {
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

    public void us() {
        this.mGroupId = null;
        this.anC = null;
        this.mLiveId = null;
        this.anJ = "0";
        this.mAppId = null;
        MessageManager.getInstance().unRegisterListener(this.anT);
        MessageManager.getInstance().unRegisterListener(this.anS);
        MessageManager.getInstance().unRegisterListener(this.anM);
        MessageManager.getInstance().unRegisterListener(this.anP);
        MessageManager.getInstance().unRegisterListener(this.anQ);
        MessageManager.getInstance().unRegisterListener(this.anR);
        MessageManager.getInstance().unRegisterListener(this.anN);
        this.mHandler.removeCallbacks(this.anL);
        this.mHandler.removeCallbacks(this.anO);
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
            com.baidu.live.im.data.a a2 = a(s, str2, z, z2, i, this.Wx);
            if (s == 126) {
                a2.bK(imSendMsgData.barrageType);
                a2.dC(imSendMsgData.barrageId);
                a2.a(imSendMsgData.barrageCardInfo);
            }
            if (a2 != null) {
                a2.k(strArr);
                this.mMsgList.add(a2);
                if (this.anB != null) {
                    this.anB.g(a2);
                    this.anB.d(this.mMsgList, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913043));
                com.baidu.live.im.message.a aVar = new com.baidu.live.im.message.a(str2, s, JavaTypesHelper.toInt(this.mGroupId, 0), this.mAppId);
                if (this.aiW != null && this.aiW.mLiveInfo != null) {
                    aVar.dD(this.aiW.mLiveInfo.live_id + "");
                    aVar.dE(this.aiW.mLiveInfo.room_id + "");
                } else {
                    aVar.dD("");
                    aVar.dE("");
                }
                aVar.setOtherParams(str);
                aVar.C(imSendMsgData.price);
                aVar.bK(imSendMsgData.barrageType);
                aVar.dC(imSendMsgData.barrageId);
                aVar.a(imSendMsgData.barrageCardInfo);
                aVar.k(strArr);
                sendMessage(aVar);
            }
        }
    }

    protected com.baidu.live.im.data.a a(short s, String str, boolean z, boolean z2, int i, List<AlaLiveMarkData> list) {
        long j = 0;
        com.baidu.live.im.data.a ut = ut();
        if (ut == null) {
            return null;
        }
        ut.setMsgType(s);
        ut.setContent(str);
        long B = o.B(getLastMid());
        ut.setMsgId(B);
        ut.setRecordId(B);
        ut.setTime(System.currentTimeMillis() / 1000);
        com.baidu.live.data.a aVar = new com.baidu.live.data.a();
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            aVar.userName = TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow();
        }
        aVar.userId = TbadkCoreApplication.getCurrentAccount();
        aVar.portrait = TbadkCoreApplication.getCurrentPortrait();
        aVar.level_id = i;
        aVar.VC = z;
        aVar.VD = z2;
        if (list != null) {
            aVar.VF = new ArrayList(list);
        }
        ut.b(aVar);
        try {
            j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        } catch (Exception e) {
        }
        ut.setUserId(j);
        return ut;
    }

    private long getLastMid() {
        if (this.mMsgList == null || this.mMsgList.size() <= 0) {
            return JavaTypesHelper.toLong(this.anC, 1L);
        }
        return this.mMsgList.get(this.mMsgList.size() - 1).getMsgId();
    }

    protected com.baidu.live.im.data.a ut() {
        com.baidu.live.im.a aVar = new com.baidu.live.im.a();
        aVar.setBornTime(System.currentTimeMillis());
        if (TextUtils.isEmpty(this.mGroupId)) {
            return null;
        }
        aVar.dx(this.anD);
        return aVar;
    }

    public void z(List<AlaLiveMarkData> list) {
        this.Wx = list;
    }

    public void dy(String str) {
        com.baidu.live.message.c cVar = new com.baidu.live.message.c(JavaTypesHelper.toLong(this.mLiveId, 0L), str);
        cVar.setParams();
        sendMessage(cVar);
    }

    public void dz(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.anJ)) {
            dy("getliveinfo");
        }
    }

    private List<com.baidu.live.im.data.a> f(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        int optInt;
        boolean qM;
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
            com.baidu.live.gift.g df = s.df(jSONObject.optString(LogConfig.LOG_GIFT_ID));
            qM = df != null ? df.qM() : false;
        } catch (JSONException e) {
            arrayList.add(aVar2);
        }
        if (optInt == 1 || qM) {
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
            aVar3.dx(aVar2.ul());
            aVar3.setBornTime(aVar2.getBornTime());
            aVar3.setTime(aVar2.getTime());
            aVar3.setUserId(aVar2.getUserId());
            aVar3.setToUserId(aVar2.getToUserId());
            aVar3.c(aVar2.vr());
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
            aVar3.b(aVar2.vq());
            aVar3.setSt_type(aVar2.getSt_type());
            arrayList.add(aVar3);
        }
        return arrayList;
    }

    public void a(int i, String str, com.baidu.live.data.a aVar) {
        com.baidu.live.im.data.a ut = ut();
        if (ut != null) {
            ut.setMsgType(i);
            ut.setContent(str);
            ut.b(aVar);
            this.mMsgList.add(ut);
            if (this.anB != null) {
                this.anB.d(this.mMsgList, true);
                this.anB.g(ut);
            }
        }
    }
}
