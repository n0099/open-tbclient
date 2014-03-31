package com.baidu.tbadk.core.service;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.g;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.d.f;
import com.baidu.tbadk.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c extends BdAsyncTask<Object, Integer, Boolean> {
    int a;
    Uri b;
    String c = null;
    final /* synthetic */ TiebaPrepareImageService d;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ Boolean a(Object... objArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Boolean bool) {
        Boolean bool2 = bool;
        super.a((c) bool2);
        Intent intent = new Intent(n.t());
        intent.putExtra("result", bool2);
        if (this.c != null) {
            intent.putExtra("error", this.c);
        }
        this.d.sendBroadcast(intent);
    }

    public c(TiebaPrepareImageService tiebaPrepareImageService, int i, Uri uri) {
        this.d = tiebaPrepareImageService;
        this.a = 0;
        this.b = null;
        this.a = i;
        this.b = uri;
    }

    private Boolean a() {
        int i;
        int i2;
        boolean z = true;
        TiebaPrepareImageService.a = true;
        try {
            int i3 = this.a;
            TiebaPrepareImageService tiebaPrepareImageService = this.d;
            Uri uri = this.b;
            i = this.d.f;
            Bitmap a = f.a(i3, tiebaPrepareImageService, uri, i);
            if (a != null) {
                if (w.a((String) null, "tieba_resized_image", a, 80) != null) {
                    int i4 = 100;
                    i2 = this.d.g;
                    if (i2 > 0) {
                        i4 = this.d.g;
                    }
                    Bitmap a2 = g.a(a, i4);
                    if (a2 == null || w.a((String) null, "tieba_resized_image_display", a2, 80) == null) {
                        this.c = this.d.getString(l.error_sd_error);
                        z = false;
                    }
                } else {
                    this.c = this.d.getString(l.error_sd_error);
                    z = false;
                }
            } else {
                this.c = this.d.getString(l.pic_parser_error);
                z = false;
            }
            TiebaPrepareImageService.a = false;
        } catch (Exception e) {
            TiebaPrepareImageService.a = false;
            z = false;
        } catch (Throwable th) {
            TiebaPrepareImageService.a = false;
            throw th;
        }
        return Boolean.valueOf(z);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        this.d.d = null;
        super.cancel(true);
    }
}
