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
import com.baidu.live.data.aj;
import com.baidu.live.data.ay;
import com.baidu.live.data.br;
import com.baidu.live.data.r;
import com.baidu.live.gift.s;
import com.baidu.live.gift.t;
import com.baidu.live.gift.v;
import com.baidu.live.im.b.a;
import com.baidu.live.im.b.d;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.message.ImBarragePayResponseMessage;
import com.baidu.live.l.c;
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
/* loaded from: classes7.dex */
public class b implements com.baidu.live.im.b.a {
    private a.InterfaceC0175a aAi;
    private r aAj;
    private boolean aAk;
    private String aAl;
    private CustomMessageListener aAn;
    private HttpMessageListener aAo;
    private CustomMessageListener aAp;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> aAq;
    private boolean aAr = false;
    private ImBarrageTrackListView aAt;
    private List<com.baidu.live.im.data.a> mMessages;
    private String mOtherParams;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
        initListener();
    }

    @Override // com.baidu.live.im.b.a
    public void a(a.InterfaceC0175a interfaceC0175a) {
        this.aAi = interfaceC0175a;
    }

    @Override // com.baidu.live.im.b.a
    public void a(r rVar, boolean z) {
        if (z) {
            if (!this.aAr) {
                this.aAr = true;
            } else {
                return;
            }
        }
        this.aAt.setCanAddNext();
        this.aAt.Br();
        Ba();
        a(rVar);
        Bc();
        Bi();
    }

    @Override // com.baidu.live.im.b.a
    public void a(r rVar) {
        boolean z = false;
        this.aAj = rVar;
        this.aAk = false;
        if (this.aAj != null && this.aAj.mLiveInfo != null) {
            this.aAl = String.valueOf(this.aAj.aDG.userId);
            String valueOf = String.valueOf(this.aAj.mLiveInfo.user_id);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
                z = true;
            }
            this.aAk = z;
        }
    }

    @Override // com.baidu.live.im.b.a
    public View AZ() {
        return this.aAt;
    }

    @Override // com.baidu.live.im.b.a
    public void Ba() {
        if (this.aAt != null) {
            this.aAt.Ba();
        }
    }

    @Override // com.baidu.live.im.b.a
    public void Bb() {
        Bd();
        Bj();
        this.aAj = null;
        if (this.mMessages != null) {
            this.mMessages.clear();
        }
        if (this.aAt != null) {
            this.aAt.release();
            if (this.aAt.getParent() != null) {
                ((ViewGroup) this.aAt.getParent()).removeView(this.aAt);
            }
        }
        this.aAr = false;
    }

    @Override // com.baidu.live.im.b.a
    public void release() {
        Bb();
        Bf();
        Bh();
        d.JD().release();
    }

    @Override // com.baidu.live.im.b.a
    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }

    private void initView() {
        this.aAt = new ImBarrageTrackListView(this.mPageContext.getPageActivity(), 3, new LandscapeImBarrageTrackView.a() { // from class: com.baidu.live.barrage.a.b.1
            @Override // com.baidu.live.barrage.view.LandscapeImBarrageTrackView.a
            public void b(com.baidu.live.data.a aVar) {
                b.this.a(aVar);
            }

            @Override // com.baidu.live.barrage.view.LandscapeImBarrageTrackView.a
            public void a(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
                b.this.aAt.b(landscapeImBarrageTrackView);
                b.this.Bl();
            }
        });
    }

    private void initListener() {
        Be();
        Bg();
    }

    private void Bc() {
        if (this.aAq == null) {
            this.aAq = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.live.barrage.a.b.2
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2913101, this.aAq);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void Bd() {
        MessageManager.getInstance().unRegisterTask(2913101);
    }

    private void Be() {
        this.aAn = new CustomMessageListener(2913102) { // from class: com.baidu.live.barrage.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(b.this.mPageContext.getPageActivity()) == 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.s((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aAn);
    }

    private void Bf() {
        if (this.aAn != null) {
            MessageManager.getInstance().unRegisterListener(this.aAn);
        }
    }

    private void Bg() {
        this.aAo = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.live.barrage.a.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021133 && (httpResponsedMessage instanceof ImBarragePayResponseMessage)) {
                    b.this.a((ImBarragePayResponseMessage) httpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aAo);
    }

    private void Bh() {
        if (this.aAo != null) {
            MessageManager.getInstance().unRegisterListener(this.aAo);
        }
    }

    private void Bi() {
        Bj();
        if (this.aAp == null) {
            this.aAp = new CustomMessageListener(2913037) { // from class: com.baidu.live.barrage.a.b.5
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
        MessageManager.getInstance().registerListener(this.aAp);
    }

    private void Bj() {
        if (this.aAp != null) {
            MessageManager.getInstance().unRegisterListener(this.aAp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImSendMsgData imSendMsgData) {
        if (imSendMsgData.msgType == 126) {
            long j = imSendMsgData.price;
            if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                Bk();
                return;
            }
            TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
            MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
        }
    }

    private void Bk() {
        if (this.aAi != null) {
            this.aAi.JC();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mPageContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(List list) {
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
        if (aVar.JO() == 1) {
            com.baidu.live.im.data.b JQ = aVar.JQ();
            if (JQ != null && JQ.bcw) {
                a(aVar.JP(), JQ);
            } else {
                b(aVar.getMsgId(), aVar.JP());
            }
        }
    }

    private void b(long j, String str) {
        String EZ = p.EZ();
        com.baidu.live.im.message.d dVar = new com.baidu.live.im.message.d();
        dVar.addParam("scene_from", EZ);
        dVar.addParam("live_id", this.aAj.mLiveInfo.live_id);
        dVar.addParam("im_id", j);
        dVar.addParam("barrage_id", str);
        MessageManager.getInstance().sendMessage(dVar);
    }

    private void a(String str, com.baidu.live.im.data.b bVar) {
        s sVar;
        Map<String, s> ER = t.EQ().ER();
        if (ER != null && ER.containsKey(str) && (sVar = ER.get(str)) != null) {
            v.c(sVar.itemId, sVar.aNv, bVar.bcx, bVar.liveId, 1, 0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImBarragePayResponseMessage imBarragePayResponseMessage) {
        if (imBarragePayResponseMessage.getError() == 0) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = imBarragePayResponseMessage.Hc();
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
                if (aVar.JN() && z2) {
                    if (this.mMessages == null) {
                        this.mMessages = new ArrayList();
                    }
                    boolean d = d(aVar);
                    if (d || this.mMessages.size() <= com.baidu.live.w.a.Nk().beJ.aHc) {
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
                        Bl();
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
        if (aVar.JN()) {
        }
    }

    private boolean c(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getMsgType() == 126;
    }

    private boolean d(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bl() {
        br brVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.aAt.Bs()) {
            br[] JE = d.JD().JE();
            com.baidu.live.im.data.a remove = this.mMessages.remove(0);
            if (remove == null || TextUtils.isEmpty(remove.getContent()) || remove.JK() == null) {
                Bl();
                return;
            }
            if (remove.getMsgType() != 126) {
                brVar = null;
            } else if (JE != null) {
                int length = JE.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        brVar = null;
                        break;
                    }
                    brVar = JE[i];
                    if (brVar.id.equals(remove.JP())) {
                        break;
                    }
                    i++;
                }
                if (brVar == null) {
                    brVar = new br().CZ();
                }
            } else {
                return;
            }
            if (this.aAt.a(brVar, brVar == null ? a(remove.JR(), remove.JK()) : null, remove.JK(), e(remove), this.aAl, f(remove))) {
                Bl();
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

    private aj a(String[] strArr, com.baidu.live.data.a aVar) {
        aj ajVar;
        JSONObject optJSONObject;
        String optString;
        JSONObject optJSONObject2;
        boolean z;
        int i = 255;
        boolean z2 = strArr != null && strArr.length > 0 && TextUtils.equals(strArr[0], "guard_seat_effect");
        if (strArr == null || strArr.length <= 1 || com.baidu.live.w.a.Nk().bkd == null) {
            ajVar = null;
        } else {
            aj ajVar2 = new aj();
            ay ayVar = com.baidu.live.w.a.Nk().bkd.aJC;
            if (ayVar != null && ayVar.aJe != null && !TextUtils.isEmpty(strArr[0]) && (optJSONObject2 = ayVar.aJe.optJSONObject(strArr[0])) != null) {
                int optInt = optJSONObject2.optInt("transparency");
                if (optInt >= 0 && optInt <= 100) {
                    ajVar2.aIe = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
                } else {
                    ajVar2.aIe = 255;
                }
                ajVar2.aIf = optJSONObject2.optString("tail_icon");
                String optString2 = optJSONObject2.optString("start_color");
                String optString3 = optJSONObject2.optString("end_color");
                try {
                    if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                        ajVar2.aIa = Color.parseColor(optString2);
                        ajVar2.aIb = Color.parseColor(optString3);
                        z = true;
                    } else {
                        String optString4 = optJSONObject2.optString("bg_color");
                        if (TextUtils.isEmpty(optString4)) {
                            z = false;
                        } else {
                            ajVar2.aIa = Color.parseColor(optString4);
                            ajVar2.aIb = ajVar2.aIa;
                            z = true;
                        }
                    }
                    if (z) {
                        String optString5 = optJSONObject2.optString("frame_start_color");
                        String optString6 = optJSONObject2.optString("frame_end_color");
                        if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
                            ajVar2.aIc = Color.parseColor(optString5);
                            ajVar2.aId = Color.parseColor(optString6);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (ayVar != null && ayVar.aJf != null && !TextUtils.isEmpty(strArr[1]) && (optJSONObject = ayVar.aJf.optJSONObject(strArr[1])) != null) {
                String optString7 = optJSONObject.optString("bg_color");
                if (!TextUtils.isEmpty(optJSONObject.optString("transparency"))) {
                    try {
                        i = (int) (((Integer.parseInt(optString) * 1.0f) / 100.0f) * 255.0f);
                    } catch (Exception e2) {
                    }
                }
                if (!TextUtils.isEmpty(optString7)) {
                    ajVar2.aIg = Color.parseColor(optString7);
                    ajVar2.aIh = i;
                }
            }
            ajVar = ajVar2;
        }
        int c = c(aVar);
        boolean z3 = c >= 5;
        boolean z4 = c >= 2;
        if (!z2 && z3) {
            if (ajVar == null) {
                ajVar = new aj();
            }
            if (c == 7) {
                ajVar.aIa = Color.parseColor("#4e030c");
                ajVar.aIb = Color.parseColor("#4e030c");
            } else {
                ajVar.aIa = Color.parseColor("#031f33");
                ajVar.aIb = Color.parseColor("#031f33");
            }
            ajVar.aIe = 60;
            ajVar.aIc = Color.parseColor("#faca21");
            ajVar.aId = Color.parseColor("#faca21");
        }
        if (z4) {
            if (ajVar == null) {
                ajVar = new aj();
            }
            if (c == 7) {
                ajVar.aIg = Color.parseColor("#ffef76");
            } else {
                ajVar.aIg = Color.parseColor("#43c0a0");
            }
            ajVar.aIh = 100;
        }
        return ajVar;
    }

    private int c(com.baidu.live.data.a aVar) {
        if (aVar != null && !ListUtils.isEmpty(aVar.aCU)) {
            for (AlaLiveMarkData alaLiveMarkData : aVar.aCU) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.a aVar) {
        if (aVar != null && this.aAj != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.aCO, aVar.aCP, aVar.aCQ, String.valueOf(this.aAj.mLiveInfo.group_id), String.valueOf(this.aAj.mLiveInfo.live_id), this.aAk, String.valueOf(this.aAj.aDG.userId), aVar.appId, aVar.getNameShow(), "")));
        }
    }
}
