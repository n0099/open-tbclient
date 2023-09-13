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
import com.baidu.searchbox.pms.constants.PmsConstant;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public InterfaceC0049b cp;
    public HandlerThread cq;
    public a cr;
    public boolean ct;

    /* renamed from: cn  reason: collision with root package name */
    public FramePixels f1032cn = null;
    public byte[] co = null;
    public boolean cs = true;
    public AlgoHandleController cb = null;
    public ArrayList<String> cu = new ArrayList<>();
    public boolean cv = true;

    /* loaded from: classes.dex */
    public static final class a extends Handler {
        public boolean cC;

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
    /* loaded from: classes.dex */
    public interface InterfaceC0049b {
        void a(int i, String str, long j);
    }

    public b(InterfaceC0049b interfaceC0049b) {
        this.cp = null;
        this.cp = interfaceC0049b;
        if (this.cq == null) {
            HandlerThread handlerThread = new HandlerThread("AnimeHandlerThread");
            this.cq = handlerThread;
            handlerThread.start();
        }
        if (this.cr == null) {
            this.cr = new a(this.cq.getLooper());
        }
    }

    private long a(ArrayList<byte[]> arrayList) {
        if (this.f1032cn == null || arrayList == null || arrayList.size() <= 0 || this.cb == null) {
            return 0L;
        }
        if (arrayList.size() < 2) {
            com.baidu.ar.h.b.aS("result List size < 2!");
            return 0L;
        }
        long createHandle = this.cb.createHandle();
        this.cb.setHandleInput(createHandle, 21, this.f1032cn.getTimestamp(), 4, this.f1032cn.getWidth(), this.f1032cn.getHeight(), this.f1032cn.isFrontCamera(), this.f1032cn.getSegOrientation().getValue(), false, this.f1032cn.getPixelsAddress());
        ReserveHandleData reserveHandleData = new ReserveHandleData();
        reserveHandleData.setByteDataSize(arrayList.size());
        int width = this.f1032cn.getWidth();
        int height = this.f1032cn.getHeight();
        if (this.cv) {
            height = this.f1032cn.getHeight() / 2;
        }
        if (this.ct) {
            width = this.f1032cn.getHeight();
            height = this.f1032cn.getWidth() / 2;
        }
        reserveHandleData.setByteWidths(new int[]{width, width});
        reserveHandleData.setByteHeights(new int[]{height, height});
        reserveHandleData.setByteFormats(new int[]{2, 2});
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(arrayList.get(i));
        }
        reserveHandleData.setByteArrayListData(arrayList2);
        AlgoHandleAdapter.setHandleReserveData(createHandle, reserveHandleData);
        return createHandle;
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
                    return;
                }
                JSONObject jSONObject = new JSONObject(content);
                int optInt = jSONObject.optInt("err_no", -1);
                String optString = jSONObject.optString(PmsConstant.Statistic.STATISTIC_ERRMSG, null);
                String optString2 = jSONObject.optString("result", null);
                if (optInt != 0) {
                    a(203, "service error, errorNum:" + optInt + " errorMsg:" + optString, (ArrayList<byte[]>) null);
                } else if (x(str)) {
                } else {
                    ArrayList<byte[]> y = y(optString2);
                    if (x(str)) {
                        return;
                    }
                    a(200, "success", y);
                    StatisticApi.onEvent(StatisticConstants.EVENT_FACE2ANIME_CASEUSE);
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
        String gW = s.gW();
        try {
            String encodeToString = Base64.encodeToString(bArr, 0);
            JSONObject jSONObject = new JSONObject();
            if (TextUtils.isEmpty(str)) {
                this.cv = true;
                str = i == 0 ? "selfie2anime_quanmin" : "selfie2anime_quanmin_rand";
                if (this.ct) {
                    str = i == 0 ? "selfie2anime" : "selfie2anime_rand";
                }
            } else {
                this.cv = false;
            }
            jSONObject.put("type_name", str);
            jSONObject.put("image", encodeToString);
            HttpFactory.newRequest().setUrl(gW).setReadTimeout(10000).addHeader("Content-Type:text/plain").setMethod("POST").setBody(jSONObject.toString()).enqueue(aVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x(String str) {
        ArrayList<String> arrayList = this.cu;
        if (arrayList == null || arrayList.size() <= 0 || !this.cu.contains(str)) {
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
        HandlerThread handlerThread = this.cq;
        if (handlerThread == null || !handlerThread.isAlive() || this.cr == null) {
            return;
        }
        final String valueOf = String.valueOf(framePixels.getTimestamp());
        ArrayList<String> arrayList = this.cu;
        if (arrayList == null) {
            return;
        }
        arrayList.add(valueOf);
        this.cr.a(1001, new Runnable() { // from class: com.baidu.ar.anime.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.f1032cn = framePixels;
                FramePixels framePixels2 = framePixels;
                if (framePixels2 == null || framePixels2.getPixelsAddress() == null) {
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
                        b bVar = b.this;
                        bVar.a(202, httpException.getCode() + "/" + httpException.getMessage(), (ArrayList<byte[]>) null);
                    }

                    @Override // com.baidu.ar.ihttp.a
                    public void a(IHttpResponse iHttpResponse) {
                        com.baidu.ar.h.b.aS("request selfie2anime_quanmin cost: " + (System.currentTimeMillis() - currentTimeMillis2));
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
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
        ArrayList<String> arrayList = this.cu;
        if (arrayList != null) {
            arrayList.clear();
        }
        a aVar = this.cr;
        if (aVar != null) {
            aVar.removeMessages(1001);
        }
    }

    public void f(boolean z) {
        this.ct = z;
    }

    public void release() {
        a aVar;
        this.cs = false;
        this.cp = null;
        ArrayList<String> arrayList = this.cu;
        if (arrayList != null) {
            arrayList.clear();
            this.cu = null;
        }
        HandlerThread handlerThread = this.cq;
        if (handlerThread == null || !handlerThread.isAlive() || (aVar = this.cr) == null) {
            return;
        }
        aVar.removeMessages(1001);
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
        a aVar;
        if (this.co == null || this.f1032cn == null) {
            com.baidu.ar.h.b.aS("retryChangeStyle input data error!");
            InterfaceC0049b interfaceC0049b = this.cp;
            if (interfaceC0049b != null) {
                interfaceC0049b.a(203, "retryChangeStyle input data error", 0L);
                return;
            }
            return;
        }
        final String str2 = String.valueOf(this.f1032cn.getTimestamp()) + String.valueOf(System.currentTimeMillis());
        ArrayList<String> arrayList = this.cu;
        if (arrayList == null) {
            return;
        }
        arrayList.add(str2);
        HandlerThread handlerThread = this.cq;
        if (handlerThread == null || !handlerThread.isAlive() || (aVar = this.cr) == null) {
            return;
        }
        aVar.a(1001, new Runnable() { // from class: com.baidu.ar.anime.b.2
            @Override // java.lang.Runnable
            public void run() {
                final long currentTimeMillis = System.currentTimeMillis();
                b.this.a(new com.baidu.ar.ihttp.a() { // from class: com.baidu.ar.anime.b.2.1
                    @Override // com.baidu.ar.ihttp.a
                    public void a(HttpException httpException) {
                        b bVar = b.this;
                        bVar.a(202, httpException.getCode() + "/" + httpException.getMessage(), (ArrayList<byte[]>) null);
                    }

                    @Override // com.baidu.ar.ihttp.a
                    public void a(IHttpResponse iHttpResponse) {
                        com.baidu.ar.h.b.aS("request selfie2anime_quanmin_rand cost: " + (System.currentTimeMillis() - currentTimeMillis));
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        b.this.a(iHttpResponse, str2);
                    }
                }, b.this.co, 1, str);
            }
        });
    }
}
