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
import com.baidu.live.data.cg;
import com.baidu.live.data.w;
import com.baidu.live.gift.ah;
import com.baidu.live.gift.x;
import com.baidu.live.gift.y;
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
    private a.InterfaceC0188a aER;
    private w aES;
    private boolean aET;
    private String aEU;
    private CustomMessageListener aEW;
    private HttpMessageListener aEX;
    private CustomMessageListener aEY;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> aEZ;
    private boolean aFa = false;
    private ImBarrageTrackView bPi;
    private List<com.baidu.live.im.data.a> mMessages;
    private String mOtherParams;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
        initListener();
    }

    @Override // com.baidu.live.im.b.a
    public void a(a.InterfaceC0188a interfaceC0188a) {
        this.aER = interfaceC0188a;
    }

    @Override // com.baidu.live.im.b.a
    public void a(w wVar, boolean z) {
        if (z) {
            if (!this.aFa) {
                this.aFa = true;
            } else {
                return;
            }
        }
        this.bPi.setCanAddNext();
        CL();
        a(wVar);
        CN();
        CT();
    }

    @Override // com.baidu.live.im.b.a
    public void a(w wVar) {
        boolean z = false;
        this.aES = wVar;
        this.aET = false;
        if (this.aES != null && this.aES.mLiveInfo != null) {
            this.aEU = String.valueOf(this.aES.aIV.userId);
            String valueOf = String.valueOf(this.aES.mLiveInfo.user_id);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
                z = true;
            }
            this.aET = z;
        }
    }

    @Override // com.baidu.live.im.b.a
    public View CK() {
        return this.bPi;
    }

    @Override // com.baidu.live.im.b.a
    public void CL() {
        if (this.bPi != null) {
            this.bPi.post(new Runnable() { // from class: com.baidu.live.yuyinbarrage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.bPi.setVisibility(a.this.bPi.getTop() > 0 ? 0 : 4);
                }
            });
        }
    }

    @Override // com.baidu.live.im.b.a
    public void CM() {
        CO();
        CU();
        this.aES = null;
        if (this.mMessages != null) {
            this.mMessages.clear();
        }
        if (this.bPi != null) {
            this.bPi.release();
            if (this.bPi.getParent() != null) {
                ((ViewGroup) this.bPi.getParent()).removeView(this.bPi);
            }
        }
        this.aFa = false;
    }

    @Override // com.baidu.live.im.b.a
    public void release() {
        CM();
        CQ();
        CS();
        d.Mg().release();
    }

    @Override // com.baidu.live.im.b.a
    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }

    private void initView() {
        this.bPi = new ImBarrageTrackView(this.mPageContext.getPageActivity());
        this.bPi.setCallback(new ImBarrageTrackView.a() { // from class: com.baidu.live.yuyinbarrage.a.a.2
            @Override // com.baidu.live.yuyinbarrage.view.ImBarrageTrackView.a
            public void b(com.baidu.live.data.a aVar) {
                a.this.a(aVar);
            }

            @Override // com.baidu.live.yuyinbarrage.view.ImBarrageTrackView.a
            public void onNext() {
                a.this.CW();
            }
        });
    }

    private void initListener() {
        CP();
        CR();
    }

    private void CN() {
        if (this.aEZ == null) {
            this.aEZ = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.live.yuyinbarrage.a.a.3
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2501069, this.aEZ);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void CO() {
        MessageManager.getInstance().unRegisterTask(2501069);
    }

    private void CP() {
        this.aEW = new CustomMessageListener(2913102) { // from class: com.baidu.live.yuyinbarrage.a.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(a.this.mPageContext.getPageActivity()) != 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    a.this.u((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aEW);
    }

    private void CQ() {
        if (this.aEW != null) {
            MessageManager.getInstance().unRegisterListener(this.aEW);
        }
    }

    private void CR() {
        this.aEX = new HttpMessageListener(1031047) { // from class: com.baidu.live.yuyinbarrage.a.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031047 && (httpResponsedMessage instanceof YuyinImBarragePayResponseMessage)) {
                    a.this.a((YuyinImBarragePayResponseMessage) httpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aEX);
    }

    private void CS() {
        if (this.aEX != null) {
            MessageManager.getInstance().unRegisterListener(this.aEX);
        }
    }

    private void CT() {
        if (this.aEY == null) {
            this.aEY = new CustomMessageListener(2913037) { // from class: com.baidu.live.yuyinbarrage.a.a.6
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
        MessageManager.getInstance().registerListener(this.aEY);
    }

    private void CU() {
        if (this.aEY != null) {
            MessageManager.getInstance().unRegisterListener(this.aEY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImSendMsgData imSendMsgData) {
        if (imSendMsgData.msgType == 126) {
            if (imSendMsgData.barrageType == 1 && (imSendMsgData.barrageCardInfo == null || !imSendMsgData.barrageCardInfo.blJ)) {
                long j = imSendMsgData.price;
                if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                    CV();
                    return;
                } else {
                    TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
        }
    }

    private void CV() {
        if (this.aER != null) {
            this.aER.Mf();
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
        if (aVar.Ms() == 1) {
            b Mu = aVar.Mu();
            if (Mu != null && Mu.blJ) {
                a(aVar.Mt(), Mu, aVar.bku);
            } else {
                d(aVar.getMsgId(), aVar.Mt());
            }
        }
    }

    private void d(long j, String str) {
        String Hr = s.Hr();
        e eVar = new e();
        eVar.addParam("scene_from", Hr);
        eVar.addParam("live_id", this.aES.mLiveInfo.live_id);
        eVar.addParam(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aES.aJK.croom_id);
        eVar.addParam("is_jiaoyou", 1);
        eVar.addParam("im_id", j);
        eVar.addParam("barrage_id", str);
        MessageManager.getInstance().sendMessage(eVar);
    }

    private void a(String str, b bVar, String str2) {
        x xVar;
        Map<String, x> Hd = y.Hc().Hd();
        if (Hd != null && Hd.containsKey(str) && (xVar = Hd.get(str)) != null) {
            ah.b(xVar.itemId, xVar.aUU, bVar.blK, bVar.liveId, 1, 0, "", str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(YuyinImBarragePayResponseMessage yuyinImBarragePayResponseMessage) {
        if (yuyinImBarragePayResponseMessage.getError() == 0) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = yuyinImBarragePayResponseMessage.Jt();
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
            if (d || this.mMessages.size() < com.baidu.live.aa.a.PQ().bod.aNb) {
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
                CW();
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
    public void CW() {
        cg[] Mi;
        cg cgVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.bPi.Dd() && (Mi = d.Mg().Mi()) != null) {
            com.baidu.live.im.data.a remove = this.mMessages.remove(0);
            int length = Mi.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    cgVar = null;
                    break;
                }
                cgVar = Mi[i];
                if (cgVar.id.equals(remove.Mt())) {
                    break;
                }
                i++;
            }
            if (cgVar == null) {
                cgVar = new cg().EW();
            }
            this.bPi.a(cgVar, remove.Mo(), remove.getContent(), this.aEU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.a aVar) {
        if (aVar != null && this.aES != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.aHA, aVar.aHB, aVar.aHC, String.valueOf(this.aES.mLiveInfo.group_id), String.valueOf(this.aES.mLiveInfo.live_id), this.aET, String.valueOf(this.aES.aIV.userId), aVar.appId, aVar.getNameShow(), "")));
        }
    }
}
