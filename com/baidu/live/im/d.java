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
import com.baidu.live.gift.q;
import com.baidu.live.im.b;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.message.ALAGroupCommitHttpResponsedMessage;
import com.baidu.live.im.message.ALAGroupHttpResponseMessage;
import com.baidu.live.k.a;
import com.baidu.live.message.AlaGetLiveStatusHttpResponseMessage;
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
/* loaded from: classes6.dex */
public class d extends BdBaseModel {
    private List<AlaLiveMarkData> Pl;
    private com.baidu.live.data.i aaj;
    private boolean aeL;
    private a aeM;
    private String aeN;
    private String aeO;
    private List<com.baidu.live.im.data.a> aeP;
    private int aeQ;
    private int aeR;
    private int aeS;
    private float aeT;
    private String aeU;
    private b.a aeV;
    private Runnable aeW;
    private CustomMessageListener aeX;
    private CustomMessageListener aeY;
    private Runnable aeZ;
    private HttpMessageListener afa;
    private HttpMessageListener afb;
    private HttpMessageListener afc;
    private HttpMessageListener afd;
    private NetMessageListener afe;
    private String mAppId;
    private String mGroupId;
    private Handler mHandler;
    private String mLiveId;
    private LinkedList<com.baidu.live.im.data.a> mMsgList;
    BdPageContext<?> mPageContext;

    /* loaded from: classes6.dex */
    public interface a {
        void d(List<com.baidu.live.im.data.a> list, boolean z);

        void g(com.baidu.live.im.data.a aVar);

        void sm();
    }

    static /* synthetic */ int h(d dVar) {
        int i = dVar.aeS;
        dVar.aeS = i + 1;
        return i;
    }

