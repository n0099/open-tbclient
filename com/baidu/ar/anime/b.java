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
import com.baidu.ar.g.e;
import com.baidu.ar.g.j;
import com.baidu.ar.g.s;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpResponse;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    private InterfaceC0072b cl;
    private HandlerThread cm;

    /* renamed from: cn  reason: collision with root package name */
    private a f956cn;
    private boolean cp;
    private FramePixels cj = null;
    private byte[] ck = null;
    private boolean co = true;
    private AlgoHandleController bY = null;
    private ArrayList<String> cq = new ArrayList<>();

    /* loaded from: classes10.dex */
    private static final class a extends Handler {
        private boolean cx;

        public a(Looper looper) {
            super(looper);
            this.cx = false;
        }

        public void a(int i, Runnable runnable) {
            if (this.cx) {
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
                this.cx = true;
            }
            Runnable runnable = (Runnable) message.obj;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* renamed from: com.baidu.ar.anime.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0072b {
        void a(int i, String str, long j);
    }

    public b(InterfaceC0072b interfaceC0072b) {
        this.cl = null;
        this.cl = interfaceC0072b;
        if (this.cm == null) {
            this.cm = new HandlerThread("AnimeHandlerThread");
            this.cm.start();
        }
        if (this.f956cn == null) {
            this.f956cn = new a(this.cm.getLooper());
        }
    }

    private long a(ArrayList<byte[]> arrayList) {
        long j = 0;
        if (this.cj != null && arrayList != null && arrayList.size() > 0 && this.bY != null) {
            if (arrayList.size() < 2) {
                com.baidu.ar.g.b.aP("result List size < 2!");
            } else {
                j = this.bY.createHandle();
                this.bY.setHandleInput(j, 21, this.cj.getTimestamp(), 4, this.cj.getWidth(), this.cj.getHeight(), this.cj.isFrontCamera(), this.cj.getSegOrientation().getValue(), false, this.cj.getPixelsAddress());
                ReserveHandleData reserveHandleData = new ReserveHandleData();
                reserveHandleData.setByteDataSize(arrayList.size());
                int width = this.cj.getWidth();
                int height = this.cj.getHeight() / 2;
                if (this.cp) {
                    width = this.cj.getHeight();
                    height = this.cj.getWidth() / 2;
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
        if (this.cl == null) {
            com.baidu.ar.g.b.aP("mRequestCallback is null!");
        } else if (i != 201 && !this.co) {
            com.baidu.ar.g.b.aP("task cancel, not process errorCode:" + i);
            this.cl.a(201, "cancel ability", 0L);
        } else {
            long a2 = a(arrayList);
            if (i != 200 || a2 > 0) {
                this.cl.a(i, str, a2);
            } else {
                this.cl.a(203, "result invalid", a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(IHttpResponse iHttpResponse, String str) {
        if (!this.co) {
            a(201, "cancel ability", (ArrayList<byte[]>) null);
        } else if (u(str)) {
        } else {
            try {
                String content = iHttpResponse.getContent();
                com.baidu.ar.g.b.aP("response.getContent():" + content);
                if (TextUtils.isEmpty(content)) {
                    a(203, "response json error", (ArrayList<byte[]>) null);
                } else {
                    JSONObject jSONObject = new JSONObject(content);
                    int optInt = jSONObject.optInt("err_no", -1);
                    String optString = jSONObject.optString("err_msg", null);
                    String optString2 = jSONObject.optString("result", null);
                    if (optInt != 0) {
                        a(203, "service error, errorNum:" + optInt + " errorMsg:" + optString, (ArrayList<byte[]>) null);
                    } else if (!u(str)) {
                        ArrayList<byte[]> v = v(optString2);
                        if (!u(str)) {
                            a(200, "success", v);
                            StatisticApi.onEvent(StatisticConstants.EVENT_FACE2ANIME_CASEUSE);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                com.baidu.ar.g.b.aP("processResponse Exception:" + e.getMessage());
                a(203, "Exception:" + e.getMessage(), (ArrayList<byte[]>) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.ar.ihttp.a aVar, byte[] bArr, int i) {
        String gW = s.gW();
        try {
            String encodeToString = Base64.encodeToString(bArr, 0);
            JSONObject jSONObject = new JSONObject();
            String str = i == 0 ? "selfie2anime_quanmin" : "selfie2anime_quanmin_rand";
            if (this.cp) {
                str = i == 0 ? "selfie2anime" : "selfie2anime_rand";
            }
            jSONObject.put("type_name", str);
            jSONObject.put("image", encodeToString);
            HttpFactory.newRequest().setUrl(gW).setReadTimeout(10000).addHeader("Content-Type:text/plain").setMethod("POST").setBody(jSONObject.toString()).enqueue(aVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u(String str) {
        if (this.cq == null || this.cq.size() <= 0 || !this.cq.contains(str)) {
            com.baidu.ar.g.b.aP("checkCancelStatus mTaskTimeStampList:" + this.cq);
            return true;
        }
        return false;
    }

    private ArrayList<byte[]> v(String str) {
        ArrayList<byte[]> arrayList = new ArrayList<>();
        String str2 = new String(Base64.decode(str, 0), "UTF-8");
        com.baidu.ar.g.b.aP("result:" + str2);
        JSONObject jSONObject = new JSONObject(str2);
        String optString = jSONObject.optString("anime", null);
        String optString2 = jSONObject.optString("selfie", null);
        long currentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(optString2)) {
            byte[] decode = Base64.decode(optString2, 0);
            Bitmap b = this.cp ? e.b(e.a(BitmapFactory.decodeByteArray(decode, 0, decode.length), 90), 180) : BitmapFactory.decodeByteArray(decode, 0, decode.length);
            if (b != null) {
                byte[] c = j.c(b);
                b.recycle();
                arrayList.add(c);
            }
        }
        if (!TextUtils.isEmpty(optString)) {
            byte[] decode2 = Base64.decode(optString, 0);
            Bitmap b2 = this.cp ? e.b(e.a(BitmapFactory.decodeByteArray(decode2, 0, decode2.length), 90), 180) : BitmapFactory.decodeByteArray(decode2, 0, decode2.length);
            if (b2 != null) {
                byte[] c2 = j.c(b2);
                b2.recycle();
                arrayList.add(c2);
            }
        }
        com.baidu.ar.g.b.aP("decodeByteArray and getRgbaFromBitmap cost:" + (System.currentTimeMillis() - currentTimeMillis));
        return arrayList;
    }

    public void a(AlgoHandleController algoHandleController) {
        this.bY = algoHandleController;
    }

    public void ap() {
        if (this.ck == null || this.cj == null) {
            com.baidu.ar.g.b.aP("retryChangeStyle input data error!");
            if (this.cl != null) {
                this.cl.a(203, "retryChangeStyle input data error", 0L);
                return;
            }
            return;
        }
        final String str = String.valueOf(this.cj.getTimestamp()) + String.valueOf(System.currentTimeMillis());
        if (this.cq != null) {
            this.cq.add(str);
            if (this.cm == null || !this.cm.isAlive() || this.f956cn == null) {
                return;
            }
            this.f956cn.a(1001, new Runnable() { // from class: com.baidu.ar.anime.b.2
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
                            com.baidu.ar.g.b.aP("request selfie2anime_quanmin_rand cost: " + (System.currentTimeMillis() - currentTimeMillis));
                            b.this.a(iHttpResponse, str);
                        }
                    }, b.this.ck, 1);
                }
            });
        }
    }

    public void aq() {
        if (this.cq != null) {
            this.cq.clear();
        }
        if (this.f956cn != null) {
            this.f956cn.removeMessages(1001);
        }
    }

    public void d(final FramePixels framePixels) {
        if (this.cm == null || !this.cm.isAlive() || this.f956cn == null) {
            return;
        }
        final String valueOf = String.valueOf(framePixels.getTimestamp());
        if (this.cq == null) {
            return;
        }
        this.cq.add(valueOf);
        this.f956cn.a(1001, new Runnable() { // from class: com.baidu.ar.anime.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.cj = framePixels;
                if (framePixels == null || framePixels.getPixelsAddress() == null) {
                    com.baidu.ar.g.b.aP("framePixels data error!");
                    return;
                }
                byte[] pixelData = framePixels.getPixelData();
                long currentTimeMillis = System.currentTimeMillis();
                Bitmap a2 = j.a(framePixels.getWidth(), framePixels.getHeight(), pixelData);
                byte[] c = j.c(a2, 50);
                a2.recycle();
                b.this.ck = c;
                com.baidu.ar.g.b.aP("rgba2Bitmap and bitmap2Bytes cost:" + (System.currentTimeMillis() - currentTimeMillis));
                if (b.this.u(valueOf)) {
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
                        com.baidu.ar.g.b.aP("request selfie2anime_quanmin cost: " + (System.currentTimeMillis() - currentTimeMillis2));
                        b.this.a(iHttpResponse, valueOf);
                    }
                }, c, 0);
            }
        });
    }

    public void f(boolean z) {
        this.cp = z;
    }

    public void release() {
        this.co = false;
        this.cl = null;
        if (this.cq != null) {
            this.cq.clear();
            this.cq = null;
        }
        if (this.cm == null || !this.cm.isAlive() || this.f956cn == null) {
            return;
        }
        this.f956cn.removeMessages(1001);
        this.f956cn.a(1002, new Runnable() { // from class: com.baidu.ar.anime.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f956cn != null) {
                    b.this.f956cn = null;
                }
                if (b.this.cm != null) {
                    b.this.cm.quit();
                    b.this.cm = null;
                }
            }
        });
    }
}
