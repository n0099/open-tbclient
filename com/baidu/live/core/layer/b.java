package com.baidu.live.core.layer;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdLog;
/* loaded from: classes10.dex */
public class b {
    private static b aHq;
    private a aHm = new a() { // from class: com.baidu.live.core.layer.b.1
        @Override // com.baidu.live.core.layer.a
        public void a(LayerChildView layerChildView) {
        }

        @Override // com.baidu.live.core.layer.a
        public void b(LayerChildView layerChildView) {
            layerChildView.release();
            if (b.this.aHr != null) {
                b.this.aHr.removeView(layerChildView);
                if (b.this.aHr.getChildCount() <= 1) {
                    b.this.aHr.setVisibility(8);
                }
            }
        }
    };
    private ViewGroup aHr;

    private b() {
    }

    public static b Bf() {
        if (aHq == null) {
            synchronized (b.class) {
                if (aHq == null) {
                    aHq = new b();
                }
            }
        }
        return aHq;
    }

    public void l(ViewGroup viewGroup) {
        this.aHr = viewGroup;
        this.aHr.setVisibility(8);
    }

    public void d(LayerChildView layerChildView) {
        if (this.aHr == null) {
            BdLog.e("LAYER_ERRORparams error LayerParentView is null");
        } else if (layerChildView == null || layerChildView.getRootView() == null) {
            BdLog.e("LAYER_ERRORparams error layer or layer view is null");
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.aHr.indexOfChild(layerChildView) != -1) {
                BdLog.e("LAYER_ERRORerror layer has showed");
                return;
            }
            this.aHr.addView(layerChildView, new RelativeLayout.LayoutParams(-1, -1));
            this.aHr.setVisibility(0);
            layerChildView.setLayerCallback(this.aHm);
            layerChildView.AX();
            BdLog.d("layer show cost time is" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public boolean e(LayerChildView layerChildView) {
        if (this.aHr == null || layerChildView == null) {
            BdLog.e("LAYER_ERRORremove layer error, param error, mLayerParentView is null or layerView is null");
            return false;
        } else if (this.aHr.indexOfChild(layerChildView) >= 0) {
            layerChildView.AY();
            return true;
        } else {
            BdLog.e("LAYER_ERRORremove layer error, layerView is " + layerChildView);
            return false;
        }
    }

    public boolean onBackPressed() {
        if (this.aHr == null || this.aHr.getChildCount() <= 0) {
            return false;
        }
        View childAt = this.aHr.getChildAt(this.aHr.getChildCount() - 1);
        if (childAt instanceof LayerChildView) {
            LayerChildView layerChildView = (LayerChildView) childAt;
            if (layerChildView.cancelableFlag && !layerChildView.aHn) {
                return e(layerChildView);
            }
            return true;
        }
        return false;
    }

    public void Bg() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aHr != null && this.aHr.getChildCount() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.aHr.getChildCount()) {
                    break;
                }
                View childAt = this.aHr.getChildAt(i2);
                if (childAt instanceof LayerChildView) {
                    ((LayerChildView) childAt).release();
                }
                i = i2 + 1;
            }
            this.aHr.clearAnimation();
            this.aHr.removeAllViews();
            this.aHr.setVisibility(8);
        }
        BdLog.d("layer clear cost time is" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
        Bg();
        this.aHr = null;
    }
}
