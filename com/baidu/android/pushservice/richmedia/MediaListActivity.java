package com.baidu.android.pushservice.richmedia;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RemoteViews;
import com.baidu.android.common.logging.Log;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class MediaListActivity extends Activity {
    private static String r = "downloadUrl";

    /* renamed from: a  reason: collision with root package name */
    ArrayList f623a;
    NotificationManager b;
    private ListView c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private RemoteViews m;
    private int n;
    private int o;
    private int p;
    private int q;
    private LinearLayout l = null;
    private AdapterView.OnItemClickListener s = new d(this);
    private AdapterView.OnItemLongClickListener t = new e(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        Uri parse = Uri.parse(str);
        String path = parse.getPath();
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/baidu/pushservice/files/" + parse.getAuthority() + "/" + path.substring(0, path.lastIndexOf(47)));
        if (com.baidu.android.pushservice.b.a()) {
            Log.d("MediaListActivity", "<<< download url " + parse.toString());
        }
        n a2 = p.a(o.REQ_TYPE_GET_ZIP, parse.toString());
        a2.b = file.getAbsolutePath();
        a2.c = str2;
        a2.d = str3;
        new b(this, new h(this)).execute(a2);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = getResources().getIdentifier("bpush_media_list", "layout", getPackageName());
        requestWindowFeature(1);
        if (this.d != 0) {
            setContentView(this.d);
            Resources resources = getResources();
            String packageName = getPackageName();
            this.e = resources.getIdentifier("bpush_media_list_item", "layout", packageName);
            this.f = resources.getIdentifier("bpush_type_listview", LocaleUtil.INDONESIAN, packageName);
            this.g = resources.getIdentifier("bpush_media_list_img", LocaleUtil.INDONESIAN, packageName);
            this.h = resources.getIdentifier("bpush_media_list_title", LocaleUtil.INDONESIAN, packageName);
            this.i = resources.getIdentifier("bpush_media_list_from_text", LocaleUtil.INDONESIAN, packageName);
            this.j = resources.getIdentifier("bpush_media_list_time_text", LocaleUtil.INDONESIAN, packageName);
            this.k = resources.getIdentifier("bpush_media_none_layout", LocaleUtil.INDONESIAN, packageName);
            this.l = (LinearLayout) findViewById(this.k);
            this.c = (ListView) findViewById(this.f);
            Button button = (Button) findViewById(resources.getIdentifier("bpush_media_list_return_btn", LocaleUtil.INDONESIAN, packageName));
            button.setClickable(true);
            button.setOnClickListener(new c(this));
            int identifier = getResources().getIdentifier("bpush_download_progress", "layout", getPackageName());
            if (identifier != 0) {
                this.m = new RemoteViews(getPackageName(), identifier);
                this.n = getResources().getIdentifier("bpush_downLoad_progress", LocaleUtil.INDONESIAN, getPackageName());
                this.o = getResources().getIdentifier("bpush_progress_percent", LocaleUtil.INDONESIAN, getPackageName());
                this.p = getResources().getIdentifier("bpush_progress_text", LocaleUtil.INDONESIAN, getPackageName());
                this.q = getResources().getIdentifier("bpush_downLoad_icon", LocaleUtil.INDONESIAN, getPackageName());
            }
            this.c.setOnItemClickListener(this.s);
            this.c.setDividerHeight(0);
            this.c.setOnItemLongClickListener(this.t);
        }
        this.b = (NotificationManager) getSystemService("notification");
    }

    @Override // android.app.Activity
    public void onResume() {
        int i = 0;
        super.onResume();
        if (this.d == 0) {
            return;
        }
        String[] strArr = {"img", "title", "fromtext", "timetext"};
        this.f623a = new ArrayList();
        List b = com.baidu.android.pushservice.util.e.b(com.baidu.android.pushservice.util.e.a(this));
        if (b.isEmpty()) {
            this.l.setVisibility(0);
            this.c.setVisibility(8);
            return;
        }
        this.l.setVisibility(8);
        this.c.setVisibility(0);
        this.c.setItemsCanFocus(true);
        PackageManager packageManager = getPackageManager();
        while (true) {
            int i2 = i;
            if (i2 >= b.size()) {
                this.c.setAdapter((ListAdapter) new i(this, this, this.f623a));
                return;
            }
            HashMap hashMap = new HashMap();
            try {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(((com.baidu.android.pushservice.util.i) b.get(i2)).f651a, 0);
                hashMap.put(strArr[0], packageManager.getApplicationIcon(applicationInfo));
                hashMap.put(strArr[1], ((com.baidu.android.pushservice.util.i) b.get(i2)).c);
                hashMap.put(strArr[2], "来自：" + ((Object) packageManager.getApplicationLabel(applicationInfo)));
                hashMap.put(strArr[3], com.baidu.android.pushservice.util.n.a(((com.baidu.android.pushservice.util.i) b.get(i2)).j));
                hashMap.put(r, ((com.baidu.android.pushservice.util.i) b.get(i2)).b);
                this.f623a.add(hashMap);
            } catch (PackageManager.NameNotFoundException e) {
                Log.w("MediaListActivity", "Media item package NOT found: " + ((com.baidu.android.pushservice.util.i) b.get(i2)).f651a);
            }
            i = i2 + 1;
        }
    }
}
