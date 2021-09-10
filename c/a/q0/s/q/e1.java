package c.a.q0.s.q;

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
    public String f14155a;

    /* renamed from: b  reason: collision with root package name */
    public String f14156b;

    /* renamed from: c  reason: collision with root package name */
    public int f14157c;

    /* renamed from: d  reason: collision with root package name */
    public String f14158d;

    /* renamed from: e  reason: collision with root package name */
    public String f14159e;

    /* renamed from: f  reason: collision with root package name */
    public String f14160f;

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
        this.f14155a = newsInfo.news_link;
        this.f14156b = newsInfo.summary;
        newsInfo.position.intValue();
        this.f14157c = newsInfo.news_type.intValue();
        this.f14158d = newsInfo.news_icon;
        this.f14159e = newsInfo.subtitle;
        this.f14160f = newsInfo.button_text;
    }
}
