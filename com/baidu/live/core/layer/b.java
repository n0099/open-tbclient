package com.baidu.live.core.layer;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdLog;
/* loaded from: classes10.dex */
public class b {
    private static b aEd;
    private a aDZ = new a() { // from class: com.baidu.live.core.layer.b.1
        @Override // com.baidu.live.core.layer.a
        public void a(LayerChildView layerChildView) {
        }

        @Override // com.baidu.live.core.layer.a
        public void b(LayerChildView layerChildView) {
            layerChildView.release();
            if (b.this.aEe != null) {
                b.this.aEe.removeView(layerChildView);
                if (b.this.aEe.getChildCount() <= 1) {
                    b.this.aEe.setVisibility(8);
                }
            }
        }
    };
    private ViewGroup aEe;

    private b() {
    }

    public static b As() {
        if (aEd == null) {
            synchronized (b.class) {
                if (aEd == null) {
                    aEd = new b();
                }
            }
        }
        return aEd;
    }

    public void l(ViewGroup viewGroup) {
        this.aEe = viewGroup;
        this.aEe.setVisibility(8);
    }

    public void d(LayerChildView layerChildView) {
        if (this.aEe == null) {
            BdLog.e("LAYER_ERRORparams error LayerParentView is null");
        } else if (layerChildView == null || layerChildView.getRootView() == null) {
            BdLog.e("LAYER_ERRORparams error layer or layer view is null");
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.aEe.indexOfChild(layerChildView) != -1) {
                BdLog.e("LAYER_ERRORerror layer has showed");
                return;
            }
            this.aEe.addView(layerChildView, new RelativeLayout.LayoutParams(-1, -1));
            this.aEe.setVisibility(0);
            layerChildView.setLayerCallback(this.aDZ);
            layerChildView.Ak();
            BdLog.d("layer show cost time is" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public boolean e(LayerChildView layerChildView) {
        if (this.aEe == null || layerChildView == null) {
            BdLog.e("LAYER_ERRORremove layer error, param error, mLayerParentView is null or layerView is null");
            return false;
        } else if (this.aEe.indexOfChild(layerChildView) >= 0) {
            layerChildView.Al();
            return true;
        } else {
            BdLog.e("LAYER_ERRORremove layer error, layerView is " + layerChildView);
            return false;
        }
    }

    public boolean onBackPressed() {
        if (this.aEe == null || this.aEe.getChildCount() <= 0) {
            return false;
        }
        View childAt = this.aEe.getChildAt(this.aEe.getChildCount() - 1);
        if (childAt instanceof LayerChildView) {
            LayerChildView layerChildView = (LayerChildView) childAt;
            if (layerChildView.cancelableFlag && !layerChildView.aEa) {
                return e(layerChildView);
            }
            return true;
        }
        return false;
    }

    public void At() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aEe != null && this.aEe.getChildCount() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.aEe.getChildCount()) {
                    break;
                }
                View childAt = this.aEe.getChildAt(i2);
                if (childAt instanceof LayerChildView) {
                    ((LayerChildView) childAt).release();
                }
                i = i2 + 1;
            }
            this.aEe.clearAnimation();
            this.aEe.removeAllViews();
            this.aEe.setVisibility(8);
        }
        BdLog.d("layer clear cost time is" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
        At();
        this.aEe = null;
    }
}
