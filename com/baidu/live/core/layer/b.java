package com.baidu.live.core.layer;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdLog;
/* loaded from: classes11.dex */
public class b {
    private static b aFQ;
    private a aFM = new a() { // from class: com.baidu.live.core.layer.b.1
        @Override // com.baidu.live.core.layer.a
        public void a(LayerChildView layerChildView) {
        }

        @Override // com.baidu.live.core.layer.a
        public void b(LayerChildView layerChildView) {
            layerChildView.release();
            if (b.this.aFR != null) {
                b.this.aFR.removeView(layerChildView);
                if (b.this.aFR.getChildCount() <= 1) {
                    b.this.aFR.setVisibility(8);
                }
            }
        }
    };
    private ViewGroup aFR;

    private b() {
    }

    public static b Bc() {
        if (aFQ == null) {
            synchronized (b.class) {
                if (aFQ == null) {
                    aFQ = new b();
                }
            }
        }
        return aFQ;
    }

    public void l(ViewGroup viewGroup) {
        this.aFR = viewGroup;
        this.aFR.setVisibility(8);
    }

    public void d(LayerChildView layerChildView) {
        if (this.aFR == null) {
            BdLog.e("LAYER_ERRORparams error LayerParentView is null");
        } else if (layerChildView == null || layerChildView.getRootView() == null) {
            BdLog.e("LAYER_ERRORparams error layer or layer view is null");
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.aFR.indexOfChild(layerChildView) != -1) {
                BdLog.e("LAYER_ERRORerror layer has showed");
                return;
            }
            this.aFR.addView(layerChildView, new RelativeLayout.LayoutParams(-1, -1));
            this.aFR.setVisibility(0);
            layerChildView.setLayerCallback(this.aFM);
            layerChildView.AU();
            BdLog.d("layer show cost time is" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public boolean e(LayerChildView layerChildView) {
        if (this.aFR == null || layerChildView == null) {
            BdLog.e("LAYER_ERRORremove layer error, param error, mLayerParentView is null or layerView is null");
            return false;
        } else if (this.aFR.indexOfChild(layerChildView) >= 0) {
            layerChildView.AV();
            return true;
        } else {
            BdLog.e("LAYER_ERRORremove layer error, layerView is " + layerChildView);
            return false;
        }
    }

    public boolean onBackPressed() {
        if (this.aFR == null || this.aFR.getChildCount() <= 0) {
            return false;
        }
        View childAt = this.aFR.getChildAt(this.aFR.getChildCount() - 1);
        if (childAt instanceof LayerChildView) {
            LayerChildView layerChildView = (LayerChildView) childAt;
            if (layerChildView.cancelableFlag && !layerChildView.aFN) {
                return e(layerChildView);
            }
            return true;
        }
        return false;
    }

    public void Bd() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aFR != null && this.aFR.getChildCount() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.aFR.getChildCount()) {
                    break;
                }
                View childAt = this.aFR.getChildAt(i2);
                if (childAt instanceof LayerChildView) {
                    ((LayerChildView) childAt).release();
                }
                i = i2 + 1;
            }
            this.aFR.clearAnimation();
            this.aFR.removeAllViews();
            this.aFR.setVisibility(8);
        }
        BdLog.d("layer clear cost time is" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
        Bd();
        this.aFR = null;
    }
}
