package com.baidu.ar.steploading;

import android.text.TextUtils;
import com.baidu.ar.bean.ARCaseBundleInfo;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.callback.IError;
import com.baidu.ar.g.t;
import com.baidu.ar.ihttp.Downloader;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.IProgressCallback;
import java.io.File;
/* loaded from: classes10.dex */
class c extends com.baidu.ar.e.a<String, Void> {
    private IProgressCallback qx;
    private ARCaseBundleInfo wJ;
    private String wK;
    private a wL;

    public c(ARCaseBundleInfo aRCaseBundleInfo, String str, a aVar, IProgressCallback iProgressCallback) {
        this.wJ = aRCaseBundleInfo;
        this.wK = str;
        this.wL = aVar;
        this.qx = iProgressCallback;
    }

    private String a(f fVar) {
        String parent = new File(this.wJ.caseDir).getParent();
        if ("gzip".equalsIgnoreCase(fVar.wY)) {
            return parent + String.format("/temp/%s.zip", fVar.wX);
        }
        if ("identity".equalsIgnoreCase(fVar.wY)) {
            return parent + File.separator + fVar.wW;
        }
        return null;
    }

    private boolean a(String str, f fVar, int i) {
        File file = new File(str);
        if (file.exists() && file.length() == i) {
            if ("gzip".equalsIgnoreCase(fVar.wY)) {
                return t.a(new File(str), new File(this.wJ.caseDir).getParentFile());
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
            f aK = this.wL.aK(this.wK);
            if (aK == null) {
                iError.onError(2, "res is not exists", null);
                return;
            }
            String a = a(aK);
            if (a == null) {
                iError.onError(2, "未知的资源encoding", null);
                return;
            }
            Downloader downloader = new Downloader(str);
            try {
                int fileSize = downloader.getFileSize();
                if (a(a, aK, fileSize)) {
                    iCallbackWith.run(null);
                    return;
                }
                try {
                    downloader.download(a, this.qx);
                    if (a(a, aK, fileSize)) {
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
    protected void fq() {
    }
}
