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
import com.baidu.adp.R;
import com.baidu.adp.lib.debug.service.DebugService;
import com.baidu.adp.lib.debug.service.SwitchDebugService;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class c extends View {
    private static boolean hj = false;
    private static String hl = com.baidu.adp.framework.client.socket.l.getUrl();
    ArrayList<HashMap<String, Object>> gU;
    String[] gV;
    String[] gW;
    private ImageButton gX;
    private LinearLayout gY;
    private LinearLayout gZ;
    private LinearLayout ha;
    private LinearLayout hb;
    private TextView hc;
    private TextView hd;
    private Dialog hf;
    private ListView hg;
    private LinearLayout hh;
    private TextView hi;
    private LinearLayout hk;
    private final Context mContext;

    public c(Activity activity) {
        super(activity);
        this.gU = null;
        this.gV = new String[]{"当前地址", "线上", "沙盒W", "沙盒C", "QA测试机", "RD测试机", "线上client机器"};
        this.gW = new String[]{"current server", "http://c.tieba.baidu.com", "http://ai-forum-shahew.ai01.baidu.com:", "http://ai-forum-shahec.ai01.baidu.com:", "http://cq01-testing-forum56.vm.baidu.com:8666", "http://cq01-forum-rdtest00.vm.baidu.com:8666", "http://ai-forum-client01.ai01.baidu.com:8090"};
        this.mContext = activity;
        onCreate();
    }

    public void onCreate() {
        ((Activity) this.mContext).setContentView(R.layout.adp_debug_config_activity);
        this.gX = (ImageButton) ((Activity) this.mContext).findViewById(R.id.close_debug);
        this.gY = (LinearLayout) ((Activity) this.mContext).findViewById(R.id.switch_monitor_item);
        this.hc = (TextView) this.gY.findViewById(R.id.switch_monitor);
        this.gZ = (LinearLayout) ((Activity) this.mContext).findViewById(R.id.switch_capture_package_item);
        this.hd = (TextView) this.gZ.findViewById(R.id.switch_capture_package);
        this.ha = (LinearLayout) ((Activity) this.mContext).findViewById(R.id.debug_close_item);
        this.hc.setText(com.baidu.adp.lib.debug.d.gi ? "开" : "关");
        this.hd.setText(com.baidu.adp.lib.debug.d.gj ? "开" : "关");
        this.gX.setOnClickListener(new d(this));
        this.gY.setOnClickListener(new e(this));
        this.gZ.setOnClickListener(new f(this));
        this.ha.setOnClickListener(new g(this));
        this.hg = (ListView) ((Activity) this.mContext).findViewById(R.id.adp_debug_custom_configs_list);
        this.hg.setAdapter((ListAdapter) new b(this.mContext));
        this.hb = (LinearLayout) ((Activity) this.mContext).findViewById(R.id.debug_update_package_item);
        this.hb.setOnClickListener(new i(this));
        this.hh = (LinearLayout) ((Activity) this.mContext).findViewById(R.id.switch_lcs_switch_item);
        this.hi = (TextView) this.hh.findViewById(R.id.switch_lcs_switch);
        this.hi.setText(((Activity) this.mContext).getText(hj ? R.string.item_close : R.string.item_open));
        this.hh.setOnClickListener(new j(this));
        this.hk = (LinearLayout) ((Activity) this.mContext).findViewById(R.id.switch_lcs_reOnline_item);
        ((EditText) ((Activity) this.mContext).findViewById(R.id.switch_lcs_reOnline_lcs_address)).setHint(hl);
        this.hk.setOnClickListener(new k(this));
    }

    public void cT() {
        this.mContext.startService(new Intent(this.mContext, DebugService.class));
    }

    public void cU() {
        this.mContext.stopService(new Intent(this.mContext, DebugService.class));
    }

    public void cV() {
        cU();
        Intent intent = new Intent(this.mContext, SwitchDebugService.class);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.STOP, true);
        this.mContext.startService(intent);
    }
}
