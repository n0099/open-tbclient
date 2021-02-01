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
import com.baidu.live.data.ab;
import com.baidu.live.data.ba;
import com.baidu.live.data.bq;
import com.baidu.live.data.cr;
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
import com.baidu.live.utils.q;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b implements com.baidu.live.im.b.a {
    private a.InterfaceC0179a aDc;
    private ab aDd;
    private boolean aDe;
    private String aDf;
    private CustomMessageListener aDh;
    private HttpMessageListener aDi;
    private CustomMessageListener aDj;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> aDk;
    private boolean aDl = false;
    private ImBarrageTrackListView aDo;
    private List<com.baidu.live.im.data.b> mMessages;
    private String mOtherParams;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
        initListener();
    }

    @Override // com.baidu.live.im.b.a
    public void a(a.InterfaceC0179a interfaceC0179a) {
        this.aDc = interfaceC0179a;
    }

    @Override // com.baidu.live.im.b.a
    public void a(ab abVar, boolean z) {
        if (z) {
            if (!this.aDl) {
                this.aDl = true;
            } else {
                return;
            }
        }
        this.aDo.setCanAddNext();
        this.aDo.Ah();
        zQ();
        a(abVar);
        zS();
        zY();
    }

    @Override // com.baidu.live.im.b.a
    public void a(ab abVar) {
        boolean z = false;
        this.aDd = abVar;
        this.aDe = false;
        if (this.aDd != null && this.aDd.mLiveInfo != null) {
            this.aDf = String.valueOf(this.aDd.aId.userId);
            String valueOf = String.valueOf(this.aDd.mLiveInfo.user_id);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
                z = true;
            }
            this.aDe = z;
        }
    }

    @Override // com.baidu.live.im.b.a
    public View zP() {
        return this.aDo;
    }

    @Override // com.baidu.live.im.b.a
    public void zQ() {
        if (this.aDo != null) {
            this.aDo.zQ();
        }
    }

    @Override // com.baidu.live.im.b.a
    public void zR() {
        zT();
        zZ();
        this.aDd = null;
        if (this.mMessages != null) {
            this.mMessages.clear();
        }
        if (this.aDo != null) {
            this.aDo.release();
            if (this.aDo.getParent() != null) {
                ((ViewGroup) this.aDo.getParent()).removeView(this.aDo);
            }
        }
        this.aDl = false;
    }

    @Override // com.baidu.live.im.b.a
    public void release() {
        zR();
        zV();
        zX();
        d.KN().release();
    }

    @Override // com.baidu.live.im.b.a
    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }

    private void initView() {
        this.aDo = new ImBarrageTrackListView(this.mPageContext.getPageActivity(), 3, new LandscapeImBarrageTrackView.a() { // from class: com.baidu.live.barrage.a.b.1
            @Override // com.baidu.live.barrage.view.LandscapeImBarrageTrackView.a
            public void b(com.baidu.live.data.a aVar) {
                b.this.a(aVar);
            }

            @Override // com.baidu.live.barrage.view.LandscapeImBarrageTrackView.a
            public void a(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
                b.this.aDo.b(landscapeImBarrageTrackView);
                b.this.Ab();
            }
        });
    }

    private void initListener() {
        zU();
        zW();
    }

    private void zS() {
        if (this.aDk == null) {
            this.aDk = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.live.barrage.a.b.2
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2913101, this.aDk);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void zT() {
        MessageManager.getInstance().unRegisterTask(2913101);
    }

    private void zU() {
        this.aDh = new CustomMessageListener(2913102) { // from class: com.baidu.live.barrage.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(b.this.mPageContext.getPageActivity()) == 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.v((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aDh);
    }

    private void zV() {
        if (this.aDh != null) {
            MessageManager.getInstance().unRegisterListener(this.aDh);
        }
    }

    private void zW() {
        this.aDi = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.live.barrage.a.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021133 && (httpResponsedMessage instanceof ImBarragePayResponseMessage)) {
                    b.this.a((ImBarragePayResponseMessage) httpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aDi);
    }

    private void zX() {
        if (this.aDi != null) {
            MessageManager.getInstance().unRegisterListener(this.aDi);
        }
    }

    private void zY() {
        zZ();
        if (this.aDj == null) {
            this.aDj = new CustomMessageListener(2913037) { // from class: com.baidu.live.barrage.a.b.5
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
        MessageManager.getInstance().registerListener(this.aDj);
    }

    private void zZ() {
        if (this.aDj != null) {
            MessageManager.getInstance().unRegisterListener(this.aDj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImSendMsgData imSendMsgData) {
        if (imSendMsgData.msgType == 126) {
            long j = imSendMsgData.price;
            if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                Aa();
                return;
            }
            TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
            MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
        }
    }

    private void Aa() {
        if (this.aDc != null) {
            this.aDc.KM();
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
        if (bVar.Ld() == 1) {
            com.baidu.live.im.data.d Lf = bVar.Lf();
            if (Lf != null && Lf.bps) {
                a(bVar.Le(), Lf, bVar.bno);
            } else {
                f(bVar.getMsgId(), bVar.Le());
            }
        }
    }

    private void f(long j, String str) {
        String Fv = q.Fv();
        com.baidu.live.im.message.d dVar = new com.baidu.live.im.message.d();
        dVar.addParam("scene_from", Fv);
        dVar.addParam("live_id", this.aDd.mLiveInfo.live_id);
        dVar.addParam("im_id", j);
        dVar.addParam("barrage_id", str);
        MessageManager.getInstance().sendMessage(dVar);
    }

    private void a(String str, com.baidu.live.im.data.d dVar, String str2) {
        y yVar;
        Map<String, y> Ff = z.Fe().Ff();
        if (Ff != null && Ff.containsKey(str) && (yVar = Ff.get(str)) != null) {
            ac.b(yVar.itemId, yVar.aWl, dVar.bdf, dVar.liveId, 1, 0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImBarragePayResponseMessage imBarragePayResponseMessage) {
        if (imBarragePayResponseMessage.getError() == 0) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = imBarragePayResponseMessage.HG();
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
                if (bVar.Lc() && z2) {
                    if (this.mMessages == null) {
                        this.mMessages = new ArrayList();
                    }
                    boolean d = d(bVar);
                    if (d || this.mMessages.size() <= com.baidu.live.ae.a.Qj().buX.aMR) {
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
                        Ab();
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
        if (bVar.Lc()) {
        }
    }

    private boolean c(com.baidu.live.im.data.b bVar) {
        return bVar != null && bVar.getMsgType() == 126;
    }

    private boolean d(com.baidu.live.im.data.b bVar) {
        return bVar != null && bVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ab() {
        cr crVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.aDo.Ai()) {
            cr[] KO = d.KN().KO();
            com.baidu.live.im.data.b remove = this.mMessages.remove(0);
            if (remove == null || TextUtils.isEmpty(remove.getContent()) || remove.KZ() == null) {
                Ab();
                return;
            }
            if (remove.getMsgType() != 126) {
                crVar = null;
            } else if (KO != null) {
                int length = KO.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        crVar = null;
                        break;
                    }
                    crVar = KO[i];
                    if (crVar.id.equals(remove.Le())) {
                        break;
                    }
                    i++;
                }
                if (crVar == null) {
                    crVar = new cr().CL();
                }
            } else {
                return;
            }
            if (this.aDo.a(crVar, crVar == null ? a(remove.Lg(), remove.KZ()) : null, remove.KZ(), e(remove), this.aDf, f(remove))) {
                Ab();
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

    private ba a(String[] strArr, com.baidu.live.data.a aVar) {
        ba baVar;
        JSONObject optJSONObject;
        String optString;
        JSONObject optJSONObject2;
        boolean z;
        int i = 255;
        boolean z2 = strArr != null && strArr.length > 0 && TextUtils.equals(strArr[0], "guard_seat_effect");
        if (strArr == null || strArr.length <= 1 || com.baidu.live.ae.a.Qj().bAS == null) {
            baVar = null;
        } else {
            ba baVar2 = new ba();
            bq bqVar = com.baidu.live.ae.a.Qj().bAS.aPO;
            if (bqVar != null && bqVar.aPv != null && !TextUtils.isEmpty(strArr[0]) && (optJSONObject2 = bqVar.aPv.optJSONObject(strArr[0])) != null) {
                int optInt = optJSONObject2.optInt("transparency");
                if (optInt >= 0 && optInt <= 100) {
                    baVar2.aOz = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
                } else {
                    baVar2.aOz = 255;
                }
                baVar2.aOA = optJSONObject2.optString("tail_icon");
                String optString2 = optJSONObject2.optString("start_color");
                String optString3 = optJSONObject2.optString("end_color");
                try {
                    if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                        baVar2.aOv = Color.parseColor(optString2);
                        baVar2.aOw = Color.parseColor(optString3);
                        z = true;
                    } else {
                        String optString4 = optJSONObject2.optString("bg_color");
                        if (TextUtils.isEmpty(optString4)) {
                            z = false;
                        } else {
                            baVar2.aOv = Color.parseColor(optString4);
                            baVar2.aOw = baVar2.aOv;
                            z = true;
                        }
                    }
                    if (z) {
                        String optString5 = optJSONObject2.optString("frame_start_color");
                        String optString6 = optJSONObject2.optString("frame_end_color");
                        if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
                            baVar2.aOx = Color.parseColor(optString5);
                            baVar2.aOy = Color.parseColor(optString6);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (bqVar != null && bqVar.aPw != null && !TextUtils.isEmpty(strArr[1]) && (optJSONObject = bqVar.aPw.optJSONObject(strArr[1])) != null) {
                String optString7 = optJSONObject.optString("bg_color");
                if (!TextUtils.isEmpty(optJSONObject.optString("transparency"))) {
                    try {
                        i = (int) (((Integer.parseInt(optString) * 1.0f) / 100.0f) * 255.0f);
                    } catch (Exception e2) {
                    }
                }
                if (!TextUtils.isEmpty(optString7)) {
                    baVar2.aOB = Color.parseColor(optString7);
                    baVar2.aOC = i;
                }
            }
            baVar = baVar2;
        }
        int c = c(aVar);
        boolean z3 = c >= 5;
        boolean z4 = c >= 2;
        if (!z2 && z3) {
            if (baVar == null) {
                baVar = new ba();
            }
            if (c == 7) {
                baVar.aOv = Color.parseColor("#4e030c");
                baVar.aOw = Color.parseColor("#4e030c");
            } else {
                baVar.aOv = Color.parseColor("#031f33");
                baVar.aOw = Color.parseColor("#031f33");
            }
            baVar.aOz = 60;
            baVar.aOx = Color.parseColor("#faca21");
            baVar.aOy = Color.parseColor("#faca21");
        }
        if (z4) {
            if (baVar == null) {
                baVar = new ba();
            }
            if (c == 7) {
                baVar.aOB = Color.parseColor("#ffef76");
            } else {
                baVar.aOB = Color.parseColor("#43c0a0");
            }
            baVar.aOC = 100;
        }
        return baVar;
    }

    private int c(com.baidu.live.data.a aVar) {
        if (aVar != null && !ListUtils.isEmpty(aVar.aFZ)) {
            for (AlaLiveMarkData alaLiveMarkData : aVar.aFZ) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.a aVar) {
        if (aVar != null && this.aDd != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.aFT, aVar.aFU, aVar.aFV, String.valueOf(this.aDd.mLiveInfo.group_id), String.valueOf(this.aDd.mLiveInfo.live_id), this.aDe, String.valueOf(this.aDd.aId.userId), aVar.appId, aVar.getNameShow())));
        }
    }
}
