package com.baidu.live.core.layer;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdLog;
/* loaded from: classes7.dex */
public class b {
    private static b aCL;
    private a aCH = new a() { // from class: com.baidu.live.core.layer.b.1
        @Override // com.baidu.live.core.layer.a
        public void a(LayerChildView layerChildView) {
        }

        @Override // com.baidu.live.core.layer.a
        public void b(LayerChildView layerChildView) {
            layerChildView.release();
            if (b.this.aCM != null) {
                b.this.aCM.removeView(layerChildView);
                if (b.this.aCM.getChildCount() <= 1) {
                    b.this.aCM.setVisibility(8);
                }
            }
        }
    };
    private ViewGroup aCM;

    private b() {
    }

    public static b Cl() {
        if (aCL == null) {
            synchronized (b.class) {
                if (aCL == null) {
                    aCL = new b();
                }
            }
        }
        return aCL;
    }

    public void m(ViewGroup viewGroup) {
        this.aCM = viewGroup;
        this.aCM.setVisibility(8);
    }

    public void d(LayerChildView layerChildView) {
        if (this.aCM == null) {
            BdLog.e("LAYER_ERRORparams error LayerParentView is null");
        } else if (layerChildView == null || layerChildView.getRootView() == null) {
            BdLog.e("LAYER_ERRORparams error layer or layer view is null");
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.aCM.indexOfChild(layerChildView) != -1) {
                BdLog.e("LAYER_ERRORerror layer has showed");
                return;
            }
            this.aCM.addView(layerChildView, new RelativeLayout.LayoutParams(-1, -1));
            this.aCM.setVisibility(0);
            layerChildView.setLayerCallback(this.aCH);
            layerChildView.Cd();
            BdLog.d("layer show cost time is" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public boolean e(LayerChildView layerChildView) {
        if (this.aCM == null || layerChildView == null) {
            BdLog.e("LAYER_ERRORremove layer error, param error, mLayerParentView is null or layerView is null");
            return false;
        } else if (this.aCM.indexOfChild(layerChildView) >= 0) {
            layerChildView.Ce();
            return true;
        } else {
            BdLog.e("LAYER_ERRORremove layer error, layerView is " + layerChildView);
            return false;
        }
    }

    public boolean onBackPressed() {
        if (this.aCM == null || this.aCM.getChildCount() <= 0) {
            return false;
        }
        View childAt = this.aCM.getChildAt(this.aCM.getChildCount() - 1);
        if (childAt instanceof LayerChildView) {
            LayerChildView layerChildView = (LayerChildView) childAt;
            if (layerChildView.cancelableFlag && !layerChildView.aCI) {
                return e(layerChildView);
            }
            return true;
        }
        return false;
    }

    public void Cm() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aCM != null && this.aCM.getChildCount() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.aCM.getChildCount()) {
                    break;
                }
                View childAt = this.aCM.getChildAt(i2);
                if (childAt instanceof LayerChildView) {
                    ((LayerChildView) childAt).release();
                }
                i = i2 + 1;
            }
            this.aCM.clearAnimation();
            this.aCM.removeAllViews();
            this.aCM.setVisibility(8);
        }
        BdLog.d("layer clear cost time is" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
        Cm();
        this.aCM = null;
    }
}
