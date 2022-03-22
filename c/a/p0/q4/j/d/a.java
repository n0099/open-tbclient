package c.a.p0.q4.j.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.VideoTemplateContent;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f17750b;

    /* renamed from: c  reason: collision with root package name */
    public int f17751c;

    /* renamed from: d  reason: collision with root package name */
    public int f17752d;

    /* renamed from: e  reason: collision with root package name */
    public long f17753e;

    /* renamed from: f  reason: collision with root package name */
    public long f17754f;

    /* renamed from: g  reason: collision with root package name */
    public double f17755g;

    /* renamed from: h  reason: collision with root package name */
    public double f17756h;
    public double i;
    public double j;
    public String k;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(VideoTemplateContent videoTemplateContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, videoTemplateContent) == null) {
            this.a = videoTemplateContent.content;
            this.f17750b = videoTemplateContent.type.intValue();
            this.f17751c = videoTemplateContent.pic_width.intValue();
            this.f17752d = videoTemplateContent.pic_height.intValue();
            this.f17753e = videoTemplateContent.start_time.longValue();
            this.f17754f = videoTemplateContent.end_time.longValue();
            this.f17755g = videoTemplateContent.position_x.doubleValue();
            this.f17756h = videoTemplateContent.position_y.doubleValue();
            this.i = videoTemplateContent.position_type.doubleValue();
            this.j = videoTemplateContent.text_size.doubleValue();
            this.k = videoTemplateContent.text_color;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "AnniversaryContentData{content='" + this.a + "', type=" + this.f17750b + ", picWidth=" + this.f17751c + ", picHeight=" + this.f17752d + ", startTime=" + this.f17753e + ", endTime=" + this.f17754f + ", x=" + this.f17755g + ", y=" + this.f17756h + ", positionType=" + this.i + ", textSize=" + this.j + ", textColor='" + this.k + "'}";
        }
        return (String) invokeV.objValue;
    }
}
