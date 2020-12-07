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
import com.baidu.live.ar.j;
import com.baidu.live.ar.l;
import com.baidu.live.d;
import com.baidu.live.data.bm;
import com.baidu.live.data.w;
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
/* loaded from: classes4.dex */
public class a {
    private w aFN;
    private j bAN;
    private ILiveMultiBeautyView bAO;
    private AlaLiveRecorder bAP;
    private BdUniqueId bAQ;
    private boolean bAR = false;
    private boolean bAS = false;
    private CustomMessageListener bAT = new CustomMessageListener(2913150) { // from class: com.baidu.live.talentshow.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof AlaFilterBeautyDataMessage) {
                AlaFilterAndBeautyData data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData();
                if (data == null) {
                    if (a.this.bAR) {
                        a.this.mPageContext.showToast(a.h.sdk_filter_beauty_no_data);
                    }
                } else if (!data.aFa || a.this.bAQ == null) {
                    if (a.this.bAQ != null && a.this.bAQ == data.aEZ) {
                        a.this.TG();
                        a.this.cR(false);
                    }
                } else {
                    Log.d("ArUpdate", "点击请求——>返回本地数据 不弹面板");
                    a.this.mPageContext.showToast(a.h.sdk_filter_beauty_no_data);
                }
                a.this.bAR = false;
            }
        }
    };
    private CustomMessageListener bAU = new CustomMessageListener(2913196) { // from class: com.baidu.live.talentshow.a.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913196 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (a.this.bAP != null && !TextUtils.isEmpty(str)) {
                    a.this.bAP.setBeautyJsonPath(str);
                    Log.d("ArUpdate", "mUpdateFaceFileListener filePath:" + str);
                    d.BM().putString("beauty_face_feature", str);
                }
            }
        }
    };
    private l bAV = new l() { // from class: com.baidu.live.talentshow.a.a.3
        @Override // com.baidu.live.ar.l
        public void DC() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913147));
        }

        @Override // com.baidu.live.ar.l
        public void a(float f, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey) {
            if (!TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && a.this.bAP != null && AlaFilterAndBeautyData.aEY != null && AlaFilterAndBeautyData.aEY.get(beautyAdjustKey) != null) {
                a.this.bAP.onBeautyParamsChanged(f, AlaFilterAndBeautyData.aEY.get(beautyAdjustKey).Dr());
            }
        }

        @Override // com.baidu.live.ar.l
        public void a(l.a aVar) {
            if (a.this.bAP != null && aVar != null && !TextUtils.isEmpty(aVar.getType())) {
                a.this.bAP.onBeautyParamsChanged(aVar.getType(), aVar.DF());
            }
        }

        @Override // com.baidu.live.ar.l
        public void a(float f, HashMap<String, Object> hashMap) {
            if (a.this.bAP != null) {
                a.this.bAP.onBeautyParamsChanged(f, hashMap);
            }
        }

        @Override // com.baidu.live.ar.l
        public void DD() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.aEY != null && AlaFilterAndBeautyData.aEY.get(beautyAdjustKey) != null) {
                    String jsonKey = beautyAdjustKey.getJsonKey();
                    if (!TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                        if (beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.chin) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.upCount)) {
                            a(((AlaFilterAndBeautyData.aEY.get(beautyAdjustKey).Dq() + 50) * 1.0f) / 100.0f, beautyAdjustKey);
                        } else if (TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey()) || TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey())) {
                            try {
                                a((new JSONObject(com.baidu.live.ar.d.aFu.toJsonString()).getInt(jsonKey) * 1.0f) / 100.0f, beautyAdjustKey);
                            } catch (Exception e) {
                                e.printStackTrace();
                                a((AlaFilterAndBeautyData.aEY.get(beautyAdjustKey).Dq() * 1.0f) / 100.0f, beautyAdjustKey);
                            }
                        } else {
                            a((AlaFilterAndBeautyData.aEY.get(beautyAdjustKey).Dq() * 1.0f) / 100.0f, beautyAdjustKey);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.live.ar.l
        public void DE() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.aEY != null && AlaFilterAndBeautyData.aEY.get(beautyAdjustKey) != null && !TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                    if (beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.chin) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.upCount)) {
                        a(0.5f, beautyAdjustKey);
                    } else {
                        a(0.0f, beautyAdjustKey);
                    }
                }
            }
        }

        @Override // com.baidu.live.ar.l
        public void onBlurLevelSelected(int i) {
            if (a.this.bAP != null) {
                a.this.bAP.onBlurLevelSelected(i);
            }
        }

        @Override // com.baidu.live.ar.l
        public void onFilterSelected(String str, String str2, float f) {
            if (a.this.bAP != null) {
                a.this.bAP.onFilterSelected(str, str2, f);
            }
        }

        @Override // com.baidu.live.ar.l
        public void t(int i, int i2) {
            if (a.this.bAP != null) {
                a.this.bAP.onColorLevelSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.l
        public void u(int i, int i2) {
            if (a.this.bAP != null) {
                a.this.bAP.onCheekThinSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.l
        public void v(int i, int i2) {
            if (a.this.bAP != null) {
                a.this.bAP.onEnlargeEyeSelected((0.8f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.l
        public void w(int i, int i2) {
            if (a.this.bAP != null) {
                a.this.bAP.onRedLevelSelected((1.0f * i) / i2);
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
        this.bAP = alaLiveRecorder;
        this.bAT.setTag(tbPageContext.getUniqueId());
        this.bAU.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.bAT);
        MessageManager.getInstance().registerListener(this.bAU);
        TC();
    }

    public void setLiveShowData(w wVar) {
        this.aFN = wVar;
    }

    public void TC() {
        CustomResponsedMessage runTask;
        if (this.bAN == null && (runTask = MessageManager.getInstance().runTask(2913177, j.class, this.mPageContext.getPageActivity())) != null) {
            this.bAN = (j) runTask.getData();
        }
        if (this.bAN != null) {
            this.bAN.b(null);
            this.bAN.c(null);
        }
    }

    public void TD() {
        if (this.bAN == null) {
            TC();
        }
        if (this.bAN != null && TE()) {
            if (TF()) {
                if (this.bAP.hasAdvancedBeauty()) {
                    TG();
                    cR(this.bAS);
                    this.bAS = true;
                }
            } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.mPageContext.showToast(a.h.sdk_filter_beauty_no_net);
            } else if (this.bAR) {
                this.mPageContext.showToast(a.h.live_chat_init_ar_resource);
            } else {
                this.bAQ = BdUniqueId.gen();
                this.bAN.a(this.bAQ);
                this.bAR = true;
            }
        }
    }

    public boolean TE() {
        if (this.bAO == null && bm.b(com.baidu.live.ae.a.RB().bxq)) {
            com.baidu.live.ar.a aVar = new com.baidu.live.ar.a();
            aVar.aEp = this.mPageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913176, ILiveMultiBeautyView.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.bAO = (ILiveMultiBeautyView) runTask.getData();
                this.bAO.setArModel(this.bAN);
            }
        }
        if (this.bAO == null) {
            return false;
        }
        this.bAO.setBdPageContext(this.mPageContext);
        this.bAO.setOnEffectSelectedListener(this.bAV);
        this.bAO.setAlaLiveShowData(this.aFN);
        return true;
    }

    private boolean TF() {
        return (this.bAN.Dz() == null || ListUtils.isEmpty(this.bAN.Dz().aET)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TG() {
        if (this.bAO != null) {
            this.bAO.setAlaLiveShowData(this.aFN);
            if (this.bAO.getParent() != null) {
                ((ViewGroup) this.bAO.getParent()).removeView(this.bAO);
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu() && (this.mContext instanceof Activity)) {
                if (((Activity) this.mContext).getApplication().getResources().getConfiguration().orientation == 1) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 80;
                    this.mParent.addView(this.bAO, layoutParams);
                } else {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
                    layoutParams2.gravity = 5;
                    this.mParent.addView(this.bAO, layoutParams2);
                }
            } else if (this.mContext.getResources().getConfiguration().orientation == 1) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams3.gravity = 80;
                this.mParent.addView(this.bAO, layoutParams3);
            } else {
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
                layoutParams4.gravity = 5;
                this.mParent.addView(this.bAO, layoutParams4);
            }
            this.bAO.setVisibility(0);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_BEAUTY_SHOW).setContentExt(null, "popup", null));
        }
    }

    public void cR(boolean z) {
        if (this.bAO != null) {
            this.bAO.setAlaLiveShowData(this.aFN);
            if (z) {
                this.bAO.DA();
            } else if (bm.b(com.baidu.live.ae.a.RB().bxq)) {
                this.bAO.setViewData();
            }
        }
    }

    public void cS(boolean z) {
        if (this.bAO != null) {
            if (z) {
                this.bAO.DB();
            }
            if (this.bAO.getParent() != null) {
                ((ViewGroup) this.bAO.getParent()).removeView(this.bAO);
            }
            com.baidu.live.ar.d.aFv.aFj = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bAT);
        MessageManager.getInstance().unRegisterListener(this.bAU);
        cS(true);
        if (this.bAN != null) {
            this.bAN.destory();
            this.bAN = null;
        }
    }
}
