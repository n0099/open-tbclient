package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Region;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.ICyberVideoView;
import com.baidu.cyberplayer.sdk.a;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.i;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.ErrorCode;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class CyberVideoView extends FrameLayout implements CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnMediaSourceChangedListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnSeekCompleteListener, CyberPlayerManager.OnVideoSizeChangedListener, ICyberVideoView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public float D;
    public long E;
    public boolean F;
    public String G;
    public String H;
    public i.a I;
    public Context a;
    public CyberPlayer b;
    public Uri c;
    public Map d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public HashMap l;
    public CyberPlayerManager.HttpDNS m;
    public CyberPlayerManager.OnPreparedListener n;
    public CyberPlayerManager.OnVideoSizeChangedListener o;
    public CyberPlayerManager.OnCompletionListener p;
    public CyberPlayerManager.OnSeekCompleteListener q;
    public CyberPlayerManager.OnBufferingUpdateListener r;
    public CyberPlayerManager.OnErrorListener s;
    public CyberPlayerManager.OnInfoListener t;
    public CyberPlayerManager.OnMediaSourceChangedListener u;
    public i v;
    public final int w;
    public a x;
    public ArrayList y;
    public int z;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CyberVideoView(Context context) {
        this(context, (AttributeSet) null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CyberVideoView(Context context, int i) {
        this(context, null, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CyberVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f = 3;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = new HashMap();
        this.z = 0;
        this.A = true;
        this.D = 1.0f;
        this.E = 0L;
        this.F = false;
        this.G = null;
        this.H = null;
        this.I = new i.a(this) { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CyberVideoView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeII(1048576, this, i3, i4) == null) || this.a.b == null) {
                    return;
                }
                try {
                    this.a.b.updateDisplaySize(i3, i4);
                } catch (Exception unused) {
                }
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(int i3, int i4, Buffer buffer) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, i4, buffer) == null) {
                    CyberTaskExcutor.getInstance().execute(new Runnable(this, buffer, i3, i4) { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ Buffer a;
                        public final /* synthetic */ int b;
                        public final /* synthetic */ int c;
                        public final /* synthetic */ AnonymousClass1 d;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr3 = {this, buffer, Integer.valueOf(i3), Integer.valueOf(i4)};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i5 = newInitContext2.flag;
                                if ((i5 & 1) != 0) {
                                    int i6 = i5 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.d = this;
                            this.a = buffer;
                            this.b = i3;
                            this.c = i4;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.a == null) {
                                return;
                            }
                            Bitmap createBitmap = Bitmap.createBitmap(this.b, this.c, Bitmap.Config.ARGB_8888);
                            createBitmap.copyPixelsFromBuffer(this.a);
                            Bitmap a = o.a(createBitmap);
                            CyberLog.d("CyberVideoView", "onTakeSnapShot rotate bmp finished");
                            synchronized (this.d.a.y) {
                                for (int i5 = 0; i5 < this.d.a.y.size(); i5++) {
                                    ((ICyberVideoView.OnSnapShotCompleteListener) this.d.a.y.get(i5)).onSnapShotComplete(a);
                                }
                                this.d.a.y.clear();
                            }
                        }
                    });
                }
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(long j) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable(this, j) { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ long a;
                        public final /* synthetic */ AnonymousClass1 b;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr3 = {this, Long.valueOf(j)};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i3 = newInitContext2.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.b = this;
                            this.a = j;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                if (Build.VERSION.SDK_INT <= 16 && this.b.a.b != null && this.b.a.b.getDecodeMode() == 4) {
                                    this.b.a.b.sendCommand(1002, 0, this.a, null);
                                }
                                if (this.b.a.b == null || this.b.a.E <= 0) {
                                    return;
                                }
                                long j2 = this.a - this.b.a.E;
                                HashMap hashMap = new HashMap();
                                hashMap.put("type", "20513");
                                hashMap.put("surface_drawed", "" + j2);
                                this.b.a.b.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
                            }
                        }
                    });
                }
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public boolean a(int i3) {
                InterceptResult invokeI;
                Surface d;
                Surface d2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(1048579, this, i3)) == null) {
                    CyberLog.d("CyberVideoView", "onSurfaceReady renderType:" + i3);
                    if (i3 == 0) {
                        if (Build.VERSION.SDK_INT < 16) {
                            if (this.a.b != null && this.a.v != null && (d2 = this.a.v.d()) != null) {
                                this.a.b.setSurface(d2);
                            }
                            return true;
                        }
                        return false;
                    }
                    if (i3 == 1) {
                        if (this.a.b == null || this.a.v == null) {
                            return false;
                        }
                        d = this.a.v.d();
                        CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d);
                        if (d == null) {
                            return false;
                        }
                    } else if (i3 != 2 || this.a.b == null || this.a.v == null) {
                        return false;
                    } else {
                        d = this.a.v.d();
                        CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d);
                        if (d == null) {
                            return false;
                        }
                        CyberLog.d("CyberVideoView", "onSurfaceReady mCyberPlayer:" + this.a.b);
                    }
                    this.a.b.setSurface(d);
                    return false;
                }
                return invokeI.booleanValue;
            }
        };
        this.w = 0;
        CyberLog.d("CyberVideoView", "CyberVideoView mRenderType:" + this.w);
        this.a = context.getApplicationContext();
        this.x = new a();
        this.y = new ArrayList();
        reset();
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CyberVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f = 3;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = new HashMap();
        this.z = 0;
        this.A = true;
        this.D = 1.0f;
        this.E = 0L;
        this.F = false;
        this.G = null;
        this.H = null;
        this.I = new i.a(this) { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CyberVideoView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr3;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i32 = newInitContext2.flag;
                    if ((i32 & 1) != 0) {
                        int i4 = i32 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(int i32, int i4) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeII(1048576, this, i32, i4) == null) || this.a.b == null) {
                    return;
                }
                try {
                    this.a.b.updateDisplaySize(i32, i4);
                } catch (Exception unused) {
                }
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(int i32, int i4, Buffer buffer) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i32, i4, buffer) == null) {
                    CyberTaskExcutor.getInstance().execute(new Runnable(this, buffer, i32, i4) { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ Buffer a;
                        public final /* synthetic */ int b;
                        public final /* synthetic */ int c;
                        public final /* synthetic */ AnonymousClass1 d;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = objArr3;
                                Object[] objArr3 = {this, buffer, Integer.valueOf(i32), Integer.valueOf(i4)};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i5 = newInitContext2.flag;
                                if ((i5 & 1) != 0) {
                                    int i6 = i5 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.d = this;
                            this.a = buffer;
                            this.b = i32;
                            this.c = i4;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.a == null) {
                                return;
                            }
                            Bitmap createBitmap = Bitmap.createBitmap(this.b, this.c, Bitmap.Config.ARGB_8888);
                            createBitmap.copyPixelsFromBuffer(this.a);
                            Bitmap a = o.a(createBitmap);
                            CyberLog.d("CyberVideoView", "onTakeSnapShot rotate bmp finished");
                            synchronized (this.d.a.y) {
                                for (int i5 = 0; i5 < this.d.a.y.size(); i5++) {
                                    ((ICyberVideoView.OnSnapShotCompleteListener) this.d.a.y.get(i5)).onSnapShotComplete(a);
                                }
                                this.d.a.y.clear();
                            }
                        }
                    });
                }
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(long j) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable(this, j) { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ long a;
                        public final /* synthetic */ AnonymousClass1 b;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = objArr3;
                                Object[] objArr3 = {this, Long.valueOf(j)};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i32 = newInitContext2.flag;
                                if ((i32 & 1) != 0) {
                                    int i4 = i32 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.b = this;
                            this.a = j;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                if (Build.VERSION.SDK_INT <= 16 && this.b.a.b != null && this.b.a.b.getDecodeMode() == 4) {
                                    this.b.a.b.sendCommand(1002, 0, this.a, null);
                                }
                                if (this.b.a.b == null || this.b.a.E <= 0) {
                                    return;
                                }
                                long j2 = this.a - this.b.a.E;
                                HashMap hashMap = new HashMap();
                                hashMap.put("type", "20513");
                                hashMap.put("surface_drawed", "" + j2);
                                this.b.a.b.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
                            }
                        }
                    });
                }
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public boolean a(int i32) {
                InterceptResult invokeI;
                Surface d;
                Surface d2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(1048579, this, i32)) == null) {
                    CyberLog.d("CyberVideoView", "onSurfaceReady renderType:" + i32);
                    if (i32 == 0) {
                        if (Build.VERSION.SDK_INT < 16) {
                            if (this.a.b != null && this.a.v != null && (d2 = this.a.v.d()) != null) {
                                this.a.b.setSurface(d2);
                            }
                            return true;
                        }
                        return false;
                    }
                    if (i32 == 1) {
                        if (this.a.b == null || this.a.v == null) {
                            return false;
                        }
                        d = this.a.v.d();
                        CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d);
                        if (d == null) {
                            return false;
                        }
                    } else if (i32 != 2 || this.a.b == null || this.a.v == null) {
                        return false;
                    } else {
                        d = this.a.v.d();
                        CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d);
                        if (d == null) {
                            return false;
                        }
                        CyberLog.d("CyberVideoView", "onSurfaceReady mCyberPlayer:" + this.a.b);
                    }
                    this.a.b.setSurface(d);
                    return false;
                }
                return invokeI.booleanValue;
            }
        };
        this.w = a(i);
        this.a = context.getApplicationContext();
        this.x = new a();
        this.y = new ArrayList();
        reset();
        a();
    }

    private int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i)) == null) {
            if (i == 0 || i == 1 || i == 2) {
                return i;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    private void a() {
        i gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            if (CyberCfgManager.getInstance().a("videoview_auto_requestfocus", false)) {
                setFocusable(true);
                setFocusableInTouchMode(true);
                requestFocus();
            }
            this.h = 0;
            this.i = 0;
            this.j = 0;
            this.k = 0;
            int i = this.w;
            if (i != 0) {
                if (i == 1) {
                    this.v = new h(this.a);
                    if (Build.VERSION.SDK_INT < 21) {
                        setDecodeMode(1);
                    }
                } else if (i == 2) {
                    gVar = new g(this.a);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
                this.v.setCyberSurfaceListener(this.I);
                this.v.getView().setLayoutParams(layoutParams);
                addView(this.v.getView());
                CyberLog.d("CyberVideoView", "initVideoView mCyberRenderView:" + this.v);
            }
            gVar = new b(this.a);
            this.v = gVar;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2, 17);
            this.v.setCyberSurfaceListener(this.I);
            this.v.getView().setLayoutParams(layoutParams2);
            addView(this.v.getView());
            CyberLog.d("CyberVideoView", "initVideoView mCyberRenderView:" + this.v);
        }
    }

    private boolean a(CyberPlayer cyberPlayer) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, cyberPlayer)) == null) {
            if (cyberPlayer != null) {
                int decodeMode = cyberPlayer.getDecodeMode();
                if (decodeMode == 4) {
                    str = "handlerLastPlay isPlayerNeedRelease DECODE_MODE_SYS!";
                } else if (decodeMode == 1) {
                    str = "handlerLastPlay isPlayerNeedRelease DECODE_MODE_SW!";
                } else if (!this.A || cyberPlayer.isRemotePlayer()) {
                    return false;
                } else {
                    str = "handlerLastPlay isPlayerNeedRelease mainprocess !";
                }
                CyberLog.i("CyberVideoView", str);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || this.c == null) {
            return;
        }
        this.E = System.currentTimeMillis();
        l.b();
        d();
        try {
            if (this.b == null) {
                this.b = new CyberPlayer(this.z, this.m, this.A);
            }
            this.b.setOnPreparedListener(this);
            this.b.setOnCompletionListener(this);
            this.b.setOnVideoSizeChangedListener(this);
            this.b.setOnSeekCompleteListener(this);
            this.b.setOnBufferingUpdateListener(this);
            this.b.setOnErrorListener(this);
            this.b.setOnInfoListener(this);
            this.b.setOnMediaSourceChangedListener(this);
            if (this.G != null) {
                this.b.setPlayJson(this.G);
            }
            if (this.H != null) {
                this.b.setClarityInfo(this.H);
            }
            if (this.l != null) {
                for (String str : this.l.keySet()) {
                    this.b.setOption(str, (String) this.l.get(str));
                }
            }
            CyberPlayer cyberPlayer = this.b;
            cyberPlayer.setOption(CyberPlayerManager.OPT_CLIENT_SET_URL_TIME, "" + this.E);
            if (this.F) {
                this.b.setOption("mediacodec-config-need-retry", 1L);
            }
            this.b.setDataSource(this.a, this.c, this.d);
            this.b.prepareAsync();
            this.h = 1;
            if (this.v != null) {
                Surface d = this.v.d();
                CyberLog.d("CyberVideoView", "openVideo s:" + d + " mCyberPlayer:" + this.b);
                if (d != null) {
                    this.b.setSurface(d);
                }
            }
            this.b.setScreenOnWhilePlaying(true);
            if (this.B) {
                this.b.muteOrUnmuteAudio(this.B);
            }
            if (this.D != 1.0f) {
                this.b.setSpeed(this.D);
            }
            if (this.C) {
                this.b.setLooping(this.C);
            }
            c();
        } catch (Exception e) {
            e.printStackTrace();
            onError(-111, 0, null);
        }
    }

    private void c() {
        ArrayList b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || this.b == null || (b = this.x.b()) == null) {
            return;
        }
        int size = b.size();
        for (int i = 0; i < size; i++) {
            a.C0088a c0088a = (a.C0088a) b.get(i);
            if (c0088a != null && c0088a.a() != null) {
                this.b.setExternalInfo(c0088a.a(), c0088a.b());
            }
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.F = false;
            if (this.b != null) {
                if (this.w == 1 && CyberCfgManager.getInstance().a("textureview_player_reuse", false) && !a(this.b)) {
                    e();
                    CyberLog.i("CyberVideoView", "handlerLastPlay called reset last player");
                } else {
                    f();
                    CyberLog.i("CyberVideoView", "handlerLastPlay called release last player");
                    if (this.w == 1) {
                        this.F = true;
                    }
                }
            }
            g();
        }
    }

    private void e() {
        CyberPlayer cyberPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, this) == null) || (cyberPlayer = this.b) == null) {
            return;
        }
        if (this.h != -1) {
            cyberPlayer.reset();
        } else {
            cyberPlayer.release();
            this.b = null;
        }
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
    }

    private void f() {
        CyberPlayer cyberPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, this) == null) || (cyberPlayer = this.b) == null) {
            return;
        }
        if (cyberPlayer.getDecodeMode() == 4) {
            this.b.reset();
        }
        this.b.release();
        this.b = null;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
    }

    private void g() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65552, this) == null) || (iVar = this.v) == null) {
            return;
        }
        iVar.a();
    }

    private boolean h() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) ? (this.b == null || (i = this.h) == -1 || i == 0 || i == 1) ? false : true : invokeV.booleanValue;
    }

    private boolean i() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) ? (this.b == null || (i = this.h) == 0 || i == 1) ? false : true : invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void changeProxyDynamic(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.b != null && TextUtils.isEmpty(o.c())) {
            HashMap hashMap = this.l;
            String str2 = hashMap != null ? (String) hashMap.get(CyberPlayerManager.OPT_HTTP_PROXY) : null;
            if (TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                this.b.changeProxyDynamic(null, false);
            } else if (str.equals(str2)) {
                return;
            } else {
                this.b.changeProxyDynamic(str, true);
            }
            this.b.seekTo(getCurrentPosition() + ErrorCode.SERVER_ERROR);
            HashMap hashMap2 = this.l;
            if (hashMap2 != null) {
                hashMap2.put(CyberPlayerManager.OPT_HTTP_PROXY, str);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            CyberLog.i("CyberVideoView", "destory called");
            f();
            HashMap hashMap = this.l;
            if (hashMap != null) {
                hashMap.clear();
                this.l = null;
            }
            a aVar = this.x;
            if (aVar != null) {
                aVar.a();
                this.x = null;
            }
            synchronized (this.y) {
                if (this.y != null) {
                    this.y.clear();
                }
            }
            Map map = this.d;
            if (map != null) {
                map.clear();
                this.d = null;
            }
            this.m = null;
            this.n = null;
            this.o = null;
            this.p = null;
            this.q = null;
            this.r = null;
            this.s = null;
            this.t = null;
            this.u = null;
            if (this.v != null) {
                removeAllViews();
                this.v.b();
                this.v = null;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, region)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (i()) {
                return this.b.getCurrentPosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getCurrentPositionSync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (i()) {
                return this.b.getCurrentPositionSync();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public CyberPlayer getCyberPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b : (CyberPlayer) invokeV.objValue;
    }

    public int getDecodeMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            CyberPlayer cyberPlayer = this.b;
            return cyberPlayer != null ? cyberPlayer.getDecodeMode() : this.z;
        }
        return invokeV.intValue;
    }

    public long getDownloadSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            CyberPlayer cyberPlayer = this.b;
            if (cyberPlayer == null || this.h == 0) {
                return -1L;
            }
            return cyberPlayer.getDownloadSpeed();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (i()) {
                return this.b.getDuration();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public long getPlayedTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (i()) {
                return this.b.getPlayedTime();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public i getRenderView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.v : (i) invokeV.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.k : invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.j : invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? h() && this.h == 3 : invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void muteOrUnmuteAudio(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.B = z;
            CyberLog.i("CyberVideoView", "muteOrUnmuteAudio flag:" + z);
            CyberPlayer cyberPlayer = this.b;
            if (cyberPlayer != null) {
                cyberPlayer.muteOrUnmuteAudio(z);
            } else {
                CyberLog.i("CyberVideoView", "muteOrUnmuteAudio must call after setVideoPath or setVideoURI");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i) {
        CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i) == null) || (onBufferingUpdateListener = this.r) == null) {
            return;
        }
        onBufferingUpdateListener.onBufferingUpdate(i);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.h = 5;
            this.i = 5;
            CyberPlayerManager.OnCompletionListener onCompletionListener = this.p;
            if (onCompletionListener != null) {
                onCompletionListener.onCompletion();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048594, this, i, i2, obj)) == null) {
            this.h = -1;
            this.i = -1;
            CyberPlayerManager.OnErrorListener onErrorListener = this.s;
            if (onErrorListener != null) {
                return onErrorListener.onError(i, i2, obj);
            }
            return true;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        CyberPlayer cyberPlayer;
        i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048595, this, i, i2, obj)) == null) {
            if (i == 10001 && (cyberPlayer = this.b) != null && cyberPlayer.getDecodeMode() != 4 && (iVar = this.v) != null) {
                iVar.setRawFrameRotation(i2);
            }
            CyberPlayerManager.OnInfoListener onInfoListener = this.t;
            return onInfoListener != null && onInfoListener.onInfo(i, i2, obj);
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnMediaSourceChangedListener
    public boolean onMediaSourceChanged(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048596, this, i, i2, obj)) == null) {
            CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener = this.u;
            return onMediaSourceChangedListener != null && onMediaSourceChangedListener.onMediaSourceChanged(i, i2, obj);
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.h = 2;
            CyberPlayerManager.OnPreparedListener onPreparedListener = this.n;
            if (onPreparedListener != null) {
                onPreparedListener.onPrepared();
            }
            int i = this.e;
            if (i > 0) {
                seekTo(i, this.f);
            }
            this.e = -1;
            int i2 = this.g;
            if (i2 != Integer.MIN_VALUE) {
                switchMediaSource(i2);
                this.g = Integer.MIN_VALUE;
            }
            CyberLog.i("CyberVideoView", "onPrepared mTargetState::" + this.i);
            if (this.i == 3 && this.h == 2) {
                start();
            } else if (this.i == 4 && this.h == 2) {
                pause();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (onSeekCompleteListener = this.q) == null) {
            return;
        }
        onSeekCompleteListener.onSeekComplete();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048599, this, i, i2, i3, i4) == null) {
            this.j = i;
            this.k = i2;
            CyberLog.d("CyberVideoView", "onVideoSizeChanged num:" + i3 + " den:" + i4 + " width:" + i + " height:" + i2);
            i iVar = this.v;
            if (iVar != null) {
                iVar.a(this.j, this.k, i3, i4);
            }
            CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener = this.o;
            if (onVideoSizeChangedListener != null) {
                onVideoSizeChangedListener.onVideoSizeChanged(i, i2, i3, i4);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (h()) {
                this.b.pause();
                this.h = 4;
            } else {
                CyberPlayer cyberPlayer = this.b;
                if (cyberPlayer != null) {
                    cyberPlayer.sendCommand(1000, 0, 0L, null);
                }
            }
            this.i = 4;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void reset() {
        CyberPlayer cyberPlayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.B = false;
            this.A = true;
            this.C = false;
            this.D = 1.0f;
            this.e = -1;
            this.g = Integer.MIN_VALUE;
            this.c = null;
            this.d = null;
            this.m = null;
            this.G = null;
            this.H = null;
            this.z = 0;
            if (this.h == -1 && (cyberPlayer = this.b) != null) {
                cyberPlayer.release();
                this.b = null;
            }
            this.h = 0;
            this.i = 0;
            this.j = 0;
            this.k = 0;
            CyberPlayer cyberPlayer2 = this.b;
            if (cyberPlayer2 != null) {
                cyberPlayer2.reset();
            }
            i iVar = this.v;
            if (iVar != null) {
                iVar.c();
            }
            HashMap hashMap = this.l;
            if (hashMap != null) {
                hashMap.clear();
            }
            a aVar = this.x;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048602, this, i) == null) || this.b == null) {
            return;
        }
        if (h()) {
            this.b.seekTo(i);
        } else {
            this.e = i;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048603, this, i, i2) == null) || this.b == null) {
            return;
        }
        if (h()) {
            this.b.seekTo(i, i2);
            return;
        }
        this.f = i2;
        this.e = i;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setClarityInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                CyberLog.w("CyberVideoView", "setClarityInfo is null");
                return;
            }
            CyberPlayer cyberPlayer = this.b;
            if (cyberPlayer != null) {
                cyberPlayer.setClarityInfo(str);
            } else {
                this.H = str;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setDecodeMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            this.z = i;
            if (Build.VERSION.SDK_INT >= 21 || i != 2) {
                return;
            }
            this.z = 1;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setExternalInfo(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048606, this, str, obj) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        CyberPlayer cyberPlayer = this.b;
        if (cyberPlayer != null) {
            cyberPlayer.setExternalInfo(str, obj);
        } else {
            this.x.a(str, obj);
        }
    }

    public void setHttpDns(CyberPlayerManager.HttpDNS httpDNS) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, httpDNS) == null) {
            this.m = httpDNS;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.C = z;
            CyberPlayer cyberPlayer = this.b;
            if (cyberPlayer != null) {
                cyberPlayer.setLooping(z);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, onBufferingUpdateListener) == null) {
            this.r = onBufferingUpdateListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, onCompletionListener) == null) {
            this.p = onCompletionListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, onErrorListener) == null) {
            this.s = onErrorListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, onInfoListener) == null) {
            this.t = onInfoListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, onMediaSourceChangedListener) == null) {
            this.u = onMediaSourceChangedListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, onPreparedListener) == null) {
            this.n = onPreparedListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, onSeekCompleteListener) == null) {
            this.q = onSeekCompleteListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, onVideoSizeChangedListener) == null) {
            this.o = onVideoSizeChangedListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setOption(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048617, this, str, str2) == null) {
            if (this.h != 0) {
                CyberLog.i("CyberVideoView", "Do not set option when the video player playing");
                return;
            }
            HashMap hashMap = this.l;
            if (hashMap != null) {
                hashMap.put(str, str2);
            }
            if (this.b != null) {
                if (str == null || !str.equals(CyberPlayerManager.OPT_HTTP_PROXY) || TextUtils.isEmpty(o.c())) {
                    this.b.setOption(str, str2);
                }
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setPlayJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                CyberLog.w("CyberVideoView", "setPlayJson is null");
                return;
            }
            CyberPlayer cyberPlayer = this.b;
            if (cyberPlayer != null) {
                cyberPlayer.setPlayJson(str);
            } else {
                this.G = str;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setRemote(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.A = z;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setSpeed(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048620, this, f) == null) {
            CyberLog.i("CyberVideoView", "setSpeed()");
            this.D = f;
            CyberPlayer cyberPlayer = this.b;
            if (cyberPlayer != null) {
                cyberPlayer.setSpeed(f);
            } else {
                CyberLog.i("CyberVideoView", "setSpeed must call after setVideoPath or setVideoURI");
            }
        }
    }

    public void setVideoPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            setVideoURI(Uri.parse(str));
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoRotation(int i) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048622, this, i) == null) || (iVar = this.v) == null) {
            return;
        }
        iVar.setClientRotation(i);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoScalingMode(int i) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048623, this, i) == null) || (iVar = this.v) == null) {
            return;
        }
        iVar.setDisplayMode(i);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, uri) == null) {
            setVideoURI(uri, null);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri, Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048625, this, uri, map) == null) {
            this.c = uri;
            this.d = map;
            this.e = -1;
            b();
            requestLayout();
            invalidate();
        }
    }

    public void setZOrderMediaOverlay(boolean z) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048626, this, z) == null) || (iVar = this.v) == null) {
            return;
        }
        iVar.setZOrderMediaOverlay(z);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            CyberLog.i("CyberVideoView", "start mCyberPlayer:" + this.b + " mCurrentState:" + this.h);
            if (h()) {
                this.b.start();
                this.h = 3;
            } else {
                CyberPlayer cyberPlayer = this.b;
                if (cyberPlayer != null) {
                    cyberPlayer.sendCommand(1000, 1, 0L, null);
                }
            }
            this.i = 3;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            CyberPlayer cyberPlayer = this.b;
            if (cyberPlayer != null) {
                cyberPlayer.stop();
                this.b.release();
                this.b = null;
                this.h = 0;
                this.i = 0;
            }
            HashMap hashMap = this.l;
            if (hashMap != null) {
                hashMap.clear();
            }
            i iVar = this.v;
            if (iVar != null) {
                iVar.c();
                this.v.a();
            }
            a aVar = this.x;
            if (aVar != null) {
                aVar.a();
            }
            this.G = null;
            this.H = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void switchMediaSource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i) == null) {
            if (h()) {
                this.b.switchMediaSource(i);
            } else {
                this.g = i;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, onSnapShotCompleteListener)) == null) ? takeSnapshotAsync(onSnapShotCompleteListener, 1.0f, 0, 0) : invokeL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener, float f, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048631, this, new Object[]{onSnapShotCompleteListener, Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (onSnapShotCompleteListener == null) {
                return false;
            }
            CyberLog.d("CyberVideoView", "takeSnapshotAsync called");
            i iVar = this.v;
            if (iVar != null) {
                if (iVar.e()) {
                    synchronized (this.y) {
                        if (this.y.isEmpty()) {
                            this.v.a(f, i, i2);
                        }
                        this.y.add(onSnapShotCompleteListener);
                    }
                    return true;
                }
                Bitmap a = this.v.a(f, i, i2);
                if (a == null || onSnapShotCompleteListener == null) {
                    return true;
                }
                onSnapShotCompleteListener.onSnapShotComplete(a);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
