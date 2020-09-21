package com.baidu.live.core.layer;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdLog;
/* loaded from: classes4.dex */
public class b {
    private static b aDv;
    private a aDr = new a() { // from class: com.baidu.live.core.layer.b.1
        @Override // com.baidu.live.core.layer.a
        public void a(LayerChildView layerChildView) {
        }

        @Override // com.baidu.live.core.layer.a
        public void b(LayerChildView layerChildView) {
            layerChildView.release();
            if (b.this.aDw != null) {
                b.this.aDw.removeView(layerChildView);
                if (b.this.aDw.getChildCount() <= 1) {
                    b.this.aDw.setVisibility(8);
                }
            }
        }
    };
    private ViewGroup aDw;

    private b() {
    }

    public static b CA() {
        if (aDv == null) {
            synchronized (b.class) {
                if (aDv == null) {
                    aDv = new b();
                }
            }
        }
        return aDv;
    }

    public void n(ViewGroup viewGroup) {
        this.aDw = viewGroup;
        this.aDw.setVisibility(8);
    }

    public void d(LayerChildView layerChildView) {
        if (this.aDw == null) {
            BdLog.e("LAYER_ERRORparams error LayerParentView is null");
        } else if (layerChildView == null || layerChildView.getRootView() == null) {
            BdLog.e("LAYER_ERRORparams error layer or layer view is null");
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.aDw.indexOfChild(layerChildView) != -1) {
                BdLog.e("LAYER_ERRORerror layer has showed");
                return;
            }
            this.aDw.addView(layerChildView, new RelativeLayout.LayoutParams(-1, -1));
            this.aDw.setVisibility(0);
            layerChildView.setLayerCallback(this.aDr);
            layerChildView.Cs();
            BdLog.d("layer show cost time is" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public boolean e(LayerChildView layerChildView) {
        if (this.aDw == null || layerChildView == null) {
            BdLog.e("LAYER_ERRORremove layer error, param error, mLayerParentView is null or layerView is null");
            return false;
        } else if (this.aDw.indexOfChild(layerChildView) >= 0) {
            layerChildView.Ct();
            return true;
        } else {
            BdLog.e("LAYER_ERRORremove layer error, layerView is " + layerChildView);
            return false;
        }
    }

    public boolean onBackPressed() {
        if (this.aDw == null || this.aDw.getChildCount() <= 0) {
            return false;
        }
        View childAt = this.aDw.getChildAt(this.aDw.getChildCount() - 1);
        if (childAt instanceof LayerChildView) {
            LayerChildView layerChildView = (LayerChildView) childAt;
            if (layerChildView.cancelableFlag && !layerChildView.aDs) {
                return e(layerChildView);
            }
            return true;
        }
        return false;
    }

    public void CB() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aDw != null && this.aDw.getChildCount() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.aDw.getChildCount()) {
                    break;
                }
                View childAt = this.aDw.getChildAt(i2);
                if (childAt instanceof LayerChildView) {
                    ((LayerChildView) childAt).release();
                }
                i = i2 + 1;
            }
            this.aDw.clearAnimation();
            this.aDw.removeAllViews();
            this.aDw.setVisibility(8);
        }
        BdLog.d("layer clear cost time is" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
        CB();
        this.aDw = null;
    }
}
