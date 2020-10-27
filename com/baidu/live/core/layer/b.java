package com.baidu.live.core.layer;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdLog;
/* loaded from: classes4.dex */
public class b {
    private static b aGH;
    private a aGD = new a() { // from class: com.baidu.live.core.layer.b.1
        @Override // com.baidu.live.core.layer.a
        public void a(LayerChildView layerChildView) {
        }

        @Override // com.baidu.live.core.layer.a
        public void b(LayerChildView layerChildView) {
            layerChildView.release();
            if (b.this.aGI != null) {
                b.this.aGI.removeView(layerChildView);
                if (b.this.aGI.getChildCount() <= 1) {
                    b.this.aGI.setVisibility(8);
                }
            }
        }
    };
    private ViewGroup aGI;

    private b() {
    }

    public static b DE() {
        if (aGH == null) {
            synchronized (b.class) {
                if (aGH == null) {
                    aGH = new b();
                }
            }
        }
        return aGH;
    }

    public void n(ViewGroup viewGroup) {
        this.aGI = viewGroup;
        this.aGI.setVisibility(8);
    }

    public void d(LayerChildView layerChildView) {
        if (this.aGI == null) {
            BdLog.e("LAYER_ERRORparams error LayerParentView is null");
        } else if (layerChildView == null || layerChildView.getRootView() == null) {
            BdLog.e("LAYER_ERRORparams error layer or layer view is null");
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.aGI.indexOfChild(layerChildView) != -1) {
                BdLog.e("LAYER_ERRORerror layer has showed");
                return;
            }
            this.aGI.addView(layerChildView, new RelativeLayout.LayoutParams(-1, -1));
            this.aGI.setVisibility(0);
            layerChildView.setLayerCallback(this.aGD);
            layerChildView.Dw();
            BdLog.d("layer show cost time is" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public boolean e(LayerChildView layerChildView) {
        if (this.aGI == null || layerChildView == null) {
            BdLog.e("LAYER_ERRORremove layer error, param error, mLayerParentView is null or layerView is null");
            return false;
        } else if (this.aGI.indexOfChild(layerChildView) >= 0) {
            layerChildView.Dx();
            return true;
        } else {
            BdLog.e("LAYER_ERRORremove layer error, layerView is " + layerChildView);
            return false;
        }
    }

    public boolean onBackPressed() {
        if (this.aGI == null || this.aGI.getChildCount() <= 0) {
            return false;
        }
        View childAt = this.aGI.getChildAt(this.aGI.getChildCount() - 1);
        if (childAt instanceof LayerChildView) {
            LayerChildView layerChildView = (LayerChildView) childAt;
            if (layerChildView.cancelableFlag && !layerChildView.aGE) {
                return e(layerChildView);
            }
            return true;
        }
        return false;
    }

    public void DF() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aGI != null && this.aGI.getChildCount() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.aGI.getChildCount()) {
                    break;
                }
                View childAt = this.aGI.getChildAt(i2);
                if (childAt instanceof LayerChildView) {
                    ((LayerChildView) childAt).release();
                }
                i = i2 + 1;
            }
            this.aGI.clearAnimation();
            this.aGI.removeAllViews();
            this.aGI.setVisibility(8);
        }
        BdLog.d("layer clear cost time is" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
        DF();
        this.aGI = null;
    }
}
