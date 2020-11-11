package com.baidu.live.core.layer;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdLog;
/* loaded from: classes4.dex */
public class b {
    private static b aHx;
    private a aHt = new a() { // from class: com.baidu.live.core.layer.b.1
        @Override // com.baidu.live.core.layer.a
        public void a(LayerChildView layerChildView) {
        }

        @Override // com.baidu.live.core.layer.a
        public void b(LayerChildView layerChildView) {
            layerChildView.release();
            if (b.this.aHy != null) {
                b.this.aHy.removeView(layerChildView);
                if (b.this.aHy.getChildCount() <= 1) {
                    b.this.aHy.setVisibility(8);
                }
            }
        }
    };
    private ViewGroup aHy;

    private b() {
    }

    public static b DX() {
        if (aHx == null) {
            synchronized (b.class) {
                if (aHx == null) {
                    aHx = new b();
                }
            }
        }
        return aHx;
    }

    public void n(ViewGroup viewGroup) {
        this.aHy = viewGroup;
        this.aHy.setVisibility(8);
    }

    public void d(LayerChildView layerChildView) {
        if (this.aHy == null) {
            BdLog.e("LAYER_ERRORparams error LayerParentView is null");
        } else if (layerChildView == null || layerChildView.getRootView() == null) {
            BdLog.e("LAYER_ERRORparams error layer or layer view is null");
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.aHy.indexOfChild(layerChildView) != -1) {
                BdLog.e("LAYER_ERRORerror layer has showed");
                return;
            }
            this.aHy.addView(layerChildView, new RelativeLayout.LayoutParams(-1, -1));
            this.aHy.setVisibility(0);
            layerChildView.setLayerCallback(this.aHt);
            layerChildView.DP();
            BdLog.d("layer show cost time is" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public boolean e(LayerChildView layerChildView) {
        if (this.aHy == null || layerChildView == null) {
            BdLog.e("LAYER_ERRORremove layer error, param error, mLayerParentView is null or layerView is null");
            return false;
        } else if (this.aHy.indexOfChild(layerChildView) >= 0) {
            layerChildView.DQ();
            return true;
        } else {
            BdLog.e("LAYER_ERRORremove layer error, layerView is " + layerChildView);
            return false;
        }
    }

    public boolean onBackPressed() {
        if (this.aHy == null || this.aHy.getChildCount() <= 0) {
            return false;
        }
        View childAt = this.aHy.getChildAt(this.aHy.getChildCount() - 1);
        if (childAt instanceof LayerChildView) {
            LayerChildView layerChildView = (LayerChildView) childAt;
            if (layerChildView.cancelableFlag && !layerChildView.aHu) {
                return e(layerChildView);
            }
            return true;
        }
        return false;
    }

    public void DY() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aHy != null && this.aHy.getChildCount() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.aHy.getChildCount()) {
                    break;
                }
                View childAt = this.aHy.getChildAt(i2);
                if (childAt instanceof LayerChildView) {
                    ((LayerChildView) childAt).release();
                }
                i = i2 + 1;
            }
            this.aHy.clearAnimation();
            this.aHy.removeAllViews();
            this.aHy.setVisibility(8);
        }
        BdLog.d("layer clear cost time is" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
        DY();
        this.aHy = null;
    }
}
