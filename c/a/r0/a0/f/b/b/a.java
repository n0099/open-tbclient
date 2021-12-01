package c.a.r0.a0.f.b.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.LiveSquare.HotLiveWithCategory;
import tbclient.ThreadInfo;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f13871b;

    /* renamed from: c  reason: collision with root package name */
    public String f13872c;

    /* renamed from: d  reason: collision with root package name */
    public String f13873d;

    /* renamed from: e  reason: collision with root package name */
    public List<ThreadInfo> f13874e;

    /* renamed from: f  reason: collision with root package name */
    public int f13875f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f13876g;

    public a(HotLiveWithCategory hotLiveWithCategory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hotLiveWithCategory};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = hotLiveWithCategory.tab_id.intValue();
        this.f13871b = hotLiveWithCategory.entry_name;
        this.f13872c = hotLiveWithCategory.label_name;
        this.f13873d = hotLiveWithCategory.bitmap_wh_ratio;
        this.f13874e = new ArrayList(hotLiveWithCategory.live);
        this.f13875f = hotLiveWithCategory.live_tab_type.intValue();
        this.f13876g = hotLiveWithCategory.sub_type_list;
    }
}
