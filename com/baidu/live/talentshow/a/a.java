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
import com.baidu.live.data.bl;
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
    private w aDh;
    private j bvD;
    private ILiveMultiBeautyView bvE;
    private AlaLiveRecorder bvF;
    private BdUniqueId bvG;
    private boolean bvH = false;
    private boolean bvI = false;
    private CustomMessageListener bvJ = new CustomMessageListener(2913150) { // from class: com.baidu.live.talentshow.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof AlaFilterBeautyDataMessage) {
                AlaFilterAndBeautyData data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData();
                if (data == null) {
                    if (a.this.bvH) {
                        a.this.mPageContext.showToast(a.h.sdk_filter_beauty_no_data);
                    }
                } else if (!data.aCu || a.this.bvG == null) {
                    if (a.this.bvG != null && a.this.bvG == data.aCt) {
                        a.this.Ri();
                        a.this.cD(false);
                    }
                } else {
                    Log.d("ArUpdate", "点击请求——>返回本地数据 不弹面板");
                    a.this.mPageContext.showToast(a.h.sdk_filter_beauty_no_data);
                }
                a.this.bvH = false;
            }
        }
    };
    private CustomMessageListener bvK = new CustomMessageListener(2913196) { // from class: com.baidu.live.talentshow.a.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913196 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (a.this.bvF != null && !TextUtils.isEmpty(str)) {
                    a.this.bvF.setBeautyJsonPath(str);
                    Log.d("ArUpdate", "mUpdateFaceFileListener filePath:" + str);
                    d.Aq().putString("beauty_face_feature", str);
                }
            }
        }
    };
    private l bvL = new l() { // from class: com.baidu.live.talentshow.a.a.3
        @Override // com.baidu.live.ar.l
        public void BS() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913147));
        }

        @Override // com.baidu.live.ar.l
        public void a(float f, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey) {
            if (!TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && a.this.bvF != null && AlaFilterAndBeautyData.aCs != null && AlaFilterAndBeautyData.aCs.get(beautyAdjustKey) != null) {
                a.this.bvF.onBeautyParamsChanged(f, AlaFilterAndBeautyData.aCs.get(beautyAdjustKey).BH());
            }
        }

        @Override // com.baidu.live.ar.l
        public void a(l.a aVar) {
            if (a.this.bvF != null && aVar != null && !TextUtils.isEmpty(aVar.getType())) {
                a.this.bvF.onBeautyParamsChanged(aVar.getType(), aVar.BV());
            }
        }

        @Override // com.baidu.live.ar.l
        public void a(float f, HashMap<String, Object> hashMap) {
            if (a.this.bvF != null) {
                a.this.bvF.onBeautyParamsChanged(f, hashMap);
            }
        }

        @Override // com.baidu.live.ar.l
        public void BT() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.aCs != null && AlaFilterAndBeautyData.aCs.get(beautyAdjustKey) != null) {
                    String jsonKey = beautyAdjustKey.getJsonKey();
                    if (!TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                        if (beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.chin) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.upCount)) {
                            a(((AlaFilterAndBeautyData.aCs.get(beautyAdjustKey).BG() + 50) * 1.0f) / 100.0f, beautyAdjustKey);
                        } else if (TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey()) || TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey())) {
                            try {
                                a((new JSONObject(com.baidu.live.ar.d.aCO.toJsonString()).getInt(jsonKey) * 1.0f) / 100.0f, beautyAdjustKey);
                            } catch (Exception e) {
                                e.printStackTrace();
                                a((AlaFilterAndBeautyData.aCs.get(beautyAdjustKey).BG() * 1.0f) / 100.0f, beautyAdjustKey);
                            }
                        } else {
                            a((AlaFilterAndBeautyData.aCs.get(beautyAdjustKey).BG() * 1.0f) / 100.0f, beautyAdjustKey);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.live.ar.l
        public void BU() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.aCs != null && AlaFilterAndBeautyData.aCs.get(beautyAdjustKey) != null && !TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
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
            if (a.this.bvF != null) {
                a.this.bvF.onBlurLevelSelected(i);
            }
        }

        @Override // com.baidu.live.ar.l
        public void onFilterSelected(String str, String str2, float f) {
            if (a.this.bvF != null) {
                a.this.bvF.onFilterSelected(str, str2, f);
            }
        }

        @Override // com.baidu.live.ar.l
        public void s(int i, int i2) {
            if (a.this.bvF != null) {
                a.this.bvF.onColorLevelSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.l
        public void t(int i, int i2) {
            if (a.this.bvF != null) {
                a.this.bvF.onCheekThinSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.l
        public void u(int i, int i2) {
            if (a.this.bvF != null) {
                a.this.bvF.onEnlargeEyeSelected((0.8f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.l
        public void v(int i, int i2) {
            if (a.this.bvF != null) {
                a.this.bvF.onRedLevelSelected((1.0f * i) / i2);
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
        this.bvF = alaLiveRecorder;
        this.bvJ.setTag(tbPageContext.getUniqueId());
        this.bvK.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.bvJ);
        MessageManager.getInstance().registerListener(this.bvK);
        Re();
    }

    public void setLiveShowData(w wVar) {
        this.aDh = wVar;
    }

    public void Re() {
        CustomResponsedMessage runTask;
        if (this.bvD == null && (runTask = MessageManager.getInstance().runTask(2913177, j.class, this.mPageContext.getPageActivity())) != null) {
            this.bvD = (j) runTask.getData();
        }
        if (this.bvD != null) {
            this.bvD.b(null);
            this.bvD.c(null);
        }
    }

    public void Rf() {
        if (this.bvD == null) {
            Re();
        }
        if (this.bvD != null && Rg()) {
            if (Rh()) {
                if (this.bvF.hasAdvancedBeauty()) {
                    Ri();
                    cD(this.bvI);
                    this.bvI = true;
                }
            } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.mPageContext.showToast(a.h.sdk_filter_beauty_no_net);
            } else if (this.bvH) {
                this.mPageContext.showToast(a.h.live_chat_init_ar_resource);
            } else {
                this.bvG = BdUniqueId.gen();
                this.bvD.a(this.bvG);
                this.bvH = true;
            }
        }
    }

    public boolean Rg() {
        if (this.bvE == null && bl.b(com.baidu.live.aa.a.Ph().bsh)) {
            com.baidu.live.ar.a aVar = new com.baidu.live.ar.a();
            aVar.aBJ = this.mPageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913176, ILiveMultiBeautyView.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.bvE = (ILiveMultiBeautyView) runTask.getData();
                this.bvE.setArModel(this.bvD);
            }
        }
        if (this.bvE == null) {
            return false;
        }
        this.bvE.setBdPageContext(this.mPageContext);
        this.bvE.setOnEffectSelectedListener(this.bvL);
        this.bvE.setAlaLiveShowData(this.aDh);
        return true;
    }

    private boolean Rh() {
        return (this.bvD.BP() == null || ListUtils.isEmpty(this.bvD.BP().aCn)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ri() {
        if (this.bvE != null) {
            this.bvE.setAlaLiveShowData(this.aDh);
            if (this.bvE.getParent() != null) {
                ((ViewGroup) this.bvE.getParent()).removeView(this.bvE);
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu() && (this.mContext instanceof Activity)) {
                if (((Activity) this.mContext).getApplication().getResources().getConfiguration().orientation == 1) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 80;
                    this.mParent.addView(this.bvE, layoutParams);
                } else {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
                    layoutParams2.gravity = 5;
                    this.mParent.addView(this.bvE, layoutParams2);
                }
            } else if (this.mContext.getResources().getConfiguration().orientation == 1) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams3.gravity = 80;
                this.mParent.addView(this.bvE, layoutParams3);
            } else {
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
                layoutParams4.gravity = 5;
                this.mParent.addView(this.bvE, layoutParams4);
            }
            this.bvE.setVisibility(0);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_BEAUTY_SHOW).setContentExt(null, "popup", null));
        }
    }

    public void cD(boolean z) {
        if (this.bvE != null) {
            this.bvE.setAlaLiveShowData(this.aDh);
            if (z) {
                this.bvE.BQ();
            } else if (bl.b(com.baidu.live.aa.a.Ph().bsh)) {
                this.bvE.setViewData();
            }
        }
    }

    public void cE(boolean z) {
        if (this.bvE != null) {
            if (z) {
                this.bvE.BR();
            }
            if (this.bvE.getParent() != null) {
                ((ViewGroup) this.bvE.getParent()).removeView(this.bvE);
            }
            com.baidu.live.ar.d.aCP.aCD = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bvJ);
        MessageManager.getInstance().unRegisterListener(this.bvK);
        cE(true);
        if (this.bvD != null) {
            this.bvD.destory();
            this.bvD = null;
        }
    }
}
