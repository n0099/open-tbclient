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
import com.baidu.live.data.aw;
import com.baidu.live.data.bl;
import com.baidu.live.data.ck;
import com.baidu.live.data.x;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.y;
import com.baidu.live.gift.z;
import com.baidu.live.im.b.a;
import com.baidu.live.im.b.d;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.message.ImBarragePayResponseMessage;
import com.baidu.live.p.c;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.utils.q;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b implements com.baidu.live.im.b.a {
    private a.InterfaceC0186a aGd;
    private x aGe;
    private boolean aGf;
    private String aGg;
    private CustomMessageListener aGi;
    private HttpMessageListener aGj;
    private CustomMessageListener aGk;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> aGl;
    private boolean aGm = false;
    private ImBarrageTrackListView aGo;
    private List<com.baidu.live.im.data.b> mMessages;
    private String mOtherParams;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
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
        this.aGo.setCanAddNext();
        this.aGo.Ds();
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
        return this.aGo;
    }

    @Override // com.baidu.live.im.b.a
    public void Db() {
        if (this.aGo != null) {
            this.aGo.Db();
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
        if (this.aGo != null) {
            this.aGo.release();
            if (this.aGo.getParent() != null) {
                ((ViewGroup) this.aGo.getParent()).removeView(this.aGo);
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
        this.aGo = new ImBarrageTrackListView(this.mPageContext.getPageActivity(), 3, new LandscapeImBarrageTrackView.a() { // from class: com.baidu.live.barrage.a.b.1
            @Override // com.baidu.live.barrage.view.LandscapeImBarrageTrackView.a
            public void b(com.baidu.live.data.a aVar) {
                b.this.a(aVar);
            }

            @Override // com.baidu.live.barrage.view.LandscapeImBarrageTrackView.a
            public void a(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
                b.this.aGo.b(landscapeImBarrageTrackView);
                b.this.Dm();
            }
        });
    }

    private void initListener() {
        Df();
        Dh();
    }

    private void Dd() {
        if (this.aGl == null) {
            this.aGl = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.live.barrage.a.b.2
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2913101, this.aGl);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void De() {
        MessageManager.getInstance().unRegisterTask(2913101);
    }

    private void Df() {
        this.aGi = new CustomMessageListener(2913102) { // from class: com.baidu.live.barrage.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(b.this.mPageContext.getPageActivity()) == 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.v((List) customResponsedMessage.getData());
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
        this.aGj = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.live.barrage.a.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021133 && (httpResponsedMessage instanceof ImBarragePayResponseMessage)) {
                    b.this.a((ImBarragePayResponseMessage) httpResponsedMessage);
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
        Dk();
        if (this.aGk == null) {
            this.aGk = new CustomMessageListener(2913037) { // from class: com.baidu.live.barrage.a.b.5
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
            long j = imSendMsgData.price;
            if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                Dl();
                return;
            }
            TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
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
        String Ia = q.Ia();
        com.baidu.live.im.message.d dVar = new com.baidu.live.im.message.d();
        dVar.addParam("scene_from", Ia);
        dVar.addParam("live_id", this.aGe.mLiveInfo.live_id);
        dVar.addParam("im_id", j);
        dVar.addParam("barrage_id", str);
        MessageManager.getInstance().sendMessage(dVar);
    }

    private void a(String str, com.baidu.live.im.data.d dVar, String str2) {
        y yVar;
        Map<String, y> HK = z.HJ().HK();
        if (HK != null && HK.containsKey(str) && (yVar = HK.get(str)) != null) {
            ac.b(yVar.itemId, yVar.aXT, dVar.beO, dVar.liveId, 1, 0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImBarragePayResponseMessage imBarragePayResponseMessage) {
        if (imBarragePayResponseMessage.getError() == 0) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = imBarragePayResponseMessage.Kl();
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
                if (bVar.Nz() && z2) {
                    if (this.mMessages == null) {
                        this.mMessages = new ArrayList();
                    }
                    boolean d = d(bVar);
                    if (d || this.mMessages.size() <= com.baidu.live.af.a.SE().bwi.aOR) {
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
                        Dm();
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
        if (bVar.Nz()) {
        }
    }

    private boolean c(com.baidu.live.im.data.b bVar) {
        return bVar != null && bVar.getMsgType() == 126;
    }

    private boolean d(com.baidu.live.im.data.b bVar) {
        return bVar != null && bVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dm() {
        ck ckVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.aGo.Dt()) {
            ck[] Nl = d.Nk().Nl();
            com.baidu.live.im.data.b remove = this.mMessages.remove(0);
            if (remove == null || TextUtils.isEmpty(remove.getContent()) || remove.Nw() == null) {
                Dm();
                return;
            }
            if (remove.getMsgType() != 126) {
                ckVar = null;
            } else if (Nl != null) {
                int length = Nl.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        ckVar = null;
                        break;
                    }
                    ckVar = Nl[i];
                    if (ckVar.id.equals(remove.NB())) {
                        break;
                    }
                    i++;
                }
                if (ckVar == null) {
                    ckVar = new ck().Fr();
                }
            } else {
                return;
            }
            if (this.aGo.a(ckVar, ckVar == null ? a(remove.ND(), remove.Nw()) : null, remove.Nw(), e(remove), this.aGg, f(remove))) {
                Dm();
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

    private aw a(String[] strArr, com.baidu.live.data.a aVar) {
        aw awVar;
        JSONObject optJSONObject;
        String optString;
        JSONObject optJSONObject2;
        boolean z;
        int i = 255;
        boolean z2 = strArr != null && strArr.length > 0 && TextUtils.equals(strArr[0], "guard_seat_effect");
        if (strArr == null || strArr.length <= 1 || com.baidu.live.af.a.SE().bCb == null) {
            awVar = null;
        } else {
            aw awVar2 = new aw();
            bl blVar = com.baidu.live.af.a.SE().bCb.aRD;
            if (blVar != null && blVar.aRk != null && !TextUtils.isEmpty(strArr[0]) && (optJSONObject2 = blVar.aRk.optJSONObject(strArr[0])) != null) {
                int optInt = optJSONObject2.optInt("transparency");
                if (optInt >= 0 && optInt <= 100) {
                    awVar2.aQp = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
                } else {
                    awVar2.aQp = 255;
                }
                awVar2.aQq = optJSONObject2.optString("tail_icon");
                String optString2 = optJSONObject2.optString("start_color");
                String optString3 = optJSONObject2.optString("end_color");
                try {
                    if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                        awVar2.aQl = Color.parseColor(optString2);
                        awVar2.aQm = Color.parseColor(optString3);
                        z = true;
                    } else {
                        String optString4 = optJSONObject2.optString("bg_color");
                        if (TextUtils.isEmpty(optString4)) {
                            z = false;
                        } else {
                            awVar2.aQl = Color.parseColor(optString4);
                            awVar2.aQm = awVar2.aQl;
                            z = true;
                        }
                    }
                    if (z) {
                        String optString5 = optJSONObject2.optString("frame_start_color");
                        String optString6 = optJSONObject2.optString("frame_end_color");
                        if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
                            awVar2.aQn = Color.parseColor(optString5);
                            awVar2.aQo = Color.parseColor(optString6);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (blVar != null && blVar.aRl != null && !TextUtils.isEmpty(strArr[1]) && (optJSONObject = blVar.aRl.optJSONObject(strArr[1])) != null) {
                String optString7 = optJSONObject.optString("bg_color");
                if (!TextUtils.isEmpty(optJSONObject.optString("transparency"))) {
                    try {
                        i = (int) (((Integer.parseInt(optString) * 1.0f) / 100.0f) * 255.0f);
                    } catch (Exception e2) {
                    }
                }
                if (!TextUtils.isEmpty(optString7)) {
                    awVar2.aQr = Color.parseColor(optString7);
                    awVar2.aQs = i;
                }
            }
            awVar = awVar2;
        }
        int c = c(aVar);
        boolean z3 = c >= 5;
        boolean z4 = c >= 2;
        if (!z2 && z3) {
            if (awVar == null) {
                awVar = new aw();
            }
            if (c == 7) {
                awVar.aQl = Color.parseColor("#4e030c");
                awVar.aQm = Color.parseColor("#4e030c");
            } else {
                awVar.aQl = Color.parseColor("#031f33");
                awVar.aQm = Color.parseColor("#031f33");
            }
            awVar.aQp = 60;
            awVar.aQn = Color.parseColor("#faca21");
            awVar.aQo = Color.parseColor("#faca21");
        }
        if (z4) {
            if (awVar == null) {
                awVar = new aw();
            }
            if (c == 7) {
                awVar.aQr = Color.parseColor("#ffef76");
            } else {
                awVar.aQr = Color.parseColor("#43c0a0");
            }
            awVar.aQs = 100;
        }
        return awVar;
    }

    private int c(com.baidu.live.data.a aVar) {
        if (aVar != null && !ListUtils.isEmpty(aVar.aIZ)) {
            for (AlaLiveMarkData alaLiveMarkData : aVar.aIZ) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.a aVar) {
        if (aVar != null && this.aGe != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.aIT, aVar.aIU, aVar.aIV, String.valueOf(this.aGe.mLiveInfo.group_id), String.valueOf(this.aGe.mLiveInfo.live_id), this.aGf, String.valueOf(this.aGe.aKu.userId), aVar.appId, aVar.getNameShow())));
        }
    }
}
