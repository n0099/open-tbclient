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
import com.baidu.live.data.br;
import com.baidu.live.data.r;
import com.baidu.live.gift.s;
import com.baidu.live.gift.t;
import com.baidu.live.gift.v;
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
/* loaded from: classes7.dex */
public class a implements com.baidu.live.im.b.a {
    private a.InterfaceC0175a aAg;
    private r aAh;
    private boolean aAi;
    private String aAj;
    private ImBarrageTrackView aAk;
    private CustomMessageListener aAl;
    private HttpMessageListener aAm;
    private CustomMessageListener aAn;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> aAo;
    private boolean aAp = false;
    private List<com.baidu.live.im.data.a> mMessages;
    private String mOtherParams;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
        initListener();
    }

    @Override // com.baidu.live.im.b.a
    public void a(a.InterfaceC0175a interfaceC0175a) {
        this.aAg = interfaceC0175a;
    }

    @Override // com.baidu.live.im.b.a
    public void a(r rVar, boolean z) {
        if (z) {
            if (!this.aAp) {
                this.aAp = true;
            } else {
                return;
            }
        }
        this.aAk.setCanAddNext();
        Ba();
        a(rVar);
        Bc();
        Bi();
    }

    @Override // com.baidu.live.im.b.a
    public void a(r rVar) {
        boolean z = false;
        this.aAh = rVar;
        this.aAi = false;
        if (this.aAh != null && this.aAh.mLiveInfo != null) {
            this.aAj = String.valueOf(this.aAh.aDE.userId);
            String valueOf = String.valueOf(this.aAh.mLiveInfo.user_id);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
                z = true;
            }
            this.aAi = z;
        }
    }

    @Override // com.baidu.live.im.b.a
    public View AZ() {
        return this.aAk;
    }

    @Override // com.baidu.live.im.b.a
    public void Ba() {
        if (this.aAk != null) {
            this.aAk.post(new Runnable() { // from class: com.baidu.live.barrage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.aAk.setVisibility(a.this.aAk.getTop() > 0 ? 0 : 4);
                }
            });
        }
    }

    @Override // com.baidu.live.im.b.a
    public void Bb() {
        Bd();
        Bj();
        this.aAh = null;
        if (this.mMessages != null) {
            this.mMessages.clear();
        }
        if (this.aAk != null) {
            this.aAk.release();
            if (this.aAk.getParent() != null) {
                ((ViewGroup) this.aAk.getParent()).removeView(this.aAk);
            }
        }
        this.aAp = false;
    }

    @Override // com.baidu.live.im.b.a
    public void release() {
        Bb();
        Bf();
        Bh();
        d.JD().release();
    }

    @Override // com.baidu.live.im.b.a
    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }

    private void initView() {
        this.aAk = new ImBarrageTrackView(this.mPageContext.getPageActivity());
        this.aAk.setCallback(new ImBarrageTrackView.a() { // from class: com.baidu.live.barrage.a.a.2
            @Override // com.baidu.live.barrage.view.ImBarrageTrackView.a
            public void b(com.baidu.live.data.a aVar) {
                a.this.a(aVar);
            }

            @Override // com.baidu.live.barrage.view.ImBarrageTrackView.a
            public void onNext() {
                a.this.Bl();
            }
        });
    }

    private void initListener() {
        Be();
        Bg();
    }

    private void Bc() {
        if (this.aAo == null) {
            this.aAo = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.live.barrage.a.a.3
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2913101, this.aAo);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void Bd() {
        MessageManager.getInstance().unRegisterTask(2913101);
    }

    private void Be() {
        this.aAl = new CustomMessageListener(2913102) { // from class: com.baidu.live.barrage.a.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(a.this.mPageContext.getPageActivity()) != 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    a.this.s((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aAl);
    }

    private void Bf() {
        if (this.aAl != null) {
            MessageManager.getInstance().unRegisterListener(this.aAl);
        }
    }

    private void Bg() {
        this.aAm = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.live.barrage.a.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021133 && (httpResponsedMessage instanceof ImBarragePayResponseMessage)) {
                    a.this.a((ImBarragePayResponseMessage) httpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aAm);
    }

    private void Bh() {
        if (this.aAm != null) {
            MessageManager.getInstance().unRegisterListener(this.aAm);
        }
    }

    private void Bi() {
        if (this.aAn == null) {
            this.aAn = new CustomMessageListener(2913037) { // from class: com.baidu.live.barrage.a.a.6
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
        MessageManager.getInstance().registerListener(this.aAn);
    }

    private void Bj() {
        if (this.aAn != null) {
            MessageManager.getInstance().unRegisterListener(this.aAn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImSendMsgData imSendMsgData) {
        if (imSendMsgData.msgType == 126) {
            if (imSendMsgData.barrageType == 1 && (imSendMsgData.barrageCardInfo == null || !imSendMsgData.barrageCardInfo.bcu)) {
                long j = imSendMsgData.price;
                if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                    Bk();
                    return;
                } else {
                    TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
        }
    }

    private void Bk() {
        if (this.aAg != null) {
            this.aAg.JC();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mPageContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(List list) {
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
        if (aVar.JO() == 1) {
            com.baidu.live.im.data.b JQ = aVar.JQ();
            if (JQ != null && JQ.bcu) {
                a(aVar.JP(), JQ);
            } else {
                b(aVar.getMsgId(), aVar.JP());
            }
        }
    }

    private void b(long j, String str) {
        String EZ = p.EZ();
        com.baidu.live.im.message.d dVar = new com.baidu.live.im.message.d();
        dVar.addParam("scene_from", EZ);
        dVar.addParam("live_id", this.aAh.mLiveInfo.live_id);
        dVar.addParam("im_id", j);
        dVar.addParam("barrage_id", str);
        MessageManager.getInstance().sendMessage(dVar);
    }

    private void a(String str, com.baidu.live.im.data.b bVar) {
        s sVar;
        Map<String, s> ER = t.EQ().ER();
        if (ER != null && ER.containsKey(str) && (sVar = ER.get(str)) != null) {
            v.c(sVar.itemId, sVar.aNt, bVar.bcv, bVar.liveId, 1, 0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImBarragePayResponseMessage imBarragePayResponseMessage) {
        if (imBarragePayResponseMessage.getError() == 0) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = imBarragePayResponseMessage.Hc();
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
            if (d || this.mMessages.size() < com.baidu.live.w.a.Nk().beH.aHb) {
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
                Bl();
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
    public void Bl() {
        br[] JE;
        br brVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.aAk.Bs() && (JE = d.JD().JE()) != null) {
            com.baidu.live.im.data.a remove = this.mMessages.remove(0);
            int length = JE.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    brVar = null;
                    break;
                }
                brVar = JE[i];
                if (brVar.id.equals(remove.JP())) {
                    break;
                }
                i++;
            }
            if (brVar == null) {
                brVar = new br().CZ();
            }
            this.aAk.a(brVar, remove.JK(), remove.getContent(), this.aAj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.a aVar) {
        if (aVar != null && this.aAh != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.aCM, aVar.aCN, aVar.aCO, String.valueOf(this.aAh.mLiveInfo.group_id), String.valueOf(this.aAh.mLiveInfo.live_id), this.aAi, String.valueOf(this.aAh.aDE.userId), aVar.appId, aVar.getNameShow(), "")));
        }
    }
}
