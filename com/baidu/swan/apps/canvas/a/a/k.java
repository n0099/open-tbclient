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
/* loaded from: classes10.dex */
public class k extends a {
    private String cnQ;
    private Uri cnR;
    private String cnS;
    private Bitmap mBitmap;
    private Rect mDstRect;
    private int mDx;
    private int mDy;
    private int mLoadStatus = 0;
    private Rect mSrcRect;

    @Override // com.baidu.swan.apps.canvas.a.a.a
    public void parseJson(JSONArray jSONArray) {
        try {
            int length = jSONArray.length();
            if (length > 0) {
                this.cnS = this.cnQ;
                this.cnQ = jSONArray.optString(0);
            }
            if (length > 2) {
                this.mDx = a(jSONArray, 1);
                this.mDy = a(jSONArray, 2);
            }
            if (length > 4) {
                int i = this.mDx;
                int i2 = this.mDy;
                int a2 = a(jSONArray, 3);
                int a3 = a(jSONArray, 4);
                if (a2 > 0 && a3 > 0) {
                    this.mDstRect = new Rect(i, i2, a2 + i, a3 + i2);
                }
            }
            if (length > 8) {
                int optInt = jSONArray.optInt(5);
                int optInt2 = jSONArray.optInt(6);
                int optInt3 = jSONArray.optInt(7);
                int optInt4 = jSONArray.optInt(8);
                if (optInt3 > 0 && optInt4 > 0) {
                    this.mSrcRect = new Rect(optInt, optInt2, optInt3 + optInt, optInt4 + optInt2);
                }
            }
            com.baidu.swan.apps.runtime.e ajI = com.baidu.swan.apps.v.f.avu().ajI();
            if (ajI != null) {
                String b = b(this.cnQ, ajI);
                if (!TextUtils.isEmpty(b)) {
                    this.mBitmap = BitmapFactory.decodeFile(b);
                } else if (!TextUtils.isEmpty(this.cnQ)) {
                    if (this.cnR == null || !TextUtils.equals(this.cnQ, this.cnS)) {
                        this.cnR = Uri.parse(this.cnQ);
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
                canvas.drawBitmap(this.mBitmap, this.mSrcRect, this.mDstRect, bVar.mBitmapPaint);
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
        if (this.cnR == null || bVar == null) {
            return false;
        }
        CanvasView canvasView = bVar.cnB;
        if (canvasView == null) {
            return false;
        }
        this.mBitmap = canvasView.lz(this.cnQ);
        if (this.mBitmap == null) {
            this.mBitmap = com.baidu.swan.apps.ap.s.b(this.cnR, bVar.cnB.getContext());
            return this.mBitmap != null;
        }
        return true;
    }

    @UiThread
    private void b(final b bVar) {
        if (this.mLoadStatus == 0 && bVar.cnB != null && bVar.cnB.getContext() != null && !TextUtils.isEmpty(this.cnQ)) {
            this.mLoadStatus = 1;
            Context context = bVar.cnB.getContext();
            final com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> e = com.facebook.drawee.a.a.c.dXh().e(ImageRequestBuilder.ad(Uri.parse(this.cnQ)).eej(), context);
            e.a(new com.facebook.imagepipeline.e.b() { // from class: com.baidu.swan.apps.canvas.a.a.k.1
                @Override // com.facebook.imagepipeline.e.b
                public void h(@Nullable Bitmap bitmap) {
                    if (e.isFinished() && bitmap != null) {
                        k.this.mBitmap = Bitmap.createBitmap(bitmap);
                        e.akV();
                        if (bVar.cnB != null) {
                            bVar.cnB.postInvalidate();
                        }
                    }
                    k.this.mLoadStatus = 2;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.datasource.b] */
                @Override // com.facebook.datasource.a
                public void a(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> bVar2) {
                    if (bVar2 != null) {
                        bVar2.akV();
                    }
                    k.this.mLoadStatus = 3;
                }
            }, com.facebook.common.b.i.dWn());
        }
    }

    private int a(JSONArray jSONArray, int i) {
        return com.baidu.swan.apps.ap.ah.J((float) jSONArray.optDouble(i));
    }

    private String b(String str, com.baidu.swan.apps.runtime.e eVar) {
        if (TextUtils.isEmpty(str) || eVar == null) {
            return null;
        }
        try {
            if ("bdfile".equalsIgnoreCase(URI.create(str).getScheme())) {
                str = com.baidu.swan.apps.storage.b.cs(str, eVar.id);
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

    public void y(HashMap<String, Bitmap> hashMap) {
        if (hashMap != null && !TextUtils.isEmpty(this.cnQ) && this.mBitmap != null && !hashMap.containsKey(this.cnQ)) {
            hashMap.put(this.cnQ, this.mBitmap);
        }
    }
}
