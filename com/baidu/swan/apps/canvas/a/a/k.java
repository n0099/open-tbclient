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
    private String amw;
    private Rect amx;
    private Uri amy;
    private String amz;
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
                this.amz = this.amw;
                this.amw = jSONArray.optString(0);
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
                    this.amx = new Rect(optInt, optInt2, optInt3 + optInt, optInt4 + optInt2);
                }
            }
            com.baidu.swan.apps.ae.b AE = com.baidu.swan.apps.w.e.GF().AE();
            if (AE != null) {
                String a3 = a(this.amw, AE);
                if (!TextUtils.isEmpty(a3)) {
                    this.mBitmap = BitmapFactory.decodeFile(a3);
                } else if (!TextUtils.isEmpty(this.amw)) {
                    if (this.amy == null || !TextUtils.equals(this.amw, this.amz)) {
                        this.amy = Uri.parse(this.amw);
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
            int alpha = bVar.Mi.getAlpha();
            bVar.a(bVar.Mi);
            if (this.mDstRect != null) {
                canvas.drawBitmap(this.mBitmap, this.amx, this.mDstRect, bVar.Mi);
            } else {
                canvas.drawBitmap(this.mBitmap, this.mDx, this.mDy, bVar.Mi);
            }
            bVar.Mi.setAlpha(alpha);
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
        if (this.amy == null || bVar == null) {
            return false;
        }
        CanvasView canvasView = bVar.ame;
        if (canvasView == null) {
            return false;
        }
        this.mBitmap = canvasView.m15do(this.amw);
        if (this.mBitmap == null) {
            this.mBitmap = com.baidu.swan.apps.an.m.b(this.amy, bVar.ame.getContext());
            return this.mBitmap != null;
        }
        return true;
    }

    @UiThread
    private void b(final b bVar) {
        if (this.mLoadStatus == 0 && bVar.ame != null && bVar.ame.getContext() != null && !TextUtils.isEmpty(this.amw)) {
            this.mLoadStatus = 1;
            Context context = bVar.ame.getContext();
            final com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> e = com.facebook.drawee.a.a.c.cFw().e(ImageRequestBuilder.U(Uri.parse(this.amw)).cLC(), context);
            e.a(new com.facebook.imagepipeline.e.b() { // from class: com.baidu.swan.apps.canvas.a.a.k.1
                @Override // com.facebook.imagepipeline.e.b
                public void f(@Nullable Bitmap bitmap) {
                    if (e.isFinished() && bitmap != null) {
                        k.this.mBitmap = Bitmap.createBitmap(bitmap);
                        e.AI();
                        if (bVar.ame != null) {
                            bVar.ame.postInvalidate();
                        }
                    }
                    k.this.mLoadStatus = 2;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.datasource.b] */
                @Override // com.facebook.datasource.a
                public void a(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bVar2) {
                    if (bVar2 != null) {
                        bVar2.AI();
                    }
                    k.this.mLoadStatus = 3;
                }
            }, com.facebook.common.b.f.cEB());
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
        if (hashMap != null && !TextUtils.isEmpty(this.amw) && this.mBitmap != null && !hashMap.containsKey(this.amw)) {
            hashMap.put(this.amw, this.mBitmap);
        }
    }
}
