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
import com.baidu.live.data.ao;
import com.baidu.live.data.bd;
import com.baidu.live.data.bz;
import com.baidu.live.data.u;
import com.baidu.live.gift.t;
import com.baidu.live.gift.w;
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
    private a.InterfaceC0177a aAO;
    private u aAP;
    private boolean aAQ;
    private String aAR;
    private CustomMessageListener aAT;
    private HttpMessageListener aAU;
    private CustomMessageListener aAV;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> aAW;
    private boolean aAX = false;
    private ImBarrageTrackListView aAZ;
    private List<com.baidu.live.im.data.a> mMessages;
    private String mOtherParams;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
        initListener();
    }

    @Override // com.baidu.live.im.b.a
    public void a(a.InterfaceC0177a interfaceC0177a) {
        this.aAO = interfaceC0177a;
    }

    @Override // com.baidu.live.im.b.a
    public void a(u uVar, boolean z) {
        if (z) {
            if (!this.aAX) {
                this.aAX = true;
            } else {
                return;
            }
        }
        this.aAZ.setCanAddNext();
        this.aAZ.BG();
        Bp();
        a(uVar);
        Br();
        Bx();
    }

    @Override // com.baidu.live.im.b.a
    public void a(u uVar) {
        boolean z = false;
        this.aAP = uVar;
        this.aAQ = false;
        if (this.aAP != null && this.aAP.mLiveInfo != null) {
            this.aAR = String.valueOf(this.aAP.aEz.userId);
            String valueOf = String.valueOf(this.aAP.mLiveInfo.user_id);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
                z = true;
            }
            this.aAQ = z;
        }
    }

    @Override // com.baidu.live.im.b.a
    public View Bo() {
        return this.aAZ;
    }

    @Override // com.baidu.live.im.b.a
    public void Bp() {
        if (this.aAZ != null) {
            this.aAZ.Bp();
        }
    }

    @Override // com.baidu.live.im.b.a
    public void Bq() {
        Bs();
        By();
        this.aAP = null;
        if (this.mMessages != null) {
            this.mMessages.clear();
        }
        if (this.aAZ != null) {
            this.aAZ.release();
            if (this.aAZ.getParent() != null) {
                ((ViewGroup) this.aAZ.getParent()).removeView(this.aAZ);
            }
        }
        this.aAX = false;
    }

    @Override // com.baidu.live.im.b.a
    public void release() {
        Bq();
        Bu();
        Bw();
        d.Kh().release();
    }

    @Override // com.baidu.live.im.b.a
    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }

    private void initView() {
        this.aAZ = new ImBarrageTrackListView(this.mPageContext.getPageActivity(), 3, new LandscapeImBarrageTrackView.a() { // from class: com.baidu.live.barrage.a.b.1
            @Override // com.baidu.live.barrage.view.LandscapeImBarrageTrackView.a
            public void b(com.baidu.live.data.a aVar) {
                b.this.a(aVar);
            }

            @Override // com.baidu.live.barrage.view.LandscapeImBarrageTrackView.a
            public void a(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
                b.this.aAZ.b(landscapeImBarrageTrackView);
                b.this.BA();
            }
        });
    }

    private void initListener() {
        Bt();
        Bv();
    }

    private void Br() {
        if (this.aAW == null) {
            this.aAW = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.live.barrage.a.b.2
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2913101, this.aAW);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void Bs() {
        MessageManager.getInstance().unRegisterTask(2913101);
    }

    private void Bt() {
        this.aAT = new CustomMessageListener(2913102) { // from class: com.baidu.live.barrage.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(b.this.mPageContext.getPageActivity()) == 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.s((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aAT);
    }

    private void Bu() {
        if (this.aAT != null) {
            MessageManager.getInstance().unRegisterListener(this.aAT);
        }
    }

    private void Bv() {
        this.aAU = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.live.barrage.a.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021133 && (httpResponsedMessage instanceof ImBarragePayResponseMessage)) {
                    b.this.a((ImBarragePayResponseMessage) httpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aAU);
    }

    private void Bw() {
        if (this.aAU != null) {
            MessageManager.getInstance().unRegisterListener(this.aAU);
        }
    }

    private void Bx() {
        By();
        if (this.aAV == null) {
            this.aAV = new CustomMessageListener(2913037) { // from class: com.baidu.live.barrage.a.b.5
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
        MessageManager.getInstance().registerListener(this.aAV);
    }

    private void By() {
        if (this.aAV != null) {
            MessageManager.getInstance().unRegisterListener(this.aAV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImSendMsgData imSendMsgData) {
        if (imSendMsgData.msgType == 126) {
            long j = imSendMsgData.price;
            if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                Bz();
                return;
            }
            TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
            MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
        }
    }

    private void Bz() {
        if (this.aAO != null) {
            this.aAO.Kg();
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
        if (aVar.Ks() == 1) {
            com.baidu.live.im.data.b Ku = aVar.Ku();
            if (Ku != null && Ku.bfi) {
                a(aVar.Kt(), Ku, aVar.bfg);
            } else {
                b(aVar.getMsgId(), aVar.Kt());
            }
        }
    }

    private void b(long j, String str) {
        String Fz = p.Fz();
        com.baidu.live.im.message.d dVar = new com.baidu.live.im.message.d();
        dVar.addParam("scene_from", Fz);
        dVar.addParam("live_id", this.aAP.mLiveInfo.live_id);
        dVar.addParam("im_id", j);
        dVar.addParam("barrage_id", str);
        MessageManager.getInstance().sendMessage(dVar);
    }

    private void a(String str, com.baidu.live.im.data.b bVar, String str2) {
        t tVar;
        Map<String, t> Fl = com.baidu.live.gift.u.Fk().Fl();
        if (Fl != null && Fl.containsKey(str) && (tVar = Fl.get(str)) != null) {
            w.b(tVar.itemId, tVar.aPu, bVar.bfj, bVar.liveId, 1, 0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImBarragePayResponseMessage imBarragePayResponseMessage) {
        if (imBarragePayResponseMessage.getError() == 0) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = imBarragePayResponseMessage.HC();
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
                if (aVar.Kr() && z2) {
                    if (this.mMessages == null) {
                        this.mMessages = new ArrayList();
                    }
                    boolean d = d(aVar);
                    if (d || this.mMessages.size() <= com.baidu.live.x.a.NN().bhy.aIs) {
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
                        BA();
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
        if (aVar.Kr()) {
        }
    }

    private boolean c(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getMsgType() == 126;
    }

    private boolean d(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BA() {
        bz bzVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.aAZ.BH()) {
            bz[] Ki = d.Kh().Ki();
            com.baidu.live.im.data.a remove = this.mMessages.remove(0);
            if (remove == null || TextUtils.isEmpty(remove.getContent()) || remove.Ko() == null) {
                BA();
                return;
            }
            if (remove.getMsgType() != 126) {
                bzVar = null;
            } else if (Ki != null) {
                int length = Ki.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        bzVar = null;
                        break;
                    }
                    bzVar = Ki[i];
                    if (bzVar.id.equals(remove.Kt())) {
                        break;
                    }
                    i++;
                }
                if (bzVar == null) {
                    bzVar = new bz().Dp();
                }
            } else {
                return;
            }
            if (this.aAZ.a(bzVar, bzVar == null ? a(remove.Kv(), remove.Ko()) : null, remove.Ko(), e(remove), this.aAR, f(remove))) {
                BA();
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

    private ao a(String[] strArr, com.baidu.live.data.a aVar) {
        ao aoVar;
        JSONObject optJSONObject;
        String optString;
        JSONObject optJSONObject2;
        boolean z;
        int i = 255;
        boolean z2 = strArr != null && strArr.length > 0 && TextUtils.equals(strArr[0], "guard_seat_effect");
        if (strArr == null || strArr.length <= 1 || com.baidu.live.x.a.NN().bmW == null) {
            aoVar = null;
        } else {
            ao aoVar2 = new ao();
            bd bdVar = com.baidu.live.x.a.NN().bmW.aKS;
            if (bdVar != null && bdVar.aKu != null && !TextUtils.isEmpty(strArr[0]) && (optJSONObject2 = bdVar.aKu.optJSONObject(strArr[0])) != null) {
                int optInt = optJSONObject2.optInt("transparency");
                if (optInt >= 0 && optInt <= 100) {
                    aoVar2.aJz = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
                } else {
                    aoVar2.aJz = 255;
                }
                aoVar2.aJA = optJSONObject2.optString("tail_icon");
                String optString2 = optJSONObject2.optString("start_color");
                String optString3 = optJSONObject2.optString("end_color");
                try {
                    if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                        aoVar2.aJv = Color.parseColor(optString2);
                        aoVar2.aJw = Color.parseColor(optString3);
                        z = true;
                    } else {
                        String optString4 = optJSONObject2.optString("bg_color");
                        if (TextUtils.isEmpty(optString4)) {
                            z = false;
                        } else {
                            aoVar2.aJv = Color.parseColor(optString4);
                            aoVar2.aJw = aoVar2.aJv;
                            z = true;
                        }
                    }
                    if (z) {
                        String optString5 = optJSONObject2.optString("frame_start_color");
                        String optString6 = optJSONObject2.optString("frame_end_color");
                        if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
                            aoVar2.aJx = Color.parseColor(optString5);
                            aoVar2.aJy = Color.parseColor(optString6);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (bdVar != null && bdVar.aKv != null && !TextUtils.isEmpty(strArr[1]) && (optJSONObject = bdVar.aKv.optJSONObject(strArr[1])) != null) {
                String optString7 = optJSONObject.optString("bg_color");
                if (!TextUtils.isEmpty(optJSONObject.optString("transparency"))) {
                    try {
                        i = (int) (((Integer.parseInt(optString) * 1.0f) / 100.0f) * 255.0f);
                    } catch (Exception e2) {
                    }
                }
                if (!TextUtils.isEmpty(optString7)) {
                    aoVar2.aJB = Color.parseColor(optString7);
                    aoVar2.aJC = i;
                }
            }
            aoVar = aoVar2;
        }
        int c = c(aVar);
        boolean z3 = c >= 5;
        boolean z4 = c >= 2;
        if (!z2 && z3) {
            if (aoVar == null) {
                aoVar = new ao();
            }
            if (c == 7) {
                aoVar.aJv = Color.parseColor("#4e030c");
                aoVar.aJw = Color.parseColor("#4e030c");
            } else {
                aoVar.aJv = Color.parseColor("#031f33");
                aoVar.aJw = Color.parseColor("#031f33");
            }
            aoVar.aJz = 60;
            aoVar.aJx = Color.parseColor("#faca21");
            aoVar.aJy = Color.parseColor("#faca21");
        }
        if (z4) {
            if (aoVar == null) {
                aoVar = new ao();
            }
            if (c == 7) {
                aoVar.aJB = Color.parseColor("#ffef76");
            } else {
                aoVar.aJB = Color.parseColor("#43c0a0");
            }
            aoVar.aJC = 100;
        }
        return aoVar;
    }

    private int c(com.baidu.live.data.a aVar) {
        if (aVar != null && !ListUtils.isEmpty(aVar.aDE)) {
            for (AlaLiveMarkData alaLiveMarkData : aVar.aDE) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.a aVar) {
        if (aVar != null && this.aAP != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.aDy, aVar.aDz, aVar.aDA, String.valueOf(this.aAP.mLiveInfo.group_id), String.valueOf(this.aAP.mLiveInfo.live_id), this.aAQ, String.valueOf(this.aAP.aEz.userId), aVar.appId, aVar.getNameShow(), "")));
        }
    }
}
