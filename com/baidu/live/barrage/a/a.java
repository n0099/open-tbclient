package com.baidu.live.barrage.a;

import android.text.TextUtils;
import android.util.Log;
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
import com.baidu.live.data.ab;
import com.baidu.live.data.cr;
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
import com.baidu.live.utils.q;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes11.dex */
public class a implements com.baidu.live.im.b.a {
    private a.InterfaceC0179a aDc;
    private ab aDd;
    private boolean aDe;
    private String aDf;
    private ImBarrageTrackView aDg;
    private CustomMessageListener aDh;
    private HttpMessageListener aDi;
    private CustomMessageListener aDj;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> aDk;
    private boolean aDl = false;
    private CustomMessageListener aDm = new CustomMessageListener(2913300) { // from class: com.baidu.live.barrage.a.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Log.i("memoryMonitor", "@@ memoryMonitor ImBarrageController @memoryMonitorCleanListener");
            if (a.this.mMessages != null) {
                a.this.mMessages.clear();
            }
        }
    };
    private List<com.baidu.live.im.data.b> mMessages;
    private String mOtherParams;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
        initListener();
        MessageManager.getInstance().registerListener(this.aDm);
    }

    @Override // com.baidu.live.im.b.a
    public void a(a.InterfaceC0179a interfaceC0179a) {
        this.aDc = interfaceC0179a;
    }

    @Override // com.baidu.live.im.b.a
    public void a(ab abVar, boolean z) {
        if (z) {
            if (!this.aDl) {
                this.aDl = true;
            } else {
                return;
            }
        }
        this.aDg.setCanAddNext();
        zQ();
        a(abVar);
        zS();
        zY();
    }

    @Override // com.baidu.live.im.b.a
    public void a(ab abVar) {
        boolean z = false;
        this.aDd = abVar;
        this.aDe = false;
        if (this.aDd != null && this.aDd.mLiveInfo != null) {
            this.aDf = String.valueOf(this.aDd.aId.userId);
            String valueOf = String.valueOf(this.aDd.mLiveInfo.user_id);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
                z = true;
            }
            this.aDe = z;
        }
    }

    @Override // com.baidu.live.im.b.a
    public View zP() {
        return this.aDg;
    }

    @Override // com.baidu.live.im.b.a
    public void zQ() {
        if (this.aDg != null) {
            this.aDg.post(new Runnable() { // from class: com.baidu.live.barrage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.aDg.setVisibility(a.this.aDg.getTop() > 0 ? 0 : 4);
                }
            });
        }
    }

    @Override // com.baidu.live.im.b.a
    public void zR() {
        zT();
        zZ();
        this.aDd = null;
        if (this.mMessages != null) {
            this.mMessages.clear();
        }
        if (this.aDg != null) {
            this.aDg.release();
            if (this.aDg.getParent() != null) {
                ((ViewGroup) this.aDg.getParent()).removeView(this.aDg);
            }
        }
        this.aDl = false;
    }

    @Override // com.baidu.live.im.b.a
    public void release() {
        zR();
        zV();
        zX();
        d.KN().release();
        MessageManager.getInstance().unRegisterListener(this.aDm);
    }

    @Override // com.baidu.live.im.b.a
    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }

    private void initView() {
        this.aDg = new ImBarrageTrackView(this.mPageContext.getPageActivity());
        this.aDg.setCallback(new ImBarrageTrackView.a() { // from class: com.baidu.live.barrage.a.a.2
            @Override // com.baidu.live.barrage.view.ImBarrageTrackView.a
            public void b(com.baidu.live.data.a aVar) {
                a.this.a(aVar);
            }

            @Override // com.baidu.live.barrage.view.ImBarrageTrackView.a
            public void onNext() {
                a.this.Ab();
            }
        });
    }

    private void initListener() {
        zU();
        zW();
    }

    private void zS() {
        if (this.aDk == null) {
            this.aDk = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.live.barrage.a.a.3
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2913101, this.aDk);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void zT() {
        MessageManager.getInstance().unRegisterTask(2913101);
    }

    private void zU() {
        this.aDh = new CustomMessageListener(2913102) { // from class: com.baidu.live.barrage.a.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(a.this.mPageContext.getPageActivity()) != 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    a.this.v((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aDh);
    }

    private void zV() {
        if (this.aDh != null) {
            MessageManager.getInstance().unRegisterListener(this.aDh);
        }
    }

    private void zW() {
        this.aDi = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.live.barrage.a.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021133 && (httpResponsedMessage instanceof ImBarragePayResponseMessage)) {
                    a.this.a((ImBarragePayResponseMessage) httpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aDi);
    }

    private void zX() {
        if (this.aDi != null) {
            MessageManager.getInstance().unRegisterListener(this.aDi);
        }
    }

    private void zY() {
        if (this.aDj == null) {
            this.aDj = new CustomMessageListener(2913037) { // from class: com.baidu.live.barrage.a.a.6
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
        MessageManager.getInstance().registerListener(this.aDj);
    }

    private void zZ() {
        if (this.aDj != null) {
            MessageManager.getInstance().unRegisterListener(this.aDj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImSendMsgData imSendMsgData) {
        if (imSendMsgData.msgType == 126) {
            if (imSendMsgData.barrageType == 1 && (imSendMsgData.barrageCardInfo == null || !imSendMsgData.barrageCardInfo.bps)) {
                long j = imSendMsgData.price;
                imSendMsgData.isUseCard = false;
                if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                    Aa();
                    return;
                } else {
                    TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
        }
    }

    private void Aa() {
        if (this.aDc != null) {
            this.aDc.KM();
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
        if (bVar.Ld() == 1) {
            com.baidu.live.im.data.d Lf = bVar.Lf();
            if (Lf != null && Lf.bps) {
                a(bVar.Le(), Lf, bVar.bno);
            } else {
                f(bVar.getMsgId(), bVar.Le());
            }
        }
    }

    private void f(long j, String str) {
        String Fv = q.Fv();
        com.baidu.live.im.message.d dVar = new com.baidu.live.im.message.d();
        dVar.addParam("scene_from", Fv);
        dVar.addParam("live_id", this.aDd.mLiveInfo.live_id);
        dVar.addParam("im_id", j);
        dVar.addParam("barrage_id", str);
        MessageManager.getInstance().sendMessage(dVar);
    }

    private void a(String str, com.baidu.live.im.data.d dVar, String str2) {
        y yVar;
        Map<String, y> Ff = z.Fe().Ff();
        if (Ff != null && Ff.containsKey(str) && (yVar = Ff.get(str)) != null) {
            ac.b(yVar.itemId, yVar.aWl, dVar.bdf, dVar.liveId, 1, 0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImBarragePayResponseMessage imBarragePayResponseMessage) {
        if (imBarragePayResponseMessage.getError() == 0) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = imBarragePayResponseMessage.HG();
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
            if (d || this.mMessages.size() < com.baidu.live.ae.a.Qj().buX.aMS) {
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
                Ab();
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
    public void Ab() {
        cr[] KO;
        cr crVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.aDg.Ai() && (KO = d.KN().KO()) != null && KO.length > 0) {
            com.baidu.live.im.data.b remove = this.mMessages.remove(0);
            int length = KO.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    crVar = null;
                    break;
                }
                crVar = KO[i];
                if (crVar.id.equals(remove.Le())) {
                    break;
                }
                i++;
            }
            if (crVar == null) {
                crVar = new cr().CL();
            }
            this.aDg.a(crVar, remove.KZ(), remove.getContent(), this.aDf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.a aVar) {
        if (aVar != null && this.aDd != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.aFT, aVar.aFU, aVar.aFV, String.valueOf(this.aDd.mLiveInfo.group_id), String.valueOf(this.aDd.mLiveInfo.live_id), this.aDe, String.valueOf(this.aDd.aId.userId), aVar.appId, aVar.getNameShow())));
        }
    }
}
