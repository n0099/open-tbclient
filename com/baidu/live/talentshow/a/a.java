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
import com.baidu.live.data.ab;
import com.baidu.live.data.bt;
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
    private ab aDd;
    private k bEu;
    private ILiveMultiBeautyView bEv;
    private AlaLiveRecorder bEw;
    private BdUniqueId bEx;
    private Context mContext;
    private TbPageContext mPageContext;
    private ViewGroup mParent;
    private boolean bEy = false;
    private boolean bEz = false;
    private CustomMessageListener bEA = new CustomMessageListener(2913150) { // from class: com.baidu.live.talentshow.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof AlaFilterBeautyDataMessage) {
                AlaFilterAndBeautyData data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData();
                if (data == null) {
                    if (a.this.bEy) {
                        a.this.mPageContext.showToast(a.h.sdk_filter_beauty_no_data);
                    }
                } else if (!data.aCk || a.this.bEx == null) {
                    if (a.this.bEx != null && a.this.bEx == data.aCj) {
                        a.this.SA();
                        a.this.cY(false);
                    }
                } else {
                    Log.d("ArUpdate", "点击请求——>返回本地数据 不弹面板");
                    a.this.mPageContext.showToast(a.h.sdk_filter_beauty_no_data);
                }
                a.this.bEy = false;
            }
        }
    };
    private CustomMessageListener bEB = new CustomMessageListener(2913196) { // from class: com.baidu.live.talentshow.a.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913196 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (a.this.bEw != null && !TextUtils.isEmpty(str)) {
                    a.this.bEw.setBeautyJsonPath(str);
                    Log.d("ArUpdate", "mUpdateFaceFileListener filePath:" + str);
                    d.xc().putString("beauty_face_feature", str);
                }
            }
        }
    };
    private m bEC = new m() { // from class: com.baidu.live.talentshow.a.a.3
        @Override // com.baidu.live.ar.m
        public void onClosed() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913147));
        }

        @Override // com.baidu.live.ar.m
        public void a(float f, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey) {
            if (!TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && a.this.bEw != null && AlaFilterAndBeautyData.aCi != null && AlaFilterAndBeautyData.aCi.get(beautyAdjustKey) != null) {
                a.this.bEw.onBeautyParamsChanged(f, AlaFilterAndBeautyData.aCi.get(beautyAdjustKey).zt());
            }
        }

        @Override // com.baidu.live.ar.m
        public void a(m.a aVar) {
            if (a.this.bEw != null && aVar != null && !TextUtils.isEmpty(aVar.getType())) {
                a.this.bEw.onBeautyParamsChanged(aVar.getType(), aVar.zG());
            }
        }

        @Override // com.baidu.live.ar.m
        public void a(float f, HashMap<String, Object> hashMap) {
            if (a.this.bEw != null) {
                a.this.bEw.onBeautyParamsChanged(f, hashMap);
            }
        }

        @Override // com.baidu.live.ar.m
        public void zE() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.aCi != null && AlaFilterAndBeautyData.aCi.get(beautyAdjustKey) != null) {
                    String jsonKey = beautyAdjustKey.getJsonKey();
                    if (!TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                        if (beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.chin) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.upCount)) {
                            a(((AlaFilterAndBeautyData.aCi.get(beautyAdjustKey).zs() + 50) * 1.0f) / 100.0f, beautyAdjustKey);
                        } else if (TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey()) || TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey())) {
                            try {
                                a((new JSONObject(e.aCE.toJsonString()).getInt(jsonKey) * 1.0f) / 100.0f, beautyAdjustKey);
                            } catch (Exception e) {
                                e.printStackTrace();
                                a((AlaFilterAndBeautyData.aCi.get(beautyAdjustKey).zs() * 1.0f) / 100.0f, beautyAdjustKey);
                            }
                        } else {
                            a((AlaFilterAndBeautyData.aCi.get(beautyAdjustKey).zs() * 1.0f) / 100.0f, beautyAdjustKey);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.live.ar.m
        public void zF() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.aCi != null && AlaFilterAndBeautyData.aCi.get(beautyAdjustKey) != null && !TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
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
            if (a.this.bEw != null) {
                a.this.bEw.onBlurLevelSelected(i);
            }
        }

        @Override // com.baidu.live.ar.m
        public void onFilterSelected(String str, String str2, float f) {
            if (a.this.bEw != null) {
                a.this.bEw.onFilterSelected(str, str2, f);
            }
        }

        @Override // com.baidu.live.ar.m
        public void t(int i, int i2) {
            if (a.this.bEw != null) {
                a.this.bEw.onColorLevelSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.m
        public void u(int i, int i2) {
            if (a.this.bEw != null) {
                a.this.bEw.onCheekThinSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.m
        public void v(int i, int i2) {
            if (a.this.bEw != null) {
                a.this.bEw.onEnlargeEyeSelected((0.8f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.m
        public void w(int i, int i2) {
            if (a.this.bEw != null) {
                a.this.bEw.onRedLevelSelected((1.0f * i) / i2);
            }
        }
    };

    public a(TbPageContext tbPageContext, ViewGroup viewGroup, AlaLiveRecorder alaLiveRecorder) {
        this.mPageContext = tbPageContext;
        this.mContext = this.mPageContext.getPageActivity();
        this.mParent = viewGroup;
        this.bEw = alaLiveRecorder;
        this.bEA.setTag(tbPageContext.getUniqueId());
        this.bEB.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.bEA);
        MessageManager.getInstance().registerListener(this.bEB);
        Sw();
    }

    public void setLiveShowData(ab abVar) {
        this.aDd = abVar;
    }

    public final void Sw() {
        CustomResponsedMessage runTask;
        if (this.bEu == null && (runTask = MessageManager.getInstance().runTask(2913177, k.class, this.mPageContext.getPageActivity())) != null) {
            this.bEu = (k) runTask.getData();
        }
        if (this.bEu != null) {
            this.bEu.b(null);
            this.bEu.c(null);
        }
    }

    public void Sx() {
        if (this.bEu == null) {
            Sw();
        }
        if (this.bEu != null) {
            if (Sy()) {
                if (Sz()) {
                    if (this.bEw.hasAdvancedBeauty()) {
                        SA();
                        cY(this.bEz);
                        this.bEz = true;
                        return;
                    }
                    Log.d("bugbye", "bugbye");
                    return;
                } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.mPageContext.showToast(a.h.sdk_filter_beauty_no_net);
                    return;
                } else if (this.bEy) {
                    this.mPageContext.showToast(a.h.live_chat_init_ar_resource);
                    return;
                } else {
                    this.bEx = BdUniqueId.gen();
                    this.bEu.a(this.bEx);
                    this.bEy = true;
                    return;
                }
            }
            Log.d("bugbye", "bugbye");
        }
    }

    public boolean Sy() {
        if (this.bEv == null && bt.b(com.baidu.live.ae.a.Qj().bAS)) {
            com.baidu.live.ar.a aVar = new com.baidu.live.ar.a();
            aVar.aBy = this.mPageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913176, ILiveMultiBeautyView.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.bEv = (ILiveMultiBeautyView) runTask.getData();
                this.bEv.setArModel(this.bEu);
            }
        }
        if (this.bEv == null) {
            return false;
        }
        this.bEv.setBdPageContext(this.mPageContext);
        this.bEv.setOnEffectSelectedListener(this.bEC);
        this.bEv.setAlaLiveShowData(this.aDd);
        return true;
    }

    private boolean Sz() {
        return (this.bEu.zB() == null || ListUtils.isEmpty(this.bEu.zB().aCd)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SA() {
        if (this.bEv != null) {
            this.bEv.setAlaLiveShowData(this.aDd);
            if (this.bEv.getParent() != null) {
                ((ViewGroup) this.bEv.getParent()).removeView(this.bEv);
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu() && (this.mContext instanceof Activity)) {
                if (((Activity) this.mContext).getApplication().getResources().getConfiguration().orientation == 1) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 80;
                    this.mParent.addView(this.bEv, layoutParams);
                } else {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
                    layoutParams2.gravity = 5;
                    this.mParent.addView(this.bEv, layoutParams2);
                }
            } else if (this.mContext.getResources().getConfiguration().orientation == 1) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams3.gravity = 80;
                this.mParent.addView(this.bEv, layoutParams3);
            } else {
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
                layoutParams4.gravity = 5;
                this.mParent.addView(this.bEv, layoutParams4);
            }
            this.bEv.setVisibility(0);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_BEAUTY_SHOW).setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
        }
    }

    public void cY(boolean z) {
        if (this.bEv != null) {
            this.bEv.setAlaLiveShowData(this.aDd);
            if (z) {
                this.bEv.zC();
            } else if (bt.b(com.baidu.live.ae.a.Qj().bAS)) {
                this.bEv.setViewData();
            }
        }
    }

    public void cZ(boolean z) {
        if (this.bEv != null) {
            if (z) {
                this.bEv.zD();
            }
            if (this.bEv.getParent() != null) {
                ((ViewGroup) this.bEv.getParent()).removeView(this.bEv);
            }
            e.aCF.aCt = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bEA);
        MessageManager.getInstance().unRegisterListener(this.bEB);
        cZ(true);
        if (this.bEu != null) {
            this.bEu.destory();
            this.bEu = null;
        }
    }
}
