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
import com.baidu.live.data.af;
import com.baidu.live.data.ar;
import com.baidu.live.data.bj;
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
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.u.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements l {
    private q aJj;
    private l.a aTa;
    private boolean aTb;
    private String aTc;
    private CustomMessageListener aTe;
    private HttpMessageListener aTf;
    private CustomMessageListener aTg;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> aTh;
    private boolean aTi = false;
    private ImBarrageTrackListView aTk;
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
        this.aTa = aVar;
    }

    @Override // com.baidu.live.im.l
    public void a(q qVar, boolean z) {
        if (z) {
            if (!this.aTi) {
                this.aTi = true;
            } else {
                return;
            }
        }
        this.aTk.setCanAddNext();
        this.aTk.ED();
        CJ();
        a(qVar);
        Dg();
        Dm();
    }

    @Override // com.baidu.live.im.l
    public void a(q qVar) {
        boolean z = false;
        this.aJj = qVar;
        this.aTb = false;
        if (this.aJj != null && this.aJj.mLiveInfo != null) {
            this.aTc = String.valueOf(this.aJj.avj.userId);
            String valueOf = String.valueOf(this.aJj.mLiveInfo.user_id);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
                z = true;
            }
            this.aTb = z;
        }
    }

    @Override // com.baidu.live.im.l
    public View CI() {
        return this.aTk;
    }

    @Override // com.baidu.live.im.l
    public void CJ() {
        if (this.aTk != null) {
            this.aTk.CJ();
        }
    }

    @Override // com.baidu.live.im.l
    public void BZ() {
        Dh();
        Dn();
        this.aJj = null;
        if (this.mMessages != null) {
            this.mMessages.clear();
        }
        if (this.aTk != null) {
            this.aTk.release();
            if (this.aTk.getParent() != null) {
                ((ViewGroup) this.aTk.getParent()).removeView(this.aTk);
            }
        }
        this.aTi = false;
    }

    @Override // com.baidu.live.im.l
    public void release() {
        BZ();
        Dj();
        Dl();
        m.CL().release();
    }

    @Override // com.baidu.live.im.l
    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }

    private void initView() {
        this.aTk = new ImBarrageTrackListView(this.mPageContext.getPageActivity(), 3, new LandscapeImBarrageTrackView.a() { // from class: com.baidu.live.im.b.c.1
            @Override // com.baidu.live.im.view.LandscapeImBarrageTrackView.a
            public void c(com.baidu.live.data.a aVar) {
                c.this.b(aVar);
            }

            @Override // com.baidu.live.im.view.LandscapeImBarrageTrackView.a
            public void a(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
                c.this.aTk.c(landscapeImBarrageTrackView);
                c.this.Dp();
            }
        });
    }

    private void initListener() {
        Di();
        Dk();
    }

    private void Dg() {
        if (this.aTh == null) {
            this.aTh = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.live.im.b.c.2
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2913101, this.aTh);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void Dh() {
        MessageManager.getInstance().unRegisterTask(2913101);
    }

    private void Di() {
        this.aTe = new CustomMessageListener(2913102) { // from class: com.baidu.live.im.b.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(c.this.mPageContext.getPageActivity()) == 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    c.this.G((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aTe);
    }

    private void Dj() {
        if (this.aTe != null) {
            MessageManager.getInstance().unRegisterListener(this.aTe);
        }
    }

    private void Dk() {
        this.aTf = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.live.im.b.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021133 && (httpResponsedMessage instanceof ImBarragePayResponseMessage)) {
                    c.this.a((ImBarragePayResponseMessage) httpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aTf);
    }

    private void Dl() {
        if (this.aTf != null) {
            MessageManager.getInstance().unRegisterListener(this.aTf);
        }
    }

    private void Dm() {
        Dn();
        if (this.aTg == null) {
            this.aTg = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.b.c.5
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
        MessageManager.getInstance().registerListener(this.aTg);
    }

    private void Dn() {
        if (this.aTg != null) {
            MessageManager.getInstance().unRegisterListener(this.aTg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImSendMsgData imSendMsgData) {
        if (imSendMsgData.msgType == 126) {
            long j = imSendMsgData.price;
            if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                Do();
                return;
            }
            TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
            MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
        }
    }

    private void Do() {
        if (this.aTa != null) {
            this.aTa.CK();
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
        if (aVar.DF() == 1) {
            com.baidu.live.im.data.b DH = aVar.DH();
            if (DH != null && DH.aTD) {
                a(aVar.DG(), DH);
            } else {
                d(aVar.getMsgId(), aVar.DG());
            }
        }
    }

    private void d(long j, String str) {
        String yu = com.baidu.live.utils.q.yu();
        com.baidu.live.im.message.d dVar = new com.baidu.live.im.message.d();
        dVar.addParam("scene_from", yu);
        dVar.addParam("live_id", this.aJj.mLiveInfo.live_id);
        dVar.addParam("im_id", j);
        dVar.addParam("barrage_id", str);
        MessageManager.getInstance().sendMessage(dVar);
    }

    private void a(String str, com.baidu.live.im.data.b bVar) {
        s sVar;
        Map<String, s> ym = t.yl().ym();
        if (ym != null && ym.containsKey(str) && (sVar = ym.get(str)) != null) {
            v.c(sVar.itemId, sVar.aEr, bVar.aTE, bVar.liveId, 1, 0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImBarragePayResponseMessage imBarragePayResponseMessage) {
        if (imBarragePayResponseMessage.getError() == 0) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = imBarragePayResponseMessage.Ax();
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
                if (aVar.DE() && z2) {
                    if (this.mMessages == null) {
                        this.mMessages = new ArrayList();
                    }
                    boolean r = r(aVar);
                    if (r || this.mMessages.size() <= com.baidu.live.v.a.Ge().aWF.ayo) {
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
                        Dp();
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
        if (aVar.DE()) {
        }
    }

    private boolean q(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getMsgType() == 126;
    }

    private boolean r(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dp() {
        bj bjVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.aTk.Ey()) {
            bj[] CM = m.CL().CM();
            com.baidu.live.im.data.a remove = this.mMessages.remove(0);
            if (remove == null || TextUtils.isEmpty(remove.getContent()) || remove.DB() == null) {
                Dp();
                return;
            }
            if (remove.getMsgType() != 126) {
                bjVar = null;
            } else if (CM != null) {
                int length = CM.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        bjVar = null;
                        break;
                    }
                    bjVar = CM[i];
                    if (bjVar.id.equals(remove.DG())) {
                        break;
                    }
                    i++;
                }
                if (bjVar == null) {
                    bjVar = new bj().wv();
                }
            } else {
                return;
            }
            if (this.aTk.c(bjVar, bjVar == null ? a(remove.DI(), remove.DB()) : null, remove.DB(), s(remove), this.aTc, t(remove))) {
                Dp();
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

    private af a(String[] strArr, com.baidu.live.data.a aVar) {
        af afVar;
        JSONObject optJSONObject;
        String optString;
        JSONObject optJSONObject2;
        boolean z;
        int i = 255;
        boolean z2 = strArr != null && strArr.length > 0 && TextUtils.equals(strArr[0], "guard_seat_effect");
        if (strArr == null || strArr.length <= 1 || com.baidu.live.v.a.Ge().aYP == null) {
            afVar = null;
        } else {
            af afVar2 = new af();
            ar arVar = com.baidu.live.v.a.Ge().aYP.aAK;
            if (arVar != null && arVar.aAm != null && !TextUtils.isEmpty(strArr[0]) && (optJSONObject2 = arVar.aAm.optJSONObject(strArr[0])) != null) {
                int optInt = optJSONObject2.optInt("transparency");
                if (optInt >= 0 && optInt <= 100) {
                    afVar2.azg = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
                } else {
                    afVar2.azg = 255;
                }
                afVar2.azh = optJSONObject2.optString("tail_icon");
                String optString2 = optJSONObject2.optString("start_color");
                String optString3 = optJSONObject2.optString("end_color");
                try {
                    if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                        afVar2.azc = Color.parseColor(optString2);
                        afVar2.azd = Color.parseColor(optString3);
                        z = true;
                    } else {
                        String optString4 = optJSONObject2.optString("bg_color");
                        if (TextUtils.isEmpty(optString4)) {
                            z = false;
                        } else {
                            afVar2.azc = Color.parseColor(optString4);
                            afVar2.azd = afVar2.azc;
                            z = true;
                        }
                    }
                    if (z) {
                        String optString5 = optJSONObject2.optString("frame_start_color");
                        String optString6 = optJSONObject2.optString("frame_end_color");
                        if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
                            afVar2.aze = Color.parseColor(optString5);
                            afVar2.azf = Color.parseColor(optString6);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (arVar != null && arVar.aAn != null && !TextUtils.isEmpty(strArr[1]) && (optJSONObject = arVar.aAn.optJSONObject(strArr[1])) != null) {
                String optString7 = optJSONObject.optString("bg_color");
                if (!TextUtils.isEmpty(optJSONObject.optString("transparency"))) {
                    try {
                        i = (int) (((Integer.parseInt(optString) * 1.0f) / 100.0f) * 255.0f);
                    } catch (Exception e2) {
                    }
                }
                if (!TextUtils.isEmpty(optString7)) {
                    afVar2.azi = Color.parseColor(optString7);
                    afVar2.azj = i;
                }
            }
            afVar = afVar2;
        }
        int d = d(aVar);
        boolean z3 = d >= 5;
        boolean z4 = d >= 2;
        if (!z2 && z3) {
            if (afVar == null) {
                afVar = new af();
            }
            if (d == 7) {
                afVar.azc = Color.parseColor("#4e030c");
                afVar.azd = Color.parseColor("#4e030c");
            } else {
                afVar.azc = Color.parseColor("#031f33");
                afVar.azd = Color.parseColor("#031f33");
            }
            afVar.azg = 60;
            afVar.aze = Color.parseColor("#faca21");
            afVar.azf = Color.parseColor("#faca21");
        }
        if (z4) {
            if (afVar == null) {
                afVar = new af();
            }
            if (d == 7) {
                afVar.azi = Color.parseColor("#ffef76");
            } else {
                afVar.azi = Color.parseColor("#43c0a0");
            }
            afVar.azj = 100;
        }
        return afVar;
    }

    private int d(com.baidu.live.data.a aVar) {
        if (aVar != null && !ListUtils.isEmpty(aVar.aux)) {
            for (AlaLiveMarkData alaLiveMarkData : aVar.aux) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.live.data.a aVar) {
        if (aVar != null && this.aJj != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.aur, aVar.aus, aVar.aut, String.valueOf(this.aJj.mLiveInfo.group_id), String.valueOf(this.aJj.mLiveInfo.live_id), this.aTb, String.valueOf(this.aJj.avj.userId), aVar.appId, aVar.getNameShow(), "")));
        }
    }
}
