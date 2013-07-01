package com.baidu.adp.lib.debug.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.lib.debug.service.DebugService;
import com.baidu.adp.lib.debug.service.SwitchDebugService;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c extends View {

    /* renamed from: a  reason: collision with root package name */
    ArrayList f155a;
    String[] b;
    String[] c;
    private EditText d;
    private String e;
    private ImageButton f;
    private LinearLayout g;
    private LinearLayout h;
    private LinearLayout i;
    private TextView j;
    private Context k;
    private Dialog l;
    private ListView m;

    public c(Activity activity) {
        super(activity);
        this.d = null;
        this.e = null;
        this.f155a = null;
        this.b = new String[]{"当前地址", "线上", "沙盒W", "沙盒C", "QA测试机", "RD测试机", "线上client机器"};
        this.c = new String[]{"current server", "http://c.tieba.baidu.com", "http://ai-forum-shahew.ai01.baidu.com:", "http://ai-forum-shahec.ai01.baidu.com:", "http://cq01-testing-forum56.vm.baidu.com:8666", "http://cq01-forum-rdtest00.vm.baidu.com:8666", "http://ai-forum-client01.ai01.baidu.com:8090"};
        this.k = activity;
        a();
    }

    public void a() {
        ((Activity) this.k).setContentView(com.baidu.adp.f.adp_debug_config_activity);
        this.f = (ImageButton) ((Activity) this.k).findViewById(com.baidu.adp.e.close_debug);
        this.g = (LinearLayout) ((Activity) this.k).findViewById(com.baidu.adp.e.switch_monitor_item);
        this.j = (TextView) this.g.findViewById(com.baidu.adp.e.switch_monitor);
        this.h = (LinearLayout) ((Activity) this.k).findViewById(com.baidu.adp.e.debug_close_item);
        if (com.baidu.adp.lib.debug.b.d) {
            this.j.setText("开");
        } else {
            this.j.setText("关");
        }
        this.f.setOnClickListener(new d(this));
        this.g.setOnClickListener(new e(this));
        this.h.setOnClickListener(new f(this));
        this.m = (ListView) ((Activity) this.k).findViewById(com.baidu.adp.e.adp_debug_custom_configs_list);
        this.m.setAdapter((ListAdapter) new b(this.k));
        this.i = (LinearLayout) ((Activity) this.k).findViewById(com.baidu.adp.e.debug_update_package_item);
        this.i.setOnClickListener(new h(this));
    }

    public void b() {
        this.k.startService(new Intent(this.k, DebugService.class));
    }

    public void c() {
        this.k.stopService(new Intent(this.k, DebugService.class));
    }

    public void d() {
        c();
        Intent intent = new Intent(this.k, SwitchDebugService.class);
        intent.putExtra("stop", true);
        this.k.startService(intent);
    }
}
