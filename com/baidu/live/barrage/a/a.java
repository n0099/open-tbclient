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
import com.baidu.live.data.bp;
import com.baidu.live.data.q;
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
/* loaded from: classes4.dex */
public class a implements com.baidu.live.im.b.a {
    private a.InterfaceC0167a ave;
    private q avf;
    private boolean avg;
    private String avh;
    private ImBarrageTrackView avi;
    private CustomMessageListener avj;
    private HttpMessageListener avk;
    private CustomMessageListener avl;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> avm;
    private boolean avn = false;
    private List<com.baidu.live.im.data.a> mMessages;
    private String mOtherParams;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
        initListener();
    }

    @Override // com.baidu.live.im.b.a
    public void a(a.InterfaceC0167a interfaceC0167a) {
        this.ave = interfaceC0167a;
    }

    @Override // com.baidu.live.im.b.a
    public void a(q qVar, boolean z) {
        if (z) {
            if (!this.avn) {
                this.avn = true;
            } else {
                return;
            }
        }
        this.avi.setCanAddNext();
        vC();
        a(qVar);
        vE();
        vK();
    }

    @Override // com.baidu.live.im.b.a
    public void a(q qVar) {
        boolean z = false;
        this.avf = qVar;
        this.avg = false;
        if (this.avf != null && this.avf.mLiveInfo != null) {
            this.avh = String.valueOf(this.avf.ayC.userId);
            String valueOf = String.valueOf(this.avf.mLiveInfo.user_id);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
                z = true;
            }
            this.avg = z;
        }
    }

    @Override // com.baidu.live.im.b.a
    public View vB() {
        return this.avi;
    }

    @Override // com.baidu.live.im.b.a
    public void vC() {
        if (this.avi != null) {
            this.avi.post(new Runnable() { // from class: com.baidu.live.barrage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.avi.setVisibility(a.this.avi.getTop() > 0 ? 0 : 4);
                }
            });
        }
    }

    @Override // com.baidu.live.im.b.a
    public void vD() {
        vF();
        vL();
        this.avf = null;
        if (this.mMessages != null) {
            this.mMessages.clear();
        }
        if (this.avi != null) {
            this.avi.release();
            if (this.avi.getParent() != null) {
                ((ViewGroup) this.avi.getParent()).removeView(this.avi);
            }
        }
        this.avn = false;
    }

    @Override // com.baidu.live.im.b.a
    public void release() {
        vD();
        vH();
        vJ();
        d.Ea().release();
    }

    @Override // com.baidu.live.im.b.a
    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }

    private void initView() {
        this.avi = new ImBarrageTrackView(this.mPageContext.getPageActivity());
        this.avi.setCallback(new ImBarrageTrackView.a() { // from class: com.baidu.live.barrage.a.a.2
            @Override // com.baidu.live.barrage.view.ImBarrageTrackView.a
            public void b(com.baidu.live.data.a aVar) {
                a.this.a(aVar);
            }

            @Override // com.baidu.live.barrage.view.ImBarrageTrackView.a
            public void onNext() {
                a.this.vN();
            }
        });
    }

    private void initListener() {
        vG();
        vI();
    }

    private void vE() {
        if (this.avm == null) {
            this.avm = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.live.barrage.a.a.3
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2913101, this.avm);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void vF() {
        MessageManager.getInstance().unRegisterTask(2913101);
    }

    private void vG() {
        this.avj = new CustomMessageListener(2913102) { // from class: com.baidu.live.barrage.a.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(a.this.mPageContext.getPageActivity()) != 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    a.this.r((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.avj);
    }

    private void vH() {
        if (this.avj != null) {
            MessageManager.getInstance().unRegisterListener(this.avj);
        }
    }

    private void vI() {
        this.avk = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.live.barrage.a.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021133 && (httpResponsedMessage instanceof ImBarragePayResponseMessage)) {
                    a.this.a((ImBarragePayResponseMessage) httpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.avk);
    }

    private void vJ() {
        if (this.avk != null) {
            MessageManager.getInstance().unRegisterListener(this.avk);
        }
    }

    private void vK() {
        if (this.avl == null) {
            this.avl = new CustomMessageListener(2913037) { // from class: com.baidu.live.barrage.a.a.6
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
        MessageManager.getInstance().registerListener(this.avl);
    }

    private void vL() {
        if (this.avl != null) {
            MessageManager.getInstance().unRegisterListener(this.avl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImSendMsgData imSendMsgData) {
        if (imSendMsgData.msgType == 126) {
            if (imSendMsgData.barrageType == 1 && (imSendMsgData.barrageCardInfo == null || !imSendMsgData.barrageCardInfo.aXe)) {
                long j = imSendMsgData.price;
                if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                    vM();
                    return;
                } else {
                    TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
        }
    }

    private void vM() {
        if (this.ave != null) {
            this.ave.DZ();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mPageContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(List list) {
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
        if (aVar.El() == 1) {
            com.baidu.live.im.data.b En = aVar.En();
            if (En != null && En.aXe) {
                a(aVar.Em(), En);
            } else {
                b(aVar.getMsgId(), aVar.Em());
            }
        }
    }

    private void b(long j, String str) {
        String zw = p.zw();
        com.baidu.live.im.message.d dVar = new com.baidu.live.im.message.d();
        dVar.addParam("scene_from", zw);
        dVar.addParam("live_id", this.avf.mLiveInfo.live_id);
        dVar.addParam("im_id", j);
        dVar.addParam("barrage_id", str);
        MessageManager.getInstance().sendMessage(dVar);
    }

    private void a(String str, com.baidu.live.im.data.b bVar) {
        s sVar;
        Map<String, s> zo = t.zn().zo();
        if (zo != null && zo.containsKey(str) && (sVar = zo.get(str)) != null) {
            v.c(sVar.itemId, sVar.aIi, bVar.aXf, bVar.liveId, 1, 0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImBarragePayResponseMessage imBarragePayResponseMessage) {
        if (imBarragePayResponseMessage.getError() == 0) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = imBarragePayResponseMessage.Bz();
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
            if (d || this.mMessages.size() < com.baidu.live.v.a.Hs().aZn.aBR) {
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
                vN();
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
    public void vN() {
        bp[] Eb;
        bp bpVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.avi.vU() && (Eb = d.Ea().Eb()) != null) {
            com.baidu.live.im.data.a remove = this.mMessages.remove(0);
            int length = Eb.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    bpVar = null;
                    break;
                }
                bpVar = Eb[i];
                if (bpVar.id.equals(remove.Em())) {
                    break;
                }
                i++;
            }
            if (bpVar == null) {
                bpVar = new bp().xw();
            }
            this.avi.a(bpVar, remove.Eh(), remove.getContent(), this.avh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.a aVar) {
        if (aVar != null && this.avf != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.axK, aVar.axL, aVar.axM, String.valueOf(this.avf.mLiveInfo.group_id), String.valueOf(this.avf.mLiveInfo.live_id), this.avg, String.valueOf(this.avf.ayC.userId), aVar.appId, aVar.getNameShow(), "")));
        }
    }
}
