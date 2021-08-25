package c.a.w.e.d;

import com.baidu.searchbox.live.interfaces.net.NetResponse;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public interface a<T> {
    void a(NetResponse netResponse, T t, Map<String, String> map, List<String> list);

    T onParseResponseInBackground(NetResponse netResponse);
}
