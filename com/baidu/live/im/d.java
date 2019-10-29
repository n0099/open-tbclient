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
    private List<AlaLiveMarkData> PP;
    private List<com.baidu.live.im.data.a> Wc;
    private com.baidu.live.data.i aaB;
    private boolean afd;
    private a afe;
    private String aff;
    private String afg;
    private List<com.baidu.live.im.data.a> afh;
    private int afi;
    private int afj;
    private int afk;
    private float afl;
    private String afm;
    private b.a afn;
    private Runnable afo;
    private CustomMessageListener afp;
    private CustomMessageListener afq;
    private Runnable afr;
    private HttpMessageListener afs;
    private HttpMessageListener aft;
    private HttpMessageListener afu;
    private HttpMessageListener afv;
    private NetMessageListener afw;
    private String mAppId;
    private String mGroupId;
    private Handler mHandler;
    private String mLiveId;
    BdPageContext<?> mPageContext;

    /* loaded from: classes6.dex */
    public interface a {
        void d(List<com.baidu.live.im.data.a> list, boolean z);

        void f(com.baidu.live.im.data.a aVar);

        void sl();
    }

    static /* synthetic */ int h(d dVar) {
        int i = dVar.afk;
        dVar.afk = i + 1;
        return i;
    }

    public d(BdPageContext<?> bdPageContext, boolean z, a aVar) {
        super(bdPageContext);
        this.mLiveId = null;
        this.afl = 1.0f;
        this.mHandler = new Handler();
        this.afm = null;
        this.afn = new b.a() { // from class: com.baidu.live.im.d.1
        };
        this.afo = new Runnable() { // from class: com.baidu.live.im.d.4
            @Override // java.lang.Runnable
            public void run() {
                int i = d.this.afk * d.this.afi;
                if (i >= d.this.afh.size()) {
                    d.this.si();
                } else if (d.this.afk >= d.this.afj - 1) {
                    if (d.this.afk != d.this.afj - 1) {
                        d.this.si();
                        return;
                    }
                    ArrayList arrayList = new ArrayList(d.this.afh);
                    d.this.x(d.this.c(arrayList.subList(i, arrayList.size()), true));
                    d.h(d.this);
                    d.this.si();
                } else {
                    ArrayList arrayList2 = new ArrayList(d.this.afh);
                    if (d.this.afi + i <= arrayList2.size()) {
                        d.this.x(d.this.c(arrayList2.subList(i, d.this.afi + i), true));
                        d.h(d.this);
                        d.this.mHandler.postDelayed(d.this.afo, 250L);
                        return;
                    }
                    d.this.x(d.this.c(arrayList2.subList(i, arrayList2.size()), true));
                    d.h(d.this);
                    d.this.si();
                }
            }
        };
        this.afp = new CustomMessageListener(MessageConfig.SOCKET_RECEIVE_MSG) { // from class: com.baidu.live.im.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.sh();
            }
        };
        this.afq = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.live.im.d.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        com.baidu.live.im.a aVar2 = new com.baidu.live.im.a();
                        aVar2.setMsgType(27);
                        aVar2.setContent(d.this.mPageContext.getString(a.i.sdk_im_offline));
                        d.this.Wc.add(aVar2);
                        if (d.this.afe != null) {
                            d.this.afe.f(aVar2);
                            d.this.afe.d(d.this.Wc, true);
                        }
                    } else if (((NetWorkChangedMessage) customResponsedMessage).mLastNetState == 0 && BdNetTypeUtil.isNetWorkAvailable()) {
                        com.baidu.live.im.a aVar3 = new com.baidu.live.im.a();
                        aVar3.setMsgType(27);
                        aVar3.setContent(d.this.mPageContext.getString(a.i.sdk_im_online));
                        d.this.Wc.add(aVar3);
                        if (d.this.afe != null) {
                            d.this.afe.f(aVar3);
                            d.this.afe.d(d.this.Wc, true);
                        }
                    }
                }
            }
        };
        this.afr = new Runnable() { // from class: com.baidu.live.im.d.8
            @Override // java.lang.Runnable
            public void run() {
                if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().getLastReceDataTime() > 35000) {
                    d.this.sg();
                }
                d.this.sf();
            }
        };
        this.afs = new HttpMessageListener(1021013) { // from class: com.baidu.live.im.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    if (!httpResponsedMessage.hasError()) {
                        if (d.this.afe != null) {
                            d.this.afe.sl();
                        }
                    } else if (httpResponsedMessage.getError() == 149010) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913070, httpResponsedMessage.getErrorString()));
                    } else {
                        BdUtilHelper.showToast(d.this.mPageContext.getPageActivity(), httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        this.aft = new HttpMessageListener(1021015) { // from class: com.baidu.live.im.d.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                        if (orginalMessage instanceof com.baidu.live.gift.i) {
                            com.baidu.live.gift.i iVar = (com.baidu.live.gift.i) orginalMessage;
                            d.this.M(iVar.WV, iVar.giftName);
                        }
                    }
                }
            }
        };
        this.afu = new HttpMessageListener(1021014) { // from class: com.baidu.live.im.d.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.hasError()) {
                    Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                    if (orginalMessage instanceof com.baidu.live.gift.m) {
                        com.baidu.live.gift.m mVar = (com.baidu.live.gift.m) orginalMessage;
                        d.this.M(mVar.WV, mVar.giftName);
                    }
                }
            }
        };
        this.afv = new HttpMessageListener(1021012) { // from class: com.baidu.live.im.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                d.this.a((ResponsedMessage<?>) httpResponsedMessage, false);
            }
        };
        this.afw = new NetMessageListener(1021050, 601008) { // from class: com.baidu.live.im.d.3
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                JSONObject jSONObject;
                AlaGetLiveStatusHttpResponseMessage alaGetLiveStatusHttpResponseMessage = responsedMessage instanceof AlaGetLiveStatusHttpResponseMessage ? (AlaGetLiveStatusHttpResponseMessage) responsedMessage : null;
                if (alaGetLiveStatusHttpResponseMessage != null) {
                    try {
                        jSONObject = new JSONObject(alaGetLiveStatusHttpResponseMessage.ajP);
                    } catch (JSONException e) {
                        jSONObject = null;
                    }
                    if (jSONObject != null) {
                        if (!"backstage_live".equals(jSONObject.optString("content_type"))) {
                            d.this.a(alaGetLiveStatusHttpResponseMessage.ajP, jSONObject, 12, false);
                            return;
                        }
                        String optString = jSONObject.optString("backstage_type");
                        if (!TextUtils.isEmpty(optString) && !optString.equals(d.this.afm)) {
                            d.this.a(alaGetLiveStatusHttpResponseMessage.ajP, jSONObject, 13, true);
                            d.this.afm = optString;
                        }
                    }
                }
            }
        };
        this.mPageContext = bdPageContext;
        this.afd = z;
        this.afe = aVar;
        this.Wc = new LinkedList();
        MessageManager.getInstance().registerTask(se());
        com.baidu.live.tieba.f.a.a.a(1021050, "alaim/gmsg/getLiveStatus", AlaGetLiveStatusHttpResponseMessage.class, false, true, true, true);
        com.baidu.live.tieba.f.a.a.a(1021012, "alaim/gmsg/getGroupMsg", ALAGroupHttpResponseMessage.class, false, true, true, true);
    }

    public void d(com.baidu.live.data.i iVar) {
        this.aaB = iVar;
    }

    private HttpMessageTask se() {
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
        if (this.Wc != null) {
            this.Wc.clear();
        }
        this.Wc = new LinkedList();
        this.mGroupId = str;
        this.aff = str2;
        this.afg = str3;
        this.mLiveId = str4;
        this.afm = "0";
        this.mAppId = str5;
        MessageManager.getInstance().registerListener(this.afv);
        MessageManager.getInstance().registerListener(this.afw);
        MessageManager.getInstance().registerListener(this.afp);
        MessageManager.getInstance().registerListener(this.afs);
        MessageManager.getInstance().registerListener(this.afq);
        MessageManager.getInstance().registerListener(this.aft);
        MessageManager.getInstance().registerListener(this.afu);
        if (BdSocketLinkService.isClose()) {
            sg();
            BdSocketLinkService.startService(true, "live start");
        }
        String str6 = com.baidu.live.l.a.uA().ajX.Qr;
        if (!TextUtils.isEmpty(str6)) {
            com.baidu.live.im.data.a sk = sk();
            sk.setMsgType(13);
            sk.setContent(str6);
            this.Wc.add(sk);
            if (this.afe != null) {
                this.afe.f(sk);
            }
        }
        String str7 = com.baidu.live.l.a.uA().ajX.Qs;
        if (!TextUtils.isEmpty(str7)) {
            com.baidu.live.im.data.a sk2 = sk();
            sk2.setMsgType(13);
            sk2.setContent(str7);
            this.Wc.add(sk2);
        }
        List<String> list = com.baidu.live.l.a.uA().ajX.Qq;
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
                    com.baidu.live.im.data.a sk3 = sk();
                    sk3.setMsgType(13);
                    sk3.setContent(str8);
                    sk3.setLink(str9);
                    this.Wc.add(sk3);
                    if (this.afe != null) {
                        this.afe.f(sk3);
                    }
                }
                i = i2 + 2;
            }
        }
        if (this.Wc.size() > 0) {
            this.afe.d(this.Wc, true);
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.live.im.d.7
            @Override // java.lang.Runnable
            public void run() {
                d.this.cE("enter");
            }
        }, 1000L);
        sf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sf() {
        this.mHandler.postDelayed(this.afr, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sg() {
        sendMessage(new com.baidu.live.im.message.b(JavaTypesHelper.toInt(this.mGroupId, 0), getLastMid()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sh() {
        this.mHandler.removeCallbacks(this.afr);
    }

    public void M(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "1";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = this.mPageContext.getString(a.i.sdk_gift);
        }
        com.baidu.live.im.data.a a2 = a((short) 27, String.format(this.mPageContext.getString(a.i.sdk_send_gift_fail), str, str2), false, false, TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel(), this.PP);
        if (a2 != null) {
            this.Wc.add(a2);
            if (this.afe != null) {
                this.afe.f(a2);
                this.afe.d(this.Wc, true);
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
            this.Wc.add(aVar);
        }
        if (this.afe != null) {
            this.afe.f(aVar);
            if (z) {
                this.afe.d(this.Wc, true);
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
            list = ((ALAGroupHttpResponseMessage) responsedMessage).tq();
            j = ((ALAGroupHttpResponseMessage) responsedMessage).getGroupId();
            z2 = ((ALAGroupHttpResponseMessage) responsedMessage).tp();
        }
        if (j == JavaTypesHelper.toLong(this.mGroupId, 0L) && list != null && !list.isEmpty()) {
            if (z2) {
                A(list);
            }
            w(list);
            if (this.afj != 0) {
                int i = this.afk * this.afi;
                ArrayList arrayList = new ArrayList(this.afh);
                list.addAll(0, arrayList.subList(i, arrayList.size()));
                si();
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
            if (!ListUtils.isEmpty(aVar.tg()) && !aVar.tg().contains(Long.valueOf(currentAccountId))) {
                linkedList.add(aVar);
            } else {
                boolean z = aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                if (z && aVar.getMsgType() == 1 && !ListUtils.isEmpty(aVar.te().OR) && this.PP == null) {
                    this.PP = aVar.te().OR;
                }
                if (z && aVar.getMsgType() != 125 && aVar.getMsgType() != 24 && aVar.getMsgType() != 13 && aVar.getMsgType() != 28) {
                    linkedList.add(aVar);
                } else if (aVar.getMsgType() == 125) {
                    try {
                        if (!"1".equals(new JSONObject(aVar.getContent()).optString("is_first"))) {
                            linkedList.add(aVar);
                            if (this.afe != null) {
                                this.afe.f(aVar);
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
                            if (this.afe != null) {
                                this.afe.f(aVar);
                            }
                        }
                    } else if ("close_live".equals(str)) {
                        linkedList.add(aVar);
                        if (this.afe != null) {
                            this.afe.f(aVar);
                        }
                    } else if ("task".equals(str)) {
                        linkedList.add(aVar);
                        if (this.afe != null) {
                            this.afe.f(aVar);
                        }
                    } else if ("live_achievement".equals(str)) {
                        linkedList.add(aVar);
                        if (this.afe != null) {
                            this.afe.f(aVar);
                        }
                    } else if ("ss_hot_live".equals(str)) {
                        linkedList.add(aVar);
                        if (this.afe != null) {
                            this.afe.f(aVar);
                        }
                    } else if ("challenge_direct_new".equals(str)) {
                        linkedList.add(aVar);
                        if (this.afe != null) {
                            this.afe.f(aVar);
                        }
                    } else if ("update_liveinfo".equals(str)) {
                        linkedList.add(aVar);
                        if (this.afe != null) {
                            this.afe.f(aVar);
                        }
                    } else if (!"backstage_live".equals(str) && !"offline_type".equals(str) && !"follow_anchor".equals(str) && !com.baidu.tbadk.TbConfig.TMP_SHARE_DIR_NAME.equals(str) && !"share_tieba".equals(str) && !"remove_video".equals(str) && !"ueg_warn".equals(str)) {
                        if ("live_admin".equals(str)) {
                            if (z && !ListUtils.isEmpty(aVar.te().OR)) {
                                this.PP = aVar.te().OR;
                                if (this.aaB != null) {
                                    this.aaB.PP = this.PP;
                                }
                            }
                        } else if (!"live_talk_ban".equals(str) && !"live_on_private".equals(str) && !"challenge_direct_matched".equals(str) && !"challenge_direct_start".equals(str) && !"challenge_random_matched".equals(str) && !"challenge_random_start".equals(str) && !TextUtils.equals(str, "share_rmb") && !TextUtils.equals(str, "zan_rmb") && !TextUtils.equals(str, "guard_club_join")) {
                            if ("ui_event".equals(str)) {
                                linkedList.add(aVar);
                                if (this.afe != null) {
                                    this.afe.f(aVar);
                                }
                            } else if ("first_recharge_success".equals(str)) {
                                linkedList.add(aVar);
                                if (this.afe != null) {
                                    this.afe.f(aVar);
                                }
                            } else if ("need_update_live_mark_info".equals(str)) {
                                linkedList.add(aVar);
                                if (this.afe != null) {
                                    this.afe.f(aVar);
                                }
                            } else {
                                linkedList.add(aVar);
                            }
                        }
                    }
                } else if (aVar.getMsgType() == 12) {
                    linkedList.add(aVar);
                    if (this.afe != null) {
                        this.afe.f(aVar);
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
        if (list != null && this.afe != null) {
            this.afe.d(this.Wc, true);
            for (com.baidu.live.im.data.a aVar : list) {
                this.afe.f(aVar);
            }
        }
    }

    protected void y(List<com.baidu.live.im.data.a> list) {
        this.afh = list;
        this.afj = (int) ((this.afl * 2.0f) / 0.25f);
        this.afk = 0;
        this.afi = list.size() / this.afj;
        if (this.afi <= 0) {
            this.afi = 1;
        }
        this.mHandler.removeCallbacks(this.afo);
        this.mHandler.postDelayed(this.afo, 250L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void si() {
        this.mHandler.removeCallbacks(this.afo);
        this.afk = 0;
        this.afj = 0;
        this.afi = 0;
        this.afh = null;
    }

    protected List<com.baidu.live.im.data.a> c(List<com.baidu.live.im.data.a> list, boolean z) {
        return a(list, z, false);
    }

    protected List<com.baidu.live.im.data.a> a(List<com.baidu.live.im.data.a> list, boolean z, boolean z2) {
        for (com.baidu.live.im.data.a aVar : list) {
            if (aVar instanceof com.baidu.live.im.a) {
                ((com.baidu.live.im.a) aVar).cD(this.afg);
            }
        }
        if (z) {
            LinkedList linkedList = new LinkedList();
            for (com.baidu.live.im.data.a aVar2 : list) {
                if (aVar2.getMsgId() > getLastMid()) {
                    if (aVar2.getMsgType() == 24) {
                        List<com.baidu.live.im.data.a> e = e(aVar2);
                        this.Wc.addAll(e);
                        linkedList.addAll(e);
                    } else {
                        this.Wc.add(aVar2);
                        linkedList.add(aVar2);
                    }
                }
            }
            list = linkedList;
        } else {
            delRepeatMsg(this.Wc, list);
            c(z2, list);
            if (z2 && this.Wc.size() > 2) {
                z(list);
                this.Wc.addAll(2, list);
            } else {
                this.Wc.addAll(list);
            }
        }
        if (this.Wc.size() > 400) {
            this.Wc = this.Wc.subList(100, this.Wc.size());
        }
        if (this.Wc.size() > 1) {
            boolean d = d(this.Wc.get(this.Wc.size() - 1));
            while (d && d(this.Wc.get(this.Wc.size() - 2))) {
                this.Wc.remove(this.Wc.size() - 2);
                if (this.Wc.size() <= 1) {
                    break;
                }
            }
        }
        return list;
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

    private void z(List<com.baidu.live.im.data.a> list) {
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

    private void A(List<com.baidu.live.im.data.a> list) {
        if (list != null && !list.isEmpty()) {
            for (com.baidu.live.im.data.a aVar : list) {
                aVar.aA(true);
            }
        }
    }

    private boolean d(com.baidu.live.im.data.a aVar) {
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
                    if (aVar != null && aVar.te() != null && !TextUtils.isEmpty(aVar.te().userId) && aVar.te().userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        int i2 = size2 - 1;
                        while (true) {
                            if (i2 >= 0 && i2 >= 0) {
                                com.baidu.live.im.data.a aVar2 = list2.get(i2);
                                if (aVar2 != null && aVar2.te() != null && !TextUtils.isEmpty(aVar2.te().userId) && aVar2.te().userId.equals(TbadkCoreApplication.getCurrentAccount()) && aVar2.getRecordId() == aVar.getRecordId()) {
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

    public void sj() {
        this.mGroupId = null;
        this.aff = null;
        this.mLiveId = null;
        this.afm = "0";
        this.mAppId = null;
        MessageManager.getInstance().unRegisterListener(this.afw);
        MessageManager.getInstance().unRegisterListener(this.afv);
        MessageManager.getInstance().unRegisterListener(this.afp);
        MessageManager.getInstance().unRegisterListener(this.afs);
        MessageManager.getInstance().unRegisterListener(this.aft);
        MessageManager.getInstance().unRegisterListener(this.afu);
        MessageManager.getInstance().unRegisterListener(this.afq);
        this.mHandler.removeCallbacks(this.afo);
        this.mHandler.removeCallbacks(this.afr);
        if (this.Wc != null) {
            this.Wc.clear();
        }
        this.Wc = null;
    }

    public void a(ImSendMsgData imSendMsgData, boolean z, boolean z2, int i, String str, String[] strArr) {
        if (!TbadkCoreApplication.isLogin()) {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.sdk_not_login);
        } else if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow())) {
            BdUtilHelper.showToast(this.mPageContext.getPageActivity(), a.i.sdk_username_empty);
        } else {
            String str2 = imSendMsgData.text;
            short s = imSendMsgData.msgType;
            com.baidu.live.im.data.a a2 = a(s, str2, z, z2, i, this.PP);
            if (s == 126) {
                a2.cJ(imSendMsgData.barrageId);
                a2.a(imSendMsgData.barrageCardInfo);
            }
            if (a2 != null) {
                a2.k(strArr);
                this.Wc.add(a2);
                if (this.afe != null) {
                    this.afe.f(a2);
                    this.afe.d(this.Wc, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913043));
                com.baidu.live.im.message.a aVar = new com.baidu.live.im.message.a(str2, s, JavaTypesHelper.toInt(this.mGroupId, 0), this.mAppId);
                if (this.aaB != null && this.aaB.mLiveInfo != null) {
                    aVar.cK(this.aaB.mLiveInfo.live_id + "");
                    aVar.cL(this.aaB.mLiveInfo.room_id + "");
                } else {
                    aVar.cK("");
                    aVar.cL("");
                }
                aVar.setOtherParams(str);
                aVar.B(imSendMsgData.price);
                aVar.cJ(imSendMsgData.barrageId);
                aVar.a(imSendMsgData.barrageCardInfo);
                aVar.k(strArr);
                sendMessage(aVar);
            }
        }
    }

    protected com.baidu.live.im.data.a a(short s, String str, boolean z, boolean z2, int i, List<AlaLiveMarkData> list) {
        long j = 0;
        com.baidu.live.im.data.a sk = sk();
        if (sk == null) {
            return null;
        }
        sk.setMsgType(s);
        sk.setContent(str);
        long A = o.A(getLastMid());
        sk.setMsgId(A);
        sk.setRecordId(A);
        sk.setTime(System.currentTimeMillis() / 1000);
        com.baidu.live.data.a aVar = new com.baidu.live.data.a();
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            aVar.userName = TbadkCoreApplication.getCurrentAccountInfo().getAccountNameShow();
        }
        aVar.userId = TbadkCoreApplication.getCurrentAccount();
        aVar.portrait = TbadkCoreApplication.getCurrentPortrait();
        aVar.level_id = i;
        aVar.OO = z;
        aVar.OP = z2;
        if (list != null) {
            aVar.OR = new ArrayList(list);
        }
        sk.b(aVar);
        try {
            j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        } catch (Exception e) {
        }
        sk.setUserId(j);
        return sk;
    }

    private long getLastMid() {
        if (this.Wc == null || this.Wc.size() <= 0) {
            return JavaTypesHelper.toLong(this.aff, 1L);
        }
        return this.Wc.get(this.Wc.size() - 1).getMsgId();
    }

    protected com.baidu.live.im.data.a sk() {
        com.baidu.live.im.a aVar = new com.baidu.live.im.a();
        aVar.setBornTime(System.currentTimeMillis());
        if (TextUtils.isEmpty(this.mGroupId)) {
            return null;
        }
        aVar.cD(this.afg);
        return aVar;
    }

    public void B(List<AlaLiveMarkData> list) {
        this.PP = list;
    }

    public void cE(String str) {
        com.baidu.live.message.b bVar = new com.baidu.live.message.b(JavaTypesHelper.toLong(this.mLiveId, 0L), str);
        bVar.setParams();
        sendMessage(bVar);
    }

    public void cF(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.afm)) {
            cE("getliveinfo");
        }
    }

    private List<com.baidu.live.im.data.a> e(com.baidu.live.im.data.a aVar) {
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
            aVar3.cD(aVar2.sc());
            aVar3.setBornTime(aVar2.getBornTime());
            aVar3.setTime(aVar2.getTime());
            aVar3.setUserId(aVar2.getUserId());
            aVar3.setToUserId(aVar2.getToUserId());
            aVar3.c(aVar2.tf());
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
            aVar3.b(aVar2.te());
            aVar3.setSt_type(aVar2.getSt_type());
            arrayList.add(aVar3);
        }
        return arrayList;
    }

    public void a(int i, String str, com.baidu.live.data.a aVar) {
        com.baidu.live.im.data.a sk = sk();
        if (sk != null) {
            sk.setMsgType(i);
            sk.setContent(str);
            sk.b(aVar);
            this.Wc.add(sk);
            if (this.afe != null) {
                this.afe.d(this.Wc, true);
                this.afe.f(sk);
            }
        }
    }
}
