package b.a.r0.w.f.b.b;

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

    /* renamed from: a  reason: collision with root package name */
    public int f24527a;

    /* renamed from: b  reason: collision with root package name */
    public String f24528b;

    /* renamed from: c  reason: collision with root package name */
    public String f24529c;

    /* renamed from: d  reason: collision with root package name */
    public String f24530d;

    /* renamed from: e  reason: collision with root package name */
    public List<ThreadInfo> f24531e;

    /* renamed from: f  reason: collision with root package name */
    public int f24532f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f24533g;

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
        this.f24527a = hotLiveWithCategory.tab_id.intValue();
        this.f24528b = hotLiveWithCategory.entry_name;
        this.f24529c = hotLiveWithCategory.label_name;
        this.f24530d = hotLiveWithCategory.bitmap_wh_ratio;
        this.f24531e = new ArrayList(hotLiveWithCategory.live);
        this.f24532f = hotLiveWithCategory.live_tab_type.intValue();
        this.f24533g = hotLiveWithCategory.sub_type_list;
    }
}
