package c.a.r0.o4.i.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import tbclient.VideoTemplateContent;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f20489b;

    /* renamed from: c  reason: collision with root package name */
    public int f20490c;

    /* renamed from: d  reason: collision with root package name */
    public int f20491d;

    /* renamed from: e  reason: collision with root package name */
    public long f20492e;

    /* renamed from: f  reason: collision with root package name */
    public long f20493f;

    /* renamed from: g  reason: collision with root package name */
    public double f20494g;

    /* renamed from: h  reason: collision with root package name */
    public double f20495h;

    /* renamed from: i  reason: collision with root package name */
    public double f20496i;

    /* renamed from: j  reason: collision with root package name */
    public double f20497j;
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
            this.f20489b = videoTemplateContent.type.intValue();
            this.f20490c = videoTemplateContent.pic_width.intValue();
            this.f20491d = videoTemplateContent.pic_height.intValue();
            this.f20492e = videoTemplateContent.start_time.longValue();
            this.f20493f = videoTemplateContent.end_time.longValue();
            this.f20494g = videoTemplateContent.position_x.doubleValue();
            this.f20495h = videoTemplateContent.position_y.doubleValue();
            this.f20496i = videoTemplateContent.position_type.doubleValue();
            this.f20497j = videoTemplateContent.text_size.doubleValue();
            this.k = videoTemplateContent.text_color;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "AnniversaryContentData{content='" + this.a + ExtendedMessageFormat.QUOTE + ", type=" + this.f20489b + ", picWidth=" + this.f20490c + ", picHeight=" + this.f20491d + ", startTime=" + this.f20492e + ", endTime=" + this.f20493f + ", x=" + this.f20494g + ", y=" + this.f20495h + ", positionType=" + this.f20496i + ", textSize=" + this.f20497j + ", textColor='" + this.k + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
