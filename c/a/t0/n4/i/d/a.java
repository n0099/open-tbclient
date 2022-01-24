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
    public int f19970b;

    /* renamed from: c  reason: collision with root package name */
    public int f19971c;

    /* renamed from: d  reason: collision with root package name */
    public int f19972d;

    /* renamed from: e  reason: collision with root package name */
    public long f19973e;

    /* renamed from: f  reason: collision with root package name */
    public long f19974f;

    /* renamed from: g  reason: collision with root package name */
    public double f19975g;

    /* renamed from: h  reason: collision with root package name */
    public double f19976h;

    /* renamed from: i  reason: collision with root package name */
    public double f19977i;

    /* renamed from: j  reason: collision with root package name */
    public double f19978j;
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
            this.f19970b = videoTemplateContent.type.intValue();
            this.f19971c = videoTemplateContent.pic_width.intValue();
            this.f19972d = videoTemplateContent.pic_height.intValue();
            this.f19973e = videoTemplateContent.start_time.longValue();
            this.f19974f = videoTemplateContent.end_time.longValue();
            this.f19975g = videoTemplateContent.position_x.doubleValue();
            this.f19976h = videoTemplateContent.position_y.doubleValue();
            this.f19977i = videoTemplateContent.position_type.doubleValue();
            this.f19978j = videoTemplateContent.text_size.doubleValue();
            this.k = videoTemplateContent.text_color;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "AnniversaryContentData{content='" + this.a + ExtendedMessageFormat.QUOTE + ", type=" + this.f19970b + ", picWidth=" + this.f19971c + ", picHeight=" + this.f19972d + ", startTime=" + this.f19973e + ", endTime=" + this.f19974f + ", x=" + this.f19975g + ", y=" + this.f19976h + ", positionType=" + this.f19977i + ", textSize=" + this.f19978j + ", textColor='" + this.k + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