    public d(BdPageContext<?> bdPageContext, boolean z, a aVar) {
        super(bdPageContext);
        this.mLiveId = null;
        this.aeT = 1.0f;
        this.mHandler = new Handler();
        this.aeU = null;
        this.aeV = new b.a() { // from class: com.baidu.live.im.d.1
        };
        this.aeW = new Runnable() { // from class: com.baidu.live.im.d.4
            @Override // java.lang.Runnable
            public void run() {
                int i = d.this.aeS * d.this.aeQ;
                if (i >= d.this.aeP.size()) {
                    d.this.sj();
                } else if (d.this.aeS >= d.this.aeR - 1) {
                    if (d.this.aeS != d.this.aeR - 1) {
                        d.this.sj();
                        return;
                    }
                    ArrayList arrayList = new ArrayList(d.this.aeP);
                    d.this.x(d.this.c(arrayList.subList(i, arrayList.size()), true));
                    d.h(d.this);
                    d.this.sj();
                } else {
                    ArrayList arrayList2 = new ArrayList(d.this.aeP);
                    if (d.this.aeQ + i <= arrayList2.size()) {
                        d.this.x(d.this.c(arrayList2.subList(i, d.this.aeQ + i), true));
                        d.h(d.this);
                        d.this.mHandler.postDelayed(d.this.aeW, 250L);
                        return;
                    }
                    d.this.x(d.this.c(arrayList2.subList(i, arrayList2.size()), true));
                    d.h(d.this);
                    d.this.sj();
                }
            }
        };
        this.aeX = new CustomMessageListener(MessageConfig.SOCKET_RECEIVE_MSG) { // from class: com.baidu.live.im.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.si();
            }
        };
        this.aeY = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.live.im.d.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        com.baidu.live.im.a aVar2 = new com.baidu.live.im.a();
                        aVar2.setMsgType(27);
                        aVar2.setContent(d.this.mPageContext.getString(a.i.sdk_im_offline));
                        d.this.mMsgList.add(aVar2);
                        if (d.this.aeM != null) {
                            d.this.aeM.g(aVar2);
                            d.this.aeM.d(d.this.mMsgList, true);
                        }
                    } else if (((NetWorkChangedMessage) customResponsedMessage).mLastNetState == 0 && BdNetTypeUtil.isNetWorkAvailable()) {
                        com.baidu.live.im.a aVar3 = new com.baidu.live.im.a();
                        aVar3.setMsgType(27);
                        aVar3.setContent(d.this.mPageContext.getString(a.i.sdk_im_online));
                        d.this.mMsgList.add(aVar3);
                        if (d.this.aeM != null) {
                            d.this.aeM.g(aVar3);
                            d.this.aeM.d(d.this.mMsgList, true);
                        }
                    }
                }
            }
        };
        this.aeZ = new Runnable() { // from class: com.baidu.live.im.d.8
            @Override // java.lang.Runnable
            public void run() {
                if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().getLastReceDataTime() > 35000) {
                    d.this.sh();
                }
                d.this.sg();
            }
        };
        this.afa = new HttpMessageListener(1021013) { // from class: com.baidu.live.im.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    if (!httpResponsedMessage.hasError()) {
                        if (d.this.aeM != null) {
                            d.this.aeM.sm();
                        }
                    } else if (httpResponsedMessage.getError() == 149010) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913070, httpResponsedMessage.getErrorString()));
                    } else {
                        BdUtilHelper.showToast(d.this.mPageContext.getPageActivity(), httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        this.afb = new HttpMessageListener(1021015) { // from class: com.baidu.live.im.d.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                        if (orginalMessage instanceof com.baidu.live.gift.i) {
                            com.baidu.live.gift.i iVar = (com.baidu.live.gift.i) orginalMessage;
                            d.this.M(iVar.WC, iVar.giftName);
                        }
                    }
                }
            }
        };
        this.afc = new HttpMessageListener(1021014) { // from class: com.baidu.live.im.d.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.hasError()) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof com.baidu.live.gift.m) {
                        com.baidu.live.gift.m mVar = (com.baidu.live.gift.m) orginalMessage;
                        d.this.M(mVar.WC, mVar.giftName);
                    }
                }
            }
        };
        this.afd = new HttpMessageListener(1021012) { // from class: com.baidu.live.im.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                d.this.a((ResponsedMessage<?>) httpResponsedMessage, false);
            }
        };
        this.afe = new NetMessageListener(1021050, 601008) { // from class: com.baidu.live.im.d.3
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                JSONObject jSONObject;
                AlaGetLiveStatusHttpResponseMessage alaGetLiveStatusHttpResponseMessage = responsedMessage instanceof AlaGetLiveStatusHttpResponseMessage ? (AlaGetLiveStatusHttpResponseMessage) responsedMessage : null;
                if (alaGetLiveStatusHttpResponseMessage != null) {
                    try {
                        jSONObject = new JSONObject(alaGetLiveStatusHttpResponseMessage.ajx);
                    } catch (JSONException e) {
                        jSONObject = null;
                    }
                    if (jSONObject != null) {
                        if (!"backstage_live".equals(jSONObject.optString("content_type"))) {
                            d.this.a(alaGetLiveStatusHttpResponseMessage.ajx, jSONObject, 12, false);
                            return;
                        }
                        String optString = jSONObject.optString("backstage_type");
                        if (!TextUtils.isEmpty(optString) && !optString.equals(d.this.aeU)) {
                            d.this.a(alaGetLiveStatusHttpResponseMessage.ajx, jSONObject, 13, true);
                            d.this.aeU = optString;
                        }
                    }
                }
            }
        };
        this.mPageContext = bdPageContext;
        this.aeL = z;
        this.aeM = aVar;
        this.mMsgList = new LinkedList<>();
        MessageManager.getInstance().registerTask(sf());
        com.baidu.live.tieba.f.a.a.a(1021050, "alaim/gmsg/getLiveStatus", AlaGetLiveStatusHttpResponseMessage.class, false, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021012, "alaim/gmsg/getGroupMsg", ALAGroupHttpResponseMessage.class, false, true, true, true);
    }

    public void d(com.baidu.live.data.i iVar) {
        this.aaj = iVar;
    }

    private HttpMessageTask sf() {
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
        this.aeN = str2;
        this.aeO = str3;
        this.mLiveId = str4;
        this.aeU = "0";
        this.mAppId = str5;
        MessageManager.getInstance().registerListener(this.afd);
        MessageManager.getInstance().registerListener(this.afe);
        MessageManager.getInstance().registerListener(this.aeX);
        MessageManager.getInstance().registerListener(this.afa);
        MessageManager.getInstance().registerListener(this.aeY);
        MessageManager.getInstance().registerListener(this.afb);
        MessageManager.getInstance().registerListener(this.afc);
        if (BdSocketLinkService.isClose()) {
            sh();
            BdSocketLinkService.startService(true, "live start");
        }
        String str6 = com.baidu.live.l.a.uB().ajF.PP;
        if (!TextUtils.isEmpty(str6)) {
            com.baidu.live.im.data.a sl = sl();
            sl.setMsgType(13);
            sl.setContent(str6);
            this.mMsgList.add(sl);
            if (this.aeM != null) {
                this.aeM.g(sl);
            }
        }
        String str7 = com.baidu.live.l.a.uB().ajF.PQ;
        if (!TextUtils.isEmpty(str7)) {
            com.baidu.live.im.data.a sl2 = sl();
            sl2.setMsgType(13);
            sl2.setContent(str7);
            this.mMsgList.add(sl2);
        }
        List<String> list = com.baidu.live.l.a.uB().ajF.PO;
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
                    com.baidu.live.im.data.a sl3 = sl();
                    sl3.setMsgType(13);
                    sl3.setContent(str8);
                    sl3.setLink(str9);
                    this.mMsgList.add(sl3);
                    if (this.aeM != null) {
                        this.aeM.g(sl3);
                    }
                }
                i = i2 + 2;
            }
        }
        if (this.mMsgList.size() > 0) {
            this.aeM.d(this.mMsgList, true);
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.d.7
            @Override // java.lang.Runnable
            public void run() {
                d.this.cE("enter");
            }
        }, 1000L);
        sg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sg() {
        this.mHandler.postDelayed(this.aeZ, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sh() {
        sendMessage(new com.baidu.live.im.message.b(JavaTypesHelper.toInt(this.mGroupId, 0), getLastMid()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void si() {
        this.mHandler.removeCallbacks(this.aeZ);
    }

    public void M(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "1";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = this.mPageContext.getString(a.i.sdk_gift);
        }
        com.baidu.live.im.data.a a2 = a((short) 27, String.format(this.mPageContext.getString(a.i.sdk_send_gift_fail), str, str2), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), this.Pl);
        if (a2 != null) {
            this.mMsgList.add(a2);
            if (this.aeM != null) {
                this.aeM.g(a2);
                this.aeM.d(this.mMsgList, true);
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
        if (this.aeM != null) {
            this.aeM.g(aVar);
            if (z) {
                this.aeM.d(this.mMsgList, true);
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
            list = ((ALAGroupHttpResponseMessage) responsedMessage).tr();
            j = ((ALAGroupHttpResponseMessage) responsedMessage).getGroupId();
            z2 = ((ALAGroupHttpResponseMessage) responsedMessage).tq();
        }
        if (j == JavaTypesHelper.toLong(this.mGroupId, 0L) && list != null && !list.isEmpty()) {
            if (z2) {
                B(list);
            }
            w(list);
            if (this.aeR != 0) {
                int i = this.aeS * this.aeQ;
                ArrayList arrayList = new ArrayList(this.aeP);
                list.addAll(0, arrayList.subList(i, arrayList.size()));
                sj();
            }
            if (list.size() > 0) {
                if (list.size() > 5 && z) {
                    y(list);
                } else {
                    x(a(list, z, z2));
                }
            }
        }
    }

    private void w(List<com.baidu.live.im.data.a> list) {
        String str;
        JSONObject jSONObject;
        LinkedList linkedList = new LinkedList();
        for (com.baidu.live.im.data.a aVar : list) {
            long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
            if (!ListUtils.isEmpty(aVar.th()) && !aVar.th().contains(Long.valueOf(currentAccountId))) {
                linkedList.add(aVar);
            } else {
                boolean z = aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                if (z && aVar.getMsgType() == 1 && !ListUtils.isEmpty(aVar.tf().Op) && this.Pl == null) {
                    this.Pl = aVar.tf().Op;
                }
                if (z && aVar.getMsgType() != 125 && aVar.getMsgType() != 24 && aVar.getMsgType() != 13 && aVar.getMsgType() != 28) {
                    linkedList.add(aVar);
                } else if (aVar.getMsgType() == 125) {
                    try {
                        if (!"1".equals(new JSONObject(aVar.getContent()).optString("is_first"))) {
                            linkedList.add(aVar);
                            if (this.aeM != null) {
                                this.aeM.g(aVar);
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
                        if (com.baidu.live.entereffect.a.oF().a(aVar)) {
                            linkedList.add(aVar);
                            if (this.aeM != null) {
                                this.aeM.g(aVar);
                            }
                        }
                    } else if ("close_live".equals(str)) {
                        linkedList.add(aVar);
                        if (this.aeM != null) {
                            this.aeM.g(aVar);
                        }
                    } else if ("task".equals(str)) {
                        linkedList.add(aVar);
                        if (this.aeM != null) {
                            this.aeM.g(aVar);
                        }
                    } else if ("live_achievement".equals(str)) {
                        linkedList.add(aVar);
                        if (this.aeM != null) {
                            this.aeM.g(aVar);
                        }
                    } else if ("ss_hot_live".equals(str)) {
                        linkedList.add(aVar);
                        if (this.aeM != null) {
                            this.aeM.g(aVar);
                        }
                    } else if ("challenge_direct_new".equals(str)) {
                        linkedList.add(aVar);
                        if (this.aeM != null) {
                            this.aeM.g(aVar);
                        }
                    } else if ("update_liveinfo".equals(str)) {
                        linkedList.add(aVar);
                        if (this.aeM != null) {
                            this.aeM.g(aVar);
                        }
                    } else if (!"backstage_live".equals(str) && !"offline_type".equals(str) && !"follow_anchor".equals(str) && !com.baidu.tbadk.TbConfig.TMP_SHARE_DIR_NAME.equals(str) && !"share_tieba".equals(str) && !"remove_video".equals(str) && !"ueg_warn".equals(str)) {
                        if ("live_admin".equals(str)) {
                            if (z && !ListUtils.isEmpty(aVar.tf().Op)) {
                                this.Pl = aVar.tf().Op;
                                if (this.aaj != null) {
                                    this.aaj.Pl = this.Pl;
                                }
                            }
                        } else if (!"live_talk_ban".equals(str) && !"live_on_private".equals(str) && !"challenge_direct_matched".equals(str) && !"challenge_direct_start".equals(str) && !"challenge_random_matched".equals(str) && !"challenge_random_start".equals(str) && !TextUtils.equals(str, "share_rmb") && !TextUtils.equals(str, "zan_rmb") && !TextUtils.equals(str, "guard_club_join")) {
                            if ("ui_event".equals(str)) {
                                linkedList.add(aVar);
                                if (this.aeM != null) {
                                    this.aeM.g(aVar);
                                }
                            } else if ("first_recharge_success".equals(str)) {
                                linkedList.add(aVar);
                                if (this.aeM != null) {
                                    this.aeM.g(aVar);
                                }
                            } else if ("need_update_live_mark_info".equals(str)) {
                                linkedList.add(aVar);
                                if (this.aeM != null) {
                                    this.aeM.g(aVar);
                                }
                            } else {
                                linkedList.add(aVar);
                            }
                        }
                    }
                } else if (aVar.getMsgType() == 12) {
                    linkedList.add(aVar);
                    if (this.aeM != null) {
                        this.aeM.g(aVar);
                    }
                    cE("push");
                }
            }
        }
        if (linkedList.size() > 0) {
            list.removeAll(linkedList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(List<com.baidu.live.im.data.a> list) {
        if (list != null && this.aeM != null) {
            this.aeM.d(this.mMsgList, true);
            for (com.baidu.live.im.data.a aVar : list) {
                this.aeM.g(aVar);
            }
        }
    }

    protected void y(List<com.baidu.live.im.data.a> list) {
        this.aeP = list;
        this.aeR = (int) ((this.aeT * 2.0f) / 0.25f);
        this.aeS = 0;
        this.aeQ = list.size() / this.aeR;
        if (this.aeQ <= 0) {
            this.aeQ = 1;
        }
        this.mHandler.removeCallbacks(this.aeW);
        this.mHandler.postDelayed(this.aeW, 250L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sj() {
        this.mHandler.removeCallbacks(this.aeW);
        this.aeS = 0;
        this.aeR = 0;
        this.aeQ = 0;
        this.aeP = null;
    }

    protected List<com.baidu.live.im.data.a> c(List<com.baidu.live.im.data.a> list, boolean z) {
        return a(list, z, false);
    }

    protected List<com.baidu.live.im.data.a> a(List<com.baidu.live.im.data.a> list, boolean z, boolean z2) {
        for (com.baidu.live.im.data.a aVar : list) {
            if (aVar instanceof com.baidu.live.im.a) {
                ((com.baidu.live.im.a) aVar).cD(this.aeO);
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
                z(list);
            }
            if (z2 && this.mMsgList.size() > 2) {
                A(list);
                this.mMsgList.addAll(2, list);
            } else {
                this.mMsgList.addAll(list);
            }
        }
        int size = this.mMsgList.size();
        if (size > com.baidu.live.l.a.uB().ajF.RU) {
            int i = (int) (size * 0.7d);
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

    private void z(List<com.baidu.live.im.data.a> list) {
        boolean z;
        List<AlaLiveMarkData> list2;
        double aF = com.baidu.live.l.d.uJ().aF(false);
        double aF2 = com.baidu.live.l.d.uJ().aF(true);
        if ((aF > 0.0d || aF2 > 0.0d) && list != null && !list.isEmpty()) {
            for (com.baidu.live.im.data.a aVar : list) {
                if (aVar.getMsgType() == 24) {
                    com.baidu.live.data.a tf = aVar.tf();
                    if (tf != null && (list2 = tf.Op) != null && !list2.isEmpty()) {
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
                            jSONObject.put("gift_rate", z ? aF2 : aF);
                            aVar.setObjContent(jSONObject);
                        } else {
                            JSONObject jSONObject2 = new JSONObject(aVar.getContent());
                            jSONObject2.put("gift_rate", z ? aF2 : aF);
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
                        if (!TextUtils.isEmpty(optString) && (optString.equals("challenge_direct_start") || optString.equals("challenge_direct_matched") || optString.equals("challenge_random_start") || optString.equals("challenge_random_matched"))) {
                            it.remove();
                        }
                    } catch (JSONException e) {
                    }
                }
            }
        }
    }

    private void A(List<com.baidu.live.im.data.a> list) {
        JSONObject jSONObject;
        if (list != null && !list.isEmpty()) {
            Iterator<com.baidu.live.im.data.a> it = list.iterator();
            while (it.hasNext()) {
                com.baidu.live.im.data.a next = it.next();
                if (next.getMsgType() == 13 || next.getMsgType() == 12) {
                    try {
                        if (next.getObjContent() instanceof JSONObject) {
                            jSONObject = (JSONObject) next.getObjContent();
                        } else {
                            jSONObject = new JSONObject(next.getContent());
                        }
                    } catch (JSONException e) {
                        jSONObject = null;
                    }
                    if (jSONObject != null && jSONObject.optString("content_type").equals("live_net_status")) {
                        it.remove();
                    }
                }
            }
        }
    }

    private void B(List<com.baidu.live.im.data.a> list) {
        if (list != null && !list.isEmpty()) {
            for (com.baidu.live.im.data.a aVar : list) {
                aVar.aA(true);
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
                    if (aVar != null && aVar.tf() != null && !TextUtils.isEmpty(aVar.tf().userId) && aVar.tf().userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        int i2 = size2 - 1;
                        while (true) {
                            if (i2 >= 0 && i2 >= 0) {
                                com.baidu.live.im.data.a aVar2 = list2.get(i2);
                                if (aVar2 != null && aVar2.tf() != null && !TextUtils.isEmpty(aVar2.tf().userId) && aVar2.tf().userId.equals(TbadkCoreApplication.getCurrentAccount()) && aVar2.getRecordId() == aVar.getRecordId()) {
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

    public void sk() {
        this.mGroupId = null;
        this.aeN = null;
        this.mLiveId = null;
        this.aeU = "0";
        this.mAppId = null;
        MessageManager.getInstance().unRegisterListener(this.afe);
        MessageManager.getInstance().unRegisterListener(this.afd);
        MessageManager.getInstance().unRegisterListener(this.aeX);
        MessageManager.getInstance().unRegisterListener(this.afa);
        MessageManager.getInstance().unRegisterListener(this.afb);
        MessageManager.getInstance().unRegisterListener(this.afc);
        MessageManager.getInstance().unRegisterListener(this.aeY);
        this.mHandler.removeCallbacks(this.aeW);
        this.mHandler.removeCallbacks(this.aeZ);
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
            com.baidu.live.im.data.a a2 = a(s, str2, z, z2, i, this.Pl);
            if (s == 126) {
                a2.cJ(imSendMsgData.barrageId);
                a2.a(imSendMsgData.barrageCardInfo);
            }
            if (a2 != null) {
                a2.k(strArr);
                this.mMsgList.add(a2);
                if (this.aeM != null) {
                    this.aeM.g(a2);
                    this.aeM.d(this.mMsgList, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913043));
                com.baidu.live.im.message.a aVar = new com.baidu.live.im.message.a(str2, s, JavaTypesHelper.toInt(this.mGroupId, 0), this.mAppId);
                if (this.aaj != null && this.aaj.mLiveInfo != null) {
                    aVar.cK(this.aaj.mLiveInfo.live_id + "");
                    aVar.cL(this.aaj.mLiveInfo.room_id + "");
                } else {
                    aVar.cK("");
                    aVar.cL("");
                }
                aVar.setOtherParams(str);
                aVar.A(imSendMsgData.price);
                aVar.cJ(imSendMsgData.barrageId);
                aVar.a(imSendMsgData.barrageCardInfo);
                aVar.k(strArr);
                sendMessage(aVar);
            }
        }
    }

    protected com.baidu.live.im.data.a a(short s, String str, boolean z, boolean z2, int i, List<AlaLiveMarkData> list) {
        long j = 0;
        com.baidu.live.im.data.a sl = sl();
        if (sl == null) {
            return null;
        }
        sl.setMsgType(s);
        sl.setContent(str);
        long z3 = o.z(getLastMid());
        sl.setMsgId(z3);
        sl.setRecordId(z3);
        sl.setTime(System.currentTimeMillis() / 1000);
        com.baidu.live.data.a aVar = new com.baidu.live.data.a();
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            aVar.userName = TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow();
        }
        aVar.userId = TbadkCoreApplication.getCurrentAccount();
        aVar.portrait = TbadkCoreApplication.getCurrentPortrait();
        aVar.level_id = i;
        aVar.Om = z;
        aVar.On = z2;
        if (list != null) {
            aVar.Op = new ArrayList(list);
        }
        sl.b(aVar);
        try {
            j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        } catch (Exception e) {
        }
        sl.setUserId(j);
        return sl;
    }

    private long getLastMid() {
        if (this.mMsgList == null || this.mMsgList.size() <= 0) {
            return JavaTypesHelper.toLong(this.aeN, 1L);
        }
        return this.mMsgList.get(this.mMsgList.size() - 1).getMsgId();
    }

    protected com.baidu.live.im.data.a sl() {
        com.baidu.live.im.a aVar = new com.baidu.live.im.a();
        aVar.setBornTime(System.currentTimeMillis());
        if (TextUtils.isEmpty(this.mGroupId)) {
            return null;
        }
        aVar.cD(this.aeO);
        return aVar;
    }

    public void C(List<AlaLiveMarkData> list) {
        this.Pl = list;
    }

    public void cE(String str) {
        com.baidu.live.message.b bVar = new com.baidu.live.message.b(JavaTypesHelper.toLong(this.mLiveId, 0L), str);
        bVar.setParams();
        sendMessage(bVar);
    }

    public void cF(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.aeU)) {
            cE("getliveinfo");
        }
    }

    private List<com.baidu.live.im.data.a> f(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        int optInt;
        boolean pk;
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
            com.baidu.live.gift.g cl = q.cl(jSONObject.optString(LogConfig.LOG_GIFT_ID));
            pk = cl != null ? cl.pk() : false;
        } catch (JSONException e) {
            arrayList.add(aVar2);
        }
        if (optInt == 1 || pk) {
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
            aVar3.cD(aVar2.sd());
            aVar3.setBornTime(aVar2.getBornTime());
            aVar3.setTime(aVar2.getTime());
            aVar3.setUserId(aVar2.getUserId());
            aVar3.setToUserId(aVar2.getToUserId());
            aVar3.c(aVar2.tg());
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
            aVar3.b(aVar2.tf());
            aVar3.setSt_type(aVar2.getSt_type());
            arrayList.add(aVar3);
        }
        return arrayList;
    }

    public void a(int i, String str, com.baidu.live.data.a aVar) {
        com.baidu.live.im.data.a sl = sl();
        if (sl != null) {
            sl.setMsgType(i);
            sl.setContent(str);
            sl.b(aVar);
            this.mMsgList.add(sl);
            if (this.aeM != null) {
                this.aeM.d(this.mMsgList, true);
                this.aeM.g(sl);
            }
        }
    }
}
