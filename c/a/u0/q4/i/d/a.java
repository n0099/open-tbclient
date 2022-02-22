package c.a.u0.q4.i.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import tbclient.VideoTemplateContent;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f21537b;

    /* renamed from: c  reason: collision with root package name */
    public int f21538c;

    /* renamed from: d  reason: collision with root package name */
    public int f21539d;

    /* renamed from: e  reason: collision with root package name */
    public long f21540e;

    /* renamed from: f  reason: collision with root package name */
    public long f21541f;

    /* renamed from: g  reason: collision with root package name */
    public double f21542g;

    /* renamed from: h  reason: collision with root package name */
    public double f21543h;

    /* renamed from: i  reason: collision with root package name */
    public double f21544i;

    /* renamed from: j  reason: collision with root package name */
    public double f21545j;
    public String k;

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
            }
        }
    }

    public void a(VideoTemplateContent videoTemplateContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, videoTemplateContent) == null) {
            this.a = videoTemplateContent.content;
            this.f21537b = videoTemplateContent.type.intValue();
            this.f21538c = videoTemplateContent.pic_width.intValue();
            this.f21539d = videoTemplateContent.pic_height.intValue();
            this.f21540e = videoTemplateContent.start_time.longValue();
            this.f21541f = videoTemplateContent.end_time.longValue();
            this.f21542g = videoTemplateContent.position_x.doubleValue();
            this.f21543h = videoTemplateContent.position_y.doubleValue();
            this.f21544i = videoTemplateContent.position_type.doubleValue();
            this.f21545j = videoTemplateContent.text_size.doubleValue();
            this.k = videoTemplateContent.text_color;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "AnniversaryContentData{content='" + this.a + ExtendedMessageFormat.QUOTE + ", type=" + this.f21537b + ", picWidth=" + this.f21538c + ", picHeight=" + this.f21539d + ", startTime=" + this.f21540e + ", endTime=" + this.f21541f + ", x=" + this.f21542g + ", y=" + this.f21543h + ", positionType=" + this.f21544i + ", textSize=" + this.f21545j + ", textColor='" + this.k + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
