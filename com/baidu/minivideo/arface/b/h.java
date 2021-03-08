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
    private static h cmk;
    private static com.baidu.minivideo.arface.utils.b cml;
    private Boolean cmm;

    public static h aco() {
        if (cmk == null) {
            createInst();
        }
        return cmk;
    }

    private static synchronized void createInst() {
        synchronized (h.class) {
            if (cmk == null) {
                cmk = new h();
            }
        }
    }

    private h() {
    }

    private boolean acp() {
        String str;
        boolean z = false;
        if (this.cmm == null) {
            this.cmm = false;
            try {
                String[] list = com.baidu.minivideo.arface.b.getContext().getAssets().list("arsource");
                if (list != null && list.length > 0) {
                    z = true;
                }
                this.cmm = Boolean.valueOf(z);
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
        return this.cmm.booleanValue();
    }

    private com.baidu.minivideo.arface.utils.b acq() {
        if (cml == null) {
            com.baidu.minivideo.arface.utils.b acF = com.baidu.minivideo.arface.utils.b.acF();
            com.baidu.minivideo.arface.b.abL();
            acF.b(com.baidu.minivideo.arface.b.getContext(), "arsource", new File(com.baidu.minivideo.arface.c.abT()));
            cml = acF;
        }
        return cml;
    }

    public File acr() {
        File abZ;
        boolean z = com.baidu.minivideo.arface.b.abM() && acp();
        if (z) {
            abZ = e.acj().ack();
        } else {
            abZ = b.ji(com.baidu.minivideo.arface.b.abN()).abZ();
        }
        if (com.baidu.minivideo.arface.b.isDebug()) {
            d("sdkPath useLocal " + z + ", SDKPath " + abZ);
        }
        return abZ;
    }

    public void a(final b.a aVar) {
        if (com.baidu.minivideo.arface.b.abM() && acp()) {
            c(aVar);
        } else if (com.baidu.minivideo.arface.b.abK() == null) {
            d("loadSDK with Downlader==null");
        } else {
            b.ji(com.baidu.minivideo.arface.b.abN()).a(com.baidu.minivideo.arface.b.getContext(), new j.b<b>() { // from class: com.baidu.minivideo.arface.b.h.1
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
                public void f(b bVar, String str) {
                    if (com.baidu.minivideo.arface.b.isDebug()) {
                        h.d("loadSDK onCompleted filePath: " + str);
                    }
                    super.f(bVar, str);
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
            d("loadAssets hasAssetsResource=" + acp());
        }
        if (com.baidu.minivideo.arface.b.abL() == null) {
            d("DuArResConfig null when loadAssets");
        } else if (TextUtils.isEmpty(com.baidu.minivideo.arface.c.abT())) {
            d("DuArResConfig data empty when loadAssets");
        } else {
            a(com.baidu.minivideo.arface.b.getContext(), "arsource", new File(com.baidu.minivideo.arface.c.abT()), aVar);
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
        acq().a(context, str, file, new g.a() { // from class: com.baidu.minivideo.arface.b.h.2
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
                        boolean abC = com.baidu.minivideo.arface.a.abC();
                        if (com.baidu.minivideo.arface.b.isDebug()) {
                            h.d("loadAssets ARControllerProxy.loadSoFile " + abC);
                        }
                        if (!abC) {
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
