package com.baidu.live.core.layer;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdLog;
/* loaded from: classes4.dex */
public class b {
    private static b axH;
    private a axD = new a() { // from class: com.baidu.live.core.layer.b.1
        @Override // com.baidu.live.core.layer.a
        public void a(LayerChildView layerChildView) {
        }

        @Override // com.baidu.live.core.layer.a
        public void b(LayerChildView layerChildView) {
            layerChildView.release();
            b.this.axI.removeView(layerChildView);
            if (b.this.axI.getChildCount() <= 1) {
                b.this.axI.setVisibility(8);
            }
        }
    };
    private ViewGroup axI;

    private b() {
    }

    public static b wN() {
        if (axH == null) {
            synchronized (b.class) {
                if (axH == null) {
                    axH = new b();
                }
            }
        }
        return axH;
    }

    public void l(ViewGroup viewGroup) {
        this.axI = viewGroup;
        this.axI.setVisibility(8);
    }

    public void d(LayerChildView layerChildView) {
        if (this.axI == null) {
            BdLog.e("LAYER_ERRORparams error LayerParentView is null");
        } else if (layerChildView == null || layerChildView.getRootView() == null) {
            BdLog.e("LAYER_ERRORparams error layer or layer view is null");
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.axI.indexOfChild(layerChildView) != -1) {
                BdLog.e("LAYER_ERRORerror layer has showed");
                return;
            }
            this.axI.addView(layerChildView, new RelativeLayout.LayoutParams(-1, -1));
            this.axI.setVisibility(0);
            layerChildView.setLayerCallback(this.axD);
            layerChildView.wF();
            BdLog.d("layer show cost time is" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public boolean e(LayerChildView layerChildView) {
        if (this.axI == null || layerChildView == null) {
            BdLog.e("LAYER_ERRORremove layer error, param error, mLayerParentView is null or layerView is null");
            return false;
        } else if (this.axI.indexOfChild(layerChildView) >= 0) {
            layerChildView.wG();
            return true;
        } else {
            BdLog.e("LAYER_ERRORremove layer error, layerView is " + layerChildView);
            return false;
        }
    }

    public boolean onBackPressed() {
        if (this.axI == null || this.axI.getChildCount() <= 0) {
            return false;
        }
        View childAt = this.axI.getChildAt(this.axI.getChildCount() - 1);
        if (childAt instanceof LayerChildView) {
            LayerChildView layerChildView = (LayerChildView) childAt;
            if (layerChildView.cancelableFlag && !layerChildView.axE) {
                return e(layerChildView);
            }
            return true;
        }
        return false;
    }

    public void wO() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.axI != null && this.axI.getChildCount() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.axI.getChildCount()) {
                    break;
                }
                View childAt = this.axI.getChildAt(i2);
                if (childAt instanceof LayerChildView) {
                    ((LayerChildView) childAt).release();
                }
                i = i2 + 1;
            }
            this.axI.clearAnimation();
            this.axI.removeAllViews();
            this.axI.setVisibility(8);
        }
        BdLog.d("layer clear cost time is" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
        wO();
        this.axI = null;
    }
}
