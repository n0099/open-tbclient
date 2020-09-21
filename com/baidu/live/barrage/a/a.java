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
    private a.InterfaceC0177a aAO;
    private u aAP;
    private boolean aAQ;
    private String aAR;
    private ImBarrageTrackView aAS;
    private CustomMessageListener aAT;
    private HttpMessageListener aAU;
    private CustomMessageListener aAV;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> aAW;
    private boolean aAX = false;
    private List<com.baidu.live.im.data.a> mMessages;
    private String mOtherParams;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
        initListener();
    }

    @Override // com.baidu.live.im.b.a
    public void a(a.InterfaceC0177a interfaceC0177a) {
        this.aAO = interfaceC0177a;
    }

    @Override // com.baidu.live.im.b.a
    public void a(u uVar, boolean z) {
        if (z) {
            if (!this.aAX) {
                this.aAX = true;
            } else {
                return;
            }
        }
        this.aAS.setCanAddNext();
        Bp();
        a(uVar);
        Br();
        Bx();
    }

    @Override // com.baidu.live.im.b.a
    public void a(u uVar) {
        boolean z = false;
        this.aAP = uVar;
        this.aAQ = false;
        if (this.aAP != null && this.aAP.mLiveInfo != null) {
            this.aAR = String.valueOf(this.aAP.aEz.userId);
            String valueOf = String.valueOf(this.aAP.mLiveInfo.user_id);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
                z = true;
            }
            this.aAQ = z;
        }
    }

    @Override // com.baidu.live.im.b.a
    public View Bo() {
        return this.aAS;
    }

    @Override // com.baidu.live.im.b.a
    public void Bp() {
        if (this.aAS != null) {
            this.aAS.post(new Runnable() { // from class: com.baidu.live.barrage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.aAS.setVisibility(a.this.aAS.getTop() > 0 ? 0 : 4);
                }
            });
        }
    }

    @Override // com.baidu.live.im.b.a
    public void Bq() {
        Bs();
        By();
        this.aAP = null;
        if (this.mMessages != null) {
            this.mMessages.clear();
        }
        if (this.aAS != null) {
            this.aAS.release();
            if (this.aAS.getParent() != null) {
                ((ViewGroup) this.aAS.getParent()).removeView(this.aAS);
            }
        }
        this.aAX = false;
    }

    @Override // com.baidu.live.im.b.a
    public void release() {
        Bq();
        Bu();
        Bw();
        d.Kh().release();
    }

    @Override // com.baidu.live.im.b.a
    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }

    private void initView() {
        this.aAS = new ImBarrageTrackView(this.mPageContext.getPageActivity());
        this.aAS.setCallback(new ImBarrageTrackView.a() { // from class: com.baidu.live.barrage.a.a.2
            @Override // com.baidu.live.barrage.view.ImBarrageTrackView.a
            public void b(com.baidu.live.data.a aVar) {
                a.this.a(aVar);
            }

            @Override // com.baidu.live.barrage.view.ImBarrageTrackView.a
            public void onNext() {
                a.this.BA();
            }
        });
    }

    private void initListener() {
        Bt();
        Bv();
    }

    private void Br() {
        if (this.aAW == null) {
            this.aAW = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.live.barrage.a.a.3
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2913101, this.aAW);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void Bs() {
        MessageManager.getInstance().unRegisterTask(2913101);
    }

    private void Bt() {
        this.aAT = new CustomMessageListener(2913102) { // from class: com.baidu.live.barrage.a.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(a.this.mPageContext.getPageActivity()) != 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    a.this.s((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aAT);
    }

    private void Bu() {
        if (this.aAT != null) {
            MessageManager.getInstance().unRegisterListener(this.aAT);
        }
    }

    private void Bv() {
        this.aAU = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.live.barrage.a.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021133 && (httpResponsedMessage instanceof ImBarragePayResponseMessage)) {
                    a.this.a((ImBarragePayResponseMessage) httpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aAU);
    }

    private void Bw() {
        if (this.aAU != null) {
            MessageManager.getInstance().unRegisterListener(this.aAU);
        }
    }

    private void Bx() {
        if (this.aAV == null) {
            this.aAV = new CustomMessageListener(2913037) { // from class: com.baidu.live.barrage.a.a.6
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
        MessageManager.getInstance().registerListener(this.aAV);
    }

    private void By() {
        if (this.aAV != null) {
            MessageManager.getInstance().unRegisterListener(this.aAV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImSendMsgData imSendMsgData) {
        if (imSendMsgData.msgType == 126) {
            if (imSendMsgData.barrageType == 1 && (imSendMsgData.barrageCardInfo == null || !imSendMsgData.barrageCardInfo.bfi)) {
                long j = imSendMsgData.price;
                if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                    Bz();
                    return;
                } else {
                    TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
        }
    }

    private void Bz() {
        if (this.aAO != null) {
            this.aAO.Kg();
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
        if (aVar.Ks() == 1) {
            com.baidu.live.im.data.b Ku = aVar.Ku();
            if (Ku != null && Ku.bfi) {
                a(aVar.Kt(), Ku, aVar.bfg);
            } else {
                b(aVar.getMsgId(), aVar.Kt());
            }
        }
    }

    private void b(long j, String str) {
        String Fz = p.Fz();
        com.baidu.live.im.message.d dVar = new com.baidu.live.im.message.d();
        dVar.addParam("scene_from", Fz);
        dVar.addParam("live_id", this.aAP.mLiveInfo.live_id);
        dVar.addParam("im_id", j);
        dVar.addParam("barrage_id", str);
        MessageManager.getInstance().sendMessage(dVar);
    }

    private void a(String str, com.baidu.live.im.data.b bVar, String str2) {
        t tVar;
        Map<String, t> Fl = com.baidu.live.gift.u.Fk().Fl();
        if (Fl != null && Fl.containsKey(str) && (tVar = Fl.get(str)) != null) {
            w.b(tVar.itemId, tVar.aPu, bVar.bfj, bVar.liveId, 1, 0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImBarragePayResponseMessage imBarragePayResponseMessage) {
        if (imBarragePayResponseMessage.getError() == 0) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = imBarragePayResponseMessage.HC();
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
            if (d || this.mMessages.size() < com.baidu.live.x.a.NN().bhy.aIt) {
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
                BA();
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
    public void BA() {
        bz[] Ki;
        bz bzVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.aAS.BH() && (Ki = d.Kh().Ki()) != null) {
            com.baidu.live.im.data.a remove = this.mMessages.remove(0);
            int length = Ki.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    bzVar = null;
                    break;
                }
                bzVar = Ki[i];
                if (bzVar.id.equals(remove.Kt())) {
                    break;
                }
                i++;
            }
            if (bzVar == null) {
                bzVar = new bz().Dp();
            }
            this.aAS.a(bzVar, remove.Ko(), remove.getContent(), this.aAR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.a aVar) {
        if (aVar != null && this.aAP != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.aDy, aVar.aDz, aVar.aDA, String.valueOf(this.aAP.mLiveInfo.group_id), String.valueOf(this.aAP.mLiveInfo.live_id), this.aAQ, String.valueOf(this.aAP.aEz.userId), aVar.appId, aVar.getNameShow(), "")));
        }
    }
}
