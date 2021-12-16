package c.a.s0.m4.i.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import tbclient.VideoTemplateContent;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f19677b;

    /* renamed from: c  reason: collision with root package name */
    public int f19678c;

    /* renamed from: d  reason: collision with root package name */
    public int f19679d;

    /* renamed from: e  reason: collision with root package name */
    public long f19680e;

    /* renamed from: f  reason: collision with root package name */
    public long f19681f;

    /* renamed from: g  reason: collision with root package name */
    public double f19682g;

    /* renamed from: h  reason: collision with root package name */
    public double f19683h;

    /* renamed from: i  reason: collision with root package name */
    public double f19684i;

    /* renamed from: j  reason: collision with root package name */
    public double f19685j;

    /* renamed from: k  reason: collision with root package name */
    public String f19686k;

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
            this.f19677b = videoTemplateContent.type.intValue();
            this.f19678c = videoTemplateContent.pic_width.intValue();
            this.f19679d = videoTemplateContent.pic_height.intValue();
            this.f19680e = videoTemplateContent.start_time.longValue();
            this.f19681f = videoTemplateContent.end_time.longValue();
            this.f19682g = videoTemplateContent.position_x.doubleValue();
            this.f19683h = videoTemplateContent.position_y.doubleValue();
            this.f19684i = videoTemplateContent.position_type.doubleValue();
            this.f19685j = videoTemplateContent.text_size.doubleValue();
            this.f19686k = videoTemplateContent.text_color;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "AnniversaryContentData{content='" + this.a + ExtendedMessageFormat.QUOTE + ", type=" + this.f19677b + ", picWidth=" + this.f19678c + ", picHeight=" + this.f19679d + ", startTime=" + this.f19680e + ", endTime=" + this.f19681f + ", x=" + this.f19682g + ", y=" + this.f19683h + ", positionType=" + this.f19684i + ", textSize=" + this.f19685j + ", textColor='" + this.f19686k + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
