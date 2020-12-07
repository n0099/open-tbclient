package com.baidu.live.barrage.a;

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
import com.baidu.live.barrage.view.ImBarrageTrackListView;
import com.baidu.live.barrage.view.LandscapeImBarrageTrackView;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.au;
import com.baidu.live.data.bj;
import com.baidu.live.data.ci;
import com.baidu.live.data.w;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.y;
import com.baidu.live.gift.z;
import com.baidu.live.im.b.a;
import com.baidu.live.im.b.d;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.message.ImBarragePayResponseMessage;
import com.baidu.live.o.c;
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
/* loaded from: classes4.dex */
public class b implements com.baidu.live.im.b.a {
    private a.InterfaceC0193a aFM;
    private w aFN;
    private boolean aFO;
    private String aFP;
    private CustomMessageListener aFR;
    private HttpMessageListener aFS;
    private CustomMessageListener aFT;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> aFU;
    private boolean aFV = false;
    private ImBarrageTrackListView aFX;
    private List<com.baidu.live.im.data.b> mMessages;
    private String mOtherParams;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
        initListener();
    }

    @Override // com.baidu.live.im.b.a
    public void a(a.InterfaceC0193a interfaceC0193a) {
        this.aFM = interfaceC0193a;
    }

    @Override // com.baidu.live.im.b.a
    public void a(w wVar, boolean z) {
        if (z) {
            if (!this.aFV) {
                this.aFV = true;
            } else {
                return;
            }
        }
        this.aFX.setCanAddNext();
        this.aFX.Ed();
        DM();
        a(wVar);
        DO();
        DU();
    }

    @Override // com.baidu.live.im.b.a
    public void a(w wVar) {
        boolean z = false;
        this.aFN = wVar;
        this.aFO = false;
        if (this.aFN != null && this.aFN.mLiveInfo != null) {
            this.aFP = String.valueOf(this.aFN.aJV.userId);
            String valueOf = String.valueOf(this.aFN.mLiveInfo.user_id);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
                z = true;
            }
            this.aFO = z;
        }
    }

    @Override // com.baidu.live.im.b.a
    public View DL() {
        return this.aFX;
    }

    @Override // com.baidu.live.im.b.a
    public void DM() {
        if (this.aFX != null) {
            this.aFX.DM();
        }
    }

    @Override // com.baidu.live.im.b.a
    public void DN() {
        DP();
        DV();
        this.aFN = null;
        if (this.mMessages != null) {
            this.mMessages.clear();
        }
        if (this.aFX != null) {
            this.aFX.release();
            if (this.aFX.getParent() != null) {
                ((ViewGroup) this.aFX.getParent()).removeView(this.aFX);
            }
        }
        this.aFV = false;
    }

    @Override // com.baidu.live.im.b.a
    public void release() {
        DN();
        DR();
        DT();
        d.NK().release();
    }

    @Override // com.baidu.live.im.b.a
    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }

    private void initView() {
        this.aFX = new ImBarrageTrackListView(this.mPageContext.getPageActivity(), 3, new LandscapeImBarrageTrackView.a() { // from class: com.baidu.live.barrage.a.b.1
            @Override // com.baidu.live.barrage.view.LandscapeImBarrageTrackView.a
            public void b(com.baidu.live.data.a aVar) {
                b.this.a(aVar);
            }

            @Override // com.baidu.live.barrage.view.LandscapeImBarrageTrackView.a
            public void a(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
                b.this.aFX.b(landscapeImBarrageTrackView);
                b.this.DX();
            }
        });
    }

    private void initListener() {
        DQ();
        DS();
    }

    private void DO() {
        if (this.aFU == null) {
            this.aFU = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.live.barrage.a.b.2
                @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<?> run(CustomMessage<ImSendMsgData> customMessage) {
                    if (customMessage != null && customMessage.getData() != null) {
                        b.this.a(customMessage.getData());
                        return null;
                    }
                    return null;
                }
            };
        }
        CustomMessageTask customMessageTask = new CustomMessageTask(2913101, this.aFU);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void DP() {
        MessageManager.getInstance().unRegisterTask(2913101);
    }

    private void DQ() {
        this.aFR = new CustomMessageListener(2913102) { // from class: com.baidu.live.barrage.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(b.this.mPageContext.getPageActivity()) == 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.v((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aFR);
    }

    private void DR() {
        if (this.aFR != null) {
            MessageManager.getInstance().unRegisterListener(this.aFR);
        }
    }

    private void DS() {
        this.aFS = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.live.barrage.a.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021133 && (httpResponsedMessage instanceof ImBarragePayResponseMessage)) {
                    b.this.a((ImBarragePayResponseMessage) httpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aFS);
    }

    private void DT() {
        if (this.aFS != null) {
            MessageManager.getInstance().unRegisterListener(this.aFS);
        }
    }

    private void DU() {
        DV();
        if (this.aFT == null) {
            this.aFT = new CustomMessageListener(2913037) { // from class: com.baidu.live.barrage.a.b.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (UtilHelper.getRealScreenOrientation(b.this.mPageContext.getPageActivity()) == 2) {
                        Object data = customResponsedMessage.getData();
                        if (data instanceof com.baidu.live.im.data.b) {
                            b.this.b((com.baidu.live.im.data.b) data);
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.aFT);
    }

    private void DV() {
        if (this.aFT != null) {
            MessageManager.getInstance().unRegisterListener(this.aFT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImSendMsgData imSendMsgData) {
        if (imSendMsgData.msgType == 126) {
            long j = imSendMsgData.price;
            if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                DW();
                return;
            }
            TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
            MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
        }
    }

    private void DW() {
        if (this.aFM != null) {
            this.aFM.NJ();
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
        if (bVar.NY() == 1) {
            com.baidu.live.im.data.d Oa = bVar.Oa();
            if (Oa != null && Oa.bpc) {
                a(bVar.NZ(), Oa, bVar.bnb);
            } else {
                f(bVar.getMsgId(), bVar.NZ());
            }
        }
    }

    private void f(long j, String str) {
        String Iz = p.Iz();
        com.baidu.live.im.message.d dVar = new com.baidu.live.im.message.d();
        dVar.addParam("scene_from", Iz);
        dVar.addParam("live_id", this.aFN.mLiveInfo.live_id);
        dVar.addParam("im_id", j);
        dVar.addParam("barrage_id", str);
        MessageManager.getInstance().sendMessage(dVar);
    }

    private void a(String str, com.baidu.live.im.data.d dVar, String str2) {
        y yVar;
        Map<String, y> Ij = z.Ii().Ij();
        if (Ij != null && Ij.containsKey(str) && (yVar = Ij.get(str)) != null) {
            ac.b(yVar.itemId, yVar.aWn, dVar.bpd, dVar.liveId, 1, 0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImBarragePayResponseMessage imBarragePayResponseMessage) {
        if (imBarragePayResponseMessage.getError() == 0) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = imBarragePayResponseMessage.KK();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
            return;
        }
        if (!TextUtils.isEmpty(imBarragePayResponseMessage.getErrorString())) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), imBarragePayResponseMessage.getErrorString());
        }
        new c().refreshCurUserScores();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0037, code lost:
        if ("zan_rmb".equals(r0) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(com.baidu.live.im.data.b bVar) {
        boolean z;
        boolean z2 = true;
        int i = 0;
        boolean g = g(bVar);
        if (!g) {
            String content = bVar.getContent();
            if (!TextUtils.isEmpty(content)) {
                try {
                    String optString = new JSONObject(content).optString("content_type");
                    if (!"follow_anchor".equals(optString) && !"guard_club_join".equals(optString)) {
                    }
                    z = true;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (!z && !g) {
                    z2 = false;
                }
                if (bVar.NX() && z2) {
                    if (this.mMessages == null) {
                        this.mMessages = new ArrayList();
                    }
                    boolean d = d(bVar);
                    if (d || this.mMessages.size() <= com.baidu.live.ae.a.RB().brA.aOk) {
                        if (d && !this.mMessages.isEmpty()) {
                            while (i < this.mMessages.size()) {
                                if (!d(this.mMessages.get(i))) {
                                    break;
                                }
                                i++;
                            }
                        }
                        i = -1;
                        if (i >= 0) {
                            this.mMessages.add(i, bVar);
                        } else {
                            this.mMessages.add(bVar);
                        }
                        DX();
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
        if (bVar.NX()) {
        }
    }

    private boolean c(com.baidu.live.im.data.b bVar) {
        return bVar != null && bVar.getMsgType() == 126;
    }

    private boolean d(com.baidu.live.im.data.b bVar) {
        return bVar != null && bVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DX() {
        ci ciVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.aFX.Ee()) {
            ci[] NL = d.NK().NL();
            com.baidu.live.im.data.b remove = this.mMessages.remove(0);
            if (remove == null || TextUtils.isEmpty(remove.getContent()) || remove.NU() == null) {
                DX();
                return;
            }
            if (remove.getMsgType() != 126) {
                ciVar = null;
            } else if (NL != null) {
                int length = NL.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        ciVar = null;
                        break;
                    }
                    ciVar = NL[i];
                    if (ciVar.id.equals(remove.NZ())) {
                        break;
                    }
                    i++;
                }
                if (ciVar == null) {
                    ciVar = new ci().FY();
                }
            } else {
                return;
            }
            if (this.aFX.a(ciVar, ciVar == null ? a(remove.Ob(), remove.NU()) : null, remove.NU(), e(remove), this.aFP, f(remove))) {
                DX();
            }
        }
    }

    private String e(com.baidu.live.im.data.b bVar) {
        String str = "";
        if (bVar == null) {
            return "";
        }
        if (g(bVar)) {
            return bVar.getContent();
        }
        if (!TextUtils.isEmpty(bVar.getContent())) {
            try {
                String optString = new JSONObject(bVar.getContent()).optString("content_type");
                if ("follow_anchor".equals(optString)) {
                    str = this.mPageContext.getPageActivity().getString(a.h.ala_follow_live);
                } else if ("guard_club_join".equals(optString)) {
                    str = this.mPageContext.getPageActivity().getString(a.h.ala_guard_club_join);
                } else if ("zan_rmb".equals(optString)) {
                    str = this.mPageContext.getPageActivity().getString(a.h.ala_zan_rmb);
                }
                return str;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    private int f(com.baidu.live.im.data.b bVar) {
        String content;
        if (bVar == null || g(bVar) || (content = bVar.getContent()) == null) {
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

    private boolean g(com.baidu.live.im.data.b bVar) {
        if (bVar == null) {
            return false;
        }
        int msgType = bVar.getMsgType();
        return msgType == 126 || msgType == 1;
    }

    private au a(String[] strArr, com.baidu.live.data.a aVar) {
        au auVar;
        JSONObject optJSONObject;
        String optString;
        JSONObject optJSONObject2;
        boolean z;
        int i = 255;
        boolean z2 = strArr != null && strArr.length > 0 && TextUtils.equals(strArr[0], "guard_seat_effect");
        if (strArr == null || strArr.length <= 1 || com.baidu.live.ae.a.RB().bxq == null) {
            auVar = null;
        } else {
            au auVar2 = new au();
            bj bjVar = com.baidu.live.ae.a.RB().bxq.aQO;
            if (bjVar != null && bjVar.aQv != null && !TextUtils.isEmpty(strArr[0]) && (optJSONObject2 = bjVar.aQv.optJSONObject(strArr[0])) != null) {
                int optInt = optJSONObject2.optInt("transparency");
                if (optInt >= 0 && optInt <= 100) {
                    auVar2.aPA = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
                } else {
                    auVar2.aPA = 255;
                }
                auVar2.aPB = optJSONObject2.optString("tail_icon");
                String optString2 = optJSONObject2.optString("start_color");
                String optString3 = optJSONObject2.optString("end_color");
                try {
                    if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                        auVar2.aPw = Color.parseColor(optString2);
                        auVar2.aPx = Color.parseColor(optString3);
                        z = true;
                    } else {
                        String optString4 = optJSONObject2.optString("bg_color");
                        if (TextUtils.isEmpty(optString4)) {
                            z = false;
                        } else {
                            auVar2.aPw = Color.parseColor(optString4);
                            auVar2.aPx = auVar2.aPw;
                            z = true;
                        }
                    }
                    if (z) {
                        String optString5 = optJSONObject2.optString("frame_start_color");
                        String optString6 = optJSONObject2.optString("frame_end_color");
                        if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
                            auVar2.aPy = Color.parseColor(optString5);
                            auVar2.aPz = Color.parseColor(optString6);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (bjVar != null && bjVar.aQw != null && !TextUtils.isEmpty(strArr[1]) && (optJSONObject = bjVar.aQw.optJSONObject(strArr[1])) != null) {
                String optString7 = optJSONObject.optString("bg_color");
                if (!TextUtils.isEmpty(optJSONObject.optString("transparency"))) {
                    try {
                        i = (int) (((Integer.parseInt(optString) * 1.0f) / 100.0f) * 255.0f);
                    } catch (Exception e2) {
                    }
                }
                if (!TextUtils.isEmpty(optString7)) {
                    auVar2.aPC = Color.parseColor(optString7);
                    auVar2.aPD = i;
                }
            }
            auVar = auVar2;
        }
        int c = c(aVar);
        boolean z3 = c >= 5;
        boolean z4 = c >= 2;
        if (!z2 && z3) {
            if (auVar == null) {
                auVar = new au();
            }
            if (c == 7) {
                auVar.aPw = Color.parseColor("#4e030c");
                auVar.aPx = Color.parseColor("#4e030c");
            } else {
                auVar.aPw = Color.parseColor("#031f33");
                auVar.aPx = Color.parseColor("#031f33");
            }
            auVar.aPA = 60;
            auVar.aPy = Color.parseColor("#faca21");
            auVar.aPz = Color.parseColor("#faca21");
        }
        if (z4) {
            if (auVar == null) {
                auVar = new au();
            }
            if (c == 7) {
                auVar.aPC = Color.parseColor("#ffef76");
            } else {
                auVar.aPC = Color.parseColor("#43c0a0");
            }
            auVar.aPD = 100;
        }
        return auVar;
    }

    private int c(com.baidu.live.data.a aVar) {
        if (aVar != null && !ListUtils.isEmpty(aVar.aID)) {
            for (AlaLiveMarkData alaLiveMarkData : aVar.aID) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.a aVar) {
        if (aVar != null && this.aFN != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.aIx, aVar.aIy, aVar.aIz, String.valueOf(this.aFN.mLiveInfo.group_id), String.valueOf(this.aFN.mLiveInfo.live_id), this.aFO, String.valueOf(this.aFN.aJV.userId), aVar.appId, aVar.getNameShow(), "")));
        }
    }
}
