package com.baidu.searchbox.http.interceptor;

import com.baidu.searchbox.http.request.HttpRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes2.dex */
public class ConnReuseProbeInterceptor implements Interceptor {
    private static final boolean DEBUG = false;
    private static final int MAX_RECORD_CONNECTION = 10;
    private static final String TAG = "ConnReuseProbeInterceptor";
    private HashMap<String, ArrayList<Integer>> hostAndConnections = new HashMap<>(10);

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        HttpRequest httpRequest;
        Request request = chain.request();
        Connection connection = chain.connection();
        Object tag = request.tag();
        if (!(tag instanceof HttpRequest)) {
            httpRequest = null;
        } else {
            httpRequest = (HttpRequest) tag;
        }
        boolean isConnReused = isConnReused(connection, request);
        if (httpRequest != null) {
            httpRequest.isConnReused = isConnReused;
        }
        return chain.proceed(request);
    }

    private synchronized boolean isConnReused(Connection connection, Request request) {
        ArrayList<Integer> arrayList;
        boolean isReused;
        if (request == null) {
            isReused = false;
        } else {
            request.url().toString();
            String host = request.url().host();
            ArrayList<Integer> arrayList2 = this.hostAndConnections.get(host);
            if (arrayList2 == null) {
                ArrayList<Integer> arrayList3 = new ArrayList<>(10);
                this.hostAndConnections.put(host, arrayList3);
                arrayList = arrayList3;
            } else {
                arrayList = arrayList2;
            }
            isReused = isReused(arrayList, Integer.valueOf(connection == null ? -1 : connection.hashCode()).intValue());
        }
        return isReused;
    }

    private boolean isReused(ArrayList<Integer> arrayList, int i) {
        boolean z;
        if (arrayList == null) {
            return false;
        }
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                z = false;
                break;
            } else if (arrayList.get(size).intValue() != i) {
                size--;
            } else {
                arrayList.remove(size);
                z = true;
                break;
            }
        }
        arrayList.add(Integer.valueOf(i));
        if (arrayList.size() > 10) {
            arrayList.remove(0);
        }
        return z;
    }
}
