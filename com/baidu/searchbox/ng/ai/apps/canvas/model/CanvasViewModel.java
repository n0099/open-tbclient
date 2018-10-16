package com.baidu.searchbox.ng.ai.apps.canvas.model;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.canvas.view.CanvasView;
/* loaded from: classes2.dex */
public class CanvasViewModel {
    public String canvasId;
    public CanvasView canvasView;

    public CanvasViewModel(Context context, String str, CanvasBasicModel canvasBasicModel) {
        this.canvasId = str;
        this.canvasView = new CanvasView(context);
        if (canvasBasicModel != null) {
            this.canvasView.setInterceptTouchEvent(canvasBasicModel.disableScroll);
            this.canvasView.setHide(canvasBasicModel.hidden);
            this.canvasView.setGesture(canvasBasicModel.gesture);
            if (canvasBasicModel.gesture) {
                this.canvasView.setInterceptTouchEvent(false);
            }
        }
    }

    public void release() {
        this.canvasView = null;
    }
}
