package com.baidu.ar.anime;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.anime.a;
import com.baidu.ar.anime.b;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arrender.l;
import com.baidu.ar.c;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.ar.databasic.AlgoHandleController;
import com.baidu.ar.databasic.ReserveHandleData;
import com.baidu.ar.h.e;
import com.baidu.ar.h.j;
import com.baidu.ar.h.p;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes9.dex */
public class AnimeAR extends c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "AnimeAR";
    public transient /* synthetic */ FieldHolder $fh;
    public String bD;
    public AlgoHandleController cb;
    public LuaMsgListener cc;
    public b cd;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1393694495, "Lcom/baidu/ar/anime/AnimeAR;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1393694495, "Lcom/baidu/ar/anime/AnimeAR;");
        }
    }

    public AnimeAR() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.bD = null;
        this.cb = null;
        this.cd = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FramePixels framePixels) {
        AlgoHandleController algoHandleController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, framePixels) == null) || framePixels == null || (algoHandleController = this.cb) == null) {
            return;
        }
        long createHandle = algoHandleController.createHandle();
        this.cb.setHandleInput(createHandle, 21, framePixels.getTimestamp(), 4, framePixels.getWidth(), framePixels.getHeight(), framePixels.isFrontCamera(), framePixels.getSegOrientation().getValue(), false, null);
        byte[] pixelData = framePixels.getPixelData();
        ReserveHandleData reserveHandleData = new ReserveHandleData();
        reserveHandleData.setByteDataSize(1);
        reserveHandleData.setByteWidths(new int[]{framePixels.getWidth()});
        reserveHandleData.setByteHeights(new int[]{framePixels.getHeight()});
        if (p.A(getContext())) {
            pixelData = j.b(e.a(j.a(framePixels.getWidth(), framePixels.getHeight(), pixelData), -90));
            reserveHandleData.setByteWidths(new int[]{framePixels.getHeight()});
            reserveHandleData.setByteHeights(new int[]{framePixels.getWidth()});
        }
        reserveHandleData.setByteFormats(new int[]{2});
        ArrayList arrayList = new ArrayList();
        arrayList.add(pixelData);
        reserveHandleData.setByteArrayListData(arrayList);
        AlgoHandleAdapter.setHandleReserveData(createHandle, reserveHandleData);
        l r = r();
        if (r == null || createHandle <= 0) {
            return;
        }
        String str = TAG;
        com.baidu.ar.h.b.b(str, "origin image setAlgoHandleData:" + createHandle);
        r.a(createHandle, this.bD);
        a(createHandle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{str, Boolean.valueOf(z), str2}) == null) {
            a aVar = new a();
            if (TextUtils.isEmpty(str2) && p.A(getContext())) {
                aVar.an();
            }
            aVar.a(new a.InterfaceC1740a(this, z, str2, aVar) { // from class: com.baidu.ar.anime.AnimeAR.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AnimeAR ce;
                public final /* synthetic */ boolean cf;
                public final /* synthetic */ String cg;
                public final /* synthetic */ a ch;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z), str2, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.ce = this;
                    this.cf = z;
                    this.cg = str2;
                    this.ch = aVar;
                }

                @Override // com.baidu.ar.anime.a.InterfaceC1740a
                public void b(FramePixels framePixels) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, framePixels) == null) {
                        this.ce.a(framePixels);
                        if (this.cf && this.ce.cd != null) {
                            com.baidu.ar.h.b.b(AnimeAR.TAG, "onFramePixelRead and mRequestController.request");
                            this.ce.cd.a(framePixels, this.cg);
                        }
                        new Thread(new Runnable(this) { // from class: com.baidu.ar.anime.AnimeAR.3.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass3 ci;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.ci = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    AnonymousClass3 anonymousClass3 = this.ci;
                                    anonymousClass3.ce.a(anonymousClass3.ch);
                                }
                            }
                        }).start();
                    }
                }
            });
            aVar.v(str);
            a(aVar, new com.baidu.ar.d.e(this) { // from class: com.baidu.ar.anime.AnimeAR.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AnimeAR ce;

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
                    this.ce = this;
                }

                @Override // com.baidu.ar.d.e
                public void a(com.baidu.ar.d.b bVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                    }
                }

                @Override // com.baidu.ar.d.e
                public void a(com.baidu.ar.d.l lVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
                    }
                }

                @Override // com.baidu.ar.d.e
                public void b(com.baidu.ar.d.l lVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
                    }
                }
            });
        }
    }

    private void al() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            if (this.cc == null) {
                this.cc = new LuaMsgListener(this) { // from class: com.baidu.ar.anime.AnimeAR.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AnimeAR ce;

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
                        this.ce = this;
                    }

                    @Override // com.baidu.ar.lua.LuaMsgListener
                    public List<String> getMsgKeyListened() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add("event_name");
                            return arrayList;
                        }
                        return (List) invokeV.objValue;
                    }

                    @Override // com.baidu.ar.lua.LuaMsgListener
                    public void onLuaMessage(HashMap<String, Object> hashMap) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) {
                            String str = (String) hashMap.get("event_name");
                            String str2 = (String) hashMap.get("type_name");
                            if ("get_pixel_frame".equals(str)) {
                                String str3 = (String) hashMap.get("filter_id");
                                String str4 = (String) hashMap.get("frame_type");
                                com.baidu.ar.h.b.aS("event_name: " + str + ", filterId: " + str3 + ", frameType:" + str4 + "type_name: " + str2);
                                boolean z = true;
                                if ("get_frame_only".equals(str4)) {
                                    z = false;
                                } else {
                                    "get_frame_and_request".equals(str4);
                                }
                                this.ce.a(str3, z, str2);
                            }
                            if ("retry_anime_effect".equals(str)) {
                                com.baidu.ar.h.b.aS("event_name: " + str + " and mRequestController.retryChangeStyle()");
                                if (this.ce.cd != null) {
                                    this.ce.cd.w(str2);
                                }
                            }
                            if ("cancel_anime_request".equals(str)) {
                                com.baidu.ar.h.b.aS("event_name: " + str + " and mRequestController.cancelAllRequest()");
                                if (this.ce.cd != null) {
                                    this.ce.cd.ar();
                                }
                            }
                        }
                    }
                };
            }
            a(this.cc);
        }
    }

    @Override // com.baidu.ar.c
    public void a(long j2) {
        AlgoHandleController algoHandleController;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            super.a(j2);
            if (j2 <= 0 || (algoHandleController = this.cb) == null || algoHandleController.getHandleType(j2) != 21) {
                return;
            }
            String str = TAG;
            com.baidu.ar.h.b.b(str, "destroyHandle:" + j2);
            this.cb.destroyHandle(j2);
        }
    }

    @Override // com.baidu.ar.c
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b(this.cc);
            b bVar = this.cd;
            if (bVar != null) {
                bVar.release();
                this.cd = null;
            }
            AlgoHandleController algoHandleController = this.cb;
            if (algoHandleController != null) {
                algoHandleController.release();
                this.cb = null;
            }
            l r = r();
            if (r != null) {
                r.q(21);
            }
            super.release();
        }
    }

    @Override // com.baidu.ar.c
    public void setup(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap) == null) {
            super.setup(hashMap);
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("setup(luaParams):");
            sb.append(hashMap != null ? hashMap.toString() : null);
            com.baidu.ar.h.b.k(str, sb.toString());
            if (this.cb == null) {
                this.cb = new AlgoHandleController();
            }
            if (hashMap != null) {
                this.bD = com.baidu.ar.arplay.c.c.a(hashMap.get("ability_name"), (String) null);
            }
            if (TextUtils.isEmpty(this.bD) || !"ability_anime".equals(this.bD)) {
                String str2 = TAG;
                com.baidu.ar.h.b.b(str2, "mAbilityName error: " + this.bD);
            }
            if (this.cd == null) {
                b bVar = new b(new b.InterfaceC1742b(this) { // from class: com.baidu.ar.anime.AnimeAR.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AnimeAR ce;

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
                        this.ce = this;
                    }

                    @Override // com.baidu.ar.anime.b.InterfaceC1742b
                    public void a(int i2, String str3, long j2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str3, Long.valueOf(j2)}) == null) {
                            if (i2 == 200) {
                                l r = this.ce.r();
                                if (r == null || j2 <= 0) {
                                    return;
                                }
                                String str4 = AnimeAR.TAG;
                                com.baidu.ar.h.b.b(str4, "result setAlgoHandleData:" + j2);
                                r.a(j2, this.ce.bD);
                                this.ce.a(j2);
                                return;
                            }
                            String str5 = AnimeAR.TAG;
                            com.baidu.ar.h.b.b(str5, "request error! code:" + i2 + " msg:" + str3);
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("event_name", "anime_network_status");
                            hashMap2.put("error_code", Integer.valueOf(i2));
                            hashMap2.put(GameCodeGetResponseMsg.PARAM_ERROR_MSG, str3);
                            this.ce.d(hashMap2);
                        }
                    }
                });
                this.cd = bVar;
                bVar.a(this.cb);
                this.cd.f(p.A(getContext()));
            }
            al();
            l r = r();
            if (r != null) {
                r.b(21, false);
            }
        }
    }
}
