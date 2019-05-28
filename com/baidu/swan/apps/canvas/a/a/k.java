package com.baidu.swan.apps.canvas.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.net.URI;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class k extends a {
    private String alT;
    private Rect alU;
    private Uri alV;
    private String alW;
    private Bitmap mBitmap;
    private Rect mDstRect;
    private int mDx;
    private int mDy;
    private int mLoadStatus = 0;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void e(JSONArray jSONArray) {
        try {
            int length = jSONArray.length();
            if (length > 0) {
                this.alW = this.alT;
                this.alT = jSONArray.optString(0);
            }
            if (length > 2) {
                this.mDx = a(jSONArray, 1);
                this.mDy = a(jSONArray, 2);
            }
            if (length > 4) {
                int i = this.mDx;
                int i2 = this.mDy;
                int a = a(jSONArray, 3);
                int a2 = a(jSONArray, 4);
                if (a > 0 && a2 > 0) {
                    this.mDstRect = new Rect(i, i2, a + i, a2 + i2);
                }
            }
            if (length > 8) {
                int optInt = jSONArray.optInt(5);
                int optInt2 = jSONArray.optInt(6);
                int optInt3 = jSONArray.optInt(7);
                int optInt4 = jSONArray.optInt(8);
                if (optInt3 > 0 && optInt4 > 0) {
                    this.alU = new Rect(optInt, optInt2, optInt3 + optInt, optInt4 + optInt2);
                }
            }
            com.baidu.swan.apps.ae.b zX = com.baidu.swan.apps.w.e.FV().zX();
            if (zX != null) {
                String a3 = a(this.alT, zX);
                if (!TextUtils.isEmpty(a3)) {
                    this.mBitmap = BitmapFactory.decodeFile(a3);
                } else if (!TextUtils.isEmpty(this.alT)) {
                    if (this.alV == null || !TextUtils.equals(this.alT, this.alW)) {
                        this.alV = Uri.parse(this.alT);
                    }
                }
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void a(b bVar, Canvas canvas) {
        if (a(bVar)) {
            int alpha = bVar.mBitmapPaint.getAlpha();
            bVar.a(bVar.mBitmapPaint);
            if (this.mDstRect != null) {
                canvas.drawBitmap(this.mBitmap, this.alU, this.mDstRect, bVar.mBitmapPaint);
            } else {
                canvas.drawBitmap(this.mBitmap, this.mDx, this.mDy, bVar.mBitmapPaint);
            }
            bVar.mBitmapPaint.setAlpha(alpha);
            return;
        }
        try {
            b(bVar);
        } catch (Exception e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private boolean a(b bVar) {
        if (this.mBitmap != null) {
            return true;
        }
        if (this.alV == null || bVar == null) {
            return false;
        }
        CanvasView canvasView = bVar.alB;
        if (canvasView == null) {
            return false;
        }
        this.mBitmap = canvasView.dk(this.alT);
        if (this.mBitmap == null) {
            this.mBitmap = com.baidu.swan.apps.an.m.b(this.alV, bVar.alB.getContext());
            return this.mBitmap != null;
        }
        return true;
    }

    @UiThread
    private void b(final b bVar) {
        if (this.mLoadStatus == 0 && bVar.alB != null && bVar.alB.getContext() != null && !TextUtils.isEmpty(this.alT)) {
            this.mLoadStatus = 1;
            Context context = bVar.alB.getContext();
            final com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> e = com.facebook.drawee.a.a.c.cCw().e(ImageRequestBuilder.U(Uri.parse(this.alT)).cIz(), context);
            e.a(new com.facebook.imagepipeline.e.b() { // from class: com.baidu.swan.apps.canvas.a.a.k.1
                @Override // com.facebook.imagepipeline.e.b
                public void f(@Nullable Bitmap bitmap) {
                    if (e.isFinished() && bitmap != null) {
                        k.this.mBitmap = Bitmap.createBitmap(bitmap);
                        e.Ab();
                        if (bVar.alB != null) {
                            bVar.alB.postInvalidate();
                        }
                    }
                    k.this.mLoadStatus = 2;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.datasource.b] */
                @Override // com.facebook.datasource.a
                public void a(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bVar2) {
                    if (bVar2 != null) {
                        bVar2.Ab();
                    }
                    k.this.mLoadStatus = 3;
                }
            }, com.facebook.common.b.f.cBB());
        }
    }

    private int a(JSONArray jSONArray, int i) {
        return com.baidu.swan.apps.an.z.ad((float) jSONArray.optDouble(i));
    }

    private String a(String str, com.baidu.swan.apps.ae.b bVar) {
        if (TextUtils.isEmpty(str) || bVar == null) {
            return null;
        }
        try {
            if ("bdfile".equalsIgnoreCase(URI.create(str).getScheme())) {
                str = com.baidu.swan.apps.storage.b.aE(str, bVar.id);
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

    public void m(HashMap<String, Bitmap> hashMap) {
        if (hashMap != null && !TextUtils.isEmpty(this.alT) && this.mBitmap != null && !hashMap.containsKey(this.alT)) {
            hashMap.put(this.alT, this.mBitmap);
        }
    }
}
