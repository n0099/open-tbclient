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
import com.baidu.live.q.a;
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
    private List<AlaLiveMarkData> Wg;
    private com.baidu.live.data.k aio;
    private boolean amN;
    private a amO;
    private String amP;
    private String amQ;
    private List<com.baidu.live.im.data.a> amR;
    private int amS;
    private int amT;
    private int amU;
    private float amV;
    private String amW;
    private b.a amX;
    private Runnable amY;
    private CustomMessageListener amZ;
    private CustomMessageListener ana;
    private Runnable anb;
    private HttpMessageListener anc;
    private HttpMessageListener and;
    private HttpMessageListener ane;
    private HttpMessageListener anf;
    private NetMessageListener ang;
    private String mAppId;
    private String mGroupId;
    private Handler mHandler;
    private String mLiveId;
    private LinkedList<com.baidu.live.im.data.a> mMsgList;
    BdPageContext<?> mPageContext;

    /* loaded from: classes2.dex */
    public interface a {
        void c(List<com.baidu.live.im.data.a> list, boolean z);

        void g(com.baidu.live.im.data.a aVar);

        void ud();
    }

    static /* synthetic */ int h(d dVar) {
        int i = dVar.amU;
        dVar.amU = i + 1;
        return i;
    }

    public d(BdPageContext<?> bdPageContext, boolean z, a aVar) {
        super(bdPageContext);
        this.mLiveId = null;
        this.amV = 1.0f;
        this.mHandler = new Handler();
        this.amW = null;
        this.amX = new b.a() { // from class: com.baidu.live.im.d.1
        };
        this.amY = new Runnable() { // from class: com.baidu.live.im.d.4
            @Override // java.lang.Runnable
            public void run() {
                int i = d.this.amU * d.this.amS;
                if (i >= d.this.amR.size()) {
                    d.this.ua();
                } else if (d.this.amU >= d.this.amT - 1) {
                    if (d.this.amU != d.this.amT - 1) {
                        d.this.ua();
                        return;
                    }
                    ArrayList arrayList = new ArrayList(d.this.amR);
                    d.this.w(d.this.b(arrayList.subList(i, arrayList.size()), true));
                    d.h(d.this);
                    d.this.ua();
                } else {
                    ArrayList arrayList2 = new ArrayList(d.this.amR);
                    if (d.this.amS + i <= arrayList2.size()) {
                        d.this.w(d.this.b(arrayList2.subList(i, d.this.amS + i), true));
                        d.h(d.this);
                        d.this.mHandler.postDelayed(d.this.amY, 250L);
                        return;
                    }
                    d.this.w(d.this.b(arrayList2.subList(i, arrayList2.size()), true));
                    d.h(d.this);
                    d.this.ua();
                }
            }
        };
        this.amZ = new CustomMessageListener(MessageConfig.SOCKET_RECEIVE_MSG) { // from class: com.baidu.live.im.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.tZ();
            }
        };
        this.ana = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.live.im.d.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        com.baidu.live.im.a aVar2 = new com.baidu.live.im.a();
                        aVar2.setMsgType(27);
                        aVar2.setContent(d.this.mPageContext.getString(a.i.sdk_im_offline));
                        d.this.mMsgList.add(aVar2);
                        if (d.this.amO != null) {
                            d.this.amO.g(aVar2);
                            d.this.amO.c(d.this.mMsgList, true);
                        }
                    } else if (((NetWorkChangedMessage) customResponsedMessage).mLastNetState == 0 && BdNetTypeUtil.isNetWorkAvailable()) {
                        com.baidu.live.im.a aVar3 = new com.baidu.live.im.a();
                        aVar3.setMsgType(27);
                        aVar3.setContent(d.this.mPageContext.getString(a.i.sdk_im_online));
                        d.this.mMsgList.add(aVar3);
                        if (d.this.amO != null) {
                            d.this.amO.g(aVar3);
                            d.this.amO.c(d.this.mMsgList, true);
                        }
                    }
                }
            }
        };
        this.anb = new Runnable() { // from class: com.baidu.live.im.d.8
            @Override // java.lang.Runnable
            public void run() {
                if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().getLastReceDataTime() > 35000) {
                    d.this.tY();
                }
                d.this.tX();
            }
        };
        this.anc = new HttpMessageListener(1021013) { // from class: com.baidu.live.im.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    if (!httpResponsedMessage.hasError()) {
                        if (d.this.amO != null) {
                            d.this.amO.ud();
                        }
                    } else if (httpResponsedMessage.getError() == 149010) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913070, httpResponsedMessage.getErrorString()));
                    } else {
                        BdUtilHelper.showToast(d.this.mPageContext.getPageActivity(), httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        this.and = new HttpMessageListener(1021015) { // from class: com.baidu.live.im.d.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                        if (orginalMessage instanceof com.baidu.live.gift.j) {
                            com.baidu.live.gift.j jVar = (com.baidu.live.gift.j) orginalMessage;
                            d.this.T(jVar.aeh, jVar.giftName);
                        }
                    }
                }
            }
        };
        this.ane = new HttpMessageListener(1021014) { // from class: com.baidu.live.im.d.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.hasError()) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof com.baidu.live.gift.o) {
                        com.baidu.live.gift.o oVar = (com.baidu.live.gift.o) orginalMessage;
                        d.this.T(oVar.aeh, oVar.giftName);
                    }
                }
            }
        };
        this.anf = new HttpMessageListener(1021012) { // from class: com.baidu.live.im.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                d.this.a((ResponsedMessage<?>) httpResponsedMessage, false);
            }
        };
        this.ang = new NetMessageListener(1021050, 601008) { // from class: com.baidu.live.im.d.3
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                JSONObject jSONObject;
                AlaGetLiveStatusHttpResponseMessage alaGetLiveStatusHttpResponseMessage = responsedMessage instanceof AlaGetLiveStatusHttpResponseMessage ? (AlaGetLiveStatusHttpResponseMessage) responsedMessage : null;
                if (alaGetLiveStatusHttpResponseMessage != null) {
                    try {
                        jSONObject = new JSONObject(alaGetLiveStatusHttpResponseMessage.arx);
                    } catch (JSONException e) {
                        jSONObject = null;
                    }
                    if (jSONObject != null) {
                        if (!"backstage_live".equals(jSONObject.optString("content_type"))) {
                            d.this.a(alaGetLiveStatusHttpResponseMessage.arx, jSONObject, 12, false);
                            return;
                        }
                        String optString = jSONObject.optString("backstage_type");
                        if (!TextUtils.isEmpty(optString) && !optString.equals(d.this.amW)) {
                            d.this.a(alaGetLiveStatusHttpResponseMessage.arx, jSONObject, 13, true);
                            d.this.amW = optString;
                        }
                    }
                }
            }
        };
        this.mPageContext = bdPageContext;
        this.amN = z;
        this.amO = aVar;
        this.mMsgList = new LinkedList<>();
        MessageManager.getInstance().registerTask(tW());
        com.baidu.live.tieba.f.a.a.a(1021050, "alaim/gmsg/getLiveStatus", AlaGetLiveStatusHttpResponseMessage.class, false, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021012, "alaim/gmsg/getGroupMsg", ALAGroupHttpResponseMessage.class, false, true, true, true);
    }

    public void d(com.baidu.live.data.k kVar) {
        this.aio = kVar;
    }

    private HttpMessageTask tW() {
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
        this.amP = str2;
        this.amQ = str3;
        this.mLiveId = str4;
        this.amW = "0";
        this.mAppId = str5;
        MessageManager.getInstance().registerListener(this.anf);
        MessageManager.getInstance().registerListener(this.ang);
        MessageManager.getInstance().registerListener(this.amZ);
        MessageManager.getInstance().registerListener(this.anc);
        MessageManager.getInstance().registerListener(this.ana);
        MessageManager.getInstance().registerListener(this.and);
        MessageManager.getInstance().registerListener(this.ane);
        if (BdSocketLinkService.isClose()) {
            tY();
            BdSocketLinkService.startService(true, "live start");
        }
        String str6 = com.baidu.live.r.a.wA().arE.WG;
        if (!TextUtils.isEmpty(str6)) {
            com.baidu.live.im.data.a uc = uc();
            uc.setMsgType(13);
            uc.setContent(str6);
            this.mMsgList.add(uc);
            if (this.amO != null) {
                this.amO.g(uc);
            }
        }
        String str7 = com.baidu.live.r.a.wA().arE.WH;
        if (!TextUtils.isEmpty(str7)) {
            com.baidu.live.im.data.a uc2 = uc();
            uc2.setMsgType(13);
            uc2.setContent(str7);
            this.mMsgList.add(uc2);
        }
        List<String> list = com.baidu.live.r.a.wA().arE.WF;
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
                    com.baidu.live.im.data.a uc3 = uc();
                    uc3.setMsgType(13);
                    uc3.setContent(str8);
                    uc3.setLink(str9);
                    this.mMsgList.add(uc3);
                    if (this.amO != null) {
                        this.amO.g(uc3);
                    }
                }
                i = i2 + 2;
            }
        }
        if (this.mMsgList.size() > 0) {
            this.amO.c(this.mMsgList, true);
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.d.7
            @Override // java.lang.Runnable
            public void run() {
                d.this.dw("enter");
            }
        }, 1000L);
        tX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tX() {
        this.mHandler.postDelayed(this.anb, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tY() {
        sendMessage(new com.baidu.live.im.message.b(JavaTypesHelper.toInt(this.mGroupId, 0), getLastMid()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tZ() {
        this.mHandler.removeCallbacks(this.anb);
    }

    public void T(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "1";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = this.mPageContext.getString(a.i.sdk_gift);
        }
        com.baidu.live.im.data.a a2 = a((short) 27, String.format(this.mPageContext.getString(a.i.sdk_send_gift_fail), str, str2), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), this.Wg);
        if (a2 != null) {
            this.mMsgList.add(a2);
            if (this.amO != null) {
                this.amO.g(a2);
                this.amO.c(this.mMsgList, true);
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
        if (this.amO != null) {
            this.amO.g(aVar);
            if (z) {
                this.amO.c(this.mMsgList, true);
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
            list = ((ALAGroupHttpResponseMessage) responsedMessage).vl();
            j = ((ALAGroupHttpResponseMessage) responsedMessage).getGroupId();
            z2 = ((ALAGroupHttpResponseMessage) responsedMessage).vk();
        }
        if (j == JavaTypesHelper.toLong(this.mGroupId, 0L) && list != null && !list.isEmpty()) {
            if (z2) {
                z(list);
            }
            v(list);
            if (this.amT != 0) {
                int i = this.amU * this.amS;
                ArrayList arrayList = new ArrayList(this.amR);
                list.addAll(0, arrayList.subList(i, arrayList.size()));
                ua();
            }
            if (list.size() > 0) {
                if (list.size() > 5 && z) {
                    x(list);
                } else {
                    w(a(list, z, z2));
                }
            }
        }
    }

    private void v(List<com.baidu.live.im.data.a> list) {
        String str;
        JSONObject jSONObject;
        LinkedList linkedList = new LinkedList();
        for (com.baidu.live.im.data.a aVar : list) {
            long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
            if (!ListUtils.isEmpty(aVar.vb()) && !aVar.vb().contains(Long.valueOf(currentAccountId))) {
                linkedList.add(aVar);
            } else {
                boolean z = aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                if (z && aVar.getMsgType() == 1 && !ListUtils.isEmpty(aVar.uZ().Vp) && this.Wg == null) {
                    this.Wg = aVar.uZ().Vp;
                }
                if (z && aVar.getMsgType() != 125 && aVar.getMsgType() != 24 && aVar.getMsgType() != 13 && aVar.getMsgType() != 28) {
                    linkedList.add(aVar);
                } else if (aVar.getMsgType() == 125) {
                    try {
                        if (!"1".equals(new JSONObject(aVar.getContent()).optString("is_first"))) {
                            linkedList.add(aVar);
                            if (this.amO != null) {
                                this.amO.g(aVar);
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
                        if (com.baidu.live.entereffect.a.pZ().a(aVar)) {
                            linkedList.add(aVar);
                            if (this.amO != null) {
                                this.amO.g(aVar);
                            }
                        }
                    } else if ("close_live".equals(str)) {
                        linkedList.add(aVar);
                        if (this.amO != null) {
                            this.amO.g(aVar);
                        }
                    } else if ("task".equals(str)) {
                        linkedList.add(aVar);
                        if (this.amO != null) {
                            this.amO.g(aVar);
                        }
                    } else if ("live_achievement".equals(str)) {
                        linkedList.add(aVar);
                        if (this.amO != null) {
                            this.amO.g(aVar);
                        }
                    } else if ("ss_hot_live".equals(str)) {
                        linkedList.add(aVar);
                        if (this.amO != null) {
                            this.amO.g(aVar);
                        }
                    } else if ("challenge_direct_new".equals(str)) {
                        linkedList.add(aVar);
                        if (this.amO != null) {
                            this.amO.g(aVar);
                        }
                    } else if ("update_liveinfo".equals(str)) {
                        linkedList.add(aVar);
                        if (this.amO != null) {
                            this.amO.g(aVar);
                        }
                    } else if (!"backstage_live".equals(str) && !"offline_type".equals(str) && !"follow_anchor".equals(str) && !com.baidu.tbadk.TbConfig.TMP_SHARE_DIR_NAME.equals(str) && !"share_tieba".equals(str) && !"remove_video".equals(str) && !"ueg_warn".equals(str)) {
                        if ("live_admin".equals(str)) {
                            if (z && !ListUtils.isEmpty(aVar.uZ().Vp)) {
                                this.Wg = aVar.uZ().Vp;
                                if (this.aio != null) {
                                    this.aio.Wg = this.Wg;
                                }
                            }
                        } else if (!"live_talk_ban".equals(str) && !"live_on_private".equals(str) && !"challenge_direct_matched".equals(str) && !"challenge_direct_start".equals(str) && !"challenge_random_matched".equals(str) && !"challenge_random_start".equals(str) && !TextUtils.equals(str, "share_rmb") && !TextUtils.equals(str, "zan_rmb") && !TextUtils.equals(str, "guard_club_join") && !TextUtils.equals(str, "send_redpacket") && !TextUtils.equals(str, "start_grab_redpacket")) {
                            if (TextUtils.equals(str, "guard_seat")) {
                                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                                    linkedList.add(aVar);
                                }
                            } else if (TextUtils.equals(str, "wish_list_finish") || TextUtils.equals(str, "wish_list_success")) {
                                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                                    linkedList.add(aVar);
                                }
                            } else if ("ui_event".equals(str)) {
                                linkedList.add(aVar);
                                if (this.amO != null) {
                                    this.amO.g(aVar);
                                }
                            } else if ("first_recharge_success".equals(str)) {
                                linkedList.add(aVar);
                                if (this.amO != null) {
                                    this.amO.g(aVar);
                                }
                            } else if ("privilege_award_success".equals(str)) {
                                linkedList.add(aVar);
                                if (this.amO != null) {
                                    this.amO.g(aVar);
                                }
                            } else if ("need_update_live_mark_info".equals(str)) {
                                linkedList.add(aVar);
                                if (this.amO != null) {
                                    this.amO.g(aVar);
                                }
                            } else {
                                linkedList.add(aVar);
                            }
                        }
                    }
                } else if (aVar.getMsgType() == 12) {
                    linkedList.add(aVar);
                    if (this.amO != null) {
                        this.amO.g(aVar);
                    }
                    dw("push");
                }
            }
        }
        if (linkedList.size() > 0) {
            list.removeAll(linkedList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(List<com.baidu.live.im.data.a> list) {
        if (list != null && this.amO != null) {
            this.amO.c(this.mMsgList, true);
            for (com.baidu.live.im.data.a aVar : list) {
                this.amO.g(aVar);
            }
        }
    }

    protected void x(List<com.baidu.live.im.data.a> list) {
        this.amR = list;
        this.amT = (int) ((this.amV * 2.0f) / 0.25f);
        this.amU = 0;
        this.amS = list.size() / this.amT;
        if (this.amS <= 0) {
            this.amS = 1;
        }
        this.mHandler.removeCallbacks(this.amY);
        this.mHandler.postDelayed(this.amY, 250L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ua() {
        this.mHandler.removeCallbacks(this.amY);
        this.amU = 0;
        this.amT = 0;
        this.amS = 0;
        this.amR = null;
    }

    protected List<com.baidu.live.im.data.a> b(List<com.baidu.live.im.data.a> list, boolean z) {
        return a(list, z, false);
    }

    protected List<com.baidu.live.im.data.a> a(List<com.baidu.live.im.data.a> list, boolean z, boolean z2) {
        for (com.baidu.live.im.data.a aVar : list) {
            if (aVar instanceof com.baidu.live.im.a) {
                ((com.baidu.live.im.a) aVar).dv(this.amQ);
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
                y(list);
            }
            if (z2 && this.mMsgList.size() > 2) {
                this.mMsgList.addAll(2, list);
            } else {
                this.mMsgList.addAll(list);
            }
        }
        if (this.mMsgList.size() > com.baidu.live.r.a.wA().arE.YG) {
            int i = (int) (com.baidu.live.r.a.wA().arE.YG * 0.7d);
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

    private void y(List<com.baidu.live.im.data.a> list) {
        boolean z;
        List<AlaLiveMarkData> list2;
        double aW = com.baidu.live.r.d.wH().aW(false);
        double aW2 = com.baidu.live.r.d.wH().aW(true);
        if ((aW > 0.0d || aW2 > 0.0d) && list != null && !list.isEmpty()) {
            for (com.baidu.live.im.data.a aVar : list) {
                if (aVar.getMsgType() == 24) {
                    com.baidu.live.data.a uZ = aVar.uZ();
                    if (uZ != null && (list2 = uZ.Vp) != null && !list2.isEmpty()) {
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
                            jSONObject.put("gift_rate", z ? aW2 : aW);
                            aVar.setObjContent(jSONObject);
                        } else {
                            JSONObject jSONObject2 = new JSONObject(aVar.getContent());
                            jSONObject2.put("gift_rate", z ? aW2 : aW);
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
                        if (!TextUtils.isEmpty(optString) && (optString.equals("challenge_direct_start") || optString.equals("challenge_direct_matched") || optString.equals("challenge_random_start") || optString.equals("challenge_random_matched") || optString.equals("live_net_status") || optString.equals("send_redpacket") || optString.equals("start_grab_redpacket") || optString.equals("guard_seat"))) {
                            it.remove();
                        }
                    } catch (JSONException e) {
                    }
                }
            }
        }
    }

    private void z(List<com.baidu.live.im.data.a> list) {
        if (list != null && !list.isEmpty()) {
            for (com.baidu.live.im.data.a aVar : list) {
                aVar.aR(true);
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
                    if (aVar != null && aVar.uZ() != null && !TextUtils.isEmpty(aVar.uZ().userId) && aVar.uZ().userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        int i2 = size2 - 1;
                        while (true) {
                            if (i2 >= 0 && i2 >= 0) {
                                com.baidu.live.im.data.a aVar2 = list2.get(i2);
                                if (aVar2 != null && aVar2.uZ() != null && !TextUtils.isEmpty(aVar2.uZ().userId) && aVar2.uZ().userId.equals(TbadkCoreApplication.getCurrentAccount()) && aVar2.getRecordId() == aVar.getRecordId()) {
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

    public void ub() {
        this.mGroupId = null;
        this.amP = null;
        this.mLiveId = null;
        this.amW = "0";
        this.mAppId = null;
        MessageManager.getInstance().unRegisterListener(this.ang);
        MessageManager.getInstance().unRegisterListener(this.anf);
        MessageManager.getInstance().unRegisterListener(this.amZ);
        MessageManager.getInstance().unRegisterListener(this.anc);
        MessageManager.getInstance().unRegisterListener(this.and);
        MessageManager.getInstance().unRegisterListener(this.ane);
        MessageManager.getInstance().unRegisterListener(this.ana);
        this.mHandler.removeCallbacks(this.amY);
        this.mHandler.removeCallbacks(this.anb);
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
            com.baidu.live.im.data.a a2 = a(s, str2, z, z2, i, this.Wg);
            if (s == 126) {
                a2.bK(imSendMsgData.barrageType);
                a2.dA(imSendMsgData.barrageId);
                a2.a(imSendMsgData.barrageCardInfo);
            }
            if (a2 != null) {
                a2.k(strArr);
                this.mMsgList.add(a2);
                if (this.amO != null) {
                    this.amO.g(a2);
                    this.amO.c(this.mMsgList, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913043));
                com.baidu.live.im.message.a aVar = new com.baidu.live.im.message.a(str2, s, JavaTypesHelper.toInt(this.mGroupId, 0), this.mAppId);
                if (this.aio != null && this.aio.mLiveInfo != null) {
                    aVar.dB(this.aio.mLiveInfo.live_id + "");
                    aVar.dC(this.aio.mLiveInfo.room_id + "");
                } else {
                    aVar.dB("");
                    aVar.dC("");
                }
                aVar.setOtherParams(str);
                aVar.C(imSendMsgData.price);
                aVar.bK(imSendMsgData.barrageType);
                aVar.dA(imSendMsgData.barrageId);
                aVar.a(imSendMsgData.barrageCardInfo);
                aVar.k(strArr);
                sendMessage(aVar);
            }
        }
    }

    protected com.baidu.live.im.data.a a(short s, String str, boolean z, boolean z2, int i, List<AlaLiveMarkData> list) {
        long j = 0;
        com.baidu.live.im.data.a uc = uc();
        if (uc == null) {
            return null;
        }
        uc.setMsgType(s);
        uc.setContent(str);
        long B = o.B(getLastMid());
        uc.setMsgId(B);
        uc.setRecordId(B);
        uc.setTime(System.currentTimeMillis() / 1000);
        com.baidu.live.data.a aVar = new com.baidu.live.data.a();
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            aVar.userName = TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow();
        }
        aVar.userId = TbadkCoreApplication.getCurrentAccount();
        aVar.portrait = TbadkCoreApplication.getCurrentPortrait();
        aVar.level_id = i;
        aVar.Vm = z;
        aVar.Vn = z2;
        if (list != null) {
            aVar.Vp = new ArrayList(list);
        }
        uc.b(aVar);
        try {
            j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        } catch (Exception e) {
        }
        uc.setUserId(j);
        return uc;
    }

    private long getLastMid() {
        if (this.mMsgList == null || this.mMsgList.size() <= 0) {
            return JavaTypesHelper.toLong(this.amP, 1L);
        }
        return this.mMsgList.get(this.mMsgList.size() - 1).getMsgId();
    }

    protected com.baidu.live.im.data.a uc() {
        com.baidu.live.im.a aVar = new com.baidu.live.im.a();
        aVar.setBornTime(System.currentTimeMillis());
        if (TextUtils.isEmpty(this.mGroupId)) {
            return null;
        }
        aVar.dv(this.amQ);
        return aVar;
    }

    public void A(List<AlaLiveMarkData> list) {
        this.Wg = list;
    }

    public void dw(String str) {
        com.baidu.live.message.c cVar = new com.baidu.live.message.c(JavaTypesHelper.toLong(this.mLiveId, 0L), str);
        cVar.setParams();
        sendMessage(cVar);
    }

    public void dx(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.amW)) {
            dw("getliveinfo");
        }
    }

    private List<com.baidu.live.im.data.a> f(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        int optInt;
        boolean qF;
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
            com.baidu.live.gift.g dd = s.dd(jSONObject.optString(LogConfig.LOG_GIFT_ID));
            qF = dd != null ? dd.qF() : false;
        } catch (JSONException e) {
            arrayList.add(aVar2);
        }
        if (optInt == 1 || qF) {
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
            aVar3.dv(aVar2.tU());
            aVar3.setBornTime(aVar2.getBornTime());
            aVar3.setTime(aVar2.getTime());
            aVar3.setUserId(aVar2.getUserId());
            aVar3.setToUserId(aVar2.getToUserId());
            aVar3.c(aVar2.va());
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
            aVar3.b(aVar2.uZ());
            aVar3.setSt_type(aVar2.getSt_type());
            arrayList.add(aVar3);
        }
        return arrayList;
    }

    public void a(int i, String str, com.baidu.live.data.a aVar) {
        com.baidu.live.im.data.a uc = uc();
        if (uc != null) {
            uc.setMsgType(i);
            uc.setContent(str);
            uc.b(aVar);
            this.mMsgList.add(uc);
            if (this.amO != null) {
                this.amO.c(this.mMsgList, true);
                this.amO.g(uc);
            }
        }
    }
}
