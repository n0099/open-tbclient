package com.baidu.live.core.layer;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdLog;
/* loaded from: classes4.dex */
public class b {
    private static b aGz;
    private ViewGroup aGA;
    private a aGv = new a() { // from class: com.baidu.live.core.layer.b.1
        @Override // com.baidu.live.core.layer.a
        public void a(LayerChildView layerChildView) {
        }

        @Override // com.baidu.live.core.layer.a
        public void b(LayerChildView layerChildView) {
            layerChildView.release();
            if (b.this.aGA != null) {
                b.this.aGA.removeView(layerChildView);
                if (b.this.aGA.getChildCount() <= 1) {
                    b.this.aGA.setVisibility(8);
                }
            }
        }
    };

    private b() {
    }

    public static b Dx() {
        if (aGz == null) {
            synchronized (b.class) {
                if (aGz == null) {
                    aGz = new b();
                }
            }
        }
        return aGz;
    }

    public void n(ViewGroup viewGroup) {
        this.aGA = viewGroup;
        this.aGA.setVisibility(8);
    }

    public void d(LayerChildView layerChildView) {
        if (this.aGA == null) {
            BdLog.e("LAYER_ERRORparams error LayerParentView is null");
        } else if (layerChildView == null || layerChildView.getRootView() == null) {
            BdLog.e("LAYER_ERRORparams error layer or layer view is null");
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.aGA.indexOfChild(layerChildView) != -1) {
                BdLog.e("LAYER_ERRORerror layer has showed");
                return;
            }
            this.aGA.addView(layerChildView, new RelativeLayout.LayoutParams(-1, -1));
            this.aGA.setVisibility(0);
            layerChildView.setLayerCallback(this.aGv);
            layerChildView.Dp();
            BdLog.d("layer show cost time is" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public boolean e(LayerChildView layerChildView) {
        if (this.aGA == null || layerChildView == null) {
            BdLog.e("LAYER_ERRORremove layer error, param error, mLayerParentView is null or layerView is null");
            return false;
        } else if (this.aGA.indexOfChild(layerChildView) >= 0) {
            layerChildView.Dq();
            return true;
        } else {
            BdLog.e("LAYER_ERRORremove layer error, layerView is " + layerChildView);
            return false;
        }
    }

    public boolean onBackPressed() {
        if (this.aGA == null || this.aGA.getChildCount() <= 0) {
            return false;
        }
        View childAt = this.aGA.getChildAt(this.aGA.getChildCount() - 1);
        if (childAt instanceof LayerChildView) {
            LayerChildView layerChildView = (LayerChildView) childAt;
            if (layerChildView.cancelableFlag && !layerChildView.aGw) {
                return e(layerChildView);
            }
            return true;
        }
        return false;
    }

    public void Dy() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aGA != null && this.aGA.getChildCount() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.aGA.getChildCount()) {
                    break;
                }
                View childAt = this.aGA.getChildAt(i2);
                if (childAt instanceof LayerChildView) {
                    ((LayerChildView) childAt).release();
                }
                i = i2 + 1;
            }
            this.aGA.clearAnimation();
            this.aGA.removeAllViews();
            this.aGA.setVisibility(8);
        }
        BdLog.d("layer clear cost time is" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
        Dy();
        this.aGA = null;
    }
}
