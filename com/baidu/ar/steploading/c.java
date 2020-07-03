package com.baidu.ar.steploading;

import android.text.TextUtils;
import com.baidu.ar.bean.ARCaseBundleInfo;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.callback.IError;
import com.baidu.ar.f.r;
import com.baidu.ar.ihttp.Downloader;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.IProgressCallback;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import java.io.File;
/* loaded from: classes3.dex */
class c extends com.baidu.ar.d.a<String, Void> {
    private IProgressCallback pS;
    private ARCaseBundleInfo wg;
    private String wh;
    private a wi;

    public c(ARCaseBundleInfo aRCaseBundleInfo, String str, a aVar, IProgressCallback iProgressCallback) {
        this.wg = aRCaseBundleInfo;
        this.wh = str;
        this.wi = aVar;
        this.pS = iProgressCallback;
    }

    private String a(f fVar) {
        String parent = new File(this.wg.caseDir).getParent();
        if ("gzip".equalsIgnoreCase(fVar.wv)) {
            return parent + String.format("/temp/%s.zip", fVar.wu);
        }
        if ("identity".equalsIgnoreCase(fVar.wv)) {
            return parent + File.separator + fVar.wt;
        }
        return null;
    }

    private boolean a(String str, f fVar, int i) {
        File file = new File(str);
        if (file.exists() && file.length() == i) {
            if ("gzip".equalsIgnoreCase(fVar.wv)) {
                return r.a(new File(str), new File(this.wg.caseDir).getParentFile());
            }
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.d.a
    public void a(String str, ICallbackWith<Void> iCallbackWith, IError iError) {
        if (TextUtils.isEmpty(str)) {
            iError.onError(2, "res url is not exists", null);
        } else if (RecentlyVisitedForumModel.LOCAL_ACCOUNT.equals(str)) {
            iCallbackWith.run(null);
        } else {
            f aG = this.wi.aG(this.wh);
            if (aG == null) {
                iError.onError(2, "res is not exists", null);
                return;
            }
            String a = a(aG);
            if (a == null) {
                iError.onError(2, "未知的资源encoding", null);
                return;
            }
            Downloader downloader = new Downloader(str);
            try {
                int fileSize = downloader.getFileSize();
                if (a(a, aG, fileSize)) {
                    iCallbackWith.run(null);
                    return;
                }
                try {
                    downloader.download(a, this.pS);
                    if (a(a, aG, fileSize)) {
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

    @Override // com.baidu.ar.d.a
    protected void ee() {
    }
}
