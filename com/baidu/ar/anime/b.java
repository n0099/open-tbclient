package com.baidu.ar.anime;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlgoHandleController cb;

    /* renamed from: cn  reason: collision with root package name */
    public FramePixels f31450cn;
    public byte[] co;
    public InterfaceC1745b cp;
    public HandlerThread cq;
    public a cr;
    public boolean cs;
    public boolean ct;
    public ArrayList<String> cu;
    public boolean cv;

    /* loaded from: classes3.dex */
    public static final class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean cC;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.cC = false;
        }

        public void a(int i2, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, runnable) == null) || this.cC) {
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = i2;
            obtain.obj = runnable;
            sendMessage(obtain);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
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
    }

    /* renamed from: com.baidu.ar.anime.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1745b {
        void a(int i2, String str, long j2);
    }

    public b(InterfaceC1745b interfaceC1745b) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {interfaceC1745b};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31450cn = null;
        this.co = null;
        this.cp = null;
        this.cs = true;
        this.cb = null;
        this.cu = new ArrayList<>();
        this.cv = true;
        this.cp = interfaceC1745b;
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
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, arrayList)) == null) {
            if (this.f31450cn == null || arrayList == null || arrayList.size() <= 0 || this.cb == null) {
                return 0L;
            }
            if (arrayList.size() < 2) {
                com.baidu.ar.h.b.aS("result List size < 2!");
                return 0L;
            }
            long createHandle = this.cb.createHandle();
            this.cb.setHandleInput(createHandle, 21, this.f31450cn.getTimestamp(), 4, this.f31450cn.getWidth(), this.f31450cn.getHeight(), this.f31450cn.isFrontCamera(), this.f31450cn.getSegOrientation().getValue(), false, this.f31450cn.getPixelsAddress());
            ReserveHandleData reserveHandleData = new ReserveHandleData();
            reserveHandleData.setByteDataSize(arrayList.size());
            int width = this.f31450cn.getWidth();
            int height = this.f31450cn.getHeight();
            if (this.cv) {
                height = this.f31450cn.getHeight() / 2;
            }
            if (this.ct) {
                width = this.f31450cn.getHeight();
                height = this.f31450cn.getWidth() / 2;
            }
            reserveHandleData.setByteWidths(new int[]{width, width});
            reserveHandleData.setByteHeights(new int[]{height, height});
            reserveHandleData.setByteFormats(new int[]{2, 2});
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                arrayList2.add(arrayList.get(i2));
            }
            reserveHandleData.setByteArrayListData(arrayList2);
            AlgoHandleAdapter.setHandleReserveData(createHandle, reserveHandleData);
            return createHandle;
        }
        return invokeL.longValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str, ArrayList<byte[]> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65541, this, i2, str, arrayList) == null) {
            if (this.cp == null) {
                com.baidu.ar.h.b.aS("mRequestCallback is null!");
            } else if (i2 != 201 && !this.cs) {
                com.baidu.ar.h.b.aS("task cancel, not process errorCode:" + i2);
                this.cp.a(201, "cancel ability", 0L);
            } else {
                long a2 = a(arrayList);
                if (i2 != 200 || a2 > 0) {
                    this.cp.a(i2, str, a2);
                } else {
                    this.cp.a(203, "result invalid", a2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(IHttpResponse iHttpResponse, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, this, iHttpResponse, str) == null) {
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
                } catch (Exception e2) {
                    e2.printStackTrace();
                    com.baidu.ar.h.b.aS("processResponse Exception:" + e2.getMessage());
                    a(203, "Exception:" + e2.getMessage(), (ArrayList<byte[]>) null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.ar.ihttp.a aVar, byte[] bArr, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65546, this, aVar, bArr, i2, str) == null) {
            String gW = s.gW();
            try {
                String encodeToString = Base64.encodeToString(bArr, 0);
                JSONObject jSONObject = new JSONObject();
                if (TextUtils.isEmpty(str)) {
                    this.cv = true;
                    str = i2 == 0 ? "selfie2anime_quanmin" : "selfie2anime_quanmin_rand";
                    if (this.ct) {
                        str = i2 == 0 ? "selfie2anime" : "selfie2anime_rand";
                    }
                } else {
                    this.cv = false;
                }
                jSONObject.put("type_name", str);
                jSONObject.put("image", encodeToString);
                HttpFactory.newRequest().setUrl(gW).setReadTimeout(10000).addHeader("Content-Type:text/plain").setMethod("POST").setBody(jSONObject.toString()).enqueue(aVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, this, str)) == null) {
            ArrayList<String> arrayList = this.cu;
            if (arrayList == null || arrayList.size() <= 0 || !this.cu.contains(str)) {
                com.baidu.ar.h.b.aS("checkCancelStatus mTaskTimeStampList:" + this.cu);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private ArrayList<byte[]> y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, this, str)) == null) {
            ArrayList<byte[]> arrayList = new ArrayList<>();
            String str2 = new String(Base64.decode(str, 0), "UTF-8");
            com.baidu.ar.h.b.aS("result:" + str2);
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString("anime", null);
            String optString2 = jSONObject.optString("selfie", null);
            long currentTimeMillis = System.currentTimeMillis();
            if (!TextUtils.isEmpty(optString2)) {
                byte[] decode = Base64.decode(optString2, 0);
                Bitmap b2 = this.ct ? e.b(e.a(BitmapFactory.decodeByteArray(decode, 0, decode.length), 90), 180) : BitmapFactory.decodeByteArray(decode, 0, decode.length);
                if (b2 != null) {
                    byte[] b3 = j.b(b2);
                    b2.recycle();
                    arrayList.add(b3);
                }
            }
            if (!TextUtils.isEmpty(optString)) {
                byte[] decode2 = Base64.decode(optString, 0);
                Bitmap b4 = this.ct ? e.b(e.a(BitmapFactory.decodeByteArray(decode2, 0, decode2.length), 90), 180) : BitmapFactory.decodeByteArray(decode2, 0, decode2.length);
                if (b4 != null) {
                    byte[] b5 = j.b(b4);
                    b4.recycle();
                    arrayList.add(b5);
                }
            }
            com.baidu.ar.h.b.aS("decodeByteArray and getRgbaFromBitmap cost:" + (System.currentTimeMillis() - currentTimeMillis));
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void a(FramePixels framePixels, String str) {
        HandlerThread handlerThread;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, framePixels, str) == null) || (handlerThread = this.cq) == null || !handlerThread.isAlive() || this.cr == null) {
            return;
        }
        String valueOf = String.valueOf(framePixels.getTimestamp());
        ArrayList<String> arrayList = this.cu;
        if (arrayList == null) {
            return;
        }
        arrayList.add(valueOf);
        this.cr.a(1001, new Runnable(this, framePixels, valueOf, str) { // from class: com.baidu.ar.anime.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String cg;
            public final /* synthetic */ FramePixels cw;
            public final /* synthetic */ String cx;
            public final /* synthetic */ b cy;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, framePixels, valueOf, str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.cy = this;
                this.cw = framePixels;
                this.cx = valueOf;
                this.cg = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.cy.f31450cn = this.cw;
                    FramePixels framePixels2 = this.cw;
                    if (framePixels2 == null || framePixels2.getPixelsAddress() == null) {
                        com.baidu.ar.h.b.aS("framePixels data error!");
                        return;
                    }
                    byte[] pixelData = this.cw.getPixelData();
                    long currentTimeMillis = System.currentTimeMillis();
                    Bitmap a2 = j.a(this.cw.getWidth(), this.cw.getHeight(), pixelData);
                    byte[] c2 = j.c(a2, 50);
                    a2.recycle();
                    this.cy.co = c2;
                    com.baidu.ar.h.b.aS("rgba2Bitmap and bitmap2Bytes cost:" + (System.currentTimeMillis() - currentTimeMillis));
                    if (this.cy.x(this.cx)) {
                        return;
                    }
                    this.cy.a(new com.baidu.ar.ihttp.a(this, System.currentTimeMillis()) { // from class: com.baidu.ar.anime.b.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass1 cA;
                        public final /* synthetic */ long cz;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Long.valueOf(r7)};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.cA = this;
                            this.cz = r7;
                        }

                        @Override // com.baidu.ar.ihttp.a
                        public void a(HttpException httpException) {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeL(1048576, this, httpException) == null) {
                                b bVar = this.cA.cy;
                                bVar.a(202, httpException.getCode() + "/" + httpException.getMessage(), (ArrayList<byte[]>) null);
                            }
                        }

                        @Override // com.baidu.ar.ihttp.a
                        public void a(IHttpResponse iHttpResponse) {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iHttpResponse) == null) {
                                com.baidu.ar.h.b.aS("request selfie2anime_quanmin cost: " + (System.currentTimeMillis() - this.cz));
                                AnonymousClass1 anonymousClass1 = this.cA;
                                anonymousClass1.cy.a(iHttpResponse, anonymousClass1.cx);
                            }
                        }
                    }, c2, 0, this.cg);
                }
            }
        });
    }

    public void a(AlgoHandleController algoHandleController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, algoHandleController) == null) {
            this.cb = algoHandleController;
        }
    }

    public void ar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ArrayList<String> arrayList = this.cu;
            if (arrayList != null) {
                arrayList.clear();
            }
            a aVar = this.cr;
            if (aVar != null) {
                aVar.removeMessages(1001);
            }
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.ct = z;
        }
    }

    public void release() {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
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
            this.cr.a(1002, new Runnable(this) { // from class: com.baidu.ar.anime.b.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b cy;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.cy = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.cy.cr != null) {
                            this.cy.cr = null;
                        }
                        if (this.cy.cq != null) {
                            this.cy.cq.quit();
                            this.cy.cq = null;
                        }
                    }
                }
            });
        }
    }

    public void w(String str) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (this.co == null || this.f31450cn == null) {
                com.baidu.ar.h.b.aS("retryChangeStyle input data error!");
                InterfaceC1745b interfaceC1745b = this.cp;
                if (interfaceC1745b != null) {
                    interfaceC1745b.a(203, "retryChangeStyle input data error", 0L);
                    return;
                }
                return;
            }
            String str2 = String.valueOf(this.f31450cn.getTimestamp()) + String.valueOf(System.currentTimeMillis());
            ArrayList<String> arrayList = this.cu;
            if (arrayList == null) {
                return;
            }
            arrayList.add(str2);
            HandlerThread handlerThread = this.cq;
            if (handlerThread == null || !handlerThread.isAlive() || (aVar = this.cr) == null) {
                return;
            }
            aVar.a(1001, new Runnable(this, str2, str) { // from class: com.baidu.ar.anime.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String cg;
                public final /* synthetic */ String cx;
                public final /* synthetic */ b cy;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str2, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.cy = this;
                    this.cx = str2;
                    this.cg = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.cy.a(new com.baidu.ar.ihttp.a(this, System.currentTimeMillis()) { // from class: com.baidu.ar.anime.b.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass2 cB;
                            public final /* synthetic */ long cz;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, Long.valueOf(r7)};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.cB = this;
                                this.cz = r7;
                            }

                            @Override // com.baidu.ar.ihttp.a
                            public void a(HttpException httpException) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, httpException) == null) {
                                    b bVar = this.cB.cy;
                                    bVar.a(202, httpException.getCode() + "/" + httpException.getMessage(), (ArrayList<byte[]>) null);
                                }
                            }

                            @Override // com.baidu.ar.ihttp.a
                            public void a(IHttpResponse iHttpResponse) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iHttpResponse) == null) {
                                    com.baidu.ar.h.b.aS("request selfie2anime_quanmin_rand cost: " + (System.currentTimeMillis() - this.cz));
                                    AnonymousClass2 anonymousClass2 = this.cB;
                                    anonymousClass2.cy.a(iHttpResponse, anonymousClass2.cx);
                                }
                            }
                        }, this.cy.co, 1, this.cg);
                    }
                }
            });
        }
    }
}
