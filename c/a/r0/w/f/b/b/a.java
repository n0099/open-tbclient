package c.a.r0.w.f.b.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.LiveSquare.HotLiveWithCategory;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f25678a;

    /* renamed from: b  reason: collision with root package name */
    public String f25679b;

    /* renamed from: c  reason: collision with root package name */
    public String f25680c;

    /* renamed from: d  reason: collision with root package name */
    public String f25681d;

    /* renamed from: e  reason: collision with root package name */
    public List<ThreadInfo> f25682e;

    /* renamed from: f  reason: collision with root package name */
    public int f25683f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f25684g;

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
        this.f25678a = hotLiveWithCategory.tab_id.intValue();
        this.f25679b = hotLiveWithCategory.entry_name;
        this.f25680c = hotLiveWithCategory.label_name;
        this.f25681d = hotLiveWithCategory.bitmap_wh_ratio;
        this.f25682e = new ArrayList(hotLiveWithCategory.live);
        this.f25683f = hotLiveWithCategory.live_tab_type.intValue();
        this.f25684g = hotLiveWithCategory.sub_type_list;
    }
}
