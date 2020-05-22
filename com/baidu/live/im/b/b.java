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
import com.baidu.live.data.bj;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class b implements l {
    private q aJj;
    private l.a aTa;
    private boolean aTb;
    private String aTc;
    private ImBarrageTrackView aTd;
    private CustomMessageListener aTe;
    private HttpMessageListener aTf;
    private CustomMessageListener aTg;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> aTh;
    private boolean aTi = false;
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
        this.aTa = aVar;
    }

    @Override // com.baidu.live.im.l
    public void a(q qVar, boolean z) {
        if (z) {
            if (!this.aTi) {
                this.aTi = true;
            } else {
                return;
            }
        }
        this.aTd.setCanAddNext();
        CJ();
        a(qVar);
        Dg();
        Dm();
    }

    @Override // com.baidu.live.im.l
    public void a(q qVar) {
        boolean z = false;
        this.aJj = qVar;
        this.aTb = false;
        if (this.aJj != null && this.aJj.mLiveInfo != null) {
            this.aTc = String.valueOf(this.aJj.avj.userId);
            String valueOf = String.valueOf(this.aJj.mLiveInfo.user_id);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
                z = true;
            }
            this.aTb = z;
        }
    }

    @Override // com.baidu.live.im.l
    public View CI() {
        return this.aTd;
    }

    @Override // com.baidu.live.im.l
    public void CJ() {
        if (this.aTd != null) {
            this.aTd.post(new Runnable() { // from class: com.baidu.live.im.b.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.aTd.setVisibility(b.this.aTd.getTop() > 0 ? 0 : 4);
                }
            });
        }
    }

    @Override // com.baidu.live.im.l
    public void BZ() {
        Dh();
        Dn();
        this.aJj = null;
        if (this.mMessages != null) {
            this.mMessages.clear();
        }
        if (this.aTd != null) {
            this.aTd.release();
            if (this.aTd.getParent() != null) {
                ((ViewGroup) this.aTd.getParent()).removeView(this.aTd);
            }
        }
        this.aTi = false;
    }

    @Override // com.baidu.live.im.l
    public void release() {
        BZ();
        Dj();
        Dl();
        m.CL().release();
    }

    @Override // com.baidu.live.im.l
    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }

    private void initView() {
        this.aTd = new ImBarrageTrackView(this.mPageContext.getPageActivity());
        this.aTd.setCallback(new ImBarrageTrackView.a() { // from class: com.baidu.live.im.b.b.2
            @Override // com.baidu.live.im.view.barrage.ImBarrageTrackView.a
            public void c(com.baidu.live.data.a aVar) {
                b.this.b(aVar);
            }

            @Override // com.baidu.live.im.view.barrage.ImBarrageTrackView.a
            public void onNext() {
                b.this.Dp();
            }
        });
    }

    private void initListener() {
        Di();
        Dk();
    }

    private void Dg() {
        if (this.aTh == null) {
            this.aTh = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.live.im.b.b.3
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2913101, this.aTh);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void Dh() {
        MessageManager.getInstance().unRegisterTask(2913101);
    }

    private void Di() {
        this.aTe = new CustomMessageListener(2913102) { // from class: com.baidu.live.im.b.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(b.this.mPageContext.getPageActivity()) != 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.G((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aTe);
    }

    private void Dj() {
        if (this.aTe != null) {
            MessageManager.getInstance().unRegisterListener(this.aTe);
        }
    }

    private void Dk() {
        this.aTf = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.live.im.b.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021133 && (httpResponsedMessage instanceof ImBarragePayResponseMessage)) {
                    b.this.a((ImBarragePayResponseMessage) httpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aTf);
    }

    private void Dl() {
        if (this.aTf != null) {
            MessageManager.getInstance().unRegisterListener(this.aTf);
        }
    }

    private void Dm() {
        if (this.aTg == null) {
            this.aTg = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.b.b.6
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
        MessageManager.getInstance().registerListener(this.aTg);
    }

    private void Dn() {
        if (this.aTg != null) {
            MessageManager.getInstance().unRegisterListener(this.aTg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImSendMsgData imSendMsgData) {
        if (imSendMsgData.msgType == 126) {
            if (imSendMsgData.barrageType == 1 && (imSendMsgData.barrageCardInfo == null || !imSendMsgData.barrageCardInfo.aTD)) {
                long j = imSendMsgData.price;
                if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                    Do();
                    return;
                } else {
                    TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
        }
    }

    private void Do() {
        if (this.aTa != null) {
            this.aTa.CK();
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
        if (aVar.DF() == 1) {
            com.baidu.live.im.data.b DH = aVar.DH();
            if (DH != null && DH.aTD) {
                a(aVar.DG(), DH);
            } else {
                d(aVar.getMsgId(), aVar.DG());
            }
        }
    }

    private void d(long j, String str) {
        String yu = com.baidu.live.utils.q.yu();
        com.baidu.live.im.message.d dVar = new com.baidu.live.im.message.d();
        dVar.addParam("scene_from", yu);
        dVar.addParam("live_id", this.aJj.mLiveInfo.live_id);
        dVar.addParam("im_id", j);
        dVar.addParam("barrage_id", str);
        MessageManager.getInstance().sendMessage(dVar);
    }

    private void a(String str, com.baidu.live.im.data.b bVar) {
        s sVar;
        Map<String, s> ym = t.yl().ym();
        if (ym != null && ym.containsKey(str) && (sVar = ym.get(str)) != null) {
            v.c(sVar.itemId, sVar.aEr, bVar.aTE, bVar.liveId, 1, 0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImBarragePayResponseMessage imBarragePayResponseMessage) {
        if (imBarragePayResponseMessage.getError() == 0) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = imBarragePayResponseMessage.Ax();
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
            if (r || this.mMessages.size() < com.baidu.live.v.a.Ge().aWF.ayp) {
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
                Dp();
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
    public void Dp() {
        bj[] CM;
        bj bjVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.aTd.Ey() && (CM = m.CL().CM()) != null) {
            com.baidu.live.im.data.a remove = this.mMessages.remove(0);
            int length = CM.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    bjVar = null;
                    break;
                }
                bjVar = CM[i];
                if (bjVar.id.equals(remove.DG())) {
                    break;
                }
                i++;
            }
            if (bjVar == null) {
                bjVar = new bj().wv();
            }
            this.aTd.a(bjVar, remove.DB(), remove.getContent(), this.aTc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.live.data.a aVar) {
        if (aVar != null && this.aJj != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.aur, aVar.aus, aVar.aut, String.valueOf(this.aJj.mLiveInfo.group_id), String.valueOf(this.aJj.mLiveInfo.live_id), this.aTb, String.valueOf(this.aJj.avj.userId), aVar.appId, aVar.getNameShow(), "")));
        }
    }
}
