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
import com.baidu.live.data.ar;
import com.baidu.live.data.bg;
import com.baidu.live.data.ce;
import com.baidu.live.data.w;
import com.baidu.live.gift.ab;
import com.baidu.live.gift.y;
import com.baidu.live.gift.z;
import com.baidu.live.im.b.a;
import com.baidu.live.im.b.d;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.message.ImBarragePayResponseMessage;
import com.baidu.live.m.c;
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
    private a.InterfaceC0186a aEb;
    private w aEc;
    private boolean aEd;
    private String aEe;
    private CustomMessageListener aEg;
    private HttpMessageListener aEh;
    private CustomMessageListener aEi;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> aEj;
    private boolean aEk = false;
    private ImBarrageTrackListView aEm;
    private List<com.baidu.live.im.data.a> mMessages;
    private String mOtherParams;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
        initListener();
    }

    @Override // com.baidu.live.im.b.a
    public void a(a.InterfaceC0186a interfaceC0186a) {
        this.aEb = interfaceC0186a;
    }

    @Override // com.baidu.live.im.b.a
    public void a(w wVar, boolean z) {
        if (z) {
            if (!this.aEk) {
                this.aEk = true;
            } else {
                return;
            }
        }
        this.aEm.setCanAddNext();
        this.aEm.CJ();
        Cs();
        a(wVar);
        Cu();
        CA();
    }

    @Override // com.baidu.live.im.b.a
    public void a(w wVar) {
        boolean z = false;
        this.aEc = wVar;
        this.aEd = false;
        if (this.aEc != null && this.aEc.mLiveInfo != null) {
            this.aEe = String.valueOf(this.aEc.aIe.userId);
            String valueOf = String.valueOf(this.aEc.mLiveInfo.user_id);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
                z = true;
            }
            this.aEd = z;
        }
    }

    @Override // com.baidu.live.im.b.a
    public View Cr() {
        return this.aEm;
    }

    @Override // com.baidu.live.im.b.a
    public void Cs() {
        if (this.aEm != null) {
            this.aEm.Cs();
        }
    }

    @Override // com.baidu.live.im.b.a
    public void Ct() {
        Cv();
        CB();
        this.aEc = null;
        if (this.mMessages != null) {
            this.mMessages.clear();
        }
        if (this.aEm != null) {
            this.aEm.release();
            if (this.aEm.getParent() != null) {
                ((ViewGroup) this.aEm.getParent()).removeView(this.aEm);
            }
        }
        this.aEk = false;
    }

    @Override // com.baidu.live.im.b.a
    public void release() {
        Ct();
        Cx();
        Cz();
        d.LG().release();
    }

    @Override // com.baidu.live.im.b.a
    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }

    private void initView() {
        this.aEm = new ImBarrageTrackListView(this.mPageContext.getPageActivity(), 3, new LandscapeImBarrageTrackView.a() { // from class: com.baidu.live.barrage.a.b.1
            @Override // com.baidu.live.barrage.view.LandscapeImBarrageTrackView.a
            public void b(com.baidu.live.data.a aVar) {
                b.this.a(aVar);
            }

            @Override // com.baidu.live.barrage.view.LandscapeImBarrageTrackView.a
            public void a(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
                b.this.aEm.b(landscapeImBarrageTrackView);
                b.this.CD();
            }
        });
    }

    private void initListener() {
        Cw();
        Cy();
    }

    private void Cu() {
        if (this.aEj == null) {
            this.aEj = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.live.barrage.a.b.2
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2913101, this.aEj);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void Cv() {
        MessageManager.getInstance().unRegisterTask(2913101);
    }

    private void Cw() {
        this.aEg = new CustomMessageListener(2913102) { // from class: com.baidu.live.barrage.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(b.this.mPageContext.getPageActivity()) == 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.u((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aEg);
    }

    private void Cx() {
        if (this.aEg != null) {
            MessageManager.getInstance().unRegisterListener(this.aEg);
        }
    }

    private void Cy() {
        this.aEh = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.live.barrage.a.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021133 && (httpResponsedMessage instanceof ImBarragePayResponseMessage)) {
                    b.this.a((ImBarragePayResponseMessage) httpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aEh);
    }

    private void Cz() {
        if (this.aEh != null) {
            MessageManager.getInstance().unRegisterListener(this.aEh);
        }
    }

    private void CA() {
        CB();
        if (this.aEi == null) {
            this.aEi = new CustomMessageListener(2913037) { // from class: com.baidu.live.barrage.a.b.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (UtilHelper.getRealScreenOrientation(b.this.mPageContext.getPageActivity()) == 2) {
                        Object data = customResponsedMessage.getData();
                        if (data instanceof com.baidu.live.im.data.a) {
                            b.this.b((com.baidu.live.im.data.a) data);
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.aEi);
    }

    private void CB() {
        if (this.aEi != null) {
            MessageManager.getInstance().unRegisterListener(this.aEi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImSendMsgData imSendMsgData) {
        if (imSendMsgData.msgType == 126) {
            long j = imSendMsgData.price;
            if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                CC();
                return;
            }
            TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
            MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
        }
    }

    private void CC() {
        if (this.aEb != null) {
            this.aEb.LF();
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
        if (aVar.LS() == 1) {
            com.baidu.live.im.data.b LU = aVar.LU();
            if (LU != null && LU.bkp) {
                a(aVar.LT(), LU, aVar.bja);
            } else {
                c(aVar.getMsgId(), aVar.LT());
            }
        }
    }

    private void c(long j, String str) {
        String GQ = p.GQ();
        com.baidu.live.im.message.d dVar = new com.baidu.live.im.message.d();
        dVar.addParam("scene_from", GQ);
        dVar.addParam("live_id", this.aEc.mLiveInfo.live_id);
        dVar.addParam("im_id", j);
        dVar.addParam("barrage_id", str);
        MessageManager.getInstance().sendMessage(dVar);
    }

    private void a(String str, com.baidu.live.im.data.b bVar, String str2) {
        y yVar;
        Map<String, y> GC = z.GB().GC();
        if (GC != null && GC.containsKey(str) && (yVar = GC.get(str)) != null) {
            ab.b(yVar.itemId, yVar.aTB, bVar.bkq, bVar.liveId, 1, 0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImBarragePayResponseMessage imBarragePayResponseMessage) {
        if (imBarragePayResponseMessage.getError() == 0) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = imBarragePayResponseMessage.IS();
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
    public void b(com.baidu.live.im.data.a aVar) {
        boolean z;
        boolean z2 = true;
        int i = 0;
        boolean g = g(aVar);
        if (!g) {
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
                if (!z && !g) {
                    z2 = false;
                }
                if (aVar.LR() && z2) {
                    if (this.mMessages == null) {
                        this.mMessages = new ArrayList();
                    }
                    boolean d = d(aVar);
                    if (d || this.mMessages.size() <= com.baidu.live.z.a.Pq().bmJ.aMa) {
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
                            this.mMessages.add(i, aVar);
                        } else {
                            this.mMessages.add(aVar);
                        }
                        CD();
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
        if (aVar.LR()) {
        }
    }

    private boolean c(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getMsgType() == 126;
    }

    private boolean d(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CD() {
        ce ceVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.aEm.CK()) {
            ce[] LH = d.LG().LH();
            com.baidu.live.im.data.a remove = this.mMessages.remove(0);
            if (remove == null || TextUtils.isEmpty(remove.getContent()) || remove.LO() == null) {
                CD();
                return;
            }
            if (remove.getMsgType() != 126) {
                ceVar = null;
            } else if (LH != null) {
                int length = LH.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        ceVar = null;
                        break;
                    }
                    ceVar = LH[i];
                    if (ceVar.id.equals(remove.LT())) {
                        break;
                    }
                    i++;
                }
                if (ceVar == null) {
                    ceVar = new ce().Ev();
                }
            } else {
                return;
            }
            if (this.aEm.a(ceVar, ceVar == null ? a(remove.LV(), remove.LO()) : null, remove.LO(), e(remove), this.aEe, f(remove))) {
                CD();
            }
        }
    }

    private String e(com.baidu.live.im.data.a aVar) {
        String str = "";
        if (aVar == null) {
            return "";
        }
        if (g(aVar)) {
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

    private int f(com.baidu.live.im.data.a aVar) {
        String content;
        if (aVar == null || g(aVar) || (content = aVar.getContent()) == null) {
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

    private boolean g(com.baidu.live.im.data.a aVar) {
        if (aVar == null) {
            return false;
        }
        int msgType = aVar.getMsgType();
        return msgType == 126 || msgType == 1;
    }

    private ar a(String[] strArr, com.baidu.live.data.a aVar) {
        ar arVar;
        JSONObject optJSONObject;
        String optString;
        JSONObject optJSONObject2;
        boolean z;
        int i = 255;
        boolean z2 = strArr != null && strArr.length > 0 && TextUtils.equals(strArr[0], "guard_seat_effect");
        if (strArr == null || strArr.length <= 1 || com.baidu.live.z.a.Pq().bsy == null) {
            arVar = null;
        } else {
            ar arVar2 = new ar();
            bg bgVar = com.baidu.live.z.a.Pq().bsy.aOC;
            if (bgVar != null && bgVar.aOe != null && !TextUtils.isEmpty(strArr[0]) && (optJSONObject2 = bgVar.aOe.optJSONObject(strArr[0])) != null) {
                int optInt = optJSONObject2.optInt("transparency");
                if (optInt >= 0 && optInt <= 100) {
                    arVar2.aNj = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
                } else {
                    arVar2.aNj = 255;
                }
                arVar2.aNk = optJSONObject2.optString("tail_icon");
                String optString2 = optJSONObject2.optString("start_color");
                String optString3 = optJSONObject2.optString("end_color");
                try {
                    if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                        arVar2.aNf = Color.parseColor(optString2);
                        arVar2.aNg = Color.parseColor(optString3);
                        z = true;
                    } else {
                        String optString4 = optJSONObject2.optString("bg_color");
                        if (TextUtils.isEmpty(optString4)) {
                            z = false;
                        } else {
                            arVar2.aNf = Color.parseColor(optString4);
                            arVar2.aNg = arVar2.aNf;
                            z = true;
                        }
                    }
                    if (z) {
                        String optString5 = optJSONObject2.optString("frame_start_color");
                        String optString6 = optJSONObject2.optString("frame_end_color");
                        if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
                            arVar2.aNh = Color.parseColor(optString5);
                            arVar2.aNi = Color.parseColor(optString6);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (bgVar != null && bgVar.aOf != null && !TextUtils.isEmpty(strArr[1]) && (optJSONObject = bgVar.aOf.optJSONObject(strArr[1])) != null) {
                String optString7 = optJSONObject.optString("bg_color");
                if (!TextUtils.isEmpty(optJSONObject.optString("transparency"))) {
                    try {
                        i = (int) (((Integer.parseInt(optString) * 1.0f) / 100.0f) * 255.0f);
                    } catch (Exception e2) {
                    }
                }
                if (!TextUtils.isEmpty(optString7)) {
                    arVar2.aNl = Color.parseColor(optString7);
                    arVar2.aNm = i;
                }
            }
            arVar = arVar2;
        }
        int c = c(aVar);
        boolean z3 = c >= 5;
        boolean z4 = c >= 2;
        if (!z2 && z3) {
            if (arVar == null) {
                arVar = new ar();
            }
            if (c == 7) {
                arVar.aNf = Color.parseColor("#4e030c");
                arVar.aNg = Color.parseColor("#4e030c");
            } else {
                arVar.aNf = Color.parseColor("#031f33");
                arVar.aNg = Color.parseColor("#031f33");
            }
            arVar.aNj = 60;
            arVar.aNh = Color.parseColor("#faca21");
            arVar.aNi = Color.parseColor("#faca21");
        }
        if (z4) {
            if (arVar == null) {
                arVar = new ar();
            }
            if (c == 7) {
                arVar.aNl = Color.parseColor("#ffef76");
            } else {
                arVar.aNl = Color.parseColor("#43c0a0");
            }
            arVar.aNm = 100;
        }
        return arVar;
    }

    private int c(com.baidu.live.data.a aVar) {
        if (aVar != null && !ListUtils.isEmpty(aVar.aGQ)) {
            for (AlaLiveMarkData alaLiveMarkData : aVar.aGQ) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.a aVar) {
        if (aVar != null && this.aEc != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.aGK, aVar.aGL, aVar.aGM, String.valueOf(this.aEc.mLiveInfo.group_id), String.valueOf(this.aEc.mLiveInfo.live_id), this.aEd, String.valueOf(this.aEc.aIe.userId), aVar.appId, aVar.getNameShow(), "")));
        }
    }
}
