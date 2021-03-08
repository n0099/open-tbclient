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
/* loaded from: classes10.dex */
public class a {
    private ab aED;
    private k bFU;
    private ILiveMultiBeautyView bFV;
    private AlaLiveRecorder bFW;
    private BdUniqueId bFX;
    private boolean bFY = false;
    private boolean bFZ = false;
    private CustomMessageListener bGa = new CustomMessageListener(2913150) { // from class: com.baidu.live.talentshow.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof AlaFilterBeautyDataMessage) {
                AlaFilterAndBeautyData data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData();
                if (data == null) {
                    if (a.this.bFY) {
                        a.this.mPageContext.showToast(a.h.sdk_filter_beauty_no_data);
                    }
                } else if (!data.aDK || a.this.bFX == null) {
                    if (a.this.bFX != null && a.this.bFX == data.aDJ) {
                        a.this.SD();
                        a.this.cY(false);
                    }
                } else {
                    Log.d("ArUpdate", "点击请求——>返回本地数据 不弹面板");
                    a.this.mPageContext.showToast(a.h.sdk_filter_beauty_no_data);
                }
                a.this.bFY = false;
            }
        }
    };
    private CustomMessageListener bGb = new CustomMessageListener(2913196) { // from class: com.baidu.live.talentshow.a.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913196 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (a.this.bFW != null && !TextUtils.isEmpty(str)) {
                    a.this.bFW.setBeautyJsonPath(str);
                    Log.d("ArUpdate", "mUpdateFaceFileListener filePath:" + str);
                    d.xf().putString("beauty_face_feature", str);
                }
            }
        }
    };
    private m bGc = new m() { // from class: com.baidu.live.talentshow.a.a.3
        @Override // com.baidu.live.ar.m
        public void onClosed() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913147));
        }

        @Override // com.baidu.live.ar.m
        public void a(float f, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey) {
            if (!TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && a.this.bFW != null && AlaFilterAndBeautyData.aDI != null && AlaFilterAndBeautyData.aDI.get(beautyAdjustKey) != null) {
                a.this.bFW.onBeautyParamsChanged(f, AlaFilterAndBeautyData.aDI.get(beautyAdjustKey).zw());
            }
        }

        @Override // com.baidu.live.ar.m
        public void a(m.a aVar) {
            if (a.this.bFW != null && aVar != null && !TextUtils.isEmpty(aVar.getType())) {
                a.this.bFW.onBeautyParamsChanged(aVar.getType(), aVar.zJ());
            }
        }

        @Override // com.baidu.live.ar.m
        public void a(float f, HashMap<String, Object> hashMap) {
            if (a.this.bFW != null) {
                a.this.bFW.onBeautyParamsChanged(f, hashMap);
            }
        }

        @Override // com.baidu.live.ar.m
        public void zH() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.aDI != null && AlaFilterAndBeautyData.aDI.get(beautyAdjustKey) != null) {
                    String jsonKey = beautyAdjustKey.getJsonKey();
                    if (!TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                        if (beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.chin) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.upCount)) {
                            a(((AlaFilterAndBeautyData.aDI.get(beautyAdjustKey).zv() + 50) * 1.0f) / 100.0f, beautyAdjustKey);
                        } else if (TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey()) || TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey())) {
                            try {
                                a((new JSONObject(e.aEe.toJsonString()).getInt(jsonKey) * 1.0f) / 100.0f, beautyAdjustKey);
                            } catch (Exception e) {
                                e.printStackTrace();
                                a((AlaFilterAndBeautyData.aDI.get(beautyAdjustKey).zv() * 1.0f) / 100.0f, beautyAdjustKey);
                            }
                        } else {
                            a((AlaFilterAndBeautyData.aDI.get(beautyAdjustKey).zv() * 1.0f) / 100.0f, beautyAdjustKey);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.live.ar.m
        public void zI() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.aDI != null && AlaFilterAndBeautyData.aDI.get(beautyAdjustKey) != null && !TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
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
            if (a.this.bFW != null) {
                a.this.bFW.onBlurLevelSelected(i);
            }
        }

        @Override // com.baidu.live.ar.m
        public void onFilterSelected(String str, String str2, float f) {
            if (a.this.bFW != null) {
                a.this.bFW.onFilterSelected(str, str2, f);
            }
        }

        @Override // com.baidu.live.ar.m
        public void t(int i, int i2) {
            if (a.this.bFW != null) {
                a.this.bFW.onColorLevelSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.m
        public void u(int i, int i2) {
            if (a.this.bFW != null) {
                a.this.bFW.onCheekThinSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.m
        public void v(int i, int i2) {
            if (a.this.bFW != null) {
                a.this.bFW.onEnlargeEyeSelected((0.8f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.m
        public void w(int i, int i2) {
            if (a.this.bFW != null) {
                a.this.bFW.onRedLevelSelected((1.0f * i) / i2);
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
        this.bFW = alaLiveRecorder;
        this.bGa.setTag(tbPageContext.getUniqueId());
        this.bGb.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.bGa);
        MessageManager.getInstance().registerListener(this.bGb);
        Sz();
    }

    public void setLiveShowData(ab abVar) {
        this.aED = abVar;
    }

    public final void Sz() {
        CustomResponsedMessage runTask;
        if (this.bFU == null && (runTask = MessageManager.getInstance().runTask(2913177, k.class, this.mPageContext.getPageActivity())) != null) {
            this.bFU = (k) runTask.getData();
        }
        if (this.bFU != null) {
            this.bFU.b(null);
            this.bFU.c(null);
        }
    }

    public void SA() {
        if (this.bFU == null) {
            Sz();
        }
        if (this.bFU != null) {
            if (SB()) {
                if (SC()) {
                    if (this.bFW.hasAdvancedBeauty()) {
                        SD();
                        cY(this.bFZ);
                        this.bFZ = true;
                        return;
                    }
                    Log.d("bugbye", "bugbye");
                    return;
                } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.mPageContext.showToast(a.h.sdk_filter_beauty_no_net);
                    return;
                } else if (this.bFY) {
                    this.mPageContext.showToast(a.h.live_chat_init_ar_resource);
                    return;
                } else {
                    this.bFX = BdUniqueId.gen();
                    this.bFU.a(this.bFX);
                    this.bFY = true;
                    return;
                }
            }
            Log.d("bugbye", "bugbye");
        }
    }

    public boolean SB() {
        if (this.bFV == null && bt.b(com.baidu.live.ae.a.Qm().bCs)) {
            com.baidu.live.ar.a aVar = new com.baidu.live.ar.a();
            aVar.aCY = this.mPageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913176, ILiveMultiBeautyView.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.bFV = (ILiveMultiBeautyView) runTask.getData();
                this.bFV.setArModel(this.bFU);
            }
        }
        if (this.bFV == null) {
            return false;
        }
        this.bFV.setBdPageContext(this.mPageContext);
        this.bFV.setOnEffectSelectedListener(this.bGc);
        this.bFV.setAlaLiveShowData(this.aED);
        return true;
    }

    private boolean SC() {
        return (this.bFU.zE() == null || ListUtils.isEmpty(this.bFU.zE().aDD)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SD() {
        if (this.bFV != null) {
            this.bFV.setAlaLiveShowData(this.aED);
            if (this.bFV.getParent() != null) {
                ((ViewGroup) this.bFV.getParent()).removeView(this.bFV);
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu() && (this.mContext instanceof Activity)) {
                if (((Activity) this.mContext).getApplication().getResources().getConfiguration().orientation == 1) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 80;
                    this.mParent.addView(this.bFV, layoutParams);
                } else {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
                    layoutParams2.gravity = 5;
                    this.mParent.addView(this.bFV, layoutParams2);
                }
            } else if (this.mContext.getResources().getConfiguration().orientation == 1) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams3.gravity = 80;
                this.mParent.addView(this.bFV, layoutParams3);
            } else {
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
                layoutParams4.gravity = 5;
                this.mParent.addView(this.bFV, layoutParams4);
            }
            this.bFV.setVisibility(0);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_BEAUTY_SHOW).setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
        }
    }

    public void cY(boolean z) {
        if (this.bFV != null) {
            this.bFV.setAlaLiveShowData(this.aED);
            if (z) {
                this.bFV.zF();
            } else if (bt.b(com.baidu.live.ae.a.Qm().bCs)) {
                this.bFV.setViewData();
            }
        }
    }

    public void cZ(boolean z) {
        if (this.bFV != null) {
            if (z) {
                this.bFV.zG();
            }
            if (this.bFV.getParent() != null) {
                ((ViewGroup) this.bFV.getParent()).removeView(this.bFV);
            }
            e.aEf.aDT = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bGa);
        MessageManager.getInstance().unRegisterListener(this.bGb);
        cZ(true);
        if (this.bFU != null) {
            this.bFU.destory();
            this.bFU = null;
        }
    }
}
