package c.a.p0.f.i.j;

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
    public String f10555a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f10556b;

    /* renamed from: c  reason: collision with root package name */
    public String f10557c;

    /* renamed from: d  reason: collision with root package name */
    public int f10558d;

    /* renamed from: e  reason: collision with root package name */
    public int f10559e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10560f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10561g;

    /* renamed from: h  reason: collision with root package name */
    public String f10562h;

    /* renamed from: i  reason: collision with root package name */
    public int f10563i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f10564j;
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
        this.f10555a = "";
        this.f10556b = false;
        this.f10557c = "";
        this.f10558d = 0;
        this.f10559e = 0;
        this.f10560f = false;
        this.f10561g = false;
        this.f10562h = "";
        this.f10563i = 0;
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
            return "VideoPlayerParams{mPlayerId='" + this.f10555a + ExtendedMessageFormat.QUOTE + ", mMute=" + this.f10556b + ", mPoster='" + this.f10557c + ExtendedMessageFormat.QUOTE + ", mInitialTime=" + this.f10558d + ", duration=" + this.f10559e + ", mAutoPlay=" + this.f10560f + ", mLoop=" + this.f10561g + ", mObjectFit='" + this.f10562h + ExtendedMessageFormat.QUOTE + ", mPos=" + this.f10563i + ", mFullScreen=" + this.f10564j + ", mDanmu='" + this.k + ExtendedMessageFormat.QUOTE + ", mDanmuList='" + this.l + ExtendedMessageFormat.QUOTE + ", mEnableDanmu=" + this.m + ", mShowDanmuBtn=" + this.n + ", mShowControlPanel=" + this.o + ", mSrc='" + this.p + ExtendedMessageFormat.QUOTE + ", mSanId='" + this.q + ExtendedMessageFormat.QUOTE + ", mShowPlayBtn=" + this.r + ", mShowMuteBtn=" + this.s + ", mShowCenterPlayBtn=" + this.t + ", mPageGesture=" + this.u + ", mShowProgress=" + this.v + ", mDirection=" + this.w + ", mShowFullscreenBtn=" + this.x + ", mEnableProgressGesture=" + this.y + ", mIsRemoteFile=" + this.z + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
