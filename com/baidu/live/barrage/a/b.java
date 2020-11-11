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
import com.baidu.live.data.at;
import com.baidu.live.data.bi;
import com.baidu.live.data.cg;
import com.baidu.live.data.w;
import com.baidu.live.gift.aa;
import com.baidu.live.gift.x;
import com.baidu.live.gift.y;
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
    private a.InterfaceC0188a aER;
    private w aES;
    private boolean aET;
    private String aEU;
    private CustomMessageListener aEW;
    private HttpMessageListener aEX;
    private CustomMessageListener aEY;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> aEZ;
    private boolean aFa = false;
    private ImBarrageTrackListView aFc;
    private List<com.baidu.live.im.data.a> mMessages;
    private String mOtherParams;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
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
        this.aFc.setCanAddNext();
        this.aFc.Dc();
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
        return this.aFc;
    }

    @Override // com.baidu.live.im.b.a
    public void CL() {
        if (this.aFc != null) {
            this.aFc.CL();
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
        if (this.aFc != null) {
            this.aFc.release();
            if (this.aFc.getParent() != null) {
                ((ViewGroup) this.aFc.getParent()).removeView(this.aFc);
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
        this.aFc = new ImBarrageTrackListView(this.mPageContext.getPageActivity(), 3, new LandscapeImBarrageTrackView.a() { // from class: com.baidu.live.barrage.a.b.1
            @Override // com.baidu.live.barrage.view.LandscapeImBarrageTrackView.a
            public void b(com.baidu.live.data.a aVar) {
                b.this.a(aVar);
            }

            @Override // com.baidu.live.barrage.view.LandscapeImBarrageTrackView.a
            public void a(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
                b.this.aFc.b(landscapeImBarrageTrackView);
                b.this.CW();
            }
        });
    }

    private void initListener() {
        CP();
        CR();
    }

    private void CN() {
        if (this.aEZ == null) {
            this.aEZ = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.live.barrage.a.b.2
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2913101, this.aEZ);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void CO() {
        MessageManager.getInstance().unRegisterTask(2913101);
    }

    private void CP() {
        this.aEW = new CustomMessageListener(2913102) { // from class: com.baidu.live.barrage.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(b.this.mPageContext.getPageActivity()) == 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.u((List) customResponsedMessage.getData());
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
        this.aEX = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.live.barrage.a.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021133 && (httpResponsedMessage instanceof ImBarragePayResponseMessage)) {
                    b.this.a((ImBarragePayResponseMessage) httpResponsedMessage);
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
        CU();
        if (this.aEY == null) {
            this.aEY = new CustomMessageListener(2913037) { // from class: com.baidu.live.barrage.a.b.5
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
            long j = imSendMsgData.price;
            if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                CV();
                return;
            }
            TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
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
            com.baidu.live.im.data.b Mu = aVar.Mu();
            if (Mu != null && Mu.blJ) {
                a(aVar.Mt(), Mu, aVar.bku);
            } else {
                d(aVar.getMsgId(), aVar.Mt());
            }
        }
    }

    private void d(long j, String str) {
        String Hr = p.Hr();
        com.baidu.live.im.message.d dVar = new com.baidu.live.im.message.d();
        dVar.addParam("scene_from", Hr);
        dVar.addParam("live_id", this.aES.mLiveInfo.live_id);
        dVar.addParam("im_id", j);
        dVar.addParam("barrage_id", str);
        MessageManager.getInstance().sendMessage(dVar);
    }

    private void a(String str, com.baidu.live.im.data.b bVar, String str2) {
        x xVar;
        Map<String, x> Hd = y.Hc().Hd();
        if (Hd != null && Hd.containsKey(str) && (xVar = Hd.get(str)) != null) {
            aa.b(xVar.itemId, xVar.aUU, bVar.blK, bVar.liveId, 1, 0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImBarragePayResponseMessage imBarragePayResponseMessage) {
        if (imBarragePayResponseMessage.getError() == 0) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = imBarragePayResponseMessage.Jt();
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
                if (aVar.Mr() && z2) {
                    if (this.mMessages == null) {
                        this.mMessages = new ArrayList();
                    }
                    boolean d = d(aVar);
                    if (d || this.mMessages.size() <= com.baidu.live.aa.a.PQ().bod.aNa) {
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
                        CW();
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
        if (aVar.Mr()) {
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
        cg cgVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.aFc.Dd()) {
            cg[] Mh = d.Mg().Mh();
            com.baidu.live.im.data.a remove = this.mMessages.remove(0);
            if (remove == null || TextUtils.isEmpty(remove.getContent()) || remove.Mo() == null) {
                CW();
                return;
            }
            if (remove.getMsgType() != 126) {
                cgVar = null;
            } else if (Mh != null) {
                int length = Mh.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        cgVar = null;
                        break;
                    }
                    cgVar = Mh[i];
                    if (cgVar.id.equals(remove.Mt())) {
                        break;
                    }
                    i++;
                }
                if (cgVar == null) {
                    cgVar = new cg().EW();
                }
            } else {
                return;
            }
            if (this.aFc.a(cgVar, cgVar == null ? a(remove.Mv(), remove.Mo()) : null, remove.Mo(), e(remove), this.aEU, f(remove))) {
                CW();
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

    private at a(String[] strArr, com.baidu.live.data.a aVar) {
        at atVar;
        JSONObject optJSONObject;
        String optString;
        JSONObject optJSONObject2;
        boolean z;
        int i = 255;
        boolean z2 = strArr != null && strArr.length > 0 && TextUtils.equals(strArr[0], "guard_seat_effect");
        if (strArr == null || strArr.length <= 1 || com.baidu.live.aa.a.PQ().btT == null) {
            atVar = null;
        } else {
            at atVar2 = new at();
            bi biVar = com.baidu.live.aa.a.PQ().btT.aPz;
            if (biVar != null && biVar.aPh != null && !TextUtils.isEmpty(strArr[0]) && (optJSONObject2 = biVar.aPh.optJSONObject(strArr[0])) != null) {
                int optInt = optJSONObject2.optInt("transparency");
                if (optInt >= 0 && optInt <= 100) {
                    atVar2.aOm = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
                } else {
                    atVar2.aOm = 255;
                }
                atVar2.aOn = optJSONObject2.optString("tail_icon");
                String optString2 = optJSONObject2.optString("start_color");
                String optString3 = optJSONObject2.optString("end_color");
                try {
                    if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                        atVar2.aOi = Color.parseColor(optString2);
                        atVar2.aOj = Color.parseColor(optString3);
                        z = true;
                    } else {
                        String optString4 = optJSONObject2.optString("bg_color");
                        if (TextUtils.isEmpty(optString4)) {
                            z = false;
                        } else {
                            atVar2.aOi = Color.parseColor(optString4);
                            atVar2.aOj = atVar2.aOi;
                            z = true;
                        }
                    }
                    if (z) {
                        String optString5 = optJSONObject2.optString("frame_start_color");
                        String optString6 = optJSONObject2.optString("frame_end_color");
                        if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
                            atVar2.aOk = Color.parseColor(optString5);
                            atVar2.aOl = Color.parseColor(optString6);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (biVar != null && biVar.aPi != null && !TextUtils.isEmpty(strArr[1]) && (optJSONObject = biVar.aPi.optJSONObject(strArr[1])) != null) {
                String optString7 = optJSONObject.optString("bg_color");
                if (!TextUtils.isEmpty(optJSONObject.optString("transparency"))) {
                    try {
                        i = (int) (((Integer.parseInt(optString) * 1.0f) / 100.0f) * 255.0f);
                    } catch (Exception e2) {
                    }
                }
                if (!TextUtils.isEmpty(optString7)) {
                    atVar2.aOo = Color.parseColor(optString7);
                    atVar2.aOp = i;
                }
            }
            atVar = atVar2;
        }
        int c = c(aVar);
        boolean z3 = c >= 5;
        boolean z4 = c >= 2;
        if (!z2 && z3) {
            if (atVar == null) {
                atVar = new at();
            }
            if (c == 7) {
                atVar.aOi = Color.parseColor("#4e030c");
                atVar.aOj = Color.parseColor("#4e030c");
            } else {
                atVar.aOi = Color.parseColor("#031f33");
                atVar.aOj = Color.parseColor("#031f33");
            }
            atVar.aOm = 60;
            atVar.aOk = Color.parseColor("#faca21");
            atVar.aOl = Color.parseColor("#faca21");
        }
        if (z4) {
            if (atVar == null) {
                atVar = new at();
            }
            if (c == 7) {
                atVar.aOo = Color.parseColor("#ffef76");
            } else {
                atVar.aOo = Color.parseColor("#43c0a0");
            }
            atVar.aOp = 100;
        }
        return atVar;
    }

    private int c(com.baidu.live.data.a aVar) {
        if (aVar != null && !ListUtils.isEmpty(aVar.aHG)) {
            for (AlaLiveMarkData alaLiveMarkData : aVar.aHG) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.a aVar) {
        if (aVar != null && this.aES != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.aHA, aVar.aHB, aVar.aHC, String.valueOf(this.aES.mLiveInfo.group_id), String.valueOf(this.aES.mLiveInfo.live_id), this.aET, String.valueOf(this.aES.aIV.userId), aVar.appId, aVar.getNameShow(), "")));
        }
    }
}
