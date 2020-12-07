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
import com.baidu.live.data.ci;
import com.baidu.live.data.w;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.y;
import com.baidu.live.gift.z;
import com.baidu.live.im.b.a;
import com.baidu.live.im.b.d;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.message.ImBarragePayResponseMessage;
import com.baidu.live.o.c;
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
/* loaded from: classes4.dex */
public class a implements com.baidu.live.im.b.a {
    private a.InterfaceC0193a aFM;
    private w aFN;
    private boolean aFO;
    private String aFP;
    private ImBarrageTrackView aFQ;
    private CustomMessageListener aFR;
    private HttpMessageListener aFS;
    private CustomMessageListener aFT;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> aFU;
    private boolean aFV = false;
    private List<com.baidu.live.im.data.b> mMessages;
    private String mOtherParams;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
        initListener();
    }

    @Override // com.baidu.live.im.b.a
    public void a(a.InterfaceC0193a interfaceC0193a) {
        this.aFM = interfaceC0193a;
    }

    @Override // com.baidu.live.im.b.a
    public void a(w wVar, boolean z) {
        if (z) {
            if (!this.aFV) {
                this.aFV = true;
            } else {
                return;
            }
        }
        this.aFQ.setCanAddNext();
        DM();
        a(wVar);
        DO();
        DU();
    }

    @Override // com.baidu.live.im.b.a
    public void a(w wVar) {
        boolean z = false;
        this.aFN = wVar;
        this.aFO = false;
        if (this.aFN != null && this.aFN.mLiveInfo != null) {
            this.aFP = String.valueOf(this.aFN.aJV.userId);
            String valueOf = String.valueOf(this.aFN.mLiveInfo.user_id);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
                z = true;
            }
            this.aFO = z;
        }
    }

    @Override // com.baidu.live.im.b.a
    public View DL() {
        return this.aFQ;
    }

    @Override // com.baidu.live.im.b.a
    public void DM() {
        if (this.aFQ != null) {
            this.aFQ.post(new Runnable() { // from class: com.baidu.live.barrage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.aFQ.setVisibility(a.this.aFQ.getTop() > 0 ? 0 : 4);
                }
            });
        }
    }

    @Override // com.baidu.live.im.b.a
    public void DN() {
        DP();
        DV();
        this.aFN = null;
        if (this.mMessages != null) {
            this.mMessages.clear();
        }
        if (this.aFQ != null) {
            this.aFQ.release();
            if (this.aFQ.getParent() != null) {
                ((ViewGroup) this.aFQ.getParent()).removeView(this.aFQ);
            }
        }
        this.aFV = false;
    }

    @Override // com.baidu.live.im.b.a
    public void release() {
        DN();
        DR();
        DT();
        d.NK().release();
    }

    @Override // com.baidu.live.im.b.a
    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }

    private void initView() {
        this.aFQ = new ImBarrageTrackView(this.mPageContext.getPageActivity());
        this.aFQ.setCallback(new ImBarrageTrackView.a() { // from class: com.baidu.live.barrage.a.a.2
            @Override // com.baidu.live.barrage.view.ImBarrageTrackView.a
            public void b(com.baidu.live.data.a aVar) {
                a.this.a(aVar);
            }

            @Override // com.baidu.live.barrage.view.ImBarrageTrackView.a
            public void onNext() {
                a.this.DX();
            }
        });
    }

    private void initListener() {
        DQ();
        DS();
    }

    private void DO() {
        if (this.aFU == null) {
            this.aFU = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.live.barrage.a.a.3
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2913101, this.aFU);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void DP() {
        MessageManager.getInstance().unRegisterTask(2913101);
    }

    private void DQ() {
        this.aFR = new CustomMessageListener(2913102) { // from class: com.baidu.live.barrage.a.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(a.this.mPageContext.getPageActivity()) != 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    a.this.v((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aFR);
    }

    private void DR() {
        if (this.aFR != null) {
            MessageManager.getInstance().unRegisterListener(this.aFR);
        }
    }

    private void DS() {
        this.aFS = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.live.barrage.a.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021133 && (httpResponsedMessage instanceof ImBarragePayResponseMessage)) {
                    a.this.a((ImBarragePayResponseMessage) httpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aFS);
    }

    private void DT() {
        if (this.aFS != null) {
            MessageManager.getInstance().unRegisterListener(this.aFS);
        }
    }

    private void DU() {
        if (this.aFT == null) {
            this.aFT = new CustomMessageListener(2913037) { // from class: com.baidu.live.barrage.a.a.6
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
        MessageManager.getInstance().registerListener(this.aFT);
    }

    private void DV() {
        if (this.aFT != null) {
            MessageManager.getInstance().unRegisterListener(this.aFT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImSendMsgData imSendMsgData) {
        if (imSendMsgData.msgType == 126) {
            if (imSendMsgData.barrageType == 1 && (imSendMsgData.barrageCardInfo == null || !imSendMsgData.barrageCardInfo.bpc)) {
                long j = imSendMsgData.price;
                if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                    DW();
                    return;
                } else {
                    TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
        }
    }

    private void DW() {
        if (this.aFM != null) {
            this.aFM.NJ();
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
        if (bVar.NY() == 1) {
            com.baidu.live.im.data.d Oa = bVar.Oa();
            if (Oa != null && Oa.bpc) {
                a(bVar.NZ(), Oa, bVar.bnb);
            } else {
                f(bVar.getMsgId(), bVar.NZ());
            }
        }
    }

    private void f(long j, String str) {
        String Iz = p.Iz();
        com.baidu.live.im.message.d dVar = new com.baidu.live.im.message.d();
        dVar.addParam("scene_from", Iz);
        dVar.addParam("live_id", this.aFN.mLiveInfo.live_id);
        dVar.addParam("im_id", j);
        dVar.addParam("barrage_id", str);
        MessageManager.getInstance().sendMessage(dVar);
    }

    private void a(String str, com.baidu.live.im.data.d dVar, String str2) {
        y yVar;
        Map<String, y> Ij = z.Ii().Ij();
        if (Ij != null && Ij.containsKey(str) && (yVar = Ij.get(str)) != null) {
            ac.b(yVar.itemId, yVar.aWn, dVar.bpd, dVar.liveId, 1, 0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImBarragePayResponseMessage imBarragePayResponseMessage) {
        if (imBarragePayResponseMessage.getError() == 0) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = imBarragePayResponseMessage.KK();
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
            if (d || this.mMessages.size() < com.baidu.live.ae.a.RB().brA.aOl) {
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
                DX();
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
    public void DX() {
        ci[] NL;
        ci ciVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.aFQ.Ee() && (NL = d.NK().NL()) != null) {
            com.baidu.live.im.data.b remove = this.mMessages.remove(0);
            int length = NL.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    ciVar = null;
                    break;
                }
                ciVar = NL[i];
                if (ciVar.id.equals(remove.NZ())) {
                    break;
                }
                i++;
            }
            if (ciVar == null) {
                ciVar = new ci().FY();
            }
            this.aFQ.a(ciVar, remove.NU(), remove.getContent(), this.aFP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.a aVar) {
        if (aVar != null && this.aFN != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.aIx, aVar.aIy, aVar.aIz, String.valueOf(this.aFN.mLiveInfo.group_id), String.valueOf(this.aFN.mLiveInfo.live_id), this.aFO, String.valueOf(this.aFN.aJV.userId), aVar.appId, aVar.getNameShow(), "")));
        }
    }
}
