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
/* loaded from: classes3.dex */
public class c extends com.baidu.ar.e.a<String, Void> {
    public IProgressCallback qN;
    public ARCaseBundleInfo xx;
    public String xy;
    public a xz;

    public c(ARCaseBundleInfo aRCaseBundleInfo, String str, a aVar, IProgressCallback iProgressCallback) {
        this.xx = aRCaseBundleInfo;
        this.xy = str;
        this.xz = aVar;
        this.qN = iProgressCallback;
    }

    private String a(f fVar) {
        StringBuilder sb;
        String str;
        String parent = new File(this.xx.caseDir).getParent();
        if ("gzip".equalsIgnoreCase(fVar.xM)) {
            str = String.format("/temp/%s.zip", fVar.xL);
            sb = new StringBuilder();
            sb.append(parent);
        } else if (!"identity".equalsIgnoreCase(fVar.xM)) {
            return null;
        } else {
            sb = new StringBuilder();
            sb.append(parent);
            sb.append(File.separator);
            str = fVar.xK;
        }
        sb.append(str);
        return sb.toString();
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
            String a = a(aN);
            if (a == null) {
                iError.onError(2, "未知的资源encoding", null);
                return;
            }
            Downloader downloader = new Downloader(str);
            try {
                int fileSize = downloader.getFileSize();
                if (!a(a, aN, fileSize)) {
                    try {
                        downloader.download(a, this.qN);
                        if (!a(a, aN, fileSize)) {
                            iError.onError(2, "download fail", null);
                            return;
                        }
                    } catch (Exception e) {
                        iError.onError(2, e.getMessage(), e);
                        return;
                    }
                }
                iCallbackWith.run(null);
            } catch (HttpException e2) {
                iError.onError(2, e2.getMessage(), e2);
            }
        }
    }

    @Override // com.baidu.ar.e.a
    public void fp() {
    }
}
