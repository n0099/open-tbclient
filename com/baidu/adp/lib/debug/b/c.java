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
import java.util.HashMap;
/* loaded from: classes.dex */
public class c extends View {
    private static boolean p = false;
    private static String r = com.baidu.adp.framework.c.c.a().d();
    ArrayList<HashMap<String, Object>> a;
    String[] b;
    String[] c;
    private ImageButton d;
    private LinearLayout e;
    private LinearLayout f;
    private LinearLayout g;
    private LinearLayout h;
    private TextView i;
    private TextView j;
    private final Context k;
    private Dialog l;
    private ListView m;
    private LinearLayout n;
    private TextView o;
    private LinearLayout q;

    public c(Activity activity) {
        super(activity);
        this.a = null;
        this.b = new String[]{"当前地址", "线上", "沙盒W", "沙盒C", "QA测试机", "RD测试机", "线上client机器"};
        this.c = new String[]{"current server", "http://c.tieba.baidu.com", "http://ai-forum-shahew.ai01.baidu.com:", "http://ai-forum-shahec.ai01.baidu.com:", "http://cq01-testing-forum56.vm.baidu.com:8666", "http://cq01-forum-rdtest00.vm.baidu.com:8666", "http://ai-forum-client01.ai01.baidu.com:8090"};
        this.k = activity;
        a();
    }

    public void a() {
        ((Activity) this.k).setContentView(com.baidu.adp.e.adp_debug_config_activity);
        this.d = (ImageButton) ((Activity) this.k).findViewById(com.baidu.adp.d.close_debug);
        this.e = (LinearLayout) ((Activity) this.k).findViewById(com.baidu.adp.d.switch_monitor_item);
        this.i = (TextView) this.e.findViewById(com.baidu.adp.d.switch_monitor);
        this.f = (LinearLayout) ((Activity) this.k).findViewById(com.baidu.adp.d.switch_capture_package_item);
        this.j = (TextView) this.f.findViewById(com.baidu.adp.d.switch_capture_package);
        this.g = (LinearLayout) ((Activity) this.k).findViewById(com.baidu.adp.d.debug_close_item);
        this.i.setText(com.baidu.adp.lib.debug.d.d ? "开" : "关");
        this.j.setText(com.baidu.adp.lib.debug.d.e ? "开" : "关");
        this.d.setOnClickListener(new d(this));
        this.e.setOnClickListener(new e(this));
        this.f.setOnClickListener(new f(this));
        this.g.setOnClickListener(new g(this));
        this.m = (ListView) ((Activity) this.k).findViewById(com.baidu.adp.d.adp_debug_custom_configs_list);
        this.m.setAdapter((ListAdapter) new b(this.k));
        this.h = (LinearLayout) ((Activity) this.k).findViewById(com.baidu.adp.d.debug_update_package_item);
        this.h.setOnClickListener(new i(this));
        this.n = (LinearLayout) ((Activity) this.k).findViewById(com.baidu.adp.d.switch_lcs_switch_item);
        this.o = (TextView) this.n.findViewById(com.baidu.adp.d.switch_lcs_switch);
        this.o.setText(((Activity) this.k).getText(p ? com.baidu.adp.f.item_close : com.baidu.adp.f.item_open));
        this.n.setOnClickListener(new j(this));
        this.q = (LinearLayout) ((Activity) this.k).findViewById(com.baidu.adp.d.switch_lcs_reOnline_item);
        ((EditText) ((Activity) this.k).findViewById(com.baidu.adp.d.switch_lcs_reOnline_lcs_address)).setHint(r);
        this.q.setOnClickListener(new k(this));
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
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.STOP, true);
        this.k.startService(intent);
    }
}
