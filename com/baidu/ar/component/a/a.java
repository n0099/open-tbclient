package com.baidu.ar.component.a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;
import com.baidu.ar.b;
import com.baidu.ar.load.util.ResponseUtil;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.statistic.StatisticHelper;
import com.baidu.ar.task.HttpResponseListener;
import com.baidu.ar.ui.g;
import com.baidu.ar.util.Res;
import com.baidu.ar.util.UiThreadUtil;
import com.baidu.ar.util.UiUtils;
import com.baidu.baiduarsdk.util.MsgParamsUtil;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private b a;
    private Context b;
    private Dialog c;

    public a(Context context, b bVar) {
        this.a = bVar;
        this.b = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        try {
            if (ResponseUtil.getIdFromResponse(str) == 0) {
                JSONObject httpJsonResultFromResponse = ResponseUtil.getHttpJsonResultFromResponse(str);
                if (httpJsonResultFromResponse.getInt("errno") == 0) {
                    final String string = httpJsonResultFromResponse.getJSONObject("data").getString("url");
                    UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.component.a.a.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.a != null) {
                                a.this.a.a().executeCommandWithO2O(a.this.b, string);
                                StatisticHelper.getInstance().statisticInfo(StatisticConstants.OPEN_URL, string);
                                a.this.a.h().quit();
                            }
                        }
                    });
                } else {
                    c();
                }
            } else {
                c();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.baidu.ar.b.a.a(this.b).a(1, new HttpResponseListener() { // from class: com.baidu.ar.component.a.a.2
            @Override // com.baidu.ar.task.HttpResponseListener
            public void onErrorResponse(String str) {
                if (a.this.a != null) {
                    a.this.a.h().getHostUI().hideLoadingView();
                }
                a.this.c();
            }

            @Override // com.baidu.ar.task.HttpResponseListener
            public void onResponse(Object obj) {
                if (a.this.a != null) {
                    a.this.a.h().getHostUI().hideLoadingView();
                }
                a.this.a((String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.component.a.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.a != null) {
                    FragmentActivity activity = a.this.a.h().getActivity();
                    if (activity == null) {
                        return;
                    }
                    a.this.c = g.e(activity, new DialogInterface.OnClickListener() { // from class: com.baidu.ar.component.a.a.4.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            a.this.b();
                        }
                    }, new DialogInterface.OnClickListener() { // from class: com.baidu.ar.component.a.a.4.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (a.this.a != null) {
                                a.this.a.h().quit();
                            }
                        }
                    });
                }
                UiUtils.showDialogSafely(a.this.c);
            }
        });
    }

    public void a() {
        this.c = null;
        this.a = null;
    }

    public void a(String str, String str2, Object obj) {
        if (this.a != null) {
            this.a.h().getHostUI().showLoadingView(Res.getString("bdar_marketing_connecting"));
        }
        com.baidu.ar.b.a.a(this.b).a(str, str2, obj);
        b();
    }

    public void a(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            switch (MsgParamsUtil.obj2Int(hashMap.get("id"), -1)) {
                case 10301:
                    UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.component.a.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.a != null) {
                                a.this.a.h().quit();
                            }
                        }
                    });
                    return;
                case 10401:
                    a((String) hashMap.get("url"), (String) hashMap.get("activity_id"), new JSONObject((HashMap) hashMap.get("extra_data")));
                    return;
                default:
                    return;
            }
        }
    }
}
