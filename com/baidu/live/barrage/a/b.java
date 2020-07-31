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
import com.baidu.live.data.ah;
import com.baidu.live.data.aw;
import com.baidu.live.data.bp;
import com.baidu.live.data.q;
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
/* loaded from: classes4.dex */
public class b implements com.baidu.live.im.b.a {
    private a.InterfaceC0167a ave;
    private q avf;
    private boolean avg;
    private String avh;
    private CustomMessageListener avj;
    private HttpMessageListener avk;
    private CustomMessageListener avl;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> avm;
    private boolean avn = false;
    private ImBarrageTrackListView avp;
    private List<com.baidu.live.im.data.a> mMessages;
    private String mOtherParams;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
        initListener();
    }

    @Override // com.baidu.live.im.b.a
    public void a(a.InterfaceC0167a interfaceC0167a) {
        this.ave = interfaceC0167a;
    }

    @Override // com.baidu.live.im.b.a
    public void a(q qVar, boolean z) {
        if (z) {
            if (!this.avn) {
                this.avn = true;
            } else {
                return;
            }
        }
        this.avp.setCanAddNext();
        this.avp.vT();
        vC();
        a(qVar);
        vE();
        vK();
    }

    @Override // com.baidu.live.im.b.a
    public void a(q qVar) {
        boolean z = false;
        this.avf = qVar;
        this.avg = false;
        if (this.avf != null && this.avf.mLiveInfo != null) {
            this.avh = String.valueOf(this.avf.ayC.userId);
            String valueOf = String.valueOf(this.avf.mLiveInfo.user_id);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
                z = true;
            }
            this.avg = z;
        }
    }

    @Override // com.baidu.live.im.b.a
    public View vB() {
        return this.avp;
    }

    @Override // com.baidu.live.im.b.a
    public void vC() {
        if (this.avp != null) {
            this.avp.vC();
        }
    }

    @Override // com.baidu.live.im.b.a
    public void vD() {
        vF();
        vL();
        this.avf = null;
        if (this.mMessages != null) {
            this.mMessages.clear();
        }
        if (this.avp != null) {
            this.avp.release();
            if (this.avp.getParent() != null) {
                ((ViewGroup) this.avp.getParent()).removeView(this.avp);
            }
        }
        this.avn = false;
    }

    @Override // com.baidu.live.im.b.a
    public void release() {
        vD();
        vH();
        vJ();
        d.Ea().release();
    }

    @Override // com.baidu.live.im.b.a
    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }

    private void initView() {
        this.avp = new ImBarrageTrackListView(this.mPageContext.getPageActivity(), 3, new LandscapeImBarrageTrackView.a() { // from class: com.baidu.live.barrage.a.b.1
            @Override // com.baidu.live.barrage.view.LandscapeImBarrageTrackView.a
            public void b(com.baidu.live.data.a aVar) {
                b.this.a(aVar);
            }

            @Override // com.baidu.live.barrage.view.LandscapeImBarrageTrackView.a
            public void a(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
                b.this.avp.b(landscapeImBarrageTrackView);
                b.this.vN();
            }
        });
    }

    private void initListener() {
        vG();
        vI();
    }

    private void vE() {
        if (this.avm == null) {
            this.avm = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.live.barrage.a.b.2
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2913101, this.avm);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void vF() {
        MessageManager.getInstance().unRegisterTask(2913101);
    }

    private void vG() {
        this.avj = new CustomMessageListener(2913102) { // from class: com.baidu.live.barrage.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(b.this.mPageContext.getPageActivity()) == 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.r((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.avj);
    }

    private void vH() {
        if (this.avj != null) {
            MessageManager.getInstance().unRegisterListener(this.avj);
        }
    }

    private void vI() {
        this.avk = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.live.barrage.a.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021133 && (httpResponsedMessage instanceof ImBarragePayResponseMessage)) {
                    b.this.a((ImBarragePayResponseMessage) httpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.avk);
    }

    private void vJ() {
        if (this.avk != null) {
            MessageManager.getInstance().unRegisterListener(this.avk);
        }
    }

    private void vK() {
        vL();
        if (this.avl == null) {
            this.avl = new CustomMessageListener(2913037) { // from class: com.baidu.live.barrage.a.b.5
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
        MessageManager.getInstance().registerListener(this.avl);
    }

    private void vL() {
        if (this.avl != null) {
            MessageManager.getInstance().unRegisterListener(this.avl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImSendMsgData imSendMsgData) {
        if (imSendMsgData.msgType == 126) {
            long j = imSendMsgData.price;
            if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                vM();
                return;
            }
            TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
            MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
        }
    }

    private void vM() {
        if (this.ave != null) {
            this.ave.DZ();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mPageContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(List list) {
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
        if (aVar.El() == 1) {
            com.baidu.live.im.data.b En = aVar.En();
            if (En != null && En.aXe) {
                a(aVar.Em(), En);
            } else {
                b(aVar.getMsgId(), aVar.Em());
            }
        }
    }

    private void b(long j, String str) {
        String zw = p.zw();
        com.baidu.live.im.message.d dVar = new com.baidu.live.im.message.d();
        dVar.addParam("scene_from", zw);
        dVar.addParam("live_id", this.avf.mLiveInfo.live_id);
        dVar.addParam("im_id", j);
        dVar.addParam("barrage_id", str);
        MessageManager.getInstance().sendMessage(dVar);
    }

    private void a(String str, com.baidu.live.im.data.b bVar) {
        s sVar;
        Map<String, s> zo = t.zn().zo();
        if (zo != null && zo.containsKey(str) && (sVar = zo.get(str)) != null) {
            v.c(sVar.itemId, sVar.aIi, bVar.aXf, bVar.liveId, 1, 0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImBarragePayResponseMessage imBarragePayResponseMessage) {
        if (imBarragePayResponseMessage.getError() == 0) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = imBarragePayResponseMessage.Bz();
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
                if (aVar.Ek() && z2) {
                    if (this.mMessages == null) {
                        this.mMessages = new ArrayList();
                    }
                    boolean d = d(aVar);
                    if (d || this.mMessages.size() <= com.baidu.live.v.a.Hs().aZn.aBQ) {
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
                        vN();
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
        if (aVar.Ek()) {
        }
    }

    private boolean c(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getMsgType() == 126;
    }

    private boolean d(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vN() {
        bp bpVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.avp.vU()) {
            bp[] Eb = d.Ea().Eb();
            com.baidu.live.im.data.a remove = this.mMessages.remove(0);
            if (remove == null || TextUtils.isEmpty(remove.getContent()) || remove.Eh() == null) {
                vN();
                return;
            }
            if (remove.getMsgType() != 126) {
                bpVar = null;
            } else if (Eb != null) {
                int length = Eb.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        bpVar = null;
                        break;
                    }
                    bpVar = Eb[i];
                    if (bpVar.id.equals(remove.Em())) {
                        break;
                    }
                    i++;
                }
                if (bpVar == null) {
                    bpVar = new bp().xw();
                }
            } else {
                return;
            }
            if (this.avp.a(bpVar, bpVar == null ? a(remove.Eo(), remove.Eh()) : null, remove.Eh(), e(remove), this.avh, f(remove))) {
                vN();
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

    private ah a(String[] strArr, com.baidu.live.data.a aVar) {
        ah ahVar;
        JSONObject optJSONObject;
        String optString;
        JSONObject optJSONObject2;
        boolean z;
        int i = 255;
        boolean z2 = strArr != null && strArr.length > 0 && TextUtils.equals(strArr[0], "guard_seat_effect");
        if (strArr == null || strArr.length <= 1 || com.baidu.live.v.a.Hs().beo == null) {
            ahVar = null;
        } else {
            ah ahVar2 = new ah();
            aw awVar = com.baidu.live.v.a.Hs().beo.aEq;
            if (awVar != null && awVar.aDS != null && !TextUtils.isEmpty(strArr[0]) && (optJSONObject2 = awVar.aDS.optJSONObject(strArr[0])) != null) {
                int optInt = optJSONObject2.optInt("transparency");
                if (optInt >= 0 && optInt <= 100) {
                    ahVar2.aCS = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
                } else {
                    ahVar2.aCS = 255;
                }
                ahVar2.aCT = optJSONObject2.optString("tail_icon");
                String optString2 = optJSONObject2.optString("start_color");
                String optString3 = optJSONObject2.optString("end_color");
                try {
                    if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                        ahVar2.aCO = Color.parseColor(optString2);
                        ahVar2.aCP = Color.parseColor(optString3);
                        z = true;
                    } else {
                        String optString4 = optJSONObject2.optString("bg_color");
                        if (TextUtils.isEmpty(optString4)) {
                            z = false;
                        } else {
                            ahVar2.aCO = Color.parseColor(optString4);
                            ahVar2.aCP = ahVar2.aCO;
                            z = true;
                        }
                    }
                    if (z) {
                        String optString5 = optJSONObject2.optString("frame_start_color");
                        String optString6 = optJSONObject2.optString("frame_end_color");
                        if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
                            ahVar2.aCQ = Color.parseColor(optString5);
                            ahVar2.aCR = Color.parseColor(optString6);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (awVar != null && awVar.aDT != null && !TextUtils.isEmpty(strArr[1]) && (optJSONObject = awVar.aDT.optJSONObject(strArr[1])) != null) {
                String optString7 = optJSONObject.optString("bg_color");
                if (!TextUtils.isEmpty(optJSONObject.optString("transparency"))) {
                    try {
                        i = (int) (((Integer.parseInt(optString) * 1.0f) / 100.0f) * 255.0f);
                    } catch (Exception e2) {
                    }
                }
                if (!TextUtils.isEmpty(optString7)) {
                    ahVar2.aCU = Color.parseColor(optString7);
                    ahVar2.aCV = i;
                }
            }
            ahVar = ahVar2;
        }
        int c = c(aVar);
        boolean z3 = c >= 5;
        boolean z4 = c >= 2;
        if (!z2 && z3) {
            if (ahVar == null) {
                ahVar = new ah();
            }
            if (c == 7) {
                ahVar.aCO = Color.parseColor("#4e030c");
                ahVar.aCP = Color.parseColor("#4e030c");
            } else {
                ahVar.aCO = Color.parseColor("#031f33");
                ahVar.aCP = Color.parseColor("#031f33");
            }
            ahVar.aCS = 60;
            ahVar.aCQ = Color.parseColor("#faca21");
            ahVar.aCR = Color.parseColor("#faca21");
        }
        if (z4) {
            if (ahVar == null) {
                ahVar = new ah();
            }
            if (c == 7) {
                ahVar.aCU = Color.parseColor("#ffef76");
            } else {
                ahVar.aCU = Color.parseColor("#43c0a0");
            }
            ahVar.aCV = 100;
        }
        return ahVar;
    }

    private int c(com.baidu.live.data.a aVar) {
        if (aVar != null && !ListUtils.isEmpty(aVar.axQ)) {
            for (AlaLiveMarkData alaLiveMarkData : aVar.axQ) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.a aVar) {
        if (aVar != null && this.avf != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.axK, aVar.axL, aVar.axM, String.valueOf(this.avf.mLiveInfo.group_id), String.valueOf(this.avf.mLiveInfo.live_id), this.avg, String.valueOf(this.avf.ayC.userId), aVar.appId, aVar.getNameShow(), "")));
        }
    }
}
