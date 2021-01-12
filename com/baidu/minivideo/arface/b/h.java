package com.baidu.minivideo.arface.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.minivideo.arface.b;
import com.baidu.minivideo.arface.b.j;
import com.baidu.minivideo.arface.utils.g;
import java.io.File;
/* loaded from: classes5.dex */
public class h {
    private static com.baidu.minivideo.arface.utils.b cgA;
    private static h cgz;
    private Boolean cgB;

    public static h aax() {
        if (cgz == null) {
            createInst();
        }
        return cgz;
    }

    private static synchronized void createInst() {
        synchronized (h.class) {
            if (cgz == null) {
                cgz = new h();
            }
        }
    }

    private h() {
    }

    private boolean aay() {
        String str;
        boolean z = false;
        if (this.cgB == null) {
            this.cgB = false;
            try {
                String[] list = com.baidu.minivideo.arface.b.getContext().getAssets().list("arsource");
                if (list != null && list.length > 0) {
                    z = true;
                }
                this.cgB = Boolean.valueOf(z);
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
        return this.cgB.booleanValue();
    }

    private com.baidu.minivideo.arface.utils.b aaz() {
        if (cgA == null) {
            com.baidu.minivideo.arface.utils.b aaO = com.baidu.minivideo.arface.utils.b.aaO();
            com.baidu.minivideo.arface.b.ZU();
            aaO.b(com.baidu.minivideo.arface.b.getContext(), "arsource", new File(com.baidu.minivideo.arface.c.aac()));
            cgA = aaO;
        }
        return cgA;
    }

    public File aaA() {
        File aai;
        boolean z = com.baidu.minivideo.arface.b.ZV() && aay();
        if (z) {
            aai = e.aas().aat();
        } else {
            aai = b.iw(com.baidu.minivideo.arface.b.ZW()).aai();
        }
        if (com.baidu.minivideo.arface.b.isDebug()) {
            d("sdkPath useLocal " + z + ", SDKPath " + aai);
        }
        return aai;
    }

    public void a(final b.a aVar) {
        if (com.baidu.minivideo.arface.b.ZV() && aay()) {
            c(aVar);
        } else if (com.baidu.minivideo.arface.b.ZT() == null) {
            d("loadSDK with Downlader==null");
        } else {
            b.iw(com.baidu.minivideo.arface.b.ZW()).a(com.baidu.minivideo.arface.b.getContext(), new j.b<b>() { // from class: com.baidu.minivideo.arface.b.h.1
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
            d("loadAssets hasAssetsResource=" + aay());
        }
        if (com.baidu.minivideo.arface.b.ZU() == null) {
            d("DuArResConfig null when loadAssets");
        } else if (TextUtils.isEmpty(com.baidu.minivideo.arface.c.aac())) {
            d("DuArResConfig data empty when loadAssets");
        } else {
            a(com.baidu.minivideo.arface.b.getContext(), "arsource", new File(com.baidu.minivideo.arface.c.aac()), aVar);
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
        aaz().a(context, str, file, new g.a() { // from class: com.baidu.minivideo.arface.b.h.2
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
                        boolean ZK = com.baidu.minivideo.arface.a.ZK();
                        if (com.baidu.minivideo.arface.b.isDebug()) {
                            h.d("loadAssets ARControllerProxy.loadSoFile " + ZK);
                        }
                        if (!ZK) {
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
