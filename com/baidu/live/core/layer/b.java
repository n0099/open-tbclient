package com.baidu.live.core.layer;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdLog;
/* loaded from: classes4.dex */
public class b {
    private static b aFM;
    private a aFI = new a() { // from class: com.baidu.live.core.layer.b.1
        @Override // com.baidu.live.core.layer.a
        public void a(LayerChildView layerChildView) {
        }

        @Override // com.baidu.live.core.layer.a
        public void b(LayerChildView layerChildView) {
            layerChildView.release();
            if (b.this.aFN != null) {
                b.this.aFN.removeView(layerChildView);
                if (b.this.aFN.getChildCount() <= 1) {
                    b.this.aFN.setVisibility(8);
                }
            }
        }
    };
    private ViewGroup aFN;

    private b() {
    }

    public static b Do() {
        if (aFM == null) {
            synchronized (b.class) {
                if (aFM == null) {
                    aFM = new b();
                }
            }
        }
        return aFM;
    }

    public void j(ViewGroup viewGroup) {
        this.aFN = viewGroup;
        this.aFN.setVisibility(8);
    }

    public void d(LayerChildView layerChildView) {
        if (this.aFN == null) {
            BdLog.e("LAYER_ERRORparams error LayerParentView is null");
        } else if (layerChildView == null || layerChildView.getRootView() == null) {
            BdLog.e("LAYER_ERRORparams error layer or layer view is null");
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.aFN.indexOfChild(layerChildView) != -1) {
                BdLog.e("LAYER_ERRORerror layer has showed");
                return;
            }
            this.aFN.addView(layerChildView, new RelativeLayout.LayoutParams(-1, -1));
            this.aFN.setVisibility(0);
            layerChildView.setLayerCallback(this.aFI);
            layerChildView.Dg();
            BdLog.d("layer show cost time is" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public boolean e(LayerChildView layerChildView) {
        if (this.aFN == null || layerChildView == null) {
            BdLog.e("LAYER_ERRORremove layer error, param error, mLayerParentView is null or layerView is null");
            return false;
        } else if (this.aFN.indexOfChild(layerChildView) >= 0) {
            layerChildView.Dh();
            return true;
        } else {
            BdLog.e("LAYER_ERRORremove layer error, layerView is " + layerChildView);
            return false;
        }
    }

    public boolean onBackPressed() {
        if (this.aFN == null || this.aFN.getChildCount() <= 0) {
            return false;
        }
        View childAt = this.aFN.getChildAt(this.aFN.getChildCount() - 1);
        if (childAt instanceof LayerChildView) {
            LayerChildView layerChildView = (LayerChildView) childAt;
            if (layerChildView.cancelableFlag && !layerChildView.aFJ) {
                return e(layerChildView);
            }
            return true;
        }
        return false;
    }

    public void Dp() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aFN != null && this.aFN.getChildCount() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.aFN.getChildCount()) {
                    break;
                }
                View childAt = this.aFN.getChildAt(i2);
                if (childAt instanceof LayerChildView) {
                    ((LayerChildView) childAt).release();
                }
                i = i2 + 1;
            }
            this.aFN.clearAnimation();
            this.aFN.removeAllViews();
            this.aFN.setVisibility(8);
        }
        BdLog.d("layer clear cost time is" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
        Dp();
        this.aFN = null;
    }
}
