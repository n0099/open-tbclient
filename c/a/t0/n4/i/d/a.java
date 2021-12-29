package c.a.t0.n4.i.d;

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
    public int f20415b;

    /* renamed from: c  reason: collision with root package name */
    public int f20416c;

    /* renamed from: d  reason: collision with root package name */
    public int f20417d;

    /* renamed from: e  reason: collision with root package name */
    public long f20418e;

    /* renamed from: f  reason: collision with root package name */
    public long f20419f;

    /* renamed from: g  reason: collision with root package name */
    public double f20420g;

    /* renamed from: h  reason: collision with root package name */
    public double f20421h;

    /* renamed from: i  reason: collision with root package name */
    public double f20422i;

    /* renamed from: j  reason: collision with root package name */
    public double f20423j;

    /* renamed from: k  reason: collision with root package name */
    public String f20424k;

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
            this.f20415b = videoTemplateContent.type.intValue();
            this.f20416c = videoTemplateContent.pic_width.intValue();
            this.f20417d = videoTemplateContent.pic_height.intValue();
            this.f20418e = videoTemplateContent.start_time.longValue();
            this.f20419f = videoTemplateContent.end_time.longValue();
            this.f20420g = videoTemplateContent.position_x.doubleValue();
            this.f20421h = videoTemplateContent.position_y.doubleValue();
            this.f20422i = videoTemplateContent.position_type.doubleValue();
            this.f20423j = videoTemplateContent.text_size.doubleValue();
            this.f20424k = videoTemplateContent.text_color;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "AnniversaryContentData{content='" + this.a + ExtendedMessageFormat.QUOTE + ", type=" + this.f20415b + ", picWidth=" + this.f20416c + ", picHeight=" + this.f20417d + ", startTime=" + this.f20418e + ", endTime=" + this.f20419f + ", x=" + this.f20420g + ", y=" + this.f20421h + ", positionType=" + this.f20422i + ", textSize=" + this.f20423j + ", textColor='" + this.f20424k + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
