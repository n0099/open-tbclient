package com.baidu.ar.steploading;

import android.text.TextUtils;
import com.baidu.ar.bean.ARCaseBundleInfo;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.callback.IError;
import com.baidu.ar.h.t;
import com.baidu.ar.ihttp.Downloader;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.IProgressCallback;
import java.io.File;
/* loaded from: classes6.dex */
class c extends com.baidu.ar.e.a<String, Void> {
    private IProgressCallback qN;
    private ARCaseBundleInfo xx;
    private String xy;
    private a xz;

    public c(ARCaseBundleInfo aRCaseBundleInfo, String str, a aVar, IProgressCallback iProgressCallback) {
        this.xx = aRCaseBundleInfo;
        this.xy = str;
        this.xz = aVar;
        this.qN = iProgressCallback;
    }

    private String a(f fVar) {
        String parent = new File(this.xx.caseDir).getParent();
        if ("gzip".equalsIgnoreCase(fVar.xM)) {
            return parent + String.format("/temp/%s.zip", fVar.xL);
        }
        if ("identity".equalsIgnoreCase(fVar.xM)) {
            return parent + File.separator + fVar.xK;
        }
        return null;
    }

    private boolean a(String str, f fVar, int i) {
        File file = new File(str);
        if (file.exists() && file.length() == i) {
            if ("gzip".equalsIgnoreCase(fVar.xM)) {
                return t.a(new File(str), new File(this.xx.caseDir).getParentFile());
            }
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.e.a
    public void a(String str, ICallbackWith<Void> iCallbackWith, IError iError) {
        if (TextUtils.isEmpty(str)) {
            iError.onError(2, "res url is not exists", null);
        } else if ("local".equals(str)) {
            iCallbackWith.run(null);
        } else {
            f aN = this.xz.aN(this.xy);
            if (aN == null) {
                iError.onError(2, "res is not exists", null);
                return;
            }
            String a2 = a(aN);
            if (a2 == null) {
                iError.onError(2, "未知的资源encoding", null);
                return;
            }
            Downloader downloader = new Downloader(str);
            try {
                int fileSize = downloader.getFileSize();
                if (a(a2, aN, fileSize)) {
                    iCallbackWith.run(null);
                    return;
                }
                try {
                    downloader.download(a2, this.qN);
                    if (a(a2, aN, fileSize)) {
                        iCallbackWith.run(null);
                    } else {
                        iError.onError(2, "download fail", null);
                    }
                } catch (Exception e) {
                    iError.onError(2, e.getMessage(), e);
                }
            } catch (HttpException e2) {
                iError.onError(2, e2.getMessage(), e2);
            }
        }
    }

    @Override // com.baidu.ar.e.a
    protected void fp() {
    }
}
