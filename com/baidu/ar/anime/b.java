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
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    private InterfaceC0074b cu;
    private HandlerThread cv;
    private a cw;
    private FramePixels cs = null;
    private byte[] ct = null;
    private boolean cx = true;
    private AlgoHandleController ch = null;
    private ArrayList<String> cy = new ArrayList<>();

    /* loaded from: classes3.dex */
    private static final class a extends Handler {
        private boolean cF;

        public a(Looper looper) {
            super(looper);
            this.cF = false;
        }

        public void a(int i, Runnable runnable) {
            if (this.cF) {
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
                this.cF = true;
            }
            Runnable runnable = (Runnable) message.obj;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* renamed from: com.baidu.ar.anime.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0074b {
        void a(int i, String str, long j);
    }

    public b(InterfaceC0074b interfaceC0074b) {
        this.cu = null;
        this.cu = interfaceC0074b;
        if (this.cv == null) {
            this.cv = new HandlerThread("AnimeHandlerThread");
            this.cv.start();
        }
        if (this.cw == null) {
            this.cw = new a(this.cv.getLooper());
        }
    }

    private long a(ArrayList<byte[]> arrayList) {
        long j = 0;
        if (this.cs != null && arrayList != null && arrayList.size() > 0 && this.ch != null) {
            if (arrayList.size() < 2) {
                com.baidu.ar.f.b.aL("result List size < 2!");
            } else {
                j = this.ch.createHandle();
                this.ch.setHandleInput(j, 21, this.cs.getTimestamp(), 4, this.cs.getWidth(), this.cs.getHeight(), this.cs.isFrontCamera(), this.cs.getSegOrientation().getValue(), false, this.cs.getPixelsAddress());
                ReserveHandleData reserveHandleData = new ReserveHandleData();
                reserveHandleData.setByteDataSize(arrayList.size());
                int width = this.cs.getWidth();
                int height = this.cs.getHeight() / 2;
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
        if (this.cu == null) {
            com.baidu.ar.f.b.aL("mRequestCallback is null!");
        } else if (i != 201 && !this.cx) {
            com.baidu.ar.f.b.aL("task cancel, not process errorCode:" + i);
            this.cu.a(201, "cancel ability", 0L);
        } else {
            long a2 = a(arrayList);
            if (i != 200 || a2 > 0) {
                this.cu.a(i, str, a2);
            } else {
                this.cu.a(203, "result invalid", a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(IHttpResponse iHttpResponse, String str) {
        if (!this.cx) {
            a(201, "cancel ability", (ArrayList<byte[]>) null);
        } else if (t(str)) {
        } else {
            try {
                String content = iHttpResponse.getContent();
                com.baidu.ar.f.b.aL("response.getContent():" + content);
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
                            StatisticApi.onEvent(StatisticConstants.EVENT_FACE2ANIME_CASEUSE);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                com.baidu.ar.f.b.aL("processResponse Exception:" + e.getMessage());
                a(203, "Exception:" + e.getMessage(), (ArrayList<byte[]>) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.ar.ihttp.a aVar, byte[] bArr, int i) {
        String fH = q.fH();
        try {
            String encodeToString = Base64.encodeToString(bArr, 0);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type_name", i == 0 ? "selfie2anime_quanmin" : "selfie2anime_quanmin_rand");
            jSONObject.put("image", encodeToString);
            HttpFactory.newRequest().setUrl(fH).setReadTimeout(10000).addHeader("Content-Type:text/plain").setMethod("POST").setBody(jSONObject.toString()).enqueue(aVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t(String str) {
        if (this.cy == null || this.cy.size() <= 0 || !this.cy.contains(str)) {
            com.baidu.ar.f.b.aL("checkCancelStatus mTaskTimeStampList:" + this.cy);
            return true;
        }
        return false;
    }

    private ArrayList<byte[]> u(String str) {
        ArrayList<byte[]> arrayList = new ArrayList<>();
        String str2 = new String(Base64.decode(str, 0), "UTF-8");
        com.baidu.ar.f.b.aL("result:" + str2);
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
        com.baidu.ar.f.b.aL("decodeByteArray and getRgbaFromBitmap cost:" + (System.currentTimeMillis() - currentTimeMillis));
        return arrayList;
    }

    public void a(AlgoHandleController algoHandleController) {
        this.ch = algoHandleController;
    }

    public void ao() {
        if (this.ct == null || this.cs == null) {
            com.baidu.ar.f.b.aL("retryChangeStyle input data error!");
            if (this.cu != null) {
                this.cu.a(203, "retryChangeStyle input data error", 0L);
                return;
            }
            return;
        }
        final String str = String.valueOf(this.cs.getTimestamp()) + String.valueOf(System.currentTimeMillis());
        if (this.cy != null) {
            this.cy.add(str);
            if (this.cv == null || !this.cv.isAlive() || this.cw == null) {
                return;
            }
            this.cw.a(1001, new Runnable() { // from class: com.baidu.ar.anime.b.2
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
                            com.baidu.ar.f.b.aL("request selfie2anime_quanmin_rand cost: " + (System.currentTimeMillis() - currentTimeMillis));
                            b.this.a(iHttpResponse, str);
                        }
                    }, b.this.ct, 1);
                }
            });
        }
    }

    public void ap() {
        if (this.cy != null) {
            this.cy.clear();
        }
        if (this.cw != null) {
            this.cw.removeMessages(1001);
        }
    }

    public void d(final FramePixels framePixels) {
        if (this.cv == null || !this.cv.isAlive() || this.cw == null) {
            return;
        }
        final String valueOf = String.valueOf(framePixels.getTimestamp());
        if (this.cy == null) {
            return;
        }
        this.cy.add(valueOf);
        this.cw.a(1001, new Runnable() { // from class: com.baidu.ar.anime.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.cs = framePixels;
                if (framePixels == null || framePixels.getPixelsAddress() == null) {
                    com.baidu.ar.f.b.aL("framePixels data error!");
                    return;
                }
                byte[] pixelData = framePixels.getPixelData();
                long currentTimeMillis = System.currentTimeMillis();
                Bitmap a2 = h.a(framePixels.getWidth(), framePixels.getHeight(), pixelData);
                byte[] a3 = h.a(a2, 50);
                a2.recycle();
                b.this.ct = a3;
                com.baidu.ar.f.b.aL("rgba2Bitmap and bitmap2Bytes cost:" + (System.currentTimeMillis() - currentTimeMillis));
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
                        com.baidu.ar.f.b.aL("request selfie2anime_quanmin cost: " + (System.currentTimeMillis() - currentTimeMillis2));
                        b.this.a(iHttpResponse, valueOf);
                    }
                }, a3, 0);
            }
        });
    }

    public void release() {
        this.cx = false;
        this.cu = null;
        if (this.cy != null) {
            this.cy.clear();
            this.cy = null;
        }
        if (this.cv == null || !this.cv.isAlive() || this.cw == null) {
            return;
        }
        this.cw.removeMessages(1001);
        this.cw.a(1002, new Runnable() { // from class: com.baidu.ar.anime.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.cw != null) {
                    b.this.cw = null;
                }
                if (b.this.cv != null) {
                    b.this.cv.quit();
                    b.this.cv = null;
                }
            }
        });
    }
}
