package com.baidu.searchbox.ng.ai.apps.canvas.action.draw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.canvas.view.CanvasView;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.storage.StorageUtil;
import com.baidu.searchbox.ng.ai.apps.util.AiAppFrescoImageUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import com.facebook.common.b.f;
import com.facebook.common.references.a;
import com.facebook.datasource.b;
import com.facebook.drawee.a.a.c;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.net.URI;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class DaDrawImage extends AbsDrawAction {
    public static final String ACTION_TYPE = "drawImage";
    private static final int LOAD_STATUS_FAILURE = 3;
    private static final int LOAD_STATUS_INIT = 0;
    private static final int LOAD_STATUS_LOADING = 1;
    private static final int LOAD_STATUS_SUCCESS = 2;
    private static final String SCHEME_BDFILE = "bdfile";
    private Bitmap mBitmap;
    private Rect mDstRect;
    private int mDx;
    private int mDy;
    private String mImageResource;
    private String mLastImageResource;
    private int mLoadStatus = 0;
    private Rect mSrcRect;
    private Uri mUrl;

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void parseJson(JSONArray jSONArray) {
        try {
            int length = jSONArray.length();
            if (length > 0) {
                this.mLastImageResource = this.mImageResource;
                this.mImageResource = jSONArray.optString(0);
            }
            if (length > 2) {
                this.mDx = parseInt(jSONArray, 1);
                this.mDy = parseInt(jSONArray, 2);
            }
            if (length > 4) {
                int i = this.mDx;
                int i2 = this.mDy;
                int parseInt = parseInt(jSONArray, 3);
                int parseInt2 = parseInt(jSONArray, 4);
                if (parseInt > 0 && parseInt2 > 0) {
                    this.mDstRect = new Rect(i, i2, parseInt + i, parseInt2 + i2);
                }
            }
            if (length > 8) {
                int parseInt3 = parseInt(jSONArray, 5);
                int parseInt4 = parseInt(jSONArray, 6);
                int parseInt5 = parseInt(jSONArray, 7);
                int parseInt6 = parseInt(jSONArray, 8);
                if (parseInt5 > 0 && parseInt6 > 0) {
                    this.mSrcRect = new Rect(parseInt3, parseInt4, parseInt5 + parseInt3, parseInt6 + parseInt4);
                }
            }
            AiApp aiApp = AiAppsController.getInstance().getAiApp();
            if (aiApp != null) {
                String sdCardPath = getSdCardPath(this.mImageResource, aiApp);
                if (!TextUtils.isEmpty(sdCardPath)) {
                    this.mBitmap = BitmapFactory.decodeFile(sdCardPath);
                } else if (!TextUtils.isEmpty(this.mImageResource)) {
                    if (this.mUrl == null || !TextUtils.equals(this.mImageResource, this.mLastImageResource)) {
                        this.mUrl = Uri.parse(this.mImageResource);
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.draw.AbsDrawAction
    public void draw(CanvasContext canvasContext, Canvas canvas) {
        if (isImageLoaded(canvasContext)) {
            int alpha = canvasContext.mBitmapPaint.getAlpha();
            canvasContext.applyGlobal(canvasContext.mBitmapPaint);
            if (this.mDstRect != null) {
                canvas.drawBitmap(this.mBitmap, this.mSrcRect, this.mDstRect, canvasContext.mBitmapPaint);
            } else {
                canvas.drawBitmap(this.mBitmap, this.mDx, this.mDy, canvasContext.mBitmapPaint);
            }
            canvasContext.mBitmapPaint.setAlpha(alpha);
            return;
        }
        try {
            tryLoadImage(canvasContext);
        } catch (Exception e) {
        }
    }

    private boolean isImageLoaded(CanvasContext canvasContext) {
        if (this.mBitmap != null) {
            return true;
        }
        if (this.mUrl == null || canvasContext == null) {
            return false;
        }
        CanvasView canvasView = canvasContext.mAttachedView;
        if (canvasView == null) {
            return false;
        }
        this.mBitmap = canvasView.getBitmapByUrlKey(this.mImageResource);
        if (this.mBitmap == null) {
            this.mBitmap = AiAppFrescoImageUtils.getBitmapFromCache(this.mUrl, canvasContext.mAttachedView.getContext());
            return this.mBitmap != null;
        }
        return true;
    }

    @UiThread
    private void tryLoadImage(final CanvasContext canvasContext) {
        if (this.mLoadStatus == 0 && canvasContext.mAttachedView != null && canvasContext.mAttachedView.getContext() != null && !TextUtils.isEmpty(this.mImageResource)) {
            this.mLoadStatus = 1;
            Context context = canvasContext.mAttachedView.getContext();
            final b<a<com.facebook.imagepipeline.f.b>> e = c.bTX().e(ImageRequestBuilder.G(Uri.parse(this.mImageResource)).bZS(), context);
            e.a(new com.facebook.imagepipeline.e.b() { // from class: com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaDrawImage.1
                @Override // com.facebook.imagepipeline.e.b
                public void onNewResultImpl(@Nullable Bitmap bitmap) {
                    if (e.isFinished() && bitmap != null) {
                        DaDrawImage.this.mBitmap = Bitmap.createBitmap(bitmap);
                        e.bTI();
                        if (canvasContext.mAttachedView != null) {
                            canvasContext.mAttachedView.postInvalidate();
                        }
                    }
                    DaDrawImage.this.mLoadStatus = 2;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.datasource.b] */
                @Override // com.facebook.datasource.a
                public void onFailureImpl(b<a<com.facebook.imagepipeline.f.b>> bVar) {
                    if (bVar != null) {
                        bVar.bTI();
                    }
                    DaDrawImage.this.mLoadStatus = 3;
                }
            }, f.bTa());
        }
    }

    private int parseInt(JSONArray jSONArray, int i) {
        return AiAppsUIUtils.dp2px((float) jSONArray.optDouble(i));
    }

    private String getSdCardPath(String str, AiApp aiApp) {
        if (TextUtils.isEmpty(str) || aiApp == null) {
            return null;
        }
        try {
            if (SCHEME_BDFILE.equalsIgnoreCase(URI.create(str).getScheme())) {
                str = StorageUtil.scheme2Path(str, aiApp.id);
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                return file.getAbsolutePath();
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public void cacheBitmap(HashMap<String, Bitmap> hashMap) {
        if (hashMap != null && !TextUtils.isEmpty(this.mImageResource) && this.mBitmap != null && !hashMap.containsKey(this.mImageResource)) {
            hashMap.put(this.mImageResource, this.mBitmap);
        }
    }
}
