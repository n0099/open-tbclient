package com.baidu.searchbox.ng.ai.apps.canvas.manager;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.canvas.model.CanvasBasicModel;
import com.baidu.searchbox.ng.ai.apps.canvas.model.CanvasViewModel;
import com.baidu.searchbox.ng.ai.apps.canvas.view.CanvasView;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes2.dex */
interface ICanvasManager {
    boolean drawCanvas(Context context, CanvasBasicModel canvasBasicModel);

    CanvasView getCanvasViewByCanvasId(CanvasBasicModel canvasBasicModel);

    CanvasViewModel getCanvasViewModelByCanvasId(CanvasBasicModel canvasBasicModel);

    boolean insert(Context context, WebView webView, CanvasBasicModel canvasBasicModel);

    boolean remove(WebView webView, CanvasBasicModel canvasBasicModel);

    boolean update(WebView webView, CanvasBasicModel canvasBasicModel);
}
