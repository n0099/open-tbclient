package com.baidu.minivideo.arface.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.minivideo.arface.b;
import com.baidu.minivideo.arface.b.j;
import com.baidu.minivideo.arface.utils.g;
import java.io.File;
/* loaded from: classes3.dex */
public class h {
    private static h ckJ;
    private static com.baidu.minivideo.arface.utils.b ckK;
    private Boolean ckL;

    public static h acl() {
        if (ckJ == null) {
            createInst();
        }
        return ckJ;
    }

    private static synchronized void createInst() {
        synchronized (h.class) {
            if (ckJ == null) {
                ckJ = new h();
            }
        }
    }

    private h() {
    }

    private boolean acm() {
        String str;
        boolean z = false;
        if (this.ckL == null) {
            this.ckL = false;
            try {
                String[] list = com.baidu.minivideo.arface.b.getContext().getAssets().list("arsource");
                if (list != null && list.length > 0) {
                    z = true;
                }
                this.ckL = Boolean.valueOf(z);
                if (com.baidu.minivideo.arface.b.isDebug()) {
                    if (list == null) {
                        str = "null";
                    } else {
                        str = "" + list.length;
                    }
                    d("hasAssetsResource: " + str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.ckL.booleanValue();
    }

    private com.baidu.minivideo.arface.utils.b acn() {
        if (ckK == null) {
            com.baidu.minivideo.arface.utils.b acC = com.baidu.minivideo.arface.utils.b.acC();
            com.baidu.minivideo.arface.b.abI();
            acC.b(com.baidu.minivideo.arface.b.getContext(), "arsource", new File(com.baidu.minivideo.arface.c.abQ()));
            ckK = acC;
        }
        return ckK;
    }

    public File aco() {
        File abW;
        boolean z = com.baidu.minivideo.arface.b.abJ() && acm();
        if (z) {
            abW = e.acg().ach();
        } else {
            abW = b.jc(com.baidu.minivideo.arface.b.abK()).abW();
        }
        if (com.baidu.minivideo.arface.b.isDebug()) {
            d("sdkPath useLocal " + z + ", SDKPath " + abW);
        }
        return abW;
    }

    public void a(final b.a aVar) {
        if (com.baidu.minivideo.arface.b.abJ() && acm()) {
            c(aVar);
        } else if (com.baidu.minivideo.arface.b.abH() == null) {
            d("loadSDK with Downlader==null");
        } else {
            b.jc(com.baidu.minivideo.arface.b.abK()).a(com.baidu.minivideo.arface.b.getContext(), new j.b<b>() { // from class: com.baidu.minivideo.arface.b.h.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.minivideo.arface.b.j.b
                public void a(b bVar, long j, long j2, int i) {
                    super.a((AnonymousClass1) bVar, j, j2, i);
                    if (aVar != null) {
                        aVar.onProgress((int) j2, i);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.minivideo.arface.b.j.b
                /* renamed from: a */
                public void e(b bVar, String str) {
                    if (com.baidu.minivideo.arface.b.isDebug()) {
                        h.d("loadSDK onCompleted filePath: " + str);
                    }
                    super.e(bVar, str);
                    if (aVar != null) {
                        aVar.onResult(true, str);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.minivideo.arface.b.j.b
                public void a(b bVar, Exception exc) {
                    if (com.baidu.minivideo.arface.b.isDebug()) {
                        h.d("loadSDK onFailed failed: " + exc);
                    }
                    super.a((AnonymousClass1) bVar, exc);
                    if (aVar != null) {
                        aVar.onResult(false, exc == null ? "unkown" : exc.getMessage());
                    }
                }
            });
        }
    }

    public void c(b.a aVar) {
        if (com.baidu.minivideo.arface.b.isDebug()) {
            d("loadAssets hasAssetsResource=" + acm());
        }
        if (com.baidu.minivideo.arface.b.abI() == null) {
            d("DuArResConfig null when loadAssets");
        } else if (TextUtils.isEmpty(com.baidu.minivideo.arface.c.abQ())) {
            d("DuArResConfig data empty when loadAssets");
        } else {
            a(com.baidu.minivideo.arface.b.getContext(), "arsource", new File(com.baidu.minivideo.arface.c.abQ()), aVar);
        }
    }

    public void a(Context context, String str, final File file, final b.a aVar) {
        final String str2 = "loadAssets context=" + context + ", assetPath=" + str + ", SDcardFile=" + file;
        if (com.baidu.minivideo.arface.b.isDebug()) {
            d(str2);
        }
        if ((context == null || TextUtils.isEmpty(str) || file == null || TextUtils.isEmpty(file.getAbsolutePath())) && aVar != null) {
            aVar.onResult(false, str2);
        }
        acn().a(context, str, file, new g.a() { // from class: com.baidu.minivideo.arface.b.h.2
            @Override // com.baidu.minivideo.arface.utils.g.a
            public void a(int i, com.baidu.minivideo.arface.utils.g gVar) {
                boolean z = i == 2;
                if (com.baidu.minivideo.arface.b.isDebug()) {
                    h.d("onLoadAssets " + z + ", state " + i);
                }
                if (aVar != null) {
                    String str3 = null;
                    if (!z) {
                        str3 = str2;
                    }
                    if (file != null) {
                        com.baidu.minivideo.arface.b.a(new com.baidu.minivideo.arface.c(file.getAbsolutePath()));
                    }
                    if (z) {
                        boolean abz = com.baidu.minivideo.arface.a.abz();
                        if (com.baidu.minivideo.arface.b.isDebug()) {
                            h.d("loadAssets ARControllerProxy.loadSoFile " + abz);
                        }
                        if (!abz) {
                            z = false;
                        }
                    }
                    aVar.onResult(z, str3);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str) {
        Log.e("DuAr_SDKLoader", "ar->" + str);
    }
}
