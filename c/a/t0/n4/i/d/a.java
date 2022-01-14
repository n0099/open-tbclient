package c.a.t0.n4.i.d;

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
    public int f19869b;

    /* renamed from: c  reason: collision with root package name */
    public int f19870c;

    /* renamed from: d  reason: collision with root package name */
    public int f19871d;

    /* renamed from: e  reason: collision with root package name */
    public long f19872e;

    /* renamed from: f  reason: collision with root package name */
    public long f19873f;

    /* renamed from: g  reason: collision with root package name */
    public double f19874g;

    /* renamed from: h  reason: collision with root package name */
    public double f19875h;

    /* renamed from: i  reason: collision with root package name */
    public double f19876i;

    /* renamed from: j  reason: collision with root package name */
    public double f19877j;
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
            this.f19869b = videoTemplateContent.type.intValue();
            this.f19870c = videoTemplateContent.pic_width.intValue();
            this.f19871d = videoTemplateContent.pic_height.intValue();
            this.f19872e = videoTemplateContent.start_time.longValue();
            this.f19873f = videoTemplateContent.end_time.longValue();
            this.f19874g = videoTemplateContent.position_x.doubleValue();
            this.f19875h = videoTemplateContent.position_y.doubleValue();
            this.f19876i = videoTemplateContent.position_type.doubleValue();
            this.f19877j = videoTemplateContent.text_size.doubleValue();
            this.k = videoTemplateContent.text_color;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "AnniversaryContentData{content='" + this.a + ExtendedMessageFormat.QUOTE + ", type=" + this.f19869b + ", picWidth=" + this.f19870c + ", picHeight=" + this.f19871d + ", startTime=" + this.f19872e + ", endTime=" + this.f19873f + ", x=" + this.f19874g + ", y=" + this.f19875h + ", positionType=" + this.f19876i + ", textSize=" + this.f19877j + ", textColor='" + this.k + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
