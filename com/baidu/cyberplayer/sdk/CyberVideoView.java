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
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes10.dex */
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

    /* renamed from: b  reason: collision with root package name */
    public CyberPlayer f34358b;

    /* renamed from: c  reason: collision with root package name */
    public Uri f34359c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f34360d;

    /* renamed from: e  reason: collision with root package name */
    public int f34361e;

    /* renamed from: f  reason: collision with root package name */
    public int f34362f;

    /* renamed from: g  reason: collision with root package name */
    public int f34363g;

    /* renamed from: h  reason: collision with root package name */
    public int f34364h;

    /* renamed from: i  reason: collision with root package name */
    public int f34365i;

    /* renamed from: j  reason: collision with root package name */
    public int f34366j;

    /* renamed from: k  reason: collision with root package name */
    public int f34367k;
    public HashMap<String, String> l;
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
    public ArrayList<ICyberVideoView.OnSnapShotCompleteListener> y;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CyberVideoView(Context context, int i2) {
        this(context, null, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f34362f = 3;
        this.f34364h = 0;
        this.f34365i = 0;
        this.f34366j = 0;
        this.f34367k = 0;
        this.l = new HashMap<>();
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeII(1048576, this, i4, i5) == null) || this.a.f34358b == null) {
                    return;
                }
                try {
                    this.a.f34358b.updateDisplaySize(i4, i5);
                } catch (Exception unused) {
                }
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(int i4, int i5, Buffer buffer) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, i5, buffer) == null) {
                    CyberTaskExcutor.getInstance().execute(new Runnable(this, buffer, i4, i5) { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ Buffer a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ int f34369b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ int f34370c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass1 f34371d;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr3 = {this, buffer, Integer.valueOf(i4), Integer.valueOf(i5)};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i6 = newInitContext2.flag;
                                if ((i6 & 1) != 0) {
                                    int i7 = i6 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.f34371d = this;
                            this.a = buffer;
                            this.f34369b = i4;
                            this.f34370c = i5;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.a == null) {
                                return;
                            }
                            Bitmap createBitmap = Bitmap.createBitmap(this.f34369b, this.f34370c, Bitmap.Config.ARGB_8888);
                            createBitmap.copyPixelsFromBuffer(this.a);
                            Bitmap a = o.a(createBitmap);
                            CyberLog.d("CyberVideoView", "onTakeSnapShot rotate bmp finished");
                            synchronized (this.f34371d.a.y) {
                                for (int i6 = 0; i6 < this.f34371d.a.y.size(); i6++) {
                                    ((ICyberVideoView.OnSnapShotCompleteListener) this.f34371d.a.y.get(i6)).onSnapShotComplete(a);
                                }
                                this.f34371d.a.y.clear();
                            }
                        }
                    });
                }
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable(this, j2) { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ long a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass1 f34368b;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr3 = {this, Long.valueOf(j2)};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i4 = newInitContext2.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.f34368b = this;
                            this.a = j2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                if (Build.VERSION.SDK_INT <= 16 && this.f34368b.a.f34358b != null && this.f34368b.a.f34358b.getDecodeMode() == 4) {
                                    this.f34368b.a.f34358b.sendCommand(1002, 0, this.a, null);
                                }
                                if (this.f34368b.a.f34358b == null || this.f34368b.a.E <= 0) {
                                    return;
                                }
                                long j3 = this.a - this.f34368b.a.E;
                                HashMap hashMap = new HashMap();
                                hashMap.put("type", "20513");
                                hashMap.put("surface_drawed", "" + j3);
                                this.f34368b.a.f34358b.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
                            }
                        }
                    });
                }
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public boolean a(int i4) {
                InterceptResult invokeI;
                Surface d2;
                Surface d3;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(1048579, this, i4)) == null) {
                    CyberLog.d("CyberVideoView", "onSurfaceReady renderType:" + i4);
                    if (i4 == 0) {
                        if (Build.VERSION.SDK_INT < 16) {
                            if (this.a.f34358b != null && this.a.v != null && (d3 = this.a.v.d()) != null) {
                                this.a.f34358b.setSurface(d3);
                            }
                            return true;
                        }
                        return false;
                    }
                    if (i4 == 1) {
                        if (this.a.f34358b == null || this.a.v == null) {
                            return false;
                        }
                        d2 = this.a.v.d();
                        CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d2);
                        if (d2 == null) {
                            return false;
                        }
                    } else if (i4 != 2 || this.a.f34358b == null || this.a.v == null) {
                        return false;
                    } else {
                        d2 = this.a.v.d();
                        CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d2);
                        if (d2 == null) {
                            return false;
                        }
                        CyberLog.d("CyberVideoView", "onSurfaceReady mCyberPlayer:" + this.a.f34358b);
                    }
                    this.a.f34358b.setSurface(d2);
                    return false;
                }
                return invokeI.booleanValue;
            }
        };
        this.w = 0;
        CyberLog.d("CyberVideoView", "CyberVideoView mRenderType:" + this.w);
        this.a = context.getApplicationContext();
        this.x = new a();
        this.y = new ArrayList<>();
        reset();
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CyberVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f34362f = 3;
        this.f34364h = 0;
        this.f34365i = 0;
        this.f34366j = 0;
        this.f34367k = 0;
        this.l = new HashMap<>();
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
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(int i42, int i5) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeII(1048576, this, i42, i5) == null) || this.a.f34358b == null) {
                    return;
                }
                try {
                    this.a.f34358b.updateDisplaySize(i42, i5);
                } catch (Exception unused) {
                }
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(int i42, int i5, Buffer buffer) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i42, i5, buffer) == null) {
                    CyberTaskExcutor.getInstance().execute(new Runnable(this, buffer, i42, i5) { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ Buffer a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ int f34369b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ int f34370c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass1 f34371d;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = objArr3;
                                Object[] objArr3 = {this, buffer, Integer.valueOf(i42), Integer.valueOf(i5)};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i6 = newInitContext2.flag;
                                if ((i6 & 1) != 0) {
                                    int i7 = i6 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.f34371d = this;
                            this.a = buffer;
                            this.f34369b = i42;
                            this.f34370c = i5;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.a == null) {
                                return;
                            }
                            Bitmap createBitmap = Bitmap.createBitmap(this.f34369b, this.f34370c, Bitmap.Config.ARGB_8888);
                            createBitmap.copyPixelsFromBuffer(this.a);
                            Bitmap a = o.a(createBitmap);
                            CyberLog.d("CyberVideoView", "onTakeSnapShot rotate bmp finished");
                            synchronized (this.f34371d.a.y) {
                                for (int i6 = 0; i6 < this.f34371d.a.y.size(); i6++) {
                                    ((ICyberVideoView.OnSnapShotCompleteListener) this.f34371d.a.y.get(i6)).onSnapShotComplete(a);
                                }
                                this.f34371d.a.y.clear();
                            }
                        }
                    });
                }
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public void a(long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable(this, j2) { // from class: com.baidu.cyberplayer.sdk.CyberVideoView.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ long a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass1 f34368b;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = objArr3;
                                Object[] objArr3 = {this, Long.valueOf(j2)};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i42 = newInitContext2.flag;
                                if ((i42 & 1) != 0) {
                                    int i5 = i42 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.f34368b = this;
                            this.a = j2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                if (Build.VERSION.SDK_INT <= 16 && this.f34368b.a.f34358b != null && this.f34368b.a.f34358b.getDecodeMode() == 4) {
                                    this.f34368b.a.f34358b.sendCommand(1002, 0, this.a, null);
                                }
                                if (this.f34368b.a.f34358b == null || this.f34368b.a.E <= 0) {
                                    return;
                                }
                                long j3 = this.a - this.f34368b.a.E;
                                HashMap hashMap = new HashMap();
                                hashMap.put("type", "20513");
                                hashMap.put("surface_drawed", "" + j3);
                                this.f34368b.a.f34358b.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, hashMap);
                            }
                        }
                    });
                }
            }

            @Override // com.baidu.cyberplayer.sdk.i.a
            public boolean a(int i42) {
                InterceptResult invokeI;
                Surface d2;
                Surface d3;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(1048579, this, i42)) == null) {
                    CyberLog.d("CyberVideoView", "onSurfaceReady renderType:" + i42);
                    if (i42 == 0) {
                        if (Build.VERSION.SDK_INT < 16) {
                            if (this.a.f34358b != null && this.a.v != null && (d3 = this.a.v.d()) != null) {
                                this.a.f34358b.setSurface(d3);
                            }
                            return true;
                        }
                        return false;
                    }
                    if (i42 == 1) {
                        if (this.a.f34358b == null || this.a.v == null) {
                            return false;
                        }
                        d2 = this.a.v.d();
                        CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d2);
                        if (d2 == null) {
                            return false;
                        }
                    } else if (i42 != 2 || this.a.f34358b == null || this.a.v == null) {
                        return false;
                    } else {
                        d2 = this.a.v.d();
                        CyberLog.d("CyberVideoView", "onSurfaceReady s:" + d2);
                        if (d2 == null) {
                            return false;
                        }
                        CyberLog.d("CyberVideoView", "onSurfaceReady mCyberPlayer:" + this.a.f34358b);
                    }
                    this.a.f34358b.setSurface(d2);
                    return false;
                }
                return invokeI.booleanValue;
            }
        };
        this.w = a(i2);
        this.a = context.getApplicationContext();
        this.x = new a();
        this.y = new ArrayList<>();
        reset();
        a();
    }

    private int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2)) == null) {
            if (i2 == 0 || i2 == 1 || i2 == 2) {
                return i2;
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
            this.f34364h = 0;
            this.f34365i = 0;
            this.f34366j = 0;
            this.f34367k = 0;
            int i2 = this.w;
            if (i2 != 0) {
                if (i2 == 1) {
                    this.v = new h(this.a);
                    if (Build.VERSION.SDK_INT < 21) {
                        setDecodeMode(1);
                    }
                } else if (i2 == 2) {
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
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || this.f34359c == null) {
            return;
        }
        this.E = System.currentTimeMillis();
        l.b();
        d();
        try {
            if (this.f34358b == null) {
                this.f34358b = new CyberPlayer(this.z, this.m, this.A);
            }
            this.f34358b.setOnPreparedListener(this);
            this.f34358b.setOnCompletionListener(this);
            this.f34358b.setOnVideoSizeChangedListener(this);
            this.f34358b.setOnSeekCompleteListener(this);
            this.f34358b.setOnBufferingUpdateListener(this);
            this.f34358b.setOnErrorListener(this);
            this.f34358b.setOnInfoListener(this);
            this.f34358b.setOnMediaSourceChangedListener(this);
            if (this.G != null) {
                this.f34358b.setPlayJson(this.G);
            }
            if (this.H != null) {
                this.f34358b.setClarityInfo(this.H);
            }
            if (this.l != null) {
                for (String str : this.l.keySet()) {
                    this.f34358b.setOption(str, this.l.get(str));
                }
            }
            CyberPlayer cyberPlayer = this.f34358b;
            cyberPlayer.setOption(CyberPlayerManager.OPT_CLIENT_SET_URL_TIME, "" + this.E);
            if (this.F) {
                this.f34358b.setOption("mediacodec-config-need-retry", 1L);
            }
            this.f34358b.setDataSource(this.a, this.f34359c, this.f34360d);
            this.f34358b.prepareAsync();
            this.f34364h = 1;
            if (this.v != null) {
                Surface d2 = this.v.d();
                CyberLog.d("CyberVideoView", "openVideo s:" + d2 + " mCyberPlayer:" + this.f34358b);
                if (d2 != null) {
                    this.f34358b.setSurface(d2);
                }
            }
            this.f34358b.setScreenOnWhilePlaying(true);
            if (this.B) {
                this.f34358b.muteOrUnmuteAudio(this.B);
            }
            if (this.D != 1.0f) {
                this.f34358b.setSpeed(this.D);
            }
            if (this.C) {
                this.f34358b.setLooping(this.C);
            }
            c();
        } catch (Exception e2) {
            e2.printStackTrace();
            onError(-111, 0, null);
        }
    }

    private void c() {
        ArrayList<a.C1775a> b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || this.f34358b == null || (b2 = this.x.b()) == null) {
            return;
        }
        int size = b2.size();
        for (int i2 = 0; i2 < size; i2++) {
            a.C1775a c1775a = b2.get(i2);
            if (c1775a != null && c1775a.a() != null) {
                this.f34358b.setExternalInfo(c1775a.a(), c1775a.b());
            }
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.F = false;
            if (this.f34358b != null) {
                if (this.w == 1 && CyberCfgManager.getInstance().a("textureview_player_reuse", false) && !a(this.f34358b)) {
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
        if (!(interceptable == null || interceptable.invokeV(65550, this) == null) || (cyberPlayer = this.f34358b) == null) {
            return;
        }
        if (this.f34364h != -1) {
            cyberPlayer.reset();
        } else {
            cyberPlayer.release();
            this.f34358b = null;
        }
        this.f34364h = 0;
        this.f34365i = 0;
        this.f34366j = 0;
        this.f34367k = 0;
    }

    private void f() {
        CyberPlayer cyberPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, this) == null) || (cyberPlayer = this.f34358b) == null) {
            return;
        }
        if (cyberPlayer.getDecodeMode() == 4) {
            this.f34358b.reset();
        }
        this.f34358b.release();
        this.f34358b = null;
        this.f34364h = 0;
        this.f34365i = 0;
        this.f34366j = 0;
        this.f34367k = 0;
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
        int i2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) ? (this.f34358b == null || (i2 = this.f34364h) == -1 || i2 == 0 || i2 == 1) ? false : true : invokeV.booleanValue;
    }

    private boolean i() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) ? (this.f34358b == null || (i2 = this.f34364h) == 0 || i2 == 1) ? false : true : invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void changeProxyDynamic(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.f34358b != null && TextUtils.isEmpty(o.c())) {
            HashMap<String, String> hashMap = this.l;
            String str2 = hashMap != null ? hashMap.get(CyberPlayerManager.OPT_HTTP_PROXY) : null;
            if (TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                this.f34358b.changeProxyDynamic(null, false);
            } else if (str.equals(str2)) {
                return;
            } else {
                this.f34358b.changeProxyDynamic(str, true);
            }
            this.f34358b.seekTo(getCurrentPosition() - 500);
            HashMap<String, String> hashMap2 = this.l;
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
            HashMap<String, String> hashMap = this.l;
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
            Map<String, String> map = this.f34360d;
            if (map != null) {
                map.clear();
                this.f34360d = null;
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
                return this.f34358b.getCurrentPosition();
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
                return this.f34358b.getCurrentPositionSync();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public CyberPlayer getCyberPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f34358b : (CyberPlayer) invokeV.objValue;
    }

    public int getDecodeMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            CyberPlayer cyberPlayer = this.f34358b;
            return cyberPlayer != null ? cyberPlayer.getDecodeMode() : this.z;
        }
        return invokeV.intValue;
    }

    public long getDownloadSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            CyberPlayer cyberPlayer = this.f34358b;
            if (cyberPlayer == null || this.f34364h == 0) {
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
                return this.f34358b.getDuration();
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
                return this.f34358b.getPlayedTime();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f34367k : invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f34366j : invokeV.intValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? h() && this.f34364h == 3 : invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void muteOrUnmuteAudio(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.B = z;
            CyberLog.i("CyberVideoView", "muteOrUnmuteAudio flag:" + z);
            CyberPlayer cyberPlayer = this.f34358b;
            if (cyberPlayer != null) {
                cyberPlayer.muteOrUnmuteAudio(z);
            } else {
                CyberLog.i("CyberVideoView", "muteOrUnmuteAudio must call after setVideoPath or setVideoURI");
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i2) {
        CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i2) == null) || (onBufferingUpdateListener = this.r) == null) {
            return;
        }
        onBufferingUpdateListener.onBufferingUpdate(i2);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f34364h = 5;
            this.f34365i = 5;
            CyberPlayerManager.OnCompletionListener onCompletionListener = this.p;
            if (onCompletionListener != null) {
                onCompletionListener.onCompletion();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048594, this, i2, i3, obj)) == null) {
            this.f34364h = -1;
            this.f34365i = -1;
            CyberPlayerManager.OnErrorListener onErrorListener = this.s;
            if (onErrorListener != null) {
                return onErrorListener.onError(i2, i3, obj);
            }
            return true;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        CyberPlayer cyberPlayer;
        i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048595, this, i2, i3, obj)) == null) {
            if (i2 == 10001 && (cyberPlayer = this.f34358b) != null && cyberPlayer.getDecodeMode() != 4 && (iVar = this.v) != null) {
                iVar.setRawFrameRotation(i3);
            }
            CyberPlayerManager.OnInfoListener onInfoListener = this.t;
            return onInfoListener != null && onInfoListener.onInfo(i2, i3, obj);
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnMediaSourceChangedListener
    public boolean onMediaSourceChanged(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048596, this, i2, i3, obj)) == null) {
            CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener = this.u;
            return onMediaSourceChangedListener != null && onMediaSourceChangedListener.onMediaSourceChanged(i2, i3, obj);
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f34364h = 2;
            CyberPlayerManager.OnPreparedListener onPreparedListener = this.n;
            if (onPreparedListener != null) {
                onPreparedListener.onPrepared();
            }
            int i2 = this.f34361e;
            if (i2 > 0) {
                seekTo(i2, this.f34362f);
            }
            this.f34361e = -1;
            int i3 = this.f34363g;
            if (i3 != Integer.MIN_VALUE) {
                switchMediaSource(i3);
                this.f34363g = Integer.MIN_VALUE;
            }
            CyberLog.i("CyberVideoView", "onPrepared mTargetState::" + this.f34365i);
            if (this.f34365i == 3 && this.f34364h == 2) {
                start();
            } else if (this.f34365i == 4 && this.f34364h == 2) {
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
    public void onVideoSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048599, this, i2, i3, i4, i5) == null) {
            this.f34366j = i2;
            this.f34367k = i3;
            CyberLog.d("CyberVideoView", "onVideoSizeChanged num:" + i4 + " den:" + i5 + " width:" + i2 + " height:" + i3);
            i iVar = this.v;
            if (iVar != null) {
                iVar.a(this.f34366j, this.f34367k, i4, i5);
            }
            CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener = this.o;
            if (onVideoSizeChangedListener != null) {
                onVideoSizeChangedListener.onVideoSizeChanged(i2, i3, i4, i5);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (h()) {
                this.f34358b.pause();
                this.f34364h = 4;
            } else {
                CyberPlayer cyberPlayer = this.f34358b;
                if (cyberPlayer != null) {
                    cyberPlayer.sendCommand(1000, 0, 0L, null);
                }
            }
            this.f34365i = 4;
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
            this.f34361e = -1;
            this.f34363g = Integer.MIN_VALUE;
            this.f34359c = null;
            this.f34360d = null;
            this.m = null;
            this.G = null;
            this.H = null;
            this.z = 0;
            if (this.f34364h == -1 && (cyberPlayer = this.f34358b) != null) {
                cyberPlayer.release();
                this.f34358b = null;
            }
            this.f34364h = 0;
            this.f34365i = 0;
            this.f34366j = 0;
            this.f34367k = 0;
            CyberPlayer cyberPlayer2 = this.f34358b;
            if (cyberPlayer2 != null) {
                cyberPlayer2.reset();
            }
            i iVar = this.v;
            if (iVar != null) {
                iVar.c();
            }
            HashMap<String, String> hashMap = this.l;
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
    public void seekTo(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048602, this, i2) == null) || this.f34358b == null) {
            return;
        }
        if (h()) {
            this.f34358b.seekTo(i2);
        } else {
            this.f34361e = i2;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void seekTo(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048603, this, i2, i3) == null) || this.f34358b == null) {
            return;
        }
        if (h()) {
            this.f34358b.seekTo(i2, i3);
            return;
        }
        this.f34362f = i3;
        this.f34361e = i2;
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setClarityInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                CyberLog.w("CyberVideoView", "setClarityInfo is null");
                return;
            }
            CyberPlayer cyberPlayer = this.f34358b;
            if (cyberPlayer != null) {
                cyberPlayer.setClarityInfo(str);
            } else {
                this.H = str;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setDecodeMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.z = i2;
            if (Build.VERSION.SDK_INT >= 21 || i2 != 2) {
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
        CyberPlayer cyberPlayer = this.f34358b;
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
            CyberPlayer cyberPlayer = this.f34358b;
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
            if (this.f34364h != 0) {
                CyberLog.i("CyberVideoView", "Do not set option when the video player playing");
                return;
            }
            HashMap<String, String> hashMap = this.l;
            if (hashMap != null) {
                hashMap.put(str, str2);
            }
            if (this.f34358b != null) {
                if (str == null || !str.equals(CyberPlayerManager.OPT_HTTP_PROXY) || TextUtils.isEmpty(o.c())) {
                    this.f34358b.setOption(str, str2);
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
            CyberPlayer cyberPlayer = this.f34358b;
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
    public void setSpeed(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048620, this, f2) == null) {
            CyberLog.i("CyberVideoView", "setSpeed()");
            this.D = f2;
            CyberPlayer cyberPlayer = this.f34358b;
            if (cyberPlayer != null) {
                cyberPlayer.setSpeed(f2);
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
    public void setVideoRotation(int i2) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048622, this, i2) == null) || (iVar = this.v) == null) {
            return;
        }
        iVar.setClientRotation(i2);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoScalingMode(int i2) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048623, this, i2) == null) || (iVar = this.v) == null) {
            return;
        }
        iVar.setDisplayMode(i2);
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, uri) == null) {
            setVideoURI(uri, null);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setVideoURI(Uri uri, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048625, this, uri, map) == null) {
            this.f34359c = uri;
            this.f34360d = map;
            this.f34361e = -1;
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
            CyberLog.i("CyberVideoView", "start mCyberPlayer:" + this.f34358b + " mCurrentState:" + this.f34364h);
            if (h()) {
                this.f34358b.start();
                this.f34364h = 3;
            } else {
                CyberPlayer cyberPlayer = this.f34358b;
                if (cyberPlayer != null) {
                    cyberPlayer.sendCommand(1000, 1, 0L, null);
                }
            }
            this.f34365i = 3;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            CyberPlayer cyberPlayer = this.f34358b;
            if (cyberPlayer != null) {
                cyberPlayer.stop();
                this.f34358b.release();
                this.f34358b = null;
                this.f34364h = 0;
                this.f34365i = 0;
            }
            HashMap<String, String> hashMap = this.l;
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
    public void switchMediaSource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i2) == null) {
            if (h()) {
                this.f34358b.switchMediaSource(i2);
            } else {
                this.f34363g = i2;
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
    public boolean takeSnapshotAsync(ICyberVideoView.OnSnapShotCompleteListener onSnapShotCompleteListener, float f2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048631, this, new Object[]{onSnapShotCompleteListener, Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (onSnapShotCompleteListener == null) {
                return false;
            }
            CyberLog.d("CyberVideoView", "takeSnapshotAsync called");
            i iVar = this.v;
            if (iVar != null) {
                if (iVar.e()) {
                    synchronized (this.y) {
                        if (this.y.isEmpty()) {
                            this.v.a(f2, i2, i3);
                        }
                        this.y.add(onSnapShotCompleteListener);
                    }
                    return true;
                }
                Bitmap a = this.v.a(f2, i2, i3);
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
