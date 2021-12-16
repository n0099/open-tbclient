package c.a.q0.h.i.j;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f9943b;

    /* renamed from: c  reason: collision with root package name */
    public String f9944c;

    /* renamed from: d  reason: collision with root package name */
    public int f9945d;

    /* renamed from: e  reason: collision with root package name */
    public int f9946e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f9947f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f9948g;

    /* renamed from: h  reason: collision with root package name */
    public String f9949h;

    /* renamed from: i  reason: collision with root package name */
    public int f9950i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f9951j;

    /* renamed from: k  reason: collision with root package name */
    public String f9952k;
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

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "";
        this.f9943b = false;
        this.f9944c = "";
        this.f9945d = 0;
        this.f9946e = 0;
        this.f9947f = false;
        this.f9948g = false;
        this.f9949h = "";
        this.f9950i = 0;
        this.f9952k = "";
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
            return "VideoPlayerParams{mPlayerId='" + this.a + ExtendedMessageFormat.QUOTE + ", mMute=" + this.f9943b + ", mPoster='" + this.f9944c + ExtendedMessageFormat.QUOTE + ", mInitialTime=" + this.f9945d + ", duration=" + this.f9946e + ", mAutoPlay=" + this.f9947f + ", mLoop=" + this.f9948g + ", mObjectFit='" + this.f9949h + ExtendedMessageFormat.QUOTE + ", mPos=" + this.f9950i + ", mFullScreen=" + this.f9951j + ", mDanmu='" + this.f9952k + ExtendedMessageFormat.QUOTE + ", mDanmuList='" + this.l + ExtendedMessageFormat.QUOTE + ", mEnableDanmu=" + this.m + ", mShowDanmuBtn=" + this.n + ", mShowControlPanel=" + this.o + ", mSrc='" + this.p + ExtendedMessageFormat.QUOTE + ", mSanId='" + this.q + ExtendedMessageFormat.QUOTE + ", mShowPlayBtn=" + this.r + ", mShowMuteBtn=" + this.s + ", mShowCenterPlayBtn=" + this.t + ", mPageGesture=" + this.u + ", mShowProgress=" + this.v + ", mDirection=" + this.w + ", mShowFullscreenBtn=" + this.x + ", mEnableProgressGesture=" + this.y + ", mIsRemoteFile=" + this.z + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
