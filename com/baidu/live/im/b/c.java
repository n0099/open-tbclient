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
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.ag;
import com.baidu.live.data.av;
import com.baidu.live.data.bo;
import com.baidu.live.data.q;
import com.baidu.live.gift.s;
import com.baidu.live.gift.t;
import com.baidu.live.gift.v;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.l;
import com.baidu.live.im.m;
import com.baidu.live.im.message.ImBarragePayResponseMessage;
import com.baidu.live.im.view.LandscapeImBarrageTrackView;
import com.baidu.live.im.view.barrage.ImBarrageTrackListView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.utils.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements l {
    private q aLQ;
    private l.a aVG;
    private boolean aVH;
    private String aVI;
    private CustomMessageListener aVK;
    private HttpMessageListener aVL;
    private CustomMessageListener aVM;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> aVN;
    private boolean aVO = false;
    private ImBarrageTrackListView aVQ;
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
        this.aVG = aVar;
    }

    @Override // com.baidu.live.im.l
    public void a(q qVar, boolean z) {
        if (z) {
            if (!this.aVO) {
                this.aVO = true;
            } else {
                return;
            }
        }
        this.aVQ.setCanAddNext();
        this.aVQ.Fh();
        Dk();
        a(qVar);
        DH();
        DN();
    }

    @Override // com.baidu.live.im.l
    public void a(q qVar) {
        boolean z = false;
        this.aLQ = qVar;
        this.aVH = false;
        if (this.aLQ != null && this.aLQ.mLiveInfo != null) {
            this.aVI = String.valueOf(this.aLQ.axp.userId);
            String valueOf = String.valueOf(this.aLQ.mLiveInfo.user_id);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
                z = true;
            }
            this.aVH = z;
        }
    }

    @Override // com.baidu.live.im.l
    public View Dj() {
        return this.aVQ;
    }

    @Override // com.baidu.live.im.l
    public void Dk() {
        if (this.aVQ != null) {
            this.aVQ.Dk();
        }
    }

    @Override // com.baidu.live.im.l
    public void Cz() {
        DI();
        DO();
        this.aLQ = null;
        if (this.mMessages != null) {
            this.mMessages.clear();
        }
        if (this.aVQ != null) {
            this.aVQ.release();
            if (this.aVQ.getParent() != null) {
                ((ViewGroup) this.aVQ.getParent()).removeView(this.aVQ);
            }
        }
        this.aVO = false;
    }

    @Override // com.baidu.live.im.l
    public void release() {
        Cz();
        DK();
        DM();
        m.Dm().release();
    }

    @Override // com.baidu.live.im.l
    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }

    private void initView() {
        this.aVQ = new ImBarrageTrackListView(this.mPageContext.getPageActivity(), 3, new LandscapeImBarrageTrackView.a() { // from class: com.baidu.live.im.b.c.1
            @Override // com.baidu.live.im.view.LandscapeImBarrageTrackView.a
            public void c(com.baidu.live.data.a aVar) {
                c.this.b(aVar);
            }

            @Override // com.baidu.live.im.view.LandscapeImBarrageTrackView.a
            public void a(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
                c.this.aVQ.c(landscapeImBarrageTrackView);
                c.this.DQ();
            }
        });
    }

    private void initListener() {
        DJ();
        DL();
    }

    private void DH() {
        if (this.aVN == null) {
            this.aVN = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.live.im.b.c.2
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2913101, this.aVN);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void DI() {
        MessageManager.getInstance().unRegisterTask(2913101);
    }

    private void DJ() {
        this.aVK = new CustomMessageListener(2913102) { // from class: com.baidu.live.im.b.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(c.this.mPageContext.getPageActivity()) == 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    c.this.K((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aVK);
    }

    private void DK() {
        if (this.aVK != null) {
            MessageManager.getInstance().unRegisterListener(this.aVK);
        }
    }

    private void DL() {
        this.aVL = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.live.im.b.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021133 && (httpResponsedMessage instanceof ImBarragePayResponseMessage)) {
                    c.this.a((ImBarragePayResponseMessage) httpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aVL);
    }

    private void DM() {
        if (this.aVL != null) {
            MessageManager.getInstance().unRegisterListener(this.aVL);
        }
    }

    private void DN() {
        DO();
        if (this.aVM == null) {
            this.aVM = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.b.c.5
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
        MessageManager.getInstance().registerListener(this.aVM);
    }

    private void DO() {
        if (this.aVM != null) {
            MessageManager.getInstance().unRegisterListener(this.aVM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImSendMsgData imSendMsgData) {
        if (imSendMsgData.msgType == 126) {
            long j = imSendMsgData.price;
            if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                DP();
                return;
            }
            TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
            MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
        }
    }

    private void DP() {
        if (this.aVG != null) {
            this.aVG.Dl();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mPageContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(List list) {
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
        if (aVar.Eh() == 1) {
            com.baidu.live.im.data.b Ej = aVar.Ej();
            if (Ej != null && Ej.aWk) {
                a(aVar.Ei(), Ej);
            } else {
                d(aVar.getMsgId(), aVar.Ei());
            }
        }
    }

    private void d(long j, String str) {
        String yU = p.yU();
        com.baidu.live.im.message.d dVar = new com.baidu.live.im.message.d();
        dVar.addParam("scene_from", yU);
        dVar.addParam("live_id", this.aLQ.mLiveInfo.live_id);
        dVar.addParam("im_id", j);
        dVar.addParam("barrage_id", str);
        MessageManager.getInstance().sendMessage(dVar);
    }

    private void a(String str, com.baidu.live.im.data.b bVar) {
        s sVar;
        Map<String, s> yM = t.yL().yM();
        if (yM != null && yM.containsKey(str) && (sVar = yM.get(str)) != null) {
            v.c(sVar.itemId, sVar.aGN, bVar.aWl, bVar.liveId, 1, 0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImBarragePayResponseMessage imBarragePayResponseMessage) {
        if (imBarragePayResponseMessage.getError() == 0) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = imBarragePayResponseMessage.AX();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
            return;
        }
        if (!TextUtils.isEmpty(imBarragePayResponseMessage.getErrorString())) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), imBarragePayResponseMessage.getErrorString());
        }
        new com.baidu.live.l.c().refreshCurUserScores();
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
                if (aVar.Eg() && z2) {
                    if (this.mMessages == null) {
                        this.mMessages = new ArrayList();
                    }
                    boolean r = r(aVar);
                    if (r || this.mMessages.size() <= com.baidu.live.v.a.Hm().aZp.aAD) {
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
                        DQ();
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
        if (aVar.Eg()) {
        }
    }

    private boolean q(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getMsgType() == 126;
    }

    private boolean r(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DQ() {
        bo boVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.aVQ.Fc()) {
            bo[] Dn = m.Dm().Dn();
            com.baidu.live.im.data.a remove = this.mMessages.remove(0);
            if (remove == null || TextUtils.isEmpty(remove.getContent()) || remove.Ed() == null) {
                DQ();
                return;
            }
            if (remove.getMsgType() != 126) {
                boVar = null;
            } else if (Dn != null) {
                int length = Dn.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        boVar = null;
                        break;
                    }
                    boVar = Dn[i];
                    if (boVar.id.equals(remove.Ei())) {
                        break;
                    }
                    i++;
                }
                if (boVar == null) {
                    boVar = new bo().wT();
                }
            } else {
                return;
            }
            if (this.aVQ.c(boVar, boVar == null ? a(remove.Ek(), remove.Ed()) : null, remove.Ed(), s(remove), this.aVI, t(remove))) {
                DQ();
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

    private ag a(String[] strArr, com.baidu.live.data.a aVar) {
        ag agVar;
        JSONObject optJSONObject;
        String optString;
        JSONObject optJSONObject2;
        boolean z;
        int i = 255;
        boolean z2 = strArr != null && strArr.length > 0 && TextUtils.equals(strArr[0], "guard_seat_effect");
        if (strArr == null || strArr.length <= 1 || com.baidu.live.v.a.Hm().bdV == null) {
            agVar = null;
        } else {
            ag agVar2 = new ag();
            av avVar = com.baidu.live.v.a.Hm().bdV.aCV;
            if (avVar != null && avVar.aCx != null && !TextUtils.isEmpty(strArr[0]) && (optJSONObject2 = avVar.aCx.optJSONObject(strArr[0])) != null) {
                int optInt = optJSONObject2.optInt("transparency");
                if (optInt >= 0 && optInt <= 100) {
                    agVar2.aBx = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
                } else {
                    agVar2.aBx = 255;
                }
                agVar2.aBy = optJSONObject2.optString("tail_icon");
                String optString2 = optJSONObject2.optString("start_color");
                String optString3 = optJSONObject2.optString("end_color");
                try {
                    if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                        agVar2.aBt = Color.parseColor(optString2);
                        agVar2.aBu = Color.parseColor(optString3);
                        z = true;
                    } else {
                        String optString4 = optJSONObject2.optString("bg_color");
                        if (TextUtils.isEmpty(optString4)) {
                            z = false;
                        } else {
                            agVar2.aBt = Color.parseColor(optString4);
                            agVar2.aBu = agVar2.aBt;
                            z = true;
                        }
                    }
                    if (z) {
                        String optString5 = optJSONObject2.optString("frame_start_color");
                        String optString6 = optJSONObject2.optString("frame_end_color");
                        if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
                            agVar2.aBv = Color.parseColor(optString5);
                            agVar2.aBw = Color.parseColor(optString6);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (avVar != null && avVar.aCy != null && !TextUtils.isEmpty(strArr[1]) && (optJSONObject = avVar.aCy.optJSONObject(strArr[1])) != null) {
                String optString7 = optJSONObject.optString("bg_color");
                if (!TextUtils.isEmpty(optJSONObject.optString("transparency"))) {
                    try {
                        i = (int) (((Integer.parseInt(optString) * 1.0f) / 100.0f) * 255.0f);
                    } catch (Exception e2) {
                    }
                }
                if (!TextUtils.isEmpty(optString7)) {
                    agVar2.aBz = Color.parseColor(optString7);
                    agVar2.aBA = i;
                }
            }
            agVar = agVar2;
        }
        int d = d(aVar);
        boolean z3 = d >= 5;
        boolean z4 = d >= 2;
        if (!z2 && z3) {
            if (agVar == null) {
                agVar = new ag();
            }
            if (d == 7) {
                agVar.aBt = Color.parseColor("#4e030c");
                agVar.aBu = Color.parseColor("#4e030c");
            } else {
                agVar.aBt = Color.parseColor("#031f33");
                agVar.aBu = Color.parseColor("#031f33");
            }
            agVar.aBx = 60;
            agVar.aBv = Color.parseColor("#faca21");
            agVar.aBw = Color.parseColor("#faca21");
        }
        if (z4) {
            if (agVar == null) {
                agVar = new ag();
            }
            if (d == 7) {
                agVar.aBz = Color.parseColor("#ffef76");
            } else {
                agVar.aBz = Color.parseColor("#43c0a0");
            }
            agVar.aBA = 100;
        }
        return agVar;
    }

    private int d(com.baidu.live.data.a aVar) {
        if (aVar != null && !ListUtils.isEmpty(aVar.awD)) {
            for (AlaLiveMarkData alaLiveMarkData : aVar.awD) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.live.data.a aVar) {
        if (aVar != null && this.aLQ != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.awx, aVar.awy, aVar.awz, String.valueOf(this.aLQ.mLiveInfo.group_id), String.valueOf(this.aLQ.mLiveInfo.live_id), this.aVH, String.valueOf(this.aLQ.axp.userId), aVar.appId, aVar.getNameShow(), "")));
        }
    }
}
