package com.baidu.ar.anime;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.databasic.ReserveHandleData;
import com.baidu.ar.h.e;
import com.baidu.ar.h.j;
import com.baidu.ar.h.s;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpResponse;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    private InterfaceC0075b cp;
    private HandlerThread cq;
    private a cr;
    private boolean ct;

    /* renamed from: cn  reason: collision with root package name */
    private FramePixels f1189cn = null;
    private byte[] co = null;
    private boolean cs = true;
    private AlgoHandleController cb = null;
    private ArrayList<String> cu = new ArrayList<>();
    private boolean cv = true;

    /* loaded from: classes10.dex */
    private static final class a extends Handler {
        private boolean cC;

        public a(Looper looper) {
            super(looper);
            this.cC = false;
        }

        public void a(int i, Runnable runnable) {
            if (this.cC) {
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
                this.cC = true;
            }
            Runnable runnable = (Runnable) message.obj;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* renamed from: com.baidu.ar.anime.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0075b {
        void a(int i, String str, long j);
    }

    public b(InterfaceC0075b interfaceC0075b) {
        this.cp = null;
        this.cp = interfaceC0075b;
        if (this.cq == null) {
            this.cq = new HandlerThread("AnimeHandlerThread");
            this.cq.start();
        }
        if (this.cr == null) {
            this.cr = new a(this.cq.getLooper());
        }
    }

    private long a(ArrayList<byte[]> arrayList) {
        long j = 0;
        if (this.f1189cn != null && arrayList != null && arrayList.size() > 0 && this.cb != null) {
            if (arrayList.size() < 2) {
                com.baidu.ar.h.b.aS("result List size < 2!");
            } else {
                j = this.cb.createHandle();
                this.cb.setHandleInput(j, 21, this.f1189cn.getTimestamp(), 4, this.f1189cn.getWidth(), this.f1189cn.getHeight(), this.f1189cn.isFrontCamera(), this.f1189cn.getSegOrientation().getValue(), false, this.f1189cn.getPixelsAddress());
                ReserveHandleData reserveHandleData = new ReserveHandleData();
                reserveHandleData.setByteDataSize(arrayList.size());
                int width = this.f1189cn.getWidth();
                int height = this.f1189cn.getHeight();
                if (this.cv) {
                    height = this.f1189cn.getHeight() / 2;
                }
                if (this.ct) {
                    width = this.f1189cn.getHeight();
                    height = this.f1189cn.getWidth() / 2;
                }
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
        if (this.cp == null) {
            com.baidu.ar.h.b.aS("mRequestCallback is null!");
        } else if (i != 201 && !this.cs) {
            com.baidu.ar.h.b.aS("task cancel, not process errorCode:" + i);
            this.cp.a(201, "cancel ability", 0L);
        } else {
            long a2 = a(arrayList);
            if (i != 200 || a2 > 0) {
                this.cp.a(i, str, a2);
            } else {
                this.cp.a(203, "result invalid", a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(IHttpResponse iHttpResponse, String str) {
        if (!this.cs) {
            a(201, "cancel ability", (ArrayList<byte[]>) null);
        } else if (x(str)) {
        } else {
            try {
                String content = iHttpResponse.getContent();
                com.baidu.ar.h.b.aS("response.getContent():" + content);
                if (TextUtils.isEmpty(content)) {
                    a(203, "response json error", (ArrayList<byte[]>) null);
                } else {
                    JSONObject jSONObject = new JSONObject(content);
                    int optInt = jSONObject.optInt("err_no", -1);
                    String optString = jSONObject.optString("err_msg", null);
                    String optString2 = jSONObject.optString("result", null);
                    if (optInt != 0) {
                        a(203, "service error, errorNum:" + optInt + " errorMsg:" + optString, (ArrayList<byte[]>) null);
                    } else if (!x(str)) {
                        ArrayList<byte[]> y = y(optString2);
                        if (!x(str)) {
                            a(200, "success", y);
                            StatisticApi.onEvent(StatisticConstants.EVENT_FACE2ANIME_CASEUSE);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                com.baidu.ar.h.b.aS("processResponse Exception:" + e.getMessage());
                a(203, "Exception:" + e.getMessage(), (ArrayList<byte[]>) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.ar.ihttp.a aVar, byte[] bArr, int i, String str) {
        String str2;
        String gW = s.gW();
        try {
            String encodeToString = Base64.encodeToString(bArr, 0);
            JSONObject jSONObject = new JSONObject();
            if (TextUtils.isEmpty(str)) {
                this.cv = true;
                str2 = i == 0 ? "selfie2anime_quanmin" : "selfie2anime_quanmin_rand";
                if (this.ct) {
                    str2 = i == 0 ? "selfie2anime" : "selfie2anime_rand";
                }
            } else {
                this.cv = false;
                str2 = str;
            }
            jSONObject.put("type_name", str2);
            jSONObject.put("image", encodeToString);
            HttpFactory.newRequest().setUrl(gW).setReadTimeout(10000).addHeader("Content-Type:text/plain").setMethod("POST").setBody(jSONObject.toString()).enqueue(aVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x(String str) {
        if (this.cu == null || this.cu.size() <= 0 || !this.cu.contains(str)) {
            com.baidu.ar.h.b.aS("checkCancelStatus mTaskTimeStampList:" + this.cu);
            return true;
        }
        return false;
    }

    private ArrayList<byte[]> y(String str) {
        ArrayList<byte[]> arrayList = new ArrayList<>();
        String str2 = new String(Base64.decode(str, 0), "UTF-8");
        com.baidu.ar.h.b.aS("result:" + str2);
        JSONObject jSONObject = new JSONObject(str2);
        String optString = jSONObject.optString("anime", null);
        String optString2 = jSONObject.optString("selfie", null);
        long currentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(optString2)) {
            byte[] decode = Base64.decode(optString2, 0);
            Bitmap b = this.ct ? e.b(e.a(BitmapFactory.decodeByteArray(decode, 0, decode.length), 90), 180) : BitmapFactory.decodeByteArray(decode, 0, decode.length);
            if (b != null) {
                byte[] b2 = j.b(b);
                b.recycle();
                arrayList.add(b2);
            }
        }
        if (!TextUtils.isEmpty(optString)) {
            byte[] decode2 = Base64.decode(optString, 0);
            Bitmap b3 = this.ct ? e.b(e.a(BitmapFactory.decodeByteArray(decode2, 0, decode2.length), 90), 180) : BitmapFactory.decodeByteArray(decode2, 0, decode2.length);
            if (b3 != null) {
                byte[] b4 = j.b(b3);
                b3.recycle();
                arrayList.add(b4);
            }
        }
        com.baidu.ar.h.b.aS("decodeByteArray and getRgbaFromBitmap cost:" + (System.currentTimeMillis() - currentTimeMillis));
        return arrayList;
    }

    public void a(final FramePixels framePixels, final String str) {
        if (this.cq == null || !this.cq.isAlive() || this.cr == null) {
            return;
        }
        final String valueOf = String.valueOf(framePixels.getTimestamp());
        if (this.cu == null) {
            return;
        }
        this.cu.add(valueOf);
        this.cr.a(1001, new Runnable() { // from class: com.baidu.ar.anime.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.f1189cn = framePixels;
                if (framePixels == null || framePixels.getPixelsAddress() == null) {
                    com.baidu.ar.h.b.aS("framePixels data error!");
                    return;
                }
                byte[] pixelData = framePixels.getPixelData();
                long currentTimeMillis = System.currentTimeMillis();
                Bitmap a2 = j.a(framePixels.getWidth(), framePixels.getHeight(), pixelData);
                byte[] c = j.c(a2, 50);
                a2.recycle();
                b.this.co = c;
                com.baidu.ar.h.b.aS("rgba2Bitmap and bitmap2Bytes cost:" + (System.currentTimeMillis() - currentTimeMillis));
                if (b.this.x(valueOf)) {
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
                        com.baidu.ar.h.b.aS("request selfie2anime_quanmin cost: " + (System.currentTimeMillis() - currentTimeMillis2));
                        b.this.a(iHttpResponse, valueOf);
                    }
                }, c, 0, str);
            }
        });
    }

    public void a(AlgoHandleController algoHandleController) {
        this.cb = algoHandleController;
    }

    public void ar() {
        if (this.cu != null) {
            this.cu.clear();
        }
        if (this.cr != null) {
            this.cr.removeMessages(1001);
        }
    }

    public void f(boolean z) {
        this.ct = z;
    }

    public void release() {
        this.cs = false;
        this.cp = null;
        if (this.cu != null) {
            this.cu.clear();
            this.cu = null;
        }
        if (this.cq == null || !this.cq.isAlive() || this.cr == null) {
            return;
        }
        this.cr.removeMessages(1001);
        this.cr.a(1002, new Runnable() { // from class: com.baidu.ar.anime.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.cr != null) {
                    b.this.cr = null;
                }
                if (b.this.cq != null) {
                    b.this.cq.quit();
                    b.this.cq = null;
                }
            }
        });
    }

    public void w(final String str) {
        if (this.co == null || this.f1189cn == null) {
            com.baidu.ar.h.b.aS("retryChangeStyle input data error!");
            if (this.cp != null) {
                this.cp.a(203, "retryChangeStyle input data error", 0L);
                return;
            }
            return;
        }
        final String str2 = String.valueOf(this.f1189cn.getTimestamp()) + String.valueOf(System.currentTimeMillis());
        if (this.cu != null) {
            this.cu.add(str2);
            if (this.cq == null || !this.cq.isAlive() || this.cr == null) {
                return;
            }
            this.cr.a(1001, new Runnable() { // from class: com.baidu.ar.anime.b.2
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
                            com.baidu.ar.h.b.aS("request selfie2anime_quanmin_rand cost: " + (System.currentTimeMillis() - currentTimeMillis));
                            b.this.a(iHttpResponse, str2);
                        }
                    }, b.this.co, 1, str);
                }
            });
        }
    }
}
