package com.baidu.swan.apps.canvas.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.net.URI;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public class k extends a {
    private String cJT;
    private Uri cJU;
    private String cJV;
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
                this.cJV = this.cJT;
                this.cJT = jSONArray.optString(0);
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
            com.baidu.swan.apps.runtime.e aos = com.baidu.swan.apps.v.f.aAl().aos();
            if (aos != null) {
                String a4 = a(this.cJT, aos);
                if (!TextUtils.isEmpty(a4)) {
                    this.mBitmap = BitmapFactory.decodeFile(a4);
                } else if (!TextUtils.isEmpty(this.cJT)) {
                    if (this.cJU == null || !TextUtils.equals(this.cJT, this.cJV)) {
                        this.cJU = Uri.parse(this.cJT);
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
            bVar.b(bVar.mBitmapPaint);
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
        if (this.cJU == null || bVar == null) {
            return false;
        }
        CanvasView canvasView = bVar.cJE;
        if (canvasView == null) {
            return false;
        }
        this.mBitmap = canvasView.lI(this.cJT);
        if (this.mBitmap == null) {
            this.mBitmap = com.baidu.swan.apps.ao.s.b(this.cJU, bVar.cJE.getContext());
            return this.mBitmap != null;
        }
        return true;
    }

    @UiThread
    private void b(final b bVar) {
        if (this.mLoadStatus == 0 && bVar.cJE != null && bVar.cJE.getContext() != null && !TextUtils.isEmpty(this.cJT)) {
            this.mLoadStatus = 1;
            Context context = bVar.cJE.getContext();
            final com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> e = com.facebook.drawee.a.a.c.ety().e(ImageRequestBuilder.ag(Uri.parse(this.cJT)).eAq(), context);
            e.a(new com.facebook.imagepipeline.d.b() { // from class: com.baidu.swan.apps.canvas.a.a.k.1
                @Override // com.facebook.imagepipeline.d.b
                public void f(@Nullable Bitmap bitmap) {
                    if (e.isFinished() && bitmap != null) {
                        k.this.mBitmap = Bitmap.createBitmap(bitmap);
                        e.apL();
                        if (bVar.cJE != null) {
                            bVar.cJE.postInvalidate();
                        }
                    }
                    k.this.mLoadStatus = 2;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.datasource.b] */
                @Override // com.facebook.datasource.a
                public void a(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> bVar2) {
                    if (bVar2 != null) {
                        bVar2.apL();
                    }
                    k.this.mLoadStatus = 3;
                }
            }, com.facebook.common.b.i.esE());
        }
    }

    private int a(JSONArray jSONArray, int i) {
        return com.baidu.swan.apps.ao.ah.P((float) jSONArray.optDouble(i));
    }

    private String a(String str, com.baidu.swan.apps.runtime.e eVar) {
        if (TextUtils.isEmpty(str) || eVar == null) {
            return null;
        }
        try {
            if ("bdfile".equalsIgnoreCase(URI.create(str).getScheme())) {
                str = com.baidu.swan.apps.storage.b.cx(str, eVar.id);
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

    public void A(HashMap<String, Bitmap> hashMap) {
        if (hashMap != null && !TextUtils.isEmpty(this.cJT) && this.mBitmap != null && !hashMap.containsKey(this.cJT)) {
            hashMap.put(this.cJT, this.mBitmap);
        }
    }
}
