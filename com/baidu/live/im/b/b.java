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
    private m alp;
    private j.a atH;
    private boolean atI;
    private String atJ;
    private ImBarrageTrackView atK;
    private CustomMessageListener atL;
    private HttpMessageListener atM;
    private CustomMessageListener atN;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> atO;
    private boolean atP = false;
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
        this.atH = aVar;
    }

    @Override // com.baidu.live.im.j
    public void a(m mVar, boolean z) {
        if (z) {
            if (!this.atP) {
                this.atP = true;
            } else {
                return;
            }
        }
        this.atK.setCanAddNext();
        wD();
        a(mVar);
        wZ();
        xf();
    }

    @Override // com.baidu.live.im.j
    public void a(m mVar) {
        boolean z = false;
        this.alp = mVar;
        this.atI = false;
        if (this.alp != null && this.alp.mLiveInfo != null) {
            this.atJ = String.valueOf(this.alp.Ya.userId);
            String valueOf = String.valueOf(this.alp.mLiveInfo.user_id);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
                z = true;
            }
            this.atI = z;
        }
    }

    @Override // com.baidu.live.im.j
    public View wC() {
        return this.atK;
    }

    @Override // com.baidu.live.im.j
    public void wD() {
        if (this.atK != null) {
            this.atK.post(new Runnable() { // from class: com.baidu.live.im.b.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.atK.setVisibility(b.this.atK.getTop() > 0 ? 0 : 4);
                }
            });
        }
    }

    @Override // com.baidu.live.im.j
    public void wb() {
        xa();
        xg();
        this.alp = null;
        if (this.mMessages != null) {
            this.mMessages.clear();
        }
        if (this.atK != null) {
            this.atK.release();
            if (this.atK.getParent() != null) {
                ((ViewGroup) this.atK.getParent()).removeView(this.atK);
            }
        }
        this.atP = false;
    }

    @Override // com.baidu.live.im.j
    public void release() {
        wb();
        xc();
        xe();
        k.wF().release();
    }

    @Override // com.baidu.live.im.j
    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }

    private void initView() {
        this.atK = new ImBarrageTrackView(this.mPageContext.getPageActivity());
        this.atK.setCallback(new ImBarrageTrackView.a() { // from class: com.baidu.live.im.b.b.2
            @Override // com.baidu.live.im.view.barrage.ImBarrageTrackView.a
            public void c(com.baidu.live.data.a aVar) {
                b.this.b(aVar);
            }

            @Override // com.baidu.live.im.view.barrage.ImBarrageTrackView.a
            public void onNext() {
                b.this.xi();
            }
        });
    }

    private void initListener() {
        xb();
        xd();
    }

    private void wZ() {
        if (this.atO == null) {
            this.atO = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.live.im.b.b.3
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2913101, this.atO);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void xa() {
        MessageManager.getInstance().unRegisterTask(2913101);
    }

    private void xb() {
        this.atL = new CustomMessageListener(2913102) { // from class: com.baidu.live.im.b.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(b.this.mPageContext.getPageActivity()) != 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.B((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.atL);
    }

    private void xc() {
        if (this.atL != null) {
            MessageManager.getInstance().unRegisterListener(this.atL);
        }
    }

    private void xd() {
        this.atM = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.live.im.b.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021133 && (httpResponsedMessage instanceof ImBarragePayResponseMessage)) {
                    b.this.a((ImBarragePayResponseMessage) httpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.atM);
    }

    private void xe() {
        if (this.atM != null) {
            MessageManager.getInstance().unRegisterListener(this.atM);
        }
    }

    private void xf() {
        if (this.atN == null) {
            this.atN = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.b.b.6
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
        MessageManager.getInstance().registerListener(this.atN);
    }

    private void xg() {
        if (this.atN != null) {
            MessageManager.getInstance().unRegisterListener(this.atN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImSendMsgData imSendMsgData) {
        if (imSendMsgData.msgType == 126) {
            if (imSendMsgData.barrageType == 1 || imSendMsgData.barrageCardInfo == null || !imSendMsgData.barrageCardInfo.auc) {
                long j = imSendMsgData.price;
                if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                    xh();
                    return;
                } else {
                    TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
        }
    }

    private void xh() {
        if (this.atH != null) {
            this.atH.wE();
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
        if (aVar.xx() == 1) {
            com.baidu.live.im.data.b xz = aVar.xz();
            if (xz != null && xz.auc) {
                a(aVar.xy(), xz);
            } else {
                b(aVar.getMsgId(), aVar.xy());
            }
        }
    }

    private void b(long j, String str) {
        String sN = q.sN();
        com.baidu.live.im.message.c cVar = new com.baidu.live.im.message.c();
        cVar.addParam("scene_from", sN);
        cVar.addParam("live_id", this.alp.mLiveInfo.live_id);
        cVar.addParam("im_id", j);
        cVar.addParam("barrage_id", str);
        MessageManager.getInstance().sendMessage(cVar);
    }

    private void a(String str, com.baidu.live.im.data.b bVar) {
        com.baidu.live.gift.q qVar;
        Map<String, com.baidu.live.gift.q> sD = r.sC().sD();
        if (sD != null && sD.containsKey(str) && (qVar = sD.get(str)) != null) {
            t.b(qVar.itemId, qVar.agD, bVar.aud, bVar.liveId, 1, 0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImBarragePayResponseMessage imBarragePayResponseMessage) {
        if (imBarragePayResponseMessage.getError() == 0) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = imBarragePayResponseMessage.uO();
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
            if (n || this.mMessages.size() < com.baidu.live.v.a.zs().awM.aaW) {
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
                xi();
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
    public void xi() {
        bb[] wG;
        bb bbVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.atK.yj() && (wG = k.wF().wG()) != null) {
            com.baidu.live.im.data.a remove = this.mMessages.remove(0);
            int length = wG.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    bbVar = null;
                    break;
                }
                bbVar = wG[i];
                if (bbVar.id.equals(remove.xy())) {
                    break;
                }
                i++;
            }
            if (bbVar == null) {
                bbVar = new bb().qQ();
            }
            this.atK.a(bbVar, remove.xt(), remove.getContent(), this.atJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.live.data.a aVar) {
        if (aVar != null && this.alp != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.Xp, aVar.Xq, aVar.Xr, String.valueOf(this.alp.mLiveInfo.group_id), String.valueOf(this.alp.mLiveInfo.live_id), this.atI, String.valueOf(this.alp.Ya.userId), aVar.appId, aVar.getNameShow(), "")));
        }
    }
}
