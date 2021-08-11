package c.a.n0.f.i.j;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f10273a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f10274b;

    /* renamed from: c  reason: collision with root package name */
    public String f10275c;

    /* renamed from: d  reason: collision with root package name */
    public int f10276d;

    /* renamed from: e  reason: collision with root package name */
    public int f10277e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10278f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10279g;

    /* renamed from: h  reason: collision with root package name */
    public String f10280h;

    /* renamed from: i  reason: collision with root package name */
    public int f10281i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f10282j;
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
        this.f10273a = "";
        this.f10274b = false;
        this.f10275c = "";
        this.f10276d = 0;
        this.f10277e = 0;
        this.f10278f = false;
        this.f10279g = false;
        this.f10280h = "";
        this.f10281i = 0;
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
            return "VideoPlayerParams{mPlayerId='" + this.f10273a + ExtendedMessageFormat.QUOTE + ", mMute=" + this.f10274b + ", mPoster='" + this.f10275c + ExtendedMessageFormat.QUOTE + ", mInitialTime=" + this.f10276d + ", duration=" + this.f10277e + ", mAutoPlay=" + this.f10278f + ", mLoop=" + this.f10279g + ", mObjectFit='" + this.f10280h + ExtendedMessageFormat.QUOTE + ", mPos=" + this.f10281i + ", mFullScreen=" + this.f10282j + ", mDanmu='" + this.k + ExtendedMessageFormat.QUOTE + ", mDanmuList='" + this.l + ExtendedMessageFormat.QUOTE + ", mEnableDanmu=" + this.m + ", mShowDanmuBtn=" + this.n + ", mShowControlPanel=" + this.o + ", mSrc='" + this.p + ExtendedMessageFormat.QUOTE + ", mSanId='" + this.q + ExtendedMessageFormat.QUOTE + ", mShowPlayBtn=" + this.r + ", mShowMuteBtn=" + this.s + ", mShowCenterPlayBtn=" + this.t + ", mPageGesture=" + this.u + ", mShowProgress=" + this.v + ", mDirection=" + this.w + ", mShowFullscreenBtn=" + this.x + ", mEnableProgressGesture=" + this.y + ", mIsRemoteFile=" + this.z + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
