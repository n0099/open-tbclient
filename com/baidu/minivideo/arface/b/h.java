package com.baidu.minivideo.arface.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.minivideo.arface.b;
import com.baidu.minivideo.arface.b.j;
import com.baidu.minivideo.arface.utils.g;
import java.io.File;
/* loaded from: classes6.dex */
public class h {
    private static h clm;
    private static com.baidu.minivideo.arface.utils.b cln;
    private Boolean clo;

    public static h aeq() {
        if (clm == null) {
            createInst();
        }
        return clm;
    }

    private static synchronized void createInst() {
        synchronized (h.class) {
            if (clm == null) {
                clm = new h();
            }
        }
    }

    private h() {
    }

    private boolean aer() {
        String str;
        boolean z = false;
        if (this.clo == null) {
            this.clo = false;
            try {
                String[] list = com.baidu.minivideo.arface.b.getContext().getAssets().list("arsource");
                if (list != null && list.length > 0) {
                    z = true;
                }
                this.clo = Boolean.valueOf(z);
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
        return this.clo.booleanValue();
    }

    private com.baidu.minivideo.arface.utils.b aes() {
        if (cln == null) {
            com.baidu.minivideo.arface.utils.b aeH = com.baidu.minivideo.arface.utils.b.aeH();
            com.baidu.minivideo.arface.b.adN();
            aeH.b(com.baidu.minivideo.arface.b.getContext(), "arsource", new File(com.baidu.minivideo.arface.c.adV()));
            cln = aeH;
        }
        return cln;
    }

    public File aet() {
        File aeb;
        boolean z = com.baidu.minivideo.arface.b.adO() && aer();
        if (z) {
            aeb = e.ael().aem();
        } else {
            aeb = b.jH(com.baidu.minivideo.arface.b.adP()).aeb();
        }
        if (com.baidu.minivideo.arface.b.isDebug()) {
            d("sdkPath useLocal " + z + ", SDKPath " + aeb);
        }
        return aeb;
    }

    public void a(final b.a aVar) {
        if (com.baidu.minivideo.arface.b.adO() && aer()) {
            c(aVar);
        } else if (com.baidu.minivideo.arface.b.adM() == null) {
            d("loadSDK with Downlader==null");
        } else {
            b.jH(com.baidu.minivideo.arface.b.adP()).a(com.baidu.minivideo.arface.b.getContext(), new j.b<b>() { // from class: com.baidu.minivideo.arface.b.h.1
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
            d("loadAssets hasAssetsResource=" + aer());
        }
        if (com.baidu.minivideo.arface.b.adN() == null) {
            d("DuArResConfig null when loadAssets");
        } else if (TextUtils.isEmpty(com.baidu.minivideo.arface.c.adV())) {
            d("DuArResConfig data empty when loadAssets");
        } else {
            a(com.baidu.minivideo.arface.b.getContext(), "arsource", new File(com.baidu.minivideo.arface.c.adV()), aVar);
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
        aes().a(context, str, file, new g.a() { // from class: com.baidu.minivideo.arface.b.h.2
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
                        boolean adD = com.baidu.minivideo.arface.a.adD();
                        if (com.baidu.minivideo.arface.b.isDebug()) {
                            h.d("loadAssets ARControllerProxy.loadSoFile " + adD);
                        }
                        if (!adD) {
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
