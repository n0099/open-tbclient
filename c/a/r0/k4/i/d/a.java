package c.a.r0.k4.i.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import tbclient.VideoTemplateContent;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f18894b;

    /* renamed from: c  reason: collision with root package name */
    public int f18895c;

    /* renamed from: d  reason: collision with root package name */
    public int f18896d;

    /* renamed from: e  reason: collision with root package name */
    public long f18897e;

    /* renamed from: f  reason: collision with root package name */
    public long f18898f;

    /* renamed from: g  reason: collision with root package name */
    public double f18899g;

    /* renamed from: h  reason: collision with root package name */
    public double f18900h;

    /* renamed from: i  reason: collision with root package name */
    public double f18901i;

    /* renamed from: j  reason: collision with root package name */
    public double f18902j;

    /* renamed from: k  reason: collision with root package name */
    public String f18903k;

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
            this.f18894b = videoTemplateContent.type.intValue();
            this.f18895c = videoTemplateContent.pic_width.intValue();
            this.f18896d = videoTemplateContent.pic_height.intValue();
            this.f18897e = videoTemplateContent.start_time.longValue();
            this.f18898f = videoTemplateContent.end_time.longValue();
            this.f18899g = videoTemplateContent.position_x.doubleValue();
            this.f18900h = videoTemplateContent.position_y.doubleValue();
            this.f18901i = videoTemplateContent.position_type.doubleValue();
            this.f18902j = videoTemplateContent.text_size.doubleValue();
            this.f18903k = videoTemplateContent.text_color;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "AnniversaryContentData{content='" + this.a + ExtendedMessageFormat.QUOTE + ", type=" + this.f18894b + ", picWidth=" + this.f18895c + ", picHeight=" + this.f18896d + ", startTime=" + this.f18897e + ", endTime=" + this.f18898f + ", x=" + this.f18899g + ", y=" + this.f18900h + ", positionType=" + this.f18901i + ", textSize=" + this.f18902j + ", textColor='" + this.f18903k + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
