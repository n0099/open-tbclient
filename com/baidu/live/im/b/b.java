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
import com.baidu.live.data.be;
import com.baidu.live.data.n;
import com.baidu.live.gift.r;
import com.baidu.live.gift.s;
import com.baidu.live.gift.u;
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
import com.baidu.live.utils.q;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class b implements l {
    private n aDK;
    private l.a aMU;
    private boolean aMV;
    private String aMW;
    private ImBarrageTrackView aMX;
    private CustomMessageListener aMY;
    private HttpMessageListener aMZ;
    private CustomMessageListener aNa;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> aNb;
    private boolean aNc = false;
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
        this.aMU = aVar;
    }

    @Override // com.baidu.live.im.l
    public void a(n nVar, boolean z) {
        if (z) {
            if (!this.aNc) {
                this.aNc = true;
            } else {
                return;
            }
        }
        this.aMX.setCanAddNext();
        Bm();
        a(nVar);
        BJ();
        BP();
    }

    @Override // com.baidu.live.im.l
    public void a(n nVar) {
        boolean z = false;
        this.aDK = nVar;
        this.aMV = false;
        if (this.aDK != null && this.aDK.mLiveInfo != null) {
            this.aMW = String.valueOf(this.aDK.aqk.userId);
            String valueOf = String.valueOf(this.aDK.mLiveInfo.user_id);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
                z = true;
            }
            this.aMV = z;
        }
    }

    @Override // com.baidu.live.im.l
    public View Bl() {
        return this.aMX;
    }

    @Override // com.baidu.live.im.l
    public void Bm() {
        if (this.aMX != null) {
            this.aMX.post(new Runnable() { // from class: com.baidu.live.im.b.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.aMX.setVisibility(b.this.aMX.getTop() > 0 ? 0 : 4);
                }
            });
        }
    }

    @Override // com.baidu.live.im.l
    public void AJ() {
        BK();
        BQ();
        this.aDK = null;
        if (this.mMessages != null) {
            this.mMessages.clear();
        }
        if (this.aMX != null) {
            this.aMX.release();
            if (this.aMX.getParent() != null) {
                ((ViewGroup) this.aMX.getParent()).removeView(this.aMX);
            }
        }
        this.aNc = false;
    }

    @Override // com.baidu.live.im.l
    public void release() {
        AJ();
        BM();
        BO();
        m.Bo().release();
    }

    @Override // com.baidu.live.im.l
    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }

    private void initView() {
        this.aMX = new ImBarrageTrackView(this.mPageContext.getPageActivity());
        this.aMX.setCallback(new ImBarrageTrackView.a() { // from class: com.baidu.live.im.b.b.2
            @Override // com.baidu.live.im.view.barrage.ImBarrageTrackView.a
            public void c(com.baidu.live.data.a aVar) {
                b.this.b(aVar);
            }

            @Override // com.baidu.live.im.view.barrage.ImBarrageTrackView.a
            public void onNext() {
                b.this.BS();
            }
        });
    }

    private void initListener() {
        BL();
        BN();
    }

    private void BJ() {
        if (this.aNb == null) {
            this.aNb = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.live.im.b.b.3
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2913101, this.aNb);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void BK() {
        MessageManager.getInstance().unRegisterTask(2913101);
    }

    private void BL() {
        this.aMY = new CustomMessageListener(2913102) { // from class: com.baidu.live.im.b.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(b.this.mPageContext.getPageActivity()) != 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.G((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aMY);
    }

    private void BM() {
        if (this.aMY != null) {
            MessageManager.getInstance().unRegisterListener(this.aMY);
        }
    }

    private void BN() {
        this.aMZ = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.live.im.b.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021133 && (httpResponsedMessage instanceof ImBarragePayResponseMessage)) {
                    b.this.a((ImBarragePayResponseMessage) httpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aMZ);
    }

    private void BO() {
        if (this.aMZ != null) {
            MessageManager.getInstance().unRegisterListener(this.aMZ);
        }
    }

    private void BP() {
        if (this.aNa == null) {
            this.aNa = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.b.b.6
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
        MessageManager.getInstance().registerListener(this.aNa);
    }

    private void BQ() {
        if (this.aNa != null) {
            MessageManager.getInstance().unRegisterListener(this.aNa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImSendMsgData imSendMsgData) {
        if (imSendMsgData.msgType == 126) {
            if (imSendMsgData.barrageType == 1 && (imSendMsgData.barrageCardInfo == null || !imSendMsgData.barrageCardInfo.aNx)) {
                long j = imSendMsgData.price;
                if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                    BR();
                    return;
                } else {
                    TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
        }
    }

    private void BR() {
        if (this.aMU != null) {
            this.aMU.Bn();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mPageContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(List list) {
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
        if (aVar.Ci() == 1) {
            com.baidu.live.im.data.b Ck = aVar.Ck();
            if (Ck != null && Ck.aNx) {
                a(aVar.Cj(), Ck);
            } else {
                d(aVar.getMsgId(), aVar.Cj());
            }
        }
    }

    private void d(long j, String str) {
        String xf = q.xf();
        com.baidu.live.im.message.d dVar = new com.baidu.live.im.message.d();
        dVar.addParam("scene_from", xf);
        dVar.addParam("live_id", this.aDK.mLiveInfo.live_id);
        dVar.addParam("im_id", j);
        dVar.addParam("barrage_id", str);
        MessageManager.getInstance().sendMessage(dVar);
    }

    private void a(String str, com.baidu.live.im.data.b bVar) {
        r rVar;
        Map<String, r> wV = s.wU().wV();
        if (wV != null && wV.containsKey(str) && (rVar = wV.get(str)) != null) {
            u.b(rVar.itemId, rVar.ayZ, bVar.aNy, bVar.liveId, 1, 0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImBarragePayResponseMessage imBarragePayResponseMessage) {
        if (imBarragePayResponseMessage.getError() == 0) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = imBarragePayResponseMessage.zi();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
            return;
        }
        if (!TextUtils.isEmpty(imBarragePayResponseMessage.getErrorString())) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), imBarragePayResponseMessage.getErrorString());
        }
        new com.baidu.live.k.c().refreshCurUserScores();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(com.baidu.live.im.data.a aVar) {
        int i;
        if (aVar.getMsgType() == 126) {
            if (this.mMessages == null) {
                this.mMessages = new ArrayList();
            }
            boolean r = r(aVar);
            if (r || this.mMessages.size() < com.baidu.live.v.a.En().aQu.atr) {
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
                BS();
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
    public void BS() {
        be[] Bp;
        be beVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.aMX.Da() && (Bp = m.Bo().Bp()) != null) {
            com.baidu.live.im.data.a remove = this.mMessages.remove(0);
            int length = Bp.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    beVar = null;
                    break;
                }
                beVar = Bp[i];
                if (beVar.id.equals(remove.Cj())) {
                    break;
                }
                i++;
            }
            if (beVar == null) {
                beVar = new be().vg();
            }
            this.aMX.a(beVar, remove.Ce(), remove.getContent(), this.aMW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.live.data.a aVar) {
        if (aVar != null && this.aDK != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.apy, aVar.apz, aVar.apA, String.valueOf(this.aDK.mLiveInfo.group_id), String.valueOf(this.aDK.mLiveInfo.live_id), this.aMV, String.valueOf(this.aDK.aqk.userId), aVar.appId, aVar.getNameShow(), "")));
        }
    }
}
