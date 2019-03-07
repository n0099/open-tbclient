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
    private String alB;
    private Rect alC;
    private Uri alD;
    private String alE;
    private Bitmap mBitmap;
    private Rect mDstRect;
    private int mDx;
    private int mDy;
    private int mLoadStatus = 0;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void g(JSONArray jSONArray) {
        try {
            int length = jSONArray.length();
            if (length > 0) {
                this.alE = this.alB;
                this.alB = jSONArray.optString(0);
            }
            if (length > 2) {
                this.mDx = b(jSONArray, 1);
                this.mDy = b(jSONArray, 2);
            }
            if (length > 4) {
                int i = this.mDx;
                int i2 = this.mDy;
                int b = b(jSONArray, 3);
                int b2 = b(jSONArray, 4);
                if (b > 0 && b2 > 0) {
                    this.mDstRect = new Rect(i, i2, b + i, b2 + i2);
                }
            }
            if (length > 8) {
                int b3 = b(jSONArray, 5);
                int b4 = b(jSONArray, 6);
                int b5 = b(jSONArray, 7);
                int b6 = b(jSONArray, 8);
                if (b5 > 0 && b6 > 0) {
                    this.alC = new Rect(b3, b4, b5 + b3, b6 + b4);
                }
            }
            com.baidu.swan.apps.ae.b zb = com.baidu.swan.apps.w.e.Ec().zb();
            if (zb != null) {
                String a = a(this.alB, zb);
                if (!TextUtils.isEmpty(a)) {
                    this.mBitmap = BitmapFactory.decodeFile(a);
                } else if (!TextUtils.isEmpty(this.alB)) {
                    if (this.alD == null || !TextUtils.equals(this.alB, this.alE)) {
                        this.alD = Uri.parse(this.alB);
                    }
                }
            }
        } catch (Exception e) {
            if (com.baidu.swan.apps.c.DEBUG) {
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
                canvas.drawBitmap(this.mBitmap, this.alC, this.mDstRect, bVar.mBitmapPaint);
            } else {
                canvas.drawBitmap(this.mBitmap, this.mDx, this.mDy, bVar.mBitmapPaint);
            }
            bVar.mBitmapPaint.setAlpha(alpha);
            return;
        }
        try {
            b(bVar);
        } catch (Exception e) {
            if (com.baidu.swan.apps.c.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private boolean a(b bVar) {
        if (this.mBitmap != null) {
            return true;
        }
        if (this.alD == null || bVar == null) {
            return false;
        }
        CanvasView canvasView = bVar.ali;
        if (canvasView == null) {
            return false;
        }
        this.mBitmap = canvasView.dv(this.alB);
        if (this.mBitmap == null) {
            this.mBitmap = com.baidu.swan.apps.an.l.b(this.alD, bVar.ali.getContext());
            return this.mBitmap != null;
        }
        return true;
    }

    @UiThread
    private void b(final b bVar) {
        if (this.mLoadStatus == 0 && bVar.ali != null && bVar.ali.getContext() != null && !TextUtils.isEmpty(this.alB)) {
            this.mLoadStatus = 1;
            Context context = bVar.ali.getContext();
            final com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> e = com.facebook.drawee.a.a.c.cus().e(ImageRequestBuilder.O(Uri.parse(this.alB)).cAv(), context);
            e.a(new com.facebook.imagepipeline.e.b() { // from class: com.baidu.swan.apps.canvas.a.a.k.1
                @Override // com.facebook.imagepipeline.e.b
                public void f(@Nullable Bitmap bitmap) {
                    if (e.isFinished() && bitmap != null) {
                        k.this.mBitmap = Bitmap.createBitmap(bitmap);
                        e.zf();
                        if (bVar.ali != null) {
                            bVar.ali.postInvalidate();
                        }
                    }
                    k.this.mLoadStatus = 2;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.datasource.b] */
                @Override // com.facebook.datasource.a
                public void a(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bVar2) {
                    if (bVar2 != null) {
                        bVar2.zf();
                    }
                    k.this.mLoadStatus = 3;
                }
            }, com.facebook.common.b.f.ctw());
        }
    }

    private int b(JSONArray jSONArray, int i) {
        return com.baidu.swan.apps.an.x.ad((float) jSONArray.optDouble(i));
    }

    private String a(String str, com.baidu.swan.apps.ae.b bVar) {
        if (TextUtils.isEmpty(str) || bVar == null) {
            return null;
        }
        try {
            if ("bdfile".equalsIgnoreCase(URI.create(str).getScheme())) {
                str = com.baidu.swan.apps.storage.b.aC(str, bVar.id);
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
        if (hashMap != null && !TextUtils.isEmpty(this.alB) && this.mBitmap != null && !hashMap.containsKey(this.alB)) {
            hashMap.put(this.alB, this.mBitmap);
        }
    }
}
