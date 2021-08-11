package c.a.v.f;

import com.baidu.searchbox.live.interfaces.net.NetResponse;
/* loaded from: classes4.dex */
public interface a<T> {
    void onNetResponse(NetResponse netResponse, T t);

    T onParseResponseInBackground(NetResponse netResponse);
}
