package com.baidu.live.im.b;

import android.graphics.Color;
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
import com.baidu.live.data.ab;
import com.baidu.live.data.am;
import com.baidu.live.data.be;
import com.baidu.live.data.n;
import com.baidu.live.gift.r;
import com.baidu.live.gift.s;
import com.baidu.live.gift.u;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.l;
import com.baidu.live.im.m;
import com.baidu.live.im.message.ImBarragePayResponseMessage;
import com.baidu.live.im.view.LandscapeImBarrageTrackView;
import com.baidu.live.im.view.barrage.ImBarrageTrackListView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.u.a;
import com.baidu.live.utils.q;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements l {
    private n aDK;
    private l.a aMU;
    private boolean aMV;
    private String aMW;
    private CustomMessageListener aMY;
    private HttpMessageListener aMZ;
    private CustomMessageListener aNa;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> aNb;
    private boolean aNc = false;
    private ImBarrageTrackListView aNe;
    private List<com.baidu.live.im.data.a> mMessages;
    private String mOtherParams;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
        initListener();
    }

    @Override // com.baidu.live.im.l
    public void a(l.a aVar) {
        this.aMU = aVar;
    }

    @Override // com.baidu.live.im.l
    public void a(n nVar, boolean z) {
        if (z) {
            if (!this.aNc) {
                this.aNc = true;
            } else {
                return;
            }
        }
        this.aNe.setCanAddNext();
        this.aNe.Df();
        Bm();
        a(nVar);
        BJ();
        BP();
    }

    @Override // com.baidu.live.im.l
    public void a(n nVar) {
        boolean z = false;
        this.aDK = nVar;
        this.aMV = false;
        if (this.aDK != null && this.aDK.mLiveInfo != null) {
            this.aMW = String.valueOf(this.aDK.aqk.userId);
            String valueOf = String.valueOf(this.aDK.mLiveInfo.user_id);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
                z = true;
            }
            this.aMV = z;
        }
    }

    @Override // com.baidu.live.im.l
    public View Bl() {
        return this.aNe;
    }

    @Override // com.baidu.live.im.l
    public void Bm() {
        if (this.aNe != null) {
            this.aNe.Bm();
        }
    }

    @Override // com.baidu.live.im.l
    public void AJ() {
        BK();
        BQ();
        this.aDK = null;
        if (this.mMessages != null) {
            this.mMessages.clear();
        }
        if (this.aNe != null) {
            this.aNe.release();
            if (this.aNe.getParent() != null) {
                ((ViewGroup) this.aNe.getParent()).removeView(this.aNe);
            }
        }
        this.aNc = false;
    }

    @Override // com.baidu.live.im.l
    public void release() {
        AJ();
        BM();
        BO();
        m.Bo().release();
    }

    @Override // com.baidu.live.im.l
    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }

    private void initView() {
        this.aNe = new ImBarrageTrackListView(this.mPageContext.getPageActivity(), 3, new LandscapeImBarrageTrackView.a() { // from class: com.baidu.live.im.b.c.1
            @Override // com.baidu.live.im.view.LandscapeImBarrageTrackView.a
            public void c(com.baidu.live.data.a aVar) {
                c.this.b(aVar);
            }

            @Override // com.baidu.live.im.view.LandscapeImBarrageTrackView.a
            public void a(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
                c.this.aNe.c(landscapeImBarrageTrackView);
                c.this.BS();
            }
        });
    }

    private void initListener() {
        BL();
        BN();
    }

    private void BJ() {
        if (this.aNb == null) {
            this.aNb = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.live.im.b.c.2
                @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<?> run(CustomMessage<ImSendMsgData> customMessage) {
                    if (customMessage != null && customMessage.getData() != null) {
                        c.this.b(customMessage.getData());
                        return null;
                    }
                    return null;
                }
            };
        }
        CustomMessageTask customMessageTask = new CustomMessageTask(2913101, this.aNb);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void BK() {
        MessageManager.getInstance().unRegisterTask(2913101);
    }

    private void BL() {
        this.aMY = new CustomMessageListener(2913102) { // from class: com.baidu.live.im.b.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(c.this.mPageContext.getPageActivity()) == 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    c.this.G((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aMY);
    }

    private void BM() {
        if (this.aMY != null) {
            MessageManager.getInstance().unRegisterListener(this.aMY);
        }
    }

    private void BN() {
        this.aMZ = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.live.im.b.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021133 && (httpResponsedMessage instanceof ImBarragePayResponseMessage)) {
                    c.this.a((ImBarragePayResponseMessage) httpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aMZ);
    }

    private void BO() {
        if (this.aMZ != null) {
            MessageManager.getInstance().unRegisterListener(this.aMZ);
        }
    }

    private void BP() {
        BQ();
        if (this.aNa == null) {
            this.aNa = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.b.c.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (UtilHelper.getRealScreenOrientation(c.this.mPageContext.getPageActivity()) == 2) {
                        Object data = customResponsedMessage.getData();
                        if (data instanceof com.baidu.live.im.data.a) {
                            c.this.p((com.baidu.live.im.data.a) data);
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.aNa);
    }

    private void BQ() {
        if (this.aNa != null) {
            MessageManager.getInstance().unRegisterListener(this.aNa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImSendMsgData imSendMsgData) {
        if (imSendMsgData.msgType == 126) {
            long j = imSendMsgData.price;
            if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                BR();
                return;
            }
            TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
            MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
        }
    }

    private void BR() {
        if (this.aMU != null) {
            this.aMU.Bn();
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
        if (aVar.Ci() == 1) {
            com.baidu.live.im.data.b Ck = aVar.Ck();
            if (Ck != null && Ck.aNx) {
                a(aVar.Cj(), Ck);
            } else {
                d(aVar.getMsgId(), aVar.Cj());
            }
        }
    }

    private void d(long j, String str) {
        String xf = q.xf();
        com.baidu.live.im.message.d dVar = new com.baidu.live.im.message.d();
        dVar.addParam("scene_from", xf);
        dVar.addParam("live_id", this.aDK.mLiveInfo.live_id);
        dVar.addParam("im_id", j);
        dVar.addParam("barrage_id", str);
        MessageManager.getInstance().sendMessage(dVar);
    }

    private void a(String str, com.baidu.live.im.data.b bVar) {
        r rVar;
        Map<String, r> wV = s.wU().wV();
        if (wV != null && wV.containsKey(str) && (rVar = wV.get(str)) != null) {
            u.b(rVar.itemId, rVar.ayZ, bVar.aNy, bVar.liveId, 1, 0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImBarragePayResponseMessage imBarragePayResponseMessage) {
        if (imBarragePayResponseMessage.getError() == 0) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = imBarragePayResponseMessage.zi();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
            return;
        }
        if (!TextUtils.isEmpty(imBarragePayResponseMessage.getErrorString())) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), imBarragePayResponseMessage.getErrorString());
        }
        new com.baidu.live.k.c().refreshCurUserScores();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0037, code lost:
        if ("zan_rmb".equals(r0) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void p(com.baidu.live.im.data.a aVar) {
        boolean z;
        boolean z2 = true;
        int i = 0;
        boolean u = u(aVar);
        if (!u) {
            String content = aVar.getContent();
            if (!TextUtils.isEmpty(content)) {
                try {
                    String optString = new JSONObject(content).optString("content_type");
                    if (!"follow_anchor".equals(optString) && !"guard_club_join".equals(optString)) {
                    }
                    z = true;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (!z && !u) {
                    z2 = false;
                }
                if (aVar.Ch() && z2) {
                    if (this.mMessages == null) {
                        this.mMessages = new ArrayList();
                    }
                    boolean r = r(aVar);
                    if (r || this.mMessages.size() <= com.baidu.live.v.a.En().aQu.atq) {
                        if (r && !this.mMessages.isEmpty()) {
                            while (i < this.mMessages.size()) {
                                if (!r(this.mMessages.get(i))) {
                                    break;
                                }
                                i++;
                            }
                        }
                        i = -1;
                        if (i >= 0) {
                            this.mMessages.add(i, aVar);
                        } else {
                            this.mMessages.add(aVar);
                        }
                        BS();
                        return;
                    }
                    return;
                }
            }
        }
        z = false;
        if (!z) {
            z2 = false;
        }
        if (aVar.Ch()) {
        }
    }

    private boolean q(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getMsgType() == 126;
    }

    private boolean r(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BS() {
        be beVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.aNe.Da()) {
            be[] Bp = m.Bo().Bp();
            com.baidu.live.im.data.a remove = this.mMessages.remove(0);
            if (remove == null || TextUtils.isEmpty(remove.getContent()) || remove.Ce() == null) {
                BS();
                return;
            }
            if (remove.getMsgType() != 126) {
                beVar = null;
            } else if (Bp != null) {
                int length = Bp.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        beVar = null;
                        break;
                    }
                    beVar = Bp[i];
                    if (beVar.id.equals(remove.Cj())) {
                        break;
                    }
                    i++;
                }
                if (beVar == null) {
                    beVar = new be().vg();
                }
            } else {
                return;
            }
            if (this.aNe.c(beVar, beVar == null ? k(remove.Cl()) : null, remove.Ce(), s(remove), this.aMW, t(remove))) {
                BS();
            }
        }
    }

    private String s(com.baidu.live.im.data.a aVar) {
        String str = "";
        if (aVar == null) {
            return "";
        }
        if (u(aVar)) {
            return aVar.getContent();
        }
        if (!TextUtils.isEmpty(aVar.getContent())) {
            try {
                String optString = new JSONObject(aVar.getContent()).optString("content_type");
                if ("follow_anchor".equals(optString)) {
                    str = this.mPageContext.getPageActivity().getString(a.i.ala_follow_live);
                } else if ("guard_club_join".equals(optString)) {
                    str = this.mPageContext.getPageActivity().getString(a.i.ala_guard_club_join);
                } else if ("zan_rmb".equals(optString)) {
                    str = this.mPageContext.getPageActivity().getString(a.i.ala_zan_rmb);
                }
                return str;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    private int t(com.baidu.live.im.data.a aVar) {
        String content;
        if (aVar == null || u(aVar) || (content = aVar.getContent()) == null) {
            return 0;
        }
        try {
            String optString = new JSONObject(content).optString("content_type");
            if ("follow_anchor".equals(optString)) {
                return 2;
            }
            if ("guard_club_join".equals(optString)) {
                return 3;
            }
            if (!"zan_rmb".equals(optString)) {
                return 0;
            }
            return 1;
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private boolean u(com.baidu.live.im.data.a aVar) {
        if (aVar == null) {
            return false;
        }
        int msgType = aVar.getMsgType();
        return msgType == 126 || msgType == 1;
    }

    private ab k(String[] strArr) {
        JSONObject optJSONObject;
        String optString;
        JSONObject optJSONObject2;
        int i = 255;
        boolean z = false;
        if (strArr == null || strArr.length <= 1 || com.baidu.live.v.a.En().aRB == null) {
            return null;
        }
        ab abVar = new ab();
        am amVar = com.baidu.live.v.a.En().aRB.avC;
        if (amVar != null && amVar.ave != null && !TextUtils.isEmpty(strArr[0]) && (optJSONObject2 = amVar.ave.optJSONObject(strArr[0])) != null) {
            int optInt = optJSONObject2.optInt("transparency");
            if (optInt >= 0 && optInt <= 100) {
                abVar.auc = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
            } else {
                abVar.auc = 255;
            }
            abVar.aud = optJSONObject2.optString("tail_icon");
            String optString2 = optJSONObject2.optString("start_color");
            String optString3 = optJSONObject2.optString("end_color");
            try {
                if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                    abVar.atY = Color.parseColor(optString2);
                    abVar.atZ = Color.parseColor(optString3);
                    z = true;
                } else {
                    String optString4 = optJSONObject2.optString("bg_color");
                    if (!TextUtils.isEmpty(optString4)) {
                        abVar.atY = Color.parseColor(optString4);
                        abVar.atZ = abVar.atY;
                        z = true;
                    }
                }
                if (z) {
                    String optString5 = optJSONObject2.optString("frame_start_color");
                    String optString6 = optJSONObject2.optString("frame_end_color");
                    if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
                        abVar.aua = Color.parseColor(optString5);
                        abVar.aub = Color.parseColor(optString6);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (amVar != null && amVar.avf != null && !TextUtils.isEmpty(strArr[1]) && (optJSONObject = amVar.avf.optJSONObject(strArr[1])) != null) {
            String optString7 = optJSONObject.optString("bg_color");
            if (!TextUtils.isEmpty(optJSONObject.optString("transparency"))) {
                try {
                    i = (int) (((Integer.parseInt(optString) * 1.0f) / 100.0f) * 255.0f);
                } catch (Exception e2) {
                }
            }
            if (!TextUtils.isEmpty(optString7)) {
                abVar.aue = Color.parseColor(optString7);
                abVar.auf = i;
            }
        }
        return abVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.live.data.a aVar) {
        if (aVar != null && this.aDK != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.apy, aVar.apz, aVar.apA, String.valueOf(this.aDK.mLiveInfo.group_id), String.valueOf(this.aDK.mLiveInfo.live_id), this.aMV, String.valueOf(this.aDK.aqk.userId), aVar.appId, aVar.getNameShow(), "")));
        }
    }
}
