package com.baidu.searchbox.ng.ai.apps.canvas.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.PaintFlagsDrawFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.CanvasContext;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaClearRect;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaDrawImage;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaSetShadow;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class CanvasView extends AbsCanvasView {
    private int mDefaultLayerType;
    private final DrawFilter mDrawFilter;
    private HashMap<String, Bitmap> mDrawImageActionHashMap;
    private List<DrawInfo> mInfoList;

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mInfoList = new ArrayList();
        this.mDrawFilter = new PaintFlagsDrawFilter(0, 3);
        this.mDefaultLayerType = 0;
        this.mDrawImageActionHashMap = new HashMap<>();
        this.mDefaultLayerType = getLayerType();
    }

    public void addDrawActionList(List<AbsDrawAction> list, boolean z) {
        if (list != null && !this.mInfoList.contains(list)) {
            if (!z) {
                this.mInfoList.clear();
            }
            int size = this.mInfoList.size();
            boolean z2 = z && size > 0;
            DrawInfo drawInfo = new DrawInfo();
            if (z2) {
                DrawInfo drawInfo2 = this.mInfoList.get(size - 1);
                drawInfo.mCanvasContext = drawInfo2.mCanvasContext;
                drawInfo.mDrawActionList = drawInfo2.mDrawActionList;
                drawInfo.mDrawActionList.addAll(list);
            } else {
                drawInfo.mCanvasContext = new CanvasContext(this);
                drawInfo.mDrawActionList = list;
            }
            this.mInfoList.add(drawInfo);
            AiAppsUtils.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.canvas.view.CanvasView.1
                @Override // java.lang.Runnable
                public void run() {
                    CanvasView.this.checkLayerType();
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return isInterceptTouchEvent() || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mInfoList.size() > 0) {
            canvas.save();
            canvas.setDrawFilter(this.mDrawFilter);
            for (DrawInfo drawInfo : this.mInfoList) {
                List<AbsDrawAction> list = drawInfo.mDrawActionList;
                CanvasContext canvasContext = drawInfo.mCanvasContext;
                canvasContext.init();
                for (AbsDrawAction absDrawAction : list) {
                    absDrawAction.draw(canvasContext, canvas);
                    if (absDrawAction instanceof DaDrawImage) {
                        ((DaDrawImage) absDrawAction).cacheBitmap(this.mDrawImageActionHashMap);
                    }
                }
            }
            canvas.restore();
        }
    }

    public CanvasContext getCanvasContext() {
        if (this.mInfoList.size() > 0) {
            return this.mInfoList.get(this.mInfoList.size() - 1).mCanvasContext;
        }
        return null;
    }

    public Bitmap getBitmapByUrlKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mDrawImageActionHashMap.get(str);
    }

    public synchronized void onRelease() {
        this.mDrawImageActionHashMap.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void checkLayerType() {
        int i;
        int i2 = this.mDefaultLayerType;
        if (this.mInfoList.size() > 0) {
            Iterator<DrawInfo> it = this.mInfoList.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                for (AbsDrawAction absDrawAction : it.next().mDrawActionList) {
                    if ((absDrawAction instanceof DaSetShadow) || (absDrawAction instanceof DaClearRect)) {
                        i2 = 1;
                        break;
                    }
                    while (r3.hasNext()) {
                    }
                }
                i2 = i;
            }
        } else {
            i = i2;
        }
        if (getLayerType() != i) {
            setLayerType(i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class DrawInfo {
        CanvasContext mCanvasContext;
        List<AbsDrawAction> mDrawActionList;

        private DrawInfo() {
        }
    }
}
