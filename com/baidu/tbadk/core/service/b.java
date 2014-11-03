package com.baidu.tbadk.core.service;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.d;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Object, Integer, Boolean> {
    final /* synthetic */ TiebaPrepareImageService Ca;
    String Cb = null;
    String mFileName;
    int mRequestCode;
    Uri mUri;

    public b(TiebaPrepareImageService tiebaPrepareImageService, int i, Uri uri, String str) {
        this.Ca = tiebaPrepareImageService;
        this.mRequestCode = 0;
        this.mUri = null;
        this.mFileName = null;
        this.mRequestCode = i;
        this.mUri = uri;
        this.mFileName = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public Boolean doInBackground(Object... objArr) {
        int i;
        int i2;
        boolean z = true;
        TiebaPrepareImageService.IS_DECODING = true;
        try {
            int i3 = this.mRequestCode;
            TiebaPrepareImageService tiebaPrepareImageService = this.Ca;
            Uri uri = this.mUri;
            String str = this.mFileName;
            i = this.Ca.mMaxSize;
            Bitmap a = k.a(i3, tiebaPrepareImageService, uri, str, i);
            if (a != null) {
                if (s.a((String) null, TbConfig.IMAGE_RESIZED_FILE, a, 80) != null) {
                    int i4 = 100;
                    i2 = this.Ca.mDisplaySize;
                    if (i2 > 0) {
                        i4 = this.Ca.mDisplaySize;
                    }
                    Bitmap a2 = d.a(a, i4);
                    if (a2 == null || s.a((String) null, TbConfig.IMAGE_RESIZED_FILE_DISPLAY, a2, 80) == null) {
                        this.Cb = this.Ca.getString(y.error_sd_error);
                        z = false;
                    }
                } else {
                    this.Cb = this.Ca.getString(y.error_sd_error);
                    z = false;
                }
            } else {
                this.Cb = this.Ca.getString(y.pic_parser_error);
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
        this.Ca.mTask = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        Intent intent = new Intent(TbConfig.getBroadcastActionImageResized());
        intent.putExtra("result", bool);
        if (this.Cb != null) {
            intent.putExtra("error", this.Cb);
        }
        this.Ca.sendBroadcast(intent);
    }
}
