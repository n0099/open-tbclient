package com.baidu.android.pushservice.j;

import android.content.Context;
import android.content.Intent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class j {
    public static void a(Context context, Intent intent, Intent intent2) {
        long j;
        String stringExtra = intent.getStringExtra("message_id");
        ArrayList<com.baidu.android.pushservice.h.h> arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        if (intent2 != null) {
            long longExtra = intent.getLongExtra("bd.message.rate.GET", 0L);
            long longExtra2 = intent.getLongExtra("bd.message.rate.REDIRECTION", 0L);
            long longExtra3 = intent2.getLongExtra("bd.message.rate.BACK", 0L);
            long longExtra4 = intent2.getLongExtra("bd.message.rate.END", 0L);
            hashMap.put("030801", Long.valueOf(longExtra2 - longExtra));
            hashMap.put("030802", Long.valueOf(longExtra3 - longExtra2));
            hashMap.put("030803", Long.valueOf(longExtra4 - longExtra3));
            j = longExtra4 - longExtra;
        } else {
            long longExtra5 = intent.getLongExtra("bd.message.rate.GET", 0L);
            long longExtra6 = intent.getLongExtra("bd.message.rate.REDIRECTION", 0L);
            long longExtra7 = intent.getLongExtra("bd.message.rate.TIMEOUT", 0L);
            long j2 = longExtra7 - longExtra5;
            hashMap.put("030801", Long.valueOf(longExtra6 - longExtra5));
            hashMap.put("030803", Long.valueOf(longExtra7 - longExtra6));
            hashMap.put("030805", Long.valueOf(j2));
            j = j2;
        }
        com.baidu.android.pushservice.h.h hVar = new com.baidu.android.pushservice.h.h();
        hVar.d = "030804";
        hVar.b = stringExtra;
        hVar.c = j + "";
        hVar.f = "100%";
        hVar.i = j + "";
        hVar.e = System.currentTimeMillis();
        arrayList.add(hVar);
        for (Map.Entry entry : hashMap.entrySet()) {
            com.baidu.android.pushservice.h.h hVar2 = new com.baidu.android.pushservice.h.h();
            hVar2.d = (String) entry.getKey();
            hVar2.b = stringExtra;
            hVar2.c = j + "";
            hVar2.i = entry.getValue() + "";
            hVar2.f = new DecimalFormat("#.##").format((((Long) entry.getValue()).longValue() / j) * 100.0d) + "%";
            hVar2.e = System.currentTimeMillis();
            arrayList.add(hVar2);
        }
        for (com.baidu.android.pushservice.h.h hVar3 : arrayList) {
            com.baidu.android.pushservice.h.p.a(context, hVar3);
        }
    }
}
