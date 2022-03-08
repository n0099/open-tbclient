package c.a.b0.w;

import androidx.annotation.NonNull;
import com.baidu.nadcore.requester.NadRequester;
import com.baidu.nadcore.requester.RequestParameters;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes.dex */
public interface c {
    public static final ServiceReference a = new ServiceReference("nad.core", "adRequester");

    void a(@NonNull RequestParameters requestParameters, @NonNull NadRequester.b bVar);
}
