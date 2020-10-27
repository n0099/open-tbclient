package com.baidu.live.yuyinbarrage.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.ala.AlaCmdConfigCustom;
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
import com.baidu.live.data.ce;
import com.baidu.live.data.w;
import com.baidu.live.gift.ai;
import com.baidu.live.gift.y;
import com.baidu.live.gift.z;
import com.baidu.live.im.b.a;
import com.baidu.live.im.b.d;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.data.b;
import com.baidu.live.im.message.YuyinImBarragePayResponseMessage;
import com.baidu.live.im.message.e;
import com.baidu.live.m.c;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.utils.s;
import com.baidu.live.yuyinbarrage.view.ImBarrageTrackView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.im.b.a {
    private a.InterfaceC0186a aEb;
    private w aEc;
    private boolean aEd;
    private String aEe;
    private CustomMessageListener aEg;
    private HttpMessageListener aEh;
    private CustomMessageListener aEi;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> aEj;
    private boolean aEk = false;
    private ImBarrageTrackView bJC;
    private List<com.baidu.live.im.data.a> mMessages;
    private String mOtherParams;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
        initListener();
    }

    @Override // com.baidu.live.im.b.a
    public void a(a.InterfaceC0186a interfaceC0186a) {
        this.aEb = interfaceC0186a;
    }

    @Override // com.baidu.live.im.b.a
    public void a(w wVar, boolean z) {
        if (z) {
            if (!this.aEk) {
                this.aEk = true;
            } else {
                return;
            }
        }
        this.bJC.setCanAddNext();
        Cs();
        a(wVar);
        Cu();
        CA();
    }

    @Override // com.baidu.live.im.b.a
    public void a(w wVar) {
        boolean z = false;
        this.aEc = wVar;
        this.aEd = false;
        if (this.aEc != null && this.aEc.mLiveInfo != null) {
            this.aEe = String.valueOf(this.aEc.aIe.userId);
            String valueOf = String.valueOf(this.aEc.mLiveInfo.user_id);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
                z = true;
            }
            this.aEd = z;
        }
    }

    @Override // com.baidu.live.im.b.a
    public View Cr() {
        return this.bJC;
    }

    @Override // com.baidu.live.im.b.a
    public void Cs() {
        if (this.bJC != null) {
            this.bJC.post(new Runnable() { // from class: com.baidu.live.yuyinbarrage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.bJC.setVisibility(a.this.bJC.getTop() > 0 ? 0 : 4);
                }
            });
        }
    }

    @Override // com.baidu.live.im.b.a
    public void Ct() {
        Cv();
        CB();
        this.aEc = null;
        if (this.mMessages != null) {
            this.mMessages.clear();
        }
        if (this.bJC != null) {
            this.bJC.release();
            if (this.bJC.getParent() != null) {
                ((ViewGroup) this.bJC.getParent()).removeView(this.bJC);
            }
        }
        this.aEk = false;
    }

    @Override // com.baidu.live.im.b.a
    public void release() {
        Ct();
        Cx();
        Cz();
        d.LG().release();
    }

    @Override // com.baidu.live.im.b.a
    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }

    private void initView() {
        this.bJC = new ImBarrageTrackView(this.mPageContext.getPageActivity());
        this.bJC.setCallback(new ImBarrageTrackView.a() { // from class: com.baidu.live.yuyinbarrage.a.a.2
            @Override // com.baidu.live.yuyinbarrage.view.ImBarrageTrackView.a
            public void b(com.baidu.live.data.a aVar) {
                a.this.a(aVar);
            }

            @Override // com.baidu.live.yuyinbarrage.view.ImBarrageTrackView.a
            public void onNext() {
                a.this.CD();
            }
        });
    }

    private void initListener() {
        Cw();
        Cy();
    }

    private void Cu() {
        if (this.aEj == null) {
            this.aEj = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.live.yuyinbarrage.a.a.3
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2501069, this.aEj);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void Cv() {
        MessageManager.getInstance().unRegisterTask(2501069);
    }

    private void Cw() {
        this.aEg = new CustomMessageListener(2913102) { // from class: com.baidu.live.yuyinbarrage.a.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(a.this.mPageContext.getPageActivity()) != 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    a.this.u((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aEg);
    }

    private void Cx() {
        if (this.aEg != null) {
            MessageManager.getInstance().unRegisterListener(this.aEg);
        }
    }

    private void Cy() {
        this.aEh = new HttpMessageListener(1031047) { // from class: com.baidu.live.yuyinbarrage.a.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031047 && (httpResponsedMessage instanceof YuyinImBarragePayResponseMessage)) {
                    a.this.a((YuyinImBarragePayResponseMessage) httpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aEh);
    }

    private void Cz() {
        if (this.aEh != null) {
            MessageManager.getInstance().unRegisterListener(this.aEh);
        }
    }

    private void CA() {
        if (this.aEi == null) {
            this.aEi = new CustomMessageListener(2913037) { // from class: com.baidu.live.yuyinbarrage.a.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (UtilHelper.getRealScreenOrientation(a.this.mPageContext.getPageActivity()) != 2) {
                        Object data = customResponsedMessage.getData();
                        if (data instanceof com.baidu.live.im.data.a) {
                            a.this.b((com.baidu.live.im.data.a) data);
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.aEi);
    }

    private void CB() {
        if (this.aEi != null) {
            MessageManager.getInstance().unRegisterListener(this.aEi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImSendMsgData imSendMsgData) {
        if (imSendMsgData.msgType == 126) {
            if (imSendMsgData.barrageType == 1 && (imSendMsgData.barrageCardInfo == null || !imSendMsgData.barrageCardInfo.bkp)) {
                long j = imSendMsgData.price;
                if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                    CC();
                    return;
                } else {
                    TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
        }
    }

    private void CC() {
        if (this.aEb != null) {
            this.aEb.LF();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mPageContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(List list) {
        if (list != null && !list.isEmpty()) {
            for (Object obj : list) {
                if (obj instanceof com.baidu.live.im.data.a) {
                    com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) obj;
                    if (d(aVar) && c(aVar)) {
                        a(aVar);
                    }
                }
            }
        }
    }

    private void a(com.baidu.live.im.data.a aVar) {
        if (aVar.LS() == 1) {
            b LU = aVar.LU();
            if (LU != null && LU.bkp) {
                a(aVar.LT(), LU, aVar.bja);
            } else {
                c(aVar.getMsgId(), aVar.LT());
            }
        }
    }

    private void c(long j, String str) {
        String GQ = s.GQ();
        e eVar = new e();
        eVar.addParam("scene_from", GQ);
        eVar.addParam("live_id", this.aEc.mLiveInfo.live_id);
        eVar.addParam(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aEc.aIS.croom_id);
        eVar.addParam("is_jiaoyou", 1);
        eVar.addParam("im_id", j);
        eVar.addParam("barrage_id", str);
        MessageManager.getInstance().sendMessage(eVar);
    }

    private void a(String str, b bVar, String str2) {
        y yVar;
        Map<String, y> GC = z.GB().GC();
        if (GC != null && GC.containsKey(str) && (yVar = GC.get(str)) != null) {
            ai.b(yVar.itemId, yVar.aTB, bVar.bkq, bVar.liveId, 1, 0, "", str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(YuyinImBarragePayResponseMessage yuyinImBarragePayResponseMessage) {
        if (yuyinImBarragePayResponseMessage.getError() == 0) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = yuyinImBarragePayResponseMessage.IS();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
            return;
        }
        if (!TextUtils.isEmpty(yuyinImBarragePayResponseMessage.getErrorString())) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), yuyinImBarragePayResponseMessage.getErrorString());
        }
        new c().refreshCurUserScores();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.live.im.data.a aVar) {
        int i;
        if (aVar.getMsgType() == 126) {
            if (this.mMessages == null) {
                this.mMessages = new ArrayList();
            }
            boolean d = d(aVar);
            if (d || this.mMessages.size() < com.baidu.live.z.a.Pq().bmJ.aMb) {
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
                    this.mMessages.add(i, aVar);
                } else {
                    this.mMessages.add(aVar);
                }
                CD();
            }
        }
    }

    private boolean c(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getMsgType() == 126;
    }

    private boolean d(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CD() {
        ce[] LI;
        ce ceVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.bJC.CK() && (LI = d.LG().LI()) != null) {
            com.baidu.live.im.data.a remove = this.mMessages.remove(0);
            int length = LI.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    ceVar = null;
                    break;
                }
                ceVar = LI[i];
                if (ceVar.id.equals(remove.LT())) {
                    break;
                }
                i++;
            }
            if (ceVar == null) {
                ceVar = new ce().Ev();
            }
            this.bJC.a(ceVar, remove.LO(), remove.getContent(), this.aEe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.a aVar) {
        if (aVar != null && this.aEc != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.aGK, aVar.aGL, aVar.aGM, String.valueOf(this.aEc.mLiveInfo.group_id), String.valueOf(this.aEc.mLiveInfo.live_id), this.aEd, String.valueOf(this.aEc.aIe.userId), aVar.appId, aVar.getNameShow(), "")));
        }
    }
}
