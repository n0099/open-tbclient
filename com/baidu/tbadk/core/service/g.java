package com.baidu.tbadk.core.service;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<Object, Integer, Boolean> {
    int a;
    Uri b;
    String c = null;
    final /* synthetic */ TiebaPrepareImageService d;

    public g(TiebaPrepareImageService tiebaPrepareImageService, int i, Uri uri) {
        this.d = tiebaPrepareImageService;
        this.a = 0;
        this.b = null;
        this.a = i;
        this.b = uri;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Boolean doInBackground(Object... objArr) {
        int i;
        int i2;
        boolean z = true;
        TiebaPrepareImageService.IS_DECODING = true;
        try {
            int i3 = this.a;
            TiebaPrepareImageService tiebaPrepareImageService = this.d;
            Uri uri = this.b;
            i = this.d.mMaxSize;
            Bitmap a = com.baidu.tbadk.b.g.a(i3, tiebaPrepareImageService, uri, i);
            if (a != null) {
                if (x.a((String) null, TbConfig.IMAGE_RESIZED_FILE, a, 80) != null) {
                    int i4 = 100;
                    i2 = this.d.mDisplaySize;
                    if (i2 > 0) {
                        i4 = this.d.mDisplaySize;
                    }
                    Bitmap a2 = com.baidu.tbadk.core.util.g.a(a, i4);
                    if (a2 == null || x.a((String) null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, a2, 80) == null) {
                        this.c = this.d.getString(y.error_sd_error);
                        z = false;
                    }
                } else {
                    this.c = this.d.getString(y.error_sd_error);
                    z = false;
                }
            } else {
                this.c = this.d.getString(y.pic_parser_error);
                z = false;
            }
            TiebaPrepareImageService.IS_DECODING = false;
        } catch (Exception e) {
            TiebaPrepareImageService.IS_DECODING = false;
            z = false;
        } catch (Throwable th) {
            TiebaPrepareImageService.IS_DECODING = false;
            throw th;
        }
        return Boolean.valueOf(z);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.d.mTask = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        Intent intent = new Intent(TbConfig.getBroadcastActionImageResized());
        intent.putExtra("result", bool);
        if (this.c != null) {
            intent.putExtra("error", this.c);
        }
        this.d.sendBroadcast(intent);
    }
}
