package com.baidu.live.talentshow.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.ar.AlaFilterBeautyDataMessage;
import com.baidu.live.ar.ILiveMultiBeautyView;
import com.baidu.live.ar.e;
import com.baidu.live.ar.k;
import com.baidu.live.ar.m;
import com.baidu.live.d;
import com.baidu.live.data.bo;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private x aBr;
    private k bAO;
    private ILiveMultiBeautyView bAP;
    private AlaLiveRecorder bAQ;
    private BdUniqueId bAR;
    private boolean bAS = false;
    private boolean bAT = false;
    private CustomMessageListener bAU = new CustomMessageListener(2913150) { // from class: com.baidu.live.talentshow.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof AlaFilterBeautyDataMessage) {
                AlaFilterAndBeautyData data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData();
                if (data == null) {
                    if (a.this.bAS) {
                        a.this.mPageContext.showToast(a.h.sdk_filter_beauty_no_data);
                    }
                } else if (!data.aAF || a.this.bAR == null) {
                    if (a.this.bAR != null && a.this.bAR == data.aAE) {
                        a.this.QQ();
                        a.this.cQ(false);
                    }
                } else {
                    Log.d("ArUpdate", "点击请求——>返回本地数据 不弹面板");
                    a.this.mPageContext.showToast(a.h.sdk_filter_beauty_no_data);
                }
                a.this.bAS = false;
            }
        }
    };
    private CustomMessageListener bAV = new CustomMessageListener(2913196) { // from class: com.baidu.live.talentshow.a.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913196 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (a.this.bAQ != null && !TextUtils.isEmpty(str)) {
                    a.this.bAQ.setBeautyJsonPath(str);
                    Log.d("ArUpdate", "mUpdateFaceFileListener filePath:" + str);
                    d.xf().putString("beauty_face_feature", str);
                }
            }
        }
    };
    private m bAW = new m() { // from class: com.baidu.live.talentshow.a.a.3
        @Override // com.baidu.live.ar.m
        public void onClosed() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913147));
        }

        @Override // com.baidu.live.ar.m
        public void a(float f, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey) {
            if (!TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && a.this.bAQ != null && AlaFilterAndBeautyData.aAD != null && AlaFilterAndBeautyData.aAD.get(beautyAdjustKey) != null) {
                a.this.bAQ.onBeautyParamsChanged(f, AlaFilterAndBeautyData.aAD.get(beautyAdjustKey).yM());
            }
        }

        @Override // com.baidu.live.ar.m
        public void a(m.a aVar) {
            if (a.this.bAQ != null && aVar != null && !TextUtils.isEmpty(aVar.getType())) {
                a.this.bAQ.onBeautyParamsChanged(aVar.getType(), aVar.yZ());
            }
        }

        @Override // com.baidu.live.ar.m
        public void a(float f, HashMap<String, Object> hashMap) {
            if (a.this.bAQ != null) {
                a.this.bAQ.onBeautyParamsChanged(f, hashMap);
            }
        }

        @Override // com.baidu.live.ar.m
        public void yX() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.aAD != null && AlaFilterAndBeautyData.aAD.get(beautyAdjustKey) != null) {
                    String jsonKey = beautyAdjustKey.getJsonKey();
                    if (!TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                        if (beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.chin) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.upCount)) {
                            a(((AlaFilterAndBeautyData.aAD.get(beautyAdjustKey).yL() + 50) * 1.0f) / 100.0f, beautyAdjustKey);
                        } else if (TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey()) || TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey())) {
                            try {
                                a((new JSONObject(e.aAZ.toJsonString()).getInt(jsonKey) * 1.0f) / 100.0f, beautyAdjustKey);
                            } catch (Exception e) {
                                e.printStackTrace();
                                a((AlaFilterAndBeautyData.aAD.get(beautyAdjustKey).yL() * 1.0f) / 100.0f, beautyAdjustKey);
                            }
                        } else {
                            a((AlaFilterAndBeautyData.aAD.get(beautyAdjustKey).yL() * 1.0f) / 100.0f, beautyAdjustKey);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.live.ar.m
        public void yY() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.aAD != null && AlaFilterAndBeautyData.aAD.get(beautyAdjustKey) != null && !TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                    if (beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.chin) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.upCount)) {
                        a(0.5f, beautyAdjustKey);
                    } else {
                        a(0.0f, beautyAdjustKey);
                    }
                }
            }
        }

        @Override // com.baidu.live.ar.m
        public void onBlurLevelSelected(int i) {
            if (a.this.bAQ != null) {
                a.this.bAQ.onBlurLevelSelected(i);
            }
        }

        @Override // com.baidu.live.ar.m
        public void onFilterSelected(String str, String str2, float f) {
            if (a.this.bAQ != null) {
                a.this.bAQ.onFilterSelected(str, str2, f);
            }
        }

        @Override // com.baidu.live.ar.m
        public void t(int i, int i2) {
            if (a.this.bAQ != null) {
                a.this.bAQ.onColorLevelSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.m
        public void u(int i, int i2) {
            if (a.this.bAQ != null) {
                a.this.bAQ.onCheekThinSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.m
        public void v(int i, int i2) {
            if (a.this.bAQ != null) {
                a.this.bAQ.onEnlargeEyeSelected((0.8f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.m
        public void w(int i, int i2) {
            if (a.this.bAQ != null) {
                a.this.bAQ.onRedLevelSelected((1.0f * i) / i2);
            }
        }
    };
    private Context mContext;
    private TbPageContext mPageContext;
    private ViewGroup mParent;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, AlaLiveRecorder alaLiveRecorder) {
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.mParent = viewGroup;
        this.bAQ = alaLiveRecorder;
        this.bAU.setTag(tbPageContext.getUniqueId());
        this.bAV.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.bAU);
        MessageManager.getInstance().registerListener(this.bAV);
        QM();
    }

    public void setLiveShowData(x xVar) {
        this.aBr = xVar;
    }

    public void QM() {
        CustomResponsedMessage runTask;
        if (this.bAO == null && (runTask = MessageManager.getInstance().runTask(2913177, k.class, this.mPageContext.getPageActivity())) != null) {
            this.bAO = (k) runTask.getData();
        }
        if (this.bAO != null) {
            this.bAO.b(null);
            this.bAO.c(null);
        }
    }

    public void QN() {
        if (this.bAO == null) {
            QM();
        }
        if (this.bAO != null && QO()) {
            if (QP()) {
                if (this.bAQ.hasAdvancedBeauty()) {
                    QQ();
                    cQ(this.bAT);
                    this.bAT = true;
                }
            } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.mPageContext.showToast(a.h.sdk_filter_beauty_no_net);
            } else if (this.bAS) {
                this.mPageContext.showToast(a.h.live_chat_init_ar_resource);
            } else {
                this.bAR = BdUniqueId.gen();
                this.bAO.a(this.bAR);
                this.bAS = true;
            }
        }
    }

    public boolean QO() {
        if (this.bAP == null && bo.b(com.baidu.live.af.a.OJ().bxp)) {
            com.baidu.live.ar.a aVar = new com.baidu.live.ar.a();
            aVar.azT = this.mPageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913176, ILiveMultiBeautyView.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.bAP = (ILiveMultiBeautyView) runTask.getData();
                this.bAP.setArModel(this.bAO);
            }
        }
        if (this.bAP == null) {
            return false;
        }
        this.bAP.setBdPageContext(this.mPageContext);
        this.bAP.setOnEffectSelectedListener(this.bAW);
        this.bAP.setAlaLiveShowData(this.aBr);
        return true;
    }

    private boolean QP() {
        return (this.bAO.yU() == null || ListUtils.isEmpty(this.bAO.yU().aAy)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QQ() {
        if (this.bAP != null) {
            this.bAP.setAlaLiveShowData(this.aBr);
            if (this.bAP.getParent() != null) {
                ((ViewGroup) this.bAP.getParent()).removeView(this.bAP);
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu() && (this.mContext instanceof Activity)) {
                if (((Activity) this.mContext).getApplication().getResources().getConfiguration().orientation == 1) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 80;
                    this.mParent.addView(this.bAP, layoutParams);
                } else {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
                    layoutParams2.gravity = 5;
                    this.mParent.addView(this.bAP, layoutParams2);
                }
            } else if (this.mContext.getResources().getConfiguration().orientation == 1) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams3.gravity = 80;
                this.mParent.addView(this.bAP, layoutParams3);
            } else {
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
                layoutParams4.gravity = 5;
                this.mParent.addView(this.bAP, layoutParams4);
            }
            this.bAP.setVisibility(0);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_BEAUTY_SHOW).setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
        }
    }

    public void cQ(boolean z) {
        if (this.bAP != null) {
            this.bAP.setAlaLiveShowData(this.aBr);
            if (z) {
                this.bAP.yV();
            } else if (bo.b(com.baidu.live.af.a.OJ().bxp)) {
                this.bAP.setViewData();
            }
        }
    }

    public void cR(boolean z) {
        if (this.bAP != null) {
            if (z) {
                this.bAP.yW();
            }
            if (this.bAP.getParent() != null) {
                ((ViewGroup) this.bAP.getParent()).removeView(this.bAP);
            }
            e.aBa.aAO = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bAU);
        MessageManager.getInstance().unRegisterListener(this.bAV);
        cR(true);
        if (this.bAO != null) {
            this.bAO.destory();
            this.bAO = null;
        }
    }
}
