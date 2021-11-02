package b.a.p0.f.i.j;

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
    public String f9770a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f9771b;

    /* renamed from: c  reason: collision with root package name */
    public String f9772c;

    /* renamed from: d  reason: collision with root package name */
    public int f9773d;

    /* renamed from: e  reason: collision with root package name */
    public int f9774e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f9775f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f9776g;

    /* renamed from: h  reason: collision with root package name */
    public String f9777h;

    /* renamed from: i  reason: collision with root package name */
    public int f9778i;
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
        this.f9770a = "";
        this.f9771b = false;
        this.f9772c = "";
        this.f9773d = 0;
        this.f9774e = 0;
        this.f9775f = false;
        this.f9776g = false;
        this.f9777h = "";
        this.f9778i = 0;
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
            return "VideoPlayerParams{mPlayerId='" + this.f9770a + ExtendedMessageFormat.QUOTE + ", mMute=" + this.f9771b + ", mPoster='" + this.f9772c + ExtendedMessageFormat.QUOTE + ", mInitialTime=" + this.f9773d + ", duration=" + this.f9774e + ", mAutoPlay=" + this.f9775f + ", mLoop=" + this.f9776g + ", mObjectFit='" + this.f9777h + ExtendedMessageFormat.QUOTE + ", mPos=" + this.f9778i + ", mFullScreen=" + this.j + ", mDanmu='" + this.k + ExtendedMessageFormat.QUOTE + ", mDanmuList='" + this.l + ExtendedMessageFormat.QUOTE + ", mEnableDanmu=" + this.m + ", mShowDanmuBtn=" + this.n + ", mShowControlPanel=" + this.o + ", mSrc='" + this.p + ExtendedMessageFormat.QUOTE + ", mSanId='" + this.q + ExtendedMessageFormat.QUOTE + ", mShowPlayBtn=" + this.r + ", mShowMuteBtn=" + this.s + ", mShowCenterPlayBtn=" + this.t + ", mPageGesture=" + this.u + ", mShowProgress=" + this.v + ", mDirection=" + this.w + ", mShowFullscreenBtn=" + this.x + ", mEnableProgressGesture=" + this.y + ", mIsRemoteFile=" + this.z + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
