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
    private w aES;
    private j bxo;
    private ILiveMultiBeautyView bxp;
    private AlaLiveRecorder bxq;
    private BdUniqueId bxr;
    private boolean bxs = false;
    private boolean bxt = false;
    private CustomMessageListener bxu = new CustomMessageListener(2913150) { // from class: com.baidu.live.talentshow.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof AlaFilterBeautyDataMessage) {
                AlaFilterAndBeautyData data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData();
                if (data == null) {
                    if (a.this.bxs) {
                        a.this.mPageContext.showToast(a.h.sdk_filter_beauty_no_data);
                    }
                } else if (!data.aEf || a.this.bxr == null) {
                    if (a.this.bxr != null && a.this.bxr == data.aEe) {
                        a.this.RR();
                        a.this.cB(false);
                    }
                } else {
                    Log.d("ArUpdate", "点击请求——>返回本地数据 不弹面板");
                    a.this.mPageContext.showToast(a.h.sdk_filter_beauty_no_data);
                }
                a.this.bxs = false;
            }
        }
    };
    private CustomMessageListener bxv = new CustomMessageListener(2913196) { // from class: com.baidu.live.talentshow.a.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913196 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (a.this.bxq != null && !TextUtils.isEmpty(str)) {
                    a.this.bxq.setBeautyJsonPath(str);
                    Log.d("ArUpdate", "mUpdateFaceFileListener filePath:" + str);
                    d.AZ().putString("beauty_face_feature", str);
                }
            }
        }
    };
    private l bxw = new l() { // from class: com.baidu.live.talentshow.a.a.3
        @Override // com.baidu.live.ar.l
        public void CB() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913147));
        }

        @Override // com.baidu.live.ar.l
        public void a(float f, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey) {
            if (!TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && a.this.bxq != null && AlaFilterAndBeautyData.aEd != null && AlaFilterAndBeautyData.aEd.get(beautyAdjustKey) != null) {
                a.this.bxq.onBeautyParamsChanged(f, AlaFilterAndBeautyData.aEd.get(beautyAdjustKey).Cq());
            }
        }

        @Override // com.baidu.live.ar.l
        public void a(l.a aVar) {
            if (a.this.bxq != null && aVar != null && !TextUtils.isEmpty(aVar.getType())) {
                a.this.bxq.onBeautyParamsChanged(aVar.getType(), aVar.CE());
            }
        }

        @Override // com.baidu.live.ar.l
        public void a(float f, HashMap<String, Object> hashMap) {
            if (a.this.bxq != null) {
                a.this.bxq.onBeautyParamsChanged(f, hashMap);
            }
        }

        @Override // com.baidu.live.ar.l
        public void CC() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.aEd != null && AlaFilterAndBeautyData.aEd.get(beautyAdjustKey) != null) {
                    String jsonKey = beautyAdjustKey.getJsonKey();
                    if (!TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                        if (beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.chin) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.upCount)) {
                            a(((AlaFilterAndBeautyData.aEd.get(beautyAdjustKey).Cp() + 50) * 1.0f) / 100.0f, beautyAdjustKey);
                        } else if (TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey()) || TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey())) {
                            try {
                                a((new JSONObject(com.baidu.live.ar.d.aEz.toJsonString()).getInt(jsonKey) * 1.0f) / 100.0f, beautyAdjustKey);
                            } catch (Exception e) {
                                e.printStackTrace();
                                a((AlaFilterAndBeautyData.aEd.get(beautyAdjustKey).Cp() * 1.0f) / 100.0f, beautyAdjustKey);
                            }
                        } else {
                            a((AlaFilterAndBeautyData.aEd.get(beautyAdjustKey).Cp() * 1.0f) / 100.0f, beautyAdjustKey);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.live.ar.l
        public void CD() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.aEd != null && AlaFilterAndBeautyData.aEd.get(beautyAdjustKey) != null && !TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
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
            if (a.this.bxq != null) {
                a.this.bxq.onBlurLevelSelected(i);
            }
        }

        @Override // com.baidu.live.ar.l
        public void onFilterSelected(String str, String str2, float f) {
            if (a.this.bxq != null) {
                a.this.bxq.onFilterSelected(str, str2, f);
            }
        }

        @Override // com.baidu.live.ar.l
        public void s(int i, int i2) {
            if (a.this.bxq != null) {
                a.this.bxq.onColorLevelSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.l
        public void t(int i, int i2) {
            if (a.this.bxq != null) {
                a.this.bxq.onCheekThinSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.l
        public void u(int i, int i2) {
            if (a.this.bxq != null) {
                a.this.bxq.onEnlargeEyeSelected((0.8f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.l
        public void v(int i, int i2) {
            if (a.this.bxq != null) {
                a.this.bxq.onRedLevelSelected((1.0f * i) / i2);
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
        this.bxq = alaLiveRecorder;
        this.bxu.setTag(tbPageContext.getUniqueId());
        this.bxv.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.bxu);
        MessageManager.getInstance().registerListener(this.bxv);
        RN();
    }

    public void setLiveShowData(w wVar) {
        this.aES = wVar;
    }

    public void RN() {
        CustomResponsedMessage runTask;
        if (this.bxo == null && (runTask = MessageManager.getInstance().runTask(2913177, j.class, this.mPageContext.getPageActivity())) != null) {
            this.bxo = (j) runTask.getData();
        }
        if (this.bxo != null) {
            this.bxo.b(null);
            this.bxo.c(null);
        }
    }

    public void RO() {
        if (this.bxo == null) {
            RN();
        }
        if (this.bxo != null && RP()) {
            if (RQ()) {
                if (this.bxq.hasAdvancedBeauty()) {
                    RR();
                    cB(this.bxt);
                    this.bxt = true;
                }
            } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.mPageContext.showToast(a.h.sdk_filter_beauty_no_net);
            } else if (this.bxs) {
                this.mPageContext.showToast(a.h.live_chat_init_ar_resource);
            } else {
                this.bxr = BdUniqueId.gen();
                this.bxo.a(this.bxr);
                this.bxs = true;
            }
        }
    }

    public boolean RP() {
        if (this.bxp == null && bl.b(com.baidu.live.aa.a.PQ().btT)) {
            com.baidu.live.ar.a aVar = new com.baidu.live.ar.a();
            aVar.aDu = this.mPageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913176, ILiveMultiBeautyView.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.bxp = (ILiveMultiBeautyView) runTask.getData();
                this.bxp.setArModel(this.bxo);
            }
        }
        if (this.bxp == null) {
            return false;
        }
        this.bxp.setBdPageContext(this.mPageContext);
        this.bxp.setOnEffectSelectedListener(this.bxw);
        this.bxp.setAlaLiveShowData(this.aES);
        return true;
    }

    private boolean RQ() {
        return (this.bxo.Cy() == null || ListUtils.isEmpty(this.bxo.Cy().aDY)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RR() {
        if (this.bxp != null) {
            this.bxp.setAlaLiveShowData(this.aES);
            if (this.bxp.getParent() != null) {
                ((ViewGroup) this.bxp.getParent()).removeView(this.bxp);
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu() && (this.mContext instanceof Activity)) {
                if (((Activity) this.mContext).getApplication().getResources().getConfiguration().orientation == 1) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 80;
                    this.mParent.addView(this.bxp, layoutParams);
                } else {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
                    layoutParams2.gravity = 5;
                    this.mParent.addView(this.bxp, layoutParams2);
                }
            } else if (this.mContext.getResources().getConfiguration().orientation == 1) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams3.gravity = 80;
                this.mParent.addView(this.bxp, layoutParams3);
            } else {
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
                layoutParams4.gravity = 5;
                this.mParent.addView(this.bxp, layoutParams4);
            }
            this.bxp.setVisibility(0);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_BEAUTY_SHOW).setContentExt(null, "popup", null));
        }
    }

    public void cB(boolean z) {
        if (this.bxp != null) {
            this.bxp.setAlaLiveShowData(this.aES);
            if (z) {
                this.bxp.Cz();
            } else if (bl.b(com.baidu.live.aa.a.PQ().btT)) {
                this.bxp.setViewData();
            }
        }
    }

    public void cC(boolean z) {
        if (this.bxp != null) {
            if (z) {
                this.bxp.CA();
            }
            if (this.bxp.getParent() != null) {
                ((ViewGroup) this.bxp.getParent()).removeView(this.bxp);
            }
            com.baidu.live.ar.d.aEA.aEo = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bxu);
        MessageManager.getInstance().unRegisterListener(this.bxv);
        cC(true);
        if (this.bxo != null) {
            this.bxo.destory();
            this.bxo = null;
        }
    }
}
