package c.a.o0.s.q;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.PbPage.NewsInfo;
/* loaded from: classes3.dex */
public class e1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f13898a;

    /* renamed from: b  reason: collision with root package name */
    public String f13899b;

    /* renamed from: c  reason: collision with root package name */
    public int f13900c;

    /* renamed from: d  reason: collision with root package name */
    public String f13901d;

    /* renamed from: e  reason: collision with root package name */
    public String f13902e;

    /* renamed from: f  reason: collision with root package name */
    public String f13903f;

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
        this.f13898a = newsInfo.news_link;
        this.f13899b = newsInfo.summary;
        newsInfo.position.intValue();
        this.f13900c = newsInfo.news_type.intValue();
        this.f13901d = newsInfo.news_icon;
        this.f13902e = newsInfo.subtitle;
        this.f13903f = newsInfo.button_text;
    }
}
