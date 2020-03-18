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
    private m alp;
    private j.a atH;
    private boolean atI;
    private String atJ;
    private CustomMessageListener atL;
    private HttpMessageListener atM;
    private CustomMessageListener atN;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> atO;
    private boolean atP = false;
    private ImBarrageTrackListView atR;
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
        this.atH = aVar;
    }

    @Override // com.baidu.live.im.j
    public void a(m mVar, boolean z) {
        if (z) {
            if (!this.atP) {
                this.atP = true;
            } else {
                return;
            }
        }
        this.atR.setCanAddNext();
        this.atR.yn();
        wD();
        a(mVar);
        wZ();
        xf();
    }

    @Override // com.baidu.live.im.j
    public void a(m mVar) {
        boolean z = false;
        this.alp = mVar;
        this.atI = false;
        if (this.alp != null && this.alp.mLiveInfo != null) {
            this.atJ = String.valueOf(this.alp.Ya.userId);
            String valueOf = String.valueOf(this.alp.mLiveInfo.user_id);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
                z = true;
            }
            this.atI = z;
        }
    }

    @Override // com.baidu.live.im.j
    public View wC() {
        return this.atR;
    }

    @Override // com.baidu.live.im.j
    public void wD() {
        if (this.atR != null) {
            this.atR.wD();
        }
    }

    @Override // com.baidu.live.im.j
    public void wb() {
        xa();
        xg();
        this.alp = null;
        if (this.mMessages != null) {
            this.mMessages.clear();
        }
        if (this.atR != null) {
            this.atR.release();
            if (this.atR.getParent() != null) {
                ((ViewGroup) this.atR.getParent()).removeView(this.atR);
            }
        }
        this.atP = false;
    }

    @Override // com.baidu.live.im.j
    public void release() {
        wb();
        xc();
        xe();
        k.wF().release();
    }

    @Override // com.baidu.live.im.j
    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }

    private void initView() {
        this.atR = new ImBarrageTrackListView(this.mPageContext.getPageActivity(), 3, new LandscapeImBarrageTrackView.a() { // from class: com.baidu.live.im.b.c.1
            @Override // com.baidu.live.im.view.LandscapeImBarrageTrackView.a
            public void c(com.baidu.live.data.a aVar) {
                c.this.b(aVar);
            }

            @Override // com.baidu.live.im.view.LandscapeImBarrageTrackView.a
            public void a(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
                c.this.atR.c(landscapeImBarrageTrackView);
                c.this.xi();
            }
        });
    }

    private void initListener() {
        xb();
        xd();
    }

    private void wZ() {
        if (this.atO == null) {
            this.atO = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.live.im.b.c.2
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2913101, this.atO);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void xa() {
        MessageManager.getInstance().unRegisterTask(2913101);
    }

    private void xb() {
        this.atL = new CustomMessageListener(2913102) { // from class: com.baidu.live.im.b.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(c.this.mPageContext.getPageActivity()) == 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    c.this.B((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.atL);
    }

    private void xc() {
        if (this.atL != null) {
            MessageManager.getInstance().unRegisterListener(this.atL);
        }
    }

    private void xd() {
        this.atM = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.live.im.b.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021133 && (httpResponsedMessage instanceof ImBarragePayResponseMessage)) {
                    c.this.a((ImBarragePayResponseMessage) httpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.atM);
    }

    private void xe() {
        if (this.atM != null) {
            MessageManager.getInstance().unRegisterListener(this.atM);
        }
    }

    private void xf() {
        xg();
        if (this.atN == null) {
            this.atN = new CustomMessageListener(2913037) { // from class: com.baidu.live.im.b.c.5
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
        MessageManager.getInstance().registerListener(this.atN);
    }

    private void xg() {
        if (this.atN != null) {
            MessageManager.getInstance().unRegisterListener(this.atN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImSendMsgData imSendMsgData) {
        if (imSendMsgData.msgType == 126) {
            long j = imSendMsgData.price;
            if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                xh();
                return;
            }
            TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
            MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
        }
    }

    private void xh() {
        if (this.atH != null) {
            this.atH.wE();
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
        if (aVar.xx() == 1) {
            com.baidu.live.im.data.b xz = aVar.xz();
            if (xz != null && xz.auc) {
                a(aVar.xy(), xz);
            } else {
                b(aVar.getMsgId(), aVar.xy());
            }
        }
    }

    private void b(long j, String str) {
        String sN = q.sN();
        com.baidu.live.im.message.c cVar = new com.baidu.live.im.message.c();
        cVar.addParam("scene_from", sN);
        cVar.addParam("live_id", this.alp.mLiveInfo.live_id);
        cVar.addParam("im_id", j);
        cVar.addParam("barrage_id", str);
        MessageManager.getInstance().sendMessage(cVar);
    }

    private void a(String str, com.baidu.live.im.data.b bVar) {
        com.baidu.live.gift.q qVar;
        Map<String, com.baidu.live.gift.q> sD = r.sC().sD();
        if (sD != null && sD.containsKey(str) && (qVar = sD.get(str)) != null) {
            t.b(qVar.itemId, qVar.agD, bVar.aud, bVar.liveId, 1, 0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImBarragePayResponseMessage imBarragePayResponseMessage) {
        if (imBarragePayResponseMessage.getError() == 0) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = imBarragePayResponseMessage.uO();
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
                if (aVar.xw() && z2) {
                    if (this.mMessages == null) {
                        this.mMessages = new ArrayList();
                    }
                    boolean n = n(aVar);
                    if (n || this.mMessages.size() <= com.baidu.live.v.a.zs().awM.aaV) {
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
                        xi();
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
        if (aVar.xw()) {
        }
    }

    private boolean m(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getMsgType() == 126;
    }

    private boolean n(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xi() {
        bb bbVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.atR.yj()) {
            bb[] wG = k.wF().wG();
            com.baidu.live.im.data.a remove = this.mMessages.remove(0);
            if (remove == null || TextUtils.isEmpty(remove.getContent()) || remove.xt() == null) {
                xi();
                return;
            }
            if (remove.getMsgType() != 126) {
                bbVar = null;
            } else if (wG != null) {
                int length = wG.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        bbVar = null;
                        break;
                    }
                    bbVar = wG[i];
                    if (bbVar.id.equals(remove.xy())) {
                        break;
                    }
                    i++;
                }
                if (bbVar == null) {
                    bbVar = new bb().qQ();
                }
            } else {
                return;
            }
            if (this.atR.c(bbVar, bbVar == null ? k(remove.xA()) : null, remove.xt(), o(remove), this.atJ, p(remove))) {
                xi();
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
        if (strArr == null || strArr.length <= 1 || com.baidu.live.v.a.zs().axR == null) {
            return null;
        }
        z zVar = new z();
        aj ajVar = com.baidu.live.v.a.zs().axR.adf;
        if (ajVar != null && ajVar.acF != null && !TextUtils.isEmpty(strArr[0]) && (optJSONObject2 = ajVar.acF.optJSONObject(strArr[0])) != null) {
            int optInt = optJSONObject2.optInt("transparency");
            if (optInt >= 0 && optInt <= 100) {
                zVar.abC = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
            } else {
                zVar.abC = 255;
            }
            zVar.abD = optJSONObject2.optString("tail_icon");
            String optString2 = optJSONObject2.optString("start_color");
            String optString3 = optJSONObject2.optString("end_color");
            try {
                if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                    zVar.aby = Color.parseColor(optString2);
                    zVar.abz = Color.parseColor(optString3);
                    z = true;
                } else {
                    String optString4 = optJSONObject2.optString("bg_color");
                    if (!TextUtils.isEmpty(optString4)) {
                        zVar.aby = Color.parseColor(optString4);
                        zVar.abz = zVar.aby;
                        z = true;
                    }
                }
                if (z) {
                    String optString5 = optJSONObject2.optString("frame_start_color");
                    String optString6 = optJSONObject2.optString("frame_end_color");
                    if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
                        zVar.abA = Color.parseColor(optString5);
                        zVar.abB = Color.parseColor(optString6);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (ajVar != null && ajVar.acG != null && !TextUtils.isEmpty(strArr[1]) && (optJSONObject = ajVar.acG.optJSONObject(strArr[1])) != null) {
            String optString7 = optJSONObject.optString("bg_color");
            if (!TextUtils.isEmpty(optJSONObject.optString("transparency"))) {
                try {
                    i = (int) (((Integer.parseInt(optString) * 1.0f) / 100.0f) * 255.0f);
                } catch (Exception e2) {
                }
            }
            if (!TextUtils.isEmpty(optString7)) {
                zVar.abE = Color.parseColor(optString7);
                zVar.abF = i;
            }
        }
        return zVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.live.data.a aVar) {
        if (aVar != null && this.alp != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.Xp, aVar.Xq, aVar.Xr, String.valueOf(this.alp.mLiveInfo.group_id), String.valueOf(this.alp.mLiveInfo.live_id), this.atI, String.valueOf(this.alp.Ya.userId), aVar.appId, aVar.getNameShow(), "")));
        }
    }
}
