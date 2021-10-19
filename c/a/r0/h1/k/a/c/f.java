package c.a.r0.h1.k.a.c;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TimeLineInfo;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f18685a;

    /* renamed from: b  reason: collision with root package name */
    public List<e> f18686b;

    public f() {
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

    public void a(long j2, TimeLine timeLine) {
        Long l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(1048576, this, j2, timeLine) == null) || timeLine == null || ListUtils.isEmpty(timeLine.timeline_info)) {
            return;
        }
        this.f18685a = timeLine.title;
        this.f18686b = new ArrayList();
        int i2 = 0;
        for (TimeLineInfo timeLineInfo : timeLine.timeline_info) {
            if (timeLineInfo != null && (((l = timeLineInfo.tid) != null && l.longValue() != 0) || !TextUtils.isEmpty(timeLineInfo.title) || !TextUtils.isEmpty(timeLineInfo.bg_color) || !TextUtils.isEmpty(timeLineInfo.show_time) || !TextUtils.isEmpty(timeLineInfo.small_title))) {
                e eVar = new e();
                eVar.f18679a = j2;
                eVar.f18684f = i2;
                eVar.a(timeLineInfo);
                this.f18686b.add(eVar);
                i2++;
            }
        }
    }
}
