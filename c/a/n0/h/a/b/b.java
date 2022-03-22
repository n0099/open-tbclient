package c.a.n0.h.a.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f8303b;

    /* renamed from: c  reason: collision with root package name */
    public String f8304c;

    /* renamed from: d  reason: collision with root package name */
    public int f8305d;

    /* renamed from: e  reason: collision with root package name */
    public int f8306e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f8307f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f8308g;

    /* renamed from: h  reason: collision with root package name */
    public String f8309h;
    public int i;
    public boolean j;
    public String k;
    public String l;
    public boolean m;
    public boolean n;
    public boolean o;
    public String p;
    public String q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public int w;
    public boolean x;
    public boolean y;
    public boolean z;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "";
        this.f8303b = false;
        this.f8304c = "";
        this.f8305d = 0;
        this.f8306e = 0;
        this.f8307f = false;
        this.f8308g = false;
        this.f8309h = "";
        this.i = 0;
        this.k = "";
        this.l = "";
        this.m = false;
        this.n = false;
        this.o = true;
        this.p = "";
        this.q = "";
        this.u = false;
        this.v = true;
        this.w = -1;
        this.x = true;
        this.y = true;
        this.z = true;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "VideoPlayerParams{mPlayerId='" + this.a + "', mMute=" + this.f8303b + ", mPoster='" + this.f8304c + "', mInitialTime=" + this.f8305d + ", duration=" + this.f8306e + ", mAutoPlay=" + this.f8307f + ", mLoop=" + this.f8308g + ", mObjectFit='" + this.f8309h + "', mPos=" + this.i + ", mFullScreen=" + this.j + ", mDanmu='" + this.k + "', mDanmuList='" + this.l + "', mEnableDanmu=" + this.m + ", mShowDanmuBtn=" + this.n + ", mShowControlPanel=" + this.o + ", mSrc='" + this.p + "', mSanId='" + this.q + "', mShowPlayBtn=" + this.r + ", mShowMuteBtn=" + this.s + ", mShowCenterPlayBtn=" + this.t + ", mPageGesture=" + this.u + ", mShowProgress=" + this.v + ", mDirection=" + this.w + ", mShowFullscreenBtn=" + this.x + ", mEnableProgressGesture=" + this.y + ", mIsRemoteFile=" + this.z + '}';
        }
        return (String) invokeV.objValue;
    }
}
