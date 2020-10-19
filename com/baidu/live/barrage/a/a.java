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
import com.baidu.live.data.bz;
import com.baidu.live.data.u;
import com.baidu.live.gift.t;
import com.baidu.live.gift.w;
import com.baidu.live.im.b.a;
import com.baidu.live.im.b.d;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.message.ImBarragePayResponseMessage;
import com.baidu.live.l.c;
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
    private a.InterfaceC0185a aDT;
    private u aDU;
    private boolean aDV;
    private String aDW;
    private ImBarrageTrackView aDX;
    private CustomMessageListener aDY;
    private HttpMessageListener aDZ;
    private CustomMessageListener aEa;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> aEb;
    private boolean aEc = false;
    private List<com.baidu.live.im.data.a> mMessages;
    private String mOtherParams;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
        initListener();
    }

    @Override // com.baidu.live.im.b.a
    public void a(a.InterfaceC0185a interfaceC0185a) {
        this.aDT = interfaceC0185a;
    }

    @Override // com.baidu.live.im.b.a
    public void a(u uVar, boolean z) {
        if (z) {
            if (!this.aEc) {
                this.aEc = true;
            } else {
                return;
            }
        }
        this.aDX.setCanAddNext();
        Cm();
        a(uVar);
        Co();
        Cu();
    }

    @Override // com.baidu.live.im.b.a
    public void a(u uVar) {
        boolean z = false;
        this.aDU = uVar;
        this.aDV = false;
        if (this.aDU != null && this.aDU.mLiveInfo != null) {
            this.aDW = String.valueOf(this.aDU.aHD.userId);
            String valueOf = String.valueOf(this.aDU.mLiveInfo.user_id);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
                z = true;
            }
            this.aDV = z;
        }
    }

    @Override // com.baidu.live.im.b.a
    public View Cl() {
        return this.aDX;
    }

    @Override // com.baidu.live.im.b.a
    public void Cm() {
        if (this.aDX != null) {
            this.aDX.post(new Runnable() { // from class: com.baidu.live.barrage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.aDX.setVisibility(a.this.aDX.getTop() > 0 ? 0 : 4);
                }
            });
        }
    }

    @Override // com.baidu.live.im.b.a
    public void Cn() {
        Cp();
        Cv();
        this.aDU = null;
        if (this.mMessages != null) {
            this.mMessages.clear();
        }
        if (this.aDX != null) {
            this.aDX.release();
            if (this.aDX.getParent() != null) {
                ((ViewGroup) this.aDX.getParent()).removeView(this.aDX);
            }
        }
        this.aEc = false;
    }

    @Override // com.baidu.live.im.b.a
    public void release() {
        Cn();
        Cr();
        Ct();
        d.Lm().release();
    }

    @Override // com.baidu.live.im.b.a
    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }

    private void initView() {
        this.aDX = new ImBarrageTrackView(this.mPageContext.getPageActivity());
        this.aDX.setCallback(new ImBarrageTrackView.a() { // from class: com.baidu.live.barrage.a.a.2
            @Override // com.baidu.live.barrage.view.ImBarrageTrackView.a
            public void b(com.baidu.live.data.a aVar) {
                a.this.a(aVar);
            }

            @Override // com.baidu.live.barrage.view.ImBarrageTrackView.a
            public void onNext() {
                a.this.Cx();
            }
        });
    }

    private void initListener() {
        Cq();
        Cs();
    }

    private void Co() {
        if (this.aEb == null) {
            this.aEb = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.live.barrage.a.a.3
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2913101, this.aEb);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void Cp() {
        MessageManager.getInstance().unRegisterTask(2913101);
    }

    private void Cq() {
        this.aDY = new CustomMessageListener(2913102) { // from class: com.baidu.live.barrage.a.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(a.this.mPageContext.getPageActivity()) != 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    a.this.u((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aDY);
    }

    private void Cr() {
        if (this.aDY != null) {
            MessageManager.getInstance().unRegisterListener(this.aDY);
        }
    }

    private void Cs() {
        this.aDZ = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.live.barrage.a.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021133 && (httpResponsedMessage instanceof ImBarragePayResponseMessage)) {
                    a.this.a((ImBarragePayResponseMessage) httpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aDZ);
    }

    private void Ct() {
        if (this.aDZ != null) {
            MessageManager.getInstance().unRegisterListener(this.aDZ);
        }
    }

    private void Cu() {
        if (this.aEa == null) {
            this.aEa = new CustomMessageListener(2913037) { // from class: com.baidu.live.barrage.a.a.6
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
        MessageManager.getInstance().registerListener(this.aEa);
    }

    private void Cv() {
        if (this.aEa != null) {
            MessageManager.getInstance().unRegisterListener(this.aEa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImSendMsgData imSendMsgData) {
        if (imSendMsgData.msgType == 126) {
            if (imSendMsgData.barrageType == 1 && (imSendMsgData.barrageCardInfo == null || !imSendMsgData.barrageCardInfo.biU)) {
                long j = imSendMsgData.price;
                if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                    Cw();
                    return;
                } else {
                    TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
        }
    }

    private void Cw() {
        if (this.aDT != null) {
            this.aDT.Ll();
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
        if (aVar.Lx() == 1) {
            com.baidu.live.im.data.b Lz = aVar.Lz();
            if (Lz != null && Lz.biU) {
                a(aVar.Ly(), Lz, aVar.biS);
            } else {
                c(aVar.getMsgId(), aVar.Ly());
            }
        }
    }

    private void c(long j, String str) {
        String Gv = p.Gv();
        com.baidu.live.im.message.d dVar = new com.baidu.live.im.message.d();
        dVar.addParam("scene_from", Gv);
        dVar.addParam("live_id", this.aDU.mLiveInfo.live_id);
        dVar.addParam("im_id", j);
        dVar.addParam("barrage_id", str);
        MessageManager.getInstance().sendMessage(dVar);
    }

    private void a(String str, com.baidu.live.im.data.b bVar, String str2) {
        t tVar;
        Map<String, t> Gh = com.baidu.live.gift.u.Gg().Gh();
        if (Gh != null && Gh.containsKey(str) && (tVar = Gh.get(str)) != null) {
            w.b(tVar.itemId, tVar.aSF, bVar.biV, bVar.liveId, 1, 0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImBarragePayResponseMessage imBarragePayResponseMessage) {
        if (imBarragePayResponseMessage.getError() == 0) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = imBarragePayResponseMessage.Iz();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
            return;
        }
        if (!TextUtils.isEmpty(imBarragePayResponseMessage.getErrorString())) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), imBarragePayResponseMessage.getErrorString());
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
            if (d || this.mMessages.size() < com.baidu.live.x.a.OS().blo.aLx) {
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
                Cx();
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
    public void Cx() {
        bz[] Ln;
        bz bzVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.aDX.CE() && (Ln = d.Lm().Ln()) != null) {
            com.baidu.live.im.data.a remove = this.mMessages.remove(0);
            int length = Ln.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    bzVar = null;
                    break;
                }
                bzVar = Ln[i];
                if (bzVar.id.equals(remove.Ly())) {
                    break;
                }
                i++;
            }
            if (bzVar == null) {
                bzVar = new bz().Em();
            }
            this.aDX.a(bzVar, remove.Lt(), remove.getContent(), this.aDW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.a aVar) {
        if (aVar != null && this.aDU != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.aGC, aVar.aGD, aVar.aGE, String.valueOf(this.aDU.mLiveInfo.group_id), String.valueOf(this.aDU.mLiveInfo.live_id), this.aDV, String.valueOf(this.aDU.aHD.userId), aVar.appId, aVar.getNameShow(), "")));
        }
    }
}
