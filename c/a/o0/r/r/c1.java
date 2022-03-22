package c.a.o0.r.r;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.PbPage.NewsInfo;
/* loaded from: classes2.dex */
public class c1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f10824b;

    /* renamed from: c  reason: collision with root package name */
    public int f10825c;

    /* renamed from: d  reason: collision with root package name */
    public String f10826d;

    /* renamed from: e  reason: collision with root package name */
    public String f10827e;

    /* renamed from: f  reason: collision with root package name */
    public String f10828f;

    public c1() {
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

    public void a(NewsInfo newsInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, newsInfo) == null) || newsInfo == null) {
            return;
        }
        this.a = newsInfo.news_link;
        this.f10824b = newsInfo.summary;
        newsInfo.position.intValue();
        this.f10825c = newsInfo.news_type.intValue();
        this.f10826d = newsInfo.news_icon;
        this.f10827e = newsInfo.subtitle;
        this.f10828f = newsInfo.button_text;
    }
}
