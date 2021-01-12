package com.baidu.live.barrage.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.barrage.view.ImBarrageTrackView;
import com.baidu.live.data.ck;
import com.baidu.live.data.x;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.y;
import com.baidu.live.gift.z;
import com.baidu.live.im.b.a;
import com.baidu.live.im.b.d;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.message.ImBarragePayResponseMessage;
import com.baidu.live.p.c;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.utils.q;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public class a implements com.baidu.live.im.b.a {
    private a.InterfaceC0177a aBq;
    private x aBr;
    private boolean aBs;
    private String aBt;
    private ImBarrageTrackView aBu;
    private CustomMessageListener aBv;
    private HttpMessageListener aBw;
    private CustomMessageListener aBx;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> aBy;
    private boolean aBz = false;
    private List<com.baidu.live.im.data.b> mMessages;
    private String mOtherParams;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
        initListener();
    }

    @Override // com.baidu.live.im.b.a
    public void a(a.InterfaceC0177a interfaceC0177a) {
        this.aBq = interfaceC0177a;
    }

    @Override // com.baidu.live.im.b.a
    public void a(x xVar, boolean z) {
        if (z) {
            if (!this.aBz) {
                this.aBz = true;
            } else {
                return;
            }
        }
        this.aBu.setCanAddNext();
        zg();
        a(xVar);
        zi();
        zo();
    }

    @Override // com.baidu.live.im.b.a
    public void a(x xVar) {
        boolean z = false;
        this.aBr = xVar;
        this.aBs = false;
        if (this.aBr != null && this.aBr.mLiveInfo != null) {
            this.aBt = String.valueOf(this.aBr.aFH.userId);
            String valueOf = String.valueOf(this.aBr.mLiveInfo.user_id);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
                z = true;
            }
            this.aBs = z;
        }
    }

    @Override // com.baidu.live.im.b.a
    public View zf() {
        return this.aBu;
    }

    @Override // com.baidu.live.im.b.a
    public void zg() {
        if (this.aBu != null) {
            this.aBu.post(new Runnable() { // from class: com.baidu.live.barrage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.aBu.setVisibility(a.this.aBu.getTop() > 0 ? 0 : 4);
                }
            });
        }
    }

    @Override // com.baidu.live.im.b.a
    public void zh() {
        zj();
        zp();
        this.aBr = null;
        if (this.mMessages != null) {
            this.mMessages.clear();
        }
        if (this.aBu != null) {
            this.aBu.release();
            if (this.aBu.getParent() != null) {
                ((ViewGroup) this.aBu.getParent()).removeView(this.aBu);
            }
        }
        this.aBz = false;
    }

    @Override // com.baidu.live.im.b.a
    public void release() {
        zh();
        zl();
        zn();
        d.Jp().release();
    }

    @Override // com.baidu.live.im.b.a
    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }

    private void initView() {
        this.aBu = new ImBarrageTrackView(this.mPageContext.getPageActivity());
        this.aBu.setCallback(new ImBarrageTrackView.a() { // from class: com.baidu.live.barrage.a.a.2
            @Override // com.baidu.live.barrage.view.ImBarrageTrackView.a
            public void b(com.baidu.live.data.a aVar) {
                a.this.a(aVar);
            }

            @Override // com.baidu.live.barrage.view.ImBarrageTrackView.a
            public void onNext() {
                a.this.zr();
            }
        });
    }

    private void initListener() {
        zk();
        zm();
    }

    private void zi() {
        if (this.aBy == null) {
            this.aBy = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.live.barrage.a.a.3
                @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<?> run(CustomMessage<ImSendMsgData> customMessage) {
                    if (customMessage != null && customMessage.getData() != null) {
                        a.this.a(customMessage.getData());
                        return null;
                    }
                    return null;
                }
            };
        }
        CustomMessageTask customMessageTask = new CustomMessageTask(2913101, this.aBy);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void zj() {
        MessageManager.getInstance().unRegisterTask(2913101);
    }

    private void zk() {
        this.aBv = new CustomMessageListener(2913102) { // from class: com.baidu.live.barrage.a.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(a.this.mPageContext.getPageActivity()) != 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    a.this.v((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aBv);
    }

    private void zl() {
        if (this.aBv != null) {
            MessageManager.getInstance().unRegisterListener(this.aBv);
        }
    }

    private void zm() {
        this.aBw = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.live.barrage.a.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021133 && (httpResponsedMessage instanceof ImBarragePayResponseMessage)) {
                    a.this.a((ImBarragePayResponseMessage) httpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aBw);
    }

    private void zn() {
        if (this.aBw != null) {
            MessageManager.getInstance().unRegisterListener(this.aBw);
        }
    }

    private void zo() {
        if (this.aBx == null) {
            this.aBx = new CustomMessageListener(2913037) { // from class: com.baidu.live.barrage.a.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (UtilHelper.getRealScreenOrientation(a.this.mPageContext.getPageActivity()) != 2) {
                        Object data = customResponsedMessage.getData();
                        if (data instanceof com.baidu.live.im.data.b) {
                            a.this.b((com.baidu.live.im.data.b) data);
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.aBx);
    }

    private void zp() {
        if (this.aBx != null) {
            MessageManager.getInstance().unRegisterListener(this.aBx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImSendMsgData imSendMsgData) {
        if (imSendMsgData.msgType == 126) {
            if (imSendMsgData.barrageType == 1 && (imSendMsgData.barrageCardInfo == null || !imSendMsgData.barrageCardInfo.blX)) {
                long j = imSendMsgData.price;
                if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                    zq();
                    return;
                } else {
                    TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
        }
    }

    private void zq() {
        if (this.aBq != null) {
            this.aBq.Jo();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mPageContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(List list) {
        if (list != null && !list.isEmpty()) {
            for (Object obj : list) {
                if (obj instanceof com.baidu.live.im.data.b) {
                    com.baidu.live.im.data.b bVar = (com.baidu.live.im.data.b) obj;
                    if (d(bVar) && c(bVar)) {
                        a(bVar);
                    }
                }
            }
        }
    }

    private void a(com.baidu.live.im.data.b bVar) {
        if (bVar.JF() == 1) {
            com.baidu.live.im.data.d JH = bVar.JH();
            if (JH != null && JH.blX) {
                a(bVar.JG(), JH, bVar.bjV);
            } else {
                f(bVar.getMsgId(), bVar.JG());
            }
        }
    }

    private void f(long j, String str) {
        String Ef = q.Ef();
        com.baidu.live.im.message.d dVar = new com.baidu.live.im.message.d();
        dVar.addParam("scene_from", Ef);
        dVar.addParam("live_id", this.aBr.mLiveInfo.live_id);
        dVar.addParam("im_id", j);
        dVar.addParam("barrage_id", str);
        MessageManager.getInstance().sendMessage(dVar);
    }

    private void a(String str, com.baidu.live.im.data.d dVar, String str2) {
        y yVar;
        Map<String, y> DP = z.DO().DP();
        if (DP != null && DP.containsKey(str) && (yVar = DP.get(str)) != null) {
            ac.b(yVar.itemId, yVar.aTg, dVar.aZY, dVar.liveId, 1, 0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImBarragePayResponseMessage imBarragePayResponseMessage) {
        if (imBarragePayResponseMessage.getError() == 0) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = imBarragePayResponseMessage.Gq();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
            return;
        }
        if (!TextUtils.isEmpty(imBarragePayResponseMessage.getErrorString())) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), imBarragePayResponseMessage.getErrorString());
        }
        new c().refreshCurUserScores();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.live.im.data.b bVar) {
        int i;
        if (bVar.getMsgType() == 126) {
            if (this.mMessages == null) {
                this.mMessages = new ArrayList();
            }
            boolean d = d(bVar);
            if (d || this.mMessages.size() < com.baidu.live.af.a.OJ().bru.aKf) {
                if (d && !this.mMessages.isEmpty()) {
                    int i2 = 0;
                    while (true) {
                        i = i2;
                        if (i >= this.mMessages.size()) {
                            break;
                        } else if (!d(this.mMessages.get(i))) {
                            break;
                        } else {
                            i2 = i + 1;
                        }
                    }
                }
                i = -1;
                if (i >= 0) {
                    this.mMessages.add(i, bVar);
                } else {
                    this.mMessages.add(bVar);
                }
                zr();
            }
        }
    }

    private boolean c(com.baidu.live.im.data.b bVar) {
        return bVar != null && bVar.getMsgType() == 126;
    }

    private boolean d(com.baidu.live.im.data.b bVar) {
        return bVar != null && bVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zr() {
        ck[] Jq;
        ck ckVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.aBu.zy() && (Jq = d.Jp().Jq()) != null && Jq.length > 0) {
            com.baidu.live.im.data.b remove = this.mMessages.remove(0);
            int length = Jq.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    ckVar = null;
                    break;
                }
                ckVar = Jq[i];
                if (ckVar.id.equals(remove.JG())) {
                    break;
                }
                i++;
            }
            if (ckVar == null) {
                ckVar = new ck().Bw();
            }
            this.aBu.a(ckVar, remove.JB(), remove.getContent(), this.aBt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.a aVar) {
        if (aVar != null && this.aBr != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.aEg, aVar.aEh, aVar.aEi, String.valueOf(this.aBr.mLiveInfo.group_id), String.valueOf(this.aBr.mLiveInfo.live_id), this.aBs, String.valueOf(this.aBr.aFH.userId), aVar.appId, aVar.getNameShow())));
        }
    }
}
