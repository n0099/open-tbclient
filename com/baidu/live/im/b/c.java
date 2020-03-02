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
import com.baidu.live.data.aj;
import com.baidu.live.data.bb;
import com.baidu.live.data.m;
import com.baidu.live.data.z;
import com.baidu.live.gift.r;
import com.baidu.live.gift.t;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.j;
import com.baidu.live.im.k;
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
public class c implements j {
    private m ald;
    private CustomMessageListener atA;
    private HttpMessageListener atB;
    private CustomMessageListener atC;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> atD;
    private boolean atE = false;
    private ImBarrageTrackListView atG;
    private j.a atw;
    private boolean atx;
    private String aty;
    private List<com.baidu.live.im.data.a> mMessages;
    private String mOtherParams;
    private TbPageContext mPageContext;

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
        initListener();
    }

    @Override // com.baidu.live.im.j
    public void a(j.a aVar) {
        this.atw = aVar;
    }

    @Override // com.baidu.live.im.j
    public void a(m mVar, boolean z) {
        if (z) {
            if (!this.atE) {
                this.atE = true;
            } else {
                return;
            }
        }
        this.atG.setCanAddNext();
        this.atG.yi();
        wy();
        a(mVar);
        wU();
        xa();
    }

    @Override // com.baidu.live.im.j
    public void a(m mVar) {
        boolean z = false;
        this.ald = mVar;
        this.atx = false;
        if (this.ald != null && this.ald.mLiveInfo != null) {
            this.aty = String.valueOf(this.ald.XQ.userId);
            String valueOf = String.valueOf(this.ald.mLiveInfo.user_id);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
                z = true;
            }
            this.atx = z;
        }
    }

    @Override // com.baidu.live.im.j
    public View wx() {
        return this.atG;
    }

    @Override // com.baidu.live.im.j
    public void wy() {
        if (this.atG != null) {
            this.atG.wy();
        }
    }

    @Override // com.baidu.live.im.j
    public void vW() {
        wV();
        xb();
        this.ald = null;
        if (this.mMessages != null) {
            this.mMessages.clear();
        }
        if (this.atG != null) {
            this.atG.release();
            if (this.atG.getParent() != null) {
                ((ViewGroup) this.atG.getParent()).removeView(this.atG);
            }
        }
        this.atE = false;
    }

    @Override // com.baidu.live.im.j
    public void release() {
        vW();
        wX();
        wZ();
        k.wA().release();
    }

    @Override // com.baidu.live.im.j
    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }

    private void initView() {
        this.atG = new ImBarrageTrackListView(this.mPageContext.getPageActivity(), 3, new LandscapeImBarrageTrackView.a() { // from class: com.baidu.live.im.b.c.1
            @Override // com.baidu.live.im.view.LandscapeImBarrageTrackView.a
            public void c(com.baidu.live.data.a aVar) {
                c.this.b(aVar);
            }

            @Override // com.baidu.live.im.view.LandscapeImBarrageTrackView.a
            public void a(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
                c.this.atG.c(landscapeImBarrageTrackView);
                c.this.xd();
            }
        });
    }

    private void initListener() {
        wW();
        wY();
    }

    private void wU() {
        if (this.atD == null) {
            this.atD = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.live.im.b.c.2
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2913101, this.atD);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void wV() {
        MessageManager.getInstance().unRegisterTask(2913101);
    }

    private void wW() {
        this.atA = new CustomMessageListener(2913102) { // from class: com.baidu.live.im.b.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(c.this.mPageContext.getPageActivity()) == 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    c.this.B((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.atA);
    }

    private void wX() {
        if (this.atA != null) {
            MessageManager.getInstance().unRegisterListener(this.atA);
        }
    }

    private void wY() {
        this.atB = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.live.im.b.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021133 && (httpResponsedMessage instanceof ImBarragePayResponseMessage)) {
                    c.this.a((ImBarragePayResponseMessage) httpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.atB);
    }

    private void wZ() {
        if (this.atB != null) {
            MessageManager.getInstance().unRegisterListener(this.atB);
        }
    }

    private void xa() {
        xb();
        if (this.atC == null) {
            this.atC = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.b.c.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (UtilHelper.getRealScreenOrientation(c.this.mPageContext.getPageActivity()) == 2) {
                        Object data = customResponsedMessage.getData();
                        if (data instanceof com.baidu.live.im.data.a) {
                            c.this.l((com.baidu.live.im.data.a) data);
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.atC);
    }

    private void xb() {
        if (this.atC != null) {
            MessageManager.getInstance().unRegisterListener(this.atC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImSendMsgData imSendMsgData) {
        if (imSendMsgData.msgType == 126) {
            long j = imSendMsgData.price;
            if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                xc();
                return;
            }
            TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
            MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
        }
    }

    private void xc() {
        if (this.atw != null) {
            this.atw.wz();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mPageContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(List list) {
        if (list != null && !list.isEmpty()) {
            for (Object obj : list) {
                if (obj instanceof com.baidu.live.im.data.a) {
                    com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) obj;
                    if (n(aVar) && m(aVar)) {
                        k(aVar);
                    }
                }
            }
        }
    }

    private void k(com.baidu.live.im.data.a aVar) {
        if (aVar.xs() == 1) {
            com.baidu.live.im.data.b xu = aVar.xu();
            if (xu != null && xu.atR) {
                a(aVar.xt(), xu);
            } else {
                b(aVar.getMsgId(), aVar.xt());
            }
        }
    }

    private void b(long j, String str) {
        String sI = q.sI();
        com.baidu.live.im.message.c cVar = new com.baidu.live.im.message.c();
        cVar.addParam("scene_from", sI);
        cVar.addParam("live_id", this.ald.mLiveInfo.live_id);
        cVar.addParam("im_id", j);
        cVar.addParam("barrage_id", str);
        MessageManager.getInstance().sendMessage(cVar);
    }

    private void a(String str, com.baidu.live.im.data.b bVar) {
        com.baidu.live.gift.q qVar;
        Map<String, com.baidu.live.gift.q> sy = r.sx().sy();
        if (sy != null && sy.containsKey(str) && (qVar = sy.get(str)) != null) {
            t.b(qVar.itemId, qVar.agt, bVar.atS, bVar.liveId, 1, 0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImBarragePayResponseMessage imBarragePayResponseMessage) {
        if (imBarragePayResponseMessage.getError() == 0) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = imBarragePayResponseMessage.uJ();
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
    public void l(com.baidu.live.im.data.a aVar) {
        boolean z;
        boolean z2 = true;
        int i = 0;
        boolean q = q(aVar);
        if (!q) {
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
                if (!z && !q) {
                    z2 = false;
                }
                if (aVar.xr() && z2) {
                    if (this.mMessages == null) {
                        this.mMessages = new ArrayList();
                    }
                    boolean n = n(aVar);
                    if (n || this.mMessages.size() <= com.baidu.live.v.a.zl().awB.aaL) {
                        if (n && !this.mMessages.isEmpty()) {
                            while (i < this.mMessages.size()) {
                                if (!n(this.mMessages.get(i))) {
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
                        xd();
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
        if (aVar.xr()) {
        }
    }

    private boolean m(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getMsgType() == 126;
    }

    private boolean n(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xd() {
        bb bbVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.atG.ye()) {
            bb[] wB = k.wA().wB();
            com.baidu.live.im.data.a remove = this.mMessages.remove(0);
            if (remove == null || TextUtils.isEmpty(remove.getContent()) || remove.xo() == null) {
                xd();
                return;
            }
            if (remove.getMsgType() != 126) {
                bbVar = null;
            } else if (wB != null) {
                int length = wB.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        bbVar = null;
                        break;
                    }
                    bbVar = wB[i];
                    if (bbVar.id.equals(remove.xt())) {
                        break;
                    }
                    i++;
                }
                if (bbVar == null) {
                    bbVar = new bb().qL();
                }
            } else {
                return;
            }
            if (this.atG.c(bbVar, bbVar == null ? k(remove.xv()) : null, remove.xo(), o(remove), this.aty, p(remove))) {
                xd();
            }
        }
    }

    private String o(com.baidu.live.im.data.a aVar) {
        String str = "";
        if (aVar == null) {
            return "";
        }
        if (q(aVar)) {
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

    private int p(com.baidu.live.im.data.a aVar) {
        String content;
        if (aVar == null || q(aVar) || (content = aVar.getContent()) == null) {
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

    private boolean q(com.baidu.live.im.data.a aVar) {
        if (aVar == null) {
            return false;
        }
        int msgType = aVar.getMsgType();
        return msgType == 126 || msgType == 1;
    }

    private z k(String[] strArr) {
        JSONObject optJSONObject;
        String optString;
        JSONObject optJSONObject2;
        int i = 255;
        boolean z = false;
        if (strArr == null || strArr.length <= 1 || com.baidu.live.v.a.zl().axC == null) {
            return null;
        }
        z zVar = new z();
        aj ajVar = com.baidu.live.v.a.zl().axC.acU;
        if (ajVar != null && ajVar.acu != null && !TextUtils.isEmpty(strArr[0]) && (optJSONObject2 = ajVar.acu.optJSONObject(strArr[0])) != null) {
            int optInt = optJSONObject2.optInt("transparency");
            if (optInt >= 0 && optInt <= 100) {
                zVar.abr = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
            } else {
                zVar.abr = 255;
            }
            zVar.abt = optJSONObject2.optString("tail_icon");
            String optString2 = optJSONObject2.optString("start_color");
            String optString3 = optJSONObject2.optString("end_color");
            try {
                if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                    zVar.abn = Color.parseColor(optString2);
                    zVar.abo = Color.parseColor(optString3);
                    z = true;
                } else {
                    String optString4 = optJSONObject2.optString("bg_color");
                    if (!TextUtils.isEmpty(optString4)) {
                        zVar.abn = Color.parseColor(optString4);
                        zVar.abo = zVar.abn;
                        z = true;
                    }
                }
                if (z) {
                    String optString5 = optJSONObject2.optString("frame_start_color");
                    String optString6 = optJSONObject2.optString("frame_end_color");
                    if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
                        zVar.abp = Color.parseColor(optString5);
                        zVar.abq = Color.parseColor(optString6);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (ajVar != null && ajVar.acv != null && !TextUtils.isEmpty(strArr[1]) && (optJSONObject = ajVar.acv.optJSONObject(strArr[1])) != null) {
            String optString7 = optJSONObject.optString("bg_color");
            if (!TextUtils.isEmpty(optJSONObject.optString("transparency"))) {
                try {
                    i = (int) (((Integer.parseInt(optString) * 1.0f) / 100.0f) * 255.0f);
                } catch (Exception e2) {
                }
            }
            if (!TextUtils.isEmpty(optString7)) {
                zVar.abu = Color.parseColor(optString7);
                zVar.abv = i;
            }
        }
        return zVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.live.data.a aVar) {
        if (aVar != null && this.ald != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.Xf, aVar.Xg, aVar.Xh, String.valueOf(this.ald.mLiveInfo.group_id), String.valueOf(this.ald.mLiveInfo.live_id), this.atx, String.valueOf(this.ald.XQ.userId), aVar.appId, aVar.getNameShow(), "")));
        }
    }
}
