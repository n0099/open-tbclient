package com.baidu.live.alablmsdk.c;

import com.baidu.live.alablmsdk.module.rtc.BLMStreamState;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public interface b {
    void a(com.baidu.live.alablmsdk.module.rtc.a aVar, int i);

    void a(com.baidu.live.alablmsdk.module.rtc.a aVar, BLMStreamState bLMStreamState);

    void a(String str, com.baidu.live.alablmsdk.module.c cVar);

    void a(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject);

    void b(String str, com.baidu.live.alablmsdk.module.c cVar);

    void b(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject);

    void c(String str, com.baidu.live.alablmsdk.module.c cVar);

    void c(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject);

    void d(String str, com.baidu.live.alablmsdk.module.c cVar);

    void d(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject);

    void e(String str, com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject);

    void fX(String str);

    void onLogReport(String str, JSONObject jSONObject, JSONObject jSONObject2);
}
