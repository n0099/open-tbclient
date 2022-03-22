package c.a.v.g;

import com.baidu.searchbox.live.interfaces.net.NetResponse;
/* loaded from: classes3.dex */
public interface a<T> {
    void onNetResponse(NetResponse netResponse, T t);

    T onParseResponseInBackground(NetResponse netResponse);
}
