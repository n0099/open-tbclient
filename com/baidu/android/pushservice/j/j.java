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
        ArrayList<com.baidu.android.pushservice.h.i> arrayList = new ArrayList();
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
        com.baidu.android.pushservice.h.i iVar = new com.baidu.android.pushservice.h.i();
        iVar.d = "030804";
        iVar.b = stringExtra;
        iVar.c = j + "";
        iVar.f = "100%";
        iVar.i = j + "";
        iVar.e = System.currentTimeMillis();
        arrayList.add(iVar);
        for (Map.Entry entry : hashMap.entrySet()) {
            com.baidu.android.pushservice.h.i iVar2 = new com.baidu.android.pushservice.h.i();
            iVar2.d = (String) entry.getKey();
            iVar2.b = stringExtra;
            iVar2.c = j + "";
            iVar2.i = entry.getValue() + "";
            iVar2.f = new DecimalFormat("#.##").format((((Long) entry.getValue()).longValue() / j) * 100.0d) + "%";
            iVar2.e = System.currentTimeMillis();
            arrayList.add(iVar2);
        }
        for (com.baidu.android.pushservice.h.i iVar3 : arrayList) {
            com.baidu.android.pushservice.h.q.a(context, iVar3);
        }
    }
}
