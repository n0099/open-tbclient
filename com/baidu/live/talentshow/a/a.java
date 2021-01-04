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
/* loaded from: classes11.dex */
public class a {
    private x aGe;
    private k bFA;
    private ILiveMultiBeautyView bFB;
    private AlaLiveRecorder bFC;
    private BdUniqueId bFD;
    private boolean bFE = false;
    private boolean bFF = false;
    private CustomMessageListener bFG = new CustomMessageListener(2913150) { // from class: com.baidu.live.talentshow.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof AlaFilterBeautyDataMessage) {
                AlaFilterAndBeautyData data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData();
                if (data == null) {
                    if (a.this.bFE) {
                        a.this.mPageContext.showToast(a.h.sdk_filter_beauty_no_data);
                    }
                } else if (!data.aFs || a.this.bFD == null) {
                    if (a.this.bFD != null && a.this.bFD == data.aFr) {
                        a.this.UL();
                        a.this.cU(false);
                    }
                } else {
                    Log.d("ArUpdate", "点击请求——>返回本地数据 不弹面板");
                    a.this.mPageContext.showToast(a.h.sdk_filter_beauty_no_data);
                }
                a.this.bFE = false;
            }
        }
    };
    private CustomMessageListener bFH = new CustomMessageListener(2913196) { // from class: com.baidu.live.talentshow.a.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913196 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (a.this.bFC != null && !TextUtils.isEmpty(str)) {
                    a.this.bFC.setBeautyJsonPath(str);
                    Log.d("ArUpdate", "mUpdateFaceFileListener filePath:" + str);
                    d.Ba().putString("beauty_face_feature", str);
                }
            }
        }
    };
    private m bFI = new m() { // from class: com.baidu.live.talentshow.a.a.3
        @Override // com.baidu.live.ar.m
        public void onClosed() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913147));
        }

        @Override // com.baidu.live.ar.m
        public void a(float f, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey) {
            if (!TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && a.this.bFC != null && AlaFilterAndBeautyData.aFq != null && AlaFilterAndBeautyData.aFq.get(beautyAdjustKey) != null) {
                a.this.bFC.onBeautyParamsChanged(f, AlaFilterAndBeautyData.aFq.get(beautyAdjustKey).CH());
            }
        }

        @Override // com.baidu.live.ar.m
        public void a(m.a aVar) {
            if (a.this.bFC != null && aVar != null && !TextUtils.isEmpty(aVar.getType())) {
                a.this.bFC.onBeautyParamsChanged(aVar.getType(), aVar.CU());
            }
        }

        @Override // com.baidu.live.ar.m
        public void a(float f, HashMap<String, Object> hashMap) {
            if (a.this.bFC != null) {
                a.this.bFC.onBeautyParamsChanged(f, hashMap);
            }
        }

        @Override // com.baidu.live.ar.m
        public void CS() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.aFq != null && AlaFilterAndBeautyData.aFq.get(beautyAdjustKey) != null) {
                    String jsonKey = beautyAdjustKey.getJsonKey();
                    if (!TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                        if (beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.chin) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.upCount)) {
                            a(((AlaFilterAndBeautyData.aFq.get(beautyAdjustKey).CG() + 50) * 1.0f) / 100.0f, beautyAdjustKey);
                        } else if (TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey()) || TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey())) {
                            try {
                                a((new JSONObject(e.aFM.toJsonString()).getInt(jsonKey) * 1.0f) / 100.0f, beautyAdjustKey);
                            } catch (Exception e) {
                                e.printStackTrace();
                                a((AlaFilterAndBeautyData.aFq.get(beautyAdjustKey).CG() * 1.0f) / 100.0f, beautyAdjustKey);
                            }
                        } else {
                            a((AlaFilterAndBeautyData.aFq.get(beautyAdjustKey).CG() * 1.0f) / 100.0f, beautyAdjustKey);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.live.ar.m
        public void CT() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.aFq != null && AlaFilterAndBeautyData.aFq.get(beautyAdjustKey) != null && !TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
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
            if (a.this.bFC != null) {
                a.this.bFC.onBlurLevelSelected(i);
            }
        }

        @Override // com.baidu.live.ar.m
        public void onFilterSelected(String str, String str2, float f) {
            if (a.this.bFC != null) {
                a.this.bFC.onFilterSelected(str, str2, f);
            }
        }

        @Override // com.baidu.live.ar.m
        public void t(int i, int i2) {
            if (a.this.bFC != null) {
                a.this.bFC.onColorLevelSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.m
        public void u(int i, int i2) {
            if (a.this.bFC != null) {
                a.this.bFC.onCheekThinSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.m
        public void v(int i, int i2) {
            if (a.this.bFC != null) {
                a.this.bFC.onEnlargeEyeSelected((0.8f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.m
        public void w(int i, int i2) {
            if (a.this.bFC != null) {
                a.this.bFC.onRedLevelSelected((1.0f * i) / i2);
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
        this.bFC = alaLiveRecorder;
        this.bFG.setTag(tbPageContext.getUniqueId());
        this.bFH.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.bFG);
        MessageManager.getInstance().registerListener(this.bFH);
        UH();
    }

    public void setLiveShowData(x xVar) {
        this.aGe = xVar;
    }

    public void UH() {
        CustomResponsedMessage runTask;
        if (this.bFA == null && (runTask = MessageManager.getInstance().runTask(2913177, k.class, this.mPageContext.getPageActivity())) != null) {
            this.bFA = (k) runTask.getData();
        }
        if (this.bFA != null) {
            this.bFA.b(null);
            this.bFA.c(null);
        }
    }

    public void UI() {
        if (this.bFA == null) {
            UH();
        }
        if (this.bFA != null && UJ()) {
            if (UK()) {
                if (this.bFC.hasAdvancedBeauty()) {
                    UL();
                    cU(this.bFF);
                    this.bFF = true;
                }
            } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.mPageContext.showToast(a.h.sdk_filter_beauty_no_net);
            } else if (this.bFE) {
                this.mPageContext.showToast(a.h.live_chat_init_ar_resource);
            } else {
                this.bFD = BdUniqueId.gen();
                this.bFA.a(this.bFD);
                this.bFE = true;
            }
        }
    }

    public boolean UJ() {
        if (this.bFB == null && bo.b(com.baidu.live.af.a.SE().bCb)) {
            com.baidu.live.ar.a aVar = new com.baidu.live.ar.a();
            aVar.aEG = this.mPageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913176, ILiveMultiBeautyView.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.bFB = (ILiveMultiBeautyView) runTask.getData();
                this.bFB.setArModel(this.bFA);
            }
        }
        if (this.bFB == null) {
            return false;
        }
        this.bFB.setBdPageContext(this.mPageContext);
        this.bFB.setOnEffectSelectedListener(this.bFI);
        this.bFB.setAlaLiveShowData(this.aGe);
        return true;
    }

    private boolean UK() {
        return (this.bFA.CP() == null || ListUtils.isEmpty(this.bFA.CP().aFl)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UL() {
        if (this.bFB != null) {
            this.bFB.setAlaLiveShowData(this.aGe);
            if (this.bFB.getParent() != null) {
                ((ViewGroup) this.bFB.getParent()).removeView(this.bFB);
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu() && (this.mContext instanceof Activity)) {
                if (((Activity) this.mContext).getApplication().getResources().getConfiguration().orientation == 1) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 80;
                    this.mParent.addView(this.bFB, layoutParams);
                } else {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
                    layoutParams2.gravity = 5;
                    this.mParent.addView(this.bFB, layoutParams2);
                }
            } else if (this.mContext.getResources().getConfiguration().orientation == 1) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams3.gravity = 80;
                this.mParent.addView(this.bFB, layoutParams3);
            } else {
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
                layoutParams4.gravity = 5;
                this.mParent.addView(this.bFB, layoutParams4);
            }
            this.bFB.setVisibility(0);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_BEAUTY_SHOW).setContentExt(null, "popup", null));
        }
    }

    public void cU(boolean z) {
        if (this.bFB != null) {
            this.bFB.setAlaLiveShowData(this.aGe);
            if (z) {
                this.bFB.CQ();
            } else if (bo.b(com.baidu.live.af.a.SE().bCb)) {
                this.bFB.setViewData();
            }
        }
    }

    public void cV(boolean z) {
        if (this.bFB != null) {
            if (z) {
                this.bFB.CR();
            }
            if (this.bFB.getParent() != null) {
                ((ViewGroup) this.bFB.getParent()).removeView(this.bFB);
            }
            e.aFN.aFB = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bFG);
        MessageManager.getInstance().unRegisterListener(this.bFH);
        cV(true);
        if (this.bFA != null) {
            this.bFA.destory();
            this.bFA = null;
        }
    }
}
