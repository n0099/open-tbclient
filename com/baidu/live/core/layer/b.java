package com.baidu.live.core.layer;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdLog;
/* loaded from: classes4.dex */
public class b {
    private static b aIu;
    private a aIq = new a() { // from class: com.baidu.live.core.layer.b.1
        @Override // com.baidu.live.core.layer.a
        public void a(LayerChildView layerChildView) {
        }

        @Override // com.baidu.live.core.layer.a
        public void b(LayerChildView layerChildView) {
            layerChildView.release();
            if (b.this.aIv != null) {
                b.this.aIv.removeView(layerChildView);
                if (b.this.aIv.getChildCount() <= 1) {
                    b.this.aIv.setVisibility(8);
                }
            }
        }
    };
    private ViewGroup aIv;

    private b() {
    }

    public static b EY() {
        if (aIu == null) {
            synchronized (b.class) {
                if (aIu == null) {
                    aIu = new b();
                }
            }
        }
        return aIu;
    }

    public void j(ViewGroup viewGroup) {
        this.aIv = viewGroup;
        this.aIv.setVisibility(8);
    }

    public void d(LayerChildView layerChildView) {
        if (this.aIv == null) {
            BdLog.e("LAYER_ERRORparams error LayerParentView is null");
        } else if (layerChildView == null || layerChildView.getRootView() == null) {
            BdLog.e("LAYER_ERRORparams error layer or layer view is null");
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.aIv.indexOfChild(layerChildView) != -1) {
                BdLog.e("LAYER_ERRORerror layer has showed");
                return;
            }
            this.aIv.addView(layerChildView, new RelativeLayout.LayoutParams(-1, -1));
            this.aIv.setVisibility(0);
            layerChildView.setLayerCallback(this.aIq);
            layerChildView.EQ();
            BdLog.d("layer show cost time is" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public boolean e(LayerChildView layerChildView) {
        if (this.aIv == null || layerChildView == null) {
            BdLog.e("LAYER_ERRORremove layer error, param error, mLayerParentView is null or layerView is null");
            return false;
        } else if (this.aIv.indexOfChild(layerChildView) >= 0) {
            layerChildView.ER();
            return true;
        } else {
            BdLog.e("LAYER_ERRORremove layer error, layerView is " + layerChildView);
            return false;
        }
    }

    public boolean onBackPressed() {
        if (this.aIv == null || this.aIv.getChildCount() <= 0) {
            return false;
        }
        View childAt = this.aIv.getChildAt(this.aIv.getChildCount() - 1);
        if (childAt instanceof LayerChildView) {
            LayerChildView layerChildView = (LayerChildView) childAt;
            if (layerChildView.cancelableFlag && !layerChildView.aIr) {
                return e(layerChildView);
            }
            return true;
        }
        return false;
    }

    public void EZ() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.aIv != null && this.aIv.getChildCount() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.aIv.getChildCount()) {
                    break;
                }
                View childAt = this.aIv.getChildAt(i2);
                if (childAt instanceof LayerChildView) {
                    ((LayerChildView) childAt).release();
                }
                i = i2 + 1;
            }
            this.aIv.clearAnimation();
            this.aIv.removeAllViews();
            this.aIv.setVisibility(8);
        }
        BdLog.d("layer clear cost time is" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
        EZ();
        this.aIv = null;
    }
}
