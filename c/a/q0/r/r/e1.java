package c.a.q0.r.r;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.PbPage.NewsInfo;
/* loaded from: classes2.dex */
public class e1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f13246b;

    /* renamed from: c  reason: collision with root package name */
    public int f13247c;

    /* renamed from: d  reason: collision with root package name */
    public String f13248d;

    /* renamed from: e  reason: collision with root package name */
    public String f13249e;

    /* renamed from: f  reason: collision with root package name */
    public String f13250f;

    public e1() {
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

    public void a(NewsInfo newsInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, newsInfo) == null) || newsInfo == null) {
            return;
        }
        this.a = newsInfo.news_link;
        this.f13246b = newsInfo.summary;
        newsInfo.position.intValue();
        this.f13247c = newsInfo.news_type.intValue();
        this.f13248d = newsInfo.news_icon;
        this.f13249e = newsInfo.subtitle;
        this.f13250f = newsInfo.button_text;
    }
}
