package com.baidu.live.im.b;

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
import com.baidu.live.data.bo;
import com.baidu.live.data.q;
import com.baidu.live.gift.s;
import com.baidu.live.gift.t;
import com.baidu.live.gift.v;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.l;
import com.baidu.live.im.m;
import com.baidu.live.im.message.ImBarragePayResponseMessage;
import com.baidu.live.im.view.barrage.ImBarrageTrackView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.utils.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class b implements l {
    private q aLQ;
    private l.a aVG;
    private boolean aVH;
    private String aVI;
    private ImBarrageTrackView aVJ;
    private CustomMessageListener aVK;
    private HttpMessageListener aVL;
    private CustomMessageListener aVM;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> aVN;
    private boolean aVO = false;
    private List<com.baidu.live.im.data.a> mMessages;
    private String mOtherParams;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
        initListener();
    }

    @Override // com.baidu.live.im.l
    public void a(l.a aVar) {
        this.aVG = aVar;
    }

    @Override // com.baidu.live.im.l
    public void a(q qVar, boolean z) {
        if (z) {
            if (!this.aVO) {
                this.aVO = true;
            } else {
                return;
            }
        }
        this.aVJ.setCanAddNext();
        Dk();
        a(qVar);
        DH();
        DN();
    }

    @Override // com.baidu.live.im.l
    public void a(q qVar) {
        boolean z = false;
        this.aLQ = qVar;
        this.aVH = false;
        if (this.aLQ != null && this.aLQ.mLiveInfo != null) {
            this.aVI = String.valueOf(this.aLQ.axp.userId);
            String valueOf = String.valueOf(this.aLQ.mLiveInfo.user_id);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
                z = true;
            }
            this.aVH = z;
        }
    }

    @Override // com.baidu.live.im.l
    public View Dj() {
        return this.aVJ;
    }

    @Override // com.baidu.live.im.l
    public void Dk() {
        if (this.aVJ != null) {
            this.aVJ.post(new Runnable() { // from class: com.baidu.live.im.b.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.aVJ.setVisibility(b.this.aVJ.getTop() > 0 ? 0 : 4);
                }
            });
        }
    }

    @Override // com.baidu.live.im.l
    public void Cz() {
        DI();
        DO();
        this.aLQ = null;
        if (this.mMessages != null) {
            this.mMessages.clear();
        }
        if (this.aVJ != null) {
            this.aVJ.release();
            if (this.aVJ.getParent() != null) {
                ((ViewGroup) this.aVJ.getParent()).removeView(this.aVJ);
            }
        }
        this.aVO = false;
    }

    @Override // com.baidu.live.im.l
    public void release() {
        Cz();
        DK();
        DM();
        m.Dm().release();
    }

    @Override // com.baidu.live.im.l
    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }

    private void initView() {
        this.aVJ = new ImBarrageTrackView(this.mPageContext.getPageActivity());
        this.aVJ.setCallback(new ImBarrageTrackView.a() { // from class: com.baidu.live.im.b.b.2
            @Override // com.baidu.live.im.view.barrage.ImBarrageTrackView.a
            public void c(com.baidu.live.data.a aVar) {
                b.this.b(aVar);
            }

            @Override // com.baidu.live.im.view.barrage.ImBarrageTrackView.a
            public void onNext() {
                b.this.DQ();
            }
        });
    }

    private void initListener() {
        DJ();
        DL();
    }

    private void DH() {
        if (this.aVN == null) {
            this.aVN = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.live.im.b.b.3
                @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<?> run(CustomMessage<ImSendMsgData> customMessage) {
                    if (customMessage != null && customMessage.getData() != null) {
                        b.this.b(customMessage.getData());
                        return null;
                    }
                    return null;
                }
            };
        }
        CustomMessageTask customMessageTask = new CustomMessageTask(2913101, this.aVN);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void DI() {
        MessageManager.getInstance().unRegisterTask(2913101);
    }

    private void DJ() {
        this.aVK = new CustomMessageListener(2913102) { // from class: com.baidu.live.im.b.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(b.this.mPageContext.getPageActivity()) != 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.K((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aVK);
    }

    private void DK() {
        if (this.aVK != null) {
            MessageManager.getInstance().unRegisterListener(this.aVK);
        }
    }

    private void DL() {
        this.aVL = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.live.im.b.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021133 && (httpResponsedMessage instanceof ImBarragePayResponseMessage)) {
                    b.this.a((ImBarragePayResponseMessage) httpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aVL);
    }

    private void DM() {
        if (this.aVL != null) {
            MessageManager.getInstance().unRegisterListener(this.aVL);
        }
    }

    private void DN() {
        if (this.aVM == null) {
            this.aVM = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.b.b.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (UtilHelper.getRealScreenOrientation(b.this.mPageContext.getPageActivity()) != 2) {
                        Object data = customResponsedMessage.getData();
                        if (data instanceof com.baidu.live.im.data.a) {
                            b.this.p((com.baidu.live.im.data.a) data);
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.aVM);
    }

    private void DO() {
        if (this.aVM != null) {
            MessageManager.getInstance().unRegisterListener(this.aVM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImSendMsgData imSendMsgData) {
        if (imSendMsgData.msgType == 126) {
            if (imSendMsgData.barrageType == 1 && (imSendMsgData.barrageCardInfo == null || !imSendMsgData.barrageCardInfo.aWk)) {
                long j = imSendMsgData.price;
                if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                    DP();
                    return;
                } else {
                    TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
        }
    }

    private void DP() {
        if (this.aVG != null) {
            this.aVG.Dl();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mPageContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(List list) {
        if (list != null && !list.isEmpty()) {
            for (Object obj : list) {
                if (obj instanceof com.baidu.live.im.data.a) {
                    com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) obj;
                    if (r(aVar) && q(aVar)) {
                        o(aVar);
                    }
                }
            }
        }
    }

    private void o(com.baidu.live.im.data.a aVar) {
        if (aVar.Eh() == 1) {
            com.baidu.live.im.data.b Ej = aVar.Ej();
            if (Ej != null && Ej.aWk) {
                a(aVar.Ei(), Ej);
            } else {
                d(aVar.getMsgId(), aVar.Ei());
            }
        }
    }

    private void d(long j, String str) {
        String yU = p.yU();
        com.baidu.live.im.message.d dVar = new com.baidu.live.im.message.d();
        dVar.addParam("scene_from", yU);
        dVar.addParam("live_id", this.aLQ.mLiveInfo.live_id);
        dVar.addParam("im_id", j);
        dVar.addParam("barrage_id", str);
        MessageManager.getInstance().sendMessage(dVar);
    }

    private void a(String str, com.baidu.live.im.data.b bVar) {
        s sVar;
        Map<String, s> yM = t.yL().yM();
        if (yM != null && yM.containsKey(str) && (sVar = yM.get(str)) != null) {
            v.c(sVar.itemId, sVar.aGN, bVar.aWl, bVar.liveId, 1, 0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImBarragePayResponseMessage imBarragePayResponseMessage) {
        if (imBarragePayResponseMessage.getError() == 0) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = imBarragePayResponseMessage.AX();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
            return;
        }
        if (!TextUtils.isEmpty(imBarragePayResponseMessage.getErrorString())) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), imBarragePayResponseMessage.getErrorString());
        }
        new com.baidu.live.l.c().refreshCurUserScores();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(com.baidu.live.im.data.a aVar) {
        int i;
        if (aVar.getMsgType() == 126) {
            if (this.mMessages == null) {
                this.mMessages = new ArrayList();
            }
            boolean r = r(aVar);
            if (r || this.mMessages.size() < com.baidu.live.v.a.Hm().aZp.aAE) {
                if (r && !this.mMessages.isEmpty()) {
                    int i2 = 0;
                    while (true) {
                        i = i2;
                        if (i >= this.mMessages.size()) {
                            break;
                        } else if (!r(this.mMessages.get(i))) {
                            break;
                        } else {
                            i2 = i + 1;
                        }
                    }
                }
                i = -1;
                if (i >= 0) {
                    this.mMessages.add(i, aVar);
                } else {
                    this.mMessages.add(aVar);
                }
                DQ();
            }
        }
    }

    private boolean q(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getMsgType() == 126;
    }

    private boolean r(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DQ() {
        bo[] Dn;
        bo boVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.aVJ.Fc() && (Dn = m.Dm().Dn()) != null) {
            com.baidu.live.im.data.a remove = this.mMessages.remove(0);
            int length = Dn.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    boVar = null;
                    break;
                }
                boVar = Dn[i];
                if (boVar.id.equals(remove.Ei())) {
                    break;
                }
                i++;
            }
            if (boVar == null) {
                boVar = new bo().wT();
            }
            this.aVJ.a(boVar, remove.Ed(), remove.getContent(), this.aVI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.live.data.a aVar) {
        if (aVar != null && this.aLQ != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.awx, aVar.awy, aVar.awz, String.valueOf(this.aLQ.mLiveInfo.group_id), String.valueOf(this.aLQ.mLiveInfo.live_id), this.aVH, String.valueOf(this.aLQ.axp.userId), aVar.appId, aVar.getNameShow(), "")));
        }
    }
}
