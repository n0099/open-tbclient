package b.a.w.f;

import com.baidu.searchbox.live.interfaces.net.NetResponse;
/* loaded from: classes6.dex */
public interface a<T> {
    void onNetResponse(NetResponse netResponse, T t);

    T onParseResponseInBackground(NetResponse netResponse);
}
