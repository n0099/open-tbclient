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
import com.baidu.live.data.ck;
import com.baidu.live.data.x;
import com.baidu.live.gift.aj;
import com.baidu.live.gift.y;
import com.baidu.live.gift.z;
import com.baidu.live.im.b.a;
import com.baidu.live.im.b.d;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.data.b;
import com.baidu.live.im.message.YuyinImBarragePayResponseMessage;
import com.baidu.live.im.message.e;
import com.baidu.live.p.c;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.utils.t;
import com.baidu.live.yuyinbarrage.view.ImBarrageTrackView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes11.dex */
public class a implements com.baidu.live.im.b.a {
    private a.InterfaceC0186a aGd;
    private x aGe;
    private boolean aGf;
    private String aGg;
    private CustomMessageListener aGi;
    private HttpMessageListener aGj;
    private CustomMessageListener aGk;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> aGl;
    private boolean aGm = false;
    private ImBarrageTrackView bYl;
    private List<b> mMessages;
    private String mOtherParams;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
        initListener();
    }

    @Override // com.baidu.live.im.b.a
    public void a(a.InterfaceC0186a interfaceC0186a) {
        this.aGd = interfaceC0186a;
    }

    @Override // com.baidu.live.im.b.a
    public void a(x xVar, boolean z) {
        if (z) {
            if (!this.aGm) {
                this.aGm = true;
            } else {
                return;
            }
        }
        this.bYl.setCanAddNext();
        Db();
        a(xVar);
        Dd();
        Dj();
    }

    @Override // com.baidu.live.im.b.a
    public void a(x xVar) {
        boolean z = false;
        this.aGe = xVar;
        this.aGf = false;
        if (this.aGe != null && this.aGe.mLiveInfo != null) {
            this.aGg = String.valueOf(this.aGe.aKu.userId);
            String valueOf = String.valueOf(this.aGe.mLiveInfo.user_id);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
                z = true;
            }
            this.aGf = z;
        }
    }

    @Override // com.baidu.live.im.b.a
    public View Da() {
        return this.bYl;
    }

    @Override // com.baidu.live.im.b.a
    public void Db() {
        if (this.bYl != null) {
            this.bYl.post(new Runnable() { // from class: com.baidu.live.yuyinbarrage.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.bYl.setVisibility(a.this.bYl.getTop() > 0 ? 0 : 4);
                }
            });
        }
    }

    @Override // com.baidu.live.im.b.a
    public void Dc() {
        De();
        Dk();
        this.aGe = null;
        if (this.mMessages != null) {
            this.mMessages.clear();
        }
        if (this.bYl != null) {
            this.bYl.release();
            if (this.bYl.getParent() != null) {
                ((ViewGroup) this.bYl.getParent()).removeView(this.bYl);
            }
        }
        this.aGm = false;
    }

    @Override // com.baidu.live.im.b.a
    public void release() {
        Dc();
        Dg();
        Di();
        d.Nk().release();
    }

    @Override // com.baidu.live.im.b.a
    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }

    private void initView() {
        this.bYl = new ImBarrageTrackView(this.mPageContext.getPageActivity());
        this.bYl.setCallback(new ImBarrageTrackView.a() { // from class: com.baidu.live.yuyinbarrage.a.a.2
            @Override // com.baidu.live.yuyinbarrage.view.ImBarrageTrackView.a
            public void b(com.baidu.live.data.a aVar) {
                a.this.a(aVar);
            }

            @Override // com.baidu.live.yuyinbarrage.view.ImBarrageTrackView.a
            public void onNext() {
                a.this.Dm();
            }
        });
    }

    private void initListener() {
        Df();
        Dh();
    }

    private void Dd() {
        if (this.aGl == null) {
            this.aGl = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.live.yuyinbarrage.a.a.3
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2501069, this.aGl);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void De() {
        MessageManager.getInstance().unRegisterTask(2501069);
    }

    private void Df() {
        this.aGi = new CustomMessageListener(2913102) { // from class: com.baidu.live.yuyinbarrage.a.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(a.this.mPageContext.getPageActivity()) != 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    a.this.v((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aGi);
    }

    private void Dg() {
        if (this.aGi != null) {
            MessageManager.getInstance().unRegisterListener(this.aGi);
        }
    }

    private void Dh() {
        this.aGj = new HttpMessageListener(1031047) { // from class: com.baidu.live.yuyinbarrage.a.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031047 && (httpResponsedMessage instanceof YuyinImBarragePayResponseMessage)) {
                    a.this.a((YuyinImBarragePayResponseMessage) httpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aGj);
    }

    private void Di() {
        if (this.aGj != null) {
            MessageManager.getInstance().unRegisterListener(this.aGj);
        }
    }

    private void Dj() {
        if (this.aGk == null) {
            this.aGk = new CustomMessageListener(2913037) { // from class: com.baidu.live.yuyinbarrage.a.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (UtilHelper.getRealScreenOrientation(a.this.mPageContext.getPageActivity()) != 2) {
                        Object data = customResponsedMessage.getData();
                        if (data instanceof b) {
                            a.this.b((b) data);
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.aGk);
    }

    private void Dk() {
        if (this.aGk != null) {
            MessageManager.getInstance().unRegisterListener(this.aGk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImSendMsgData imSendMsgData) {
        if (imSendMsgData.msgType == 126) {
            if (imSendMsgData.barrageType == 1 && (imSendMsgData.barrageCardInfo == null || !imSendMsgData.barrageCardInfo.bqK)) {
                long j = imSendMsgData.price;
                if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                    Dl();
                    return;
                } else {
                    TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
        }
    }

    private void Dl() {
        if (this.aGd != null) {
            this.aGd.Nj();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mPageContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(List list) {
        if (list != null && !list.isEmpty()) {
            for (Object obj : list) {
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    if (d(bVar) && c(bVar)) {
                        a(bVar);
                    }
                }
            }
        }
    }

    private void a(b bVar) {
        if (bVar.NA() == 1) {
            com.baidu.live.im.data.d NC = bVar.NC();
            if (NC != null && NC.bqK) {
                a(bVar.NB(), NC, bVar.boI);
            } else {
                f(bVar.getMsgId(), bVar.NB());
            }
        }
    }

    private void f(long j, String str) {
        String Ia = t.Ia();
        e eVar = new e();
        eVar.addParam("scene_from", Ia);
        eVar.addParam("live_id", this.aGe.mLiveInfo.live_id);
        eVar.addParam(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aGe.aLl.croom_id);
        eVar.addParam("is_jiaoyou", 1);
        eVar.addParam("im_id", j);
        eVar.addParam("barrage_id", str);
        MessageManager.getInstance().sendMessage(eVar);
    }

    private void a(String str, com.baidu.live.im.data.d dVar, String str2) {
        y yVar;
        Map<String, y> HK = z.HJ().HK();
        if (HK != null && HK.containsKey(str) && (yVar = HK.get(str)) != null) {
            aj.b(yVar.itemId, yVar.aXT, dVar.beO, dVar.liveId, 1, 0, "", str2, 0, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(YuyinImBarragePayResponseMessage yuyinImBarragePayResponseMessage) {
        if (yuyinImBarragePayResponseMessage.getError() == 0) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = yuyinImBarragePayResponseMessage.Kl();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
            return;
        }
        if (!TextUtils.isEmpty(yuyinImBarragePayResponseMessage.getErrorString())) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), yuyinImBarragePayResponseMessage.getErrorString());
        }
        new c().refreshCurUserScores();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        int i;
        if (bVar.getMsgType() == 126) {
            if (this.mMessages == null) {
                this.mMessages = new ArrayList();
            }
            boolean d = d(bVar);
            if (d || this.mMessages.size() < com.baidu.live.af.a.SE().bwi.aOS) {
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
                Dm();
            }
        }
    }

    private boolean c(b bVar) {
        return bVar != null && bVar.getMsgType() == 126;
    }

    private boolean d(b bVar) {
        return bVar != null && bVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dm() {
        ck[] Nm;
        ck ckVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.bYl.Dt() && (Nm = d.Nk().Nm()) != null) {
            b remove = this.mMessages.remove(0);
            int length = Nm.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    ckVar = null;
                    break;
                }
                ckVar = Nm[i];
                if (ckVar.id.equals(remove.NB())) {
                    break;
                }
                i++;
            }
            if (ckVar == null) {
                ckVar = new ck().Fr();
            }
            this.bYl.a(ckVar, remove.Nw(), remove.getContent(), this.aGg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.a aVar) {
        if (aVar != null && this.aGe != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.aIT, aVar.aIU, aVar.aIV, String.valueOf(this.aGe.mLiveInfo.group_id), String.valueOf(this.aGe.mLiveInfo.live_id), this.aGf, String.valueOf(this.aGe.aKu.userId), aVar.appId, aVar.getNameShow(), "")));
        }
    }
}
