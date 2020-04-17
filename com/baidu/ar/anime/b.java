package com.baidu.ar.anime;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.ar.arplay.core.engine.pixel.FramePixels;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.databasic.ReserveHandleData;
import com.baidu.ar.f.h;
import com.baidu.ar.f.q;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpResponse;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    private InterfaceC0050b ch;
    private HandlerThread ci;
    private a cj;
    private FramePixels cf = null;
    private byte[] cg = null;
    private boolean ck = true;
    private AlgoHandleController bU = null;
    private ArrayList<String> cl = new ArrayList<>();

    /* loaded from: classes3.dex */
    private static final class a extends Handler {
        private boolean cs;

        public a(Looper looper) {
            super(looper);
            this.cs = false;
        }

        public void a(int i, Runnable runnable) {
            if (this.cs) {
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.obj = runnable;
            sendMessage(obtain);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1002) {
                this.cs = true;
            }
            Runnable runnable = (Runnable) message.obj;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* renamed from: com.baidu.ar.anime.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0050b {
        void a(int i, String str, long j);
    }

    public b(InterfaceC0050b interfaceC0050b) {
        this.ch = null;
        this.ch = interfaceC0050b;
        if (this.ci == null) {
            this.ci = new HandlerThread("AnimeHandlerThread");
            this.ci.start();
        }
        if (this.cj == null) {
            this.cj = new a(this.ci.getLooper());
        }
    }

    private long a(ArrayList<byte[]> arrayList) {
        long j = 0;
        if (this.cf != null && arrayList != null && arrayList.size() > 0 && this.bU != null) {
            if (arrayList.size() < 2) {
                com.baidu.ar.f.b.aK("result List size < 2!");
            } else {
                j = this.bU.createHandle();
                this.bU.setHandleInput(j, 21, this.cf.getTimestamp(), 4, this.cf.getWidth(), this.cf.getHeight(), this.cf.isFrontCamera(), this.cf.getSegOrientation().getValue(), false, this.cf.getPixelsAddress());
                ReserveHandleData reserveHandleData = new ReserveHandleData();
                reserveHandleData.setByteDataSize(arrayList.size());
                int width = this.cf.getWidth();
                int height = this.cf.getHeight() / 2;
                reserveHandleData.setByteWidths(new int[]{width, width});
                reserveHandleData.setByteHeights(new int[]{height, height});
                reserveHandleData.setByteFormats(new int[]{2, 2});
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < arrayList.size(); i++) {
                    arrayList2.add(arrayList.get(i));
                }
                reserveHandleData.setByteArrayListData(arrayList2);
                AlgoHandleAdapter.setHandleReserveData(j, reserveHandleData);
            }
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, ArrayList<byte[]> arrayList) {
        if (this.ch == null) {
            com.baidu.ar.f.b.aK("mRequestCallback is null!");
        } else if (i != 201 && !this.ck) {
            com.baidu.ar.f.b.aK("task cancel, not process errorCode:" + i);
            this.ch.a(201, "cancel ability", 0L);
        } else {
            long a2 = a(arrayList);
            if (i != 200 || a2 > 0) {
                this.ch.a(i, str, a2);
            } else {
                this.ch.a(203, "result invalid", a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(IHttpResponse iHttpResponse, String str) {
        if (!this.ck) {
            a(201, "cancel ability", (ArrayList<byte[]>) null);
        } else if (t(str)) {
        } else {
            try {
                String content = iHttpResponse.getContent();
                com.baidu.ar.f.b.aK("response.getContent():" + content);
                if (TextUtils.isEmpty(content)) {
                    a(203, "response json error", (ArrayList<byte[]>) null);
                } else {
                    JSONObject jSONObject = new JSONObject(content);
                    int optInt = jSONObject.optInt("err_no", -1);
                    String optString = jSONObject.optString("err_msg", null);
                    String optString2 = jSONObject.optString("result", null);
                    if (optInt != 0) {
                        a(203, "service error, errorNum:" + optInt + " errorMsg:" + optString, (ArrayList<byte[]>) null);
                    } else if (!t(str)) {
                        ArrayList<byte[]> u = u(optString2);
                        if (!t(str)) {
                            a(200, "success", u);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                com.baidu.ar.f.b.aK("processResponse Exception:" + e.getMessage());
                a(203, "Exception:" + e.getMessage(), (ArrayList<byte[]>) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.ar.ihttp.a aVar, byte[] bArr, int i) {
        String fr = q.fr();
        try {
            String encodeToString = Base64.encodeToString(bArr, 0);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type_name", i == 0 ? "selfie2anime_quanmin" : "selfie2anime_quanmin_rand");
            jSONObject.put("image", encodeToString);
            HttpFactory.newRequest().setUrl(fr).setReadTimeout(10000).addHeader("Content-Type:text/plain").setMethod("POST").setBody(jSONObject.toString()).enqueue(aVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t(String str) {
        if (this.cl == null || this.cl.size() <= 0 || !this.cl.contains(str)) {
            com.baidu.ar.f.b.aK("checkCancelStatus mTaskTimeStampList:" + this.cl);
            return true;
        }
        return false;
    }

    private ArrayList<byte[]> u(String str) {
        ArrayList<byte[]> arrayList = new ArrayList<>();
        String str2 = new String(Base64.decode(str, 0), "UTF-8");
        com.baidu.ar.f.b.aK("result:" + str2);
        JSONObject jSONObject = new JSONObject(str2);
        String optString = jSONObject.optString("anime", null);
        String optString2 = jSONObject.optString("selfie", null);
        long currentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(optString2)) {
            byte[] decode = Base64.decode(optString2, 0);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
            if (decodeByteArray != null) {
                byte[] c = h.c(decodeByteArray);
                decodeByteArray.recycle();
                arrayList.add(c);
            }
        }
        if (!TextUtils.isEmpty(optString)) {
            byte[] decode2 = Base64.decode(optString, 0);
            Bitmap decodeByteArray2 = BitmapFactory.decodeByteArray(decode2, 0, decode2.length);
            if (decodeByteArray2 != null) {
                byte[] c2 = h.c(decodeByteArray2);
                decodeByteArray2.recycle();
                arrayList.add(c2);
            }
        }
        com.baidu.ar.f.b.aK("decodeByteArray and getRgbaFromBitmap cost:" + (System.currentTimeMillis() - currentTimeMillis));
        return arrayList;
    }

    public void a(AlgoHandleController algoHandleController) {
        this.bU = algoHandleController;
    }

    public void aa() {
        if (this.cg == null || this.cf == null) {
            com.baidu.ar.f.b.aK("retryChangeStyle input data error!");
            if (this.ch != null) {
                this.ch.a(203, "retryChangeStyle input data error", 0L);
                return;
            }
            return;
        }
        final String str = String.valueOf(this.cf.getTimestamp()) + String.valueOf(System.currentTimeMillis());
        if (this.cl != null) {
            this.cl.add(str);
            if (this.ci == null || !this.ci.isAlive() || this.cj == null) {
                return;
            }
            this.cj.a(1001, new Runnable() { // from class: com.baidu.ar.anime.b.2
                @Override // java.lang.Runnable
                public void run() {
                    final long currentTimeMillis = System.currentTimeMillis();
                    b.this.a(new com.baidu.ar.ihttp.a() { // from class: com.baidu.ar.anime.b.2.1
                        @Override // com.baidu.ar.ihttp.a
                        public void a(HttpException httpException) {
                            b.this.a(202, httpException.getCode() + "/" + httpException.getMessage(), (ArrayList<byte[]>) null);
                        }

                        @Override // com.baidu.ar.ihttp.a
                        public void a(IHttpResponse iHttpResponse) {
                            com.baidu.ar.f.b.aK("request selfie2anime_quanmin_rand cost: " + (System.currentTimeMillis() - currentTimeMillis));
                            b.this.a(iHttpResponse, str);
                        }
                    }, b.this.cg, 1);
                }
            });
        }
    }

    public void ab() {
        if (this.cl != null) {
            this.cl.clear();
        }
        if (this.cj != null) {
            this.cj.removeMessages(1001);
        }
    }

    public void d(final FramePixels framePixels) {
        if (this.ci == null || !this.ci.isAlive() || this.cj == null) {
            return;
        }
        final String valueOf = String.valueOf(framePixels.getTimestamp());
        if (this.cl == null) {
            return;
        }
        this.cl.add(valueOf);
        this.cj.a(1001, new Runnable() { // from class: com.baidu.ar.anime.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.cf = framePixels;
                if (framePixels == null || framePixels.getPixelsAddress() == null) {
                    com.baidu.ar.f.b.aK("framePixels data error!");
                    return;
                }
                byte[] pixelData = framePixels.getPixelData();
                long currentTimeMillis = System.currentTimeMillis();
                Bitmap a2 = h.a(framePixels.getWidth(), framePixels.getHeight(), pixelData);
                byte[] a3 = h.a(a2, 50);
                a2.recycle();
                b.this.cg = a3;
                com.baidu.ar.f.b.aK("rgba2Bitmap and bitmap2Bytes cost:" + (System.currentTimeMillis() - currentTimeMillis));
                if (b.this.t(valueOf)) {
                    return;
                }
                final long currentTimeMillis2 = System.currentTimeMillis();
                b.this.a(new com.baidu.ar.ihttp.a() { // from class: com.baidu.ar.anime.b.1.1
                    @Override // com.baidu.ar.ihttp.a
                    public void a(HttpException httpException) {
                        b.this.a(202, httpException.getCode() + "/" + httpException.getMessage(), (ArrayList<byte[]>) null);
                    }

                    @Override // com.baidu.ar.ihttp.a
                    public void a(IHttpResponse iHttpResponse) {
                        com.baidu.ar.f.b.aK("request selfie2anime_quanmin cost: " + (System.currentTimeMillis() - currentTimeMillis2));
                        b.this.a(iHttpResponse, valueOf);
                    }
                }, a3, 0);
            }
        });
    }

    public void release() {
        this.ck = false;
        this.ch = null;
        if (this.cl != null) {
            this.cl.clear();
            this.cl = null;
        }
        if (this.ci == null || !this.ci.isAlive() || this.cj == null) {
            return;
        }
        this.cj.removeMessages(1001);
        this.cj.a(1002, new Runnable() { // from class: com.baidu.ar.anime.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.cj != null) {
                    b.this.cj = null;
                }
                if (b.this.ci != null) {
                    b.this.ci.quit();
                    b.this.ci = null;
                }
            }
        });
    }
}
