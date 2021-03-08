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
/* loaded from: classes10.dex */
public class a implements com.baidu.live.im.b.a {
    private a.InterfaceC0185a aEC;
    private ab aED;
    private boolean aEE;
    private String aEF;
    private ImBarrageTrackView aEG;
    private CustomMessageListener aEH;
    private HttpMessageListener aEI;
    private CustomMessageListener aEJ;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> aEK;
    private boolean aEL = false;
    private CustomMessageListener aEM = new CustomMessageListener(2913300) { // from class: com.baidu.live.barrage.a.a.7
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
        MessageManager.getInstance().registerListener(this.aEM);
    }

    @Override // com.baidu.live.im.b.a
    public void a(a.InterfaceC0185a interfaceC0185a) {
        this.aEC = interfaceC0185a;
    }

    @Override // com.baidu.live.im.b.a
    public void a(ab abVar, boolean z) {
        if (z) {
            if (!this.aEL) {
                this.aEL = true;
            } else {
                return;
            }
        }
        this.aEG.setCanAddNext();
        zT();
        a(abVar);
        zV();
        Ab();
    }

    @Override // com.baidu.live.im.b.a
    public void a(ab abVar) {
        boolean z = false;
        this.aED = abVar;
        this.aEE = false;
        if (this.aED != null && this.aED.mLiveInfo != null) {
            this.aEF = String.valueOf(this.aED.aJD.userId);
            String valueOf = String.valueOf(this.aED.mLiveInfo.user_id);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
                z = true;
            }
            this.aEE = z;
        }
    }

    @Override // com.baidu.live.im.b.a
    public View zS() {
        return this.aEG;
    }

    @Override // com.baidu.live.im.b.a
    public void zT() {
        if (this.aEG != null) {
            this.aEG.post(new Runnable() { // from class: com.baidu.live.barrage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.aEG.setVisibility(a.this.aEG.getTop() > 0 ? 0 : 4);
                }
            });
        }
    }

    @Override // com.baidu.live.im.b.a
    public void zU() {
        zW();
        Ac();
        this.aED = null;
        if (this.mMessages != null) {
            this.mMessages.clear();
        }
        if (this.aEG != null) {
            this.aEG.release();
            if (this.aEG.getParent() != null) {
                ((ViewGroup) this.aEG.getParent()).removeView(this.aEG);
            }
        }
        this.aEL = false;
    }

    @Override // com.baidu.live.im.b.a
    public void release() {
        zU();
        zY();
        Aa();
        d.KQ().release();
        MessageManager.getInstance().unRegisterListener(this.aEM);
    }

    @Override // com.baidu.live.im.b.a
    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }

    private void initView() {
        this.aEG = new ImBarrageTrackView(this.mPageContext.getPageActivity());
        this.aEG.setCallback(new ImBarrageTrackView.a() { // from class: com.baidu.live.barrage.a.a.2
            @Override // com.baidu.live.barrage.view.ImBarrageTrackView.a
            public void b(com.baidu.live.data.a aVar) {
                a.this.a(aVar);
            }

            @Override // com.baidu.live.barrage.view.ImBarrageTrackView.a
            public void onNext() {
                a.this.Ae();
            }
        });
    }

    private void initListener() {
        zX();
        zZ();
    }

    private void zV() {
        if (this.aEK == null) {
            this.aEK = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.live.barrage.a.a.3
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2913101, this.aEK);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void zW() {
        MessageManager.getInstance().unRegisterTask(2913101);
    }

    private void zX() {
        this.aEH = new CustomMessageListener(2913102) { // from class: com.baidu.live.barrage.a.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(a.this.mPageContext.getPageActivity()) != 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    a.this.v((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aEH);
    }

    private void zY() {
        if (this.aEH != null) {
            MessageManager.getInstance().unRegisterListener(this.aEH);
        }
    }

    private void zZ() {
        this.aEI = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.live.barrage.a.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021133 && (httpResponsedMessage instanceof ImBarragePayResponseMessage)) {
                    a.this.a((ImBarragePayResponseMessage) httpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aEI);
    }

    private void Aa() {
        if (this.aEI != null) {
            MessageManager.getInstance().unRegisterListener(this.aEI);
        }
    }

    private void Ab() {
        if (this.aEJ == null) {
            this.aEJ = new CustomMessageListener(2913037) { // from class: com.baidu.live.barrage.a.a.6
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
        MessageManager.getInstance().registerListener(this.aEJ);
    }

    private void Ac() {
        if (this.aEJ != null) {
            MessageManager.getInstance().unRegisterListener(this.aEJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImSendMsgData imSendMsgData) {
        if (imSendMsgData.msgType == 126) {
            if (imSendMsgData.barrageType == 1 && (imSendMsgData.barrageCardInfo == null || !imSendMsgData.barrageCardInfo.bqS)) {
                long j = imSendMsgData.price;
                imSendMsgData.isUseCard = false;
                if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                    Ad();
                    return;
                } else {
                    TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
        }
    }

    private void Ad() {
        if (this.aEC != null) {
            this.aEC.KP();
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
        if (bVar.Lg() == 1) {
            com.baidu.live.im.data.d Li = bVar.Li();
            if (Li != null && Li.bqS) {
                a(bVar.Lh(), Li, bVar.boO);
            } else {
                f(bVar.getMsgId(), bVar.Lh());
            }
        }
    }

    private void f(long j, String str) {
        String Fy = q.Fy();
        com.baidu.live.im.message.d dVar = new com.baidu.live.im.message.d();
        dVar.addParam("scene_from", Fy);
        dVar.addParam("live_id", this.aED.mLiveInfo.live_id);
        dVar.addParam("im_id", j);
        dVar.addParam("barrage_id", str);
        MessageManager.getInstance().sendMessage(dVar);
    }

    private void a(String str, com.baidu.live.im.data.d dVar, String str2) {
        y yVar;
        Map<String, y> Fi = z.Fh().Fi();
        if (Fi != null && Fi.containsKey(str) && (yVar = Fi.get(str)) != null) {
            ac.b(yVar.itemId, yVar.aXL, dVar.beH, dVar.liveId, 1, 0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImBarragePayResponseMessage imBarragePayResponseMessage) {
        if (imBarragePayResponseMessage.getError() == 0) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = imBarragePayResponseMessage.HJ();
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
            if (d || this.mMessages.size() < com.baidu.live.ae.a.Qm().bwx.aOs) {
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
                Ae();
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
    public void Ae() {
        cr[] KR;
        cr crVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.aEG.Al() && (KR = d.KQ().KR()) != null && KR.length > 0) {
            com.baidu.live.im.data.b remove = this.mMessages.remove(0);
            int length = KR.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    crVar = null;
                    break;
                }
                crVar = KR[i];
                if (crVar.id.equals(remove.Lh())) {
                    break;
                }
                i++;
            }
            if (crVar == null) {
                crVar = new cr().CO();
            }
            this.aEG.a(crVar, remove.Lc(), remove.getContent(), this.aEF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.a aVar) {
        if (aVar != null && this.aED != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.aHt, aVar.aHu, aVar.aHv, String.valueOf(this.aED.mLiveInfo.group_id), String.valueOf(this.aED.mLiveInfo.live_id), this.aEE, String.valueOf(this.aED.aJD.userId), aVar.appId, aVar.getNameShow())));
        }
    }
}
