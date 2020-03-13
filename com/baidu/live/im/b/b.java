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
import com.baidu.live.data.bb;
import com.baidu.live.data.m;
import com.baidu.live.gift.r;
import com.baidu.live.gift.t;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.j;
import com.baidu.live.im.k;
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
public class b implements j {
    private m ale;
    private ImBarrageTrackView atA;
    private CustomMessageListener atB;
    private HttpMessageListener atC;
    private CustomMessageListener atD;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> atE;
    private boolean atF = false;
    private j.a atx;
    private boolean aty;
    private String atz;
    private List<com.baidu.live.im.data.a> mMessages;
    private String mOtherParams;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
        initListener();
    }

    @Override // com.baidu.live.im.j
    public void a(j.a aVar) {
        this.atx = aVar;
    }

    @Override // com.baidu.live.im.j
    public void a(m mVar, boolean z) {
        if (z) {
            if (!this.atF) {
                this.atF = true;
            } else {
                return;
            }
        }
        this.atA.setCanAddNext();
        wy();
        a(mVar);
        wU();
        xa();
    }

    @Override // com.baidu.live.im.j
    public void a(m mVar) {
        boolean z = false;
        this.ale = mVar;
        this.aty = false;
        if (this.ale != null && this.ale.mLiveInfo != null) {
            this.atz = String.valueOf(this.ale.XQ.userId);
            String valueOf = String.valueOf(this.ale.mLiveInfo.user_id);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
                z = true;
            }
            this.aty = z;
        }
    }

    @Override // com.baidu.live.im.j
    public View wx() {
        return this.atA;
    }

    @Override // com.baidu.live.im.j
    public void wy() {
        if (this.atA != null) {
            this.atA.post(new Runnable() { // from class: com.baidu.live.im.b.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.atA.setVisibility(b.this.atA.getTop() > 0 ? 0 : 4);
                }
            });
        }
    }

    @Override // com.baidu.live.im.j
    public void vW() {
        wV();
        xb();
        this.ale = null;
        if (this.mMessages != null) {
            this.mMessages.clear();
        }
        if (this.atA != null) {
            this.atA.release();
            if (this.atA.getParent() != null) {
                ((ViewGroup) this.atA.getParent()).removeView(this.atA);
            }
        }
        this.atF = false;
    }

    @Override // com.baidu.live.im.j
    public void release() {
        vW();
        wX();
        wZ();
        k.wA().release();
    }

    @Override // com.baidu.live.im.j
    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }

    private void initView() {
        this.atA = new ImBarrageTrackView(this.mPageContext.getPageActivity());
        this.atA.setCallback(new ImBarrageTrackView.a() { // from class: com.baidu.live.im.b.b.2
            @Override // com.baidu.live.im.view.barrage.ImBarrageTrackView.a
            public void c(com.baidu.live.data.a aVar) {
                b.this.b(aVar);
            }

            @Override // com.baidu.live.im.view.barrage.ImBarrageTrackView.a
            public void onNext() {
                b.this.xd();
            }
        });
    }

    private void initListener() {
        wW();
        wY();
    }

    private void wU() {
        if (this.atE == null) {
            this.atE = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.live.im.b.b.3
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2913101, this.atE);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void wV() {
        MessageManager.getInstance().unRegisterTask(2913101);
    }

    private void wW() {
        this.atB = new CustomMessageListener(2913102) { // from class: com.baidu.live.im.b.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(b.this.mPageContext.getPageActivity()) != 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.B((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.atB);
    }

    private void wX() {
        if (this.atB != null) {
            MessageManager.getInstance().unRegisterListener(this.atB);
        }
    }

    private void wY() {
        this.atC = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.live.im.b.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021133 && (httpResponsedMessage instanceof ImBarragePayResponseMessage)) {
                    b.this.a((ImBarragePayResponseMessage) httpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.atC);
    }

    private void wZ() {
        if (this.atC != null) {
            MessageManager.getInstance().unRegisterListener(this.atC);
        }
    }

    private void xa() {
        if (this.atD == null) {
            this.atD = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.b.b.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (UtilHelper.getRealScreenOrientation(b.this.mPageContext.getPageActivity()) != 2) {
                        Object data = customResponsedMessage.getData();
                        if (data instanceof com.baidu.live.im.data.a) {
                            b.this.l((com.baidu.live.im.data.a) data);
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.atD);
    }

    private void xb() {
        if (this.atD != null) {
            MessageManager.getInstance().unRegisterListener(this.atD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImSendMsgData imSendMsgData) {
        if (imSendMsgData.msgType == 126) {
            if (imSendMsgData.barrageType == 1 || imSendMsgData.barrageCardInfo == null || !imSendMsgData.barrageCardInfo.atS) {
                long j = imSendMsgData.price;
                if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                    xc();
                    return;
                } else {
                    TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
        }
    }

    private void xc() {
        if (this.atx != null) {
            this.atx.wz();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mPageContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(List list) {
        if (list != null && !list.isEmpty()) {
            for (Object obj : list) {
                if (obj instanceof com.baidu.live.im.data.a) {
                    com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) obj;
                    if (n(aVar) && m(aVar)) {
                        k(aVar);
                    }
                }
            }
        }
    }

    private void k(com.baidu.live.im.data.a aVar) {
        if (aVar.xs() == 1) {
            com.baidu.live.im.data.b xu = aVar.xu();
            if (xu != null && xu.atS) {
                a(aVar.xt(), xu);
            } else {
                b(aVar.getMsgId(), aVar.xt());
            }
        }
    }

    private void b(long j, String str) {
        String sI = q.sI();
        com.baidu.live.im.message.c cVar = new com.baidu.live.im.message.c();
        cVar.addParam("scene_from", sI);
        cVar.addParam("live_id", this.ale.mLiveInfo.live_id);
        cVar.addParam("im_id", j);
        cVar.addParam("barrage_id", str);
        MessageManager.getInstance().sendMessage(cVar);
    }

    private void a(String str, com.baidu.live.im.data.b bVar) {
        com.baidu.live.gift.q qVar;
        Map<String, com.baidu.live.gift.q> sy = r.sx().sy();
        if (sy != null && sy.containsKey(str) && (qVar = sy.get(str)) != null) {
            t.b(qVar.itemId, qVar.agt, bVar.atT, bVar.liveId, 1, 0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImBarragePayResponseMessage imBarragePayResponseMessage) {
        if (imBarragePayResponseMessage.getError() == 0) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = imBarragePayResponseMessage.uJ();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
            return;
        }
        if (!TextUtils.isEmpty(imBarragePayResponseMessage.getErrorString())) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), imBarragePayResponseMessage.getErrorString());
        }
        new com.baidu.live.k.c().refreshCurUserScores();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(com.baidu.live.im.data.a aVar) {
        int i;
        if (aVar.getMsgType() == 126) {
            if (this.mMessages == null) {
                this.mMessages = new ArrayList();
            }
            boolean n = n(aVar);
            if (n || this.mMessages.size() < com.baidu.live.v.a.zl().awC.aaM) {
                if (n && !this.mMessages.isEmpty()) {
                    int i2 = 0;
                    while (true) {
                        i = i2;
                        if (i >= this.mMessages.size()) {
                            break;
                        } else if (!n(this.mMessages.get(i))) {
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
                xd();
            }
        }
    }

    private boolean m(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getMsgType() == 126;
    }

    private boolean n(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xd() {
        bb[] wB;
        bb bbVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.atA.ye() && (wB = k.wA().wB()) != null) {
            com.baidu.live.im.data.a remove = this.mMessages.remove(0);
            int length = wB.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    bbVar = null;
                    break;
                }
                bbVar = wB[i];
                if (bbVar.id.equals(remove.xt())) {
                    break;
                }
                i++;
            }
            if (bbVar == null) {
                bbVar = new bb().qL();
            }
            this.atA.a(bbVar, remove.xo(), remove.getContent(), this.atz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.live.data.a aVar) {
        if (aVar != null && this.ale != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.Xf, aVar.Xg, aVar.Xh, String.valueOf(this.ale.mLiveInfo.group_id), String.valueOf(this.ale.mLiveInfo.live_id), this.aty, String.valueOf(this.ale.XQ.userId), aVar.appId, aVar.getNameShow(), "")));
        }
    }
}
