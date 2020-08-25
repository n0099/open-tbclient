package com.baidu.live.core.layer;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdLog;
/* loaded from: classes7.dex */
public class b {
    private static b aCJ;
    private a aCF = new a() { // from class: com.baidu.live.core.layer.b.1
        @Override // com.baidu.live.core.layer.a
        public void a(LayerChildView layerChildView) {
        }

        @Override // com.baidu.live.core.layer.a
        public void b(LayerChildView layerChildView) {
            layerChildView.release();
            b.this.aCK.removeView(layerChildView);
            if (b.this.aCK.getChildCount() <= 1) {
                b.this.aCK.setVisibility(8);
            }
        }
    };
    private ViewGroup aCK;

    private b() {
    }

    public static b Cl() {
        if (aCJ == null) {
            synchronized (b.class) {
                if (aCJ == null) {
                    aCJ = new b();
                }
            }
        }
        return aCJ;
    }

    public void m(ViewGroup viewGroup) {
        this.aCK = viewGroup;
        this.aCK.setVisibility(8);
    }

    public void d(LayerChildView layerChildView) {
        if (this.aCK == null) {
            BdLog.e("LAYER_ERRORparams error LayerParentView is null");
        } else if (layerChildView == null || layerChildView.getRootView() == null) {
            BdLog.e("LAYER_ERRORparams error layer or layer view is null");
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.aCK.indexOfChild(layerChildView) != -1) {
                BdLog.e("LAYER_ERRORerror layer has showed");
                return;
            }
            this.aCK.addView(layerChildView, new RelativeLayout.LayoutParams(-1, -1));
            this.aCK.setVisibility(0);
            layerChildView.setLayerCallback(this.aCF);
            layerChildView.Cd();
            BdLog.d("layer show cost time is" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public boolean e(LayerChildView layerChildView) {
        if (this.aCK == null || layerChildView == null) {
            BdLog.e("LAYER_ERRORremove layer error, param error, mLayerParentView is null or layerView is null");
            return false;
        } else if (this.aCK.indexOfChild(layerChildView) >= 0) {
            layerChildView.Ce();
            return true;
        } else {
            BdLog.e("LAYER_ERRORremove layer error, layerView is " + layerChildView);
            return false;
        }
    }

    public boolean onBackPressed() {
        if (this.aCK == null || this.aCK.getChildCount() <= 0) {
            return false;
        }
        View childAt = this.aCK.getChildAt(this.aCK.getChildCount() - 1);
        if (childAt instanceof LayerChildView) {
            LayerChildView layerChildView = (LayerChildView) childAt;
            if (layerChildView.cancelableFlag && !layerChildView.aCG) {
                return e(layerChildView);
            }
            return true;
        }
        return false;
    }

    public void Cm() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aCK != null && this.aCK.getChildCount() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.aCK.getChildCount()) {
                    break;
                }
                View childAt = this.aCK.getChildAt(i2);
                if (childAt instanceof LayerChildView) {
                    ((LayerChildView) childAt).release();
                }
                i = i2 + 1;
            }
            this.aCK.clearAnimation();
            this.aCK.removeAllViews();
            this.aCK.setVisibility(8);
        }
        BdLog.d("layer clear cost time is" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
        Cm();
        this.aCK = null;
    }
}
