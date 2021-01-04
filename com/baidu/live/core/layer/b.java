package com.baidu.live.core.layer;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdLog;
/* loaded from: classes11.dex */
public class b {
    private static b aIQ;
    private a aIM = new a() { // from class: com.baidu.live.core.layer.b.1
        @Override // com.baidu.live.core.layer.a
        public void a(LayerChildView layerChildView) {
        }

        @Override // com.baidu.live.core.layer.a
        public void b(LayerChildView layerChildView) {
            layerChildView.release();
            if (b.this.aIR != null) {
                b.this.aIR.removeView(layerChildView);
                if (b.this.aIR.getChildCount() <= 1) {
                    b.this.aIR.setVisibility(8);
                }
            }
        }
    };
    private ViewGroup aIR;

    private b() {
    }

    public static b En() {
        if (aIQ == null) {
            synchronized (b.class) {
                if (aIQ == null) {
                    aIQ = new b();
                }
            }
        }
        return aIQ;
    }

    public void l(ViewGroup viewGroup) {
        this.aIR = viewGroup;
        this.aIR.setVisibility(8);
    }

    public void d(LayerChildView layerChildView) {
        if (this.aIR == null) {
            BdLog.e("LAYER_ERRORparams error LayerParentView is null");
        } else if (layerChildView == null || layerChildView.getRootView() == null) {
            BdLog.e("LAYER_ERRORparams error layer or layer view is null");
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.aIR.indexOfChild(layerChildView) != -1) {
                BdLog.e("LAYER_ERRORerror layer has showed");
                return;
            }
            this.aIR.addView(layerChildView, new RelativeLayout.LayoutParams(-1, -1));
            this.aIR.setVisibility(0);
            layerChildView.setLayerCallback(this.aIM);
            layerChildView.Ef();
            BdLog.d("layer show cost time is" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public boolean e(LayerChildView layerChildView) {
        if (this.aIR == null || layerChildView == null) {
            BdLog.e("LAYER_ERRORremove layer error, param error, mLayerParentView is null or layerView is null");
            return false;
        } else if (this.aIR.indexOfChild(layerChildView) >= 0) {
            layerChildView.Eg();
            return true;
        } else {
            BdLog.e("LAYER_ERRORremove layer error, layerView is " + layerChildView);
            return false;
        }
    }

    public boolean onBackPressed() {
        if (this.aIR == null || this.aIR.getChildCount() <= 0) {
            return false;
        }
        View childAt = this.aIR.getChildAt(this.aIR.getChildCount() - 1);
        if (childAt instanceof LayerChildView) {
            LayerChildView layerChildView = (LayerChildView) childAt;
            if (layerChildView.cancelableFlag && !layerChildView.aIN) {
                return e(layerChildView);
            }
            return true;
        }
        return false;
    }

    public void Eo() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aIR != null && this.aIR.getChildCount() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.aIR.getChildCount()) {
                    break;
                }
                View childAt = this.aIR.getChildAt(i2);
                if (childAt instanceof LayerChildView) {
                    ((LayerChildView) childAt).release();
                }
                i = i2 + 1;
            }
            this.aIR.clearAnimation();
            this.aIR.removeAllViews();
            this.aIR.setVisibility(8);
        }
        BdLog.d("layer clear cost time is" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
        Eo();
        this.aIR = null;
    }
}
